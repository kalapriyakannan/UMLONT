package com.ibm.ccl.soa.deploy.ide.ui.refactoring.wizards;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.util.RowLayouter;
import com.ibm.ccl.soa.deploy.ide.refactoring.participant.RenameTopologyParticipant;
import com.ibm.ccl.soa.deploy.ide.ui.refactoring.Messages;

public class RenameTopologyInputWizardPage extends TextInputWizardPage {

	/**
	 * Creates a new text input page.
	 * 
	 * @param isLastUserPage
	 *           <code>true</code> if this page is the wizard's last user input page. Otherwise
	 *           <code>false</code>.
	 * @param initialValue
	 *           the initial value
	 */
	public RenameTopologyInputWizardPage(String description, boolean isLastUserPage,
			String initialValue) {
		super(description, isLastUserPage, initialValue.substring(0, initialValue
				.indexOf(IConstants.DOT_SEPARATOR)));
	}

	public void createControl(Composite parent) {
		Composite superComposite = new Composite(parent, SWT.NONE);
		setControl(superComposite);
		initializeDialogUnits(superComposite);
		superComposite.setLayout(new GridLayout());
		Composite composite = new Composite(superComposite, SWT.NONE);
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.marginHeight = 0;
		layout.marginWidth = 0;

		composite.setLayout(layout);
		RowLayouter layouter = new RowLayouter(2);

		Label label = new Label(composite, SWT.NONE);
		label.setText(getLabelText());

		Text text = createTextInputField(composite);
		text.selectAll();
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.widthHint = convertWidthInCharsToPixels(25);
		text.setLayoutData(gd);
		text.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent event) {
				handleInputChanged();
			}
		});

		layouter.perform(label, text, 1);

		Label separator = new Label(composite, SWT.NONE);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, false, false);
		gridData.heightHint = 2;
		separator.setLayoutData(gridData);

		addAdditionalOptions(composite, layouter);

		Dialog.applyDialogFont(superComposite);
		/*
		 * PlatformUI.getWorkbench().getHelpSystem().setHelp(getControl(),
		 * IDeployHelpContextIds.TOPOLOGY_REFACTOR_RENAME_TOPOLOGY);
		 */
	}

	/**
	 * Clients can override this method to provide more UI elements. By default, does nothing
	 * 
	 * @param composite
	 *           the parent composite
	 * @param layouter
	 *           the row layouter to use
	 */
	protected void addAdditionalOptions(Composite composite, RowLayouter layouter) {
		// none by default
	}

	public void setVisible(boolean visible) {
		if (visible) {
			RenameTopologyParticipant renameProcessor = getProcessor();
			if (renameProcessor != null) {
				String newName = renameProcessor.getDataModel().getName();
				if (newName != null && newName.length() > 0 && !newName.equals(getInitialValue())) {
					IPath name = new Path(newName);
					Text textField = getTextField();
					textField.setText(name.removeFileExtension().lastSegment());
					textField.setSelection(0, newName.length());
				}
			}
		}
		super.setVisible(visible);
	}

	protected boolean saveSettings() {
		// always save
		return true;
	}

	public void dispose() {
		super.dispose();
	}

	protected String getLabelText() {
		return Messages.RenameTopologyInputPage_New_na_me_;
	}

	protected Text createTextInputField(Composite parent) {
		return createTextInputField(parent, SWT.BORDER);
	}

	protected RenameTopologyParticipant getProcessor() {
		return null;
//		return (RenameTopologyParticipant) ((RenameRefactoring) getRefactoring()).getProcessor();
	}

	protected void handleInputChanged() {
		RefactoringStatus status = new RefactoringStatus();

		String newName = super.getText().trim();
		if (newName.length() == 0) {
			status.merge(RefactoringStatus.create(new Status(IStatus.ERROR,
					DeployCoreUIPlugin.PLUGIN_ID, NLS.bind(
							Messages.RenameTopologyInputWizardPage_Invalid_topology_name_0_, newName))));
		}

		if (newName.indexOf(IConstants.DOT_SEPARATOR) < 0) {
			newName += IConstants.DOT_SEPARATOR + IConstants.TOPOLOGY_EXTENSION;
		}

		RenameTopologyParticipant renameProcessor = getProcessor();
		IPath path = new Path(renameProcessor.getDataModel().getTopology());
		IPath newPath = path.removeLastSegments(1).append(newName);
		renameProcessor.getDataModel().setName(newPath.toString());
		status.merge(RefactoringStatus.create(renameProcessor.getDataModel().validateName()));

		setPageComplete(status);
	}

}
