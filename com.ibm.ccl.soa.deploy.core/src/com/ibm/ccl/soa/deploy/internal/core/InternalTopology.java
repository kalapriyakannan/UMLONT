/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.internal.core;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;

import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.internal.core.extension.IScopeService;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.InternalScopeService;

/**
 * This interface is not meant to be implemented or used by clients.
 * 
 */
public interface InternalTopology {

	/**
	 * This is an internal method called by the
	 * CoreResourceImpl$CoreResourceModificationTrackingAdapter. This method should not be called by
	 * clients.
	 * 
	 * @param notification
	 *           The {@link Notification} that needs to be delegated.
	 */
	void notifyTopologyListeners(Notification notification);

	/**
	 * Return the set of related imports (the import ancestory) for the given path.
	 * 
	 * @param scopeService
	 *           The scope service that manages the imported Topologies for the caller of this
	 *           method.
	 * @param fullPath
	 *           The path of the interesting object
	 * @param visited
	 *           An initially empty list that will be populated with the String identifiers of
	 *           visited Topologies.
	 * @return
	 * 
	 * @see IScopeService.Locator#findScopeService(com.ibm.ccl.soa.deploy.core.DeployModelObject)
	 */
	List<Import> findRelatedImport(InternalScopeService scopeService, String fullPath,
			List<String> visited);

	List<Unit> getVisibleUnits(InternalScopeService scopeService, Import importedSource,
			List<String> visited);

}
