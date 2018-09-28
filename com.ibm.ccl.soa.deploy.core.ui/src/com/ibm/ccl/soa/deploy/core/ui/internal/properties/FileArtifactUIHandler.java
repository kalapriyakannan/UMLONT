package com.ibm.ccl.soa.deploy.core.ui.internal.properties;

import java.io.File;

import org.eclipse.core.resources.IContainer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.Substitutable;
import com.ibm.ccl.soa.deploy.core.ui.properties.Messages;
import com.ibm.ccl.soa.deploy.saf.exception.InvalidOperationException;
import com.ibm.ccl.soa.deploy.saf.exception.SAFException;
import com.ibm.ccl.soa.deploy.saf.ui.handler.AbstractUIHandler;

public class FileArtifactUIHandler extends AbstractUIHandler {

	@Override
	public Object createNewSubstitutableObject(IContainer defaultLocation, Shell shell)
			throws SAFException, InvalidOperationException {

		final FileArtifact newArtifact = CoreFactory.eINSTANCE.createFileArtifact();
		newArtifact.setDisplayName(Messages.ModulePropertySection_NEW_ARTIFACT_NAME);
		FileDialog fsd = new FileDialog(shell, SWT.MULTI);

		if (newArtifact.getFileURIs().size() > 0) {
			String initial = (String) newArtifact.getFileURIs().get(0);
			fsd.setFileName(initial);
		}

		String fname = fsd.open();

		// Did user click 'OK'?
		if (fname == null) {
			return null;
		}

		// Remove all old URIs
//			CompoundCommand cc = new CompoundCommand();
//			TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(unit);
//			for (Iterator<String> it = newArtifact.getFileURIs().iterator(); it.hasNext();) {
//				String uri = it.next();
//				RemoveCommand rc = new RemoveCommand(domain, (EList<String>) newArtifact.getFileURIs(),
//						uri);
//				cc.append(rc);
//			}

		String[] names = fsd.getFileNames();
		if (fsd.getFilterPath() != null) {
			for (int i = 0; i < names.length; i++) {
				names[i] = fsd.getFilterPath() + File.separator + names[i];
			}
		}

		for (int i = 0; i < names.length; i++) {
			newArtifact.getFileURIs().add(names[i]);
		}

		return newArtifact;
	}

	@Override
	public boolean editSubstitutable(Shell shell, DeployModelObject dmo,
			Substitutable substitutable, boolean isEditNubDmo) throws SAFException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUIHandlerForObject(Substitutable obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void open(Substitutable substitutableObj) throws SAFException, InvalidOperationException {
		// TODO Auto-generated method stub

	}

}
