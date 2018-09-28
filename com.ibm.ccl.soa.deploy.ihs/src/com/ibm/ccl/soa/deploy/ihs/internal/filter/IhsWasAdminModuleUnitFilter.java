/***************************************************************************************************
 * Copyright (c) 2003, 2008 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.ihs.internal.filter;

import java.util.ArrayList;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitFilter;
import com.ibm.ccl.soa.deploy.ihs.IIhsTemplateConstants;
import com.ibm.ccl.soa.deploy.ihs.IhsWasAdminModuleUnit;

/**
 * Suggests {@link Unit} types to be hosted by an {@link IhsWasAdminModuleUnit}.
 * 
 * @since 3.2
 * @see IhsWasAdminModuleUnit
 */
public class IhsWasAdminModuleUnitFilter extends UnitFilter {

	/**
	 * Returns the 'ihsWasAdminModuleUnitTool.spec' specialization type from the *.ihs.ui/plugin.xml.
	 * 
	 * @return a List of Strings which are &lt;specializationType id=&gt; values.
	 */
	@Override
	public List<String> getAllowableHostingUnitTypes(Unit anInputUnit) {
		List<String> list = new ArrayList<String>(1);
		list.add(IIhsTemplateConstants.IHS_USER_UNIT);
		return list;
	}

}
