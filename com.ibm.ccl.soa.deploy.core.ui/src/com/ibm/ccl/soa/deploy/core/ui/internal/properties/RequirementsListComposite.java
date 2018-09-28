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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.DefaultToolTip;
import org.eclipse.jface.window.ToolTip;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
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
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.core.Reference;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.datamodels.LinkDiscoveryDataModel;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedFonts;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.internal.SoaDeployUiUtil;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.RequirementLinkChangeManager.RequirementLinkChangeHandler;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.RequirementsPropertiesContentProvider.RequirementGroup;
import com.ibm.ccl.soa.deploy.core.ui.marker.quickfix.MarkerResolutionHelper;
import com.ibm.ccl.soa.deploy.core.ui.marker.quickfix.QuickFixDialog;
import com.ibm.ccl.soa.deploy.core.ui.properties.Messages;
import com.ibm.ccl.soa.deploy.core.ui.properties.NewLinkWizard;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.saf.exception.InvalidOperationException;
import com.ibm.ccl.soa.deploy.saf.exception.SAFException;
import com.ibm.ccl.soa.deploy.saf.extension.IInterfaceHandlerService;
import com.ibm.ccl.soa.deploy.saf.handler.AbstractInterfaceHandler;
import com.ibm.ccl.soa.deploy.saf.ui.handler.AbstractUIHandler;

/**
 * @author daberg
 * 
 */
public class RequirementsListComposite extends Composite implements RequirementLinkChangeHandler,
		IResolutionListener {

	private static final int REQ_COL_MIN_WIDTH = 200;

	private final class RequirementAdapter extends AdapterImpl {
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
					|| CorePackage.Literals.REQUIREMENT__LINK == feature
					|| CorePackage.Literals.DEPLOY_MODEL_OBJECT__DISPLAY_NAME == feature
					|| CorePackage.Literals.REFERENCE__INTERFACE_GROUP == feature
					|| CorePackage.Literals.DEPLOY_MODEL_OBJECT__VISIBILITY == feature) {
				refresh(msg.getNotifier());
			} else if (CorePackage.Literals.REQUIREMENT__LINK_TYPE == feature) {
				if (RequirementLinkTypes.MEMBER_LITERAL == msg.getNewValue()) {
					//Expand the member group and select the requirement.
					isPreservingTreeSelection = true;
					try {
						refreshTree();
						RequirementGroup memberGroup = getMemberGroup();
						if (memberGroup != null) {
							treeViewer.expandToLevel(memberGroup, 1);
							treeViewer.setSelection(new StructuredSelection(msg.getNotifier()), true);
						}
					} finally {
						isPreservingTreeSelection = false;
					}
				}
			}
		}

		private RequirementGroup getMemberGroup() {
			TreeItem[] items = treeViewer.getTree().getItems();
			for (int i = 0; i < items.length; i++) {
				Object data = items[i].getData();
				if (data instanceof RequirementGroup && ((RequirementGroup) data).isMember()) {
					return (RequirementGroup) data;
				}
			}
			return null;
		}

		private void refresh(final Object element) {
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

		protected void adapt(List<Requirement> reqs) {
			for (Requirement req : reqs) {
				req.getEObject().eAdapters().add(this);
			}
		}

		protected void adapt(Requirement req) {
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
	public static final int REQ_COLUMN = 0;
	public static final int VISIBILITY_COLUMN = 1;
	public static final int TARGET_COLUMN = 2;

	private Tree requirementsTree = null;
	private TreeViewer treeViewer = null;
	private Unit unit;
	private TreeColumn requirementColumn;
	private TreeColumn linkTargetColumn;
	private TreeColumn visibilityColumn;
	private ToolTip toolTip;
	private Adapter unitAdapter;
	private RequirementAdapter requirementAdapter;
	private boolean unitIsImported = false;
	private boolean shouldResizeShell = true;
	private boolean isPreservingTreeSelection;
	private QuickFixDialog quickfixPopup;
	private Composite listHeaderComposite;

	/**
	 * @param parent
	 * @param aUnit
	 *           The {@link Unit} so show all requirements in this composite.
	 * @param showHeaders
	 *           If true then headers will be shown.
	 * @param showLinkColumns
	 *           If true then the link columns will be shown.
	 */
	public RequirementsListComposite(Composite parent, Unit aUnit, boolean isUnitImported,
			boolean showHeaders, boolean showLinkColumns) {
		super(parent, SWT.NONE);
		unitIsImported = isUnitImported;
		initialize(showLinkColumns, isUnitImported);
		setInput(aUnit, isUnitImported, showLinkColumns);
		showHeaders(showHeaders);
	}

	/**
	 * @param parent
	 * @param style
	 * @param showHeaders
	 *           If true then headers will be shown.
	 * @param showLinkColumns
	 *           If true then the link columns will be shown.
	 */
	public RequirementsListComposite(Composite parent, int style, boolean showHeaders,
			boolean showLinkColumns) {
		super(parent, style);
		initialize(showLinkColumns, false);
		showHeaders(showHeaders);
	}

	private ToolTip getToolTip() {
		if (toolTip == null) {
			//toolTip = new ToolTip(requirementsTree.getShell(), SWT.CAP_ROUND);
			toolTip = new DefaultToolTip(requirementsTree, ToolTip.NO_RECREATE, false);
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
	private void initialize(boolean showLinks, boolean isUnitImported) {
		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.verticalSpacing = 0;
		this.setLayout(layout);

		createTitleBar();
		requirementsTree = new Tree(this, SWT.MULTI | SWT.FULL_SELECTION);
		requirementsTree.setHeaderVisible(false);
		requirementsTree.setLinesVisible(true);
		GridData treeData = new GridData(SWT.FILL, SWT.FILL, true, true);
		treeData.minimumHeight = 100;
		requirementsTree.setLayoutData(treeData);

		requirementColumn = new TreeColumn(requirementsTree, SWT.NONE);
		//requirementColumn.setWidth(200);
		requirementColumn.setResizable(true);
		requirementColumn.setText(Messages.ServiceLinkLabelProvider_5);
		// Create Visibility Column
		visibilityColumn = new TreeColumn(requirementsTree, SWT.NONE);
		visibilityColumn.setResizable(false);
		visibilityColumn.setText("V"); //$NON-NLS-1$
		visibilityColumn.pack();
		if (showLinks) {
			createLinkColumns();
		}
		treeViewer = new TreeViewer(requirementsTree);
		setProviders(isUnitImported);
		setListeners();

		PlatformUI.getWorkbench().getHelpSystem().setHelp(this,
				IDeployHelpContextIds.TOPOLOGY_REQUIREMENTS_FLYOUT);
	}

	private void createTitleBar() {
		listHeaderComposite = new Composite(this, SWT.NONE);
		listHeaderComposite.setBackgroundMode(SWT.INHERIT_DEFAULT);

		GridLayout gl = new GridLayout(1, false);
		gl.marginWidth = 5;
		gl.marginHeight = 5;
		listHeaderComposite.setLayout(gl);
		listHeaderComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		//Add Label
		Label label = new Label(listHeaderComposite, SWT.NONE);
		label.setText(Messages.UnitFlyOutPropertiesToggler_Requirements);
		label.setFont(DeployCoreUIPlugin.getDefault().getSharedFonts().getFont(
				ISharedFonts.FIG_CATEGORY));
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		listHeaderComposite.setBackground(getDisplay().getSystemColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
	}

	public void setInput(Unit aUnit, boolean unitIsImported, boolean showLinks) {
		if (unit != aUnit) {
			removeInputListeners(unit);
			unit = aUnit;
			addInputListeners(aUnit);

			getTreeLabelProvider().setIsUnitImported(unitIsImported);

			treeViewer.setInput(unit);
			requirementColumn.pack();

			if (showLinks) {
				packLinkColumns();
			}
			resizeTree(REQ_COL_MIN_WIDTH);
		}
	}

	private void createLinkColumns() {
		linkTargetColumn = new TreeColumn(requirementsTree, SWT.NONE);
		linkTargetColumn.setText(Messages.LinksPropertySection2_Targe_);
	}

	private void packLinkColumns() {
		if (linkTargetColumn != null && !linkTargetColumn.isDisposed()) {
			linkTargetColumn.pack();
		}
	}

	private void addInputListeners(Unit aUnit) {
		if (aUnit != null) {
			addUnitListener(aUnit);
			addRequirementsListener(aUnit);
		}
	}

	private void addRequirementsListener(Unit aUnit) {
		List<Requirement> reqs = aUnit.getRequirements();
		if (requirementAdapter == null) {
			requirementAdapter = new RequirementAdapter();
		}
		requirementAdapter.adapt(reqs);
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
						if (CorePackage.Literals.UNIT__REQUIREMENT_GROUP == notification.getFeature()) {
							FeatureMap.Entry map = (FeatureMap.Entry) notification.getNewValue();
							requirementAdapter.adapt((Requirement) map.getValue());
						}
						refreshTree();
						break;
					case Notification.ADD_MANY:
						if (CorePackage.Literals.UNIT__REQUIREMENT_GROUP == notification.getFeature()) {
							List<FeatureMap.Entry> entries = (List<FeatureMap.Entry>) notification
									.getNewValue();
							for (Entry entry : entries) {
								requirementAdapter.adapt((Requirement) entry.getValue());
							}
						}
						refreshTree();
						break;
					case Notification.REMOVE:
						if (CorePackage.Literals.UNIT__REQUIREMENT_GROUP == notification.getFeature()) {
							FeatureMap.Entry map = (FeatureMap.Entry) notification.getOldValue();
							((Requirement) map.getValue()).getEObject().eAdapters().remove(
									requirementAdapter);
						}
						refreshTree();
						break;
					case Notification.REMOVE_MANY:
						if (CorePackage.Literals.UNIT__REQUIREMENT_GROUP == notification.getFeature()) {
							List<FeatureMap.Entry> entries = (List<FeatureMap.Entry>) notification
									.getNewValue();
							for (Entry entry : entries) {
								Requirement req = (Requirement) entry.getValue();
								req.getEObject().eAdapters().remove(requirementAdapter);
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
			if (requirementAdapter != null) {
				requirementAdapter.removeTargets();
			}
		}
	}

	private void setListeners() {
		Listener treeListener = new Listener() {
			public void handleEvent(Event event) {
				TreeItem row = requirementsTree.getItem(new Point(event.x, event.y));
				if (row != null) {
					switch (event.type)
					{
					case SWT.MouseHover:
						if (overIconArea(row, 0, event.x)) {
//							System.out.println("over icon"); //$NON-NLS-1$
							showRequirementToolTip(requirementsTree, row.getData(), event);
						} else if (overTextArea(row, 0, event.x)) {
//							System.out.println("over text :: column 0"); //$NON-NLS-1$
							if (row.getData() instanceof UnsetInterface) {
								showToolTip(requirementsTree,
										Messages.RequirementsListComposite_Double_click_to_set_interface_,
										event);
							} else if (row.getData() instanceof Interface) {
								showToolTip(requirementsTree,
										Messages.RequirementsListComposite_Double_click_to_open_interface_,
										event);
							}
						} else if (overTextArea(row, VISIBILITY_COLUMN, event.x)) {
//							System.out.println("over text :: column visibility"); //$NON-NLS-1$
							showVisibilityToolTip(requirementsTree, row.getData(), event);
						} else if (overTextArea(row, TARGET_COLUMN, event.x)) {
//							System.out.println("over text :: column TARGET"); //$NON-NLS-1$
							String text = row.getText(TARGET_COLUMN);
							if (Messages.RequirementsPropertiesLabelProvider_No_target_.equals(text)) {
								showToolTip(requirementsTree,
										Messages.RequirementsListComposite_Double_click_to_set_target_, event);
							} else if (Messages.RequirementsPropertiesLabelProvider_No_host_.equals(text)) {
								showToolTip(requirementsTree,
										Messages.RequirementsListComposite_Double_click_to_set_host_, event);
							} else {
								showToolTip(
										requirementsTree,
										Messages.RequirementsListComposite_Double_click_to_select_in_the_diagr_,
										event);
							}
						}
						break;
					case SWT.KeyDown:
						if (event.character == SWT.CR && requirementsTree.getSelectionCount() == 1) {
							row = requirementsTree.getSelection()[0];
							handleRowActivation(row);
						}
						break;
					}
				}
			}
		};
		requirementsTree.addListener(SWT.MouseHover, treeListener);
		requirementsTree.addListener(SWT.KeyDown, treeListener);
		requirementsTree.addListener(SWT.Selection, treeListener);

		requirementsTree.addMouseListener(new MouseListener() {
			public void mouseUp(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {
				Point tempPoint = new Point(e.x, e.y);
				TreeItem row = requirementsTree.getItem(tempPoint);
				if (overIconArea(row, 0, e.x)) {
					Point point = requirementsTree.toDisplay(tempPoint);
					showResolutions(row.getData(), new Point(point.x, point.y + 8));
				}
			}

			public void mouseDoubleClick(MouseEvent e) {
				TreeItem row = requirementsTree.getItem(new Point(e.x, e.y));
				handleRowActivation(row);
			}
		});

		getShell().addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				dispose();
			}
		});

		requirementsTree.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				resizeTree(REQ_COL_MIN_WIDTH);
			}
		});
	}

	/**
	 * Force the resize of the tree based on the shell bounds.
	 * 
	 * @param minSize
	 */
	public void resizeTree(int minSize) {
		int w = requirementsTree.getBounds().width;
		// We hard-code the width of the visibility rather than
		// using the pack()ed with because on Linux there seems
		// to be a default to proportionally grow columns that
		// caused visibility to incorrectly grow.
		w -= 24; // visibilityColumn.getWidth();
		if (linkTargetColumn != null && !linkTargetColumn.isDisposed()) {
			w -= linkTargetColumn.getWidth();
		}
		int size = minSize > 0 ? minSize : REQ_COL_MIN_WIDTH;
		if (w < size) {
			w = size;
		}
//		System.out.println("controlResized()"); //$NON-NLS-1$
		requirementColumn.setWidth(w);
	}

	protected void showResolutions(Object data, Point point) {
		if (data instanceof Requirement) {
			Requirement dmo = (Requirement) data;
			List<IMarker> listOfMarkers = SoaDeployUiUtil.getMarkers(dmo);
			IStatus status = dmo.getStatus();
			if (status.isOK() && isHosting(dmo)) {
				// getHostingStatus can return null
				status = getHostingStatus();
				if (status == null) {
					return;
				}
			}
			if (!listOfMarkers.isEmpty() || !status.isOK()) {
				IMarker[] markers = new IMarker[listOfMarkers.size()];
				listOfMarkers.toArray(markers);

				getTreeViewer().setSelection(null);
				MarkerResolutionHelper mrh = new MarkerResolutionHelper(markers);
				quickfixPopup = new QuickFixDialog(getShell(), dmo.getTopology(), mrh, status, point,
						true, this);
				quickfixPopup.open();

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
		} else {
			//Select the link target.
			revealTarget(data);
		}
	}

	private void showRequirementToolTip(Control control, Object data, Event e) {
		String tipText = null;
		if (data != null) {
			if (data instanceof Requirement) {
				tipText = getTipText((Requirement) data);
				if (tipText == null && isHosting((Requirement) data)) {
					tipText = Messages.ConfigurationsPropertySection2_Hostin_;
				}
			}
		}

		showToolTip(control, tipText, e);
	}

	private boolean isHosting(Requirement requirement) {
		return requirement.getLinkType() == RequirementLinkTypes.HOSTING_LITERAL;
	}

	private void showToolTip(Control control, String tipText, Event e) {
//		System.out.println("Show tooltip = " + tipText); //$NON-NLS-1$
		if (tipText != null) {
			Point ptAbs = control.toDisplay(new Point(e.x, e.y));
			DefaultToolTip tip = (DefaultToolTip) getToolTip();
//			if (tip.isVisible()) {
//				// tip.setMessage(null);
//				tip.setVisible(false);
//			}
			tip.setText(tipText);
			tip.show(new Point(ptAbs.x + 15, ptAbs.y + 10));
			//tip.setVisible(true);

		} else {
			//getToolTip().setVisible(false);
			getToolTip().hide();
		}
	}

	private String getTipText(Requirement req) {
		List<IStatus> badExpressionStatuses = getBadExpressionStatuses(req);

		// if (req.getStatus().isOK()) {
		// return null;
		// }

		if (!req.getStatus().isOK()) {
			badExpressionStatuses.add(req.getStatus());
		}

		if (req.getLinkType() == RequirementLinkTypes.HOSTING_LITERAL) {
			IStatus hostingStatus = getHostingStatus();
			if (hostingStatus != null) {
				badExpressionStatuses.add(hostingStatus);
			}
		}

		IStatus status;
		if (badExpressionStatuses.size() == 0) {
			return PropertyUtils.getDisplayEType(req.getDmoEType(), null);
		} else if (badExpressionStatuses.size() == 1) {
			status = badExpressionStatuses.get(0);
		} else {
			IStatus[] children = badExpressionStatuses.toArray(new IStatus[0]);
			status = new MultiStatus(DeployCorePlugin.PLUGIN_ID, 0, children,
					DeployCoreMessages.Model_consistency_status_message, null);
		}

		return SoaDeployUiUtil.getStatusMessage(status);
	}

	private List<IStatus> getBadExpressionStatuses(Requirement req) {
		List<IStatus> l = new LinkedList<IStatus>();
		List<RequirementExpression> expressions = req.getExpressions();
		for (Iterator<RequirementExpression> it = expressions.iterator(); it.hasNext();) {
			RequirementExpression re = it.next();
			if (!re.getStatus().isOK()) {
				l.add(re.getStatus());
			}
		}

		return l;
	}

	private IStatus getHostingStatus() {
		return RequirementsPropertiesLabelProvider.getHostingStatus(unit);
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
		treeViewer.setContentProvider(new RequirementsPropertiesContentProvider());
		// Set label provider
		treeViewer.setLabelProvider(new RequirementsPropertiesLabelProvider(isUnitImported));
	}

	protected void setInterface(TreeItem item, UnsetInterface element) {
		if (unitIsImported && !element.getParent().isPublicEditable()) {
			// Cannot edit.
			return;
		}
		Interface interfaceToEdit = null;

		AbstractUIHandler uihandler = null;
		AbstractInterfaceHandler handler = null;
		EClass serviceType = ((Reference) element.getParent()).getDmoEType();
		if (serviceType != null) {
			IInterfaceHandlerService handlerService = DeployCoreUIPlugin.getDefault()
					.getInterfaceHandlerService();
			// TODO This is a hack that needs to be fixed with proper extension
			// support for
			// service handlers to associate a service with interfaces.
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
			Reference ref = (Reference) element.getParent();
			uihandler = DeployCoreUIPlugin.getDefault().getInterfaceUIHandlerService()
					.findUIHandlerForSubstitutable(interfaceToEdit);
			if (uihandler != null) {
				try {
					boolean result = uihandler
							.editSubstitutable(getShell(), ref, interfaceToEdit, false);
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
						setInterfaceObjectOnReference(ref, interfaceToEdit);
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

	/**
	 * Show/hide link columns based on the visable flag.
	 * 
	 * @param visable
	 *           If true then show the link columns.
	 */
	public void setLinkColumnsVisable(boolean visable) {
		Shell shell = treeViewer.getControl().getShell();
		Point shellSize = shell.getSize();
		if (visable) {
			// Create columns.
			createLinkColumns();
			treeViewer.refresh();
			packLinkColumns();
			if (shouldResizeShell) {
				int width = linkTargetColumn.getWidth();
				shell.setSize(shellSize.x + width, shellSize.y);
			}
		} else {
			// Dispose columns.
			int width = linkTargetColumn.getWidth();
			linkTargetColumn.dispose();
			if (shouldResizeShell) {
				shell.setSize(shellSize.x - width, shellSize.y);
			}
		}
	}

	private void revealTarget(Object data) {
//		if (data instanceof RequirementGroup && ((RequirementGroup) data).isHosting()) {
//			// Reveal target host.
//			Unit sourceUnit = ((RequirementGroup) data).getParent();
//			if (sourceUnit != null) {
//				Unit host = ValidatorUtils.getHost(sourceUnit);
//				if (host == null) {
//					// Launch to find Host.
//					launchLinksDiscoveryForHost(sourceUnit, (RequirementGroup) data);
//				} else {
//					PropertyUtils.reveal(host);
//				}
//			}
//		} else 
		if (data instanceof Requirement) {
			// Reveal link target.
			Requirement req = (Requirement) data;
			RequirementLinkTypes linkType = req.getLinkType();
			if (linkType == RequirementLinkTypes.HOSTING_LITERAL) {
				Unit sourceUnit = (Unit) req.getParent();
				if (sourceUnit != null) {
					Unit host = ValidatorUtils.getHost(sourceUnit);
					if (host == null) {
						// Launch to find Host.
						launchLinksDiscoveryForHost(sourceUnit, req);
					} else {
						PropertyUtils.reveal(host);
					}
				}
			} else if (/*
							 * linkType != RequirementLinkTypes.HOSTING_LITERAL &&
							 */linkType != RequirementLinkTypes.MEMBER_LITERAL) {
				DependencyLink link = req.getLink();
				if (link != null) {
					Capability cap = link.getTarget();
					if (cap != null) {
						PropertyUtils.reveal(cap.getParent());
						//Would like to reveal the capability but this is not
						//supported by the properties view.
						//PropertyUtils.reveal(cap);
					}
				} else {
					// Discover target.
					launchLinksDiscoveryForRequirement(req);
				}
			}
		}
	}

	private void launchLinksDiscoveryForRequirement(Requirement requirement) {
		LinkDiscoveryDataModel model = LinkDiscoveryDataModel.createModel();
		model.setIsDependency(true);
		model.setRequirement(requirement);
		model.setShouldShowSelectionPage(false);
		openNewLinkWizard(model);
	}

	private void launchLinksDiscoveryForHost(Unit hostee, Requirement requirement) {
		LinkDiscoveryDataModel model = LinkDiscoveryDataModel.createModel();
		model.setIsHosting(true);
		model.setUnit(hostee);
		model.setShouldShowSelectionPage(false);
		int result = openNewLinkWizard(model);
		if (result == Window.OK) {
			treeViewer.refresh(requirement);
		}
	}

	private int openNewLinkWizard(LinkDiscoveryDataModel model) {
		NewLinkWizard wizard = new NewLinkWizard(model);
		WizardDialog dialog = new WizardDialog(getShell(), wizard);
		dialog.create();
		return dialog.open();
	}

	protected DeployLink getLink(Object data) {
		DeployLink link = null;
		if (data != null) {
			if (data instanceof Requirement) {
				Requirement req = (Requirement) data;
				if (req.getLinkType() == RequirementLinkTypes.HOSTING_LITERAL) {
					link = ValidatorUtils.getHostingLink((Unit) req.getParent());
				} else {
					link = req.getLink();
				}
			}
		}
		return link;
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
		TreeItem rootItems[] = requirementsTree.getItems();
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
	 * Programmatically show or hide the headers.
	 * 
	 * @param aBoolean
	 */
	public void showHeaders(boolean aBoolean) {
		requirementsTree.setHeaderVisible(aBoolean);
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
		if (listener != null && requirementsTree != null) {
			requirementsTree.addListener(eventType, listener);
		}
	}

	public void addSelectionChangedListener(ISelectionChangedListener aListener) {
		if (aListener != null && treeViewer != null) {
			treeViewer.addSelectionChangedListener(aListener);
		}
	}

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
		if (listener != null && requirementsTree != null) {
			requirementsTree.removeListener(eventType, listener);
		}
	}

	public RequirementsPropertiesLabelProvider getTreeLabelProvider() {
		return (RequirementsPropertiesLabelProvider) (treeViewer != null ? treeViewer
				.getLabelProvider() : null);
	}

	@Override
	public void dispose() {
		if (!isDisposed()) {
			if (toolTip != null && requirementsTree != null && !requirementsTree.isDisposed()) {
				toolTip.deactivate();
				toolTip = null;
			}
			removeInputListeners(unit);
			unit = null;
			unitAdapter = null;
			requirementAdapter = null;
			super.dispose();
		}
	}

	private void showVisibilityToolTip(Control control, Object data, Event e) {
		String tipText = null;
		if (data != null && data instanceof Requirement) {
			Requirement requirement = (Requirement) data;
			if (unitIsImported) {
				//There are only two options if the parent Unit is imported.
				if (requirement.isPublicEditable()) {
					tipText = Messages.RequirementsPopupDialog_Public_Editabl_;
				} else if (requirement.isPublic()) {
					tipText = Messages.RequirementsPopupDialog_Publi_;
				} else {
					tipText = Messages.RequirementsPopupDialog_Privat_;
				}
			} else {
				Topology top = requirement.getEditTopology();
				if (top != null) {
					ConfigurationContract contract = top.getConfigurationContract();
					if (contract != null) {
						if (contract.isPublicEditable(requirement)) {
							tipText = Messages.RequirementsPopupDialog_Public_Editabl_;
						} else if (contract.isPublic(requirement)) {
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
	public void setSelection(Requirement req) {
		if (req != null && treeViewer != null) {
			treeViewer.setSelection(new StructuredSelection(req), true);
		}
	}

	protected void setShouldResizeShell(boolean aBoolean) {
		shouldResizeShell = aBoolean;
	}

	private void refreshTree() {
		if (Display.getCurrent() != null) {
			treeViewer.refresh();
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

	public TreeViewer getTreeViewer() {
		return treeViewer;
	}

	public IStatus handleRequirementLinkChange(Notification notification) {
		//Let's take the brute force approach and refresh the tree.
		refresh();
		return Status.OK_STATUS;
	}

	/**
	 * 
	 * @return true if we are in the process of preserving selections in the tree. This is a hint
	 *         that a selection event may need to be ignored.
	 */
	public boolean isPreservingSelection() {
		return isPreservingTreeSelection;
	}

	public void handleResolution(ResolutionEvent event) {
		if (event.status == null || event.status.getSeverity() != IStatus.CANCEL) {
			//close the dialog
			if (quickfixPopup != null) {
				quickfixPopup.close();
				quickfixPopup = null;
			}
		}
	}

	/**
	 * Add to the list of exclusions for setting background colors.
	 * 
	 * @param aList
	 */
	public void addBackgroundExclusions(List<Control> aList) {
		aList.add(listHeaderComposite);
		aList.add(listHeaderComposite.getChildren()[0]);
	}
}
