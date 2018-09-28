/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Deploy Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployLinkImpl#getSourceURI <em>Source URI</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployLinkImpl#getTargetURI <em>Target URI</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeployLinkImpl extends DeployModelObjectImpl implements DeployLink {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getSourceURI() <em>Source URI</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSourceURI()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSourceURI() <em>Source URI</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSourceURI()
	 * @generated
	 * @ordered
	 */
	protected String sourceURI = SOURCE_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetURI() <em>Target URI</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTargetURI()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetURI() <em>Target URI</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTargetURI()
	 * @generated
	 * @ordered
	 */
	protected String targetURI = TARGET_URI_EDEFAULT;

	/**
	 * Transient cache of {@link sourceURI} as a referenc to a {@link DeployModelObject}
	 * 
	 * @generated NOT
	 */
	protected DeployModelObject sourceObject;

	/**
	 * Transient cache of {@link targetURI} as a referenc to a {@link DeployModelObject}
	 * 
	 * @generated NOT
	 */
	protected DeployModelObject targetObject;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DeployLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.DEPLOY_LINK;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String getSourceURI() {
		if (sourceObject != null) {
			return sourceObject.getFullPath();
		}
		return sourceURI;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceURIGen(String newSourceURI) {
		String oldSourceURI = sourceURI;
		sourceURI = newSourceURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.DEPLOY_LINK__SOURCE_URI, oldSourceURI, sourceURI));
	}

	public void setSourceURI(String newSourceURI) {
		if (sourceObject != null) {
			String path = sourceObject.getFullPath();
			if (!path.equals(newSourceURI)) {
				sourceObject = null;
			}
		}
		setSourceURIGen(newSourceURI);
	}

	/**
	 * Sets the cached source object reference, and updates the {@link sourceURI} reference as a
	 * side-effect.
	 * 
	 * @param object
	 *           the source object.
	 * 
	 * @generated NOT
	 */
	public void setSourceObject(DeployModelObject object) {
		sourceObject = object;
		if (object == null) {
			setSourceURIGen(null);
		} else {
			String path = object.getFullPath();
			if (!path.equals(sourceURI)) {
				setSourceURIGen(path);
			}
		}
	}

	/**
	 * Returns the deploy object that is the source of the link.
	 * <p>
	 * It is possible for this method to return <code>null</code> even though
	 * {@link #getSourceURI()} is not <code>null</code>. This occurs when the URI cannot be
	 * resolved using {@link DeployModelObject#resolve(String)}.
	 * 
	 * @return the deploy model object that is the source of the link.
	 * 
	 * @generated NOT
	 */
	public DeployModelObject getSourceObject() {
		if (sourceObject != null) {
			return sourceObject;
		}
		if (sourceURI != null) {
			sourceObject = resolve(sourceURI);
		}
		return sourceObject;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String getTargetURI() {
		if (targetObject != null) {
			return targetObject.getFullPath();
		}
		return targetURI;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetURIGen(String newTargetURI) {
		String oldTargetURI = targetURI;
		targetURI = newTargetURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.DEPLOY_LINK__TARGET_URI, oldTargetURI, targetURI));
	}

	public void setTargetURI(String newTargetURI) {
		if (targetObject != null) {
			String path = targetObject.getFullPath();
			if (!path.equals(newTargetURI)) {
				targetObject = null;
			}
		}
		setTargetURIGen(newTargetURI);
	}

	/**
	 * Sets the cached target object reference, and updates the {@link targetURI} reference as a
	 * side-effect.
	 * 
	 * @param object
	 *           the target object.
	 * 
	 * @generated NOT
	 */
	public void setTargetObject(DeployModelObject object) {
		targetObject = object;
		if (object == null) {
			setTargetURIGen(null);
		} else {
			String path = object.getFullPath();
			if (!path.equals(targetURI)) {
				setTargetURIGen(path);
			}
		}
	}

	/**
	 * Returns the deploy object that is the target of the link.
	 * <p>
	 * It is possible for this method to return <code>null</code> even though
	 * {@link #getTargetURI()} is not <code>null</code>. This occurs when the URI cannot be
	 * resolved using {@link DeployModelObject#resolve(String)}.
	 * 
	 * @return the deploy model object that is the target of the link.
	 * 
	 * @generated NOT
	 */
	public DeployModelObject getTargetObject() {
		if (targetObject != null) {
			return targetObject;
		}
		if (targetURI != null) {
			targetObject = resolve(targetURI);
		}
		return targetObject;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.DEPLOY_LINK__SOURCE_URI:
				return getSourceURI();
			case CorePackage.DEPLOY_LINK__TARGET_URI:
				return getTargetURI();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CorePackage.DEPLOY_LINK__SOURCE_URI:
				setSourceURI((String)newValue);
				return;
			case CorePackage.DEPLOY_LINK__TARGET_URI:
				setTargetURI((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case CorePackage.DEPLOY_LINK__SOURCE_URI:
				setSourceURI(SOURCE_URI_EDEFAULT);
				return;
			case CorePackage.DEPLOY_LINK__TARGET_URI:
				setTargetURI(TARGET_URI_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CorePackage.DEPLOY_LINK__SOURCE_URI:
				return SOURCE_URI_EDEFAULT == null ? sourceURI != null : !SOURCE_URI_EDEFAULT.equals(sourceURI);
			case CorePackage.DEPLOY_LINK__TARGET_URI:
				return TARGET_URI_EDEFAULT == null ? targetURI != null : !TARGET_URI_EDEFAULT.equals(targetURI);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (sourceURI: "); //$NON-NLS-1$
		result.append(sourceURI);
		result.append(", targetURI: "); //$NON-NLS-1$
		result.append(targetURI);
		result.append(')');
		return result.toString();
	}

} //DeployLinkImpl
