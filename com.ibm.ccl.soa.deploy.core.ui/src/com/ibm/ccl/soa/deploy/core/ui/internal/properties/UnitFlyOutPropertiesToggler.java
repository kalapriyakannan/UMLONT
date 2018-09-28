/***************************************************************************************************
 * Copyright (c) 2008 IBM Corporation. All rights reserved.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.properties;

import org.eclipse.gef.EditDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.composites.DmoTabbedComposite;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.CapabilitiesPopupDialog;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.RequirementsPopupDialog;
import com.ibm.ccl.soa.deploy.core.ui.properties.Messages;

/**
 * This class is used to toggle between the General, Capabilities, and Requirements property
 * dialogs.
 * 
 */
public class UnitFlyOutPropertiesToggler implements KeyListener {

	private UnitFlyOutPropertiesTogglerDialog currentDialog;
	private boolean needToResizeGen = true;

	/**
	 * All dialogs that support Unit toggling need to implement this interface. This interface is not
	 * to be implemented by clients.
	 * 
	 */
	public static interface UnitFlyOutPropertiesTogglerDialog extends IShellProvider {

		/**
		 * Index for the {@link GeneralPropertyFlyoutDialog}
		 */
		final int GEN_INDEX = 0;
		/**
		 * Index for the {@link CapabilitiesPopupDialog}
		 */
		final int CAP_INDEX = 1;
		/**
		 * Index for the {@link RequirementsPopupDialog}
		 */
		final int REQ_INDEX = 2;

		/**
		 * @return The contents for the dialog.
		 */
		Control getContents();

		/**
		 * 
		 * @return int
		 * 
		 */
		int getDialogIndex();

		/**
		 * Close the dialog.
		 * 
		 * @return boolean
		 */
		boolean close();

		/**
		 * 
		 * @return int
		 */
		int open();

		/**
		 * Create the shell.
		 */
		void create();

		/**
		 * Set a message to be displayed at the bottom of the dialog.
		 * 
		 * @param aMessage
		 */
		void setToggleMessage(String aMessage);

		/**
		 * @return A {@link IToolBarManager}.
		 */
		IToolBarManager getToolBarManager();
	}

	private static final class NextDialogAction extends Action {
		private final UnitFlyOutPropertiesToggler toggler;

		private NextDialogAction(UnitFlyOutPropertiesToggler aToggler) {
			toggler = aToggler;
		}

		@Override
		public ImageDescriptor getImageDescriptor() {
			return PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(
					ISharedImages.IMG_TOOL_FORWARD);
		}

		@Override
		public void run() {
			toggler.togglePropertiesDialog();
		}
	}

	private static final class PreviousDialogAction extends Action {
		private final UnitFlyOutPropertiesToggler toggler;

		private PreviousDialogAction(UnitFlyOutPropertiesToggler aToggler) {
			toggler = aToggler;
		}

		@Override
		public ImageDescriptor getImageDescriptor() {
			return PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(
					ISharedImages.IMG_TOOL_BACK);
		}

		@Override
		public void run() {
			toggler.reverseTogglePropertiesDialog();
		}
	}

	/*
	 * 0 == GeneralPropertyFlyoutDialog 1 == CapabilitiesPopupDialog 2 == RequirementsPopupDialog
	 */
	private int dialogIndex;
	private final Unit unit;
	private final EditDomain gefDomain;
	private final Shell parentShell;

	//Actions
	private IAction nextDialogAction;
	private IAction previousDialogAction;

	/**
	 * @param aUnit
	 * @param aGefDomain
	 * @param aPopupDialog
	 */
	public UnitFlyOutPropertiesToggler(Unit aUnit, EditDomain aGefDomain,
			UnitFlyOutPropertiesTogglerDialog aPopupDialog) {
		unit = aUnit;
		gefDomain = aGefDomain;
		currentDialog = aPopupDialog;
		Shell shell = aPopupDialog.getShell();
		if (shell == null || shell.isDisposed()) {
			aPopupDialog.create();
		}
		initializeActions();
		bind(aPopupDialog);
		setToggleMessage(aPopupDialog);
		parentShell = aPopupDialog.getShell().getParent().getShell();
		dialogIndex = aPopupDialog.getDialogIndex();
		if (dialogIndex == UnitFlyOutPropertiesTogglerDialog.GEN_INDEX) {
			needToResizeGen = false;
		}
	}

	private void initializeActions() {
		nextDialogAction = new NextDialogAction(this);
		previousDialogAction = new PreviousDialogAction(this);
	}

	private void bind(UnitFlyOutPropertiesTogglerDialog popupDialog) {
		//Add toolbar actions.
		IToolBarManager toolbar = popupDialog.getToolBarManager();
		if (!toolbar.isEmpty()) {
			toolbar.add(new Separator());
		}
		toolbar.add(previousDialogAction);
		toolbar.add(nextDialogAction);
		toolbar.update(false);
		//Set action info text
		switch (popupDialog.getDialogIndex())
		{
		case UnitFlyOutPropertiesTogglerDialog.GEN_INDEX:
			setTooltip(nextDialogAction, Messages.UnitFlyOutPropertiesToggler_Capabilities);
			setTooltip(previousDialogAction, Messages.UnitFlyOutPropertiesToggler_Requirements);
			break;
		case UnitFlyOutPropertiesTogglerDialog.CAP_INDEX:
			setTooltip(nextDialogAction, Messages.UnitFlyOutPropertiesToggler_Requirements);
			setTooltip(previousDialogAction, Messages.UnitFlyOutPropertiesToggler_GeneralProperties);
			break;
		case UnitFlyOutPropertiesTogglerDialog.REQ_INDEX:
			setTooltip(nextDialogAction, Messages.UnitFlyOutPropertiesToggler_GeneralProperties);
			setTooltip(previousDialogAction, Messages.UnitFlyOutPropertiesToggler_Capabilities);
			break;
		}
		//Bind controls.
		bind(popupDialog.getContents());

	}

	private void setToggleMessage(UnitFlyOutPropertiesTogglerDialog popupDialog) {
		switch (popupDialog.getDialogIndex())
		{
		case UnitFlyOutPropertiesTogglerDialog.CAP_INDEX:
			popupDialog.setToggleMessage(NLS.bind(Messages.UnitFlyOutPropertiesToggler_toggleMessage,
					Messages.UnitFlyOutPropertiesToggler_Requirements));
			break;
		case UnitFlyOutPropertiesTogglerDialog.REQ_INDEX:
			popupDialog.setToggleMessage(NLS.bind(Messages.UnitFlyOutPropertiesToggler_toggleMessage,
					Messages.UnitFlyOutPropertiesToggler_GeneralProperties));
			break;
		case UnitFlyOutPropertiesTogglerDialog.GEN_INDEX:
			//Requirements to General
			popupDialog.setToggleMessage(NLS.bind(Messages.UnitFlyOutPropertiesToggler_toggleMessage,
					Messages.UnitFlyOutPropertiesToggler_Capabilities));
			break;
		}

	}

	public void keyPressed(KeyEvent e) {
		if ((e.stateMask & SWT.CTRL) != 0 && e.character == ' ') {
			togglePropertiesDialog();
		}
	}

	/*
	 * Pressed CTRL+Space>
	 */
	private void togglePropertiesDialog() {
		Shell shell = currentDialog.getShell();
		switch (dialogIndex)
		{
		case UnitFlyOutPropertiesTogglerDialog.GEN_INDEX:
			//General to Capabilities
			openCapabilitiesDialog(shell);
			break;
		case UnitFlyOutPropertiesTogglerDialog.CAP_INDEX:
			//Capabilities to Requirements
			openRequirementsDialog(shell);
			break;

		case UnitFlyOutPropertiesTogglerDialog.REQ_INDEX:
			//Requirements to General
			openGeneralDialog(shell);
			break;
		}
	}

	private void openGeneralDialog(Shell shell) {
		GeneralPropertyFlyoutDialog genDialog = new GeneralPropertyFlyoutDialog(parentShell, unit,
				shell.getLocation(), gefDomain, NLS.bind(
						Messages.UnitFlyOutPropertiesToggler_toggleMessage,
						Messages.UnitFlyOutPropertiesToggler_Capabilities));
		genDialog.create();
		Point size = shell.getSize();
		if (needToResizeGen) {
			size = null;
			needToResizeGen = false;
		}
		openNextDialog(size, genDialog);
	}

	private void openRequirementsDialog(Shell shell) {
		RequirementsPopupDialog reqDialog = new RequirementsPopupDialog(parentShell, unit, shell
				.getLocation(), NLS.bind(Messages.UnitFlyOutPropertiesToggler_toggleMessage,
				Messages.UnitFlyOutPropertiesToggler_GeneralProperties));
		reqDialog.create();
		openNextDialog(shell.getSize(), reqDialog);
	}

	private void openCapabilitiesDialog(Shell shell) {
		CapabilitiesPopupDialog capDialog = new CapabilitiesPopupDialog(parentShell, unit, shell
				.getLocation(), NLS.bind(Messages.UnitFlyOutPropertiesToggler_toggleMessage,
				Messages.UnitFlyOutPropertiesToggler_Requirements));
		capDialog.create();
		openNextDialog(shell.getSize(), capDialog);
	}

	private void setTooltip(IAction anAction, String s) {
		anAction.setText(NLS.bind(Messages.UnitFlyOutPropertiesToggler_GOTO, s));
	}

	private void reverseTogglePropertiesDialog() {
		Shell shell = currentDialog.getShell();
		switch (dialogIndex)
		{
		case UnitFlyOutPropertiesTogglerDialog.GEN_INDEX:
			//General to Requirements
			openRequirementsDialog(shell);
			break;
		case UnitFlyOutPropertiesTogglerDialog.CAP_INDEX:
			//Capabilities to General
			openGeneralDialog(shell);
			break;

		case UnitFlyOutPropertiesTogglerDialog.REQ_INDEX:
			//Requirements to Capabilities
			openCapabilitiesDialog(shell);
			break;
		}
	}

	private void openNextDialog(Point size, UnitFlyOutPropertiesTogglerDialog nextDialog) {
		bind(nextDialog);
		if (size != null) {
			nextDialog.getShell().setSize(size);
		}
		dialogIndex = nextDialog.getDialogIndex();
		nextDialog.open();
		currentDialog.close();
		currentDialog = nextDialog;
	}

	public void keyReleased(KeyEvent e) {
	}

	/**
	 * Add key bindings to aControl.
	 * 
	 * @param aControl
	 */
	private void bind(Control aControl) {
		if (aControl instanceof DmoTabbedComposite) {
			bindDmoTabbedComposite((DmoTabbedComposite) aControl);
		} else if (aControl instanceof Composite) {
			bindComposite((Composite) aControl);
		}
		aControl.addKeyListener(this);
	}

	private void bindComposite(Composite composite) {
		Control[] children = composite.getChildren();
		for (int i = 0; i < children.length; i++) {
			bind(children[i]);
		}
	}

	private void bindDmoTabbedComposite(DmoTabbedComposite tabbedComposite) {
		CTabItem[] tabs = tabbedComposite.getTabs();
		if (tabs != null) {
			for (int i = 0; i < tabs.length; i++) {
				bind(tabs[i].getControl());
			}
		}
	}
}
