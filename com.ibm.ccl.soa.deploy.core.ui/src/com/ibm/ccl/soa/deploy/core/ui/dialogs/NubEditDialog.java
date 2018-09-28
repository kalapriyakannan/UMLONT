/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.dialogs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.part.ISetSelectionTarget;

import com.ibm.ccl.soa.deploy.core.Agreement;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExplicitContract;
import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.core.Service;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.operation.UpdateContractOperation;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedFonts;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.composites.NewInterfaceDialog;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.NubEditPopUpCommand;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.PopupCloserListener;
import com.ibm.ccl.soa.deploy.core.ui.properties.LightweightOperationFactory;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.saf.exception.SAFException;
import com.ibm.ccl.soa.deploy.saf.extension.IInterfaceHandlerService;
import com.ibm.ccl.soa.deploy.saf.ui.handler.AbstractUIHandler;

/**
 * This dialog appears when the 'capabilities' icon/button is clicked on a diagram Unit. It presents
 * a tree of the Capabilities and interfaces.
 * 
 * @since 1.0
 * @see NubEditPopUpCommand
 * @see RequirementsPopupDialog
 * @deprecated use CapabilitiesPopupDialog
 */
public class NubEditDialog extends PopupDialog implements ISetSelectionTarget {

	private static final String DIALOG_SETTINGS_ID = "topology.diagram.nubediting"; //$NON-NLS-1$

	private static final String SETTINGS_LAST_VISIBILITY = "NubEditDialog_lastVisibility"; //$NON-NLS-1$

	private final Point initialLocation;
	private final Unit unit;
	private boolean isNonMutableImport = false;
	private PopupCloserListener popupCloser;
	private PopupDialog popup;

	private Text textFilter;

	private ToolBar reqToolBar;

	private PublicVizAction publicVizAction;

	private PublicEditableVizAction publicEditableVizAction;

	private PrivateVizAction privateVizAction;

	private boolean isImportedUnit;

	private MenuManager visibilityMenuManager;

	private ToolItem visiblityDropdownItem;
	private ToolItem deleteCapabilityItem;
	private ToolItem addCapabilityItem;
	private ToolItem customizeAttributesItem;

	private TreeViewer tviewer;

	private PatternFilter patternFilter;

	private Object objectBeingEdited;

	/*
	 * The delay before showing a secondary popup.
	 */
	private static final int POPUP_DELAY = 450;
	private Thread detailDialogThread;

	private ILabelProvider objectLabelProvider;

	private String objectLabelShowing;

	private static final String SET_INTERFACE_LBL = "<Set Interface>"; //$NON-NLS-1$

	/**
	 * @param unit
	 * @param initialLoc
	 */
	public NubEditDialog(Shell shell, Unit unit, Point initialLoc) {
		super(shell, SWT.RESIZE, true, // takeFocusOnOpen
				true, // persistBounds
				true, // showDialogMenu
				true, // showPersistAction
				null, Messages.NubEditDialog_Select_on_capability_to_modif_);
		this.unit = unit;
		isImportedUnit = PropertyUtils.isProxy(unit);

		isNonMutableImport = !PropertyUtils.isEditable(unit);
		initialLocation = initialLoc;
		create();
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////// SIZE/LOCATION/SETTINGS//////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////
	protected Point getInitialLocation(Point initialSize) {
		return initialLocation;
	}

	protected Point getInitialSize() {
		IDialogSettings settings = DeployCoreUIPlugin.getDefault().getDialogSettings().getSection(
				DIALOG_SETTINGS_ID);
		if (settings == null) {
			DeployCoreUIPlugin.getDefault().getDialogSettings().addNewSection(DIALOG_SETTINGS_ID);
			return new Point(300, 150);
		}
		return super.getInitialSize();
	}

	protected IDialogSettings getDialogSettings() {
		IDialogSettings settings = DeployCoreUIPlugin.getDefault().getDialogSettings().getSection(
				DIALOG_SETTINGS_ID);

		if (settings == null) {
			settings = DeployCoreUIPlugin.getDefault().getDialogSettings().addNewSection(
					DIALOG_SETTINGS_ID);
		}
		return settings;
	}

	/** Call PopupDialog.createContents(), then go back and re-color to avoid hideous yellow. */
	protected Control createContents(Composite parent) {
		Control composite = super.createContents(parent);

		changeDefaultColors(parent);

		return composite;
	}

	/*
	 * Set the colors of the popup. The contents have already been created.
	 */
	private void changeDefaultColors(Control control) {
		applyForegroundColor(getShell().getDisplay().getSystemColor(SWT.COLOR_LIST_FOREGROUND),
				control);
		applyBackgroundColor(getShell().getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND),
				control);
	}

	protected Control createTitleControl(Composite parent) {
		Composite titleComposite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		layout.marginHeight = POPUP_MARGINHEIGHT;
		layout.marginWidth = POPUP_MARGINWIDTH;
		layout.verticalSpacing = POPUP_VERTICALSPACING;
		layout.horizontalSpacing = POPUP_HORIZONTALSPACING;
		titleComposite.setLayout(layout);
		titleComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		textFilter = new Text(titleComposite, SWT.NULL);
		textFilter.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		createCapabilityToolBar(titleComposite);

		textFilter.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				//				listComposite.expandTree();
				patternFilter.setPattern(textFilter.getText());
				//				listComposite.refresh();
				//				listComposite.selectFirst();
//				tviewer.refresh();
				refreshCaps();
			}
		});

		textFilter.addKeyListener(new KeyListener() {

			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.ARROW_DOWN) {
					tviewer.getTree().setFocus();
				}
			}

			public void keyReleased(KeyEvent e) {
				// do nothing
			}
		});

		return titleComposite;
	}

	private void createCapabilityToolBar(Composite parent) {
		reqToolBar = new ToolBar(parent, SWT.FLAT);
		reqToolBar.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));

		// Visibility
		createContractComboToolItem();
		// Add
		createAddCapabilityToolItem();
		// Delete
		createDeleteCapabilityToolItem();
		// Customize
		new ToolItem(reqToolBar, SWT.SEPARATOR);
		createCustomizeAttributesToolItem();
	}

	private void createAddCapabilityToolItem() {
		addCapabilityItem = new ToolItem(reqToolBar, SWT.PUSH);

		addCapabilityItem.setImage(DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
				ISharedImages.IMG_ADD_CAPABILITY));

		addCapabilityItem.setToolTipText(Messages.NubEditDialog_Add_Capabilit_);

		addCapabilityItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleAddCapability();
			}
		});
	}

	private void createCustomizeAttributesToolItem() {
		customizeAttributesItem = new ToolItem(reqToolBar, SWT.PUSH);
		customizeAttributesItem.setImage(DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
				ISharedImages.IMG_EDIT_ATTRIBUTES));
//		customizeAttributesItem.setImage(PropertyUtils.createImageDescriptor(
//				"icons/elcl16/edit_attrbut.gif").createImage()); //$NON-NLS-1$
		customizeAttributesItem.setToolTipText(Messages.NubEditDialog_Customize_attribute_);

		//		if (!isImportedUnit) {
		customizeAttributesItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleCustomizeAttributes();
			}
		});
		//		}
	}

	private void createDeleteCapabilityToolItem() {
		deleteCapabilityItem = new ToolItem(reqToolBar, SWT.PUSH);
//		deleteCapabilityItem.setImage(PropertyUtils
//				.createImageDescriptor("icons/elcl16/delete.gif").createImage()); //$NON-NLS-1$
		deleteCapabilityItem.setImage(DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
				ISharedImages.IMG_DELETE));
		//		deleteCapabilityItem.setImage(DeployCoreUIPlugin.getDefault().getSharedImages().getImage(ISharedImages.IMG_DELETE_REQUIREMENT));
		//		deleteCapabilityItem.setDisabledImage(DeployCoreUIPlugin.getDefault().getSharedImages().getImage(ISharedImages.IMG_DELETE_REQUIREMENT_DISABLED));
		deleteCapabilityItem.setToolTipText(Messages.NubEditDialog_Delete_Capabilit_);
		//		deleteCapabilityItem.setEnabled(false);

		//		if (!isImportedUnit) {
		deleteCapabilityItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleDeleteCapability();
			}
		});
		//		}
	}

	private void handleCustomizeAttributes() {
		List<Capability> selCaps = getSelectedCapabilitiesWithoutInterfaces();
		if (selCaps.size() > 0) {
			Capability cap = selCaps.get(0);
//			ExtendedAttributeDialog ead = new ExtendedAttributeDialog(getShell(), cap);
			CustomizeAttributesDialog ead = new CustomizeAttributesDialog(getShell(), cap);
			if (ead.open() == Window.OK) {
				openSelection(null); // close popup
				openSelection(); // re-open, possibly with different attributes
			}
		}
	}

	private void handleAddCapability() {
		List<Object> list = new LinkedList<Object>();
		list.addAll(PropertyUtils.getBankedCapabilities());
		list.addAll(PropertyUtils.getCapTypeNames());

		ElementListSelectionDialog dlg = new NewCapabilityCreationDialog(getShell(), PropertyUtils
				.getSoaLabelProvider());
		dlg
				.setTitle(com.ibm.ccl.soa.deploy.core.ui.properties.Messages.NewCapabilityDialog_ADD_CAPABILITY);
		dlg.setHelpAvailable(false);
		dlg.setElements(list.toArray());
		if (dlg.open() == Window.OK) {
			Object sel = dlg.getFirstResult();
			Capability cap = null;
			if (sel instanceof Capability) {
				cap = (Capability) sel;
			} else if (sel instanceof String) {
				String ecName = (String) sel;
				cap = PropertyUtils.createCapability(ecName);
			}

			if (cap != null) {
				cap.setName(UnitUtil.generateUniqueName(unit, cap.eClass().getName()));

				// Create a Command (so Undo will work, and to get transactional wrapper)
				// It's no longer legal to cast to EList because proxies use ReassociationList instead!
				//				System.out.println("cap list class="+unit.getCapabilities().getClass()); //$NON-NLS-1$
				//				System.out.println("or is it"+unit.eGet(CorePackage.eINSTANCE.getUnit_Capabilities()).getClass());  //$NON-NLS-1$
				//				AddCommand ac = new AddCommand(domain, unit, CorePackage.eINSTANCE.getUnit_Capabilities(), cap);

				//				TransactionCommandWrapper2 mtcw = new TransactionCommandWrapper2(domain, ac, false);
				//				ICommandProxy command = new ICommandProxy(mtcw);
				//				gefDomain.getCommandStack().execute(command);

				final Capability cap2 = cap;
				PropertyUtils.executeWithUndo(unit, Messages.NubEditDialog_Add_Capabilit_,
						new Runnable() {

							public void run() {
								unit.getCapabilities().add(cap2);
							}
						});
			}

			// Refresh, because of bug 2368, even though we should be listening for model changes.
			tviewer.refresh();
			refreshCaps();

		} // endif OK clicked
	}

	private void handleDeleteCapability() {
		PropertyUtils.deleteFromModel(getSelectedCapabilitiesWithoutInterfaces(), unit,
				Messages.NubEditDialog_Delete_Capabilit_);
		refreshCaps();

		if (popup != null) {
			popup.close();
			objectBeingEdited = null;
		}
	}

	private boolean noSelectedCapsAreProxies() {
		if (tviewer.getSelection() instanceof StructuredSelection) {
			StructuredSelection ss = (StructuredSelection) tviewer.getSelection();
			for (Iterator<?> it = ss.toList().iterator(); it.hasNext();) {
				Object obj = it.next();
				if (obj instanceof Capability) {
					if (PropertyUtils.isProxy((DeployModelObject) obj)) {
						return false;
					}
				}
			}
		}

		return true;
	}

	private List<Capability> getSelectedCapabilitiesWithoutInterfaces() {
		List<Capability> retVal = new LinkedList<Capability>();

		if (tviewer.getSelection() instanceof StructuredSelection) {
			StructuredSelection ss = (StructuredSelection) tviewer.getSelection();
			for (Iterator<?> it = ss.toList().iterator(); it.hasNext();) {
				Object obj = it.next();
				if (obj instanceof Capability) {
					retVal.add((Capability) obj);
				}
			}
		}

		return retVal;
	}

	private void createContractComboToolItem() {
		// Create push, drop-down item
		visiblityDropdownItem = new ToolItem(reqToolBar, SWT.DROP_DOWN);
		initializeVisibilityItemMenuActions();

		// The tool item should not enable in M5 since we do not support
		// re-export.
		if (!isImportedUnit) {
			visiblityDropdownItem.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					if (SWT.ARROW == e.detail) {
						// Show Menu
						showVisibilityItemMenu(e);
//					} else {
//						// Perform the cached action.
//						IAction action = (IAction) visiblityDropdownItem.getData();
//						action.run();
					}
				}

			});
		}
	}

	protected void showVisibilityItemMenu(SelectionEvent e) {
		if (visibilityMenuManager == null) {
			visibilityMenuManager = new MenuManager();
			fillVisibilityMenu(visibilityMenuManager);
		}

		Menu menu = visibilityMenuManager.createContextMenu(getShell());
		Rectangle bounds = reqToolBar.getBounds();
		Point topLeft = new Point(bounds.x, bounds.y + bounds.height);
		topLeft = getShell().toDisplay(topLeft);
		menu.setLocation(topLeft.x, topLeft.y);
		menu.setVisible(true);
	}

	private void fillVisibilityMenu(MenuManager menuMgr) {
		menuMgr.add(publicVizAction);
		menuMgr.add(publicEditableVizAction);
		menuMgr.add(privateVizAction);
	}

	private void initializeVisibilityItemMenuActions() {
		publicVizAction = new PublicVizAction();
		publicEditableVizAction = new PublicEditableVizAction();
		privateVizAction = new PrivateVizAction();
	}

	@Override
	public int open() {
		//		long t = System.currentTimeMillis();
		//		System.out.println("Trying to open NubEditDialog; time=" + t); //$NON-NLS-1$
		int retVal = super.open();
		textFilter.setFocus();
		if (popupCloser == null) {
			popupCloser = new PopupCloserListener(this);
		}
		//		System.out.println("Opened NubEditDialog?; time=" + System.currentTimeMillis() + "(" + (System.currentTimeMillis() - t) + "ms)"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return retVal;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////// CREATE TREE //////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////
	protected Control createDialogArea(Composite parent) {

		///////////////// create tree //////////////////////////////

		Tree nubEditingTree = new Tree(parent, SWT.H_SCROLL | SWT.V_SCROLL
				| /* SWT.BORDER | */SWT.MULTI | SWT.FULL_SELECTION);
		//nubEditingTree.addMouseTrackListener(this);
		nubEditingTree.setHeaderVisible(false);
		nubEditingTree.setLinesVisible(false);
		nubEditingTree.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_INFO_BACKGROUND));
		nubEditingTree.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_INFO_FOREGROUND));

		nubEditingTree.setFont(DeployCoreUIPlugin.getDefault().getSharedFonts().getFont(
				ISharedFonts.INFO));

		nubEditingTree.addMouseListener(new MouseListener() {

			public void mouseDoubleClick(MouseEvent e) {
				// do nothing
			}

			public void mouseDown(MouseEvent e) {
				// do nothing
			}

			public void mouseUp(MouseEvent e) {
				openSelection();
			}

		});

		// remove selected item
		nubEditingTree.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent event) {
				//				System.out.println("@@@char=" + event.character); //$NON-NLS-1$

				if (event.character == SWT.CR && event.stateMask == 0) {
					openSelection();
				} else if (event.character == SWT.DEL && event.stateMask == 0 && !isNonMutableImport) {
					handleDeleteCapability();

				}
			}
		});

		nubEditingTree.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				enableDisableActions();
			}
		});

		tviewer = new TreeViewer(nubEditingTree);
		patternFilter = new PatternFilter();
		tviewer.addFilter(patternFilter);
		tviewer.setComparator(PropertyUtils.getDisplayNameComparator());
		tviewer.setContentProvider(new NubEditContentProvider());
		objectLabelProvider = PropertyUtils.getSoaLabelProvider();
		tviewer.setLabelProvider(objectLabelProvider);
		tviewer.setInput(unit);

		GridData gdTree = new GridData(SWT.FILL, SWT.FILL, true, true);
		gdTree.heightHint = 150;
		nubEditingTree.setLayoutData(gdTree);

		enableDisableActions();

		listenForObjectNameChanges();

		return nubEditingTree;

	}

	/**
	 * As a result of user editing of popup's Capabilities, the contents of the list could become
	 * dirty. Listen for changes.
	 */
	private void listenForObjectNameChanges() {
		TransactionalEditingDomain theEditingDomain = TransactionUtil.getEditingDomain(unit);
		if (theEditingDomain != null) {
			theEditingDomain.addResourceSetListener(eventListener);
		}
	}

	private void stopListeningForObjectNameChanges() {
		TransactionalEditingDomain theEditingDomain = TransactionUtil.getEditingDomain(unit);
		if (theEditingDomain != null) {
			theEditingDomain.removeResourceSetListener(eventListener);
		}
	}

	private void refreshCaps() {
		tviewer.refresh();

		if (objectBeingEdited != null) {
			objectLabelShowing = objectLabelProvider.getText(objectBeingEdited);
		}
	}

	/**
	 * event listener; catches multiplexed events and routes them to us. We are interested in<br>
	 * 1. the list of Capabilities changing<br>
	 * 2. the name changing for the current capability.
	 */
	private final ResourceSetListenerImpl eventListener = new ResourceSetListenerImpl(getFilter()) {

		public void resourceSetChanged(ResourceSetChangeEvent event) {

			if (!tviewer.getTree().isDisposed() && objectBeingEdited != null) {
				// The list didn't change, but perhaps the title of the selected capability did
				String labelShouldBe = objectLabelProvider.getText(objectBeingEdited);
				if (!labelShouldBe.equals(objectLabelShowing)) {
					objectLabelShowing = labelShouldBe;

					getShell().getDisplay().asyncExec(new Runnable() {

						public void run() {
							tviewer.refresh(objectBeingEdited);
						}
					});
				}
			}
		}

		public boolean isPostcommitOnly() {
			return true;
		}

	};

	private NotificationFilter getFilter() {
		// We listen to property sets.  We also listen to add/remove (might help with 
		// edit topology {@link Property} overrides
		NotificationFilter retVal = NotificationFilter.createEventTypeFilter(Notification.SET).or(
				NotificationFilter.createEventTypeFilter(Notification.ADD)).or(
				NotificationFilter.createEventTypeFilter(Notification.REMOVE));
		return retVal;
	}

	private void enableDisableActions() {
//		System.out.println("->enableDisableActions"); //$NON-NLS-1$

		int capSize = getSelectedCapabilitiesWithoutInterfaces().size();
		boolean capSel = capSize > 0;
		visiblityDropdownItem.setEnabled(capSel && !isNonMutableImport
				&& editTopologyAllowsExplicitExport());
		boolean noSelectedCapsAreProxies = noSelectedCapsAreProxies();
		deleteCapabilityItem.setEnabled(capSel && noSelectedCapsAreProxies);
		customizeAttributesItem.setEnabled(capSel && noSelectedCapsAreProxies);
		addCapabilityItem.setEnabled(!isNonMutableImport);

		if (capSize == 1) {
			Capability cap = getSelectedCapabilitiesWithoutInterfaces().get(0);
			Agreement agreement = cap.getEditTopology().getConfigurationContract();
			String msg;
			if (agreement.isPublicEditable(cap)) {
//				System.out.println(cap.getCaptionProvider().title(cap) + " is public editable"); //$NON-NLS-1$
				visiblityDropdownItem.setImage(DeployCoreUIPlugin.getDefault().getSharedImages()
						.getImage(ISharedImages.IMG_CONTRACT_PUBLIC_EDITABLE));
				msg = Messages.AttributesDecorator_Public_Editable_;
			} else if (agreement.isPublic(cap)) {
//				System.out.println(cap.getCaptionProvider().title(cap) + " is public"); //$NON-NLS-1$
				visiblityDropdownItem.setImage(DeployCoreUIPlugin.getDefault().getSharedImages()
						.getImage(ISharedImages.IMG_CONTRACT_PUBLIC));
				msg = Messages.AttributesDecorator_Public_;
			} else { // private
//				System.out.println(cap.getCaptionProvider().title(cap) + " is private"); //$NON-NLS-1$
				visiblityDropdownItem.setImage(DeployCoreUIPlugin.getDefault().getSharedImages()
						.getImage(ISharedImages.IMG_CONTRACT_PRIVATE));
				msg = Messages.AttributesDecorator_Private_;
			}

			String tooltip = Messages.ContractFigure_Contract_Status_ + " " + msg; //$NON-NLS-1$
			visiblityDropdownItem.setToolTipText(tooltip);
		} else {
			// clear
			visiblityDropdownItem.setImage(null);
			visiblityDropdownItem.setToolTipText(null);
		}
	}

	private boolean editTopologyAllowsExplicitExport() {
		return unit.getTopology().getConfigurationContract() instanceof ExplicitContract;
	}

	/** Open the current selection in the side popup, {@link NubEditPopupDialog}. */
	private void openSelection() {

		if (getSelectionCount() != 1) {
			return;
		}

		Interface interfaceToEdit = null;
		DeployModelObject dmoToEdit = null;

		Object selectedItem = getFirstSelection();

		if (selectedItem instanceof NakedService) {
			//				needToSetInterface = true;
			//Open the right interface dialog somehow.
			//				EClass serviceType = (EClass) items[0].getData();
			NakedService ns = (NakedService) selectedItem;
			EClass serviceType = ns.service.eClass();
			if (serviceType != null) {
				IInterfaceHandlerService handlerService = DeployCoreUIPlugin.getDefault()
						.getInterfaceHandlerService();

				NewInterfaceDialog selection = new NewInterfaceDialog(getShell(), handlerService,
						serviceType);

				if (selection.open() == Window.OK) {
					interfaceToEdit = selection.createSelectedInterface();
					if (interfaceToEdit != null) {
						// TODO Run in safe transaction
						ns.service.setInterface(interfaceToEdit);
						editInterface(interfaceToEdit, true, ns.service);
					}
				}
			}
		} else if (selectedItem instanceof Interface) {
			interfaceToEdit = (Interface) selectedItem;
			//	DeployModelObject dmo = (DeployModelObject) interfaceToEdit.eContainer();
			openSelection(interfaceToEdit);
		} else if (selectedItem instanceof DeployModelObject) {
			dmoToEdit = (DeployModelObject) selectedItem;
			openSelection(dmoToEdit);
		}

	}

	private Object getFirstSelection() {
		if (tviewer.getSelection() instanceof StructuredSelection) {
			StructuredSelection ss = (StructuredSelection) tviewer.getSelection();
			return ss.getFirstElement();
		}

		return null;
	}

	private int getSelectionCount() {
		if (tviewer.getSelection() instanceof StructuredSelection) {
			StructuredSelection ss = (StructuredSelection) tviewer.getSelection();
			return ss.size();
		}

		return 0;
	}

	private void editInterface(Interface interfaceToEdit, boolean needToSetInterface,
			DeployModelObject dmo) {

		AbstractUIHandler uihandler = null;
		uihandler = DeployCoreUIPlugin.getDefault().getInterfaceUIHandlerService()
				.findUIHandlerForSubstitutable(interfaceToEdit);
		if (uihandler != null) {
			try {
				uihandler.editSubstitutable(getShell(), dmo, interfaceToEdit, false);
				if (needToSetInterface) {
					setInterfaceObjectOnDMO(dmo, interfaceToEdit);
				}
				refreshCaps();
			} catch (SAFException e) {
			}
		}
	}

	private void openSelection(Object objectToEdit) {
		if (objectToEdit == null) {
			if (popup != null) {
				popup.close();

			}

			objectBeingEdited = null;
			return;
		}

		if (objectToEdit == objectBeingEdited && popup != null && popup.getShell() != null
				&& !popup.getShell().isDisposed()) {
			return;
		}

		boolean delayOpen = true;
		if (popup != null) {
			if (popup.getShell() != null && !popup.getShell().isDisposed()) {
				delayOpen = false;
			}
			popup.close();
			popup = null;
		}

		if (objectToEdit instanceof Interface) {
			Interface ifaceToEdit = (Interface) objectToEdit;
			popup = new InterfaceEditPopupDialog(getShell(), null, ifaceToEdit);

		} else if (objectToEdit instanceof DeployModelObject) {
			DeployModelObject dmoToEdit = (DeployModelObject) objectToEdit;
			popup = new NubEditPopupDialog(getShell(), null, dmoToEdit);
		}

		showDetailFlyoutPopup(delayOpen);

		objectBeingEdited = objectToEdit;
	}

	private void showDetailFlyoutPopup(boolean delayOpen) {
		if (popup == null) {
			return;
		}
		if (!delayOpen) {
			//Show with no delay.
			//TODO Try to reuse the current dialog.
			doShowDetailFlyoutPopup();
		} else {
			Runnable runnable = new Runnable() {
				public void run() {
					try {
						Thread.sleep(POPUP_DELAY);
					} catch (InterruptedException e) {
					}
					if (tviewer == null || tviewer.getTree().isDisposed()) {
						return;
					}
					getShell().getDisplay().syncExec(new Runnable() {
						public void run() {
							doShowDetailFlyoutPopup();
						}
					});
				}
			};
			detailDialogThread = new Thread(runnable);
			detailDialogThread.start();
		}
	}

	/*
	 * Operate in a command.
	 */
	private void setInterfaceObjectOnDMO(final DeployModelObject aServiceOrReference,
			final Interface interfaceToEdit) {
		AbstractTransactionalCommand editCmd = new AbstractTransactionalCommand(TransactionUtil
				.getEditingDomain(aServiceOrReference), "Set interface relationship", null) { //$NON-NLS-1$
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
				if (aServiceOrReference instanceof Service) {
					((Service) aServiceOrReference).setInterface(interfaceToEdit);
				}
				return CommandResult.newOKCommandResult();
			}
		};
		try {
			editCmd.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
		}
	}

	@Override
	public boolean close() {
		handleDispose();
		return super.close();
	}

	/**
	 * 
	 */
	public synchronized void handleDispose() {
		stopListeningForObjectNameChanges();
	}

	/**
	 * Update the {@link ConfigurationContract} for the set of requirements from the
	 * toggleVisibilityItem.
	 * 
	 * @param contractFlag
	 *           The flag indicating the contract change.
	 */
	private void executeChangeContractSettings(int contractFlag) {
		List<Capability> selectedCaps = getSelectedCapabilitiesWithoutInterfaces();
		List<DeployModelObject> selectedDmos = new LinkedList<DeployModelObject>(selectedCaps);
		if (selectedCaps.size() > 0) {
			IUndoableOperation op = UpdateContractOperation.createUpdateContractOperation(
					selectedDmos, contractFlag, "Update Contracts"); //$NON-NLS-1$
			if (op != null) {
				// Create a ChangeScope based on the first object.
				DeployModelObject u = selectedCaps.get(0).getParent();
				LightweightOperationFactory.execute(u, op);
			}
		}
	}

	private void doShowDetailFlyoutPopup() {
		if (popup == null) {
			return;
		}

		// Query the current selection since we have
		// been delayed
		Point point = null;
		popup.create();
		Rectangle rect = getShell().getBounds();
		Rectangle detailRect = popup.getShell().getBounds();
		Rectangle monitorBounds = Display.getCurrent().getPrimaryMonitor().getBounds();
		if (rect.x + rect.width + detailRect.width > monitorBounds.width) {
			// Open to the left.
			point = new Point(rect.x - detailRect.width, rect.y);
		} else {
			// Open to the right.
			point = new Point(rect.x + rect.width, rect.y);
		}
		popup.getShell().setLocation(point);
		popupCloser.setSecondaryPopup(popup);
		popup.open();

		popup.getShell().addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent event) {
				popup = null;
			}
		});
	}

	/** Class to make the current Capability public */
	private class PublicVizAction extends Action {
		PublicVizAction() {
			super(com.ibm.ccl.soa.deploy.core.ui.properties.Messages.RequirementsPopupDialog_Publi_,
					IAction.AS_PUSH_BUTTON);
			setChecked(false);
			setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages().getImageDescriptor(
					ISharedImages.IMG_CONTRACT_PUBLIC));
		}

		public void run() {
			executeChangeContractSettings(UpdateContractOperation.PUBLIC_FLAG);
			enableDisableActions();
		}
	}

	/** Class to make the current Capability public-editable */
	private class PublicEditableVizAction extends Action {

		PublicEditableVizAction() {
			super(
					com.ibm.ccl.soa.deploy.core.ui.properties.Messages.RequirementsPopupDialog_Public_Editabl_,
					IAction.AS_PUSH_BUTTON);
			setChecked(false);
			setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages().getImageDescriptor(
					ISharedImages.IMG_CONTRACT_PUBLIC_EDITABLE));
		}

		public void run() {
			executeChangeContractSettings(UpdateContractOperation.PUBLIC_EDITABLE_FLAG);
			enableDisableActions();
		}
	}

	/** Class to make the current Capability private */
	private class PrivateVizAction extends Action {

		PrivateVizAction() {
			super(com.ibm.ccl.soa.deploy.core.ui.properties.Messages.RequirementsPopupDialog_Privat_,
					IAction.AS_PUSH_BUTTON);
			setChecked(false);
			setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages().getImageDescriptor(
					ISharedImages.IMG_CONTRACT_PRIVATE));
		}

		public void run() {
			executeChangeContractSettings(UpdateContractOperation.PRIVATE_FLAG);
			enableDisableActions();
		}
	}

	/** A {@link Service} with no interface */
	private static final class NakedService {
		protected final Service service;

		protected NakedService(Service svc) {
			service = svc;
		}

		@Override
		public String toString() {
			return SET_INTERFACE_LBL;
		}
	}

	private static class NubEditContentProvider implements ITreeContentProvider {

		private final static Object[] NONE = new Object[0];

		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof Unit) {
				Unit unit = (Unit) parentElement;
				return unit.getCapabilities().toArray();
			} else if (parentElement instanceof Service) {
				Service service = (Service) parentElement;
				Interface interfaze = service.getInterface();
				if (interfaze == null) {
					return new Object[] { new NakedService(service) };
				}

				return new Object[] { interfaze };
			}

			return NONE;
		}

		public Object getParent(Object element) {
			return null;
		}

		public boolean hasChildren(Object element) {
			return getChildren(element).length > 0;
		}

		public Object[] getElements(Object inputElement) {
			return getChildren(inputElement);
		}

		public void dispose() {
			// do nothing
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// do nothing
		}

	} // end private inner class NubEditContentProvider

	// ISetSelectionTarget
	public void selectReveal(ISelection selection) {
		if (!tviewer.getTree().isDisposed()) {
			tviewer.refresh();
			tviewer.setSelection(selection, true);
		}
	}

} // end class NubEditDialog
