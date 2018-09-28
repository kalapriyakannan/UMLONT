/***************************************************************************************************
 * Copyright (c) 2003, 2008 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.ui.validator.resolution;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.ui.validator.resolution.Messages;
import com.ibm.ccl.soa.infrastructure.internal.emf.DynamicAdapterFactory;

/**
 * Shows a list of proposed and chosen realizations.
 * 
 * @since 7.0
 * @see MultiRealizationPopupDialog
 */
public class RealizationsCreatedComposite extends Composite implements RealizationMapperView {

	/**
	 * If <code>true</code> this UI displays configuration units.
	 */
	private final boolean allowConfigUnits = RealizationAssistantResolutionGenerator.allowConfigUnits;

	private static final int COL_MANUAL = 0;
	private static final int COL_SOURCE = 1;
	private static final int COL_TARGET = 2;

	private final TableViewer tv;
	private final RealizationMapHelper mapUtil;

	/**
	 * @param parent
	 * @param rmu
	 */
	public RealizationsCreatedComposite(Composite parent, RealizationMapHelper rmu) {
		super(parent, SWT.NULL);

		mapUtil = rmu;

		setLayout(new GridLayout());

		Table table = new Table(this, SWT.V_SCROLL | SWT.BORDER | SWT.MULTI | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		GridData gdTable = new GridData(SWT.FILL, SWT.FILL, true, true);
		gdTable.heightHint = 160;
		table.setLayoutData(gdTable);

		TableColumn manualColumn = new TableColumn(table, SWT.CENTER);
		manualColumn.setWidth(75);
		manualColumn.setResizable(true);
		manualColumn.setText(""); //$NON-NLS-1$

		TableColumn sourceColumn = new TableColumn(table, SWT.NONE);
		sourceColumn.setWidth(200);
		sourceColumn.setResizable(true);
		sourceColumn.setText(Messages.RealizationsCreatedComposite_Sourc_);

		TableColumn targetColumn = new TableColumn(table, SWT.NONE);
		targetColumn.setWidth(200);
		targetColumn.setResizable(true);
		targetColumn.setText(Messages.RealizationsCreatedComposite_Targe_);

		table.addMouseTrackListener(new MappingTableMouseTrackListener());

		tv = new TableViewer(table);
		tv.setLabelProvider(new MappingsLabelProvider());
		tv.setContentProvider(new MappingsContentProvider());

		if (!allowConfigUnits) {
			tv.addFilter(new NonConfigFilter());
		}

		initControls();
	}

	private void initControls() {
		tv.setInput(mapUtil.getMappings());
	}

//	private static String getName(DeployModelObject dmo) {
//		if (dmo instanceof Unit) {
//			Unit unit = (Unit) dmo;
//			return unit.getCaptionProvider().title(unit);
//		}
//
//		return dmo.getDisplayName() == null ? dmo.getName() : dmo.getDisplayName();
//	}

	public void refreshRealizationLinks() {
		tv.refresh();
	}

	public void refreshSourceUnits() {
		// Does nothing
	}

	public void refreshUnrealCount() {
		// Does nothing
	}

	public void selectRealizationLink(RealizationLink realizationLink) {
		tv.setSelection(new StructuredSelection(realizationLink));
	}

	private static String getNameWithContext(DeployModelObject dmo) {
		if (dmo instanceof Unit) {
			Unit unit = (Unit) dmo;
			return unit.getCaptionProvider().titleWithContext(unit);
		}

		return PropertyUtils.getSoaLabelProvider().getText(dmo);
	}

	private class MappingsLabelProvider extends LabelProvider implements ITableLabelProvider {

		private ILabelProvider emfLabelProvider;
		private final ILabelProvider soaLabelProvider = PropertyUtils.getSoaLabelProvider();

		public Image getColumnImage(Object element, int columnIndex) {
			if (element instanceof RealizationLink) {
				RealizationLink rlink = (RealizationLink) element;
				if (columnIndex == COL_SOURCE) {
					DeployModelObject dmo = rlink.getSource();
					return getEmfLabelProvider(dmo).getImage(dmo);
				} else if (columnIndex == COL_TARGET) {
					DeployModelObject dmo = rlink.getTarget();
					return getEmfLabelProvider(dmo).getImage(dmo);
				}
			}

			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof RealizationLink) {
				RealizationLink rlink = (RealizationLink) element;
				DeployModelObject dmo;
				if (columnIndex == COL_MANUAL) {
//					if (rlink == mapUtil.getProposed()) {
					if (mapUtil.getProposed() != null && mapUtil.getProposed().contains(rlink)) {
						return Messages.RealizationsCreatedComposite_Propose_;
					}
					return Messages.RealizationsCreatedComposite_Manua_;
//					dmo = rlink.getSource();
//					return mapUtil.manuallyAdded(dmo) ? Messages.RealizationsCreatedComposite_Manua_
//							: Messages.RealizationsCreatedComposite_Compute_;
				} else if (columnIndex == COL_SOURCE) {
					dmo = rlink.getSource();
				} else {
					dmo = rlink.getTarget();
				}

				return soaLabelProvider.getText(dmo);
			}

			return element.getClass().getName();
		}

		private ILabelProvider getEmfLabelProvider(Object element) {
			if (emfLabelProvider == null) {
				emfLabelProvider = new AdapterFactoryLabelProvider(new DynamicAdapterFactory(null));
			}

			return emfLabelProvider;
		}

	} // end inner class

	private static class MappingsContentProvider implements IStructuredContentProvider {

		public void dispose() {
			// do nothing
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// do nothing
		}

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof Collection) {
				Collection<?> c = (Collection<?>) inputElement;
				return c.toArray();
			}

			return null;
		}

	} // end inner class

	private class MappingTableMouseTrackListener extends MouseTrackAdapter {

		public void mouseHover(MouseEvent event) {
			String tipText = null;

			if (event.widget instanceof Table) {
				Table table = (Table) event.widget;
				TableItem item = table.getItem(new Point(event.x, event.y));
				if (item != null) {
					if (item.getData() instanceof RealizationLink) {
						RealizationLink rlink = (RealizationLink) item.getData();

						int col = getColumn(table, item, new Point(event.x, event.y));
						DeployModelObject dmo = null;
						if (col == COL_SOURCE) {
							dmo = rlink.getSource();
						} else if (col == COL_TARGET) {
							dmo = rlink.getTarget();
						}

						if (dmo != null) {
							tipText = getNameWithContext(dmo);
						}
					}
				}
			}

			tv.getTable().setToolTipText(tipText);
		} // end method mouseHover()

		private int getColumn(Table table, TableItem item, Point pt) {
			for (int i = 0; i < table.getColumnCount(); i++) {
				Rectangle bounds = item.getBounds(i);
				if (bounds.contains(pt)) {
					return i;
				}
			}

			// On failure default to first column 
			return COL_MANUAL;
		}

	} // end inner class

	private static class NonConfigFilter extends ViewerFilter {

		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			if (element instanceof RealizationLink) {
				RealizationLink rlink = (RealizationLink) element;
				if (rlink.getSource() instanceof Unit) {
					Unit unit = (Unit) rlink.getSource();
					return !unit.isConfigurationUnit();
				}
			}

			return true;
		}

	} // end inner class

	/**
	 * @return controls that shouldn't be colored by their container
	 */
	public Collection<Control> getBackgroundColorExclusions() {
		return Collections.singletonList(tv.getControl());
	}

}
