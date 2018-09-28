/**
 * <copyright>
 * </copyright>
 *
 * $Id: UMLActor.java,v 1.2 2007/12/05 21:54:25 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.uml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Actor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				UML Actor capability
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.uml.UMLActor#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.uml.UMLActor#isLeaf <em>Leaf</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.uml.UmlPackage#getUMLActor()
 * @model extendedMetaData="name='UMLActor' kind='elementOnly'"
 * @generated
 */
public interface UMLActor extends UMLElementCapability {
	/**
	 * Returns the value of the '<em><b>Abstract</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract</em>' attribute.
	 * @see #isSetAbstract()
	 * @see #unsetAbstract()
	 * @see #setAbstract(boolean)
	 * @see com.ibm.ccl.soa.deploy.uml.UmlPackage#getUMLActor_Abstract()
	 * @model default="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='abstract'"
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.uml.UMLActor#isAbstract <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract</em>' attribute.
	 * @see #isSetAbstract()
	 * @see #unsetAbstract()
	 * @see #isAbstract()
	 * @generated
	 */
	void setAbstract(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.uml.UMLActor#isAbstract <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAbstract()
	 * @see #isAbstract()
	 * @see #setAbstract(boolean)
	 * @generated
	 */
	void unsetAbstract();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.uml.UMLActor#isAbstract <em>Abstract</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Abstract</em>' attribute is set.
	 * @see #unsetAbstract()
	 * @see #isAbstract()
	 * @see #setAbstract(boolean)
	 * @generated
	 */
	boolean isSetAbstract();

	/**
	 * Returns the value of the '<em><b>Leaf</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Leaf</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Leaf</em>' attribute.
	 * @see #isSetLeaf()
	 * @see #unsetLeaf()
	 * @see #setLeaf(boolean)
	 * @see com.ibm.ccl.soa.deploy.uml.UmlPackage#getUMLActor_Leaf()
	 * @model default="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='leaf'"
	 * @generated
	 */
	boolean isLeaf();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.uml.UMLActor#isLeaf <em>Leaf</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Leaf</em>' attribute.
	 * @see #isSetLeaf()
	 * @see #unsetLeaf()
	 * @see #isLeaf()
	 * @generated
	 */
	void setLeaf(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.uml.UMLActor#isLeaf <em>Leaf</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLeaf()
	 * @see #isLeaf()
	 * @see #setLeaf(boolean)
	 * @generated
	 */
	void unsetLeaf();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.uml.UMLActor#isLeaf <em>Leaf</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Leaf</em>' attribute is set.
	 * @see #unsetLeaf()
	 * @see #isLeaf()
	 * @see #setLeaf(boolean)
	 * @generated
	 */
	boolean isSetLeaf();

} // UMLActor
