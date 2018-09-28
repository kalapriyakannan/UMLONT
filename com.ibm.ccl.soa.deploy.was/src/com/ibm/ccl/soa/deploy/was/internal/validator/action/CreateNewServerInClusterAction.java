/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator.action;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.internal.validator.matcher.WasLinkDescriptor;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;

/**
 * Action to create a new server hosted on a node and add it to an existing cluster. This action
 * will work as long as (see {@link CreateNewServerInClusterActionTest}):
 * <ul>
 * <li>the node is not a deployment manager node</li>
 * <li>the node is hosted on an ND system (if hosted on any system)</li>
 * <li>WAS version is defined on node and is less than that of the cluster</li>
 * <li>the cluster and node are not on/in different cells (will work if no cell is defined or if
 * only one is defined) </li>
 * <li>the nodegroup associated with the cluster/of which node is a member is the same node group
 * (will work if there is no node group</li>
 * </ul>
 */
public class CreateNewServerInClusterAction extends DeployResolution {

	private final List<DeployModelObject> _parameters;
	private final WasClusterUnit _cluster;
	private final WasNodeUnit _node;

	/**
	 * Constructor for resolution
	 * 
	 * @param context
	 *           the resolution context
	 * @param generator
	 *           the resolution generator creating this resolution
	 * @param message
	 *           the resolution message
	 */
	public CreateNewServerInClusterAction(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, String message, List<DeployModelObject> parameters) {
		super(context, generator, message);
		_parameters = parameters;
		_cluster = (WasClusterUnit) _parameters.get(0);
		_node = (WasNodeUnit) _parameters.get(1);
	}

	public IStatus resolve(IProgressMonitor monitor) {

		//create server based on was version and conceptuality of node/cluster
		// version is based on hosting container for the server: the node
		// conceptual if either the cluster or the node is
		boolean conceptual = _cluster.isConceptual() || _node.isConceptual();

		WasNode nodeCap = (WasNode) ValidatorUtils.getCapability(_node, WasPackage.Literals.WAS_NODE);
		if (null == nodeCap) {
			return Status.CANCEL_STATUS;
		}
		String version = nodeCap.getWasVersion();
		if (null == version) {
			return Status.CANCEL_STATUS;
		}

		String templateId = null;
		if (version.startsWith(WasUtil.WAS_5_MAIN_VERSION)) {
			templateId = conceptual ? IWasTemplateConstants.WAS_5_APPLICATION_SERVER_UNIT_CONCEPTUAL
					: IWasTemplateConstants.WAS_5_APPLICATION_SERVER_UNIT;
		} else if (version.startsWith(WasUtil.WAS_6_MAIN_VERSION)) {
			templateId = conceptual ? IWasTemplateConstants.WAS_6_APPLICATION_SERVER_UNIT_CONCEPTUAL
					: IWasTemplateConstants.WAS_6_APPLICATION_SERVER_UNIT;
		} else {
			return Status.CANCEL_STATUS;
		}

		DeployModelObject keyObject = ResolutionUtils.addFromTemplate(templateId, _cluster
				.getEditTopology());
		if (!WasPackage.Literals.WEBSPHERE_APP_SERVER_UNIT.isSuperTypeOf(keyObject.getEObject()
				.eClass())) {
			return Status.CANCEL_STATUS;
		}

		WebsphereAppServerUnit server = (WebsphereAppServerUnit) keyObject;

		// host server on node
		(new WasLinkDescriptor(LinkType.HOSTING, _node, server)).create();

		// add server to cluster
		(new WasLinkDescriptor(LinkType.MEMBER, _cluster, server)).create();

		return Status.OK_STATUS;
	}
}
