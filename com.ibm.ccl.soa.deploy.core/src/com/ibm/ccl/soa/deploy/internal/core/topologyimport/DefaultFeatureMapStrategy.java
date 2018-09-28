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

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.Instantiation;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.FeatureAwareList;

public abstract class DefaultFeatureMapStrategy implements IDynamicFeatureMapStrategy {

	protected final InstanceConfiguration configuration;
	protected final DeployModelObject source;
	protected final EStructuralFeature feature;
	protected final Map<EStructuralFeature, EStructuralFeature> translations;
	protected EchoAdapter echoAdapter;
	protected EList editableList;
	private FeatureMap.Internal featureMap;
	private boolean hasPermission = false;

	/**
	 * @param persistenceContainer
	 *           The {@link InstanceConfiguration} will persist data manipulated by this strategy
	 * @param originatingSource
	 *           The source of the DMO is required to identify the correct {@link Instantiation}
	 * @param instantiatedFeature
	 *           The feature to be instantiated, if a write occurs.
	 */
	public DefaultFeatureMapStrategy(InstanceConfiguration persistenceContainer,
			DeployModelObject originatingSource, EStructuralFeature instantiatedFeature) {
		configuration = persistenceContainer;
		source = originatingSource;
		feature = instantiatedFeature;
		translations = new HashMap<EStructuralFeature, EStructuralFeature>(2);
		translations.put(CorePackage.Literals.AUGMENTATION__ADDITIONS, instantiatedFeature);
	}

	/**
	 * @param persistenceContainer
	 *           The {@link InstanceConfiguration} will persist data manipulated by this strategy
	 * @param originatingSource
	 *           The source of the DMO is required to identify the correct {@link Instantiation}
	 * @param instantiatedFeature
	 *           The feature to be instantiated, if a write occurs.
	 */
	public DefaultFeatureMapStrategy(InstanceConfiguration persistenceContainer,
			DeployModelObject originatingSource, EStructuralFeature instantiatedFeature,
			boolean ignoreContract) {
		configuration = persistenceContainer;
		source = originatingSource;
		feature = instantiatedFeature;
		translations = new HashMap<EStructuralFeature, EStructuralFeature>(2);
		translations.put(CorePackage.Literals.AUGMENTATION__ADDITIONS, instantiatedFeature);
		hasPermission = ignoreContract;
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
	public DefaultFeatureMapStrategy(InstanceConfiguration persistenceContainer,
			DeployModelObject originatingSource, EStructuralFeature instantiatedFeature,
			Map<EStructuralFeature, EStructuralFeature> theTranslations) {
		this(persistenceContainer, originatingSource, instantiatedFeature, theTranslations, false);
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
	public DefaultFeatureMapStrategy(InstanceConfiguration persistenceContainer,
			DeployModelObject originatingSource, EStructuralFeature instantiatedFeature,
			Map<EStructuralFeature, EStructuralFeature> theTranslations, boolean ignoreContract) {
		configuration = persistenceContainer;
		source = originatingSource;
		feature = instantiatedFeature;
		translations = theTranslations;
		hasPermission = ignoreContract;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.internal.core.topologyimport.IDynamicFeatureMapStrategy#getEditableList()
	 */
	public List getEditableList() {
		if (editableList == null) {
			Instantiation instantiation = configuration.getInstantiation(source.getFullPath());
			if (instantiation != null) {
				editableList = getEditableList(instantiation);
			}
		}
		return editableList != null ? editableList : Collections.emptyList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.internal.core.topologyimport.IDynamicFeatureMapStrategy#createEditableList()
	 */
	public EList createEditableList() {
		if (editableList == null) {
			editableList = new FeatureAwareList(feature, resolveFeatureMap());
		}
		return editableList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.internal.core.topologyimport.IDynamicFeatureMapStrategy#resolveFeatureMap()
	 */
	public FeatureMap.Internal resolveFeatureMap() {
		if (featureMap == null) {
			Instantiation instantiation = configuration.getInstantiation(source.getFullPath());
			if (isPermitted()) {
				instantiation = configuration.instantiate(source.getFullPath());
			}
			if (instantiation != null) {
				featureMap = createFeatureMap(instantiation);
			} else {
				throw new IllegalStateException(NLS.bind(
						DeployCoreMessages.MethodHandler_Cannot_modify_a_non_editable_field_,
						new Object[] {
								feature.getName(),
								source.getEditTopology().getQualifiedName() + IConstants.TOPOLOGY_SEPARATOR
										+ source.getFullPath() }));
			}
		}
		return featureMap;
	}

	protected boolean isPermitted() {
		return hasPermission || configuration.isPublicEditable(source, feature.getName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.internal.core.topologyimport.IDynamicFeatureMapStrategy#getFeatureMap()
	 */
	public FeatureMap.Internal getFeatureMap() {
		if (featureMap == null) {
			Instantiation instantiation = configuration.getInstantiation(source.getFullPath());
			if (instantiation != null) {
				featureMap = getFeatureMap(instantiation);
			}
		}
		return featureMap;
	}

	protected abstract FeatureAwareList getEditableList(Instantiation instantiation);

	protected abstract FeatureMap.Internal getFeatureMap(Instantiation instantiation);

	protected abstract FeatureMap.Internal createFeatureMap(Instantiation instantiation);
}
