/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.properties;

import java.util.LinkedList;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.ibm.ccl.soa.deploy.core.Artifact;
import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * Hand-crafted tree content provider for a Unit's {@link Artifact}s.
 * 
 * @see ModulePropertySection
 */
public class ArtifactContentProvider implements ITreeContentProvider {

	private static final Object[] NONE = new Object[0];

	/**
	 * Constructor.
	 */
	public ArtifactContentProvider() {
		// do nothing
	}

	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof Unit) {
			Unit module = (Unit) parentElement;
//			Object[] retVal = module.getArtifacts().toArray();
//			return retVal;

			// Work around for M6 bug
			LinkedList<Artifact> retVal = new LinkedList<Artifact>();
			int n = module.getArtifacts().size();
			for (int i = 0; i < n; i++) {
				retVal.add((Artifact) module.getArtifacts().get(i));
			}
			return retVal.toArray();
		} else if (parentElement instanceof Artifact) {
			return NONE;
		}

		System.out.println("parentElement instanceof " + parentElement.getClass()); //$NON-NLS-1$
		return NONE;
	}

	public Object getParent(Object element) {
		return null;
	}

	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}

	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	public void dispose() {
		// Do nothing
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// Do nothing
	}

} // end class ArtifactContentProvider
