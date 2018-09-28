package com.ibm.ccl.soa.deploy.ide.refactoring;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringDescriptor;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.RefactoringStatusEntry;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.ParticipantManager;
import org.eclipse.ltk.core.refactoring.participants.RefactoringParticipant;
import org.eclipse.ltk.core.refactoring.participants.RenameArguments;
import org.eclipse.ltk.core.refactoring.participants.RenameProcessor;
import org.eclipse.ltk.core.refactoring.participants.SharableParticipants;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ide.undo.DeleteResourcesOperation;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragment;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.Messages;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.utils.ChangeAdapter;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.utils.RefactoringUtils;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.CoreCompositeChange;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.CreateNamespaceChange;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.MoveResourceChange;
import com.ibm.ccl.soa.deploy.ide.refactoring.participant.MoveTopologyDescriptor;
import com.ibm.ccl.soa.deploy.ide.refactoring.participant.MoveTopologyParticipant;

public class RenameNamespaceProcessor extends RenameProcessor {

	public static final String IDENTIFIER = "com.ibm.ccl.soa.deploy.ide.refactoring.renameNamespaceProcessor"; //$NON-NLS-1$

	private RenameNamespaceRefactoringDescriptor descriptor = null;

	public RenameNamespaceProcessor(RenameNamespaceRefactoringDescriptor model) {
		descriptor = model;
	}

	@Override
	public RefactoringStatus checkFinalConditions(IProgressMonitor monitor,
			CheckConditionsContext context) throws CoreException, OperationCanceledException {
		monitor.beginTask(Messages.RenameNamespaceProcessor_Checking_final_conditions_for_renam_, 1);
		try {

			RefactoringStatus status = RefactoringStatus.create(descriptor.validateSourcePath());
			status.merge(RefactoringStatus.create(descriptor.validatePreviousNamespacePath()));
			status.merge(RefactoringStatus.create(descriptor.validateNewNamespacePath()));

			if (status.isOK()) {
				INamespaceFragment namespace = NamespaceCore.findNamespace(descriptor
						.getPreviousNamespaceContainer().getProject(), descriptor
						.getPreviousNamespaceContainer());
				List<IEditorPart> editors = RefactoringUtils.findDirtyEditors(namespace, descriptor
						.getRenameSubNamespaces());
				for (Iterator<IEditorPart> iter = editors.iterator(); iter.hasNext();) {
					IEditorPart editor = iter.next();
					if (editor.isDirty()) {
						status.addEntry(new RefactoringStatusEntry(RefactoringStatus.ERROR, NLS.bind(
								Messages.RenameNamespaceProcessor_The_editor_0_contains_unsaved_, editor
										.getTitle())));
					}
				}
			}

			return status;
		} finally {
			monitor.done();
		}
	}

	@Override
	public RefactoringStatus checkInitialConditions(IProgressMonitor monitor) throws CoreException,
			OperationCanceledException {
		monitor.beginTask(Messages.RenameNamespaceProcessor_Checking_initial_conditions_for_ren_, 1);
		try {

			RefactoringStatus status = RefactoringStatus.create(descriptor.validateSourcePath());
			status.merge(RefactoringStatus.create(descriptor.validatePreviousNamespacePath()));

			return status;
		} finally {
			monitor.done();
		}
	}

	private void fluffDescriptor() {
		descriptor.setProject(descriptor.getSourceContainer().getProject().getName());
		descriptor.setDescription("Rename namespace " //$NON-NLS-1$
				+ descriptor.getPreviousNamespacePath() + " to " //$NON-NLS-1$
				+ descriptor.getNewNamespacePath() + "."); //$NON-NLS-1$
		descriptor.setComment("Rename namespace " + descriptor.getPreviousNamespacePath() + " to " //$NON-NLS-1$ //$NON-NLS-2$
				+ descriptor.getNewNamespacePath());
		descriptor.setFlags(RefactoringDescriptor.STRUCTURAL_CHANGE
				| RefactoringDescriptor.MULTI_CHANGE | RefactoringDescriptor.BREAKING_CHANGE);
	}

	@Override
	public Change createChange(IProgressMonitor monitor) throws CoreException,
			OperationCanceledException {
		monitor.beginTask(new String(), 1);

		fluffDescriptor();

		CoreCompositeChange changes = new CoreCompositeChange(
				Messages.RenameNamespaceProcessor_Rename_Namespace_Refactoring_Change_);

		try {

			createRenameNamespaceChanges(changes, descriptor, monitor);

			IContainer newNamespaceContainer = descriptor.getNewNamespaceContainer();
			IContainer oldNamespaceContainer = descriptor.getPreviousNamespaceContainer();
			boolean newNamespaceIsDescendentOfOld = newNamespaceContainer.getFullPath()
					.matchingFirstSegments(oldNamespaceContainer.getFullPath()) == oldNamespaceContainer
					.getFullPath().segmentCount();

			INamespaceFragment oldNamespace = NamespaceCore.findNamespace(descriptor
					.getSourceContainer().getProject(), descriptor.getPreviousNamespacePath());

			// delete old namespace *if* it does not contain any subnamespaces unless we are renaming
			// sub namespaces or the new namespace is contained within the old namespace
			INamespaceFragment parent = oldNamespace;
			while (null != parent && !parent.equals(oldNamespace.getRoot())
					&& !parent.isDefaultNamespace()) {

				// only delete namespace if it does not contain topologies or in the case that the parent
				// is the renamed namespace we can proceed since we will be moving those topologies to
				// the new namespace
				if (!parent.containsTopologies() || parent.equals(oldNamespace)) {

					// only delete old namespace if new namespace will not be a descendent of the old namespace
					if (!newNamespaceIsDescendentOfOld) {

						// if we're renameing subnamespaces and this namespace is the renamed namespace then delete it
						if (descriptor.getRenameSubNamespaces() && parent.equals(oldNamespace)) {
							ChangeAdapter delete = new ChangeAdapter(new DeleteResourcesOperation(
									new IResource[] { parent.getCorrespondingResource() },
									"delete namespace", true), new Object[] { parent //$NON-NLS-1$
									.getCorrespondingResource() }, ChangeAdapter.Operation.EXECUTE);
							changes.add(delete);
							parent = parent.getParent();
						}

						// if the number of subnamespaces is equal to one then it's a direct path
						// to the namespace that we are renaming
						else if (parent.subNamespaces().length == 1 && !parent.equals(oldNamespace)) {
							if (!newNamespaceIsDescendentOfOld) {
								ChangeAdapter delete = new ChangeAdapter(new DeleteResourcesOperation(
										new IResource[] { parent.getCorrespondingResource() },
										"delete namespace", true), new Object[] { parent //$NON-NLS-1$
										.getCorrespondingResource() }, ChangeAdapter.Operation.EXECUTE);
								changes.add(delete);
								parent = parent.getParent();
							}
						} else {
							break;
						}
					} else {
						break;
					}
				}
			}

		} finally {
			monitor.done();
		}

		return changes;
	}

	public Change createRenameNamespaceChanges(CoreCompositeChange changes,
			RenameNamespaceRefactoringDescriptor dataModel, IProgressMonitor monitor)
			throws CoreException {

		// create the new namespace
		CreateNamespaceChange createNamespace = CreateNamespaceChange.createModel();
		createNamespace.setSourcePath(dataModel.getSourcePath());
		createNamespace.setNamespacePath(dataModel.getNewNamespacePath());
		changes.add(createNamespace);

		INamespaceFragment oldNamespace = NamespaceCore.findNamespace(dataModel.getSourceContainer()
				.getProject(), dataModel.getPreviousNamespacePath());

		// move all existing topology in the old namespace to the new one
		IFile[] topologies = oldNamespace.topologies();
		for (int i = 0; i < topologies.length; i++) {
			MoveResourceChange move = MoveResourceChange.createModel();
			move.setDestination(createNamespace.getNamespaceContainer().getFullPath().append(
					topologies[i].getName()));
			move.setSource(topologies[i].getFullPath());
			changes.add(move);
		}

		MoveTopologyDescriptor moveTopologyDescriptor = MoveTopologyDescriptor.createModel();
		IContainer destination = createNamespace.getNamespaceContainer();
		moveTopologyDescriptor.setContainer(destination.getFullPath().toString());
		moveTopologyDescriptor.setTopologies(oldNamespace.topologies());
		new MoveTopologyParticipant().createMoveTopologyChanges(changes, moveTopologyDescriptor,
				monitor);
		moveTopologyDescriptor.dispose();

		// move all other existing files in the old namespace to the new one
		IResource[] resources = oldNamespace.nonTopologyResources();
		for (int i = 0; i < resources.length; i++) {
			if (resources[i].getType() == IResource.FILE
					&& !IConstants.TOPOLOGYV_EXTENSION.equals(resources[i].getFileExtension())) {
				MoveResourceChange move = MoveResourceChange.createModel();
				move.setDestination(createNamespace.getNamespaceContainer().getFullPath());
				move.setSource(resources[i].getFullPath());
				changes.add(move);
			}
		}

		if (dataModel.getRenameSubNamespaces()) {
			INamespaceFragment[] subNamespaces = oldNamespace.subNamespaces();
			for (int i = 0; i < subNamespaces.length; i++) {
				RenameNamespaceRefactoringDescriptor descriptor = RenameNamespaceRefactoringDescriptor
						.createModel();
				descriptor.setSourcePath(dataModel.getSourcePath());
				descriptor.setPreviousNamespacePath(subNamespaces[i].getQualifiedName());
				descriptor
						.setNewNamespacePath((createNamespace.getNamespacePath().equals(new String()) ? new String()
								: createNamespace.getNamespacePath() + IConstants.DOT_SEPARATOR)
								+ subNamespaces[i].getName());
				descriptor.setRenameSubNamespaces(dataModel.getRenameSubNamespaces());
				createRenameNamespaceChanges(changes, descriptor, monitor);
			}
		}

		return changes;
	}

	@Override
	public Object[] getElements() {
		return new Object[] { descriptor.getPreviousNamespaceContainer() };
	}

	@Override
	public String getIdentifier() {
		return IDENTIFIER;
	}

	@Override
	public String getProcessorName() {
		return Messages.RenameNamespaceProcessor_Rename_Namespac_;
	}

	@Override
	public boolean isApplicable() throws CoreException {

		if (descriptor.validateSourcePath().isOK()
				&& descriptor.validatePreviousNamespacePath().isOK()) {
			return true;
		}

		return false;
	}

	@Override
	public RefactoringParticipant[] loadParticipants(RefactoringStatus status,
			SharableParticipants sharedParticipants) throws CoreException {

		return ParticipantManager.loadRenameParticipants(status, this, descriptor
				.getPreviousNamespaceContainer(), new RenameArguments(descriptor
				.getNewNamespaceContainer().getName(), true), descriptor
				.getPreviousNamespaceContainer().getProject().getDescription().getNatureIds(),
				sharedParticipants);
	}

	public RenameNamespaceRefactoringDescriptor getDataModel() {
		return descriptor;
	}

}
