/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.dialogs;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.DmoPrimaryPopupDialog;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.RequirementLinkChangeManager;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.RequirementsListComposite;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.RequirementsToolBarManager;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.UnitFlyOutPropertiesToggler;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.UnsetInterface;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.RequirementLinkChangeManager.RequirementLinkChangeHandler;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.RequirementsToolBarManager.RequirementsToolBarHelper;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.UnitFlyOutPropertiesToggler.UnitFlyOutPropertiesTogglerDialog;

/**
 * The pop-up for a list of {@link Requirement}s on a Unit.
 * 
 * @author daberg
 * @see RequirementsListComposite
 */
public class RequirementsPopupDialog extends DmoPrimaryPopupDialog implements
		RequirementLinkChangeHandler, RequirementsToolBarHelper, UnitFlyOutPropertiesTogglerDialog {

	private RequirementsListComposite listComposite;
	private RequirementsToolBarManager reqToolBar;
	private RequirementLinkChangeManager hostingChangeListener;
	private UnitFlyOutPropertiesToggler toggler;

	protected Control control;

	/**
	 * @param parent
	 * @param aUnit
	 * @param initialPoint
	 */
	public RequirementsPopupDialog(Shell parent, Unit aUnit, Point initialPoint) {
		super(parent, aUnit, initialPoint, null,
				com.ibm.ccl.soa.deploy.core.ui.Messages.Select_to_edit_properties);
	}

	/**
	 * @param parent
	 * @param aUnit
	 * @param initialPoint
	 * @param infoText
	 *           Text to appear at the bottom of the dialog.
	 */
	public RequirementsPopupDialog(Shell parent, Unit aUnit, Point initialPoint, String infoText) {
		super(parent, aUnit, initialPoint, null, infoText);
	}

	private Unit getUnit() {
		return (Unit) dmo;
	}

	@Override
	protected Composite doCreateDialogArea(Composite parent) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_REQUIREMENTS_FLYOUT);

		listComposite = new RequirementsListComposite(parent, getUnit(), isImportedDmo(), reqToolBar
				.showHeaders(), reqToolBar.showLinks());
		listComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		reqToolBar.setRequirementListComposite(listComposite);

		Listener listListener = new Listener() {
			public void handleEvent(Event event) {
				if (event.type == SWT.KeyDown && event.character == SWT.DEL) {
					//The delete key was selected.  Execute the delete requirement action.
					reqToolBar.invokeDeleteRequirementItem();
				}
			}
		};
		listComposite.addTreeListener(SWT.KeyDown, listListener);
		//Resize to ensure the filter text is shown.
		listComposite.resizeTree(230);
		return listComposite;
	}

	protected void fillDialogMenu(IMenuManager dialogMenu) {
		super.fillDialogMenu(dialogMenu);
		reqToolBar.fillMenu(dialogMenu);
	}

	/**
	 * Closes this popup. This method is extended to remove the control listener.
	 * 
	 * @return <code>true</code> if the window is (or was already) closed, and <code>false</code>
	 *         if it is still open
	 */
	public boolean close() {
		if (reqToolBar != null) {
			reqToolBar.dispose();
		}
		//Ensure the hostingChangeListener is disposed.
		if (hostingChangeListener != null) {
			hostingChangeListener.dispose();
		}
		return super.close();
	}

	public void showRequirementDetails(Requirement aRequirement) {
		showDetails(aRequirement);
	}

	public String getSettingsPrefix() {
		return "RequirementsPopupDialog"; //$NON-NLS-1$
	}

	public void resizeForLinkColumnVisibilityChange() {
		// We may need to adjust our location if the window is now off the
		// screen of the current monitor.
		Monitor monitor = getActiveMonitor();
		if (monitor != null) {
			Rectangle monitorBounds = monitor.getBounds();
			Rectangle shellBounds = getShell().getBounds();
			Point shellLocation = getShell().getLocation();
			if (shellLocation.x + shellBounds.width > monitorBounds.width + monitorBounds.x) {
				// We are off screen of the current monitor so adjust the location.
				int newX = shellLocation.x
						- (shellLocation.x + shellBounds.width - (monitorBounds.width + monitorBounds.x));
				getShell().setLocation(newX, shellLocation.y);
			}
		}
	}

	@Override
	protected boolean isTextFilterRequired() {
		return true;
	}

	@Override
	protected boolean isToolBarRequired() {
		return true;
	}

	@Override
	protected void initializeToolBar(Composite parent, ToolBarManager toolBarManager) {
		reqToolBar = new RequirementsToolBarManager(parent, isImportedDmo(), getUnit(), this,
				toolBarManager);
		reqToolBar.addActionsToToolbar();
	}

	@Override
	protected boolean canShowDetails(Object object) {
		return object instanceof Requirement || object instanceof Interface
				|| object instanceof UnsetInterface;
	}

	@Override
	protected PopupDialog createDetailDialog(Object selectedObject) {
		if (selectedObject instanceof Requirement) {
			if (((Requirement) selectedObject).eContainer() != null) {
				return new RequirementDetailPopupDialog(getShell(), listComposite
						.getTreeLabelProvider());
			}
		} else if (selectedObject instanceof Interface) {
			if (((Interface) selectedObject).eContainer() != null) {
				return new InterfaceDialog(getShell());
			}
		}
		return null;
	}

	@Override
	protected TreeViewer getTreeViewer() {
		return listComposite.getTreeViewer();
	}

	@Override
	protected void setDetailDialogInput(PopupDialog detailDialog, Object newInput) {
		((RequirementDetailPopupDialog) detailDialog).setInput(newInput);
	}

	/**
	 * Close the detailDialog if it is open.
	 */
	public void hideRequirementDetails() {
		closeDetailDialog();
	}

	@Override
	protected boolean canReuseDetailDialog(Object currentInput, Object newInput) {
		return currentInput instanceof Requirement && newInput instanceof Requirement;
	}

	public void handleUpdateActionBars() {
		//Update the layout for the title.
		getTitleComposite().layout();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * Delegate hosting changes to the listComposite, reqToolBar, and the open
	 * RequirementDetailPopupDialog.
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.ui.internal.properties.HostingLinkChangeListener.HostingLinkChangeHandler#handleHostingChange(org.eclipse.emf.common.notify.Notification)
	 */
	public IStatus handleRequirementLinkChange(Notification notification) {
		if (listComposite != null) {
			listComposite.handleRequirementLinkChange(notification);
		}
		if (reqToolBar != null) {

			reqToolBar.handleRequirementLinkChange(notification);
		}
		RequirementDetailPopupDialog detailDialog = (RequirementDetailPopupDialog) getDetailDialog();
		if (detailDialog != null && detailDialog.getShell() != null
				&& detailDialog.getShell().isVisible()) {
			detailDialog.handleRequirementLinkChange(notification);
		}
		return Status.OK_STATUS;
	}

	@Override
	public int open() {
		//Register to receive hosting link change events.
		hostingChangeListener = new RequirementLinkChangeManager(dmo.getEditTopology(), this);
		return super.open();
	}

	public void selectReveal(IStructuredSelection selection) {
		if (listComposite != null) {
			if (selection.getFirstElement() instanceof Requirement) {
				Requirement req = (Requirement) selection.getFirstElement();
				listComposite.setSelection(req);
			}
		}
	}

	@Override
	protected void closeDetailDialog() {
		if (listComposite != null && !listComposite.isDisposed()
				&& listComposite.isPreservingSelection()) {
			//Ignore close for now.
			return;
		}
		super.closeDetailDialog();
	}

	@Override
	public Control getContents() {
		return super.getContents();
	}

	public int getDialogIndex() {
		return REQ_INDEX;
	}

	public void setToggleMessage(String message) {
		setInfoText(message);
	}

	public IToolBarManager getToolBarManager() {
		return reqToolBar.getInternalToolBarManager();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List getBackgroundColorExclusions() {
		List result = super.getBackgroundColorExclusions();
		listComposite.addBackgroundExclusions(result);
		return result;
	}

	@Override
	protected Rectangle getAdjustedDetailDialogBounds() {
		Rectangle rect = super.getAdjustedDetailDialogBounds();
		int width = ((RequirementDetailPopupDialog) detailDialog).getAdjustedWidth(rect.width);
		if (width != rect.width) {
			return new Rectangle(rect.x, rect.y, width, rect.height);
		}
		return rect;
	}
}
