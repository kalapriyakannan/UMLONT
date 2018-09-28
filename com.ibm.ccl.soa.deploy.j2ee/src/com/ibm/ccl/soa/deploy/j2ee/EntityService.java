/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Entity Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.EntityService#isManaged <em>Managed</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getEntityService()
 * @model extendedMetaData="name='EntityService' kind='elementOnly'"
 * @generated
 */
public interface EntityService extends EnterpriseBeanService {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Managed</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc --> <!-- begin-model-doc -->
	 * 
	 * A value of "true" would indicate that the bean is intended to be managed by the container in
	 * which it run in ( CMP ). A value of false would indicate that the bean will manage it's own
	 * datasource connection logic. ( BMP )
	 * 
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Managed</em>' attribute.
	 * @see #isSetManaged()
	 * @see #unsetManaged()
	 * @see #setManaged(boolean)
	 * @see com.ibm.ccl.soa.deploy.j2ee.J2eePackage#getEntityService_Managed()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        required="true" extendedMetaData="kind='attribute' name='managed'"
	 * @generated
	 */
	boolean isManaged();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.EntityService#isManaged <em>Managed</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Managed</em>' attribute.
	 * @see #isSetManaged()
	 * @see #unsetManaged()
	 * @see #isManaged()
	 * @generated
	 */
	void setManaged(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.EntityService#isManaged <em>Managed</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetManaged()
	 * @see #isManaged()
	 * @see #setManaged(boolean)
	 * @generated
	 */
	void unsetManaged();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.j2ee.EntityService#isManaged <em>Managed</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Managed</em>' attribute is set.
	 * @see #unsetManaged()
	 * @see #isManaged()
	 * @see #setManaged(boolean)
	 * @generated
	 */
	boolean isSetManaged();

} // EntityService
