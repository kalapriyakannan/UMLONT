/**
 * <copyright>
 * </copyright>
 *
 * $Id: VMwareVirtualImageImpl.java,v 1.3 2008/04/17 15:47:25 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImage;
import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>VMware Virtual Image</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualImageImpl#getConfigVersion <em>Config Version</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualImageImpl#getVmxFile <em>Vmx File</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VMwareVirtualImageImpl extends VirtualImageImpl implements VMwareVirtualImage {
	/**
	 * The default value of the '{@link #getConfigVersion() <em>Config Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String CONFIG_VERSION_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getConfigVersion() <em>Config Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigVersion()
	 * @generated
	 * @ordered
	 */
	protected String configVersion = CONFIG_VERSION_EDEFAULT;
	/**
	 * The default value of the '{@link #getVmxFile() <em>Vmx File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVmxFile()
	 * @generated
	 * @ordered
	 */
	protected static final String VMX_FILE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getVmxFile() <em>Vmx File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVmxFile()
	 * @generated
	 * @ordered
	 */
	protected String vmxFile = VMX_FILE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VMwareVirtualImageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return VirtualizationPackage.Literals.VMWARE_VIRTUAL_IMAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConfigVersion() {
		return configVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfigVersion(String newConfigVersion) {
		String oldConfigVersion = configVersion;
		configVersion = newConfigVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VMWARE_VIRTUAL_IMAGE__CONFIG_VERSION, oldConfigVersion, configVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVmxFile() {
		return vmxFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVmxFile(String newVmxFile) {
		String oldVmxFile = vmxFile;
		vmxFile = newVmxFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VMWARE_VIRTUAL_IMAGE__VMX_FILE, oldVmxFile, vmxFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VirtualizationPackage.VMWARE_VIRTUAL_IMAGE__CONFIG_VERSION:
				return getConfigVersion();
			case VirtualizationPackage.VMWARE_VIRTUAL_IMAGE__VMX_FILE:
				return getVmxFile();
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
			case VirtualizationPackage.VMWARE_VIRTUAL_IMAGE__CONFIG_VERSION:
				setConfigVersion((String)newValue);
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_IMAGE__VMX_FILE:
				setVmxFile((String)newValue);
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
			case VirtualizationPackage.VMWARE_VIRTUAL_IMAGE__CONFIG_VERSION:
				setConfigVersion(CONFIG_VERSION_EDEFAULT);
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_IMAGE__VMX_FILE:
				setVmxFile(VMX_FILE_EDEFAULT);
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
			case VirtualizationPackage.VMWARE_VIRTUAL_IMAGE__CONFIG_VERSION:
				return CONFIG_VERSION_EDEFAULT == null ? configVersion != null : !CONFIG_VERSION_EDEFAULT.equals(configVersion);
			case VirtualizationPackage.VMWARE_VIRTUAL_IMAGE__VMX_FILE:
				return VMX_FILE_EDEFAULT == null ? vmxFile != null : !VMX_FILE_EDEFAULT.equals(vmxFile);
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
		result.append(" (configVersion: "); //$NON-NLS-1$
		result.append(configVersion);
		result.append(", vmxFile: "); //$NON-NLS-1$
		result.append(vmxFile);
		result.append(')');
		return result.toString();
	}

} //VMwareVirtualImageImpl
