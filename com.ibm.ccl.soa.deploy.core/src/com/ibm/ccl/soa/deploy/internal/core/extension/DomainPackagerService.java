/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import java.util.ArrayList;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.DomainPackager;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.extension.IDomainPackagerDescriptor;
import com.ibm.ccl.soa.deploy.core.extension.IDomainPackagerService;

/**
 * Provides a concrete implementation of IDomainPackagerService.
 * 
 * @since 1.0
 * 
 */
public class DomainPackagerService implements IDomainPackagerService {

	private static final DomainPackagerDescriptor[] NO_DOMAINPACKAGERS = new DomainPackagerDescriptor[0];

	public IDomainPackagerDescriptor[] findDomainPackagers(Unit anInput) {
		DomainDescriptor[] domainDescr = DomainManager.INSTANCE.findDomainDescriptors(anInput);
		List descList = new ArrayList();
		for (int i = 0; i < domainDescr.length; i++) {
			DomainPackagerDescriptor desc = domainDescr[i].getDomainPackagerDescriptor();
			if (desc != null) {
				descList.add(desc);
			}
		}
		if (descList.size() == 0) {
			return NO_DOMAINPACKAGERS;
		}
		return (DomainPackagerDescriptor[]) descList.toArray(new DomainPackagerDescriptor[descList
				.size()]);
	}

	/**
	 * Create an instance of the domain packager using the descriptor
	 * 
	 * @param aDescriptor
	 *           the domain packager descriptor to be used to create the instance of the domain
	 *           packager
	 * @return the instance of the domain packager
	 */
	public DomainPackager createDomainPackager(IDomainPackagerDescriptor aDescriptor) {
		return aDescriptor.createDomainPackager();

	}
}
