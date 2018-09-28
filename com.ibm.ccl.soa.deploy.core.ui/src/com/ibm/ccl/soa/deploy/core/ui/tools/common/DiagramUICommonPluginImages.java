/*
 * +--------------------------------------------------------------------------------+ | Licensed
 * Materials - Property of IBM | | Copyright IBM Corporation 2008. All Rights Reserved. | | | | Note
 * to US Government Users Restricted Rights: Use, duplication or disclosure | | restricted by GSA
 * ADP Schedule Contract with IBM Corp. |
 * +--------------------------------------------------------------------------------+
 */
package com.ibm.ccl.soa.deploy.core.ui.tools.common;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;

/**
 * @since 7.0
 * 
 */
public class DiagramUICommonPluginImages {

	/**
	 * The icons root directory.
	 */
	static final String PREFIX_ROOT = "icons/"; //$NON-NLS-1$

	/**
	 * Enabled subdirectory off of root icon directory
	 */
	private static final String PREFIX_ENABLED = PREFIX_ROOT + "elcl16/"; //$NON-NLS-1$

	public static final ImageDescriptor DESC_ADDSHAPECURSOR_MASK = create(PREFIX_ENABLED
			+ "addshape_masks.bmp");//$NON-NLS-1$
	public static final ImageDescriptor DESC_ADDSHAPECURSOR_SOURCE = create(PREFIX_ENABLED
			+ "addshape_pointer.bmp");//$NON-NLS-1$	

	/**
	 * Creates the image descriptor from the filename given.
	 * 
	 * @param imageName
	 *           the full filename of the image
	 * @return the new image descriptor
	 */
	private static ImageDescriptor create(String imageName) {
		return AbstractUIPlugin.imageDescriptorFromPlugin(DeployCoreUIPlugin.PLUGIN_ID, imageName);
	}

}
