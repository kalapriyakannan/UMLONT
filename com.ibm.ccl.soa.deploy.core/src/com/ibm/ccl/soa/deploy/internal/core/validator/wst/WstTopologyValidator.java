/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.wst;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jem.util.emf.workbench.WorkbenchResourceHelperBase;
import org.eclipse.osgi.util.NLS;
import org.eclipse.wst.validation.internal.provisional.core.IReporter;
import org.eclipse.wst.validation.internal.provisional.core.IValidationContext;
import org.eclipse.wst.validation.internal.provisional.core.IValidator;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployMarker;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployValidationContext;

/**
 * Supports invocation of the SOA deploy validator service from the WST validator.
 * <p>
 * Referenced by the WST org.eclipse.wst.validation.validator< extension point in plugin.xml.
 * 
 * @see IValidator
 * @see DeployValidatorService#validate(Topology)
 */
@SuppressWarnings("restriction")
// @Jazz("1550")
public class WstTopologyValidator implements IValidator {

	/**
	 * A deploy reporter storing statuses in a set.
	 */
	public class SetReporter implements IDeployReporter {

		protected final Set<IDeployStatus> statusSet = new LinkedHashSet<IDeployStatus>();

		/**
		 * Clears the statuses collected.
		 */
		public void clear() {
			statusSet.clear();
		}

		/*
		 * @see com.ibm.ccl.soa.deploy.core.validator.IDeployReporter#addStatus(com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus)
		 */
		public void addStatus(IDeployStatus status) {
			if (status == null) {
				return;
			}
			statusSet.add(status);
		}

		/**
		 * @return a collection of statuses reported.
		 */
		public Set<IDeployStatus> getStatuses() {
			return Collections.unmodifiableSet(statusSet);
		}
	}

	/*
	 * @see org.eclipse.wst.validation.internal.provisional.core.IValidator#cleanup(org.eclipse.wst.validation.internal.provisional.core.IReporter)
	 */
	public void cleanup(IReporter reporter) {
	}

	/*
	 * @see org.eclipse.wst.validation.internal.provisional.core.IValidator#validate(org.eclipse.wst.validation.internal.provisional.core.IValidationContext,
	 *      org.eclipse.wst.validation.internal.provisional.core.IReporter)
	 */
	@SuppressWarnings("restriction")
	// @Jazz("1550")
	public void validate(IValidationContext helper, IReporter reporter) {
		WstTopologyValidatorWorkbenchContext topologyHelper = (WstTopologyValidatorWorkbenchContext) helper;
		IResource[] resources = topologyHelper.getResources();
		DeployValidatorService validator = topologyHelper.getDeployValidatorService();
		NullProgressMonitor monitor = new NullProgressMonitor();
		SetReporter deployReporter = new SetReporter();
		for (int i = 0; i < resources.length; i++) {

			if (reporter.isCancelled()) {
				break;
			}
			try {
				Resource res = WorkbenchResourceHelperBase.getResource((IFile) resources[i]);
				if (res != null) {
					res.load(Collections.EMPTY_MAP);
					DeployCoreRoot deployCoreRoot = (DeployCoreRoot) res.getContents().get(0);
					Topology topology = deployCoreRoot.getTopology();
					DeployValidationContext context = new DeployValidationContext(topology, validator,
							monitor);
					try {
						deployReporter.clear();
						// Validate the topology
						validator.validate(context, deployReporter);

						// Add the statuses to the topology
						for (IDeployStatus status : deployReporter.getStatuses()) {
							if (status != null && status.getDeployObject() != null) {
								status.getDeployObject().addStatus(status);
							}
						}

						// Create the markers
						SubMonitor submonitor = SubMonitor.convert(monitor);
						DeployMarker.createMarkers(topology, submonitor);
					} catch (Exception e) {
						DeployCorePlugin.logError(0, DeployCoreMessages.Deploy_validation_failed, e);
					}
				} else {
					// Can't validate a null resource. Log.
					// TODO why is resource null?
					String message = NLS.bind(DeployCoreMessages.Validation_error_opening_resource_0,
							null);
					DeployCorePlugin.logError(0, message, null);
				}
			} catch (IOException e) {
				String message = NLS.bind(DeployCoreMessages.Validation_error_opening_resource_0,
						resources[i].getName());
				throw new RuntimeException(message, e);
			}
		}
	}
}
