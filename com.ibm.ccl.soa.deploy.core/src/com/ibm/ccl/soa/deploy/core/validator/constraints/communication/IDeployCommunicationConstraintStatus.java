/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.constraints.communication;

import java.util.List;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Status associated with a communication constraint.
 */
public interface IDeployCommunicationConstraintStatus extends IDeployStatus {

	public Unit getSource();

	public Unit getTarget();

	public String getTypeDescription();

	public List<Constraint> getCandidateConstaints();

	public void setStatusMap(StatusMap statusMap);

	public StatusMap getStatusMap();

}
