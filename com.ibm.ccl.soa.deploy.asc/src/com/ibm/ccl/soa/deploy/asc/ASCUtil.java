/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.asc;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.asc.exception.ASCException;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.util.CapabilityUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.Port;
import com.ibm.ccl.soa.deploy.os.PortConfigUnit;
import com.ibm.ccl.soa.deploy.os.PortConsumer;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasCluster;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasDeploymentManager;
import com.ibm.ccl.soa.deploy.was.WasDeploymentManagerUnit;
import com.ibm.ccl.soa.deploy.was.WasEditionEnum;
import com.ibm.ccl.soa.deploy.was.WasEndpointListenerConfiguration;
import com.ibm.ccl.soa.deploy.was.WasEndpointListenerUnit;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeGroup;
import com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum;
import com.ibm.ccl.soa.deploy.was.WasSIBusUnit;
import com.ibm.ccl.soa.deploy.was.WasServer;
import com.ibm.ccl.soa.deploy.was.WasSibDestinationUnit;
import com.ibm.ccl.soa.deploy.was.WasSubstitutionVariable;
import com.ibm.ccl.soa.deploy.was.WasSystem;
import com.ibm.ccl.soa.deploy.was.WasSystemUnit;
import com.ibm.ccl.soa.deploy.was.WasV5Datasource;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;

/**
 * Utility class for the asc exporter.
 * 
 * @author <a href="mailto:zhaoyong@cn.ibm.com">ZhaoYong(John)</a>
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 */
public class ASCUtil {

	/**
	 * Replace all the "\" to "/" in the String.
	 * 
	 * @param str :
	 *           the String to be replaced
	 * @return the image descriptor
	 */
	public static String matchASCSpliter(String str) {
		if (str == null)
			return str;
		while (str.indexOf("\\") > 0) //$NON-NLS-1$
		{
			str = str.substring(0, str.indexOf("\\")) + "/" + //$NON-NLS-1$ //$NON-NLS-2$
					str.substring(str.indexOf("\\") + 1); //$NON-NLS-1$
		}
		return str;
	}

	public static String getProfileName(WasNodeUnit unit) {

		WasNodeUnit nodeUnit = ASCUtil.getNode(unit);
		if (nodeUnit != null) {
			WasNode nodeCap = (WasNode) CapabilityUtil.findCapabilityOfType(unit, WasPackage.eINSTANCE
					.getWasNode());
			if (nodeCap != null)
				return nodeCap.getProfileName();
		}
		return null;
	}

	/**
	 * Get the operation system's host name.
	 * 
	 * @param
	 * @return The operation system's host name in which the unit is installed
	 */
	public static String getOSHostName(Unit unit) {
		Unit beginNode = unit;
		if (!(unit instanceof WasSystemUnit)) {
			beginNode = ASCUtil.getNode(unit);
		}

		OperatingSystemUnit osUnit = (OperatingSystemUnit) TopologyDiscovererService.INSTANCE
				.findHost(beginNode, OsPackage.eINSTANCE.getOperatingSystemUnit(), unit.getTopology());
		OperatingSystem osCap = (OperatingSystem) ValidatorUtils.getCapability(osUnit,
				OsPackage.eINSTANCE.getOperatingSystem());
		if (osCap != null)
			return osCap.getHostname();
		return null;
	}

	public static PortConfigUnit getServerPortConfig(Unit serverUnit) {
		List configUnitList = TopologyDiscovererService.INSTANCE.findHosted(serverUnit, serverUnit
				.getTopology());
		for (Iterator index = configUnitList.iterator(); index.hasNext();) {
			UnitDescriptor configUD = (UnitDescriptor) index.next();
			Unit config = configUD.getUnitValue();
			if (config instanceof PortConfigUnit) {
				PortConfigUnit portConfigUnit = (PortConfigUnit) config;
				List portList = portConfigUnit.getCapabilities();
				boolean found = true;
				if (portList.size() == ASCConstants.WAS_PORTMAP.keySet().size()) {
					for (Iterator portIndex = portList.iterator(); portIndex.hasNext();) {
						Capability cap = (Capability) portIndex.next();
						if (cap instanceof Port) {

							String wasPortName = ((Port) cap).getPortName();
							String ascPortName = (String) ASCConstants.WAS_PORTMAP.get(wasPortName);

							if (ascPortName == null) {
								found = false;
								break;
							}

						}
					}
				}
				if (found) {
					return portConfigUnit;
				}

			}

		}
		return null;
	}

	/*
	 * add by Lin Feng this method use to get the first group of unit by assigned group unit class
	 * and group capability
	 */
	// private static Capability getGroupCap(Unit unit, EClass gUnitClass,
	// EClass gCapClass) {
	// List reqL = unit.getRequirements();
	// for (int i = 0; i < reqL.size(); i++) {
	// if (((Requirement) reqL.get(i)).getDmoEType().equals(gUnitClass)) {
	// List groupList = TopologyDiscovererService.INSTANCE.getGroups(
	// unit, (Requirement) reqL.get(i), unit.getTopology());
	// if (groupList != null && groupList.size() > 0) {
	// UnitDescriptor gUnitDesc = (UnitDescriptor) groupList
	// .get(0);
	// Unit groupUnit = gUnitDesc.getUnitValue();
	// Capability groupCap = ValidatorUtils.getCapability(
	// groupUnit, gCapClass);
	// return groupCap;
	// }
	// }
	// }
	// return null;
	// }
	private static Unit getFirstGroupUnit(Unit unit, EClass gUnitClass) {
		if (unit == null)
			return null;
		List reqL = unit.getRequirements();
		for (int i = 0; i < reqL.size(); i++) {
			if (((Requirement) reqL.get(i)).getDmoEType().equals(gUnitClass)) {
				List groupList = TopologyDiscovererService.INSTANCE.getGroups(unit, (Requirement) reqL
						.get(i), unit.getTopology());
				if (groupList != null && groupList.size() > 0) {
					UnitDescriptor gUnitDesc = (UnitDescriptor) groupList.get(0);
					Unit groupUnit = gUnitDesc.getUnitValue();
					return groupUnit;
				}
			}
		}
		return null;
	}

	public static List getGroups(Unit unit, EClass gUnitClass) {
		if (unit == null)
			return null;
		List reqL = unit.getRequirements();
		List groupList = new LinkedList();
		for (int i = 0; i < reqL.size(); i++) {
			List udGroupList = new LinkedList();
			if (gUnitClass == null) {
				udGroupList = TopologyDiscovererService.INSTANCE.getGroups(unit, (Requirement) reqL
						.get(i), unit.getTopology());
			} else if (((Requirement) reqL.get(i)).getDmoEType().equals(gUnitClass)) {
				udGroupList = TopologyDiscovererService.INSTANCE.getGroups(unit, (Requirement) reqL
						.get(i), unit.getTopology());

			}
			if (udGroupList != null && udGroupList.size() > 0) {
				UnitDescriptor gUnitDesc = (UnitDescriptor) udGroupList.get(0);
				Unit groupUnit = gUnitDesc.getUnitValue();
				groupList.add(groupUnit);
			}
		}
		return groupList;
	}

	// private static List getRequiredGroups(Unit unit) {
	// if (unit == null)
	// return null;
	// List reqL = unit.getRequirements();
	// List groupList = new LinkedList();
	// for (int i = 0; i < reqL.size(); i++) {
	// List udGroupList = TopologyDiscovererService.INSTANCE.getGroups(
	// unit, (Requirement) reqL.get(i), unit.getTopology());
	// if (udGroupList != null && udGroupList.size() > 0) {
	// UnitDescriptor gUnitDesc = (UnitDescriptor) udGroupList.get(0);
	// Unit groupUnit = gUnitDesc.getUnitValue();
	// groupList.add(groupUnit);
	// }
	//
	// }
	// return groupList;
	// }

	public static WasClusterUnit getCluster(WebsphereAppServerUnit serverUnit) {
		return (WasClusterUnit) getFirstGroupUnit(serverUnit, WasPackage.eINSTANCE
				.getWasClusterUnit());
	}

	public static WasNodeGroupUnit getFirstNodeGroup(WasNodeUnit nodeUnit) {
		return (WasNodeGroupUnit) getFirstGroupUnit(nodeUnit, WasPackage.eINSTANCE
				.getWasNodeGroupUnit());
	}

	public static List getNodeGroup(WasNodeUnit nodeUnit) {
		return getGroups(nodeUnit, WasPackage.eINSTANCE.getWasNodeGroupUnit());
	}

	public static WasNodeUnit getCellHostNode(WasCellUnit cellUnit) {
		if (cellUnit == null)
			return null;
		return (WasNodeUnit) TopologyDiscovererService.INSTANCE.findHost(cellUnit,
				WasPackage.eINSTANCE.getWasNodeUnit(), cellUnit.getTopology());
	}

	public static WasSystemUnit getWasSystemUnit(WasNodeUnit nodeUnit) {
		return (WasSystemUnit) TopologyDiscovererService.INSTANCE.findHost(nodeUnit,
				WasPackage.eINSTANCE.getWasSystemUnit(), nodeUnit.getTopology());
	}

	public static String getWasHome(WasCellUnit cellUnit) {
		WasNodeUnit hostNode = getCellHostNode(cellUnit);
		return getWasHome(hostNode);
	}

	public static String getWasHome(WasNodeUnit nodeUnit) {
		WasSystemUnit systemUnit = (WasSystemUnit) TopologyDiscovererService.INSTANCE.findHost(
				nodeUnit, WasPackage.eINSTANCE.getWasSystemUnit(), nodeUnit.getTopology());
		return getWasHome(systemUnit);
	}

	public static String getWasHome(WasSystemUnit systemUnit) {
		if (systemUnit == null)
			return null;
		WasSystem system = (WasSystem) ValidatorUtils.getCapability(systemUnit, WasPackage.eINSTANCE
				.getWasSystem());
		if (system == null)
			return null;
		return ASCUtil.matchASCSpliter(system.getWasHome());
	}

	public static String getNodeName(WasNodeUnit nodeUnit) {
		WasNode nodeCap = (WasNode) ValidatorUtils.getCapability(nodeUnit, WasPackage.eINSTANCE
				.getWasNode());
		if (nodeCap == null) {
			return null;
		}
		return nodeCap.getNodeName();
	}

	public static WasProfileTypeEnum getProfileType(WasNodeUnit nodeUnit) {
		WasNode nodeCap = (WasNode) ValidatorUtils.getCapability(nodeUnit, WasPackage.eINSTANCE
				.getWasNode());
		if (nodeCap == null) {
			return null;
		}
		return nodeCap.getProfileType();
	}

	public static String getNodeGroupName(WasNodeGroupUnit nodeGroupUnit) {
		WasNodeGroup nodeGroupCap = (WasNodeGroup) ValidatorUtils.getCapability(nodeGroupUnit,
				WasPackage.eINSTANCE.getWasNodeGroup());
		if (nodeGroupCap == null)
			return null;
		return nodeGroupCap.getNodeGroupName();
	}

	public static String getProfileHome(WasNodeUnit nodeUnit) {
		WasNode nodeCap = (WasNode) ValidatorUtils.getCapability(nodeUnit, WasPackage.eINSTANCE
				.getWasNode());
		if (nodeCap == null)
			return null;
		return ASCUtil.matchASCSpliter(nodeCap.getProfileLocation());

	}

	public static String getServerName(WebsphereAppServerUnit serverUnit) {
		WasServer serverCap = (WasServer) ValidatorUtils.getCapability(serverUnit,
				WasPackage.eINSTANCE.getWasServer());
		if (serverCap == null)
			return null;
		return serverCap.getServerName();
	}

	// TODO: take care this
	public static String getServerName(WasDeploymentManagerUnit dmgrUnit) {
		WasDeploymentManager dmgrCap = (WasDeploymentManager) ValidatorUtils.getCapability(dmgrUnit,
				WasPackage.eINSTANCE.getWasDeploymentManager());
		if (dmgrCap == null)
			return null;
		return dmgrCap.getName();
	}

	public static List findAllInstalledManagedNode(WasCellUnit cellUnit) {
		List managedNode = new LinkedList();
		Iterator mIt = cellUnit.getMemberLinks().iterator();
		while (mIt.hasNext()) {
			MemberLink mLink = (MemberLink) mIt.next();
			Unit member = mLink.getTarget();
			if (member instanceof WasNodeUnit) {
				WasNodeUnit nodeUnit = (WasNodeUnit) member;
				WasNode nodeCap = (WasNode) ValidatorUtils.getCapability(nodeUnit, WasPackage.eINSTANCE
						.getWasNode());
				if (nodeCap.isIsManaged()
						&& nodeUnit.getInitInstallState().equals(InstallState.INSTALLED_LITERAL)) {
					managedNode.add(nodeUnit);
				}
			}

		}
		return managedNode;
	}

	public static List findAllInstalledManagedNode(WasNodeGroupUnit nodeGroupUnit) {
		List managedNode = new LinkedList();
		Iterator mIt = nodeGroupUnit.getMemberLinks().iterator();
		while (mIt.hasNext()) {
			MemberLink mLink = (MemberLink) mIt.next();
			Unit member = mLink.getTarget();
			if (member instanceof WasNodeUnit) {
				WasNodeUnit nodeUnit = (WasNodeUnit) member;
				WasNode nodeCap = (WasNode) ValidatorUtils.getCapability(nodeUnit, WasPackage.eINSTANCE
						.getWasNode());
				if (nodeCap.isIsManaged()
						&& nodeUnit.getInitInstallState().equals(InstallState.INSTALLED_LITERAL)) {
					managedNode.add(nodeUnit);
				}
			}

		}
		return managedNode;
	}

	private static List findAllInstalledMember(Unit unit, EClass type) {
		Iterator it = getMembers(unit, type).iterator();
		List installedMemberList = new LinkedList();
		while (it.hasNext()) {
			Unit memberUnit = (Unit) it.next();
			if (memberUnit.getInitInstallState().equals(InstallState.INSTALLED_LITERAL)) {
				installedMemberList.add(memberUnit);
			}
		}
		return installedMemberList;
	}

	public static List findAllInstalledAppSvr(WasSIBusUnit busUnit) {
		return findAllInstalledMember(busUnit, WasPackage.eINSTANCE.getWebsphereAppServerUnit());
	}

	public static List findAllInstalledCluster(WasSIBusUnit busUnit) {
		return findAllInstalledMember(busUnit, WasPackage.eINSTANCE.getWasClusterUnit());
	}

	public static String getAttribute(Unit unit, String methodName) {
		if (unit == null)
			return ""; //$NON-NLS-1$
		List capList = unit.getCapabilities();
		String attributeValue = null;
		for (int i = 0; i < capList.size(); i++) {
			Method[] methods = capList.get(i).getClass().getMethods();
			for (int j = 0; j < methods.length; j++) {
				if (methods[j].getName().equals(methodName)) {
					try {
						attributeValue = (String) methods[j].invoke(capList.get(i), new Object[0]);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return attributeValue;
	}

	public static String getAttribute(Unit unit, EClass capType, String methodName) {
		List capList = ValidatorUtils.findCapabilities(unit, capType);
		String attributeValue = null;
		for (int i = 0; i < capList.size(); i++) {
			Method[] methods = capList.get(i).getClass().getMethods();
			for (int j = 0; j < methods.length; j++) {
				if (methods[j].getName().equals(methodName)) {
					try {
						attributeValue = (String) methods[j].invoke(capList.get(i), new Object[0]);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return attributeValue;
	}

	public static String getClusterName(WasClusterUnit clusterUnit) {
		WasCluster clusterCap = (WasCluster) ValidatorUtils.getCapability(clusterUnit,
				WasPackage.eINSTANCE.getWasCluster());
		if (clusterCap == null)
			return null;
		return clusterCap.getClusterName();
	}

	// only for jms connection factory
	public static String getSiBusNameFromDependency(Unit unit) {

		WasSIBusUnit sibusUnit = (WasSIBusUnit) TopologyDiscovererService.INSTANCE.findTarget(unit,
				WasPackage.eINSTANCE.getWasSIBus(), unit.getTopology());
		return getBusName(sibusUnit);
	}

	// only for sib and msessage destination
	public static String getSiBusNameFromSibDestination(WasSibDestinationUnit unit) {
		return getSiBusNameFromHoster(unit);
	}

	public static String getSiBusNameFromHoster(Unit unit) {
		WasSIBusUnit sibusUnit = (WasSIBusUnit) TopologyDiscovererService.INSTANCE.findHost(unit,
				WasPackage.eINSTANCE.getWasSIBusUnit(), unit.getTopology());
		return getBusName(sibusUnit);
	}

	public static WasSubstitutionVariable getSubVariable(Unit unit) {
		return (WasSubstitutionVariable) ValidatorUtils.getCapability(unit, WasPackage.eINSTANCE
				.getWasSubstitutionVariable());

	}

	public static Unit getWasScope(Unit unit) {
		return WasUtil.getWasScope(unit);
	}

	public static WasCellUnit getCell(Unit unit) {
		Unit scope = WasUtil.getWasScope(unit);
		if (scope instanceof WasCellUnit)
			return (WasCellUnit) scope;
		if (scope instanceof WebsphereAppServerUnit) {
			scope = getNode(scope);
		} else if (scope instanceof WasDeploymentManagerUnit) {
			scope = getNode(scope);
		}

		scope = ASCUtil.getFirstGroupUnit(scope, WasPackage.eINSTANCE.getWasCellUnit());
		if (scope instanceof WasCellUnit)
			return (WasCellUnit) scope;
		return null;
	}

	public static List getSIBusGroup(WebsphereAppServerUnit serverUnit) {
		return ASCUtil.getGroups(serverUnit, WasPackage.eINSTANCE.getWasSIBusUnit());
	}

	public static List getSIBusGroup(WasClusterUnit clusterUnit) {
		return ASCUtil.getGroups(clusterUnit, WasPackage.eINSTANCE.getWasSIBusUnit());
	}

	public static WasNodeUnit getNode(Unit unit) {
		unit = getWasScope(unit);
		if (unit instanceof WasNodeUnit)
			return (WasNodeUnit) unit;
		if (unit instanceof WebsphereAppServerUnit || unit instanceof WasDeploymentManagerUnit)
			return (WasNodeUnit) getFirstGroupUnit(unit, WasPackage.eINSTANCE.getWasNodeUnit());
		WasCellUnit cellUnit = getCell(unit);
		return ASCUtil.getCellHostNode(cellUnit);

	}

	public static WasNodeUnit getDMGRNode(Unit unit) {
		return getNode(getCell(unit));
	}

	public static WebsphereAppServerUnit getExistingServer(WasClusterUnit clusterUnit) {
		List memberList = getMembers(clusterUnit, WasPackage.eINSTANCE.getWebsphereAppServerUnit());
		Iterator mIt = memberList.iterator();
		while (mIt.hasNext()) {
			WebsphereAppServerUnit serverUnit = (WebsphereAppServerUnit) mIt.next();
			if (InstallState.INSTALLED_LITERAL.equals(serverUnit.getInitInstallState())) {
				return serverUnit;
			}
		}
		return null;
	}

	private static List getMembers(final Unit unit, final EClass type) {
		final List memberList = new LinkedList();
		final Iterator it = unit.getRequirements().iterator();
		while (it.hasNext()) {
			final Requirement req = (Requirement) it.next();
			if (type.equals(req.getDmoEType())) {
				final List memberUDList = TopologyDiscovererService.INSTANCE.getMembers(unit, req, unit
						.getTopology());
				final Iterator mIt = memberUDList.iterator();
				while (mIt.hasNext()) {
					final UnitDescriptor unitDesc = (UnitDescriptor) mIt.next();
					final Unit memberUnit = unitDesc.getUnitValue();
					if (memberUnit != null)
						memberList.add(memberUnit);
				}
			}
		}
		return memberList;

	}

	/**
	 * judge whethere the unit is in WAS nd6 domain.
	 * 
	 * @param unit
	 *           :the unit to be judged
	 * @return boolean if is in WAS nd6
	 */
	public static boolean isWASND6(Unit unit) {

		WasSystem systemCap = getWas6System(unit);
		if (systemCap == null) {
			return false;
		}
		boolean result = ASCConstants.WAS_VERSION_6.equals(systemCap.getWasVersion());
		result = result
				&& WasEditionEnum.NETWORK_DEPLOYMENT_LITERAL.equals(systemCap.getWasEdition());
		if (result) {
			return true;
		}
		return false;
	}

	/**
	 * judge whethere the unit is in WAS base 6 domain.
	 * 
	 * @param unit
	 *           :the unit to be judged
	 * @return boolean if is in WAS base 6
	 */
	public static boolean isWASBase6(Unit unit) throws ASCException {
		WasSystem systemCap = getWas6System(unit);
		if (systemCap == null) {
			throw new ASCException("No WasSystem releated to the unit " + unit.getName()); //$NON-NLS-1$
		}
		if (ASCConstants.WAS_VERSION_6.equals(systemCap.getWasVersion())
				&& WasEditionEnum.BASE_LITERAL.equals(systemCap.getWasEdition())) {
			return true;
		} else
			return false;
	}

	private static WasSystem getWas6System(Unit unit) {
		WasSystemUnit systemUnit = null;
		if (unit instanceof WasSystemUnit) {
			systemUnit = (WasSystemUnit) unit;
		} else {
			WasNodeUnit nodeUnit = getNode(unit);
			if (nodeUnit == null)
				return null;
			WasNode nodeCap = (WasNode) ValidatorUtils.getCapability(nodeUnit, WasPackage.eINSTANCE
					.getWasNode());
			if (!ASCConstants.WAS_VERSION_6.equals(nodeCap.getWasVersion())) {
				return null;
			}
			systemUnit = getWasSystemUnit(nodeUnit);

		}
		WasSystem systemCap = (WasSystem) ValidatorUtils.getCapability(systemUnit,
				WasPackage.eINSTANCE.getWasSystem());
		return systemCap;
	}

	public static String getCellName(WasCellUnit cellUnit) {
		WasCell cellCap = (WasCell) ValidatorUtils.getCapability(cellUnit, WasPackage.eINSTANCE
				.getWasCell());
		if (cellCap != null) {
			return cellCap.getCellName();
		}
		return null;
	}

	public static WebsphereAppServerUnit getDefaultServer(WasNodeUnit nodeUnit) {
		List memberList = getMembers(nodeUnit, WasPackage.eINSTANCE.getWebsphereAppServerUnit());
		return (WebsphereAppServerUnit) (memberList.size() > 0 ? memberList.get(0) : null);
	}

	public static WasDeploymentManagerUnit getDMGR(WasNodeUnit nodeUnit) {
		List memberList = getMembers(nodeUnit, WasPackage.eINSTANCE.getWasDeploymentManagerUnit());
		return (WasDeploymentManagerUnit) (memberList.size() > 0 ? memberList.get(0) : null);
	}

	public static PortConsumer getPortConsumber(Unit unit) {
		return (PortConsumer) ValidatorUtils.getCapability(unit, OsPackage.eINSTANCE
				.getPortConsumer());
	}

	public static boolean isManaged(WasNodeUnit nodeUnit) {
		WasNode nodeCap = (WasNode) ValidatorUtils.getCapability(nodeUnit, WasPackage.eINSTANCE
				.getWasNode());
		return nodeCap.isIsManaged();
	}

	public static List getserverFromCluster(WasClusterUnit clusterUnit) {
		return getMembers(clusterUnit, WasPackage.eINSTANCE.getWebsphereAppServerUnit());
	}

	public static String getSiBusNameFromDFMDest(Unit unit) {

		WasSibDestinationUnit destUnit = (WasSibDestinationUnit) TopologyDiscovererService.INSTANCE
				.findTarget(unit, WasPackage.eINSTANCE.getWasSibDestination(), unit.getTopology());

		return getSiBusNameFromSibDestination(destUnit);
	}

	public static WebsphereAppServerUnit getLinkedWasServerUnit4SibDest(
			WasSibDestinationUnit destUnit) {
		WebsphereAppServerUnit serverUnit = null;// (WebsphereAppServerUnit)

		List list = destUnit.getRequirements();
		for (int i = 0; i < list.size(); i++) {
			Requirement req = (Requirement) list.get(i);
			if (req.getDmoEType().equals(WasPackage.eINSTANCE.getWasJ2EEServer())) {
				Capability target = ValidatorUtils.getDependencyLinkTarget(req);
				if (target instanceof WasServer) {
					WasServer server = (WasServer) target;
					serverUnit = (WebsphereAppServerUnit) server.getParent();
				}
			}
		}
		return serverUnit;
	}

	public static WasClusterUnit getLinkedClusterUnit4SibDest(WasSibDestinationUnit unit) {
		WasClusterUnit clusterUnit = null;// (WebsphereAppServerUnit)
		List list = unit.getRequirements();
		for (int i = 0; i < list.size(); i++) {
			Requirement req = (Requirement) list.get(i);
			if (req.getDmoEType().equals(WasPackage.eINSTANCE.getWasJ2EEServer())) {
				Capability target = ValidatorUtils.getDependencyLinkTarget(req);
				if (target instanceof WasCluster) {
					WasCluster cluster = (WasCluster) target;
					clusterUnit = (WasClusterUnit) cluster.getParent();
				}
			}
		}
		return clusterUnit;
	}

	public static String getEndpointListenerName(WasEndpointListenerUnit unit) {
		List capList = unit.getCapabilities();
		for (int i = 0; i < capList.size(); i++) {
			if (capList.get(i) instanceof WasEndpointListenerConfiguration) {
				return ((WasEndpointListenerConfiguration) capList.get(i)).getEndpointListenerName()
						.getLiteral();
			}
		}
		return null;// ASCUtil.getAttribute(unit, "getEndpointListenerName");
	}

	public static String getBusName(WasSIBusUnit busUnit) {
		return getAttribute(busUnit, "getBusName"); //$NON-NLS-1$
	}

	public static Unit[] getSequenceUnits(Topology topology) {
		return SequenceUtil.getSequenceUnits(topology);
	}

	// optional for server
	public static String getDataSourceJndi4MEDB(WebsphereAppServerUnit serverUnit) {

		Requirement requiredWasSibus = (Requirement) ValidatorUtils.getRequirements(serverUnit,
				WasPackage.eINSTANCE.getWasV5Datasource()).get(0);
		Capability target = ValidatorUtils.getDependencyLinkTarget(requiredWasSibus);
		if (target != null && target instanceof WasV5Datasource) {
			WasV5Datasource dataSource = (WasV5Datasource) target;
			return dataSource.getJndiName();
		}
		return null;
	}

	public static String getDataSourceJndi4MEDB(WasClusterUnit busUnit) {
		Requirement requiredWasSibus = (Requirement) ValidatorUtils.getRequirements(busUnit,
				WasPackage.eINSTANCE.getWasV5Datasource()).get(0);
		Capability target = ValidatorUtils.getDependencyLinkTarget(requiredWasSibus);
		if (target != null && target instanceof WasV5Datasource) {
			WasV5Datasource dataSource = (WasV5Datasource) target;
			return dataSource.getJndiName();
		}
		return null;
	}

	public static WasNodeUnit getFirstWasNodeUnitofWasBase(WasSystemUnit unit) {
		List udList = TopologyDiscovererService.INSTANCE.findHosted(unit, unit.getTopology());
		if (udList.size() > 0) {
			UnitDescriptor wasNodeUD = (UnitDescriptor) udList.get(0);
			WasNodeUnit nodeUnit = (WasNodeUnit) wasNodeUD.getUnitValue();
			return nodeUnit;
		}
		return null;
	}

	public static boolean isInstalledUnit(Unit unit) {
		if (unit.getInitInstallState().equals(InstallState.INSTALLED_LITERAL))
			return true;
		else
			return false;
	}
}
