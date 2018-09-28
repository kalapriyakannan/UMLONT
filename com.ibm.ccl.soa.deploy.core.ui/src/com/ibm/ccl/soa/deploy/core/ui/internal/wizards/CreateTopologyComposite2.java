/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.wizards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.DecoratedField;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalProvider;
import org.eclipse.jface.fieldassist.TextContentAdapter;
import org.eclipse.jface.fieldassist.TextControlCreator;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.actions.NewProjectAction;
import org.eclipse.ui.fieldassist.ContentAssistCommandAdapter;
import org.eclipse.ui.fieldassist.ContentAssistField;
import org.eclipse.ui.forms.HyperlinkGroup;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.wst.common.frameworks.datamodel.DataModelEvent;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelListener;
import org.eclipse.wst.common.frameworks.internal.datamodel.ui.DataModelSynchHelper;
import org.eclipse.wst.common.frameworks.internal.datamodel.ui.DataModelWizardPage;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.datamodels.CreateTopologyDataModel;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.IAddToPaletteDataModelProperties;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.ICreateTopologyDataModelProperties;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceElement;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.infrastructure.ui.internal.epl.TextProcessorDataModelSynchHelper;

/**
 * @author daberg
 * 
 */
public class CreateTopologyComposite2 extends Composite implements IDataModelListener,
		ICreateTopologyDataModelProperties {

	private static final IContentProposal[] EMPTY_CONTNENT_PROPOSAL = new IContentProposal[0];
	private final TextProcessorDataModelSynchHelper synchHelper;
	private final CreateTopologyDataModel dataModel;

	private Label nameLabel = null;
	private Text topologyNameText = null;
	private Label sourceFolderLabel = null;
	private Text sourceFolderText = null;
	private Button sourceFolderButton = null;
	private Label namespaceLabel = null;
	private Text namespaceText = null;
	private Button namespaceButton = null;
	private Label typeLabel = null;
	private Combo typeCombo = null;
	private Text typeTextArea = null;
	private Label descriptionLabel = null;
	private Text descriptionTextArea = null;
	private Label defaultNamespaceLabel = null;
	private Label optionLabel = null;
	private Button addToTopologyCheckBox = null;
	private ContentAssistField namespaceContentAssistField = null;
	private ContentAssistField sourceFolderContentAssistField = null;
	private DecoratedField nameDecoratedField = null;
	private Label contractLabel;
	private Combo contractCombo;

	private static final class NewProjectChangeListener implements IResourceChangeListener,
			IResourceDeltaVisitor {
		private final CreateTopologyDataModel topDataModel;
		private final Display display;

		private NewProjectChangeListener(CreateTopologyDataModel aDataModel, Display aDisplay) {
			topDataModel = aDataModel;
			display = aDisplay;
		}

		public void resourceChanged(IResourceChangeEvent event) {
			IResourceDelta delta = event.getDelta();
			try {
				delta.accept(this);
			} catch (CoreException e) {
				DeployCoreUIPlugin.logError(0, e.getLocalizedMessage(), e);
			}
		}

		public boolean visit(IResourceDelta delta) throws CoreException {
			switch (delta.getKind())
			{
			case IResourceDelta.CHANGED:
				return delta.getResource().getType() == IResource.ROOT;
			case IResourceDelta.ADDED:
				//Was it a project?
				final IResource res = delta.getResource();
				if (res.getType() == IResource.PROJECT) {
					//Set on the datamodel
					final String sourcepath = res.getName() + "/topologies"; //$NON-NLS-1$
					if (Display.getCurrent() != null) {
						topDataModel.setSourcePath(sourcepath);
					}
					display.asyncExec(new Runnable() {
						public void run() {
							topDataModel.setSourcePath(res.getName() + "/topologies"); //$NON-NLS-1$
						}
					});
				}
			}
			return false;
		}
	}

	/**
	 * @param parent -
	 *           The parent {@link Composite}.
	 * @param style -
	 *           The style flag for this {@link Composite}.
	 * @param synchHelper -
	 *           A {@link DataModelSynchHelper} from a {@link DataModelWizardPage} used to bind the
	 *           controls.
	 * @param dataModel -
	 *           A {@link CreateTopologyDataModel} type safe data model used to hold the property
	 *           values displayed in the {@link Composite}.
	 */
	public CreateTopologyComposite2(Composite parent, int style,
			TextProcessorDataModelSynchHelper synchHelper, CreateTopologyDataModel dataModel) {
		super(parent, style);
		this.synchHelper = synchHelper;
		this.dataModel = dataModel;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 */
	@SuppressWarnings("deprecation")
	private void initialize() {

		GridData gridData8 = new GridData();
		gridData8.horizontalAlignment = GridData.FILL;
		gridData8.horizontalSpan = 2;
		gridData8.minimumHeight = 100;
		GridData gridData7 = new GridData();
		gridData7.horizontalAlignment = GridData.BEGINNING;
		gridData7.horizontalSpan = 3;
		GridData gridData6 = new GridData();
		gridData6.horizontalAlignment = GridData.BEGINNING;
		gridData6.verticalAlignment = GridData.BEGINNING;
		GridData gridData5 = new GridData();
		gridData5.horizontalAlignment = GridData.FILL;
		gridData5.grabExcessVerticalSpace = true;
		gridData5.horizontalSpan = 3;
		gridData5.verticalAlignment = GridData.FILL;
		gridData5.minimumHeight = 100;
		GridData gridData4 = new GridData();
		gridData4.horizontalAlignment = GridData.FILL;
		gridData4.grabExcessHorizontalSpace = true;
		gridData4.grabExcessVerticalSpace = true;
		gridData4.horizontalSpan = 3;
		gridData4.verticalAlignment = GridData.FILL;
		gridData4.minimumHeight = 65;
		GridData gridData2 = new GridData();
		gridData2.horizontalAlignment = GridData.FILL;
		gridData2.grabExcessHorizontalSpace = true;
		gridData2.verticalAlignment = GridData.CENTER;
		gridData2.horizontalSpan = 2;
		GridData gridData1 = new GridData();
		gridData1.horizontalAlignment = GridData.FILL;
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.horizontalSpan = 3;
		gridData1.verticalAlignment = GridData.CENTER;
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.verticalAlignment = GridData.CENTER;
		gridData.horizontalSpan = 3;
		gridData.horizontalAlignment = GridData.FILL;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 5;
		nameLabel = new Label(this, SWT.NONE);
		nameLabel.setFont(JFaceResources.getDialogFont());
		nameLabel.setText(Messages.DEPLOYMENTMODEL_NAME);
		TextControlCreator controlCreator = new TextControlCreator();
		nameDecoratedField = new DecoratedField(this, SWT.BORDER, controlCreator);
		nameDecoratedField.getLayoutControl().setLayoutData(gridData);
//        new Label(this, SWT.NONE);
//        topologyNameText = new Text(this, SWT.BORDER);
//        topologyNameText.setLayoutData(gridData);
		topologyNameText = (Text) nameDecoratedField.getControl();
		new Label(this, SWT.NONE);
		sourceFolderLabel = new Label(this, SWT.NONE);
		sourceFolderLabel.setText(Messages.CreateTopologyComposite_Source_Folder_);
		sourceFolderLabel.setFont(JFaceResources.getDialogFont());
		// Setup the namespace field with content assist.
		sourceFolderContentAssistField = new ContentAssistField(this, SWT.BORDER, controlCreator,
				new TextContentAdapter(), createSourceFolderContentProposalProvider(), null,
				new char[] { '\\' });
		sourceFolderContentAssistField.getLayoutControl().setLayoutData(gridData1);
		//Initialize the ContentAssistCommandAdapter
		ContentAssistCommandAdapter sourceContentAssistAdapter = sourceFolderContentAssistField
				.getContentAssistCommandAdapter();
		sourceContentAssistAdapter.setFilterStyle(ContentProposalAdapter.FILTER_NONE);
		sourceContentAssistAdapter.setLabelProvider(new ContentAssistSourceFolderLabelProvider());
		sourceContentAssistAdapter
				.setProposalAcceptanceStyle(ContentProposalAdapter.PROPOSAL_REPLACE);
		sourceFolderText = (Text) sourceFolderContentAssistField.getControl();
//        new Label(this, SWT.NONE);
//        sourceFolderText = new Text(this, SWT.BORDER);
//        sourceFolderText.setLayoutData(gridData1);
		sourceFolderButton = new Button(this, SWT.NONE);
		sourceFolderButton.setText(Messages.CreateTopologyComposite_Browse_);
		sourceFolderButton.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				browseSourceFolderButtonPressed();
			}
		});
		//Add create project hyperlink
		initializeCreateProjectHyperlink(dataModel);

		namespaceLabel = new Label(this, SWT.NONE);
		namespaceLabel.setFont(JFaceResources.getDialogFont());
		namespaceLabel.setText(Messages.CreateTopologyComposite_Namespace_);
		//Setup the namespace field with content assist.
		namespaceContentAssistField = new ContentAssistField(this, SWT.BORDER, controlCreator,
				new TextContentAdapter(), createNamespaceContentProposalProvider(), null,
				new char[] { '\\' });
		namespaceContentAssistField.getLayoutControl().setLayoutData(gridData2);
		//Initialize the ContentAssistCommandAdapter
		ContentAssistCommandAdapter contentAssistAdapter = namespaceContentAssistField
				.getContentAssistCommandAdapter();
		contentAssistAdapter.setFilterStyle(ContentProposalAdapter.FILTER_NONE);
		contentAssistAdapter.setLabelProvider(new ContentAssistNamespaceLabelProvider(dataModel));
		contentAssistAdapter.setProposalAcceptanceStyle(ContentProposalAdapter.PROPOSAL_REPLACE);

		namespaceText = (Text) namespaceContentAssistField.getControl();
		// Label filler111 = new Label(this, SWT.NONE);
//        namespaceText = new Text(this, SWT.BORDER);
//        namespaceText.setLayoutData(gridData2);
		defaultNamespaceLabel = new Label(this, SWT.NONE);
		defaultNamespaceLabel.setText(Messages.CreateTopologyComposite2_default_);
		defaultNamespaceLabel.setFont(JFaceResources.getDialogFont());
		namespaceButton = new Button(this, SWT.NONE);
		namespaceButton.setText(Messages.CreateTopologyComposite_Browse_);
		namespaceButton.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				browseNamespaceButtonPressed();
			}
		});
		typeLabel = new Label(this, SWT.NONE);
		typeLabel.setText(Messages.CreateTopologyComposite_Type_);
		typeLabel.setFont(JFaceResources.getDialogFont());
		this.setLayout(gridLayout);
		int fillerLabelWidth = FieldDecorationRegistry.getDefault().getMaximumDecorationWidth();
		GridData fillerData = new GridData();
		fillerData.widthHint = fillerLabelWidth / 2;
		Label typeFiller = new Label(this, SWT.NONE);
		typeFiller.setLayoutData(fillerData);
		createTypeCombo();
		this.setSize(new Point(375, 308));
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		typeTextArea = new Text(this, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.READ_ONLY
				| SWT.BORDER);
		typeTextArea.setLayoutData(gridData4);

		contractLabel = new Label(this, SWT.NONE);
		contractLabel.setFont(JFaceResources.getDialogFont());
		contractLabel.setText(Messages.CreateTopologyComposite2_Contract_);
		this.setLayout(gridLayout);
		GridData contractFillerData = new GridData();
		contractFillerData.widthHint = fillerLabelWidth / 2;
		Label contractFiller = new Label(this, SWT.NONE);
		contractFiller.setLayoutData(contractFillerData);
		createContractCombo();
		new Label(this, SWT.NONE);
//        
		descriptionLabel = new Label(this, SWT.NONE);
		descriptionLabel.setFont(JFaceResources.getDialogFont());
		descriptionLabel.setText(Messages.DEPLOYMENTMODEL_DESCRIPTION);
		descriptionLabel.setLayoutData(gridData6);
		new Label(this, SWT.NONE);
		descriptionTextArea = new Text(this, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.BORDER);
		descriptionTextArea.setLayoutData(gridData5);

		optionLabel = new Label(this, SWT.NONE);
		optionLabel.setFont(JFaceResources.getDialogFont());
		optionLabel.setText(Messages.CreateTopologyComposite2_Option_);
		optionLabel.setLayoutData(gridData8);
		if (dataModel.getUnderlyingDataModel().isProperty(
				IAddToPaletteDataModelProperties.ADD_TO_PALETTE)) {
			addToTopologyCheckBox = new Button(this, SWT.CHECK);
			addToTopologyCheckBox.setText(Messages.CreateTopologyComposite2_Add_topology_to_palett_);
			addToTopologyCheckBox.setLayoutData(gridData7);
		}

		dataModel.getUnderlyingDataModel().addListener(this);
		bindControls();

		//Select Identity Contract initially
		String[] items = contractCombo.getItems();
		for (int i = 0; i < items.length; i++) {
			//TODO grab externalized reference from descriptor when
			//michael makes this change
			if (items[i].equals("Identity Contract")) { //$NON-NLS-1$
				contractCombo.select(i);
				break;
			}
		}
	}

	private void initializeCreateProjectHyperlink(CreateTopologyDataModel aDataModel) {
		//GridLayout has 4 columns. Need to pad 2 spaces on front.
		new Label(this, SWT.NONE); //filler
		new Label(this, SWT.NONE); //filler
		//Add hyperLink
		HyperlinkGroup group = new HyperlinkGroup(getDisplay());
		Hyperlink link = new Hyperlink(this, SWT.NONE);
		group.add(link);
		link.setUnderlined(true);
		link.setText(Messages.CreateTopologyComposite2_Create_a_new_projec_);
		GridData gd = new GridData();
		gd.horizontalSpan = 3;
		link.setLayoutData(gd);
		link.addHyperlinkListener(new IHyperlinkListener() {
			public void linkExited(HyperlinkEvent e) {
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkActivated(HyperlinkEvent e) {
				//Launch the new project wizard.
				IResourceChangeListener resourceListener = new NewProjectChangeListener(dataModel,
						getDisplay());
				ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceListener,
						IResourceChangeEvent.POST_CHANGE);
				try {
					NewProjectAction action = new NewProjectAction();
					action.run();
				} finally {
					ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceListener);
				}
			}
		});
	}

	private void createContractCombo() {

		GridData gridData3 = new GridData();
		gridData3.horizontalAlignment = GridData.FILL;
		gridData3.horizontalSpan = 2;
		gridData3.verticalAlignment = GridData.CENTER;
		contractCombo = new Combo(this, SWT.READ_ONLY);
		contractCombo.setLayoutData(gridData3);

	}

	/**
	 * This method initializes typeCombo
	 * 
	 */
	private void createTypeCombo() {
		GridData gridData3 = new GridData();
		gridData3.horizontalAlignment = GridData.FILL;
		gridData3.horizontalSpan = 2;
		gridData3.verticalAlignment = GridData.CENTER;
		typeCombo = new Combo(this, SWT.READ_ONLY);
		typeCombo.setLayoutData(gridData3);
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

	/*
	 * Create an IContentProposalProvider that will display the available source folders based on the
	 * entered text. This is necessary to support a ContentAssistField.
	 */
	private IContentProposalProvider createSourceFolderContentProposalProvider() {
		return new IContentProposalProvider() {
			/*
			 * Filter the list of source folder proposals (i.e., IFolders) based on the current
			 * contents and the location of the cursor.
			 * 
			 * @see org.eclipse.jface.fieldassist.IContentProposalProvider#getProposals(java.lang.String,
			 *      int)
			 */
			public IContentProposal[] getProposals(String contents, int position) {
				String filter = null;
				if (position > 0) {
					filter = contents.substring(0, position);
				}
				List proposalList = new ArrayList();
				if (filter != null && filter.length() > 0) {
					IPath filterPath = new Path(filter);
					boolean endsWithPathSep = filter.charAt(filter.length() - 1) == '/';
					collectFilteredProposals(filterPath, endsWithPathSep, proposalList);
				} else {
					collectContainerProposals(ResourcesPlugin.getWorkspace().getRoot(), null, null,
							false, proposalList);
				}
				IContentProposal[] proposals = EMPTY_CONTNENT_PROPOSAL;
				if (proposalList != null && !proposalList.isEmpty()) {
					Collections.sort(proposalList, new Comparator() {
						public int compare(Object obj1, Object obj2) {
							Assert.isNotNull(obj1);
							Assert.isNotNull(obj2);
							IContainer container1 = ((SourceFolderContentProposal) obj1).getContainer();
							IContainer container2 = ((SourceFolderContentProposal) obj2).getContainer();
							return container1.getName().compareToIgnoreCase(container2.getName());
						}

					});
					proposals = new IContentProposal[proposalList.size()];
					proposalList.toArray(proposals);
				}
				return proposals;
			}

			private void collectFilteredProposals(IPath filter, boolean endsWithPathSep,
					List proposalList) {
				if (filter.segmentCount() > 1 || endsWithPathSep) {
					IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(
							filter.segment(0));
					if (project != null && project.exists()) {
						if (filter.segmentCount() > 2) {
							//We should not be here yet since a source folder must be
							//the project or a folder directly under the project.
							//Need to find the parent container and then filter.
							String lastSegment = filter.lastSegment();
							IPath parentPath = filter.removeFirstSegments(0);
							parentPath = parentPath.removeLastSegments(0);
							IContainer parentContainer = project.getFolder(parentPath);
							if (parentContainer != null && parentContainer.exists()) {
								collectContainerProposals(parentContainer, lastSegment, filter, false,
										proposalList);
							}
						} else {
							//Only need to filter based on last segment.
							String lastSegment = filter.segmentCount() > 1 ? filter.lastSegment() : null;
							collectContainerProposals(project, lastSegment, filter, false, proposalList);
						}
					}
				} else {
					IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
					IContainer filterContainer = getContainerToFilter(root, filter);
					if (filterContainer != null) {
						IPath filterPath = filterContainer == root ? null : filter;
						String filterString = filter.lastSegment();
						boolean includeProject = root != filterContainer;
						if (includeProject) {
							includeProject = filterString != null
									&& filterString.length() != filterContainer.getName().length();
						}
						if (filterContainer != root) {
							//Do not filter any further;
							filterString = null;
						}
						collectContainerProposals(filterContainer, filterString, filterPath,
								includeProject, proposalList);
					}
				}
			}

			private IContainer getContainerToFilter(IWorkspaceRoot root, IPath filterPath) {
				String filter = filterPath.lastSegment();
				if (filter == null || filter.length() == 0) {
					return root;
				}
				//Check if more than one project fits the filter.
				IProject[] projects = root.getProjects();
				IProject foundProject = null;
				for (int i = 0; i < projects.length; i++) {
					if (projects[i].getName().startsWith(filter)) {
						if (foundProject == null) {
							foundProject = projects[i];
						} else {
							return root;
						}
					}
				}
				return foundProject;
			}

			private void collectContainerProposals(IContainer container, String filter,
					IPath filterPath, boolean includeContainer, List proposalList) {
				if (container != null) {
					if (includeContainer) {
						proposalList.add(new SourceFolderContentProposal(container, filterPath));
					}
					try {
						IResource[] members = container.members();
						for (int i = 0; i < members.length; i++) {
							String memberName = members[i].getName();
							switch (members[i].getType())
							{
							case IResource.FOLDER:
							case IResource.PROJECT:
								if (!memberName.startsWith(String.valueOf(IConstants.DOT_SEPARATOR))
										&& (filter == null || memberName.startsWith(filter))
										&& isValidSourceFolder((IContainer) members[i])) {
									SourceFolderContentProposal proposal = new SourceFolderContentProposal(
											(IContainer) members[i], filterPath);
									proposalList.add(proposal);
									if (members[i].getType() == IResource.PROJECT) {
										collectContainerProposals((IContainer) members[i], null, filterPath,
												false, proposalList);
									}
								}
								break;
							}
						}
					} catch (CoreException e) {
						DeployCoreUIPlugin.logError(0, e.getMessage(), e);
					}
				}
			}

			private boolean isValidSourceFolder(IContainer container) {
				INamespaceElement namespaceElement = NamespaceCore.create(container);
				return namespaceElement == null
						|| namespaceElement.getType() != INamespaceElement.TOPOLOGY_NAMESPACE;
			}
		};
	}

	@SuppressWarnings("restriction")
	private void bindControls() {
		synchHelper.synchText(topologyNameText, TOPOLOGY_NAME, true, null);
		synchHelper.processText(sourceFolderText, SOURCE_PATH, false, null);
		synchHelper.synchText(namespaceText, NAMESPACE_PATH, true, null);
		synchHelper.synchCombo(typeCombo, DECORATOR_SEMANTIC, null);
		synchHelper.synchCombo(contractCombo, CONTRACT_TYPE, null);
		synchHelper.synchText(typeTextArea, DECORATOR_SEMANTIC_DESCRIPTION, false, null);
		synchHelper.synchText(descriptionTextArea, TOPOLOGY_DESCRIPTION, true, null);
		if (dataModel.getUnderlyingDataModel().isProperty(
				IAddToPaletteDataModelProperties.ADD_TO_PALETTE)) {
			synchHelper.synchCheckbox(addToTopologyCheckBox,
					IAddToPaletteDataModelProperties.ADD_TO_PALETTE, null);
		}
		setDefaultNamespaceLabelText();
	}

	private void setDefaultNamespaceLabelText() {
		String namespacePath = dataModel.getNamespacePath();
		if (namespacePath == null || namespacePath.length() == 0) {
			defaultNamespaceLabel.setText(Messages.CreateTopologyComposite2_default_);
		} else {
			defaultNamespaceLabel.setText(""); //$NON-NLS-1$
		}
	}

	/*
	 * Open the TopologySourceFolderSelectionDialog.
	 */
	protected void browseSourceFolderButtonPressed() {
		TopologySourceFolderSelectionDialog sourceFolderDialog = new TopologySourceFolderSelectionDialog(
				getShell());
		sourceFolderDialog.create();
		sourceFolderDialog.setSelection(dataModel.getSourceContainer());
		sourceFolderDialog.getShell().setSize(new Point(274, 273));
		if (sourceFolderDialog.open() == Window.OK) {
			IContainer container = sourceFolderDialog.getSelectedSourceFolder();
			if (container != null) {
				dataModel.setSourcePath(container.getFullPath().makeRelative().toString());
			}
		}
	}

	/*
	 * Open the TopologyNamespaceSelectionDialog.
	 */
	protected void browseNamespaceButtonPressed() {
		TopologyNamespaceSelectionDialog namespaceDialog = new TopologyNamespaceSelectionDialog(
				getShell(), dataModel.getSourceContainer());
		namespaceDialog.setInitialSelections(new Object[] { dataModel.getNamespaceContainer() });
		//LI 708:  Do not set the filter to be consistent with JDT browsing.
		//	namespaceDialog.setFilter(dataModel.getNamespacePath());
		namespaceDialog.create();
		namespaceDialog.getShell().setSize(new Point(274, 273));
		if (namespaceDialog.open() == Window.OK) {
			String namespace = namespaceDialog.getSelectedNamespace();
			if (namespace != null) {
				dataModel.setNamespacePath(namespace);
			}
		}
	}

	/*
	 * Update the defaultNamespaceLabelText when the NAMESPACE_PATH changes.
	 * 
	 * @see org.eclipse.wst.common.frameworks.datamodel.IDataModelListener#propertyChanged(org.eclipse.wst.common.frameworks.datamodel.DataModelEvent)
	 */
	public void propertyChanged(DataModelEvent event) {
		if (NAMESPACE_PATH.equals(event.getPropertyName())) {
			setDefaultNamespaceLabelText();
		}
	}

	protected DecoratedField getSourceFolderField() {
		return sourceFolderContentAssistField;
	}

	protected DecoratedField getNamespaceField() {
		return namespaceContentAssistField;
	}

	protected DecoratedField getNameField() {
		return nameDecoratedField;
	}

} //  @jve:decl-index=0:visual-constraint="79,13"
