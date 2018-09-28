/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.os.validator.pattern.capability;

import java.util.List;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.capability.UnitCapabilityValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.os.OsDomainMessages;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.Port;
import com.ibm.ccl.soa.deploy.os.PortConsumer;
import com.ibm.ccl.soa.deploy.os.validator.pattern.attribute.IOsDomainValidators;
import com.ibm.ccl.soa.deploy.os.validator.pattern.attribute.IOsProblemType;

/**
 * {@link PortConsumer} capability validator.
 * <p>
 * Validates that a unit with a port consumer capability hosts a port.
 */
public class PortConsumerValidator extends UnitCapabilityValidator {

	/** Constant used to indicate an unbounded number of ports. */
	public static final int PORT_COUNT_ANY = -1;

	protected int minPorts = 0;

	protected int maxPorts = PORT_COUNT_ANY;

	/**
	 * Construct a {@link PortConsumer} capability validator.
	 */
	public PortConsumerValidator() {
		super(OsPackage.eINSTANCE.getPortConsumer());
	}

	/**
	 * Construct a {@link PortConsumer} capability validator.
	 * 
	 * @param minPorts
	 *           minimum number of ports.
	 * @param maxPorts
	 *           maximum number of ports.
	 */
	public PortConsumerValidator(int minPorts, int maxPorts) {
		super(OsPackage.eINSTANCE.getPortConsumer());
		setMinPorts(minPorts);
		setMaxPorts(maxPorts);
	}

	/**
	 * @return the maximum number of {@link Port} capabilities provided by hosted configuration units
	 *         {@link #PORT_COUNT_ANY}.
	 */
	public int getMaxPorts() {
		return maxPorts;
	}

	/**
	 * Set the maximum number of {@link Port} capabilities provided by hosted configuration units.
	 * 
	 * @param minPorts
	 *           minimum number of ports (greater or equal to zero).
	 */
	public void setMaxPorts(int maxPorts) {
		if (maxPorts >= 0) {
			assert maxPorts >= minPorts;
		} else {
			assert maxPorts == PORT_COUNT_ANY;
		}
		this.maxPorts = maxPorts;
	}

	/**
	 * @return the minimum number of {@link Port} capabilities provided by hosted configuration
	 *         units.
	 */
	public int getMinPorts() {
		return minPorts;
	}

	/**
	 * Set the minimum number of {@link Port} capabilities provided by hosted configuration units.
	 * 
	 * @param minPorts
	 *           minimum number of ports (greater or equal to zero).
	 */
	public void setMinPorts(int minPorts) {
		assert minPorts >= 0;
		this.minPorts = minPorts;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.pattern.capability.UnitCapabilityValidator#validateCapability(com.ibm.ccl.soa.deploy.core.Capability,
	 *      com.ibm.ccl.soa.deploy.core.Unit,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	@Override
	public void validateCapability(Capability capability, Unit unit,
			IDeployValidationContext context, IDeployReporter reporter) {
		super.validateCapability(capability, unit, context, reporter);

		int count = 0;
		for (Unit target : ValidatorUtils.getHosted(unit)) {
			if (target == null) {
				continue;
			}
			for (Capability cap : (List<Capability>) target.getCapabilities()) {
				if (cap instanceof Port && accept((Port) cap)) {
					count++;
				}
			}
		}

		if (count < minPorts) {
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
					IOsDomainValidators.PORT_CONSUMER_001, IOsProblemType.PORT_CONFIG_MISSING,
					OsDomainMessages.Validator_port_consumer_missing_hosted_port,
					new Object[] { capability }, capability);
			reporter.addStatus(status);
		} else if (count > maxPorts) {
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
					IOsDomainValidators.PORT_CONSUMER_002, IOsProblemType.PORT_CONFIG_COUNT_EXCEEDED,
					OsDomainMessages.Validator_port_consumer_too_many_ports,
					new Object[] { capability }, capability);
			reporter.addStatus(status);
		}
	}

	/**
	 * Filter method for port counting.
	 * <p>
	 * Default implementation returns true if capability unit is a configuration unit. Subtypes may
	 * override.
	 * 
	 * @param port
	 *           a port that should be considered for counting.
	 * @return true if the port should be counted, false otherwise.
	 */
	protected boolean accept(Port port) {
		return ((Unit) port.getParent()).isConfigurationUnit();
	}
}
