/**
 * <copyright>
 * </copyright>
 *
 * $Id: NetFactory.java,v 1.2 2008/02/01 20:40:01 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.net;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.net.NetPackage
 * @generated
 */
public interface NetFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NetFactory eINSTANCE = com.ibm.ccl.soa.deploy.net.impl.NetFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Ip Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ip Interface</em>'.
	 * @generated
	 */
	IpInterface createIpInterface();

	/**
	 * Returns a new object of class '<em>Ip Interface Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ip Interface Unit</em>'.
	 * @generated
	 */
	IpInterfaceUnit createIpInterfaceUnit();

	/**
	 * Returns a new object of class '<em>L2 Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>L2 Interface</em>'.
	 * @generated
	 */
	L2Interface createL2Interface();

	/**
	 * Returns a new object of class '<em>L2 Interface Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>L2 Interface Unit</em>'.
	 * @generated
	 */
	L2InterfaceUnit createL2InterfaceUnit();

	/**
	 * Returns a new object of class '<em>Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Root</em>'.
	 * @generated
	 */
	NetRoot createNetRoot();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	NetPackage getNetPackage();

} //NetFactory
