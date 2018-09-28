/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.virtualization;

/**
 * Defines type IDs for the OS domain plugin. These IDs can be used with the {@link ResourceTypeService}.
 */
public interface IVirtualizationTemplateConstants {

	// Abstract
	public static final String VIRTUALIZATION_VIRTUAL_IMAGE_UNIT_CONCEPTUAL = "virtualization.VirtualImage.conceptual"; //$NON-NLS-1$

	public static final String VIRTUALIZATION_VIRTUAL_ETHERNET_NIC_DEF_UNIT_CONCEPTUAL = "virtualization.VirtualEthernetNICDef.conceptual"; //$NON-NLS-1$

	public static final String VIRTUALIZATION_VIRTUAL_DISK_DEF_UNIT_CONCEPTUAL = "virtualization.VirtualDiskDef.conceptual"; //$NON-NLS-1$
	
	// VMware
	public static final String VIRTUALIZATION_VMWARE_VIRTUAL_DISK_DEF_UNIT_CONCEPTUAL = "virtualization.VMwareVirtualDiskDef.infra"; //$NON-NLS-1$

	public static final String VIRTUALIZATION_VMWARE_VIRTUAL_IMAGE_UNIT = "virtualization.VMwareVirtualImage.infra"; //$NON-NLS-1$

	public static final String VIRTUALIZATION_VMWARE_VIRTUAL_ETHERNET_NIC_DEF_UNIT = "virtualization.VMwareVirtualEthernetNICDef.infra"; //$NON-NLS-1$

	public static final String VIRTUALIZATION_VMWARE_VIRTUAL_IDE_DISK_DEF_UNIT = "virtualization.VMwareVirtualIDEDiskDef.infra"; //$NON-NLS-1$

	public static final String VIRTUALIZATION_VMWARE_VIRTUAL_SCSI_DISK_DEF_UNIT = "virtualization.VMwareVirtualSCSIDiskDef.infra"; //$NON-NLS-1$

	public static final String VIRTUALIZATION_VMWARE_VIRTUAL_SERVER_SNAPSHOT_UNIT = "virtualization.VMwareVirtualServerSnapshot.infra"; //$NON-NLS-1$

	public static final String VIRTUALIZATION_VMWARE_VIRTUAL_DISK_SNAPSHOT_UNIT = "virtualization.VMwareVirtualDiskSnapshot.infra"; //$NON-NLS-1$

	// Xen
	public static final String VIRTUALIZATION_XEN_VIRTUAL_ETHERNET_NIC_DEF_UNIT = "virtualization.XenVirtualEthernetNICDef.infra"; //$NON-NLS-1$
	
	public static final String VIRTUALIZATION_XEN_VIRTUAL_IMAGE_UNIT = "virtualization.XenVirtualImage.infra"; //$NON-NLS-1$

	public static final String VIRTUALIZATION_XEN_VIRTUAL_DISK_DEF_UNIT = "virtualization.XenVirtualDiskDef.infra"; //$NON-NLS-1$
	
	public static final String VIRTUALIZATION_SLES10_XEN_UNIT_CONCEPTUAL = "os.OperatingSystemUnit.SLES10XenLinux.conceptual"; //$NON-NLS-1$
	
	public static final String VIRTUALIZATION_SLES10_XEN_UNIT = "os.OperatingSystemUnit.SLES10XenLinux.infra"; //$NON-NLS-1$
	
	public static final String VIRTUALIZATION_VMWARE_ESX_UNIT_CONCEPTUAL = "virtualization.OperatingSystemUnit.VMwareESX.conceptual"; //$NON_NLS-1$
}
