/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import org.eclipse.core.expressions.EvaluationContext;
import org.eclipse.core.expressions.EvaluationResult;
import org.eclipse.core.expressions.Expression;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.CapabilityProvider;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Provides a wrapper around <b>&lt;capabilityProvider /&gt;</b> configuration elements parsed from
 * the <b>com.ibm.ccl.soa.deploy.core.domains</b> extension point.
 * 
 * @since 1.0
 * 
 */
public class CapabilityProviderDescriptor extends CommonDescriptor {

	private Expression inputExpression;
	private Expression outputExpression;
	private Expression hostExpression;

	/**
	 * Only allow classes local to the package or subclasses to instantiate this element.
	 * 
	 * @param anElement
	 *           The "capabilityProvider" IConfigurationElement from the registry reader.
	 */
	protected CapabilityProviderDescriptor(IConfigurationElement anElement) {
		super(anElement);
		assert TAG_CAPABILITY_PROVIDER.equals(anElement.getName());
		init();
	}

	private void init() {
		IConfigurationElement[] inputEnablement = getElement().getChildren(TAG_INPUT_ENABLEMENT);
		if (inputEnablement.length == 1) {
			inputExpression = new CustomCoreExpression(inputEnablement[0]);
		} /*
		 * else { DeployCorePlugin.logError(0, NLS.bind(
		 * DeployCoreMessages.CapabilityProviderDescriptor_Exactly_one_enablement_element_is, new
		 * Object[] { TAG_CAPABILITY_PROVIDER, getName(), getElement().getDeclaringExtension()
		 * .getExtensionPointUniqueIdentifier() }), null); }
		 */
		IConfigurationElement[] outputEnablement = getElement().getChildren(TAG_OUTPUT_ENABLEMENT);
		if (outputEnablement.length == 1) {
			outputExpression = new CustomCoreExpression(outputEnablement[0]);
		} /*
		 * else { DeployCorePlugin.logError(0, NLS.bind(
		 * DeployCoreMessages.CapabilityProviderDescriptor_Exactly_one_enablement_element_is, new
		 * Object[] { TAG_CAPABILITY_PROVIDER, getName(), getElement().getDeclaringExtension()
		 * .getExtensionPointUniqueIdentifier() }), null); }
		 */
		IConfigurationElement[] hostEnablement = getElement().getChildren(TAG_HOST_ENABLEMENT);
		if (hostEnablement.length == 1) {
			hostExpression = new CustomCoreExpression(hostEnablement[0]);
		}
	}

	/**
	 * The provider created by this method will not be cached. Clients of this method are required to
	 * manage the lifecycle of the new object.
	 * 
	 * @return An instance of the {@link CapabilityProvider} defined by the extension or a no-op
	 *         singleton if a problem occurs.
	 */
	public CapabilityProvider createCapabilityProvider() {
		if (inputExpression == null && outputExpression == null) {
			return null;
		}
		try {
			Object provider = getElement().createExecutableExtension(ATT_CLASS);
			if (provider instanceof CapabilityProvider) {
				return (CapabilityProvider) provider;
			}

			String errMsg = NLS
					.bind(
							DeployCoreMessages.CapabilityProviderDescriptor_An_instance_of_CapabilityProvider_is_required,
							new Object[] { CapabilityProvider.class.getName(), ATT_CLASS,
									getElement().getDeclaringExtension().getExtensionPointUniqueIdentifier() });
			DeployCorePlugin.logError(0, errMsg, null);
		} catch (CoreException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		} catch (RuntimeException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		return SkeletonCapabilityProvider.INSTANCE;
	}

	/**
	 * 
	 * @param anObject
	 *           An element that might activate this provider.
	 * @return True if and only if the given argument is described by the enablement clause of the
	 *         extension defined by this {@link CapabilityProviderDescriptor}.
	 */
	public boolean isEnabledForInputOnly(Object anObject) {
		if (inputExpression == null) {
			return false;
		}
		EvaluationContext context = new EvaluationContext(null, anObject);
		context.setAllowPluginActivation(true);
		try {
			return inputExpression.evaluate(context) == EvaluationResult.TRUE;
		} catch (CoreException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
			return false;
		}
	}

	/**
	 * 
	 * @param anObject
	 *           A topology Unit.
	 * @return True if and only if the given argument is described by the outputEnablement clause of
	 *         the extension defined by this {@link UnitProviderDescriptor}.
	 */
	public boolean isEnabledForOutputOnly(Object anObject) {
		if (outputExpression == null) {
			return false;
		}
		EvaluationContext context = new EvaluationContext(null, anObject);
		context.setAllowPluginActivation(true);
		try {
			return outputExpression.evaluate(context) == EvaluationResult.TRUE;
		} catch (CoreException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
			return false;
		}
	}

	/**
	 * Check for enabledment based on input and output expression
	 * 
	 * @param aInput
	 *           the object to be used for input enablement expression
	 * @param aOutput
	 *           the object to be used for output enablement expression
	 * @return True if and only if the given argument's are described by the inputEnablement and
	 *         outputEnablement clause of the extension defined by this
	 *         {@link UnitProviderDescriptor}.
	 */
	public boolean isEnabledForInputAndOutput(Object aInput, Object aOutput) {
		if (outputExpression == null || inputExpression == null) {
			return false;
		}
		EvaluationContext inputContext = new EvaluationContext(null, aInput);
		inputContext.setAllowPluginActivation(true);
		EvaluationContext outputContext = new EvaluationContext(null, aOutput);
		outputContext.setAllowPluginActivation(true);
		try {
			return outputExpression.evaluate(outputContext) == EvaluationResult.TRUE
					&& inputExpression.evaluate(inputContext) == EvaluationResult.TRUE;
		} catch (CoreException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
			return false;
		}
	}

	public String toString() {
		return "CapabilityProviderDescriptor[name=" + getName() + ", inputExpression=" + inputExpression + "]" + ", outputExpression=" + outputExpression + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
	}
}
