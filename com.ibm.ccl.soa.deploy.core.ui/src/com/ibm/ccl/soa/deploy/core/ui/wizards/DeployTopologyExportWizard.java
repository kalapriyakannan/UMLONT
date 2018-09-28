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

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jem.util.emf.workbench.ProjectUtilities;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IPluginContribution;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;
import org.eclipse.wst.common.frameworks.internal.datamodel.ui.DataModelWizard;

import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;
import com.ibm.ccl.soa.deploy.core.datamodels.DeployTopologyExportDataModel;
import com.ibm.ccl.soa.deploy.core.datamodels.ui.UIDeployTopologyExportDataModel;
import com.ibm.ccl.soa.deploy.core.export.DeployExportLogger;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.DeployTopologyExportDataModelProvider;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.export.ExportView;
import com.ibm.ccl.soa.deploy.core.ui.perspective.DeployCorePerspectiveFactory;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;
import com.ibm.ccl.soa.infrastructure.operations.IAbstractScribblerDataModelProperties;

public class DeployTopologyExportWizard extends DataModelWizard implements INewWizard,
		IExecutableExtension, IPluginContribution {

	private IStructuredSelection selection;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
	 *      org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection aSelection) {
		setNeedsProgressMonitor(true);
		selection = aSelection;
		setWindowTitle(Messages.DEPLOYTOPOLOGY_EXPORT_WIZARD_TITLE);
		setDefaultPageImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_TOP_WIZ_BAN));
		DeployTopologyExportDataModel exportDataModel = new UIDeployTopologyExportDataModel(
				getDataModel());
		if (exportDataModel.getUnderlyingDataModel() != null) {
			if (selection != null && !selection.isEmpty()) {
				Object sel = selection.getFirstElement();
				if (sel instanceof IFile) {
					exportDataModel.setTopologyFile((IFile) sel);
				} else if (sel instanceof DeployShapeNodeEditPart) {
					DeployShapeNodeEditPart ep = (DeployShapeNodeEditPart) sel;
					EObject unit = ep.getNotationView().getElement();
					if (unit != null) {
						exportDataModel.setTopologyFile(WorkbenchResourceHelper.getFile(unit));
					}
				} else if (sel instanceof DeployDiagramEditPart) {
					DeployDiagramEditPart ep = (DeployDiagramEditPart) sel;
					EObject top = ep.getNotationView().getElement();
					if (top != null) {
						exportDataModel.setTopologyFile(WorkbenchResourceHelper.getFile(top));
					}
				}
			}
		}
	}

//	 don't exit until they pick the manditory items
	public boolean canFinish() {
		/*
		 * if
		 * (getDataModel().validateProperty(IDeployTopologyExportProperties.ARCHIVE_DESTINATION).getSeverity()
		 * ==IStatus.ERROR) return false;
		 */return super.canFinish();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.internal.datamodel.ui.DataModelWizard#getDefaultProvider()
	 */
	protected IDataModelProvider getDefaultProvider() {
		return new DeployTopologyExportDataModelProvider();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.internal.datamodel.ui.DataModelWizard#doAddPages()
	 */
	protected void doAddPages() {
		addPage(new DeployTopologyExportWizardPage1(getDataModel(),
				Messages.DEPLOYTOPOLOGY_EXPORT_WIZARD_PAGE1_TITLE));
	}

	protected void postPerformFinish() throws InvocationTargetException {
		DeployTopologyExportDataModel exportDataModel = new UIDeployTopologyExportDataModel(
				getDataModel());
		DeployExportLogger exportLog = exportDataModel.getExportLogger();
		if (exportLog != null) {
			exportLog.logToConsole();

			IWorkbench workbench = PlatformUI.getWorkbench();
			if (workbench == null) {
				return;
			}
			int n = workbench.getWorkbenchWindowCount();
			IWorkbenchWindow[] windows = workbench.getWorkbenchWindows();
			for (int i = 0; i < n; i++) {
				IWorkbenchWindow w = windows[i];
				String exportViewId = DeployCorePerspectiveFactory.ID_EXPORT_VIEW;
				try {
					w.getActivePage().showView(exportViewId);
				} catch (PartInitException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ExportView view = (ExportView) w.getActivePage().findView(exportViewId);
				if (view != null) {
					view.show(exportLog.getStatuses());
				} else {

				}
			}
		}
	}

	protected boolean prePerformFinish() {
		DeployTopologyExportDataModel exportDataModel = new UIDeployTopologyExportDataModel(
				getDataModel());
		String destinationValue = exportDataModel.getArchiveDestination();
		if (!ensureTargetIsValid(destinationValue)) {
			displayErrorDialog(DeployCoreMessages.DEPLOYMENTTOPOLOGYEXPORT_DESTINATION_INVALID);
			return false;
		}
		IFile topologyFile = exportDataModel.getTopologyFile();
		if (topologyFile != null) {
			exportDataModel.getScribblerDefinition().setProjectName(
					topologyFile.getProject().getName());
			exportDataModel.getScribblerDefinition().setEditModelLabel(
					DeploymentTopologyDomain.generateEditModelLabel(topologyFile));
			List domain = new ArrayList();
			domain.add(new DeploymentTopologyDomain(topologyFile));
			exportDataModel.getScribblerDefinition().setScribblerDomains(domain);

		}
		return super.prePerformFinish();
	}

	protected void displayErrorDialog(String message) {
		MessageDialog.openError(getContainer().getShell(),
				Messages.DEPLOYTOPOLOGY_EXPORT_WIZARD_TITLE, message);
	}

	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
	}

	public String getLocalId() {
		return null;
	}

	public String getPluginId() {
		return null;
	}

	protected IProject getProject() {
		String pName = getDataModel().getStringProperty(
				IAbstractScribblerDataModelProperties.PROJECT_NAME);
		if (pName != null && pName.length() > 0) {
			return ProjectUtilities.getProject(pName);
		}

		return null;
	}

	/**
	 * Ensures that the target output file and its containing directory are both valid and able to be
	 * used. Answer a boolean indicating validity.
	 */
	protected boolean ensureTargetIsValid(String archiveDestination) {
		String targetPath = archiveDestination;

		if (!ensureTargetDirectoryIsValid(targetPath)) {
			return false;
		}

		return true;
	}

	/**
	 * Returns a boolean indicating whether the directory portion of the passed pathname is valid and
	 * available for use.
	 */
	protected boolean ensureTargetDirectoryIsValid(String fullPathname) {
		int separatorIndex = fullPathname.lastIndexOf(File.separator);

		if (separatorIndex == -1) {
			return true;
		}

		return ensureTargetIsValid(new File(fullPathname.substring(0, separatorIndex)));
	}

	/**
	 * Attempts to ensure that the specified directory exists on the local file system. Answers a
	 * boolean indicating success.
	 * 
	 * @return boolean
	 * @param directory
	 *           java.io.File
	 */
	protected boolean ensureDirectoryExists(File directory) {
		if (!directory.exists()) {
			if (!directory.mkdirs()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * If the target for export does not exist then attempt to create it. Answer a boolean indicating
	 * whether the target exists (ie.- if it either pre-existed or this method was able to create it)
	 * 
	 * @return boolean
	 */
	protected boolean ensureTargetIsValid(File targetDirectory) {
		if (targetDirectory.exists() && !targetDirectory.isDirectory()) {
			return false;
		}
		return ensureDirectoryExists(targetDirectory);
	}

	public void createPageControls(Composite pageContainer) {
		super.createPageControls(pageContainer);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(pageContainer,
				IDeployHelpContextIds.EXPORT_TOPOLOGY_WIZARD);
	}

}
