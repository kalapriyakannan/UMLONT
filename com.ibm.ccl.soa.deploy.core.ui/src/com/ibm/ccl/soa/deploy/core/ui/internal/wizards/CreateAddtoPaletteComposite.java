/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.wizards;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wst.common.frameworks.internal.datamodel.ui.DataModelSynchHelper;
import org.eclipse.wst.common.frameworks.internal.datamodel.ui.DataModelWizardPage;

import com.ibm.ccl.soa.deploy.core.datamodels.AddToPaletteDataModel;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.IAddToPaletteDataModelProperties;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry;
import com.ibm.ccl.soa.infrastructure.ui.internal.epl.TextProcessorDataModelSynchHelper;

public class CreateAddtoPaletteComposite extends Composite implements
		IAddToPaletteDataModelProperties {

	private static final IContentProposal[] EMPTY_CONTNENT_PROPOSAL = new IContentProposal[0];
	private final TextProcessorDataModelSynchHelper synchHelper;
	private final AddToPaletteDataModel dataModel;
	private final IconUrlLabelProvider iconUrlLabelProvider = new IconUrlLabelProvider();

	private Label nameLabel = null;
	private Text nameText = null;
	private Label descriptionLabel = null;
	private Text descriptionText = null;
	private Label drawerNameLabel = null;
	private Label drawerValue = null;
	private Label stackLabel = null;
	private Combo stackCombo = null;
	private Button stackNewButton = null;
	private Label iconName = null;
	private Label iconImageLabel = null;
	private Button iconBrowse = null;
	private StackHelper stackHelper;
	private Image imageIcon;
	private Button captureVisuals;

	/**
	 * @param parent -
	 *           The parent {@link Composite}.
	 * @param style -
	 *           The style flag for this {@link Composite}.
	 * @param synchHelper -
	 *           A {@link DataModelSynchHelper} from a {@link DataModelWizardPage} used to bind the
	 *           controls.
	 * @param dataModel -
	 *           A {@link AddToPaletteDataModel} type safe data model used to hold the property
	 *           values displayed in the {@link Composite}.
	 */
	public CreateAddtoPaletteComposite(Composite parent, int style,
			TextProcessorDataModelSynchHelper synchHelper, AddToPaletteDataModel dataModel) {
		super(parent, style);
		this.synchHelper = synchHelper;
		this.dataModel = dataModel;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {

		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		this.setLayout(gridLayout);

		nameLabel = new Label(this, SWT.NONE);
		nameLabel.setFont(JFaceResources.getDialogFont());
		nameLabel.setText(Messages.BankUnitAction_Label_);

		nameText = new Text(this, SWT.BORDER);
		nameText.setLayoutData(getCommonGridLayout(GridData.FILL_HORIZONTAL));

		descriptionLabel = new Label(this, SWT.NONE);
		descriptionLabel.setFont(JFaceResources.getDialogFont());
		descriptionLabel.setText(Messages.BankUnitAction_Description_);
		descriptionLabel.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));

		descriptionText = new Text(this, SWT.BORDER | SWT.WRAP);
		descriptionText.setLayoutData(getCommonGridLayout(GridData.FILL_HORIZONTAL, 100));

		drawerNameLabel = new Label(this, SWT.NONE);
		drawerNameLabel.setFont(JFaceResources.getDialogFont());
		drawerNameLabel.setText(Messages.CreateAddtoPaletteComposite_Drawer_);

		drawerValue = new Label(this, SWT.NONE);
		drawerValue.setFont(JFaceResources.getDialogFont());
		drawerValue.setText(LOCAL_EXTENSIONS);
		drawerValue.setLayoutData(getCommonGridLayout(GridData.FILL_HORIZONTAL));

		stackLabel = new Label(this, SWT.NONE);
		stackLabel.setFont(JFaceResources.getDialogFont());
		stackLabel.setText(Messages.CreateAddtoPaletteComposite_Stack_);

		stackCombo = new Combo(this, SWT.READ_ONLY);
		stackCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		stackNewButton = new Button(this, SWT.PUSH);
		stackNewButton.setText(Messages.CreateAddtoPaletteComposite_New_);

		addNewStackSelectionListener();
		initStack();

		createIconComposite();
		if (dataModel.getEnableCaptureVisuals()) {
			Label label = new Label(this, SWT.NONE);
			label.setFont(JFaceResources.getDialogFont());
			label.setText(Messages.CreateTopologyComposite2_Option_);
			captureVisuals = new Button(this, SWT.CHECK);
			captureVisuals.setLayoutData(getCommonGridLayout(GridData.FILL_HORIZONTAL));
			//externalize after UI review:
			captureVisuals.setText("Maintain visual structure"); //$NON-NLS-1$
		}
		bindControls();

	}

	private void addNewStackSelectionListener() {
		stackNewButton.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				defineNewStack();
			}
		});

	}

	private void createIconComposite() {

		iconName = new Label(this, SWT.NONE);
		iconName.setFont(JFaceResources.getDialogFont());
		iconName.setText(Messages.BankUnitAction_Icon_);

		Composite iconComposite = new Composite(this, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		iconComposite.setLayout(layout);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = 2;

		iconComposite.setLayout(layout);
		iconComposite.setLayoutData(gridData);

		iconImageLabel = new Label(iconComposite, SWT.NONE);
		iconImageLabel.setImage(iconUrlLabelProvider.getImageDescriptor(dataModel.getIcon())
				.createImage());

		iconBrowse = new Button(iconComposite, SWT.PUSH);
		iconBrowse.setText(Messages.BROWSE_LABEL);

		addIconBrowseSelectionListener();

	}

	public void addIconBrowseSelectionListener() {
		iconBrowse.addSelectionListener(new SelectionListener() {
			public void widgetDefaultSelected(SelectionEvent e) {
			}

			public void widgetSelected(SelectionEvent e) {
				browseForIcon();
			}
		});

	}

	private GridData getCommonGridLayout(int gridType) {
		GridData data = new GridData(gridType);
		data.horizontalSpan = 2;
		return data;
	}

	private GridData getCommonGridLayout(int gridType, int hint) {
		GridData data = getCommonGridLayout(gridType);
		data.heightHint = hint;
		return data;
	}

	private void bindControls() {
		synchHelper.synchText(nameText, LABEL, true, null);
		synchHelper.synchText(descriptionText, DESCRIPTION, true, null);
		synchHelper.synchCombo(stackCombo, STACK, null);
		if (dataModel.getEnableCaptureVisuals()) {
			synchHelper.synchCheckbox(captureVisuals, CAPTURE_VISUALS, null);
		}

	}

	private DynamicPaletteEntry[] getPaletteFilteredForIconUniqueness() {
		Map<String, DynamicPaletteEntry> retVal = new HashMap<String, DynamicPaletteEntry>();

		DynamicPaletteEntry[] adpe = ExtensionsCore.createResourceTypeService()
				.getAllPaletteEntries();
		for (int i = 0; i < adpe.length; i++) {
			retVal.put(adpe[i].getLargeIcon(), adpe[i]);
		}

		return retVal.values().toArray(new DynamicPaletteEntry[0]);
	}

	private void browseForIcon() {
		IconSelectionDialog elsd = new IconSelectionDialog(getShell(), iconUrlLabelProvider,
				getPaletteFilteredForIconUniqueness());
		if (elsd.open() == Window.OK) {
			DynamicPaletteEntry dpe = (DynamicPaletteEntry) elsd.getFirstResult();
			if (dpe != null) {
				String urlIconLarge = dpe.getLargeIcon();
				dataModel.setIcon(urlIconLarge);
				ImageDescriptor idIcon = iconUrlLabelProvider.getImageDescriptor(urlIconLarge);
				imageIcon = idIcon.createImage();
				iconImageLabel.setImage(imageIcon);

			}
		}
	}

	private void defineNewStack() {
		InputDialog dlg = new StackCreationDialog(getShell(), Messages.BankUnitAction_New_Stack_Nam_,
				Messages.BankUnitAction_Stack_, Messages.BankUnitAction_newStac_, stackHelper
						.getPaletteStackNameValidator());
		if (dlg.open() == Window.OK) {
			String newStackName = dlg.getValue();
			String id = StackHelper.makeIdFromStackName(newStackName);
			ExtensionsCore.createResourceTypeService().addDynamicPaletteStack(id, getDrawerId(),
					newStackName, null, dataModel.getProjectName());
			initStack();
			dataModel.setStack(newStackName);
		}
	}

	private String getDrawerId() {
		return "/extensionDrawer/"; //$NON-NLS-1$
	}

	private void initStack() {
		stackHelper = new StackHelper();
		stackCombo.removeAll();
		DynamicPaletteEntry[] adpe = stackHelper.getDynamicStackEntries();
		Set<String> uniqueSet = new HashSet<String>(adpe.length);
		for (int i = 0; i < adpe.length; i++) {
			uniqueSet.add(adpe[i].getId());
		}
		String[] items = new String[uniqueSet.size()];
		int i = -1;
		for (Iterator<String> it = uniqueSet.iterator(); it.hasNext();) {
			i++;
			items[i] = it.next();
		}
		Arrays.sort(items);
		String[] all = new String[items.length + 1];
		all[0] = ""; //$NON-NLS-1$
		System.arraycopy(items, 0, all, 1, items.length);
		stackCombo.setItems(all);
		dataModel.setStack(all[0]);
	}

	@Override
	public void dispose() {
		imageIcon.dispose();
		imageIcon = null;
		super.dispose();
	}
}
