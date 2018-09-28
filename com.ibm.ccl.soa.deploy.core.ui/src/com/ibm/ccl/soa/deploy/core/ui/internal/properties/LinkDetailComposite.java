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

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableColorProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.composites.DmoTabbedComposite;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.LinkDetailPopupDialog;
import com.ibm.ccl.soa.deploy.core.ui.properties.DmoSyncHelper;
import com.ibm.ccl.soa.deploy.core.ui.properties.LinksPropertySection2;
import com.ibm.ccl.soa.deploy.core.ui.properties.Messages;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.ui.properties.LinksPropertySection2.LinkRow;
import com.ibm.ccl.soa.deploy.core.ui.properties.LinksPropertySection2.LinkRowHoverListener;

/**
 * Note that this class doesn't extend DmoComposite because it works with multiple DMOs, not just
 * one.
 * 
 * @author Ed Snible (based on daberg original)
 * @see LinkDetailPopupDialog
 */
public class LinkDetailComposite extends Composite {

	private static final String CONSTRAINTEXPANSION_STATE_SETTING = "LinkDetailComposite_ConstraintExpansionState"; //$NON-NLS-1$

	private TableViewer tableViewer;
	//	private boolean isPopup;
	//	private Shell parentPopupShell;
	private final Map<TableColumn, Integer> mapColumn = new HashMap<TableColumn, Integer>();
	private LinkTreeLabelViewerComparator comparator;
	private LinkTableLabelProvider labelProvider;
	private final FormToolkit formToolkit;
	private List<LinkRow> links;
	private DmoTabbedComposite tabbedComposite;
	private final FormToolkit toolkit;

	protected DeployModelObject deployModelObject;

	/**
	 * @param parent
	 * @param tk
	 */
	public LinkDetailComposite(Composite parent, FormToolkit tk) {
		super(parent, SWT.NONE);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_PROPERTIES_LINKS_TAB);
		toolkit = tk;
		//		this.labelProvider = labelProvider;
		//		model.setUnitIsImported(unitIsImported);
		//		model.setTypeImageProvider(labelProvider);
		//		getSynchHelper().updateUIWithModel(CorePackage.Literals.REQUIREMENT__DMO_TYPE);

		this.getShell().addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				// FIXME: in ConstraintComposite, the DisposeListener is added to the Composite itself, not to the shell. Check with Ed.
				stopListeningForChanges();
				dispose();
			}
		});

		formToolkit = toolkit;

		initializeContents();
	}

	protected void initializeContents() {
		this.setLayout(new GridLayout());
		this.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));
		setBackgroundMode(SWT.INHERIT_DEFAULT);
		//		initializeBodyContents(this);

		//		SashForm sf = new SashForm(this, SWT.HORIZONTAL);
		//		sf.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		initializeBodyContents(this);

		//Add constraints and description
		tabbedComposite = new DmoTabbedComposite(this, SWT.None, formToolkit) {
			@Override
			protected void initializeTabItems() {
				initializeConstraintsTab();
				initializeDescriptionTab();
			}

			@Override
			protected void initializeMainContent(Composite parent, DmoSyncHelper synchHelper) {
				//Do nothing		
			}
		};
		GridData gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		tabbedComposite.setLayoutData(gridData);

	}

	private IDialogSettings getDialogSettings() {
		return DeployCoreUIPlugin.getDefault().getDialogSettings();
	}

	private void initializeBodyContents(Composite body /* , DmoSyncHelper aSynchHelper */) {
		Table table = formToolkit.createTable(body, SWT.FLAT | SWT.FULL_SELECTION | SWT.SINGLE);
		GridData gdTable = new GridData(GridData.FILL, GridData.FILL, true, true);
		gdTable.widthHint = 400;
		table.setLayoutData(gdTable);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		String[] columns = new String[] { Messages.LinkDetailComposite_Link_Nam_,
				Messages.LinksPropertySection2_Sourc_, Messages.LinksPropertySection2_Targe_ };
		setColumns(table, columns);

		TableLayout tl = new TableLayout();
		tl.addColumnData(new ColumnWeightData(30)); // link name
		tl.addColumnData(new ColumnWeightData(30)); // source
		tl.addColumnData(new ColumnWeightData(30)); // target
		table.setLayout(tl);

		LinkRowHoverListener listener = new LinkRowHoverListener(table, null);
		table.addMouseTrackListener(listener);
		table.addMouseListener(listener);

		table.addKeyListener(new KeyListener() {

			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.DEL) {
					deleteSelectedLinks();
				}
			}

			public void keyReleased(KeyEvent e) {
			}
		});

		table.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				LinkRow lr = getSelectedLink();
				if (lr != null) {
					setDeployModelObject(lr);
				}
				//setConstraintSectionLabel();
			}
		});

		tableViewer = new TableViewer(table);

		tableViewer.setContentProvider(new ListContentProvider());
		labelProvider = new LinkTableLabelProvider(getShell().getDisplay());
		tableViewer.setLabelProvider(labelProvider);
		comparator = new LinkTreeLabelViewerComparator(labelProvider);
		tableViewer.setComparator(comparator);
		tableViewer.setColumnProperties(columns);
		attachCellEditors();
	}

	private void attachCellEditors() {
		tableViewer.setCellEditors(new CellEditor[] { new TextCellEditor(tableViewer.getTable(),
				SWT.LEFT) // link name
				});
		tableViewer.setCellModifier(new LinkPropertiesModifier());
	}

	private void setColumns(Table table, String[] columnLabels) {
		TableColumn[] columns = table.getColumns();
		for (int i = 0; i < columnLabels.length; i++) {
			String string = columnLabels[i];
			TableColumn column = i < columns.length ? columns[i] : new TableColumn(table, 0);
			column.setText(string);

			mapColumn.put(column, new Integer(i));
			column.addSelectionListener(new SelectionListener() {

				public void widgetDefaultSelected(SelectionEvent e) {
					// do nothing
				}

				public void widgetSelected(SelectionEvent e) {
					selectedColumn(e);
				}
			});
		}
	}

	private void selectedColumn(SelectionEvent e) {
		Integer col = mapColumn.get(e.getSource());
		if (col != null) {
			comparator.setSortKey(col.intValue());
			tableViewer.refresh();
		}
	}

	//	private void updateToolBarActions() {
	//		this.addExpressionToolItem.setEnabled(dmo.isPublicEditable());
	//	}

	//	private void updateLinkButton() {
	//		DeployLink link = getRequirementLink();
	//		Topology topology = null;
	//		if (link == null || ((topology = link.getTopology()) != null && topology != link.getEditTopology())) {
	//			deleteTargetButton.setEnabled(false);
	//			deleteTargetButton.setImage(DeployCoreUIPlugin.getDefault().getSharedImages().getImage(ISharedImages.IMG_DELETE_LINK_DISABLED));
	//		} else {
	//			deleteTargetButton.setEnabled(true);
	//			deleteTargetButton.setImage(DeployCoreUIPlugin.getDefault().getSharedImages().getImage(ISharedImages.IMG_DELETE_LINK));
	//		}
	//	}

	//	/**
	//	 * This method should only be called if the composite is created for a popup.
	//	 * @param isPopup
	//	 * 		Pass true if this composite is used within a {@link PopupDialog}.
	//	 * @param parentPopupShell
	//	 * 		Pass the parent {@link Shell} if this is a secondary {@link PopupDialog}.
	//	 */
	//	public void setPopupDialog(boolean isPopup, Shell parentPopupShell) {
	//		this.isPopup = isPopup;
	//		this.parentPopupShell = parentPopupShell;
	//	}

	/**
	 * @param newLinks
	 */
	public void setInput(List<DeployLink> newLinks) {
		List<LinkRow> rowInput = new LinkedList<LinkRow>();

		for (Iterator<DeployLink> it = newLinks.iterator(); it.hasNext();) {
			DeployLink deployLink = it.next();
			rowInput.add(LinksPropertySection2.createRowForLink(deployLink, true));
		}

		tableViewer.setInput(rowInput);
		links = rowInput;

		if (tableViewer.getTable().getItemCount() > 0) {
			tableViewer.getTable().select(0);

			LinkRow lr = getSelectedLink();
			if (lr != null) {
				setDeployModelObject(lr);
			}
			//setConstraintSectionLabel();
		}
	}

	private void setDeployModelObject(LinkRow lr) {
		if (deployModelObject != null) {
			stopListeningForChanges();
		}

		deployModelObject = lr.getObjectForPopup();

		listenForChanges();

		tabbedComposite.setInput(deployModelObject);
	}

	private void listenForChanges() {
		if (deployModelObject != null && deployModelObject.getEditTopology() != null) {
			// We can't register a more specific listener, because we need to
			// be informed if any DeployLink attributes change as this might effect
			// the link's title.
			deployModelObject.getEditTopology().addTopologyListener(eventListener,
					Topology.WILDCARD_LISTENER);
		}
	}

	private void stopListeningForChanges() {
		if (deployModelObject != null && deployModelObject.getEditTopology() != null) {
			deployModelObject.getEditTopology().removeTopologyListener(eventListener,
					Topology.WILDCARD_LISTENER);
		}
	}

	private static class ListContentProvider implements IStructuredContentProvider {

		private final static Object[] NONE = new Object[0];

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof List) {
				return ((List<?>) inputElement).toArray();
			}

			return NONE;
		}

		public void dispose() {
			// do nothing
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// do nothing
		}

	}

	private static class LinkTableLabelProvider extends LabelProvider implements
			ITableLabelProvider, ITableColorProvider {

		private final Color white;
		private final Color blue;
		private final Color black;

		protected LinkTableLabelProvider(Display display) {
			white = display.getSystemColor(SWT.COLOR_LIST_BACKGROUND);
			blue = display.getSystemColor(SWT.COLOR_BLUE);
			black = display.getSystemColor(SWT.COLOR_LIST_FOREGROUND);
		}

		public Image getColumnImage(Object element, int columnIndex) {
			if (element instanceof LinkRow) {
				LinkRow row = (LinkRow) element;
				return row.getColumnImage(columnIndex);
			}

			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof LinkRow) {
				LinkRow row = (LinkRow) element;
				return row.getColumnText(columnIndex);
			}

			return element.toString();
		}

		public Color getBackground(Object element, int columnIndex) {
			return white;
		}

		public Color getForeground(Object element, int columnIndex) {
			if (showAsHyperlink(element, columnIndex)) {
				return blue;
			}

			return black;
		}

		private boolean showAsHyperlink(Object element, int columnIndex) {
			if (element instanceof LinkRow) {
				LinkRow row = (LinkRow) element;
				return row.showAsHyperlink(columnIndex, null);
			}

			return false;
		}

	} // end class LinkTableLabelProvider

	private static class LinkTreeLabelViewerComparator extends ViewerComparator {
		private int sortKey;
		private final LinkTableLabelProvider lp;

		protected LinkTreeLabelViewerComparator(LinkTableLabelProvider labelProvider) {
			lp = labelProvider;
		}

		protected void setSortKey(int col) {
			sortKey = col;
		}

		public int compare(Viewer viewer, Object e1, Object e2) {
			if (e1 instanceof LinkRow && e2 instanceof LinkRow) {
				LinkRow row1 = (LinkRow) e1;
				LinkRow row2 = (LinkRow) e2;

				String name1 = lp.getColumnText(row1, sortKey);
				String name2 = lp.getColumnText(row2, sortKey);

				return name1.compareTo(name2);
			}

			return 0;
		}
	}

	/**
	 * 
	 */
	public void deleteSelectedLinks() {
		LinkRow lr = getSelectedLink();
		if (lr != null) {
			lr.unlink();

			// At this point it would be better if we got an update from some listener
			// that the delete happened.  However, we don't have a master object to ask
			// about current links, we calculated our links based on the mouse position
			// which we no longer have.  So just assume the delete happened.
			links.remove(lr);
			tableViewer.refresh(false);
		}
	}

	/**
	 * @return <code>true</code> if at least one link is selected and all selected links SHOULD be
	 *         deleteable.
	 */
	public boolean canDeleteSelectedLinks() {
		//		Collection<LinkRow> sel = getSelectedLinks();
		//		if (sel.size() == 0) {
		//			return false;
		//		}
		//		
		//		for (Iterator<LinkRow> it = sel.iterator(); it.hasNext();) {
		//			LinkRow lrow = it.next();
		//			if (!lrow.canRemove()) {
		//				return false;
		//			}
		//		}
		//		
		//		return true;

		LinkRow lr = getSelectedLink();
		return lr != null && lr.canRemove();
	}

	private LinkRow getSelectedLink() {
		if (tableViewer.getSelection() instanceof StructuredSelection) {
			StructuredSelection ss = (StructuredSelection) tableViewer.getSelection();
			if (ss.getFirstElement() instanceof LinkRow) {
				return (LinkRow) ss.getFirstElement();
			}
		}

		return null;
	}

	/**
	 * @param selectionListener
	 *           a listener that gets called when the selected links changes
	 */
	public void addSelectionListener(SelectionListener selectionListener) {
		tableViewer.getTable().addSelectionListener(selectionListener);
	}

	private class LinkPropertiesModifier implements ICellModifier {

		public boolean canModify(Object element, String property) {
			if (element instanceof LinkRow) {
				if (property.equals(Messages.LinkDetailComposite_Link_Nam_)) {
					return true;
				}
			}
			return false;
		}

		public Object getValue(Object element, String property) {

			if (element instanceof LinkRow) {
				if (property.equals(Messages.LinkDetailComposite_Link_Nam_)) {
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
					if (property.equals(Messages.LinkDetailComposite_Link_Nam_)) {
						LinkRow row = (LinkRow) element;
						DeployModelObject dmo = row.getObjectForPopup();
						if (dmo != null) {
							LinksPropertySection2.setDisplayName(dmo, value.toString());
						}
					}
				}
			}

			tableViewer.refresh();
		}

	} // end inner class LinkPropertiesModifier 

	private final Adapter eventListener = new AdapterImpl() {
		private String oldLabel;

		@Override
		public void notifyChanged(final Notification msg) {
			// We want to filter out notifications that don't change table values,
			// to prevent flicker during, for example, validation.

			// Change whenever a Link is added/removed, or if the
			// currently selected link's label changes.

			//BLB adding a Display synch here, this code is being accessed from a non ui thread.
			Display.getDefault().asyncExec(new Runnable() {

				public void run() {
					safeNotify(msg);

				}
			});

		}

		private void safeNotify(Notification msg) {
			LinkRow lr = getSelectedLink();
			if (lr != null) {
				DeployModelObject dmo = lr.getObjectForPopup();

				String newLabel = dmo != null ? PropertyUtils.getDmoName(dmo) : null;
				if (msg.getNotifier() instanceof DeployLink || msg.getNewValue() instanceof DeployLink
						|| msg.getOldValue() instanceof DeployLink || oldLabel != null
						&& !oldLabel.equals(newLabel)) {
					oldLabel = newLabel;

					if (!tableViewer.getTable().isDisposed()) {
						Display.getDefault().asyncExec(new Runnable() {
							public void run() {
								if (!tableViewer.getTable().isDisposed()) {
									tableViewer.refresh(true);
								}
							}

						});
					} // end if not disposed
				} // end if notification  might affect the links table
			} // end if getSelectedLink is not null
		}
	};
} // end class LinkDetailComposite
