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
import java.util.List;
import java.util.Properties;

import com.ibm.ccl.soa.deploy.asc.ASCConstants;
import com.ibm.ccl.soa.deploy.asc.ASCUtil;
import com.ibm.ccl.soa.deploy.asc.exception.ASCException;
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;

/**
 * UnitProvider Contribution: WasCellUnitProvider It creates {@link ASCConstants#TASK_FEDERATE_NODE}
 * and {@link ASCConstants#TASK_START_NODE} asc task for every installed node contained in
 * {@link WasCellUnit}.
 * 
 * @see WasCell
 * @see WasCellUnit
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */
public class WasCellUnitProvider extends WasComponentUnitProvider {

	/**
	 * No tasks for WAS Cell in WAS Base, so do nothing here.
	 */
	public void initTasks_Base() throws ASCException {
		ascTaskName = new String[0];
		ascProps = new Properties[0];

	}

	public void initTasks_ND() throws ASCException {
		List managedNode = ASCUtil.findAllInstalledManagedNode((WasCellUnit) unit);
		ascTaskName = new String[managedNode.size() * 2];
		ascProps = new Properties[managedNode.size() * 2];
		Iterator nIt = managedNode.iterator();
		int i = 0;
		while (nIt.hasNext()) {
			WasNodeUnit wasNodeUnit = (WasNodeUnit) nIt.next();
			ascTaskName[i] = ASCConstants.TASK_FEDERATE_NODE;
			ascTaskName[i + 1] = ASCConstants.TASK_START_NODE;
			ascProps[i] = initFederateNode(wasNodeUnit, (WasCellUnit) unit);
			ascProps[i + 1] = createStartNodeProps(wasNodeUnit);
			i = i + 2;
		}
	}
}
