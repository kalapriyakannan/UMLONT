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
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.os.IOsTemplateConstants;
import com.ibm.ccl.soa.deploy.os.LinuxOperatingSystemUnit;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.RedhatLinuxOperatingSystem;
import com.ibm.ccl.soa.deploy.os.SUSELinuxOperatingSystem;

/**
 * Suggests {@link Unit} types to be contained by an {@link LinuxOperatingSystemUnit}.
 * 
 * &lt;unitFilter&gt; registered on the <code>com.ibm.ccl.soa.deploy.core.unitLifecycle</code>
 * extension.
 * 
 * @see LinuxOperatingSystemUnit
 */
public class LinuxOperatingSystemUnitFilter extends UnitFilter {

	private final static List<String> redhatLinuxHostingUnitTypes = Collections
			.unmodifiableList(Arrays.asList(new String[] {
					IOsTemplateConstants.OS_REDHAT_LOCAL_USER_UNIT,
					IOsTemplateConstants.OS_REDHAT_LOCAL_GROUP_UNIT,
					IOsTemplateConstants.OS_UNIX_FILE_SYSTEM_UNIT }));
	private final static List<String> suseLinuxHostingUnitTypes = Collections
			.unmodifiableList(Arrays.asList(new String[] {
					IOsTemplateConstants.OS_SUSE_LOCAL_USER_UNIT,
					IOsTemplateConstants.OS_SUSE_LOCAL_GROUP_UNIT,
					IOsTemplateConstants.OS_UNIX_FILE_SYSTEM_UNIT }));
	private final static List<String> genericOsHostingUnitTypes = Collections
			.unmodifiableList(Arrays.asList(new String[] { IOsTemplateConstants.OS_USER_CONCEPTUAL,
					IOsTemplateConstants.OS_USER_GROUP_UNIT_CONCEPTUAL,
					IOsTemplateConstants.OS_UNIX_FILE_SYSTEM_UNIT }));

	/**
	 * Clients don't call this directly; it should be called through DeployableUnitElementUIService
	 * or GMF's ModelingAssistantService.
	 */
	@Override
	public List<String> getAllowableHostingUnitTypes(Unit anInputUnit) {
		OperatingSystem osCap = (OperatingSystem) ValidatorUtils.getFirstCapability(anInputUnit,
				OsPackage.eINSTANCE.getOperatingSystem());
		if (osCap != null) {
			if (osCap instanceof RedhatLinuxOperatingSystem) {
				return redhatLinuxHostingUnitTypes;
			} else if (osCap instanceof SUSELinuxOperatingSystem) {
				return suseLinuxHostingUnitTypes;
			}
		}
		return genericOsHostingUnitTypes;
	}
} // end class LinuxOperatingSystemUnitFilter
