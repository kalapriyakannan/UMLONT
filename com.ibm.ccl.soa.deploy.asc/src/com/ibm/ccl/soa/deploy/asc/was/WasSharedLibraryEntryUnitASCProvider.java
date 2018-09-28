/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.asc.was;

import java.util.Iterator;
import java.util.Properties;

import com.ibm.ccl.soa.deploy.asc.ASCConstants;
import com.ibm.ccl.soa.deploy.asc.exception.ASCException;
import com.ibm.ccl.soa.deploy.core.util.CapabilityUtil;
import com.ibm.ccl.soa.deploy.was.SharedLibraryEntry;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSharedLibraryEntryUnit;

/**
 * UnitProvider Contribution: WasSharedLibraryEntryUnitASCProvider It create
 * {@link ASCConstants#TASK_SET_SHARED_LIBRARY} for {@link WasSharedLibraryEntryUnit}
 * 
 * @see SharedLibraryEntry
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 */
public class WasSharedLibraryEntryUnitASCProvider extends WASASCProvider {

	protected void initTasks_Base() throws ASCException {
		ascTaskName = new String[] { ASCConstants.TASK_SET_SHARED_LIBRARY };
		Properties setLib = new Properties();
		ascProps = new Properties[] { setLib };
		setEnvProp(setLib);

		SharedLibraryEntry libCap = (SharedLibraryEntry) CapabilityUtil.findCapabilityOfType(unit,
				WasPackage.eINSTANCE.getSharedLibraryEntry());
		String classPath = ""; //$NON-NLS-1$
		for (Iterator index = libCap.getClassPath().iterator(); index.hasNext();) {
			classPath += (String) index.next();
		}
		super.setAscProperty(setLib, ASCConstants.WAS_LIB_CLASS_PATH, classPath);
		super.setAscProperty(setLib, ASCConstants.WAS_LIB_NAME, libCap.getSharedLibraryEntryName());
		super.setASCAgentProp(setLib);
	}

}
