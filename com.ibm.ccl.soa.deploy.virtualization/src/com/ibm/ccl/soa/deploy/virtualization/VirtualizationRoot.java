/**
 * <copyright>
 * </copyright>
 *
 * $Id: VirtualizationRoot.java,v 1.7 2008/05/08 14:38:29 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityHypervisor <em>Capability Hypervisor</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVirtualDiskDef <em>Capability Virtual Disk Def</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVirtualDiskSnapshot <em>Capability Virtual Disk Snapshot</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVirtualEthernetNICDef <em>Capability Virtual Ethernet NIC Def</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVirtualImage <em>Capability Virtual Image</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVirtualImageCollection <em>Capability Virtual Image Collection</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVirtualImageSnapshotContainer <em>Capability Virtual Image Snapshot Container</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVirtualServerDef <em>Capability Virtual Server Def</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVirtualServerSnapshot <em>Capability Virtual Server Snapshot</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareESX <em>Capability Vmware ESX</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareHypervisor <em>Capability Vmware Hypervisor</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareVirtualDiskDef <em>Capability Vmware Virtual Disk Def</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareVirtualDiskSnapshot <em>Capability Vmware Virtual Disk Snapshot</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareVirtualEthernetNICDef <em>Capability Vmware Virtual Ethernet NIC Def</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareVirtualIDEDiskDef <em>Capability Vmware Virtual IDE Disk Def</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareVirtualImage <em>Capability Vmware Virtual Image</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareVirtualImageSnapshotContainer <em>Capability Vmware Virtual Image Snapshot Container</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareVirtualSCSIDiskDef <em>Capability Vmware Virtual SCSI Disk Def</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareVirtualServerDef <em>Capability Vmware Virtual Server Def</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareVirtualServerSnapshot <em>Capability Vmware Virtual Server Snapshot</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityXenHypervisor <em>Capability Xen Hypervisor</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityXenVirtualDiskDef <em>Capability Xen Virtual Disk Def</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityXenVirtualEthernetNICDef <em>Capability Xen Virtual Ethernet NIC Def</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityXenVirtualImage <em>Capability Xen Virtual Image</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityXenVirtualServerDef <em>Capability Xen Virtual Server Def</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVirtualDiskDefUnit <em>Unit Virtual Disk Def Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVirtualDiskSnapshotUnit <em>Unit Virtual Disk Snapshot Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVirtualEthernetNICDefUnit <em>Unit Virtual Ethernet NIC Def Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVirtualImageCollectionUnit <em>Unit Virtual Image Collection Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVirtualImageUnit <em>Unit Virtual Image Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVirtualServerSnapshotUnit <em>Unit Virtual Server Snapshot Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVmwareESXUnit <em>Unit Vmware ESX Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVmwareVirtualDiskDefUnit <em>Unit Vmware Virtual Disk Def Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVmwareVirtualDiskSnapshotUnit <em>Unit Vmware Virtual Disk Snapshot Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVmwareVirtualEthernetNICDefUnit <em>Unit Vmware Virtual Ethernet NIC Def Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVmwareVirtualImageUnit <em>Unit Vmware Virtual Image Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVmwareVirtualServerSnapshotUnit <em>Unit Vmware Virtual Server Snapshot Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitXenVirtualDiskDefUnit <em>Unit Xen Virtual Disk Def Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitXenVirtualEthernetNICDefUnit <em>Unit Xen Virtual Ethernet NIC Def Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitXenVirtualImageUnit <em>Unit Xen Virtual Image Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface VirtualizationRoot extends EObject {
	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XMLNS Prefix Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XMLNS Prefix Map</em>' map.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_XMLNSPrefixMap()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String" valueType="java.lang.String" transient="true"
	 *        extendedMetaData="kind='attribute' name='xmlns:prefix'"
	 * @generated
	 */
	EMap getXMLNSPrefixMap();

	/**
	 * Returns the value of the '<em><b>XSI Schema Location</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XSI Schema Location</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XSI Schema Location</em>' map.
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String" valueType="java.lang.String" transient="true"
	 *        extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
	 * @generated
	 */
	EMap getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Capability Hypervisor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Hypervisor</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Hypervisor</em>' containment reference.
	 * @see #setCapabilityHypervisor(Hypervisor)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_CapabilityHypervisor()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.hypervisor' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	Hypervisor getCapabilityHypervisor();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityHypervisor <em>Capability Hypervisor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Hypervisor</em>' containment reference.
	 * @see #getCapabilityHypervisor()
	 * @generated
	 */
	void setCapabilityHypervisor(Hypervisor value);

	/**
	 * Returns the value of the '<em><b>Capability Virtual Disk Def</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Virtual Disk Def</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Virtual Disk Def</em>' containment reference.
	 * @see #setCapabilityVirtualDiskDef(VirtualDiskDef)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_CapabilityVirtualDiskDef()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.virtualDiskDef' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	VirtualDiskDef getCapabilityVirtualDiskDef();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVirtualDiskDef <em>Capability Virtual Disk Def</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Virtual Disk Def</em>' containment reference.
	 * @see #getCapabilityVirtualDiskDef()
	 * @generated
	 */
	void setCapabilityVirtualDiskDef(VirtualDiskDef value);

	/**
	 * Returns the value of the '<em><b>Capability Virtual Disk Snapshot</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Virtual Disk Snapshot</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Virtual Disk Snapshot</em>' containment reference.
	 * @see #setCapabilityVirtualDiskSnapshot(VirtualDiskSnapshot)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_CapabilityVirtualDiskSnapshot()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.virtualDiskSnapshot' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	VirtualDiskSnapshot getCapabilityVirtualDiskSnapshot();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVirtualDiskSnapshot <em>Capability Virtual Disk Snapshot</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Virtual Disk Snapshot</em>' containment reference.
	 * @see #getCapabilityVirtualDiskSnapshot()
	 * @generated
	 */
	void setCapabilityVirtualDiskSnapshot(VirtualDiskSnapshot value);

	/**
	 * Returns the value of the '<em><b>Capability Virtual Ethernet NIC Def</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Virtual Ethernet NIC Def</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Virtual Ethernet NIC Def</em>' containment reference.
	 * @see #setCapabilityVirtualEthernetNICDef(VirtualEthernetNICDef)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_CapabilityVirtualEthernetNICDef()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.virtualEthernetNICDef' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	VirtualEthernetNICDef getCapabilityVirtualEthernetNICDef();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVirtualEthernetNICDef <em>Capability Virtual Ethernet NIC Def</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Virtual Ethernet NIC Def</em>' containment reference.
	 * @see #getCapabilityVirtualEthernetNICDef()
	 * @generated
	 */
	void setCapabilityVirtualEthernetNICDef(VirtualEthernetNICDef value);

	/**
	 * Returns the value of the '<em><b>Capability Virtual Image</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Virtual Image</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Virtual Image</em>' containment reference.
	 * @see #setCapabilityVirtualImage(VirtualImage)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_CapabilityVirtualImage()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.virtualImage' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	VirtualImage getCapabilityVirtualImage();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVirtualImage <em>Capability Virtual Image</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Virtual Image</em>' containment reference.
	 * @see #getCapabilityVirtualImage()
	 * @generated
	 */
	void setCapabilityVirtualImage(VirtualImage value);

	/**
	 * Returns the value of the '<em><b>Capability Virtual Image Collection</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Virtual Image Collection</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Virtual Image Collection</em>' containment reference.
	 * @see #setCapabilityVirtualImageCollection(VirtualImageCollection)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_CapabilityVirtualImageCollection()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.virtualImageCollection' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	VirtualImageCollection getCapabilityVirtualImageCollection();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVirtualImageCollection <em>Capability Virtual Image Collection</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Virtual Image Collection</em>' containment reference.
	 * @see #getCapabilityVirtualImageCollection()
	 * @generated
	 */
	void setCapabilityVirtualImageCollection(VirtualImageCollection value);

	/**
	 * Returns the value of the '<em><b>Capability Virtual Image Snapshot Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Virtual Image Snapshot Container</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Virtual Image Snapshot Container</em>' containment reference.
	 * @see #setCapabilityVirtualImageSnapshotContainer(VirtualImageSnapshotContainer)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_CapabilityVirtualImageSnapshotContainer()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.virtualImageSnapshotContainer' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	VirtualImageSnapshotContainer getCapabilityVirtualImageSnapshotContainer();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVirtualImageSnapshotContainer <em>Capability Virtual Image Snapshot Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Virtual Image Snapshot Container</em>' containment reference.
	 * @see #getCapabilityVirtualImageSnapshotContainer()
	 * @generated
	 */
	void setCapabilityVirtualImageSnapshotContainer(VirtualImageSnapshotContainer value);

	/**
	 * Returns the value of the '<em><b>Capability Virtual Server Def</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Virtual Server Def</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Virtual Server Def</em>' containment reference.
	 * @see #setCapabilityVirtualServerDef(VirtualServerDef)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_CapabilityVirtualServerDef()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.virtualServerDef' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	VirtualServerDef getCapabilityVirtualServerDef();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVirtualServerDef <em>Capability Virtual Server Def</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Virtual Server Def</em>' containment reference.
	 * @see #getCapabilityVirtualServerDef()
	 * @generated
	 */
	void setCapabilityVirtualServerDef(VirtualServerDef value);

	/**
	 * Returns the value of the '<em><b>Capability Virtual Server Snapshot</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Virtual Server Snapshot</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Virtual Server Snapshot</em>' containment reference.
	 * @see #setCapabilityVirtualServerSnapshot(VirtualServerSnapshot)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_CapabilityVirtualServerSnapshot()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.virtualServerSnapshot' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	VirtualServerSnapshot getCapabilityVirtualServerSnapshot();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVirtualServerSnapshot <em>Capability Virtual Server Snapshot</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Virtual Server Snapshot</em>' containment reference.
	 * @see #getCapabilityVirtualServerSnapshot()
	 * @generated
	 */
	void setCapabilityVirtualServerSnapshot(VirtualServerSnapshot value);

	/**
	 * Returns the value of the '<em><b>Capability Vmware ESX</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Vmware ESX</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Vmware ESX</em>' containment reference.
	 * @see #setCapabilityVmwareESX(VMwareESX)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_CapabilityVmwareESX()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.vmwareESX' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	VMwareESX getCapabilityVmwareESX();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareESX <em>Capability Vmware ESX</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Vmware ESX</em>' containment reference.
	 * @see #getCapabilityVmwareESX()
	 * @generated
	 */
	void setCapabilityVmwareESX(VMwareESX value);

	/**
	 * Returns the value of the '<em><b>Capability Vmware Hypervisor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Vmware Hypervisor</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Vmware Hypervisor</em>' containment reference.
	 * @see #setCapabilityVmwareHypervisor(VMwareHypervisor)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_CapabilityVmwareHypervisor()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.vmwareHypervisor' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	VMwareHypervisor getCapabilityVmwareHypervisor();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareHypervisor <em>Capability Vmware Hypervisor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Vmware Hypervisor</em>' containment reference.
	 * @see #getCapabilityVmwareHypervisor()
	 * @generated
	 */
	void setCapabilityVmwareHypervisor(VMwareHypervisor value);

	/**
	 * Returns the value of the '<em><b>Capability Vmware Virtual Disk Def</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Vmware Virtual Disk Def</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Vmware Virtual Disk Def</em>' containment reference.
	 * @see #setCapabilityVmwareVirtualDiskDef(VMwareVirtualDiskDef)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_CapabilityVmwareVirtualDiskDef()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.vmwareVirtualDiskDef' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	VMwareVirtualDiskDef getCapabilityVmwareVirtualDiskDef();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareVirtualDiskDef <em>Capability Vmware Virtual Disk Def</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Vmware Virtual Disk Def</em>' containment reference.
	 * @see #getCapabilityVmwareVirtualDiskDef()
	 * @generated
	 */
	void setCapabilityVmwareVirtualDiskDef(VMwareVirtualDiskDef value);

	/**
	 * Returns the value of the '<em><b>Capability Vmware Virtual Disk Snapshot</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Vmware Virtual Disk Snapshot</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Vmware Virtual Disk Snapshot</em>' containment reference.
	 * @see #setCapabilityVmwareVirtualDiskSnapshot(VMwareVirtualDiskSnapshot)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_CapabilityVmwareVirtualDiskSnapshot()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.vmwareVirtualDiskSnapshot' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	VMwareVirtualDiskSnapshot getCapabilityVmwareVirtualDiskSnapshot();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareVirtualDiskSnapshot <em>Capability Vmware Virtual Disk Snapshot</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Vmware Virtual Disk Snapshot</em>' containment reference.
	 * @see #getCapabilityVmwareVirtualDiskSnapshot()
	 * @generated
	 */
	void setCapabilityVmwareVirtualDiskSnapshot(VMwareVirtualDiskSnapshot value);

	/**
	 * Returns the value of the '<em><b>Capability Vmware Virtual Ethernet NIC Def</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Vmware Virtual Ethernet NIC Def</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Vmware Virtual Ethernet NIC Def</em>' containment reference.
	 * @see #setCapabilityVmwareVirtualEthernetNICDef(VMwareVirtualEthernetNICDef)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_CapabilityVmwareVirtualEthernetNICDef()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.vmwareVirtualEthernetNICDef' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	VMwareVirtualEthernetNICDef getCapabilityVmwareVirtualEthernetNICDef();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareVirtualEthernetNICDef <em>Capability Vmware Virtual Ethernet NIC Def</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Vmware Virtual Ethernet NIC Def</em>' containment reference.
	 * @see #getCapabilityVmwareVirtualEthernetNICDef()
	 * @generated
	 */
	void setCapabilityVmwareVirtualEthernetNICDef(VMwareVirtualEthernetNICDef value);

	/**
	 * Returns the value of the '<em><b>Capability Vmware Virtual IDE Disk Def</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Vmware Virtual IDE Disk Def</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Vmware Virtual IDE Disk Def</em>' containment reference.
	 * @see #setCapabilityVmwareVirtualIDEDiskDef(VMwareVirtualIDEDiskDef)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_CapabilityVmwareVirtualIDEDiskDef()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.vmwareVirtualIDEDiskDef' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	VMwareVirtualIDEDiskDef getCapabilityVmwareVirtualIDEDiskDef();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareVirtualIDEDiskDef <em>Capability Vmware Virtual IDE Disk Def</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Vmware Virtual IDE Disk Def</em>' containment reference.
	 * @see #getCapabilityVmwareVirtualIDEDiskDef()
	 * @generated
	 */
	void setCapabilityVmwareVirtualIDEDiskDef(VMwareVirtualIDEDiskDef value);

	/**
	 * Returns the value of the '<em><b>Capability Vmware Virtual Image</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Vmware Virtual Image</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Vmware Virtual Image</em>' containment reference.
	 * @see #setCapabilityVmwareVirtualImage(VMwareVirtualImage)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_CapabilityVmwareVirtualImage()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.vmwareVirtualImage' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	VMwareVirtualImage getCapabilityVmwareVirtualImage();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareVirtualImage <em>Capability Vmware Virtual Image</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Vmware Virtual Image</em>' containment reference.
	 * @see #getCapabilityVmwareVirtualImage()
	 * @generated
	 */
	void setCapabilityVmwareVirtualImage(VMwareVirtualImage value);

	/**
	 * Returns the value of the '<em><b>Capability Vmware Virtual Image Snapshot Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Vmware Virtual Image Snapshot Container</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Vmware Virtual Image Snapshot Container</em>' containment reference.
	 * @see #setCapabilityVmwareVirtualImageSnapshotContainer(VMwareVirtualImageSnapshotContainer)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_CapabilityVmwareVirtualImageSnapshotContainer()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.vmwareVirtualImageSnapshotContainer' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	VMwareVirtualImageSnapshotContainer getCapabilityVmwareVirtualImageSnapshotContainer();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareVirtualImageSnapshotContainer <em>Capability Vmware Virtual Image Snapshot Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Vmware Virtual Image Snapshot Container</em>' containment reference.
	 * @see #getCapabilityVmwareVirtualImageSnapshotContainer()
	 * @generated
	 */
	void setCapabilityVmwareVirtualImageSnapshotContainer(VMwareVirtualImageSnapshotContainer value);

	/**
	 * Returns the value of the '<em><b>Capability Vmware Virtual SCSI Disk Def</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Vmware Virtual SCSI Disk Def</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Vmware Virtual SCSI Disk Def</em>' containment reference.
	 * @see #setCapabilityVmwareVirtualSCSIDiskDef(VMwareVirtualSCSIDiskDef)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_CapabilityVmwareVirtualSCSIDiskDef()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.vmwareVirtualSCSIDiskDef' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	VMwareVirtualSCSIDiskDef getCapabilityVmwareVirtualSCSIDiskDef();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareVirtualSCSIDiskDef <em>Capability Vmware Virtual SCSI Disk Def</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Vmware Virtual SCSI Disk Def</em>' containment reference.
	 * @see #getCapabilityVmwareVirtualSCSIDiskDef()
	 * @generated
	 */
	void setCapabilityVmwareVirtualSCSIDiskDef(VMwareVirtualSCSIDiskDef value);

	/**
	 * Returns the value of the '<em><b>Capability Vmware Virtual Server Def</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Vmware Virtual Server Def</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Vmware Virtual Server Def</em>' containment reference.
	 * @see #setCapabilityVmwareVirtualServerDef(VMwareVirtualServerDef)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_CapabilityVmwareVirtualServerDef()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.vmwareVirtualServerDef' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	VMwareVirtualServerDef getCapabilityVmwareVirtualServerDef();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareVirtualServerDef <em>Capability Vmware Virtual Server Def</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Vmware Virtual Server Def</em>' containment reference.
	 * @see #getCapabilityVmwareVirtualServerDef()
	 * @generated
	 */
	void setCapabilityVmwareVirtualServerDef(VMwareVirtualServerDef value);

	/**
	 * Returns the value of the '<em><b>Capability Vmware Virtual Server Snapshot</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Vmware Virtual Server Snapshot</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Vmware Virtual Server Snapshot</em>' containment reference.
	 * @see #setCapabilityVmwareVirtualServerSnapshot(VMwareVirtualServerSnapshot)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_CapabilityVmwareVirtualServerSnapshot()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.vmwareVirtualServerSnapshot' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	VMwareVirtualServerSnapshot getCapabilityVmwareVirtualServerSnapshot();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityVmwareVirtualServerSnapshot <em>Capability Vmware Virtual Server Snapshot</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Vmware Virtual Server Snapshot</em>' containment reference.
	 * @see #getCapabilityVmwareVirtualServerSnapshot()
	 * @generated
	 */
	void setCapabilityVmwareVirtualServerSnapshot(VMwareVirtualServerSnapshot value);

	/**
	 * Returns the value of the '<em><b>Capability Xen Hypervisor</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Xen Hypervisor</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Xen Hypervisor</em>' containment reference.
	 * @see #setCapabilityXenHypervisor(XenHypervisor)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_CapabilityXenHypervisor()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.xenHypervisor' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	XenHypervisor getCapabilityXenHypervisor();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityXenHypervisor <em>Capability Xen Hypervisor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Xen Hypervisor</em>' containment reference.
	 * @see #getCapabilityXenHypervisor()
	 * @generated
	 */
	void setCapabilityXenHypervisor(XenHypervisor value);

	/**
	 * Returns the value of the '<em><b>Capability Xen Virtual Disk Def</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Xen Virtual Disk Def</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Xen Virtual Disk Def</em>' containment reference.
	 * @see #setCapabilityXenVirtualDiskDef(XenVirtualDiskDef)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_CapabilityXenVirtualDiskDef()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.xenVirtualDiskDef' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	XenVirtualDiskDef getCapabilityXenVirtualDiskDef();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityXenVirtualDiskDef <em>Capability Xen Virtual Disk Def</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Xen Virtual Disk Def</em>' containment reference.
	 * @see #getCapabilityXenVirtualDiskDef()
	 * @generated
	 */
	void setCapabilityXenVirtualDiskDef(XenVirtualDiskDef value);

	/**
	 * Returns the value of the '<em><b>Capability Xen Virtual Ethernet NIC Def</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Xen Virtual Ethernet NIC Def</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Xen Virtual Ethernet NIC Def</em>' containment reference.
	 * @see #setCapabilityXenVirtualEthernetNICDef(XenVirtualEthernetNICDef)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_CapabilityXenVirtualEthernetNICDef()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.xenVirtualEthernetNICDef' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	XenVirtualEthernetNICDef getCapabilityXenVirtualEthernetNICDef();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityXenVirtualEthernetNICDef <em>Capability Xen Virtual Ethernet NIC Def</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Xen Virtual Ethernet NIC Def</em>' containment reference.
	 * @see #getCapabilityXenVirtualEthernetNICDef()
	 * @generated
	 */
	void setCapabilityXenVirtualEthernetNICDef(XenVirtualEthernetNICDef value);

	/**
	 * Returns the value of the '<em><b>Capability Xen Virtual Image</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Xen Virtual Image</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Xen Virtual Image</em>' containment reference.
	 * @see #setCapabilityXenVirtualImage(XenVirtualImage)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_CapabilityXenVirtualImage()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.xenVirtualImage' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	XenVirtualImage getCapabilityXenVirtualImage();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityXenVirtualImage <em>Capability Xen Virtual Image</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Xen Virtual Image</em>' containment reference.
	 * @see #getCapabilityXenVirtualImage()
	 * @generated
	 */
	void setCapabilityXenVirtualImage(XenVirtualImage value);

	/**
	 * Returns the value of the '<em><b>Capability Xen Virtual Server Def</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Xen Virtual Server Def</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Xen Virtual Server Def</em>' containment reference.
	 * @see #setCapabilityXenVirtualServerDef(XenVirtualServerDef)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_CapabilityXenVirtualServerDef()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.xenVirtualServerDef' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	XenVirtualServerDef getCapabilityXenVirtualServerDef();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getCapabilityXenVirtualServerDef <em>Capability Xen Virtual Server Def</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Xen Virtual Server Def</em>' containment reference.
	 * @see #getCapabilityXenVirtualServerDef()
	 * @generated
	 */
	void setCapabilityXenVirtualServerDef(XenVirtualServerDef value);

	/**
	 * Returns the value of the '<em><b>Unit Virtual Disk Def Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Virtual Disk Def Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Virtual Disk Def Unit</em>' containment reference.
	 * @see #setUnitVirtualDiskDefUnit(VirtualDiskDefUnit)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_UnitVirtualDiskDefUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.virtualDiskDefUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	VirtualDiskDefUnit getUnitVirtualDiskDefUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVirtualDiskDefUnit <em>Unit Virtual Disk Def Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Virtual Disk Def Unit</em>' containment reference.
	 * @see #getUnitVirtualDiskDefUnit()
	 * @generated
	 */
	void setUnitVirtualDiskDefUnit(VirtualDiskDefUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Virtual Disk Snapshot Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Virtual Disk Snapshot Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Virtual Disk Snapshot Unit</em>' containment reference.
	 * @see #setUnitVirtualDiskSnapshotUnit(VirtualDiskSnapshotUnit)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_UnitVirtualDiskSnapshotUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.virtualDiskSnapshotUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	VirtualDiskSnapshotUnit getUnitVirtualDiskSnapshotUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVirtualDiskSnapshotUnit <em>Unit Virtual Disk Snapshot Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Virtual Disk Snapshot Unit</em>' containment reference.
	 * @see #getUnitVirtualDiskSnapshotUnit()
	 * @generated
	 */
	void setUnitVirtualDiskSnapshotUnit(VirtualDiskSnapshotUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Virtual Ethernet NIC Def Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Virtual Ethernet NIC Def Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Virtual Ethernet NIC Def Unit</em>' containment reference.
	 * @see #setUnitVirtualEthernetNICDefUnit(VirtualEthernetNICDefUnit)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_UnitVirtualEthernetNICDefUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.virtualEthernetNICDefUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	VirtualEthernetNICDefUnit getUnitVirtualEthernetNICDefUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVirtualEthernetNICDefUnit <em>Unit Virtual Ethernet NIC Def Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Virtual Ethernet NIC Def Unit</em>' containment reference.
	 * @see #getUnitVirtualEthernetNICDefUnit()
	 * @generated
	 */
	void setUnitVirtualEthernetNICDefUnit(VirtualEthernetNICDefUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Virtual Image Collection Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Virtual Image Collection Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Virtual Image Collection Unit</em>' containment reference.
	 * @see #setUnitVirtualImageCollectionUnit(VirtualImageCollectionUnit)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_UnitVirtualImageCollectionUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.virtualImageCollectionUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	VirtualImageCollectionUnit getUnitVirtualImageCollectionUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVirtualImageCollectionUnit <em>Unit Virtual Image Collection Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Virtual Image Collection Unit</em>' containment reference.
	 * @see #getUnitVirtualImageCollectionUnit()
	 * @generated
	 */
	void setUnitVirtualImageCollectionUnit(VirtualImageCollectionUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Virtual Image Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Virtual Image Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Virtual Image Unit</em>' containment reference.
	 * @see #setUnitVirtualImageUnit(VirtualImageUnit)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_UnitVirtualImageUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.virtualImageUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	VirtualImageUnit getUnitVirtualImageUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVirtualImageUnit <em>Unit Virtual Image Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Virtual Image Unit</em>' containment reference.
	 * @see #getUnitVirtualImageUnit()
	 * @generated
	 */
	void setUnitVirtualImageUnit(VirtualImageUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Virtual Server Snapshot Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Virtual Server Snapshot Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Virtual Server Snapshot Unit</em>' containment reference.
	 * @see #setUnitVirtualServerSnapshotUnit(VirtualServerSnapshotUnit)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_UnitVirtualServerSnapshotUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.virtualServerSnapshotUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	VirtualServerSnapshotUnit getUnitVirtualServerSnapshotUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVirtualServerSnapshotUnit <em>Unit Virtual Server Snapshot Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Virtual Server Snapshot Unit</em>' containment reference.
	 * @see #getUnitVirtualServerSnapshotUnit()
	 * @generated
	 */
	void setUnitVirtualServerSnapshotUnit(VirtualServerSnapshotUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Vmware ESX Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Vmware ESX Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Vmware ESX Unit</em>' containment reference.
	 * @see #setUnitVmwareESXUnit(VMwareESXUnit)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_UnitVmwareESXUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.vmwareESXUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	VMwareESXUnit getUnitVmwareESXUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVmwareESXUnit <em>Unit Vmware ESX Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Vmware ESX Unit</em>' containment reference.
	 * @see #getUnitVmwareESXUnit()
	 * @generated
	 */
	void setUnitVmwareESXUnit(VMwareESXUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Vmware Virtual Disk Def Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Vmware Virtual Disk Def Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Vmware Virtual Disk Def Unit</em>' containment reference.
	 * @see #setUnitVmwareVirtualDiskDefUnit(VMwareVirtualDiskDefUnit)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_UnitVmwareVirtualDiskDefUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.vmwareVirtualDiskDefUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	VMwareVirtualDiskDefUnit getUnitVmwareVirtualDiskDefUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVmwareVirtualDiskDefUnit <em>Unit Vmware Virtual Disk Def Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Vmware Virtual Disk Def Unit</em>' containment reference.
	 * @see #getUnitVmwareVirtualDiskDefUnit()
	 * @generated
	 */
	void setUnitVmwareVirtualDiskDefUnit(VMwareVirtualDiskDefUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Vmware Virtual Disk Snapshot Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Vmware Virtual Disk Snapshot Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Vmware Virtual Disk Snapshot Unit</em>' containment reference.
	 * @see #setUnitVmwareVirtualDiskSnapshotUnit(VMwareVirtualDiskSnapshotUnit)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_UnitVmwareVirtualDiskSnapshotUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.vmwareVirtualDiskSnapshotUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	VMwareVirtualDiskSnapshotUnit getUnitVmwareVirtualDiskSnapshotUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVmwareVirtualDiskSnapshotUnit <em>Unit Vmware Virtual Disk Snapshot Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Vmware Virtual Disk Snapshot Unit</em>' containment reference.
	 * @see #getUnitVmwareVirtualDiskSnapshotUnit()
	 * @generated
	 */
	void setUnitVmwareVirtualDiskSnapshotUnit(VMwareVirtualDiskSnapshotUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Vmware Virtual Ethernet NIC Def Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Vmware Virtual Ethernet NIC Def Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Vmware Virtual Ethernet NIC Def Unit</em>' containment reference.
	 * @see #setUnitVmwareVirtualEthernetNICDefUnit(VMwareVirtualEthernetNICDefUnit)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_UnitVmwareVirtualEthernetNICDefUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.vmwareVirtualEthernetNICDefUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	VMwareVirtualEthernetNICDefUnit getUnitVmwareVirtualEthernetNICDefUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVmwareVirtualEthernetNICDefUnit <em>Unit Vmware Virtual Ethernet NIC Def Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Vmware Virtual Ethernet NIC Def Unit</em>' containment reference.
	 * @see #getUnitVmwareVirtualEthernetNICDefUnit()
	 * @generated
	 */
	void setUnitVmwareVirtualEthernetNICDefUnit(VMwareVirtualEthernetNICDefUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Vmware Virtual Image Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Vmware Virtual Image Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Vmware Virtual Image Unit</em>' containment reference.
	 * @see #setUnitVmwareVirtualImageUnit(VMwareVirtualImageUnit)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_UnitVmwareVirtualImageUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.vmwareVirtualImageUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	VMwareVirtualImageUnit getUnitVmwareVirtualImageUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVmwareVirtualImageUnit <em>Unit Vmware Virtual Image Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Vmware Virtual Image Unit</em>' containment reference.
	 * @see #getUnitVmwareVirtualImageUnit()
	 * @generated
	 */
	void setUnitVmwareVirtualImageUnit(VMwareVirtualImageUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Vmware Virtual Server Snapshot Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Vmware Virtual Server Snapshot Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Vmware Virtual Server Snapshot Unit</em>' containment reference.
	 * @see #setUnitVmwareVirtualServerSnapshotUnit(VMwareVirtualServerSnapshotUnit)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_UnitVmwareVirtualServerSnapshotUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.vmwareVirtualServerSnapshotUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	VMwareVirtualServerSnapshotUnit getUnitVmwareVirtualServerSnapshotUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitVmwareVirtualServerSnapshotUnit <em>Unit Vmware Virtual Server Snapshot Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Vmware Virtual Server Snapshot Unit</em>' containment reference.
	 * @see #getUnitVmwareVirtualServerSnapshotUnit()
	 * @generated
	 */
	void setUnitVmwareVirtualServerSnapshotUnit(VMwareVirtualServerSnapshotUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Xen Virtual Disk Def Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Xen Virtual Disk Def Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Xen Virtual Disk Def Unit</em>' containment reference.
	 * @see #setUnitXenVirtualDiskDefUnit(XenVirtualDiskDefUnit)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_UnitXenVirtualDiskDefUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.xenVirtualDiskDefUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	XenVirtualDiskDefUnit getUnitXenVirtualDiskDefUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitXenVirtualDiskDefUnit <em>Unit Xen Virtual Disk Def Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Xen Virtual Disk Def Unit</em>' containment reference.
	 * @see #getUnitXenVirtualDiskDefUnit()
	 * @generated
	 */
	void setUnitXenVirtualDiskDefUnit(XenVirtualDiskDefUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Xen Virtual Ethernet NIC Def Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Xen Virtual Ethernet NIC Def Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Xen Virtual Ethernet NIC Def Unit</em>' containment reference.
	 * @see #setUnitXenVirtualEthernetNICDefUnit(XenVirtualEthernetNICDefUnit)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_UnitXenVirtualEthernetNICDefUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.xenVirtualEthernetNICDefUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	XenVirtualEthernetNICDefUnit getUnitXenVirtualEthernetNICDefUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitXenVirtualEthernetNICDefUnit <em>Unit Xen Virtual Ethernet NIC Def Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Xen Virtual Ethernet NIC Def Unit</em>' containment reference.
	 * @see #getUnitXenVirtualEthernetNICDefUnit()
	 * @generated
	 */
	void setUnitXenVirtualEthernetNICDefUnit(XenVirtualEthernetNICDefUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Xen Virtual Image Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Xen Virtual Image Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Xen Virtual Image Unit</em>' containment reference.
	 * @see #setUnitXenVirtualImageUnit(XenVirtualImageUnit)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualizationRoot_UnitXenVirtualImageUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.xenVirtualImageUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	XenVirtualImageUnit getUnitXenVirtualImageUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualizationRoot#getUnitXenVirtualImageUnit <em>Unit Xen Virtual Image Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Xen Virtual Image Unit</em>' containment reference.
	 * @see #getUnitXenVirtualImageUnit()
	 * @generated
	 */
	void setUnitXenVirtualImageUnit(XenVirtualImageUnit value);

} // VirtualizationRoot
