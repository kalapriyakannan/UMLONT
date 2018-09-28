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
import com.ibm.ccl.soa.deploy.was.WasWebAppExt;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Web App Ext</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasWebAppExtImpl#getAdditionalClassPath <em>Additional Class Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasWebAppExtImpl#isAutoLoadFilters <em>Auto Load Filters</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasWebAppExtImpl#isAutoRequestEncoding <em>Auto Request Encoding</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasWebAppExtImpl#isAutoResponseEncoding <em>Auto Response Encoding</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasWebAppExtImpl#getDefaultErrorPage <em>Default Error Page</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasWebAppExtImpl#isDirectoryBrowsingEnabled <em>Directory Browsing Enabled</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasWebAppExtImpl#isFileServingEnabled <em>File Serving Enabled</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasWebAppExtImpl#isPreCompileJSPs <em>Pre Compile JS Ps</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasWebAppExtImpl#isReloadingEnabled <em>Reloading Enabled</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasWebAppExtImpl#getReloadInterval <em>Reload Interval</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.impl.WasWebAppExtImpl#isServeServletsByClassnameEnabled <em>Serve Servlets By Classname Enabled</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WasWebAppExtImpl extends CapabilityImpl implements WasWebAppExt {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getAdditionalClassPath() <em>Additional Class Path</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAdditionalClassPath()
	 * @generated
	 * @ordered
	 */
	protected static final String ADDITIONAL_CLASS_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAdditionalClassPath() <em>Additional Class Path</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAdditionalClassPath()
	 * @generated
	 * @ordered
	 */
	protected String additionalClassPath = ADDITIONAL_CLASS_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #isAutoLoadFilters() <em>Auto Load Filters</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isAutoLoadFilters()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AUTO_LOAD_FILTERS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAutoLoadFilters() <em>Auto Load Filters</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isAutoLoadFilters()
	 * @generated
	 * @ordered
	 */
	protected boolean autoLoadFilters = AUTO_LOAD_FILTERS_EDEFAULT;

	/**
	 * This is true if the Auto Load Filters attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean autoLoadFiltersESet;

	/**
	 * The default value of the '{@link #isAutoRequestEncoding() <em>Auto Request Encoding</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isAutoRequestEncoding()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AUTO_REQUEST_ENCODING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAutoRequestEncoding() <em>Auto Request Encoding</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isAutoRequestEncoding()
	 * @generated
	 * @ordered
	 */
	protected boolean autoRequestEncoding = AUTO_REQUEST_ENCODING_EDEFAULT;

	/**
	 * This is true if the Auto Request Encoding attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean autoRequestEncodingESet;

	/**
	 * The default value of the '{@link #isAutoResponseEncoding() <em>Auto Response Encoding</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isAutoResponseEncoding()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AUTO_RESPONSE_ENCODING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAutoResponseEncoding() <em>Auto Response Encoding</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isAutoResponseEncoding()
	 * @generated
	 * @ordered
	 */
	protected boolean autoResponseEncoding = AUTO_RESPONSE_ENCODING_EDEFAULT;

	/**
	 * This is true if the Auto Response Encoding attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean autoResponseEncodingESet;

	/**
	 * The default value of the '{@link #getDefaultErrorPage() <em>Default Error Page</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDefaultErrorPage()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_ERROR_PAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultErrorPage() <em>Default Error Page</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDefaultErrorPage()
	 * @generated
	 * @ordered
	 */
	protected String defaultErrorPage = DEFAULT_ERROR_PAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #isDirectoryBrowsingEnabled() <em>Directory Browsing Enabled</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isDirectoryBrowsingEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DIRECTORY_BROWSING_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDirectoryBrowsingEnabled() <em>Directory Browsing Enabled</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isDirectoryBrowsingEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean directoryBrowsingEnabled = DIRECTORY_BROWSING_ENABLED_EDEFAULT;

	/**
	 * This is true if the Directory Browsing Enabled attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean directoryBrowsingEnabledESet;

	/**
	 * The default value of the '{@link #isFileServingEnabled() <em>File Serving Enabled</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isFileServingEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FILE_SERVING_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFileServingEnabled() <em>File Serving Enabled</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isFileServingEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean fileServingEnabled = FILE_SERVING_ENABLED_EDEFAULT;

	/**
	 * This is true if the File Serving Enabled attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean fileServingEnabledESet;

	/**
	 * The default value of the '{@link #isPreCompileJSPs() <em>Pre Compile JS Ps</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isPreCompileJSPs()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PRE_COMPILE_JS_PS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPreCompileJSPs() <em>Pre Compile JS Ps</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isPreCompileJSPs()
	 * @generated
	 * @ordered
	 */
	protected boolean preCompileJSPs = PRE_COMPILE_JS_PS_EDEFAULT;

	/**
	 * This is true if the Pre Compile JS Ps attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean preCompileJSPsESet;

	/**
	 * The default value of the '{@link #isReloadingEnabled() <em>Reloading Enabled</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isReloadingEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RELOADING_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReloadingEnabled() <em>Reloading Enabled</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isReloadingEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean reloadingEnabled = RELOADING_ENABLED_EDEFAULT;

	/**
	 * This is true if the Reloading Enabled attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean reloadingEnabledESet;

	/**
	 * The default value of the '{@link #getReloadInterval() <em>Reload Interval</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getReloadInterval()
	 * @generated
	 * @ordered
	 */
	protected static final int RELOAD_INTERVAL_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getReloadInterval() <em>Reload Interval</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getReloadInterval()
	 * @generated
	 * @ordered
	 */
	protected int reloadInterval = RELOAD_INTERVAL_EDEFAULT;

	/**
	 * This is true if the Reload Interval attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean reloadIntervalESet;

	/**
	 * The default value of the '{@link #isServeServletsByClassnameEnabled() <em>Serve Servlets By Classname Enabled</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isServeServletsByClassnameEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SERVE_SERVLETS_BY_CLASSNAME_ENABLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isServeServletsByClassnameEnabled() <em>Serve Servlets By Classname Enabled</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isServeServletsByClassnameEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean serveServletsByClassnameEnabled = SERVE_SERVLETS_BY_CLASSNAME_ENABLED_EDEFAULT;

	/**
	 * This is true if the Serve Servlets By Classname Enabled attribute has been set. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean serveServletsByClassnameEnabledESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasWebAppExtImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_WEB_APP_EXT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getAdditionalClassPath() {
		return additionalClassPath;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdditionalClassPath(String newAdditionalClassPath) {
		String oldAdditionalClassPath = additionalClassPath;
		additionalClassPath = newAdditionalClassPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_WEB_APP_EXT__ADDITIONAL_CLASS_PATH, oldAdditionalClassPath, additionalClassPath));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAutoLoadFilters() {
		return autoLoadFilters;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAutoLoadFilters(boolean newAutoLoadFilters) {
		boolean oldAutoLoadFilters = autoLoadFilters;
		autoLoadFilters = newAutoLoadFilters;
		boolean oldAutoLoadFiltersESet = autoLoadFiltersESet;
		autoLoadFiltersESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_WEB_APP_EXT__AUTO_LOAD_FILTERS, oldAutoLoadFilters, autoLoadFilters, !oldAutoLoadFiltersESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAutoLoadFilters() {
		boolean oldAutoLoadFilters = autoLoadFilters;
		boolean oldAutoLoadFiltersESet = autoLoadFiltersESet;
		autoLoadFilters = AUTO_LOAD_FILTERS_EDEFAULT;
		autoLoadFiltersESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_WEB_APP_EXT__AUTO_LOAD_FILTERS, oldAutoLoadFilters, AUTO_LOAD_FILTERS_EDEFAULT, oldAutoLoadFiltersESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAutoLoadFilters() {
		return autoLoadFiltersESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAutoRequestEncoding() {
		return autoRequestEncoding;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAutoRequestEncoding(boolean newAutoRequestEncoding) {
		boolean oldAutoRequestEncoding = autoRequestEncoding;
		autoRequestEncoding = newAutoRequestEncoding;
		boolean oldAutoRequestEncodingESet = autoRequestEncodingESet;
		autoRequestEncodingESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_WEB_APP_EXT__AUTO_REQUEST_ENCODING, oldAutoRequestEncoding, autoRequestEncoding, !oldAutoRequestEncodingESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAutoRequestEncoding() {
		boolean oldAutoRequestEncoding = autoRequestEncoding;
		boolean oldAutoRequestEncodingESet = autoRequestEncodingESet;
		autoRequestEncoding = AUTO_REQUEST_ENCODING_EDEFAULT;
		autoRequestEncodingESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_WEB_APP_EXT__AUTO_REQUEST_ENCODING, oldAutoRequestEncoding, AUTO_REQUEST_ENCODING_EDEFAULT, oldAutoRequestEncodingESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAutoRequestEncoding() {
		return autoRequestEncodingESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAutoResponseEncoding() {
		return autoResponseEncoding;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAutoResponseEncoding(boolean newAutoResponseEncoding) {
		boolean oldAutoResponseEncoding = autoResponseEncoding;
		autoResponseEncoding = newAutoResponseEncoding;
		boolean oldAutoResponseEncodingESet = autoResponseEncodingESet;
		autoResponseEncodingESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_WEB_APP_EXT__AUTO_RESPONSE_ENCODING, oldAutoResponseEncoding, autoResponseEncoding, !oldAutoResponseEncodingESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAutoResponseEncoding() {
		boolean oldAutoResponseEncoding = autoResponseEncoding;
		boolean oldAutoResponseEncodingESet = autoResponseEncodingESet;
		autoResponseEncoding = AUTO_RESPONSE_ENCODING_EDEFAULT;
		autoResponseEncodingESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_WEB_APP_EXT__AUTO_RESPONSE_ENCODING, oldAutoResponseEncoding, AUTO_RESPONSE_ENCODING_EDEFAULT, oldAutoResponseEncodingESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAutoResponseEncoding() {
		return autoResponseEncodingESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultErrorPage() {
		return defaultErrorPage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultErrorPage(String newDefaultErrorPage) {
		String oldDefaultErrorPage = defaultErrorPage;
		defaultErrorPage = newDefaultErrorPage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_WEB_APP_EXT__DEFAULT_ERROR_PAGE, oldDefaultErrorPage, defaultErrorPage));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDirectoryBrowsingEnabled() {
		return directoryBrowsingEnabled;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirectoryBrowsingEnabled(boolean newDirectoryBrowsingEnabled) {
		boolean oldDirectoryBrowsingEnabled = directoryBrowsingEnabled;
		directoryBrowsingEnabled = newDirectoryBrowsingEnabled;
		boolean oldDirectoryBrowsingEnabledESet = directoryBrowsingEnabledESet;
		directoryBrowsingEnabledESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_WEB_APP_EXT__DIRECTORY_BROWSING_ENABLED, oldDirectoryBrowsingEnabled, directoryBrowsingEnabled, !oldDirectoryBrowsingEnabledESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDirectoryBrowsingEnabled() {
		boolean oldDirectoryBrowsingEnabled = directoryBrowsingEnabled;
		boolean oldDirectoryBrowsingEnabledESet = directoryBrowsingEnabledESet;
		directoryBrowsingEnabled = DIRECTORY_BROWSING_ENABLED_EDEFAULT;
		directoryBrowsingEnabledESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_WEB_APP_EXT__DIRECTORY_BROWSING_ENABLED, oldDirectoryBrowsingEnabled, DIRECTORY_BROWSING_ENABLED_EDEFAULT, oldDirectoryBrowsingEnabledESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDirectoryBrowsingEnabled() {
		return directoryBrowsingEnabledESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFileServingEnabled() {
		return fileServingEnabled;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setFileServingEnabled(boolean newFileServingEnabled) {
		boolean oldFileServingEnabled = fileServingEnabled;
		fileServingEnabled = newFileServingEnabled;
		boolean oldFileServingEnabledESet = fileServingEnabledESet;
		fileServingEnabledESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_WEB_APP_EXT__FILE_SERVING_ENABLED, oldFileServingEnabled, fileServingEnabled, !oldFileServingEnabledESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFileServingEnabled() {
		boolean oldFileServingEnabled = fileServingEnabled;
		boolean oldFileServingEnabledESet = fileServingEnabledESet;
		fileServingEnabled = FILE_SERVING_ENABLED_EDEFAULT;
		fileServingEnabledESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_WEB_APP_EXT__FILE_SERVING_ENABLED, oldFileServingEnabled, FILE_SERVING_ENABLED_EDEFAULT, oldFileServingEnabledESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFileServingEnabled() {
		return fileServingEnabledESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPreCompileJSPs() {
		return preCompileJSPs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPreCompileJSPs(boolean newPreCompileJSPs) {
		boolean oldPreCompileJSPs = preCompileJSPs;
		preCompileJSPs = newPreCompileJSPs;
		boolean oldPreCompileJSPsESet = preCompileJSPsESet;
		preCompileJSPsESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_WEB_APP_EXT__PRE_COMPILE_JS_PS, oldPreCompileJSPs, preCompileJSPs, !oldPreCompileJSPsESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPreCompileJSPs() {
		boolean oldPreCompileJSPs = preCompileJSPs;
		boolean oldPreCompileJSPsESet = preCompileJSPsESet;
		preCompileJSPs = PRE_COMPILE_JS_PS_EDEFAULT;
		preCompileJSPsESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_WEB_APP_EXT__PRE_COMPILE_JS_PS, oldPreCompileJSPs, PRE_COMPILE_JS_PS_EDEFAULT, oldPreCompileJSPsESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPreCompileJSPs() {
		return preCompileJSPsESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReloadingEnabled() {
		return reloadingEnabled;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setReloadingEnabled(boolean newReloadingEnabled) {
		boolean oldReloadingEnabled = reloadingEnabled;
		reloadingEnabled = newReloadingEnabled;
		boolean oldReloadingEnabledESet = reloadingEnabledESet;
		reloadingEnabledESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_WEB_APP_EXT__RELOADING_ENABLED, oldReloadingEnabled, reloadingEnabled, !oldReloadingEnabledESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetReloadingEnabled() {
		boolean oldReloadingEnabled = reloadingEnabled;
		boolean oldReloadingEnabledESet = reloadingEnabledESet;
		reloadingEnabled = RELOADING_ENABLED_EDEFAULT;
		reloadingEnabledESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_WEB_APP_EXT__RELOADING_ENABLED, oldReloadingEnabled, RELOADING_ENABLED_EDEFAULT, oldReloadingEnabledESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetReloadingEnabled() {
		return reloadingEnabledESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getReloadInterval() {
		return reloadInterval;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setReloadInterval(int newReloadInterval) {
		int oldReloadInterval = reloadInterval;
		reloadInterval = newReloadInterval;
		boolean oldReloadIntervalESet = reloadIntervalESet;
		reloadIntervalESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_WEB_APP_EXT__RELOAD_INTERVAL, oldReloadInterval, reloadInterval, !oldReloadIntervalESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetReloadInterval() {
		int oldReloadInterval = reloadInterval;
		boolean oldReloadIntervalESet = reloadIntervalESet;
		reloadInterval = RELOAD_INTERVAL_EDEFAULT;
		reloadIntervalESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_WEB_APP_EXT__RELOAD_INTERVAL, oldReloadInterval, RELOAD_INTERVAL_EDEFAULT, oldReloadIntervalESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetReloadInterval() {
		return reloadIntervalESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isServeServletsByClassnameEnabled() {
		return serveServletsByClassnameEnabled;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setServeServletsByClassnameEnabled(boolean newServeServletsByClassnameEnabled) {
		boolean oldServeServletsByClassnameEnabled = serveServletsByClassnameEnabled;
		serveServletsByClassnameEnabled = newServeServletsByClassnameEnabled;
		boolean oldServeServletsByClassnameEnabledESet = serveServletsByClassnameEnabledESet;
		serveServletsByClassnameEnabledESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WasPackage.WAS_WEB_APP_EXT__SERVE_SERVLETS_BY_CLASSNAME_ENABLED, oldServeServletsByClassnameEnabled, serveServletsByClassnameEnabled, !oldServeServletsByClassnameEnabledESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetServeServletsByClassnameEnabled() {
		boolean oldServeServletsByClassnameEnabled = serveServletsByClassnameEnabled;
		boolean oldServeServletsByClassnameEnabledESet = serveServletsByClassnameEnabledESet;
		serveServletsByClassnameEnabled = SERVE_SERVLETS_BY_CLASSNAME_ENABLED_EDEFAULT;
		serveServletsByClassnameEnabledESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, WasPackage.WAS_WEB_APP_EXT__SERVE_SERVLETS_BY_CLASSNAME_ENABLED, oldServeServletsByClassnameEnabled, SERVE_SERVLETS_BY_CLASSNAME_ENABLED_EDEFAULT, oldServeServletsByClassnameEnabledESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetServeServletsByClassnameEnabled() {
		return serveServletsByClassnameEnabledESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WasPackage.WAS_WEB_APP_EXT__ADDITIONAL_CLASS_PATH:
				return getAdditionalClassPath();
			case WasPackage.WAS_WEB_APP_EXT__AUTO_LOAD_FILTERS:
				return isAutoLoadFilters() ? Boolean.TRUE : Boolean.FALSE;
			case WasPackage.WAS_WEB_APP_EXT__AUTO_REQUEST_ENCODING:
				return isAutoRequestEncoding() ? Boolean.TRUE : Boolean.FALSE;
			case WasPackage.WAS_WEB_APP_EXT__AUTO_RESPONSE_ENCODING:
				return isAutoResponseEncoding() ? Boolean.TRUE : Boolean.FALSE;
			case WasPackage.WAS_WEB_APP_EXT__DEFAULT_ERROR_PAGE:
				return getDefaultErrorPage();
			case WasPackage.WAS_WEB_APP_EXT__DIRECTORY_BROWSING_ENABLED:
				return isDirectoryBrowsingEnabled() ? Boolean.TRUE : Boolean.FALSE;
			case WasPackage.WAS_WEB_APP_EXT__FILE_SERVING_ENABLED:
				return isFileServingEnabled() ? Boolean.TRUE : Boolean.FALSE;
			case WasPackage.WAS_WEB_APP_EXT__PRE_COMPILE_JS_PS:
				return isPreCompileJSPs() ? Boolean.TRUE : Boolean.FALSE;
			case WasPackage.WAS_WEB_APP_EXT__RELOADING_ENABLED:
				return isReloadingEnabled() ? Boolean.TRUE : Boolean.FALSE;
			case WasPackage.WAS_WEB_APP_EXT__RELOAD_INTERVAL:
				return new Integer(getReloadInterval());
			case WasPackage.WAS_WEB_APP_EXT__SERVE_SERVLETS_BY_CLASSNAME_ENABLED:
				return isServeServletsByClassnameEnabled() ? Boolean.TRUE : Boolean.FALSE;
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case WasPackage.WAS_WEB_APP_EXT__ADDITIONAL_CLASS_PATH:
				setAdditionalClassPath((String)newValue);
				return;
			case WasPackage.WAS_WEB_APP_EXT__AUTO_LOAD_FILTERS:
				setAutoLoadFilters(((Boolean)newValue).booleanValue());
				return;
			case WasPackage.WAS_WEB_APP_EXT__AUTO_REQUEST_ENCODING:
				setAutoRequestEncoding(((Boolean)newValue).booleanValue());
				return;
			case WasPackage.WAS_WEB_APP_EXT__AUTO_RESPONSE_ENCODING:
				setAutoResponseEncoding(((Boolean)newValue).booleanValue());
				return;
			case WasPackage.WAS_WEB_APP_EXT__DEFAULT_ERROR_PAGE:
				setDefaultErrorPage((String)newValue);
				return;
			case WasPackage.WAS_WEB_APP_EXT__DIRECTORY_BROWSING_ENABLED:
				setDirectoryBrowsingEnabled(((Boolean)newValue).booleanValue());
				return;
			case WasPackage.WAS_WEB_APP_EXT__FILE_SERVING_ENABLED:
				setFileServingEnabled(((Boolean)newValue).booleanValue());
				return;
			case WasPackage.WAS_WEB_APP_EXT__PRE_COMPILE_JS_PS:
				setPreCompileJSPs(((Boolean)newValue).booleanValue());
				return;
			case WasPackage.WAS_WEB_APP_EXT__RELOADING_ENABLED:
				setReloadingEnabled(((Boolean)newValue).booleanValue());
				return;
			case WasPackage.WAS_WEB_APP_EXT__RELOAD_INTERVAL:
				setReloadInterval(((Integer)newValue).intValue());
				return;
			case WasPackage.WAS_WEB_APP_EXT__SERVE_SERVLETS_BY_CLASSNAME_ENABLED:
				setServeServletsByClassnameEnabled(((Boolean)newValue).booleanValue());
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
			case WasPackage.WAS_WEB_APP_EXT__ADDITIONAL_CLASS_PATH:
				setAdditionalClassPath(ADDITIONAL_CLASS_PATH_EDEFAULT);
				return;
			case WasPackage.WAS_WEB_APP_EXT__AUTO_LOAD_FILTERS:
				unsetAutoLoadFilters();
				return;
			case WasPackage.WAS_WEB_APP_EXT__AUTO_REQUEST_ENCODING:
				unsetAutoRequestEncoding();
				return;
			case WasPackage.WAS_WEB_APP_EXT__AUTO_RESPONSE_ENCODING:
				unsetAutoResponseEncoding();
				return;
			case WasPackage.WAS_WEB_APP_EXT__DEFAULT_ERROR_PAGE:
				setDefaultErrorPage(DEFAULT_ERROR_PAGE_EDEFAULT);
				return;
			case WasPackage.WAS_WEB_APP_EXT__DIRECTORY_BROWSING_ENABLED:
				unsetDirectoryBrowsingEnabled();
				return;
			case WasPackage.WAS_WEB_APP_EXT__FILE_SERVING_ENABLED:
				unsetFileServingEnabled();
				return;
			case WasPackage.WAS_WEB_APP_EXT__PRE_COMPILE_JS_PS:
				unsetPreCompileJSPs();
				return;
			case WasPackage.WAS_WEB_APP_EXT__RELOADING_ENABLED:
				unsetReloadingEnabled();
				return;
			case WasPackage.WAS_WEB_APP_EXT__RELOAD_INTERVAL:
				unsetReloadInterval();
				return;
			case WasPackage.WAS_WEB_APP_EXT__SERVE_SERVLETS_BY_CLASSNAME_ENABLED:
				unsetServeServletsByClassnameEnabled();
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
			case WasPackage.WAS_WEB_APP_EXT__ADDITIONAL_CLASS_PATH:
				return ADDITIONAL_CLASS_PATH_EDEFAULT == null ? additionalClassPath != null : !ADDITIONAL_CLASS_PATH_EDEFAULT.equals(additionalClassPath);
			case WasPackage.WAS_WEB_APP_EXT__AUTO_LOAD_FILTERS:
				return isSetAutoLoadFilters();
			case WasPackage.WAS_WEB_APP_EXT__AUTO_REQUEST_ENCODING:
				return isSetAutoRequestEncoding();
			case WasPackage.WAS_WEB_APP_EXT__AUTO_RESPONSE_ENCODING:
				return isSetAutoResponseEncoding();
			case WasPackage.WAS_WEB_APP_EXT__DEFAULT_ERROR_PAGE:
				return DEFAULT_ERROR_PAGE_EDEFAULT == null ? defaultErrorPage != null : !DEFAULT_ERROR_PAGE_EDEFAULT.equals(defaultErrorPage);
			case WasPackage.WAS_WEB_APP_EXT__DIRECTORY_BROWSING_ENABLED:
				return isSetDirectoryBrowsingEnabled();
			case WasPackage.WAS_WEB_APP_EXT__FILE_SERVING_ENABLED:
				return isSetFileServingEnabled();
			case WasPackage.WAS_WEB_APP_EXT__PRE_COMPILE_JS_PS:
				return isSetPreCompileJSPs();
			case WasPackage.WAS_WEB_APP_EXT__RELOADING_ENABLED:
				return isSetReloadingEnabled();
			case WasPackage.WAS_WEB_APP_EXT__RELOAD_INTERVAL:
				return isSetReloadInterval();
			case WasPackage.WAS_WEB_APP_EXT__SERVE_SERVLETS_BY_CLASSNAME_ENABLED:
				return isSetServeServletsByClassnameEnabled();
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
		result.append(" (additionalClassPath: "); //$NON-NLS-1$
		result.append(additionalClassPath);
		result.append(", autoLoadFilters: "); //$NON-NLS-1$
		if (autoLoadFiltersESet) result.append(autoLoadFilters); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", autoRequestEncoding: "); //$NON-NLS-1$
		if (autoRequestEncodingESet) result.append(autoRequestEncoding); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", autoResponseEncoding: "); //$NON-NLS-1$
		if (autoResponseEncodingESet) result.append(autoResponseEncoding); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", defaultErrorPage: "); //$NON-NLS-1$
		result.append(defaultErrorPage);
		result.append(", directoryBrowsingEnabled: "); //$NON-NLS-1$
		if (directoryBrowsingEnabledESet) result.append(directoryBrowsingEnabled); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", fileServingEnabled: "); //$NON-NLS-1$
		if (fileServingEnabledESet) result.append(fileServingEnabled); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", preCompileJSPs: "); //$NON-NLS-1$
		if (preCompileJSPsESet) result.append(preCompileJSPs); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", reloadingEnabled: "); //$NON-NLS-1$
		if (reloadingEnabledESet) result.append(reloadingEnabled); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", reloadInterval: "); //$NON-NLS-1$
		if (reloadIntervalESet) result.append(reloadInterval); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", serveServletsByClassnameEnabled: "); //$NON-NLS-1$
		if (serveServletsByClassnameEnabledESet) result.append(serveServletsByClassnameEnabled); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //WasWebAppExtImpl
