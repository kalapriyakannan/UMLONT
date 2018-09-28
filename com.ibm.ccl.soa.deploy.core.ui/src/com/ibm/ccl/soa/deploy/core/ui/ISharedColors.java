package com.ibm.ccl.soa.deploy.core.ui;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;

public interface ISharedColors {

	public final static String BLACK = "COLOR_BLACK"; //$NON-NLS-1$
	public final static String WHITE = "COLOR WHITE"; //$NON-NLS-1$
	public final static String GHOST_FILL_COLOR = "COLOR_GHOST_FILL"; //$NON-NLS-1$
	public final static String TOOL_TIP_COLOR = "COLOR_TOOL_TIP"; //$NON-NLS-1$

	/**
	 * @param symbolicName
	 * @return Color of preloaded colors
	 */
	public Color getColor(String symbolicName);

	/**
	 * @param symbolicName
	 * @param rgb
	 */
	public void putColor(String symbolicName, RGB rgb);

}
