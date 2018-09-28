/**
 * <copyright>
 * </copyright>
 *
 * $Id: VirtualServerSnapshotUnit.java,v 1.1 2008/04/17 15:47:25 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization;

import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Virtual Server Snapshot Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				A VirtualServerSnapshotUnit represents a snapshot of a virtual machine
 * 
 * 				<p>
 * 					VirtualServerSnapshotUnit are by convention configuration {@link Unit}s and have a {@link
 * 					HostingRequirement} for the {@link VirtualImage} capability on a {@link VirtualImageUnit}. They are
 * 					hosted by Units with a {@link VirtualImage} capability.
 * 				</p>
 * 			
 * <!-- end-model-doc -->
 *
 *
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualServerSnapshotUnit()
 * @model extendedMetaData="name='VirtualServerSnapshotUnit' kind='elementOnly'"
 * @generated
 */
public interface VirtualServerSnapshotUnit extends Unit {
} // VirtualServerSnapshotUnit
