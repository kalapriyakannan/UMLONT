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

import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.ui.internal.SharedImages;

/**
 * Provides access to the shared images and icons of the Deploy Core UI Plugin.
 */
public interface ISharedImages {

	/**
	 * Arrow down used in context bar of editor.
	 */
	String IMG_ARROW_DOWN = "IMG_ARROW_DOWN"; //$NON-NLS-1$
	/**
	 * Identifies the icon for quickfixes
	 */
	String IMG_ACTN_CORRECTION = "IMG_ACTN_CORRECTION"; //$NON-NLS-1$ 

	/**
	 * Identifies the icon for the synchronize submenu
	 */
	String IMG_ACTN_SYNCHRONIZE = "IMG_ACTN_SYNCHRONIZE"; //$NON-NLS-1$

	/**
	 * Identifies the icon for the synchronize to world action
	 */
	String IMG_ACTN_SYNCHRONIZE_TO_WORLD = "IMG_ACTN_SYNCHRONIZE_TO_WORLD"; //$NON-NLS-1$

	/**
	 * Identifies the icon for the synchronize to model action
	 */
	String IMG_ACTN_SYNCHRONIZE_TO_MODEL = "IMG_ACTN_SYNCHRONIZE_TO_MODEL"; //$NON-NLS-1$

	/**
	 * The {@link INamespaceFragmentRoot} icon.
	 */
	String IMG_TOPOLOGY_NAMESPACE_ROOT = "IMG_TOPOLOGY_NAMESPACE_ROOT"; //$NON-NLS-1$  

	/**
	 * Identifies the icon used for decorating topology projects in the navigator
	 */
	String IMG_TOPOLOGY_PROJECT_OVRLY = "IMG_TOPOLOGY_PROJECT_OVRLY"; //$NON-NLS-1$

	/**
	 * Identifies the icon used for decorating topology projects in the navigator
	 */
	String IMG_REUSABLE_TOPOLOGY_OVRLY = "IMG_REUSABLE_TOPOLOGY_OVRLY"; //$NON-NLS-1$

	/**
	 * Generic Add image
	 */
	String IMG_ADD = "IMG_ADD"; //$NON-NLS-1$
	/**
	 * Generic Delete image
	 */
	String IMG_DELETE = "IMG_DELETE"; //$NON-NLS-1$

	/**
	 * Property pages icons.
	 */

	String IMG_EXPAND_ALL_IMAGE = "EXPAND_ALL_IMAGE"; //$NON-NLS-1$
	String IMG_COLLAPSE_ALL_IMAGE = "COLLAPSE_ALL_IMAGE"; //$NON-NLS-1$
	String IMG_PUBLISH_IMAGE = "PUBLISH_IMAGE"; //$NON-NLS-1$
	String IMG_EXPORT_IMAGE = "EXPORT_IMAGE"; //$NON-NLS-1$
	String IMG_PARENT_IMAGE = "PARENT_IMAGE"; //$NON-NLS-1$
	String IMG_SUCCESS_IMAGE = "SUCCESS_IMAGE"; //$NON-NLS-1$
	String IMG_SEPERATOR_IMAGE = "SEPERATOR_IMAGE"; //$NON-NLS-1$
	String IMG_TOPOLOGY_STATUS = "TOPOLOGY_STATUS_IMAGE"; //$NON-NLS-1$

	/**
	 * Status icons
	 */
	String IMG_ERROR16 = "IMG_ERROR16"; //$NON-NLS-1$
	String IMG_ERROR = "IMG_ERROR"; //$NON-NLS-1$
	String IMG_QUICKFIX_ERROR16 = "IMG_QUICKFIX_ERROR16"; //$NON-NLS-1$
	String IMG_WARNING16 = "IMG_WARNING16"; //$NON-NLS-1$
	String IMG_WARNING = "IMG_WARNING"; //$NON-NLS-1$
	String IMG_QUICKFIX_WARNING16 = "IMG_QUICKFIX_WARNING16"; //$NON-NLS-1$
	String IMG_INFO16 = "IMG_INFO16"; //$NON-NLS-1$
	String IMG_INFO = "IMG_INFO"; //$NON-NLS-1$

	String IMG_DEPENDENT_REQ_MET = "IMG_DEPENDENT_REQ_MET"; //$NON-NLS-1$
	String IMG_DEPENDENT_REQ = "IMG_DEPENDENT_REQ"; //$NON-NLS-1$
	String IMG_MEMBERSHIP = "IMG_MEMBERSHIP"; //$NON-NLS-1$
	String IMG_HOSTING = "IMG_HOSTING"; //$NON-NLS-1$
	String IMG_LINKED_HOSTING = "IMG_LINKED_HOSTING"; //$NON-NLS-1$
	String IMG_DELETE_LINK = "IMG_DELETE_LINK"; //$NON-NLS-1$
	String IMG_DELETE_LINK_DISABLED = "IMG_DELETE_LINK_DISABLED"; //$NON-NLS-1$
	String IMG_DISCOVER_LINK = "IMG_DISCOVER_LINK"; //$NON-NLS-1$
	String IMG_DELETE_REQUIREMENT = "IMG_DELETE_REQUIREMENT"; //$NON-NLS-1$
	String IMG_ADD_REQUIREMENT = "IMG_ADD_REQUIREMENT"; //$NON-NLS-1$
	String IMG_DELETE_REQUIREMENT_DISABLED = "IMG_DELETE_REQUIREMENT_DISABLED"; //$NON-NLS-1$
	String IMG_ADD_REQUIREMENT_DISABLED = "IMG_ADD_REQUIREMENT_DISABLED"; //$NON-NLS-1$
	String IMG_DEPENDENCY_LINK_TYPE = "IMG_DEPENDENCY_LINK_TYPE"; //$NON-NLS-1$
	String IMG_MEMBERSHIP_LINK_TYPE = "IMG_MEMBERSHIP_LINK_TYPE"; //$NON-NLS-1$
	String IMG_HOSTING_LINK_TYPE = "IMG_HOSTING_LINK_TYPE"; //$NON-NLS-1$
	String IMG_DELETE_REQ_EXPRESSION = IMG_DELETE;
	String IMG_ADD_REQ_EXPRESSION = IMG_ADD;
	String IMG_CONSTRAINT_LINK_TYPE = "IMG_CONSTRAINT_LINK_TYPE"; //$NON-NLS-1$
	String IMG_REALIZATION_LINK_TYPE = "IMG_REALIZATION_LINK_TYPE"; //$NON-NLS-1$

	String IMG_LINK_ARROW = "IMG_LINK_ARROW"; //$NON-NLS-1$	

	String IMG_BOUND_STATE = "IMG_BOUND_STATE"; //$NON-NLS-1$

	/**
	 * Topology editor overlay for default contract status of all units public
	 */
	String IMG_DEFAULT_CONTRACT_ALL_PUBLIC = "IMG_DEFAULT_CONTRACT_ALL_PUBLIC"; //$NON-NLS-1$
	/**
	 * Topology editor overlay for default contract status of all conceptual units public
	 */
	String IMG_DEFAULT_CONTRACT_ALL_CONCEPTUAL_PUBLIC = "IMG_DEFAULT_CONTRACT_ALL_CONCEPTUAL_PUBLIC"; //$NON-NLS-1$
	/**
	 * Topology editor overlay for default contract status of all units private
	 */
	String IMG_DEFAULT_CONTRACT_ALL_PRIVATE = "IMG_DEFAULT_CONTRACT_ALL_PRIVATE"; //$NON-NLS-1$

	/**
	 * Contract constant for Public
	 */
	String IMG_CONTRACT_PUBLIC = "IMG_CONTRACT_PUBLIC"; //$NON-NLS-1$
	/**
	 * Contract constant for Public-Editable
	 */
	String IMG_CONTRACT_PUBLIC_EDITABLE = "IMG_CONTRACT_PUBLIC_EDITABLE"; //$NON-NLS-1$
	/**
	 * Contract constant for Private
	 */
	String IMG_CONTRACT_PRIVATE = "IMG_CONTRACT_PRIVATE"; //$NON-NLS-1$
	/**
	 * Contract constant for Private with public attributes
	 */
	String IMG_CONTRACT_PRIVATE_WITH_PUBLIC = "IMG_CONTRACT_PRIVATE_WITH_PUBLIC"; //$NON-NLS-1$

	//Images for Install States
	String IMG_NO_ATTRIBUTES = "IMG_NO_ATTRIBUTES"; //$NON-NLS-1$

	//Images for Install States
	String IMG_UNINSTALL_INSTALL = "IMG_UNINSTALL_INSTALL"; //$NON-NLS-1$
	String IMG_INSTALL_UNINSTALL = "IMG_INSTALL_UNINSTALL"; //$NON-NLS-1$
	String IMG_UNKNOWN_INSTALL = "IMG_UKNOWN_INSTALL"; //$NON-NLS-1$
	String IMG_UNKNOWN_UNINSTALL = "IMG_UKNOWN_UNINSTALL"; //$NON-NLS-1$
	String IMG_INSTALLED = "IMG_INSTALLED"; //$NON-NLS-1$
	String IMG_UNINSTALLED = "IMG_UNINSTALLED"; //$NON-NLS-1$
	String IMG_INSTALLED_UNKNOWN = "IMG_INSTALLED_UNKNOWN"; //$NON-NLS-1$
	String IMG_UNINSTALLED_UNKNOWN = "IMG_UNINSTALLED_UNKNOWN"; //$NON-NLS-1$

	//Images for toggle conceptual action
	String IMG_CONCEPTUAL = "IMG_CONCEPTUAL"; //$NON-NLS-1$
	String IMG_NON_CONCEPTUAL = "IMG_NON_CONCEPTUAL"; //$NON-NLS-1$

	/**
	 * Required usage image.
	 */
	String IMG_USE_REQUIRED = "IMG_USE_REQUIRED"; //$NON-NLS-1$
	/**
	 * Optional usage image.
	 */
	String IMG_USE_OPTIONAL = "IMG_USE_OPTIONAL"; //$NON-NLS-1$
	/**
	 * Prohibited usage image.
	 */
	String IMG_USE_PROHIBITED = "IMG_USE_PROHIBITED"; //$NON-NLS-1$

	/**
	 * Topology Wizard Banner
	 */
	String IMG_TOP_WIZ_BAN = "IMG_TOP_WIZ_BAN";//$NON-NLS-1$

	/**
	 * The icon used for the "Publish" attribute in a Figure.
	 */
	String IMAGE_PUBLISH_ATTRIBUTE = "IMAGE_PUBLISH_ATTRIBUTE"; //$NON-NLS-1$

	/**
	 * The icon used to to add a Capability
	 */
	String IMG_ADD_CAPABILITY = "IMAGE_ADD_CAPABILITY"; //$NON-NLS-1$

	/**
	 * The icon used to to edit extended attributes and change attribute contract visibility
	 */
	String IMG_EDIT_ATTRIBUTES = "IMAGE_EDIT_ATTRIBUTES"; //$NON-NLS-1$

	/**
	 * The collapse all icon for toolbar/menu
	 */
	String IMG_TOOL_COLLAPSE_ALL = "IMAGE_TOOL_COLLAPSE_ALL"; //$NON-NLS-1$

//	/**
//	 * The expand all icon for toolbar/menu
//	 */
//	String IMG_TOOL_EXPAND_ALL = "IMAGE_TOOL_EXPAND_ALL"; //$NON-NLS-1$

	/**
	 * The expand all icon for toolbar/menu
	 */
	String IMG_TOOL_EXPAND_ALL_LCL = "IMG_TOOL_EXPAND_ALL_LCL"; //$NON-NLS-1$
	/**
	 * The disabled expand all icon for toolbar/menu
	 */
	String IMG_TOOL_EXPAND_ALL_LCL_DISABLED = "IMG_TOOL_EXPAND_ALL_LCL_DISABLED"; //$NON-NLS-1$
	/**
	 * The collapse all icon for toolbar/menu
	 */
	String IMG_TOOL_COLLAPSE_ALL_LCL = "IMG_TOOL_COLLAPSE_ALL_LCL"; //$NON-NLS-1$
	/**
	 * The disabled collapse all icon for toolbar/menu
	 */
	String IMG_TOOL_COLLAPSE_ALL_LCL_DISABLED = "IMG_TOOL_COLLAPSE_ALL_LCL_DISABLED"; //$NON-NLS-1$

	/**
	 * The collapse all icon for toolbar/menu
	 */
	String IMG_TOOL_COLLAPSE_ALL_DISABLED = "IMAGE_TOOL_COLLAPSE_ALL_DISABLED"; //$NON-NLS-1$

	/**
	 * The collapse selected icon for toolbar/menu
	 */
	String IMG_TOOL_COLLAPSE_SELECTED = "IMAGE_TOOL_COLLAPSE_SELECTED"; //$NON-NLS-1$

	/**
	 * The collapse selected icon for toolbar/menu
	 */
	String IMG_TOOL_COLLAPSE_SELECTED_DISABLED = "IMAGE_TOOL_COLLAPSE_SELECTED_DISABLED"; //$NON-NLS-1$

	/**
	 * the decorators at the ends of link lines
	 */
	String IMG_REALIZATION_TARGET_DECORATOR = "IMG_REALIZATION_TARGET_DECORATOR"; //$NON-NLS-1$

	/**
	 * diagram preferences actions
	 */
	String IMG_TOOL_DIAGRAM_PREFERENCES = "IMG_TOOL_DIAGRAM_PREFERENCES";//$NON-NLS-1$

	/**
	 * overlay type icon with member arrow
	 */
	String IMG_MEMBER_ICON_OVERLAY = "IMG_TOOL_MEMBER_ICON_OVERLAY";//$NON-NLS-1$

	/**
	 * overlay type icon with member arrow
	 */
	String IMG_HOSTEE_ICON_OVERLAY = "IMG_TOOL_HOSTEE_ICON_OVERLAY";//$NON-NLS-1$

	/**
	 * overlay type icon with member arrow
	 */
	String IMG_DEFERREDHOSTEE_ICON_OVERLAY = "IMG_TOOL_DEFERREDHOSTEE_ICON_OVERLAY";//$NON-NLS-1$

	/**
	 * The group context menu icon
	 */
	final String IMG_GROUP_ICON = "IMG_GROUP_ICON"; //$NON-NLS-1$

	/**
	 * One of a series of icons that emulate animation in the Navigator.
	 */
	String IMG_LOADING_MODEL_NODE_1 = "IMG_LOADING_MODEL_NODE_1"; //$NON-NLS-1$	

	/**
	 * One of a series of icons that emulate animation in the Navigator.
	 */
	String IMG_LOADING_MODEL_NODE_2 = "IMG_LOADING_MODEL_NODE_2"; //$NON-NLS-1$

	/**
	 * One of a series of icons that emulate animation in the Navigator.
	 */
	String IMG_LOADING_MODEL_NODE_3 = "IMG_LOADING_MODEL_NODE_3"; //$NON-NLS-1$

	/**
	 * One of a series of icons that emulate animation in the Navigator.
	 */
	String IMG_LOADING_MODEL_NODE_4 = "IMG_LOADING_MODEL_NODE_4"; //$NON-NLS-1$

	/**
	 * Icon for Diagrams underneath topology model (same as uml icon)
	 */
	String IMG_TOPOLOGY_DIAGRAM_NODE = "IMG_TOPOLOGY_DIAGRAM_NODE"; //$NON-NLS-1$

	/**
	 * Icon for the drop down toolbar menus.
	 */
	String IMG_DROP_DOWN_MENU = "IMG_DROP_DOWN_MENU"; //$NON-NLS-1$

	String IMG_EDIT_REQUIREMENT = "IMG_EDIT_REQUIREMENT"; //$NON-NLS-1$
	String IMG_EDIT_CAPABILITY = "IMG_EDIT_CAPABILITY"; //$NON-NLS-1$
	String IMG_DELETE_CAPABILITY = "IMG_DELETE_CAPABILITY"; //$NON-NLS-1$

	String IMG_ADD_MATCHING_CAPABILITY = "IMAGE_ADD_MATCHING_CAPABILITY"; //$NON-NLS-1$
	String IMG_ADD_MATCHING_REQUIREMENT = "IMAGE_ADD_MATCHING_REQUIREMENT"; //$NON-NLS-1$
	String IMG_ADD_CAPABILTITY_AND_REQUIREMENT = "IMAGE_ADD_CAPABILTITY_AND_REQUIREMENT"; //$NON-NLS-1$

	String IMG_CONSTRAINT = "IMAGE_CONSTRAINT"; //$NON-NLS-1$

	//Enabled Add child constraint icon
	String IMG_ADD_CHILD_CONSTRAINT = "IMG_ADD_CHILD_CONSTRAINT"; //$NON-NLS-1$
	//Disabled Add child constraint icon
	String IMG_ADD_CHILD_CONSTRAINT_DIS = "IMG_ADD_CHILD_CONSTRAINT_DIS"; //$NON-NLS-1$

	/**
	 * Create instances of {@link ISharedImages} for use in managing re-used images.
	 * 
	 */
	public class Factory {

		/**
		 * Create an instance of {@link ISharedImages} to manage images in the {@link ImageRegistry}
		 * of the given bundle.
		 * 
		 * @param managingBundle
		 *           A bundle with a valid ImageRegistry
		 * @return An instance of {@link ISharedImages} to manage images in the {@link ImageRegistry}
		 */
		public static ISharedImages createSharedImages(AbstractUIPlugin managingBundle) {
			return new SharedImages(managingBundle.getBundle().getSymbolicName(), managingBundle
					.getImageRegistry());
		}

		/**
		 * Create an instance of {@link ISharedImages} that can maintain extra images outside of the
		 * parent. The child will check the parent for a shared image, if available. The child can be
		 * disposed without affecting the parent.
		 * 
		 * @param parent
		 *           A bundle with a valid ImageRegistry
		 * @return An instance of {@link ISharedImages} to manage images in the {@link ImageRegistry}
		 */
		public static ISharedImages createSharedImages(ISharedImages parent) {
			return new SharedImages(parent);
		}
	}

	/**
	 * Retrieves the specified image from the workbench plugin's image registry. Note: The returned
	 * <code>Image</code> is managed by the workbench; clients must <b>not</b> dispose of the
	 * returned image.
	 * 
	 * @param symbolicName
	 *           the symbolic name of the image; there are constants declared in this interface for
	 *           build-in images that come with the workbench
	 * @return the image, or <code>null</code> if not found
	 */
	public Image getImage(String symbolicName);

	/**
	 * Retrieves the specified image from the workbench plugin's image registry. Note: The returned
	 * <code>Image</code> is managed by the workbench; clients must <b>not</b> dispose of the
	 * returned image.
	 * 
	 * @param symbolicName
	 *           the symbolic name of the image; there are constants declared in this interface for
	 *           build-in images that come with the workbench
	 * @return the image, or <code>null</code> if not found
	 */
	public Image getImage(String symbolicName, boolean enabled);

	/**
	 * Retrieves the specified image from the workbench plugin's image registry. Note: The returned
	 * <code>Image</code> is managed by the workbench; clients must <b>not</b> dispose of the
	 * returned image.
	 * 
	 * 
	 * @param imageURL
	 *           A URL that points to the interesting image.
	 * @return the image descriptor, or <code>null</code> if not found
	 */
	public Image getImage(URL imageURL);

	/**
	 * Retrieves the specified image from the workbench plugin's image registry. Note: The returned
	 * <code>Image</code> is managed by the workbench; clients must <b>not</b> dispose of the
	 * returned image.
	 * 
	 * 
	 * @param descriptor
	 *           An ImageDescriptor for the desired image.
	 * @return the image descriptor, or <code>null</code> if not found
	 */
	public Image getImage(ImageDescriptor descriptor);

	/**
	 * Retrieves the image descriptor for specified image from the workbench's image registry. Unlike
	 * <code>Image</code>s, image descriptors themselves do not need to be disposed.
	 * 
	 * @param symbolicName
	 *           the symbolic name of the image; there are constants declared in this interface for
	 *           build-in images that come with the workbench
	 * @return the image descriptor, or <code>null</code> if not found
	 */
	public ImageDescriptor getImageDescriptor(String symbolicName);

	/**
	 * Retrieves the image descriptor for specified image from the workbench's image registry. Unlike
	 * <code>Image</code>s, image descriptors themselves do not need to be disposed.
	 * 
	 * @param imageURL
	 *           A URL that points to the interesting image.
	 * @return the image descriptor, or <code>null</code> if not found
	 */
	public ImageDescriptor getImageDescriptor(URL imageURL);

	/**
	 * Return a cached image from the given path
	 * 
	 * @param path
	 *           The plugin-relative path for the image.
	 * @return The image from the path
	 */
	public Image getImageFromPath(String path);

	/**
	 * Return a cached image from the given path
	 * 
	 * @param path
	 *           The plugin-relative path for the image.
	 * @return The image from the path
	 */
	public Image getImageFromPath(String path, boolean enabled);

	/**
	 * Dispose of any loaded resources.
	 */
	public void dispose();
}
