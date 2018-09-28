/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.constraints;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.AttributePropagationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.impl.DeployLinkImpl;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.util.RealizationLinkUtil;
import com.ibm.ccl.soa.deploy.core.validator.ConstraintService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.link.MultiplicityChecker;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Constraint validator for {@link AttributePropagationConstraint}.
 */
public class AttributePropagationConstraintValidator extends ConstraintValidator {

	@Override
	public boolean canValidateConstraint(Constraint constraint) {
		return constraint instanceof AttributePropagationConstraint;
	}

	@Override
	public IStatus validate(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor) {
		if (!canValidateConstraint(constraint)) {
			return CANCEL_STATUS;
		}
		AttributePropagationConstraint apc = (AttributePropagationConstraint) constraint;
		if (context == null) {
			return ConstraintUtil.createNullContextStatus(apc);
		}

		List<IStatus> statusList = new ArrayList<IStatus>(4);
		StatusInOutParameter statusResult = new StatusInOutParameter();

		// Source object can be found
		statusResult.clear();
		List<DeployModelObject> sourceDmos = getSourceObjects(apc, context, statusResult);
		if (statusResult.hasStatus()) {
			statusList.addAll(statusResult.getStatuses());
		} else if (sourceDmos == null || sourceDmos.isEmpty()) {
			IStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(IStatus.ERROR, apc
					.eClass().getName(), ICoreProblemType.OBJECT_ATTRIBUTE_INVALID,
					DeployCoreMessages.Attribute_propagation_constraint_0_can_not_resolve_source_object,
					new Object[] { title(apc) }, apc, ConstraintPackage.eINSTANCE
							.getAttributePropagationConstraint_SourceObjectURI());
			statusList.add(status);
		}

		// Source attribute name is defined
		if (apc.getSourceAttributeName() == null || apc.getSourceAttributeName().trim().length() == 0) {
			IStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(IStatus.ERROR, apc
					.eClass().getName(), ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED,
					DeployCoreMessages.Attribute_propagation_constraint_0_empty_source_attribute_name,
					new Object[] { title(apc) }, apc, ConstraintPackage.eINSTANCE
							.getAttributePropagationConstraint_SourceAttributeName());
			statusList.add(status);
		}

		// Target object can be resolved
		statusResult.clear();
		List<DeployModelObject> targetDmos = getTargetObjects(apc, context, statusResult);
		if (statusResult.hasStatus()) {
			statusList.addAll(statusResult.getStatuses());
		} else if (targetDmos == null || targetDmos.isEmpty()) {
			IStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(IStatus.ERROR, apc
					.eClass().getName(), ICoreProblemType.OBJECT_ATTRIBUTE_INVALID,
					DeployCoreMessages.Attribute_propagation_constraint_0_can_not_resolve_target_object,
					new Object[] { title(apc) }, apc, ConstraintPackage.eINSTANCE
							.getAttributePropagationConstraint_TargetObjectURI());
			statusList.add(status);
		}

		// Target object attribute is undefined
		if (apc.getTargetAttributeName() == null || apc.getTargetAttributeName().trim().length() == 0) {
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(
					IStatus.ERROR, apc.eClass().getName(), ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED,
					DeployCoreMessages.Attribute_propagation_constraint_0_empty_target_attribute_name,
					new Object[] { title(apc) }, apc, ConstraintPackage.eINSTANCE
							.getAttributePropagationConstraint_TargetAttributeName());
			statusList.add(status);
		}

		for (DeployModelObject sourceDmo : sourceDmos) {
			for (DeployModelObject targetDmo : targetDmos) {
				// get final realizations of source and target
				DeployModelObject sourceDmoFinalRealiz = RealizationLinkUtil
						.getImplicitFinalRealization(sourceDmo);
				DeployModelObject targetDmoFinalRealiz = RealizationLinkUtil
						.getImplicitFinalRealization(targetDmo);

				boolean sourceDefined = false;
				EDataType sourceType = null;
				Object sourceValue = null;
				if (sourceDmoFinalRealiz != null && apc.getSourceAttributeName() != null
						&& apc.getSourceAttributeName().trim().length() != 0) {
					// Source value can be obtained
					statusResult.clear();
					sourceValue = getAttributeValue(apc, sourceDmoFinalRealiz, apc
							.getSourceAttributeName(), ConstraintPackage.eINSTANCE
							.getAttributePropagationConstraint_SourceAttributeName(), statusResult);
					sourceType = statusResult.getAttrDataType();
					if (statusResult.hasStatus()) {
						statusList.addAll(statusResult.getStatuses());
					} else {
						sourceDefined = true;
					}
				}
				boolean targetDefined = false;
				EDataType targetType = null;
				Object targetValue = null;
				if (targetDmoFinalRealiz != null && apc.getTargetAttributeName() != null
						&& apc.getTargetAttributeName().trim().length() != 0) {
					// Target attribute can be obtained
					statusResult.clear();
					targetValue = getAttributeValue(apc, targetDmoFinalRealiz, apc
							.getTargetAttributeName(), ConstraintPackage.eINSTANCE
							.getAttributePropagationConstraint_TargetAttributeName(), statusResult);
					targetType = statusResult.getAttrDataType();
					if (statusResult.hasStatus()) {
						statusList.addAll(statusResult.getStatuses());
					} else {
						targetDefined = true;
					}
				}
				if (sourceDefined && targetDefined) {
					if (!isRelaxedEquals(sourceValue, sourceType, targetValue, targetType)) {
						// values are not the same, let's try to convert them
						ConversionResult convertedSourceValue = convertAttributeValue(sourceValue,
								sourceType, targetType, targetValue instanceof List);
						if (convertedSourceValue.isSuccessful()) {
							// conversion was successful: create Attribute Value Status 
							statusList.add(DeployCoreStatusFactory.INSTANCE.createAttributeValueStatus(
									IStatus.ERROR, apc.eClass().getName(),
									ICoreProblemType.OBJECT_ATTRIBUTE_INVALID,
									DeployCoreMessages.Validator_deploy_model_object_0_attribute_1_invalid,
									new Object[] { targetDmoFinalRealiz, apc.getTargetAttributeName() },
									targetDmoFinalRealiz, apc.getTargetAttributeName(), convertedSourceValue
											.getValue()));
						} else {
							// conversion was unsuccessful: 
							// create Constraint Malfromed Status, because propagation can not be performed 
							statusList
									.add(DeployCoreStatusFactory.INSTANCE
											.createDeployStatus(
													IStatus.ERROR,
													apc.eClass().getName(),
													ICoreProblemType.CONSTRAINT_MALFORMED,
													DeployCoreMessages.Attribute_propagation_constraint_0_can_not_convert_value,
													new Object[] { ConstraintService.INSTANCE.title(constraint) },
													constraint));
						}
					}
				}
			} // for each target
		} // for each source

		if (statusList.size() > 1) {
			return ConstraintUtil.createMultiStatus(statusList);
		} else if (statusList.size() == 1) {
			return statusList.get(0);
		}
		return Status.OK_STATUS;
	}

	@Override
	public DeployModelObject getContextForChildConstraints(Constraint constraint) {
		return null;
	}

	@Override
	public String title(Constraint constraint) {
		AttributePropagationConstraint apc = (AttributePropagationConstraint) constraint;
		StringBuffer buf = new StringBuffer(computeTypeName(apc));
		buf.append(" (").append(apc.getSourceAttributeName()).append(" -> ").append( //$NON-NLS-1$ //$NON-NLS-2$
				apc.getTargetAttributeName()).append(")");//$NON-NLS-1$
		return buf.toString();
	}

	/**
	 * Computes the source DMO, taking into account the 'respectLinkDirection' attribute of the
	 * constraint.
	 * 
	 * @param apc
	 *           the attribute propagation constraint
	 * @param context
	 *           the context DMO
	 * @param outStatus
	 *           mutable parameter used to provide failure information.
	 * 
	 * @return the source DMO
	 */
	public static List<DeployModelObject> getSourceObjects(AttributePropagationConstraint apc,
			DeployModelObject context, StatusInOutParameter outStatus) {
		List<DeployModelObject> bases = null;
		if (apc.isRespectLinkDirection()) {
			bases = getBaseSourceObjects(apc, context, outStatus);
			if (outStatus.hasStatus()) {
				return Collections.emptyList();
			}
		} else {
			bases = getBaseTargetObjects(apc, context, outStatus);
			if (outStatus.hasStatus()) {
				return Collections.emptyList();
			}
		}
		if (bases == null || bases.isEmpty()) {
			return Collections.emptyList();
		}
		if (apc.getSourceObjectURI() == null || apc.getSourceObjectURI().trim().length() == 0) {
			return bases;
		}
		List<DeployModelObject> result = new ArrayList<DeployModelObject>(bases.size());
		for (DeployModelObject base : bases) {
			DeployModelObject obj = base.resolve(apc.getSourceObjectURI().trim());
			if (obj == null) {
				outStatus
						.addStatus(DeployCoreStatusFactory.INSTANCE
								.createAttributeStatus(
										IStatus.ERROR,
										apc.eClass().getName(),
										ICoreProblemType.OBJECT_ATTRIBUTE_INVALID,
										DeployCoreMessages.Attribute_propagation_constraint_0_can_not_resolve_object_1_on_2,
										new Object[] { title_static(apc), apc.getSourceObjectURI(), base },
										apc, ConstraintPackage.eINSTANCE
												.getAttributePropagationConstraint_SourceObjectURI()));
			} else {
				result.add(obj);
			}
		}
		return result;
	}

	/**
	 * Computes the target DMO, taking into account the 'respectLinkDirection' attribute of the
	 * constraint.
	 * 
	 * @param constraint
	 *           the constraint
	 * @param context
	 *           the context DMO
	 * @param outStatus
	 *           mutable parameter used to provide failure information.
	 * 
	 * @return the target DMO
	 */
	public static List<DeployModelObject> getTargetObjects(
			AttributePropagationConstraint constraint, DeployModelObject context,
			StatusInOutParameter outStatus) {
		List<DeployModelObject> bases = null;
		if (constraint.isRespectLinkDirection()) {
			bases = getBaseTargetObjects(constraint, context, outStatus);
			if (outStatus.hasStatus()) {
				return Collections.emptyList();
			}
		} else {
			bases = getBaseSourceObjects(constraint, context, outStatus);
			if (outStatus.hasStatus()) {
				return Collections.emptyList();
			}
		}
		if (bases == null || bases.isEmpty()) {
			return Collections.emptyList();
		}
		if (constraint.getTargetObjectURI() == null
				|| constraint.getTargetObjectURI().trim().length() == 0) {
			return bases;
		}

		List<DeployModelObject> result = new ArrayList<DeployModelObject>(bases.size());
		for (DeployModelObject base : bases) {
			DeployModelObject obj = base.resolve(constraint.getTargetObjectURI().trim());
			if (obj == null) {
				outStatus
						.addStatus(DeployCoreStatusFactory.INSTANCE
								.createAttributeStatus(
										IStatus.ERROR,
										constraint.eClass().getName(),
										ICoreProblemType.OBJECT_ATTRIBUTE_INVALID,
										DeployCoreMessages.Attribute_propagation_constraint_0_can_not_resolve_object_1_on_2,
										new Object[] { title_static(constraint),
												constraint.getTargetObjectURI(), base }, constraint,
										ConstraintPackage.eINSTANCE
												.getAttributePropagationConstraint_TargetObjectURI()));
			} else {
				result.add(obj);
			}
		}
		return result;
	}

	/**
	 * Computes the base source object of the propagation constraint.
	 * <p>
	 * The base source object is define by its context based on the rules defined in
	 * {@link AttributePropagationConstraint}.
	 * 
	 * @param apc
	 *           the attribute propagation constraint
	 * @param context
	 *           the context on which the constraint is defined
	 * @param outStatus
	 *           mutable parameter used to provide failure information.
	 * @return the 'base' source object, or null if not found
	 */
	public static List<DeployModelObject> getBaseSourceObjects(AttributePropagationConstraint apc,
			DeployModelObject context, StatusInOutParameter outStatus) {
		DeployModelObject source = null;
		if (context instanceof Requirement) {
			source = ValidatorUtils.getUnit(context);
		} else if (context instanceof DependencyLink) {
			source = ValidatorUtils.getUnit(((DependencyLink) context).getSource());
		} else if (context instanceof HostingLink) {
			source = ((HostingLink) context).getHost();
		} else if (context instanceof MemberLink) {
			source = ((MemberLink) context).getSource();
		} else if (context instanceof ConstraintLink) {
			source = ((ConstraintLink) context).getSource();
		} else if (context instanceof RealizationLink) {
			source = ((RealizationLink) context).getSource();
		} else if (context instanceof DeployLinkImpl) {
			source = ((DeployLinkImpl) context).getSourceObject();
		} else {
			source = context;
		}
		if (source == null) {
			outStatus.addStatus(DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.WARNING,
					apc.eClass().getName(), ICoreProblemType.CONSTRAINT_NOT_ENOUGH_INFO_TO_VALIDATE,
					DeployCoreMessages.Attribute_propagation_constraint_0_source_not_in_topology,
					new Object[] { title_static(apc) }, apc));
			return Collections.emptyList();
		}
		return Collections.singletonList(source);
	}

	/**
	 * Computes the base source object of the propagation constraint.
	 * <p>
	 * The base source object is define by its context based on the rules defined in
	 * {@link AttributePropagationConstraint}.
	 * 
	 * @param apc
	 *           the attribute propagation constraint
	 * @param context
	 *           the context on which the constraint is defined
	 * @param outStatus
	 *           mutable parameter used to provide failure information.
	 * @return the 'base' source object, or null if not found
	 */
	public static List<DeployModelObject> getBaseTargetObjects(AttributePropagationConstraint apc,
			DeployModelObject context, StatusInOutParameter outStatus) {
		List<DeployModelObject> targets = null;
		DeployModelObject target = null;
		if (context instanceof Requirement) {
			Requirement req = (Requirement) context;
			switch (req.getLinkType().getValue())
			{
			case RequirementLinkTypes.DEPENDENCY: {
				// DependencyLink: requirement -> capability
				Collection<Capability> caps = req.getTopology().getRelationships()
						.getDependencyTargets(req);
				targets = new ArrayList<DeployModelObject>(caps);
				break;
			}
			case RequirementLinkTypes.HOSTING: {
				// HostingLink: host -> hosted
				Collection<Unit> hosts = req.getTopology().getRelationships().getHost(
						ValidatorUtils.getUnit(req));
				targets = new ArrayList<DeployModelObject>(hosts);
				break;
			}
			case RequirementLinkTypes.MEMBER: {
				// MemberLink: group -> member
				if (MultiplicityChecker.isGroup(req)) {
					Collection<Unit> members = req.getTopology().getRelationships().getMembers(
							ValidatorUtils.getUnit(req));
					targets = new ArrayList<DeployModelObject>(members);
				} else {
					Collection<Unit> groups = req.getTopology().getRelationships().getContainer(
							ValidatorUtils.getUnit(req));
					targets = new ArrayList<DeployModelObject>(groups);
				}
				break;
			}
			default:
				outStatus
						.addStatus(DeployCoreStatusFactory.INSTANCE
								.createDeployStatus(
										IStatus.ERROR,
										apc.eClass().getName(),
										ICoreProblemType.CONSTRAINT_PLACEMENT_INVALID,
										DeployCoreMessages.Attribute_propagation_constraint_0_unsupported_requirement_1_link_type_2,
										new Object[] { title_static(apc), req, req.getLinkType() }, apc));
			}
		} else if (context instanceof DependencyLink) {
			target = ((DependencyLink) context).getTarget();
		} else if (context instanceof HostingLink) {
			target = ((HostingLink) context).getHosted();
		} else if (context instanceof MemberLink) {
			target = ((MemberLink) context).getTarget();
		} else if (context instanceof ConstraintLink) {
			target = ((ConstraintLink) context).getTarget();
		} else if (context instanceof RealizationLink) {
			target = ((RealizationLink) context).getTarget();
		} else if (context instanceof DeployLinkImpl) {
			target = ((DeployLinkImpl) context).getTargetObject();
		} else {
			target = context;
		}
		if (target == null && (targets == null || targets.isEmpty())) {
			outStatus.addStatus(DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.WARNING,
					apc.eClass().getName(), ICoreProblemType.CONSTRAINT_NOT_ENOUGH_INFO_TO_VALIDATE,
					DeployCoreMessages.Attribute_propagation_constraint_0_target_not_in_topology,
					new Object[] { title_static(apc) }, apc));
			return Collections.emptyList();
		}
		if (targets != null) {
			if (target != null) {
				targets.add(target);
			}
			return targets;
		}
		return Collections.singletonList(target);
	}

	/**
	 * Gets the value of the attribute.
	 * 
	 * @param constraint
	 *           the Attribute Propagation Constraint, not null.
	 * @param object
	 *           DeployModelObject, not null.
	 * @param attributeName
	 *           the name of the attribute, not null.
	 * @param refAttr
	 *           the attribute which stores the attribute name (used as a reference in reporting
	 *           errors).
	 * @param outStatus
	 *           mutable parameter used to provide failure information.
	 * 
	 * @return the attribute value
	 */
	public Object getAttributeValue(AttributePropagationConstraint constraint,
			DeployModelObject object, String attributeName, EAttribute refAttr,
			StatusInOutParameter outStatus) {
		assert constraint != null;
		assert object != null;
		assert attributeName != null;

		// Check static attribute
		EStructuralFeature esf = object.eClass().getEStructuralFeature(attributeName);
		if (esf instanceof EAttribute) {
			EAttribute attribute = (EAttribute) esf;
			outStatus.setAttrDataType(attribute.getEAttributeType());
			if (object.eIsSet(attribute)) {
				return object.eGet(attribute);
			}
			return null;
		}

		// Check dynamic attribute
		if (object instanceof Capability) {
			ExtendedAttribute ea = ((Capability) object).getExtendedAttribute(attributeName);
			if (ea != null) {
				outStatus.setAttrDataType(ea.getInstanceType());
				return ea.getValue();
			}
		}

		// No such attribute was found
		outStatus.addStatus(DeployCoreStatusFactory.INSTANCE.createAttributeStatus(IStatus.ERROR,
				constraint.eClass().getName(), ICoreProblemType.CONSTRAINT_MALFORMED,
				DeployCoreMessages.Attribute_constraint_0_attribute_1_not_found_on_object_2,
				new Object[] { title(constraint), attributeName, object }, constraint, refAttr));
		return null;
	}

	/**
	 * Checks two attribute values for equality.
	 * <p>
	 * Performs a relaxed check for equality using:
	 * <ul>
	 * <li> Values that are singletons (not List) are compared using the
	 * {@link AttributePropagationConstraintValidator#isRelaxedObjectEquals(Object, EDataType, Object, EDataType)}
	 * method.
	 * <li> Lists are compared element-by-element () using the
	 * {@link AttributePropagationConstraintValidator#isRelaxedObjectEquals(Object, EDataType, Object, EDataType)}
	 * method.
	 * <li> Empty list is treated as a NULL value.
	 * <li> List of size 1 is treated as its single element.
	 * </ul>
	 * 
	 * @param o1
	 *           object 1 (may be null).
	 * @param o1Type
	 *           data type of object 1, needed for type conversion.
	 * @param o2
	 *           object 2 (may be null).
	 * @param o2Type
	 *           data type of object 2, needed for type comversion.
	 * @return true if the objects are equal under the relaxed equality rules.
	 */
	public static boolean isRelaxedEquals(Object o1, EDataType o1Type, Object o2, EDataType o2Type) {
		if (o1 instanceof List) {
			List list1 = (List) o1;
			if (o2 instanceof List) {
				// o1 is List, o2 is List
				List list2 = (List) o2;
				if (list1.size() != list2.size()) {
					return false;
				}
				int i = 0;
				for (Object obj1 : list1) {
					Object obj2 = list2.get(i);
					if (!isRelaxedObjectEquals(obj1, o1Type, obj2, o2Type)) {
						return false;
					}
					i++;
				}
				return true;
			}
			// o1 is List, o2 is single value
			if (list1.size() == 0) {
				if (!isRelaxedObjectEquals(null, o1Type, o2, o2Type)) {
					return false;
				}
			} else if (list1.size() == 1) {
				if (!isRelaxedObjectEquals(list1.get(0), o1Type, o2, o2Type)) {
					return false;
				}
			} else {
				// list1 contains > 1 element
				return false;
			}
			return true;
		}

		if (o2 instanceof List) {
			// o1 is single value, o2 is List			
			List list2 = (List) o2;
			if (list2.size() == 0) {
				if (!isRelaxedObjectEquals(o1, o1Type, null, o2Type)) {
					return false;
				}
			} else if (list2.size() == 1) {
				if (!isRelaxedObjectEquals(o1, o1Type, list2.get(0), o2Type)) {
					return false;
				}
			} else {
				// list2 contains > 1 element
				return false;
			}
			return true;
		}

		// o1 is single value, o2 is single value			
		return isRelaxedObjectEquals(o1, o1Type, o2, o2Type);
	}

	/**
	 * Checks two attribute values for equality.
	 * <p>
	 * Performs a relaxed check for equality using:
	 * <ul>
	 * <li> Null values are equal to empty strings
	 * <li> If objects are not equal they are compared after converting them to strings using
	 * {@link EcoreUtil#convertToString(EDataType, Object)} method.
	 * </ul>
	 * 
	 * @param o1
	 *           object 1 (may be null).
	 * @param o1Type
	 *           data type of object 1, needed for type conversion.
	 * @param o2
	 *           object 2 (may be null).
	 * @param o2Type
	 *           data type of object 2, needed for type comversion.
	 * @return true if the objects are equal under the relaxed equality rules.
	 */
	public static boolean isRelaxedObjectEquals(Object o1, EDataType o1Type, Object o2,
			EDataType o2Type) {
		if (o1 == o2) {
			return true;
		}
		// Treat null and empty string as equals
		if (o1 == null || o1 instanceof String && ((String) o1).length() == 0) {
			return o2 == null || o2 instanceof String && ((String) o2).length() == 0;
		}
		if (o2 == null || o2 instanceof String && ((String) o2).length() == 0) {
			return o1 == null || o1 instanceof String && ((String) o1).length() == 0;
		}
		// neither o1 or o2 are null
		if (o1.equals(o2)) {
			return true;
		}

		// For non-assignable types, try the toString comparison 
		// if (!o1.getClass().isAssignableFrom(o2.getClass())
		//		&& !o2.getClass().isAssignableFrom(o1.getClass())) {
		//	if (o1 instanceof String) {
		//		return isRelaxedObjectEquals(o1, o1Type, o2.toString(), o2Type);
		//	}
		//	if (o2 instanceof String) {
		//		return isRelaxedObjectEquals(o1.toString(), o1Type, o2, o2Type);
		//	}
		//	return o1.toString().equals(o2.toString());
		//}

		// compare values by converting them to strings using their data types
		String o1str = o1Type == null ? o1.toString() : EcoreUtil.convertToString(o1Type, o1);
		String o2str = o2Type == null ? o2.toString() : EcoreUtil.convertToString(o2Type, o2);
		return o1str.equals(o2str);
	}

	/**
	 * Converts object into corresponding object of different EDataType, using conversion through a
	 * string value, potentially wrapping it into a List, or unwrapping it from the List (e.g., List
	 * of Strings with 1 element (string "1") is converted into BigInteger(1)).
	 * 
	 * @param value
	 *           the source value
	 * @param valueType
	 *           the source value datatype
	 * @param targetType
	 *           target datatype
	 * @param targetIsMany
	 *           if true: converted value must be a List (of converted values); if false: converted
	 *           value must be a single value.
	 * 
	 * @return ConvertedValue object; never null.
	 */
	public static ConversionResult convertAttributeValue(Object value, EDataType valueType,
			EDataType targetType, boolean targetIsMany) {

		if (value == null || value instanceof String && ((String) value).length() == 0) {
			if (targetIsMany) {
				return new ConversionResult(new LinkedList(), true);
			} else {
				return new ConversionResult(null, true);
			}
		}

		if (targetIsMany) {
			List convertedValueAsList = new LinkedList();
			if (value instanceof List) {
				// 'value' is List, 'converted value' is List 
				// copy the values from one list to another
				List valueAsList = (List) value;
				for (Object v : valueAsList) {
					if (targetType.isInstance(v)) {
						convertedValueAsList.add(v);
					} else {
						ConversionResult cValue = convertSingleObject(v, valueType, targetType);
						if (cValue.isSuccessful()) {
							convertedValueAsList.add(cValue.getValue());
						} else {
							return new ConversionResult(null, false);
						}
					}
				}
				return new ConversionResult(convertedValueAsList, true);
			}
			// 'value' is a single value, 'converted value' is List 
			if (targetType.isInstance(value)) {
				convertedValueAsList.add(value);
			} else {
				ConversionResult cValue = convertSingleObject(value, valueType, targetType);
				if (cValue.isSuccessful()) {
					convertedValueAsList.add(cValue.getValue());
				} else {
					return new ConversionResult(null, false);
				}
			}
			return new ConversionResult(convertedValueAsList, true);
		}

		if (value instanceof List) {
			// 'value' is List, 'converted value' is a single value,  
			List valueAsList = (List) value;
			Object convertedValue = null;
			if (valueAsList.isEmpty()) {
				convertedValue = null;
			} else if (valueAsList.size() == 1) {
				Object v = valueAsList.get(0);
				if (v == null) {
					convertedValue = null;
				} else if (targetType.isInstance(v)) {
					convertedValue = v;
				} else {
					ConversionResult cValue = convertSingleObject(v, valueType, targetType);
					if (cValue.isSuccessful()) {
						convertedValue = cValue.getValue();
					} else {
						return new ConversionResult(null, false);
					}
				}
			} else {
				// 'value' is a List with more than one value
				return new ConversionResult(null, false);
			}
			return new ConversionResult(convertedValue, true);
		}

		// 'value' is single value, 'converted value' is single value 
		if (!targetType.isInstance(value)) {
			return convertSingleObject(value, valueType, targetType);
		}
		return new ConversionResult(value, true);
	}

	/**
	 * Converts object into an object of different EDataType, using conversion through a string value
	 * (e.g., String "1" is converted into BigInteger(1)).
	 * 
	 * @param value
	 *           the original value
	 * @param valueType
	 *           data type of value
	 * @param targetType
	 *           target data type of the value
	 * 
	 * @return ConvertedValue object, never null
	 */
	private static ConversionResult convertSingleObject(Object value, EDataType valueType,
			EDataType targetType) {
		if (value == null || value instanceof String && ((String) value).length() == 0) {
			return new ConversionResult(null, true);
		}
		try {
			Object convertedValue = EcoreUtil.createFromString(targetType, valueType == null ? value
					.toString() : EcoreUtil.convertToString(valueType, value));
			return new ConversionResult(convertedValue, true);
		} catch (Exception e) {
			// DeployCorePlugin.log(IStatus.ERROR, 0, DeployCoreMessages.Error_deserializing_value, e);
			return new ConversionResult(null, false);
		}
	}

	private static String title_static(AttributePropagationConstraint constraint) {
		AttributePropagationConstraintValidator apcv = new AttributePropagationConstraintValidator();
		return apcv.title(constraint);
	}

	private static class ConversionResult {
		private final Object convertedValue;
		private final boolean success;

		private ConversionResult(Object o, boolean s) {
			convertedValue = o;
			success = s;
		}

		private Object getValue() {
			return convertedValue;
		}

		private boolean isSuccessful() {
			return success;
		}
	}
}
