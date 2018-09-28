/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.db2high.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.ibm.ccl.soa.deploy.db2high.DB2BufferPool;
import com.ibm.ccl.soa.deploy.db2high.DB2BufferPoolUnit;
import com.ibm.ccl.soa.deploy.db2high.DB2Constraint;
import com.ibm.ccl.soa.deploy.db2high.DB2ConstraintUnit;
import com.ibm.ccl.soa.deploy.db2high.DB2Field;
import com.ibm.ccl.soa.deploy.db2high.DB2FieldUnit;
import com.ibm.ccl.soa.deploy.db2high.DB2HighRoot;
import com.ibm.ccl.soa.deploy.db2high.DB2Index;
import com.ibm.ccl.soa.deploy.db2high.DB2IndexUnit;
import com.ibm.ccl.soa.deploy.db2high.DB2Manager;
import com.ibm.ccl.soa.deploy.db2high.DB2ManagerUnit;
import com.ibm.ccl.soa.deploy.db2high.DB2PartitionGroup;
import com.ibm.ccl.soa.deploy.db2high.DB2PartitionGroupUnit;
import com.ibm.ccl.soa.deploy.db2high.DB2Permission;
import com.ibm.ccl.soa.deploy.db2high.DB2PermissionUnit;
import com.ibm.ccl.soa.deploy.db2high.DB2Table;
import com.ibm.ccl.soa.deploy.db2high.DB2TableSpace;
import com.ibm.ccl.soa.deploy.db2high.DB2TableSpaceUnit;
import com.ibm.ccl.soa.deploy.db2high.DB2TableUnit;
import com.ibm.ccl.soa.deploy.db2high.DB2User;
import com.ibm.ccl.soa.deploy.db2high.DB2UserUnit;
import com.ibm.ccl.soa.deploy.db2high.Db2highPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DB2 High Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2HighRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2HighRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2HighRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2HighRootImpl#getCapabilityDB2BufferPool <em>Capability DB2 Buffer Pool</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2HighRootImpl#getCapabilityDB2PartitionGroup <em>Capability DB2 Partition Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2HighRootImpl#getCapabilityDB2TableSpace <em>Capability DB2 Table Space</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2HighRootImpl#getCapailityDB2Manager <em>Capaility DB2 Manager</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2HighRootImpl#getUnitDB2BufferPoolUnit <em>Unit DB2 Buffer Pool Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2HighRootImpl#getUnitDB2Constraint <em>Unit DB2 Constraint</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2HighRootImpl#getUnitDB2ConstraintUnit <em>Unit DB2 Constraint Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2HighRootImpl#getUnitDB2Field <em>Unit DB2 Field</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2HighRootImpl#getUnitDB2FieldUnit <em>Unit DB2 Field Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2HighRootImpl#getUnitDB2Index <em>Unit DB2 Index</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2HighRootImpl#getUnitDB2IndexUnit <em>Unit DB2 Index Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2HighRootImpl#getUnitDB2ManagerUnit <em>Unit DB2 Manager Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2HighRootImpl#getUnitDB2PartitionGroupUnit <em>Unit DB2 Partition Group Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2HighRootImpl#getUnitDB2Permission <em>Unit DB2 Permission</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2HighRootImpl#getUnitDB2PermissionUnit <em>Unit DB2 Permission Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2HighRootImpl#getUnitDB2Table <em>Unit DB2 Table</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2HighRootImpl#getUnitDB2TableSpaceUnit <em>Unit DB2 Table Space Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2HighRootImpl#getUnitDB2TableUnit <em>Unit DB2 Table Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2HighRootImpl#getUnitDB2User <em>Unit DB2 User</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2HighRootImpl#getUnitDB2UserUnit <em>Unit DB2 User Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DB2HighRootImpl extends EObjectImpl implements DB2HighRoot {
	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXMLNSPrefixMap()
	 * @generated
	 * @ordered
	 */
	protected EMap xMLNSPrefixMap;

	/**
	 * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXSISchemaLocation()
	 * @generated
	 * @ordered
	 */
	protected EMap xSISchemaLocation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DB2HighRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Db2highPackage.Literals.DB2_HIGH_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, Db2highPackage.DB2_HIGH_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, Db2highPackage.DB2_HIGH_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, Db2highPackage.DB2_HIGH_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2BufferPool getCapabilityDB2BufferPool() {
		return (DB2BufferPool)getMixed().get(Db2highPackage.Literals.DB2_HIGH_ROOT__CAPABILITY_DB2_BUFFER_POOL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityDB2BufferPool(DB2BufferPool newCapabilityDB2BufferPool, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2highPackage.Literals.DB2_HIGH_ROOT__CAPABILITY_DB2_BUFFER_POOL, newCapabilityDB2BufferPool, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityDB2BufferPool(DB2BufferPool newCapabilityDB2BufferPool) {
		((FeatureMap.Internal)getMixed()).set(Db2highPackage.Literals.DB2_HIGH_ROOT__CAPABILITY_DB2_BUFFER_POOL, newCapabilityDB2BufferPool);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2PartitionGroup getCapabilityDB2PartitionGroup() {
		return (DB2PartitionGroup)getMixed().get(Db2highPackage.Literals.DB2_HIGH_ROOT__CAPABILITY_DB2_PARTITION_GROUP, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityDB2PartitionGroup(DB2PartitionGroup newCapabilityDB2PartitionGroup, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2highPackage.Literals.DB2_HIGH_ROOT__CAPABILITY_DB2_PARTITION_GROUP, newCapabilityDB2PartitionGroup, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityDB2PartitionGroup(DB2PartitionGroup newCapabilityDB2PartitionGroup) {
		((FeatureMap.Internal)getMixed()).set(Db2highPackage.Literals.DB2_HIGH_ROOT__CAPABILITY_DB2_PARTITION_GROUP, newCapabilityDB2PartitionGroup);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2TableSpace getCapabilityDB2TableSpace() {
		return (DB2TableSpace)getMixed().get(Db2highPackage.Literals.DB2_HIGH_ROOT__CAPABILITY_DB2_TABLE_SPACE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityDB2TableSpace(DB2TableSpace newCapabilityDB2TableSpace, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2highPackage.Literals.DB2_HIGH_ROOT__CAPABILITY_DB2_TABLE_SPACE, newCapabilityDB2TableSpace, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityDB2TableSpace(DB2TableSpace newCapabilityDB2TableSpace) {
		((FeatureMap.Internal)getMixed()).set(Db2highPackage.Literals.DB2_HIGH_ROOT__CAPABILITY_DB2_TABLE_SPACE, newCapabilityDB2TableSpace);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2Manager getCapailityDB2Manager() {
		return (DB2Manager)getMixed().get(Db2highPackage.Literals.DB2_HIGH_ROOT__CAPAILITY_DB2_MANAGER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapailityDB2Manager(DB2Manager newCapailityDB2Manager, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2highPackage.Literals.DB2_HIGH_ROOT__CAPAILITY_DB2_MANAGER, newCapailityDB2Manager, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapailityDB2Manager(DB2Manager newCapailityDB2Manager) {
		((FeatureMap.Internal)getMixed()).set(Db2highPackage.Literals.DB2_HIGH_ROOT__CAPAILITY_DB2_MANAGER, newCapailityDB2Manager);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2BufferPoolUnit getUnitDB2BufferPoolUnit() {
		return (DB2BufferPoolUnit)getMixed().get(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_BUFFER_POOL_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDB2BufferPoolUnit(DB2BufferPoolUnit newUnitDB2BufferPoolUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_BUFFER_POOL_UNIT, newUnitDB2BufferPoolUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDB2BufferPoolUnit(DB2BufferPoolUnit newUnitDB2BufferPoolUnit) {
		((FeatureMap.Internal)getMixed()).set(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_BUFFER_POOL_UNIT, newUnitDB2BufferPoolUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2Constraint getUnitDB2Constraint() {
		return (DB2Constraint)getMixed().get(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_CONSTRAINT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDB2Constraint(DB2Constraint newUnitDB2Constraint, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_CONSTRAINT, newUnitDB2Constraint, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDB2Constraint(DB2Constraint newUnitDB2Constraint) {
		((FeatureMap.Internal)getMixed()).set(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_CONSTRAINT, newUnitDB2Constraint);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2ConstraintUnit getUnitDB2ConstraintUnit() {
		return (DB2ConstraintUnit)getMixed().get(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_CONSTRAINT_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDB2ConstraintUnit(DB2ConstraintUnit newUnitDB2ConstraintUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_CONSTRAINT_UNIT, newUnitDB2ConstraintUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDB2ConstraintUnit(DB2ConstraintUnit newUnitDB2ConstraintUnit) {
		((FeatureMap.Internal)getMixed()).set(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_CONSTRAINT_UNIT, newUnitDB2ConstraintUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2Field getUnitDB2Field() {
		return (DB2Field)getMixed().get(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_FIELD, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDB2Field(DB2Field newUnitDB2Field, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_FIELD, newUnitDB2Field, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDB2Field(DB2Field newUnitDB2Field) {
		((FeatureMap.Internal)getMixed()).set(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_FIELD, newUnitDB2Field);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2FieldUnit getUnitDB2FieldUnit() {
		return (DB2FieldUnit)getMixed().get(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_FIELD_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDB2FieldUnit(DB2FieldUnit newUnitDB2FieldUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_FIELD_UNIT, newUnitDB2FieldUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDB2FieldUnit(DB2FieldUnit newUnitDB2FieldUnit) {
		((FeatureMap.Internal)getMixed()).set(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_FIELD_UNIT, newUnitDB2FieldUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2Index getUnitDB2Index() {
		return (DB2Index)getMixed().get(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_INDEX, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDB2Index(DB2Index newUnitDB2Index, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_INDEX, newUnitDB2Index, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDB2Index(DB2Index newUnitDB2Index) {
		((FeatureMap.Internal)getMixed()).set(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_INDEX, newUnitDB2Index);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2IndexUnit getUnitDB2IndexUnit() {
		return (DB2IndexUnit)getMixed().get(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_INDEX_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDB2IndexUnit(DB2IndexUnit newUnitDB2IndexUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_INDEX_UNIT, newUnitDB2IndexUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDB2IndexUnit(DB2IndexUnit newUnitDB2IndexUnit) {
		((FeatureMap.Internal)getMixed()).set(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_INDEX_UNIT, newUnitDB2IndexUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2ManagerUnit getUnitDB2ManagerUnit() {
		return (DB2ManagerUnit)getMixed().get(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_MANAGER_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDB2ManagerUnit(DB2ManagerUnit newUnitDB2ManagerUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_MANAGER_UNIT, newUnitDB2ManagerUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDB2ManagerUnit(DB2ManagerUnit newUnitDB2ManagerUnit) {
		((FeatureMap.Internal)getMixed()).set(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_MANAGER_UNIT, newUnitDB2ManagerUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2PartitionGroupUnit getUnitDB2PartitionGroupUnit() {
		return (DB2PartitionGroupUnit)getMixed().get(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_PARTITION_GROUP_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDB2PartitionGroupUnit(DB2PartitionGroupUnit newUnitDB2PartitionGroupUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_PARTITION_GROUP_UNIT, newUnitDB2PartitionGroupUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDB2PartitionGroupUnit(DB2PartitionGroupUnit newUnitDB2PartitionGroupUnit) {
		((FeatureMap.Internal)getMixed()).set(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_PARTITION_GROUP_UNIT, newUnitDB2PartitionGroupUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2Permission getUnitDB2Permission() {
		return (DB2Permission)getMixed().get(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_PERMISSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDB2Permission(DB2Permission newUnitDB2Permission, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_PERMISSION, newUnitDB2Permission, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDB2Permission(DB2Permission newUnitDB2Permission) {
		((FeatureMap.Internal)getMixed()).set(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_PERMISSION, newUnitDB2Permission);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2PermissionUnit getUnitDB2PermissionUnit() {
		return (DB2PermissionUnit)getMixed().get(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_PERMISSION_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDB2PermissionUnit(DB2PermissionUnit newUnitDB2PermissionUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_PERMISSION_UNIT, newUnitDB2PermissionUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDB2PermissionUnit(DB2PermissionUnit newUnitDB2PermissionUnit) {
		((FeatureMap.Internal)getMixed()).set(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_PERMISSION_UNIT, newUnitDB2PermissionUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2Table getUnitDB2Table() {
		return (DB2Table)getMixed().get(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_TABLE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDB2Table(DB2Table newUnitDB2Table, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_TABLE, newUnitDB2Table, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDB2Table(DB2Table newUnitDB2Table) {
		((FeatureMap.Internal)getMixed()).set(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_TABLE, newUnitDB2Table);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2TableSpaceUnit getUnitDB2TableSpaceUnit() {
		return (DB2TableSpaceUnit)getMixed().get(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_TABLE_SPACE_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDB2TableSpaceUnit(DB2TableSpaceUnit newUnitDB2TableSpaceUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_TABLE_SPACE_UNIT, newUnitDB2TableSpaceUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDB2TableSpaceUnit(DB2TableSpaceUnit newUnitDB2TableSpaceUnit) {
		((FeatureMap.Internal)getMixed()).set(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_TABLE_SPACE_UNIT, newUnitDB2TableSpaceUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2TableUnit getUnitDB2TableUnit() {
		return (DB2TableUnit)getMixed().get(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_TABLE_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDB2TableUnit(DB2TableUnit newUnitDB2TableUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_TABLE_UNIT, newUnitDB2TableUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDB2TableUnit(DB2TableUnit newUnitDB2TableUnit) {
		((FeatureMap.Internal)getMixed()).set(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_TABLE_UNIT, newUnitDB2TableUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2User getUnitDB2User() {
		return (DB2User)getMixed().get(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_USER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDB2User(DB2User newUnitDB2User, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_USER, newUnitDB2User, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDB2User(DB2User newUnitDB2User) {
		((FeatureMap.Internal)getMixed()).set(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_USER, newUnitDB2User);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2UserUnit getUnitDB2UserUnit() {
		return (DB2UserUnit)getMixed().get(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_USER_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDB2UserUnit(DB2UserUnit newUnitDB2UserUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_USER_UNIT, newUnitDB2UserUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDB2UserUnit(DB2UserUnit newUnitDB2UserUnit) {
		((FeatureMap.Internal)getMixed()).set(Db2highPackage.Literals.DB2_HIGH_ROOT__UNIT_DB2_USER_UNIT, newUnitDB2UserUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Db2highPackage.DB2_HIGH_ROOT__MIXED:
				return ((InternalEList)getMixed()).basicRemove(otherEnd, msgs);
			case Db2highPackage.DB2_HIGH_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case Db2highPackage.DB2_HIGH_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case Db2highPackage.DB2_HIGH_ROOT__CAPABILITY_DB2_BUFFER_POOL:
				return basicSetCapabilityDB2BufferPool(null, msgs);
			case Db2highPackage.DB2_HIGH_ROOT__CAPABILITY_DB2_PARTITION_GROUP:
				return basicSetCapabilityDB2PartitionGroup(null, msgs);
			case Db2highPackage.DB2_HIGH_ROOT__CAPABILITY_DB2_TABLE_SPACE:
				return basicSetCapabilityDB2TableSpace(null, msgs);
			case Db2highPackage.DB2_HIGH_ROOT__CAPAILITY_DB2_MANAGER:
				return basicSetCapailityDB2Manager(null, msgs);
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_BUFFER_POOL_UNIT:
				return basicSetUnitDB2BufferPoolUnit(null, msgs);
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_CONSTRAINT:
				return basicSetUnitDB2Constraint(null, msgs);
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_CONSTRAINT_UNIT:
				return basicSetUnitDB2ConstraintUnit(null, msgs);
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_FIELD:
				return basicSetUnitDB2Field(null, msgs);
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_FIELD_UNIT:
				return basicSetUnitDB2FieldUnit(null, msgs);
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_INDEX:
				return basicSetUnitDB2Index(null, msgs);
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_INDEX_UNIT:
				return basicSetUnitDB2IndexUnit(null, msgs);
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_MANAGER_UNIT:
				return basicSetUnitDB2ManagerUnit(null, msgs);
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_PARTITION_GROUP_UNIT:
				return basicSetUnitDB2PartitionGroupUnit(null, msgs);
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_PERMISSION:
				return basicSetUnitDB2Permission(null, msgs);
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_PERMISSION_UNIT:
				return basicSetUnitDB2PermissionUnit(null, msgs);
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_TABLE:
				return basicSetUnitDB2Table(null, msgs);
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_TABLE_SPACE_UNIT:
				return basicSetUnitDB2TableSpaceUnit(null, msgs);
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_TABLE_UNIT:
				return basicSetUnitDB2TableUnit(null, msgs);
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_USER:
				return basicSetUnitDB2User(null, msgs);
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_USER_UNIT:
				return basicSetUnitDB2UserUnit(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Db2highPackage.DB2_HIGH_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case Db2highPackage.DB2_HIGH_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case Db2highPackage.DB2_HIGH_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case Db2highPackage.DB2_HIGH_ROOT__CAPABILITY_DB2_BUFFER_POOL:
				return getCapabilityDB2BufferPool();
			case Db2highPackage.DB2_HIGH_ROOT__CAPABILITY_DB2_PARTITION_GROUP:
				return getCapabilityDB2PartitionGroup();
			case Db2highPackage.DB2_HIGH_ROOT__CAPABILITY_DB2_TABLE_SPACE:
				return getCapabilityDB2TableSpace();
			case Db2highPackage.DB2_HIGH_ROOT__CAPAILITY_DB2_MANAGER:
				return getCapailityDB2Manager();
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_BUFFER_POOL_UNIT:
				return getUnitDB2BufferPoolUnit();
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_CONSTRAINT:
				return getUnitDB2Constraint();
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_CONSTRAINT_UNIT:
				return getUnitDB2ConstraintUnit();
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_FIELD:
				return getUnitDB2Field();
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_FIELD_UNIT:
				return getUnitDB2FieldUnit();
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_INDEX:
				return getUnitDB2Index();
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_INDEX_UNIT:
				return getUnitDB2IndexUnit();
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_MANAGER_UNIT:
				return getUnitDB2ManagerUnit();
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_PARTITION_GROUP_UNIT:
				return getUnitDB2PartitionGroupUnit();
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_PERMISSION:
				return getUnitDB2Permission();
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_PERMISSION_UNIT:
				return getUnitDB2PermissionUnit();
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_TABLE:
				return getUnitDB2Table();
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_TABLE_SPACE_UNIT:
				return getUnitDB2TableSpaceUnit();
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_TABLE_UNIT:
				return getUnitDB2TableUnit();
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_USER:
				return getUnitDB2User();
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_USER_UNIT:
				return getUnitDB2UserUnit();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Db2highPackage.DB2_HIGH_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__CAPABILITY_DB2_BUFFER_POOL:
				setCapabilityDB2BufferPool((DB2BufferPool)newValue);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__CAPABILITY_DB2_PARTITION_GROUP:
				setCapabilityDB2PartitionGroup((DB2PartitionGroup)newValue);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__CAPABILITY_DB2_TABLE_SPACE:
				setCapabilityDB2TableSpace((DB2TableSpace)newValue);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__CAPAILITY_DB2_MANAGER:
				setCapailityDB2Manager((DB2Manager)newValue);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_BUFFER_POOL_UNIT:
				setUnitDB2BufferPoolUnit((DB2BufferPoolUnit)newValue);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_CONSTRAINT:
				setUnitDB2Constraint((DB2Constraint)newValue);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_CONSTRAINT_UNIT:
				setUnitDB2ConstraintUnit((DB2ConstraintUnit)newValue);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_FIELD:
				setUnitDB2Field((DB2Field)newValue);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_FIELD_UNIT:
				setUnitDB2FieldUnit((DB2FieldUnit)newValue);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_INDEX:
				setUnitDB2Index((DB2Index)newValue);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_INDEX_UNIT:
				setUnitDB2IndexUnit((DB2IndexUnit)newValue);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_MANAGER_UNIT:
				setUnitDB2ManagerUnit((DB2ManagerUnit)newValue);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_PARTITION_GROUP_UNIT:
				setUnitDB2PartitionGroupUnit((DB2PartitionGroupUnit)newValue);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_PERMISSION:
				setUnitDB2Permission((DB2Permission)newValue);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_PERMISSION_UNIT:
				setUnitDB2PermissionUnit((DB2PermissionUnit)newValue);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_TABLE:
				setUnitDB2Table((DB2Table)newValue);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_TABLE_SPACE_UNIT:
				setUnitDB2TableSpaceUnit((DB2TableSpaceUnit)newValue);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_TABLE_UNIT:
				setUnitDB2TableUnit((DB2TableUnit)newValue);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_USER:
				setUnitDB2User((DB2User)newValue);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_USER_UNIT:
				setUnitDB2UserUnit((DB2UserUnit)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case Db2highPackage.DB2_HIGH_ROOT__MIXED:
				getMixed().clear();
				return;
			case Db2highPackage.DB2_HIGH_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case Db2highPackage.DB2_HIGH_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case Db2highPackage.DB2_HIGH_ROOT__CAPABILITY_DB2_BUFFER_POOL:
				setCapabilityDB2BufferPool((DB2BufferPool)null);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__CAPABILITY_DB2_PARTITION_GROUP:
				setCapabilityDB2PartitionGroup((DB2PartitionGroup)null);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__CAPABILITY_DB2_TABLE_SPACE:
				setCapabilityDB2TableSpace((DB2TableSpace)null);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__CAPAILITY_DB2_MANAGER:
				setCapailityDB2Manager((DB2Manager)null);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_BUFFER_POOL_UNIT:
				setUnitDB2BufferPoolUnit((DB2BufferPoolUnit)null);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_CONSTRAINT:
				setUnitDB2Constraint((DB2Constraint)null);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_CONSTRAINT_UNIT:
				setUnitDB2ConstraintUnit((DB2ConstraintUnit)null);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_FIELD:
				setUnitDB2Field((DB2Field)null);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_FIELD_UNIT:
				setUnitDB2FieldUnit((DB2FieldUnit)null);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_INDEX:
				setUnitDB2Index((DB2Index)null);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_INDEX_UNIT:
				setUnitDB2IndexUnit((DB2IndexUnit)null);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_MANAGER_UNIT:
				setUnitDB2ManagerUnit((DB2ManagerUnit)null);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_PARTITION_GROUP_UNIT:
				setUnitDB2PartitionGroupUnit((DB2PartitionGroupUnit)null);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_PERMISSION:
				setUnitDB2Permission((DB2Permission)null);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_PERMISSION_UNIT:
				setUnitDB2PermissionUnit((DB2PermissionUnit)null);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_TABLE:
				setUnitDB2Table((DB2Table)null);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_TABLE_SPACE_UNIT:
				setUnitDB2TableSpaceUnit((DB2TableSpaceUnit)null);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_TABLE_UNIT:
				setUnitDB2TableUnit((DB2TableUnit)null);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_USER:
				setUnitDB2User((DB2User)null);
				return;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_USER_UNIT:
				setUnitDB2UserUnit((DB2UserUnit)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Db2highPackage.DB2_HIGH_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case Db2highPackage.DB2_HIGH_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case Db2highPackage.DB2_HIGH_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case Db2highPackage.DB2_HIGH_ROOT__CAPABILITY_DB2_BUFFER_POOL:
				return getCapabilityDB2BufferPool() != null;
			case Db2highPackage.DB2_HIGH_ROOT__CAPABILITY_DB2_PARTITION_GROUP:
				return getCapabilityDB2PartitionGroup() != null;
			case Db2highPackage.DB2_HIGH_ROOT__CAPABILITY_DB2_TABLE_SPACE:
				return getCapabilityDB2TableSpace() != null;
			case Db2highPackage.DB2_HIGH_ROOT__CAPAILITY_DB2_MANAGER:
				return getCapailityDB2Manager() != null;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_BUFFER_POOL_UNIT:
				return getUnitDB2BufferPoolUnit() != null;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_CONSTRAINT:
				return getUnitDB2Constraint() != null;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_CONSTRAINT_UNIT:
				return getUnitDB2ConstraintUnit() != null;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_FIELD:
				return getUnitDB2Field() != null;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_FIELD_UNIT:
				return getUnitDB2FieldUnit() != null;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_INDEX:
				return getUnitDB2Index() != null;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_INDEX_UNIT:
				return getUnitDB2IndexUnit() != null;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_MANAGER_UNIT:
				return getUnitDB2ManagerUnit() != null;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_PARTITION_GROUP_UNIT:
				return getUnitDB2PartitionGroupUnit() != null;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_PERMISSION:
				return getUnitDB2Permission() != null;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_PERMISSION_UNIT:
				return getUnitDB2PermissionUnit() != null;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_TABLE:
				return getUnitDB2Table() != null;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_TABLE_SPACE_UNIT:
				return getUnitDB2TableSpaceUnit() != null;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_TABLE_UNIT:
				return getUnitDB2TableUnit() != null;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_USER:
				return getUnitDB2User() != null;
			case Db2highPackage.DB2_HIGH_ROOT__UNIT_DB2_USER_UNIT:
				return getUnitDB2UserUnit() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (mixed: "); //$NON-NLS-1$
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //DB2HighRootImpl
