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

import com.ibm.ccl.soa.deploy.database.impl.DatabaseImpl;
import com.ibm.ccl.soa.deploy.db2.DB2Database;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.PageSizeType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>DB2 Database</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.DB2DatabaseImpl#getCatalogSp <em>Catalog Sp</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.DB2DatabaseImpl#getCodeSet <em>Code Set</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.DB2DatabaseImpl#getCreatePath <em>Create Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.DB2DatabaseImpl#getDb2Version <em>Db2 Version</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.DB2DatabaseImpl#getDbAlias <em>Db Alias</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.DB2DatabaseImpl#getDbDrive <em>Db Drive</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.DB2DatabaseImpl#getDbName <em>Db Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.DB2DatabaseImpl#getDftExtentSize <em>Dft Extent Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.DB2DatabaseImpl#getPageSize <em>Page Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.DB2DatabaseImpl#getTempSp <em>Temp Sp</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.DB2DatabaseImpl#getTerritory <em>Territory</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2.impl.DB2DatabaseImpl#getUserSp <em>User Sp</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DB2DatabaseImpl extends DatabaseImpl implements DB2Database {
	/**
	 * The default value of the '{@link #getCatalogSp() <em>Catalog Sp</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCatalogSp()
	 * @generated
	 * @ordered
	 */
	protected static final String CATALOG_SP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCatalogSp() <em>Catalog Sp</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCatalogSp()
	 * @generated
	 * @ordered
	 */
	protected String catalogSp = CATALOG_SP_EDEFAULT;

	/**
	 * The default value of the '{@link #getCodeSet() <em>Code Set</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCodeSet()
	 * @generated
	 * @ordered
	 */
	protected static final String CODE_SET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCodeSet() <em>Code Set</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCodeSet()
	 * @generated
	 * @ordered
	 */
	protected String codeSet = CODE_SET_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreatePath() <em>Create Path</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCreatePath()
	 * @generated
	 * @ordered
	 */
	protected static final String CREATE_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreatePath() <em>Create Path</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCreatePath()
	 * @generated
	 * @ordered
	 */
	protected String createPath = CREATE_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getDb2Version() <em>Db2 Version</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDb2Version()
	 * @generated
	 * @ordered
	 */
	protected static final String DB2_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDb2Version() <em>Db2 Version</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDb2Version()
	 * @generated
	 * @ordered
	 */
	protected String db2Version = DB2_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDbAlias() <em>Db Alias</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDbAlias()
	 * @generated
	 * @ordered
	 */
	protected static final String DB_ALIAS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDbAlias() <em>Db Alias</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDbAlias()
	 * @generated
	 * @ordered
	 */
	protected String dbAlias = DB_ALIAS_EDEFAULT;

	/**
	 * The default value of the '{@link #getDbDrive() <em>Db Drive</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDbDrive()
	 * @generated
	 * @ordered
	 */
	protected static final String DB_DRIVE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDbDrive() <em>Db Drive</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDbDrive()
	 * @generated
	 * @ordered
	 */
	protected String dbDrive = DB_DRIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDbName() <em>Db Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDbName()
	 * @generated
	 * @ordered
	 */
	protected static final String DB_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDbName() <em>Db Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDbName()
	 * @generated
	 * @ordered
	 */
	protected String dbName = DB_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDftExtentSize() <em>Dft Extent Size</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDftExtentSize()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger DFT_EXTENT_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDftExtentSize() <em>Dft Extent Size</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDftExtentSize()
	 * @generated
	 * @ordered
	 */
	protected BigInteger dftExtentSize = DFT_EXTENT_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPageSize() <em>Page Size</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPageSize()
	 * @generated
	 * @ordered
	 */
	protected static final PageSizeType PAGE_SIZE_EDEFAULT = PageSizeType._4096_LITERAL;

	/**
	 * The cached value of the '{@link #getPageSize() <em>Page Size</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPageSize()
	 * @generated
	 * @ordered
	 */
	protected PageSizeType pageSize = PAGE_SIZE_EDEFAULT;

	/**
	 * This is true if the Page Size attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean pageSizeESet;

	/**
	 * The default value of the '{@link #getTempSp() <em>Temp Sp</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTempSp()
	 * @generated
	 * @ordered
	 */
	protected static final String TEMP_SP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTempSp() <em>Temp Sp</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTempSp()
	 * @generated
	 * @ordered
	 */
	protected String tempSp = TEMP_SP_EDEFAULT;

	/**
	 * The default value of the '{@link #getTerritory() <em>Territory</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTerritory()
	 * @generated
	 * @ordered
	 */
	protected static final String TERRITORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTerritory() <em>Territory</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTerritory()
	 * @generated
	 * @ordered
	 */
	protected String territory = TERRITORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getUserSp() <em>User Sp</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUserSp()
	 * @generated
	 * @ordered
	 */
	protected static final String USER_SP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUserSp() <em>User Sp</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUserSp()
	 * @generated
	 * @ordered
	 */
	protected String userSp = USER_SP_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DB2DatabaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Db2Package.Literals.DB2_DATABASE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getCatalogSp() {
		return catalogSp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCatalogSp(String newCatalogSp) {
		String oldCatalogSp = catalogSp;
		catalogSp = newCatalogSp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.DB2_DATABASE__CATALOG_SP, oldCatalogSp, catalogSp));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getCodeSet() {
		return codeSet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCodeSet(String newCodeSet) {
		String oldCodeSet = codeSet;
		codeSet = newCodeSet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.DB2_DATABASE__CODE_SET, oldCodeSet, codeSet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getCreatePath() {
		return createPath;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreatePath(String newCreatePath) {
		String oldCreatePath = createPath;
		createPath = newCreatePath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.DB2_DATABASE__CREATE_PATH, oldCreatePath, createPath));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDb2Version() {
		return db2Version;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDb2Version(String newDb2Version) {
		String oldDb2Version = db2Version;
		db2Version = newDb2Version;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.DB2_DATABASE__DB2_VERSION, oldDb2Version, db2Version));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDbAlias() {
		return dbAlias;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDbAlias(String newDbAlias) {
		String oldDbAlias = dbAlias;
		dbAlias = newDbAlias;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.DB2_DATABASE__DB_ALIAS, oldDbAlias, dbAlias));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDbDrive() {
		return dbDrive;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDbDrive(String newDbDrive) {
		String oldDbDrive = dbDrive;
		dbDrive = newDbDrive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.DB2_DATABASE__DB_DRIVE, oldDbDrive, dbDrive));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDbName() {
		return dbName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDbName(String newDbName) {
		String oldDbName = dbName;
		dbName = newDbName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.DB2_DATABASE__DB_NAME, oldDbName, dbName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getDftExtentSize() {
		return dftExtentSize;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDftExtentSize(BigInteger newDftExtentSize) {
		BigInteger oldDftExtentSize = dftExtentSize;
		dftExtentSize = newDftExtentSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.DB2_DATABASE__DFT_EXTENT_SIZE, oldDftExtentSize, dftExtentSize));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PageSizeType getPageSize() {
		return pageSize;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPageSize(PageSizeType newPageSize) {
		PageSizeType oldPageSize = pageSize;
		pageSize = newPageSize == null ? PAGE_SIZE_EDEFAULT : newPageSize;
		boolean oldPageSizeESet = pageSizeESet;
		pageSizeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.DB2_DATABASE__PAGE_SIZE, oldPageSize, pageSize, !oldPageSizeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPageSize() {
		PageSizeType oldPageSize = pageSize;
		boolean oldPageSizeESet = pageSizeESet;
		pageSize = PAGE_SIZE_EDEFAULT;
		pageSizeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, Db2Package.DB2_DATABASE__PAGE_SIZE, oldPageSize, PAGE_SIZE_EDEFAULT, oldPageSizeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPageSize() {
		return pageSizeESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getTempSp() {
		return tempSp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTempSp(String newTempSp) {
		String oldTempSp = tempSp;
		tempSp = newTempSp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.DB2_DATABASE__TEMP_SP, oldTempSp, tempSp));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getTerritory() {
		return territory;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTerritory(String newTerritory) {
		String oldTerritory = territory;
		territory = newTerritory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.DB2_DATABASE__TERRITORY, oldTerritory, territory));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getUserSp() {
		return userSp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserSp(String newUserSp) {
		String oldUserSp = userSp;
		userSp = newUserSp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2Package.DB2_DATABASE__USER_SP, oldUserSp, userSp));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Db2Package.DB2_DATABASE__CATALOG_SP:
				return getCatalogSp();
			case Db2Package.DB2_DATABASE__CODE_SET:
				return getCodeSet();
			case Db2Package.DB2_DATABASE__CREATE_PATH:
				return getCreatePath();
			case Db2Package.DB2_DATABASE__DB2_VERSION:
				return getDb2Version();
			case Db2Package.DB2_DATABASE__DB_ALIAS:
				return getDbAlias();
			case Db2Package.DB2_DATABASE__DB_DRIVE:
				return getDbDrive();
			case Db2Package.DB2_DATABASE__DB_NAME:
				return getDbName();
			case Db2Package.DB2_DATABASE__DFT_EXTENT_SIZE:
				return getDftExtentSize();
			case Db2Package.DB2_DATABASE__PAGE_SIZE:
				return getPageSize();
			case Db2Package.DB2_DATABASE__TEMP_SP:
				return getTempSp();
			case Db2Package.DB2_DATABASE__TERRITORY:
				return getTerritory();
			case Db2Package.DB2_DATABASE__USER_SP:
				return getUserSp();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Db2Package.DB2_DATABASE__CATALOG_SP:
				setCatalogSp((String)newValue);
				return;
			case Db2Package.DB2_DATABASE__CODE_SET:
				setCodeSet((String)newValue);
				return;
			case Db2Package.DB2_DATABASE__CREATE_PATH:
				setCreatePath((String)newValue);
				return;
			case Db2Package.DB2_DATABASE__DB2_VERSION:
				setDb2Version((String)newValue);
				return;
			case Db2Package.DB2_DATABASE__DB_ALIAS:
				setDbAlias((String)newValue);
				return;
			case Db2Package.DB2_DATABASE__DB_DRIVE:
				setDbDrive((String)newValue);
				return;
			case Db2Package.DB2_DATABASE__DB_NAME:
				setDbName((String)newValue);
				return;
			case Db2Package.DB2_DATABASE__DFT_EXTENT_SIZE:
				setDftExtentSize((BigInteger)newValue);
				return;
			case Db2Package.DB2_DATABASE__PAGE_SIZE:
				setPageSize((PageSizeType)newValue);
				return;
			case Db2Package.DB2_DATABASE__TEMP_SP:
				setTempSp((String)newValue);
				return;
			case Db2Package.DB2_DATABASE__TERRITORY:
				setTerritory((String)newValue);
				return;
			case Db2Package.DB2_DATABASE__USER_SP:
				setUserSp((String)newValue);
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
			case Db2Package.DB2_DATABASE__CATALOG_SP:
				setCatalogSp(CATALOG_SP_EDEFAULT);
				return;
			case Db2Package.DB2_DATABASE__CODE_SET:
				setCodeSet(CODE_SET_EDEFAULT);
				return;
			case Db2Package.DB2_DATABASE__CREATE_PATH:
				setCreatePath(CREATE_PATH_EDEFAULT);
				return;
			case Db2Package.DB2_DATABASE__DB2_VERSION:
				setDb2Version(DB2_VERSION_EDEFAULT);
				return;
			case Db2Package.DB2_DATABASE__DB_ALIAS:
				setDbAlias(DB_ALIAS_EDEFAULT);
				return;
			case Db2Package.DB2_DATABASE__DB_DRIVE:
				setDbDrive(DB_DRIVE_EDEFAULT);
				return;
			case Db2Package.DB2_DATABASE__DB_NAME:
				setDbName(DB_NAME_EDEFAULT);
				return;
			case Db2Package.DB2_DATABASE__DFT_EXTENT_SIZE:
				setDftExtentSize(DFT_EXTENT_SIZE_EDEFAULT);
				return;
			case Db2Package.DB2_DATABASE__PAGE_SIZE:
				unsetPageSize();
				return;
			case Db2Package.DB2_DATABASE__TEMP_SP:
				setTempSp(TEMP_SP_EDEFAULT);
				return;
			case Db2Package.DB2_DATABASE__TERRITORY:
				setTerritory(TERRITORY_EDEFAULT);
				return;
			case Db2Package.DB2_DATABASE__USER_SP:
				setUserSp(USER_SP_EDEFAULT);
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
			case Db2Package.DB2_DATABASE__CATALOG_SP:
				return CATALOG_SP_EDEFAULT == null ? catalogSp != null : !CATALOG_SP_EDEFAULT.equals(catalogSp);
			case Db2Package.DB2_DATABASE__CODE_SET:
				return CODE_SET_EDEFAULT == null ? codeSet != null : !CODE_SET_EDEFAULT.equals(codeSet);
			case Db2Package.DB2_DATABASE__CREATE_PATH:
				return CREATE_PATH_EDEFAULT == null ? createPath != null : !CREATE_PATH_EDEFAULT.equals(createPath);
			case Db2Package.DB2_DATABASE__DB2_VERSION:
				return DB2_VERSION_EDEFAULT == null ? db2Version != null : !DB2_VERSION_EDEFAULT.equals(db2Version);
			case Db2Package.DB2_DATABASE__DB_ALIAS:
				return DB_ALIAS_EDEFAULT == null ? dbAlias != null : !DB_ALIAS_EDEFAULT.equals(dbAlias);
			case Db2Package.DB2_DATABASE__DB_DRIVE:
				return DB_DRIVE_EDEFAULT == null ? dbDrive != null : !DB_DRIVE_EDEFAULT.equals(dbDrive);
			case Db2Package.DB2_DATABASE__DB_NAME:
				return DB_NAME_EDEFAULT == null ? dbName != null : !DB_NAME_EDEFAULT.equals(dbName);
			case Db2Package.DB2_DATABASE__DFT_EXTENT_SIZE:
				return DFT_EXTENT_SIZE_EDEFAULT == null ? dftExtentSize != null : !DFT_EXTENT_SIZE_EDEFAULT.equals(dftExtentSize);
			case Db2Package.DB2_DATABASE__PAGE_SIZE:
				return isSetPageSize();
			case Db2Package.DB2_DATABASE__TEMP_SP:
				return TEMP_SP_EDEFAULT == null ? tempSp != null : !TEMP_SP_EDEFAULT.equals(tempSp);
			case Db2Package.DB2_DATABASE__TERRITORY:
				return TERRITORY_EDEFAULT == null ? territory != null : !TERRITORY_EDEFAULT.equals(territory);
			case Db2Package.DB2_DATABASE__USER_SP:
				return USER_SP_EDEFAULT == null ? userSp != null : !USER_SP_EDEFAULT.equals(userSp);
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
		result.append(" (catalogSp: "); //$NON-NLS-1$
		result.append(catalogSp);
		result.append(", codeSet: "); //$NON-NLS-1$
		result.append(codeSet);
		result.append(", createPath: "); //$NON-NLS-1$
		result.append(createPath);
		result.append(", db2Version: "); //$NON-NLS-1$
		result.append(db2Version);
		result.append(", dbAlias: "); //$NON-NLS-1$
		result.append(dbAlias);
		result.append(", dbDrive: "); //$NON-NLS-1$
		result.append(dbDrive);
		result.append(", dbName: "); //$NON-NLS-1$
		result.append(dbName);
		result.append(", dftExtentSize: "); //$NON-NLS-1$
		result.append(dftExtentSize);
		result.append(", pageSize: "); //$NON-NLS-1$
		if (pageSizeESet) result.append(pageSize); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", tempSp: "); //$NON-NLS-1$
		result.append(tempSp);
		result.append(", territory: "); //$NON-NLS-1$
		result.append(territory);
		result.append(", userSp: "); //$NON-NLS-1$
		result.append(userSp);
		result.append(')');
		return result.toString();
	}

	private final static List keys = Collections.singletonList(Db2Package.eINSTANCE
			.getDB2Database_DbName());

	/* @generated NOT */
	public List titleKeys() {
		return keys;
	}

} //DB2DatabaseImpl
