/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.osgi.impl;

import com.ibm.ccl.soa.deploy.core.impl.SoftwareComponentImpl;

import com.ibm.ccl.soa.deploy.osgi.BundleComponent;
import com.ibm.ccl.soa.deploy.osgi.OsgiPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bundle Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.osgi.impl.BundleComponentImpl#getActivator <em>Activator</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.osgi.impl.BundleComponentImpl#isEclipseLazyStart <em>Eclipse Lazy Start</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.osgi.impl.BundleComponentImpl#getLocalization <em>Localization</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.osgi.impl.BundleComponentImpl#getManifestVersion <em>Manifest Version</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.osgi.impl.BundleComponentImpl#isSingleton <em>Singleton</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.osgi.impl.BundleComponentImpl#getVendor <em>Vendor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BundleComponentImpl extends SoftwareComponentImpl implements BundleComponent {
	/**
	 * The default value of the '{@link #getActivator() <em>Activator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivator()
	 * @generated
	 * @ordered
	 */
	protected static final String ACTIVATOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getActivator() <em>Activator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivator()
	 * @generated
	 * @ordered
	 */
	protected String activator = ACTIVATOR_EDEFAULT;

	/**
	 * The default value of the '{@link #isEclipseLazyStart() <em>Eclipse Lazy Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEclipseLazyStart()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ECLIPSE_LAZY_START_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEclipseLazyStart() <em>Eclipse Lazy Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEclipseLazyStart()
	 * @generated
	 * @ordered
	 */
	protected boolean eclipseLazyStart = ECLIPSE_LAZY_START_EDEFAULT;

	/**
	 * This is true if the Eclipse Lazy Start attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean eclipseLazyStartESet;

	/**
	 * The default value of the '{@link #getLocalization() <em>Localization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalization()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCALIZATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocalization() <em>Localization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalization()
	 * @generated
	 * @ordered
	 */
	protected String localization = LOCALIZATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getManifestVersion() <em>Manifest Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManifestVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String MANIFEST_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getManifestVersion() <em>Manifest Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManifestVersion()
	 * @generated
	 * @ordered
	 */
	protected String manifestVersion = MANIFEST_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #isSingleton() <em>Singleton</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSingleton()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SINGLETON_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSingleton() <em>Singleton</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSingleton()
	 * @generated
	 * @ordered
	 */
	protected boolean singleton = SINGLETON_EDEFAULT;

	/**
	 * This is true if the Singleton attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean singletonESet;

	/**
	 * The default value of the '{@link #getVendor() <em>Vendor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVendor()
	 * @generated
	 * @ordered
	 */
	protected static final String VENDOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVendor() <em>Vendor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVendor()
	 * @generated
	 * @ordered
	 */
	protected String vendor = VENDOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BundleComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return OsgiPackage.Literals.BUNDLE_COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getActivator() {
		return activator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActivator(String newActivator) {
		String oldActivator = activator;
		activator = newActivator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OsgiPackage.BUNDLE_COMPONENT__ACTIVATOR, oldActivator, activator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEclipseLazyStart() {
		return eclipseLazyStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEclipseLazyStart(boolean newEclipseLazyStart) {
		boolean oldEclipseLazyStart = eclipseLazyStart;
		eclipseLazyStart = newEclipseLazyStart;
		boolean oldEclipseLazyStartESet = eclipseLazyStartESet;
		eclipseLazyStartESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OsgiPackage.BUNDLE_COMPONENT__ECLIPSE_LAZY_START, oldEclipseLazyStart, eclipseLazyStart, !oldEclipseLazyStartESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEclipseLazyStart() {
		boolean oldEclipseLazyStart = eclipseLazyStart;
		boolean oldEclipseLazyStartESet = eclipseLazyStartESet;
		eclipseLazyStart = ECLIPSE_LAZY_START_EDEFAULT;
		eclipseLazyStartESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, OsgiPackage.BUNDLE_COMPONENT__ECLIPSE_LAZY_START, oldEclipseLazyStart, ECLIPSE_LAZY_START_EDEFAULT, oldEclipseLazyStartESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEclipseLazyStart() {
		return eclipseLazyStartESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLocalization() {
		return localization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocalization(String newLocalization) {
		String oldLocalization = localization;
		localization = newLocalization;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OsgiPackage.BUNDLE_COMPONENT__LOCALIZATION, oldLocalization, localization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getManifestVersion() {
		return manifestVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setManifestVersion(String newManifestVersion) {
		String oldManifestVersion = manifestVersion;
		manifestVersion = newManifestVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OsgiPackage.BUNDLE_COMPONENT__MANIFEST_VERSION, oldManifestVersion, manifestVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSingleton() {
		return singleton;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSingleton(boolean newSingleton) {
		boolean oldSingleton = singleton;
		singleton = newSingleton;
		boolean oldSingletonESet = singletonESet;
		singletonESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OsgiPackage.BUNDLE_COMPONENT__SINGLETON, oldSingleton, singleton, !oldSingletonESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSingleton() {
		boolean oldSingleton = singleton;
		boolean oldSingletonESet = singletonESet;
		singleton = SINGLETON_EDEFAULT;
		singletonESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, OsgiPackage.BUNDLE_COMPONENT__SINGLETON, oldSingleton, SINGLETON_EDEFAULT, oldSingletonESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSingleton() {
		return singletonESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVendor() {
		return vendor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVendor(String newVendor) {
		String oldVendor = vendor;
		vendor = newVendor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OsgiPackage.BUNDLE_COMPONENT__VENDOR, oldVendor, vendor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OsgiPackage.BUNDLE_COMPONENT__ACTIVATOR:
				return getActivator();
			case OsgiPackage.BUNDLE_COMPONENT__ECLIPSE_LAZY_START:
				return isEclipseLazyStart() ? Boolean.TRUE : Boolean.FALSE;
			case OsgiPackage.BUNDLE_COMPONENT__LOCALIZATION:
				return getLocalization();
			case OsgiPackage.BUNDLE_COMPONENT__MANIFEST_VERSION:
				return getManifestVersion();
			case OsgiPackage.BUNDLE_COMPONENT__SINGLETON:
				return isSingleton() ? Boolean.TRUE : Boolean.FALSE;
			case OsgiPackage.BUNDLE_COMPONENT__VENDOR:
				return getVendor();
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
			case OsgiPackage.BUNDLE_COMPONENT__ACTIVATOR:
				setActivator((String)newValue);
				return;
			case OsgiPackage.BUNDLE_COMPONENT__ECLIPSE_LAZY_START:
				setEclipseLazyStart(((Boolean)newValue).booleanValue());
				return;
			case OsgiPackage.BUNDLE_COMPONENT__LOCALIZATION:
				setLocalization((String)newValue);
				return;
			case OsgiPackage.BUNDLE_COMPONENT__MANIFEST_VERSION:
				setManifestVersion((String)newValue);
				return;
			case OsgiPackage.BUNDLE_COMPONENT__SINGLETON:
				setSingleton(((Boolean)newValue).booleanValue());
				return;
			case OsgiPackage.BUNDLE_COMPONENT__VENDOR:
				setVendor((String)newValue);
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
			case OsgiPackage.BUNDLE_COMPONENT__ACTIVATOR:
				setActivator(ACTIVATOR_EDEFAULT);
				return;
			case OsgiPackage.BUNDLE_COMPONENT__ECLIPSE_LAZY_START:
				unsetEclipseLazyStart();
				return;
			case OsgiPackage.BUNDLE_COMPONENT__LOCALIZATION:
				setLocalization(LOCALIZATION_EDEFAULT);
				return;
			case OsgiPackage.BUNDLE_COMPONENT__MANIFEST_VERSION:
				setManifestVersion(MANIFEST_VERSION_EDEFAULT);
				return;
			case OsgiPackage.BUNDLE_COMPONENT__SINGLETON:
				unsetSingleton();
				return;
			case OsgiPackage.BUNDLE_COMPONENT__VENDOR:
				setVendor(VENDOR_EDEFAULT);
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
			case OsgiPackage.BUNDLE_COMPONENT__ACTIVATOR:
				return ACTIVATOR_EDEFAULT == null ? activator != null : !ACTIVATOR_EDEFAULT.equals(activator);
			case OsgiPackage.BUNDLE_COMPONENT__ECLIPSE_LAZY_START:
				return isSetEclipseLazyStart();
			case OsgiPackage.BUNDLE_COMPONENT__LOCALIZATION:
				return LOCALIZATION_EDEFAULT == null ? localization != null : !LOCALIZATION_EDEFAULT.equals(localization);
			case OsgiPackage.BUNDLE_COMPONENT__MANIFEST_VERSION:
				return MANIFEST_VERSION_EDEFAULT == null ? manifestVersion != null : !MANIFEST_VERSION_EDEFAULT.equals(manifestVersion);
			case OsgiPackage.BUNDLE_COMPONENT__SINGLETON:
				return isSetSingleton();
			case OsgiPackage.BUNDLE_COMPONENT__VENDOR:
				return VENDOR_EDEFAULT == null ? vendor != null : !VENDOR_EDEFAULT.equals(vendor);
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
		result.append(" (activator: "); //$NON-NLS-1$
		result.append(activator);
		result.append(", eclipseLazyStart: "); //$NON-NLS-1$
		if (eclipseLazyStartESet) result.append(eclipseLazyStart); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", localization: "); //$NON-NLS-1$
		result.append(localization);
		result.append(", manifestVersion: "); //$NON-NLS-1$
		result.append(manifestVersion);
		result.append(", singleton: "); //$NON-NLS-1$
		if (singletonESet) result.append(singleton); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", vendor: "); //$NON-NLS-1$
		result.append(vendor);
		result.append(')');
		return result.toString();
	}

} //BundleComponentImpl
