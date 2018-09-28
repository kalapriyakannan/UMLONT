package test;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;

/**
 * @author barnold
 * 
 */
public class NewExtensionWizard extends BasicNewResourceWizard {

	private GetGenmodelNameWizardPage genmodelNameWizardPage;

	@Override
	public boolean performFinish() {
		String genmodelURI = genmodelNameWizardPage.getTextURI();
		URI uri = URI.createFileURI(genmodelURI);
		String convertedUriString = uri.toString();
		nonBlockingGeneration(convertedUriString);
		return true;
	}

	private void nonBlockingGeneration(final String convertedUriString) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				DeployCoreUIPlugin.runWithProgress(new IRunnableWithProgress() {
					public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
						try {
							TestGeneration tg = new TestGeneration();
							tg.doGeneration(convertedUriString, monitor);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}, false);
			}
		});
	}

	@Override
	public void addPages() {
		super.addPages();
		genmodelNameWizardPage = new GetGenmodelNameWizardPage("New Domain Extension (Pagename)",
				"New Domain Extension (Title)", null);
		addPage(genmodelNameWizardPage);
		this.getClass();
	}

}
