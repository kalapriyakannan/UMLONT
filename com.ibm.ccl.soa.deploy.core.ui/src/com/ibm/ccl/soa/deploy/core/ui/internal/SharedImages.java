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

import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;

public class SharedImages implements ISharedImages {

	public final static String ICONS_PATH = "icons/";//$NON-NLS-1$

	public final static String ICONS_FULL_PATH = "icons/full/";//$NON-NLS-1$

	private final static String PATH_FULL_OBJECT = ICONS_FULL_PATH + "obj16/"; //Model object icons//$NON-NLS-1$

	private final static String PATH_ELOCALTOOL = ICONS_FULL_PATH + "elcl16/"; //Enabled local toolbar icons.//$NON-NLS-1$

	private final static String DISABLED_PATH_ELOCALTOOL = ICONS_PATH + "dlcl16/"; //Enabled local toolbar icons.//$NON-NLS-1$

	private final static String DISABLED_PATH_ELTOOL = ICONS_PATH + "dtool16/"; //Enabled local toolbar icons.//$NON-NLS-1$

	private final static String[] DISABLED_PATHS = new String[] { DISABLED_PATH_ELOCALTOOL,
			DISABLED_PATH_ELTOOL };

	private final static String PATH_DGM = ICONS_PATH + "dgm/"; //$NON-NLS-1$

	//private final static String PATH_PROD = ICONS_PATH+"prod/";	//Product images
	private final static String PATH_OBJECT = ICONS_PATH + "obj16/"; //Model object icons//$NON-NLS-1$

	private final static String PATH_WIZBAN = ICONS_PATH + "wizban/"; //Wizard icons//$NON-NLS-1$

	private final static String PATH_FULL_OVER = ICONS_PATH + "ovr16/"; //decorator icons //$NON-NLS-1$

	private final static String PATH_UNIT_PROPERTY = ICONS_PATH + "dgm/"; //$NON-NLS-1$

	private final Map imageLocationMap = new HashMap();

	private final String bundleId;
	private final ImageRegistry imageRegistry;
	private final ImageRegistry disabledImageRegistry;

	private ISharedImages parent;

	/**
	 * Create an instance that will store images in the given registry and default to the given
	 * bundle id for looking up local images.
	 * 
	 * @param id
	 *           The id of a bundle that stores image that will be loaded from this instance of
	 *           {@link ISharedImages}
	 * @param registry
	 *           A registry that will actually contain images for this instance of
	 *           {@link ISharedImages}.
	 */
	public SharedImages(String id, ImageRegistry registry) {
		declareImages();
		bundleId = id;
		imageRegistry = registry;
		disabledImageRegistry = new ImageRegistry();
	}

	public SharedImages(String id, ImageRegistry registry, ImageRegistry disabledRegistry) {
		declareImages();
		bundleId = id;
		imageRegistry = registry;
		disabledImageRegistry = disabledRegistry;
	}

	/**
	 * Create an instance that will delegate to the parent for lookups before storing the image
	 * locally.
	 * 
	 * @param parent
	 *           A parent that is shared by other clients.
	 */
	public SharedImages(ISharedImages parent) {
		declareImages();
		if (parent instanceof SharedImages) {
			bundleId = ((SharedImages) parent).bundleId;
		} else {
			bundleId = DeployCoreUIPlugin.PLUGIN_ID;
		}
		imageRegistry = new ImageRegistry();
		disabledImageRegistry = new ImageRegistry();
		this.parent = parent;
	}

	private void declareImages() {
		declareImage(ISharedImages.IMG_TOP_WIZ_BAN, PATH_WIZBAN + "dply_topology_wizban.gif"); //$NON-NLS-1$

		declareImage(ISharedImages.IMG_ACTN_CORRECTION, PATH_FULL_OBJECT + "correction_change.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_ACTN_SYNCHRONIZE, PATH_ELOCALTOOL + "synchronize.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_ACTN_SYNCHRONIZE_TO_MODEL, PATH_ELOCALTOOL
				+ "sync_to_model.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_ACTN_SYNCHRONIZE_TO_WORLD, PATH_ELOCALTOOL
				+ "sync_to_world.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_TOPOLOGY_NAMESPACE_ROOT, PATH_OBJECT + "jworkingSet_obj.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_TOPOLOGY_PROJECT_OVRLY, PATH_FULL_OVER + "topology_ovr.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_REUSABLE_TOPOLOGY_OVRLY, PATH_FULL_OVER
				+ "reusable_topology.gif"); //$NON-NLS-1$
		//Declare property sheet icons.
		declareImage(ISharedImages.IMG_DEPENDENT_REQ, PATH_OBJECT + "dependen_rqrmnt.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_DEPENDENT_REQ_MET, PATH_OBJECT + "dependen_rqrmnt-met.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_MEMBERSHIP, ICONS_PATH + "svctypes/membership.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_HOSTING, PATH_OBJECT + "host_rqrmnt.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_LINKED_HOSTING, PATH_OBJECT + "host_rqrmnt-met.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_DELETE_LINK, "icons/elcl16/rmove_link.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_DELETE_LINK_DISABLED, "icons/dlcl16/rmove_link.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_DISCOVER_LINK, "icons/elcl16/create_link.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_DELETE_REQUIREMENT, "icons/elcl16/dlt_rqrmnt.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_DELETE_REQUIREMENT_DISABLED, "icons/dlcl16/dlt_rqrmnt.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_ADD_REQUIREMENT, "icons/elcl16/new_rqrmnt.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_ADD_REQUIREMENT_DISABLED, "icons/dlcl16/new_rqrmnt.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_DEPENDENCY_LINK_TYPE, "icons/dgm/depndlnk_dgm.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_MEMBERSHIP_LINK_TYPE, "icons/svctypes/membership.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_HOSTING_LINK_TYPE, "icons/dgm/hstlnk_dgm.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_LINK_ARROW, "icons/full/elcl16/link_arrow.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_MEMBER_ICON_OVERLAY, "icons/full/elcl16/member_arrow.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_HOSTEE_ICON_OVERLAY, "icons/full/elcl16/hostee_arrow.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_DEFERREDHOSTEE_ICON_OVERLAY,
				"icons/full/elcl16/deferredhostee_arrow.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_CONSTRAINT_LINK_TYPE, ICONS_PATH + "pal/constraint_link16.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_REALIZATION_LINK_TYPE, ICONS_PATH
				+ "pal/realization_pal16.gif"); //$NON-NLS-1$

		//Add child constraint icons
		declareImage(ISharedImages.IMG_ADD_CHILD_CONSTRAINT, ICONS_PATH
				+ "etool16/crtchildconstraint.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_ADD_CHILD_CONSTRAINT_DIS, ICONS_PATH
				+ "dtool16/crtchildconstraint.gif"); //$NON-NLS-1$

		//Declare Contract Overlays
		declareImage(ISharedImages.IMG_DEFAULT_CONTRACT_ALL_PUBLIC, PATH_FULL_OVER + "public.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_DEFAULT_CONTRACT_ALL_PRIVATE, PATH_FULL_OVER + "private.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_DEFAULT_CONTRACT_ALL_CONCEPTUAL_PUBLIC, PATH_FULL_OVER
				+ "mixed.gif"); //$NON-NLS-1$
		//Declare Contract images
		declareImage(ISharedImages.IMG_CONTRACT_PUBLIC, PATH_UNIT_PROPERTY + "public.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_CONTRACT_PUBLIC_EDITABLE, PATH_UNIT_PROPERTY
				+ "public-editable.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_CONTRACT_PRIVATE, PATH_UNIT_PROPERTY + "private.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_CONTRACT_PRIVATE_WITH_PUBLIC, PATH_UNIT_PROPERTY
				+ "privatepublic.gif"); //$NON-NLS-1$

		//Declare Install/Transition State images
		declareImage(ISharedImages.IMG_UNINSTALL_INSTALL, PATH_UNIT_PROPERTY + "un_in_installed.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_INSTALL_UNINSTALL, PATH_UNIT_PROPERTY + "in_un_installed.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_UNKNOWN_INSTALL, PATH_UNIT_PROPERTY + "unkn_in_installed.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_UNKNOWN_UNINSTALL, PATH_UNIT_PROPERTY
				+ "unkn_un_installed.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_INSTALLED, PATH_UNIT_PROPERTY + "installed.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_UNINSTALLED, PATH_UNIT_PROPERTY + "uninstalled.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_INSTALLED_UNKNOWN, PATH_UNIT_PROPERTY
				+ "installed_unknown.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_UNINSTALLED_UNKNOWN, PATH_UNIT_PROPERTY
				+ "uninstalled_unknown.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_NO_ATTRIBUTES, PATH_UNIT_PROPERTY + "noattribute.gif"); //$NON-NLS-1$

		//Declare Conceptual/concrete images
		declareImage(ISharedImages.IMG_CONCEPTUAL, PATH_UNIT_PROPERTY + "conceptual.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_NON_CONCEPTUAL, PATH_UNIT_PROPERTY + "non_conceptual.gif"); //$NON-NLS-1$		

		//Declare usage images
		declareImage(ISharedImages.IMG_USE_OPTIONAL, PATH_FULL_OBJECT + "use_optional.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_USE_REQUIRED, PATH_FULL_OBJECT + "use_required.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_USE_PROHIBITED, PATH_FULL_OBJECT + "use_prohibited.gif"); //$NON-NLS-1$

		// Declare Capability editing images
		declareImage(ISharedImages.IMG_ADD_CAPABILITY, "icons/elcl16/add_cpblty.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_EDIT_ATTRIBUTES, "icons/elcl16/edit_attrbut.gif"); //$NON-NLS-1$

		declareImage(ISharedImages.IMG_EDIT_REQUIREMENT, "icons/elcl16/edit_rqrmnt.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_EDIT_CAPABILITY, "icons/elcl16/edit_cpblty.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_DELETE_CAPABILITY, "icons/elcl16/delt_cpblty.gif"); //$NON-NLS-1$

		declareImage(ISharedImages.IMG_ADD_MATCHING_CAPABILITY, "icons/elcl16/match_cpblty.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_ADD_MATCHING_REQUIREMENT, "icons/elcl16/match_rqrmnt.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_ADD_CAPABILTITY_AND_REQUIREMENT,
				"icons/elcl16/add_cpblty_rqrmnt.gif"); //$NON-NLS-1$

		//Declare basic images
		declareImage(ISharedImages.IMG_DELETE, PATH_FULL_OBJECT + "delete_obj.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_ADD, PATH_FULL_OBJECT + "add_obj.gif"); //$NON-NLS-1$

		declareImage(ISharedImages.IMAGE_PUBLISH_ATTRIBUTE, PATH_OBJECT + "publish_obj.gif"); //$NON-NLS-1$

		//Declare editor images
		declareImage(ISharedImages.IMG_ARROW_DOWN, ICONS_PATH + "misc/ArrowDown.gif"); //$NON-NLS-1$

		// Declare collapse menu/toolbar icons
		declareImage(ISharedImages.IMG_TOOL_COLLAPSE_ALL, "icons/misc/collapseall.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_TOOL_COLLAPSE_ALL_DISABLED, "icons/misc/collapsealldis.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_TOOL_COLLAPSE_SELECTED, "icons/misc/collapsesel.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_TOOL_COLLAPSE_SELECTED_DISABLED,
				"icons/misc/collapseseldis.gif"); //$NON-NLS-1$

		// Declare diagram preferences icons
		declareImage(ISharedImages.IMG_TOOL_DIAGRAM_PREFERENCES, "icons/misc/diagramprefs.gif"); //$NON-NLS-1$

		declareImage(ISharedImages.IMG_TOOL_EXPAND_ALL_LCL, "icons/elcl16/expand_all.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_TOOL_EXPAND_ALL_LCL_DISABLED, "icons/dlcl16/expand_all.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_TOOL_COLLAPSE_ALL_LCL, "icons/elcl16/collapse_all.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_TOOL_COLLAPSE_ALL_LCL_DISABLED,
				"icons/dlcl16/collapse_all.gif"); //$NON-NLS-1$

		// Declare decorators at the ends of links
		declareImage(ISharedImages.IMG_REALIZATION_TARGET_DECORATOR, "icons/misc/realizetgt.gif"); //$NON-NLS-1$
		// topology status view 

		declareImage(ISharedImages.IMG_EXPAND_ALL_IMAGE, "icons/props/expandall.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_COLLAPSE_ALL_IMAGE, "icons/props/collapse_all.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_PUBLISH_IMAGE, "icons/props/temp_publish.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_EXPORT_IMAGE, "icons/props/temp_export.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_PARENT_IMAGE, "icons/props/parent_obj.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_SUCCESS_IMAGE, "icons/obj16/validated_errors_obj.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_SEPERATOR_IMAGE, "icons/images/seperator.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_TOPOLOGY_STATUS, "icons/view16/errors.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_BOUND_STATE, "icons/ovr16/bound_state_ovr.gif"); //$NON-NLS-1$

		//Status Icons
		declareImage(ISharedImages.IMG_ERROR, PATH_UNIT_PROPERTY + "error.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_ERROR16, PATH_OBJECT + "error_mssge_obj.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_QUICKFIX_ERROR16, PATH_OBJECT + "quickfix_error_obj16.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_WARNING, PATH_UNIT_PROPERTY + "warning.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_WARNING16, PATH_OBJECT + "warning_obj.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_QUICKFIX_WARNING16, PATH_OBJECT + "quickfix_warning_obj.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_INFO16, PATH_OBJECT + "information_obj.gif"); //$NON-NLS-1$
		declareImage(ISharedImages.IMG_INFO, PATH_UNIT_PROPERTY + "info_warning.gif"); //$NON-NLS-1$

		//Group context menu icon
		declareImage(ISharedImages.IMG_GROUP_ICON, ICONS_PATH + "pal/unit_group_16.gif"); //$NON-NLS-1$

		//TopologyDiagramNode
		declareImage(ISharedImages.IMG_TOPOLOGY_DIAGRAM_NODE, PATH_FULL_OBJECT
				+ "TopologyDiagramNode.gif"); //$NON-NLS-1$

		//TopologyDiagramNode
		declareImage(ISharedImages.IMG_LOADING_MODEL_NODE_1, PATH_OBJECT + "loading1.gif"); //$NON-NLS-1$

		//TopologyDiagramNode
		declareImage(ISharedImages.IMG_LOADING_MODEL_NODE_2, PATH_OBJECT + "loading2.gif"); //$NON-NLS-1$

		//TopologyDiagramNode
		declareImage(ISharedImages.IMG_LOADING_MODEL_NODE_3, PATH_OBJECT + "loading3.gif"); //$NON-NLS-1$

		//TopologyDiagramNode
		declareImage(ISharedImages.IMG_LOADING_MODEL_NODE_4, PATH_OBJECT + "loading4.gif"); //$NON-NLS-1$

		declareImage(ISharedImages.IMG_DROP_DOWN_MENU, PATH_ELOCALTOOL + "view_menu.gif"); //$NON-NLS-1$

		declareImage(ISharedImages.IMG_CONSTRAINT, PATH_DGM + "constraints.gif"); //$NON-NLS-1$

	}

	public Image getImage(String symbolicName) {
		if (parent != null) {
			Image pImg = parent.getImage(symbolicName);
			if (pImg != null) {
				return pImg;
			}
		}

		String path = (String) imageLocationMap.get(symbolicName);
		return getImageFromPath(path);
	}

	public Image getImage(String symbolicName, boolean enabled) {
		if (parent != null) {
			Image pImg = parent.getImage(symbolicName);
			if (pImg != null) {
				return pImg;
			}
		}

		String path = (String) imageLocationMap.get(symbolicName);
		return getImageFromPath(path, enabled);
	}

	public Image getImage(ImageDescriptor descriptor) {
		if (parent != null) {
			Image pImg = parent.getImage(descriptor);
			if (pImg != null) {
				return pImg;
			}
		}

		Image image = null;
		synchronized (imageRegistry) {
			if ((image = imageRegistry.get(descriptor.toString())) == null) {
				if (descriptor != null) {
					imageRegistry.put(descriptor.toString(), (image = descriptor.createImage()));
				}
			}
		}
		return image;
	}

	private void declareImage(String symbolicName, String path) {
		imageLocationMap.put(symbolicName, path);

	}

	public ImageDescriptor getImageDescriptor(String symbolicName) {
		if (parent != null) {
			ImageDescriptor pDesc = parent.getImageDescriptor(symbolicName);
			if (pDesc != null) {
				return pDesc;
			}
		}
		synchronized (imageLocationMap) {
			String path = (String) imageLocationMap.get(symbolicName);
			return AbstractUIPlugin.imageDescriptorFromPlugin(bundleId, path);
		}
	}

	public ImageDescriptor getImageDescriptor(URL imageURL) {
		if (parent != null) {
			ImageDescriptor pDesc = parent.getImageDescriptor(imageURL);
			if (pDesc != null) {
				return pDesc;
			}
		}
		return ImageDescriptor.createFromURL(imageURL);
	}

	public Image getImageFromPath(String path) {
		if (parent != null) {
			Image pImg = parent.getImage(path);
			if (pImg != null) {
				return pImg;
			}
		}
		Image image = null;
		synchronized (imageRegistry) {
			if ((image = imageRegistry.get(path)) == null) {
				ImageDescriptor descriptor = AbstractUIPlugin.imageDescriptorFromPlugin(bundleId, path);
				if (descriptor != null) {
					imageRegistry.put(path, (image = descriptor.createImage()));
				}
			}
		}
		return image;
	}

	public Image getImageFromPath(String path, boolean enabled) {
		if (enabled) {
			return getImageFromPath(path);
		}

		if (parent != null) {
			Image pImg = parent.getImageFromPath(path, enabled);
			if (pImg != null) {
				return pImg;
			}
		}
		Image image = null;
		synchronized (disabledImageRegistry) {
			if ((image = disabledImageRegistry.get(path)) == null) {
				int beginIndex = path.lastIndexOf('/');
				if (beginIndex == -1) {
					return null;
				}
				String stringFileName = path.substring(beginIndex + 1, path.length());
				String disabledFilePath = getDisabledFileLocaction(stringFileName);
				if (disabledFilePath != null) {
					image = addToDisabledImageRegistry(path, disabledFilePath, image);
				} else {
					image = getImageFromPath(path);
					if (image != null) {
						image = new Image(Display.getDefault(), image, SWT.IMAGE_DISABLE);
						disabledImageRegistry.put(path, image);
					}
				}
			}
		}

		return image;
	}

	private Image addToDisabledImageRegistry(String path, String disabledFilePath, Image image) {
		ImageDescriptor descriptor;
		descriptor = AbstractUIPlugin.imageDescriptorFromPlugin(bundleId, disabledFilePath);
		if (descriptor != null) {
			disabledImageRegistry.put(path, (image = descriptor.createImage()));
		}
		return image;
	}

	private String getDisabledFileLocaction(String stringFileName) {
		for (int i = 0; i < DISABLED_PATHS.length; i++) {
			String path = DISABLED_PATHS[i];
			String disabledELocalToolPath = path + stringFileName;
			Bundle bundle = Platform.getBundle(bundleId);
			URL url = FileLocator
					.find(bundle, new Path(disabledELocalToolPath), Collections.EMPTY_MAP);
			if (url != null) {
				return disabledELocalToolPath;
			}

		}
		return null;
	}

	public Image getImage(URL imageURL) {
		if (parent != null) {
			Image pImg = parent.getImage(imageURL);
			if (pImg != null) {
				return pImg;
			}
		}
		Image image = null;
		synchronized (imageRegistry) {
			image = imageRegistry.get(imageURL.toString());
			if (image == null) {
				ImageDescriptor imageDescriptor = getImageDescriptor(imageURL);
				imageRegistry.put(imageURL.toString(), image = imageDescriptor.createImage());
			}
		}
		return image;
	}

	public void dispose() {
		if (parent != null) {
			imageRegistry.dispose();
			disabledImageRegistry.dispose();
		}

	}

	public String getPath(String symbolicName) {
		// TODO Auto-generated method stub
		return (String) imageLocationMap.get(symbolicName);
	}

}
