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

import java.util.List;

import org.eclipse.gef.EditDomain;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.UnitFlyOutPropertiesToggler.UnitFlyOutPropertiesTogglerDialog;
import com.ibm.ccl.soa.deploy.core.ui.properties.DeployUIWidgetFactory;
import com.ibm.ccl.soa.deploy.core.ui.properties.Messages;
import com.ibm.ccl.soa.deploy.core.ui.util.ResourceUtils;

/**
 * PopupDialog for the Unit general property sheet.
 * 
 * @author NKruk
 * 
 */
public class GeneralPropertyFlyoutDialog extends PopupDialog implements
		UnitFlyOutPropertiesTogglerDialog {

	private final DeployModelObject unit;
	private final Point loc;
	private GeneralPropertyComposite popup;
	private PopupCloserListener popupListener;
	private final EditDomain gefDomain;
	private FormToolkit toolkit;
	private UndoRedoActionGroup globalActionGroup;
	private ToolBarManager toolBarManager;
	private Composite modifiedStatusBar;
	private boolean isClosed = false;

	/**
	 * Create the popup dialog.
	 * 
	 * @param parentShell
	 * @param unit
	 * @param loc
	 * @param gefDomain
	 */
	@SuppressWarnings("deprecation")
	public GeneralPropertyFlyoutDialog(Shell parentShell, DeployModelObject unit, Point loc,
			EditDomain gefDomain) {
		super(parentShell, SWT.TOOL | SWT.RESIZE, true, false, true, false, null, NLS.bind(
				Messages.UnitFlyOutPropertiesToggler_toggleMessage,
				Messages.UnitFlyOutPropertiesToggler_Capabilities));
		this.unit = unit;
		this.loc = loc;
		this.gefDomain = gefDomain;
	}

	/**
	 * Create the popup dialog.
	 * 
	 * @param parentShell
	 * @param unit
	 * @param loc
	 * @param gefDomain
	 * @param infoText
	 * @param aToggler
	 */
	GeneralPropertyFlyoutDialog(Shell parentShell, DeployModelObject unit, Point loc,
			EditDomain gefDomain, String infoText) {
		super(parentShell, SWT.TOOL | SWT.RESIZE, true, false, true, false, null, infoText);
		this.unit = unit;
		this.loc = loc;
		this.gefDomain = gefDomain;
	}

	protected Control createDialogArea(Composite parent) {
		toolkit = new FormToolkit(Display.getCurrent());
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_UNIT_PROPERTIES_FLYOUT);
		popup = new GeneralPropertyComposite(parent, SWT.NONE, toolkit);
		popup.setInput(unit);
		popup.selectName();
		return popup;
	}

	public boolean close() {
		if (!isClosed) {
			isClosed = true;
			popupListener.dispose();
			popup.dispose();
			if (toolkit != null) {
				toolkit.dispose();
			}
			if (toolBarManager != null) {
				toolBarManager.dispose();
			}
			if (globalActionGroup != null) {
				globalActionGroup.dispose();
			}
		}
		return super.close();
	}

	protected Point getInitialLocation(Point initialSize) {
		return loc;
	}

	protected Control createTitleControl(Composite parent) {
		Composite titleComposite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(1, false);
		layout.marginHeight = POPUP_MARGINHEIGHT;
		layout.marginWidth = POPUP_MARGINWIDTH;
		layout.verticalSpacing = POPUP_VERTICALSPACING;
		layout.horizontalSpacing = POPUP_HORIZONTALSPACING;
		titleComposite.setLayout(layout);
		titleComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		createToolBar(titleComposite);
		return titleComposite;
	}

	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		changeDefaultColors(parent);
		return contents;
	}

	@Override
	protected Control createInfoTextArea(Composite parent) {
		modifiedStatusBar = DeployUIWidgetFactory.INSTANCE.createModifiedDialogStatusBar(parent, 2);
		Label label = (Label) super.createInfoTextArea(modifiedStatusBar);
		//Switch alignment to the left.
		label.setAlignment(SWT.LEFT);
		DeployUIWidgetFactory.INSTANCE.createCloseHyperlink(modifiedStatusBar, this);
		return modifiedStatusBar;
	}

	@Override
	public int open() {
		int retVal = super.open();
		registerKeyBindings();
		popupListener = new GeneralPopupCloseListener(this);
		popup.setPopupListener(popupListener);
		return retVal;
	}

	private void registerKeyBindings() {
		//Register action group.
		IEditorPart editorPart = ResourceUtils.getActiveEditorPart();
		if (editorPart != null) {
			globalActionGroup = new UndoRedoActionGroup(editorPart);
		}
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

	@Override
	//Make sure the Correct backgrounds show up for our children
	protected List<Control> getBackgroundColorExclusions() {
		List<Control> retVal = super.getBackgroundColorExclusions();
		DeployUIWidgetFactory.INSTANCE.addChildren(popup, retVal);
		DeployUIWidgetFactory.INSTANCE.addWithChildren(modifiedStatusBar, retVal);
		return retVal;
	}

	@Override
	public Control getContents() {
		return super.getContents();
	}

	private void createToolBar(Composite parent) {
		ToolBar toolBar = new ToolBar(parent, SWT.FLAT);
		toolBar.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));
		toolBarManager = new ToolBarManager(toolBar);
		//	initializeToolBar(toolBar, toolBarManager);
		GridData gd = new GridData(SWT.END, SWT.CENTER, true, false);
		toolBar.setLayoutData(gd);
		toolBarManager.update(true);
	}

	public int getDialogIndex() {
		return GEN_INDEX;
	}

	public void setToggleMessage(String message) {
		setInfoText(message);
	}

	public IToolBarManager getToolBarManager() {
		return toolBarManager;
	}

	public boolean isClosed() {
		return isClosed;
	}
}
