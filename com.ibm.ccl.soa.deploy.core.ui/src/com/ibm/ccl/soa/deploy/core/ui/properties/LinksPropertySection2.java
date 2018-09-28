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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.ToolTipHelper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ITableColorProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.datamodels.LinkDiscoveryDataModel;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.composites.ConstraintComposite;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployCoreEditor;
import com.ibm.ccl.soa.deploy.core.ui.internal.SoaDeployUiUtil;
import com.ibm.ccl.soa.deploy.core.ui.marker.quickfix.MarkerResolutionHelper;
import com.ibm.ccl.soa.deploy.core.ui.marker.quickfix.QuickFixDialog;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ResourceUtils;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * Property section on the 'Links2' tab. See plugin.xml for enablement.
 * 
 * <p>
 * The UI is a TableTree that groups by link type.
 * 
 * @author Ed Snible
 */
public class LinksPropertySection2 extends AbstractTopologyPropertySection {

	private static final int MARGIN_PIXELS = 3;
	private static final int LINK_TYPE = 0;
	private static final int LINK_SOURCE = 1;
	private static final int LINK_TARGET = 2;

	private static final List<EStructuralFeature> interestingFeatures = new ArrayList<EStructuralFeature>(
			8);

	static {

		interestingFeatures.add(CorePackage.Literals.UNIT__CONSTRAINT_LINKS);
		interestingFeatures.add(CorePackage.Literals.UNIT__REALIZATION_LINKS);
		interestingFeatures.add(CorePackage.Literals.UNIT__UNIT_LINKS);
		interestingFeatures.add(CorePackage.Literals.UNIT__UNIT_LINKS_GROUP);

		interestingFeatures.add(CorePackage.Literals.REQUIREMENT__LINK);

		interestingFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_DEPLOY);
		interestingFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_CONSTRAINT);
		interestingFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_DEPENDENCY);
		interestingFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_REALIZATION);
		interestingFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_HOSTING);
		interestingFeatures.add(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_MEMBER);

		interestingFeatures.add(CorePackage.Literals.TOPOLOGY__CONSTRAINT_LINKS);
		interestingFeatures.add(CorePackage.Literals.TOPOLOGY__DEPENDENCY_LINKS);
		interestingFeatures.add(CorePackage.Literals.TOPOLOGY__DEPENDENCY_LINK_GROUP);
		interestingFeatures.add(CorePackage.Literals.TOPOLOGY__REALIZATION_LINKS);
		interestingFeatures.add(CorePackage.Literals.TOPOLOGY__UNIT_LINKS);
		interestingFeatures.add(CorePackage.Literals.TOPOLOGY__UNIT_LINKS_GROUP);

		interestingFeatures.add(CorePackage.Literals.DEPLOY_MODEL_OBJECT__DISPLAY_NAME);

	}

	private TreeViewer treeViewer;
	private Unit unit;
	private Action createLinkAction;
	private Action removeLinkAction;
	private Action traverseLinkAction;
	private Action realizeAction;
	private Action discoverAction;
	private LinkTreeContentProvider provider;
	private LinkRowHoverListener listener;
	private LinkTreeLabelProvider labelProvider;

	private ConstraintComposite constraintComposite;

	private final Map<Object, LinkRow> cache = new HashMap<Object, LinkRow>();

	private ScrolledComposite constraintsWrapper;

	/**
	 * constructor
	 */
	public LinksPropertySection2() {
		// do nothing
	}

	public void doCreateControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {

		System.out.println("creating controls"); //$NON-NLS-1$

		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_PROPERTIES_LINKS_TAB);

		// Create a new section to wrap and layout our table
		Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		composite.setLayout(new GridLayout());
		composite.setBackgroundMode(SWT.INHERIT_DEFAULT);

		GridData stdGridData = new GridData(GridData.FILL, GridData.FILL, true, true);

		SashForm sf = new SashForm(composite, SWT.VERTICAL);
		GridLayout gridLayout = new GridLayout(1, true);
		gridLayout.marginHeight = MARGIN_PIXELS;
		gridLayout.marginWidth = MARGIN_PIXELS;
		gridLayout.marginLeft = MARGIN_PIXELS;
		gridLayout.marginRight = MARGIN_PIXELS;
		gridLayout.marginTop = MARGIN_PIXELS;
		gridLayout.marginBottom = MARGIN_PIXELS;
		sf.setLayout(gridLayout);
		sf.setLayoutData(stdGridData);

		Tree tableTree = getWidgetFactory().createTree(sf,
				SWT.FULL_SELECTION | SWT.SINGLE | SWT.HIDE_SELECTION);
		tableTree.setLinesVisible(true);
		tableTree.setHeaderVisible(true);

		String[] columns = new String[] { Messages.RequirementsPropertySection5_Lin_,
				Messages.LinksPropertySection2_Sourc_, Messages.LinksPropertySection2_Targe_ };

		setColumns(tableTree, columns);

		TableLayout tl = new TableLayout();
		tl.addColumnData(new ColumnWeightData(30)); // link
		tl.addColumnData(new ColumnWeightData(35)); // source
		tl.addColumnData(new ColumnWeightData(35)); // target		
		tableTree.setLayout(tl);

		treeViewer = new TreeViewer(tableTree);
		treeViewer.setColumnProperties(columns);

		provider = new LinkTreeContentProvider(cache);
		provider.setIncludeDiscoverableLinks(false);

		treeViewer.setContentProvider(provider);
		labelProvider = new LinkTreeLabelProvider();
		treeViewer.setLabelProvider(labelProvider);

		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				enableDisableButtons();
			}
		});

		tableTree.setLayoutData(stdGridData);

		listener = new LinkRowHoverListener(tableTree);
		tableTree.addMouseTrackListener(listener);
		tableTree.addMouseListener(listener);

		constraintsWrapper = getWidgetFactory().createScrolledComposite(sf, SWT.V_SCROLL);
		constraintsWrapper.setLayout(new GridLayout(1, true));
		constraintsWrapper.setLayoutData(stdGridData);
		constraintsWrapper.setBackgroundMode(SWT.INHERIT_DEFAULT);

		constraintsWrapper.setExpandVertical(true);
		constraintsWrapper.setExpandHorizontal(true);

		constraintComposite = new ConstraintComposite(constraintsWrapper, SWT.FLAT, null,
				getWidgetFactory());
		getWidgetFactory().adapt(constraintComposite);
		constraintComposite.setLayoutData(stdGridData);
		constraintsWrapper.setContent(constraintComposite);

		createActions();

		attachCellEditors();
	}

	@Override
	protected void doDispose() {
		if (constraintComposite != null) {
			constraintComposite.dispose();
		}
	}

	private void attachCellEditors() {
		treeViewer.setCellEditors(new CellEditor[] { new TextCellEditor(treeViewer.getTree(),
				SWT.LEFT) // link name
				});
		treeViewer.setCellModifier(new LinkPropertiesModifier());
	}

	private void setColumns(Tree tree, String[] columnLabels) {
		TreeColumn[] columns = tree.getColumns();
		for (int i = 0; i < columnLabels.length; i++) {
			String string = columnLabels[i];
			TreeColumn column = i < columns.length ? columns[i] : new TreeColumn(tree, 0);
			column.setText(string);
		}
	}

	private void createActions() {

		String addLink = Messages.ConfigurationsPropertySection2_Create_Lin_;
		createLinkAction = propAction(addLink, "icons/elcl16/create_link.gif", new Action() { //$NON-NLS-1$
					public void run() {
						addLink();
					}
				});

		String unlink = Messages.ConfigurationsPropertySection2_Unlin_;
		removeLinkAction = propAction(unlink, "icons/elcl16/rmove_link.gif", new Action() { //$NON-NLS-1$
					public void run() {
						unlink();
					}
				});

		String jump = Messages.ConfigurationsPropertySection2_Go_T_;
		traverseLinkAction = propAction(jump, "icons/elcl16/goto_linktarget.gif", new Action() { //$NON-NLS-1$
					public void run() {
						jump();
					}
				});

		String realize = Messages.LinksPropertySection_0;
		realizeAction = propAction(realize, "icons/elcl16/add_to_tplogy.gif", new Action() { //$NON-NLS-1$
					public void run() {
						realize();
					}
				});

		String discover = Messages.LinksPropertySection_Discover_Links;
		discoverAction = propAction(discover, "icons/elcl16/findofflink.gif", new Action() { //$NON-NLS-1$
					public void run() {
						discover();
					}
				});
	}

	private Action propAction(String msg, String icon, Action a) {
		a.setText(msg);
		a.setToolTipText(msg);
		ImageDescriptor id = PropertyUtils.createImageDescriptor(icon);
		a.setImageDescriptor(id);
		Image image = DeployCoreUIPlugin.getDefault().getSharedImages().getImageFromPath(icon, false);
		if (image != null) {
			a.setDisabledImageDescriptor(ImageDescriptor.createFromImage(image));
		}
		return a;
	}

	protected void enableDisableButtons() {
		LinkRow lrow = getSelectedRow();

		removeLinkAction.setEnabled(lrow != null && lrow.canRemove());
		boolean toTarget = lrow != null && unit == lrow.getSourceUnit();
		traverseLinkAction.setEnabled(lrow != null && lrow.canTraverse(toTarget));
		realizeAction.setEnabled(lrow != null && lrow.canRealize());

		// Note: an improvement would be to enable 'add link' only if there is 
		// something on the Topology that matches.  This might be expensive to
		// calculate...

		discoverAction.setEnabled(!provider.getIncludeDiscoverableLinks());

		DeployModelObject deployModelObject = lrow != null ? lrow.getObjectForPopup() : null;
		constraintComposite.setInput(deployModelObject);
	}

	@Override
	protected void setInput(DeployModelObject input) {
		if (input instanceof Unit) {
			setInput((Unit) input);
		}

	}

	protected void setInput(Unit input) {
		// It isn't safe to do this, because the links could have
		// changed since last time we displayed this Unit.
		//		if (this.unit == unit) {
		//			return;
		//		}

		unit = input;

		cache.clear();

		if (input != null) {
			if (treeViewer.getInput() != input) {
				treeViewer.setInput(input);
				listener.setInput(input);
				labelProvider.setUnitToSuppressHyperlinkingFor(input);
			}
		}

		treeViewer.expandAll();

		enableDisableButtons();
	}

	@Override
	protected boolean shouldProcessEvent(IWorkbenchWindow window, Notification notification) {

		// always process events since the table isn't synced with a DmoHelper
		return interestingFeatures.contains(notification.getFeature());
	}

	/**
	 * We keep track of the {@link LinkRow} for each link, because we don't want to recreate them.
	 * Recreating them forces the table tree to redraw. We don't want the flicker and selection
	 * change, especially when adding Constraints to an existing Link.
	 * 
	 * @param deployLink
	 * @param showIcon
	 * @return
	 */
	private static LinkRow getRowForLink(Map<Object, LinkRow> cache, DeployLink deployLink,
			boolean showIcon) {
		LinkRow retVal = cache.get(deployLink);
		if (retVal == null) {
			retVal = createRowForLink(deployLink, showIcon);
			cache.put(deployLink, retVal);
		}
		return retVal;
	}

	private static LinkRow getRowForLink(Map<Object, LinkRow> cache, UnitDescriptor ud, Unit u,
			boolean isOut, int linkType, boolean showIcon) {
		LinkRow retVal = cache.get(ud);
		if (retVal == null) {
			retVal = new UnitDescriptorLinkRow(showIcon, ud, u, isOut, linkType);
			cache.put(ud, retVal);
		}
		return retVal;
	}

	protected NotificationFilter getFilter() {
		NotificationFilter retVal = NotificationFilter.createEventTypeFilter(Notification.SET).or(
				NotificationFilter.createEventTypeFilter(Notification.ADD)).or(
				NotificationFilter.createEventTypeFilter(Notification.REMOVE));
		return retVal;
	}

	public void doAboutToBeShown() {

		if (unit != null && treeViewer != null) {

			treeViewer.refresh();
			treeViewer.expandAll();
		}
	}

	public void doAboutToBeHidden() {

	}

	protected void discover() {
		BusyIndicator.showWhile(getPart().getSite().getShell().getDisplay(), new Runnable() {

			public void run() {
				provider.setIncludeDiscoverableLinks(true);
				enableDisableButtons();
				treeViewer.refresh();
				treeViewer.expandAll();
			}

		});
	}

	private void realize() {
		LinkRow lrow = getSelectedRow();
		if (lrow != null) {
			lrow.realize();
		}
	}

	private void jump() {
		LinkRow lrow = getSelectedRow();
		if (lrow != null) {
			boolean toTarget = unit == lrow.getSourceUnit();
			lrow.traverse(/* getPart(), */toTarget);
		}
	}

	private void addLink() {
		LinkDiscoveryDataModel linkDiscoveryModel = LinkDiscoveryDataModel.createModel();
		linkDiscoveryModel.setUnit(unit);
		NewLinkWizard wizard = new NewLinkWizard(linkDiscoveryModel);
		WizardDialog dialog = new WizardDialog(getPart().getSite().getShell(), wizard);
		dialog.create();
		dialog.open();
	}

	private void unlink() {
		LinkRow lrow = getSelectedRow();
		lrow.unlink();
		TreeItem[] items = treeViewer.getTree().getItems();
		if (items.length > 0) {
			treeViewer.setSelection(new StructuredSelection(items[0].getData()));
		}
	}

	private LinkRow getSelectedRow() {
		if (treeViewer.getSelection() instanceof StructuredSelection) {
			StructuredSelection ss = (StructuredSelection) treeViewer.getSelection();
			Object rowObj = ss.getFirstElement();
			if (rowObj instanceof LinkRow) {
				return (LinkRow) rowObj;
			}
		}

		return null;
	}

	public boolean shouldUseExtraSpace() {
		return true;
	}

	public void refresh() {
		if (treeViewer != null && !treeViewer.getTree().isDisposed()) {
			provider.refresh();
			treeViewer.refresh();
			treeViewer.expandAll();
		}
	}

	@Override
	protected void addMenuActions(IMenuManager menu) {

		menu.add(createLinkAction);
		menu.add(removeLinkAction);
		menu.add(traverseLinkAction);
		menu.add(realizeAction);
		menu.add(discoverAction);
	}

	@Override
	protected void addToolBarActions(IToolBarManager toolbar) {
		toolbar.add(createLinkAction);
		toolbar.add(removeLinkAction);
		toolbar.add(traverseLinkAction);
		toolbar.add(realizeAction);
		toolbar.add(discoverAction);
	}

	protected static EditPart getDiagram() {
		DeployCoreEditor activeEditor = ResourceUtils.getActiveDeployEditDomain();
		return activeEditor != null ? activeEditor.getDiagramEditPart() : null;
	}

	/**
	 * Roots are the link types: Hosting, Dependency, Membership, Realization, Logical (in that
	 * order)
	 * 
	 * Within each category the sub-categories are IN and OUT
	 * 
	 * Within each sub-category are the actual links
	 */
	private class LinkTreeContentProvider implements ITreeContentProvider {

//		private static final Object[] NONE = new Object[0];

		private boolean includeDiscoverableLinks;
		private final Map<Object, LinkRow> linkRowCache;
		private final Map<Unit, List<LinkCategory>> categoryCache = new HashMap<Unit, List<LinkCategory>>();

		protected LinkTreeContentProvider(Map<Object, LinkRow> c) {
			includeDiscoverableLinks = false;
			linkRowCache = c;
		}

		protected boolean getIncludeDiscoverableLinks() {
			return includeDiscoverableLinks;
		}

		protected void setIncludeDiscoverableLinks(boolean b) {
			if (b != includeDiscoverableLinks) {
				cache.clear();
				categoryCache.clear();
			}

			includeDiscoverableLinks = b;
		}

		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof Unit) {
				Unit punit = (Unit) parentElement;
				return getNonEmptyLinkCategories(punit).toArray();
			} else if (parentElement instanceof LinkCategory) {
				LinkCategory category = (LinkCategory) parentElement;
				return category.getDirections(includeDiscoverableLinks).toArray();
			} else if (parentElement instanceof LinkDirection) {
				LinkDirection dir = (LinkDirection) parentElement;
				return dir.getMatchingLinks(includeDiscoverableLinks).toArray();
			}

			return new Object[0];
		}

		private Collection<LinkCategory> getNonEmptyLinkCategories(@SuppressWarnings("hiding")
		Unit unit) {
			List<LinkCategory> retVal = new LinkedList<LinkCategory>();

			List<LinkCategory> unitCache = getCategories(unit);
			LinkCategory hostsCategory = unitCache.get(0);
			LinkCategory dependencyCategory = unitCache.get(1);
			LinkCategory memberCategory = unitCache.get(2);
			LinkCategory realizationCategory = unitCache.get(3);
			LinkCategory logicalCategory = unitCache.get(4);

			if (hostsCategory.getDirections(includeDiscoverableLinks).size() > 0) {
				retVal.add(hostsCategory);
			}

			if (dependencyCategory.getDirections(includeDiscoverableLinks).size() > 0) {
				retVal.add(dependencyCategory);
			}

			if (memberCategory.getDirections(includeDiscoverableLinks).size() > 0) {
				retVal.add(memberCategory);
			}

			if (realizationCategory.getDirections(includeDiscoverableLinks).size() > 0) {
				retVal.add(realizationCategory);
			}

			if (logicalCategory.getDirections(includeDiscoverableLinks).size() > 0) {
				retVal.add(logicalCategory);
			}

			return retVal;
		}

		private List<LinkCategory> getCategories(@SuppressWarnings("hiding")
		Unit unit) {
			List<LinkCategory> retVal = categoryCache.get(unit);
			if (retVal == null) {
				retVal = new ArrayList<LinkCategory>(5);
				retVal.add(new LinkCategory(LinkType.HOSTING, unit, linkRowCache));
				retVal.add(new LinkCategory(LinkType.DEPENDENCY, unit, linkRowCache));
				retVal.add(new LinkCategory(LinkType.MEMBER, unit, linkRowCache));
				retVal.add(new LinkCategory(LinkType.REALIZATION, unit, linkRowCache));
				retVal.add(new LinkCategory(LinkType.CONSTRAINT, unit, linkRowCache));
				categoryCache.put(unit, retVal);
			}
			return retVal;
		}

		public Object[] getElements(Object inputElement) {
			return getChildren(inputElement);
		}

		public void dispose() {
			// Do nothing
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			categoryCache.clear();
		}

		private void refresh() {
			categoryCache.clear();
		}

		public Object getParent(Object element) {
			return null;
		}

		public boolean hasChildren(Object element) {
			return getChildren(element).length > 0;
		}

	} // end static inner class LinksTableProvider

	private static class LinkDirection {

		private final boolean isIn;
		private final LinkCategory category;
		private Collection<? extends LinkRow> cache;

		protected LinkDirection(@SuppressWarnings("hiding")
		boolean isIn, @SuppressWarnings("hiding")
		LinkCategory category) {
			this.isIn = isIn;
			this.category = category;
		}

		protected Collection<? extends LinkRow> getMatchingLinks(boolean includeDiscoverableLinks) {
			if (cache == null) {
				cache = category.getMatchingLinks(isIn, includeDiscoverableLinks);
			}

			return cache;
		}

		protected String getText() {
			return category.getText(isIn);
		}

	}

	private static class LinkCategory {
		private final Unit unit;
		private final LinkType linkType;
		private final Map<Object, LinkRow> cache;
		private final LinkDirection inDirection;
		private final LinkDirection outDirection;
		private final List<LinkDirection> validDirections;

		private static Image getHostingLinkTypeImage() {
			return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
					ISharedImages.IMG_HOSTING_LINK_TYPE);
		}

		private static Image getDependencyLinkTypeImage() {
			return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
					ISharedImages.IMG_DEPENDENCY_LINK_TYPE);
		}

		private static Image getRealizationLinkTypeImage() {
			return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
					ISharedImages.IMG_REALIZATION_LINK_TYPE);
		}

		private static Image getConstraintLinkTypeImage() {
			return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
					ISharedImages.IMG_CONSTRAINT_LINK_TYPE);
		}

		private static Image getMemberLinkTypeImage() {
			return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
					ISharedImages.IMG_MEMBERSHIP_LINK_TYPE);
		}

		protected LinkCategory(@SuppressWarnings("hiding")
		LinkType linkType, @SuppressWarnings("hiding")
		Unit unit, Map<Object, LinkRow> c) {
			this.unit = unit;
			this.linkType = linkType;
			cache = c;
			inDirection = new LinkDirection(true, this);
			outDirection = new LinkDirection(false, this);
			validDirections = new LinkedList<LinkDirection>();
		}

		protected Collection<LinkDirection> getDirections(boolean includeDiscoverableLinks) {
			List<LinkDirection> retVal = validDirections;
			retVal.clear();

			if (inDirection.getMatchingLinks(includeDiscoverableLinks).size() > 0) {
				retVal.add(inDirection);
			}

			if (outDirection.getMatchingLinks(includeDiscoverableLinks).size() > 0) {
				retVal.add(outDirection);
			}

			return retVal;
		}

		protected Collection<? extends LinkRow> getMatchingLinks(boolean isIn,
				boolean includeDiscoverableLinks) {
			if (linkType == LinkType.HOSTING) {
				return getMatchingHostingLinks(isIn, includeDiscoverableLinks);
			} else if (linkType == LinkType.DEPENDENCY) {
				return getMatchingDependencyLinks(isIn, includeDiscoverableLinks);
			} else if (linkType == LinkType.MEMBER) {
				return getMatchingMemberLinks(isIn, includeDiscoverableLinks);
			} else if (linkType == LinkType.REALIZATION) {
				return getMatchingRealizationLinks(isIn, includeDiscoverableLinks);
			} else if (linkType == LinkType.CONSTRAINT) {
				return getMatchingLinksLogicalLinks(isIn, includeDiscoverableLinks);
			}

			// Unknown Link Type
			return Collections.emptyList();
		}

		@SuppressWarnings("unchecked")
		private List<LinkRow> getMatchingLinksLogicalLinks(boolean isIn,
				boolean includeDiscoverableLinks) {
			List<ConstraintLink> links = new LinkedList<ConstraintLink>();

			links.addAll(isIn ? TopologyUtil.getImmediateConstraintLinksIn(unit) : TopologyUtil
					.getImmediateConstraintLinksOut(unit));

			for (Iterator<Capability> it = unit.getCapabilities().iterator(); it.hasNext();) {
				Capability cap = it.next();

				links.addAll(isIn ? TopologyUtil.getImmediateConstraintLinksIn(cap) : TopologyUtil
						.getImmediateConstraintLinksOut(cap));
			}

			for (Iterator<Requirement> it = unit.getRequirements().iterator(); it.hasNext();) {
				Requirement req = it.next();

				links.addAll(isIn ? TopologyUtil.getImmediateConstraintLinksIn(req) : TopologyUtil
						.getImmediateConstraintLinksOut(req));
			}

			return wrapLogicalLinks(links);
		}

		private List<LinkRow> wrapLogicalLinks(List<ConstraintLink> links) {
			List<LinkRow> retVal = new LinkedList<LinkRow>();
			for (Iterator<ConstraintLink> it = links.iterator(); it.hasNext();) {
//				retVal.add(new LogicalLinkRow(false, it.next(), getDiagram()));
				retVal.add(getRowForLink(cache, it.next(), false));
			}
			return retVal;
		}

		private Collection<LinkRow> getMatchingRealizationLinks(boolean isIn,
				boolean includeDiscoverableLinks) {
			Collection<RealizationLink> links = isIn ? TopologyUtil
					.getImmediateRealizationLinksIn(unit) : TopologyUtil
					.getImmediateRealizationLinksOut(unit);

			return wrapDependencyLinks(links);
		}

		private Collection<LinkRow> wrapDependencyLinks(Collection<RealizationLink> links) {
			List<LinkRow> retVal = new LinkedList<LinkRow>();
			for (Iterator<RealizationLink> it = links.iterator(); it.hasNext();) {
//				retVal.add(new RealizationLinkRow(false, it.next(), getDiagram()));
				retVal.add(getRowForLink(cache, it.next(), false));
			}
			return retVal;
		}

		private Collection<? extends LinkRow> getMatchingMemberLinks(boolean isIn,
				boolean includeDiscoverableLinks) {
			List<MemberLink> links = isIn ? TopologyUtil.getImmediateMemberLinksIn(unit)
					: TopologyUtil.getImmediateMemberLinksOut(unit);
			return wrapMemberLinks(links);
		}

		@SuppressWarnings("unchecked")
		private Collection<? extends LinkRow> getMatchingDependencyLinks(boolean isIn,
				boolean includeDiscoverableLinks) {

			List<DependencyLink> links = new LinkedList<DependencyLink>();
			if (isIn) {
				for (Iterator<Capability> it = unit.getCapabilities().iterator(); it.hasNext();) {
					Capability cap = it.next();
					links.addAll(TopologyUtil.getImmediateDependencyLinksIn(cap));
				}
			} else {
				for (Iterator<Requirement> it = unit.getRequirements().iterator(); it.hasNext();) {
					Requirement req = it.next();
					links.addAll(TopologyUtil.getImmediateDependencyLinksOut(req));
				}
			}

			List<? extends LinkRow> wl = wrapDependencyLinks(links);
			List<LinkRow> retVal = new LinkedList<LinkRow>(wl);

			// It isn't safe to call the TopologyDiscovererService without a target topology...
			if (includeDiscoverableLinks && unit.getTopology() != null) {
				if (isIn) {
					for (Iterator<Capability> it = unit.getCapabilities().iterator(); it.hasNext();) {
						Capability cap = it.next();
						List<UnitDescriptor> l = TopologyDiscovererService.INSTANCE.findSources(unit,
								cap, unit.getTopology(), new NullProgressMonitor());
						for (Iterator<UnitDescriptor> it2 = l.iterator(); it2.hasNext();) {
							UnitDescriptor ud = it2.next();
							if (refersToOffDiagramUnit(ud, unit.getTopology())) {
//								retVal.add(new UnitDescriptorLinkRow(false, ud, unit, false,
//										UnitDescriptorLinkRow.DEPENDENCY_TYPE));
								retVal.add(getRowForLink(cache, ud, unit, false,
										UnitDescriptorLinkRow.DEPENDENCY_TYPE, false));
							}
						}
					}
				} else {

					// MK 8/9/2006 restrict iterator to just dependency links
					for (Iterator<Requirement> it = unit.getDependencyOrAnyRequirements().iterator(); it
							.hasNext();) {
						Requirement req = it.next();
						UnitDescriptor ud = TopologyDiscovererService.INSTANCE.findTarget(unit, req, unit
								.getTopology(), new NullProgressMonitor());
						if (ud != null) {
							if (refersToOffDiagramUnit(ud, unit.getTopology())) {
//								retVal.add(new UnitDescriptorLinkRow(false, ud, unit, true,
//										UnitDescriptorLinkRow.DEPENDENCY_TYPE));
								retVal.add(getRowForLink(cache, ud, unit, true,
										UnitDescriptorLinkRow.DEPENDENCY_TYPE, false));
							}
						}
					}
				} // endif in/out
			}

			return retVal;
		}

		/**
		 * 
		 * @param ud
		 * @return <code>true</code> if 'ud' is probably not already on the topology
		 */
		private static boolean refersToOffDiagramUnit(UnitDescriptor ud, Topology top) {
			return ud.getUnitValue().getTopology() != top;
		}

		private Collection<LinkRow> getMatchingHostingLinks(boolean isIn,
				boolean includeDiscoverableLinks) {
			// Note that we reverse the direction; TopologyUtil thinks in terms of model
			// sources/targets, but isIn thinks in terms of the way the arrow points in the UI.
			List<HostingLink> links = isIn ? TopologyUtil.getImmediateHostingLinksOut(unit)
					: TopologyUtil.getImmediateHostingLinksIn(unit);

			List<LinkRow> retVal = new LinkedList<LinkRow>(wrapHostingLinks(links));

			// It isn't safe to call the TopologyDiscovererService without a target topology...
			if (includeDiscoverableLinks && unit.getTopology() != null) {
				if (!isIn) {
					UnitDescriptor ud = TopologyDiscovererService.INSTANCE.findHostUD(unit, unit
							.getTopology(), new NullProgressMonitor());
					if (ud != null) {
						if (refersToOffDiagramUnit(ud, unit.getTopology())) {
//							retVal.add(new UnitDescriptorLinkRow(false, ud, unit, true,
//									UnitDescriptorLinkRow.HOSTING_TYPE));
							retVal.add(getRowForLink(cache, ud, unit, !isIn,
									UnitDescriptorLinkRow.HOSTING_TYPE, false));
						}
					}
				} else {
					List<UnitDescriptor> l = TopologyDiscovererService.INSTANCE.findHosted(unit, unit
							.getTopology(), new NullProgressMonitor());
					for (Iterator<UnitDescriptor> it = l.iterator(); it.hasNext();) {
						UnitDescriptor ud = it.next();
						if (refersToOffDiagramUnit(ud, unit.getTopology())) {
//							retVal.add(new UnitDescriptorLinkRow(false, ud, unit, false,
//									UnitDescriptorLinkRow.HOSTING_TYPE));
							retVal.add(getRowForLink(cache, ud, unit, !isIn,
									UnitDescriptorLinkRow.HOSTING_TYPE, false));
						}
					}
				}
			}

			return retVal;
		}

		private Collection<LinkRow> wrapMemberLinks(List<MemberLink> memberLinks) {
			List<LinkRow> retVal = new LinkedList<LinkRow>();
			for (Iterator<MemberLink> it = memberLinks.iterator(); it.hasNext();) {
//				retVal.add(new MemberLinkRow(false, it.next(), epDiagram));
				retVal.add(getRowForLink(cache, it.next(), false));
			}
			return retVal;
		}

		private List<LinkRow> wrapDependencyLinks(List<DependencyLink> dependencyLinks) {
			List<LinkRow> retVal = new LinkedList<LinkRow>();
			for (Iterator<DependencyLink> it = dependencyLinks.iterator(); it.hasNext();) {
//				retVal.add(new DependencyLinkRow(false, it.next(), epDiagram));
				retVal.add(getRowForLink(cache, it.next(), false));
			}
			return retVal;
		}

		private List<LinkRow> wrapHostingLinks(List<HostingLink> hostingLinks) {
			List<LinkRow> retVal = new LinkedList<LinkRow>();
			for (Iterator<HostingLink> it = hostingLinks.iterator(); it.hasNext();) {
//				retVal.add(new HostingLinkRow(false, it.next(), epDiagram));
				retVal.add(getRowForLink(cache, it.next(), false));
			}
			return retVal;
		}

		protected Image getImage() {
			if (linkType == LinkType.HOSTING) {
				return getHostingLinkTypeImage();
			} else if (linkType == LinkType.DEPENDENCY) {
				return getDependencyLinkTypeImage();
			} else if (linkType == LinkType.MEMBER) {
				return getMemberLinkTypeImage();
			} else if (linkType == LinkType.REALIZATION) {
				return getRealizationLinkTypeImage();
			} else if (linkType == LinkType.CONSTRAINT) {
				return getConstraintLinkTypeImage();
			}

			// Unknown link type
			return null;
		}

		protected String getText() {
			if (linkType == LinkType.HOSTING) {
				return Messages.LinksPropertySection2_Hostin_;
			} else if (linkType == LinkType.DEPENDENCY) {
				return Messages.NewRequirementDialog_Dependenc_;
			} else if (linkType == LinkType.MEMBER) {
				return Messages.MembersPropertySection_MEMBER;
			} else if (linkType == LinkType.REALIZATION) {
				return Messages.LinksPropertySection2_Realizatio_;
			} else if (linkType == LinkType.CONSTRAINT) {
				return Messages.LinksPropertySection2_Logica_;
			}

			return ""; //$NON-NLS-1$
		}

		protected String getText(boolean isIn) {
			return isIn ? getInText() : getOutText();
		}

		protected String getInText() {
			if (linkType == LinkType.HOSTING) {
				return Messages.LinksPropertySection2_In_Hosts_;
			} else if (linkType == LinkType.DEPENDENCY) {
				return Messages.LinksPropertySection2_In_is_Depended_Upon_;
			} else if (linkType == LinkType.MEMBER) {
				return Messages.LinksPropertySection2_In_is_Member_;
			} else if (linkType == LinkType.REALIZATION) {
				return Messages.LinksPropertySection2_In_Realizes_;
			} else if (linkType == LinkType.CONSTRAINT) {
				return Messages.LinksPropertySection_I_;
			}

			return ""; //$NON-NLS-1$
		}

		protected String getOutText() {
			if (linkType == LinkType.HOSTING) {
				return Messages.LinksPropertySection2_Out_Hosted_;
			} else if (linkType == LinkType.DEPENDENCY) {
				return Messages.LinksPropertySection2_Out_Depends_Upon_;
			} else if (linkType == LinkType.MEMBER) {
				return Messages.LinksPropertySection2_Out_Contains_;
			} else if (linkType == LinkType.REALIZATION) {
				return Messages.LinksPropertySection2_Out_is_Realized_By_;
			} else if (linkType == LinkType.CONSTRAINT) {
				return Messages.LinksPropertySection_Ou_;
			}

			return ""; //$NON-NLS-1$
		}

	} // end class LinkCategory

	// TODO Figure out how to underline on SWT.  Unclear if this can be done through a Font, or if
	// I need to get the tree to support SWT StyledText
	private static class LinkTreeLabelProvider extends LabelProvider implements ITableLabelProvider,
			ITableColorProvider /* , ITableFontProvider */{

		private final Color white;
		private final Color blue;
		private final Color black;
		private Unit unitToSuppressHyperlinkingFor;

		//		private final Font normalFont;
		//		private final Font underlineFont;

		/**
		 * Constructor
		 */
		public LinkTreeLabelProvider() {
			Display display = Display.getCurrent();

			//			this.normalFont = normalFont;
			//			this.underlineFont = new Font(display, normalFont.getFontData());

			white = display.getSystemColor(SWT.COLOR_LIST_BACKGROUND);
			blue = display.getSystemColor(SWT.COLOR_BLUE);
			black = display.getSystemColor(SWT.COLOR_BLACK);
		}

		protected void setUnitToSuppressHyperlinkingFor(Unit unit) {
			unitToSuppressHyperlinkingFor = unit;
		}

		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof LinkRow) {
				LinkRow row = (LinkRow) element;
				return row.getColumnText(columnIndex);
			} else if (element instanceof LinkCategory) {
				if (columnIndex == LINK_TYPE) {
					LinkCategory category = (LinkCategory) element;
					return category.getText();
				}

				return ""; //$NON-NLS-1$
			} else if (element instanceof LinkDirection) {
				if (columnIndex == LINK_TYPE) {
					LinkDirection direction = (LinkDirection) element;
					return direction.getText();
				}

				return ""; //$NON-NLS-1$
			}

			return element.getClass().getName();
		}

		public Image getColumnImage(Object element, int columnIndex) {
			if (element instanceof LinkRow) {
				LinkRow row = (LinkRow) element;
				return row.getColumnImage(columnIndex);
			}

			if (element instanceof LinkCategory && columnIndex == LINK_TYPE) {
				LinkCategory category = (LinkCategory) element;
				return category.getImage();
			}

			return null;
		}

		public Color getBackground(Object element, int columnIndex) {
			return white;
		}

		public Color getForeground(Object element, int columnIndex) {
			if (showAsHyperlink(element, columnIndex, unitToSuppressHyperlinkingFor)) {
				return blue;
			}

			return black;

		}

		//		public Font getFont(Object element, int columnIndex) {
		//			if (showAsHyperlink(element, columnIndex)) {
		//				return normalFont;
		//			} else {
		//				return underlineFont;
		//			}
		//		}

		private boolean showAsHyperlink(Object element, int columnIndex, Unit unitToSuppressLinkingFor) {
			if (element instanceof LinkRow) {
				LinkRow row = (LinkRow) element;
				return row.showAsHyperlink(columnIndex, unitToSuppressLinkingFor);
			}

			return false;
		}

	} // end inner class LinkTreeLabelProvider

	/**
	 * Represents a Link in the UI as a three columns on a Table row.
	 * 
	 * @author Ed Snible
	 */
	public static abstract class LinkRow {

		private final boolean showIcon;

		protected LinkRow(@SuppressWarnings("hiding")
		boolean showIcon) {
			this.showIcon = showIcon;
		}

		/**
		 * @param columnIndex
		 * @param unitToSuppressLinkingFor
		 * @return should nth column of table be drawn as a hyperlink?
		 */
		public boolean showAsHyperlink(int columnIndex, Unit unitToSuppressLinkingFor) {
			if (columnIndex == LINK_TYPE) {
				return false;
			}

			//			boolean thisUnitIsSource = (unit == getSourceUnit());
			//			return (columnIndex == LINK_SOURCE) ^ thisUnitIsSource;
			if (columnIndex == LINK_SOURCE) {
				return unitToSuppressLinkingFor != getSourceUnit() && hasEditPart(getSourceUnit());
			}

			// LINK_TARGET
			return unitToSuppressLinkingFor != getTargetUnit() && hasEditPart(getTargetUnit());
		}

		//		/** Get the target of a traverse() */
		//		Unit getOpposite() {
		//			boolean traverseOpensTarget = (unit == getSourceUnit());
		//			return (traverseOpensTarget) ? getTargetUnit() : getSourceUnit();
		//		}

		/** Get the source Unit (the source, or the source's owner) */
		abstract Unit getTargetUnit();

		/** Get the target Unit (the target, or the target's owner) */
		abstract Unit getSourceUnit();

		void realize() {
			// do nothing, only off-diagram pseudo-links can be realized
		}

		boolean canRealize() {
			return false;
		}

		boolean canTraverse(boolean toTarget) {
			//			Unit opposite = getOpposite();
			Unit opposite = toTarget ? getTargetUnit() : getSourceUnit();
			return hasEditPart(opposite);
		}

		private boolean hasEditPart(Unit unit) {
			DeployCoreEditor activeEditDomain = ResourceUtils.getActiveDeployEditDomain();
			if (activeEditDomain != null) {
				DiagramEditPart diagramEditPart = activeEditDomain.getDiagramEditPart();
				if (diagramEditPart != null) {
					return GMFUtils.getEditPartsFor(diagramEditPart, unit).size() > 0;
				}
			}
			return false;
		}

		/**
		 * @return <code>true</code> if the link this row represents should appear deletable
		 */
		public abstract boolean canRemove();

		/**
		 * Delete the link this row represents
		 */
		public abstract void unlink();

		/**
		 * @param part
		 * @param toTarget
		 *           if <code>false</code>, traverse goes to source.
		 */
		void traverse(/* IWorkbenchPart part, */boolean toTarget) {
			//			Unit opposite = getOpposite();
			Unit opposite = toTarget ? getTargetUnit() : getSourceUnit();
			if (opposite != null) {
				PropertyUtils.reveal(opposite);
			}
		}

		String getSourceName() {
			return PropertyUtils.getName(getSourceUnit());
		}

		String getTargetName() {
			return PropertyUtils.getName(getTargetUnit());
		}

		/**
		 * @param columnIndex
		 * @return text to display at that column
		 */
		public String getColumnText(int columnIndex) {
			switch (columnIndex)
			{
			case LINK_TYPE:
				return getLinkName();
			case LINK_SOURCE:
				//				return PropertyUtils.getName(getSourceUnit());
				return getSourceName();
			case LINK_TARGET:
				//				return PropertyUtils.getName(getTargetUnit());
				return getTargetName();
			}

			return ""; //$NON-NLS-1$
		}

		/**
		 * Get display name for link
		 * 
		 * @return display name for link
		 */
		abstract public String getLinkName();

		//		/**
		//		 * Get display name for link type
		//		 */
		//		abstract String getLinkTypeName();

		/**
		 * @param columnIndex
		 * @return icon for nth colum of table
		 */
		final public Image getColumnImage(int columnIndex) {
			if (columnIndex == LINK_TYPE) {
				IStatus status = getStatus();

				if (!status.isOK()) {
					return PropertyUtils.getStatusTableImage(status);
				}

				if (showIcon) {
					return getLinkTypeImage();
				}
			}

			return null;
		}

		protected abstract Image getLinkTypeImage();

		/**
		 * @return status of the model object
		 */
		public abstract IStatus getStatus();

		/**
		 * Does DMO have a non-OK status?
		 * 
		 * @param dmo
		 * @return <code>true</code> if 'dmo' has non-OK Status
		 */
		public static boolean errorStatus(DeployModelObject dmo) {
			return dmo.getStatus() != null && dmo.getStatus().getSeverity() != IStatus.OK;
		}

		/**
		 * @return a hover message, or null if there should be no message
		 */
		abstract String getHoverTooltip();

		/**
		 * Return a DeployModelObject suitable for calculating resolutions, or null if there is no
		 * such object or there is no wish to have a popup list of resolutions.
		 * 
		 * <p>
		 * This is also the object which is used for attaching {@link Constraint}s.
		 * 
		 * @return a DeployModelObject (usually with an error status)
		 */
		public abstract DeployModelObject getObjectForPopup();
	}

	private static class DependencyLinkRow extends LinkRow {

		private final DependencyLink link;

		protected DependencyLinkRow(boolean showIcon, @SuppressWarnings("hiding")
		DependencyLink link) {
			super(showIcon);
			this.link = link;
		}

		//		public Image getColumnImage(int columnIndex) {
		//			if (columnIndex == LINK_TYPE) {
		//				return PropertyUtils.getStatusTableImage(link.getStatus());
		//			}
		//			
		//			return null;
		//		}

		public void unlink() {
			PropertyUtils.deleteLinkElementAndView(link);
//			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(link);
//			Command c = PropertyUtils.getRemoveCommand(link, domain);
//			executeEmfCommand(c, domain);
		}

		public boolean canRemove() {
			return PropertyUtils.canRemove(link);
		}

		String getHoverTooltip() {
			if (errorStatus(link)) {
				return SoaDeployUiUtil.getStatusMessage(link.getStatus());
			}

			return null;
		}

		public DeployModelObject getObjectForPopup() {
			return link;
		}

		Unit getSourceUnit() {
			return (Unit) link.getSource().getParent();
		}

		Unit getTargetUnit() {
			// This happens if there is no target, or if the target URI
			// is corrupt.
			if (link.getTarget() == null) {
				return null;
			}

			return (Unit) link.getTarget().getParent();
		}

		public String getLinkName() {
			return PropertyUtils.getName(link);
		}

		String getSourceName() {
			Requirement req = link.getSource();
			//			return PropertyUtils.getName(req) + " in " + super.getSourceName();
			String s1 = PropertyUtils.getName(req);
			String s2 = super.getSourceName();
			return NLS.bind(Messages.LinksPropertySection2_0_in_1_, new Object[] { s1, s2 });
		}

		String getTargetName() {
			Capability cap = link.getTarget();
			return cap.getCaptionProvider().titleWithContext(cap);
		}

		@Override
		protected Image getLinkTypeImage() {
			return LinkCategory.getDependencyLinkTypeImage();
		}

		@Override
		public IStatus getStatus() {
			return link.getStatus();
		}
	}

	private static class LogicalLinkRow extends LinkRow {

		private final ConstraintLink link;

		protected LogicalLinkRow(boolean showIcon, @SuppressWarnings("hiding")
		ConstraintLink link) {
			super(showIcon);
			this.link = link;
		}

		//		public Image getColumnImage(int columnIndex) {
		//			if (columnIndex == LINK_TYPE) {
		//				return PropertyUtils.getStatusTableImage(link.getStatus());
		//			}
		//			
		//			return null;
		//		}

		/**
		 * Figure out which Unit to name on behalf of a logical link. (This screen display source and
		 * target units, which the user is familiar with, rather than trying to name specific inner
		 * parts of the Unit the link actually points too.)
		 */
		private Unit getUnitFor(DeployModelObject dmo) {
			if (dmo instanceof Unit) {
				return (Unit) dmo;
			} else if (dmo instanceof Capability) {
				return (Unit) dmo.getParent();
			} else if (dmo instanceof Requirement) {
				return (Unit) dmo.getParent();
			}

			return null;
		}

		Unit getTargetUnit() {
			return getUnitFor(link.getTarget());
		}

		Unit getSourceUnit() {
			return getUnitFor(link.getSource());
		}

		public void unlink() {
			PropertyUtils.deleteLinkElementAndView(link);
//			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(link);
//			Command c = PropertyUtils.getRemoveCommand(link, domain);
//			executeEmfCommand(c, domain);
		}

		public boolean canRemove() {
			return PropertyUtils.canRemove(link);
			//			return DeployModelObjectUtil.isMutable(unit) && !PropertyUtils.isProxy(link);
		}

		String getHoverTooltip() {
			if (errorStatus(link)) {
				return SoaDeployUiUtil.getStatusMessage(link.getStatus());
			}

			return null;
		}

		public DeployModelObject getObjectForPopup() {
			return link;
		}

		public String getLinkName() {
			return PropertyUtils.getName(link);
		}

		@Override
		protected Image getLinkTypeImage() {
			return LinkCategory.getConstraintLinkTypeImage();
		}

		@Override
		public IStatus getStatus() {
			return link.getStatus();
		}
	} // end inner class LogicalLinkRow

	private static class RealizationLinkRow extends LinkRow {

		private final RealizationLink link;

		protected RealizationLinkRow(boolean showIcon, @SuppressWarnings("hiding")
		RealizationLink link) {
			super(showIcon);
			this.link = link;
		}

		public boolean canRemove() {
			return PropertyUtils.canRemove(link);
		}

		//		public Image getColumnImage(int columnIndex) {
		//			if (columnIndex == LINK_TYPE) {
		//				return PropertyUtils.getStatusTableImage(link.getStatus());
		//			}
		//			
		//			return null;
		//		}

		String getHoverTooltip() {
			if (errorStatus(link)) {
				return SoaDeployUiUtil.getStatusMessage(link.getStatus());
			}

			return null;
		}

		public DeployModelObject getObjectForPopup() {
			return link;
		}

		public void unlink() {
			PropertyUtils.deleteLinkElementAndView(link);
//			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(link);
//			Command c = PropertyUtils.getRemoveCommand(link, domain);
//			executeEmfCommand(c, domain);
		}

		Unit getSourceUnit() {
			return link.getSource() instanceof Unit ? (Unit) link.getSource() : null;
		}

		Unit getTargetUnit() {
			return link.getTarget() instanceof Unit ? (Unit) link.getTarget() : null;
		}

		public String getLinkName() {
			return PropertyUtils.getName(link);
		}

		@Override
		protected Image getLinkTypeImage() {
			return LinkCategory.getRealizationLinkTypeImage();
		}

		@Override
		public IStatus getStatus() {
			return link.getStatus();
		}
	} // end inner class RealizationLinkRow

	private static class HostingLinkRow extends LinkRow {

		private final HostingLink link;

		protected HostingLinkRow(boolean showIcon, @SuppressWarnings("hiding")
		HostingLink link) {
			super(showIcon);
			this.link = link;

			assert link != null;
		}

		//		public Image getColumnImage(int columnIndex) {
		//			if (columnIndex == LINK_TYPE) {
		//				return PropertyUtils.getStatusTableImage(link.getStatus());
		//			}
		//			
		//			return null;
		//		}

		public void unlink() {
			PropertyUtils.deleteLinkElementAndView(link);
//			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(link);
//			Command c = PropertyUtils.getRemoveCommand(link, domain);
//			executeEmfCommand(c, domain);
		}

		public boolean canRemove() {
			//			return DeployModelObjectUtil.isMutable(unit) && !PropertyUtils.isProxy(link);
			return PropertyUtils.canRemove(link);
		}

		String getHoverTooltip() {
			if (errorStatus(link)) {
				return SoaDeployUiUtil.getStatusMessage(link.getStatus());
			}

			return null;
		}

		public DeployModelObject getObjectForPopup() {
			return link;
		}

		Unit getSourceUnit() {
			return link.getSource();
		}

		Unit getTargetUnit() {
			return link.getTarget();
		}

		public String getLinkName() {
			return PropertyUtils.getName(link);
		}

		@Override
		protected Image getLinkTypeImage() {
			return LinkCategory.getHostingLinkTypeImage();
		}

		@Override
		public IStatus getStatus() {
			return link.getStatus();
		}
	} // end inner class HostingLinkRow

	private static class MemberLinkRow extends LinkRow {

		private final MemberLink link;

		protected MemberLinkRow(boolean showIcon, @SuppressWarnings("hiding")
		MemberLink link) {
			super(showIcon);
			this.link = link;

			assert link != null;
		}

		//		public Image getColumnImage(int columnIndex) {
		//			if (columnIndex == LINK_TYPE) {
		//				return PropertyUtils.getStatusTableImage(link.getStatus());
		//			}
		//			
		//			return null;
		//		}

		public void unlink() {
			PropertyUtils.deleteLinkElementAndView(link);
//			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(link);
//			Command c = PropertyUtils.getRemoveCommand(link, domain);
//			executeEmfCommand(c, domain);
		}

		public boolean canRemove() {
			//			return DeployModelObjectUtil.isMutable(unit) && !PropertyUtils.isProxy(link);
			return PropertyUtils.canRemove(link);
		}

		String getHoverTooltip() {
			if (errorStatus(link)) {
				return SoaDeployUiUtil.getStatusMessage(link.getStatus());
			}

			return null;
		}

		public DeployModelObject getObjectForPopup() {
			return link;
		}

		String getLinkTypeName() {
			return PropertyUtils.getName(link);
		}

		Unit getSourceUnit() {
			return link.getSource();
		}

		Unit getTargetUnit() {
			return link.getTarget();
		}

		public String getLinkName() {
			return PropertyUtils.getName(link);
		}

		@Override
		protected Image getLinkTypeImage() {
			return LinkCategory.getMemberLinkTypeImage();
		}

		@Override
		public IStatus getStatus() {
			return link.getStatus();
		}
	} // end inner class MemberLinkRow

	private static class UnitDescriptorLinkRow extends LinkRow {

		/**
		 * Hosting
		 */
		static public int HOSTING_TYPE = 0;

		/**
		 * Dependency
		 */
		static public int DEPENDENCY_TYPE = 1;

		private final UnitDescriptor ud;
		private final boolean isOut;

		private final Unit unit;
		private final int linkType;

		/**
		 * @param showIcon
		 * @param descriptor
		 * @param unit
		 * @param isOut
		 * @param linkType
		 */
		public UnitDescriptorLinkRow(boolean showIcon, UnitDescriptor descriptor,
				@SuppressWarnings("hiding")
				Unit unit, @SuppressWarnings("hiding")
				boolean isOut, @SuppressWarnings("hiding")
				int linkType) {
			super(showIcon);
			ud = descriptor;
			this.unit = unit;
			this.isOut = isOut;
			this.linkType = linkType;
		}

		//		public Image getColumnImage(int columnIndex) {
		//			return null;
		//		}

		String getSourceName() {
			return getSourceUnit() == null ? ud.getDisplayName() : PropertyUtils
					.getName(getSourceUnit());
		}

		String getTargetName() {
			return getTargetUnit() == null ? ud.getDisplayName() : PropertyUtils
					.getName(getTargetUnit());
		}

		public void unlink() {
			// We shouldn't reach here, these links aren't unlinkable
		}

		boolean canTraverse() {
			return false;
		}

		public boolean canRemove() {
			return false;
		}

		public boolean canRealize() {
			//			return PropertyUtils.isMutable(unit.getTopology()); 
			return DeployModelObjectUtil.isMutable(unit.getTopology());
		}

		void realize() {

			PropertyUtils.executeWithUndo(unit, Messages.LinksPropertySection_7, new Runnable() {

				public void run() {
					Topology top = unit.getTopology();
					DeployModelObject newUnit = ud.getUnitValueAndAddToTopology(top);
					DeployCoreEditor.visualize(Collections.singletonList(newUnit));
				}
			});
		}

		String getHoverTooltip() {
			// No statuses on UnitDescriptors; so link cannot be in error
			return null;
		}

		public DeployModelObject getObjectForPopup() {
			return null;
		}

		//		String getLinkTypeName() {
		//			return getLinkType();
		//		}

		Unit getSourceUnit() {
			return isOut ? unit : null;
		}

		Unit getTargetUnit() {
			return isOut ? null : unit;
		}

		public String getLinkName() {
			String retVal = ud.getDisplayName();
			return retVal != null ? retVal : "<null>"; //$NON-NLS-1$
		}

		@Override
		protected Image getLinkTypeImage() {
			if (linkType == HOSTING_TYPE) {
				return LinkCategory.getHostingLinkTypeImage();
			} else if (linkType == DEPENDENCY_TYPE) {
				return LinkCategory.getDependencyLinkTypeImage();
			}

			return null;
		}

		@Override
		public IStatus getStatus() {
			return Status.OK_STATUS;
		}
	} // end inner class UnitDescriptorLinkRow

	/**
	 * Provide hover explaination of error status on Tables of {@link LinkRow}.
	 * 
	 * @author Ed Snible
	 */
	public static class LinkRowHoverListener implements MouseTrackListener, MouseListener {

		private ToolTipHelper toolTip;
		private final Control control;
		//		private IWorkbenchPart part;
		//		private EditDomain gefDomain;
		private Unit unitToSuppressHyperlinkingTo;

		/**
		 * @param control
		 */
		public LinkRowHoverListener(@SuppressWarnings("hiding")
		Control control) {
			this(control, null);
		}

		/**
		 * @param control
		 * @param hyperlinkSuppressUnit
		 */
		public LinkRowHoverListener(@SuppressWarnings("hiding")
		Control control, Unit hyperlinkSuppressUnit) {
			this.control = control;
			unitToSuppressHyperlinkingTo = hyperlinkSuppressUnit;
		}

		protected void setInput(Unit unit) {
			unitToSuppressHyperlinkingTo = unit;
		}

		public void mouseEnter(MouseEvent e) {
			// do nothing
		}

		public void mouseExit(MouseEvent e) {
			// do nothing
		}

		public void mouseHover(MouseEvent e) {
			String tipText = null;

			if (overIcon(e)) {
				Object data = getTableItemData(e.widget, e.x, e.y);
				if (data instanceof LinkRow) {
					LinkRow row = (LinkRow) data;
					tipText = row.getHoverTooltip();
				}
			}

			if (tipText != null) {
				Point ptAbs = ((Tree) e.widget).toDisplay(new org.eclipse.swt.graphics.Point(e.x, e.y));
				Label draw2dLabel = new Label();
				draw2dLabel.setText(tipText);
				getToolTipHelper().displayToolTipNear(new Label(), draw2dLabel, ptAbs.x, ptAbs.y);
			} else {
				// Remove existing tooltip
				getToolTipHelper().updateToolTip(null, null, 0, 0);
			}
		}

		private boolean overIcon(MouseEvent e) {
			// Get the 'Type' column bounds
			Rectangle bounds = getBounds(e, LINK_TYPE);
			if (bounds == null) {
				return false;
			}

			// The rectangle seems to be for the text area, not the icon,
			// so check if the click has a negative offset from the bounds.
			int xRel = e.x - bounds.x;
			return 0 < xRel && xRel <= 16;
		}

		private Rectangle getBounds(MouseEvent e, int column) {
			if (e.widget instanceof Tree) {
				return getBounds((Tree) e.widget, e.x, e.y, column);
			}
			return getBounds((Table) e.widget, e.x, e.y, column);
		}

		private Rectangle getBounds(Table table, int x, int y, int column) {
			TableItem item = table.getItem(new Point(x, y));

			if (item == null) {
				return null;
			}

			// The rectangle seems to be for the text area, not the icon
			return item.getBounds(column);
		}

		private Rectangle getBounds(Tree tree, int x, int y, int column) {
			TreeItem item = tree.getItem(new Point(x, y));

			if (item == null) {
				return null;
			}

			// The rectangle seems to be for the text area, not the icon,
			// so check if the click has a negative offset from the bounds.
			return item.getBounds(column);
		}

		private ToolTipHelper getToolTipHelper() {
			if (toolTip == null) {
				toolTip = new ToolTipHelper(control);
			}
			return toolTip;
		}

		private Object getTableItemData(Widget widget, int x, int y) {
			if (widget instanceof Tree) {
				Tree table = (Tree) widget;
				TreeItem item = table.getItem(new Point(x, y));
				if (item != null) {
					return item.getData();
				}
			} else if (widget instanceof Table) {
				Table table = (Table) widget;
				TableItem item = table.getItem(new Point(x, y));
				if (item != null) {
					return item.getData();
				}
			}

			return null;
		}

		public void mouseDoubleClick(MouseEvent e) {
			// do nothing
		}

		public void mouseDown(MouseEvent e) {
			// do nothing
		}

		public void mouseUp(MouseEvent e) {
			Object data = getTableItemData(e.widget, e.x, e.y);
			if (data instanceof LinkRow) {
				LinkRow row = (LinkRow) data;
				if (overIcon(e)) {
					DeployModelObject dmo = row.getObjectForPopup();
					popupResolutions(dmo);
				} else if (overHyperlink(e, row, LINK_SOURCE)) {
					row.traverse(/* part, */false);
				} else if (overHyperlink(e, row, LINK_TARGET)) {
					row.traverse(/* part, */true);
				}
			}
		}

		private boolean overHyperlink(MouseEvent e, LinkRow row, int columnIndex) {

			if (getBounds(e, columnIndex).contains(e.x, e.y)) {
				return row.showAsHyperlink(columnIndex, unitToSuppressHyperlinkingTo);
			}

			return false;
		}

		@SuppressWarnings("unchecked")
		private void popupResolutions(DeployModelObject selectedDMO) {
			IMarker[] markers = SoaDeployUiUtil.getMarkers(selectedDMO).toArray(new IMarker[0]);
			if (markers.length > 0 || !selectedDMO.getStatus().isOK()) {
				MarkerResolutionHelper mrh = new MarkerResolutionHelper(markers);
				QuickFixDialog popup = new QuickFixDialog(selectedDMO.getTopology(), mrh, selectedDMO
						.getStatus(), PlatformUI.getWorkbench().getDisplay().getCursorLocation(), true);
				popup.open();
			}
		}

	} // end inner class LinkRowHoverListener

	/**
	 * @param deployLink
	 * @param showIcon
	 * @return a row representing a link
	 */
	public static LinkRow createRowForLink(DeployLink deployLink, boolean showIcon) {
		if (deployLink instanceof ConstraintLink) {
			ConstraintLink link = (ConstraintLink) deployLink;
			return new LogicalLinkRow(showIcon, link);
		} else if (deployLink instanceof DependencyLink) {
			DependencyLink link = (DependencyLink) deployLink;
			return new DependencyLinkRow(showIcon, link);
		} else if (deployLink instanceof MemberLink) {
			MemberLink link = (MemberLink) deployLink;
			return new MemberLinkRow(showIcon, link);
		} else if (deployLink instanceof HostingLink) {
			HostingLink link = (HostingLink) deployLink;
			return new HostingLinkRow(showIcon, link);
		} else if (deployLink instanceof RealizationLink) {
			RealizationLink link = (RealizationLink) deployLink;
			return new RealizationLinkRow(showIcon, link);
		}

		return null;
	}

	private class LinkPropertiesModifier implements ICellModifier {

		public boolean canModify(Object element, String property) {
			// These names are hard-coded, not modeled
			if (element instanceof UnitDescriptorLinkRow) {
				return false;
			}

			if (element instanceof LinkRow) { // (exclude LinkCategory or LinkDirection)
				if (property.equals(Messages.RequirementsPropertySection5_Lin_)) {
					return true;
				}
			}
			return false;
		}

		public Object getValue(Object element, String property) {

			if (element instanceof LinkRow) {
				if (property.equals(Messages.RequirementsPropertySection5_Lin_)) {
					LinkRow row = (LinkRow) element;
					return row.getLinkName();
				}
			}
			return ""; //$NON-NLS-1$
		}

		public void modify(Object element, String property, Object value) {
			// Note that it is possible for an SWT Item to be passed instead of the model element.
			if (element instanceof Item) {
				element = ((Item) element).getData();
				if (element instanceof LinkRow) {
					if (property.equals(Messages.RequirementsPropertySection5_Lin_)) {
						LinkRow row = (LinkRow) element;
						DeployModelObject dmo = row.getObjectForPopup();
						if (dmo != null) {
							String newValue = value.toString();
							if (!dmo.getName().equals(newValue)) {
								setDisplayName(dmo, newValue);
							}
						}
					}
				}
			}

			treeViewer.refresh();
		}

	} // end inner class LinkPropertiesModifier 

	/**
	 * @param dmo
	 * @param name
	 */
	public static void setDisplayName(final DeployModelObject dmo, final String name) {
		// Don't do anything if the name isn't changing.
		if (name.equals(dmo.getDisplayName())) {
			return;
		}

		String msg = NLS
				.bind(Messages.LinksPropertySection2_Set_Display_Name_, new Object[] { name });
		PropertyUtils.executeWithUndo(dmo, msg, new Runnable() {

			public void run() {
				//5635: Link label remains even when link name value is cleared
				if (name == null || name.trim().length() == 0 || name.equals(dmo.getName())) {
					dmo.setDisplayName(null);
				} else {
					dmo.setDisplayName(name);
				}
			}
		});

	}

} // end class LinksPropertySection2
