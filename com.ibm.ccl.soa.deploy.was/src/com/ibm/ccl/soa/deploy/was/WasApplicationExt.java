/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Application Ext</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasApplicationExt#getReloadInterval <em>Reload Interval</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasApplicationExt#isShareSessionContext <em>Share Session Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasApplicationExt()
 * @model extendedMetaData="name='WasApplicationExt' kind='elementOnly'"
 * @generated
 */
public interface WasApplicationExt extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Reload Interval</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Reload Interval</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reload Interval</em>' attribute.
	 * @see #isSetReloadInterval()
	 * @see #unsetReloadInterval()
	 * @see #setReloadInterval(long)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasApplicationExt_ReloadInterval()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Long"
	 *        extendedMetaData="kind='attribute' name='reloadInterval'"
	 * @generated
	 */
	long getReloadInterval();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasApplicationExt#getReloadInterval <em>Reload Interval</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reload Interval</em>' attribute.
	 * @see #isSetReloadInterval()
	 * @see #unsetReloadInterval()
	 * @see #getReloadInterval()
	 * @generated
	 */
	void setReloadInterval(long value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasApplicationExt#getReloadInterval <em>Reload Interval</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetReloadInterval()
	 * @see #getReloadInterval()
	 * @see #setReloadInterval(long)
	 * @generated
	 */
	void unsetReloadInterval();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasApplicationExt#getReloadInterval <em>Reload Interval</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Reload Interval</em>' attribute is set.
	 * @see #unsetReloadInterval()
	 * @see #getReloadInterval()
	 * @see #setReloadInterval(long)
	 * @generated
	 */
	boolean isSetReloadInterval();

	/**
	 * Returns the value of the '<em><b>Share Session Context</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Share Session Context</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Share Session Context</em>' attribute.
	 * @see #isSetShareSessionContext()
	 * @see #unsetShareSessionContext()
	 * @see #setShareSessionContext(boolean)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasApplicationExt_ShareSessionContext()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='shareSessionContext'"
	 * @generated
	 */
	boolean isShareSessionContext();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasApplicationExt#isShareSessionContext <em>Share Session Context</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Share Session Context</em>' attribute.
	 * @see #isSetShareSessionContext()
	 * @see #unsetShareSessionContext()
	 * @see #isShareSessionContext()
	 * @generated
	 */
	void setShareSessionContext(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasApplicationExt#isShareSessionContext <em>Share Session Context</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetShareSessionContext()
	 * @see #isShareSessionContext()
	 * @see #setShareSessionContext(boolean)
	 * @generated
	 */
	void unsetShareSessionContext();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasApplicationExt#isShareSessionContext <em>Share Session Context</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Share Session Context</em>' attribute is set.
	 * @see #unsetShareSessionContext()
	 * @see #isShareSessionContext()
	 * @see #setShareSessionContext(boolean)
	 * @generated
	 */
	boolean isSetShareSessionContext();

} // WasApplicationExt
