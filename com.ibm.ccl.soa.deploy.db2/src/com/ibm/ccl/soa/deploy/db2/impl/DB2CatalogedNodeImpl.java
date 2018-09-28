/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2.impl;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode;
import com.ibm.ccl.soa.deploy.db2.Db2Package;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>DB2 Cataloged Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.DB2CatalogedNodeImpl#getDasLevel <em>Das Level</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.DB2CatalogedNodeImpl#getHostname <em>Hostname</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.DB2CatalogedNodeImpl#getNodeName <em>Node Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.DB2CatalogedNodeImpl#getNodeType <em>Node Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.DB2CatalogedNodeImpl#getPort <em>Port</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DB2CatalogedNodeImpl extends CapabilityImpl implements DB2CatalogedNode {
	/**
	 * The default value of the '{@link #getDasLevel() <em>Das Level</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDasLevel()
	 * @generated
	 * @ordered
	 */
	protected static final String DAS_LEVEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDasLevel() <em>Das Level</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDasLevel()
	 * @generated
	 * @ordered
	 */
	protected String dasLevel = DAS_LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getHostname() <em>Hostname</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getHostname()
	 * @generated
	 * @ordered
	 */
	protected static final String HOSTNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHostname() <em>Hostname</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getHostname()
	 * @generated
	 * @ordered
	 */
	protected String hostname = HOSTNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getNodeName() <em>Node Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNodeName()
	 * @generated
	 * @ordered
	 */
	protected static final String NODE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNodeName() <em>Node Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNodeName()
	 * @generated
	 * @ordered
	 */
	protected String nodeName = NODE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getNodeType() <em>Node Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNodeType()
	 * @generated
	 * @ordered
	 */
	protected static final String NODE_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNodeType() <em>Node Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNodeType()
	 * @generated
	 * @ordered
	 */
	protected String nodeType = NODE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPort() <em>Port</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger PORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPort() <em>Port</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected BigInteger port = PORT_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DB2CatalogedNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Db2Package.Literals.DB2_CATALOGED_NODE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDasLevel() {
		return dasLevel;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDasLevel(String newDasLevel) {
		String oldDasLevel = dasLevel;
		dasLevel = newDasLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.DB2_CATALOGED_NODE__DAS_LEVEL, oldDasLevel, dasLevel));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getHostname() {
		return hostname;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHostname(String newHostname) {
		String oldHostname = hostname;
		hostname = newHostname;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.DB2_CATALOGED_NODE__HOSTNAME, oldHostname, hostname));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getNodeName() {
		return nodeName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeName(String newNodeName) {
		String oldNodeName = nodeName;
		nodeName = newNodeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.DB2_CATALOGED_NODE__NODE_NAME, oldNodeName, nodeName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getNodeType() {
		return nodeType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setNodeType(String newNodeType) {
		String oldNodeType = nodeType;
		nodeType = newNodeType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.DB2_CATALOGED_NODE__NODE_TYPE, oldNodeType, nodeType));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getPort() {
		return port;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPort(BigInteger newPort) {
		BigInteger oldPort = port;
		port = newPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.DB2_CATALOGED_NODE__PORT, oldPort, port));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Db2Package.DB2_CATALOGED_NODE__DAS_LEVEL:
				return getDasLevel();
			case Db2Package.DB2_CATALOGED_NODE__HOSTNAME:
				return getHostname();
			case Db2Package.DB2_CATALOGED_NODE__NODE_NAME:
				return getNodeName();
			case Db2Package.DB2_CATALOGED_NODE__NODE_TYPE:
				return getNodeType();
			case Db2Package.DB2_CATALOGED_NODE__PORT:
				return getPort();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Db2Package.DB2_CATALOGED_NODE__DAS_LEVEL:
				setDasLevel((String)newValue);
				return;
			case Db2Package.DB2_CATALOGED_NODE__HOSTNAME:
				setHostname((String)newValue);
				return;
			case Db2Package.DB2_CATALOGED_NODE__NODE_NAME:
				setNodeName((String)newValue);
				return;
			case Db2Package.DB2_CATALOGED_NODE__NODE_TYPE:
				setNodeType((String)newValue);
				return;
			case Db2Package.DB2_CATALOGED_NODE__PORT:
				setPort((BigInteger)newValue);
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
			case Db2Package.DB2_CATALOGED_NODE__DAS_LEVEL:
				setDasLevel(DAS_LEVEL_EDEFAULT);
				return;
			case Db2Package.DB2_CATALOGED_NODE__HOSTNAME:
				setHostname(HOSTNAME_EDEFAULT);
				return;
			case Db2Package.DB2_CATALOGED_NODE__NODE_NAME:
				setNodeName(NODE_NAME_EDEFAULT);
				return;
			case Db2Package.DB2_CATALOGED_NODE__NODE_TYPE:
				setNodeType(NODE_TYPE_EDEFAULT);
				return;
			case Db2Package.DB2_CATALOGED_NODE__PORT:
				setPort(PORT_EDEFAULT);
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
			case Db2Package.DB2_CATALOGED_NODE__DAS_LEVEL:
				return DAS_LEVEL_EDEFAULT == null ? dasLevel != null : !DAS_LEVEL_EDEFAULT.equals(dasLevel);
			case Db2Package.DB2_CATALOGED_NODE__HOSTNAME:
				return HOSTNAME_EDEFAULT == null ? hostname != null : !HOSTNAME_EDEFAULT.equals(hostname);
			case Db2Package.DB2_CATALOGED_NODE__NODE_NAME:
				return NODE_NAME_EDEFAULT == null ? nodeName != null : !NODE_NAME_EDEFAULT.equals(nodeName);
			case Db2Package.DB2_CATALOGED_NODE__NODE_TYPE:
				return NODE_TYPE_EDEFAULT == null ? nodeType != null : !NODE_TYPE_EDEFAULT.equals(nodeType);
			case Db2Package.DB2_CATALOGED_NODE__PORT:
				return PORT_EDEFAULT == null ? port != null : !PORT_EDEFAULT.equals(port);
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
		result.append(" (dasLevel: "); //$NON-NLS-1$
		result.append(dasLevel);
		result.append(", hostname: "); //$NON-NLS-1$
		result.append(hostname);
		result.append(", nodeName: "); //$NON-NLS-1$
		result.append(nodeName);
		result.append(", nodeType: "); //$NON-NLS-1$
		result.append(nodeType);
		result.append(", port: "); //$NON-NLS-1$
		result.append(port);
		result.append(')');
		return result.toString();
	}

	/**
	 * Immutable list of capability key attributes returned by {@link #titleKeys()}.
	 */
	private final static List _titleKeys = Collections.singletonList(Db2Package.eINSTANCE
			.getDB2CatalogedNode_NodeName());

	/*
	 * @see com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl#titleKeys()
	 */
	public List titleKeys() {
		return _titleKeys;
	}
} //DB2CatalogedNodeImpl
