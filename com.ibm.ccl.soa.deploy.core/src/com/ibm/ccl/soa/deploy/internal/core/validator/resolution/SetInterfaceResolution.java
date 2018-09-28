/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.internal.core.validator.resolution;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.core.Reference;
import com.ibm.ccl.soa.deploy.core.Service;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * @since 7.0
 * 
 */
public class SetInterfaceResolution extends DeployResolution {

	private Reference reference;
	private Service service;
	private final Interface originalInterface;

	/**
	 * @param aContext
	 * @param aGenerator
	 * @param aReference
	 *           The {@link Reference} whose interface field will be set using the passed
	 *           anInterface.
	 * @param anInterface
	 *           The {@link Interface} which will be copied and set on the passed aReference.
	 */
	public SetInterfaceResolution(IDeployResolutionContext aContext,
			IDeployResolutionGenerator aGenerator, Reference aReference, Interface anInterface) {
		super(aContext, aGenerator, computeDescription(aReference, anInterface));
		reference = aReference;
		originalInterface = anInterface;
	}

	/**
	 * @param aContext
	 * @param aGenerator
	 * @param aService
	 *           The {@link Service} whose interface field will be set using the passed anInterface.
	 * @param anInterface
	 *           The {@link Interface} which will be copied and set on the passed aService.
	 */
	public SetInterfaceResolution(IDeployResolutionContext aContext,
			IDeployResolutionGenerator aGenerator, Service aService, Interface anInterface) {
		super(aContext, aGenerator, computeDescription(aService, anInterface));
		service = aService;
		originalInterface = anInterface;
	}

	private static String computeDescription(Reference aReference, Interface anInterface) {
		return NLS.bind(DeployCoreMessages.SetInterfaceResolution_Set_interface_of_0_, new Object[] {
				aReference.getDisplayName() == null ? aReference.getName() : aReference
						.getDisplayName(), anInterface.getDisplayString() });
	}

	private static String computeDescription(Service aService, Interface anInterface) {
		return NLS.bind(DeployCoreMessages.SetInterfaceResolution_Set_interface_of_0_, new Object[] {
				aService.getCaptionProvider().title(aService), anInterface.getDisplayString() });
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#resolve(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		if (originalInterface != null) {
			Interface copy = (Interface) EcoreUtil.copy(originalInterface);
			if (service != null) {
				service.setInterface(copy);
			} else if (reference != null) {
				reference.setInterface(copy);
			}
			return Status.OK_STATUS;
		}
		return null;
	}

}
