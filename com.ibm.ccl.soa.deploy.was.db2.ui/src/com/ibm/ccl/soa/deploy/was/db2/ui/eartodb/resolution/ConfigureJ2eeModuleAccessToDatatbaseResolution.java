/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2.ui.eartodb.resolution;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Shell;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.DiscoveryFilter;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint;
import com.ibm.ccl.soa.deploy.core.provider.discovery.DiscoveryFilterFactory;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.ui.internal.DeployableUnitElementUIService;
import com.ibm.ccl.soa.deploy.core.ui.util.IUnitElementType;
import com.ibm.ccl.soa.deploy.core.ui.util.ResolutionUIUtils;
import com.ibm.ccl.soa.deploy.core.util.CapabilityUtil;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.util.RealizationLinkUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.constraints.communication.AddNetworkCommunicationConstraintResolutionGenerator.AddNetworkCommunicationConstraintResolution;
import com.ibm.ccl.soa.deploy.core.validator.expression.RequirementUtil;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.database.Database;
import com.ibm.ccl.soa.deploy.database.DatabaseInstanceUnit;
import com.ibm.ccl.soa.deploy.database.DatabasePackage;
import com.ibm.ccl.soa.deploy.database.DatabaseUnit;
import com.ibm.ccl.soa.deploy.db2.DB2AdminClientUnit;
import com.ibm.ccl.soa.deploy.db2.DB2AppDevelClientUnit;
import com.ibm.ccl.soa.deploy.db2.DB2CatalogUnit;
import com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode;
import com.ibm.ccl.soa.deploy.db2.DB2ClientInstance;
import com.ibm.ccl.soa.deploy.db2.DB2ClientInstanceUnit;
import com.ibm.ccl.soa.deploy.db2.DB2Database;
import com.ibm.ccl.soa.deploy.db2.DB2DatabaseUnit;
import com.ibm.ccl.soa.deploy.db2.DB2Instance;
import com.ibm.ccl.soa.deploy.db2.DB2InstanceUnit;
import com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver;
import com.ibm.ccl.soa.deploy.db2.DB2NodeCatalogUnit;
import com.ibm.ccl.soa.deploy.db2.DB2RuntimeClientUnit;
import com.ibm.ccl.soa.deploy.db2.DB2SystemUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.IDb2TemplateConstants;
import com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationDataEntry;
import com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationUnit;
import com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.java.JavaPackage;
import com.ibm.ccl.soa.deploy.java.JdbcProviderUnit;
import com.ibm.ccl.soa.deploy.java.JdbcTypeType;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.User;
import com.ibm.ccl.soa.deploy.os.UserUnit;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProvider;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProviderType;
import com.ibm.ccl.soa.deploy.was.DB2JdbcProviderUnit;
import com.ibm.ccl.soa.deploy.was.DataSourceHelperClassNames;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;
import com.ibm.ccl.soa.deploy.was.WASJ2CAuthenticationUnit;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasDatasource;
import com.ibm.ccl.soa.deploy.was.WasDatasourceUnit;
import com.ibm.ccl.soa.deploy.was.WasJNDIBindingConstraint;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasV5Datasource;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.db2.DatasourceSatisfactionConstraint;
import com.ibm.ccl.soa.deploy.was.db2.WasDB2Plugin;
import com.ibm.ccl.soa.deploy.was.db2.ui.WasDB2UIPlugin;
import com.ibm.ccl.soa.deploy.was.db2.ui.discoverer.IDiscoveryResultFilter;
import com.ibm.ccl.soa.deploy.was.db2.ui.eartodb.filters.DatasourceFilter;
import com.ibm.ccl.soa.deploy.was.db2.ui.eartodb.filters.ExpectedHostFilter;
import com.ibm.ccl.soa.deploy.was.db2.ui.eartodb.filters.HostedOnFilter;
import com.ibm.ccl.soa.deploy.was.db2.ui.eartodb.filters.J2CAuthenticationFilter;
import com.ibm.ccl.soa.deploy.was.db2.ui.eartodb.filters.J2CAuthenticationUserFilter;
import com.ibm.ccl.soa.deploy.was.db2.ui.eartodb.filters.JdbcProviderFilter;
import com.ibm.ccl.soa.deploy.was.db2.ui.eartodb.filters.NodeCatalogFilter;
import com.ibm.ccl.soa.deploy.was.db2.ui.internal.Messages;
import com.ibm.ccl.soa.deploy.was.db2.validator.constraint.DatabaseContext;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDatasourceUnitValidator;
import com.ibm.ccl.soa.deploy.was.util.jdbcprovider.JdbcProviderPreferences;
import com.ibm.ccl.soa.deploy.was.util.jdbcprovider.WasDb2LegacyCLIType2ProviderDefinition;
import com.ibm.ccl.soa.deploy.was.util.jdbcprovider.WasDb2UniversalProviderDefinition;
import com.ibm.ccl.soa.deploy.was.util.jdbcprovider.WasDb2UniversalProviderXADefinition;
import com.ibm.ccl.soa.deploy.was.util.jdbcprovider.WasJdbcProviderHelper;
import com.ibm.ccl.soa.deploy.was.util.jdbcprovider.WebsphereContext;

/**
 * Resolution to add a WAS security subject binding
 */
public class ConfigureJ2eeModuleAccessToDatatbaseResolution extends DeployResolution {

	private final Requirement _source;
	private final Database _target;
	private final String _user;
	private final String _userPassword;
	private final DatasourceSatisfactionConstraint _dsConstraint;

	/**
	 * Constructor for resolution
	 * 
	 * @param context
	 *           the resolution context
	 * @param generator
	 *           the resolution generator that created the resolution
	 * @param description
	 *           a description of the resolution
	 * @param source
	 *           the J2EE datasource that must be configured
	 * @param target
	 *           the database (capability) target of the communication
	 */
	public ConfigureJ2eeModuleAccessToDatatbaseResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, String description, Requirement source,
			Database target, DatasourceSatisfactionConstraint dsConstraint) {
		super(context, generator, description);
		_source = source;
		_target = target;
		_user = null;
		_userPassword = null;
		_dsConstraint = dsConstraint;
	}

	/**
	 * Constructor for resolution
	 * 
	 * @param context
	 *           the resolution context
	 * @param generator
	 *           the resolution generator that created the resolution
	 * @param description
	 *           a description of the resolution
	 * @param source
	 *           the J2EE datasource that must be configured
	 * @param target
	 *           the database (capability) target of the communication
	 * @param user
	 *           the name of the user that should be configured to access the database
	 * @param userPassword
	 *           the password of the user configured to access the database
	 */
	public ConfigureJ2eeModuleAccessToDatatbaseResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, String description, Requirement source,
			Database target, DatasourceSatisfactionConstraint dsConstraint, String user,
			String userPassword) {
		super(context, generator, description);
		_source = source;
		_target = target;
		_user = user;
		_userPassword = userPassword;
		_dsConstraint = dsConstraint;
	}

	public IStatus resolve(IProgressMonitor monitor) {

		return implement(context, _source, _target, _dsConstraint, _user, _userPassword);
	}

	private static IStatus implement(IDeployResolutionContext context, Requirement consumedDs,
			Database providedDb, DatasourceSatisfactionConstraint dsConstraint, String dbUserId,
			String dbUserPassword) {

		IProgressMonitor monitor = context.getProgressMonitor();
		Topology editTopology = context.getTopology().getEditTopology();

		try {
			// MK 12/7/2006 refactor to allow call from another LL implementation
			// Requirement consumedDs = (Requirement) link.getSource();

			assert null != consumedDs;

			//
			// identify all of the resources that we expect to find in the model
			// (may not be in the topology)
			//

			// source module might be EarModule, EjbModule or WebModule
			Unit module = ValidatorUtils.getOwningUnit(consumedDs);
			// MK 01/18/2008 defect 5211 [process using final realization]
			// Is this right?  It means links will be created from the final realization instead of
			// the unit the communication link is connected to
			module = (Unit) RealizationLinkUtil.getFinalRealization(module);

			assert module != null;

			// get hosting OS
			Unit wasUnit = TopologyDiscovererService.INSTANCE.findHost(module, editTopology, monitor);
			// MK 2/27/2007 wasUnit might be null if EbjModule is a member of an
			// EarModule instead of being directly hosted
			if (null == wasUnit) {
				// MK 01/18/2008 defect 5211 [process using final realization]
				// Unit earModule = ValidatorUtils.findGroupByUnitType(module,
				//		J2eePackage.Literals.EAR_MODULE);
				Unit earModule = ValidatorUtils.discoverGroupByUnitType(module,
						J2eePackage.Literals.EAR_MODULE, monitor);
				wasUnit = TopologyDiscovererService.INSTANCE.findHost(earModule, editTopology, monitor);
				// System.out.println ("wasUnit found: " + wasUnit.getName() + "  conceptual = " + wasUnit.isConceptual()); //$NON-NLS-1$ //$NON-NLS-2$
			}
			assert null != wasUnit;

			// get db stack
			// MK 12/7/2006 refactor to allow call from another LL implementation
			// Database providedDb = (Database) link.getTarget();
			assert null != providedDb;
			// MK 01/18/2008 defect 5211 [process using final realization]
			// DatabaseUnit dbUnit = (DatabaseUnit) ValidatorUtils.getOwningUnit(providedDb);
			Capability realizedDb = (Capability) RealizationLinkUtil.getFinalRealization(providedDb);
			DatabaseUnit dbUnit = (DatabaseUnit) ValidatorUtils.getOwningUnit(realizedDb);
			dbUnit = (DatabaseUnit) RealizationLinkUtil.getFinalRealization(dbUnit);
			assert null != dbUnit;
			assert Db2Package.eINSTANCE.getDB2DatabaseUnit().isSuperTypeOf(
					dbUnit.getEObject().eClass());

			DB2InstanceUnit instanceUnit = (DB2InstanceUnit) TopologyDiscovererService.INSTANCE
					.findHostUD(dbUnit, editTopology, monitor).getUnitValueAndAddToTopology(
							context.getTopology().getEditTopology());
			assert null != instanceUnit;
// MK 11/16/2006 removed system from diagram (to reduce clutter)
//			DB2SystemUnit systemUnit = (DB2SystemUnit) TopologyDiscovererService.INSTANCE
//					.findHostUD(instanceUnit, context.getTopology().getEditTopology())
//					.getUnitValueAndAddToTopology(context.getTopology().getEditTopology());
			DB2SystemUnit systemUnit = (DB2SystemUnit) TopologyDiscovererService.INSTANCE.findHostUD(
					instanceUnit, editTopology, monitor).getUnitValue();
			assert null != systemUnit;
			UnitDescriptor dbOsUD = TopologyDiscovererService.INSTANCE.findHostUD(systemUnit,
					editTopology, monitor);
			OperatingSystemUnit dbOsUnit = (OperatingSystemUnit) dbOsUD.getUnitValue();
			assert null != dbOsUnit;

//MK 11/16/2006 removed addition to the topology (to reduce clutter)
//			// add it to the topology
//			dbOsUD.getUnitValueAndAddToTopology(context.getTopology().getEditTopology());

//			// get user
//			if (null == userUnit) {
//				userUnit = (UserUnit) findAndAddUserUnit(context,
//						instanceUnit, dbOsUnit);
//			}
//
//			// New -- allow user to cancel
//			if (userUnit == null) {
//				return Status.OK_STATUS;
//			}
//			
			DatabaseContext dbContext = new DatabaseContext(dbUnit, instanceUnit, systemUnit,
					dbOsUnit, null);

			//
			// find and or add units to the model
			//

			// FIXME move text of template ids to static finals somewhere
			// TODO abort when failure occurs
			// TODO need to decide which template to use when there are multiple choices
			// TODO (for all calls to "hosts" and "link") avoid making links that already exist
			// TODO (for all calls to "hosts" and "link") can I replace with a call to a resolution?
			// TODO what happens if field want to set is immutable?

			// MK 11/16/2006 moved the following so that provider is known before deciding about 
			WebsphereContext wasContext = new WebsphereContext(wasUnit);

			// MK 12/18/2006 get provider preferences from the capabilities of the db system
			// if there aren't clients on all nodes, filter out the type 2 drivers
			List<JdbcProviderPreferences> providerPreferences = getDriverPreferences(dbContext);
			// MK 12/18/2006 added preference for Type 4 driver if no clients
			// MK 9/12/2007 removed check for single server; nothing wrong with a type 2 driver for single server
			if (//isSingleServer(wasContext, dbContext, editTopology, monitor) ||
			!allNodesHaveDb2ClientInstance(wasContext, editTopology, monitor)) {
				// filter out type 2 drivers
				int i = 0;
				while (i < providerPreferences.size()) {
					JdbcProviderPreferences pref = providerPreferences.get(i);
					if (JdbcTypeType._2_LITERAL.equals(pref.getJdbcType())) {
						providerPreferences.remove(i);
					} else {
						i++;
					}
				}
			}

			// MK 11/16/2006 added the following user interaction once instead of for each unit type
			// this means that we have to keep track of the results that we get... and we need to 
			// avoid asking for information if we don't really need it.
			OsUsers users = null;
			UserUnit userUnit = null;
			users = new OsUsers(dbOsUnit, context.getTopology().getEditTopology());
			if (dbUserId != null) {
				userUnit = users.getUserUnit(dbUserId);
			}
			if (null == userUnit) {
				// if there is just one user short circuit the user interaction (selection)
				if (1 == users.getNumberOfUsers()) {
					userUnit = users.getUserUnit(0, dbOsUnit.getTopology() == context.getTopology()
							.getEditTopology());
					// userUnit = users.getUserUnit(0, true);
				}
			} // else {
			// we are interested in only one user; set it
			// users = new OsUsers (userUnit, context.getTopology().getEditTopology());
			// }

			// if there is more than one user or if there is a need to identify a provider
			// display dialog box.  Otherwise, skip this code.  Currently, we decide only 
			// by the number of users.
			// MK 12/19/2006 added unit to topology if hosting OS is already in the 
			// topology.
			if (null == userUnit) {
				// if (1 < users.getNumberOfUsers()) {
				SelectUserDialog dlg = new SelectUserDialog(new Shell(), users.getUserDisplayNames());
				dlg.create();
				if (dlg.open() == Window.OK) {
					int userIndex = dlg.getUserIndex();
					if (userIndex < 0) {
						// a user was not selected from the list; use the name/password pair
						String userN = dlg.getUserName();
						String userP = dlg.getPassword();
						if (null == userN || 0 == userN.trim().length() || null == userP
								|| 0 == userP.trim().length()) {
							throw new IllegalArgumentException();
						}
						// search for user in list
						userUnit = users.getUserUnit(userN);
						if (null == userUnit) {
							// need to create one and host it on the OS
							userUnit = addDbUserUnit(context, dbOsUnit, userN, userP);
							if (null == userUnit) {
								throw new IllegalArgumentException();
							}
							// host new user unit on the target Os.  But first need to make sure it is in the topology
							dbOsUnit = (OperatingSystemUnit) dbOsUD.getUnitValueAndAddToTopology(context
									.getTopology().getEditTopology());
							ResolutionUtils.host(dbOsUnit, userUnit);
						}
					} else {
						userUnit = users.getUserUnit(userIndex, dbOsUnit.getTopology() == context
								.getTopology().getEditTopology());
						// userUnit = users.getUserUnit(userIndex, true);
					}
				} else {
					// Fortunately, there have been no model changes at this point, so can just quit
					return Status.CANCEL_STATUS;
					// Defect 5128 - Cancel button doesn't work
//					userUnit = users.getUserUnit(0, dbOsUnit.getTopology() == context.getTopology()
//							.getEditTopology());
				}
			}

			//MK 12/19/2006
			// check password; if not set call to get it set
			String password = (String) CapabilityUtil.getAttributeFromUnitCapability(userUnit,
					OsPackage.Literals.USER__USER_PASSWORD, OsPackage.Literals.USER);
			if (null == password || password.trim().length() == 0) {
				if (dbUserPassword != null) {
					password = dbUserPassword;
				} else {
					ResolutionUIUtils.resolveUndefinedAttribute(userUnit, OsPackage.Literals.USER,
							OsPackage.Literals.USER__USER_PASSWORD, context);
				}
			}

			// define JDBC provider, JDBC data source and J2C authentication on WAS cluster/server
			// for each node, make sure DB2 connection valid

			JdbcProviderUnit jdbcProviderUnit = (JdbcProviderUnit) findAndAddJdbcProviderUnit(context,
					providerPreferences, dbContext, wasContext);
			if (null == ValidatorUtils.getHost(jdbcProviderUnit)) {
				// wasUnit and jdbcProviderUnit already in topology
				ResolutionUtils.hosts(context, wasUnit, jdbcProviderUnit);
			}
			// after creating (and hosting), we set prefered paths
			DB2JdbcDriver driver = (DB2JdbcDriver) ValidatorUtils.getFirstCapability(
					dbContext.dbSystemUnit, Db2Package.Literals.DB2_JDBC_DRIVER);
			DB2JdbcProvider provider = (DB2JdbcProvider) ValidatorUtils.getFirstCapability(
					jdbcProviderUnit, WasPackage.Literals.DB2_JDBC_PROVIDER);
			// can only pass driver from system when know on same machine
			//if (JdbcTypeType._4_LITERAL.equals(provider.getJdbcType())) {
			if (isSingleServer(wasContext, dbContext, editTopology, monitor)) {
				WasJdbcProviderHelper.INSTANCE.setProviderPaths(jdbcProviderUnit, driver);
			} else {
				WasJdbcProviderHelper.INSTANCE.setProviderPaths(jdbcProviderUnit, null);
			}
			fixUpPaths(jdbcProviderUnit, wasUnit, wasContext);
			// System.out.println (((JdbcProvider) ValidatorUtils.getFirstCapability(jdbcProviderUnit, JavaPackage.Literals.JDBC_PROVIDER)).getClasspath());

			// 9/11/2006 removed direct dependence on driverUnit

			// if necessary, process each node to ensure database client exists and is configured correctly
			// that is, if provider is a type 2 provider (tested here) 
			// and the ear and db are on different machines (tested in processNode())
//			DB2JdbcProvider provider = (DB2JdbcProvider) ValidatorUtils.getFirstCapability(jdbcProviderUnit, WasPackage.Literals.DB2_JDBC_PROVIDER);
			DB2CatalogUnit dbCatalog = null;
			if (provider.getJdbcType().equals(JdbcTypeType._2_LITERAL)) {
				if (wasUnit instanceof WasClusterUnit) {
					List<UnitDescriptor> nodeUDs = getEarHostingOs((WasClusterUnit) wasUnit,
							editTopology, monitor);
					for (int i = 0; i < nodeUDs.size(); i++) {
						UnitDescriptor osUnitUD = nodeUDs.get(i);
						dbCatalog = processNode(osUnitUD, dbContext, context);
					}
					// if there was more than one node, make dbCatalog null so no link to it can be created
					if (nodeUDs.size() > 1) {
						dbCatalog = null;
					}
				} else if (wasUnit instanceof WebsphereAppServerUnit) {
					UnitDescriptor osUnitUD = TopologyDiscovererService.INSTANCE.findHostUD(wasUnit,
							OsPackage.Literals.OPERATING_SYSTEM_UNIT, editTopology, monitor);
					dbCatalog = processNode(osUnitUD, dbContext, context);
				}
			}

			WasDatasourceUnit wasDSUnit = (WasDatasourceUnit) findAndAddWasDatasourceUnit(context,
					module, consumedDs, jdbcProviderUnit, instanceUnit, dbUnit, null);

			DependencyLink dsLink = ResolutionUtils.link(context, consumedDs, wasDSUnit,
					WasPackage.Literals.WAS_V5_DATASOURCE);

			// MK 02/02/2007 Apparently a requirement for type 4 drivers.  Perhaps doesn't hurt for all?
			// MK 02/22/2008 Needed also to configure type 2 drivers.  
//			if (JdbcTypeType._4_LITERAL.equals(provider.getJdbcType())) {
			propogateDbInstancePortToDatasource(wasDSUnit, dbContext.getInstanceUnit(), context);
//			}

			// if there was only one node then we can link the datasource to the catalog
			if (null != dbCatalog) {
				Requirement sourceRequirement = ValidatorUtils.getFirstRequirement(wasDSUnit,
						Db2Package.Literals.DB2_DATABASE);
				Capability targetCapability = ValidatorUtils.getFirstCapability(dbCatalog,
						Db2Package.Literals.DB2_DATABASE);
				ResolutionUtils.link(context, sourceRequirement, targetCapability);
			}

			if (null == ValidatorUtils.getHost(wasDSUnit)) {
				// jdbcProviderUnit and wasDSUnit already in topology
				ResolutionUtils.hosts(context, jdbcProviderUnit, wasDSUnit);
			}
			setDataStoreHelperClassNameOnDatasource(wasDSUnit, context);

			// 9/11/2006 removed dependence on database/client
			UserAuthenticationDetails user = new UserAuthenticationDetails(userUnit);
			// UserAuthenticationDetails user = new UserAuthenticationDetails (dbContext.userUnit);

			J2CAuthenticationUnit authenticationUnit = (J2CAuthenticationUnit) findAndAddJ2CAuthUnit(
					context, user, wasDSUnit, wasContext);

			if (null == ValidatorUtils.getHost(authenticationUnit)) {
				// cell may not be in topology; add it
				// authenticationUnit already in topology
				ResolutionUtils.hosts(context, wasContext.addCellToTopology(), authenticationUnit);
			}
			// ensure user/password are set properly
			propogateJ2CAuthDetails(user, authenticationUnit, context);

			ResolutionUtils.link(context, wasDSUnit,
					WasPackage.Literals.WASJ2C_AUTHENTICATION_DATA_ENTRY, authenticationUnit,
					WasPackage.Literals.WASJ2C_AUTHENTICATION_DATA_ENTRY);

			// 9/11/2006 removed dependency on target user

			//
			// propogate attributes to new units
			//

			// MK 04-24-2008 - defect 5677; if jndiName is null create one
			//   will use other attributes; so make sure they are set first
			RequirementUtil.copyAttributeFromConstraintToCapability(dsLink,
					J2eePackage.Literals.J2EE_DATASOURCE__USED_FOR_CMP);

			// propogate hostname to the datasource
			propogateHostNameToDatasource(wasDSUnit, instanceUnit, context);

			// propogate database name to the datasource
			propogateDbNameToDatasource(wasDSUnit, dbUnit, context);

			// propogate J2C authentication alias to datasource
			propogateJ2CAuthAliasToDatasource(wasDSUnit, authenticationUnit, context);

			// MK 2/11/2008: Defect 5328
			// Remove usage of Requirement Expressions from the WAS domain.
			// MK 03-07-2008: defect 5664
			// expected JNDI name now on WasJNDIBinding; not in EqualityConstraint
			// leaving old code (copyAttributeFromConstraintToCapability) for older topologies.  
			// Eventually it should be removed in favor of the call to propagateJndiNameToDatasource
			boolean success = RequirementUtil.copyAttributeFromConstraintToCapability(dsLink,
					J2eePackage.Literals.J2EE_DATASOURCE__JNDI_NAME);
			if (!success) {
				propagateJndiNameToDatasource(consumedDs, context);
			}
			// ensure binding matches (it should since we copied it but in the case
			// where it was initially null, we need to update it
			propogateJndiNameToBindings(wasDSUnit, context);

			// set the datasource name
			setDatasourceNameOnDatasource(wasDSUnit, context);

			//TODO put this back in
//			// propogate jdbc type/provider type to provider
//			propogateJdbcTypeToProvider(jdbcProviderUnit, clientUnit,
//					systemUnit);

			// propogate driver classpath to provider (if type 2 datasource)
//			if (JdbcTypeType._2_LITERAL.equals(provider.getJdbcType())) {
			propogateClassPathToProvider((DB2JdbcProviderUnit) jdbcProviderUnit, context.getTopology()
					.getEditTopology(), context);
//			}

//			// MK 12/20/2006 remove userUnit from topology if it the hosting OS is not in the topology
//			if (dbOsUnit.getTopology() != context.getTopology().getEditTopology()) {
//				// we shouldn't have added the user to the topology
//				EcoreUtil.remove(userUnit);
//			}

			// MK 04-24-2008: lineitem 5803 - DatasourceSatisfactionConstraint extends ApplicationCommunicationConstraint
			// ensure that any requirement for a NetworkCommunicationConstraint is satisfied
			createNCC(dsConstraint, context);

//			System.out.println ("reached end of logical link implementation"); //$NON-NLS-1$
			return Status.OK_STATUS;
		} catch (Throwable e) {
			DeployCorePlugin.log(IStatus.ERROR, 0, NLS.bind(
					Messages.InsertNewDatabaseInstance_Exception_trying_to_resolve_marker_,
					new Object[] { e.getMessage() }, null), null);
			return new Status(IStatus.ERROR, WasDB2UIPlugin.pluginID, 0,
					Messages.InsertNewDatabaseInstance_Exception_trying_to_resolve_marker_, e);
		}
	}

	private static boolean propogateJ2CAuthDetails(DB2InstanceUnit instanceUnit,
			J2CAuthenticationUnit j2CUnit) {
		if (null == j2CUnit || null == instanceUnit) {
			return false;
		}

		J2CAuthenticationDataEntry j2C = (J2CAuthenticationDataEntry) ValidatorUtils
				.getFirstCapability(j2CUnit, WasPackage.Literals.WASJ2C_AUTHENTICATION_DATA_ENTRY);
		DB2Instance instance = (DB2Instance) ValidatorUtils.getFirstCapability(instanceUnit,
				Db2Package.Literals.DB2_INSTANCE);
		if (null == j2C || null == instance) {
			return false;
		}

		if (null != instance.getUsername()) {
			j2C.setUserId(instance.getUsername());
		}
		if (null != instance.getPassword()) {
			j2C.setPassword(instance.getPassword());
		}

		if (null == j2C.getAlias()) {
			j2C.setAlias(j2C.getUserId());
		}
		return true;
	}

	private static boolean propogateJ2CAuthDetails(UserAuthenticationDetails user,
			J2CAuthenticationUnit authenticationUnit, IDeployResolutionContext context) {

		// get authEntry
		if (authenticationUnit == null) {
			return false;
		}
		J2CAuthenticationDataEntry authEntry = (J2CAuthenticationDataEntry) ValidatorUtils
				.getFirstCapability(authenticationUnit,
						J2eePackage.Literals.J2C_AUTHENTICATION_DATA_ENTRY);

		// do propogration
		if (propogateUserId(user.getUserId(), authEntry, context)) {
			if (propogatePassword(user.getPassword(), authEntry, context)) {
				String alias = user.getUserId();
				alias = getUniqueAuthenticationAlias(authEntry, alias);
				if (propogateAlias(alias, authEntry, context)) {
					return true;
				}
			}
		}

		return false;
	}

	private static String getUniqueAuthenticationAlias(J2CAuthenticationDataEntry authEntry,
			String alias) {
		return getUniqueStringAttribute(alias, authEntry,
				J2eePackage.Literals.J2C_AUTHENTICATION_DATA_ENTRY__ALIAS,
				J2eePackage.Literals.J2C_AUTHENTICATION_DATA_ENTRY);
	}

	private static String getUniqueStringAttribute(String proposal, Capability targetCap,
			EAttribute attribute, EClass capType) {
		return getUniqueStringAttribute(proposal, targetCap, attribute, capType, -1);
	}

	private static String getUniqueStringAttribute(String proposal, Capability targetCap,
			EAttribute attribute, EClass capType, int maxLength) {
		Unit owningUnit = ValidatorUtils.getOwningUnit(targetCap);
		Unit hostUnit = ValidatorUtils.getHost(owningUnit);
		DiscoveryFilter filter = DiscoveryFilterFactory.createFindHostedFilter(hostUnit, targetCap
				.getTopology());
		List units = TopologyDiscovererService.INSTANCE.findAll(filter);

		String value = proposal;

		for (int i = 0; i < 10000; i++) { // prevent infinite loop
			if (i > 0) {
				value = proposal + (i - 1);
			}
			if (maxLength > -1 && value.length() > maxLength) { // truncate the name
				value = value.substring(value.length() - maxLength);
			}
			boolean nameFound = false;

			for (int j = 0; j < units.size(); j++) {
				UnitDescriptor ud = (UnitDescriptor) units.get(j);
				Unit unit = ud.getUnitValue();
				if (null == unit) {
					continue;
				}
				Capability cap = ValidatorUtils.getFirstCapability(unit, capType);
				// skip if no capability found (would happen if wrong type of hosted unit found)
				if (null == cap) {
					continue;
				}
				// skip check if capability is target
				if (cap == targetCap) {
					continue;
				}
				// check for name conflict
				if (value.equals(cap.getEObject().eGet(attribute))) {
					nameFound = true;
					break;
				}
			}

			if (!nameFound) {
				break;
			}
		}

		return value;
	}

	private static boolean propogateUserId(String userId, J2CAuthenticationDataEntry authEntry,
			IDeployResolutionContext context) {
		if (null == userId) {
			return false;
		}
		if (null == authEntry) {
			return false;
		}

		// propogate only if not already set to the same value
		if (!userId.equals(authEntry.getUserId())) {
			return ResolutionUtils.propogateAttributeValue(authEntry,
					J2eePackage.Literals.J2C_AUTHENTICATION_DATA_ENTRY__USER_ID, userId, context);
		}
		// it was already set to what we wanted
		return true;
	}

	private static boolean propogatePassword(String password, J2CAuthenticationDataEntry authEntry,
			IDeployResolutionContext context) {
		if (null == password) {
			return false;
		}
		if (null == authEntry) {
			return false;
		}

		// propogate only if not already set to the same value
		if (!password.equals(authEntry.getPassword())) {
			return ResolutionUtils.propogateAttributeValue(authEntry,
					J2eePackage.Literals.J2C_AUTHENTICATION_DATA_ENTRY__PASSWORD, password, context);
		}
		// it was already set to what we wanted
		return true;
	}

	private static boolean propogateAlias(String alias, J2CAuthenticationDataEntry authEntry,
			IDeployResolutionContext context) {
		if (null == alias) {
			return false;
		}
		if (null == authEntry) {
			return false;
		}

		// propogate only if not already set to the same value
		if (!alias.equals(authEntry.getAlias())) {
			return ResolutionUtils.propogateAttributeValue(authEntry,
					J2eePackage.Literals.J2C_AUTHENTICATION_DATA_ENTRY__ALIAS, alias, context);
		}
		// it was already set to what we wanted
		return true;
	}

	private static boolean propogateDbHost(DB2InstanceUnit instanceUnit,
			DB2NodeCatalogUnit nodeUnit, DB2ClientInstanceUnit clientInstanceUnit,
			IProgressMonitor monitor) {
		DB2CatalogedNode node = (DB2CatalogedNode) ValidatorUtils.getFirstCapability(nodeUnit,
				Db2Package.Literals.DB2_CATALOGED_NODE);
		DB2Instance instance = (DB2Instance) ValidatorUtils.getFirstCapability(instanceUnit,
				Db2Package.Literals.DB2_INSTANCE);
		DB2ClientInstance clientInstance = (DB2ClientInstance) ValidatorUtils.getFirstCapability(
				clientInstanceUnit, Db2Package.Literals.DB2_CLIENT_INSTANCE);
		String clientInstanceName = null;
		if (null != clientInstance) {
			clientInstanceName = clientInstance.getDb2InstanceName();
		}
		if (null == node || null == instance) {
			return false;
		}

		// MK 1/19/2008 Defect 5211 [don't update if the field is already set the same value]
		String goalHostname = instance.getHostname();
		String currentHostname = node.getHostname();
		if (null != goalHostname && !goalHostname.equalsIgnoreCase(currentHostname)) {
			node.setHostname(goalHostname);
		}

		// MK 1/19/2008 Defect 5211 [don't update if the field is already set (value not important)]
		String goalInstanceName = instance.getDb2InstanceName();
		String currentInstanceName = node.getNodeName();
		if (null != goalInstanceName && null == currentInstanceName) {
			node.setNodeName(getUniqueNodeName(node, goalInstanceName, clientInstanceName, monitor));
		}

		// MK 1/19/2008 Defect 5211 [don't update if the field is already set to the same value]
		BigInteger goalPort = instance.getPort();
		BigInteger currentPort = node.getPort();
		if (null != goalPort && !goalPort.equals(currentPort)) {
			node.setPort(goalPort);
		}

		return true;
	}

	private static String getUniqueNodeName(DB2CatalogedNode node, String proposedName,
			String clientInstanceName, IProgressMonitor monitor) {
		Unit nodeCatalogUnit = ValidatorUtils.getOwningUnit(node);
		Unit hostUnit = ValidatorUtils.getHost(nodeCatalogUnit);
		DiscoveryFilter filter = DiscoveryFilterFactory.createFindHostedFilter(hostUnit,
				nodeCatalogUnit.getTopology(), monitor);
		filter.setUnitTypes(new Class[] { DB2NodeCatalogUnit.class });
		List catalogedNodes = TopologyDiscovererService.INSTANCE.findAll(filter);

		String nodeName = proposedName;

		for (int i = 0; i < 10000; i++) { // prevent infinite loop
			if (i > 0) {
				nodeName = proposedName + (i - 1);
			}
			if (nodeName.length() > 8) { // truncate the name to 8 characters
				nodeName = nodeName.substring(nodeName.length() - 8);
			}

			// check that the name is unique among other catalog names
			boolean nameFound = false;
			for (int j = 0; j < catalogedNodes.size(); j++) {
				UnitDescriptor ud = (UnitDescriptor) catalogedNodes.get(j);
				DB2NodeCatalogUnit catalogedNodeUnit = (DB2NodeCatalogUnit) ud.getUnitValue();
				if (null == catalogedNodeUnit) {
					continue;
				}
				DB2CatalogedNode catalogedNode = (DB2CatalogedNode) ValidatorUtils.getFirstCapability(
						catalogedNodeUnit, Db2Package.Literals.DB2_CATALOGED_NODE);
				// skip check if no node to check
				if (null == catalogedNode) {
					continue;
				}
				// skip check if node is us
				if (node == catalogedNode) {
					continue;
				}
				// check for name conflict
				if (nodeName.equals(catalogedNode.getNodeName())) {
					nameFound = true;
					break;
				}
			}

			// check that the name is not the same as the client instance name
			if (nodeName.equals(clientInstanceName)) {
				nameFound = true;
			}

			// when we found a name then we are ready to go on
			if (!nameFound) {
				break;
			}
		}

		return nodeName;
	}

	private static boolean propogateDb(DB2DatabaseUnit dbUnit, DB2CatalogUnit catalogUnit) {
		DB2Database catalogDb = (DB2Database) ValidatorUtils.getFirstCapability(catalogUnit,
				Db2Package.Literals.DB2_DATABASE);
		DB2Database db = (DB2Database) ValidatorUtils.getFirstCapability(dbUnit,
				Db2Package.Literals.DB2_DATABASE);
		if (null == catalogDb || null == db) {
			return false;
		}

		// MK 1/19/2008 Defect 5211 [don't update if the field is already set to the same value]
		String goalDbName = db.getDbName();
		String currentDbName = catalogDb.getDbName();
		if (null != goalDbName && !goalDbName.equalsIgnoreCase(currentDbName)) {
			catalogDb.setDbName(goalDbName);
		}

		// MK 1/19/2008 Defect 5211 [don't update if the field is already set (value not important)]
		String goalAliasName = db.getDbName();
		String currentAliasName = catalogDb.getDbAlias();
		if (null != goalAliasName && null == currentAliasName) {
			catalogDb.setDbAlias(goalAliasName);
		}
		return true;
	}

	private static boolean propogateHostNameToDatasource(WasDatasourceUnit wasDSUnit,
			DB2InstanceUnit instanceUnit, IDeployResolutionContext context) {
//		String hostname = getHostnameFromInstance(instanceUnit);
		String hostname = (String) CapabilityUtil.getAttributeFromUnitCapability(instanceUnit,
				Db2Package.Literals.DB2_INSTANCE__HOSTNAME, Db2Package.Literals.DB2_INSTANCE);
		// MK 1/19/2008 Defect 5211 [don't update if the field is already set to same value]
		String currentHostname = (String) CapabilityUtil.getAttributeFromUnitCapability(wasDSUnit,
				J2eePackage.Literals.J2EE_DATASOURCE__HOSTNAME, WasPackage.Literals.WAS_DATASOURCE);
		if (null != hostname && !hostname.equalsIgnoreCase(currentHostname)) {
			WasDatasource dsCap = (WasDatasource) ValidatorUtils.getFirstCapability(wasDSUnit,
					WasPackage.Literals.WAS_DATASOURCE);

			return ResolutionUtils.propogateAttributeValue(dsCap,
					J2eePackage.Literals.J2EE_DATASOURCE__HOSTNAME, hostname, context);
		}
		return false;
	}

	// MK 1/19/2008 replace with CapabilityUtil.getAttributeFromCapability
//	private static String getHostnameFromInstance(DB2InstanceUnit instanceUnit) {
//		String hostname = null;
//		if (instanceUnit != null) {
//			DB2Instance instanceCap = (DB2Instance) ValidatorUtils.getFirstCapability(instanceUnit,
//					Db2Package.Literals.DB2_INSTANCE);
//			hostname = instanceCap.getHostname();
//		}
//		return hostname;
//	}

	private static Object getJndiNameFromRequirement(Requirement requirement) {
		return getAttributeValueFromRequirement(requirement,
				J2eePackage.Literals.J2EE_DATASOURCE__JNDI_NAME);
	}

	private static Object getUsedForCmpFromRequirement(Requirement requirement) {
		return getAttributeValueFromRequirement(requirement,
				J2eePackage.Literals.J2EE_DATASOURCE__USED_FOR_CMP);
	}

// MK: 2/10/2008: Defect 5328 - Remove usage of Requirement Expressions from the WAS domain
	// this method added to replace older getAttributeValueFromRequirement() which was renamed
	// getAttributeValueFromRequirementRE and deprecated.  A new getAttributeValueFromRequirement()
	// calls both for now.
	private static Object getAttributeValueFromRequirementC(Requirement requirement,
			EAttribute attribute) {
		if (null == requirement) {
			return null;
		}
		if (null == attribute) {
			return null;
		}

		String attrName = attribute.getName();

		EqualsConstraint sourceConstraint = null;
		for (Constraint c : (List<Constraint>) requirement.getConstraints()) {
			if (ConstraintPackage.Literals.EQUALS_CONSTRAINT.isSuperTypeOf(c.getEObject().eClass())) {
				EqualsConstraint ec = (EqualsConstraint) c;
				if (attrName.equals(ec.getAttributeName())) {
					sourceConstraint = ec;
					if (null != sourceConstraint.getValue()) {
						try {
							Object value = EcoreUtil.createFromString(attribute.getEAttributeType(),
									sourceConstraint.getValue());
							return value;
						} catch (Throwable e) {
							WasDB2Plugin.logError(0,
									"Error extracting expected attribute value from constraint.", e); //$NON-NLS-1$
							return null;
						}
					}
				}
			}
		}
		return null;
	}

	private static Object getAttributeValueFromRequirement(Requirement requirement,
			EAttribute attribute) {
		Object v = getAttributeValueFromRequirementC(requirement, attribute);
		return v;
	}

	private static boolean propogateDbNameToDatasource(WasDatasourceUnit wasDSUnit,
			DatabaseUnit dbUnit, IDeployResolutionContext context) {
		String dbName = getDbNameFromDB(dbUnit);
		// MK 1/19/2008 Defect 5211 [don't update if the field is already set to the same value]
		String currentDbName = (String) CapabilityUtil.getAttributeFromUnitCapability(wasDSUnit,
				J2eePackage.Literals.J2EE_DATASOURCE__DB_NAME, WasPackage.Literals.WAS_DATASOURCE);
		if (null != dbName && !dbName.equalsIgnoreCase(currentDbName)) {
			WasDatasource dsCap = (WasDatasource) ValidatorUtils.getFirstCapability(wasDSUnit,
					WasPackage.Literals.WAS_DATASOURCE);

			return ResolutionUtils.propogateAttributeValue(dsCap,
					J2eePackage.Literals.J2EE_DATASOURCE__DB_NAME, dbName, context);
		}
		return false;
	}

	private static String getDbNameFromDB(DatabaseUnit dbUnit) {
		String dbName = null;
		if (dbUnit != null) {
			DB2Database dbCap = (DB2Database) ValidatorUtils.getFirstCapability(dbUnit,
					Db2Package.Literals.DB2_DATABASE);
			if (dbCap != null) {
				dbName = dbCap.getDbName();
			}
		}
		return dbName;
	}

	private static boolean propogateDbInstancePortToDatasource(WasDatasourceUnit wasDSUnit,
			DatabaseInstanceUnit dbInstanceUnit, IDeployResolutionContext context) {
		DB2Instance dbInst = (DB2Instance) ValidatorUtils.getFirstCapability(dbInstanceUnit,
				Db2Package.Literals.DB2_INSTANCE);
		if (null == dbInst) {
			return false;
		}

		// MK 1/19/2008 Defect 5211 [don't update if the field is already set to the same value]
		BigInteger port = dbInst.getPort();
		BigInteger currentPort = (BigInteger) CapabilityUtil.getAttributeFromUnitCapability(
				wasDSUnit, J2eePackage.Literals.J2EE_DATASOURCE__PORT,
				WasPackage.Literals.WAS_DATASOURCE);
		if (port != null && !port.equals(currentPort)) {
			WasDatasource dsCap = (WasDatasource) ValidatorUtils.getFirstCapability(wasDSUnit,
					WasPackage.Literals.WAS_DATASOURCE);

			return ResolutionUtils.propogateAttributeValue(dsCap,
					J2eePackage.Literals.J2EE_DATASOURCE__PORT, port, context);
		}
		return false;
	}

	private static boolean propogateJ2CAuthAliasToDatasource(WasDatasourceUnit wasDSUnit,
			J2CAuthenticationUnit authenticationUnit, IDeployResolutionContext context) {
		// MK 1/19/2008 Defect 5211 [don't update if the field is already set to the same value]
		String alias = (String) CapabilityUtil.getAttributeFromUnitCapability(authenticationUnit,
				J2eePackage.Literals.J2C_AUTHENTICATION_DATA_ENTRY__ALIAS,
				J2eePackage.Literals.J2C_AUTHENTICATION_DATA_ENTRY);
		String currentAlias = (String) CapabilityUtil.getAttributeFromUnitCapability(wasDSUnit,
				WasPackage.Literals.WAS_V5_DATASOURCE__J2C_AUTH_ALIAS,
				WasPackage.Literals.WAS_DATASOURCE);
		if (null != alias && !alias.equalsIgnoreCase(currentAlias)) {
			WasDatasource dsCap = (WasDatasource) ValidatorUtils.getFirstCapability(wasDSUnit,
					WasPackage.Literals.WAS_DATASOURCE);

			return ResolutionUtils.propogateAttributeValue(dsCap,
					WasPackage.Literals.WAS_V5_DATASOURCE__J2C_AUTH_ALIAS, alias, context);
		}
		return false;
	}

	private static boolean setDatasourceNameOnDatasource(WasDatasourceUnit wasDSUnit,
			IDeployResolutionContext context) {
		String dsName = null;

		WasDatasource dsCap = (WasDatasource) ValidatorUtils.getFirstCapability(wasDSUnit,
				WasPackage.Literals.WAS_DATASOURCE);

		String jndiName = dsCap.getJndiName();
		if (jndiName != null) {
			int slash = jndiName.indexOf('/');
			if (slash + 1 < jndiName.length()) {
				dsName = jndiName.substring(slash + 1);
			}
		}

		if (null != dsName) {
			boolean result = ResolutionUtils.propogateAttributeValue(dsCap,
					J2eePackage.Literals.J2EE_DATASOURCE__DATASOURCE_NAME, dsName, context);
			System.out.println("dsCap.dsName = " + dsCap.getDatasourceName()); //$NON-NLS-1$
			return result;
		}
		return false;
	}

	private static boolean setDataStoreHelperClassNameOnDatasource(WasDatasourceUnit wasDSUnit,
			IDeployResolutionContext context) {

		DataSourceHelperClassNames helperClassName = WasDatasourceUnitValidator
				.getExpectedDataStoreClassName(wasDSUnit);
		if (null != helperClassName) {
			WasV5Datasource dsCap = (WasV5Datasource) ValidatorUtils.getFirstCapability(wasDSUnit,
					WasPackage.Literals.WAS_DATASOURCE);

			return ResolutionUtils.propogateAttributeValue(dsCap,
					WasPackage.Literals.WAS_V5_DATASOURCE__DATA_SOURCE_HELPER_CLASS_NAME,
					helperClassName, context);
//			IDeployResolution resolution = DeployAttributeValueResolution
//					.createResolution(
//							dsCap,
//							WasPackage.Literals.WAS_V5_DATASOURCE__DATA_SOURCE_HELPER_CLASS_NAME,
//							helperClassName, context);
//			resolution.resolve(new NullProgressMonitor());
//
//			return true;
		}
		return false;
	}

	private static boolean propogateClassPathToProvider(DB2JdbcProviderUnit jdbcProviderUnit,
			Unit clientUnit, DB2SystemUnit systemUnit, WebsphereContext wasContext,
			IDeployResolutionContext context) {
		DB2JdbcProvider provider = (DB2JdbcProvider) ValidatorUtils.getFirstCapability(
				jdbcProviderUnit, WasPackage.Literals.DB2_JDBC_PROVIDER);

		DB2JdbcDriver driver = null;
		if (clientUnit != null) {
			driver = (DB2JdbcDriver) ValidatorUtils.getFirstCapability(clientUnit,
					Db2Package.Literals.DB2_JDBC_DRIVER);
		} else if (systemUnit != null) {
			driver = (DB2JdbcDriver) ValidatorUtils.getFirstCapability(systemUnit,
					Db2Package.Literals.DB2_JDBC_DRIVER);
		}

//		String classpath = WasJdbcProviderHelper.INSTANCE.getExpectedClassPath(provider,
//				wasContext, driver);
		String classpath = WasJdbcProviderHelper.INSTANCE.getExpectedClasspath(jdbcProviderUnit,
				driver);
		if (null != classpath) {
			return ResolutionUtils.propogateAttributeValue(provider,
					JavaPackage.Literals.JDBC_PROVIDER__CLASSPATH, classpath, context);
//			IDeployResolution resolution = DeployAttributeValueResolution
//					.createResolution(provider,
//							JavaPackage.Literals.JDBC_PROVIDER__CLASSPATH,
//							classpath, context);
//			resolution.resolve(new NullProgressMonitor());
//
//			return true;
		}
		return false;
	}

	private static boolean propogateClassPathToProvider(DB2JdbcProviderUnit jdbcProviderUnit,
			Topology topology, IDeployResolutionContext context) {
		IProgressMonitor monitor = context.getProgressMonitor();
		// find all class paths
		// find all nodes
		Unit wasUnit = TopologyDiscovererService.INSTANCE.findHost(jdbcProviderUnit, topology,
				monitor);
		// List nodes = WebsphereContext.getWasNodes(wasUnit, topology);
		List<Unit> nodes = WebsphereContext.getHostingNodes(wasUnit, topology);
		// for each node find the "client" and "driver"
		Unit[] clients = new Unit[nodes.size()];
		DB2JdbcDriver[] drivers = new DB2JdbcDriver[nodes.size()];
		String[] cPaths = new String[nodes.size()];
		for (int i = 0; i < nodes.size(); i++) {
			Unit node = nodes.get(i);
			Unit os = TopologyDiscovererService.INSTANCE.findHost(node,
					OsPackage.Literals.OPERATING_SYSTEM_UNIT, topology, monitor);
			DiscoveryFilter clientFilter = DiscoveryFilterFactory.createFindHostedFilter(os, topology,
					monitor);
			clientFilter.setUnitTypes(new Class[] { DB2RuntimeClientUnit.class,
					DB2AdminClientUnit.class, DB2SystemUnit.class });
			List<UnitDescriptor> clientUDs = TopologyDiscovererService.INSTANCE.findAll(clientFilter);
			clients[i] = matchClient(jdbcProviderUnit, clientUDs);
			if (clients[i] != null) {
				drivers[i] = findJdbcDriver(jdbcProviderUnit, clients[i]);
//				drivers[i] = (DB2JdbcDriver) ValidatorUtils.getFirstCapability(clients[i],
//						Db2Package.Literals.DB2_JDBC_DRIVER);
				if (null != drivers[i]) { // check a match was found
					cPaths[i] = getClassPath(drivers[i]);
				}
			}
		}

		// now figure out how to define the classpath on the provider
		// TODO fix this; this is temporary
		String commonPath = findCommonPath(cPaths);
		// System.out.println (commonPath);

		// propogate this value
		DB2JdbcProvider providerCap = (DB2JdbcProvider) ValidatorUtils.getFirstCapability(
				jdbcProviderUnit, WasPackage.Literals.DB2_JDBC_PROVIDER);

		return ResolutionUtils.propogateAttributeValue(providerCap,
				JavaPackage.Literals.JDBC_PROVIDER__CLASSPATH, commonPath, context);
//		IDeployResolution resolution = DeployAttributeValueResolution
//				.createResolution(providerCap,
//						JavaPackage.Literals.JDBC_PROVIDER__CLASSPATH,
//						commonPath, context);
//		resolution.resolve(new NullProgressMonitor());
//
//		return true;
	}

	private static Unit matchClient(DB2JdbcProviderUnit jdbcProviderUnit,
			List<UnitDescriptor> clients) {
		if (clients.size() < 1) {
			return null;
		}

		return clients.get(0).getUnitValue();
	}

	private static String getClassPath(DB2JdbcDriver driver) {
		if (null == driver) {
			return null;
		}

		String classpath = driver.getClasspath();
		// cleanup result
		if (null != classpath) {
			classpath = classpath.trim();
		}

		// 11/20 2006 removed; it appears that classpath is a full classname. cf. CQtio00045610
//		String driverpath = driver.getDriverPath();
//		// cleanup result
//		if (null != driverpath)
//			driverpath = driverpath.trim();

		if (null != classpath) {
			// 11/20 2006 removed; it appears that classpath is a full classname. cf. CQtio00045610
//			if (driverpath != null) {
//				char lastCharacter = driverpath.charAt(driverpath.length() - 1);
//				if ((lastCharacter == '/') || (lastCharacter == '\\')) {
//					classpath = driverpath + classpath;
//				} else {
//					classpath = driverpath + '/' + classpath;
//				}
//			}

			classpath = classpath.replace('\\', '/');
		}

		return classpath;
	}

	private static DB2JdbcDriver findJdbcDriver(DB2JdbcProviderUnit providerUnit, Unit unit) {

		DB2JdbcProvider provider = (DB2JdbcProvider) ValidatorUtils.getFirstCapability(providerUnit,
				WasPackage.Literals.DB2_JDBC_PROVIDER);
		if (null == provider) {
			return null;
		}

		for (Capability option : ValidatorUtils.getCapabilities(unit,
				Db2Package.Literals.DB2_JDBC_DRIVER)) {
			DB2JdbcDriver opt = (DB2JdbcDriver) option;
			if (!provider.getJdbcType().equals(opt.getJdbcType())) {
				continue;
			}

			if (!provider.getImplementationClassName().equals(opt.getClassname())) {
				continue;
			}

//			System.out.println("template: " + provider.getTemplate().toString()); //$NON-NLS-1$
//			System.out.println("display: " + opt.getDisplayName()); //$NON-NLS-1$
//			if (!provider.getTemplate().toString().equals(opt.getDisplayName())) {
//				continue;
//			}
//			System.out.println("option is: " + opt); //$NON-NLS-1$
			return opt;
		}
		return null;
	}

	private static String findCommonPath(String[] cPaths) {
		for (int i = 0; i < cPaths.length; i++) {
			if (cPaths[i] != null) {
				return cPaths[i];
			}
		}
		return null;
	}

	private static boolean propogateJdbcTypeToProvider(DB2JdbcProviderUnit jdbcProviderUnit,
			Unit clientUnit, DB2SystemUnit systemUnit, IDeployResolutionContext context) {
		JdbcTypeType jdbcType = null;
		if (clientUnit != null) {
			DB2JdbcDriver driverCap = (DB2JdbcDriver) ValidatorUtils.getFirstCapability(clientUnit,
					Db2Package.Literals.DB2_JDBC_DRIVER);
			if (driverCap != null) {
				jdbcType = driverCap.getJdbcType();
			}

		}
		if (jdbcType == null && systemUnit != null) {
			DB2JdbcDriver driverCap = (DB2JdbcDriver) ValidatorUtils.getFirstCapability(systemUnit,
					Db2Package.Literals.DB2_JDBC_DRIVER);
			if (driverCap != null) {
				jdbcType = driverCap.getJdbcType();
			}
		}
		if (null != jdbcType) {
			DB2JdbcProvider providerCap = (DB2JdbcProvider) ValidatorUtils.getFirstCapability(
					jdbcProviderUnit, WasPackage.Literals.DB2_JDBC_PROVIDER);

			ResolutionUtils.propogateAttributeValue(providerCap,
					WasPackage.Literals.DB2_JDBC_PROVIDER__JDBC_TYPE, jdbcType, context);

			// now update the providerType as well
			String providerType = null;
			if (jdbcType.equals(JdbcTypeType._2_LITERAL)) {
				// DB2JdbcProviderType.DB2_LEGACY_CLI_BASED_TYPE2_JDBC_DRIVER_LITERAL
				providerType = DB2JdbcProviderType.DB2_LEGACY_CLI_BASED_TYPE2_JDBC_DRIVER_LITERAL
						.toString();
			} else if (jdbcType.equals(JdbcTypeType._4_LITERAL)) {
				// set to
				// DB2JdbcProviderType.DB2_UNIVERSAL_JDBC_DRIVER_PROVIDER_LITERAL
				providerType = DB2JdbcProviderType.DB2_UNIVERSAL_JDBC_DRIVER_PROVIDER_LITERAL
						.toString();
			} else {
				providerType = Messages.Unknown_provider;
			}
			if (null != providerType) {
				ResolutionUtils.propogateAttributeValue(providerCap,
						JavaPackage.Literals.JDBC_PROVIDER__PROVIDER_TYPE, providerType, context);
			}
			return true;
		}
		return false;
	}

	private static List<UnitDescriptor> executeQueryGetDescriptors(DiscoveryFilter filter) {
		return executeQueryGetDescriptors(new DiscoveryFilter[] { filter });
	}

	private static List<UnitDescriptor> executeQueryGetDescriptors(DiscoveryFilter[] filters) {
		return TopologyDiscovererService.INSTANCE.findAll(filters);
	}

	private static UserUnit addDbUserUnit(IDeployResolutionContext context, Unit dbOsUnit,
			String userName, String userPassword) {
		Topology topology = context.getTopology().getEditTopology();

		List<IUnitElementType> types = DeployableUnitElementUIService.getInstance()
				.getAllowableHostingUnitElements(dbOsUnit);
		for (IUnitElementType type : types) {
			String templateURI = type.getTemplateURI();
			Topology tempTopology = CoreFactory.eINSTANCE.createTopology();
			Unit u = (Unit) ResolutionUtils.addFromTemplateURI(templateURI, tempTopology);
			if (OsPackage.Literals.USER_UNIT.isSuperTypeOf(u.getEObject().eClass())) {
				// found a suitable user type
				// what happens if there is more than one?
				UserUnit userU = (UserUnit) ResolutionUtils.addFromTemplateURI(templateURI, topology);
				User userC = (User) ValidatorUtils.getCapability(userU, OsPackage.Literals.USER);
				userC.setUserId(userName);
				userC.setUserPassword(userPassword);
				userU.setInitInstallState(InstallState.UNKNOWN_LITERAL);
				userU.setGoalInstallState(InstallState.INSTALLED_LITERAL);
				return userU;
			}
		}
		return null;
	}

	private static Unit findAndAddDb2CatalogUnit(IDeployResolutionContext context, Unit earOsUnit,
			Unit dbUnit) {
		IProgressMonitor monitor = context.getProgressMonitor();
		Topology topology = context.getTopology().getEditTopology();

		DiscoveryFilter existingFilter = DiscoveryFilterFactory.createFindSourcesFilter(dbUnit,
				ValidatorUtils.getFirstCapability(dbUnit, DatabasePackage.Literals.DATABASE), topology,
				monitor);
		existingFilter.setUnitTypes(new Class[] { DB2CatalogUnit.class });
		existingFilter.setHosts(Arrays.asList(new Unit[] { earOsUnit }));
		existingFilter.setDirectHosting(Boolean.FALSE);

		// TODO what is the right query here?
		DiscoveryFilter possibleFilter = DiscoveryFilterFactory.createEmptyFilter(topology);

		String templateId = dbUnit.isConceptual() ? IDb2TemplateConstants.DB2_CATALOG_UNIT_CONCEPTUAL
				: IDb2TemplateConstants.DB2_CATALOG_UNIT;
		return findAndAddUnit(context, new DiscoveryFilter[] { existingFilter },
				new DiscoveryFilter[] { possibleFilter }, false, templateId, topology);
	}

	private static Unit findAndAddDb2NodeCatalogUnit(IDeployResolutionContext context,
			Unit catalogUnit, Unit host, Unit dbInstanceUnit) {
		IProgressMonitor monitor = context.getProgressMonitor();
		Topology topology = context.getTopology().getEditTopology();

		DiscoveryFilter eF1 = DiscoveryFilterFactory.createFindSourcesFilter(dbInstanceUnit,
				ValidatorUtils.getFirstCapability(dbInstanceUnit, Db2Package.Literals.DB2_INSTANCE),
				topology, monitor);
		assert eF1 != null;
		eF1.setUnitTypes(new Class[] { DB2NodeCatalogUnit.class });
		if (null != host) {
			eF1.setHosts(Arrays.asList(new Unit[] { host }));
		}
		eF1.setDirectHosting(Boolean.FALSE);

		DiscoveryFilter pF = DiscoveryFilterFactory.createFindPossibleHostsFilter(catalogUnit,
				topology, monitor);
		assert pF != null;
		pF.setInitInstallState(Arrays
				.asList(new InstallState[] { InstallState.NOT_INSTALLED_LITERAL }));
		pF.setUnitTypes(new Class[] { DB2NodeCatalogUnit.class });
		if (null != host) {
			pF.setHosts(Arrays.asList(new Unit[] { host }));
		}
		pF.setDirectHosting(Boolean.FALSE);

		String templateId = IDb2TemplateConstants.DB2_NODE_CATALOG_UNIT_CONCEPTUAL;
		return findAndAddUnit(context, new DiscoveryFilter[] { eF1 }, new ExpectedHostFilter(host,
				topology), new DiscoveryFilter[] { pF }, new NodeCatalogFilter(), false, templateId,
				topology);
	}

	private static Unit findAndAddDb2ClientInstanceUnit(IDeployResolutionContext context,
			Unit nodeCatalogUnit, Unit osUnit) {
		IProgressMonitor monitor = context.getProgressMonitor();
		Topology topology = context.getTopology().getEditTopology();

		DiscoveryFilter existingFilter = DiscoveryFilterFactory.createFindHostFilter(nodeCatalogUnit,
				topology, monitor);
		// 4/24/2007 capabilities must be empty for it to be a findHost filter
//		existingFilter.setCapabilities(Arrays
//				.asList(new Capability[] { Db2Factory.eINSTANCE
//						.createDB2ClientInstance() }));
		// 4/24/2007 see note below.  Duh!
//		existingFilter.setHosts(Arrays.asList(new Unit[] { osUnit }));
//		existingFilter.setDirectHosting(Boolean.FALSE);		

		DiscoveryFilter possibleFilter = DiscoveryFilterFactory.createFindPossibleHostsFilter(
				nodeCatalogUnit, topology, monitor);
		// 12/15/2005 find possible hosts query requires that direct hosting is true
		// we need to find an alternative way to identify that the indirect host is osUnit
		// possibleFilter.setHosts(Arrays.asList(new Unit[] { osUnit }));
		// possibleFilter.setDirectHosting(Boolean.FALSE);

		String templateId = IDb2TemplateConstants.DB2_CLIENT_INSTANCE_UNIT_CONCEPTUAL;
		return findAndAddUnit(context, new DiscoveryFilter[] { existingFilter }, null,
				new DiscoveryFilter[] { possibleFilter }, new HostedOnFilter(topology, osUnit, false),
				false, templateId, topology);
	}

	private static Unit findAndAddDb2ClientUnit(IDeployResolutionContext context,
			Unit clientInstanceUnit, Unit osUnit) {
		IProgressMonitor monitor = context.getProgressMonitor();
		Topology topology = context.getTopology().getEditTopology();

		DiscoveryFilter existingFilter = DiscoveryFilterFactory.createFindHostFilter(
				clientInstanceUnit, topology, monitor);

		DiscoveryFilter possibleFilter = DiscoveryFilterFactory.createFindPossibleHostsFilter(
				clientInstanceUnit, topology, monitor);

		String templateId = IDb2TemplateConstants.DB2_RUNTIME_CLIENT_UNIT_CONCEPTUAL;
		return findAndAddUnit(context, new DiscoveryFilter[] { existingFilter }, null,
				new DiscoveryFilter[] { possibleFilter }, new HostedOnFilter(topology, osUnit, true),
				false, templateId, topology);
	}

	private static Unit findAndAddWasDatasourceUnit(IDeployResolutionContext context,
			Unit earModule, Requirement req, JdbcProviderUnit jdbcProviderUnit,
			DB2InstanceUnit instanceUnit, DatabaseUnit dbUnit, J2CAuthenticationUnit authenticationUnit) {
		IProgressMonitor monitor = context.getProgressMonitor();
		Topology topology = context.getTopology().getEditTopology();

		DiscoveryFilter eF0 = DiscoveryFilterFactory.createFindTargetFilter(earModule, req, topology,
				monitor);
		eF0.setHosts(Arrays.asList(new Unit[] { jdbcProviderUnit }));
		eF0.setDirectHosting(Boolean.TRUE);

		DiscoveryFilter eF1 = null;
		eF1 = DiscoveryFilterFactory.createFindPossibleTargetsFilter(earModule, req, topology,
				monitor);
		eF1.setUnitTypes(new Class[] { WasDatasourceUnit.class });
		eF1.setHosts(Arrays.asList(new Unit[] { jdbcProviderUnit }));
		eF1.setDirectHosting(Boolean.TRUE);

		DiscoveryFilter possibleFilter = DiscoveryFilterFactory.createFindPossibleTargetsFilter(
				earModule, req, topology, monitor);
		possibleFilter.setInitInstallState(Arrays
				.asList(new InstallState[] { InstallState.NOT_INSTALLED_LITERAL }));
		possibleFilter.setUnitTypes(new Class[] { WasDatasourceUnit.class });
		possibleFilter.setHosts(Arrays.asList(new Unit[] { jdbcProviderUnit }));
		possibleFilter.setDirectHosting(Boolean.TRUE);

		EAttribute[] mutableAttributes = new EAttribute[] {
				J2eePackage.Literals.J2EE_DATASOURCE__JNDI_NAME,
				J2eePackage.Literals.J2EE_DATASOURCE__HOSTNAME,
				J2eePackage.Literals.J2EE_DATASOURCE__DB_NAME,
				WasPackage.Literals.WAS_V5_DATASOURCE__J2C_AUTH_ALIAS,
				J2eePackage.Literals.J2EE_DATASOURCE__DATASOURCE_NAME };

		Object[] values = new Object[] {
				getJndiNameFromRequirement(req),
				CapabilityUtil.getAttributeFromUnitCapability(instanceUnit,
						Db2Package.Literals.DB2_INSTANCE__HOSTNAME, Db2Package.Literals.DB2_INSTANCE),
				getDbNameFromDB(dbUnit), null, null };

		String templateId = IWasTemplateConstants.WAS_DB2_DATASOURCE_UNIT_5;
		return findAndAddUnit(context, new DiscoveryFilter[] { eF0, eF1 }, new DatasourceFilter(
				topology, req, jdbcProviderUnit, mutableAttributes, values),
				new DiscoveryFilter[] { possibleFilter }, new DatasourceFilter(topology, req, null,
						mutableAttributes, values), false, templateId, topology);
	}

	private static Unit findAndAddJ2CAuthUnit(IDeployResolutionContext context,
			UserAuthenticationDetails user, Unit dsUnit, WebsphereContext wasContext) {
		IProgressMonitor monitor = context.getProgressMonitor();
		Topology topology = context.getTopology().getEditTopology();

		// the following will be in the current topology since we have a
		// requirement on the ear hosting stack
		Unit host = null;
		if (null != wasContext.getServerUnit()) {
			host = TopologyDiscovererService.INSTANCE.findHost(dsUnit,
					WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT, topology, monitor);
			// MK 10/19/2006 scope handling
			if (null == host) {
				host = TopologyDiscovererService.INSTANCE.findHost(dsUnit,
						WasPackage.Literals.WAS_NODE_UNIT, topology, monitor);
			}
		} else {
			host = TopologyDiscovererService.INSTANCE.findHost(dsUnit,
					WasPackage.Literals.WAS_CLUSTER_UNIT, topology, monitor);
		}
		// MK 10/19/2006
		if (null == host) {
			host = TopologyDiscovererService.INSTANCE.findHost(dsUnit,
					WasPackage.Literals.WAS_CELL_UNIT, topology, monitor);
		}

		assert null != host;

		Unit wasCell = wasContext.getCellUnit();

		DiscoveryFilter eF = DiscoveryFilterFactory
				.createFindHostedFilter(wasCell, topology, monitor);
		eF.setUnitTypes(new Class[] { WASJ2CAuthenticationUnit.class });

		DiscoveryFilter possibleFilter = DiscoveryFilterFactory.createEmptyFilter(topology);
		possibleFilter.setInitInstallState(Arrays
				.asList(new InstallState[] { InstallState.NOT_INSTALLED_LITERAL }));
		possibleFilter.setUnit(dsUnit);
		possibleFilter.setUnitTypes(new Class[] { J2CAuthenticationUnit.class });
		Requirement authReq = ValidatorUtils.getFirstRequirement(dsUnit,
				J2eePackage.Literals.J2C_AUTHENTICATION_DATA_ENTRY);
		possibleFilter.setRequirements(Arrays.asList(new Requirement[] { authReq }));
		possibleFilter.setHosts(Arrays.asList(new Unit[] { wasCell }));
		possibleFilter.setDirectHosting(Boolean.TRUE);

		String templateId = wasCell.isConceptual() ? IWasTemplateConstants.WAS_J2C_AUTHENTICATION_UNIT_CONCEPTUAL
				: IWasTemplateConstants.WAS_J2C_AUTHENTICATION_UNIT;
		Unit retVal = findAndAddUnit(context, new DiscoveryFilter[] { eF },
				new J2CAuthenticationFilter(user), new DiscoveryFilter[] { possibleFilter },
				new J2CAuthenticationUserFilter(topology, authReq, user), false, templateId, topology);

//		// ensure user/password are set properly
//		propogateJ2CAuthDetails(user, (J2CAuthenticationUnit) retVal, context);
//
		return retVal;
	}

	// 9/11/2006
	// given database get set of possible providers
	// get type (if choice), XArequired from user
	private static Unit findAndAddJdbcProviderUnit(IDeployResolutionContext context,
			List<JdbcProviderPreferences> providerPreferences, DatabaseContext dbContext,
			WebsphereContext wasContext) {
		IProgressMonitor monitor = context.getProgressMonitor();
		Topology topology = context.getTopology().getEditTopology();

		// find existing jdbc providers already hosted on wasUnit (or node or cell)
		// that satisfies the user needs ?

		DiscoveryFilter eFs = null;
		if (null != wasContext.getServerUnit()) {
			eFs = DiscoveryFilterFactory.createFindHostedFilter(wasContext.getServerUnit(), topology,
					monitor);
			eFs.setUnitTypes(new Class[] { DB2JdbcProviderUnit.class });
		}
		DiscoveryFilter eFn = null;
		if (null != wasContext.getNodeUnit()) {
			eFn = DiscoveryFilterFactory.createFindHostedFilter(wasContext.getNodeUnit(), topology,
					monitor);
			eFn.setUnitTypes(new Class[] { DB2JdbcProviderUnit.class });
		}
		DiscoveryFilter eFcl = null;
		if (null != wasContext.getClusterUnit()) {
			eFcl = DiscoveryFilterFactory.createFindHostedFilter(wasContext.getClusterUnit(),
					topology, monitor);
			eFcl.setUnitTypes(new Class[] { DB2JdbcProviderUnit.class });
		}
		DiscoveryFilter eFc = null;
		if (null != wasContext.getCellUnit()) {
			eFc = DiscoveryFilterFactory.createFindHostedFilter(wasContext.getCellUnit(), topology,
					monitor);
			eFc.setUnitTypes(new Class[] { DB2JdbcProviderUnit.class });
		}

		// install new  jdbc provider that satisifes users needs
		// put it at the wasUnit (server/cluster) level
		DiscoveryFilter pF = null;
		if (null != wasContext.getServerUnit()) {
			pF = DiscoveryFilterFactory.createFindPossibleHostedFilter(wasContext.getServerUnit(),
					topology, monitor);
		} else {
			// cluster is not null
			pF = DiscoveryFilterFactory.createFindPossibleHostedFilter(wasContext.getClusterUnit(),
					topology, monitor);
		}
		pF.setUnitTypes(new Class[] { DB2JdbcProviderUnit.class });

		// get the provider and add it to the diagram; we do this in two steps.  If we must resort to a template
		// then we will explictly set various parameters in the result (we have only one template and serveral 
		// possible outcomes.
		Unit u = findAndAddUnit(context, new DiscoveryFilter[] { eFs, eFn, eFcl, eFc },
				new JdbcProviderFilter(providerPreferences), new DiscoveryFilter[] { pF }, null, false,
				null, topology);
		if (null != u) {
			return u;
		}

		// last alternative is to use template
		JdbcProviderPreferences pref = selectJdbcProviderPreference(providerPreferences);
		u = findAndAddUnit(context, new DiscoveryFilter[] {}, null, new DiscoveryFilter[] {}, null,
				false, WasJdbcProviderHelper.INSTANCE.getTemplateId(pref), topology);
		// The Universal Driver can be used for either type 2 or type 4.  Make sure it is set to the preference.
		DB2JdbcProvider p = (DB2JdbcProvider) ValidatorUtils.getCapability(u,
				WasPackage.Literals.DB2_JDBC_PROVIDER);
		if (p != null && !pref.getJdbcType().equals(p.getJdbcType())) {
			p.setJdbcType(pref.getJdbcType());
		}
		return u;
	}

	private static List<JdbcProviderPreferences> getDriverPreferences(DatabaseContext dbContext) {
		List<JdbcProviderPreferences> providerPreferences = new ArrayList<JdbcProviderPreferences>();

		if (dbContext.dbUnit instanceof DB2DatabaseUnit) {
			List<Capability> drivers = ValidatorUtils.getCapabilities(dbContext.dbSystemUnit,
					Db2Package.Literals.DB2_JDBC_DRIVER);
			for (int i = 0; i < drivers.size(); i++) {
				DB2JdbcDriver driver = (DB2JdbcDriver) drivers.get(i);
				providerPreferences.add(new JdbcProviderPreferences(driver));
			}
		}

		return providerPreferences;
	}

	private static JdbcProviderPreferences selectJdbcProviderPreference(
			List<JdbcProviderPreferences> preferences) {
		// policy looks for Universal non-XA driver first
		// then legacy non-XA driver
		// then universal xa driver
		// then legacy XA driver
		// otherwise selects first (non-)XA if available
		// otherwise picks first
		// otherwise creates a default one

		List<JdbcProviderPreferences> providerOrderPolicy = new ArrayList<JdbcProviderPreferences>();
		providerOrderPolicy.add(new JdbcProviderPreferences(Db2Package.Literals.DB2_DATABASE,
				JdbcTypeType._2_LITERAL, Boolean.FALSE, (new WasDb2UniversalProviderDefinition())
						.getProviderTypeAsString()));
		providerOrderPolicy
				.add(new JdbcProviderPreferences(Db2Package.Literals.DB2_DATABASE, null, Boolean.FALSE,
						(new WasDb2LegacyCLIType2ProviderDefinition()).getProviderTypeAsString()));
		providerOrderPolicy.add(new JdbcProviderPreferences(Db2Package.Literals.DB2_DATABASE,
				JdbcTypeType._2_LITERAL, Boolean.TRUE, (new WasDb2UniversalProviderXADefinition())
						.getProviderTypeAsString()));
		providerOrderPolicy
				.add(new JdbcProviderPreferences(Db2Package.Literals.DB2_DATABASE, null, Boolean.TRUE,
						(new WasDb2LegacyCLIType2ProviderDefinition()).getProviderTypeAsString()));
		providerOrderPolicy.add(new JdbcProviderPreferences(null, JdbcTypeType._2_LITERAL,
				Boolean.FALSE, null));
		providerOrderPolicy.add(new JdbcProviderPreferences(null, JdbcTypeType._4_LITERAL,
				Boolean.FALSE, null));
		providerOrderPolicy.add(new JdbcProviderPreferences(null, JdbcTypeType._2_LITERAL,
				Boolean.TRUE, null));
		providerOrderPolicy.add(new JdbcProviderPreferences(null, JdbcTypeType._4_LITERAL,
				Boolean.TRUE, null));
		providerOrderPolicy.add(new JdbcProviderPreferences(null, null, Boolean.FALSE, null));
		providerOrderPolicy.add(new JdbcProviderPreferences(null, null, Boolean.TRUE, null));
		providerOrderPolicy.add(new JdbcProviderPreferences(null, null, null, null));

		for (JdbcProviderPreferences policy : providerOrderPolicy) {
			for (JdbcProviderPreferences pref : preferences) {
				if (policy.getDbType() != null) {
					if (!policy.getDbType().isSuperTypeOf(pref.getDbType())) {
						continue;
					}
				}
				if (policy.getTag() != null && policy.getTag().trim().length() != 0
						&& pref.getTag() != null && pref.getTag().trim().length() != 0) {
					if (!policy.getTag().trim().equals(pref.getTag().trim())) {
						continue;
					}
				}
				if (policy.getJdbcType() != null) {
					if (!policy.getJdbcType().equals(pref.getJdbcType())) {
						continue;
					}
				}
				if (policy.isXARequired() != null && pref.isXARequired() != null) {
					if (!policy.isXARequired().equals(pref.isXARequired())) {
						continue;
					}
				}
				// found match
				return pref;
			}
		}

//		for (int i = 0; i < preferences.size(); i++) {
//			JdbcProviderPreferences pref = preferences.get(i);
//			// if (pref.isXARequired() != null && pref.isXARequired().booleanValue()) {
//			if (pref.isXARequired() != null && !pref.isXARequired().booleanValue()) {
//				return pref;
//			}
//		}
//
		if (preferences.size() == 0) {
			JdbcProviderPreferences pref = new JdbcProviderPreferences();
			pref.setDbType(Db2Package.Literals.DB2_DATABASE);
			return pref;
		}
		return preferences.get(0);
	}

	// MK: 9/12/2007 - added parameter 'unique'; true if expect a single value to be found
	private static Unit findAndAddUnit(IDeployResolutionContext context,
			DiscoveryFilter[] existingFilters, DiscoveryFilter[] possibleFilters, boolean unique,
			String templateId, Topology topology) {
		return findAndAddUnit(context, existingFilters, null, possibleFilters, null, unique,
				templateId, topology);
	}

	// MK: 9/12/2007 - added parameter 'unique'; true if expect a single value to be found
	private static Unit findAndAddUnit(IDeployResolutionContext context,
			DiscoveryFilter[] existingFilters, IDiscoveryResultFilter existingResultsFilter,
			DiscoveryFilter[] possibleFilters, IDiscoveryResultFilter possibleResultsFilter,
			boolean unique, String templateId, Topology topology) {
		// find existing units; can match any of the existing filters
		topology = topology.getEditTopology();

		for (int i = 0; i < existingFilters.length; i++) {
			if (existingFilters[i] == null) {
				continue;
			}
			List<UnitDescriptor> existing = executeQueryGetDescriptors(existingFilters[i]);
			if (null != existingResultsFilter) {
				existing = existingResultsFilter.select(existing);
			}

			if (existing.size() == 1) {
//				 System.out.println(" FOUND existing unit: " + ((UnitDescriptor) existing.get(0)).getUnitValue()); //$NON-NLS-1$
				return existing.get(0).getUnitValueAndAddToTopology(topology);
			}
			if (existing.size() > 1) {
				if (unique) {
					return null;
				} else {
					return existing.get(0).getUnitValueAndAddToTopology(topology);
				}
			}
		}

		// existing.size() == 0
		for (int i = 0; i < possibleFilters.length; i++) {
			List<UnitDescriptor> possible = executeQueryGetDescriptors(possibleFilters[i]);
			if (null != possibleResultsFilter) {
				possible = possibleResultsFilter.select(possible);
			}

			if (possible.size() == 1) {
//				 System.out.println(" FOUND possible unit: " + ((UnitDescriptor) possible.get(0)).getUnitValue()); //$NON-NLS-1$
				return possible.get(0).getUnitValueAndAddToTopology(topology);
			}
			if (possible.size() > 1) {
				if (unique) {
					// TODO get the user to pick
					return null;
				} else {
					// select the first one; might want user selection in future
					return possible.get(0).getUnitValueAndAddToTopology(topology);
				}
			}
		}

		// possible.size() == 0
		// get logical template; add to topology
		if (null != templateId) {
			templateId = templateId.trim();
			if (templateId.length() > 0) {
//				System.out.println(" FOUND: getting from template: " + templateId); //$NON-NLS-1$
				Unit u = (Unit) ResolutionUtils.addFromTemplate(templateId, topology);
				u.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
				u.setGoalInstallState(InstallState.INSTALLED_LITERAL);
				return u;
			}
		}

		// couldn't find one
		return null;
	}

	private static boolean isDb2DatabaseUnit(DeployModelObject object) {
		return Db2Package.eINSTANCE.getDB2DatabaseUnit().isSuperTypeOf(object.getEObject().eClass());
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

	private static DB2CatalogUnit processNode(UnitDescriptor osUnitUD, DatabaseContext dbContext,
			IDeployResolutionContext context) {
		// MK - 03/01/2008 - defect 5574:
		// If we can't correctly identify the hosting OS, assume that it is the SAME
		// OS [the OS specific processing in this method cannot be applied]
		if (null == osUnitUD) {
			return null;
		}
		OperatingSystemUnit osUnit = (OperatingSystemUnit) osUnitUD.getUnitValue();
		if (null == osUnit) {
			return null;
		}

		boolean isSameOs = osUnit.equals(dbContext.dbOsUnit);

		DB2CatalogUnit catalogUnit = null;
		DB2NodeCatalogUnit nodeUnit = null;
		Unit clientUnit = null; // May be one of several types of client
		Unit clientInstanceUnit = null; // May be one of several types of client units		

		// add necessary clients and configurations 
		if (!isSameOs) {
			catalogUnit = (DB2CatalogUnit) findAndAddDb2CatalogUnit(context, osUnit, dbContext.dbUnit);
			ResolutionUtils.link(context, catalogUnit, Db2Package.eINSTANCE.getDB2Database(),
					dbContext.dbUnit, Db2Package.eINSTANCE.getDB2Database());

			nodeUnit = (DB2NodeCatalogUnit) findAndAddDb2NodeCatalogUnit(context, catalogUnit, osUnit,
					dbContext.dbInstanceUnit);

			// replace the catalog unit if it is conceptual and the node catalog is not
			Unit newUnit = replaceUnit(catalogUnit, nodeUnit, IDb2TemplateConstants.DB2_CATALOG_UNIT,
					context.getTopology());
			if (newUnit != catalogUnit) {
				EcoreUtil.delete(catalogUnit);
				catalogUnit = (DB2CatalogUnit) newUnit;
				ResolutionUtils.link(context, catalogUnit, Db2Package.eINSTANCE.getDB2Database(),
						dbContext.dbUnit, Db2Package.eINSTANCE.getDB2Database());
			}

			ResolutionUtils.link(context, nodeUnit, Db2Package.eINSTANCE.getDB2Instance(),
					dbContext.dbInstanceUnit, Db2Package.eINSTANCE.getDB2Instance());

			clientInstanceUnit = findAndAddDb2ClientInstanceUnit(context, nodeUnit, osUnit);

			// replace the node catalog unit (and catalog unit) if they are conceptual and the instance is not
			newUnit = replaceUnit(nodeUnit, clientInstanceUnit,
					IDb2TemplateConstants.DB2_NODE_CATALOG_UNIT, context.getTopology());
			if (newUnit != nodeUnit) {
				EcoreUtil.delete(nodeUnit);
				nodeUnit = (DB2NodeCatalogUnit) newUnit;
				ResolutionUtils.link(context, nodeUnit, Db2Package.eINSTANCE.getDB2Instance(),
						dbContext.dbInstanceUnit, Db2Package.eINSTANCE.getDB2Instance());
				// replace the catalog unit if it is conceptual and the node catalog is not
				newUnit = replaceUnit(catalogUnit, nodeUnit, IDb2TemplateConstants.DB2_CATALOG_UNIT,
						context.getTopology());
				if (newUnit != catalogUnit) {
					EcoreUtil.delete(catalogUnit);
					catalogUnit = (DB2CatalogUnit) newUnit;
					ResolutionUtils.link(context, catalogUnit, Db2Package.eINSTANCE.getDB2Database(),
							dbContext.dbUnit, Db2Package.eINSTANCE.getDB2Database());
				}
			}

			clientUnit = findAndAddDb2ClientUnit(context, clientInstanceUnit, osUnit);

			// replace the instance unit (and the others) if they are conceptual and the client is not
			newUnit = replaceUnit(clientInstanceUnit, clientUnit,
					IDb2TemplateConstants.DB2_CLIENT_INSTANCE_UNIT, context.getTopology());
			if (newUnit != clientInstanceUnit) {
				EcoreUtil.delete(clientInstanceUnit);
				clientInstanceUnit = newUnit;
				newUnit = replaceUnit(nodeUnit, clientInstanceUnit,
						IDb2TemplateConstants.DB2_NODE_CATALOG_UNIT, context.getTopology());
				if (newUnit != nodeUnit) {
					EcoreUtil.delete(nodeUnit);
					nodeUnit = (DB2NodeCatalogUnit) newUnit;
					ResolutionUtils.link(context, nodeUnit, Db2Package.eINSTANCE.getDB2Instance(),
							dbContext.dbInstanceUnit, Db2Package.eINSTANCE.getDB2Instance());
					// replace the catalog unit if it is conceptual and the node catalog is not
					newUnit = replaceUnit(catalogUnit, nodeUnit, IDb2TemplateConstants.DB2_CATALOG_UNIT,
							context.getTopology());
					if (newUnit != catalogUnit) {
						EcoreUtil.delete(catalogUnit);
						catalogUnit = (DB2CatalogUnit) newUnit;
						ResolutionUtils.link(context, catalogUnit, Db2Package.eINSTANCE.getDB2Database(),
								dbContext.dbUnit, Db2Package.eINSTANCE.getDB2Database());
					}
				}
			}

			// replace the client unit (and the others) if they are conceptual and the os is not
			newUnit = replaceUnit(clientUnit, osUnit, IDb2TemplateConstants.DB2_RUNTIME_CLIENT_UNIT,
					context.getTopology());
			if (newUnit != clientUnit) {
				EcoreUtil.delete(clientUnit);
				clientUnit = newUnit;
				newUnit = replaceUnit(clientInstanceUnit, clientUnit,
						IDb2TemplateConstants.DB2_CLIENT_INSTANCE_UNIT, context.getTopology());
				if (newUnit != clientInstanceUnit) {
					EcoreUtil.delete(clientInstanceUnit);
					clientInstanceUnit = newUnit;
					newUnit = replaceUnit(nodeUnit, clientInstanceUnit,
							IDb2TemplateConstants.DB2_NODE_CATALOG_UNIT, context.getTopology());
					if (newUnit != nodeUnit) {
						EcoreUtil.delete(nodeUnit);
						nodeUnit = (DB2NodeCatalogUnit) newUnit;
						ResolutionUtils.link(context, nodeUnit, Db2Package.eINSTANCE.getDB2Instance(),
								dbContext.dbInstanceUnit, Db2Package.eINSTANCE.getDB2Instance());
						// replace the catalog unit if it is conceptual and the node catalog is not
						newUnit = replaceUnit(catalogUnit, nodeUnit,
								IDb2TemplateConstants.DB2_CATALOG_UNIT, context.getTopology());
						if (newUnit != catalogUnit) {
							EcoreUtil.delete(catalogUnit);
							catalogUnit = (DB2CatalogUnit) newUnit;
							ResolutionUtils.link(context, catalogUnit, Db2Package.eINSTANCE
									.getDB2Database(), dbContext.dbUnit, Db2Package.eINSTANCE
									.getDB2Database());
						}
					}
				}
			}

			if (null == ValidatorUtils.getHost(catalogUnit)) {
				// nodeUnit and catalogUnit already in topology
				ResolutionUtils.hosts(context, nodeUnit, catalogUnit);
			}
			if (null == ValidatorUtils.getHost(nodeUnit)) {
				// clientInstanceUnit and nodeUnit already in topology
				ResolutionUtils.hosts(context, clientInstanceUnit, nodeUnit);
			}
			if (null == ValidatorUtils.getHost(clientInstanceUnit)) {
				// clientUnit and clientInstanceUnit already in topology
				ResolutionUtils.hosts(context, clientUnit, clientInstanceUnit);
			}
			if (null == ValidatorUtils.getHost(clientUnit)) {
				// earOS unit may not be in the topology
				// clientUnit already in topology
				osUnit = (OperatingSystemUnit) osUnitUD.getUnitValueAndAddToTopology(context
						.getTopology().getEditTopology());
				ResolutionUtils.hosts(context, osUnit, clientUnit);
			}

			propogateDbHost(dbContext.dbInstanceUnit, nodeUnit,
					(DB2ClientInstanceUnit) clientInstanceUnit, context.getProgressMonitor());
			propogateDb((DB2DatabaseUnit) dbContext.dbUnit, catalogUnit);

		}
		return catalogUnit;
	}

	/**
	 * Given a was server or was cluster determine if all supported OSs have a DB2 client instance.
	 * 
	 * @param context
	 *           the websphere hosting stack
	 * @param topology
	 *           the current topology
	 * @return true if all nodes have a db2 client instance; false otherwise
	 */
	private static boolean allNodesHaveDb2ClientInstance(WebsphereContext context,
			Topology topology, IProgressMonitor monitor) {
		if (null != context.getServerUnit()) {
			UnitDescriptor osUnitUD = TopologyDiscovererService.INSTANCE.findHostUD(context
					.getServerUnit(), OsPackage.Literals.OPERATING_SYSTEM_UNIT, topology, monitor);
			if (null == osUnitUD) {
				return false;
			}
			return hasDb2ClientInstance((OperatingSystemUnit) osUnitUD.getUnitValue(), topology,
					monitor);
		} else if (null != context.getClusterUnit()) {
			List<UnitDescriptor> nodeUDs = getEarHostingOs(context.getClusterUnit(), topology, monitor);
			for (int i = 0; i < nodeUDs.size(); i++) {
				UnitDescriptor ud = nodeUDs.get(i);
				if (!hasDb2ClientInstance((OperatingSystemUnit) ud.getUnitValue(), topology, monitor)) {
					return false;
				}
			}
			return true;
		} else {
			// invalid context
			return false;
		}
	}

	/**
	 * Determine if a node (identified by its operating system hosts a DB2 instance.
	 * 
	 * @param osUnit
	 *           the operating system unit
	 * @param topology
	 *           the topology
	 * @return true if client exists
	 */
	private static boolean hasDb2ClientInstance(OperatingSystemUnit osUnit, Topology topology,
			IProgressMonitor monitor) {
		DiscoveryFilter filter = DiscoveryFilterFactory.createFindHostedFilter(osUnit, topology,
				monitor);
		filter.setUnitTypes(new Class[] { DB2AdminClientUnit.class, DB2RuntimeClientUnit.class,
				DB2AppDevelClientUnit.class, DB2SystemUnit.class });
		List<UnitDescriptor> clientUDs = TopologyDiscovererService.INSTANCE.findAll(filter);
		if (0 == clientUDs.size()) {
			return false;
		}
		// check for an instance
		for (int i = 0; i < clientUDs.size(); i++) {
			UnitDescriptor ud = clientUDs.get(i);
			Unit unit = ud.getUnitValue();
			filter = DiscoveryFilterFactory.createFindHostedFilter(unit, topology, monitor);
			// MK 12/18/2006 this code has been cut because of observed problems with code;
			// replace when bug tiou00047182 is fixed
//			if (unit instanceof DB2SystemUnit) {
//				filter.setUnitTypes(new Class[] { DB2InstanceUnit.class });
//			} else {
//				filter
//						.setUnitTypes(new Class[] { DB2ClientInstanceUnit.class });
//			}
			List<UnitDescriptor> instanceUDs = TopologyDiscovererService.INSTANCE.findAll(filter);
			if (0 != instanceUDs.size()) {
				return true;
			}
		}
		return false;
	}

	private static boolean isSingleServer(WebsphereContext wasContext, DatabaseContext dbContext,
			Topology topology, IProgressMonitor monitor) {
		if (null == wasContext.getServerUnit()) {
			return false;
		}
		UnitDescriptor osUnitUD = TopologyDiscovererService.INSTANCE.findHostUD(wasContext
				.getServerUnit(), OsPackage.Literals.OPERATING_SYSTEM_UNIT, topology, monitor);
		if (null == osUnitUD) {
			return false;
		}

		boolean isSame = osUnitUD.getUnitValue() == dbContext.dbOsUnit;
		return isSame;
	}

	private static void fixUpPaths(JdbcProviderUnit providerUnit, Unit wasUnit,
			WebsphereContext wasContext) {
		if (null == providerUnit || null == wasUnit || null == wasContext) {
			return;
		}
		fixUpPath((String) CapabilityUtil.getAttributeFromUnitCapability(providerUnit,
				JavaPackage.Literals.JDBC_PROVIDER__CLASSPATH, JavaPackage.Literals.JDBC_PROVIDER),
				wasUnit, wasContext);
		fixUpPath((String) CapabilityUtil.getAttributeFromUnitCapability(providerUnit,
				JavaPackage.Literals.JDBC_PROVIDER__NATIVEPATH, JavaPackage.Literals.JDBC_PROVIDER),
				wasUnit, wasContext);
	}

	private static void fixUpPath(String path, Unit wasUnit, WebsphereContext wasContext) {
		String[] variables = wasContext.getSubstitutionVariables(path);
		for (int i = 0; i < variables.length; i++) {
			if (!wasContext.checkExistence(variables[i])) {
// TODO FIX post M4				
// MK need to create Substitution Variable on wasServer. _Problem_
				if (wasUnit.getTopology() == wasUnit.getEditTopology()) {
					wasContext.addNewSubstitutionVariable(variables[i], wasUnit);
				}
			}
		}
	}

	private static String getJndiNameFromBinding(Requirement req) {
		String jndiName = null;
		List<Constraint> bindingConstraints = ConstraintUtil.getConstraints(req,
				WasPackage.Literals.WAS_JNDI_BINDING_CONSTRAINT);
		// we expect only one; if more than one will pick the last with a non-null, non-empty value
		for (Constraint c : bindingConstraints) {
			WasJNDIBindingConstraint bc = (WasJNDIBindingConstraint) c;
			String name = bc.getJndiName();
			if (null != name && name.trim().length() > 0) {
				jndiName = name.trim();
			}
		}
		return jndiName;
	}

	private static boolean propagateJndiNameToDatasource(Requirement dsReq,
			IDeployResolutionContext context) {
		if (null == dsReq) {
			return false;
		}

		// find the value to propagate and the current value
		// datasource was added to the topology; so we don't need discovery
		// indeed, discovery may fail if the datasource is new:  the discovery cache will hide it
		// Capability dsCap = ValidatorUtils.discoverDependencyLinkTarget(dsReq, context.getProgressMonitor());
		Capability dsCap = dsReq.getLink().getTarget();
		String jndiName = getJndiNameFromBinding(dsReq);
		String currentJndiName = (String) CapabilityUtil.getValue(dsCap,
				J2eePackage.Literals.J2EE_DATASOURCE__DATASOURCE_NAME.toString());

		// MK 04-24-2008 - defect 5677; if jndiName is null create one
		if (null == jndiName && null == currentJndiName) {
			jndiName = generateJndiName((J2EEDatasource) dsCap, context.getProgressMonitor());
		}

		// if the field is not already set to the same value update the field
		if (jndiName != null && !jndiName.equals(currentJndiName)) {
			boolean result = ResolutionUtils.propogateAttributeValue(dsCap,
					J2eePackage.Literals.J2EE_DATASOURCE__JNDI_NAME, jndiName, context);
			return result;
		}

		return true;
	}

	private static String generateJndiName(J2EEDatasource ds, IProgressMonitor monitor) {
		String proposal = null;
		String dsName = ds.getDatasourceName();
		if (null != dsName && 0 < dsName.trim().length()) {
			proposal = createUniqueJndiName(dsName.trim(), ds, monitor);
		}
		if (null == proposal) {
			String dbName = ds.getDbName();
			if (null != dbName && 0 < dbName.trim().length()) {
				proposal = createUniqueJndiName(dbName.trim(), ds, monitor);
			}
		}
		if (null == proposal) {
			int rdm = (int) Math.floor(1000.0 * Math.random());
			proposal = createUniqueJndiName(Integer.toString(rdm), ds, monitor);
		}
		return proposal;
	}

	private static String createUniqueJndiName(String seed, J2EEDatasource ds,
			IProgressMonitor monitor) {
		String JNDI_NAME_PREFIX = "jdbc"; //$NON-NLS-1$
		String JNDI_NAME_SEPARATOR = "/"; //$NON-NLS-1$
		String proposalPrefix = JNDI_NAME_PREFIX + JNDI_NAME_SEPARATOR + seed;
		Unit dsHost = ValidatorUtils.discoverHost(ds, monitor);

		String currentProposal = proposalPrefix;
		for (int index = 0; index < 10000; index++) {
			boolean failure = false;
			List<Capability> possibleConflicts = ValidatorUtils.discoverHostedCapabilities(dsHost,
					J2eePackage.Literals.J2EE_DATASOURCE, false, monitor);
			for (Capability d : possibleConflicts) {
				J2EEDatasource datasource = (J2EEDatasource) d;
				if (datasource.equals(ds)) {
					continue;
				}
				if (datasource.getJndiName().equals(currentProposal)) {
					currentProposal = proposalPrefix + index;
					failure = true;
					break;
				}
			}
			if (!failure) {
				return currentProposal;
			}
		}

		// tried hard and failed; give up
		return null;
	}

	private static boolean propogateJndiNameToBindings(WasDatasourceUnit wasDSUnit,
			IDeployResolutionContext context) {
		if (null == wasDSUnit) {
			return false;
		}
		String jndiName = (String) CapabilityUtil.getAttributeFromUnitCapability(wasDSUnit,
				J2eePackage.Literals.J2EE_DATASOURCE__JNDI_NAME, WasPackage.Literals.WAS_DATASOURCE);
		if (null == jndiName || jndiName.trim().length() == 0) {
			return false;
		}
		Capability dsCap = ValidatorUtils.getFirstCapability(wasDSUnit,
				WasPackage.Literals.WAS_DATASOURCE);
		List<Requirement> sourceReqs = ValidatorUtils.discoverDependencyLinkSources(dsCap, context
				.getTopology().getEditTopology(), context.getProgressMonitor());
		for (Requirement req : sourceReqs) {
			List<Constraint> bindingConstraints = ValidatorUtils.getConstraints(req,
					WasPackage.Literals.WAS_JNDI_BINDING_CONSTRAINT);
			for (int i = 0; i < bindingConstraints.size(); i++) {
				WasJNDIBindingConstraint bindingConstraint = (WasJNDIBindingConstraint) bindingConstraints
						.get(i);
				if (bindingConstraint
						.isPublicEditable(WasPackage.Literals.WAS_JNDI_BINDING_CONSTRAINT__JNDI_NAME
								.getName())) {
					bindingConstraint.setJndiName(jndiName);
				}
			}
		}
		return true;
	}

	private static Unit replaceUnit(Unit hostee, Unit host, String templateId, Topology topology) {
		if (!host.isConceptual() && hostee.isConceptual()) {
			// hostee unit came from a template; replace it
			templateId = templateId.trim();
			Unit u = (Unit) ResolutionUtils.addFromTemplate(templateId, topology);
			u.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
			return u;
		}
		return hostee;
	}

	private static void createNCC(Constraint acc, IDeployResolutionContext context) {
		DeployValidatorService dvs = DeployValidatorService
				.getOrCreateValidatorService(WasDB2UIPlugin.pluginID);
		dvs.validate(context.getTopology());
		List<IDeployStatus> statuses = ResolutionUtils.getStatuses(acc,
				ICoreProblemType.CANNOT_MATCH_ACC_TO_NCC, IStatus.ERROR);
		for (IDeployStatus status : statuses) {
			if (dvs.hasResolutions(status)) {
				List<IDeployResolution> resolutions = ResolutionUtils.getResolutions(dvs
						.getResolutions(status), AddNetworkCommunicationConstraintResolution.class);
				assert 1 <= resolutions.size(); // should be only 1
				resolutions.get(0).resolve(context.getProgressMonitor());
			}
		}
	}

	/**
	 * Details about the users hosted on an operating system.
	 */
	private static class OsUsers {
		private final OperatingSystemUnit _osUnit;
		private final Topology _topology;
		private final int _numberOfUsers;
		private final UnitDescriptor[] _userDescriptions;
		private final UserUnit[] _userUnits;
		private final User[] _users;

		/**
		 * Constructor that idenfies all of the users on an operating system
		 * 
		 * @param osUnit
		 *           the operating system unit (need not be in the target topology)
		 * @param topology
		 *           the target topology
		 */
		public OsUsers(OperatingSystemUnit osUnit, Topology topology) {
			_osUnit = osUnit;
			_topology = topology;
			DiscoveryFilter filter = DiscoveryFilterFactory.createFindHostedFilter(_osUnit, _topology);
			filter.setUnitTypes(new Class[] { UserUnit.class });
			List userDescriptors = TopologyDiscovererService.INSTANCE.findAll(filter);
			_numberOfUsers = userDescriptors.size();
			_userDescriptions = new UnitDescriptor[_numberOfUsers];
			_userUnits = new UserUnit[_numberOfUsers];
			_users = new User[_numberOfUsers];
			for (int i = 0; i < _numberOfUsers; i++) {
				UnitDescriptor descriptor = (UnitDescriptor) userDescriptors.get(i);
				_userDescriptions[i] = descriptor;
				_userUnits[i] = (UserUnit) RealizationLinkUtil.getFinalRealization(descriptor
						.getUnitValue());
				_users[i] = (User) ValidatorUtils.getFirstCapability(_userUnits[i],
						OsPackage.Literals.USER);
			}
		}

		/**
		 * Constructor that identifies a single user on an operating system
		 * 
		 * @param userUnit
		 *           the user (need not be in the target topology)
		 * @param topology
		 *           the target topology
		 * @param monitor
		 */
		public OsUsers(UserUnit userUnit, Topology topology, IProgressMonitor monitor) {
			_osUnit = (OperatingSystemUnit) TopologyDiscovererService.INSTANCE.findHost(userUnit,
					topology, monitor);
			_topology = topology;
			_numberOfUsers = 1;
			_userDescriptions = new UnitDescriptor[] { null };
			_userUnits = new UserUnit[] { userUnit };
			_users = new User[] { (User) ValidatorUtils.getFirstCapability(_userUnits[0],
					OsPackage.Literals.USER) };
		}

		/**
		 * Retrieve the number of users defined on the operating system.
		 * 
		 * @return the number of users
		 */
		public int getNumberOfUsers() {
			return _numberOfUsers;
		}

		/**
		 * Get an array of the user ids.
		 * 
		 * @return array of user ids
		 */
		public String[] getUserDisplayNames() {
			if (null == _users) {
				return new String[0];
			}

			String[] names = new String[_numberOfUsers];
			for (int i = 0; i < _numberOfUsers; i++) {
				names[i] = _users[i].getUserId();
			}

			return names;
		}

		/**
		 * Retrieve an identified {@link User}.
		 * 
		 * @param index
		 *           the index of the desired {@link User}
		 * @return the {@link User}
		 */
		public User getUser(int index) {
			if (index > _numberOfUsers || index < 0) {
				return null;
			}

			return _users[index];
		}

		/**
		 * Retrieve an identified {@link UserUnit}.
		 * 
		 * @param index
		 *           the index of the desired {@link UserUnit}
		 * @param addToTopology
		 *           flag indicating whether or not user should be added to topology
		 * @return the {@link UserUnit}
		 */
		public UserUnit getUserUnit(int index, boolean addToTopology) {
			if (index > _numberOfUsers || index < 0) {
				return null;
			}

			if (!addToTopology || _userDescriptions[index] == null) {
				return _userUnits[index];
			}

			return (UserUnit) _userDescriptions[index].getUnitValueAndAddToTopology(_topology);
		}

		/**
		 * Retrieve a {@link UserUnit} identified by its user id.
		 * 
		 * @param userId
		 *           the user id
		 * @return the {@link UserUnit} if present, null otherwise
		 */
		public UserUnit getUserUnit(String userId) {
			for (int i = 0; i < _numberOfUsers; i++) {
				if (_users[i].getUserId().equals(userId)) {
					return _userUnits[i];
				}
			}
			return null;
		}

	}
}
