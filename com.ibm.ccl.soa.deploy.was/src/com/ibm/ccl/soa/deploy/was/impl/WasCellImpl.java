/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.impl;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Cell</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasCellImpl#getCellName <em>Cell Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasCellImpl#isIsDistributed <em>Is Distributed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasCellImpl#getWasVersion <em>Was Version</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasCellImpl extends CapabilityImpl implements WasCell {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getCellName() <em>Cell Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCellName()
	 * @generated
	 * @ordered
	 */
	protected static final String CELL_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCellName() <em>Cell Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCellName()
	 * @generated
	 * @ordered
	 */
	protected String cellName = CELL_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsDistributed() <em>Is Distributed</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isIsDistributed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_DISTRIBUTED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsDistributed() <em>Is Distributed</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isIsDistributed()
	 * @generated
	 * @ordered
	 */
	protected boolean isDistributed = IS_DISTRIBUTED_EDEFAULT;

	/**
	 * This is true if the Is Distributed attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean isDistributedESet;

	/**
	 * The default value of the '{@link #getWasVersion() <em>Was Version</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getWasVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String WAS_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWasVersion() <em>Was Version</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getWasVersion()
	 * @generated
	 * @ordered
	 */
	protected String wasVersion = WAS_VERSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasCellImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_CELL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getCellName() {
		return cellName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCellName(String newCellName) {
		String oldCellName = cellName;
		cellName = newCellName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_CELL__CELL_NAME, oldCellName, cellName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsDistributed() {
		return isDistributed;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsDistributed(boolean newIsDistributed) {
		boolean oldIsDistributed = isDistributed;
		isDistributed = newIsDistributed;
		boolean oldIsDistributedESet = isDistributedESet;
		isDistributedESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_CELL__IS_DISTRIBUTED, oldIsDistributed, isDistributed, !oldIsDistributedESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsDistributed() {
		boolean oldIsDistributed = isDistributed;
		boolean oldIsDistributedESet = isDistributedESet;
		isDistributed = IS_DISTRIBUTED_EDEFAULT;
		isDistributedESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_CELL__IS_DISTRIBUTED, oldIsDistributed, IS_DISTRIBUTED_EDEFAULT, oldIsDistributedESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsDistributed() {
		return isDistributedESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getWasVersion() {
		return wasVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setWasVersion(String newWasVersion) {
		String oldWasVersion = wasVersion;
		wasVersion = newWasVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_CELL__WAS_VERSION, oldWasVersion, wasVersion));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.WAS_CELL__CELL_NAME:
				return getCellName();
			case WasPackage.WAS_CELL__IS_DISTRIBUTED:
				return isIsDistributed() ? Boolean.TRUE : Boolean.FALSE;
			case WasPackage.WAS_CELL__WAS_VERSION:
				return getWasVersion();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.WAS_CELL__CELL_NAME:
				setCellName((String)newValue);
				return;
			case WasPackage.WAS_CELL__IS_DISTRIBUTED:
				setIsDistributed(((Boolean)newValue).booleanValue());
				return;
			case WasPackage.WAS_CELL__WAS_VERSION:
				setWasVersion((String)newValue);
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
			case WasPackage.WAS_CELL__CELL_NAME:
				setCellName(CELL_NAME_EDEFAULT);
				return;
			case WasPackage.WAS_CELL__IS_DISTRIBUTED:
				unsetIsDistributed();
				return;
			case WasPackage.WAS_CELL__WAS_VERSION:
				setWasVersion(WAS_VERSION_EDEFAULT);
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
			case WasPackage.WAS_CELL__CELL_NAME:
				return CELL_NAME_EDEFAULT == null ? cellName != null : !CELL_NAME_EDEFAULT.equals(cellName);
			case WasPackage.WAS_CELL__IS_DISTRIBUTED:
				return isSetIsDistributed();
			case WasPackage.WAS_CELL__WAS_VERSION:
				return WAS_VERSION_EDEFAULT == null ? wasVersion != null : !WAS_VERSION_EDEFAULT.equals(wasVersion);
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
		result.append(" (cellName: "); //$NON-NLS-1$
		result.append(cellName);
		result.append(", isDistributed: "); //$NON-NLS-1$
		if (isDistributedESet) result.append(isDistributed); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", wasVersion: "); //$NON-NLS-1$
		result.append(wasVersion);
		result.append(')');
		return result.toString();
	}

	/**
	 * Immutable list of capability key attributes returned by {@link #titleKeys()}.
	 */
	private final static List _titleKeys = Collections.singletonList(WasPackage.eINSTANCE
			.getWasCell_CellName());

	/*
	 * @see com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl#titleKeys()
	 */
	public List titleKeys() {
		return _titleKeys;
	}
} //WasCellImpl
