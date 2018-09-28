/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.extension;

import com.ibm.ccl.soa.deploy.core.DomainPackager;
import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * Provides a management layer for <b>com.ibm.ccl.soa.deploy.core.domain/packager</b> extensions.
 * 
 * <p>
 * This interface is not intended to be implemented by clients.
 * </p>
 */
public interface IDomainPackagerService {

	/**
	 * Return an array of DomainPackagerDescriptor that can potentially package input {@link Unit}.
	 * The domain packager is contributed per domain. Multiple domains can provide packaging content
	 * for the same unit.
	 * 
	 * @param anInput
	 *           A unit for which packager needs to be found
	 * @return an array of IDomainPackagerDescriptor[] that provide for the packaged content of the
	 *         unit
	 */
	public IDomainPackagerDescriptor[] findDomainPackagers(Unit anInput);

	/**
	 * Create an instance of the domain packager using the descriptor
	 * 
	 * @param aDescriptor
	 *           the domain packager descriptor to be used to create the instance of the domain
	 *           packager
	 * @return the instance of the domain packager
	 */
	public DomainPackager createDomainPackager(IDomainPackagerDescriptor aDescriptor);

}
