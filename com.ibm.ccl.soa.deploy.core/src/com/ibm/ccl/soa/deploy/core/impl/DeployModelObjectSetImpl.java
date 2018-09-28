/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.impl;

import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObjectSet;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Deploy Model Object Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployModelObjectSetImpl#getDeployModelObjectGroup <em>Deploy Model Object Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployModelObjectSetImpl#getDeployModelObject <em>Deploy Model Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeployModelObjectSetImpl extends EObjectImpl implements DeployModelObjectSet {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getDeployModelObjectGroup() <em>Deploy Model Object Group</em>}' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDeployModelObjectGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap deployModelObjectGroup;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DeployModelObjectSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.DEPLOY_MODEL_OBJECT_SET;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getDeployModelObjectGroup() {
		if (deployModelObjectGroup == null) {
			deployModelObjectGroup = new BasicFeatureMap(this, CorePackage.DEPLOY_MODEL_OBJECT_SET__DEPLOY_MODEL_OBJECT_GROUP);
		}
		return deployModelObjectGroup;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public List getDeployModelObject() {
		return getDeployModelObjectGroup().list(CorePackage.Literals.DEPLOY_MODEL_OBJECT_SET__DEPLOY_MODEL_OBJECT);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.DEPLOY_MODEL_OBJECT_SET__DEPLOY_MODEL_OBJECT_GROUP:
				return ((InternalEList)getDeployModelObjectGroup()).basicRemove(otherEnd, msgs);
			case CorePackage.DEPLOY_MODEL_OBJECT_SET__DEPLOY_MODEL_OBJECT:
				return ((InternalEList)getDeployModelObject()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.DEPLOY_MODEL_OBJECT_SET__DEPLOY_MODEL_OBJECT_GROUP:
				if (coreType) return getDeployModelObjectGroup();
				return ((FeatureMap.Internal)getDeployModelObjectGroup()).getWrapper();
			case CorePackage.DEPLOY_MODEL_OBJECT_SET__DEPLOY_MODEL_OBJECT:
				return getDeployModelObject();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CorePackage.DEPLOY_MODEL_OBJECT_SET__DEPLOY_MODEL_OBJECT_GROUP:
				((FeatureMap.Internal)getDeployModelObjectGroup()).set(newValue);
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
			case CorePackage.DEPLOY_MODEL_OBJECT_SET__DEPLOY_MODEL_OBJECT_GROUP:
				getDeployModelObjectGroup().clear();
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
			case CorePackage.DEPLOY_MODEL_OBJECT_SET__DEPLOY_MODEL_OBJECT_GROUP:
				return deployModelObjectGroup != null && !deployModelObjectGroup.isEmpty();
			case CorePackage.DEPLOY_MODEL_OBJECT_SET__DEPLOY_MODEL_OBJECT:
				return !getDeployModelObject().isEmpty();
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
		result.append(" (deployModelObjectGroup: "); //$NON-NLS-1$
		result.append(deployModelObjectGroup);
		result.append(')');
		return result.toString();
	}

} //DeployModelObjectSetImpl
