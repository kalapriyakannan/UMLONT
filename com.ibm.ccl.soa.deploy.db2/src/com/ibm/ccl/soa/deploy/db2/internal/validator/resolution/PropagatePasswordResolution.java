/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2.internal.validator.resolution;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.db2.DB2DeployPlugin;
import com.ibm.ccl.soa.deploy.db2.DB2Instance;
import com.ibm.ccl.soa.deploy.db2.Messages;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.User;

/**
 * Propagate password from linked OS user to instance admin user password.
 */
public class PropagatePasswordResolution extends DeployResolution {

	private User userCap;
	private Unit userUnit;
	private String userTitle;

	/**
	 * Construct a resolution over the marker.
	 * 
	 * @param context
	 * @param generator
	 * @param unit
	 */
	public PropagatePasswordResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, Unit unit) {
		super(context, generator);

		// Assume password always encrypted, if not then metadata missing.
		//    	AttributeMetaData md = dmo.getAttributeMetaData(esf.getName()); 
		//		if (md != null) {
		//			return md.isEncrypted();
		//		}
		setup(unit);
		String params[] = { userTitle };
		setDescription(NLS.bind(Messages.Resolution_propagate_password_from_user_0, params));
		//		this.setPriority(this.getPriority()+1);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.ui.marker.resolution.IDeployResolution#resolve(com.ibm.ccl.soa.deploy.core.ui.marker.resolution.IDeployResolutionContext,
	 *      org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		IDeployStatus message = context.getDeployStatus();
		DeployModelObject object = message.getDeployObject();

		try {
			if (object instanceof DB2Instance) {
				DB2Instance db2Instance = (DB2Instance) object;
				if (userCap != null) {
					db2Instance.setPassword(userCap.getUserPassword());
				} else {
					// Failure should be impossible.
					throw new Exception();
				}
			}
			return Status.OK_STATUS;
		} catch (Throwable e) {
			return new Status(IStatus.ERROR, DB2DeployPlugin.PLUGIN_ID, 0,
					Messages.Password_propagation_exception, e);
		}
	}

	private void setup(Unit unit) {
		if (unit == null) {
			return;
		}
		Requirement userReq = ValidatorUtils.getFirstRequirement(unit, OsPackage.Literals.USER);
		if (userReq == null) {
			return;
		}
		Capability userReqTarget = ValidatorUtils.discoverDependencyLinkTarget(userReq, null);
		if (!(userReqTarget instanceof User)) {
			return;
		}
		userCap = (User) userReqTarget;
		userUnit = (Unit) userCap.getParent();
		if (userUnit != null) {
			userTitle = userUnit.getCaptionProvider().titleWithContext(userUnit);
		}
	}
}
