/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ui.marker.quickfix.MarkerResolutionHelper;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Utility class collecting miscellaneous static methods.
 * 
 * @author snible@us.ibm.com
 */
public class SoaDeployUiUtil {

	private static final String NEW_LINE = "\n"; //$NON-NLS-1$

	/**
	 * Get marker resolutions associated with a model object.
	 * 
	 * @param dmo
	 *           a Deploy Model Object, possibly with error status
	 * @return a List of IMarkerResolution related to dmo
	 */
	public static List getResolutions(DeployModelObject dmo) {
		IMarker[] markers = getMarkers(dmo).toArray(new IMarker[0]);
		MarkerResolutionHelper mrh = new MarkerResolutionHelper(markers);
		return Arrays.asList(mrh.getResolutions());
	}

	/**
	 * Get markers associated with a model object.
	 * 
	 * @param dmo
	 *           a Deploy Model Object, possibly with error status
	 * @return a List of IMarker related to dmo
	 */
	public static List<IMarker> getMarkers(DeployModelObject dmo) {
		List<IMarker> retVal = new LinkedList<IMarker>();
		addMarkers(dmo.getStatus(), retVal);
		return retVal;
	}

	/**
	 * Add the IMarkers associated with a status to outList. RECURSIVE.
	 */
	private static void addMarkers(IStatus status, List outList) {
		if (status instanceof MultiStatus) {
			MultiStatus ms = (MultiStatus) status;
			for (int i = 0; i < ms.getChildren().length; i++) {
				addMarkers(ms.getChildren()[i], outList);
			}
		} else if (status instanceof IDeployStatus) {
			// Deployment Model Objects have a special synthetic status
			// that knows about associated markers
			IDeployStatus deployStatus = (IDeployStatus) status;
			IMarker marker = deployStatus.getMarker();
			if (marker != null && !outList.contains(marker)) {
				outList.add(marker);
			}
		}
	}

	/**
	 * Given a Status, generate a message suitable for a tooltip. Based on MarkerFigure.getMessage(),
	 * but that was private and non-static.
	 * 
	 * @param status
	 *           The status to consider
	 * @return a message
	 */
	public static String getStatusMessage(IStatus status) {
		if (status.isMultiStatus()) {
			String message = null;
			IStatus[] children = status.getChildren();
			for (int x = 0; x < children.length; ++x) {
				if (x == 5) {
					break; // show 5 messages
				}
				if (x == 0) {
					message = children[x].getMessage();
				} else {
					message += NEW_LINE + children[x].getMessage();
				}
			}
			return message;
		}
		return status.getMessage();
	}

}
