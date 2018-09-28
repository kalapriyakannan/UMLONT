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

/**
 * @author nmakin
 * 
 */
public abstract class TopologyCreationScheme {
	/**
	 * return the name of the scheme
	 * 
	 * @return the name of the scheme
	 */
	public abstract String getName();

	/**
	 * return the description of the scheme
	 * 
	 * @return the description of the scheme
	 */
	public abstract String getDescription();

	/**
	 * apply the topology creation scheme on these units and return true, if successful
	 * 
	 * @param List
	 *           an list of units
	 * @return boolean true, if scheme was succesfully applied
	 */
	public abstract boolean applyScheme(List unitList);

	/**
	 * apply the topology creation scheme on this topology and return true, if successful
	 * 
	 * @param aTopology
	 *           input topology object
	 * @return boolean true, if scheme was succesfully applied
	 */
	public abstract boolean applyScheme(Topology aTopology);
}
