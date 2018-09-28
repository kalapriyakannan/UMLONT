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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.DefaultToolTip;
import org.eclipse.jface.window.ToolTip;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.part.ISetSelectionTarget;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.core.Reference;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Service;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedFonts;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.CapabilitiesPopupDialog;
import com.ibm.ccl.soa.deploy.core.ui.internal.SoaDeployUiUtil;
import com.ibm.ccl.soa.deploy.core.ui.marker.quickfix.MarkerResolutionHelper;
import com.ibm.ccl.soa.deploy.core.ui.marker.quickfix.QuickFixDialog;
import com.ibm.ccl.soa.deploy.core.ui.properties.CapabilitiesPropertySection2;
import com.ibm.ccl.soa.deploy.core.ui.properties.Messages;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.saf.exception.InvalidOperationException;
import com.ibm.ccl.soa.deploy.saf.exception.SAFException;
import com.ibm.ccl.soa.deploy.saf.extension.IInterfaceHandlerService;
import com.ibm.ccl.soa.deploy.saf.handler.AbstractInterfaceHandler;
import com.ibm.ccl.soa.deploy.saf.ui.handler.AbstractUIHandler;
import com.ibm.ccl.soa.infrastructure.internal.emf.DynamicAdapterFactory;

/**
 * A tree of {@link Capability}s and {@link Interface}s, used by {@link CapabilitiesPopupDialog}
 * and {@link CapabilitiesPropertySection2}.
 * 
 * @author Ed Snible (based on daberg RequirementsListComposite)
 */
public class CapabilitiesListComposite extends Composite implements ISetSelectionTarget {

	private static final int CAP_COL_MIN_WIDTH = 200;

	private final class CapabilityAdapter extends AdapterImpl {
		private final List<Notifier> targets = new ArrayList<Notifier>();

		@Override
		public void setTarget(Notifier newTarget) {
			if (newTarget != null) {
				targets.add(newTarget);
			}
		}

		@Override
		public void notifyChanged(Notification msg) {
			Object feature = msg.getFeature();
			//Status has changed.
			if (CorePackage.Literals.DEPLOY_MODEL_OBJECT__STATUS == feature
//					|| CorePackage.Literals.REQUIREMENT__LINK == feature
					|| CorePackage.Literals.DEPLOY_MODEL_OBJECT__DISPLAY_NAME == feature
//					|| CorePackage.Literals.REFERENCE__INTERFACE_GROUP == feature
					|| CorePackage.Literals.DEPLOY_MODEL_OBJECT__VISIBILITY == feature) {
				refresh(msg.getNotifier());
//			} else if (CorePackage.Literals.REQUIREMENT__LINK_TYPE == feature) {
//				refreshTree();
			}
		}

		private void refresh(final Object element) {
			if (treeViewer != null && !treeViewer.getTree().isDisposed()) {
				if (Display.getCurrent() != null) {
					if (treeViewer != null && !treeViewer.getTree().isDisposed()) {
						treeViewer.refresh();
					}
				} else {
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							if (treeViewer != null && !treeViewer.getTree().isDisposed()) {
								treeViewer.refresh(element);
							}
						}
					});
				}
			}
		}

		protected void adapt(List<Capability> reqs) {
			for (Capability req : reqs) {
				req.getEObject().eAdapters().add(this);
			}
		}

		protected void adapt(Capability req) {
			if (req != null) {
				req.getEObject().eAdapters().add(this);
			}
		}

		protected void removeTargets() {
			for (Notifier notifier : targets) {
				notifier.eAdapters().remove(this);
			}
			targets.clear();
		}
	}

	// Define column indexes.
	/**
	 * Numerical position of the Capability/Interface name column
	 */
	public static final int CAP_COLUMN = 0;
	/**
	 * Numerical position of the export visibility column
	 */
	public static final int VISIBILITY_COLUMN = 1;

	private Tree capsTree = null;
	private TreeViewer treeViewer = null;
	private Unit unit;
	private TreeColumn capColumn;
//	private TreeColumn linkTargetColumn;
	private TreeColumn visibilityColumn;
	private ToolTip toolTip;
	private Adapter unitAdapter;
	private CapabilityAdapter capAdapter;
	private boolean unitIsImported = false;
	private Composite treeHeaderComposite;

//	private boolean shouldResizeShell = true;

	/**
	 * @param parent
	 * @param aUnit
	 *           The {@link Unit} so show all requirements in this composite.
	 * @param isUnitImported
	 */
	public CapabilitiesListComposite(Composite parent, Unit aUnit, boolean isUnitImported /*
																														 * ,
																														 * boolean
																														 * showHeaders,
																														 * boolean
																														 * showLinkColumns
																														 */) {
		super(parent, SWT.NONE);
		unitIsImported = isUnitImported;
		initialize(/* showLinkColumns, */isUnitImported);
		setInput(aUnit, isUnitImported /* , showLinkColumns */);
		showHeaders(/* showHeaders */false);
	}

	/**
	 * @param parent
	 * @param style
	 */
	public CapabilitiesListComposite(Composite parent, int style /*
																						 * , boolean showHeaders, boolean
																						 * showLinkColumns
																						 */) {
		super(parent, style);
		initialize(/* showLinkColumns, */false);
		showHeaders(/* showHeaders */false);
	}

	private ToolTip getToolTip() {
		if (toolTip == null) {
			//toolTip = new ToolTip(requirementsTree.getShell(), SWT.CAP_ROUND);
			toolTip = new DefaultToolTip(capsTree, ToolTip.NO_RECREATE, false);
			toolTip.setHideDelay(0);
			toolTip.setPopupDelay(10);
			toolTip.setHideOnMouseDown(true);
		}
		return toolTip;
	}

	/**
	 * This method initializes this
	 * 
	 * @param isUnitImported
	 * 
	 */
	private void initialize(/* boolean showLinks, */boolean isUnitImported) {
		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.verticalSpacing = 0;
		this.setLayout(layout);
		this.setBackgroundMode(SWT.INHERIT_DEFAULT);

		createTitleBar();
		capsTree = new Tree(this, SWT.MULTI | SWT.FULL_SELECTION);
		capsTree.setHeaderVisible(true);
		capsTree.setLinesVisible(true);
		capsTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		capColumn = new TreeColumn(capsTree, SWT.NONE);
		//capColumn.setWidth(200);
		capColumn.setResizable(true);
		//capColumn.setText("Capabilities"); //$NON-NLS-1$
		// Create Visibility Column
		visibilityColumn = new TreeColumn(capsTree, SWT.NONE);
		visibilityColumn.setResizable(false);
		visibilityColumn.setText("V"); //$NON-NLS-1$
		visibilityColumn.pack();
//		if (showLinks) {
//			createLinkColumns();
//		}
		treeViewer = new TreeViewer(capsTree);

		setProviders(isUnitImported);
		setListeners();
	}

	private void createTitleBar() {
		treeHeaderComposite = new Composite(this, SWT.NONE);
		GridLayout gl = new GridLayout(1, false);
		gl.marginWidth = 5;
		gl.marginHeight = 5;
		treeHeaderComposite.setLayout(gl);
		treeHeaderComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		//Add Label
		Label label = new Label(treeHeaderComposite, SWT.NONE);
		label.setText(Messages.UnitFlyOutPropertiesToggler_Capabilities);
		label.setFont(DeployCoreUIPlugin.getDefault().getSharedFonts().getFont(
				ISharedFonts.FIG_CATEGORY));
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		treeHeaderComposite.setBackground(getDisplay().getSystemColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
	}

	/**
	 * @param aUnit
	 * @param unitIsImported
	 */
	public void setInput(Unit aUnit, boolean unitIsImported /* , boolean showLinks */) {
		if (unit != aUnit) {
			removeInputListeners(unit);
			unit = aUnit;
			addInputListeners(aUnit);

			getTreeLabelProvider().setIsUnitImported(unitIsImported);

			treeViewer.setInput(unit);
			capColumn.pack();
			resizeTree(CAP_COL_MIN_WIDTH);
		}
	}

	private void addInputListeners(Unit aUnit) {
		if (aUnit != null) {
			addUnitListener(aUnit);
			addCapabilitiesListener(aUnit);
		}
	}

	private void addCapabilitiesListener(Unit aUnit) {
		List<Capability> caps = aUnit.getCapabilities();
		if (capAdapter == null) {
			capAdapter = new CapabilityAdapter();
		}
		capAdapter.adapt(caps);
	}

	private void addUnitListener(Unit aUnit) {
		if (unitAdapter == null) {
			unitAdapter = new Adapter() {
				public void setTarget(Notifier newTarget) {
				}

				public void notifyChanged(Notification notification) {
					switch (notification.getEventType())
					{
					case Notification.ADD:
						if (CorePackage.Literals.UNIT__CAPABILITY_GROUP == notification.getFeature()) {
							FeatureMap.Entry map = (FeatureMap.Entry) notification.getNewValue();
							capAdapter.adapt((Capability) map.getValue());
						}
						refreshTree();
						break;
					case Notification.ADD_MANY:
						if (CorePackage.Literals.UNIT__CAPABILITY_GROUP == notification.getFeature()) {
							List<FeatureMap.Entry> entries = (List<FeatureMap.Entry>) notification
									.getNewValue();
							for (Entry entry : entries) {
								capAdapter.adapt((Capability) entry.getValue());
							}
						}
						refreshTree();
						break;
					case Notification.REMOVE:
						if (CorePackage.Literals.UNIT__CAPABILITY_GROUP == notification.getFeature()) {
							FeatureMap.Entry map = (FeatureMap.Entry) notification.getOldValue();
							((Capability) map.getValue()).getEObject().eAdapters().remove(capAdapter);
						}
						refreshTree();
						break;
					case Notification.REMOVE_MANY:
						if (CorePackage.Literals.UNIT__CAPABILITY_GROUP == notification.getFeature()) {
							List<FeatureMap.Entry> entries = (List<FeatureMap.Entry>) notification
									.getNewValue();
							for (Entry entry : entries) {
								Capability req = (Capability) entry.getValue();
								req.getEObject().eAdapters().remove(capAdapter);
							}
						}
						refreshTree();
						break;
					}
				}

				public boolean isAdapterForType(Object type) {
					return false;
				}

				public Notifier getTarget() {
					return null;
				}

			};
		}
		aUnit.getEObject().eAdapters().add(unitAdapter);
	}

	private void removeInputListeners(Unit aUnit) {
		if (aUnit != null) {
			if (unitAdapter != null) {
				aUnit.getEObject().eAdapters().remove(unitAdapter);
			}
			if (capAdapter != null) {
				capAdapter.removeTargets();
			}
		}
	}

	private void setListeners() {
		Listener treeListener = new Listener() {
			public void handleEvent(Event event) {
				if (capsTree.isDisposed()) {
					return;
				}

				TreeItem row = capsTree.getItem(new Point(event.x, event.y));
				if (row != null) {
					switch (event.type)
					{
					case SWT.MouseHover:
						if (overIconArea(row, 0, event.x)) {
							showCapabilityToolTip(capsTree, row.getData(), event);
						} else if (overTextArea(row, 0, event.x)) {
							if (row.getData() instanceof UnsetInterface) {
								showToolTip(capsTree,
										Messages.RequirementsListComposite_Double_click_to_set_interface_,
										event);
							} else if (row.getData() instanceof Interface) {
								showToolTip(capsTree,
										Messages.RequirementsListComposite_Double_click_to_open_interface_,
										event);
							}
						} else if (overTextArea(row, VISIBILITY_COLUMN, event.x)) {
							showVisibilityToolTip(capsTree, row.getData(), event);
						}
						break;
					case SWT.KeyDown:
						if (event.character == SWT.CR && capsTree.getSelectionCount() == 1) {
							row = capsTree.getSelection()[0];
							handleRowActivation(row);
						}
					}
				}
			}
		};
		capsTree.addListener(SWT.MouseHover, treeListener);
		capsTree.addListener(SWT.KeyDown, treeListener);
		capsTree.addListener(SWT.Selection, treeListener);

		capsTree.addMouseListener(new MouseListener() {
			public void mouseUp(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {
				TreeItem row = capsTree.getItem(new Point(e.x, e.y));
				if (overIconArea(row, 0, e.x)) {
					Point point = capsTree.toDisplay(e.x, e.y);
					showResolutions(row.getData(), point);
				}
			}

			public void mouseDoubleClick(MouseEvent e) {
				TreeItem row = capsTree.getItem(new Point(e.x, e.y));
				handleRowActivation(row);
			}
		});

		getShell().addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				dispose();
			}
		});

		capsTree.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				resizeTree(CAP_COL_MIN_WIDTH);
			}
		});
	}

	/**
	 * Resize the tree based on the size of the shell.
	 * 
	 * @param minSize
	 */
	public void resizeTree(int minSize) {
		int w = capsTree.getBounds().width;
		// We hard-code the width of the visibility rather than
		// using the pack()ed with because on Linux there seems
		// to be a default to proportionally grow columns that
		// caused visibility to incorrectly grow.
		w -= 24; //visibilityColumn.getWidth();
		//Adjust for the vertical scroll bar.
		if (capsTree.getVerticalBar().isVisible()) {
			w -= capsTree.getVerticalBar().getSize().x;
		}
		int size = minSize > 0 ? minSize : CAP_COL_MIN_WIDTH;
		if (w < size) {
			w = size;
		}
		capColumn.setWidth(w);
	}

	private void showResolutions(Object data, Point point) {
		if (data instanceof DeployModelObject) {
			DeployModelObject dmo = (DeployModelObject) data;
			List<IMarker> listOfMarkers = SoaDeployUiUtil.getMarkers(dmo);
			IStatus status = dmo.getStatus();
			if (!listOfMarkers.isEmpty() || !status.isOK()) {
				IMarker[] markers = new IMarker[listOfMarkers.size()];
				listOfMarkers.toArray(markers);
				MarkerResolutionHelper mrh = new MarkerResolutionHelper(markers);
				QuickFixDialog popup = new QuickFixDialog(getShell(), dmo.getTopology(), mrh, status,
						point, true);
				popup.open();
			}
		}
	}

	protected void handleRowActivation(TreeItem row) {
		//Nothing to do if the row is null.
		if (row == null) {
			return;
		}
		Object data = row.getData();
		if (data instanceof UnsetInterface) {
			//Set an interface.
			setInterface(row, (UnsetInterface) row.getData());
		} else if (data instanceof Interface) {
			// Open the selected interface.
			Interface interfaze = (Interface) data;
			AbstractUIHandler uihandler = DeployCoreUIPlugin.getDefault()
					.getInterfaceUIHandlerService().findUIHandlerForSubstitutable(interfaze);
			if (uihandler != null) {
				try {
					uihandler.open(interfaze);
				} catch (SAFException e) {
					DeployCoreUIPlugin.logError(0, e.getMessage(), e);
				} catch (InvalidOperationException e) {
					DeployCoreUIPlugin.logError(0, e.getMessage(), e);
				}
			}
		}
	}

	private void showCapabilityToolTip(Control control, Object data, Event e) {
		String tipText = null;
		if (data != null) {
			if (data instanceof Capability) {
				tipText = getTipText((Capability) data);
			}
		}

		showToolTip(control, tipText, e);
	}

//	private boolean isHosting(Requirement requirement) {
//		return requirement.getLinkType() == RequirementLinkTypes.HOSTING_LITERAL;
//	}

	private void showToolTip(Control control, String tipText, Event e) {
		if (tipText != null) {
			Point ptAbs = control.toDisplay(new Point(e.x, e.y));
			DefaultToolTip tip = (DefaultToolTip) getToolTip();
			tip.setText(tipText);
			tip.show(new Point(ptAbs.x + 15, ptAbs.y + 10));

		} else {
			getToolTip().hide();
		}
	}

	private String getTipText(Capability cap) {

		if (cap.getStatus().isOK()) {
			return null;
		}

		return SoaDeployUiUtil.getStatusMessage(cap.getStatus());
	}

	// See Northover & Wilson, _SWT_, section 9.2.27 page 243
	private boolean overIconArea(TreeItem item, int column, int x) {
		// Get the 'Value' column bounds
		// The rectangle seems to be for the text area, not the icon,
		// so check if the click has a negative offset from the bounds.
		if (item == null) {
			return false;
		}
		int xRel = x - item.getBounds(column).x;
		return 0 < xRel && xRel <= 16;
	}

	/*
	 * Is the current position over the text area of the current tree column?
	 */
	private boolean overTextArea(TreeItem item, int column, int x) {
		Rectangle bounds = item.getBounds(column);
		return x >= bounds.x && x <= bounds.x + bounds.width;
	}

	private void setProviders(boolean isUnitImported) {
		// Set content provider
		treeViewer.setContentProvider(new CapabilityTreeProvider(new DynamicAdapterFactory(null)));
		// Set label provider
		treeViewer.setLabelProvider(new CapabilitiesPropertiesLabelProvider(isUnitImported));
	}

	protected void setInterface(TreeItem item, UnsetInterface element) {
		if (unitIsImported && !element.getParent().isPublicEditable()) {
			// Cannot edit.
			return;
		}
		Interface interfaceToEdit = null;

		AbstractUIHandler uihandler = null;
		AbstractInterfaceHandler handler = null;

		EClass serviceType = null;
		if (element instanceof Requirement) {
			serviceType = ((Requirement) element.getParent()).getDmoEType();
		} else {
			serviceType = element.getParent().eClass();
		}

		if (serviceType != null) {
			IInterfaceHandlerService handlerService = DeployCoreUIPlugin.getDefault()
					.getInterfaceHandlerService();
			AbstractInterfaceHandler[] handlers = handlerService
					.findInterfaceHandlersForService(serviceType);

			if (handlers.length > 0) {
				try {
					interfaceToEdit = handlers[0].createInterfaceFor(serviceType);
				} catch (Exception e) {
					DeployCoreUIPlugin.logError(0,
							"Failed to create interface for service type " + serviceType.getName(), e); //$NON-NLS-1$
				}
			}
		}

		if (interfaceToEdit != null) {
			uihandler = DeployCoreUIPlugin.getDefault().getInterfaceUIHandlerService()
					.findUIHandlerForSubstitutable(interfaceToEdit);
			if (uihandler != null) {
				try {
					boolean result = uihandler.editSubstitutable(getShell(), element.getParent(),
							interfaceToEdit, false);
					if (result == false) {
						return;
					}
					if (handler == null) {
						handler = DeployCoreUIPlugin.getDefault().getInterfaceHandlerService()
								.findInterfaceHandlerForInterface(interfaceToEdit);
					}
					String text = handler.getInterfacePropertyLabel(interfaceToEdit);
					// workitem 886
					if (text != null && item != null && !item.isDisposed()) {
						item.setText(handler.getInterfacePropertyLabel(interfaceToEdit));
						if (element.getParent() instanceof Reference) {
							setInterfaceObjectOnReference((Reference) element.getParent(), interfaceToEdit);
						} else {
							setInterfaceObjectOnService((Service) element.getParent(), interfaceToEdit);
						}
						item.setData(interfaceToEdit);
						item.setForeground(0, null);
					}
				} catch (SAFException e) {
				}
			}
		}
	}

	/*
	 * Operate in a command.
	 */
	private void setInterfaceObjectOnReference(final Reference aReference,
			final Interface interfaceToEdit) {
		AbstractTransactionalCommand editCmd = new AbstractTransactionalCommand(TransactionUtil
				.getEditingDomain(aReference), Messages.RequirementsListComposite2_Set_interface_, null) {
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
				// Set the interface on the dmo.
				aReference.setInterface(interfaceToEdit);
				return CommandResult.newOKCommandResult();
			}
		};
		try {
			editCmd.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
		}
	}

	/*
	 * Operate in a command.
	 */
	private void setInterfaceObjectOnService(final Service service, final Interface interfaceToEdit) {
		// the label is wrong because this was copied from setInterface..OnReference() 
		// must defer correction until post CCL 2.0
		AbstractTransactionalCommand editCmd = new AbstractTransactionalCommand(TransactionUtil
				.getEditingDomain(service), Messages.RequirementsListComposite2_Set_interface_, null) {
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {
				// Set the interface on the dmo.
				service.setInterface(interfaceToEdit);
				return CommandResult.newOKCommandResult();
			}
		};
		try {
			editCmd.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
		}
	}

	/**
	 * Refresh the tree viewer.
	 */
	public void refresh() {
		if (!isDisposed()) {
			refreshTree();
		}
	}

	/**
	 * Force selection of the first element in the tree.
	 * 
	 * @return the Object that is selected in the tree.
	 */
	public Object selectFirst() {
		Object result = null;
		// Select the first Unit in the tree
		TreeItem rootItems[] = capsTree.getItems();
		if (rootItems.length > 0) {
			result = rootItems[0].getData();
			treeViewer.setSelection(new StructuredSelection(result), true);
		}
		return result;
	}

	/**
	 * Add a {@link ViewerFilter} to the contained {@link TreeViewer}.
	 * 
	 * @param filter
	 */
	public void addFilter(ViewerFilter filter) {
		if (filter != null) {
			treeViewer.addFilter(filter);
		}
	}

	/**
	 * Ensure all items in the {@link TreeViewer} are expanded.
	 */
	public void expandTree() {
		if (treeViewer != null) {
			treeViewer.expandAll();
		}
	}

	/**
	 * Programmatically show or hide the headers.
	 * 
	 * @param aBoolean
	 */
	public void showHeaders(boolean aBoolean) {
		capsTree.setHeaderVisible(aBoolean);
	}

	/**
	 * Update the tree items that are passed.
	 * 
	 * @param elements
	 *           The items shown in the tree that need to be updated.
	 */
	public void updateTree(Object[] elements) {
		treeViewer.update(elements, null);
	}

	/**
	 * Listen to events on the contained tree.
	 * 
	 * @param eventType
	 *           The {@link SWT} event type.
	 * @param listener
	 *           A {@link Listener} to handle the events.
	 */
	public void addTreeListener(int eventType, Listener listener) {
		if (listener != null && capsTree != null) {
			capsTree.addListener(eventType, listener);
		}
	}

	/**
	 * @param aListener
	 */
	public void addSelectionChangedListener(ISelectionChangedListener aListener) {
		if (aListener != null && treeViewer != null) {
			treeViewer.addSelectionChangedListener(aListener);
		}
	}

	/**
	 * @param aListener
	 */
	public void removeSelectionListener(ISelectionChangedListener aListener) {
		if (aListener != null && treeViewer != null) {
			treeViewer.removeSelectionChangedListener(aListener);
		}
	}

	/**
	 * Remove the listener for the event type on the contained tree.
	 * 
	 * @param eventType
	 *           The {@link SWT} event type.
	 * @param listener
	 *           A {@link Listener} to handle the events.
	 */
	public void removeTreeListener(int eventType, Listener listener) {
		if (listener != null && capsTree != null) {
			capsTree.removeListener(eventType, listener);
		}
	}

	private CapabilitiesPropertiesLabelProvider getTreeLabelProvider() {
		return (CapabilitiesPropertiesLabelProvider) (treeViewer != null ? treeViewer
				.getLabelProvider() : null);
	}

	@Override
	public void dispose() {
		if (!isDisposed()) {
			if (toolTip != null && capsTree != null && !capsTree.isDisposed()) {
				toolTip.deactivate();
				toolTip = null;
			}
			removeInputListeners(unit);
			unit = null;
			unitAdapter = null;
			capAdapter = null;
			super.dispose();
		}
	}

	private void showVisibilityToolTip(Control control, Object data, Event e) {
		String tipText = null;
		if (data != null && data instanceof Capability) {
			Capability cap = (Capability) data;
			if (unitIsImported) {
				//There are only two options if the parent Unit is imported.
				if (cap.isPublicEditable()) {
					tipText = Messages.RequirementsPopupDialog_Public_Editabl_;
				} else if (cap.isPublic()) {
					tipText = Messages.RequirementsPopupDialog_Publi_;
				} else {
					tipText = Messages.RequirementsPopupDialog_Privat_;
				}
			} else {
				Topology top = cap.getEditTopology();
				if (top != null) {
					ConfigurationContract contract = top.getConfigurationContract();
					if (contract != null) {
						if (contract.isPublicEditable(cap)) {
							tipText = Messages.RequirementsPopupDialog_Public_Editabl_;
						} else if (contract.isPublic(cap)) {
							tipText = Messages.RequirementsPopupDialog_Publi_;
						} else {
							tipText = Messages.RequirementsPopupDialog_Privat_;
						}
					}
				}
			}
			showToolTip(control, tipText, e);
		}
	}

	/**
	 * Select the passed {@link Requirement} in the {@link Tree}.
	 * 
	 * @param req
	 *           A {@link Requirement} displayed in the tree.
	 */
	public void setSelection(Capability req) {
		if (req != null && treeViewer != null) {
			treeViewer.setSelection(new StructuredSelection(req), true);
		}
	}

//	protected void setShouldResizeShell(boolean aBoolean) {
//		shouldResizeShell = aBoolean;
//	}

	private void refreshTree() {
		if (Display.getCurrent() != null) {
			if (treeViewer != null && !treeViewer.getTree().isDisposed()) {
				treeViewer.refresh();
			}
		} else {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					if (treeViewer != null && !treeViewer.getTree().isDisposed()) {
						treeViewer.refresh();
					}
				}
			});
		}
	}

	/**
	 * @return
	 */
	public TreeViewer getTreeViewer() {
		return treeViewer;
	}

	private class CapabilityTreeProvider extends AdapterFactoryContentProvider {
		private final Class<?> ITreeItemContentProviderClass = ITreeItemContentProvider.class;

		private CapabilityTreeProvider(AdapterFactory af) {
			super(af);

		}

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof Unit) {
				Unit unit = (Unit) inputElement;
				//				return unit.getCapabilities().toArray();
				return UnitUtil.getPublicCapabilities(unit).toArray();
			}
			if (inputElement instanceof Service) {
				Service service = (Service) inputElement;
				Interface interfaceObj = service.getInterface();
				if (interfaceObj == null) {
					UnsetInterface unsetInterface = new UnsetInterface(service);
					unsetInterface.setReference(false);
					return new Object[] { unsetInterface };
				}
				return new Object[] { interfaceObj };

			}

			return new Object[0];
		}

		public void dispose() {
			// do nothing
		}

		public void notifyChanged(Notification notification) {
			if (CorePackage.Literals.SERVICE__INTERFACE_GROUP == notification.getFeature()) {
				if (treeViewer != null && !treeViewer.getTree().isDisposed()) {
					treeViewer.refresh(notification.getNotifier());
				}
			}
		}

		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}

		public Object[] getChildren(Object parentElement) {
			adapterFactory.adapt(parentElement, ITreeItemContentProviderClass);
			return getElements(parentElement);
		}

		public Object getParent(Object element) {
			// TODO Auto-generated method stub
			return null;
		}

		public boolean hasChildren(Object element) {
			return element instanceof Service;

		}
	} // end private static inner class CapabilityTreeProvider

	public void selectReveal(ISelection selection) {
		if (selection instanceof StructuredSelection) {
			StructuredSelection ss = (StructuredSelection) selection;
			if (ss.getFirstElement() instanceof Capability) {
				setSelection((Capability) ss.getFirstElement());
			}
		}
	}

	/**
	 * Add to the list of exclusions for setting background colors.
	 * 
	 * @param aList
	 */
	public void addBackgroundExclusions(List<Control> aList) {
		aList.add(treeHeaderComposite);
		aList.add(treeHeaderComposite.getChildren()[0]);
	}
}
