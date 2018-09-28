/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.asc.exporter;

import java.io.IOException;
import java.util.Vector;
import java.util.zip.ZipOutputStream;

import com.ibm.ccl.soa.deploy.asc.exception.ASCException;
import com.ibm.ccl.soa.deploy.core.Unit;

public interface ASCBuilder {

	/**
	 * get the build string for build.xml
	 * 
	 * @return the buildStr which is a set of ant task.
	 * @throws IOException
	 */
	public abstract StringBuffer getBuildStr() throws ASCException;

	/**
	 * get all of the tasks the builder created
	 * 
	 * @return Task vector
	 */
	public abstract Vector getTasks();

	/**
	 * get the string for solution.properties
	 * 
	 * @return solution string which is a set of task properties.
	 * @throws IOException
	 */
	public abstract StringBuffer getSolutionStr() throws ASCException;

	/**
	 * build it into the zip stream
	 * 
	 * @param zipOut
	 *           the ascScript set output target.
	 */
	public abstract void buildZip(ZipOutputStream zipOut) throws ASCException;

	public abstract void addUnitArray(Unit[] units) throws ASCException;

}
