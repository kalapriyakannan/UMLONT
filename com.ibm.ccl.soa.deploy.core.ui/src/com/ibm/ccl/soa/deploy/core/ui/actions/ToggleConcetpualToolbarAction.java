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

import com.ibm.ccl.soa.deploy.core.ConceptualNode;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;

/**
 * Creates the {@link ToggleConceptualAction} pulldown toolbar menu.
 * 
 * @since 7.0
 * @author NKruk
 * 
 */
public class ToggleConcetpualToolbarAction implements IWorkbenchWindowPulldownDelegate,
		IActionDelegate2 {
	private IWorkbenchWindow window = null;
	private ToggleConceptualAction lastAction = null;
	private Menu menu = null;
	private IAction cache = null;

	public Menu getMenu(Control parent) {
		if (menu == null) {
			menu = new Menu(parent);
			createMenuItem(ToggleConceptualAction.createSetAllConceptual(window.getActivePage()), menu);
			createMenuItem(ToggleConceptualAction.createSetAllNonConceptual(window.getActivePage()),
					menu);
		}
		return menu;
	}

	public void dispose() {
		window = null;
		lastAction = null;
		if (menu != null) {
			menu.dispose();
			menu = null;
		}
	}

	public void init(IWorkbenchWindow window) {
		this.window = window;
		lastAction = ToggleConceptualAction.createSetAllConceptual(window.getActivePage());
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
				if (!isNonConceptualNodeUnit(iter.next())) {
					action.setEnabled(false);
					return;
				}
			}
		}
		action.setEnabled(true);
	}

	private boolean isNonConceptualNodeUnit(Object element) {
		if (element instanceof DeployShapeNodeEditPart) {
			DeployShapeNodeEditPart editPart = (DeployShapeNodeEditPart) element;
			if (editPart.getModel() instanceof Node) {
				Node node = (Node) editPart.getModel();
				//disable action for conceptual nodes
				if (node.getElement() instanceof Unit && !(node.getElement() instanceof ConceptualNode)) {
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
	private MenuItem createMenuItem(final ToggleConceptualAction action, Menu parent) {
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
				cache.setImageDescriptor(action.getImageDescriptor());
				lastAction = action;
			}
		});
		return item;
	}
}
