package com.ibm.ccl.soa.deploy.ide.refactoring.participant;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.RefactoringStatusEntry;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.MoveParticipant;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.IEditorPart;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.Messages;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.utils.RefactoringUtils;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.CoreCompositeChange;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.MoveEMFResourceChange;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.MoveTopologyChange;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.UpdateDiagramImportsChange;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.UpdateTopologyImportsChange;
import com.ibm.ccl.soa.deploy.index.search.Query;

public class MoveTopologyParticipant extends MoveParticipant {

	private MoveTopologyDescriptor dataModel = null;

	private static final boolean DEBUG = DeployCorePlugin.getDefault().isDebugging()
			&& Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DeployCorePlugin.PLUGIN_ID
							+ "/debug/" + MoveTopologyParticipant.class.getCanonicalName())); //$NON-NLS-1$

	@Override
	public RefactoringStatus checkConditions(IProgressMonitor monitor, CheckConditionsContext context)
			throws OperationCanceledException {
		monitor.beginTask(Messages.MoveTopologyProcessor_Checking_final_conditiions_, 1);

		RefactoringStatus status = new RefactoringStatus();

		try {

			status.merge(RefactoringStatus.create(dataModel.validate()));

			if (status.isOK()) {
				IResource[] topologies = dataModel.getTopologies();
				for (int i = 0; i < topologies.length; i++) {
					IResource resource = topologies[i];
					if (resource.getType() == IResource.FILE) {
						List<IEditorPart> editors = RefactoringUtils.findDirtyEditors((IFile) resource);
						for (Iterator<IEditorPart> iter = editors.iterator(); iter.hasNext();) {
							status.addEntry(new RefactoringStatusEntry(RefactoringStatus.ERROR, NLS.bind(
									Messages.RenameNamespaceProcessor_The_editor_0_contains_unsaved_, iter
											.next().getTitle())));
						}
					}
				}
			}

		} finally {
			monitor.done();
		}

		return status;
	}

	@Override
	public String getName() {
		return Messages.MoveTopologyProcessor_Move_Topologie_;
	}

	@Override
	protected boolean initialize(Object element) {
		if (element instanceof IResource) {
			IResource resource = (IResource) element;
			if (resource.getType() == IResource.FILE) {
				IFile file = (IFile) resource;
				if (IConstants.TOPOLOGY_EXTENSION.equals(file.getFileExtension())) {
					MoveTopologyDescriptor descriptor = MoveTopologyDescriptor.createModel();

					Object destinationArg = super.getArguments().getDestination();
					if (destinationArg instanceof IContainer) {
						IContainer destination = (IContainer) destinationArg;
						descriptor.setContainer(destination.getFullPath().toString());
					} else {
						descriptor.setContainer(destinationArg.toString());
					}

					descriptor.setTopologies(new IResource[] { file });
					dataModel = descriptor;
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		pm.beginTask("", 1); //$NON-NLS-1$

		Change change = null;

		try {

			change = createMoveTopologyChanges(new CoreCompositeChange(
					Messages.MoveTopologyProcessor_Move_Topology_Change_), dataModel, pm);

		} finally {
			pm.done();
		}

		return change;
	}

	public Change createMoveTopologyChanges(CoreCompositeChange changes,
			MoveTopologyDescriptor dataModel, IProgressMonitor pm) throws CoreException {

		for (int i = 0; i < dataModel.getTopologies().length; i++) {
			IFile topology = (IFile) dataModel.getTopologies()[i];
			Topology aTopology = dataModel.getTopology(topology);

			MoveTopologyChange renameTopology = MoveTopologyChange.createModel();
			renameTopology.setSource(topology.getFullPath());
			renameTopology.setDestination(ResourcesPlugin.getWorkspace().getRoot().getFolder(
					new Path(dataModel.getContainer())).getFullPath().append(topology.getName()));

			changes.add(renameTopology);

			// find all imports of this model in other topology models
			Collection<IFile> importingModels = Query.findImportingTopologyReferences(aTopology, null,
					true, false, true, false, pm);
			for (Iterator<IFile> iter = importingModels.iterator(); iter.hasNext();) {
				IFile resource = iter.next();

				UpdateTopologyImportsChange updateImports = UpdateTopologyImportsChange.createModel();
				updateImports.setModel(resource.getFullPath());
				updateImports.setSource(aTopology.getQualifiedName());
				updateImports.setDestination(renameTopology.getNewQualifiedName());

				changes.add(updateImports);
			}

			// find all diagrams associated with this topology
			Collection<IFile> diagrams = Query.findReferencingDiagramResources(aTopology, null, true,
					false, true, false, pm);
			for (Iterator<IFile> iter = diagrams.iterator(); iter.hasNext();) {
				IFile aFile = iter.next();

				MoveEMFResourceChange moveResource = MoveEMFResourceChange.createModel();
				moveResource.setSource(aFile.getFullPath());
				moveResource.setDestination(ResourcesPlugin.getWorkspace().getRoot().getFolder(
						new Path(dataModel.getContainer())).getFullPath().append(aFile.getName()));

				changes.add(moveResource);
			}

			// find all diagrams associated with topology models that import this topology
			for (Iterator<IFile> iter = importingModels.iterator(); iter.hasNext();) {
				IFile resource = iter.next();
				Collection<IFile> theDiagrams = Query.findReferencingDiagramResources(dataModel
						.getTopology(resource), null, true, false, true, false, pm);
				for (Iterator<IFile> anIter = theDiagrams.iterator(); anIter.hasNext();) {
					IFile aResource = anIter.next();

					UpdateDiagramImportsChange updateImports = UpdateDiagramImportsChange.createModel();
					updateImports.setDiagram(aResource.getFullPath());
					updateImports.setModel(resource.getFullPath());
					updateImports.setSource(aTopology.getQualifiedName());
					updateImports.setDestination(renameTopology.getNewQualifiedName());

					changes.add(updateImports);
				}
			}
		}

		return changes;
	}

	public MoveTopologyDescriptor getDataModel() {
		return dataModel;
	}

}
