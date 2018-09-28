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

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;
import org.eclipse.wst.common.frameworks.internal.datamodel.ui.DataModelWizardPage;

import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.datamodels.LinkDiscoveryDataModel;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.DiscoveryDescriptor;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.ILinkDiscoveryDataModelProperties;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.internal.core.extension.DiscoverAndAddService;

/**
 * @author Ed Snible
 * @see NewLinkWizard
 */
public class SelectMatchPage extends DataModelWizardPage {

	private static final String PAGE_NAME = "DiscoveryMatchSelect"; //$NON-NLS-1$
	//private static final int RE_TYPE = 0;
	private static final int RE_SOURCE = 0;
	private static final int RE_TARGET = 1;
	private static final int RE_MATCH = 2;
	private static final int RE_TOPOLOGY = 3;

	private CheckboxTableViewer tviewer;
	private final LinkDiscoveryDataModel linkDiscoveryDataModel;
	private Composite parentComposite;

	protected SelectMatchPage(IDataModel model) {
		super(model, PAGE_NAME);
		linkDiscoveryDataModel = new LinkDiscoveryDataModel(model);
	}

	public Composite createTopLevelComposite(Composite parent) {
		parentComposite = parent;
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout());
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		Table tableLinks = new Table(composite, SWT.BORDER | SWT.CHECK | SWT.MULTI | SWT.FLAT
				| SWT.FULL_SELECTION);
		tableLinks.setLayoutData(new GridData(GridData.FILL_BOTH));
		TableLayout tl = new TableLayout();
		//tl.addColumnData(new ColumnWeightData(30)); // type
		tl.addColumnData(new ColumnWeightData(35)); // source
		tl.addColumnData(new ColumnWeightData(35)); // target
		tl.addColumnData(new ColumnWeightData(15)); // match
		tl.addColumnData(new ColumnWeightData(15)); // topology
		tableLinks.setLayout(tl);
		tableLinks.setHeaderVisible(true);
		tableLinks.setLinesVisible(true);
		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.widthHint = 500;
		gridData.heightHint = 100;
		tableLinks.setLayoutData(gridData);
		tviewer = new CheckboxTableViewer(tableLinks);
		LinkContentProvider prov = new LinkContentProvider();
		tviewer.setContentProvider(prov);
		tviewer.setLabelProvider(new LinkLabelProvider());
		tviewer.getTable().setSortDirection(SWT.DOWN);
		tviewer.setComparator(new ViewerComparator() {

			@Override
			public int compare(Viewer viewer, Object e1, Object e2) {
				Table table = ((TableViewer) viewer).getTable();
				TableColumn sortColumn = table.getSortColumn();
				int col_index = RE_MATCH;
				if (sortColumn != null) {
					col_index = table.indexOf(sortColumn);
				}
				ITableLabelProvider provider = (ITableLabelProvider) ((TableViewer) viewer)
						.getLabelProvider();
				String s1 = provider.getColumnText(e1, col_index);
				String s2 = provider.getColumnText(e2, col_index);

				//Default for SWT.DOWN.
				String first = s2;
				String second = s1;

				if (table.getSortDirection() == SWT.UP) {
					first = s1;
					second = s2;
				}

				if (col_index == RE_MATCH) {
					boolean isFirstEmpty = first == null || first.length() == 0;
					boolean isSecondEmpty = second == null || second.length() == 0;

					if (isFirstEmpty) {
						if (isSecondEmpty) {
							return 0;
						}
						return -1;
					} else if (isSecondEmpty) {
						if (isFirstEmpty) {
							return 0;
						}
						return 1;
					}

					//Compare integers.
					Integer firstInt = Integer.valueOf(first.substring(0, first.length() - 1));
					Integer secondInt = Integer.valueOf(second.substring(0, second.length() - 1));
					return firstInt.compareTo(secondInt);
				}
				return getComparator().compare(first, second);
			}
		});
		String[] colHeaders = new String[] { Messages.LinksPropertySection2_Sourc_,
				Messages.LinksPropertySection2_Targe_, Messages.CreateDependencyLinkDialog_Matc_,
				Messages.SelectMatchPage_Topolog_ };
		for (int i = 0; i < colHeaders.length; i++) {
			TableColumn col = new TableColumn(tableLinks, SWT.LEFT);
			col.setText(colHeaders[i]);
			//col.setWidth(115);
			if (i == RE_MATCH) {
				//set default sort column
				tviewer.getTable().setSortColumn(col);
				tviewer.getTable().setSortDirection(toggleSortDirection(col));
			}
			col.addSelectionListener(new SelectionAdapter() {

				public void widgetSelected(SelectionEvent e) {
					// Header was selected so sort the table by this column.
					TableColumn column = (TableColumn) e.getSource();
					Table table = tviewer.getTable();
					table.setSortColumn(column);
					int direction = toggleSortDirection(column);
					table.setSortDirection(direction);
					tviewer.refresh();
				}

			});
		}

		synchHelper.synchCheckBoxTableViewer(tviewer, ILinkDiscoveryDataModelProperties.DESCRIPTORS,
				new Control[0]);

		Label legendLabel = new Label(composite, SWT.NONE);
		legendLabel.setText(Messages.TOPOLOGY_DISCOVERY_WIZARD_UNIT_NOT_IN_TOPOLOGY_LABEL);
		return composite;
	}

	protected int toggleSortDirection(TableColumn column) {
		Object data = column.getData();
		if (data == null) {
			//Set initial direction
			column.setData(new Integer(SWT.DOWN));
			return SWT.DOWN;
		}
		switch (((Integer) data).intValue())
		{
		case SWT.DOWN:
			column.setData(new Integer(SWT.UP));
			return SWT.UP;
		case SWT.UP:
			column.setData(new Integer(SWT.DOWN));
			return SWT.DOWN;
		}
		return SWT.DOWN;
	}

	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			populate();

			if (linkDiscoveryDataModel.getIsHosting()) {
				setDescription(Messages.TOPOLOGY_DISCOVERY_WIZARD_PAGE2_DESC);
				setTitle(Messages.TOPOLOGY_DISCOVERY_WIZARD_PAGE2_TITLE);
			} else if (linkDiscoveryDataModel.getIsDependency()) {
				setDescription(Messages.TOPOLOGY_DISCOVERY_WIZARD_DEPENDENCY_DESC1);
				setTitle(Messages.TOPOLOGY_DISCOVERY_WIZARD_DEPENDENCY_TITLE);
			} else if (linkDiscoveryDataModel.getIsGroup()) {
				setDescription(Messages.TOPOLOGY_DISCOVERY_WIZARD_MEMBER_DESC);
				setTitle(Messages.TOPOLOGY_DISCOVERY_WIZARD_MEMBER_TITLE);
//			} else if (linkDiscoveryDataModel.getIsLogical()) {
//				setDescription(Messages.TOPOLOGY_DISCOVERY_WIZARD_CONSTRAINT_DESC);
//				setTitle(Messages.TOPOLOGY_DISCOVERY_WIZARD_CONSTRAINT_TITLE);
			}

			postSetFocusOnDialogField(tviewer.getTable(), getShell().getDisplay());

		}
	}

	private void populate() {

		List<DiscoveryDescriptor> possibilities = new LinkedList<DiscoveryDescriptor>();

		TableColumn tableColumn[] = tviewer.getTable().getColumns();

		if (linkDiscoveryDataModel.getIsHosting()) {
			List<DiscoveryDescriptor> hostOptions = wrapHostingTUDs(DiscoverAndAddService.INSTANCE
					.discoverHostUnitDescriptors(linkDiscoveryDataModel.getUnit()));
			possibilities.addAll(hostOptions);
			tableColumn[RE_SOURCE].setText(Messages.SelectMatchPage_Hostee_Uni_);
			tableColumn[RE_TARGET].setText(Messages.SelectMatchPage_Hoster_Uni_);
		} else if (linkDiscoveryDataModel.getIsDependency()) {
			Map<Requirement, List<LinkDescriptor>> m = null;
			if (linkDiscoveryDataModel.getRequirement() != null) {
				Requirement requirement = linkDiscoveryDataModel.getRequirement();
				m = DiscoverAndAddService.INSTANCE.discoverDependencyUnitDescriptors(requirement);

			} else {
				m = DiscoverAndAddService.INSTANCE
						.discoverDependencyUnitDescriptors(linkDiscoveryDataModel.getUnit());

			}
			if (m != null) {
				List<DiscoveryDescriptor> dependencyOptions = wrapDependencyTUDs(m);
				possibilities.addAll(dependencyOptions);
			}
			tableColumn[RE_SOURCE].setText(Messages.SelectMatchPage_Requiremen_);
			tableColumn[RE_TARGET].setText(Messages.SelectMatchPage_Capabilit_);
		} else if (linkDiscoveryDataModel.getIsGroup()) {
			List<DiscoveryDescriptor> memberOptions = wrapMemberTUDs(DiscoverAndAddService.INSTANCE
					.discoverContainerUnitDescriptors(linkDiscoveryDataModel.getUnit()));
			possibilities.addAll(memberOptions);

			tableColumn[RE_SOURCE].setText(Messages.SelectMatchPage_Membe_);
			tableColumn[RE_TARGET].setText(Messages.SelectMatchPage_Containe_);
//		} else if (linkDiscoveryDataModel.getIsLogical()) {
//			List<DiscoveryDescriptor> logicalOptions = wrapLogicalLDs(DiscoverAndAddService.INSTANCE
//					.discoverLogicalLinks(linkDiscoveryDataModel.getUnit()));
//			possibilities.addAll(logicalOptions);
//
//			tableColumn[RE_SOURCE].setText(Messages.SelectMatchPage_Sourc_);
//			tableColumn[RE_TARGET].setText(Messages.SelectMatchPage_Targe_);
		}

		tviewer.setInput(possibilities);

		if (possibilities.size() > 0) {
			tviewer.getTable().select(0);
		} else {
			setErrorMessage(Messages.SelectMatchPage_No_matching_Unit_);
		}
	}

	private void postSetFocusOnDialogField(final Control control, Display display) {
		if (display != null) {
			display.asyncExec(new Runnable() {
				public void run() {
					control.setFocus();
				}
			});
		}
	}

	private List<DiscoveryDescriptor> wrapDependencyTUDs(Map<Requirement, List<LinkDescriptor>> m) {
		List<DiscoveryDescriptor> retVal = new LinkedList<DiscoveryDescriptor>();

		for (Iterator<Map.Entry<Requirement, List<LinkDescriptor>>> it = m.entrySet().iterator(); it
				.hasNext();) {
			Map.Entry<Requirement, List<LinkDescriptor>> entry = /* (Map.Entry) */it.next();
			List<LinkDescriptor> l = /* (List) */entry.getValue();

			for (LinkDescriptor linkDescritpor : l) {
				retVal.add(new DiscoveryDescriptor(linkDescritpor));
			}
		}

		return retVal;
	}

	/**
	 * @param list
	 *           List of {@link UnitDescriptor}
	 */
	private List<DiscoveryDescriptor> wrapHostingTUDs(List<UnitDescriptor> list) {
		List<DiscoveryDescriptor> retVal = new LinkedList<DiscoveryDescriptor>();

		for (Iterator<UnitDescriptor> it = list.iterator(); it.hasNext();) {
			UnitDescriptor ud = /* (UnitDescriptor) */it.next();
			retVal.add(new DiscoveryDescriptor(ud, linkDiscoveryDataModel.getUnit(), ud.getUnitValue()
					.getTopology(), LinkType.HOSTING));
		}

		return retVal;
	}

	private List<DiscoveryDescriptor> wrapMemberTUDs(List<UnitDescriptor> list) {
		List<DiscoveryDescriptor> retVal = new LinkedList<DiscoveryDescriptor>();

		for (Iterator<UnitDescriptor> it = list.iterator(); it.hasNext();) {
			UnitDescriptor ud = /* (UnitDescriptor) */it.next();
			retVal.add(new DiscoveryDescriptor(ud, linkDiscoveryDataModel.getUnit(), ud.getUnitValue()
					.getTopology(), LinkType.MEMBER));
		}

		return retVal;
	}

//	private List<DiscoveryDescriptor> wrapLogicalLDs(Set<LinkDescriptor> s) {
//		List<DiscoveryDescriptor> retVal = new LinkedList<DiscoveryDescriptor>();
//		for (Iterator<LinkDescriptor> it = s.iterator(); it.hasNext();) {
//			retVal.add(new DiscoveryDescriptor(it.next()));
//		}
//		return retVal;
//	}

	static class LinkContentProvider implements IStructuredContentProvider {
		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof List) {
				List<?> res = (List<?>) inputElement;
				return res.toArray();
			}

			throw new IllegalStateException(
					"LinkContentProvider Unexpected type: " + inputElement.getClass()); //$NON-NLS-1$
		}

		public void dispose() {
			// do nothing
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// do nothing
		}

	}

	static class LinkLabelProvider extends LabelProvider implements ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			DiscoveryDescriptor dd = (DiscoveryDescriptor) element;

			if (columnIndex == RE_SOURCE) {
				String key = null;
				switch (dd.getType().getValue())
				{
				case LinkType.HOSTING_VALUE:
					key = ISharedImages.IMG_HOSTING_LINK_TYPE;
					break;

				case LinkType.DEPENDENCY_VALUE:
					key = ISharedImages.IMG_DEPENDENCY_LINK_TYPE;
					break;
				case LinkType.MEMBER_VALUE:
					key = ISharedImages.IMG_MEMBERSHIP_LINK_TYPE;
					break;
				}
				if (key != null) {
					return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(key);
				}
			}

			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			DiscoveryDescriptor dd = (DiscoveryDescriptor) element;
			switch (columnIndex)
			{
//			case RE_TYPE:
//				return dd.getType().getDescription();
			case RE_SOURCE:
				return dd.getSourceName();
			case RE_TARGET:
				return dd.getTargetName();
			case RE_MATCH:
				LinkDescriptor ld = dd.getDescriptor();
				if (ld != null) {
					return ld.getLinkWeight() + "%"; //$NON-NLS-1$
				}
				break;
			case RE_TOPOLOGY:
				return dd.getTopologyName();
			}

			return ""; //$NON-NLS-1$
		}
	}

	protected String[] getValidationPropertyNames() {
		String[] propertyNames = new String[] {
				ILinkDiscoveryDataModelProperties.IS_HOSTING,
				ILinkDiscoveryDataModelProperties.UNIT,
//				ILinkDiscoveryDataModelProperties.IS_LOGICAL,
				ILinkDiscoveryDataModelProperties.IS_DEPENDENCY,
				ILinkDiscoveryDataModelProperties.IS_GROUP,
				ILinkDiscoveryDataModelProperties.DESCRIPTORS,
				ILinkDiscoveryDataModelProperties.REQUIREMENT };
		return propertyNames;
	}

}
