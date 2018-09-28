/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.server;

import java.math.BigInteger;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Server</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.Server#isAutoStart <em>Auto Start</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.Server#getCpuArchitecture <em>Cpu Architecture</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.Server#getCpuCount <em>Cpu Count</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.Server#getCpuArchitectureWidth <em>Cpu Architecture Width</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.Server#getCpuCoresInstalled <em>Cpu Cores Installed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.Server#getCpuDiesInstalled <em>Cpu Dies Installed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.Server#getCpuManufacturer <em>Cpu Manufacturer</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.Server#getCpuSpeed <em>Cpu Speed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.Server#getCpuType <em>Cpu Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.Server#isIsVMIDanLPAR <em>Is VMI Dan LPAR</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.Server#getManufacturer <em>Manufacturer</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.Server#getMemorySize <em>Memory Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.Server#getModel <em>Model</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.Server#getPrimaryMACAddress <em>Primary MAC Address</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.Server#getProcessingCapacity <em>Processing Capacity</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.Server#getProcessingCapacityUnits <em>Processing Capacity Units</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.Server#getRomVersion <em>Rom Version</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.Server#getSerialNumber <em>Serial Number</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.Server#getSystemBoardUUID <em>System Board UUID</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.Server#getSystemId <em>System Id</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.Server#isVirtual <em>Virtual</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.server.Server#getVmid <em>Vmid</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.server.ServerPackage#getServer()
 * @model extendedMetaData="name='Server' kind='elementOnly'"
 * @generated
 */
public interface Server extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Auto Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Auto Start</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							In the circumstances where the Computer System environment supports this function (such as
	 * 							in Virtualization), AutoStart represents whether or not the instance is automatically
	 * 							started under particular circumstances. These circumstances could include when the
	 * 							ComputerSystem is powered off, it will automatically restart when power is restored to the
	 * 							machine. Another circumstance includes when virtual computer system instances are
	 * 							automatically started when the physcial computer system instance is started.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Auto Start</em>' attribute.
	 * @see #isSetAutoStart()
	 * @see #unsetAutoStart()
	 * @see #setAutoStart(boolean)
	 * @see com.ibm.ccl.soa.deploy.server.ServerPackage#getServer_AutoStart()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='autoStart'"
	 * @generated
	 */
	boolean isAutoStart();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#isAutoStart <em>Auto Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Auto Start</em>' attribute.
	 * @see #isSetAutoStart()
	 * @see #unsetAutoStart()
	 * @see #isAutoStart()
	 * @generated
	 */
	void setAutoStart(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#isAutoStart <em>Auto Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAutoStart()
	 * @see #isAutoStart()
	 * @see #setAutoStart(boolean)
	 * @generated
	 */
	void unsetAutoStart();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#isAutoStart <em>Auto Start</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Auto Start</em>' attribute is set.
	 * @see #unsetAutoStart()
	 * @see #isAutoStart()
	 * @see #setAutoStart(boolean)
	 * @generated
	 */
	boolean isSetAutoStart();

	/**
	 * Returns the value of the '<em><b>Cpu Architecture</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * e.g. "Intel" or "i686"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cpu Architecture</em>' attribute.
	 * @see #setCpuArchitecture(String)
	 * @see com.ibm.ccl.soa.deploy.server.ServerPackage#getServer_CpuArchitecture()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='cpu.architecture'"
	 * @generated
	 */
	String getCpuArchitecture();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#getCpuArchitecture <em>Cpu Architecture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cpu Architecture</em>' attribute.
	 * @see #getCpuArchitecture()
	 * @generated
	 */
	void setCpuArchitecture(String value);

	/**
	 * Returns the value of the '<em><b>Cpu Architecture Width</b></em>' attribute.
	 * The default value is <code>"32-bit"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.server.ArchitectureWidthType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Enumeration - "32-bit" or "61-bit"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cpu Architecture Width</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.server.ArchitectureWidthType
	 * @see #isSetCpuArchitectureWidth()
	 * @see #unsetCpuArchitectureWidth()
	 * @see #setCpuArchitectureWidth(ArchitectureWidthType)
	 * @see com.ibm.ccl.soa.deploy.server.ServerPackage#getServer_CpuArchitectureWidth()
	 * @model default="32-bit" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='cpuArchitectureWidth'"
	 * @generated
	 */
	ArchitectureWidthType getCpuArchitectureWidth();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#getCpuArchitectureWidth <em>Cpu Architecture Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cpu Architecture Width</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.server.ArchitectureWidthType
	 * @see #isSetCpuArchitectureWidth()
	 * @see #unsetCpuArchitectureWidth()
	 * @see #getCpuArchitectureWidth()
	 * @generated
	 */
	void setCpuArchitectureWidth(ArchitectureWidthType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#getCpuArchitectureWidth <em>Cpu Architecture Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCpuArchitectureWidth()
	 * @see #getCpuArchitectureWidth()
	 * @see #setCpuArchitectureWidth(ArchitectureWidthType)
	 * @generated
	 */
	void unsetCpuArchitectureWidth();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#getCpuArchitectureWidth <em>Cpu Architecture Width</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Cpu Architecture Width</em>' attribute is set.
	 * @see #unsetCpuArchitectureWidth()
	 * @see #getCpuArchitectureWidth()
	 * @see #setCpuArchitectureWidth(ArchitectureWidthType)
	 * @generated
	 */
	boolean isSetCpuArchitectureWidth();

	/**
	 * Returns the value of the '<em><b>Cpu Cores Installed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * TODO
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cpu Cores Installed</em>' attribute.
	 * @see #isSetCpuCoresInstalled()
	 * @see #unsetCpuCoresInstalled()
	 * @see #setCpuCoresInstalled(int)
	 * @see com.ibm.ccl.soa.deploy.server.ServerPackage#getServer_CpuCoresInstalled()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='cpuCoresInstalled'"
	 * @generated
	 */
	int getCpuCoresInstalled();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#getCpuCoresInstalled <em>Cpu Cores Installed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cpu Cores Installed</em>' attribute.
	 * @see #isSetCpuCoresInstalled()
	 * @see #unsetCpuCoresInstalled()
	 * @see #getCpuCoresInstalled()
	 * @generated
	 */
	void setCpuCoresInstalled(int value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#getCpuCoresInstalled <em>Cpu Cores Installed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCpuCoresInstalled()
	 * @see #getCpuCoresInstalled()
	 * @see #setCpuCoresInstalled(int)
	 * @generated
	 */
	void unsetCpuCoresInstalled();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#getCpuCoresInstalled <em>Cpu Cores Installed</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Cpu Cores Installed</em>' attribute is set.
	 * @see #unsetCpuCoresInstalled()
	 * @see #getCpuCoresInstalled()
	 * @see #setCpuCoresInstalled(int)
	 * @generated
	 */
	boolean isSetCpuCoresInstalled();

	/**
	 * Returns the value of the '<em><b>Cpu Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The number of CPUs as seen by a hosted operating system.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cpu Count</em>' attribute.
	 * @see #setCpuCount(BigInteger)
	 * @see com.ibm.ccl.soa.deploy.server.ServerPackage#getServer_CpuCount()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.PositiveInteger"
	 *        extendedMetaData="kind='attribute' name='cpu.count'"
	 * @generated
	 */
	BigInteger getCpuCount();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#getCpuCount <em>Cpu Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cpu Count</em>' attribute.
	 * @see #getCpuCount()
	 * @generated
	 */
	void setCpuCount(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Cpu Dies Installed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * TODO
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cpu Dies Installed</em>' attribute.
	 * @see #isSetCpuDiesInstalled()
	 * @see #unsetCpuDiesInstalled()
	 * @see #setCpuDiesInstalled(int)
	 * @see com.ibm.ccl.soa.deploy.server.ServerPackage#getServer_CpuDiesInstalled()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='cpuDiesInstalled'"
	 * @generated
	 */
	int getCpuDiesInstalled();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#getCpuDiesInstalled <em>Cpu Dies Installed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cpu Dies Installed</em>' attribute.
	 * @see #isSetCpuDiesInstalled()
	 * @see #unsetCpuDiesInstalled()
	 * @see #getCpuDiesInstalled()
	 * @generated
	 */
	void setCpuDiesInstalled(int value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#getCpuDiesInstalled <em>Cpu Dies Installed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCpuDiesInstalled()
	 * @see #getCpuDiesInstalled()
	 * @see #setCpuDiesInstalled(int)
	 * @generated
	 */
	void unsetCpuDiesInstalled();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#getCpuDiesInstalled <em>Cpu Dies Installed</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Cpu Dies Installed</em>' attribute is set.
	 * @see #unsetCpuDiesInstalled()
	 * @see #getCpuDiesInstalled()
	 * @see #setCpuDiesInstalled(int)
	 * @generated
	 */
	boolean isSetCpuDiesInstalled();

	/**
	 * Returns the value of the '<em><b>Cpu Manufacturer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * TODO
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cpu Manufacturer</em>' attribute.
	 * @see #setCpuManufacturer(String)
	 * @see com.ibm.ccl.soa.deploy.server.ServerPackage#getServer_CpuManufacturer()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='cpuManufacturer'"
	 * @generated
	 */
	String getCpuManufacturer();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#getCpuManufacturer <em>Cpu Manufacturer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cpu Manufacturer</em>' attribute.
	 * @see #getCpuManufacturer()
	 * @generated
	 */
	void setCpuManufacturer(String value);

	/**
	 * Returns the value of the '<em><b>Cpu Speed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Units are Hertz
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cpu Speed</em>' attribute.
	 * @see #isSetCpuSpeed()
	 * @see #unsetCpuSpeed()
	 * @see #setCpuSpeed(long)
	 * @see com.ibm.ccl.soa.deploy.server.ServerPackage#getServer_CpuSpeed()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Long"
	 *        extendedMetaData="kind='attribute' name='cpuSpeed'"
	 * @generated
	 */
	long getCpuSpeed();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#getCpuSpeed <em>Cpu Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cpu Speed</em>' attribute.
	 * @see #isSetCpuSpeed()
	 * @see #unsetCpuSpeed()
	 * @see #getCpuSpeed()
	 * @generated
	 */
	void setCpuSpeed(long value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#getCpuSpeed <em>Cpu Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCpuSpeed()
	 * @see #getCpuSpeed()
	 * @see #setCpuSpeed(long)
	 * @generated
	 */
	void unsetCpuSpeed();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#getCpuSpeed <em>Cpu Speed</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Cpu Speed</em>' attribute is set.
	 * @see #unsetCpuSpeed()
	 * @see #getCpuSpeed()
	 * @see #setCpuSpeed(long)
	 * @generated
	 */
	boolean isSetCpuSpeed();

	/**
	 * Returns the value of the '<em><b>Cpu Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * e.g. "Dual Core AMD Opteron(tm) Processor 280"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Cpu Type</em>' attribute.
	 * @see #setCpuType(String)
	 * @see com.ibm.ccl.soa.deploy.server.ServerPackage#getServer_CpuType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='cpuType'"
	 * @generated
	 */
	String getCpuType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#getCpuType <em>Cpu Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cpu Type</em>' attribute.
	 * @see #getCpuType()
	 * @generated
	 */
	void setCpuType(String value);

	/**
	 * Returns the value of the '<em><b>Is VMI Dan LPAR</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is VMI Dan LPAR</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Is the VMID an LPAR?
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is VMI Dan LPAR</em>' attribute.
	 * @see #isSetIsVMIDanLPAR()
	 * @see #unsetIsVMIDanLPAR()
	 * @see #setIsVMIDanLPAR(boolean)
	 * @see com.ibm.ccl.soa.deploy.server.ServerPackage#getServer_IsVMIDanLPAR()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='isVMIDanLPAR'"
	 * @generated
	 */
	boolean isIsVMIDanLPAR();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#isIsVMIDanLPAR <em>Is VMI Dan LPAR</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is VMI Dan LPAR</em>' attribute.
	 * @see #isSetIsVMIDanLPAR()
	 * @see #unsetIsVMIDanLPAR()
	 * @see #isIsVMIDanLPAR()
	 * @generated
	 */
	void setIsVMIDanLPAR(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#isIsVMIDanLPAR <em>Is VMI Dan LPAR</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIsVMIDanLPAR()
	 * @see #isIsVMIDanLPAR()
	 * @see #setIsVMIDanLPAR(boolean)
	 * @generated
	 */
	void unsetIsVMIDanLPAR();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#isIsVMIDanLPAR <em>Is VMI Dan LPAR</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Is VMI Dan LPAR</em>' attribute is set.
	 * @see #unsetIsVMIDanLPAR()
	 * @see #isIsVMIDanLPAR()
	 * @see #setIsVMIDanLPAR(boolean)
	 * @generated
	 */
	boolean isSetIsVMIDanLPAR();

	/**
	 * Returns the value of the '<em><b>Manufacturer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Manufacturer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							The string for the manufacturer should match the strings defined in the following URL:
	 * 							http://www.iana.org/assignments/enterprise-numbers In addition to the names on the list,
	 * 							there are a few corrections and extensions due to mergers, acquisitions, etc. The following
	 * 							is a list of currently defined changes to the URL above. "42", "Sun Microsystems" "1872",
	 * 							"Nortel Networks (Alteon)" "1916", "Extreme" "Other" "Other" is a valid string that
	 * 							applications can use if the application manufacturer string has not been defined in the URL
	 * 							above. Manufacturers that are not on the list should contact the Internet Assigned Numbers
	 * 							Authority (IANA) to get an assigned number. Applications placing data in the Common Data
	 * 							Model are responsible for mapping application manufacturer strings to strings defined in the
	 * 							URL above. For example, applications need to use "IBM" as a manufacturer string and not
	 * 							"International Business Machines", "IBM Corp", "IBM Corporation", "International Business
	 * 							Machines Corporation", etc.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Manufacturer</em>' attribute.
	 * @see #setManufacturer(String)
	 * @see com.ibm.ccl.soa.deploy.server.ServerPackage#getServer_Manufacturer()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='manufacturer'"
	 * @generated
	 */
	String getManufacturer();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#getManufacturer <em>Manufacturer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manufacturer</em>' attribute.
	 * @see #getManufacturer()
	 * @generated
	 */
	void setManufacturer(String value);

	/**
	 * Returns the value of the '<em><b>Memory Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Memory Size</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							Memory size, in 1024 byte units.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Memory Size</em>' attribute.
	 * @see #setMemorySize(BigInteger)
	 * @see com.ibm.ccl.soa.deploy.server.ServerPackage#getServer_MemorySize()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.UnsignedLong"
	 *        extendedMetaData="kind='attribute' name='memory.size'"
	 * @generated
	 */
	BigInteger getMemorySize();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#getMemorySize <em>Memory Size</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Memory Size</em>' attribute.
	 * @see #getMemorySize()
	 * @generated
	 */
	void setMemorySize(BigInteger value);

	/**
	 * Returns the value of the '<em><b>Model</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * e.g. eserver xSeries 336 -[883701U]-
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Model</em>' attribute.
	 * @see #setModel(String)
	 * @see com.ibm.ccl.soa.deploy.server.ServerPackage#getServer_Model()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='model'"
	 * @generated
	 */
	String getModel();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#getModel <em>Model</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' attribute.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(String value);

	/**
	 * Returns the value of the '<em><b>Primary MAC Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary MAC Address</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							The primary MAC address may be used to compose a unique machine identifier
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Primary MAC Address</em>' attribute.
	 * @see #setPrimaryMACAddress(String)
	 * @see com.ibm.ccl.soa.deploy.server.ServerPackage#getServer_PrimaryMACAddress()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='primaryMACAddress'"
	 * @generated
	 */
	String getPrimaryMACAddress();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#getPrimaryMACAddress <em>Primary MAC Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary MAC Address</em>' attribute.
	 * @see #getPrimaryMACAddress()
	 * @generated
	 */
	void setPrimaryMACAddress(String value);

	/**
	 * Returns the value of the '<em><b>Processing Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processing Capacity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							A specification of the processing capacity of this computer system, including all of the
	 * 							CPUs assigned to it. The units in which this capacity are expressed should be stated in the
	 * 							ProcessCapacityUnits attribute.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Processing Capacity</em>' attribute.
	 * @see #isSetProcessingCapacity()
	 * @see #unsetProcessingCapacity()
	 * @see #setProcessingCapacity(float)
	 * @see com.ibm.ccl.soa.deploy.server.ServerPackage#getServer_ProcessingCapacity()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Float"
	 *        extendedMetaData="kind='attribute' name='processingCapacity'"
	 * @generated
	 */
	float getProcessingCapacity();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#getProcessingCapacity <em>Processing Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Processing Capacity</em>' attribute.
	 * @see #isSetProcessingCapacity()
	 * @see #unsetProcessingCapacity()
	 * @see #getProcessingCapacity()
	 * @generated
	 */
	void setProcessingCapacity(float value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#getProcessingCapacity <em>Processing Capacity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetProcessingCapacity()
	 * @see #getProcessingCapacity()
	 * @see #setProcessingCapacity(float)
	 * @generated
	 */
	void unsetProcessingCapacity();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#getProcessingCapacity <em>Processing Capacity</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Processing Capacity</em>' attribute is set.
	 * @see #unsetProcessingCapacity()
	 * @see #getProcessingCapacity()
	 * @see #setProcessingCapacity(float)
	 * @generated
	 */
	boolean isSetProcessingCapacity();

	/**
	 * Returns the value of the '<em><b>Processing Capacity Units</b></em>' attribute.
	 * The default value is <code>"Unknown"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.server.ProcessingCapacityUnitsType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							The units in which the ProcessingCapacity attribute's value are expressed. For ZSeries this
	 * 							should be MSU (Millions of service units/hour)
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Processing Capacity Units</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.server.ProcessingCapacityUnitsType
	 * @see #isSetProcessingCapacityUnits()
	 * @see #unsetProcessingCapacityUnits()
	 * @see #setProcessingCapacityUnits(ProcessingCapacityUnitsType)
	 * @see com.ibm.ccl.soa.deploy.server.ServerPackage#getServer_ProcessingCapacityUnits()
	 * @model default="Unknown" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='processingCapacityUnits'"
	 * @generated
	 */
	ProcessingCapacityUnitsType getProcessingCapacityUnits();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#getProcessingCapacityUnits <em>Processing Capacity Units</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Processing Capacity Units</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.server.ProcessingCapacityUnitsType
	 * @see #isSetProcessingCapacityUnits()
	 * @see #unsetProcessingCapacityUnits()
	 * @see #getProcessingCapacityUnits()
	 * @generated
	 */
	void setProcessingCapacityUnits(ProcessingCapacityUnitsType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#getProcessingCapacityUnits <em>Processing Capacity Units</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetProcessingCapacityUnits()
	 * @see #getProcessingCapacityUnits()
	 * @see #setProcessingCapacityUnits(ProcessingCapacityUnitsType)
	 * @generated
	 */
	void unsetProcessingCapacityUnits();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#getProcessingCapacityUnits <em>Processing Capacity Units</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Processing Capacity Units</em>' attribute is set.
	 * @see #unsetProcessingCapacityUnits()
	 * @see #getProcessingCapacityUnits()
	 * @see #setProcessingCapacityUnits(ProcessingCapacityUnitsType)
	 * @generated
	 */
	boolean isSetProcessingCapacityUnits();

	/**
	 * Returns the value of the '<em><b>Rom Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rom Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * TODO
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Rom Version</em>' attribute.
	 * @see #setRomVersion(String)
	 * @see com.ibm.ccl.soa.deploy.server.ServerPackage#getServer_RomVersion()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='romVersion'"
	 * @generated
	 */
	String getRomVersion();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#getRomVersion <em>Rom Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rom Version</em>' attribute.
	 * @see #getRomVersion()
	 * @generated
	 */
	void setRomVersion(String value);

	/**
	 * Returns the value of the '<em><b>Serial Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Serial Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * e.g. "KPAMNL2"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Serial Number</em>' attribute.
	 * @see #setSerialNumber(String)
	 * @see com.ibm.ccl.soa.deploy.server.ServerPackage#getServer_SerialNumber()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='serialNumber'"
	 * @generated
	 */
	String getSerialNumber();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#getSerialNumber <em>Serial Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Serial Number</em>' attribute.
	 * @see #getSerialNumber()
	 * @generated
	 */
	void setSerialNumber(String value);

	/**
	 * Returns the value of the '<em><b>System Board UUID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Board UUID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * TODO
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>System Board UUID</em>' attribute.
	 * @see #setSystemBoardUUID(String)
	 * @see com.ibm.ccl.soa.deploy.server.ServerPackage#getServer_SystemBoardUUID()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='systemBoardUUID'"
	 * @generated
	 */
	String getSystemBoardUUID();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#getSystemBoardUUID <em>System Board UUID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System Board UUID</em>' attribute.
	 * @see #getSystemBoardUUID()
	 * @generated
	 */
	void setSystemBoardUUID(String value);

	/**
	 * Returns the value of the '<em><b>System Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * TODO
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>System Id</em>' attribute.
	 * @see #setSystemId(String)
	 * @see com.ibm.ccl.soa.deploy.server.ServerPackage#getServer_SystemId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='systemId'"
	 * @generated
	 */
	String getSystemId();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#getSystemId <em>System Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System Id</em>' attribute.
	 * @see #getSystemId()
	 * @generated
	 */
	void setSystemId(String value);

	/**
	 * Returns the value of the '<em><b>Virtual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Virtual</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							Boolean. Set to true if this is a virtual computer system. This flag should be set
	 * 							regardless of how the virtualization is implemented (Hardware - pSeries and ZSeries,
	 * 							OperatingSystem - VMWareESX, Application - VMWare). If the value is not known, leave it 
	 * 							unset.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Virtual</em>' attribute.
	 * @see #isSetVirtual()
	 * @see #unsetVirtual()
	 * @see #setVirtual(boolean)
	 * @see com.ibm.ccl.soa.deploy.server.ServerPackage#getServer_Virtual()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='virtual'"
	 * @generated
	 */
	boolean isVirtual();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#isVirtual <em>Virtual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Virtual</em>' attribute.
	 * @see #isSetVirtual()
	 * @see #unsetVirtual()
	 * @see #isVirtual()
	 * @generated
	 */
	void setVirtual(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#isVirtual <em>Virtual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetVirtual()
	 * @see #isVirtual()
	 * @see #setVirtual(boolean)
	 * @generated
	 */
	void unsetVirtual();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#isVirtual <em>Virtual</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Virtual</em>' attribute is set.
	 * @see #unsetVirtual()
	 * @see #isVirtual()
	 * @see #setVirtual(boolean)
	 * @generated
	 */
	boolean isSetVirtual();

	/**
	 * Returns the value of the '<em><b>Vmid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vmid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							The VMID is a unique identifier for the virtual machine. For pSeries this is the LPARID.
	 * 							pSeries boxex can have multiple LPARS running different operating systems. The pSeries
	 * 							implementation will return the same manufacturer, model, and serial number all the LPARs. So
	 * 							all ComputerSystems running in different LPARs end up getting incorrectly merged down to a
	 * 							single object. In order to avoid this merging in a pSeries environment, the LPARID shoiuld
	 * 							be saved in the VMID attribute.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Vmid</em>' attribute.
	 * @see #setVmid(String)
	 * @see com.ibm.ccl.soa.deploy.server.ServerPackage#getServer_Vmid()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='vmid'"
	 * @generated
	 */
	String getVmid();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.server.Server#getVmid <em>Vmid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vmid</em>' attribute.
	 * @see #getVmid()
	 * @generated
	 */
	void setVmid(String value);

} // Server
