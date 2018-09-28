/***************************************************************************************************
 * Copyright (c) 2003, 2008 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.j2ee.validator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Reference;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ShortConstraintDescriptor;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.constraints.ConstraintValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.jms.JmsPackage;
import com.ibm.ccl.soa.deploy.was.WasJNDIBindingConstraint;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.validator.IWASProblemType;
import com.ibm.ccl.soa.deploy.was.validator.IWasValidatorID;

/**
 * Validator for {@link WasJNDIBindingConstraint}.
 */
public class WasJNDIBindingConstraintValidator extends ConstraintValidator {

	/**
	 * /* list of valid capability types on against which a {@link WasJNDIBindingConstraint} can we
	 * written. Included for each is the attribute on the capability containing the target JNDI name.
	 * This list should be expanded when new capabilities are added to the model.
	 */
	protected static List<JndiNameMap> validTypesContainingJndiName = new ArrayList<JndiNameMap>();
	{
		validTypesContainingJndiName.add(new JndiNameMap(J2eePackage.Literals.J2EE_DATASOURCE,
				J2eePackage.Literals.J2EE_DATASOURCE__JNDI_NAME));
		validTypesContainingJndiName.add(new JndiNameMap(
				JmsPackage.Literals.JMS_QUEUE_CONNECTION_FACTORY,
				JmsPackage.Literals.JMS_QUEUE_CONNECTION_FACTORY__JNDI_NAME));
		validTypesContainingJndiName.add(new JndiNameMap(JmsPackage.Literals.JMS_DESTINATION,
				JmsPackage.Literals.JMS_DESTINATION__JNDI_NAME));
		validTypesContainingJndiName.add(new JndiNameMap(
				JmsPackage.Literals.JMS_TOPIC_CONNECTION_FACTORY,
				JmsPackage.Literals.JMS_TOPIC_CONNECTION_FACTORY__JNDI_NAME));
		validTypesContainingJndiName.add(new JndiNameMap(
				JmsPackage.Literals.JMS_ACTIVATION_SPECIFICATION,
				JmsPackage.Literals.JMS_ACTIVATION_SPECIFICATION__JNDI_NAME));
	}

	protected boolean isValidTargetType(EClass type) {
		if (null == type) {
			return false;
		}
		boolean valid = false;
		for (JndiNameMap validType : validTypesContainingJndiName) {
			if (validType.getType().isSuperTypeOf(type)) {
				valid = true;
				break;
			}
		}
		return valid;
	}

	protected boolean isValidPlacement(Constraint constraint, DeployModelObject dmo) {
		EClass dmoType = dmo.getEObject().eClass();

		// constraint may be on an bean service (if hosted on WAS)
		if (J2eePackage.Literals.ENTERPRISE_BEAN_SERVICE.isSuperTypeOf(dmoType)) {
			return WasJ2eeValidatorUtils.isJ2eeHostedOnWas(dmo);
		}

		// constraint may be on a reference (hosted on WAS) to a bean service
		if (CorePackage.Literals.REFERENCE.isSuperTypeOf(dmoType)) {
			Reference ref = (Reference) dmo;
			if (J2eePackage.Literals.ENTERPRISE_BEAN_SERVICE.isSuperTypeOf(ref.getDmoEType())) {
				return WasJ2eeValidatorUtils.isJ2eeHostedOnWas(dmo);
			}
		}

		// or on a requirement (hosted on WAS) satisfied by an appropriate type
		if (CorePackage.Literals.REQUIREMENT.isSuperTypeOf(dmoType)) {
			// target of dependency can be one of validTypesContainingJndiName
			Requirement req = (Requirement) dmo;
			if (!isValidTargetType(req.getDmoEType())) {
				return false;
			}
			return WasJ2eeValidatorUtils.isJ2eeHostedOnWas(dmo);
		}

		// was not of the expected types
		return false;
	}

	@Override
	public List<ShortConstraintDescriptor> applicableConstraints(Constraint parentConstraint,
			List<ShortConstraintDescriptor> potentialConstraints) {
		return EMPTY_CONSTRAINT_LIST;
	}

	@Override
	public boolean canValidateConstraint(Constraint constraint) {
		return WasPackage.Literals.WAS_JNDI_BINDING_CONSTRAINT.isSuperTypeOf(constraint.getEObject()
				.eClass());
	}

	@Override
	public DeployModelObject getContextForChildConstraints(Constraint constraint) {
		return null;
	}

	@Override
	public IStatus validate(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor) {
		if (!WasPackage.Literals.WAS_JNDI_BINDING_CONSTRAINT.isSuperTypeOf(constraint.getEObject()
				.eClass())) {
			// we don't know how to validate this constraint
			return DeployCoreStatusFactory.INSTANCE.getOKStatus();
		}

		WasJNDIBindingConstraint wasConstraint = (WasJNDIBindingConstraint) constraint;

		// check that the constraint is on a valid WebModule, EjbModule, EarModule, EnterpriseBeanService,
		// or requirement with dmoEType of EnterpriseBeanService or J2EEDatasource and is hosted on was
		if (!isValidPlacement(constraint, context)) {
			IDeployStatus status = DeployCoreStatusFactory.INSTANCE.createDeployStatus(
					IStatus.WARNING,
					IWasValidatorID.WAS_JNDI_BINDING_CONSTRAINT_INVALID_CONTEXT_VALIDATOR_001,
					IWASProblemType.WAS_JNDI_BINDING_CONSTRAINT_INVALID_CONTEXT,
					WasDomainMessages.WasJ2eeValidator_WasJNDIBindingConstraint_In_Invalid_Context,
					new Object[] {}, wasConstraint);
			return status;
		}

		// bean service
		if (J2eePackage.Literals.ENTERPRISE_BEAN_SERVICE.isSuperTypeOf(context.getEObject().eClass())) {
			return DeployCoreStatusFactory.INSTANCE.getOKStatus();
		}

		DeployModelObject dmo = wasConstraint.getParent();

		// reference linked to a bean service
		if (CorePackage.Literals.REFERENCE.isSuperTypeOf(context.getEObject().eClass())) {
			Reference ref = (Reference) dmo;
			DependencyLink existingLink = ref.getLink();
			if (null == existingLink || null == existingLink.getTarget()) {
				// no target; can't validate; handled via core validations
				return DeployCoreStatusFactory.INSTANCE.getOKStatus();
			}
			Capability cap = existingLink.getTarget();
			for (Constraint c : ValidatorUtils.getConstraints(cap,
					WasPackage.Literals.WAS_JNDI_BINDING_CONSTRAINT)) {
				WasJNDIBindingConstraint jndiConstraint = (WasJNDIBindingConstraint) c;
				String expectedJndiName = wasConstraint.getJndiName() == null ? new String()
						: wasConstraint.getJndiName();
				String foundJndiName = jndiConstraint.getJndiName() == null ? new String()
						: jndiConstraint.getJndiName();
				//Use endsWith to allow for cross server detection.
				if (!expectedJndiName.endsWith(foundJndiName)) {
					IDeployStatus status = DeployCoreStatusFactory.INSTANCE
							.createAttributeValueStatus(
									IStatus.ERROR,
									IWasValidatorID.WAS_JNDI_BINDING_CONSTRAINT_JNDI_NAME_OF_CAPABILITY_DOES_NOT_MATCH_VALIDATOR_001,
									IWASProblemType.WAS_JNDI_BINDING_CONSTRAINT_JNDI_NAME_OF_CAPABILITY_DOES_NOT_MATCH,
									DeployNLS
											.bind(
													WasDomainMessages.WasJ2eeValidator_WasJNDIBindingConstraint_Jndi_Name_Of_Capability_Does_Not_Match,
													new Object[] { constraint.getParent(), cap }),
									new Object[] {}, wasConstraint,
									WasPackage.Literals.WAS_JNDI_BINDING_CONSTRAINT__JNDI_NAME,
									foundJndiName);
					return status;
				}
			}
			return DeployCoreStatusFactory.INSTANCE.getOKStatus();
		}

		// requirement linked to a capability containing a jndiName attribute
		if (CorePackage.Literals.REQUIREMENT.isSuperTypeOf(dmo.getEObject().eClass())) {
			Requirement req = (Requirement) dmo;
			DependencyLink existingLink = req.getLink();
			if (null == existingLink || null == existingLink.getTarget()) {
				// no target; can't validate; handled via core validations
				return DeployCoreStatusFactory.INSTANCE.getOKStatus();
			}
			Capability cap = existingLink.getTarget();
			for (JndiNameMap validType : validTypesContainingJndiName) {
				if (validType.getType().isSuperTypeOf(cap.getEObject().eClass())) {
					Object value = cap.eGet(validType.getAttribute());
					if (!(value instanceof String)) {
						// unexpected attribute value; can't validate
						return DeployCoreStatusFactory.INSTANCE.getOKStatus();
					}
					String jndiName = (String) value;

					String expectedJndiName = wasConstraint.getJndiName() == null ? new String()
							: wasConstraint.getJndiName();
					if (!expectedJndiName.equals(jndiName)) {
						// MK 1/20/2008 defect 4652
						// There may be a conflict between an attribute value constraint and the JNDIBindingConstraint
						// For now we allow the attribute value constraint to take precedence (since it is a core constraint)

						// find any conflicting equals constraint
						boolean deferToAVC = false;
						dmo.getConstraints();
						for (Constraint c : (List<Constraint>) dmo.getConstraints()) {
							if (ConstraintPackage.Literals.EQUALS_CONSTRAINT.isSuperTypeOf(constraint
									.getEObject().eClass())) {
								EqualsConstraint eqConstraint = (EqualsConstraint) c;
								String aName = eqConstraint.getAttributeName();
								if (null != eqConstraint.getValue()) {
									for (JndiNameMap attribute : validTypesContainingJndiName) {
										if (attribute.getAttribute().equals(aName)) {
											deferToAVC = true;
											break;
										}
									}
									if (deferToAVC) {
										break;
									}
								}
							}
						}

						if (!deferToAVC) {
							IStatus status = DeployCoreStatusFactory.INSTANCE
									.createAttributeValueStatus(
											IStatus.ERROR,
											IWasValidatorID.WAS_JNDI_BINDING_CONSTRAINT_JNDI_NAME_OF_CAPABILITY_DOES_NOT_MATCH_VALIDATOR_001,
											IWASProblemType.WAS_JNDI_BINDING_CONSTRAINT_JNDI_NAME_OF_CAPABILITY_DOES_NOT_MATCH,
											WasDomainMessages.WasJ2eeValidator_WasJNDIBindingConstraint_Jndi_Name_Does_Not_Match,
											new Object[] { wasConstraint, constraint.getParent(), jndiName,
													context }, cap, validType.getAttribute(), expectedJndiName);
							status = ValidatorUtils
									.addStatus(
											status,
											DeployCoreStatusFactory.INSTANCE
													.createAttributeValueStatus(
															IStatus.ERROR,
															IWasValidatorID.WAS_JNDI_BINDING_CONSTRAINT_JNDI_NAME_OF_CAPABILITY_DOES_NOT_MATCH_VALIDATOR_001,
															IWASProblemType.WAS_JNDI_BINDING_CONSTRAINT_JNDI_NAME_OF_CAPABILITY_DOES_NOT_MATCH,
															WasDomainMessages.WasJ2eeValidator_WasJNDIBindingConstraint_Jndi_Name_Does_Not_Match,
															new Object[] { wasConstraint, constraint.getParent(),
																	jndiName, context },
															wasConstraint,
															WasPackage.Literals.WAS_JNDI_BINDING_CONSTRAINT__JNDI_NAME,
															value));
							return status;
						}
					}
				}
			}
			return DeployCoreStatusFactory.INSTANCE.getOKStatus();
		}

		// don't know the type (should not happen since we validate placement)
		return DeployCoreStatusFactory.INSTANCE.getOKStatus();
	}

	public String title(Constraint constraint) {
		if (constraint == null) {
			return DeployCoreMessages.null_value;
		}
		StringBuffer buf = new StringBuffer();
		String caption = constraint.getDisplayName();
		if (caption != null && caption.trim().length() > 0) {
			buf.append(caption.trim());
			buf.append('(');
			buf.append(WasDomainMessages.WasJNDIBindingConstraintValidator_WebSphere_JNDI_Binding_);
			buf.append(((WasJNDIBindingConstraint) constraint).getJndiName());
			buf.append(')');
		} else {
			buf.append(WasDomainMessages.WasJNDIBindingConstraintValidator_WebSphere_JNDI_Binding_);
			buf.append(((WasJNDIBindingConstraint) constraint).getJndiName());
		}
		return buf.toString();
	}

	private class JndiNameMap {
		private final EClass _type;
		private final EAttribute _attribute;

		/**
		 * Constructor
		 * 
		 * @param type
		 *           type
		 * @param jndiNameAttribute
		 *           attribute of JNDI name
		 */
		public JndiNameMap(EClass type, EAttribute jndiNameAttribute) {
			_type = type;
			_attribute = jndiNameAttribute;
		}

		/**
		 * @return the type
		 */
		public EClass getType() {
			return _type;
		}

		/**
		 * @return the attribute containing the JNDI name
		 */
		public EAttribute getAttribute() {
			return _attribute;
		}
	}
}
