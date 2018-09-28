package com.ibm.ccl.soa.deploy.ide.refactoring.participant;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.RefactoringStatusEntry;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.RenameParticipant;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.IEditorPart;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.Messages;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.utils.RefactoringUtils;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.CoreCompositeChange;
import com.ibm.ccl.soa.deploy.ide.refactoring.change.RenameDiagramChange;

public class RenameDiagramParticipant extends RenameParticipant {

	private RenameDiagramDescriptor dataModel;

	@Override
	public RefactoringStatus checkConditions(IProgressMonitor monitor, CheckConditionsContext context)
			throws OperationCanceledException {
		monitor.beginTask(Messages.RenameTopologyProcessor_Check_final_conditions_, 1);
		RefactoringStatus status = new RefactoringStatus();

		try {

			status = RefactoringStatus.create(dataModel.validate());

			if (status.isOK()) {
				IFile model = RefactoringUtils.getAssociatedModelFile(ResourcesPlugin.getWorkspace()
						.getRoot().getFile(new Path(dataModel.getDiagram())));
				List<IEditorPart> editors = RefactoringUtils.findDirtyEditors(model);
				for (Iterator<IEditorPart> iter = editors.iterator(); iter.hasNext();) {
					status.addEntry(new RefactoringStatusEntry(RefactoringStatus.ERROR, NLS.bind(
							Messages.RenameNamespaceProcessor_The_editor_0_contains_unsaved_, iter.next()
									.getTitle())));
				}
			}

		} finally {
			monitor.done();
		}

		return status;
	}

	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException, OperationCanceledException {
		pm.beginTask("", 1); //$NON-NLS-1$

		CoreCompositeChange changes = new CoreCompositeChange("Rename Diagram Changes"); //$NON-NLS-1$

		try {

			IPath diagramPath = new Path(dataModel.getDiagram());
			IFile diagram = ResourcesPlugin.getWorkspace().getRoot().getFile(diagramPath);
			if (diagram.isAccessible()) {
				IPath newDiagramPath = new Path(dataModel.getName()).removeFileExtension()
						.addFileExtension(IConstants.TOPOLOGYV_EXTENSION);
				RenameDiagramChange renameDiagram = RenameDiagramChange.createModel();
				renameDiagram.setSource(diagram.getFullPath());
				renameDiagram.setDestination(newDiagramPath);

				changes.add(renameDiagram);
			}

		} finally {
			pm.done();
		}

		return changes;
	}

	@Override
	public String getName() {
		return "Rename Diagram"; //$NON-NLS-1$
	}

	@Override
	protected boolean initialize(Object element) {
		if (element instanceof IResource) {
			IResource resource = (IResource) element;
			if (resource.getType() == IResource.FILE) {
				IFile file = (IFile) resource;
				if (IConstants.TOPOLOGYV_EXTENSION.equals(file.getFileExtension())) {
					RenameDiagramDescriptor descriptor = RenameDiagramDescriptor.createModel();
					descriptor.setName(file.getParent().getFullPath().append(
							super.getArguments().getNewName()).toString());
					descriptor.setDiagram(file.getFullPath().toString());
					dataModel = descriptor;
					return true;
				}
			}
		}

		return false;
	}

}
