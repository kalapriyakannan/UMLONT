/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.internal.provider;

public class J2EEVersionUtil implements J2EEVersionConstants {

	public static String getServletTextVersion(int aServletVersion) {
		switch (aServletVersion)
		{
		case SERVLET_2_2:
			return VERSION_2_2_TEXT;
		case SERVLET_2_3:
			return VERSION_2_3_TEXT;
		case SERVLET_2_4:
			return VERSION_2_4_TEXT;
		default:
			return VERSION_NONE_TEXT;
		}
	}

	public static String getEJBTextVersion(int anEJBVersion) {
		switch (anEJBVersion)
		{
		case EJB_1_1_ID:
			return VERSION_1_1_TEXT;
		case EJB_2_0_ID:
			return VERSION_2_0_TEXT;
		case EJB_2_1_ID:
			return VERSION_2_1_TEXT;
		default:
			return VERSION_NONE_TEXT;
		}
	}

	public static String getJCATextVersion(int aJCAVersion) {
		switch (aJCAVersion)
		{
		case JCA_1_0_ID:
			return VERSION_1_0_TEXT;
		case JCA_1_5_ID:
			return VERSION_1_5_TEXT;
		default:
			return VERSION_NONE_TEXT;
		}
	}

	public static String getJSPTextVersion(int aJSPVersion) {
		switch (aJSPVersion)
		{
		case JSP_1_1_ID:
			return VERSION_1_1_TEXT;
		case JSP_1_2_ID:
			return VERSION_1_2_TEXT;
		case JSP_2_0_ID:
			return VERSION_2_0_TEXT;
		default:
			return VERSION_NONE_TEXT;
		}
	}

	public static String getJ2EETextVersion(int aJ2EEVersion) {
		switch (aJ2EEVersion)
		{
		case J2EE_1_2_ID:
			return VERSION_1_2_TEXT;
		case J2EE_1_3_ID:
			return VERSION_1_3_TEXT;
		case J2EE_1_4_ID:
			return VERSION_1_4_TEXT;
		default:
			return VERSION_NONE_TEXT;
		}
	}

	public static int convertAppClientVersionToJ2EEVersion(String anAppClientVersion) {
		if (anAppClientVersion.equals(VERSION_1_2_TEXT))
			return J2EE_1_2_ID;
		if (anAppClientVersion.equals(VERSION_1_3_TEXT))
			return J2EE_1_3_ID;
		if (anAppClientVersion.equals(VERSION_1_4_TEXT))
			return J2EE_1_4_ID;
		// default
		return J2EE_1_4_ID;
	}

	public static int convertEJBVersionToJ2EEVersion(String anEJBVersion) {
		if (anEJBVersion.equals(VERSION_1_1_TEXT))
			return J2EE_1_2_ID;
		if (anEJBVersion.equals(VERSION_2_0_TEXT))
			return J2EE_1_3_ID;
		if (anEJBVersion.equals(VERSION_2_1_TEXT))
			return J2EE_1_4_ID;
		// default
		return J2EE_1_4_ID;
	}

	public static int convertEJBVersionToJ2EEVersion(int anEJBVersion) {
		switch (anEJBVersion)
		{
		case EJB_1_1_ID:
			return J2EE_1_2_ID;
		case EJB_2_0_ID:
			return J2EE_1_3_ID;
		case EJB_2_1_ID:
			return J2EE_1_4_ID;
		}
		// default
		return J2EE_1_4_ID;
	}

	public static int convertServletVersionToJ2EEVersion(String aServletVersion) {
		if (aServletVersion.equals(VERSION_2_2_TEXT))
			return J2EE_1_2_ID;
		if (aServletVersion.equals(VERSION_2_3_TEXT))
			return J2EE_1_3_ID;
		if (aServletVersion.equals(VERSION_2_4_TEXT))
			return J2EE_1_4_ID;
		// default
		return J2EE_1_4_ID;
	}

	public static int convertServletVersionToJ2EEVersion(int aServletVersion) {
		switch (aServletVersion)
		{
		case SERVLET_2_2:
			return J2EE_1_2_ID;
		case SERVLET_2_3:
			return J2EE_1_3_ID;
		case SERVLET_2_4:
			return J2EE_1_4_ID;
		}
		// default
		return J2EE_1_4_ID;
	}

	public static int convertJCAVersionToJ2EEVersion(int aJcaVersion) {
		switch (aJcaVersion)
		{
		case JCA_1_0_ID:
			return J2EE_1_3_ID;
		case JCA_1_5_ID:
			return J2EE_1_4_ID;
		}
		// default
		return J2EE_1_4_ID;
	}

	public static int convertJCAVersionToJ2EEVersion(String aJCAVersion) {
		if (aJCAVersion.equals(VERSION_1_0_TEXT))
			return J2EE_1_3_ID;
		if (aJCAVersion.equals(VERSION_1_5_TEXT))
			return J2EE_1_4_ID;
		// default
		return J2EE_1_4_ID;
	}

	public static int convertJ2EEVersionToEJBVersion(int aJ2EEVersion) {
		switch (aJ2EEVersion)
		{
		case J2EE_1_2_ID:
			return EJB_1_1_ID;
		case J2EE_1_3_ID:
			return EJB_2_0_ID;
		case J2EE_1_4_ID:
			return EJB_2_1_ID;
		}
		// default
		return EJB_2_1_ID;
	}

	public static int convertJ2EEVersionToServletVersion(int aJ2EEVersion) {
		switch (aJ2EEVersion)
		{
		case J2EE_1_2_ID:
			return SERVLET_2_2;
		case J2EE_1_3_ID:
			return SERVLET_2_3;
		case J2EE_1_4_ID:
			return SERVLET_2_4;
		}
		// default
		return WEB_2_4_ID;
	}

	public static int convertJ2EEVersionToJSPVersion(int aJ2EEVersion) {
		switch (aJ2EEVersion)
		{
		case J2EE_1_2_ID:
			return JSP_1_1_ID;
		case J2EE_1_3_ID:
			return JSP_1_2_ID;
		case J2EE_1_4_ID:
			return JSP_2_0_ID;
		}
		// default
		return WEB_2_4_ID;
	}

	public static int convertJ2EEVersionToJCAVersion(int aJ2EEVersion) {
		switch (aJ2EEVersion)
		{
		case J2EE_1_3_ID:
			return JCA_1_0_ID;
		case J2EE_1_4_ID:
			return JCA_1_5_ID;
		}
		// default
		return JCA_1_5_ID;
	}

	public static int convertVersionToInt(String version) {
		int nVersion = 0;

		if (version.equals(VERSION_1_0_TEXT))
			nVersion = VERSION_1_0;

		else if (version.equals(VERSION_1_1_TEXT))
			nVersion = VERSION_1_1;

		else if (version.equals(VERSION_1_2_TEXT))
			nVersion = VERSION_1_2;

		else if (version.equals(VERSION_1_3_TEXT))
			nVersion = VERSION_1_3;

		else if (version.equals(VERSION_1_4_TEXT))
			nVersion = VERSION_1_4;

		else if (version.equals(VERSION_1_5_TEXT))
			nVersion = VERSION_1_5;

		else if (version.equals(VERSION_2_0_TEXT))
			nVersion = VERSION_2_0;

		else if (version.equals(VERSION_2_1_TEXT))
			nVersion = VERSION_2_1;

		else if (version.equals(VERSION_2_2_TEXT))
			nVersion = VERSION_2_2;

		else if (version.equals(VERSION_2_3_TEXT))
			nVersion = VERSION_2_3;

		else if (version.equals(VERSION_2_4_TEXT))
			nVersion = VERSION_2_4;

		else if (version.equals(VERSION_2_5_TEXT))
			nVersion = VERSION_2_5;

		return nVersion;
	}

	public static String convertVersionToString(int version) {
		switch (version)
		{
		case VERSION_1_0:
			return VERSION_1_0_TEXT;
		case VERSION_1_1:
			return VERSION_1_1_TEXT;
		case VERSION_1_2:
			return VERSION_1_2_TEXT;
		case VERSION_1_3:
			return VERSION_1_3_TEXT;
		case VERSION_1_4:
			return VERSION_1_4_TEXT;
		case VERSION_1_5:
			return VERSION_1_5_TEXT;
		case VERSION_2_0:
			return VERSION_2_0_TEXT;
		case VERSION_2_1:
			return VERSION_2_1_TEXT;
		case VERSION_2_2:
			return VERSION_2_2_TEXT;
		case VERSION_2_3:
			return VERSION_2_3_TEXT;
		case VERSION_2_4:
			return VERSION_2_4_TEXT;
		case VERSION_2_5:
			return VERSION_2_5_TEXT;
		default:
			return null;
		}
	}

}
