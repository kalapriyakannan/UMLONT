/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.saf.ui.extension;

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
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.internal.saf.ui.Messages;
import com.ibm.ccl.soa.deploy.internal.saf.ui.SAFUIPlugin;
import com.ibm.ccl.soa.deploy.saf.handler.AbstractInterfaceHandler;
import com.ibm.ccl.soa.deploy.saf.ui.handler.AbstractUIHandler;

/**
 * Provides a wrapper around <b>&lt;unitDiscoverer /&gt;</b> configuration elements parsed from the
 * <b>com.ibm.ccl.soa.deploy.core.unitLifecycle</b> extension point.
 * 
 * @since 1.0
 * 
 */
public class UIHandlerDescriptor extends CommonDescriptor {

	private Expression enablementExpression = null;

	/**
	 * Only allow classes local to the package or subclasses to instantiate this element.
	 * 
	 * @param anElement
	 *           The "unitDiscoverer" IConfigurationElement from the registry reader.
	 */
	protected UIHandlerDescriptor(IConfigurationElement anElement) {
		super(anElement);
		init();
	}

	private void init() {
		IConfigurationElement[] enablementChild = getElement().getChildren(TAG_ENABLEMENT);
		if (enablementChild.length == 1) {
			try {
				enablementExpression = ExpressionConverter.getDefault().perform(enablementChild[0]);
			} catch (CoreException e) {
				SAFUIPlugin.log(e.getStatus());
			}
		} else {
			SAFUIPlugin.log(new Status(IStatus.WARNING, SAFUIPlugin.PLUGIN_ID, 0, NLS.bind(
					Messages.UIHandlerDescriptor_Invalid_number_of_enablement_expres_, getElement()
							.getDeclaringExtension().getExtensionPointUniqueIdentifier()), null));
		}
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
		if (enablementExpression == null || obj == null) {
			return false;
		}
		EvaluationContext context = new EvaluationContext(null, obj);
		try {
			context.setAllowPluginActivation(true);
			EvaluationResult result = enablementExpression.evaluate(context);
			return EvaluationResult.TRUE.equals(result);
		} catch (CoreException e) {
			SAFUIPlugin.log(e.getStatus());
			return false;
		}
	}

	/**
	 * @return An instance of the {@link AbstractInterfaceHandler} defined by the extension or null
	 *         if a problem occurs.
	 */
	public AbstractUIHandler createUIHandler() {
		if (getKind() == null || getName() == null) {
			return null;
		}

		final AbstractUIHandler[] contribution = new AbstractUIHandler[1];
		SafeRunner.run(new ISafeRunnable() {
			public void run() throws Exception {
				Object handler = getElement().createExecutableExtension(ATTR_CLASS);
				if (handler instanceof AbstractUIHandler) {
					AbstractUIHandler abstractInterfaceUIHandler = (AbstractUIHandler) handler;
					abstractInterfaceUIHandler.initialize(getKind(), getName(), getDescription());
					contribution[0] = abstractInterfaceUIHandler;
				} else {
					String errMsg = NLS
							.bind(
									Messages.InterfaceUIHandlerDescriptor_An_instance_of_AbstractUIInterfaceHandler_is_required,
									new Object[] {
											AbstractUIHandler.class.getName(),
											ATTR_CLASS,
											getElement().getDeclaringExtension()
													.getExtensionPointUniqueIdentifier() });
					SAFUIPlugin.logError(0, errMsg, null);
				}
			}

			public void handleException(Throwable exception) {
				SAFUIPlugin.logError(0, exception.getMessage(), exception);
			}
		});

		if (contribution[0] == null) {
			return SkeletonUIHandler.INSTANCE;
		}

		return contribution[0];
	}

	public String toString() {
		return "InterfaceUIHandlerDescriptor[name=" + getName() + ", kind=" + getKind() + "]" + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	}
}
