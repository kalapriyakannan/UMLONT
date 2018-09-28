/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.properties;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.IFilter;

import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ImportTopologyEditPart;

/**
 * &lt;propertySection filter=&gt; for Imported Topology
 * 
 * @author Ed Snible
 */
public class ImportEditPartFilter implements IFilter {

	public boolean select(Object object) {
		if (object instanceof ImportTopologyEditPart) {

			return true;
		}

		// Allow the property pages to come up when selecting in the outline view
		if (object instanceof EditPart) {
			EditPart ep = (EditPart) object;
			if (ep.getModel() instanceof View) {
				View view = (View) ep.getModel();
				return view.getElement() instanceof Import;
			}
		}

		return false;
	}

} // end class ImportEditPartFilter
