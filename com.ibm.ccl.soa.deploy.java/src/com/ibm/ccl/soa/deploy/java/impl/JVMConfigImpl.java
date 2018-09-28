/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.java.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.java.ClassAccessMode;
import com.ibm.ccl.soa.deploy.java.JVMConfig;
import com.ibm.ccl.soa.deploy.java.JavaPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>JVM Config</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.impl.JVMConfigImpl#getBootClasspath <em>Boot Classpath</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.impl.JVMConfigImpl#getClasspath <em>Classpath</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.impl.JVMConfigImpl#getDebugArgs <em>Debug Args</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.impl.JVMConfigImpl#isDisableJIT <em>Disable JIT</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.impl.JVMConfigImpl#getExecutableJarfileName <em>Executable Jarfile Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.impl.JVMConfigImpl#getGenericJvmArguments <em>Generic Jvm Arguments</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.impl.JVMConfigImpl#getInitialHeapSize <em>Initial Heap Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.impl.JVMConfigImpl#getInternalClassAccessMode <em>Internal Class Access Mode</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.impl.JVMConfigImpl#getMaximumHeapSize <em>Maximum Heap Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.impl.JVMConfigImpl#getRunHProf <em>Run HProf</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.impl.JVMConfigImpl#isVerboseModeClass <em>Verbose Mode Class</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.impl.JVMConfigImpl#isVerboseModeGarbageCollection <em>Verbose Mode Garbage Collection</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.java.impl.JVMConfigImpl#isVerboseModeJNI <em>Verbose Mode JNI</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JVMConfigImpl extends CapabilityImpl implements JVMConfig {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getBootClasspath() <em>Boot Classpath</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getBootClasspath()
	 * @generated
	 * @ordered
	 */
	protected static final String BOOT_CLASSPATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBootClasspath() <em>Boot Classpath</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getBootClasspath()
	 * @generated
	 * @ordered
	 */
	protected String bootClasspath = BOOT_CLASSPATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getClasspath() <em>Classpath</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getClasspath()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASSPATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClasspath() <em>Classpath</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getClasspath()
	 * @generated
	 * @ordered
	 */
	protected String classpath = CLASSPATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getDebugArgs() <em>Debug Args</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDebugArgs()
	 * @generated
	 * @ordered
	 */
	protected static final String DEBUG_ARGS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDebugArgs() <em>Debug Args</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDebugArgs()
	 * @generated
	 * @ordered
	 */
	protected String debugArgs = DEBUG_ARGS_EDEFAULT;

	/**
	 * The default value of the '{@link #isDisableJIT() <em>Disable JIT</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isDisableJIT()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DISABLE_JIT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDisableJIT() <em>Disable JIT</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isDisableJIT()
	 * @generated
	 * @ordered
	 */
	protected boolean disableJIT = DISABLE_JIT_EDEFAULT;

	/**
	 * This is true if the Disable JIT attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean disableJITESet;

	/**
	 * The default value of the '{@link #getExecutableJarfileName() <em>Executable Jarfile Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getExecutableJarfileName()
	 * @generated
	 * @ordered
	 */
	protected static final String EXECUTABLE_JARFILE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExecutableJarfileName() <em>Executable Jarfile Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getExecutableJarfileName()
	 * @generated
	 * @ordered
	 */
	protected String executableJarfileName = EXECUTABLE_JARFILE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getGenericJvmArguments() <em>Generic Jvm Arguments</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getGenericJvmArguments()
	 * @generated
	 * @ordered
	 */
	protected static final String GENERIC_JVM_ARGUMENTS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGenericJvmArguments() <em>Generic Jvm Arguments</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getGenericJvmArguments()
	 * @generated
	 * @ordered
	 */
	protected String genericJvmArguments = GENERIC_JVM_ARGUMENTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getInitialHeapSize() <em>Initial Heap Size</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInitialHeapSize()
	 * @generated
	 * @ordered
	 */
	protected static final int INITIAL_HEAP_SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getInitialHeapSize() <em>Initial Heap Size</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInitialHeapSize()
	 * @generated
	 * @ordered
	 */
	protected int initialHeapSize = INITIAL_HEAP_SIZE_EDEFAULT;

	/**
	 * This is true if the Initial Heap Size attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean initialHeapSizeESet;

	/**
	 * The default value of the '{@link #getInternalClassAccessMode() <em>Internal Class Access Mode</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInternalClassAccessMode()
	 * @generated
	 * @ordered
	 */
	protected static final ClassAccessMode INTERNAL_CLASS_ACCESS_MODE_EDEFAULT = ClassAccessMode.ALLOW_LITERAL;

	/**
	 * The cached value of the '{@link #getInternalClassAccessMode() <em>Internal Class Access Mode</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInternalClassAccessMode()
	 * @generated
	 * @ordered
	 */
	protected ClassAccessMode internalClassAccessMode = INTERNAL_CLASS_ACCESS_MODE_EDEFAULT;

	/**
	 * This is true if the Internal Class Access Mode attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean internalClassAccessModeESet;

	/**
	 * The default value of the '{@link #getMaximumHeapSize() <em>Maximum Heap Size</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMaximumHeapSize()
	 * @generated
	 * @ordered
	 */
	protected static final int MAXIMUM_HEAP_SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaximumHeapSize() <em>Maximum Heap Size</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMaximumHeapSize()
	 * @generated
	 * @ordered
	 */
	protected int maximumHeapSize = MAXIMUM_HEAP_SIZE_EDEFAULT;

	/**
	 * This is true if the Maximum Heap Size attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean maximumHeapSizeESet;

	/**
	 * The default value of the '{@link #getRunHProf() <em>Run HProf</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRunHProf()
	 * @generated
	 * @ordered
	 */
	protected static final String RUN_HPROF_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRunHProf() <em>Run HProf</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRunHProf()
	 * @generated
	 * @ordered
	 */
	protected String runHProf = RUN_HPROF_EDEFAULT;

	/**
	 * The default value of the '{@link #isVerboseModeClass() <em>Verbose Mode Class</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isVerboseModeClass()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VERBOSE_MODE_CLASS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isVerboseModeClass() <em>Verbose Mode Class</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isVerboseModeClass()
	 * @generated
	 * @ordered
	 */
	protected boolean verboseModeClass = VERBOSE_MODE_CLASS_EDEFAULT;

	/**
	 * This is true if the Verbose Mode Class attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean verboseModeClassESet;

	/**
	 * The default value of the '{@link #isVerboseModeGarbageCollection() <em>Verbose Mode Garbage Collection</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isVerboseModeGarbageCollection()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VERBOSE_MODE_GARBAGE_COLLECTION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isVerboseModeGarbageCollection() <em>Verbose Mode Garbage Collection</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isVerboseModeGarbageCollection()
	 * @generated
	 * @ordered
	 */
	protected boolean verboseModeGarbageCollection = VERBOSE_MODE_GARBAGE_COLLECTION_EDEFAULT;

	/**
	 * This is true if the Verbose Mode Garbage Collection attribute has been set. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean verboseModeGarbageCollectionESet;

	/**
	 * The default value of the '{@link #isVerboseModeJNI() <em>Verbose Mode JNI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isVerboseModeJNI()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VERBOSE_MODE_JNI_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isVerboseModeJNI() <em>Verbose Mode JNI</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isVerboseModeJNI()
	 * @generated
	 * @ordered
	 */
	protected boolean verboseModeJNI = VERBOSE_MODE_JNI_EDEFAULT;

	/**
	 * This is true if the Verbose Mode JNI attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean verboseModeJNIESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected JVMConfigImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return JavaPackage.Literals.JVM_CONFIG;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getBootClasspath() {
		return bootClasspath;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBootClasspath(String newBootClasspath) {
		String oldBootClasspath = bootClasspath;
		bootClasspath = newBootClasspath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JVM_CONFIG__BOOT_CLASSPATH, oldBootClasspath, bootClasspath));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getClasspath() {
		return classpath;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setClasspath(String newClasspath) {
		String oldClasspath = classpath;
		classpath = newClasspath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JVM_CONFIG__CLASSPATH, oldClasspath, classpath));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDebugArgs() {
		return debugArgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDebugArgs(String newDebugArgs) {
		String oldDebugArgs = debugArgs;
		debugArgs = newDebugArgs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JVM_CONFIG__DEBUG_ARGS, oldDebugArgs, debugArgs));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDisableJIT() {
		return disableJIT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisableJIT(boolean newDisableJIT) {
		boolean oldDisableJIT = disableJIT;
		disableJIT = newDisableJIT;
		boolean oldDisableJITESet = disableJITESet;
		disableJITESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JVM_CONFIG__DISABLE_JIT, oldDisableJIT, disableJIT, !oldDisableJITESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDisableJIT() {
		boolean oldDisableJIT = disableJIT;
		boolean oldDisableJITESet = disableJITESet;
		disableJIT = DISABLE_JIT_EDEFAULT;
		disableJITESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, JavaPackage.JVM_CONFIG__DISABLE_JIT, oldDisableJIT, DISABLE_JIT_EDEFAULT, oldDisableJITESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDisableJIT() {
		return disableJITESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getExecutableJarfileName() {
		return executableJarfileName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecutableJarfileName(String newExecutableJarfileName) {
		String oldExecutableJarfileName = executableJarfileName;
		executableJarfileName = newExecutableJarfileName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JVM_CONFIG__EXECUTABLE_JARFILE_NAME, oldExecutableJarfileName, executableJarfileName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getGenericJvmArguments() {
		return genericJvmArguments;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setGenericJvmArguments(String newGenericJvmArguments) {
		String oldGenericJvmArguments = genericJvmArguments;
		genericJvmArguments = newGenericJvmArguments;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JVM_CONFIG__GENERIC_JVM_ARGUMENTS, oldGenericJvmArguments, genericJvmArguments));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getInitialHeapSize() {
		return initialHeapSize;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialHeapSize(int newInitialHeapSize) {
		int oldInitialHeapSize = initialHeapSize;
		initialHeapSize = newInitialHeapSize;
		boolean oldInitialHeapSizeESet = initialHeapSizeESet;
		initialHeapSizeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JVM_CONFIG__INITIAL_HEAP_SIZE, oldInitialHeapSize, initialHeapSize, !oldInitialHeapSizeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetInitialHeapSize() {
		int oldInitialHeapSize = initialHeapSize;
		boolean oldInitialHeapSizeESet = initialHeapSizeESet;
		initialHeapSize = INITIAL_HEAP_SIZE_EDEFAULT;
		initialHeapSizeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, JavaPackage.JVM_CONFIG__INITIAL_HEAP_SIZE, oldInitialHeapSize, INITIAL_HEAP_SIZE_EDEFAULT, oldInitialHeapSizeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInitialHeapSize() {
		return initialHeapSizeESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ClassAccessMode getInternalClassAccessMode() {
		return internalClassAccessMode;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setInternalClassAccessMode(ClassAccessMode newInternalClassAccessMode) {
		ClassAccessMode oldInternalClassAccessMode = internalClassAccessMode;
		internalClassAccessMode = newInternalClassAccessMode == null ? INTERNAL_CLASS_ACCESS_MODE_EDEFAULT : newInternalClassAccessMode;
		boolean oldInternalClassAccessModeESet = internalClassAccessModeESet;
		internalClassAccessModeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JVM_CONFIG__INTERNAL_CLASS_ACCESS_MODE, oldInternalClassAccessMode, internalClassAccessMode, !oldInternalClassAccessModeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetInternalClassAccessMode() {
		ClassAccessMode oldInternalClassAccessMode = internalClassAccessMode;
		boolean oldInternalClassAccessModeESet = internalClassAccessModeESet;
		internalClassAccessMode = INTERNAL_CLASS_ACCESS_MODE_EDEFAULT;
		internalClassAccessModeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, JavaPackage.JVM_CONFIG__INTERNAL_CLASS_ACCESS_MODE, oldInternalClassAccessMode, INTERNAL_CLASS_ACCESS_MODE_EDEFAULT, oldInternalClassAccessModeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInternalClassAccessMode() {
		return internalClassAccessModeESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaximumHeapSize() {
		return maximumHeapSize;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumHeapSize(int newMaximumHeapSize) {
		int oldMaximumHeapSize = maximumHeapSize;
		maximumHeapSize = newMaximumHeapSize;
		boolean oldMaximumHeapSizeESet = maximumHeapSizeESet;
		maximumHeapSizeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JVM_CONFIG__MAXIMUM_HEAP_SIZE, oldMaximumHeapSize, maximumHeapSize, !oldMaximumHeapSizeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMaximumHeapSize() {
		int oldMaximumHeapSize = maximumHeapSize;
		boolean oldMaximumHeapSizeESet = maximumHeapSizeESet;
		maximumHeapSize = MAXIMUM_HEAP_SIZE_EDEFAULT;
		maximumHeapSizeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, JavaPackage.JVM_CONFIG__MAXIMUM_HEAP_SIZE, oldMaximumHeapSize, MAXIMUM_HEAP_SIZE_EDEFAULT, oldMaximumHeapSizeESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMaximumHeapSize() {
		return maximumHeapSizeESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getRunHProf() {
		return runHProf;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRunHProf(String newRunHProf) {
		String oldRunHProf = runHProf;
		runHProf = newRunHProf;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JVM_CONFIG__RUN_HPROF, oldRunHProf, runHProf));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isVerboseModeClass() {
		return verboseModeClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setVerboseModeClass(boolean newVerboseModeClass) {
		boolean oldVerboseModeClass = verboseModeClass;
		verboseModeClass = newVerboseModeClass;
		boolean oldVerboseModeClassESet = verboseModeClassESet;
		verboseModeClassESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JVM_CONFIG__VERBOSE_MODE_CLASS, oldVerboseModeClass, verboseModeClass, !oldVerboseModeClassESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVerboseModeClass() {
		boolean oldVerboseModeClass = verboseModeClass;
		boolean oldVerboseModeClassESet = verboseModeClassESet;
		verboseModeClass = VERBOSE_MODE_CLASS_EDEFAULT;
		verboseModeClassESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, JavaPackage.JVM_CONFIG__VERBOSE_MODE_CLASS, oldVerboseModeClass, VERBOSE_MODE_CLASS_EDEFAULT, oldVerboseModeClassESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVerboseModeClass() {
		return verboseModeClassESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isVerboseModeGarbageCollection() {
		return verboseModeGarbageCollection;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setVerboseModeGarbageCollection(boolean newVerboseModeGarbageCollection) {
		boolean oldVerboseModeGarbageCollection = verboseModeGarbageCollection;
		verboseModeGarbageCollection = newVerboseModeGarbageCollection;
		boolean oldVerboseModeGarbageCollectionESet = verboseModeGarbageCollectionESet;
		verboseModeGarbageCollectionESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JVM_CONFIG__VERBOSE_MODE_GARBAGE_COLLECTION, oldVerboseModeGarbageCollection, verboseModeGarbageCollection, !oldVerboseModeGarbageCollectionESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVerboseModeGarbageCollection() {
		boolean oldVerboseModeGarbageCollection = verboseModeGarbageCollection;
		boolean oldVerboseModeGarbageCollectionESet = verboseModeGarbageCollectionESet;
		verboseModeGarbageCollection = VERBOSE_MODE_GARBAGE_COLLECTION_EDEFAULT;
		verboseModeGarbageCollectionESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, JavaPackage.JVM_CONFIG__VERBOSE_MODE_GARBAGE_COLLECTION, oldVerboseModeGarbageCollection, VERBOSE_MODE_GARBAGE_COLLECTION_EDEFAULT, oldVerboseModeGarbageCollectionESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVerboseModeGarbageCollection() {
		return verboseModeGarbageCollectionESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isVerboseModeJNI() {
		return verboseModeJNI;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setVerboseModeJNI(boolean newVerboseModeJNI) {
		boolean oldVerboseModeJNI = verboseModeJNI;
		verboseModeJNI = newVerboseModeJNI;
		boolean oldVerboseModeJNIESet = verboseModeJNIESet;
		verboseModeJNIESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavaPackage.JVM_CONFIG__VERBOSE_MODE_JNI, oldVerboseModeJNI, verboseModeJNI, !oldVerboseModeJNIESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVerboseModeJNI() {
		boolean oldVerboseModeJNI = verboseModeJNI;
		boolean oldVerboseModeJNIESet = verboseModeJNIESet;
		verboseModeJNI = VERBOSE_MODE_JNI_EDEFAULT;
		verboseModeJNIESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, JavaPackage.JVM_CONFIG__VERBOSE_MODE_JNI, oldVerboseModeJNI, VERBOSE_MODE_JNI_EDEFAULT, oldVerboseModeJNIESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVerboseModeJNI() {
		return verboseModeJNIESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JavaPackage.JVM_CONFIG__BOOT_CLASSPATH:
				return getBootClasspath();
			case JavaPackage.JVM_CONFIG__CLASSPATH:
				return getClasspath();
			case JavaPackage.JVM_CONFIG__DEBUG_ARGS:
				return getDebugArgs();
			case JavaPackage.JVM_CONFIG__DISABLE_JIT:
				return isDisableJIT() ? Boolean.TRUE : Boolean.FALSE;
			case JavaPackage.JVM_CONFIG__EXECUTABLE_JARFILE_NAME:
				return getExecutableJarfileName();
			case JavaPackage.JVM_CONFIG__GENERIC_JVM_ARGUMENTS:
				return getGenericJvmArguments();
			case JavaPackage.JVM_CONFIG__INITIAL_HEAP_SIZE:
				return new Integer(getInitialHeapSize());
			case JavaPackage.JVM_CONFIG__INTERNAL_CLASS_ACCESS_MODE:
				return getInternalClassAccessMode();
			case JavaPackage.JVM_CONFIG__MAXIMUM_HEAP_SIZE:
				return new Integer(getMaximumHeapSize());
			case JavaPackage.JVM_CONFIG__RUN_HPROF:
				return getRunHProf();
			case JavaPackage.JVM_CONFIG__VERBOSE_MODE_CLASS:
				return isVerboseModeClass() ? Boolean.TRUE : Boolean.FALSE;
			case JavaPackage.JVM_CONFIG__VERBOSE_MODE_GARBAGE_COLLECTION:
				return isVerboseModeGarbageCollection() ? Boolean.TRUE : Boolean.FALSE;
			case JavaPackage.JVM_CONFIG__VERBOSE_MODE_JNI:
				return isVerboseModeJNI() ? Boolean.TRUE : Boolean.FALSE;
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case JavaPackage.JVM_CONFIG__BOOT_CLASSPATH:
				setBootClasspath((String)newValue);
				return;
			case JavaPackage.JVM_CONFIG__CLASSPATH:
				setClasspath((String)newValue);
				return;
			case JavaPackage.JVM_CONFIG__DEBUG_ARGS:
				setDebugArgs((String)newValue);
				return;
			case JavaPackage.JVM_CONFIG__DISABLE_JIT:
				setDisableJIT(((Boolean)newValue).booleanValue());
				return;
			case JavaPackage.JVM_CONFIG__EXECUTABLE_JARFILE_NAME:
				setExecutableJarfileName((String)newValue);
				return;
			case JavaPackage.JVM_CONFIG__GENERIC_JVM_ARGUMENTS:
				setGenericJvmArguments((String)newValue);
				return;
			case JavaPackage.JVM_CONFIG__INITIAL_HEAP_SIZE:
				setInitialHeapSize(((Integer)newValue).intValue());
				return;
			case JavaPackage.JVM_CONFIG__INTERNAL_CLASS_ACCESS_MODE:
				setInternalClassAccessMode((ClassAccessMode)newValue);
				return;
			case JavaPackage.JVM_CONFIG__MAXIMUM_HEAP_SIZE:
				setMaximumHeapSize(((Integer)newValue).intValue());
				return;
			case JavaPackage.JVM_CONFIG__RUN_HPROF:
				setRunHProf((String)newValue);
				return;
			case JavaPackage.JVM_CONFIG__VERBOSE_MODE_CLASS:
				setVerboseModeClass(((Boolean)newValue).booleanValue());
				return;
			case JavaPackage.JVM_CONFIG__VERBOSE_MODE_GARBAGE_COLLECTION:
				setVerboseModeGarbageCollection(((Boolean)newValue).booleanValue());
				return;
			case JavaPackage.JVM_CONFIG__VERBOSE_MODE_JNI:
				setVerboseModeJNI(((Boolean)newValue).booleanValue());
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
			case JavaPackage.JVM_CONFIG__BOOT_CLASSPATH:
				setBootClasspath(BOOT_CLASSPATH_EDEFAULT);
				return;
			case JavaPackage.JVM_CONFIG__CLASSPATH:
				setClasspath(CLASSPATH_EDEFAULT);
				return;
			case JavaPackage.JVM_CONFIG__DEBUG_ARGS:
				setDebugArgs(DEBUG_ARGS_EDEFAULT);
				return;
			case JavaPackage.JVM_CONFIG__DISABLE_JIT:
				unsetDisableJIT();
				return;
			case JavaPackage.JVM_CONFIG__EXECUTABLE_JARFILE_NAME:
				setExecutableJarfileName(EXECUTABLE_JARFILE_NAME_EDEFAULT);
				return;
			case JavaPackage.JVM_CONFIG__GENERIC_JVM_ARGUMENTS:
				setGenericJvmArguments(GENERIC_JVM_ARGUMENTS_EDEFAULT);
				return;
			case JavaPackage.JVM_CONFIG__INITIAL_HEAP_SIZE:
				unsetInitialHeapSize();
				return;
			case JavaPackage.JVM_CONFIG__INTERNAL_CLASS_ACCESS_MODE:
				unsetInternalClassAccessMode();
				return;
			case JavaPackage.JVM_CONFIG__MAXIMUM_HEAP_SIZE:
				unsetMaximumHeapSize();
				return;
			case JavaPackage.JVM_CONFIG__RUN_HPROF:
				setRunHProf(RUN_HPROF_EDEFAULT);
				return;
			case JavaPackage.JVM_CONFIG__VERBOSE_MODE_CLASS:
				unsetVerboseModeClass();
				return;
			case JavaPackage.JVM_CONFIG__VERBOSE_MODE_GARBAGE_COLLECTION:
				unsetVerboseModeGarbageCollection();
				return;
			case JavaPackage.JVM_CONFIG__VERBOSE_MODE_JNI:
				unsetVerboseModeJNI();
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
			case JavaPackage.JVM_CONFIG__BOOT_CLASSPATH:
				return BOOT_CLASSPATH_EDEFAULT == null ? bootClasspath != null : !BOOT_CLASSPATH_EDEFAULT.equals(bootClasspath);
			case JavaPackage.JVM_CONFIG__CLASSPATH:
				return CLASSPATH_EDEFAULT == null ? classpath != null : !CLASSPATH_EDEFAULT.equals(classpath);
			case JavaPackage.JVM_CONFIG__DEBUG_ARGS:
				return DEBUG_ARGS_EDEFAULT == null ? debugArgs != null : !DEBUG_ARGS_EDEFAULT.equals(debugArgs);
			case JavaPackage.JVM_CONFIG__DISABLE_JIT:
				return isSetDisableJIT();
			case JavaPackage.JVM_CONFIG__EXECUTABLE_JARFILE_NAME:
				return EXECUTABLE_JARFILE_NAME_EDEFAULT == null ? executableJarfileName != null : !EXECUTABLE_JARFILE_NAME_EDEFAULT.equals(executableJarfileName);
			case JavaPackage.JVM_CONFIG__GENERIC_JVM_ARGUMENTS:
				return GENERIC_JVM_ARGUMENTS_EDEFAULT == null ? genericJvmArguments != null : !GENERIC_JVM_ARGUMENTS_EDEFAULT.equals(genericJvmArguments);
			case JavaPackage.JVM_CONFIG__INITIAL_HEAP_SIZE:
				return isSetInitialHeapSize();
			case JavaPackage.JVM_CONFIG__INTERNAL_CLASS_ACCESS_MODE:
				return isSetInternalClassAccessMode();
			case JavaPackage.JVM_CONFIG__MAXIMUM_HEAP_SIZE:
				return isSetMaximumHeapSize();
			case JavaPackage.JVM_CONFIG__RUN_HPROF:
				return RUN_HPROF_EDEFAULT == null ? runHProf != null : !RUN_HPROF_EDEFAULT.equals(runHProf);
			case JavaPackage.JVM_CONFIG__VERBOSE_MODE_CLASS:
				return isSetVerboseModeClass();
			case JavaPackage.JVM_CONFIG__VERBOSE_MODE_GARBAGE_COLLECTION:
				return isSetVerboseModeGarbageCollection();
			case JavaPackage.JVM_CONFIG__VERBOSE_MODE_JNI:
				return isSetVerboseModeJNI();
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
		result.append(" (bootClasspath: "); //$NON-NLS-1$
		result.append(bootClasspath);
		result.append(", classpath: "); //$NON-NLS-1$
		result.append(classpath);
		result.append(", debugArgs: "); //$NON-NLS-1$
		result.append(debugArgs);
		result.append(", disableJIT: "); //$NON-NLS-1$
		if (disableJITESet) result.append(disableJIT); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", executableJarfileName: "); //$NON-NLS-1$
		result.append(executableJarfileName);
		result.append(", genericJvmArguments: "); //$NON-NLS-1$
		result.append(genericJvmArguments);
		result.append(", initialHeapSize: "); //$NON-NLS-1$
		if (initialHeapSizeESet) result.append(initialHeapSize); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", internalClassAccessMode: "); //$NON-NLS-1$
		if (internalClassAccessModeESet) result.append(internalClassAccessMode); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", maximumHeapSize: "); //$NON-NLS-1$
		if (maximumHeapSizeESet) result.append(maximumHeapSize); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", runHProf: "); //$NON-NLS-1$
		result.append(runHProf);
		result.append(", verboseModeClass: "); //$NON-NLS-1$
		if (verboseModeClassESet) result.append(verboseModeClass); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", verboseModeGarbageCollection: "); //$NON-NLS-1$
		if (verboseModeGarbageCollectionESet) result.append(verboseModeGarbageCollection); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", verboseModeJNI: "); //$NON-NLS-1$
		if (verboseModeJNIESet) result.append(verboseModeJNI); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //JVMConfigImpl
