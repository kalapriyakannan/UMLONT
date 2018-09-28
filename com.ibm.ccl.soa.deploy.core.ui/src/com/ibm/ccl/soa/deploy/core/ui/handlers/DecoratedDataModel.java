/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.handlers;

import org.eclipse.jface.fieldassist.DecoratedField;

/**
 * An interface with methods for registering and refreshing decorations.
 * 
 * @author Ed Snible
 * @see DecoratingDataModelWizardPage
 * @deprecated
 */
public interface DecoratedDataModel {

	/**
	 * Register a decorated field
	 * 
	 * @param decor
	 * @param propertyName
	 */
	void registerDecoratedField(DecoratedField decor, String propertyName);

	/**
	 * Refresh all registered decorated fields
	 */
	void refreshDecorations();

	/**
	 * Refresh a single decorated field
	 * 
	 * @param propertyName
	 */
	public void refreshDecoration(String propertyName);
}
