/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.derby;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Deploy Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDeployRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDeployRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDeployRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDeployRoot#getArtifactDerbyddl <em>Artifact Derbyddl</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDeployRoot#getCapabilityDerbyDatabase <em>Capability Derby Database</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDeployRoot#getCapabilityDerbyInstance <em>Capability Derby Instance</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDeployRoot#getUnitDerbyDatabaseInstanceUnit <em>Unit Derby Database Instance Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDeployRoot#getUnitDerbyDatabaseUnit <em>Unit Derby Database Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyPackage#getDerbyDeployRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface DerbyDeployRoot extends EObject {
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
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyPackage#getDerbyDeployRoot_Mixed()
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
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyPackage#getDerbyDeployRoot_XMLNSPrefixMap()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String"
	 *        valueType="java.lang.String" transient="true" extendedMetaData="kind='attribute'
	 *        name='xmlns:prefix'"
	 * @generated
	 */
	EMap getXMLNSPrefixMap();

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
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyPackage#getDerbyDeployRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String"
	 *        valueType="java.lang.String" transient="true" extendedMetaData="kind='attribute'
	 *        name='xsi:schemaLocation'"
	 * @generated
	 */
	EMap getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Artifact Derbyddl</b></em>' containment reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Artifact Derbyddl</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Artifact Derbyddl</em>' containment reference.
	 * @see #setArtifactDerbyddl(DerbyDDLArtifact)
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyPackage#getDerbyDeployRoot_ArtifactDerbyddl()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='artifact.derbyddl' namespace='##targetNamespace'
	 *        affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#artifact'"
	 * @generated
	 */
	DerbyDDLArtifact getArtifactDerbyddl();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDeployRoot#getArtifactDerbyddl <em>Artifact Derbyddl</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Artifact Derbyddl</em>' containment reference.
	 * @see #getArtifactDerbyddl()
	 * @generated
	 */
	void setArtifactDerbyddl(DerbyDDLArtifact value);

	/**
	 * Returns the value of the '<em><b>Capability Derby Database</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Derby Database</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Derby Database</em>' containment reference.
	 * @see #setCapabilityDerbyDatabase(DerbyDatabase)
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyPackage#getDerbyDeployRoot_CapabilityDerbyDatabase()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.derbyDatabase' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	DerbyDatabase getCapabilityDerbyDatabase();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDeployRoot#getCapabilityDerbyDatabase <em>Capability Derby Database</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Derby Database</em>' containment reference.
	 * @see #getCapabilityDerbyDatabase()
	 * @generated
	 */
	void setCapabilityDerbyDatabase(DerbyDatabase value);

	/**
	 * Returns the value of the '<em><b>Capability Derby Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Derby Instance</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Derby Instance</em>' containment reference.
	 * @see #setCapabilityDerbyInstance(DerbyInstance)
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyPackage#getDerbyDeployRoot_CapabilityDerbyInstance()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.derbyInstance' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	DerbyInstance getCapabilityDerbyInstance();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDeployRoot#getCapabilityDerbyInstance <em>Capability Derby Instance</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Derby Instance</em>' containment reference.
	 * @see #getCapabilityDerbyInstance()
	 * @generated
	 */
	void setCapabilityDerbyInstance(DerbyInstance value);

	/**
	 * Returns the value of the '<em><b>Unit Derby Database Instance Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Derby Database Instance Unit</em>' containment reference
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Derby Database Instance Unit</em>' containment reference.
	 * @see #setUnitDerbyDatabaseInstanceUnit(DerbyDatabaseInstanceUnit)
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyPackage#getDerbyDeployRoot_UnitDerbyDatabaseInstanceUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.derbyDatabaseInstanceUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	DerbyDatabaseInstanceUnit getUnitDerbyDatabaseInstanceUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDeployRoot#getUnitDerbyDatabaseInstanceUnit <em>Unit Derby Database Instance Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Derby Database Instance Unit</em>' containment reference.
	 * @see #getUnitDerbyDatabaseInstanceUnit()
	 * @generated
	 */
	void setUnitDerbyDatabaseInstanceUnit(DerbyDatabaseInstanceUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Derby Database Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Derby Database Unit</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Derby Database Unit</em>' containment reference.
	 * @see #setUnitDerbyDatabaseUnit(DerbyDatabaseUnit)
	 * @see com.ibm.ccl.soa.deploy.internal.derby.DerbyPackage#getDerbyDeployRoot_UnitDerbyDatabaseUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.derbyDatabaseUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	DerbyDatabaseUnit getUnitDerbyDatabaseUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.internal.derby.DerbyDeployRoot#getUnitDerbyDatabaseUnit <em>Unit Derby Database Unit</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Derby Database Unit</em>' containment reference.
	 * @see #getUnitDerbyDatabaseUnit()
	 * @generated
	 */
	void setUnitDerbyDatabaseUnit(DerbyDatabaseUnit value);

} // DerbyDeployRoot
