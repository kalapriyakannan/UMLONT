/**
 * <copyright>
 * </copyright>
 *
 * $Id: VMwareVirtualServerSnapshotUnit.java,v 1.1 2008/04/17 15:47:25 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization;

import com.ibm.ccl.soa.deploy.core.Unit;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VMware Virtual Server Snapshot Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				A VMwareVirtualServerSnapshotUnit represents a snapshot of a VMware virtual machine
 * 
 * 				<p>
 * 					VMwareVirtualServerSnapshotUnit are by convention configuration {@link Unit}s and have a {@link
 * 					HostingRequirement} for the {@link VMwareVirtualImage} capability on a {@link
 * 					VMwareVirtualImageUnit}. They are hosted by Units with a {@link VMwareVirtualImage} capability.
 * 				</p>
 * 			
 * <!-- end-model-doc -->
 *
 *
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualServerSnapshotUnit()
 * @model extendedMetaData="name='VMwareVirtualServerSnapshotUnit' kind='elementOnly'"
 * @generated
 */
public interface VMwareVirtualServerSnapshotUnit extends VirtualServerSnapshotUnit {
} // VMwareVirtualServerSnapshotUnit
