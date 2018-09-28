/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.server.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.ibm.ccl.soa.deploy.server.ArchitectureWidthType;
import com.ibm.ccl.soa.deploy.server.ProcessingCapacityUnitsType;
import com.ibm.ccl.soa.deploy.server.Server;
import com.ibm.ccl.soa.deploy.server.ServerFactory;
import com.ibm.ccl.soa.deploy.server.ServerPackage;
import com.ibm.ccl.soa.deploy.server.ServerRoot;
import com.ibm.ccl.soa.deploy.server.ServerUnit;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class ServerFactoryImpl extends EFactoryImpl implements ServerFactory {
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
	public static ServerFactory init() {
		try {
			ServerFactory theServerFactory = (ServerFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://www.ibm.com/ccl/soa/deploy/server/1.0.0/"); //$NON-NLS-1$ 
			if (theServerFactory != null) {
				return theServerFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ServerFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ServerFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID())
		{
		case ServerPackage.SERVER:
			return createServer();
		case ServerPackage.SERVER_ROOT:
			return (EObject) createServerRoot();
		case ServerPackage.SERVER_UNIT:
			return createServerUnit();
		default:
			throw new IllegalArgumentException(
					"The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID())
		{
		case ServerPackage.ARCHITECTURE_WIDTH_TYPE:
			return createArchitectureWidthTypeFromString(eDataType, initialValue);
		case ServerPackage.PROCESSING_CAPACITY_UNITS_TYPE:
			return createProcessingCapacityUnitsTypeFromString(eDataType, initialValue);
		case ServerPackage.ARCHITECTURE_WIDTH_TYPE_OBJECT:
			return createArchitectureWidthTypeObjectFromString(eDataType, initialValue);
		case ServerPackage.PROCESSING_CAPACITY_UNITS_TYPE_OBJECT:
			return createProcessingCapacityUnitsTypeObjectFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException(
					"The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID())
		{
		case ServerPackage.ARCHITECTURE_WIDTH_TYPE:
			return convertArchitectureWidthTypeToString(eDataType, instanceValue);
		case ServerPackage.PROCESSING_CAPACITY_UNITS_TYPE:
			return convertProcessingCapacityUnitsTypeToString(eDataType, instanceValue);
		case ServerPackage.ARCHITECTURE_WIDTH_TYPE_OBJECT:
			return convertArchitectureWidthTypeObjectToString(eDataType, instanceValue);
		case ServerPackage.PROCESSING_CAPACITY_UNITS_TYPE_OBJECT:
			return convertProcessingCapacityUnitsTypeObjectToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException(
					"The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Server createServer() {
		ServerImpl server = new ServerImpl();
		return server;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ServerRoot createServerRoot() {
		ServerRootImpl serverRoot = new ServerRootImpl();
		return serverRoot;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ServerUnit createServerUnit() {
		ServerUnitImpl serverUnit = new ServerUnitImpl();
		return serverUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureWidthType createArchitectureWidthTypeFromString(EDataType eDataType,
			String initialValue) {
		ArchitectureWidthType result = ArchitectureWidthType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertArchitectureWidthTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingCapacityUnitsType createProcessingCapacityUnitsTypeFromString(
			EDataType eDataType, String initialValue) {
		ProcessingCapacityUnitsType result = ProcessingCapacityUnitsType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertProcessingCapacityUnitsTypeToString(EDataType eDataType,
			Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureWidthType createArchitectureWidthTypeObjectFromString(EDataType eDataType,
			String initialValue) {
		return createArchitectureWidthTypeFromString(ServerPackage.Literals.ARCHITECTURE_WIDTH_TYPE,
				initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertArchitectureWidthTypeObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertArchitectureWidthTypeToString(ServerPackage.Literals.ARCHITECTURE_WIDTH_TYPE,
				instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingCapacityUnitsType createProcessingCapacityUnitsTypeObjectFromString(
			EDataType eDataType, String initialValue) {
		return createProcessingCapacityUnitsTypeFromString(
				ServerPackage.Literals.PROCESSING_CAPACITY_UNITS_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertProcessingCapacityUnitsTypeObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertProcessingCapacityUnitsTypeToString(
				ServerPackage.Literals.PROCESSING_CAPACITY_UNITS_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ServerPackage getServerPackage() {
		return (ServerPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static ServerPackage getPackage() {
		return ServerPackage.eINSTANCE;
	}

} //ServerFactoryImpl
