/**
 * <copyright>
 * </copyright>
 *
 * $Id: VirtualServerDefImpl.java,v 1.3 2008/04/17 15:47:25 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization.impl;

import java.math.BigInteger;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.virtualization.VirtualServerDef;
import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Virtual Server Def</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualServerDefImpl#getMemorySize <em>Memory Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualServerDefImpl#getVcpus <em>Vcpus</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualServerDefImpl#getVirtualHWFamily <em>Virtual HW Family</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VirtualServerDefImpl extends CapabilityImpl implements VirtualServerDef {
	/**
	 * The default value of the '{@link #getMemorySize() <em>Memory Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemorySize()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger MEMORY_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMemorySize() <em>Memory Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemorySize()
	 * @generated
	 * @ordered
	 */
	protected BigInteger memorySize = MEMORY_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getVcpus() <em>Vcpus</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVcpus()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger VCPUS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVcpus() <em>Vcpus</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVcpus()
	 * @generated
	 * @ordered
	 */
	protected BigInteger vcpus = VCPUS_EDEFAULT;

	/**
	 * The default value of the '{@link #getVirtualHWFamily() <em>Virtual HW Family</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVirtualHWFamily()
	 * @generated
	 * @ordered
	 */
	protected static final String VIRTUAL_HW_FAMILY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVirtualHWFamily() <em>Virtual HW Family</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVirtualHWFamily()
	 * @generated
	 * @ordered
	 */
	protected String virtualHWFamily = VIRTUAL_HW_FAMILY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VirtualServerDefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return VirtualizationPackage.Literals.VIRTUAL_SERVER_DEF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getMemorySize() {
		return memorySize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMemorySize(BigInteger newMemorySize) {
		BigInteger oldMemorySize = memorySize;
		memorySize = newMemorySize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VIRTUAL_SERVER_DEF__MEMORY_SIZE, oldMemorySize, memorySize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getVcpus() {
		return vcpus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVcpus(BigInteger newVcpus) {
		BigInteger oldVcpus = vcpus;
		vcpus = newVcpus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VIRTUAL_SERVER_DEF__VCPUS, oldVcpus, vcpus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVirtualHWFamily() {
		return virtualHWFamily;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVirtualHWFamily(String newVirtualHWFamily) {
		String oldVirtualHWFamily = virtualHWFamily;
		virtualHWFamily = newVirtualHWFamily;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VIRTUAL_SERVER_DEF__VIRTUAL_HW_FAMILY, oldVirtualHWFamily, virtualHWFamily));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VirtualizationPackage.VIRTUAL_SERVER_DEF__MEMORY_SIZE:
				return getMemorySize();
			case VirtualizationPackage.VIRTUAL_SERVER_DEF__VCPUS:
				return getVcpus();
			case VirtualizationPackage.VIRTUAL_SERVER_DEF__VIRTUAL_HW_FAMILY:
				return getVirtualHWFamily();
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
			case VirtualizationPackage.VIRTUAL_SERVER_DEF__MEMORY_SIZE:
				setMemorySize((BigInteger)newValue);
				return;
			case VirtualizationPackage.VIRTUAL_SERVER_DEF__VCPUS:
				setVcpus((BigInteger)newValue);
				return;
			case VirtualizationPackage.VIRTUAL_SERVER_DEF__VIRTUAL_HW_FAMILY:
				setVirtualHWFamily((String)newValue);
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
			case VirtualizationPackage.VIRTUAL_SERVER_DEF__MEMORY_SIZE:
				setMemorySize(MEMORY_SIZE_EDEFAULT);
				return;
			case VirtualizationPackage.VIRTUAL_SERVER_DEF__VCPUS:
				setVcpus(VCPUS_EDEFAULT);
				return;
			case VirtualizationPackage.VIRTUAL_SERVER_DEF__VIRTUAL_HW_FAMILY:
				setVirtualHWFamily(VIRTUAL_HW_FAMILY_EDEFAULT);
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
			case VirtualizationPackage.VIRTUAL_SERVER_DEF__MEMORY_SIZE:
				return MEMORY_SIZE_EDEFAULT == null ? memorySize != null : !MEMORY_SIZE_EDEFAULT.equals(memorySize);
			case VirtualizationPackage.VIRTUAL_SERVER_DEF__VCPUS:
				return VCPUS_EDEFAULT == null ? vcpus != null : !VCPUS_EDEFAULT.equals(vcpus);
			case VirtualizationPackage.VIRTUAL_SERVER_DEF__VIRTUAL_HW_FAMILY:
				return VIRTUAL_HW_FAMILY_EDEFAULT == null ? virtualHWFamily != null : !VIRTUAL_HW_FAMILY_EDEFAULT.equals(virtualHWFamily);
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
		result.append(" (memorySize: "); //$NON-NLS-1$
		result.append(memorySize);
		result.append(", vcpus: "); //$NON-NLS-1$
		result.append(vcpus);
		result.append(", virtualHWFamily: "); //$NON-NLS-1$
		result.append(virtualHWFamily);
		result.append(')');
		return result.toString();
	}

} //VirtualServerDefImpl
