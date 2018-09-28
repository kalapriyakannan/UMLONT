package com.ibm.ccl.soa.deploy.was.validator.resolution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.DeployResolutionStatus;
import com.ibm.ccl.soa.deploy.was.WasDeployPlugin;
import com.ibm.ccl.soa.deploy.was.internal.validator.DeployWasMessageFactory;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDeployStatus;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.validator.IWASProblemType;

/**
 * Resolution generator for resolutions to delete hosting links between units when there is more
 * than one of a particular type hosted on a common host.
 */
public class DeleteHostedUnitsResolutionGenerator extends DeployResolutionGenerator {

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		if (!hasResolutions(context)) {
			return null;
		}

		Unit unit = (Unit) context.getDeployStatus().getDeployObject();
		EClass type = (EClass) ((WasDeployStatus) context.getDeployStatus())
				.getAttribute(DeployWasMessageFactory.DELETION_DMO_TYPE);
		return new IDeployResolution[] { new UnhostOtherUnitsResolution(context, this, unit, type) };
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

		// verify that if a type is present then unit is a subtype of it
		if (!(status instanceof WasDeployStatus)) {
			return false;
		}
		WasDeployStatus wdStatus = (WasDeployStatus) status;
		Object t = wdStatus.getAttribute(DeployWasMessageFactory.DELETION_DMO_TYPE);
		if (!(t instanceof EClass)) {
			return false;
		}
		EClass type = (EClass) t;

		if (null != type) {
			if (!type.isSuperTypeOf(unit.getEObject().eClass())) {
				return false;
			}
		}

		Unit host = ValidatorUtils.discoverHost(unit, context.getProgressMonitor());
		if (null == host) {
			return false;
		}

		// verify that there are other hosted elements of type
		List<Unit> all = ValidatorUtils.discoverHosted(host, type, context.getProgressMonitor());
		if (1 >= all.size()) {
			return false;
		}

		// verify that we can delete the links (ie, they are in the edit topology)
		for (Unit u : all) {
			HostingLink lnk = ValidatorUtils.getHostingLink(u);
			if (lnk.getEditTopology() != lnk.getTopology()) {
				return false;
			}
		}

		return true;
	}

	private class UnhostOtherUnitsResolution extends DeployResolution {

		private final Unit _unit;
		private final EClass _type;

		/**
		 * Constructor
		 * 
		 * @param context
		 *           resolution context
		 * @param generator
		 *           resolution generator that created this resolution
		 * @param unit
		 *           unit that should be kept
		 * @param type
		 *           type of all units to be deleted
		 * @throws IllegalArgumentException
		 *            if unit is not a subtype of type
		 */
		public UnhostOtherUnitsResolution(IDeployResolutionContext context,
				IDeployResolutionGenerator generator, Unit unit, EClass type) {
			super(context, generator, WasDomainMessages.Resolution_unhost_other_units);

			_unit = unit;
			_type = type;

			if (!_type.isSuperTypeOf(_unit.getEObject().eClass())) {
				throw new IllegalArgumentException();
			}
		}

		public IStatus resolve(IProgressMonitor monitor) {
			Unit host = ValidatorUtils.discoverHost(_unit, context.getProgressMonitor());
			if (null == host) {
				// not hosted; we can claim success
				return Status.OK_STATUS;
			}

			List<Unit> hostees = ValidatorUtils.discoverHosted(host, _type, context
					.getProgressMonitor());
			List<Unit> failed = new ArrayList<Unit>();
			for (Unit hostee : hostees) {
				if (hostee.equals(_unit)) {
					continue;
				}
				HostingLink hLink = ValidatorUtils.getHostingLink(hostee);
				try {
					EcoreUtil.delete(hLink);
				} catch (Throwable t) {
					failed.add(hostee);
				}
			}
			if (0 == failed.size()) {
				return Status.OK_STATUS;
			}

			IStatus status = new Status(IStatus.ERROR, WasDeployPlugin.pluginID,
					WasDomainMessages.Resolution_unhost_other_units_failure);
			return new DeployResolutionStatus(status, Collections.emptyList(), failed);
		}
	}
}
