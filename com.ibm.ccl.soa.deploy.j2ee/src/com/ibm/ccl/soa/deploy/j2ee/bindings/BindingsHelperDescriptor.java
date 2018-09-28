/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.bindings;

import org.eclipse.core.expressions.EvaluationContext;
import org.eclipse.core.expressions.EvaluationResult;
import org.eclipse.core.expressions.Expression;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;

import com.ibm.ccl.soa.deploy.internal.core.extension.CommonDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.extension.CustomCoreExpression;
import com.ibm.ccl.soa.deploy.j2ee.J2EEDeployPlugin;

public class BindingsHelperDescriptor extends CommonDescriptor {

	public static String ATT_CLASS = "class"; //$NON-NLS-1$
	private final IBindingsHelper helper = new AbstractBindingsHelper();
	private Expression enablementExpression;

	/**
	 * Only allow classes local to the package or subclasses to instantiate this element.
	 * 
	 * @param anElement
	 *           The "unitPublisher" IConfigurationElement from the registry reader.
	 */
	protected BindingsHelperDescriptor(IConfigurationElement anElement) {
		super(anElement);
		assert BindingsHelperManager.TAG_BINDINGS_HELPER.equals(anElement.getName());
		init();
	}

	private void init() {
		IConfigurationElement[] enablement = getElement().getChildren(TAG_HOST_ENABLEMENT);
		if (enablement.length == 1) {
			enablementExpression = new CustomCoreExpression(enablement[0]);
		}
	}

	public IBindingsHelper createBindingsHelper() {
		if (enablementExpression == null) {
			return null;
		}
		try {
			Object helper = getElement().createExecutableExtension(ATT_CLASS);
			if (helper instanceof IBindingsHelper) {
				return (IBindingsHelper) helper;
			}
		} catch (CoreException e) {
			J2EEDeployPlugin.logError(0, e.getMessage(), e);
		} catch (RuntimeException e) {
			J2EEDeployPlugin.logError(0, e.getMessage(), e);
		}
		return helper;
	}

	public boolean isEnabled(Object aPotentialUnit) {
		if (enablementExpression == null) {
			return false;
		}
		EvaluationContext context = new EvaluationContext(null, aPotentialUnit);
		try {
			return enablementExpression.evaluate(context) == EvaluationResult.TRUE;
		} catch (CoreException e) {
			J2EEDeployPlugin.logError(0, e.getMessage(), e);
			return false;
		}
	}

	public String toString() {
		return "BindingsHelperDescriptor[name=" + getName() + ", expression=" + enablementExpression + "]"; //$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$
	}
}
