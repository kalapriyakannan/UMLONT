/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.navigator.deploy;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Import;

/**
 * Sorts EObjects based on their EClass first then name.
 * 
 * @author NKruk
 * 
 */
public class TopologyUnitSorter extends ViewerSorter {

	private final DeployEMFLabelProvider labelProvider = new DeployEMFLabelProvider();

	/**
	 * Returns a negative, zero, or positive number depending on whether the first element is less
	 * than, equal to, or greater than the second element.
	 * <p>
	 * The default implementation of this method is based on comparing the elements' categories as
	 * computed by the <code>category</code> framework method. Elements within the same category
	 * are further subjected to a case insensitive compare of their label strings, either as computed
	 * by the content viewer's label provider, or their <code>toString</code> values in other
	 * cases. Subclasses may override.
	 * </p>
	 * 
	 * @param viewer
	 *           the viewer
	 * @param e1
	 *           the first element
	 * @param e2
	 *           the second element
	 * @return a negative number if the first element is less than the second element; the value
	 *         <code>0</code> if the first element is equal to the second element; and a positive
	 *         number if the first element is greater than the second element
	 */
	public int compare(Viewer viewer, Object e1, Object e2) {
		if (e1 instanceof DeployModelObject && e2 instanceof DeployModelObject) {

			int cat1 = category(e1);
			int cat2 = category(e2);

			if (cat1 != cat2) {
				return cat1 - cat2;
			}

			String name1;
			String name2;

			name1 = labelProvider.getText(e1);
			name2 = labelProvider.getText(e2);
			if (name1 == null) {
				name1 = "";//$NON-NLS-1$
			}
			if (name2 == null) {
				name2 = "";//$NON-NLS-1$
			}

			// use the comparator to compare the strings
			return getComparator().compare(name1, name2);
		}
		return super.compare(viewer, e1, e2);
	}

	public int category(Object element) {
		if (element instanceof TopologyDiagramNode) {
			return 0;
		}
		if (element instanceof Import) {
			return 1;
		}
		if (element instanceof EObject) {
			EObject o = (EObject) element;
			return o.eClass().hashCode() + 2;
		}
		return 2;
	}
}
