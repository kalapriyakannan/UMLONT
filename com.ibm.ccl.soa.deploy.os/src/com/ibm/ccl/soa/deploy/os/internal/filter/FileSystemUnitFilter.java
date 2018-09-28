/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.os.internal.filter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitFilter;
import com.ibm.ccl.soa.deploy.os.FileSystemUnit;
import com.ibm.ccl.soa.deploy.os.IOsTemplateConstants;

/**
 * Suggests {@link Unit} types to be contained by an {@link FileSystemUnit}.
 * 
 * &lt;unitFilter&gt; registered on the <code>com.ibm.ccl.soa.deploy.core.unitLifecycle</code>
 * extension.
 * 
 * @see FileSystemUnit
 */
public class FileSystemUnitFilter extends UnitFilter {

	private final static List<String> fileSystemHostingUnitTypes = Collections
			.unmodifiableList(Arrays.asList(new String[] { IOsTemplateConstants.OS_DIRECTORY_UNIT }));

	/**
	 * Clients don't call this directly; it should be called through DeployableUnitElementUIService
	 * or GMF's ModelingAssistantService.
	 */
	@Override
	public List<String> getAllowableHostingUnitTypes(Unit anInputUnit) {
		return fileSystemHostingUnitTypes;
	}
} // end class FileSystemUnitFilter
