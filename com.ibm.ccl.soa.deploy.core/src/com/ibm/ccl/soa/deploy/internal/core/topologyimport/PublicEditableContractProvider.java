/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.topologyimport;

import com.ibm.ccl.soa.deploy.core.ContractProvider;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.ExplicitContract;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Visibility;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;

/**
 * Creates instances of the {@link ExplicitContract} type.
 * 
 * @since 1.0
 * 
 */
public class PublicEditableContractProvider extends ContractProvider {

	public static final String ID = "com.ibm.ccl.soa.deploy.core.PublicEditableContract"; //$NON-NLS-1$ 

	@Override
	public void installContract(Topology topology) {
		ExplicitContract contract = CoreFactory.eINSTANCE.createExplicitContract();
		contract.setDefaultPolicy(Visibility.PUBLIC_EDITABLE_LITERAL);
		contract.setDefaultConceptualPolicy(Visibility.PUBLIC_EDITABLE_LITERAL);
		contract.setDisplayName(getDescriptor().getDisplayName());
		topology.setConfigurationContract(contract);
		UnitUtil.assignUniqueName(contract);
	}

}
