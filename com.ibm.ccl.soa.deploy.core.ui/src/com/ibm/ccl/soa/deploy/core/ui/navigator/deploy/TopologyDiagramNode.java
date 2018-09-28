package com.ibm.ccl.soa.deploy.core.ui.navigator.deploy;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.part.FileEditorInput;

import com.ibm.ccl.soa.deploy.core.ui.editor.DeployCoreEditor;
import com.ibm.ccl.soa.deploy.core.ui.savables.TopologyArtifactsMonitor;
import com.ibm.ccl.soa.deploy.core.ui.savables.TopologySaveable;

/**
 * A node on the Project Explorer representing a diagram for a Topology.
 * 
 * @since 7.0
 * @see DeployEMFContentProvider
 */
public class TopologyDiagramNode implements IAdaptable {
	private final IFile diagramFile;
	private IFile topologyFile;
	private TopologySaveable saveable;

	/**
	 * @param ifile
	 * @param top
	 */
	public TopologyDiagramNode(IFile ifile) {
		diagramFile = ifile;
	}

	public TopologyDiagramNode(IFile file, TopologySaveable saveable) {
		diagramFile = file;
		this.saveable = saveable;
	}

	public TopologySaveable getSaveable() {
		return saveable;
	}

	public DeployCoreEditor findOpenEditor(IWorkbenchPage page) {

		IEditorPart editor = page.findEditor(new FileEditorInput(diagramFile));
		if (editor != null && editor instanceof DeployCoreEditor) {
			return (DeployCoreEditor) editor;
		}
		return null;
	}

	/**
	 * Return the diagram file for this node.
	 * 
	 * @return The diagram file for this node.
	 */
	public IFile getDiagramFile() {
		return diagramFile;
	}

	public IFile getTopologyFile() {
		if (topologyFile == null) {
			topologyFile = TopologyArtifactsMonitor.INSTANCE.getAssociatedModelFile(diagramFile);
		}
		return topologyFile;
	}

	@SuppressWarnings("unchecked")
	public Object getAdapter(Class adapter) {
		if (adapter == IResource.class || adapter == IFile.class) {
			return diagramFile;
		}
		return null;
	}

	/**
	 * @return
	 */
	public String getText() {
		return diagramFile.getName().substring(0, diagramFile.getName().indexOf(".")); //$NON-NLS-1$
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (diagramFile == null ? 0 : diagramFile.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final TopologyDiagramNode other = (TopologyDiagramNode) obj;
		if (diagramFile == null) {
			if (other.diagramFile != null) {
				return false;
			}
		} else if (!diagramFile.equals(other.diagramFile)) {
			return false;
		}
		return true;
	}

}
