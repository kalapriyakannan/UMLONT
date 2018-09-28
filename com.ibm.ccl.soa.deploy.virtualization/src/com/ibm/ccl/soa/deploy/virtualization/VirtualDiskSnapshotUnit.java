/**
 * <copyright>
 * </copyright>
 *
 * $Id: VirtualDiskSnapshotUnit.java,v 1.1 2008/04/17 15:47:25 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization;

import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Virtual Disk Snapshot Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				A VirtualDiskSnapshotUnit represents a snapshot of a virtual disk on a virtual server
 * 
 * 				<p>
 * 					VirtualDiskSnapshotUnit are by convention configuration {@link Unit}s and have a {@link
 * 					HostingRequirement} for the {@link VirtualServerSnapshot} capability on a {@link
 * 					VirtualServerSnapshotUnit}. They are hosted by Units with a {@link VirtualServerSnapshot}
 * 					capability.
 * 				</p>
 * 			
 * <!-- end-model-doc -->
 *
 *
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualDiskSnapshotUnit()
 * @model extendedMetaData="name='VirtualDiskSnapshotUnit' kind='elementOnly'"
 * @generated
 */
public interface VirtualDiskSnapshotUnit extends Unit {
} // VirtualDiskSnapshotUnit
