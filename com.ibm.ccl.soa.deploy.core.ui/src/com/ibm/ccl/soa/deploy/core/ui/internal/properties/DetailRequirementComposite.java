/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.properties;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Reference;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.datamodels.LinkDiscoveryDataModel;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.composites.DmoTabbedComposite;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.RequirementDetailPopupDialog;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.RequirementLinkChangeManager.RequirementLinkChangeHandler;
import com.ibm.ccl.soa.deploy.core.ui.properties.DmoSyncHelper;
import com.ibm.ccl.soa.deploy.core.ui.properties.DmoSyncHelperModel;
import com.ibm.ccl.soa.deploy.core.ui.properties.LightweightOperationFactory;
import com.ibm.ccl.soa.deploy.core.ui.properties.Messages;
import com.ibm.ccl.soa.deploy.core.ui.properties.NewLinkWizard;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;

/**
 * Composite for editing a single {@link Requirement}.
 * 
 * @author daberg
 * @see RequirementDetailPopupDialog
 */
public class DetailRequirementComposite extends DmoTabbedComposite implements
		RequirementLinkChangeHandler {

	private CLabel capabilityLabel;
	private Text dmoTypeText;
	private CLabel typeLabel;
	private Combo linkTypeCombo;
	private CLabel targetLabel; // link target
	private Hyperlink targetHyperLink; // link target
	private Button deleteTargetButton; // link target
	private Label typeIcon;
	private Label linkIcon;
	private CLabel nameLabel; // caption
	private Text titleText; // caption
	private Combo usageCombo;
	private final RequirementsPropertiesLabelProvider labelProvider;
	private boolean isPopup;
	private Shell parentPopupShell;
	private DetailRequirementDmoSynchHelperModel model;
	private final CellEditor[] readOnlyExpressionCellEditors = new CellEditor[4];
	private Label usageIcon;
	private boolean shouldResizeShellForExpressions = true;
	private FormToolkit dmoTypeBrowwf;
	private Button dmoTypeBrowseButton;

	private class RequirementDmoBrowseDialog extends DmoTypeSelectionDialog {
		/**
		 * 
		 * @param parent
		 * @param renderer
		 */
		private RequirementDmoBrowseDialog(Shell parent, String aTitle, boolean showCapabilities,
				boolean showUnits) {
			super(parent, aTitle, showCapabilities, showUnits);
		}

		protected Control createDialogArea(Composite parent) {
			PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
					IDeployHelpContextIds.TOPOLOGY_REQUIREMENTS_FLYOUT_SEL_REQUIREMENT_BROWSE_TYPE);
			return super.createDialogArea(parent);
		}

	}

	/**
	 * @param parent
	 * @param style
	 * @param labelProvider
	 * @param formToolkit
	 * @param allowExpandShell
	 */
	public DetailRequirementComposite(Composite parent, int style,
			RequirementsPropertiesLabelProvider labelProvider, FormToolkit formToolkit,
			boolean allowExpandShell) {
		super(parent, style, formToolkit, false);
		this.labelProvider = labelProvider;
		model.setTypeImageProvider(labelProvider);
		getSynchHelper().updateUIWithModel(CorePackage.Literals.REQUIREMENT__DMO_TYPE);
		this.getShell().addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				dispose();
			}
		});
		shouldResizeShellForExpressions = allowExpandShell;
		initializeContents(getSynchHelper());
	}

	@Override
	protected DmoSyncHelperModel createDmoSyncHelperModel() {
		model = new DetailRequirementDmoSynchHelperModel();
		model.addListener(new Adapter() {
			public void setTarget(Notifier newTarget) {
			}

			public void notifyChanged(final Notification notification) {
				Runnable runnable = null;
				//If the displayName changes we need to update the header of the form.
				final Object feature = notification.getFeature();
				if (dmo == notification.getNotifier()) {
					//The link type changed so update the target labels
					if (CorePackage.Literals.REQUIREMENT__LINK_TYPE == feature) {
						//setLinkTargetLabel();
						if (basicUpdateLinkContent()) {
							getSynchHelper().updateUIWithModel(
									CorePackage.Literals.DEPLOY_LINK__TARGET_URI);
						}
					}
					switch (notification.getEventType())
					{
					case Notification.ADD:
					case Notification.ADD_MANY:
						runnable = new Runnable() {
							public void run() {
								if (CorePackage.Literals.REQUIREMENT__DEPENDENCY_LINK_GROUP == feature) {
									//Link was added.
									getSynchHelper().updateUIWithModel(
											CorePackage.Literals.DEPLOY_LINK__TARGET_URI);
									updateLinkContent();
								}
							}
						};
						break;
					case Notification.REMOVE:
					case Notification.REMOVE_MANY:
						runnable = new Runnable() {
							public void run() {
								if (CorePackage.Literals.REQUIREMENT__DEPENDENCY_LINK_GROUP == feature) {
									//Link was removed.
									getSynchHelper().updateUIWithModel(
											CorePackage.Literals.DEPLOY_LINK__TARGET_URI);
									updateLinkContent();
								}
							}
						};
						break;
					}
				}
				if (runnable != null) {
					if (Display.getCurrent() == null) {
						Display.getDefault().asyncExec(runnable);
					} else {
						runnable.run();
					}
				}
			}

			public boolean isAdapterForType(Object type) {
				return false;
			}

			public Notifier getTarget() {
				return null;
			}
		});
		return model;
	}

	@Override
	protected void initializeMainContent(Composite parent, DmoSyncHelper aSynchHelper) {
		initializeGeneralContents(parent, aSynchHelper);
	}

	protected void initializeGeneralContents(Composite body, DmoSyncHelper aSynchHelper) {
		TabbedPropertySheetWidgetFactory wf = (TabbedPropertySheetWidgetFactory) getWidgetFactory();
		String emptyString = ""; //$NON-NLS-1$
		GridData gridData12 = new GridData();
		gridData12.horizontalAlignment = GridData.FILL;
		gridData12.verticalAlignment = GridData.CENTER;
		GridData gridData11 = new GridData();
		gridData11.verticalAlignment = GridData.CENTER;
		gridData11.grabExcessHorizontalSpace = true;
		gridData11.horizontalAlignment = GridData.FILL;
		GridData gridData1 = new GridData();
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.verticalAlignment = GridData.CENTER;
		gridData1.horizontalAlignment = GridData.FILL;
		GridData gridData = new GridData();
		// gridData.grabExcessHorizontalSpace = true;
		gridData.verticalAlignment = GridData.CENTER;
		gridData.horizontalAlignment = GridData.FILL;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 4;
		//Caption
		nameLabel = wf.createCLabel(body, Messages.DetailRequirementComposite_Caption_, SWT.FLAT);
		new Label(body, SWT.NONE);
		titleText = wf.createText(body, emptyString, SWT.BORDER | SWT.NONE);
		titleText.setLayoutData(gridData12);
		new Label(body, SWT.NONE);

		//Link Type
		typeLabel = wf.createCLabel(body, Messages.DetailRequirementComposite_Link_type_, SWT.FLAT);
		linkIcon = wf.createLabel(body, emptyString, SWT.FLAT);
		linkIcon.setImage(DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
				ISharedImages.IMG_DEPENDENCY_LINK_TYPE));
		linkTypeCombo = new Combo(body, SWT.READ_ONLY | SWT.FLAT);
		wf.adapt(linkTypeCombo, false, false);
		linkTypeCombo.setVisibleItemCount(3);
		linkTypeCombo.setLayoutData(gridData1);
		new Label(body, SWT.NONE);

		//Type
		capabilityLabel = wf.createCLabel(body, Messages.DiagramPropertySection_TypeLabel, SWT.FLAT);
		typeIcon = wf.createLabel(body, emptyString, SWT.FLAT);
		typeIcon.setImage(DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
				ISharedImages.IMG_DEPENDENT_REQ));
		dmoTypeText = wf.createText(body, emptyString, SWT.READ_ONLY);
		dmoTypeText.setLayoutData(gridData);
		dmoTypeBrowseButton = wf.createButton(body,
				"..."/* Messages.TypeConstraintUIHandler_Browse_ */, //$NON-NLS-1$
				SWT.PUSH);

		//Usage
		wf.createCLabel(body, Messages.DetailRequirementComposite_Usage_, SWT.FLAT);
		usageIcon = wf.createLabel(body, emptyString, SWT.FLAT);
		usageIcon.setImage(DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
				ISharedImages.IMG_USE_REQUIRED));
		usageCombo = new Combo(body, SWT.FLAT | SWT.READ_ONLY);
		wf.adapt(usageCombo, false, false);
		usageCombo.setLayoutData(gridData1);
		new Label(body, SWT.NONE);

		//Link Target
		targetLabel = wf.createCLabel(body, Messages.DetailRequirementComposite_Target_, SWT.FLAT);
		new Label(body, SWT.NONE);
		targetHyperLink = wf.createHyperlink(body, Messages.DetailRequirementComposite_Set_Target_,
				SWT.FLAT);
		targetHyperLink.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL));
		deleteTargetButton = wf.createButton(body, emptyString, SWT.TOGGLE | SWT.FLAT);
		deleteTargetButton.setImage(DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
				ISharedImages.IMG_DELETE_LINK));
		deleteTargetButton
				.setToolTipText(Messages.RequirementsDialog_Remove_link_to_selected_target_);

		//Set layout
		body.setLayout(gridLayout);
		body.setLayoutData(gridData11);

		//Bind Controls
		aSynchHelper.synchText(titleText, CorePackage.Literals.DEPLOY_MODEL_OBJECT__DISPLAY_NAME,
				true, null);
		aSynchHelper.synchCombo(usageCombo, CorePackage.Literals.REQUIREMENT__USE, usageIcon, null);
		aSynchHelper.synchText(dmoTypeText, CorePackage.Literals.REQUIREMENT__DMO_TYPE, typeIcon,
				new Control[] { dmoTypeBrowseButton });
		aSynchHelper.synchCombo(linkTypeCombo, CorePackage.Literals.REQUIREMENT__LINK_TYPE, linkIcon,
				null);
		aSynchHelper.synchHyperlink(targetHyperLink, CorePackage.Literals.DEPLOY_LINK__TARGET_URI,
				null);

		setListeners();
	}

	private void setListeners() {
		initializeDeleteTargetButtonAction();
		initializeTargetHyperLinkAction();
		initializeDmoTypeBrowseButtonAction();
	}

	private void initializeDmoTypeBrowseButtonAction() {
		dmoTypeBrowseButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				DmoTypeSelectionDialog elsd = new RequirementDmoBrowseDialog(
						getShell(),
						com.ibm.ccl.soa.deploy.core.ui.Messages.DetailRequirementComposite_Set_Requirement_Typ_,
						shouldBrowseForCapabilities(), shouldBrowseForUnits());
				if (elsd.open() == Window.OK) {
					final EClass ec = elsd.getSelectedEType();
					IUndoableOperation op = new AbstractEMFOperation(
							TransactionUtil.getEditingDomain(dmo),
							com.ibm.ccl.soa.deploy.core.ui.Messages.DetailRequirementComposite_Set_Requirement_Typ_) {

						@Override
						protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
								throws ExecutionException {
							//Set dmo type on the Requirement.
							Requirement req = (Requirement) dmo;
							req = convertRequirementTypeIfNecessary(req, ec);
							req.setDmoEType(ec);
							return Status.OK_STATUS;
						}

						/*
						 * DCB - I hate doing this but until we can remove Reference and use Constraints
						 * we are stuck.
						 */
						private Requirement convertRequirementTypeIfNecessary(Requirement req, EClass ec) {
							Requirement result = req;
							if (ec != null && CorePackage.Literals.SERVICE.isSuperTypeOf(ec)) {
								//Convert to Reference.
								if (!(req instanceof Reference)) {
									Reference ref = CoreFactory.eINSTANCE.createReference();
									replaceRequirement(req, ref);
									result = ref;
								}
							} else {
								//Ensure we have a Requirement and not a Reference.
								if (req instanceof Reference) {
									result = CoreFactory.eINSTANCE.createRequirement();
									replaceRequirement(req, result);
								}
							}
							return result;
						}

						private void replaceRequirement(Requirement originalReq,
								Requirement replacementReq) {
							Unit parent = (Unit) originalReq.getParent();
							if (parent != null) {
								copyAttributes(replacementReq, originalReq);
								//int index = parent.getRequirements().indexOf(originalReq);
								parent.getRequirements().remove(originalReq);
								//parent.getRequirements().add(index, replacementReq);
								parent.getRequirements().add(replacementReq);
							}
						}

						private void copyAttributes(Requirement req1, Requirement req2) {
							req1.setName(req2.getName());
							req1.setDisplayName(req2.getDisplayName());
							req1.setLinkType(req2.getLinkType());
							req1.setUse(req2.getUse());
							req2.setLink(req1.getLink());
							req1.getConstraints().addAll(req2.getConstraints());
						}
					};
					LightweightOperationFactory.execute(dmo, op);
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
	}

	protected boolean shouldBrowseForCapabilities() {
		return !shouldBrowseForUnits();
	}

	protected boolean shouldBrowseForUnits() {
		if (dmo != null) {
			return ((Requirement) dmo).getLinkType() == RequirementLinkTypes.MEMBER_LITERAL;
		}
		return false;
	}

	private void initializeTargetHyperLinkAction() {
		targetHyperLink.addHyperlinkListener(new IHyperlinkListener() {

			public void linkExited(HyperlinkEvent e) {
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkActivated(HyperlinkEvent e) {
				Requirement req = (Requirement) dmo;
				if (req.getLinkType() == RequirementLinkTypes.HOSTING_LITERAL) {
					Unit sourceUnit = (Unit) req.getParent();
					if (sourceUnit != null) {
						Unit host = ValidatorUtils.getHost(sourceUnit);
						if (host == null) {
							// Launch to find Host.
							launchLinksDiscoveryForHost(sourceUnit);
						} else {
							reveal(host);
						}
					}
				} else {
					DependencyLink link = req.getLink();
					if (link != null) {
						Capability cap = link.getTarget();
						if (cap != null) {
							reveal(cap.getParent());
						}
					} else {
						launchLinksDiscoveryForDependency(req);
					}
				}
			}

			private void launchLinksDiscoveryForDependency(Requirement requirement) {
				LinkDiscoveryDataModel model = LinkDiscoveryDataModel.createModel();
				model.setIsDependency(true);
				model.setRequirement(requirement);
				model.setShouldShowSelectionPage(false);
				NewLinkWizard wizard = new NewLinkWizard(model);
				WizardDialog dialog = new WizardDialog(getShell(), wizard);
				dialog.create();
				dialog.open();
			}

			private void launchLinksDiscoveryForHost(Unit hostee) {
				LinkDiscoveryDataModel model = LinkDiscoveryDataModel.createModel();
				model.setIsHosting(true);
				model.setUnit(hostee);
				model.setShouldShowSelectionPage(false);
				NewLinkWizard wizard = new NewLinkWizard(model);
				WizardDialog dialog = new WizardDialog(getShell(), wizard);
				dialog.create();
				if (dialog.open() != Window.CANCEL) {
					//Force an update of the UI host target.
					getSynchHelper().updateUIWithModel(CorePackage.Literals.DEPLOY_LINK__TARGET_URI);
				}
			}

			private void reveal(DeployModelObject dmo) {
				PropertyUtils.reveal(dmo);
				if (isPopup) {
					getShell().close();
					if (parentPopupShell != null) {
						parentPopupShell.close();
					}
				}
			}
		});
	}

	private void initializeDeleteTargetButtonAction() {
		deleteTargetButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				DeployLink link = getRequirementLink();
				if (link != null) {
					PropertyUtils.deleteLinkElementAndView(link);
					getSynchHelper().updateUIWithModel(CorePackage.Literals.DEPLOY_LINK__TARGET_URI);
					updateLinkContent();
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
	}

	private DeployLink getRequirementLink() {
		Requirement req = (Requirement) dmo;
		if (isHostingRequirement()) {
			return ValidatorUtils.getHostingLink((Unit) req.getParent());
		}
		return req.getLink();
	}

	@Override
	public void setInput(Object aDmo) {
		super.setInput(aDmo);
		updateLinkContent();
	}

	/*
	 * Return true if the update is to a linkable requirement.
	 */
	private boolean basicUpdateLinkContent() {
		setLinkTargetLabel();
		if (!isLinkableRequirement()) {
			targetLabel.setEnabled(false);
			targetHyperLink.setEnabled(false);
			targetHyperLink.setText(""); //$NON-NLS-1$
			deleteTargetButton.setEnabled(false);
			return false;
		}
		return true;
	}

	private void updateLinkContent() {
		if (basicUpdateLinkContent()) {
			updateLinkButton();
		}
	}

	protected void setLinkTargetLabel() {
		if (isHostingRequirement()) {
			targetLabel.setText(Messages.DetailRequirementComposite_Host_);
		} else {
			targetLabel.setText(Messages.DetailRequirementComposite_Target_);
		}
	}

	private boolean isHostingRequirement() {
		if (dmo != null) {
			return ((Requirement) dmo).getLinkType() == RequirementLinkTypes.HOSTING_LITERAL;
		}
		return false;
	}

	private boolean isLinkableRequirement() {
		Requirement req = (Requirement) dmo;
		if (req != null) {
			RequirementLinkTypes type = req.getLinkType();
			return type != RequirementLinkTypes.MEMBER_LITERAL;
		}
		return false;
	}

	private void updateLinkButton() {
		DeployLink link = getRequirementLink();
		Topology topology = null;
		if (link == null || (topology = link.getTopology()) != null
				&& topology != link.getEditTopology()) {
			deleteTargetButton.setEnabled(false);
			deleteTargetButton.setImage(DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
					ISharedImages.IMG_DELETE_LINK_DISABLED));
		} else {
			deleteTargetButton.setEnabled(true);
			deleteTargetButton.setImage(DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
					ISharedImages.IMG_DELETE_LINK));
		}
	}

	/**
	 * This method should only be called if the composite is created for a popup.
	 * 
	 * @param isPopup
	 *           Pass true if this composite is used within a {@link PopupDialog}.
	 * @param parentPopupShell
	 *           Pass the parent {@link Shell} if this is a secondary {@link PopupDialog}.
	 */
	public void setPopupDialog(boolean isPopup, Shell parentPopupShell) {
		this.isPopup = isPopup;
		this.parentPopupShell = parentPopupShell;
	}

	public IStatus handleRequirementLinkChange(Notification notification) {
		if (isHostingRequirement()) {
			//Update the host link label, hyperlink, and button.
			getSynchHelper().updateUIWithModel(CorePackage.Literals.DEPLOY_LINK__TARGET_URI);
			updateLinkContent();
		}
		return Status.OK_STATUS;
	}
} //  @jve:decl-index=0:visual-constraint="0,21"
