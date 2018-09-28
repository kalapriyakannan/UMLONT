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

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.osgi.util.NLS;
import org.eclipse.osgi.util.TextProcessor;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * CapabilityCaptionProvider generates captions on behalf of {@link Capability}s.
 * 
 * <p>
 * Units and Capabilities can't generate their own captions because they can't see how the 'proxy
 * layer' has mangled them.
 */
public class CapabilityCaptionProvider {

	// deliminators passed to TextProcessor to fix RTL embedded strings
	static final private String delim = "<:>[]()"; //$NON-NLS-1$

	/**
	 * @param cap
	 * @param hypotheticals
	 *           Map of DeployModelObject->Map(of String->Object); overrides to value
	 * @return if not-null, the Unit contribution to the recommended title
	 */
	public String calculatedTitle(Capability cap, Map<EAttribute, String> hypotheticals) {

		List<EAttribute> titleKeys = cap.titleKeys();
		if (titleKeys == null || titleKeys.size() == 0) {
			return null;
		}

		// Optimization to avoid string buffer creation for common case of single key
		// if only one key, no colon in title
		String retVal = keyValue(cap, titleKeys.get(0), hypotheticals);
		if (titleKeys.size() > 1) {
			// else put colons between each key
			for (int i = 1; i < titleKeys.size(); i++) {
				retVal = NLS.bind(DeployCoreMessages.CapabilityCaptionProvider_PART_SUBPART, retVal,
						keyValue(cap, titleKeys.get(i), hypotheticals));
			}
		}

		// process string for embedded RTL characters
		retVal = TextProcessor.deprocess(retVal);
		retVal = TextProcessor.process(retVal, delim);
		return retVal;
	}

	/**
	 * @param cap
	 * @return A String that names the Unit
	 */
	public String title(Capability cap) {
		String retVal = null;
		// if display name defined, use that
		if (cap.getDisplayName() != null) {
			retVal = cap.getDisplayName();
		}

		// else see if there are title keys and use that
		if (retVal == null) {
			retVal = calculatedTitle(cap, null);
		}

		// else if all else fails, use the name anchor
		if (retVal == null) {
			retVal = cap.getName();
		}

		// process string for embedded RTL characters
		retVal = TextProcessor.deprocess(retVal);
		retVal = TextProcessor.process(retVal, delim);
		return retVal;
	}

	/**
	 * @param cap
	 * @return A String that names the Unit and supplies additional information
	 */
	public String titleWithContext(Capability cap) {
		String retVal = null;

		// see if parent provider can provide context to capability title ("capability title" in "parent title")
		if (cap.getParent() instanceof Unit) {
			Unit parent = (Unit) cap.getParent();
			UnitCaptionProvider parentCaptionProvider = parent.getCaptionProvider();
			retVal = NLS.bind(DeployCoreMessages.CapabilityCaptionProvider_0_in_1_, new Object[] {
					title(cap), parentCaptionProvider.titleWithContext(parent) });
		}

		// else just use capability title w/o context
		if (retVal == null) {
			retVal = title(cap);
		}

		// process string for embedded RTL characters
		retVal = TextProcessor.deprocess(retVal);
		retVal = TextProcessor.process(retVal, delim);
		return retVal;
	}

	private String keyValue(Capability cap, EAttribute key, Map<EAttribute, String> hypotheticals) {
		// No matter what is in the object, the hypothethical new value always overrides
		if (hypotheticals != null) {
			String retVal = hypotheticals.get(key);
			if (retVal != null) {
				return retVal;
			}
		}

		Object retVal = null;
		if (key instanceof EStructuralFeature) {
			retVal = cap.eGet(key);
			//			} else if (key instanceof String) {
			//				retVal = DeployModelObjectUtil.getAttributeValue(cap, (String) key);
		}

		// Defect #415 fixed -- don't treat the empty string as more valid than null string
		if (retVal != null && (!(retVal instanceof String) || ((String) retVal).length() > 0)) {
			return retVal.toString();
		}

		// Attribute was null

		return NLS.bind(DeployCoreMessages.CapabilityCaptionProvider_no_0_, key.getName());
	}

} // end class CapabilityCaptionProvider
