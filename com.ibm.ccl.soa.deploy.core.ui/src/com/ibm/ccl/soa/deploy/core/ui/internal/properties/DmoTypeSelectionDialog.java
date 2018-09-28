/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.properties;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;

/**
 * @since 7.0
 * 
 */
public class DmoTypeSelectionDialog extends ElementListSelectionDialog {

	/**
	 * @param parent
	 *           The parent {@link Shell}.
	 * @param aTitle
	 *           A title for the dialog.
	 * @param showCapabilities
	 *           A boolean indicating if Capability types should be shown.
	 * @param showUnits
	 *           A boolean indicating if Unit tyes should be shown.
	 */
	public DmoTypeSelectionDialog(Shell parent, String aTitle, boolean showCapabilities,
			boolean showUnits) {
		super(parent, PropertyUtils.getSoaLabelProvider());
		setMultipleSelection(false);
		if (aTitle != null) {
			setTitle(aTitle);
		}
		initializeElements(showCapabilities, showUnits);
	}

	private void initializeElements(boolean showCapabilities, boolean showUnits) {
		List<String> elements = new ArrayList<String>();
		if (showCapabilities) {
			elements.addAll(PropertyUtils.getCapTypeNames());
		}
		if (showUnits) {
			elements.addAll(PropertyUtils.getUnitTypeNames());
		}
		Collections.sort(elements);
		setElements(elements.toArray());
	}

	/**
	 * 
	 * @return An {@link EClass} based on the selection. Null may be returned if the dialog was
	 *         cancelled or if a <none> selection was made.
	 */
	public org.eclipse.emf.ecore.EClass getSelectedEType() {
		Object selection = getFirstResult();
		if (selection != null) {
			return PropertyUtils.getETypeFromName((String) selection);
		}
		return null;
	}

}
