/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta
 * objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc --> <!-- begin-model-doc -->
 * 
 * The core model for SOA Deploy. A {@link Topology} contains {@link Unit}s. Units contain
 * {@Capability}s, {@Requirement}s, and {@UnitLink}s. Extension domains are encouraged to extend
 * Unit and Capability but not Topology, Requirement, or UnitLink.
 * 
 * 
 * An object that can be part of a deployable module. See {@link FileArtifact}.
 * 
 * <!-- end-model-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.os.OsFactory
 * @model kind="package"
 * @generated
 */
public interface OsPackage extends EPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "os"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ibm.com/ccl/soa/deploy/os/1.0.0/"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "os"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	OsPackage eINSTANCE = com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemImpl <em>Operating System</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.OperatingSystemImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getOperatingSystem()
	 * @generated
	 */
	int OPERATING_SYSTEM = 30;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.LinuxOperatingSystemImpl <em>Linux Operating System</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.LinuxOperatingSystemImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getLinuxOperatingSystem()
	 * @generated
	 */
	int LINUX_OPERATING_SYSTEM = 22;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl <em>Operating System Root</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getOperatingSystemRoot()
	 * @generated
	 */
	int OPERATING_SYSTEM_ROOT = 31;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemUnitImpl <em>Operating System Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.OperatingSystemUnitImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getOperatingSystemUnit()
	 * @generated
	 */
	int OPERATING_SYSTEM_UNIT = 32;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.PortImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getPort()
	 * @generated
	 */
	int PORT = 33;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.PortConfigUnitImpl <em>Port Config Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.PortConfigUnitImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getPortConfigUnit()
	 * @generated
	 */
	int PORT_CONFIG_UNIT = 34;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.PortConsumerImpl <em>Port Consumer</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.PortConsumerImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getPortConsumer()
	 * @generated
	 */
	int PORT_CONSUMER = 35;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.RedhatLinuxLocalServiceImpl <em>Redhat Linux Local Service</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.RedhatLinuxLocalServiceImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getRedhatLinuxLocalService()
	 * @generated
	 */
	int REDHAT_LINUX_LOCAL_SERVICE = 37;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.RedhatLinuxOperatingSystemImpl <em>Redhat Linux Operating System</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.RedhatLinuxOperatingSystemImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getRedhatLinuxOperatingSystem()
	 * @generated
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM = 39;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.UserImpl <em>User</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.UserImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getUser()
	 * @generated
	 */
	int USER = 53;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.LinuxLocalUserImpl <em>Linux Local User</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.LinuxLocalUserImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getLinuxLocalUser()
	 * @generated
	 */
	int LINUX_LOCAL_USER = 20;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.UserGroupImpl <em>User Group</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.UserGroupImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getUserGroup()
	 * @generated
	 */
	int USER_GROUP = 54;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.LinuxLocalGroupImpl <em>Linux Local Group</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.LinuxLocalGroupImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getLinuxLocalGroup()
	 * @generated
	 */
	int LINUX_LOCAL_GROUP = 16;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.LinuxLocalServiceImpl <em>Linux Local Service</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.LinuxLocalServiceImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getLinuxLocalService()
	 * @generated
	 */
	int LINUX_LOCAL_SERVICE = 18;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.LinuxLocalServiceUnitImpl <em>Linux Local Service Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.LinuxLocalServiceUnitImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getLinuxLocalServiceUnit()
	 * @generated
	 */
	int LINUX_LOCAL_SERVICE_UNIT = 19;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.LinuxOperatingSystemUnitImpl <em>Linux Operating System Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.LinuxOperatingSystemUnitImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getLinuxOperatingSystemUnit()
	 * @generated
	 */
	int LINUX_OPERATING_SYSTEM_UNIT = 23;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.RedhatLinuxLocalGroupImpl <em>Redhat Linux Local Group</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.RedhatLinuxLocalGroupImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getRedhatLinuxLocalGroup()
	 * @generated
	 */
	int REDHAT_LINUX_LOCAL_GROUP = 36;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.UserGroupUnitImpl <em>User Group Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.UserGroupUnitImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getUserGroupUnit()
	 * @generated
	 */
	int USER_GROUP_UNIT = 55;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.LinuxLocalGroupUnitImpl <em>Linux Local Group Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.LinuxLocalGroupUnitImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getLinuxLocalGroupUnit()
	 * @generated
	 */
	int LINUX_LOCAL_GROUP_UNIT = 17;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.UserUnitImpl <em>User Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.UserUnitImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getUserUnit()
	 * @generated
	 */
	int USER_UNIT = 56;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.LinuxLocalUserUnitImpl <em>Linux Local User Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.LinuxLocalUserUnitImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getLinuxLocalUserUnit()
	 * @generated
	 */
	int LINUX_LOCAL_USER_UNIT = 21;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.RedhatLinuxLocalUserImpl <em>Redhat Linux Local User</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.RedhatLinuxLocalUserImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getRedhatLinuxLocalUser()
	 * @generated
	 */
	int REDHAT_LINUX_LOCAL_USER = 38;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER_GROUP__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_GROUP__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_GROUP__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER_GROUP__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER_GROUP__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER_GROUP__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER_GROUP__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_GROUP__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_GROUP__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_GROUP__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_GROUP__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_GROUP__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_GROUP__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_GROUP__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_GROUP__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Group Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_GROUP__GROUP_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>User Group</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_GROUP_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalGroupImpl <em>AIX Local Group</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.AIXLocalGroupImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getAIXLocalGroup()
	 * @generated
	 */
	int AIX_LOCAL_GROUP = 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP__ANNOTATIONS = USER_GROUP__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP__ATTRIBUTE_META_DATA = USER_GROUP__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP__EXTENDED_ATTRIBUTES = USER_GROUP__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP__ARTIFACT_GROUP = USER_GROUP__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP__ARTIFACTS = USER_GROUP__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP__CONSTRAINT_GROUP = USER_GROUP__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP__CONSTRAINTS = USER_GROUP__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP__DESCRIPTION = USER_GROUP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP__DISPLAY_NAME = USER_GROUP__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP__MUTABLE = USER_GROUP__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP__NAME = USER_GROUP__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP__STEREOTYPES = USER_GROUP__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP__BUILD_VERSION = USER_GROUP__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP__LINK_TYPE = USER_GROUP__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP__ORIGIN = USER_GROUP__ORIGIN;

	/**
	 * The feature id for the '<em><b>Group Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP__GROUP_NAME = USER_GROUP__GROUP_NAME;

	/**
	 * The feature id for the '<em><b>Group Description</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP__GROUP_DESCRIPTION = USER_GROUP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Group Sid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP__GROUP_SID = USER_GROUP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>AIX Local Group</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP_FEATURE_COUNT = USER_GROUP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER_GROUP_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_GROUP_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_GROUP_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER_GROUP_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER_GROUP_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER_GROUP_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER_GROUP_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_GROUP_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_GROUP_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_GROUP_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_GROUP_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER_GROUP_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER_GROUP_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER_GROUP_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER_GROUP_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER_GROUP_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER_GROUP_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_GROUP_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_GROUP_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_GROUP_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_GROUP_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_GROUP_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER_GROUP_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER_GROUP_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER_GROUP_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_GROUP_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_GROUP_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>User Group Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER_GROUP_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalGroupUnitImpl <em>AIX Local Group Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.AIXLocalGroupUnitImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getAIXLocalGroupUnit()
	 * @generated
	 */
	int AIX_LOCAL_GROUP_UNIT = 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP_UNIT__ANNOTATIONS = USER_GROUP_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP_UNIT__ATTRIBUTE_META_DATA = USER_GROUP_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP_UNIT__EXTENDED_ATTRIBUTES = USER_GROUP_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP_UNIT__ARTIFACT_GROUP = USER_GROUP_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP_UNIT__ARTIFACTS = USER_GROUP_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP_UNIT__CONSTRAINT_GROUP = USER_GROUP_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP_UNIT__CONSTRAINTS = USER_GROUP_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP_UNIT__DESCRIPTION = USER_GROUP_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP_UNIT__DISPLAY_NAME = USER_GROUP_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP_UNIT__MUTABLE = USER_GROUP_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP_UNIT__NAME = USER_GROUP_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP_UNIT__CAPABILITY_GROUP = USER_GROUP_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP_UNIT__CAPABILITIES = USER_GROUP_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP_UNIT__REQUIREMENT_GROUP = USER_GROUP_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP_UNIT__REQUIREMENTS = USER_GROUP_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP_UNIT__UNIT_LINKS_GROUP = USER_GROUP_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP_UNIT__UNIT_LINKS = USER_GROUP_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP_UNIT__CONSTRAINT_LINKS = USER_GROUP_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP_UNIT__REALIZATION_LINKS = USER_GROUP_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP_UNIT__STEREOTYPES = USER_GROUP_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP_UNIT__BUILD_VERSION = USER_GROUP_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP_UNIT__CONCEPTUAL = USER_GROUP_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP_UNIT__CONFIGURATION_UNIT = USER_GROUP_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP_UNIT__GOAL_INSTALL_STATE = USER_GROUP_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP_UNIT__INIT_INSTALL_STATE = USER_GROUP_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP_UNIT__ORIGIN = USER_GROUP_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP_UNIT__PUBLISH_INTENT = USER_GROUP_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>AIX Local Group Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_GROUP_UNIT_FEATURE_COUNT = USER_GROUP_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalServiceImpl <em>AIX Local Service</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.AIXLocalServiceImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getAIXLocalService()
	 * @generated
	 */
	int AIX_LOCAL_SERVICE = 2;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Action Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE__ACTION_TYPE = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Executable Path</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE__EXECUTABLE_PATH = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Service Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE__SERVICE_DESCRIPTION = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Startup Run Level Eight</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_EIGHT = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Startup Run Level Five</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FIVE = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Startup Run Level Four</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FOUR = CorePackage.CAPABILITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Startup Run Level Nine</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_NINE = CorePackage.CAPABILITY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Startup Run Level One</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ONE = CorePackage.CAPABILITY_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Startup Run Level Seven</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_SEVEN = CorePackage.CAPABILITY_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Startup Run Level Six</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_SIX = CorePackage.CAPABILITY_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Startup Run Level Three</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_THREE = CorePackage.CAPABILITY_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Startup Run Level Two</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_TWO = CorePackage.CAPABILITY_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Startup Run Level Zero</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ZERO = CorePackage.CAPABILITY_FEATURE_COUNT + 12;

	/**
	 * The number of structural features of the '<em>AIX Local Service</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 13;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalServiceUnitImpl <em>AIX Local Service Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.AIXLocalServiceUnitImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getAIXLocalServiceUnit()
	 * @generated
	 */
	int AIX_LOCAL_SERVICE_UNIT = 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>AIX Local Service Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_SERVICE_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>User Id</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__USER_ID = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>User Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__USER_PASSWORD = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl <em>AIX Local User</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getAIXLocalUser()
	 * @generated
	 */
	int AIX_LOCAL_USER = 4;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__ANNOTATIONS = USER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__ATTRIBUTE_META_DATA = USER__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__EXTENDED_ATTRIBUTES = USER__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__ARTIFACT_GROUP = USER__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__ARTIFACTS = USER__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__CONSTRAINT_GROUP = USER__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__CONSTRAINTS = USER__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__DESCRIPTION = USER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__DISPLAY_NAME = USER__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__MUTABLE = USER__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__NAME = USER__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__STEREOTYPES = USER__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__BUILD_VERSION = USER__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__LINK_TYPE = USER__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__ORIGIN = USER__ORIGIN;

	/**
	 * The feature id for the '<em><b>User Id</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__USER_ID = USER__USER_ID;

	/**
	 * The feature id for the '<em><b>User Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__USER_PASSWORD = USER__USER_PASSWORD;

	/**
	 * The feature id for the '<em><b>Account Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__ACCOUNT_DESCRIPTION = USER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Account Disabled</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__ACCOUNT_DISABLED = USER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Account Expiration Time</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__ACCOUNT_EXPIRATION_TIME = USER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Change Password Next Logon</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__CHANGE_PASSWORD_NEXT_LOGON = USER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Full Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__FULL_NAME = USER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Home Dir</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__HOME_DIR = USER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Is Admin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__IS_ADMIN = USER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Login Permitted</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__LOGIN_PERMITTED = USER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Login Retries</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__LOGIN_RETRIES = USER_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Login Times</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__LOGIN_TIMES = USER_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Max Char Repeats</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__MAX_CHAR_REPEATS = USER_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Max Password Age In Weeks</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__MAX_PASSWORD_AGE_IN_WEEKS = USER_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Max Password Valid Weeks</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__MAX_PASSWORD_VALID_WEEKS = USER_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Min Alpha Chars In Password</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__MIN_ALPHA_CHARS_IN_PASSWORD = USER_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Min Diff Chars</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__MIN_DIFF_CHARS = USER_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Min Other Chars In Password</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__MIN_OTHER_CHARS_IN_PASSWORD = USER_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Min Password Age In Weeks</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__MIN_PASSWORD_AGE_IN_WEEKS = USER_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Min Password Length</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__MIN_PASSWORD_LENGTH = USER_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Not Reusable Number Of Passwords</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__NOT_REUSABLE_NUMBER_OF_PASSWORDS = USER_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Pass Reuse Not Allowed In Weeks</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__PASS_REUSE_NOT_ALLOWED_IN_WEEKS = USER_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Password Change Warn Time</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__PASSWORD_CHANGE_WARN_TIME = USER_FEATURE_COUNT + 20;

	/**
	 * The feature id for the '<em><b>Password Never Expires</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__PASSWORD_NEVER_EXPIRES = USER_FEATURE_COUNT + 21;

	/**
	 * The feature id for the '<em><b>Primary Auth Method</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__PRIMARY_AUTH_METHOD = USER_FEATURE_COUNT + 22;

	/**
	 * The feature id for the '<em><b>Remote Login Is Allowed</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__REMOTE_LOGIN_IS_ALLOWED = USER_FEATURE_COUNT + 23;

	/**
	 * The feature id for the '<em><b>Secondary Auth Method</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__SECONDARY_AUTH_METHOD = USER_FEATURE_COUNT + 24;

	/**
	 * The feature id for the '<em><b>Shell</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__SHELL = USER_FEATURE_COUNT + 25;

	/**
	 * The feature id for the '<em><b>Su Groups Allowed</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__SU_GROUPS_ALLOWED = USER_FEATURE_COUNT + 26;

	/**
	 * The feature id for the '<em><b>Su Is Allowed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__SU_IS_ALLOWED = USER_FEATURE_COUNT + 27;

	/**
	 * The feature id for the '<em><b>Time Last Login</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__TIME_LAST_LOGIN = USER_FEATURE_COUNT + 28;

	/**
	 * The feature id for the '<em><b>User Cannot Change Password</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__USER_CANNOT_CHANGE_PASSWORD = USER_FEATURE_COUNT + 29;

	/**
	 * The feature id for the '<em><b>User Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__USER_NAME = USER_FEATURE_COUNT + 30;

	/**
	 * The feature id for the '<em><b>User Registering Method</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__USER_REGISTERING_METHOD = USER_FEATURE_COUNT + 31;

	/**
	 * The feature id for the '<em><b>User Sid</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__USER_SID = USER_FEATURE_COUNT + 32;

	/**
	 * The feature id for the '<em><b>Usuccessful Login Count</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER__USUCCESSFUL_LOGIN_COUNT = USER_FEATURE_COUNT + 33;

	/**
	 * The number of structural features of the '<em>AIX Local User</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER_FEATURE_COUNT = USER_FEATURE_COUNT + 34;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int USER_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>User Unit</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserUnitImpl <em>AIX Local User Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserUnitImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getAIXLocalUserUnit()
	 * @generated
	 */
	int AIX_LOCAL_USER_UNIT = 5;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER_UNIT__ANNOTATIONS = USER_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER_UNIT__ATTRIBUTE_META_DATA = USER_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER_UNIT__EXTENDED_ATTRIBUTES = USER_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER_UNIT__ARTIFACT_GROUP = USER_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER_UNIT__ARTIFACTS = USER_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER_UNIT__CONSTRAINT_GROUP = USER_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER_UNIT__CONSTRAINTS = USER_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER_UNIT__DESCRIPTION = USER_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER_UNIT__DISPLAY_NAME = USER_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER_UNIT__MUTABLE = USER_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER_UNIT__NAME = USER_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER_UNIT__CAPABILITY_GROUP = USER_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER_UNIT__CAPABILITIES = USER_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER_UNIT__REQUIREMENT_GROUP = USER_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER_UNIT__REQUIREMENTS = USER_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER_UNIT__UNIT_LINKS_GROUP = USER_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER_UNIT__UNIT_LINKS = USER_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER_UNIT__CONSTRAINT_LINKS = USER_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER_UNIT__REALIZATION_LINKS = USER_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER_UNIT__STEREOTYPES = USER_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER_UNIT__BUILD_VERSION = USER_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER_UNIT__CONCEPTUAL = USER_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER_UNIT__CONFIGURATION_UNIT = USER_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER_UNIT__GOAL_INSTALL_STATE = USER_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER_UNIT__INIT_INSTALL_STATE = USER_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER_UNIT__ORIGIN = USER_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER_UNIT__PUBLISH_INTENT = USER_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>AIX Local User Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_LOCAL_USER_UNIT_FEATURE_COUNT = USER_UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Fqdn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM__FQDN = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Hostname</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM__HOSTNAME = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Kernel Architecture</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM__KERNEL_ARCHITECTURE = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Kernel Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM__KERNEL_VERSION = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Kernel Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM__KERNEL_WIDTH = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Locale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM__LOCALE = CorePackage.CAPABILITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Manufacturer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM__MANUFACTURER = CorePackage.CAPABILITY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Os Distribution</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM__OS_DISTRIBUTION = CorePackage.CAPABILITY_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Os Servicepack</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM__OS_SERVICEPACK = CorePackage.CAPABILITY_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Os Type</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM__OS_TYPE = CorePackage.CAPABILITY_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Os Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM__OS_VERSION = CorePackage.CAPABILITY_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Time Zone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM__TIME_ZONE = CorePackage.CAPABILITY_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Operating System</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 12;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.AIXOperatingSystemImpl <em>AIX Operating System</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.AIXOperatingSystemImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getAIXOperatingSystem()
	 * @generated
	 */
	int AIX_OPERATING_SYSTEM = 6;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM__ANNOTATIONS = OPERATING_SYSTEM__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM__ATTRIBUTE_META_DATA = OPERATING_SYSTEM__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM__EXTENDED_ATTRIBUTES = OPERATING_SYSTEM__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM__ARTIFACT_GROUP = OPERATING_SYSTEM__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM__ARTIFACTS = OPERATING_SYSTEM__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM__CONSTRAINT_GROUP = OPERATING_SYSTEM__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM__CONSTRAINTS = OPERATING_SYSTEM__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM__DESCRIPTION = OPERATING_SYSTEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM__DISPLAY_NAME = OPERATING_SYSTEM__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM__MUTABLE = OPERATING_SYSTEM__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM__NAME = OPERATING_SYSTEM__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM__STEREOTYPES = OPERATING_SYSTEM__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM__BUILD_VERSION = OPERATING_SYSTEM__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM__LINK_TYPE = OPERATING_SYSTEM__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM__ORIGIN = OPERATING_SYSTEM__ORIGIN;

	/**
	 * The feature id for the '<em><b>Fqdn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM__FQDN = OPERATING_SYSTEM__FQDN;

	/**
	 * The feature id for the '<em><b>Hostname</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM__HOSTNAME = OPERATING_SYSTEM__HOSTNAME;

	/**
	 * The feature id for the '<em><b>Kernel Architecture</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM__KERNEL_ARCHITECTURE = OPERATING_SYSTEM__KERNEL_ARCHITECTURE;

	/**
	 * The feature id for the '<em><b>Kernel Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM__KERNEL_VERSION = OPERATING_SYSTEM__KERNEL_VERSION;

	/**
	 * The feature id for the '<em><b>Kernel Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM__KERNEL_WIDTH = OPERATING_SYSTEM__KERNEL_WIDTH;

	/**
	 * The feature id for the '<em><b>Locale</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM__LOCALE = OPERATING_SYSTEM__LOCALE;

	/**
	 * The feature id for the '<em><b>Manufacturer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM__MANUFACTURER = OPERATING_SYSTEM__MANUFACTURER;

	/**
	 * The feature id for the '<em><b>Os Distribution</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM__OS_DISTRIBUTION = OPERATING_SYSTEM__OS_DISTRIBUTION;

	/**
	 * The feature id for the '<em><b>Os Servicepack</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM__OS_SERVICEPACK = OPERATING_SYSTEM__OS_SERVICEPACK;

	/**
	 * The feature id for the '<em><b>Os Type</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM__OS_TYPE = OPERATING_SYSTEM__OS_TYPE;

	/**
	 * The feature id for the '<em><b>Os Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM__OS_VERSION = OPERATING_SYSTEM__OS_VERSION;

	/**
	 * The feature id for the '<em><b>Time Zone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM__TIME_ZONE = OPERATING_SYSTEM__TIME_ZONE;

	/**
	 * The feature id for the '<em><b>Desktop</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM__DESKTOP = OPERATING_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Install Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM__INSTALL_DATE = OPERATING_SYSTEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Kernel</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM__KERNEL = OPERATING_SYSTEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Last Boot Up Time</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM__LAST_BOOT_UP_TIME = OPERATING_SYSTEM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM__OWNER = OPERATING_SYSTEM_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>TCB</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM__TCB = OPERATING_SYSTEM_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>AIX Operating System</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM_FEATURE_COUNT = OPERATING_SYSTEM_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Operating System Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.AIXOperatingSystemUnitImpl <em>AIX Operating System Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.AIXOperatingSystemUnitImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getAIXOperatingSystemUnit()
	 * @generated
	 */
	int AIX_OPERATING_SYSTEM_UNIT = 7;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM_UNIT__ANNOTATIONS = OPERATING_SYSTEM_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM_UNIT__ATTRIBUTE_META_DATA = OPERATING_SYSTEM_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM_UNIT__EXTENDED_ATTRIBUTES = OPERATING_SYSTEM_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM_UNIT__ARTIFACT_GROUP = OPERATING_SYSTEM_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM_UNIT__ARTIFACTS = OPERATING_SYSTEM_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM_UNIT__CONSTRAINT_GROUP = OPERATING_SYSTEM_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM_UNIT__CONSTRAINTS = OPERATING_SYSTEM_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM_UNIT__DESCRIPTION = OPERATING_SYSTEM_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM_UNIT__DISPLAY_NAME = OPERATING_SYSTEM_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM_UNIT__MUTABLE = OPERATING_SYSTEM_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM_UNIT__NAME = OPERATING_SYSTEM_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM_UNIT__CAPABILITY_GROUP = OPERATING_SYSTEM_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM_UNIT__CAPABILITIES = OPERATING_SYSTEM_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM_UNIT__REQUIREMENT_GROUP = OPERATING_SYSTEM_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM_UNIT__REQUIREMENTS = OPERATING_SYSTEM_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM_UNIT__UNIT_LINKS_GROUP = OPERATING_SYSTEM_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM_UNIT__UNIT_LINKS = OPERATING_SYSTEM_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM_UNIT__CONSTRAINT_LINKS = OPERATING_SYSTEM_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM_UNIT__REALIZATION_LINKS = OPERATING_SYSTEM_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM_UNIT__STEREOTYPES = OPERATING_SYSTEM_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM_UNIT__BUILD_VERSION = OPERATING_SYSTEM_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM_UNIT__CONCEPTUAL = OPERATING_SYSTEM_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM_UNIT__CONFIGURATION_UNIT = OPERATING_SYSTEM_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM_UNIT__GOAL_INSTALL_STATE = OPERATING_SYSTEM_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM_UNIT__INIT_INSTALL_STATE = OPERATING_SYSTEM_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM_UNIT__ORIGIN = OPERATING_SYSTEM_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM_UNIT__PUBLISH_INTENT = OPERATING_SYSTEM_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>AIX Operating System Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AIX_OPERATING_SYSTEM_UNIT_FEATURE_COUNT = OPERATING_SYSTEM_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.FileSystemContentImpl <em>File System Content</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.FileSystemContentImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getFileSystemContent()
	 * @generated
	 */
	int FILE_SYSTEM_CONTENT = 13;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Fixed Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT__FIXED_PATH = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT__GROUP = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Last Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT__LAST_MODIFIED = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT__OWNER = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Permissions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT__PERMISSIONS = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Real File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT__REAL_FILE = CorePackage.CAPABILITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT__SIZE = CorePackage.CAPABILITY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT__URI = CorePackage.CAPABILITY_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>File System Content</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.DataFileImpl <em>Data File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.DataFileImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getDataFile()
	 * @generated
	 */
	int DATA_FILE = 8;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE__ANNOTATIONS = FILE_SYSTEM_CONTENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE__ATTRIBUTE_META_DATA = FILE_SYSTEM_CONTENT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE__EXTENDED_ATTRIBUTES = FILE_SYSTEM_CONTENT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE__ARTIFACT_GROUP = FILE_SYSTEM_CONTENT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE__ARTIFACTS = FILE_SYSTEM_CONTENT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE__CONSTRAINT_GROUP = FILE_SYSTEM_CONTENT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE__CONSTRAINTS = FILE_SYSTEM_CONTENT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE__DESCRIPTION = FILE_SYSTEM_CONTENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE__DISPLAY_NAME = FILE_SYSTEM_CONTENT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE__MUTABLE = FILE_SYSTEM_CONTENT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE__NAME = FILE_SYSTEM_CONTENT__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE__STEREOTYPES = FILE_SYSTEM_CONTENT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE__BUILD_VERSION = FILE_SYSTEM_CONTENT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE__LINK_TYPE = FILE_SYSTEM_CONTENT__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE__ORIGIN = FILE_SYSTEM_CONTENT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Fixed Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE__FIXED_PATH = FILE_SYSTEM_CONTENT__FIXED_PATH;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE__GROUP = FILE_SYSTEM_CONTENT__GROUP;

	/**
	 * The feature id for the '<em><b>Last Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE__LAST_MODIFIED = FILE_SYSTEM_CONTENT__LAST_MODIFIED;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE__OWNER = FILE_SYSTEM_CONTENT__OWNER;

	/**
	 * The feature id for the '<em><b>Permissions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE__PERMISSIONS = FILE_SYSTEM_CONTENT__PERMISSIONS;

	/**
	 * The feature id for the '<em><b>Real File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE__REAL_FILE = FILE_SYSTEM_CONTENT__REAL_FILE;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE__SIZE = FILE_SYSTEM_CONTENT__SIZE;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE__URI = FILE_SYSTEM_CONTENT__URI;

	/**
	 * The number of structural features of the '<em>Data File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE_FEATURE_COUNT = FILE_SYSTEM_CONTENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.FileSystemContentUnitImpl <em>File System Content Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.FileSystemContentUnitImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getFileSystemContentUnit()
	 * @generated
	 */
	int FILE_SYSTEM_CONTENT_UNIT = 14;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>File System Content Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_CONTENT_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.DataFileUnitImpl <em>Data File Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.DataFileUnitImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getDataFileUnit()
	 * @generated
	 */
	int DATA_FILE_UNIT = 9;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE_UNIT__ANNOTATIONS = FILE_SYSTEM_CONTENT_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE_UNIT__ATTRIBUTE_META_DATA = FILE_SYSTEM_CONTENT_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE_UNIT__EXTENDED_ATTRIBUTES = FILE_SYSTEM_CONTENT_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE_UNIT__ARTIFACT_GROUP = FILE_SYSTEM_CONTENT_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE_UNIT__ARTIFACTS = FILE_SYSTEM_CONTENT_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE_UNIT__CONSTRAINT_GROUP = FILE_SYSTEM_CONTENT_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE_UNIT__CONSTRAINTS = FILE_SYSTEM_CONTENT_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE_UNIT__DESCRIPTION = FILE_SYSTEM_CONTENT_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE_UNIT__DISPLAY_NAME = FILE_SYSTEM_CONTENT_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE_UNIT__MUTABLE = FILE_SYSTEM_CONTENT_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE_UNIT__NAME = FILE_SYSTEM_CONTENT_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE_UNIT__CAPABILITY_GROUP = FILE_SYSTEM_CONTENT_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE_UNIT__CAPABILITIES = FILE_SYSTEM_CONTENT_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE_UNIT__REQUIREMENT_GROUP = FILE_SYSTEM_CONTENT_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE_UNIT__REQUIREMENTS = FILE_SYSTEM_CONTENT_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE_UNIT__UNIT_LINKS_GROUP = FILE_SYSTEM_CONTENT_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE_UNIT__UNIT_LINKS = FILE_SYSTEM_CONTENT_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE_UNIT__CONSTRAINT_LINKS = FILE_SYSTEM_CONTENT_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE_UNIT__REALIZATION_LINKS = FILE_SYSTEM_CONTENT_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE_UNIT__STEREOTYPES = FILE_SYSTEM_CONTENT_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE_UNIT__BUILD_VERSION = FILE_SYSTEM_CONTENT_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE_UNIT__CONCEPTUAL = FILE_SYSTEM_CONTENT_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE_UNIT__CONFIGURATION_UNIT = FILE_SYSTEM_CONTENT_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE_UNIT__GOAL_INSTALL_STATE = FILE_SYSTEM_CONTENT_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE_UNIT__INIT_INSTALL_STATE = FILE_SYSTEM_CONTENT_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE_UNIT__ORIGIN = FILE_SYSTEM_CONTENT_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE_UNIT__PUBLISH_INTENT = FILE_SYSTEM_CONTENT_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Data File Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FILE_UNIT_FEATURE_COUNT = FILE_SYSTEM_CONTENT_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.DirectoryImpl <em>Directory</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.DirectoryImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getDirectory()
	 * @generated
	 */
	int DIRECTORY = 10;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__ANNOTATIONS = FILE_SYSTEM_CONTENT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__ATTRIBUTE_META_DATA = FILE_SYSTEM_CONTENT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__EXTENDED_ATTRIBUTES = FILE_SYSTEM_CONTENT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__ARTIFACT_GROUP = FILE_SYSTEM_CONTENT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__ARTIFACTS = FILE_SYSTEM_CONTENT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__CONSTRAINT_GROUP = FILE_SYSTEM_CONTENT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__CONSTRAINTS = FILE_SYSTEM_CONTENT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__DESCRIPTION = FILE_SYSTEM_CONTENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__DISPLAY_NAME = FILE_SYSTEM_CONTENT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__MUTABLE = FILE_SYSTEM_CONTENT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__NAME = FILE_SYSTEM_CONTENT__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__STEREOTYPES = FILE_SYSTEM_CONTENT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__BUILD_VERSION = FILE_SYSTEM_CONTENT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__LINK_TYPE = FILE_SYSTEM_CONTENT__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__ORIGIN = FILE_SYSTEM_CONTENT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Fixed Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__FIXED_PATH = FILE_SYSTEM_CONTENT__FIXED_PATH;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__GROUP = FILE_SYSTEM_CONTENT__GROUP;

	/**
	 * The feature id for the '<em><b>Last Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__LAST_MODIFIED = FILE_SYSTEM_CONTENT__LAST_MODIFIED;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__OWNER = FILE_SYSTEM_CONTENT__OWNER;

	/**
	 * The feature id for the '<em><b>Permissions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__PERMISSIONS = FILE_SYSTEM_CONTENT__PERMISSIONS;

	/**
	 * The feature id for the '<em><b>Real File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__REAL_FILE = FILE_SYSTEM_CONTENT__REAL_FILE;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__SIZE = FILE_SYSTEM_CONTENT__SIZE;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__URI = FILE_SYSTEM_CONTENT__URI;

	/**
	 * The feature id for the '<em><b>Directory Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY__DIRECTORY_PATH = FILE_SYSTEM_CONTENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Directory</em>' class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_FEATURE_COUNT = FILE_SYSTEM_CONTENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.DirectoryUnitImpl <em>Directory Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.DirectoryUnitImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getDirectoryUnit()
	 * @generated
	 */
	int DIRECTORY_UNIT = 11;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_UNIT__ANNOTATIONS = FILE_SYSTEM_CONTENT_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_UNIT__ATTRIBUTE_META_DATA = FILE_SYSTEM_CONTENT_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_UNIT__EXTENDED_ATTRIBUTES = FILE_SYSTEM_CONTENT_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_UNIT__ARTIFACT_GROUP = FILE_SYSTEM_CONTENT_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_UNIT__ARTIFACTS = FILE_SYSTEM_CONTENT_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_UNIT__CONSTRAINT_GROUP = FILE_SYSTEM_CONTENT_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_UNIT__CONSTRAINTS = FILE_SYSTEM_CONTENT_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_UNIT__DESCRIPTION = FILE_SYSTEM_CONTENT_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_UNIT__DISPLAY_NAME = FILE_SYSTEM_CONTENT_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_UNIT__MUTABLE = FILE_SYSTEM_CONTENT_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_UNIT__NAME = FILE_SYSTEM_CONTENT_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_UNIT__CAPABILITY_GROUP = FILE_SYSTEM_CONTENT_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_UNIT__CAPABILITIES = FILE_SYSTEM_CONTENT_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_UNIT__REQUIREMENT_GROUP = FILE_SYSTEM_CONTENT_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_UNIT__REQUIREMENTS = FILE_SYSTEM_CONTENT_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_UNIT__UNIT_LINKS_GROUP = FILE_SYSTEM_CONTENT_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_UNIT__UNIT_LINKS = FILE_SYSTEM_CONTENT_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_UNIT__CONSTRAINT_LINKS = FILE_SYSTEM_CONTENT_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_UNIT__REALIZATION_LINKS = FILE_SYSTEM_CONTENT_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_UNIT__STEREOTYPES = FILE_SYSTEM_CONTENT_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_UNIT__BUILD_VERSION = FILE_SYSTEM_CONTENT_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_UNIT__CONCEPTUAL = FILE_SYSTEM_CONTENT_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_UNIT__CONFIGURATION_UNIT = FILE_SYSTEM_CONTENT_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_UNIT__GOAL_INSTALL_STATE = FILE_SYSTEM_CONTENT_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_UNIT__INIT_INSTALL_STATE = FILE_SYSTEM_CONTENT_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_UNIT__ORIGIN = FILE_SYSTEM_CONTENT_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_UNIT__PUBLISH_INTENT = FILE_SYSTEM_CONTENT_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Directory Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIRECTORY_UNIT_FEATURE_COUNT = FILE_SYSTEM_CONTENT_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.FileSystemImpl <em>File System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.FileSystemImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getFileSystem()
	 * @generated
	 */
	int FILE_SYSTEM = 12;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Available Space</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM__AVAILABLE_SPACE = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM__CAPACITY = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Mount Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM__MOUNT_POINT = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM__TYPE = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>File System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.FileSystemUnitImpl <em>File System Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.FileSystemUnitImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getFileSystemUnit()
	 * @generated
	 */
	int FILE_SYSTEM_UNIT = 15;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>File System Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_SYSTEM_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP__ANNOTATIONS = USER_GROUP__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP__ATTRIBUTE_META_DATA = USER_GROUP__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP__EXTENDED_ATTRIBUTES = USER_GROUP__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP__ARTIFACT_GROUP = USER_GROUP__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP__ARTIFACTS = USER_GROUP__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP__CONSTRAINT_GROUP = USER_GROUP__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP__CONSTRAINTS = USER_GROUP__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP__DESCRIPTION = USER_GROUP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP__DISPLAY_NAME = USER_GROUP__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP__MUTABLE = USER_GROUP__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP__NAME = USER_GROUP__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP__STEREOTYPES = USER_GROUP__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP__BUILD_VERSION = USER_GROUP__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP__LINK_TYPE = USER_GROUP__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP__ORIGIN = USER_GROUP__ORIGIN;

	/**
	 * The feature id for the '<em><b>Group Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP__GROUP_NAME = USER_GROUP__GROUP_NAME;

	/**
	 * The feature id for the '<em><b>Group Description</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP__GROUP_DESCRIPTION = USER_GROUP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Linux Local Group</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP_FEATURE_COUNT = USER_GROUP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP_UNIT__ANNOTATIONS = USER_GROUP_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP_UNIT__ATTRIBUTE_META_DATA = USER_GROUP_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP_UNIT__EXTENDED_ATTRIBUTES = USER_GROUP_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP_UNIT__ARTIFACT_GROUP = USER_GROUP_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP_UNIT__ARTIFACTS = USER_GROUP_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP_UNIT__CONSTRAINT_GROUP = USER_GROUP_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP_UNIT__CONSTRAINTS = USER_GROUP_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP_UNIT__DESCRIPTION = USER_GROUP_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP_UNIT__DISPLAY_NAME = USER_GROUP_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP_UNIT__MUTABLE = USER_GROUP_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP_UNIT__NAME = USER_GROUP_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP_UNIT__CAPABILITY_GROUP = USER_GROUP_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP_UNIT__CAPABILITIES = USER_GROUP_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP_UNIT__REQUIREMENT_GROUP = USER_GROUP_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP_UNIT__REQUIREMENTS = USER_GROUP_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP_UNIT__UNIT_LINKS_GROUP = USER_GROUP_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP_UNIT__UNIT_LINKS = USER_GROUP_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP_UNIT__CONSTRAINT_LINKS = USER_GROUP_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP_UNIT__REALIZATION_LINKS = USER_GROUP_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP_UNIT__STEREOTYPES = USER_GROUP_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP_UNIT__BUILD_VERSION = USER_GROUP_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP_UNIT__CONCEPTUAL = USER_GROUP_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP_UNIT__CONFIGURATION_UNIT = USER_GROUP_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP_UNIT__GOAL_INSTALL_STATE = USER_GROUP_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP_UNIT__INIT_INSTALL_STATE = USER_GROUP_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP_UNIT__ORIGIN = USER_GROUP_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP_UNIT__PUBLISH_INTENT = USER_GROUP_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Linux Local Group Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_GROUP_UNIT_FEATURE_COUNT = USER_GROUP_UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Executable Path</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE__EXECUTABLE_PATH = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Service Account</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE__SERVICE_ACCOUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Service Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE__SERVICE_DESCRIPTION = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Service Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE__SERVICE_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Service Status</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE__SERVICE_STATUS = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Startup Run Level Five</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FIVE = CorePackage.CAPABILITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Startup Run Level Four</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FOUR = CorePackage.CAPABILITY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Startup Run Level One</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ONE = CorePackage.CAPABILITY_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Startup Run Level Six</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_SIX = CorePackage.CAPABILITY_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Startup Run Level Three</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_THREE = CorePackage.CAPABILITY_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Startup Run Level Two</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_TWO = CorePackage.CAPABILITY_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Startup Run Level Zero</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ZERO = CorePackage.CAPABILITY_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Startup Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE__STARTUP_TYPE = CorePackage.CAPABILITY_FEATURE_COUNT + 12;

	/**
	 * The number of structural features of the '<em>Linux Local Service</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Linux Local Service Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_SERVICE_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER__ANNOTATIONS = USER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER__ATTRIBUTE_META_DATA = USER__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER__EXTENDED_ATTRIBUTES = USER__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER__ARTIFACT_GROUP = USER__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER__ARTIFACTS = USER__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER__CONSTRAINT_GROUP = USER__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER__CONSTRAINTS = USER__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER__DESCRIPTION = USER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER__DISPLAY_NAME = USER__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER__MUTABLE = USER__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER__NAME = USER__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER__STEREOTYPES = USER__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER__BUILD_VERSION = USER__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER__LINK_TYPE = USER__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER__ORIGIN = USER__ORIGIN;

	/**
	 * The feature id for the '<em><b>User Id</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER__USER_ID = USER__USER_ID;

	/**
	 * The feature id for the '<em><b>User Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER__USER_PASSWORD = USER__USER_PASSWORD;

	/**
	 * The feature id for the '<em><b>Account Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER__ACCOUNT_DESCRIPTION = USER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Account Disabled</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER__ACCOUNT_DISABLED = USER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Change Password Next Logon</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER__CHANGE_PASSWORD_NEXT_LOGON = USER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Full Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER__FULL_NAME = USER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Home Dir</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER__HOME_DIR = USER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Password Never Expires</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER__PASSWORD_NEVER_EXPIRES = USER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Shell</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER__SHELL = USER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>User Cannot Change Password</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER__USER_CANNOT_CHANGE_PASSWORD = USER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>User Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER__USER_NAME = USER_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Linux Local User</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER_FEATURE_COUNT = USER_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER_UNIT__ANNOTATIONS = USER_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER_UNIT__ATTRIBUTE_META_DATA = USER_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER_UNIT__EXTENDED_ATTRIBUTES = USER_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER_UNIT__ARTIFACT_GROUP = USER_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER_UNIT__ARTIFACTS = USER_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER_UNIT__CONSTRAINT_GROUP = USER_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER_UNIT__CONSTRAINTS = USER_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER_UNIT__DESCRIPTION = USER_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER_UNIT__DISPLAY_NAME = USER_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER_UNIT__MUTABLE = USER_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER_UNIT__NAME = USER_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER_UNIT__CAPABILITY_GROUP = USER_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER_UNIT__CAPABILITIES = USER_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER_UNIT__REQUIREMENT_GROUP = USER_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER_UNIT__REQUIREMENTS = USER_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER_UNIT__UNIT_LINKS_GROUP = USER_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER_UNIT__UNIT_LINKS = USER_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER_UNIT__CONSTRAINT_LINKS = USER_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER_UNIT__REALIZATION_LINKS = USER_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER_UNIT__STEREOTYPES = USER_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER_UNIT__BUILD_VERSION = USER_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER_UNIT__CONCEPTUAL = USER_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER_UNIT__CONFIGURATION_UNIT = USER_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER_UNIT__GOAL_INSTALL_STATE = USER_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER_UNIT__INIT_INSTALL_STATE = USER_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER_UNIT__ORIGIN = USER_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER_UNIT__PUBLISH_INTENT = USER_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Linux Local User Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_LOCAL_USER_UNIT_FEATURE_COUNT = USER_UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM__ANNOTATIONS = OPERATING_SYSTEM__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM__ATTRIBUTE_META_DATA = OPERATING_SYSTEM__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM__EXTENDED_ATTRIBUTES = OPERATING_SYSTEM__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM__ARTIFACT_GROUP = OPERATING_SYSTEM__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM__ARTIFACTS = OPERATING_SYSTEM__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM__CONSTRAINT_GROUP = OPERATING_SYSTEM__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM__CONSTRAINTS = OPERATING_SYSTEM__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM__DESCRIPTION = OPERATING_SYSTEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM__DISPLAY_NAME = OPERATING_SYSTEM__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM__MUTABLE = OPERATING_SYSTEM__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM__NAME = OPERATING_SYSTEM__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM__STEREOTYPES = OPERATING_SYSTEM__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM__BUILD_VERSION = OPERATING_SYSTEM__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM__LINK_TYPE = OPERATING_SYSTEM__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM__ORIGIN = OPERATING_SYSTEM__ORIGIN;

	/**
	 * The feature id for the '<em><b>Fqdn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM__FQDN = OPERATING_SYSTEM__FQDN;

	/**
	 * The feature id for the '<em><b>Hostname</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM__HOSTNAME = OPERATING_SYSTEM__HOSTNAME;

	/**
	 * The feature id for the '<em><b>Kernel Architecture</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM__KERNEL_ARCHITECTURE = OPERATING_SYSTEM__KERNEL_ARCHITECTURE;

	/**
	 * The feature id for the '<em><b>Kernel Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM__KERNEL_VERSION = OPERATING_SYSTEM__KERNEL_VERSION;

	/**
	 * The feature id for the '<em><b>Kernel Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM__KERNEL_WIDTH = OPERATING_SYSTEM__KERNEL_WIDTH;

	/**
	 * The feature id for the '<em><b>Locale</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM__LOCALE = OPERATING_SYSTEM__LOCALE;

	/**
	 * The feature id for the '<em><b>Manufacturer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM__MANUFACTURER = OPERATING_SYSTEM__MANUFACTURER;

	/**
	 * The feature id for the '<em><b>Os Distribution</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM__OS_DISTRIBUTION = OPERATING_SYSTEM__OS_DISTRIBUTION;

	/**
	 * The feature id for the '<em><b>Os Servicepack</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM__OS_SERVICEPACK = OPERATING_SYSTEM__OS_SERVICEPACK;

	/**
	 * The feature id for the '<em><b>Os Type</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM__OS_TYPE = OPERATING_SYSTEM__OS_TYPE;

	/**
	 * The feature id for the '<em><b>Os Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM__OS_VERSION = OPERATING_SYSTEM__OS_VERSION;

	/**
	 * The feature id for the '<em><b>Time Zone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM__TIME_ZONE = OPERATING_SYSTEM__TIME_ZONE;

	/**
	 * The feature id for the '<em><b>Kernel Release</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM__KERNEL_RELEASE = OPERATING_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Linux Operating System</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM_FEATURE_COUNT = OPERATING_SYSTEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM_UNIT__ANNOTATIONS = OPERATING_SYSTEM_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM_UNIT__ATTRIBUTE_META_DATA = OPERATING_SYSTEM_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM_UNIT__EXTENDED_ATTRIBUTES = OPERATING_SYSTEM_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM_UNIT__ARTIFACT_GROUP = OPERATING_SYSTEM_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM_UNIT__ARTIFACTS = OPERATING_SYSTEM_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM_UNIT__CONSTRAINT_GROUP = OPERATING_SYSTEM_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM_UNIT__CONSTRAINTS = OPERATING_SYSTEM_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM_UNIT__DESCRIPTION = OPERATING_SYSTEM_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM_UNIT__DISPLAY_NAME = OPERATING_SYSTEM_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM_UNIT__MUTABLE = OPERATING_SYSTEM_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM_UNIT__NAME = OPERATING_SYSTEM_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM_UNIT__CAPABILITY_GROUP = OPERATING_SYSTEM_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM_UNIT__CAPABILITIES = OPERATING_SYSTEM_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM_UNIT__REQUIREMENT_GROUP = OPERATING_SYSTEM_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM_UNIT__REQUIREMENTS = OPERATING_SYSTEM_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM_UNIT__UNIT_LINKS_GROUP = OPERATING_SYSTEM_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM_UNIT__UNIT_LINKS = OPERATING_SYSTEM_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM_UNIT__CONSTRAINT_LINKS = OPERATING_SYSTEM_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM_UNIT__REALIZATION_LINKS = OPERATING_SYSTEM_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM_UNIT__STEREOTYPES = OPERATING_SYSTEM_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM_UNIT__BUILD_VERSION = OPERATING_SYSTEM_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM_UNIT__CONCEPTUAL = OPERATING_SYSTEM_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM_UNIT__CONFIGURATION_UNIT = OPERATING_SYSTEM_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM_UNIT__GOAL_INSTALL_STATE = OPERATING_SYSTEM_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM_UNIT__INIT_INSTALL_STATE = OPERATING_SYSTEM_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM_UNIT__ORIGIN = OPERATING_SYSTEM_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM_UNIT__PUBLISH_INTENT = OPERATING_SYSTEM_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Linux Operating System Unit</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINUX_OPERATING_SYSTEM_UNIT_FEATURE_COUNT = OPERATING_SYSTEM_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.LocalFileSystemImpl <em>Local File System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.LocalFileSystemImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getLocalFileSystem()
	 * @generated
	 */
	int LOCAL_FILE_SYSTEM = 24;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM__ANNOTATIONS = FILE_SYSTEM__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM__ATTRIBUTE_META_DATA = FILE_SYSTEM__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM__EXTENDED_ATTRIBUTES = FILE_SYSTEM__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM__ARTIFACT_GROUP = FILE_SYSTEM__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM__ARTIFACTS = FILE_SYSTEM__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM__CONSTRAINT_GROUP = FILE_SYSTEM__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM__CONSTRAINTS = FILE_SYSTEM__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM__DESCRIPTION = FILE_SYSTEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM__DISPLAY_NAME = FILE_SYSTEM__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM__MUTABLE = FILE_SYSTEM__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM__NAME = FILE_SYSTEM__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM__STEREOTYPES = FILE_SYSTEM__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM__BUILD_VERSION = FILE_SYSTEM__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM__LINK_TYPE = FILE_SYSTEM__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM__ORIGIN = FILE_SYSTEM__ORIGIN;

	/**
	 * The feature id for the '<em><b>Available Space</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM__AVAILABLE_SPACE = FILE_SYSTEM__AVAILABLE_SPACE;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM__CAPACITY = FILE_SYSTEM__CAPACITY;

	/**
	 * The feature id for the '<em><b>Mount Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM__MOUNT_POINT = FILE_SYSTEM__MOUNT_POINT;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM__TYPE = FILE_SYSTEM__TYPE;

	/**
	 * The number of structural features of the '<em>Local File System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM_FEATURE_COUNT = FILE_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.LocalFileSystemUnitImpl <em>Local File System Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.LocalFileSystemUnitImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getLocalFileSystemUnit()
	 * @generated
	 */
	int LOCAL_FILE_SYSTEM_UNIT = 25;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM_UNIT__ANNOTATIONS = FILE_SYSTEM_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM_UNIT__ATTRIBUTE_META_DATA = FILE_SYSTEM_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM_UNIT__EXTENDED_ATTRIBUTES = FILE_SYSTEM_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM_UNIT__ARTIFACT_GROUP = FILE_SYSTEM_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM_UNIT__ARTIFACTS = FILE_SYSTEM_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM_UNIT__CONSTRAINT_GROUP = FILE_SYSTEM_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM_UNIT__CONSTRAINTS = FILE_SYSTEM_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM_UNIT__DESCRIPTION = FILE_SYSTEM_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM_UNIT__DISPLAY_NAME = FILE_SYSTEM_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM_UNIT__MUTABLE = FILE_SYSTEM_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM_UNIT__NAME = FILE_SYSTEM_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM_UNIT__CAPABILITY_GROUP = FILE_SYSTEM_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM_UNIT__CAPABILITIES = FILE_SYSTEM_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM_UNIT__REQUIREMENT_GROUP = FILE_SYSTEM_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM_UNIT__REQUIREMENTS = FILE_SYSTEM_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM_UNIT__UNIT_LINKS_GROUP = FILE_SYSTEM_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM_UNIT__UNIT_LINKS = FILE_SYSTEM_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM_UNIT__CONSTRAINT_LINKS = FILE_SYSTEM_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM_UNIT__REALIZATION_LINKS = FILE_SYSTEM_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM_UNIT__STEREOTYPES = FILE_SYSTEM_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM_UNIT__BUILD_VERSION = FILE_SYSTEM_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM_UNIT__CONCEPTUAL = FILE_SYSTEM_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM_UNIT__CONFIGURATION_UNIT = FILE_SYSTEM_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM_UNIT__GOAL_INSTALL_STATE = FILE_SYSTEM_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM_UNIT__INIT_INSTALL_STATE = FILE_SYSTEM_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM_UNIT__ORIGIN = FILE_SYSTEM_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM_UNIT__PUBLISH_INTENT = FILE_SYSTEM_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Local File System Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FILE_SYSTEM_UNIT_FEATURE_COUNT = FILE_SYSTEM_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.RemoteFileSystemImpl <em>Remote File System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.RemoteFileSystemImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getRemoteFileSystem()
	 * @generated
	 */
	int REMOTE_FILE_SYSTEM = 40;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM__ANNOTATIONS = FILE_SYSTEM__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM__ATTRIBUTE_META_DATA = FILE_SYSTEM__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM__EXTENDED_ATTRIBUTES = FILE_SYSTEM__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM__ARTIFACT_GROUP = FILE_SYSTEM__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM__ARTIFACTS = FILE_SYSTEM__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM__CONSTRAINT_GROUP = FILE_SYSTEM__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM__CONSTRAINTS = FILE_SYSTEM__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM__DESCRIPTION = FILE_SYSTEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM__DISPLAY_NAME = FILE_SYSTEM__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM__MUTABLE = FILE_SYSTEM__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM__NAME = FILE_SYSTEM__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM__STEREOTYPES = FILE_SYSTEM__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM__BUILD_VERSION = FILE_SYSTEM__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM__LINK_TYPE = FILE_SYSTEM__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM__ORIGIN = FILE_SYSTEM__ORIGIN;

	/**
	 * The feature id for the '<em><b>Available Space</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM__AVAILABLE_SPACE = FILE_SYSTEM__AVAILABLE_SPACE;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM__CAPACITY = FILE_SYSTEM__CAPACITY;

	/**
	 * The feature id for the '<em><b>Mount Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM__MOUNT_POINT = FILE_SYSTEM__MOUNT_POINT;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM__TYPE = FILE_SYSTEM__TYPE;

	/**
	 * The feature id for the '<em><b>Export Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM__EXPORT_NAME = FILE_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Server Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM__SERVER_NAME = FILE_SYSTEM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Remote File System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM_FEATURE_COUNT = FILE_SYSTEM_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.NFSFileSystemImpl <em>NFS File System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.NFSFileSystemImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getNFSFileSystem()
	 * @generated
	 */
	int NFS_FILE_SYSTEM = 26;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM__ANNOTATIONS = REMOTE_FILE_SYSTEM__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM__ATTRIBUTE_META_DATA = REMOTE_FILE_SYSTEM__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM__EXTENDED_ATTRIBUTES = REMOTE_FILE_SYSTEM__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM__ARTIFACT_GROUP = REMOTE_FILE_SYSTEM__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM__ARTIFACTS = REMOTE_FILE_SYSTEM__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM__CONSTRAINT_GROUP = REMOTE_FILE_SYSTEM__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM__CONSTRAINTS = REMOTE_FILE_SYSTEM__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM__DESCRIPTION = REMOTE_FILE_SYSTEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM__DISPLAY_NAME = REMOTE_FILE_SYSTEM__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM__MUTABLE = REMOTE_FILE_SYSTEM__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM__NAME = REMOTE_FILE_SYSTEM__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM__STEREOTYPES = REMOTE_FILE_SYSTEM__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM__BUILD_VERSION = REMOTE_FILE_SYSTEM__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM__LINK_TYPE = REMOTE_FILE_SYSTEM__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM__ORIGIN = REMOTE_FILE_SYSTEM__ORIGIN;

	/**
	 * The feature id for the '<em><b>Available Space</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM__AVAILABLE_SPACE = REMOTE_FILE_SYSTEM__AVAILABLE_SPACE;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM__CAPACITY = REMOTE_FILE_SYSTEM__CAPACITY;

	/**
	 * The feature id for the '<em><b>Mount Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM__MOUNT_POINT = REMOTE_FILE_SYSTEM__MOUNT_POINT;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM__TYPE = REMOTE_FILE_SYSTEM__TYPE;

	/**
	 * The feature id for the '<em><b>Export Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM__EXPORT_NAME = REMOTE_FILE_SYSTEM__EXPORT_NAME;

	/**
	 * The feature id for the '<em><b>Server Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM__SERVER_NAME = REMOTE_FILE_SYSTEM__SERVER_NAME;

	/**
	 * The number of structural features of the '<em>NFS File System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM_FEATURE_COUNT = REMOTE_FILE_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.RemoteFileSystemUnitImpl <em>Remote File System Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.RemoteFileSystemUnitImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getRemoteFileSystemUnit()
	 * @generated
	 */
	int REMOTE_FILE_SYSTEM_UNIT = 41;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM_UNIT__ANNOTATIONS = FILE_SYSTEM_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM_UNIT__ATTRIBUTE_META_DATA = FILE_SYSTEM_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM_UNIT__EXTENDED_ATTRIBUTES = FILE_SYSTEM_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM_UNIT__ARTIFACT_GROUP = FILE_SYSTEM_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM_UNIT__ARTIFACTS = FILE_SYSTEM_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM_UNIT__CONSTRAINT_GROUP = FILE_SYSTEM_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM_UNIT__CONSTRAINTS = FILE_SYSTEM_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM_UNIT__DESCRIPTION = FILE_SYSTEM_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM_UNIT__DISPLAY_NAME = FILE_SYSTEM_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM_UNIT__MUTABLE = FILE_SYSTEM_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM_UNIT__NAME = FILE_SYSTEM_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM_UNIT__CAPABILITY_GROUP = FILE_SYSTEM_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM_UNIT__CAPABILITIES = FILE_SYSTEM_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM_UNIT__REQUIREMENT_GROUP = FILE_SYSTEM_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM_UNIT__REQUIREMENTS = FILE_SYSTEM_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM_UNIT__UNIT_LINKS_GROUP = FILE_SYSTEM_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM_UNIT__UNIT_LINKS = FILE_SYSTEM_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM_UNIT__CONSTRAINT_LINKS = FILE_SYSTEM_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM_UNIT__REALIZATION_LINKS = FILE_SYSTEM_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM_UNIT__STEREOTYPES = FILE_SYSTEM_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM_UNIT__BUILD_VERSION = FILE_SYSTEM_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM_UNIT__CONCEPTUAL = FILE_SYSTEM_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM_UNIT__CONFIGURATION_UNIT = FILE_SYSTEM_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM_UNIT__GOAL_INSTALL_STATE = FILE_SYSTEM_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM_UNIT__INIT_INSTALL_STATE = FILE_SYSTEM_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM_UNIT__ORIGIN = FILE_SYSTEM_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM_UNIT__PUBLISH_INTENT = FILE_SYSTEM_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Remote File System Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOTE_FILE_SYSTEM_UNIT_FEATURE_COUNT = FILE_SYSTEM_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.NFSFileSystemUnitImpl <em>NFS File System Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.NFSFileSystemUnitImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getNFSFileSystemUnit()
	 * @generated
	 */
	int NFS_FILE_SYSTEM_UNIT = 27;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM_UNIT__ANNOTATIONS = REMOTE_FILE_SYSTEM_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM_UNIT__ATTRIBUTE_META_DATA = REMOTE_FILE_SYSTEM_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM_UNIT__EXTENDED_ATTRIBUTES = REMOTE_FILE_SYSTEM_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM_UNIT__ARTIFACT_GROUP = REMOTE_FILE_SYSTEM_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM_UNIT__ARTIFACTS = REMOTE_FILE_SYSTEM_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM_UNIT__CONSTRAINT_GROUP = REMOTE_FILE_SYSTEM_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM_UNIT__CONSTRAINTS = REMOTE_FILE_SYSTEM_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM_UNIT__DESCRIPTION = REMOTE_FILE_SYSTEM_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM_UNIT__DISPLAY_NAME = REMOTE_FILE_SYSTEM_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM_UNIT__MUTABLE = REMOTE_FILE_SYSTEM_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM_UNIT__NAME = REMOTE_FILE_SYSTEM_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM_UNIT__CAPABILITY_GROUP = REMOTE_FILE_SYSTEM_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM_UNIT__CAPABILITIES = REMOTE_FILE_SYSTEM_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM_UNIT__REQUIREMENT_GROUP = REMOTE_FILE_SYSTEM_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM_UNIT__REQUIREMENTS = REMOTE_FILE_SYSTEM_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM_UNIT__UNIT_LINKS_GROUP = REMOTE_FILE_SYSTEM_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM_UNIT__UNIT_LINKS = REMOTE_FILE_SYSTEM_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM_UNIT__CONSTRAINT_LINKS = REMOTE_FILE_SYSTEM_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM_UNIT__REALIZATION_LINKS = REMOTE_FILE_SYSTEM_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM_UNIT__STEREOTYPES = REMOTE_FILE_SYSTEM_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM_UNIT__BUILD_VERSION = REMOTE_FILE_SYSTEM_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM_UNIT__CONCEPTUAL = REMOTE_FILE_SYSTEM_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM_UNIT__CONFIGURATION_UNIT = REMOTE_FILE_SYSTEM_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM_UNIT__GOAL_INSTALL_STATE = REMOTE_FILE_SYSTEM_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM_UNIT__INIT_INSTALL_STATE = REMOTE_FILE_SYSTEM_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM_UNIT__ORIGIN = REMOTE_FILE_SYSTEM_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM_UNIT__PUBLISH_INTENT = REMOTE_FILE_SYSTEM_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>NFS File System Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NFS_FILE_SYSTEM_UNIT_FEATURE_COUNT = REMOTE_FILE_SYSTEM_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.OpenVmsFileSystemImpl <em>Open Vms File System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.OpenVmsFileSystemImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getOpenVmsFileSystem()
	 * @generated
	 */
	int OPEN_VMS_FILE_SYSTEM = 28;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM__ANNOTATIONS = LOCAL_FILE_SYSTEM__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM__ATTRIBUTE_META_DATA = LOCAL_FILE_SYSTEM__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM__EXTENDED_ATTRIBUTES = LOCAL_FILE_SYSTEM__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM__ARTIFACT_GROUP = LOCAL_FILE_SYSTEM__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM__ARTIFACTS = LOCAL_FILE_SYSTEM__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM__CONSTRAINT_GROUP = LOCAL_FILE_SYSTEM__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM__CONSTRAINTS = LOCAL_FILE_SYSTEM__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM__DESCRIPTION = LOCAL_FILE_SYSTEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM__DISPLAY_NAME = LOCAL_FILE_SYSTEM__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM__MUTABLE = LOCAL_FILE_SYSTEM__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM__NAME = LOCAL_FILE_SYSTEM__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM__STEREOTYPES = LOCAL_FILE_SYSTEM__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM__BUILD_VERSION = LOCAL_FILE_SYSTEM__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM__LINK_TYPE = LOCAL_FILE_SYSTEM__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM__ORIGIN = LOCAL_FILE_SYSTEM__ORIGIN;

	/**
	 * The feature id for the '<em><b>Available Space</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM__AVAILABLE_SPACE = LOCAL_FILE_SYSTEM__AVAILABLE_SPACE;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM__CAPACITY = LOCAL_FILE_SYSTEM__CAPACITY;

	/**
	 * The feature id for the '<em><b>Mount Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM__MOUNT_POINT = LOCAL_FILE_SYSTEM__MOUNT_POINT;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM__TYPE = LOCAL_FILE_SYSTEM__TYPE;

	/**
	 * The number of structural features of the '<em>Open Vms File System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM_FEATURE_COUNT = LOCAL_FILE_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.OpenVmsFileSystemUnitImpl <em>Open Vms File System Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.OpenVmsFileSystemUnitImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getOpenVmsFileSystemUnit()
	 * @generated
	 */
	int OPEN_VMS_FILE_SYSTEM_UNIT = 29;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM_UNIT__ANNOTATIONS = LOCAL_FILE_SYSTEM_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM_UNIT__ATTRIBUTE_META_DATA = LOCAL_FILE_SYSTEM_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM_UNIT__EXTENDED_ATTRIBUTES = LOCAL_FILE_SYSTEM_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM_UNIT__ARTIFACT_GROUP = LOCAL_FILE_SYSTEM_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM_UNIT__ARTIFACTS = LOCAL_FILE_SYSTEM_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM_UNIT__CONSTRAINT_GROUP = LOCAL_FILE_SYSTEM_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM_UNIT__CONSTRAINTS = LOCAL_FILE_SYSTEM_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM_UNIT__DESCRIPTION = LOCAL_FILE_SYSTEM_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM_UNIT__DISPLAY_NAME = LOCAL_FILE_SYSTEM_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM_UNIT__MUTABLE = LOCAL_FILE_SYSTEM_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM_UNIT__NAME = LOCAL_FILE_SYSTEM_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM_UNIT__CAPABILITY_GROUP = LOCAL_FILE_SYSTEM_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM_UNIT__CAPABILITIES = LOCAL_FILE_SYSTEM_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM_UNIT__REQUIREMENT_GROUP = LOCAL_FILE_SYSTEM_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM_UNIT__REQUIREMENTS = LOCAL_FILE_SYSTEM_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM_UNIT__UNIT_LINKS_GROUP = LOCAL_FILE_SYSTEM_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM_UNIT__UNIT_LINKS = LOCAL_FILE_SYSTEM_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM_UNIT__CONSTRAINT_LINKS = LOCAL_FILE_SYSTEM_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM_UNIT__REALIZATION_LINKS = LOCAL_FILE_SYSTEM_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM_UNIT__STEREOTYPES = LOCAL_FILE_SYSTEM_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM_UNIT__BUILD_VERSION = LOCAL_FILE_SYSTEM_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM_UNIT__CONCEPTUAL = LOCAL_FILE_SYSTEM_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM_UNIT__CONFIGURATION_UNIT = LOCAL_FILE_SYSTEM_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM_UNIT__GOAL_INSTALL_STATE = LOCAL_FILE_SYSTEM_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM_UNIT__INIT_INSTALL_STATE = LOCAL_FILE_SYSTEM_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM_UNIT__ORIGIN = LOCAL_FILE_SYSTEM_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM_UNIT__PUBLISH_INTENT = LOCAL_FILE_SYSTEM_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Open Vms File System Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_VMS_FILE_SYSTEM_UNIT_FEATURE_COUNT = LOCAL_FILE_SYSTEM_UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Capability Aix Local Group</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_GROUP = 3;

	/**
	 * The feature id for the '<em><b>Capability Aix Local Service</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_SERVICE = 4;

	/**
	 * The feature id for the '<em><b>Capability Aix Local User</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_USER = 5;

	/**
	 * The feature id for the '<em><b>Capability Aix Operating System</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_OPERATING_SYSTEM = 6;

	/**
	 * The feature id for the '<em><b>Capability Data File</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_DATA_FILE = 7;

	/**
	 * The feature id for the '<em><b>Capability Directory</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_DIRECTORY = 8;

	/**
	 * The feature id for the '<em><b>Capability File System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM = 9;

	/**
	 * The feature id for the '<em><b>Capability File System Content</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM_CONTENT = 10;

	/**
	 * The feature id for the '<em><b>Capability Linux Local Group</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_GROUP = 11;

	/**
	 * The feature id for the '<em><b>Capability Linux Local Service</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_SERVICE = 12;

	/**
	 * The feature id for the '<em><b>Capability Linux Local User</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_USER = 13;

	/**
	 * The feature id for the '<em><b>Capability Linux Operating System</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_OPERATING_SYSTEM = 14;

	/**
	 * The feature id for the '<em><b>Capability Local File System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_LOCAL_FILE_SYSTEM = 15;

	/**
	 * The feature id for the '<em><b>Capability NFS File System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_NFS_FILE_SYSTEM = 16;

	/**
	 * The feature id for the '<em><b>Capability Open Vms File System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_OPEN_VMS_FILE_SYSTEM = 17;

	/**
	 * The feature id for the '<em><b>Capability Operating System</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_OPERATING_SYSTEM = 18;

	/**
	 * The feature id for the '<em><b>Capability Port</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_PORT = 19;

	/**
	 * The feature id for the '<em><b>Capability Port Consumer</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_PORT_CONSUMER = 20;

	/**
	 * The feature id for the '<em><b>Capability Redhat Linux Local Group</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_GROUP = 21;

	/**
	 * The feature id for the '<em><b>Capability Redhat Linux Local Service</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_SERVICE = 22;

	/**
	 * The feature id for the '<em><b>Capability Redhat Linux Local User</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_USER = 23;

	/**
	 * The feature id for the '<em><b>Capability Redhat Linux Operating System</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_OPERATING_SYSTEM = 24;

	/**
	 * The feature id for the '<em><b>Capability Remote File System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_REMOTE_FILE_SYSTEM = 25;

	/**
	 * The feature id for the '<em><b>Capability SMB File System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_SMB_FILE_SYSTEM = 26;

	/**
	 * The feature id for the '<em><b>Capability Solaris File System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_SOLARIS_FILE_SYSTEM = 27;

	/**
	 * The feature id for the '<em><b>Capability Suse Linux Local Group</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_GROUP = 28;

	/**
	 * The feature id for the '<em><b>Capability Suse Linux Local Service</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_SERVICE = 29;

	/**
	 * The feature id for the '<em><b>Capability Suse Linux Local User</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_USER = 30;

	/**
	 * The feature id for the '<em><b>Capability Suse Linux Operating System</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_OPERATING_SYSTEM = 31;

	/**
	 * The feature id for the '<em><b>Capability Unix Directory</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_UNIX_DIRECTORY = 32;

	/**
	 * The feature id for the '<em><b>Capability Unix File System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_UNIX_FILE_SYSTEM = 33;

	/**
	 * The feature id for the '<em><b>Capability User</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_USER = 34;

	/**
	 * The feature id for the '<em><b>Capability User Group</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_USER_GROUP = 35;

	/**
	 * The feature id for the '<em><b>Capability Windows Directory</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_DIRECTORY = 36;

	/**
	 * The feature id for the '<em><b>Capability Windows File System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_FILE_SYSTEM = 37;

	/**
	 * The feature id for the '<em><b>Capability Windows Local Group</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_GROUP = 38;

	/**
	 * The feature id for the '<em><b>Capability Windows Local Service</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_SERVICE = 39;

	/**
	 * The feature id for the '<em><b>Capability Windows Local User</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_USER = 40;

	/**
	 * The feature id for the '<em><b>Capability Windows Operating System</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_OPERATING_SYSTEM = 41;

	/**
	 * The feature id for the '<em><b>Unit Aix Local Group</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_GROUP = 42;

	/**
	 * The feature id for the '<em><b>Unit Aix Local Service Unit</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_SERVICE_UNIT = 43;

	/**
	 * The feature id for the '<em><b>Unit Aix Local User</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_USER = 44;

	/**
	 * The feature id for the '<em><b>Unit Aix Operating System Unit</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__UNIT_AIX_OPERATING_SYSTEM_UNIT = 45;

	/**
	 * The feature id for the '<em><b>Unit Data File Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__UNIT_DATA_FILE_UNIT = 46;

	/**
	 * The feature id for the '<em><b>Unit Directory Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__UNIT_DIRECTORY_UNIT = 47;

	/**
	 * The feature id for the '<em><b>Unit File System Content Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_CONTENT_UNIT = 48;

	/**
	 * The feature id for the '<em><b>Unit File System Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_UNIT = 49;

	/**
	 * The feature id for the '<em><b>Unit Linux Local Group</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_GROUP = 50;

	/**
	 * The feature id for the '<em><b>Unit Linux Local Service Unit</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_SERVICE_UNIT = 51;

	/**
	 * The feature id for the '<em><b>Unit Linux Local User</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_USER = 52;

	/**
	 * The feature id for the '<em><b>Unit Linux Operating System Unit</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__UNIT_LINUX_OPERATING_SYSTEM_UNIT = 53;

	/**
	 * The feature id for the '<em><b>Unit Local File System Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__UNIT_LOCAL_FILE_SYSTEM_UNIT = 54;

	/**
	 * The feature id for the '<em><b>Unit NFS File System Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__UNIT_NFS_FILE_SYSTEM_UNIT = 55;

	/**
	 * The feature id for the '<em><b>Unit Open Vms File System Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__UNIT_OPEN_VMS_FILE_SYSTEM_UNIT = 56;

	/**
	 * The feature id for the '<em><b>Unit Operating System Unit</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__UNIT_OPERATING_SYSTEM_UNIT = 57;

	/**
	 * The feature id for the '<em><b>Unit Port Config Unit</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__UNIT_PORT_CONFIG_UNIT = 58;

	/**
	 * The feature id for the '<em><b>Unit Remote File System Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__UNIT_REMOTE_FILE_SYSTEM_UNIT = 59;

	/**
	 * The feature id for the '<em><b>Unit SMB File System Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__UNIT_SMB_FILE_SYSTEM_UNIT = 60;

	/**
	 * The feature id for the '<em><b>Unit Solaris File System Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__UNIT_SOLARIS_FILE_SYSTEM_UNIT = 61;

	/**
	 * The feature id for the '<em><b>Unit Unix File System Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__UNIT_UNIX_FILE_SYSTEM_UNIT = 62;

	/**
	 * The feature id for the '<em><b>Unit User</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__UNIT_USER = 63;

	/**
	 * The feature id for the '<em><b>Unit User Group</b></em>' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__UNIT_USER_GROUP = 64;

	/**
	 * The feature id for the '<em><b>Unit Windows File System Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_FILE_SYSTEM_UNIT = 65;

	/**
	 * The feature id for the '<em><b>Unit Windows Local Group</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_GROUP = 66;

	/**
	 * The feature id for the '<em><b>Unit Windows Local Service Unit</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_SERVICE_UNIT = 67;

	/**
	 * The feature id for the '<em><b>Unit Windows Local User</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_USER = 68;

	/**
	 * The feature id for the '<em><b>Unit Windows Operating System Unit</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_OPERATING_SYSTEM_UNIT = 69;

	/**
	 * The number of structural features of the '<em>Operating System Root</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_ROOT_FEATURE_COUNT = 70;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Application Layer Protocol</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT__APPLICATION_LAYER_PROTOCOL = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ip Address Or Hostname</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT__IP_ADDRESS_OR_HOSTNAME = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__PORT = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Port Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__PORT_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Transport Layer Protocol</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT__TRANSPORT_LAYER_PROTOCOL = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT_CONFIG_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_CONFIG_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_CONFIG_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT_CONFIG_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT_CONFIG_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT_CONFIG_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT_CONFIG_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_CONFIG_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_CONFIG_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_CONFIG_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_CONFIG_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT_CONFIG_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT_CONFIG_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT_CONFIG_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT_CONFIG_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT_CONFIG_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT_CONFIG_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_CONFIG_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_CONFIG_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_CONFIG_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_CONFIG_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_CONFIG_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT_CONFIG_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT_CONFIG_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT_CONFIG_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_CONFIG_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_CONFIG_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Port Config Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT_CONFIG_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT_CONSUMER__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_CONSUMER__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_CONSUMER__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT_CONSUMER__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT_CONSUMER__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT_CONSUMER__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT_CONSUMER__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_CONSUMER__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_CONSUMER__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_CONSUMER__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_CONSUMER__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_CONSUMER__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_CONSUMER__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_CONSUMER__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_CONSUMER__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The number of structural features of the '<em>Port Consumer</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT_CONSUMER_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_GROUP__ANNOTATIONS = LINUX_LOCAL_GROUP__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_GROUP__ATTRIBUTE_META_DATA = LINUX_LOCAL_GROUP__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_GROUP__EXTENDED_ATTRIBUTES = LINUX_LOCAL_GROUP__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_GROUP__ARTIFACT_GROUP = LINUX_LOCAL_GROUP__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_GROUP__ARTIFACTS = LINUX_LOCAL_GROUP__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_GROUP__CONSTRAINT_GROUP = LINUX_LOCAL_GROUP__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_GROUP__CONSTRAINTS = LINUX_LOCAL_GROUP__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_GROUP__DESCRIPTION = LINUX_LOCAL_GROUP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_GROUP__DISPLAY_NAME = LINUX_LOCAL_GROUP__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_GROUP__MUTABLE = LINUX_LOCAL_GROUP__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_GROUP__NAME = LINUX_LOCAL_GROUP__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_GROUP__STEREOTYPES = LINUX_LOCAL_GROUP__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_GROUP__BUILD_VERSION = LINUX_LOCAL_GROUP__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_GROUP__LINK_TYPE = LINUX_LOCAL_GROUP__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_GROUP__ORIGIN = LINUX_LOCAL_GROUP__ORIGIN;

	/**
	 * The feature id for the '<em><b>Group Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_GROUP__GROUP_NAME = LINUX_LOCAL_GROUP__GROUP_NAME;

	/**
	 * The feature id for the '<em><b>Group Description</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_GROUP__GROUP_DESCRIPTION = LINUX_LOCAL_GROUP__GROUP_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Group Sid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_GROUP__GROUP_SID = LINUX_LOCAL_GROUP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Redhat Linux Local Group</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_GROUP_FEATURE_COUNT = LINUX_LOCAL_GROUP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_SERVICE__ANNOTATIONS = LINUX_LOCAL_SERVICE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_SERVICE__ATTRIBUTE_META_DATA = LINUX_LOCAL_SERVICE__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_SERVICE__EXTENDED_ATTRIBUTES = LINUX_LOCAL_SERVICE__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_SERVICE__ARTIFACT_GROUP = LINUX_LOCAL_SERVICE__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_SERVICE__ARTIFACTS = LINUX_LOCAL_SERVICE__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_SERVICE__CONSTRAINT_GROUP = LINUX_LOCAL_SERVICE__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_SERVICE__CONSTRAINTS = LINUX_LOCAL_SERVICE__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_SERVICE__DESCRIPTION = LINUX_LOCAL_SERVICE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_SERVICE__DISPLAY_NAME = LINUX_LOCAL_SERVICE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_SERVICE__MUTABLE = LINUX_LOCAL_SERVICE__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_SERVICE__NAME = LINUX_LOCAL_SERVICE__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_SERVICE__STEREOTYPES = LINUX_LOCAL_SERVICE__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_SERVICE__BUILD_VERSION = LINUX_LOCAL_SERVICE__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_SERVICE__LINK_TYPE = LINUX_LOCAL_SERVICE__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_SERVICE__ORIGIN = LINUX_LOCAL_SERVICE__ORIGIN;

	/**
	 * The feature id for the '<em><b>Executable Path</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_SERVICE__EXECUTABLE_PATH = LINUX_LOCAL_SERVICE__EXECUTABLE_PATH;

	/**
	 * The feature id for the '<em><b>Service Account</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_SERVICE__SERVICE_ACCOUNT = LINUX_LOCAL_SERVICE__SERVICE_ACCOUNT;

	/**
	 * The feature id for the '<em><b>Service Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_SERVICE__SERVICE_DESCRIPTION = LINUX_LOCAL_SERVICE__SERVICE_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Service Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_SERVICE__SERVICE_NAME = LINUX_LOCAL_SERVICE__SERVICE_NAME;

	/**
	 * The feature id for the '<em><b>Service Status</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_SERVICE__SERVICE_STATUS = LINUX_LOCAL_SERVICE__SERVICE_STATUS;

	/**
	 * The feature id for the '<em><b>Startup Run Level Five</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FIVE = LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FIVE;

	/**
	 * The feature id for the '<em><b>Startup Run Level Four</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FOUR = LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FOUR;

	/**
	 * The feature id for the '<em><b>Startup Run Level One</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ONE = LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ONE;

	/**
	 * The feature id for the '<em><b>Startup Run Level Six</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_SIX = LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_SIX;

	/**
	 * The feature id for the '<em><b>Startup Run Level Three</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_THREE = LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_THREE;

	/**
	 * The feature id for the '<em><b>Startup Run Level Two</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_TWO = LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_TWO;

	/**
	 * The feature id for the '<em><b>Startup Run Level Zero</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ZERO = LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ZERO;

	/**
	 * The feature id for the '<em><b>Startup Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_SERVICE__STARTUP_TYPE = LINUX_LOCAL_SERVICE__STARTUP_TYPE;

	/**
	 * The number of structural features of the '<em>Redhat Linux Local Service</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_SERVICE_FEATURE_COUNT = LINUX_LOCAL_SERVICE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_USER__ANNOTATIONS = LINUX_LOCAL_USER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_USER__ATTRIBUTE_META_DATA = LINUX_LOCAL_USER__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_USER__EXTENDED_ATTRIBUTES = LINUX_LOCAL_USER__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_USER__ARTIFACT_GROUP = LINUX_LOCAL_USER__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_USER__ARTIFACTS = LINUX_LOCAL_USER__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_USER__CONSTRAINT_GROUP = LINUX_LOCAL_USER__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_USER__CONSTRAINTS = LINUX_LOCAL_USER__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_USER__DESCRIPTION = LINUX_LOCAL_USER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_USER__DISPLAY_NAME = LINUX_LOCAL_USER__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_USER__MUTABLE = LINUX_LOCAL_USER__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_USER__NAME = LINUX_LOCAL_USER__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_USER__STEREOTYPES = LINUX_LOCAL_USER__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_USER__BUILD_VERSION = LINUX_LOCAL_USER__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_USER__LINK_TYPE = LINUX_LOCAL_USER__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_USER__ORIGIN = LINUX_LOCAL_USER__ORIGIN;

	/**
	 * The feature id for the '<em><b>User Id</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_USER__USER_ID = LINUX_LOCAL_USER__USER_ID;

	/**
	 * The feature id for the '<em><b>User Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_USER__USER_PASSWORD = LINUX_LOCAL_USER__USER_PASSWORD;

	/**
	 * The feature id for the '<em><b>Account Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_USER__ACCOUNT_DESCRIPTION = LINUX_LOCAL_USER__ACCOUNT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Account Disabled</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_USER__ACCOUNT_DISABLED = LINUX_LOCAL_USER__ACCOUNT_DISABLED;

	/**
	 * The feature id for the '<em><b>Change Password Next Logon</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_USER__CHANGE_PASSWORD_NEXT_LOGON = LINUX_LOCAL_USER__CHANGE_PASSWORD_NEXT_LOGON;

	/**
	 * The feature id for the '<em><b>Full Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_USER__FULL_NAME = LINUX_LOCAL_USER__FULL_NAME;

	/**
	 * The feature id for the '<em><b>Home Dir</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_USER__HOME_DIR = LINUX_LOCAL_USER__HOME_DIR;

	/**
	 * The feature id for the '<em><b>Password Never Expires</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_USER__PASSWORD_NEVER_EXPIRES = LINUX_LOCAL_USER__PASSWORD_NEVER_EXPIRES;

	/**
	 * The feature id for the '<em><b>Shell</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_USER__SHELL = LINUX_LOCAL_USER__SHELL;

	/**
	 * The feature id for the '<em><b>User Cannot Change Password</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_USER__USER_CANNOT_CHANGE_PASSWORD = LINUX_LOCAL_USER__USER_CANNOT_CHANGE_PASSWORD;

	/**
	 * The feature id for the '<em><b>User Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_USER__USER_NAME = LINUX_LOCAL_USER__USER_NAME;

	/**
	 * The feature id for the '<em><b>Account Disable After Days</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_USER__ACCOUNT_DISABLE_AFTER_DAYS = LINUX_LOCAL_USER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Account Disable Date</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_USER__ACCOUNT_DISABLE_DATE = LINUX_LOCAL_USER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Days Before Password May Change</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_USER__DAYS_BEFORE_PASSWORD_MAY_CHANGE = LINUX_LOCAL_USER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Last Password Change</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_USER__LAST_PASSWORD_CHANGE = LINUX_LOCAL_USER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Password Expire After Days</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_USER__PASSWORD_EXPIRE_AFTER_DAYS = LINUX_LOCAL_USER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Password Expire Warning Days</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_USER__PASSWORD_EXPIRE_WARNING_DAYS = LINUX_LOCAL_USER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>User Sid</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_USER__USER_SID = LINUX_LOCAL_USER_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Redhat Linux Local User</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_LOCAL_USER_FEATURE_COUNT = LINUX_LOCAL_USER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM__ANNOTATIONS = LINUX_OPERATING_SYSTEM__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM__ATTRIBUTE_META_DATA = LINUX_OPERATING_SYSTEM__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM__EXTENDED_ATTRIBUTES = LINUX_OPERATING_SYSTEM__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM__ARTIFACT_GROUP = LINUX_OPERATING_SYSTEM__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM__ARTIFACTS = LINUX_OPERATING_SYSTEM__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM__CONSTRAINT_GROUP = LINUX_OPERATING_SYSTEM__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM__CONSTRAINTS = LINUX_OPERATING_SYSTEM__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM__DESCRIPTION = LINUX_OPERATING_SYSTEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM__DISPLAY_NAME = LINUX_OPERATING_SYSTEM__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM__MUTABLE = LINUX_OPERATING_SYSTEM__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM__NAME = LINUX_OPERATING_SYSTEM__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM__STEREOTYPES = LINUX_OPERATING_SYSTEM__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM__BUILD_VERSION = LINUX_OPERATING_SYSTEM__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM__LINK_TYPE = LINUX_OPERATING_SYSTEM__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM__ORIGIN = LINUX_OPERATING_SYSTEM__ORIGIN;

	/**
	 * The feature id for the '<em><b>Fqdn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM__FQDN = LINUX_OPERATING_SYSTEM__FQDN;

	/**
	 * The feature id for the '<em><b>Hostname</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM__HOSTNAME = LINUX_OPERATING_SYSTEM__HOSTNAME;

	/**
	 * The feature id for the '<em><b>Kernel Architecture</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM__KERNEL_ARCHITECTURE = LINUX_OPERATING_SYSTEM__KERNEL_ARCHITECTURE;

	/**
	 * The feature id for the '<em><b>Kernel Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM__KERNEL_VERSION = LINUX_OPERATING_SYSTEM__KERNEL_VERSION;

	/**
	 * The feature id for the '<em><b>Kernel Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM__KERNEL_WIDTH = LINUX_OPERATING_SYSTEM__KERNEL_WIDTH;

	/**
	 * The feature id for the '<em><b>Locale</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM__LOCALE = LINUX_OPERATING_SYSTEM__LOCALE;

	/**
	 * The feature id for the '<em><b>Manufacturer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM__MANUFACTURER = LINUX_OPERATING_SYSTEM__MANUFACTURER;

	/**
	 * The feature id for the '<em><b>Os Distribution</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM__OS_DISTRIBUTION = LINUX_OPERATING_SYSTEM__OS_DISTRIBUTION;

	/**
	 * The feature id for the '<em><b>Os Servicepack</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM__OS_SERVICEPACK = LINUX_OPERATING_SYSTEM__OS_SERVICEPACK;

	/**
	 * The feature id for the '<em><b>Os Type</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM__OS_TYPE = LINUX_OPERATING_SYSTEM__OS_TYPE;

	/**
	 * The feature id for the '<em><b>Os Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM__OS_VERSION = LINUX_OPERATING_SYSTEM__OS_VERSION;

	/**
	 * The feature id for the '<em><b>Time Zone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM__TIME_ZONE = LINUX_OPERATING_SYSTEM__TIME_ZONE;

	/**
	 * The feature id for the '<em><b>Kernel Release</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM__KERNEL_RELEASE = LINUX_OPERATING_SYSTEM__KERNEL_RELEASE;

	/**
	 * The feature id for the '<em><b>Boot Loader</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM__BOOT_LOADER = LINUX_OPERATING_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Desktop</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM__DESKTOP = LINUX_OPERATING_SYSTEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Install Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM__INSTALL_DATE = LINUX_OPERATING_SYSTEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Last Boot Up Time</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM__LAST_BOOT_UP_TIME = LINUX_OPERATING_SYSTEM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM__OWNER = LINUX_OPERATING_SYSTEM_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Product Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM__PRODUCT_TYPE = LINUX_OPERATING_SYSTEM_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>SE Linux State</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM__SE_LINUX_STATE = LINUX_OPERATING_SYSTEM_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Redhat Linux Operating System</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_LINUX_OPERATING_SYSTEM_FEATURE_COUNT = LINUX_OPERATING_SYSTEM_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.SMBFileSystemImpl <em>SMB File System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.SMBFileSystemImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getSMBFileSystem()
	 * @generated
	 */
	int SMB_FILE_SYSTEM = 42;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM__ANNOTATIONS = REMOTE_FILE_SYSTEM__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM__ATTRIBUTE_META_DATA = REMOTE_FILE_SYSTEM__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM__EXTENDED_ATTRIBUTES = REMOTE_FILE_SYSTEM__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM__ARTIFACT_GROUP = REMOTE_FILE_SYSTEM__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM__ARTIFACTS = REMOTE_FILE_SYSTEM__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM__CONSTRAINT_GROUP = REMOTE_FILE_SYSTEM__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM__CONSTRAINTS = REMOTE_FILE_SYSTEM__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM__DESCRIPTION = REMOTE_FILE_SYSTEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM__DISPLAY_NAME = REMOTE_FILE_SYSTEM__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM__MUTABLE = REMOTE_FILE_SYSTEM__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM__NAME = REMOTE_FILE_SYSTEM__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM__STEREOTYPES = REMOTE_FILE_SYSTEM__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM__BUILD_VERSION = REMOTE_FILE_SYSTEM__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM__LINK_TYPE = REMOTE_FILE_SYSTEM__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM__ORIGIN = REMOTE_FILE_SYSTEM__ORIGIN;

	/**
	 * The feature id for the '<em><b>Available Space</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM__AVAILABLE_SPACE = REMOTE_FILE_SYSTEM__AVAILABLE_SPACE;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM__CAPACITY = REMOTE_FILE_SYSTEM__CAPACITY;

	/**
	 * The feature id for the '<em><b>Mount Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM__MOUNT_POINT = REMOTE_FILE_SYSTEM__MOUNT_POINT;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM__TYPE = REMOTE_FILE_SYSTEM__TYPE;

	/**
	 * The feature id for the '<em><b>Export Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM__EXPORT_NAME = REMOTE_FILE_SYSTEM__EXPORT_NAME;

	/**
	 * The feature id for the '<em><b>Server Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM__SERVER_NAME = REMOTE_FILE_SYSTEM__SERVER_NAME;

	/**
	 * The number of structural features of the '<em>SMB File System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM_FEATURE_COUNT = REMOTE_FILE_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.SMBFileSystemUnitImpl <em>SMB File System Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.SMBFileSystemUnitImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getSMBFileSystemUnit()
	 * @generated
	 */
	int SMB_FILE_SYSTEM_UNIT = 43;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM_UNIT__ANNOTATIONS = REMOTE_FILE_SYSTEM_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM_UNIT__ATTRIBUTE_META_DATA = REMOTE_FILE_SYSTEM_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM_UNIT__EXTENDED_ATTRIBUTES = REMOTE_FILE_SYSTEM_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM_UNIT__ARTIFACT_GROUP = REMOTE_FILE_SYSTEM_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM_UNIT__ARTIFACTS = REMOTE_FILE_SYSTEM_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM_UNIT__CONSTRAINT_GROUP = REMOTE_FILE_SYSTEM_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM_UNIT__CONSTRAINTS = REMOTE_FILE_SYSTEM_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM_UNIT__DESCRIPTION = REMOTE_FILE_SYSTEM_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM_UNIT__DISPLAY_NAME = REMOTE_FILE_SYSTEM_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM_UNIT__MUTABLE = REMOTE_FILE_SYSTEM_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM_UNIT__NAME = REMOTE_FILE_SYSTEM_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM_UNIT__CAPABILITY_GROUP = REMOTE_FILE_SYSTEM_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM_UNIT__CAPABILITIES = REMOTE_FILE_SYSTEM_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM_UNIT__REQUIREMENT_GROUP = REMOTE_FILE_SYSTEM_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM_UNIT__REQUIREMENTS = REMOTE_FILE_SYSTEM_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM_UNIT__UNIT_LINKS_GROUP = REMOTE_FILE_SYSTEM_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM_UNIT__UNIT_LINKS = REMOTE_FILE_SYSTEM_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM_UNIT__CONSTRAINT_LINKS = REMOTE_FILE_SYSTEM_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM_UNIT__REALIZATION_LINKS = REMOTE_FILE_SYSTEM_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM_UNIT__STEREOTYPES = REMOTE_FILE_SYSTEM_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM_UNIT__BUILD_VERSION = REMOTE_FILE_SYSTEM_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM_UNIT__CONCEPTUAL = REMOTE_FILE_SYSTEM_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM_UNIT__CONFIGURATION_UNIT = REMOTE_FILE_SYSTEM_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM_UNIT__GOAL_INSTALL_STATE = REMOTE_FILE_SYSTEM_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM_UNIT__INIT_INSTALL_STATE = REMOTE_FILE_SYSTEM_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM_UNIT__ORIGIN = REMOTE_FILE_SYSTEM_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM_UNIT__PUBLISH_INTENT = REMOTE_FILE_SYSTEM_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>SMB File System Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMB_FILE_SYSTEM_UNIT_FEATURE_COUNT = REMOTE_FILE_SYSTEM_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.SUSELinuxLocalGroupImpl <em>SUSE Linux Local Group</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.SUSELinuxLocalGroupImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getSUSELinuxLocalGroup()
	 * @generated
	 */
	int SUSE_LINUX_LOCAL_GROUP = 46;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.SUSELinuxLocalServiceImpl <em>SUSE Linux Local Service</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.SUSELinuxLocalServiceImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getSUSELinuxLocalService()
	 * @generated
	 */
	int SUSE_LINUX_LOCAL_SERVICE = 47;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.SUSELinuxLocalUserImpl <em>SUSE Linux Local User</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.SUSELinuxLocalUserImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getSUSELinuxLocalUser()
	 * @generated
	 */
	int SUSE_LINUX_LOCAL_USER = 48;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.SUSELinuxOperatingSystemImpl <em>SUSE Linux Operating System</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.SUSELinuxOperatingSystemImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getSUSELinuxOperatingSystem()
	 * @generated
	 */
	int SUSE_LINUX_OPERATING_SYSTEM = 49;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.UnixDirectoryImpl <em>Unix Directory</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.UnixDirectoryImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getUnixDirectory()
	 * @generated
	 */
	int UNIX_DIRECTORY = 50;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.UnixFileSystemImpl <em>Unix File System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.UnixFileSystemImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getUnixFileSystem()
	 * @generated
	 */
	int UNIX_FILE_SYSTEM = 51;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM__ANNOTATIONS = LOCAL_FILE_SYSTEM__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM__ATTRIBUTE_META_DATA = LOCAL_FILE_SYSTEM__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM__EXTENDED_ATTRIBUTES = LOCAL_FILE_SYSTEM__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM__ARTIFACT_GROUP = LOCAL_FILE_SYSTEM__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM__ARTIFACTS = LOCAL_FILE_SYSTEM__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM__CONSTRAINT_GROUP = LOCAL_FILE_SYSTEM__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM__CONSTRAINTS = LOCAL_FILE_SYSTEM__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM__DESCRIPTION = LOCAL_FILE_SYSTEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM__DISPLAY_NAME = LOCAL_FILE_SYSTEM__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM__MUTABLE = LOCAL_FILE_SYSTEM__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM__NAME = LOCAL_FILE_SYSTEM__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM__STEREOTYPES = LOCAL_FILE_SYSTEM__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM__BUILD_VERSION = LOCAL_FILE_SYSTEM__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM__LINK_TYPE = LOCAL_FILE_SYSTEM__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM__ORIGIN = LOCAL_FILE_SYSTEM__ORIGIN;

	/**
	 * The feature id for the '<em><b>Available Space</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM__AVAILABLE_SPACE = LOCAL_FILE_SYSTEM__AVAILABLE_SPACE;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM__CAPACITY = LOCAL_FILE_SYSTEM__CAPACITY;

	/**
	 * The feature id for the '<em><b>Mount Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM__MOUNT_POINT = LOCAL_FILE_SYSTEM__MOUNT_POINT;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM__TYPE = LOCAL_FILE_SYSTEM__TYPE;

	/**
	 * The number of structural features of the '<em>Unix File System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM_FEATURE_COUNT = LOCAL_FILE_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.SolarisFileSystemImpl <em>Solaris File System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.SolarisFileSystemImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getSolarisFileSystem()
	 * @generated
	 */
	int SOLARIS_FILE_SYSTEM = 44;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM__ANNOTATIONS = UNIX_FILE_SYSTEM__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM__ATTRIBUTE_META_DATA = UNIX_FILE_SYSTEM__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM__EXTENDED_ATTRIBUTES = UNIX_FILE_SYSTEM__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM__ARTIFACT_GROUP = UNIX_FILE_SYSTEM__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM__ARTIFACTS = UNIX_FILE_SYSTEM__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM__CONSTRAINT_GROUP = UNIX_FILE_SYSTEM__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM__CONSTRAINTS = UNIX_FILE_SYSTEM__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM__DESCRIPTION = UNIX_FILE_SYSTEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM__DISPLAY_NAME = UNIX_FILE_SYSTEM__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM__MUTABLE = UNIX_FILE_SYSTEM__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM__NAME = UNIX_FILE_SYSTEM__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM__STEREOTYPES = UNIX_FILE_SYSTEM__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM__BUILD_VERSION = UNIX_FILE_SYSTEM__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM__LINK_TYPE = UNIX_FILE_SYSTEM__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM__ORIGIN = UNIX_FILE_SYSTEM__ORIGIN;

	/**
	 * The feature id for the '<em><b>Available Space</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM__AVAILABLE_SPACE = UNIX_FILE_SYSTEM__AVAILABLE_SPACE;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM__CAPACITY = UNIX_FILE_SYSTEM__CAPACITY;

	/**
	 * The feature id for the '<em><b>Mount Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM__MOUNT_POINT = UNIX_FILE_SYSTEM__MOUNT_POINT;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM__TYPE = UNIX_FILE_SYSTEM__TYPE;

	/**
	 * The number of structural features of the '<em>Solaris File System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM_FEATURE_COUNT = UNIX_FILE_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.UnixFileSystemUnitImpl <em>Unix File System Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.UnixFileSystemUnitImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getUnixFileSystemUnit()
	 * @generated
	 */
	int UNIX_FILE_SYSTEM_UNIT = 52;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM_UNIT__ANNOTATIONS = LOCAL_FILE_SYSTEM_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM_UNIT__ATTRIBUTE_META_DATA = LOCAL_FILE_SYSTEM_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM_UNIT__EXTENDED_ATTRIBUTES = LOCAL_FILE_SYSTEM_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM_UNIT__ARTIFACT_GROUP = LOCAL_FILE_SYSTEM_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM_UNIT__ARTIFACTS = LOCAL_FILE_SYSTEM_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM_UNIT__CONSTRAINT_GROUP = LOCAL_FILE_SYSTEM_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM_UNIT__CONSTRAINTS = LOCAL_FILE_SYSTEM_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM_UNIT__DESCRIPTION = LOCAL_FILE_SYSTEM_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM_UNIT__DISPLAY_NAME = LOCAL_FILE_SYSTEM_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM_UNIT__MUTABLE = LOCAL_FILE_SYSTEM_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM_UNIT__NAME = LOCAL_FILE_SYSTEM_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM_UNIT__CAPABILITY_GROUP = LOCAL_FILE_SYSTEM_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM_UNIT__CAPABILITIES = LOCAL_FILE_SYSTEM_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM_UNIT__REQUIREMENT_GROUP = LOCAL_FILE_SYSTEM_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM_UNIT__REQUIREMENTS = LOCAL_FILE_SYSTEM_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM_UNIT__UNIT_LINKS_GROUP = LOCAL_FILE_SYSTEM_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM_UNIT__UNIT_LINKS = LOCAL_FILE_SYSTEM_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM_UNIT__CONSTRAINT_LINKS = LOCAL_FILE_SYSTEM_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM_UNIT__REALIZATION_LINKS = LOCAL_FILE_SYSTEM_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM_UNIT__STEREOTYPES = LOCAL_FILE_SYSTEM_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM_UNIT__BUILD_VERSION = LOCAL_FILE_SYSTEM_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM_UNIT__CONCEPTUAL = LOCAL_FILE_SYSTEM_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM_UNIT__CONFIGURATION_UNIT = LOCAL_FILE_SYSTEM_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM_UNIT__GOAL_INSTALL_STATE = LOCAL_FILE_SYSTEM_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM_UNIT__INIT_INSTALL_STATE = LOCAL_FILE_SYSTEM_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM_UNIT__ORIGIN = LOCAL_FILE_SYSTEM_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM_UNIT__PUBLISH_INTENT = LOCAL_FILE_SYSTEM_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Unix File System Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_FILE_SYSTEM_UNIT_FEATURE_COUNT = LOCAL_FILE_SYSTEM_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.SolarisFileSystemUnitImpl <em>Solaris File System Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.SolarisFileSystemUnitImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getSolarisFileSystemUnit()
	 * @generated
	 */
	int SOLARIS_FILE_SYSTEM_UNIT = 45;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM_UNIT__ANNOTATIONS = UNIX_FILE_SYSTEM_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM_UNIT__ATTRIBUTE_META_DATA = UNIX_FILE_SYSTEM_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM_UNIT__EXTENDED_ATTRIBUTES = UNIX_FILE_SYSTEM_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM_UNIT__ARTIFACT_GROUP = UNIX_FILE_SYSTEM_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM_UNIT__ARTIFACTS = UNIX_FILE_SYSTEM_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM_UNIT__CONSTRAINT_GROUP = UNIX_FILE_SYSTEM_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM_UNIT__CONSTRAINTS = UNIX_FILE_SYSTEM_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM_UNIT__DESCRIPTION = UNIX_FILE_SYSTEM_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM_UNIT__DISPLAY_NAME = UNIX_FILE_SYSTEM_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM_UNIT__MUTABLE = UNIX_FILE_SYSTEM_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM_UNIT__NAME = UNIX_FILE_SYSTEM_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM_UNIT__CAPABILITY_GROUP = UNIX_FILE_SYSTEM_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM_UNIT__CAPABILITIES = UNIX_FILE_SYSTEM_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM_UNIT__REQUIREMENT_GROUP = UNIX_FILE_SYSTEM_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM_UNIT__REQUIREMENTS = UNIX_FILE_SYSTEM_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM_UNIT__UNIT_LINKS_GROUP = UNIX_FILE_SYSTEM_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM_UNIT__UNIT_LINKS = UNIX_FILE_SYSTEM_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM_UNIT__CONSTRAINT_LINKS = UNIX_FILE_SYSTEM_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM_UNIT__REALIZATION_LINKS = UNIX_FILE_SYSTEM_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM_UNIT__STEREOTYPES = UNIX_FILE_SYSTEM_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM_UNIT__BUILD_VERSION = UNIX_FILE_SYSTEM_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM_UNIT__CONCEPTUAL = UNIX_FILE_SYSTEM_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM_UNIT__CONFIGURATION_UNIT = UNIX_FILE_SYSTEM_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM_UNIT__GOAL_INSTALL_STATE = UNIX_FILE_SYSTEM_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM_UNIT__INIT_INSTALL_STATE = UNIX_FILE_SYSTEM_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM_UNIT__ORIGIN = UNIX_FILE_SYSTEM_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM_UNIT__PUBLISH_INTENT = UNIX_FILE_SYSTEM_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Solaris File System Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLARIS_FILE_SYSTEM_UNIT_FEATURE_COUNT = UNIX_FILE_SYSTEM_UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_GROUP__ANNOTATIONS = LINUX_LOCAL_GROUP__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_GROUP__ATTRIBUTE_META_DATA = LINUX_LOCAL_GROUP__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_GROUP__EXTENDED_ATTRIBUTES = LINUX_LOCAL_GROUP__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_GROUP__ARTIFACT_GROUP = LINUX_LOCAL_GROUP__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_GROUP__ARTIFACTS = LINUX_LOCAL_GROUP__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_GROUP__CONSTRAINT_GROUP = LINUX_LOCAL_GROUP__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_GROUP__CONSTRAINTS = LINUX_LOCAL_GROUP__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_GROUP__DESCRIPTION = LINUX_LOCAL_GROUP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_GROUP__DISPLAY_NAME = LINUX_LOCAL_GROUP__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_GROUP__MUTABLE = LINUX_LOCAL_GROUP__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_GROUP__NAME = LINUX_LOCAL_GROUP__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_GROUP__STEREOTYPES = LINUX_LOCAL_GROUP__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_GROUP__BUILD_VERSION = LINUX_LOCAL_GROUP__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_GROUP__LINK_TYPE = LINUX_LOCAL_GROUP__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_GROUP__ORIGIN = LINUX_LOCAL_GROUP__ORIGIN;

	/**
	 * The feature id for the '<em><b>Group Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_GROUP__GROUP_NAME = LINUX_LOCAL_GROUP__GROUP_NAME;

	/**
	 * The feature id for the '<em><b>Group Description</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_GROUP__GROUP_DESCRIPTION = LINUX_LOCAL_GROUP__GROUP_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Group Id</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_GROUP__GROUP_ID = LINUX_LOCAL_GROUP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SUSE Linux Local Group</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_GROUP_FEATURE_COUNT = LINUX_LOCAL_GROUP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_SERVICE__ANNOTATIONS = LINUX_LOCAL_SERVICE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_SERVICE__ATTRIBUTE_META_DATA = LINUX_LOCAL_SERVICE__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_SERVICE__EXTENDED_ATTRIBUTES = LINUX_LOCAL_SERVICE__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_SERVICE__ARTIFACT_GROUP = LINUX_LOCAL_SERVICE__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_SERVICE__ARTIFACTS = LINUX_LOCAL_SERVICE__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_SERVICE__CONSTRAINT_GROUP = LINUX_LOCAL_SERVICE__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_SERVICE__CONSTRAINTS = LINUX_LOCAL_SERVICE__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_SERVICE__DESCRIPTION = LINUX_LOCAL_SERVICE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_SERVICE__DISPLAY_NAME = LINUX_LOCAL_SERVICE__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_SERVICE__MUTABLE = LINUX_LOCAL_SERVICE__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_SERVICE__NAME = LINUX_LOCAL_SERVICE__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_SERVICE__STEREOTYPES = LINUX_LOCAL_SERVICE__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_SERVICE__BUILD_VERSION = LINUX_LOCAL_SERVICE__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_SERVICE__LINK_TYPE = LINUX_LOCAL_SERVICE__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_SERVICE__ORIGIN = LINUX_LOCAL_SERVICE__ORIGIN;

	/**
	 * The feature id for the '<em><b>Executable Path</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_SERVICE__EXECUTABLE_PATH = LINUX_LOCAL_SERVICE__EXECUTABLE_PATH;

	/**
	 * The feature id for the '<em><b>Service Account</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_SERVICE__SERVICE_ACCOUNT = LINUX_LOCAL_SERVICE__SERVICE_ACCOUNT;

	/**
	 * The feature id for the '<em><b>Service Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_SERVICE__SERVICE_DESCRIPTION = LINUX_LOCAL_SERVICE__SERVICE_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Service Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_SERVICE__SERVICE_NAME = LINUX_LOCAL_SERVICE__SERVICE_NAME;

	/**
	 * The feature id for the '<em><b>Service Status</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_SERVICE__SERVICE_STATUS = LINUX_LOCAL_SERVICE__SERVICE_STATUS;

	/**
	 * The feature id for the '<em><b>Startup Run Level Five</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FIVE = LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FIVE;

	/**
	 * The feature id for the '<em><b>Startup Run Level Four</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FOUR = LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FOUR;

	/**
	 * The feature id for the '<em><b>Startup Run Level One</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ONE = LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ONE;

	/**
	 * The feature id for the '<em><b>Startup Run Level Six</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_SIX = LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_SIX;

	/**
	 * The feature id for the '<em><b>Startup Run Level Three</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_THREE = LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_THREE;

	/**
	 * The feature id for the '<em><b>Startup Run Level Two</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_TWO = LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_TWO;

	/**
	 * The feature id for the '<em><b>Startup Run Level Zero</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ZERO = LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ZERO;

	/**
	 * The feature id for the '<em><b>Startup Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_SERVICE__STARTUP_TYPE = LINUX_LOCAL_SERVICE__STARTUP_TYPE;

	/**
	 * The number of structural features of the '<em>SUSE Linux Local Service</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_SERVICE_FEATURE_COUNT = LINUX_LOCAL_SERVICE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_USER__ANNOTATIONS = LINUX_LOCAL_USER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_USER__ATTRIBUTE_META_DATA = LINUX_LOCAL_USER__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_USER__EXTENDED_ATTRIBUTES = LINUX_LOCAL_USER__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_USER__ARTIFACT_GROUP = LINUX_LOCAL_USER__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_USER__ARTIFACTS = LINUX_LOCAL_USER__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_USER__CONSTRAINT_GROUP = LINUX_LOCAL_USER__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_USER__CONSTRAINTS = LINUX_LOCAL_USER__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_USER__DESCRIPTION = LINUX_LOCAL_USER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_USER__DISPLAY_NAME = LINUX_LOCAL_USER__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_USER__MUTABLE = LINUX_LOCAL_USER__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_USER__NAME = LINUX_LOCAL_USER__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_USER__STEREOTYPES = LINUX_LOCAL_USER__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_USER__BUILD_VERSION = LINUX_LOCAL_USER__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_USER__LINK_TYPE = LINUX_LOCAL_USER__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_USER__ORIGIN = LINUX_LOCAL_USER__ORIGIN;

	/**
	 * The feature id for the '<em><b>User Id</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_USER__USER_ID = LINUX_LOCAL_USER__USER_ID;

	/**
	 * The feature id for the '<em><b>User Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_USER__USER_PASSWORD = LINUX_LOCAL_USER__USER_PASSWORD;

	/**
	 * The feature id for the '<em><b>Account Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_USER__ACCOUNT_DESCRIPTION = LINUX_LOCAL_USER__ACCOUNT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Account Disabled</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_USER__ACCOUNT_DISABLED = LINUX_LOCAL_USER__ACCOUNT_DISABLED;

	/**
	 * The feature id for the '<em><b>Change Password Next Logon</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_USER__CHANGE_PASSWORD_NEXT_LOGON = LINUX_LOCAL_USER__CHANGE_PASSWORD_NEXT_LOGON;

	/**
	 * The feature id for the '<em><b>Full Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_USER__FULL_NAME = LINUX_LOCAL_USER__FULL_NAME;

	/**
	 * The feature id for the '<em><b>Home Dir</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_USER__HOME_DIR = LINUX_LOCAL_USER__HOME_DIR;

	/**
	 * The feature id for the '<em><b>Password Never Expires</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_USER__PASSWORD_NEVER_EXPIRES = LINUX_LOCAL_USER__PASSWORD_NEVER_EXPIRES;

	/**
	 * The feature id for the '<em><b>Shell</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_USER__SHELL = LINUX_LOCAL_USER__SHELL;

	/**
	 * The feature id for the '<em><b>User Cannot Change Password</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_USER__USER_CANNOT_CHANGE_PASSWORD = LINUX_LOCAL_USER__USER_CANNOT_CHANGE_PASSWORD;

	/**
	 * The feature id for the '<em><b>User Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_USER__USER_NAME = LINUX_LOCAL_USER__USER_NAME;

	/**
	 * The number of structural features of the '<em>SUSE Linux Local User</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_LOCAL_USER_FEATURE_COUNT = LINUX_LOCAL_USER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_OPERATING_SYSTEM__ANNOTATIONS = LINUX_OPERATING_SYSTEM__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_OPERATING_SYSTEM__ATTRIBUTE_META_DATA = LINUX_OPERATING_SYSTEM__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_OPERATING_SYSTEM__EXTENDED_ATTRIBUTES = LINUX_OPERATING_SYSTEM__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_OPERATING_SYSTEM__ARTIFACT_GROUP = LINUX_OPERATING_SYSTEM__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_OPERATING_SYSTEM__ARTIFACTS = LINUX_OPERATING_SYSTEM__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_OPERATING_SYSTEM__CONSTRAINT_GROUP = LINUX_OPERATING_SYSTEM__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_OPERATING_SYSTEM__CONSTRAINTS = LINUX_OPERATING_SYSTEM__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_OPERATING_SYSTEM__DESCRIPTION = LINUX_OPERATING_SYSTEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_OPERATING_SYSTEM__DISPLAY_NAME = LINUX_OPERATING_SYSTEM__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_OPERATING_SYSTEM__MUTABLE = LINUX_OPERATING_SYSTEM__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_OPERATING_SYSTEM__NAME = LINUX_OPERATING_SYSTEM__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_OPERATING_SYSTEM__STEREOTYPES = LINUX_OPERATING_SYSTEM__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_OPERATING_SYSTEM__BUILD_VERSION = LINUX_OPERATING_SYSTEM__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_OPERATING_SYSTEM__LINK_TYPE = LINUX_OPERATING_SYSTEM__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_OPERATING_SYSTEM__ORIGIN = LINUX_OPERATING_SYSTEM__ORIGIN;

	/**
	 * The feature id for the '<em><b>Fqdn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_OPERATING_SYSTEM__FQDN = LINUX_OPERATING_SYSTEM__FQDN;

	/**
	 * The feature id for the '<em><b>Hostname</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_OPERATING_SYSTEM__HOSTNAME = LINUX_OPERATING_SYSTEM__HOSTNAME;

	/**
	 * The feature id for the '<em><b>Kernel Architecture</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_OPERATING_SYSTEM__KERNEL_ARCHITECTURE = LINUX_OPERATING_SYSTEM__KERNEL_ARCHITECTURE;

	/**
	 * The feature id for the '<em><b>Kernel Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_OPERATING_SYSTEM__KERNEL_VERSION = LINUX_OPERATING_SYSTEM__KERNEL_VERSION;

	/**
	 * The feature id for the '<em><b>Kernel Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_OPERATING_SYSTEM__KERNEL_WIDTH = LINUX_OPERATING_SYSTEM__KERNEL_WIDTH;

	/**
	 * The feature id for the '<em><b>Locale</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_OPERATING_SYSTEM__LOCALE = LINUX_OPERATING_SYSTEM__LOCALE;

	/**
	 * The feature id for the '<em><b>Manufacturer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_OPERATING_SYSTEM__MANUFACTURER = LINUX_OPERATING_SYSTEM__MANUFACTURER;

	/**
	 * The feature id for the '<em><b>Os Distribution</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_OPERATING_SYSTEM__OS_DISTRIBUTION = LINUX_OPERATING_SYSTEM__OS_DISTRIBUTION;

	/**
	 * The feature id for the '<em><b>Os Servicepack</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_OPERATING_SYSTEM__OS_SERVICEPACK = LINUX_OPERATING_SYSTEM__OS_SERVICEPACK;

	/**
	 * The feature id for the '<em><b>Os Type</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_OPERATING_SYSTEM__OS_TYPE = LINUX_OPERATING_SYSTEM__OS_TYPE;

	/**
	 * The feature id for the '<em><b>Os Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_OPERATING_SYSTEM__OS_VERSION = LINUX_OPERATING_SYSTEM__OS_VERSION;

	/**
	 * The feature id for the '<em><b>Time Zone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_OPERATING_SYSTEM__TIME_ZONE = LINUX_OPERATING_SYSTEM__TIME_ZONE;

	/**
	 * The feature id for the '<em><b>Kernel Release</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_OPERATING_SYSTEM__KERNEL_RELEASE = LINUX_OPERATING_SYSTEM__KERNEL_RELEASE;

	/**
	 * The feature id for the '<em><b>Boot Loader</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_OPERATING_SYSTEM__BOOT_LOADER = LINUX_OPERATING_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Desktop</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_OPERATING_SYSTEM__DESKTOP = LINUX_OPERATING_SYSTEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Last Boot Up Date</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_OPERATING_SYSTEM__LAST_BOOT_UP_DATE = LINUX_OPERATING_SYSTEM_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>SUSE Linux Operating System</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUSE_LINUX_OPERATING_SYSTEM_FEATURE_COUNT = LINUX_OPERATING_SYSTEM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIX_DIRECTORY__ANNOTATIONS = DIRECTORY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DIRECTORY__ATTRIBUTE_META_DATA = DIRECTORY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DIRECTORY__EXTENDED_ATTRIBUTES = DIRECTORY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIX_DIRECTORY__ARTIFACT_GROUP = DIRECTORY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIX_DIRECTORY__ARTIFACTS = DIRECTORY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIX_DIRECTORY__CONSTRAINT_GROUP = DIRECTORY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIX_DIRECTORY__CONSTRAINTS = DIRECTORY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DIRECTORY__DESCRIPTION = DIRECTORY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DIRECTORY__DISPLAY_NAME = DIRECTORY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DIRECTORY__MUTABLE = DIRECTORY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DIRECTORY__NAME = DIRECTORY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DIRECTORY__STEREOTYPES = DIRECTORY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DIRECTORY__BUILD_VERSION = DIRECTORY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DIRECTORY__LINK_TYPE = DIRECTORY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DIRECTORY__ORIGIN = DIRECTORY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Fixed Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DIRECTORY__FIXED_PATH = DIRECTORY__FIXED_PATH;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DIRECTORY__GROUP = DIRECTORY__GROUP;

	/**
	 * The feature id for the '<em><b>Last Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DIRECTORY__LAST_MODIFIED = DIRECTORY__LAST_MODIFIED;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DIRECTORY__OWNER = DIRECTORY__OWNER;

	/**
	 * The feature id for the '<em><b>Permissions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DIRECTORY__PERMISSIONS = DIRECTORY__PERMISSIONS;

	/**
	 * The feature id for the '<em><b>Real File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DIRECTORY__REAL_FILE = DIRECTORY__REAL_FILE;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DIRECTORY__SIZE = DIRECTORY__SIZE;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DIRECTORY__URI = DIRECTORY__URI;

	/**
	 * The feature id for the '<em><b>Directory Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIX_DIRECTORY__DIRECTORY_PATH = DIRECTORY__DIRECTORY_PATH;

	/**
	 * The number of structural features of the '<em>Unix Directory</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIX_DIRECTORY_FEATURE_COUNT = DIRECTORY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.WindowsDirectoryImpl <em>Windows Directory</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.WindowsDirectoryImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsDirectory()
	 * @generated
	 */
	int WINDOWS_DIRECTORY = 57;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DIRECTORY__ANNOTATIONS = DIRECTORY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DIRECTORY__ATTRIBUTE_META_DATA = DIRECTORY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DIRECTORY__EXTENDED_ATTRIBUTES = DIRECTORY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DIRECTORY__ARTIFACT_GROUP = DIRECTORY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DIRECTORY__ARTIFACTS = DIRECTORY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DIRECTORY__CONSTRAINT_GROUP = DIRECTORY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DIRECTORY__CONSTRAINTS = DIRECTORY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DIRECTORY__DESCRIPTION = DIRECTORY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DIRECTORY__DISPLAY_NAME = DIRECTORY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DIRECTORY__MUTABLE = DIRECTORY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DIRECTORY__NAME = DIRECTORY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DIRECTORY__STEREOTYPES = DIRECTORY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DIRECTORY__BUILD_VERSION = DIRECTORY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DIRECTORY__LINK_TYPE = DIRECTORY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DIRECTORY__ORIGIN = DIRECTORY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Fixed Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DIRECTORY__FIXED_PATH = DIRECTORY__FIXED_PATH;

	/**
	 * The feature id for the '<em><b>Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DIRECTORY__GROUP = DIRECTORY__GROUP;

	/**
	 * The feature id for the '<em><b>Last Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DIRECTORY__LAST_MODIFIED = DIRECTORY__LAST_MODIFIED;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DIRECTORY__OWNER = DIRECTORY__OWNER;

	/**
	 * The feature id for the '<em><b>Permissions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DIRECTORY__PERMISSIONS = DIRECTORY__PERMISSIONS;

	/**
	 * The feature id for the '<em><b>Real File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DIRECTORY__REAL_FILE = DIRECTORY__REAL_FILE;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DIRECTORY__SIZE = DIRECTORY__SIZE;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DIRECTORY__URI = DIRECTORY__URI;

	/**
	 * The feature id for the '<em><b>Directory Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DIRECTORY__DIRECTORY_PATH = DIRECTORY__DIRECTORY_PATH;

	/**
	 * The number of structural features of the '<em>Windows Directory</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_DIRECTORY_FEATURE_COUNT = DIRECTORY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.WindowsFileSystemImpl <em>Windows File System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.WindowsFileSystemImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsFileSystem()
	 * @generated
	 */
	int WINDOWS_FILE_SYSTEM = 58;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM__ANNOTATIONS = LOCAL_FILE_SYSTEM__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM__ATTRIBUTE_META_DATA = LOCAL_FILE_SYSTEM__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM__EXTENDED_ATTRIBUTES = LOCAL_FILE_SYSTEM__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM__ARTIFACT_GROUP = LOCAL_FILE_SYSTEM__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM__ARTIFACTS = LOCAL_FILE_SYSTEM__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM__CONSTRAINT_GROUP = LOCAL_FILE_SYSTEM__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM__CONSTRAINTS = LOCAL_FILE_SYSTEM__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM__DESCRIPTION = LOCAL_FILE_SYSTEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM__DISPLAY_NAME = LOCAL_FILE_SYSTEM__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM__MUTABLE = LOCAL_FILE_SYSTEM__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM__NAME = LOCAL_FILE_SYSTEM__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM__STEREOTYPES = LOCAL_FILE_SYSTEM__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM__BUILD_VERSION = LOCAL_FILE_SYSTEM__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM__LINK_TYPE = LOCAL_FILE_SYSTEM__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM__ORIGIN = LOCAL_FILE_SYSTEM__ORIGIN;

	/**
	 * The feature id for the '<em><b>Available Space</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM__AVAILABLE_SPACE = LOCAL_FILE_SYSTEM__AVAILABLE_SPACE;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM__CAPACITY = LOCAL_FILE_SYSTEM__CAPACITY;

	/**
	 * The feature id for the '<em><b>Mount Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM__MOUNT_POINT = LOCAL_FILE_SYSTEM__MOUNT_POINT;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM__TYPE = LOCAL_FILE_SYSTEM__TYPE;

	/**
	 * The number of structural features of the '<em>Windows File System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM_FEATURE_COUNT = LOCAL_FILE_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.WindowsFileSystemUnitImpl <em>Windows File System Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.WindowsFileSystemUnitImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsFileSystemUnit()
	 * @generated
	 */
	int WINDOWS_FILE_SYSTEM_UNIT = 59;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM_UNIT__ANNOTATIONS = LOCAL_FILE_SYSTEM_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM_UNIT__ATTRIBUTE_META_DATA = LOCAL_FILE_SYSTEM_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM_UNIT__EXTENDED_ATTRIBUTES = LOCAL_FILE_SYSTEM_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM_UNIT__ARTIFACT_GROUP = LOCAL_FILE_SYSTEM_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM_UNIT__ARTIFACTS = LOCAL_FILE_SYSTEM_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM_UNIT__CONSTRAINT_GROUP = LOCAL_FILE_SYSTEM_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM_UNIT__CONSTRAINTS = LOCAL_FILE_SYSTEM_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM_UNIT__DESCRIPTION = LOCAL_FILE_SYSTEM_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM_UNIT__DISPLAY_NAME = LOCAL_FILE_SYSTEM_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM_UNIT__MUTABLE = LOCAL_FILE_SYSTEM_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM_UNIT__NAME = LOCAL_FILE_SYSTEM_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM_UNIT__CAPABILITY_GROUP = LOCAL_FILE_SYSTEM_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM_UNIT__CAPABILITIES = LOCAL_FILE_SYSTEM_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM_UNIT__REQUIREMENT_GROUP = LOCAL_FILE_SYSTEM_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM_UNIT__REQUIREMENTS = LOCAL_FILE_SYSTEM_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM_UNIT__UNIT_LINKS_GROUP = LOCAL_FILE_SYSTEM_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM_UNIT__UNIT_LINKS = LOCAL_FILE_SYSTEM_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM_UNIT__CONSTRAINT_LINKS = LOCAL_FILE_SYSTEM_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM_UNIT__REALIZATION_LINKS = LOCAL_FILE_SYSTEM_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM_UNIT__STEREOTYPES = LOCAL_FILE_SYSTEM_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM_UNIT__BUILD_VERSION = LOCAL_FILE_SYSTEM_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM_UNIT__CONCEPTUAL = LOCAL_FILE_SYSTEM_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM_UNIT__CONFIGURATION_UNIT = LOCAL_FILE_SYSTEM_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM_UNIT__GOAL_INSTALL_STATE = LOCAL_FILE_SYSTEM_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM_UNIT__INIT_INSTALL_STATE = LOCAL_FILE_SYSTEM_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM_UNIT__ORIGIN = LOCAL_FILE_SYSTEM_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM_UNIT__PUBLISH_INTENT = LOCAL_FILE_SYSTEM_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Windows File System Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_FILE_SYSTEM_UNIT_FEATURE_COUNT = LOCAL_FILE_SYSTEM_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalGroupImpl <em>Windows Local Group</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.WindowsLocalGroupImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsLocalGroup()
	 * @generated
	 */
	int WINDOWS_LOCAL_GROUP = 60;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP__ANNOTATIONS = USER_GROUP__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP__ATTRIBUTE_META_DATA = USER_GROUP__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP__EXTENDED_ATTRIBUTES = USER_GROUP__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP__ARTIFACT_GROUP = USER_GROUP__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP__ARTIFACTS = USER_GROUP__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP__CONSTRAINT_GROUP = USER_GROUP__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP__CONSTRAINTS = USER_GROUP__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP__DESCRIPTION = USER_GROUP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP__DISPLAY_NAME = USER_GROUP__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP__MUTABLE = USER_GROUP__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP__NAME = USER_GROUP__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP__STEREOTYPES = USER_GROUP__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP__BUILD_VERSION = USER_GROUP__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP__LINK_TYPE = USER_GROUP__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP__ORIGIN = USER_GROUP__ORIGIN;

	/**
	 * The feature id for the '<em><b>Group Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP__GROUP_NAME = USER_GROUP__GROUP_NAME;

	/**
	 * The feature id for the '<em><b>Description1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP__DESCRIPTION1 = USER_GROUP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Group Sid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP__GROUP_SID = USER_GROUP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Windows Local Group</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP_FEATURE_COUNT = USER_GROUP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalGroupUnitImpl <em>Windows Local Group Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.WindowsLocalGroupUnitImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsLocalGroupUnit()
	 * @generated
	 */
	int WINDOWS_LOCAL_GROUP_UNIT = 61;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP_UNIT__ANNOTATIONS = USER_GROUP_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP_UNIT__ATTRIBUTE_META_DATA = USER_GROUP_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP_UNIT__EXTENDED_ATTRIBUTES = USER_GROUP_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP_UNIT__ARTIFACT_GROUP = USER_GROUP_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP_UNIT__ARTIFACTS = USER_GROUP_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP_UNIT__CONSTRAINT_GROUP = USER_GROUP_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP_UNIT__CONSTRAINTS = USER_GROUP_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP_UNIT__DESCRIPTION = USER_GROUP_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP_UNIT__DISPLAY_NAME = USER_GROUP_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP_UNIT__MUTABLE = USER_GROUP_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP_UNIT__NAME = USER_GROUP_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP_UNIT__CAPABILITY_GROUP = USER_GROUP_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP_UNIT__CAPABILITIES = USER_GROUP_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP_UNIT__REQUIREMENT_GROUP = USER_GROUP_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP_UNIT__REQUIREMENTS = USER_GROUP_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP_UNIT__UNIT_LINKS_GROUP = USER_GROUP_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP_UNIT__UNIT_LINKS = USER_GROUP_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP_UNIT__CONSTRAINT_LINKS = USER_GROUP_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP_UNIT__REALIZATION_LINKS = USER_GROUP_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP_UNIT__STEREOTYPES = USER_GROUP_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP_UNIT__BUILD_VERSION = USER_GROUP_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP_UNIT__CONCEPTUAL = USER_GROUP_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP_UNIT__CONFIGURATION_UNIT = USER_GROUP_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP_UNIT__GOAL_INSTALL_STATE = USER_GROUP_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP_UNIT__INIT_INSTALL_STATE = USER_GROUP_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP_UNIT__ORIGIN = USER_GROUP_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP_UNIT__PUBLISH_INTENT = USER_GROUP_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Windows Local Group Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_GROUP_UNIT_FEATURE_COUNT = USER_GROUP_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalServiceImpl <em>Windows Local Service</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.WindowsLocalServiceImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsLocalService()
	 * @generated
	 */
	int WINDOWS_LOCAL_SERVICE = 62;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE__ANNOTATIONS = CorePackage.CAPABILITY__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE__ATTRIBUTE_META_DATA = CorePackage.CAPABILITY__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE__EXTENDED_ATTRIBUTES = CorePackage.CAPABILITY__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE__ARTIFACT_GROUP = CorePackage.CAPABILITY__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE__ARTIFACTS = CorePackage.CAPABILITY__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE__CONSTRAINT_GROUP = CorePackage.CAPABILITY__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE__CONSTRAINTS = CorePackage.CAPABILITY__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE__DESCRIPTION = CorePackage.CAPABILITY__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE__DISPLAY_NAME = CorePackage.CAPABILITY__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE__MUTABLE = CorePackage.CAPABILITY__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE__NAME = CorePackage.CAPABILITY__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE__STEREOTYPES = CorePackage.CAPABILITY__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE__BUILD_VERSION = CorePackage.CAPABILITY__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE__LINK_TYPE = CorePackage.CAPABILITY__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE__ORIGIN = CorePackage.CAPABILITY__ORIGIN;

	/**
	 * The feature id for the '<em><b>Dependant Components</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE__DEPENDANT_COMPONENTS = CorePackage.CAPABILITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Error Control</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE__ERROR_CONTROL = CorePackage.CAPABILITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Executable Path</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE__EXECUTABLE_PATH = CorePackage.CAPABILITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Log On As System</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE__LOG_ON_AS_SYSTEM = CorePackage.CAPABILITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Run Program</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE__RUN_PROGRAM = CorePackage.CAPABILITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Service Account</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE__SERVICE_ACCOUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Service Account Password</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE__SERVICE_ACCOUNT_PASSWORD = CorePackage.CAPABILITY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Service Dependencies</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE__SERVICE_DEPENDENCIES = CorePackage.CAPABILITY_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Service Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE__SERVICE_DESCRIPTION = CorePackage.CAPABILITY_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Service Display Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE__SERVICE_DISPLAY_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Service Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE__SERVICE_NAME = CorePackage.CAPABILITY_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Service Status</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE__SERVICE_STATUS = CorePackage.CAPABILITY_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Start Params</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE__START_PARAMS = CorePackage.CAPABILITY_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Startup Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE__STARTUP_TYPE = CorePackage.CAPABILITY_FEATURE_COUNT + 13;

	/**
	 * The number of structural features of the '<em>Windows Local Service</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE_FEATURE_COUNT = CorePackage.CAPABILITY_FEATURE_COUNT + 14;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalServiceUnitImpl <em>Windows Local Service Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.WindowsLocalServiceUnitImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsLocalServiceUnit()
	 * @generated
	 */
	int WINDOWS_LOCAL_SERVICE_UNIT = 63;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE_UNIT__ANNOTATIONS = CorePackage.UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE_UNIT__ATTRIBUTE_META_DATA = CorePackage.UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE_UNIT__EXTENDED_ATTRIBUTES = CorePackage.UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE_UNIT__ARTIFACT_GROUP = CorePackage.UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE_UNIT__ARTIFACTS = CorePackage.UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE_UNIT__CONSTRAINT_GROUP = CorePackage.UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE_UNIT__CONSTRAINTS = CorePackage.UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE_UNIT__DESCRIPTION = CorePackage.UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE_UNIT__DISPLAY_NAME = CorePackage.UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE_UNIT__MUTABLE = CorePackage.UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE_UNIT__NAME = CorePackage.UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE_UNIT__CAPABILITY_GROUP = CorePackage.UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE_UNIT__CAPABILITIES = CorePackage.UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE_UNIT__REQUIREMENT_GROUP = CorePackage.UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE_UNIT__REQUIREMENTS = CorePackage.UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE_UNIT__UNIT_LINKS_GROUP = CorePackage.UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE_UNIT__UNIT_LINKS = CorePackage.UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE_UNIT__CONSTRAINT_LINKS = CorePackage.UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE_UNIT__REALIZATION_LINKS = CorePackage.UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE_UNIT__STEREOTYPES = CorePackage.UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE_UNIT__BUILD_VERSION = CorePackage.UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE_UNIT__CONCEPTUAL = CorePackage.UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE_UNIT__CONFIGURATION_UNIT = CorePackage.UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE_UNIT__GOAL_INSTALL_STATE = CorePackage.UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE_UNIT__INIT_INSTALL_STATE = CorePackage.UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE_UNIT__ORIGIN = CorePackage.UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE_UNIT__PUBLISH_INTENT = CorePackage.UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Windows Local Service Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_SERVICE_UNIT_FEATURE_COUNT = CorePackage.UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalUserImpl <em>Windows Local User</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.WindowsLocalUserImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsLocalUser()
	 * @generated
	 */
	int WINDOWS_LOCAL_USER = 64;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER__ANNOTATIONS = USER__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER__ATTRIBUTE_META_DATA = USER__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER__EXTENDED_ATTRIBUTES = USER__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER__ARTIFACT_GROUP = USER__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER__ARTIFACTS = USER__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER__CONSTRAINT_GROUP = USER__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER__CONSTRAINTS = USER__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER__DESCRIPTION = USER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER__DISPLAY_NAME = USER__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER__MUTABLE = USER__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER__NAME = USER__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER__STEREOTYPES = USER__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER__BUILD_VERSION = USER__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER__LINK_TYPE = USER__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER__ORIGIN = USER__ORIGIN;

	/**
	 * The feature id for the '<em><b>User Id</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER__USER_ID = USER__USER_ID;

	/**
	 * The feature id for the '<em><b>User Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER__USER_PASSWORD = USER__USER_PASSWORD;

	/**
	 * The feature id for the '<em><b>Account Description</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER__ACCOUNT_DESCRIPTION = USER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Account Disabled</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER__ACCOUNT_DISABLED = USER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Account Locked</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER__ACCOUNT_LOCKED = USER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Change Password Next Logon</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER__CHANGE_PASSWORD_NEXT_LOGON = USER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Enable Remote Control</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER__ENABLE_REMOTE_CONTROL = USER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Full Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER__FULL_NAME = USER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Home Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER__HOME_FOLDER = USER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Logon Script</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER__LOGON_SCRIPT = USER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Password Never Expires</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER__PASSWORD_NEVER_EXPIRES = USER_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Profile Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER__PROFILE_PATH = USER_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>User Account Type</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER__USER_ACCOUNT_TYPE = USER_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>User Cannot Change Password</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER__USER_CANNOT_CHANGE_PASSWORD = USER_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>User Sid</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER__USER_SID = USER_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>User Sid Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER__USER_SID_TYPE = USER_FEATURE_COUNT + 13;

	/**
	 * The number of structural features of the '<em>Windows Local User</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER_FEATURE_COUNT = USER_FEATURE_COUNT + 14;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalUserUnitImpl <em>Windows Local User Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.WindowsLocalUserUnitImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsLocalUserUnit()
	 * @generated
	 */
	int WINDOWS_LOCAL_USER_UNIT = 65;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER_UNIT__ANNOTATIONS = USER_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER_UNIT__ATTRIBUTE_META_DATA = USER_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER_UNIT__EXTENDED_ATTRIBUTES = USER_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER_UNIT__ARTIFACT_GROUP = USER_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER_UNIT__ARTIFACTS = USER_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER_UNIT__CONSTRAINT_GROUP = USER_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER_UNIT__CONSTRAINTS = USER_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER_UNIT__DESCRIPTION = USER_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER_UNIT__DISPLAY_NAME = USER_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER_UNIT__MUTABLE = USER_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER_UNIT__NAME = USER_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER_UNIT__CAPABILITY_GROUP = USER_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER_UNIT__CAPABILITIES = USER_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER_UNIT__REQUIREMENT_GROUP = USER_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER_UNIT__REQUIREMENTS = USER_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER_UNIT__UNIT_LINKS_GROUP = USER_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER_UNIT__UNIT_LINKS = USER_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER_UNIT__CONSTRAINT_LINKS = USER_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER_UNIT__REALIZATION_LINKS = USER_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER_UNIT__STEREOTYPES = USER_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER_UNIT__BUILD_VERSION = USER_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER_UNIT__CONCEPTUAL = USER_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER_UNIT__CONFIGURATION_UNIT = USER_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER_UNIT__GOAL_INSTALL_STATE = USER_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER_UNIT__INIT_INSTALL_STATE = USER_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER_UNIT__ORIGIN = USER_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER_UNIT__PUBLISH_INTENT = USER_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Windows Local User Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_LOCAL_USER_UNIT_FEATURE_COUNT = USER_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.WindowsOperatingSystemImpl <em>Windows Operating System</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.WindowsOperatingSystemImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsOperatingSystem()
	 * @generated
	 */
	int WINDOWS_OPERATING_SYSTEM = 66;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__ANNOTATIONS = OPERATING_SYSTEM__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__ATTRIBUTE_META_DATA = OPERATING_SYSTEM__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__EXTENDED_ATTRIBUTES = OPERATING_SYSTEM__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__ARTIFACT_GROUP = OPERATING_SYSTEM__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__ARTIFACTS = OPERATING_SYSTEM__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__CONSTRAINT_GROUP = OPERATING_SYSTEM__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__CONSTRAINTS = OPERATING_SYSTEM__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__DESCRIPTION = OPERATING_SYSTEM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__DISPLAY_NAME = OPERATING_SYSTEM__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__MUTABLE = OPERATING_SYSTEM__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__NAME = OPERATING_SYSTEM__NAME;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__STEREOTYPES = OPERATING_SYSTEM__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__BUILD_VERSION = OPERATING_SYSTEM__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__LINK_TYPE = OPERATING_SYSTEM__LINK_TYPE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__ORIGIN = OPERATING_SYSTEM__ORIGIN;

	/**
	 * The feature id for the '<em><b>Fqdn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__FQDN = OPERATING_SYSTEM__FQDN;

	/**
	 * The feature id for the '<em><b>Hostname</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__HOSTNAME = OPERATING_SYSTEM__HOSTNAME;

	/**
	 * The feature id for the '<em><b>Kernel Architecture</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__KERNEL_ARCHITECTURE = OPERATING_SYSTEM__KERNEL_ARCHITECTURE;

	/**
	 * The feature id for the '<em><b>Kernel Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__KERNEL_VERSION = OPERATING_SYSTEM__KERNEL_VERSION;

	/**
	 * The feature id for the '<em><b>Kernel Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__KERNEL_WIDTH = OPERATING_SYSTEM__KERNEL_WIDTH;

	/**
	 * The feature id for the '<em><b>Locale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__LOCALE = OPERATING_SYSTEM__LOCALE;

	/**
	 * The feature id for the '<em><b>Manufacturer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__MANUFACTURER = OPERATING_SYSTEM__MANUFACTURER;

	/**
	 * The feature id for the '<em><b>Os Distribution</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__OS_DISTRIBUTION = OPERATING_SYSTEM__OS_DISTRIBUTION;

	/**
	 * The feature id for the '<em><b>Os Servicepack</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__OS_SERVICEPACK = OPERATING_SYSTEM__OS_SERVICEPACK;

	/**
	 * The feature id for the '<em><b>Os Type</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__OS_TYPE = OPERATING_SYSTEM__OS_TYPE;

	/**
	 * The feature id for the '<em><b>Os Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__OS_VERSION = OPERATING_SYSTEM__OS_VERSION;

	/**
	 * The feature id for the '<em><b>Time Zone</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__TIME_ZONE = OPERATING_SYSTEM__TIME_ZONE;

	/**
	 * The feature id for the '<em><b>Company</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__COMPANY = OPERATING_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Domain Admin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__DOMAIN_ADMIN = OPERATING_SYSTEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Domain Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__DOMAIN_NAME = OPERATING_SYSTEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Domain Password</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__DOMAIN_PASSWORD = OPERATING_SYSTEM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Encryption Level</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__ENCRYPTION_LEVEL = OPERATING_SYSTEM_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Install Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__INSTALL_DATE = OPERATING_SYSTEM_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__LANGUAGE = OPERATING_SYSTEM_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Language Group</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__LANGUAGE_GROUP = OPERATING_SYSTEM_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Last Boot Up Time</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__LAST_BOOT_UP_TIME = OPERATING_SYSTEM_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Machine Object OU</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__MACHINE_OBJECT_OU = OPERATING_SYSTEM_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Number Of Licensed Users</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__NUMBER_OF_LICENSED_USERS = OPERATING_SYSTEM_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__OWNER = OPERATING_SYSTEM_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Product Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__PRODUCT_KEY = OPERATING_SYSTEM_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Product Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__PRODUCT_TYPE = OPERATING_SYSTEM_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>System Drive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__SYSTEM_DRIVE = OPERATING_SYSTEM_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Windows Directory</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__WINDOWS_DIRECTORY = OPERATING_SYSTEM_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Workgroup Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM__WORKGROUP_NAME = OPERATING_SYSTEM_FEATURE_COUNT + 16;

	/**
	 * The number of structural features of the '<em>Windows Operating System</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM_FEATURE_COUNT = OPERATING_SYSTEM_FEATURE_COUNT + 17;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.impl.WindowsOperatingSystemUnitImpl <em>Windows Operating System Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.impl.WindowsOperatingSystemUnitImpl
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsOperatingSystemUnit()
	 * @generated
	 */
	int WINDOWS_OPERATING_SYSTEM_UNIT = 67;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM_UNIT__ANNOTATIONS = OPERATING_SYSTEM_UNIT__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attribute Meta Data</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM_UNIT__ATTRIBUTE_META_DATA = OPERATING_SYSTEM_UNIT__ATTRIBUTE_META_DATA;

	/**
	 * The feature id for the '<em><b>Extended Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM_UNIT__EXTENDED_ATTRIBUTES = OPERATING_SYSTEM_UNIT__EXTENDED_ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Artifact Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM_UNIT__ARTIFACT_GROUP = OPERATING_SYSTEM_UNIT__ARTIFACT_GROUP;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM_UNIT__ARTIFACTS = OPERATING_SYSTEM_UNIT__ARTIFACTS;

	/**
	 * The feature id for the '<em><b>Constraint Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM_UNIT__CONSTRAINT_GROUP = OPERATING_SYSTEM_UNIT__CONSTRAINT_GROUP;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM_UNIT__CONSTRAINTS = OPERATING_SYSTEM_UNIT__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM_UNIT__DESCRIPTION = OPERATING_SYSTEM_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Display Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM_UNIT__DISPLAY_NAME = OPERATING_SYSTEM_UNIT__DISPLAY_NAME;

	/**
	 * The feature id for the '<em><b>Mutable</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM_UNIT__MUTABLE = OPERATING_SYSTEM_UNIT__MUTABLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM_UNIT__NAME = OPERATING_SYSTEM_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Capability Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM_UNIT__CAPABILITY_GROUP = OPERATING_SYSTEM_UNIT__CAPABILITY_GROUP;

	/**
	 * The feature id for the '<em><b>Capabilities</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM_UNIT__CAPABILITIES = OPERATING_SYSTEM_UNIT__CAPABILITIES;

	/**
	 * The feature id for the '<em><b>Requirement Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM_UNIT__REQUIREMENT_GROUP = OPERATING_SYSTEM_UNIT__REQUIREMENT_GROUP;

	/**
	 * The feature id for the '<em><b>Requirements</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM_UNIT__REQUIREMENTS = OPERATING_SYSTEM_UNIT__REQUIREMENTS;

	/**
	 * The feature id for the '<em><b>Unit Links Group</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM_UNIT__UNIT_LINKS_GROUP = OPERATING_SYSTEM_UNIT__UNIT_LINKS_GROUP;

	/**
	 * The feature id for the '<em><b>Unit Links</b></em>' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM_UNIT__UNIT_LINKS = OPERATING_SYSTEM_UNIT__UNIT_LINKS;

	/**
	 * The feature id for the '<em><b>Constraint Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM_UNIT__CONSTRAINT_LINKS = OPERATING_SYSTEM_UNIT__CONSTRAINT_LINKS;

	/**
	 * The feature id for the '<em><b>Realization Links</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM_UNIT__REALIZATION_LINKS = OPERATING_SYSTEM_UNIT__REALIZATION_LINKS;

	/**
	 * The feature id for the '<em><b>Stereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM_UNIT__STEREOTYPES = OPERATING_SYSTEM_UNIT__STEREOTYPES;

	/**
	 * The feature id for the '<em><b>Build Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM_UNIT__BUILD_VERSION = OPERATING_SYSTEM_UNIT__BUILD_VERSION;

	/**
	 * The feature id for the '<em><b>Conceptual</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM_UNIT__CONCEPTUAL = OPERATING_SYSTEM_UNIT__CONCEPTUAL;

	/**
	 * The feature id for the '<em><b>Configuration Unit</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM_UNIT__CONFIGURATION_UNIT = OPERATING_SYSTEM_UNIT__CONFIGURATION_UNIT;

	/**
	 * The feature id for the '<em><b>Goal Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM_UNIT__GOAL_INSTALL_STATE = OPERATING_SYSTEM_UNIT__GOAL_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Init Install State</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM_UNIT__INIT_INSTALL_STATE = OPERATING_SYSTEM_UNIT__INIT_INSTALL_STATE;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM_UNIT__ORIGIN = OPERATING_SYSTEM_UNIT__ORIGIN;

	/**
	 * The feature id for the '<em><b>Publish Intent</b></em>' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM_UNIT__PUBLISH_INTENT = OPERATING_SYSTEM_UNIT__PUBLISH_INTENT;

	/**
	 * The number of structural features of the '<em>Windows Operating System Unit</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WINDOWS_OPERATING_SYSTEM_UNIT_FEATURE_COUNT = OPERATING_SYSTEM_UNIT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.AIXAuthMethodType <em>AIX Auth Method Type</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.AIXAuthMethodType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getAIXAuthMethodType()
	 * @generated
	 */
	int AIX_AUTH_METHOD_TYPE = 68;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.AIXDesktopType <em>AIX Desktop Type</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.AIXDesktopType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getAIXDesktopType()
	 * @generated
	 */
	int AIX_DESKTOP_TYPE = 69;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.AIXUserRegisteringMethodType <em>AIX User Registering Method Type</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.AIXUserRegisteringMethodType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getAIXUserRegisteringMethodType()
	 * @generated
	 */
	int AIX_USER_REGISTERING_METHOD_TYPE = 70;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.ArchitectureBusType <em>Architecture Bus Type</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.ArchitectureBusType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getArchitectureBusType()
	 * @generated
	 */
	int ARCHITECTURE_BUS_TYPE = 71;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.DefaultWindowsUserGroups <em>Default Windows User Groups</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.DefaultWindowsUserGroups
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getDefaultWindowsUserGroups()
	 * @generated
	 */
	int DEFAULT_WINDOWS_USER_GROUPS = 72;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.EncryptionLevelType <em>Encryption Level Type</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.EncryptionLevelType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getEncryptionLevelType()
	 * @generated
	 */
	int ENCRYPTION_LEVEL_TYPE = 73;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.KernelWidthType <em>Kernel Width Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.KernelWidthType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getKernelWidthType()
	 * @generated
	 */
	int KERNEL_WIDTH_TYPE = 74;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.LinuxServiceStartupTypeType <em>Linux Service Startup Type Type</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.LinuxServiceStartupTypeType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getLinuxServiceStartupTypeType()
	 * @generated
	 */
	int LINUX_SERVICE_STARTUP_TYPE_TYPE = 75;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.LinuxServiceStatusType <em>Linux Service Status Type</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.LinuxServiceStatusType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getLinuxServiceStatusType()
	 * @generated
	 */
	int LINUX_SERVICE_STATUS_TYPE = 76;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemType <em>Operating System Type</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getOperatingSystemType()
	 * @generated
	 */
	int OPERATING_SYSTEM_TYPE = 77;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.RedhatDesktopType <em>Redhat Desktop Type</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.RedhatDesktopType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getRedhatDesktopType()
	 * @generated
	 */
	int REDHAT_DESKTOP_TYPE = 78;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxBootLoaderType <em>Redhat Linux Boot Loader Type</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxBootLoaderType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getRedhatLinuxBootLoaderType()
	 * @generated
	 */
	int REDHAT_LINUX_BOOT_LOADER_TYPE = 79;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxProductTypeType <em>Redhat Linux Product Type Type</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxProductTypeType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getRedhatLinuxProductTypeType()
	 * @generated
	 */
	int REDHAT_LINUX_PRODUCT_TYPE_TYPE = 80;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxServiceStartupTypeType <em>Redhat Linux Service Startup Type Type</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxServiceStartupTypeType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getRedhatLinuxServiceStartupTypeType()
	 * @generated
	 */
	int REDHAT_LINUX_SERVICE_STARTUP_TYPE_TYPE = 81;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxServiceStatusType <em>Redhat Linux Service Status Type</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxServiceStatusType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getRedhatLinuxServiceStatusType()
	 * @generated
	 */
	int REDHAT_LINUX_SERVICE_STATUS_TYPE = 82;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.SELinuxStateType <em>SE Linux State Type</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.SELinuxStateType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getSELinuxStateType()
	 * @generated
	 */
	int SE_LINUX_STATE_TYPE = 83;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.SUSEDesktopType <em>SUSE Desktop Type</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.SUSEDesktopType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getSUSEDesktopType()
	 * @generated
	 */
	int SUSE_DESKTOP_TYPE = 84;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.SUSELinuxBootLoaderType <em>SUSE Linux Boot Loader Type</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.SUSELinuxBootLoaderType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getSUSELinuxBootLoaderType()
	 * @generated
	 */
	int SUSE_LINUX_BOOT_LOADER_TYPE = 85;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.SUSELinuxServiceStartupTypeType <em>SUSE Linux Service Startup Type Type</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.SUSELinuxServiceStartupTypeType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getSUSELinuxServiceStartupTypeType()
	 * @generated
	 */
	int SUSE_LINUX_SERVICE_STARTUP_TYPE_TYPE = 86;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.SUSELinuxServiceStatusType <em>SUSE Linux Service Status Type</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.SUSELinuxServiceStatusType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getSUSELinuxServiceStatusType()
	 * @generated
	 */
	int SUSE_LINUX_SERVICE_STATUS_TYPE = 87;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.TransportLayerProtocolType <em>Transport Layer Protocol Type</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.TransportLayerProtocolType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getTransportLayerProtocolType()
	 * @generated
	 */
	int TRANSPORT_LAYER_PROTOCOL_TYPE = 88;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.WindowsDirectoryType <em>Windows Directory Type</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.WindowsDirectoryType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsDirectoryType()
	 * @generated
	 */
	int WINDOWS_DIRECTORY_TYPE = 89;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.WindowsProductTypeType <em>Windows Product Type Type</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.WindowsProductTypeType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsProductTypeType()
	 * @generated
	 */
	int WINDOWS_PRODUCT_TYPE_TYPE = 90;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.WindowsServiceErrorControlType <em>Windows Service Error Control Type</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.WindowsServiceErrorControlType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsServiceErrorControlType()
	 * @generated
	 */
	int WINDOWS_SERVICE_ERROR_CONTROL_TYPE = 91;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.WindowsServiceStartupType <em>Windows Service Startup Type</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.WindowsServiceStartupType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsServiceStartupType()
	 * @generated
	 */
	int WINDOWS_SERVICE_STARTUP_TYPE = 92;

	/**
	 * The meta object id for the '{@link com.ibm.ccl.soa.deploy.os.WindowsServiceStatusType <em>Windows Service Status Type</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.WindowsServiceStatusType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsServiceStatusType()
	 * @generated
	 */
	int WINDOWS_SERVICE_STATUS_TYPE = 93;

	/**
	 * The meta object id for the '<em>AIX Auth Method Type Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.os.AIXAuthMethodType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getAIXAuthMethodTypeObject()
	 * @generated
	 */
	int AIX_AUTH_METHOD_TYPE_OBJECT = 94;

	/**
	 * The meta object id for the '<em>AIX Desktop Type Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.os.AIXDesktopType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getAIXDesktopTypeObject()
	 * @generated
	 */
	int AIX_DESKTOP_TYPE_OBJECT = 95;

	/**
	 * The meta object id for the '<em>AIX User Registering Method Type Object</em>' data type.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.AIXUserRegisteringMethodType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getAIXUserRegisteringMethodTypeObject()
	 * @generated
	 */
	int AIX_USER_REGISTERING_METHOD_TYPE_OBJECT = 96;

	/**
	 * The meta object id for the '<em>Architecture Bus Type Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.os.ArchitectureBusType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getArchitectureBusTypeObject()
	 * @generated
	 */
	int ARCHITECTURE_BUS_TYPE_OBJECT = 97;

	/**
	 * The meta object id for the '<em>Default Windows User Groups Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.os.DefaultWindowsUserGroups
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getDefaultWindowsUserGroupsObject()
	 * @generated
	 */
	int DEFAULT_WINDOWS_USER_GROUPS_OBJECT = 98;

	/**
	 * The meta object id for the '<em>Encryption Level Type Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.os.EncryptionLevelType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getEncryptionLevelTypeObject()
	 * @generated
	 */
	int ENCRYPTION_LEVEL_TYPE_OBJECT = 99;

	/**
	 * The meta object id for the '<em>Kernel Width Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.KernelWidthType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getKernelWidthTypeObject()
	 * @generated
	 */
	int KERNEL_WIDTH_TYPE_OBJECT = 100;

	/**
	 * The meta object id for the '<em>Linux Service Startup Type Type Object</em>' data type.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.LinuxServiceStartupTypeType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getLinuxServiceStartupTypeTypeObject()
	 * @generated
	 */
	int LINUX_SERVICE_STARTUP_TYPE_TYPE_OBJECT = 101;

	/**
	 * The meta object id for the '<em>Linux Service Status Type Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.os.LinuxServiceStatusType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getLinuxServiceStatusTypeObject()
	 * @generated
	 */
	int LINUX_SERVICE_STATUS_TYPE_OBJECT = 102;

	/**
	 * The meta object id for the '<em>Operating System Type Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getOperatingSystemTypeObject()
	 * @generated
	 */
	int OPERATING_SYSTEM_TYPE_OBJECT = 103;

	/**
	 * The meta object id for the '<em>Redhat Desktop Type Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.os.RedhatDesktopType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getRedhatDesktopTypeObject()
	 * @generated
	 */
	int REDHAT_DESKTOP_TYPE_OBJECT = 104;

	/**
	 * The meta object id for the '<em>Redhat Linux Boot Loader Type Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxBootLoaderType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getRedhatLinuxBootLoaderTypeObject()
	 * @generated
	 */
	int REDHAT_LINUX_BOOT_LOADER_TYPE_OBJECT = 105;

	/**
	 * The meta object id for the '<em>Redhat Linux Product Type Type Object</em>' data type.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxProductTypeType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getRedhatLinuxProductTypeTypeObject()
	 * @generated
	 */
	int REDHAT_LINUX_PRODUCT_TYPE_TYPE_OBJECT = 106;

	/**
	 * The meta object id for the '<em>Redhat Linux Service Startup Type Type Object</em>' data type.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxServiceStartupTypeType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getRedhatLinuxServiceStartupTypeTypeObject()
	 * @generated
	 */
	int REDHAT_LINUX_SERVICE_STARTUP_TYPE_TYPE_OBJECT = 107;

	/**
	 * The meta object id for the '<em>Redhat Linux Service Status Type Object</em>' data type.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxServiceStatusType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getRedhatLinuxServiceStatusTypeObject()
	 * @generated
	 */
	int REDHAT_LINUX_SERVICE_STATUS_TYPE_OBJECT = 108;

	/**
	 * The meta object id for the '<em>SE Linux State Type Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.os.SELinuxStateType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getSELinuxStateTypeObject()
	 * @generated
	 */
	int SE_LINUX_STATE_TYPE_OBJECT = 109;

	/**
	 * The meta object id for the '<em>SUSE Desktop Type Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.os.SUSEDesktopType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getSUSEDesktopTypeObject()
	 * @generated
	 */
	int SUSE_DESKTOP_TYPE_OBJECT = 110;

	/**
	 * The meta object id for the '<em>SUSE Linux Boot Loader Type Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.os.SUSELinuxBootLoaderType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getSUSELinuxBootLoaderTypeObject()
	 * @generated
	 */
	int SUSE_LINUX_BOOT_LOADER_TYPE_OBJECT = 111;

	/**
	 * The meta object id for the '<em>SUSE Linux Service Startup Type Type Object</em>' data type.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.SUSELinuxServiceStartupTypeType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getSUSELinuxServiceStartupTypeTypeObject()
	 * @generated
	 */
	int SUSE_LINUX_SERVICE_STARTUP_TYPE_TYPE_OBJECT = 112;

	/**
	 * The meta object id for the '<em>SUSE Linux Service Status Type Object</em>' data type.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.SUSELinuxServiceStatusType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getSUSELinuxServiceStatusTypeObject()
	 * @generated
	 */
	int SUSE_LINUX_SERVICE_STATUS_TYPE_OBJECT = 113;

	/**
	 * The meta object id for the '<em>TCP Port Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.math.BigInteger
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getTCPPortType()
	 * @generated
	 */
	int TCP_PORT_TYPE = 114;

	/**
	 * The meta object id for the '<em>Transport Layer Protocol Type Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.os.TransportLayerProtocolType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getTransportLayerProtocolTypeObject()
	 * @generated
	 */
	int TRANSPORT_LAYER_PROTOCOL_TYPE_OBJECT = 115;

	/**
	 * The meta object id for the '<em>UDP Port Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.math.BigInteger
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getUDPPortType()
	 * @generated
	 */
	int UDP_PORT_TYPE = 116;

	/**
	 * The meta object id for the '<em>Windows Directory Type Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.os.WindowsDirectoryType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsDirectoryTypeObject()
	 * @generated
	 */
	int WINDOWS_DIRECTORY_TYPE_OBJECT = 117;

	/**
	 * The meta object id for the '<em>Windows Product Type Type Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.os.WindowsProductTypeType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsProductTypeTypeObject()
	 * @generated
	 */
	int WINDOWS_PRODUCT_TYPE_TYPE_OBJECT = 118;

	/**
	 * The meta object id for the '<em>Windows Service Error Control Type Object</em>' data type.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see com.ibm.ccl.soa.deploy.os.WindowsServiceErrorControlType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsServiceErrorControlTypeObject()
	 * @generated
	 */
	int WINDOWS_SERVICE_ERROR_CONTROL_TYPE_OBJECT = 119;

	/**
	 * The meta object id for the '<em>Windows Service Startup Type Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.os.WindowsServiceStartupType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsServiceStartupTypeObject()
	 * @generated
	 */
	int WINDOWS_SERVICE_STARTUP_TYPE_OBJECT = 120;

	/**
	 * The meta object id for the '<em>Windows Service Status Type Object</em>' data type. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see com.ibm.ccl.soa.deploy.os.WindowsServiceStatusType
	 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsServiceStatusTypeObject()
	 * @generated
	 */
	int WINDOWS_SERVICE_STATUS_TYPE_OBJECT = 121;

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.AIXLocalGroup <em>AIX Local Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>AIX Local Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalGroup
	 * @generated
	 */
	EClass getAIXLocalGroup();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalGroup#getGroupDescription <em>Group Description</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Group Description</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalGroup#getGroupDescription()
	 * @see #getAIXLocalGroup()
	 * @generated
	 */
	EAttribute getAIXLocalGroup_GroupDescription();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalGroup#getGroupSid <em>Group Sid</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Group Sid</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalGroup#getGroupSid()
	 * @see #getAIXLocalGroup()
	 * @generated
	 */
	EAttribute getAIXLocalGroup_GroupSid();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.AIXLocalGroupUnit <em>AIX Local Group Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>AIX Local Group Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalGroupUnit
	 * @generated
	 */
	EClass getAIXLocalGroupUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService <em>AIX Local Service</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>AIX Local Service</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalService
	 * @generated
	 */
	EClass getAIXLocalService();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#getActionType <em>Action Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Action Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalService#getActionType()
	 * @see #getAIXLocalService()
	 * @generated
	 */
	EAttribute getAIXLocalService_ActionType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#getExecutablePath <em>Executable Path</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Executable Path</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalService#getExecutablePath()
	 * @see #getAIXLocalService()
	 * @generated
	 */
	EAttribute getAIXLocalService_ExecutablePath();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#getServiceDescription <em>Service Description</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Description</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalService#getServiceDescription()
	 * @see #getAIXLocalService()
	 * @generated
	 */
	EAttribute getAIXLocalService_ServiceDescription();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelEight <em>Startup Run Level Eight</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Startup Run Level Eight</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelEight()
	 * @see #getAIXLocalService()
	 * @generated
	 */
	EAttribute getAIXLocalService_StartupRunLevelEight();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelFive <em>Startup Run Level Five</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Startup Run Level Five</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelFive()
	 * @see #getAIXLocalService()
	 * @generated
	 */
	EAttribute getAIXLocalService_StartupRunLevelFive();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelFour <em>Startup Run Level Four</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Startup Run Level Four</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelFour()
	 * @see #getAIXLocalService()
	 * @generated
	 */
	EAttribute getAIXLocalService_StartupRunLevelFour();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelNine <em>Startup Run Level Nine</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Startup Run Level Nine</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelNine()
	 * @see #getAIXLocalService()
	 * @generated
	 */
	EAttribute getAIXLocalService_StartupRunLevelNine();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelOne <em>Startup Run Level One</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Startup Run Level One</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelOne()
	 * @see #getAIXLocalService()
	 * @generated
	 */
	EAttribute getAIXLocalService_StartupRunLevelOne();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelSeven <em>Startup Run Level Seven</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Startup Run Level Seven</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelSeven()
	 * @see #getAIXLocalService()
	 * @generated
	 */
	EAttribute getAIXLocalService_StartupRunLevelSeven();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelSix <em>Startup Run Level Six</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Startup Run Level Six</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelSix()
	 * @see #getAIXLocalService()
	 * @generated
	 */
	EAttribute getAIXLocalService_StartupRunLevelSix();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelThree <em>Startup Run Level Three</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Startup Run Level Three</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelThree()
	 * @see #getAIXLocalService()
	 * @generated
	 */
	EAttribute getAIXLocalService_StartupRunLevelThree();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelTwo <em>Startup Run Level Two</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Startup Run Level Two</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelTwo()
	 * @see #getAIXLocalService()
	 * @generated
	 */
	EAttribute getAIXLocalService_StartupRunLevelTwo();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelZero <em>Startup Run Level Zero</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Startup Run Level Zero</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalService#isStartupRunLevelZero()
	 * @see #getAIXLocalService()
	 * @generated
	 */
	EAttribute getAIXLocalService_StartupRunLevelZero();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.AIXLocalServiceUnit <em>AIX Local Service Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>AIX Local Service Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalServiceUnit
	 * @generated
	 */
	EClass getAIXLocalServiceUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser <em>AIX Local User</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>AIX Local User</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUser
	 * @generated
	 */
	EClass getAIXLocalUser();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getAccountDescription <em>Account Description</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Account Description</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUser#getAccountDescription()
	 * @see #getAIXLocalUser()
	 * @generated
	 */
	EAttribute getAIXLocalUser_AccountDescription();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isAccountDisabled <em>Account Disabled</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Account Disabled</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUser#isAccountDisabled()
	 * @see #getAIXLocalUser()
	 * @generated
	 */
	EAttribute getAIXLocalUser_AccountDisabled();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getAccountExpirationTime <em>Account Expiration Time</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Account Expiration Time</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUser#getAccountExpirationTime()
	 * @see #getAIXLocalUser()
	 * @generated
	 */
	EAttribute getAIXLocalUser_AccountExpirationTime();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isChangePasswordNextLogon <em>Change Password Next Logon</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Change Password Next Logon</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUser#isChangePasswordNextLogon()
	 * @see #getAIXLocalUser()
	 * @generated
	 */
	EAttribute getAIXLocalUser_ChangePasswordNextLogon();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getFullName <em>Full Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Full Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUser#getFullName()
	 * @see #getAIXLocalUser()
	 * @generated
	 */
	EAttribute getAIXLocalUser_FullName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getHomeDir <em>Home Dir</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Home Dir</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUser#getHomeDir()
	 * @see #getAIXLocalUser()
	 * @generated
	 */
	EAttribute getAIXLocalUser_HomeDir();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isIsAdmin <em>Is Admin</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Admin</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUser#isIsAdmin()
	 * @see #getAIXLocalUser()
	 * @generated
	 */
	EAttribute getAIXLocalUser_IsAdmin();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isLoginPermitted <em>Login Permitted</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Login Permitted</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUser#isLoginPermitted()
	 * @see #getAIXLocalUser()
	 * @generated
	 */
	EAttribute getAIXLocalUser_LoginPermitted();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getLoginRetries <em>Login Retries</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Login Retries</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUser#getLoginRetries()
	 * @see #getAIXLocalUser()
	 * @generated
	 */
	EAttribute getAIXLocalUser_LoginRetries();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getLoginTimes <em>Login Times</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Login Times</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUser#getLoginTimes()
	 * @see #getAIXLocalUser()
	 * @generated
	 */
	EAttribute getAIXLocalUser_LoginTimes();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getMaxCharRepeats <em>Max Char Repeats</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Char Repeats</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUser#getMaxCharRepeats()
	 * @see #getAIXLocalUser()
	 * @generated
	 */
	EAttribute getAIXLocalUser_MaxCharRepeats();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getMaxPasswordAgeInWeeks <em>Max Password Age In Weeks</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Password Age In Weeks</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUser#getMaxPasswordAgeInWeeks()
	 * @see #getAIXLocalUser()
	 * @generated
	 */
	EAttribute getAIXLocalUser_MaxPasswordAgeInWeeks();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getMaxPasswordValidWeeks <em>Max Password Valid Weeks</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Password Valid Weeks</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUser#getMaxPasswordValidWeeks()
	 * @see #getAIXLocalUser()
	 * @generated
	 */
	EAttribute getAIXLocalUser_MaxPasswordValidWeeks();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getMinAlphaCharsInPassword <em>Min Alpha Chars In Password</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Alpha Chars In Password</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUser#getMinAlphaCharsInPassword()
	 * @see #getAIXLocalUser()
	 * @generated
	 */
	EAttribute getAIXLocalUser_MinAlphaCharsInPassword();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getMinDiffChars <em>Min Diff Chars</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Diff Chars</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUser#getMinDiffChars()
	 * @see #getAIXLocalUser()
	 * @generated
	 */
	EAttribute getAIXLocalUser_MinDiffChars();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getMinOtherCharsInPassword <em>Min Other Chars In Password</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Other Chars In Password</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUser#getMinOtherCharsInPassword()
	 * @see #getAIXLocalUser()
	 * @generated
	 */
	EAttribute getAIXLocalUser_MinOtherCharsInPassword();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getMinPasswordAgeInWeeks <em>Min Password Age In Weeks</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Password Age In Weeks</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUser#getMinPasswordAgeInWeeks()
	 * @see #getAIXLocalUser()
	 * @generated
	 */
	EAttribute getAIXLocalUser_MinPasswordAgeInWeeks();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getMinPasswordLength <em>Min Password Length</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min Password Length</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUser#getMinPasswordLength()
	 * @see #getAIXLocalUser()
	 * @generated
	 */
	EAttribute getAIXLocalUser_MinPasswordLength();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getNotReusableNumberOfPasswords <em>Not Reusable Number Of Passwords</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Not Reusable Number Of Passwords</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUser#getNotReusableNumberOfPasswords()
	 * @see #getAIXLocalUser()
	 * @generated
	 */
	EAttribute getAIXLocalUser_NotReusableNumberOfPasswords();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getPassReuseNotAllowedInWeeks <em>Pass Reuse Not Allowed In Weeks</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pass Reuse Not Allowed In Weeks</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUser#getPassReuseNotAllowedInWeeks()
	 * @see #getAIXLocalUser()
	 * @generated
	 */
	EAttribute getAIXLocalUser_PassReuseNotAllowedInWeeks();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getPasswordChangeWarnTime <em>Password Change Warn Time</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password Change Warn Time</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUser#getPasswordChangeWarnTime()
	 * @see #getAIXLocalUser()
	 * @generated
	 */
	EAttribute getAIXLocalUser_PasswordChangeWarnTime();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isPasswordNeverExpires <em>Password Never Expires</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password Never Expires</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUser#isPasswordNeverExpires()
	 * @see #getAIXLocalUser()
	 * @generated
	 */
	EAttribute getAIXLocalUser_PasswordNeverExpires();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getPrimaryAuthMethod <em>Primary Auth Method</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Primary Auth Method</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUser#getPrimaryAuthMethod()
	 * @see #getAIXLocalUser()
	 * @generated
	 */
	EAttribute getAIXLocalUser_PrimaryAuthMethod();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isRemoteLoginIsAllowed <em>Remote Login Is Allowed</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Remote Login Is Allowed</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUser#isRemoteLoginIsAllowed()
	 * @see #getAIXLocalUser()
	 * @generated
	 */
	EAttribute getAIXLocalUser_RemoteLoginIsAllowed();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getSecondaryAuthMethod <em>Secondary Auth Method</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Secondary Auth Method</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUser#getSecondaryAuthMethod()
	 * @see #getAIXLocalUser()
	 * @generated
	 */
	EAttribute getAIXLocalUser_SecondaryAuthMethod();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getShell <em>Shell</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Shell</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUser#getShell()
	 * @see #getAIXLocalUser()
	 * @generated
	 */
	EAttribute getAIXLocalUser_Shell();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getSuGroupsAllowed <em>Su Groups Allowed</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Su Groups Allowed</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUser#getSuGroupsAllowed()
	 * @see #getAIXLocalUser()
	 * @generated
	 */
	EAttribute getAIXLocalUser_SuGroupsAllowed();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isSuIsAllowed <em>Su Is Allowed</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Su Is Allowed</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUser#isSuIsAllowed()
	 * @see #getAIXLocalUser()
	 * @generated
	 */
	EAttribute getAIXLocalUser_SuIsAllowed();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getTimeLastLogin <em>Time Last Login</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Last Login</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUser#getTimeLastLogin()
	 * @see #getAIXLocalUser()
	 * @generated
	 */
	EAttribute getAIXLocalUser_TimeLastLogin();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#isUserCannotChangePassword <em>User Cannot Change Password</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Cannot Change Password</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUser#isUserCannotChangePassword()
	 * @see #getAIXLocalUser()
	 * @generated
	 */
	EAttribute getAIXLocalUser_UserCannotChangePassword();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getUserName <em>User Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUser#getUserName()
	 * @see #getAIXLocalUser()
	 * @generated
	 */
	EAttribute getAIXLocalUser_UserName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getUserRegisteringMethod <em>User Registering Method</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Registering Method</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUser#getUserRegisteringMethod()
	 * @see #getAIXLocalUser()
	 * @generated
	 */
	EAttribute getAIXLocalUser_UserRegisteringMethod();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getUserSid <em>User Sid</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Sid</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUser#getUserSid()
	 * @see #getAIXLocalUser()
	 * @generated
	 */
	EAttribute getAIXLocalUser_UserSid();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUser#getUsuccessfulLoginCount <em>Usuccessful Login Count</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Usuccessful Login Count</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUser#getUsuccessfulLoginCount()
	 * @see #getAIXLocalUser()
	 * @generated
	 */
	EAttribute getAIXLocalUser_UsuccessfulLoginCount();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.AIXLocalUserUnit <em>AIX Local User Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>AIX Local User Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXLocalUserUnit
	 * @generated
	 */
	EClass getAIXLocalUserUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.AIXOperatingSystem <em>AIX Operating System</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>AIX Operating System</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXOperatingSystem
	 * @generated
	 */
	EClass getAIXOperatingSystem();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXOperatingSystem#getDesktop <em>Desktop</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Desktop</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXOperatingSystem#getDesktop()
	 * @see #getAIXOperatingSystem()
	 * @generated
	 */
	EAttribute getAIXOperatingSystem_Desktop();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXOperatingSystem#getInstallDate <em>Install Date</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Install Date</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXOperatingSystem#getInstallDate()
	 * @see #getAIXOperatingSystem()
	 * @generated
	 */
	EAttribute getAIXOperatingSystem_InstallDate();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXOperatingSystem#getKernel <em>Kernel</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kernel</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXOperatingSystem#getKernel()
	 * @see #getAIXOperatingSystem()
	 * @generated
	 */
	EAttribute getAIXOperatingSystem_Kernel();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXOperatingSystem#getLastBootUpTime <em>Last Boot Up Time</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Boot Up Time</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXOperatingSystem#getLastBootUpTime()
	 * @see #getAIXOperatingSystem()
	 * @generated
	 */
	EAttribute getAIXOperatingSystem_LastBootUpTime();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXOperatingSystem#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Owner</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXOperatingSystem#getOwner()
	 * @see #getAIXOperatingSystem()
	 * @generated
	 */
	EAttribute getAIXOperatingSystem_Owner();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.AIXOperatingSystem#isTCB <em>TCB</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>TCB</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXOperatingSystem#isTCB()
	 * @see #getAIXOperatingSystem()
	 * @generated
	 */
	EAttribute getAIXOperatingSystem_TCB();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.AIXOperatingSystemUnit <em>AIX Operating System Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>AIX Operating System Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXOperatingSystemUnit
	 * @generated
	 */
	EClass getAIXOperatingSystemUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.DataFile <em>Data File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data File</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.DataFile
	 * @generated
	 */
	EClass getDataFile();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.DataFileUnit <em>Data File Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data File Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.DataFileUnit
	 * @generated
	 */
	EClass getDataFileUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.Directory <em>Directory</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Directory</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.Directory
	 * @generated
	 */
	EClass getDirectory();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.Directory#getDirectoryPath <em>Directory Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Directory Path</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.Directory#getDirectoryPath()
	 * @see #getDirectory()
	 * @generated
	 */
	EAttribute getDirectory_DirectoryPath();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.DirectoryUnit <em>Directory Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Directory Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.DirectoryUnit
	 * @generated
	 */
	EClass getDirectoryUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.FileSystem <em>File System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File System</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.FileSystem
	 * @generated
	 */
	EClass getFileSystem();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.FileSystem#getAvailableSpace <em>Available Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Available Space</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.FileSystem#getAvailableSpace()
	 * @see #getFileSystem()
	 * @generated
	 */
	EAttribute getFileSystem_AvailableSpace();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.FileSystem#getCapacity <em>Capacity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Capacity</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.FileSystem#getCapacity()
	 * @see #getFileSystem()
	 * @generated
	 */
	EAttribute getFileSystem_Capacity();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.FileSystem#getMountPoint <em>Mount Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mount Point</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.FileSystem#getMountPoint()
	 * @see #getFileSystem()
	 * @generated
	 */
	EAttribute getFileSystem_MountPoint();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.FileSystem#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.FileSystem#getType()
	 * @see #getFileSystem()
	 * @generated
	 */
	EAttribute getFileSystem_Type();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.FileSystemContent <em>File System Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File System Content</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.FileSystemContent
	 * @generated
	 */
	EClass getFileSystemContent();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.FileSystemContent#getFixedPath <em>Fixed Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fixed Path</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.FileSystemContent#getFixedPath()
	 * @see #getFileSystemContent()
	 * @generated
	 */
	EAttribute getFileSystemContent_FixedPath();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.FileSystemContent#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.FileSystemContent#getGroup()
	 * @see #getFileSystemContent()
	 * @generated
	 */
	EAttribute getFileSystemContent_Group();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.FileSystemContent#getLastModified <em>Last Modified</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Modified</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.FileSystemContent#getLastModified()
	 * @see #getFileSystemContent()
	 * @generated
	 */
	EAttribute getFileSystemContent_LastModified();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.FileSystemContent#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Owner</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.FileSystemContent#getOwner()
	 * @see #getFileSystemContent()
	 * @generated
	 */
	EAttribute getFileSystemContent_Owner();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.FileSystemContent#getPermissions <em>Permissions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Permissions</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.FileSystemContent#getPermissions()
	 * @see #getFileSystemContent()
	 * @generated
	 */
	EAttribute getFileSystemContent_Permissions();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.FileSystemContent#getRealFile <em>Real File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Real File</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.FileSystemContent#getRealFile()
	 * @see #getFileSystemContent()
	 * @generated
	 */
	EAttribute getFileSystemContent_RealFile();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.FileSystemContent#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.FileSystemContent#getSize()
	 * @see #getFileSystemContent()
	 * @generated
	 */
	EAttribute getFileSystemContent_Size();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.FileSystemContent#getURI <em>URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>URI</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.FileSystemContent#getURI()
	 * @see #getFileSystemContent()
	 * @generated
	 */
	EAttribute getFileSystemContent_URI();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.FileSystemContentUnit <em>File System Content Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File System Content Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.FileSystemContentUnit
	 * @generated
	 */
	EClass getFileSystemContentUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.FileSystemUnit <em>File System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File System Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.FileSystemUnit
	 * @generated
	 */
	EClass getFileSystemUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalGroup <em>Linux Local Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Linux Local Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxLocalGroup
	 * @generated
	 */
	EClass getLinuxLocalGroup();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalGroup#getGroupDescription <em>Group Description</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Group Description</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxLocalGroup#getGroupDescription()
	 * @see #getLinuxLocalGroup()
	 * @generated
	 */
	EAttribute getLinuxLocalGroup_GroupDescription();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalGroupUnit <em>Linux Local Group Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Linux Local Group Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxLocalGroupUnit
	 * @generated
	 */
	EClass getLinuxLocalGroupUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalService <em>Linux Local Service</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Linux Local Service</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxLocalService
	 * @generated
	 */
	EClass getLinuxLocalService();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalService#getExecutablePath <em>Executable Path</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Executable Path</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxLocalService#getExecutablePath()
	 * @see #getLinuxLocalService()
	 * @generated
	 */
	EAttribute getLinuxLocalService_ExecutablePath();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalService#getServiceAccount <em>Service Account</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Account</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxLocalService#getServiceAccount()
	 * @see #getLinuxLocalService()
	 * @generated
	 */
	EAttribute getLinuxLocalService_ServiceAccount();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalService#getServiceDescription <em>Service Description</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Description</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxLocalService#getServiceDescription()
	 * @see #getLinuxLocalService()
	 * @generated
	 */
	EAttribute getLinuxLocalService_ServiceDescription();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalService#getServiceName <em>Service Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxLocalService#getServiceName()
	 * @see #getLinuxLocalService()
	 * @generated
	 */
	EAttribute getLinuxLocalService_ServiceName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalService#getServiceStatus <em>Service Status</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Status</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxLocalService#getServiceStatus()
	 * @see #getLinuxLocalService()
	 * @generated
	 */
	EAttribute getLinuxLocalService_ServiceStatus();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalService#isStartupRunLevelFive <em>Startup Run Level Five</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Startup Run Level Five</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxLocalService#isStartupRunLevelFive()
	 * @see #getLinuxLocalService()
	 * @generated
	 */
	EAttribute getLinuxLocalService_StartupRunLevelFive();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalService#isStartupRunLevelFour <em>Startup Run Level Four</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Startup Run Level Four</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxLocalService#isStartupRunLevelFour()
	 * @see #getLinuxLocalService()
	 * @generated
	 */
	EAttribute getLinuxLocalService_StartupRunLevelFour();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalService#isStartupRunLevelOne <em>Startup Run Level One</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Startup Run Level One</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxLocalService#isStartupRunLevelOne()
	 * @see #getLinuxLocalService()
	 * @generated
	 */
	EAttribute getLinuxLocalService_StartupRunLevelOne();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalService#isStartupRunLevelSix <em>Startup Run Level Six</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Startup Run Level Six</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxLocalService#isStartupRunLevelSix()
	 * @see #getLinuxLocalService()
	 * @generated
	 */
	EAttribute getLinuxLocalService_StartupRunLevelSix();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalService#isStartupRunLevelThree <em>Startup Run Level Three</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Startup Run Level Three</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxLocalService#isStartupRunLevelThree()
	 * @see #getLinuxLocalService()
	 * @generated
	 */
	EAttribute getLinuxLocalService_StartupRunLevelThree();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalService#isStartupRunLevelTwo <em>Startup Run Level Two</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Startup Run Level Two</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxLocalService#isStartupRunLevelTwo()
	 * @see #getLinuxLocalService()
	 * @generated
	 */
	EAttribute getLinuxLocalService_StartupRunLevelTwo();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalService#isStartupRunLevelZero <em>Startup Run Level Zero</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Startup Run Level Zero</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxLocalService#isStartupRunLevelZero()
	 * @see #getLinuxLocalService()
	 * @generated
	 */
	EAttribute getLinuxLocalService_StartupRunLevelZero();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalService#getStartupType <em>Startup Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Startup Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxLocalService#getStartupType()
	 * @see #getLinuxLocalService()
	 * @generated
	 */
	EAttribute getLinuxLocalService_StartupType();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalServiceUnit <em>Linux Local Service Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Linux Local Service Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxLocalServiceUnit
	 * @generated
	 */
	EClass getLinuxLocalServiceUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser <em>Linux Local User</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Linux Local User</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxLocalUser
	 * @generated
	 */
	EClass getLinuxLocalUser();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser#getAccountDescription <em>Account Description</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Account Description</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxLocalUser#getAccountDescription()
	 * @see #getLinuxLocalUser()
	 * @generated
	 */
	EAttribute getLinuxLocalUser_AccountDescription();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser#isAccountDisabled <em>Account Disabled</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Account Disabled</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxLocalUser#isAccountDisabled()
	 * @see #getLinuxLocalUser()
	 * @generated
	 */
	EAttribute getLinuxLocalUser_AccountDisabled();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser#isChangePasswordNextLogon <em>Change Password Next Logon</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Change Password Next Logon</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxLocalUser#isChangePasswordNextLogon()
	 * @see #getLinuxLocalUser()
	 * @generated
	 */
	EAttribute getLinuxLocalUser_ChangePasswordNextLogon();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser#getFullName <em>Full Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Full Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxLocalUser#getFullName()
	 * @see #getLinuxLocalUser()
	 * @generated
	 */
	EAttribute getLinuxLocalUser_FullName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser#getHomeDir <em>Home Dir</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Home Dir</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxLocalUser#getHomeDir()
	 * @see #getLinuxLocalUser()
	 * @generated
	 */
	EAttribute getLinuxLocalUser_HomeDir();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser#isPasswordNeverExpires <em>Password Never Expires</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password Never Expires</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxLocalUser#isPasswordNeverExpires()
	 * @see #getLinuxLocalUser()
	 * @generated
	 */
	EAttribute getLinuxLocalUser_PasswordNeverExpires();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser#getShell <em>Shell</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Shell</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxLocalUser#getShell()
	 * @see #getLinuxLocalUser()
	 * @generated
	 */
	EAttribute getLinuxLocalUser_Shell();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser#isUserCannotChangePassword <em>User Cannot Change Password</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Cannot Change Password</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxLocalUser#isUserCannotChangePassword()
	 * @see #getLinuxLocalUser()
	 * @generated
	 */
	EAttribute getLinuxLocalUser_UserCannotChangePassword();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUser#getUserName <em>User Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxLocalUser#getUserName()
	 * @see #getLinuxLocalUser()
	 * @generated
	 */
	EAttribute getLinuxLocalUser_UserName();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.LinuxLocalUserUnit <em>Linux Local User Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Linux Local User Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxLocalUserUnit
	 * @generated
	 */
	EClass getLinuxLocalUserUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.LinuxOperatingSystem <em>Linux Operating System</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Linux Operating System</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxOperatingSystem
	 * @generated
	 */
	EClass getLinuxOperatingSystem();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.LinuxOperatingSystem#getKernelRelease <em>Kernel Release</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kernel Release</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxOperatingSystem#getKernelRelease()
	 * @see #getLinuxOperatingSystem()
	 * @generated
	 */
	EAttribute getLinuxOperatingSystem_KernelRelease();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.LinuxOperatingSystemUnit <em>Linux Operating System Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Linux Operating System Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxOperatingSystemUnit
	 * @generated
	 */
	EClass getLinuxOperatingSystemUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.LocalFileSystem <em>Local File System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local File System</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LocalFileSystem
	 * @generated
	 */
	EClass getLocalFileSystem();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.LocalFileSystemUnit <em>Local File System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local File System Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LocalFileSystemUnit
	 * @generated
	 */
	EClass getLocalFileSystemUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.NFSFileSystem <em>NFS File System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>NFS File System</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.NFSFileSystem
	 * @generated
	 */
	EClass getNFSFileSystem();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.NFSFileSystemUnit <em>NFS File System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>NFS File System Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.NFSFileSystemUnit
	 * @generated
	 */
	EClass getNFSFileSystemUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.OpenVmsFileSystem <em>Open Vms File System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Open Vms File System</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OpenVmsFileSystem
	 * @generated
	 */
	EClass getOpenVmsFileSystem();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.OpenVmsFileSystemUnit <em>Open Vms File System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Open Vms File System Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OpenVmsFileSystemUnit
	 * @generated
	 */
	EClass getOpenVmsFileSystemUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.OperatingSystem <em>Operating System</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operating System</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystem
	 * @generated
	 */
	EClass getOperatingSystem();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getFqdn <em>Fqdn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fqdn</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystem#getFqdn()
	 * @see #getOperatingSystem()
	 * @generated
	 */
	EAttribute getOperatingSystem_Fqdn();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getHostname <em>Hostname</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hostname</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystem#getHostname()
	 * @see #getOperatingSystem()
	 * @generated
	 */
	EAttribute getOperatingSystem_Hostname();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getKernelArchitecture <em>Kernel Architecture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kernel Architecture</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystem#getKernelArchitecture()
	 * @see #getOperatingSystem()
	 * @generated
	 */
	EAttribute getOperatingSystem_KernelArchitecture();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getKernelVersion <em>Kernel Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kernel Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystem#getKernelVersion()
	 * @see #getOperatingSystem()
	 * @generated
	 */
	EAttribute getOperatingSystem_KernelVersion();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getKernelWidth <em>Kernel Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kernel Width</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystem#getKernelWidth()
	 * @see #getOperatingSystem()
	 * @generated
	 */
	EAttribute getOperatingSystem_KernelWidth();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getLocale <em>Locale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Locale</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystem#getLocale()
	 * @see #getOperatingSystem()
	 * @generated
	 */
	EAttribute getOperatingSystem_Locale();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getManufacturer <em>Manufacturer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Manufacturer</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystem#getManufacturer()
	 * @see #getOperatingSystem()
	 * @generated
	 */
	EAttribute getOperatingSystem_Manufacturer();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getOsDistribution <em>Os Distribution</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Os Distribution</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystem#getOsDistribution()
	 * @see #getOperatingSystem()
	 * @generated
	 */
	EAttribute getOperatingSystem_OsDistribution();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getOsServicepack <em>Os Servicepack</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Os Servicepack</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystem#getOsServicepack()
	 * @see #getOperatingSystem()
	 * @generated
	 */
	EAttribute getOperatingSystem_OsServicepack();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getOsType <em>Os Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Os Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystem#getOsType()
	 * @see #getOperatingSystem()
	 * @generated
	 */
	EAttribute getOperatingSystem_OsType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getOsVersion <em>Os Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Os Version</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystem#getOsVersion()
	 * @see #getOperatingSystem()
	 * @generated
	 */
	EAttribute getOperatingSystem_OsVersion();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.OperatingSystem#getTimeZone <em>Time Zone</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Zone</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystem#getTimeZone()
	 * @see #getOperatingSystem()
	 * @generated
	 */
	EAttribute getOperatingSystem_TimeZone();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot <em>Operating System Root</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operating System Root</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot
	 * @generated
	 */
	EClass getOperatingSystemRoot();

	/**
	 * Returns the meta object for the attribute list '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getMixed()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EAttribute getOperatingSystemRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getXMLNSPrefixMap()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getXSISchemaLocation()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityAixLocalGroup <em>Capability Aix Local Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Aix Local Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityAixLocalGroup()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilityAixLocalGroup();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityAixLocalService <em>Capability Aix Local Service</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Aix Local Service</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityAixLocalService()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilityAixLocalService();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityAixLocalUser <em>Capability Aix Local User</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Aix Local User</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityAixLocalUser()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilityAixLocalUser();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityAixOperatingSystem <em>Capability Aix Operating System</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Aix Operating System</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityAixOperatingSystem()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilityAixOperatingSystem();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityDataFile <em>Capability Data File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Data File</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityDataFile()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilityDataFile();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityDirectory <em>Capability Directory</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Directory</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityDirectory()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilityDirectory();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityFileSystem <em>Capability File System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability File System</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityFileSystem()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilityFileSystem();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityFileSystemContent <em>Capability File System Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability File System Content</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityFileSystemContent()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilityFileSystemContent();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityLinuxLocalGroup <em>Capability Linux Local Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Linux Local Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityLinuxLocalGroup()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilityLinuxLocalGroup();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityLinuxLocalService <em>Capability Linux Local Service</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Linux Local Service</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityLinuxLocalService()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilityLinuxLocalService();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityLinuxLocalUser <em>Capability Linux Local User</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Linux Local User</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityLinuxLocalUser()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilityLinuxLocalUser();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityLinuxOperatingSystem <em>Capability Linux Operating System</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Linux Operating System</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityLinuxOperatingSystem()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilityLinuxOperatingSystem();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityLocalFileSystem <em>Capability Local File System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Local File System</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityLocalFileSystem()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilityLocalFileSystem();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityNFSFileSystem <em>Capability NFS File System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability NFS File System</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityNFSFileSystem()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilityNFSFileSystem();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityOpenVmsFileSystem <em>Capability Open Vms File System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Open Vms File System</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityOpenVmsFileSystem()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilityOpenVmsFileSystem();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityOperatingSystem <em>Capability Operating System</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Operating System</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityOperatingSystem()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilityOperatingSystem();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityPort <em>Capability Port</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Port</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityPort()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilityPort();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityPortConsumer <em>Capability Port Consumer</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Port Consumer</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityPortConsumer()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilityPortConsumer();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityRedhatLinuxLocalGroup <em>Capability Redhat Linux Local Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Redhat Linux Local Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityRedhatLinuxLocalGroup()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilityRedhatLinuxLocalGroup();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityRedhatLinuxLocalService <em>Capability Redhat Linux Local Service</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Redhat Linux Local Service</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityRedhatLinuxLocalService()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilityRedhatLinuxLocalService();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityRedhatLinuxLocalUser <em>Capability Redhat Linux Local User</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Redhat Linux Local User</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityRedhatLinuxLocalUser()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilityRedhatLinuxLocalUser();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityRedhatLinuxOperatingSystem <em>Capability Redhat Linux Operating System</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Redhat Linux Operating System</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityRedhatLinuxOperatingSystem()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilityRedhatLinuxOperatingSystem();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityRemoteFileSystem <em>Capability Remote File System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Remote File System</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityRemoteFileSystem()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilityRemoteFileSystem();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilitySMBFileSystem <em>Capability SMB File System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability SMB File System</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilitySMBFileSystem()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilitySMBFileSystem();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilitySolarisFileSystem <em>Capability Solaris File System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Solaris File System</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilitySolarisFileSystem()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilitySolarisFileSystem();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilitySuseLinuxLocalGroup <em>Capability Suse Linux Local Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Suse Linux Local Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilitySuseLinuxLocalGroup()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilitySuseLinuxLocalGroup();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilitySuseLinuxLocalService <em>Capability Suse Linux Local Service</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Suse Linux Local Service</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilitySuseLinuxLocalService()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilitySuseLinuxLocalService();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilitySuseLinuxLocalUser <em>Capability Suse Linux Local User</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Suse Linux Local User</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilitySuseLinuxLocalUser()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilitySuseLinuxLocalUser();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilitySuseLinuxOperatingSystem <em>Capability Suse Linux Operating System</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Suse Linux Operating System</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilitySuseLinuxOperatingSystem()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilitySuseLinuxOperatingSystem();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityUnixDirectory <em>Capability Unix Directory</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Unix Directory</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityUnixDirectory()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilityUnixDirectory();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityUnixFileSystem <em>Capability Unix File System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Unix File System</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityUnixFileSystem()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilityUnixFileSystem();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityUser <em>Capability User</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability User</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityUser()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilityUser();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityUserGroup <em>Capability User Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability User Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityUserGroup()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilityUserGroup();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityWindowsDirectory <em>Capability Windows Directory</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Windows Directory</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityWindowsDirectory()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilityWindowsDirectory();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityWindowsFileSystem <em>Capability Windows File System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Windows File System</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityWindowsFileSystem()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilityWindowsFileSystem();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityWindowsLocalGroup <em>Capability Windows Local Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Windows Local Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityWindowsLocalGroup()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilityWindowsLocalGroup();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityWindowsLocalService <em>Capability Windows Local Service</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Windows Local Service</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityWindowsLocalService()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilityWindowsLocalService();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityWindowsLocalUser <em>Capability Windows Local User</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Windows Local User</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityWindowsLocalUser()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilityWindowsLocalUser();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityWindowsOperatingSystem <em>Capability Windows Operating System</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Capability Windows Operating System</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getCapabilityWindowsOperatingSystem()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_CapabilityWindowsOperatingSystem();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitAixLocalGroup <em>Unit Aix Local Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Aix Local Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitAixLocalGroup()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_UnitAixLocalGroup();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitAixLocalServiceUnit <em>Unit Aix Local Service Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Aix Local Service Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitAixLocalServiceUnit()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_UnitAixLocalServiceUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitAixLocalUser <em>Unit Aix Local User</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Aix Local User</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitAixLocalUser()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_UnitAixLocalUser();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitAixOperatingSystemUnit <em>Unit Aix Operating System Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Aix Operating System Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitAixOperatingSystemUnit()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_UnitAixOperatingSystemUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitDataFileUnit <em>Unit Data File Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Data File Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitDataFileUnit()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_UnitDataFileUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitDirectoryUnit <em>Unit Directory Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Directory Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitDirectoryUnit()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_UnitDirectoryUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitFileSystemContentUnit <em>Unit File System Content Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit File System Content Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitFileSystemContentUnit()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_UnitFileSystemContentUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitFileSystemUnit <em>Unit File System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit File System Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitFileSystemUnit()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_UnitFileSystemUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitLinuxLocalGroup <em>Unit Linux Local Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Linux Local Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitLinuxLocalGroup()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_UnitLinuxLocalGroup();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitLinuxLocalServiceUnit <em>Unit Linux Local Service Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Linux Local Service Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitLinuxLocalServiceUnit()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_UnitLinuxLocalServiceUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitLinuxLocalUser <em>Unit Linux Local User</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Linux Local User</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitLinuxLocalUser()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_UnitLinuxLocalUser();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitLinuxOperatingSystemUnit <em>Unit Linux Operating System Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Linux Operating System Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitLinuxOperatingSystemUnit()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_UnitLinuxOperatingSystemUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitLocalFileSystemUnit <em>Unit Local File System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Local File System Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitLocalFileSystemUnit()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_UnitLocalFileSystemUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitNFSFileSystemUnit <em>Unit NFS File System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit NFS File System Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitNFSFileSystemUnit()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_UnitNFSFileSystemUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitOpenVmsFileSystemUnit <em>Unit Open Vms File System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Open Vms File System Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitOpenVmsFileSystemUnit()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_UnitOpenVmsFileSystemUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitOperatingSystemUnit <em>Unit Operating System Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Operating System Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitOperatingSystemUnit()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_UnitOperatingSystemUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitPortConfigUnit <em>Unit Port Config Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Port Config Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitPortConfigUnit()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_UnitPortConfigUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitRemoteFileSystemUnit <em>Unit Remote File System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Remote File System Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitRemoteFileSystemUnit()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_UnitRemoteFileSystemUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitSMBFileSystemUnit <em>Unit SMB File System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit SMB File System Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitSMBFileSystemUnit()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_UnitSMBFileSystemUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitSolarisFileSystemUnit <em>Unit Solaris File System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Solaris File System Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitSolarisFileSystemUnit()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_UnitSolarisFileSystemUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitUnixFileSystemUnit <em>Unit Unix File System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Unix File System Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitUnixFileSystemUnit()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_UnitUnixFileSystemUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitUser <em>Unit User</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit User</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitUser()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_UnitUser();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitUserGroup <em>Unit User Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit User Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitUserGroup()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_UnitUserGroup();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitWindowsFileSystemUnit <em>Unit Windows File System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Windows File System Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitWindowsFileSystemUnit()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_UnitWindowsFileSystemUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitWindowsLocalGroup <em>Unit Windows Local Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Windows Local Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitWindowsLocalGroup()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_UnitWindowsLocalGroup();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitWindowsLocalServiceUnit <em>Unit Windows Local Service Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Windows Local Service Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitWindowsLocalServiceUnit()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_UnitWindowsLocalServiceUnit();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitWindowsLocalUser <em>Unit Windows Local User</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Windows Local User</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitWindowsLocalUser()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_UnitWindowsLocalUser();

	/**
	 * Returns the meta object for the containment reference '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitWindowsOperatingSystemUnit <em>Unit Windows Operating System Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit Windows Operating System Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemRoot#getUnitWindowsOperatingSystemUnit()
	 * @see #getOperatingSystemRoot()
	 * @generated
	 */
	EReference getOperatingSystemRoot_UnitWindowsOperatingSystemUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemUnit <em>Operating System Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operating System Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemUnit
	 * @generated
	 */
	EClass getOperatingSystemUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.Port <em>Port</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.Port#getApplicationLayerProtocol <em>Application Layer Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Application Layer Protocol</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.Port#getApplicationLayerProtocol()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_ApplicationLayerProtocol();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.Port#getIpAddressOrHostname <em>Ip Address Or Hostname</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ip Address Or Hostname</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.Port#getIpAddressOrHostname()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_IpAddressOrHostname();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.Port#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.Port#getPort()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_Port();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.Port#getPortName <em>Port Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.Port#getPortName()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_PortName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.Port#getTransportLayerProtocol <em>Transport Layer Protocol</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transport Layer Protocol</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.Port#getTransportLayerProtocol()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_TransportLayerProtocol();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.PortConfigUnit <em>Port Config Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port Config Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.PortConfigUnit
	 * @generated
	 */
	EClass getPortConfigUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.PortConsumer <em>Port Consumer</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port Consumer</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.PortConsumer
	 * @generated
	 */
	EClass getPortConsumer();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalGroup <em>Redhat Linux Local Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Redhat Linux Local Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalGroup
	 * @generated
	 */
	EClass getRedhatLinuxLocalGroup();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalGroup#getGroupSid <em>Group Sid</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Group Sid</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalGroup#getGroupSid()
	 * @see #getRedhatLinuxLocalGroup()
	 * @generated
	 */
	EAttribute getRedhatLinuxLocalGroup_GroupSid();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalService <em>Redhat Linux Local Service</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Redhat Linux Local Service</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalService
	 * @generated
	 */
	EClass getRedhatLinuxLocalService();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser <em>Redhat Linux Local User</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Redhat Linux Local User</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser
	 * @generated
	 */
	EClass getRedhatLinuxLocalUser();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser#getAccountDisableAfterDays <em>Account Disable After Days</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Account Disable After Days</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser#getAccountDisableAfterDays()
	 * @see #getRedhatLinuxLocalUser()
	 * @generated
	 */
	EAttribute getRedhatLinuxLocalUser_AccountDisableAfterDays();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser#getAccountDisableDate <em>Account Disable Date</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Account Disable Date</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser#getAccountDisableDate()
	 * @see #getRedhatLinuxLocalUser()
	 * @generated
	 */
	EAttribute getRedhatLinuxLocalUser_AccountDisableDate();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser#getDaysBeforePasswordMayChange <em>Days Before Password May Change</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Days Before Password May Change</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser#getDaysBeforePasswordMayChange()
	 * @see #getRedhatLinuxLocalUser()
	 * @generated
	 */
	EAttribute getRedhatLinuxLocalUser_DaysBeforePasswordMayChange();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser#getLastPasswordChange <em>Last Password Change</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Password Change</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser#getLastPasswordChange()
	 * @see #getRedhatLinuxLocalUser()
	 * @generated
	 */
	EAttribute getRedhatLinuxLocalUser_LastPasswordChange();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser#getPasswordExpireAfterDays <em>Password Expire After Days</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password Expire After Days</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser#getPasswordExpireAfterDays()
	 * @see #getRedhatLinuxLocalUser()
	 * @generated
	 */
	EAttribute getRedhatLinuxLocalUser_PasswordExpireAfterDays();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser#getPasswordExpireWarningDays <em>Password Expire Warning Days</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password Expire Warning Days</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser#getPasswordExpireWarningDays()
	 * @see #getRedhatLinuxLocalUser()
	 * @generated
	 */
	EAttribute getRedhatLinuxLocalUser_PasswordExpireWarningDays();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser#getUserSid <em>User Sid</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Sid</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxLocalUser#getUserSid()
	 * @see #getRedhatLinuxLocalUser()
	 * @generated
	 */
	EAttribute getRedhatLinuxLocalUser_UserSid();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem <em>Redhat Linux Operating System</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Redhat Linux Operating System</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem
	 * @generated
	 */
	EClass getRedhatLinuxOperatingSystem();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem#getBootLoader <em>Boot Loader</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Boot Loader</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem#getBootLoader()
	 * @see #getRedhatLinuxOperatingSystem()
	 * @generated
	 */
	EAttribute getRedhatLinuxOperatingSystem_BootLoader();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem#getDesktop <em>Desktop</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Desktop</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem#getDesktop()
	 * @see #getRedhatLinuxOperatingSystem()
	 * @generated
	 */
	EAttribute getRedhatLinuxOperatingSystem_Desktop();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem#getInstallDate <em>Install Date</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Install Date</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem#getInstallDate()
	 * @see #getRedhatLinuxOperatingSystem()
	 * @generated
	 */
	EAttribute getRedhatLinuxOperatingSystem_InstallDate();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem#getLastBootUpTime <em>Last Boot Up Time</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Boot Up Time</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem#getLastBootUpTime()
	 * @see #getRedhatLinuxOperatingSystem()
	 * @generated
	 */
	EAttribute getRedhatLinuxOperatingSystem_LastBootUpTime();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Owner</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem#getOwner()
	 * @see #getRedhatLinuxOperatingSystem()
	 * @generated
	 */
	EAttribute getRedhatLinuxOperatingSystem_Owner();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem#getProductType <em>Product Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Product Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem#getProductType()
	 * @see #getRedhatLinuxOperatingSystem()
	 * @generated
	 */
	EAttribute getRedhatLinuxOperatingSystem_ProductType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem#getSELinuxState <em>SE Linux State</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SE Linux State</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem#getSELinuxState()
	 * @see #getRedhatLinuxOperatingSystem()
	 * @generated
	 */
	EAttribute getRedhatLinuxOperatingSystem_SELinuxState();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.RemoteFileSystem <em>Remote File System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remote File System</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.RemoteFileSystem
	 * @generated
	 */
	EClass getRemoteFileSystem();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.RemoteFileSystem#getExportName <em>Export Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Export Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.RemoteFileSystem#getExportName()
	 * @see #getRemoteFileSystem()
	 * @generated
	 */
	EAttribute getRemoteFileSystem_ExportName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.RemoteFileSystem#getServerName <em>Server Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Server Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.RemoteFileSystem#getServerName()
	 * @see #getRemoteFileSystem()
	 * @generated
	 */
	EAttribute getRemoteFileSystem_ServerName();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.RemoteFileSystemUnit <em>Remote File System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remote File System Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.RemoteFileSystemUnit
	 * @generated
	 */
	EClass getRemoteFileSystemUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.SMBFileSystem <em>SMB File System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SMB File System</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.SMBFileSystem
	 * @generated
	 */
	EClass getSMBFileSystem();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.SMBFileSystemUnit <em>SMB File System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SMB File System Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.SMBFileSystemUnit
	 * @generated
	 */
	EClass getSMBFileSystemUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.SolarisFileSystem <em>Solaris File System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Solaris File System</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.SolarisFileSystem
	 * @generated
	 */
	EClass getSolarisFileSystem();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.SolarisFileSystemUnit <em>Solaris File System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Solaris File System Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.SolarisFileSystemUnit
	 * @generated
	 */
	EClass getSolarisFileSystemUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.SUSELinuxLocalGroup <em>SUSE Linux Local Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>SUSE Linux Local Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.SUSELinuxLocalGroup
	 * @generated
	 */
	EClass getSUSELinuxLocalGroup();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.SUSELinuxLocalGroup#getGroupId <em>Group Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Group Id</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.SUSELinuxLocalGroup#getGroupId()
	 * @see #getSUSELinuxLocalGroup()
	 * @generated
	 */
	EAttribute getSUSELinuxLocalGroup_GroupId();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.SUSELinuxLocalService <em>SUSE Linux Local Service</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>SUSE Linux Local Service</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.SUSELinuxLocalService
	 * @generated
	 */
	EClass getSUSELinuxLocalService();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.SUSELinuxLocalUser <em>SUSE Linux Local User</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>SUSE Linux Local User</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.SUSELinuxLocalUser
	 * @generated
	 */
	EClass getSUSELinuxLocalUser();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.SUSELinuxOperatingSystem <em>SUSE Linux Operating System</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>SUSE Linux Operating System</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.SUSELinuxOperatingSystem
	 * @generated
	 */
	EClass getSUSELinuxOperatingSystem();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.SUSELinuxOperatingSystem#getBootLoader <em>Boot Loader</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Boot Loader</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.SUSELinuxOperatingSystem#getBootLoader()
	 * @see #getSUSELinuxOperatingSystem()
	 * @generated
	 */
	EAttribute getSUSELinuxOperatingSystem_BootLoader();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.SUSELinuxOperatingSystem#getDesktop <em>Desktop</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Desktop</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.SUSELinuxOperatingSystem#getDesktop()
	 * @see #getSUSELinuxOperatingSystem()
	 * @generated
	 */
	EAttribute getSUSELinuxOperatingSystem_Desktop();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.SUSELinuxOperatingSystem#getLastBootUpDate <em>Last Boot Up Date</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Boot Up Date</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.SUSELinuxOperatingSystem#getLastBootUpDate()
	 * @see #getSUSELinuxOperatingSystem()
	 * @generated
	 */
	EAttribute getSUSELinuxOperatingSystem_LastBootUpDate();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.UnixDirectory <em>Unix Directory</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unix Directory</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.UnixDirectory
	 * @generated
	 */
	EClass getUnixDirectory();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.UnixFileSystem <em>Unix File System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unix File System</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.UnixFileSystem
	 * @generated
	 */
	EClass getUnixFileSystem();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.UnixFileSystemUnit <em>Unix File System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unix File System Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.UnixFileSystemUnit
	 * @generated
	 */
	EClass getUnixFileSystemUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.User <em>User</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>User</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.User
	 * @generated
	 */
	EClass getUser();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.User#getUserId <em>User Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Id</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.User#getUserId()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_UserId();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.User#getUserPassword <em>User Password</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Password</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.User#getUserPassword()
	 * @see #getUser()
	 * @generated
	 */
	EAttribute getUser_UserPassword();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.UserGroup <em>User Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.UserGroup
	 * @generated
	 */
	EClass getUserGroup();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.UserGroup#getGroupName <em>Group Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Group Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.UserGroup#getGroupName()
	 * @see #getUserGroup()
	 * @generated
	 */
	EAttribute getUserGroup_GroupName();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.UserGroupUnit <em>User Group Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Group Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.UserGroupUnit
	 * @generated
	 */
	EClass getUserGroupUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.UserUnit <em>User Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>User Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.UserUnit
	 * @generated
	 */
	EClass getUserUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.WindowsDirectory <em>Windows Directory</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Windows Directory</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsDirectory
	 * @generated
	 */
	EClass getWindowsDirectory();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.WindowsFileSystem <em>Windows File System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Windows File System</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsFileSystem
	 * @generated
	 */
	EClass getWindowsFileSystem();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.WindowsFileSystemUnit <em>Windows File System Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Windows File System Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsFileSystemUnit
	 * @generated
	 */
	EClass getWindowsFileSystemUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalGroup <em>Windows Local Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Windows Local Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalGroup
	 * @generated
	 */
	EClass getWindowsLocalGroup();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalGroup#getDescription1 <em>Description1</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description1</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalGroup#getDescription1()
	 * @see #getWindowsLocalGroup()
	 * @generated
	 */
	EAttribute getWindowsLocalGroup_Description1();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalGroup#getGroupSid <em>Group Sid</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Group Sid</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalGroup#getGroupSid()
	 * @see #getWindowsLocalGroup()
	 * @generated
	 */
	EAttribute getWindowsLocalGroup_GroupSid();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalGroupUnit <em>Windows Local Group Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Windows Local Group Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalGroupUnit
	 * @generated
	 */
	EClass getWindowsLocalGroupUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService <em>Windows Local Service</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Windows Local Service</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalService
	 * @generated
	 */
	EClass getWindowsLocalService();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getDependantComponents <em>Dependant Components</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Dependant Components</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalService#getDependantComponents()
	 * @see #getWindowsLocalService()
	 * @generated
	 */
	EAttribute getWindowsLocalService_DependantComponents();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getErrorControl <em>Error Control</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Error Control</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalService#getErrorControl()
	 * @see #getWindowsLocalService()
	 * @generated
	 */
	EAttribute getWindowsLocalService_ErrorControl();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getExecutablePath <em>Executable Path</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Executable Path</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalService#getExecutablePath()
	 * @see #getWindowsLocalService()
	 * @generated
	 */
	EAttribute getWindowsLocalService_ExecutablePath();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#isLogOnAsSystem <em>Log On As System</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Log On As System</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalService#isLogOnAsSystem()
	 * @see #getWindowsLocalService()
	 * @generated
	 */
	EAttribute getWindowsLocalService_LogOnAsSystem();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getRunProgram <em>Run Program</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Run Program</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalService#getRunProgram()
	 * @see #getWindowsLocalService()
	 * @generated
	 */
	EAttribute getWindowsLocalService_RunProgram();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getServiceAccount <em>Service Account</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Account</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalService#getServiceAccount()
	 * @see #getWindowsLocalService()
	 * @generated
	 */
	EAttribute getWindowsLocalService_ServiceAccount();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getServiceAccountPassword <em>Service Account Password</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Account Password</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalService#getServiceAccountPassword()
	 * @see #getWindowsLocalService()
	 * @generated
	 */
	EAttribute getWindowsLocalService_ServiceAccountPassword();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getServiceDependencies <em>Service Dependencies</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Dependencies</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalService#getServiceDependencies()
	 * @see #getWindowsLocalService()
	 * @generated
	 */
	EAttribute getWindowsLocalService_ServiceDependencies();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getServiceDescription <em>Service Description</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Description</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalService#getServiceDescription()
	 * @see #getWindowsLocalService()
	 * @generated
	 */
	EAttribute getWindowsLocalService_ServiceDescription();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getServiceDisplayName <em>Service Display Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Display Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalService#getServiceDisplayName()
	 * @see #getWindowsLocalService()
	 * @generated
	 */
	EAttribute getWindowsLocalService_ServiceDisplayName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getServiceName <em>Service Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalService#getServiceName()
	 * @see #getWindowsLocalService()
	 * @generated
	 */
	EAttribute getWindowsLocalService_ServiceName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getServiceStatus <em>Service Status</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Status</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalService#getServiceStatus()
	 * @see #getWindowsLocalService()
	 * @generated
	 */
	EAttribute getWindowsLocalService_ServiceStatus();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getStartParams <em>Start Params</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Params</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalService#getStartParams()
	 * @see #getWindowsLocalService()
	 * @generated
	 */
	EAttribute getWindowsLocalService_StartParams();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalService#getStartupType <em>Startup Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Startup Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalService#getStartupType()
	 * @see #getWindowsLocalService()
	 * @generated
	 */
	EAttribute getWindowsLocalService_StartupType();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalServiceUnit <em>Windows Local Service Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Windows Local Service Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalServiceUnit
	 * @generated
	 */
	EClass getWindowsLocalServiceUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser <em>Windows Local User</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Windows Local User</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalUser
	 * @generated
	 */
	EClass getWindowsLocalUser();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#getAccountDescription <em>Account Description</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Account Description</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalUser#getAccountDescription()
	 * @see #getWindowsLocalUser()
	 * @generated
	 */
	EAttribute getWindowsLocalUser_AccountDescription();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#isAccountDisabled <em>Account Disabled</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Account Disabled</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalUser#isAccountDisabled()
	 * @see #getWindowsLocalUser()
	 * @generated
	 */
	EAttribute getWindowsLocalUser_AccountDisabled();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#isAccountLocked <em>Account Locked</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Account Locked</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalUser#isAccountLocked()
	 * @see #getWindowsLocalUser()
	 * @generated
	 */
	EAttribute getWindowsLocalUser_AccountLocked();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#isChangePasswordNextLogon <em>Change Password Next Logon</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Change Password Next Logon</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalUser#isChangePasswordNextLogon()
	 * @see #getWindowsLocalUser()
	 * @generated
	 */
	EAttribute getWindowsLocalUser_ChangePasswordNextLogon();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#isEnableRemoteControl <em>Enable Remote Control</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enable Remote Control</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalUser#isEnableRemoteControl()
	 * @see #getWindowsLocalUser()
	 * @generated
	 */
	EAttribute getWindowsLocalUser_EnableRemoteControl();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#getFullName <em>Full Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Full Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalUser#getFullName()
	 * @see #getWindowsLocalUser()
	 * @generated
	 */
	EAttribute getWindowsLocalUser_FullName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#getHomeFolder <em>Home Folder</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Home Folder</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalUser#getHomeFolder()
	 * @see #getWindowsLocalUser()
	 * @generated
	 */
	EAttribute getWindowsLocalUser_HomeFolder();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#getLogonScript <em>Logon Script</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Logon Script</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalUser#getLogonScript()
	 * @see #getWindowsLocalUser()
	 * @generated
	 */
	EAttribute getWindowsLocalUser_LogonScript();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#isPasswordNeverExpires <em>Password Never Expires</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Password Never Expires</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalUser#isPasswordNeverExpires()
	 * @see #getWindowsLocalUser()
	 * @generated
	 */
	EAttribute getWindowsLocalUser_PasswordNeverExpires();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#getProfilePath <em>Profile Path</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Profile Path</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalUser#getProfilePath()
	 * @see #getWindowsLocalUser()
	 * @generated
	 */
	EAttribute getWindowsLocalUser_ProfilePath();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#getUserAccountType <em>User Account Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Account Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalUser#getUserAccountType()
	 * @see #getWindowsLocalUser()
	 * @generated
	 */
	EAttribute getWindowsLocalUser_UserAccountType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#isUserCannotChangePassword <em>User Cannot Change Password</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Cannot Change Password</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalUser#isUserCannotChangePassword()
	 * @see #getWindowsLocalUser()
	 * @generated
	 */
	EAttribute getWindowsLocalUser_UserCannotChangePassword();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#getUserSid <em>User Sid</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Sid</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalUser#getUserSid()
	 * @see #getWindowsLocalUser()
	 * @generated
	 */
	EAttribute getWindowsLocalUser_UserSid();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUser#getUserSidType <em>User Sid Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Sid Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalUser#getUserSidType()
	 * @see #getWindowsLocalUser()
	 * @generated
	 */
	EAttribute getWindowsLocalUser_UserSidType();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.WindowsLocalUserUnit <em>Windows Local User Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Windows Local User Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsLocalUserUnit
	 * @generated
	 */
	EClass getWindowsLocalUserUnit();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem <em>Windows Operating System</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Windows Operating System</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem
	 * @generated
	 */
	EClass getWindowsOperatingSystem();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getCompany <em>Company</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Company</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getCompany()
	 * @see #getWindowsOperatingSystem()
	 * @generated
	 */
	EAttribute getWindowsOperatingSystem_Company();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getDomainAdmin <em>Domain Admin</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Domain Admin</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getDomainAdmin()
	 * @see #getWindowsOperatingSystem()
	 * @generated
	 */
	EAttribute getWindowsOperatingSystem_DomainAdmin();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getDomainName <em>Domain Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Domain Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getDomainName()
	 * @see #getWindowsOperatingSystem()
	 * @generated
	 */
	EAttribute getWindowsOperatingSystem_DomainName();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getDomainPassword <em>Domain Password</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Domain Password</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getDomainPassword()
	 * @see #getWindowsOperatingSystem()
	 * @generated
	 */
	EAttribute getWindowsOperatingSystem_DomainPassword();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getEncryptionLevel <em>Encryption Level</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Encryption Level</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getEncryptionLevel()
	 * @see #getWindowsOperatingSystem()
	 * @generated
	 */
	EAttribute getWindowsOperatingSystem_EncryptionLevel();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getInstallDate <em>Install Date</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Install Date</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getInstallDate()
	 * @see #getWindowsOperatingSystem()
	 * @generated
	 */
	EAttribute getWindowsOperatingSystem_InstallDate();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getLanguage()
	 * @see #getWindowsOperatingSystem()
	 * @generated
	 */
	EAttribute getWindowsOperatingSystem_Language();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getLanguageGroup <em>Language Group</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language Group</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getLanguageGroup()
	 * @see #getWindowsOperatingSystem()
	 * @generated
	 */
	EAttribute getWindowsOperatingSystem_LanguageGroup();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getLastBootUpTime <em>Last Boot Up Time</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Boot Up Time</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getLastBootUpTime()
	 * @see #getWindowsOperatingSystem()
	 * @generated
	 */
	EAttribute getWindowsOperatingSystem_LastBootUpTime();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getMachineObjectOU <em>Machine Object OU</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Machine Object OU</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getMachineObjectOU()
	 * @see #getWindowsOperatingSystem()
	 * @generated
	 */
	EAttribute getWindowsOperatingSystem_MachineObjectOU();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getNumberOfLicensedUsers <em>Number Of Licensed Users</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number Of Licensed Users</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getNumberOfLicensedUsers()
	 * @see #getWindowsOperatingSystem()
	 * @generated
	 */
	EAttribute getWindowsOperatingSystem_NumberOfLicensedUsers();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Owner</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getOwner()
	 * @see #getWindowsOperatingSystem()
	 * @generated
	 */
	EAttribute getWindowsOperatingSystem_Owner();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getProductKey <em>Product Key</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Product Key</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getProductKey()
	 * @see #getWindowsOperatingSystem()
	 * @generated
	 */
	EAttribute getWindowsOperatingSystem_ProductKey();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getProductType <em>Product Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Product Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getProductType()
	 * @see #getWindowsOperatingSystem()
	 * @generated
	 */
	EAttribute getWindowsOperatingSystem_ProductType();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getSystemDrive <em>System Drive</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>System Drive</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getSystemDrive()
	 * @see #getWindowsOperatingSystem()
	 * @generated
	 */
	EAttribute getWindowsOperatingSystem_SystemDrive();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getWindowsDirectory <em>Windows Directory</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Windows Directory</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getWindowsDirectory()
	 * @see #getWindowsOperatingSystem()
	 * @generated
	 */
	EAttribute getWindowsOperatingSystem_WindowsDirectory();

	/**
	 * Returns the meta object for the attribute '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getWorkgroupName <em>Workgroup Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Workgroup Name</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsOperatingSystem#getWorkgroupName()
	 * @see #getWindowsOperatingSystem()
	 * @generated
	 */
	EAttribute getWindowsOperatingSystem_WorkgroupName();

	/**
	 * Returns the meta object for class '{@link com.ibm.ccl.soa.deploy.os.WindowsOperatingSystemUnit <em>Windows Operating System Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Windows Operating System Unit</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsOperatingSystemUnit
	 * @generated
	 */
	EClass getWindowsOperatingSystemUnit();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.os.AIXAuthMethodType <em>AIX Auth Method Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>AIX Auth Method Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXAuthMethodType
	 * @generated
	 */
	EEnum getAIXAuthMethodType();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.os.AIXDesktopType <em>AIX Desktop Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>AIX Desktop Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXDesktopType
	 * @generated
	 */
	EEnum getAIXDesktopType();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.os.AIXUserRegisteringMethodType <em>AIX User Registering Method Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>AIX User Registering Method Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXUserRegisteringMethodType
	 * @generated
	 */
	EEnum getAIXUserRegisteringMethodType();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.os.ArchitectureBusType <em>Architecture Bus Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Architecture Bus Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.ArchitectureBusType
	 * @generated
	 */
	EEnum getArchitectureBusType();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.os.DefaultWindowsUserGroups <em>Default Windows User Groups</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Default Windows User Groups</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.DefaultWindowsUserGroups
	 * @generated
	 */
	EEnum getDefaultWindowsUserGroups();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.os.EncryptionLevelType <em>Encryption Level Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Encryption Level Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.EncryptionLevelType
	 * @generated
	 */
	EEnum getEncryptionLevelType();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.os.KernelWidthType <em>Kernel Width Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Kernel Width Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.KernelWidthType
	 * @generated
	 */
	EEnum getKernelWidthType();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.os.LinuxServiceStartupTypeType <em>Linux Service Startup Type Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Linux Service Startup Type Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxServiceStartupTypeType
	 * @generated
	 */
	EEnum getLinuxServiceStartupTypeType();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.os.LinuxServiceStatusType <em>Linux Service Status Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Linux Service Status Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxServiceStatusType
	 * @generated
	 */
	EEnum getLinuxServiceStatusType();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemType <em>Operating System Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Operating System Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemType
	 * @generated
	 */
	EEnum getOperatingSystemType();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.os.RedhatDesktopType <em>Redhat Desktop Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Redhat Desktop Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatDesktopType
	 * @generated
	 */
	EEnum getRedhatDesktopType();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxBootLoaderType <em>Redhat Linux Boot Loader Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Redhat Linux Boot Loader Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxBootLoaderType
	 * @generated
	 */
	EEnum getRedhatLinuxBootLoaderType();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxProductTypeType <em>Redhat Linux Product Type Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Redhat Linux Product Type Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxProductTypeType
	 * @generated
	 */
	EEnum getRedhatLinuxProductTypeType();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxServiceStartupTypeType <em>Redhat Linux Service Startup Type Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Redhat Linux Service Startup Type Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxServiceStartupTypeType
	 * @generated
	 */
	EEnum getRedhatLinuxServiceStartupTypeType();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxServiceStatusType <em>Redhat Linux Service Status Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Redhat Linux Service Status Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxServiceStatusType
	 * @generated
	 */
	EEnum getRedhatLinuxServiceStatusType();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.os.SELinuxStateType <em>SE Linux State Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>SE Linux State Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.SELinuxStateType
	 * @generated
	 */
	EEnum getSELinuxStateType();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.os.SUSEDesktopType <em>SUSE Desktop Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>SUSE Desktop Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.SUSEDesktopType
	 * @generated
	 */
	EEnum getSUSEDesktopType();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.os.SUSELinuxBootLoaderType <em>SUSE Linux Boot Loader Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>SUSE Linux Boot Loader Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.SUSELinuxBootLoaderType
	 * @generated
	 */
	EEnum getSUSELinuxBootLoaderType();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.os.SUSELinuxServiceStartupTypeType <em>SUSE Linux Service Startup Type Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>SUSE Linux Service Startup Type Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.SUSELinuxServiceStartupTypeType
	 * @generated
	 */
	EEnum getSUSELinuxServiceStartupTypeType();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.os.SUSELinuxServiceStatusType <em>SUSE Linux Service Status Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>SUSE Linux Service Status Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.SUSELinuxServiceStatusType
	 * @generated
	 */
	EEnum getSUSELinuxServiceStatusType();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.os.TransportLayerProtocolType <em>Transport Layer Protocol Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Transport Layer Protocol Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.TransportLayerProtocolType
	 * @generated
	 */
	EEnum getTransportLayerProtocolType();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.os.WindowsDirectoryType <em>Windows Directory Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Windows Directory Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsDirectoryType
	 * @generated
	 */
	EEnum getWindowsDirectoryType();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.os.WindowsProductTypeType <em>Windows Product Type Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Windows Product Type Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsProductTypeType
	 * @generated
	 */
	EEnum getWindowsProductTypeType();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.os.WindowsServiceErrorControlType <em>Windows Service Error Control Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Windows Service Error Control Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsServiceErrorControlType
	 * @generated
	 */
	EEnum getWindowsServiceErrorControlType();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.os.WindowsServiceStartupType <em>Windows Service Startup Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Windows Service Startup Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsServiceStartupType
	 * @generated
	 */
	EEnum getWindowsServiceStartupType();

	/**
	 * Returns the meta object for enum '{@link com.ibm.ccl.soa.deploy.os.WindowsServiceStatusType <em>Windows Service Status Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Windows Service Status Type</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsServiceStatusType
	 * @generated
	 */
	EEnum getWindowsServiceStatusType();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.os.AIXAuthMethodType <em>AIX Auth Method Type Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>AIX Auth Method Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXAuthMethodType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.os.AIXAuthMethodType"
	 *        extendedMetaData="name='AIXAuthMethodType:Object' baseType='AIXAuthMethodType'"
	 * @generated
	 */
	EDataType getAIXAuthMethodTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.os.AIXDesktopType <em>AIX Desktop Type Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>AIX Desktop Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXDesktopType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.os.AIXDesktopType"
	 *        extendedMetaData="name='AIXDesktopType:Object' baseType='AIXDesktopType'"
	 * @generated
	 */
	EDataType getAIXDesktopTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.os.AIXUserRegisteringMethodType <em>AIX User Registering Method Type Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>AIX User Registering Method Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.AIXUserRegisteringMethodType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.os.AIXUserRegisteringMethodType"
	 *        extendedMetaData="name='AIXUserRegisteringMethodType:Object' baseType='AIXUserRegisteringMethodType'"
	 * @generated
	 */
	EDataType getAIXUserRegisteringMethodTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.os.ArchitectureBusType <em>Architecture Bus Type Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Architecture Bus Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.ArchitectureBusType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.os.ArchitectureBusType"
	 *        extendedMetaData="name='ArchitectureBusType:Object' baseType='ArchitectureBusType'"
	 * @generated
	 */
	EDataType getArchitectureBusTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.os.DefaultWindowsUserGroups <em>Default Windows User Groups Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Default Windows User Groups Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.DefaultWindowsUserGroups
	 * @model instanceClass="com.ibm.ccl.soa.deploy.os.DefaultWindowsUserGroups"
	 *        extendedMetaData="name='DefaultWindowsUserGroups:Object' baseType='DefaultWindowsUserGroups'"
	 * @generated
	 */
	EDataType getDefaultWindowsUserGroupsObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.os.EncryptionLevelType <em>Encryption Level Type Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Encryption Level Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.EncryptionLevelType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.os.EncryptionLevelType"
	 *        extendedMetaData="name='EncryptionLevelType:Object' baseType='EncryptionLevelType'"
	 * @generated
	 */
	EDataType getEncryptionLevelTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.os.KernelWidthType <em>Kernel Width Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Kernel Width Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.KernelWidthType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.os.KernelWidthType"
	 *        extendedMetaData="name='KernelWidthType:Object' baseType='KernelWidthType'"
	 * @generated
	 */
	EDataType getKernelWidthTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.os.LinuxServiceStartupTypeType <em>Linux Service Startup Type Type Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Linux Service Startup Type Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxServiceStartupTypeType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.os.LinuxServiceStartupTypeType"
	 *        extendedMetaData="name='LinuxServiceStartupTypeType:Object' baseType='LinuxServiceStartupTypeType'"
	 * @generated
	 */
	EDataType getLinuxServiceStartupTypeTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.os.LinuxServiceStatusType <em>Linux Service Status Type Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Linux Service Status Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.LinuxServiceStatusType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.os.LinuxServiceStatusType"
	 *        extendedMetaData="name='LinuxServiceStatusType:Object' baseType='LinuxServiceStatusType'"
	 * @generated
	 */
	EDataType getLinuxServiceStatusTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemType <em>Operating System Type Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Operating System Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.os.OperatingSystemType"
	 *        extendedMetaData="name='OperatingSystemType:Object' baseType='OperatingSystemType'"
	 * @generated
	 */
	EDataType getOperatingSystemTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.os.RedhatDesktopType <em>Redhat Desktop Type Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Redhat Desktop Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatDesktopType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.os.RedhatDesktopType"
	 *        extendedMetaData="name='RedhatDesktopType:Object' baseType='RedhatDesktopType'"
	 * @generated
	 */
	EDataType getRedhatDesktopTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxBootLoaderType <em>Redhat Linux Boot Loader Type Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Redhat Linux Boot Loader Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxBootLoaderType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.os.RedhatLinuxBootLoaderType"
	 *        extendedMetaData="name='RedhatLinuxBootLoaderType:Object' baseType='RedhatLinuxBootLoaderType'"
	 * @generated
	 */
	EDataType getRedhatLinuxBootLoaderTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxProductTypeType <em>Redhat Linux Product Type Type Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Redhat Linux Product Type Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxProductTypeType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.os.RedhatLinuxProductTypeType"
	 *        extendedMetaData="name='RedhatLinuxProductTypeType:Object' baseType='RedhatLinuxProductTypeType'"
	 * @generated
	 */
	EDataType getRedhatLinuxProductTypeTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxServiceStartupTypeType <em>Redhat Linux Service Startup Type Type Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Redhat Linux Service Startup Type Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxServiceStartupTypeType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.os.RedhatLinuxServiceStartupTypeType"
	 *        extendedMetaData="name='RedhatLinuxServiceStartupTypeType:Object' baseType='RedhatLinuxServiceStartupTypeType'"
	 * @generated
	 */
	EDataType getRedhatLinuxServiceStartupTypeTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxServiceStatusType <em>Redhat Linux Service Status Type Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Redhat Linux Service Status Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxServiceStatusType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.os.RedhatLinuxServiceStatusType"
	 *        extendedMetaData="name='RedhatLinuxServiceStatusType:Object' baseType='RedhatLinuxServiceStatusType'"
	 * @generated
	 */
	EDataType getRedhatLinuxServiceStatusTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.os.SELinuxStateType <em>SE Linux State Type Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>SE Linux State Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.SELinuxStateType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.os.SELinuxStateType"
	 *        extendedMetaData="name='SELinuxStateType:Object' baseType='SELinuxStateType'"
	 * @generated
	 */
	EDataType getSELinuxStateTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.os.SUSEDesktopType <em>SUSE Desktop Type Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>SUSE Desktop Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.SUSEDesktopType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.os.SUSEDesktopType"
	 *        extendedMetaData="name='SUSEDesktopType:Object' baseType='SUSEDesktopType'"
	 * @generated
	 */
	EDataType getSUSEDesktopTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.os.SUSELinuxBootLoaderType <em>SUSE Linux Boot Loader Type Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>SUSE Linux Boot Loader Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.SUSELinuxBootLoaderType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.os.SUSELinuxBootLoaderType"
	 *        extendedMetaData="name='SUSELinuxBootLoaderType:Object' baseType='SUSELinuxBootLoaderType'"
	 * @generated
	 */
	EDataType getSUSELinuxBootLoaderTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.os.SUSELinuxServiceStartupTypeType <em>SUSE Linux Service Startup Type Type Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>SUSE Linux Service Startup Type Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.SUSELinuxServiceStartupTypeType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.os.SUSELinuxServiceStartupTypeType"
	 *        extendedMetaData="name='SUSELinuxServiceStartupTypeType:Object' baseType='SUSELinuxServiceStartupTypeType'"
	 * @generated
	 */
	EDataType getSUSELinuxServiceStartupTypeTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.os.SUSELinuxServiceStatusType <em>SUSE Linux Service Status Type Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>SUSE Linux Service Status Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.SUSELinuxServiceStatusType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.os.SUSELinuxServiceStatusType"
	 *        extendedMetaData="name='SUSELinuxServiceStatusType:Object' baseType='SUSELinuxServiceStatusType'"
	 * @generated
	 */
	EDataType getSUSELinuxServiceStatusTypeObject();

	/**
	 * Returns the meta object for data type '{@link java.math.BigInteger <em>TCP Port Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>TCP Port Type</em>'.
	 * @see java.math.BigInteger
	 * @model instanceClass="java.math.BigInteger"
	 *        extendedMetaData="name='TCPPortType' baseType='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#PortType'"
	 * @generated
	 */
	EDataType getTCPPortType();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.os.TransportLayerProtocolType <em>Transport Layer Protocol Type Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Transport Layer Protocol Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.TransportLayerProtocolType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.os.TransportLayerProtocolType"
	 *        extendedMetaData="name='TransportLayerProtocolType:Object' baseType='TransportLayerProtocolType'"
	 * @generated
	 */
	EDataType getTransportLayerProtocolTypeObject();

	/**
	 * Returns the meta object for data type '{@link java.math.BigInteger <em>UDP Port Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>UDP Port Type</em>'.
	 * @see java.math.BigInteger
	 * @model instanceClass="java.math.BigInteger"
	 *        extendedMetaData="name='UDPPortType' baseType='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#PortType'"
	 * @generated
	 */
	EDataType getUDPPortType();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.os.WindowsDirectoryType <em>Windows Directory Type Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Windows Directory Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsDirectoryType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.os.WindowsDirectoryType"
	 *        extendedMetaData="name='WindowsDirectoryType:Object' baseType='WindowsDirectoryType'"
	 * @generated
	 */
	EDataType getWindowsDirectoryTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.os.WindowsProductTypeType <em>Windows Product Type Type Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Windows Product Type Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsProductTypeType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.os.WindowsProductTypeType"
	 *        extendedMetaData="name='WindowsProductTypeType:Object' baseType='WindowsProductTypeType'"
	 * @generated
	 */
	EDataType getWindowsProductTypeTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.os.WindowsServiceErrorControlType <em>Windows Service Error Control Type Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Windows Service Error Control Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsServiceErrorControlType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.os.WindowsServiceErrorControlType"
	 *        extendedMetaData="name='WindowsServiceErrorControlType:Object' baseType='WindowsServiceErrorControlType'"
	 * @generated
	 */
	EDataType getWindowsServiceErrorControlTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.os.WindowsServiceStartupType <em>Windows Service Startup Type Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Windows Service Startup Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsServiceStartupType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.os.WindowsServiceStartupType"
	 *        extendedMetaData="name='WindowsServiceStartupType:Object' baseType='WindowsServiceStartupType'"
	 * @generated
	 */
	EDataType getWindowsServiceStartupTypeObject();

	/**
	 * Returns the meta object for data type '{@link com.ibm.ccl.soa.deploy.os.WindowsServiceStatusType <em>Windows Service Status Type Object</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Windows Service Status Type Object</em>'.
	 * @see com.ibm.ccl.soa.deploy.os.WindowsServiceStatusType
	 * @model instanceClass="com.ibm.ccl.soa.deploy.os.WindowsServiceStatusType"
	 *        extendedMetaData="name='WindowsServiceStatusType:Object' baseType='WindowsServiceStatusType'"
	 * @generated
	 */
	EDataType getWindowsServiceStatusTypeObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	OsFactory getOsFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalGroupImpl <em>AIX Local Group</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.AIXLocalGroupImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getAIXLocalGroup()
		 * @generated
		 */
		EClass AIX_LOCAL_GROUP = eINSTANCE.getAIXLocalGroup();

		/**
		 * The meta object literal for the '<em><b>Group Description</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_GROUP__GROUP_DESCRIPTION = eINSTANCE.getAIXLocalGroup_GroupDescription();

		/**
		 * The meta object literal for the '<em><b>Group Sid</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute AIX_LOCAL_GROUP__GROUP_SID = eINSTANCE.getAIXLocalGroup_GroupSid();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalGroupUnitImpl <em>AIX Local Group Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.AIXLocalGroupUnitImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getAIXLocalGroupUnit()
		 * @generated
		 */
		EClass AIX_LOCAL_GROUP_UNIT = eINSTANCE.getAIXLocalGroupUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalServiceImpl <em>AIX Local Service</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.AIXLocalServiceImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getAIXLocalService()
		 * @generated
		 */
		EClass AIX_LOCAL_SERVICE = eINSTANCE.getAIXLocalService();

		/**
		 * The meta object literal for the '<em><b>Action Type</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute AIX_LOCAL_SERVICE__ACTION_TYPE = eINSTANCE.getAIXLocalService_ActionType();

		/**
		 * The meta object literal for the '<em><b>Executable Path</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_SERVICE__EXECUTABLE_PATH = eINSTANCE.getAIXLocalService_ExecutablePath();

		/**
		 * The meta object literal for the '<em><b>Service Description</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_SERVICE__SERVICE_DESCRIPTION = eINSTANCE
				.getAIXLocalService_ServiceDescription();

		/**
		 * The meta object literal for the '<em><b>Startup Run Level Eight</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_EIGHT = eINSTANCE
				.getAIXLocalService_StartupRunLevelEight();

		/**
		 * The meta object literal for the '<em><b>Startup Run Level Five</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FIVE = eINSTANCE
				.getAIXLocalService_StartupRunLevelFive();

		/**
		 * The meta object literal for the '<em><b>Startup Run Level Four</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FOUR = eINSTANCE
				.getAIXLocalService_StartupRunLevelFour();

		/**
		 * The meta object literal for the '<em><b>Startup Run Level Nine</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_NINE = eINSTANCE
				.getAIXLocalService_StartupRunLevelNine();

		/**
		 * The meta object literal for the '<em><b>Startup Run Level One</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ONE = eINSTANCE
				.getAIXLocalService_StartupRunLevelOne();

		/**
		 * The meta object literal for the '<em><b>Startup Run Level Seven</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_SEVEN = eINSTANCE
				.getAIXLocalService_StartupRunLevelSeven();

		/**
		 * The meta object literal for the '<em><b>Startup Run Level Six</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_SIX = eINSTANCE
				.getAIXLocalService_StartupRunLevelSix();

		/**
		 * The meta object literal for the '<em><b>Startup Run Level Three</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_THREE = eINSTANCE
				.getAIXLocalService_StartupRunLevelThree();

		/**
		 * The meta object literal for the '<em><b>Startup Run Level Two</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_TWO = eINSTANCE
				.getAIXLocalService_StartupRunLevelTwo();

		/**
		 * The meta object literal for the '<em><b>Startup Run Level Zero</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ZERO = eINSTANCE
				.getAIXLocalService_StartupRunLevelZero();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalServiceUnitImpl <em>AIX Local Service Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.AIXLocalServiceUnitImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getAIXLocalServiceUnit()
		 * @generated
		 */
		EClass AIX_LOCAL_SERVICE_UNIT = eINSTANCE.getAIXLocalServiceUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl <em>AIX Local User</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getAIXLocalUser()
		 * @generated
		 */
		EClass AIX_LOCAL_USER = eINSTANCE.getAIXLocalUser();

		/**
		 * The meta object literal for the '<em><b>Account Description</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_USER__ACCOUNT_DESCRIPTION = eINSTANCE
				.getAIXLocalUser_AccountDescription();

		/**
		 * The meta object literal for the '<em><b>Account Disabled</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_USER__ACCOUNT_DISABLED = eINSTANCE.getAIXLocalUser_AccountDisabled();

		/**
		 * The meta object literal for the '<em><b>Account Expiration Time</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_USER__ACCOUNT_EXPIRATION_TIME = eINSTANCE
				.getAIXLocalUser_AccountExpirationTime();

		/**
		 * The meta object literal for the '<em><b>Change Password Next Logon</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_USER__CHANGE_PASSWORD_NEXT_LOGON = eINSTANCE
				.getAIXLocalUser_ChangePasswordNextLogon();

		/**
		 * The meta object literal for the '<em><b>Full Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute AIX_LOCAL_USER__FULL_NAME = eINSTANCE.getAIXLocalUser_FullName();

		/**
		 * The meta object literal for the '<em><b>Home Dir</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute AIX_LOCAL_USER__HOME_DIR = eINSTANCE.getAIXLocalUser_HomeDir();

		/**
		 * The meta object literal for the '<em><b>Is Admin</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute AIX_LOCAL_USER__IS_ADMIN = eINSTANCE.getAIXLocalUser_IsAdmin();

		/**
		 * The meta object literal for the '<em><b>Login Permitted</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_USER__LOGIN_PERMITTED = eINSTANCE.getAIXLocalUser_LoginPermitted();

		/**
		 * The meta object literal for the '<em><b>Login Retries</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_USER__LOGIN_RETRIES = eINSTANCE.getAIXLocalUser_LoginRetries();

		/**
		 * The meta object literal for the '<em><b>Login Times</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute AIX_LOCAL_USER__LOGIN_TIMES = eINSTANCE.getAIXLocalUser_LoginTimes();

		/**
		 * The meta object literal for the '<em><b>Max Char Repeats</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_USER__MAX_CHAR_REPEATS = eINSTANCE.getAIXLocalUser_MaxCharRepeats();

		/**
		 * The meta object literal for the '<em><b>Max Password Age In Weeks</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_USER__MAX_PASSWORD_AGE_IN_WEEKS = eINSTANCE
				.getAIXLocalUser_MaxPasswordAgeInWeeks();

		/**
		 * The meta object literal for the '<em><b>Max Password Valid Weeks</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_USER__MAX_PASSWORD_VALID_WEEKS = eINSTANCE
				.getAIXLocalUser_MaxPasswordValidWeeks();

		/**
		 * The meta object literal for the '<em><b>Min Alpha Chars In Password</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_USER__MIN_ALPHA_CHARS_IN_PASSWORD = eINSTANCE
				.getAIXLocalUser_MinAlphaCharsInPassword();

		/**
		 * The meta object literal for the '<em><b>Min Diff Chars</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_USER__MIN_DIFF_CHARS = eINSTANCE.getAIXLocalUser_MinDiffChars();

		/**
		 * The meta object literal for the '<em><b>Min Other Chars In Password</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_USER__MIN_OTHER_CHARS_IN_PASSWORD = eINSTANCE
				.getAIXLocalUser_MinOtherCharsInPassword();

		/**
		 * The meta object literal for the '<em><b>Min Password Age In Weeks</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_USER__MIN_PASSWORD_AGE_IN_WEEKS = eINSTANCE
				.getAIXLocalUser_MinPasswordAgeInWeeks();

		/**
		 * The meta object literal for the '<em><b>Min Password Length</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_USER__MIN_PASSWORD_LENGTH = eINSTANCE
				.getAIXLocalUser_MinPasswordLength();

		/**
		 * The meta object literal for the '<em><b>Not Reusable Number Of Passwords</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_USER__NOT_REUSABLE_NUMBER_OF_PASSWORDS = eINSTANCE
				.getAIXLocalUser_NotReusableNumberOfPasswords();

		/**
		 * The meta object literal for the '<em><b>Pass Reuse Not Allowed In Weeks</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_USER__PASS_REUSE_NOT_ALLOWED_IN_WEEKS = eINSTANCE
				.getAIXLocalUser_PassReuseNotAllowedInWeeks();

		/**
		 * The meta object literal for the '<em><b>Password Change Warn Time</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_USER__PASSWORD_CHANGE_WARN_TIME = eINSTANCE
				.getAIXLocalUser_PasswordChangeWarnTime();

		/**
		 * The meta object literal for the '<em><b>Password Never Expires</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_USER__PASSWORD_NEVER_EXPIRES = eINSTANCE
				.getAIXLocalUser_PasswordNeverExpires();

		/**
		 * The meta object literal for the '<em><b>Primary Auth Method</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_USER__PRIMARY_AUTH_METHOD = eINSTANCE
				.getAIXLocalUser_PrimaryAuthMethod();

		/**
		 * The meta object literal for the '<em><b>Remote Login Is Allowed</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_USER__REMOTE_LOGIN_IS_ALLOWED = eINSTANCE
				.getAIXLocalUser_RemoteLoginIsAllowed();

		/**
		 * The meta object literal for the '<em><b>Secondary Auth Method</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_USER__SECONDARY_AUTH_METHOD = eINSTANCE
				.getAIXLocalUser_SecondaryAuthMethod();

		/**
		 * The meta object literal for the '<em><b>Shell</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute AIX_LOCAL_USER__SHELL = eINSTANCE.getAIXLocalUser_Shell();

		/**
		 * The meta object literal for the '<em><b>Su Groups Allowed</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_USER__SU_GROUPS_ALLOWED = eINSTANCE.getAIXLocalUser_SuGroupsAllowed();

		/**
		 * The meta object literal for the '<em><b>Su Is Allowed</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_USER__SU_IS_ALLOWED = eINSTANCE.getAIXLocalUser_SuIsAllowed();

		/**
		 * The meta object literal for the '<em><b>Time Last Login</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_USER__TIME_LAST_LOGIN = eINSTANCE.getAIXLocalUser_TimeLastLogin();

		/**
		 * The meta object literal for the '<em><b>User Cannot Change Password</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_USER__USER_CANNOT_CHANGE_PASSWORD = eINSTANCE
				.getAIXLocalUser_UserCannotChangePassword();

		/**
		 * The meta object literal for the '<em><b>User Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute AIX_LOCAL_USER__USER_NAME = eINSTANCE.getAIXLocalUser_UserName();

		/**
		 * The meta object literal for the '<em><b>User Registering Method</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_USER__USER_REGISTERING_METHOD = eINSTANCE
				.getAIXLocalUser_UserRegisteringMethod();

		/**
		 * The meta object literal for the '<em><b>User Sid</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute AIX_LOCAL_USER__USER_SID = eINSTANCE.getAIXLocalUser_UserSid();

		/**
		 * The meta object literal for the '<em><b>Usuccessful Login Count</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_LOCAL_USER__USUCCESSFUL_LOGIN_COUNT = eINSTANCE
				.getAIXLocalUser_UsuccessfulLoginCount();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserUnitImpl <em>AIX Local User Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.AIXLocalUserUnitImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getAIXLocalUserUnit()
		 * @generated
		 */
		EClass AIX_LOCAL_USER_UNIT = eINSTANCE.getAIXLocalUserUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.AIXOperatingSystemImpl <em>AIX Operating System</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.AIXOperatingSystemImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getAIXOperatingSystem()
		 * @generated
		 */
		EClass AIX_OPERATING_SYSTEM = eINSTANCE.getAIXOperatingSystem();

		/**
		 * The meta object literal for the '<em><b>Desktop</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute AIX_OPERATING_SYSTEM__DESKTOP = eINSTANCE.getAIXOperatingSystem_Desktop();

		/**
		 * The meta object literal for the '<em><b>Install Date</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute AIX_OPERATING_SYSTEM__INSTALL_DATE = eINSTANCE.getAIXOperatingSystem_InstallDate();

		/**
		 * The meta object literal for the '<em><b>Kernel</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute AIX_OPERATING_SYSTEM__KERNEL = eINSTANCE.getAIXOperatingSystem_Kernel();

		/**
		 * The meta object literal for the '<em><b>Last Boot Up Time</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIX_OPERATING_SYSTEM__LAST_BOOT_UP_TIME = eINSTANCE
				.getAIXOperatingSystem_LastBootUpTime();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute AIX_OPERATING_SYSTEM__OWNER = eINSTANCE.getAIXOperatingSystem_Owner();

		/**
		 * The meta object literal for the '<em><b>TCB</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute AIX_OPERATING_SYSTEM__TCB = eINSTANCE.getAIXOperatingSystem_TCB();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.AIXOperatingSystemUnitImpl <em>AIX Operating System Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.AIXOperatingSystemUnitImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getAIXOperatingSystemUnit()
		 * @generated
		 */
		EClass AIX_OPERATING_SYSTEM_UNIT = eINSTANCE.getAIXOperatingSystemUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.DataFileImpl <em>Data File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.DataFileImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getDataFile()
		 * @generated
		 */
		EClass DATA_FILE = eINSTANCE.getDataFile();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.DataFileUnitImpl <em>Data File Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.DataFileUnitImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getDataFileUnit()
		 * @generated
		 */
		EClass DATA_FILE_UNIT = eINSTANCE.getDataFileUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.DirectoryImpl <em>Directory</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.DirectoryImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getDirectory()
		 * @generated
		 */
		EClass DIRECTORY = eINSTANCE.getDirectory();

		/**
		 * The meta object literal for the '<em><b>Directory Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIRECTORY__DIRECTORY_PATH = eINSTANCE.getDirectory_DirectoryPath();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.DirectoryUnitImpl <em>Directory Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.DirectoryUnitImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getDirectoryUnit()
		 * @generated
		 */
		EClass DIRECTORY_UNIT = eINSTANCE.getDirectoryUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.FileSystemImpl <em>File System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.FileSystemImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getFileSystem()
		 * @generated
		 */
		EClass FILE_SYSTEM = eINSTANCE.getFileSystem();

		/**
		 * The meta object literal for the '<em><b>Available Space</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_SYSTEM__AVAILABLE_SPACE = eINSTANCE.getFileSystem_AvailableSpace();

		/**
		 * The meta object literal for the '<em><b>Capacity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_SYSTEM__CAPACITY = eINSTANCE.getFileSystem_Capacity();

		/**
		 * The meta object literal for the '<em><b>Mount Point</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_SYSTEM__MOUNT_POINT = eINSTANCE.getFileSystem_MountPoint();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_SYSTEM__TYPE = eINSTANCE.getFileSystem_Type();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.FileSystemContentImpl <em>File System Content</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.FileSystemContentImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getFileSystemContent()
		 * @generated
		 */
		EClass FILE_SYSTEM_CONTENT = eINSTANCE.getFileSystemContent();

		/**
		 * The meta object literal for the '<em><b>Fixed Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_SYSTEM_CONTENT__FIXED_PATH = eINSTANCE.getFileSystemContent_FixedPath();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_SYSTEM_CONTENT__GROUP = eINSTANCE.getFileSystemContent_Group();

		/**
		 * The meta object literal for the '<em><b>Last Modified</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_SYSTEM_CONTENT__LAST_MODIFIED = eINSTANCE.getFileSystemContent_LastModified();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_SYSTEM_CONTENT__OWNER = eINSTANCE.getFileSystemContent_Owner();

		/**
		 * The meta object literal for the '<em><b>Permissions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_SYSTEM_CONTENT__PERMISSIONS = eINSTANCE.getFileSystemContent_Permissions();

		/**
		 * The meta object literal for the '<em><b>Real File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_SYSTEM_CONTENT__REAL_FILE = eINSTANCE.getFileSystemContent_RealFile();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_SYSTEM_CONTENT__SIZE = eINSTANCE.getFileSystemContent_Size();

		/**
		 * The meta object literal for the '<em><b>URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILE_SYSTEM_CONTENT__URI = eINSTANCE.getFileSystemContent_URI();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.FileSystemContentUnitImpl <em>File System Content Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.FileSystemContentUnitImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getFileSystemContentUnit()
		 * @generated
		 */
		EClass FILE_SYSTEM_CONTENT_UNIT = eINSTANCE.getFileSystemContentUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.FileSystemUnitImpl <em>File System Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.FileSystemUnitImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getFileSystemUnit()
		 * @generated
		 */
		EClass FILE_SYSTEM_UNIT = eINSTANCE.getFileSystemUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.LinuxLocalGroupImpl <em>Linux Local Group</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.LinuxLocalGroupImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getLinuxLocalGroup()
		 * @generated
		 */
		EClass LINUX_LOCAL_GROUP = eINSTANCE.getLinuxLocalGroup();

		/**
		 * The meta object literal for the '<em><b>Group Description</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINUX_LOCAL_GROUP__GROUP_DESCRIPTION = eINSTANCE
				.getLinuxLocalGroup_GroupDescription();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.LinuxLocalGroupUnitImpl <em>Linux Local Group Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.LinuxLocalGroupUnitImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getLinuxLocalGroupUnit()
		 * @generated
		 */
		EClass LINUX_LOCAL_GROUP_UNIT = eINSTANCE.getLinuxLocalGroupUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.LinuxLocalServiceImpl <em>Linux Local Service</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.LinuxLocalServiceImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getLinuxLocalService()
		 * @generated
		 */
		EClass LINUX_LOCAL_SERVICE = eINSTANCE.getLinuxLocalService();

		/**
		 * The meta object literal for the '<em><b>Executable Path</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINUX_LOCAL_SERVICE__EXECUTABLE_PATH = eINSTANCE
				.getLinuxLocalService_ExecutablePath();

		/**
		 * The meta object literal for the '<em><b>Service Account</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINUX_LOCAL_SERVICE__SERVICE_ACCOUNT = eINSTANCE
				.getLinuxLocalService_ServiceAccount();

		/**
		 * The meta object literal for the '<em><b>Service Description</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINUX_LOCAL_SERVICE__SERVICE_DESCRIPTION = eINSTANCE
				.getLinuxLocalService_ServiceDescription();

		/**
		 * The meta object literal for the '<em><b>Service Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LINUX_LOCAL_SERVICE__SERVICE_NAME = eINSTANCE.getLinuxLocalService_ServiceName();

		/**
		 * The meta object literal for the '<em><b>Service Status</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINUX_LOCAL_SERVICE__SERVICE_STATUS = eINSTANCE
				.getLinuxLocalService_ServiceStatus();

		/**
		 * The meta object literal for the '<em><b>Startup Run Level Five</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FIVE = eINSTANCE
				.getLinuxLocalService_StartupRunLevelFive();

		/**
		 * The meta object literal for the '<em><b>Startup Run Level Four</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_FOUR = eINSTANCE
				.getLinuxLocalService_StartupRunLevelFour();

		/**
		 * The meta object literal for the '<em><b>Startup Run Level One</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ONE = eINSTANCE
				.getLinuxLocalService_StartupRunLevelOne();

		/**
		 * The meta object literal for the '<em><b>Startup Run Level Six</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_SIX = eINSTANCE
				.getLinuxLocalService_StartupRunLevelSix();

		/**
		 * The meta object literal for the '<em><b>Startup Run Level Three</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_THREE = eINSTANCE
				.getLinuxLocalService_StartupRunLevelThree();

		/**
		 * The meta object literal for the '<em><b>Startup Run Level Two</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_TWO = eINSTANCE
				.getLinuxLocalService_StartupRunLevelTwo();

		/**
		 * The meta object literal for the '<em><b>Startup Run Level Zero</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINUX_LOCAL_SERVICE__STARTUP_RUN_LEVEL_ZERO = eINSTANCE
				.getLinuxLocalService_StartupRunLevelZero();

		/**
		 * The meta object literal for the '<em><b>Startup Type</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LINUX_LOCAL_SERVICE__STARTUP_TYPE = eINSTANCE.getLinuxLocalService_StartupType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.LinuxLocalServiceUnitImpl <em>Linux Local Service Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.LinuxLocalServiceUnitImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getLinuxLocalServiceUnit()
		 * @generated
		 */
		EClass LINUX_LOCAL_SERVICE_UNIT = eINSTANCE.getLinuxLocalServiceUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.LinuxLocalUserImpl <em>Linux Local User</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.LinuxLocalUserImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getLinuxLocalUser()
		 * @generated
		 */
		EClass LINUX_LOCAL_USER = eINSTANCE.getLinuxLocalUser();

		/**
		 * The meta object literal for the '<em><b>Account Description</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINUX_LOCAL_USER__ACCOUNT_DESCRIPTION = eINSTANCE
				.getLinuxLocalUser_AccountDescription();

		/**
		 * The meta object literal for the '<em><b>Account Disabled</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINUX_LOCAL_USER__ACCOUNT_DISABLED = eINSTANCE.getLinuxLocalUser_AccountDisabled();

		/**
		 * The meta object literal for the '<em><b>Change Password Next Logon</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINUX_LOCAL_USER__CHANGE_PASSWORD_NEXT_LOGON = eINSTANCE
				.getLinuxLocalUser_ChangePasswordNextLogon();

		/**
		 * The meta object literal for the '<em><b>Full Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LINUX_LOCAL_USER__FULL_NAME = eINSTANCE.getLinuxLocalUser_FullName();

		/**
		 * The meta object literal for the '<em><b>Home Dir</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LINUX_LOCAL_USER__HOME_DIR = eINSTANCE.getLinuxLocalUser_HomeDir();

		/**
		 * The meta object literal for the '<em><b>Password Never Expires</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINUX_LOCAL_USER__PASSWORD_NEVER_EXPIRES = eINSTANCE
				.getLinuxLocalUser_PasswordNeverExpires();

		/**
		 * The meta object literal for the '<em><b>Shell</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LINUX_LOCAL_USER__SHELL = eINSTANCE.getLinuxLocalUser_Shell();

		/**
		 * The meta object literal for the '<em><b>User Cannot Change Password</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINUX_LOCAL_USER__USER_CANNOT_CHANGE_PASSWORD = eINSTANCE
				.getLinuxLocalUser_UserCannotChangePassword();

		/**
		 * The meta object literal for the '<em><b>User Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LINUX_LOCAL_USER__USER_NAME = eINSTANCE.getLinuxLocalUser_UserName();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.LinuxLocalUserUnitImpl <em>Linux Local User Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.LinuxLocalUserUnitImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getLinuxLocalUserUnit()
		 * @generated
		 */
		EClass LINUX_LOCAL_USER_UNIT = eINSTANCE.getLinuxLocalUserUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.LinuxOperatingSystemImpl <em>Linux Operating System</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.LinuxOperatingSystemImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getLinuxOperatingSystem()
		 * @generated
		 */
		EClass LINUX_OPERATING_SYSTEM = eINSTANCE.getLinuxOperatingSystem();

		/**
		 * The meta object literal for the '<em><b>Kernel Release</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINUX_OPERATING_SYSTEM__KERNEL_RELEASE = eINSTANCE
				.getLinuxOperatingSystem_KernelRelease();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.LinuxOperatingSystemUnitImpl <em>Linux Operating System Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.LinuxOperatingSystemUnitImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getLinuxOperatingSystemUnit()
		 * @generated
		 */
		EClass LINUX_OPERATING_SYSTEM_UNIT = eINSTANCE.getLinuxOperatingSystemUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.LocalFileSystemImpl <em>Local File System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.LocalFileSystemImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getLocalFileSystem()
		 * @generated
		 */
		EClass LOCAL_FILE_SYSTEM = eINSTANCE.getLocalFileSystem();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.LocalFileSystemUnitImpl <em>Local File System Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.LocalFileSystemUnitImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getLocalFileSystemUnit()
		 * @generated
		 */
		EClass LOCAL_FILE_SYSTEM_UNIT = eINSTANCE.getLocalFileSystemUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.NFSFileSystemImpl <em>NFS File System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.NFSFileSystemImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getNFSFileSystem()
		 * @generated
		 */
		EClass NFS_FILE_SYSTEM = eINSTANCE.getNFSFileSystem();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.NFSFileSystemUnitImpl <em>NFS File System Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.NFSFileSystemUnitImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getNFSFileSystemUnit()
		 * @generated
		 */
		EClass NFS_FILE_SYSTEM_UNIT = eINSTANCE.getNFSFileSystemUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.OpenVmsFileSystemImpl <em>Open Vms File System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.OpenVmsFileSystemImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getOpenVmsFileSystem()
		 * @generated
		 */
		EClass OPEN_VMS_FILE_SYSTEM = eINSTANCE.getOpenVmsFileSystem();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.OpenVmsFileSystemUnitImpl <em>Open Vms File System Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.OpenVmsFileSystemUnitImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getOpenVmsFileSystemUnit()
		 * @generated
		 */
		EClass OPEN_VMS_FILE_SYSTEM_UNIT = eINSTANCE.getOpenVmsFileSystemUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemImpl <em>Operating System</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.OperatingSystemImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getOperatingSystem()
		 * @generated
		 */
		EClass OPERATING_SYSTEM = eINSTANCE.getOperatingSystem();

		/**
		 * The meta object literal for the '<em><b>Fqdn</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATING_SYSTEM__FQDN = eINSTANCE.getOperatingSystem_Fqdn();

		/**
		 * The meta object literal for the '<em><b>Hostname</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute OPERATING_SYSTEM__HOSTNAME = eINSTANCE.getOperatingSystem_Hostname();

		/**
		 * The meta object literal for the '<em><b>Kernel Architecture</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATING_SYSTEM__KERNEL_ARCHITECTURE = eINSTANCE
				.getOperatingSystem_KernelArchitecture();

		/**
		 * The meta object literal for the '<em><b>Kernel Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATING_SYSTEM__KERNEL_VERSION = eINSTANCE.getOperatingSystem_KernelVersion();

		/**
		 * The meta object literal for the '<em><b>Kernel Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATING_SYSTEM__KERNEL_WIDTH = eINSTANCE.getOperatingSystem_KernelWidth();

		/**
		 * The meta object literal for the '<em><b>Locale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATING_SYSTEM__LOCALE = eINSTANCE.getOperatingSystem_Locale();

		/**
		 * The meta object literal for the '<em><b>Manufacturer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATING_SYSTEM__MANUFACTURER = eINSTANCE.getOperatingSystem_Manufacturer();

		/**
		 * The meta object literal for the '<em><b>Os Distribution</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATING_SYSTEM__OS_DISTRIBUTION = eINSTANCE.getOperatingSystem_OsDistribution();

		/**
		 * The meta object literal for the '<em><b>Os Servicepack</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATING_SYSTEM__OS_SERVICEPACK = eINSTANCE.getOperatingSystem_OsServicepack();

		/**
		 * The meta object literal for the '<em><b>Os Type</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute OPERATING_SYSTEM__OS_TYPE = eINSTANCE.getOperatingSystem_OsType();

		/**
		 * The meta object literal for the '<em><b>Os Version</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute OPERATING_SYSTEM__OS_VERSION = eINSTANCE.getOperatingSystem_OsVersion();

		/**
		 * The meta object literal for the '<em><b>Time Zone</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATING_SYSTEM__TIME_ZONE = eINSTANCE.getOperatingSystem_TimeZone();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl <em>Operating System Root</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.OperatingSystemRootImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getOperatingSystemRoot()
		 * @generated
		 */
		EClass OPERATING_SYSTEM_ROOT = eINSTANCE.getOperatingSystemRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute OPERATING_SYSTEM_ROOT__MIXED = eINSTANCE.getOperatingSystemRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__XMLNS_PREFIX_MAP = eINSTANCE
				.getOperatingSystemRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE
				.getOperatingSystemRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Capability Aix Local Group</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_GROUP = eINSTANCE
				.getOperatingSystemRoot_CapabilityAixLocalGroup();

		/**
		 * The meta object literal for the '<em><b>Capability Aix Local Service</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_SERVICE = eINSTANCE
				.getOperatingSystemRoot_CapabilityAixLocalService();

		/**
		 * The meta object literal for the '<em><b>Capability Aix Local User</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_LOCAL_USER = eINSTANCE
				.getOperatingSystemRoot_CapabilityAixLocalUser();

		/**
		 * The meta object literal for the '<em><b>Capability Aix Operating System</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_AIX_OPERATING_SYSTEM = eINSTANCE
				.getOperatingSystemRoot_CapabilityAixOperatingSystem();

		/**
		 * The meta object literal for the '<em><b>Capability Data File</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_DATA_FILE = eINSTANCE
				.getOperatingSystemRoot_CapabilityDataFile();

		/**
		 * The meta object literal for the '<em><b>Capability Directory</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_DIRECTORY = eINSTANCE
				.getOperatingSystemRoot_CapabilityDirectory();

		/**
		 * The meta object literal for the '<em><b>Capability File System</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM = eINSTANCE
				.getOperatingSystemRoot_CapabilityFileSystem();

		/**
		 * The meta object literal for the '<em><b>Capability File System Content</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_FILE_SYSTEM_CONTENT = eINSTANCE
				.getOperatingSystemRoot_CapabilityFileSystemContent();

		/**
		 * The meta object literal for the '<em><b>Capability Linux Local Group</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_GROUP = eINSTANCE
				.getOperatingSystemRoot_CapabilityLinuxLocalGroup();

		/**
		 * The meta object literal for the '<em><b>Capability Linux Local Service</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_SERVICE = eINSTANCE
				.getOperatingSystemRoot_CapabilityLinuxLocalService();

		/**
		 * The meta object literal for the '<em><b>Capability Linux Local User</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_LOCAL_USER = eINSTANCE
				.getOperatingSystemRoot_CapabilityLinuxLocalUser();

		/**
		 * The meta object literal for the '<em><b>Capability Linux Operating System</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_LINUX_OPERATING_SYSTEM = eINSTANCE
				.getOperatingSystemRoot_CapabilityLinuxOperatingSystem();

		/**
		 * The meta object literal for the '<em><b>Capability Local File System</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_LOCAL_FILE_SYSTEM = eINSTANCE
				.getOperatingSystemRoot_CapabilityLocalFileSystem();

		/**
		 * The meta object literal for the '<em><b>Capability NFS File System</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_NFS_FILE_SYSTEM = eINSTANCE
				.getOperatingSystemRoot_CapabilityNFSFileSystem();

		/**
		 * The meta object literal for the '<em><b>Capability Open Vms File System</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_OPEN_VMS_FILE_SYSTEM = eINSTANCE
				.getOperatingSystemRoot_CapabilityOpenVmsFileSystem();

		/**
		 * The meta object literal for the '<em><b>Capability Operating System</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_OPERATING_SYSTEM = eINSTANCE
				.getOperatingSystemRoot_CapabilityOperatingSystem();

		/**
		 * The meta object literal for the '<em><b>Capability Port</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_PORT = eINSTANCE
				.getOperatingSystemRoot_CapabilityPort();

		/**
		 * The meta object literal for the '<em><b>Capability Port Consumer</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_PORT_CONSUMER = eINSTANCE
				.getOperatingSystemRoot_CapabilityPortConsumer();

		/**
		 * The meta object literal for the '<em><b>Capability Redhat Linux Local Group</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_GROUP = eINSTANCE
				.getOperatingSystemRoot_CapabilityRedhatLinuxLocalGroup();

		/**
		 * The meta object literal for the '<em><b>Capability Redhat Linux Local Service</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_SERVICE = eINSTANCE
				.getOperatingSystemRoot_CapabilityRedhatLinuxLocalService();

		/**
		 * The meta object literal for the '<em><b>Capability Redhat Linux Local User</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_LOCAL_USER = eINSTANCE
				.getOperatingSystemRoot_CapabilityRedhatLinuxLocalUser();

		/**
		 * The meta object literal for the '<em><b>Capability Redhat Linux Operating System</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_REDHAT_LINUX_OPERATING_SYSTEM = eINSTANCE
				.getOperatingSystemRoot_CapabilityRedhatLinuxOperatingSystem();

		/**
		 * The meta object literal for the '<em><b>Capability Remote File System</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_REMOTE_FILE_SYSTEM = eINSTANCE
				.getOperatingSystemRoot_CapabilityRemoteFileSystem();

		/**
		 * The meta object literal for the '<em><b>Capability SMB File System</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_SMB_FILE_SYSTEM = eINSTANCE
				.getOperatingSystemRoot_CapabilitySMBFileSystem();

		/**
		 * The meta object literal for the '<em><b>Capability Solaris File System</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_SOLARIS_FILE_SYSTEM = eINSTANCE
				.getOperatingSystemRoot_CapabilitySolarisFileSystem();

		/**
		 * The meta object literal for the '<em><b>Capability Suse Linux Local Group</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_GROUP = eINSTANCE
				.getOperatingSystemRoot_CapabilitySuseLinuxLocalGroup();

		/**
		 * The meta object literal for the '<em><b>Capability Suse Linux Local Service</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_SERVICE = eINSTANCE
				.getOperatingSystemRoot_CapabilitySuseLinuxLocalService();

		/**
		 * The meta object literal for the '<em><b>Capability Suse Linux Local User</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_LOCAL_USER = eINSTANCE
				.getOperatingSystemRoot_CapabilitySuseLinuxLocalUser();

		/**
		 * The meta object literal for the '<em><b>Capability Suse Linux Operating System</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_SUSE_LINUX_OPERATING_SYSTEM = eINSTANCE
				.getOperatingSystemRoot_CapabilitySuseLinuxOperatingSystem();

		/**
		 * The meta object literal for the '<em><b>Capability Unix Directory</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_UNIX_DIRECTORY = eINSTANCE
				.getOperatingSystemRoot_CapabilityUnixDirectory();

		/**
		 * The meta object literal for the '<em><b>Capability Unix File System</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_UNIX_FILE_SYSTEM = eINSTANCE
				.getOperatingSystemRoot_CapabilityUnixFileSystem();

		/**
		 * The meta object literal for the '<em><b>Capability User</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_USER = eINSTANCE
				.getOperatingSystemRoot_CapabilityUser();

		/**
		 * The meta object literal for the '<em><b>Capability User Group</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_USER_GROUP = eINSTANCE
				.getOperatingSystemRoot_CapabilityUserGroup();

		/**
		 * The meta object literal for the '<em><b>Capability Windows Directory</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_DIRECTORY = eINSTANCE
				.getOperatingSystemRoot_CapabilityWindowsDirectory();

		/**
		 * The meta object literal for the '<em><b>Capability Windows File System</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_FILE_SYSTEM = eINSTANCE
				.getOperatingSystemRoot_CapabilityWindowsFileSystem();

		/**
		 * The meta object literal for the '<em><b>Capability Windows Local Group</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_GROUP = eINSTANCE
				.getOperatingSystemRoot_CapabilityWindowsLocalGroup();

		/**
		 * The meta object literal for the '<em><b>Capability Windows Local Service</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_SERVICE = eINSTANCE
				.getOperatingSystemRoot_CapabilityWindowsLocalService();

		/**
		 * The meta object literal for the '<em><b>Capability Windows Local User</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_LOCAL_USER = eINSTANCE
				.getOperatingSystemRoot_CapabilityWindowsLocalUser();

		/**
		 * The meta object literal for the '<em><b>Capability Windows Operating System</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__CAPABILITY_WINDOWS_OPERATING_SYSTEM = eINSTANCE
				.getOperatingSystemRoot_CapabilityWindowsOperatingSystem();

		/**
		 * The meta object literal for the '<em><b>Unit Aix Local Group</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_GROUP = eINSTANCE
				.getOperatingSystemRoot_UnitAixLocalGroup();

		/**
		 * The meta object literal for the '<em><b>Unit Aix Local Service Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_SERVICE_UNIT = eINSTANCE
				.getOperatingSystemRoot_UnitAixLocalServiceUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Aix Local User</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__UNIT_AIX_LOCAL_USER = eINSTANCE
				.getOperatingSystemRoot_UnitAixLocalUser();

		/**
		 * The meta object literal for the '<em><b>Unit Aix Operating System Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__UNIT_AIX_OPERATING_SYSTEM_UNIT = eINSTANCE
				.getOperatingSystemRoot_UnitAixOperatingSystemUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Data File Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__UNIT_DATA_FILE_UNIT = eINSTANCE
				.getOperatingSystemRoot_UnitDataFileUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Directory Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__UNIT_DIRECTORY_UNIT = eINSTANCE
				.getOperatingSystemRoot_UnitDirectoryUnit();

		/**
		 * The meta object literal for the '<em><b>Unit File System Content Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_CONTENT_UNIT = eINSTANCE
				.getOperatingSystemRoot_UnitFileSystemContentUnit();

		/**
		 * The meta object literal for the '<em><b>Unit File System Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__UNIT_FILE_SYSTEM_UNIT = eINSTANCE
				.getOperatingSystemRoot_UnitFileSystemUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Linux Local Group</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_GROUP = eINSTANCE
				.getOperatingSystemRoot_UnitLinuxLocalGroup();

		/**
		 * The meta object literal for the '<em><b>Unit Linux Local Service Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_SERVICE_UNIT = eINSTANCE
				.getOperatingSystemRoot_UnitLinuxLocalServiceUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Linux Local User</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__UNIT_LINUX_LOCAL_USER = eINSTANCE
				.getOperatingSystemRoot_UnitLinuxLocalUser();

		/**
		 * The meta object literal for the '<em><b>Unit Linux Operating System Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__UNIT_LINUX_OPERATING_SYSTEM_UNIT = eINSTANCE
				.getOperatingSystemRoot_UnitLinuxOperatingSystemUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Local File System Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__UNIT_LOCAL_FILE_SYSTEM_UNIT = eINSTANCE
				.getOperatingSystemRoot_UnitLocalFileSystemUnit();

		/**
		 * The meta object literal for the '<em><b>Unit NFS File System Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__UNIT_NFS_FILE_SYSTEM_UNIT = eINSTANCE
				.getOperatingSystemRoot_UnitNFSFileSystemUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Open Vms File System Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__UNIT_OPEN_VMS_FILE_SYSTEM_UNIT = eINSTANCE
				.getOperatingSystemRoot_UnitOpenVmsFileSystemUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Operating System Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__UNIT_OPERATING_SYSTEM_UNIT = eINSTANCE
				.getOperatingSystemRoot_UnitOperatingSystemUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Port Config Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__UNIT_PORT_CONFIG_UNIT = eINSTANCE
				.getOperatingSystemRoot_UnitPortConfigUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Remote File System Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__UNIT_REMOTE_FILE_SYSTEM_UNIT = eINSTANCE
				.getOperatingSystemRoot_UnitRemoteFileSystemUnit();

		/**
		 * The meta object literal for the '<em><b>Unit SMB File System Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__UNIT_SMB_FILE_SYSTEM_UNIT = eINSTANCE
				.getOperatingSystemRoot_UnitSMBFileSystemUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Solaris File System Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__UNIT_SOLARIS_FILE_SYSTEM_UNIT = eINSTANCE
				.getOperatingSystemRoot_UnitSolarisFileSystemUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Unix File System Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__UNIT_UNIX_FILE_SYSTEM_UNIT = eINSTANCE
				.getOperatingSystemRoot_UnitUnixFileSystemUnit();

		/**
		 * The meta object literal for the '<em><b>Unit User</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__UNIT_USER = eINSTANCE.getOperatingSystemRoot_UnitUser();

		/**
		 * The meta object literal for the '<em><b>Unit User Group</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__UNIT_USER_GROUP = eINSTANCE
				.getOperatingSystemRoot_UnitUserGroup();

		/**
		 * The meta object literal for the '<em><b>Unit Windows File System Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_FILE_SYSTEM_UNIT = eINSTANCE
				.getOperatingSystemRoot_UnitWindowsFileSystemUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Windows Local Group</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_GROUP = eINSTANCE
				.getOperatingSystemRoot_UnitWindowsLocalGroup();

		/**
		 * The meta object literal for the '<em><b>Unit Windows Local Service Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_SERVICE_UNIT = eINSTANCE
				.getOperatingSystemRoot_UnitWindowsLocalServiceUnit();

		/**
		 * The meta object literal for the '<em><b>Unit Windows Local User</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_LOCAL_USER = eINSTANCE
				.getOperatingSystemRoot_UnitWindowsLocalUser();

		/**
		 * The meta object literal for the '<em><b>Unit Windows Operating System Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM_ROOT__UNIT_WINDOWS_OPERATING_SYSTEM_UNIT = eINSTANCE
				.getOperatingSystemRoot_UnitWindowsOperatingSystemUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.OperatingSystemUnitImpl <em>Operating System Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.OperatingSystemUnitImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getOperatingSystemUnit()
		 * @generated
		 */
		EClass OPERATING_SYSTEM_UNIT = eINSTANCE.getOperatingSystemUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.PortImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getPort()
		 * @generated
		 */
		EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '<em><b>Application Layer Protocol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__APPLICATION_LAYER_PROTOCOL = eINSTANCE.getPort_ApplicationLayerProtocol();

		/**
		 * The meta object literal for the '<em><b>Ip Address Or Hostname</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__IP_ADDRESS_OR_HOSTNAME = eINSTANCE.getPort_IpAddressOrHostname();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__PORT = eINSTANCE.getPort_Port();

		/**
		 * The meta object literal for the '<em><b>Port Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PORT__PORT_NAME = eINSTANCE.getPort_PortName();

		/**
		 * The meta object literal for the '<em><b>Transport Layer Protocol</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__TRANSPORT_LAYER_PROTOCOL = eINSTANCE.getPort_TransportLayerProtocol();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.PortConfigUnitImpl <em>Port Config Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.PortConfigUnitImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getPortConfigUnit()
		 * @generated
		 */
		EClass PORT_CONFIG_UNIT = eINSTANCE.getPortConfigUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.PortConsumerImpl <em>Port Consumer</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.PortConsumerImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getPortConsumer()
		 * @generated
		 */
		EClass PORT_CONSUMER = eINSTANCE.getPortConsumer();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.RedhatLinuxLocalGroupImpl <em>Redhat Linux Local Group</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.RedhatLinuxLocalGroupImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getRedhatLinuxLocalGroup()
		 * @generated
		 */
		EClass REDHAT_LINUX_LOCAL_GROUP = eINSTANCE.getRedhatLinuxLocalGroup();

		/**
		 * The meta object literal for the '<em><b>Group Sid</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute REDHAT_LINUX_LOCAL_GROUP__GROUP_SID = eINSTANCE
				.getRedhatLinuxLocalGroup_GroupSid();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.RedhatLinuxLocalServiceImpl <em>Redhat Linux Local Service</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.RedhatLinuxLocalServiceImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getRedhatLinuxLocalService()
		 * @generated
		 */
		EClass REDHAT_LINUX_LOCAL_SERVICE = eINSTANCE.getRedhatLinuxLocalService();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.RedhatLinuxLocalUserImpl <em>Redhat Linux Local User</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.RedhatLinuxLocalUserImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getRedhatLinuxLocalUser()
		 * @generated
		 */
		EClass REDHAT_LINUX_LOCAL_USER = eINSTANCE.getRedhatLinuxLocalUser();

		/**
		 * The meta object literal for the '<em><b>Account Disable After Days</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REDHAT_LINUX_LOCAL_USER__ACCOUNT_DISABLE_AFTER_DAYS = eINSTANCE
				.getRedhatLinuxLocalUser_AccountDisableAfterDays();

		/**
		 * The meta object literal for the '<em><b>Account Disable Date</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REDHAT_LINUX_LOCAL_USER__ACCOUNT_DISABLE_DATE = eINSTANCE
				.getRedhatLinuxLocalUser_AccountDisableDate();

		/**
		 * The meta object literal for the '<em><b>Days Before Password May Change</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REDHAT_LINUX_LOCAL_USER__DAYS_BEFORE_PASSWORD_MAY_CHANGE = eINSTANCE
				.getRedhatLinuxLocalUser_DaysBeforePasswordMayChange();

		/**
		 * The meta object literal for the '<em><b>Last Password Change</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REDHAT_LINUX_LOCAL_USER__LAST_PASSWORD_CHANGE = eINSTANCE
				.getRedhatLinuxLocalUser_LastPasswordChange();

		/**
		 * The meta object literal for the '<em><b>Password Expire After Days</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REDHAT_LINUX_LOCAL_USER__PASSWORD_EXPIRE_AFTER_DAYS = eINSTANCE
				.getRedhatLinuxLocalUser_PasswordExpireAfterDays();

		/**
		 * The meta object literal for the '<em><b>Password Expire Warning Days</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REDHAT_LINUX_LOCAL_USER__PASSWORD_EXPIRE_WARNING_DAYS = eINSTANCE
				.getRedhatLinuxLocalUser_PasswordExpireWarningDays();

		/**
		 * The meta object literal for the '<em><b>User Sid</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute REDHAT_LINUX_LOCAL_USER__USER_SID = eINSTANCE.getRedhatLinuxLocalUser_UserSid();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.RedhatLinuxOperatingSystemImpl <em>Redhat Linux Operating System</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.RedhatLinuxOperatingSystemImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getRedhatLinuxOperatingSystem()
		 * @generated
		 */
		EClass REDHAT_LINUX_OPERATING_SYSTEM = eINSTANCE.getRedhatLinuxOperatingSystem();

		/**
		 * The meta object literal for the '<em><b>Boot Loader</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute REDHAT_LINUX_OPERATING_SYSTEM__BOOT_LOADER = eINSTANCE
				.getRedhatLinuxOperatingSystem_BootLoader();

		/**
		 * The meta object literal for the '<em><b>Desktop</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute REDHAT_LINUX_OPERATING_SYSTEM__DESKTOP = eINSTANCE
				.getRedhatLinuxOperatingSystem_Desktop();

		/**
		 * The meta object literal for the '<em><b>Install Date</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute REDHAT_LINUX_OPERATING_SYSTEM__INSTALL_DATE = eINSTANCE
				.getRedhatLinuxOperatingSystem_InstallDate();

		/**
		 * The meta object literal for the '<em><b>Last Boot Up Time</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REDHAT_LINUX_OPERATING_SYSTEM__LAST_BOOT_UP_TIME = eINSTANCE
				.getRedhatLinuxOperatingSystem_LastBootUpTime();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute REDHAT_LINUX_OPERATING_SYSTEM__OWNER = eINSTANCE
				.getRedhatLinuxOperatingSystem_Owner();

		/**
		 * The meta object literal for the '<em><b>Product Type</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute REDHAT_LINUX_OPERATING_SYSTEM__PRODUCT_TYPE = eINSTANCE
				.getRedhatLinuxOperatingSystem_ProductType();

		/**
		 * The meta object literal for the '<em><b>SE Linux State</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REDHAT_LINUX_OPERATING_SYSTEM__SE_LINUX_STATE = eINSTANCE
				.getRedhatLinuxOperatingSystem_SELinuxState();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.RemoteFileSystemImpl <em>Remote File System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.RemoteFileSystemImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getRemoteFileSystem()
		 * @generated
		 */
		EClass REMOTE_FILE_SYSTEM = eINSTANCE.getRemoteFileSystem();

		/**
		 * The meta object literal for the '<em><b>Export Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REMOTE_FILE_SYSTEM__EXPORT_NAME = eINSTANCE.getRemoteFileSystem_ExportName();

		/**
		 * The meta object literal for the '<em><b>Server Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REMOTE_FILE_SYSTEM__SERVER_NAME = eINSTANCE.getRemoteFileSystem_ServerName();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.RemoteFileSystemUnitImpl <em>Remote File System Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.RemoteFileSystemUnitImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getRemoteFileSystemUnit()
		 * @generated
		 */
		EClass REMOTE_FILE_SYSTEM_UNIT = eINSTANCE.getRemoteFileSystemUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.SMBFileSystemImpl <em>SMB File System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.SMBFileSystemImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getSMBFileSystem()
		 * @generated
		 */
		EClass SMB_FILE_SYSTEM = eINSTANCE.getSMBFileSystem();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.SMBFileSystemUnitImpl <em>SMB File System Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.SMBFileSystemUnitImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getSMBFileSystemUnit()
		 * @generated
		 */
		EClass SMB_FILE_SYSTEM_UNIT = eINSTANCE.getSMBFileSystemUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.SolarisFileSystemImpl <em>Solaris File System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.SolarisFileSystemImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getSolarisFileSystem()
		 * @generated
		 */
		EClass SOLARIS_FILE_SYSTEM = eINSTANCE.getSolarisFileSystem();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.SolarisFileSystemUnitImpl <em>Solaris File System Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.SolarisFileSystemUnitImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getSolarisFileSystemUnit()
		 * @generated
		 */
		EClass SOLARIS_FILE_SYSTEM_UNIT = eINSTANCE.getSolarisFileSystemUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.SUSELinuxLocalGroupImpl <em>SUSE Linux Local Group</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.SUSELinuxLocalGroupImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getSUSELinuxLocalGroup()
		 * @generated
		 */
		EClass SUSE_LINUX_LOCAL_GROUP = eINSTANCE.getSUSELinuxLocalGroup();

		/**
		 * The meta object literal for the '<em><b>Group Id</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SUSE_LINUX_LOCAL_GROUP__GROUP_ID = eINSTANCE.getSUSELinuxLocalGroup_GroupId();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.SUSELinuxLocalServiceImpl <em>SUSE Linux Local Service</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.SUSELinuxLocalServiceImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getSUSELinuxLocalService()
		 * @generated
		 */
		EClass SUSE_LINUX_LOCAL_SERVICE = eINSTANCE.getSUSELinuxLocalService();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.SUSELinuxLocalUserImpl <em>SUSE Linux Local User</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.SUSELinuxLocalUserImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getSUSELinuxLocalUser()
		 * @generated
		 */
		EClass SUSE_LINUX_LOCAL_USER = eINSTANCE.getSUSELinuxLocalUser();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.SUSELinuxOperatingSystemImpl <em>SUSE Linux Operating System</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.SUSELinuxOperatingSystemImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getSUSELinuxOperatingSystem()
		 * @generated
		 */
		EClass SUSE_LINUX_OPERATING_SYSTEM = eINSTANCE.getSUSELinuxOperatingSystem();

		/**
		 * The meta object literal for the '<em><b>Boot Loader</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SUSE_LINUX_OPERATING_SYSTEM__BOOT_LOADER = eINSTANCE
				.getSUSELinuxOperatingSystem_BootLoader();

		/**
		 * The meta object literal for the '<em><b>Desktop</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SUSE_LINUX_OPERATING_SYSTEM__DESKTOP = eINSTANCE
				.getSUSELinuxOperatingSystem_Desktop();

		/**
		 * The meta object literal for the '<em><b>Last Boot Up Date</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUSE_LINUX_OPERATING_SYSTEM__LAST_BOOT_UP_DATE = eINSTANCE
				.getSUSELinuxOperatingSystem_LastBootUpDate();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.UnixDirectoryImpl <em>Unix Directory</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.UnixDirectoryImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getUnixDirectory()
		 * @generated
		 */
		EClass UNIX_DIRECTORY = eINSTANCE.getUnixDirectory();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.UnixFileSystemImpl <em>Unix File System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.UnixFileSystemImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getUnixFileSystem()
		 * @generated
		 */
		EClass UNIX_FILE_SYSTEM = eINSTANCE.getUnixFileSystem();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.UnixFileSystemUnitImpl <em>Unix File System Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.UnixFileSystemUnitImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getUnixFileSystemUnit()
		 * @generated
		 */
		EClass UNIX_FILE_SYSTEM_UNIT = eINSTANCE.getUnixFileSystemUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.UserImpl <em>User</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.UserImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getUser()
		 * @generated
		 */
		EClass USER = eINSTANCE.getUser();

		/**
		 * The meta object literal for the '<em><b>User Id</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute USER__USER_ID = eINSTANCE.getUser_UserId();

		/**
		 * The meta object literal for the '<em><b>User Password</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USER__USER_PASSWORD = eINSTANCE.getUser_UserPassword();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.UserGroupImpl <em>User Group</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.UserGroupImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getUserGroup()
		 * @generated
		 */
		EClass USER_GROUP = eINSTANCE.getUserGroup();

		/**
		 * The meta object literal for the '<em><b>Group Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute USER_GROUP__GROUP_NAME = eINSTANCE.getUserGroup_GroupName();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.UserGroupUnitImpl <em>User Group Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.UserGroupUnitImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getUserGroupUnit()
		 * @generated
		 */
		EClass USER_GROUP_UNIT = eINSTANCE.getUserGroupUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.UserUnitImpl <em>User Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.UserUnitImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getUserUnit()
		 * @generated
		 */
		EClass USER_UNIT = eINSTANCE.getUserUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.WindowsDirectoryImpl <em>Windows Directory</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.WindowsDirectoryImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsDirectory()
		 * @generated
		 */
		EClass WINDOWS_DIRECTORY = eINSTANCE.getWindowsDirectory();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.WindowsFileSystemImpl <em>Windows File System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.WindowsFileSystemImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsFileSystem()
		 * @generated
		 */
		EClass WINDOWS_FILE_SYSTEM = eINSTANCE.getWindowsFileSystem();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.WindowsFileSystemUnitImpl <em>Windows File System Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.WindowsFileSystemUnitImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsFileSystemUnit()
		 * @generated
		 */
		EClass WINDOWS_FILE_SYSTEM_UNIT = eINSTANCE.getWindowsFileSystemUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalGroupImpl <em>Windows Local Group</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.WindowsLocalGroupImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsLocalGroup()
		 * @generated
		 */
		EClass WINDOWS_LOCAL_GROUP = eINSTANCE.getWindowsLocalGroup();

		/**
		 * The meta object literal for the '<em><b>Description1</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WINDOWS_LOCAL_GROUP__DESCRIPTION1 = eINSTANCE.getWindowsLocalGroup_Description1();

		/**
		 * The meta object literal for the '<em><b>Group Sid</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WINDOWS_LOCAL_GROUP__GROUP_SID = eINSTANCE.getWindowsLocalGroup_GroupSid();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalGroupUnitImpl <em>Windows Local Group Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.WindowsLocalGroupUnitImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsLocalGroupUnit()
		 * @generated
		 */
		EClass WINDOWS_LOCAL_GROUP_UNIT = eINSTANCE.getWindowsLocalGroupUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalServiceImpl <em>Windows Local Service</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.WindowsLocalServiceImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsLocalService()
		 * @generated
		 */
		EClass WINDOWS_LOCAL_SERVICE = eINSTANCE.getWindowsLocalService();

		/**
		 * The meta object literal for the '<em><b>Dependant Components</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWS_LOCAL_SERVICE__DEPENDANT_COMPONENTS = eINSTANCE
				.getWindowsLocalService_DependantComponents();

		/**
		 * The meta object literal for the '<em><b>Error Control</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWS_LOCAL_SERVICE__ERROR_CONTROL = eINSTANCE
				.getWindowsLocalService_ErrorControl();

		/**
		 * The meta object literal for the '<em><b>Executable Path</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWS_LOCAL_SERVICE__EXECUTABLE_PATH = eINSTANCE
				.getWindowsLocalService_ExecutablePath();

		/**
		 * The meta object literal for the '<em><b>Log On As System</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWS_LOCAL_SERVICE__LOG_ON_AS_SYSTEM = eINSTANCE
				.getWindowsLocalService_LogOnAsSystem();

		/**
		 * The meta object literal for the '<em><b>Run Program</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WINDOWS_LOCAL_SERVICE__RUN_PROGRAM = eINSTANCE.getWindowsLocalService_RunProgram();

		/**
		 * The meta object literal for the '<em><b>Service Account</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWS_LOCAL_SERVICE__SERVICE_ACCOUNT = eINSTANCE
				.getWindowsLocalService_ServiceAccount();

		/**
		 * The meta object literal for the '<em><b>Service Account Password</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWS_LOCAL_SERVICE__SERVICE_ACCOUNT_PASSWORD = eINSTANCE
				.getWindowsLocalService_ServiceAccountPassword();

		/**
		 * The meta object literal for the '<em><b>Service Dependencies</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWS_LOCAL_SERVICE__SERVICE_DEPENDENCIES = eINSTANCE
				.getWindowsLocalService_ServiceDependencies();

		/**
		 * The meta object literal for the '<em><b>Service Description</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWS_LOCAL_SERVICE__SERVICE_DESCRIPTION = eINSTANCE
				.getWindowsLocalService_ServiceDescription();

		/**
		 * The meta object literal for the '<em><b>Service Display Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWS_LOCAL_SERVICE__SERVICE_DISPLAY_NAME = eINSTANCE
				.getWindowsLocalService_ServiceDisplayName();

		/**
		 * The meta object literal for the '<em><b>Service Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WINDOWS_LOCAL_SERVICE__SERVICE_NAME = eINSTANCE
				.getWindowsLocalService_ServiceName();

		/**
		 * The meta object literal for the '<em><b>Service Status</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWS_LOCAL_SERVICE__SERVICE_STATUS = eINSTANCE
				.getWindowsLocalService_ServiceStatus();

		/**
		 * The meta object literal for the '<em><b>Start Params</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WINDOWS_LOCAL_SERVICE__START_PARAMS = eINSTANCE
				.getWindowsLocalService_StartParams();

		/**
		 * The meta object literal for the '<em><b>Startup Type</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WINDOWS_LOCAL_SERVICE__STARTUP_TYPE = eINSTANCE
				.getWindowsLocalService_StartupType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalServiceUnitImpl <em>Windows Local Service Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.WindowsLocalServiceUnitImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsLocalServiceUnit()
		 * @generated
		 */
		EClass WINDOWS_LOCAL_SERVICE_UNIT = eINSTANCE.getWindowsLocalServiceUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalUserImpl <em>Windows Local User</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.WindowsLocalUserImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsLocalUser()
		 * @generated
		 */
		EClass WINDOWS_LOCAL_USER = eINSTANCE.getWindowsLocalUser();

		/**
		 * The meta object literal for the '<em><b>Account Description</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWS_LOCAL_USER__ACCOUNT_DESCRIPTION = eINSTANCE
				.getWindowsLocalUser_AccountDescription();

		/**
		 * The meta object literal for the '<em><b>Account Disabled</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWS_LOCAL_USER__ACCOUNT_DISABLED = eINSTANCE
				.getWindowsLocalUser_AccountDisabled();

		/**
		 * The meta object literal for the '<em><b>Account Locked</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWS_LOCAL_USER__ACCOUNT_LOCKED = eINSTANCE.getWindowsLocalUser_AccountLocked();

		/**
		 * The meta object literal for the '<em><b>Change Password Next Logon</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWS_LOCAL_USER__CHANGE_PASSWORD_NEXT_LOGON = eINSTANCE
				.getWindowsLocalUser_ChangePasswordNextLogon();

		/**
		 * The meta object literal for the '<em><b>Enable Remote Control</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWS_LOCAL_USER__ENABLE_REMOTE_CONTROL = eINSTANCE
				.getWindowsLocalUser_EnableRemoteControl();

		/**
		 * The meta object literal for the '<em><b>Full Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WINDOWS_LOCAL_USER__FULL_NAME = eINSTANCE.getWindowsLocalUser_FullName();

		/**
		 * The meta object literal for the '<em><b>Home Folder</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WINDOWS_LOCAL_USER__HOME_FOLDER = eINSTANCE.getWindowsLocalUser_HomeFolder();

		/**
		 * The meta object literal for the '<em><b>Logon Script</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WINDOWS_LOCAL_USER__LOGON_SCRIPT = eINSTANCE.getWindowsLocalUser_LogonScript();

		/**
		 * The meta object literal for the '<em><b>Password Never Expires</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWS_LOCAL_USER__PASSWORD_NEVER_EXPIRES = eINSTANCE
				.getWindowsLocalUser_PasswordNeverExpires();

		/**
		 * The meta object literal for the '<em><b>Profile Path</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WINDOWS_LOCAL_USER__PROFILE_PATH = eINSTANCE.getWindowsLocalUser_ProfilePath();

		/**
		 * The meta object literal for the '<em><b>User Account Type</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWS_LOCAL_USER__USER_ACCOUNT_TYPE = eINSTANCE
				.getWindowsLocalUser_UserAccountType();

		/**
		 * The meta object literal for the '<em><b>User Cannot Change Password</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWS_LOCAL_USER__USER_CANNOT_CHANGE_PASSWORD = eINSTANCE
				.getWindowsLocalUser_UserCannotChangePassword();

		/**
		 * The meta object literal for the '<em><b>User Sid</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WINDOWS_LOCAL_USER__USER_SID = eINSTANCE.getWindowsLocalUser_UserSid();

		/**
		 * The meta object literal for the '<em><b>User Sid Type</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWS_LOCAL_USER__USER_SID_TYPE = eINSTANCE.getWindowsLocalUser_UserSidType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.WindowsLocalUserUnitImpl <em>Windows Local User Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.WindowsLocalUserUnitImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsLocalUserUnit()
		 * @generated
		 */
		EClass WINDOWS_LOCAL_USER_UNIT = eINSTANCE.getWindowsLocalUserUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.WindowsOperatingSystemImpl <em>Windows Operating System</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.WindowsOperatingSystemImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsOperatingSystem()
		 * @generated
		 */
		EClass WINDOWS_OPERATING_SYSTEM = eINSTANCE.getWindowsOperatingSystem();

		/**
		 * The meta object literal for the '<em><b>Company</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WINDOWS_OPERATING_SYSTEM__COMPANY = eINSTANCE.getWindowsOperatingSystem_Company();

		/**
		 * The meta object literal for the '<em><b>Domain Admin</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WINDOWS_OPERATING_SYSTEM__DOMAIN_ADMIN = eINSTANCE
				.getWindowsOperatingSystem_DomainAdmin();

		/**
		 * The meta object literal for the '<em><b>Domain Name</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WINDOWS_OPERATING_SYSTEM__DOMAIN_NAME = eINSTANCE
				.getWindowsOperatingSystem_DomainName();

		/**
		 * The meta object literal for the '<em><b>Domain Password</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWS_OPERATING_SYSTEM__DOMAIN_PASSWORD = eINSTANCE
				.getWindowsOperatingSystem_DomainPassword();

		/**
		 * The meta object literal for the '<em><b>Encryption Level</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWS_OPERATING_SYSTEM__ENCRYPTION_LEVEL = eINSTANCE
				.getWindowsOperatingSystem_EncryptionLevel();

		/**
		 * The meta object literal for the '<em><b>Install Date</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WINDOWS_OPERATING_SYSTEM__INSTALL_DATE = eINSTANCE
				.getWindowsOperatingSystem_InstallDate();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WINDOWS_OPERATING_SYSTEM__LANGUAGE = eINSTANCE
				.getWindowsOperatingSystem_Language();

		/**
		 * The meta object literal for the '<em><b>Language Group</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWS_OPERATING_SYSTEM__LANGUAGE_GROUP = eINSTANCE
				.getWindowsOperatingSystem_LanguageGroup();

		/**
		 * The meta object literal for the '<em><b>Last Boot Up Time</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWS_OPERATING_SYSTEM__LAST_BOOT_UP_TIME = eINSTANCE
				.getWindowsOperatingSystem_LastBootUpTime();

		/**
		 * The meta object literal for the '<em><b>Machine Object OU</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWS_OPERATING_SYSTEM__MACHINE_OBJECT_OU = eINSTANCE
				.getWindowsOperatingSystem_MachineObjectOU();

		/**
		 * The meta object literal for the '<em><b>Number Of Licensed Users</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWS_OPERATING_SYSTEM__NUMBER_OF_LICENSED_USERS = eINSTANCE
				.getWindowsOperatingSystem_NumberOfLicensedUsers();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WINDOWS_OPERATING_SYSTEM__OWNER = eINSTANCE.getWindowsOperatingSystem_Owner();

		/**
		 * The meta object literal for the '<em><b>Product Key</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WINDOWS_OPERATING_SYSTEM__PRODUCT_KEY = eINSTANCE
				.getWindowsOperatingSystem_ProductKey();

		/**
		 * The meta object literal for the '<em><b>Product Type</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WINDOWS_OPERATING_SYSTEM__PRODUCT_TYPE = eINSTANCE
				.getWindowsOperatingSystem_ProductType();

		/**
		 * The meta object literal for the '<em><b>System Drive</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WINDOWS_OPERATING_SYSTEM__SYSTEM_DRIVE = eINSTANCE
				.getWindowsOperatingSystem_SystemDrive();

		/**
		 * The meta object literal for the '<em><b>Windows Directory</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWS_OPERATING_SYSTEM__WINDOWS_DIRECTORY = eINSTANCE
				.getWindowsOperatingSystem_WindowsDirectory();

		/**
		 * The meta object literal for the '<em><b>Workgroup Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WINDOWS_OPERATING_SYSTEM__WORKGROUP_NAME = eINSTANCE
				.getWindowsOperatingSystem_WorkgroupName();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.impl.WindowsOperatingSystemUnitImpl <em>Windows Operating System Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.impl.WindowsOperatingSystemUnitImpl
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsOperatingSystemUnit()
		 * @generated
		 */
		EClass WINDOWS_OPERATING_SYSTEM_UNIT = eINSTANCE.getWindowsOperatingSystemUnit();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.AIXAuthMethodType <em>AIX Auth Method Type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.AIXAuthMethodType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getAIXAuthMethodType()
		 * @generated
		 */
		EEnum AIX_AUTH_METHOD_TYPE = eINSTANCE.getAIXAuthMethodType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.AIXDesktopType <em>AIX Desktop Type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.AIXDesktopType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getAIXDesktopType()
		 * @generated
		 */
		EEnum AIX_DESKTOP_TYPE = eINSTANCE.getAIXDesktopType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.AIXUserRegisteringMethodType <em>AIX User Registering Method Type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.AIXUserRegisteringMethodType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getAIXUserRegisteringMethodType()
		 * @generated
		 */
		EEnum AIX_USER_REGISTERING_METHOD_TYPE = eINSTANCE.getAIXUserRegisteringMethodType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.ArchitectureBusType <em>Architecture Bus Type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.ArchitectureBusType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getArchitectureBusType()
		 * @generated
		 */
		EEnum ARCHITECTURE_BUS_TYPE = eINSTANCE.getArchitectureBusType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.DefaultWindowsUserGroups <em>Default Windows User Groups</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.DefaultWindowsUserGroups
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getDefaultWindowsUserGroups()
		 * @generated
		 */
		EEnum DEFAULT_WINDOWS_USER_GROUPS = eINSTANCE.getDefaultWindowsUserGroups();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.EncryptionLevelType <em>Encryption Level Type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.EncryptionLevelType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getEncryptionLevelType()
		 * @generated
		 */
		EEnum ENCRYPTION_LEVEL_TYPE = eINSTANCE.getEncryptionLevelType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.KernelWidthType <em>Kernel Width Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.KernelWidthType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getKernelWidthType()
		 * @generated
		 */
		EEnum KERNEL_WIDTH_TYPE = eINSTANCE.getKernelWidthType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.LinuxServiceStartupTypeType <em>Linux Service Startup Type Type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.LinuxServiceStartupTypeType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getLinuxServiceStartupTypeType()
		 * @generated
		 */
		EEnum LINUX_SERVICE_STARTUP_TYPE_TYPE = eINSTANCE.getLinuxServiceStartupTypeType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.LinuxServiceStatusType <em>Linux Service Status Type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.LinuxServiceStatusType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getLinuxServiceStatusType()
		 * @generated
		 */
		EEnum LINUX_SERVICE_STATUS_TYPE = eINSTANCE.getLinuxServiceStatusType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.OperatingSystemType <em>Operating System Type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getOperatingSystemType()
		 * @generated
		 */
		EEnum OPERATING_SYSTEM_TYPE = eINSTANCE.getOperatingSystemType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.RedhatDesktopType <em>Redhat Desktop Type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.RedhatDesktopType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getRedhatDesktopType()
		 * @generated
		 */
		EEnum REDHAT_DESKTOP_TYPE = eINSTANCE.getRedhatDesktopType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxBootLoaderType <em>Redhat Linux Boot Loader Type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxBootLoaderType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getRedhatLinuxBootLoaderType()
		 * @generated
		 */
		EEnum REDHAT_LINUX_BOOT_LOADER_TYPE = eINSTANCE.getRedhatLinuxBootLoaderType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxProductTypeType <em>Redhat Linux Product Type Type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxProductTypeType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getRedhatLinuxProductTypeType()
		 * @generated
		 */
		EEnum REDHAT_LINUX_PRODUCT_TYPE_TYPE = eINSTANCE.getRedhatLinuxProductTypeType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxServiceStartupTypeType <em>Redhat Linux Service Startup Type Type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxServiceStartupTypeType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getRedhatLinuxServiceStartupTypeType()
		 * @generated
		 */
		EEnum REDHAT_LINUX_SERVICE_STARTUP_TYPE_TYPE = eINSTANCE
				.getRedhatLinuxServiceStartupTypeType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.RedhatLinuxServiceStatusType <em>Redhat Linux Service Status Type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxServiceStatusType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getRedhatLinuxServiceStatusType()
		 * @generated
		 */
		EEnum REDHAT_LINUX_SERVICE_STATUS_TYPE = eINSTANCE.getRedhatLinuxServiceStatusType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.SELinuxStateType <em>SE Linux State Type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.SELinuxStateType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getSELinuxStateType()
		 * @generated
		 */
		EEnum SE_LINUX_STATE_TYPE = eINSTANCE.getSELinuxStateType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.SUSEDesktopType <em>SUSE Desktop Type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.SUSEDesktopType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getSUSEDesktopType()
		 * @generated
		 */
		EEnum SUSE_DESKTOP_TYPE = eINSTANCE.getSUSEDesktopType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.SUSELinuxBootLoaderType <em>SUSE Linux Boot Loader Type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.SUSELinuxBootLoaderType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getSUSELinuxBootLoaderType()
		 * @generated
		 */
		EEnum SUSE_LINUX_BOOT_LOADER_TYPE = eINSTANCE.getSUSELinuxBootLoaderType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.SUSELinuxServiceStartupTypeType <em>SUSE Linux Service Startup Type Type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.SUSELinuxServiceStartupTypeType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getSUSELinuxServiceStartupTypeType()
		 * @generated
		 */
		EEnum SUSE_LINUX_SERVICE_STARTUP_TYPE_TYPE = eINSTANCE.getSUSELinuxServiceStartupTypeType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.SUSELinuxServiceStatusType <em>SUSE Linux Service Status Type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.SUSELinuxServiceStatusType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getSUSELinuxServiceStatusType()
		 * @generated
		 */
		EEnum SUSE_LINUX_SERVICE_STATUS_TYPE = eINSTANCE.getSUSELinuxServiceStatusType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.TransportLayerProtocolType <em>Transport Layer Protocol Type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.TransportLayerProtocolType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getTransportLayerProtocolType()
		 * @generated
		 */
		EEnum TRANSPORT_LAYER_PROTOCOL_TYPE = eINSTANCE.getTransportLayerProtocolType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.WindowsDirectoryType <em>Windows Directory Type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.WindowsDirectoryType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsDirectoryType()
		 * @generated
		 */
		EEnum WINDOWS_DIRECTORY_TYPE = eINSTANCE.getWindowsDirectoryType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.WindowsProductTypeType <em>Windows Product Type Type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.WindowsProductTypeType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsProductTypeType()
		 * @generated
		 */
		EEnum WINDOWS_PRODUCT_TYPE_TYPE = eINSTANCE.getWindowsProductTypeType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.WindowsServiceErrorControlType <em>Windows Service Error Control Type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.WindowsServiceErrorControlType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsServiceErrorControlType()
		 * @generated
		 */
		EEnum WINDOWS_SERVICE_ERROR_CONTROL_TYPE = eINSTANCE.getWindowsServiceErrorControlType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.WindowsServiceStartupType <em>Windows Service Startup Type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.WindowsServiceStartupType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsServiceStartupType()
		 * @generated
		 */
		EEnum WINDOWS_SERVICE_STARTUP_TYPE = eINSTANCE.getWindowsServiceStartupType();

		/**
		 * The meta object literal for the '{@link com.ibm.ccl.soa.deploy.os.WindowsServiceStatusType <em>Windows Service Status Type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.WindowsServiceStatusType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsServiceStatusType()
		 * @generated
		 */
		EEnum WINDOWS_SERVICE_STATUS_TYPE = eINSTANCE.getWindowsServiceStatusType();

		/**
		 * The meta object literal for the '<em>AIX Auth Method Type Object</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.os.AIXAuthMethodType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getAIXAuthMethodTypeObject()
		 * @generated
		 */
		EDataType AIX_AUTH_METHOD_TYPE_OBJECT = eINSTANCE.getAIXAuthMethodTypeObject();

		/**
		 * The meta object literal for the '<em>AIX Desktop Type Object</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.os.AIXDesktopType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getAIXDesktopTypeObject()
		 * @generated
		 */
		EDataType AIX_DESKTOP_TYPE_OBJECT = eINSTANCE.getAIXDesktopTypeObject();

		/**
		 * The meta object literal for the '<em>AIX User Registering Method Type Object</em>' data type.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.AIXUserRegisteringMethodType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getAIXUserRegisteringMethodTypeObject()
		 * @generated
		 */
		EDataType AIX_USER_REGISTERING_METHOD_TYPE_OBJECT = eINSTANCE
				.getAIXUserRegisteringMethodTypeObject();

		/**
		 * The meta object literal for the '<em>Architecture Bus Type Object</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.os.ArchitectureBusType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getArchitectureBusTypeObject()
		 * @generated
		 */
		EDataType ARCHITECTURE_BUS_TYPE_OBJECT = eINSTANCE.getArchitectureBusTypeObject();

		/**
		 * The meta object literal for the '<em>Default Windows User Groups Object</em>' data type.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.DefaultWindowsUserGroups
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getDefaultWindowsUserGroupsObject()
		 * @generated
		 */
		EDataType DEFAULT_WINDOWS_USER_GROUPS_OBJECT = eINSTANCE.getDefaultWindowsUserGroupsObject();

		/**
		 * The meta object literal for the '<em>Encryption Level Type Object</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.os.EncryptionLevelType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getEncryptionLevelTypeObject()
		 * @generated
		 */
		EDataType ENCRYPTION_LEVEL_TYPE_OBJECT = eINSTANCE.getEncryptionLevelTypeObject();

		/**
		 * The meta object literal for the '<em>Kernel Width Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.KernelWidthType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getKernelWidthTypeObject()
		 * @generated
		 */
		EDataType KERNEL_WIDTH_TYPE_OBJECT = eINSTANCE.getKernelWidthTypeObject();

		/**
		 * The meta object literal for the '<em>Linux Service Startup Type Type Object</em>' data type.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.LinuxServiceStartupTypeType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getLinuxServiceStartupTypeTypeObject()
		 * @generated
		 */
		EDataType LINUX_SERVICE_STARTUP_TYPE_TYPE_OBJECT = eINSTANCE
				.getLinuxServiceStartupTypeTypeObject();

		/**
		 * The meta object literal for the '<em>Linux Service Status Type Object</em>' data type.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.LinuxServiceStatusType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getLinuxServiceStatusTypeObject()
		 * @generated
		 */
		EDataType LINUX_SERVICE_STATUS_TYPE_OBJECT = eINSTANCE.getLinuxServiceStatusTypeObject();

		/**
		 * The meta object literal for the '<em>Operating System Type Object</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.os.OperatingSystemType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getOperatingSystemTypeObject()
		 * @generated
		 */
		EDataType OPERATING_SYSTEM_TYPE_OBJECT = eINSTANCE.getOperatingSystemTypeObject();

		/**
		 * The meta object literal for the '<em>Redhat Desktop Type Object</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.os.RedhatDesktopType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getRedhatDesktopTypeObject()
		 * @generated
		 */
		EDataType REDHAT_DESKTOP_TYPE_OBJECT = eINSTANCE.getRedhatDesktopTypeObject();

		/**
		 * The meta object literal for the '<em>Redhat Linux Boot Loader Type Object</em>' data type.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxBootLoaderType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getRedhatLinuxBootLoaderTypeObject()
		 * @generated
		 */
		EDataType REDHAT_LINUX_BOOT_LOADER_TYPE_OBJECT = eINSTANCE
				.getRedhatLinuxBootLoaderTypeObject();

		/**
		 * The meta object literal for the '<em>Redhat Linux Product Type Type Object</em>' data type.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxProductTypeType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getRedhatLinuxProductTypeTypeObject()
		 * @generated
		 */
		EDataType REDHAT_LINUX_PRODUCT_TYPE_TYPE_OBJECT = eINSTANCE
				.getRedhatLinuxProductTypeTypeObject();

		/**
		 * The meta object literal for the '<em>Redhat Linux Service Startup Type Type Object</em>' data type.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxServiceStartupTypeType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getRedhatLinuxServiceStartupTypeTypeObject()
		 * @generated
		 */
		EDataType REDHAT_LINUX_SERVICE_STARTUP_TYPE_TYPE_OBJECT = eINSTANCE
				.getRedhatLinuxServiceStartupTypeTypeObject();

		/**
		 * The meta object literal for the '<em>Redhat Linux Service Status Type Object</em>' data type.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.RedhatLinuxServiceStatusType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getRedhatLinuxServiceStatusTypeObject()
		 * @generated
		 */
		EDataType REDHAT_LINUX_SERVICE_STATUS_TYPE_OBJECT = eINSTANCE
				.getRedhatLinuxServiceStatusTypeObject();

		/**
		 * The meta object literal for the '<em>SE Linux State Type Object</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.os.SELinuxStateType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getSELinuxStateTypeObject()
		 * @generated
		 */
		EDataType SE_LINUX_STATE_TYPE_OBJECT = eINSTANCE.getSELinuxStateTypeObject();

		/**
		 * The meta object literal for the '<em>SUSE Desktop Type Object</em>' data type. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see com.ibm.ccl.soa.deploy.os.SUSEDesktopType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getSUSEDesktopTypeObject()
		 * @generated
		 */
		EDataType SUSE_DESKTOP_TYPE_OBJECT = eINSTANCE.getSUSEDesktopTypeObject();

		/**
		 * The meta object literal for the '<em>SUSE Linux Boot Loader Type Object</em>' data type.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.SUSELinuxBootLoaderType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getSUSELinuxBootLoaderTypeObject()
		 * @generated
		 */
		EDataType SUSE_LINUX_BOOT_LOADER_TYPE_OBJECT = eINSTANCE.getSUSELinuxBootLoaderTypeObject();

		/**
		 * The meta object literal for the '<em>SUSE Linux Service Startup Type Type Object</em>' data type.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.SUSELinuxServiceStartupTypeType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getSUSELinuxServiceStartupTypeTypeObject()
		 * @generated
		 */
		EDataType SUSE_LINUX_SERVICE_STARTUP_TYPE_TYPE_OBJECT = eINSTANCE
				.getSUSELinuxServiceStartupTypeTypeObject();

		/**
		 * The meta object literal for the '<em>SUSE Linux Service Status Type Object</em>' data type.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.SUSELinuxServiceStatusType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getSUSELinuxServiceStatusTypeObject()
		 * @generated
		 */
		EDataType SUSE_LINUX_SERVICE_STATUS_TYPE_OBJECT = eINSTANCE
				.getSUSELinuxServiceStatusTypeObject();

		/**
		 * The meta object literal for the '<em>TCP Port Type</em>' data type.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * @see java.math.BigInteger
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getTCPPortType()
		 * @generated
		 */
		EDataType TCP_PORT_TYPE = eINSTANCE.getTCPPortType();

		/**
		 * The meta object literal for the '<em>Transport Layer Protocol Type Object</em>' data type.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.TransportLayerProtocolType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getTransportLayerProtocolTypeObject()
		 * @generated
		 */
		EDataType TRANSPORT_LAYER_PROTOCOL_TYPE_OBJECT = eINSTANCE
				.getTransportLayerProtocolTypeObject();

		/**
		 * The meta object literal for the '<em>UDP Port Type</em>' data type.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * @see java.math.BigInteger
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getUDPPortType()
		 * @generated
		 */
		EDataType UDP_PORT_TYPE = eINSTANCE.getUDPPortType();

		/**
		 * The meta object literal for the '<em>Windows Directory Type Object</em>' data type.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.WindowsDirectoryType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsDirectoryTypeObject()
		 * @generated
		 */
		EDataType WINDOWS_DIRECTORY_TYPE_OBJECT = eINSTANCE.getWindowsDirectoryTypeObject();

		/**
		 * The meta object literal for the '<em>Windows Product Type Type Object</em>' data type.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.WindowsProductTypeType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsProductTypeTypeObject()
		 * @generated
		 */
		EDataType WINDOWS_PRODUCT_TYPE_TYPE_OBJECT = eINSTANCE.getWindowsProductTypeTypeObject();

		/**
		 * The meta object literal for the '<em>Windows Service Error Control Type Object</em>' data type.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.WindowsServiceErrorControlType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsServiceErrorControlTypeObject()
		 * @generated
		 */
		EDataType WINDOWS_SERVICE_ERROR_CONTROL_TYPE_OBJECT = eINSTANCE
				.getWindowsServiceErrorControlTypeObject();

		/**
		 * The meta object literal for the '<em>Windows Service Startup Type Object</em>' data type.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.WindowsServiceStartupType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsServiceStartupTypeObject()
		 * @generated
		 */
		EDataType WINDOWS_SERVICE_STARTUP_TYPE_OBJECT = eINSTANCE
				.getWindowsServiceStartupTypeObject();

		/**
		 * The meta object literal for the '<em>Windows Service Status Type Object</em>' data type.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see com.ibm.ccl.soa.deploy.os.WindowsServiceStatusType
		 * @see com.ibm.ccl.soa.deploy.os.impl.OsPackageImpl#getWindowsServiceStatusTypeObject()
		 * @generated
		 */
		EDataType WINDOWS_SERVICE_STATUS_TYPE_OBJECT = eINSTANCE.getWindowsServiceStatusTypeObject();

	}

} //OsPackage
