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
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImage;
import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot;
import com.ibm.ccl.soa.deploy.virtualization.VirtualImage;
import com.ibm.ccl.soa.deploy.virtualization.VirtualServerSnapshot;
import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage;
import com.ibm.ccl.soa.deploy.virtualization.XenVirtualImage;

/**
 * Suggests {@link Unit} types to be contained by an {@link VirtualImageUnit}.
 * 
 * &lt;unitFilter&gt; registered on the <code>com.ibm.ccl.soa.deploy.core.unitLifecycle</code>
 * extension.
 * 
 * @see VirtualImageSnapshotUnit
 */
public class VirtualImageUnitFilter extends UnitFilter {

	private final static List<String> virtualImageTypes = Collections
			.unmodifiableList(Arrays.asList(new String[] {
					IVirtualizationTemplateConstants.VIRTUALIZATION_VIRTUAL_DISK_DEF_UNIT_CONCEPTUAL,
					IVirtualizationTemplateConstants.VIRTUALIZATION_VIRTUAL_ETHERNET_NIC_DEF_UNIT_CONCEPTUAL
					}));
	private final static List<String> vmwareVirtualImageTypes = Collections
	.unmodifiableList(Arrays.asList(new String[] {
			IVirtualizationTemplateConstants.VIRTUALIZATION_VMWARE_VIRTUAL_SCSI_DISK_DEF_UNIT,
			IVirtualizationTemplateConstants.VIRTUALIZATION_VMWARE_VIRTUAL_IDE_DISK_DEF_UNIT,
			IVirtualizationTemplateConstants.VIRTUALIZATION_VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT,
			IVirtualizationTemplateConstants.VIRTUALIZATION_VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT
			}));
	private final static List<String> xenVirtualImageTypes = Collections
	.unmodifiableList(Arrays.asList(new String[] {
			IVirtualizationTemplateConstants.VIRTUALIZATION_XEN_VIRTUAL_DISK_DEF_UNIT,
			IVirtualizationTemplateConstants.VIRTUALIZATION_XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT
			}));	
	/**
	 * Clients don't call this directly; it should be called through DeployableUnitElementUIService
	 * or GMF's ModelingAssistantService.
	 */
	@Override
	public List<String> getAllowableHostingUnitTypes(Unit anInputUnit) {
		VirtualImage viCap = (VirtualImage) ValidatorUtils.getFirstCapability(anInputUnit,
				VirtualizationPackage.eINSTANCE.getVirtualImage());
		if (viCap != null) {
			if (viCap instanceof VMwareVirtualImage) {
				return vmwareVirtualImageTypes;
			} else if (viCap instanceof XenVirtualImage) {
				return xenVirtualImageTypes;
			}
		}
		return virtualImageTypes;
	}
} // end class VirtualServerSnapshotUnitFilter
