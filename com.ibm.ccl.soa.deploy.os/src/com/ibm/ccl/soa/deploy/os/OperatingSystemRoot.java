/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os;

import java.util.Map;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Operating System Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityAixLocalGroup <em>Capability Aix Local Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityAixLocalService <em>Capability Aix Local Service</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityAixLocalUser <em>Capability Aix Local User</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityAixOperatingSystem <em>Capability Aix Operating System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityDataFile <em>Capability Data File</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityDirectory <em>Capability Directory</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityFileSystem <em>Capability File System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityFileSystemContent <em>Capability File System Content</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityLinuxLocalGroup <em>Capability Linux Local Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityLinuxLocalService <em>Capability Linux Local Service</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityLinuxLocalUser <em>Capability Linux Local User</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityLinuxOperatingSystem <em>Capability Linux Operating System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityLocalFileSystem <em>Capability Local File System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityNFSFileSystem <em>Capability NFS File System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityOpenVmsFileSystem <em>Capability Open Vms File System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityOperatingSystem <em>Capability Operating System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityPort <em>Capability Port</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityPortConsumer <em>Capability Port Consumer</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityRedhatLinuxLocalGroup <em>Capability Redhat Linux Local Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityRedhatLinuxLocalService <em>Capability Redhat Linux Local Service</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityRedhatLinuxLocalUser <em>Capability Redhat Linux Local User</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityRedhatLinuxOperatingSystem <em>Capability Redhat Linux Operating System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityRemoteFileSystem <em>Capability Remote File System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilitySMBFileSystem <em>Capability SMB File System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilitySolarisFileSystem <em>Capability Solaris File System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilitySuseLinuxLocalGroup <em>Capability Suse Linux Local Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilitySuseLinuxLocalService <em>Capability Suse Linux Local Service</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilitySuseLinuxLocalUser <em>Capability Suse Linux Local User</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilitySuseLinuxOperatingSystem <em>Capability Suse Linux Operating System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityUnixDirectory <em>Capability Unix Directory</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityUnixFileSystem <em>Capability Unix File System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityUser <em>Capability User</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityUserGroup <em>Capability User Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityWindowsDirectory <em>Capability Windows Directory</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityWindowsFileSystem <em>Capability Windows File System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityWindowsLocalGroup <em>Capability Windows Local Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityWindowsLocalService <em>Capability Windows Local Service</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityWindowsLocalUser <em>Capability Windows Local User</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityWindowsOperatingSystem <em>Capability Windows Operating System</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitAixLocalGroup <em>Unit Aix Local Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitAixLocalServiceUnit <em>Unit Aix Local Service Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitAixLocalUser <em>Unit Aix Local User</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitAixOperatingSystemUnit <em>Unit Aix Operating System Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitDataFileUnit <em>Unit Data File Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitDirectoryUnit <em>Unit Directory Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitFileSystemContentUnit <em>Unit File System Content Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitFileSystemUnit <em>Unit File System Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitLinuxLocalGroup <em>Unit Linux Local Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitLinuxLocalServiceUnit <em>Unit Linux Local Service Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitLinuxLocalUser <em>Unit Linux Local User</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitLinuxOperatingSystemUnit <em>Unit Linux Operating System Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitLocalFileSystemUnit <em>Unit Local File System Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitNFSFileSystemUnit <em>Unit NFS File System Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitOpenVmsFileSystemUnit <em>Unit Open Vms File System Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitOperatingSystemUnit <em>Unit Operating System Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitPortConfigUnit <em>Unit Port Config Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitRemoteFileSystemUnit <em>Unit Remote File System Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitSMBFileSystemUnit <em>Unit SMB File System Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitSolarisFileSystemUnit <em>Unit Solaris File System Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitUnixFileSystemUnit <em>Unit Unix File System Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitUser <em>Unit User</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitUserGroup <em>Unit User Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitWindowsFileSystemUnit <em>Unit Windows File System Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitWindowsLocalGroup <em>Unit Windows Local Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitWindowsLocalServiceUnit <em>Unit Windows Local Service Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitWindowsLocalUser <em>Unit Windows Local User</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitWindowsOperatingSystemUnit <em>Unit Windows Operating System Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface OperatingSystemRoot {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>XMLNS Prefix Map</b></em>' map. The key is of type
	 * {@link java.lang.String}, and the value is of type {@link java.lang.String}, <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XMLNS Prefix Map</em>' map isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>XMLNS Prefix Map</em>' map.
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_XMLNSPrefixMap()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String"
	 *        valueType="java.lang.String" transient="true" extendedMetaData="kind='attribute'
	 *        name='xmlns:prefix'"
	 * @generated
	 */
	Map getXMLNSPrefixMap();

	/**
	 * Returns the value of the '<em><b>XSI Schema Location</b></em>' map. The key is of type
	 * {@link java.lang.String}, and the value is of type {@link java.lang.String}, <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XSI Schema Location</em>' map isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>XSI Schema Location</em>' map.
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String"
	 *        valueType="java.lang.String" transient="true" extendedMetaData="kind='attribute'
	 *        name='xsi:schemaLocation'"
	 * @generated
	 */
	Map getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Capability Aix Local Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Aix Local Group</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Aix Local Group</em>' containment reference.
	 * @see #setCapabilityAixLocalGroup(AIXLocalGroup)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilityAixLocalGroup()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.aixLocalGroup' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	AIXLocalGroup getCapabilityAixLocalGroup();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityAixLocalGroup <em>Capability Aix Local Group</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Aix Local Group</em>' containment reference.
	 * @see #getCapabilityAixLocalGroup()
	 * @generated
	 */
	void setCapabilityAixLocalGroup(AIXLocalGroup value);

	/**
	 * Returns the value of the '<em><b>Capability Aix Local Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Aix Local Service</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Aix Local Service</em>' containment reference.
	 * @see #setCapabilityAixLocalService(AIXLocalService)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilityAixLocalService()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.aixLocalService' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	AIXLocalService getCapabilityAixLocalService();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityAixLocalService <em>Capability Aix Local Service</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Aix Local Service</em>' containment reference.
	 * @see #getCapabilityAixLocalService()
	 * @generated
	 */
	void setCapabilityAixLocalService(AIXLocalService value);

	/**
	 * Returns the value of the '<em><b>Capability Aix Local User</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Aix Local User</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Aix Local User</em>' containment reference.
	 * @see #setCapabilityAixLocalUser(AIXLocalUser)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilityAixLocalUser()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.aixLocalUser' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	AIXLocalUser getCapabilityAixLocalUser();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityAixLocalUser <em>Capability Aix Local User</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Aix Local User</em>' containment reference.
	 * @see #getCapabilityAixLocalUser()
	 * @generated
	 */
	void setCapabilityAixLocalUser(AIXLocalUser value);

	/**
	 * Returns the value of the '<em><b>Capability Aix Operating System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Aix Operating System</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Aix Operating System</em>' containment reference.
	 * @see #setCapabilityAixOperatingSystem(AIXOperatingSystem)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilityAixOperatingSystem()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.aixOperatingSystem' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	AIXOperatingSystem getCapabilityAixOperatingSystem();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityAixOperatingSystem <em>Capability Aix Operating System</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Aix Operating System</em>' containment reference.
	 * @see #getCapabilityAixOperatingSystem()
	 * @generated
	 */
	void setCapabilityAixOperatingSystem(AIXOperatingSystem value);

	/**
	 * Returns the value of the '<em><b>Capability Data File</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Data File</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Data File</em>' containment reference.
	 * @see #setCapabilityDataFile(DataFile)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilityDataFile()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.dataFile' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	DataFile getCapabilityDataFile();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityDataFile <em>Capability Data File</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Data File</em>' containment reference.
	 * @see #getCapabilityDataFile()
	 * @generated
	 */
	void setCapabilityDataFile(DataFile value);

	/**
	 * Returns the value of the '<em><b>Capability Directory</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Directory</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Directory</em>' containment reference.
	 * @see #setCapabilityDirectory(Directory)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilityDirectory()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.directory' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	Directory getCapabilityDirectory();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityDirectory <em>Capability Directory</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Directory</em>' containment reference.
	 * @see #getCapabilityDirectory()
	 * @generated
	 */
	void setCapabilityDirectory(Directory value);

	/**
	 * Returns the value of the '<em><b>Capability File System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability File System</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability File System</em>' containment reference.
	 * @see #setCapabilityFileSystem(FileSystem)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilityFileSystem()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.fileSystem' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	FileSystem getCapabilityFileSystem();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityFileSystem <em>Capability File System</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability File System</em>' containment reference.
	 * @see #getCapabilityFileSystem()
	 * @generated
	 */
	void setCapabilityFileSystem(FileSystem value);

	/**
	 * Returns the value of the '<em><b>Capability File System Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability File System Content</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability File System Content</em>' containment reference.
	 * @see #setCapabilityFileSystemContent(FileSystemContent)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilityFileSystemContent()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.fileSystemContent' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	FileSystemContent getCapabilityFileSystemContent();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityFileSystemContent <em>Capability File System Content</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability File System Content</em>' containment reference.
	 * @see #getCapabilityFileSystemContent()
	 * @generated
	 */
	void setCapabilityFileSystemContent(FileSystemContent value);

	/**
	 * Returns the value of the '<em><b>Capability Linux Local Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Linux Local Group</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Linux Local Group</em>' containment reference.
	 * @see #setCapabilityLinuxLocalGroup(LinuxLocalGroup)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilityLinuxLocalGroup()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.linuxLocalGroup' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	LinuxLocalGroup getCapabilityLinuxLocalGroup();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityLinuxLocalGroup <em>Capability Linux Local Group</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Linux Local Group</em>' containment reference.
	 * @see #getCapabilityLinuxLocalGroup()
	 * @generated
	 */
	void setCapabilityLinuxLocalGroup(LinuxLocalGroup value);

	/**
	 * Returns the value of the '<em><b>Capability Linux Local Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Linux Local Service</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Linux Local Service</em>' containment reference.
	 * @see #setCapabilityLinuxLocalService(LinuxLocalService)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilityLinuxLocalService()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.linuxLocalService' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	LinuxLocalService getCapabilityLinuxLocalService();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityLinuxLocalService <em>Capability Linux Local Service</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Linux Local Service</em>' containment reference.
	 * @see #getCapabilityLinuxLocalService()
	 * @generated
	 */
	void setCapabilityLinuxLocalService(LinuxLocalService value);

	/**
	 * Returns the value of the '<em><b>Capability Linux Local User</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Linux Local User</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Linux Local User</em>' containment reference.
	 * @see #setCapabilityLinuxLocalUser(LinuxLocalUser)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilityLinuxLocalUser()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.linuxLocalUser' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	LinuxLocalUser getCapabilityLinuxLocalUser();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityLinuxLocalUser <em>Capability Linux Local User</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Linux Local User</em>' containment reference.
	 * @see #getCapabilityLinuxLocalUser()
	 * @generated
	 */
	void setCapabilityLinuxLocalUser(LinuxLocalUser value);

	/**
	 * Returns the value of the '<em><b>Capability Linux Operating System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Linux Operating System</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Linux Operating System</em>' containment reference.
	 * @see #setCapabilityLinuxOperatingSystem(LinuxOperatingSystem)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilityLinuxOperatingSystem()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.linuxOperatingSystem' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	LinuxOperatingSystem getCapabilityLinuxOperatingSystem();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityLinuxOperatingSystem <em>Capability Linux Operating System</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Linux Operating System</em>' containment reference.
	 * @see #getCapabilityLinuxOperatingSystem()
	 * @generated
	 */
	void setCapabilityLinuxOperatingSystem(LinuxOperatingSystem value);

	/**
	 * Returns the value of the '<em><b>Capability Local File System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Local File System</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Local File System</em>' containment reference.
	 * @see #setCapabilityLocalFileSystem(LocalFileSystem)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilityLocalFileSystem()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.localFileSystem' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	LocalFileSystem getCapabilityLocalFileSystem();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityLocalFileSystem <em>Capability Local File System</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Local File System</em>' containment reference.
	 * @see #getCapabilityLocalFileSystem()
	 * @generated
	 */
	void setCapabilityLocalFileSystem(LocalFileSystem value);

	/**
	 * Returns the value of the '<em><b>Capability NFS File System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability NFS File System</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability NFS File System</em>' containment reference.
	 * @see #setCapabilityNFSFileSystem(NFSFileSystem)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilityNFSFileSystem()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.nFSFileSystem' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	NFSFileSystem getCapabilityNFSFileSystem();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityNFSFileSystem <em>Capability NFS File System</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability NFS File System</em>' containment reference.
	 * @see #getCapabilityNFSFileSystem()
	 * @generated
	 */
	void setCapabilityNFSFileSystem(NFSFileSystem value);

	/**
	 * Returns the value of the '<em><b>Capability Open Vms File System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Open Vms File System</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Open Vms File System</em>' containment reference.
	 * @see #setCapabilityOpenVmsFileSystem(OpenVmsFileSystem)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilityOpenVmsFileSystem()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.openVmsFileSystem' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	OpenVmsFileSystem getCapabilityOpenVmsFileSystem();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityOpenVmsFileSystem <em>Capability Open Vms File System</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Open Vms File System</em>' containment reference.
	 * @see #getCapabilityOpenVmsFileSystem()
	 * @generated
	 */
	void setCapabilityOpenVmsFileSystem(OpenVmsFileSystem value);

	/**
	 * Returns the value of the '<em><b>Capability Operating System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Operating System</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Operating System</em>' containment reference.
	 * @see #setCapabilityOperatingSystem(OperatingSystem)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilityOperatingSystem()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.operatingSystem' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	OperatingSystem getCapabilityOperatingSystem();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityOperatingSystem <em>Capability Operating System</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Operating System</em>' containment reference.
	 * @see #getCapabilityOperatingSystem()
	 * @generated
	 */
	void setCapabilityOperatingSystem(OperatingSystem value);

	/**
	 * Returns the value of the '<em><b>Capability Port</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Port</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Capability Port</em>' containment reference.
	 * @see #setCapabilityPort(Port)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilityPort()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.port' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	Port getCapabilityPort();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityPort <em>Capability Port</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Port</em>' containment reference.
	 * @see #getCapabilityPort()
	 * @generated
	 */
	void setCapabilityPort(Port value);

	/**
	 * Returns the value of the '<em><b>Capability Port Consumer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Port Consumer</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Port Consumer</em>' containment reference.
	 * @see #setCapabilityPortConsumer(PortConsumer)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilityPortConsumer()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.portConsumer' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	PortConsumer getCapabilityPortConsumer();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityPortConsumer <em>Capability Port Consumer</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Port Consumer</em>' containment reference.
	 * @see #getCapabilityPortConsumer()
	 * @generated
	 */
	void setCapabilityPortConsumer(PortConsumer value);

	/**
	 * Returns the value of the '<em><b>Capability Redhat Linux Local Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Redhat Linux Local Group</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Redhat Linux Local Group</em>' containment reference.
	 * @see #setCapabilityRedhatLinuxLocalGroup(RedhatLinuxLocalGroup)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilityRedhatLinuxLocalGroup()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.redhatLinuxLocalGroup' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	RedhatLinuxLocalGroup getCapabilityRedhatLinuxLocalGroup();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityRedhatLinuxLocalGroup <em>Capability Redhat Linux Local Group</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Redhat Linux Local Group</em>' containment reference.
	 * @see #getCapabilityRedhatLinuxLocalGroup()
	 * @generated
	 */
	void setCapabilityRedhatLinuxLocalGroup(RedhatLinuxLocalGroup value);

	/**
	 * Returns the value of the '<em><b>Capability Redhat Linux Local Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Redhat Linux Local Service</em>' containment
	 * reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Redhat Linux Local Service</em>' containment reference.
	 * @see #setCapabilityRedhatLinuxLocalService(RedhatLinuxLocalService)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilityRedhatLinuxLocalService()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.redhatLinuxLocalService' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	RedhatLinuxLocalService getCapabilityRedhatLinuxLocalService();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityRedhatLinuxLocalService <em>Capability Redhat Linux Local Service</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Redhat Linux Local Service</em>' containment reference.
	 * @see #getCapabilityRedhatLinuxLocalService()
	 * @generated
	 */
	void setCapabilityRedhatLinuxLocalService(RedhatLinuxLocalService value);

	/**
	 * Returns the value of the '<em><b>Capability Redhat Linux Local User</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Redhat Linux Local User</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Redhat Linux Local User</em>' containment reference.
	 * @see #setCapabilityRedhatLinuxLocalUser(RedhatLinuxLocalUser)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilityRedhatLinuxLocalUser()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.redhatLinuxLocalUser' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	RedhatLinuxLocalUser getCapabilityRedhatLinuxLocalUser();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityRedhatLinuxLocalUser <em>Capability Redhat Linux Local User</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Redhat Linux Local User</em>' containment reference.
	 * @see #getCapabilityRedhatLinuxLocalUser()
	 * @generated
	 */
	void setCapabilityRedhatLinuxLocalUser(RedhatLinuxLocalUser value);

	/**
	 * Returns the value of the '<em><b>Capability Redhat Linux Operating System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Redhat Linux Operating System</em>' containment
	 * reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Redhat Linux Operating System</em>' containment reference.
	 * @see #setCapabilityRedhatLinuxOperatingSystem(RedhatLinuxOperatingSystem)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilityRedhatLinuxOperatingSystem()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.redhatLinuxOperatingSystem' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	RedhatLinuxOperatingSystem getCapabilityRedhatLinuxOperatingSystem();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityRedhatLinuxOperatingSystem <em>Capability Redhat Linux Operating System</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Redhat Linux Operating System</em>' containment reference.
	 * @see #getCapabilityRedhatLinuxOperatingSystem()
	 * @generated
	 */
	void setCapabilityRedhatLinuxOperatingSystem(RedhatLinuxOperatingSystem value);

	/**
	 * Returns the value of the '<em><b>Capability Remote File System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Remote File System</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Remote File System</em>' containment reference.
	 * @see #setCapabilityRemoteFileSystem(RemoteFileSystem)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilityRemoteFileSystem()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.remoteFileSystem' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	RemoteFileSystem getCapabilityRemoteFileSystem();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityRemoteFileSystem <em>Capability Remote File System</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Remote File System</em>' containment reference.
	 * @see #getCapabilityRemoteFileSystem()
	 * @generated
	 */
	void setCapabilityRemoteFileSystem(RemoteFileSystem value);

	/**
	 * Returns the value of the '<em><b>Capability SMB File System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability SMB File System</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability SMB File System</em>' containment reference.
	 * @see #setCapabilitySMBFileSystem(SMBFileSystem)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilitySMBFileSystem()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.sMBFileSystem' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	SMBFileSystem getCapabilitySMBFileSystem();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilitySMBFileSystem <em>Capability SMB File System</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability SMB File System</em>' containment reference.
	 * @see #getCapabilitySMBFileSystem()
	 * @generated
	 */
	void setCapabilitySMBFileSystem(SMBFileSystem value);

	/**
	 * Returns the value of the '<em><b>Capability Solaris File System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Solaris File System</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Solaris File System</em>' containment reference.
	 * @see #setCapabilitySolarisFileSystem(SolarisFileSystem)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilitySolarisFileSystem()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.solarisFileSystem' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	SolarisFileSystem getCapabilitySolarisFileSystem();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilitySolarisFileSystem <em>Capability Solaris File System</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Solaris File System</em>' containment reference.
	 * @see #getCapabilitySolarisFileSystem()
	 * @generated
	 */
	void setCapabilitySolarisFileSystem(SolarisFileSystem value);

	/**
	 * Returns the value of the '<em><b>Capability Suse Linux Local Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Suse Linux Local Group</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Suse Linux Local Group</em>' containment reference.
	 * @see #setCapabilitySuseLinuxLocalGroup(SUSELinuxLocalGroup)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilitySuseLinuxLocalGroup()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.suseLinuxLocalGroup' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	SUSELinuxLocalGroup getCapabilitySuseLinuxLocalGroup();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilitySuseLinuxLocalGroup <em>Capability Suse Linux Local Group</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Suse Linux Local Group</em>' containment reference.
	 * @see #getCapabilitySuseLinuxLocalGroup()
	 * @generated
	 */
	void setCapabilitySuseLinuxLocalGroup(SUSELinuxLocalGroup value);

	/**
	 * Returns the value of the '<em><b>Capability Suse Linux Local Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Suse Linux Local Service</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Suse Linux Local Service</em>' containment reference.
	 * @see #setCapabilitySuseLinuxLocalService(SUSELinuxLocalService)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilitySuseLinuxLocalService()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.suseLinuxLocalService' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	SUSELinuxLocalService getCapabilitySuseLinuxLocalService();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilitySuseLinuxLocalService <em>Capability Suse Linux Local Service</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Suse Linux Local Service</em>' containment reference.
	 * @see #getCapabilitySuseLinuxLocalService()
	 * @generated
	 */
	void setCapabilitySuseLinuxLocalService(SUSELinuxLocalService value);

	/**
	 * Returns the value of the '<em><b>Capability Suse Linux Local User</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Suse Linux Local User</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Suse Linux Local User</em>' containment reference.
	 * @see #setCapabilitySuseLinuxLocalUser(SUSELinuxLocalUser)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilitySuseLinuxLocalUser()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.suseLinuxLocalUser' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	SUSELinuxLocalUser getCapabilitySuseLinuxLocalUser();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilitySuseLinuxLocalUser <em>Capability Suse Linux Local User</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Suse Linux Local User</em>' containment reference.
	 * @see #getCapabilitySuseLinuxLocalUser()
	 * @generated
	 */
	void setCapabilitySuseLinuxLocalUser(SUSELinuxLocalUser value);

	/**
	 * Returns the value of the '<em><b>Capability Suse Linux Operating System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Suse Linux Operating System</em>' containment
	 * reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Suse Linux Operating System</em>' containment reference.
	 * @see #setCapabilitySuseLinuxOperatingSystem(SUSELinuxOperatingSystem)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilitySuseLinuxOperatingSystem()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.suseLinuxOperatingSystem' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	SUSELinuxOperatingSystem getCapabilitySuseLinuxOperatingSystem();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilitySuseLinuxOperatingSystem <em>Capability Suse Linux Operating System</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Suse Linux Operating System</em>' containment reference.
	 * @see #getCapabilitySuseLinuxOperatingSystem()
	 * @generated
	 */
	void setCapabilitySuseLinuxOperatingSystem(SUSELinuxOperatingSystem value);

	/**
	 * Returns the value of the '<em><b>Capability Unix Directory</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Unix Directory</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Unix Directory</em>' containment reference.
	 * @see #setCapabilityUnixDirectory(UnixDirectory)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilityUnixDirectory()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.unixDirectory' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	UnixDirectory getCapabilityUnixDirectory();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityUnixDirectory <em>Capability Unix Directory</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Unix Directory</em>' containment reference.
	 * @see #getCapabilityUnixDirectory()
	 * @generated
	 */
	void setCapabilityUnixDirectory(UnixDirectory value);

	/**
	 * Returns the value of the '<em><b>Capability Unix File System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Unix File System</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Unix File System</em>' containment reference.
	 * @see #setCapabilityUnixFileSystem(UnixFileSystem)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilityUnixFileSystem()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.unixFileSystem' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	UnixFileSystem getCapabilityUnixFileSystem();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityUnixFileSystem <em>Capability Unix File System</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Unix File System</em>' containment reference.
	 * @see #getCapabilityUnixFileSystem()
	 * @generated
	 */
	void setCapabilityUnixFileSystem(UnixFileSystem value);

	/**
	 * Returns the value of the '<em><b>Capability User</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability User</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Capability User</em>' containment reference.
	 * @see #setCapabilityUser(User)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilityUser()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.user' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	User getCapabilityUser();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityUser <em>Capability User</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability User</em>' containment reference.
	 * @see #getCapabilityUser()
	 * @generated
	 */
	void setCapabilityUser(User value);

	/**
	 * Returns the value of the '<em><b>Capability User Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability User Group</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability User Group</em>' containment reference.
	 * @see #setCapabilityUserGroup(UserGroup)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilityUserGroup()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.userGroup' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	UserGroup getCapabilityUserGroup();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityUserGroup <em>Capability User Group</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability User Group</em>' containment reference.
	 * @see #getCapabilityUserGroup()
	 * @generated
	 */
	void setCapabilityUserGroup(UserGroup value);

	/**
	 * Returns the value of the '<em><b>Capability Windows Directory</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Windows Directory</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Windows Directory</em>' containment reference.
	 * @see #setCapabilityWindowsDirectory(WindowsDirectory)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilityWindowsDirectory()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.windowsDirectory' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WindowsDirectory getCapabilityWindowsDirectory();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityWindowsDirectory <em>Capability Windows Directory</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Windows Directory</em>' containment reference.
	 * @see #getCapabilityWindowsDirectory()
	 * @generated
	 */
	void setCapabilityWindowsDirectory(WindowsDirectory value);

	/**
	 * Returns the value of the '<em><b>Capability Windows File System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Windows File System</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Windows File System</em>' containment reference.
	 * @see #setCapabilityWindowsFileSystem(WindowsFileSystem)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilityWindowsFileSystem()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.windowsFileSystem' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WindowsFileSystem getCapabilityWindowsFileSystem();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityWindowsFileSystem <em>Capability Windows File System</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Windows File System</em>' containment reference.
	 * @see #getCapabilityWindowsFileSystem()
	 * @generated
	 */
	void setCapabilityWindowsFileSystem(WindowsFileSystem value);

	/**
	 * Returns the value of the '<em><b>Capability Windows Local Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Windows Local Group</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Windows Local Group</em>' containment reference.
	 * @see #setCapabilityWindowsLocalGroup(WindowsLocalGroup)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilityWindowsLocalGroup()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.windowsLocalGroup' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WindowsLocalGroup getCapabilityWindowsLocalGroup();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityWindowsLocalGroup <em>Capability Windows Local Group</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Windows Local Group</em>' containment reference.
	 * @see #getCapabilityWindowsLocalGroup()
	 * @generated
	 */
	void setCapabilityWindowsLocalGroup(WindowsLocalGroup value);

	/**
	 * Returns the value of the '<em><b>Capability Windows Local Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Windows Local Service</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Windows Local Service</em>' containment reference.
	 * @see #setCapabilityWindowsLocalService(WindowsLocalService)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilityWindowsLocalService()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.windowsLocalService' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WindowsLocalService getCapabilityWindowsLocalService();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityWindowsLocalService <em>Capability Windows Local Service</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Windows Local Service</em>' containment reference.
	 * @see #getCapabilityWindowsLocalService()
	 * @generated
	 */
	void setCapabilityWindowsLocalService(WindowsLocalService value);

	/**
	 * Returns the value of the '<em><b>Capability Windows Local User</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Windows Local User</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Windows Local User</em>' containment reference.
	 * @see #setCapabilityWindowsLocalUser(WindowsLocalUser)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilityWindowsLocalUser()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.windowsLocalUser' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WindowsLocalUser getCapabilityWindowsLocalUser();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityWindowsLocalUser <em>Capability Windows Local User</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Windows Local User</em>' containment reference.
	 * @see #getCapabilityWindowsLocalUser()
	 * @generated
	 */
	void setCapabilityWindowsLocalUser(WindowsLocalUser value);

	/**
	 * Returns the value of the '<em><b>Capability Windows Operating System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Windows Operating System</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Windows Operating System</em>' containment reference.
	 * @see #setCapabilityWindowsOperatingSystem(WindowsOperatingSystem)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_CapabilityWindowsOperatingSystem()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.windowsOperatingSystem' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	WindowsOperatingSystem getCapabilityWindowsOperatingSystem();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityWindowsOperatingSystem <em>Capability Windows Operating System</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Windows Operating System</em>' containment reference.
	 * @see #getCapabilityWindowsOperatingSystem()
	 * @generated
	 */
	void setCapabilityWindowsOperatingSystem(WindowsOperatingSystem value);

	/**
	 * Returns the value of the '<em><b>Unit Aix Local Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Aix Local Group</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Aix Local Group</em>' containment reference.
	 * @see #setUnitAixLocalGroup(AIXLocalGroupUnit)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_UnitAixLocalGroup()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.aixLocalGroup' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	AIXLocalGroupUnit getUnitAixLocalGroup();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitAixLocalGroup <em>Unit Aix Local Group</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Aix Local Group</em>' containment reference.
	 * @see #getUnitAixLocalGroup()
	 * @generated
	 */
	void setUnitAixLocalGroup(AIXLocalGroupUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Aix Local Service Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Aix Local Service Unit</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Aix Local Service Unit</em>' containment reference.
	 * @see #setUnitAixLocalServiceUnit(AIXLocalServiceUnit)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_UnitAixLocalServiceUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.aixLocalServiceUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	AIXLocalServiceUnit getUnitAixLocalServiceUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitAixLocalServiceUnit <em>Unit Aix Local Service Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Aix Local Service Unit</em>' containment reference.
	 * @see #getUnitAixLocalServiceUnit()
	 * @generated
	 */
	void setUnitAixLocalServiceUnit(AIXLocalServiceUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Aix Local User</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Aix Local User</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Aix Local User</em>' containment reference.
	 * @see #setUnitAixLocalUser(AIXLocalUserUnit)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_UnitAixLocalUser()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.aixLocalUser' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	AIXLocalUserUnit getUnitAixLocalUser();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitAixLocalUser <em>Unit Aix Local User</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Aix Local User</em>' containment reference.
	 * @see #getUnitAixLocalUser()
	 * @generated
	 */
	void setUnitAixLocalUser(AIXLocalUserUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Aix Operating System Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Aix Operating System Unit</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Aix Operating System Unit</em>' containment reference.
	 * @see #setUnitAixOperatingSystemUnit(AIXOperatingSystemUnit)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_UnitAixOperatingSystemUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.aixOperatingSystemUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	AIXOperatingSystemUnit getUnitAixOperatingSystemUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitAixOperatingSystemUnit <em>Unit Aix Operating System Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Aix Operating System Unit</em>' containment reference.
	 * @see #getUnitAixOperatingSystemUnit()
	 * @generated
	 */
	void setUnitAixOperatingSystemUnit(AIXOperatingSystemUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Data File Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Data File Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Data File Unit</em>' containment reference.
	 * @see #setUnitDataFileUnit(DataFileUnit)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_UnitDataFileUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.dataFileUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	DataFileUnit getUnitDataFileUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitDataFileUnit <em>Unit Data File Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Data File Unit</em>' containment reference.
	 * @see #getUnitDataFileUnit()
	 * @generated
	 */
	void setUnitDataFileUnit(DataFileUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Directory Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Directory Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Directory Unit</em>' containment reference.
	 * @see #setUnitDirectoryUnit(DirectoryUnit)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_UnitDirectoryUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.directoryUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	DirectoryUnit getUnitDirectoryUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitDirectoryUnit <em>Unit Directory Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Directory Unit</em>' containment reference.
	 * @see #getUnitDirectoryUnit()
	 * @generated
	 */
	void setUnitDirectoryUnit(DirectoryUnit value);

	/**
	 * Returns the value of the '<em><b>Unit File System Content Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit File System Content Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit File System Content Unit</em>' containment reference.
	 * @see #setUnitFileSystemContentUnit(FileSystemContentUnit)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_UnitFileSystemContentUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.fileSystemContentUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	FileSystemContentUnit getUnitFileSystemContentUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitFileSystemContentUnit <em>Unit File System Content Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit File System Content Unit</em>' containment reference.
	 * @see #getUnitFileSystemContentUnit()
	 * @generated
	 */
	void setUnitFileSystemContentUnit(FileSystemContentUnit value);

	/**
	 * Returns the value of the '<em><b>Unit File System Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit File System Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit File System Unit</em>' containment reference.
	 * @see #setUnitFileSystemUnit(FileSystemUnit)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_UnitFileSystemUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.fileSystemUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	FileSystemUnit getUnitFileSystemUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitFileSystemUnit <em>Unit File System Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit File System Unit</em>' containment reference.
	 * @see #getUnitFileSystemUnit()
	 * @generated
	 */
	void setUnitFileSystemUnit(FileSystemUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Linux Local Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Linux Local Group</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Linux Local Group</em>' containment reference.
	 * @see #setUnitLinuxLocalGroup(LinuxLocalGroupUnit)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_UnitLinuxLocalGroup()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.linuxLocalGroup' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	LinuxLocalGroupUnit getUnitLinuxLocalGroup();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitLinuxLocalGroup <em>Unit Linux Local Group</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Linux Local Group</em>' containment reference.
	 * @see #getUnitLinuxLocalGroup()
	 * @generated
	 */
	void setUnitLinuxLocalGroup(LinuxLocalGroupUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Linux Local Service Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Linux Local Service Unit</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Linux Local Service Unit</em>' containment reference.
	 * @see #setUnitLinuxLocalServiceUnit(LinuxLocalServiceUnit)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_UnitLinuxLocalServiceUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.linuxLocalServiceUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	LinuxLocalServiceUnit getUnitLinuxLocalServiceUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitLinuxLocalServiceUnit <em>Unit Linux Local Service Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Linux Local Service Unit</em>' containment reference.
	 * @see #getUnitLinuxLocalServiceUnit()
	 * @generated
	 */
	void setUnitLinuxLocalServiceUnit(LinuxLocalServiceUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Linux Local User</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Linux Local User</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Linux Local User</em>' containment reference.
	 * @see #setUnitLinuxLocalUser(LinuxLocalUserUnit)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_UnitLinuxLocalUser()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.linuxLocalUser' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	LinuxLocalUserUnit getUnitLinuxLocalUser();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitLinuxLocalUser <em>Unit Linux Local User</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Linux Local User</em>' containment reference.
	 * @see #getUnitLinuxLocalUser()
	 * @generated
	 */
	void setUnitLinuxLocalUser(LinuxLocalUserUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Linux Operating System Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Linux Operating System Unit</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Linux Operating System Unit</em>' containment reference.
	 * @see #setUnitLinuxOperatingSystemUnit(LinuxOperatingSystemUnit)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_UnitLinuxOperatingSystemUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.linuxOperatingSystemUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	LinuxOperatingSystemUnit getUnitLinuxOperatingSystemUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitLinuxOperatingSystemUnit <em>Unit Linux Operating System Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Linux Operating System Unit</em>' containment reference.
	 * @see #getUnitLinuxOperatingSystemUnit()
	 * @generated
	 */
	void setUnitLinuxOperatingSystemUnit(LinuxOperatingSystemUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Local File System Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Local File System Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Local File System Unit</em>' containment reference.
	 * @see #setUnitLocalFileSystemUnit(LocalFileSystemUnit)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_UnitLocalFileSystemUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.localFileSystemUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	LocalFileSystemUnit getUnitLocalFileSystemUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitLocalFileSystemUnit <em>Unit Local File System Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Local File System Unit</em>' containment reference.
	 * @see #getUnitLocalFileSystemUnit()
	 * @generated
	 */
	void setUnitLocalFileSystemUnit(LocalFileSystemUnit value);

	/**
	 * Returns the value of the '<em><b>Unit NFS File System Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit NFS File System Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit NFS File System Unit</em>' containment reference.
	 * @see #setUnitNFSFileSystemUnit(NFSFileSystemUnit)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_UnitNFSFileSystemUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.nFSFileSystemUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	NFSFileSystemUnit getUnitNFSFileSystemUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitNFSFileSystemUnit <em>Unit NFS File System Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit NFS File System Unit</em>' containment reference.
	 * @see #getUnitNFSFileSystemUnit()
	 * @generated
	 */
	void setUnitNFSFileSystemUnit(NFSFileSystemUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Open Vms File System Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Open Vms File System Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Open Vms File System Unit</em>' containment reference.
	 * @see #setUnitOpenVmsFileSystemUnit(OpenVmsFileSystemUnit)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_UnitOpenVmsFileSystemUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.openVmsFileSystemUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	OpenVmsFileSystemUnit getUnitOpenVmsFileSystemUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitOpenVmsFileSystemUnit <em>Unit Open Vms File System Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Open Vms File System Unit</em>' containment reference.
	 * @see #getUnitOpenVmsFileSystemUnit()
	 * @generated
	 */
	void setUnitOpenVmsFileSystemUnit(OpenVmsFileSystemUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Operating System Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Operating System Unit</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Operating System Unit</em>' containment reference.
	 * @see #setUnitOperatingSystemUnit(OperatingSystemUnit)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_UnitOperatingSystemUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.operatingSystemUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	OperatingSystemUnit getUnitOperatingSystemUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitOperatingSystemUnit <em>Unit Operating System Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Operating System Unit</em>' containment reference.
	 * @see #getUnitOperatingSystemUnit()
	 * @generated
	 */
	void setUnitOperatingSystemUnit(OperatingSystemUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Port Config Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Port Config Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Port Config Unit</em>' containment reference.
	 * @see #setUnitPortConfigUnit(PortConfigUnit)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_UnitPortConfigUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.portConfigUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	PortConfigUnit getUnitPortConfigUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitPortConfigUnit <em>Unit Port Config Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Port Config Unit</em>' containment reference.
	 * @see #getUnitPortConfigUnit()
	 * @generated
	 */
	void setUnitPortConfigUnit(PortConfigUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Remote File System Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Remote File System Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Remote File System Unit</em>' containment reference.
	 * @see #setUnitRemoteFileSystemUnit(RemoteFileSystemUnit)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_UnitRemoteFileSystemUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.remoteFileSystemUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	RemoteFileSystemUnit getUnitRemoteFileSystemUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitRemoteFileSystemUnit <em>Unit Remote File System Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Remote File System Unit</em>' containment reference.
	 * @see #getUnitRemoteFileSystemUnit()
	 * @generated
	 */
	void setUnitRemoteFileSystemUnit(RemoteFileSystemUnit value);

	/**
	 * Returns the value of the '<em><b>Unit SMB File System Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit SMB File System Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit SMB File System Unit</em>' containment reference.
	 * @see #setUnitSMBFileSystemUnit(SMBFileSystemUnit)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_UnitSMBFileSystemUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.sMBFileSystemUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	SMBFileSystemUnit getUnitSMBFileSystemUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitSMBFileSystemUnit <em>Unit SMB File System Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit SMB File System Unit</em>' containment reference.
	 * @see #getUnitSMBFileSystemUnit()
	 * @generated
	 */
	void setUnitSMBFileSystemUnit(SMBFileSystemUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Solaris File System Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Solaris File System Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Solaris File System Unit</em>' containment reference.
	 * @see #setUnitSolarisFileSystemUnit(SolarisFileSystemUnit)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_UnitSolarisFileSystemUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.solarisFileSystemUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	SolarisFileSystemUnit getUnitSolarisFileSystemUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitSolarisFileSystemUnit <em>Unit Solaris File System Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Solaris File System Unit</em>' containment reference.
	 * @see #getUnitSolarisFileSystemUnit()
	 * @generated
	 */
	void setUnitSolarisFileSystemUnit(SolarisFileSystemUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Unix File System Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Unix File System Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Unix File System Unit</em>' containment reference.
	 * @see #setUnitUnixFileSystemUnit(UnixFileSystemUnit)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_UnitUnixFileSystemUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.unixFileSystemUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	UnixFileSystemUnit getUnitUnixFileSystemUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitUnixFileSystemUnit <em>Unit Unix File System Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Unix File System Unit</em>' containment reference.
	 * @see #getUnitUnixFileSystemUnit()
	 * @generated
	 */
	void setUnitUnixFileSystemUnit(UnixFileSystemUnit value);

	/**
	 * Returns the value of the '<em><b>Unit User</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit User</em>' containment reference isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Unit User</em>' containment reference.
	 * @see #setUnitUser(UserUnit)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_UnitUser()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.user' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	UserUnit getUnitUser();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitUser <em>Unit User</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit User</em>' containment reference.
	 * @see #getUnitUser()
	 * @generated
	 */
	void setUnitUser(UserUnit value);

	/**
	 * Returns the value of the '<em><b>Unit User Group</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit User Group</em>' containment reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Unit User Group</em>' containment reference.
	 * @see #setUnitUserGroup(UserGroupUnit)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_UnitUserGroup()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.userGroup' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	UserGroupUnit getUnitUserGroup();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitUserGroup <em>Unit User Group</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit User Group</em>' containment reference.
	 * @see #getUnitUserGroup()
	 * @generated
	 */
	void setUnitUserGroup(UserGroupUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Windows File System Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Windows File System Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Windows File System Unit</em>' containment reference.
	 * @see #setUnitWindowsFileSystemUnit(WindowsFileSystemUnit)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_UnitWindowsFileSystemUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.windowsFileSystemUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WindowsFileSystemUnit getUnitWindowsFileSystemUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitWindowsFileSystemUnit <em>Unit Windows File System Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Windows File System Unit</em>' containment reference.
	 * @see #getUnitWindowsFileSystemUnit()
	 * @generated
	 */
	void setUnitWindowsFileSystemUnit(WindowsFileSystemUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Windows Local Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Windows Local Group</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Windows Local Group</em>' containment reference.
	 * @see #setUnitWindowsLocalGroup(WindowsLocalGroupUnit)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_UnitWindowsLocalGroup()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.windowsLocalGroup' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WindowsLocalGroupUnit getUnitWindowsLocalGroup();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitWindowsLocalGroup <em>Unit Windows Local Group</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Windows Local Group</em>' containment reference.
	 * @see #getUnitWindowsLocalGroup()
	 * @generated
	 */
	void setUnitWindowsLocalGroup(WindowsLocalGroupUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Windows Local Service Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Windows Local Service Unit</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Windows Local Service Unit</em>' containment reference.
	 * @see #setUnitWindowsLocalServiceUnit(WindowsLocalServiceUnit)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_UnitWindowsLocalServiceUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.windowsLocalServiceUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WindowsLocalServiceUnit getUnitWindowsLocalServiceUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitWindowsLocalServiceUnit <em>Unit Windows Local Service Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Windows Local Service Unit</em>' containment reference.
	 * @see #getUnitWindowsLocalServiceUnit()
	 * @generated
	 */
	void setUnitWindowsLocalServiceUnit(WindowsLocalServiceUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Windows Local User</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Windows Local User</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Windows Local User</em>' containment reference.
	 * @see #setUnitWindowsLocalUser(WindowsLocalUserUnit)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_UnitWindowsLocalUser()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.windowsLocalUser' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WindowsLocalUserUnit getUnitWindowsLocalUser();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitWindowsLocalUser <em>Unit Windows Local User</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Windows Local User</em>' containment reference.
	 * @see #getUnitWindowsLocalUser()
	 * @generated
	 */
	void setUnitWindowsLocalUser(WindowsLocalUserUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Windows Operating System Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Windows Operating System Unit</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Windows Operating System Unit</em>' containment reference.
	 * @see #setUnitWindowsOperatingSystemUnit(WindowsOperatingSystemUnit)
	 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemRoot_UnitWindowsOperatingSystemUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.windowsOperatingSystemUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	WindowsOperatingSystemUnit getUnitWindowsOperatingSystemUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitWindowsOperatingSystemUnit <em>Unit Windows Operating System Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Windows Operating System Unit</em>' containment reference.
	 * @see #getUnitWindowsOperatingSystemUnit()
	 * @generated
	 */
	void setUnitWindowsOperatingSystemUnit(WindowsOperatingSystemUnit value);

} // OperatingSystemRoot
