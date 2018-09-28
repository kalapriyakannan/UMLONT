package com.ibm.ccl.soa.deploy.core.ui.internal.wizards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
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
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.fieldassist.ContentAssistCommandAdapter;
import org.eclipse.ui.fieldassist.ContentAssistField;
import org.eclipse.wst.common.frameworks.datamodel.DataModelEvent;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelListener;
import org.eclipse.wst.common.frameworks.internal.datamodel.ui.DataModelSynchHelper;
import org.eclipse.wst.common.frameworks.internal.datamodel.ui.DataModelWizardPage;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.datamodels.CreateNamespaceDataModel;
import com.ibm.ccl.soa.deploy.core.datamodels.CreateTopologyDataModel;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.ICreateNamespaceDataModelProperties;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceElement;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.infrastructure.ui.internal.epl.TextProcessorDataModelSynchHelper;

public class CreateNamespaceComposite extends Composite implements IDataModelListener,
		ICreateNamespaceDataModelProperties {

	private static final IContentProposal[] EMPTY_CONTNENT_PROPOSAL = new IContentProposal[0];
	private final TextProcessorDataModelSynchHelper synchHelper;
	private final CreateNamespaceDataModel dataModel;

	private ContentAssistField srcField;
	private Text srcText = null;
	private ContentAssistField namespaceField;
	private Text namespaceText;
	private Label defaultNamespaceLabel = null;

	/**
	 * @param parent -
	 *           The parent {@link Composite}.
	 * @param style -
	 *           The style flag for this {@link Composite}.
	 * @param synchHelper -
	 *           A {@link DataModelSynchHelper} from a {@link DataModelWizardPage} used to bind the
	 *           controls.
	 * @param dataModel -
	 *           A {@link CreateNamespaceDataModel} type safe data model used to hold the property
	 *           values displayed in the {@link Composite}.
	 */
	public CreateNamespaceComposite(Composite parent, int style,
			TextProcessorDataModelSynchHelper synchHelper, CreateNamespaceDataModel dataModel) {
		super(parent, style);
		this.synchHelper = synchHelper;
		this.dataModel = dataModel;
		PlatformUI.getWorkbench().getHelpSystem().setHelp(this,
				IDeployHelpContextIds.TOPOLOGY_EDITOR_NEW_NAMESPACE_WIZARD);
		initialize();
	}

	private void initialize() {

		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 5;
		gridLayout.marginTop = 8;

		this.setLayout(gridLayout);
		this.setLayoutData(new GridData(GridData.FILL_BOTH));

		GridData descGridData = new GridData();
		descGridData.horizontalAlignment = GridData.BEGINNING;
		descGridData.verticalAlignment = GridData.CENTER;
		descGridData.horizontalSpan = 5;

		Label desc = new Label(this, SWT.NONE);
		desc.setFont(JFaceResources.getDialogFont());
		desc.setText(Messages.NewNamespaceDialog_Creates_folders_corresponding_to_na_);
		desc.setLayoutData(descGridData);

		GridData srcLabelGridData = new GridData();
		srcLabelGridData.horizontalAlignment = GridData.BEGINNING;
		srcLabelGridData.verticalAlignment = GridData.CENTER;

		Label srcLabel = new Label(this, SWT.NONE);
		srcLabel.setFont(JFaceResources.getDialogFont());
		srcLabel.setText(Messages.NewNamespaceDialog_Source_folder_);
		srcLabel.setLayoutData(srcLabelGridData);

		GridData textGridData = new GridData();
		textGridData.grabExcessHorizontalSpace = true;
		textGridData.verticalAlignment = GridData.CENTER;
		textGridData.horizontalSpan = 3;
		textGridData.horizontalAlignment = GridData.FILL;

		TextControlCreator controlCreator = new TextControlCreator();

		GridData gridData1 = new GridData();
		gridData1.horizontalAlignment = GridData.FILL;
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.horizontalSpan = 3;
		gridData1.verticalAlignment = GridData.CENTER;

		srcField = new ContentAssistField(this, SWT.BORDER, controlCreator, new TextContentAdapter(),
				createSourceFolderContentProposalProvider(), null, new char[] { '\\' });
		srcField.getLayoutControl().setLayoutData(gridData1);

		//Initialize the ContentAssistCommandAdapter
		ContentAssistCommandAdapter sourceContentAssistAdapter = srcField
				.getContentAssistCommandAdapter();
		sourceContentAssistAdapter.setFilterStyle(ContentProposalAdapter.FILTER_NONE);
		sourceContentAssistAdapter.setLabelProvider(new ContentAssistSourceFolderLabelProvider());
		sourceContentAssistAdapter
				.setProposalAcceptanceStyle(ContentProposalAdapter.PROPOSAL_REPLACE);
		srcText = (Text) srcField.getControl();

		Button srcButton = new Button(this, SWT.PUSH);
		srcButton.setText(Messages.NewNamespaceDialog_Browse_);
		srcButton.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event event) {
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
		});

		GridData nameLabelGridData = new GridData();
		nameLabelGridData.horizontalAlignment = GridData.BEGINNING;
		nameLabelGridData.verticalAlignment = GridData.CENTER;

		Label nameLabel = new Label(this, SWT.NONE);
		nameLabel.setFont(JFaceResources.getDialogFont());
		nameLabel.setText(Messages.NewNamespaceDialog_Name_);
		nameLabel.setLayoutData(nameLabelGridData);

		GridData gridData2 = new GridData();
		gridData2.horizontalAlignment = GridData.FILL;
		gridData2.grabExcessHorizontalSpace = true;
		gridData2.verticalAlignment = GridData.CENTER;
		gridData2.horizontalSpan = 2;

		//Setup the namespace field with content assist.
		namespaceField = new ContentAssistField(this, SWT.BORDER, controlCreator,
				new TextContentAdapter(), createNamespaceContentProposalProvider(), null,
				new char[] { '\\' });
		namespaceField.getLayoutControl().setLayoutData(gridData2);

		//Initialize the ContentAssistCommandAdapter
		ContentAssistCommandAdapter contentAssistAdapter = namespaceField
				.getContentAssistCommandAdapter();
		contentAssistAdapter.setFilterStyle(ContentProposalAdapter.FILTER_NONE);
		contentAssistAdapter.setLabelProvider(new ContentAssistNamespaceLabelProvider(dataModel));
		contentAssistAdapter.setProposalAcceptanceStyle(ContentProposalAdapter.PROPOSAL_REPLACE);

		namespaceText = (Text) namespaceField.getControl();

		defaultNamespaceLabel = new Label(this, SWT.NONE);
		defaultNamespaceLabel.setText(Messages.CreateTopologyComposite2_default_);
		defaultNamespaceLabel.setFont(JFaceResources.getDialogFont());

		Button namespaceButton = new Button(this, SWT.NONE);
		namespaceButton.setText(Messages.CreateTopologyComposite_Browse_);
		namespaceButton.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				TopologyNamespaceSelectionDialog namespaceDialog = new TopologyNamespaceSelectionDialog(
						getShell(), dataModel.getSourceContainer());
				namespaceDialog
						.setInitialSelections(new Object[] { dataModel.getNamespaceContainer() });
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
		});

		bindControls();
		dataModel.getUnderlyingDataModel().addListener(this);
	}

	private void bindControls() {
		synchHelper.processText(srcText, SOURCE_PATH, false, null);
		synchHelper.synchText(namespaceText, NAMESPACE_PATH, true, null);
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

	public void propertyChanged(DataModelEvent event) {
		if (NAMESPACE_PATH.equals(event.getPropertyName())) {
			setDefaultNamespaceLabelText();
		}
	}

	public INamespaceElement getNamespace() {
		IContainer src = dataModel.getSourceContainer();
		INamespaceFragmentRoot root = NamespaceCore.getRoot(src);
		if (dataModel.getNamespaceContainer() != null) {
			return root.resolveNamespace(dataModel.getNamespacePath());
		}

		return root;
	}

	protected DecoratedField getSourceFolderField() {
		return srcField;
	}

	protected DecoratedField getNamespaceField() {
		return namespaceField;
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
		private final CreateNamespaceDataModel dataModel;

		/**
		 * @param dataModel -
		 *           A {@link CreateTopologyDataModel} instance.
		 */
		public ContentAssistNamespaceLabelProvider(CreateNamespaceDataModel dataModel) {
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
					&& ICreateNamespaceDataModelProperties.SOURCE_PATH.equals(event.getPropertyName())) {
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
