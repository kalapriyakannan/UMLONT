/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os.impl;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.os.KernelWidthType;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OsPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Operating System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemImpl#getFqdn <em>Fqdn</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemImpl#getHostname <em>Hostname</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemImpl#getKernelArchitecture <em>Kernel Architecture</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemImpl#getKernelVersion <em>Kernel Version</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemImpl#getKernelWidth <em>Kernel Width</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemImpl#getLocale <em>Locale</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemImpl#getManufacturer <em>Manufacturer</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemImpl#getOsDistribution <em>Os Distribution</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemImpl#getOsServicepack <em>Os Servicepack</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemImpl#getOsType <em>Os Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemImpl#getOsVersion <em>Os Version</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemImpl#getTimeZone <em>Time Zone</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperatingSystemImpl extends CapabilityImpl implements OperatingSystem {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getFqdn() <em>Fqdn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFqdn()
	 * @generated
	 * @ordered
	 */
	protected static final String FQDN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFqdn() <em>Fqdn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFqdn()
	 * @generated
	 * @ordered
	 */
	protected String fqdn = FQDN_EDEFAULT;

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
	 * The default value of the '{@link #getKernelArchitecture() <em>Kernel Architecture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKernelArchitecture()
	 * @generated
	 * @ordered
	 */
	protected static final String KERNEL_ARCHITECTURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKernelArchitecture() <em>Kernel Architecture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKernelArchitecture()
	 * @generated
	 * @ordered
	 */
	protected String kernelArchitecture = KERNEL_ARCHITECTURE_EDEFAULT;

	/**
	 * The default value of the '{@link #getKernelVersion() <em>Kernel Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKernelVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String KERNEL_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKernelVersion() <em>Kernel Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKernelVersion()
	 * @generated
	 * @ordered
	 */
	protected String kernelVersion = KERNEL_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getKernelWidth() <em>Kernel Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKernelWidth()
	 * @generated
	 * @ordered
	 */
	protected static final KernelWidthType KERNEL_WIDTH_EDEFAULT = KernelWidthType._32_BIT_LITERAL;

	/**
	 * The cached value of the '{@link #getKernelWidth() <em>Kernel Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKernelWidth()
	 * @generated
	 * @ordered
	 */
	protected KernelWidthType kernelWidth = KERNEL_WIDTH_EDEFAULT;

	/**
	 * This is true if the Kernel Width attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean kernelWidthESet;

	/**
	 * The default value of the '{@link #getLocale() <em>Locale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocale()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCALE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocale() <em>Locale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocale()
	 * @generated
	 * @ordered
	 */
	protected String locale = LOCALE_EDEFAULT;

	/**
	 * The default value of the '{@link #getManufacturer() <em>Manufacturer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManufacturer()
	 * @generated
	 * @ordered
	 */
	protected static final String MANUFACTURER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getManufacturer() <em>Manufacturer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManufacturer()
	 * @generated
	 * @ordered
	 */
	protected String manufacturer = MANUFACTURER_EDEFAULT;

	/**
	 * The default value of the '{@link #getOsDistribution() <em>Os Distribution</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getOsDistribution()
	 * @generated
	 * @ordered
	 */
	protected static final String OS_DISTRIBUTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOsDistribution() <em>Os Distribution</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getOsDistribution()
	 * @generated
	 * @ordered
	 */
	protected String osDistribution = OS_DISTRIBUTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getOsServicepack() <em>Os Servicepack</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getOsServicepack()
	 * @generated
	 * @ordered
	 */
	protected static final String OS_SERVICEPACK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOsServicepack() <em>Os Servicepack</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getOsServicepack()
	 * @generated
	 * @ordered
	 */
	protected String osServicepack = OS_SERVICEPACK_EDEFAULT;

	/**
	 * The default value of the '{@link #getOsType() <em>Os Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOsType()
	 * @generated
	 * @ordered
	 */
	protected static final String OS_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOsType() <em>Os Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOsType()
	 * @generated
	 * @ordered
	 */
	protected String osType = OS_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getOsVersion() <em>Os Version</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOsVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String OS_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOsVersion() <em>Os Version</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getOsVersion()
	 * @generated
	 * @ordered
	 */
	protected String osVersion = OS_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimeZone() <em>Time Zone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeZone()
	 * @generated
	 * @ordered
	 */
	protected static final String TIME_ZONE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTimeZone() <em>Time Zone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeZone()
	 * @generated
	 * @ordered
	 */
	protected String timeZone = TIME_ZONE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected OperatingSystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return OsPackage.Literals.OPERATING_SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFqdn() {
		return fqdn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFqdn(String newFqdn) {
		String oldFqdn = fqdn;
		fqdn = newFqdn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OsPackage.OPERATING_SYSTEM__FQDN,
					oldFqdn, fqdn));
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
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.OPERATING_SYSTEM__HOSTNAME, oldHostname, hostname));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKernelArchitecture() {
		return kernelArchitecture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKernelArchitecture(String newKernelArchitecture) {
		String oldKernelArchitecture = kernelArchitecture;
		kernelArchitecture = newKernelArchitecture;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.OPERATING_SYSTEM__KERNEL_ARCHITECTURE, oldKernelArchitecture,
					kernelArchitecture));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKernelVersion() {
		return kernelVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKernelVersion(String newKernelVersion) {
		String oldKernelVersion = kernelVersion;
		kernelVersion = newKernelVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.OPERATING_SYSTEM__KERNEL_VERSION, oldKernelVersion, kernelVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KernelWidthType getKernelWidth() {
		return kernelWidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKernelWidth(KernelWidthType newKernelWidth) {
		KernelWidthType oldKernelWidth = kernelWidth;
		kernelWidth = newKernelWidth == null ? KERNEL_WIDTH_EDEFAULT : newKernelWidth;
		boolean oldKernelWidthESet = kernelWidthESet;
		kernelWidthESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.OPERATING_SYSTEM__KERNEL_WIDTH, oldKernelWidth, kernelWidth,
					!oldKernelWidthESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetKernelWidth() {
		KernelWidthType oldKernelWidth = kernelWidth;
		boolean oldKernelWidthESet = kernelWidthESet;
		kernelWidth = KERNEL_WIDTH_EDEFAULT;
		kernelWidthESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					OsPackage.OPERATING_SYSTEM__KERNEL_WIDTH, oldKernelWidth, KERNEL_WIDTH_EDEFAULT,
					oldKernelWidthESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetKernelWidth() {
		return kernelWidthESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocale(String newLocale) {
		String oldLocale = locale;
		locale = newLocale;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OsPackage.OPERATING_SYSTEM__LOCALE,
					oldLocale, locale));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setManufacturer(String newManufacturer) {
		String oldManufacturer = manufacturer;
		manufacturer = newManufacturer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.OPERATING_SYSTEM__MANUFACTURER, oldManufacturer, manufacturer));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getOsDistribution() {
		return osDistribution;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setOsDistribution(String newOsDistribution) {
		String oldOsDistribution = osDistribution;
		osDistribution = newOsDistribution;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.OPERATING_SYSTEM__OS_DISTRIBUTION, oldOsDistribution, osDistribution));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getOsServicepack() {
		return osServicepack;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setOsServicepack(String newOsServicepack) {
		String oldOsServicepack = osServicepack;
		osServicepack = newOsServicepack;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.OPERATING_SYSTEM__OS_SERVICEPACK, oldOsServicepack, osServicepack));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getOsType() {
		return osType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setOsType(String newOsType) {
		String oldOsType = osType;
		osType = newOsType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OsPackage.OPERATING_SYSTEM__OS_TYPE,
					oldOsType, osType));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getOsVersion() {
		return osVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setOsVersion(String newOsVersion) {
		String oldOsVersion = osVersion;
		osVersion = newOsVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.OPERATING_SYSTEM__OS_VERSION, oldOsVersion, osVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTimeZone() {
		return timeZone;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeZone(String newTimeZone) {
		String oldTimeZone = timeZone;
		timeZone = newTimeZone;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					OsPackage.OPERATING_SYSTEM__TIME_ZONE, oldTimeZone, timeZone));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case OsPackage.OPERATING_SYSTEM__FQDN:
			return getFqdn();
		case OsPackage.OPERATING_SYSTEM__HOSTNAME:
			return getHostname();
		case OsPackage.OPERATING_SYSTEM__KERNEL_ARCHITECTURE:
			return getKernelArchitecture();
		case OsPackage.OPERATING_SYSTEM__KERNEL_VERSION:
			return getKernelVersion();
		case OsPackage.OPERATING_SYSTEM__KERNEL_WIDTH:
			return getKernelWidth();
		case OsPackage.OPERATING_SYSTEM__LOCALE:
			return getLocale();
		case OsPackage.OPERATING_SYSTEM__MANUFACTURER:
			return getManufacturer();
		case OsPackage.OPERATING_SYSTEM__OS_DISTRIBUTION:
			return getOsDistribution();
		case OsPackage.OPERATING_SYSTEM__OS_SERVICEPACK:
			return getOsServicepack();
		case OsPackage.OPERATING_SYSTEM__OS_TYPE:
			return getOsType();
		case OsPackage.OPERATING_SYSTEM__OS_VERSION:
			return getOsVersion();
		case OsPackage.OPERATING_SYSTEM__TIME_ZONE:
			return getTimeZone();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
		case OsPackage.OPERATING_SYSTEM__FQDN:
			setFqdn((String) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM__HOSTNAME:
			setHostname((String) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM__KERNEL_ARCHITECTURE:
			setKernelArchitecture((String) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM__KERNEL_VERSION:
			setKernelVersion((String) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM__KERNEL_WIDTH:
			setKernelWidth((KernelWidthType) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM__LOCALE:
			setLocale((String) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM__MANUFACTURER:
			setManufacturer((String) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM__OS_DISTRIBUTION:
			setOsDistribution((String) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM__OS_SERVICEPACK:
			setOsServicepack((String) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM__OS_TYPE:
			setOsType((String) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM__OS_VERSION:
			setOsVersion((String) newValue);
			return;
		case OsPackage.OPERATING_SYSTEM__TIME_ZONE:
			setTimeZone((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID)
		{
		case OsPackage.OPERATING_SYSTEM__FQDN:
			setFqdn(FQDN_EDEFAULT);
			return;
		case OsPackage.OPERATING_SYSTEM__HOSTNAME:
			setHostname(HOSTNAME_EDEFAULT);
			return;
		case OsPackage.OPERATING_SYSTEM__KERNEL_ARCHITECTURE:
			setKernelArchitecture(KERNEL_ARCHITECTURE_EDEFAULT);
			return;
		case OsPackage.OPERATING_SYSTEM__KERNEL_VERSION:
			setKernelVersion(KERNEL_VERSION_EDEFAULT);
			return;
		case OsPackage.OPERATING_SYSTEM__KERNEL_WIDTH:
			unsetKernelWidth();
			return;
		case OsPackage.OPERATING_SYSTEM__LOCALE:
			setLocale(LOCALE_EDEFAULT);
			return;
		case OsPackage.OPERATING_SYSTEM__MANUFACTURER:
			setManufacturer(MANUFACTURER_EDEFAULT);
			return;
		case OsPackage.OPERATING_SYSTEM__OS_DISTRIBUTION:
			setOsDistribution(OS_DISTRIBUTION_EDEFAULT);
			return;
		case OsPackage.OPERATING_SYSTEM__OS_SERVICEPACK:
			setOsServicepack(OS_SERVICEPACK_EDEFAULT);
			return;
		case OsPackage.OPERATING_SYSTEM__OS_TYPE:
			setOsType(OS_TYPE_EDEFAULT);
			return;
		case OsPackage.OPERATING_SYSTEM__OS_VERSION:
			setOsVersion(OS_VERSION_EDEFAULT);
			return;
		case OsPackage.OPERATING_SYSTEM__TIME_ZONE:
			setTimeZone(TIME_ZONE_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
		case OsPackage.OPERATING_SYSTEM__FQDN:
			return FQDN_EDEFAULT == null ? fqdn != null : !FQDN_EDEFAULT.equals(fqdn);
		case OsPackage.OPERATING_SYSTEM__HOSTNAME:
			return HOSTNAME_EDEFAULT == null ? hostname != null : !HOSTNAME_EDEFAULT.equals(hostname);
		case OsPackage.OPERATING_SYSTEM__KERNEL_ARCHITECTURE:
			return KERNEL_ARCHITECTURE_EDEFAULT == null ? kernelArchitecture != null
					: !KERNEL_ARCHITECTURE_EDEFAULT.equals(kernelArchitecture);
		case OsPackage.OPERATING_SYSTEM__KERNEL_VERSION:
			return KERNEL_VERSION_EDEFAULT == null ? kernelVersion != null : !KERNEL_VERSION_EDEFAULT
					.equals(kernelVersion);
		case OsPackage.OPERATING_SYSTEM__KERNEL_WIDTH:
			return isSetKernelWidth();
		case OsPackage.OPERATING_SYSTEM__LOCALE:
			return LOCALE_EDEFAULT == null ? locale != null : !LOCALE_EDEFAULT.equals(locale);
		case OsPackage.OPERATING_SYSTEM__MANUFACTURER:
			return MANUFACTURER_EDEFAULT == null ? manufacturer != null : !MANUFACTURER_EDEFAULT
					.equals(manufacturer);
		case OsPackage.OPERATING_SYSTEM__OS_DISTRIBUTION:
			return OS_DISTRIBUTION_EDEFAULT == null ? osDistribution != null
					: !OS_DISTRIBUTION_EDEFAULT.equals(osDistribution);
		case OsPackage.OPERATING_SYSTEM__OS_SERVICEPACK:
			return OS_SERVICEPACK_EDEFAULT == null ? osServicepack != null : !OS_SERVICEPACK_EDEFAULT
					.equals(osServicepack);
		case OsPackage.OPERATING_SYSTEM__OS_TYPE:
			return OS_TYPE_EDEFAULT == null ? osType != null : !OS_TYPE_EDEFAULT.equals(osType);
		case OsPackage.OPERATING_SYSTEM__OS_VERSION:
			return OS_VERSION_EDEFAULT == null ? osVersion != null : !OS_VERSION_EDEFAULT
					.equals(osVersion);
		case OsPackage.OPERATING_SYSTEM__TIME_ZONE:
			return TIME_ZONE_EDEFAULT == null ? timeZone != null : !TIME_ZONE_EDEFAULT
					.equals(timeZone);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (fqdn: "); //$NON-NLS-1$
		result.append(fqdn);
		result.append(", hostname: "); //$NON-NLS-1$
		result.append(hostname);
		result.append(", kernelArchitecture: "); //$NON-NLS-1$
		result.append(kernelArchitecture);
		result.append(", kernelVersion: "); //$NON-NLS-1$
		result.append(kernelVersion);
		result.append(", kernelWidth: "); //$NON-NLS-1$
		if (kernelWidthESet)
			result.append(kernelWidth);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", locale: "); //$NON-NLS-1$
		result.append(locale);
		result.append(", manufacturer: "); //$NON-NLS-1$
		result.append(manufacturer);
		result.append(", osDistribution: "); //$NON-NLS-1$
		result.append(osDistribution);
		result.append(", osServicepack: "); //$NON-NLS-1$
		result.append(osServicepack);
		result.append(", osType: "); //$NON-NLS-1$
		result.append(osType);
		result.append(", osVersion: "); //$NON-NLS-1$
		result.append(osVersion);
		result.append(", timeZone: "); //$NON-NLS-1$
		result.append(timeZone);
		result.append(')');
		return result.toString();
	}

	private final static List keys = Collections.singletonList(OsPackage.eINSTANCE
			.getOperatingSystem_Hostname());

	/* @generated NOT */
	public List titleKeys() {
		return keys;
	}

} //OperatingSystemImpl
