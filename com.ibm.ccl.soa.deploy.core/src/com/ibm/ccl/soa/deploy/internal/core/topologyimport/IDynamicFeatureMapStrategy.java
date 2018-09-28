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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * Defines a mechanism to dynamically resolve feature maps.
 * 
 */
public interface IDynamicFeatureMapStrategy {

	/**
	 * Return the editable list, if available.
	 * 
	 * @return The editable list, if available.
	 */
	public abstract List getEditableList();

	/**
	 * Create and return the editable list, if available.
	 * 
	 * @return Create and return the editable list.
	 */
	public abstract EList createEditableList();

	/**
	 * Resolve the feature map, creating it if necessary.
	 * 
	 * @return Resolve the feature map, creating it if necessary
	 */
	public abstract FeatureMap.Internal resolveFeatureMap();

	/**
	 * Return the feature map, if available.
	 * 
	 * @return the feature map, if available.
	 */
	public abstract FeatureMap.Internal getFeatureMap();

}