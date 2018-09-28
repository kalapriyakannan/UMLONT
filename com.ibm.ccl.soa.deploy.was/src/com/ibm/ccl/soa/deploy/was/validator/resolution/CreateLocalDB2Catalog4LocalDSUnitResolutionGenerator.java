/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.validator.resolution;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode;
import com.ibm.ccl.soa.deploy.db2.DB2ClientInstanceUnit;
import com.ibm.ccl.soa.deploy.db2.DB2Database;
import com.ibm.ccl.soa.deploy.db2.DB2NodeCatalogUnit;
import com.ibm.ccl.soa.deploy.db2.DB2RuntimeClientUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.IDb2TemplateConstants;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.was.WasDatasource;
import com.ibm.ccl.soa.deploy.was.WasDatasourceUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

public class CreateLocalDB2Catalog4LocalDSUnitResolutionGenerator extends DeployResolutionGenerator {

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		//IDeployResolution[] result;
		IDeployStatus status = context.getDeployStatus();
		WasDatasourceUnit dsUnit = (WasDatasourceUnit) status.getDeployObject();
		String validatorID = context.getDeployStatus().getValidatorID();
		//TODO remove this use of bindings to pass parameters, use attribute instead
		if (status.getBindings()[0] instanceof Unit) {
			Unit nearestUnit = (Unit) status.getBindings()[0];
			if (nearestUnit == null) {
				return new IDeployResolution[0];
			}

			if (IWasValidatorID.WAS_VALIDAT_DB2_DATASOURCEUNIT_LOCAL_CATALOG_001.equals(validatorID)
					&& nearestUnit instanceof OperatingSystemUnit) {
				return new IDeployResolution[] { new CreateDSUnitCorrespondingLocalCatalogUnitResolution_01(
						context, this, dsUnit, nearestUnit) };
			}
			if (IWasValidatorID.WAS_VALIDAT_DB2_DATASOURCEUNIT_LOCAL_CATALOG_002.equals(validatorID)
					&& nearestUnit instanceof DB2RuntimeClientUnit) {
				return new IDeployResolution[] { new CreateDSUnitCorrespondingLocalCatalogUnitResolution_02(
						context, this, dsUnit, nearestUnit) };
			}
			if (IWasValidatorID.WAS_VALIDAT_DB2_DATASOURCEUNIT_LOCAL_CATALOG_003.equals(validatorID)
					&& nearestUnit instanceof DB2ClientInstanceUnit) {
				return new IDeployResolution[] { new CreateDSUnitCorrespondingLocalCatalogUnitResolution_03(
						context, this, dsUnit, nearestUnit) };
			}
			if (IWasValidatorID.WAS_VALIDAT_DB2_DATASOURCEUNIT_LOCAL_CATALOG_004.equals(validatorID)
					&& nearestUnit instanceof DB2NodeCatalogUnit) {
				return new IDeployResolution[] { new CreateDSUnitCorrespondingLocalCatalogUnitResolution_04(
						context, this, dsUnit, nearestUnit) };
			}
		} else if (status.getBindings()[0] instanceof List
				&& IWasValidatorID.WAS_VALIDAT_DB2_DATASOURCEUNIT_LOCAL_CATALOG_006.equals(validatorID)) {
			List osUnitL = (List) status.getBindings()[0];
			if (osUnitL == null || osUnitL.size() <= 0) {
				return new IDeployResolution[0];
			}

			return new IDeployResolution[] { new CreateDSUnitCorrespondingLocalCatalogUnitResolution_06(
					context, this, dsUnit, osUnitL) };
		}

		return new IDeployResolution[0];
	}

	public boolean hasResolutions(IDeployResolutionContext context) {
		// MK 8/23/2007: disabled resolution generation until contract aware
//		IDeployStatus status = context.getDeployStatus();
//		if (!IWASProblemType.DB2_DATASOURCEUNIT_MISSING_LOCAL_CATALOG.equals(status.getProblemType())) {
//			return false;
//		}
//		if (!(status.getDeployObject() instanceof WasDatasourceUnit)) {
//			return false;
//		}
//		if (status.getBindings() == null
//				|| !(status.getBindings()[0] instanceof Unit || status.getBindings()[0] instanceof List)) {
//			return false;
//		}
//
//		String validatorID = context.getDeployStatus().getValidatorID();
//		if (IWasValidatorID.WAS_VALIDAT_DB2_DATASOURCEUNIT_LOCAL_CATALOG_001.equals(validatorID)
//				|| IWasValidatorID.WAS_VALIDAT_DB2_DATASOURCEUNIT_LOCAL_CATALOG_002.equals(validatorID)
//				|| IWasValidatorID.WAS_VALIDAT_DB2_DATASOURCEUNIT_LOCAL_CATALOG_003.equals(validatorID)
//				|| IWasValidatorID.WAS_VALIDAT_DB2_DATASOURCEUNIT_LOCAL_CATALOG_004.equals(validatorID)
//				|| IWasValidatorID.WAS_VALIDAT_DB2_DATASOURCEUNIT_LOCAL_CATALOG_006.equals(validatorID)) {
//			return true;
//		}

		return false;
	}

	private static class CreateDSUnitCorrespondingLocalCatalogUnitResolution_06 extends
			DeployResolution {
		private final WasDatasourceUnit _dsUnit;
		private final List _osUnitL;

		public CreateDSUnitCorrespondingLocalCatalogUnitResolution_06(
				IDeployResolutionContext context, IDeployResolutionGenerator generator,
				WasDatasourceUnit dsUnit, List osUnitL) {
			super(
					context,
					generator,
					DeployNLS
							.bind(
									WasDomainMessages.Resolution_create_corresponding_local_db2_catalogUnit_for_datasourceUnit_0,
									dsUnit));
			_dsUnit = dsUnit;
			_osUnitL = osUnitL;
		}

		public IStatus resolve(IProgressMonitor monitor) {
			Iterator osUnitIt = _osUnitL.iterator();
			while (osUnitIt.hasNext()) {
				Unit osUnit = (Unit) osUnitIt.next();
				List db2runtimeClientL = ValidatorUtils.getHosted(osUnit,
						Db2Package.Literals.DB2_RUNTIME_CLIENT_UNIT);
				if (db2runtimeClientL == null || db2runtimeClientL.size() <= 0) {
					DB2RuntimeClientUnit runtimeClientUnit = createDB2RuntimeClientONOSUnit(osUnit,
							context);
					Unit clientInstanceUnit = createDB2clientInstanceOntoRuntimeClient(
							runtimeClientUnit, context);
					Unit db2NodeCatalogUnit = createDB2NodeCatalogOntoclientInstance(clientInstanceUnit,
							context);
					DB2Database dataBaseCap = createDB2CatalogUnitOntoDB2NodeCatalogUnit(
							db2NodeCatalogUnit, context);
					assert dataBaseCap != null;
					WasDatasource dscap = (WasDatasource) ValidatorUtils.getCapability(_dsUnit,
							WasPackage.Literals.WAS_DATASOURCE);
					dataBaseCap.setDbName(dscap.getDbName());
					continue;
				}

				DB2RuntimeClientUnit db2runtimeClientUnit = (DB2RuntimeClientUnit) db2runtimeClientL
						.get(0); //no need to create 2 runtime client on a same os
				List db2ClientInstanceUnitL = ValidatorUtils.getHosted(db2runtimeClientUnit,
						Db2Package.Literals.DB2_CLIENT_INSTANCE_UNIT);
				if (db2ClientInstanceUnitL == null || db2ClientInstanceUnitL.size() <= 0) {
					Unit clientInstanceUnit = createDB2clientInstanceOntoRuntimeClient(
							db2runtimeClientUnit, context);
					Unit db2NodeCatalogUnit = createDB2NodeCatalogOntoclientInstance(clientInstanceUnit,
							context);
					DB2Database dataBaseCap = createDB2CatalogUnitOntoDB2NodeCatalogUnit(
							db2NodeCatalogUnit, context);
					assert dataBaseCap != null;
					WasDatasource dscap = (WasDatasource) ValidatorUtils.getCapability(_dsUnit,
							WasPackage.Literals.WAS_DATASOURCE);
					dataBaseCap.setDbName(dscap.getDbName());
					continue;
				}

				Iterator clientInsatanceUnitIt = db2ClientInstanceUnitL.iterator();
				while (clientInsatanceUnitIt.hasNext()) {
					DB2ClientInstanceUnit instanceUnit = (DB2ClientInstanceUnit) clientInsatanceUnitIt
							.next();
					List temp = ValidatorUtils.getHosted(instanceUnit,
							Db2Package.Literals.DB2_NODE_CATALOG_UNIT);
					if (temp != null && temp.size() > 0) {
						DB2NodeCatalogUnit db2NodeCatalogUnit = (DB2NodeCatalogUnit) temp.get(0);
						DB2Database dataBaseCap = createDB2CatalogUnitOntoDB2NodeCatalogUnit(
								db2NodeCatalogUnit, context);
						assert dataBaseCap != null;
						WasDatasource dscap = (WasDatasource) ValidatorUtils.getCapability(_dsUnit,
								WasPackage.Literals.WAS_DATASOURCE);
						dataBaseCap.setDbName(dscap.getDbName());
						continue;
					}
					Unit db2NodeCatalogUnit = createDB2NodeCatalogOntoclientInstance(instanceUnit,
							context);
					DB2Database dataBaseCap = createDB2CatalogUnitOntoDB2NodeCatalogUnit(
							db2NodeCatalogUnit, context);
					assert dataBaseCap != null;
					WasDatasource dscap = (WasDatasource) ValidatorUtils.getCapability(_dsUnit,
							WasPackage.Literals.WAS_DATASOURCE);
					dataBaseCap.setDbName(dscap.getDbName());
					continue;
				}
			}
			return Status.OK_STATUS;
		}

	}

	/**
	 * local OS has a list of db2nodecatalogs, but they all don't have a satisfied db2 catalog create
	 * a satisfied db2 catalog for the given nodecatalog
	 * 
	 * @since 3.2
	 * 
	 */
	private static class CreateDSUnitCorrespondingLocalCatalogUnitResolution_04 extends
			DeployResolution {
		private final WasDatasourceUnit _dsUnit;
		private final Unit _db2NodeCatalogUnit;

		public CreateDSUnitCorrespondingLocalCatalogUnitResolution_04(
				IDeployResolutionContext context, IDeployResolutionGenerator generator,
				WasDatasourceUnit dsUnit, Unit nearestUnit) {
			super(
					context,
					generator,
					DeployNLS
							.bind(
									WasDomainMessages.Resolution_create_corresponding_local_db2_catalogUnit_for_datasourceUnit_0_on_DB2NodeCatalogUnit_1,
									dsUnit, nearestUnit));
			_dsUnit = dsUnit;
			_db2NodeCatalogUnit = nearestUnit;

		}

		public IStatus resolve(IProgressMonitor monitor) {
			//create db2 catalog
			DB2Database dataBaseCap = createDB2CatalogUnitOntoDB2NodeCatalogUnit(_db2NodeCatalogUnit,
					context);

			assert dataBaseCap != null;
			WasDatasource dscap = (WasDatasource) ValidatorUtils.getCapability(_dsUnit,
					WasPackage.Literals.WAS_DATASOURCE);
			dataBaseCap.setDbName(dscap.getDbName());
			return Status.OK_STATUS;
		}
	}

	/**
	 * local OS has a db2 runtime client, with the input client instance, create the corresponding
	 * catalog onto the instance
	 * 
	 * @since 3.2
	 * 
	 */
	private static class CreateDSUnitCorrespondingLocalCatalogUnitResolution_03 extends
			DeployResolution {
		private final WasDatasourceUnit _dsUnit;
		private final Unit _db2ClientInstanceUnit;

		public CreateDSUnitCorrespondingLocalCatalogUnitResolution_03(
				IDeployResolutionContext context, IDeployResolutionGenerator generator,
				WasDatasourceUnit dsUnit, Unit nearestUnit) {
			super(
					context,
					generator,
					DeployNLS
							.bind(
									WasDomainMessages.Resolution_create_corresponding_local_db2_catalogUnit_for_datasourceUnit_0_on_DB2ClientInstance_1,
									dsUnit, nearestUnit));
			_dsUnit = dsUnit;
			_db2ClientInstanceUnit = nearestUnit;
		}

		public IStatus resolve(IProgressMonitor monitor) {
			//create db2 node catalog
			Unit db2NodeCatalogUnit = createDB2NodeCatalogOntoclientInstance(_db2ClientInstanceUnit,
					context);

			//create db2 catalog
			DB2Database dataBaseCap = createDB2CatalogUnitOntoDB2NodeCatalogUnit(db2NodeCatalogUnit,
					context);

			assert dataBaseCap != null;
			WasDatasource dscap = (WasDatasource) ValidatorUtils.getCapability(_dsUnit,
					WasPackage.Literals.WAS_DATASOURCE);
			dataBaseCap.setDbName(dscap.getDbName());
			return Status.OK_STATUS;
		}
	}

	/**
	 * Local OS has a db2 runtime client
	 * 
	 * @since 3.2
	 * 
	 */
	private static class CreateDSUnitCorrespondingLocalCatalogUnitResolution_02 extends
			DeployResolution {
		private final WasDatasourceUnit _dsUnit;
		private final Unit _db2runtimeClientUnit;

		public CreateDSUnitCorrespondingLocalCatalogUnitResolution_02(
				IDeployResolutionContext context, IDeployResolutionGenerator generator,
				WasDatasourceUnit dsUnit, Unit nearestUnit) {
			super(
					context,
					generator,
					DeployNLS
							.bind(
									WasDomainMessages.Resolution_create_corresponding_local_db2_catalogUnit_for_datasourceUnit_0_on_DB2RuntimeClient_unit_1,
									dsUnit, nearestUnit));
			_dsUnit = dsUnit;
			_db2runtimeClientUnit = nearestUnit;
		}

		public IStatus resolve(IProgressMonitor monitor) {
			//create db2 client instance
			Unit clientInstanceUnit = createDB2clientInstanceOntoRuntimeClient(_db2runtimeClientUnit,
					context);

			//create db2 node catalog
			Unit db2NodeCatalogUnit = createDB2NodeCatalogOntoclientInstance(clientInstanceUnit,
					context);

			//create db2 catalog
			DB2Database dataBaseCap = createDB2CatalogUnitOntoDB2NodeCatalogUnit(db2NodeCatalogUnit,
					context);

			assert dataBaseCap != null;
			WasDatasource dscap = (WasDatasource) ValidatorUtils.getCapability(_dsUnit,
					WasPackage.Literals.WAS_DATASOURCE);
			dataBaseCap.setDbName(dscap.getDbName());
			return Status.OK_STATUS;
		}

	}

	/**
	 * ds's local OS has no client runtime at all
	 * 
	 * @since 3.2
	 * 
	 */
	private static class CreateDSUnitCorrespondingLocalCatalogUnitResolution_01 extends
			DeployResolution {
		private final WasDatasourceUnit _dsUnit;
		private final Unit _osUnit;

		public CreateDSUnitCorrespondingLocalCatalogUnitResolution_01(
				IDeployResolutionContext context, IDeployResolutionGenerator generator,
				WasDatasourceUnit dsUnit, Unit osUnit) {
			super(
					context,
					generator,
					DeployNLS
							.bind(
									WasDomainMessages.Resolution_create_corresponding_local_db2_catalogUnit_for_datasourceUnit_0_on_OS_unit_1,
									dsUnit, osUnit));
			_dsUnit = dsUnit;
			_osUnit = osUnit;
		}

		public IStatus resolve(IProgressMonitor monitor) {
			//create db2 runtime client unit from template
			DB2RuntimeClientUnit runtimeClientUnit = createDB2RuntimeClientONOSUnit(_osUnit, context);

			//create db2 client instance
			Unit clientInstanceUnit = createDB2clientInstanceOntoRuntimeClient(runtimeClientUnit,
					context);

			//create db2 node catalog
			Unit db2NodeCatalogUnit = createDB2NodeCatalogOntoclientInstance(clientInstanceUnit,
					context);

			//create db2 catalog
			DB2Database dataBaseCap = createDB2CatalogUnitOntoDB2NodeCatalogUnit(db2NodeCatalogUnit,
					context);

			assert dataBaseCap != null;
			WasDatasource dscap = (WasDatasource) ValidatorUtils.getCapability(_dsUnit,
					WasPackage.Literals.WAS_DATASOURCE);
			dataBaseCap.setDbName(dscap.getDbName());
			return Status.OK_STATUS;
		}
	}

	private static DB2RuntimeClientUnit createDB2RuntimeClientONOSUnit(Unit _osUnit,
			IDeployResolutionContext context) {
		DB2RuntimeClientUnit runtimeClientUnit = (DB2RuntimeClientUnit) ResolutionUtils
				.addFromTemplate(IDb2TemplateConstants.DB2_RUNTIME_CLIENT_UNIT, _osUnit.getTopology());
		assert ValidatorUtils.getCapability(runtimeClientUnit, Db2Package.Literals.DB2_CLIENT) != null;
		runtimeClientUnit
				.setDisplayName(WasDomainMessages.Resolution_create_runtime_client_description);
		ResolutionUtils.hosts(context, _osUnit, runtimeClientUnit);
		return runtimeClientUnit;
	}

	/**
	 * create db2 catalog onto db2 node catalog unit from template
	 * 
	 * @param runtimeClientUnit
	 * @return clientInstanceUnit
	 */
	private static DB2Database createDB2CatalogUnitOntoDB2NodeCatalogUnit(Unit db2NodeCatalogUnit,
			IDeployResolutionContext context) {
		assert db2NodeCatalogUnit != null;
		assert db2NodeCatalogUnit instanceof DB2NodeCatalogUnit;

		Unit db2catalogUnit = (Unit) ResolutionUtils.addFromTemplate(
				IDb2TemplateConstants.DB2_CATALOG_UNIT, db2NodeCatalogUnit.getTopology());
		DB2Database databaseCap = (DB2Database) ValidatorUtils.getCapability(db2catalogUnit,
				Db2Package.Literals.DB2_DATABASE);
		assert databaseCap != null;
		db2catalogUnit
				.setDisplayName(WasDomainMessages.Resolution_create_database_catalog_description);
		ResolutionUtils.hosts(context, db2NodeCatalogUnit, db2catalogUnit);
		return databaseCap;
	}

	/**
	 * create db2 node catalog unit onto db2 client instanceUnit from template
	 * 
	 * @param runtimeClientUnit
	 * @return db2NodeCatalogUnit
	 */
	private static Unit createDB2NodeCatalogOntoclientInstance(Unit clientInstanceUnit,
			IDeployResolutionContext context) {
		assert clientInstanceUnit != null;
		assert clientInstanceUnit instanceof DB2ClientInstanceUnit;

		Unit db2NodeCatalogUnit = (Unit) ResolutionUtils.addFromTemplate(
				IDb2TemplateConstants.DB2_NODE_CATALOG_UNIT, clientInstanceUnit.getTopology());
		DB2CatalogedNode db2CatalogedNodeCap = (DB2CatalogedNode) ValidatorUtils.getCapability(
				db2NodeCatalogUnit, Db2Package.Literals.DB2_CATALOGED_NODE);
		assert db2CatalogedNodeCap != null;
		db2CatalogedNodeCap.setNodeName(WasDomainMessages.Resolution_create_node_catalog_description);
		clientInstanceUnit
				.setDisplayName(WasDomainMessages.Resolution_create_node_catalog_description);
		ResolutionUtils.hosts(context, clientInstanceUnit, db2NodeCatalogUnit);
		return db2NodeCatalogUnit;
	}

	/**
	 * create db2 client instanceUnit onto runtimeclient unit from template
	 * 
	 * @param runtimeClientUnit
	 * @return clientInstanceUnit
	 */
	private static Unit createDB2clientInstanceOntoRuntimeClient(Unit runtimeClientUnit,
			IDeployResolutionContext context) {
		assert runtimeClientUnit != null;
		assert runtimeClientUnit instanceof DB2RuntimeClientUnit;

		Unit clientInstanceUnit = (Unit) ResolutionUtils.addFromTemplate(
				IDb2TemplateConstants.DB2_CLIENT_INSTANCE_UNIT, runtimeClientUnit.getTopology());
		assert ValidatorUtils.getCapability(runtimeClientUnit, Db2Package.Literals.DB2_CLIENT) != null;
		clientInstanceUnit
				.setDisplayName(WasDomainMessages.Resolution_create_client_instance_description);
		ResolutionUtils.hosts(context, runtimeClientUnit, clientInstanceUnit);
		return clientInstanceUnit;
	}
}
