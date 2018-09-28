package com.ibm.ccl.soa.deploy.core.ui.actions;

import java.util.Iterator;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.IActionDelegate2;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowPulldownDelegate;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;

/**
 * Creates the SetInstallState pulldown toolbar menu.
 * 
 * @since 7.0
 * @author NKruk
 * 
 */
public class SetInstallStateToolbarAction implements IWorkbenchWindowPulldownDelegate,
		IActionDelegate2 {
	private IWorkbenchWindow window = null;
	private SetInstallStateAction lastAction = null;
	private Menu menu = null;
	private IAction cache = null;

	public Menu getMenu(Control parent) {
		if (menu == null) {
			menu = new Menu(parent);

			// uninstalled > installed
			createMenuItem(SetInstallStateAction.createSetAllUninstalledInstalledAction(window
					.getActivePage()), menu);
			// installed > uninstalled
			createMenuItem(SetInstallStateAction.createSetAllInstalledUninstalledAction(window
					.getActivePage()), menu);
			// installed > installed
			createMenuItem(SetInstallStateAction.createSetAllInstalledAction(window.getActivePage()),
					menu);
			// uninstalled > uninstalled
			createMenuItem(SetInstallStateAction.createSetAllUnistalledAction(window.getActivePage()),
					menu);
			// unknown > unknown
			createMenuItem(SetInstallStateAction.createSetAllUnknownAction(window.getActivePage()),
					menu);
			// unknown > installed
			createMenuItem(SetInstallStateAction.createSetAllUnknownInstalledAction(window
					.getActivePage()), menu);
			// unknown > uninstalled
			createMenuItem(SetInstallStateAction.createSetAllUnknownUninstalledAction(window
					.getActivePage()), menu);
			// installed > unknown
			createMenuItem(SetInstallStateAction.createSetAllInstalledUnknownAction(window
					.getActivePage()), menu);
			// uninstalled > unknown
			createMenuItem(SetInstallStateAction.createSetAllUnknownUninstalledAction(window
					.getActivePage()), menu);

		}
		return menu;
	}

	public void dispose() {
		window = null;
		lastAction = null;
		if (menu != null) {
			menu.dispose();
		}
	}

	public void init(IWorkbenchWindow window) {
		this.window = window;
		lastAction = SetInstallStateAction.createSetAllInstalledUninstalledAction(window
				.getActivePage());
	}

	public void init(IAction action) {
		//cache our action so we can adjust the image
		cache = action;
	}

	public void run(IAction action) {
		//Runs the last action
		if (lastAction != null) {
			lastAction.doRun(new NullProgressMonitor());
		}
	}

	public void runWithEvent(IAction action, Event event) {
		//Runs the last action
		if (lastAction != null) {
			lastAction.doRun(new NullProgressMonitor());
		}
	}

	//disable action for non-units
	public void selectionChanged(IAction action, ISelection sel) {
		if (sel != null && sel instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection) sel;
			for (Iterator iter = selection.iterator(); iter.hasNext();) {
				if (!isUnit(iter.next())) {
					action.setEnabled(false);
					return;
				}
			}
		}
		action.setEnabled(true);
	}

	private boolean isUnit(Object element) {
		if (element instanceof DeployShapeNodeEditPart) {
			DeployShapeNodeEditPart editPart = (DeployShapeNodeEditPart) element;
			if (editPart.getModel() instanceof Node) {
				Node node = (Node) editPart.getModel();
				if (node.getElement() instanceof Unit) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Creates a menu item for the parent menu based on the action.
	 * 
	 * @param parent
	 * @return a menu item
	 */
	private MenuItem createMenuItem(final SetInstallStateAction action, Menu parent) {
		final MenuItem item = new MenuItem(parent, SWT.NONE);
		if (action.getImageDescriptor() != null) {
			item.setImage(action.getImageDescriptor().createImage());
		}
		item.setText(action.getText());

		item.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
				//Do nothing
			}

			public void widgetSelected(SelectionEvent e) {
				action.doRun(new NullProgressMonitor());
				if (cache != null && action != null) {
					cache.setImageDescriptor(action.getImageDescriptor());
				}
				lastAction = action;
			}
		});
		return item;
	}
}
