/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.topologyimport;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.Instantiation;
import com.ibm.ccl.soa.deploy.internal.core.FeatureAwareList;
import com.ibm.ccl.soa.deploy.internal.core.InternalInstantiation;

/**
 * 
 * Defines a mechanism to use the Configured Capabilities of an Instantiation on demand.
 * 
 */
public class ConfiguredCapabilityFeatureMapStrategy extends DefaultFeatureMapStrategy implements
		IDynamicFeatureMapStrategy {

	/**
	 * @param persistenceContainer
	 *           The {@link InstanceConfiguration} will persist data manipulated by this strategy
	 * @param originatingSource
	 *           The source of the DMO is required to identify the correct {@link Instantiation}
	 * @param instantiatedFeature
	 *           The feature to be instantiated, if a write occurs.
	 * @param theTranslations
	 *           A Map of source features to their translated (or announced) features.
	 */
	public ConfiguredCapabilityFeatureMapStrategy(InstanceConfiguration persistenceContainer,
			DeployModelObject originatingSource, EStructuralFeature instantiatedFeature,
			Map<EStructuralFeature, EStructuralFeature> theTranslations) {
		super(persistenceContainer, originatingSource, instantiatedFeature, theTranslations);
	}

	protected FeatureAwareList getEditableList(Instantiation instantiation) {
		if (Proxy.isProxyClass(instantiation.getClass())) {
			return null;
		}
		return new FeatureAwareList(feature, resolveFeatureMap());
	}

	protected FeatureMap.Internal getFeatureMap(Instantiation instantiation) {

		if (Proxy.isProxyClass(instantiation.getClass())) {
			return null;
		}
		initEchoAdapter(instantiation);
		if (instantiation != null && instantiation instanceof InternalInstantiation) {
			return (FeatureMap.Internal) ((InternalInstantiation) instantiation)
					.getConfiguredCapabilityGroup();
		}
		return null;
	}

	@Override
	protected FeatureMap.Internal createFeatureMap(Instantiation instantiation) {
		if (Proxy.isProxyClass(instantiation.getClass())) {
			InvocationHandler handler = Proxy.getInvocationHandler(instantiation);
			if (handler != null && handler instanceof IProxyConfiguration) {
				IProxyConfiguration proxyConfig = (IProxyConfiguration) handler;
				Instantiation sourceInstantiation = (Instantiation) proxyConfig.getSource();
				InstanceConfiguration editableConfiguration = proxyConfig.getImported()
						.getInstanceConfiguration();
				instantiation = editableConfiguration.getInstantiation(instantiation.getReferenced());
				if (instantiation == null
						&& editableConfiguration instanceof InternalInstanceConfiguration) {
					InternalInstanceConfiguration iEditableConfiguration = (InternalInstanceConfiguration) editableConfiguration;
					instantiation = iEditableConfiguration.createInstantiation(source,
							sourceInstantiation.getReferenced());
				}
			}
		}
		if (instantiation != null && instantiation instanceof InternalInstantiation) {
			initEchoAdapter(instantiation);
			return (FeatureMap.Internal) ((InternalInstantiation) instantiation)
					.getConfiguredCapabilityGroup();
		}
		return null;
	}

	private void initEchoAdapter(Instantiation instantiation) {
		if (echoAdapter == null) {
			echoAdapter = EchoAdapter.findAdapter(instantiation, translations, source, configuration,
					false);
			echoAdapter.setForwardUnrecognizedEvents(true);
		}
	}
}
