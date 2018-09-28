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

import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.RealizationLinkUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.db2.DB2Database;
import com.ibm.ccl.soa.deploy.db2.DB2DatabaseUnit;
import com.ibm.ccl.soa.deploy.db2.DB2Instance;
import com.ibm.ccl.soa.deploy.db2.DB2InstanceUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.IDb2TemplateConstants;

/**
 * Resolution to generate resolutions to add a new {@link DB2DatabaseUnit}.
 */
public class InsertNewDatabaseResolution extends DeployResolution {

	private final Unit _host;
	private final Unit _hostee;
	private final String _dbName;

	/**
	 * Constructor
	 * 
	 * @param context
	 * @param generator
	 * @param description
	 * @param host
	 * @param hostee
	 * @param dbName
	 */
	public InsertNewDatabaseResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, String description, Unit host, Unit hostee,
			String dbName) {
		super(context, generator, description);
		_host = host;
		_hostee = hostee;
		_dbName = dbName;
	}

	public IStatus resolve(IProgressMonitor monitor) {

		String dbTemplateId = _host.isConceptual() ? IDb2TemplateConstants.DB2_DATABASE_UNIT_CONCEPTUAL
				: IDb2TemplateConstants.DB2_DATABASE_UNIT;
		Unit db2Unit = (Unit) ResolutionUtils.addFromTemplate(dbTemplateId, context.getTopology());

		// if we know the name, set it
		DB2Database db = (DB2Database) ValidatorUtils.getFirstCapability(db2Unit,
				Db2Package.Literals.DB2_DATABASE);
		if (null == db) {
			return Status.CANCEL_STATUS;
		}
		if (null != _dbName) {
			db.setDbName(_dbName);
		}

		// if we know the db2Version, set it to match
		DB2InstanceUnit realizedInstUnit = (DB2InstanceUnit) RealizationLinkUtil
				.getFinalRealization(_host);
		if (null == realizedInstUnit) {
			return Status.CANCEL_STATUS;
		}
		DB2Instance realizedDbInst = (DB2Instance) ValidatorUtils.getFirstCapability(
				realizedInstUnit, Db2Package.Literals.DB2_INSTANCE);
		if (null == realizedDbInst) {
			return Status.CANCEL_STATUS;
		}
		String db2Version = realizedDbInst.getDb2Version();
		if (null != db2Version) {
			db.setDb2Version(db2Version);
		}

		// create hosting links to existing elements at either end
		HostingLink link = ResolutionUtils.host(_host, db2Unit);
		if (null == link) {
			return Status.CANCEL_STATUS;
		}
		link = ResolutionUtils.host(db2Unit, _hostee);
		if (null == link) {
			return Status.CANCEL_STATUS;
		}

		return Status.OK_STATUS;
	}

}
