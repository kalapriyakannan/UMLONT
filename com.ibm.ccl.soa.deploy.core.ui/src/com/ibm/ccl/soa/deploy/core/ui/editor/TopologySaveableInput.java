package com.ibm.ccl.soa.deploy.core.ui.editor;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditorInput;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.ui.part.FileEditorInput;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.ui.savables.TopologySaveable;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelScribbler;

public class TopologySaveableInput extends FileEditorInput implements IDiagramEditorInput {

	private final TopologySaveable saveable;
	IEditModelScribbler scribbler;

	public TopologySaveableInput(IFile diagramFile, TopologySaveable saveable) {
		super(diagramFile);
		this.saveable = saveable;

	}

	@Override
	public String getName() {
		return getFile().getName();
	}

	//todo discuss with melder why the scribbler is getting vaporized blb

	public Diagram getDiagram() {
		try {
			if (getFile().isAccessible() && saveable.isOpen() && !saveable.getScribbler().isClosed()) {
				Resource resource = saveable.getScribbler().getResource(getFile().getFullPath());
				return getDiagram(resource);
			}
		} catch (IllegalStateException e) {
			DeployCorePlugin
					.logError(
							0,
							"An unexpected problem occured while working with " + getFile().getFullPath().lastSegment() + ".", e); //$NON-NLS-1$//$NON-NLS-2$
		}
		return null;
	}

	private Diagram getDiagram(Resource resource) {
		if (resource != null && resource.getContents().size() > 0) {
			List contents = resource.getContents();
			return (Diagram) contents.get(0);
		}
		return null;
	}

}
