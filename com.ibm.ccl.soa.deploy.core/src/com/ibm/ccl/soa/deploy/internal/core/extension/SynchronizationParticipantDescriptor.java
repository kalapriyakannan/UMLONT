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
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.synchronization.ISynchronizationParticipantDescriptor;
import com.ibm.ccl.soa.deploy.core.synchronization.SynchronizationParticipant;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreSafeRunnable;

/**
 * 
 * Provides an implementation of {@link ISynchronizationParticipantDescriptor} that wraps an Eclipse
 * Extension's {@link IConfigurationElement}.
 * 
 * @since 1.0
 * 
 */
public class SynchronizationParticipantDescriptor implements ICommonDeployExtensionConstants,
		ISynchronizationParticipantDescriptor {

	private IConfigurationElement element;
	private CustomCoreExpression expression;

	/* package */SynchronizationParticipantDescriptor(IConfigurationElement element) {
		Assert.isTrue(TAG_SYNCHRONIZATION_PARTICIPANT.equals(element.getName()));
		this.element = element;
		init();
	}

	private void init() {
		IConfigurationElement[] children = element.getChildren(TAG_INPUT_ENABLEMENT);
		if (children.length == 1)
			expression = new CustomCoreExpression(children[0]);
		else
			DeployCorePlugin
					.logError(
							0,
							NLS
									.bind(
											DeployCoreMessages.ImplementationParticipantDescriptor_An_implementationParticipant_define_,
											element.getNamespaceIdentifier()), null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.internal.core.extension.ISynchronizationParticipantDescriptor#createParticipant()
	 */
	public SynchronizationParticipant createParticipant() {

		final SynchronizationParticipant[] participant = new SynchronizationParticipant[1];
		SafeRunner.run(new DeployCoreSafeRunnable() {
			public void run() throws Exception {
				Object ext = element.createExecutableExtension(ATT_CLASS);
				if (ext instanceof SynchronizationParticipant)
					participant[0] = (SynchronizationParticipant) ext;
				else
					throw new CoreException(
							DeployCorePlugin
									.createErrorStatus(
											0,
											NLS
													.bind(
															DeployCoreMessages.ImplementationParticipantDescriptor_An_extension_defined_by_0_must_sp_,
															new Object[] { element.getNamespaceIdentifier(),
																	SynchronizationParticipant.class.getName(),
																	element.getAttribute(ATT_CLASS) }), null));

			}
		});

		if (participant[0] == null)
			return SkeletonImplementationParticipant.INSTANCE;
		return participant[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.internal.core.extension.ISynchronizationParticipantDescriptor#isEnabled(com.ibm.ccl.soa.deploy.core.Unit)
	 */
	public boolean isEnabled(Unit unit) {

		if (expression != null) {
			try {
				EvaluationContext context = new EvaluationContext(null, unit);
				context.setAllowPluginActivation(true);
				if (EvaluationResult.TRUE.equals(expression.evaluate(context)))
					return true;
			} catch (CoreException e) {
				DeployCorePlugin.logError(0, e.getMessage(), e);
			}
		}

		return false;

	}
}
