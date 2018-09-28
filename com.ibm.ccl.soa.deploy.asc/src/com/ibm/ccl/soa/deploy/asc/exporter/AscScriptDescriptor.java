/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.asc.exporter;

import java.util.Properties;

/**
 * AscScriptDescriptor is a wrap of ASC Script Task. ASC Ecporter use it to generate the ASC tasks.
 * 
 * @author WangXue
 * @updated Zhaoyong
 * @updated by Feng Lin
 */
public class AscScriptDescriptor {

	private String ascPackageName = null;

	private String ascTaskName = null;

	private Properties ascProperties = null;

	/**
	 * get the task's package name
	 * 
	 * @return package name of the ASC task
	 */

	public String getAscPackageName() {
		return ascPackageName;
	}

	/**
	 * Set asc task package name, eg, "was_6".
	 * 
	 * @param ascPackageName
	 *           asc task package name
	 */
	public void setAscPackageName(String ascPackageName) {
		this.ascPackageName = ascPackageName;
	}

	/**
	 * get the task's Properties
	 * 
	 * @return Properties of the ASC task
	 */
	public Properties getAscProperties() {
		return ascProperties;
	}

	/**
	 * set properties owned by an asc task
	 * 
	 * @param ascProperties
	 */
	public void setAscProperties(Properties ascProperties) {
		this.ascProperties = ascProperties;
	}

	/**
	 * get the task's task name
	 * 
	 * @return task name of the ASC task
	 */
	public String getAscTaskName() {
		return ascTaskName;
	}

	/**
	 * Set asc task name, eg, "createProfile"
	 * 
	 * @param ascTaskName
	 */
	public void setAscTaskName(String ascTaskName) {
		this.ascTaskName = ascTaskName;
	}

	public String toString() {
		String str = " ascPackageName=" + ascPackageName; //$NON-NLS-1$
		str = str + "\n ascTaskName= " + ascTaskName; //$NON-NLS-1$
		str = str + "\n ascProperties= " + ascProperties; //$NON-NLS-1$
		return str;
	}

}
