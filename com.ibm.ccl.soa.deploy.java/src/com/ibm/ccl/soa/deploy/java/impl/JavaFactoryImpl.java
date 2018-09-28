/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.java.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.ibm.ccl.soa.deploy.java.ClassAccessMode;
import com.ibm.ccl.soa.deploy.java.JDK;
import com.ibm.ccl.soa.deploy.java.JDKUnit;
import com.ibm.ccl.soa.deploy.java.JRE;
import com.ibm.ccl.soa.deploy.java.JREEdition;
import com.ibm.ccl.soa.deploy.java.JREUnit;
import com.ibm.ccl.soa.deploy.java.JREVersion;
import com.ibm.ccl.soa.deploy.java.JVMConfig;
import com.ibm.ccl.soa.deploy.java.JavaDeployRoot;
import com.ibm.ccl.soa.deploy.java.JavaFactory;
import com.ibm.ccl.soa.deploy.java.JavaPackage;
import com.ibm.ccl.soa.deploy.java.JdbcProvider;
import com.ibm.ccl.soa.deploy.java.JdbcProviderUnit;
import com.ibm.ccl.soa.deploy.java.JdbcTypeType;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class JavaFactoryImpl extends EFactoryImpl implements JavaFactory {
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
	public static JavaFactory init() {
		try {
			JavaFactory theJavaFactory = (JavaFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.ibm.com/ccl/soa/deploy/java/1.0.0/"); //$NON-NLS-1$ 
			if (theJavaFactory != null) {
				return theJavaFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new JavaFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JavaFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case JavaPackage.JAVA_DEPLOY_ROOT: return (EObject)createJavaDeployRoot();
			case JavaPackage.JDBC_PROVIDER: return createJdbcProvider();
			case JavaPackage.JDBC_PROVIDER_UNIT: return createJdbcProviderUnit();
			case JavaPackage.JDK: return createJDK();
			case JavaPackage.JDK_UNIT: return createJDKUnit();
			case JavaPackage.JRE: return createJRE();
			case JavaPackage.JRE_UNIT: return createJREUnit();
			case JavaPackage.JVM_CONFIG: return createJVMConfig();
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
			case JavaPackage.CLASS_ACCESS_MODE:
				return createClassAccessModeFromString(eDataType, initialValue);
			case JavaPackage.JDBC_TYPE_TYPE:
				return createJdbcTypeTypeFromString(eDataType, initialValue);
			case JavaPackage.JRE_EDITION:
				return createJREEditionFromString(eDataType, initialValue);
			case JavaPackage.JRE_VERSION:
				return createJREVersionFromString(eDataType, initialValue);
			case JavaPackage.CLASS_ACCESS_MODE_OBJECT:
				return createClassAccessModeObjectFromString(eDataType, initialValue);
			case JavaPackage.JDBC_TYPE_TYPE_OBJECT:
				return createJdbcTypeTypeObjectFromString(eDataType, initialValue);
			case JavaPackage.JRE_EDITION_OBJECT:
				return createJREEditionObjectFromString(eDataType, initialValue);
			case JavaPackage.JRE_VERSION_OBJECT:
				return createJREVersionObjectFromString(eDataType, initialValue);
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
			case JavaPackage.CLASS_ACCESS_MODE:
				return convertClassAccessModeToString(eDataType, instanceValue);
			case JavaPackage.JDBC_TYPE_TYPE:
				return convertJdbcTypeTypeToString(eDataType, instanceValue);
			case JavaPackage.JRE_EDITION:
				return convertJREEditionToString(eDataType, instanceValue);
			case JavaPackage.JRE_VERSION:
				return convertJREVersionToString(eDataType, instanceValue);
			case JavaPackage.CLASS_ACCESS_MODE_OBJECT:
				return convertClassAccessModeObjectToString(eDataType, instanceValue);
			case JavaPackage.JDBC_TYPE_TYPE_OBJECT:
				return convertJdbcTypeTypeObjectToString(eDataType, instanceValue);
			case JavaPackage.JRE_EDITION_OBJECT:
				return convertJREEditionObjectToString(eDataType, instanceValue);
			case JavaPackage.JRE_VERSION_OBJECT:
				return convertJREVersionObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JavaDeployRoot createJavaDeployRoot() {
		JavaDeployRootImpl javaDeployRoot = new JavaDeployRootImpl();
		return javaDeployRoot;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JdbcProvider createJdbcProvider() {
		JdbcProviderImpl jdbcProvider = new JdbcProviderImpl();
		return jdbcProvider;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JdbcProviderUnit createJdbcProviderUnit() {
		JdbcProviderUnitImpl jdbcProviderUnit = new JdbcProviderUnitImpl();
		return jdbcProviderUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JDK createJDK() {
		JDKImpl jdk = new JDKImpl();
		return jdk;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JDKUnit createJDKUnit() {
		JDKUnitImpl jdkUnit = new JDKUnitImpl();
		return jdkUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JRE createJRE() {
		JREImpl jre = new JREImpl();
		return jre;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JREUnit createJREUnit() {
		JREUnitImpl jreUnit = new JREUnitImpl();
		return jreUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JVMConfig createJVMConfig() {
		JVMConfigImpl jvmConfig = new JVMConfigImpl();
		return jvmConfig;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ClassAccessMode createClassAccessModeFromString(EDataType eDataType, String initialValue) {
		ClassAccessMode result = ClassAccessMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertClassAccessModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JdbcTypeType createJdbcTypeTypeFromString(EDataType eDataType, String initialValue) {
		JdbcTypeType result = JdbcTypeType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJdbcTypeTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JREEdition createJREEditionFromString(EDataType eDataType, String initialValue) {
		JREEdition result = JREEdition.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJREEditionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JREVersion createJREVersionFromString(EDataType eDataType, String initialValue) {
		JREVersion result = JREVersion.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJREVersionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ClassAccessMode createClassAccessModeObjectFromString(EDataType eDataType,
			String initialValue) {
		return createClassAccessModeFromString(JavaPackage.Literals.CLASS_ACCESS_MODE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertClassAccessModeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertClassAccessModeToString(JavaPackage.Literals.CLASS_ACCESS_MODE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JdbcTypeType createJdbcTypeTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createJdbcTypeTypeFromString(JavaPackage.Literals.JDBC_TYPE_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJdbcTypeTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertJdbcTypeTypeToString(JavaPackage.Literals.JDBC_TYPE_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JREEdition createJREEditionObjectFromString(EDataType eDataType, String initialValue) {
		return createJREEditionFromString(JavaPackage.Literals.JRE_EDITION, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJREEditionObjectToString(EDataType eDataType, Object instanceValue) {
		return convertJREEditionToString(JavaPackage.Literals.JRE_EDITION, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JREVersion createJREVersionObjectFromString(EDataType eDataType, String initialValue) {
		return createJREVersionFromString(JavaPackage.Literals.JRE_VERSION, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertJREVersionObjectToString(EDataType eDataType, Object instanceValue) {
		return convertJREVersionToString(JavaPackage.Literals.JRE_VERSION, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JavaPackage getJavaPackage() {
		return (JavaPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static JavaPackage getPackage() {
		return JavaPackage.eINSTANCE;
	}

} //JavaFactoryImpl
