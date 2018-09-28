/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.os.ui.editparts;

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ConfigurationEditPart;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.os.AIXLocalUserUnit;
import com.ibm.ccl.soa.deploy.os.LinuxLocalUserUnit;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser;
import com.ibm.ccl.soa.deploy.os.SUSELinuxLocalUser;
import com.ibm.ccl.soa.deploy.os.User;
import com.ibm.ccl.soa.deploy.os.UserUnit;
import com.ibm.ccl.soa.deploy.os.WindowsLocalUserUnit;
import com.ibm.ccl.soa.deploy.os.ui.OsUIMessages;
import com.ibm.ccl.soa.deploy.os.ui.figures.OsFigureFactory;

/**
 * Holds a logical node, which is a container capable of holding deployable units.
 */
public class UserUnitEditPart extends ConfigurationEditPart {
	/**
	 * @param view
	 */
	public UserUnitEditPart(View view) {
		super(view);
		// determine figure category description
		Unit unit = (Unit) ViewUtil.resolveSemanticElement((View) getModel());
		if (unit == null) {
			return;
		}
		if (unit instanceof WindowsLocalUserUnit) {
			setCategory(OsUIMessages.UserUnitEditPart_WindowsUser);
		} else if (unit instanceof LinuxLocalUserUnit) {
			String cat = OsUIMessages.UserUnitEditPart_LinuxUser;
			User userCap = (User) ValidatorUtils.getFirstCapability(unit, OsPackage.eINSTANCE
					.getUser());
			if (userCap != null) {
				if (userCap instanceof RedhatLinuxLocalUser) {
					cat = OsUIMessages.UserUnitEditPart_RedhatLinuxUser;
				} else if (userCap instanceof SUSELinuxLocalUser) {
					cat = OsUIMessages.UserUnitEditPart_SUSELinuxUser;
				}
			}
			setCategory(cat);
		} else if (unit instanceof AIXLocalUserUnit) {
			setCategory(OsUIMessages.UserUnitEditPart_AIXUser);
		} else if (unit instanceof UserUnit) {
			setCategory(OsUIMessages.UserUnitEditPart_User);
		} else {
			setCategory(OsUIMessages.UserUnitEditPart_User);
		}

	}

	@Override
	protected NodeFigure createMainFigure() {
		NodeFigure f = OsFigureFactory.createNewConfigurationUserFigure();
		f.setLayoutManager(new DelegatingLayout());
		return f;
	}
}
