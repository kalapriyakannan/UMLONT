/**
 * <copyright>
 * </copyright>
 *
 * $Id: UMLPackageCap.java,v 1.3 2007/12/05 21:54:25 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.uml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Package Cap</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				UML Package capability
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.uml.UMLPackageCap#isCanonical <em>Canonical</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.uml.UmlPackage#getUMLPackageCap()
 * @model extendedMetaData="name='UMLPackageCap' kind='elementOnly'"
 * @generated
 */
public interface UMLPackageCap extends UMLElementCapability {
	/**
	 * Returns the value of the '<em><b>Canonical</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Canonical</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Canonical</em>' attribute.
	 * @see #isSetCanonical()
	 * @see #unsetCanonical()
	 * @see #setCanonical(boolean)
	 * @see com.ibm.ccl.soa.deploy.uml.UmlPackage#getUMLPackageCap_Canonical()
	 * @model default="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='canonical'"
	 * @generated
	 */
	boolean isCanonical();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.uml.UMLPackageCap#isCanonical <em>Canonical</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Canonical</em>' attribute.
	 * @see #isSetCanonical()
	 * @see #unsetCanonical()
	 * @see #isCanonical()
	 * @generated
	 */
	void setCanonical(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.uml.UMLPackageCap#isCanonical <em>Canonical</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCanonical()
	 * @see #isCanonical()
	 * @see #setCanonical(boolean)
	 * @generated
	 */
	void unsetCanonical();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.uml.UMLPackageCap#isCanonical <em>Canonical</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Canonical</em>' attribute is set.
	 * @see #unsetCanonical()
	 * @see #isCanonical()
	 * @see #setCanonical(boolean)
	 * @generated
	 */
	boolean isSetCanonical();

} // UMLPackageCap
