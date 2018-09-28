/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.namespace;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdapterFactory;

import com.ibm.ccl.soa.deploy.core.namespace.INamespaceElement;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragment;

/**
 * Adapter Factory implementation for all topology element types.
 * 
 * @since 1.0
 * 
 */
public class NamespaceElementAdapterFactory implements IAdapterFactory {

	private static final Class IFOLDER_CLASS = IFolder.class;
	private static final Class ICONTAINER_CLASS = IContainer.class;
	private static final Class IRESOURCE_CLASS = IResource.class;

	private static final int IFOLDER_TYPE = 200;
	private static final int ICONTAINER_TYPE = 300;
	private static final int IRESOURCE_TYPE = 400;

	private static final int IFOLDER_TYPE_AND_TOPOLOGY_NAMESPACE_OBJECT = IFOLDER_TYPE
			+ INamespaceElement.TOPOLOGY_NAMESPACE;
	private static final int IFOLDER_TYPE_AND_TOPOLOGY_NAMESPACE_ROOT_OBJECT = IFOLDER_TYPE
			+ INamespaceElement.TOPOLOGY_NAMESPACE_ROOT;
	private static final int ICONTAINER_TYPE_AND_TOPOLOGY_NAMESPACE_OBJECT = ICONTAINER_TYPE
			+ INamespaceElement.TOPOLOGY_NAMESPACE;
	private static final int ICONTAINER_TYPE_AND_TOPOLOGY_NAMESPACE_ROOT_OBJECT = ICONTAINER_TYPE
			+ INamespaceElement.TOPOLOGY_NAMESPACE_ROOT;
	private static final int IRESOURCE_TYPE_AND_TOPOLOGY_NAMESPACE_OBJECT = IRESOURCE_TYPE
			+ INamespaceElement.TOPOLOGY_NAMESPACE;
	private static final int IRESOURCE_TYPE_AND_TOPOLOGY_NAMESPACE_ROOT_OBJECT = IRESOURCE_TYPE
			+ INamespaceElement.TOPOLOGY_NAMESPACE_ROOT;

	private static final Class[] SUPPORTED_ADAPTER_TYPES = new Class[] { IFOLDER_CLASS,
			ICONTAINER_CLASS, IRESOURCE_CLASS };

	public Object getAdapter(Object adaptableObject, Class adapterType) {

		if (adaptableObject instanceof INamespaceElement) {

			// cast adaptable to ITopologyElement
			INamespaceElement ele = (INamespaceElement) adaptableObject;

			int type = 0;
			if (adapterType == IFOLDER_CLASS)
				type = IFOLDER_TYPE;
			if (adapterType == ICONTAINER_CLASS)
				type = ICONTAINER_TYPE;
			if (adapterType == IRESOURCE_CLASS)
				type = IRESOURCE_TYPE;

			// decide how to cast the return object depending on the element type
			switch (type + ele.getType())
			{

			case IFOLDER_TYPE_AND_TOPOLOGY_NAMESPACE_OBJECT:
			case IFOLDER_TYPE_AND_TOPOLOGY_NAMESPACE_ROOT_OBJECT:
				return (IFolder) ele.getRoot().getCorrespondingResource((INamespaceFragment) ele);

			case ICONTAINER_TYPE_AND_TOPOLOGY_NAMESPACE_OBJECT:
			case ICONTAINER_TYPE_AND_TOPOLOGY_NAMESPACE_ROOT_OBJECT:
				return ele.getRoot().getCorrespondingResource((INamespaceFragment) ele);

			case IRESOURCE_TYPE_AND_TOPOLOGY_NAMESPACE_OBJECT:
			case IRESOURCE_TYPE_AND_TOPOLOGY_NAMESPACE_ROOT_OBJECT:
				return (IResource) ele.getRoot().getCorrespondingResource((INamespaceFragment) ele);

			}
		}
		return null;
	}

	public Class[] getAdapterList() {

		return SUPPORTED_ADAPTER_TYPES;

	}

}
