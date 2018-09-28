/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.resources;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.gmf.runtime.emf.core.internal.util.EMFCoreConstants;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResource;

//This code is exactly the same a MResourceFactory except this one creates a custom MSLResource
//instead of MSLResource. We had to do this to override ModificationTracking adapter.
public class SOAResourceFactory extends XMIResourceFactoryImpl {

	public SOAResourceFactory() {
		super();
	}

	// default load options.
	private static final Map loadOptions = new HashMap();

	// default save options.
	private static final Map saveOptions = new HashMap();

	static {

		XMIResource resource = new XMIResourceImpl();

		// default load options.
		loadOptions.putAll(resource.getDefaultLoadOptions());
		loadOptions.put(XMIResource.OPTION_LAX_FEATURE_PROCESSING, Boolean.TRUE);

		// default save options.
		saveOptions.putAll(resource.getDefaultSaveOptions());
		saveOptions.put(XMIResource.OPTION_DECLARE_XML, Boolean.TRUE);
		saveOptions.put(XMIResource.OPTION_PROCESS_DANGLING_HREF,
				XMIResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);
		saveOptions.put(XMIResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
		saveOptions.put(XMIResource.OPTION_USE_XMI_TYPE, Boolean.TRUE);
		saveOptions.put(XMIResource.OPTION_SAVE_TYPE_INFORMATION, Boolean.TRUE);
		saveOptions.put(XMIResource.OPTION_SKIP_ESCAPE_URI, Boolean.FALSE);
		saveOptions.put(XMIResource.OPTION_ENCODING, EMFCoreConstants.XMI_ENCODING);
	}

	/**
	 * Get default load options.
	 */
	public static Map getDefaultLoadOptions() {
		return loadOptions;
	}

	/**
	 * Get default save options.
	 */
	public static Map getDefaultSaveOptions() {
		return saveOptions;
	}

	public Resource createResource(URI uri) {
		XMIResource resource = new GMFResource(uri) {
			//The only thing extra this does is to create its own ModificationTrackingAdapter which understands
			//GMF notational Transient feature.
			protected Adapter createModificationTrackingAdapter() {
				return new MSLModificationTrackingAdapter();
			}
		};

		resource.getDefaultLoadOptions().putAll(loadOptions);
		resource.getDefaultSaveOptions().putAll(saveOptions);

		if (!resource.getEncoding().equals(EMFCoreConstants.XMI_ENCODING))
			resource.setEncoding(EMFCoreConstants.XMI_ENCODING);

		return resource;
	}
}
