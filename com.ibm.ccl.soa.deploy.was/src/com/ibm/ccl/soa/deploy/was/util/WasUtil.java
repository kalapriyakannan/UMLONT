/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasCluster;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasEditionEnum;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeGroup;
import com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum;
import com.ibm.ccl.soa.deploy.was.WasSIBusUnit;
import com.ibm.ccl.soa.deploy.was.WasServer;
import com.ibm.ccl.soa.deploy.was.WasSystem;
import com.ibm.ccl.soa.deploy.was.WasSystemUnit;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;

/**
 * This class will provide the most popular navigation's needed in was Model
 * 
 * @since 3.2
 * 
 */
public class WasUtil {
	public final static String WAS_5_MAIN_VERSION = "5"; //$NON-NLS-1$
	public final static String WAS_6_MAIN_VERSION = "6"; //$NON-NLS-1$
	public final static String WAS_MAIN_VERSION_MAX_BOUND = "7"; //$NON-NLS-1$

	private WasUtil() {
		//static method only
	}

	/**
	 * Retrieve the {@link WasCell} capability of the {@link WasCellUnit} containing a given
	 * {@link WasNodeUnit}.
	 * 
	 * @param wasNodeUnit
	 *           a {@link WasNodeUnit}
	 * @param top
	 *           the topology in which to search; typically the current edit topology
	 * @return the {@link WasCell} capability of the {@link WasCellUnit} containing wasNodeUnit
	 */
	public static WasCell getWasCellCap(WasNodeUnit wasNodeUnit, Topology top) {
		List<Requirement> reqL = wasNodeUnit.getRequirements();
		for (int i = 0; i < reqL.size(); i++) {
			Requirement req = reqL.get(i);
			if (null == req.getDmoEType()) {
				return null;
			}
			if (req.getDmoEType().equals(WasPackage.eINSTANCE.getWasCellUnit())) {
				List<UnitDescriptor> groupList = TopologyDiscovererService.INSTANCE.getGroups(
						wasNodeUnit, req, wasNodeUnit.getEditTopology());
				if (groupList != null && groupList.size() > 0) {
					UnitDescriptor wasCellUnitDesc = groupList.get(0);
					WasCellUnit wasCellunit = (WasCellUnit) wasCellUnitDesc.getUnitValue();
					WasCell wasCellCap = (WasCell) ValidatorUtils.getCapability(wasCellunit,
							WasPackage.eINSTANCE.getWasCell());
					return wasCellCap;
				}
			}
		}
		return null;
	}

	public static WasCell getWasCellCap(WasNodeGroupUnit wasNodeGroupUnit, Topology top) {
		List reqL = wasNodeGroupUnit.getRequirements();
		for (int i = 0; i < reqL.size(); i++) {
			if (((Requirement) reqL.get(i)).getDmoEType()
					.equals(WasPackage.eINSTANCE.getWasCellUnit())) {
				List groupList = TopologyDiscovererService.INSTANCE.getGroups(wasNodeGroupUnit,
						(Requirement) reqL.get(i), top);
				if (groupList != null && groupList.size() > 0) {
					UnitDescriptor wasCellUnitDesc = (UnitDescriptor) groupList.get(0);
					WasCellUnit wasCellunit = (WasCellUnit) wasCellUnitDesc.getUnitValue();
					WasCell wasCellCap = (WasCell) ValidatorUtils.getCapability(wasCellunit,
							WasPackage.eINSTANCE.getWasCell());
					return wasCellCap;
				}
			}
		}
		return null;
	}

	/**
	 * Retrieve the {@link WasCell} capability of the cell containing a given {@link WasClusterUnit}.
	 * 
	 * @param wasClusterUnit
	 *           the {@link WasClusterUnit}
	 * @param top
	 *           the {@link Topology} in which to search; typically the current edit topology
	 * @return the {@link WasCell} capability of the {@link WasCellUnit} containing wasClusterUnit
	 */
	public static WasCell getWasCellCap(WasClusterUnit wasClusterUnit, Topology top) {
		Unit wasCellUnit = ValidatorUtils.discoverHost(wasClusterUnit, null);
		if (null == wasCellUnit) {
			return null;
		}

		return (WasCell) ValidatorUtils.getCapability(wasCellUnit, WasPackage.eINSTANCE.getWasCell());
		//		List reqL = wasClusterUnit.getRequirements();
		//		for(int i = 0; i < reqL.size(); i ++){
		//			if(((Requirement)reqL.get(i)).getDmoEType().equals(WasPackage.eINSTANCE.getWasCellUnit())){
		//				List groupList = TopologyDiscovererService.INSTANCE.getGroups(wasClusterUnit, (Requirement)reqL.get(i), top);
		//				if(groupList != null && groupList.size()>0){
		//					UnitDescriptor wasCellUnitDesc = (UnitDescriptor) groupList.get(0);
		//					WasCellUnit wasCellunit = (WasCellUnit) wasCellUnitDesc.getUnitValue();
		//					WasCell wasCellCap = (WasCell) ValidatorUtils.getCapability(wasCellunit, WasPackage.eINSTANCE.getWasCell());
		//					return wasCellCap;
		//				}
		//			}			
		//		}
		//		return null;
	}

	public static WasSystem getWasSystemCap(WasNodeUnit wasNodeUnit) {
		Unit host_wasSystemUnit = TopologyDiscovererService.INSTANCE.findHost(wasNodeUnit,
				wasNodeUnit.getTopology());
		if (host_wasSystemUnit != null) {
			return (WasSystem) ValidatorUtils.getCapability(host_wasSystemUnit, WasPackage.eINSTANCE
					.getWasSystem());
		}
		return null;
	}

	/**
	 * 
	 * @param wasAppSvrUnit
	 * @return
	 * @deprecated
	 */
	/*
	 * add by Lin Feng
	 */
	public static WasNode getWasNodeCap(WebsphereAppServerUnit wasAppSvrUnit) {
		return (WasNode) getGroupCap(wasAppSvrUnit, WasPackage.eINSTANCE.getWasNodeUnit(),
				WasPackage.eINSTANCE.getWasNode());
	}

	public static WasNode getWasNodeCap(WebsphereAppServerUnit wasAppSvrUnit, Topology top) {
		// MK 11/21/2006 changed method to get node from server since membership chagned to hosting
		// return (WasNode)getGroupCap(wasAppSvrUnit,WasPackage.eINSTANCE.getWasNodeUnit(),WasPackage.eINSTANCE.getWasNode(), top);
		Unit node = TopologyDiscovererService.INSTANCE.findHost(wasAppSvrUnit, top);
		return (WasNode) ValidatorUtils.getFirstCapability(node, WasPackage.Literals.WAS_NODE);
	}

	public static WasCluster getWasClusterCap(WebsphereAppServerUnit wasAppSvrUnit, Topology top) {
		return (WasCluster) getGroupCap(wasAppSvrUnit, WasPackage.eINSTANCE.getWasClusterUnit(),
				WasPackage.eINSTANCE.getWasCluster(), top);
	}

	public static WasNodeGroup getWasNodeGroupCap(WasNodeUnit nodeUnit, Topology top) {
		return (WasNodeGroup) getGroupCap(nodeUnit, WasPackage.eINSTANCE.getWasNodeGroupUnit(),
				WasPackage.eINSTANCE.getWasNodeGroup(), top);
	}

	/**
	 * 
	 * @param configUnit
	 * @return the scope unit(Cell, node ,appsvr)which holds configUnit return configUnit if
	 *         configUnit is not a configuration unit.
	 * @deprecated use the method with Topology as a param
	 */
	public static Unit getWasScope(Unit configUnit) {
		Unit hoster = configUnit;
		while (!isWasComponent(hoster) && hoster != null) {
			hoster = TopologyDiscovererService.INSTANCE.findHost(hoster, hoster.getTopology());
		}

		return hoster;

	}

	/**
	 * 
	 * @param configUnit
	 * @param top
	 * @return the scope Unit on which the configuration Unit is hosting
	 */
	public static Unit getWasScope(Unit configUnit, Topology top) {
		Unit hoster = configUnit;
		while (!isWasComponent(hoster) && hoster != null) {
			hoster = TopologyDiscovererService.INSTANCE.findHost(hoster, top);
		}

		return hoster;
	}

	private static boolean isWasComponent(Unit unit) {
		return unit instanceof WasCellUnit || unit instanceof WasNodeUnit
				|| unit instanceof WebsphereAppServerUnit || unit instanceof WasClusterUnit
				|| unit instanceof WasSIBusUnit || unit instanceof WasNodeGroupUnit;
	}

	/**
	 * 
	 * @param unit
	 * @return profileLocation of unit
	 */
	/*
	 * add by Lin Feng
	 */
	public static String getProfileLocation(Unit unit) {
		WasNode nodeCap = getWasNodeFromAnyUnit(unit);
		if (nodeCap == null) {
			return null;
		}
		return nodeCap.getProfileLocation();

	}

	/**
	 * 
	 * @param unit
	 * @return the host name of OS which hold unit.
	 */
	public static String getOSHostName(Unit unit) {
		Unit tempUnit = null;
		WasNode nodeCap = getWasNodeFromAnyUnit(unit);
		if (nodeCap != null) {
			tempUnit = (Unit) nodeCap.getParent();

		} else {
			tempUnit = unit;
		}
		while (!(tempUnit instanceof OperatingSystemUnit) && tempUnit != null) {
			tempUnit = TopologyDiscovererService.INSTANCE.findHost(tempUnit, tempUnit.getTopology());
			if (tempUnit == null) {
				return null;
			}
		}
		OperatingSystem osCap = (OperatingSystem) ValidatorUtils.getCapability(tempUnit,
				OsPackage.eINSTANCE.getOperatingSystem());
		return osCap.getHostname();
	}

	/*
	 * add by Lin Feng this method use to get the first group of unit by assigned group unit class
	 * and group capability
	 * 
	 */
	/**
	 * @deprecated may not find the topology, reference
	 *             {@link WasUtil#getGroupCap(Unit, EClass, EClass, Topology)}
	 */
	private static Capability getGroupCap(Unit unit, EClass gUnitClass, EClass gCapClass) {
		List reqL = unit.getRequirements();
		for (int i = 0; i < reqL.size(); i++) {
			if (((Requirement) reqL.get(i)).getDmoEType().equals(gUnitClass)) {
				List groupList = TopologyDiscovererService.INSTANCE.getGroups(unit, (Requirement) reqL
						.get(i), unit.getTopology());
				if (groupList != null && groupList.size() > 0) {
					UnitDescriptor gUnitDesc = (UnitDescriptor) groupList.get(0);
					Unit groupUnit = gUnitDesc.getUnitValue();
					Capability groupCap = ValidatorUtils.getCapability(groupUnit, gCapClass);
					return groupCap;
				}
			}
		}
		return null;
	}

	private static Capability getGroupCap(Unit unit, EClass gUnitClass, EClass gCapClass,
			Topology top) {
		for (Requirement req : ValidatorUtils.getRequirements(unit, gUnitClass)) {
			List groupList = TopologyDiscovererService.INSTANCE.getGroups(unit, req, top);
			if (groupList != null && groupList.size() > 0) {
				UnitDescriptor gUnitDesc = (UnitDescriptor) groupList.get(0);
				Unit groupUnit = gUnitDesc.getUnitValue();
				Capability groupCap = ValidatorUtils.getCapability(groupUnit, gCapClass);
				return groupCap;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param cellUnit
	 * @return a capability of wasCellUnit contained nodes.
	 * @deprecated refer to {@link WasUtil#getWasNodeCapsFromCellUnit(WasCellUnit, Topology)}
	 */
	public static List getWasNodeCapsFromCellUnit(WasCellUnit cellUnit) {
		ArrayList capList = new ArrayList();
		List reqL = cellUnit.getOnlyMemberRequirements();
		for (int i = 0; i < reqL.size(); i++) {
			// Bill Arnold 2006/08/25 prevent NPE if DmoEType not set. 
			if (((Requirement) reqL.get(i)).getDmoEType() == null) {
				continue;
			}
			if (((Requirement) reqL.get(i)).getDmoEType()
					.equals(WasPackage.eINSTANCE.getWasNodeUnit())) {
				List memberList = TopologyDiscovererService.INSTANCE.getMembers(cellUnit,
						(Requirement) reqL.get(i), cellUnit.getTopology());
				if (memberList == null) {
					continue;
				}
				for (int j = 0; j < memberList.size(); j++) {
					UnitDescriptor nodeUnitDesc = (UnitDescriptor) memberList.get(j);
					WasNodeUnit nodeUnit = (WasNodeUnit) nodeUnitDesc.getUnitValue();
					WasNode nodeCap = (WasNode) ValidatorUtils.getCapability(nodeUnit,
							WasPackage.eINSTANCE.getWasNode());
					if (nodeCap != null
							&& nodeCap.getProfileType().equals(WasProfileTypeEnum.DMGR_LITERAL)) {
						capList.add(0, nodeCap);
					} else {
						capList.add(nodeCap);
					}
				}
			}
		}

		return capList;
	}

	/**
	 * 
	 * @param cellUnit
	 * @param top
	 * @return nodes inside the cellUnit
	 */
	public static List getWasNodeCapsFromCellUnit(WasCellUnit cellUnit, Topology top) {
		ArrayList capList = new ArrayList();
		List reqL = cellUnit.getOnlyMemberRequirements();
		for (int i = 0; i < reqL.size(); i++) {
			// Bill Arnold 2006/08/25 prevent NPE if DmoEType not set. 
			if (((Requirement) reqL.get(i)).getDmoEType() == null) {
				continue;
			}
			if (((Requirement) reqL.get(i)).getDmoEType()
					.equals(WasPackage.eINSTANCE.getWasNodeUnit())) {
				List memberList = TopologyDiscovererService.INSTANCE.getMembers(cellUnit,
						(Requirement) reqL.get(i), top);
				if (memberList == null) {
					continue;
				}
				for (int j = 0; j < memberList.size(); j++) {
					UnitDescriptor nodeUnitDesc = (UnitDescriptor) memberList.get(j);
					WasNodeUnit nodeUnit = (WasNodeUnit) nodeUnitDesc.getUnitValue();
					WasNode nodeCap = (WasNode) ValidatorUtils.getCapability(nodeUnit,
							WasPackage.eINSTANCE.getWasNode());
					if (nodeCap != null
							&& nodeCap.getProfileType().equals(WasProfileTypeEnum.DMGR_LITERAL)) {
						capList.add(0, nodeCap);
					} else {
						capList.add(nodeCap);
					}
				}
			}
		}

		return capList;
	}

	/**
	 * 
	 * @param nodeGroupUnit
	 * @param top
	 * @return a capability of nodeGroupUnit contained nodes.
	 */
	public static List getWasNodeCapsFromNodeGroupUnit(WasNodeGroupUnit nodeGroupUnit, Topology top) {
		ArrayList capList = new ArrayList();
		List reqL = nodeGroupUnit.getOnlyMemberRequirements();
		for (int i = 0; i < reqL.size(); i++) {
			if (((Requirement) reqL.get(i)).getDmoEType()
					.equals(WasPackage.eINSTANCE.getWasNodeUnit())) {
				List memberList = TopologyDiscovererService.INSTANCE.getMembers(nodeGroupUnit,
						(Requirement) reqL.get(i), top);
				if (memberList == null) {
					continue;
				}
				for (int j = 0; j < memberList.size(); j++) {
					UnitDescriptor nodeUnitDesc = (UnitDescriptor) memberList.get(j);
					WasNodeUnit nodeUnit = (WasNodeUnit) nodeUnitDesc.getUnitValue();
					WasNode nodeCap = (WasNode) ValidatorUtils.getCapability(nodeUnit,
							WasPackage.eINSTANCE.getWasNode());
					if (nodeCap != null
							&& nodeCap.getProfileType().equals(WasProfileTypeEnum.DMGR_LITERAL)) {
						capList.add(0, nodeCap);
					} else {
						capList.add(nodeCap);
					}
				}
			}
		}

		return capList;
	}

	/**
	 * get NodeUnits in NodeGroupUnit
	 * 
	 * @param nodeGroupUnit
	 * @param top
	 * @return nodeUnitList
	 */
	public static List getWasNodeUnitsFromNodeGroupUnit(WasNodeGroupUnit nodeGroupUnit, Topology top) {
		ArrayList nodeUnitList = new ArrayList();
		List reqL = nodeGroupUnit.getOnlyMemberRequirements();
		for (int i = 0; i < reqL.size(); i++) {
			if (((Requirement) reqL.get(i)).getDmoEType()
					.equals(WasPackage.eINSTANCE.getWasNodeUnit())) {
				List memberList = TopologyDiscovererService.INSTANCE.getMembers(nodeGroupUnit,
						(Requirement) reqL.get(i), top);
				if (memberList == null) {
					continue;
				}
				for (int j = 0; j < memberList.size(); j++) {
					UnitDescriptor nodeUnitDesc = (UnitDescriptor) memberList.get(j);
					WasNodeUnit nodeUnit = (WasNodeUnit) nodeUnitDesc.getUnitValue();
					nodeUnitList.add(nodeUnit);
				}
			}
		}
		return nodeUnitList;
	}

	/**
	 * get NodeUnits in CellUnit
	 * 
	 * @param cellUnit
	 * @param top
	 * @return nodeUnitList
	 */
	public static List getWasNodeUnitsFromCellUnit(WasCellUnit cellUnit, Topology top) {
		ArrayList nodeUnitList = new ArrayList();
		List reqL = cellUnit.getOnlyMemberRequirements();
		for (int i = 0; i < reqL.size(); i++) {
			if (((Requirement) reqL.get(i)).getDmoEType()
					.equals(WasPackage.eINSTANCE.getWasNodeUnit())) {
				List memberList = TopologyDiscovererService.INSTANCE.getMembers(cellUnit,
						(Requirement) reqL.get(i), top);
				if (memberList == null) {
					continue;
				}
				for (int j = 0; j < memberList.size(); j++) {
					UnitDescriptor nodeUnitDesc = (UnitDescriptor) memberList.get(j);
					WasNodeUnit nodeUnit = (WasNodeUnit) nodeUnitDesc.getUnitValue();
					nodeUnitList.add(nodeUnit);
				}
			}
		}
		return nodeUnitList;
	}

	/**
	 * 
	 * @param unit
	 * @return serverCapList contained in this unit
	 * @deprecated
	 */
	public static List getWasAppSvrCapMemberList(Unit unit) {
		ArrayList capList = new ArrayList();
		List reqL = unit.getOnlyMemberRequirements();
		for (int i = 0; i < reqL.size(); i++) {
			if (((Requirement) reqL.get(i)).getDmoEType().equals(
					WasPackage.eINSTANCE.getWebsphereAppServerUnit())) {
				List memberList = TopologyDiscovererService.INSTANCE.getMembers(unit,
						(Requirement) reqL.get(i), unit.getTopology());
				if (memberList == null) {
					continue;
				}
				for (int j = 0; j < memberList.size(); j++) {
					UnitDescriptor appSvrUnitDesc = (UnitDescriptor) memberList.get(j);
					WebsphereAppServerUnit appSvrUnit = (WebsphereAppServerUnit) appSvrUnitDesc
							.getUnitValue();
					WasServer appSvrCap = (WasServer) ValidatorUtils.getCapability(appSvrUnit,
							WasPackage.eINSTANCE.getWasServer());
					if (!capList.contains(appSvrCap)) {
						capList.add(appSvrCap);
					}
				}
			}
		}
		return capList;
	}

	public static List getWasAppSvrCapMemberList(Unit unit, Topology top) {
		ArrayList capList = new ArrayList();
		List reqL = unit.getOnlyMemberRequirements();
		for (int i = 0; i < reqL.size(); i++) {
			if (((Requirement) reqL.get(i)).getDmoEType().equals(
					WasPackage.eINSTANCE.getWebsphereAppServerUnit())) {
				List memberList = TopologyDiscovererService.INSTANCE.getMembers(unit,
						(Requirement) reqL.get(i), top);
				if (memberList == null) {
					continue;
				}
				for (int j = 0; j < memberList.size(); j++) {
					UnitDescriptor appSvrUnitDesc = (UnitDescriptor) memberList.get(j);
					WebsphereAppServerUnit appSvrUnit = (WebsphereAppServerUnit) appSvrUnitDesc
							.getUnitValue();
					WasServer appSvrCap = (WasServer) ValidatorUtils.getCapability(appSvrUnit,
							WasPackage.eINSTANCE.getWasServer());
					if (!capList.contains(appSvrCap)) {
						capList.add(appSvrCap);
					}
				}
			}
		}
		return capList;
	}

	/**
	 * 
	 * @param unit
	 * @param top
	 * @return serverUnitList contained in this unit
	 */
	public static List getWasAppServerUnitMemberList(Unit unit, Topology top) {
		ArrayList serverUnitList = new ArrayList();
		List reqL = unit.getOnlyMemberRequirements();
		for (int i = 0; i < reqL.size(); i++) {
			if (((Requirement) reqL.get(i)).getDmoEType().equals(
					WasPackage.eINSTANCE.getWebsphereAppServerUnit())) {
				List memberList = TopologyDiscovererService.INSTANCE.getMembers(unit,
						(Requirement) reqL.get(i), top);
				if (memberList == null) {
					continue;
				}
				for (int j = 0; j < memberList.size(); j++) {
					UnitDescriptor appSvrUnitDesc = (UnitDescriptor) memberList.get(j);
					WebsphereAppServerUnit appSvrUnit = (WebsphereAppServerUnit) appSvrUnitDesc
							.getUnitValue();
					if (!serverUnitList.contains(appSvrUnit)) {
						serverUnitList.add(appSvrUnit);
					}
				}
			}
		}
		return serverUnitList;
	}

	/**
	 * 
	 * @param cellUnit
	 * @param top
	 * @return a capability list of WasCellUnit conatained nodegroups
	 */
	public static List getWasNodeGroupsFromCell(WasCellUnit cellUnit, Topology top) {
		ArrayList capList = new ArrayList();
		List reqL = cellUnit.getOnlyMemberRequirements();
		for (int i = 0; i < reqL.size(); i++) {
			if (((Requirement) reqL.get(i)).getDmoEType().equals(
					WasPackage.eINSTANCE.getWasNodeGroupUnit())) {
				List memberList = TopologyDiscovererService.INSTANCE.getMembers(cellUnit,
						(Requirement) reqL.get(i), top);
				if (memberList == null) {
					continue;
				}
				for (int j = 0; j < memberList.size(); j++) {
					UnitDescriptor nodegroupUnitDesc = (UnitDescriptor) memberList.get(j);
					WasNodeGroupUnit nodegroupUnit = (WasNodeGroupUnit) nodegroupUnitDesc.getUnitValue();
					WasNodeGroup nodegroupCap = (WasNodeGroup) ValidatorUtils.getCapability(
							nodegroupUnit, WasPackage.eINSTANCE.getWasNodeGroup());
					capList.add(nodegroupCap);
				}
			}
		}

		return capList;
	}

	/*
	 * if unit is node, return itself if unit is distributed cell, return dmgr node if unit is
	 * standalone cell, return default node if unit is WebSphereAppServerUnit, return it's node if
	 * unit is configuration unit, first find its scope unit(cell, node, appsvr), then return scope
	 * unit's node.
	 * 
	 */
	/**
	 * @deprecated do not use get Units method that does not invovle any Topology as param
	 */
	private static WasNode getWasNodeFromAnyUnit(Unit unit) {
		Unit scopeUnit = getWasScope(unit);
		if (scopeUnit == null) {
			return null;
		}
		WasNode nodeCap = null;
		if (scopeUnit instanceof WasCellUnit) {
			nodeCap = (WasNode) getWasNodeCapsFromCellUnit((WasCellUnit) scopeUnit).get(0);
		} else if (scopeUnit instanceof WasNodeUnit) {
			nodeCap = (WasNode) ValidatorUtils.getCapability(scopeUnit, WasPackage.eINSTANCE
					.getWasNode());
		} else if (scopeUnit instanceof WebsphereAppServerUnit) {

			nodeCap = getWasNodeCap((WebsphereAppServerUnit) scopeUnit);
		} else {
			return null;
		}
		return nodeCap;
	}

	/**
	 * Version String formate is n1.n2.n3.n4, n1.n2.n3, n1.n2, n1
	 * 
	 * @param vs1
	 * @param vs2
	 * @return 0 == equals, 1 == (vs1 >vs2), -1 == (vs1 < vs2)
	 */
	public static int compare2VersionString(String vs1, String vs2) {
		if (vs1 == null || vs1.length() <= 0) {
			vs1 = "0"; //$NON-NLS-1$
		}
		if (vs2 == null || vs2.length() <= 0) {
			vs2 = "0"; //$NON-NLS-1$
		}

		int pos1 = vs1.indexOf("."); //$NON-NLS-1$
		int pos2 = vs2.indexOf(".");//$NON-NLS-1$
		String sub_vs1;
		String sub_vs2;
		int n1;
		int n2;
		if (pos1 >= 0) {
			sub_vs1 = vs1.substring(0, pos1);
		} else {
			sub_vs1 = vs1;
		}
		if (pos2 >= 0) {
			sub_vs2 = vs2.substring(0, pos2);
		} else {
			sub_vs2 = vs2;
		}

		if (sub_vs1 == null || sub_vs1.length() <= 0) {
			n1 = 0;
		} else {
			n1 = Integer.parseInt(sub_vs1);
		}

		if (sub_vs2 == null || sub_vs2.length() <= 0) {
			n2 = 0;
		} else {
			n2 = Integer.parseInt(sub_vs2);
		}

		if (n1 == n2) {
			if (pos1 < 0 && pos2 < 0) {
				return 0;
			}
			if (pos1 >= 0) {
				sub_vs1 = vs1.substring(pos1 + 1);
			} else {
				sub_vs1 = "0";//$NON-NLS-1$
			}
			if (pos2 >= 0) {
				sub_vs2 = vs2.substring(pos2 + 1);
			} else {
				sub_vs2 = "0";//$NON-NLS-1$
			}

			if (sub_vs1 != null && sub_vs1.length() > 0) {
				if (!(sub_vs2 != null && sub_vs2.length() > 0)) {
					sub_vs2 = "0";//$NON-NLS-1$
				}
			} else {
				sub_vs1 = "0"; //$NON-NLS-1$
			}
			return compare2VersionString(sub_vs1, sub_vs2);

		} else if (n1 > n2) {
			return 1;
		} else {
			return -1;
		}

	}

	/**
	 * Move the memberUnit out of the groupUnit
	 * 
	 * @param memberUnit
	 * @param groupUnit
	 */
	public static void departFromGroup(Unit memberUnit, Unit groupUnit) {
		Iterator memberLinkIt = groupUnit.getMemberLinks().iterator();
		while (memberLinkIt.hasNext()) {
			MemberLink link = (MemberLink) memberLinkIt.next();
			if (link.getTarget().equals(memberUnit)) {
				groupUnit.getMemberLinks().remove(link);
				break;
			}
		}
	}

	/**
	 * 
	 * @param unit
	 * @return applications hosting on this unit
	 */
	public static List getAllApplications(Unit unit) {
		if (!(unit instanceof WebsphereAppServerUnit || unit instanceof WasClusterUnit)) {
			return null;
		}

		List applicationLists = new ArrayList();
		applicationLists.addAll(ValidatorUtils.getHosted(unit, J2eePackage.Literals.EAR_MODULE));
		applicationLists.addAll(ValidatorUtils.getHosted(unit, J2eePackage.Literals.WEB_MODULE));
		applicationLists.addAll(ValidatorUtils.getHosted(unit, J2eePackage.Literals.EJB_MODULE));

		return applicationLists;
	}

	/**
	 * Create and return a hosting link from hoster to hostee
	 * 
	 * @param hoster
	 *           the unit hosting the created link
	 * @param hostee
	 *           the unit hosted by the created link
	 * @return the new hosting link
	 * @deprecated use {@link ResolutionUtils#host(Unit, Unit)
	 */
	public static HostingLink hosts(Unit hoster, Unit hostee) {
//		assert hoster != null;
//		assert hostee != null;
//		assert hoster != hostee;
//
//		assert hostee.getTopology() != null;
//		assert hoster.getTopology() != null;
//		assert hostee.getTopology() == hoster.getTopology();
//		assert hostee.getTopology().findHosts(hostee).length == 0 : "Hostee \"" + hostee.getName() //$NON-NLS-1$
//				+ "\" already hosted by \"" + hostee.getTopology().findHosts(hostee)[0].getName() + "\""; //$NON-NLS-1$//$NON-NLS-2$
//		HostingLink hl = CoreFactory.eINSTANCE.createHostingLink();
//		hl.setHosted(hostee);
//		hoster.getHostingLinks().add(hl);
//		hl.setName("hosted" + hl.getHosted().getName() + "In" + hl.getHost().getName()); //$NON-NLS-1$ //$NON-NLS-2$
//		assert hostee.getTopology().findHosts(hostee).length == 1 : "Topology.getHosts() error: returned " //$NON-NLS-1$
//				+ hostee.getTopology().findHosts(hostee).length
//				+ " hosts for hoster \"" + hoster.getName() //$NON-NLS-1$
//				+ "\" for hostee \"" + hostee.getName() + "\"; hostee contained in \"" + hostee.getParent().getName() //$NON-NLS-1$//$NON-NLS-2$
//				+ "\", hoster contained in \"" + hoster.getParent().getName() + "\""; //$NON-NLS-1$//$NON-NLS-2$
//		assert hostee.getTopology().findHosts(hostee)[0] == hoster;
//		return hl;
		return ResolutionUtils.host(hoster, hostee);
	}

	/**
	 * Checks if a given cell is hosted on a Base System
	 * 
	 * @param cell
	 * @return true if it is hosted on a Base System, false if not
	 */
	public static boolean isCellHostedOnBaseSystem(WasCellUnit cell) {
		Unit cellHost = ValidatorUtils.getHost(cell);
		if (cellHost != null && cellHost instanceof WasNodeUnit) {
			Unit nodeHost = ValidatorUtils.getHost(cellHost);
			if (nodeHost != null && nodeHost instanceof WasSystemUnit) {
				WasSystem wasSystemCap = (WasSystem) ValidatorUtils.getCapability(nodeHost,
						WasPackage.Literals.WAS_SYSTEM);
				if (wasSystemCap.getWasEdition().getLiteral().equals(
						WasEditionEnum.BASE_LITERAL.getLiteral())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * returns the first found Dmgr of a given cell
	 * 
	 * @param cell
	 * @return first Dmgr found in the cell. Null if no one is found.
	 */
	public static WasNodeUnit getDeploymentManager(WasCellUnit cell) {
		List<Unit> members = ValidatorUtils.getMembers(cell);
		for (Iterator iterator = members.iterator(); iterator.hasNext();) {
			Unit member = (Unit) iterator.next();
			if (member instanceof WasNodeUnit) {
				WasNode nodeCap = (WasNode) ValidatorUtils.getCapability(member,
						WasPackage.Literals.WAS_NODE);
				if (null != nodeCap) {
					// expect this to be non-null but check anyway
					if (nodeCap.getProfileType().getLiteral().equals(
							WasProfileTypeEnum.DMGR_LITERAL.getLiteral())) {
						return (WasNodeUnit) member;
					}
				}
			}
		}
		return null;

	}
}
