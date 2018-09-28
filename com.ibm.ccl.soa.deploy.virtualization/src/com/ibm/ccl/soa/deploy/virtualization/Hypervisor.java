/**
 * <copyright>
 * </copyright>
 *
 * $Id: Hypervisor.java,v 1.3 2008/04/17 15:47:25 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hypervisor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				This capability or subclasses of it may be provided by {@link Unit}s that can host virtual machines.
 * 				<p>The attributes are optional and if set, may be used for matching.</p>
 * 				<p>This capability corresponds to the OVF Platform_Type in an OVF environment xml</p>
 * 			
 * <!-- end-model-doc -->
 *
 *
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getHypervisor()
 * @model extendedMetaData="name='Hypervisor' kind='elementOnly'"
 * @generated
 */
public interface Hypervisor extends Capability {

} // Hypervisor
