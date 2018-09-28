/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.scenarios;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.resource.Resource;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyUnitDescriptor;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployStatusIterator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCoreValidators;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.database.DDLArtifact;
import com.ibm.ccl.soa.deploy.database.DatabaseFactory;
import com.ibm.ccl.soa.deploy.database.DatabasePackage;
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
import com.ibm.ccl.soa.deploy.operation.IOperationTemplateConstants;
import com.ibm.ccl.soa.deploy.operation.ScriptUnit;
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
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * JUnit test case for Trade 6
 * 
 * <p>
 * 
 * @author Bill Arnold
 */
public class Trade6FromTemplatesTest extends TopologyTestCase {

	// Use instance variables for now
	private Topology top;

	private DB2InstanceUnit db2InstanceUnit;

	private DB2SystemUnit db2SystemUnit;

	private OperatingSystemUnit operatingSystemUnitDB2;

	private ServerUnit serverUnitDB2;

	private UserUnit db2AdminUserUnit;

	private DB2DatabaseUnit db2DatabaseUnit;

	// private SQLModule sqlModule;

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

	private ScriptUnit scriptUnit;

	/** Test case ctor */
	public Trade6FromTemplatesTest() {
		super("Trade6Test");
	}

	/*
	 * @see junit.framework.TestCase#tearDown() Uncomment to stop deletion of
	 *      trade6 topology after test run.
	 */
	protected void tearDown() throws Exception {
	}

	private void fixupAdminstratorPasswords() {
		for (Iterator capIter = top.findAllCapabilities(); capIter.hasNext();) {
			Capability cap = (Capability) capIter.next();
			if (cap instanceof User) {
				User u = (User) cap;
				if (u.getUserId().equals("Administrator")) {
					if (u.getUserPassword() == null) {
						u.setUserPassword("dummyPassword");
					}
				}
			}
		}
	}

	/**
	 * Populates the topology with the Trade6 objects.
	 * 
	 */
	public void addTrade6Objects() {
		createDB2Stack();
		createWASStack();
		addEARModule();
		addScriptUnit();
		fixupAdminstratorPasswords();

		ValidatorTestUtils.hosts(was6ServerUnit, earModule);
		ValidatorTestUtils.hosts(operatingSystemUnitWAS, scriptUnit);

		// <core:link.logical xsi:type="core:LogicalLink"
		// name="Trade6DataSourceLogicalToDB2 Database"
		// source="/Trade6#Trade6DataSource" target="/DB2Database0#DB2
		// Database"/>
		ds2dbll = CoreFactory.eINSTANCE.createConstraintLink();
		ds2dbll.setName("Trade6DataSourceLogicalToDB2 Database");
		ds2dbll.setSource(dsReq);
		ds2dbll.setTarget(db2Database);
		earModule.getConstraintLinks().add(ds2dbll);
		dsConstraint = WasDb2Factory.eINSTANCE.createDatasourceSatisfactionConstraint();
		dsConstraint.setName("Trade6DatasourceSatisfactionConstraint");
		ds2dbll.getConstraints().add(dsConstraint);
	}

	private void createDB2Stack() {
		// NOTE: DCM Provider doesn't do SQLModules

		// sqlModule = DatabaseFactory.eINSTANCE.createSQLModule();
		// sqlModule.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		// sqlModule.setName("Trade6_ddl");
		// sqlModule.setDisplayName("Trade6.ddl");
		// DDLArtifact ddlArtifact =
		// DatabaseFactory.eINSTANCE.createDDLArtifact();
		// ddlArtifact.setName("Trade6_ddl");
		// ddlArtifact.setDisplayName("Trade6.ddl");
		// ddlArtifact.getFileURIs().add("C:\\Trade6.ddl");
		// sqlModule.getArtifacts().add(ddlArtifact);
		// Requirement db2DBReq =
		// ValidatorTestUtils.createHostingRequirement(Db2Package.eINSTANCE.getDB2Database(),
		// "db2DBReq");
		// sqlModule.getRequirements().add(db2DBReq);
		// Annotation ann = CoreFactory.eINSTANCE.createAnnotation();
		// ann.setContext("environment_wtp");
		// ann.getDetails().put("module_type", "ddl");
		// sqlModule.getAnnotations().add(ann);
		// top.getUnits().add(sqlModule);

		// <db2Deploy:unit.db2DatabaseUnit xsi:type="db2Deploy:DB2DatabaseUnit"
		// displayName="PlantsByWebSphereDDL_Install" name="PlantsByWebSphereDDL
		// 2884"
		// initInstallState="not_installed">
		// <core:annotation xsi:type="core:Annotation"
		// context="DCM_SRT_ANNOTATION_TYPE">
		// <core:detail xsi:type="core:StringToStringEntry"
		// key="TPM_OBJECT_NAME"
		// value="/PlantsByWebSphereDDL/PlantsByWebSphereDDL_Install"/>
		// <core:detail xsi:type="core:StringToStringEntry"
		// key="TPM_OBJECT_TYPE"
		// value="class
		// com.thinkdynamics.kanaha.datacentermodel.SoftwareResourceTemplate"/>
		// <core:detail xsi:type="core:StringToStringEntry"
		// key="SRT_DEFINITION_NAME"
		// value="/IBM DB2 UDB - Database"/>
		// </core:annotation>
		// <core:provides xsi:type="core:ServicesSet">
		// <db2Deploy:capability.db2Database xsi:type="db2Deploy:DB2Database"
		// description="" name="providedDb2DatabaseCapability"
		// linkType="any" catalogSp="" codeSet="" db2Version="" dbAlias=""
		// dbName="PLANTSBY" tempSp="" territory="" userSp=""/>
		// </core:provides>
		// <core:requirement xsi:type="core:Requirement"
		// name="requiredDb2Instance"
		// dmoType="db2Deploy:DB2Instance" linkType="hosting">
		// <core:extendedAttribute xsi:type="core:ExtendedAttribute"
		// name="RDBRT:DB2UDB"/>
		// </core:requirement>
		// <core:artifact.file xsi:type="core:FileArtifact"
		// displayName="PlantsByWebSphereDDL_Installable"
		// name="PlantsByWebSphereDDL_Installable">
		// <core:fileURI>/IBM/PlantsByWebSphere/PlantsByWebSphere.ddl</core:fileURI>
		// </core:artifact.file>
		// </db2Deploy:unit.db2DatabaseUnit>

		db2DatabaseUnit = (DB2DatabaseUnit) ResolutionUtils.addFromTemplate(IDb2TemplateConstants.DB2_DATABASE_UNIT,
				top); //$NON-NLS-1$
		assert (db2DatabaseUnit != null);
		db2InstanceUnit = (DB2InstanceUnit) ResolutionUtils.addFromTemplate(IDb2TemplateConstants.DB2_INSTANCE_UNIT,
				top); //$NON-NLS-1$
		assert (db2InstanceUnit != null);
		db2SystemUnit = (DB2SystemUnit) ResolutionUtils.addFromTemplate(IDb2TemplateConstants.DB2_SYSTEM_UNIT, top); //$NON-NLS-1$
		assert (db2SystemUnit != null);
		operatingSystemUnitDB2 = (OperatingSystemUnit) ResolutionUtils.addFromTemplate(
				IOsTemplateConstants.OS_WINDOWS_2000_UNIT, top); //$NON-NLS-1$
		assert (operatingSystemUnitDB2 != null);
		serverUnitDB2 = (ServerUnit) ResolutionUtils.addFromTemplate(IServerTemplateConstants.SERVER_INTEL_X86_UNIT,
				top); //$NON-NLS-1$
		assert (serverUnitDB2 != null);

		ValidatorTestUtils.hosts(serverUnitDB2, operatingSystemUnitDB2);
		ValidatorTestUtils.hosts(operatingSystemUnitDB2, db2SystemUnit);
		ValidatorTestUtils.hosts(db2SystemUnit, db2InstanceUnit);

		db2DatabaseUnit.setName("TradeDB");
		db2DatabaseUnit.setDisplayName("TradeDB_Install");
		db2DatabaseUnit.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);

		ValidatorTestUtils.hosts(db2InstanceUnit, db2DatabaseUnit);

		SQLModule sqlModule = DatabaseFactory.eINSTANCE.createSQLModule();
		sqlModule.setName("Trade6SQLModule");
		top.getUnits().add(sqlModule);
		Requirement requiredDBHosting = ValidatorTestUtils.createHostingRequirement(DatabasePackage.Literals.DATABASE,
				"requiredDBHosting");
		sqlModule.getRequirements().add(requiredDBHosting);

		ValidatorTestUtils.hosts(db2DatabaseUnit, sqlModule);

		db2Database = (DB2Database) ValidatorUtils
				.getCapability(db2DatabaseUnit, Db2Package.eINSTANCE.getDB2Database());
		assert (db2Database != null);
		{ // Fixup db2 database to look like results of DCM drag and drop of
			// installable ddl

			db2Database.setName("providedTrade6Database");
			db2Database.setDisplayName("providedTrade6Database");
			db2Database.setDescription("");
			db2Database.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
			db2Database.setCatalogSp("");
			db2Database.setCodeSet("");
			db2Database.setDb2Version("");
			db2Database.setDbAlias("");
			db2Database.setDbName("TRADE");
			db2Database.setTempSp("");
			db2Database.setTerritory("");
			db2Database.setUserSp("");

			DDLArtifact ddlArtifact = DatabaseFactory.eINSTANCE.createDDLArtifact();
			ddlArtifact.setName("TradeDDL_Installable");
			ddlArtifact.setDisplayName("TradeDDL_Installable");
			ddlArtifact.getFileURIs().add("C:\\tradeinstall\\DB2\\Table.ddl");

			sqlModule.getArtifacts().add(ddlArtifact);

		}

		OperatingSystem operatingSystemDB2 = (OperatingSystem) ValidatorUtils.getCapability(operatingSystemUnitDB2,
				OsPackage.eINSTANCE.getOperatingSystem());
		assert (operatingSystemDB2 != null);
		operatingSystemDB2.setHostname("osDB2");

		DB2Instance db2Instance = (DB2Instance) ValidatorUtils.getCapability(db2InstanceUnit, Db2Package.eINSTANCE
				.getDB2Instance());
		assert (db2Instance != null);
		db2Instance.setHostname(operatingSystemDB2.getHostname());

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
		db2Database.setDbName("TRADE");
	}

	private void fixupDB2OperatingSystem() {
		UnitDescriptor operatingSystemUnitUD = new TopologyUnitDescriptor(this.operatingSystemUnitDB2, top, null);
		if (null == operatingSystemUnitUD.getUnitValue()) {
			operatingSystemUnitUD = null;
		}
		db2AdminUserUnit = GUICreateDB2InstanceAdminUserResolution.createUserOnOSInTopology(operatingSystemUnitUD, top,
				"db2admin", "db2admin", "8.2", null);
	}

	private void createWASStack() {
		// TODO consider changing to the WAS6 Standalone Server mega-template
		was6ServerUnit = (WebsphereAppServerUnit) ResolutionUtils.addFromTemplate(IWasTemplateConstants.WAS_6_APPLICATION_SERVER_UNIT, top); //$NON-NLS-1$
		wasNodeUnit = (WasNodeUnit) ResolutionUtils.addFromTemplate(IWasTemplateConstants.WAS_6_NODE_UNIT, top); //$NON-NLS-1$
		wasNodeGroupUnit = (WasNodeGroupUnit) ResolutionUtils.addFromTemplate(IWasTemplateConstants.WAS_6_NODE_GROUP_UNIT, top); //$NON-NLS-1$
		wasCellUnit = (WasCellUnit) ResolutionUtils.addFromTemplate(IWasTemplateConstants.WAS_6_STANDALONE_CELL_UNIT, top); //$NON-NLS-1$

		wasSystemUnit = (WasSystemUnit) ResolutionUtils.addFromTemplate(IWasTemplateConstants.WAS_6_SYSTEM_UNIT, top); //$NON-NLS-1$	
		operatingSystemUnitWAS = (OperatingSystemUnit) ResolutionUtils.addFromTemplate(IOsTemplateConstants.OS_WINDOWS_2003_UNIT, top); //$NON-NLS-1$
		serverUnitWAS = (ServerUnit) ResolutionUtils.addFromTemplate(IServerTemplateConstants.SERVER_INTEL_X86_UNIT, top); //$NON-NLS-1$	

		ValidatorTestUtils.hosts(serverUnitWAS, operatingSystemUnitWAS);
		ValidatorTestUtils.hosts(operatingSystemUnitWAS, wasSystemUnit);
		ValidatorTestUtils.hosts(wasSystemUnit, wasNodeUnit);
		ValidatorTestUtils.hosts(wasNodeUnit, wasCellUnit);
		ValidatorTestUtils.hosts(wasNodeUnit, was6ServerUnit);

		OperatingSystem operatingSystemWAS = (OperatingSystem) ValidatorUtils.getCapability(operatingSystemUnitWAS,
				OsPackage.eINSTANCE.getOperatingSystem());
		operatingSystemWAS.setHostname("osWAS");

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

		// memberlink changed to hosting link
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

	private void addScriptUnit() {
		scriptUnit = (ScriptUnit) ResolutionUtils.addFromTemplate(IOperationTemplateConstants.SCRIPT_UNIT, top); //$NON-NLS-1$
		scriptUnit.setDisplayName("TradeJMS Script");

		// Add URI to default artifact (from template).
		assert (scriptUnit.getArtifacts().size() >= 1);
		FileArtifact scriptFileArtifact = (FileArtifact) scriptUnit.getArtifacts().get(0);
		scriptFileArtifact.getFileURIs().add("C:\\tradeinstall\\tradejms.jacl");

		// FileArtifact scriptFileArtifact =
		// CoreFactory.eINSTANCE.createFileArtifact();
		// scriptFileArtifact.setName("tradejms_jacl");
		// scriptFileArtifact.setDisplayName("tradeJMS jacl");
		// scriptFileArtifact.getFileURIs().add("C:\\tradeinstall\\tradejms.jacl");
		// scriptUnit.getArtifacts().add(scriptFileArtifact);
	}

	// TODO consider using provider to build the ear from an EAR file
	private void addEARModule() {
		// <j2eeDeploy:unit.earModule xsi:type="j2eeDeploy:EarModule"
		// name="Trade"
		// initInstallState="not_installed">
		earModule = J2eeFactory.eINSTANCE.createEarModule();
		earModule.setName("Trade");
		earModule.setDisplayName("Trade6 earModule");
		earModule.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		top.getUnits().add(earModule);

		// <core:annotation xsi:type="core:Annotation"
		// context="environment_wtp">
		// <core:detail xsi:type="core:StringToStringEntry" key="archive_uri"
		// value="C:\runtime-New_configuration\trade6\trade.ear"/>
		// <core:detail xsi:type="core:StringToStringEntry" key="module_type"
		// value="jst.ear"/>
		// </core:annotation>

		{
			Annotation ann = CoreFactory.eINSTANCE.createAnnotation();
			ann.setContext("environment_wtp");
			ann.getDetails().put("archive_uri", "C:\\runtime-New_configuration\\trade6\\trade.ear");
			ann.getDetails().put("module_type", "jst.ear");
			earModule.getAnnotations().add(ann);
		}
		// <core:provides xsi:type="core:ServicesSet">
		// <j2eeDeploy:capability.earModule
		// xsi:type="j2eeDeploy:EARModuleCapability"
		// name="trade_ear" moduleName="trade_ear"/>
		// </core:provides>
		{
			EARModuleCapability earModuleCapability = J2eeFactory.eINSTANCE.createEARModuleCapability();
			earModuleCapability.setName("trade_ear");
			earModuleCapability.setDisplayName("trade_ear");
			earModuleCapability.setModuleName("trade_ear");
			earModule.getCapabilities().add(earModuleCapability);
		}

		// <core:requirement xsi:type="core:Requirement" name="ejbService_21"
		// dmoType="j2eeDeploy:EJBContainer" linkType="hosting">
		// <constraint:constraint.version attributeName="containerVersion"
		// value="2.1+"/>
		// </core:requirement>

		{
			Requirement ejbReq = ValidatorTestUtils.createHostingRequirement(J2eePackage.eINSTANCE.getEJBContainer(),
					"ejbService_21");

			// MK 2/11/2008 - Defect 5328 - Remove usage of Requirement
			// Expressions from the WAS domain.
			ValidatorTestUtils.addVersionConstraint(ejbReq, J2eePackage.Literals.J2EE_CONTAINER__CONTAINER_VERSION,
					"2.1+");
			// RequirementExpression ejbContainerVersionExp =
			// CoreFactory.eINSTANCE
			// .createRequirementExpression();
			// ejbContainerVersionExp.setName("containerVersion");
			// ejbContainerVersionExp.setInterpreter("GreaterThanEquals");
			// ejbContainerVersionExp.setAttributeName("containerVersion");
			// ejbContainerVersionExp
			// .setUse(RequirementExpressionUsage.REQUIRED_LITERAL);
			// ejbContainerVersionExp.setValue("2.1");
			// ejbReq.getExpressions().add(ejbContainerVersionExp);
			earModule.getRequirements().add(ejbReq);
		}
		// <core:requirement xsi:type="core:Requirement"
		// name="jdbc_TradeDataSource"
		// dmoType="j2eeDeploy:J2EEDatasource" linkType="dependency">
		// <constraint:constraint.equals attributeName="jndiName"
		// value="jdbc/TradeDataSource"/>
		// </core:requirement>

		{
			dsReq = ValidatorTestUtils.createDependencyRequirement(J2eePackage.eINSTANCE.getJ2EEDatasource(),
					"TradeDataSource");
			// MK 2/11/2008 - Defect 5328 - Remove usage of Requirement
			// Expressions from the WAS domain.
			ValidatorTestUtils.addEqualsConstraint(dsReq, J2eePackage.Literals.J2EE_DATASOURCE__JNDI_NAME,
					"jdbc/TradeDataSource");
			// RequirementExpression jndiNameExp = CoreFactory.eINSTANCE
			// .createRequirementExpression();
			// jndiNameExp.setName("jndiNameExp");
			// jndiNameExp.setInterpreter("Equals");
			// jndiNameExp.setAttributeName("jndiName");
			// jndiNameExp.setUse(RequirementExpressionUsage.REQUIRED_LITERAL);
			// jndiNameExp.setValue("jdbc/TradeDataSource");
			// dsReq.getExpressions().add(jndiNameExp);
			earModule.getRequirements().add(dsReq);
		}
		// <core:requirement xsi:type="core:Requirement" name="j2eeService_14"
		// dmoType="j2eeDeploy:J2EEContainer" linkType="hosting">
		// <constraint:constraint.version attributeName="containerVersion"
		// value="1.4+"/>
		// </core:requirement>

		{
			Requirement j2ee14ServiceReq = ValidatorTestUtils.createHostingRequirement(J2eePackage.eINSTANCE
					.getJ2EEContainer(), "j2eeService_14");
			// MK 2/11/2008 - Defect 5328 - Remove usage of Requirement
			// Expressions from the WAS domain.
			ValidatorTestUtils.addVersionConstraint(j2ee14ServiceReq,
					J2eePackage.Literals.J2EE_CONTAINER__CONTAINER_VERSION, "1.4+");
			// RequirementExpression j2ee14ContainerVersionExp =
			// CoreFactory.eINSTANCE
			// .createRequirementExpression();
			// j2ee14ContainerVersionExp.setName("containerVersion");
			// j2ee14ContainerVersionExp.setInterpreter("GreaterThanEquals");
			// j2ee14ContainerVersionExp.setAttributeName("containerVersion");
			// j2ee14ContainerVersionExp
			// .setUse(RequirementExpressionUsage.REQUIRED_LITERAL);
			// j2ee14ContainerVersionExp.setValue("1.4");
			// j2ee14ServiceReq.getExpressions().add(j2ee14ContainerVersionExp);
			earModule.getRequirements().add(j2ee14ServiceReq);
		}
		// <core:requirement xsi:type="core:Requirement" name="jspService_20"
		// dmoType="j2eeDeploy:JSPContainer" linkType="hosting">
		// <constraint:constraint.version attributeName="containerVersion"
		// value="2.0+"/>
		// </core:requirement>

		{
			Requirement jsp20ServiceReq = ValidatorTestUtils.createHostingRequirement(J2eePackage.eINSTANCE
					.getJSPContainer(), "jspService_20");
			// MK 2/11/2008 - Defect 5328 - Remove usage of Requirement
			// Expressions from the WAS domain.
			ValidatorTestUtils.addVersionConstraint(jsp20ServiceReq,
					J2eePackage.Literals.J2EE_CONTAINER__CONTAINER_VERSION, "2.0+");
			// RequirementExpression jsp20ContainerVersionExp =
			// CoreFactory.eINSTANCE
			// .createRequirementExpression();
			// jsp20ContainerVersionExp.setName("containerVersion");
			// jsp20ContainerVersionExp.setInterpreter("GreaterThanEquals");
			// jsp20ContainerVersionExp.setAttributeName("containerVersion");
			// jsp20ContainerVersionExp
			// .setUse(RequirementExpressionUsage.REQUIRED_LITERAL);
			// jsp20ContainerVersionExp.setValue("2.0");
			// jsp20ServiceReq.getExpressions().add(jsp20ContainerVersionExp);
			earModule.getRequirements().add(jsp20ServiceReq);
		}
		// <core:requirement xsi:type="core:Requirement"
		// name="servletService_24"
		// dmoType="j2eeDeploy:ServletContainer" linkType="hosting">
		// <constraint:constraint.version attributeName="containerVersion"
		// value="2.4+"/>
		// </core:requirement>

		{
			Requirement servlet24ServiceReq = ValidatorTestUtils.createHostingRequirement(J2eePackage.eINSTANCE
					.getServletContainer(), "servletService_24");
			// MK 2/11/2008 - Defect 5328 - Remove usage of Requirement
			// Expressions from the WAS domain.
			ValidatorTestUtils.addVersionConstraint(servlet24ServiceReq,
					J2eePackage.Literals.J2EE_CONTAINER__CONTAINER_VERSION, "2.4+");
			// RequirementExpression servlet24ContainerVersionExp =
			// CoreFactory.eINSTANCE
			// .createRequirementExpression();
			// servlet24ContainerVersionExp.setName("containerVersion");
			// servlet24ContainerVersionExp.setInterpreter("GreaterThanEquals");
			// servlet24ContainerVersionExp.setAttributeName("containerVersion");
			// servlet24ContainerVersionExp
			// .setUse(RequirementExpressionUsage.REQUIRED_LITERAL);
			// servlet24ContainerVersionExp.setValue("2.4");
			// servlet24ServiceReq.getExpressions().add(
			// servlet24ContainerVersionExp);
			earModule.getRequirements().add(servlet24ServiceReq);
		}
		// <core:artifact.file xsi:type="core:FileArtifact">
		// <core:fileURI>C:\runtime-New_configuration\trade6\trade.ear</core:fileURI>
		// </core:artifact.file>
		{
			FileArtifact earFileArtifact = CoreFactory.eINSTANCE.createFileArtifact();
			earFileArtifact.setName("trade6EARFileArtifact");
			earFileArtifact.setDisplayName("trade6 earFileArtifact");
			String uri = "C:\\runtime-New_configuration\\trade6\\trade.ear";
			earFileArtifact.getFileURIs().add(uri);
			earModule.getArtifacts().add(earFileArtifact);
		}
		// </j2eeDeploy:unit.earModule>

	}

	private void implementEARToDBLogicalLink() {
		// ConnectEARToDBLinkImplementation connectEARToDBLinkImplementation =
		// new ConnectEARToDBLinkImplementation();
		// EarOnClusterToDBImplementation connectEARToDBLinkImplementation = new
		// EarOnClusterToDBImplementation();

		IDeployStatus llStatus = null;
		for (DeployStatusIterator sIt = new DeployStatusIterator(dsConstraint); sIt.hasNext();) {
			IDeployStatus s = sIt.next();
			if (s.getProblemType().equals(IWasDb2ProblemType.EARTODB_LOGICAL_LINK_NOT_IMPLEMENTED_BUT_CAN)) {
				llStatus = s;
				break;
			}
		}
		// we know llStatus was found since we got through the asserts earlier
		IDeployResolutionContext context = new DeployResolutionContext(llStatus, deployValidatorService, null);
		ConfigureJ2eeModuleAccessToDatatbaseResolution resolution = new ConfigureJ2eeModuleAccessToDatatbaseResolution(
				context, null, Messages.Resolution_Configure_Database_Access, dsReq, db2Database, dsConstraint,
				"db2admin", null);
		IStatus status = resolution.resolve(context.getProgressMonitor());
		// connectEARToDBLinkImplementation.setDbUser("db2admin");
		// connectEARToDBLinkImplementation.implement(context, ds2dbll);
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
	 * @return a full Trade6 example topology
	 * @throws Exception
	 */
	public Topology createTrade6ByTopologyPreLogicalLinkImplementation() throws Exception {
		top = createTopology("Trade6FromTemplates");
		top.setDescription("Trade6 topology from templates");
		addTrade6Objects();
		return top;
	}

	/**
	 * Test creating, saving, and validating.
	 * 
	 * @throws Exception
	 */
	public void testTrade6LogicalTopologyCreationFromTemplates() throws Exception {
		deployValidatorService = new DeployValidatorService();
		createTrade6ByTopologyPreLogicalLinkImplementation();

		Resource res = top.getEObject().eResource();
		res.save(null);

		// --------------------------------------
		// First validation will have errors; logical link not implemented
		// TODO identify statuses precisely
		long prevTime = System.currentTimeMillis();
		deployValidatorService.validate(top);
		long time = System.currentTimeMillis();
		System.out.println(this.getName() + " : Elapsed milliseconds for validation = " + (time - prevTime));
		System.out.println(ValidatorTestUtils.getTopologyErrorDescription(top));
		Set<String> expectedValidatorIDsSet = new HashSet<String>();
		expectedValidatorIDsSet.add(IDeployCoreValidators.DEPENDENCY_LINK_003);
		expectedValidatorIDsSet.add(IWasValidatorID.VALIDAT_WAS_APP_S_MISSING_DATASOURCE_REQ);
		expectedValidatorIDsSet.add(IEarToDbLinkValidatorID.DATASOURCE_SATISFACTION_CONSTRAINT_VALIDATION);
		expectedValidatorIDsSet.add(IWasValidatorID.WAS_REFACTOR_WAS_BASE_SYSTEM_TO_ND);
		expectedValidatorIDsSet.add(IWasValidatorID.WAS_J2EE_EAR_CLASSLOADER_POLICY_CONSTRAINT_MISSING_001);
		expectedValidatorIDsSet.add(IDeployCoreValidators.ACC_MATCHING_001);
		assert (ValidatorTestUtils.topologyValidatorIDsInSet(top, expectedValidatorIDsSet)) : dumpStatus(top);
		assert (ValidatorTestUtils.getTopologyErrorCount(top) == 4) : ValidatorTestUtils.getTopologyErrorCount(top);

		// --------------------------------------
		// Implement ear-db logical link
		// Should be zero errors after this
		implementEARToDBLogicalLink();

		// But there are not atm:

		res = top.getEObject().eResource();
		res.save(null);

		prevTime = System.currentTimeMillis();
		deployValidatorService.validate(top);
		time = System.currentTimeMillis();
		System.out.println(this.getName() + " : Elapsed milliseconds for validation = " + (time - prevTime));
		assertNoValidationErrors(top);
		System.out.println(ValidatorTestUtils.getTopologyErrorDescription(top));

		// --------------------------------------
		// save/load tests.
		res = top.getEObject().eResource();
		res.save(null);

		res.unload();

		res.load(Collections.EMPTY_MAP);
		DeployCoreRoot deployCoreRoot = (DeployCoreRoot) res.getContents().get(0);
		Topology topology = deployCoreRoot.getTopology();
		assertNotNull(topology);

		prevTime = System.currentTimeMillis();
		deployValidatorService.validate(top);
		time = System.currentTimeMillis();
		System.out.println(this.getName() + " : Elapsed milliseconds for validation = " + (time - prevTime));
		assertNoValidationErrors(topology);
		System.out.println(ValidatorTestUtils.getTopologyErrorDescription(top));

	}
}
