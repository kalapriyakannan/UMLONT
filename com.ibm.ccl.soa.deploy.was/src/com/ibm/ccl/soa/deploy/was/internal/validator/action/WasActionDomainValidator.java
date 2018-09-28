/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator.action;

import com.ibm.ccl.soa.deploy.core.validator.pattern.action.SignatureBasedActionDomainValidator;
import com.ibm.ccl.soa.deploy.was.WasPackage;

public class WasActionDomainValidator extends SignatureBasedActionDomainValidator {

	public WasActionDomainValidator() {
		super(WasPackage.eINSTANCE);

		addActionPreconditionTest(new FederateNodeIntoDmgrTest());
		addActionPreconditionTest(new CreateSharedLibraryForApplicationTest());
		addActionPreconditionTest(new PromoteServerToExistingClusterActionTest());
		addActionPreconditionTest(new PromoteServerToNewClusterActionTest());
		addActionPreconditionTest(new RefactorWasBaseSystemToNDActionTest());
		addActionPreconditionTest(new HostClusterOnCellWithNodeGroupActionTest());
		addActionPreconditionTest(new CreateNewServerInClusterActionTest());
	}

}
