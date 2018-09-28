/**
 * <copyright>
 * </copyright>
 *
 * $Id: VMwareHypervisorImpl.java,v 1.3 2008/04/17 15:47:25 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.virtualization.VMwareHypervisor;
import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>VMware Hypervisor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareHypervisorImpl#getVmwareProduct <em>Vmware Product</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareHypervisorImpl#getVmwareVersion <em>Vmware Version</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VMwareHypervisorImpl extends HypervisorImpl implements VMwareHypervisor {
	/**
	 * The default value of the '{@link #getVmwareProduct() <em>Vmware Product</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVmwareProduct()
	 * @generated
	 * @ordered
	 */
	protected static final String VMWARE_PRODUCT_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getVmwareProduct() <em>Vmware Product</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVmwareProduct()
	 * @generated
	 * @ordered
	 */
	protected String vmwareProduct = VMWARE_PRODUCT_EDEFAULT;
	/**
	 * The default value of the '{@link #getVmwareVersion() <em>Vmware Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVmwareVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VMWARE_VERSION_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getVmwareVersion() <em>Vmware Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVmwareVersion()
	 * @generated
	 * @ordered
	 */
	protected String vmwareVersion = VMWARE_VERSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VMwareHypervisorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return VirtualizationPackage.Literals.VMWARE_HYPERVISOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVmwareProduct() {
		return vmwareProduct;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVmwareProduct(String newVmwareProduct) {
		String oldVmwareProduct = vmwareProduct;
		vmwareProduct = newVmwareProduct;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VMWARE_HYPERVISOR__VMWARE_PRODUCT, oldVmwareProduct, vmwareProduct));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVmwareVersion() {
		return vmwareVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVmwareVersion(String newVmwareVersion) {
		String oldVmwareVersion = vmwareVersion;
		vmwareVersion = newVmwareVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VMWARE_HYPERVISOR__VMWARE_VERSION, oldVmwareVersion, vmwareVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VirtualizationPackage.VMWARE_HYPERVISOR__VMWARE_PRODUCT:
				return getVmwareProduct();
			case VirtualizationPackage.VMWARE_HYPERVISOR__VMWARE_VERSION:
				return getVmwareVersion();
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
			case VirtualizationPackage.VMWARE_HYPERVISOR__VMWARE_PRODUCT:
				setVmwareProduct((String)newValue);
				return;
			case VirtualizationPackage.VMWARE_HYPERVISOR__VMWARE_VERSION:
				setVmwareVersion((String)newValue);
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
			case VirtualizationPackage.VMWARE_HYPERVISOR__VMWARE_PRODUCT:
				setVmwareProduct(VMWARE_PRODUCT_EDEFAULT);
				return;
			case VirtualizationPackage.VMWARE_HYPERVISOR__VMWARE_VERSION:
				setVmwareVersion(VMWARE_VERSION_EDEFAULT);
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
			case VirtualizationPackage.VMWARE_HYPERVISOR__VMWARE_PRODUCT:
				return VMWARE_PRODUCT_EDEFAULT == null ? vmwareProduct != null : !VMWARE_PRODUCT_EDEFAULT.equals(vmwareProduct);
			case VirtualizationPackage.VMWARE_HYPERVISOR__VMWARE_VERSION:
				return VMWARE_VERSION_EDEFAULT == null ? vmwareVersion != null : !VMWARE_VERSION_EDEFAULT.equals(vmwareVersion);
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
		result.append(" (vmwareProduct: "); //$NON-NLS-1$
		result.append(vmwareProduct);
		result.append(", vmwareVersion: "); //$NON-NLS-1$
		result.append(vmwareVersion);
		result.append(')');
		return result.toString();
	}

} //VMwareHypervisorImpl
