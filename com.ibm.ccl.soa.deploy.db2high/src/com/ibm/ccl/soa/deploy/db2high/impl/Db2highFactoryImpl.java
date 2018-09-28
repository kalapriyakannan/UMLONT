/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.db2high.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

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
import com.ibm.ccl.soa.deploy.db2high.Db2highFactory;
import com.ibm.ccl.soa.deploy.db2high.Db2highPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Db2highFactoryImpl extends EFactoryImpl implements Db2highFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Db2highFactory init() {
		try {
			Db2highFactory theDb2highFactory = (Db2highFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.ibm.com/Zephyr/db2high/1.0.0/"); //$NON-NLS-1$ 
			if (theDb2highFactory != null) {
				return theDb2highFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Db2highFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Db2highFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case Db2highPackage.DB2_BUFFER_POOL: return createDB2BufferPool();
			case Db2highPackage.DB2_BUFFER_POOL_UNIT: return createDB2BufferPoolUnit();
			case Db2highPackage.DB2_CONSTRAINT: return createDB2Constraint();
			case Db2highPackage.DB2_CONSTRAINT_UNIT: return createDB2ConstraintUnit();
			case Db2highPackage.DB2_FIELD: return createDB2Field();
			case Db2highPackage.DB2_FIELD_UNIT: return createDB2FieldUnit();
			case Db2highPackage.DB2_HIGH_ROOT: return createDB2HighRoot();
			case Db2highPackage.DB2_INDEX: return createDB2Index();
			case Db2highPackage.DB2_INDEX_UNIT: return createDB2IndexUnit();
			case Db2highPackage.DB2_MANAGER: return createDB2Manager();
			case Db2highPackage.DB2_MANAGER_UNIT: return createDB2ManagerUnit();
			case Db2highPackage.DB2_PARTITION_GROUP: return createDB2PartitionGroup();
			case Db2highPackage.DB2_PARTITION_GROUP_UNIT: return createDB2PartitionGroupUnit();
			case Db2highPackage.DB2_PERMISSION: return createDB2Permission();
			case Db2highPackage.DB2_PERMISSION_UNIT: return createDB2PermissionUnit();
			case Db2highPackage.DB2_TABLE: return createDB2Table();
			case Db2highPackage.DB2_TABLE_SPACE: return createDB2TableSpace();
			case Db2highPackage.DB2_TABLE_SPACE_UNIT: return createDB2TableSpaceUnit();
			case Db2highPackage.DB2_TABLE_UNIT: return createDB2TableUnit();
			case Db2highPackage.DB2_USER: return createDB2User();
			case Db2highPackage.DB2_USER_UNIT: return createDB2UserUnit();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2BufferPool createDB2BufferPool() {
		DB2BufferPoolImpl db2BufferPool = new DB2BufferPoolImpl();
		return db2BufferPool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2BufferPoolUnit createDB2BufferPoolUnit() {
		DB2BufferPoolUnitImpl db2BufferPoolUnit = new DB2BufferPoolUnitImpl();
		return db2BufferPoolUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2Constraint createDB2Constraint() {
		DB2ConstraintImpl db2Constraint = new DB2ConstraintImpl();
		return db2Constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2ConstraintUnit createDB2ConstraintUnit() {
		DB2ConstraintUnitImpl db2ConstraintUnit = new DB2ConstraintUnitImpl();
		return db2ConstraintUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2Field createDB2Field() {
		DB2FieldImpl db2Field = new DB2FieldImpl();
		return db2Field;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2FieldUnit createDB2FieldUnit() {
		DB2FieldUnitImpl db2FieldUnit = new DB2FieldUnitImpl();
		return db2FieldUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2HighRoot createDB2HighRoot() {
		DB2HighRootImpl db2HighRoot = new DB2HighRootImpl();
		return db2HighRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2Index createDB2Index() {
		DB2IndexImpl db2Index = new DB2IndexImpl();
		return db2Index;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2IndexUnit createDB2IndexUnit() {
		DB2IndexUnitImpl db2IndexUnit = new DB2IndexUnitImpl();
		return db2IndexUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2Manager createDB2Manager() {
		DB2ManagerImpl db2Manager = new DB2ManagerImpl();
		return db2Manager;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2ManagerUnit createDB2ManagerUnit() {
		DB2ManagerUnitImpl db2ManagerUnit = new DB2ManagerUnitImpl();
		return db2ManagerUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2PartitionGroup createDB2PartitionGroup() {
		DB2PartitionGroupImpl db2PartitionGroup = new DB2PartitionGroupImpl();
		return db2PartitionGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2PartitionGroupUnit createDB2PartitionGroupUnit() {
		DB2PartitionGroupUnitImpl db2PartitionGroupUnit = new DB2PartitionGroupUnitImpl();
		return db2PartitionGroupUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2Permission createDB2Permission() {
		DB2PermissionImpl db2Permission = new DB2PermissionImpl();
		return db2Permission;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2PermissionUnit createDB2PermissionUnit() {
		DB2PermissionUnitImpl db2PermissionUnit = new DB2PermissionUnitImpl();
		return db2PermissionUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2Table createDB2Table() {
		DB2TableImpl db2Table = new DB2TableImpl();
		return db2Table;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2TableSpace createDB2TableSpace() {
		DB2TableSpaceImpl db2TableSpace = new DB2TableSpaceImpl();
		return db2TableSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2TableSpaceUnit createDB2TableSpaceUnit() {
		DB2TableSpaceUnitImpl db2TableSpaceUnit = new DB2TableSpaceUnitImpl();
		return db2TableSpaceUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2TableUnit createDB2TableUnit() {
		DB2TableUnitImpl db2TableUnit = new DB2TableUnitImpl();
		return db2TableUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2User createDB2User() {
		DB2UserImpl db2User = new DB2UserImpl();
		return db2User;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DB2UserUnit createDB2UserUnit() {
		DB2UserUnitImpl db2UserUnit = new DB2UserUnitImpl();
		return db2UserUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Db2highPackage getDb2highPackage() {
		return (Db2highPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static Db2highPackage getPackage() {
		return Db2highPackage.eINSTANCE;
	}

} //Db2highFactoryImpl
