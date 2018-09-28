/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.was.internal.filter;

import java.util.ArrayList;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitFilter;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;

/**
 * @author <a href="mailto:tianchen@cn.ibm.com">Tian Chen</a>
 */

public class WasSibusUnitFilter extends UnitFilter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.UnitFilter#getAllowableHostingTemplates(com.ibm.ccl.soa.deploy.core.Unit)
	 */
	public List<String> getAllowableHostingUnitTypes(Unit anInputUnit) {
		List<String> list = new ArrayList<String>();

		if (anInputUnit.isConceptual()) {
			list.add(IWasTemplateConstants.WAS_SIBUS_INBOUND_SERVICE_UNIT_CONCEPTUAL);
			list.add(IWasTemplateConstants.WAS_SIBUS_OUTBOUND_PORT_UNIT_CONCEPTUAL);
			list.add(IWasTemplateConstants.WAS_SIBUS_DESTINATION_UNIG_CONCEPTUAL);
			list.add(IWasTemplateConstants.WAS_SIBUS_MEDIATION_UNIG_CONCEPTUAL);
		} else {
			list.add(IWasTemplateConstants.WAS_SIBUS_INBOUND_SERVICE_UNIT);
			list.add(IWasTemplateConstants.WAS_SIBUS_OUTBOUND_PORT_UNIT);
			list.add(IWasTemplateConstants.WAS_SIBUS_DESTINATION_UNIG);
			list.add(IWasTemplateConstants.WAS_SIBUS_MEDIATION_UNIG);
		}

		return list;
	}

	public List<String> getAllowableMemberUnitTypes(Unit anInputUnit) {

		List<String> list = new ArrayList<String>();

		if (anInputUnit.isConceptual()) {
			list.add(IWasTemplateConstants.WAS_6_APPLICATION_SERVER_UNIT_CONCEPTUAL);
			list.add(IWasTemplateConstants.WAS_6_CLUSTER_UNIT_CONCEPTUAL);
			list.add(IWasTemplateConstants.WAS_MESSAGING_ENGINE_CONCEPTUAL);
		} else {
			list.add(IWasTemplateConstants.WAS_6_APPLICATION_SERVER_UNIT);
			list.add(IWasTemplateConstants.WAS_6_CLUSTER_UNIT);
			list.add(IWasTemplateConstants.WAS_MESSAGING_ENGINE);
		}
		return list;
	}

	@Override
	public boolean isVolatile() {
		// Don't cache the types, because the user may toggle the conceptual bit and
		// expect the filter to generate different stuff.
		return true;
	}
}
