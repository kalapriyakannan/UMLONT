/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Operating System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getFqdn <em>Fqdn</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getHostname <em>Hostname</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getKernelArchitecture <em>Kernel Architecture</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getKernelVersion <em>Kernel Version</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getKernelWidth <em>Kernel Width</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getLocale <em>Locale</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getManufacturer <em>Manufacturer</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getOsDistribution <em>Os Distribution</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getOsServicepack <em>Os Servicepack</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getOsType <em>Os Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getOsVersion <em>Os Version</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getTimeZone <em>Time Zone</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystem()
 * @model extendedMetaData="name='OperatingSystem' kind='elementOnly'"
 * @generated
 */
public interface OperatingSystem extends Capability {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Fqdn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fqdn</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							Fully qualified domain name. e.g. "foo.watson.ibm.com." In practice the trailing "." is
	 * 							often omitted.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Fqdn</em>' attribute.
	 * @see #setFqdn(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystem_Fqdn()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='fqdn'"
	 * @generated
	 */
	String getFqdn();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getFqdn <em>Fqdn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fqdn</em>' attribute.
	 * @see #getFqdn()
	 * @generated
	 */
	void setFqdn(String value);

	/**
	 * Returns the value of the '<em><b>Hostname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hostname</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							A hostname, which could be a simple hostname or qualified name up to a full fqdn. In many
	 * 							operating systems, what would be returned by "hostname" from a command line.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Hostname</em>' attribute.
	 * @see #setHostname(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystem_Hostname()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='hostname'"
	 * @generated
	 */
	String getHostname();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getHostname <em>Hostname</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hostname</em>' attribute.
	 * @see #getHostname()
	 * @generated
	 */
	void setHostname(String value);

	/**
	 * Returns the value of the '<em><b>Kernel Architecture</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kernel Architecture</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * e.g. Intel (Windows), or i686 (Linux). TODO an enumeration?
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Kernel Architecture</em>' attribute.
	 * @see #setKernelArchitecture(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystem_KernelArchitecture()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='kernelArchitecture'"
	 * @generated
	 */
	String getKernelArchitecture();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getKernelArchitecture <em>Kernel Architecture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kernel Architecture</em>' attribute.
	 * @see #getKernelArchitecture()
	 * @generated
	 */
	void setKernelArchitecture(String value);

	/**
	 * Returns the value of the '<em><b>Kernel Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kernel Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * e.g. 5.1.2600 (Windows), or 2.6.9-55.0.2.ELsmp (Linux).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Kernel Version</em>' attribute.
	 * @see #setKernelVersion(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystem_KernelVersion()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='kernelVersion'"
	 * @generated
	 */
	String getKernelVersion();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getKernelVersion <em>Kernel Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kernel Version</em>' attribute.
	 * @see #getKernelVersion()
	 * @generated
	 */
	void setKernelVersion(String value);

	/**
	 * Returns the value of the '<em><b>Kernel Width</b></em>' attribute.
	 * The default value is <code>"32-bit"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.os.KernelWidthType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An enumeration, "32-bit" or "64-bit"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Kernel Width</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.KernelWidthType
	 * @see #isSetKernelWidth()
	 * @see #unsetKernelWidth()
	 * @see #setKernelWidth(KernelWidthType)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystem_KernelWidth()
	 * @model default="32-bit" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='kernelWidth'"
	 * @generated
	 */
	KernelWidthType getKernelWidth();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getKernelWidth <em>Kernel Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kernel Width</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.os.KernelWidthType
	 * @see #isSetKernelWidth()
	 * @see #unsetKernelWidth()
	 * @see #getKernelWidth()
	 * @generated
	 */
	void setKernelWidth(KernelWidthType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getKernelWidth <em>Kernel Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetKernelWidth()
	 * @see #getKernelWidth()
	 * @see #setKernelWidth(KernelWidthType)
	 * @generated
	 */
	void unsetKernelWidth();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getKernelWidth <em>Kernel Width</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Kernel Width</em>' attribute is set.
	 * @see #unsetKernelWidth()
	 * @see #getKernelWidth()
	 * @see #setKernelWidth(KernelWidthType)
	 * @generated
	 */
	boolean isSetKernelWidth();

	/**
	 * Returns the value of the '<em><b>Locale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Locale</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * In Linux, e.g. “en_US”. In Windows WMI, e.g. “0409”
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Locale</em>' attribute.
	 * @see #setLocale(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystem_Locale()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='locale'"
	 * @generated
	 */
	String getLocale();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getLocale <em>Locale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Locale</em>' attribute.
	 * @see #getLocale()
	 * @generated
	 */
	void setLocale(String value);

	/**
	 * Returns the value of the '<em><b>Manufacturer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Manufacturer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * TODO
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Manufacturer</em>' attribute.
	 * @see #setManufacturer(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystem_Manufacturer()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='manufacturer'"
	 * @generated
	 */
	String getManufacturer();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getManufacturer <em>Manufacturer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manufacturer</em>' attribute.
	 * @see #getManufacturer()
	 * @generated
	 */
	void setManufacturer(String value);

	/**
	 * Returns the value of the '<em><b>Os Distribution</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Os Distribution</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * e.g. "SuSE" if osType is "Linux"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Os Distribution</em>' attribute.
	 * @see #setOsDistribution(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystem_OsDistribution()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='os.distribution'"
	 * @generated
	 */
	String getOsDistribution();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getOsDistribution <em>Os Distribution</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Os Distribution</em>' attribute.
	 * @see #getOsDistribution()
	 * @generated
	 */
	void setOsDistribution(String value);

	/**
	 * Returns the value of the '<em><b>Os Servicepack</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Os Servicepack</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * e.g. "SP5" for Windows 2000
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Os Servicepack</em>' attribute.
	 * @see #setOsServicepack(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystem_OsServicepack()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='os.servicepack'"
	 * @generated
	 */
	String getOsServicepack();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getOsServicepack <em>Os Servicepack</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Os Servicepack</em>' attribute.
	 * @see #getOsServicepack()
	 * @generated
	 */
	void setOsServicepack(String value);

	/**
	 * Returns the value of the '<em><b>Os Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Os Type</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							e.g. "AIX", "Windows-Cygwin", "HPUX", "Linux", "Solaris", "Windows". Use the values from the
	 * 							OperatingSystemType enumeration if applicable.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Os Type</em>' attribute.
	 * @see #setOsType(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystem_OsType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='os.type'"
	 * @generated
	 */
	String getOsType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getOsType <em>Os Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Os Type</em>' attribute.
	 * @see #getOsType()
	 * @generated
	 */
	void setOsType(String value);

	/**
	 * Returns the value of the '<em><b>Os Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Os Version</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * e.g. "4.0"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Os Version</em>' attribute.
	 * @see #setOsVersion(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystem_OsVersion()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='os.version'"
	 * @generated
	 */
	String getOsVersion();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getOsVersion <em>Os Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Os Version</em>' attribute.
	 * @see #getOsVersion()
	 * @generated
	 */
	void setOsVersion(String value);

	/**
	 * Returns the value of the '<em><b>Time Zone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Zone</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Zone</em>' attribute.
	 * @see #setTimeZone(String)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystem_TimeZone()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='TimeZone'"
	 * @generated
	 */
	String getTimeZone();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getTimeZone <em>Time Zone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Zone</em>' attribute.
	 * @see #getTimeZone()
	 * @generated
	 */
	void setTimeZone(String value);

} // OperatingSystem
