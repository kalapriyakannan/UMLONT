/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.wizards;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.wst.common.frameworks.datamodel.DataModelFactory;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;
import org.eclipse.wst.common.frameworks.internal.datamodel.ui.DataModelWizard;

import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.actions.DiscoverLinksAction;
import com.ibm.ccl.soa.deploy.core.ui.operations.ITopologyDiscoveryProperties;
import com.ibm.ccl.soa.deploy.core.ui.operations.TopologyDiscoveryOperation;
import com.ibm.ccl.soa.deploy.core.ui.operations.TopologyDiscoveryProvider;
import com.ibm.ccl.soa.infrastructure.emf.IScribblerDomain;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;
import com.ibm.ccl.soa.infrastructure.operations.IAbstractScribblerDataModelProperties;

/**
 * Wizard for suggesting links.
 * 
 * @author Ed Snible
 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
 * 
 * @see DiscoverLinksAction
 * 
 * @see DiscoveryWizardSourceUnitSelectPage
 * @see DiscoveryWizardLinkTypeSelectPage
 * @see DiscoveryWizardHostDiscoverResultPage
 * @see DiscoveryWizardDependencyDiscoverResultPage
 * 
 * @see TopologyDiscoveryProvider
 * @see TopologyDiscoveryOperation
 * 
 * @deprecated use NewLinkWizard
 */
public class TopologyDiscoveryWizard extends DataModelWizard {

	/**
	 * @param selectedUnits
	 *           Selected Unit List
	 */

	public TopologyDiscoveryWizard(List selectedUnits) {
		setNeedsProgressMonitor(true);
		setWindowTitle(Messages.TOPOLOGY_DISCOVERY_WIZARD_TITLE);
		setDefaultPageImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_TOP_WIZ_BAN));

		IDataModel dm = DataModelFactory.createDataModel(TopologyDiscoveryProvider.class);
		setDataModel(dm);

		Topology topology = ((Unit) selectedUnits.get(0)).getTopology();

		if (topology.eResource() != null) {
			IFile topologyFile = WorkbenchResourceHelper.getFile(topology);
			getDataModel().setProperty(ITopologyDiscoveryProperties.TOPOLOGY_FILE, topologyFile);
			getDataModel().setStringProperty(IAbstractScribblerDataModelProperties.PROJECT_NAME,
					topologyFile.getProject().getName());
		}
		getDataModel().setProperty(ITopologyDiscoveryProperties.SELECTED_ITEMS,
				selectedUnits.toArray());
	}

	protected boolean prePerformFinish() {
		IFile topologyFile = (IFile) getDataModel().getProperty(
				ITopologyDiscoveryProperties.TOPOLOGY_FILE);
		if (topologyFile != null) {
			getDataModel().setProperty(IAbstractScribblerDataModelProperties.EDIT_MODEL_LABEL,
					DeploymentTopologyDomain.generateEditModelLabel(topologyFile));
			getDataModel().setProperty(IAbstractScribblerDataModelProperties.SCRIBBLER_DOMAINS,
					new IScribblerDomain[] { new DeploymentTopologyDomain(topologyFile) });
		}
		return super.prePerformFinish();
	}

	/**
	 * Add wizard pages
	 */
	protected void doAddPages() {
		Object[] selectedUnits = (Object[]) getDataModel().getProperty(
				ITopologyDiscoveryProperties.SELECTED_ITEMS);
		if (selectedUnits != null && selectedUnits.length > 1) {
			addPage(new DiscoveryWizardSourceUnitSelectPage(getDataModel()));
			addPage(new DiscoveryWizardLinkTypeSelectPage(getDataModel()));
			addPage(new DiscoveryWizardHostDiscoverResultPage(getDataModel()));
			addPage(new DiscoveryWizardDependencyDiscoverResultPage(getDataModel()));
		} else {
			addPage(new DiscoveryWizardLinkTypeSelectPage(getDataModel()));
			addPage(new DiscoveryWizardHostDiscoverResultPage(getDataModel()));
			addPage(new DiscoveryWizardDependencyDiscoverResultPage(getDataModel()));
		}
	}

	public String getNextPage(String currentPageName, String expectedNextPageName) {

		if (currentPageName != null
				&& currentPageName.equals(DiscoveryWizardLinkTypeSelectPage.PAGE_NAME)) {
			if (getDataModel().getBooleanProperty(
					ITopologyDiscoveryProperties.IS_CREATE_FIND_HOST_FILTER)) {
				return DiscoveryWizardHostDiscoverResultPage.PAGE_NAME;
			} else {
				return DiscoveryWizardDependencyDiscoverResultPage.PAGE_NAME;
			}
		}

		return super.getNextPage(currentPageName, expectedNextPageName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.internal.datamodel.ui.DataModelWizard#getDefaultProvider()
	 */
	protected IDataModelProvider getDefaultProvider() {
		return new TopologyDiscoveryProvider();
	}

	protected boolean isCancelable() {
		return true;
	}

	protected boolean runForked() {
		return false;
	}

	public boolean canFinish() {
		IWizardPage currpage = getContainer().getCurrentPage();
		if (currpage.getName().equals(DiscoveryWizardSourceUnitSelectPage.PAGE_NAME)
				|| currpage.getName().equals(DiscoveryWizardLinkTypeSelectPage.PAGE_NAME)) {
			return false;
		}
		return super.canFinish();
	}

}
