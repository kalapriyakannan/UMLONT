/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DiscoveryFilter;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint;
import com.ibm.ccl.soa.deploy.core.provider.discovery.DiscoveryFilterFactory;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeUniqueInHostValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeStringNotEmptyValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.db2.DB2AdminClientUnit;
import com.ibm.ccl.soa.deploy.db2.DB2BaseClientUnit;
import com.ibm.ccl.soa.deploy.db2.DB2ClientInstanceUnit;
import com.ibm.ccl.soa.deploy.db2.DB2Database;
import com.ibm.ccl.soa.deploy.db2.DB2RuntimeClientUnit;
import com.ibm.ccl.soa.deploy.db2.DB2SystemUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.j2ee.EJBContainer;
import com.ibm.ccl.soa.deploy.j2ee.EJBContainerVersion;
import com.ibm.ccl.soa.deploy.j2ee.J2EEContainer;
import com.ibm.ccl.soa.deploy.j2ee.J2EEContainerVersion;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.JSPContainer;
import com.ibm.ccl.soa.deploy.j2ee.JSPContainerVersion;
import com.ibm.ccl.soa.deploy.j2ee.ServletContainer;
import com.ibm.ccl.soa.deploy.j2ee.ServletContainerVersion;
import com.ibm.ccl.soa.deploy.java.JavaPackage;
import com.ibm.ccl.soa.deploy.java.JdbcTypeType;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProvider;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProviderUnit;
import com.ibm.ccl.soa.deploy.was.WASJ2CAuthenticationUnit;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasCluster;
import com.ibm.ccl.soa.deploy.was.WasDatasource;
import com.ibm.ccl.soa.deploy.was.WasDatasourceUnit;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasServer;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.internal.j2ee.validator.WasSecuritySubjectConstraintValidator;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * Validate instances of {@link WebsphereAppServerUnit}.
 */
public class WebsphereAppServerUnitValidator extends UnitValidator {

	protected final Map configurationUnitMap = new HashMap(); // key is onfigurationUnit(who is not empty)'s Eclass, value is the corresponding map

	protected final Map jdbcproviderUnitMap = new HashMap(); // key is jdbcUnit.Name, value is the unit

	protected final Map datasourceUnitMap = new HashMap(); // key is datasouce.jndiname, value is datasourceUnit

	protected final Map j2cAuthenticationUnitMap = new HashMap(); //key is j2cAuthUnit.Name, value is the unit

	protected final WasSecuritySubjectConstraintValidator wasSecuritySubjectConstraintValidator = new WasSecuritySubjectConstraintValidator();

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IUnitValidator#getUnitType()
	 */
	public EClass getUnitType() {
		return WasPackage.eINSTANCE.getWebsphereAppServerUnit();
	}

	/**
	 * 
	 */
	public WebsphereAppServerUnitValidator() {
		super(WasPackage.eINSTANCE.getWebsphereAppServerUnit());
		this.addCapabilityTypeConstraint(J2eePackage.eINSTANCE.getJ2EEContainer(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
		this.addCapabilityTypeConstraint(J2eePackage.eINSTANCE.getServletContainer(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
		this.addCapabilityTypeConstraint(J2eePackage.eINSTANCE.getJSPContainer(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
		this.addCapabilityTypeConstraint(J2eePackage.eINSTANCE.getEJBContainer(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
		this.addCapabilityTypeConstraint(J2eePackage.eINSTANCE.getJCAContainer(),
				CapabilityLinkTypes.ANY_LITERAL, 0, 1);
		this.addCapabilityTypeConstraint(WasPackage.eINSTANCE.getWasConfigurationContainer(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
		this.addCapabilityTypeConstraint(WasPackage.eINSTANCE.getWasSharedLibContainer(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
		this.addCapabilityTypeConstraint(WasPackage.Literals.WAS_APPLICATION_CLASS_LOADER_POLICY,
				CapabilityLinkTypes.ANY_LITERAL, 0, 1);
		this.addCapabilityTypeConstraint(WasPackage.Literals.WAS_MODULE_CLASS_LOADER_POLICY,
				CapabilityLinkTypes.ANY_LITERAL, 0, 1);
		this.addCapabilityTypeConstraint(OsPackage.eINSTANCE.getPortConsumer(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
		this.addCapabilityTypeConstraint(JavaPackage.eINSTANCE.getJRE(),
				CapabilityLinkTypes.ANY_LITERAL, 0, Integer.MAX_VALUE);
		this.addCapabilityTypeConstraint(JavaPackage.eINSTANCE.getJVMConfig(),
				CapabilityLinkTypes.ANY_LITERAL, 0, Integer.MAX_VALUE);
		this.addCapabilityTypeConstraint(WasPackage.eINSTANCE.getWasServer(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);

		this.addCapabilityTypeConstraint(WasPackage.eINSTANCE.getWasSubstitutionVariable(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);

		// Leave this - eventually it will be fixed.
		this.addCapabilityTypeConstraint(WasPackage.eINSTANCE.getWasSecurity(),
				CapabilityLinkTypes.DEPENDENCY_LITERAL, 0, 1);

		this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWasNode(),
				RequirementLinkTypes.HOSTING_LITERAL, 1, 1);
		this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWasClusterUnit(),
				RequirementLinkTypes.MEMBER_LITERAL, 0, Integer.MAX_VALUE);
		this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWasV5Datasource(),
				RequirementLinkTypes.DEPENDENCY_LITERAL, 0, 1);
		// this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWasSIBusUnit(), RequirementLinkTypes.MEMBER_LITERAL, 0, Integer.MAX_VALUE);
		// this.addRequirementTypeConstraint(OsPackage.eINSTANCE.getOperatingSystem(), RequirementLinkTypes.HOSTING_LITERAL, 1, 1);

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IWasValidatorID.WAS_APP_SERVER_WAS_VERSION_EMPTY_001,
				WasPackage.Literals.WAS_SERVER__WAS_VERSION, IStatus.ERROR));

		addAttributeValidator(new CapabilityAttributeUniqueInHostValidator(
				IWasValidatorID.WAS_APP_SERVER_SERVER_NAME_UNIQUENESS_001,
				WasPackage.Literals.WAS_SERVER__SERVER_NAME));

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IWasValidatorID.WAS_APP_SERVER_SERVER_NAME_EMPTY_001,
				WasPackage.Literals.WAS_SERVER__SERVER_NAME, IStatus.ERROR));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.UnitValidator#validateUnit(com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		// Core Unit validation
		super.validateUnit(unit, context, reporter);
		//
		List wasServerList = ValidatorUtils.getCapabilities(unit, WasPackage.Literals.WAS_SERVER);
		if (wasServerList.size() == 1) {
			WasServer wasServer = (WasServer) wasServerList.get(0);
			if (wasServer != null) {
				String wasVersion = wasServer.getWasVersion();
				if (wasVersion != null) {
					if (wasVersion.startsWith("5.0")) { //$NON-NLS-1$
						validateJ2EE13ContainerVersions(unit, reporter);
					}
					if (wasVersion.startsWith("5.1")) { //$NON-NLS-1$
						validateJ2EE13ContainerVersions(unit, reporter);
					}
					if (wasVersion.startsWith("6.0")) { //$NON-NLS-1$
						validateJ2EE14ContainerVersions(unit, reporter);
					}
				}
			}

			validateConfigurationUnits(unit, context, reporter);
		}

	}

	/**
	 * validate the configurationUnits used by application Units deployed on this server
	 * 
	 * configuration runtime satisfaction validating, start whenever there are ear, jar, war hosting
	 * onto wasServerUnit if there are applications deployed onto an server, collecting all artifacts
	 * deployed on the server
	 * 
	 * @param unit
	 * @param reporter
	 * @author lidb@cn.ibm.com
	 */
	protected void validateConfigurationUnits(Unit unit, IDeployValidationContext context,
			IDeployReporter reporter) {
// ----------------------------Do scope configuration validation only when all the scopes are there!---------------------------------------------------//
		assert unit instanceof WebsphereAppServerUnit;
		WebsphereAppServerUnit serverUnit = (WebsphereAppServerUnit) unit;
		Topology top = unit.getEditTopology();
		if (top == null) {
			return;
		}

		List applicationLists = WasUtil.getAllApplications(unit);
		if (applicationLists == null || applicationLists.size() <= 0) {
			return;
		}

		WasCluster clusterCap = WasUtil.getWasClusterCap(serverUnit, top);
		//if server is a member of cluster, it could not own any applications
		if (clusterCap != null) {
			Iterator applicationIt = applicationLists.iterator();
			while (applicationIt.hasNext()) {
				Unit applicationUnit = (Unit) applicationIt.next();
				IDeployStatus message = DeployWasMessageFactory
						.createApplicationHostingOnClusterMemberStatus(applicationUnit, serverUnit,
								(Unit) clusterCap.getParent());
				reporter.addStatus(message);
			}
			return;
		}

		WasNode nodeCap = WasUtil.getWasNodeCap(serverUnit, top);
		if (nodeCap == null) {
			return;
		}

		WasNodeUnit nodeUnit = (WasNodeUnit) nodeCap.getParent();
		WasCell cellCap = WasUtil.getWasCellCap(nodeUnit, top);
		if (cellCap == null) {
			return;
		}

		WasCellUnit cellUnit = (WasCellUnit) cellCap.getParent();

//		--------if artifacts requiring WAS configurationUnits, then collecting configurationUnits, if not, quit-------------------////
		Iterator applicationIt = applicationLists.iterator();
		List j2cAuthReqList = new ArrayList();
		List dsReqList = new ArrayList();
		// sharedlib, variable(this will turn into attribute), ldap

		while (applicationIt.hasNext()) {
			Unit applicationUnit = (Unit) applicationIt.next();
			j2cAuthReqList.addAll(ValidatorUtils.getRequirements(applicationUnit,
					WasPackage.Literals.WASJ2C_AUTHENTICATION_DATA_ENTRY));
			j2cAuthReqList.addAll(ValidatorUtils.getRequirements(applicationUnit,
					J2eePackage.Literals.J2C_AUTHENTICATION_DATA_ENTRY));
			// TODO remove this test? 
			dsReqList.addAll(ValidatorUtils.getRequirements(applicationUnit,
					WasPackage.Literals.WAS_DATASOURCE));
			dsReqList.addAll(ValidatorUtils.getRequirements(applicationUnit,
					J2eePackage.Literals.J2EE_DATASOURCE));
		}

		if ((j2cAuthReqList == null || j2cAuthReqList.size() <= 0)
				&& (dsReqList == null || dsReqList.size() <= 0)) {
			return;
		}

		validJ2CAuthenL(j2cAuthReqList, cellUnit, reporter);

//		validDataSourceUnitL(dsReqList, unit, nodeUnit, cellUnit, context, reporter);
		// De-dupe - alternative is to remove WAS_DATASOURCE from loop above
		validDataSourceUnitL(new ArrayList(new HashSet(dsReqList)), unit, nodeUnit, cellUnit,
				context, reporter);

	}

	/**
	 * validate datasource list
	 * 
	 * @param dsReqList
	 * @param unit
	 * @param nodeUnit
	 * @param cellUnit
	 * @param reporter
	 */
	protected void validDataSourceUnitL(List dsReqList, Unit unit, WasNodeUnit nodeUnit,
			WasCellUnit cellUnit, IDeployValidationContext context, IDeployReporter reporter) {
		if (dsReqList == null) {
			return;
		}
		if (dsReqList.size() <= 0) {
			return;
			//first check whether there is a dependencyLink, if not, collect and provides a marker for missing link or missing ds, if has, check whether the ds is a satisfied ds
		}

		Iterator dsReqIt = dsReqList.iterator();
		collectingDSUnitInCorrentScope(unit);
		collectingDSUnitInCorrentScope(nodeUnit);
		collectingDSUnitInCorrentScope(cellUnit);

		while (dsReqIt.hasNext()) {
			Requirement dsRequire = (Requirement) dsReqIt.next();
			DependencyLink link = dsRequire.getLink();

			if (link == null) {// missing link to ds
// MK: 2/10/2008: Defect 5328 - Remove usage of Requirement Expressions from the WAS domain
//				List expressions = dsRequire.getExpressions();
//				if (expressions == null) {
//					continue;
//				}
//				if (expressions.size() <= 0) {
//					continue;
//				}
//
				for (Constraint c : (List<Constraint>) dsRequire.getConstraints()) {
//				Iterator expIt = expressions.iterator();
//				while (expIt.hasNext()) {
//					RequirementExpression req_expr = (RequirementExpression) expIt.next();
					if (ConstraintPackage.Literals.EQUALS_CONSTRAINT.isSuperTypeOf(c.getEObject()
							.eClass())) {
						EqualsConstraint ec = (EqualsConstraint) c;
						if (J2eePackage.Literals.J2EE_DATASOURCE__JNDI_NAME.getName().equals(
								ec.getAttributeName())) {// "jndiName"
//							req_expr.getAttributeName())) {// "jndiName"
							String req_jndiName = ec.getValue();
//						String req_jndiName = req_expr.getValue();
							if (req_jndiName == null) {
								continue;
							}
							if (req_jndiName.length() <= 0) {
								continue;
							}

							if (datasourceUnitMap.get(req_jndiName) != null) {
								//have a satisfied datasourceUnit, common resolution will encourage user to create the link, need not duplix resolution here
							} else {// mark it, privide a resolution for create such a datasource
								IDeployStatus message = DeployWasMessageFactory
										.createApplicationRequiringDSMissingStatus(ValidatorUtils
												.getOwningUnit(dsRequire), req_jndiName, jdbcproviderUnitMap);
								reporter.addStatus(message);
							}
						}
					}
				}//end of loop
			} else {// link != null, check whether the target ds is satisfied
				Capability dsC = link.getTarget();
				assert dsC != null;
				Unit ds = (Unit) dsC.getParent();
				assert ds instanceof WasDatasourceUnit;
				WasDatasourceUnit dsUnit = (WasDatasourceUnit) ds;

				DB2JdbcProviderUnit jdbcProviderUnit = (DB2JdbcProviderUnit) ValidatorUtils
						.getHost(dsUnit);
				DB2JdbcProvider jdbcProviderCap = (DB2JdbcProvider) ValidatorUtils.getCapability(
						jdbcProviderUnit, WasPackage.Literals.DB2_JDBC_PROVIDER);
				if (jdbcProviderCap == null || jdbcProviderCap.getProviderType() == null
						|| jdbcProviderCap.getProviderType().length() == 0) {
					continue;
				}

				if (!JdbcTypeType._2_LITERAL.equals(jdbcProviderCap.getJdbcType())) {
					continue;
				}

				Unit osUnit = ValidatorUtils.discoverHostInStack(nodeUnit, OsPackage.eINSTANCE
						.getOperatingSystemUnit(), context.getProgressMonitor());
				if (osUnit == null) {
					continue;
				}

				List db2ServerL = ValidatorUtils.getHosted(osUnit, Db2Package.Literals.DB2_SYSTEM_UNIT);
				if (db2ServerL != null && db2ServerL.size() > 0) {
					//if the db2 server and the was server are at the same machine, then fine!
					continue;
				}

				// MK 11/21/2006 start replacement code for determining hosted clients
				// MK question: why only those in the current topology?  Can't the runtime client be among the off-topology elements?
				// MK comment: must also consider other kinds of clients:  admin client and system
				DiscoveryFilter filter = DiscoveryFilterFactory.createFindHostedFilter(osUnit, unit
						.getTopology());
				filter.setUnitTypes(new Class[] { DB2RuntimeClientUnit.class, DB2AdminClientUnit.class,
						DB2SystemUnit.class });
				List db2ClientUDL = TopologyDiscovererService.INSTANCE.findAll(filter);
				List db2runtimeClientL = new ArrayList();
				for (int i = 0; i < db2ClientUDL.size(); i++) {
					UnitDescriptor clientUD = (UnitDescriptor) db2ClientUDL.get(i);
					Unit u = clientUD.getUnitValue();
					if (null == u) {
						continue;
					}
					db2runtimeClientL.add(u);
				}
				// MK 11/21/2006 end added; start removed
				// List db2runtimeClientL = ValidatorUtils.getHosted(osUnit, Db2Package.Literals.DB2_RUNTIME_CLIENT_UNIT);
				// MK 11/21/2006 end removed code
				if (db2runtimeClientL == null || db2runtimeClientL.size() <= 0) {
					IDeployStatus message = DeployWasMessageFactory
							.createLocalDB2DSUnitMissingLocalDB2CatalogStatus(dsUnit, osUnit,
									IWasValidatorID.WAS_VALIDAT_DB2_DATASOURCEUNIT_LOCAL_CATALOG_001);
					reporter.addStatus(message);
				} else {
					DB2BaseClientUnit db2BaseClientUnit = (DB2BaseClientUnit) db2runtimeClientL.get(0);
					List db2ClientInstanceUnitL = ValidatorUtils.getHosted(db2BaseClientUnit,
							Db2Package.Literals.DB2_CLIENT_INSTANCE_UNIT);
					if (db2ClientInstanceUnitL == null || db2ClientInstanceUnitL.size() <= 0) {
						IDeployStatus message = DeployWasMessageFactory
								.createLocalDB2DSUnitMissingLocalDB2CatalogStatus(dsUnit,
										db2BaseClientUnit,
										IWasValidatorID.WAS_VALIDAT_DB2_DATASOURCEUNIT_LOCAL_CATALOG_002);
						reporter.addStatus(message);
					} else {
						WasDatasource dsCap = (WasDatasource) ValidatorUtils.getCapability(dsUnit,
								WasPackage.Literals.WAS_DATASOURCE);
						if (dsCap == null) {
							continue;
						}
						if (dsCap.getDbName() == null || dsCap.getDbName().length() <= 0) {
							continue;
						}

						// if Datasource.DBname != null, validate there is a coresponding db2 catalog for this dbName
						Iterator clientInstanceUnitIt = db2ClientInstanceUnitL.iterator();
						List db2NodeCatUnitL = new ArrayList();
						List db2CatlogUnitL = new ArrayList();

						boolean found = false;
						while (!found && clientInstanceUnitIt.hasNext()) {
							DB2ClientInstanceUnit instanceUnit = (DB2ClientInstanceUnit) clientInstanceUnitIt
									.next();
							List temp = ValidatorUtils.getHosted(instanceUnit,
									Db2Package.Literals.DB2_NODE_CATALOG_UNIT);
							if (temp == null || temp.size() <= 0) {
								continue;
							}

							Iterator tempIt = temp.iterator();
							while (!found && tempIt.hasNext()) {
								Unit tempUnit = (Unit) tempIt.next();
								if (db2NodeCatUnitL.contains(tempUnit)) {
									continue;
								}

								db2NodeCatUnitL.add(tempUnit);
								List cattempL = ValidatorUtils.getHosted(tempUnit,
										Db2Package.Literals.DB2_CATALOG_UNIT);
								if (cattempL == null || cattempL.size() <= 0) {
									continue;
								}

								Iterator tIt = cattempL.iterator();
								while (!found && tIt.hasNext()) {
									Unit tUnit = (Unit) tIt.next();
									DB2Database db2Database = (DB2Database) ValidatorUtils.getCapability(
											tUnit, Db2Package.Literals.DB2_DATABASE);
									if (db2Database == null) {
										continue;
									}

									if (dsCap.getDbName().equals(db2Database.getDbName())) {
										found = true;
									}

									if ((db2Database.getDbName() == null || db2Database.getDbName().length() == 0)
											&& !db2CatlogUnitL.contains(tUnit)) {
										db2CatlogUnitL.add(tUnit);
									}
								}
							}
						}//end of searching current exist NodeCata and Catalogs on NodeCatalog

						if (found) {
							continue;
						}

						if (db2NodeCatUnitL == null || db2NodeCatUnitL.size() <= 0) { //there is no NodeCatalog at all
							IDeployStatus message = DeployWasMessageFactory
									.createLocalDB2DSUnitMissingLocalDB2CatalogStatus(dsUnit,
											(Unit) db2ClientInstanceUnitL.get(0),
											IWasValidatorID.WAS_VALIDAT_DB2_DATASOURCEUNIT_LOCAL_CATALOG_003);
							reporter.addStatus(message);
						} else if (db2CatlogUnitL == null || db2CatlogUnitL.size() <= 0) { //has NodeCatalogs, but not any Catalogs on any of them
							IDeployStatus message = DeployWasMessageFactory
									.createLocalDB2DSUnitMissingLocalDB2CatalogStatus(dsUnit,
											(Unit) db2NodeCatUnitL.get(0),
											IWasValidatorID.WAS_VALIDAT_DB2_DATASOURCEUNIT_LOCAL_CATALOG_004);
							reporter.addStatus(message);
						} else {
							Iterator tempIt = db2CatlogUnitL.iterator();
							while (tempIt.hasNext()) {
								Unit tempUnit = (Unit) tempIt.next();
								DB2Database db2Database = (DB2Database) ValidatorUtils.getCapability(
										tempUnit, Db2Package.Literals.DB2_DATABASE);
								IDeployAttributeValueStatus message = DeployCoreStatusUtil
										.createAttributeInvalidStatus(
												IStatus.ERROR,
												IWasValidatorID.WAS_VALIDAT_DB2_DATASOURCEUNIT_LOCAL_CATALOG_005,
												db2Database, Db2Package.eINSTANCE.getDB2Database_DbName(),
												dsCap.getDbName());
								reporter.addStatus(message);
							}
						}
					}// end of check DB2ClientInstance, DB2NodeCatlog and DB2Catlog(dbname == datasource.dbname)
				}
			}
		}
	}

	/**
	 * validate the j2cAuthenList
	 * 
	 * @param j2cAuthReqList
	 * @param cellUnit
	 * @param reporter
	 */
	protected void validJ2CAuthenL(List j2cAuthReqList, WasCellUnit cellUnit,
			IDeployReporter reporter) {
		if (j2cAuthReqList == null) {
			return;
		}
		if (j2cAuthReqList.size() <= 0) {
			return;
		}

		Iterator j2cAuthReqIt = j2cAuthReqList.iterator();
		collectingJ2CAuthUnitFromCell(cellUnit);

		while (j2cAuthReqIt.hasNext()) {
			Requirement j2cRequire = (Requirement) j2cAuthReqIt.next();
			DependencyLink link = j2cRequire.getLink();
			if (link != null) {
				continue;
			}

// MK: 2/10/2008: Defect 5328 - Remove usage of Requirement Expressions from the WAS domain
//			List expressions = j2cRequire.getExpressions();
//			if (expressions == null) {
//				continue;
//			}
//			if (expressions.size() <= 0) {
//				continue;
//			}
//
//			Iterator expIt = expressions.iterator();
			for (Constraint c : (List<Constraint>) j2cRequire.getConstraints()) {
//			while (expIt.hasNext()) {
//				RequirementExpression req_expr = (RequirementExpression) expIt.next();
				if (ConstraintPackage.Literals.EQUALS_CONSTRAINT.isSuperTypeOf(c.getEObject().eClass())) {
					EqualsConstraint ec = (EqualsConstraint) c;
					if (ec.getAttributeName().equals(
//				if (req_expr.getAttributeName().equals(
							J2eePackage.Literals.J2C_AUTHENTICATION_DATA_ENTRY__ALIAS.getName())) {
						String req_alias = ec.getValue();
//					String req_alias = req_expr.getValue();
						if (req_alias != null && req_alias.length() > 0) {
							if (j2cAuthenticationUnitMap.get(req_alias) == null) {
								IDeployStatus message = DeployWasMessageFactory
										.createApplicationRequiringJ2CAuthMissingStatus(ValidatorUtils
												.getOwningUnit(j2cRequire), req_alias, cellUnit, j2cRequire);
								reporter.addStatus(message);
							}
						}
					}
				}
			}
		}

	}

	/**
	 * only cell can set j2cAuth, collect it from cell
	 * 
	 * @param cellUnit
	 */
	protected void collectingJ2CAuthUnitFromCell(Unit cellUnit) {
		List j2cAuthUnitL = ValidatorUtils.getHosted(cellUnit,
				WasPackage.Literals.WASJ2C_AUTHENTICATION_UNIT);
		if (j2cAuthUnitL != null && j2cAuthUnitL.size() > 0) {
			j2cAuthUnitL.clear();
			if (configurationUnitMap.get(WasPackage.Literals.WASJ2C_AUTHENTICATION_UNIT) == null) {
				configurationUnitMap.put(WasPackage.Literals.DB2_JDBC_PROVIDER_UNIT,
						j2cAuthenticationUnitMap);
			}

			Iterator j2cAuthUnitIt = j2cAuthUnitL.iterator();
			while (j2cAuthUnitIt.hasNext()) {
				WASJ2CAuthenticationUnit j2cAuthUnit = (WASJ2CAuthenticationUnit) j2cAuthUnitIt.next();
				String j2cAuthUnitName = j2cAuthUnit.getName();
				if (j2cAuthUnitName != null && j2cAuthUnitName.length() > 0) {
					if (j2cAuthenticationUnitMap.get(j2cAuthUnitName) == null) {
						j2cAuthenticationUnitMap.put(j2cAuthUnitName, j2cAuthUnit);
					}
				}
			}
		}
	}

	/**
	 * collecting DatasourceUnit in corrent scope
	 * 
	 * @param unit
	 * @author lidb@cn.ibm.com
	 */
	protected void collectingDSUnitInCorrentScope(Unit unit) {
		List jdbcProviderUnitL = ValidatorUtils.getHosted(unit,
				WasPackage.Literals.DB2_JDBC_PROVIDER_UNIT);
		List dsUnitL = new ArrayList();
		if (jdbcProviderUnitL != null && jdbcProviderUnitL.size() > 0) {
			dsUnitL.clear();
			if (configurationUnitMap.get(WasPackage.Literals.DB2_JDBC_PROVIDER_UNIT) == null) {
				configurationUnitMap.put(WasPackage.Literals.DB2_JDBC_PROVIDER_UNIT,
						jdbcproviderUnitMap);
			}

			Iterator jdbcProviderUnitIt = jdbcProviderUnitL.iterator();
			while (jdbcProviderUnitIt.hasNext()) {
				DB2JdbcProviderUnit jdbcUnit = (DB2JdbcProviderUnit) jdbcProviderUnitIt.next();
				String jdbcUnitName = jdbcUnit.getName();
				if (jdbcUnitName != null && jdbcUnitName.length() > 0) {
					if (jdbcproviderUnitMap.get(jdbcUnitName) == null) {
						jdbcproviderUnitMap.put(jdbcUnitName, jdbcUnit);
					}
				}
				List tempL = ValidatorUtils
						.getHosted(jdbcUnit, WasPackage.Literals.WAS_DATASOURCE_UNIT);
				if (tempL != null && tempL.size() > 0) {
					dsUnitL.addAll(ValidatorUtils.getHosted(jdbcUnit,
							WasPackage.Literals.WAS_DATASOURCE_UNIT));
				}
			}
		}
		if (dsUnitL != null && dsUnitL.size() > 0) {
			Iterator dsUnitIt = dsUnitL.iterator();
			if (configurationUnitMap.get(WasPackage.Literals.WAS_DATASOURCE_UNIT) == null) {
				configurationUnitMap.put(WasPackage.Literals.WAS_DATASOURCE_UNIT, datasourceUnitMap);
			}

			while (dsUnitIt.hasNext()) {
				WasDatasourceUnit dsUnit = (WasDatasourceUnit) dsUnitIt.next();
				WasDatasource dsCap = (WasDatasource) ValidatorUtils.getCapability(dsUnit,
						WasPackage.Literals.WAS_DATASOURCE);
				String dsJndiName = dsCap.getJndiName();
				if (dsJndiName != null && dsJndiName.length() > 0) {
					if (datasourceUnitMap.get(dsJndiName) == null) {
						datasourceUnitMap.put(dsJndiName, dsUnit);
					}
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.UnitValidator#validateHostingCapability(com.ibm.ccl.soa.deploy.core.Capability,
	 *      com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	protected void validateCapability(Capability capability, Unit unit,
			IDeployValidationContext context, IDeployReporter reporter) {
		super.validateCapability(capability, unit, context, reporter);

		if (capability instanceof WasServer) {
			WasServer wasServer = (WasServer) capability;
			// TODO Add WAS version number checks here against known WAS
			// versions?
			// The current check is against a version string type which allows 4
			// dot-separated version number segments.
			ValidatorUtils.validateStrictVersionNumberSyntax(wasServer,
					WasPackage.Literals.WAS_SERVER__WAS_VERSION, reporter);
		}
	}

	/**
	 * Validate J2EE 1.3 container versions. Capabilities that specify back-compatibility with
	 * earlier versions are allowed. If there is a j2ee 1.2 capability, it is allowed. Only container
	 * versions newer than what is implied by J2EE 1.3 are flagged as being in error.
	 * 
	 * J2EE 1.3 implies: Servlet 2.3 JSP 1.2 EJB 2.0
	 * 
	 * Stricter checks are possible. This test is intended to detect gross errors in templates or
	 * providers.
	 * 
	 * TODO move this check to J2EE domain so that it may be used by domain extensions for other
	 * non-IBM application server products.
	 * 
	 * @param unit
	 * @param context
	 * @param reporter
	 */
	private void validateJ2EE13ContainerVersions(Unit unit, IDeployReporter reporter) {
		// J2EE 1.3
		boolean j2ee13CapabilityFound = false;
		for (Iterator iter = ValidatorUtils
				.getCapabilities(unit, J2eePackage.Literals.J2EE_CONTAINER).iterator(); iter.hasNext();) {
			J2EEContainer j2eeContainer = (J2EEContainer) iter.next();
			J2EEContainerVersion j2eeContainerVersion = j2eeContainer.getContainerVersion();
			if (j2eeContainerVersion != J2EEContainerVersion._12_LITERAL
					&& j2eeContainerVersion != J2EEContainerVersion._13_LITERAL) {
				reporter.addStatus(DeployCoreStatusUtil.createObjectAttributeInvalidStatus(
						j2eeContainer, J2eePackage.Literals.J2EE_CONTAINER__CONTAINER_VERSION));
			}
			if (j2eeContainerVersion == J2EEContainerVersion._13_LITERAL) {
				j2ee13CapabilityFound = true;
			}
		}
		if (j2ee13CapabilityFound) {
			// Servlet 2.3
			for (Iterator iter = ValidatorUtils.getCapabilities(unit,
					J2eePackage.Literals.SERVLET_CONTAINER).iterator(); iter.hasNext();) {
				ServletContainer servletContainer = (ServletContainer) iter.next();
				ServletContainerVersion servletContainerVersion = servletContainer
						.getContainerVersion();
				if (servletContainerVersion != ServletContainerVersion._22_LITERAL
						&& servletContainerVersion != ServletContainerVersion._23_LITERAL) {
					reporter.addStatus(DeployCoreStatusUtil.createObjectAttributeInvalidStatus(
							servletContainer, J2eePackage.Literals.SERVLET_CONTAINER__CONTAINER_VERSION));
				}
			}
			// JSP 1.2
			for (Iterator iter = ValidatorUtils.getCapabilities(unit,
					J2eePackage.Literals.JSP_CONTAINER).iterator(); iter.hasNext();) {
				JSPContainer jspContainer = (JSPContainer) iter.next();
				JSPContainerVersion jspContainerVersion = jspContainer.getContainerVersion();
				if (jspContainerVersion != JSPContainerVersion._11_LITERAL
						&& jspContainerVersion != JSPContainerVersion._12_LITERAL) {
					reporter.addStatus(DeployCoreStatusUtil.createObjectAttributeInvalidStatus(
							jspContainer, J2eePackage.Literals.JSP_CONTAINER__CONTAINER_VERSION));
				}
			}
			// EJB 2.0
			for (Iterator iter = ValidatorUtils.getCapabilities(unit,
					J2eePackage.Literals.EJB_CONTAINER).iterator(); iter.hasNext();) {
				EJBContainer ejbContainer = (EJBContainer) iter.next();
				EJBContainerVersion ejbContainerVersion = ejbContainer.getContainerVersion();
				if (ejbContainerVersion != EJBContainerVersion._11_LITERAL
						&& ejbContainerVersion != EJBContainerVersion._20_LITERAL) {
					reporter.addStatus(DeployCoreStatusUtil.createObjectAttributeInvalidStatus(
							ejbContainer, J2eePackage.Literals.EJB_CONTAINER__CONTAINER_VERSION));
				}
			}
		}
	}

	/**
	 * Validate J2EE 1.4 container versions. Capabilities that specify back-compatibility with
	 * earlier versions are allowed. If there is a j2ee 1.2 or 1.3 capability, it is allowed. Only
	 * container versions newer than what is implied by J2EE 1.4 are flagged as being in error.
	 * 
	 * J2EE 1.4 implies: Servlet 2.4 JSP 2.0 EJB 2.1
	 * 
	 * Stricter checks are possible. This test is intended to detect gross errors in templates or
	 * providers.
	 * 
	 * TODO move this check to J2EE domain so that it may be used by domain extensions for other
	 * non-IBM application server products.
	 * 
	 * @param unit
	 * @param context
	 * @param reporter
	 */
	private void validateJ2EE14ContainerVersions(Unit unit, IDeployReporter reporter) {
		// J2EE 1.4
		boolean j2ee14CapabilityFound = false;
		for (Iterator iter = ValidatorUtils
				.getCapabilities(unit, J2eePackage.Literals.J2EE_CONTAINER).iterator(); iter.hasNext();) {
			J2EEContainer j2eeContainer = (J2EEContainer) iter.next();
			J2EEContainerVersion j2eeContainerVersion = j2eeContainer.getContainerVersion();
			if (j2eeContainerVersion != J2EEContainerVersion._12_LITERAL
					&& j2eeContainerVersion != J2EEContainerVersion._13_LITERAL
					&& j2eeContainerVersion != J2EEContainerVersion._14_LITERAL) {
				reporter.addStatus(DeployCoreStatusUtil.createObjectAttributeInvalidStatus(
						j2eeContainer, J2eePackage.Literals.J2EE_CONTAINER__CONTAINER_VERSION));
			}
			if (j2eeContainerVersion == J2EEContainerVersion._14_LITERAL) {
				j2ee14CapabilityFound = true;
			}
		}
		if (j2ee14CapabilityFound) {
			// Servlet 2.4
			for (Iterator iter = ValidatorUtils.getCapabilities(unit,
					J2eePackage.Literals.SERVLET_CONTAINER).iterator(); iter.hasNext();) {
				ServletContainer servletContainer = (ServletContainer) iter.next();
				ServletContainerVersion servletContainerVersion = servletContainer
						.getContainerVersion();
				if (servletContainerVersion != ServletContainerVersion._22_LITERAL
						&& servletContainerVersion != ServletContainerVersion._23_LITERAL
						&& servletContainerVersion != ServletContainerVersion._24_LITERAL) {
					reporter.addStatus(DeployCoreStatusUtil.createObjectAttributeInvalidStatus(
							servletContainer, J2eePackage.Literals.SERVLET_CONTAINER__CONTAINER_VERSION));
				}
			}
			// JSP 2.0
			for (Iterator iter = ValidatorUtils.getCapabilities(unit,
					J2eePackage.Literals.JSP_CONTAINER).iterator(); iter.hasNext();) {
				JSPContainer jspContainer = (JSPContainer) iter.next();
				JSPContainerVersion jspContainerVersion = jspContainer.getContainerVersion();
				if (jspContainerVersion != JSPContainerVersion._11_LITERAL
						&& jspContainerVersion != JSPContainerVersion._12_LITERAL
						&& jspContainerVersion != JSPContainerVersion._20_LITERAL) {
					reporter.addStatus(DeployCoreStatusUtil.createObjectAttributeInvalidStatus(
							jspContainer, J2eePackage.Literals.JSP_CONTAINER__CONTAINER_VERSION));
				}
			}
			// EJB 2.1
			for (Iterator iter = ValidatorUtils.getCapabilities(unit,
					J2eePackage.Literals.EJB_CONTAINER).iterator(); iter.hasNext();) {
				EJBContainer ejbContainer = (EJBContainer) iter.next();
				EJBContainerVersion ejbContainerVersion = ejbContainer.getContainerVersion();
				if (ejbContainerVersion != EJBContainerVersion._11_LITERAL
						&& ejbContainerVersion != EJBContainerVersion._20_LITERAL
						&& ejbContainerVersion != EJBContainerVersion._21_LITERAL) {
					reporter.addStatus(DeployCoreStatusUtil.createObjectAttributeInvalidStatus(
							ejbContainer, J2eePackage.Literals.EJB_CONTAINER__CONTAINER_VERSION));
				}
			}
		}
	}

	/**
	 * add configuration units into corresponding eClass List in configurationUnitMap
	 * 
	 * @param configUnit
	 */
	protected void addConfigUnit(Unit configUnit) {
		assert configUnit != null;
		List list = (List) configurationUnitMap.get(configUnit.getEObject().eClass());
		if (list == null) {
			list = new LinkedList();
			configurationUnitMap.put(configUnit.getEObject().eClass(), list);
		}
		list.add(configUnit);
	}

}
