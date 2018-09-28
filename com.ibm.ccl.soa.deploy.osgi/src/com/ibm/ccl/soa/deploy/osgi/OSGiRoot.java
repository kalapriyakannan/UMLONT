/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.osgi;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>OS Gi Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.osgi.OSGiRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.osgi.OSGiRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.osgi.OSGiRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.osgi.OSGiRoot#getCapabilityApiPackage <em>Capability Api Package</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.osgi.OSGiRoot#getCapabilityOsgiBundle <em>Capability Osgi Bundle</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.osgi.OSGiRoot#getComponentBundle <em>Component Bundle</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.osgi.OSGiRoot#getUnitOsgiLibrary <em>Unit Osgi Library</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.osgi.OsgiPackage#getOSGiRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface OSGiRoot extends EObject {
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
	 * @see com.ibm.ccl.soa.deploy.osgi.OsgiPackage#getOSGiRoot_Mixed()
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
	 * @see com.ibm.ccl.soa.deploy.osgi.OsgiPackage#getOSGiRoot_XMLNSPrefixMap()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String" valueType="java.lang.String" transient="true"
	 *        extendedMetaData="kind='attribute' name='xmlns:prefix'"
	 * @generated
	 */
	Map getXMLNSPrefixMap();

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
	 * @see com.ibm.ccl.soa.deploy.osgi.OsgiPackage#getOSGiRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String" valueType="java.lang.String" transient="true"
	 *        extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
	 * @generated
	 */
	Map getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Capability Api Package</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Api Package</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Api Package</em>' containment reference.
	 * @see #setCapabilityApiPackage(ExportedPackage)
	 * @see com.ibm.ccl.soa.deploy.osgi.OsgiPackage#getOSGiRoot_CapabilityApiPackage()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.apiPackage' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	ExportedPackage getCapabilityApiPackage();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.osgi.OSGiRoot#getCapabilityApiPackage <em>Capability Api Package</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Api Package</em>' containment reference.
	 * @see #getCapabilityApiPackage()
	 * @generated
	 */
	void setCapabilityApiPackage(ExportedPackage value);

	/**
	 * Returns the value of the '<em><b>Capability Osgi Bundle</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Osgi Bundle</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Osgi Bundle</em>' containment reference.
	 * @see #setCapabilityOsgiBundle(BundleCapability)
	 * @see com.ibm.ccl.soa.deploy.osgi.OsgiPackage#getOSGiRoot_CapabilityOsgiBundle()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.osgiBundle' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	BundleCapability getCapabilityOsgiBundle();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.osgi.OSGiRoot#getCapabilityOsgiBundle <em>Capability Osgi Bundle</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Osgi Bundle</em>' containment reference.
	 * @see #getCapabilityOsgiBundle()
	 * @generated
	 */
	void setCapabilityOsgiBundle(BundleCapability value);

	/**
	 * Returns the value of the '<em><b>Component Bundle</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Bundle</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Bundle</em>' containment reference.
	 * @see #setComponentBundle(BundleComponent)
	 * @see com.ibm.ccl.soa.deploy.osgi.OsgiPackage#getOSGiRoot_ComponentBundle()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='component.bundle' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#baseComponent'"
	 * @generated
	 */
	BundleComponent getComponentBundle();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.osgi.OSGiRoot#getComponentBundle <em>Component Bundle</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component Bundle</em>' containment reference.
	 * @see #getComponentBundle()
	 * @generated
	 */
	void setComponentBundle(BundleComponent value);

	/**
	 * Returns the value of the '<em><b>Unit Osgi Library</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Osgi Library</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Osgi Library</em>' containment reference.
	 * @see #setUnitOsgiLibrary(Library)
	 * @see com.ibm.ccl.soa.deploy.osgi.OsgiPackage#getOSGiRoot_UnitOsgiLibrary()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.osgiLibrary' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	Library getUnitOsgiLibrary();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.osgi.OSGiRoot#getUnitOsgiLibrary <em>Unit Osgi Library</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Osgi Library</em>' containment reference.
	 * @see #getUnitOsgiLibrary()
	 * @generated
	 */
	void setUnitOsgiLibrary(Library value);

} // OSGiRoot
