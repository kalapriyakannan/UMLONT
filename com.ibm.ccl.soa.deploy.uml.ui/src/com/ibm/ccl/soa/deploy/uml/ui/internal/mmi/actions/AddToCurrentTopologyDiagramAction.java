package com.ibm.ccl.soa.deploy.uml.ui.internal.mmi.actions;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployCoreEditor;
import com.ibm.ccl.soa.deploy.core.ui.util.ResourceUtils;
import com.ibm.xtools.mmi.ui.actions.AddToCurrentDiagramAction;
import com.ibm.xtools.mmi.ui.util.IUIContext;
import com.ibm.xtools.mmi.ui.util.UIContext;

/**
 * @since 7.0
 * 
 */
public class AddToCurrentTopologyDiagramAction extends AddToCurrentDiagramAction {

	private static final IUIContext context = new UIContext();
	private final ArrayList<DeployModelObject> deployModelObjects = new ArrayList<DeployModelObject>();
	protected IEditorDescriptor currentDescriptor;

	@Override
	protected IUIContext getUIContext() {
		return context;
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		action.setEnabled(true);
		setSelection(selection);
		setAction(action);
	}

	@Override
	protected IWorkbenchWindow getWindow() {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (window == null && PlatformUI.getWorkbench().getWorkbenchWindowCount() > 0) {
			window = PlatformUI.getWorkbench().getWorkbenchWindows()[0];
		}
		return window;
	}

	public void doRun(IProgressMonitor progressMonitor) {
		IEditorPart part = ResourceUtils.getActiveEditorPart();
		if (part instanceof DeployCoreEditor) {
			if (getSelection() instanceof IStructuredSelection) {
				for (Iterator it = ((IStructuredSelection) getSelection()).toList().iterator(); it
						.hasNext();) {
					Object obj = it.next();
					if (obj instanceof Unit || obj instanceof DeployModelObject) {
						deployModelObjects.add((DeployModelObject) obj);
					}
				}

				DeployCoreEditor.visualize(deployModelObjects);
				deployModelObjects.clear();
			}
		} else {
			super.doRun(progressMonitor);
		}
	}

}
