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

import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;

import com.ibm.ccl.soa.deploy.core.ui.ISharedFonts;

/**
 * Internal implementation to registry and return shared fonts for the Deploy Core UI Plug-in.
 * 
 * @since 7.0
 * 
 */
public class SharedFonts implements ISharedFonts {

	private final FontRegistry fontRegistry;

	public SharedFonts(FontRegistry aRegistry) {
		fontRegistry = aRegistry;
		registerFonts();
	}

	private void registerFonts() {
		fontRegistry.put(INFO, new FontData[] { new FontData("Arial", 9, SWT.NONE) }); //$NON-NLS-1$
		fontRegistry.put(FIG_CATEGORY, new FontData[] { new FontData("Tahoma", 8, SWT.BOLD) }); //$NON-NLS-1$
		fontRegistry.put(FIG_IMPORT, new FontData[] { new FontData("Tahoma", 7, SWT.NORMAL) }); //$NON-NLS-1$
		fontRegistry.put(FIG_DUP_INDEX, new FontData[] { new FontData("Tahoma", 8, SWT.NORMAL) }); //$NON-NLS-1$
		fontRegistry.put(FIG_NAME, new FontData[] { new FontData("Arial", 8, SWT.NORMAL) }); //$NON-NLS-1$
		fontRegistry.put(LINK_NAME, new FontData[] { new FontData("Arial", 8, SWT.BOLD) }); //$NON-NLS-1$
		fontRegistry.put(FEEDBACK_FIG_NAME, new FontData[] { new FontData(
				"MS Sans Serif", 8, SWT.NORMAL) }); //$NON-NLS-1$
		fontRegistry.put(CONNECTION_LABEL_NAME, new FontData[] { new FontData(
				"Small Fonts", 7, SWT.NORMAL) }); //$NON-NLS-1$
	}

	public Font getFont(String symbolicName) {
		return fontRegistry.get(symbolicName);
	}

	public void putFont(String symbolicName, FontData fontData[]) {
		fontRegistry.put(symbolicName, fontData);
	}
}
