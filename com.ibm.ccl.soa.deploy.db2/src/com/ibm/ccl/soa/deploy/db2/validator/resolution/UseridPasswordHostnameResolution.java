/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2.validator.resolution;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.db2.DB2DeployPlugin;
import com.ibm.ccl.soa.deploy.db2.DB2Instance;
import com.ibm.ccl.soa.deploy.db2.DB2InstanceUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.Messages;
import com.ibm.ccl.soa.deploy.db2.internal.validator.util.UseridPasswordHostnameUser;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.User;
import com.ibm.ccl.soa.deploy.os.UserUnit;

/**
 * Resolves an attribute expected value by overwritting the attribute value.
 */
public class UseridPasswordHostnameResolution extends DeployResolution {

	private Unit _unit;
	private UseridPasswordHostnameUser _uphu;

	/**
	 * Construct a resolution over the marker.
	 * 
	 * @param context
	 * @param generator
	 * @param unit
	 */
	public UseridPasswordHostnameResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, Unit unit, UseridPasswordHostnameUser uphu) {
		super(context, generator);
		_unit = unit;
		_uphu = uphu;
		//_uphu.getPassword();
		String passwordDisplayString = "********"; //$NON-NLS-1$
		String params[] = { _uphu.getUserid(), passwordDisplayString, _uphu.getHostname() };
		setDescription(NLS.bind(Messages.Resolution_propagate_userid_0_password_1_hostname_2, params));
		this.setPriority(this.getPriority() + 2);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.ui.marker.resolution.IDeployResolution#resolve(com.ibm.ccl.soa.deploy.core.ui.marker.resolution.IDeployResolutionContext,
	 *      org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		IDeployStatus message = (IDeployStatus) context.getDeployStatus();
		DeployModelObject object = message.getDeployObject();

		try {
			if (object instanceof DB2InstanceUnit) {
				DB2Instance db2Instance = (DB2Instance) ValidatorUtils.getFirstCapability(_unit,
						Db2Package.Literals.DB2_INSTANCE);
				assert (db2Instance != null);
				assert (object.equals(_unit));
				db2Instance.setHostname(_uphu.getHostname());
				db2Instance.setUsername(_uphu.getUserid());
				db2Instance.setPassword(_uphu.getPassword());
				Topology topology = context.getTopology().getEditTopology();

				UserUnit userUnit = (UserUnit) _uphu.getUserUD().getUnitValueAndAddToTopology(topology);
				User user = (User) ValidatorUtils.getFirstCapability(userUnit, OsPackage.Literals.USER);

				LinkDescriptor linkDescriptor = new LinkDescriptor(LinkType.DEPENDENCY, _unit, _uphu
						.getUserReq(), userUnit, user);

				Unit tmpUnit = (Unit) userUnit;
				while (tmpUnit.isConfigurationUnit()) {
					UnitDescriptor tmpUD = TopologyDiscovererService.INSTANCE.findHostUD(tmpUnit,
							topology);
					if (tmpUD == null) {
						break;
					}
					tmpUnit = tmpUD.getUnitValueAndAddToTopology(topology);
				}
				linkDescriptor.create();

			}
			return Status.OK_STATUS;
		} catch (Throwable e) {
			return new Status(IStatus.ERROR, DB2DeployPlugin.PLUGIN_ID, 0,
					Messages.Userid_password_hostname_propagation_exception, e);
		}
	}
}
