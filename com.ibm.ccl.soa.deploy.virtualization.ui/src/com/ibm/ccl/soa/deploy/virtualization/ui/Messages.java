package com.ibm.ccl.soa.deploy.virtualization.ui;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.ibm.ccl.soa.deploy.virtualization.ui.messages"; //$NON-NLS-1$

	public static String VirtualDiskDefUnitEditPart_0;

	public static String VirtualEthernetNICDefUnitEditPart_0;

	public static String VirtualImageCollectionUnitEditPart_Virtual_Image_Collection;

	public static String VirtualImageUnitEditPart_Virtual_Image;

	public static String VMwareVirtualDiskDefUnitEditPart_VMware_Virtual_Disk_Def;

	public static String VMwareVirtualDiskSnapshotUnitEditPart_VMware_Virtual_Disk_Snapshot;

	public static String VMwareVirtualEthernetNICDefUnitEditPart_VMware_Virtual_Ethernet_NIC_Def;

	public static String VMwareVirtualImageUnitEditPart_VMware_Virtual_Image;

	public static String VMwareVirtualServerSnapshotUnitEditPart_VMware_Virtual_Server_Snapshot;

	public static String XenVirtualDiskDefUnitEditPart_Xen_Virtual_Disk_Def;

	public static String XenVirtualEthernetNICDefUnitEditPart_Xen_Virtual_Ethernet_NIC_Def;

	public static String XenVirtualImageUnitEditPart_Xen_Virtual_Image;
	
	public static String VMwareESXUnitEditPart_VMware_ESX;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
