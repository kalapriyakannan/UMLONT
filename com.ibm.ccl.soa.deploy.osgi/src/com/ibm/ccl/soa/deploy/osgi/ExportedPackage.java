/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.osgi;

import com.ibm.ccl.soa.deploy.core.Capability;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exported Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *       Describes a Java package that an OSGi Bundle makes available 
 *       to other OSGi Bundles that depend on it. 
 *     
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.osgi.ExportedPackage#getFriend <em>Friend</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.osgi.ExportedPackage#isInternal <em>Internal</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.osgi.OsgiPackage#getExportedPackage()
 * @model extendedMetaData="name='ExportedPackage' kind='elementOnly'"
 * @generated
 */
public interface ExportedPackage extends Capability {
	/**
	 * Returns the value of the '<em><b>Friend</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *             Provides the fully qualified Bundle identifier of a 
	 *             downstream Bundle that requires access to enclosing 
	 *             'ExportedPackage'.               
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Friend</em>' attribute list.
	 * @see com.ibm.ccl.soa.deploy.osgi.OsgiPackage#getExportedPackage_Friend()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='friend' namespace='##targetNamespace'"
	 * @generated
	 */
	List getFriend();

	/**
	 * Returns the value of the '<em><b>Internal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *             A value of 'true' indicates the 'ExportedPackage' is 
	 *             considered part of the internal implementation.  
	 *           
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Internal</em>' attribute.
	 * @see #isSetInternal()
	 * @see #unsetInternal()
	 * @see #setInternal(boolean)
	 * @see com.ibm.ccl.soa.deploy.osgi.OsgiPackage#getExportedPackage_Internal()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='internal'"
	 * @generated
	 */
	boolean isInternal();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.osgi.ExportedPackage#isInternal <em>Internal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Internal</em>' attribute.
	 * @see #isSetInternal()
	 * @see #unsetInternal()
	 * @see #isInternal()
	 * @generated
	 */
	void setInternal(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.osgi.ExportedPackage#isInternal <em>Internal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInternal()
	 * @see #isInternal()
	 * @see #setInternal(boolean)
	 * @generated
	 */
	void unsetInternal();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.osgi.ExportedPackage#isInternal <em>Internal</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Internal</em>' attribute is set.
	 * @see #unsetInternal()
	 * @see #isInternal()
	 * @see #setInternal(boolean)
	 * @generated
	 */
	boolean isSetInternal();

} // ExportedPackage
