package com.ibm.ccl.soa.deploy.uml.ui.internal.mmi.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.core.ui.editor.TopologyDiagramCreateHelper;
import com.ibm.ccl.soa.deploy.core.ui.editor.VisualizeFileEditorInput;
import com.ibm.ccl.soa.deploy.core.ui.navigator.deploy.TopologyDiagramNode;
import com.ibm.ccl.soa.deploy.core.ui.savables.TopologyArtifactsMonitor;
import com.ibm.ccl.soa.deploy.core.ui.util.AdaptabilityUtility;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;
import com.ibm.xtools.mmi.ui.actions.AbstractAddToNewDiagramAction;
import com.ibm.xtools.mmi.ui.util.IUIContext;
import com.ibm.xtools.mmi.ui.util.UIContext;

public class AddToNewTopologyDiagramAction extends AbstractAddToNewDiagramAction {

	private static final IUIContext context = new UIContext();
	private IFile file;
	private final ArrayList<DeployModelObject> deployModelObjects = new ArrayList<DeployModelObject>();
	protected IEditorDescriptor currentDescriptor;

	@Override
	protected IUIContext getUIContext() {
		return context;
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		action.setEnabled(true);
		setSelection(selection);
		setAction(action);
	}

	@Override
	protected DiagramEditPart createDiagramEditPart(List targetEl, IProgressMonitor monitor) {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		assert page != null;
		gather(targetEl);
		assert file != null;

		try {
			IFile diagramFile = TopologyDiagramCreateHelper.createTopologyDiagram(file, null);
			if (diagramFile != null) {
				page.openEditor(new VisualizeFileEditorInput(diagramFile, deployModelObjects),
						getEditorDescriptor(file).getId());
			}
		} catch (PartInitException e) {
			DeployCorePlugin.log(IStatus.ERROR, 0, e.getMessage(), e);
		}
		deployModelObjects.clear();
		return null;
	}

	private void gather(List targetEl) {
		for (Iterator iterator = targetEl.iterator(); iterator.hasNext();) {
			Object obj = iterator.next();
			if (obj instanceof Unit || obj instanceof DeployModelObject) {
				deployModelObjects.add((DeployModelObject) obj);
			} else if (obj instanceof IFile) {
				file = (IFile) obj;
			} else if (obj instanceof TopologyDiagramNode) {
				IFile diagramFile = (IFile) ((TopologyDiagramNode) obj).getAdapter(IFile.class);
				file = TopologyArtifactsMonitor.INSTANCE.getAssociatedModelFile(diagramFile);
			}
		}
		if (file == null && !deployModelObjects.isEmpty()) {
			deriveFile(deployModelObjects);
		}

	}

	private void deriveFile(ArrayList<DeployModelObject> deployModelList) {
		DeployModelObject dmo = deployModelList.get(0);

		if (dmo instanceof Import) { // Try to find the imported file
			Import theImport = (Import) dmo;
			// Import must be in same project as file it is imported into
			IProject project = WorkbenchResourceHelper.getFile(theImport).getProject();
			file = NamespaceCore.resolveTopology(project, theImport.getNamespace(), theImport
					.getDisplayName());
		}
		if (file == null) {
			file = (IFile) AdaptabilityUtility.getAdapter(dmo, IFile.class);
		}
	}

	private IEditorDescriptor getEditorDescriptor(IFile file) {
		if (file != null) {
			IEditorRegistry registry = PlatformUI.getWorkbench().getEditorRegistry();
			currentDescriptor = registry.getDefaultEditor(file.getName());
		}

		return currentDescriptor;
	}

}
