/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.properties;

import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.IPageSite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.ibm.ccl.soa.deploy.core.Artifact;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.actions.BasicToolbarAction;
import com.ibm.ccl.soa.deploy.core.ui.composites.AbstractCompositeFactory;
import com.ibm.ccl.soa.deploy.core.ui.composites.DmoComposite;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.CustomizeAttributesDialog;
import com.ibm.ccl.soa.deploy.core.ui.internal.SoaDeployUiUtil;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.LyingLayout;
import com.ibm.ccl.soa.deploy.core.ui.marker.quickfix.MarkerResolutionHelper;
import com.ibm.ccl.soa.deploy.core.ui.marker.quickfix.QuickFixDialog;
import com.ibm.ccl.soa.deploy.saf.ui.extension.IUIHandlerService;
import com.ibm.ccl.soa.deploy.saf.ui.handler.IUIHandlerDescriptor;

/**
 * Property section, on 'Artifacts' tab, for artifacts.
 * 
 * <p>
 * This section is controlled by a &lt;propertySection&gt; entry within a
 * <code>org.eclipse.ui.views.properties.tabbed.propertySections</code> extension point.
 * 
 * @author Ed Snible
 * @see ArtifactContentProvider
 */
public class ModulePropertySection extends AbstractTopologyPropertySection implements
		IShellProvider {

	private static final String MENU_ID = "topology.artifacts.view"; //$NON-NLS-1$

	/** Left-side selector */
	private TreeViewer treeViewer;

	private DmoComposite compositeShowing;

	private Unit unit;

	private IAction removeArtifactAction;

	private IAction createArtifactAction;

	private IAction editAttributeAction;

	private boolean mutable;

	private SashForm sf;

	private ILabelProvider artifactLabelProvider;

	private Artifact artifactShowing;

	private ScrolledComposite propsWrapper;

	private static class BasicSelectionProvider implements ISelectionProvider {

		private final ListenerList listeners = new ListenerList();
		private ISelection currentSelection = null;

		public void addSelectionChangedListener(ISelectionChangedListener listener) {
			listeners.add(listener);
		}

		public ISelection getSelection() {
			return currentSelection;
		}

		public void removeSelectionChangedListener(ISelectionChangedListener listener) {
			listeners.add(listener);

		}

		public void setSelection(ISelection selection) {
			currentSelection = selection;
			notifyListeners(new SelectionChangedEvent(this, selection));

		}

		private void notifyListeners(final SelectionChangedEvent event) {
			Object[] notify = listeners.getListeners();
			for (Object o : notify) {
				if (o instanceof ISelectionChangedListener) {
					((ISelectionChangedListener) o).selectionChanged(event);
				}
			}
		}

	};

	private final ISelectionProvider unitSelectionProvider = new BasicSelectionProvider();

//	private String artifactLabelShowing;
//
//	private Image artifactImageShowing;

	protected void doCreateControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_PROPERTIES_ARTIFACTS_TAB);
		// Create a new section to wrap and layout our table
		Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		composite.setLayout(new LyingLayout());

		sf = new SashForm(composite, SWT.HORIZONTAL);

		createArtifactsPane(sf);

		createArtifactPane(sf);

		sf.setWeights(new int[] { 1, 2 });

		createActions();

		createContextMenu(treeViewer.getTree(), getPage().getSite());
	}

	@Override
	protected void doDispose() {
		if (sf != null && !sf.isDisposed()) {
			sf.dispose();
		}

	}

	/** Create the list of artifacts on the left-hand side */
	private void createArtifactsPane(Composite parent) {

		Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		composite.setLayout(new GridLayout(2, true));

		final Tree tree = getWidgetFactory().createTree(composite,
				SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		GridData gdTree = new GridData(GridData.FILL_BOTH);
		gdTree.horizontalSpan = 2;
		tree.setLayoutData(gdTree);

		treeViewer = new TreeViewer(tree);
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				if (getSelectedArtifact() != null) {
					showSelectedArtifact();
				}
			}
		});

		treeViewer.getControl().addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.DEL && e.stateMask == 0) {
					if (removeArtifactAction.isEnabled()) {

						delArtifact();
					}
				}
			}
		});

		ArtifactContentProvider acp = new ArtifactContentProvider();
		treeViewer.setContentProvider(acp);
		artifactLabelProvider = PropertyUtils.getSoaLabelProvider();
		treeViewer.setLabelProvider(artifactLabelProvider);

		tree.addMouseListener(new ArtifactListMouseListener());

	}

	private void createContextMenu(final Tree tree, IPageSite pageSite) {
		MenuManager menuMgr = new MenuManager(MENU_ID);
		Menu menu = menuMgr.createContextMenu(tree);

		tree.setMenu(menu);

		pageSite.registerContextMenu(MENU_ID, menuMgr, new BasicSelectionProvider() {
			@Override
			public void setSelection(ISelection selection) {
				if (treeViewer != null && !treeViewer.getControl().isDisposed()) {
					treeViewer.setSelection(selection);
				}
			}

			@Override
			public ISelection getSelection() {
				return treeViewer.getSelection();
			}

		});
	}

	private void createActions() {

		// create standard artifact drop down actions
		createArtifactAction = new BasicToolbarAction(NLS.bind(Messages.AddArtifactAction_Add_0_,
				Messages.ModulePropertySection_none_), DeployCoreUIPlugin
				.getImageDescriptor(AddArtifactAction.IMAGE_PATH), DeployCoreUIPlugin
				.getImageDescriptor(AddArtifactAction.IMAGE_PATH)) {

			@Override
			public IAction createDefaultAction(IWorkbenchPage activePage) {

				IUIHandlerService handlerService = DeployCoreUIPlugin.getDefault()
						.getArtifactUIHandlerService();

				IUIHandlerDescriptor descriptor = handlerService
						.findAllUIHandlerDescriptors("artifact.file"); //$NON-NLS-1$
				if (handlerService != null) {
					return new AddArtifactAction(descriptor.getName(), descriptor.getKind(),
							ModulePropertySection.this, null, unitSelectionProvider);
				}
				return null;
			}

			@Override
			public boolean isEnabled(IStructuredSelection selection) {
				return true;
			}

			@Override
			public void populateMenu(IWorkbenchPage activePage, Menu emptyMenu) {

				IUIHandlerService handlerService = DeployCoreUIPlugin.getDefault()
						.getArtifactUIHandlerService();

				IUIHandlerDescriptor[] descriptors = handlerService.findAllUIHandlerDescriptors();
				for (IUIHandlerDescriptor descriptor : descriptors) {

					createMenuItem(new AddArtifactAction(descriptor.getName(), descriptor.getKind(),
							ModulePropertySection.this, null, unitSelectionProvider), emptyMenu);
				}

			}

		};

		String delArt = Messages.ModulePropertySection_DELETE_ARTIFACT;
		removeArtifactAction = propAction(delArt, "icons/elcl16/delt_atfct.gif", new Action() { //$NON-NLS-1$
					public void run() {
						delArtifact();
					}
				});

		String editAttr = Messages.ExtendedAttributeDialog_Customize_Attribute_;
		editAttributeAction = propAction(editAttr, "icons/elcl16/edit_attrbut.gif", new Action() { //$NON-NLS-1$
					public void run() {
						editAttributes();
					}
				});
	}

	private Action propAction(String msg, String icon, Action a) {
		a.setText(msg);
		a.setToolTipText(msg);
		ImageDescriptor id = PropertyUtils.createImageDescriptor(icon);
		Image image = DeployCoreUIPlugin.getDefault().getSharedImages().getImageFromPath(icon, false);
		if (image != null) {
			a.setDisabledImageDescriptor(ImageDescriptor.createFromImage(image));
		}
		a.setImageDescriptor(id);
		return a;
	}

	@Override
	protected void setInput(DeployModelObject input) {
		if (input instanceof Unit) {
			setModuleInput((Unit) input);
		}
	}

	private void setModuleInput(Unit module) {
		if (unit == module) {
			return;
		}
		unit = module;
		unitSelectionProvider.setSelection(new StructuredSelection(unit));

		if (unit != null) {
			mutable = PropertyUtils.isEditable(unit);
			treeViewer.setInput(unit);
			showSelectedArtifact();
		}

		enableDisableButtons();
	}

	public boolean shouldUseExtraSpace() {
		return true;
	}

	private void createArtifactPane(Composite parent) {

		propsWrapper = getWidgetFactory().createScrolledComposite(parent, SWT.V_SCROLL);
		propsWrapper.setLayout(new GridLayout());

		propsWrapper.setExpandVertical(true);
		propsWrapper.setExpandHorizontal(true);
	}

	/** The capability selected in the table has changed */
	private void showSelectedArtifact() {
		Artifact artToShow = getSelectedArtifact();
		if (artifactShowing != artToShow) {
			removeArtifactPane();
			artifactShowing = artToShow;
			if (artToShow != null) {
				AbstractCompositeFactory uiShowing = DeployCoreUIPlugin.getDefault()
						.getCompositeFactoryService().findDmoUIHandlerForDmo(artToShow);
				compositeShowing = uiShowing
						.createControls(propsWrapper, artToShow, getWidgetFactory());
				compositeShowing.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
				propsWrapper.setContent(compositeShowing);
				Rectangle r = propsWrapper.getClientArea();
				propsWrapper.setMinSize(compositeShowing.computeSize(r.width, SWT.DEFAULT));

				compositeShowing.aboutToBeShown();

//				artifactLabelShowing = artifactLabelProvider.getText(artifactShowing);
//				artifactImageShowing = artifactLabelProvider.getImage(artifactShowing);
			}

		} else if (artToShow == null) {
			// This happens when the list is empty.  We still need something, otherwise there may be
			// layout issues, and also a big grey rectangle.
			Label l = new Label(propsWrapper, SWT.NONE);
			l.setBackground(getPart().getSite().getShell().getDisplay()
					.getSystemColor(SWT.COLOR_WHITE));
			propsWrapper.setContent(l);
		}

		enableDisableButtons();
	}

	private void removeArtifactPane() {

		if (compositeShowing != null) {
			compositeShowing.aboutToBeHidden();
		}

		List<Control> l = Arrays.asList(propsWrapper.getChildren());
		for (Iterator<Control> iter = l.iterator(); iter.hasNext();) {
			Control control = iter.next();
			control.dispose();
		}
	}

	/** Implementation of ISection.refresh(), refreshes embedded property sheet */
	public void refresh() {
		if (!treeViewer.getControl().isDisposed()) {
			treeViewer.refresh();
			showSelectedArtifact();
		}
	}

	@Override
	protected void addMenuActions(IMenuManager menu) {
		menu.add(createArtifactAction);
		menu.add(removeArtifactAction);
		menu.add(editAttributeAction);
	}

	@Override
	protected void addToolBarActions(IToolBarManager toolbar) {
		// add creation actions
		toolbar.add(createArtifactAction);
		toolbar.add(removeArtifactAction);
		toolbar.add(editAttributeAction);
	}

	public void doAboutToBeShown() {

		if (compositeShowing != null) {
			compositeShowing.aboutToBeShown();
		}
	}

	public void doAboutToBeHidden() {

		if (compositeShowing != null) {
			compositeShowing.aboutToBeHidden();
			compositeShowing = null;
		}
	}

	@Override
	protected boolean shouldProcessEvent(IWorkbenchWindow window, Notification notification) {
		return true;
	}

	private Artifact getSelectedArtifact() {
		ISelection sel = treeViewer.getSelection();
		if (sel instanceof StructuredSelection) {
			StructuredSelection ss = (StructuredSelection) sel;
			if (ss.getFirstElement() instanceof Artifact) {
				return (Artifact) ss.getFirstElement();
			}
		}

		return null;
	}

	private void enableDisableButtons() {
		Artifact artifact = getSelectedArtifact();
		createArtifactAction.setEnabled(mutable);
		removeArtifactAction.setEnabled(artifact != null && mutable
		/* && !PropertyUtils.isProxy(artifact) */);
		editAttributeAction.setEnabled(artifact != null && mutable);

		actionBars.getToolBarManager().update(true);
	}

	protected void editAttributes() {
		Artifact artifact = getSelectedArtifact();
		CustomizeArtifactAttributesDialog ead = new CustomizeArtifactAttributesDialog(getPart()
				.getSite().getShell(), artifact, false);
		if (ead.open() == Window.OK) {
			removeArtifactPane();
			artifactShowing = null;
			showSelectedArtifact();
		}
	}

	private class CustomizeArtifactAttributesDialog extends CustomizeAttributesDialog {
		private CustomizeArtifactAttributesDialog(Shell parentShell, DeployModelObject dmo) {
			super(parentShell, dmo, true);
		}

		private CustomizeArtifactAttributesDialog(Shell parentShell, DeployModelObject dmo,
				boolean showContractSettings) {
			super(parentShell, dmo, showContractSettings);
		}

		protected Control createDialogArea(Composite parent) {
			PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
					IDeployHelpContextIds.CUSTOMIZE_ARTIFACT_ATTRIBUTES);
			return super.createDialogArea(parent);
		}

	}

	protected void setArtifactUri() {
		Artifact selectedArtifact = getSelectedArtifact();
		if (selectedArtifact instanceof FileArtifact) {
			FileArtifact fa = (FileArtifact) selectedArtifact;

			FileDialog fsd = new FileDialog(getPart().getSite().getShell(), SWT.MULTI);

			if (fa.getFileURIs().size() > 0) {
				String initial = uriToFname((String) fa.getFileURIs().get(0));
				fsd.setFileName(initial);
			}

			String fname = fsd.open();

			// Did user click 'OK'?
			if (fname != null) {

				// Remove all old URIs
				CompoundCommand cc = new CompoundCommand();
				TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(unit);
				for (Iterator<String> it = fa.getFileURIs().iterator(); it.hasNext();) {
					String uri = it.next();
					RemoveCommand rc = new RemoveCommand(domain, (EList<String>) fa.getFileURIs(), uri);
					cc.append(rc);
				}

				String[] names = fsd.getFileNames();
				if (fsd.getFilterPath() != null) {
					for (int i = 0; i < names.length; i++) {
						names[i] = fsd.getFilterPath() + File.separator + names[i];
					}
				}

				for (int i = 0; i < names.length; i++) {
					String uri = fnameToUri(names[i]);
					AddCommand ac = new AddCommand(domain, (EList) fa.getFileURIs(), uri);
					cc.append(ac);
				}

				PropertyUtils.executeWithUndo(unit, cc);
			} // end if user clicked 'OK'
		} // end if FileArtifact is selected
	}

	private String uriToFname(String uri) {
		return uri;
	}

	private String fnameToUri(String fname) {
		return fname;
	}

	protected void delArtifact() {
		final Artifact selectedArtifact = getSelectedArtifact();

		// It isn't safe to use the EMF.Edit command pattern, because unit.getArtifacts()
		// isn't an EList if it is imported.

		String msg = Messages.ModulePropertySection_Remove_Artifac_;
		PropertyUtils.executeWithUndo(unit, msg, new Runnable() {
			public void run() {
				unit.getArtifacts().remove(selectedArtifact);
			}
		});

		// No artifact is selected; disable button until one is 
		removeArtifactAction.setEnabled(false);
	}

	private class ArtifactListMouseListener implements MouseListener {

		public void mouseDoubleClick(MouseEvent e) {
			// do nothing
		}

		public void mouseDown(MouseEvent e) {
			// do nothing
		}

		public void mouseUp(MouseEvent e) {
			Object data = getTreeItemData(e.widget, e.x, e.y);
			if (data instanceof DeployModelObject) {
				if (iconClicked(e)) {
					popupResolutions((DeployModelObject) data);
				}
			}
		}

		private Object getTreeItemData(Widget widget, int x, int y) {
			if (widget instanceof Tree) {
				Tree tree = (Tree) widget;
				TreeItem item = tree.getItem(new Point(x, y));
				if (item != null) {
					return item.getData();
				}
			}

			return null;
		}

		// See Northover & Wilson, _SWT_, section 9.2.27 page 243
		private boolean iconClicked(MouseEvent e) {
			Tree tree = (Tree) e.widget;
			TreeItem item = tree.getItem(new Point(e.x, e.y));
//			System.out.println(item.getBounds());

			// If there is no item, the icon was not clicked
			if (item == null) {
				return false;
			}

//			Rectangle bounds = item.getBounds(1);
//			TreeColumn col1 = tree.getColumn(1);

			// Get the 'Value' column bounds
			// The rectangle seems to be for the text area, not the icon,
			// so check if the click has a negative offset from the bounds.
			int xRel = e.x - item.getBounds(0).x;
			return 0 < xRel && xRel <= 16;
		}

		private void popupResolutions(DeployModelObject selectedDMO) {
			IMarker[] markers = SoaDeployUiUtil.getMarkers(selectedDMO).toArray(new IMarker[0]);
			if (markers.length > 0 || !selectedDMO.getStatus().isOK()) {
				MarkerResolutionHelper mrh = new MarkerResolutionHelper(markers);
				QuickFixDialog popup = new QuickFixDialog(selectedDMO.getTopology(), mrh, selectedDMO
						.getStatus(), PlatformUI.getWorkbench().getDisplay().getCursorLocation(), true);
				popup.open();
			}
		}
	} // end static inner class ArtifactListMouseListener

	public Shell getShell() {
		return getPart().getSite().getShell();
	}

} // end class ModulePropertySection

