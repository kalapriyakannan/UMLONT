package com.ibm.ccl.soa.deploy.core.ui.editor;

import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.part.FileEditorInput;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;

/**
 * @since 7.0
 * 
 */
public class VisualizeFileEditorInput extends FileEditorInput {

	final List<DeployModelObject> _visualizeDmos;
	final Diagram _sourceDiagram;
	final Map<DeployModelObject, View> _viewMap;

	/**
	 * open the diagram file and visualize the list of dmos
	 * 
	 * @param diagramFile --
	 *           the .topologyv file
	 * @param visualizeDmos
	 *           --dmos to create views for
	 * @param sourceDiagram --
	 *           if not null, arrange visualized units the same way they are arranged in this diagram
	 */
	public VisualizeFileEditorInput(IFile diagramFile, List<DeployModelObject> visualizeDmos) {
		super(diagramFile);
		_visualizeDmos = visualizeDmos;
		_sourceDiagram = null;
		_viewMap = null;
	}

	/**
	 * open the diagram file and visualize everything in diagram
	 * 
	 * @param diagramFile --
	 *           the .topologyv file
	 * @param sourceDiagram --
	 *           if not null, arrange visualized units the same way they are arranged in this diagram
	 */
	public VisualizeFileEditorInput(IFile diagramFile, List<DeployModelObject> visualizeDmos,
			Diagram sourceDiagram) {
		super(diagramFile);
		_visualizeDmos = visualizeDmos;
		_sourceDiagram = sourceDiagram;
		_viewMap = null;
	}

	/**
	 * open the diagram file and visualize everything in diagram
	 * 
	 * @param diagramFile --
	 *           the .topologyv file
	 * @param viewMap --
	 *           a map of objects to visualize pointing to their notation objects for copying
	 */
	public VisualizeFileEditorInput(IFile diagramFile, Map<DeployModelObject, View> viewMap) {
		super(diagramFile);
		_visualizeDmos = null;
		_sourceDiagram = null;
		_viewMap = viewMap;
	}

	/**
	 * @return the dmos for which views should be created
	 */
	public List<DeployModelObject> getVisualizeDmos() {
		return _visualizeDmos;
	}

	/**
	 * @return the diagram which the unit arrangement will come from
	 */
	public Diagram getSourceDiagram() {
		return _sourceDiagram;
	}

	/**
	 * @return the view map of semantic model elemnts->notation model elements
	 */
	public Map<DeployModelObject, View> getViewMap() {
		return _viewMap;
	}

	/**
	 * @return the view map of semantic model elemnts->notation model elements
	 */
	public boolean hasNotationModel() {
		return _sourceDiagram != null || _viewMap != null;
	}

}
