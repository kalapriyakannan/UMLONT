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

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;

/**
 * Provides constant Images for DeployCoreUIPlugin .gif files.
 * 
 * @since 1.0
 */
public class DeployCoreImages {
	// cursors
	public static final Image ADDSHAPE_POINTER = createImage("icons/cursors/addshape_pointer.bmp"); //$NON-NLS-1$
	public static final Image ADDSHAPE_MASKS = createImage("icons/cursors/addshape_masks.bmp"); //$NON-NLS-1$
	public static final Cursor ADDSHAPE_CURSOR = new Cursor(Display.getDefault(), ADDSHAPE_POINTER
			.getImageData(), ADDSHAPE_MASKS.getImageData(), 0, 0);
	public static final Image CONNECTCURSOR_SOURCE = createImage("icons/cursors/connectcursor_source.bmp"); //$NON-NLS-1$
	public static final Image CONNECTCURSOR_MASK = createImage("icons/cursors/connectcursor_mask.bmp"); //$NON-NLS-1$
	public static final Cursor CONNECT_CURSOR = new Cursor(Display.getDefault(),
			CONNECTCURSOR_SOURCE.getImageData(), CONNECTCURSOR_MASK.getImageData(), 0, 0);

	public static final Image ZOOM_TOOL_PLUS = createImage("icons/dgm/zoomplus.gif"); //$NON-NLS-1$
	public static final Image ZOOM_TOOL_MINUS = createImage("icons/dgm/zoomminus.gif"); //$NON-NLS-1$
	public static final Cursor ZOOM_TOOL_PLUS_CURSOR = new Cursor(null, ZOOM_TOOL_PLUS
			.getImageData(), 0, 0);
	public static final Cursor ZOOM_TOOL_MINUS_CURSOR = new Cursor(null, ZOOM_TOOL_MINUS
			.getImageData(), 0, 0);

	// images
	public static final Image CONSUMEHOSTLOLLY__IMAGE = createImage("icons/handles/host_grabby_bttm.gif"); //$NON-NLS-1$
	public static final Image CONSUMESERVICELOLLY__IMAGE = createImage("icons/handles/dependency_grabby_right.gif"); //$NON-NLS-1$
	public static final Image CONSUMESERVICELOLLY__LEFTIMAGE = createImage("icons/handles/dependency_grabby_left.gif"); //$NON-NLS-1$
	public static final Image CONSUMEREALIZATIONLOLLY__IMAGE = createImage("icons/handles/realize_grabby_bttm.gif"); //$NON-NLS-1$
	public static final Image CONSTRAINTLOLLY__IMAGE = createImage("icons/handles/constraint_grabby_crnr.gif"); //$NON-NLS-1$

	public static final Image UNIT__IMAGE = createImage("icons/images/node_dgm.gif"); //$NON-NLS-1$

	public static final Image IMAGE_HOVER_TOP = createImage("icons/misc/hovertop_misc.gif"); //$NON-NLS-1$
	public static final Image IMAGE_HOVER_LEFT = createImage("icons/misc/hoverleft_misc.gif"); //$NON-NLS-1$

	public static final Image IMAGE_HOVER_TOP_LEFT = createImage("icons/misc/hovertopleft_misc.gif"); //$NON-NLS-1$
	public static final Image IMAGE_HOVER_BOTTOM_LEFT = createImage("icons/misc/hoverbotleft_misc.gif"); //$NON-NLS-1$

	public static final Image IMAGE_SELECT_TOP = createImage("icons/misc/selecttop_misc.gif"); //$NON-NLS-1$
	public static final Image IMAGE_SELECT_LEFT = createImage("icons/misc/selectleft_misc.gif"); //$NON-NLS-1$
	public static final Image IMAGE_SELECT_TOP_LEFT = createImage("icons/misc/selecttopleft_misc.gif"); //$NON-NLS-1$
	public static final Image IMAGE_SELECT_BOTTOM_LEFT = createImage("icons/misc/selectbotleft_misc.gif"); //$NON-NLS-1$
	public static final Image ICON_INFO = createImage("icons/obj16/info_obj.gif"); //$NON-NLS-1$

	public static final Image ICON_ERROR_CIRCLE = createImage("icons/dgm/error_info_dgm.gif"); //$NON-NLS-1$
	public static final Image ICON_SEARCH_CIRCLE = createImage("icons/dgm/search_info_dgm.gif"); //$NON-NLS-1$
	public static final Image ICON_SUCCESS_CIRCLE = createImage("icons/dgm/success_info_dgm.gif"); //$NON-NLS-1$
	public static final Image ICON_CREATE_CIRCLE = createImage("icons/dgm/create_info_dgm.gif"); //$NON-NLS-1$;

	public static final Image IMAGE_UNIT_GROUP_COLLAPSED = createImage("icons/misc/unitGroupCollapsed.gif"); //$NON-NLS-1$
	public static final Image IMAGE_PROHIBIT_FEEDBACK = createImage("icons/misc/prohibitFeedback.gif"); //$NON-NLS-1$

	public static final Image IMAGE_COLLAPSED_HOSTLIST = createImage("icons/misc/collapsed.gif"); //$NON-NLS-1$
	public static final Image IMAGE_EXPANDED_HOSTLIST = createImage("icons/misc/expanded.gif"); //$NON-NLS-1$

	public static final Image IMAGE_PLUS_SIGN = createImage("icons/misc/plus_sign.gif"); //$NON-NLS-1$
	public static final Image IMAGE_MINUS_SIGN = createImage("icons/misc/minus_sign.gif"); //$NON-NLS-1$

	public static final Image IMAGE_INSTALLED_ATTRIBUTE = createImage("icons/obj16/installed_obj.gif"); //$NON-NLS-1$
	public static final Image IMAGE_PUBLISH_ATTRIBUTE = createImage("icons/obj16/publish_obj.gif"); //$NON-NLS-1$

	// business images
	public static final Image CAPABILITY_IMAGE = createImage("icons/dgm/capability_multi_dgm.gif"); //$NON-NLS-1$
	public static final Image REQUIREMENT_IMAGE = createImage("icons/dgm/requirement_multi_dgm.gif"); //$NON-NLS-1$
	public static final Image IMPORTPROXY_IMAGE = createImage("icons/dgm/importproxy.gif"); //$NON-NLS-1$

	//	/**
	//	 * Image representing filtered units
	//	 */
	//	public static final Image FILTERSURROGATEHUB__IMAGE = createImage("icons/dgm/hub.gif");  //$NON-NLS-1$

	private static Image createImage(String path) {
		return DeployCoreUIPlugin.getImageDescriptor(path).createImage();
	}

	public static ImageDescriptor IMAGE_CLEAR_STATUS = DeployCoreUIPlugin
			.getImageDescriptor("icons/elcl16/clear_errors.gif"); //$NON-NLS-1$
	public static ImageDescriptor IMAGE_CLEAR_STATUS_D = DeployCoreUIPlugin
			.getImageDescriptor("icons/dlcl16/clear_errors.gif"); //$NON-NLS-1$
	public static ImageDescriptor IMAGE_SHOW_DETAILS = DeployCoreUIPlugin
			.getImageDescriptor("icons/elcl16/shwdetails.gif"); //$NON-NLS-1$
	public static ImageDescriptor IMAGE_SHOW_DETAILS_D = DeployCoreUIPlugin
			.getImageDescriptor("icons/dlcl16/shwdetails.gif"); //$NON-NLS-1$

	public static ImageDescriptor IMAGE_SORT = DeployCoreUIPlugin
			.getImageDescriptor("icons/elcl16/sort.gif");//$NON-NLS-1$

	public static ImageDescriptor IMAGE_GROUPBY = DeployCoreUIPlugin
			.getImageDescriptor("icons/elcl16/groupby.gif"); //$NON-NLS-1$
	public static ImageDescriptor IMAGE_GROUPBY_D = DeployCoreUIPlugin
			.getImageDescriptor("icons/dlcl16/groupby.gif"); //$NON-NLS-1$
	public static ImageDescriptor IMAGE_SUBVIEW = DeployCoreUIPlugin
			.getImageDescriptor("icons/elcl16/errors.gif"); //$NON-NLS-1$
	public static ImageDescriptor IMAGE_CONFIG_FILTER = DeployCoreUIPlugin
			.getImageDescriptor("icons/elcl16/config_filters.gif"); //$NON-NLS-1$
	public static ImageDescriptor IMAGE_CONFIG_FILTER_D = DeployCoreUIPlugin
			.getImageDescriptor("icons/dlcl16/config_filters.gif"); //$NON-NLS-1$
	public static ImageDescriptor IMAGE_SELECT_FILTER = DeployCoreUIPlugin
			.getImageDescriptor("icons/elcl16/filter.gif"); //$NON-NLS-1$
	public static ImageDescriptor IMAGE_SELECT_FILTER_D = DeployCoreUIPlugin
			.getImageDescriptor("icons/dlcl16/filter.gif"); //$NON-NLS-1$

	public static final ImageDescriptor IMAGEDSC_ADD_CONFIG_UNIT_MENU = DeployCoreUIPlugin
			.getImageDescriptor("icons/etool16/dply_topology_wiz.gif"); //$NON-NLS-1$

	/**
	 * Images relating to group context menus/actions
	 */
	public static final ImageDescriptor IMAGEDSC_ADD_TO_GRP = DeployCoreUIPlugin
			.getImageDescriptor("icons/elcl16/add.gif"); //$NON-NLS-1$
	public static final ImageDescriptor IMAGEDSC_ADD_TO_NEW_GRP = DeployCoreUIPlugin
			.getImageDescriptor("icons/elcl16/add_new_grp.gif"); //$NON-NLS-1$
	public static final ImageDescriptor IMAGEDSC_MOVE_TO_MENU = DeployCoreUIPlugin
			.getImageDescriptor("icons/elcl16/moveto.gif"); //$NON-NLS-1$
	public static final ImageDescriptor IMAGEDSC_REMOVE_FROM_MENU = DeployCoreUIPlugin
			.getImageDescriptor("icons/elcl16/remove.gif"); //$NON-NLS-1$
	public static final ImageDescriptor IMAGEDSC_REMOVE_FROM_CURRENT_GRP = DeployCoreUIPlugin
			.getImageDescriptor("icons/elcl16/rmv_current_grp.gif"); //$NON-NLS-1$
	public static final ImageDescriptor IMAGEDSC_REMOVE_FROM_ALL_GRP = DeployCoreUIPlugin
			.getImageDescriptor("icons/elcl16/rmv_all_grp.gif"); //$NON-NLS-1$

	public static Image IMAGE_ERROR_TBL = createImage("icons/obj16/error_tbl.gif"); //$NON-NLS-1$
	public static Image IMAGE_INFO_TBL = createImage("icons/obj16/info_tbl.gif"); //$NON-NLS-1$
	public static Image IMAGE_WARNING_TBL = createImage("icons/obj16/warn_tbl.gif"); //$NON-NLS-1$
	public static Image IMAGE_CATEGORY_TBL = createImage("icons/obj16/layout_hier.gif"); //$NON-NLS-1$

	/** Error icon with quickfix indication */
	public static Image IMAGE_ERROR_TBL_QUICKFIX = createImage("icons/obj16/quickfix_error_obj16.gif"); //$NON-NLS-1$
	/** Warning icon with quickfix indication */
	public static Image IMAGE_WARNING_TBL_QUICKFIX = createImage("icons/obj16/quickfix_warning_obj.gif"); //$NON-NLS-1$
}
