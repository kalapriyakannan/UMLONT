/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tomcat.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.j2ee.impl.J2EEDatasourceImpl;
import com.ibm.ccl.soa.deploy.tomcat.Tomcat50Datasource;
import com.ibm.ccl.soa.deploy.tomcat.TomcatPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Tomcat50 Datasource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.tomcat.impl.Tomcat50DatasourceImpl#getClientJarLocation <em>Client Jar Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.tomcat.impl.Tomcat50DatasourceImpl#getDriverClassName <em>Driver Class Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.tomcat.impl.Tomcat50DatasourceImpl#getFactory <em>Factory</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.tomcat.impl.Tomcat50DatasourceImpl#getUrl <em>Url</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Tomcat50DatasourceImpl extends J2EEDatasourceImpl implements Tomcat50Datasource {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getClientJarLocation() <em>Client Jar Location</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getClientJarLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String CLIENT_JAR_LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClientJarLocation() <em>Client Jar Location</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getClientJarLocation()
	 * @generated
	 * @ordered
	 */
	protected String clientJarLocation = CLIENT_JAR_LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDriverClassName() <em>Driver Class Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDriverClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String DRIVER_CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDriverClassName() <em>Driver Class Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDriverClassName()
	 * @generated
	 * @ordered
	 */
	protected String driverClassName = DRIVER_CLASS_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getFactory() <em>Factory</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFactory()
	 * @generated
	 * @ordered
	 */
	protected static final String FACTORY_EDEFAULT = "org.apache.commons.dbcp.BasicDataSourceFactory"; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getFactory() <em>Factory</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFactory()
	 * @generated
	 * @ordered
	 */
	protected String factory = FACTORY_EDEFAULT;

	/**
	 * This is true if the Factory attribute has been set. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean factoryESet;

	/**
	 * The default value of the '{@link #getUrl() <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUrl() <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrl()
	 * @generated
	 * @ordered
	 */
	protected String url = URL_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected Tomcat50DatasourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return TomcatPackage.Literals.TOMCAT50_DATASOURCE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getClientJarLocation() {
		return clientJarLocation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setClientJarLocation(String newClientJarLocation) {
		String oldClientJarLocation = clientJarLocation;
		clientJarLocation = newClientJarLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TomcatPackage.TOMCAT50_DATASOURCE__CLIENT_JAR_LOCATION, oldClientJarLocation, clientJarLocation));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDriverClassName() {
		return driverClassName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDriverClassName(String newDriverClassName) {
		String oldDriverClassName = driverClassName;
		driverClassName = newDriverClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TomcatPackage.TOMCAT50_DATASOURCE__DRIVER_CLASS_NAME, oldDriverClassName, driverClassName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getFactory() {
		return factory;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setFactory(String newFactory) {
		String oldFactory = factory;
		factory = newFactory;
		boolean oldFactoryESet = factoryESet;
		factoryESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TomcatPackage.TOMCAT50_DATASOURCE__FACTORY, oldFactory, factory, !oldFactoryESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFactory() {
		String oldFactory = factory;
		boolean oldFactoryESet = factoryESet;
		factory = FACTORY_EDEFAULT;
		factoryESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, TomcatPackage.TOMCAT50_DATASOURCE__FACTORY, oldFactory, FACTORY_EDEFAULT, oldFactoryESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFactory() {
		return factoryESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUrl(String newUrl) {
		String oldUrl = url;
		url = newUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TomcatPackage.TOMCAT50_DATASOURCE__URL, oldUrl, url));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TomcatPackage.TOMCAT50_DATASOURCE__CLIENT_JAR_LOCATION:
				return getClientJarLocation();
			case TomcatPackage.TOMCAT50_DATASOURCE__DRIVER_CLASS_NAME:
				return getDriverClassName();
			case TomcatPackage.TOMCAT50_DATASOURCE__FACTORY:
				return getFactory();
			case TomcatPackage.TOMCAT50_DATASOURCE__URL:
				return getUrl();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TomcatPackage.TOMCAT50_DATASOURCE__CLIENT_JAR_LOCATION:
				setClientJarLocation((String)newValue);
				return;
			case TomcatPackage.TOMCAT50_DATASOURCE__DRIVER_CLASS_NAME:
				setDriverClassName((String)newValue);
				return;
			case TomcatPackage.TOMCAT50_DATASOURCE__FACTORY:
				setFactory((String)newValue);
				return;
			case TomcatPackage.TOMCAT50_DATASOURCE__URL:
				setUrl((String)newValue);
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
			case TomcatPackage.TOMCAT50_DATASOURCE__CLIENT_JAR_LOCATION:
				setClientJarLocation(CLIENT_JAR_LOCATION_EDEFAULT);
				return;
			case TomcatPackage.TOMCAT50_DATASOURCE__DRIVER_CLASS_NAME:
				setDriverClassName(DRIVER_CLASS_NAME_EDEFAULT);
				return;
			case TomcatPackage.TOMCAT50_DATASOURCE__FACTORY:
				unsetFactory();
				return;
			case TomcatPackage.TOMCAT50_DATASOURCE__URL:
				setUrl(URL_EDEFAULT);
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
			case TomcatPackage.TOMCAT50_DATASOURCE__CLIENT_JAR_LOCATION:
				return CLIENT_JAR_LOCATION_EDEFAULT == null ? clientJarLocation != null : !CLIENT_JAR_LOCATION_EDEFAULT.equals(clientJarLocation);
			case TomcatPackage.TOMCAT50_DATASOURCE__DRIVER_CLASS_NAME:
				return DRIVER_CLASS_NAME_EDEFAULT == null ? driverClassName != null : !DRIVER_CLASS_NAME_EDEFAULT.equals(driverClassName);
			case TomcatPackage.TOMCAT50_DATASOURCE__FACTORY:
				return isSetFactory();
			case TomcatPackage.TOMCAT50_DATASOURCE__URL:
				return URL_EDEFAULT == null ? url != null : !URL_EDEFAULT.equals(url);
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
		result.append(" (clientJarLocation: "); //$NON-NLS-1$
		result.append(clientJarLocation);
		result.append(", driverClassName: "); //$NON-NLS-1$
		result.append(driverClassName);
		result.append(", factory: "); //$NON-NLS-1$
		if (factoryESet) result.append(factory); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", url: "); //$NON-NLS-1$
		result.append(url);
		result.append(')');
		return result.toString();
	}

} //Tomcat50DatasourceImpl
