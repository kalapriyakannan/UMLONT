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
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ColumnLayoutData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Property;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.operation.DeleteModelObjectOperation;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;

/**
 * Simple property section for the adding/removing/editing of variables from a topology.
 * 
 * @author Nkruk
 * 
 */
public class TopologyVariableSection extends AbstractTopologyPropertySection {
	private Topology topology;
	private Table table;
	private TableViewer tableViewer;
	private static final int NAME = 0;
	private static final int VALUE = 1;
	private Action createVariableAction;
	private Action deleteVariableAction;
	private Composite parentComposite;

	private static class NewVariableCreationDialog extends InputDialog {

		private NewVariableCreationDialog(Shell parentShell, String dialogTitle,
				String dialogMessage, String initialValue, IInputValidator validator) {
			super(parentShell, dialogTitle, dialogMessage, initialValue, validator);
		}

		protected Control createDialogArea(Composite parent) {
			PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
					IDeployHelpContextIds.TOPOLOGY_PROPERTIES_CREATE_NEW_VARIABLE);
			return super.createDialogArea(parent);
		}

	}

	protected static String[] tableColumnProperties = { Messages.TopologyVariableSection_Nam_,
			Messages.TopologyVariableSection_Valu_ };

	protected ColumnLayoutData[] tableColumnLayouts = { new ColumnWeightData(25),
			new ColumnWeightData(25) };

	/**
	 * Ctor
	 */
	public TopologyVariableSection() {
		super();
	}

	@Override
	public void doCreateControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		parentComposite = parent;

		Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayout(new GridLayout(1, false));
		comp.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_WHITE));

		createTableArea(comp);

		createActions(comp);
	}

	private void setCSHelp() {
		if (topology != null && parentComposite != null) {
			if (topology instanceof Import) {
				PlatformUI.getWorkbench().getHelpSystem().setHelp(parentComposite,
						IDeployHelpContextIds.TOPOLOGY_PROPERTIES_IMPORT_VARIABLES_TAB);
			} else {
				PlatformUI.getWorkbench().getHelpSystem().setHelp(parentComposite,
						IDeployHelpContextIds.TOPOLOGY_PROPERTIES_VARIABLES_TAB);
			}
		}
	}

	/**
	 * Create the Table area
	 * 
	 * @param parent
	 *           The parent to create this widget in
	 */
	private void createTableArea(Composite parent) {
		table = new Table(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION
				| SWT.MULTI);
		TableLayout tableLayout = new TableLayout();
		table.setLayout(tableLayout);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.widthHint = 500;
		gridData.heightHint = 200;
		table.setLayoutData(gridData);
		table.setFont(parent.getFont());
		table.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_WHITE));

		tableViewer = new TableViewer(table);
		tableViewer.setContentProvider(new VariableContentProvider());
		tableViewer.setLabelProvider(new VariableLabelProvider());
		// Create columns
		tableViewer.setColumnProperties(tableColumnProperties);
		for (int i = 0; i < tableColumnProperties.length; i++) {
			tableLayout.addColumnData(tableColumnLayouts[i]);
			TableColumn tc = new TableColumn(table, SWT.NONE, i);
			tc.setResizable(tableColumnLayouts[i].resizable);
			tc.setText(tableColumnProperties[i]);
		}

		tableViewer.setCellEditors(new org.eclipse.jface.viewers.CellEditor[] { null,
				new TextCellEditor(table) });

		ICellModifier cellMod = new ICellModifier() {
			public void modify(final Object element, final String property, final Object value) {
				//Test property and set value from Property (the element).
				if (element instanceof TableItem) {
					TableItem temp = (TableItem) element;
					if (temp.getData() instanceof Property) {
						final Property data = (Property) temp.getData();
						LightweightOperationFactory.execute(topology, new AbstractEMFOperation(
								TransactionUtil.getEditingDomain(topology), NLS.bind(
										Messages.TopologyVariableSection_Set_Property_0_to_1_, new Object[] {
												property, value })) {
							@Override
							protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
									throws ExecutionException {
								//TODO Name edit support
								if (property != null) {
									if (property.equals(Messages.TopologyVariableSection_Valu_)) {
										data.setValue((String) value);
									}
								}
								return Status.OK_STATUS;
							}
						});
						tableViewer.refresh();
					}
				}
			}

			public Object getValue(Object element, String property) {
				if (element instanceof Property) {
					Property data = (Property) element;
					if (property != null) {
						if (property.equals(Messages.TopologyVariableSection_Nam_)) {
							return data.getName();
						}
						if (property.equals(Messages.TopologyVariableSection_Valu_)) {
							return data.getValue();
						}
					}
				}
				return null;
			}

			public boolean canModify(Object element, String property) {
				return true;
			}

		};
		tableViewer.setCellModifier(cellMod);
	}

	/**
	 * Create the add/delete actions for this page
	 * 
	 * @param comp
	 */
	private void createActions(final Composite comp) {

		ISharedImages sharedImages = DeployCoreUIPlugin.getDefault().getSharedImages();
		createVariableAction = propAction(Messages.TopologyVariableSection_Create_new_variable_,
				sharedImages.getImageDescriptor(ISharedImages.IMG_ADD), new Action() {
					public void run() {
						final InputDialog dialog = new NewVariableCreationDialog(comp.getShell(),
								Messages.TopologyVariableSection_Create_new_variable_,
								Messages.TopologyVariableSection_Enter_variable_name_,
								IConstants.EMPTY_STRING, new IInputValidator() {

									public String isValid(String newText) {
										if (newText.length() == 0) {
											return Messages.TopologyVariableSection_Please_enter_a_valid_name_;
										}
										if (newText.indexOf(" ") != -1) { //$NON-NLS-1$
											return Messages.TopologyVariableSection_Text_must_contain_no_spaces_;
										}
										return null;
									}

								});

						if (dialog.open() == Window.OK) {
							//Check to make sure we don't already have the property
							boolean propExists = false;
							for (Iterator<Property> props = topology.getConfigurationContract()
									.getGlobalProperties().iterator(); props.hasNext();) {
								Property prop = props.next();
								if (prop.getName().equals(dialog.getValue())) {
									propExists = true;
									break;
								}
							}

							//if we have the property, notify the user and do nothing
							if (propExists) {
								MessageDialog
										.openError(
												comp.getShell(),
												Messages.TopologyVariableSection_Error_creating_propert_,
												NLS
														.bind(
																Messages.TopologyVariableSection_A_variable_with_name_0_already_,
																dialog.getValue()));
								return;
							}

							//if we don't have the property, add it
							AbstractEMFOperation op = new AbstractEMFOperation(TransactionUtil
									.getEditingDomain(topology),
									Messages.TopologyVariableSection_Create_new_variable_) {

								@Override
								protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
										throws ExecutionException {
									topology.getConfigurationContract().exportProperty(dialog.getValue());
									return Status.OK_STATUS;
								}

								@Override
								protected void didUndo(Transaction tx) {
									tableViewer.refresh();
									super.didUndo(tx);
								}

								@Override
								protected void didRedo(Transaction tx) {
									tableViewer.refresh();
									super.didRedo(tx);
								}
							};
							LightweightOperationFactory.execute(topology, op);
							tableViewer.refresh();
						}
					}
				});

		deleteVariableAction = propAction(Messages.TopologyVariableSection_Delete_Variabl_,
				sharedImages.getImageDescriptor(ISharedImages.IMG_DELETE), new Action() {
					public void run() {
						ISelection sel = tableViewer.getSelection();
						if (sel != null && sel instanceof IStructuredSelection) {
							IStructuredSelection temp = (IStructuredSelection) sel;
							if (temp.size() > 0) {
								Object[] objects = temp.toArray();
								List<EObject> objectsToDelete = new ArrayList<EObject>();
								for (Object o : objects) {
									if (o instanceof EObject) {
										objectsToDelete.add((EObject) o);
									}
								}
								if (objectsToDelete.size() > 0) {
									IUndoableOperation op = DeleteModelObjectOperation
											.createDeleteModelObjectOperation(objectsToDelete,
													Messages.TopologyVariableSection_Delete_Variabl_);
									LightweightOperationFactory.execute(topology, op);
								}
							}
						}
						tableViewer.refresh();
					}
				});
	}

	//Convience method for creating actions
	private Action propAction(String msg, ImageDescriptor imgd, Action a) {
		a.setText(msg);
		a.setToolTipText(msg);

		a.setImageDescriptor(imgd);
		return a;
	}

	@Override
	protected void setInput(DeployModelObject input) {
		if (input instanceof Topology) {
			setInput(topology);
		} else {
			setInput(input.getEditTopology());
		}

	}

	protected void setInput(Topology input) {
		topology = input;
		setCSHelp();

		if (input != null) {
			//add our values to the property page
			tableViewer.setInput(input);
		}
		if (input instanceof Import) {
			//Disable add/remove for imports
			createVariableAction.setEnabled(false);
			deleteVariableAction.setEnabled(false);
		} else {
			createVariableAction.setEnabled(true);
			deleteVariableAction.setEnabled(true);
		}
	}

	//Add our actions
	protected void doRefresh() {

	}

	@Override
	protected void addToolBarActions(IToolBarManager toolbar) {
		toolbar.add(createVariableAction);
		toolbar.add(deleteVariableAction);
	}

	@Override
	protected void doAboutToBeHidden() {

	}

	/**
	 * 
	 * 
	 */
	private class VariableContentProvider implements IStructuredContentProvider {

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof Topology) {

				// Check for no contract, because some topologies (Such as palette entries)
				// don't have a contract.  Or someone may have broken the contract using a text editor.
				if (topology.getConfigurationContract() == null) {
					return new Object[0];
				}

				return topology.getConfigurationContract().getGlobalProperties().toArray();
			}
			return ((Import) inputElement).getInstanceConfiguration().getGlobalProperties().toArray();
		}

		public void dispose() {
		}
	}

	/**
	 * 
	 * @since 7.0
	 * 
	 */
	private class VariableLabelProvider extends LabelProvider implements ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof Property) {
				Property data = (Property) element;
				switch (columnIndex)
				{
				case NAME:
					return data.getName();
				case VALUE:
					return data.getValue();
				}
			}
			return null;
		}
	}

	@Override
	protected void doDispose() {
		if (table != null && !table.isDisposed()) {
			table.dispose();
		}
	}

	@Override
	public void refresh() {

	}
}
