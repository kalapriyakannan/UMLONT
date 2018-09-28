/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Import</b></em>'. <!--
 * end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				An imported topology whose contents will be visible by reference to this topology.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Import#getInstanceConfiguration <em>Instance Configuration</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Import#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Import#getPattern <em>Pattern</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Import#isReexported <em>Reexported</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getImport()
 * @model extendedMetaData="name='Import' kind='elementOnly'"
 * @generated
 */
public interface Import extends DeployModelObject {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Instance Configuration</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link com.ibm.ccl.soa.deploy.core.InstanceConfiguration#getImported <em>Imported</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Configuration</em>' containment reference.
	 * @see #setInstanceConfiguration(InstanceConfiguration)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getImport_InstanceConfiguration()
	 * @see com.ibm.ccl.soa.deploy.core.InstanceConfiguration#getImported
	 * @model opposite="imported" containment="true" required="true"
	 *        extendedMetaData="kind='element' name='config.topology' namespace='##targetNamespace'"
	 * @generated
	 */
	InstanceConfiguration getInstanceConfiguration();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.Import#getInstanceConfiguration <em>Instance Configuration</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Configuration</em>' containment reference.
	 * @see #getInstanceConfiguration()
	 * @generated
	 */
	void setInstanceConfiguration(InstanceConfiguration value);

	/**
	 * Returns the value of the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespace</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namespace</em>' attribute.
	 * @see #setNamespace(String)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getImport_Namespace()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='namespace'"
	 * @generated
	 */
	String getNamespace();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.Import#getNamespace <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namespace</em>' attribute.
	 * @see #getNamespace()
	 * @generated
	 */
	void setNamespace(String value);

	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' attribute.
	 * @see #setPattern(String)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getImport_Pattern()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='pattern'"
	 * @generated
	 */
	String getPattern();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.Import#getPattern <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' attribute.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(String value);

	/**
	 * Returns the value of the '<em><b>Reexported</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reexported</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reexported</em>' attribute.
	 * @see #isSetReexported()
	 * @see #unsetReexported()
	 * @see #setReexported(boolean)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getImport_Reexported()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='reexport'"
	 * @generated
	 */
	boolean isReexported();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.Import#isReexported <em>Reexported</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reexported</em>' attribute.
	 * @see #isSetReexported()
	 * @see #unsetReexported()
	 * @see #isReexported()
	 * @generated
	 */
	void setReexported(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.Import#isReexported <em>Reexported</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetReexported()
	 * @see #isReexported()
	 * @see #setReexported(boolean)
	 * @generated
	 */
	void unsetReexported();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.Import#isReexported <em>Reexported</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Reexported</em>' attribute is set.
	 * @see #unsetReexported()
	 * @see #isReexported()
	 * @see #setReexported(boolean)
	 * @generated
	 */
	boolean isSetReexported();

	/**
	 * <!-- begin-user-doc --> Resolves the import and returns the topology associated with the
	 * import
	 * 
	 * @return the imported topology <!-- end-user-doc -->
	 * @model required="true"
	 * @generated NOT
	 */
	Topology resolveImport();

	/**
	 * Returns true if the given namespace and a pattern match the current Import's attributes.
	 * 
	 * @param namespace
	 *           The namespace with NO trailing dot.
	 * @param pattern
	 *           The pattern (topology name without a file extension).
	 * @return
	 */
	boolean equals(String namespace, String pattern);

	/**
	 * Checks to see if the URI of a link matches the namespace and name of this import.
	 * 
	 * @param URI -
	 *           the uri
	 * @return true if there is a match; false otherwise
	 */
	boolean isReferencingMe(String uri);

	/**
	 * Return the qualified namespace + pattern of the imported Topology. Adjusts for the default
	 * namespace.
	 * 
	 * @return The qualified namespace + pattern of the imported Topology.
	 */
	String getQualifiedImport();

} // Import
