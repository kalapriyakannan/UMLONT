/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.extension;

import org.eclipse.core.expressions.EvaluationContext;
import org.eclipse.core.expressions.EvaluationResult;
import org.eclipse.core.expressions.Expression;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.ide.publisher.SkeletonUnitPublisher;
import com.ibm.ccl.soa.deploy.ide.publisher.UnitPublisher;
import com.ibm.ccl.soa.deploy.internal.core.extension.CommonDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.extension.CustomCoreExpression;

/**
 * Provides a wrapper around <b>&lt;unitPublisher /&gt;</b> configuration elements parsed from the
 * <b>com.ibm.ccl.soa.deploy.core.unitLifecycle</b> extension point.
 * 
 * @since 1.0
 * 
 */
public class UnitPublisherDescriptor extends CommonDescriptor {

	private Expression enablementExpression;

	/**
	 * Only allow classes local to the package or subclasses to instantiate this element.
	 * 
	 * @param anElement
	 *           The "unitPublisher" IConfigurationElement from the registry reader.
	 */
	protected UnitPublisherDescriptor(IConfigurationElement anElement) {
		super(anElement);
		assert TAG_UNIT_PUBLISHER.equals(anElement.getName());
		init();
	}

	private void init() {
		IConfigurationElement[] enablement = getElement().getChildren(TAG_ENABLEMENT);
		if (enablement.length == 1) {
			enablementExpression = new CustomCoreExpression(enablement[0]);
		} else {
			DeployCorePlugin.logError(0, NLS.bind(
					DeployIdeMessages.UnitPublisherDescriptor_Exactly_one_enablement_element_is,
					new Object[] { TAG_UNIT_PUBLISHER, getName(),
							getElement().getDeclaringExtension().getExtensionPointUniqueIdentifier() }),
					null);
		}

	}

	/**
	 * The publisher created by this method will not be cached. Clients of this method are required
	 * to manage the lifecycle of the new object.
	 * 
	 * @return An instance of the {@link UnitPublisher} defined by the extension or a no-op singleton
	 *         if a problem occurs.
	 */
	public UnitPublisher createUnitPublisher() {
		if (enablementExpression == null)
			return null;
		try {
			Object publisher = getElement().createExecutableExtension(ATT_CLASS);
			if (publisher instanceof UnitPublisher)
				return (UnitPublisher) publisher;

			String errMsg = NLS.bind(
					DeployIdeMessages.UnitPublisherDescriptor_An_instance_of_UnitPublisher_is_required,
					new Object[] { UnitPublisher.class.getName(), ATT_CLASS,
							getElement().getDeclaringExtension().getExtensionPointUniqueIdentifier() });
			DeployCorePlugin.logError(0, errMsg, null);
		} catch (CoreException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		} catch (RuntimeException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
		return SkeletonUnitPublisher.INSTANCE;
	}

	/**
	 * 
	 * @param aPotentialUnit
	 *           An element that might be a topology Unit.
	 * @return True if and only if the given argument is described by the enablement clause of the
	 *         extension defined by this {@link UnitPublisherDescriptor}.
	 */
	public boolean isEnabled(Object aPotentialUnit) {
		if (enablementExpression == null)
			return false;
		EvaluationContext context = new EvaluationContext(null, aPotentialUnit);
		try {
			return enablementExpression.evaluate(context) == EvaluationResult.TRUE;
		} catch (CoreException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
			return false;
		}
	}

	public String toString() {
		return "UnitPublisherDescriptor[name=" + getName() + ", expression=" + enablementExpression + "]"; //$NON-NLS-1$ //$NON-NLS-2$//$NON-NLS-3$
	}
}
