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

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.ui.services.icon.IconOptions;
import org.eclipse.gmf.runtime.common.ui.services.icon.IconService;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITableFontProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.misc.StringMatcher;

import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.actions.QuickOutlineDialogHandler;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployCoreCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployListCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;

/**
 * A popup dialog resembling the Java 'Quick Outline' (control-O) dialog. Ours lists Units rather
 * than Java methods.
 * 
 * @author Ed Snible
 * @see QuickOutlineDialogHandler
 */
public class TopologyOutlinePopup extends PopupDialog {

	//	private final Topology top;
	private Text textFilter;
	private TopologyOutlineFilter filter;
	private TreeViewer tviewer;
	private final IWorkbenchPart wbPart;
	private final DiagramEditPart dgm;

	/**
	 * @param parentShell
	 * @param diagram
	 * @param part
	 */
	public TopologyOutlinePopup(Shell parentShell, DiagramEditPart diagram, IWorkbenchPart part) {
		super(parentShell, SWT.RESIZE, true, false, true, false, "", ""); //$NON-NLS-1$//$NON-NLS-2$

		//		top = topology;
		dgm = diagram;
		wbPart = part;
		setInfoText(""); //$NON-NLS-1$
	}

	protected Control createDialogArea(Composite parent) {
		//		Label l = new Label(parent, SWT.NULL);
		//		l.setText("Dlg Area"); //$NON-NLS-1$
		//		return l;
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_OUTLINE_VIEW);

		Tree tree = new Tree(parent, SWT.SINGLE | SWT.V_SCROLL | SWT.H_SCROLL);
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.heightHint = tree.getItemHeight() * 12;
		gd.widthHint = 300; // Don't use the Tree's guess, because it might be too small
		tree.setLayoutData(gd);

		tviewer = new TreeViewer(tree);
		ITreeContentProvider treeProvider = new TopologyOutlineContentProvider();
		tviewer.setContentProvider(treeProvider);
		ILabelProvider labelProvider = new ItalicizingTopologyLabelProvider(parent.getFont());
		tviewer.setLabelProvider(labelProvider);
		filter = new TopologyOutlineFilter(labelProvider, treeProvider);
		tviewer.addFilter(filter);
		//		tviewer.setComparator(new UnitComparator());
		//		tviewer.setInput(Collections.singletonList(top));
		tviewer.setInput(dgm);
		tviewer.expandToLevel(AbstractTreeViewer.ALL_LEVELS);

		tree.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				// do nothing
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				focusSelectedUnit();
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
						focusSelectedUnit();
					}
				}
			}
		});

		return tree;
	}

	protected Control createTitleControl(Composite parent) {
		//		Label l = new Label(parent, SWT.NULL);
		//		l.setText("Title Area"); //$NON-NLS-1$
		//		return l;
		textFilter = new Text(parent, SWT.NULL);
		textFilter.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		textFilter.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				filter.setMatchString(textFilter.getText());
				tviewer.refresh();
				selectFirstUnit();
			}
		});

		textFilter.addKeyListener(new KeyListener() {

			public void keyPressed(KeyEvent e) {
				// ENTER
				if (e.keyCode == 0x0D) {
					focusSelectedUnit();
				} else if (e.keyCode == SWT.ARROW_DOWN) {
					tviewer.getTree().setFocus();
				}
			}

			public void keyReleased(KeyEvent e) {
				// do nothing
			}
		});

		return textFilter;
	}

	public int open() {
		int retVal = super.open();
		//		getShell().forceFocus();
		textFilter.setFocus();

		selectFirstUnit();

		return retVal;
	}

	private void selectFirstUnit() {
		// Select the first Unit in the tree
		TreeItem rootItems[] = tviewer.getTree().getItems();
		if (rootItems.length > 0) {
			TreeItem unitItems[] = rootItems[0].getItems();
			if (unitItems.length > 0) {
				tviewer.getTree().setSelection(unitItems[0]);
			}

			//			System.out.println(tviewer.getTree().getTopItem());
			//			tviewer.getTree().setTopItem(rootItems[0]);
			//			System.out.println(tviewer.getTree().getTopItem());
		}
	}

	//	private void focusSelectedUnit() {
	//		Unit unit = getSelectedUnit();
	//		if (unit != null) {
	//			PropertyUtils.revealNext(unit, wbPart);
	//			close();
	//		}
	//	}

	private void focusSelectedUnit() {
		EditPart ep = getSelectedEditPart();
		if (ep != null) {
			PropertyUtils.revealEditPart(ep, wbPart);
			close();
		}
	}

	private EditPart getSelectedEditPart() {
		ISelection sel = tviewer.getSelection();
		if (sel instanceof StructuredSelection) {
			StructuredSelection ss = (StructuredSelection) sel;
			//			if (ss.getFirstElement() instanceof Unit) {
			//				return (Unit) ss.getFirstElement();
			//			}
			if (ss.getFirstElement() instanceof EditPart) {
				return (EditPart) ss.getFirstElement();
			}
		}

		return null;
	}

	//	private Unit getSelectedUnit() {
	//		ISelection sel = tviewer.getSelection();
	//		if (sel instanceof StructuredSelection) {
	//			StructuredSelection ss = (StructuredSelection) sel;
	//			//			if (ss.getFirstElement() instanceof Unit) {
	//			//				return (Unit) ss.getFirstElement();
	//			//			}
	//			if (ss.getFirstElement() instanceof EditPart) {
	//				EditPart ep = (EditPart) ss.getFirstElement();
	//				Object obj = getSemantic(ep);
	//				if (obj instanceof Unit) {
	//					return (Unit) obj;
	//				}
	//			}
	//		}
	//
	//		return null;
	//	}

	private static Object getSemantic(Object element) {
		// Convert from EditPart to semantic object
		if (element instanceof EditPart) {
			EditPart ep = (EditPart) element;
			if (ep.getModel() instanceof Node) {
				Node node = (Node) ep.getModel();
				element = node.getElement();
			}
		}

		return element;
	}

	private static class TopologyOutlineContentProvider implements ITreeContentProvider {

		private static final Object[] NONE = new Object[0];

		//		public Object[] getChildren(Object parentElement) {
		//			if (parentElement instanceof Topology) {
		//				Topology top = (Topology) parentElement;
		//				return PropertyUtils.getUnitsInTopologyForSemantic(top).toArray();
		//			} else if (parentElement instanceof List) {
		//				List<?> l = (List<?>) parentElement;
		//				return l.toArray();
		//			}
		//
		//			return NONE;
		//		}

		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof DiagramEditPart) {
				EditPart ep = (EditPart) parentElement;
				return filterForUnitsAndImports(ep.getChildren()).toArray();
			} else if (parentElement instanceof DeployShapeNodeEditPart) {
				// It isn't sufficient to merely return the children, as the children are
				// sometimes compartments which aren't DeployShapeNodeEditPart and shouldn't
				// appear in the tree, but their children should.
				EditPart ep = (EditPart) parentElement;
				return expandCompartments(ep.getChildren()).toArray();
			}

			return NONE;
		}

		private List<EditPart> expandCompartments(List<EditPart> children) {
			List<EditPart> retVal = new LinkedList<EditPart>();

			for (EditPart child : children) {
				if (child instanceof DeployCoreCompartmentEditPart) {
					DeployCoreCompartmentEditPart dccep = (DeployCoreCompartmentEditPart) child;
					retVal.addAll(dccep.getChildren());
				} else if (child instanceof DeployListCompartmentEditPart) {
					DeployListCompartmentEditPart dlcep = (DeployListCompartmentEditPart) child;
					retVal.addAll(dlcep.getChildren());
				}
			}

			return retVal;
		}

		private List<EditPart> filterForUnitsAndImports(List<EditPart> children) {
			List<EditPart> retVal = new LinkedList<EditPart>();

			for (EditPart child : children) {
				if (child instanceof DeployShapeNodeEditPart) {
					retVal.add(child);
				}
			}

			return retVal;
		}

		public Object getParent(Object element) {
			return null;
		}

		public boolean hasChildren(Object element) {
			return getChildren(element).length > 0;
		}

		public Object[] getElements(Object inputElement) {
			//			return new Object[] { inputElement };
			return getChildren(inputElement);
		}

		public void dispose() {
			// do nothing
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// do nothing
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
			//			// The Topology always matches
			//			if (element instanceof Topology) {
			//				return true;
			//			}
			// The Diagram always matches
			if (element instanceof Diagram) {
				return true;
			}

			// Units only match if they match the input
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

	//	private static class UnitComparator extends ViewerComparator {
	//
	//		public int compare(Viewer viewer, Object e1, Object e2) {
	//			if (e1 instanceof DeployModelObject && e2 instanceof DeployModelObject) {
	//				Unit dmo1 = (Unit) e1;
	//				Unit dmo2 = (Unit) e2;
	//
	//				String name1 = dmo1.getCaptionProvider().title(dmo1);
	//				String name2 = dmo2.getCaptionProvider().title(dmo2);
	//
	//				return name1.compareTo(name2);
	//			}
	//
	//			return 0;
	//		}
	//	} // end inner class UnitComparator

	/**
	 * A label provider for the Units in a Topology; italicizes conceptual units.
	 */
	public static class ItalicizingTopologyLabelProvider extends LabelProvider implements
			IFontProvider, ITableFontProvider {

		private final Font regularFont;
		private final Font italicFont;

		/**
		 * @param font
		 */
		public ItalicizingTopologyLabelProvider(Font font) {
			regularFont = font;

			FontData fd[] = font.getFontData();
			fd[0].setStyle(fd[0].getStyle() | SWT.ITALIC);
			italicFont = new Font(Display.getDefault(), fd);
		}

		public Image getImage(Object element) {
			element = getSemantic(element);

			if (element instanceof EObject) {
				return IconService.getInstance().getIcon(new EObjectAdapter((EObject) element),
						IconOptions.GET_STEREOTYPE_IMAGE_FOR_ELEMENT.intValue());
			}

			return null;
		}

		public String getText(Object element) {
			element = getSemantic(element);

			if (element instanceof Unit) {
				Unit unit = (Unit) element;
				return unit.getCaptionProvider().titleWithContext(unit);
			} else if (element instanceof Topology) {
				return PropertyUtils.getName((Topology) element);
			} else if (element instanceof Import) {
				Import imp = (Import) element;
				return PropertyUtils.getName(imp);
			}

			return element.getClass().getName();
		}

		public void dispose() {
			italicFont.dispose();
		}

		public Font getFont(Object element) {
			element = getSemantic(element);

			if (element instanceof Unit) {
				Unit unit = (Unit) element;
				if (unit.isConceptual()) {
					return italicFont;
				}
			}

			return regularFont;
		}

		public Font getFont(Object element, int columnIndex) {
			// Ignore column info, all columns are the same
			return getFont(element);
		}

	} // end inner class ItalicizingTopologyLabelProvider

} // end class TopologyOutlineInformationControl
