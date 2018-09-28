/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.properties;

import org.eclipse.gef.EditDomain;

/**
 * A provider of the GEF Edit Domain
 * 
 * @author Ed Snible
 */
public interface GEFProvider {

	/**
	 * @return the GEF EditDomain in charge of the CommandStack
	 */
	EditDomain getEditDomain();

}
