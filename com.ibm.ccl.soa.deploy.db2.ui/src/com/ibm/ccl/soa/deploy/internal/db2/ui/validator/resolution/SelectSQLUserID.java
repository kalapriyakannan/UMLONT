/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.db2.ui.validator.resolution;

import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.database.SQLModule;
import com.ibm.ccl.soa.deploy.database.SQLUser;
import com.ibm.ccl.soa.deploy.db2.DB2DeployPlugin;
import com.ibm.ccl.soa.deploy.db2.internal.validator.DB2ValidatorUtils;
import com.ibm.ccl.soa.deploy.os.User;

/**
 * Resolves an attribute expected value by overwritting the attribute value.
 */
public class SelectSQLUserID extends DeployResolution {

	/**
	 * Construct a resolution over the status
	 * 
	 * @param context
	 * @param generator
	 */
	public SelectSQLUserID(IDeployResolutionContext context, IDeployResolutionGenerator generator) {
		super(context, generator);
		// This is a very specific resolution so bump priority
		setPriority(getPriority() + 1);
		setDescription(Messages.SQLUserID);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.ui.marker.resolution.IDeployResolution#resolve(com.ibm.ccl.soa.deploy.core.ui.marker.resolution.IDeployResolutionContext,
	 *      org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		IDeployStatus message = context.getDeployStatus();
		SQLUser sqlUser = (SQLUser) message.getDeployObject();

		try {
			if (sqlUser.getParent() instanceof SQLModule) {
				Map<String, Capability> usersMap = DB2ValidatorUtils
						.getUsersOnHostingOS((SQLModule) sqlUser.getParent());
				if (usersMap != null && usersMap.size() > 0) {
					String users[] = usersMap.keySet().toArray(new String[usersMap.size()]);
					SelectSQLUserDialog dlg = new SelectSQLUserDialog(new Shell(), users);
					dlg.create();
					if (dlg.open() == Window.OK) {
						int userIndex = dlg.getUserIndex();
						User u = (User) usersMap.get(users[userIndex]);
						sqlUser.setUserId(u.getUserId());
						sqlUser.setUserPassword(u.getUserPassword());
						return Status.OK_STATUS;
					}
				}
			}
			return Status.CANCEL_STATUS;
		} catch (Throwable e) {
			return new Status(IStatus.ERROR, DB2DeployPlugin.PLUGIN_ID, 0,
					Messages.SelectSQLUserID_resolution_exception, e);
		}
	}
}
