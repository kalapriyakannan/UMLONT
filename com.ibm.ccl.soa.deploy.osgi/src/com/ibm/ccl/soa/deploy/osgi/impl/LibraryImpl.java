/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.osgi.impl;

import com.ibm.ccl.soa.deploy.core.impl.UnitImpl;

import com.ibm.ccl.soa.deploy.osgi.Library;
import com.ibm.ccl.soa.deploy.osgi.OsgiPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.osgi.impl.LibraryImpl#getSource <em>Source</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.osgi.impl.LibraryImpl#getOutput <em>Output</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LibraryImpl extends UnitImpl implements Library {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected EList source;

	/**
	 * The cached value of the '{@link #getOutput() <em>Output</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutput()
	 * @generated
	 * @ordered
	 */
	protected EList output;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LibraryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return OsgiPackage.Literals.LIBRARY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getSource() {
		if (source == null) {
			source = new EDataTypeEList(String.class, this, OsgiPackage.LIBRARY__SOURCE);
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getOutput() {
		if (output == null) {
			output = new EDataTypeEList(String.class, this, OsgiPackage.LIBRARY__OUTPUT);
		}
		return output;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OsgiPackage.LIBRARY__SOURCE:
				return getSource();
			case OsgiPackage.LIBRARY__OUTPUT:
				return getOutput();
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
			case OsgiPackage.LIBRARY__SOURCE:
				getSource().clear();
				getSource().addAll((Collection)newValue);
				return;
			case OsgiPackage.LIBRARY__OUTPUT:
				getOutput().clear();
				getOutput().addAll((Collection)newValue);
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
			case OsgiPackage.LIBRARY__SOURCE:
				getSource().clear();
				return;
			case OsgiPackage.LIBRARY__OUTPUT:
				getOutput().clear();
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
			case OsgiPackage.LIBRARY__SOURCE:
				return source != null && !source.isEmpty();
			case OsgiPackage.LIBRARY__OUTPUT:
				return output != null && !output.isEmpty();
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
		result.append(" (source: "); //$NON-NLS-1$
		result.append(source);
		result.append(", output: "); //$NON-NLS-1$
		result.append(output);
		result.append(')');
		return result.toString();
	}

} //LibraryImpl
