/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.java.JdbcTypeType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>DB2 Jdbc Driver</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.DB2JdbcDriverImpl#getClassname <em>Classname</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.DB2JdbcDriverImpl#getClasspath <em>Classpath</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.DB2JdbcDriverImpl#getDriverPath <em>Driver Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.DB2JdbcDriverImpl#getJdbcType <em>Jdbc Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DB2JdbcDriverImpl extends CapabilityImpl implements DB2JdbcDriver {
	/**
	 * The default value of the '{@link #getClassname() <em>Classname</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getClassname()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASSNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassname() <em>Classname</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getClassname()
	 * @generated
	 * @ordered
	 */
	protected String classname = CLASSNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getClasspath() <em>Classpath</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getClasspath()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASSPATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClasspath() <em>Classpath</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getClasspath()
	 * @generated
	 * @ordered
	 */
	protected String classpath = CLASSPATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getDriverPath() <em>Driver Path</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDriverPath()
	 * @generated
	 * @ordered
	 */
	protected static final String DRIVER_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDriverPath() <em>Driver Path</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDriverPath()
	 * @generated
	 * @ordered
	 */
	protected String driverPath = DRIVER_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getJdbcType() <em>Jdbc Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getJdbcType()
	 * @generated
	 * @ordered
	 */
	protected static final JdbcTypeType JDBC_TYPE_EDEFAULT = JdbcTypeType._1_LITERAL;

	/**
	 * The cached value of the '{@link #getJdbcType() <em>Jdbc Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getJdbcType()
	 * @generated
	 * @ordered
	 */
	protected JdbcTypeType jdbcType = JDBC_TYPE_EDEFAULT;

	/**
	 * This is true if the Jdbc Type attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean jdbcTypeESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DB2JdbcDriverImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Db2Package.Literals.DB2_JDBC_DRIVER;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassname() {
		return classname;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassname(String newClassname) {
		String oldClassname = classname;
		classname = newClassname;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.DB2_JDBC_DRIVER__CLASSNAME, oldClassname, classname));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getClasspath() {
		return classpath;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setClasspath(String newClasspath) {
		String oldClasspath = classpath;
		classpath = newClasspath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.DB2_JDBC_DRIVER__CLASSPATH, oldClasspath, classpath));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDriverPath() {
		return driverPath;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDriverPath(String newDriverPath) {
		String oldDriverPath = driverPath;
		driverPath = newDriverPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.DB2_JDBC_DRIVER__DRIVER_PATH, oldDriverPath, driverPath));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JdbcTypeType getJdbcType() {
		return jdbcType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setJdbcType(JdbcTypeType newJdbcType) {
		JdbcTypeType oldJdbcType = jdbcType;
		jdbcType = newJdbcType == null ? JDBC_TYPE_EDEFAULT : newJdbcType;
		boolean oldJdbcTypeESet = jdbcTypeESet;
		jdbcTypeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.DB2_JDBC_DRIVER__JDBC_TYPE, oldJdbcType, jdbcType, !oldJdbcTypeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetJdbcType() {
		JdbcTypeType oldJdbcType = jdbcType;
		boolean oldJdbcTypeESet = jdbcTypeESet;
		jdbcType = JDBC_TYPE_EDEFAULT;
		jdbcTypeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Db2Package.DB2_JDBC_DRIVER__JDBC_TYPE, oldJdbcType, JDBC_TYPE_EDEFAULT, oldJdbcTypeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetJdbcType() {
		return jdbcTypeESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Db2Package.DB2_JDBC_DRIVER__CLASSNAME:
				return getClassname();
			case Db2Package.DB2_JDBC_DRIVER__CLASSPATH:
				return getClasspath();
			case Db2Package.DB2_JDBC_DRIVER__DRIVER_PATH:
				return getDriverPath();
			case Db2Package.DB2_JDBC_DRIVER__JDBC_TYPE:
				return getJdbcType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Db2Package.DB2_JDBC_DRIVER__CLASSNAME:
				setClassname((String)newValue);
				return;
			case Db2Package.DB2_JDBC_DRIVER__CLASSPATH:
				setClasspath((String)newValue);
				return;
			case Db2Package.DB2_JDBC_DRIVER__DRIVER_PATH:
				setDriverPath((String)newValue);
				return;
			case Db2Package.DB2_JDBC_DRIVER__JDBC_TYPE:
				setJdbcType((JdbcTypeType)newValue);
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
			case Db2Package.DB2_JDBC_DRIVER__CLASSNAME:
				setClassname(CLASSNAME_EDEFAULT);
				return;
			case Db2Package.DB2_JDBC_DRIVER__CLASSPATH:
				setClasspath(CLASSPATH_EDEFAULT);
				return;
			case Db2Package.DB2_JDBC_DRIVER__DRIVER_PATH:
				setDriverPath(DRIVER_PATH_EDEFAULT);
				return;
			case Db2Package.DB2_JDBC_DRIVER__JDBC_TYPE:
				unsetJdbcType();
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
			case Db2Package.DB2_JDBC_DRIVER__CLASSNAME:
				return CLASSNAME_EDEFAULT == null ? classname != null : !CLASSNAME_EDEFAULT.equals(classname);
			case Db2Package.DB2_JDBC_DRIVER__CLASSPATH:
				return CLASSPATH_EDEFAULT == null ? classpath != null : !CLASSPATH_EDEFAULT.equals(classpath);
			case Db2Package.DB2_JDBC_DRIVER__DRIVER_PATH:
				return DRIVER_PATH_EDEFAULT == null ? driverPath != null : !DRIVER_PATH_EDEFAULT.equals(driverPath);
			case Db2Package.DB2_JDBC_DRIVER__JDBC_TYPE:
				return isSetJdbcType();
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
		result.append(" (classname: "); //$NON-NLS-1$
		result.append(classname);
		result.append(", classpath: "); //$NON-NLS-1$
		result.append(classpath);
		result.append(", driverPath: "); //$NON-NLS-1$
		result.append(driverPath);
		result.append(", jdbcType: "); //$NON-NLS-1$
		if (jdbcTypeESet) result.append(jdbcType); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //DB2JdbcDriverImpl
