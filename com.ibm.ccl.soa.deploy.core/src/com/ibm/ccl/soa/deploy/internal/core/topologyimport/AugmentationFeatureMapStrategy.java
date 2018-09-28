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

import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;

import com.ibm.ccl.soa.deploy.core.Augmentation;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.Instantiation;
import com.ibm.ccl.soa.deploy.internal.core.FeatureAwareList;

/**
 * Defines a mechanism to create augmentations on demand.
 * 
 */
public class AugmentationFeatureMapStrategy extends DefaultFeatureMapStrategy implements
		IDynamicFeatureMapStrategy {

	/**
	 * @param persistenceContainer
	 *           The {@link InstanceConfiguration} will persist data manipulated by this strategy
	 * @param originatingSource
	 *           The source of the DMO is required to identify the correct {@link Instantiation}
	 * @param instantiatedFeature
	 *           The feature to be instantiated, if a write occurs.
	 */
	public AugmentationFeatureMapStrategy(InstanceConfiguration persistenceContainer,
			DeployModelObject originatingSource, EStructuralFeature instantiatedFeature) {
		super(persistenceContainer, originatingSource, instantiatedFeature);
	}

	/**
	 * @param persistenceContainer
	 *           The {@link InstanceConfiguration} will persist data manipulated by this strategy
	 * @param originatingSource
	 *           The source of the DMO is required to identify the correct {@link Instantiation}
	 * @param instantiatedFeature
	 *           The feature to be instantiated, if a write occurs.
	 * @param ignoreContract
	 *           True to ignore the contract permissions if a request to create an editable list is
	 *           received.
	 */
	public AugmentationFeatureMapStrategy(InstanceConfiguration persistenceContainer,
			DeployModelObject originatingSource, EStructuralFeature instantiatedFeature,
			boolean ignoreContract) {
		super(persistenceContainer, originatingSource, instantiatedFeature, ignoreContract);
	}

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
	public AugmentationFeatureMapStrategy(InstanceConfiguration persistenceContainer,
			DeployModelObject originatingSource, EStructuralFeature instantiatedFeature,
			Map<EStructuralFeature, EStructuralFeature> theTranslations) {
		super(persistenceContainer, originatingSource, instantiatedFeature, theTranslations);
	}

	/**
	 * @param persistenceContainer
	 *           The {@link InstanceConfiguration} will persist data manipulated by this strategy
	 * @param originatingSource
	 *           The source of the DMO is required to identify the correct {@link Instantiation}
	 * @param instantiatedFeature
	 *           The feature to be instantiated, if a write occurs.
	 * @param theTranslations
	 *           A Map of source features to their translated (or announced) features.
	 * 
	 * @param ignoreContract
	 *           True to ignore the contract permissions if a request to create an editable list is
	 *           received.
	 */
	public AugmentationFeatureMapStrategy(InstanceConfiguration persistenceContainer,
			DeployModelObject originatingSource, EStructuralFeature instantiatedFeature,
			Map<EStructuralFeature, EStructuralFeature> theTranslations, boolean ignoreContract) {
		super(persistenceContainer, originatingSource, instantiatedFeature, theTranslations,
				ignoreContract);
	}

	protected FeatureAwareList getEditableList(Instantiation instantiation) {
		Augmentation augmentation = instantiation.getAugmentation(feature.getName());
		if (augmentation != null) {
			return new FeatureAwareList(feature, resolveFeatureMap());
		}
		return null;
	}

	protected FeatureMap.Internal getFeatureMap(Instantiation instantiation) {
		Augmentation augmentation = instantiation.getAugmentation(feature.getName());
		if (augmentation != null) {
			return (FeatureMap.Internal) augmentation.getAdditions();
		}
		return null;
	}

	@Override
	protected FeatureMap.Internal createFeatureMap(Instantiation instantiation) {
		Augmentation augmentation = instantiation.createAugmentation(feature.getName());
		echoAdapter = EchoAdapter.findAdapter(augmentation, translations, source, configuration);
		echoAdapter.setForwardUnrecognizedEvents(true);
		return (FeatureMap.Internal) augmentation.getAdditions();
	}

}
