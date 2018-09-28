/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.handlers;

import java.util.HashMap;
import java.util.Map;

import com.ibm.ccl.soa.deploy.core.Artifact;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ui.composites.AbstractCompositeFactory;

/**
 * Composite Factory Service.
 * 
 */
public class CompositeFactoryService implements ICompositeFactoryService {
	private final Map<CompositeFactoryDescriptor, AbstractCompositeFactory> descToFactory = new HashMap<CompositeFactoryDescriptor, AbstractCompositeFactory>();
	private final Object lock = new Object();

	//Grab all the descriptors
	private CompositeFactoryDescriptor[] findAllCompositeFactoryDescriptors() {
		CompositeFactoryDescriptor[] descriptors = CompositeFactoryManager.INSTANCE
				.findAllCompositeFactoryDescriptors();
		return descriptors;
	}

	//TODO Rename
	public AbstractCompositeFactory findDmoUIHandlerForDmo(DeployModelObject dmo) {
		CompositeFactoryDescriptor[] list = findAllCompositeFactoryDescriptors();
		for (int i = 0; i < list.length; i++) {
			CompositeFactoryDescriptor desc = list[i];
			if (desc.isEnabled(dmo)) {
				AbstractCompositeFactory factory = getFactory(desc);
				if (factory.isUIHandlerForObject(dmo)) {
					return factory;
				}
			}
		}

		// No matches found in extension points; return a suitable default handler
		if (dmo instanceof Capability) {
			return new CatchallCapabilityUIHandler3();
		} else if (dmo instanceof Artifact) {
			// By passing false, we don't show Constraints on Artifacts, even though
			// the model allows it.
			return new CatchallDmoUIHandler(false);
		}

		// By passing nothing we don't show Constraints on Constraints, even though the
		// model allows it.  Child constraints are handled differently, by a tree or list view.
		return new CatchallDmoUIHandler();
	}

	public static ICompositeFactoryService createCompositeFactoryService() {
		return new CompositeFactoryService();
	}

	private AbstractCompositeFactory getFactory(CompositeFactoryDescriptor desc) {
		synchronized (lock) {
			AbstractCompositeFactory factory = descToFactory.get(desc);
			if (factory == null) {
				descToFactory.put(desc, factory = desc.createCompositeFactory());
			}
			return factory;
		}

	}

}
