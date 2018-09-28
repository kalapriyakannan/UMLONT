/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.commands;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditDomain;
import org.eclipse.gmf.runtime.common.core.command.AbstractCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.part.ISetSelectionTarget;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.CapabilitiesPopupDialog;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.RequirementsPopupDialog;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.UnitFlyOutPropertiesToggler;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.UnitFlyOutPropertiesToggler.UnitFlyOutPropertiesTogglerDialog;

/**
 * @since 1.0
 */
public class NubEditPopUpCommand extends AbstractCommand {

	private PopupDialog nubEditPopUp;

	private ISelectionProvider initialSelectionProvider;

	private final Point _initialLocation;

	private final boolean _isCapability;

	private final EditDomain _domain;

	private final DeployModelObject _dmo;

	private final Shell _shell;

	private final IGraphicalEditPart _editPart;

	private static final int TOP_LEFT = 0;
	private static final int TOP_RIGHT = 1;
	private static final int BOTTOM_RIGHT = 2;
	private static final int BOTTOM_LEFT = 3;

	/**
	 * @param shell
	 * @param dmo
	 * @param isCapability
	 * @param initialLocation
	 * @param aDomain
	 */
	public NubEditPopUpCommand(Shell shell, DeployModelObject dmo, boolean isCapability,
			Point initialLocation, EditDomain aDomain) {
		super(Messages.NubEditPopUpCommand_Show_Services_Reference_);
		_shell = shell;
		_dmo = dmo;
		_editPart = null;
		_isCapability = isCapability;
		_initialLocation = initialLocation;
		_domain = aDomain;
	}

	/**
	 * @param shell
	 * @param dmo
	 * @param initialLocation
	 */
	public NubEditPopUpCommand(Shell shell, DeployModelObject dmo, boolean isCapability,
			IGraphicalEditPart editPart) {
		super(Messages.NubEditPopUpCommand_Show_Services_Reference_);
		_shell = shell;
		_dmo = dmo;
		_isCapability = isCapability;
		_editPart = editPart;
		_initialLocation = null;
		_domain = editPart.getViewer().getEditDomain();
	}

	/**
	 * @return is executable
	 */
	public boolean isExecutable() {
		if (nubEditPopUp != null) {
			return true;
		}
		return false;
	}

	/*
	 * Pops up the dialog with the content provided. If the user selects 'select existing', then the
	 * select elements dialog also appears.
	 * 
	 * @see org.eclipse.gmf.runtime.common.core.command.AbstractCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) {
		if (!_isCapability) {
			nubEditPopUp = new RequirementsPopupDialog(_shell, (Unit) _dmo,
					_initialLocation != null ? _initialLocation : estimate(_editPart, TOP_RIGHT));
		} else if (_dmo instanceof Unit) {
			nubEditPopUp = new CapabilitiesPopupDialog(_shell, (Unit) _dmo,
					_initialLocation != null ? _initialLocation : estimate(_editPart, BOTTOM_LEFT));
		}

		if (nubEditPopUp != null) {
			new UnitFlyOutPropertiesToggler((Unit) _dmo, _domain,
					(UnitFlyOutPropertiesTogglerDialog) nubEditPopUp);
			nubEditPopUp.open();
			if (initialSelectionProvider != null && nubEditPopUp instanceof ISetSelectionTarget) {
				((ISetSelectionTarget) nubEditPopUp).selectReveal(initialSelectionProvider
						.getSelection());
			}
		}
		return CommandResult.newOKCommandResult();
	}

	private static Point estimate(IGraphicalEditPart editPart, int which) {
		IFigure figure = editPart.getFigure();

		org.eclipse.draw2d.geometry.Point pt = null;

		switch (which)
		{
		case TOP_LEFT:
			pt = figure.getBounds().getTopLeft().getCopy();
			break;
		case TOP_RIGHT:
			pt = figure.getBounds().getTopRight().getCopy();
			break;
		case BOTTOM_LEFT:
			pt = figure.getBounds().getBottomLeft().getCopy();
			break;
		case BOTTOM_RIGHT:
		default:
			pt = figure.getBounds().getBottomRight().getCopy();
			break;
		}
		figure.translateToAbsolute(pt);
		org.eclipse.swt.graphics.Point p = new org.eclipse.swt.graphics.Point(0, 0);
		p = editPart.getViewer().getControl().toDisplay(p);
		pt.x += p.x;
		pt.y += p.y;
		return new Point(pt.x, pt.y);
	}

	protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor, IAdaptable info) {
		return null;
	}

	protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor, IAdaptable info) {
		return null;
	}

	public void setInitialSelectionProvider(ISelectionProvider provider) {
		initialSelectionProvider = provider;

	}

}
