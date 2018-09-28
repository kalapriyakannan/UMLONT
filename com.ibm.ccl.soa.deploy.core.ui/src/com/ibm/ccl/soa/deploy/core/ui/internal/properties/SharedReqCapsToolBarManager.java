/***************************************************************************************************
 * Copyright (c) 2008 IBM Corporation. All rights reserved.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.properties;

import java.util.List;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.ToolBar;

import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.operation.UpdateContractOperation;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.RequirementsToolBarManager.RequirementsToolBarHelper;
import com.ibm.ccl.soa.deploy.core.ui.properties.LightweightOperationFactory;
import com.ibm.ccl.soa.deploy.core.ui.properties.Messages;

/**
 * @since 7.0
 * 
 */
public abstract class SharedReqCapsToolBarManager {

	//DialogSettings
	private static final String SETTINGS_LAST_VISIBILITY = "_lastVisibility"; //$NON-NLS-1$

	protected final IToolBarManager toolBar;

	//Tool Item actions
	private IAction toggleVisibilityItem;

	// Visibility Menu Actions
	private IAction publicVizAction;
	private IAction publicEditableVizAction;
	private IAction privateVizAction;
	private IAction currentVisibilityAction;

	private boolean isImport;

	protected Unit unit;

	private class PrivateVizAction extends Action {

		PrivateVizAction() {
			super(Messages.RequirementsPopupDialog_Privat_, IAction.AS_PUSH_BUTTON);
			setChecked(false);
			setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages().getImageDescriptor(
					ISharedImages.IMG_CONTRACT_PRIVATE));
			Image image = DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
					ISharedImages.IMG_CONTRACT_PRIVATE, false);
			if (image != null) {
				setDisabledImageDescriptor(ImageDescriptor.createFromImage(image));
			}
			setToolTipText(Messages.RequirementsPopupDialog_Set_Privat_);
		}

		public void run() {
			setCurrentVisibilityItem(UpdateContractOperation.PRIVATE_FLAG, this);
			executeChangeContractSettings(UpdateContractOperation.PRIVATE_FLAG);
		}
	}

	private class PublicEditableVizAction extends Action {

		PublicEditableVizAction() {
			super(Messages.RequirementsPopupDialog_Public_Editabl_, IAction.AS_PUSH_BUTTON);
			setChecked(false);
			setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages().getImageDescriptor(
					ISharedImages.IMG_CONTRACT_PUBLIC_EDITABLE));
			setToolTipText(Messages.RequirementsPopupDialog_Set_Public_Editabl_);
		}

		public void run() {
			setCurrentVisibilityItem(UpdateContractOperation.PUBLIC_EDITABLE_FLAG, this);
			executeChangeContractSettings(UpdateContractOperation.PUBLIC_EDITABLE_FLAG);
		}
	}

	private class PublicVizAction extends Action {
		PublicVizAction() {
			super(Messages.RequirementsPopupDialog_Publi_, IAction.AS_PUSH_BUTTON);
			setChecked(false);
			setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages().getImageDescriptor(
					ISharedImages.IMG_CONTRACT_PUBLIC));
			setToolTipText(Messages.RequirementsPopupDialog_Set_Publi_);
		}

		public void run() {
			setCurrentVisibilityItem(UpdateContractOperation.PUBLIC_FLAG, this);
			executeChangeContractSettings(UpdateContractOperation.PUBLIC_FLAG);
		}
	}

	/**
	 * Create a new toolbar manager.
	 * 
	 * @param parent
	 *           The parent {@link Composite}.
	 * @param isImport
	 *           Set to true if the passed {@link Unit} is imported.
	 * @param aUnit
	 *           The owning {@link Unit}.
	 * @param aToolBarHelper
	 *           A {@link RequirementsToolBarHelper} instance.
	 * @param aToolBarManager
	 *           An {@link IToolBarManager} that will be responsible for managing the {@link ToolBar}.
	 */
	public SharedReqCapsToolBarManager(Composite parent, boolean isImport, Unit aUnit,
			IToolBarManager aToolBarManager) {
		toolBar = aToolBarManager;
		this.isImport = isImport;
		unit = aUnit;
	}

	protected void initializeActions() {
		// Visibility
		if (!isImport) {
			createToggleVisibilityToolItem();
		}
	}

	/**
	 * Clients must call this method to add the actions to the {@link IToolBarManager} that was
	 * passed in the constructor.
	 */
	public void addActionsToToolbar() {
		if (!isImport) {
			toolBar.add(toggleVisibilityItem);
			toolBar.add(new Separator());
		}
	}

	private void createToggleVisibilityToolItem() {
		initializeVisibilityItemMenuActions();
		// Create push, drop-down item

		// The tool item should not enable in M5 since we do not suppor
		// re-export.
		toggleVisibilityItem = new Action() {

			@Override
			public void run() {
				if (!isImport) {
					// Perform the cached action.
					if (currentVisibilityAction != null) {
						currentVisibilityAction.run();
					}
				}
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.jface.action.Action#getStyle()
			 */
			@Override
			public int getStyle() {
				return IAction.AS_DROP_DOWN_MENU;
			}
		};

		toggleVisibilityItem.setMenuCreator(new IMenuCreator() {
			MenuManager mgr;

			public Menu getMenu(Menu parent) {
				return null;
			}

			public Menu getMenu(Control parent) {
				if (parent.getMenu() != null && mgr != null) {
					return parent.getMenu();
				}
				mgr = new MenuManager();
				mgr.add(publicVizAction);
				mgr.add(publicEditableVizAction);
				mgr.add(privateVizAction);
				Menu menu = mgr.createContextMenu(parent);
				parent.setMenu(menu);
				return menu;
			}

			public void dispose() {
				if (mgr != null) {
					mgr.dispose();
					mgr = null;
				}
			}

		});

		restoreLastVisibilityAction();
		toggleVisibilityItem.setEnabled(false);
	}

	/**
	 * 
	 */
	private void restoreLastVisibilityAction() {
		int lastViz = UpdateContractOperation.PUBLIC_FLAG;
		// Set the current action.
		IDialogSettings settings = getDialogSettings();
		String key = getSettingsPrefix() + SETTINGS_LAST_VISIBILITY;
		if (settings.get(key) != null) {
			//The settings is not null so set it based on the last setting.
			try {
				lastViz = settings.getInt(key);
			} catch (NumberFormatException numberException) {
			}
		}
		if (lastViz < 0) {
			lastViz = UpdateContractOperation.PUBLIC_FLAG;
		}
		IAction vizAction = null;
		switch (lastViz)
		{
		case UpdateContractOperation.PUBLIC_FLAG:
			vizAction = publicVizAction;
			break;
		case UpdateContractOperation.PUBLIC_EDITABLE_FLAG:
			vizAction = publicEditableVizAction;
			break;
		case UpdateContractOperation.PRIVATE_FLAG:
			vizAction = privateVizAction;
			break;
		}
		setCurrentVisibilityItem(lastViz, vizAction);
	}

	private void initializeVisibilityItemMenuActions() {
		publicVizAction = new PublicVizAction();
		publicEditableVizAction = new PublicEditableVizAction();
		privateVizAction = new PrivateVizAction();
	}

	/**
	 * Dispose the controls managed by this manager.
	 */
	public void dispose() {
		saveDialogSettings();
	}

	protected IDialogSettings getDialogSettings() {
		return DeployCoreUIPlugin.getDefault().getDialogSettings();
	}

	protected void saveDialogSettings() {
		IDialogSettings settings = getDialogSettings();
		int vizSetting = UpdateContractOperation.PUBLIC_FLAG;
		if (currentVisibilityAction != null) {
			if (currentVisibilityAction == publicEditableVizAction) {
				vizSetting = UpdateContractOperation.PUBLIC_EDITABLE_FLAG;
			} else if (currentVisibilityAction == privateVizAction) {
				vizSetting = UpdateContractOperation.PRIVATE_FLAG;
			}
			settings.put(getSettingsPrefix() + SETTINGS_LAST_VISIBILITY, vizSetting);
		}
	}

	protected abstract String getSettingsPrefix();

	protected void setCurrentVisibilityItem(int i, IAction action) {
		currentVisibilityAction = action;
		switch (i)
		{
		case UpdateContractOperation.PUBLIC_FLAG:
			toggleVisibilityItem.setToolTipText(action.getToolTipText());
			toggleVisibilityItem.setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages()
					.getImageDescriptor(ISharedImages.IMG_CONTRACT_PUBLIC));
			Image image = DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
					ISharedImages.IMG_CONTRACT_PUBLIC, false);
			if (image != null) {
				toggleVisibilityItem.setDisabledImageDescriptor(ImageDescriptor.createFromImage(image));
			}
			break;
		case UpdateContractOperation.PUBLIC_EDITABLE_FLAG:
			toggleVisibilityItem.setToolTipText(action.getToolTipText());
			toggleVisibilityItem.setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages()
					.getImageDescriptor(ISharedImages.IMG_CONTRACT_PUBLIC_EDITABLE));
			image = DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
					ISharedImages.IMG_CONTRACT_PUBLIC_EDITABLE, false);
			if (image != null) {
				toggleVisibilityItem.setDisabledImageDescriptor(ImageDescriptor.createFromImage(image));
			}
			break;
		case UpdateContractOperation.PRIVATE_FLAG:
			toggleVisibilityItem.setToolTipText(action.getToolTipText());
			toggleVisibilityItem.setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages()
					.getImageDescriptor(ISharedImages.IMG_CONTRACT_PRIVATE));
			image = DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
					ISharedImages.IMG_CONTRACT_PRIVATE, false);
			if (image != null) {
				toggleVisibilityItem.setDisabledImageDescriptor(ImageDescriptor.createFromImage(image));
			}
			break;
		}
	}

	protected abstract List<? extends DeployModelObject> getSelectedDMOs();

	/**
	 * Update the {@link ConfigurationContract} for the set of requirements from the
	 * toggleVisibilityItem.
	 * 
	 * @param contractFlag
	 *           The flag indicating the contract change.
	 */
	protected void executeChangeContractSettings(int contractFlag) {
		List<? extends DeployModelObject> selectedDMOs = getSelectedDMOs();
		if (selectedDMOs != null) {
			IUndoableOperation op = UpdateContractOperation.createUpdateContractOperation(
					selectedDMOs, contractFlag, "Update Contracts"); //$NON-NLS-1$
			if (op != null) {
				// Create a ChangeScope based on the first object.
				DeployModelObject someUnit = selectedDMOs.get(0).getParent();
				LightweightOperationFactory.execute(someUnit, op);
			}
		}
	}

	protected void setVisibilityItemEnabled(boolean enabled) {
		if (toggleVisibilityItem != null) {
			toggleVisibilityItem.setEnabled(enabled);
		}
	}

	protected boolean isImport() {
		return isImport;
	}

	public void setIsImport(boolean isNonMutableImport) {
		isImport = isNonMutableImport;
	}

	public final void setInput(Unit aUnit) {
		if (unit != aUnit) {
			unit = aUnit;
			didSetInput(aUnit);
		}
	}

	protected void didSetInput(Unit aUnit) {

	}

	/**
	 * @return The {@link IToolBarManager} internally used by this manager.
	 */
	public IToolBarManager getInternalToolBarManager() {
		return toolBar;
	}

}
