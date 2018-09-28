/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.properties;

import org.eclipse.jface.viewers.IFilter;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.ui.navigator.deploy.TopologyDiagramNode;

/**
 * Filter for {@link Topology}.
 * 
 * @since V8M6
 */
public class TopologyPropertySectionFilter implements IFilter {

	public boolean select(Object candidate) {
		return candidate instanceof TopologyDiagramNode;
	}

}
