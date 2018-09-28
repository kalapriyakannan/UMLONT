package com.ibm.ccl.soa.deploy.core.ui.internal.search.handlers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.emf.ecore.EObject;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.internal.search.Messages;
import com.ibm.ccl.soa.deploy.core.ui.internal.search.scopes.Scope;
import com.ibm.ccl.soa.deploy.index.search.Query;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

public class ReferencesInEnclosingProjectHandler extends AbstractReferencesHandler {

	@Override
	protected Scope getSearchScope(ExecutionEvent event) throws CoreException, ExecutionException {

		Collection<IContentType> types = new ArrayList<IContentType>();
		types.add(Query.TOPOLOGY_MODEL_CONTENT_TYPE);
		types.add(Query.TOPOLOGY_DIAGRAM_CONTENT_TYPE);

		IFile file = WorkbenchResourceHelper.getFile((EObject) getSelection(event));
		if (null != file) {
			return Scope.getProjectScope(Collections.EMPTY_LIST, file.getProject(), true);
		}

		throw new CoreException(new Status(IStatus.ERROR, DeployCoreUIPlugin.PLUGIN_ID,
				Messages.ReferencesInEnclosingProject_Could_not_determine_project_from_se_, null));

	}
}
