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

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelProvider;
import org.eclipse.wst.common.frameworks.internal.datamodel.ui.DataModelWizard;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.datamodels.AddToPaletteDataModel;
import com.ibm.ccl.soa.deploy.core.datamodels.CreateTopologyDataModel;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.CreateTopologyDataModelProvider;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.IAddToPaletteDataModelProperties;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceElement;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragment;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.namespace.index.ITopologyNamespaceRootIndex;
import com.ibm.ccl.soa.deploy.core.namespace.index.ITopologyNamespaceRootIndexer;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.internal.wizards.AddToPaletteWizardPage;
import com.ibm.ccl.soa.deploy.core.ui.internal.wizards.TopologyCreationWizardPage1;
import com.ibm.ccl.soa.deploy.core.ui.preferences.IDeployPreferences;
import com.ibm.ccl.soa.infrastructure.ui.internal.epl.DecoratingDataModelWizardPage.IDecoratingWizard;

/**
 * This wizard is used to create a new {@link Topology} file.
 */
public class TopologyCreationWizard extends DataModelWizard implements INewWizard,
		IExecutableExtension, IDecoratingWizard {

	private static final String DEPLOY_PERSPECTIVE = "com.ibm.ccl.soa.deploy.core.ui.DeployCore.Perspective"; //$NON-NLS-1$
	private CreateTopologyDataModel topologyDataModel;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench,
	 *      org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection aSelection) {
		setNeedsProgressMonitor(true);
		IStructuredSelection selection = aSelection;
		setWindowTitle(Messages.DEPLOYMENTMODEL_WIZARD_TITLE);
		setDefaultPageImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_TOP_WIZ_BAN));
		if (getDataModel() != null) {
			topologyDataModel = new CreateTopologyDataModel(getDataModel());
			if (selection != null && !selection.isEmpty()) {
				Object sel = selection.getFirstElement();
				if (sel instanceof INamespaceElement) {
					setInitialSelections((INamespaceElement) sel);
				} else {
					IResource resource = (IResource) Platform.getAdapterManager().getAdapter(sel,
							IResource.class);
					if (resource != null) {
						switch (resource.getType())
						{
						case IResource.PROJECT:
							setInitialSelections((IProject) resource);
							break;
						case IResource.FOLDER:
							setInitialSelections((IFolder) resource);
							break;
						case IResource.FILE:
							setInitialSelections((IFile) resource);
							break;
						}
					}
				}
			}
		}
	}

	private void setInitialSelections(INamespaceElement element) {
		switch (element.getType())
		{
		case INamespaceElement.TOPOLOGY_NAMESPACE_ROOT:
			topologyDataModel.setSourcePath((INamespaceFragmentRoot) element);
			break;
		case INamespaceElement.TOPOLOGY_NAMESPACE:
			INamespaceFragment namespaceFragment = (INamespaceFragment) element;
			topologyDataModel.setNamespacePath(namespaceFragment.getQualifiedName());
			topologyDataModel.setSourcePath(namespaceFragment.getRoot());
		}
	}

	private void setInitialSelections(IFile file) {
		IContainer parent = file.getParent();
		if (parent != null) {
			switch (parent.getType())
			{
			case IResource.PROJECT:
				setInitialSelections((IProject) parent);
				break;

			case IResource.FOLDER:
				setInitialSelections((IFolder) parent);
				break;
			}
		}
	}

	private void setInitialSelections(IFolder folder) {
		ITopologyNamespaceRootIndexer indexer = DeployCorePlugin.getDefault()
				.getTopologyNamespaceRootIndexer();
		ITopologyNamespaceRootIndex index = indexer.getTopologyNamespaceRootIndex(
				folder.getProject(), null);
		if (index != null) {
			INamespaceFragmentRoot root = index.getRoot(folder);
			if (root != null) {
				IContainer container = root.getCorrespondingResource();
				if (container != null) {
					topologyDataModel.setSourcePath(root);
					if (!container.equals(folder)) {
						IPath namespacePath = folder.getFullPath().removeFirstSegments(
								container.getFullPath().segmentCount());
						INamespaceFragment namespaceFragment = root.resolveNamespace(namespacePath
								.segments());
						if (namespaceFragment != null) {
							topologyDataModel.setNamespacePath(namespaceFragment.getQualifiedName());
						}
					}
				}
			} else {
				IPath path = folder.getFullPath();
				if (path.segmentCount() > 2) {
					//Trim the path to no more than 2 segments for now.
					path = path.removeLastSegments(path.segmentCount() - 2);
				}
				path = path.makeRelative();
				topologyDataModel.setSourcePath(path.toString());
			}
		}
	}

	private void setInitialSelections(IProject project) {
		//make project have default source folder of "topologies"
		topologyDataModel.setSourcePath(project.getName() + "/topologies"); //$NON-NLS-1$
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.internal.datamodel.ui.DataModelWizard#getDefaultProvider()
	 */
	protected IDataModelProvider getDefaultProvider() {
		return new CreateTopologyDataModelProvider();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.frameworks.internal.datamodel.ui.DataModelWizard#doAddPages()
	 */
	protected void doAddPages() {
		addNestedDataModel(topologyDataModel.getUnderlyingDataModel());
		addPage(new TopologyCreationWizardPage1(topologyDataModel,
				Messages.DEPLOYMENTMODEL_PAGE1_TITLE));
		addPage(new AddToPaletteWizardPage(topologyDataModel,
				Messages.TopologyCreationWizardPage2_Add_Topology_to_Palett_));
	}

	private void addNestedDataModel(IDataModel underlyingDataModel) {
		AddToPaletteDataModel dataModel = AddToPaletteDataModel.createModel();
		dataModel.setEnableCaptureVisuals(true);
		underlyingDataModel.addNestedModel(IAddToPaletteDataModelProperties.DATAMODEL, dataModel
				.getUnderlyingDataModel());

	}

	// open deployment perspective, then file, then init editor
	protected void postPerformFinish() {
		// give a chance for the creation wizard to exit first
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				openPerspective();
				openFile();
			}
		});
	}

	private void openFile() {
		IEditorRegistry registry = PlatformUI.getWorkbench().getEditorRegistry();
		IFile topologyFile = topologyDataModel.getTopologyFile();
		if (topologyFile != null && topologyFile.exists()) {
			IEditorDescriptor currentDescriptor = registry.getDefaultEditor(topologyFile.getName());
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			try {
				if (page != null) {
					page.openEditor(new FileEditorInput(topologyFile), currentDescriptor.getId());
				}
			} catch (PartInitException e) {
				e.printStackTrace();
			}
		}
		BasicNewResourceWizard.selectAndReveal(topologyFile, PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow());
	}

	private void openPerspective() {
		try {
			// prompt user to open perspective
			// unless preferences forces it

			// if already openned, just return
			IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			IPerspectiveDescriptor perspective = null;
			if (window != null && window.getActivePage() != null) {
				perspective = window.getActivePage().getPerspective();
			}
			if (perspective != null && perspective.getId().equalsIgnoreCase(DEPLOY_PERSPECTIVE)) {
				return;
			}

			// if user never wants to open perspecitve
			IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
			String pref = store.getString(IDeployPreferences.OPEN_DEPLOY_PERSPECTIVE);
			if (pref != null && pref.equals(MessageDialogWithToggle.NEVER)) {
				return;
			}

			// if user hasn't set "remeber me" checkbox, prompt them again
			boolean bOpenPerspective = pref != null && pref.equals(MessageDialogWithToggle.ALWAYS);
			if (!bOpenPerspective) {
				MessageDialogWithToggle dialog = new MessageDialogWithToggle(window.getShell(),
						Messages.OPENPERSPEC_DIALOG_TITLE, null, Messages.OPENPERSPEC_DIALOG_MESSAGE,
						MessageDialog.WARNING, new String[] { IDialogConstants.YES_LABEL,
								IDialogConstants.NO_LABEL }, 1, null, false);
				dialog.setPrefKey(IDeployPreferences.OPEN_DEPLOY_PERSPECTIVE);
				dialog.setPrefStore(store);
				dialog.open();
				bOpenPerspective = dialog.getReturnCode() == IDialogConstants.YES_ID;
			}

			// so if someone said open, lets open it!
			if (bOpenPerspective) {
				window.getWorkbench().showPerspective(DEPLOY_PERSPECTIVE, window);
			}

		} catch (WorkbenchException e) {
		}
	}

//	private DeployCoreEditor openVisualizationFile() {
//		DeployCoreEditor editor = null;
//		IDataModel dataModel = getDataModel().getNestedModel(ICreateComposedDeploymentProperties.CREATE_DEPLOYMENT_VIZUALIZATION_PROVIDER);
//		String fileName = dataModel.getStringProperty(ICreateDeploymentVisualizationProperties.DEPLOYMENT_TOPOLOGY_FILENAME);
//		final IFolder deploymentFolder = (IFolder) dataModel.getProperty(ICreateDeploymentVisualizationProperties.DEPLOYMENT_FOLDER);
//		final IProject project = getProject();
//		if (deploymentFolder==null || project==null) return null;
//
//		String completeFileName = deploymentFolder.getProjectRelativePath().toString() + "/" + fileName; //$NON-NLS-1$
//		IFile deploymentVisualizationFile = project.getFile(completeFileName);
//		IEditorRegistry registry = PlatformUI.getWorkbench().getEditorRegistry();
//		if (deploymentVisualizationFile != null && deploymentVisualizationFile.exists()) {
//			IEditorDescriptor currentDescriptor = registry.getDefaultEditor(deploymentVisualizationFile.getName());
//			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
//			try {
//				editor = (DeployCoreEditor) page.openEditor(new FileEditorInput(deploymentVisualizationFile), currentDescriptor.getId());
//				editor.arrangeTopologyDiagram();
//			} catch (PartInitException e) {
//				e.printStackTrace();
//			}
//		}
//		return editor;
//	}

	public void setInitializationData(IConfigurationElement config, String propertyName, Object data) {
	}

	/*
	 * Exposing as public for others to call.
	 * 
	 * @see org.eclipse.wst.common.frameworks.internal.datamodel.ui.DataModelWizard#isExecuting()
	 */
	public boolean isExecuting() {
		return super.isExecuting();
	}

	public void createPageControls(Composite pageContainer) {
		super.createPageControls(pageContainer);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(pageContainer,
				IDeployHelpContextIds.TOPOLOGY_NEW_TOPOLOGY_WIZARD);
	}
}
