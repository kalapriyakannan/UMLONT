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

import com.ibm.ccl.soa.deploy.was.DataSourceHelperClassNames;
import com.ibm.ccl.soa.deploy.was.Policies;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasV5Datasource;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>V5 Datasource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasV5DatasourceImpl#getAgedTimeout <em>Aged Timeout</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasV5DatasourceImpl#getDataSourceHelperClassName <em>Data Source Helper Class Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasV5DatasourceImpl#getJ2cAuthAlias <em>J2c Auth Alias</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasV5DatasourceImpl#getPurgePolicy <em>Purge Policy</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasV5DatasourceImpl#getReapTime <em>Reap Time</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasV5DatasourceImpl#getUnusedTimeout <em>Unused Timeout</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasV5DatasourceImpl extends WasDatasourceImpl implements WasV5Datasource {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getAgedTimeout() <em>Aged Timeout</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAgedTimeout()
	 * @generated
	 * @ordered
	 */
	protected static final String AGED_TIMEOUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAgedTimeout() <em>Aged Timeout</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAgedTimeout()
	 * @generated
	 * @ordered
	 */
	protected String agedTimeout = AGED_TIMEOUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getDataSourceHelperClassName() <em>Data Source Helper Class Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDataSourceHelperClassName()
	 * @generated
	 * @ordered
	 */
	protected static final DataSourceHelperClassNames DATA_SOURCE_HELPER_CLASS_NAME_EDEFAULT = DataSourceHelperClassNames.COM_IBM_WEBSPHERE_RSADAPTER_DB2_UNIVERSAL_DATA_STORE_HELPER_LITERAL;

	/**
	 * The cached value of the '{@link #getDataSourceHelperClassName() <em>Data Source Helper Class Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDataSourceHelperClassName()
	 * @generated
	 * @ordered
	 */
	protected DataSourceHelperClassNames dataSourceHelperClassName = DATA_SOURCE_HELPER_CLASS_NAME_EDEFAULT;

	/**
	 * This is true if the Data Source Helper Class Name attribute has been set.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean dataSourceHelperClassNameESet;

	/**
	 * The default value of the '{@link #getJ2cAuthAlias() <em>J2c Auth Alias</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getJ2cAuthAlias()
	 * @generated
	 * @ordered
	 */
	protected static final String J2C_AUTH_ALIAS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJ2cAuthAlias() <em>J2c Auth Alias</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getJ2cAuthAlias()
	 * @generated
	 * @ordered
	 */
	protected String j2cAuthAlias = J2C_AUTH_ALIAS_EDEFAULT;

	/**
	 * The default value of the '{@link #getPurgePolicy() <em>Purge Policy</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPurgePolicy()
	 * @generated
	 * @ordered
	 */
	protected static final Policies PURGE_POLICY_EDEFAULT = Policies.ENTIRE_POOL_LITERAL;

	/**
	 * The cached value of the '{@link #getPurgePolicy() <em>Purge Policy</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPurgePolicy()
	 * @generated
	 * @ordered
	 */
	protected Policies purgePolicy = PURGE_POLICY_EDEFAULT;

	/**
	 * This is true if the Purge Policy attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean purgePolicyESet;

	/**
	 * The default value of the '{@link #getReapTime() <em>Reap Time</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getReapTime()
	 * @generated
	 * @ordered
	 */
	protected static final String REAP_TIME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReapTime() <em>Reap Time</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getReapTime()
	 * @generated
	 * @ordered
	 */
	protected String reapTime = REAP_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getUnusedTimeout() <em>Unused Timeout</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getUnusedTimeout()
	 * @generated
	 * @ordered
	 */
	protected static final String UNUSED_TIMEOUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUnusedTimeout() <em>Unused Timeout</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getUnusedTimeout()
	 * @generated
	 * @ordered
	 */
	protected String unusedTimeout = UNUSED_TIMEOUT_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasV5DatasourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_V5_DATASOURCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getAgedTimeout() {
		return agedTimeout;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAgedTimeout(String newAgedTimeout) {
		String oldAgedTimeout = agedTimeout;
		agedTimeout = newAgedTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_V5_DATASOURCE__AGED_TIMEOUT, oldAgedTimeout, agedTimeout));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DataSourceHelperClassNames getDataSourceHelperClassName() {
		return dataSourceHelperClassName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataSourceHelperClassName(DataSourceHelperClassNames newDataSourceHelperClassName) {
		DataSourceHelperClassNames oldDataSourceHelperClassName = dataSourceHelperClassName;
		dataSourceHelperClassName = newDataSourceHelperClassName == null ? DATA_SOURCE_HELPER_CLASS_NAME_EDEFAULT : newDataSourceHelperClassName;
		boolean oldDataSourceHelperClassNameESet = dataSourceHelperClassNameESet;
		dataSourceHelperClassNameESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_V5_DATASOURCE__DATA_SOURCE_HELPER_CLASS_NAME, oldDataSourceHelperClassName, dataSourceHelperClassName, !oldDataSourceHelperClassNameESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDataSourceHelperClassName() {
		DataSourceHelperClassNames oldDataSourceHelperClassName = dataSourceHelperClassName;
		boolean oldDataSourceHelperClassNameESet = dataSourceHelperClassNameESet;
		dataSourceHelperClassName = DATA_SOURCE_HELPER_CLASS_NAME_EDEFAULT;
		dataSourceHelperClassNameESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_V5_DATASOURCE__DATA_SOURCE_HELPER_CLASS_NAME, oldDataSourceHelperClassName, DATA_SOURCE_HELPER_CLASS_NAME_EDEFAULT, oldDataSourceHelperClassNameESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDataSourceHelperClassName() {
		return dataSourceHelperClassNameESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getJ2cAuthAlias() {
		return j2cAuthAlias;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setJ2cAuthAlias(String newJ2cAuthAlias) {
		String oldJ2cAuthAlias = j2cAuthAlias;
		j2cAuthAlias = newJ2cAuthAlias;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_V5_DATASOURCE__J2C_AUTH_ALIAS, oldJ2cAuthAlias, j2cAuthAlias));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Policies getPurgePolicy() {
		return purgePolicy;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPurgePolicy(Policies newPurgePolicy) {
		Policies oldPurgePolicy = purgePolicy;
		purgePolicy = newPurgePolicy == null ? PURGE_POLICY_EDEFAULT : newPurgePolicy;
		boolean oldPurgePolicyESet = purgePolicyESet;
		purgePolicyESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_V5_DATASOURCE__PURGE_POLICY, oldPurgePolicy, purgePolicy, !oldPurgePolicyESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPurgePolicy() {
		Policies oldPurgePolicy = purgePolicy;
		boolean oldPurgePolicyESet = purgePolicyESet;
		purgePolicy = PURGE_POLICY_EDEFAULT;
		purgePolicyESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_V5_DATASOURCE__PURGE_POLICY, oldPurgePolicy, PURGE_POLICY_EDEFAULT, oldPurgePolicyESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPurgePolicy() {
		return purgePolicyESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getReapTime() {
		return reapTime;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setReapTime(String newReapTime) {
		String oldReapTime = reapTime;
		reapTime = newReapTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_V5_DATASOURCE__REAP_TIME, oldReapTime, reapTime));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getUnusedTimeout() {
		return unusedTimeout;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnusedTimeout(String newUnusedTimeout) {
		String oldUnusedTimeout = unusedTimeout;
		unusedTimeout = newUnusedTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_V5_DATASOURCE__UNUSED_TIMEOUT, oldUnusedTimeout, unusedTimeout));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.WAS_V5_DATASOURCE__AGED_TIMEOUT:
				return getAgedTimeout();
			case WasPackage.WAS_V5_DATASOURCE__DATA_SOURCE_HELPER_CLASS_NAME:
				return getDataSourceHelperClassName();
			case WasPackage.WAS_V5_DATASOURCE__J2C_AUTH_ALIAS:
				return getJ2cAuthAlias();
			case WasPackage.WAS_V5_DATASOURCE__PURGE_POLICY:
				return getPurgePolicy();
			case WasPackage.WAS_V5_DATASOURCE__REAP_TIME:
				return getReapTime();
			case WasPackage.WAS_V5_DATASOURCE__UNUSED_TIMEOUT:
				return getUnusedTimeout();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.WAS_V5_DATASOURCE__AGED_TIMEOUT:
				setAgedTimeout((String)newValue);
				return;
			case WasPackage.WAS_V5_DATASOURCE__DATA_SOURCE_HELPER_CLASS_NAME:
				setDataSourceHelperClassName((DataSourceHelperClassNames)newValue);
				return;
			case WasPackage.WAS_V5_DATASOURCE__J2C_AUTH_ALIAS:
				setJ2cAuthAlias((String)newValue);
				return;
			case WasPackage.WAS_V5_DATASOURCE__PURGE_POLICY:
				setPurgePolicy((Policies)newValue);
				return;
			case WasPackage.WAS_V5_DATASOURCE__REAP_TIME:
				setReapTime((String)newValue);
				return;
			case WasPackage.WAS_V5_DATASOURCE__UNUSED_TIMEOUT:
				setUnusedTimeout((String)newValue);
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
			case WasPackage.WAS_V5_DATASOURCE__AGED_TIMEOUT:
				setAgedTimeout(AGED_TIMEOUT_EDEFAULT);
				return;
			case WasPackage.WAS_V5_DATASOURCE__DATA_SOURCE_HELPER_CLASS_NAME:
				unsetDataSourceHelperClassName();
				return;
			case WasPackage.WAS_V5_DATASOURCE__J2C_AUTH_ALIAS:
				setJ2cAuthAlias(J2C_AUTH_ALIAS_EDEFAULT);
				return;
			case WasPackage.WAS_V5_DATASOURCE__PURGE_POLICY:
				unsetPurgePolicy();
				return;
			case WasPackage.WAS_V5_DATASOURCE__REAP_TIME:
				setReapTime(REAP_TIME_EDEFAULT);
				return;
			case WasPackage.WAS_V5_DATASOURCE__UNUSED_TIMEOUT:
				setUnusedTimeout(UNUSED_TIMEOUT_EDEFAULT);
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
			case WasPackage.WAS_V5_DATASOURCE__AGED_TIMEOUT:
				return AGED_TIMEOUT_EDEFAULT == null ? agedTimeout != null : !AGED_TIMEOUT_EDEFAULT.equals(agedTimeout);
			case WasPackage.WAS_V5_DATASOURCE__DATA_SOURCE_HELPER_CLASS_NAME:
				return isSetDataSourceHelperClassName();
			case WasPackage.WAS_V5_DATASOURCE__J2C_AUTH_ALIAS:
				return J2C_AUTH_ALIAS_EDEFAULT == null ? j2cAuthAlias != null : !J2C_AUTH_ALIAS_EDEFAULT.equals(j2cAuthAlias);
			case WasPackage.WAS_V5_DATASOURCE__PURGE_POLICY:
				return isSetPurgePolicy();
			case WasPackage.WAS_V5_DATASOURCE__REAP_TIME:
				return REAP_TIME_EDEFAULT == null ? reapTime != null : !REAP_TIME_EDEFAULT.equals(reapTime);
			case WasPackage.WAS_V5_DATASOURCE__UNUSED_TIMEOUT:
				return UNUSED_TIMEOUT_EDEFAULT == null ? unusedTimeout != null : !UNUSED_TIMEOUT_EDEFAULT.equals(unusedTimeout);
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
		result.append(" (agedTimeout: "); //$NON-NLS-1$
		result.append(agedTimeout);
		result.append(", dataSourceHelperClassName: "); //$NON-NLS-1$
		if (dataSourceHelperClassNameESet) result.append(dataSourceHelperClassName); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", j2cAuthAlias: "); //$NON-NLS-1$
		result.append(j2cAuthAlias);
		result.append(", purgePolicy: "); //$NON-NLS-1$
		if (purgePolicyESet) result.append(purgePolicy); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", reapTime: "); //$NON-NLS-1$
		result.append(reapTime);
		result.append(", unusedTimeout: "); //$NON-NLS-1$
		result.append(unusedTimeout);
		result.append(')');
		return result.toString();
	}

} //WasV5DatasourceImpl
