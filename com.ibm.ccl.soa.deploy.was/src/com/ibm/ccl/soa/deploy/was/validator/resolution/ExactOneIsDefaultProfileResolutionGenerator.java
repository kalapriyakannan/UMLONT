/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.validator.resolution;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum;
import com.ibm.ccl.soa.deploy.was.WasSystemUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.validator.IWASProblemType;

/**
 * Resolves {@link IWASProblemType#INVALID_NUMBER_DEFAULTPROFILE_WASNODE_ON_WASSYSTEM}
 */
public class ExactOneIsDefaultProfileResolutionGenerator extends DeployResolutionGenerator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#getResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		if (!(context.getDeployStatus().getDeployObject() instanceof WasSystemUnit)) {
			return EMPTY_RESOLUTION_ARRAY;
		}
		WasSystemUnit wasSystemUnit = (WasSystemUnit) context.getDeployStatus().getDeployObject();
		List<Capability> wasNodes = ValidatorUtils.discoverHostedCapabilities(wasSystemUnit,
				WasPackage.Literals.WAS_NODE, false, context.getProgressMonitor());

		List<IDeployResolution> resolutions = new ArrayList<IDeployResolution>(wasNodes.size());
		for (Capability nodeCap : wasNodes) {
			WasNode node = (WasNode) nodeCap;
			if (node.getProfileType() != WasProfileTypeEnum.NONE_LITERAL) {
				resolutions.add(new MakeThisNodeDefaultProfileResolution(context, this, wasSystemUnit,
						node, wasNodes));
			}
		}
		return resolutions.toArray(new IDeployResolution[resolutions.size()]);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#hasResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {
		if (!IWASProblemType.INVALID_NUMBER_DEFAULTPROFILE_WASNODE_ON_WASSYSTEM.equals(context
				.getDeployStatus().getProblemType())) {
			return false;
		}
		if (!(context.getDeployStatus().getDeployObject() instanceof WasSystemUnit)) {
			return false;
		}
		WasSystemUnit wasSystemUnit = (WasSystemUnit) context.getDeployStatus().getDeployObject();
		// Don't use discovery in the hasResolutions method
		List<Capability> wasNodes = ValidatorUtils.getHostedCapabilities(wasSystemUnit,
				WasPackage.Literals.WAS_NODE, false);
		int defaultCount = 0;
		for (Capability nodeCap : wasNodes) {
			WasNode node = (WasNode) nodeCap;
			if (node.isIsDefaultProfile()) {
				defaultCount++;
			}
		}
		for (Capability nodeCap : wasNodes) {
			WasNode node = (WasNode) nodeCap;
			if (node.getProfileType() != WasProfileTypeEnum.NONE_LITERAL
					&& DeployModelObjectUtil.isSettable(node,
							WasPackage.Literals.WAS_NODE__IS_DEFAULT_PROFILE)) {
				// Can be changed, but does it need to?
				if (defaultCount == 0) {
					return true;
				}
				if (defaultCount > 1 && node.isIsDefaultProfile()) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Resolution to make a {@link WasNode} the default profile.
	 */
	private static class MakeThisNodeDefaultProfileResolution extends DeployResolution {
		private final WasNode defaultNode;
		private final List<Capability> wasNodes;

		/**
		 * Make the was node the default.
		 * 
		 * @param context
		 *           the resolution context.
		 * @param generator
		 *           the parent generator.
		 * @param wasSystemUnit
		 *           the WAS system unit.
		 * @param defaultNode
		 *           the node to be made default.
		 * @param wasNodes
		 *           all the nodes of the system.
		 */
		public MakeThisNodeDefaultProfileResolution(IDeployResolutionContext context,
				IDeployResolutionGenerator generator, WasSystemUnit wasSystemUnit, WasNode defaultNode,
				List<Capability> wasNodes) {
			super(context, generator, DeployNLS.bind(
					WasDomainMessages.Resolution_make_wasNode_0_defaultProfile_of_wasSystemUnit_1,
					new Object[] { defaultNode, wasSystemUnit }));
			this.defaultNode = defaultNode;
			this.wasNodes = wasNodes;
		}

		/*
		 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#resolve(org.eclipse.core.runtime.IProgressMonitor)
		 */
		public IStatus resolve(IProgressMonitor monitor) {
			for (Capability curr : wasNodes) {
				WasNode currNode = (WasNode) curr;
				if (curr.equals(defaultNode)) {
					currNode.setIsDefaultProfile(true);
				} else {
					currNode.setIsDefaultProfile(false);
				}
			}
			return Status.OK_STATUS;
		}
	}
}
