/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.util;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;

/**
 * code copied from real logic example in gef
 */
/*
 * @canBeSeenBy com.ibm.xtools.diagram.ui.examples.logic.*
 */
public class DeployColorConstants {

	public static final String RGB_LIGHT_BLUE = "RGB_LIGHT_BLUE"; //$NON-NLS-1$
	public static final String RGB_BLUE_FOR_STROKE = "RGB_BLUE_FOR_STROKE"; //$NON-NLS-1$
	public static final String RGB_BLUE_FOR_FILL = "RGB_BLUE_FOR_FILL"; //$NON-NLS-1$
	public static final String RGB_BLUE = "RGB_BLUE"; //$NON-NLS-1$

	public static final String GHOST_FILL_COLOR = "GHOST_FILL"; //$NON-NLS-1$
	public static final String TOOL_TIP_COLOR = "TOOL_TIP_COLOR"; //$NON-NLS-1$
	public static final String GHOST_LINE_COLOR = "GHOST_LINE_COLOR"; //$NON-NLS-1$

	public static final String BG_SHAPE_CONTAINTER = "BG_SHAPE_CONTAINTER";//$NON-NLS-1$
	public static final String BG_DIAGRAM = "BG_DIAGRAM"; //$NON-NLS-1$
	public static final String FG_DIAGRAM = "FG_DIAGRAM"; //$NON-NLS-1$

	public final static Color black = new Color(null, 0, 0, 0);
	public final static Color white = new Color(null, 255, 255, 255);
	public final static Color lightYellow = new Color(null, 255, 255, 170);
	public final static Color lightGray = new Color(null, 240, 240, 245);

	/*
	 * figure colors
	 */
	public static final Color appGradiantFill = new Color(Display.getDefault(), 229, 232, 237);
	public static final Color appOutline = new Color(Display.getDefault(), 170, 170, 170);
	public static final Color appTitleBar = new Color(Display.getDefault(), 217, 213, 212);
	public static final Color categoryColor = new Color(Display.getDefault(), 128, 128, 160);
	public static final Color dbGradiantFill1 = new Color(Display.getDefault(), 217, 217, 217);
	public static final Color dbGradiantFill2 = new Color(Display.getDefault(), 234, 240, 243);
	public static final Color dbOutline = new Color(Display.getDefault(), 176, 176, 184);
	public static final Color osOutline = new Color(Display.getDefault(), 184, 184, 184);
	public static final Color osGradiantFill1 = new Color(Display.getDefault(), 240, 240, 240);
	public static final Color osGradiantFill2 = new Color(Display.getDefault(), 208, 208, 208);
	public static final Color srvrGradiantFill = new Color(Display.getDefault(), 234, 235, 239);
	public static final Color srvrOutline = new Color(Display.getDefault(), 168, 177, 184);
	public static final Color sqlOutline = new Color(Display.getDefault(), 160, 160, 160);
	public static final Color sqlFill1 = new Color(Display.getDefault(), 240, 240, 248);
	public static final Color sqlFill2 = new Color(Display.getDefault(), 200, 200, 192);
	public static final Color sqlFill3 = new Color(Display.getDefault(), 224, 224, 224);
	public static final Color unitCollection = new Color(Display.getDefault(), 102, 102, 212);
	public static final Color grpFillColor = new Color(Display.getDefault(), 216, 216, 216);
	public static final Color grpFillColor2 = new Color(Display.getDefault(), 240, 240, 240);
	public static final Color overlapShadow = new Color(null, 83, 86, 101);
	public static final Color groupCompartmentGray = new Color(null, 168, 168, 168);
	public static final Color importTopologyBorder1 = new Color(Display.getDefault(), 171, 169, 154);
	public static final Color importTopologyBorder2 = new Color(Display.getDefault(), 211, 212, 204);
	public static final Color importTopologyFill = new Color(Display.getDefault(), 238, 238, 236);
	public static final Color diagramNodeBorder = new Color(Display.getDefault(), 181, 179, 164);
	public static final Color diagramNodeFill = new Color(Display.getDefault(), 240, 240, 255);
	public static final Color imprtDiagramNodeBorder = new Color(Display.getDefault(), 171, 169, 154);
	public static final Color imprtDiagramNodeFill = new Color(Display.getDefault(), 210, 230, 230);

	/*
	 * business figure colors
	 */
	public static final Color nodeComponentConcept = new Color(Display.getDefault(), 204, 153, 102);
	public static final Color nodeComponentBorder1 = new Color(Display.getDefault(), 250, 196, 88);
	public static final Color nodeComponentBorder2 = new Color(Display.getDefault(), 253, 226, 172);
	public static final Color nodeComponentFill = new Color(Display.getDefault(), 255, 255, 204);
	public static final Color softComponentFill1 = new Color(Display.getDefault(), 229, 235, 247);
	public static final Color softComponentFill2 = new Color(Display.getDefault(), 197, 208, 236);
	public static final Color softComponentFillc1 = new Color(Display.getDefault(), 242, 245, 252);
	public static final Color softComponentFillc2 = new Color(Display.getDefault(), 227, 232, 246);
	public static final Color softComponentBorder = new Color(Display.getDefault(), 97, 122, 202);
	public static final Color softComponentConcept = new Color(Display.getDefault(), 97, 122, 202);
	public static final Color dataComponentFill1 = new Color(Display.getDefault(), 234, 248, 233);
	public static final Color dataComponentFill2 = new Color(Display.getDefault(), 215, 248, 215);
	public static final Color dataComponentFillc1 = new Color(Display.getDefault(), 245, 252, 244);
	public static final Color dataComponentFillc2 = new Color(Display.getDefault(), 235, 252, 235);
	public static final Color dataComponentBorder = new Color(Display.getDefault(), 102, 153, 102);
	public static final Color dataComponentConcept = new Color(Display.getDefault(), 148, 216, 148);
	public static final Color webComponentFill1 = new Color(Display.getDefault(), 247, 238, 238);
	public static final Color webComponentFill2 = new Color(Display.getDefault(), 243, 220, 220);
	public static final Color webComponentFillc1 = new Color(Display.getDefault(), 247, 239, 239);
	public static final Color webComponentFillc2 = new Color(Display.getDefault(), 249, 238, 238);
	public static final Color webComponentBorder = new Color(Display.getDefault(), 205, 155, 155);
	public static final Color webComponentConcept = new Color(Display.getDefault(), 205, 155, 155);

	public static final Color earComponentFill1 = new Color(Display.getDefault(), 237, 237, 219);
	public static final Color earComponentFill2 = new Color(Display.getDefault(), 214, 214, 173);
	public static final Color earComponentFillc1 = new Color(Display.getDefault(), 246, 246, 237);
	public static final Color earComponentFillc2 = new Color(Display.getDefault(), 234, 234, 214);
	public static final Color earComponentBorder = new Color(Display.getDefault(), 128, 128, 0);
	public static final Color earComponentConcept = new Color(Display.getDefault(), 191, 191, 127);

	public static final Color ejbComponentFill1 = new Color(Display.getDefault(), 239, 223, 239);
	public static final Color ejbComponentFill2 = new Color(Display.getDefault(), 213, 170, 213);
	public static final Color ejbComponentFillc1 = new Color(Display.getDefault(), 246, 237, 246);
	public static final Color ejbComponentFillc2 = new Color(Display.getDefault(), 232, 208, 232);
	public static final Color ejbComponentBorder = new Color(Display.getDefault(), 128, 0, 128);
	public static final Color ejbComponentConcept = new Color(Display.getDefault(), 179, 102, 179);

	public static final Color utilComponentFill1 = new Color(Display.getDefault(), 221, 238, 238);
	public static final Color utilComponentFill2 = new Color(Display.getDefault(), 164, 209, 209);
	public static final Color utilComponentFillc1 = new Color(Display.getDefault(), 235, 245, 245);
	public static final Color utilComponentFillc2 = new Color(Display.getDefault(), 200, 227, 227);
	public static final Color utilComponentBorder = new Color(Display.getDefault(), 0, 128, 128);
	public static final Color utilComponentConcept = new Color(Display.getDefault(), 102, 179, 179);

	// color for selected and associated figures & links
	public static final Color selectedInner = new Color(null, 150, 179, 224);
	public static final Color selectedOuter = new Color(null, 49, 106, 197);
	public static final Color associatedInner = new Color(null, 187, 212, 162);
	public static final Color associatedOuter = new Color(null, 145, 189, 111);
	public static final Color hiliteInner = new Color(null, 253, 226, 172);
	public static final Color hiliteOuter = new Color(null, 250, 196, 88);
	public static final Color dupInner = new Color(null, 50, 230, 210);
	public static final Color dupOuter = new Color(null, 50, 205, 195);

	/*
	 * link colors
	 */
	public static final Color hostingLinkColor = new Color(Display.getDefault(), 184, 184, 184);
	public static final Color hostingLinkInner = new Color(Display.getDefault(), 248, 248, 208);
	public static final Color dependencyLinkColor = new Color(Display.getDefault(), 152, 152, 144);
	public static final Color realizationLinkColor = new Color(Display.getDefault(), 193, 193, 193);
	public static final Color realizationLinkInner = new Color(Display.getDefault(), 128, 128, 128);
	public static final Color logicalLinkColor = new Color(Display.getDefault(), 152, 152, 144);
	public static final Color consolidationLinkColor = new Color(Display.getDefault(), 100, 100, 128);
	public static final Color borderLineColor = new Color(Display.getDefault(), 0, 127, 0);
	/**
	 * Color for connections from Units to hidden/filtered units
	 */
	public static final Color filterSurrogateLinkColor = new Color(Display.getDefault(), 128, 0, 128);

	public static final Color tooltipColor = new Color(Display.getDefault(), 192, 192, 212);
	public static final Color enabledTextColor = new Color(Display.getDefault(), 0, 0, 0);
	public static final Color disabledTextColor = new Color(Display.getDefault(), 128, 128, 128);
	public static final Color detachedError = new Color(Display.getDefault(), 255, 32, 32);
	public static final Color detachedBkdError = new Color(Display.getDefault(), 255, 200, 200);
	public static final Color select = new Color(Display.getDefault(), 54, 186, 255);
	public static final Color category = new Color(null, 100, 100, 140);
	public static final Color gray = new Color(null, 128, 128, 128);
	public static final Color orange = new Color(null, 255, 196, 0);
	public static final Color importLabel = new Color(null, 130, 60, 140);

	public static final Color colorLightBlue = ColorUtils
			.getRelativeColor(getSystemColor(RGB_LIGHT_BLUE));

	public static final Color colorBlueForStroke = ColorUtils
			.getRelativeColor(getSystemColor(RGB_BLUE_FOR_STROKE));

	public static final Color colorBlueForFill = ColorUtils
			.getRelativeColor(getSystemColor(RGB_BLUE_FOR_FILL));

	private static Color getSystemColor(String color) {
		return DeployCoreUIPlugin.getDefault().getColorRegistry().get(color);
	}

}
