/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.java;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>JVM Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Java Virtual Machine settings
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.JVMConfig#getBootClasspath <em>Boot Classpath</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.JVMConfig#getClasspath <em>Classpath</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.JVMConfig#getDebugArgs <em>Debug Args</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.JVMConfig#isDisableJIT <em>Disable JIT</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.JVMConfig#getExecutableJarfileName <em>Executable Jarfile Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.JVMConfig#getGenericJvmArguments <em>Generic Jvm Arguments</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.JVMConfig#getInitialHeapSize <em>Initial Heap Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.JVMConfig#getInternalClassAccessMode <em>Internal Class Access Mode</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.JVMConfig#getMaximumHeapSize <em>Maximum Heap Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.JVMConfig#getRunHProf <em>Run HProf</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.JVMConfig#isVerboseModeClass <em>Verbose Mode Class</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.JVMConfig#isVerboseModeGarbageCollection <em>Verbose Mode Garbage Collection</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.JVMConfig#isVerboseModeJNI <em>Verbose Mode JNI</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJVMConfig()
 * @model extendedMetaData="name='JVMConfig' kind='elementOnly'"
 * @generated
 */
public interface JVMConfig extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Boot Classpath</b></em>' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc --> <!-- begin-model-doc --> Corresponds to the -Xbootclasspath options
	 * to the Java launcher <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Boot Classpath</em>' attribute.
	 * @see #setBootClasspath(String)
	 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJVMConfig_BootClasspath()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='bootClasspath'"
	 * @generated
	 */
	String getBootClasspath();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#getBootClasspath <em>Boot Classpath</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Boot Classpath</em>' attribute.
	 * @see #getBootClasspath()
	 * @generated
	 */
	void setBootClasspath(String value);

	/**
	 * Returns the value of the '<em><b>Classpath</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc --> <!-- begin-model-doc --> Corresponds to the -classpath option to the
	 * Java launcher <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Classpath</em>' attribute.
	 * @see #setClasspath(String)
	 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJVMConfig_Classpath()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='classpath'"
	 * @generated
	 */
	String getClasspath();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#getClasspath <em>Classpath</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classpath</em>' attribute.
	 * @see #getClasspath()
	 * @generated
	 */
	void setClasspath(String value);

	/**
	 * Returns the value of the '<em><b>Debug Args</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc --> <!-- begin-model-doc --> TODO <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Debug Args</em>' attribute.
	 * @see #setDebugArgs(String)
	 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJVMConfig_DebugArgs()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='debugArgs'"
	 * @generated
	 */
	String getDebugArgs();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#getDebugArgs <em>Debug Args</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Debug Args</em>' attribute.
	 * @see #getDebugArgs()
	 * @generated
	 */
	void setDebugArgs(String value);

	/**
	 * Returns the value of the '<em><b>Disable JIT</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc --> <!-- begin-model-doc --> Disable JIT (Just In Time compiler) <!--
	 * end-model-doc -->
	 * 
	 * @return the value of the '<em>Disable JIT</em>' attribute.
	 * @see #isSetDisableJIT()
	 * @see #unsetDisableJIT()
	 * @see #setDisableJIT(boolean)
	 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJVMConfig_DisableJIT()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='disableJIT'"
	 * @generated
	 */
	boolean isDisableJIT();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#isDisableJIT <em>Disable JIT</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Disable JIT</em>' attribute.
	 * @see #isSetDisableJIT()
	 * @see #unsetDisableJIT()
	 * @see #isDisableJIT()
	 * @generated
	 */
	void setDisableJIT(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#isDisableJIT <em>Disable JIT</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetDisableJIT()
	 * @see #isDisableJIT()
	 * @see #setDisableJIT(boolean)
	 * @generated
	 */
	void unsetDisableJIT();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#isDisableJIT <em>Disable JIT</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Disable JIT</em>' attribute is set.
	 * @see #unsetDisableJIT()
	 * @see #isDisableJIT()
	 * @see #setDisableJIT(boolean)
	 * @generated
	 */
	boolean isSetDisableJIT();

	/**
	 * Returns the value of the '<em><b>Executable Jarfile Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> TODO <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Executable Jarfile Name</em>' attribute.
	 * @see #setExecutableJarfileName(String)
	 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJVMConfig_ExecutableJarfileName()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='executableJarfileName'"
	 * @generated
	 */
	String getExecutableJarfileName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#getExecutableJarfileName <em>Executable Jarfile Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Executable Jarfile Name</em>' attribute.
	 * @see #getExecutableJarfileName()
	 * @generated
	 */
	void setExecutableJarfileName(String value);

	/**
	 * Returns the value of the '<em><b>Generic Jvm Arguments</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> Command-line options to be
	 * passed to the Java launcher <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Generic Jvm Arguments</em>' attribute.
	 * @see #setGenericJvmArguments(String)
	 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJVMConfig_GenericJvmArguments()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='genericJvmArguments'"
	 * @generated
	 */
	String getGenericJvmArguments();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#getGenericJvmArguments <em>Generic Jvm Arguments</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generic Jvm Arguments</em>' attribute.
	 * @see #getGenericJvmArguments()
	 * @generated
	 */
	void setGenericJvmArguments(String value);

	/**
	 * Returns the value of the '<em><b>Initial Heap Size</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> Initial heap size;
	 * corresponds to the -Xms&lt;size&gt; option to the Java launcher <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Initial Heap Size</em>' attribute.
	 * @see #isSetInitialHeapSize()
	 * @see #unsetInitialHeapSize()
	 * @see #setInitialHeapSize(int)
	 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJVMConfig_InitialHeapSize()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='initialHeapSize'"
	 * @generated
	 */
	int getInitialHeapSize();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#getInitialHeapSize <em>Initial Heap Size</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Heap Size</em>' attribute.
	 * @see #isSetInitialHeapSize()
	 * @see #unsetInitialHeapSize()
	 * @see #getInitialHeapSize()
	 * @generated
	 */
	void setInitialHeapSize(int value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#getInitialHeapSize <em>Initial Heap Size</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetInitialHeapSize()
	 * @see #getInitialHeapSize()
	 * @see #setInitialHeapSize(int)
	 * @generated
	 */
	void unsetInitialHeapSize();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#getInitialHeapSize <em>Initial Heap Size</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Initial Heap Size</em>' attribute is set.
	 * @see #unsetInitialHeapSize()
	 * @see #getInitialHeapSize()
	 * @see #setInitialHeapSize(int)
	 * @generated
	 */
	boolean isSetInitialHeapSize();

	/**
	 * Returns the value of the '<em><b>Internal Class Access Mode</b></em>' attribute. The
	 * default value is <code>"Allow"</code>. The literals are from the enumeration
	 * {@link com.ibm.ccl.soa.deploy.java.ClassAccessMode}. <!-- begin-user-doc --> <!--
	 * end-user-doc --> <!-- begin-model-doc --> TODO <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Internal Class Access Mode</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.java.ClassAccessMode
	 * @see #isSetInternalClassAccessMode()
	 * @see #unsetInternalClassAccessMode()
	 * @see #setInternalClassAccessMode(ClassAccessMode)
	 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJVMConfig_InternalClassAccessMode()
	 * @model default="Allow" unique="false" unsettable="true" extendedMetaData="kind='attribute'
	 *        name='internalClassAccessMode'"
	 * @generated
	 */
	ClassAccessMode getInternalClassAccessMode();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#getInternalClassAccessMode <em>Internal Class Access Mode</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Internal Class Access Mode</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.java.ClassAccessMode
	 * @see #isSetInternalClassAccessMode()
	 * @see #unsetInternalClassAccessMode()
	 * @see #getInternalClassAccessMode()
	 * @generated
	 */
	void setInternalClassAccessMode(ClassAccessMode value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#getInternalClassAccessMode <em>Internal Class Access Mode</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetInternalClassAccessMode()
	 * @see #getInternalClassAccessMode()
	 * @see #setInternalClassAccessMode(ClassAccessMode)
	 * @generated
	 */
	void unsetInternalClassAccessMode();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#getInternalClassAccessMode <em>Internal Class Access Mode</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Internal Class Access Mode</em>' attribute is set.
	 * @see #unsetInternalClassAccessMode()
	 * @see #getInternalClassAccessMode()
	 * @see #setInternalClassAccessMode(ClassAccessMode)
	 * @generated
	 */
	boolean isSetInternalClassAccessMode();

	/**
	 * Returns the value of the '<em><b>Maximum Heap Size</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> Initial heap size;
	 * corresponds to the -Xmx&lt;size&gt; option to the Java launcher <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Maximum Heap Size</em>' attribute.
	 * @see #isSetMaximumHeapSize()
	 * @see #unsetMaximumHeapSize()
	 * @see #setMaximumHeapSize(int)
	 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJVMConfig_MaximumHeapSize()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='maximumHeapSize'"
	 * @generated
	 */
	int getMaximumHeapSize();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#getMaximumHeapSize <em>Maximum Heap Size</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Heap Size</em>' attribute.
	 * @see #isSetMaximumHeapSize()
	 * @see #unsetMaximumHeapSize()
	 * @see #getMaximumHeapSize()
	 * @generated
	 */
	void setMaximumHeapSize(int value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#getMaximumHeapSize <em>Maximum Heap Size</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetMaximumHeapSize()
	 * @see #getMaximumHeapSize()
	 * @see #setMaximumHeapSize(int)
	 * @generated
	 */
	void unsetMaximumHeapSize();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#getMaximumHeapSize <em>Maximum Heap Size</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Maximum Heap Size</em>' attribute is set.
	 * @see #unsetMaximumHeapSize()
	 * @see #getMaximumHeapSize()
	 * @see #setMaximumHeapSize(int)
	 * @generated
	 */
	boolean isSetMaximumHeapSize();

	/**
	 * Returns the value of the '<em><b>Run HProf</b></em>' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc --> <!-- begin-model-doc --> Corresponds to the -Xrunhprof option to the
	 * Java launcher <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Run HProf</em>' attribute.
	 * @see #setRunHProf(String)
	 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJVMConfig_RunHProf()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='runHProf'"
	 * @generated
	 */
	String getRunHProf();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#getRunHProf <em>Run HProf</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Run HProf</em>' attribute.
	 * @see #getRunHProf()
	 * @generated
	 */
	void setRunHProf(String value);

	/**
	 * Returns the value of the '<em><b>Verbose Mode Class</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> Corresponds to the
	 * -verbose:class option to the Java launcher <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Verbose Mode Class</em>' attribute.
	 * @see #isSetVerboseModeClass()
	 * @see #unsetVerboseModeClass()
	 * @see #setVerboseModeClass(boolean)
	 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJVMConfig_VerboseModeClass()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='verboseModeClass'"
	 * @generated
	 */
	boolean isVerboseModeClass();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#isVerboseModeClass <em>Verbose Mode Class</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Verbose Mode Class</em>' attribute.
	 * @see #isSetVerboseModeClass()
	 * @see #unsetVerboseModeClass()
	 * @see #isVerboseModeClass()
	 * @generated
	 */
	void setVerboseModeClass(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#isVerboseModeClass <em>Verbose Mode Class</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetVerboseModeClass()
	 * @see #isVerboseModeClass()
	 * @see #setVerboseModeClass(boolean)
	 * @generated
	 */
	void unsetVerboseModeClass();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#isVerboseModeClass <em>Verbose Mode Class</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Verbose Mode Class</em>' attribute is set.
	 * @see #unsetVerboseModeClass()
	 * @see #isVerboseModeClass()
	 * @see #setVerboseModeClass(boolean)
	 * @generated
	 */
	boolean isSetVerboseModeClass();

	/**
	 * Returns the value of the '<em><b>Verbose Mode Garbage Collection</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> Corresponds to the
	 * -verbose:gc option to the Java launcher <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Verbose Mode Garbage Collection</em>' attribute.
	 * @see #isSetVerboseModeGarbageCollection()
	 * @see #unsetVerboseModeGarbageCollection()
	 * @see #setVerboseModeGarbageCollection(boolean)
	 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJVMConfig_VerboseModeGarbageCollection()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='verboseModeGarbageCollection'"
	 * @generated
	 */
	boolean isVerboseModeGarbageCollection();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#isVerboseModeGarbageCollection <em>Verbose Mode Garbage Collection</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Verbose Mode Garbage Collection</em>' attribute.
	 * @see #isSetVerboseModeGarbageCollection()
	 * @see #unsetVerboseModeGarbageCollection()
	 * @see #isVerboseModeGarbageCollection()
	 * @generated
	 */
	void setVerboseModeGarbageCollection(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#isVerboseModeGarbageCollection <em>Verbose Mode Garbage Collection</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetVerboseModeGarbageCollection()
	 * @see #isVerboseModeGarbageCollection()
	 * @see #setVerboseModeGarbageCollection(boolean)
	 * @generated
	 */
	void unsetVerboseModeGarbageCollection();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#isVerboseModeGarbageCollection <em>Verbose Mode Garbage Collection</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Verbose Mode Garbage Collection</em>' attribute is set.
	 * @see #unsetVerboseModeGarbageCollection()
	 * @see #isVerboseModeGarbageCollection()
	 * @see #setVerboseModeGarbageCollection(boolean)
	 * @generated
	 */
	boolean isSetVerboseModeGarbageCollection();

	/**
	 * Returns the value of the '<em><b>Verbose Mode JNI</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> Corresponds to the
	 * -verbose:jni option to the Java launcher <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Verbose Mode JNI</em>' attribute.
	 * @see #isSetVerboseModeJNI()
	 * @see #unsetVerboseModeJNI()
	 * @see #setVerboseModeJNI(boolean)
	 * @see com.ibm.ccl.soa.deploy.java.JavaPackage#getJVMConfig_VerboseModeJNI()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='verboseModeJNI'"
	 * @generated
	 */
	boolean isVerboseModeJNI();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#isVerboseModeJNI <em>Verbose Mode JNI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Verbose Mode JNI</em>' attribute.
	 * @see #isSetVerboseModeJNI()
	 * @see #unsetVerboseModeJNI()
	 * @see #isVerboseModeJNI()
	 * @generated
	 */
	void setVerboseModeJNI(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#isVerboseModeJNI <em>Verbose Mode JNI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetVerboseModeJNI()
	 * @see #isVerboseModeJNI()
	 * @see #setVerboseModeJNI(boolean)
	 * @generated
	 */
	void unsetVerboseModeJNI();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.java.JVMConfig#isVerboseModeJNI <em>Verbose Mode JNI</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Verbose Mode JNI</em>' attribute is set.
	 * @see #unsetVerboseModeJNI()
	 * @see #isVerboseModeJNI()
	 * @see #setVerboseModeJNI(boolean)
	 * @generated
	 */
	boolean isSetVerboseModeJNI();

} // JVMConfig
