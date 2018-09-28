/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator.action;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.action.ActionPreconditionTest;
import com.ibm.ccl.soa.deploy.core.validator.pattern.action.IActionPreconditionTest;
import com.ibm.ccl.soa.deploy.core.validator.pattern.action.ISignature;
import com.ibm.ccl.soa.deploy.core.validator.pattern.action.UnitSignature;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasEditionEnum;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSystemUnit;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.internal.validator.util.WasValidationUtil;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * Precondition test to determine if a {@link WebsphereAppServerUnit} can be added to an existing
 * {@link WasClusterUnit}. See {@link PromoteServerToExistingClusterAction}.
 * <p>
 * The preconditions tested for are:
 * <ul>
 * <li>(A) the parameters are defined and of the correct types</li>
 * <li>(B) server is not already in a cluster</li>
 * <li>(C) if server is hosted on a node and the node on a system check that the system is ND</li>
 * <li>(D) if server is hosted on a node and the node is in a cell, then the cluster is hosted on
 * the cell</li>
 * <li>(E) permissions exist to make the desired changes</li>
 * </ul>
 */
public class PromoteServerToExistingClusterActionTest extends ActionPreconditionTest implements
		IActionPreconditionTest {

	private static final int NUMBER_EXPECTED_PARAMETERS = 2;
	private static final int SERVER_UNIT_PARAMETER_INDEX = 0;
	private static final int CLUSTER_UNIT_PARAMETER_INDEX = 1;

	/**
	 * Constructor
	 */
	public PromoteServerToExistingClusterActionTest() {
		super(IWasValidatorID.WAS_PROMOTE_SERVER_TO_EXISTING_CLUSTER, new UnitSignature(new EClass[] {
				WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT, WasPackage.Literals.WAS_CLUSTER_UNIT }));
	}

	@Override
	public boolean appliesTo(ISignature signature) {
		// check number of parameters
		if (NUMBER_EXPECTED_PARAMETERS != signature.getNumberParameters()) {
			return false;
		}

		// check that parameters are not null
		for (int i = 0; i < NUMBER_EXPECTED_PARAMETERS; i++) {
			if (null == signature.get(i)) {
				return false;
			}
		}

		// check types of parameters
		if (!WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT.isSuperTypeOf(signature
				.get(SERVER_UNIT_PARAMETER_INDEX))) {
			return false;
		}

		if (!WasPackage.Literals.WAS_CLUSTER_UNIT.isSuperTypeOf(signature
				.get(CLUSTER_UNIT_PARAMETER_INDEX))) {
			return false;
		}

		return true;
	}

	@Override
	public void testActionPreconditions(List<DeployModelObject> parameters,
			IDeployValidationContext context, IDeployReporter reporter) {

		// (A) the parameters are defined and of the correct types
		if (!appliesTo(parameters)) {
			return;
		}

		// extract parameters
		WebsphereAppServerUnit server = (WebsphereAppServerUnit) parameters
				.get(SERVER_UNIT_PARAMETER_INDEX);
		WasClusterUnit cluster = (WasClusterUnit) parameters.get(CLUSTER_UNIT_PARAMETER_INDEX);
		IProgressMonitor monitor = context.getProgressMonitor();

		// (B) server is not already in a cluster
		if (ValidatorUtils.discoverGroupByCapabilityType(server, WasPackage.Literals.WAS_CLUSTER,
				monitor) != null) {
			return;
		}

		WasNodeUnit node = (WasNodeUnit) ValidatorUtils.discoverHost(server,
				WasPackage.Literals.WAS_NODE_UNIT, monitor);
		if (null != node) {
			// (C) if server is hosted on a node and the node on a system check that the system is ND
			WasSystemUnit system = (WasSystemUnit) ValidatorUtils.discoverHost(node,
					WasPackage.Literals.WAS_SYSTEM_UNIT, monitor);
			if (null != system) {
				if (!WasValidationUtil.attributeValueEquals(system,
						WasPackage.Literals.WAS_SYSTEM__WAS_EDITION, WasPackage.Literals.WAS_SYSTEM,
						WasEditionEnum.NETWORK_DEPLOYMENT_LITERAL, true)) {
					return;
				}
//				WasEditionEnum edition = (WasEditionEnum) CapabilityUtil
//						.getAttributeFromUnitCapability(system,
//								WasPackage.Literals.WAS_SYSTEM__WAS_EDITION, WasPackage.Literals.WAS_SYSTEM);
//				if (null != edition) {
//					if (!WasEditionEnum.NETWORK_DEPLOYMENT_LITERAL.equals(edition)) {
//						return;
//					}
//				}
			}
			// (D) if server is hosted on a node and the node is in a cell, then the cluster is hosted on the cell
			WasCellUnit cell = (WasCellUnit) ValidatorUtils.discoverHost(cluster,
					WasPackage.Literals.WAS_CELL_UNIT, monitor);
			if (null != cell) {
				List<Unit> cells = ValidatorUtils.discoverGroupsByUnitType(node,
						WasPackage.Literals.WAS_CELL_UNIT, context.getTopology(), monitor);
				if (cells.size() != 0) {
					boolean foundCell = false;
					for (Unit candidate : cells) {
						if (candidate == cell) {
							foundCell = true;
							break;
						}
					}
					if (!foundCell) {
						return;
					}
				}
			}
		}

//		Unit hostNode = null;
//		//check if Server is hosted on a node
//		hostNode = ValidatorUtils.getHost(server);
//		if (hostNode == null || !(hostNode instanceof WasNodeUnit)) {
//			return;
//		}
//
//		//check if the node is contained in a Cell and Cluster hosted on the same Cell
//		WasCellUnit serverCell = (WasCellUnit) ValidatorUtils.discoverGroupByUnitType(hostNode,
//				WasPackage.Literals.WAS_CELL_UNIT, monitor);
//		if (serverCell == null) {
//			return;
//		}
//
//		Capability cellCap = ValidatorUtils.getHostCapability(cluster, WasPackage.Literals.WAS_CELL);
//		if (cellCap == null) {
//			return;
//		}
//		WasCellUnit clusterCell = (WasCellUnit) cellCap.getParent();
//		if (clusterCell == null) {
//			return;
//		}
//
//		if (!serverCell.equals(clusterCell)) {
//			return;
//		}
//
//		//check if node is hosted on a WasSystem
//		hostNode = ValidatorUtils.getHost(hostNode);
//		if (hostNode == null || !(hostNode instanceof WasSystemUnit)) {
//			return;
//		}
//
//		//check if WasSystem is Network Deployment
//		WasSystem wasCap = (WasSystem) ValidatorUtils.getCapabilities(hostNode,
//				WasPackage.eINSTANCE.getWasSystem()).get(0);
//		if (wasCap == null
//				|| !wasCap.getWasEdition().equals(WasEditionEnum.NETWORK_DEPLOYMENT_LITERAL)) {
//			return;
//		}

		// (E) permissions exist to make the desired changes
		//    (a) unhost things from server
		//    (b) host things on the cluster
		//    (c) add server to cluster

		//    (a) unhost things from server
		// only possible if the server is in the current topology
		if (server.getTopology() != server.getEditTopology()) {
			return;
		}

		//    (b) host things on the cluster
		if (!cluster.isPublic()) {
			return;
		}
		// need to check that each hosted item is public
		//host most things hosted on the server on the cluster
		List<Unit> hostedUnits = ValidatorUtils.discoverHosted(server, context.getProgressMonitor());
		for (Unit hosted : hostedUnits) {
//		for (Iterator<Unit> iterator = hostedUnits.iterator(); iterator.hasNext();) {
//			Unit hosted = iterator.next();
			EClass hostedType = hosted.getEObject().eClass();
			if (OsPackage.Literals.PORT_CONFIG_UNIT.isSuperTypeOf(hostedType)
					|| WasPackage.Literals.WAS_CLASS_LOADER_CONFIGURATION_UNIT.isSuperTypeOf(hostedType)) {
				// don't want to rehost these
				continue;
			}
			if (!hosted.isPublic()) {
				return;
			}
		}

		//    (c) add server to cluster
		if (!server.isPublic()) {
			return;
		}

		// the preconditions hold; we create an INFO status to trigger the action
		reporter.addStatus(WasValidationUtil.createActionPreconditionValid(getId(),
				WasDomainMessages.Action_Promote_Server_To_Existing_Cluster_0, new Object[] { server
						.getCaptionProvider().title(server) }, server, parameters));
	}
}
