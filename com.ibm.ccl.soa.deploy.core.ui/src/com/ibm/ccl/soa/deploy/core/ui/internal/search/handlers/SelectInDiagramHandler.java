package com.ibm.ccl.soa.deploy.core.ui.internal.search.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.util.DiagramEditorUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.internal.search.Messages;
import com.ibm.ccl.soa.deploy.core.ui.internal.search.query.Match;

public class SelectInDiagramHandler extends AbstractSelectInViewHandler {

	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);

		try {
			final Match match = (Match) getSelection(event);
			EObject eObject = match.getReferencerEObject(true, true, false);
			while (eObject != null && !NotationPackage.Literals.DIAGRAM.isInstance(eObject)) {
				eObject = eObject.eContainer();
			}

			Diagram diagram = (Diagram) eObject;
			DiagramEditor editor = DiagramEditorUtil.findOpenedDiagramEditorForID(ViewUtil
					.getIdStr(diagram));
			if (null == editor) {
				final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(
						new Path(match.getReferencing().toPlatformString(true)));
				openFile(file);
				editor = DiagramEditorUtil.findOpenedDiagramEditorForID(ViewUtil.getIdStr(diagram));
			}

			if (null != editor) {
				selectAndReveal(editor, match.getReferencing());
			}

		} catch (CoreException ex) {
			DeployCoreUIPlugin.logError(0, ex.getMessage(), ex);
			ErrorDialog.openError(window.getShell(),
					Messages.AbstractReferencesHandler_Error_Occurre_, ex.getMessage(), new Status(
							IStatus.ERROR, DeployCoreUIPlugin.PLUGIN_ID, ex.getMessage(), ex));
		}

		return null;
	}

	private void selectAndReveal(DiagramEditor editor, URI uri) {
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().activate(editor);
		IDiagramGraphicalViewer viewer = editor.getDiagramGraphicalViewer();
		if (null != viewer) {
			Object obj = viewer.getEditPartRegistry().get(
					editor.getDiagram().eResource().getEObject(uri.fragment()));

			if (obj instanceof EditPart) {
				EditPart part = (EditPart) obj;
				viewer.select(part);
				viewer.reveal(part);
			}
		}
	}

	private IEditorPart openFile(IFile file) {
		IEditorPart part = null;
		IEditorRegistry registry = PlatformUI.getWorkbench().getEditorRegistry();
		if (file != null && file.exists()) {
			IEditorDescriptor currentDescriptor = registry.getDefaultEditor(file.getName());
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			try {
				if (page != null) {
					part = page.openEditor(new FileEditorInput(file), currentDescriptor.getId());
				}
			} catch (PartInitException e) {
				e.printStackTrace();
			}
		}
		BasicNewResourceWizard.selectAndReveal(file, PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow());

		return part;
	}

}
