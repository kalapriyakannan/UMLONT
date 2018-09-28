package com.ibm.ccl.soa.deploy.ide.refactoring.change;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.MultiRule;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.CompositeEMFOperation;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringChangeDescriptor;
import org.eclipse.ltk.core.refactoring.RefactoringDescriptor;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.RefactoringStatusEntry;
import org.eclipse.ltk.internal.core.refactoring.UndoableOperation2ChangeAdapter;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.index.ROTopologyModelManager;
import com.ibm.ccl.soa.deploy.core.index.ROTopologyModelManager.Listener;
import com.ibm.ccl.soa.deploy.ide.IDEPlugin;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.Messages;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.utils.ChangeAdapter;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.utils.RefactoringUtils;
import com.ibm.ccl.soa.infrastructure.emf.IEMFWorkbenchContext;
import com.ibm.ccl.soa.infrastructure.emf.IEMFWorkbenchContextFactory;

public class CoreCompositeChange extends CompositeChange {

	private int priority;

	private final ImportTracker imports;
	private final Map<String, String> nameChanges = new HashMap<String, String>();
	private final Map<IPath, CompositeChange> fileChanges = new HashMap<IPath, CompositeChange>();
	private final List<Change> ordering = new ArrayList<Change>();
	private RefactoringChangeDescriptor descriptor;

	public CoreCompositeChange(String name) {
		this(name, new Change[0]);
	}

	public CoreCompositeChange(String name, Change[] children) {
		super(name);
		imports = new ImportTracker();
		for (int i = 0; i < children.length; i++) {
			add(children[i]);
		}
	}

	public void setRefactoringDescriptor(RefactoringDescriptor descriptor) {
		this.descriptor = new RefactoringChangeDescriptor(descriptor);
	}

	public RefactoringChangeDescriptor getChangeDescriptor() {
		return descriptor;
	}

	public ImportTracker getImportTracker() {
		return imports;
	}

	public void generateUniqueNames(Topology topology, DeployModelObject[] dmos) {
		if (null == dmos) {
			return;
		}

		for (int i = 0; i < dmos.length; i++) {
			if (null == dmos[i]) {
				continue;
			}
			generateUniqueName(topology, dmos[i]);
		}
	}

	public String generateUniqueName(Topology topology, DeployModelObject dmo) {

		if (nameChanges.containsKey(dmo.getFullPath())) {
			return nameChanges.get(dmo.getFullPath());
		}

		String name = IConstants.PATH_SEPARATOR + dmo.getName();
		String temp = name;
		int index = 0;
		if (topology != null) {
			while (topology.resolve(name) != null && !dmo.equals(topology.resolve(name))
					|| nameChanges.values().contains(name.substring(1))) {
				name = temp + index++;
			}
		} else {
			while (nameChanges.values().contains(name.substring(1))) {
				name = temp + index++;
			}
		}

		nameChanges.put(dmo.getFullPath(), name.substring(1));
		return nameChanges.get(dmo.getFullPath());
	}

	public String getUniqueName(DeployModelObject dmo) {
		String name = nameChanges.get(dmo.getEditTopology().equals(dmo.getTopology()) ? dmo
				.getFullPath() : dmo.getFullPath().substring(
				dmo.getTopology().getQualifiedName().length() + 1));
		if (null == name) {
			name = generateUniqueName(null, dmo);
		}
		return name;
	}

	@Override
	public void add(Change change) {

		Object element = change.getModifiedElement();
		IResource resource = (IResource) adapt(element, IResource.class);

		if (null == resource) {
			Iterator<Object> iter = Arrays.asList(change.getAffectedObjects()).iterator();
			while (iter.hasNext() && null == resource) {
				resource = (IResource) adapt(iter.next(), IResource.class);
			}
		}

		if (null != resource) {
			if (IConstants.TOPOLOGYV_EXTENSION.equals(resource.getFileExtension())) {
				addDiagramChange(resource.getFullPath(), change);
			} else {
				addModelChange(resource.getFullPath(), change);
			}
		} else {
			internalAPIAdd(change);
		}
	}

	private void internalAPIAdd(Change change) {
		super.add(change);
	}

	private void addModelChange(IPath path, Change aChange) {

		recordOrder(aChange);
		cachePendingImports(aChange);
		addChangeDescriptor(aChange);
		getModelChanges(path).internalAPIAdd(aChange);
	}

	private void addDiagramChange(IPath path, Change aChange) {

		recordOrder(aChange);
		addChangeDescriptor(aChange);
		getDiagramChanges(path).internalAPIAdd(aChange);
	}

	private void recordOrder(Change change) {
		if (!ordering.contains(change)) {
			ordering.add(change);
		}
		if (change instanceof CompositeChange) {
			Change[] children = ((CompositeChange) change).getChildren();
			for (int i = 0; i < children.length; i++) {
				recordOrder(children[i]);
			}
		}
	}

	private void cachePendingImports(Change change) {
		if (change instanceof CreateImportChange) {
			CreateImportChange iChange = (CreateImportChange) change;
			imports.getImports(iChange.getImports()).add(iChange.getImported());
		} else if (change instanceof CompositeChange) {
			Change[] children = ((CompositeChange) change).getChildren();
			for (int i = 0; i < children.length; i++) {
				cachePendingImports(children[i]);
			}
		}
	}

	private void addChangeDescriptor(Change change) {
		if (change instanceof DeployRefactoringChange) {
			((DeployRefactoringChange) change).setDescriptor(getChangeDescriptor());
		} else if (change instanceof CompositeChange) {
			Change[] children = ((CompositeChange) change).getChildren();
			for (int i = 0; i < children.length; i++) {
				addChangeDescriptor(children[i]);
			}
		}
	}

	private CoreCompositeChange getModelChanges(IPath path) {
		CompositeChange change = getFileChanges(path);

		for (int i = 0; i < change.getChildren().length; i++) {
			CompositeChange aChange = (CompositeChange) change.getChildren()[i];
			if (aChange.getName().equals(Messages.MoveUnitsProcessor_Model_Change__2)) {
				return (CoreCompositeChange) aChange;
			}
		}

		CoreCompositeChange changes = new CoreCompositeChange(
				Messages.MoveUnitsProcessor_Model_Change__2);
		change.add(changes);
		return changes;
	}

	private CoreCompositeChange getDiagramChanges(IPath path) {
		CompositeChange change = getFileChanges(path);

		for (int i = 0; i < change.getChildren().length; i++) {
			CompositeChange aChange = (CompositeChange) change.getChildren()[i];
			if (aChange.getName().equals(Messages.MoveUnitsProcessor_Diagram_Change__2)) {
				return (CoreCompositeChange) aChange;
			}
		}

		CoreCompositeChange changes = new CoreCompositeChange(
				Messages.MoveUnitsProcessor_Diagram_Change__2);
		change.add(changes);
		return changes;
	}

	private CompositeChange getFileChanges(IPath path) {
		CompositeChange change = fileChanges.get(path);
		if (change == null) {
			change = new CoreCompositeChange(path.toString());
			fileChanges.put(path, change);
			super.add(change);
		}

		return change;
	}

	private Object adapt(Object adaptable, Class adapter) {
		if (null == adaptable) {
			return null;
		}
		Object adapted = null;
		if (adaptable instanceof IAdaptable) {
			adapted = ((IAdaptable) adaptable).getAdapter(adapter);
		}
		if (null == adapted) {
			adapted = Platform.getAdapterManager().getAdapter(adaptable, adapter);
		}
		return adapted;
	}

	@SuppressWarnings("unchecked")
	private List<Change> getPrioritizedChildren() {
		Change[] children = getChildren();
		for (int i = 0; i < children.length; i++) {
			Change child = children[i];
			if (child instanceof CompositeChange) {
				merge((CompositeChange) child);
				remove(child);
			}
		}

		List changes = new ArrayList();
		changes.addAll(Arrays.asList(getChildren()));
		Collections.sort(changes, new Comparator() {
			public int compare(Object a, Object b) {
				int aPriority = ordering.indexOf(a);
				int bPriority = ordering.indexOf(b);
				return aPriority < bPriority ? -1 : aPriority == bPriority ? 0 : 1;
			}
		});
		return changes;
	}

	public void merge(CompositeChange change) {

		boolean foundCompositeChange = true;
		while (foundCompositeChange) {
			foundCompositeChange = false;
			Change[] others = change.getChildren();
			for (int i = 0; i < others.length; i++) {
				Change other = others[i];
				change.remove(other);
				if (other instanceof CompositeChange) {
					merge((CompositeChange) other);
					foundCompositeChange = true;
				} else {
					internalAPIAdd(other);
				}
			}
		}
	}

	protected IStatus getStatusWithHighestSeverity(IStatus status) {
		if (!status.isMultiStatus()) {
			return status;
		}

		IStatus highest = status;
		for (int i = 0; i < status.getChildren().length; i++) {
			IStatus aStatus = status.getChildren()[i];
			if (highest.getSeverity() == aStatus.getSeverity()) {
				highest = aStatus;
				break;
			}
		}

		return highest;
	}

	private List<IResource> getAffectedResources() {
		// adapt the array of affected objects to instances of IResource
		Object[] affected = getAffectedObjects();
		final List<IResource> resources = new ArrayList<IResource>(affected.length + 2);
		for (int i = 0; i < affected.length; i++) {
			IResource resource = (IResource) adapt(affected[i], IResource.class);
			if (!resources.contains(resource)) {
				resources.add(resource);
			}
		}

		return resources;
	}

	private TransactionalEditingDomain getEditingDomain() {
		IEMFWorkbenchContext context = IEMFWorkbenchContextFactory.eINSTANCE
				.getContext(getAffectedResources().get(0).getProject());
		ResourceSet resourceSet = context.getResourceSet();
		TransactionalEditingDomain domain = TransactionalEditingDomain.Factory.INSTANCE
				.getEditingDomain(resourceSet);
		if (domain == null) {
			domain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(resourceSet);
		}

		return domain;
	}

	@Override
	public RefactoringStatus isValid(IProgressMonitor monitor) throws CoreException {
		RefactoringStatus status = super.isValid(monitor);
		if (!status.isOK()) {
			return status;
		}

		// run validate edit checks
		final List<IFile> files = new ArrayList<IFile>();
		List<IResource> resources = getAffectedResources();
		for (Iterator<IResource> iter = resources.iterator(); iter.hasNext();) {
			IResource resource = iter.next();
			if (resource.getType() == IResource.FILE) {
				IFile file = (IFile) resource;
				if (!files.contains(file)) {
					files.add(file);
				}
			}
		}

		if (files.size() > 0) {
			IStatus validate = ResourcesPlugin.getWorkspace().validateEdit(
					files.toArray(new IFile[files.size()]),
					DeployCorePlugin.getDefault().getDeployValidateEditHelper().getUIContext());
			if (!validate.isOK()) {
				RefactoringStatusEntry[] entries = RefactoringStatus.create(validate).getEntries();
				for (int i = 0; i < entries.length; i++) {
					status.addEntry(entries[i]);
				}
			}
		}

		// check resources for modified state
		for (Iterator<IResource> iter = resources.iterator(); iter.hasNext();) {
			IResource resource = iter.next();
			if (resource.getType() == IResource.FILE) {
				IFile file = (IFile) resource;
				if (RefactoringUtils.isDirty(file)) {
					status.addEntry(new RefactoringStatusEntry(RefactoringStatus.FATAL, NLS.bind(
							Messages.DeployRefactoringChange_The_affected_resource_0_conta_, file
									.getFullPath())));
				}
			}
		}

		return status;
	}

	@Override
	@SuppressWarnings("restriction")
	public Change perform(IProgressMonitor monitor) throws CoreException {

		if (null == monitor) {
			monitor = new NullProgressMonitor();
		}

		List<Change> changes = getPrioritizedChildren();
		monitor.beginTask(getName(), changes.size() + 3);
		Change undo = null;

		DeployRefactoringChange change = null;

		try {

			// adapt child changes of this composite change to instances of IUndoableOperations
			final List<IUndoableOperation> operations = new ArrayList<IUndoableOperation>();
			for (Iterator<Change> iter = changes.iterator(); iter.hasNext();) {
				Change aChange = iter.next();
				IUndoableOperation adapted = (IUndoableOperation) adapt(aChange,
						IUndoableOperation.class);
				if (null == adapted) {
					adapted = new UndoableOperation2ChangeAdapter(aChange);
				}
				operations.add(adapted);
			}

			Map<Object, Object> options = new HashMap<Object, Object>();
			options.put(Transaction.OPTION_NO_TRIGGERS, Boolean.TRUE);
			final CompositeEMFOperation operation = new CompositeEMFOperation(getEditingDomain(),
					getName(), options);
			operation.setTransactionNestingEnabled(false);

			// add change operations
			for (Iterator<IUndoableOperation> iter = operations.iterator(); iter.hasNext();) {
				IUndoableOperation next = iter.next();
				operation.add(next);
			}

			final MultiStatus status = new MultiStatus(IDEPlugin.PLUGIN_ID, 0, new String(), null);

			List<IResource> resources = getAffectedResources();
			ResourcesPlugin.getWorkspace().run(
					new IWorkspaceRunnable() {

						public void run(IProgressMonitor monitor) throws CoreException {
							try {
								status.add(operation.execute(monitor, null));
							} catch (ExecutionException ex) {
								throw new CoreException(new Status(IStatus.ERROR, IDEPlugin.PLUGIN_ID, ex
										.toString(), ex));
							}
						}

					}, new MultiRule(resources.toArray(new ISchedulingRule[resources.size()])),
					IWorkspace.AVOID_UPDATE, new SubProgressMonitor(monitor, changes.size()));

			if (!status.isOK()) {
				throw new CoreException(getStatusWithHighestSeverity(status));
			}

			undo = new ChangeAdapter(operation, resources.toArray(new IResource[resources.size()]),
					ChangeAdapter.Operation.UNDO);

			monitor.worked(1);

		} finally {
			if (null != change) {
				final Change aChange = change;
				SafeRunner.run(new ISafeRunnable() {
					public void run() throws Exception {
						if (null != aChange) {
							aChange.dispose();
						}
					}

					public void handleException(Throwable ex) {
						IDEPlugin.logError(0, ex.toString(), ex);
					}
				});
			}
			monitor.done();
		}

		return undo;
	}

	public void dispose() {
		super.dispose();
		SafeRunner.run(new ISafeRunnable() {
			@SuppressWarnings("restriction")
			public void run() throws Exception {
				if (imports != null) {
					imports.dispose();
				}
			}

			public void handleException(Throwable ex) {
				IDEPlugin.logError(0, ex.toString(), ex);
			}
		});
	}

	public static class ImportTracker {

		@SuppressWarnings("restriction")
		ROTopologyModelManager modelManager = null;
		Map<IPath, List<IPath>> newImports = new HashMap<IPath, List<IPath>>();

		@SuppressWarnings("unchecked")
		public List<IPath> getImports(IPath topology) {
			List imports = newImports.get(topology);
			if (imports == null) {
				imports = new ArrayList<IPath>();
				newImports.put(topology, imports);
			}
			return imports;
		}

		@SuppressWarnings("unchecked")
		private boolean haveCommonImports(Topology topology1, Topology topology2) {
			if (null == topology1 || null == topology2) {
				return false;
			}

			for (Iterator<Import> iter = topology1.getImports().iterator(); iter.hasNext();) {
				Import anImport = iter.next();
				if (hasImport(topology2, anImport.getQualifiedImport())) {
					return true;
				}
			}

			for (Iterator<Import> iter = topology2.getImports().iterator(); iter.hasNext();) {
				Import anImport = iter.next();
				if (hasImport(topology1, anImport.getQualifiedImport())) {
					return true;
				}
			}

			return false;
		}

		public boolean haveCommonImports(IPath topology1, IPath topology2) {
			if (null == newImports || null == topology1 || null == topology2) {
				return false;
			}

			if (willHaveCommonImports(getImports(topology1), getImports(topology2))) {
				return true;
			}

			for (Iterator<IPath> iter = getImports(topology1).iterator(); iter.hasNext();) {
				if (haveCommonImports(iter.next(), topology2)) {
					return true;
				}
			}

			for (Iterator<IPath> iter = getImports(topology2).iterator(); iter.hasNext();) {
				if (haveCommonImports(iter.next(), topology1)) {
					return true;
				}
			}

			if (haveCommonImports(getTopology(topology1), getTopology(topology2))) {
				return true;
			}

			return false;
		}

		private boolean willHaveCommonImports(List<IPath> aImports, List<IPath> bImports) {
			if (null == aImports || null == bImports) {
				return false;
			}

			for (Iterator<IPath> iter = aImports.iterator(); iter.hasNext();) {
				IPath aPath = iter.next();
				if (bImports.contains(aPath)) {
					return true;
				}
			}

			for (Iterator<IPath> iter = bImports.iterator(); iter.hasNext();) {
				IPath bPath = iter.next();
				if (aImports.contains(bPath)) {
					return true;
				}
			}

			return false;
		}

		public boolean hasImport(IPath topology, IPath imported) {
			if (null == topology || null == imported) {
				return false;
			}

			if (willHaveImport(topology, imported)) {
				return true;
			}

			if (hasImport(getTopology(topology), getTopology(imported))) {
				return true;
			}

			return false;
		}

		public boolean hasImport(Topology topology, Topology imported) {
			if (null == imported) {
				return false;
			}
			return hasImport(topology, imported.getQualifiedName());
		}

		@SuppressWarnings("unchecked")
		private boolean hasImport(Topology topology, String qualifiedTopologyName) {
			if (null == topology || null == qualifiedTopologyName) {
				return false;
			}
			for (Iterator<Import> iter = topology.getImports().iterator(); iter.hasNext();) {
				Import anImport = iter.next();
				if (qualifiedTopologyName.equals(anImport.getQualifiedImport())) {
					return true;
				}
			}

			return false;
		}

		private boolean willHaveImport(IPath topology, IPath imported) {
			return getImports(topology).contains(imported);
		}

		@SuppressWarnings("restriction")
		private ROTopologyModelManager getModelManager() {
			if (modelManager == null) {
				modelManager = ROTopologyModelManager.create();
			}

			return modelManager;
		}

		public Topology getTopology(IPath path) {
			return getTopology(ResourcesPlugin.getWorkspace().getRoot().getFile(path));
		}

		@SuppressWarnings("restriction")
		public Topology getTopology(IFile file) {
			return getModelManager().openModel(file, new Listener() {

				public void onUnload(IFile unloadedResource) {
					// TODO Auto-generated method stub

				}

			});
		}

		public void dispose() {
			SafeRunner.run(new ISafeRunnable() {
				@SuppressWarnings("restriction")
				public void run() throws Exception {
					if (null != modelManager) {
						modelManager.dispose();
						modelManager = null;
					}
				}

				public void handleException(Throwable ex) {
					IDEPlugin.logError(0, ex.toString(), ex);
				}
			});
		}
	}
}
