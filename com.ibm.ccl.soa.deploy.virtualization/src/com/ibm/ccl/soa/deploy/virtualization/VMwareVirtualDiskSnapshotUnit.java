/**
 * <copyright>
 * </copyright>
 *
 * $Id: VMwareVirtualDiskSnapshotUnit.java,v 1.2 2008/04/24 02:17:02 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization;

import com.ibm.ccl.soa.deploy.core.Unit;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VMware Virtual Disk Snapshot Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				A VMwareVirtualDiskSnapshotUnit represents a snapshot of a VMware virtual disk on a VMware virtual
 * 				server
 * 
 * 				<p>
 * 					VMwareVirtualDiskSnapshotUnits are by convention configuration {@link Unit}s and have a {@link
 * 					HostingRequirement} for the {@link VMwareVirtualServerSnapshot} capability on a {@link
 * 					VMwareVirtualServerSnapshotUnit}. They are hosted by Units with a {@link
 * 					VMwareVirtualServerSnapshot} capability.
 * 				</p>
 * 			
 * <!-- end-model-doc -->
 *
 *
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualDiskSnapshotUnit()
 * @model extendedMetaData="name='VMwareVirtualDiskSnapshotUnit' kind='elementOnly'"
 * @generated
 */
public interface VMwareVirtualDiskSnapshotUnit extends VirtualDiskSnapshotUnit {
} // VMwareVirtualDiskSnapshotUnit
