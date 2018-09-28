/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Exported;
import com.ibm.ccl.soa.deploy.core.ExportedUnit;
import com.ibm.ccl.soa.deploy.core.Property;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Exported Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.ExportedUnitImpl#getExportedCapabilities <em>Exported Capabilities</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.ExportedUnitImpl#getExportedRequirements <em>Exported Requirements</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.ExportedUnitImpl#getExportedProperties <em>Exported Properties</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.ExportedUnitImpl#getConstraintGroup <em>Constraint Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.ExportedUnitImpl#getAugmentedConstraints <em>Augmented Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExportedUnitImpl extends ExportedImpl implements ExportedUnit {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getExportedCapabilities() <em>Exported Capabilities</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getExportedCapabilities()
	 * @generated
	 * @ordered
	 */
	protected EList exportedCapabilities;

	/**
	 * The cached value of the '{@link #getExportedRequirements() <em>Exported Requirements</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getExportedRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList exportedRequirements;

	/**
	 * The cached value of the '{@link #getExportedProperties() <em>Exported Properties</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getExportedProperties()
	 * @generated
	 * @ordered
	 */
	protected EList exportedProperties;

	/**
	 * The cached value of the '{@link #getConstraintGroup() <em>Constraint Group</em>}' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getConstraintGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap constraintGroup;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ExportedUnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.EXPORTED_UNIT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public List getExportedCapabilities() {
		if (exportedCapabilities == null) {
			exportedCapabilities = new EObjectContainmentEList(Exported.class, this, CorePackage.EXPORTED_UNIT__EXPORTED_CAPABILITIES);
		}
		return exportedCapabilities;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public List getExportedRequirements() {
		if (exportedRequirements == null) {
			exportedRequirements = new EObjectContainmentEList(Exported.class, this, CorePackage.EXPORTED_UNIT__EXPORTED_REQUIREMENTS);
		}
		return exportedRequirements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public List getExportedProperties() {
		if (exportedProperties == null) {
			exportedProperties = new EObjectContainmentEList(Property.class, this, CorePackage.EXPORTED_UNIT__EXPORTED_PROPERTIES);
		}
		return exportedProperties;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getConstraintGroup() {
		if (constraintGroup == null) {
			constraintGroup = new BasicFeatureMap(this, CorePackage.EXPORTED_UNIT__CONSTRAINT_GROUP);
		}
		return constraintGroup;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public List getAugmentedConstraints() {
		return getConstraintGroup().list(CorePackage.Literals.EXPORTED_UNIT__AUGMENTED_CONSTRAINTS);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.EXPORTED_UNIT__EXPORTED_CAPABILITIES:
				return ((InternalEList)getExportedCapabilities()).basicRemove(otherEnd, msgs);
			case CorePackage.EXPORTED_UNIT__EXPORTED_REQUIREMENTS:
				return ((InternalEList)getExportedRequirements()).basicRemove(otherEnd, msgs);
			case CorePackage.EXPORTED_UNIT__EXPORTED_PROPERTIES:
				return ((InternalEList)getExportedProperties()).basicRemove(otherEnd, msgs);
			case CorePackage.EXPORTED_UNIT__CONSTRAINT_GROUP:
				return ((InternalEList)getConstraintGroup()).basicRemove(otherEnd, msgs);
			case CorePackage.EXPORTED_UNIT__AUGMENTED_CONSTRAINTS:
				return ((InternalEList)getAugmentedConstraints()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.EXPORTED_UNIT__EXPORTED_CAPABILITIES:
				return getExportedCapabilities();
			case CorePackage.EXPORTED_UNIT__EXPORTED_REQUIREMENTS:
				return getExportedRequirements();
			case CorePackage.EXPORTED_UNIT__EXPORTED_PROPERTIES:
				return getExportedProperties();
			case CorePackage.EXPORTED_UNIT__CONSTRAINT_GROUP:
				if (coreType) return getConstraintGroup();
				return ((FeatureMap.Internal)getConstraintGroup()).getWrapper();
			case CorePackage.EXPORTED_UNIT__AUGMENTED_CONSTRAINTS:
				return getAugmentedConstraints();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CorePackage.EXPORTED_UNIT__EXPORTED_CAPABILITIES:
				getExportedCapabilities().clear();
				getExportedCapabilities().addAll((Collection)newValue);
				return;
			case CorePackage.EXPORTED_UNIT__EXPORTED_REQUIREMENTS:
				getExportedRequirements().clear();
				getExportedRequirements().addAll((Collection)newValue);
				return;
			case CorePackage.EXPORTED_UNIT__EXPORTED_PROPERTIES:
				getExportedProperties().clear();
				getExportedProperties().addAll((Collection)newValue);
				return;
			case CorePackage.EXPORTED_UNIT__CONSTRAINT_GROUP:
				((FeatureMap.Internal)getConstraintGroup()).set(newValue);
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
			case CorePackage.EXPORTED_UNIT__EXPORTED_CAPABILITIES:
				getExportedCapabilities().clear();
				return;
			case CorePackage.EXPORTED_UNIT__EXPORTED_REQUIREMENTS:
				getExportedRequirements().clear();
				return;
			case CorePackage.EXPORTED_UNIT__EXPORTED_PROPERTIES:
				getExportedProperties().clear();
				return;
			case CorePackage.EXPORTED_UNIT__CONSTRAINT_GROUP:
				getConstraintGroup().clear();
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
			case CorePackage.EXPORTED_UNIT__EXPORTED_CAPABILITIES:
				return exportedCapabilities != null && !exportedCapabilities.isEmpty();
			case CorePackage.EXPORTED_UNIT__EXPORTED_REQUIREMENTS:
				return exportedRequirements != null && !exportedRequirements.isEmpty();
			case CorePackage.EXPORTED_UNIT__EXPORTED_PROPERTIES:
				return exportedProperties != null && !exportedProperties.isEmpty();
			case CorePackage.EXPORTED_UNIT__CONSTRAINT_GROUP:
				return constraintGroup != null && !constraintGroup.isEmpty();
			case CorePackage.EXPORTED_UNIT__AUGMENTED_CONSTRAINTS:
				return !getAugmentedConstraints().isEmpty();
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
		result.append(" (constraintGroup: "); //$NON-NLS-1$
		result.append(constraintGroup);
		result.append(')');
		return result.toString();
	}

} //ExportedUnitImpl
