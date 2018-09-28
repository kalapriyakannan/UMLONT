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

import java.util.Collection;
import java.util.List;

import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.LinkDetailComposite;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.PopupCloserListener;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.UndoRedoActionGroup;
import com.ibm.ccl.soa.deploy.core.ui.properties.DeployUIWidgetFactory;
import com.ibm.ccl.soa.deploy.core.ui.util.ResourceUtils;

/**
 * Popup for explaining a visual link (which may correspond to multiple model links.)
 * 
 * @author Ed Snible (based on daberg original)
 * @see LinkDetailComposite
 */
public class LinkDetailPopupDialog extends PopupDialog {
	private LinkDetailComposite detailComposite;
	//	private RequirementsPropertiesLabelProvider labelProvider;
	private boolean isFirstInputSet = true;
	private final Point initialLocation;
	private ToolItem deleteLinksItem;
	private TabbedPropertySheetWidgetFactory ft;
	private PopupCloserListener popupCloser;
	private UndoRedoActionGroup globalActionGroup;

	//	private boolean unitIsImported;

	/**
	 * @param parent
	 * @param initialLocation
	 */
	public LinkDetailPopupDialog(Shell parent, Point initialLocation) {
		super(parent, SWT.RESIZE, true, // focus on open
				true, // persist bounds
				true, // show menu
				false, // show persist action
				null, null);
		this.initialLocation = initialLocation;
	}

	//	/**
	//	 * @param links
	//	 */
	//	public void setLinks(List<DeployLink> links) {
	//		if (detailComposite != null) {
	//			detailComposite.setInput(links);
	//		}
	//	}

	protected Control createDialogArea(Composite parent) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_PROPERTIES_LINKS_TAB);
		ft = new TabbedPropertySheetWidgetFactory();
		detailComposite = new LinkDetailComposite(parent, ft);
		detailComposite.setLayout(new GridLayout());
		//		detailComposite.setPopupDialog(true, this.getParentShell());

		detailComposite.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				// do nothing
			}

			public void widgetSelected(SelectionEvent e) {
				updateToolbarEnablement();
			}
		});

		return detailComposite;
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

		Label dummy = new Label(titleComposite, SWT.NULL);
		dummy.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		createLinkDetailsToolBar(titleComposite);

		return titleComposite;
	}

	private void createLinkDetailsToolBar(Composite parent) {
		ToolBar toolBar = new ToolBar(parent, SWT.FLAT);
		toolBar.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));

		// Delete
		createDeleteLinksToolItem(toolBar);
	}

	private void createDeleteLinksToolItem(ToolBar toolBar) {
		deleteLinksItem = new ToolItem(toolBar, SWT.PUSH);
		deleteLinksItem.setImage(DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
				ISharedImages.IMG_DELETE_LINK));
		deleteLinksItem.setDisabledImage(DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
				ISharedImages.IMG_DELETE_LINK_DISABLED));
		deleteLinksItem
				.setToolTipText(com.ibm.ccl.soa.deploy.core.ui.properties.Messages.ConfigurationsPropertySection2_Unlin_);

		deleteLinksItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleDeleteLinks();
			}
		});
	}

	protected Point getInitialLocation(Point initialSize) {
		return initialLocation;
		//		return super.getInitialLocation(initialSize);
	}

	/**
	 * @param links
	 */
	public void setInput(List<DeployLink> links) {
		detailComposite.setInput(links);
		if (isFirstInputSet) {
			isFirstInputSet = false;
			getShell().pack();
		}
	}

	/*
	 * Overridden to force change of colors. See https://bugs.eclipse.org/bugs/show_bug.cgi?id=136244
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.PopupDialog#createContents(org.eclipse.swt.widgets.Composite)
	 */
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		changeDefaultColors(parent);
		DeployUIWidgetFactory.INSTANCE.createModifiedStatusBarWithClose((Composite) contents, this);
		updateToolbarEnablement();
		return contents;
	}

	/**
	 * We need to keep PopupDialog from setting the background color of anything on the UIHandler. We
	 * don't need to set it, because it was already created with the color it wants. Furthermore, the
	 * default behavior was setting the constraint 'section' title to have a white background rather
	 * than a transparent one, creating cutouts in the section gradient.
	 */
	@Override
	protected List getBackgroundColorExclusions() {
		List exclusions = super.getBackgroundColorExclusions();
		collectAllChildren(detailComposite, exclusions);
		return exclusions;
	}

	private void collectAllChildren(Composite composite, Collection<Control> children) {
		for (Control control : composite.getChildren()) {
			if (control instanceof Composite) {
				children.add(control);
				collectAllChildren((Composite) control, children);
			} else {
				children.add(control);
			}
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

	private void dispose() {
		if (detailComposite != null && !detailComposite.isDisposed()) {
			detailComposite.dispose();
		}
		if (ft != null) {
			ft.dispose();
		}
	}

	/**
	 * @return
	 */
	public boolean hasFocus() {
		if (detailComposite.isDisposed()) {
			return false;
		}
		return getShell().isFocusControl() || detailComposite.isFocusControl();
	}

	@Override
	public int open() {
//		this.getShell().addDisposeListener(new DisposeListener() {
//
//			public void widgetDisposed(DisposeEvent e) {
//				dispose();
//			}
//		});
		if (popupCloser == null) {
			popupCloser = new PopupCloserListener(this);
		}
		int retVal = super.open();
		registerKeyBindings();
		return retVal;
	}

	@Override
	public boolean close() {
		if (globalActionGroup != null) {
			globalActionGroup.dispose();
		}
		return super.close();
	}

	private void registerKeyBindings() {
		//Register action group.
		IEditorPart editorPart = ResourceUtils.getActiveEditorPart();
		if (editorPart != null) {
			globalActionGroup = new UndoRedoActionGroup(editorPart);
		}
	}

	protected void updateToolbarEnablement() {
		boolean canDelete = detailComposite.canDeleteSelectedLinks();
		deleteLinksItem.setEnabled(canDelete);
	}

	protected void handleDeleteLinks() {
		detailComposite.deleteSelectedLinks();
		deleteLinksItem.setEnabled(false);
	}

} // end class LinkDetailPopupDialog
