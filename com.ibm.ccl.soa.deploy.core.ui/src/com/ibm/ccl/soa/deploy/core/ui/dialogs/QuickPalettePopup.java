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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.gef.Tool;
import org.eclipse.gef.internal.InternalImages;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.gef.palette.SelectionToolEntry;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.services.palette.PaletteToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.misc.StringMatcher;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.actions.QuickPaletteDialogHandler;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;

/**
 * A popup dialog resembling the Java 'Quick Outline' (control-O) dialog. Ours lists GEF Palette
 * items rather than Java methods. Selecting a palette item starts the palette tool
 * 
 * @author Ed Snible
 * @see QuickPaletteDialogHandler
 */
public class QuickPalettePopup extends PopupDialog {

	private Text textFilter;
	private TopologyOutlineFilter filter;
	private TreeViewer tviewer;
	private final IWorkbenchPart wbPart;
	private final DiagramEditPart dgm;

	private static List<String> lastSelections = null;

	/**
	 * @param parentShell
	 * @param diagram
	 * @param part
	 */
	public QuickPalettePopup(Shell parentShell, DiagramEditPart diagram, IWorkbenchPart part) {
		super(parentShell, SWT.RESIZE, true, false, true, false,
				"", Messages.QuickPalettePopup_Click_to_add_to_diagra_); //$NON-NLS-1$

		dgm = diagram;
		wbPart = part;
//		setInfoText(""); //$NON-NLS-1$
	}

	protected Control createDialogArea(Composite parent) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_QUICK_PALETTE_DIALOG);

		Tree tree = new Tree(parent, SWT.SINGLE | SWT.V_SCROLL | SWT.H_SCROLL);
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.heightHint = tree.getItemHeight() * 12;
		gd.widthHint = 415; // Don't use the Tree's guess, because it might be too small
		tree.setLayoutData(gd);

		tviewer = new TreeViewer(tree);
		ITreeContentProvider treeProvider = new PaletteContentProvider(lastSelections);
		tviewer.setContentProvider(treeProvider);
		ILabelProvider labelProvider = new PaletteEntryLabelProvider();
		tviewer.setLabelProvider(labelProvider);
		filter = new TopologyOutlineFilter(labelProvider, treeProvider);
		tviewer.addFilter(filter);
		tviewer.setInput(getPaletteRoot());
		tviewer.expandToLevel(AbstractTreeViewer.ALL_LEVELS);

		tree.addSelectionListener(new SelectionAdapter() {

			public void widgetDefaultSelected(SelectionEvent e) {
				startPaletteTool();
			}
		});

		tree.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {

				// Correct button?  Anything to do?
				if (e.button != 1 || tviewer.getTree().getSelectionCount() < 1) {
					return;
				}

				if (tviewer.getTree().equals(e.getSource())) {
					Object obj = tviewer.getTree().getItem(new Point(e.x, e.y));
					TreeItem selection = tviewer.getTree().getSelection()[0];
					if (selection.equals(obj)) {
						startPaletteTool();
					}
				}
			}
		});

		return tree;
	}

	// TODO Consider passing this in, rather than calculating it in the popup
	private PaletteRoot getPaletteRoot() {
		PaletteViewer viewer = (PaletteViewer) wbPart.getAdapter(PaletteViewer.class);
		return viewer.getPaletteRoot();
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

		textFilter = new Text(titleComposite, SWT.NULL);
		textFilter.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		textFilter.setText(Messages.QuickPalettePopup_Enter_a_value_to_filter_list_);
		textFilter.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				filter.setMatchString(textFilter.getText());
				tviewer.refresh();
				tviewer.expandToLevel(AbstractTreeViewer.ALL_LEVELS);
				selectFirstPaletteEntry();
			}
		});

		textFilter.addKeyListener(new KeyAdapter() {

			/**
			 * It is important to do this on release, not press, because the palette tool
			 * performCreation() is called on a release, triggering a double performCreation() when the
			 * mouse is clicked later.
			 */
			public void keyReleased(KeyEvent e) {
				// ENTER
				if (e.keyCode == 0x0D) {
					startPaletteTool();
				} else if (e.keyCode == SWT.ARROW_DOWN) {
					tviewer.getTree().setFocus();
				}
			}

		});

		createQuickPaletteToolBar(titleComposite);

		return textFilter;
	}

	private void createQuickPaletteToolBar(Composite parent) {
		ToolBar toolBar = new ToolBar(parent, SWT.FLAT);
		toolBar.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));

		ToolItem expandItem = new ToolItem(toolBar, SWT.PUSH);
		expandItem.setImage(DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
				ISharedImages.IMG_TOOL_EXPAND_ALL_LCL));
		expandItem.setDisabledImage(DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
				ISharedImages.IMG_TOOL_EXPAND_ALL_LCL_DISABLED));
		expandItem
				.setToolTipText(com.ibm.ccl.soa.deploy.core.ui.properties.Messages.CapabilitiesPropertySection_Expan_);
		expandItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleExpandAll();
			}
		});

		ToolItem collapseItem = new ToolItem(toolBar, SWT.PUSH);
		collapseItem.setImage(DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
				ISharedImages.IMG_TOOL_COLLAPSE_ALL_LCL));
		collapseItem.setDisabledImage(DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
				ISharedImages.IMG_TOOL_COLLAPSE_ALL_LCL_DISABLED));
		collapseItem
				.setToolTipText(com.ibm.ccl.soa.deploy.core.ui.properties.Messages.CapabilitiesPropertySection_Collaps_);
		collapseItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleCollapseAll();
			}
		});
	}

	public int open() {
		int retVal = super.open();
		//		getShell().forceFocus();
		textFilter.setFocus();
		textFilter.selectAll();

		selectFirstPaletteEntry();

		return retVal;
	}

//	private void selectFirstPaletteEntry() {
//		// Select the first entry in the tree
//		TreeItem rootItems[] = tviewer.getTree().getItems();
//		if (rootItems.length > 0) {
//			TreeItem unitItems[] = rootItems[0].getItems();
//			if (unitItems.length > 0) {
//				tviewer.getTree().setSelection(unitItems[0]);
//			}
//		}
//	}

	// Select the first entry in the tree, DFS
	private void selectFirstPaletteEntry() {
		TreeItem rootItems[] = tviewer.getTree().getItems();
		selectFirstPaletteTool(rootItems);
	}

	/** RECURSIVE */
	private boolean selectFirstPaletteTool(TreeItem[] items) {
		for (int i = 0; i < items.length; i++) {
			if (selectFirstPaletteTool(items[i].getItems())) {
				return true;
			}

			if (items[i].getData() instanceof PaletteToolEntry) {
				tviewer.getTree().setSelection(items[i]);
				return true;
			}
		}

		return false;
	}

	private void startPaletteTool() {
		if (wbPart instanceof DiagramEditor) {
			DiagramEditor dce = (DiagramEditor) wbPart;
//			EditPartViewer viewer = dce.getDiagramGraphicalViewer();
//		PaletteViewer viewer = (PaletteViewer) wbPart.getAdapter(PaletteViewer.class);

			PaletteToolEntry toolEntry = getSelectedPaletteTool();
//		DiagramEditor dce;
//		dce.getDiagramEditDomain();
//		EditDomain editDomain = dce.getDiagramEditDomain();
//		DeployCoreEditor dce;
			DiagramEditDomain editDomain = (DiagramEditDomain) dce.getDiagramEditDomain();

			if (toolEntry != null) {
				store(toolEntry);
				Tool tool = toolEntry.createTool();

//			Event fake = new Event();
//			fake.widget = viewer.getControl();
//			fake.button = 1;
//			MouseEvent mouseEvent = new MouseEvent(fake);
//			tool.mouseDown(mouseEvent, viewer);

				editDomain.setActiveTool(tool);

				close();
			}
		}
	}

	private void store(PaletteToolEntry toolEntry) {
		if (lastSelections == null) {
			lastSelections = new ArrayList<String>();
			lastSelections.add(toolEntry.getId());
		} else {
			//Remove exiting ID.
			lastSelections.remove(toolEntry.getId());
			//Add first in list.
			lastSelections.add(0, toolEntry.getId());
			if (lastSelections.size() == 5) {
				//Remove last.
				lastSelections.remove(4);
			}
		}
	}

	private PaletteToolEntry getSelectedPaletteTool() {
		ISelection sel = tviewer.getSelection();
		if (sel instanceof StructuredSelection) {
			StructuredSelection ss = (StructuredSelection) sel;
			if (ss.getFirstElement() instanceof PaletteToolEntry) {
				return (PaletteToolEntry) ss.getFirstElement();
			}
		}

		return null;
	}

	private void handleCollapseAll() {
		tviewer.collapseAll();
	}

	private void handleExpandAll() {
		tviewer.expandAll();
	}

	private static class PaletteContentProvider implements ITreeContentProvider {

		private static final Object[] NONE = new Object[0];

		private final List<String> rootPaletteIds;

		/**
		 * @param rootPaletteIds
		 */
		PaletteContentProvider(List<String> rootPaletteIds) {
			super();
			this.rootPaletteIds = rootPaletteIds;
		}

		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof PaletteContainer) {
				PaletteContainer root = (PaletteContainer) parentElement;
				return filterChildren(root.getChildren()).toArray();
			}

			return NONE;
		}

		public Object getParent(Object element) {
			return null;
		}

		public boolean hasChildren(Object element) {
			return getChildren(element).length > 0;
		}

		public Object[] getElements(Object inputElement) {
			//Filter the empty root.
			Object input = inputElement;
			if (inputElement instanceof PaletteRoot
					&& ((PaletteRoot) inputElement).getParent() == null) {
				List children = ((PaletteRoot) inputElement).getChildren();
				if (children.size() == 1) {
					input = children.get(0);
				}
			}
			PaletteContainer container = (PaletteContainer) input;
			List rootEntries = computeRootEntries(container);
			if (rootEntries == null) {
				rootEntries = container.getChildren();
			} else {
				rootEntries.addAll(container.getChildren());
			}
			return filterChildren(rootEntries).toArray();
		}

		private List<PaletteEntry> computeRootEntries(PaletteContainer container) {
			if (rootPaletteIds == null || rootPaletteIds.isEmpty()) {
				return null;
			}
			List<PaletteEntry> entries = new ArrayList<PaletteEntry>(rootPaletteIds.size());
			for (Iterator<String> it = rootPaletteIds.iterator(); it.hasNext();) {
				String id = it.next();
				PaletteEntry entry = findEntry(id, container);
				if (entry != null) {
					entries.add(entry);
				}
			}
			return entries;
		}

		private PaletteEntry findEntry(String id, PaletteContainer container) {
			List children = container.getChildren();
			for (int i = 0; i < children.size(); i++) {
				PaletteEntry entry = (PaletteEntry) children.get(i);
				if (entry.getId() != null && entry.getId().equals(id)) {
					return entry;
				}
				if (entry instanceof PaletteContainer) {
					entry = findEntry(id, (PaletteContainer) entry);
					if (entry != null) {
						return entry;
					}
				}
			}
			return null;
		}

		public void dispose() {
			// do nothing
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// do nothing
		}

		// Exclude PaletteSeparator and SelectionToolEntry
		private List<?> filterChildren(List<?> children) {
			List<Object> retVal = new LinkedList<Object>();
			for (Object child : children) {
				if (!(child instanceof PaletteSeparator || child instanceof SelectionToolEntry)) {
					retVal.add(child);
				}
			}

			return retVal;
		}

	} // end inner class TopologyOutlineContentProvider

	private class TopologyOutlineFilter extends ViewerFilter {

		// TODO Is StringMatcher really internal?
		private StringMatcher matcher;
		private final ILabelProvider labelProvider;
		private final ITreeContentProvider treeProvider;

		private TopologyOutlineFilter(ILabelProvider labProvider, ITreeContentProvider tProvider) {
			matcher = new StringMatcher("*", true, false); //$NON-NLS-1$
			labelProvider = labProvider;
			treeProvider = tProvider;
		}

		// indirectly recursive
		public boolean select(Viewer viewer, Object parentElement, Object element) {

			// entries only match if they match the regexp input
			String text = labelProvider.getText(element);

			if (matcher.match(text)) {
				return true;
			}

			// We can't return false if any children would return true.
			// Ask the content provider
			return atLeastOneChildReturnsTrue(viewer, element);
		}

		// indirectly recursive
		private boolean atLeastOneChildReturnsTrue(Viewer viewer, Object ep) {
			Object[] children = treeProvider.getChildren(ep);
			for (int i = 0; i < children.length; i++) {
				if (select(viewer, ep, children[i])) {
					return true;
				}
			}

			return false;
		}

		protected void setMatchString(String s) {
			matcher = new StringMatcher(s + '*', true, false);
		}

	} // end inner class TopologyOutlineFilter

	/**
	 * A label provider for the Units in a Topology; italicizes conceptual units.
	 */
	public static class PaletteEntryLabelProvider extends LabelProvider {

		private final Map<ImageDescriptor, Image> imageCache = new HashMap<ImageDescriptor, Image>();
		private final List<ImageDescriptor> badImages = new LinkedList<ImageDescriptor>();

		protected PaletteEntryLabelProvider() {
			// do nothing
		}

		public Image getImage(Object element) {
			if (element instanceof PaletteEntry) {
				PaletteEntry entry = (PaletteEntry) element;
				ImageDescriptor descriptor = entry.getSmallIcon();
				if (descriptor == null) {
					if (entry instanceof PaletteContainer) {
						return PlatformUI.getWorkbench().getSharedImages().getImage(
								org.eclipse.ui.ISharedImages.IMG_OBJ_FOLDER);
					} else if (entry instanceof PaletteSeparator) {
						//TODO For now we have this internal reference but it should 
						//be removed when this code is factored out to a common plug-in.
						descriptor = InternalImages.DESC_SEPARATOR;
					} else {
						return null;
					}
				}
				return getCachedImage(entry.getSmallIcon());
			}
			return null;
		}

		public String getText(Object element) {
			if (element instanceof PaletteEntry) {
				PaletteEntry entry = (PaletteEntry) element;
				return entry.getLabel();
			}

			return element.getClass().getName();
		}

		public void dispose() {
			for (Image image : imageCache.values()) {
				image.dispose();
			}
		}

		private Image getCachedImage(ImageDescriptor iDescr) {
			if (iDescr == null) {
				return null;
			}

			Image retVal = imageCache.get(iDescr);
			if (retVal == null) {
				if (!badImages.contains(iDescr)) {
					// If the image has no data, we'll display a red square by default.
					// We don't want the square, so we don't cache it.
					try {
						retVal = iDescr.createImage(false);
						if (retVal == null) {
							badImages.add(iDescr);
						} else {
							imageCache.put(iDescr, retVal);
						}
					} catch (SWTException e) {
						// In the Runtime Workbench, iDescr.getImageData() seemed to return
						// null for invalid images, such as non-existent ones for stacks,
						// but in the FVT driver it throws an exception instead.  I wish
						// I wish could eliminate the call to iDescr.createImage() if it will fail,
						// but don't know how.  The standard GMF palette doesn't have this problem,
						// but perhaps this is because the problem is related to stacks, which GMF
						// doesn't display icons for?
						badImages.add(iDescr);
					}
				}
			}

			return retVal;
		}

	} // end inner class ItalicizingTopologyLabelProvider

} // end class QuickPalettePopup
