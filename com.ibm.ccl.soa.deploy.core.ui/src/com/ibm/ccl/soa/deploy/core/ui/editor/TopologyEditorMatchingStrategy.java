package com.ibm.ccl.soa.deploy.core.ui.editor;

import org.eclipse.core.resources.IFile;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorMatchingStrategy;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.savables.TopologyArtifactsMonitor;

public class TopologyEditorMatchingStrategy implements IEditorMatchingStrategy {

	public boolean matches(IEditorReference editorRef, IEditorInput input) {

		TopologySaveableInput editorInput = null;
		try {
			if (editorRef.getEditorInput() instanceof TopologySaveableInput) {
				editorInput = (TopologySaveableInput) editorRef.getEditorInput();
			}
		} catch (PartInitException e) {
			DeployCoreUIPlugin.logError(0, e.getMessage(), e);
		}

		if (editorInput != null) {

			IFile editorDiagramFile = editorInput.getFile();
			IFile editorModelFile = TopologyArtifactsMonitor.INSTANCE
					.getAssociatedModelFile(editorDiagramFile);

			// there are cases where the diagram file is corrupted and doesn't 
			// properly reference a valid model file 
			if (editorModelFile != null) {

				IFile modelFile = null;
				IFile diagramFile = null;
				if (input instanceof TopologySaveableInput) {
					diagramFile = ((TopologySaveableInput) input).getFile();
					modelFile = TopologyArtifactsMonitor.INSTANCE.getAssociatedModelFile(diagramFile);
				} else if (input instanceof IFileEditorInput) {
					IFile file = ((IFileEditorInput) input).getFile();
					if (IConstants.TOPOLOGY_EXTENSION.equals(file.getFileExtension())) {
						modelFile = file;
					} else if (IConstants.TOPOLOGYV_EXTENSION.equals(file.getFileExtension())) {
						diagramFile = file;
					}
				}

				if (modelFile == null && diagramFile == null) {
					return false;
				}
				if (modelFile != null && !editorModelFile.equals(modelFile)) {
					return false;
				}
				if (diagramFile != null && !editorDiagramFile.equals(diagramFile)) {
					return false;
				}
				return true;
			}
		}
		return false;
	}

}
