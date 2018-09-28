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

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.DemultiplexingListener;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.ui.services.icon.IconOptions;
import org.eclipse.gmf.runtime.common.ui.services.icon.IconService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;

/**
 * &lt;propertySection filter=&gt; for Deployment Diagram
 * 
 * @author Ed Snible
 */
public class TopologyDetailsSection extends AbstractPropertySection {

	protected static final int TITLE_NAME = 0;
	protected static final int ANCHOR_NAME = 1;
	protected static final int EDITPART_CLASS = 2;

	private TableViewer tviewer;
	private TopologyDebugTableProvider provider;
	private TopologyDebugLabelProvider labelProvider;

	private IActionBars actionBars;
	private Action focusAction;
	private Topology top;
	private EditPart epDiagram;
	//	private Action toggleAction;
	//	private EditDomain gefDomain;
	private DisplayNameViewerComparator comparator;
	private final Map<TableColumn, Integer> mapColumn;

	/**
	 * 
	 */
	public TopologyDetailsSection() {
		mapColumn = new HashMap<TableColumn, Integer>();
	}

	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);

		// Create a new section to wrap and layout our table
		Composite composite = getWidgetFactory().createComposite(parent);
		composite.setLayout(new GridLayout());

		Table table = getWidgetFactory().createTable(composite,
				SWT.BORDER | SWT.SINGLE | SWT.FULL_SELECTION);
		GridData gdTable = new GridData();
		gdTable.widthHint = 650;
		gdTable.heightHint = 150;
		table.setLayoutData(gdTable);

		tviewer = new TableViewer(table);
		provider = new TopologyDebugTableProvider();
		tviewer.setContentProvider(provider);
		labelProvider = provider.getPropLabelProvider();
		comparator = new DisplayNameViewerComparator(labelProvider);
		tviewer.setComparator(comparator);
		tviewer.setLabelProvider(labelProvider);

		tviewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				enableDisableButtons();
			}
		});

		TableLayout tl = new TableLayout();
		tl.addColumnData(new ColumnWeightData(45)); // type
		tl.addColumnData(new ColumnWeightData(45)); // dir
		tl.addColumnData(new ColumnWeightData(130)); // opposite
		table.setLayout(tl);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		String[] colHeaders = new String[] { Messages.ImportPropertySection_Titl_,
				Messages.TopologyDetailsSection_Ancho_, Messages.TopologyDetailsSection_EditPar_ };
		for (int i = 0; i < colHeaders.length; i++) {
			TableColumn col = new TableColumn(table, SWT.LEFT);
			col.setText(colHeaders[i]);
			col.setWidth(115);

			mapColumn.put(col, new Integer(i));
			col.addSelectionListener(new SelectionListener() {

				public void widgetDefaultSelected(SelectionEvent e) {
					// do nothing
				}

				public void widgetSelected(SelectionEvent e) {
					selectedColumn(e);
				}
			});
		}

		actionBars = aTabbedPropertySheetPage.getSite().getActionBars();
		createActions();
	}

	protected void selectedColumn(SelectionEvent e) {
		Integer col = mapColumn.get(e.getSource());
		if (col != null) {
			comparator.setSortKey(col.intValue());
			tviewer.refresh();
		}
	}

	private void createActions() {

		//		String addLink = "Focus";
		String jump = Messages.ConfigurationsPropertySection2_Go_T_;
		focusAction = propAction(jump, "icons/elcl16/goto_linktarget.gif", new Action() { //$NON-NLS-1$
					public void run() {
						focusUnit();
					}
				});

		//        String toggleMutability = "Toggle Mutability"; //$NON-NLS-1$
		//        toggleAction = propAction(toggleMutability, new Action() {
		//        	public void run() {
		//        		toggleMutability();
		//        	}
		//        });
	}

	private Action propAction(String msg, String icon, Action a) {
		a.setText(msg);
		a.setToolTipText(msg);
		ImageDescriptor id = PropertyUtils.createImageDescriptor(icon);
		a.setImageDescriptor(id);
		//		a.setChecked(true);
		return a;
	}

	//	/**
	//	 * @deprecated
	//	 */
	//	private Action propAction(String msg, Action a) {
	//		a.setText(msg);
	//		a.setToolTipText(msg);
	//		a.setChecked(true);
	//		return a;
	//	}

	protected void enableDisableButtons() {
		//		boolean linkExists = !tviewer.getSelection().isEmpty();
		Unit unit = getSelectedUnit();
		Import importz = getSelectedImport();

		EObject objSemantic = unit != null ? (EObject) unit : (EObject) importz;

		boolean hasEp = objSemantic != null && epDiagram != null
				&& GMFUtils.getEditPartsFor(epDiagram, objSemantic).size() > 0;

		focusAction.setEnabled(hasEp);
		//		toggleAction.setEnabled(unit != null);
	}

	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);

		if (selection instanceof IStructuredSelection) {
			IStructuredSelection iss = (IStructuredSelection) selection;
			Object sel = iss.getFirstElement();
			if (sel instanceof EditPart) {
				EditPart ep = (EditPart) sel;
				if (ep.getModel() instanceof View) {
					View view = (View) ep.getModel();
					if (ViewUtil.resolveSemanticElement(view) instanceof Topology) {
						setInput((Topology) ViewUtil.resolveSemanticElement(view), ep);
						return;
					}
				}
			}
		}

		setInput((Topology) null, (EditPart) null);
	}

	private void setInput(Topology topology, EditPart epTop /* , EditDomain gefDomain */) {
		top = topology;
		epDiagram = epTop;
		//		this.gefDomain = gefDomain;

		labelProvider.setDiagramEditPart(epTop);
		//		this.epReg = epTop.getViewer().getEditPartRegistry();

		if (top != null) {
			tviewer.setInput(top);
		}

		if (tviewer.getTable().getItemCount() > 0) {
			tviewer.getTable().setSelection(0);
		}

		enableDisableButtons();
	}

	private Unit getSelectedUnit() {
		if (tviewer.getSelection() instanceof StructuredSelection) {
			StructuredSelection ss = (StructuredSelection) tviewer.getSelection();
			Object rowObj = ss.getFirstElement();
			if (rowObj instanceof Unit) {
				return (Unit) rowObj;
			}
		}

		return null;
	}

	private Import getSelectedImport() {
		if (tviewer.getSelection() instanceof StructuredSelection) {
			StructuredSelection ss = (StructuredSelection) tviewer.getSelection();
			Object rowObj = ss.getFirstElement();
			if (rowObj instanceof Import) {
				return (Import) rowObj;
			}
		}

		return null;
	}

	/**
	 * event listener; catches multiplexed events and routes them to us
	 */
	private final DemultiplexingListener eventListener = new DemultiplexingListener(getFilter()) {

		protected void handleNotification(TransactionalEditingDomain domain, Notification notification) {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					if (!tviewer.getTable().isDisposed()) {
						tviewer.refresh();
					}
				}
			});
		}
	};

	private NotificationFilter getFilter() {
		return NotificationFilter.createEventTypeFilter(Notification.SET);
	}

	public void aboutToBeShown() {
		super.aboutToBeShown();

		if (top != null) {
			// Setup to capture notifications after model-changing events (e.g. Edit->Undo)
			TransactionalEditingDomain theEditingDomain = TransactionUtil.getEditingDomain(top);
			if (theEditingDomain != null) {
				theEditingDomain.addResourceSetListener(eventListener);
			}

			// Refresh the table, in case a user in the structure editor added or delete a capability
			tviewer.refresh();
		}
	}

	public void aboutToBeHidden() {
		actionBars.getMenuManager().removeAll();
		actionBars.getStatusLineManager().removeAll();
		actionBars.getToolBarManager().removeAll();
		actionBars.getToolBarManager().update(true);
		super.aboutToBeHidden();

		if (top != null) {
			TransactionalEditingDomain theEditingDomain = TransactionUtil.getEditingDomain(top);
			if (theEditingDomain != null) {
				theEditingDomain.removeResourceSetListener(eventListener);
			}
		}
	}

	public void refresh() {

		super.refresh();

		actionBars.getMenuManager().removeAll();
		actionBars.getStatusLineManager().removeAll();
		actionBars.getToolBarManager().removeAll();

		actionBars.getToolBarManager().add(focusAction);
		//        actionBars.getToolBarManager().add(toggleAction);

		actionBars.getMenuManager().add(focusAction);
		//        actionBars.getMenuManager().add(toggleAction);

		actionBars.getToolBarManager().update(true);
	}

	/** Note: focuses on either {@link Import} or {@link Unit} */
	private void focusUnit() {
		Unit unit = getSelectedUnit();
		if (unit != null) {
			PropertyUtils.reveal(unit, getPart());
		} else {
			Import importz = getSelectedImport();
			PropertyUtils.reveal(importz, getPart());
		}
	}

	//	protected void toggleMutability() {
	//		Unit unit = getSelectedUnit();
	//		boolean newMutability = !unit.isMutable();
	//		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(unit);
	//		
	//		SetCommand sc = new SetCommand(domain, unit, 
	//				CorePackage.eINSTANCE.getDeployModelObject_Mutable(),  
	//				Boolean.valueOf(newMutability));
	//		TransactionCommandWrapper2 mtcw = new TransactionCommandWrapper2(domain, sc, true);
	//		ICommandProxy command = new ICommandProxy(mtcw);
	//		gefDomain.getCommandStack().execute(command);
	//	}

	/**
	 * 
	 * @author Ed Snible
	 */
	private static class TopologyDebugTableProvider implements IStructuredContentProvider {

		private static final Object[] NONE = new Object[0];

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof Topology) {
				Topology top = (Topology) inputElement;
				List<?> retVal = new LinkedList(top.getUnits());
				retVal.addAll(top.getImports());
				return retVal.toArray();
				//				return top.getUnits().toArray();
			}

			return NONE;
		}

		public void dispose() {
			// do nothing
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// do nothing
		}

		protected TopologyDebugLabelProvider getPropLabelProvider() {
			return new TopologyDebugLabelProvider();
		}
	} // end inner class TopologyDebugTableProvider

	private static class TopologyDebugLabelProvider extends LabelProvider implements
			ITableLabelProvider {

		private EditPart epDiagram;

		public Image getColumnImage(Object element, int columnIndex) {
			if (columnIndex == TITLE_NAME) {
				if (element instanceof EObject) {
					return IconService.getInstance().getIcon(new EObjectAdapter((EObject) element),
							IconOptions.GET_STEREOTYPE_IMAGE_FOR_ELEMENT.intValue());
				}
			}

			return null;
		}

		protected void setDiagramEditPart(EditPart epTop) {
			epDiagram = epTop;
		}

		public String getColumnText(Object element, int columnIndex) {
			switch (columnIndex)
			{
			case TITLE_NAME:
				return getTitle(element);
			case ANCHOR_NAME:
				return getAnchorName(element);
			case EDITPART_CLASS:
				return getEditPartName(element);
			}

			return ""; //$NON-NLS-1$
		}

		private String getEditPartName(Object element) {
			if (epDiagram != null && element instanceof EObject) {
				List<DeployShapeNodeEditPart> l = GMFUtils
						.getEditPartsFor(epDiagram, (EObject) element);
				return epListToString(l);
			}

			return element.getClass().getName();
		}

		private String epListToString(List<DeployShapeNodeEditPart> l) {
			StringBuffer sb = new StringBuffer();

			for (Iterator<DeployShapeNodeEditPart> it = l.iterator(); it.hasNext();) {
				EditPart ep = it.next();
				sb.append(getLocalName(ep.getClass()));
				if (it.hasNext()) {
					sb.append(", "); //$NON-NLS-1$
				}
			}

			return sb.toString();
		}

		private String getLocalName(Class<?> clazz) {
			String s = clazz.getName();
			int pos = s.lastIndexOf('.');
			if (pos == -1) {
				return s;
			}

			return s.substring(pos + 1);
		}

		private String getAnchorName(Object element) {
			if (element instanceof DeployModelObject) {
				DeployModelObject dmo = (DeployModelObject) element;
				return dmo.getName();
			}

			return element.getClass().getName();
		}

		private String getTitle(Object element) {
			if (element instanceof Unit) {
				return ((Unit) element).getCaptionProvider().titleWithContext((Unit) element);
			} else if (element instanceof Capability) {
				return ((Capability) element).getCaptionProvider().titleWithContext(
						(Capability) element);
			} else if (element instanceof DeployModelObject) {
				DeployModelObject dmo = (DeployModelObject) element;
				return dmo.getDisplayName();
			}

			return element.getClass().getName();
		}

	} // end inner class TopologyDebugLabelProvider

	//	private static class DisplayNameComparator implements Comparator {
	//
	//		public int compare(Object o1, Object o2) {
	//			if (o1 instanceof DeployModelObject && o2 instanceof DeployModelObject) {
	//				DeployModelObject dmo1 = (DeployModelObject) o1;
	//				DeployModelObject dmo2 = (DeployModelObject) o2;
	//				return dmo1.getDisplayName().compareTo(dmo2.getDisplayName());
	//			}
	//			
	//			return 0;
	//		}
	//		
	//	}

	private static class DisplayNameViewerComparator extends ViewerComparator {

		private final ITableLabelProvider lp;
		private int sortKey;

		protected DisplayNameViewerComparator(ITableLabelProvider lprovider) {
			lp = lprovider;
			sortKey = TITLE_NAME;
		}

		protected void setSortKey(int col) {
			sortKey = col;
		}

		public int compare(Viewer viewer, Object e1, Object e2) {
			if (e1 instanceof DeployModelObject && e2 instanceof DeployModelObject) {
				DeployModelObject dmo1 = (DeployModelObject) e1;
				DeployModelObject dmo2 = (DeployModelObject) e2;

				// HACK -- override usage of label provider because
				// we want to sort on title() instead of titleWithContext()
				// for performance reasons.
				String name1, name2;
				if (sortKey == TITLE_NAME && dmo1 instanceof Unit) {
					name1 = ((Unit) dmo1).getCaptionProvider().title((Unit) dmo1);
				} else {
					name1 = lp.getColumnText(dmo1, sortKey);
				}
				if (sortKey == TITLE_NAME && dmo2 instanceof Unit) {
					name2 = ((Unit) dmo2).getCaptionProvider().title((Unit) dmo2);
				} else {
					name2 = lp.getColumnText(dmo2, sortKey);
				}

				return name1.compareTo(name2);
			}

			return 0;
		}
	} // end static inner class DisplayNameViewerComparator

	//	private static class TopologyDebugSorter {
	//		
	//	}

} // end class TopologyDebugSection
