package com.ibm.ccl.soa.deploy.ide.ui.refactoring.handlers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.mapping.ResourceMapping;
import org.eclipse.core.resources.mapping.ResourceMappingContext;
import org.eclipse.core.resources.mapping.ResourceTraversal;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ltk.internal.ui.refactoring.RefactoringUIMessages;
import org.eclipse.ltk.internal.ui.refactoring.RefactoringUIPlugin;
import org.eclipse.ltk.ui.refactoring.RefactoringWizardOpenOperation;
import org.eclipse.ltk.ui.refactoring.resource.DeleteResourcesWizard;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

public class DeleteTopologyNamespaceRefactoringHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		Shell activeShell = HandlerUtil.getActiveShell(event);
		ISelection sel = HandlerUtil.getCurrentSelection(event);
		if (sel instanceof IStructuredSelection) {
			IResource[] resources = getSelectedResources((IStructuredSelection) sel);
			if (resources.length > 0) {
				DeleteResourcesWizard refactoringWizard = new DeleteResourcesWizard(resources);
				RefactoringWizardOpenOperation op = new RefactoringWizardOpenOperation(
						refactoringWizard);
				try {
					op.run(activeShell, RefactoringUIMessages.DeleteResourcesHandler_title);
				} catch (InterruptedException e) {
					// do nothing
				}
			}
		}
		return null;
	}

	protected IResource[] getSelectedResources(IStructuredSelection sel) {
		List resources = new ArrayList(sel.size());
		for (Iterator e = sel.iterator(); e.hasNext();) {
			Object next = e.next();
			if (next instanceof IResource) {
				resources.add(next);
				continue;
			} else if (next instanceof IAdaptable) {
				Object resource = ((IAdaptable) next).getAdapter(IResource.class);
				if (resource != null) {
					resources.add(resource);
					continue;
				}
			} else {
				IAdapterManager adapterManager = Platform.getAdapterManager();
				ResourceMapping mapping = (ResourceMapping) adapterManager.getAdapter(next,
						ResourceMapping.class);

				if (mapping != null) {

					ResourceTraversal[] traversals = null;
					try {
						traversals = mapping.getTraversals(ResourceMappingContext.LOCAL_CONTEXT,
								new NullProgressMonitor());
					} catch (CoreException exception) {
						RefactoringUIPlugin.log(exception.getStatus());
					}

					if (traversals != null) {
						for (int i = 0; i < traversals.length; i++) {
							IResource[] traversalResources = traversals[i].getResources();
							if (traversalResources != null) {
								for (int j = 0; j < traversalResources.length; j++) {
									resources.add(traversalResources[j]);
								}// for
							}// if
						}// for
					}// if
				}// if
			}
		}
		return (IResource[]) resources.toArray(new IResource[resources.size()]);
	}

}
