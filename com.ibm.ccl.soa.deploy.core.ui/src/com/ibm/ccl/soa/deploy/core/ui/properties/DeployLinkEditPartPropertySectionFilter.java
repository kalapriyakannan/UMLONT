/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.properties;

import org.eclipse.jface.viewers.IFilter;

import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployConnectionNodeEditPart;

/**
 * filter for a <code>org.eclipse.ui.views.properties.tabbed.propertySections</code>
 * &lt;propertySection&gt;.
 * 
 * <p>
 * Returns false for everything except SOA Deploy links.
 * 
 * @author Ed Snible
 * @see DeployConnectionNodeEditPart
 */
public class DeployLinkEditPartPropertySectionFilter implements IFilter {

	public boolean select(Object object) {
		if (object instanceof DeployConnectionNodeEditPart) {

			return true;
		}

		return false;
	}

}
