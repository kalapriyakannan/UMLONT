/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.osgi;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bundle Capability</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *       Describes a Capability that other 'BundleComponents' may link to
 *       in order to describe the dependency tree of an OSGi Application. 
 *     
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.osgi.BundleCapability#getSymbolicName <em>Symbolic Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.osgi.OsgiPackage#getBundleCapability()
 * @model extendedMetaData="name='BundleCapability' kind='elementOnly'"
 * @generated
 */
public interface BundleCapability extends Capability {
	/**
	 * Returns the value of the '<em><b>Symbolic Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *             The fully qualified Bundle identifier for the enclosing 
	 *             'BundleComponent'.  
	 *           
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Symbolic Name</em>' attribute.
	 * @see #setSymbolicName(String)
	 * @see com.ibm.ccl.soa.deploy.osgi.OsgiPackage#getBundleCapability_SymbolicName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='symbolicName'"
	 * @generated
	 */
	String getSymbolicName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.osgi.BundleCapability#getSymbolicName <em>Symbolic Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Symbolic Name</em>' attribute.
	 * @see #getSymbolicName()
	 * @generated
	 */
	void setSymbolicName(String value);

} // BundleCapability
