/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.saf.extension;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.osgi.util.NLS;
import org.osgi.framework.Bundle;

import com.ibm.ccl.soa.deploy.internal.saf.Messages;
import com.ibm.ccl.soa.deploy.internal.saf.SAFPlugin;
import com.ibm.ccl.soa.deploy.saf.handler.ICommonDescriptor;

/**
 * Provides a wrapper around configuration elements parsed from the extension points in
 * <b>com.ibm.ccl.soa.deploy.core</b> plugin.
 * 
 * <p>
 * A <i>Descriptor</i> provides a higher level abstraction to handle parsing, validation, and
 * failsafeness around configuration elements parsed from the Eclipse extension point mechanism.
 * </p>
 * 
 * <p>
 * Subclasses are required to validate or protect the value returned from any <i>getXXX()</i>
 * method.
 * </p>
 * 
 * <p>
 * Subclasses are also required to define zero or more <i>createXXX()</i> methods.
 * </p>
 * <p>
 * In createXXX() methods, unless a null value signifies a particular condition or behavior, define
 * a non-API singleton implementation of the required interface or type to return in place of
 * exceptions or null return values.
 * </p>
 * <p>
 * For example, if the extension defines an implementation of IMyInterface, define a non-API
 * implementation of IMyInterface named SkeletonMyInterface (in an internal package) which
 * implements IMyInterface (with no-op methods) and declares a public static final IMyInterface
 * INSTANCE = new SkeletonMyInterface(); singleton field. Also make the the constructor private so
 * that it cannot be inadvertantly instantiated. Then whenever an exception occurs when trying to
 * instantiate the specific implementation from the extension, return SkeletonMyInterface.INSTANCE
 * instead of null.
 * </p>
 * 
 * @since 1.0
 * 
 */
public abstract class CommonDescriptor implements ISAFExtensionConstants, ICommonDescriptor {

	private final IConfigurationElement element;

	protected final String EMPTY_STRING = ""; //$NON-NLS-1$

	private final String name;
	private final String description;
	private URL smallIconURL;
	private URL largeIconURL;

	/**
	 * @param anElement
	 *           The configuration element from the parsed extension point.
	 */
	public CommonDescriptor(IConfigurationElement anElement) {
		Assert.isNotNull(anElement);
		IExtension extension = anElement.getDeclaringExtension();
		element = anElement;

		name = element.getAttribute(ATTR_NAME) == null ? EMPTY_STRING : element
				.getAttribute(ATTR_NAME);
		if (name == null || name.equals("")) { //$NON-NLS-1$
			SAFPlugin.log(this, "initialize", IStatus.WARNING, //$NON-NLS-1$
					NLS.bind(Messages.ccl_soa_core_component_attributeNameMissing, element.getName(),
							extension.getNamespaceIdentifier()));
		}

		description = element.getAttribute(ATTR_DESCRIPTION) == null ? EMPTY_STRING : element
				.getAttribute(ATTR_DESCRIPTION);

		String smallIconURI = element.getAttribute(ATTR_SMALL_ICON) == null ? EMPTY_STRING : element
				.getAttribute(ATTR_SMALL_ICON);
		smallIconURL = null;
		if (smallIconURI != null) {
			try {
				smallIconURL = getImageURL(smallIconURI, extension);
			} catch (MalformedURLException e) {
				SAFPlugin.log(this, "initialize", IStatus.WARNING, //$NON-NLS-1$
						NLS.bind(Messages.ccl_soa_core_component_attributeIconInvalid, new Object[] {
								smallIconURI, ISAFExtensionConstants.ATTR_SMALL_ICON, element.getName(),
								extension.getNamespaceIdentifier() }));
			}
		}

		String largeIconURI = element.getAttribute(ATTR_LARGE_ICON) == null ? EMPTY_STRING : element
				.getAttribute(ATTR_LARGE_ICON);
		largeIconURL = null;
		if (largeIconURI != null) {
			try {
				largeIconURL = getImageURL(largeIconURI, extension);
			} catch (MalformedURLException e) {
				SAFPlugin.log(this, "initialize", IStatus.WARNING, //$NON-NLS-1$
						NLS.bind(Messages.ccl_soa_core_component_attributeIconInvalid, new Object[] {
								largeIconURI, ISAFExtensionConstants.ATTR_LARGE_ICON, element.getName(),
								extension.getNamespaceIdentifier() }));
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.internal.saf.extension.ICommonDescriptor#getName()
	 */
	public String getName() {
		return name;
	}

	/**
	 * Provides access to the configuration element for subclasses.
	 * 
	 * @return the configuration element used to construct this descriptor.
	 */
	protected final IConfigurationElement getElement() {
		return element;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.internal.saf.extension.ICommonDescriptor#getLargeIcon()
	 */
	public final URL getLargeIcon() {
		return largeIconURL;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.internal.saf.extension.ICommonDescriptor#getSmallIcon()
	 */
	public final URL getSmallIcon() {
		return smallIconURL;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.internal.saf.extension.ICommonDescriptor#getDescription()
	 */
	public final String getDescription() {
		return description;
	}

	private URL getImageURL(String uri, IExtension extension) throws MalformedURLException {
		if (uri == null || uri.length() == 0) {
			return null;
		}

		String pluginId = extension.getNamespaceIdentifier();

		Bundle bundle = Platform.getBundle(pluginId);

		URL baseURL = bundle.getEntry("/"); //$NON-NLS-1$
		return new URL(baseURL, uri);
	}
}
