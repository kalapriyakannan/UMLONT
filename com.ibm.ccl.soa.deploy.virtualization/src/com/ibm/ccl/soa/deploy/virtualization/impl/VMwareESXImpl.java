/**
 * <copyright>
 * </copyright>
 *
 * $Id: VMwareESXImpl.java,v 1.1 2008/05/08 14:38:29 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization.impl;

import com.ibm.ccl.soa.deploy.os.impl.OperatingSystemImpl;

import com.ibm.ccl.soa.deploy.virtualization.VMwareESX;
import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>VMware ESX</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class VMwareESXImpl extends OperatingSystemImpl implements VMwareESX {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VMwareESXImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return VirtualizationPackage.Literals.VMWARE_ESX;
	}

} //VMwareESXImpl
