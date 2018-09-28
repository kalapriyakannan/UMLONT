/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal;

import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedColors;

public class SharedColors implements ISharedColors {

	private final String bundleId;
	private final ColorRegistry colorRegistry;

	/**
	 * Create an instance that will store colors in the given registry and default to the given
	 * bundle id for looking up local color.
	 * 
	 * @param id
	 *           The id of a bundle that stores color that will be loaded from this instance of
	 *           {@link ISharedColor}
	 * @param registry
	 *           A color that will actually contain color for this instance of {@link ISharedColor}.
	 */
	public SharedColors(String id, ColorRegistry registry) {

		if (id != null) {
			bundleId = id;
		} else {
			bundleId = DeployCoreUIPlugin.PLUGIN_ID;
		}
		if (registry != null) {
			colorRegistry = registry;
		} else {
			colorRegistry = DeployCoreUIPlugin.getDefault().getColorRegistry();
		}
		declareColor();
	}

	private void declareColor() {
		putColor(BLACK, new RGB(0, 0, 0));
		putColor(WHITE, new RGB(255, 255, 255));
		putColor(GHOST_FILL_COLOR, new RGB(40, 40, 40));
		putColor(TOOL_TIP_COLOR, new RGB(255, 255, 225));
	}

	public Color getColor(String symbolicName) {
		return colorRegistry.get(symbolicName);
	}

	public void putColor(String symbolicName, RGB rgb) {
		colorRegistry.put(symbolicName, rgb);

	}

}
