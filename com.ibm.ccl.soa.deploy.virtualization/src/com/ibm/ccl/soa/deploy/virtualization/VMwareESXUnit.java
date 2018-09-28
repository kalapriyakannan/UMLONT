/**
 * <copyright>
 * </copyright>
 *
 * $Id: VMwareESXUnit.java,v 1.1 2008/05/08 14:38:29 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization;

import com.ibm.ccl.soa.deploy.os.OperatingSystemUnit;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VMware ESX Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				A VMwareESXUnit represents a single VMware ESX installation. It extends {@link
 * 				OperatingSystemUnit}. A VMwareESXUnit provides a {@link VMwareESX} capability and a {@link
 * 				VMwareHypervisor} capability.
 * 				<p>
 * 				A VMwareESXUnit is hosted directly on a physical (intel architecture) server.
 * 				</p>
 * 			
 * <!-- end-model-doc -->
 *
 *
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareESXUnit()
 * @model extendedMetaData="name='VMwareESXUnit' kind='elementOnly'"
 * @generated
 */
public interface VMwareESXUnit extends OperatingSystemUnit {
} // VMwareESXUnit
