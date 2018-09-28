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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gmf.runtime.common.ui.services.icon.IconOptions;
import org.eclipse.gmf.runtime.common.ui.services.icon.IconService;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.wst.common.frameworks.internal.ui.TimedModifyListener;

import com.ibm.ccl.soa.deploy.core.Agreement;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

/**
 * &lt;propertySection filter=&gt; for Imported Topology
 * 
 * @author Ed Snible
 */
public class ImportPropertySection extends AbstractTopologyPropertySection {

	private static final int TITLE_NAME = 0;
	private static final int PUBLIC_LINKABLE = 1;
	private static final int PUBLIC_EDITABLE = 2;

	private TableViewer tviewer;
	private Action focusAction;
	private DisplayNameViewerComparator comparator;
	private Import imp;
	private Label labelPattern;
	private Label labelNamespace;
	private Composite composite;
	private AgreementLabelProvider labelProvider;
	private Text captionText;
	private ChangeScope<Import, DeploymentTopologyDomain> scope;
	private PausableTimedModifyListener captionTimedModifyListener;

	/**
	 * 
	 */
	public ImportPropertySection() {
	}

	public void doCreateControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		// Create a new section to wrap and layout our table
		composite = getWidgetFactory().createComposite(parent);
		composite.setLayout(new GridLayout());
		createCaptionSection(composite);
		createPatternSection(composite);
		createNamespaceSection(composite);

		Table table = getWidgetFactory().createTable(composite,
				SWT.BORDER | SWT.SINGLE | SWT.FULL_SELECTION);
		GridData gdTable = new GridData();
		gdTable.widthHint = 650;
		gdTable.heightHint = 150;
		table.setLayoutData(gdTable);

		tviewer = new TableViewer(table);
		//		provider = new ImportTableProvider();
		//		tviewer.setContentProvider(provider);
		tviewer.setContentProvider(new AgreementTableProvider());
		//		labelProvider = provider.getPropLabelProvider();
		labelProvider = new AgreementLabelProvider();
		comparator = new DisplayNameViewerComparator(labelProvider);
		tviewer.setComparator(comparator);
		tviewer.setLabelProvider(labelProvider);

		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_PROPERTIES_INTERFACE_TAB);

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
				Messages.RequirementsPopupDialog_Publi_,
				Messages.RequirementsPopupDialog_Public_Editabl_ };
		for (int i = 0; i < colHeaders.length; i++) {
			TableColumn col = new TableColumn(table, SWT.LEFT);
			col.setText(colHeaders[i]);
			col.setWidth(230);
		}

		createActions();
	}

	private void createCaptionSection(Composite parent) {
		Composite c = getWidgetFactory().createComposite(parent);
		c.setLayout(new GridLayout(2, false));
		c.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		getWidgetFactory().createLabel(c, Messages.ImportPropertySection_Caption_);
		captionText = getWidgetFactory().createText(c, ""); //$NON-NLS-1$
		captionText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		final Text text = captionText;
		captionTimedModifyListener = new PausableTimedModifyListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (text.isDisposed()) {
					return;
				}

				final String temp = text.getText();
				AbstractEMFOperation op = new AbstractEMFOperation(TransactionUtil
						.getEditingDomain(imp), NLS.bind(
						Messages.ImportPropertySection_Set_Caption_to_0_, temp)) {

					@Override
					protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
							throws ExecutionException {
						imp.setDisplayName(temp);
						return Status.OK_STATUS;
					}

					@Override
					protected void didUndo(Transaction tx) {
						captionText.setText(imp.getDisplayName());
						super.didUndo(tx);
					}

					@Override
					protected void didRedo(Transaction tx) {
						captionText.setText(imp.getDisplayName());
						super.didRedo(tx);
					}
				};
				LightweightOperationFactory.addUndoContext(op, imp);
				if (scope != null) {
					scope.execute(op, ChangeScope.OPTION_DO_NOT_SAVE, new NullProgressMonitor());
				}
			}
		}) {
		};
		captionText.addModifyListener(captionTimedModifyListener);

	}

	private void createNamespaceSection(Composite parent) {
		Composite c = getWidgetFactory().createComposite(parent);
		c.setLayout(new GridLayout(2, false));

		getWidgetFactory().createLabel(c, Messages.TopologyPropertySection_Namespace);
		labelNamespace = getWidgetFactory().createLabel(c, ""); //$NON-NLS-1$
	}

	private void createPatternSection(Composite parent) {
		Composite c = getWidgetFactory().createComposite(parent);
		c.setLayout(new GridLayout(2, false));

		getWidgetFactory().createLabel(c, Messages.ImportPropertySection_Pattern_);
		labelPattern = getWidgetFactory().createLabel(c, ""); //$NON-NLS-1$
	}

	private void createActions() {

		String jump = Messages.ConfigurationsPropertySection2_Go_T_;
		focusAction = propAction(jump, "icons/elcl16/goto_linktarget.gif", new Action() { //$NON-NLS-1$
					public void run() {
						jumpToImport();
					}
				});
	}

	private Action propAction(String msg, String icon, Action a) {
		a.setText(msg);
		a.setToolTipText(msg);
		ImageDescriptor id = PropertyUtils.createImageDescriptor(icon);
		Image image = DeployCoreUIPlugin.getDefault().getSharedImages().getImageFromPath(icon, false);
		if (image != null) {
			a.setDisabledImageDescriptor(ImageDescriptor.createFromImage(image));
		}
		a.setImageDescriptor(id);
		return a;
	}

	protected void enableDisableButtons() {
	}

	@Override
	protected void setInput(DeployModelObject input) {
		if (input instanceof Import) {
			setInput((Import) input);
		}

	}

	@Override
	public void doDispose() {
		if (composite != null) {
			composite.dispose();
		}
		if (scope != null) {
			scope.close(new NullProgressMonitor());
		}
	}

	private void setInput(Import input) {
		imp = input;
		if (scope != null) {
			//Need to close out our change scope to avoid scribbler exceptions
			scope.close(new NullProgressMonitor());
		}
		if (input != null && input.getEObject().eResource() != null) {
			scope = ChangeScope.createChangeScopeForWrite(input);
		}

		if (input != null) {
			InstanceConfiguration ic = input.getInstanceConfiguration();
			labelProvider.setAgreement(ic);
			//			tviewer.setInput(imp);
			tviewer.setInput(ic);
		}

		if (tviewer.getTable().getItemCount() > 0) {
			tviewer.getTable().setSelection(0);
		}
		//Turn off the keyListener first.
		captionTimedModifyListener.setPaused(true);
		try {
			String s = input.getDisplayName();
			captionText.setText(s != null ? s : IConstants.EMPTY_STRING);
		} finally {
			captionTimedModifyListener.setPaused(false);
		}
		labelPattern.setText(input.getPattern());
		labelNamespace.setText(input.getNamespace());
		labelPattern.pack(); //Pack it up so our labels show up
		composite.layout(); //Relayout

		enableDisableButtons();
	}

	public void doAboutToBeShown() {
		if (imp != null) {

			// Refresh the table, in case a user in the structure editor added or delete a capability
			tviewer.refresh();
		}
	}

	public void refresh() {

		if (!tviewer.getTable().isDisposed()) {
			tviewer.refresh();
		}
	}

	@Override
	protected void addMenuActions(IMenuManager menu) {
		actionBars.getMenuManager().add(focusAction);
	}

	@Override
	protected void addToolBarActions(IToolBarManager toolbar) {
		actionBars.getToolBarManager().add(focusAction);
	}

	private void jumpToImport() {

		if (imp.eResource() != null) {
			IProject context = WorkbenchResourceHelper.getProject(imp.eResource());
			IFile topologyFile = NamespaceCore.resolveTopology(context, imp.getQualifiedImport());

			if (topologyFile != null) {
				IEditorRegistry registry = PlatformUI.getWorkbench().getEditorRegistry();
				IEditorDescriptor currentDescriptor = registry.getDefaultEditor(topologyFile.getName());
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
						.getActivePage();
				if (page != null) {
					FileEditorInput input = new FileEditorInput(topologyFile);
					try {
						/* DeployCoreEditor editor = (DeployCoreEditor) */
						page.openEditor(input, currentDescriptor.getId());
					} catch (PartInitException e) {
						MessageDialog
								.openError(
										null,
										com.ibm.ccl.soa.deploy.core.ui.Messages.Redirecting_Editor_1,
										NLS
												.bind(
														com.ibm.ccl.soa.deploy.core.ui.Messages.DeployCoreEditor_Could_not_successfully_load_the_mod_,
														input));

					}
				}
			}
		}
	}

	private static class PausableTimedModifyListener extends TimedModifyListener {
		private boolean isPaused = false;

		private PausableTimedModifyListener(ActionListener listener) {
			super(300, listener);
		}

		@Override
		public void modifyText(ModifyEvent e) {
			if (!isPaused) {
				super.modifyText(e);
			}
		}

		void setPaused(boolean aBoolean) {
			isPaused = aBoolean;
		}
	}

	private static class DisplayNameViewerComparator extends ViewerComparator {

		private final ITableLabelProvider lp;
		private int sortKey;

		protected DisplayNameViewerComparator(ITableLabelProvider lp) {
			this.lp = lp;
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

	private static class AgreementTableProvider implements IStructuredContentProvider {

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof Agreement) {
				Agreement agreement = (Agreement) inputElement;
				return agreement.getPublicUnits().toArray();
			}

			return new Object[0];
		}

		public void dispose() {
			// do nothing
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// do nothing
		}

	}

	private static class AgreementLabelProvider extends LabelProvider implements ITableLabelProvider {

		private Agreement agreement;

		public Image getColumnImage(Object element, int columnIndex) {
			if (columnIndex == TITLE_NAME) {
				if (element instanceof EObject) {
					return IconService.getInstance().getIcon(new EObjectAdapter((EObject) element),
							IconOptions.GET_STEREOTYPE_IMAGE_FOR_ELEMENT.intValue());
				}
			}

			return null;
		}

		protected void setAgreement(Agreement agreement) {
			this.agreement = agreement;
		}

		public String getColumnText(Object element, int columnIndex) {
			switch (columnIndex)
			{
			case TITLE_NAME:
				return getTitle(element);
			case PUBLIC_LINKABLE:
				return linkable(element);
			case PUBLIC_EDITABLE:
				return editable(element);
			}

			return ""; //$NON-NLS-1$
		}

		private String editable(Object element) {
			return element instanceof DeployModelObject ? toString(agreement
					.isPublicEditable((DeployModelObject) element)) : element.getClass().getName();
		}

		private String linkable(Object element) {
			return element instanceof DeployModelObject ? toString(agreement
					.isPublicEditable((DeployModelObject) element)) : element.getClass().getName();
		}

		private String toString(boolean b) {
			return b ? Messages.ImportPropertySection_Ye_ : ""; //$NON-NLS-1$
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

	} // end private class  AgreementLabelProvider
} // end class TopologyDebugSection
