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
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeUniqueInGroupValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeStringNotEmptyValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.db2.DB2ClientInstanceUnit;
import com.ibm.ccl.soa.deploy.db2.DB2Database;
import com.ibm.ccl.soa.deploy.db2.DB2RuntimeClientUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.java.JavaPackage;
import com.ibm.ccl.soa.deploy.java.JdbcTypeType;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProvider;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProviderUnit;
import com.ibm.ccl.soa.deploy.was.WASJ2CAuthenticationUnit;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasCluster;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasDatasource;
import com.ibm.ccl.soa.deploy.was.WasDatasourceUnit;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * {@link WasClusterUnit}
 */
public class WasGenericClusterUnitValidator extends UnitValidator {
	protected final Map configurationUnitMap = new HashMap(); //key is configurationUnit(who is not empty)'s Eclass, value is the corresponding map
	protected final Map jdbcproviderUnitMap = new HashMap(); //key is jdbcUnit.Name, value is the unit
	protected final Map datasourceUnitMap = new HashMap(); //key is datasouce.jndiname, value is datasourceUnit
	protected final Map j2cAuthenticationUnitMap = new HashMap(); //key is j2cAuthUnit.Name, value is the unit

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IUnitValidator#getUnitType()
	 */
	public EClass getUnitType() {
		return WasPackage.eINSTANCE.getWasClusterUnit();
	}

	/**
	 * 
	 */
	public WasGenericClusterUnitValidator() {
		super(WasPackage.eINSTANCE.getWasClusterUnit());

		this.addCapabilityTypeConstraint(WasPackage.eINSTANCE.getWasCluster(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
		this.addCapabilityTypeConstraint(J2eePackage.eINSTANCE.getJ2EEContainer(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
		this.addCapabilityTypeConstraint(J2eePackage.eINSTANCE.getServletContainer(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
		this.addCapabilityTypeConstraint(J2eePackage.eINSTANCE.getJSPContainer(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
		this.addCapabilityTypeConstraint(J2eePackage.eINSTANCE.getEJBContainer(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
		this.addCapabilityTypeConstraint(J2eePackage.eINSTANCE.getJCAContainer(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
		this.addCapabilityTypeConstraint(WasPackage.eINSTANCE.getWasConfigurationContainer(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
		this.addCapabilityTypeConstraint(WasPackage.eINSTANCE.getWasSubstitutionVariable(),
				CapabilityLinkTypes.ANY_LITERAL, 1, 1);
		this.addCapabilityTypeConstraint(JavaPackage.eINSTANCE.getJRE(),
				CapabilityLinkTypes.ANY_LITERAL, 0, Integer.MAX_VALUE);
		this.addCapabilityTypeConstraint(JavaPackage.eINSTANCE.getJRE(),
				CapabilityLinkTypes.HOSTING_LITERAL, 0, Integer.MAX_VALUE);

		// MK 4/8/2007 changed cluster to hosted on cell
		// this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWasCellUnit(), RequirementLinkTypes.MEMBER_LITERAL, 1, 1);
		this.addRequirementTypeConstraint(WasPackage.Literals.WAS_CELL,
				RequirementLinkTypes.HOSTING_LITERAL, 1, 1);

		this.addRequirementTypeConstraint(WasPackage.eINSTANCE.getWebsphereAppServerUnit(),
				RequirementLinkTypes.MEMBER_LITERAL, 1, 1);

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IWasValidatorID.WAS_CLUSTER_UNIT_CLUSTER_NAME_EMPTY_001,
				WasPackage.Literals.WAS_CLUSTER__CLUSTER_NAME, IStatus.ERROR));

		addAttributeValidator(new CapabilityAttributeUniqueInGroupValidator(
				IWasValidatorID.WAS_CLUSTER_CLUSTER_NAME_UNIQUE_001,
				WasPackage.Literals.WAS_CLUSTER_UNIT, WasPackage.Literals.WAS_CLUSTER__CLUSTER_NAME,
				WasPackage.Literals.WAS_CELL_UNIT));

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IWasValidatorID.WAS_CLUSTER_UNIT_WAS_VERSION_EMPTY_001,
				WasPackage.Literals.WAS_CLUSTER__WAS_VERSION, IStatus.ERROR));

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
		assert unit != null;
		assert unit instanceof WasClusterUnit;
		Topology top = unit.getTopology();
		if (top == null) {
			return;
		}
		WasClusterUnit clusterUnit = (WasClusterUnit) unit;
		WasCluster wasClusterCap = (WasCluster) ValidatorUtils.getCapability(unit,
				WasPackage.eINSTANCE.getWasCluster());
		if (wasClusterCap == null) {
			return;
		}

		validateConfigurationUnits(clusterUnit, context, reporter, top);

		WasCell wasCellCap = WasUtil.getWasCellCap(clusterUnit, top);
		if (wasCellCap == null) {
			return;
		}

		if (!wasCellCap.isIsDistributed()) {
			WasCellUnit cellUnit = (WasCellUnit) wasCellCap.getParent();
			IDeployStatus message = DeployWasMessageFactory
					.createWasInvalidMemberUnitInGroupUnitStatus(
							clusterUnit,
							cellUnit,
							IWasValidatorID.VALIDAT_WAS_CLUSTER_UNIT_S_CELLTYPE,
							DeployNLS
									.bind(
											WasDomainMessages.Validator_Was_ClusterUnit_0_Is_Invalid_MemberOF_StandAlone_Was_Cell_Unit_1,
											clusterUnit, cellUnit));
			reporter.addStatus(message);
			//Stand-alone cluster could not be added to standalone cell, cause it does not support that in UI
		} else {
			String wasCellVersion = wasCellCap.getWasVersion();
			String wasClusterVersion = wasClusterCap.getWasVersion();
			if (wasCellVersion != null && wasCellVersion.length() > 0) {
				if (wasClusterVersion != null && wasClusterVersion.length() > 0) {
					if (WasUtil.compare2VersionString(wasClusterVersion, wasCellVersion) > 0) {
						//check wasClusterVersion <= wasCell.wasVersion, mark cluster
						IDeployStatus message = DeployWasMessageFactory
								.createWasInvalidMemberUnitInGroupUnitStatus(
										clusterUnit,
										(Unit) wasCellCap.getParent(),
										IWasValidatorID.VALIDAT_WAS_CLUSTER_UNIT_VERSION_WITH_WASCELL_VERSION,
										DeployNLS
												.bind(
														WasDomainMessages.Validator_Was_Cluster_0_WasVersion_1_Bigger_Than_Its_WasCell_2_WasVersion_3,
														new Object[] { wasClusterCap.getClusterName(),
																wasClusterCap.getWasVersion(),
																wasCellCap.getCellName(),
																wasCellCap.getWasVersion() }));
						reporter.addStatus(message);
					}
				}
			}
		}
	}

	/**
	 * validate the configurationUnits used by application Units deployed on this cluster
	 * 
	 * @param clusterUnit
	 * @param reporter
	 * @param context
	 * @param top
	 */
	protected void validateConfigurationUnits(WasClusterUnit clusterUnit,
			IDeployValidationContext context, IDeployReporter reporter, Topology top) {
//		----------------------------Do scope configuration validation only when all the scopes are there! ---------------------------------------------------//
		List applicationLists = WasUtil.getAllApplications(clusterUnit);
		if (applicationLists == null || applicationLists.size() <= 0) {
			return;
		}

		List serverMemberUnitL = WasUtil.getWasAppServerUnitMemberList(clusterUnit, top);

		if (serverMemberUnitL == null || serverMemberUnitL.size() <= 0) {
			IDeployStatus message = DeployWasMessageFactory
					.createApplicationHostingOnEmptyClusterStatus(clusterUnit, ((Unit) applicationLists
							.get(0)));
			reporter.addStatus(message);
		} else {
			Iterator applicationIt = applicationLists.iterator();

			////--------if artifacts requiring WAS configurationUnits, then collecting configurationUnits, if not, quit-------------------////
			List j2cAuthReqList = new ArrayList();
			List dsReqList = new ArrayList();
			//sharedlib, variable(this will turn into attribute), ldap

			while (applicationIt.hasNext()) {
				Unit applicationUnit = (Unit) applicationIt.next();
				j2cAuthReqList.addAll(ValidatorUtils.getRequirements(applicationUnit,
						WasPackage.Literals.WASJ2C_AUTHENTICATION_DATA_ENTRY));
				j2cAuthReqList.addAll(ValidatorUtils.getRequirements(applicationUnit,
						J2eePackage.Literals.J2C_AUTHENTICATION_DATA_ENTRY));
				dsReqList.addAll(ValidatorUtils.getRequirements(applicationUnit,
						WasPackage.Literals.WAS_DATASOURCE));
				dsReqList.addAll(ValidatorUtils.getRequirements(applicationUnit,
						J2eePackage.Literals.J2EE_DATASOURCE));
			}

			WasCell cellCap = WasUtil.getWasCellCap(clusterUnit, top);
			if (cellCap == null) {
				return;
			}

			WasCellUnit cellUnit = (WasCellUnit) cellCap.getParent();

			if (j2cAuthReqList.size() <= 0 && dsReqList.size() <= 0) {
				return;
			}

			if (j2cAuthReqList.size() > 0) {
				Iterator j2cAuthReqIt = j2cAuthReqList.iterator();
				collectingJ2CAuthUnitFromCell(cellUnit);

				while (j2cAuthReqIt.hasNext()) {
					Requirement j2cRequire = (Requirement) j2cAuthReqIt.next();
					if (ValidatorUtils.getDependencyLinkTarget(j2cRequire) == null) {
						for (Constraint c : (List<Constraint>) j2cRequire.getConstraints()) {
							if (ConstraintPackage.Literals.EQUALS_CONSTRAINT.isSuperTypeOf(c.getEObject()
									.eClass())) {
								EqualsConstraint ec = (EqualsConstraint) c;
								if (J2eePackage.Literals.J2C_AUTHENTICATION_DATA_ENTRY__ALIAS.getName()
										.equals(ec.getAttributeName())) {
									String requiredAlias = ec.getValue();
									if (null != requiredAlias && 0 < requiredAlias.trim().length()) {
										if (j2cAuthenticationUnitMap.get(requiredAlias) == null) {
											IDeployStatus message = DeployWasMessageFactory
													.createApplicationRequiringJ2CAuthMissingStatus(
															(Unit) j2cRequire.getParent(), requiredAlias,
															cellUnit, j2cRequire);
											reporter.addStatus(message);
										}
									}
								}
							}
						}
// MK: 2/10/2008: Defect 5328 - Remove usage of Requirement Expressions from the WAS domain
//						List expressions = j2cRequire.getExpressions();
//						if (expressions != null && expressions.size() > 0) {
//							Iterator expIt = expressions.iterator();
//							while (expIt.hasNext()) {
//								RequirementExpression req_expr = (RequirementExpression) expIt.next();
//								if (req_expr.getAttributeName().equals(
//										J2eePackage.Literals.J2C_AUTHENTICATION_DATA_ENTRY__ALIAS.getName())) {
//									String req_alias = req_expr.getValue();
//									if (req_alias != null && req_alias.length() > 0) {
//										if (j2cAuthenticationUnitMap.get(req_alias) == null) {
//											IDeployStatus message = DeployWasMessageFactory
//													.createApplicationRequiringJ2CAuthMissingStatus(
//															(Unit) j2cRequire.getParent(), req_alias, cellUnit,
//															j2cRequire);
//											reporter.addStatus(message);
//										}
//									}
//								}
//							}
//						}
					}
				}
			}

			if (dsReqList.size() > 0) {
				//first check out whether there is a dependencyLink, if not, collect and provides a marker for missing link or missing ds; if so, have to check whether the ds is a satisfied ds
				Iterator dsReqIt = dsReqList.iterator();
				collectingDSUnitInCorrentScope(clusterUnit);
				collectingDSUnitInCorrentScope(cellUnit);
				while (dsReqIt.hasNext()) {
					Requirement dsRequire = (Requirement) dsReqIt.next();
					DeployModelObject target = ValidatorUtils.getDependencyLinkTarget(dsRequire);
					if (target == null) {
						//at least missing link to ds
						for (Constraint c : (List<Constraint>) dsRequire.getConstraints()) {
							if (ConstraintPackage.Literals.EQUALS_CONSTRAINT.isSuperTypeOf(c.getEObject()
									.eClass())) {
								EqualsConstraint ec = (EqualsConstraint) c;
								if (J2eePackage.Literals.J2EE_DATASOURCE__JNDI_NAME.getName().equals(
										ec.getAttributeName())) {
									String requiredJndiName = ec.getValue();
									if (null != requiredJndiName && 0 < requiredJndiName.trim().length()) {
										if (datasourceUnitMap.get(requiredJndiName) == null) {
											IDeployStatus message = DeployWasMessageFactory
													.createApplicationRequiringDSMissingStatus(ValidatorUtils
															.getOwningUnit(dsRequire), requiredJndiName,
															jdbcproviderUnitMap);
											reporter.addStatus(message);
										}
									}
								}
							}
						}
// MK: 2/10/2008: Defect 5328 - Remove usage of Requirement Expressions from the WAS domain
//						List expressions = dsRequire.getExpressions();
//						if (expressions != null && expressions.size() > 0) {
//							Iterator expIt = expressions.iterator();
//							while (expIt.hasNext()) {
//								RequirementExpression req_expr = (RequirementExpression) expIt.next();
//								if (req_expr.getAttributeName().equals(
//										J2eePackage.Literals.J2EE_DATASOURCE__JNDI_NAME.getName())) {//"jndiName"
//									String req_jndiName = req_expr.getValue();
//									if (req_jndiName != null && req_jndiName.length() > 0) {
//										if (datasourceUnitMap.get(req_jndiName) != null) {//have a satisfied datasourceUnit, common resolution will encourage user to create the link
//										} else {//mark it, privide a resolution for create such a datasource
//											IDeployStatus message = DeployWasMessageFactory
//													.createApplicationRequiringDSMissingStatus((Unit) dsRequire
//															.getParent(), req_jndiName, jdbcproviderUnitMap);
//											reporter.addStatus(message);
//										}
//									}
//								}
//							}
//						}
					}//end of link ==null
					else if (target.getParent() instanceof WasDatasourceUnit) {
						//link != null, check whether the target ds is satisfied
						WasDatasourceUnit dsUnit = (WasDatasourceUnit) target.getParent();
						WasDatasource dsCap = (WasDatasource) ValidatorUtils.getCapability(dsUnit,
								WasPackage.Literals.WAS_DATASOURCE);
						DB2JdbcProviderUnit jdbcProviderUnit = (DB2JdbcProviderUnit) ValidatorUtils
								.getHost(dsUnit);
						DB2JdbcProvider jdbcProviderCap = (DB2JdbcProvider) ValidatorUtils.getCapability(
								jdbcProviderUnit, WasPackage.Literals.DB2_JDBC_PROVIDER);
						if (jdbcProviderCap == null || jdbcProviderCap.getProviderType() == null
								|| jdbcProviderCap.getProviderType().length() == 0) {
							continue;
						}

						if (jdbcProviderCap.getJdbcType().equals(JdbcTypeType._2_LITERAL)) {
							List wasNodeCapL = new ArrayList();
							List osUnitL = new ArrayList();
							Iterator serverMemberUnitIt = serverMemberUnitL.iterator();
							while (serverMemberUnitIt.hasNext()) {
								WebsphereAppServerUnit serverUnit = (WebsphereAppServerUnit) serverMemberUnitIt
										.next();
								WasNode nodeCap = WasUtil.getWasNodeCap(serverUnit, top);

								if (nodeCap == null || wasNodeCapL.contains(nodeCap)) {
									continue;
								}
								wasNodeCapL.add(nodeCap);
								Unit osUnit = ValidatorUtils.discoverHostInStack(
										(Unit) nodeCap.getParent(), OsPackage.eINSTANCE
												.getOperatingSystemUnit(), context.getProgressMonitor());
								if (osUnit != null && !osUnitL.contains(osUnit)) {
									osUnitL.add(osUnit);
								}
							}//endof collecting related osUnits

							if (!checkLocalCatalog(osUnitL, dsCap.getDbName())) {
								IDeployStatus message = DeployWasMessageFactory
										.createLocalDB2DSUnitMissingLocalDB2CatalogStatus(
												dsUnit,
												osUnitL,
												IWasValidatorID.WAS_VALIDAT_DB2_DATASOURCEUNIT_LOCAL_CATALOG_006);
								reporter.addStatus(message);
							}
						}
					}
				}
			}
		}
	}

	protected boolean checkLocalCatalog(List osUnitL, String dbName) {
		if (osUnitL == null || osUnitL.size() <= 0) {
			return true;
		}
		Iterator osUnitIt = osUnitL.iterator();
		while (osUnitIt.hasNext()) {
			Unit osUnit = (Unit) osUnitIt.next();
			List db2runtimeClientL = ValidatorUtils.getHosted(osUnit,
					Db2Package.Literals.DB2_RUNTIME_CLIENT_UNIT);
			if (db2runtimeClientL == null || db2runtimeClientL.size() <= 0) {
				return false;
			}
			DB2RuntimeClientUnit db2runtimeClientUnit = (DB2RuntimeClientUnit) db2runtimeClientL
					.get(0); //no need to create 2 runtime client on a same os
			List db2ClientInstanceUnitL = ValidatorUtils.getHosted(db2runtimeClientUnit,
					Db2Package.Literals.DB2_CLIENT_INSTANCE_UNIT);
			if (db2ClientInstanceUnitL == null || db2ClientInstanceUnitL.size() <= 0) {
				return false;
			}
			Iterator clientInsatanceUnitIt = db2ClientInstanceUnitL.iterator();
			List db2NodeCatUnitL = new ArrayList();
			//List db2CatlogUnitL = new ArrayList();

			boolean found = false;
			while (!found && clientInsatanceUnitIt.hasNext()) {
				DB2ClientInstanceUnit instanceUnit = (DB2ClientInstanceUnit) clientInsatanceUnitIt
						.next();
				List temp = ValidatorUtils.getHosted(instanceUnit,
						Db2Package.Literals.DB2_NODE_CATALOG_UNIT);
				if (temp != null && temp.size() > 0) {
					Iterator tempIt = temp.iterator();
					while (!found && tempIt.hasNext()) {
						Unit tempUnit = (Unit) tempIt.next();
						if (!db2NodeCatUnitL.contains(tempUnit)) {
							db2NodeCatUnitL.add(tempUnit);
							List cattempL = ValidatorUtils.getHosted(tempUnit,
									Db2Package.Literals.DB2_CATALOG_UNIT);
							if (cattempL != null && cattempL.size() > 0) {
								Iterator tIt = cattempL.iterator();
								while (!found && tIt.hasNext()) {
									Unit tUnit = (Unit) tIt.next();
									DB2Database db2Database = (DB2Database) ValidatorUtils.getCapability(
											tUnit, Db2Package.Literals.DB2_DATABASE);
									if (db2Database != null) {
										if (db2Database.getDbName() == null) {
											if (dbName == null) {
												found = true;
											}
										} else if (db2Database.getDbName().equals(dbName)) {
											found = true;
										}
									}
								}
							}
						}
					}
				}
			}
			if (!found) {
				return false;
			}
		}
		return true;
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
		if (jdbcProviderUnitL.size() > 0) {
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

	/**
	 * only cell can set j2cAuth, collect it from cell
	 * 
	 * @param cellUnit
	 */
	protected void collectingJ2CAuthUnitFromCell(Unit cellUnit) {
		List j2cAuthUnitL = ValidatorUtils.getHosted(cellUnit,
				WasPackage.Literals.WASJ2C_AUTHENTICATION_UNIT);
		if (j2cAuthUnitL != null && j2cAuthUnitL.size() > 0) {
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

	protected WasNodeUnit getWasNodeUnit(WebsphereAppServerUnit serverUnit, Topology top) {
		List reqL = serverUnit.getOnlyMemberRequirements();
		for (int i = 0; i < reqL.size(); i++) {
			if (((Requirement) reqL.get(i)).getDmoEType()
					.equals(WasPackage.eINSTANCE.getWasNodeUnit())) {
				List memberList = TopologyDiscovererService.INSTANCE.getGroups(serverUnit,
						(Requirement) reqL.get(i), top);
				if (memberList != null) {
					if (memberList.size() > 0) {
						return (WasNodeUnit) ((UnitDescriptor) memberList.get(0)).getUnitValue();
					}
				}
			}
		}
		return null;
	}
}
