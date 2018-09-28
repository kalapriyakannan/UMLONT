/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.was.SharedLibraryEntry;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Shared Library Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.SharedLibraryEntryImpl#getClassPath <em>Class Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.SharedLibraryEntryImpl#getNativePath <em>Native Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.SharedLibraryEntryImpl#getSharedLibraryEntryName <em>Shared Library Entry Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SharedLibraryEntryImpl extends CapabilityImpl implements SharedLibraryEntry {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getClassPath() <em>Class Path</em>}' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getClassPath()
	 * @generated
	 * @ordered
	 */
	protected EList classPath;

	/**
	 * The cached value of the '{@link #getNativePath() <em>Native Path</em>}' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNativePath()
	 * @generated
	 * @ordered
	 */
	protected EList nativePath;

	/**
	 * The default value of the '{@link #getSharedLibraryEntryName() <em>Shared Library Entry Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSharedLibraryEntryName()
	 * @generated
	 * @ordered
	 */
	protected static final String SHARED_LIBRARY_ENTRY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSharedLibraryEntryName() <em>Shared Library Entry Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSharedLibraryEntryName()
	 * @generated
	 * @ordered
	 */
	protected String sharedLibraryEntryName = SHARED_LIBRARY_ENTRY_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected SharedLibraryEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.SHARED_LIBRARY_ENTRY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public List getClassPath() {
		if (classPath == null) {
			classPath = new EDataTypeEList(String.class, this, WasPackage.SHARED_LIBRARY_ENTRY__CLASS_PATH);
		}
		return classPath;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public List getNativePath() {
		if (nativePath == null) {
			nativePath = new EDataTypeEList(String.class, this, WasPackage.SHARED_LIBRARY_ENTRY__NATIVE_PATH);
		}
		return nativePath;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getSharedLibraryEntryName() {
		return sharedLibraryEntryName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSharedLibraryEntryName(String newSharedLibraryEntryName) {
		String oldSharedLibraryEntryName = sharedLibraryEntryName;
		sharedLibraryEntryName = newSharedLibraryEntryName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.SHARED_LIBRARY_ENTRY__SHARED_LIBRARY_ENTRY_NAME, oldSharedLibraryEntryName, sharedLibraryEntryName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.SHARED_LIBRARY_ENTRY__CLASS_PATH:
				return getClassPath();
			case WasPackage.SHARED_LIBRARY_ENTRY__NATIVE_PATH:
				return getNativePath();
			case WasPackage.SHARED_LIBRARY_ENTRY__SHARED_LIBRARY_ENTRY_NAME:
				return getSharedLibraryEntryName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.SHARED_LIBRARY_ENTRY__CLASS_PATH:
				getClassPath().clear();
				getClassPath().addAll((Collection)newValue);
				return;
			case WasPackage.SHARED_LIBRARY_ENTRY__NATIVE_PATH:
				getNativePath().clear();
				getNativePath().addAll((Collection)newValue);
				return;
			case WasPackage.SHARED_LIBRARY_ENTRY__SHARED_LIBRARY_ENTRY_NAME:
				setSharedLibraryEntryName((String)newValue);
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
			case WasPackage.SHARED_LIBRARY_ENTRY__CLASS_PATH:
				getClassPath().clear();
				return;
			case WasPackage.SHARED_LIBRARY_ENTRY__NATIVE_PATH:
				getNativePath().clear();
				return;
			case WasPackage.SHARED_LIBRARY_ENTRY__SHARED_LIBRARY_ENTRY_NAME:
				setSharedLibraryEntryName(SHARED_LIBRARY_ENTRY_NAME_EDEFAULT);
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
			case WasPackage.SHARED_LIBRARY_ENTRY__CLASS_PATH:
				return classPath != null && !classPath.isEmpty();
			case WasPackage.SHARED_LIBRARY_ENTRY__NATIVE_PATH:
				return nativePath != null && !nativePath.isEmpty();
			case WasPackage.SHARED_LIBRARY_ENTRY__SHARED_LIBRARY_ENTRY_NAME:
				return SHARED_LIBRARY_ENTRY_NAME_EDEFAULT == null ? sharedLibraryEntryName != null : !SHARED_LIBRARY_ENTRY_NAME_EDEFAULT.equals(sharedLibraryEntryName);
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
		result.append(" (classPath: "); //$NON-NLS-1$
		result.append(classPath);
		result.append(", nativePath: "); //$NON-NLS-1$
		result.append(nativePath);
		result.append(", sharedLibraryEntryName: "); //$NON-NLS-1$
		result.append(sharedLibraryEntryName);
		result.append(')');
		return result.toString();
	}

} //SharedLibraryEntryImpl
