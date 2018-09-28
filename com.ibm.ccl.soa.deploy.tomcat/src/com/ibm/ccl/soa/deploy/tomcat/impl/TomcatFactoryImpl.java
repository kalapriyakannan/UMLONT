/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tomcat.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.ibm.ccl.soa.deploy.tomcat.Tomcat50Datasource;
import com.ibm.ccl.soa.deploy.tomcat.TomcatDatasourceUnit;
import com.ibm.ccl.soa.deploy.tomcat.TomcatDeployRoot;
import com.ibm.ccl.soa.deploy.tomcat.TomcatFactory;
import com.ibm.ccl.soa.deploy.tomcat.TomcatPackage;
import com.ibm.ccl.soa.deploy.tomcat.TomcatServer;
import com.ibm.ccl.soa.deploy.tomcat.TomcatWebServerUnit;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class TomcatFactoryImpl extends EFactoryImpl implements TomcatFactory {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static TomcatFactory init() {
		try {
			TomcatFactory theTomcatFactory = (TomcatFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.ibm.com/ccl/soa/deploy/tomcat/1.0.0/"); //$NON-NLS-1$ 
			if (theTomcatFactory != null) {
				return theTomcatFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TomcatFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TomcatFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case TomcatPackage.TOMCAT50_DATASOURCE: return createTomcat50Datasource();
			case TomcatPackage.TOMCAT_DATASOURCE_UNIT: return createTomcatDatasourceUnit();
			case TomcatPackage.TOMCAT_DEPLOY_ROOT: return createTomcatDeployRoot();
			case TomcatPackage.TOMCAT_SERVER: return createTomcatServer();
			case TomcatPackage.TOMCAT_WEB_SERVER_UNIT: return createTomcatWebServerUnit();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Tomcat50Datasource createTomcat50Datasource() {
		Tomcat50DatasourceImpl tomcat50Datasource = new Tomcat50DatasourceImpl();
		return tomcat50Datasource;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TomcatDatasourceUnit createTomcatDatasourceUnit() {
		TomcatDatasourceUnitImpl tomcatDatasourceUnit = new TomcatDatasourceUnitImpl();
		return tomcatDatasourceUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TomcatDeployRoot createTomcatDeployRoot() {
		TomcatDeployRootImpl tomcatDeployRoot = new TomcatDeployRootImpl();
		return tomcatDeployRoot;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TomcatServer createTomcatServer() {
		TomcatServerImpl tomcatServer = new TomcatServerImpl();
		return tomcatServer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TomcatWebServerUnit createTomcatWebServerUnit() {
		TomcatWebServerUnitImpl tomcatWebServerUnit = new TomcatWebServerUnitImpl();
		return tomcatWebServerUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TomcatPackage getTomcatPackage() {
		return (TomcatPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static TomcatPackage getPackage() {
		return TomcatPackage.eINSTANCE;
	}

} //TomcatFactoryImpl
