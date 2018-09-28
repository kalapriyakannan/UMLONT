/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.properties;

import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.jface.viewers.IFilter;

import com.ibm.ccl.soa.deploy.core.RealizationLink;

/**
 * filter for a <code>org.eclipse.ui.views.properties.tabbed.propertySections</code>
 * &lt;propertySection&gt;.
 * 
 * <p>
 * Returns false for everything except EditParts that refer to SOA Deploy {@link RealizationLink}s.
 * 
 * @author snible@us.ibm.com
 * @deprecated
 */
public class RealizationLinkFilter implements IFilter {

	public boolean select(Object object) {
		if (object instanceof AbstractConnectionEditPart) {
			AbstractConnectionEditPart acep = (AbstractConnectionEditPart) object;
			if (acep.getModel() instanceof Edge) {
				Edge edge = (Edge) acep.getModel();
				if (edge.getElement() instanceof RealizationLink) {
					return true;
				}
			}
		}

		return false;
	}

}
