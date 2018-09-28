/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.synchronization;

import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * Encapsulates a contribution to the Synchronization Framework.
 * 
 * @since 1.0
 * 
 */
public interface ISynchronizationParticipantDescriptor {

	/**
	 * Creates an instance of the defined Implementation participant.
	 * 
	 * @return An instance of the class defined by the current extension.
	 */
	SynchronizationParticipant createParticipant();

	/**
	 * Returns true if the current participant is enabled for one or more of the components specified
	 * in the datamodel.
	 * 
	 * @param unit
	 *           The unit to be implemented.
	 * @return True if current participant is enabled for one or more of the components specified in
	 *         the datamodel.
	 */
	boolean isEnabled(Unit unit);

}