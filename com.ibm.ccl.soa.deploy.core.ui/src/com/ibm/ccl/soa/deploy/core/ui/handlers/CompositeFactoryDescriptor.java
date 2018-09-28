/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.handlers;

import org.eclipse.core.expressions.EvaluationContext;
import org.eclipse.core.expressions.EvaluationResult;
import org.eclipse.core.expressions.Expression;
import org.eclipse.core.expressions.ExpressionConverter;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.composites.AbstractCompositeFactory;
import com.ibm.ccl.soa.deploy.internal.core.extension.CommonDescriptor;
import com.ibm.ccl.soa.deploy.saf.handler.AbstractInterfaceHandler;

/**
 * 
 * 
 */
public class CompositeFactoryDescriptor extends CommonDescriptor implements
		IDeployCoreUIExtensionConstants {
	private Expression enablementExpression = null;

	/* package */CompositeFactoryDescriptor(IConfigurationElement anElement) {
		super(anElement);
		assert TAG_COMPOSITE_FACTORY.equals(anElement.getName());
		IConfigurationElement[] enablementChild = getElement().getChildren(TAG_ENABLEMENT);
		if (enablementChild.length == 1) {
			try {
				enablementExpression = ExpressionConverter.getDefault().perform(enablementChild[0]);
			} catch (CoreException e) {
				DeployCoreUIPlugin.log(e.getStatus());
			}
		} else if (enablementChild.length > 1) {
			String message = "An Error occured"; //$NON-NLS-1$ //TODO Grab from SAF
			IStatus status = new Status(IStatus.WARNING, DeployCoreUIPlugin.PLUGIN_ID, 0, message,
					null);
			DeployCoreUIPlugin.log(status);
		}
	}

	/**
	 * @return An instance of the {@link AbstractInterfaceHandler} defined by the extension or null
	 *         if a problem occurs.
	 */
	public AbstractCompositeFactory createCompositeFactory() {
		if (getName() == null) {
			return null;
		}

		final AbstractCompositeFactory[] contribution = new AbstractCompositeFactory[1];
		SafeRunner.run(new ISafeRunnable() {
			public void run() throws Exception {
				Object handler = getElement().createExecutableExtension(ATTR_CLASS);
				if (handler instanceof AbstractCompositeFactory) {
					AbstractCompositeFactory abstractCompositeFactory = (AbstractCompositeFactory) handler;
					contribution[0] = abstractCompositeFactory;
				} else {
					String errMsg = "An Error occured"; //$NON-NLS-1$ //TODO Grab from SAF
					DeployCoreUIPlugin.logError(0, errMsg, null);
				}
			}

			public void handleException(Throwable exception) {
				DeployCoreUIPlugin.logError(0, exception.getMessage(), exception);
			}
		});

		return contribution[0];
	}

	/**
	 * Returns true if the resolution is enabled for the specified Object.
	 * 
	 * @param obj
	 *           this could be IType.
	 * @return true if the resolution is enabled, false if the enablement expression is false, or
	 *         failed.
	 */
	public boolean isEnabled(Object obj) {
		if (enablementExpression == null) {
			return true;
		}

		EvaluationContext context = new EvaluationContext(null, obj);
		try {
			context.setAllowPluginActivation(true);
			EvaluationResult result = enablementExpression.evaluate(context);
			return EvaluationResult.TRUE.equals(result);
		} catch (CoreException e) {
			DeployCoreUIPlugin.log(e.getStatus());
			return false;
		}
	}

	public String toString() {
		return "CompositeFactoryDescriptor[name=" + getName() + "]"; //$NON-NLS-1$ //$NON-NLS-2$
	}

}
