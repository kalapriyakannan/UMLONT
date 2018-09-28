/**
 * <copyright>
 * </copyright>
 *
 * $Id: UmlFactory.java,v 1.10 2008/02/05 22:17:44 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.uml;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.uml.UmlPackage
 * @generated
 */
public interface UmlFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UmlFactory eINSTANCE = com.ibm.ccl.soa.deploy.uml.impl.UmlFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>UML Actor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>UML Actor</em>'.
	 * @generated
	 */
	UMLActor createUMLActor();

	/**
	 * Returns a new object of class '<em>UML Actor Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>UML Actor Unit</em>'.
	 * @generated
	 */
	UMLActorUnit createUMLActorUnit();

	/**
	 * Returns a new object of class '<em>UML Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>UML Component</em>'.
	 * @generated
	 */
	UMLComponent createUMLComponent();

	/**
	 * Returns a new object of class '<em>UML Deploy Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>UML Deploy Root</em>'.
	 * @generated
	 */
	UMLDeployRoot createUMLDeployRoot();

	/**
	 * Returns a new object of class '<em>UML Element Artifact</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>UML Element Artifact</em>'.
	 * @generated
	 */
	UMLElementArtifact createUMLElementArtifact();

	/**
	 * Returns a new object of class '<em>UML Interaction Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>UML Interaction Constraint</em>'.
	 * @generated
	 */
	UMLInteractionConstraint createUMLInteractionConstraint();

	/**
	 * Returns a new object of class '<em>UML Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>UML Interface</em>'.
	 * @generated
	 */
	UMLInterface createUMLInterface();

	/**
	 * Returns a new object of class '<em>UML Interface Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>UML Interface Unit</em>'.
	 * @generated
	 */
	UMLInterfaceUnit createUMLInterfaceUnit();

	/**
	 * Returns a new object of class '<em>UML Package Cap</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>UML Package Cap</em>'.
	 * @generated
	 */
	UMLPackageCap createUMLPackageCap();

	/**
	 * Returns a new object of class '<em>UML Package Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>UML Package Unit</em>'.
	 * @generated
	 */
	UMLPackageUnit createUMLPackageUnit();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	UmlPackage getUmlPackage();

} //UmlFactory
