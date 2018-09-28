/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.statusview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.osgi.util.TextProcessor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.IFormColors;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.progress.UIJob;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.actions.ExportOpenWizardAction;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployCoreEditor;
import com.ibm.ccl.soa.deploy.core.ui.navigator.actions.TopologyPublisherAction;
import com.ibm.ccl.soa.deploy.core.ui.util.ResourceUtils;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.extension.TopologyManager;
import com.ibm.ccl.soa.deploy.internal.core.extension.TopologyPublisherDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployValidatorJob;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatusGrouper;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.IDeployStatusGroupType;

public class TopologyStatusView extends ViewPart implements IPartListener {

	private JobChangeAdapter validationListener;
	private FormToolkit toolKit = null;
	private ScrolledForm form;
	private InfoCompositeHandler infoCompositeHandler;
	private StatusCompositeHandler realizeCompositeHandler;
	private StatusCompositeHandler customActionCompositeHandler;
	private StatusCompositeHandler hostCompositeHandler;
	private StatusCompositeHandler missingDependencyCompositeHandler;
	private StatusCompositeHandler att_missMatchCompositeHandler;
	private StatusCompositeHandler att_missingCompositeHandler;
	private StatusCompositeHandler otherCompositeHandler;
	private StatusCompositeHandler[] statusHandlers;
	private DeployStatusGrouper grouper = null;
	private Section infoSection;
	private boolean filterWarning;
	private boolean filterError;
	private boolean filterInfo;
	private boolean expandALL;
	int sectionCounter = 0;
	private Form titleform;
	private Composite viewComposite;
	private static int NO_STYLE = -99;
	private boolean showContainer;
	private final static String delems = ".:"; //$NON-NLS-1$

	private ImageDescriptor EXPAND_ALL_IMAGE = DeployCoreUIPlugin.getDefault().getSharedImages()
			.getImageDescriptor(ISharedImages.IMG_EXPAND_ALL_IMAGE);
	private ImageDescriptor COLLAPSE_ALL_IMAGE = DeployCoreUIPlugin.getDefault().getSharedImages()
			.getImageDescriptor(ISharedImages.IMG_COLLAPSE_ALL_IMAGE);
	private ImageDescriptor PUBLISH_IMAGE = DeployCoreUIPlugin.getDefault().getSharedImages()
			.getImageDescriptor(ISharedImages.IMG_PUBLISH_IMAGE);
	private ImageDescriptor EXPORT_IMAGE = DeployCoreUIPlugin.getDefault().getSharedImages()
			.getImageDescriptor(ISharedImages.IMG_EXPORT_IMAGE);
	private ImageDescriptor PARENT_IMAGE = DeployCoreUIPlugin.getDefault().getSharedImages()
			.getImageDescriptor(ISharedImages.IMG_PARENT_IMAGE);
	private Image successImage = DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
			ISharedImages.IMG_SUCCESS_IMAGE);
	private Image seperatorImage = DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
			ISharedImages.IMG_SEPERATOR_IMAGE);
	private Image topologyStatusImage = DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
			ISharedImages.IMG_TOPOLOGY_STATUS);

	private static final String BRIGHT_WHITE_COLOR = "WHITE_COLOR"; //$NON-NLS-1$
	private static final String GREEN_COLOR = "GREEN_COLOR"; //$NON-NLS-1$
	private static final String LIGHT_GRAY_COLOR = "LIGHT_GREY"; //$NON-NLS-1$
	private DropDownAction publishDropDown;
	private ExportOpenWizardAction exportOpenWizardAction;
	private final List<Hyperlink> hyperLinks = new ArrayList<Hyperlink>();
	private int sizeVariable = 1;
	private ToolBarManager toolBarManager;
	final String uiJob = Messages.TopologyStatusView_Update_the_Topology_Status_Vie_;
	final int REFRESH_DELAY = 200;

	@Override
	public void createPartControl(Composite parent) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_STATUS_VIEW);
		toolKit = new FormToolkit(parent.getDisplay());
		loadColors();
		viewComposite = createViewComposite(parent);
		createToolBar(viewComposite);
		Composite whiteBoardComposite = createWhiteBoardComposite(viewComposite);
		Composite formComposite = createParentForm(whiteBoardComposite);
		createInfoSection(formComposite);
		createSeperator(formComposite.getParent());
		createScrollForm(whiteBoardComposite);
		createStatusSections(formComposite);
		createSeperatorImage(form.getBody());
		createHyperLinkArea(form.getBody());
		createValidationJobListener();
		ResourceUtils.addWorkbenchPartListener(this);
		updateView(getEditTopology() != null);
		enableView(getEditTopology() != null, true);

	}

	private void createSeperatorImage(Composite body) {
		Label spacer = toolKit.createLabel(body, StatusCompositeHandler.EMPTY_STRING);
		TableWrapData dataSpace = new TableWrapData(TableWrapData.FILL);
		dataSpace.colspan = 2;
		dataSpace.rowspan = 3;
		spacer.setLayoutData(dataSpace);
		Label label = toolKit.createLabel(body, StatusCompositeHandler.EMPTY_STRING);
		TableWrapData data = new TableWrapData(TableWrapData.FILL);
		data.colspan = 2;
		data.rowspan = 3;
		label.setImage(seperatorImage);
		label.setLayoutData(data);

	}

	private void createHyperLinkArea(Composite whiteBoardComposite) {
		createExportHyperLink(whiteBoardComposite);
		createPublisherHyperLinks(whiteBoardComposite);
	}

	private void createPublisherHyperLinks(Composite whiteBoardComposite) {
		Action[] publishActions = getTopologyActions();
		for (int i = 0; i < publishActions.length; i++) {
			Action action = publishActions[i];
			ImageHyperlink publishHyperLink = toolKit.createImageHyperlink(whiteBoardComposite,
					SWT.NONE);
			publishHyperLink.setImage(PUBLISH_IMAGE.createImage());
			publishHyperLink.setText(action.getText());
			publishHyperLink.setData(action);
			hyperLinks.add(publishHyperLink);
			if (JFaceResources.getFontRegistry().hasValueFor(JFaceResources.BANNER_FONT)) {
				publishHyperLink.setFont(JFaceResources.getFontRegistry().get(
						JFaceResources.DEFAULT_FONT));
			}
			TableWrapData data = new TableWrapData(TableWrapData.FILL_GRAB);
			data.colspan = 2;
			data.indent = 20;
			data.rowspan = 2;
			publishHyperLink.setLayoutData(data);
			publishHyperLink.addHyperlinkListener(new IHyperlinkListener() {

				public void linkActivated(HyperlinkEvent e) {
					if (e.getSource() != null) {
						ImageHyperlink link = (ImageHyperlink) e.getSource();
						if (link.getData() != null) {
							Action publishAction = (Action) link.getData();
							publishAction.run();
						}
					}

				}

				public void linkEntered(HyperlinkEvent e) {

				}

				public void linkExited(HyperlinkEvent e) {

				}
			});

		}

	}

	private void createExportHyperLink(Composite whiteBoardComposite) {
		ImageHyperlink exportHyperLink = toolKit.createImageHyperlink(whiteBoardComposite, SWT.NONE);
		exportHyperLink.setImage(EXPORT_IMAGE.createImage());
		exportHyperLink.setText(Messages.TopologyStatusView_Export_topolog_);
		if (JFaceResources.getFontRegistry().hasValueFor(JFaceResources.BANNER_FONT)) {
			exportHyperLink.setFont(JFaceResources.getFontRegistry().get(JFaceResources.DEFAULT_FONT));
		}
		hyperLinks.add(exportHyperLink);
		TableWrapData data = new TableWrapData(TableWrapData.FILL_GRAB);
		data.colspan = 2;
		data.indent = 20;
		exportHyperLink.setLayoutData(data);
		exportHyperLink.addHyperlinkListener(new IHyperlinkListener() {

			public void linkActivated(HyperlinkEvent e) {
				if (exportOpenWizardAction != null) {
					exportOpenWizardAction.run();
				}

			}

			public void linkEntered(HyperlinkEvent e) {

			}

			public void linkExited(HyperlinkEvent e) {

			}
		});
	}

	private void loadColors() {
		toolKit.getColors().createColor(LIGHT_GRAY_COLOR, 240, 240, 240);
		toolKit.getColors().createColor(BRIGHT_WHITE_COLOR, 255, 255, 255);
		toolKit.getColors().createColor(GREEN_COLOR, 0, 255, 0);

	}

	private void createStatusSections(Composite formComposite) {
		realizeCompositeHandler = createSectionClient(
				DeployCoreMessages.IDeployStatusGroupType_Realize_Concptual_Unit_,
				realizeCompositeHandler);
		customActionCompositeHandler = createSectionClient(
				DeployCoreMessages.IDeployStatusGroupType_Perform_Custom_Action_,
				customActionCompositeHandler);
		hostCompositeHandler = createSectionClient(
				DeployCoreMessages.IDeployStatusGroupType_Host_Unit_, hostCompositeHandler);
		missingDependencyCompositeHandler = createSectionClient(
				DeployCoreMessages.IDeployStatusGroupType_Resolve_Missing_Dependencie_,
				missingDependencyCompositeHandler);
		att_missMatchCompositeHandler = createSectionClient(
				DeployCoreMessages.IDeployStatusGroupType_Fix_Mismatched_Attribute_,
				att_missMatchCompositeHandler);
		att_missingCompositeHandler = createSectionClient(
				DeployCoreMessages.IDeployStatusGroupType_Set_Missing_Attribute_,
				att_missingCompositeHandler);
		otherCompositeHandler = createSectionClient(DeployCoreMessages.IDeployStatusGroupType_OTHE_,
				otherCompositeHandler);
		statusHandlers = new StatusCompositeHandler[] { realizeCompositeHandler,
				customActionCompositeHandler, hostCompositeHandler, missingDependencyCompositeHandler,
				att_missingCompositeHandler, att_missMatchCompositeHandler, otherCompositeHandler };

	}

	private void createSeperator(Composite whiteBoardComposite) {
		Composite composite = new Composite(whiteBoardComposite, SWT.BORDER);
		composite.setBackground(toolKit.getColors().getColor(IFormColors.H_BOTTOM_KEYLINE2));
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		//	TableWrapData data = new TableWrapData(TableWrapData.FILL_GRAB);
		data.heightHint = 1;
		//	data.colspan = 1;
		composite.setLayoutData(data);
		//composite.setBackground(toolKit.getColors().getColor(IFormColors.H_GRADIENT_START));

	}

	private void createSeperator(Composite whiteBoardComposite, int type) {
		Composite composite = new Composite(whiteBoardComposite, SWT.NONE);
		composite.setBackground(toolKit.getColors().getColor(IFormColors.H_BOTTOM_KEYLINE2));
		GridData data = new GridData(type);
		data.heightHint = 1;
		composite.setLayoutData(data);

	}

	protected StatusCompositeHandler createSectionClient(String sectionTitle,
			StatusCompositeHandler handler) {
		Label imageLabel = toolKit.createLabel(form.getBody(), ""); //$NON-NLS-1$
		TableWrapData tableWrap = new TableWrapData(TableWrapData.LEFT);
		imageLabel.setImage(StatusCompositeHandler.SUCCESS_IMAGE);
		imageLabel.setLayoutData(tableWrap);
		Section section = createSection(NO_STYLE, null);
		section.setFont(JFaceResources.getDialogFont());
		section.setText(sectionTitle);
		section.setBackground(toolKit.getColors().getColor(IFormColors.TB_BG));
		handler = new StatusCompositeHandler(toolKit, section, imageLabel, sectionTitle);
		section.setClient(handler.getClientComposite());
		toolKit.paintBordersFor(handler.getClientComposite());
		section.layout(true);
		return handler;

	}

	private Section createSection(int style, Composite formComposite) {
		Section section = null;
		if (style == NO_STYLE) {
			style = ExpandableComposite.TWISTIE;

		}
		if (formComposite == null) {
			section = toolKit.createSection(form.getBody(), style);
			section.setBackground(toolKit.getColors().getBackground());
			TableWrapData td = new TableWrapData(TableWrapData.FILL_GRAB);
			section.setLayoutData(td);
		} else {
			section = toolKit.createSection(formComposite, style);
			GridData td = new GridData(GridData.FILL_BOTH);
			section.setLayoutData(td);

		}

		section.addExpansionListener(new ExpansionAdapter() {
			public void expansionStateChanged(ExpansionEvent e) {
				form.reflow(true);
			}
		});
		return section;
	}

	private Composite createParentForm(Composite viewComposite) {
		titleform = toolKit.createForm(viewComposite);
		titleform.getBody().setLayout(new GridLayout());
		titleform.getBody().setLayoutData(new GridData(GridData.FILL_BOTH));
		titleform.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		titleform.setLayout(layout);
		toolKit.decorateFormHeading(titleform);
		if (JFaceResources.getFontRegistry().hasValueFor(JFaceResources.BANNER_FONT)) {
			titleform.setFont(JFaceResources.getFontRegistry().get(JFaceResources.BANNER_FONT));
		}
		if (getEditTopology() == null) {
			titleform.setText(Messages.TopologyStatusView_Could_not_resolve_topolog_);
		}
		if (getEditTopology() != null) {
			updateTitle(""); //$NON-NLS-1$
		}
		titleform.setBackground(toolKit.getColors().getColor(IFormColors.H_GRADIENT_START));
		return titleform.getBody();
	}

	private void createInfoSection(Composite viewComposite) {
		viewComposite.setBackground(toolKit.getColors().getColor(IFormColors.H_GRADIENT_START));
		infoSection = createSection(ExpandableComposite.NO_TITLE, viewComposite);
		infoSection.setBackground(toolKit.getColors().getColor(IFormColors.H_GRADIENT_START));
		infoCompositeHandler = new InfoCompositeHandler(toolKit, infoSection);
		infoSection.setClient(infoCompositeHandler.getClientComposite());
		infoCompositeHandler.getClientComposite().setBackground(
				toolKit.getColors().getColor(IFormColors.H_GRADIENT_START));
		infoCompositeHandler.addStatusListener(new IStatusListener() {
			public void statusChange(StatusEvent event) {
				filterSections(event.severityType);

			}

		});
		toolKit.paintBordersFor(infoCompositeHandler.getClientComposite());

	}

	private void filterSections(int severityType) {
		for (int i = 0; i < statusHandlers.length; i++) {
			StatusCompositeHandler statusHandler = statusHandlers[i];
			statusHandler.handleFilter(severityType);
		}

	}

	private Composite createViewComposite(Composite parent) {
		Composite viewComposite = new Composite(parent, SWT.NONE);
		GridLayout gridLayout = new GridLayout();
		GridData gridData = new GridData(GridData.FILL_BOTH);
		viewComposite.setLayout(gridLayout);
		viewComposite.setLayoutData(gridData);
		return viewComposite;

	}

	private Composite createWhiteBoardComposite(Composite viewComposite) {
		Composite whiteBoardComposite = new Composite(viewComposite, SWT.NONE);
		GridLayout gridLayoutWhite = new GridLayout();
		gridLayoutWhite.marginWidth = 0;
		gridLayoutWhite.marginHeight = 0;
		GridData gridDataWhite = new GridData(GridData.FILL_BOTH);
		whiteBoardComposite.setLayout(gridLayoutWhite);
		whiteBoardComposite.setLayoutData(gridDataWhite);
		whiteBoardComposite.setBackground(toolKit.getColors().getColor(IFormColors.H_GRADIENT_START));
		return whiteBoardComposite;
	}

	private void createToolBar(Composite parent) {
		toolBarManager = (ToolBarManager) getViewSite().getActionBars().getToolBarManager();
		initializeToolBar();
		toolBarManager.update(true);

	}

	private void initializeToolBar() {
		//toolBarManager.getControl().setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));
		toolBarManager.add(getPublishAction());
		toolBarManager.add(getExportAction());
		toolBarManager.add(new Separator());

		toolBarManager.add(new Action(Messages.StatusCompositeHandler_show_deployment_model_,
				PARENT_IMAGE) {
			public void run() {
				showContainer = !showContainer;
				for (int i = 0; i < statusHandlers.length; i++) {
					StatusCompositeHandler handler = statusHandlers[i];
					handler.handleParentAction(showContainer);
				}
			}
		});

		toolBarManager.add(new Action(Messages.TopologyStatusView_expand_collapse_sections_,
				EXPAND_ALL_IMAGE) {
			public void run() {
				expandALL = !expandALL;
				expandAllSection(expandALL);
				if (expandALL) {
					setImageDescriptor(COLLAPSE_ALL_IMAGE);
				} else {
					setImageDescriptor(EXPAND_ALL_IMAGE);
				}
			}
		});
		toolBarManager.update(true);
		//toolBar.layout(true);

	}

	private IAction getExportAction() {
		exportOpenWizardAction = new ExportOpenWizardAction(getTopologyFile());
		exportOpenWizardAction.setImageDescriptor(EXPORT_IMAGE);
		exportOpenWizardAction.setText(Messages.TopologyStatusView_export_topolog_);
		return exportOpenWizardAction;
	}

	private IFile getTopologyFile() {
		return ResourceUtil.getFile(getEditTopology());
	}

	private IAction getPublishAction() {
		publishDropDown = new DropDownAction(PUBLISH_IMAGE, null) {

			public Action[] getSubActions() {
				return getTopologyActions();
			}

			public IContributionItem[] getSubItems() {
				return new IContributionItem[0];
			}

			@Override
			public int getStyle() {
				// TODO Auto-generated method stub
				return AS_DROP_DOWN_MENU;
			}

		};
		publishDropDown.setText(Messages.TopologyStatusView_Publish_topologie_);
		return publishDropDown;

	}

	protected Action[] getTopologyActions() {
		TopologyPublisherDescriptor[] descriptors = TopologyManager.getInstance()
				.findAvailablePublishers(getEditTopology());
		Action[] actions = new Action[descriptors.length];
		for (int x = 0; x < descriptors.length; ++x) {
			actions[x] = new TopologyPublisherAction(form.getShell(), descriptors[x],
					getEditTopology());
		}
		return actions;
	}

	protected void expandAllSection(boolean checked) {
		for (int i = 0; i < statusHandlers.length; i++) {
			StatusCompositeHandler statusHandler = statusHandlers[i];
			if (grouper != null) {
				if (grouper.getCount(statusHandler.getSectionType(), IStatus.ERROR) > 0
						|| grouper.getCount(statusHandler.getSectionType(), IStatus.WARNING) > 0
						|| grouper.getCount(statusHandler.getSectionType(), IStatus.INFO) > 0) {
					statusHandler.expand(checked);
				} else {
					statusHandler.expand(false);
				}
			} else {
				statusHandler.expand(checked);
			}

		}

	}

	protected void updateAllSections(DeployStatusGrouper grouper, boolean shouldUpdateTitle) {
		for (int i = 0; i < statusHandlers.length; i++) {
			StatusCompositeHandler statusHandler = statusHandlers[i];
			statusHandler.update(grouper, shouldUpdateTitle);
		}
	}

	private void updateTitle(String message) {
		if (titleform == null || getEditTopology() == null) {
			return;
		}
		String viewTitle = getEditTopology().getQualifiedName() + ": " + message; //$NON-NLS-1$
		viewTitle = TextProcessor.deprocess(viewTitle);
		viewTitle = TextProcessor.process(viewTitle, delems);
		titleform.setText(viewTitle);
	}

	private void createScrollForm(Composite parent) {
		form = toolKit.createScrolledForm(parent);
		TableWrapLayout layout = new TableWrapLayout();
		layout.numColumns = 2;
		form.getBody().setLayout(layout);
		form.getBody().setLayoutData(new TableWrapData(TableWrapData.FILL));
		form.setLayoutData(new GridData(GridData.FILL_BOTH));
		Label descriptionLabel = toolKit.createLabel(form.getBody(),
				Messages.TopologyStatusView_Use_the_list_below_to_identify_and_, SWT.WRAP);
		TableWrapData data = new TableWrapData();
		data.colspan = 2;
		descriptionLabel.setLayoutData(data);
	}

	private void createValidationJobListener() {

		validationListener = new JobChangeAdapter() {

			final UIJob refreshJob = new UIJob(uiJob) {

				@Override
				public IStatus runInUIThread(IProgressMonitor monitor) {
					enableView(true, false);
					updateView(true);
					resetSize();
					return Status.OK_STATUS;
				}

				private void resetSize() {
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							if (sizeVariable > 1) {
								titleform.setSize(titleform.getSize().x - 1, titleform.getSize().y);
								sizeVariable++;
							} else {
								titleform.setSize(titleform.getSize().x + 1, titleform.getSize().y);
								sizeVariable--;
							}

						}
					});

				}
			};

			@Override
			public void aboutToRun(IJobChangeEvent event) {
				if (event.getJob() instanceof DeployValidatorJob) {
					enableView(false, false);

				}
			}

			public void done(IJobChangeEvent event) {
				if (event.getJob() instanceof DeployValidatorJob) {
					refreshJob.schedule(REFRESH_DELAY);
				}
			}

		};

		Job.getJobManager().addJobChangeListener(validationListener);
	}

	private void updateView(final boolean updateStatusNumbers) {
		grouper = new DeployStatusGrouper(getEditTopology(), isFilterErrorSet(),
				isFilterWarningSet(), isFilterInfoSet());
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				if (grouper != null && !infoCompositeHandler.getClientComposite().isDisposed()) {
					updateTitle(""); //$NON-NLS-1$
					infoCompositeHandler.update(grouper, updateStatusNumbers);
					if (grouper.getCount(IDeployStatusGroupType.GLOBAL, IStatus.ERROR) != 0) {
						publishDropDown.setEnabled(false);
						exportOpenWizardAction.setEnabled(false);
						updateHyperLinks(false);
						if (getTitleImage() != topologyStatusImage && topologyStatusImage != null) {
							setTitleImage(topologyStatusImage);
						}

					} else {
						publishDropDown.setEnabled(true);
						exportOpenWizardAction.setEnabled(true);
						exportOpenWizardAction.setTopologyFile(getTopologyFile());
						updateHyperLinks(true);
						setTitleImage(successImage);

					}
					infoSection.layout(true);
					updateAllSections(grouper, updateStatusNumbers);
				}

			}

			private void updateHyperLinks(boolean enable) {
				for (Iterator iterator = hyperLinks.iterator(); iterator.hasNext();) {
					Hyperlink link = (Hyperlink) iterator.next();
					link.setEnabled(enable);
					Object data = link.getData();
					if (data != null || data instanceof TopologyPublisherAction) {
						TopologyPublisherAction action = (TopologyPublisherAction) data;
						action.setTopology(getEditTopology());
					}
				}
			}
		});

	}

	private Topology getEditTopology() {
		//TODO temp until i can talk to Alexander about exposing the topology in validatorJob
		Object part = ResourceUtils.getActiveEditorPart();
		if (part != null && part instanceof DeployCoreEditor) {
			DeployCoreEditor dce = (DeployCoreEditor) part;
			if (dce.getDiagram() != null && dce.getDiagram().getElement() instanceof Topology) {
				return (Topology) dce.getDiagram().getElement();
			}
		}
		return null;

	}

	private void enableView(final boolean enable, final boolean visable) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				if (viewComposite.isDisposed()) {
					return;
				}
				enableComposite(viewComposite, enable, visable);
				if (toolBarManager.getControl().getEnabled() != enable) {
					toolBarManager.getControl().setEnabled(enable);
//				for (int i = 0; i < toolBarManager.getItems().length; i++) {
//					IContributionItem item = toolBarManager.getItems()[i];
//					item.setVisible(enable);
//					toolBarManager.update(true);
//				}
				}

			}
		});

	}

	private Composite enableComposite(Composite parent, boolean enable, boolean hideVisable) {
		if (parent == null) {
			return null;
		}
		Control[] controls = parent.getChildren();
		for (int i = 0; i < controls.length; i++) {
			Control control = controls[i];
			if (control instanceof Composite) {
				if (enable) {
					if (control.getBackground().getRGB().equals(
							toolKit.getColors().getColor(LIGHT_GRAY_COLOR).getRGB())) {
						control.setBackground(toolKit.getColors().getColor(BRIGHT_WHITE_COLOR));
						if (hideVisable) {
							control.setVisible(true);
						}
					}
				} else {
					if (control.getBackground().getRGB().equals(
							toolKit.getColors().getColor(BRIGHT_WHITE_COLOR).getRGB())) {
						control.setBackground(toolKit.getColors().getColor(LIGHT_GRAY_COLOR));
						if (hideVisable) {
							control.setVisible(false);
						}
					}
				}

				enableComposite((Composite) control, enable, hideVisable);
			}
		}
		return null;
	}

	@Override
	public void dispose() {
		removeJobListener();
		toolKit.dispose();
		ResourceUtils.removeWorkbenchPartListener(this);
		successImage = null;
		topologyStatusImage = null;
		seperatorImage = null;
		EXPAND_ALL_IMAGE = null;
		COLLAPSE_ALL_IMAGE = null;
		PUBLISH_IMAGE = null;
		EXPORT_IMAGE = null;
		PARENT_IMAGE = null;
		successImage = null;
		seperatorImage = null;
		super.dispose();
	}

	private void removeJobListener() {
		Job.getJobManager().removeJobChangeListener(validationListener);
	}

	public void setFilterErrors(boolean filterError) {
		this.filterError = filterError;
	}

	public void setFilterInfos(boolean filterInfo) {
		this.filterInfo = filterInfo;
	}

	public void setFilterWarnings(boolean filterWarning) {
		this.filterWarning = filterWarning;
	}

	public boolean isFilterWarningSet() {
		return filterWarning;
	}

	public boolean isFilterErrorSet() {
		return filterError;
	}

	public boolean isFilterInfoSet() {
		return filterInfo;
	}

	IWorkbenchPart currentPart = null;

	public void partBroughtToTop(IWorkbenchPart part) {
		final UIJob topJob = new UIJob(uiJob) {

			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				enableView(true, false);
				updateView(true);
				return Status.OK_STATUS;
			}
		};
		if (part instanceof DeployCoreEditor) {
			currentPart = part;
			topJob.schedule(REFRESH_DELAY);
		}

	}

	public void partClosed(IWorkbenchPart part) {
		final UIJob closeJob = new UIJob(uiJob) {

			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				if (viewComposite.isDisposed()) {
					return Status.OK_STATUS;
				}
				updateView(true);
				for (int i = 0; i < statusHandlers.length; i++) {
					StatusCompositeHandler handler = statusHandlers[i];
					if (handler.getClientComposite() != null
							&& !handler.getClientComposite().isDisposed()) {
						handler.clear();
						enableView(false, true);
						titleform.setText(StatusCompositeHandler.EMPTY_STRING);
					}

				}
				return Status.OK_STATUS;
			}
		};

		if ((currentPart == part || currentPart == null) && !viewComposite.isDisposed()) {
			if (part instanceof DeployCoreEditor) {
				closeJob.schedule(REFRESH_DELAY);
			}
		}

	}

	public void partDeactivated(IWorkbenchPart part) {
	}

	public void partOpened(IWorkbenchPart part) {
		final UIJob openJob = new UIJob(uiJob) {

			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				enableView(true, true);
				updateView(true);
				return Status.OK_STATUS;
			}
		};
		if (part instanceof DeployCoreEditor) {
			currentPart = part;
			openJob.schedule(REFRESH_DELAY);
		}
	}

	public void partActivated(IWorkbenchPart part) {
	}

	@Override
	public void setFocus() {
		if (viewComposite != null) {
			viewComposite.setFocus();
		}

	}

}
