/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.asc.exception;

import org.eclipse.osgi.util.NLS;

/**
 * This is the provider of all exception and log messages for i18n use
 * 
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */
public class ASCExceptionMsg extends NLS {
	private static final String BUNDLE_NAME = "com.ibm.ccl.soa.deploy.asc.exception.messages"; //$NON-NLS-1$

	public static String LOG_UNIT_INSTALLED;

	public static String PROFILE_MISSING_SERVER;

	public static String INVALID_SCOPE;

	public static String TASK_CREATE_FAILED;

	public static String ZIP_FILE_FAILED;

	public static String BUILDFILE_CREATE_FAILED;

	public static String SOLUTIONFILE_CREATE_FAILED;

	public static String NO_PROVIDER_FOUND;

	public static String HOST_NOT_FOUND;

	public static String NULL_PROPERTY_FOUND;

	public static String NO_SUPPORTE_PROPERTY_SETTING;

	public static String LOG_UNIT_IGNOERED;

	public static String LOG_COND_FAILED;

	// --------------for log use-------------------
	public static String LOG_NULL_PROP = null;

	public static String LOG_MARK_DIRTY = null;

	public static String LOG_Exception = null;

	public static String LOG_UNIT_SUCCESS = null;

	public static String LOG_UNIT_ERROR = null;

	public static String LOG_TASK_ERROR = null;

	public static String LOG_TASK_SUCCESS = null;

	public static String LOG_ENTRY_UNIT = null;

	public static String LOG_TOTAL_DIRTY = null;

	public static String LOG_TOTAL_TASK = null;

	public static String LOG_TOTAL_PROPERTY = null;

	public static String LOG_END_ERROR = null;

	public static String LOG_END_SUCCESS = null;

	static {
		NLS.initializeMessages(BUNDLE_NAME, ASCExceptionMsg.class);
	}
}
