/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tests.core.ui.marker.resolution;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.ui.IMarkerResolution;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.ui.marker.quickfix.MarkerResolutionHelper;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployMarker;

/**
 * Extends the Topology test case with resolution utility methods.
 */
public class ResolutionTestCase extends TopologyTestCase {

	public ResolutionTestCase(String name) {
		super(name);
	}

	/**
	 * @return the validator service used for testing.
	 */
	protected DeployValidatorService getValidatorService() {
		return DeployValidatorService.getDefaultValidatorService();
	}

	/**
	 * Returns the all deploy resolutions of the specified type on the status.
	 * 
	 * @param status
	 *            a deployment status.
	 * @param resolutionType
	 *            the type of resolution required.
	 * @return an array of resolutions of type resolutionType (never null).
	 */
	protected IDeployResolution[] getDeployResolutions(IStatus status,
			Class resolutionType) {
		DeployValidatorService validator = getValidatorService();
		List<IDeployResolution> rList = validator.getResolutions(status);
		IDeployResolution[] resolutions = rList.toArray(new IDeployResolution[rList.size()]);
		if (resolutions.length == 0) {
			return resolutions;
		}
		if (resolutions.length == 1) {
			if (resolutionType.isInstance(resolutions[0])) {
				return resolutions;
			}
			return new IDeployResolution[0];
		}
		List<IDeployResolution> list = new ArrayList<IDeployResolution>(resolutions.length);
		for (int i = 0; i < resolutions.length; i++) {
			if (resolutionType.isInstance(resolutions[i])) {
				list.add(resolutions[i]);
			}
		}
		return list.toArray(new IDeployResolution[list
				.size()]);
	}

	/**
	 * Dumps all markers and resolutions on the markers for the object.
	 * 
	 * @param object
	 *            a deploy object.
	 * @return the dump as a string.
	 */
	protected String dumpResolutions(DeployModelObject object) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("*** marker resolutions for ");
		buffer.append(object.getName());
		for (Iterator iter = findDeployStatus(object); iter.hasNext();) {
			IMarker marker = ((IDeployStatus) iter.next()).getMarker();
			buffer.append("\n");
			buffer.append(DeployMarker.toString(marker));
			MarkerResolutionHelper helper = new MarkerResolutionHelper(
					new IMarker[] { marker });
			IMarkerResolution[] resolutions = helper.getResolutions();
			for (int i = 0; i < resolutions.length; i++) {
				buffer.append("\n  [");
				buffer.append(i);
				buffer.append("] = ");
				buffer.append(resolutions[i].getLabel());
			}
		}
		buffer.append("\n");

		System.out.println(buffer.toString());
		return buffer.toString();
	}
}
