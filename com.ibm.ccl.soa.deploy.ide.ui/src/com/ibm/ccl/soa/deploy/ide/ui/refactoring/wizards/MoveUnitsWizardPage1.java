package com.ibm.ccl.soa.deploy.ide.ui.refactoring.wizards;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.window.Window;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.ui.refactoring.UserInputWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.wst.common.frameworks.datamodel.DataModelEvent;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelListener;

import com.ibm.ccl.soa.deploy.core.datamodels.CreateTopologyDataModel;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.ICreateTopologyDataModelProperties;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.OpenTopologyDialog;
import com.ibm.ccl.soa.deploy.core.ui.internal.wizards.CreateTopologyComposite2;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.IMoveUnitsModelProperties;
import com.ibm.ccl.soa.deploy.ide.refactoring.MoveUnitsRefactoringDescriptor;
import com.ibm.ccl.soa.deploy.ide.ui.refactoring.Messages;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;
import com.ibm.ccl.soa.infrastructure.ui.internal.epl.TextProcessorDataModelSynchHelper;

public class MoveUnitsWizardPage1 extends UserInputWizardPage implements IDataModelListener,
		IMoveUnitsModelProperties {

	public static final String PAGE_NAME = "MoveUnitsWizardPage1";//$NON-NLS-1$
	private final MoveUnitsRefactoringDescriptor dataModel;
	private final TextProcessorDataModelSynchHelper synchHelper;

	private Label topologyLabel = null;
	private Text topologyText = null;
	private Button browseButton = null;

	private Label importInstructionLabel = null;
	private Button source = null;
	private Button destination = null;

	private NewTopologyDialog newTopologyDialog;

	public MoveUnitsWizardPage1(MoveUnitsRefactoringDescriptor model, String pageName) {
		super(pageName);
		dataModel = model;
		synchHelper = new TextProcessorDataModelSynchHelper(model.getUnderlyingDataModel());
		setTitle(Messages.MoveUnitsWizardPage1_Select_destination_and_import_locat_);
		setDescription(Messages.MoveUnitsWizardPage1_Select_a_topology_as_the_destinatio_);
	}

	public void createControl(final Composite parent) {
		final Composite composite = new Composite(parent, SWT.NONE);
		composite.setSize(465, 355);

		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 5;
		gridLayout.marginTop = 8;

		composite.setLayout(gridLayout);

		GridData labelGridData = new GridData();
		labelGridData.horizontalAlignment = GridData.BEGINNING;
		labelGridData.verticalAlignment = GridData.CENTER;

		topologyLabel = new Label(composite, SWT.NONE);
		topologyLabel.setFont(JFaceResources.getDialogFont());
		topologyLabel.setText(Messages.MoveUnitsWizardPage1_Topolog_);
		topologyLabel.setLayoutData(labelGridData);

		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.verticalAlignment = GridData.CENTER;
		gridData.horizontalSpan = 3;
		gridData.horizontalAlignment = GridData.FILL;

		topologyText = new Text(composite, SWT.BORDER);
		topologyText.setLayoutData(gridData);

		browseButton = new Button(composite, SWT.PUSH);
		browseButton.setText(Messages.ChooseExistingTopologyComposite_Browse_);
		browseButton.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event event) {
				BrowseTopologyDialog dialog = new BrowseTopologyDialog(parent.getShell());
				dialog.create();
				dialog.limitToProject(WorkbenchResourceHelper.getProject(dataModel.getUnits()[0]
						.eResource()));
				int result = dialog.open();
				if (result == Window.OK) {
					Object[] selections = dialog.getResult();
					if (selections != null && selections.length > 0) {
						Object selection = selections[0];
						if (selection instanceof IResource) {
							IResource aResource = (IResource) selection;
							topologyText.setText(aResource.getFullPath().toString());
							dataModel.setUseExistingTopology(Boolean.TRUE);
							dataModel.setExistingTopologyFile(aResource.getFullPath().toString());
						}
					}
				}
			}

		});

		GridData linkData = new GridData(GridData.FILL_HORIZONTAL);
		linkData.grabExcessHorizontalSpace = true;
		linkData.horizontalAlignment = GridData.BEGINNING;
		linkData.horizontalSpan = 5;
		linkData.verticalAlignment = GridData.FILL;
		linkData.horizontalIndent = 50;

		Link link = new Link(composite, SWT.NONE);
		link.setText(Messages.MoveUnitsWizardPage1_Create_a_new_topolog_);
		link.setLayoutData(linkData);
		link.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event event) {
				openNewTopologyDialog();
			}

		});

		GridData labelGridData2 = new GridData();
		labelGridData2.horizontalAlignment = GridData.BEGINNING;
		labelGridData2.verticalAlignment = GridData.CENTER;
		labelGridData2.horizontalSpan = 5;

		Label spacer = new Label(composite, SWT.NONE);
		spacer.setLayoutData(labelGridData2);

		importInstructionLabel = new Label(composite, SWT.NONE);
		importInstructionLabel.setFont(JFaceResources.getDialogFont());
		importInstructionLabel
				.setText(Messages.MoveUnitsWizardPage1_Specify_Import_location_to_preserve_);
		importInstructionLabel.setLayoutData(labelGridData2);

		GridData gridData2 = new GridData();
		gridData2.grabExcessHorizontalSpace = true;
		gridData2.verticalAlignment = GridData.CENTER;
		gridData2.horizontalSpan = 5;
		gridData2.horizontalAlignment = GridData.FILL;
		gridData2.horizontalIndent = 50;

		source = new Button(composite, SWT.RADIO);
		source.setText(Messages.MoveUnitsWizardPage1_Source_topolog_);
		source.setLayoutData(gridData2);
		source.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event event) {
				destination.setSelection(false);
				source.setSelection(true);
				dataModel.setPreserveLinks(PRESERVE_LINKS_IN_SOURCE);
			}

		});

		destination = new Button(composite, SWT.RADIO);
		destination.setText(Messages.MoveUnitsWizardPage1_Destination_topolog_);
		destination.setLayoutData(gridData2);
		destination.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event event) {
				source.setSelection(false);
				destination.setSelection(true);
				dataModel.setPreserveLinks(PRESERVE_LINKS_IN_DESTINATION);
			}

		});

		newTopologyDialog = new NewTopologyDialog(getShell(), synchHelper, dataModel
				.getTopologyCreationDataModel());
		newTopologyDialog.create();

		setControl(composite);
		bindControls();
		updateImportRadioButtons();

		dataModel.getUnderlyingDataModel().addListener(this);
		setPageComplete(false);

		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_REFACTOR_MOVE_UNIT);
	}

	private void bindControls() {
		synchHelper.processText(topologyText, EXISTING_TOPOLOGY_FILE, false, null);
	}

	private void updateImportRadioButtons() {
		boolean preserveLinksInSource = dataModel.getPreserveLinks().equals(
				IMoveUnitsModelProperties.PRESERVE_LINKS_IN_SOURCE);
		boolean preserveLinksInDestination = dataModel.getPreserveLinks().equals(
				IMoveUnitsModelProperties.PRESERVE_LINKS_IN_DESTINATION);
		boolean preserveLinksInNeither = dataModel.getPreserveLinks().equals(
				IMoveUnitsModelProperties.PRESERVE_LINKS_IN_NEITHER);
		boolean restricted = dataModel.getPreserveLinksRestricted().booleanValue();

		if (preserveLinksInSource) {
			source.setSelection(true);
			if (restricted) {
				destination.setEnabled(false);
			} else {
				destination.setEnabled(true);
			}
		} else if (preserveLinksInDestination) {
			destination.setSelection(true);
			if (restricted) {
				source.setEnabled(false);
			} else {
				source.setEnabled(true);
			}
		} else if (preserveLinksInNeither && restricted) {
			destination.setSelection(false);
			destination.setEnabled(false);
			source.setSelection(false);
			source.setEnabled(false);
		} else {
			source.setEnabled(true);
			destination.setEnabled(true);
		}
	}

	public void propertyChanged(DataModelEvent event) {
		IStatus status = dataModel.validate();
		updateImportRadioButtons();
		setPageComplete(RefactoringStatus.create(status));
	}

	protected void openNewTopologyDialog() {
		int result = newTopologyDialog.open();
		if (result == Window.OK) {
			dataModel.setUseExistingTopology(false);
			topologyText.setText(dataModel.getTopologyCreationDataModel().getTopologyFile()
					.getFullPath().toString());
		} else {
			dataModel.setUseExistingTopology(true);
			dataModel.setExistingTopologyFile(null);
			topologyText.setText(new String());
		}
	}

	public boolean isLastUserInputPage() {
		return true;
	}

	private IStatus getStatusWithHighestSeverity(IStatus status) {
		if (!status.isMultiStatus()) {
			return status;
		}

		IStatus highest = status;
		for (int i = 0; i < status.getChildren().length; i++) {
			IStatus aStatus = status.getChildren()[i];
			if (highest.getSeverity() == aStatus.getSeverity()) {
				highest = aStatus;
				break;
			}
		}

		return highest;
	}

	class BrowseTopologyDialog extends OpenTopologyDialog {

		public BrowseTopologyDialog(Shell parentShell) {
			super(parentShell);
			this.setTitle(Messages.MoveUnitsWizardPage1_Browse_Topolog_);
			description = Messages.MoveUnitsWizardPage1_Choose_or_create_a_topology_;
		}

		public void limitToProject(IProject project) {
			viewer.setInput(project);
		}
	}

	class NewTopologyDialog extends TitleAreaDialog implements IDataModelListener,
			ICreateTopologyDataModelProperties {

		private final TextProcessorDataModelSynchHelper synchHelper;
		private final CreateTopologyDataModel dataModel;

		public NewTopologyDialog(Shell parent, TextProcessorDataModelSynchHelper synchHelper,
				CreateTopologyDataModel dataModel) {
			super(parent);
			super.setTitleImage(DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
					ISharedImages.IMG_TOP_WIZ_BAN));
			PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
					IDeployHelpContextIds.TOPOLOGY_NEW_TOPOLOGY_WIZARD);
			this.synchHelper = synchHelper;
			this.dataModel = dataModel;
		}

		@Override
		protected Control createDialogArea(Composite parent) {
			Composite dialogArea = (Composite) super.createDialogArea(parent);
			dialogArea.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));
			new CreateTopologyComposite2(dialogArea, SWT.NONE, synchHelper, dataModel);
			dataModel.getUnderlyingDataModel().addListener(this);
			return dialogArea;
		}

		@Override
		public void create() {
			//Override so we can disable the ok button
			super.create();
			super.getOKButton().setEnabled(false);
			super.setTitle(Messages.MoveUnitsWizardPage1_Topolog__2);
			super.setMessage(Messages.MoveUnitsWizardPage1_Select_a_name_source_folder_and_a_);
			super.getShell().setText(Messages.MoveUnitsWizardPage1_Topolog__2);
		}

		public void propertyChanged(DataModelEvent event) {
			super.setErrorMessage(null);
			super.getButton(IDialogConstants.OK_ID).setEnabled(false);
			IStatus status = dataModel.validate();
			if (status.isOK()) {
				super.getButton(IDialogConstants.OK_ID).setEnabled(true);
			} else {
				IStatus highest = getStatusWithHighestSeverity(status);
				if (highest.matches(IStatus.INFO | IStatus.WARNING)) {
					super.getButton(IDialogConstants.OK_ID).setEnabled(true);
					super.setMessage(highest.getMessage());
				} else {
					super.setErrorMessage(highest.getMessage());
				}
			}
		}
	}

}
