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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import com.ibm.ccl.soa.deploy.core.Augmentation;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Instantiation;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Augmentation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.AugmentationImpl#getAdditions <em>Additions</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.AugmentationImpl#getFeature <em>Feature</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.AugmentationImpl#getSelect <em>Select</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class AugmentationImpl extends EObjectImpl implements Augmentation {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getAdditions() <em>Additions</em>}' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAdditions()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap additions;

	/**
	 * The default value of the '{@link #getFeature() <em>Feature</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFeature()
	 * @generated
	 * @ordered
	 */
	protected static final String FEATURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFeature() <em>Feature</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFeature()
	 * @generated
	 * @ordered
	 */
	protected String feature = FEATURE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSelect() <em>Select</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getSelect()
	 * @generated
	 * @ordered
	 */
	protected static final String SELECT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSelect() <em>Select</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getSelect()
	 * @generated
	 * @ordered
	 */
	protected String select = SELECT_EDEFAULT;

	protected EStructuralFeature logicalFeature;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AugmentationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.AUGMENTATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public FeatureMap getAdditions() {
		if (additions == null) {
			additions = createLogicalAdditions();
		}
		return additions;
	}

	protected Object convert(Object o) {
		if (o instanceof FeatureMap.Entry) {
			return ((FeatureMap.Entry) o).getValue();
		}
		return o;
	}

	protected BasicFeatureMap createLogicalAdditions() {
		return new BasicFeatureMap(this, CorePackage.AUGMENTATION__ADDITIONS) {
			private static final long serialVersionUID = 0L;

			@Override
			public EStructuralFeature getEStructuralFeature() {
				if (eResource() != null) {
					EObject logicalContainer = getOwner();
					if (logicalContainer != null) {
						logicalFeature = logicalContainer.eClass().getEStructuralFeature(getSelect());
//						featureMapValidator = FeatureMapUtil.getValidator(owner.eClass(), logicalFeature);
					}
				}
				return logicalFeature != null ? logicalFeature
						: CorePackage.Literals.AUGMENTATION__ADDITIONS;
			}

			public InternalEObject getOwner() {

				if (eResource() != null) {
					DeployModelObject referenced = getReferencedObject();
					if (referenced != null && !referenced.eIsProxy()) {
						InternalEObject logicalContainer = (InternalEObject) referenced.getEObject();

						if (logicalContainer != null && !logicalContainer.eIsProxy()) {
							return logicalContainer;
						}
					}
				}
				return AugmentationImpl.this;
			}

			@Override
			public Object getFeature() {
				return getEStructuralFeature();
			}

			@Override
			public int getFeatureID() {
				return ((EStructuralFeature) getFeature()).getFeatureID();
			}

			protected NotificationImpl createNotification(int eventType, Object oldObject,
					Object newObject, int index, boolean wasSet) {
				return new FeatureMapUtil.FeatureENotificationImpl(getOwner(), eventType,
						getEStructuralFeature(), convert(oldObject), convert(newObject), index, wasSet);

			}

			@Override
			protected Entry validate(int index, Entry object) {
				if (modCount == 0) {
					return object;
				}
				// Disable validation to support the dynamic features from the referenced model.

//				Entry result = super.validate(index, object);
//			    EStructuralFeature eStructuralFeature = object.getEStructuralFeature();
//			    if (!eStructuralFeature.isChangeable() || !featureMapValidator.isValid(eStructuralFeature))
//			    {
//			      throw
//			        new RuntimeException
//			          ("Invalid entry feature '" + eStructuralFeature.getEContainingClass().getName() + "." + eStructuralFeature.getName() + "'");
//			    }
				return object;
			}

		};
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getFeature() {
		return feature;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setFeature(String newFeature) {
		String oldFeature = feature;
		feature = newFeature;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.AUGMENTATION__FEATURE,
					oldFeature, feature));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getSelect() {
		return select;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSelect(String newSelect) {
		String oldSelect = select;
		select = newSelect;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.AUGMENTATION__SELECT,
					oldSelect, select));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID)
		{
		case CorePackage.AUGMENTATION__ADDITIONS:
			return ((InternalEList) getAdditions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case CorePackage.AUGMENTATION__ADDITIONS:
			if (coreType) {
				return getAdditions();
			}
			return ((FeatureMap.Internal) getAdditions()).getWrapper();
		case CorePackage.AUGMENTATION__FEATURE:
			return getFeature();
		case CorePackage.AUGMENTATION__SELECT:
			return getSelect();
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
		case CorePackage.AUGMENTATION__ADDITIONS:
			((FeatureMap.Internal) getAdditions()).set(newValue);
			return;
		case CorePackage.AUGMENTATION__FEATURE:
			setFeature((String) newValue);
			return;
		case CorePackage.AUGMENTATION__SELECT:
			setSelect((String) newValue);
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
		case CorePackage.AUGMENTATION__ADDITIONS:
			getAdditions().clear();
			return;
		case CorePackage.AUGMENTATION__FEATURE:
			setFeature(FEATURE_EDEFAULT);
			return;
		case CorePackage.AUGMENTATION__SELECT:
			setSelect(SELECT_EDEFAULT);
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
		case CorePackage.AUGMENTATION__ADDITIONS:
			return additions != null && !additions.isEmpty();
		case CorePackage.AUGMENTATION__FEATURE:
			return FEATURE_EDEFAULT == null ? feature != null : !FEATURE_EDEFAULT.equals(feature);
		case CorePackage.AUGMENTATION__SELECT:
			return SELECT_EDEFAULT == null ? select != null : !SELECT_EDEFAULT.equals(select);
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
		result.append(" (additions: "); //$NON-NLS-1$
		result.append(additions);
		result.append(", feature: "); //$NON-NLS-1$
		result.append(feature);
		result.append(", select: "); //$NON-NLS-1$
		result.append(select);
		result.append(')');
		return result.toString();
	}

	public DeployModelObject getReferencedObject() {
		if (eContainer() instanceof Instantiation) {
			return ((Instantiation) eContainer()).getReferencedObject();
		}
		return null;

	}

} //AugmentationImpl
