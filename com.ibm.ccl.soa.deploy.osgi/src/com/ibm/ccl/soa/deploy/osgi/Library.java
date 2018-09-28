/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.osgi;

import com.ibm.ccl.soa.deploy.core.Unit;

import java.util.List;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *       Describes a Configuration Unit that may be 
 *       hosted on 'BundleComponents'.
 *     
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.osgi.Library#getSource <em>Source</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.osgi.Library#getOutput <em>Output</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.osgi.OsgiPackage#getLibrary()
 * @model extendedMetaData="name='Library' kind='elementOnly'"
 * @generated
 */
public interface Library extends Unit {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' attribute list.
	 * @see com.ibm.ccl.soa.deploy.osgi.OsgiPackage#getLibrary_Source()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='source' namespace='##targetNamespace'"
	 * @generated
	 */
	List getSource();

	/**
	 * Returns the value of the '<em><b>Output</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output</em>' attribute list.
	 * @see com.ibm.ccl.soa.deploy.osgi.OsgiPackage#getLibrary_Output()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='output' namespace='##targetNamespace'"
	 * @generated
	 */
	List getOutput();

} // Library
