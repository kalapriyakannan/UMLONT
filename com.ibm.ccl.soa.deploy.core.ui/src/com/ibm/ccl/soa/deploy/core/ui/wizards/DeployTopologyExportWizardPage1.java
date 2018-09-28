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
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jem.util.emf.workbench.ProjectUtilities;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.internal.datamodel.ui.DataModelWizardPage;

import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.datamodels.DeployTopologyExportDataModel;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.IDeployTopologyExportDataModelProperties;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.util.ResourceUtils;
import com.ibm.ccl.soa.deploy.internal.core.extension.TopologyExporterDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.extension.TopologyManager;

public class DeployTopologyExportWizardPage1 extends DataModelWizardPage {
	public static boolean isWindows = SWT.getPlatform().toLowerCase().startsWith("win"); //$NON-NLS-1$
	protected CCombo exportTypeField = null;
	protected CCombo projectField = null;
	protected CCombo topologyField = null;
	private Button destinationBrowseButton;
	protected Button overwriteExistingFilesCheckbox;
	private Button sourceFilesCheckbox;
	private Button exportWithErrorsCheckbox;
	private Button createLocationBindingCheckBox;
	private Button exportDiagramResourceIfPresentCheckBox;
	private Button createExportProjectCheckBox;
	private Text destinationNameText;
	private Text exportTypeTextArea;
	protected static final String defBrowseButtonLabel = Messages.BROWSE_LABEL;
	protected String LABEL_DESTINATION = Messages.DEPLOYTOPOLOGY_EXPORT_URI_LABEL;
	// private static String DEPLOYMENTPLAN_NATURE = "com.ibm.ccl.soa.deploy.core.DeploymentNature" ;//$NON-NLS-1$
	DeployTopologyExportDataModel exportUIDataModel = null;

	/*
	 * ///////////////////////////////////// INIT PAGE
	 */
	public DeployTopologyExportWizardPage1(IDataModel model, String pageName) {
		super(model, pageName);
		exportUIDataModel = new DeployTopologyExportDataModel(model);
		setDefaultDescription();
	}

	public DeployTopologyExportWizardPage1(IDataModel model, String pageName, String title) {
		super(model, pageName);
		exportUIDataModel = new DeployTopologyExportDataModel(model);
		setTitle(title);
		setDefaultDescription();
	}

	public DeployTopologyExportWizardPage1(IDataModel model, String pageName, String title,
			ImageDescriptor titleImage) {
		super(model, pageName, title, titleImage);
		exportUIDataModel = new DeployTopologyExportDataModel(model);
		setDefaultDescription();
	}

	/*
	 * ///////////////////////////////////// GENERAL PAGE SUPPORT
	 * ///////////////////////////////////////////// ///////////////////////////////////// GENERAL
	 * PAGE SUPPORT /////////////////////////////////////////////
	 * ///////////////////////////////////// GENERAL PAGE SUPPORT
	 * /////////////////////////////////////////////
	 */
	protected void enter() {
		super.enter();
	}

	protected boolean showValidationErrorsOnEnter() {
		return true;
	}

	protected void exit() {
		setProperties();
		super.exit();
	}

	private void setProperties() {
		setProjectGroupProperties();
		setTopologyGroupProperties();
		setExportTypeGroupProperties();
	}

	private void setExportTypeGroupProperties() {
		if (exportTypeField != null) {
			TopologyExporterDescriptor exporterDesc = (TopologyExporterDescriptor) exportTypeField
					.getData(exportTypeField.getText());
			exportUIDataModel.setExporter(exporterDesc.createTopologyExporter());
			exportTypeTextArea.setText(exporterDesc.getDescription());
		}
	}

	private void setTopologyGroupProperties() {
		if (topologyField != null) {
			String selectedTopologyName = topologyField.getText();
			exportUIDataModel.setTopologyFile((IFile) topologyField.getData(selectedTopologyName));
		}
	}

	private void setProjectGroupProperties() {
		if (projectField != null) {
			exportUIDataModel.getScribblerDefinition().setProjectName(projectField.getText());
		}
	}

	private void setDefaultDescription() {
		setDescription(Messages.DEPLOYTOPOLOGY_EXPORT_WIZARD_PAGE1_DESCRIPTION);
		setTitle(Messages.DEPLOYTOPOLOGY_EXPORT_WIZARD_PAGE1_TITLE);
	}

	public void storeDefaultSettings() {
		super.storeDefaultSettings();
	}

	protected void restoreDefaultSettings() {
		super.restoreDefaultSettings();
	}

	// just validate the name-- user can eneter anything for description and
	// project name is fixed
	protected String[] getValidationPropertyNames() {
		return new String[] { IDeployTopologyExportDataModelProperties.TOPOLOGY_FILE,
				IDeployTopologyExportDataModelProperties.EXPORTER,
				IDeployTopologyExportDataModelProperties.ARCHIVE_DESTINATION,
				IDeployTopologyExportDataModelProperties.EXPORT_WITH_ERROR,
				IDeployTopologyExportDataModelProperties.CREATE_LOCATION_BINDING,
				IDeployTopologyExportDataModelProperties.CREATE_EXPORT_PROJECT };
	}

	/*
	 * ///////////////////////////////////// Default values
	 * ///////////////////////////////////////////// ///////////////////////////////////// Default
	 * values ///////////////////////////////////////////// /////////////////////////////////////
	 * Default values /////////////////////////////////////////////
	 */

	protected void setDefaults() {
		super.setDefaults();

		// description is set to date and time
		/*
		 * if (isFirstTimeToPage) { IFile deployModelFile =
		 * (IFile)getDataModel().getProperty(IDeployTopologyExportProperties.DEPLOYMENT_PLAN_FILE); if
		 * (deployModelFile != null){ String projectName = deployModelFile.getProject().getName();
		 * String topologyName = DeploymentTopologyDomain.getDeployPlanName(deployModelFile);
		 * getDataModel().setProperty(IDeployTopologyExportProperties.ARCHIVE_DESTINATION,
		 * topologyName + ".zip"); //$NON-NLS-1$
		 * getDataModel().setProperty(IDeployTopologyExportProperties.PROJECT_NAME, projectName);
		 * projectField.setText(projectName); topologyField.setText(topologyName); } }
		 */
		/*
		 * IProject project = getProject (); calcPlanName(project);
		 */}

	protected Composite createTopLevelComposite(Composite parent) {
		Composite top = new Composite(parent, SWT.NONE);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.EXPORT_TOPOLOGY_WIZARD);
		//	PlatformUI.getWorkbench().getHelpSystem().setHelp(top, getInfopopID());
		top.setLayout(new GridLayout());
		top.setData(new GridData(GridData.FILL_BOTH));

		// create a composite that controls will appear in
		Composite composite = new Composite(top, SWT.NONE);
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		GridLayout layout = new GridLayout(2, false);
		composite.setLayout(layout);
		createFirstControlGroups(composite);

		Composite composite2 = new Composite(top, SWT.NONE);
		composite2.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		GridLayout layout2 = new GridLayout();
		layout2.numColumns = 6;
		composite2.setLayout(layout2);
		createDestinationGroup(composite2);

		Composite composite3 = new Composite(top, SWT.NONE);
		composite3.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		GridLayout layout3 = new GridLayout();
		layout3.numColumns = 1;
		composite3.setLayout(layout3);
		createOptionsGroup(composite3);

		return top;
	}

	/*
	 * ///////////////////////////////////// Controls /////////////////////////////////////////////
	 */

	protected void createFirstControlGroups(Composite parent) {
		createProjectGroup(parent);
		createTopologyGroup(parent);
		createExportTypeGroup(parent);
	}

	protected void createDestinationGroup(org.eclipse.swt.widgets.Composite parent) {
		GridData gridData1 = new GridData();
		gridData1.horizontalAlignment = GridData.FILL;
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.horizontalSpan = 2;
		gridData1.verticalAlignment = GridData.CENTER;
		//Destination label
		Label destinationLabel = new Label(parent, SWT.NONE);
		destinationLabel.setText(LABEL_DESTINATION);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		// destination name combo field
		destinationNameText = new Text(parent, SWT.SINGLE | SWT.BORDER);
		synchHelper.synchText(destinationNameText,
				IDeployTopologyExportDataModelProperties.ARCHIVE_DESTINATION, null);
		destinationNameText.setLayoutData(gridData1);

		// destination browse button
		destinationBrowseButton = new Button(parent, SWT.NONE);
		destinationBrowseButton.setText(defBrowseButtonLabel);
		//  destinationBrowseButton.setLayoutData((new GridData(GridData.FILL_HORIZONTAL)));
		destinationBrowseButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleDestinationBrowseButtonPressed();
			}
		});
		destinationBrowseButton.setEnabled(true);

	}

	/*
	 * gets the deployment plan location
	 */
	private void createProjectGroup(final Composite parent) {
		// set up location path label
		Label projectLabel = new Label(parent, SWT.NONE);
		projectLabel.setText(Messages.DEPLOYTOPOLOGY_EXPORT_PROJECT_LABEL);
		projectField = new CCombo(parent, SWT.BORDER);
		projectField.setEditable(false);

		projectField.setBackground(parent.getShell().getDisplay().getSystemColor(SWT.COLOR_WHITE));
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		// gridData.widthHint = 205;
		projectField.setLayoutData(gridData);
		projectField.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				setProjectGroupProperties();
				fillTopologyCombo();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		// fill the projects 
		fillProjectCombo();
		setProjectGroupProperties();
	}

	private void fillProjectCombo() {
		IProject[] projects = ProjectUtilities.getAllProjects();
		int sel = -1;
		String selectedProjectName = null;
		projectField.removeAll();
		for (int i = 0; i < projects.length; i++) {
			IProject p = projects[i];
			if (!p.isOpen()) {
				continue;
			}
			// if project doesn't have a deployment nature don't list it
			/*
			 * try { if (p.getNature(DEPLOYMENTPLAN_NATURE)==null &&
			 * p.getDescription().getNatureIds().length>0) continue; } catch (CoreException e) { }
			 */
			//if project does not contain a topology file, do not list it
			List topologyFiles = ResourceUtils.getTopologyProjectFiles(p);
			if (topologyFiles == null || topologyFiles.size() == 0) {
				continue;
			}
			String projectName = p.getName();
			projectField.add(projectName);
			projectField.setData(projectName, projects[i]);
			if (sel == -1 && isFirstTimeToPage) {
				IFile deployModelFile = exportUIDataModel.getTopologyFile();
				if (deployModelFile != null) {
					selectedProjectName = deployModelFile.getProject().getName();
					sel++;
				}
			}
			if (sel == -1) {
				selectedProjectName = projectName;
				sel++;
			}
		}
		if (sel != -1) {
			projectField.setText(selectedProjectName);
		}
	}

	/*
	 * gets the deployment plan location
	 */
	private void createTopologyGroup(final Composite parent) {
		// set up location path label
		Label topologyLabel = new Label(parent, SWT.NONE);
		topologyLabel.setText(Messages.DEPLOYTOPOLOGY_EXPORT_TOPOLOGY_LABEL);
		topologyField = new CCombo(parent, SWT.BORDER);
		topologyField.setEditable(false);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		// gridData.widthHint = 205;
		topologyField.setLayoutData(gridData);
		topologyField.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				setTopologyGroupProperties();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		topologyField.setBackground(parent.getShell().getDisplay().getSystemColor(SWT.COLOR_WHITE));
		// fill the topologies 
		fillTopologyCombo();
		setTopologyGroupProperties();
	}

	private void fillTopologyCombo() {
		List topologyFiles = ResourceUtils.getTopologyProjectFiles(getProject());
		int sel = -1;
		topologyField.removeAll();
		String selectedTopologyName = null;
		for (int i = 0; i < topologyFiles.size(); i++) {
			IFile file = (IFile) topologyFiles.get(i);
			if (!file.exists()) {
				continue;
			}
			ChangeScope<Topology, DeploymentTopologyDomain> changeScope = ChangeScope
					.createChangeScopeForWrite(file);
			try {
				DeployCoreRoot root = changeScope.openModel(file, CorePackage.eINSTANCE
						.getDeployCoreRoot());
				Topology topology = root.getTopology();
				String topologyName = topology.getQualifiedName();//DeploymentTopologyDomain.getDeployPlanName(file);
				topologyField.add(topologyName);
				topologyField.setData(topologyName, file);
				if (sel == -1 && isFirstTimeToPage) {
					IFile deployModelFile = exportUIDataModel.getTopologyFile();
					if (deployModelFile != null) {
						selectedTopologyName = getSelectedTopologyName();//DeploymentTopologyDomain.getDeployPlanName(file);
						sel++;
					}
				}
				if (sel == -1) {
					selectedTopologyName = topologyName;
					sel++;
				}
			} finally {
				if (changeScope != null) {
					changeScope.close(new NullProgressMonitor());
				}
			}
		}
		if (sel != -1) {
			topologyField.setText(selectedTopologyName);
		}
	}

	private String getSelectedTopologyName() {
		IFile deployModelFile = exportUIDataModel.getTopologyFile();
		ChangeScope<Topology, DeploymentTopologyDomain> changeScope = ChangeScope
				.createChangeScopeForWrite(deployModelFile);
		try {
			DeployCoreRoot root = changeScope.openModel(deployModelFile, CorePackage.eINSTANCE
					.getDeployCoreRoot());
			Topology topology = root.getTopology();
			return topology.getQualifiedName();
		} finally {
			if (changeScope != null) {
				changeScope.close(new NullProgressMonitor());
			}
		}
	}

	/*
	 * gets the deployment plan location
	 */
	private void createExportTypeGroup(final Composite parent) {
		// set up location path label
		Label exportTypeLabel = new Label(parent, SWT.NONE);
		exportTypeLabel.setText(Messages.DEPLOYTOPOLOGY_EXPORT_TYPE_LABEL);
		exportTypeField = new CCombo(parent, SWT.BORDER);
		exportTypeField.setEditable(false);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		// gridData.widthHint = 205;
		exportTypeField.setLayoutData(gridData);
		exportTypeField.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				setExportTypeGroupProperties();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		exportTypeField.setBackground(parent.getShell().getDisplay().getSystemColor(SWT.COLOR_WHITE));
		GridData gridData4 = new GridData();
		gridData4.horizontalAlignment = GridData.FILL;
		gridData4.grabExcessHorizontalSpace = true;
		gridData4.grabExcessVerticalSpace = true;
		gridData4.horizontalSpan = 3;
		gridData4.verticalAlignment = GridData.FILL;
		gridData4.widthHint = 200;
		gridData4.heightHint = 70;
		gridData4.minimumHeight = 65;
		exportTypeTextArea = new Text(parent, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.READ_ONLY
				| SWT.BORDER);
		exportTypeTextArea.setLayoutData(gridData4);
		// fill the export types 
		fillExportTypes();

	}

	private void fillExportTypes() {
		int sel = -1;
		exportTypeField.removeAll();
		//TODO get topology here
		TopologyExporterDescriptor selectedDesc = null;
		TopologyExporterDescriptor[] exporters = TopologyManager.getInstance()
				.findAvailableExporters(null);
		for (int i = 0; i < exporters.length; i++) {
			String exportTypeName = exporters[i].getName();
			exportTypeField.add(exportTypeName);
			exportTypeField.setData(exportTypeName, exporters[i]);
			if (sel == -1) {
				selectedDesc = exporters[i];
				sel++;
			}
		}
		if (sel != -1) {
			exportTypeField.setText(selectedDesc.getName());
			exportTypeTextArea.setText(selectedDesc.getDescription());
		}
	}

	protected void createOptionsGroup(Composite parent) {

		// options group
		Composite optionsGroup = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout(1, false);
		optionsGroup.setLayout(layout);
		createSourceFilesCheckbox(optionsGroup);
		createOverwriteExistingFilesCheckbox(optionsGroup);
		createExportWithErrorsCheckbox(optionsGroup);
		createExportCreateLocationBindingCheckBox(optionsGroup);
		createExportDiagramResourceIfPresentCheckBox(optionsGroup);
		createExportProjectCheckBox(optionsGroup);
	}

	protected void createExportCreateLocationBindingCheckBox(Composite optionsGroup) {
		//create location binding checkbox
		createLocationBindingCheckBox = new Button(optionsGroup, SWT.CHECK | SWT.LEFT);
		createLocationBindingCheckBox.setText(Messages.EXPORT_CREATE_LOCATION_BINDING);
		createLocationBindingCheckBox.setEnabled(true);
		synchHelper.synchCheckbox(createLocationBindingCheckBox,
				IDeployTopologyExportDataModelProperties.CREATE_LOCATION_BINDING, null);
	}

	protected void createExportDiagramResourceIfPresentCheckBox(Composite optionsGroup) {
		//create export diagram resource check box
		exportDiagramResourceIfPresentCheckBox = new Button(optionsGroup, SWT.CHECK | SWT.LEFT);
		exportDiagramResourceIfPresentCheckBox.setText(Messages.EXPORT_DIAGRAM_RESOURCE_IF_PRESENT);
		exportDiagramResourceIfPresentCheckBox.setEnabled(true);
		synchHelper.synchCheckbox(exportDiagramResourceIfPresentCheckBox,
				IDeployTopologyExportDataModelProperties.EXPORT_DIAGRAM_RESOURCE_IF_PRESENT, null);
	}

	protected void createExportProjectCheckBox(Composite optionsGroup) {
		//create export diagram resource check box
		createExportProjectCheckBox = new Button(optionsGroup, SWT.CHECK | SWT.LEFT);
		createExportProjectCheckBox.setText(Messages.EXPORT_CREATE_PROJECT);
		createExportProjectCheckBox.setEnabled(true);
		synchHelper.synchCheckbox(createExportProjectCheckBox,
				IDeployTopologyExportDataModelProperties.CREATE_EXPORT_PROJECT, null);
	}

	protected void createOverwriteExistingFilesCheckbox(Composite optionsGroup) {
		//Overwrite checkbox
		overwriteExistingFilesCheckbox = new Button(optionsGroup, SWT.CHECK | SWT.LEFT);
		overwriteExistingFilesCheckbox.setText(Messages.EXPORT_OVERWRITE_CHECKBOX);
		overwriteExistingFilesCheckbox.setEnabled(true);
		synchHelper.synchCheckbox(overwriteExistingFilesCheckbox,
				IDeployTopologyExportDataModelProperties.OVERWRITE_EXISTING, null);
	}

	protected void createSourceFilesCheckbox(Composite optionsGroup) {
		sourceFilesCheckbox = new Button(optionsGroup, SWT.CHECK | SWT.LEFT);
		sourceFilesCheckbox.setText(Messages.EXPORT_SOURCE_CHECKBOX);
		synchHelper.synchCheckbox(sourceFilesCheckbox,
				IDeployTopologyExportDataModelProperties.EXPORT_SOURCE_FILES, null);
	}

	protected void createExportWithErrorsCheckbox(Composite optionsGroup) {
		exportWithErrorsCheckbox = new Button(optionsGroup, SWT.CHECK | SWT.LEFT);
		exportWithErrorsCheckbox.setText(Messages.EXPORT_WITH_ERRORS_LABEL);
		synchHelper.synchCheckbox(exportWithErrorsCheckbox,
				IDeployTopologyExportDataModelProperties.EXPORT_WITH_ERROR, null);
	}

	protected void handleDestinationBrowseButtonPressed() {

		FileDialog dialog = new FileDialog(destinationNameText.getShell(), SWT.SAVE);
		String fileName = exportUIDataModel.getArchiveDestination();
		String[] filters = getFilterExpression();
		if (!isWindows) {
			if (filters.length != 0 && filters[0] != null && filters[0].indexOf('.') != -1) {
				fileName += filters[0].substring(filters[0].indexOf('.'));
			}
		}
		dialog.setFileName(fileName);
		if (isWindows) {
			dialog.setFilterExtensions(filters);
		}
		String filename = dialog.open();
		if (filename != null) {
			destinationNameText.setText(filename);
		}
	}

	protected IProject getProject() {
		String pName = exportUIDataModel.getScribblerDefinition().getProjectName();
		if (pName != null && pName.length() > 0) {
			return ProjectUtilities.getProject(pName);
		}

		return null;
	}

	protected String[] getFilterExpression() {
		return new String[0];
	}

}
