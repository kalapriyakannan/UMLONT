/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.BooleanOperator;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.EnumerationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.GroupCardinalityConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.MemberCardinalityConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.SingleValue;
import com.ibm.ccl.soa.deploy.core.constraint.TypeConstraint;
import com.ibm.ccl.soa.deploy.core.validator.ConstraintService;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DeployMatcherStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployStatusIterator;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCoreValidators;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Static {@link Constraint} utility methods.
 */
public final class ConstraintUtil {

	/**
	 * Status message indicating that a guard holds.
	 */
	public static final IStatus PRECONDITION_HOLDS = new Status(IStatus.OK,
			DeployCorePlugin.PLUGIN_ID, 0, DeployCoreMessages.Constraint_Precondition_holds, null);

	/**
	 * Status message indicating that a guard does not hold.
	 */
	public static final IStatus PRECONDITION_FAILS = new Status(IStatus.ERROR,
			DeployCorePlugin.PLUGIN_ID, 0, DeployCoreMessages.Constraint_Precondition_does_not_hold,
			null);

	/**
	 * Status message indicating that a guard does not hold because it can't be properly evaluated.
	 */
	public static final IStatus PRECONDITION_NOT_EVALUATABLE = new Status(IStatus.ERROR,
			DeployCorePlugin.PLUGIN_ID, 0,
			DeployCoreMessages.Constraint_Precondition_can_not_be_evaluated, null);

	private ConstraintUtil() {
		// prevent instantiation
	}

	/**
	 * Creates a deploy status on the constraint for a null context.
	 * 
	 * @param constraint
	 *           the constraint with which the status will be associated.
	 * @return the created status.
	 */
	public static IStatus createNullContextStatus(Constraint constraint) {
		assert constraint != null;
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.WARNING,
				constraint.eClass().getName(), ICoreProblemType.CONSTRAINT_CONTEXT_NULL,
				DeployCoreMessages.Constraint_0_null_context, new Object[] { ConstraintService.INSTANCE
						.title(constraint) }, constraint);
		return status;

	}

	/**
	 * Creates a deploy status on the constraint for an invalid context.
	 * 
	 * @param constraint
	 *           the constraint with which the status will be associated.
	 * @param context
	 *           the constraint context.
	 * @return the created status.
	 */
	public static IStatus createInvalidContextStatus(Constraint constraint, DeployModelObject context) {
		assert constraint != null;
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.WARNING,
				constraint.eClass().getName(), ICoreProblemType.CONSTRAINT_CONTEXT_INVALID,
				DeployCoreMessages.Constraint_0_invalid_context_1, new Object[] {
						ConstraintService.INSTANCE.title(constraint), context }, constraint);
		return status;
	}

	/**
	 * Creates a deploy status on the constraint for an invalid constraint placement.
	 * 
	 * @param constraint
	 *           the constraint with which the status will be associated.
	 * @param parentDmo
	 *           the constraint parent DMO.
	 * @return the created status.
	 */
	public static IStatus createInvalidConstraintPlacementStatus(Constraint constraint,
			DeployModelObject parentDmo) {
		assert constraint != null;
		return DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR, constraint.eClass()
				.getName(), ICoreProblemType.CONSTRAINT_PLACEMENT_INVALID,
				DeployCoreMessages.Constraint_0_parent_1_is_invalid, new Object[] {
						ConstraintService.INSTANCE.title(constraint), parentDmo }, constraint);
	}

	/**
	 * Validates immediate child constraints of a non-constraint Deploy Model Object, in the context
	 * of this DMO. The following constraints on Requirements are not validated: TypeConstraints,
	 * AttributeValueConstraints, Cardinality Constraints, and RequirementExpressions; they are
	 * validated during corresponding link validation.
	 * 
	 * See
	 * {@link ConstraintUtil#containsNonBooleanConstraintEnabledForContext(Constraint, DeployModelObject)}
	 * 
	 * @param parentDmo
	 *           the deploy model object whose child constraints should be validated.
	 * @param context
	 *           Zephyr Deploy Validation context (not constraint validation context)
	 * @param reporter
	 *           used to report validation errors.
	 */
	public static void validateChildConstraintsInParentContext(DeployModelObject parentDmo,
			IDeployValidationContext context, IDeployReporter reporter) {
		if (parentDmo instanceof Constraint) {
			return;
		}
		for (Constraint c : (List<Constraint>) parentDmo.getConstraints()) {
			// If parent DMO is a Requrement and the constraint (tree) does not contain constraints that should be validated 
			// in the context of parent Requirement, we don't validate the constraint
			if (parentDmo instanceof Requirement
					&& !containsNonBooleanConstraintEnabledForContext(c, parentDmo)) {
				continue;
			}

			// validate the constraint in the context of parent DMO
			ConstraintUtil.validateConstraintAndReport(c, parentDmo, null, context
					.getProgressMonitor(), reporter);

			// Do validation on the final realization of a Unit or a Capability
			if (parentDmo instanceof Unit) {
				DeployModelObject finalRealization = RealizationLinkUtil.getFinalRealization(parentDmo);
				if (!parentDmo.equals(finalRealization)) {
					ConstraintUtil.validateConstraintAndReport(c, finalRealization, null, context
							.getProgressMonitor(), reporter);
				}
			}
			if (parentDmo instanceof Capability) {
				DeployModelObject finalRealization = RealizationLinkUtil
						.getImplicitFinalRealization(parentDmo);
				if (!parentDmo.equals(finalRealization)) {
					ConstraintUtil.validateConstraintAndReport(c, finalRealization, null, context
							.getProgressMonitor(), reporter);
				}
			}
		}
	}

	/**
	 * Validates all immediate child constraints of the Requirement that should not be validated in
	 * the context of parent Requirement, in a given validation context.
	 * 
	 * See
	 * {@link ConstraintUtil#containsNonBooleanConstraintEnabledForContext(Constraint, DeployModelObject)}
	 * 
	 * @param req
	 *           the Requirement whose specific child constraints should be validated.
	 * @param validationContext
	 *           the context object in which constraints should be validated.
	 * @param reportingContext
	 *           the reporting DMO for statuses
	 * @param deployContext
	 *           Zephyr Deploy Validation context (not constraint validation context)
	 * @param reporter
	 *           used to report validation errors.
	 */
	public static void validateChildConstraintsOnRequirement(Requirement req,
			DeployModelObject validationContext, DeployModelObject reportingContext,
			IDeployValidationContext deployContext, IDeployReporter reporter) {
		for (Constraint c : (List<Constraint>) req.getConstraints()) {
			// validate only constraints containing TypeConstraints, AttributeValueConstraints, 
			// Cardinality Constraints and RequirementExpressions
			if (!containsNonBooleanConstraintEnabledForContext(c, req)) {
				// validate the constraint
				ConstraintUtil.validateConstraintAndReport(c, validationContext, reportingContext,
						deployContext.getProgressMonitor(), reporter);
			}
		}
	}

	/**
	 * Validates constraint in the validation context, but may use different reporting DMO. If
	 * reportingDMO is not NULL an is different from the validationContext, then each individual
	 * IDeployStatus is wrapped into a DeployWrapperStatus that has reportingDMO as a DMO on which
	 * the status is set. Reports all errors to the reporter and catches all exceptions.
	 * 
	 * @param constraint
	 *           the constraint to be validated
	 * @param validationContext
	 *           the constraint validation context
	 * @param reportingDMO
	 *           the target for statuses. If null, then validationContext is used.
	 * @param monitor
	 *           progress monitor
	 * @param reporter
	 *           used to report validation errors
	 */
	public static void validateConstraintAndReport(Constraint constraint,
			DeployModelObject validationContext, DeployModelObject reportingDMO,
			IProgressMonitor monitor, IDeployReporter reporter) {
		if (reportingDMO == null) {
			reportingDMO = validationContext;
		}
		try {
			IStatus status = ConstraintService.INSTANCE.validate(constraint, validationContext,
					monitor);
			if (status == null) {
				// TODO log error
			} else if (status instanceof IDeployStatus) {
				IDeployStatus dStatus = (IDeployStatus) status;
				if (dStatus.getDeployObject() != null) {
					if (!validationContext.equals(reportingDMO)) {
						dStatus = DeployCoreStatusFactory.INSTANCE.createDeployWrapperStatus(dStatus
								.getSeverity(), dStatus.getValidatorID(), dStatus.getProblemType(), dStatus
								.getUnboundMessage(), dStatus.getBindings(), reportingDMO, dStatus);
					}
					reporter.addStatus(dStatus);
				}
			} else {
				int count = 0;
				if (status.isMultiStatus()) {
					for (Iterator<IDeployStatus> iter = new DeployStatusIterator(status); iter.hasNext();) {
						IDeployStatus cur = iter.next();
						if (cur.getDeployObject() != null) {
							if (!validationContext.equals(reportingDMO)) {
								cur = DeployCoreStatusFactory.INSTANCE.createDeployWrapperStatus(cur
										.getSeverity(), cur.getValidatorID(), cur.getProblemType(), cur
										.getUnboundMessage(), cur.getBindings(), reportingDMO, cur);
							}
							reporter.addStatus(cur);
						}
						count++;
					}
				}
				if (count == 0 && !status.isOK() && status.getSeverity() != IStatus.CANCEL
						&& status.getMessage() != null && status.getMessage().length() > 0) {
					String validatorID = status.getPlugin();
					if (validatorID == null) {
						validatorID = IDeployCoreValidators.CONSTRAINT_001;
					}
					IDeployStatus dStatus = DeployCoreStatusFactory.INSTANCE.createDeployStatus(status
							.getSeverity(), validatorID, ICoreProblemType.CONSTRAINT_UNSATISFIED, status
							.getMessage(), null, reportingDMO);
					reporter.addStatus(dStatus);
				}
			}
		} catch (RuntimeException e) {
			if (!monitor.isCanceled()) {
				DeployCorePlugin.log(IStatus.ERROR, 0, constraint + ": " + e.getMessage(), e); //$NON-NLS-1$
			}
		}
	}

	/**
	 * Computes the actual (or expected) validation context for a given constraint. One use of this
	 * method is in the UI, which needs to know the validation context DMO for an Attribute Value
	 * Constraint and Requirement Expresion, to produce the list of attributes on the context DMO.
	 * 
	 * @param constraint
	 *           the constraint
	 * @return actual (or, expected) validation context DMO. Returns null, if can not figure out the
	 *         validation contex DMO.
	 */
	public static DeployModelObject getExpectedContext(Constraint constraint) {
		DeployModelObject parent = constraint.getParent();
		if (parent == null) {
			// don't know the parent yet...
			return null;
		}
		if (parent instanceof Requirement) {
			// Special case: MemberCardinalityConstraint and GroupCardinalityConstraint 
			if (constraint instanceof MemberCardinalityConstraint
					|| constraint instanceof GroupCardinalityConstraint) {
				// return parent Unit of the Requirement
				return parent.getParent();
			}
			if (containsNonBooleanConstraintEnabledForContext(constraint, parent)) {
				// it contains a constraint, that requires context of Requirement itself.
				return parent;
			} else {
				// The constraint tree contains "Requirement-semantic-relevant" constraints only, 
				// the validaton context will be a link target
				EClass clazz = ((Requirement) parent).getDmoEType();
				if (clazz != null) {
					try {
						return (DeployModelObject) EcoreUtil.create(clazz);
					} catch (Exception ex) {
						// something wrong happened
						return null;
					}
				}
			}
		}
		if (parent instanceof TypeConstraint) {
			EClass clazz = ((TypeConstraint) parent).getDmoEType();
			if (clazz != null) {
				try {
					return (DeployModelObject) EcoreUtil.create(clazz);
				} catch (Exception ex) {
					// something wrong happened
				}
			}
		}
		if (parent instanceof Constraint) {
			return getExpectedContext((Constraint) parent);
		}
		return parent;
	}

	/**
	 * Computes the type of the actual (or expected) validation context for a given constraint. One
	 * use of this method is in the UI, which needs to know the validation context DMO for an
	 * Attribute Value Constraint and Requirement Expresion, to produce the list of attributes on the
	 * context DMO.
	 * 
	 * @param constraint
	 *           the constraint
	 * @return actual (or, expected) validation context DMO Type. Never returns null. If can not
	 *         figure out the validation contex DMO Type, returns
	 *         {@link CorePackage.Literals#DEPLOY_MODEL_OBJECT}.
	 */
	public static EClass getExpectedContextDmoType(Constraint constraint) {
		DeployModelObject parent = constraint.getParent();
		if (parent == null) {
			// don't know the parent yet...
			return CorePackage.Literals.DEPLOY_MODEL_OBJECT;
		}
		if (parent instanceof Requirement) {
			// Special case: MemberCardinalityConstraint and GroupCardinalityConstraint 
			if (constraint instanceof MemberCardinalityConstraint
					|| constraint instanceof GroupCardinalityConstraint) {
				// return Unit type
				return CorePackage.Literals.UNIT;
			}
			if (containsNonBooleanConstraintEnabledForContext(constraint, parent)) {
				// it contains a constraint, that requires context of Requirement itself.
				return CorePackage.Literals.REQUIREMENT;
			} else {
				// The constraint tree contains "Requirement-semantic-relevant" constraints only, 
				// the validaton context will be a link target
				EClass clazz = ((Requirement) parent).getDmoEType();
				return clazz == null ? CorePackage.Literals.DEPLOY_MODEL_OBJECT : clazz;
			}
		}
		if (parent instanceof TypeConstraint) {
			EClass clazz = ((TypeConstraint) parent).getDmoEType();
			return clazz == null ? CorePackage.Literals.DEPLOY_MODEL_OBJECT : clazz;
		}
		if (parent instanceof Constraint) {
			return getExpectedContextDmoType((Constraint) parent);
		}
		return parent.eClass();
	}

	/**
	 * Generate the status indicating that the constraint is malformed.
	 * 
	 * @param constraint
	 *           the constraint
	 * @param context
	 *           the context (DMO object)
	 * @return the status
	 */
	public static IDeployStatus generateConstraintMalformedStatus(Constraint constraint,
			DeployModelObject context) {
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.ERROR,
				constraint.eClass().getName(), ICoreProblemType.CONSTRAINT_MALFORMED,
				DeployCoreMessages.Constraint_0_malformed_on_object_1, new Object[] {
						ConstraintService.INSTANCE.title(constraint), context }, constraint);
		return status;
	}

	/**
	 * Retrieve a list of constraints of a particular type and its subtypes
	 * 
	 * @param parent
	 *           the dmo whose constraints should be added to the list
	 * @param type
	 *           the type of the constraints
	 * @return an unmodifiable list of constraints
	 */
	public static List<Constraint> getConstraints(DeployModelObject parent, EClass type) {
		IObjectFilter filter = new EObjectTypeFilter(type, true);
		return Collections.unmodifiableList((List<Constraint>) new FilterList(
				(EList<Constraint>) parent.getConstraints(), filter));
	}

	/**
	 * Creates a multi-status out of an collection of statuses.
	 * <p>
	 * If a status contained in the array parameter is a multi-status, its children will be directly
	 * added to the multi-status returned.
	 * 
	 * @param c
	 *           a collection of status objects.
	 * 
	 * @return a multi-status (never null).
	 */
	public static MultiStatus createMultiStatus(Collection<? extends IStatus> c) {
		List<IStatus> list;
		if (c == null || c.size() == 0) {
			list = Collections.emptyList();
		} else {
			list = new ArrayList<IStatus>(c.size());
			for (IStatus cur : c) {
				if (cur == null) {
					// ignore
				} else if (cur.isMultiStatus()) {
					IStatus[] children = cur.getChildren();
					if (children != null) {
						for (IStatus child : children) {
							if (child != null) {
								list.add(child);
							}
						}
					}
				} else {
					list.add(cur);
				}
			}
		}
		return new MultiStatus(DeployCorePlugin.PLUGIN_ID, 0, list.toArray(new IStatus[list.size()]),
				DeployCoreMessages.Model_consistency_status_message, null);
	}

	/**
	 * Creates a multi-status out of an array of statuses.
	 * <p>
	 * If a status contained in the array parameter is a multi-status, its children will be directly
	 * added to the multi-status returned.
	 * 
	 * @param status
	 *           an array of status objects.
	 * 
	 * @return a multi-status (never null).
	 */
	public static MultiStatus createMultiStatus(IStatus[] status) {
		List<IStatus> list;
		if (status == null || status.length == 0) {
			list = Collections.emptyList();
		} else {
			list = new ArrayList<IStatus>(status.length);
			for (IStatus cur : status) {
				if (cur == null) {
					// ignore
				} else if (cur.isMultiStatus()) {
					IStatus[] children = cur.getChildren();
					if (children != null) {
						for (IStatus child : children) {
							if (child != null) {
								list.add(child);
							}
						}
					}
				} else {
					list.add(cur);
				}
			}
		}
		return new MultiStatus(DeployCorePlugin.PLUGIN_ID, 0, list.toArray(new IStatus[list.size()]),
				DeployCoreMessages.Model_consistency_status_message, null);
	}

	/**
	 * Given two lists of lists of objects L1 = {a, b, c, ...} and L2 = {x, y, z, ...}, creates list
	 * of lists of objects where each list is a union of a list from L1 and a list from L2, with all
	 * possible combinations of lists from lists L1 and L2: {a+x, a+y, a+z, ..., b+x, b+y, b+z, ...}
	 * 
	 * @param <T>
	 *           object type
	 * @param list1
	 *           first list of lists of objects
	 * @param list2
	 *           second list of lists of objects
	 * @return the merged list of lists of objects
	 */
	public static <T> List<List<T>> createAndSetMerge(List<List<T>> list1, List<List<T>> list2) {
		List<List<T>> merge = new ArrayList<List<T>>();
		for (List<T> l1 : list1) {
			for (List<T> l2 : list2) {
				List<T> union = new ArrayList<T>();
				union.addAll(l1);
				union.addAll(l2);
				merge.add(union);
			}
		}
		return merge;
	}

	/**
	 * Given two lists of lists of objects L1 = {a, b, c, ...} and L2 = {x, y, z, ...}, creates list
	 * of lists of objects where each list is either (a) from L1, or (b) from L2, or (c) a union of a
	 * list from L1 and a list from L2, with all possible combinations of lists from L1 and L2:
	 * 
	 * {a, b, c, ..., x, y, z, ..., a+x, a+y, a+z, ..., b+x, b+y, b+z, ...}
	 * 
	 * @param <T>
	 *           object type
	 * @param list1
	 *           first list of lists of objects
	 * @param list2
	 *           second list of lists of objects
	 * @return the merged list of lists of objects
	 */
	public static <T> List<List<T>> createOrSetMerge(List<List<T>> list1, List<List<T>> list2) {
		List<List<T>> merge = new ArrayList<List<T>>();
		merge.addAll(list1);
		merge.addAll(list2);

		for (List<T> l1 : list1) {
			for (List<T> l2 : list2) {
				List<T> union = new ArrayList<T>();
				union.addAll(l1);
				union.addAll(l2);
				merge.add(union);
			}
		}
		return merge;
	}

	/**
	 * Given several lists of objects, creates union set of them.
	 * 
	 * @param <T>
	 *           object type
	 * @param lists
	 *           several lists of objects
	 * @return union of these lists
	 */
	public static <T> List<T> createSetUnion(List<List<T>> lists) {
		List<T> union = new ArrayList<T>();
		for (List<T> list : lists) {
			union.addAll(list);
		}
		return union;
	}

	/**
	 * Creates an enumeration constraint with the specified values.
	 * 
	 * @param name
	 *           the name of the constraint.
	 * @param values
	 *           a list of values.
	 * @return a new enumeration constraint without a parent.
	 */
	public static EnumerationConstraint createEnumerationConstraint(String name, List<?> values) {
		EnumerationConstraint c = ConstraintFactory.eINSTANCE.createEnumerationConstraint();
		c.setName(name);
		if (values != null) {
			for (Object value : values) {
				SingleValue sv = ConstraintFactory.eINSTANCE.createSingleValue();
				if (value instanceof Enumerator) {
					Enumerator e = (Enumerator) value;
					sv.setValue(e.getName());
				} else if (value instanceof String) {
					sv.setValue((String) value);
				} else if (value != null) {
					sv.setValue(value.toString());
				}
				c.getValues().add(sv);
			}
		}
		return c;
	}

	/**
	 * Checks whether the constraint itself or any of its child constraints is enabled for a given
	 * context.
	 * 
	 * We need this method to single-out constraints on Requirements that are enabled (i.e., should
	 * be validated in the context of parent Requirement).
	 * 
	 * @param constraint
	 *           the constraint
	 * @param context
	 *           the validation context
	 * @return true the constraint itself or any of its child constraints is enabled for a given
	 *         context; false otherwise
	 */
	public static boolean containsNonBooleanConstraintEnabledForContext(Constraint constraint,
			DeployModelObject context) {
		if (!(constraint instanceof BooleanOperator)
				&& ConstraintService.INSTANCE.isEnabledForContext(constraint, context)) {
			return true;
		}
		for (Constraint c : (List<Constraint>) constraint.getConstraints()) {
			if (containsNonBooleanConstraintEnabledForContext(c, context)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Validates for a potential match all the immediate child constraints of the Requirement,
	 * containing TypeConstraints, AttributeValue Constraints, Cardinality Constraints, and
	 * RequirementExpressions), but excepting Requirement Expressions, because they will be validated
	 * for match separately.
	 * 
	 * @param req
	 *           the Requirement
	 * @param validationContext
	 *           the deploy model object against which the constraints should be validated.
	 * @param constraintMatchWeight
	 *           to return the weight of the match, 0 <= X <= 100
	 * @return DeployMatcherStatus.MATCH_FOUND status, or status from first constraint validation
	 *         that failed.
	 */
	public static IStatus validateForMatchChildConstraintsOnRequirement(Requirement req,
			DeployModelObject validationContext, int[] constraintMatchWeight) {

		int numConstraintsSatisfied = 0;
		int numConstraintsChecked = 0; // need to filter Requirement Expressions and third-party constraints

		for (Constraint c : (List<Constraint>) req.getConstraints()) {
			// Special case - RequirementExpressions on Requirements evaluated in legacy code.
			// Constraints that should be validated in the context of parent Requirement (i.e., not relevant to Requirement 
			// semantics) are not validated.
			if (!containsNonBooleanConstraintEnabledForContext(c, req)
					&& !(c instanceof RequirementExpression)) {
				DeployModelObject contextDMO = validationContext;
				// If passed Capability for context and TypeConstraint and hosting req, convert context
				if (c instanceof TypeConstraint && contextDMO instanceof Capability
						&& req.getLinkType().equals(RequirementLinkTypes.HOSTING_LITERAL)) {
					contextDMO = contextDMO.getParent();
				}

				// validate the constraint
				IStatus matchStatus = ConstraintService.INSTANCE.validateForPotentialMatch(c,
						contextDMO);
				int constraintSize = ConstraintUtil.computeConstraintSize(c);
				numConstraintsChecked = numConstraintsChecked + constraintSize;
				if (!matchStatus.isOK()) {
					return matchStatus;
				}
				IStatus validationStatus = ConstraintService.INSTANCE.validate(c, contextDMO,
						new NullProgressMonitor());
				if (validationStatus.isOK()) {
					numConstraintsSatisfied = numConstraintsSatisfied + constraintSize;
				} else {
					//Count statuses returned.
					if (validationStatus.isMultiStatus()) {
						int[] count = { 0 };
						countFailedStatuses(validationStatus, count);
						numConstraintsSatisfied = numConstraintsSatisfied - (constraintSize - count[0]);
					}
				}
			}
		}

		constraintMatchWeight[0] = (int) Math.round(50.0 * (1.0 + (1.0 + numConstraintsSatisfied)
				/ (1.0 + numConstraintsChecked)));

		return DeployMatcherStatus.MATCH_FOUND;
	}

	private static void countFailedStatuses(IStatus status, int[] count) {
		if (status == null || status.isOK() && status.getSeverity() != IStatus.CANCEL) {
			//No Failure
			return;
		}
		if (status.isMultiStatus()) {
			//Traverse children.
			IStatus[] children = ((MultiStatus) status).getChildren();
			for (IStatus childStatus : children) {
				countFailedStatuses(childStatus, count);
			}
		} else {
			//The single status is a failure.
			count[0] = count[0] + 1;
		}
	}

	/**
	 * This API will calculate the true number of constraints that will be evaluated including child
	 * constraints. The API will count all leaf constraints as well as any non-boolean parent
	 * constraint.
	 * 
	 * @param dmo
	 * @return An int indicating the number of constraints.
	 */
	@SuppressWarnings("unchecked")
	public static int computeConstraintSize(DeployModelObject dmo) {
		int[] count = null;
		if (dmo instanceof Constraint) {
			count = new int[] { 0 };
			countConstraints((Constraint) dmo, count);
		} else {
			List<Constraint> constraints = dmo.getConstraints();
			if (constraints.isEmpty()) {
				return dmo instanceof Constraint ? 1 : 0;
			}
			count = new int[] { 0 };
			for (Constraint constraint : constraints) {
				countConstraints(constraint, count);
			}
		}
		return count[0];
	}

	@SuppressWarnings("unchecked")
	private static void countConstraints(Constraint aConstraint, int[] count) {
		List<Constraint> constraints = aConstraint.getConstraints();
		if (constraints.isEmpty()) {
			count[0] = count[0] + 1;
		} else {
			if (!(aConstraint instanceof BooleanOperator)) {
				count[0] = count[0] + 1;
			}
			for (Constraint constraint : constraints) {
				countConstraints(constraint, count);
			}
		}
	}

	/**
	 * Returns the first non-constraint DMO up the containment ladder.
	 * 
	 * @param object
	 *           DMO
	 * @return the first non-constraint DMO up the containment ladder (may be the object itself)
	 */
	public static DeployModelObject getNonConstraintParent(DeployModelObject object) {
		while (object != null && object instanceof Constraint) {
			object = object.getParent();
		}
		return object;
	}
}
