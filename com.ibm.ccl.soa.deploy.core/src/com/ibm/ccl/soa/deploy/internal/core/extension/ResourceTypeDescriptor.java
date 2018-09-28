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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Provides a wrapper around <b>&lt;resourceType /&gt;</b> configuration elements parsed from the
 * <b>com.ibm.ccl.soa.deploy.core.domains</b> extension point.
 * 
 * @since 1.0
 * 
 */
public class ResourceTypeDescriptor extends CommonDescriptor {

	private String id;
	private String templateUri;
	private String description;
	private EClass eclass;
	private String eclassName;
	private String nsUri;
	private String templateVUri;

	private EPackage ePackage;
	boolean metamodelNotFound = false;
	boolean eClassNotFound = false;

	private static final String PLATFORM_URI_PREFIX = "platform:/plugin"; //$NON-NLS-1$
	private static final String EMPTY_STRING = ""; //$NON-NLS-1$

	/**
	 * Only allow classes local to the package or subclasses to instantiate this element.
	 * 
	 * @param anElement
	 *           The "resourceType" IConfigurationElement from the registry reader.
	 */
	protected ResourceTypeDescriptor(IConfigurationElement anElement) {
		super(anElement);
		assert TAG_RESOURCE_TYPE.equals(anElement.getName());
		init();
	}

	private void init() {
		id = getElement().getAttribute(ATT_ID);
		templateUri = getElement().getAttribute(ATT_TEMPLATE_URI);
		templateVUri = getElement().getAttribute(ATT_TEMPLATEV_URI);
		description = getElement().getAttribute(ATT_DESCRIPTION);
		if (templateUri == null || templateUri.equals("")) { //$NON-NLS-1$
			eclassName = getElement().getAttribute(ATT_ECLASS);
			Object obj = getElement().getParent();
			if (obj instanceof IConfigurationElement) {
				IConfigurationElement elem = (IConfigurationElement) obj;
				nsUri = elem.getAttribute(ATT_TARGET_NAMESPACE);
			}
		} else {
			templateUri = resolveURI(templateUri);
			if (templateVUri != null) {
				templateVUri = resolveURI(templateVUri);
			}

		}

	}

	public String toString() {
		return "ResourceTypeDescriptor[name=" + getName() + ", id=" + id + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	/**
	 * The id of this resource descriptor
	 * 
	 * @return the id of this resource descriptor
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * @return The templateUri of this resource descriptor
	 */
	public String getTemplateUri() {
		return templateUri;
	}

	public String getTemplateVUri() {
		return templateVUri;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the eclass, will return null is templateUri is specified
	 */
	public String getEclassName() {
		return eclassName;
	}

	/**
	 * @return the eclass of this descriptor
	 */
	public EClass getEclass() {

		if (eclass != null) {
			return eclass;
		}

		if (ePackage == null & !metamodelNotFound) {
			ePackage = getNsUri() != null ? EPackage.Registry.INSTANCE.getEPackage(getNsUri()) : null;

			if (ePackage == null) {
				metamodelNotFound = true;
				DeployCorePlugin.logError(0, NLS.bind(
						DeployCoreMessages.ResourceTypeDescriptor_ePackage_not_found_for_namespace_0_,
						getNsUri()), null);
			}
		}

		if (eclass == null && !eClassNotFound) {
			ENamedElement namedElement = ePackage.getEClassifier(getEclassName());

			if (namedElement instanceof EClass) {
				eclass = (EClass) namedElement;
			}

			if (eclass == null) {
				eClassNotFound = true;
				// TODO log error - eclass not found
				DeployCorePlugin.logError(0, NLS.bind(
						DeployCoreMessages.ResourceTypeDescriptor_Resource_type_eclass_0_not_found_,
						getEclassName()), null);
			}
		}

		return eclass;
	}

	/**
	 * @return the namespace URI
	 */
	public String getNsUri() {
		return nsUri;
	}

	private String resolveURI(String uri) {
		if (uri == null || uri.equals(EMPTY_STRING) || uri.startsWith(PLATFORM_URI_PREFIX)) {
			return uri;
		}
		// Look in current bundle for relative URI path
		String pluginId = getElement().getDeclaringExtension().getNamespaceIdentifier();
		Bundle bundle = Platform.getBundle(pluginId);
		URL resolvedTemplateURL = FileLocator.find(bundle, new Path(uri), null);
		if (resolvedTemplateURL != null) {
			uri = resolvedTemplateURL.toString();
		}
		return uri;

	}

}
