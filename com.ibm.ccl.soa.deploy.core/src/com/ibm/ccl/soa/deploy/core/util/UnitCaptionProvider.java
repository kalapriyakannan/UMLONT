/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.util;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.osgi.util.NLS;
import org.eclipse.osgi.util.TextProcessor;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * DmoCaptionProvider generates captions on behalf of Units and Capabilities.
 * 
 * <p>
 * Units and Capabilities can't generate their own captions because they can't see how the 'proxy
 * layer' has mangled them.
 */
public class UnitCaptionProvider {

	// deliminators passed to TextProcessor to fix RTL embedded strings
	static final private String delim = "<:>[]()"; //$NON-NLS-1$

	/**
	 * @param unit
	 * @param hypotheticals
	 *           Map of DeployModelObject->Map(of String->Object); overrides to value
	 * @return if not-null, the Unit contribution to the recommended title
	 */
	public String calculatedTitle(Unit unit, Map<Capability, Map<EAttribute, String>> hypotheticals) {

		// Use the title of the first Capability.  Ignore conflicts.
		String retVal = null;
		for (Iterator<Capability> it = unit.getCapabilities().iterator(); it.hasNext();) {
			Capability cap = it.next();
			Map<EAttribute, String> capHypotheticals = hypotheticals == null ? null : hypotheticals
					.get(cap);
			retVal = cap.getCaptionProvider().calculatedTitle(cap, capHypotheticals);
			if (retVal != null) {
				break;
			}
		}

		// process string for embedded RTL characters
		// already done in capability caption provider
		return retVal;
	}

	/**
	 * @param unit
	 * @return A String that names the Unit
	 */
	public String title(Unit unit) {
		String retVal = null;
		// if there's a display name, just use that
		//5606: Caption setting problems with imported units
		String displayName = unit.getDisplayName();
		if (displayName != null && displayName.length() > 0) {
			retVal = unit.getDisplayName();
		}

		// else try to use the title from the first capability on this unit
		if (retVal == null) {
			retVal = calculatedTitle(unit, null);
		}

		// else if all else fails use the unit's anchor name
		if (retVal == null) {
			retVal = unit.getName();
		}

		// process string for embedded RTL characters
		retVal = TextProcessor.deprocess(retVal);
		retVal = TextProcessor.process(retVal, delim);
		return retVal;
	}

	/**
	 * @param unit
	 * @return A String that names the Unit and supplies additional information
	 */
	public String titleWithContext(Unit unit) {
		String retVal = null;
		Topology top = unit.getEditTopology();
		if (top != null) {

			// if this unit is hosted, see if host's title provider can add context
			//  to the unit title ("unit title" on "parent title")
			Unit[] hosters = top.findHosts(unit);
			if (hosters != null && hosters.length > 0) {
				Unit host = hosters[0];
				UnitCaptionProvider hostCaptionProvider = host.getCaptionProvider();
				String str = NLS.bind(DeployCoreMessages.UnitCaptionProvider_0_on_1_, new Object[] {
						title(unit), hostCaptionProvider.title(host) });
				retVal = TextProcessor.process(str, delim);
			}

			// else if this unit is a member of a group, see if group's title provider can add
			// context to the unit title ("unit title" in "group title")
			if (retVal == null && unit.getHostingOrAnyRequirements().size() == 0
					&& unit.getOnlyMemberRequirements().size() != 0) {
				Unit[] groups = top.findMemberOf(unit);
				if (groups.length > 0) {
					StringBuffer buffer = new StringBuffer();
					buffer.append(title(unit));
					buffer.append(DeployCoreMessages.UnitCaptionProvider_in_);
					for (int i = 0; i < groups.length; i++) {
						if (i > 0) {
							buffer.append(',');
							buffer.append(' ');
						}
						UnitCaptionProvider hostCaptionProvider = groups[i].getCaptionProvider();
						buffer.append(hostCaptionProvider.title(groups[i]));
					}
					retVal = buffer.toString();
				}
			}
		}

		// else just use the unit title w/o context
		if (retVal == null) {
			retVal = title(unit);
		}

		// process string for embedded RTL characters
		retVal = TextProcessor.deprocess(retVal);
		retVal = TextProcessor.process(retVal, delim);
		return retVal;
	}

} // end class UnitCaptionProvider
