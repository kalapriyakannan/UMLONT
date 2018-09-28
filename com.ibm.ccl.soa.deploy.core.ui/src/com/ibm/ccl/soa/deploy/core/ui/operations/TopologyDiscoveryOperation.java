/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.operations;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.ui.util.CanonicalUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.TopologyStateData;
import com.ibm.ccl.soa.deploy.internal.core.extension.DiscoverAndAddService;
import com.ibm.ccl.soa.infrastructure.operations.AbstractScribblerOperation;

/**
 * TopologyDiscoveryOperation
 * 
 * @see TopologyDiscoveryProvider
 * @see DiscoverAndAddService
 */

public class TopologyDiscoveryOperation extends AbstractScribblerOperation implements
		ITopologyDiscoveryProperties {

	/**
	 * constructor
	 */
	public TopologyDiscoveryOperation() {
		super();
	}

	/**
	 * @param dataModel
	 */
	public TopologyDiscoveryOperation(IDataModel dataModel) {
		super(dataModel);
	}

	protected IStatus doExecute(IProgressMonitor monitor) throws ExecutionException {
		executeDiscovery(monitor);

		return Status.OK_STATUS;
	}

	private void executeDiscovery(final IProgressMonitor monitor) {
		IDataModel discoveryDataModel = getDataModel();

		if (discoveryDataModel.getBooleanProperty(IS_CREATE_FIND_DEPENDENCIES_FILTER)) {
			Map selectedReq2CapsMap = (Map) discoveryDataModel.getProperty(SELECTED_UNIT_DESCRIPTORS);
			if (selectedReq2CapsMap == null) {
				return;
			}

			Set entrySet = selectedReq2CapsMap.entrySet();

			TopologyStateData state = new TopologyStateData(null);
			for (Iterator i = entrySet.iterator(); i.hasNext();) {
				Map.Entry entry = (Map.Entry) i.next();
				Requirement req = (Requirement) entry.getKey();
				List caps = (List) entry.getValue();
				Capability cap = (Capability) caps.get(0);

				DiscoverAndAddService.INSTANCE.addTargetUnitAndDependenyLinkToTopology(req, cap);
			}
			state.markChanges();
			CanonicalUtils.refreshViews(state.getNewViews(), false);
			return;
		}

		/** In case of hosting link discovery */
		Map selectedUnitDescrMap = (HashMap) discoveryDataModel
				.getProperty(SELECTED_UNIT_DESCRIPTORS);
		if (selectedUnitDescrMap == null) {
			return;
		}

		//List addedUnits = new ArrayList();
		for (Iterator iter = selectedUnitDescrMap.entrySet().iterator(); iter.hasNext();) {
			Map.Entry entry = (Map.Entry) iter.next();
			List selectedList = (List) entry.getValue();
			//there should only be 1 in the selected list, if more, than pick first one
			if (selectedList.size() > 0) {
				UnitDescriptor hostDesc = (UnitDescriptor) selectedList.get(0);
				Unit hostee = (Unit) entry.getKey();
				DiscoverAndAddService.INSTANCE.addAndHostDiscoveredUnitToTopology(hostee, hostDesc);
			}
		}
	}

	protected IStatus doRedo(IProgressMonitor monitor) {
		return null;
	}

	protected IStatus doUndo(IProgressMonitor monitor) {
		return null;
	}
}
