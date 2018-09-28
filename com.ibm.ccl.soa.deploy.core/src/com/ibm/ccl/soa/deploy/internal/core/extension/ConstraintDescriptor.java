/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import org.eclipse.core.expressions.EvaluationContext;
import org.eclipse.core.expressions.EvaluationResult;
import org.eclipse.core.expressions.Expression;
import org.eclipse.core.expressions.IVariableResolver;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.constraint.CustomConstraintFactory;
import com.ibm.ccl.soa.deploy.core.validator.constraints.ConstraintValidator;
import com.ibm.ccl.soa.deploy.core.validator.constraints.SkeletonConstraintValidator;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatcher;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Descriptor for the 'constraints' extension point.
 */
public class ConstraintDescriptor extends CommonDescriptor {

	private static final String EMPTY_STRING = ""; //$NON-NLS-1$

	private final String id;
	private final String displayName;
	private final String namespace;
	private final String type;
	private IConfigurationElement validator;
	private IConfigurationElement factory;
	private IConfigurationElement linkMatcher;
	private Expression parentEnablementExpression;
	private Expression contextEnablementExpression;

	/**
	 * Cached instance of constraint factory.
	 */
	private CustomConstraintFactory factoryInstance;

	/**
	 * @param anElement
	 *           The configuration element from the parsed extension point.
	 */
	public ConstraintDescriptor(IConfigurationElement anElement) {
		super(anElement);

		// id 
		id = getElement().getAttribute(ATT_ID);
		if (id == null || id.trim().equals(EMPTY_STRING)) {
			String message = NLS.bind(
					DeployCoreMessages.ConstraintDescriptor_missing_ID_attribute_in_0, getElement()
							.getDeclaringExtension().getUniqueIdentifier());
			IStatus status = new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, 0, message, null);
			DeployCorePlugin.log(status);
		}

		// display name
		displayName = getElement().getAttribute(ATT_DISPLAY_NAME);

		// namespace
		namespace = getElement().getAttribute(ATT_NAMESPACE);

		// type
		type = getElement().getAttribute(ATT_TYPE);
		if (type == null || type.trim().equals(EMPTY_STRING)) {
			String message = NLS.bind(
					DeployCoreMessages.ConstraintDescriptor_missing_type_attribute_in_0, getElement()
							.getDeclaringExtension().getUniqueIdentifier());
			IStatus status = new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, 0, message, null);
			DeployCorePlugin.log(status);
		}

		// validator
		IConfigurationElement[] validatorChildren = getElement().getChildren(TAG_VALIDATOR);
		if (validatorChildren.length == 1) {
			validator = validatorChildren[0];
			String validatorClass = validator.getAttribute(ATT_CLASS);
			if (validatorClass == null || validatorClass.trim().equals(EMPTY_STRING)) {
				String message = NLS
						.bind(
								DeployCoreMessages.ConstraintDescriptor_missing_class_attribute_on_element_0_in_1,
								TAG_VALIDATOR, getElement().getDeclaringExtension().getUniqueIdentifier());
				IStatus status = new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, 0, message, null);
				DeployCorePlugin.log(status);
			}
		} else {
			String message = NLS.bind(
					DeployCoreMessages.ConstraintDescriptor_should_have_one_validator_in_0, getElement()
							.getDeclaringExtension().getUniqueIdentifier());
			IStatus status = new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, 0, message, null);
			DeployCorePlugin.log(status);
		}

		// factory
		IConfigurationElement[] factoryChildren = getElement().getChildren(TAG_FACTORY);
		if (factoryChildren.length > 1) {
			String message = NLS.bind(
					DeployCoreMessages.ConstraintDescriptor_should_have_at_most_one_factory_in_0,
					getElement().getDeclaringExtension().getUniqueIdentifier());
			IStatus status = new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, 0, message, null);
			DeployCorePlugin.log(status);
		} else if (factoryChildren.length == 1) {
			factory = factoryChildren[0];
			String factoryClass = factory.getAttribute(ATT_CLASS);
			if (factoryClass == null || factoryClass.trim().equals(EMPTY_STRING)) {
				String message = NLS
						.bind(
								DeployCoreMessages.ConstraintDescriptor_missing_class_attribute_on_element_0_in_1,
								TAG_FACTORY, getElement().getDeclaringExtension().getUniqueIdentifier());
				IStatus status = new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, 0, message, null);
				DeployCorePlugin.log(status);
			}
		}

		// matcher
		IConfigurationElement[] matcherChildren = getElement().getChildren(TAG_LINK_MATCHER);
		if (matcherChildren.length > 1) {
			String message = NLS.bind(
					DeployCoreMessages.ConstraintDescriptor_should_have_at_most_one_matcher_in_0,
					getElement().getDeclaringExtension().getUniqueIdentifier());
			IStatus status = new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, 0, message, null);
			DeployCorePlugin.log(status);
		} else if (matcherChildren.length == 1) {
			linkMatcher = matcherChildren[0];
			String matcherClass = linkMatcher.getAttribute(ATT_CLASS);
			if (matcherClass == null || matcherClass.trim().equals(EMPTY_STRING)) {
				String message = NLS
						.bind(
								DeployCoreMessages.ConstraintDescriptor_missing_class_attribute_on_element_0_in_1,
								TAG_LINK_MATCHER, getElement().getDeclaringExtension()
										.getUniqueIdentifier());
				IStatus status = new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, 0, message, null);
				DeployCorePlugin.log(status);
			}
		}

		// parent enablement
		IConfigurationElement[] parentEnablementChildren = getElement().getChildren(
				TAG_PARENT_ENABLEMENT);
		if (parentEnablementChildren.length > 1) {
			String message = NLS
					.bind(
							DeployCoreMessages.ConstraintDescriptor_should_have_at_most_one_parent_enablement_in_0,
							getElement().getDeclaringExtension().getUniqueIdentifier());
			IStatus status = new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, 0, message, null);
			DeployCorePlugin.log(status);
		} else if (parentEnablementChildren.length == 1) {
			parentEnablementExpression = new CustomCoreExpression(parentEnablementChildren[0]);
		} else {
			parentEnablementExpression = null;
		}

		// context enablement
		IConfigurationElement[] contextEnablementChildren = getElement().getChildren(
				TAG_CONTEXT_ENABLEMENT);
		if (contextEnablementChildren.length > 1) {
			String message = NLS
					.bind(
							DeployCoreMessages.ConstraintDescriptor_should_have_at_most_one_context_enablement_in_0,
							getElement().getDeclaringExtension().getUniqueIdentifier());
			IStatus status = new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, 0, message, null);
			DeployCorePlugin.log(status);
		} else if (contextEnablementChildren.length == 1) {
			contextEnablementExpression = new CustomCoreExpression(contextEnablementChildren[0]);
		} else {
			contextEnablementExpression = null;
		}
	}

	/**
	 * @return ID of the constraint declaration
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return display name
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * @return namespace of the EMF package where the constraint type is defined
	 */
	public String getNamespace() {
		return namespace;
	}

	/**
	 * @return type (XML complexType) of the constraint
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return factory class name if defined in th constraint extension
	 */
	public String getFactoryClassName() {
		return factory != null ? factory.getAttribute(ATT_CLASS) : null;
	}

	/**
	 * Returns an instance of constraint validator.
	 * 
	 * @return instance of constraint validator
	 */
	public ConstraintValidator createValidator() {
		if (validator == null) {
			return SkeletonConstraintValidator.INSTANCE;
		}
		try {
			Object validatorInstance = validator.createExecutableExtension(ATT_CLASS);
			if (validatorInstance instanceof ConstraintValidator) {
				return (ConstraintValidator) validatorInstance;
			}

			String errMsg = NLS.bind(
					DeployCoreMessages.ConstraintDescriptor_instance_0_is_required_in_element_1_in_2,
					new Object[] { ConstraintValidator.class.getName(), TAG_VALIDATOR,
							getElement().getDeclaringExtension().getUniqueIdentifier() });
			DeployCorePlugin.logError(0, errMsg, null);
		} catch (CoreException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		} catch (RuntimeException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		return SkeletonConstraintValidator.INSTANCE;
	}

	/**
	 * Creates an instance of constraint. Returns NULL, if the constraint can not be created.
	 * 
	 * @param parentDmo
	 *           the parent object
	 * 
	 * @return constraint instance; can return NULL (!!!)
	 */
	public Constraint createConstraint(DeployModelObject parentDmo) {
		if (factory == null) {
			// don't have factory, will try to create constraint instance 
			// based on the 'namespace' and 'type' attributes
			return createConstraint();
		}

		// we have custom constraint factory declaration
		return getFactoryInstance().createConstraint(parentDmo);
	}

	/**
	 * Whether or not link matcher is defined for the constraint.
	 * 
	 * @return true or false
	 * 
	 * @see #createLinkMatcher()
	 */
	public boolean hasLinkMatcherDefined() {
		return linkMatcher != null;
	}

	/**
	 * Returns an instance of constraint link matcher. Returns NULL if link matcher is not defined
	 * for the constraint.
	 * 
	 * @return instance of constraint link validator, or NULL
	 * 
	 * @see #hasLinkMatcherDefined()
	 */
	public LinkMatcher createLinkMatcher() {
		if (linkMatcher == null) {
			return null;
		}
		try {
			Object matcherInstance = linkMatcher.createExecutableExtension(ATT_CLASS);
			if (matcherInstance instanceof LinkMatcher) {
				return (LinkMatcher) matcherInstance;
			}

			String errMsg = NLS.bind(
					DeployCoreMessages.ConstraintDescriptor_instance_0_is_required_in_element_1_in_2,
					new Object[] { LinkMatcher.class.getName(), TAG_LINK_MATCHER,
							getElement().getDeclaringExtension().getUniqueIdentifier() });
			DeployCorePlugin.logError(0, errMsg, null);
		} catch (CoreException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		} catch (RuntimeException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		return null;
	}

	/**
	 * Evaluates the parent DMO in the parent enablement expression.
	 * 
	 * @param parent
	 *           parent DMO
	 * @return True if the given DMO is described by the parentEnablement clause of the extension.
	 */
	public boolean isParentLegal(DeployModelObject parent) {
		if (parentEnablementExpression == null) {
			return true;
		}
		if (parent == null) {
			return false;
		}
		EvaluationContext context = new EvaluationContext(null, parent, new IVariableResolver[] {
				new DeployLinkVariableResolver(parent), new DeployModelObjectVariableResolver(parent) });
		context.setAllowPluginActivation(true);
		try {
			return parentEnablementExpression.evaluate(context) == EvaluationResult.TRUE;
		} catch (CoreException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
			return false;
		}
	}

	/**
	 * Evaluates the validation context in the context enablement expression.
	 * 
	 * @param validationContext
	 *           validation context
	 * @return True if the given DMO is described by the contextEnablement clause of the extension.
	 */
	public boolean isContextLegal(DeployModelObject validationContext) {
		if (validationContext == null) {
			return false;
		}

		if (contextEnablementExpression == null) {
			return true;
		}
		EvaluationContext context = new EvaluationContext(null, validationContext,
				new IVariableResolver[] { new DeployLinkVariableResolver(validationContext),
						new DeployModelObjectVariableResolver(validationContext) });
		context.setAllowPluginActivation(true);
		try {
			return contextEnablementExpression.evaluate(context) == EvaluationResult.TRUE;
		} catch (CoreException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
			return false;
		}
	}

	/**
	 * Returns the cached copy of the factory instance. If the cached copy is not created - creates
	 * it. If something goes wrong, creates Skeleton Constraint factory.
	 * 
	 * @return cached instance of constrant factory
	 */
	private synchronized CustomConstraintFactory getFactoryInstance() {
		if (factoryInstance != null) {
			return factoryInstance;
		}
		try {
			Object fi = factory.createExecutableExtension(ATT_CLASS);
			if (fi instanceof CustomConstraintFactory) {
				factoryInstance = (CustomConstraintFactory) fi;
				return factoryInstance;
			}

			String errMsg = NLS.bind(
					DeployCoreMessages.ConstraintDescriptor_instance_0_is_required_in_element_1_in_2,
					new Object[] { CustomConstraintFactory.class.getName(), TAG_FACTORY,
							getElement().getDeclaringExtension().getUniqueIdentifier() });
			DeployCorePlugin.logError(0, errMsg, null);
		} catch (CoreException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		} catch (RuntimeException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		factoryInstance = new SkeletonConstraintFactory();
		return factoryInstance;
	}

	/**
	 * Creates an instance of the constrain type.
	 * 
	 * Implementation catches all exceptions and returns NULL if an error occurs.
	 * 
	 * @return instance of constraint type, NULL if can not create a class instance
	 */
	private Constraint createConstraint() {
		if (type == null) {
			return null;
		}

		try {
			EPackage pkg = EPackage.Registry.INSTANCE.getEPackage(namespace);
			if (pkg == null) {
				// we don't have this EMF Package
				String errMsg = NLS.bind(DeployCoreMessages.No_EMF_package_for_namespace_0,
						new Object[] { namespace });
				DeployCorePlugin.logError(0, errMsg, null);
				return null;
			}

			EClassifier classifier = pkg.getEClassifier(type);
			if (!(classifier instanceof EClass)) {
				// we don't have this EClass
				String errMsg = NLS.bind(DeployCoreMessages.No_EClass_for_type_name_0,
						new Object[] { type });
				DeployCorePlugin.logError(0, errMsg, null);
				return null;
			}

			EObject instance = pkg.getEFactoryInstance().create((EClass) classifier);
			if (instance instanceof Constraint) {
				return (Constraint) instance;
			}

			String errMsg = NLS.bind(
					DeployCoreMessages.ConstraintDescriptor_instance_0_is_required_in_attribute_1_in_2,
					new Object[] { Constraint.class.getName(), ATT_TYPE,
							getElement().getDeclaringExtension().getUniqueIdentifier() });
			DeployCorePlugin.logError(0, errMsg, null);
			return null;

		} catch (Exception e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
			return null;
		}
	}
}
