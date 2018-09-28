/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IResourceTypeService;
import com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Provides a wrapper around <b>&lt;resourceTypePaletteBinding /&gt;</b> configuration elements
 * parsed from the <b>com.ibm.ccl.soa.deploy.core.domains</b> extension point.
 * 
 * @since 1.0
 * 
 */
public class ResourceTypeUIBindingDescriptor extends CommonDescriptor {

	private String label;
	private String description;
	private String resourceTypeId;
	private String path;
	private String smallIcon;
	private String largeIcon;
	private String smallIconFullyQualified;
	private String largeIconFullyQualified;
	private String enableForPalette;

	/**
	 * Only allow classes local to the package or subclasses to instantiate this element.
	 * 
	 * @param anElement
	 *           The "resourceTypePaletteBinding" IConfigurationElement from the registry reader.
	 */
	protected ResourceTypeUIBindingDescriptor(IConfigurationElement anElement) {
		super(anElement);
		assert TAG_RESOURCE_TYPE_UI_BINDING.equals(anElement.getName());
		init();
	}

	private void init() {
		label = getElement().getAttribute(ATT_LABEL);

		// SWT really hates null labels, so don't risk holding one
		if (label == null) {
			label = ""; //$NON-NLS-1$
		}

		path = getElement().getAttribute(ATT_PATH);
		description = getElement().getAttribute(ATT_DESCRIPTION);
		resourceTypeId = getElement().getAttribute(ATT_RESOURCE_TYPE_ID);
		smallIcon = getElement().getAttribute(ATT_SMALL_ICON);
		largeIcon = getElement().getAttribute(ATT_LARGE_ICON);
		enableForPalette = getElement().getAttribute(ENABLE_PALETTE);
	}

	public String toString() {
		return "ResourceTypePaletteBindingDescriptor[resourceTypeId=" + resourceTypeId + ", label=" + label + ", path=" + path + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	}

	/**
	 * The label of this resource descriptor
	 * 
	 * @return
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * The description of this resource descriptor
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @return the Resource type id of this binding
	 */
	public String getResourceTypeId() {
		return resourceTypeId;
	}

	/**
	 * 
	 * @return The path of this binding
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Create a DeployPaletteEntry
	 * 
	 * @return the created DeployPaletteEntry, null if the associated resourceTypeId does not match a
	 *         known resource type
	 */
	public DynamicPaletteEntry createDeployPaletteEntry() {
		IResourceTypeService rts = ExtensionsCore.createResourceTypeService();
		ResourceTypeDescriptor rdesc = rts.getResourceTypeDescriptor(resourceTypeId);

		if (rdesc != null) {
			String paletteLabel = label;
			if (label == null || label.equals("")) //$NON-NLS-1$
			{
				paletteLabel = rdesc.getName();
			}
			String paletteDesc = description;
			if (description == null || description.equals("")) //$NON-NLS-1$
			{
				paletteDesc = rdesc.getDescription();
			}

			// id, path, label, desc, smallIcon, largeIcon, kind
			DynamicPaletteEntry entry = rts.createDynamicPaletteEntry(resourceTypeId, path,
					paletteLabel, paletteDesc, getSmallIconFullyQualified(),
					getLargeIconFullyQualified(), rdesc.getTemplateUri());

			return entry;
		}
		// TODO error that resource type id could not be found
		return null;
	}

	/**
	 * @return The large icon path
	 */
	public String getLargeIcon() {
		return largeIcon;
	}

	/**
	 * @return The small icon path
	 */
	public String getSmallIcon() {
		return smallIcon;
	}

	/**
	 * Return the fully-qualified small icon URI string
	 * 
	 * @return
	 */
	public String getSmallIconFullyQualified() {
		if (smallIconFullyQualified == null) {
			smallIconFullyQualified = findIconFullPath(getElement(), smallIcon);
		}
		return smallIconFullyQualified;
	}

	/**
	 * Return the fully-qualified large icon URI string
	 * 
	 * @return
	 */
	public String getLargeIconFullyQualified() {
		if (largeIconFullyQualified == null) {
			largeIconFullyQualified = findIconFullPath(getElement(), largeIcon);
		}
		return largeIconFullyQualified;
	}

	/**
	 * Return the URL of the small icon path
	 * 
	 * @return
	 */
	public URL getSmallIconURL() {
		String pluginId = getElement().getDeclaringExtension().getNamespaceIdentifier();
		Bundle bundle = Platform.getBundle(pluginId);
		if (smallIcon != null) {
			URL fullPathString = FileLocator.find(bundle, new Path(smallIcon), null);
			return fullPathString;
		}
		return null;
	}

	/**
	 * Finds the platform relative URI to the icon path
	 * 
	 * @param configElement
	 * @param smallIconPath
	 * @return
	 */
	private String findIconFullPath(IConfigurationElement configElement, String iconPath) {
		try {
			if (iconPath != null) {
				URI iconURI = URI.createURI(iconPath);
				URI pluginURI = URI.createPlatformPluginURI(configElement.getContributor().getName()
						+ "/", true); //$NON-NLS-1$
				URI newiconURI = iconURI.resolve(pluginURI);
				return newiconURI.toString();
			}
		} catch (Exception e) {
			String message = NLS.bind(DeployCoreMessages.Malformed_resource_type_icon_url_0,
					new Object[] { iconPath });
			DeployCorePlugin.logError(0, message, null);
		}

		return null;
	}

	/**
	 * Returns true if the binding is palette enabled
	 * 
	 * @return
	 */
	public boolean isEnabledForPalette() {
		if (enableForPalette != null) {
			if (enableForPalette.equals("false")) { //$NON-NLS-1$
				return false;
			}
		}
		return true;
	}

	public String getName() {
		return getLabel();
	}
}
