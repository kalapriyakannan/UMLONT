/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.server.impl;

import java.math.BigInteger;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.server.ArchitectureWidthType;
import com.ibm.ccl.soa.deploy.server.ProcessingCapacityUnitsType;
import com.ibm.ccl.soa.deploy.server.Server;
import com.ibm.ccl.soa.deploy.server.ServerPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Server</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.impl.ServerImpl#isAutoStart <em>Auto Start</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.impl.ServerImpl#getCpuArchitecture <em>Cpu Architecture</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.impl.ServerImpl#getCpuCount <em>Cpu Count</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.impl.ServerImpl#getCpuArchitectureWidth <em>Cpu Architecture Width</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.impl.ServerImpl#getCpuCoresInstalled <em>Cpu Cores Installed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.impl.ServerImpl#getCpuDiesInstalled <em>Cpu Dies Installed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.impl.ServerImpl#getCpuManufacturer <em>Cpu Manufacturer</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.impl.ServerImpl#getCpuSpeed <em>Cpu Speed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.impl.ServerImpl#getCpuType <em>Cpu Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.impl.ServerImpl#isIsVMIDanLPAR <em>Is VMI Dan LPAR</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.impl.ServerImpl#getManufacturer <em>Manufacturer</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.impl.ServerImpl#getMemorySize <em>Memory Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.impl.ServerImpl#getModel <em>Model</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.impl.ServerImpl#getPrimaryMACAddress <em>Primary MAC Address</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.impl.ServerImpl#getProcessingCapacity <em>Processing Capacity</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.impl.ServerImpl#getProcessingCapacityUnits <em>Processing Capacity Units</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.impl.ServerImpl#getRomVersion <em>Rom Version</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.impl.ServerImpl#getSerialNumber <em>Serial Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.impl.ServerImpl#getSystemBoardUUID <em>System Board UUID</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.impl.ServerImpl#getSystemId <em>System Id</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.impl.ServerImpl#isVirtual <em>Virtual</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.impl.ServerImpl#getVmid <em>Vmid</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServerImpl extends CapabilityImpl implements Server {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #isAutoStart() <em>Auto Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAutoStart()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AUTO_START_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAutoStart() <em>Auto Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAutoStart()
	 * @generated
	 * @ordered
	 */
	protected boolean autoStart = AUTO_START_EDEFAULT;

	/**
	 * This is true if the Auto Start attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean autoStartESet;

	/**
	 * The default value of the '{@link #getCpuArchitecture() <em>Cpu Architecture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpuArchitecture()
	 * @generated
	 * @ordered
	 */
	protected static final String CPU_ARCHITECTURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCpuArchitecture() <em>Cpu Architecture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpuArchitecture()
	 * @generated
	 * @ordered
	 */
	protected String cpuArchitecture = CPU_ARCHITECTURE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCpuCount() <em>Cpu Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpuCount()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger CPU_COUNT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCpuCount() <em>Cpu Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpuCount()
	 * @generated
	 * @ordered
	 */
	protected BigInteger cpuCount = CPU_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getCpuArchitectureWidth() <em>Cpu Architecture Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpuArchitectureWidth()
	 * @generated
	 * @ordered
	 */
	protected static final ArchitectureWidthType CPU_ARCHITECTURE_WIDTH_EDEFAULT = ArchitectureWidthType._32_BIT_LITERAL;

	/**
	 * The cached value of the '{@link #getCpuArchitectureWidth() <em>Cpu Architecture Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpuArchitectureWidth()
	 * @generated
	 * @ordered
	 */
	protected ArchitectureWidthType cpuArchitectureWidth = CPU_ARCHITECTURE_WIDTH_EDEFAULT;

	/**
	 * This is true if the Cpu Architecture Width attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean cpuArchitectureWidthESet;

	/**
	 * The default value of the '{@link #getCpuCoresInstalled() <em>Cpu Cores Installed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpuCoresInstalled()
	 * @generated
	 * @ordered
	 */
	protected static final int CPU_CORES_INSTALLED_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCpuCoresInstalled() <em>Cpu Cores Installed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpuCoresInstalled()
	 * @generated
	 * @ordered
	 */
	protected int cpuCoresInstalled = CPU_CORES_INSTALLED_EDEFAULT;

	/**
	 * This is true if the Cpu Cores Installed attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean cpuCoresInstalledESet;

	/**
	 * The default value of the '{@link #getCpuDiesInstalled() <em>Cpu Dies Installed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpuDiesInstalled()
	 * @generated
	 * @ordered
	 */
	protected static final int CPU_DIES_INSTALLED_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCpuDiesInstalled() <em>Cpu Dies Installed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpuDiesInstalled()
	 * @generated
	 * @ordered
	 */
	protected int cpuDiesInstalled = CPU_DIES_INSTALLED_EDEFAULT;

	/**
	 * This is true if the Cpu Dies Installed attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean cpuDiesInstalledESet;

	/**
	 * The default value of the '{@link #getCpuManufacturer() <em>Cpu Manufacturer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpuManufacturer()
	 * @generated
	 * @ordered
	 */
	protected static final String CPU_MANUFACTURER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCpuManufacturer() <em>Cpu Manufacturer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpuManufacturer()
	 * @generated
	 * @ordered
	 */
	protected String cpuManufacturer = CPU_MANUFACTURER_EDEFAULT;

	/**
	 * The default value of the '{@link #getCpuSpeed() <em>Cpu Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpuSpeed()
	 * @generated
	 * @ordered
	 */
	protected static final long CPU_SPEED_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getCpuSpeed() <em>Cpu Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpuSpeed()
	 * @generated
	 * @ordered
	 */
	protected long cpuSpeed = CPU_SPEED_EDEFAULT;

	/**
	 * This is true if the Cpu Speed attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean cpuSpeedESet;

	/**
	 * The default value of the '{@link #getCpuType() <em>Cpu Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpuType()
	 * @generated
	 * @ordered
	 */
	protected static final String CPU_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCpuType() <em>Cpu Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpuType()
	 * @generated
	 * @ordered
	 */
	protected String cpuType = CPU_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsVMIDanLPAR() <em>Is VMI Dan LPAR</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsVMIDanLPAR()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_VMI_DAN_LPAR_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsVMIDanLPAR() <em>Is VMI Dan LPAR</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsVMIDanLPAR()
	 * @generated
	 * @ordered
	 */
	protected boolean isVMIDanLPAR = IS_VMI_DAN_LPAR_EDEFAULT;

	/**
	 * This is true if the Is VMI Dan LPAR attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean isVMIDanLPARESet;

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
	 * The default value of the '{@link #getMemorySize() <em>Memory Size</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMemorySize()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger MEMORY_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMemorySize() <em>Memory Size</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMemorySize()
	 * @generated
	 * @ordered
	 */
	protected BigInteger memorySize = MEMORY_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getModel() <em>Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected static final String MODEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModel() <em>Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected String model = MODEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getPrimaryMACAddress() <em>Primary MAC Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryMACAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String PRIMARY_MAC_ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrimaryMACAddress() <em>Primary MAC Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryMACAddress()
	 * @generated
	 * @ordered
	 */
	protected String primaryMACAddress = PRIMARY_MAC_ADDRESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getProcessingCapacity() <em>Processing Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessingCapacity()
	 * @generated
	 * @ordered
	 */
	protected static final float PROCESSING_CAPACITY_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getProcessingCapacity() <em>Processing Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessingCapacity()
	 * @generated
	 * @ordered
	 */
	protected float processingCapacity = PROCESSING_CAPACITY_EDEFAULT;

	/**
	 * This is true if the Processing Capacity attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean processingCapacityESet;

	/**
	 * The default value of the '{@link #getProcessingCapacityUnits() <em>Processing Capacity Units</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessingCapacityUnits()
	 * @generated
	 * @ordered
	 */
	protected static final ProcessingCapacityUnitsType PROCESSING_CAPACITY_UNITS_EDEFAULT = ProcessingCapacityUnitsType.UNKNOWN_LITERAL;

	/**
	 * The cached value of the '{@link #getProcessingCapacityUnits() <em>Processing Capacity Units</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessingCapacityUnits()
	 * @generated
	 * @ordered
	 */
	protected ProcessingCapacityUnitsType processingCapacityUnits = PROCESSING_CAPACITY_UNITS_EDEFAULT;

	/**
	 * This is true if the Processing Capacity Units attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean processingCapacityUnitsESet;

	/**
	 * The default value of the '{@link #getRomVersion() <em>Rom Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRomVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String ROM_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRomVersion() <em>Rom Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRomVersion()
	 * @generated
	 * @ordered
	 */
	protected String romVersion = ROM_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getSerialNumber() <em>Serial Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSerialNumber()
	 * @generated
	 * @ordered
	 */
	protected static final String SERIAL_NUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSerialNumber() <em>Serial Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSerialNumber()
	 * @generated
	 * @ordered
	 */
	protected String serialNumber = SERIAL_NUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getSystemBoardUUID() <em>System Board UUID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemBoardUUID()
	 * @generated
	 * @ordered
	 */
	protected static final String SYSTEM_BOARD_UUID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSystemBoardUUID() <em>System Board UUID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemBoardUUID()
	 * @generated
	 * @ordered
	 */
	protected String systemBoardUUID = SYSTEM_BOARD_UUID_EDEFAULT;

	/**
	 * The default value of the '{@link #getSystemId() <em>System Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemId()
	 * @generated
	 * @ordered
	 */
	protected static final String SYSTEM_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSystemId() <em>System Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSystemId()
	 * @generated
	 * @ordered
	 */
	protected String systemId = SYSTEM_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #isVirtual() <em>Virtual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVirtual()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VIRTUAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isVirtual() <em>Virtual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVirtual()
	 * @generated
	 * @ordered
	 */
	protected boolean virtual = VIRTUAL_EDEFAULT;

	/**
	 * This is true if the Virtual attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean virtualESet;

	/**
	 * The default value of the '{@link #getVmid() <em>Vmid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVmid()
	 * @generated
	 * @ordered
	 */
	protected static final String VMID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVmid() <em>Vmid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVmid()
	 * @generated
	 * @ordered
	 */
	protected String vmid = VMID_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ServerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ServerPackage.Literals.SERVER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAutoStart() {
		return autoStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAutoStart(boolean newAutoStart) {
		boolean oldAutoStart = autoStart;
		autoStart = newAutoStart;
		boolean oldAutoStartESet = autoStartESet;
		autoStartESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServerPackage.SERVER__AUTO_START,
					oldAutoStart, autoStart, !oldAutoStartESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAutoStart() {
		boolean oldAutoStart = autoStart;
		boolean oldAutoStartESet = autoStartESet;
		autoStart = AUTO_START_EDEFAULT;
		autoStartESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ServerPackage.SERVER__AUTO_START,
					oldAutoStart, AUTO_START_EDEFAULT, oldAutoStartESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAutoStart() {
		return autoStartESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCpuArchitecture() {
		return cpuArchitecture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCpuArchitecture(String newCpuArchitecture) {
		String oldCpuArchitecture = cpuArchitecture;
		cpuArchitecture = newCpuArchitecture;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ServerPackage.SERVER__CPU_ARCHITECTURE, oldCpuArchitecture, cpuArchitecture));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArchitectureWidthType getCpuArchitectureWidth() {
		return cpuArchitectureWidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCpuArchitectureWidth(ArchitectureWidthType newCpuArchitectureWidth) {
		ArchitectureWidthType oldCpuArchitectureWidth = cpuArchitectureWidth;
		cpuArchitectureWidth = newCpuArchitectureWidth == null ? CPU_ARCHITECTURE_WIDTH_EDEFAULT
				: newCpuArchitectureWidth;
		boolean oldCpuArchitectureWidthESet = cpuArchitectureWidthESet;
		cpuArchitectureWidthESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ServerPackage.SERVER__CPU_ARCHITECTURE_WIDTH, oldCpuArchitectureWidth,
					cpuArchitectureWidth, !oldCpuArchitectureWidthESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCpuArchitectureWidth() {
		ArchitectureWidthType oldCpuArchitectureWidth = cpuArchitectureWidth;
		boolean oldCpuArchitectureWidthESet = cpuArchitectureWidthESet;
		cpuArchitectureWidth = CPU_ARCHITECTURE_WIDTH_EDEFAULT;
		cpuArchitectureWidthESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					ServerPackage.SERVER__CPU_ARCHITECTURE_WIDTH, oldCpuArchitectureWidth,
					CPU_ARCHITECTURE_WIDTH_EDEFAULT, oldCpuArchitectureWidthESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCpuArchitectureWidth() {
		return cpuArchitectureWidthESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCpuCoresInstalled() {
		return cpuCoresInstalled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCpuCoresInstalled(int newCpuCoresInstalled) {
		int oldCpuCoresInstalled = cpuCoresInstalled;
		cpuCoresInstalled = newCpuCoresInstalled;
		boolean oldCpuCoresInstalledESet = cpuCoresInstalledESet;
		cpuCoresInstalledESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ServerPackage.SERVER__CPU_CORES_INSTALLED, oldCpuCoresInstalled, cpuCoresInstalled,
					!oldCpuCoresInstalledESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCpuCoresInstalled() {
		int oldCpuCoresInstalled = cpuCoresInstalled;
		boolean oldCpuCoresInstalledESet = cpuCoresInstalledESet;
		cpuCoresInstalled = CPU_CORES_INSTALLED_EDEFAULT;
		cpuCoresInstalledESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					ServerPackage.SERVER__CPU_CORES_INSTALLED, oldCpuCoresInstalled,
					CPU_CORES_INSTALLED_EDEFAULT, oldCpuCoresInstalledESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCpuCoresInstalled() {
		return cpuCoresInstalledESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getCpuCount() {
		return cpuCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCpuCount(BigInteger newCpuCount) {
		BigInteger oldCpuCount = cpuCount;
		cpuCount = newCpuCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServerPackage.SERVER__CPU_COUNT,
					oldCpuCount, cpuCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCpuDiesInstalled() {
		return cpuDiesInstalled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCpuDiesInstalled(int newCpuDiesInstalled) {
		int oldCpuDiesInstalled = cpuDiesInstalled;
		cpuDiesInstalled = newCpuDiesInstalled;
		boolean oldCpuDiesInstalledESet = cpuDiesInstalledESet;
		cpuDiesInstalledESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ServerPackage.SERVER__CPU_DIES_INSTALLED, oldCpuDiesInstalled, cpuDiesInstalled,
					!oldCpuDiesInstalledESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCpuDiesInstalled() {
		int oldCpuDiesInstalled = cpuDiesInstalled;
		boolean oldCpuDiesInstalledESet = cpuDiesInstalledESet;
		cpuDiesInstalled = CPU_DIES_INSTALLED_EDEFAULT;
		cpuDiesInstalledESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					ServerPackage.SERVER__CPU_DIES_INSTALLED, oldCpuDiesInstalled,
					CPU_DIES_INSTALLED_EDEFAULT, oldCpuDiesInstalledESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCpuDiesInstalled() {
		return cpuDiesInstalledESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCpuManufacturer() {
		return cpuManufacturer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCpuManufacturer(String newCpuManufacturer) {
		String oldCpuManufacturer = cpuManufacturer;
		cpuManufacturer = newCpuManufacturer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ServerPackage.SERVER__CPU_MANUFACTURER, oldCpuManufacturer, cpuManufacturer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getCpuSpeed() {
		return cpuSpeed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCpuSpeed(long newCpuSpeed) {
		long oldCpuSpeed = cpuSpeed;
		cpuSpeed = newCpuSpeed;
		boolean oldCpuSpeedESet = cpuSpeedESet;
		cpuSpeedESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServerPackage.SERVER__CPU_SPEED,
					oldCpuSpeed, cpuSpeed, !oldCpuSpeedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCpuSpeed() {
		long oldCpuSpeed = cpuSpeed;
		boolean oldCpuSpeedESet = cpuSpeedESet;
		cpuSpeed = CPU_SPEED_EDEFAULT;
		cpuSpeedESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ServerPackage.SERVER__CPU_SPEED,
					oldCpuSpeed, CPU_SPEED_EDEFAULT, oldCpuSpeedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCpuSpeed() {
		return cpuSpeedESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCpuType() {
		return cpuType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCpuType(String newCpuType) {
		String oldCpuType = cpuType;
		cpuType = newCpuType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServerPackage.SERVER__CPU_TYPE,
					oldCpuType, cpuType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsVMIDanLPAR() {
		return isVMIDanLPAR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsVMIDanLPAR(boolean newIsVMIDanLPAR) {
		boolean oldIsVMIDanLPAR = isVMIDanLPAR;
		isVMIDanLPAR = newIsVMIDanLPAR;
		boolean oldIsVMIDanLPARESet = isVMIDanLPARESet;
		isVMIDanLPARESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ServerPackage.SERVER__IS_VMI_DAN_LPAR, oldIsVMIDanLPAR, isVMIDanLPAR,
					!oldIsVMIDanLPARESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIsVMIDanLPAR() {
		boolean oldIsVMIDanLPAR = isVMIDanLPAR;
		boolean oldIsVMIDanLPARESet = isVMIDanLPARESet;
		isVMIDanLPAR = IS_VMI_DAN_LPAR_EDEFAULT;
		isVMIDanLPARESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					ServerPackage.SERVER__IS_VMI_DAN_LPAR, oldIsVMIDanLPAR, IS_VMI_DAN_LPAR_EDEFAULT,
					oldIsVMIDanLPARESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIsVMIDanLPAR() {
		return isVMIDanLPARESet;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ServerPackage.SERVER__MANUFACTURER,
					oldManufacturer, manufacturer));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getMemorySize() {
		return memorySize;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMemorySize(BigInteger newMemorySize) {
		BigInteger oldMemorySize = memorySize;
		memorySize = newMemorySize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServerPackage.SERVER__MEMORY_SIZE,
					oldMemorySize, memorySize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getModel() {
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModel(String newModel) {
		String oldModel = model;
		model = newModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServerPackage.SERVER__MODEL,
					oldModel, model));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPrimaryMACAddress() {
		return primaryMACAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimaryMACAddress(String newPrimaryMACAddress) {
		String oldPrimaryMACAddress = primaryMACAddress;
		primaryMACAddress = newPrimaryMACAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ServerPackage.SERVER__PRIMARY_MAC_ADDRESS, oldPrimaryMACAddress, primaryMACAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getProcessingCapacity() {
		return processingCapacity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessingCapacity(float newProcessingCapacity) {
		float oldProcessingCapacity = processingCapacity;
		processingCapacity = newProcessingCapacity;
		boolean oldProcessingCapacityESet = processingCapacityESet;
		processingCapacityESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ServerPackage.SERVER__PROCESSING_CAPACITY, oldProcessingCapacity,
					processingCapacity, !oldProcessingCapacityESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetProcessingCapacity() {
		float oldProcessingCapacity = processingCapacity;
		boolean oldProcessingCapacityESet = processingCapacityESet;
		processingCapacity = PROCESSING_CAPACITY_EDEFAULT;
		processingCapacityESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					ServerPackage.SERVER__PROCESSING_CAPACITY, oldProcessingCapacity,
					PROCESSING_CAPACITY_EDEFAULT, oldProcessingCapacityESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetProcessingCapacity() {
		return processingCapacityESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingCapacityUnitsType getProcessingCapacityUnits() {
		return processingCapacityUnits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessingCapacityUnits(ProcessingCapacityUnitsType newProcessingCapacityUnits) {
		ProcessingCapacityUnitsType oldProcessingCapacityUnits = processingCapacityUnits;
		processingCapacityUnits = newProcessingCapacityUnits == null ? PROCESSING_CAPACITY_UNITS_EDEFAULT
				: newProcessingCapacityUnits;
		boolean oldProcessingCapacityUnitsESet = processingCapacityUnitsESet;
		processingCapacityUnitsESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ServerPackage.SERVER__PROCESSING_CAPACITY_UNITS, oldProcessingCapacityUnits,
					processingCapacityUnits, !oldProcessingCapacityUnitsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetProcessingCapacityUnits() {
		ProcessingCapacityUnitsType oldProcessingCapacityUnits = processingCapacityUnits;
		boolean oldProcessingCapacityUnitsESet = processingCapacityUnitsESet;
		processingCapacityUnits = PROCESSING_CAPACITY_UNITS_EDEFAULT;
		processingCapacityUnitsESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					ServerPackage.SERVER__PROCESSING_CAPACITY_UNITS, oldProcessingCapacityUnits,
					PROCESSING_CAPACITY_UNITS_EDEFAULT, oldProcessingCapacityUnitsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetProcessingCapacityUnits() {
		return processingCapacityUnitsESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRomVersion() {
		return romVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRomVersion(String newRomVersion) {
		String oldRomVersion = romVersion;
		romVersion = newRomVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServerPackage.SERVER__ROM_VERSION,
					oldRomVersion, romVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSerialNumber() {
		return serialNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSerialNumber(String newSerialNumber) {
		String oldSerialNumber = serialNumber;
		serialNumber = newSerialNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServerPackage.SERVER__SERIAL_NUMBER,
					oldSerialNumber, serialNumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSystemBoardUUID() {
		return systemBoardUUID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystemBoardUUID(String newSystemBoardUUID) {
		String oldSystemBoardUUID = systemBoardUUID;
		systemBoardUUID = newSystemBoardUUID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ServerPackage.SERVER__SYSTEM_BOARD_UUID, oldSystemBoardUUID, systemBoardUUID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSystemId() {
		return systemId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystemId(String newSystemId) {
		String oldSystemId = systemId;
		systemId = newSystemId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServerPackage.SERVER__SYSTEM_ID,
					oldSystemId, systemId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isVirtual() {
		return virtual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVirtual(boolean newVirtual) {
		boolean oldVirtual = virtual;
		virtual = newVirtual;
		boolean oldVirtualESet = virtualESet;
		virtualESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServerPackage.SERVER__VIRTUAL,
					oldVirtual, virtual, !oldVirtualESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVirtual() {
		boolean oldVirtual = virtual;
		boolean oldVirtualESet = virtualESet;
		virtual = VIRTUAL_EDEFAULT;
		virtualESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ServerPackage.SERVER__VIRTUAL,
					oldVirtual, VIRTUAL_EDEFAULT, oldVirtualESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVirtual() {
		return virtualESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVmid() {
		return vmid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVmid(String newVmid) {
		String oldVmid = vmid;
		vmid = newVmid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServerPackage.SERVER__VMID, oldVmid,
					vmid));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case ServerPackage.SERVER__AUTO_START:
			return isAutoStart() ? Boolean.TRUE : Boolean.FALSE;
		case ServerPackage.SERVER__CPU_ARCHITECTURE:
			return getCpuArchitecture();
		case ServerPackage.SERVER__CPU_COUNT:
			return getCpuCount();
		case ServerPackage.SERVER__CPU_ARCHITECTURE_WIDTH:
			return getCpuArchitectureWidth();
		case ServerPackage.SERVER__CPU_CORES_INSTALLED:
			return new Integer(getCpuCoresInstalled());
		case ServerPackage.SERVER__CPU_DIES_INSTALLED:
			return new Integer(getCpuDiesInstalled());
		case ServerPackage.SERVER__CPU_MANUFACTURER:
			return getCpuManufacturer();
		case ServerPackage.SERVER__CPU_SPEED:
			return new Long(getCpuSpeed());
		case ServerPackage.SERVER__CPU_TYPE:
			return getCpuType();
		case ServerPackage.SERVER__IS_VMI_DAN_LPAR:
			return isIsVMIDanLPAR() ? Boolean.TRUE : Boolean.FALSE;
		case ServerPackage.SERVER__MANUFACTURER:
			return getManufacturer();
		case ServerPackage.SERVER__MEMORY_SIZE:
			return getMemorySize();
		case ServerPackage.SERVER__MODEL:
			return getModel();
		case ServerPackage.SERVER__PRIMARY_MAC_ADDRESS:
			return getPrimaryMACAddress();
		case ServerPackage.SERVER__PROCESSING_CAPACITY:
			return new Float(getProcessingCapacity());
		case ServerPackage.SERVER__PROCESSING_CAPACITY_UNITS:
			return getProcessingCapacityUnits();
		case ServerPackage.SERVER__ROM_VERSION:
			return getRomVersion();
		case ServerPackage.SERVER__SERIAL_NUMBER:
			return getSerialNumber();
		case ServerPackage.SERVER__SYSTEM_BOARD_UUID:
			return getSystemBoardUUID();
		case ServerPackage.SERVER__SYSTEM_ID:
			return getSystemId();
		case ServerPackage.SERVER__VIRTUAL:
			return isVirtual() ? Boolean.TRUE : Boolean.FALSE;
		case ServerPackage.SERVER__VMID:
			return getVmid();
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
		case ServerPackage.SERVER__AUTO_START:
			setAutoStart(((Boolean) newValue).booleanValue());
			return;
		case ServerPackage.SERVER__CPU_ARCHITECTURE:
			setCpuArchitecture((String) newValue);
			return;
		case ServerPackage.SERVER__CPU_COUNT:
			setCpuCount((BigInteger) newValue);
			return;
		case ServerPackage.SERVER__CPU_ARCHITECTURE_WIDTH:
			setCpuArchitectureWidth((ArchitectureWidthType) newValue);
			return;
		case ServerPackage.SERVER__CPU_CORES_INSTALLED:
			setCpuCoresInstalled(((Integer) newValue).intValue());
			return;
		case ServerPackage.SERVER__CPU_DIES_INSTALLED:
			setCpuDiesInstalled(((Integer) newValue).intValue());
			return;
		case ServerPackage.SERVER__CPU_MANUFACTURER:
			setCpuManufacturer((String) newValue);
			return;
		case ServerPackage.SERVER__CPU_SPEED:
			setCpuSpeed(((Long) newValue).longValue());
			return;
		case ServerPackage.SERVER__CPU_TYPE:
			setCpuType((String) newValue);
			return;
		case ServerPackage.SERVER__IS_VMI_DAN_LPAR:
			setIsVMIDanLPAR(((Boolean) newValue).booleanValue());
			return;
		case ServerPackage.SERVER__MANUFACTURER:
			setManufacturer((String) newValue);
			return;
		case ServerPackage.SERVER__MEMORY_SIZE:
			setMemorySize((BigInteger) newValue);
			return;
		case ServerPackage.SERVER__MODEL:
			setModel((String) newValue);
			return;
		case ServerPackage.SERVER__PRIMARY_MAC_ADDRESS:
			setPrimaryMACAddress((String) newValue);
			return;
		case ServerPackage.SERVER__PROCESSING_CAPACITY:
			setProcessingCapacity(((Float) newValue).floatValue());
			return;
		case ServerPackage.SERVER__PROCESSING_CAPACITY_UNITS:
			setProcessingCapacityUnits((ProcessingCapacityUnitsType) newValue);
			return;
		case ServerPackage.SERVER__ROM_VERSION:
			setRomVersion((String) newValue);
			return;
		case ServerPackage.SERVER__SERIAL_NUMBER:
			setSerialNumber((String) newValue);
			return;
		case ServerPackage.SERVER__SYSTEM_BOARD_UUID:
			setSystemBoardUUID((String) newValue);
			return;
		case ServerPackage.SERVER__SYSTEM_ID:
			setSystemId((String) newValue);
			return;
		case ServerPackage.SERVER__VIRTUAL:
			setVirtual(((Boolean) newValue).booleanValue());
			return;
		case ServerPackage.SERVER__VMID:
			setVmid((String) newValue);
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
		case ServerPackage.SERVER__AUTO_START:
			unsetAutoStart();
			return;
		case ServerPackage.SERVER__CPU_ARCHITECTURE:
			setCpuArchitecture(CPU_ARCHITECTURE_EDEFAULT);
			return;
		case ServerPackage.SERVER__CPU_COUNT:
			setCpuCount(CPU_COUNT_EDEFAULT);
			return;
		case ServerPackage.SERVER__CPU_ARCHITECTURE_WIDTH:
			unsetCpuArchitectureWidth();
			return;
		case ServerPackage.SERVER__CPU_CORES_INSTALLED:
			unsetCpuCoresInstalled();
			return;
		case ServerPackage.SERVER__CPU_DIES_INSTALLED:
			unsetCpuDiesInstalled();
			return;
		case ServerPackage.SERVER__CPU_MANUFACTURER:
			setCpuManufacturer(CPU_MANUFACTURER_EDEFAULT);
			return;
		case ServerPackage.SERVER__CPU_SPEED:
			unsetCpuSpeed();
			return;
		case ServerPackage.SERVER__CPU_TYPE:
			setCpuType(CPU_TYPE_EDEFAULT);
			return;
		case ServerPackage.SERVER__IS_VMI_DAN_LPAR:
			unsetIsVMIDanLPAR();
			return;
		case ServerPackage.SERVER__MANUFACTURER:
			setManufacturer(MANUFACTURER_EDEFAULT);
			return;
		case ServerPackage.SERVER__MEMORY_SIZE:
			setMemorySize(MEMORY_SIZE_EDEFAULT);
			return;
		case ServerPackage.SERVER__MODEL:
			setModel(MODEL_EDEFAULT);
			return;
		case ServerPackage.SERVER__PRIMARY_MAC_ADDRESS:
			setPrimaryMACAddress(PRIMARY_MAC_ADDRESS_EDEFAULT);
			return;
		case ServerPackage.SERVER__PROCESSING_CAPACITY:
			unsetProcessingCapacity();
			return;
		case ServerPackage.SERVER__PROCESSING_CAPACITY_UNITS:
			unsetProcessingCapacityUnits();
			return;
		case ServerPackage.SERVER__ROM_VERSION:
			setRomVersion(ROM_VERSION_EDEFAULT);
			return;
		case ServerPackage.SERVER__SERIAL_NUMBER:
			setSerialNumber(SERIAL_NUMBER_EDEFAULT);
			return;
		case ServerPackage.SERVER__SYSTEM_BOARD_UUID:
			setSystemBoardUUID(SYSTEM_BOARD_UUID_EDEFAULT);
			return;
		case ServerPackage.SERVER__SYSTEM_ID:
			setSystemId(SYSTEM_ID_EDEFAULT);
			return;
		case ServerPackage.SERVER__VIRTUAL:
			unsetVirtual();
			return;
		case ServerPackage.SERVER__VMID:
			setVmid(VMID_EDEFAULT);
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
		case ServerPackage.SERVER__AUTO_START:
			return isSetAutoStart();
		case ServerPackage.SERVER__CPU_ARCHITECTURE:
			return CPU_ARCHITECTURE_EDEFAULT == null ? cpuArchitecture != null
					: !CPU_ARCHITECTURE_EDEFAULT.equals(cpuArchitecture);
		case ServerPackage.SERVER__CPU_COUNT:
			return CPU_COUNT_EDEFAULT == null ? cpuCount != null : !CPU_COUNT_EDEFAULT
					.equals(cpuCount);
		case ServerPackage.SERVER__CPU_ARCHITECTURE_WIDTH:
			return isSetCpuArchitectureWidth();
		case ServerPackage.SERVER__CPU_CORES_INSTALLED:
			return isSetCpuCoresInstalled();
		case ServerPackage.SERVER__CPU_DIES_INSTALLED:
			return isSetCpuDiesInstalled();
		case ServerPackage.SERVER__CPU_MANUFACTURER:
			return CPU_MANUFACTURER_EDEFAULT == null ? cpuManufacturer != null
					: !CPU_MANUFACTURER_EDEFAULT.equals(cpuManufacturer);
		case ServerPackage.SERVER__CPU_SPEED:
			return isSetCpuSpeed();
		case ServerPackage.SERVER__CPU_TYPE:
			return CPU_TYPE_EDEFAULT == null ? cpuType != null : !CPU_TYPE_EDEFAULT.equals(cpuType);
		case ServerPackage.SERVER__IS_VMI_DAN_LPAR:
			return isSetIsVMIDanLPAR();
		case ServerPackage.SERVER__MANUFACTURER:
			return MANUFACTURER_EDEFAULT == null ? manufacturer != null : !MANUFACTURER_EDEFAULT
					.equals(manufacturer);
		case ServerPackage.SERVER__MEMORY_SIZE:
			return MEMORY_SIZE_EDEFAULT == null ? memorySize != null : !MEMORY_SIZE_EDEFAULT
					.equals(memorySize);
		case ServerPackage.SERVER__MODEL:
			return MODEL_EDEFAULT == null ? model != null : !MODEL_EDEFAULT.equals(model);
		case ServerPackage.SERVER__PRIMARY_MAC_ADDRESS:
			return PRIMARY_MAC_ADDRESS_EDEFAULT == null ? primaryMACAddress != null
					: !PRIMARY_MAC_ADDRESS_EDEFAULT.equals(primaryMACAddress);
		case ServerPackage.SERVER__PROCESSING_CAPACITY:
			return isSetProcessingCapacity();
		case ServerPackage.SERVER__PROCESSING_CAPACITY_UNITS:
			return isSetProcessingCapacityUnits();
		case ServerPackage.SERVER__ROM_VERSION:
			return ROM_VERSION_EDEFAULT == null ? romVersion != null : !ROM_VERSION_EDEFAULT
					.equals(romVersion);
		case ServerPackage.SERVER__SERIAL_NUMBER:
			return SERIAL_NUMBER_EDEFAULT == null ? serialNumber != null : !SERIAL_NUMBER_EDEFAULT
					.equals(serialNumber);
		case ServerPackage.SERVER__SYSTEM_BOARD_UUID:
			return SYSTEM_BOARD_UUID_EDEFAULT == null ? systemBoardUUID != null
					: !SYSTEM_BOARD_UUID_EDEFAULT.equals(systemBoardUUID);
		case ServerPackage.SERVER__SYSTEM_ID:
			return SYSTEM_ID_EDEFAULT == null ? systemId != null : !SYSTEM_ID_EDEFAULT
					.equals(systemId);
		case ServerPackage.SERVER__VIRTUAL:
			return isSetVirtual();
		case ServerPackage.SERVER__VMID:
			return VMID_EDEFAULT == null ? vmid != null : !VMID_EDEFAULT.equals(vmid);
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
		result.append(" (autoStart: "); //$NON-NLS-1$
		if (autoStartESet)
			result.append(autoStart);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", cpuArchitecture: "); //$NON-NLS-1$
		result.append(cpuArchitecture);
		result.append(", cpuCount: "); //$NON-NLS-1$
		result.append(cpuCount);
		result.append(", cpuArchitectureWidth: "); //$NON-NLS-1$
		if (cpuArchitectureWidthESet)
			result.append(cpuArchitectureWidth);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", cpuCoresInstalled: "); //$NON-NLS-1$
		if (cpuCoresInstalledESet)
			result.append(cpuCoresInstalled);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", cpuDiesInstalled: "); //$NON-NLS-1$
		if (cpuDiesInstalledESet)
			result.append(cpuDiesInstalled);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", cpuManufacturer: "); //$NON-NLS-1$
		result.append(cpuManufacturer);
		result.append(", cpuSpeed: "); //$NON-NLS-1$
		if (cpuSpeedESet)
			result.append(cpuSpeed);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", cpuType: "); //$NON-NLS-1$
		result.append(cpuType);
		result.append(", isVMIDanLPAR: "); //$NON-NLS-1$
		if (isVMIDanLPARESet)
			result.append(isVMIDanLPAR);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", manufacturer: "); //$NON-NLS-1$
		result.append(manufacturer);
		result.append(", memorySize: "); //$NON-NLS-1$
		result.append(memorySize);
		result.append(", model: "); //$NON-NLS-1$
		result.append(model);
		result.append(", primaryMACAddress: "); //$NON-NLS-1$
		result.append(primaryMACAddress);
		result.append(", processingCapacity: "); //$NON-NLS-1$
		if (processingCapacityESet)
			result.append(processingCapacity);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", processingCapacityUnits: "); //$NON-NLS-1$
		if (processingCapacityUnitsESet)
			result.append(processingCapacityUnits);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", romVersion: "); //$NON-NLS-1$
		result.append(romVersion);
		result.append(", serialNumber: "); //$NON-NLS-1$
		result.append(serialNumber);
		result.append(", systemBoardUUID: "); //$NON-NLS-1$
		result.append(systemBoardUUID);
		result.append(", systemId: "); //$NON-NLS-1$
		result.append(systemId);
		result.append(", virtual: "); //$NON-NLS-1$
		if (virtualESet)
			result.append(virtual);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(", vmid: "); //$NON-NLS-1$
		result.append(vmid);
		result.append(')');
		return result.toString();
	}

} //ServerImpl
