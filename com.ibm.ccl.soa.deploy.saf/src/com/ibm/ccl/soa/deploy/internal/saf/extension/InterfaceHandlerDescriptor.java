/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.saf.extension;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.expressions.EvaluationContext;
import org.eclipse.core.expressions.EvaluationResult;
import org.eclipse.core.expressions.Expression;
import org.eclipse.core.expressions.ExpressionConverter;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Service;
import com.ibm.ccl.soa.deploy.internal.saf.Messages;
import com.ibm.ccl.soa.deploy.internal.saf.SAFPlugin;
import com.ibm.ccl.soa.deploy.saf.handler.AbstractInterfaceHandler;
import com.ibm.ccl.soa.deploy.saf.handler.IInterfaceDescriptor;

/**
 * Provides a wrapper for <tt>interfaceHandler</tt> elements from the
 * <b>com.ibm.ccl.soa.deploy.saf.handlers</b> extension point.
 * 
 * @since 1.0
 * 
 */
public class InterfaceHandlerDescriptor extends CommonDescriptor implements IInterfaceDescriptor {

	private static final String[] NO_SERVICES = new String[0];

	private Expression enablementExpression = null;
	private String type = null;

	private final Set<InterfaceHandlerBindingDescriptor> relevantBindings = new HashSet<InterfaceHandlerBindingDescriptor>();

	/**
	 * Only allow classes local to the package or subclasses to instantiate this element.
	 * 
	 * @param anElement
	 *           The "unitDiscoverer" IConfigurationElement from the registry reader.
	 */
	/* package */InterfaceHandlerDescriptor(IConfigurationElement anElement) {
		super(anElement);

		init();
	}

	private void init() {
		assert TAG_INTERFACE_HANDLER.equals(getElement().getName());

		IConfigurationElement[] enablementChild = getElement().getChildren(TAG_ENABLEMENT);
		if (enablementChild.length == 1) {
			try {
				enablementExpression = ExpressionConverter.getDefault().perform(enablementChild[0]);
			} catch (CoreException e) {
				SAFPlugin.log(e.getStatus());
			}
		}
		/*
		 * else { SAFPlugin.log(new Status(IStatus.WARNING, SAFPlugin.PLUGIN_ID, 0, NLS.bind(
		 * Messages.InterfaceHandlerDescriptor_Invalid_number_of_enablement_expres_,
		 * getElement().getDeclaringExtension().getExtensionPointUniqueIdentifier()), null)); }
		 */

		type = getElement().getAttribute(ATTR_TYPE);

		if (type == null) {
			SAFPlugin.logError(0, NLS.bind(
					Messages.InterfaceHandlerDescriptor_The_0_extension_defined_by_1_do_, new Object[] {
							getElement().getDeclaringExtension().getUniqueIdentifier(),
							getElement().getNamespaceIdentifier() }), null);
		}
	}

	/**
	 * Return the fully qualified Java class of the associated Interface.
	 * 
	 * @return The fully qualified Java class of the associated Interface.
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return An instance of the {@link AbstractInterfaceHandler} defined by the extension or null
	 *         if a problem occurs.
	 */
	public AbstractInterfaceHandler createInterfaceHandler() {

		final AbstractInterfaceHandler[] contribution = new AbstractInterfaceHandler[1];
		SafeRunner.run(new ISafeRunnable() {
			public void run() throws Exception {
				Object handler = getElement().createExecutableExtension(ATTR_CLASS);
				if (handler instanceof AbstractInterfaceHandler) {
					AbstractInterfaceHandler abstractInterfaceHandler = (AbstractInterfaceHandler) handler;
					abstractInterfaceHandler.initialize(getName(), getDescription(), getSmallIcon(),
							getLargeIcon());
					contribution[0] = abstractInterfaceHandler;
				} else {

					SAFPlugin.logError(0, NLS
							.bind(Messages.InterfaceHandlerDescriptor_An_instance_of_0_for_the_1_attr_,
									new Object[] {
											AbstractInterfaceHandler.class.getName(),
											ATTR_CLASS,
											getElement().getDeclaringExtension()
													.getExtensionPointUniqueIdentifier() }), null);
				}
			}

			public void handleException(Throwable exception) {
				SAFPlugin.logError(0, exception.getMessage(), exception);
			}
		});

		if (contribution[0] == null) {
			return SkeletonInterfaceHandler.INSTANCE;
		}

		return contribution[0];
	}

	/**
	 * Return true if the given Interface object is of a type supported by this descriptor's
	 * {@link AbstractInterfaceHandler}.
	 * 
	 * @param interfaze
	 *           An instance of the interface in question.
	 * @return True if the given Interface object is of a type supported by this descriptor's
	 *         {@link AbstractInterfaceHandler}.
	 */
	public boolean isSupportedInterface(Interface interfaze) {
		if (interfaze != null) {
			EClass eClass = interfaze.eClass();
			return isSupportedInterface(eClass.getInstanceClassName());
		}
		return false;
	}

	/**
	 * Return true if the given interface class name is supported by this descriptor's
	 * {@link AbstractInterfaceHandler}
	 * 
	 * @param interfaze
	 *           The fully qualified class name of the Interface.
	 * @return True if the given interface class name is supported by this descriptor's
	 *         {@link AbstractInterfaceHandler}.
	 */
	public boolean isSupportedInterface(String interfaze) {
		return type.equals(interfaze);
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
			return false;
		}
		if (obj == null) {
			return true;
		}

		EvaluationContext context = new EvaluationContext(null, obj);
		try {
			context.setAllowPluginActivation(true);
			EvaluationResult result = enablementExpression.evaluate(context);
			return EvaluationResult.TRUE.equals(result);
		} catch (CoreException e) {
			SAFPlugin.log(e.getStatus());
			return false;
		}
	}

	/**
	 * Return an array of user displayable names to describe the supported Services.
	 * 
	 * @return An array of user displayable names to describe the supported Services.
	 */
	public String[] getSupportedServiceLabels() {
		return NO_SERVICES;
	}

	public String toString() {
		return "InterfaceHandlerDescriptor[name=" + getName() + ", type=" + getType() + "]" + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	}

	/**
	 * Return true of the object or its associated field (e.g. {@link Requirement#getDmoEType()}) is
	 * bound to an interface supported by this handler.
	 * 
	 * @param obj
	 *           One of {@link Requirement} or {@link Service} or {@link EClass}. The method type
	 *           safe and will return false if one of these types is not supplied.
	 * @return True of the object or its associated field (e.g. {@link Requirement#getDmoEType()})
	 *         is bound to an interface supported by this handler.
	 */
	public boolean isBound(Object obj) {

		String serviceType = null;
		if (obj instanceof EClass) {
			EClass eClass = (EClass) obj;
			serviceType = eClass.getInstanceClassName();
		} else if (obj instanceof Requirement) {
			Requirement requirement = (Requirement) obj;
			if (requirement.getDmoEType() != null) {
				serviceType = requirement.getDmoEType().getInstanceClassName();
			}
		} else if (obj instanceof Service) { // for cases where the Service instance is passed in 
			Service service = (Service) obj;
			serviceType = service.eClass().getInstanceClassName();
		}
		if (serviceType != null) {
			for (Iterator<InterfaceHandlerBindingDescriptor> iterator = getRelevantBindings()
					.iterator(); iterator.hasNext();) {
				InterfaceHandlerBindingDescriptor binding = iterator.next();
				if (binding.isServiceTypeBound(serviceType)) {
					return true;
				}
			}
		}
		return false;

	}

	/**
	 * Return an modifiable set of bindings for this handler. The set should only be modified by the
	 * {@link SAFManager}.
	 * 
	 * @return An modifiable set of bindings for this handler. The set should only be modified by the
	 *         {@link SAFManager}.
	 */
	public Set<InterfaceHandlerBindingDescriptor> getRelevantBindings() {
		return relevantBindings;
	}

}
