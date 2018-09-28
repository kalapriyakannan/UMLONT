/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.was.internal.filter;

import java.util.ArrayList;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitFilter;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;
import com.ibm.ccl.soa.deploy.was.WasNodeGroupUnit;

/**
 * Suggests {@link Unit} types to be contained by an {@link WasNodeGroupUnit}.
 * 
 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
 * @see WasNodeGroupUnit
 */
public class WebsphereNodeGroupUnitFilter extends UnitFilter {

	public List<String> getAllowableMemberUnitTypes(Unit anInputUnit) {
		List<String> list = new ArrayList<String>();
		if (anInputUnit.isConceptual() ? list.add(IWasTemplateConstants.WAS_6_NODE_UNIT_CONCEPTUAL)
				: list.add(IWasTemplateConstants.WAS_6_NODE_UNIT)) {
			;
		}
		return list;
	}

	@Override
	public boolean isVolatile() {
		return true;
	}
}
