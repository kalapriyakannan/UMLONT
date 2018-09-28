package com.ibm.ccl.soa.deploy.core.ui.actions;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;

/**
 * Abstract class for displaying unit property flyouts. Sublcasses may override to implement their
 * own specific flyouts.
 * 
 * @since 7.0
 * 
 */
public abstract class UnitPropertyFlyoutHandler extends Action implements IHandler {
	protected DeployShapeNodeEditPart editPart;
	protected IWorkbenchPage page;

	/**
	 * 
	 */
	public UnitPropertyFlyoutHandler() {
		super();
	}

	/**
	 * @param wbPage
	 */
	public UnitPropertyFlyoutHandler(IWorkbenchPage wbPage) {
		page = wbPage;
	}

	public void run() {
		Unit unit = getSelectedUnit(page.getSelection());
		if (unit == null) {
			return; //Do nothing
		}
		openFlyout(unit);
	}

	public boolean isEnabled() {
		// var page will have to be initialized for the IHandler case.
		if (page == null) {
			IWorkbench workbench = PlatformUI.getWorkbench();
			if (workbench == null) {
				return false;
			}
			IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
			if (window == null) {
				return false;
			}
			page = window.getActivePage();
		}
		if (page == null || page.getSelection() == null) {
			return false;
		}
		Unit unit = getSelectedUnit(page.getSelection());
		if (unit == null || unit instanceof Import) {
			return false;
		}
		return super.isEnabled();
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow win = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (win != null) {
			Unit unit = getSelectedUnit(win.getSelectionService().getSelection());
			if (unit != null) {
				openFlyout(unit);
			}
		}
		return null;
	}

	public Object executeAndSelect(DeployModelObject dmo) throws ExecutionException {
		IWorkbenchWindow win = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (win != null) {
			Unit unit = getSelectedUnit(win.getSelectionService().getSelection());
			if (unit != null) {
				openFlyoutAndSelect(unit, dmo);
			}
		}
		return null;
	}

	private void openFlyoutAndSelect(Unit unit, DeployModelObject dmo) {
		Point location = new Point(editPart.getFigure().getBounds().getTopRight());
		editPart.getFigure().translateToAbsolute(location);
		org.eclipse.swt.graphics.Point loc = location.getSWTPoint();
		Control canvas = editPart.getParent().getRoot().getViewer().getControl();
		loc = Display.getCurrent().map(canvas, null, loc);
		openFlyoutAndSelect(Display.getCurrent().getShells()[0], unit, loc, dmo);
	}

	private void openFlyout(Unit unit) {
		Point location = new Point(editPart.getFigure().getBounds().getTopRight());
		editPart.getFigure().translateToAbsolute(location);
		org.eclipse.swt.graphics.Point loc = location.getSWTPoint();
		Control canvas = editPart.getParent().getRoot().getViewer().getControl();
		loc = Display.getCurrent().map(canvas, null, loc);
		openFlyout(Display.getCurrent().getShells()[0], unit, loc);
	}

	/**
	 * Subclasses should override to open their specific flyout.
	 * 
	 * @param shell
	 *           the shell
	 * @param unit
	 *           the unit
	 * @param point
	 *           the point where the flyout should open
	 */
	protected abstract void openFlyout(Shell shell, Unit unit, org.eclipse.swt.graphics.Point point);

	/**
	 * Subclasses should override to open their specific flyout.
	 * 
	 * @param shell
	 *           the shell
	 * @param unit
	 *           the unit
	 * @param point
	 *           the point where the flyout should open
	 * @param dmo
	 *           the {@link DeployModelObject} to select
	 */
	protected void openFlyoutAndSelect(Shell shell, Unit unit, org.eclipse.swt.graphics.Point point,
			DeployModelObject dmo) {
		openFlyout(shell, unit, point);
	}

	private Unit getSelectedUnit(ISelection sel) {
		if (sel == null) {
			return null;
		}
		Unit retVal = null;
		if (sel instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection) sel;
			if (selection.size() == 1) {
				Object element = selection.getFirstElement();
				if (element instanceof DeployShapeNodeEditPart) {
					editPart = (DeployShapeNodeEditPart) element;
					if (editPart.getModel() instanceof Node) {
						Node node = (Node) editPart.getModel();
						if (node.getElement() instanceof Unit) {
							retVal = (Unit) node.getElement();
						}
					}
				}
			}
		}
		return retVal;
	}

	public void dispose() {
		editPart = null;
		page = null;
	}

	public void addHandlerListener(IHandlerListener handlerListener) {
		//Do Nothing
	}

	public void removeHandlerListener(IHandlerListener handlerListener) {
		//Do Nothing
	}

}
