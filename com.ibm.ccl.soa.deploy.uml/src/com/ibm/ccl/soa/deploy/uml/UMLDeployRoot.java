/**
 * <copyright>
 * </copyright>
 *
 * $Id: UMLDeployRoot.java,v 1.10 2008/02/05 22:17:44 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.uml;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>UML Deploy Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getArtifactUmlElement <em>Artifact Uml Element</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getCapabilityUmlActor <em>Capability Uml Actor</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getCapabilityUmlComponent <em>Capability Uml Component</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getCapabilityUmlInterface <em>Capability Uml Interface</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getCapabilityUmlPackageCap <em>Capability Uml Package Cap</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getConstraintUmlInteraction <em>Constraint Uml Interaction</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getUnitUmlActorUnit <em>Unit Uml Actor Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getUnitUmlInterfaceUnit <em>Unit Uml Interface Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getUnitUmlPackageUnit <em>Unit Uml Package Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.uml.UmlPackage#getUMLDeployRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface UMLDeployRoot extends EObject {
	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see com.ibm.ccl.soa.deploy.uml.UmlPackage#getUMLDeployRoot_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XMLNS Prefix Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XMLNS Prefix Map</em>' map.
	 * @see com.ibm.ccl.soa.deploy.uml.UmlPackage#getUMLDeployRoot_XMLNSPrefixMap()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String" valueType="java.lang.String" transient="true"
	 *        extendedMetaData="kind='attribute' name='xmlns:prefix'"
	 * @generated
	 */
	EMap getXMLNSPrefixMap();

	/**
	 * Returns the value of the '<em><b>XSI Schema Location</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XSI Schema Location</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XSI Schema Location</em>' map.
	 * @see com.ibm.ccl.soa.deploy.uml.UmlPackage#getUMLDeployRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String" valueType="java.lang.String" transient="true"
	 *        extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
	 * @generated
	 */
	EMap getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Artifact Uml Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Artifact Uml Element</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Artifact Uml Element</em>' containment reference.
	 * @see #setArtifactUmlElement(UMLElementArtifact)
	 * @see com.ibm.ccl.soa.deploy.uml.UmlPackage#getUMLDeployRoot_ArtifactUmlElement()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='artifact.umlElement' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#artifact'"
	 * @generated
	 */
	UMLElementArtifact getArtifactUmlElement();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getArtifactUmlElement <em>Artifact Uml Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Artifact Uml Element</em>' containment reference.
	 * @see #getArtifactUmlElement()
	 * @generated
	 */
	void setArtifactUmlElement(UMLElementArtifact value);

	/**
	 * Returns the value of the '<em><b>Capability Uml Actor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Uml Actor</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Uml Actor</em>' containment reference.
	 * @see #setCapabilityUmlActor(UMLActor)
	 * @see com.ibm.ccl.soa.deploy.uml.UmlPackage#getUMLDeployRoot_CapabilityUmlActor()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.umlActor' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	UMLActor getCapabilityUmlActor();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getCapabilityUmlActor <em>Capability Uml Actor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Uml Actor</em>' containment reference.
	 * @see #getCapabilityUmlActor()
	 * @generated
	 */
	void setCapabilityUmlActor(UMLActor value);

	/**
	 * Returns the value of the '<em><b>Capability Uml Component</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Uml Component</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Uml Component</em>' containment reference.
	 * @see #setCapabilityUmlComponent(UMLComponent)
	 * @see com.ibm.ccl.soa.deploy.uml.UmlPackage#getUMLDeployRoot_CapabilityUmlComponent()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.umlComponent' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	UMLComponent getCapabilityUmlComponent();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getCapabilityUmlComponent <em>Capability Uml Component</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Uml Component</em>' containment reference.
	 * @see #getCapabilityUmlComponent()
	 * @generated
	 */
	void setCapabilityUmlComponent(UMLComponent value);

	/**
	 * Returns the value of the '<em><b>Capability Uml Interface</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Uml Interface</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Uml Interface</em>' containment reference.
	 * @see #setCapabilityUmlInterface(UMLInterface)
	 * @see com.ibm.ccl.soa.deploy.uml.UmlPackage#getUMLDeployRoot_CapabilityUmlInterface()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.umlInterface' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	UMLInterface getCapabilityUmlInterface();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getCapabilityUmlInterface <em>Capability Uml Interface</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Uml Interface</em>' containment reference.
	 * @see #getCapabilityUmlInterface()
	 * @generated
	 */
	void setCapabilityUmlInterface(UMLInterface value);

	/**
	 * Returns the value of the '<em><b>Capability Uml Package Cap</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Uml Package Cap</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Uml Package Cap</em>' containment reference.
	 * @see #setCapabilityUmlPackageCap(UMLPackageCap)
	 * @see com.ibm.ccl.soa.deploy.uml.UmlPackage#getUMLDeployRoot_CapabilityUmlPackageCap()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.umlPackageCap' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	UMLPackageCap getCapabilityUmlPackageCap();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getCapabilityUmlPackageCap <em>Capability Uml Package Cap</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Uml Package Cap</em>' containment reference.
	 * @see #getCapabilityUmlPackageCap()
	 * @generated
	 */
	void setCapabilityUmlPackageCap(UMLPackageCap value);

	/**
	 * Returns the value of the '<em><b>Constraint Uml Interaction</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Uml Interaction</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Uml Interaction</em>' containment reference.
	 * @see #setConstraintUmlInteraction(UMLInteractionConstraint)
	 * @see com.ibm.ccl.soa.deploy.uml.UmlPackage#getUMLDeployRoot_ConstraintUmlInteraction()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.umlInteraction' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	UMLInteractionConstraint getConstraintUmlInteraction();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getConstraintUmlInteraction <em>Constraint Uml Interaction</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint Uml Interaction</em>' containment reference.
	 * @see #getConstraintUmlInteraction()
	 * @generated
	 */
	void setConstraintUmlInteraction(UMLInteractionConstraint value);

	/**
	 * Returns the value of the '<em><b>Unit Uml Actor Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 				This is a unit that is Zephyr representation of a UML actor.
	 * 			
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Unit Uml Actor Unit</em>' containment reference.
	 * @see #setUnitUmlActorUnit(UMLActorUnit)
	 * @see com.ibm.ccl.soa.deploy.uml.UmlPackage#getUMLDeployRoot_UnitUmlActorUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.umlActorUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#baseComponent'"
	 * @generated
	 */
	UMLActorUnit getUnitUmlActorUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getUnitUmlActorUnit <em>Unit Uml Actor Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Uml Actor Unit</em>' containment reference.
	 * @see #getUnitUmlActorUnit()
	 * @generated
	 */
	void setUnitUmlActorUnit(UMLActorUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Uml Interface Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 				This is a unit that is Zephyr representation of a UML interface.
	 * 			
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Unit Uml Interface Unit</em>' containment reference.
	 * @see #setUnitUmlInterfaceUnit(UMLInterfaceUnit)
	 * @see com.ibm.ccl.soa.deploy.uml.UmlPackage#getUMLDeployRoot_UnitUmlInterfaceUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.umlInterfaceUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	UMLInterfaceUnit getUnitUmlInterfaceUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getUnitUmlInterfaceUnit <em>Unit Uml Interface Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Uml Interface Unit</em>' containment reference.
	 * @see #getUnitUmlInterfaceUnit()
	 * @generated
	 */
	void setUnitUmlInterfaceUnit(UMLInterfaceUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Uml Package Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 				This is a unit that is Zephyr representation of a UML package.
	 * 			
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Unit Uml Package Unit</em>' containment reference.
	 * @see #setUnitUmlPackageUnit(UMLPackageUnit)
	 * @see com.ibm.ccl.soa.deploy.uml.UmlPackage#getUMLDeployRoot_UnitUmlPackageUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.umlPackageUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	UMLPackageUnit getUnitUmlPackageUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.uml.UMLDeployRoot#getUnitUmlPackageUnit <em>Unit Uml Package Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Uml Package Unit</em>' containment reference.
	 * @see #getUnitUmlPackageUnit()
	 * @generated
	 */
	void setUnitUmlPackageUnit(UMLPackageUnit value);

} // UMLDeployRoot
