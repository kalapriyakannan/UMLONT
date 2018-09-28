/**
 * <copyright> </copyright>
 * 
 * $Id: UMLElementArtifactImpl.java,v 1.4 2008/07/24 17:57:38 blancett Exp $
 */
package com.ibm.ccl.soa.deploy.uml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.ArtifactImpl;
import com.ibm.ccl.soa.deploy.uml.UMLElementArtifact;
import com.ibm.ccl.soa.deploy.uml.UmlPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>UML Element Artifact</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.ibm.ccl.soa.deploy.uml.impl.UMLElementArtifactImpl#getQualifiedName <em>Qualified Name</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.uml.impl.UMLElementArtifactImpl#getResourceURI <em>Resource URI</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class UMLElementArtifactImpl extends ArtifactImpl implements UMLElementArtifact {
	/**
	 * The default value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected static final String QUALIFIED_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected String qualifiedName = QUALIFIED_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getResourceURI() <em>Resource URI</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getResourceURI()
	 * @generated
	 * @ordered
	 */
	protected static final String RESOURCE_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResourceURI() <em>Resource URI</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getResourceURI()
	 * @generated
	 * @ordered
	 */
	protected String resourceURI = RESOURCE_URI_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected UMLElementArtifactImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UmlPackage.Literals.UML_ELEMENT_ARTIFACT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getQualifiedName() {
		return qualifiedName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setQualifiedName(String newQualifiedName) {
		String oldQualifiedName = qualifiedName;
		qualifiedName = newQualifiedName;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					UmlPackage.UML_ELEMENT_ARTIFACT__QUALIFIED_NAME, oldQualifiedName, qualifiedName));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getResourceURI() {
		return resourceURI;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setResourceURI(String newResourceURI) {
		String oldResourceURI = resourceURI;
		resourceURI = newResourceURI;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					UmlPackage.UML_ELEMENT_ARTIFACT__RESOURCE_URI, oldResourceURI, resourceURI));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case UmlPackage.UML_ELEMENT_ARTIFACT__QUALIFIED_NAME:
			return getQualifiedName();
		case UmlPackage.UML_ELEMENT_ARTIFACT__RESOURCE_URI:
			return getResourceURI();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
		case UmlPackage.UML_ELEMENT_ARTIFACT__QUALIFIED_NAME:
			setQualifiedName((String) newValue);
			return;
		case UmlPackage.UML_ELEMENT_ARTIFACT__RESOURCE_URI:
			setResourceURI((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID)
		{
		case UmlPackage.UML_ELEMENT_ARTIFACT__QUALIFIED_NAME:
			setQualifiedName(QUALIFIED_NAME_EDEFAULT);
			return;
		case UmlPackage.UML_ELEMENT_ARTIFACT__RESOURCE_URI:
			setResourceURI(RESOURCE_URI_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
		case UmlPackage.UML_ELEMENT_ARTIFACT__QUALIFIED_NAME:
			return QUALIFIED_NAME_EDEFAULT == null ? qualifiedName != null : !QUALIFIED_NAME_EDEFAULT
					.equals(qualifiedName);
		case UmlPackage.UML_ELEMENT_ARTIFACT__RESOURCE_URI:
			return RESOURCE_URI_EDEFAULT == null ? resourceURI != null : !RESOURCE_URI_EDEFAULT
					.equals(resourceURI);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (qualifiedName: "); //$NON-NLS-1$
		result.append(qualifiedName);
		result.append(", resourceURI: "); //$NON-NLS-1$
		result.append(resourceURI);
		result.append(')');
		return result.toString();
	}

} //UMLElementArtifactImpl
