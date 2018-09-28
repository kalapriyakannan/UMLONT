/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.ide.extension;

import com.ibm.ccl.soa.deploy.ide.publisher.IdeTopologyPublisher;

/**
 * Creates implementations of {@link IUnitPublisherService}.
 * 
 * <p>
 * This service is specific to {@link IdeTopologyPublisher}, not generic for all Unit publishing.
 * 
 * @since 1.0
 * @see UnitPublisherService
 * @see IdeTopologyPublisher
 */
public class UnitPublisherServiceFactory {

	/**
	 * 
	 * @return An implementation of {@link IUnitPublisherService} that can provide information and
	 *         instantiated classes from the available extensions.
	 */
	public static IUnitPublisherService createPublisherService() {
		return new UnitPublisherService();
	}
}
