/***************************************************************************************************
 * Copyright (c) 2008 IBM Corporation. All rights reserved.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.composites;

import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ui.actions.BasicToolbarAction;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.PopupCloserListener;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;

/**
 * Class will create a modified section view that has a label and toolbar.
 * 
 */
public abstract class ModifiedSectionComposite extends Composite {

	protected DeployModelObject dmo;
	private boolean mutable;
	protected final FormToolkit formToolkit;
	ModelListener dmoListener;
	private ToolBarManager toolbarManager;
	private ToolBar toolBar;

	/*
	 * This field is used to hold a PopupCloserListener that would be set but PopupDialogs to ensure
	 * that they close when a downstream composite opens another popup dialog.
	 */
	protected PopupCloserListener popupCloser;

	/**
	 * @param parent
	 * @param style
	 * @param deployModelObject
	 * @param ft
	 */
	public ModifiedSectionComposite(Composite parent, int style,
			DeployModelObject deployModelObject, FormToolkit ft) {
		super(parent, style);
		formToolkit = ft;
		initializeContents();
		setInput(deployModelObject);
	}

	/**
	 * @param newDmo
	 */
	public void setInput(DeployModelObject newDmo) {
		if (dmo != null) {
			stopListeningForChanges();
		}

		dmo = newDmo;
		mutable = DeployModelObjectUtil.isMutable(dmo);
		listenForChanges();
	}

	private final void initializeContents() {
		GridLayout gl = new GridLayout();
		gl.marginWidth = 0;
		gl.marginHeight = 0;
		gl.verticalSpacing = 5;
		setLayout(gl);
		setBackgroundMode(SWT.INHERIT_DEFAULT);
		createToolBar(this);
		initializeBody();
	}

	protected void createToolBar(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setBackground(getDisplay().getSystemColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		GridLayout gl = new GridLayout(2, false);
		gl.marginWidth = 5;
		gl.marginHeight = 0;
		comp.setLayout(gl);
		comp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		createToolbarTitleControls(comp);
		//Initialize toolbar.
		toolbarManager = new ToolBarManager(SWT.FLAT);
		toolBar = toolbarManager.createControl(comp);
		toolBar.setLayoutData(new GridData(SWT.END, SWT.CENTER, false, false));
		initializeToolBar(toolbarManager);
		toolbarManager.update(true);
	}

	protected boolean isMutable() {
		return mutable;
	}

	protected boolean canModify(DeployModelObject aDmo) {
		return aDmo.isPublicEditable(); // || (aDmo.getTopology() == aDmo.getEditTopology();
	}

	protected boolean canModify(List<? extends DeployModelObject> dmos) {
		if (dmos == null || dmos.isEmpty()) {
			return false;
		} else {
			Iterator<? extends DeployModelObject> it = dmos.iterator();
			while (it.hasNext()) {
				if (!canModify(it.next())) {
					return false;
				}
			}
			return true;
		}
	}

	protected Point getToolbarActionPoint(int actionIndex) {
		ToolItem toolItem = toolBar.getItem(actionIndex);
		assert toolItem != null;
		Rectangle bounds = toolItem.getBounds();
		return toolbarManager.getControl().toDisplay(bounds.x, bounds.y + bounds.height);
	}

	@Override
	public void dispose() {
		if (toolbarManager != null) {
			toolbarManager.dispose();
		}
		stopListeningForChanges();
	}

	private void listenForChanges() {
		if (dmo != null) {
			dmoListener = createModelListener();
			dmoListener.adapt(dmo);
		}
	}

	protected abstract ModelListener createModelListener();

	private void stopListeningForChanges() {
		if (dmoListener != null) {
			dmoListener.dispose();
			dmoListener = null;
		}
	}

	/**
	 * This setter is to be used by {@link PopupDialog} clients to allow the caller to pass an
	 * instance of a {@link PopupCloserListener} which will ensure the primary dialog closes when
	 * focus moves to a another shell from a secondary dialog opened by downstream composite.
	 * 
	 * @param aPopupCloser
	 *           The popupCloser to set.
	 * 
	 * @see PopupCloserListener#setSecondaryPopup(org.eclipse.jface.window.Window)
	 */
	public void setPopupCloser(PopupCloserListener aPopupCloser) {
		popupCloser = aPopupCloser;
	}

	protected abstract void initializeToolBar(ToolBarManager toolbarMgr);

	protected abstract void createToolbarTitleControls(Composite parent);

	protected abstract void initializeBody();

	/**
	 * Open the menu associated with the action and the ToolItem dynamically.
	 * 
	 * @param toolItemIndex
	 *           The index of the toolbar item (zero based).
	 * @param action
	 *           The action that contributes the menu.
	 */
	protected void openToolBarPopupMenu(int toolItemIndex, BasicToolbarAction action) {
		ToolItem ti = toolBar.getItem(toolItemIndex);
		if (ti != null && action != null) {
			Menu m = action.getMenu(ti.getParent());
			if (m != null) {
				Rectangle bounds = ti.getBounds();
				// position the menu below the drop down item
				Point point = ti.getParent().toDisplay(new Point(bounds.x, bounds.y + bounds.height));
				m.setLocation(point.x, point.y); // waiting
				m.setVisible(true);
			}
		}
	}
}
