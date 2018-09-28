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
import com.ibm.ccl.soa.deploy.core.util.CapabilityUtil;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.action.ActionPreconditionTest;
import com.ibm.ccl.soa.deploy.core.validator.pattern.action.IActionPreconditionTest;
import com.ibm.ccl.soa.deploy.core.validator.pattern.action.ISignature;
import com.ibm.ccl.soa.deploy.core.validator.pattern.action.UnitSignature;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasEditionEnum;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSystemUnit;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.internal.validator.util.WasValidationUtil;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * Precondition test to determine if a {@link WebsphereAppServerUnit} can be used as a template to
 * create a {@link WasClusterUnit}. See {@link PromoteServerToNewClusterAction}.
 * <p>
 * The preconditions tested for are:
 * <ul>
 * <li>(A) the parameters are defined and of the correct types</li>
 * <li>(B) server is not already in a cluster</li>
 * <li>(C) if server hosted on a system, the system is ND</li>
 * <li>(D) if server in cell, the cell is distributed</li>
 * <li>(E) if server is in cell, server version is less than cell version</li>
 * <li>(F) permissions exist to make the desired changes</li>
 * </ul>
 */
public class PromoteServerToNewClusterActionTest extends ActionPreconditionTest implements
		IActionPreconditionTest {

	private static final int NUMBER_EXPECTED_PARAMETERS = 1;
	private static final int SERVER_UNIT_PARAMETER_INDEX = 0;

	/**
	 * Constructor
	 */
	public PromoteServerToNewClusterActionTest() {
		super(IWasValidatorID.WAS_PROMOTE_SERVER_TO_NEW_CLUSTER, new UnitSignature(
				new EClass[] { WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT }));
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

		return true;
	}

	@Override
	public void testActionPreconditions(List<DeployModelObject> parameters,
			IDeployValidationContext context, IDeployReporter reporter) {

		//    (A) the parameters are defined and of the correct types
		if (!appliesTo(parameters)) {
			return;
		}

		// extract parameters
		WebsphereAppServerUnit server = (WebsphereAppServerUnit) parameters.get(0);
		IProgressMonitor monitor = context.getProgressMonitor();

		//    (B) server is not already in a cluster
		if (null != ValidatorUtils.discoverGroupByUnitType(server,
				WasPackage.Literals.WAS_CLUSTER_UNIT, monitor)) {
			return;
		}

		//    (C) if hosted on a system, the system is ND
		WasSystemUnit system = (WasSystemUnit) ValidatorUtils.discoverHostInStack(server,
				WasPackage.Literals.WAS_SYSTEM_UNIT, monitor);
		if (null != system) {
			if (!WasValidationUtil.attributeValueEquals(system,
					WasPackage.Literals.WAS_SYSTEM__WAS_EDITION, WasPackage.Literals.WAS_SYSTEM,
					WasEditionEnum.NETWORK_DEPLOYMENT_LITERAL, false)) {
				return;
			}
		}

		// keep track of cell if it can be found
		WasCellUnit foundCell = null;

		//    (D) if server in cell, the cell is distributed
		WasNodeUnit node = (WasNodeUnit) ValidatorUtils.discoverHost(server,
				WasPackage.Literals.WAS_NODE_UNIT, monitor);
		if (null != node) {
			List<Unit> cells = ValidatorUtils.discoverGroupsByUnitType(node,
					WasPackage.Literals.WAS_CELL_UNIT, context.getTopology(), monitor);
			for (Unit cell : cells) {
				Object dist = CapabilityUtil.getAttributeFromUnitCapability(cell,
						WasPackage.Literals.WAS_CELL__IS_DISTRIBUTED, WasPackage.Literals.WAS_CELL);
				if (null == dist) {
					continue;
				}
				if (((Boolean) dist).booleanValue()) {
					foundCell = (WasCellUnit) cell;
					break;
				}
			}
		}

		//    (E) if server is in cell, server version is less than cell version
		if (null != foundCell) {
			Object version = CapabilityUtil.getAttributeFromUnitCapability(foundCell,
					WasPackage.Literals.WAS_CELL__WAS_VERSION, WasPackage.Literals.WAS_CELL);
			if (null == version) {
				return;
			}
			String cellVersion = (String) version;

			version = CapabilityUtil.getAttributeFromUnitCapability(server,
					WasPackage.Literals.WAS_SERVER__WAS_VERSION, WasPackage.Literals.WAS_SERVER);
			if (null == version) {
				return;
			}
			String serverVersion = (String) version;

			if (cellVersion.startsWith(WasUtil.WAS_5_MAIN_VERSION)) {
				if (!serverVersion.startsWith(WasUtil.WAS_5_MAIN_VERSION)) {
					return;
				}
			}
		}

		//    (F) permissions exist to make the desired changes
		//    (a) create new cluster
		//    (b) host cluster on cell (if it exists)
		//    (c) unhost things from server
		//    (d) host things on the cluster
		//    (e) add server to cluster

		//    (a) create new cluster
		// can always create new cluster from templates

		//    (b) host cluster on cell (if it exists)
		if (null != foundCell) {
			if (!foundCell.isPublic()) {
				return;
			}
		}

		//    (c) unhost things from server
		// only possible if the server is in the current topology
		if (server.getTopology() != server.getEditTopology()) {
			return;
		}

		//    (d) host things on the cluster
		// cluster is new so in edit topology so can always do so

		//    (e) add server to cluster
		// server and cluster are in edit topology so always possible

		// the preconditions hold; we create an INFO status to trigger the action
		reporter.addStatus(WasValidationUtil.createActionPreconditionValid(getId(),
				WasDomainMessages.Action_Promote_Server_To_New_Cluster_0, new Object[] { server
						.getCaptionProvider().title(server) }, server, parameters));
	}
}
