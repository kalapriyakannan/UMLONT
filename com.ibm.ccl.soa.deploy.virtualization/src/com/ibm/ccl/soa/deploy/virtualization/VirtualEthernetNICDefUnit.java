/**
 * <copyright>
 * </copyright>
 *
 * $Id: VirtualEthernetNICDefUnit.java,v 1.3 2008/04/17 15:47:25 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization;

import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Virtual Ethernet NIC Def Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				A VirtualEthernetNICDefUnit represents the specification for a virtual ethernet network interface
 * 				controller
 * 
 * 				<p>VirtualEthernetNICDefUnit may have a {@link DependencyLink} to the L2Interface that it specifies.</p>
 * 
 * 				<p>
 * 					VirtualEthernetNICDefUnits are by convention configuration {@link Unit}s and have a {@link
 * 					HostingRequirement} for the {@link VirtualImage} capability on a {@link VirtualImageUnit}. They are
 * 					hosted by Units with a {@link VirtualImage} capability.
 * 				</p>
 * 			
 * <!-- end-model-doc -->
 *
 *
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualEthernetNICDefUnit()
 * @model extendedMetaData="name='VirtualEthernetNICDefUnit' kind='elementOnly'"
 * @generated
 */
public interface VirtualEthernetNICDefUnit extends Unit {
} // VirtualEthernetNICDefUnit
