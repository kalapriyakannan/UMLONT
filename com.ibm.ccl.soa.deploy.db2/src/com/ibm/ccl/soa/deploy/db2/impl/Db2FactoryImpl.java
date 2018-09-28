/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.ibm.ccl.soa.deploy.db2.AuthenticationTypeType;
import com.ibm.ccl.soa.deploy.db2.DB2AdminClient;
import com.ibm.ccl.soa.deploy.db2.DB2AdminClientUnit;
import com.ibm.ccl.soa.deploy.db2.DB2AdminServer;
import com.ibm.ccl.soa.deploy.db2.DB2AdminServerUnit;
import com.ibm.ccl.soa.deploy.db2.DB2AppDevelClient;
import com.ibm.ccl.soa.deploy.db2.DB2AppDevelClientUnit;
import com.ibm.ccl.soa.deploy.db2.DB2BaseClientUnit;
import com.ibm.ccl.soa.deploy.db2.DB2BaseInstance;
import com.ibm.ccl.soa.deploy.db2.DB2CatalogUnit;
import com.ibm.ccl.soa.deploy.db2.DB2CatalogedNode;
import com.ibm.ccl.soa.deploy.db2.DB2Client;
import com.ibm.ccl.soa.deploy.db2.DB2ClientInstance;
import com.ibm.ccl.soa.deploy.db2.DB2ClientInstanceUnit;
import com.ibm.ccl.soa.deploy.db2.DB2DDLArtifact;
import com.ibm.ccl.soa.deploy.db2.DB2Database;
import com.ibm.ccl.soa.deploy.db2.DB2DatabaseUnit;
import com.ibm.ccl.soa.deploy.db2.DB2Instance;
import com.ibm.ccl.soa.deploy.db2.DB2InstancePortNames;
import com.ibm.ccl.soa.deploy.db2.DB2InstanceUnit;
import com.ibm.ccl.soa.deploy.db2.DB2JdbcDriver;
import com.ibm.ccl.soa.deploy.db2.DB2NodeCatalogUnit;
import com.ibm.ccl.soa.deploy.db2.DB2RuntimeClientUnit;
import com.ibm.ccl.soa.deploy.db2.DB2System;
import com.ibm.ccl.soa.deploy.db2.DB2SystemUnit;
import com.ibm.ccl.soa.deploy.db2.Db2DeployRoot;
import com.ibm.ccl.soa.deploy.db2.Db2Factory;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.PageSizeType;
import com.ibm.ccl.soa.deploy.db2.UnixDB2AdminServer;
import com.ibm.ccl.soa.deploy.db2.UnixDB2ClientInstance;
import com.ibm.ccl.soa.deploy.db2.UnixDB2Instance;
import com.ibm.ccl.soa.deploy.db2.UnixDB2System;
import com.ibm.ccl.soa.deploy.db2.UnixInstanceTypeType;
import com.ibm.ccl.soa.deploy.db2.WindowsDB2AdminServer;
import com.ibm.ccl.soa.deploy.db2.WindowsDB2ClientInstance;
import com.ibm.ccl.soa.deploy.db2.WindowsDB2Instance;
import com.ibm.ccl.soa.deploy.db2.WindowsDB2System;
import com.ibm.ccl.soa.deploy.db2.WindowsInstanceTypeType;
import com.ibm.ccl.soa.deploy.db2.WordWidthType;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class Db2FactoryImpl extends EFactoryImpl implements Db2Factory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static Db2Factory init() {
		try {
			Db2Factory theDb2Factory = (Db2Factory)EPackage.Registry.INSTANCE.getEFactory("http://www.ibm.com/ccl/soa/deploy/db2/1.0.0/"); //$NON-NLS-1$ 
			if (theDb2Factory != null) {
				return theDb2Factory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Db2FactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Db2FactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case Db2Package.DB2_ADMIN_CLIENT: return createDB2AdminClient();
			case Db2Package.DB2_ADMIN_CLIENT_UNIT: return createDB2AdminClientUnit();
			case Db2Package.DB2_ADMIN_SERVER: return createDB2AdminServer();
			case Db2Package.DB2_ADMIN_SERVER_UNIT: return createDB2AdminServerUnit();
			case Db2Package.DB2_APP_DEVEL_CLIENT: return createDB2AppDevelClient();
			case Db2Package.DB2_APP_DEVEL_CLIENT_UNIT: return createDB2AppDevelClientUnit();
			case Db2Package.DB2_BASE_CLIENT_UNIT: return createDB2BaseClientUnit();
			case Db2Package.DB2_BASE_INSTANCE: return createDB2BaseInstance();
			case Db2Package.DB2_CATALOGED_NODE: return createDB2CatalogedNode();
			case Db2Package.DB2_CATALOG_UNIT: return createDB2CatalogUnit();
			case Db2Package.DB2_CLIENT: return createDB2Client();
			case Db2Package.DB2_CLIENT_INSTANCE: return createDB2ClientInstance();
			case Db2Package.DB2_CLIENT_INSTANCE_UNIT: return createDB2ClientInstanceUnit();
			case Db2Package.DB2_DATABASE: return createDB2Database();
			case Db2Package.DB2_DATABASE_UNIT: return createDB2DatabaseUnit();
			case Db2Package.DB2DDL_ARTIFACT: return createDB2DDLArtifact();
			case Db2Package.DB2_DEPLOY_ROOT: return createDb2DeployRoot();
			case Db2Package.DB2_INSTANCE: return createDB2Instance();
			case Db2Package.DB2_INSTANCE_UNIT: return createDB2InstanceUnit();
			case Db2Package.DB2_JDBC_DRIVER: return createDB2JdbcDriver();
			case Db2Package.DB2_NODE_CATALOG_UNIT: return createDB2NodeCatalogUnit();
			case Db2Package.DB2_RUNTIME_CLIENT_UNIT: return createDB2RuntimeClientUnit();
			case Db2Package.DB2_SYSTEM: return createDB2System();
			case Db2Package.DB2_SYSTEM_UNIT: return createDB2SystemUnit();
			case Db2Package.UNIX_DB2_ADMIN_SERVER: return createUnixDB2AdminServer();
			case Db2Package.UNIX_DB2_CLIENT_INSTANCE: return createUnixDB2ClientInstance();
			case Db2Package.UNIX_DB2_INSTANCE: return createUnixDB2Instance();
			case Db2Package.UNIX_DB2_SYSTEM: return createUnixDB2System();
			case Db2Package.WINDOWS_DB2_ADMIN_SERVER: return createWindowsDB2AdminServer();
			case Db2Package.WINDOWS_DB2_CLIENT_INSTANCE: return createWindowsDB2ClientInstance();
			case Db2Package.WINDOWS_DB2_INSTANCE: return createWindowsDB2Instance();
			case Db2Package.WINDOWS_DB2_SYSTEM: return createWindowsDB2System();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case Db2Package.AUTHENTICATION_TYPE_TYPE:
				return createAuthenticationTypeTypeFromString(eDataType, initialValue);
			case Db2Package.DB2_INSTANCE_PORT_NAMES:
				return createDB2InstancePortNamesFromString(eDataType, initialValue);
			case Db2Package.PAGE_SIZE_TYPE:
				return createPageSizeTypeFromString(eDataType, initialValue);
			case Db2Package.UNIX_INSTANCE_TYPE_TYPE:
				return createUnixInstanceTypeTypeFromString(eDataType, initialValue);
			case Db2Package.WINDOWS_INSTANCE_TYPE_TYPE:
				return createWindowsInstanceTypeTypeFromString(eDataType, initialValue);
			case Db2Package.WORD_WIDTH_TYPE:
				return createWordWidthTypeFromString(eDataType, initialValue);
			case Db2Package.AUTHENTICATION_TYPE_TYPE_OBJECT:
				return createAuthenticationTypeTypeObjectFromString(eDataType, initialValue);
			case Db2Package.DB2_INSTANCE_PORT_NAMES_OBJECT:
				return createDB2InstancePortNamesObjectFromString(eDataType, initialValue);
			case Db2Package.PAGE_SIZE_TYPE_OBJECT:
				return createPageSizeTypeObjectFromString(eDataType, initialValue);
			case Db2Package.UNIX_INSTANCE_TYPE_TYPE_OBJECT:
				return createUnixInstanceTypeTypeObjectFromString(eDataType, initialValue);
			case Db2Package.WINDOWS_INSTANCE_TYPE_TYPE_OBJECT:
				return createWindowsInstanceTypeTypeObjectFromString(eDataType, initialValue);
			case Db2Package.WORD_WIDTH_TYPE_OBJECT:
				return createWordWidthTypeObjectFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case Db2Package.AUTHENTICATION_TYPE_TYPE:
				return convertAuthenticationTypeTypeToString(eDataType, instanceValue);
			case Db2Package.DB2_INSTANCE_PORT_NAMES:
				return convertDB2InstancePortNamesToString(eDataType, instanceValue);
			case Db2Package.PAGE_SIZE_TYPE:
				return convertPageSizeTypeToString(eDataType, instanceValue);
			case Db2Package.UNIX_INSTANCE_TYPE_TYPE:
				return convertUnixInstanceTypeTypeToString(eDataType, instanceValue);
			case Db2Package.WINDOWS_INSTANCE_TYPE_TYPE:
				return convertWindowsInstanceTypeTypeToString(eDataType, instanceValue);
			case Db2Package.WORD_WIDTH_TYPE:
				return convertWordWidthTypeToString(eDataType, instanceValue);
			case Db2Package.AUTHENTICATION_TYPE_TYPE_OBJECT:
				return convertAuthenticationTypeTypeObjectToString(eDataType, instanceValue);
			case Db2Package.DB2_INSTANCE_PORT_NAMES_OBJECT:
				return convertDB2InstancePortNamesObjectToString(eDataType, instanceValue);
			case Db2Package.PAGE_SIZE_TYPE_OBJECT:
				return convertPageSizeTypeObjectToString(eDataType, instanceValue);
			case Db2Package.UNIX_INSTANCE_TYPE_TYPE_OBJECT:
				return convertUnixInstanceTypeTypeObjectToString(eDataType, instanceValue);
			case Db2Package.WINDOWS_INSTANCE_TYPE_TYPE_OBJECT:
				return convertWindowsInstanceTypeTypeObjectToString(eDataType, instanceValue);
			case Db2Package.WORD_WIDTH_TYPE_OBJECT:
				return convertWordWidthTypeObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2AdminClient createDB2AdminClient() {
		DB2AdminClientImpl db2AdminClient = new DB2AdminClientImpl();
		return db2AdminClient;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2AdminClientUnit createDB2AdminClientUnit() {
		DB2AdminClientUnitImpl db2AdminClientUnit = new DB2AdminClientUnitImpl();
		return db2AdminClientUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2AdminServer createDB2AdminServer() {
		DB2AdminServerImpl db2AdminServer = new DB2AdminServerImpl();
		return db2AdminServer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2AdminServerUnit createDB2AdminServerUnit() {
		DB2AdminServerUnitImpl db2AdminServerUnit = new DB2AdminServerUnitImpl();
		return db2AdminServerUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2AppDevelClient createDB2AppDevelClient() {
		DB2AppDevelClientImpl db2AppDevelClient = new DB2AppDevelClientImpl();
		return db2AppDevelClient;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2AppDevelClientUnit createDB2AppDevelClientUnit() {
		DB2AppDevelClientUnitImpl db2AppDevelClientUnit = new DB2AppDevelClientUnitImpl();
		return db2AppDevelClientUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2BaseClientUnit createDB2BaseClientUnit() {
		DB2BaseClientUnitImpl db2BaseClientUnit = new DB2BaseClientUnitImpl();
		return db2BaseClientUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2BaseInstance createDB2BaseInstance() {
		DB2BaseInstanceImpl db2BaseInstance = new DB2BaseInstanceImpl();
		return db2BaseInstance;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2CatalogedNode createDB2CatalogedNode() {
		DB2CatalogedNodeImpl db2CatalogedNode = new DB2CatalogedNodeImpl();
		return db2CatalogedNode;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2CatalogUnit createDB2CatalogUnit() {
		DB2CatalogUnitImpl db2CatalogUnit = new DB2CatalogUnitImpl();
		return db2CatalogUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2Client createDB2Client() {
		DB2ClientImpl db2Client = new DB2ClientImpl();
		return db2Client;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2ClientInstance createDB2ClientInstance() {
		DB2ClientInstanceImpl db2ClientInstance = new DB2ClientInstanceImpl();
		return db2ClientInstance;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2ClientInstanceUnit createDB2ClientInstanceUnit() {
		DB2ClientInstanceUnitImpl db2ClientInstanceUnit = new DB2ClientInstanceUnitImpl();
		return db2ClientInstanceUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2Database createDB2Database() {
		DB2DatabaseImpl db2Database = new DB2DatabaseImpl();
		return db2Database;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2DatabaseUnit createDB2DatabaseUnit() {
		DB2DatabaseUnitImpl db2DatabaseUnit = new DB2DatabaseUnitImpl();
		return db2DatabaseUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2DDLArtifact createDB2DDLArtifact() {
		DB2DDLArtifactImpl db2DDLArtifact = new DB2DDLArtifactImpl();
		return db2DDLArtifact;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Db2DeployRoot createDb2DeployRoot() {
		Db2DeployRootImpl db2DeployRoot = new Db2DeployRootImpl();
		return db2DeployRoot;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2Instance createDB2Instance() {
		DB2InstanceImpl db2Instance = new DB2InstanceImpl();
		return db2Instance;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2InstanceUnit createDB2InstanceUnit() {
		DB2InstanceUnitImpl db2InstanceUnit = new DB2InstanceUnitImpl();
		return db2InstanceUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2JdbcDriver createDB2JdbcDriver() {
		DB2JdbcDriverImpl db2JdbcDriver = new DB2JdbcDriverImpl();
		return db2JdbcDriver;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2NodeCatalogUnit createDB2NodeCatalogUnit() {
		DB2NodeCatalogUnitImpl db2NodeCatalogUnit = new DB2NodeCatalogUnitImpl();
		return db2NodeCatalogUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2RuntimeClientUnit createDB2RuntimeClientUnit() {
		DB2RuntimeClientUnitImpl db2RuntimeClientUnit = new DB2RuntimeClientUnitImpl();
		return db2RuntimeClientUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2System createDB2System() {
		DB2SystemImpl db2System = new DB2SystemImpl();
		return db2System;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2SystemUnit createDB2SystemUnit() {
		DB2SystemUnitImpl db2SystemUnit = new DB2SystemUnitImpl();
		return db2SystemUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UnixDB2AdminServer createUnixDB2AdminServer() {
		UnixDB2AdminServerImpl unixDB2AdminServer = new UnixDB2AdminServerImpl();
		return unixDB2AdminServer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UnixDB2ClientInstance createUnixDB2ClientInstance() {
		UnixDB2ClientInstanceImpl unixDB2ClientInstance = new UnixDB2ClientInstanceImpl();
		return unixDB2ClientInstance;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UnixDB2Instance createUnixDB2Instance() {
		UnixDB2InstanceImpl unixDB2Instance = new UnixDB2InstanceImpl();
		return unixDB2Instance;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UnixDB2System createUnixDB2System() {
		UnixDB2SystemImpl unixDB2System = new UnixDB2SystemImpl();
		return unixDB2System;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsDB2AdminServer createWindowsDB2AdminServer() {
		WindowsDB2AdminServerImpl windowsDB2AdminServer = new WindowsDB2AdminServerImpl();
		return windowsDB2AdminServer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsDB2ClientInstance createWindowsDB2ClientInstance() {
		WindowsDB2ClientInstanceImpl windowsDB2ClientInstance = new WindowsDB2ClientInstanceImpl();
		return windowsDB2ClientInstance;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsDB2Instance createWindowsDB2Instance() {
		WindowsDB2InstanceImpl windowsDB2Instance = new WindowsDB2InstanceImpl();
		return windowsDB2Instance;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsDB2System createWindowsDB2System() {
		WindowsDB2SystemImpl windowsDB2System = new WindowsDB2SystemImpl();
		return windowsDB2System;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AuthenticationTypeType createAuthenticationTypeTypeFromString(EDataType eDataType,
			String initialValue) {
		AuthenticationTypeType result = AuthenticationTypeType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAuthenticationTypeTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2InstancePortNames createDB2InstancePortNamesFromString(EDataType eDataType,
			String initialValue) {
		DB2InstancePortNames result = DB2InstancePortNames.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDB2InstancePortNamesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PageSizeType createPageSizeTypeFromString(EDataType eDataType, String initialValue) {
		PageSizeType result = PageSizeType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPageSizeTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UnixInstanceTypeType createUnixInstanceTypeTypeFromString(EDataType eDataType,
			String initialValue) {
		UnixInstanceTypeType result = UnixInstanceTypeType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUnixInstanceTypeTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsInstanceTypeType createWindowsInstanceTypeTypeFromString(EDataType eDataType,
			String initialValue) {
		WindowsInstanceTypeType result = WindowsInstanceTypeType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWindowsInstanceTypeTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WordWidthType createWordWidthTypeFromString(EDataType eDataType, String initialValue) {
		WordWidthType result = WordWidthType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWordWidthTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AuthenticationTypeType createAuthenticationTypeTypeObjectFromString(EDataType eDataType,
			String initialValue) {
		return createAuthenticationTypeTypeFromString(Db2Package.Literals.AUTHENTICATION_TYPE_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAuthenticationTypeTypeObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertAuthenticationTypeTypeToString(Db2Package.Literals.AUTHENTICATION_TYPE_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DB2InstancePortNames createDB2InstancePortNamesObjectFromString(EDataType eDataType,
			String initialValue) {
		return createDB2InstancePortNamesFromString(Db2Package.Literals.DB2_INSTANCE_PORT_NAMES, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDB2InstancePortNamesObjectToString(EDataType eDataType, Object instanceValue) {
		return convertDB2InstancePortNamesToString(Db2Package.Literals.DB2_INSTANCE_PORT_NAMES, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PageSizeType createPageSizeTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createPageSizeTypeFromString(Db2Package.Literals.PAGE_SIZE_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPageSizeTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertPageSizeTypeToString(Db2Package.Literals.PAGE_SIZE_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UnixInstanceTypeType createUnixInstanceTypeTypeObjectFromString(EDataType eDataType,
			String initialValue) {
		return createUnixInstanceTypeTypeFromString(Db2Package.Literals.UNIX_INSTANCE_TYPE_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUnixInstanceTypeTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertUnixInstanceTypeTypeToString(Db2Package.Literals.UNIX_INSTANCE_TYPE_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WindowsInstanceTypeType createWindowsInstanceTypeTypeObjectFromString(
			EDataType eDataType, String initialValue) {
		return createWindowsInstanceTypeTypeFromString(Db2Package.Literals.WINDOWS_INSTANCE_TYPE_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWindowsInstanceTypeTypeObjectToString(EDataType eDataType,
			Object instanceValue) {
		return convertWindowsInstanceTypeTypeToString(Db2Package.Literals.WINDOWS_INSTANCE_TYPE_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public WordWidthType createWordWidthTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createWordWidthTypeFromString(Db2Package.Literals.WORD_WIDTH_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWordWidthTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertWordWidthTypeToString(Db2Package.Literals.WORD_WIDTH_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Db2Package getDb2Package() {
		return (Db2Package)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static Db2Package getPackage() {
		return Db2Package.eINSTANCE;
	}

} //Db2FactoryImpl
