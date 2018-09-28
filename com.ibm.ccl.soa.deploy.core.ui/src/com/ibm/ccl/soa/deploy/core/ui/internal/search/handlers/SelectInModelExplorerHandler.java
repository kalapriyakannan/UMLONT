package com.ibm.ccl.soa.deploy.core.ui.internal.search.handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.navigator.CommonNavigator;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.internal.search.Messages;
import com.ibm.ccl.soa.deploy.core.ui.internal.search.query.Match;
import com.ibm.ccl.soa.deploy.core.ui.navigator.actions.OpenTopologyModelAction;

public class SelectInModelExplorerHandler extends AbstractSelectInViewHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);

		try {

			Match match = (Match) getSelection(event);
			final IFile topology = ResourcesPlugin.getWorkspace().getRoot().getFile(
					new Path(match.getReferencing().toPlatformString(true)));
			EObject eObject = match.getReferencerEObject(true, true, false);
			CommonNavigator navigator = getProjectExplorer();
			navigator.setFocus();

			ResourcesPlugin.getWorkspace().run(new IWorkspaceRunnable() {

				public void run(IProgressMonitor monitor) throws CoreException {
					OpenTopologyModelAction open = new OpenTopologyModelAction(topology);
					open.run();
				}

			}, topology, IWorkspace.AVOID_UPDATE, new NullProgressMonitor());

			List<EObject> selections = new ArrayList<EObject>(1);
			if (CorePackage.Literals.DEPLOY_MODEL_OBJECT.isSuperTypeOf(eObject.eClass())) {
				DeployModelObject dmo = (DeployModelObject) eObject;
				while (!CorePackage.Literals.UNIT.isSuperTypeOf(dmo.eClass()) && null != dmo) {
					dmo = dmo.getParent();
				}

				if (null != dmo) {
					eObject = dmo;
				}
			}
			selections.add(eObject);
			IStructuredSelection selection = new StructuredSelection(selections);
			navigator.selectReveal(selection);

		} catch (CoreException ex) {
			DeployCoreUIPlugin.logError(0, ex.getMessage(), ex);
			ErrorDialog.openError(window.getShell(),
					Messages.AbstractReferencesHandler_Error_Occurre_, ex.getMessage(), new Status(
							IStatus.ERROR, DeployCoreUIPlugin.PLUGIN_ID, ex.getMessage(), ex));
		}

		return null;
	}

	private CommonNavigator getProjectExplorer() {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		if (page != null) {
			IViewReference references[] = page.getViewReferences();
			for (int i = 0; i < references.length; i++) {
				IViewReference reference = references[i];
				if (reference.getId().equals("org.eclipse.ui.navigator.ProjectExplorer")) { //$NON-NLS-1$
					return (CommonNavigator) reference.getPart(false);
				}
			}

		}
		return null;
	}

}
