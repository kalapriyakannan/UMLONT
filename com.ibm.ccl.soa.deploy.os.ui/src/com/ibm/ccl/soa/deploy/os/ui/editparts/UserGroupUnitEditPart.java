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
import com.ibm.ccl.soa.deploy.core.ui.editparts.UnitGroupEditPart;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.os.AIXLocalGroupUnit;
import com.ibm.ccl.soa.deploy.os.LinuxLocalGroupUnit;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalGroup;
import com.ibm.ccl.soa.deploy.os.SUSELinuxLocalGroup;
import com.ibm.ccl.soa.deploy.os.UserGroup;
import com.ibm.ccl.soa.deploy.os.UserGroupUnit;
import com.ibm.ccl.soa.deploy.os.WindowsLocalGroupUnit;
import com.ibm.ccl.soa.deploy.os.ui.OsUIMessages;
import com.ibm.ccl.soa.deploy.os.ui.figures.OsFigureFactory;

/**
 * Holds a logical node, which is a container capable of holding deployable units.
 */
public class UserGroupUnitEditPart extends UnitGroupEditPart {
	/**
	 * @param view
	 */
	public UserGroupUnitEditPart(View view) {
		super(view);
		// determine figure category description
		Unit unit = (Unit) ViewUtil.resolveSemanticElement((View) getModel());
		if (unit == null) {
			return;
		}

		if (unit instanceof WindowsLocalGroupUnit) {
			setCategory(OsUIMessages.UserGroupUnitEditPart_WindowsUserGroup);
		} else if (unit instanceof LinuxLocalGroupUnit) {
			String cat = OsUIMessages.UserGroupUnitEditPart_LinuxUserGroup;
			UserGroup userGroupCap = (UserGroup) ValidatorUtils.getFirstCapability(unit,
					OsPackage.eINSTANCE.getUserGroup());
			if (userGroupCap != null) {
				if (userGroupCap instanceof RedhatLinuxLocalGroup) {
					cat = OsUIMessages.UserGroupUnitEditPart_RedhatLinuxUserGroup;
				} else if (userGroupCap instanceof SUSELinuxLocalGroup) {
					cat = OsUIMessages.UserGroupUnitEditPart_SUSELinuxUserGroup;
				}
			}
			setCategory(cat);
		} else if (unit instanceof AIXLocalGroupUnit) {
			setCategory(OsUIMessages.UserGroupUnitEditPart_AIXUserGroup);
		} else if (unit instanceof UserGroupUnit) {
			setCategory(OsUIMessages.UserGroupUnitEditPart_UserGroup);
		} else {
			setCategory(OsUIMessages.UserGroupUnitEditPart_UserGroup);
		}

	}

	@Override
	protected NodeFigure createMainFigure() {
		NodeFigure f = OsFigureFactory.createNewConfigurationUserGroupFigure();
		f.setLayoutManager(new DelegatingLayout());
		return f;
	}
}
