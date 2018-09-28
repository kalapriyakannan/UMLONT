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
import com.ibm.ccl.soa.deploy.was.WasRoutingDefinitionTypeEnum;
import com.ibm.ccl.soa.deploy.was.WasSibForeignBus;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Sib Foreign Bus</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasSibForeignBusImpl#getForeignBusName <em>Foreign Bus Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasSibForeignBusImpl#getInBoundUserID <em>In Bound User ID</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasSibForeignBusImpl#getOutBoundUserID <em>Out Bound User ID</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasSibForeignBusImpl#getRoutingDefinitionType <em>Routing Definition Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasSibForeignBusImpl extends CapabilityImpl implements WasSibForeignBus {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

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
	 * The default value of the '{@link #getInBoundUserID() <em>In Bound User ID</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInBoundUserID()
	 * @generated
	 * @ordered
	 */
	protected static final String IN_BOUND_USER_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInBoundUserID() <em>In Bound User ID</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInBoundUserID()
	 * @generated
	 * @ordered
	 */
	protected String inBoundUserID = IN_BOUND_USER_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getOutBoundUserID() <em>Out Bound User ID</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getOutBoundUserID()
	 * @generated
	 * @ordered
	 */
	protected static final String OUT_BOUND_USER_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOutBoundUserID() <em>Out Bound User ID</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getOutBoundUserID()
	 * @generated
	 * @ordered
	 */
	protected String outBoundUserID = OUT_BOUND_USER_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getRoutingDefinitionType() <em>Routing Definition Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRoutingDefinitionType()
	 * @generated
	 * @ordered
	 */
	protected static final WasRoutingDefinitionTypeEnum ROUTING_DEFINITION_TYPE_EDEFAULT = WasRoutingDefinitionTypeEnum.DIRECT_SERVICE_INTEGRATION_BUS_LINK_LITERAL;

	/**
	 * The cached value of the '{@link #getRoutingDefinitionType() <em>Routing Definition Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getRoutingDefinitionType()
	 * @generated
	 * @ordered
	 */
	protected WasRoutingDefinitionTypeEnum routingDefinitionType = ROUTING_DEFINITION_TYPE_EDEFAULT;

	/**
	 * This is true if the Routing Definition Type attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean routingDefinitionTypeESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasSibForeignBusImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_SIB_FOREIGN_BUS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SIB_FOREIGN_BUS__FOREIGN_BUS_NAME, oldForeignBusName, foreignBusName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getInBoundUserID() {
		return inBoundUserID;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setInBoundUserID(String newInBoundUserID) {
		String oldInBoundUserID = inBoundUserID;
		inBoundUserID = newInBoundUserID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SIB_FOREIGN_BUS__IN_BOUND_USER_ID, oldInBoundUserID, inBoundUserID));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getOutBoundUserID() {
		return outBoundUserID;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutBoundUserID(String newOutBoundUserID) {
		String oldOutBoundUserID = outBoundUserID;
		outBoundUserID = newOutBoundUserID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SIB_FOREIGN_BUS__OUT_BOUND_USER_ID, oldOutBoundUserID, outBoundUserID));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasRoutingDefinitionTypeEnum getRoutingDefinitionType() {
		return routingDefinitionType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoutingDefinitionType(WasRoutingDefinitionTypeEnum newRoutingDefinitionType) {
		WasRoutingDefinitionTypeEnum oldRoutingDefinitionType = routingDefinitionType;
		routingDefinitionType = newRoutingDefinitionType == null ? ROUTING_DEFINITION_TYPE_EDEFAULT : newRoutingDefinitionType;
		boolean oldRoutingDefinitionTypeESet = routingDefinitionTypeESet;
		routingDefinitionTypeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_SIB_FOREIGN_BUS__ROUTING_DEFINITION_TYPE, oldRoutingDefinitionType, routingDefinitionType, !oldRoutingDefinitionTypeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRoutingDefinitionType() {
		WasRoutingDefinitionTypeEnum oldRoutingDefinitionType = routingDefinitionType;
		boolean oldRoutingDefinitionTypeESet = routingDefinitionTypeESet;
		routingDefinitionType = ROUTING_DEFINITION_TYPE_EDEFAULT;
		routingDefinitionTypeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_SIB_FOREIGN_BUS__ROUTING_DEFINITION_TYPE, oldRoutingDefinitionType, ROUTING_DEFINITION_TYPE_EDEFAULT, oldRoutingDefinitionTypeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRoutingDefinitionType() {
		return routingDefinitionTypeESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.WAS_SIB_FOREIGN_BUS__FOREIGN_BUS_NAME:
				return getForeignBusName();
			case WasPackage.WAS_SIB_FOREIGN_BUS__IN_BOUND_USER_ID:
				return getInBoundUserID();
			case WasPackage.WAS_SIB_FOREIGN_BUS__OUT_BOUND_USER_ID:
				return getOutBoundUserID();
			case WasPackage.WAS_SIB_FOREIGN_BUS__ROUTING_DEFINITION_TYPE:
				return getRoutingDefinitionType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.WAS_SIB_FOREIGN_BUS__FOREIGN_BUS_NAME:
				setForeignBusName((String)newValue);
				return;
			case WasPackage.WAS_SIB_FOREIGN_BUS__IN_BOUND_USER_ID:
				setInBoundUserID((String)newValue);
				return;
			case WasPackage.WAS_SIB_FOREIGN_BUS__OUT_BOUND_USER_ID:
				setOutBoundUserID((String)newValue);
				return;
			case WasPackage.WAS_SIB_FOREIGN_BUS__ROUTING_DEFINITION_TYPE:
				setRoutingDefinitionType((WasRoutingDefinitionTypeEnum)newValue);
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
			case WasPackage.WAS_SIB_FOREIGN_BUS__FOREIGN_BUS_NAME:
				setForeignBusName(FOREIGN_BUS_NAME_EDEFAULT);
				return;
			case WasPackage.WAS_SIB_FOREIGN_BUS__IN_BOUND_USER_ID:
				setInBoundUserID(IN_BOUND_USER_ID_EDEFAULT);
				return;
			case WasPackage.WAS_SIB_FOREIGN_BUS__OUT_BOUND_USER_ID:
				setOutBoundUserID(OUT_BOUND_USER_ID_EDEFAULT);
				return;
			case WasPackage.WAS_SIB_FOREIGN_BUS__ROUTING_DEFINITION_TYPE:
				unsetRoutingDefinitionType();
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
			case WasPackage.WAS_SIB_FOREIGN_BUS__FOREIGN_BUS_NAME:
				return FOREIGN_BUS_NAME_EDEFAULT == null ? foreignBusName != null : !FOREIGN_BUS_NAME_EDEFAULT.equals(foreignBusName);
			case WasPackage.WAS_SIB_FOREIGN_BUS__IN_BOUND_USER_ID:
				return IN_BOUND_USER_ID_EDEFAULT == null ? inBoundUserID != null : !IN_BOUND_USER_ID_EDEFAULT.equals(inBoundUserID);
			case WasPackage.WAS_SIB_FOREIGN_BUS__OUT_BOUND_USER_ID:
				return OUT_BOUND_USER_ID_EDEFAULT == null ? outBoundUserID != null : !OUT_BOUND_USER_ID_EDEFAULT.equals(outBoundUserID);
			case WasPackage.WAS_SIB_FOREIGN_BUS__ROUTING_DEFINITION_TYPE:
				return isSetRoutingDefinitionType();
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
		result.append(" (foreignBusName: "); //$NON-NLS-1$
		result.append(foreignBusName);
		result.append(", inBoundUserID: "); //$NON-NLS-1$
		result.append(inBoundUserID);
		result.append(", outBoundUserID: "); //$NON-NLS-1$
		result.append(outBoundUserID);
		result.append(", routingDefinitionType: "); //$NON-NLS-1$
		if (routingDefinitionTypeESet) result.append(routingDefinitionType); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //WasSibForeignBusImpl
