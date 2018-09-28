/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator.matcher;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatchFilter;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.WebModule;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasEditionEnum;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum;
import com.ibm.ccl.soa.deploy.was.WasSystem;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.validator.resolution.WasResolutionUtils;

/**
 * Class to filter (limit) {@link HostingLink} matches in the WAS domain.
 */
public class WasHostingLinkMatcherFilter extends LinkMatchFilter {

	// short hand for reuse and readability
	private static final EClass cellUnitType = WasPackage.Literals.WAS_CELL_UNIT;
	private static final EClass systemUnitType = WasPackage.Literals.WAS_SYSTEM_UNIT;
	private static final EClass nodeUnitType = WasPackage.Literals.WAS_NODE_UNIT;
	private static final EClass clusterUnitType = WasPackage.Literals.WAS_CLUSTER_UNIT;
	private static final EClass serverUnitType = WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT;
	private static final EClass earModuleType = J2eePackage.Literals.EAR_MODULE;
	private static final EClass ejbModuleType = J2eePackage.Literals.EJB_MODULE;
	private static final EClass webModuleType = J2eePackage.Literals.WEB_MODULE;
	private static final EClass sharedLibraryType = WasPackage.Literals.SHARED_LIBRARY_ENTRY;

	@Override
	public IStatus canCreateLink(Unit host, Unit hostee) {
		assert null != host;
		assert null != hostee;

		EClass hosteeType = hostee.getEObject().eClass();
		EClass hostType = host.getEObject().eClass();

		if (cellUnitType.isSuperTypeOf(hosteeType)) {
//		if (hostee instanceof WasCellUnit) {
			if (!(host instanceof WasNodeUnit)) {
				return DeployMatcherStatus.HOSTING_LINK_NOT_POSSIBLE;
			}

			WasNodeUnit wasNodeUnit = (WasNodeUnit) host;
			List reqL = wasNodeUnit.getRequirements();
			for (int i = 0; i < reqL.size(); i++) {
				if (((Requirement) reqL.get(i)).getDmoEType().equals(
						WasPackage.eINSTANCE.getWasCellUnit())) {
					List groupList = TopologyDiscovererService.INSTANCE.getGroups(wasNodeUnit,
							(Requirement) reqL.get(i), host.getTopology());
					if (groupList != null && groupList.size() > 0) {
						UnitDescriptor wasCellUnitDesc = (UnitDescriptor) groupList.get(0);
						WasCellUnit wasCellunit = (WasCellUnit) wasCellUnitDesc.getUnitValue();
						// a node can host the cell only if the node isn't in a cell or if the node is in the (to be) hosted cell
						if (wasCellunit != null && wasCellunit != hostee) {
							return DeployMatcherStatus.HOSTING_LINK_NOT_POSSIBLE;
						}
					}
				}
			}
		}

		//if host is Base System
		if (systemUnitType.isSuperTypeOf(hostType)
//		if (host instanceof WasSystemUnit
				&& ((WasSystem) ValidatorUtils.getCapability(host, WasPackage.Literals.WAS_SYSTEM))
						.getWasEdition().getLiteral().equals(WasEditionEnum.BASE_LITERAL.getLiteral())) {

			if (nodeUnitType.isSuperTypeOf(hosteeType)) {
//			if (hostee instanceof WasNodeUnit) {
				//Dmgr can not be hosted on a base system
				if (((WasNode) ValidatorUtils.getCapability(hostee, WasPackage.Literals.WAS_NODE))
						.getProfileType().getLiteral().equals(
								WasProfileTypeEnum.DMGR_LITERAL.getLiteral())) {
					return DeployMatcherStatus.HOSTING_LINK_NOT_POSSIBLE;
				}
				//Node contained in a distributed cell can 
				List hostedCellsList = ValidatorUtils.getHosted(hostee,
						WasPackage.Literals.WAS_CELL_UNIT);
				if (hostedCellsList.size() == 1
						&& ((WasCell) ValidatorUtils.getCapability((WasCellUnit) hostedCellsList.get(0),
								WasPackage.Literals.WAS_CELL)).isIsDistributed()) {
					return DeployMatcherStatus.HOSTING_LINK_NOT_POSSIBLE;
				}
			}
		}

		// if host is a was app server or a cluster
		if (serverUnitType.isSuperTypeOf(hostType) || clusterUnitType.isSuperTypeOf(hostType)) {
			// reject the hosting link if 
			// {@link WasLinkDescriptor#postHostingLinkCreate(Unit, Unit, HostingLink)} 
			// cannot complete because of contract problems

			if (earModuleType.isSuperTypeOf(hosteeType)) {
				// must be able to:
				// add optional dependency requirement for SharedLibraryEntry
				// if not already present AND if there is not already an unlinked one
				// add optional dependency requirement for SharedLibraryEntry to each contained WebModule
				if (!WasResolutionUtils.canBeDependencyLinkSource(hostee, sharedLibraryType, true)) {
					return DeployMatcherStatus.HOSTING_LINK_NOT_POSSIBLE;
				}
				// add optional dependency requirement for SharedLibraryEntry to each contained WebModule
				List<Unit> containedModules = ValidatorUtils.getMembers(hostee);
				for (Unit module : containedModules) {
					if (module instanceof WebModule) {
						if (!WasResolutionUtils
								.canBeDependencyLinkSource(module, sharedLibraryType, true)) {
							return DeployMatcherStatus.HOSTING_LINK_NOT_POSSIBLE;
						}
					}
				}
			}

			if (webModuleType.isSuperTypeOf(hosteeType)) {
				// must be able to:
				// add optional dependency requirement for SharedLibraryEntry
				// if not already present AND if there is not already an unlinked one
				if (!WasResolutionUtils.canBeDependencyLinkSource(hostee, sharedLibraryType, true)) {
					return DeployMatcherStatus.HOSTING_LINK_NOT_POSSIBLE;
				}
			}

			//We want to avoid allowing Utility modules hosted directly.
			if (J2eePackage.Literals.JAR_MODULE.isSuperTypeOf(hosteeType)) {
				return DeployCorePlugin
						.createErrorStatus(
								0,
								WasDomainMessages.WasHostingLinkMatcherFilter_WebSphere_Application_Server_cannot_,
								null);
			} else if (J2eePackage.Literals.EJB_MODULE.isSuperTypeOf(hosteeType)) {
				return DeployCorePlugin
						.createErrorStatus(
								0,
								WasDomainMessages.WasHostingLinkMatcherFilter_WebSphere_Application_Server_cannot__2,
								null);
			}

			// Also must be able to: 
			// add jndi binding constraints - optional and checked in implementation
			// add security role constraints - optional and checked in implementation
			// add start weight constraints - optional and checked in implementation
			// add classloader policy constraints - optional and checked in implementation
		}

		return DeployMatcherStatus.MATCH_NOT_REJECTED;
	}

}
