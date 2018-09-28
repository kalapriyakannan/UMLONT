/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.db2.internal.validator.resolution;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueSourceStatus;
import com.ibm.ccl.soa.deploy.db2.internal.validator.IDB2ValidatorID;

/**
 * Generates a special case resolution for propagating a user password to the db2 instance admin
 * password field Resolution description does not display the value; it just displays the source
 * title with context
 */
public class PropagatePasswordResolutionGenerator extends DeployResolutionGenerator {

	/*
	 * @see org.eclipse.ui.IMarkerResolutionGenerator2#hasResolutions(org.eclipse.core.resources.IMarker)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {
		if (!IDB2ValidatorID.DB2_INSTANCE_UNIT_USER_PASSWORD_FROM_USER_001.equals(context
				.getDeployStatus().getValidatorID())) {
			return false;
		}
		if (context.getDeployStatus() instanceof IDeployAttributeValueSourceStatus) {
			IDeployAttributeValueSourceStatus s = (IDeployAttributeValueSourceStatus) context
					.getDeployStatus();
			if (!DeployModelObjectUtil.isSettable(s.getDeployObject(), s.getAttributeShortName())) {
				return false;
			}
		} else {
			return false;
		}

		return true;
	}

	/*
	 * @see org.eclipse.ui.IMarkerResolutionGenerator#getResolutions(org.eclipse.core.resources.IMarker)
	 */
	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		if (!hasResolutions(context)) {
			return new IDeployResolution[0];
		}

		if (context.getDeployStatus() == null || context.getDeployStatus().getDeployObject() == null
				|| !(context.getDeployStatus().getDeployObject() instanceof Capability)) {
			return new IDeployResolution[0];
		}
		Capability cap = (Capability) context.getDeployStatus().getDeployObject();
		Unit unit = (Unit) cap.getParent();
		IDeployResolution[] idr = new IDeployResolution[1];
		idr[0] = new PropagatePasswordResolution(context, this, unit);

		return idr;
	}

//	private Topology getTopology() {
//		  if (ResourceUtils.getActiveEditorPart() instanceof DiagramEditor) {
//		   DiagramEditor de = (DiagramEditor) ResourceUtils.getActiveEditorPart();
//		   DiagramEditPart dep = de.getDiagramEditPart();
//		   View view = (View) dep.getModel();
//		   if (view.getElement() instanceof Topology) {
//		    return (Topology) view.getElement();
//		   }
//		  }
//		  
//		  return null;
//		 }

}
