/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.db2.validator.constraint;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.database.Database;
import com.ibm.ccl.soa.deploy.database.DatabasePackage;
import com.ibm.ccl.soa.deploy.database.DatabaseUnit;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.was.db2.DatasourceSatisfactionConstraint;
import com.ibm.ccl.soa.deploy.was.db2.WasDb2Package;

public class EarToDbUtil {

	/**
	 * Retrieve the target {@link DatabaseUnit} from a constraint of type:
	 * <ul>
	 * <li>{@link DatasourceSatisfactionConstraint}</li>
	 * </ul>
	 * 
	 * @param constraint
	 *           the constraint
	 * @param context
	 *           the constraint context
	 * @return a database unit
	 */
	public static DatabaseUnit getDatabaseUnitFromConstraint(Constraint constraint,
			DeployModelObject context, IProgressMonitor monitor) {
		if (null == constraint || null == context) {
			return null;
		}

		if (WasDb2Package.Literals.DATASOURCE_SATISFACTION_CONSTRAINT.isSuperTypeOf(constraint
				.getEObject().eClass())) {

			Database db = getDatabaseFromConstraint(constraint, context, monitor);
			if (null == db) {
				return null;
			}
			Unit u = ValidatorUtils.getOwningUnit(db);
			if (!DatabasePackage.Literals.DATABASE_UNIT.isSuperTypeOf(u.getEObject().eClass())) {
				return null;
			}
			return (DatabaseUnit) u;
		} else {
			// handle other variations on the constraint that we know how to handle
		}

		// we don't know what kind of constraint it is
		return null;
	}

	/**
	 * Retrieve the target {@link DatabaseUnit} from a constraint of type:
	 * <ul>
	 * <li>{@link DatasourceSatisfactionConstraint}</li>
	 * </ul>
	 * 
	 * @param constraint
	 *           the constraint
	 * @param context
	 *           the constraint context
	 * @return a database unit
	 */
	public static Database getDatabaseFromConstraint(Constraint constraint,
			DeployModelObject context, IProgressMonitor monitor) {
		if (null == constraint || null == context) {
			return null;
		}

		if (WasDb2Package.Literals.DATASOURCE_SATISFACTION_CONSTRAINT.isSuperTypeOf(constraint
				.getEObject().eClass())) {
			EClass contextType = context.getEObject().eClass();
			if (CorePackage.Literals.DEPENDENCY_LINK.isSuperTypeOf(contextType)) {
				Capability targetCap = ((DependencyLink) context).getTarget();
				if (null == targetCap) {
					return null;
				}
				if (!DatabasePackage.Literals.DATABASE.isSuperTypeOf(targetCap.getEObject().eClass())) {
					return null;
				}
				return (Database) targetCap;
			} else if (CorePackage.Literals.CONSTRAINT_LINK.isSuperTypeOf(contextType)) {
				DeployModelObject target = ((ConstraintLink) context).getTarget();
				if (null == target) {
					return null;
				}
				if (DatabasePackage.Literals.DATABASE_DEFINITION.isSuperTypeOf(target.getEObject()
						.eClass())) {
					target = ValidatorUtils.discoverHost((Capability) target, monitor);
					if (null == target) {
						return null;
					}
				}
				if (DatabasePackage.Literals.DATABASE_COMPONENT.isSuperTypeOf(target.getEObject()
						.eClass())) {
					target = ValidatorUtils.discoverHost((Unit) target, monitor);
					if (null == target) {
						return null;
					}
				}
				if (DatabasePackage.Literals.DATABASE_UNIT.isSuperTypeOf(target.getEObject().eClass())) {
					target = ValidatorUtils.getCapability((Unit) target,
							DatabasePackage.Literals.DATABASE);
					if (null == target) {
						return null;
					}
				}
				if (DatabasePackage.Literals.DATABASE.isSuperTypeOf(target.getEObject().eClass())) {
					return (Database) target;
				}
				// if we got here then we failed to find the database capability
				return null;
			} else {
				// this constraint should not appear in another context
				return null;
			}
		} else {
			// handle other variations on the constraint that we know how to handle
		}

		// we don't know what kind of constraint it is
		return null;
	}

	/**
	 * Retrieve the source module from a constraint of type:
	 * <ul>
	 * <li>{@link DatasourceSatisfactionConstraint}</li>
	 * </ul>
	 * 
	 * @param constraint
	 *           the constraint
	 * @param context
	 *           the constraint context
	 * @return a database unit
	 */
	public static Unit getJ2eeModuleFromConstraint(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor) {
		if (null == constraint || null == context) {
			return null;
		}

		if (WasDb2Package.Literals.DATASOURCE_SATISFACTION_CONSTRAINT.isSuperTypeOf(constraint
				.getEObject().eClass())) {

			Requirement sourceReq = getDatasourceRequirementFromConstraint(constraint, context,
					monitor);
			if (null == sourceReq) {
				return null;
			}

			Unit u = ValidatorUtils.getOwningUnit(sourceReq);
			if (!J2eePackage.Literals.EAR_MODULE.isSuperTypeOf(u.getEObject().eClass())
					&& !J2eePackage.Literals.EJB_MODULE.isSuperTypeOf(u.getEObject().eClass())
					&& !J2eePackage.Literals.WEB_MODULE.isSuperTypeOf(u.getEObject().eClass())) {
				return null;
			}
			return u;
		} else {
			// handle other variations on the constraint that we know how to handle
		}

		// we don't know what kind of constraint it is
		return null;
	}

	/**
	 * Retrieve the source datasource requirement from a constraint of type:
	 * <ul>
	 * <li>{@link DatasourceSatisfactionConstraint}</li>
	 * </ul>
	 * 
	 * @param constraint
	 *           the constraint
	 * @param context
	 *           the constraint context
	 * @return a database unit
	 */
	public static Requirement getDatasourceRequirementFromConstraint(Constraint constraint,
			DeployModelObject context, IProgressMonitor monitor) {
		if (null == constraint || null == context) {
			return null;
		}

		if (WasDb2Package.Literals.DATASOURCE_SATISFACTION_CONSTRAINT.isSuperTypeOf(constraint
				.getEObject().eClass())) {
			EClass contextType = context.getEObject().eClass();
			if (CorePackage.Literals.DEPENDENCY_LINK.isSuperTypeOf(contextType)) {
				Requirement sourceReq = ((DependencyLink) context).getSource();
				if (null == sourceReq) {
					return null;
				}
				if (!J2eePackage.Literals.J2EE_DATASOURCE.isSuperTypeOf(sourceReq.getDmoEType())) {
					return null;
				}
				return sourceReq;
			} else if (CorePackage.Literals.CONSTRAINT_LINK.isSuperTypeOf(contextType)) {
				DeployModelObject source = ((ConstraintLink) context).getSource();
				if (null == source) {
					return null;
				}
				if (!CorePackage.Literals.REQUIREMENT.isSuperTypeOf(source.getEObject().eClass())) {
					return null;
				}

				Requirement sourceReq = (Requirement) source;
				if (!J2eePackage.Literals.J2EE_DATASOURCE.isSuperTypeOf(sourceReq.getDmoEType())) {
					return null;
				}
				return sourceReq;
			} else {
				// this constraint should not appear in another context
				return null;
			}
		} else {
			// handle other variations on the constraint that we know how to handle
		}

		// we don't know what kind of constraint it is
		return null;
	}

}
