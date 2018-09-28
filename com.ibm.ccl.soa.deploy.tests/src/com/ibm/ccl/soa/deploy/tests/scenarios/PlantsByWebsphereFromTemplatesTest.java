/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.scenarios;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyUnitDescriptor;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployStatusIterator;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCoreValidators;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.database.DDLArtifact;
import com.ibm.ccl.soa.deploy.database.DatabaseFactory;
import com.ibm.ccl.soa.deploy.database.SQLModule;
import com.ibm.ccl.soa.deploy.db2.DB2Database;
import com.ibm.ccl.soa.deploy.db2.DB2DatabaseUnit;
import com.ibm.ccl.soa.deploy.db2.DB2Instance;
import com.ibm.ccl.soa.deploy.db2.DB2InstanceUnit;
import com.ibm.ccl.soa.deploy.db2.DB2SystemUnit;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.IDb2TemplateConstants;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.DeployResolutionContext;
import com.ibm.ccl.soa.deploy.internal.db2.ui.validator.resolution.GUICreateDB2InstanceAdminUserResolution;
import com.ibm.ccl.soa.deploy.j2ee.EARModuleCapability;
import com.ibm.ccl.soa.deploy.j2ee.EarModule;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.os.IOsTemplateConstants;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.User;
import com.ibm.ccl.soa.deploy.os.UserUnit;
import com.ibm.ccl.soa.deploy.server.IServerTemplateConstants;
import com.ibm.ccl.soa.deploy.server.ServerUnit;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeGroup;
import com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasServer;
import com.ibm.ccl.soa.deploy.was.WasSystemUnit;
import com.ibm.ccl.soa.deploy.was.WasV5Datasource;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.db2.DatasourceSatisfactionConstraint;
import com.ibm.ccl.soa.deploy.was.db2.WasDb2Factory;
import com.ibm.ccl.soa.deploy.was.db2.internal.validator.IEarToDbLinkValidatorID;
import com.ibm.ccl.soa.deploy.was.db2.ui.eartodb.resolution.ConfigureJ2eeModuleAccessToDatatbaseResolution;
import com.ibm.ccl.soa.deploy.was.db2.ui.internal.Messages;
import com.ibm.ccl.soa.deploy.was.db2.validator.IWasDb2ProblemType;
import com.ibm.ccl.soa.deploy.was.validator.IWASProblemType;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * JUnit test case for Plants-by.
 * 
 * <p>
 * 
 * @author Bill Arnold
 */
public class PlantsByWebsphereFromTemplatesTest extends TopologyTestCase {

	public static final String DB2_OS_HOST_NAME = "osDB2";

	// private static final String PROJECT_NAME = "PlantsByWASTest";

	// private static final String PLANTS_TOPOLOGY_NAME = "plants.topology";

	// Use instance variables for now
	/** Topology used for the middleware units. */
	private Topology top;

	/** Imported module topology. */
	private Topology moduleTop;

	/** Topology used for the EAR and DDL module units. */
	private Topology moduleTopEdit;

	/** Imported infrastructure topology. */
	private Topology infraTop;

	/** Topology used for the OS and system units. */
	private Topology infraTopEdit;

	/** Optional {@link Import} of {@link #moduleTopEdit} in {@link top} */
	private Import moduleTopImport;

	/** Optional {@link Import} of {@link #infraTopEdit} in {@link top} */
	private Import infraTopImport;

	private DB2InstanceUnit db2InstanceUnit;

	private DB2SystemUnit db2SystemUnit;

	private OperatingSystemUnit operatingSystemUnitDB2;

	private ServerUnit serverUnitDB2;

	private UserUnit db2AdminUserUnit;

	private DB2DatabaseUnit db2DatabaseUnit;

	private SQLModule sqlModuleEdit;

	private SQLModule sqlModule;

	private WasSystemUnit wasSystemUnit;

	private OperatingSystemUnit operatingSystemUnitWAS;

	private ServerUnit serverUnitWAS;

	private WebsphereAppServerUnit was6ServerUnit;

	private WasNodeUnit wasNodeUnit;

	private WasNodeGroupUnit wasNodeGroupUnit;

	private EarModule earModule;

	private Requirement dsReq;

	private DB2Database db2Database;

	private DeployValidatorService deployValidatorService;

	private DatasourceSatisfactionConstraint dsConstraint;
	
	private ConstraintLink ds2dbll;

	private WasCellUnit wasCellUnit;

	private OperatingSystemUnit operatingSystemUnitDB2Edit;

	private ServerUnit serverUnitDB2Edit;

	private OperatingSystemUnit operatingSystemUnitWASEdit;

	private ServerUnit serverUnitWASEdit;

	private Requirement dsReqEdit;

	private EarModule earModuleEdit;

	/** Test case ctor */
	public PlantsByWebsphereFromTemplatesTest() {
		super("PlantsByWebsphereTest");
	}

	/*
	 * @see junit.framework.TestCase#tearDown() Uncomment to stop deletion of
	 *      plants topology after test run.
	 */
	protected void tearDown() throws Exception {
	}

	/**
	 * @throws Exception
	 *             Note 2007/04/04 main test case won't run without this dummy
	 *             test run first.
	 */
	public void testDummy() throws Exception {
		createTopology("dummy");
	}

	/**
	 * Populates the topology with the Plants by WebSphere objects.
	 * 
	 */
	public void addPlantsByWebSphereObjects() throws IOException {
		//
		// Create module topology
		//
		addDDLModule();
		addEARModule();

		if (moduleTopEdit != top) {
			save(moduleTopEdit);

			moduleTopImport = TopologyUtil.importTopology(moduleTopEdit, top);
			moduleTop = TopologyUtil.resolve(moduleTopImport);
			assert moduleTopImport != null;
			assert moduleTop != null;

			this.sqlModule = (SQLModule) top.resolve(DeployModelObjectUtil.getGlobalPath(sqlModuleEdit));
			this.earModule = (EarModule) top.resolve(DeployModelObjectUtil.getGlobalPath(earModuleEdit));
			this.dsReq = (Requirement) top.resolve(DeployModelObjectUtil.getGlobalPath(dsReqEdit));
			assert this.sqlModule != null;
			assert earModule != null;
			assert dsReq != null;
		} else {
			moduleTop = top;

			this.sqlModule = sqlModuleEdit;
			this.earModule = earModuleEdit;
			this.dsReq = dsReqEdit;
		}

		//
		// Create infrastructure topology
		//
		createDB2Infra();
		createWASInfra();

		// Set passwords
		for (Iterator capIter = infraTopEdit.findAllCapabilities(); capIter.hasNext();) {
			Capability cap = (Capability) capIter.next();
			if (cap instanceof User) {
				User u = (User) cap;
				if (u.getUserPassword() == null) {
					u.setUserPassword("dummyPassword");
				}
			}
		}

		if (infraTopEdit != top) {
			save(infraTopEdit);

			infraTopImport = TopologyUtil.importTopology(infraTopEdit, top);
			
			// re-export the import
			infraTopImport.setReexported(true);
			infraTop = TopologyUtil.resolve(infraTopImport);
			assert infraTopImport != null;
			assert infraTop != null;

			this.operatingSystemUnitDB2 = (OperatingSystemUnit) top.resolve(DeployModelObjectUtil
					.getGlobalPath(operatingSystemUnitDB2Edit));
			this.serverUnitDB2 = (ServerUnit) top.resolve(DeployModelObjectUtil.getGlobalPath(serverUnitDB2Edit));
			this.operatingSystemUnitWAS = (OperatingSystemUnit) top.resolve(DeployModelObjectUtil
					.getGlobalPath(operatingSystemUnitWASEdit));
			this.serverUnitWAS = (ServerUnit) top.resolve(DeployModelObjectUtil.getGlobalPath(serverUnitWASEdit));
			assert this.operatingSystemUnitDB2 != null;
			assert this.serverUnitDB2 != null;
			assert this.operatingSystemUnitWAS != null;
			assert this.serverUnitWAS != null;
		} else {
			infraTop = top;

			this.operatingSystemUnitDB2 = operatingSystemUnitDB2Edit;
			this.serverUnitDB2 = serverUnitDB2Edit;
			this.operatingSystemUnitWAS = operatingSystemUnitWASEdit;
			this.serverUnitWAS = serverUnitWASEdit;
		}

		//
		// Create "edit" middleware topology
		//
		createDB2Middleware();
		createWASMiddleware();

		//
		// Create cross-topology links
		//
		HostingLink link = ValidatorTestUtils.hosts(db2DatabaseUnit, sqlModule);
		assert link != null;
		assertSetEquals(top.findHosts(sqlModule), new Object[] { db2DatabaseUnit });
		assertSetEquals(moduleTop.findHosts(sqlModule), new Object[] { db2DatabaseUnit });
		assert link.getSource() == db2DatabaseUnit;
		assert link.getTarget() == sqlModule;
		assert link.getTopology() == top;
		assert link.getParent() == db2DatabaseUnit;
		assertSetEquals(db2DatabaseUnit.getHostingLinks(), new Object[] { link });
		assertContains(top.findAllHostingLinks(), link);
		assertContains(top.findAllUnitLinks(), link);
		assertEquals(top.resolve(sqlModule.getFullPath()), sqlModule);
		assertEquals(moduleTop.resolve(sqlModule.getFullPath()), sqlModule);
		assertEquals(infraTop.resolve(sqlModule.getFullPath()), sqlModule);

		ValidatorTestUtils.hosts(was6ServerUnit, earModule);
		assertSetEquals(top.findHosts(earModule), new Object[] { was6ServerUnit });
		assertSetEquals(moduleTop.findHosts(earModule), new Object[] { was6ServerUnit });

		ValidatorTestUtils.hosts(operatingSystemUnitDB2, db2SystemUnit);
		assertSetEquals(top.findHosts(db2SystemUnit), new Object[] { operatingSystemUnitDB2 });
		assertSetEquals(infraTop.findHosts(db2SystemUnit), new Object[] { operatingSystemUnitDB2 });

		ValidatorTestUtils.hosts(operatingSystemUnitWAS, wasSystemUnit);
		assertSetEquals(top.findHosts(wasSystemUnit), new Object[] { operatingSystemUnitWAS });
		assertSetEquals(infraTop.findHosts(wasSystemUnit), new Object[] { operatingSystemUnitWAS });

// <core:link.logical xsi:type="core:LogicalLink"
// name="plantsby_PlantsByWebSphereDataSourceLogicalToDB2 Database"
// source="/PlantsByWebSphere#plantsby_PlantsByWebSphereDataSource"
// target="/DB2Database0#DB2 Database"/>
		ds2dbll = CoreFactory.eINSTANCE.createConstraintLink();
		ds2dbll.setName("plantsby_PlantsByWebSphereDataSourceLogicalToDB2 Database");
		ds2dbll.setSource(dsReq);
		ds2dbll.setTarget(db2Database);
		earModule.getConstraintLinks().add(ds2dbll);
		// MK 7/4/2007 add constraint to link
		dsConstraint = WasDb2Factory.eINSTANCE.createDatasourceSatisfactionConstraint();
		dsConstraint.setName("plantsby_DatasourceSatisfactionConstraint");
		ds2dbll.getConstraints().add(dsConstraint);
	}

	// TODO consider using provider to build the ear from a DDL file
	private void addDDLModule() throws IOException {
		sqlModuleEdit = DatabaseFactory.eINSTANCE.createSQLModule();
		sqlModuleEdit.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		sqlModuleEdit.setName("plantsbywebsphere_ddl");
		sqlModuleEdit.setDisplayName("plantsbywebsphere.ddl");
		DDLArtifact ddlArtifact = DatabaseFactory.eINSTANCE.createDDLArtifact();
		ddlArtifact.setName("plantsbywebsphere_ddl");
		ddlArtifact.setDisplayName("plantsbywebsphere.ddl");
		ddlArtifact.getFileURIs().add("C:\\plantsbywebsphere.ddl");
		sqlModuleEdit.getArtifacts().add(ddlArtifact);
		Requirement db2DBReq = ValidatorTestUtils.createHostingRequirement(Db2Package.eINSTANCE.getDB2Database(),
				"db2DBReq");
		sqlModuleEdit.getRequirements().add(db2DBReq);
		Annotation ann = CoreFactory.eINSTANCE.createAnnotation();
		ann.setContext("environment_wtp");
		ann.getDetails().put("module_type", "ddl");
		sqlModuleEdit.getAnnotations().add(ann);
		moduleTopEdit.getUnits().add(sqlModuleEdit);
	}

	private void createDB2Infra() throws IOException {
		operatingSystemUnitDB2Edit = (OperatingSystemUnit) ResolutionUtils.addFromTemplate(IOsTemplateConstants.OS_WINDOWS_2000_UNIT, infraTopEdit); //$NON-NLS-1$
		serverUnitDB2Edit = (ServerUnit) ResolutionUtils.addFromTemplate(IServerTemplateConstants.SERVER_INTEL_X86_UNIT, infraTopEdit); //$NON-NLS-1$

		ValidatorTestUtils.hosts(serverUnitDB2Edit, operatingSystemUnitDB2Edit);

		OperatingSystem operatingSystemDB2 = (OperatingSystem) ValidatorUtils.getCapability(operatingSystemUnitDB2Edit,
				OsPackage.eINSTANCE.getOperatingSystem());
		operatingSystemDB2.setHostname(DB2_OS_HOST_NAME);
	}

	private void createDB2Middleware() {
		db2DatabaseUnit = (DB2DatabaseUnit) ResolutionUtils.addFromTemplate(IDb2TemplateConstants.DB2_DATABASE_UNIT, top); //$NON-NLS-1$
		db2InstanceUnit = (DB2InstanceUnit) ResolutionUtils.addFromTemplate(IDb2TemplateConstants.DB2_INSTANCE_UNIT, top); //$NON-NLS-1$
		db2SystemUnit = (DB2SystemUnit) ResolutionUtils.addFromTemplate(IDb2TemplateConstants.DB2_SYSTEM_UNIT, top); //$NON-NLS-1$	

		ValidatorTestUtils.hosts(db2SystemUnit, db2InstanceUnit);
		ValidatorTestUtils.hosts(db2InstanceUnit, db2DatabaseUnit);

		DB2Instance db2Instance = (DB2Instance) ValidatorUtils.getCapability(db2InstanceUnit, Db2Package.eINSTANCE
				.getDB2Instance());
		db2Instance.setHostname(DB2_OS_HOST_NAME);

		fixupDB2OperatingSystem();

		User db2AdminUserCap = (User) ValidatorUtils.getCapability(db2AdminUserUnit, OsPackage.eINSTANCE.getUser());
		assert (db2AdminUserCap != null);
		Requirement userReq = ValidatorUtils.getFirstRequirement(db2InstanceUnit, OsPackage.eINSTANCE.getUser());
		assert (userReq != null);
		LinkDescriptor newLinkDescriptor = new LinkDescriptor(LinkType.DEPENDENCY, db2InstanceUnit, userReq,
				db2AdminUserUnit, db2AdminUserCap);
		newLinkDescriptor.create();

		// TODO do propagation with resolution
		User db2AdminUser = (User) ValidatorUtils.getCapability(db2AdminUserUnit, OsPackage.eINSTANCE.getUser());
		db2Instance.setUsername(db2AdminUser.getUserId());
		db2Instance.setPassword(db2AdminUser.getUserPassword());

		// DB name not set in template
		db2Database = (DB2Database) ValidatorUtils
				.getCapability(db2DatabaseUnit, Db2Package.eINSTANCE.getDB2Database());
		db2Database.setDbName("PLANTS");
	}

	private void fixupDB2OperatingSystem() {
		UnitDescriptor operatingSystemUnitUD = new TopologyUnitDescriptor(this.operatingSystemUnitDB2, top, null);
		if (null == operatingSystemUnitUD.getUnitValue()) {
			operatingSystemUnitUD = null;
		}
		db2AdminUserUnit = GUICreateDB2InstanceAdminUserResolution.createUserOnOSInTopology(operatingSystemUnitUD,
				top, "db2admin", "db2admin", "8.2", null);
	}

	private void createWASInfra() throws IOException {
		operatingSystemUnitWASEdit = (OperatingSystemUnit) ResolutionUtils.addFromTemplate(IOsTemplateConstants.OS_WINDOWS_2003_UNIT, infraTopEdit); //$NON-NLS-1$
		serverUnitWASEdit = (ServerUnit) ResolutionUtils.addFromTemplate(IServerTemplateConstants.SERVER_INTEL_X86_UNIT, infraTopEdit); //$NON-NLS-1$	

		OperatingSystem operatingSystemWAS = (OperatingSystem) ValidatorUtils.getCapability(operatingSystemUnitWASEdit,
				OsPackage.eINSTANCE.getOperatingSystem());
		operatingSystemWAS.setHostname("osWAS");

		ValidatorTestUtils.hosts(serverUnitWASEdit, operatingSystemUnitWASEdit);
	}

	private void createWASMiddleware() {
		// TODO consider changing to the WAS6 Standalone Server mega-template
		was6ServerUnit = (WebsphereAppServerUnit) ResolutionUtils.addFromTemplate(IWasTemplateConstants.WAS_6_APPLICATION_SERVER_UNIT, top); //$NON-NLS-1$
		wasNodeUnit = (WasNodeUnit) ResolutionUtils.addFromTemplate(IWasTemplateConstants.WAS_6_NODE_UNIT, top); //$NON-NLS-1$
		wasNodeGroupUnit = (WasNodeGroupUnit) ResolutionUtils.addFromTemplate(IWasTemplateConstants.WAS_6_NODE_GROUP_UNIT, top); //$NON-NLS-1$
		wasCellUnit = (WasCellUnit) ResolutionUtils.addFromTemplate(IWasTemplateConstants.WAS_6_STANDALONE_CELL_UNIT, top); //$NON-NLS-1$
		wasSystemUnit = (WasSystemUnit) ResolutionUtils.addFromTemplate(IWasTemplateConstants.WAS_6_SYSTEM_UNIT, top); //$NON-NLS-1$	

		ValidatorTestUtils.hosts(wasSystemUnit, wasNodeUnit);
		ValidatorTestUtils.hosts(wasNodeUnit, wasCellUnit);
		ValidatorTestUtils.hosts(wasNodeUnit, was6ServerUnit);

		WasServer was6Server = (WasServer) ValidatorUtils.getCapability(was6ServerUnit, WasPackage.eINSTANCE
				.getWasServer());
		was6Server.setServerName("server1");

		WasNode wasNode = (WasNode) ValidatorUtils.getCapability(wasNodeUnit, WasPackage.eINSTANCE.getWasNode());
		wasNode.setProfileName("default");
		wasNode.setProfileLocation("C:\\Program Files\\IBM\\WebSphere\\AppServer\\profiles\\default");
		wasNode.setIsDefaultProfile(true);

		WasNodeGroup wasNodeGroup = (WasNodeGroup) ValidatorUtils.getCapability(wasNodeGroupUnit, WasPackage.eINSTANCE
				.getWasNodeGroup());
		wasNodeGroup.setNodeGroupName("nodegroup1"); // What is the default?
		wasNodeGroup.setIsDefaultType(true);

// MemberLink mlServerInNode = CoreFactory.eINSTANCE.createMemberLink();
// mlServerInNode.setSource(wasNodeUnit);
// mlServerInNode.setTarget(was6ServerUnit);
// mlServerInNode.setName(was6ServerUnit.getName() + "In" +
// wasNodeUnit.getName());
// mlServerInNode.setDisplayName(mlServerInNode.getName());
// wasNodeUnit.getMemberLinks().add(mlServerInNode);

		MemberLink mlNodeInNodeGroup = CoreFactory.eINSTANCE.createMemberLink();
		mlNodeInNodeGroup.setSource(wasNodeGroupUnit);
		mlNodeInNodeGroup.setTarget(wasNodeUnit);
		mlNodeInNodeGroup.setName(wasNodeUnit.getName() + "In" + wasNodeGroupUnit.getName());
		mlNodeInNodeGroup.setDisplayName(mlNodeInNodeGroup.getName());
		wasNodeGroupUnit.getMemberLinks().add(mlNodeInNodeGroup);

		MemberLink mlNodeGroupInCell = CoreFactory.eINSTANCE.createMemberLink();
		mlNodeGroupInCell.setSource(wasCellUnit);
		mlNodeGroupInCell.setTarget(wasNodeGroupUnit);
		mlNodeGroupInCell.setName(wasNodeGroupUnit.getName() + "In" + wasCellUnit.getName());
		mlNodeGroupInCell.setDisplayName(mlNodeGroupInCell.getName());
		wasCellUnit.getMemberLinks().add(mlNodeGroupInCell);

		MemberLink mlNodeInCell = CoreFactory.eINSTANCE.createMemberLink();
		mlNodeInCell.setSource(wasCellUnit);
		mlNodeInCell.setTarget(wasNodeUnit);
		mlNodeInCell.setName(wasNodeUnit.getName() + "In" + wasCellUnit.getName());
		mlNodeInCell.setDisplayName(mlNodeInCell.getName());
		wasCellUnit.getMemberLinks().add(mlNodeInCell);
	}

	// TODO consider using provider to build the ear from an EAR file
	private void addEARModule() throws IOException {
// <j2eeDeploy:unit.earModule xsi:type="j2eeDeploy:EarModule"
// name="PlantsByWebSphere" initInstallState="not_installed">
		earModuleEdit = J2eeFactory.eINSTANCE.createEarModule();
		earModuleEdit.setName("earModule");
		earModuleEdit.setDisplayName("earModule");
		earModuleEdit.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		moduleTopEdit.getUnits().add(earModuleEdit);

// <core:annotation xsi:type="core:Annotation" context="environment_wtp">
// <core:detail xsi:type="core:StringToStringEntry" key="archive_uri"
// value="C:\runtime-New_configuration\plantsbywebsphere\PlantsByWebSphere.ear"/>
// <core:detail xsi:type="core:StringToStringEntry" key="module_type"
// value="jst.ear"/>
// </core:annotation>
		{
			Annotation ann = CoreFactory.eINSTANCE.createAnnotation();
			ann.setContext("environment_wtp");
			ann.getDetails().put("archive_uri",
					"C:\\runtime-New_configuration\\plantsbywebsphere\\PlantsByWebSphere.ear");
			ann.getDetails().put("module_type", "jst.ear");
			earModuleEdit.getAnnotations().add(ann);
		}

// <core:provides xsi:type="core:ServicesSet">
// <j2eeDeploy:capability.earModule xsi:type="j2eeDeploy:EARModuleCapability"
// name="PlantsByWebSphere_ear" moduleName="PlantsByWebSphere_ear"/>
// </core:provides>
		{
			EARModuleCapability earModuleCapability = J2eeFactory.eINSTANCE.createEARModuleCapability();
			earModuleCapability.setName("PlantsByWebSphere_ear");
			earModuleCapability.setDisplayName("PlantsByWebSphere_ear");
			earModuleCapability.setModuleName("PlantsByWebSphere_ear");
			earModuleEdit.getCapabilities().add(earModuleCapability);
		}

// <core:requirement xsi:type="core:Requirement" name="ejbService_20"
// dmoType="j2eeDeploy:EJBContainer" linkType="hosting">
// <constraint:constraint.version attributeName="containerVersion" value="2.0+"/>
// </core:requirement>
		{
			Requirement ejbReq = ValidatorTestUtils.createHostingRequirement(J2eePackage.eINSTANCE.getEJBContainer(),
					"ejbService_20");
// MK 2/11/2008 - Defect 5328 - Remove usage of Requirement Expressions from the WAS domain.
			ValidatorTestUtils.addVersionConstraint(ejbReq, J2eePackage.Literals.J2EE_CONTAINER__CONTAINER_VERSION, "2.0+");
//			RequirementExpression ejbContainerVersionExp = CoreFactory.eINSTANCE.createRequirementExpression();
//			ejbContainerVersionExp.setName("containerVersion");
//			ejbContainerVersionExp.setInterpreter("GreaterThanEquals");
//			ejbContainerVersionExp.setAttributeName("containerVersion");
//			ejbContainerVersionExp.setUse(RequirementExpressionUsage.REQUIRED_LITERAL);
//			ejbContainerVersionExp.setValue("2.0");
//			ejbReq.getExpressions().add(ejbContainerVersionExp);
			earModuleEdit.getRequirements().add(ejbReq);
		}
// <core:requirement xsi:type="core:Requirement"
// name="plantsby_PlantsByWebSphereDataSource"
// dmoType="j2eeDeploy:J2EEDatasource" linkType="dependency">
// <constraint:constraint.equals name="EqualsConstraint" 
// attributeName="jndiName" value="plantsby/PlantsByWebSphereDataSource"/>
// <core:link xsi:type="core:DependencyLink"
// name="plantsby_PlantsByWebSphereDataSourceToWAS5 Data Source">
// <core:target>/WAS5DB2V5DataSource0#WAS5 Data Source</core:target>
// </core:link>
// </core:requirement>
		{
			dsReqEdit = ValidatorTestUtils.createDependencyRequirement(J2eePackage.eINSTANCE.getJ2EEDatasource(),
					"plantsby_PlantsByWebSphereDataSource");
// MK 2/11/2008 - Defect 5328 - Remove usage of Requirement Expressions from the WAS domain.
			ValidatorTestUtils.addEqualsConstraint(dsReqEdit, J2eePackage.Literals.J2EE_DATASOURCE__JNDI_NAME, "plantsby/PlantsByWebSphereDataSource");
//			RequirementExpression jndiNameExp = CoreFactory.eINSTANCE.createRequirementExpression();
//			jndiNameExp.setName("jndiNameExp");
//			jndiNameExp.setInterpreter("Equals");
//			jndiNameExp.setAttributeName("jndiName");
//			jndiNameExp.setUse(RequirementExpressionUsage.REQUIRED_LITERAL);
//			jndiNameExp.setValue("plantsby/PlantsByWebSphereDataSource");
//			dsReqEdit.getExpressions().add(jndiNameExp);
			earModuleEdit.getRequirements().add(dsReqEdit);
		}
// <core:requirement xsi:type="core:Requirement" name="j2eeService_13"
// dmoType="j2eeDeploy:J2EEContainer" linkType="hosting">
// <constraint:constraint.version attributeName="containerVersion" value="1.3+"/>
// </core:requirement>
		{
			Requirement j2ee13ServiceReq = ValidatorTestUtils.createHostingRequirement(J2eePackage.eINSTANCE
					.getJ2EEContainer(), "j2eeService_13");
// MK 2/11/2008 - Defect 5328 - Remove usage of Requirement Expressions from the WAS domain.
			ValidatorTestUtils.addVersionConstraint(j2ee13ServiceReq, J2eePackage.Literals.J2EE_CONTAINER__CONTAINER_VERSION, "1.3+");
//			RequirementExpression j2ee13ContainerVersionExp = CoreFactory.eINSTANCE.createRequirementExpression();
//			j2ee13ContainerVersionExp.setName("containerVersion");
//			j2ee13ContainerVersionExp.setInterpreter("GreaterThanEquals");
//			j2ee13ContainerVersionExp.setAttributeName("containerVersion");
//			j2ee13ContainerVersionExp.setUse(RequirementExpressionUsage.REQUIRED_LITERAL);
//			j2ee13ContainerVersionExp.setValue("1.3");
//			j2ee13ServiceReq.getExpressions().add(j2ee13ContainerVersionExp);
			earModuleEdit.getRequirements().add(j2ee13ServiceReq);
		}
// <core:requirement xsi:type="core:Requirement" name="j2eeService_12"
// dmoType="j2eeDeploy:J2EEContainer" linkType="hosting">
// <constraint:constraint.version attributeName="containerVersion" value="1.2+"/>
// </core:requirement>
		{
			Requirement j2ee12ServiceReq = ValidatorTestUtils.createHostingRequirement(J2eePackage.eINSTANCE
					.getJ2EEContainer(), "j2eeService_12");
// MK 2/11/2008 - Defect 5328 - Remove usage of Requirement Expressions from the WAS domain.
			ValidatorTestUtils.addVersionConstraint(j2ee12ServiceReq, J2eePackage.Literals.J2EE_CONTAINER__CONTAINER_VERSION, "1.2+");
//			RequirementExpression j2ee12ContainerVersionExp = CoreFactory.eINSTANCE.createRequirementExpression();
//			j2ee12ContainerVersionExp.setName("containerVersion");
//			j2ee12ContainerVersionExp.setInterpreter("GreaterThanEquals");
//			j2ee12ContainerVersionExp.setAttributeName("containerVersion");
//			j2ee12ContainerVersionExp.setUse(RequirementExpressionUsage.REQUIRED_LITERAL);
//			j2ee12ContainerVersionExp.setValue("1.2");
//			j2ee12ServiceReq.getExpressions().add(j2ee12ContainerVersionExp);
			earModuleEdit.getRequirements().add(j2ee12ServiceReq);
		}
// <core:requirement xsi:type="core:Requirement" name="jspService_11"
// dmoType="j2eeDeploy:JSPContainer" linkType="hosting">
// <constraint:constraint.version attributeName="containerVersion" value="1.1+"/>
// </core:requirement>
		{
			Requirement jsp11ServiceReq = ValidatorTestUtils.createHostingRequirement(J2eePackage.eINSTANCE
					.getJSPContainer(), "jspService_11");
// MK 2/11/2008 - Defect 5328 - Remove usage of Requirement Expressions from the WAS domain.
			ValidatorTestUtils.addVersionConstraint(jsp11ServiceReq, J2eePackage.Literals.J2EE_CONTAINER__CONTAINER_VERSION, "1.1+");
//			RequirementExpression jsp11ContainerVersionExp = CoreFactory.eINSTANCE.createRequirementExpression();
//			jsp11ContainerVersionExp.setName("containerVersion");
//			jsp11ContainerVersionExp.setInterpreter("GreaterThanEquals");
//			jsp11ContainerVersionExp.setAttributeName("containerVersion");
//			jsp11ContainerVersionExp.setUse(RequirementExpressionUsage.REQUIRED_LITERAL);
//			jsp11ContainerVersionExp.setValue("1.1");
//			jsp11ServiceReq.getExpressions().add(jsp11ContainerVersionExp);
			earModuleEdit.getRequirements().add(jsp11ServiceReq);
		}
// <core:requirement xsi:type="core:Requirement" name="servletService_22"
// dmoType="j2eeDeploy:ServletContainer" linkType="hosting">
// <constraint:constraint.version attributeName="containerVersion" value="2.2+"/>
// </core:requirement>
		{
			Requirement servlet22ServiceReq = ValidatorTestUtils.createHostingRequirement(J2eePackage.eINSTANCE
					.getServletContainer(), "servletService_22");
// MK 2/11/2008 - Defect 5328 - Remove usage of Requirement Expressions from the WAS domain.
			ValidatorTestUtils.addVersionConstraint(servlet22ServiceReq, J2eePackage.Literals.J2EE_CONTAINER__CONTAINER_VERSION, "2.2+");
//			RequirementExpression servlet22ContainerVersionExp = CoreFactory.eINSTANCE.createRequirementExpression();
//			servlet22ContainerVersionExp.setName("containerVersion");
//			servlet22ContainerVersionExp.setInterpreter("GreaterThanEquals");
//			servlet22ContainerVersionExp.setAttributeName("containerVersion");
//			servlet22ContainerVersionExp.setUse(RequirementExpressionUsage.REQUIRED_LITERAL);
//			servlet22ContainerVersionExp.setValue("2.2");
//			servlet22ServiceReq.getExpressions().add(servlet22ContainerVersionExp);
			earModuleEdit.getRequirements().add(servlet22ServiceReq);
		}
// <core:link.logical xsi:type="core:LogicalLink"
// name="plantsby_PlantsByWebSphereDataSourceLogicalToDB2 Database"
// source="/PlantsByWebSphere#plantsby_PlantsByWebSphereDataSource"
// target="/DB2Database0#DB2 Database"/>
// <core:artifact.file xsi:type="core:FileArtifact">
// <core:fileURI>C:\runtime-New_configuration\plantsbywebsphere\PlantsByWebSphere.ear</core:fileURI>
// </core:artifact.file>
		{
			FileArtifact earFileArtifact = CoreFactory.eINSTANCE.createFileArtifact();
			earFileArtifact.setName("earFileArtifact");
			earFileArtifact.setDisplayName("earFileArtifact");
			String uri = "C:\\runtime-New_configuration\\plantsbywebsphere\\PlantsByWebSphere.ear";
			earFileArtifact.getFileURIs().add(uri);
			earModuleEdit.getArtifacts().add(earFileArtifact);
		}
// </j2eeDeploy:unit.earModule>
	}

	private void implementEARToDBLogicalLink() {
		// ConnectEARToDBLinkImplementation connectEARToDBLinkImplementation =
		// new ConnectEARToDBLinkImplementation();
//		EarOnClusterToDBImplementation connectEARToDBLinkImplementation = new EarOnClusterToDBImplementation();

//		IDeployResolutionContext context = new DeployResolutionContext((IDeployStatus) ds2dbll.getStatus(),
//				deployValidatorService, null);
		IDeployStatus llStatus = null;
		for (DeployStatusIterator sIt = new DeployStatusIterator (dsConstraint); sIt.hasNext();) {
			IDeployStatus s = sIt.next();
			if (s.getProblemType().equals(IWasDb2ProblemType.EARTODB_LOGICAL_LINK_NOT_IMPLEMENTED_BUT_CAN)) {
				llStatus = s;
				break;
			}
		}
		// we know llStatus was found since we got through the asserts earlier
		IDeployResolutionContext context = new DeployResolutionContext(llStatus,
				deployValidatorService, null);

		ConfigureJ2eeModuleAccessToDatatbaseResolution resolution = new ConfigureJ2eeModuleAccessToDatatbaseResolution(
				context, null, Messages.Resolution_Configure_Database_Access,
				dsReq, db2Database, dsConstraint, "db2admin", null);
		IStatus status = resolution.resolve(context.getProgressMonitor());
//		connectEARToDBLinkImplementation.setDbUser("db2admin");
//		IStatus status = connectEARToDBLinkImplementation.implement(context, ds2dbll);
		assert status.isOK() : getString(status);
		int datasourceCount = 0;
		for (Iterator iter = top.findAllCapabilities(); iter.hasNext();) {
			Capability cap = (Capability) iter.next();
			// Should be only one in this topology
			if (cap instanceof WasV5Datasource) {
				((WasV5Datasource) cap).setDatasourceName("SomeDatasourceName");
				++datasourceCount;
			}
		}
		assert (datasourceCount == 1);
	}

	/**
	 * @param multipleTopologies
	 *            true if the units should be created in three topologies:
	 *            application, middleware, OS/hardware.
	 * 
	 * @return a full two-server PlantsBy example topology
	 * @throws Exception
	 */
	public Topology createPlantsByTopologyPreLogicalLinkImplementation(boolean multipleTopologies) throws Exception {
		top = createTopology("PlantsByWebSphereFromTemplates", true);
		addExplicitContractDefaultPublic(top);
		top.setDescription("Plants by WebSphere two system topology from templates");
		if (multipleTopologies) {
			moduleTopEdit = createTopology("PlantsByWebSphereFromTemplates-Modules", true);
			addExplicitContractDefaultPublic(moduleTopEdit);
			infraTopEdit = createTopology("PlantsByWebSphereFromTemplates-Infrastructure", true);
			addExplicitContractDefaultPublic(infraTopEdit);
			infraTopEdit = top;
		} else {
			moduleTopEdit = top;
			infraTopEdit = top;
		}
		addPlantsByWebSphereObjects();
		return top;
	}

	/**
	 * Test creating, saving, and validating in one topology.
	 * 
	 * @throws Exception
	 */
	public void testPlantsLogicalTopologyCreationFromTemplatesOneTopology() throws Exception {
		internalTestPlantsLogicalTopologyCreationFromTemplates(false);
	}

	/**
	 * Test creating, saving, and validating over multiple topologies.
	 * 
	 * @throws Exception
	 */
	public void testPlantsLogicalTopologyCreationFromTemplatesMultipleTopologies() throws Exception {
		internalTestPlantsLogicalTopologyCreationFromTemplates(true);
	}

	/**
	 * Test creating, saving, and validating.
	 * 
	 * @param multipleTopologies
	 *            true if the units should be created in three topologies:
	 *            application, middleware, OS/hardware.
	 * 
	 * @throws Exception
	 */
	protected void internalTestPlantsLogicalTopologyCreationFromTemplates(boolean multipleTopologies) throws Exception {
		deployValidatorService = new DeployValidatorService();
		createPlantsByTopologyPreLogicalLinkImplementation(multipleTopologies);
		save(top);

		// --------------------------------------
		// First validation will have errors; logical link not implemented
		// TODO identify statuses precisely
		long prevTime = System.currentTimeMillis();
		deployValidatorService.validate(top);
		long time = System.currentTimeMillis();
		System.out.println(this.getName() + " : Elapsed milliseconds for validation = " + (time - prevTime));
// dumpMarkers(top);
// assertNoValidationErrors(top);
		System.out.println(ValidatorTestUtils.getTopologyErrorDescription(top));
		HashSet expectedValidatorIDsSet = new HashSet();
		expectedValidatorIDsSet.add(IDeployCoreValidators.DEPENDENCY_LINK_003);
		expectedValidatorIDsSet.add(IWasValidatorID.VALIDAT_WAS_APP_S_MISSING_DATASOURCE_REQ);
//		expectedValidatorIDsSet.add(ILogicalLinkValidatorID.LOGICAL_LINK_VALIDATE);
		expectedValidatorIDsSet.add(IEarToDbLinkValidatorID.DATASOURCE_SATISFACTION_CONSTRAINT_VALIDATION);
		expectedValidatorIDsSet.add(IWasValidatorID.WAS_REFACTOR_WAS_BASE_SYSTEM_TO_ND);
		expectedValidatorIDsSet.add(IWasValidatorID.WAS_J2EE_EAR_CLASSLOADER_POLICY_CONSTRAINT_MISSING_001);
		// MK 4/24/2008 - lineitem 5803
		expectedValidatorIDsSet.add(IDeployCoreValidators.ACC_MATCHING_001);
		assert (ValidatorTestUtils.topologyValidatorIDsInSet(top, expectedValidatorIDsSet)) : dumpStatus(top);
		System.out.println ("-------------------");
		dumpStatus(top);
		assertHasErrorStatus(top, IWASProblemType.MISSING_WAS_DATASOURCE_FOR_APPLICATION);
//		assertHasErrorStatus(top, ILogicalLinkProblemType.LOGICAL_LINK_NOT_IMPLEMENTED_BUT_CAN);
		assertHasErrorStatus(top, IWasDb2ProblemType.EARTODB_LOGICAL_LINK_NOT_IMPLEMENTED_BUT_CAN);
		// MK 4/24/2008 - lineitem 5803
		assertHasErrorStatus(top, ICoreProblemType.CANNOT_MATCH_ACC_TO_NCC);
		assert (ValidatorTestUtils.getTopologyErrorCount(top) == 3) : ValidatorTestUtils.getTopologyErrorCount(top);
		

		// --------------------------------------
		// Implement ear-db logical link
		// Should be zero errors after this
		int unitCountBeforeLL = top.getUnits().size();
		implementEARToDBLogicalLink();
		int unitCountAfterLL = top.getUnits().size();
		assert (unitCountBeforeLL < unitCountAfterLL);

		// But there are not atm:
		save(top);

		prevTime = System.currentTimeMillis();
		deployValidatorService.validate(top);
		time = System.currentTimeMillis();
		System.out.println(this.getName() + " : Elapsed milliseconds for validation = " + (time - prevTime));
		assertNoValidationErrors(top);
		System.out.println(ValidatorTestUtils.getTopologyErrorDescription(top));

		// --------------------------------------
		// save/load tests.
		top = reload(top, true);

		prevTime = System.currentTimeMillis();
		deployValidatorService.validate(top);
		time = System.currentTimeMillis();
		System.out.println(this.getName() + " : Elapsed milliseconds for validation = " + (time - prevTime));
		assertNoValidationErrors(top);
		System.out.println(ValidatorTestUtils.getTopologyErrorDescription(top));

	}
}
