package com.ibm.ccl.soa.deploy.virtualization;

/**
 * Constants related to SAT provider annotations.
 */
public interface IVirtualizationAnnotationConstants {
	/**
	 * Constant identifying a Xen domain configuration provider annotation.
	 */
	public static final String XEN_DOMAIN_CONFIGURATION = "environment_xen_domain"; //$NON-NLS-1$

	/**
	 * Constant identifying a VMware domain configuration provider annotation.
	 */
	public static final String VMWARE_MACHINE_CONFIGURATION = "environment_vmware_machine"; //$NON-NLS-1$

	/**
	 * Constant identifying a VMware domain configuration provider annotation.
	 */
	public static final String VMWARE_SNAPSHOT_CONFIGURATION = "environment_vmware_snapshot"; //$NON-NLS-1$
}
