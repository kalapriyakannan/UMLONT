/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.db2high.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.db2high.DB2BufferPool;
import com.ibm.ccl.soa.deploy.db2high.Db2highPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DB2 Buffer Pool</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2BufferPoolImpl#getImmediateOrDeferred <em>Immediate Or Deferred</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2BufferPoolImpl#getName1 <em>Name1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2BufferPoolImpl#getPageSize <em>Page Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2BufferPoolImpl#getSize <em>Size</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DB2BufferPoolImpl extends CapabilityImpl implements DB2BufferPool {
	/**
	 * The default value of the '{@link #getImmediateOrDeferred() <em>Immediate Or Deferred</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImmediateOrDeferred()
	 * @generated
	 * @ordered
	 */
	protected static final String IMMEDIATE_OR_DEFERRED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImmediateOrDeferred() <em>Immediate Or Deferred</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImmediateOrDeferred()
	 * @generated
	 * @ordered
	 */
	protected String immediateOrDeferred = IMMEDIATE_OR_DEFERRED_EDEFAULT;

	/**
	 * The default value of the '{@link #getName1() <em>Name1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName1()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName1() <em>Name1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName1()
	 * @generated
	 * @ordered
	 */
	protected String name1 = NAME1_EDEFAULT;

	/**
	 * The default value of the '{@link #getPageSize() <em>Page Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageSize()
	 * @generated
	 * @ordered
	 */
	protected static final String PAGE_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPageSize() <em>Page Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageSize()
	 * @generated
	 * @ordered
	 */
	protected String pageSize = PAGE_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final String SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected String size = SIZE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DB2BufferPoolImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Db2highPackage.Literals.DB2_BUFFER_POOL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getImmediateOrDeferred() {
		return immediateOrDeferred;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImmediateOrDeferred(String newImmediateOrDeferred) {
		String oldImmediateOrDeferred = immediateOrDeferred;
		immediateOrDeferred = newImmediateOrDeferred;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_BUFFER_POOL__IMMEDIATE_OR_DEFERRED, oldImmediateOrDeferred, immediateOrDeferred));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName1() {
		return name1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName1(String newName1) {
		String oldName1 = name1;
		name1 = newName1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_BUFFER_POOL__NAME1, oldName1, name1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPageSize() {
		return pageSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPageSize(String newPageSize) {
		String oldPageSize = pageSize;
		pageSize = newPageSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_BUFFER_POOL__PAGE_SIZE, oldPageSize, pageSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSize() {
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSize(String newSize) {
		String oldSize = size;
		size = newSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_BUFFER_POOL__SIZE, oldSize, size));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Db2highPackage.DB2_BUFFER_POOL__IMMEDIATE_OR_DEFERRED:
				return getImmediateOrDeferred();
			case Db2highPackage.DB2_BUFFER_POOL__NAME1:
				return getName1();
			case Db2highPackage.DB2_BUFFER_POOL__PAGE_SIZE:
				return getPageSize();
			case Db2highPackage.DB2_BUFFER_POOL__SIZE:
				return getSize();
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
			case Db2highPackage.DB2_BUFFER_POOL__IMMEDIATE_OR_DEFERRED:
				setImmediateOrDeferred((String)newValue);
				return;
			case Db2highPackage.DB2_BUFFER_POOL__NAME1:
				setName1((String)newValue);
				return;
			case Db2highPackage.DB2_BUFFER_POOL__PAGE_SIZE:
				setPageSize((String)newValue);
				return;
			case Db2highPackage.DB2_BUFFER_POOL__SIZE:
				setSize((String)newValue);
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
			case Db2highPackage.DB2_BUFFER_POOL__IMMEDIATE_OR_DEFERRED:
				setImmediateOrDeferred(IMMEDIATE_OR_DEFERRED_EDEFAULT);
				return;
			case Db2highPackage.DB2_BUFFER_POOL__NAME1:
				setName1(NAME1_EDEFAULT);
				return;
			case Db2highPackage.DB2_BUFFER_POOL__PAGE_SIZE:
				setPageSize(PAGE_SIZE_EDEFAULT);
				return;
			case Db2highPackage.DB2_BUFFER_POOL__SIZE:
				setSize(SIZE_EDEFAULT);
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
			case Db2highPackage.DB2_BUFFER_POOL__IMMEDIATE_OR_DEFERRED:
				return IMMEDIATE_OR_DEFERRED_EDEFAULT == null ? immediateOrDeferred != null : !IMMEDIATE_OR_DEFERRED_EDEFAULT.equals(immediateOrDeferred);
			case Db2highPackage.DB2_BUFFER_POOL__NAME1:
				return NAME1_EDEFAULT == null ? name1 != null : !NAME1_EDEFAULT.equals(name1);
			case Db2highPackage.DB2_BUFFER_POOL__PAGE_SIZE:
				return PAGE_SIZE_EDEFAULT == null ? pageSize != null : !PAGE_SIZE_EDEFAULT.equals(pageSize);
			case Db2highPackage.DB2_BUFFER_POOL__SIZE:
				return SIZE_EDEFAULT == null ? size != null : !SIZE_EDEFAULT.equals(size);
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
		result.append(" (immediateOrDeferred: "); //$NON-NLS-1$
		result.append(immediateOrDeferred);
		result.append(", name1: "); //$NON-NLS-1$
		result.append(name1);
		result.append(", pageSize: "); //$NON-NLS-1$
		result.append(pageSize);
		result.append(", size: "); //$NON-NLS-1$
		result.append(size);
		result.append(')');
		return result.toString();
	}

} //DB2BufferPoolImpl
