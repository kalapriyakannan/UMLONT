/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.internal.core.validator.resolution;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.core.Reference;
import com.ibm.ccl.soa.deploy.core.Service;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCoreValidators;

/**
 * @since 7.0
 * 
 */
public class SetInterfaceResolutionGenerator extends DeployResolutionGenerator {

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		String problemType = context.getDeployStatus().getProblemType();
		if (problemType.equals(ICoreProblemType.REFERENCE_LINKED_INTERFACE_MISMATCH)) {
			String validatorID = context.getDeployStatus().getValidatorID();
			DeployModelObject dmo = context.getDeployStatus().getDeployObject();
			if (IDeployCoreValidators.REFERENCE_INTERFACE_002.equals(validatorID)) {
				//The reference interface is null so test if the reference interface can be set.
				if (dmo instanceof DependencyLink) {
					DependencyLink link = (DependencyLink) dmo;
					Reference ref = (Reference) link.getSource();
					if (canSetInterface(ref)) {
						return new IDeployResolution[] { new SetInterfaceResolution(context, this, ref,
								getServiceInterface(link)) };
					}
				}
			} else if (IDeployCoreValidators.REFERENCE_INTERFACE_003.equals(validatorID)) {
				//The service interface is null so test if the service interface can be set.
				if (dmo instanceof DependencyLink) {
					DependencyLink link = (DependencyLink) dmo;
					Service service = (Service) link.getTarget();
					if (canSetInterface(service)) {
						return new IDeployResolution[] { new SetInterfaceResolution(context, this,
								service, getReferenceInterface(link)) };
					}
				}
			} else if (IDeployCoreValidators.REFERENCE_INTERFACE_001.equals(validatorID)) {
				if (dmo instanceof DependencyLink) {
					DependencyLink link = (DependencyLink) dmo;
					Reference ref = (Reference) link.getSource();
					Service service = (Service) link.getTarget();
					IDeployResolution refResolution = null;
					IDeployResolution serviceResolution = null;
					if (canSetInterface(ref)) {
						refResolution = new SetInterfaceResolution(context, this, ref, service
								.getInterface());
					}
					if (canSetInterface(service)) {
						serviceResolution = new SetInterfaceResolution(context, this, service, ref
								.getInterface());
					}
					if (refResolution != null && serviceResolution != null) {
						return new IDeployResolution[] { refResolution, serviceResolution };
					} else if (refResolution != null) {
						return new IDeployResolution[] { refResolution };
					} else if (serviceResolution != null) {
						return new IDeployResolution[] { serviceResolution };
					}
				}
			}
		}
		return null;
	}

	private Interface getReferenceInterface(DependencyLink link) {
		return ((Reference) link.getSource()).getInterface();
	}

	private Interface getServiceInterface(DependencyLink link) {
		return ((Service) link.getTarget()).getInterface();
	}

	public boolean hasResolutions(IDeployResolutionContext context) {
		String problemType = context.getDeployStatus().getProblemType();
		if (problemType.equals(ICoreProblemType.REFERENCE_LINKED_INTERFACE_MISMATCH)) {
			String validatorID = context.getDeployStatus().getValidatorID();
			DeployModelObject dmo = context.getDeployStatus().getDeployObject();
			if (IDeployCoreValidators.REFERENCE_INTERFACE_002.equals(validatorID)) {
				//The reference interface is null so test if the reference interface can be set.
				if (dmo instanceof DependencyLink) {
					Reference ref = (Reference) ((DependencyLink) dmo).getSource();
					return canSetInterface(ref);
				}
			} else if (IDeployCoreValidators.REFERENCE_INTERFACE_003.equals(validatorID)) {
				//The service interface is null so test if the service interface can be set.
				if (dmo instanceof DependencyLink) {
					Service service = (Service) ((DependencyLink) dmo).getTarget();
					return canSetInterface(service);
				}
			} else if (IDeployCoreValidators.REFERENCE_INTERFACE_001.equals(validatorID)) {
				if (dmo instanceof DependencyLink) {
					Reference ref = (Reference) ((DependencyLink) dmo).getSource();
					Service service = (Service) ((DependencyLink) dmo).getTarget();
					return canSetInterface(ref) || canSetInterface(service);
				}
			}
		}
		return false;
	}

	private boolean canSetInterface(Service service) {
		return service != null
				&& service.isPublicEditable(CorePackage.Literals.SERVICE__INTERFACE.getName())
				&& service.isMutable();
	}

	private boolean canSetInterface(Reference ref) {
		return ref != null
				&& ref.isPublicEditable(CorePackage.Literals.REFERENCE__INTERFACE.getName())
				&& ref.isMutable();
	}

}
