/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.db2high.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage
 * @generated
 */
public class Db2highSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Db2highPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Db2highSwitch() {
		if (modelPackage == null) {
			modelPackage = Db2highPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case Db2highPackage.DB2_BUFFER_POOL: {
				DB2BufferPool db2BufferPool = (DB2BufferPool)theEObject;
				Object result = caseDB2BufferPool(db2BufferPool);
				if (result == null) result = caseCapability(db2BufferPool);
				if (result == null) result = caseDeployModelObject(db2BufferPool);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2highPackage.DB2_BUFFER_POOL_UNIT: {
				DB2BufferPoolUnit db2BufferPoolUnit = (DB2BufferPoolUnit)theEObject;
				Object result = caseDB2BufferPoolUnit(db2BufferPoolUnit);
				if (result == null) result = caseUnit(db2BufferPoolUnit);
				if (result == null) result = caseDeployModelObject(db2BufferPoolUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2highPackage.DB2_CONSTRAINT: {
				DB2Constraint db2Constraint = (DB2Constraint)theEObject;
				Object result = caseDB2Constraint(db2Constraint);
				if (result == null) result = caseCapability(db2Constraint);
				if (result == null) result = caseDeployModelObject(db2Constraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2highPackage.DB2_CONSTRAINT_UNIT: {
				DB2ConstraintUnit db2ConstraintUnit = (DB2ConstraintUnit)theEObject;
				Object result = caseDB2ConstraintUnit(db2ConstraintUnit);
				if (result == null) result = caseUnit(db2ConstraintUnit);
				if (result == null) result = caseDeployModelObject(db2ConstraintUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2highPackage.DB2_FIELD: {
				DB2Field db2Field = (DB2Field)theEObject;
				Object result = caseDB2Field(db2Field);
				if (result == null) result = caseCapability(db2Field);
				if (result == null) result = caseDeployModelObject(db2Field);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2highPackage.DB2_FIELD_UNIT: {
				DB2FieldUnit db2FieldUnit = (DB2FieldUnit)theEObject;
				Object result = caseDB2FieldUnit(db2FieldUnit);
				if (result == null) result = caseUnit(db2FieldUnit);
				if (result == null) result = caseDeployModelObject(db2FieldUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2highPackage.DB2_HIGH_ROOT: {
				DB2HighRoot db2HighRoot = (DB2HighRoot)theEObject;
				Object result = caseDB2HighRoot(db2HighRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2highPackage.DB2_INDEX: {
				DB2Index db2Index = (DB2Index)theEObject;
				Object result = caseDB2Index(db2Index);
				if (result == null) result = caseCapability(db2Index);
				if (result == null) result = caseDeployModelObject(db2Index);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2highPackage.DB2_INDEX_UNIT: {
				DB2IndexUnit db2IndexUnit = (DB2IndexUnit)theEObject;
				Object result = caseDB2IndexUnit(db2IndexUnit);
				if (result == null) result = caseUnit(db2IndexUnit);
				if (result == null) result = caseDeployModelObject(db2IndexUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2highPackage.DB2_MANAGER: {
				DB2Manager db2Manager = (DB2Manager)theEObject;
				Object result = caseDB2Manager(db2Manager);
				if (result == null) result = caseCapability(db2Manager);
				if (result == null) result = caseDeployModelObject(db2Manager);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2highPackage.DB2_MANAGER_UNIT: {
				DB2ManagerUnit db2ManagerUnit = (DB2ManagerUnit)theEObject;
				Object result = caseDB2ManagerUnit(db2ManagerUnit);
				if (result == null) result = caseUnit(db2ManagerUnit);
				if (result == null) result = caseDeployModelObject(db2ManagerUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2highPackage.DB2_PARTITION_GROUP: {
				DB2PartitionGroup db2PartitionGroup = (DB2PartitionGroup)theEObject;
				Object result = caseDB2PartitionGroup(db2PartitionGroup);
				if (result == null) result = caseCapability(db2PartitionGroup);
				if (result == null) result = caseDeployModelObject(db2PartitionGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2highPackage.DB2_PARTITION_GROUP_UNIT: {
				DB2PartitionGroupUnit db2PartitionGroupUnit = (DB2PartitionGroupUnit)theEObject;
				Object result = caseDB2PartitionGroupUnit(db2PartitionGroupUnit);
				if (result == null) result = caseUnit(db2PartitionGroupUnit);
				if (result == null) result = caseDeployModelObject(db2PartitionGroupUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2highPackage.DB2_PERMISSION: {
				DB2Permission db2Permission = (DB2Permission)theEObject;
				Object result = caseDB2Permission(db2Permission);
				if (result == null) result = caseCapability(db2Permission);
				if (result == null) result = caseDeployModelObject(db2Permission);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2highPackage.DB2_PERMISSION_UNIT: {
				DB2PermissionUnit db2PermissionUnit = (DB2PermissionUnit)theEObject;
				Object result = caseDB2PermissionUnit(db2PermissionUnit);
				if (result == null) result = caseUnit(db2PermissionUnit);
				if (result == null) result = caseDeployModelObject(db2PermissionUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2highPackage.DB2_TABLE: {
				DB2Table db2Table = (DB2Table)theEObject;
				Object result = caseDB2Table(db2Table);
				if (result == null) result = caseCapability(db2Table);
				if (result == null) result = caseDeployModelObject(db2Table);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2highPackage.DB2_TABLE_SPACE: {
				DB2TableSpace db2TableSpace = (DB2TableSpace)theEObject;
				Object result = caseDB2TableSpace(db2TableSpace);
				if (result == null) result = caseCapability(db2TableSpace);
				if (result == null) result = caseDeployModelObject(db2TableSpace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2highPackage.DB2_TABLE_SPACE_UNIT: {
				DB2TableSpaceUnit db2TableSpaceUnit = (DB2TableSpaceUnit)theEObject;
				Object result = caseDB2TableSpaceUnit(db2TableSpaceUnit);
				if (result == null) result = caseUnit(db2TableSpaceUnit);
				if (result == null) result = caseDeployModelObject(db2TableSpaceUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2highPackage.DB2_TABLE_UNIT: {
				DB2TableUnit db2TableUnit = (DB2TableUnit)theEObject;
				Object result = caseDB2TableUnit(db2TableUnit);
				if (result == null) result = caseUnit(db2TableUnit);
				if (result == null) result = caseDeployModelObject(db2TableUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2highPackage.DB2_USER: {
				DB2User db2User = (DB2User)theEObject;
				Object result = caseDB2User(db2User);
				if (result == null) result = caseCapability(db2User);
				if (result == null) result = caseDeployModelObject(db2User);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Db2highPackage.DB2_USER_UNIT: {
				DB2UserUnit db2UserUnit = (DB2UserUnit)theEObject;
				Object result = caseDB2UserUnit(db2UserUnit);
				if (result == null) result = caseUnit(db2UserUnit);
				if (result == null) result = caseDeployModelObject(db2UserUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Buffer Pool</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Buffer Pool</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2BufferPool(DB2BufferPool object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Buffer Pool Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Buffer Pool Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2BufferPoolUnit(DB2BufferPoolUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2Constraint(DB2Constraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Constraint Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Constraint Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2ConstraintUnit(DB2ConstraintUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2Field(DB2Field object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Field Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Field Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2FieldUnit(DB2FieldUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 High Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 High Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2HighRoot(DB2HighRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Index</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Index</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2Index(DB2Index object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Index Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Index Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2IndexUnit(DB2IndexUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Manager</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Manager</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2Manager(DB2Manager object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Manager Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Manager Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2ManagerUnit(DB2ManagerUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Partition Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Partition Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2PartitionGroup(DB2PartitionGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Partition Group Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Partition Group Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2PartitionGroupUnit(DB2PartitionGroupUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Permission</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Permission</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2Permission(DB2Permission object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Permission Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Permission Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2PermissionUnit(DB2PermissionUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Table</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Table</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2Table(DB2Table object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Table Space</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Table Space</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2TableSpace(DB2TableSpace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Table Space Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Table Space Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2TableSpaceUnit(DB2TableSpaceUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 Table Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 Table Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2TableUnit(DB2TableUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 User</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 User</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2User(DB2User object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>DB2 User Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DB2 User Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDB2UserUnit(DB2UserUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deploy Model Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deploy Model Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDeployModelObject(DeployModelObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Capability</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Capability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCapability(Capability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUnit(Unit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //Db2highSwitch
