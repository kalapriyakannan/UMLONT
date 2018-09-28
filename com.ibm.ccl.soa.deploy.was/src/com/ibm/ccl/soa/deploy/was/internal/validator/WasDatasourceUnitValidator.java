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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.DiscoveryFilter;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementUsage;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.EnumerationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.SingleValue;
import com.ibm.ccl.soa.deploy.core.provider.discovery.DiscoveryFilterFactory;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeToAttributePropagationValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.CapabilityAttributeUniqueInHostValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeStringNotEmptyValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.link.DependencyLinkLocalValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.database.DatabasePackage;
import com.ibm.ccl.soa.deploy.db2.DB2CatalogUnit;
import com.ibm.ccl.soa.deploy.db2.DB2Database;
import com.ibm.ccl.soa.deploy.db2.DB2DatabaseUnit;
import com.ibm.ccl.soa.deploy.db2.DB2Instance;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.validator.J2EEDataSourceValidator;
import com.ibm.ccl.soa.deploy.java.JavaPackage;
import com.ibm.ccl.soa.deploy.java.JdbcProviderUnit;
import com.ibm.ccl.soa.deploy.java.JdbcTypeType;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProvider;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProviderType;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProviderUnit;
import com.ibm.ccl.soa.deploy.was.DataSourceHelperClassNames;
import com.ibm.ccl.soa.deploy.was.DerbyJdbcProvider;
import com.ibm.ccl.soa.deploy.was.DerbyJdbcProviderTypeType;
import com.ibm.ccl.soa.deploy.was.WasDatasource;
import com.ibm.ccl.soa.deploy.was.WasDatasourceUnit;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum;
import com.ibm.ccl.soa.deploy.was.WasV5Datasource;
import com.ibm.ccl.soa.deploy.was.util.jdbcprovider.WebsphereContext;
import com.ibm.ccl.soa.deploy.was.validator.IWASProblemType;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * {@link WasDatasourceUnit}
 * 
 */
public class WasDatasourceUnitValidator extends J2EEDataSourceValidator {
	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IUnitValidator#getUnitType()
	 */
	public EClass getUnitType() {
		return WasPackage.Literals.WAS_DATASOURCE_UNIT;
	}

	/**
	 * @param unitType
	 */
	public WasDatasourceUnitValidator(EClass unitType) {
		super(unitType);
		this.addCapabilityTypeConstraint(WasPackage.Literals.WAS_V4_DATASOURCE,
				CapabilityLinkTypes.DEPENDENCY_LITERAL, 0, 1);
		this.addCapabilityTypeConstraint(WasPackage.Literals.WAS_V5_DATASOURCE,
				CapabilityLinkTypes.DEPENDENCY_LITERAL, 0, 1);
		this.addCapabilityTypeConstraint(J2eePackage.Literals.J2EE_DATASOURCE,
				CapabilityLinkTypes.DEPENDENCY_LITERAL, 1, 1);

		this.addRequirementTypeConstraint(J2eePackage.Literals.J2C_AUTHENTICATION_DATA_ENTRY,
				RequirementLinkTypes.DEPENDENCY_LITERAL, 0, 1);
		this.addRequirementTypeConstraint(DatabasePackage.Literals.DATABASE,
				RequirementLinkTypes.DEPENDENCY_LITERAL, 0, 1);
//		this.addRequirementTypeConstraint(WasPackage.Literals.DB2_JDBC_PROVIDER,
//		RequirementLinkTypes.HOSTING_LITERAL, 1, 1);
		this.addRequirementTypeConstraint(WasPackage.Literals.EXTENDED_JDBC_PROVIDER,
				RequirementLinkTypes.HOSTING_LITERAL, 1, 1);

		addDependencyLinkValidator(new DependencyLinkLocalValidator(
				IWasValidatorID.WAS_DATASOURCE_JDBCPROVIDER_LINK_NON_LOCAL_001, JavaPackage.eINSTANCE
						.getJdbcProvider(), WasPackage.eINSTANCE.getWasServer(), IStatus.ERROR));
		// TODO what is this supposed to do?
		// The requirement is really that the j2c auth to user link be across 
		// the same stack boundary (if any) as the other links to the database.
		// MK 10/6/2006 replaced DependencyLinkLocalValidator with the following:
		addDependencyLinkValidator(new DependencyLinkCommonCellValidator(
				IWasValidatorID.WAS_J2C_AUTHENTICATION_DATA_ENTRY_LINK_NON_LOCAL_001,
				J2eePackage.eINSTANCE.getJ2CAuthenticationDataEntry(),
				//OsPackage.eINSTANCE.getOperatingSystem(),
				IStatus.ERROR));

		// MK 12/6/2006 changed signature of validator; some inputs are fixed for this type
		// of validator; it makes no sense to pass them as parameters to the constructor
		addDependencyLinkValidator(new DatasourceType2ToDatabaseLinkLocalValidator(
				IWasValidatorID.WAS_DATASOURCE_TYPE_2_DATABASE_LINK_NON_LOCAL_001,
//				DatabasePackage.eINSTANCE.getDatabase(),
//				OsPackage.eINSTANCE.getOperatingSystem(),
				IStatus.ERROR));

		// TODO fix or remove. Need to investigate
		addAttributeValidator(new CapabilityAttributeUniqueInHostValidator(
				IWasValidatorID.WAS_DATASOURCE_UNIT_JNDI_NAME_UNIQUENESS_001,
				J2eePackage.Literals.J2EE_DATASOURCE__JNDI_NAME));

		addAttributeValidator(new CapabilityAttributeToAttributePropagationValidator(
				IWasValidatorID.J2EE_DATASOURCE_FROM_DB2_DATABASE_DB_NAME, J2eePackage.eINSTANCE
						.getJ2EEDatasource_DbName(), Db2Package.eINSTANCE.getDB2Database_DbName()));

		addAttributeValidator(new CapabilityAttributeToAttributePropagationValidator(
				IWasValidatorID.WAS_V5_DATASOURCE_J2C_AUTH_ALIAS_FROM_J2C_AUTHENTICATION_DATA_ENTRY_ALIAS,
				WasPackage.eINSTANCE.getWasV5Datasource(), WasPackage.eINSTANCE
						.getWasV5Datasource_J2cAuthAlias(), WasPackage.eINSTANCE
						.getWASJ2CAuthenticationDataEntry(), J2eePackage.eINSTANCE
						.getJ2CAuthenticationDataEntry_Alias()));

		addAttributeValidator(new AliasNotEmptyValidator(
				IWasValidatorID.WAS_V5_DATASOURCE_J2C_AUTH_ALIAS_EMPTY,
				WasPackage.Literals.WAS_V5_DATASOURCE__J2C_AUTH_ALIAS, IStatus.ERROR));

		addAttributeValidator(new DbNameValidator());
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
		validateDataStoreHelper(unit, reporter);
		validateWASV5DB2Datasource(unit, reporter);
	}

	/*
	 * This is a case where a requirement type should be variable depending upon a capability type
	 */
	private void validateWASV5DB2Datasource(Unit unit, IDeployReporter reporter) {
		if (ValidatorUtils.getCapabilities(unit, WasPackage.Literals.WAS_V5DB2_DATASOURCE).size() > 0) {
			List dbRequirements = ValidatorUtils.getRequirements(unit,
					DatabasePackage.Literals.DATABASE);
			if (dbRequirements.size() == 1) {
				Requirement dbRequirement = (Requirement) dbRequirements.get(0);
				if (!Db2Package.Literals.DB2_DATABASE.isSuperTypeOf(dbRequirement.getDmoEType())) {
					String[] bindings = new String[] { dbRequirement.getDmoEType().getClass().toString() };
					IDeployStatus status = DeployCoreStatusFactory.INSTANCE
							.createDeployStatus(
									IStatus.ERROR,
									IWasValidatorID.WAS_V5_DB2DATASOURCE_WITH_REQUIREMENT_FOR_NON_DB2_DATABASE_001,
									ICoreProblemType.UNIT_REQUIREMENT_TYPE_INVALID,
									DeployNLS
											.bind(
													WasDomainMessages.Validator_WASV5DB2Datasource_0_with_non_DB2_database_requirement_1,
													unit, dbRequirement), bindings, unit);
					reporter.addStatus(status);
				}
			}
		}
	}

	protected void validateDataStoreHelper(Unit unit, IDeployReporter reporter) {
		if (!(unit instanceof WasDatasourceUnit)) {
			return;
		}

		// get the helper class
		WasDatasource datasource = (WasDatasource) ValidatorUtils.getFirstCapability(unit,
				WasPackage.Literals.WAS_DATASOURCE);
		// on a was v5 datasource has a data store helper class
		if (null == datasource || !(datasource instanceof WasV5Datasource)) {
			return;
		}
		WasV5Datasource v5Datasource = (WasV5Datasource) datasource;
		DataSourceHelperClassNames helperClass = v5Datasource.getDataSourceHelperClassName();

		DataSourceHelperClassNames expectedClassName = getExpectedDataStoreClassName(unit);
		if (null == expectedClassName) {
			return;
		}

		// compare actual with expected
		if (!expectedClassName.equals(helperClass)) {
			// report error status
			IDeployAttributeStatus status = DeployCoreStatusFactory.INSTANCE
					.createAttributeValueStatus(IStatus.ERROR,
							IWasValidatorID.WAS_DATASOURCE_DATA_STORE_HELPER_CLASS_NAME_INVALID,
							ICoreProblemType.OBJECT_ATTRIBUTE_INVALID,
							DeployCoreMessages.Validator_deploy_model_object_0_attribute_1_invalid,
							new Object[] {
									helperClass,
									WasPackage.eINSTANCE.getWasV5Datasource_DataSourceHelperClassName()
											.getName() }, v5Datasource, WasPackage.eINSTANCE
									.getWasV5Datasource_DataSourceHelperClassName(), expectedClassName);
			reporter.addStatus(status);
		}
	}

	public static DataSourceHelperClassNames getExpectedDataStoreClassName(Unit dsUnit) {
		// now check if the class name if right for the given provider
		// get the provider
		Unit unit = TopologyDiscovererService.INSTANCE.findHost(dsUnit, dsUnit.getTopology());
		if (!(unit instanceof JdbcProviderUnit)) {
			return null;
		}
		JdbcProviderUnit providerUnit = (JdbcProviderUnit) unit;
		DataSourceHelperClassNames expectedClassName = null;
		if (providerUnit instanceof DB2JdbcProviderUnit) {
			DB2JdbcProvider provider = (DB2JdbcProvider) ValidatorUtils.getFirstCapability(
					providerUnit, WasPackage.Literals.DB2_JDBC_PROVIDER);
			DB2JdbcProviderType providerType = provider.getTemplate();
			if (DB2JdbcProviderType.DB2_LEGACY_CLI_BASED_TYPE2_JDBC_DRIVER_LITERAL
					.equals(providerType)) {
				expectedClassName = DataSourceHelperClassNames.COM_IBM_WEBSPHERE_RSADAPTER_DB2_DATA_STORE_HELPER_LITERAL;
			} else if (DB2JdbcProviderType.DB2_LEGACY_CLI_BASED_TYPE2_JDBC_DRIVER_XA_LITERAL
					.equals(providerType)) {
				expectedClassName = DataSourceHelperClassNames.COM_IBM_WEBSPHERE_RSADAPTER_DB2_DATA_STORE_HELPER_LITERAL;
			} else if (DB2JdbcProviderType.DB2_UNIVERSAL_JDBC_DRIVER_PROVIDER_LITERAL
					.equals(providerType)) {
				expectedClassName = DataSourceHelperClassNames.COM_IBM_WEBSPHERE_RSADAPTER_DB2_UNIVERSAL_DATA_STORE_HELPER_LITERAL;
			} else if (DB2JdbcProviderType.DB2_UNIVERSAL_JDBC_DRIVER_PROVIDER_XA_LITERAL
					.equals(providerType)) {
				expectedClassName = DataSourceHelperClassNames.COM_IBM_WEBSPHERE_RSADAPTER_DB2_UNIVERSAL_DATA_STORE_HELPER_LITERAL;
			} else {
				// handle other types
			}
		} else if (providerUnit instanceof DerbyJdbcProvider) {
			DerbyJdbcProvider provider = (DerbyJdbcProvider) ValidatorUtils.getFirstCapability(
					providerUnit, WasPackage.Literals.DB2_JDBC_PROVIDER);
			DerbyJdbcProviderTypeType providerType = provider.getTemplate();
			if (DerbyJdbcProviderTypeType.CLOUDSCAPE_JDBC_PROVIDER_LITERAL.equals(providerType)) {
				expectedClassName = DataSourceHelperClassNames.COM_IBM_WEBSPHERE_RSADAPTER_CLOUDSCAPE_DATA_STORE_HELPER_CLASS_LITERAL;
			} else if (DerbyJdbcProviderTypeType.CLOUDSCAPE_JDBC_PROVIDER_XA_LITERAL
					.equals(providerType)) {
				expectedClassName = DataSourceHelperClassNames.COM_IBM_WEBSPHERE_RSADAPTER_CLOUDSCAPE_DATA_STORE_HELPER_CLASS_LITERAL;
			} else if (DerbyJdbcProviderTypeType.CLOUDSCAPE_NETWORK_SERVER_USING_UNIVERSAL_JDBC_DRIVER_LITERAL
					.equals(providerType)) {
				expectedClassName = DataSourceHelperClassNames.COM_IBM_WEBSPHERE_RSADAPTER_CLOUDSCAPE_NETWORK_SERVER_DATA_STORE_HELPER_LITERAL;
			} else {
				// handle other types; currently there are none; create warning status?
			}
		} else {
			// handle other cases; currently there are none; create warning status?
		}
		return expectedClassName;
	}
}

/**
 * Validates that the source of the dependency link is hosted on the same unit as the target of the
 * link.
 * <p>
 * Validation can be performed by depth, or by the type of the expected host (unit or capability).
 */
class DatasourceType2ToDatabaseLinkLocalValidator extends DependencyLinkLocalValidator {

	/**
	 * @deprecated
	 */
	public DatasourceType2ToDatabaseLinkLocalValidator(String validatorID, EClass capabilityType,
			EClass hostType, int severity) {
		super(validatorID, capabilityType, hostType, severity);
	}

	public DatasourceType2ToDatabaseLinkLocalValidator(String validatorID, int severity) {
		super(validatorID, DatabasePackage.eINSTANCE.getDatabase(), OsPackage.eINSTANCE
				.getOperatingSystem(), severity);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.pattern.link.DependencyLinkLocalValidator#appliesTo(com.ibm.ccl.soa.deploy.core.Requirement,
	 *      com.ibm.ccl.soa.deploy.core.Capability, com.ibm.ccl.soa.deploy.core.DependencyLink,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext)
	 */
	public boolean appliesTo(Requirement req, Capability cap, DependencyLink dl,
			IDeployValidationContext context) {
		boolean superVal = super.appliesTo(req, cap, dl, context);
		if (superVal) {
			if (dl.getSource() != null && dl.getSource().getParent() != null) {
				Unit parentUnit = (Unit) dl.getSource().getParent();
				if (parentUnit instanceof WasDatasourceUnit) {
					Unit parentUnitHost = ValidatorUtils.discoverHost(parentUnit, context
							.getProgressMonitor());
					if (parentUnitHost != null && parentUnitHost instanceof DB2JdbcProviderUnit) {
						DB2JdbcProvider db2JdbcProvider = (DB2JdbcProvider) ValidatorUtils.getCapability(
								parentUnitHost, WasPackage.eINSTANCE.getDB2JdbcProvider());
						if (db2JdbcProvider.getJdbcType().equals(JdbcTypeType._2_LITERAL)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.pattern.link.DependencyLinkLocalValidator#validate(com.ibm.ccl.soa.deploy.core.Requirement,
	 *      com.ibm.ccl.soa.deploy.core.Capability, com.ibm.ccl.soa.deploy.core.DependencyLink,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validate(Requirement sourceReq, Capability targetCap, DependencyLink link,
			IDeployValidationContext context, IDeployReporter reporter) {
		if (sourceReq == null || targetCap == null) {
			return;
		}

		Unit sourceHost = null;
		Unit targetHost = null;

		// cf. super: we know what we are doing so we ignore some things
		// it isn't really clear that extending DependencyLinkLocalValidator
		// is a good idea
		targetHost = searchHostByType((Unit) targetCap.getParent(), context);
		if (targetHost == null) {
			return;
		}

		Unit sourceUnit = (Unit) sourceReq.getParent();
		Unit wasUnit = TopologyDiscovererService.INSTANCE.findHost(sourceUnit,
				WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT, context.getTopology());
		if (null == wasUnit) {
			wasUnit = TopologyDiscovererService.INSTANCE.findHost(sourceUnit,
					WasPackage.Literals.WAS_NODE_UNIT, context.getTopology());
			if (null != wasUnit) {
				// check if it is a dmgr node in which case we reset
				WasNode node = (WasNode) ValidatorUtils.getFirstCapability(wasUnit,
						WasPackage.Literals.WAS_NODE);
				if (WasProfileTypeEnum.DMGR_LITERAL.equals(node.getProfileType())) {
					wasUnit = null;
				}
			}
		}
		if (null != wasUnit) {
			// we have a single server, we can look for os
			sourceHost = searchHostByType(sourceUnit, context);
			if (sourceHost == null) {
				return;
			}

			compareHosts(sourceReq, targetCap, link, sourceHost, targetHost, context, reporter);
		} else {
			// data source is not defined on the server or node
			// it must be on a cluster or cell
			// we must find a list of nodes

			List wasNodes = null;
			wasUnit = TopologyDiscovererService.INSTANCE.findHost(sourceUnit,
					WasPackage.Literals.WAS_CLUSTER_UNIT, context.getTopology());
			if (null == wasUnit) {
				wasUnit = TopologyDiscovererService.INSTANCE.findHost(sourceUnit,
						WasPackage.Literals.WAS_CELL_UNIT, context.getTopology());
			}
			if (null == wasUnit) {
				return;
			}
			wasNodes = WebsphereContext.getWasNodes(wasUnit, context.getTopology());

			// we have a list of nodes
			// if there are none then we can quit
			// if there is one we can validate it
			// if there are more than one then we need to flag it

			if (wasNodes.size() == 0) {
				return;
			}
			if (wasNodes.size() == 1) {
				// handle single node
				WasNodeUnit wasNodeUnit = (WasNodeUnit) wasNodes.get(0);
				sourceHost = searchHostByType(wasNodeUnit, context);
				if (sourceHost == null) {
					return;
				}

				compareHosts(sourceReq, targetCap, link, sourceHost, targetHost, context, reporter);
			} else {
				// handle more than one
				// TODO
			}
		}
	}

	/**
	 * Returns the first unit down the hosting stack to satisfy {@link #isHostTypeMatch(Unit)}.
	 * 
	 * @param unit
	 *           the unit where the search begins (may be returned).
	 * @param context
	 *           the validation context.
	 * @return the matching unit, or null if not found.
	 */
	protected Unit searchHostByType(Unit unit, IDeployValidationContext context) {
		while (unit != null) {
			if (isHostTypeMatch(unit)) {
				return unit;
			}
			unit = TopologyDiscovererService.INSTANCE.findHost(unit, context.getTopology());
		}
		return null;
	}

}

class AliasNotEmptyValidator extends DeployAttributeStringNotEmptyValidator {

	public AliasNotEmptyValidator(String validatorID, EAttribute attribute, int severity) {
		super(validatorID, attribute, severity);
	}

	public void validate(DeployModelObject object, IDeployValidationContext context,
			IDeployReporter reporter) {
		Capability cap = (Capability) object;
		Unit unit = (Unit) cap.getParent();
		assert unit != null;
		List j2cAuthEntryReqs = ValidatorUtils.findRequirements(unit,
				WasPackage.Literals.WASJ2C_AUTHENTICATION_DATA_ENTRY,
				RequirementLinkTypes.DEPENDENCY_LITERAL);
		if (j2cAuthEntryReqs.size() > 0) {
			if ((Requirement) j2cAuthEntryReqs.get(0) != null) {
				if (!((Requirement) j2cAuthEntryReqs.get(0)).getUse().equals(
						RequirementUsage.OPTIONAL_LITERAL)) {
					super.validate(object, context, reporter);
				}
			}
		}
	}
}

class DbNameValidator extends DeployAttributeValidator {

	/**
	 * Constructor
	 */
	public DbNameValidator() {
		super(IWasValidatorID.J2EE_DATASOURCE_FROM_DB2_DATABASE_DB_NAME,
				J2eePackage.Literals.J2EE_DATASOURCE__DB_NAME);
	}

	public void validate(DeployModelObject object, IDeployValidationContext context,
			IDeployReporter reporter) {
		// given a datasource, we need to find a corresponding database and validate the name matches
		// stategies to apply:
		// (a) is there a dependency link?
		// (b) is there a communication constraint linking a consumer of the datasource to a database?
		// (c) is there a database hosted on a server with matching hostname (and port)
		if (null == object) {
			return;
		}
		// we only know how to validate one type of datasource
		if (!WasPackage.Literals.WAS_V5DB2_DATASOURCE.isSuperTypeOf(object.getEObject().eClass())) {
			return;
		}

		Topology t = context.getTopology();
		IProgressMonitor m = context.getProgressMonitor();
		WasV5Datasource ds = (WasV5Datasource) object;

		// (a) is there a dependency link?
		DB2Database dbCap = validateViaDependencyLinkTarget(ds, t, m);
		if (null != dbCap) {
			// found one; use it
			// in this case we quit; we already registered a validator for this case
			return;
		}

		// (b) is there a communication constraint linking a consumer of the datasource to a database?
		// (c) is there a database hosted on a server with matching hostname (and port)
		// search first for databases linked then general search if none
		validateViaDatabaseSearch(ds, t, m, reporter);
	}

	private DB2Database validateViaDependencyLinkTarget(Capability cap, Topology top,
			IProgressMonitor monitor) {
		Requirement req = ValidatorUtils.getFirstRequirement(cap, Db2Package.Literals.DB2_DATABASE);
		if (null == req) {
			return null;
		}
		Capability targetCap = ValidatorUtils.discoverDependencyLinkTarget(req, top, monitor);
		if (null == targetCap) {
			return null;
		}
		if (!Db2Package.Literals.DB2_DATABASE.isSuperTypeOf(targetCap.getEObject().eClass())) {
			return null;
		}
		return (DB2Database) targetCap;
	}

	private static final String CLIENT = "CLIENT"; //$NON-NLS-1$
	private static final String LOCAL_SERVER = "LOCAL_SERVER"; //$NON-NLS-1$
	private static final String REMOTE_SERVER = "REMOTE_SERVER"; //$NON-NLS-1$

	/**
	 * Assumes that the list of databases was deter
	 * 
	 * @param ds
	 *           the datasource
	 * @param databases
	 *           a list of possible matching databases
	 */
	private void validateViaDatabaseSearch(WasV5Datasource ds, Topology top,
			IProgressMonitor monitor, IDeployReporter reporter) {

		Set<DeployModelObject> databases = findDatabasesByLinks(ds, top, monitor);
		if (0 == databases.size()) {
			Set<String> databaseTypes = new HashSet<String>();
			JdbcTypeType jdbcType = getJdbcType(ds, monitor);
			if (null == jdbcType) {
				// look for all databases and clients on all hosts
				databaseTypes.add(CLIENT);
				databaseTypes.add(LOCAL_SERVER);
				databaseTypes.add(REMOTE_SERVER);
			} else if (JdbcTypeType._2_LITERAL.equals(jdbcType)) {
				// look for databases or clients on local host
				databaseTypes.add(CLIENT);
				databaseTypes.add(LOCAL_SERVER);
			} else if (JdbcTypeType._4_LITERAL.equals(jdbcType)) {
				// look for databases on remote hosts
				databaseTypes.add(CLIENT);
				databaseTypes.add(LOCAL_SERVER);
				databaseTypes.add(REMOTE_SERVER);
			} else {
				// don't know how to handle it
				return;
			}

			databases = findDatabases(ds, databaseTypes, top, monitor);
		}
		if (0 == databases.size()) {
			// we aren't able to identify a target database that we are configuring
			IDeployStatus s = new WasDeployStatus(IStatus.WARNING,
					IWasValidatorID.WAS_DATASOURCE_MATCHING_DB_IDENTIFICATION_001,
					IWASProblemType.WAS_DATASOURCE_MATCHING_DB_NOT_IDENTIFIED,
					WasDomainMessages.Validator_Cannot_identify_target_database_for_datasource,
					new Object[] {}, ds);
			reporter.addStatus(s);
			return;
		}

		DeployModelObjectMatcher dsMatcher = new DeployModelObjectMatcher(ds,
				new EAttribute[] { J2eePackage.Literals.J2EE_DATASOURCE__DB_NAME });
		dsMatcher.compare(databases, new EAttribute[] { Db2Package.Literals.DB2_DATABASE__DB_NAME });

		// If at least one database matches, we have "validated" the datasource
		if (dsMatcher.hasExactMatch()) {
			// do nothing; we have a valid database match
			// This status is for debugging only
//			IDeployStatus s = new WasDeployStatus(
//					IStatus.INFO,
//					IWasValidatorID.WAS_DATASOURCE_MATCHING_DB_IDENTIFICATION_001,
//					IWASProblemType.WAS_DATASOURCE_MATCHING_DB_IDENTIFIED,
//					"Found at least one matching database.", //$NON-NLS-1$
//					new Object[] {}, ds);
//			reporter.addStatus(s);
			return;
		}

		// If there are no compatible databases, we don't have a possible target
		if (!dsMatcher.hasCompatibleMatch()) {
			IDeployStatus s = new WasDeployStatus(IStatus.WARNING,
					IWasValidatorID.WAS_DATASOURCE_MATCHING_DB_IDENTIFICATION_001,
					IWASProblemType.WAS_DATASOURCE_MATCHING_DB_NOT_IDENTIFIED,
					WasDomainMessages.Validator_Cannot_identify_target_database_for_datasource,
					new Object[] {}, ds);
			reporter.addStatus(s);
			return;
		}

		// There is at least one compatible database
		// Cache on status all of the possible values for use by a resolution
		Map<EAttribute, Set<Object>> attrValueMap = dsMatcher.getValueOptions();
		for (Iterator<EAttribute> aIt = attrValueMap.keySet().iterator(); aIt.hasNext();) {
			EAttribute attr = aIt.next();
			Set<Object> possibleValues = attrValueMap.get(attr);
			if (null == possibleValues) {
				continue;
			}
			EnumerationConstraint ec = ConstraintFactory.eINSTANCE.createEnumerationConstraint();
			ec.setAttributeName(attr.getName());
			List<SingleValue> enumValues = ec.getValues();
			for (Iterator<Object> vIt = possibleValues.iterator(); vIt.hasNext();) {
				Object possibleValue = vIt.next();
				SingleValue v = ConstraintFactory.eINSTANCE.createSingleValue();
				v.setValueObject(possibleValue);
				enumValues.add(v);
			}
			List<Constraint> constraints = new ArrayList<Constraint>();
			constraints.add(ec);
			IDeployStatus avs = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(
					IStatus.WARNING, IWasValidatorID.WAS_DATASOURCE_MATCHING_DB_IDENTIFICATION_001,
					IWASProblemType.WAS_DATASOURCE_MATCHING_DB_NOT_IDENTIFIED,
					WasDomainMessages.Validator_Database_name_does_not_match_defined_databases,
					new Object[] {}, ds, attr, constraints);
			reporter.addStatus(avs);
		}
		return;
	}

	private Set<DeployModelObject> findDatabasesByLinks(WasV5Datasource ds, Topology topology,
			IProgressMonitor monitor) {
		Set<DeployModelObject> candidates = new HashSet<DeployModelObject>();
		List<Requirement> sourceRequirements = ValidatorUtils.discoverDependencyLinkSources(ds,
				monitor);
		for (Requirement req : sourceRequirements) {
			Unit unit = ValidatorUtils.getOwningUnit(req);
			List<ConstraintLink> links = unit.getConstraintLinks();
			for (ConstraintLink link : links) {
				List<Constraint> commConstraints = ConstraintUtil.getConstraints(link,
						ConstraintPackage.Literals.BASE_COMMUNICATION_CONSTRAINT);
				if (0 != commConstraints.size()) {
					Unit target = ValidatorUtils.getUnit(link.getTarget());
					Capability cap = ValidatorUtils.getFirstCapability(target,
							Db2Package.Literals.DB2_DATABASE);
					if (null != cap) {
						candidates.add(cap);
					} else {
						Unit dbUnit = ValidatorUtils.discoverHostInStackWithCapability(target,
								Db2Package.Literals.DB2_DATABASE, monitor);
						if (null != dbUnit) {
							// found database at end of communication link
							candidates.add(ValidatorUtils.getFirstCapability(dbUnit,
									Db2Package.Literals.DB2_DATABASE));
						}
					}
				}
			}
		}
		return candidates;
	}

	private JdbcTypeType getJdbcType(WasV5Datasource datasource, IProgressMonitor monitor) {
		DB2JdbcProvider provider = (DB2JdbcProvider) ValidatorUtils.discoverHostCapability(
				datasource, WasPackage.Literals.DB2_JDBC_PROVIDER, monitor);
		if (null == provider) {
			// try other provider types if any known; otherwise...
			return null;
		}

		return provider.getJdbcType();
	}

	private Set<DeployModelObject> findDatabases(WasV5Datasource ds, Set<String> databaseTypes,
			Topology topology, IProgressMonitor monitor) {

		DiscoveryFilter df = DiscoveryFilterFactory.createEmptyFilter(topology);
		Set<DeployModelObject> candidates = new HashSet<DeployModelObject>();

		if (databaseTypes.contains(CLIENT)) {
			df.setUnitTypes(new Class[] { DB2CatalogUnit.class });
			df.setInitInstallState(InstallState.VALUES);
			for (UnitDescriptor ud : TopologyDiscovererService.INSTANCE.findAll(df)) {
				DB2CatalogUnit dbUnit = (DB2CatalogUnit) ud.getUnitValue();
				DB2Database db = (DB2Database) ValidatorUtils.getFirstCapability(dbUnit,
						Db2Package.Literals.DB2_DATABASE);
				// filter databases where hostname same
				if (!haveDifferentHostnames(ds, db, monitor) && !haveDifferentDbNames(ds, db, monitor)
						&& isSameOs(ds, db, monitor)) {
					candidates.add(db);
				}
			}
		}
		if (databaseTypes.contains(LOCAL_SERVER)) {
			df.setUnitTypes(new Class[] { DB2DatabaseUnit.class });
			df.setInitInstallState(InstallState.VALUES);
			for (UnitDescriptor ud : TopologyDiscovererService.INSTANCE.findAll(df)) {
				DB2DatabaseUnit dbUnit = (DB2DatabaseUnit) ud.getUnitValue();
				DB2Database db = (DB2Database) ValidatorUtils.getFirstCapability(dbUnit,
						Db2Package.Literals.DB2_DATABASE);
				// filter databases where hostname same
				if (!haveDifferentHostnames(ds, db, monitor) && !haveDifferentDbNames(ds, db, monitor)
						&& isSameOs(ds, db, monitor)) {
					candidates.add(db);
				}
			}
		}
		if (databaseTypes.contains(REMOTE_SERVER)) {
			df.setUnitTypes(new Class[] { DB2DatabaseUnit.class });
			df.setInitInstallState(InstallState.VALUES);
			for (UnitDescriptor ud : TopologyDiscovererService.INSTANCE.findAll(df)) {
				DB2DatabaseUnit dbUnit = (DB2DatabaseUnit) ud.getUnitValue();
				DB2Database db = (DB2Database) ValidatorUtils.getFirstCapability(dbUnit,
						Db2Package.Literals.DB2_DATABASE);
				// filter databases where hostname differs
				if (!haveDifferentHostnames(ds, db, monitor) && !haveDifferentDbNames(ds, db, monitor)
						&& !haveDifferentPorts(ds, db, monitor) && !isSameOs(ds, db, monitor)) {
					candidates.add(db);
				}
			}
		}

		return candidates;
	}

	private boolean haveDifferentHostnames(WasV5Datasource ds, DB2Database db,
			IProgressMonitor monitor) {
		String dsHostname = (String) DeployModelObjectUtil.getAttributeValue(ds,
				J2eePackage.Literals.J2EE_DATASOURCE__HOSTNAME);
		if (null == dsHostname) {
			// don't know hostname; can't test if different
			return false;
		}

		// if either hostname on instance or on os differ (and can't me made the same) then return true
		// if they are different then one is wrong.... and its correction leads to a reevaluation anyway
		DB2Instance dbi = (DB2Instance) ValidatorUtils.discoverHostCapability(db,
				Db2Package.Literals.DB2_INSTANCE, monitor);
		if (null != dbi) {
			String dbiHostname = (String) DeployModelObjectUtil.getAttributeValue(dbi,
					Db2Package.Literals.DB2_INSTANCE__HOSTNAME);
			if (null != dbiHostname
					&& !dsHostname.equals(dbiHostname)
					&& !DeployModelObjectUtil
							.isSettable(dbi, Db2Package.Literals.DB2_INSTANCE__HOSTNAME)) {
				return true;
			}
		}

		Unit osUnit = ValidatorUtils.discoverHostInStack(ValidatorUtils.getOwningUnit(db),
				OsPackage.Literals.OPERATING_SYSTEM_UNIT, monitor);
		OperatingSystem os = (OperatingSystem) ValidatorUtils.getFirstCapability(osUnit,
				OsPackage.Literals.OPERATING_SYSTEM);
		String osHostname = (String) DeployModelObjectUtil.getAttributeValue(os,
				OsPackage.Literals.OPERATING_SYSTEM__HOSTNAME);
		if (null != osHostname
				&& !dsHostname.equals(osHostname)
				&& !DeployModelObjectUtil.isSettable(osUnit,
						OsPackage.Literals.OPERATING_SYSTEM__HOSTNAME)) {
			return true;
		}

		return false;
	}

	private boolean haveDifferentDbNames(WasV5Datasource ds, DB2Database db, IProgressMonitor monitor) {
		String dsDbName = (String) DeployModelObjectUtil.getAttributeValue(ds,
				J2eePackage.Literals.J2EE_DATASOURCE__DB_NAME);
		if (null == dsDbName) {
			// don't know database name; can't test if different
			return false;
		}

		// if database name on database is different (and can't be made the same) can ignore
		// if they are different then one is wrong.... and its correction leads to a reevaluation anyway
		String dbName = (String) DeployModelObjectUtil.getAttributeValue(db,
				Db2Package.Literals.DB2_DATABASE__DB_NAME);
		if (null != dbName && !dsDbName.equals(dbName)
				&& !DeployModelObjectUtil.isSettable(db, Db2Package.Literals.DB2_DATABASE__DB_NAME)) {
			return true;
		}

		return false;
	}

	private boolean haveDifferentPorts(WasV5Datasource ds, DB2Database db, IProgressMonitor monitor) {
		BigInteger dsPort = (BigInteger) DeployModelObjectUtil.getAttributeValue(ds,
				J2eePackage.Literals.J2EE_DATASOURCE__PORT);
		if (null == dsPort) {
			// don't know hostname; can't test if different
			return false;
		}

		// if either hostname on instance or on os differ (and can't be made the same) then return true
		// if they are different then one is wrong.... and its correction leads to a reevaluation anyway
		DB2Instance dbi = (DB2Instance) ValidatorUtils.discoverHostCapability(db,
				Db2Package.Literals.DB2_INSTANCE, monitor);
		BigInteger dbiPort = (BigInteger) DeployModelObjectUtil.getAttributeValue(dbi,
				Db2Package.Literals.DB2_INSTANCE__PORT);
		if (null != dbiPort && !dsPort.equals(dbiPort)
				&& !DeployModelObjectUtil.isSettable(dbi, Db2Package.Literals.DB2_INSTANCE__PORT)) {
			return true;
		}

		return false;
	}

	private Boolean isSameOs(WasV5Datasource ds, DB2Database db, IProgressMonitor monitor) {
		Unit dsOs = ValidatorUtils.discoverHostInStack(ValidatorUtils.getOwningUnit(ds),
				OsPackage.Literals.OPERATING_SYSTEM_UNIT, monitor);
		Unit dbOs = ValidatorUtils.discoverHostInStack(ValidatorUtils.getOwningUnit(db),
				OsPackage.Literals.OPERATING_SYSTEM_UNIT, monitor);
		if (null == dsOs || null == dsOs) {
			return null;
		}
		return new Boolean(dsOs == dbOs);
	}

}
