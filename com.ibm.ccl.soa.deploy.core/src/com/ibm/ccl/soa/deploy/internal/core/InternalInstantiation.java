package com.ibm.ccl.soa.deploy.internal.core;

import org.eclipse.emf.ecore.util.FeatureMap;

import com.ibm.ccl.soa.deploy.core.Instantiation;

public interface InternalInstantiation extends Instantiation {

	public FeatureMap getConfiguredCapabilityGroup();

	public FeatureMap getConfiguredRequirementsGroup();

}
