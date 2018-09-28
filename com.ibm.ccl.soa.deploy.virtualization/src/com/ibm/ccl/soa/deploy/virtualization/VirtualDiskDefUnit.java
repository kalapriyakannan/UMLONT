/**
 * <copyright>
 * </copyright>
 *
 * $Id: VirtualDiskDefUnit.java,v 1.3 2008/04/17 15:47:25 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization;

import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Virtual Disk Def Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				A VirtualDiskDefUnit represents the specification for a virtual disk
 * 
 * 				<p>VirtualDiskDefUnit may have a {@link DependencyLink} to the TODO Disk that it specifies.</p>
 * 
 * 				<p>
 * 					VirtualDiskDefUnits are by convention configuration {@link Unit}s and have a {@link
 * 					HostingRequirement} for the {@link VirtualImage} capability on a {@link VirtualImageUnit}. They are
 * 					hosted by Units with a {@link VirtualImage} capability.
 * 				</p>
 * 			
 * <!-- end-model-doc -->
 *
 *
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualDiskDefUnit()
 * @model extendedMetaData="name='VirtualDiskDefUnit' kind='elementOnly'"
 * @generated
 */
public interface VirtualDiskDefUnit extends Unit {
} // VirtualDiskDefUnit
