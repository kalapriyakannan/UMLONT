/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui;

import org.eclipse.swt.graphics.Font;

import com.ibm.ccl.soa.deploy.core.ui.figures.DeployCoreFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployLinkConnection;

/**
 * Provides access to the shared fonts and icons of the Deploy Core UI Plugin.
 * 
 * @since 7.0
 * 
 */
public interface ISharedFonts {

	/**
	 * Information font.
	 */
	String INFO = "INFO"; //$NON-NLS-1$

	/**
	 * The category font for {@link DeployCoreFigure}.
	 */
	String FIG_CATEGORY = "FIG_CATEGORY"; //$NON-NLS-1$

	/**
	 * The import font for {@link DeployCoreFigure}.
	 */
	String FIG_IMPORT = "FIG_IMPORT"; //$NON-NLS-1$

	/**
	 * The duplicate index font for {@link DeployCoreFigure}.
	 */
	String FIG_DUP_INDEX = "FIG_DUP_INDEX"; //$NON-NLS-1$

	/**
	 * The name font for {@link DeployCoreFigure}.
	 */
	String FIG_NAME = "FIG_NAME"; //$NON-NLS-1$

	/**
	 * The name font for {@link DeployLinkConnection}.
	 */
	String LINK_NAME = "LINK_NAME"; //$NON-NLS-1$

	/**
	 * The name font for {feedback figure}.
	 */

	String FEEDBACK_FIG_NAME = "FEEDBACK_FIG_NAME"; //$NON-NLS-1$

	/**
	 * The name font for {link label}.
	 */

	String CONNECTION_LABEL_NAME = "LINK_LABEL_NAME"; //$NON-NLS-1$

	/**
	 * Returns the font associated with the given symbolic font name. Returns the default font if
	 * there is no special value associated with that name.
	 * 
	 * @param symbolicName
	 *           symbolic font name
	 * @return the font
	 */
	Font getFont(String symbolicName);
}
