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

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils.CollectiveHostingRequirement;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * Dialog for creating links. Presents all possible links. The selected link is created on 'OK'.
 * 
 * @author Ed Snible
 * @deprecated
 */
public class NewLinkDialog extends TitleAreaDialog {

//	private static final int RE_DIR = 0;
	private static final int RE_TYPE = 0;
	private static final int RE_SOURCE = 1;
	private static final int RE_TARGET = 2;
	private static final int RE_WEIGHT = 3;

	private final List matches;
	private final EditDomain gefDomain;
	private final String name;
	private TableViewer tviewer;

//	private Unit source;

	public NewLinkDialog(Shell parentShell, Requirement req, EditDomain ed) {
		this(parentShell, (Unit) req.getParent(), ed);
	}

	public NewLinkDialog(Shell parentShell, CollectiveHostingRequirement chr, EditDomain ed) {
		this(parentShell, chr.getUnit(), ed);
	}

	protected NewLinkDialog(Shell parentShell, Unit unit, EditDomain ed) {
		super(parentShell);

//		this.source = unit;
		matches = calculateMatches(unit);
		name = PropertyUtils.getName(unit);
		gefDomain = ed;
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText(Messages.NewLinkDialog_Create_New_Wir_);
	}

	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		GridLayout layout = new GridLayout();
		composite.setLayout(layout);

		addBasicSection(composite);

		initializeControls();

		applyDialogFont(composite);

		return composite;
	}

	protected Control createButtonBar(Composite parent) {
		Control c = super.createButtonBar(parent);

		dialogChanged();

		return c;
	}

	private void initializeControls() {
		tviewer.setInput(matches);
		setTitle(NLS.bind(Messages.NewLinkDialog_Source_Unit_0_, name));
	}

	private void addBasicSection(Composite parent) {

		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		GridLayout layout = new GridLayout();
		composite.setLayout(layout);

//		labelSource = new Label(composite, SWT.NONE);

		Table tableLinks = new Table(composite, SWT.BORDER | SWT.SINGLE | SWT.FULL_SELECTION/* |SWT.CHECK */);
		GridData gdTable = new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL);
//		gdTable.horizontalSpan = 4;
		gdTable.heightHint = 100;
		tableLinks.setLayoutData(gdTable);

		TableLayout tl = new TableLayout();
		tl.addColumnData(new ColumnWeightData(25)); // dir
		tl.addColumnData(new ColumnWeightData(30)); // source
		tl.addColumnData(new ColumnWeightData(30)); // target
		tl.addColumnData(new ColumnWeightData(15)); // weight
		tableLinks.setLayout(tl);
		tableLinks.setHeaderVisible(true);
		tableLinks.setLinesVisible(true);

		tviewer = new TableViewer(tableLinks);
		LinkTableProvider prov = new LinkTableProvider(/* parent.getShell() */);
		tviewer.setContentProvider(prov);
		tviewer.setLabelProvider(prov.getPropLabelProvider());

		String[] colHeaders = new String[] { Messages.LinksPropertySection_Directio_,
				Messages.NewLinkDialog_Source_Requirement_, Messages.NewLinkDialog_Target_Unit_,
				"Relevance" }; //$NON-NLS-1$
		for (int i = 0; i < colHeaders.length; i++) {
			TableColumn col = new TableColumn(tableLinks, SWT.LEFT);
			col.setText(colHeaders[i]);
			col.setWidth(115);
		}

		tableLinks.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				// do nothing
			}

			public void widgetSelected(SelectionEvent e) {
				dialogChanged();
			}
		});
	}

	private void dialogChanged() {
		if (matches.size() == 0) {
			updateStatus(Messages.NewLinkDialog_No_matching_targets_);
			return;
		}

		if (noLinksSelected()) {
			updateStatus(Messages.NewLinkDialog_Select_wire_to_create_);
			return;
		}

		updateStatus(null);
	}

	private boolean noLinksSelected() {
//		TableItem[] ati = tviewer.getTable().getItems();
//		for (int i = 0; i < ati.length; i++) {
//			if (ati[i].getChecked()) {
//				return false;
//			}
//		}
//		
//		return true;
		if (tviewer.getSelection() instanceof StructuredSelection) {
			StructuredSelection ss = (StructuredSelection) tviewer.getSelection();
			return ss.size() == 0;
		}

		return false;
	}

	private void updateStatus(String message) {
		setErrorMessage(message);
		getButton(IDialogConstants.OK_ID).setEnabled(message == null);
	}

	protected void okPressed() {
		// Get the LinkDescriptors matching the user's selection
		TransactionalEditingDomain domain = null;
		List linksToCreate = new LinkedList();
//		TableItem[] ati = tviewer.getTable().getItems();
//		for (int i = 0; i < ati.length; i++) {
//			if (ati[i].getChecked()) {
//				linksToCreate.add(ati[i].getData());
//				if (domain == null) {
//					LinkDescriptor ld = (LinkDescriptor) ati[i].getData();
//					domain = TransactionUtil.getEditingDomain(ld.getSource());
//				}
//			}
//		}
		if (tviewer.getSelection() instanceof StructuredSelection) {
			StructuredSelection ss = (StructuredSelection) tviewer.getSelection();
			if (ss.getFirstElement() instanceof LinkDescriptor) {
				LinkDescriptor ld = (LinkDescriptor) ss.getFirstElement();
				linksToCreate.add(ld);
				domain = TransactionUtil.getEditingDomain(ld.getSource());
			}
		}

		// Simply executing the descriptor wouldn't give us an UNDO history
		// or transaction safety. Do it within a transaction.
		LinkDescriptorCreateRelationshipCommand ldcrc = new LinkDescriptorCreateRelationshipCommand(
				domain, linksToCreate);
		Command command = new ICommandProxy(ldcrc);
		gefDomain.getCommandStack().execute(command);

		super.okPressed();
	}

	/**
	 * @return a List of LinkDescriptor
	 */
	private List calculateMatches(Unit src) {
//    	LinkType[] atypes = new LinkType[] {LinkType.DEPENDENCY, LinkType.LOGICAL, LinkType.HOSTING };
		final LinkType[] forwardTypes = new LinkType[] { LinkType.DEPENDENCY, LinkType.CONSTRAINT };
		final LinkType[] backwardTypes = new LinkType[] { LinkType.HOSTING, LinkType.CONSTRAINT };

		DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();

		List retVal = new LinkedList();
		LinkDescriptor[] ald;

		Topology top = src.getTopology();
		for (Iterator it = top.getUnits().iterator(); it.hasNext();) {
			Unit candidate = (Unit) it.next();
			// MK 10/2/2006 removed conditional to allow an EjbModule to satisify its own ebj-ref
			//if (candidate != src) {
			ald = dvs.getPossibleLinks(candidate, src, backwardTypes);
			if (/* status.isOK() */ald.length > 0) {
				retVal.addAll(Arrays.asList(ald));
			}

			//MK 11/06/2006 removed System.out.println
			//System.out.println ("src: " + src); //$NON-NLS-1$
			//System.out.println ("candidate: " + candidate); //$NON-NLS-1$
			ald = dvs.getPossibleLinks(src, candidate, forwardTypes);
			//System.out.println ("links: " + ald.length); //$NON-NLS-1$
			if (/* status.isOK() */ald.length > 0) {
				retVal.addAll(Arrays.asList(ald));
			}

			// NOTE: The above will only find links FROM this node TO another
			// node on the current topology.  Kirk has demanded we not be able
			// to discover links TO this node.  We also don't consider the possibility
			// of showing "discoverable" links -- this dialog is only about creating
			// new links.

//				// Go the other way, too
//				ald = dvs.getPossibleLinks(src, candidate, backwardTypes);
//				if (/*status.isOK()*/ ald.length > 0) {
//					retVal.addAll(Arrays.asList(ald));
//				}
//				
//				// Go the other way, too
//				ald = dvs.getPossibleLinks(candidate, src, forwardTypes);
//				if (/*status.isOK()*/ ald.length > 0) {
//					retVal.addAll(Arrays.asList(ald));
//				}
			//}
		}

		return retVal;
	}

	private class LinkTableProvider implements IStructuredContentProvider {

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof List) {
				List res = (List) inputElement;
				return res.toArray();
			}

			throw new IllegalStateException(
					"LinkTableProvider Unexpected type: " + inputElement.getClass()); //$NON-NLS-1$
		}

		public void dispose() {
			// do nothing
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// do nothing
		}

		protected IBaseLabelProvider getPropLabelProvider() {
			return new LinkLabelProvider(/* shell */);
		}

	} // end static inner class RETableProvider

	private static class LinkLabelProvider extends LabelProvider implements ITableLabelProvider {

		private static Image DEPENDENCY;
		private static Image HOSTING;

		public Image getColumnImage(Object element, int columnIndex) {
			LinkDescriptor ld = (LinkDescriptor) element;

			if (columnIndex == RE_TYPE) {
				if (ld.getType() == LinkType.HOSTING) {
					return getHostingLinkImage();
				} else if (ld.getType() == LinkType.DEPENDENCY) {
					return getDependencyLinkImage();
				} else if (ld.getType() == LinkType.CONSTRAINT) {
					// TODO We need a link type
					return null;
				}
			}

			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			LinkDescriptor ld = (LinkDescriptor) element;

			switch (columnIndex)
			{
			case RE_TYPE:
				return ld.getType().getDescription();
			case RE_SOURCE:
				// Because the GUI draws hosting in the opposite direction has the
				// LinkDescriptor thinks about source/target, reverse directions
				Unit from = ld.getType() == LinkType.HOSTING ? ld.getTargetUnit() : ld.getSourceUnit();
				return PropertyUtils.getName(from);
			case RE_TARGET:
				Unit to = ld.getType() == LinkType.HOSTING ? ld.getSourceUnit() : ld.getTargetUnit();
				return PropertyUtils.getName(to);
			case RE_WEIGHT:
				return calculateWeightString(ld.getLinkWeight());
			}

			return ""; //$NON-NLS-1$
		}

		private String calculateWeightString(int linkWeight) {
			return linkWeight + " %"; //$NON-NLS-1$
		}

		private Image getDependencyLinkImage() {
			if (DEPENDENCY == null) {
				DEPENDENCY = PropertyUtils.createImage("icons/obj16/dependen_rqrmnt.gif"); //$NON-NLS-1$;
			}

			return DEPENDENCY;
		}

		private Image getHostingLinkImage() {
			if (HOSTING == null) {
				HOSTING = PropertyUtils.createImage("icons/obj16/host_rqrmnt.gif"); //$NON-NLS-1$;
			}

			return HOSTING;
		}

	} // end static inner class RELabelProvider

	private static class LinkDescriptorCreateRelationshipCommand extends
			AbstractTransactionalCommand {

		private final List linksToCreate;

		protected LinkDescriptorCreateRelationshipCommand(TransactionalEditingDomain domain,
				List linksToCreate) {
			super(domain, Messages.NewLinkDialog_Create_Link_, null);

			this.linksToCreate = linksToCreate;
		}

		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) /*
																															 * throws
																															 * ExecutionException
																															 */{
			for (Iterator it = linksToCreate.iterator(); it.hasNext();) {
				LinkDescriptor ld = (LinkDescriptor) it.next();
				ld.create();
			}

			//CanonicalUtils.refreshAll(true);
			return CommandResult.newOKCommandResult();
		}

	}

} // end class NewLinkDialog
