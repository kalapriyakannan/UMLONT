package com.ibm.ccl.soa.deploy.was.validator.resolution;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.was.validator.IWASProblemType;

/**
 * Resolution generator for resolution to delete the hosting link between a unit and its host.
 */
public class DeleteHostedUnitResolutionGenerator extends DeployResolutionGenerator {

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		if (!hasResolutions(context)) {
			return null;
		}

		Unit unit = (Unit) context.getDeployStatus().getDeployObject();
		return new IDeployResolution[] { new UnhostUnitResolution(context, this, ValidatorUtils
				.discoverHost(unit, context.getProgressMonitor()), unit) };
	}

	public boolean hasResolutions(IDeployResolutionContext context) {
		// validate the status
		IDeployStatus status = context.getDeployStatus();
		if (null == status) {
			return false;
		}

		// validate the problem type
		if (!IWASProblemType.UNIT_NOT_UNIQUE_ON_HOST.equals(status.getProblemType())) {
			return false;
		}

		// validate the object is a non-null unit
		DeployModelObject obj = status.getDeployObject();
		if (null == obj) {
			return false;
		}
		if (!CorePackage.Literals.UNIT.isSuperTypeOf(obj.getEObject().eClass())) {
			return false;
		}

		Unit unit = (Unit) obj;

		// verify that there is a hosting link in the model
		HostingLink hLink = ValidatorUtils.getHostingLink(unit);
		if (null == hLink) {
			return false;
		}

		// verify that we can delete the link (ie, they are in the edit topology)
		if (hLink.getEditTopology() != hLink.getTopology()) {
			return false;
		}

		return true;
	}
}
