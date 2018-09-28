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
import com.ibm.ccl.soa.deploy.os.IOsTemplateConstants;
import com.ibm.ccl.soa.deploy.os.WindowsOperatingSystemUnit;

/**
 * Suggests {@link Unit} types to be contained by an {@link WindowsOperatingSystemUnit}.
 * 
 * &lt;unitFilter&gt; registered on the <code>com.ibm.ccl.soa.deploy.core.unitLifecycle</code>
 * extension.
 * 
 * @see WindowsOperatingSystemUnit
 */
public class WindowsOperatingSystemUnitFilter extends UnitFilter {

	private final static List<String> windowsHostingUnitTypes = Collections.unmodifiableList(Arrays
			.asList(new String[] { IOsTemplateConstants.OS_WINDOWS_LOCAL_USER_UNIT,
					IOsTemplateConstants.OS_WINDOWS_LOCAL_GROUP_UNIT,
					IOsTemplateConstants.OS_WINDOWS_FILE_SYSTEM_UNIT }));

	/**
	 * Clients don't call this directly; it should be called through DeployableUnitElementUIService
	 * or GMF's ModelingAssistantService.
	 */
	@Override
	public List<String> getAllowableHostingUnitTypes(Unit anInputUnit) {
		return windowsHostingUnitTypes;
		//
		//						List<String> list = new ArrayList<String>();
		//						list.add("os.WindowsLocalUserUnit"); //$NON-NLS-1$
		//						list.add("os.WindowsLocalGroupUnit"); //$NON-NLS-1$
		//				return list;
		//
		//		// The return List should be able to handle Strings (GMF/RTS type IDs, template URIs,
		//		// AbstractOperations, and Lists of any of these.
		//		return Collections.unmodifiableList(createHostees((WindowsOperatingSystemUnit) anInputUnit));
	}

	/**
	 * The commented-out code is an example of how to use UnitFilterTemplate or UnitFilterAction to
	 * customize the behavior
	 */

	//	private static List<? extends UnitFilterTemplate> createHostees(
	//			WindowsOperatingSystemUnit windows) {
	//		return Arrays.asList(new UnitFilterTemplate[] { createUser(windows.isConceptual()) });
	//	}
	//
	//	private static UnitFilterTemplate createUser(boolean conceptual) {
	//
	//		if (conceptual) {
	//			return new UnitFilterTemplate(
	//					"Windows User", "platform:///plugin/com.ibm.ccl.soa.deploy.os/icons/pal/win_user_16.gif", "platform:/plugin/com.ibm.ccl.soa.deploy.os/templates/WindowsUserC.template"); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
	//		} else {
	//			return new UnitFilterTemplate(
	//					"Windows User", "platform:///plugin/com.ibm.ccl.soa.deploy.os/icons/pal/win_user_16.gif", "platform:/plugin/com.ibm.ccl.soa.deploy.os/templates/WindowsUser.template"); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
	//		}
	//	}
	//	private static UnitFilterAction createUser() {
	//
	//		return new UnitFilterAction(
	//				"Windows User", "platform:///plugin/com.ibm.ccl.soa.deploy.os/icons/pal/win_user_16.gif") { //$NON-NLS-1$//$NON-NLS-2$
	//
	//			@Override
	//			public IStatus run(Unit context, List<DeployModelObject> outDmosToReveal) {
	//				WindowsLocalUserUnit user = OsFactory.eINSTANCE.createWindowsLocalUserUnit();
	//				user.setName(UnitUtil.generateUniqueName(windows.getParent(), "u")); //$NON-NLS-1$
	//				context.getTopology().getUnits().add(user);
	//				host(context, user);
	//				outDmosToReveal.add(user);
	//				return Status.OK_STATUS;
	//			}
	//
	//		};
	//	}
	//
	//	protected static void host(Unit hoster, Unit hostee) {
	//		HostingLink hl = CoreFactory.eINSTANCE.createHostingLink();
	//		hl.setSource(hoster);
	//		hl.setTarget(hostee);
	//		hl.setName(UnitUtil.generateUniqueName(hoster, "hl")); //$NON-NLS-1$
	//		hoster.getHostingLinks().add(hl);
	//	}
} // end class WindowsOperatingSystemUnitFilter
