/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSibServiceIntegrationBusLink;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Sib Service Integration Bus Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasSibServiceIntegrationBusLinkImpl#getBootTrapEndpoints <em>Boot Trap Endpoints</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasSibServiceIntegrationBusLinkImpl#getForeignBusName <em>Foreign Bus Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasSibServiceIntegrationBusLinkImpl#getLinkName <em>Link Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasSibServiceIntegrationBusLinkImpl#getRemoteMessagingEngineName <em>Remote Messaging Engine Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasSibServiceIntegrationBusLinkImpl extends CapabilityImpl implements
		WasSibServiceIntegrationBusLink {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getBootTrapEndpoints() <em>Boot Trap Endpoints</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getBootTrapEndpoints()
	 * @generated
	 * @ordered
	 */
	protected static final String BOOT_TRAP_ENDPOINTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBootTrapEndpoints() <em>Boot Trap Endpoints</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getBootTrapEndpoints()
	 * @generated
	 * @ordered
	 */
	protected String bootTrapEndpoints = BOOT_TRAP_ENDPOINTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getForeignBusName() <em>Foreign Bus Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getForeignBusName()
	 * @generated
	 * @ordered
	 */
	protected static final String FOREIGN_BUS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getForeignBusName() <em>Foreign Bus Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getForeignBusName()
	 * @generated
	 * @ordered
	 */
	protected String foreignBusName = FOREIGN_BUS_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getLinkName() <em>Link Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLinkName()
	 * @generated
	 * @ordered
	 */
	protected static final String LINK_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLinkName() <em>Link Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLinkName()
	 * @generated
	 * @ordered
	 */
	protected String linkName = LINK_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getRemoteMessagingEngineName() <em>Remote Messaging Engine Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRemoteMessagingEngineName()
	 * @generated
	 * @ordered
	 */
	protected static final String REMOTE_MESSAGING_ENGINE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRemoteMessagingEngineName() <em>Remote Messaging Engine Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRemoteMessagingEngineName()
	 * @generated
	 * @ordered
	 */
	protected String remoteMessagingEngineName = REMOTE_MESSAGING_ENGINE_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasSibServiceIntegrationBusLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_SIB_SERVICE_INTEGRATION_BUS_LINK;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getBootTrapEndpoints() {
		return bootTrapEndpoints;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBootTrapEndpoints(String newBootTrapEndpoints) {
		String oldBootTrapEndpoints = bootTrapEndpoints;
		bootTrapEndpoints = newBootTrapEndpoints;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SIB_SERVICE_INTEGRATION_BUS_LINK__BOOT_TRAP_ENDPOINTS, oldBootTrapEndpoints, bootTrapEndpoints));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getForeignBusName() {
		return foreignBusName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setForeignBusName(String newForeignBusName) {
		String oldForeignBusName = foreignBusName;
		foreignBusName = newForeignBusName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SIB_SERVICE_INTEGRATION_BUS_LINK__FOREIGN_BUS_NAME, oldForeignBusName, foreignBusName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getLinkName() {
		return linkName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkName(String newLinkName) {
		String oldLinkName = linkName;
		linkName = newLinkName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SIB_SERVICE_INTEGRATION_BUS_LINK__LINK_NAME, oldLinkName, linkName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getRemoteMessagingEngineName() {
		return remoteMessagingEngineName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemoteMessagingEngineName(String newRemoteMessagingEngineName) {
		String oldRemoteMessagingEngineName = remoteMessagingEngineName;
		remoteMessagingEngineName = newRemoteMessagingEngineName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SIB_SERVICE_INTEGRATION_BUS_LINK__REMOTE_MESSAGING_ENGINE_NAME, oldRemoteMessagingEngineName, remoteMessagingEngineName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.WAS_SIB_SERVICE_INTEGRATION_BUS_LINK__BOOT_TRAP_ENDPOINTS:
				return getBootTrapEndpoints();
			case WasPackage.WAS_SIB_SERVICE_INTEGRATION_BUS_LINK__FOREIGN_BUS_NAME:
				return getForeignBusName();
			case WasPackage.WAS_SIB_SERVICE_INTEGRATION_BUS_LINK__LINK_NAME:
				return getLinkName();
			case WasPackage.WAS_SIB_SERVICE_INTEGRATION_BUS_LINK__REMOTE_MESSAGING_ENGINE_NAME:
				return getRemoteMessagingEngineName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.WAS_SIB_SERVICE_INTEGRATION_BUS_LINK__BOOT_TRAP_ENDPOINTS:
				setBootTrapEndpoints((String)newValue);
				return;
			case WasPackage.WAS_SIB_SERVICE_INTEGRATION_BUS_LINK__FOREIGN_BUS_NAME:
				setForeignBusName((String)newValue);
				return;
			case WasPackage.WAS_SIB_SERVICE_INTEGRATION_BUS_LINK__LINK_NAME:
				setLinkName((String)newValue);
				return;
			case WasPackage.WAS_SIB_SERVICE_INTEGRATION_BUS_LINK__REMOTE_MESSAGING_ENGINE_NAME:
				setRemoteMessagingEngineName((String)newValue);
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
			case WasPackage.WAS_SIB_SERVICE_INTEGRATION_BUS_LINK__BOOT_TRAP_ENDPOINTS:
				setBootTrapEndpoints(BOOT_TRAP_ENDPOINTS_EDEFAULT);
				return;
			case WasPackage.WAS_SIB_SERVICE_INTEGRATION_BUS_LINK__FOREIGN_BUS_NAME:
				setForeignBusName(FOREIGN_BUS_NAME_EDEFAULT);
				return;
			case WasPackage.WAS_SIB_SERVICE_INTEGRATION_BUS_LINK__LINK_NAME:
				setLinkName(LINK_NAME_EDEFAULT);
				return;
			case WasPackage.WAS_SIB_SERVICE_INTEGRATION_BUS_LINK__REMOTE_MESSAGING_ENGINE_NAME:
				setRemoteMessagingEngineName(REMOTE_MESSAGING_ENGINE_NAME_EDEFAULT);
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
			case WasPackage.WAS_SIB_SERVICE_INTEGRATION_BUS_LINK__BOOT_TRAP_ENDPOINTS:
				return BOOT_TRAP_ENDPOINTS_EDEFAULT == null ? bootTrapEndpoints != null : !BOOT_TRAP_ENDPOINTS_EDEFAULT.equals(bootTrapEndpoints);
			case WasPackage.WAS_SIB_SERVICE_INTEGRATION_BUS_LINK__FOREIGN_BUS_NAME:
				return FOREIGN_BUS_NAME_EDEFAULT == null ? foreignBusName != null : !FOREIGN_BUS_NAME_EDEFAULT.equals(foreignBusName);
			case WasPackage.WAS_SIB_SERVICE_INTEGRATION_BUS_LINK__LINK_NAME:
				return LINK_NAME_EDEFAULT == null ? linkName != null : !LINK_NAME_EDEFAULT.equals(linkName);
			case WasPackage.WAS_SIB_SERVICE_INTEGRATION_BUS_LINK__REMOTE_MESSAGING_ENGINE_NAME:
				return REMOTE_MESSAGING_ENGINE_NAME_EDEFAULT == null ? remoteMessagingEngineName != null : !REMOTE_MESSAGING_ENGINE_NAME_EDEFAULT.equals(remoteMessagingEngineName);
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
		result.append(" (bootTrapEndpoints: "); //$NON-NLS-1$
		result.append(bootTrapEndpoints);
		result.append(", foreignBusName: "); //$NON-NLS-1$
		result.append(foreignBusName);
		result.append(", linkName: "); //$NON-NLS-1$
		result.append(linkName);
		result.append(", remoteMessagingEngineName: "); //$NON-NLS-1$
		result.append(remoteMessagingEngineName);
		result.append(')');
		return result.toString();
	}

} //WasSibServiceIntegrationBusLinkImpl
