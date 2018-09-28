/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.util;

import org.eclipse.gmf.runtime.emf.type.core.IHintedType;

/**
 * @author Manish Bhargava
 * 
 * Note: in GMF M5, IHintedType will become public. Till them depend on it.
 * 
 */
public interface IUnitElementType extends IHintedType {

	/**
	 * Gets the uri hint required for pre configured unit creation.
	 * 
	 * @return the template URI hint.
	 */
	String getTemplateURI();
}
