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

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.CapabilitiesPopupDialog;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.CustomizeAttributesDialog;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.NewCapabilityCreationDialog;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;

/**
 * @author Ed Snible (based on daberg RequirementsToolBarManager)
 * @see CapabilitiesPopupDialog
 */
public class CapabilitiesToolBarManager extends SharedReqCapsToolBarManager {

	/**
	 * @since 7.0
	 * 
	 */
	public interface CapabilitiesToolBarHelper {

		/**
		 * Ensure that the details composite is shown
		 * 
		 * @param cap
		 */
		void showCapabilityDetails(Capability cap);

		/**
		 * Hide the details popup.
		 */
		void hideCapabilityDetails();

		/**
		 * @return A String that will be used to acquire setting values;
		 */
		String getSettingsPrefix();

		/**
		 * The action bar has changed so propagate the changes through the UI.
		 * 
		 * @see IActionBars#updateActionBars()
		 */
		void handleUpdateActionBars();

	}

	//DialogSettings
//	private static final String SETTINGS_LAST_VISIBILITY = "_lastVisibility"; //$NON-NLS-1$
//	private static final String SETTINGS_SHOW_LINKS = "_showLinks"; //$NON-NLS-1$
//	private static final String SETTINGS_SHOW_HEADERS = "_showHeaders"; //$NON-NLS-1$

	private IAction deleteCapabilityItem;
	private IAction addCapabilityItem;
	private IAction customizeAttributesItem;

	private List<Capability> selectedCapabilities = null; // Collections.emptyList();

	private CapabilitiesListComposite listComposite;

	private final CapabilitiesToolBarHelper helper;

	/**
	 * Create a new tool bar manager.
	 * 
	 * @param parent
	 *           The parent {@link Composite}.
	 * @param isImport
	 *           Set to true if the passed {@link Unit} is imported.
	 * @param aUnit
	 *           The owning {@link Unit}.
	 * @param aToolBarHelper
	 * @param aToolBarManager
	 *           An {@link IToolBarManager} that will be responsible for managing the {@link ToolBar}.
	 */
	public CapabilitiesToolBarManager(Composite parent, boolean isImport, Unit aUnit,
			CapabilitiesToolBarHelper aToolBarHelper, IToolBarManager aToolBarManager) {
		super(parent, isImport, aUnit, aToolBarManager);
		helper = aToolBarHelper;
		initializeActions();
	}

	@Override
	protected void initializeActions() {
		super.initializeActions();

		// Add
		createAddCapabilityToolItem();

		// Delete
		createDeleteCapabilityToolItem();

		// Customize
//		new ToolItem(toolBar, SWT.SEPARATOR);
		createCustomizeAttributesToolItem();
	}

	private void createAddCapabilityToolItem() {
		addCapabilityItem = new Action() {

			@Override
			public void run() {
				if (unit != null && unit.isPublicEditable()) {
					handleAddCapability();
				}
			}

			@Override
			public int getStyle() {
				return IAction.AS_PUSH_BUTTON;
			}

		};
		addCapabilityItem.setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_ADD_CAPABILITY));
		Image image = DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
				ISharedImages.IMG_ADD_CAPABILITY, false);
		if (image != null) {
			addCapabilityItem.setDisabledImageDescriptor(ImageDescriptor.createFromImage(image));
		}
		addCapabilityItem
				.setToolTipText(com.ibm.ccl.soa.deploy.core.ui.Messages.NubEditDialog_Add_Capabilit_);
		addCapabilityItem
				.setText(com.ibm.ccl.soa.deploy.core.ui.Messages.NubEditDialog_Add_Capabilit_);
	}

	private void createCustomizeAttributesToolItem() {
		customizeAttributesItem = new Action() {

			@Override
			public void run() {
				if (unit != null && unit.isPublicEditable()) {
					handleCustomizeAttributes();
				}
			}

			@Override
			public int getStyle() {
				return IAction.AS_PUSH_BUTTON;
			}

		};
		customizeAttributesItem.setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_EDIT_ATTRIBUTES));
		Image image = DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
				ISharedImages.IMG_EDIT_ATTRIBUTES, false);
		if (image != null) {
			customizeAttributesItem.setDisabledImageDescriptor(ImageDescriptor.createFromImage(image));
		}
		customizeAttributesItem
				.setToolTipText(com.ibm.ccl.soa.deploy.core.ui.Messages.NubEditDialog_Customize_attribute_);
		customizeAttributesItem
				.setText(com.ibm.ccl.soa.deploy.core.ui.Messages.NubEditDialog_Customize_attribute_);
		customizeAttributesItem.setEnabled(false);
	}

	private void createDeleteCapabilityToolItem() {
		deleteCapabilityItem = new Action() {

			@Override
			public void run() {
				if (unit != null && unit.isPublicEditable()) {
					handleDeleteCapability();
				}
			}

			@Override
			public int getStyle() {
				return IAction.AS_PUSH_BUTTON;
			}

		};
		deleteCapabilityItem.setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_DELETE));

		Image image = DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
				ISharedImages.IMG_DELETE, false);
		if (image != null) {
			deleteCapabilityItem.setDisabledImageDescriptor(ImageDescriptor.createFromImage(image));
		}
		deleteCapabilityItem
				.setToolTipText(com.ibm.ccl.soa.deploy.core.ui.Messages.NubEditDialog_Delete_Capabilit_);
		deleteCapabilityItem
				.setText(com.ibm.ccl.soa.deploy.core.ui.Messages.NubEditDialog_Delete_Capabilit_);
		deleteCapabilityItem.setEnabled(false);
	}

	/**
	 * Clients must call this method to add the actions to the {@link IToolBarManager} that was
	 * passed in the constructor.
	 */
	public void addActionsToToolbar() {
		super.addActionsToToolbar();
		toolBar.add(addCapabilityItem);
		toolBar.add(deleteCapabilityItem);
		toolBar.add(new Separator());
		toolBar.add(customizeAttributesItem);
	}

	private void handleCustomizeAttributes() {
//		List<Capability> selCaps = getSelectedCapabilitiesWithoutInterfaces();
		if (selectedCapabilities != null && selectedCapabilities.size() > 0) {
			Capability cap = selectedCapabilities.get(0);
			CustomizeCapsToolBarAttributesDialog ead = new CustomizeCapsToolBarAttributesDialog(
					getShell(), cap);
			if (ead.open() == Window.OK) {
				helper.hideCapabilityDetails();
				helper.showCapabilityDetails(cap);
			}
		}
	}

	private class CustomizeCapsToolBarAttributesDialog extends CustomizeAttributesDialog {

		private CustomizeCapsToolBarAttributesDialog(Shell parentShell, DeployModelObject dmo) {
			super(parentShell, dmo, true);
		}

		private CustomizeCapsToolBarAttributesDialog(Shell parentShell, DeployModelObject dmo,
				boolean showContractSettings) {
			super(parentShell, dmo, showContractSettings);
		}

		protected Control createDialogArea(Composite parent) {
			PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
					IDeployHelpContextIds.TOPOLOGY_CAPABILITIES_FLYOUT_SEL_CAPABILITY_CUSTOMIZE_ATTR);
			return super.createDialogArea(parent);
		}

	}

	private void handleAddCapability() {
		List<Object> list = new LinkedList<Object>();
		list.addAll(PropertyUtils.getBankedCapabilities());
		list.addAll(PropertyUtils.getInstantiatableCapTypeNames());

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
				cap = (Capability) EcoreUtil.copy(cap);
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
				PropertyUtils.executeWithUndo(unit,
						com.ibm.ccl.soa.deploy.core.ui.Messages.NubEditDialog_Add_Capabilit_,
						new Runnable() {

							public void run() {
								unit.getCapabilities().add(cap2);
							}
						});
			}

			if (cap != null) {
				//Select the new capability.
				listComposite.setSelection(cap);
				//Setting the selection will open the details.
				//helper.showCapabilityDetails(cap);
			}
		} // endif OK clicked
	}

	private void handleDeleteCapability() {
		PropertyUtils.deleteFromModel(selectedCapabilities, unit,
				com.ibm.ccl.soa.deploy.core.ui.Messages.NubEditDialog_Delete_Capabilit_);

		deleteCapabilityItem.setEnabled(false);
		customizeAttributesItem.setEnabled(false);
		helper.hideCapabilityDetails();
		listComposite.refresh();
		listComposite.selectFirst();
	}

	private Shell getShell() {
		return listComposite.getShell();
	}

	/**
	 * @param aListComposite
	 */
	public void setCapabilityListComposite(CapabilitiesListComposite aListComposite) {
		listComposite = aListComposite;
		if (listComposite != null) {
			if (!isImport()) {
				listComposite.addSelectionChangedListener(new ISelectionChangedListener() {
					public void selectionChanged(SelectionChangedEvent event) {
						selectedCapabilities = null;
						if (event.getSelection().isEmpty()) {
							deleteCapabilityItem.setEnabled(false);
							customizeAttributesItem.setEnabled(false);
							setVisibilityItemEnabled(false);
						} else if (event.getSelection() instanceof IStructuredSelection) {

							Iterator<?> it = ((IStructuredSelection) event.getSelection()).iterator();
							boolean enable = true;
							while (it.hasNext()) {
								Object item = it.next();
								if (!(item instanceof Capability) || !((Capability) item).isMutable()) {
									enable = false;
									break;
								}
							}
							selectedCapabilities = getSelectedCapabilities(event.getSelection());
							deleteCapabilityItem.setEnabled(enable);
							customizeAttributesItem.setEnabled(enable);
							setVisibilityItemEnabled(enable);
						}
					}
				});
			}
		}
	}

	protected List<Capability> getSelectedCapabilities(ISelection selection) {

		List<Capability> retVal = new LinkedList<Capability>();

		if (selection instanceof StructuredSelection) {
			StructuredSelection ss = (StructuredSelection) selection;
			for (Iterator<?> it = ss.toList().iterator(); it.hasNext();) {
				Object obj = it.next();
				if (obj instanceof Capability) {
					retVal.add((Capability) obj);
				}
			}
		}

		return retVal;
	}

	/**
	 * If the delete {@link ToolItem} is enabled then invoke its action based on the current
	 * selection from the {@link CapabilitiesListComposite}.
	 */
	public void invokeDeleteCapabilityItem() {
		if (deleteCapabilityItem != null && deleteCapabilityItem.isEnabled()) {
			//Delete the requirements
			handleDeleteCapability();
		}
	}

	@Override
	protected void didSetInput(Unit aUnit) {
		if (aUnit == null || !aUnit.isPublicEditable()) {
			addCapabilityItem.setEnabled(false);
		} else {
			addCapabilityItem.setEnabled(true);
		}
	}

	@Override
	protected List<? extends DeployModelObject> getSelectedDMOs() {
		return selectedCapabilities;
	}

	@Override
	protected String getSettingsPrefix() {
		return helper.getSettingsPrefix();
	}

	/**
	 * Add menu actions to aMenuManager.
	 * 
	 * @param aMenuManager
	 *           An {@link IMenuManager} that will create and manage the actions in the menu.
	 */
	public void fillMenu(IMenuManager aMenuManager) {
		if (aMenuManager != null) {
			aMenuManager.add(addCapabilityItem);
			aMenuManager.add(deleteCapabilityItem);
			aMenuManager.add(customizeAttributesItem);
		}
	}
}
