/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.navigator.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.edit.provider.IWrapperItemProvider;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IActionDelegate2;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.SelectionListenerAction;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.core.ui.navigator.deploy.TopologyDiagramNode;
import com.ibm.ccl.soa.deploy.core.ui.util.AdaptabilityUtility;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

/**
 * Action for opening a SOA resource from the SOA navigator.
 */
public class OpenToplogyAction extends SelectionListenerAction implements IActionDelegate2 {
	private static final String OPEN_LABEL = "Open"; //$NON-NLS-1$
	private static final String OPEN_TOPOLOGY_ACTION = "openTopologyAction"; //$NON-NLS-1$
	// //$NON-NLS-1$
	protected IEditorDescriptor currentDescriptor;
	protected Object srcObject;
	private final IWorkbenchPage page;

	protected OpenToplogyAction(IWorkbenchPage page) {
		super(OPEN_LABEL);
		setId(OPEN_TOPOLOGY_ACTION);
		this.page = page;
	}

	protected static IEditorDescriptor findEditorDescriptor(String id) {
		IEditorRegistry registry = PlatformUI.getWorkbench().getEditorRegistry();
		return registry.findEditor(id);
	}

	public boolean updateSelection(IStructuredSelection s) {
		srcObject = null;
		if (!super.updateSelection(s)) {
			return false;
		}

		if (s.size() != 1) {
			return false;
		}

		// Make sure this is one of the selections we can handle,
		// then set the source object as is. The run() will do the hard stuff.
		Object obj = s.getFirstElement();

		// object either instance of Topology or the objects parent is topology
		if (isEnabled(obj)) {
			srcObject = obj;
			revealObject(obj, s);
			return true;
		}

		return false;
	}

	private void revealObject(Object obj, IStructuredSelection s) {
		Object resolvedObject = resolveObject(obj);
		IFile file = (IFile) AdaptabilityUtility.getAdapter(resolvedObject, IFile.class);

		if (file != null) {
			IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
					.getActiveEditor();
			if (editor instanceof ISetSelectionTarget) {
				((ISetSelectionTarget) editor).selectReveal(getEObjects(s));
			}
		}
	}

	private Object resolveObject(Object obj) {
		if (obj instanceof IWrapperItemProvider) {
			IWrapperItemProvider wrapperItemProvider = (IWrapperItemProvider) obj;
			obj = wrapperItemProvider.getValue();

		}
		if (obj instanceof FeatureMap.Entry) {
			FeatureMap.Entry entry = (FeatureMap.Entry) obj;
			obj = entry.getValue();
		}
		return obj;
	}

	private boolean isEnabled(Object obj) {
		obj = resolveObject(obj);
		if (obj instanceof TopologyDiagramNode) {
			return true;
		}
		if (obj instanceof EObject) {
			EObject eObject = (EObject) obj;
			EObject parent = eObject;
			while (parent != null) {
				if (parent instanceof Topology) {
					return true;
				}
				parent = parent.eContainer();
			}
		}
		if (obj instanceof TopologyDiagramNode) {
			return true;
		}
		return false;
	}

	private IStructuredSelection getEObjects(IStructuredSelection selection) {
		Iterator iterator = selection.iterator();
		List list = new ArrayList();
		Object object = null;
		while (iterator.hasNext()) {
			object = resolveObject(iterator.next());
			if (object instanceof EObject) {
				list.add(object);
			}
		}
		return new StructuredSelection(list.toArray());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate2#dispose()
	 */
	public void dispose() {
		//Dispose
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate2#init(org.eclipse.jface.action.IAction)
	 */
	public void init(IAction action) {
		//init
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate2#runWithEvent(org.eclipse.jface.action.IAction,
	 *      org.eclipse.swt.widgets.Event)
	 */
	public void runWithEvent(IAction action, Event event) {
		runWithEvent(event);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {
		run();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction,
	 *      org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		updateSelection((IStructuredSelection) selection);
	}

	/**
	 * open the appropriate editor
	 */
	protected void openAppropriateEditor(IResource r) {
		if (r == null) {
			return;
		}
		IWorkbenchPage page = null;
		IEditorPart editor = null;
		try {
			page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			editor = page.openEditor(new FileEditorInput((IFile) r), currentDescriptor.getId());
			if (editor instanceof ISetSelectionTarget) {
				((ISetSelectionTarget) editor).selectReveal(getEObjects(getStructuredSelection()));
			}
		} catch (Exception e) {
			MessageDialog.openError(page.getWorkbenchWindow().getShell(),
					"Error in opening the resource", e.getMessage()); //$NON-NLS-1$
		}
	}

	/**
	 * The user has invoked this action
	 */
	public void run() {
		if (!isEnabled()) {
			return;
		}

		if (isEnabled(srcObject)) {

			Object resolvedObject = resolveObject(srcObject);
			IFile file = null;

			if (resolvedObject instanceof Import) { //Try to find the imported file
				Import theImport = (Import) resolvedObject;
				//Import must be in same project as file it is imported into
				IProject project = WorkbenchResourceHelper.getFile(theImport).getProject();
				file = NamespaceCore.resolveTopology(project, theImport.getNamespace(), theImport
						.getDisplayName());
			}

			if (file == null) {
				//Open up the topology
				file = (IFile) AdaptabilityUtility.getAdapter(resolvedObject, IFile.class);
			}

			if (file != null) {
				IEditorRegistry registry = PlatformUI.getWorkbench().getEditorRegistry();
				currentDescriptor = registry.getDefaultEditor(file.getName());
				openAppropriateEditor(file);
			}
		}
	}

}
