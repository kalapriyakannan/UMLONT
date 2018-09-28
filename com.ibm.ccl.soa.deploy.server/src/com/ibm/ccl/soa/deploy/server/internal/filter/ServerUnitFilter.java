/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.server.internal.filter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitFilter;
import com.ibm.ccl.soa.deploy.server.ServerUnit;

/**
 * Suggests {@link Unit} types to be contained by an {@link ServerUnit}.
 * 
 * &lt;unitFilter&gt; registered on the <code>com.ibm.ccl.soa.deploy.core.unitLifecycle</code>
 * extension.
 * 
 * @see ServerUnit
 */
public class ServerUnitFilter extends UnitFilter {

	// NOTE: These constants duplicate constants in *.soa.deploy.os.IOsTemplateConstants.
	// We can't use those, because we cannot depend on *.soa.deploy.os, because it depends on us!

	// Windows
	private static final String OS_WINDOWS_2000_UNIT = "os.OperatingSystemUnit.W2K.infra"; //$NON-NLS-1$
	private static final String OS_WINDOWS_2000_UNIT_CONCEPTUAL = "os.OperatingSystemUnit.W2K.conceptual"; //$NON-NLS-1$
	private static final String OS_WINDOWS_XP_UNIT = "os.OperatingSystemUnit.WXP.infra"; //$NON-NLS-1$
	private static final String OS_WINDOWS_XP_UNIT_CONCEPTUAL = "os.OperatingSystemUnit.WXP.conceptual"; //$NON-NLS-1$
	private static final String OS_WINDOWS_2003_UNIT = "os.OperatingSystemUnit.WServer2003.infra"; //$NON-NLS-1$
	private static final String OS_WINDOWS_2003_UNIT_CONCEPTUAL = "os.OperatingSystemUnit.WServer2003.conceptual"; //$NON-NLS-1$

	// Linux
	private static final String OS_LINUX_UNIT_CONCEPTUAL = "os.OperatingSystemUnit.Linux.conceptual"; //$NON-NLS-1$
	private static final String OS_REDHAT_4_LINUX_UNIT = "os.OperatingSystemUnit.RedhatAS4Linux.infra"; //$NON-NLS-1$
	private static final String OS_REDHAT_4_LINUX_UNIT_CONCEPTUAL = "os.OperatingSystemUnit.RedhatAS4Linux.conceptual"; //$NON-NLS-1$

	private static final String OS_SUSE_9_UNIT = "os.OperatingSystemUnit.SUSEServer9Linux.infra"; //$NON-NLS-1$
	private static final String OS_SUSE_9_UNIT_CONCEPTUAL = "os.OperatingSystemUnit.SUSEServer9Linux.conceptual"; //$NON-NLS-1$

	// AIX
	private static final String OS_AIX_5L_UNIT = "os.OperatingSystemUnit.AIX5L.infra"; //$NON-NLS-1$	
	private static final String OS_AIX_5L_UNIT_CONCEPTUAL = "os.OperatingSystemUnit.AIX5L.conceptual"; //$NON-NLS-1$

	private final static List<String> hostees = Collections.unmodifiableList(Arrays
			.asList(new String[] { OS_WINDOWS_2000_UNIT, OS_WINDOWS_XP_UNIT, OS_WINDOWS_2003_UNIT,
					OS_REDHAT_4_LINUX_UNIT, OS_SUSE_9_UNIT, OS_AIX_5L_UNIT }));
	private final static List<String> conceptualHostees = Collections.unmodifiableList(Arrays
			.asList(new String[] { OS_WINDOWS_2000_UNIT_CONCEPTUAL, OS_WINDOWS_XP_UNIT_CONCEPTUAL,
					OS_WINDOWS_2003_UNIT_CONCEPTUAL, OS_LINUX_UNIT_CONCEPTUAL,
					OS_REDHAT_4_LINUX_UNIT_CONCEPTUAL, OS_SUSE_9_UNIT, OS_AIX_5L_UNIT_CONCEPTUAL }));

	/**
	 * Clients don't call this directly; it should be called through DeployableUnitElementUIService
	 * or GMF's ModelingAssistantService.
	 */
	@Override
	public List<String> getAllowableHostingUnitTypes(Unit anInputUnit) {
		return anInputUnit.isConceptual() ? conceptualHostees : hostees;
	}

	@Override
	public boolean isVolatile() {
		// Don't cache the types, because the user may toggle the conceptual bit and
		// expect the filter to generate different stuff.
		return true;
	}
}
