/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.test.provider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;

/**
 * @author Alexander
 * 
 */
public class JUnitUnitDescriptor extends UnitDescriptor {

	protected Unit originalUnit;

	protected JUnitTopologyProvider provider;

	public JUnitUnitDescriptor(Unit originalUnit, JUnitTopologyProvider provider) {
		assert originalUnit != null;
		assert provider != null;
		this.originalUnit = originalUnit;
		this.provider = provider;
	}

	protected String createDescriptorName() {
		return originalUnit.getCaptionProvider().title(originalUnit);
	}

	protected String createDisplayName() {
		return originalUnit.getDisplayName();
	}

	protected Unit getUnit() {
		return JUnitTopologyProvider.copyUnitWithoutLinks(originalUnit);
	}

	protected Unit getUnitAndAddToTopology(Topology topology) {
		Unit existing = (Unit) provider.lookupProvided(originalUnit, topology);
		if (existing != null) {
			return existing;
		}
		// Copy the object & add to topology
		Unit copy = JUnitTopologyProvider.copyUnitWithoutLinks(originalUnit);
		topology.getUnits().add(copy);

		// Resolve all links to added unit and all its contained objects.
		List list = new ArrayList();
		list.add(copy);
		for (Iterator iter = copy.eAllContents(); iter.hasNext();) {
			Object obj = iter.next();
			if (obj instanceof DeployModelObject) {
				list.add(obj);
			}
		}
		provider.resolveLinks(list, null);
		return copy;
	}

	public boolean referencesUnit(Unit unit) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean referencesUnit(UnitDescriptor descriptor) {
		// TODO Auto-generated method stub
		return false;
	}

}
