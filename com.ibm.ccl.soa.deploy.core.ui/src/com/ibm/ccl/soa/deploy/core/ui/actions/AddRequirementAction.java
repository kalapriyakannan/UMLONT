/***************************************************************************************************
 * Copyright (c) 2008 IBM Corporation. All rights reserved.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.actions;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.properties.Messages;

/**
 * An Action used to create a new Requirement for a given {@link Unit}.
 * 
 */
public class AddRequirementAction extends AbstractAddUnitPropertiesAction {
	/**
	 * 
	 */
	public AddRequirementAction(IWorkbenchPage page) {
		super(page);
		setId(DeployActionIds.ACTION_ADD_REQUIREMENT);
		setText(Messages.RequirementsPropertySection5_Add_Requiremen_);
		setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages().getImageDescriptor(
				ISharedImages.IMG_ADD_REQUIREMENT));
		setDisabledImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_ADD_REQUIREMENT_DISABLED));
		setToolTipText(Messages.RequirementsPropertySection5_Add_Requiremen_);
	}

	protected String getOperationTitle() {
		return Messages.RequirementsPropertySection5_Add_Requiremen_;
	}

	@Override
	protected DeployModelObject createDmo() {
		return CoreFactory.eINSTANCE.createRequirement();
	}

	@Override
	protected UnitPropertyFlyoutHandler createUnitPropertyFlyoutHandler() {
		return new OpenRequirementsFlyout();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected CommandResult doRun(Unit owner, DeployModelObject newDmo) {
		newDmo.setName(generateUniqueName(owner));
		owner.getRequirements().add(newDmo);
		return null;
	}

	private String generateUniqueName(Unit owner) {
		List<String> names = getReqNames(owner);
		int cnt = 0;
		String candidate = "r0"; //$NON-NLS-1$
		while (names.contains(candidate)) {
			candidate = "r" + ++cnt; //$NON-NLS-1$
		}

		return candidate;
	}

	private List<String> getReqNames(Unit owner) {
		List<String> retVal = new LinkedList<String>();
		for (Iterator<Requirement> it = owner.getRequirements().iterator(); it.hasNext();) {
			Requirement req = it.next();
			retVal.add(req.getName());
		}
		return retVal;
	}

}
