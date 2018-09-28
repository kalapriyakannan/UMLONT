/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.internal.core.validator;

import java.util.List;

import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.IDomainValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Optional API of {@link IDomainValidators}.
 */
public interface InternalDomainValidator extends IDomainValidator {

	/**
	 * Enables domain validators to post-process statuses.
	 * <p>
	 * Note: this API will be subject to change in M5. Will include indexing support.
	 * 
	 * @param context
	 *           the deploy validation context.
	 * @param list
	 *           a mutable List<IDeployStatus>.
	 */
	public void filterStatusList(IDeployValidationContext context, List<IDeployStatus> list);

}
