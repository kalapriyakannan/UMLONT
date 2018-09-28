/**
 * <copyright>
 * </copyright>
 *
 * $Id: XenVirtualDiskDefUnit.java,v 1.3 2008/04/17 15:47:25 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization;

import com.ibm.ccl.soa.deploy.core.Unit;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Xen Virtual Disk Def Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				A XenVirtualDiskDefUnit represents the specification for a Xen virtual disk
 * 				<p>
 * 					XenVirtualDiskDefUnits are by convention configuration {@link Unit}s and have a {@link
 * 					HostingRequirement} for the {@link XenVirtualImage} capability on a {@link XenVirtualImageUnit}.
 * 					They are hosted by Units with a {@link XenVirtualImage} capability.
 * 				</p>
 * 			
 * <!-- end-model-doc -->
 *
 *
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getXenVirtualDiskDefUnit()
 * @model extendedMetaData="name='XenVirtualDiskDefUnit' kind='elementOnly'"
 * @generated
 */
public interface XenVirtualDiskDefUnit extends VirtualDiskDefUnit {
} // XenVirtualDiskDefUnit
