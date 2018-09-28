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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.validator.IWASProblemType;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

public class ClusterDependingLinkSatisficationResolutionGenerator extends DeployResolutionGenerator {

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		if (IWasValidatorID.VALIDAT_WAS_CLUSTER_UNIT_DEPENDING_ON_WAS_NODEGROUP_UNIT_IN_DIFFERENT_CELL
				.equals(context.getDeployStatus().getValidatorID())) {
			assert context.getDeployStatus().getDeployObject() instanceof WasClusterUnit;
			WasClusterUnit clusterUnit = (WasClusterUnit) context.getDeployStatus().getDeployObject();
			assert clusterUnit != null;
			// TODO remove use of bindings to pass parameters; use attributes instead
			Object[] bindings = context.getDeployStatus().getBindings();
			assert bindings.length > 1;
			assert bindings[1] instanceof WasNodeGroupUnit;

			return new IDeployResolution[] { new CreateRemoveUnsatisfiedDependencyLinkResolution(
					context, this, clusterUnit, (WasNodeGroupUnit) bindings[1]) };

		}
		return null;
	}

	public boolean hasResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();
		if (null == status) {
			return false;
		}

		if (!IWASProblemType.WAS_CLUSTER_UNIT_DEPENDINGLINK_UNSATISFIED.equals(status
				.getProblemType())) {
			return false;
		}

		DeployModelObject obj = status.getDeployObject();
		if (!WasPackage.Literals.WAS_CLUSTER_UNIT.isSuperTypeOf(obj.getEObject().eClass())) {
			return false;
		}

		WasClusterUnit cluster = (WasClusterUnit) obj;

		// check that resolution will have permissions to do what it wants:
		// (a) remove dependency link
		// ie, link is in the edit topology
		Requirement req = ValidatorUtils.getFirstRequirement(cluster,
				WasPackage.Literals.WAS_NODE_GROUP);
		if (null == req) {
			return false;
		}
		DependencyLink link = req.getLink();
		if (null == link) {
			return false;
		}
		if (link.getTopology() != link.getEditTopology()) {
			return false;
		}

		return true;
	}

	private static class CreateRemoveUnsatisfiedDependencyLinkResolution extends DeployResolution {
		private final WasClusterUnit _clusterUnit;

		//private WasNodeGroupUnit _nodeGroupUnit;

		public CreateRemoveUnsatisfiedDependencyLinkResolution(IDeployResolutionContext context,
				IDeployResolutionGenerator generator, WasClusterUnit clusterUnit,
				WasNodeGroupUnit nodeGroupUnit) {
			super(context, generator, DeployNLS.bind(
					WasDomainMessages.Resolution_unlink_Unit_0_with_Unit_1, clusterUnit, nodeGroupUnit));
			_clusterUnit = clusterUnit;
			//_nodeGroupUnit = nodeGroupUnit;
		}

		public IStatus resolve(IProgressMonitor monitor) {
			Requirement req = ValidatorUtils.getFirstRequirement(_clusterUnit,
					WasPackage.Literals.WAS_NODE_GROUP);
			assert req != null;
			DependencyLink link = req.getLink();
			assert link != null;
			req.setLink(null);
			return Status.OK_STATUS;
		}

	}

}
