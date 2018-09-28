/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.virtualization.internal.filter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitFilter;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.virtualization.IVirtualizationTemplateConstants;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot;
import com.ibm.ccl.soa.deploy.virtualization.VirtualServerSnapshot;
import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage;

/**
 * Suggests {@link Unit} types to be contained by an {@link VirtualServerSnapshotUnit}.
 * 
 * &lt;unitFilter&gt; registered on the <code>com.ibm.ccl.soa.deploy.core.unitLifecycle</code>
 * extension.
 * 
 * @see VirtualServerSnapshotUnit
 */
public class VirtualServerSnapshotUnitFilter extends UnitFilter {

	private final static List<String> vmwareVirtualServerSnapshotTypes = Collections
			.unmodifiableList(Arrays.asList(new String[] {
					IVirtualizationTemplateConstants.VIRTUALIZATION_VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT
					}));
	/**
	 * Clients don't call this directly; it should be called through DeployableUnitElementUIService
	 * or GMF's ModelingAssistantService.
	 */
	@Override
	public List<String> getAllowableHostingUnitTypes(Unit anInputUnit) {
		VirtualServerSnapshot vssCap = (VirtualServerSnapshot) ValidatorUtils.getFirstCapability(anInputUnit,
				VirtualizationPackage.eINSTANCE.getVirtualServerSnapshot());
		if (vssCap != null) {
			if (vssCap instanceof VMwareVirtualServerSnapshot) {
				return vmwareVirtualServerSnapshotTypes;
			}
		}
		return Collections.emptyList();
	}
} // end class VirtualServerSnapshotUnitFilter
