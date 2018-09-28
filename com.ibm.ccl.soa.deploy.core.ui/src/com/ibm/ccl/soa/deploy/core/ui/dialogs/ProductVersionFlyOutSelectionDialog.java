package com.ibm.ccl.soa.deploy.core.ui.dialogs;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.internal.popup.Messages;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.GeneralPopupCloseListener;

public class ProductVersionFlyOutSelectionDialog extends PopupDialog {

	private String fSelection = null;
	private final String fShellTitle;
	private final String fLabelText;
	private final String[] fAllowedStrings;
	private final int fInitialSelectionIndex;
	private FormToolkit toolKit = null;
	private final Point initialLocation;
	private String amplifierDescription;
	private final String existingValue;

	/**
	 * @param parentShell
	 * @param shellTitle
	 * @param labelText
	 * @param comboStrings
	 * @param initialSelectionIndex
	 * @param exitingValue
	 */
	public ProductVersionFlyOutSelectionDialog(Shell parentShell, String shellTitle,
			String labelText, String amplifierDescription, String[] comboStrings,
			int initialSelectionIndex, Point location, String existingValue) {
		super(parentShell, SWT.RESIZE, true, true, true, true, " ", shellTitle); //$NON-NLS-1$
		Assert.isNotNull(shellTitle);
		Assert.isNotNull(labelText);
		Assert.isTrue(comboStrings.length >= 0);
		fShellTitle = shellTitle;
		fLabelText = labelText;
		fAllowedStrings = comboStrings;
		fInitialSelectionIndex = initialSelectionIndex;
		initialLocation = location;
		this.amplifierDescription = amplifierDescription;
		this.existingValue = existingValue;
	}

	public void setBlockOnOpen(boolean shouldBlock) {
		super.setBlockOnOpen(true);
	}

	public String getSelectedString() {
		return fSelection;
	}

	@Override
	public void create() {
		super.create();
		applyBackgroundColor(getShell().getDisplay().getSystemColor(SWT.COLOR_WHITE), getShell());
	}

	protected Point getInitialLocation(Point initialSize) {
		return initialLocation;
	}

	@Override
	public int open() {
		// TODO Auto-generated method stub
		int returnCode = super.open();
		runEventLoop(getShell());
		return returnCode;

	}

	private void runEventLoop(Shell loopShell) {

		//Use the display provided by the shell if possible
		Display display;
		if (getShell() == null) {
			display = Display.getCurrent();
		} else {
			display = loopShell.getDisplay();
		}

		while (loopShell != null && !loopShell.isDisposed()) {
			try {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			} catch (Throwable e) {
				DeployCorePlugin.log(0, 0, e.getMessage(), e);
			}
		}
		display.update();
	}

	/*
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	protected Control createDialogArea(Composite parent) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_PRODUCT_VERSION_FLYOUT_DIALOG);
		//	getShell().setText(fShellTitle);
		toolKit = new FormToolkit(parent.getDisplay());
		Composite composite = toolKit.createComposite(parent, SWT.BORDER);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		GridLayout layout = new GridLayout();
		layout.marginWidth = 0;
		composite.setLayout(layout);
		Composite innerComposite = toolKit.createComposite(composite);
		GridData gd = new GridData(GridData.FILL_BOTH);
		innerComposite.setLayoutData(gd);
		GridLayout layoutInner = new GridLayout();
		layoutInner.numColumns = 2;
		innerComposite.setLayout(layoutInner);
		Label descriptionLabel = toolKit.createLabel(innerComposite,
				Messages.FlyOutComboSelectionDialog_Description_);
		GridData dataDescription = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
		descriptionLabel.setLayoutData(dataDescription);
		descriptionLabel.setText(Messages.FlyOutComboSelectionDialog_Description_);

		Text descriptionLabelContent = toolKit.createText(innerComposite,
				Messages.FlyOutComboSelectionDialog_Description_, SWT.WRAP | SWT.READ_ONLY);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.widthHint = 200;
		descriptionLabelContent.setLayoutData(data);
		if (amplifierDescription == null || amplifierDescription == "") { //$NON-NLS-1$
			amplifierDescription = Messages.FlyOutComboSelectionDialog_no_descriptio_;
		}
		descriptionLabelContent.setText(amplifierDescription);

		Label label = toolKit.createLabel(innerComposite, fLabelText);
		label.setText(fLabelText);

		final CCombo combo = new CCombo(innerComposite, SWT.READ_ONLY | SWT.FLAT | SWT.BORDER);
		combo.setBackground(innerComposite.getBackground());
		int x = -1;
		for (int i = 0; i < fAllowedStrings.length; i++) {
			combo.add(fAllowedStrings[i]);
			if (fAllowedStrings[i].equals(existingValue)) {
				x = i;
			}
		}
		if (existingValue != null) {
			combo.select(x);
		} else {
			combo.select(fInitialSelectionIndex);
		}
		if (combo.getSelectionIndex() >= 0) {
			fSelection = combo.getItem(combo.getSelectionIndex());
		}
		GridData gdCombo = new GridData(GridData.FILL_HORIZONTAL);
		combo.setLayoutData(gdCombo);

		combo.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				fSelection = combo.getItem(combo.getSelectionIndex());
			}
		});
		toolKit.paintBordersFor(innerComposite);
		new GeneralPopupCloseListener(this);
		return composite;
	}

	@Override
	public boolean close() {
		toolKit.dispose();
		return super.close();
	}

	private int getMaxStringLength() {
		int max = 0;
		for (int i = 0; i < fAllowedStrings.length; i++) {
			max = Math.max(max, fAllowedStrings[i].length());
		}
		return max;
	}
}