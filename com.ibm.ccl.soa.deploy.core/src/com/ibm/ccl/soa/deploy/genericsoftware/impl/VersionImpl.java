/**
 * <copyright>
 * </copyright>
 *
 * $Id: VersionImpl.java,v 1.2 2008/02/05 22:20:17 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.genericsoftware.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage;
import com.ibm.ccl.soa.deploy.genericsoftware.Version;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Version</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.impl.VersionImpl#getBuildLevel <em>Build Level</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.impl.VersionImpl#getLevel <em>Level</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.impl.VersionImpl#getMajorVersion <em>Major Version</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.impl.VersionImpl#getModifier <em>Modifier</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.impl.VersionImpl#getRelease <em>Release</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.impl.VersionImpl#getVersionString <em>Version String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VersionImpl extends CapabilityImpl implements Version {
	/**
	 * The default value of the '{@link #getBuildLevel() <em>Build Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuildLevel()
	 * @generated
	 * @ordered
	 */
	protected static final String BUILD_LEVEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBuildLevel() <em>Build Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuildLevel()
	 * @generated
	 * @ordered
	 */
	protected String buildLevel = BUILD_LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
	protected static final int LEVEL_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
	protected int level = LEVEL_EDEFAULT;

	/**
	 * This is true if the Level attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean levelESet;

	/**
	 * The default value of the '{@link #getMajorVersion() <em>Major Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMajorVersion()
	 * @generated
	 * @ordered
	 */
	protected static final int MAJOR_VERSION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMajorVersion() <em>Major Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMajorVersion()
	 * @generated
	 * @ordered
	 */
	protected int majorVersion = MAJOR_VERSION_EDEFAULT;

	/**
	 * This is true if the Major Version attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean majorVersionESet;

	/**
	 * The default value of the '{@link #getModifier() <em>Modifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifier()
	 * @generated
	 * @ordered
	 */
	protected static final int MODIFIER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getModifier() <em>Modifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModifier()
	 * @generated
	 * @ordered
	 */
	protected int modifier = MODIFIER_EDEFAULT;

	/**
	 * This is true if the Modifier attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean modifierESet;

	/**
	 * The default value of the '{@link #getRelease() <em>Release</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelease()
	 * @generated
	 * @ordered
	 */
	protected static final int RELEASE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRelease() <em>Release</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelease()
	 * @generated
	 * @ordered
	 */
	protected int release = RELEASE_EDEFAULT;

	/**
	 * This is true if the Release attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean releaseESet;

	/**
	 * The default value of the '{@link #getVersionString() <em>Version String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersionString()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_STRING_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersionString() <em>Version String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersionString()
	 * @generated
	 * @ordered
	 */
	protected String versionString = VERSION_STRING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VersionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return GenericsoftwarePackage.Literals.VERSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBuildLevel() {
		return buildLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBuildLevel(String newBuildLevel) {
		String oldBuildLevel = buildLevel;
		buildLevel = newBuildLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenericsoftwarePackage.VERSION__BUILD_LEVEL, oldBuildLevel, buildLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLevel(int newLevel) {
		int oldLevel = level;
		level = newLevel;
		boolean oldLevelESet = levelESet;
		levelESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenericsoftwarePackage.VERSION__LEVEL, oldLevel, level, !oldLevelESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLevel() {
		int oldLevel = level;
		boolean oldLevelESet = levelESet;
		level = LEVEL_EDEFAULT;
		levelESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, GenericsoftwarePackage.VERSION__LEVEL, oldLevel, LEVEL_EDEFAULT, oldLevelESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLevel() {
		return levelESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMajorVersion() {
		return majorVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMajorVersion(int newMajorVersion) {
		int oldMajorVersion = majorVersion;
		majorVersion = newMajorVersion;
		boolean oldMajorVersionESet = majorVersionESet;
		majorVersionESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenericsoftwarePackage.VERSION__MAJOR_VERSION, oldMajorVersion, majorVersion, !oldMajorVersionESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMajorVersion() {
		int oldMajorVersion = majorVersion;
		boolean oldMajorVersionESet = majorVersionESet;
		majorVersion = MAJOR_VERSION_EDEFAULT;
		majorVersionESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, GenericsoftwarePackage.VERSION__MAJOR_VERSION, oldMajorVersion, MAJOR_VERSION_EDEFAULT, oldMajorVersionESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMajorVersion() {
		return majorVersionESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getModifier() {
		return modifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModifier(int newModifier) {
		int oldModifier = modifier;
		modifier = newModifier;
		boolean oldModifierESet = modifierESet;
		modifierESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenericsoftwarePackage.VERSION__MODIFIER, oldModifier, modifier, !oldModifierESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetModifier() {
		int oldModifier = modifier;
		boolean oldModifierESet = modifierESet;
		modifier = MODIFIER_EDEFAULT;
		modifierESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, GenericsoftwarePackage.VERSION__MODIFIER, oldModifier, MODIFIER_EDEFAULT, oldModifierESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetModifier() {
		return modifierESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRelease() {
		return release;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelease(int newRelease) {
		int oldRelease = release;
		release = newRelease;
		boolean oldReleaseESet = releaseESet;
		releaseESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenericsoftwarePackage.VERSION__RELEASE, oldRelease, release, !oldReleaseESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetRelease() {
		int oldRelease = release;
		boolean oldReleaseESet = releaseESet;
		release = RELEASE_EDEFAULT;
		releaseESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, GenericsoftwarePackage.VERSION__RELEASE, oldRelease, RELEASE_EDEFAULT, oldReleaseESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetRelease() {
		return releaseESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersionString() {
		return versionString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersionString(String newVersionString) {
		String oldVersionString = versionString;
		versionString = newVersionString;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenericsoftwarePackage.VERSION__VERSION_STRING, oldVersionString, versionString));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GenericsoftwarePackage.VERSION__BUILD_LEVEL:
				return getBuildLevel();
			case GenericsoftwarePackage.VERSION__LEVEL:
				return new Integer(getLevel());
			case GenericsoftwarePackage.VERSION__MAJOR_VERSION:
				return new Integer(getMajorVersion());
			case GenericsoftwarePackage.VERSION__MODIFIER:
				return new Integer(getModifier());
			case GenericsoftwarePackage.VERSION__RELEASE:
				return new Integer(getRelease());
			case GenericsoftwarePackage.VERSION__VERSION_STRING:
				return getVersionString();
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
			case GenericsoftwarePackage.VERSION__BUILD_LEVEL:
				setBuildLevel((String)newValue);
				return;
			case GenericsoftwarePackage.VERSION__LEVEL:
				setLevel(((Integer)newValue).intValue());
				return;
			case GenericsoftwarePackage.VERSION__MAJOR_VERSION:
				setMajorVersion(((Integer)newValue).intValue());
				return;
			case GenericsoftwarePackage.VERSION__MODIFIER:
				setModifier(((Integer)newValue).intValue());
				return;
			case GenericsoftwarePackage.VERSION__RELEASE:
				setRelease(((Integer)newValue).intValue());
				return;
			case GenericsoftwarePackage.VERSION__VERSION_STRING:
				setVersionString((String)newValue);
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
			case GenericsoftwarePackage.VERSION__BUILD_LEVEL:
				setBuildLevel(BUILD_LEVEL_EDEFAULT);
				return;
			case GenericsoftwarePackage.VERSION__LEVEL:
				unsetLevel();
				return;
			case GenericsoftwarePackage.VERSION__MAJOR_VERSION:
				unsetMajorVersion();
				return;
			case GenericsoftwarePackage.VERSION__MODIFIER:
				unsetModifier();
				return;
			case GenericsoftwarePackage.VERSION__RELEASE:
				unsetRelease();
				return;
			case GenericsoftwarePackage.VERSION__VERSION_STRING:
				setVersionString(VERSION_STRING_EDEFAULT);
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
			case GenericsoftwarePackage.VERSION__BUILD_LEVEL:
				return BUILD_LEVEL_EDEFAULT == null ? buildLevel != null : !BUILD_LEVEL_EDEFAULT.equals(buildLevel);
			case GenericsoftwarePackage.VERSION__LEVEL:
				return isSetLevel();
			case GenericsoftwarePackage.VERSION__MAJOR_VERSION:
				return isSetMajorVersion();
			case GenericsoftwarePackage.VERSION__MODIFIER:
				return isSetModifier();
			case GenericsoftwarePackage.VERSION__RELEASE:
				return isSetRelease();
			case GenericsoftwarePackage.VERSION__VERSION_STRING:
				return VERSION_STRING_EDEFAULT == null ? versionString != null : !VERSION_STRING_EDEFAULT.equals(versionString);
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
		result.append(" (buildLevel: "); //$NON-NLS-1$
		result.append(buildLevel);
		result.append(", level: "); //$NON-NLS-1$
		if (levelESet) result.append(level); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", majorVersion: "); //$NON-NLS-1$
		if (majorVersionESet) result.append(majorVersion); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", modifier: "); //$NON-NLS-1$
		if (modifierESet) result.append(modifier); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", release: "); //$NON-NLS-1$
		if (releaseESet) result.append(release); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", versionString: "); //$NON-NLS-1$
		result.append(versionString);
		result.append(')');
		return result.toString();
	}

} //VersionImpl
