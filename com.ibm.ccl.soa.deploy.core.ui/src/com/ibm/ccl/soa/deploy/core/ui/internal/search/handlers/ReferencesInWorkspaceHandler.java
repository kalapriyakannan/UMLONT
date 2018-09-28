package com.ibm.ccl.soa.deploy.core.ui.internal.search.handlers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.content.IContentType;

import com.ibm.ccl.soa.deploy.core.ui.internal.search.scopes.Scope;
import com.ibm.ccl.soa.deploy.index.search.Query;

public class ReferencesInWorkspaceHandler extends AbstractReferencesHandler {

	@Override
	protected Scope getSearchScope(ExecutionEvent event) throws CoreException {

		Collection<IContentType> types = new ArrayList<IContentType>();
		types.add(Query.TOPOLOGY_MODEL_CONTENT_TYPE);
		types.add(Query.TOPOLOGY_DIAGRAM_CONTENT_TYPE);

		return Scope.getWorkspaceScope(Collections.EMPTY_LIST, true, false);
	}

}
