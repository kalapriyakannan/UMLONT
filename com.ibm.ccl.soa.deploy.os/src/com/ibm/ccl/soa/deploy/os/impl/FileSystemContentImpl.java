/**
 * Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved.
 *
 * $Id: FileSystemContentImpl.java,v 1.1 2007/12/19 23:37:06 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.os.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.os.FileSystemContent;
import com.ibm.ccl.soa.deploy.os.OsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>File System Content</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.FileSystemContentImpl#getFixedPath <em>Fixed Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.FileSystemContentImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.FileSystemContentImpl#getLastModified <em>Last Modified</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.FileSystemContentImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.FileSystemContentImpl#getPermissions <em>Permissions</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.FileSystemContentImpl#getRealFile <em>Real File</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.FileSystemContentImpl#getSize <em>Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.FileSystemContentImpl#getURI <em>URI</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FileSystemContentImpl extends CapabilityImpl implements FileSystemContent {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getFixedPath() <em>Fixed Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFixedPath()
	 * @generated
	 * @ordered
	 */
	protected static final String FIXED_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFixedPath() <em>Fixed Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFixedPath()
	 * @generated
	 * @ordered
	 */
	protected String fixedPath = FIXED_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getGroup() <em>Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroup()
	 * @generated
	 * @ordered
	 */
	protected static final String GROUP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGroup() <em>Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroup()
	 * @generated
	 * @ordered
	 */
	protected String group = GROUP_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastModified() <em>Last Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastModified()
	 * @generated
	 * @ordered
	 */
	protected static final long LAST_MODIFIED_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getLastModified() <em>Last Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastModified()
	 * @generated
	 * @ordered
	 */
	protected long lastModified = LAST_MODIFIED_EDEFAULT;

	/**
	 * This is true if the Last Modified attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean lastModifiedESet;

	/**
	 * The default value of the '{@link #getOwner() <em>Owner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected static final String OWNER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOwner() <em>Owner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected String owner = OWNER_EDEFAULT;

	/**
	 * The default value of the '{@link #getPermissions() <em>Permissions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPermissions()
	 * @generated
	 * @ordered
	 */
	protected static final String PERMISSIONS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPermissions() <em>Permissions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPermissions()
	 * @generated
	 * @ordered
	 */
	protected String permissions = PERMISSIONS_EDEFAULT;

	/**
	 * The default value of the '{@link #getRealFile() <em>Real File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRealFile()
	 * @generated
	 * @ordered
	 */
	protected static final String REAL_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRealFile() <em>Real File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRealFile()
	 * @generated
	 * @ordered
	 */
	protected String realFile = REAL_FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final long SIZE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected long size = SIZE_EDEFAULT;

	/**
	 * This is true if the Size attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean sizeESet;

	/**
	 * The default value of the '{@link #getURI() <em>URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getURI()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getURI() <em>URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getURI()
	 * @generated
	 * @ordered
	 */
	protected String uRI = URI_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FileSystemContentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return OsPackage.Literals.FILE_SYSTEM_CONTENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFixedPath() {
		return fixedPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFixedPath(String newFixedPath) {
		String oldFixedPath = fixedPath;
		fixedPath = newFixedPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.FILE_SYSTEM_CONTENT__FIXED_PATH, oldFixedPath, fixedPath));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGroup(String newGroup) {
		String oldGroup = group;
		group = newGroup;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.FILE_SYSTEM_CONTENT__GROUP, oldGroup, group));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getLastModified() {
		return lastModified;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLastModified(long newLastModified) {
		long oldLastModified = lastModified;
		lastModified = newLastModified;
		boolean oldLastModifiedESet = lastModifiedESet;
		lastModifiedESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.FILE_SYSTEM_CONTENT__LAST_MODIFIED, oldLastModified, lastModified,
					!oldLastModifiedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLastModified() {
		long oldLastModified = lastModified;
		boolean oldLastModifiedESet = lastModifiedESet;
		lastModified = LAST_MODIFIED_EDEFAULT;
		lastModifiedESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.FILE_SYSTEM_CONTENT__LAST_MODIFIED, oldLastModified,
					LAST_MODIFIED_EDEFAULT, oldLastModifiedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLastModified() {
		return lastModifiedESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(String newOwner) {
		String oldOwner = owner;
		owner = newOwner;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.FILE_SYSTEM_CONTENT__OWNER, oldOwner, owner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPermissions() {
		return permissions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPermissions(String newPermissions) {
		String oldPermissions = permissions;
		permissions = newPermissions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.FILE_SYSTEM_CONTENT__PERMISSIONS, oldPermissions, permissions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRealFile() {
		return realFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRealFile(String newRealFile) {
		String oldRealFile = realFile;
		realFile = newRealFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.FILE_SYSTEM_CONTENT__REAL_FILE, oldRealFile, realFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getSize() {
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSize(long newSize) {
		long oldSize = size;
		size = newSize;
		boolean oldSizeESet = sizeESet;
		sizeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OsPackage.FILE_SYSTEM_CONTENT__SIZE,
					oldSize, size, !oldSizeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSize() {
		long oldSize = size;
		boolean oldSizeESet = sizeESet;
		size = SIZE_EDEFAULT;
		sizeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.FILE_SYSTEM_CONTENT__SIZE, oldSize, SIZE_EDEFAULT, oldSizeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSize() {
		return sizeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getURI() {
		return uRI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setURI(String newURI) {
		String oldURI = uRI;
		uRI = newURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OsPackage.FILE_SYSTEM_CONTENT__URI,
					oldURI, uRI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case OsPackage.FILE_SYSTEM_CONTENT__FIXED_PATH:
			return getFixedPath();
		case OsPackage.FILE_SYSTEM_CONTENT__GROUP:
			return getGroup();
		case OsPackage.FILE_SYSTEM_CONTENT__LAST_MODIFIED:
			return new Long(getLastModified());
		case OsPackage.FILE_SYSTEM_CONTENT__OWNER:
			return getOwner();
		case OsPackage.FILE_SYSTEM_CONTENT__PERMISSIONS:
			return getPermissions();
		case OsPackage.FILE_SYSTEM_CONTENT__REAL_FILE:
			return getRealFile();
		case OsPackage.FILE_SYSTEM_CONTENT__SIZE:
			return new Long(getSize());
		case OsPackage.FILE_SYSTEM_CONTENT__URI:
			return getURI();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
		case OsPackage.FILE_SYSTEM_CONTENT__FIXED_PATH:
			setFixedPath((String) newValue);
			return;
		case OsPackage.FILE_SYSTEM_CONTENT__GROUP:
			setGroup((String) newValue);
			return;
		case OsPackage.FILE_SYSTEM_CONTENT__LAST_MODIFIED:
			setLastModified(((Long) newValue).longValue());
			return;
		case OsPackage.FILE_SYSTEM_CONTENT__OWNER:
			setOwner((String) newValue);
			return;
		case OsPackage.FILE_SYSTEM_CONTENT__PERMISSIONS:
			setPermissions((String) newValue);
			return;
		case OsPackage.FILE_SYSTEM_CONTENT__REAL_FILE:
			setRealFile((String) newValue);
			return;
		case OsPackage.FILE_SYSTEM_CONTENT__SIZE:
			setSize(((Long) newValue).longValue());
			return;
		case OsPackage.FILE_SYSTEM_CONTENT__URI:
			setURI((String) newValue);
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
		switch (featureID)
		{
		case OsPackage.FILE_SYSTEM_CONTENT__FIXED_PATH:
			setFixedPath(FIXED_PATH_EDEFAULT);
			return;
		case OsPackage.FILE_SYSTEM_CONTENT__GROUP:
			setGroup(GROUP_EDEFAULT);
			return;
		case OsPackage.FILE_SYSTEM_CONTENT__LAST_MODIFIED:
			unsetLastModified();
			return;
		case OsPackage.FILE_SYSTEM_CONTENT__OWNER:
			setOwner(OWNER_EDEFAULT);
			return;
		case OsPackage.FILE_SYSTEM_CONTENT__PERMISSIONS:
			setPermissions(PERMISSIONS_EDEFAULT);
			return;
		case OsPackage.FILE_SYSTEM_CONTENT__REAL_FILE:
			setRealFile(REAL_FILE_EDEFAULT);
			return;
		case OsPackage.FILE_SYSTEM_CONTENT__SIZE:
			unsetSize();
			return;
		case OsPackage.FILE_SYSTEM_CONTENT__URI:
			setURI(URI_EDEFAULT);
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
		switch (featureID)
		{
		case OsPackage.FILE_SYSTEM_CONTENT__FIXED_PATH:
			return FIXED_PATH_EDEFAULT == null ? fixedPath != null : !FIXED_PATH_EDEFAULT
					.equals(fixedPath);
		case OsPackage.FILE_SYSTEM_CONTENT__GROUP:
			return GROUP_EDEFAULT == null ? group != null : !GROUP_EDEFAULT.equals(group);
		case OsPackage.FILE_SYSTEM_CONTENT__LAST_MODIFIED:
			return isSetLastModified();
		case OsPackage.FILE_SYSTEM_CONTENT__OWNER:
			return OWNER_EDEFAULT == null ? owner != null : !OWNER_EDEFAULT.equals(owner);
		case OsPackage.FILE_SYSTEM_CONTENT__PERMISSIONS:
			return PERMISSIONS_EDEFAULT == null ? permissions != null : !PERMISSIONS_EDEFAULT
					.equals(permissions);
		case OsPackage.FILE_SYSTEM_CONTENT__REAL_FILE:
			return REAL_FILE_EDEFAULT == null ? realFile != null : !REAL_FILE_EDEFAULT
					.equals(realFile);
		case OsPackage.FILE_SYSTEM_CONTENT__SIZE:
			return isSetSize();
		case OsPackage.FILE_SYSTEM_CONTENT__URI:
			return URI_EDEFAULT == null ? uRI != null : !URI_EDEFAULT.equals(uRI);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (fixedPath: "); //$NON-NLS-1$
		result.append(fixedPath);
		result.append(", group: "); //$NON-NLS-1$
		result.append(group);
		result.append(", lastModified: "); //$NON-NLS-1$
		if (lastModifiedESet)
			result.append(lastModified);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", owner: "); //$NON-NLS-1$
		result.append(owner);
		result.append(", permissions: "); //$NON-NLS-1$
		result.append(permissions);
		result.append(", realFile: "); //$NON-NLS-1$
		result.append(realFile);
		result.append(", size: "); //$NON-NLS-1$
		if (sizeESet)
			result.append(size);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", uRI: "); //$NON-NLS-1$
		result.append(uRI);
		result.append(')');
		return result.toString();
	}

} //FileSystemContentImpl
