package com.ibm.ccl.soa.deploy.ide.ui.refactoring.wizards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jdt.ui.ISharedImages;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.DecoratedField;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalProvider;
import org.eclipse.jface.fieldassist.TextContentAdapter;
import org.eclipse.jface.fieldassist.TextControlCreator;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.window.Window;
import org.eclipse.ltk.ui.refactoring.UserInputWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.fieldassist.ContentAssistCommandAdapter;
import org.eclipse.ui.fieldassist.ContentAssistField;
import org.eclipse.wst.common.frameworks.datamodel.DataModelEvent;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelListener;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.datamodels.CreateTopologyDataModel;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceElement;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.core.ui.internal.wizards.NamespaceContentProposal;
import com.ibm.ccl.soa.deploy.core.ui.internal.wizards.TopologyNamespaceSelectionDialog;
import com.ibm.ccl.soa.deploy.ide.internal.refactoring.IRenameNamespaceModelProperties;
import com.ibm.ccl.soa.deploy.ide.refactoring.RenameNamespaceRefactoringDescriptor;
import com.ibm.ccl.soa.deploy.ide.ui.refactoring.Messages;
import com.ibm.ccl.soa.infrastructure.ui.internal.epl.TextProcessorDataModelSynchHelper;

public class RenameNamespaceWizardPage1 extends UserInputWizardPage implements IDataModelListener,
		IRenameNamespaceModelProperties {

	private static final IContentProposal[] EMPTY_CONTNENT_PROPOSAL = new IContentProposal[0];
	public static final String PAGE_NAME = "RenameNamespaceWizardPage1";//$NON-NLS-1$
	private final RenameNamespaceRefactoringDescriptor dataModel;
	private final TextProcessorDataModelSynchHelper synchHelper;
	private ContentAssistField namespaceField;
	private Text namespaceText;
	private Label defaultNamespaceLabel = null;
	private Button renameSubNamespacesButton;

	public RenameNamespaceWizardPage1(RenameNamespaceRefactoringDescriptor model, String pageName) {
		super(pageName);
		dataModel = model;
		synchHelper = new TextProcessorDataModelSynchHelper(model.getUnderlyingDataModel());
		setTitle(Messages.RenameNamespaceWizardPage1_Rename_Namespac_);
		setDescription(Messages.RenameNamespaceWizardPage1_Choose_new_name_for_the_selected_na_);
	}

	public void createControl(Composite parent) {

		final Composite composite = new Composite(parent, SWT.NONE);

		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 5;
		gridLayout.marginTop = 8;

		composite.setLayout(gridLayout);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		TextControlCreator controlCreator = new TextControlCreator();

		GridData labelGridData = new GridData();
		labelGridData.horizontalAlignment = GridData.BEGINNING;
		labelGridData.verticalAlignment = GridData.CENTER;

		Label nameLabel = new Label(composite, SWT.NONE);
		nameLabel.setFont(JFaceResources.getDialogFont());
		nameLabel.setText(Messages.RenameNamespaceWizardPage1_Namespac_);
		nameLabel.setLayoutData(labelGridData);

		GridData fieldData = new GridData();
		fieldData.horizontalAlignment = GridData.FILL;
		fieldData.grabExcessHorizontalSpace = true;
		fieldData.verticalAlignment = GridData.CENTER;
		fieldData.horizontalSpan = 2;

		//Setup the namespace field with content assist.
		namespaceField = new ContentAssistField(composite, SWT.BORDER, controlCreator,
				new TextContentAdapter(), createNamespaceContentProposalProvider(), null,
				new char[] { '\\' });
		namespaceField.getLayoutControl().setLayoutData(fieldData);

		//Initialize the ContentAssistCommandAdapter
		ContentAssistCommandAdapter contentAssistAdapter = namespaceField
				.getContentAssistCommandAdapter();
		contentAssistAdapter.setFilterStyle(ContentProposalAdapter.FILTER_NONE);
		contentAssistAdapter.setLabelProvider(new ContentAssistNamespaceLabelProvider(dataModel));
		contentAssistAdapter.setProposalAcceptanceStyle(ContentProposalAdapter.PROPOSAL_REPLACE);

		namespaceText = (Text) namespaceField.getControl();
		namespaceText.addFocusListener(new org.eclipse.swt.events.FocusListener() {
			public void focusGained(FocusEvent e) {
				namespaceText.selectAll();
			}

			public void focusLost(FocusEvent e) {
			}
		});

		defaultNamespaceLabel = new Label(composite, SWT.NONE);
		defaultNamespaceLabel.setText(Messages.RenameNamespaceWizardPage1_default_);
		defaultNamespaceLabel.setFont(JFaceResources.getDialogFont());

		Button namespaceButton = new Button(composite, SWT.NONE);
		namespaceButton.setText(Messages.RenameNamespaceWizardPage1_Browse_);
		namespaceButton.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				TopologyNamespaceSelectionDialog namespaceDialog = new TopologyNamespaceSelectionDialog(
						getShell(), dataModel.getSourceContainer());
				namespaceDialog.setInitialSelections(new Object[] { dataModel
						.getNewNamespaceContainer() });
				//LI 708:  Do not set the filter to be consistent with JDT browsing.
				//	namespaceDialog.setFilter(dataModel.getNamespacePath());
				namespaceDialog.create();
				namespaceDialog.getShell().setSize(new Point(274, 273));
				if (namespaceDialog.open() == Window.OK) {
					String namespace = namespaceDialog.getSelectedNamespace();
					if (namespace != null) {
						dataModel.setNewNamespacePath(namespace);
					}
				}
			}
		});

//		Label renameSubNamespacesLabel = new Label(composite, SWT.NONE);
//		renameSubNamespacesLabel.setFont(JFaceResources.getDialogFont());
//		renameSubNamespacesLabel.setText("Rename subnamespaces"); //$NON-NLS-1$
//		renameSubNamespacesLabel.setLayoutData(labelGridData);

		GridData seperatorData = new GridData();
		seperatorData.horizontalAlignment = GridData.FILL;
		seperatorData.grabExcessHorizontalSpace = true;
		seperatorData.verticalAlignment = GridData.CENTER;
		seperatorData.horizontalSpan = 5;

		Label seperator = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
		seperator.setLayoutData(seperatorData);

		GridData fieldData2 = new GridData();
		fieldData2.horizontalAlignment = GridData.FILL;
		fieldData2.grabExcessHorizontalSpace = true;
		fieldData2.verticalAlignment = GridData.CENTER;
		fieldData2.horizontalSpan = 5;

		renameSubNamespacesButton = new Button(composite, SWT.CHECK);
		renameSubNamespacesButton.setText("Rename subnamespaces"); //$NON-NLS-1$
		renameSubNamespacesButton.setLayoutData(fieldData2);

		setControl(composite);

		bindControls();
		dataModel.getUnderlyingDataModel().addListener(this);

		setPageComplete(false);
	}

	private void bindControls() {
		synchHelper.synchText(namespaceText, NEW_NAMESPACE_PATH, true, null);
		synchHelper.synchCheckbox(renameSubNamespacesButton, RENAME_SUBNAMESPACES, null);
		setDefaultNamespaceLabelText();
	}

	private void setDefaultNamespaceLabelText() {
		String namespacePath = dataModel.getNewNamespacePath();
		if (namespacePath == null || namespacePath.length() == 0) {
			defaultNamespaceLabel.setText(Messages.RenameNamespaceWizardPage1_default_);
		} else {
			defaultNamespaceLabel.setText(""); //$NON-NLS-1$
		}
	}

	public void propertyChanged(DataModelEvent event) {
		if (NEW_NAMESPACE_PATH.equals(event.getPropertyName())) {
			setDefaultNamespaceLabelText();
		}

		setMessage(null);
		setErrorMessage(null);
		setPageComplete(true);
		IStatus status = dataModel.validateNewNamespacePath();

		if (!status.isOK()) {
			IStatus issue = getStatusWithHighestSeverity(status);
			if (issue.getSeverity() <= IStatus.WARNING) {
				setMessage(issue.getMessage(), issue.getSeverity());
			} else {
				setErrorMessage(issue.getMessage());
				setPageComplete(false);
			}
		}
	}

	public INamespaceElement getNewNamespace() {
		IContainer src = dataModel.getSourceContainer();
		INamespaceFragmentRoot root = NamespaceCore.getRoot(src);
		if (dataModel.getNewNamespaceContainer() != null) {
			return root.resolveNamespace(dataModel.getNewNamespacePath());
		}

		return root;
	}

	public INamespaceElement getPreviousNamespace() {
		IContainer src = dataModel.getSourceContainer();
		INamespaceFragmentRoot root = NamespaceCore.getRoot(src);
		if (dataModel.getPreviousNamespaceContainer() != null) {
			return root.resolveNamespace(dataModel.getPreviousNamespacePath());
		}

		return root;
	}

	protected DecoratedField getNamespaceField() {
		return namespaceField;
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

	/*
	 * Create an IContentProposalProvider that will display the available namespaces based on the
	 * entered text. This is necessary to support a ContentAssistField.
	 */
	private IContentProposalProvider createNamespaceContentProposalProvider() {
		return new IContentProposalProvider() {
			/*
			 * Filter the list of namespace proposals (i.e., IFolders) based on the current contents
			 * and the location of the cursor.
			 * 
			 * @see org.eclipse.jface.fieldassist.IContentProposalProvider#getProposals(java.lang.String,
			 *      int)
			 */
			public IContentProposal[] getProposals(String contents, int position) {
				String filter = null;
				if (position > 0) {
					filter = contents.substring(0, position);
				}
				List proposalList = null;
				IContainer sourceFolder = dataModel.getSourceContainer();
				IFolder[] namespaces = TopologyNamespaceSelectionDialog.getNamespaces(sourceFolder);
				if (namespaces.length > 0) {
					proposalList = new ArrayList(namespaces.length);
					int sourceSegments = sourceFolder.getFullPath().segmentCount();
					for (int i = 0; i < namespaces.length; i++) {
						NamespaceContentProposal proposal = new NamespaceContentProposal(namespaces[i],
								sourceSegments);
						if (filter == null || proposal.getContent().startsWith(filter)) {
							proposalList.add(proposal);
						}
					}
				}
				IContentProposal[] proposals = EMPTY_CONTNENT_PROPOSAL;
				if (proposalList != null && !proposalList.isEmpty()) {
					//Sort the namespace proposals.
					Collections.sort(proposalList, new Comparator() {
						public int compare(Object obj1, Object obj2) {
							Assert.isNotNull(obj1);
							Assert.isNotNull(obj2);
							NamespaceContentProposal prop1 = (NamespaceContentProposal) obj1;
							NamespaceContentProposal prop2 = (NamespaceContentProposal) obj2;
							return prop1.getContent().compareToIgnoreCase(prop2.getContent());
						}

					});
					proposals = new IContentProposal[proposalList.size()];
					proposalList.toArray(proposals);
				}
				return proposals;
			}
		};
	}

	public class ContentAssistNamespaceLabelProvider extends NamespaceLabelProvider implements
			IDataModelListener {
		private final RenameNamespaceRefactoringDescriptor dataModel;

		/**
		 * @param dataModel -
		 *           A {@link CreateTopologyDataModel} instance.
		 */
		public ContentAssistNamespaceLabelProvider(RenameNamespaceRefactoringDescriptor dataModel) {
			super(dataModel.getSourceContainer());
			this.dataModel = dataModel;
			dataModel.getUnderlyingDataModel().addListener(this);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.ui.internal.wizards.NamespaceLabelProvider#getText(java.lang.Object)
		 */
		public String getText(Object element) {
			return super.getText(((NamespaceContentProposal) element).getFolder());
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.ui.internal.wizards.NamespaceLabelProvider#getImage(java.lang.Object)
		 */
		public Image getImage(Object element) {
			return super.getImage(((NamespaceContentProposal) element).getFolder());
		}

		/*
		 * If the SOURCE_PATH changes then we have to reset the sourceContainer to ensure that we are
		 * tracking the correct number of source path segments.
		 * 
		 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelListener#propertyChanged(org.eclipse.wst.common.frameworks.datamodel.DataModelEvent)
		 */
		public void propertyChanged(DataModelEvent event) {
			if (event.getFlag() == DataModelEvent.VALUE_CHG
					&& IRenameNamespaceModelProperties.SOURCE_PATH.equals(event.getPropertyName())) {
				super.setSourceContainer(dataModel.getSourceContainer());
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.ibm.ccl.soa.deploy.core.ui.internal.wizards.NamespaceLabelProvider#dispose()
		 */
		public void dispose() {
			//Remove ourself as a listener to the data model.
			if (dataModel != null && dataModel.getUnderlyingDataModel() != null) {
				dataModel.getUnderlyingDataModel().removeListener(this);
			}
			super.dispose();
		}

	}

	class NamespaceLabelProvider implements ILabelProvider {
		private int sourceContainerSegmentCount = 0;

		/**
		 * 
		 * @param aSourceContainer -
		 *           The source {@link IContainer} for the namespaces.
		 */
		public NamespaceLabelProvider(IContainer aSourceContainer) {
			setSourceContainer(aSourceContainer);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
		 */
		public Image getImage(Object element) {
			IContainer container = (IContainer) element;
			String imageKey;
			if (hasFiles(container)) {
				imageKey = ISharedImages.IMG_OBJS_LOGICAL_PACKAGE;
			} else {
				imageKey = ISharedImages.IMG_OBJS_EMPTY_PACKAGE;
			}
			return JavaUI.getSharedImages().getImage(imageKey);
		}

		/**
		 * 
		 * @param container -
		 *           An {@link IContainer}.
		 * @return - true if the passed container has any {@link IFile}s.
		 */
		public boolean hasFiles(IContainer container) {
			try {
				IResource[] members = container.members();
				if (members.length > 0) {
					for (int i = 0; i < members.length; i++) {
						if (members[i].getType() == IResource.FILE) {
							return true;
						}
					}
				}
			} catch (CoreException e) {
				//Fail gracefully.
			}
			return false;
		}

		public String getText(Object element) {
			return getQualifiedName((IContainer) element, sourceContainerSegmentCount);
		}

		/**
		 * 
		 * @param container -
		 *           An {@link IContainer} that is a namespace.
		 * @param sourceFolderSegments -
		 *           The number of segments representing the source folder.
		 * @return A qualified namespace name for the passed container.
		 */
		public String getQualifiedName(IContainer container, int sourceFolderSegments) {
			IPath containerPath = container.getFullPath();
			containerPath = containerPath.removeFirstSegments(sourceFolderSegments);
			if (containerPath.segmentCount() > 0) {
				if (containerPath.segmentCount() == 1) {
					return containerPath.segment(0);
				}
				String[] segments = containerPath.segments();
				StringBuffer buffer = new StringBuffer();
				for (int i = 0; i < segments.length; i++) {
					if (i > 0) {
						buffer.append('.');
					}
					buffer.append(segments[i]);
				}
				return buffer.toString();
			}
			return IConstants.EMPTY_STRING;
		}

		public void addListener(ILabelProviderListener listener) {
		}

		public boolean isLabelProperty(Object element, String property) {
			return false;
		}

		public void removeListener(ILabelProviderListener listener) {
		}

		public void setSourceContainer(IContainer container) {
			if (container != null) {
				sourceContainerSegmentCount = container.getFullPath().segmentCount();
			} else {
				sourceContainerSegmentCount = 0;
			}
		}

		public void dispose() {
		}
	}

}
