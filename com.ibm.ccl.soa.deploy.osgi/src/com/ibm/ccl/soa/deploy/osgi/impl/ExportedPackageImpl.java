/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.osgi.impl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;

import com.ibm.ccl.soa.deploy.osgi.ExportedPackage;
import com.ibm.ccl.soa.deploy.osgi.OsgiPackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Exported Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.osgi.impl.ExportedPackageImpl#getFriend <em>Friend</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.osgi.impl.ExportedPackageImpl#isInternal <em>Internal</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExportedPackageImpl extends CapabilityImpl implements ExportedPackage {
	/**
	 * The cached value of the '{@link #getFriend() <em>Friend</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFriend()
	 * @generated
	 * @ordered
	 */
	protected EList friend;

	/**
	 * The default value of the '{@link #isInternal() <em>Internal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInternal()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INTERNAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInternal() <em>Internal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInternal()
	 * @generated
	 * @ordered
	 */
	protected boolean internal = INTERNAL_EDEFAULT;

	/**
	 * This is true if the Internal attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean internalESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExportedPackageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return OsgiPackage.Literals.EXPORTED_PACKAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getFriend() {
		if (friend == null) {
			friend = new EDataTypeEList(String.class, this, OsgiPackage.EXPORTED_PACKAGE__FRIEND);
		}
		return friend;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInternal() {
		return internal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInternal(boolean newInternal) {
		boolean oldInternal = internal;
		internal = newInternal;
		boolean oldInternalESet = internalESet;
		internalESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OsgiPackage.EXPORTED_PACKAGE__INTERNAL, oldInternal, internal, !oldInternalESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetInternal() {
		boolean oldInternal = internal;
		boolean oldInternalESet = internalESet;
		internal = INTERNAL_EDEFAULT;
		internalESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, OsgiPackage.EXPORTED_PACKAGE__INTERNAL, oldInternal, INTERNAL_EDEFAULT, oldInternalESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInternal() {
		return internalESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OsgiPackage.EXPORTED_PACKAGE__FRIEND:
				return getFriend();
			case OsgiPackage.EXPORTED_PACKAGE__INTERNAL:
				return isInternal() ? Boolean.TRUE : Boolean.FALSE;
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
			case OsgiPackage.EXPORTED_PACKAGE__FRIEND:
				getFriend().clear();
				getFriend().addAll((Collection)newValue);
				return;
			case OsgiPackage.EXPORTED_PACKAGE__INTERNAL:
				setInternal(((Boolean)newValue).booleanValue());
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
			case OsgiPackage.EXPORTED_PACKAGE__FRIEND:
				getFriend().clear();
				return;
			case OsgiPackage.EXPORTED_PACKAGE__INTERNAL:
				unsetInternal();
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
			case OsgiPackage.EXPORTED_PACKAGE__FRIEND:
				return friend != null && !friend.isEmpty();
			case OsgiPackage.EXPORTED_PACKAGE__INTERNAL:
				return isSetInternal();
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
		result.append(" (friend: "); //$NON-NLS-1$
		result.append(friend);
		result.append(", internal: "); //$NON-NLS-1$
		if (internalESet) result.append(internal); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //ExportedPackageImpl
