/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.properties;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;
import org.eclipse.wst.common.frameworks.internal.datamodel.ui.DataModelWizard;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.datamodels.LinkDiscoveryDataModel;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.LinkDiscoveryDataModelOperation;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.LinkDiscoveryDataModelProvider;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.internal.popup.Messages;
import com.ibm.ccl.soa.deploy.core.ui.util.ResolutionUIUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.TopologyStateData;

/**
 * Wizard for creating links using 'discovery' API to guide user to possible links.
 * 
 * @author Ed Snible
 * 
 * @see DiscoveryOptionsPage
 * @see SelectMatchPage
 * 
 * @see LinkDiscoveryDataModelOperation
 * @see LinkDiscoveryDataModel
 */
public class NewLinkWizard extends DataModelWizard {

	private LinkDiscoveryDataModel linkDiscoveryDataModel = null;
	private Topology _topology = null;
	private TopologyStateData _state = null;

	public NewLinkWizard(LinkDiscoveryDataModel linkDiscoveryDataModel) {
		this.linkDiscoveryDataModel = linkDiscoveryDataModel;
		super.setWindowTitle(Messages.NewLinkWizard_New_Link_Wizar_);
		super.setDefaultPageImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_TOP_WIZ_BAN));
	}

	public void doAddPages() {
		if (linkDiscoveryDataModel.shouldCreateSelectionPage()) {
			addPage(new DiscoveryOptionsPage(getDataModel()));
		}
		addPage(new SelectMatchPage(getDataModel()));
	}

	/**
	 * Subclass can override to perform any tasks prior to running the operation. Return true to have
	 * the operation run and false to stop the execution of the operation.
	 * 
	 * @return
	 */
	protected boolean prePerformFinish() {
		super.prePerformFinish();

		//save the old state of the topology layout before this operation is run
		Unit unit = linkDiscoveryDataModel.getUnit();
		if (unit != null) {
			// save current state of the topology for highlighting topology changes later
			_topology = unit.getEditTopology();
			_state = new TopologyStateData(_topology);
		}
		return true;
	}

	protected void postPerformFinish() throws InvocationTargetException {
		super.postPerformFinish();

		//refresh the topology and highlight the differential units that are created
		if (_topology != null && _state != null) {
			_state.markChanges();
			ResolutionUIUtils.refreshAndHighlightTopologyDiff(_state, getShell().getLocation(), true);
		}
	}

	protected IDataModelProvider getDefaultProvider() {
		return new LinkDiscoveryDataModelProvider();
	}

	protected boolean runForked() {
		return false;
	}

	@Override
	public IDataModel getDataModel() {
		return linkDiscoveryDataModel.getUnderlyingDataModel();
	}

}
