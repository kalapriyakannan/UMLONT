/***************************************************************************************************
 * Copyright (c) 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved. US
 * Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.ui.validator.resolution;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.util.IObjectFilter;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.infrastructure.internal.emf.DynamicAdapterFactory;

/**
 * Composite that shows {@link Topology} hosting stacks in a tree-like format.
 * 
 * @author Ed Snible
 */
public class TopTreeComposite extends Composite {

	private final TreeViewer tv;
	private final TreeRepresentationLabelProvider labelProvider;
	private EnablementFunction enablementFunction;
	private Map<Unit, TRNode> unitToNode;
	private ViewerFilter currentFilter;
	private IObjectFilter<Unit> iofilter;

	/**
	 * @param parent
	 */
	public TopTreeComposite(Composite parent) {
		super(parent, SWT.NULL);
		GridLayout gl = new GridLayout();
//		gl.marginLeft = gl.marginRight = gl.marginTop = gl.marginBottom = 1;
//		gl.verticalSpacing = gl.horizontalSpacing = 0;
		gl.marginWidth = 0;
		gl.marginHeight = 0;
		setLayout(gl);

		Tree table = new Tree(this, SWT.V_SCROLL | SWT.BORDER);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		tv = new TreeViewer(table);
		tv.setContentProvider(getTreeContentProvider());
		// Using the SOA Label provider starts GMF, so it is expensive in a non-GMF app.
		// Also, GMF will throw an IllegalStateException from UIModificationValidator$1.run()
		// if it is called and no Workbench has been created.
		labelProvider = getTreeLabelProvider();
		tv.setLabelProvider(labelProvider);
//		tv.addFilter(getNonConfigFilter());

//		this.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
	}

	/**
	 * @param units
	 */
	public void setInput(List<Unit> units) {
//		System.out.println("@@@ TopTreeComposite given " + units.size() + " Unit(s) as input"); //$NON-NLS-1$//$NON-NLS-2$
//		tv.setInput(TreeRepresentation.topologyToTree(units));
		TRNode root = unitsToTree(units);
		refreshMap(root);
		tv.setInput(root);
		tv.expandAll();
	}

	private void refreshMap(TRNode node) {
		unitToNode = new HashMap<Unit, TRNode>();
		refreshMap2(node);
	}

	// RECURSIVE
	private void refreshMap2(TRNode node) {
		if (node.getUnit() != null) {
			unitToNode.put(node.getUnit(), node);
		}

		for (TRNode child : node.getChildren()) {
			refreshMap2(child);
		}
	}

	/**
	 * @param slc
	 */
	public void addSelectionChangedListener(ISelectionChangedListener slc) {
		tv.addSelectionChangedListener(slc);
	}

	/**
	 * @param newEnabled
	 */
	public void setEnablementFunction(EnablementFunction newEnabled) {
		enablementFunction = newEnabled;
		labelProvider.setEnablementFunction(newEnabled);
	}

	/**
	 * @since 7.0
	 * 
	 */
	public abstract static class EnablementFunction {

		/**
		 * @param obj
		 * @return true if should appear as enabled/selectable
		 */
		public abstract boolean isEnabled(Object obj);

	}

	/**
	 * 
	 */
	public void refresh() {
		tv.refresh();
	}

	/**
	 * @return the selected Unit, or null if none
	 */
	public Unit getSelection() {
		Unit u = getRawSelection();
		if (!enabled(u)) {
			return null;
		}

		return u;
	}

	/**
	 * 
	 */
	public void clearSelection() {
		tv.setSelection(new StructuredSelection());
	}

	/**
	 * @param unit
	 */
	public void setSelection(Unit unit) {
		TRNode node = unitToNode.get(unit);
		if (node != null) {
			tv.setSelection(new StructuredSelection(node));
		}
	}

	private boolean enabled(Unit u) {
		return enablementFunction == null || enablementFunction.isEnabled(u);
	}

	private Unit getRawSelection() {
		ISelection sel = tv.getSelection();
		if (sel instanceof StructuredSelection) {
			StructuredSelection ss = (StructuredSelection) sel;
			if (ss.getFirstElement() instanceof TRNode) {
				TRNode node = (TRNode) ss.getFirstElement();
				return node.getUnit();
			}
		}

		return null;
	}

	/**
	 * @param units
	 *           Collection of all Units to appear in the returned TRNode
	 * 
	 * @return a true tree, not a graph
	 */
	public static TRNode unitsToTree(Collection<Unit> units) {
		// We can't use TopologyUtil.sequenceTopologyHostingStack() because it demands installed units

		// Root node to be returned as the tree
		TRNode root = new TRNode();

		// 'candidates' starts as the children of the root
		Queue<TRNode> candidates = new LinkedList<TRNode>(getUnhostedUnits(units, root));

		// 'memory' remembers Units we've seen before
		Set<Unit> memory = new HashSet<Unit>();

		while (!candidates.isEmpty()) {
//			System.out.println("@@@ " + candidates.size() + " candidates"); //$NON-NLS-1$//$NON-NLS-2$
			TRNode candidate = candidates.remove();
//			System.out.println("@@@ Considering " + dumpNodeName(candidate)); //$NON-NLS-1$
			// BUG CUTS HOSTING STACKS IF ALL MEMBERS AREN'T IN 'units'
			if (firstTime(candidate, memory) && units.contains(candidate.getUnit())) {
				memory.add(candidate.getUnit());
//				System.out.println("@@@ Adding " //$NON-NLS-1$
//						+ dumpNodeName(candidate) + " to " //$NON-NLS-1$
//						+ dumpNodeName(candidate.getParent()));
				candidate.getParent().add(candidate);
				Collection<TRNode> rawChildren = getRawChildren(candidate);
//				System.out.println("@@@ " + dumpNodeName(candidate) //$NON-NLS-1$
//						+ " has " + rawChildren.size() + " child(ren)"); //$NON-NLS-1$//$NON-NLS-2$
				candidates.addAll(rawChildren);
//			} else if (firstTime(candidate, memory)) {
//				System.out
//						.println("@@@ Excluding " + dumpNodeName(candidate) + " because it isn't in our 'set'"); //$NON-NLS-1$//$NON-NLS-2$
			}
		}

		return root;
	}

//	private static String dumpNodeName(TRNode trn) {
//		Unit u = trn.getUnit();
//		if (u == null) {
//			return "<null>"; //$NON-NLS-1$
//		}
//
//		return u.getCaptionProvider().title(u);
//	}

	private static Collection<TRNode> getRawChildren(TRNode trnode) {
		List<TRNode> retVal = new LinkedList<TRNode>();

		for (Unit u : ValidatorUtils.getImmediateHosted(trnode.getUnit())) {
			retVal.add(new TRNode(u, trnode));
		}
		for (Unit u : ValidatorUtils.getImmediateMembers(trnode.getUnit())) {
			retVal.add(new TRNode(u, trnode));
		}

//		System.out
//				.println("@@@ Unit " + trnode.getUnit().getCaptionProvider().title(trnode.getUnit()) + " has " + retVal.size() + " children"); //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$

		return retVal;
	}

	private static boolean firstTime(TRNode node, Set<Unit> memory) {
		return !memory.contains(node.getUnit());
	}

//	private static List<TRNode> getUnhostedUnits(Topology topology, TRNode root) {
//		List<TRNode> retVal = new LinkedList<TRNode>();
//		
//		for (Unit u : (List<Unit>) topology.getUnits()) {
//			if (ValidatorUtils.getImmediateHost(u) == null) {
//				retVal.add(new TRNode(u, root));
//			}
//		}
//		return retVal;
//	}

	/**
	 * Given a collection of Units, return those units that aren't hosted/grouped by other members of
	 * the collection.
	 * 
	 * <p>
	 * Note: doesn't break recursion, so if A contains B and B is hosted by A the result is the empty
	 * collection.
	 */
	private static Collection<Unit> getUnhostedUnits(Collection<Unit> units) {
		Collection<Unit> retVal = new LinkedList<Unit>();

		for (Unit u : units) {
			boolean hosted = units.contains(ValidatorUtils.getImmediateHost(u));
			if (!hosted && emptyIntersection(ValidatorUtils.getImmediateGroups(u), units)) {
				retVal.add(u);
			}
		}

		return retVal;
	}

	private static boolean emptyIntersection(Collection<?> c1, Collection<?> c2) {
		for (Object o : c1) {
			if (c2.contains(o)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 
	 * <p>
	 * All returned tree nodes will be children of 'root'.
	 */
	private static List<TRNode> getUnhostedUnits(Collection<Unit> units, TRNode root) {
		List<TRNode> retVal = new LinkedList<TRNode>();

//		for (Unit u : units) {
////			System.out.println(u.eClass().getName() + '/' + u.getDisplayName() + '/' + TopologyUtil.getImmediateRealizationLinksOut(u).size());
//			if (ValidatorUtils.getImmediateHost(u) == null) {
//				// We don't want to consider unhosted things like WasCellUnit as the root of a visual tree
//				if (ValidatorUtils.getImmediateGroups(u).size() == 0) {
//					retVal.add(new TRNode(u, root));
//				}
//			}
//		}

		for (Unit u : getUnhostedUnits(units)) {
			retVal.add(new TRNode(u, root));
		}

		return retVal;
	}

	private static ITreeContentProvider getTreeContentProvider() {
		return new TreeRepresentationContentProvider();
	}

	private static TreeRepresentationLabelProvider getTreeLabelProvider() {
		return new TreeRepresentationLabelProvider();
	}

//	/**
//	 * @return a content provider for TRNodes
//	 */
//	public static ViewerFilter getNonConfigFilter() {
//		return new TreeRepresentationNonConfigViewerFilter();
//	}

	private static class TreeRepresentationContentProvider implements ITreeContentProvider {

		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof TRNode) {
//				Unit u = ((TRNode) parentElement).getUnit();
//				if (u != null) {
//					if (((TRNode) parentElement).getChildren() == null) {
//						System.out.println("Null children for " + u.getCaptionProvider().title(u)); //$NON-NLS-1$
//					} else {
//						System.out
//								.println("@@@TRCP says " + u.getCaptionProvider().title(u) + " has " + ((TRNode) parentElement).getChildren().size() + " children"); //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
//					}
//				} else {
//					System.out.println("Null node"); //$NON-NLS-1$
//				}
				return ((TRNode) parentElement).getChildren().toArray();
			}

			return null;
		}

		public Object getParent(Object element) {
			return null;
		}

		public boolean hasChildren(Object element) {
			if (getChildren(element) == null) {
				return false;
			}

			return getChildren(element).length > 0;
		}

		public Object[] getElements(Object inputElement) {
			return getChildren(inputElement);
		}

		public void dispose() {
			// do nothing
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// do nothing
		}

	}

	/**
	 * @since 7.0
	 * 
	 */
	public static class TreeRepresentationLabelProvider extends LabelProvider implements
			IColorProvider {

		private static final Color WHITE = Display.getDefault().getSystemColor(
				SWT.COLOR_LIST_BACKGROUND);

		private static final Color GREY = Display.getDefault().getSystemColor(SWT.COLOR_GRAY);

		private static final Color BLACK = Display.getDefault().getSystemColor(
				SWT.COLOR_LIST_FOREGROUND);

		ILabelProvider lp = new AdapterFactoryLabelProvider(new DynamicAdapterFactory(null));
		private EnablementFunction enablement;

		private final Map<Image, Image> disabledImages = new HashMap<Image, Image>();

		@Override
		public Image getImage(Object element) {
			if (element instanceof TRNode) {
				Unit unit = ((TRNode) element).getUnit();
				if (!enabled(unit)) {
//					return NOSMOKING;
					return disabledImage(unit);
				}

				return lp.getImage(unit);
			}

			return null;
		}

		private Image disabledImage(Unit unit) {
			Image raw = lp.getImage(unit);
			// If there is no raw image don't try to disable it. 
			if (raw == null) {
				return null;
			}

			Image dis = disabledImages.get(raw);
			if (dis == null) {
				dis = generateDisabled(raw);
				disabledImages.put(raw, dis);
			}
			return dis;
		}

		private Image generateDisabled(Image raw) {
			return new Image(Display.getDefault(), raw, SWT.IMAGE_DISABLE);
		}

		private boolean enabled(Unit unit) {
			return enablement == null || enablement.isEnabled(unit);
		}

		@Override
		public String getText(Object element) {
			if (element instanceof TRNode) {
//				return lp.getText(((TRNode) element).getUnit());
				return PropertyUtils.getSoaLabelProvider().getText(((TRNode) element).getUnit());
			}

			return element.toString();
		}

		/**
		 * @param newEnabled
		 */
		public void setEnablementFunction(EnablementFunction newEnabled) {
			enablement = newEnabled;
		}

		public Color getBackground(Object element) {
			return WHITE;
		}

		public Color getForeground(Object element) {
			if (element instanceof TRNode) {
				Unit unit = ((TRNode) element).getUnit();
				if (!enabled(unit)) {
					return GREY;
				}
			}

			return BLACK;
		}

		@Override
		public void dispose() {
			for (Image img : disabledImages.values()) {
				img.dispose();
			}

			super.dispose();
		}
	}

	private static class TRNode {

		private final Unit unit;
		private final TRNode p;
		private final List<TRNode> children;

		protected TRNode() {
			this(null, null);
		}

		protected List<TRNode> getChildren() {
			return Collections.unmodifiableList(children);
		}

		protected TRNode(Unit u, TRNode parent) {
			unit = u;
			p = parent;
			children = new LinkedList<TRNode>();
		}

		protected void add(TRNode trnode) {
			children.add(trnode);
		}

		protected TRNode getParent() {
			return p;
		}

		protected Unit getUnit() {
			return unit;
		}

	}

//	private static class TreeRepresentationNonConfigViewerFilter extends ViewerFilter {
//
//		@Override
//		public boolean select(Viewer viewer, Object parentElement, Object element) {
//
//			if (element instanceof TRNode) {
//				return !((TRNode) element).getUnit().isConfigurationUnit();
//			}
//			return false;
//		}
//
//	}

	private static class TreeRepresentationUnwrapperViewerFilter extends ViewerFilter {

//		private final ViewerFilter viewerFilter;
		private final IObjectFilter<Unit> iofilter;

//		private TreeRepresentationUnwrapperViewerFilter(ViewerFilter filter) {
//			viewerFilter = filter;
//		}

		private TreeRepresentationUnwrapperViewerFilter(IObjectFilter<Unit> filter) {
			assert filter != null;
			iofilter = filter;
		}

		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {

			if (element instanceof TRNode /* && parentElement instanceof TRNode */) {
//				return viewerFilter.select(viewer, ((TRNode) parentElement).getUnit(),
//						((TRNode) element).getUnit());
				return iofilter.accept(((TRNode) element).getUnit());
			}

			return false;
		}
	}

	/**
	 * @return controls that shouldn't be colored by their container
	 */
	public Collection<Control> getBackgroundColorExclusions() {
		return Collections.singletonList(tv.getControl());
	}

	/**
	 * @return filter we are applying over input
	 */
	public IObjectFilter<Unit> getFilter() {
		return iofilter;
	}

	/**
	 * @param filter
	 */
	synchronized public void setFilter(IObjectFilter<Unit> filter) {
		iofilter = filter;

		//
		if (currentFilter != null) {
			tv.removeFilter(currentFilter);
			currentFilter = null;
		}

		if (filter != null) {
			currentFilter = new TreeRepresentationUnwrapperViewerFilter(filter);
			tv.addFilter(currentFilter);
		}

		tv.expandAll();
	}

//	/**
//	 * @param viewerFilter
//	 */
//	synchronized public void setViewerFilter(ViewerFilter viewerFilter) {
//
//		if (currentFilter != null) {
//			tv.removeFilter(currentFilter);
//			currentFilter = null;
//		}
//
//		if (viewerFilter != null) {
//			currentFilter = new TreeRepresentationUnwrapperViewerFilter(viewerFilter);
//			tv.addFilter(currentFilter);
//		}
//	}

}
