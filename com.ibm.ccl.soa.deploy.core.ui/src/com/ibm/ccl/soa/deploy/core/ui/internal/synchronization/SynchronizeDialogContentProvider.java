/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.synchronization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * Provides a list of Components from the current diagram to synchronize.
 * 
 */
public class SynchronizeDialogContentProvider implements ITreeContentProvider {

	private static final Object[] NO_CHILDREN = new Object[0];

	public Object[] getChildren(Object parentElement) {

		if (parentElement instanceof Unit) {
			Unit unit = (Unit) parentElement;
			List<Unit> configurationUnits = new ArrayList<Unit>();
			for (Iterator iter = unit.getEditTopology().getRelationships().getHostedLinks(unit)
					.iterator(); iter.hasNext();) {
				HostingLink link = (HostingLink) iter.next();
				Unit target = link.getTarget();
				if (target.isConfigurationUnit() && !target.isConceptual()) {
					configurationUnits.add(target);
				}
			}
			return configurationUnits.toArray();

		}

		return NO_CHILDREN;
	}

	public Object getParent(Object element) {
		if (element instanceof Unit) {
			Unit unit = (Unit) element;
			Unit[] hosts = unit.getEditTopology().findHosts(unit);
			if (hosts.length > 0) {
				return hosts[0];
			}
		}
		return null;
	}

	public boolean hasChildren(Object element) {
		return element instanceof Unit
				&& ((Unit) element).getEditTopology().getRelationships().getHostedLinks((Unit) element)
						.size() > 0;
	}

	public Object[] getElements(Object inputElement) {

		if (inputElement instanceof Topology) {
			Topology inputTopology = (Topology) inputElement;
			List<Unit> elements = new ArrayList<Unit>();
			for (Iterator<Unit> iter = inputTopology.findAllUnits(); iter.hasNext();) {
				Unit unit = iter.next();
				if (!unit.isConfigurationUnit() && !unit.isConceptual()) {
					elements.add(unit);
				}
			}
			return elements.toArray();
		}

		return NO_CHILDREN;
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

	public void dispose() {

	}

}
