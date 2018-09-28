/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
/**
 * 
 */
package com.ibm.ccl.soa.deploy.core.ui.internal.synchronization;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.eclipse.wst.common.frameworks.internal.datamodel.ui.DataModelSynchHelper;

import com.ibm.ccl.soa.deploy.core.internal.datamodels.ISynchronizationDatamodelProperties;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.infrastructure.internal.emf.DynamicAdapterFactory;

public class SelectComponentsComposite extends Composite {

	private static final String FORM_STRT = "<form>"; //$NON-NLS-1$
	private static final String FORM_END = "</form>"; //$NON-NLS-1$

	private static final String P_STRT = "<p>"; //$NON-NLS-1$
	private static final String P_END = "</p>"; //$NON-NLS-1$ 

	private static final int DIALOG_HEIGHT = 300;
	private static final int DIALOG_WIDTH = 450;
	protected static final Object SELECT_ALL = "select-all"; //$NON-NLS-1$
	protected static final Object DESELECT_ALL = "deselect-all"; //$NON-NLS-1$

	private final SynchronizationRefactoringWizard wizard;
	private Tree componentsTree = null;
	private CheckboxTreeViewer checkboxTreeViewer = null;

	private PatternFilter filter;
	private FilteredTree filteredTree;

	private DataModelSynchHelper syncHelper;
	private Composite infoComposite = null;
	private FontMetrics fontMetrics;
	private FormToolkit formToolkit;

	public SelectComponentsComposite(SynchronizationRefactoringWizard wizard, Composite parent,
			int style) {
		super(parent, style);
		this.wizard = wizard;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
		this.setSize(new Point(DIALOG_WIDTH, DIALOG_HEIGHT));

		this.setLayout(createLayoutData(4));

		createInfoPart();

		createTreePart();

		bindControls();

	}

	private void createInfoPart() {

		GridData infoLayoutData = new GridData();

		infoLayoutData.horizontalSpan = 2;
		infoLayoutData.grabExcessVerticalSpace = true;
		infoLayoutData.grabExcessHorizontalSpace = true;
		infoLayoutData.horizontalAlignment = GridData.FILL;
		infoLayoutData.verticalAlignment = GridData.FILL;
		infoLayoutData.widthHint = DIALOG_WIDTH / 2;

		infoComposite = getFormToolkit().createComposite(this, SWT.BORDER);
		infoComposite.setLayoutData(infoLayoutData);
		infoComposite.setLayout(new TableWrapLayout());

		Form instructions = getFormToolkit().createForm(infoComposite);

		instructions.setText(Messages.SelectComponentsComposite_Synchronize_the_model_with_the_work_);
		instructions.getBody().setLayoutData(
				new TableWrapData(TableWrapData.CENTER, TableWrapData.TOP));
		instructions.getBody().setLayout(new TableWrapLayout());

		StringBuffer buffer = new StringBuffer();
		buffer.append(FORM_STRT);
		buffer.append(P_STRT);
		buffer.append(Messages.SelectComponentsComposite_Please_select_the_units_you_would_l_);
		buffer.append(P_END);

		buffer.append(P_STRT);
		buffer.append(P_END);

		buffer.append(P_STRT);
		buffer.append(NLS.bind(Messages.SelectComponentsComposite_You_can__a_href_0__Select_All__a_,
				new Object[] { SELECT_ALL, DESELECT_ALL }));
		buffer.append(P_END);

		buffer.append(P_STRT);
		buffer.append(P_END);
		buffer.append(P_STRT);
		buffer.append(P_END);

		buffer.append(FORM_END);

		FormText formText = getFormToolkit().createFormText(instructions.getBody(), false);
		formText.setLayoutData(new TableWrapData(TableWrapData.CENTER, TableWrapData.TOP));
		formText.setText(buffer.toString(), true, true);
		formText.setWhitespaceNormalized(true);
		formText.addHyperlinkListener(new HyperlinkAdapter() {
			public void linkActivated(HyperlinkEvent e) {
				if (SELECT_ALL.equals(e.getHref())) {
					handleSelect(true);
				} else if (DESELECT_ALL.equals(e.getHref())) {
					handleSelect(false);
				}
			}
		});

//        FormText formText2 = getFormToolkit().createFormText(infoComposite, false);
//        formText2.setLayoutData(new TableWrapData(TableWrapData.CENTER, TableWrapData.BOTTOM));

	}

	private void createTreePart() {

		GridData treeLayoutData = new GridData();
		treeLayoutData.horizontalSpan = 2;
		treeLayoutData.grabExcessVerticalSpace = true;
		treeLayoutData.grabExcessHorizontalSpace = true;
		treeLayoutData.horizontalAlignment = GridData.FILL;
		treeLayoutData.verticalAlignment = GridData.FILL;
		treeLayoutData.widthHint = DIALOG_WIDTH / 2;

		filter = new PatternFilter();
		filteredTree = new FilteredTree(this, SWT.CHECK | SWT.BORDER, filter) {
			@Override
			protected TreeViewer doCreateTreeViewer(Composite parent, int style) {

				componentsTree = new Tree(parent, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL);
				componentsTree.setLayoutData(createWideGridData());
				CheckboxTreeViewer viewer = new CheckboxTreeViewer(componentsTree);

				viewer.setContentProvider(new SynchronizeDialogContentProvider());
				viewer.setLabelProvider(new SynchronizeDialogLabelProvider(new DynamicAdapterFactory(
						null)));
				viewer.setInput(wizard.getDatamodel().getTopology());

				return viewer;
			}

		};

		filteredTree.setLayoutData(treeLayoutData);

		checkboxTreeViewer = (CheckboxTreeViewer) filteredTree.getViewer();
	}

	private GridLayout createLayoutData(int numColumns) {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = numColumns;
		gridLayout.verticalSpacing = Dialog.convertVerticalDLUsToPixels(getFontMetrics(),
				IDialogConstants.VERTICAL_SPACING);
		gridLayout.horizontalSpacing = Dialog.convertHorizontalDLUsToPixels(getFontMetrics(),
				IDialogConstants.VERTICAL_SPACING);
		gridLayout.makeColumnsEqualWidth = true;
		return gridLayout;
	}

	protected void handleSelect(boolean selected) {
		Tree tree = (Tree) checkboxTreeViewer.getControl();
		TreeItem[] items = tree.getItems();
		for (int i = 0; i < items.length; i++) {
			handleSelect(items[i], selected);
		}
	}

	protected void handleSelect(TreeItem item, boolean selected) {
		if (item.getData() != null)
			checkboxTreeViewer.setChecked(item.getData(), selected);
		TreeItem[] items = item.getItems();
		for (int i = 0; i < items.length; i++) {
			if (items[i].getItems().length > 0) {
				handleSelect(items[i], selected);
			} else {
				if (items[i].getData() != null)
					checkboxTreeViewer.setChecked(items[i].getData(), selected);
			}
		}
	}

	private void bindControls() {
		syncHelper = new DataModelSynchHelper(wizard.getDatamodel().getUnderlyingDataModel());
		syncHelper.synchCheckBoxTreeViewer(checkboxTreeViewer,
				ISynchronizationDatamodelProperties.COMPONENTS, null);

	}

	private FontMetrics getFontMetrics() {
		// Compute and store a font metric
		if (fontMetrics == null) {
			GC gc = new GC(this);
			gc.setFont(JFaceResources.getDialogFont());
			fontMetrics = gc.getFontMetrics();
			gc.dispose();
		}
		return fontMetrics;
	}

	private GridData createWideGridData() {
		return new GridData(GridData.HORIZONTAL_ALIGN_CENTER, GridData.VERTICAL_ALIGN_CENTER, true,
				true/* , GridData.GRAB_HORIZONTAL, GridData.GRAB_VERTICAL */);
	}

	/**
	 * This method initializes formToolkit
	 * 
	 * @return org.eclipse.ui.forms.widgets.FormToolkit
	 */
	private FormToolkit getFormToolkit() {
		if (formToolkit == null) {
			formToolkit = new FormToolkit(Display.getCurrent());
		}
		return formToolkit;
	}

} //  @jve:decl-index=0:visual-constraint="10,10"
