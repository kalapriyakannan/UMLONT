package com.ibm.ccl.soa.deploy.uml.ui.internal.search.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.ui.internal.search.scopes.Scope;
import com.ibm.ccl.soa.deploy.uml.ui.Activator;
import com.ibm.ccl.soa.deploy.uml.ui.internal.search.Messages;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

public class UMLReferencesInEnclosingDiagramHandler extends AbstractUMLReferencesHandler {

	@Override
	protected Scope getSearchScope(ExecutionEvent event) throws CoreException, ExecutionException {
		IFile file = getDiagramOfCurrentSelection(event);
		if (null != file && IConstants.TOPOLOGYV_EXTENSION.equals(file.getFileExtension())) {
			return Scope.getDocumentScope(file);
		}

		throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
				Messages.UMLReferencesInEnclosingDiagramHandler_Could_not_determin_topology_diagram_,
				null));
	}

	private IFile getDiagramOfCurrentSelection(ExecutionEvent event) throws CoreException,
			ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelectionChecked(event);
		Object object = selection;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection extended = (IStructuredSelection) selection;
			Object[] elements = extended.toArray();
			if (elements.length == 0 && elements.length > 1) {
				throw new CoreException(
						new Status(
								IStatus.ERROR,
								Activator.PLUGIN_ID,
								Messages.UMLReferencesInEnclosingDiagramHandler_Cannot_search_for_more_than_a_singl_,
								null));
			}
			object = elements[0];
		}

		if (object instanceof EditPart) {
			object = ((EditPart) object).getModel();
		}

		if (!(object instanceof EObject)) {
			throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
					Messages.UMLReferencesInWorkspaceHandler_Selection_was_not_an_instance_of_EO_, null));
		}

		EObject eObject = (EObject) object;
		return WorkbenchResourceHelper.getFile(eObject);
	}

}
