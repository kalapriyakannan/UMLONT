/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;

public class DeployModelObjectAdapterFactory implements IAdapterFactory {

	private static final Class IFILE_CLASS = IFile.class;
	private static final Class IRESOURCE_CLASS = IResource.class;

	private static final Class[] SUPPORTED_ADAPTER_TYPES = new Class[] { IFILE_CLASS,
			IRESOURCE_CLASS };

	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adaptableObject instanceof DeployModelObject) {
			DeployModelObject dmo = (DeployModelObject) adaptableObject;
			if ((adapterType == IFILE_CLASS || adapterType == IRESOURCE_CLASS)
					&& dmo.getEObject().eResource() != null)
				return WorkbenchResourceHelperBase.getIFile(dmo.getEObject().eResource().getURI());
		}
		return null;
	}

	public Class[] getAdapterList() {
		return SUPPORTED_ADAPTER_TYPES;
	}

}
