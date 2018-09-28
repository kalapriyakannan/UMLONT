/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.status;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.FilterIterator;
import com.ibm.ccl.soa.deploy.core.util.IObjectFilter;
import com.ibm.ccl.soa.deploy.core.util.ObjectTypeFilter;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Factory for generating common types of {@link IDeployStatus} instances.
 * <p>
 * Methods combine the problem type with the message type for reusability across validators.
 * 
 * @see DeployCoreStatusFactory
 */
public class DeployCoreStatusUtil {

	/**
	 * Creates status for an undefined attribute.
	 * 
	 * @param object
	 *           the object whose property is undefined.
	 * @param attribute
	 *           the attribute that is undefined.
	 * @return the status created.
	 * @deprecated use
	 *             {@link #createAttributeUndefinedStatus(int, String, DeployModelObject, EAttribute)}.
	 */
	public static IDeployAttributeStatus createObjectAttributeUndefinedStatus(
			DeployModelObject object, EAttribute attribute) {
		return createAttributeUndefinedStatus(IStatus.ERROR, IDeployCoreValidators.CORE_UNASSIGNED,
				object, attribute);
	}

	/**
	 * Creates status for an undefined attribute.
	 * 
	 * @param severity
	 *           the severity of the status.
	 * @param validatorID
	 *           the ID of the validator which created this status.
	 * @param object
	 *           the object whose property is undefined.
	 * @param attribute
	 *           the attribute that is undefined.
	 * @return the status created.
	 */
	public static IDeployAttributeStatus createAttributeUndefinedStatus(int severity,
			String validatorID, DeployModelObject object, EAttribute attribute) {
		IDeployAttributeStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(
				severity, validatorID, ICoreProblemType.OBJECT_ATTRIBUTE_UNDEFINED,
				DeployCoreMessages.Validator_deploy_model_object_0_attribute_1_undefined, new Object[] {
						object, attribute }, object, attribute);
		return status;
	}

	/**
	 * Creates status for an invalid attribute.
	 * 
	 * @param object
	 *           the object whose property is invalid.
	 * @param attribute
	 *           the attribute that is invalid.
	 * @return the status created.
	 * @deprecated use
	 *             {@link #createAttributeInvalidStatus(int, String, DeployModelObject, EAttribute)}
	 */
	public static IDeployAttributeStatus createObjectAttributeInvalidStatus(
			DeployModelObject object, EAttribute attribute) {
		return createAttributeInvalidStatus(IStatus.ERROR, IDeployCoreValidators.CORE_UNASSIGNED,
				object, attribute);
	}

	/**
	 * Creates status for an invalid attribute.
	 * 
	 * @param severity
	 *           the severity of the status.
	 * @param validatorID
	 *           the ID of the validator which created this status.
	 * @param object
	 *           the object whose property is invalid.
	 * @param attribute
	 *           the attribute that is invalid.
	 * @return the status created.
	 */
	public static IDeployAttributeStatus createAttributeInvalidStatus(int severity,
			String validatorID, DeployModelObject object, EAttribute attribute) {
		IDeployAttributeStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(
				severity, validatorID, ICoreProblemType.OBJECT_ATTRIBUTE_INVALID,
				DeployCoreMessages.Validator_deploy_model_object_0_attribute_1_invalid, new Object[] {
						object, attribute }, object, attribute);
		return status;
	}

	/**
	 * Creates a status for an object with an invalid attribute whose expected value is known.
	 * 
	 * @param object
	 *           the object whose property is invalid.
	 * @param attribute
	 *           the attribute that is invalid.
	 * @param value
	 *           the serialized value.
	 * @return the status created.
	 * @deprecated use
	 *             {@link #createAttributeInvalidStatus(int, String, DeployModelObject, EAttribute, Object)}.
	 */
	public static IDeployAttributeValueStatus createObjectAttributeInvalidStatus(
			DeployModelObject object, EAttribute attribute, Object value) {
		return createAttributeInvalidStatus(IStatus.ERROR, IDeployCoreValidators.CORE_UNASSIGNED,
				object, attribute, value);
	}

	/**
	 * Creates a status for an object with an invalid attribute whose expected value is known.
	 * 
	 * @param severity
	 *           the severity of the status.
	 * @param validatorID
	 *           the ID of the validator which created this status.
	 * @param object
	 *           the object whose property is invalid.
	 * @param attribute
	 *           the attribute that is invalid.
	 * @param value
	 *           the serialized value.
	 * @return the status created.
	 */
	public static IDeployAttributeValueStatus createAttributeInvalidStatus(int severity,
			String validatorID, DeployModelObject object, EAttribute attribute, Object value) {
		IDeployAttributeValueStatus status = DeployCoreStatusFactory.INSTANCE
				.createAttributeValueStatus(severity, validatorID,
						ICoreProblemType.OBJECT_ATTRIBUTE_INVALID,
						DeployCoreMessages.Validator_deploy_model_object_0_attribute_1_invalid,
						new Object[] { object, attribute }, object, attribute, value);
		return status;
	}

	/**
	 * Creates a status for an object with an invalid attribute whose expected value is known.
	 * 
	 * @param severity
	 *           the severity of the status.
	 * @param validatorID
	 *           the ID of the validator which created this status.
	 * @param object
	 *           the object whose property is invalid.
	 * @param attributeName
	 *           the name of the attribute that is invalid.
	 * @param value
	 *           the serialized value.
	 * @return the status created.
	 */
	public static IDeployAttributeValueStatus createAttributeInvalidStatus(int severity,
			String validatorID, DeployModelObject object, String attributeName, Object value) {
		IDeployAttributeValueStatus status = DeployCoreStatusFactory.INSTANCE
				.createAttributeValueStatus(severity, validatorID,
						ICoreProblemType.OBJECT_ATTRIBUTE_INVALID,
						DeployCoreMessages.Validator_deploy_model_object_0_attribute_1_invalid,
						new Object[] { object, attributeName }, object, attributeName, value);
		return status;
	}

	/**
	 * Creates a status for an object with an invalid attribute whose expected value is known, and
	 * its source object/attribute can be identified.
	 * 
	 * @param object
	 *           the object whose property is invalid.
	 * @param attribute
	 *           the attribute that is invalid.
	 * @param source
	 *           the source object from which the value was propagated.
	 * @param sourceAttribute
	 *           the attribute of the source object from which the value was propagated.
	 * @return the status created.
	 * @deprecated use
	 *             {@link #createAttributeInvalidSourceValueStatus(int, String, DeployModelObject, EAttribute, DeployModelObject, EAttribute)}.
	 */
	public static IDeployAttributeValueSourceStatus createObjectAttributeInvalidSourceValueStatus(
			DeployModelObject object, EAttribute attribute, DeployModelObject source,
			EAttribute sourceAttribute) {
		return createAttributeInvalidSourceValueStatus(IStatus.ERROR,
				IDeployCoreValidators.CORE_UNASSIGNED, object, attribute, source, sourceAttribute);
	}

	/**
	 * Creates a status for an object with an invalid attribute whose expected value is known, and
	 * its source object/attribute can be identified.
	 * 
	 * @param severity
	 *           the severity of the status.
	 * @param validatorID
	 *           the ID of the validator which created this status.
	 * @param object
	 *           the object whose property is invalid.
	 * @param attribute
	 *           the attribute that is invalid.
	 * @param source
	 *           the source object from which the value was propagated.
	 * @param sourceAttribute
	 *           the attribute of the source object from which the value was propagated.
	 * @return the status created.
	 */
	public static IDeployAttributeValueSourceStatus createAttributeInvalidSourceValueStatus(
			int severity, String validatorID, DeployModelObject object, EAttribute attribute,
			DeployModelObject source, EAttribute sourceAttribute) {
		IDeployAttributeValueSourceStatus status = DeployCoreStatusFactory.INSTANCE
				.createAttributeValueSourceStatus(severity, validatorID,
						ICoreProblemType.OBJECT_ATTRIBUTE_INVALID,
						DeployCoreMessages.Validator_deploy_model_object_0_attribute_1_invalid,
						new Object[] { object, attribute }, object, attribute, source, sourceAttribute);
		return status;
	}

	/**
	 * Creates status for an object found without a container.
	 * 
	 * @param severity
	 *           the severity of the status.
	 * @param validatorID
	 *           the ID of the validator which created this status.
	 * @param object
	 *           the object whose {@link DeployModelObject#getParent()} is null.
	 * 
	 * @return the status created.
	 */
	public static IDeployStatus createContainerUndefinedStatus(int severity, String validatorID,
			DeployModelObject object) {
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(severity,
				validatorID, ICoreProblemType.OBJECT_CONTAINER_UNDEFINED,
				DeployCoreMessages.Validator_deploy_model_object_0_container_undefined,
				new Object[] { object }, object);
		return status;
	}

	/**
	 * Creates a {@link ICoreProblemType.UNIT_CAPABILITY_TYPE_CARDINALITY_INVALID} status.
	 * 
	 * @param severity
	 *           the severity of the status.
	 * @param validatorID
	 *           the ID of the validator which created this status.
	 * @param unit
	 *           the unit which provides a capability of an invalid type.
	 * @param type
	 *           the capability type whose cardinality is invalid.
	 * @param cardinality
	 *           the invalid cardinality.
	 * @return the status created.
	 */
	public static IDeployStatus createUnitCapabilityTypeCardinalityInvalidStatus(int severity,
			String validatorID, Unit unit, EClass type, int cardinality) {
		String unboundMessage;
		Object[] bindings;
		if (cardinality == 0) {
			unboundMessage = DeployCoreMessages.Validator_unit_0_capability_type_1_missing;
			bindings = new Object[] { unit, type };
		} else {
			unboundMessage = DeployCoreMessages.Validator_unit_0_capability_type_1_cardinality_2_invalid;
			bindings = new Object[] { unit, type, Integer.toString(cardinality) };
		}
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(severity,
				validatorID, ICoreProblemType.UNIT_CAPABILITY_TYPE_CARDINALITY_INVALID, unboundMessage,
				bindings, unit);
		return status;
	}

	/**
	 * Creates a {@link ICoreProblemType#UNIT_REQUIREMENT_CAPABILTY_TYPE_CARDINALITY_INVALID} status.
	 * 
	 * @param severity
	 *           the severity of the status.
	 * @param validatorID
	 *           the ID of the validator which created this status.
	 * @param unit
	 *           the unit which provides a requirement with {@link Requirement#getDmoEType()} of an
	 *           invalid cardinality.
	 * @param type
	 *           the capability type whose cardinality is invalid.
	 * @param cardinality
	 *           the invalid cardinality.
	 * @return the status created.
	 */
	public static IDeployStatus createUnitRequirementTypeCardinalityInvalidStatus(int severity,
			String validatorID, Unit unit, EClass type, int cardinality) {
		String unboundMessage;
		Object[] bindings;
		if (cardinality == 0) {
			unboundMessage = DeployCoreMessages.Validator_unit_0_requirement_type_1_missing;
			bindings = new Object[] { unit, type };
		} else {
			unboundMessage = DeployCoreMessages.Validator_unit_0_requirement_type_1_cardinality_2_invalid;
			bindings = new Object[] { unit, type, Integer.toString(cardinality) };
		}
		IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(severity,
				validatorID, ICoreProblemType.UNIT_REQUIREMENT_CARDINALITY_INVALID, unboundMessage,
				bindings, unit);
		return status;
	}

	/**
	 * Creates a mesasge indicating that the deploy model object name attribute is not unique in its
	 * parent.
	 * 
	 * @param severity
	 *           the severity of the status.
	 * @param validatorID
	 *           the ID of the validator which created this status.
	 * @param object
	 *           the object whose name is not unique.
	 * @param parent
	 *           the parent context.
	 * @return the created status.
	 */
	public static IDeployAttributeStatus createDeployModelObjectNameNotUniqueStatus(int severity,
			String validatorID, DeployModelObject object, DeployModelObject parent) {
		IDeployAttributeStatus status = DeployCoreStatusFactory.INSTANCE.createAttributeStatus(
				severity, validatorID, ICoreProblemType.OBJECT_ATTRIBUTE_NOT_UNIQUE,
				DeployCoreMessages.Validator_deploy_model_object_0_name_not_unique_in_container_1,
				new Object[] { object, parent }, object, CorePackage.eINSTANCE
						.getDeployModelObject_Name());
		return status;
	}

	/** Filter objects of type {@link IAttributeStatus}. */
	private final static IObjectFilter ATTRIBUTE_STATUS_FILTER = new ObjectTypeFilter(
			IDeployAttributeStatus.class, true);

	/**
	 * Returns an iterator over {@link IDeployAttributeStatus} set on a deploy object.
	 * 
	 * @param obj
	 *           a deploy model object.
	 * @return Iterator<IDeployAttributeStatus>
	 */
	public static Iterator getAttributeStatus(DeployModelObject obj) {
		assert obj != null;
		return new FilterIterator(new StatusIterator(obj), ATTRIBUTE_STATUS_FILTER);
	}

	/**
	 * Return an attribute-specific status if this esf has one. (If this esf has more than one,
	 * returns only one status.)
	 * 
	 * @param dmo
	 * @param esf
	 * @return status of this attribute
	 */
	public static IDeployAttributeStatus getAttributeStatus(DeployModelObject dmo,
			EStructuralFeature esf) {
		if (dmo.getStatus() == null || dmo.getStatus().isOK()) {
			return null;
		}
		for (Iterator iter = new StatusIterator(dmo.getStatus()); iter.hasNext();) {
			IStatus status = (IStatus) iter.next();
			if (status instanceof IDeployAttributeStatus) {
				IDeployAttributeStatus das = (IDeployAttributeStatus) status;
				if (das.getAttributeType() == esf) {
					return (IDeployAttributeStatus) status;
				}
			}
		}
		return null;
	}

	/**
	 * Returns the full name of the EAttribute (class_name + '#' + attribute_name).
	 * 
	 * @param attribute
	 *           an EAttribute.
	 * @return the string fully qualifying the attribute.
	 * 
	 * @see DeployCoreStatusUtil#resolveFullEAttributeName(String, EClass)
	 */
	public static String getFullEAttributeName(EAttribute attribute) {
		assert attribute != null;
		if (attribute.getEContainingClass() != null) {
			return attribute.getEContainingClass().getInstanceClassName()
					+ IDeployAttributeStatus.ATTRIBUTE_NAME_CLASS_SEPARATOR + attribute.getName();
		}
		return attribute.getName();
	}

	/**
	 * Resolves the static EAttribute identified by a full name.
	 * 
	 * @param name
	 *           a full attribute name.
	 * @param container
	 *           the attribute container class.
	 * @return the EAttribute, or null if it does not exist.
	 * 
	 * @see #getFullEAttributeName(EAttribute)
	 */
	public static EAttribute resolveFullEAttributeName(String name, EClass container) {
		if (name == null) {
			return null;
		}
		int hashIndex = name.indexOf(IDeployAttributeStatus.ATTRIBUTE_NAME_CLASS_SEPARATOR);
		if (hashIndex != -1 && hashIndex < name.length() - 1) {
			name = name.substring(hashIndex + 1);
		}
		return (EAttribute) container.getEStructuralFeature(name);
	}

	/**
	 * Resolves the static or dynamic EAttribute identified by a full name.
	 * 
	 * @param name
	 *           a full attribute name.
	 * @param object
	 *           a deploy model object.
	 * @return the EAttribute or {@link ExtendedAttribute} associated with the name, or null if it
	 *         does not exist.
	 * 
	 * @see #getFullEAttributeName(EAttribute)
	 */
	public static EAttribute resolveFullEAttributeName(String name, DeployModelObject object) {
		if (name == null || object == null) {
			return null;
		}
		int hashIndex = name.indexOf(IDeployAttributeStatus.ATTRIBUTE_NAME_CLASS_SEPARATOR);
		if (hashIndex != -1 && hashIndex < name.length() - 1) {
			name = name.substring(hashIndex + 1);
		}
		EStructuralFeature feature = object.getEObject().eClass().getEStructuralFeature(name);
		if (feature instanceof EAttribute) {
			return (EAttribute) feature;
		}
		return object.getExtendedAttribute(name);
	}

	public static Collection<IStatus> findMatchingStatuses(String problemType, IStatus status) {
		List<IStatus> results = new ArrayList<IStatus>();
		findMatchingStatuses(problemType, status, results);
		return results;
	}

	protected static void findMatchingStatuses(String problemType, IStatus incomingStatus,
			Collection<IStatus> results) {

		if (incomingStatus != null) {

			if (incomingStatus.isMultiStatus()) {
				for (IStatus status : incomingStatus.getChildren()) {
					if (status.isMultiStatus()) {
						findMatchingStatuses(problemType, status, results);
					} else if (status instanceof IDeployStatus) {
						testMatch(problemType, status, results);
					}
				}
			} else {
				testMatch(problemType, incomingStatus, results);
			}
		}
	}

	private static void testMatch(String problemType, IStatus status, Collection<IStatus> results) {
		IDeployStatus match = (IDeployStatus) status;
		if (problemType.equals(match.getProblemType())) {
			results.add(match);
		}
	}
}
