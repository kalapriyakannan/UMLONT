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

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.CapabilitiesListComposite;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.CapabilitiesToolBarManager;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.DmoPrimaryPopupDialog;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.UnsetInterface;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.CapabilitiesToolBarManager.CapabilitiesToolBarHelper;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.UnitFlyOutPropertiesToggler.UnitFlyOutPropertiesTogglerDialog;

/**
 * This dialog appears when the 'capabilities' icon/button is clicked on a diagram {@link Unit}. It
 * presents a tree of the {@link Capability}s and {@link Interface}s.
 * 
 * @author Ed Snible
 * @see RequirementsPopupDialog
 * @see CapabilitiesToolBarManager
 * @see CapabilitiesListComposite
 */
public class CapabilitiesPopupDialog extends DmoPrimaryPopupDialog implements
		CapabilitiesToolBarHelper, UnitFlyOutPropertiesTogglerDialog {

	private CapabilitiesToolBarManager capToolBar;
	private CapabilitiesListComposite listComposite;

	/**
	 * @param shell
	 * @param unit
	 * @param initialPoint
	 */
	public CapabilitiesPopupDialog(Shell shell, Unit unit, Point initialPoint) {
		super(shell, unit, initialPoint, null, Messages.NubEditDialog_Select_on_capability_to_modif_);
	}

	/**
	 * @param shell
	 * @param unit
	 * @param initialPoint
	 * @param infoText
	 *           Text to appear at the bottom of the dialog.
	 */
	public CapabilitiesPopupDialog(Shell shell, Unit unit, Point initialPoint, String infoText) {
		super(shell, unit, initialPoint, null, infoText);
	}

	@Override
	protected boolean canReuseDetailDialog(Object currentInput, Object newInput) {
		return false;
	}

	@Override
	protected boolean canShowDetails(Object object) {
		return object instanceof Capability || object instanceof Interface
				|| object instanceof UnsetInterface;
	}

	@Override
	protected PopupDialog createDetailDialog(Object selectedObject) {
		if (selectedObject instanceof Interface) {
			Interface ifaceToEdit = (Interface) selectedObject;
			if (ifaceToEdit.eContainer() != null) {
				return new InterfaceEditPopupDialog(getShell(), null, ifaceToEdit);
			}

		} else if (selectedObject instanceof DeployModelObject) {
			DeployModelObject dmoToEdit = (DeployModelObject) selectedObject;
			if (dmoToEdit.eContainer() != null) {
				return new NubEditPopupDialog(getShell(), null, dmoToEdit);
			}
		}

		return null;
	}

	@Override
	protected Composite doCreateDialogArea(Composite parent) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_CAPABILITIES_FLYOUT);

		listComposite = new CapabilitiesListComposite(parent, getUnit(), isImportedDmo());
		listComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		capToolBar.setCapabilityListComposite(listComposite);

		Listener listListener = new Listener() {
			public void handleEvent(Event event) {
				if (event.type == SWT.KeyDown && event.character == SWT.DEL) {
					//The delete key was selected.  Execute the delete requirement action.
					capToolBar.invokeDeleteCapabilityItem();
				}
			}
		};

		listComposite.addTreeListener(SWT.KeyDown, listListener);
		//Resize to ensure the filter text is shown.
		listComposite.resizeTree(260);
		return listComposite;
	}

	@Override
	protected TreeViewer getTreeViewer() {
		return listComposite.getTreeViewer();
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
	protected void setDetailDialogInput(PopupDialog detailDialog, Object newInput) {
		// Do nothing.  We already set the input when we created the dialog.
	}

	@Override
	protected void initializeToolBar(Composite parent, ToolBarManager toolBarManager) {
		capToolBar = new CapabilitiesToolBarManager(parent, isImportedDmo(), getUnit(), this,
				toolBarManager);
		capToolBar.addActionsToToolbar();
	}

	private Unit getUnit() {
		return (Unit) dmo;
	}

	public String getSettingsPrefix() {
		return "CapabilitiesPopupDialog"; //$NON-NLS-1$
	}

	public void handleUpdateActionBars() {
		//Update the layout for the title.
		getTitleComposite().layout();
	}

	public void hideCapabilityDetails() {
		closeDetailDialog();
	}

	public void showCapabilityDetails(Capability cap) {
		showDetails(cap);
	}

	/**
	 * Select 'cap', which must be a Capability of the Unit this popup was created with.
	 * 
	 * @param cap
	 */
	public void setSelection(Capability cap) {
		listComposite.setSelection(cap);
	}

	@Override
	public boolean close() {
		if (capToolBar != null) {
			capToolBar.dispose();
		}
		return super.close();
	}

	@Override
	protected void fillDialogMenu(IMenuManager dialogMenu) {
		super.fillDialogMenu(dialogMenu);
		capToolBar.fillMenu(dialogMenu);
	}

	@Override
	public Control getContents() {
		return super.getContents();
	}

	public int getDialogIndex() {
		return CAP_INDEX;
	}

	public void setToggleMessage(String message) {
		setInfoText(message);
	}

	public IToolBarManager getToolBarManager() {
		return capToolBar.getInternalToolBarManager();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List getBackgroundColorExclusions() {
		List result = super.getBackgroundColorExclusions();
		listComposite.addBackgroundExclusions(result);
		return result;
	}

	public void selectReveal(StructuredSelection selection) {
		if (listComposite != null) {
			listComposite.selectReveal(selection);
		}
	}
}
