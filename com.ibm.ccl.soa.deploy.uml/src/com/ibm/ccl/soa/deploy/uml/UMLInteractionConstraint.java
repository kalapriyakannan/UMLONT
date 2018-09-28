/**
 * <copyright>
 * </copyright>
 *
 * $Id: UMLInteractionConstraint.java,v 1.2 2007/11/01 13:22:15 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.uml;

import com.ibm.ccl.soa.deploy.core.Constraint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Interaction Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				Idenitifies associated UML interaction resources. 
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.uml.UMLInteractionConstraint#getInteractionQName <em>Interaction QName</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.uml.UMLInteractionConstraint#getResourceURI <em>Resource URI</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.uml.UmlPackage#getUMLInteractionConstraint()
 * @model extendedMetaData="name='UMLInteractionConstraint' kind='elementOnly'"
 * @generated
 */
public interface UMLInteractionConstraint extends Constraint {
	/**
	 * Returns the value of the '<em><b>Interaction QName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interaction QName</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interaction QName</em>' attribute.
	 * @see #setInteractionQName(String)
	 * @see com.ibm.ccl.soa.deploy.uml.UmlPackage#getUMLInteractionConstraint_InteractionQName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='interactionQName'"
	 * @generated
	 */
	String getInteractionQName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.uml.UMLInteractionConstraint#getInteractionQName <em>Interaction QName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interaction QName</em>' attribute.
	 * @see #getInteractionQName()
	 * @generated
	 */
	void setInteractionQName(String value);

	/**
	 * Returns the value of the '<em><b>Resource URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource URI</em>' attribute.
	 * @see #setResourceURI(String)
	 * @see com.ibm.ccl.soa.deploy.uml.UmlPackage#getUMLInteractionConstraint_ResourceURI()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='resourceURI'"
	 * @generated
	 */
	String getResourceURI();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.uml.UMLInteractionConstraint#getResourceURI <em>Resource URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource URI</em>' attribute.
	 * @see #getResourceURI()
	 * @generated
	 */
	void setResourceURI(String value);

} // UMLInteractionConstraint
