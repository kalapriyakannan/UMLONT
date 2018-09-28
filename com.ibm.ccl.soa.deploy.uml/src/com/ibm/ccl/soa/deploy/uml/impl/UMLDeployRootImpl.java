/**
 * <copyright>
 * </copyright>
 *
 * $Id: UMLDeployRootImpl.java,v 1.8 2007/12/10 21:57:46 nmakin Exp $
 */
package com.ibm.ccl.soa.deploy.uml.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.ibm.ccl.soa.deploy.uml.UMLActor;
import com.ibm.ccl.soa.deploy.uml.UMLActorUnit;
import com.ibm.ccl.soa.deploy.uml.UMLComponent;
import com.ibm.ccl.soa.deploy.uml.UMLDeployRoot;
import com.ibm.ccl.soa.deploy.uml.UMLElementArtifact;
import com.ibm.ccl.soa.deploy.uml.UMLInteractionConstraint;
import com.ibm.ccl.soa.deploy.uml.UMLInterface;
import com.ibm.ccl.soa.deploy.uml.UMLInterfaceUnit;
import com.ibm.ccl.soa.deploy.uml.UMLPackageCap;
import com.ibm.ccl.soa.deploy.uml.UMLPackageUnit;
import com.ibm.ccl.soa.deploy.uml.UmlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>UML Deploy Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.uml.impl.UMLDeployRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.uml.impl.UMLDeployRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.uml.impl.UMLDeployRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.uml.impl.UMLDeployRootImpl#getArtifactUmlElement <em>Artifact Uml Element</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.uml.impl.UMLDeployRootImpl#getCapabilityUmlActor <em>Capability Uml Actor</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.uml.impl.UMLDeployRootImpl#getCapabilityUmlComponent <em>Capability Uml Component</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.uml.impl.UMLDeployRootImpl#getCapabilityUmlInterface <em>Capability Uml Interface</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.uml.impl.UMLDeployRootImpl#getCapabilityUmlPackageCap <em>Capability Uml Package Cap</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.uml.impl.UMLDeployRootImpl#getConstraintUmlInteraction <em>Constraint Uml Interaction</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.uml.impl.UMLDeployRootImpl#getUnitUmlActorUnit <em>Unit Uml Actor Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.uml.impl.UMLDeployRootImpl#getUnitUmlInterfaceUnit <em>Unit Uml Interface Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.uml.impl.UMLDeployRootImpl#getUnitUmlPackageUnit <em>Unit Uml Package Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UMLDeployRootImpl extends EObjectImpl implements UMLDeployRoot {
	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXMLNSPrefixMap()
	 * @generated
	 * @ordered
	 */
	protected EMap xMLNSPrefixMap;

	/**
	 * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXSISchemaLocation()
	 * @generated
	 * @ordered
	 */
	protected EMap xSISchemaLocation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UMLDeployRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UmlPackage.Literals.UML_DEPLOY_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, UmlPackage.UML_DEPLOY_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, UmlPackage.UML_DEPLOY_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, UmlPackage.UML_DEPLOY_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMLElementArtifact getArtifactUmlElement() {
		return (UMLElementArtifact)getMixed().get(UmlPackage.Literals.UML_DEPLOY_ROOT__ARTIFACT_UML_ELEMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetArtifactUmlElement(UMLElementArtifact newArtifactUmlElement, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(UmlPackage.Literals.UML_DEPLOY_ROOT__ARTIFACT_UML_ELEMENT, newArtifactUmlElement, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArtifactUmlElement(UMLElementArtifact newArtifactUmlElement) {
		((FeatureMap.Internal)getMixed()).set(UmlPackage.Literals.UML_DEPLOY_ROOT__ARTIFACT_UML_ELEMENT, newArtifactUmlElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMLActor getCapabilityUmlActor() {
		return (UMLActor)getMixed().get(UmlPackage.Literals.UML_DEPLOY_ROOT__CAPABILITY_UML_ACTOR, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityUmlActor(UMLActor newCapabilityUmlActor, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(UmlPackage.Literals.UML_DEPLOY_ROOT__CAPABILITY_UML_ACTOR, newCapabilityUmlActor, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityUmlActor(UMLActor newCapabilityUmlActor) {
		((FeatureMap.Internal)getMixed()).set(UmlPackage.Literals.UML_DEPLOY_ROOT__CAPABILITY_UML_ACTOR, newCapabilityUmlActor);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMLComponent getCapabilityUmlComponent() {
		return (UMLComponent)getMixed().get(UmlPackage.Literals.UML_DEPLOY_ROOT__CAPABILITY_UML_COMPONENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityUmlComponent(UMLComponent newCapabilityUmlComponent, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(UmlPackage.Literals.UML_DEPLOY_ROOT__CAPABILITY_UML_COMPONENT, newCapabilityUmlComponent, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityUmlComponent(UMLComponent newCapabilityUmlComponent) {
		((FeatureMap.Internal)getMixed()).set(UmlPackage.Literals.UML_DEPLOY_ROOT__CAPABILITY_UML_COMPONENT, newCapabilityUmlComponent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMLInterface getCapabilityUmlInterface() {
		return (UMLInterface)getMixed().get(UmlPackage.Literals.UML_DEPLOY_ROOT__CAPABILITY_UML_INTERFACE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityUmlInterface(UMLInterface newCapabilityUmlInterface, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(UmlPackage.Literals.UML_DEPLOY_ROOT__CAPABILITY_UML_INTERFACE, newCapabilityUmlInterface, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityUmlInterface(UMLInterface newCapabilityUmlInterface) {
		((FeatureMap.Internal)getMixed()).set(UmlPackage.Literals.UML_DEPLOY_ROOT__CAPABILITY_UML_INTERFACE, newCapabilityUmlInterface);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMLPackageCap getCapabilityUmlPackageCap() {
		return (UMLPackageCap)getMixed().get(UmlPackage.Literals.UML_DEPLOY_ROOT__CAPABILITY_UML_PACKAGE_CAP, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityUmlPackageCap(UMLPackageCap newCapabilityUmlPackageCap, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(UmlPackage.Literals.UML_DEPLOY_ROOT__CAPABILITY_UML_PACKAGE_CAP, newCapabilityUmlPackageCap, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityUmlPackageCap(UMLPackageCap newCapabilityUmlPackageCap) {
		((FeatureMap.Internal)getMixed()).set(UmlPackage.Literals.UML_DEPLOY_ROOT__CAPABILITY_UML_PACKAGE_CAP, newCapabilityUmlPackageCap);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMLInteractionConstraint getConstraintUmlInteraction() {
		return (UMLInteractionConstraint)getMixed().get(UmlPackage.Literals.UML_DEPLOY_ROOT__CONSTRAINT_UML_INTERACTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConstraintUmlInteraction(UMLInteractionConstraint newConstraintUmlInteraction, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(UmlPackage.Literals.UML_DEPLOY_ROOT__CONSTRAINT_UML_INTERACTION, newConstraintUmlInteraction, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraintUmlInteraction(UMLInteractionConstraint newConstraintUmlInteraction) {
		((FeatureMap.Internal)getMixed()).set(UmlPackage.Literals.UML_DEPLOY_ROOT__CONSTRAINT_UML_INTERACTION, newConstraintUmlInteraction);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMLActorUnit getUnitUmlActorUnit() {
		return (UMLActorUnit)getMixed().get(UmlPackage.Literals.UML_DEPLOY_ROOT__UNIT_UML_ACTOR_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitUmlActorUnit(UMLActorUnit newUnitUmlActorUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(UmlPackage.Literals.UML_DEPLOY_ROOT__UNIT_UML_ACTOR_UNIT, newUnitUmlActorUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitUmlActorUnit(UMLActorUnit newUnitUmlActorUnit) {
		((FeatureMap.Internal)getMixed()).set(UmlPackage.Literals.UML_DEPLOY_ROOT__UNIT_UML_ACTOR_UNIT, newUnitUmlActorUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMLInterfaceUnit getUnitUmlInterfaceUnit() {
		return (UMLInterfaceUnit)getMixed().get(UmlPackage.Literals.UML_DEPLOY_ROOT__UNIT_UML_INTERFACE_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitUmlInterfaceUnit(UMLInterfaceUnit newUnitUmlInterfaceUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(UmlPackage.Literals.UML_DEPLOY_ROOT__UNIT_UML_INTERFACE_UNIT, newUnitUmlInterfaceUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitUmlInterfaceUnit(UMLInterfaceUnit newUnitUmlInterfaceUnit) {
		((FeatureMap.Internal)getMixed()).set(UmlPackage.Literals.UML_DEPLOY_ROOT__UNIT_UML_INTERFACE_UNIT, newUnitUmlInterfaceUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UMLPackageUnit getUnitUmlPackageUnit() {
		return (UMLPackageUnit)getMixed().get(UmlPackage.Literals.UML_DEPLOY_ROOT__UNIT_UML_PACKAGE_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitUmlPackageUnit(UMLPackageUnit newUnitUmlPackageUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(UmlPackage.Literals.UML_DEPLOY_ROOT__UNIT_UML_PACKAGE_UNIT, newUnitUmlPackageUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitUmlPackageUnit(UMLPackageUnit newUnitUmlPackageUnit) {
		((FeatureMap.Internal)getMixed()).set(UmlPackage.Literals.UML_DEPLOY_ROOT__UNIT_UML_PACKAGE_UNIT, newUnitUmlPackageUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UmlPackage.UML_DEPLOY_ROOT__MIXED:
				return ((InternalEList)getMixed()).basicRemove(otherEnd, msgs);
			case UmlPackage.UML_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case UmlPackage.UML_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case UmlPackage.UML_DEPLOY_ROOT__ARTIFACT_UML_ELEMENT:
				return basicSetArtifactUmlElement(null, msgs);
			case UmlPackage.UML_DEPLOY_ROOT__CAPABILITY_UML_ACTOR:
				return basicSetCapabilityUmlActor(null, msgs);
			case UmlPackage.UML_DEPLOY_ROOT__CAPABILITY_UML_COMPONENT:
				return basicSetCapabilityUmlComponent(null, msgs);
			case UmlPackage.UML_DEPLOY_ROOT__CAPABILITY_UML_INTERFACE:
				return basicSetCapabilityUmlInterface(null, msgs);
			case UmlPackage.UML_DEPLOY_ROOT__CAPABILITY_UML_PACKAGE_CAP:
				return basicSetCapabilityUmlPackageCap(null, msgs);
			case UmlPackage.UML_DEPLOY_ROOT__CONSTRAINT_UML_INTERACTION:
				return basicSetConstraintUmlInteraction(null, msgs);
			case UmlPackage.UML_DEPLOY_ROOT__UNIT_UML_ACTOR_UNIT:
				return basicSetUnitUmlActorUnit(null, msgs);
			case UmlPackage.UML_DEPLOY_ROOT__UNIT_UML_INTERFACE_UNIT:
				return basicSetUnitUmlInterfaceUnit(null, msgs);
			case UmlPackage.UML_DEPLOY_ROOT__UNIT_UML_PACKAGE_UNIT:
				return basicSetUnitUmlPackageUnit(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UmlPackage.UML_DEPLOY_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case UmlPackage.UML_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case UmlPackage.UML_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case UmlPackage.UML_DEPLOY_ROOT__ARTIFACT_UML_ELEMENT:
				return getArtifactUmlElement();
			case UmlPackage.UML_DEPLOY_ROOT__CAPABILITY_UML_ACTOR:
				return getCapabilityUmlActor();
			case UmlPackage.UML_DEPLOY_ROOT__CAPABILITY_UML_COMPONENT:
				return getCapabilityUmlComponent();
			case UmlPackage.UML_DEPLOY_ROOT__CAPABILITY_UML_INTERFACE:
				return getCapabilityUmlInterface();
			case UmlPackage.UML_DEPLOY_ROOT__CAPABILITY_UML_PACKAGE_CAP:
				return getCapabilityUmlPackageCap();
			case UmlPackage.UML_DEPLOY_ROOT__CONSTRAINT_UML_INTERACTION:
				return getConstraintUmlInteraction();
			case UmlPackage.UML_DEPLOY_ROOT__UNIT_UML_ACTOR_UNIT:
				return getUnitUmlActorUnit();
			case UmlPackage.UML_DEPLOY_ROOT__UNIT_UML_INTERFACE_UNIT:
				return getUnitUmlInterfaceUnit();
			case UmlPackage.UML_DEPLOY_ROOT__UNIT_UML_PACKAGE_UNIT:
				return getUnitUmlPackageUnit();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case UmlPackage.UML_DEPLOY_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case UmlPackage.UML_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case UmlPackage.UML_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case UmlPackage.UML_DEPLOY_ROOT__ARTIFACT_UML_ELEMENT:
				setArtifactUmlElement((UMLElementArtifact)newValue);
				return;
			case UmlPackage.UML_DEPLOY_ROOT__CAPABILITY_UML_ACTOR:
				setCapabilityUmlActor((UMLActor)newValue);
				return;
			case UmlPackage.UML_DEPLOY_ROOT__CAPABILITY_UML_COMPONENT:
				setCapabilityUmlComponent((UMLComponent)newValue);
				return;
			case UmlPackage.UML_DEPLOY_ROOT__CAPABILITY_UML_INTERFACE:
				setCapabilityUmlInterface((UMLInterface)newValue);
				return;
			case UmlPackage.UML_DEPLOY_ROOT__CAPABILITY_UML_PACKAGE_CAP:
				setCapabilityUmlPackageCap((UMLPackageCap)newValue);
				return;
			case UmlPackage.UML_DEPLOY_ROOT__CONSTRAINT_UML_INTERACTION:
				setConstraintUmlInteraction((UMLInteractionConstraint)newValue);
				return;
			case UmlPackage.UML_DEPLOY_ROOT__UNIT_UML_ACTOR_UNIT:
				setUnitUmlActorUnit((UMLActorUnit)newValue);
				return;
			case UmlPackage.UML_DEPLOY_ROOT__UNIT_UML_INTERFACE_UNIT:
				setUnitUmlInterfaceUnit((UMLInterfaceUnit)newValue);
				return;
			case UmlPackage.UML_DEPLOY_ROOT__UNIT_UML_PACKAGE_UNIT:
				setUnitUmlPackageUnit((UMLPackageUnit)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case UmlPackage.UML_DEPLOY_ROOT__MIXED:
				getMixed().clear();
				return;
			case UmlPackage.UML_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case UmlPackage.UML_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case UmlPackage.UML_DEPLOY_ROOT__ARTIFACT_UML_ELEMENT:
				setArtifactUmlElement((UMLElementArtifact)null);
				return;
			case UmlPackage.UML_DEPLOY_ROOT__CAPABILITY_UML_ACTOR:
				setCapabilityUmlActor((UMLActor)null);
				return;
			case UmlPackage.UML_DEPLOY_ROOT__CAPABILITY_UML_COMPONENT:
				setCapabilityUmlComponent((UMLComponent)null);
				return;
			case UmlPackage.UML_DEPLOY_ROOT__CAPABILITY_UML_INTERFACE:
				setCapabilityUmlInterface((UMLInterface)null);
				return;
			case UmlPackage.UML_DEPLOY_ROOT__CAPABILITY_UML_PACKAGE_CAP:
				setCapabilityUmlPackageCap((UMLPackageCap)null);
				return;
			case UmlPackage.UML_DEPLOY_ROOT__CONSTRAINT_UML_INTERACTION:
				setConstraintUmlInteraction((UMLInteractionConstraint)null);
				return;
			case UmlPackage.UML_DEPLOY_ROOT__UNIT_UML_ACTOR_UNIT:
				setUnitUmlActorUnit((UMLActorUnit)null);
				return;
			case UmlPackage.UML_DEPLOY_ROOT__UNIT_UML_INTERFACE_UNIT:
				setUnitUmlInterfaceUnit((UMLInterfaceUnit)null);
				return;
			case UmlPackage.UML_DEPLOY_ROOT__UNIT_UML_PACKAGE_UNIT:
				setUnitUmlPackageUnit((UMLPackageUnit)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case UmlPackage.UML_DEPLOY_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case UmlPackage.UML_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case UmlPackage.UML_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case UmlPackage.UML_DEPLOY_ROOT__ARTIFACT_UML_ELEMENT:
				return getArtifactUmlElement() != null;
			case UmlPackage.UML_DEPLOY_ROOT__CAPABILITY_UML_ACTOR:
				return getCapabilityUmlActor() != null;
			case UmlPackage.UML_DEPLOY_ROOT__CAPABILITY_UML_COMPONENT:
				return getCapabilityUmlComponent() != null;
			case UmlPackage.UML_DEPLOY_ROOT__CAPABILITY_UML_INTERFACE:
				return getCapabilityUmlInterface() != null;
			case UmlPackage.UML_DEPLOY_ROOT__CAPABILITY_UML_PACKAGE_CAP:
				return getCapabilityUmlPackageCap() != null;
			case UmlPackage.UML_DEPLOY_ROOT__CONSTRAINT_UML_INTERACTION:
				return getConstraintUmlInteraction() != null;
			case UmlPackage.UML_DEPLOY_ROOT__UNIT_UML_ACTOR_UNIT:
				return getUnitUmlActorUnit() != null;
			case UmlPackage.UML_DEPLOY_ROOT__UNIT_UML_INTERFACE_UNIT:
				return getUnitUmlInterfaceUnit() != null;
			case UmlPackage.UML_DEPLOY_ROOT__UNIT_UML_PACKAGE_UNIT:
				return getUnitUmlPackageUnit() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (mixed: "); //$NON-NLS-1$
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //UMLDeployRootImpl
