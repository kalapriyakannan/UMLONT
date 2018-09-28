/**
 * <copyright> </copyright>
 * 
 * $Id: UMLElementCapability.java,v 1.3 2008/02/05 22:17:44 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.uml;

import com.ibm.ccl.soa.deploy.core.BundleCapability;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>UML Element Capability</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				UML Element capability
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.uml.UMLElementCapability#getUmlVisibilityKind <em>Uml Visibility Kind</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.uml.UmlPackage#getUMLElementCapability()
 * @model abstract="true"
 *        extendedMetaData="name='UMLElementCapability' kind='elementOnly'"
 * @generated
 */
public interface UMLElementCapability extends BundleCapability {
	/**
	 * Returns the value of the '<em><b>Uml Visibility Kind</b></em>' attribute.
	 * The default value is <code>"public"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.uml.UMLVisibilityKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uml Visibility Kind</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uml Visibility Kind</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLVisibilityKind
	 * @see #isSetUmlVisibilityKind()
	 * @see #unsetUmlVisibilityKind()
	 * @see #setUmlVisibilityKind(UMLVisibilityKind)
	 * @see com.ibm.ccl.soa.deploy.uml.UmlPackage#getUMLElementCapability_UmlVisibilityKind()
	 * @model default="public" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='umlVisibilityKind'"
	 * @generated
	 */
	UMLVisibilityKind getUmlVisibilityKind();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.uml.UMLElementCapability#getUmlVisibilityKind <em>Uml Visibility Kind</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uml Visibility Kind</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.uml.UMLVisibilityKind
	 * @see #isSetUmlVisibilityKind()
	 * @see #unsetUmlVisibilityKind()
	 * @see #getUmlVisibilityKind()
	 * @generated
	 */
	void setUmlVisibilityKind(UMLVisibilityKind value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.uml.UMLElementCapability#getUmlVisibilityKind <em>Uml Visibility Kind</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetUmlVisibilityKind()
	 * @see #getUmlVisibilityKind()
	 * @see #setUmlVisibilityKind(UMLVisibilityKind)
	 * @generated
	 */
	void unsetUmlVisibilityKind();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.uml.UMLElementCapability#getUmlVisibilityKind <em>Uml Visibility Kind</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Uml Visibility Kind</em>' attribute is set.
	 * @see #unsetUmlVisibilityKind()
	 * @see #getUmlVisibilityKind()
	 * @see #setUmlVisibilityKind(UMLVisibilityKind)
	 * @generated
	 */
	boolean isSetUmlVisibilityKind();

} // UMLElementCapability
