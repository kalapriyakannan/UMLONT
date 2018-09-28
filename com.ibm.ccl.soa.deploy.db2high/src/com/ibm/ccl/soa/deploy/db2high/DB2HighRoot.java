/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.db2high;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DB2 High Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getCapabilityDB2BufferPool <em>Capability DB2 Buffer Pool</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getCapabilityDB2PartitionGroup <em>Capability DB2 Partition Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getCapabilityDB2TableSpace <em>Capability DB2 Table Space</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getCapailityDB2Manager <em>Capaility DB2 Manager</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2BufferPoolUnit <em>Unit DB2 Buffer Pool Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2Constraint <em>Unit DB2 Constraint</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2ConstraintUnit <em>Unit DB2 Constraint Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2Field <em>Unit DB2 Field</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2FieldUnit <em>Unit DB2 Field Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2Index <em>Unit DB2 Index</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2IndexUnit <em>Unit DB2 Index Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2ManagerUnit <em>Unit DB2 Manager Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2PartitionGroupUnit <em>Unit DB2 Partition Group Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2Permission <em>Unit DB2 Permission</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2PermissionUnit <em>Unit DB2 Permission Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2Table <em>Unit DB2 Table</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2TableSpaceUnit <em>Unit DB2 Table Space Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2TableUnit <em>Unit DB2 Table Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2User <em>Unit DB2 User</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2UserUnit <em>Unit DB2 User Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2HighRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface DB2HighRoot extends EObject {
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
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2HighRoot_Mixed()
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
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2HighRoot_XMLNSPrefixMap()
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
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2HighRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String" valueType="java.lang.String" transient="true"
	 *        extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
	 * @generated
	 */
	EMap getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Capability DB2 Buffer Pool</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability DB2 Buffer Pool</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability DB2 Buffer Pool</em>' containment reference.
	 * @see #setCapabilityDB2BufferPool(DB2BufferPool)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2HighRoot_CapabilityDB2BufferPool()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.DB2BufferPool' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	DB2BufferPool getCapabilityDB2BufferPool();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getCapabilityDB2BufferPool <em>Capability DB2 Buffer Pool</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability DB2 Buffer Pool</em>' containment reference.
	 * @see #getCapabilityDB2BufferPool()
	 * @generated
	 */
	void setCapabilityDB2BufferPool(DB2BufferPool value);

	/**
	 * Returns the value of the '<em><b>Capability DB2 Partition Group</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability DB2 Partition Group</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability DB2 Partition Group</em>' containment reference.
	 * @see #setCapabilityDB2PartitionGroup(DB2PartitionGroup)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2HighRoot_CapabilityDB2PartitionGroup()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.DB2PartitionGroup' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	DB2PartitionGroup getCapabilityDB2PartitionGroup();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getCapabilityDB2PartitionGroup <em>Capability DB2 Partition Group</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability DB2 Partition Group</em>' containment reference.
	 * @see #getCapabilityDB2PartitionGroup()
	 * @generated
	 */
	void setCapabilityDB2PartitionGroup(DB2PartitionGroup value);

	/**
	 * Returns the value of the '<em><b>Capability DB2 Table Space</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability DB2 Table Space</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability DB2 Table Space</em>' containment reference.
	 * @see #setCapabilityDB2TableSpace(DB2TableSpace)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2HighRoot_CapabilityDB2TableSpace()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.DB2TableSpace' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	DB2TableSpace getCapabilityDB2TableSpace();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getCapabilityDB2TableSpace <em>Capability DB2 Table Space</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability DB2 Table Space</em>' containment reference.
	 * @see #getCapabilityDB2TableSpace()
	 * @generated
	 */
	void setCapabilityDB2TableSpace(DB2TableSpace value);

	/**
	 * Returns the value of the '<em><b>Capaility DB2 Manager</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capaility DB2 Manager</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capaility DB2 Manager</em>' containment reference.
	 * @see #setCapailityDB2Manager(DB2Manager)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2HighRoot_CapailityDB2Manager()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capaility.DB2Manager' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	DB2Manager getCapailityDB2Manager();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getCapailityDB2Manager <em>Capaility DB2 Manager</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capaility DB2 Manager</em>' containment reference.
	 * @see #getCapailityDB2Manager()
	 * @generated
	 */
	void setCapailityDB2Manager(DB2Manager value);

	/**
	 * Returns the value of the '<em><b>Unit DB2 Buffer Pool Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit DB2 Buffer Pool Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit DB2 Buffer Pool Unit</em>' containment reference.
	 * @see #setUnitDB2BufferPoolUnit(DB2BufferPoolUnit)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2HighRoot_UnitDB2BufferPoolUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.DB2BufferPoolUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	DB2BufferPoolUnit getUnitDB2BufferPoolUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2BufferPoolUnit <em>Unit DB2 Buffer Pool Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit DB2 Buffer Pool Unit</em>' containment reference.
	 * @see #getUnitDB2BufferPoolUnit()
	 * @generated
	 */
	void setUnitDB2BufferPoolUnit(DB2BufferPoolUnit value);

	/**
	 * Returns the value of the '<em><b>Unit DB2 Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit DB2 Constraint</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit DB2 Constraint</em>' containment reference.
	 * @see #setUnitDB2Constraint(DB2Constraint)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2HighRoot_UnitDB2Constraint()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.DB2Constraint' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	DB2Constraint getUnitDB2Constraint();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2Constraint <em>Unit DB2 Constraint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit DB2 Constraint</em>' containment reference.
	 * @see #getUnitDB2Constraint()
	 * @generated
	 */
	void setUnitDB2Constraint(DB2Constraint value);

	/**
	 * Returns the value of the '<em><b>Unit DB2 Constraint Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit DB2 Constraint Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit DB2 Constraint Unit</em>' containment reference.
	 * @see #setUnitDB2ConstraintUnit(DB2ConstraintUnit)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2HighRoot_UnitDB2ConstraintUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.DB2ConstraintUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	DB2ConstraintUnit getUnitDB2ConstraintUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2ConstraintUnit <em>Unit DB2 Constraint Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit DB2 Constraint Unit</em>' containment reference.
	 * @see #getUnitDB2ConstraintUnit()
	 * @generated
	 */
	void setUnitDB2ConstraintUnit(DB2ConstraintUnit value);

	/**
	 * Returns the value of the '<em><b>Unit DB2 Field</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit DB2 Field</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit DB2 Field</em>' containment reference.
	 * @see #setUnitDB2Field(DB2Field)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2HighRoot_UnitDB2Field()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.DB2Field' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	DB2Field getUnitDB2Field();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2Field <em>Unit DB2 Field</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit DB2 Field</em>' containment reference.
	 * @see #getUnitDB2Field()
	 * @generated
	 */
	void setUnitDB2Field(DB2Field value);

	/**
	 * Returns the value of the '<em><b>Unit DB2 Field Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit DB2 Field Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit DB2 Field Unit</em>' containment reference.
	 * @see #setUnitDB2FieldUnit(DB2FieldUnit)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2HighRoot_UnitDB2FieldUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.DB2FieldUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	DB2FieldUnit getUnitDB2FieldUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2FieldUnit <em>Unit DB2 Field Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit DB2 Field Unit</em>' containment reference.
	 * @see #getUnitDB2FieldUnit()
	 * @generated
	 */
	void setUnitDB2FieldUnit(DB2FieldUnit value);

	/**
	 * Returns the value of the '<em><b>Unit DB2 Index</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit DB2 Index</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit DB2 Index</em>' containment reference.
	 * @see #setUnitDB2Index(DB2Index)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2HighRoot_UnitDB2Index()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.DB2Index' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	DB2Index getUnitDB2Index();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2Index <em>Unit DB2 Index</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit DB2 Index</em>' containment reference.
	 * @see #getUnitDB2Index()
	 * @generated
	 */
	void setUnitDB2Index(DB2Index value);

	/**
	 * Returns the value of the '<em><b>Unit DB2 Index Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit DB2 Index Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit DB2 Index Unit</em>' containment reference.
	 * @see #setUnitDB2IndexUnit(DB2IndexUnit)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2HighRoot_UnitDB2IndexUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.DB2IndexUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	DB2IndexUnit getUnitDB2IndexUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2IndexUnit <em>Unit DB2 Index Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit DB2 Index Unit</em>' containment reference.
	 * @see #getUnitDB2IndexUnit()
	 * @generated
	 */
	void setUnitDB2IndexUnit(DB2IndexUnit value);

	/**
	 * Returns the value of the '<em><b>Unit DB2 Manager Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit DB2 Manager Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit DB2 Manager Unit</em>' containment reference.
	 * @see #setUnitDB2ManagerUnit(DB2ManagerUnit)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2HighRoot_UnitDB2ManagerUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.DB2ManagerUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	DB2ManagerUnit getUnitDB2ManagerUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2ManagerUnit <em>Unit DB2 Manager Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit DB2 Manager Unit</em>' containment reference.
	 * @see #getUnitDB2ManagerUnit()
	 * @generated
	 */
	void setUnitDB2ManagerUnit(DB2ManagerUnit value);

	/**
	 * Returns the value of the '<em><b>Unit DB2 Partition Group Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit DB2 Partition Group Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit DB2 Partition Group Unit</em>' containment reference.
	 * @see #setUnitDB2PartitionGroupUnit(DB2PartitionGroupUnit)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2HighRoot_UnitDB2PartitionGroupUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.DB2PartitionGroupUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	DB2PartitionGroupUnit getUnitDB2PartitionGroupUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2PartitionGroupUnit <em>Unit DB2 Partition Group Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit DB2 Partition Group Unit</em>' containment reference.
	 * @see #getUnitDB2PartitionGroupUnit()
	 * @generated
	 */
	void setUnitDB2PartitionGroupUnit(DB2PartitionGroupUnit value);

	/**
	 * Returns the value of the '<em><b>Unit DB2 Permission</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit DB2 Permission</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit DB2 Permission</em>' containment reference.
	 * @see #setUnitDB2Permission(DB2Permission)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2HighRoot_UnitDB2Permission()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.DB2Permission' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	DB2Permission getUnitDB2Permission();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2Permission <em>Unit DB2 Permission</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit DB2 Permission</em>' containment reference.
	 * @see #getUnitDB2Permission()
	 * @generated
	 */
	void setUnitDB2Permission(DB2Permission value);

	/**
	 * Returns the value of the '<em><b>Unit DB2 Permission Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit DB2 Permission Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit DB2 Permission Unit</em>' containment reference.
	 * @see #setUnitDB2PermissionUnit(DB2PermissionUnit)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2HighRoot_UnitDB2PermissionUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.DB2PermissionUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	DB2PermissionUnit getUnitDB2PermissionUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2PermissionUnit <em>Unit DB2 Permission Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit DB2 Permission Unit</em>' containment reference.
	 * @see #getUnitDB2PermissionUnit()
	 * @generated
	 */
	void setUnitDB2PermissionUnit(DB2PermissionUnit value);

	/**
	 * Returns the value of the '<em><b>Unit DB2 Table</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit DB2 Table</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit DB2 Table</em>' containment reference.
	 * @see #setUnitDB2Table(DB2Table)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2HighRoot_UnitDB2Table()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.DB2Table' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	DB2Table getUnitDB2Table();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2Table <em>Unit DB2 Table</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit DB2 Table</em>' containment reference.
	 * @see #getUnitDB2Table()
	 * @generated
	 */
	void setUnitDB2Table(DB2Table value);

	/**
	 * Returns the value of the '<em><b>Unit DB2 Table Space Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit DB2 Table Space Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit DB2 Table Space Unit</em>' containment reference.
	 * @see #setUnitDB2TableSpaceUnit(DB2TableSpaceUnit)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2HighRoot_UnitDB2TableSpaceUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.DB2TableSpaceUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	DB2TableSpaceUnit getUnitDB2TableSpaceUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2TableSpaceUnit <em>Unit DB2 Table Space Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit DB2 Table Space Unit</em>' containment reference.
	 * @see #getUnitDB2TableSpaceUnit()
	 * @generated
	 */
	void setUnitDB2TableSpaceUnit(DB2TableSpaceUnit value);

	/**
	 * Returns the value of the '<em><b>Unit DB2 Table Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit DB2 Table Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit DB2 Table Unit</em>' containment reference.
	 * @see #setUnitDB2TableUnit(DB2TableUnit)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2HighRoot_UnitDB2TableUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.DB2TableUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	DB2TableUnit getUnitDB2TableUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2TableUnit <em>Unit DB2 Table Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit DB2 Table Unit</em>' containment reference.
	 * @see #getUnitDB2TableUnit()
	 * @generated
	 */
	void setUnitDB2TableUnit(DB2TableUnit value);

	/**
	 * Returns the value of the '<em><b>Unit DB2 User</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit DB2 User</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit DB2 User</em>' containment reference.
	 * @see #setUnitDB2User(DB2User)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2HighRoot_UnitDB2User()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.DB2User' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	DB2User getUnitDB2User();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2User <em>Unit DB2 User</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit DB2 User</em>' containment reference.
	 * @see #getUnitDB2User()
	 * @generated
	 */
	void setUnitDB2User(DB2User value);

	/**
	 * Returns the value of the '<em><b>Unit DB2 User Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit DB2 User Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit DB2 User Unit</em>' containment reference.
	 * @see #setUnitDB2UserUnit(DB2UserUnit)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2HighRoot_UnitDB2UserUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.DB2UserUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	DB2UserUnit getUnitDB2UserUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot#getUnitDB2UserUnit <em>Unit DB2 User Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit DB2 User Unit</em>' containment reference.
	 * @see #getUnitDB2UserUnit()
	 * @generated
	 */
	void setUnitDB2UserUnit(DB2UserUnit value);

} // DB2HighRoot
