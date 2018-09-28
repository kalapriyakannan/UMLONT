/***************************************************************************************************
 * Copyright (c) 2008 IBM Corporation. All rights reserved.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.j2ee;

import com.ibm.ccl.soa.deploy.core.extension.IResourceTypeService;

/**
 * Template IDs for the Java Enterprise Edition plug-in to be used with the
 * {@link IResourceTypeService}.
 * 
 */
public interface IJ2EETemplateConstants {

	public static final String WEB_COMPONENT = "j2ee.WebComponent.infra"; //$NON-NLS-1$;
	public static final String WEB_COMPONENT_CONCEPTUAL = "j2ee.WebComponent.conceptual"; //$NON-NLS-1$;

	public static final String EJB_COMPONENT = "j2ee.EJBComponent.infra"; //$NON-NLS-1$;
	public static final String EJB_COMPONENT_CONCEPTUAL = "j2ee.EJBComponent.conceptual"; //$NON-NLS-1$;

	public static final String EAR_COMPONENT = "j2ee.EARComponent.infra"; //$NON-NLS-1$;
	public static final String EAR_COMPONENT_CONCEPTUAL = "j2ee.EARComponent.conceptual"; //$NON-NLS-1$;

	public static final String UTILITY_COMPONENT = "j2ee.UtilityComponent.infra"; //$NON-NLS-1$;
	public static final String UTILITY_COMPONENT_CONCEPTUAL = "j2ee.UtilityComponent.conceptual"; //$NON-NLS-1$;

	public static final String J2EE_SERVER_CONCEPTUAL = "j2ee.J2eeServer.conceptual"; //$NON-NLS-1$;
	public static final String J2EE_SERVER_13_CONCEPTUAL = "j2ee.J2ee13Server.conceptual"; //$NON-NLS-1$;
	public static final String J2EE_SERVER_14_CONCEPTUAL = "j2ee.J2ee14Server.conceptual"; //$NON-NLS-1$;
	public static final String ENTITY_SERVICE = "j2ee.EntityService"; //$NON-NLS-1$;
	public static final String SESSION_SERVICE = "j2ee.SessionService"; //$NON-NLS-1$;
	public static final String WEB_SERVICE = "web.WebService"; //$NON-NLS-1$;
	public static final String URL_SERVICE = "web.URLService"; //$NON-NLS-1$;
}
