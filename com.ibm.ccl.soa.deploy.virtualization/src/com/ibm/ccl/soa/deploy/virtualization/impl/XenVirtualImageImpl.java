/**
 * <copyright>
 * </copyright>
 *
 * $Id: XenVirtualImageImpl.java,v 1.3 2008/04/04 22:33:54 avk Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization.impl;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage;
import com.ibm.ccl.soa.deploy.virtualization.XenVirtualImage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Xen Virtual Image</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.XenVirtualImageImpl#getDomainConfigFile <em>Domain Config File</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.XenVirtualImageImpl#getDomainName <em>Domain Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XenVirtualImageImpl extends VirtualImageImpl implements XenVirtualImage {
	/**
	 * The default value of the '{@link #getDomainConfigFile() <em>Domain Config File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainConfigFile()
	 * @generated
	 * @ordered
	 */
	protected static final String DOMAIN_CONFIG_FILE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getDomainConfigFile() <em>Domain Config File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainConfigFile()
	 * @generated
	 * @ordered
	 */
	protected String domainConfigFile = DOMAIN_CONFIG_FILE_EDEFAULT;
	/**
	 * The default value of the '{@link #getDomainName() <em>Domain Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainName()
	 * @generated
	 * @ordered
	 */
	protected static final String DOMAIN_NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getDomainName() <em>Domain Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainName()
	 * @generated
	 * @ordered
	 */
	protected String domainName = DOMAIN_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XenVirtualImageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return VirtualizationPackage.Literals.XEN_VIRTUAL_IMAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDomainConfigFile() {
		return domainConfigFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomainConfigFile(String newDomainConfigFile) {
		String oldDomainConfigFile = domainConfigFile;
		domainConfigFile = newDomainConfigFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.XEN_VIRTUAL_IMAGE__DOMAIN_CONFIG_FILE, oldDomainConfigFile, domainConfigFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDomainName() {
		return domainName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomainName(String newDomainName) {
		String oldDomainName = domainName;
		domainName = newDomainName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.XEN_VIRTUAL_IMAGE__DOMAIN_NAME, oldDomainName, domainName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VirtualizationPackage.XEN_VIRTUAL_IMAGE__DOMAIN_CONFIG_FILE:
				return getDomainConfigFile();
			case VirtualizationPackage.XEN_VIRTUAL_IMAGE__DOMAIN_NAME:
				return getDomainName();
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
			case VirtualizationPackage.XEN_VIRTUAL_IMAGE__DOMAIN_CONFIG_FILE:
				setDomainConfigFile((String)newValue);
				return;
			case VirtualizationPackage.XEN_VIRTUAL_IMAGE__DOMAIN_NAME:
				setDomainName((String)newValue);
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
			case VirtualizationPackage.XEN_VIRTUAL_IMAGE__DOMAIN_CONFIG_FILE:
				setDomainConfigFile(DOMAIN_CONFIG_FILE_EDEFAULT);
				return;
			case VirtualizationPackage.XEN_VIRTUAL_IMAGE__DOMAIN_NAME:
				setDomainName(DOMAIN_NAME_EDEFAULT);
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
			case VirtualizationPackage.XEN_VIRTUAL_IMAGE__DOMAIN_CONFIG_FILE:
				return DOMAIN_CONFIG_FILE_EDEFAULT == null ? domainConfigFile != null : !DOMAIN_CONFIG_FILE_EDEFAULT.equals(domainConfigFile);
			case VirtualizationPackage.XEN_VIRTUAL_IMAGE__DOMAIN_NAME:
				return DOMAIN_NAME_EDEFAULT == null ? domainName != null : !DOMAIN_NAME_EDEFAULT.equals(domainName);
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
		result.append(" (domainConfigFile: "); //$NON-NLS-1$
		result.append(domainConfigFile);
		result.append(", domainName: "); //$NON-NLS-1$
		result.append(domainName);
		result.append(')');
		return result.toString();
	}

	private final static List<EAttribute> keys = Collections.singletonList(VirtualizationPackage.eINSTANCE
			.getXenVirtualImage_DomainName());

	/* @generated NOT */
	public List titleKeys() {
		return keys;
	}

} //XenVirtualImageImpl
