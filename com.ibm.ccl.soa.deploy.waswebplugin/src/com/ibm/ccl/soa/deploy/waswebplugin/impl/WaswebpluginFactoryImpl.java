/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.waswebplugin.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.ibm.ccl.soa.deploy.waswebplugin.IhsWasPlugin;
import com.ibm.ccl.soa.deploy.waswebplugin.IhsWasPluginUnit;
import com.ibm.ccl.soa.deploy.waswebplugin.WasWebPluginDeployRoot;
import com.ibm.ccl.soa.deploy.waswebplugin.WasWebServerToIhsConstraint;
import com.ibm.ccl.soa.deploy.waswebplugin.WaswebpluginFactory;
import com.ibm.ccl.soa.deploy.waswebplugin.WaswebpluginPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class WaswebpluginFactoryImpl extends EFactoryImpl implements WaswebpluginFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static WaswebpluginFactory init() {
		try {
			WaswebpluginFactory theWaswebpluginFactory = (WaswebpluginFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.ibm.com/ccl/soa/deploy/waswebplugin/1.0.0/"); //$NON-NLS-1$ 
			if (theWaswebpluginFactory != null) {
				return theWaswebpluginFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new WaswebpluginFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WaswebpluginFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case WaswebpluginPackage.IHS_WAS_PLUGIN: return createIhsWasPlugin();
			case WaswebpluginPackage.IHS_WAS_PLUGIN_UNIT: return createIhsWasPluginUnit();
			case WaswebpluginPackage.WAS_WEB_PLUGIN_DEPLOY_ROOT: return createWasWebPluginDeployRoot();
			case WaswebpluginPackage.WAS_WEB_SERVER_TO_IHS_CONSTRAINT: return createWasWebServerToIhsConstraint();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IhsWasPlugin createIhsWasPlugin() {
		IhsWasPluginImpl ihsWasPlugin = new IhsWasPluginImpl();
		return ihsWasPlugin;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IhsWasPluginUnit createIhsWasPluginUnit() {
		IhsWasPluginUnitImpl ihsWasPluginUnit = new IhsWasPluginUnitImpl();
		return ihsWasPluginUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WasWebPluginDeployRoot createWasWebPluginDeployRoot() {
		WasWebPluginDeployRootImpl wasWebPluginDeployRoot = new WasWebPluginDeployRootImpl();
		return wasWebPluginDeployRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WasWebServerToIhsConstraint createWasWebServerToIhsConstraint() {
		WasWebServerToIhsConstraintImpl wasWebServerToIhsConstraint = new WasWebServerToIhsConstraintImpl();
		return wasWebServerToIhsConstraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WaswebpluginPackage getWaswebpluginPackage() {
		return (WaswebpluginPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static WaswebpluginPackage getPackage() {
		return WaswebpluginPackage.eINSTANCE;
	}

} //WaswebpluginFactoryImpl
