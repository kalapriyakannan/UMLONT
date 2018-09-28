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

import com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDatasourceImpl;
import com.ibm.ccl.soa.deploy.was.WasDatasource;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Datasource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDatasourceImpl#getCategory <em>Category</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDatasourceImpl#getConnectionTimeout <em>Connection Timeout</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDatasourceImpl#getMaxConnections <em>Max Connections</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDatasourceImpl#getMinConnections <em>Min Connections</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasDatasourceImpl#getStatementCacheSize <em>Statement Cache Size</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasDatasourceImpl extends J2EEDatasourceImpl implements WasDatasource {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getCategory() <em>Category</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected static final String CATEGORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCategory() <em>Category</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCategory()
	 * @generated
	 * @ordered
	 */
	protected String category = CATEGORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getConnectionTimeout() <em>Connection Timeout</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getConnectionTimeout()
	 * @generated
	 * @ordered
	 */
	protected static final String CONNECTION_TIMEOUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConnectionTimeout() <em>Connection Timeout</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getConnectionTimeout()
	 * @generated
	 * @ordered
	 */
	protected String connectionTimeout = CONNECTION_TIMEOUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxConnections() <em>Max Connections</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMaxConnections()
	 * @generated
	 * @ordered
	 */
	protected static final String MAX_CONNECTIONS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxConnections() <em>Max Connections</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMaxConnections()
	 * @generated
	 * @ordered
	 */
	protected String maxConnections = MAX_CONNECTIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinConnections() <em>Min Connections</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMinConnections()
	 * @generated
	 * @ordered
	 */
	protected static final String MIN_CONNECTIONS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMinConnections() <em>Min Connections</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMinConnections()
	 * @generated
	 * @ordered
	 */
	protected String minConnections = MIN_CONNECTIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #getStatementCacheSize() <em>Statement Cache Size</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getStatementCacheSize()
	 * @generated
	 * @ordered
	 */
	protected static final String STATEMENT_CACHE_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStatementCacheSize() <em>Statement Cache Size</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getStatementCacheSize()
	 * @generated
	 * @ordered
	 */
	protected String statementCacheSize = STATEMENT_CACHE_SIZE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasDatasourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_DATASOURCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCategory(String newCategory) {
		String oldCategory = category;
		category = newCategory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_DATASOURCE__CATEGORY, oldCategory, category));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getConnectionTimeout() {
		return connectionTimeout;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setConnectionTimeout(String newConnectionTimeout) {
		String oldConnectionTimeout = connectionTimeout;
		connectionTimeout = newConnectionTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_DATASOURCE__CONNECTION_TIMEOUT, oldConnectionTimeout, connectionTimeout));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaxConnections() {
		return maxConnections;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxConnections(String newMaxConnections) {
		String oldMaxConnections = maxConnections;
		maxConnections = newMaxConnections;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_DATASOURCE__MAX_CONNECTIONS, oldMaxConnections, maxConnections));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getMinConnections() {
		return minConnections;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinConnections(String newMinConnections) {
		String oldMinConnections = minConnections;
		minConnections = newMinConnections;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_DATASOURCE__MIN_CONNECTIONS, oldMinConnections, minConnections));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getStatementCacheSize() {
		return statementCacheSize;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatementCacheSize(String newStatementCacheSize) {
		String oldStatementCacheSize = statementCacheSize;
		statementCacheSize = newStatementCacheSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_DATASOURCE__STATEMENT_CACHE_SIZE, oldStatementCacheSize, statementCacheSize));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.WAS_DATASOURCE__CATEGORY:
				return getCategory();
			case WasPackage.WAS_DATASOURCE__CONNECTION_TIMEOUT:
				return getConnectionTimeout();
			case WasPackage.WAS_DATASOURCE__MAX_CONNECTIONS:
				return getMaxConnections();
			case WasPackage.WAS_DATASOURCE__MIN_CONNECTIONS:
				return getMinConnections();
			case WasPackage.WAS_DATASOURCE__STATEMENT_CACHE_SIZE:
				return getStatementCacheSize();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.WAS_DATASOURCE__CATEGORY:
				setCategory((String)newValue);
				return;
			case WasPackage.WAS_DATASOURCE__CONNECTION_TIMEOUT:
				setConnectionTimeout((String)newValue);
				return;
			case WasPackage.WAS_DATASOURCE__MAX_CONNECTIONS:
				setMaxConnections((String)newValue);
				return;
			case WasPackage.WAS_DATASOURCE__MIN_CONNECTIONS:
				setMinConnections((String)newValue);
				return;
			case WasPackage.WAS_DATASOURCE__STATEMENT_CACHE_SIZE:
				setStatementCacheSize((String)newValue);
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
			case WasPackage.WAS_DATASOURCE__CATEGORY:
				setCategory(CATEGORY_EDEFAULT);
				return;
			case WasPackage.WAS_DATASOURCE__CONNECTION_TIMEOUT:
				setConnectionTimeout(CONNECTION_TIMEOUT_EDEFAULT);
				return;
			case WasPackage.WAS_DATASOURCE__MAX_CONNECTIONS:
				setMaxConnections(MAX_CONNECTIONS_EDEFAULT);
				return;
			case WasPackage.WAS_DATASOURCE__MIN_CONNECTIONS:
				setMinConnections(MIN_CONNECTIONS_EDEFAULT);
				return;
			case WasPackage.WAS_DATASOURCE__STATEMENT_CACHE_SIZE:
				setStatementCacheSize(STATEMENT_CACHE_SIZE_EDEFAULT);
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
			case WasPackage.WAS_DATASOURCE__CATEGORY:
				return CATEGORY_EDEFAULT == null ? category != null : !CATEGORY_EDEFAULT.equals(category);
			case WasPackage.WAS_DATASOURCE__CONNECTION_TIMEOUT:
				return CONNECTION_TIMEOUT_EDEFAULT == null ? connectionTimeout != null : !CONNECTION_TIMEOUT_EDEFAULT.equals(connectionTimeout);
			case WasPackage.WAS_DATASOURCE__MAX_CONNECTIONS:
				return MAX_CONNECTIONS_EDEFAULT == null ? maxConnections != null : !MAX_CONNECTIONS_EDEFAULT.equals(maxConnections);
			case WasPackage.WAS_DATASOURCE__MIN_CONNECTIONS:
				return MIN_CONNECTIONS_EDEFAULT == null ? minConnections != null : !MIN_CONNECTIONS_EDEFAULT.equals(minConnections);
			case WasPackage.WAS_DATASOURCE__STATEMENT_CACHE_SIZE:
				return STATEMENT_CACHE_SIZE_EDEFAULT == null ? statementCacheSize != null : !STATEMENT_CACHE_SIZE_EDEFAULT.equals(statementCacheSize);
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
		result.append(" (category: "); //$NON-NLS-1$
		result.append(category);
		result.append(", connectionTimeout: "); //$NON-NLS-1$
		result.append(connectionTimeout);
		result.append(", maxConnections: "); //$NON-NLS-1$
		result.append(maxConnections);
		result.append(", minConnections: "); //$NON-NLS-1$
		result.append(minConnections);
		result.append(", statementCacheSize: "); //$NON-NLS-1$
		result.append(statementCacheSize);
		result.append(')');
		return result.toString();
	}

} //WasDatasourceImpl
