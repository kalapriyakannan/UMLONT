/**
 * <copyright>
 * </copyright>
 *
 * $Id: IpInterfaceUnit.java,v 1.1 2008/02/01 18:53:29 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.net;

import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ip Interface Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				In CDM, the IPInterface is contained by the computer system. It should be contained by the
 * 				OperatingSystem, and this should map to hosting on an OperatingSystemUnit. The IpInterfaceUnit should be
 * 				a configuration unit
 * 			
 * <!-- end-model-doc -->
 *
 *
 * @see com.ibm.ccl.soa.deploy.net.NetPackage#getIpInterfaceUnit()
 * @model extendedMetaData="name='IpInterfaceUnit' kind='elementOnly'"
 * @generated
 */
public interface IpInterfaceUnit extends Unit {
} // IpInterfaceUnit
