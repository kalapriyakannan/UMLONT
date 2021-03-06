/**
 * <copyright>
 * </copyright>
 *
 * $Id: VMwareVirtualDiskDefUnit.java,v 1.3 2008/04/17 15:47:25 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization;

import com.ibm.ccl.soa.deploy.core.Unit;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VMware Virtual Disk Def Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				A VMwareVirtualDiskDefUnit represents the specification for a VMware virtual disk
 * 				<p>
 * 					VMwareVirtualDiskDefUnits are by convention configuration {@link Unit}s and have a {@link
 * 					HostingRequirement} for the {@link VMwareVirtualImage} capability on a {@link
 * 					VMwareVirtualImageUnit}. They are hosted by Units with a {@link VMwareVirtualImage} capability.
 * 				</p>
 * 			
 * <!-- end-model-doc -->
 *
 *
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualDiskDefUnit()
 * @model extendedMetaData="name='VMwareVirtualDiskDefUnit' kind='elementOnly'"
 * @generated
 */
public interface VMwareVirtualDiskDefUnit extends VirtualDiskDefUnit {
} // VMwareVirtualDiskDefUnit
