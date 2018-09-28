/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.internal.scheme;

import java.util.List;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.ide.IdeMessages;

/**
 * @author nmakin
 * 
 */
public class NoTopologyCreationScheme extends TopologyCreationScheme {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.ide.internal.scheme.TopologyCreationScheme#applyScheme(com.ibm.ccl.soa.deploy.core.Unit)
	 */
	public boolean applyScheme(List aUnitList) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.ide.internal.scheme.TopologyCreationScheme#applyScheme(com.ibm.ccl.soa.deploy.core.Topology)
	 */
	public boolean applyScheme(Topology aTopology) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.ide.internal.scheme.TopologyCreationScheme#getDescription()
	 */
	public String getDescription() {
		return IdeMessages.NO_SCHEME_DESCRIPTION;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.ide.internal.scheme.TopologyCreationScheme#getName()
	 */
	public String getName() {
		// TODO Auto-generated method stub
		return ITopologyCreationSchemeConstants.NO_TOPOLOGY_CREATION_SCHEME;
	}

}
