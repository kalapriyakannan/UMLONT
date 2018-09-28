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

import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;

public class DynamicReassociationList extends ReassociationList {

	public DynamicReassociationList(InstanceConfiguration configuration, DeployModelObject source,
			EStructuralFeature feature, List readonly) {
		super(source, feature, new DynamicFeatureAwareList(configuration, source, feature), readonly);
	}

	public DynamicReassociationList(InstanceConfiguration configuration, DeployModelObject source,
			EStructuralFeature feature, List readonly, IDynamicFeatureMapStrategy resolver) {
		super(source, feature, new DynamicFeatureAwareList(feature, resolver), readonly);
	}

}
