/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.test;

import java.math.BigInteger;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.test.validator.utils.ValidatorTestUtils;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.ldap.LdapServer;
import com.ibm.ccl.soa.deploy.ldap.LdapFactory;
import com.ibm.ccl.soa.deploy.ldap.LdapLdif;
import com.ibm.ccl.soa.deploy.ldap.LdapLdifUnit;
import com.ibm.ccl.soa.deploy.ldap.LdapPackage;
import com.ibm.ccl.soa.deploy.ldap.LdapSuffix;
import com.ibm.ccl.soa.deploy.ldap.LdapSuffixUnit;
import com.ibm.ccl.soa.deploy.ldap.LdapServerUnit;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.was.LDAPDirectoryType;
import com.ibm.ccl.soa.deploy.was.WasAdvancedLdapConfiguration;
import com.ibm.ccl.soa.deploy.was.WasFactory;
import com.ibm.ccl.soa.deploy.was.WasLdapConfiguration;
import com.ibm.ccl.soa.deploy.was.WasLdapConfigurationUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSecurity;
import com.ibm.ccl.soa.deploy.was.WasUserRegistryTypes;

/**
 * @since 3.2
 * @see PlantsByWebsphereTest
 */
public class PlantsByWebsphereTest_LDAPOnly extends PlantsByWebsphereTest {

	private static final String PROJECT_NAME = "PlantsByWASTest";

	private IProject project;

	protected Requirement requiredLdapDb2Database;

	protected Requirement requiredLdapOs;

	protected WasSecurity providedWasSecurity;

	protected LdapSuffix providedLdapSuffix;

	protected LdapServerUnit ldapServerUnit;

	protected WasLdapConfigurationUnit ldapConfigUnit;

	protected DependencyLink wasSecurityLink;

	protected void setUp() throws Exception {
		project = ResourcesPlugin.getWorkspace().getRoot().getProject(
				PROJECT_NAME);
		project.create(new NullProgressMonitor());
		project.open(new NullProgressMonitor());
	}

	/**
	 * Creates the LDAP server objects in the topology.
	 * 
	 * @param top
	 *            the topology where the objects will be added.
	 */
	public void populateLdapTopology(Topology top) {

		// //////////////////////////////////////////////////////////////////////////
		//
		// LDAP configuration unit & services (page 5)
		//
		// //////////////////////////////////////////////////////////////////////////

		//
		// Provided advanced LDAP service
		//
		WasAdvancedLdapConfiguration providedAdvLdap = WasFactory.eINSTANCE
				.createWasAdvancedLdapConfiguration();
		providedAdvLdap.setDisplayName("AdvancedLdapConfiguration");
		providedAdvLdap.setName("providedAdvancedLdapConfigurationService");
		providedAdvLdap.setUserFilter("(&(cn=%v)(objectclass=person))");
		providedAdvLdap.setGroupFilter("(&(cn=%v)(objectclass=groupOfNames))");
		providedAdvLdap.setUserIdMap("*:cn");
		providedAdvLdap.setGroupIdMap("*:cn");
		providedAdvLdap.setGroupMemberIdMap("groupOfNames:member");

		//
		// Provided LDAP service
		//
		WasLdapConfiguration providedLdapConfiguration = WasFactory.eINSTANCE
				.createWasLdapConfiguration();
		providedLdapConfiguration.setDisplayName("LdapConfiguration");
		providedLdapConfiguration.setName("providedWasLdapConfiguration");
		providedLdapConfiguration.setServerId("wasadmin");
		providedLdapConfiguration.setServerPassword("wasadm1n");
		providedLdapConfiguration.setType(LDAPDirectoryType.CUSTOM_LITERAL);
		providedLdapConfiguration.setLdapHostname("rf12.watson.ibm.com");
		providedLdapConfiguration.setLdapPort(BigInteger.valueOf(389));
		providedLdapConfiguration.setBaseDN("dc=plants");
		providedLdapConfiguration.setBindDN("dn=cn=plantsldap,dc=plants");
		providedLdapConfiguration.setBindPassword("plantspwd");
		providedLdapConfiguration.setIgnoreCase(true);

		//
		// Required WAS security
		//
		Requirement requiredWasSecurity = ValidatorTestUtils
				.createDependencyRequirement(WasPackage.Literals.WAS_SECURITY,
						"requiredWasSecurity");
		ValidatorTestUtils.addEqualsExpression(requiredWasSecurity,
				WasPackage.Literals.WAS_SECURITY__GLOBAL_SECURITY_ENABLED,
				Boolean.TRUE);
		ValidatorTestUtils.addEqualsExpression(requiredWasSecurity,
				WasPackage.Literals.WAS_SECURITY__ACTIVE_USER_REGISTRY, WasUserRegistryTypes.LDAP_LITERAL);
		ValidatorTestUtils.addEqualsExpression(requiredWasSecurity,
				WasPackage.Literals.WAS_SECURITY__ENFORCE_JAVA2_SECURITY,
				Boolean.TRUE);

		//
		// Consumed LDAP suffix service
		//
		Requirement requiredLdapSuffix = ValidatorTestUtils
				.createDependencyRequirement(LdapPackage.Literals.LDAP_SUFFIX,
						"requiredLdapSuffix");
		ValidatorTestUtils.addEqualsExpression(requiredLdapSuffix,
				LdapPackage.Literals.LDAP_SUFFIX__SUFFIX_DN, "dc=plants");

		//
		// LDAP configuration unit
		// - provides: LDAP service, advanced LDAP service
		// - requires: WAS security, LDAP suffix
		//
		ldapConfigUnit = WasFactory.eINSTANCE.createWasLdapConfigurationUnit();
		ldapConfigUnit.setName("wasLdapConfigurationUnit");
		top.getUnits().add(ldapConfigUnit);

		ldapConfigUnit.getOnlyDependencyCapabilities().add(
				providedLdapConfiguration);
		ldapConfigUnit.getOnlyDependencyCapabilities().add(providedAdvLdap);
		ldapConfigUnit.getRequirements().add(requiredWasSecurity);
		ldapConfigUnit.getRequirements().add(requiredLdapSuffix);

		//
		// Provided WAS security service
		//
		providedWasSecurity = WasFactory.eINSTANCE.createWasSecurity();
		providedWasSecurity.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
		providedWasSecurity.setName("providedWasSecurity");
		providedWasSecurity.setGlobalSecurityEnabled(true);
		providedWasSecurity.setEnforceJava2Security(true);
		providedWasSecurity.setActiveAuthMechanism("swam");
		providedWasSecurity.setActiveUserRegistry(WasUserRegistryTypes.LDAP_LITERAL);

		//
		// dependency link WAS LDAP configuration suffix to LDAP server suffix
		//
		wasSecurityLink = CoreFactory.eINSTANCE.createDependencyLink();
		wasSecurityLink.setName("wasSecurityLink");
		wasSecurityLink.setSource(requiredWasSecurity);
		requiredWasSecurity.setLink(wasSecurityLink);

		// //////////////////////////////////////////////////////////////////////////
		//
		// LDAP server unit & services (page 7)
		//
		// //////////////////////////////////////////////////////////////////////////

		// **************************** Suffix *******************************

		//
		// Provided LDAP suffix service
		//
		providedLdapSuffix = LdapFactory.eINSTANCE.createLdapSuffix();
		providedLdapSuffix.setName("providedLdapSuffix");
		providedLdapSuffix.setSuffixDN("dc=plants");

		//
		// Consumed LDAP service
		//
		Requirement requiredLdapForSuffix = ValidatorTestUtils
				.createHostingRequirement(LdapPackage.Literals.LDAP_SERVER,
						"consumedLdapForSuffix");

		//
		// Suffix artifact
		//
		FileArtifact ldapSuffixArtifact = CoreFactory.eINSTANCE
				.createFileArtifact();
		ldapSuffixArtifact.setName("ldapSuffixArtifact");
		ldapSuffixArtifact.getFileURIs().add("PlantsByWebSphere-suffix.ldif");

		//
		// LDAP suffix unit
		// - provides LDAP suffix service
		// - requires LDAP service
		// - contains suffix artifact
		//
		LdapSuffixUnit ldapSuffixUnit = LdapFactory.eINSTANCE
				.createLdapSuffixUnit();
		ldapSuffixUnit.setName("ldapSuffixUnit");
		top.getUnits().add(ldapSuffixUnit);

		ldapSuffixUnit.getOnlyDependencyCapabilities().add(providedLdapSuffix);
		ldapSuffixUnit.getRequirements().add(requiredLdapForSuffix);

		ldapSuffixUnit.getArtifacts().add(ldapSuffixArtifact);

		// **************************** LDIF *******************************

		//
		// Provided LDIF service
		//
		LdapLdif providedLdapLdif = LdapFactory.eINSTANCE.createLdapLdif();
		providedLdapLdif.setName("providedLdapLdif");
		providedLdapLdif.setSubtreeDn("cn=foo");

		//
		// Provided LDIF service
		//
		Requirement requiredLdapForLdif = ValidatorTestUtils
				.createHostingRequirement(LdapPackage.Literals.LDAP_SERVER,
						"requiredLdapForLdif");

		//
		// LDIF artifact
		//
		FileArtifact ldapLdifArtifact = CoreFactory.eINSTANCE
				.createFileArtifact();
		ldapLdifArtifact.setName("ldapLdifArtifact");
		ldapLdifArtifact.getFileURIs().add("PlantsByWebSphere-IBMDS.ldif");

		//
		// LDIF unit
		// - produces LDIF service
		// - requires LDAP service
		// - contains LDIF artifact
		//
		LdapLdifUnit ldapLdifUnit = LdapFactory.eINSTANCE.createLdapLdifUnit();
		ldapLdifUnit.setName("ldapLdifUnit");
		top.getUnits().add(ldapLdifUnit);

		ldapLdifUnit.getOnlyDependencyCapabilities().add(providedLdapLdif);
		ldapLdifUnit.getRequirements().add(requiredLdapForLdif);

		ldapLdifUnit.getArtifacts().add(ldapLdifArtifact);

		// ************************* LDAP Server ****************************

		//
		// Provided LDAP service
		//
		LdapServer providedLdap = LdapFactory.eINSTANCE.createLdapServer();
		providedLdap.setName("providedLdap");
		providedLdap.setAdministratorDN("cn=root");
		providedLdap.setAdministratorPassword("ldap1"); 
		// TODO Should this be changed to match other ports?
		// providedLdap.setPort(BigInteger.valueOf(389));

		// 
		// Requires LDAP database
		//

		requiredLdapDb2Database = ValidatorTestUtils
				.createDependencyRequirement(Db2Package.Literals.DB2_DATABASE,
						"requiredLdapDb2Database");
		ValidatorTestUtils.addEqualsExpression(requiredLdapDb2Database,
				Db2Package.Literals.DB2_DATABASE__DB_NAME, "LDAP");

		//
		// Requires Windows OS
		//
		requiredLdapOs = ValidatorTestUtils.createHostingRequirement(
				OsPackage.Literals.OPERATING_SYSTEM, "requiredLdapOs");

		//
		// LDAP unit
		// - produces LDAP service
		// - requires DB2 database service, Windows OS service
		//
		/* LdapServerUnit */ldapServerUnit = LdapFactory.eINSTANCE.createLdapServerUnit();
		ldapServerUnit.setName("ldapServerUnit");
		top.getUnits().add(ldapServerUnit);

		ldapServerUnit.getHostingOrAnyCapabilities().add(providedLdap);
		ldapServerUnit.getRequirements().add(requiredLdapDb2Database);
		ldapServerUnit.getRequirements().add(requiredLdapOs);

		// **************************** LDIF *******************************

		//
		// dependency link WAS LDAP configuration suffix to LDAP server suffix
		//
		DependencyLink suffixLink = CoreFactory.eINSTANCE
				.createDependencyLink();
		suffixLink.setName("suffixLink");
		suffixLink.setTarget(providedLdapSuffix);
		suffixLink.setSource(requiredLdapSuffix);
		requiredLdapSuffix.setLink(suffixLink);

		//
		// hosting link LDIF to LdapServer
		//
		ValidatorTestUtils.hosts(ldapServerUnit, ldapLdifUnit);

		//
		// hosting link suffix to LdapServer service consumption
		//
		ValidatorTestUtils.hosts(ldapServerUnit, ldapSuffixUnit);
	}

	/**
	 * @return ldap topology
	 */
	public Topology createLdapTopology() {
		Topology top = CoreFactory.eINSTANCE.createTopology();
		top.setName("PlantsByWebsphere Topology");

		return top;
	}
}
