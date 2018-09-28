/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2.validator.constraint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.DiscoveryFilter;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.constraint.ShortConstraintDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.DiscoveryFilterFactory;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.util.CapabilityUtil;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.util.RealizationLinkUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.constraints.ConstraintValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.database.Database;
import com.ibm.ccl.soa.deploy.database.DatabasePackage;
import com.ibm.ccl.soa.deploy.database.DatabaseUnit;
import com.ibm.ccl.soa.deploy.db2.DB2AdminClientUnit;
import com.ibm.ccl.soa.deploy.db2.DB2AppDevelClientUnit;
import com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode;
import com.ibm.ccl.soa.deploy.db2.DB2ClientInstanceUnit;
import com.ibm.ccl.soa.deploy.db2.DB2Database;
import com.ibm.ccl.soa.deploy.db2.DB2Instance;
import com.ibm.ccl.soa.deploy.db2.DB2InstanceUnit;
import com.ibm.ccl.soa.deploy.db2.DB2RuntimeClientUnit;
import com.ibm.ccl.soa.deploy.db2.DB2SystemUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationDataEntry;
import com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationUnit;
import com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.java.JdbcProviderUnit;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.User;
import com.ibm.ccl.soa.deploy.os.UserUnit;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProviderUnit;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasDatasource;
import com.ibm.ccl.soa.deploy.was.WasDatasourceUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasV5Datasource;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.db2.DatasourceSatisfactionConstraint;
import com.ibm.ccl.soa.deploy.was.db2.WasDB2Plugin;
import com.ibm.ccl.soa.deploy.was.db2.WasDb2Package;
import com.ibm.ccl.soa.deploy.was.db2.internal.Messages;
import com.ibm.ccl.soa.deploy.was.db2.internal.validator.IEarToDbLinkValidatorID;
import com.ibm.ccl.soa.deploy.was.db2.validator.IWasDb2ProblemType;
import com.ibm.ccl.soa.deploy.was.db2.validator.status.DatasourceSatisfactionStatus;
import com.ibm.ccl.soa.deploy.was.util.jdbcprovider.WebsphereContext;

/**
 * Validator for {@link DatasourceSatisfactionConstraint} on a {@link ConstraintLink}.
 */
public class DatasourceSatisfactionConstraintValidator extends ConstraintValidator {

	private static final IStatus VALIDATION_FAILURE = new Status(IStatus.ERROR,
			WasDB2Plugin.PLUGIN_ID, 0, Messages.DatasourceSatisfactionConstraint_validation_failure,
			null);

	private static final String TCPIP = "TCPIP"; //$NON-NLS-1$

	/*
	 * List of preconditions to check for ability to "implement" the constraint. Execution of the
	 * guards creates statuses on the constraint to inform the user what preconditions are necessary
	 * for "implementation".
	 */
	// MK 7/23/2007 removed guard: EAR2DB2GuardDbUserCheck since the user does not need to be the db admin user
	private static final IConstraintResolutionPrecondition[] guards = new IConstraintResolutionPrecondition[] {
			new EAR2DB2GuardEarHosted(), new EAR2DB2GuardDbHosted(), new EAR2DB2GuardInstanceCheck(),
			new EAR2DB2GuardCellDefined() };

	@Override
	public List<ShortConstraintDescriptor> applicableConstraints(Constraint parentConstraint,
			List<ShortConstraintDescriptor> potentialConstraints) {
		return Collections.emptyList();
	}

	@Override
	public boolean canValidateConstraint(Constraint constraint) {
		return WasDb2Package.Literals.DATASOURCE_SATISFACTION_CONSTRAINT.isSuperTypeOf(constraint
				.getEObject().eClass());
	}

	@Override
	public DeployModelObject getContextForChildConstraints(Constraint constraint) {
		return null;
	}

	@Override
	public IStatus validate(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor) {

		// validate constraint context
		if (null == context) {
			ConstraintUtil.createNullContextStatus(constraint);
		}
		if (!CorePackage.Literals.CONSTRAINT_LINK.isSuperTypeOf(context.getEObject().eClass())
				&& !CorePackage.Literals.DEPENDENCY_LINK.isSuperTypeOf(context.getEObject().eClass())) {
			return ConstraintUtil.createInvalidContextStatus(constraint, context);
		}

		Requirement srcReq = null;
		Database target = null;

		if (CorePackage.Literals.CONSTRAINT_LINK.isSuperTypeOf(context.getEObject().eClass())) {
			ConstraintLink link = (ConstraintLink) context;
			if (!linkEndpointsValid(link.getSource(), J2eePackage.Literals.J2EE_DATASOURCE, link
					.getTarget(), new EClass[] { DatabasePackage.Literals.DATABASE,
					DatabasePackage.Literals.DATABASE_UNIT,
					DatabasePackage.Literals.DATABASE_DEFINITION,
					DatabasePackage.Literals.DATABASE_COMPONENT })) {
				return ConstraintUtil.createInvalidContextStatus(constraint, context);
			}
			// we expect only one type of target: Requirement (J2EEDatasource
			srcReq = (Requirement) link.getSource();
			// there may be many types of targets; the common thread is the Database capability
			target = EarToDbUtil.getDatabaseFromConstraint(constraint, context, monitor);
		} else if (CorePackage.Literals.DEPENDENCY_LINK.isSuperTypeOf(context.getEObject().eClass())) {
			DependencyLink link = (DependencyLink) context;
			if (!linkEndpointsValid(link.getSource(), J2eePackage.Literals.J2EE_DATASOURCE, link
					.getTarget(), new EClass[] { DatabasePackage.Literals.DATABASE,
					DatabasePackage.Literals.DATABASE_UNIT,
					DatabasePackage.Literals.DATABASE_DEFINITION,
					DatabasePackage.Literals.DATABASE_COMPONENT })) {
				return ConstraintUtil.createInvalidContextStatus(constraint, context);
			}
			// we expect only one type of target: Requirement (J2EEDatasource
			srcReq = link.getSource();
			// there may be many types of targets; the common thread is the Database capability
			target = EarToDbUtil.getDatabaseFromConstraint(constraint, context, monitor);
		} else {
			return ConstraintUtil.createInvalidContextStatus(constraint, context);
		}

		// actually validate the constraint
		// MK 01/18/2008 defect 5211 [process using final realization]
		IStatus implementationStatus = validate(constraint, srcReq, (Unit) RealizationLinkUtil
				.getFinalRealization(ValidatorUtils.getOwningUnit(target)), monitor);
		if (implementationStatus.isOK()) {
			return implementationStatus;
		}

		// check if we know how to implement a resolution for this
		return checkResolutionPreconditions(constraint, context, monitor);
	}

	private boolean linkEndpointsValid(DeployModelObject linkSrcObj, EClass srcType,
			DeployModelObject linkTargetObj, EClass[] targetTypes) {
		if (!linkSourceValid(linkSrcObj, srcType)) {
			return false;
		}
		return linkTargetValid(linkTargetObj, targetTypes);
	}

	private boolean linkSourceValid(DeployModelObject linkSrcObj, EClass srcType) {
		if (null == linkSrcObj
				|| !CorePackage.Literals.REQUIREMENT.isSuperTypeOf(linkSrcObj.getEObject().eClass())) {
			return false;
		}
		Requirement req = (Requirement) linkSrcObj;
		if (!srcType.isSuperTypeOf(req.getDmoEType())) {
			return false;
		}
		return true;
	}

	private boolean linkTargetValid(DeployModelObject linkTargetObj, EClass[] targetTypes) {
		if (null == linkTargetObj) {
			return false;
		}
		EClass linkTargetType = linkTargetObj.getEObject().eClass();
		for (int i = 0; i < targetTypes.length; i++) {
			if (targetTypes[i].isSuperTypeOf(linkTargetType)) {
				return true;
			}
		}
		return false;
	}

	protected static IStatus validate(Constraint constraint, Requirement dsRequirement, Unit target,
			IProgressMonitor monitor) {
		try {
			Topology topology = dsRequirement.getEditTopology();

			// MK 12/7/2006 the matcher/tester takes care of this
//			Unit sourceUnit = LogicalLinkUtils.getLogicalLinkSourceUnit(link);
//			// Not this logical link
//			if (!(sourceUnit instanceof EarModule)
//					&& !(sourceUnit instanceof EjbModule)
//					&& !(sourceUnit instanceof WebModule)) {
//				return LogicalLinkImplementation.VALIDATION_FAILURE;				
//			}			

			if (null == dsRequirement) {
				return VALIDATION_FAILURE;
			}
			if (!J2eePackage.Literals.J2EE_DATASOURCE.isSuperTypeOf(dsRequirement.getDmoEType())) {
				return VALIDATION_FAILURE;
			}

			Unit source = ValidatorUtils.getOwningUnit(dsRequirement);
			if (null == source) {
				return VALIDATION_FAILURE;
			}

			if (null == target) {
				return VALIDATION_FAILURE;
			}
			if (!Db2Package.Literals.DB2_DATABASE_UNIT.isSuperTypeOf(target.getEObject().eClass())) {
				return VALIDATION_FAILURE;
			}

			// verify expected nodes exist (added was configuration)
			UnitDescriptor dsUnitUD = TopologyDiscovererService.INSTANCE.findTarget(source,
					dsRequirement, topology, monitor);
			if (null == dsUnitUD) {
				return VALIDATION_FAILURE;
			}
			Unit dsUnit = dsUnitUD.getUnitValue();
			if (null == dsUnit) {
				return VALIDATION_FAILURE;
			}
			if (!validateDatasource((WasDatasourceUnit) dsUnit)) {
				return VALIDATION_FAILURE;
			}

			// check that datasource hosted on same was as module

			// j2cAuthUnit checks done after earContext and dsOsUnit determined

//			System.out.println ("*******************"); //$NON-NLS-1$
			Unit jdbcProviderUnit = TopologyDiscovererService.INSTANCE.findHost(dsUnit,
					WasPackage.Literals.DB2_JDBC_PROVIDER_UNIT, topology, monitor);
//			System.out.println ("*******************"); //$NON-NLS-1$
			if (null == jdbcProviderUnit) {
				return VALIDATION_FAILURE;
			}
			if (!validateJdbcProvider(jdbcProviderUnit)) {
				return VALIDATION_FAILURE;
			}

			// nodes that should have existed up front (database hosting stack)
			Unit dbUnit = target;
			Unit instanceUnit = TopologyDiscovererService.INSTANCE.findHost(dbUnit,
					Db2Package.Literals.DB2_INSTANCE_UNIT, topology, monitor);
			if (null == instanceUnit) {
				return VALIDATION_FAILURE;
			}
			Unit systemUnit = TopologyDiscovererService.INSTANCE.findHost(instanceUnit,
					Db2Package.Literals.DB2_SYSTEM_UNIT, topology, monitor);
			if (null == systemUnit) {
				return VALIDATION_FAILURE;
			}
			UnitDescriptor dbOsUD = TopologyDiscovererService.INSTANCE.findHostUD(systemUnit,
					topology, monitor);
			if (null == dbOsUD) {
				return VALIDATION_FAILURE;
			}
			OperatingSystemUnit dbOsUnit = (OperatingSystemUnit) dbOsUD.getUnitValue();
			if (null == dbOsUnit) {
				return VALIDATION_FAILURE;
			}

			Unit userUnit = TopologyDiscovererService.INSTANCE.findTarget(instanceUnit,
					OsPackage.Literals.USER, topology, monitor);
			if (userUnit == null) {
				return VALIDATION_FAILURE;
			}

			DatabaseContext dbContext = new DatabaseContext((DatabaseUnit) dbUnit,
					(DB2InstanceUnit) instanceUnit, (DB2SystemUnit) systemUnit, dbOsUnit,
					(UserUnit) userUnit);

			// and EAR hosting stack
			Unit wasUnit = TopologyDiscovererService.INSTANCE.findHost(source, topology, monitor);
			// MK 2/27/2007 modified to allow for source module contained in EarModule instead of directly hosted
			if (null == wasUnit) {
				// MK 01/18/2008 defect 5211 [process using final realization]
				Unit earModule = ValidatorUtils.discoverGroupByUnitType(source,
						J2eePackage.Literals.EAR_MODULE, monitor);
				// Unit earModule = ValidatorUtils.findGroupByUnitType(source,
				//		J2eePackage.Literals.EAR_MODULE);
				if (null == earModule) {
					return VALIDATION_FAILURE;
				}
				wasUnit = TopologyDiscovererService.INSTANCE.findHost(earModule, topology, monitor);
			}
			if (null == wasUnit) {
				return VALIDATION_FAILURE;
			}

			// check that datasource is hosted on same wasUnit as (ear) module
//			Unit dsWasUnit = (Unit) TopologyDiscovererService.INSTANCE.findHost(dsUnit, WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT, link.getTopology());
//			if (null == dsWasUnit) {
//				dsWasUnit = (Unit) TopologyDiscovererService.INSTANCE.findHost(dsUnit, WasPackage.Literals.WAS_CLUSTER_UNIT, link.getTopology());
//			}
//			if (null == dsWasUnit) return LogicalLinkImplementation.VALIDATION_FAILURE;
//			
//			if (wasUnit != dsWasUnit) {
//				return LogicalLinkImplementation.VALIDATION_FAILURE;
//			}
//			
			WebsphereContext earContext = new WebsphereContext(wasUnit); // , link.getTopology());

			Unit dsWasUnit = TopologyDiscovererService.INSTANCE.findHost(dsUnit,
					WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT, topology, monitor);
			if (null == dsWasUnit) {
				dsWasUnit = TopologyDiscovererService.INSTANCE.findHost(dsUnit,
						WasPackage.Literals.WAS_CLUSTER_UNIT, topology, monitor);
			}
			if (null == dsWasUnit) {
				dsWasUnit = TopologyDiscovererService.INSTANCE.findHost(dsUnit,
						WasPackage.Literals.WAS_CELL_UNIT, topology, monitor);
			}
			if (null == dsWasUnit) {
				dsWasUnit = TopologyDiscovererService.INSTANCE.findHost(dsUnit,
						WasPackage.Literals.WAS_NODE_UNIT, topology, monitor);
			}
			if (null == dsWasUnit) {
				return VALIDATION_FAILURE;
			}

			if (!earContext.isInContext(dsWasUnit)) {
				return VALIDATION_FAILURE;
			}

			Unit j2cAuthUnit = TopologyDiscovererService.INSTANCE.findTarget(dsUnit,
					WasPackage.Literals.WASJ2C_AUTHENTICATION_DATA_ENTRY,
					J2eePackage.Literals.J2C_AUTHENTICATION_UNIT, topology, monitor);
			if (null == j2cAuthUnit) {
				// the link is optional... perhaps it has not been set. We can
				// still find a j2c authentication entry by search on alias
				String alias = (String) CapabilityUtil.getAttributeFromUnitCapability(dsUnit,
						WasPackage.Literals.WAS_V5_DATASOURCE__J2C_AUTH_ALIAS,
						WasPackage.Literals.WAS_V5_DATASOURCE);
				j2cAuthUnit = findAuthenticationUnitByAlias(alias, earContext.getCellUnit(), topology,
						monitor);
			}
			// if we still haven't found it then report and error
			if (null == j2cAuthUnit) {
				return VALIDATION_FAILURE;
			}
			if (!validateJ2CAuthentication((J2CAuthenticationUnit) j2cAuthUnit, dbOsUnit, monitor)) {
				return VALIDATION_FAILURE;
			}

			// need to ensure catalogUnit/nodeUnit/client present on all nodes
			if (wasUnit instanceof WasClusterUnit) {
				List<UnitDescriptor> nodeUDs = getEarHostingOs((WasClusterUnit) wasUnit, topology,
						monitor);
				for (int i = 0; i < nodeUDs.size(); i++) {
					UnitDescriptor osUnitUD = nodeUDs.get(i);
					if (!validateNode(osUnitUD, dbContext, null, (WasDatasourceUnit) dsUnit, topology,
							monitor)) {
						return VALIDATION_FAILURE;
					}
				}
			} else if (wasUnit instanceof WebsphereAppServerUnit) {
				UnitDescriptor osUnitUD = TopologyDiscovererService.INSTANCE.findHostUD(wasUnit,
						OsPackage.Literals.OPERATING_SYSTEM_UNIT, topology, monitor);
				if (!validateNode(osUnitUD, dbContext, null, (WasDatasourceUnit) dsUnit, topology,
						monitor)) {
					return VALIDATION_FAILURE;
				}
			}
			return Status.OK_STATUS;
		} catch (Exception e) {
			e.printStackTrace();
			return VALIDATION_FAILURE;
		}
	}

	/**
	 * Validate that propogated fields on a {@link WasDatasource} are valid. That is:
	 * <ul>
	 * <li>datasource name is set</li>
	 * <li>datasource alias matches referenced j2c authentication alias</li>
	 * </ul>
	 * <p>
	 * Validations that the hostname and database names are consistent are done per node in
	 * validateNode
	 * 
	 * @param dsUnit
	 *           the data source unit
	 * @return true if valid; false otherwise
	 */
	private static boolean validateDatasource(WasDatasourceUnit dsUnit) {
		WasDatasource ds = (WasDatasource) ValidatorUtils.getFirstCapability(dsUnit,
				WasPackage.Literals.WAS_DATASOURCE);
		// test datasource name is set
		if (null == ds.getDatasourceName()) {
			return false;
		}

		// test alias
		J2CAuthenticationDataEntry j2c = (J2CAuthenticationDataEntry) ValidatorUtils
				.getFirstRequirementLinkTargetCapability(dsUnit,
						J2eePackage.Literals.J2C_AUTHENTICATION_DATA_ENTRY);
		if (null != j2c) {
			// if found j2c auth then must have been a v5 datasource
			if (null == j2c.getAlias()
					|| !j2c.getAlias().equals(((WasV5Datasource) ds).getJ2cAuthAlias())) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Identify a J2C Authentication Unit from its alias and from its hosting cell unit.
	 * 
	 * @param alias
	 *           the alias of the authentication entry
	 * @param cellUnit
	 *           the hosting cell unit
	 * @param topology
	 *           the current topology
	 * @return the authentication unit or null if none can be found
	 */
	private static J2CAuthenticationUnit findAuthenticationUnitByAlias(String alias,
			WasCellUnit cellUnit, Topology topology, IProgressMonitor monitor) {
		if (null == alias) {
			return null;
		}
		if (0 == alias.trim().length()) {
			return null;
		}
		if (null == cellUnit) {
			return null;
		}
		if (null == topology) {
			return null;
		}

		DiscoveryFilter filter = DiscoveryFilterFactory.createFindHostedFilter(cellUnit, topology,
				monitor);
		filter.setUnitTypes(new Class[] { J2CAuthenticationUnit.class });
		List<UnitDescriptor> authenticationEntries = TopologyDiscovererService.INSTANCE
				.findAll(filter);
		for (int i = 0; i < authenticationEntries.size(); i++) {
			UnitDescriptor ud = authenticationEntries.get(i);
			J2CAuthenticationUnit authenticationUnit = (J2CAuthenticationUnit) ud.getUnitValue();
			if (alias.equals(CapabilityUtil.getAttributeFromUnitCapability(authenticationUnit,
					J2eePackage.Literals.J2C_AUTHENTICATION_DATA_ENTRY__ALIAS,
					J2eePackage.Literals.J2C_AUTHENTICATION_DATA_ENTRY))) {
				return authenticationUnit;
			}
		}
		return null;
	}

	/**
	 * Validate that propogated fields on a {@link J2CAuthenticationUnit} are valid. That is:
	 * <ul>
	 * <li>there is a user/password combination on the target db os</li>
	 * </ul>
	 * 
	 * @param authUnit
	 *           the J2C authentication unit
	 * @return true if valid; false otherwise
	 */
	private static boolean validateJ2CAuthentication(J2CAuthenticationUnit authUnit,
			OperatingSystemUnit targetOsUnit, IProgressMonitor monitor) {
		J2CAuthenticationDataEntry j2c = (J2CAuthenticationDataEntry) ValidatorUtils
				.getFirstCapability(authUnit, J2eePackage.Literals.J2C_AUTHENTICATION_DATA_ENTRY);
		DiscoveryFilter filter = DiscoveryFilterFactory.createFindHostedFilter(targetOsUnit, authUnit
				.getTopology(), monitor);
		filter.setUnitTypes(new Class[] { UserUnit.class });
		List<UnitDescriptor> users = TopologyDiscovererService.INSTANCE.findAll(filter);
		for (int i = 0; i < users.size(); i++) {
			UnitDescriptor ud = users.get(i);
			UserUnit userUnit = (UserUnit) ud.getUnitValue();
			User user = (User) ValidatorUtils.getFirstCapability(userUnit, OsPackage.Literals.USER);
			if (null == user) {
				continue;
			}
			if (j2c.getUserId().equals(user.getUserId())
					&& j2c.getPassword().equals(user.getUserPassword())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Validate that propogated fields on a {@link JdbcProviderUnit} are valid. That is:
	 * <ul>
	 * <li></li>
	 * </ul>
	 * 
	 * @param providerUnit
	 *           the JDBC provider unit
	 * @return true if valid; false otherwise
	 */
	private static boolean validateJdbcProvider(Unit providerUnit) {
		return true;
	}

	/**
	 * Validate that the configuration of the db client is consistent for a node. That is:
	 * <ul>
	 * <li>datasource database name matches cataloged database database name</li>
	 * <li>cataloged node hostname matches datasource hostname</li>/
	 * <li>cataloged node hostname matches database instance hostname (when protocol is 'TCPIP')</li>
	 * <li>cataloged node port number matches database instance port number (when protocol is
	 * 'TCPIP')</li>
	 * <li>cataloged database database name matches datasource database name</li>
	 * <li>cataloged database database name matches database database name</li>
	 * </ul>
	 */
	private static boolean validateNode(UnitDescriptor osUnitUD, DatabaseContext dbContext,
			DB2JdbcProviderUnit providerUnit, WasDatasourceUnit dsUnit, Topology topology,
			IProgressMonitor monitor) {
		// check that there is a local database hosted on the OS that satisfies the conditions
		// establihsed by the configured JDBC provider and the JDBC data source

		J2EEDatasource ds = (J2EEDatasource) ValidatorUtils.getFirstCapability(dsUnit,
				J2eePackage.Literals.J2EE_DATASOURCE);
		if (null == ds) {
			return false;
		}

		OperatingSystemUnit osUnit = (OperatingSystemUnit) osUnitUD.getUnitValue();
		//boolean isSameOs = osUnit.equals(dbContext.dbOsUnit);
		boolean isSameOs = TopologyDiscovererService.INSTANCE.isSameUnit(osUnit, dbContext.dbOsUnit);

		// units
		if (!isSameOs) {

			// get DB2 client runtimes
			DiscoveryFilter filter = DiscoveryFilterFactory.createFindHostedFilter(osUnit, topology,
					monitor);
			filter.setUnitTypes(new Class[] { DB2RuntimeClientUnit.class, DB2AdminClientUnit.class,
					DB2AppDevelClientUnit.class, DB2SystemUnit.class });
			List<UnitDescriptor> queryResults = TopologyDiscovererService.INSTANCE.findAll(filter);

			// for each discovered client runtime
			for (int i = 0; i < queryResults.size(); i++) {
				UnitDescriptor clientUD = queryResults.get(i);
				Unit client = clientUD.getUnitValue();

				//TODO validate that the JDBC provider matches this client
//				Capability driverCap = ValidatorUtils.getFirstCapability(client,
//						Db2Package.Literals.DB2_JDBC_DRIVER);
//				  providerUnit.getClasspath() == driverCap.getDriverPath() + driverCap.getClasspath()
//				  providerUnit.getJdbcType() == driverCap.getType()

				if (client instanceof DB2SystemUnit) {
					if (client == dbContext.dbSystemUnit) {
						// match
					} else {
						// TODO A continue here is a bad idea. 
						// It doesn't add any value and makes the loop harder to read.
						continue;
					}
				} else {
					// discovery DB2 client instances
					DiscoveryFilter filterCI = DiscoveryFilterFactory.createFindHostedFilter(client,
							topology, monitor);
					filterCI.setUnitTypes(new Class[] { DB2ClientInstanceUnit.class });
					List queryResultsCI = TopologyDiscovererService.INSTANCE.findAll(filterCI);
					for (int j = 0; j < queryResultsCI.size(); j++) {
						UnitDescriptor clientInstanceUD = (UnitDescriptor) queryResultsCI.get(j);
						Unit clientInstance = clientInstanceUD.getUnitValue();
						// client is an db2 client; check for node catalog and catalog
						// ensure have node catalog entry 
						DB2Instance dbInstance = (DB2Instance) ValidatorUtils.getFirstCapability(
								dbContext.dbInstanceUnit, Db2Package.Literals.DB2_INSTANCE);
						filter = DiscoveryFilterFactory.createFindSourcesFilter(dbContext.dbInstanceUnit,
								dbInstance, topology, monitor);
						filter.setHosts(Arrays.asList(new Unit[] { clientInstance }));
						filter.setDirectHosting(Boolean.TRUE);
						queryResults = TopologyDiscovererService.INSTANCE.findAll(filter);
						if (queryResults.size() != 1) {
							return false;
						}
						Unit nodeCatalogUnit = queryResults.get(0).getUnitValue();

						//TODO check attributes as well?  Or is there a way to call existing validations for this?
						// ds hostname == catalogedNode hostname
						// if nodetype == TCPIP then check:
						// nodeCatalogUnit.getHostName () == dbInstance.getHostName()
						// nodeCatalogUnit.getPort === dbInstance.getPort()
						DB2CatalogedNode catalogedNode = (DB2CatalogedNode) ValidatorUtils
								.getFirstCapability(nodeCatalogUnit, Db2Package.Literals.DB2_CATALOGED_NODE);

						if (null == ds.getHostname() && null != catalogedNode.getHostname()) {
							return false;
						}
						if (ds.getHostname() != null
								&& !ds.getHostname().equals(catalogedNode.getHostname())) {
							return false;
						}
						if (TCPIP.equals(catalogedNode.getNodeType())) {
							if (null == catalogedNode.getHostname() && null != dbInstance.getHostname()) {
								return false;
							}
							if (catalogedNode.getHostname() != null
									&& !catalogedNode.getHostname().equals(dbInstance.getHostname())) {
								return false;
							}
							if (!catalogedNode.getPort().equals(dbInstance.getPort())) {
								return false;
							}
						} else {
							// TODO check the right things for other protocols
						}

						// ensure have catalog entry
						DB2Database db = (DB2Database) ValidatorUtils.getFirstCapability(
								dbContext.dbUnit, Db2Package.Literals.DB2_DATABASE);
						filter = DiscoveryFilterFactory.createFindSourcesFilter(dbContext.dbUnit, db,
								topology, monitor);
						filter.setHosts(Arrays.asList(new Unit[] { nodeCatalogUnit }));
						filter.setDirectHosting(Boolean.TRUE);
						queryResults = TopologyDiscovererService.INSTANCE.findAll(filter);
						if (queryResults.size() != 1) {
							return false;
						}
						Unit catalogUnit = queryResults.get(0).getUnitValue();
						DB2Database dbCatalog = (DB2Database) ValidatorUtils.getFirstCapability(
								catalogUnit, Db2Package.Literals.DB2_DATABASE);
						if (!dbCatalog.getDbName().equals(db.getDbName())) {
							return false;
						}
						if (!ds.getDbName().equals(dbCatalog.getDbName())) {
							return false;
						}
					}
				}
			}

		}
		// we've successfully found appropriate database stuff on each node
		return true;
	}

	private static List<UnitDescriptor> getEarHostingOs(WasClusterUnit cluster, Topology topology,
			IProgressMonitor monitor) {
		List<UnitDescriptor> osList = new ArrayList<UnitDescriptor>();

		for (Iterator<Requirement> rIt = cluster.getMemberOrAnyRequirements().iterator(); rIt
				.hasNext();) {
			Requirement req = rIt.next();
			if (WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT.isSuperTypeOf(req.getDmoEType())) {
				for (Iterator<UnitDescriptor> udIt = TopologyDiscovererService.INSTANCE.getMembers(
						cluster, req, topology, monitor).iterator(); udIt.hasNext();) {
					UnitDescriptor ud = udIt.next();
					Unit u = ud.getUnitValue();
					if (u instanceof WebsphereAppServerUnit) {
						UnitDescriptor osUnitUD = TopologyDiscovererService.INSTANCE.findHostUD(u,
								OsPackage.Literals.OPERATING_SYSTEM_UNIT, topology, monitor);
						if (null != osUnitUD) {
							osList.add(osUnitUD);
						}
					}
				}
			}
		}

		return osList;
	}

	private IStatus checkResolutionPreconditions(Constraint constraint,
			DeployModelObject constraintContext, IProgressMonitor monitor) {
		return evaluateGuards(constraint, constraintContext, monitor, false);
	}

	/**
	 * Test all implementation guards defined for an implementation. By default stops evaluation on
	 * first failure.
	 * 
	 * @param constraint
	 *           the constraint to test for resolution preconditions
	 * @param constraintContext
	 *           the constraint context
	 * @param monitor
	 *           progress monitor
	 * @param evaluate_all
	 *           when true evaluates all guards even in face of error
	 * @return ok if all the guards hold
	 */
	private IStatus evaluateGuards(Constraint constraint, DeployModelObject constraintContext,
			IProgressMonitor monitor, boolean evaluate_all) {
		IStatus rtnStatus = null;
		IStatus status;
		for (int i = 0; i < guards.length; i++) {
			try {
				status = guards[i].evaluate(constraint, constraintContext, monitor);
//			 System.out.println ("result for guard: " + guards[i] + status); //$NON-NLS-1$
				if (!status.isOK()) {
					if (!status.equals(ConstraintUtil.PRECONDITION_NOT_EVALUATABLE)) {
						rtnStatus = DatasourceSatisfactionConstraintGuardUtils.addStatus(rtnStatus,
								status);
					}
//					return status;
				}
			} catch (Throwable t) {
				// problem evaluating guard; assume it cannot be evaluated
				// log problem so that it can be debugged (we don't expect such exceptions)
				DeployCorePlugin.log(IStatus.ERROR, 0, NLS.bind(
						Messages.Validator_Exception_Executing_Preconditions, new Object[] { t
								.getMessage() }, null), t);
				status = ConstraintUtil.PRECONDITION_NOT_EVALUATABLE;
			}
		}
		if (null == rtnStatus) {
			IDeployStatus s = new DatasourceSatisfactionStatus(IStatus.ERROR,
					IEarToDbLinkValidatorID.DATASOURCE_SATISFACTION_CONSTRAINT_VALIDATION,
					IWasDb2ProblemType.EARTODB_LOGICAL_LINK_NOT_IMPLEMENTED_BUT_CAN,
					Messages.Validator_Ear2DbLL_Can_Implement, new Object[] {}, constraint,
					constraintContext);
			return s;
		}

		return rtnStatus;
	}

}
