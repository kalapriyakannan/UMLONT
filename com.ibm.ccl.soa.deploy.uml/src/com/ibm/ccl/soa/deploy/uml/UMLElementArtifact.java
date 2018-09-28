/**
 * <copyright>
 * </copyright>
 *
 * $Id: UMLElementArtifact.java,v 1.1 2007/10/16 21:13:47 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.uml;

import com.ibm.ccl.soa.deploy.core.Artifact;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Element Artifact</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				An artifact that represents a file resource.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.uml.UMLElementArtifact#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.uml.UMLElementArtifact#getResourceURI <em>Resource URI</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.uml.UmlPackage#getUMLElementArtifact()
 * @model extendedMetaData="name='UMLElementArtifact' kind='elementOnly'"
 * @generated
 */
public interface UMLElementArtifact extends Artifact {
	/**
	 * Returns the value of the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualified Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualified Name</em>' attribute.
	 * @see #setQualifiedName(String)
	 * @see com.ibm.ccl.soa.deploy.uml.UmlPackage#getUMLElementArtifact_QualifiedName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='qualifiedName'"
	 * @generated
	 */
	String getQualifiedName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.uml.UMLElementArtifact#getQualifiedName <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualified Name</em>' attribute.
	 * @see #getQualifiedName()
	 * @generated
	 */
	void setQualifiedName(String value);

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
	 * @see com.ibm.ccl.soa.deploy.uml.UmlPackage#getUMLElementArtifact_ResourceURI()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='resourceURI'"
	 * @generated
	 */
	String getResourceURI();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.uml.UMLElementArtifact#getResourceURI <em>Resource URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource URI</em>' attribute.
	 * @see #getResourceURI()
	 * @generated
	 */
	void setResourceURI(String value);

} // UMLElementArtifact
