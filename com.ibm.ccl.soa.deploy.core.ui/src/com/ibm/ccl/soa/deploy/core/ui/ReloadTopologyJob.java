/***************************************************************************************************
 * Copyright (c) 2008 IBM Corporation. All rights reserved.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.progress.UIJob;

import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployCoreEditor;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.savables.TopologyArtifactsMonitor;
import com.ibm.ccl.soa.infrastructure.internal.emf.ReferenceCountAdapter;

/**
 * @since 7.0
 * 
 */
public class ReloadTopologyJob extends UIJob implements ISchedulingRule {

	private final Map<IEditorPart, Resource> openEditors = new HashMap<IEditorPart, Resource>();
	private final Collection<IFile> filesToOpen = new HashSet<IFile>();
	private final Collection<Resource> diagramResources = new HashSet<Resource>();

	/**
	 * Return the singleton job.
	 */
	public static ReloadTopologyJob INSTANCE = new ReloadTopologyJob();

	private final ListenerList queue = new ListenerList() {

		public synchronized Object[] getListeners() {
			Object[] data = super.getListeners();
			clear();
			return data;

		}
	};

	private ReloadTopologyJob() {
		super(Messages.ReloadTopologyJob_Refreshing_Topology_Content_);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.progress.UIJob#runInUIThread(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public IStatus runInUIThread(IProgressMonitor monitor) {
		Object[] files = queue.getListeners();
		if (files.length == 0) {
			return Status.OK_STATUS;
		}
		monitor.beginTask(Messages.ReloadTopologyJob_Refreshing_Topology_Content_, files.length);
		try {
			Set<IFile> trackedFiles = new HashSet<IFile>();
			for (int i = 0; i < files.length; i++) {
				doRun((IFile) files[i]);
				trackedFiles.add((IFile) files[i]);
				monitor.worked(1);
			}
		} finally {
			clearCaches();
		}
		monitor.done();
		return Status.OK_STATUS;
	}

	private void clearCaches() {
		diagramResources.clear();
		filesToOpen.clear();
		openEditors.clear();
	}

	private IStatus doRun(IFile file) {
		clearCaches();
		if (file == null) {
			return Status.OK_STATUS;
		}
		//Compute topology Resource
		Resource topologyResource = computeTopologyResource(file);

		if (topologyResource == null) {
			return Status.OK_STATUS;
		}

		boolean isTopConsistent = isConsistent(topologyResource);

		Topology topology = getTopology(topologyResource);
		//Compute related resources
		computeDiagramResources(topologyResource, topology);

		//If the topology is consistent then remove all consistent diagrams.
		if (isTopConsistent) {
			removeConsistentDiagrams();
		}
		//Is any resource modified?
		boolean isModified = computeResourceModification(topologyResource);
		//Are all resources read only?
		boolean isReadOnly = computeReadOnly(topologyResource);

		if (!isTopConsistent || openEditors != null && !openEditors.isEmpty()) {
			//Prompt user
			if (!isReadOnly || isModified) {
				if (promptForReload(topology, isModified)) {
					//If the topology resource is inconsistent then reload all.
					closeOpenEditors(isTopConsistent);
					unloadResources(topologyResource, isTopConsistent);
					reopenEditors();
				}
			}
		}
		return Status.OK_STATUS;
	}

	private void reopenEditors() {
		if (filesToOpen != null && !filesToOpen.isEmpty()) {
			IWorkbenchPage page = getActiveWorkbenchWindow().getActivePage();
			for (IFile openFile : filesToOpen) {
				try {
					IDE.openEditor(page, openFile);
				} catch (PartInitException e) {
					DeployCoreUIPlugin.logError(0, e.getMessage(), e);
				}
			}
		}
	}

	private void unloadResources(Resource topologyResource, boolean isTopConsistent) {
		if (!isTopConsistent) {
			//Should we remove as well?
			topologyResource.unload();
			topologyResource.setModified(false);
		}
		if (diagramResources != null && !diagramResources.isEmpty()) {
			for (Resource diagramRes : diagramResources) {
				diagramRes.unload();
				diagramRes.setModified(false);
			}
		}
	}

	private void removeConsistentDiagrams() {
		if (openEditors == null || openEditors.isEmpty()) {
			return;
		}
		Iterator<Entry<IEditorPart, Resource>> it = openEditors.entrySet().iterator();
		while (it.hasNext()) {
			Entry<IEditorPart, Resource> entry = it.next();
			if (isConsistent(entry.getValue())) {
				if (diagramResources != null) {
					diagramResources.remove(entry.getValue());
				}
				it.remove();
			}
		}
	}

	@SuppressWarnings("restriction")
	private boolean isConsistent(Resource resource) {
		ReferenceCountAdapter adapter = ReferenceCountAdapter.findAdapter(resource);
		if (adapter == null) {
			return true;
		}
		return adapter.isConsistent();
	}

	@SuppressWarnings("restriction")
	private boolean isReadOnly(Resource resource) {
		ReferenceCountAdapter adapter = ReferenceCountAdapter.findAdapter(resource);
		if (adapter == null) {
			return false;
		}
		return adapter.isReadOnly();
	}

	@SuppressWarnings("restriction")
	private void closeOpenEditors(boolean isTopConsistent) {
		if (openEditors == null || openEditors.isEmpty()) {
			return;
		}
		boolean shouldClose = !isTopConsistent;
		Iterator<Entry<IEditorPart, Resource>> it = openEditors.entrySet().iterator();
		while (it.hasNext()) {
			Entry<IEditorPart, Resource> entry = it.next();
			ReferenceCountAdapter adapter = ReferenceCountAdapter.findAdapter(entry.getValue());
			if (!shouldClose && adapter != null) {
				shouldClose = !adapter.isConsistent();
			}
			if (shouldClose) {
				if (adapter != null) {
					filesToOpen.add(adapter.getFile());
				}
				IWorkbenchPage page = entry.getKey().getEditorSite().getPage();
				page.closeEditor(entry.getKey(), false);
			} else {
				//Remove consistent files
				if (diagramResources != null) {
					diagramResources.remove(entry.getValue());
				}
				it.remove();
			}
		}
	}

	private boolean promptForReload(Topology topology, boolean isModified) {
		if (topology == null) {
			return false;
		}
		// prepare prompt
		Shell shell = getDisplay().getActiveShell();
		String msg;
		boolean shouldReload = true;
		if (isModified) {
			//Open Question
			msg = NLS.bind(Messages.ReloadTopologyJob_The_topology_0_has_been_changed_, topology
					.getQualifiedName());
			shouldReload = MessageDialog.openQuestion(shell,
					Messages.ReloadTopologyJob_Topology_Change_, msg);
		} else {
			//Open Info
			shouldReload = true;
			msg = NLS.bind(Messages.ReloadTopologyJob_The_topology_0_has_been_changed__2, topology
					.getQualifiedName());
			MessageDialog.openInformation(shell, Messages.ReloadTopologyJob_Topology_Change_, msg);
		}
		return shouldReload;
	}

	private boolean computeResourceModification(Resource topologyResource) {
		//check model resource first
		if (topologyResource != null) {
			if (topologyResource.isModified()) {
				return true;
			}
		}
		//Check diagram resources
		if (diagramResources != null && !diagramResources.isEmpty()) {
			for (Resource diagramResource : diagramResources) {
				if (diagramResource.isModified()) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean computeReadOnly(Resource topologyResource) {
		//check model resource first
		if (topologyResource != null) {
			if (!isReadOnly(topologyResource)) {
				return false;
			}
		}
		//Check diagram resources
		if (diagramResources != null && !diagramResources.isEmpty()) {
			for (Resource diagramResource : diagramResources) {
				if (!isReadOnly(diagramResource)) {
					return false;
				}
			}
		}
		return true;
	}

	private IWorkbenchWindow getActiveWorkbenchWindow() {
		if (!PlatformUI.isWorkbenchRunning()) {
			return null;
		}
		IWorkbench workbench = PlatformUI.getWorkbench();
		return workbench.isClosing() ? null : workbench.getActiveWorkbenchWindow();
	}

	private void computeDiagramResources(Resource topologyResource, Topology topology) {
		if (topologyResource != null) {
			//Compute open editors and diagram resources
			IWorkbenchWindow ww = getActiveWorkbenchWindow();
			if (ww != null) {
				IWorkbenchPage page = ww.getActivePage();
				if (page != null) {
					IEditorReference[] editorReferences = page.getEditorReferences();
					for (int i = 0; i < editorReferences.length; i++) {
						IEditorPart tmpEditor = editorReferences[i].getEditor(false);
						if (tmpEditor instanceof DeployCoreEditor) {
							DeployCoreEditor deployEditor = (DeployCoreEditor) tmpEditor;
							computeDiagramResource(topology, deployEditor);
						}
					}
				}
			}
		}
	}

	private void computeDiagramResource(Topology top, DeployCoreEditor deployEditor) {
		DeployDiagramEditPart ddep = (DeployDiagramEditPart) deployEditor.getDiagramEditPart();
		EObject semanticElement = ddep.resolveSemanticElement();
		if (top == semanticElement) {
			//We have a match.
			Diagram diagram = deployEditor.getDiagram();
			if (diagram != null) {
				Resource diagramResource = diagram.eResource();
				if (diagramResource != null) {
					diagramResources.add(diagramResource);
					openEditors.put(deployEditor, diagramResource);
				} else {
					openEditors.put(deployEditor, null);
				}
			}
		}
	}

	private Resource computeTopologyResource(IFile file) {
		if (file != null) {
			return TopologyArtifactsMonitor.INSTANCE.getReadOnlyResource(file, false);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private Topology getTopology(Resource topologyResource) {
		if (topologyResource != null) {
			List contents = topologyResource.getContents();
			if (!contents.isEmpty()) {
				DeployCoreRoot root = (DeployCoreRoot) contents.get(0);
				return root.getTopology();
			}
		}
		return null;
	}

	public boolean contains(ISchedulingRule rule) {
		return this == rule;
	}

	public boolean isConflicting(ISchedulingRule rule) {
		return this == rule;
	}

	/**
	 * Enqueue the given topology or topologyv {@link IFile} to detect file system changes and to
	 * reload topologies as necessary.
	 * 
	 * @param aFile
	 *           A non-null object to refresh in the viewer.
	 */
	public void enqueue(IFile aFile) {
		IFile theModelFile = TopologyArtifactsMonitor.INSTANCE.getAssociatedModelFile(aFile);
		if (theModelFile != null) {
			queue.add(theModelFile);
			schedule(200);
		}
	}
}
