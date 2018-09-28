/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.os.validator.resolution;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.os.OsDomainMessages;
import com.ibm.ccl.soa.deploy.os.OsFactory;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.Port;
import com.ibm.ccl.soa.deploy.os.PortConfigUnit;
import com.ibm.ccl.soa.deploy.os.PortConsumer;

/**
 * Creates a port configuration on the unit that is missing one.
 */
public class CreatePortResolution extends DeployResolution {

	/**
	 * Construct a resolution to create a port configuration on a unit.
	 * 
	 * @param context
	 *           the validation context.
	 * @param generator
	 *           the generator that instantiated this resolution.
	 */
	public CreatePortResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator) {
		super(context, generator, OsDomainMessages.Resolution_add_port_configuration);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#resolve(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		PortConsumer portConsumer = (PortConsumer) context.getDeployStatus().getDeployObject();
		Unit unit = (Unit) portConsumer.getParent();

		PortConfigUnit portConfigUnit = null;
		for (Unit target : ValidatorUtils.getHosted(unit)) {
			if (target == null || !(target instanceof PortConfigUnit)) {
				continue;
			}
			portConfigUnit = (PortConfigUnit) target;
			break;
		}

		// No port config unit exists: create one
		if (portConfigUnit == null) {
			Requirement req = CoreFactory.eINSTANCE.createRequirement();
			req.setName("hosting");//$NON-NLS-1$
			req.setDmoEType(OsPackage.eINSTANCE.getPortConsumer());
			req.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);

			portConfigUnit = OsFactory.eINSTANCE.createPortConfigUnit();
			portConfigUnit.setConfigurationUnit(true);
			portConfigUnit.getRequirements().add(req);
			unit.getEditTopology().getUnits().add(portConfigUnit);
			UnitUtil.assignUniqueName(portConfigUnit);

			LinkFactory.createHostingLink(unit, portConfigUnit);
		}

		// Add port to config unit.
		Port port = OsFactory.eINSTANCE.createPort();
		portConfigUnit.getCapabilities().add(port);
		UnitUtil.assignUniqueName(port);

		return Status.OK_STATUS;
	}
}
