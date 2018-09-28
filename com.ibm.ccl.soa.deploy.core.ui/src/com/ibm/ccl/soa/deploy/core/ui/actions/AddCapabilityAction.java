/***************************************************************************************************
 * Copyright (c) 2008 IBM Corporation. All rights reserved.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.actions;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.NewCapabilityCreationDialog;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;

/**
 * A UI action to create a new {@link Capability} for a {@link Unit}. The action will prompt the
 * user to select the capability type to create.
 * 
 */
public class AddCapabilityAction extends AbstractAddUnitPropertiesAction {

	/**
	 * @param workbenchPage
	 */
	public AddCapabilityAction(IWorkbenchPage workbenchPage) {
		super(workbenchPage);
		setId(DeployActionIds.ACTION_ADD_CAPABILITY);
		setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages().getImageDescriptor(
				ISharedImages.IMG_ADD_CAPABILITY));
		setToolTipText(com.ibm.ccl.soa.deploy.core.ui.Messages.NubEditDialog_Add_Capabilit_);
		setText(com.ibm.ccl.soa.deploy.core.ui.Messages.NubEditDialog_Add_Capabilit_);
	}

	protected String getOperationTitle() {
		return com.ibm.ccl.soa.deploy.core.ui.Messages.NubEditDialog_Add_Capabilit_;
	}

	@Override
	protected DeployModelObject createDmo() {
		Capability cap = null;
		//Launch dialog

		Shell shell = Display.getCurrent().getActiveShell();
		final List<Object> list = new LinkedList<Object>();
		BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
			public void run() {
				list.addAll(PropertyUtils.getBankedCapabilities());
				list.addAll(PropertyUtils.getInstantiatableCapTypeNames());
			}
		});
		ElementListSelectionDialog dlg = new NewCapabilityCreationDialog(shell, PropertyUtils
				.getSoaLabelProvider());
		dlg
				.setTitle(com.ibm.ccl.soa.deploy.core.ui.properties.Messages.NewCapabilityDialog_ADD_CAPABILITY);
		dlg.setHelpAvailable(false);
		dlg.setElements(list.toArray());
		if (dlg.open() == Window.OK) {
			Object sel = dlg.getFirstResult();
			if (sel instanceof Capability) {
				cap = (Capability) sel;
				cap = (Capability) EcoreUtil.copy(cap);
			} else if (sel instanceof String) {
				String ecName = (String) sel;
				cap = PropertyUtils.createCapability(ecName);
			}
		}
		return cap;
	}

	@Override
	protected UnitPropertyFlyoutHandler createUnitPropertyFlyoutHandler() {
		return new OpenCapabilitiesFlyout();
	}

	@Override
	protected boolean canEditUnit(Unit owner) {
		return super.canEditUnit(owner) && owner.isPublicEditable();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected CommandResult doRun(Unit owner, DeployModelObject newDmo) {
		String name = UnitUtil.generateUniqueName(owner, newDmo.eClass().getName());
		newDmo.setName(name);
		newDmo.setDisplayName(name);
		owner.getCapabilities().add(newDmo);
		return null;
	}
}
