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

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasProfileTypeEnum;
import com.ibm.ccl.soa.deploy.was.WasSystem;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;

/**
 * Resolution to add a {@link WasNode} to a {@link WasCell} that contain non-web nodes on the local
 * {@link WasSystem}.
 */
public class AddWasNodeToSystemCellResolution extends DeployResolution {

	/** The WAS node unit to which this resolution is bound. */
	protected WasNodeUnit wasNodeUnit;

	/**
	 * Construct a resolution to add a node to a local standalone cell.
	 * 
	 * @param context
	 *           the resolution context.
	 * @param generator
	 *           the resolution generator creating this resolution.
	 * @param nodeUnit
	 *           the {@link WasNode} unit.
	 */
	public AddWasNodeToSystemCellResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, WasNodeUnit nodeUnit) {
		super(context, generator, WasDomainMessages.Resolution_associate_node_with_profile);
		wasNodeUnit = nodeUnit;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#resolve(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		WasNode wasNode = (WasNode) ValidatorUtils.getFirstCapability(wasNodeUnit,
				WasPackage.Literals.WAS_NODE);
		if (wasNode == null || wasNode.getProfileType() != WasProfileTypeEnum.NONE_LITERAL) {
			return Status.CANCEL_STATUS;
		}
		Unit systemUnit = ValidatorUtils.discoverHost(wasNodeUnit, monitor);
		if (systemUnit == null) {
			return Status.CANCEL_STATUS;
		}
		List wasNodeList = ValidatorUtils.discoverHostedCapabilities(systemUnit,
				WasPackage.Literals.WAS_NODE, false, monitor);
		UnitDescriptor wasCellDescriptor = null;
		WasNode targetWasNode = null;
		for (Iterator iter = wasNodeList.iterator(); iter.hasNext();) {
			WasNode curWasNode = (WasNode) iter.next();
			if (curWasNode == wasNode) {
				continue;
			}
			if (wasNode.getProfileName() != null && wasNode.getProfileName().length() > 0
					&& !wasNode.getProfileName().equals(curWasNode.getProfileName())) {
				// check for profile name match
				continue;
			}
			if (curWasNode.getProfileType() == WasProfileTypeEnum.NONE_LITERAL) {
				// ignore non-profile nodes
				continue;
			}
			UnitDescriptor curWasCellDescriptor = ValidatorUtils
					.discoverGroupDescriptorByCapabilityType((Unit) curWasNode.getParent(),
							WasPackage.Literals.WAS_CELL, monitor);
			if (curWasCellDescriptor != null) {
				wasCellDescriptor = curWasCellDescriptor;
				targetWasNode = curWasNode;
			}
		}

		if (wasCellDescriptor == null) {
			return Status.CANCEL_STATUS;
		}

		//
		// Add WasNode to cell and set its profile attributes.
		//
		Unit wasCellUnit;
		if (wasCellDescriptor.isInTopology(context.getTopology())) {
			wasCellUnit = wasCellDescriptor.getUnitValue();
		} else {
			wasCellUnit = wasCellDescriptor.getUnitValueAndAddToTopology(context.getTopology());
		}

		MemberLink link = ResolutionUtils.addMember(context, wasCellUnit, wasNodeUnit);
		if (link == null) {
			return Status.CANCEL_STATUS;
		}
		wasNode.setProfileName(targetWasNode.getProfileName());
		wasNode.setProfileLocation(targetWasNode.getProfileLocation());

		return Status.OK_STATUS;
	}
}
