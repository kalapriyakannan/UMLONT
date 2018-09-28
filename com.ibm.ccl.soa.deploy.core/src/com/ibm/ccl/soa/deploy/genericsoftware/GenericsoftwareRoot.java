/**
 * <copyright>
 * </copyright>
 *
 * $Id: GenericsoftwareRoot.java,v 1.2 2008/02/05 22:20:20 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.genericsoftware;

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
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwareRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwareRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwareRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwareRoot#getCapabilitySoftwareInstall <em>Capability Software Install</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwareRoot#getCapabilitySoftwarePatch <em>Capability Software Patch</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwareRoot#getCapabilityVersion <em>Capability Version</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwareRoot#getUnitSoftwareInstallUnit <em>Unit Software Install Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwareRoot#getUnitSoftwarePatchUnit <em>Unit Software Patch Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage#getGenericsoftwareRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface GenericsoftwareRoot extends EObject {
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
	 * @see com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage#getGenericsoftwareRoot_Mixed()
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
	 * @see com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage#getGenericsoftwareRoot_XMLNSPrefixMap()
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
	 * @see com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage#getGenericsoftwareRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String" valueType="java.lang.String" transient="true"
	 *        extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
	 * @generated
	 */
	EMap getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Capability Software Install</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Software Install</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Software Install</em>' containment reference.
	 * @see #setCapabilitySoftwareInstall(SoftwareInstall)
	 * @see com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage#getGenericsoftwareRoot_CapabilitySoftwareInstall()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.softwareInstall' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	SoftwareInstall getCapabilitySoftwareInstall();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwareRoot#getCapabilitySoftwareInstall <em>Capability Software Install</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Software Install</em>' containment reference.
	 * @see #getCapabilitySoftwareInstall()
	 * @generated
	 */
	void setCapabilitySoftwareInstall(SoftwareInstall value);

	/**
	 * Returns the value of the '<em><b>Capability Software Patch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Software Patch</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Software Patch</em>' containment reference.
	 * @see #setCapabilitySoftwarePatch(SoftwarePatch)
	 * @see com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage#getGenericsoftwareRoot_CapabilitySoftwarePatch()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.softwarePatch' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	SoftwarePatch getCapabilitySoftwarePatch();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwareRoot#getCapabilitySoftwarePatch <em>Capability Software Patch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Software Patch</em>' containment reference.
	 * @see #getCapabilitySoftwarePatch()
	 * @generated
	 */
	void setCapabilitySoftwarePatch(SoftwarePatch value);

	/**
	 * Returns the value of the '<em><b>Capability Version</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Version</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Version</em>' containment reference.
	 * @see #setCapabilityVersion(Version)
	 * @see com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage#getGenericsoftwareRoot_CapabilityVersion()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.version' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	Version getCapabilityVersion();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwareRoot#getCapabilityVersion <em>Capability Version</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Version</em>' containment reference.
	 * @see #getCapabilityVersion()
	 * @generated
	 */
	void setCapabilityVersion(Version value);

	/**
	 * Returns the value of the '<em><b>Unit Software Install Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Software Install Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Software Install Unit</em>' containment reference.
	 * @see #setUnitSoftwareInstallUnit(SoftwareInstallUnit)
	 * @see com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage#getGenericsoftwareRoot_UnitSoftwareInstallUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.softwareInstallUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	SoftwareInstallUnit getUnitSoftwareInstallUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwareRoot#getUnitSoftwareInstallUnit <em>Unit Software Install Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Software Install Unit</em>' containment reference.
	 * @see #getUnitSoftwareInstallUnit()
	 * @generated
	 */
	void setUnitSoftwareInstallUnit(SoftwareInstallUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Software Patch Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Software Patch Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Software Patch Unit</em>' containment reference.
	 * @see #setUnitSoftwarePatchUnit(SoftwarePatchUnit)
	 * @see com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage#getGenericsoftwareRoot_UnitSoftwarePatchUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.softwarePatchUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	SoftwarePatchUnit getUnitSoftwarePatchUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwareRoot#getUnitSoftwarePatchUnit <em>Unit Software Patch Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Software Patch Unit</em>' containment reference.
	 * @see #getUnitSoftwarePatchUnit()
	 * @generated
	 */
	void setUnitSoftwarePatchUnit(SoftwarePatchUnit value);

} // GenericsoftwareRoot
