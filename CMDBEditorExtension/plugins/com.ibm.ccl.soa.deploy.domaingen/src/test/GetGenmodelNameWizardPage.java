package test;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * @author barnold
 * 
 */
public class GetGenmodelNameWizardPage extends WizardPage {

	private Text textURI;

	/**
	 * Creates a new text input page.
	 * 
	 * @param isLastUserPage
	 *            <code>true</code> if this page is the wizard's last user
	 *            input page. Otherwise <code>false</code>.
	 * @param initialValue
	 *            the initial value
	 */

	protected GetGenmodelNameWizardPage(String pageName, String title, ImageDescriptor titleImage) {
		super(pageName, title, titleImage);
		this.setPageComplete(false);
	}

	public void createControl(Composite parent) {
			Composite composite = new Composite(parent, SWT.NONE);
	composite.setLayout(new GridLayout(3, false));
	composite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));

//		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		Label label = new Label(composite, SWT.NONE);
		label.setText("genmodel:");

		textURI = new Text(composite, SWT.BORDER);
		textURI.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));		

		Button button = new Button(composite, SWT.PUSH);
		button.setText("Browse");

		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				openFileDialog();
			}
		});
		
		setControl(composite);

		Dialog.applyDialogFont(composite);		
	}

	protected void openFileDialog() {
		final FileDialog fileDialog = new FileDialog(getShell(), SWT.OPEN);
		fileDialog.setFilterNames(new String[] { "*.genmodel" });
		fileDialog.setFilterExtensions(new String[] { "*.genmodel" });
		String genmodelURI = fileDialog.open();

		// Did user click 'OK'?
		if (genmodelURI != null) {
			textURI.setText(genmodelURI);
			this.setPageComplete(true);
		}
	}

	/**
	 * @return the textURI
	 */
	public String getTextURI() {
		return textURI.getText();
	}

}
