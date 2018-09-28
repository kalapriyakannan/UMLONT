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

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DomainPackager;
import com.ibm.ccl.soa.deploy.core.validator.DomainValidator;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Provides a wrapper around <b>&lt;domains /&gt;</b> configuration elements parsed from the
 * <b>com.ibm.ccl.soa.deploy.core.domains</b> extension point.
 * 
 * <p>
 * A DomainDescriptor provides two important <i>create</i> methods:
 * <ul>
 * <li>{@link #createDomainValidator()}: Clients are required to specify a validator for their
 * domain models. </li>
 * <li>{@link #createDomainPackager()}: Clients may optionally specify a packager to prepare their
 * domain models for export or publishing. </li>
 * </ul>
 * </p>
 * 
 * @since 1.0
 * 
 */
public class DomainDescriptor extends CommonDescriptor {

	private static final String ATT_TARGET_NAMESPACE = "targetNamespace"; //$NON-NLS-1$

	private DomainValidatorDescriptor validator;

	private DomainPackagerDescriptor packager;

	private CapabilityProviderDescriptor[] capabilityProviderDescriptors;

	private DecoratorSemanticBindingRuleDescriptor dsBindingRuleDescriptor;

	private ResourceTypeDescriptor[] resourceTypeDescriptors;
	private ResourceTypeBindingDescriptor[] resourceTypeBindingDescriptors;
	private ResourceTypeUIBindingDescriptor[] resourceTypeUIBindingDescriptors;

	private String id;

	private String targetNamespace;

	/**
	 * @param anElement
	 *           The configuration element from the parsed extension point.
	 */
	public DomainDescriptor(IConfigurationElement anElement) {
		super(anElement);

		Assert.isTrue(TAG_DOMAIN.equals(anElement.getName()));
		init();
	}

	public String getDomainValidatorClassAttr() {
		if (validator == null) {
			return SkeletonDomainValidator.INSTANCE.getClass().getName();
		}
		return validator.getClassName();
	}

	public String getDomainValidatorPluginid() {
		if (validator == null) {
			return SkeletonDomainValidator.INSTANCE.getDomainID();
		}
		return validator.getContributingPluginId();
	}

	private void init() {

		id = getElement().getAttribute(ATT_ID) == null ? "" : getElement().getAttribute(ATT_ID); //$NON-NLS-1$

		targetNamespace = getElement().getAttribute(ATT_TARGET_NAMESPACE) == null ? "" : getElement().getAttribute(ATT_TARGET_NAMESPACE); //$NON-NLS-1$

		IConfigurationElement[] validatorChild = getElement().getChildren(TAG_VALIDATOR);
		if (validatorChild.length == 1) {
			try {
				validator = new DomainValidatorDescriptor(validatorChild[0], targetNamespace);
			} catch (RuntimeException e) {
				DeployCorePlugin.logError(0, NLS.bind(
						DeployCoreMessages.DomainDescriptor_Invalid_domain_descriptor_0, getElement()
								.getDeclaringExtension().getExtensionPointUniqueIdentifier()), e);
			}
		} else {
			if (validatorChild.length > 1) {
				DeployCorePlugin.logError(0, NLS.bind(
						DeployCoreMessages.DomainDescriptor_Invalid_number_of_validator_eleme_,
						getElement().getDeclaringExtension().getExtensionPointUniqueIdentifier()), null);
			}
		}
		IConfigurationElement[] packagerChild = getElement().getChildren(TAG_PACKAGER);
		if (packagerChild.length == 1) {
			packager = new DomainPackagerDescriptor(packagerChild[0]);
		}

		IConfigurationElement[] capabilityProviders = getElement().getChildren(
				TAG_CAPABILITY_PROVIDER);
		capabilityProviderDescriptors = new CapabilityProviderDescriptor[capabilityProviders.length];
		for (int i = 0; i < capabilityProviders.length; i++) {
			capabilityProviderDescriptors[i] = new CapabilityProviderDescriptor(capabilityProviders[i]);
		}

		IConfigurationElement[] resourceTypes = getElement().getChildren(TAG_RESOURCE_TYPE);
		resourceTypeDescriptors = new ResourceTypeDescriptor[resourceTypes.length];
		for (int i = 0; i < resourceTypes.length; i++) {
			resourceTypeDescriptors[i] = new ResourceTypeDescriptor(resourceTypes[i]);
		}

		IConfigurationElement[] resourceTypeBindings = getElement().getChildren(
				TAG_RESOURCE_TYPE_BINDING);
		resourceTypeBindingDescriptors = new ResourceTypeBindingDescriptor[resourceTypeBindings.length];
		for (int i = 0; i < resourceTypeBindings.length; i++) {
			resourceTypeBindingDescriptors[i] = new ResourceTypeBindingDescriptor(
					resourceTypeBindings[i]);
		}

		IConfigurationElement[] resourceTypeUIBindings = getElement().getChildren(
				TAG_RESOURCE_TYPE_UI_BINDING);
		resourceTypeUIBindingDescriptors = new ResourceTypeUIBindingDescriptor[resourceTypeUIBindings.length];
		for (int i = 0; i < resourceTypeUIBindings.length; i++) {
			resourceTypeUIBindingDescriptors[i] = new ResourceTypeUIBindingDescriptor(
					resourceTypeUIBindings[i]);
		}

		IConfigurationElement[] dsBindingRuleChild = getElement().getChildren(
				TAG_DECORATOR_SEMANTIC_BINDING_RULE);
		if (dsBindingRuleChild.length == 1) {
			dsBindingRuleDescriptor = new DecoratorSemanticBindingRuleDescriptor(dsBindingRuleChild[0]);
		}

	}

	/**
	 * 
	 * @return The identifier provided by the extension ("targetNamespace" attribute).
	 */
	public String getTargetNamespace() {
		return targetNamespace;
	}

	/**
	 * 
	 * @return The identifier provided by the extension ("id" attribute).
	 */
	public String getId() {
		return id;
	}

	/**
	 * The DomainValidator provides hooks for clients to validate their respective models in extended
	 * domains.
	 * <p>
	 * The DomainValidator created by this method will not be cached. Clients of this method are
	 * required to manage the lifecycle of the new object.
	 * </p>
	 * <p>
	 * In the event of an error (exception or otherwise), the error will be logged and the singleton
	 * instance of {@link SkeletonDomainValidator#INSTANCE} will be returned.
	 * </p>
	 * 
	 * @return An instance of the {@link DomainValidator} defined by the extension or a no-op
	 *         singleton if a problem occurs.
	 */
	public DomainValidator createDomainValidator() {
		return validator != null ? validator.createDomainValidator()
				: SkeletonDomainValidator.INSTANCE;
	}

	/**
	 * The DomainPackager allows clients to define how their domain model should be prepared for
	 * export or publishing.
	 * <p>
	 * The DomainPackager created by this method will not be cached. Clients of this method are
	 * required to manage the lifecycle of the new object.
	 * </p>
	 * <p>
	 * In the event of an error (exception or otherwise), the error will be logged and the singleton
	 * instance of {@link SkeletonDomainPackager#INSTANCE} will be returned.
	 * </p>
	 * 
	 * @return An instance of the {@link DomainValidator} defined by the extension or a no-op
	 *         singleton if a problem occurs.
	 */
	public DomainPackager createDomainPackager() {
		return packager != null ? packager.createDomainPackager() : SkeletonDomainPackager.INSTANCE;
	}

	/**
	 * Wraps elements named "validator".
	 * 
	 * @see ICommonDeployExtensionConstants#TAG_VALIDATOR
	 */
	private class DomainValidatorDescriptor extends CommonDescriptor {

		protected final String targetNamespace;
		protected final String contributingPluginId;

		private DomainValidatorDescriptor(IConfigurationElement anElement, String targetNamespace) {
			super(anElement);
			this.targetNamespace = targetNamespace;
			contributingPluginId = anElement.getContributor().getName();
			Assert.isTrue(TAG_VALIDATOR.equals(anElement.getName()));
		}

		public String getClassName() {
			return getElement().getAttribute(ATT_CLASS);

		}

		public String getContributingPluginId() {
			return contributingPluginId;
		}

		private DomainValidator createDomainValidator() {
			try {
				Object instance = getElement().createExecutableExtension(ATT_CLASS);
				if (instance instanceof DomainValidator) {
					DomainValidator validator = (DomainValidator) instance;
					validator.setDomainID(id);
					validator.setDomainNsURI(targetNamespace);
					return validator;
				}

				String errMsg = NLS
						.bind(
								DeployCoreMessages.UnitProviderDescriptor_An_instance_of_TopologyUnitProvider_is_required,
								new Object[] {
										DomainValidator.class.getName(),
										ATT_CLASS,
										getElement().getDeclaringExtension()
												.getExtensionPointUniqueIdentifier() });
				DeployCorePlugin.logError(0, errMsg, null);
			} catch (CoreException e) {
				DeployCorePlugin.logError(0, e.getMessage(), e);
			} catch (RuntimeException e) {
				DeployCorePlugin.logError(0, e.getMessage(), e);
			}
			return SkeletonDomainValidator.INSTANCE;
		}
	}

	/**
	 * @return CapabilityProviderDescriptor
	 */
	public CapabilityProviderDescriptor[] getCapabilityProviderDescriptors() {
		return capabilityProviderDescriptors;
	}

	/**
	 * the {@link DomainPackagerDescriptor}
	 * 
	 * @return the DomainPackagerDescriptor
	 */
	public DomainPackagerDescriptor getDomainPackagerDescriptor() {
		return packager;
	}

	/**
	 * @return ResourceTypeDescriptors
	 */
	public ResourceTypeDescriptor[] getResourceTypeDescriptors() {
		return resourceTypeDescriptors;
	}

	/**
	 * @return ResourceTypeBindingDescriptors
	 */
	public ResourceTypeBindingDescriptor[] getResourceTypeBindingDescriptors() {
		return resourceTypeBindingDescriptors;
	}

	/**
	 * @return ResourceTypeUIBindingDescriptors
	 */
	public ResourceTypeUIBindingDescriptor[] getResourceTypeUIBindingDescriptors() {
		return resourceTypeUIBindingDescriptors;
	}

	public String toString() {
		return "DomainDescriptor[id=" + getId() + ", targetNamespace=" + getTargetNamespace() + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	/**
	 * 
	 * @return DecoratorSemanticBindingRuleDescriptor
	 */
	public DecoratorSemanticBindingRuleDescriptor getDsBindingRuleDescriptor() {
		return dsBindingRuleDescriptor;
	}

}
