/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.cmdb.ui.internal.actions;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.cmdb.ui.internal.CmdbUiUtil;
import com.ibm.ccl.soa.deploy.cmdb.ui.internal.commands.AbstractDiscoverCommand;
import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * Abstract super-type of UI discover actions.
 */
public abstract class AbstractDiscoverAction extends DiagramAction {

	/**
	 * The point into which the provided units will be added.
	 */
	protected Point point;

	/**
	 * 
	 * @param page
	 */
	public AbstractDiscoverAction(IWorkbenchPage page) {
		super(page);
		init();
		Control control = Display.getCurrent().getCursorControl();
		if (control != null) {
			point = new org.eclipse.draw2d.geometry.Point(control
					.toControl(Display.getCurrent().getCursorLocation()));
		}
		if (point == null) {
			point = new Point(0, 0);
		}
	}

	/*
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#doRun(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected void doRun(IProgressMonitor progressMonitor) {
		List<Unit> units = CmdbUiUtil
				.getSelectedPartUnits(getSelectedObjects());
		AbstractDiscoverCommand cmd = createDiscoverCommand(units);
		getDiagramCommandStack().execute(new ICommandProxy(cmd),
				progressMonitor);
	}

	/*
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#createTargetRequest()
	 */
	@Override
	protected Request createTargetRequest() {
		return null;
	}

	/*
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#isSelectionListener()
	 */
	@Override
	protected boolean isSelectionListener() {
		return true;
	}

	/*
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#calculateEnabled()
	 */
	@Override
	protected boolean calculateEnabled() {
		List<Unit> units = CmdbUiUtil
				.getSelectedPartUnits(getSelectedObjects());
		if (units.size() == 0) {
			return false;
		}
		for (Unit u : units) {
			if (isEnabledOnUnit(u)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return the draw 2D point where the action was invoked.
	 */
	public Point getActionPoint() {
		return point;
	}

	/**
	 * Returns true if the action is enabled on the semantic unit.
	 * 
	 * @param unit
	 *            a deploy unit.
	 * @return true if the action can be applied on the unit.
	 */
	protected abstract boolean isEnabledOnUnit(Unit unit);

	/**
	 * Returns the discover command associated with the action.
	 * 
	 * @param units
	 *            a list of units to be discovered.
	 * @return the discover command associated with the action.
	 */
	protected abstract AbstractDiscoverCommand createDiscoverCommand(
			List<Unit> units);
}
