/***************************************************************************************************
 * Copyright (c) 2003, 2008 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.ui.validator.resolution;

import com.ibm.ccl.soa.deploy.core.RealizationLink;

/**
 * Classes must implement RealizationMapperView to be driven by {@link RealizationMapHelper}
 * realization mapping UIs.
 * 
 * @since 7.0
 * @see RealizationMapHelper
 */
public interface RealizationMapperView {

	/**
	 * Refresh the list of realizations created in this {@link RealizationMapHelper} session.
	 */
	void refreshRealizationLinks();

	/**
	 * Highlight a link in the list of links created in this session
	 * 
	 * @param realizationLink
	 */
	void selectRealizationLink(RealizationLink realizationLink);

	/**
	 * Refresh source unit display (for example, after {@link RealizationMapHelper} has removed a
	 * choice.
	 */
	void refreshSourceUnits();

	/**
	 * Refresh detail display.
	 */
	void refreshUnrealCount();

//	/**
//	 * {@link RealizationMapUtil} uses this for possibly long-running operations.  UI code SHOULD run the code with
//	 * an indication such as hourglass cursor.
//	 * 
//	 * @param runnable
//	 */
//	void runWithBusyIndication(Runnable runnable);

}
