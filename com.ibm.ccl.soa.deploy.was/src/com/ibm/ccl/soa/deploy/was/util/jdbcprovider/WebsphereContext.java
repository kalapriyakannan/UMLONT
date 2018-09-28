/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.util.jdbcprovider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DiscoveryFilter;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.DiscoveryFilterFactory;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSubstitutionVariable;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.util.WasValidationUtil;

/**
 * References to the various WebSphere units from the hosting container (server or cluster) to the
 * cell.
 */
public class WebsphereContext {

	/** the WebSphere Application Server if defined */
	private WebsphereAppServerUnit wasServer = null;

	/** The WebSphere Cluster if defined */
	private WasClusterUnit wasCluster = null;

	/** The node the Application Server is a member of */
	private WasNodeUnit wasNode = null;

	/** The cell the node or cluster is a member of */
	private WasCellUnit wasCell = null;

	/** {@link UnitDescriptor} of the {@link wasNode} */
	private UnitDescriptor wasNodeUD;

	/** {@link UnitDescriptor} of the {@link wasCell} */
	private UnitDescriptor wasCellUD;

	/** The topology containing the hosting container */
	private final Topology topology;

	/**
	 * Constructor builds context from hosting container.
	 * 
	 * @param wasUnit
	 *           the application hosting container, either a {@link WebsphereAppServerUnit} or a
	 *           {@link WasClusterUnit}
	 */
	public WebsphereContext(Unit wasUnit) {
		topology = wasUnit.getTopology();

		if (wasUnit instanceof WebsphereAppServerUnit) {
			// if hosting container is an application server, find node and cell
			wasServer = (WebsphereAppServerUnit) wasUnit;
			wasNodeUD = getWasNodeUD(wasServer, topology);
			if (null != wasNodeUD) {
				wasNode = (WasNodeUnit) wasNodeUD.getUnitValue();
				wasCellUD = getWasCellUD(wasNode, topology);
				if (null != wasCellUD) {
					wasCell = (WasCellUnit) wasCellUD.getUnitValue();
				}
			}
		} else if (wasUnit instanceof WasClusterUnit) {
			// if hosting container is a cluster, find cell
			wasCluster = (WasClusterUnit) wasUnit;
			wasCellUD = getWasCellUD(wasCluster, topology);
			if (null != wasCellUD) {
				wasCell = (WasCellUnit) wasCellUD.getUnitValue();
			}
		}
	}

	/**
	 * Add node unit to the topology if it has not already been added.
	 * 
	 * @return the node unit
	 */
	public WasNodeUnit addNodeToTopology() {
		if (null == wasNodeUD) {
			return null;
		}
		return (WasNodeUnit) wasNodeUD.getUnitValueAndAddToTopology(topology);
	}

	/**
	 * Return the {@link WebsphereAppServerUnit}
	 * 
	 * @return the cell unit
	 */
	public WebsphereAppServerUnit getServerUnit() {
		return wasServer;
	}

	/**
	 * Return the {@link WasClusterUnit}
	 * 
	 * @return the cell unit
	 */
	public WasClusterUnit getClusterUnit() {
		return wasCluster;
	}

	/**
	 * Return the {@link WasNodeUnit}
	 * 
	 * @return the cell unit
	 */
	public WasNodeUnit getNodeUnit() {
		return wasNode;
	}

	/**
	 * Return the {@link WasCellUnit}
	 * 
	 * @return the cell unit
	 */
	public WasCellUnit getCellUnit() {
		return wasCell;
	}

	/**
	 * Add the cell unit to the topology if it has not already been added.
	 * 
	 * @return the cell unit
	 */
	public WasCellUnit addCellToTopology() {
		if (null == wasCellUD) {
			return null;
		}
		return (WasCellUnit) wasCellUD.getUnitValueAndAddToTopology(topology);
	}

	/**
	 * Determine if a given unit is a Websphere unit (server, node, cluster or cell) in this context.
	 * 
	 * @param unit
	 *           the unit to check
	 * @return true if is in the context; false otherwise
	 */
	public boolean isInContext(Unit unit) {
		if (unit == null) {
			return false;
		}
		if (unit == wasServer) {
			return true;
		}
		if (unit == wasNode) {
			return true;
		}
		if (unit == wasCluster) {
			return true;
		}
		if (unit == wasCell) {
			return true;
		}

		return false;
	}

	/**
	 * Retrieve the {@link UnitDescriptor} of the node containing an application server
	 * 
	 * @param was
	 *           the application server (need not be in the target topology)
	 * @param topology
	 *           the target topology
	 * @return the {@link UnitDescriptor} of the node
	 */
	public static UnitDescriptor getWasNodeUD(WebsphereAppServerUnit was, Topology topology) {
		UnitDescriptor ud = TopologyDiscovererService.INSTANCE.findHostUD(was, topology);
		if (null == ud) {
			ud = getGroup(was, WasPackage.Literals.WAS_NODE_UNIT, topology);
		}

		return ud;
	}

	/**
	 * Retrieve the {@UnitDescriptor} of the cell containing a node
	 * 
	 * @param node
	 *           the node (need not be in the target topology)
	 * @param topology
	 *           the target topology
	 * @return the {@link UnitDescriptor} of the cell
	 */
	public static UnitDescriptor getWasCellUD(WasNodeUnit node, Topology topology) {
		return getGroup(node, WasPackage.Literals.WAS_CELL_UNIT, topology);
	}

	/**
	 * Retrieve the {@UnitDescriptor} of the cell containing a cluster
	 * 
	 * @param cluster
	 *           the cluster (need not be in the target topology)
	 * @param topology
	 *           the target topology
	 * @return the {@link UnitDescriptor} of the cell
	 */
	public static UnitDescriptor getWasCellUD(WasClusterUnit cluster, Topology topology) {
		// MK 1/9/2007 get cell directly from cluster instead of via the nodeGorup
//		WasNodeGroupUnit nodeGroup = getWasNodeGroup(cluster, topology);
//		if (null == nodeGroup)
//			return null;
//		return getGroup(nodeGroup, WasPackage.Literals.WAS_CELL_UNIT, topology);

		// MK 4/8/2007 cluster hosted on cell; not group member
		// return getGroup(cluster, WasPackage.Literals.WAS_CELL_UNIT, topology);
		return ValidatorUtils.discoverHostUDInStack(cluster, WasPackage.Literals.WAS_CELL_UNIT, null);
	}

	/**
	 * Retrieve the node group from which cluster members are drawn
	 * 
	 * @param cluster
	 *           the cluster
	 * @param topology
	 *           the target topology
	 * @return the node group
	 */
	public static WasNodeGroupUnit getWasNodeGroup(WasClusterUnit cluster, Topology topology) {
		return (WasNodeGroupUnit) TopologyDiscovererService.INSTANCE.findTarget(cluster,
				WasPackage.Literals.WAS_NODE_GROUP, topology);
	}

	/**
	 * Get the node members of a node group
	 * 
	 * @param nodeGroup
	 *           the node group (need not be in the target topology)
	 * @param topology
	 *           the target topology
	 * @return list of nodes in the node group
	 */
	public static List<Unit> getWasNodes(WasNodeGroupUnit nodeGroup, Topology topology) {
		return getMembers(nodeGroup, WasPackage.Literals.WAS_NODE_UNIT, topology);
	}

	/**
	 * Get the node members of a cell
	 * 
	 * @param cell
	 *           the cell (need not be a in the target topology)
	 * @param topology
	 *           the target topology
	 * @return list of nodes in the cell
	 */
	public static List<Unit> getWasNodes(WasCellUnit cell, Topology topology) {
		return getMembers(cell, WasPackage.Literals.WAS_NODE_UNIT, topology);
	}

	/**
	 * Get the nodes related to a WebSphere unit (members of a cell, members of node group associated
	 * with a cluster, members of a node group, or the node to which a server is a member)
	 * 
	 * @param wasUnit
	 *           the WebSphere unit (need not be in the target topology)
	 * @param topology
	 *           the target topology
	 * @return the list of related nodes
	 */
	public static List<Unit> getWasNodes(Unit wasUnit, Topology topology) {
		List<Unit> nodes = new ArrayList<Unit>();

		if (wasUnit instanceof WasCellUnit) {
			nodes = getWasNodes((WasCellUnit) wasUnit, topology);
		} else if (wasUnit instanceof WasClusterUnit) {
			WasNodeGroupUnit nodeGroup = getWasNodeGroup((WasClusterUnit) wasUnit, topology);
			nodes = getWasNodes(nodeGroup, topology);
		} else if (wasUnit instanceof WasNodeUnit) {
			nodes.add(wasUnit);
		} else if (wasUnit instanceof WebsphereAppServerUnit) {
			UnitDescriptor nodeUD = getWasNodeUD((WebsphereAppServerUnit) wasUnit, topology);
			nodes.add(nodeUD.getUnitValue());
		} else {
			// don't recognize it; return empty list
		}

		return nodes;
	}

	/**
	 * Get the nodes related to a WebSphere unit because the nodes contain servers of a cluster.
	 * 
	 * @param wasUnit
	 *           the WebSphere unit (need not be in the target topology)
	 * @param topology
	 *           the target topology
	 * @return the list of related nodes
	 */
	public static List<Unit> getHostingNodes(Unit wasUnit, Topology topology) {
		List<Unit> nodes = new ArrayList<Unit>();
		if (wasUnit instanceof WebsphereAppServerUnit) {
			UnitDescriptor nodeUD = getWasNodeUD((WebsphereAppServerUnit) wasUnit, topology);
			nodes.add(nodeUD.getUnitValue());
		} else if (wasUnit instanceof WasClusterUnit) {
			List<Unit> servers = getMembers(wasUnit, WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT,
					topology);
			for (int i = 0; i < servers.size(); i++) {
				WebsphereAppServerUnit server = (WebsphereAppServerUnit) servers.get(i);
				WasNodeUnit parentNode = null;
				List<Unit> parentNodes = getWasNodes(server, topology);
				if (parentNodes.size() == 1) { // otherwise error so skip
					parentNode = (WasNodeUnit) parentNodes.get(0);
					// nodes.add(parentNode);
					boolean alreadyAdded = false;
					for (int j = 0; j < nodes.size(); j++) {
						WasNodeUnit node = (WasNodeUnit) nodes.get(j);
						if (node.getName().equals(parentNode.getName())) {
							alreadyAdded = true;
							break;
						}
					}
					if (!alreadyAdded) {
						nodes.add(parentNode);
					}
				}
			}
		} else {
			// not a valid host; return empty list
		}

		return nodes;
	}

	// TODO move the following utility methods to a more general location; they
	// are reusable elsewhere

	/**
	 * Retrieve the {@link UnitDescriptor} of the group (of a particular type) to which a member unit
	 * belongs
	 * 
	 * @param member
	 *           the member unit
	 * @param type
	 *           the {@link EClass} of the group
	 * @param topology
	 *           the target topology
	 * @return the {@link UnitDescriptor} of the group
	 */
	public static UnitDescriptor getGroup(Unit member, EClass type, Topology topology) {
		List<UnitDescriptor> groups = TopologyDiscovererService.INSTANCE.getGroups(member, null,
				member.getTopology(), new NullProgressMonitor());
		for (Iterator<UnitDescriptor> iter = groups.iterator(); iter.hasNext();) {
			UnitDescriptor descr = iter.next();
			Unit unit = descr.getUnitValue();
			if (type.isInstance(unit)) {
				return descr;
			}
		}

		return null;
//
//		Requirement req = getMemberRequirement(member, type);
//		if (null == req) {
//			return null;
//		}
//
//		DiscoveryFilter filter = DiscoveryFilterFactory.createFindGroupsFilter(member, req, topology);
//		List<UnitDescriptor> nodeUd = TopologyDiscovererService.INSTANCE.findAll(filter);
//		assert 1 == nodeUd.size();
//		return nodeUd.get(0);
	}

	/**
	 * Retrive the members of a particular {@link EClass} from a group
	 * 
	 * @param group
	 *           the group (need not be in the target topology)
	 * @param type
	 *           the {@link EClass} of desired members
	 * @param topology
	 *           the target topology
	 * @return a list of members (as {@link Unit}s)
	 */
	public static List<Unit> getMembers(Unit group, EClass type, Topology topology) {
		List<Unit> members = new ArrayList<Unit>();

		Requirement req = getMemberRequirement(group, type);
		if (null == req) {
			return members;
		}

		DiscoveryFilter filter = DiscoveryFilterFactory.createFindMembersFilter(group, req, topology);
		List<UnitDescriptor> nodeUd = TopologyDiscovererService.INSTANCE.findAll(filter);
		for (int i = 0; i < nodeUd.size(); i++) {
			members.add(nodeUd.get(i).getUnitValue());
		}

		return members;
	}

	/**
	 * Retrieve the member requirement for a given {@link EClass} type
	 * 
	 * @param unit
	 *           the group
	 * @param type
	 *           the {@link EClass} of desired members
	 * @return the member requirement defined for such members
	 */
	private static Requirement getMemberRequirement(Unit unit, EClass type) {
		Requirement req = null;
		for (Iterator<Requirement> rIt = unit.getMemberOrAnyRequirements().iterator(); rIt.hasNext();) {
			Requirement groupReq = rIt.next();
			if (type.isSuperTypeOf(groupReq.getDmoEType())) {
				req = groupReq;
				break;
			}
		}
		return req;
	}

	/**
	 * Retrieve the (scoped) value of a substitution variable.
	 * 
	 * @param variableName
	 *           the variable name
	 * @return the value
	 */
	public Object getSubstitutionVariableValue(String variableName) {
		ExtendedAttribute attr = getSubstitutionVariableAttribute(variableName);
		if (null == attr) {
			return null;
		}
		return getSubstitutionVariableValue(attr);
	}

	private Object getSubstitutionVariable(Unit wasUnit, String variableName) {
		ExtendedAttribute attr = getSubstitutionVariableAttribute(wasUnit, variableName);

		return attr.getValue();
	}

	private ExtendedAttribute getSubstitutionVariableAttribute(String variableName) {
		if (null != wasServer) {
			ExtendedAttribute value = getSubstitutionVariableAttribute(wasServer, variableName);
			if (null != value) {
				return value;
			}
		}

		if (null != wasNode) {
			ExtendedAttribute value = getSubstitutionVariableAttribute(wasNode, variableName);
			if (null != value) {
				return value;
			}
		}

		if (null != wasCluster) {
			ExtendedAttribute value = getSubstitutionVariableAttribute(wasCluster, variableName);
			if (null != value) {
				return value;
			}
		}

		if (null != wasCell) {
			ExtendedAttribute value = getSubstitutionVariableAttribute(wasCell, variableName);
			if (null != value) {
				return value;
			}
		}

		return null;
	}

	private ExtendedAttribute getSubstitutionVariableAttribute(Unit wasUnit, String variableName) {
		if (null == wasUnit) {
			return null;
		}

		WasSubstitutionVariable vars = (WasSubstitutionVariable) ValidatorUtils.getFirstCapability(
				wasUnit, WasPackage.Literals.WAS_SUBSTITUTION_VARIABLE);
		if (null == vars) {
			return null;
		}

		ExtendedAttribute attr = vars.getExtendedAttribute(variableName);
		if (null == attr) {
			return null;
		}

		return attr;
	}

	private Object getSubstitutionVariableValue(ExtendedAttribute attr) {
		if (null == attr) {
			return null;
		}
		return attr.getValue();
	}

	public String[] getSubstitutionVariables(String str) {
		List variableNameList = WasValidationUtil.parseUsingVariables(str);
		String[] result = new String[variableNameList.size()];
		for (int i = 0; i < variableNameList.size(); i++) {
			result[i] = (String) variableNameList.get(i);
		}
		return result;
	}

	public boolean checkExistence(String variableName) {
		ExtendedAttribute attr = getSubstitutionVariableAttribute(variableName);
		return null != attr;
	}

	public boolean checkExistence(String variableName, Unit wasUnit) {
		ExtendedAttribute attr = getSubstitutionVariableAttribute(wasUnit, variableName);
		return null != attr;
	}

	public void addNewSubstitutionVariable(String variableName, Unit wasUnit) {
		if (null == wasUnit) {
			return;
		}

		// do nothing if it already exists
		if (checkExistence(variableName, wasUnit)) {
			return;
		}

		WasSubstitutionVariable var = (WasSubstitutionVariable) ValidatorUtils.getFirstCapability(
				wasUnit, WasPackage.Literals.WAS_SUBSTITUTION_VARIABLE);
		if (null == var) {
			return;
		}

		ExtendedAttribute attr = CoreFactory.eINSTANCE.createExtendedAttribute();
		attr.setName(variableName);
		attr.setValue(""); //$NON-NLS-1$
		var.getExtendedAttributes().add(attr);
	}
}
