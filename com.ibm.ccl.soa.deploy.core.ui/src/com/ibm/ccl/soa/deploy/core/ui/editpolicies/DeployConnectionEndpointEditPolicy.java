/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.editpolicies;

import java.util.Collections;
import java.util.List;

import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;

import com.ibm.ccl.soa.deploy.core.ui.editparts.ConsolidationLinkEditPart;
import com.ibm.ccl.soa.deploy.core.ui.requests.RequestConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.SelectionUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.SelectionUtils.FadingData;

/**
 * 
 * Created on Oct 18, 2004
 * 
 * @author tonychau
 * 
 */
public class DeployConnectionEndpointEditPolicy extends ConnectionEndpointEditPolicy implements
		RequestConstants {

	private FadingData fadingData = null;

	protected void showSelection() {
		super.showSelection();
		fadingData = SelectionUtils.showSelectionFeedback((AbstractGraphicalEditPart) getHost());
	}

	protected void hideSelection() {
		super.hideSelection();
		SelectionUtils.hideSelectionFeedback((AbstractGraphicalEditPart) getHost());
		fadingData = null;
	}

	/**
	 * fade figures
	 */
	public void showFadeFeedback() {
		if (fadingData != null) {
			SelectionUtils.showFadeFeedback((AbstractGraphicalEditPart) getHost(), fadingData);
		}
	}

	protected List createSelectionHandles() {
		if (this.getHost() instanceof ConsolidationLinkEditPart) {
			return Collections.EMPTY_LIST;
		}
		return super.createSelectionHandles();
	}

}
