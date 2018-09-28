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
import java.util.Collections;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitFilter;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;
import com.ibm.ccl.soa.deploy.was.WasEditionEnum;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSystem;
import com.ibm.ccl.soa.deploy.was.WasSystemUnit;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;

/**
 * @author <a href="mailto:tianchen@cn.ibm.com">Tian Chen</a>
 * @see WasSystemUnit
 */

public class WasSystemUnitFilter extends UnitFilter {

	public List<String> getAllowableHostingUnitTypes(Unit anInputUnit) {

		assert anInputUnit != null;

		List<String> list = new ArrayList<String>();

		WasSystem wasSystemCap = (WasSystem) ValidatorUtils.getCapability(anInputUnit,
				WasPackage.eINSTANCE.getWasSystem());
		if (wasSystemCap == null) {
			return Collections.emptyList();
		}

		boolean isND = wasSystemCap.getWasEdition() == WasEditionEnum.NETWORK_DEPLOYMENT_LITERAL;
		if (wasSystemCap.getWasVersion() != null
				&& wasSystemCap.getWasVersion().startsWith(WasUtil.WAS_6_MAIN_VERSION)) {
			if (isND) {
				if (anInputUnit.isConceptual() ? list
						.add(IWasTemplateConstants.WAS_6_DEPLOYMENT_MANAGER_PROFILE_CONCEPTUAL) : list
						.add(IWasTemplateConstants.WAS_6_DEPLOYMENT_MANAGER_PROFILE)) {
					;
				}
			}
			if (anInputUnit.isConceptual() ? list
					.add(IWasTemplateConstants.WAS_6_APPLICATION_SERVER_PROFILE_CONCEPTUAL) : list
					.add(IWasTemplateConstants.WAS_6_APPLICATION_SERVER_PROFILE)) {
				;
			}
			if (isND) {
				if (anInputUnit.isConceptual() ? list
						.add(IWasTemplateConstants.WAS_6_NODE_UNIT_CONCEPTUAL) : list
						.add(IWasTemplateConstants.WAS_6_NODE_UNIT)) {
					;
				}
			}
			list.add(IWasTemplateConstants.WAS_6_UNMANAGED_NODE_WITH_WEB_SERVER);
		} else {
			if (anInputUnit.isConceptual() ? list
					.add(IWasTemplateConstants.WAS_5_NODE_UNIT_CONCEPTUAL) : list
					.add(IWasTemplateConstants.WAS_5_NODE_UNIT)) {
				;
			}
			if (isND) {
				if (anInputUnit.isConceptual() ? list
						.add(IWasTemplateConstants.WAS_5_DMGR_NODE_UNIT_CONCEPTUAL) : list
						.add(IWasTemplateConstants.WAS_5_DMGR_NODE_UNIT)) {
					;
				}
			}

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
