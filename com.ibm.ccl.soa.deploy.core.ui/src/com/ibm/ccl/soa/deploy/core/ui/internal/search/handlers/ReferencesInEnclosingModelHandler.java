package com.ibm.ccl.soa.deploy.core.ui.internal.search.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.internal.search.Messages;
import com.ibm.ccl.soa.deploy.core.ui.internal.search.scopes.Scope;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

public class ReferencesInEnclosingModelHandler extends AbstractReferencesHandler {

	@Override
	protected Scope getSearchScope(ExecutionEvent event) throws CoreException, ExecutionException {

		IFile file = WorkbenchResourceHelper.getFile((EObject) getSelection(event));
		if (null != file && IConstants.TOPOLOGY_EXTENSION.equals(file.getFileExtension())) {
			return Scope.getDocumentScope(file);
		}

		throw new CoreException(new Status(IStatus.ERROR, DeployCoreUIPlugin.PLUGIN_ID,
				Messages.ReferencesInEnclosingModel_Could_not_determine_the_enclosing_m_, null));
	}

}
