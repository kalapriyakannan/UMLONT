/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator.action;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.CapabilityUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.ResolutionUtils;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.was.IWasTemplateConstants;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasClusterUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WebsphereAppServerUnit;
import com.ibm.ccl.soa.deploy.was.util.WasUtil;

/**
 * Action to create a new WAS cluster using a particular server as a template. For conditions under
 * which this can be done, see {@link PromoteServerToNewClusterActionTest}
 */
public class PromoteServerToNewClusterAction extends DeployResolution {

	private final List<DeployModelObject> _parameters;
	private final WebsphereAppServerUnit _server;

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
	public PromoteServerToNewClusterAction(IDeployResolutionContext context,
			IDeployResolutionGenerator generator, String message, List<DeployModelObject> parameters) {
		super(context, generator, message);
		_parameters = parameters;
		_server = (WebsphereAppServerUnit) _parameters.get(0);
	}

	public IStatus resolve(IProgressMonitor monitor) {

		//create cluster based on was version and conceptuality
		// prefer to use the cell version if we can find it; otherwise use the server version

		//retrieve Cell of the server node if present
		WasCellUnit cell = null;

		WasNodeUnit node = (WasNodeUnit) ValidatorUtils.discoverHost(_server,
				WasPackage.Literals.WAS_NODE_UNIT, monitor);
		if (null != node) {
			List<Unit> cells = ValidatorUtils.discoverGroupsByUnitType(node,
					WasPackage.Literals.WAS_CELL_UNIT, context.getTopology(), monitor);
			for (int i = 0; i < cells.size(); i++) {
				WasCell cellCap = (WasCell) ValidatorUtils.getCapability(cells.get(i),
						WasPackage.Literals.WAS_CELL);
				if (null == cellCap) {
					continue;
				}
				if (cellCap.isIsDistributed()) {
					cell = (WasCellUnit) cells.get(i);
					break;
				}
			}
		}

		String templateId = null;
		if (null != cell) {
			Object version = CapabilityUtil.getAttributeFromUnitCapability(cell,
					WasPackage.Literals.WAS_CELL__WAS_VERSION, WasPackage.Literals.WAS_CELL);
			templateId = getTemplateId(version, cell.isConceptual());
		} else {
			Object version = CapabilityUtil.getAttributeFromUnitCapability(_server,
					WasPackage.Literals.WAS_SERVER__WAS_VERSION, WasPackage.Literals.WAS_SERVER);
			templateId = getTemplateId(version, _server.isConceptual());
		}

		if (null == templateId) {
			return Status.CANCEL_STATUS;
		}

		WasClusterUnit cluster = (WasClusterUnit) ResolutionUtils.addFromTemplate(templateId, _server
				.getEditTopology());

		if (null != cell) {
			//host cluster on Cell
			ResolutionUtils.host(cell, cluster);
		}

		//host most things that are hosted on the server on the cluster
		List<Unit> hostedUnits = ValidatorUtils.discoverHosted(_server, context.getProgressMonitor());
		for (Iterator<Unit> iterator = hostedUnits.iterator(); iterator.hasNext();) {
			Unit hosted = iterator.next();
			EClass hostedType = hosted.getEObject().eClass();
			if (OsPackage.Literals.PORT_CONFIG_UNIT.isSuperTypeOf(hostedType)
					|| WasPackage.Literals.WAS_CLASS_LOADER_CONFIGURATION_UNIT.isSuperTypeOf(hostedType)) {
				// don't rehost these
				continue;
			}
			ResolutionUtils.unhost(_server, hosted);
			ResolutionUtils.host(cluster, hosted);
		}

		// Add node to server to cluster
		ResolutionUtils.group(cluster, _server);
		return Status.OK_STATUS;
	}

	private String getTemplateId(Object version, boolean conceptual) {
		String templateId = null;

		if (null == version) {
			return null;
		}
		String v = (String) version;

		if (v.startsWith(WasUtil.WAS_5_MAIN_VERSION)) {
			templateId = conceptual ? IWasTemplateConstants.WAS_5_CLUSTER_UNIT_CONCEPTUAL
					: IWasTemplateConstants.WAS_5_CLUSTER_UNIT;
		} else if (v.startsWith(WasUtil.WAS_6_MAIN_VERSION)) {
			templateId = conceptual ? IWasTemplateConstants.WAS_6_CLUSTER_UNIT_CONCEPTUAL
					: IWasTemplateConstants.WAS_6_CLUSTER_UNIT;
		} else {
			// do nothing; return null
		}

		return templateId;
	}
}
