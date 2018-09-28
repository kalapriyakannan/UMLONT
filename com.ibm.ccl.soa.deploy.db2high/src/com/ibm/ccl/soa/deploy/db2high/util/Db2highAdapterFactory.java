/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.db2high.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage
 * @generated
 */
public class Db2highAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Db2highPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Db2highAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = Db2highPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Db2highSwitch modelSwitch =
		new Db2highSwitch() {
			public Object caseDB2BufferPool(DB2BufferPool object) {
				return createDB2BufferPoolAdapter();
			}
			public Object caseDB2BufferPoolUnit(DB2BufferPoolUnit object) {
				return createDB2BufferPoolUnitAdapter();
			}
			public Object caseDB2Constraint(DB2Constraint object) {
				return createDB2ConstraintAdapter();
			}
			public Object caseDB2ConstraintUnit(DB2ConstraintUnit object) {
				return createDB2ConstraintUnitAdapter();
			}
			public Object caseDB2Field(DB2Field object) {
				return createDB2FieldAdapter();
			}
			public Object caseDB2FieldUnit(DB2FieldUnit object) {
				return createDB2FieldUnitAdapter();
			}
			public Object caseDB2HighRoot(DB2HighRoot object) {
				return createDB2HighRootAdapter();
			}
			public Object caseDB2Index(DB2Index object) {
				return createDB2IndexAdapter();
			}
			public Object caseDB2IndexUnit(DB2IndexUnit object) {
				return createDB2IndexUnitAdapter();
			}
			public Object caseDB2Manager(DB2Manager object) {
				return createDB2ManagerAdapter();
			}
			public Object caseDB2ManagerUnit(DB2ManagerUnit object) {
				return createDB2ManagerUnitAdapter();
			}
			public Object caseDB2PartitionGroup(DB2PartitionGroup object) {
				return createDB2PartitionGroupAdapter();
			}
			public Object caseDB2PartitionGroupUnit(DB2PartitionGroupUnit object) {
				return createDB2PartitionGroupUnitAdapter();
			}
			public Object caseDB2Permission(DB2Permission object) {
				return createDB2PermissionAdapter();
			}
			public Object caseDB2PermissionUnit(DB2PermissionUnit object) {
				return createDB2PermissionUnitAdapter();
			}
			public Object caseDB2Table(DB2Table object) {
				return createDB2TableAdapter();
			}
			public Object caseDB2TableSpace(DB2TableSpace object) {
				return createDB2TableSpaceAdapter();
			}
			public Object caseDB2TableSpaceUnit(DB2TableSpaceUnit object) {
				return createDB2TableSpaceUnitAdapter();
			}
			public Object caseDB2TableUnit(DB2TableUnit object) {
				return createDB2TableUnitAdapter();
			}
			public Object caseDB2User(DB2User object) {
				return createDB2UserAdapter();
			}
			public Object caseDB2UserUnit(DB2UserUnit object) {
				return createDB2UserUnitAdapter();
			}
			public Object caseDeployModelObject(DeployModelObject object) {
				return createDeployModelObjectAdapter();
			}
			public Object caseCapability(Capability object) {
				return createCapabilityAdapter();
			}
			public Object caseUnit(Unit object) {
				return createUnitAdapter();
			}
			public Object defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2high.DB2BufferPool <em>DB2 Buffer Pool</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2BufferPool
	 * @generated
	 */
	public Adapter createDB2BufferPoolAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2high.DB2BufferPoolUnit <em>DB2 Buffer Pool Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2BufferPoolUnit
	 * @generated
	 */
	public Adapter createDB2BufferPoolUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2high.DB2Constraint <em>DB2 Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Constraint
	 * @generated
	 */
	public Adapter createDB2ConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2high.DB2ConstraintUnit <em>DB2 Constraint Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2ConstraintUnit
	 * @generated
	 */
	public Adapter createDB2ConstraintUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2high.DB2Field <em>DB2 Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Field
	 * @generated
	 */
	public Adapter createDB2FieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2high.DB2FieldUnit <em>DB2 Field Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2FieldUnit
	 * @generated
	 */
	public Adapter createDB2FieldUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2high.DB2HighRoot <em>DB2 High Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2HighRoot
	 * @generated
	 */
	public Adapter createDB2HighRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2high.DB2Index <em>DB2 Index</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Index
	 * @generated
	 */
	public Adapter createDB2IndexAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2high.DB2IndexUnit <em>DB2 Index Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2IndexUnit
	 * @generated
	 */
	public Adapter createDB2IndexUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2high.DB2Manager <em>DB2 Manager</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Manager
	 * @generated
	 */
	public Adapter createDB2ManagerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2high.DB2ManagerUnit <em>DB2 Manager Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2ManagerUnit
	 * @generated
	 */
	public Adapter createDB2ManagerUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2high.DB2PartitionGroup <em>DB2 Partition Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2PartitionGroup
	 * @generated
	 */
	public Adapter createDB2PartitionGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2high.DB2PartitionGroupUnit <em>DB2 Partition Group Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2PartitionGroupUnit
	 * @generated
	 */
	public Adapter createDB2PartitionGroupUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2high.DB2Permission <em>DB2 Permission</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Permission
	 * @generated
	 */
	public Adapter createDB2PermissionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2high.DB2PermissionUnit <em>DB2 Permission Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2PermissionUnit
	 * @generated
	 */
	public Adapter createDB2PermissionUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2high.DB2Table <em>DB2 Table</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2Table
	 * @generated
	 */
	public Adapter createDB2TableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace <em>DB2 Table Space</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2TableSpace
	 * @generated
	 */
	public Adapter createDB2TableSpaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpaceUnit <em>DB2 Table Space Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2TableSpaceUnit
	 * @generated
	 */
	public Adapter createDB2TableSpaceUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2high.DB2TableUnit <em>DB2 Table Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2TableUnit
	 * @generated
	 */
	public Adapter createDB2TableUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2high.DB2User <em>DB2 User</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2User
	 * @generated
	 */
	public Adapter createDB2UserAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.db2high.DB2UserUnit <em>DB2 User Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.db2high.DB2UserUnit
	 * @generated
	 */
	public Adapter createDB2UserUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.DeployModelObject <em>Deploy Model Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.DeployModelObject
	 * @generated
	 */
	public Adapter createDeployModelObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.Capability <em>Capability</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.Capability
	 * @generated
	 */
	public Adapter createCapabilityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.Unit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.Unit
	 * @generated
	 */
	public Adapter createUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //Db2highAdapterFactory
