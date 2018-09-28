/**
 * <copyright> </copyright>
 * 
 * $Id: UmlFactoryImpl.java,v 1.12 2008/02/05 22:17:44 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.uml.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

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
import com.ibm.ccl.soa.deploy.uml.UMLVisibilityKind;
import com.ibm.ccl.soa.deploy.uml.UmlFactory;
import com.ibm.ccl.soa.deploy.uml.UmlPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class UmlFactoryImpl extends EFactoryImpl implements UmlFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static UmlFactory init() {
		try {
			UmlFactory theUmlFactory = (UmlFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.ibm.com/ccl/soa/deploy/uml/1.0.0/"); //$NON-NLS-1$ 
			if (theUmlFactory != null) {
				return theUmlFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UmlFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UmlFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case UmlPackage.UML_ACTOR: return createUMLActor();
			case UmlPackage.UML_ACTOR_UNIT: return createUMLActorUnit();
			case UmlPackage.UML_COMPONENT: return createUMLComponent();
			case UmlPackage.UML_DEPLOY_ROOT: return createUMLDeployRoot();
			case UmlPackage.UML_ELEMENT_ARTIFACT: return createUMLElementArtifact();
			case UmlPackage.UML_INTERACTION_CONSTRAINT: return createUMLInteractionConstraint();
			case UmlPackage.UML_INTERFACE: return createUMLInterface();
			case UmlPackage.UML_INTERFACE_UNIT: return createUMLInterfaceUnit();
			case UmlPackage.UML_PACKAGE_CAP: return createUMLPackageCap();
			case UmlPackage.UML_PACKAGE_UNIT: return createUMLPackageUnit();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case UmlPackage.UML_VISIBILITY_KIND:
				return createUMLVisibilityKindFromString(eDataType, initialValue);
			case UmlPackage.UML_VISIBILITY_KIND_OBJECT:
				return createUMLVisibilityKindObjectFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case UmlPackage.UML_VISIBILITY_KIND:
				return convertUMLVisibilityKindToString(eDataType, instanceValue);
			case UmlPackage.UML_VISIBILITY_KIND_OBJECT:
				return convertUMLVisibilityKindObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UMLActor createUMLActor() {
		UMLActorImpl umlActor = new UMLActorImpl();
		return umlActor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UMLActorUnit createUMLActorUnit() {
		UMLActorUnitImpl umlActorUnit = new UMLActorUnitImpl();
		return umlActorUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UMLComponent createUMLComponent() {
		UMLComponentImpl umlComponent = new UMLComponentImpl();
		return umlComponent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UMLDeployRoot createUMLDeployRoot() {
		UMLDeployRootImpl umlDeployRoot = new UMLDeployRootImpl();
		return umlDeployRoot;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UMLElementArtifact createUMLElementArtifact() {
		UMLElementArtifactImpl umlElementArtifact = new UMLElementArtifactImpl();
		return umlElementArtifact;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UMLInteractionConstraint createUMLInteractionConstraint() {
		UMLInteractionConstraintImpl umlInteractionConstraint = new UMLInteractionConstraintImpl();
		return umlInteractionConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UMLInterface createUMLInterface() {
		UMLInterfaceImpl umlInterface = new UMLInterfaceImpl();
		return umlInterface;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UMLInterfaceUnit createUMLInterfaceUnit() {
		UMLInterfaceUnitImpl umlInterfaceUnit = new UMLInterfaceUnitImpl();
		return umlInterfaceUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UMLPackageCap createUMLPackageCap() {
		UMLPackageCapImpl umlPackageCap = new UMLPackageCapImpl();
		return umlPackageCap;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UMLPackageUnit createUMLPackageUnit() {
		UMLPackageUnitImpl umlPackageUnit = new UMLPackageUnitImpl();
		return umlPackageUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UMLVisibilityKind createUMLVisibilityKindFromString(EDataType eDataType,
			String initialValue) {
		UMLVisibilityKind result = UMLVisibilityKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUMLVisibilityKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UMLVisibilityKind createUMLVisibilityKindObjectFromString(EDataType eDataType,
			String initialValue) {
		return createUMLVisibilityKindFromString(UmlPackage.Literals.UML_VISIBILITY_KIND, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUMLVisibilityKindObjectToString(EDataType eDataType, Object instanceValue) {
		return convertUMLVisibilityKindToString(UmlPackage.Literals.UML_VISIBILITY_KIND, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UmlPackage getUmlPackage() {
		return (UmlPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static UmlPackage getPackage() {
		return UmlPackage.eINSTANCE;
	}

} //UmlFactoryImpl
