package com.ibm.ccl.soa.deploy.core.ui.savables;

import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;

/**
 * <p>
 * Interface to be implemented by classes that wish to listen to ArtifactEvents published by the
 * TopologyArtifactsMonitor.
 * </p>
 * 
 * @author Tim Pouyer <tpouyer@us.ibm.com>
 * @since 7.0
 * 
 */
public abstract class ArtifactListener {

	/**
	 * <p>
	 * Called when a dirty edit model event occurs on a topology model file.
	 * </p>
	 * 
	 * @param model
	 *           the model file that the dirty edit model event occurred on
	 */
	public void onModelChanged(IFile model) {

	}

	/**
	 * <p>
	 * Called when a the underlying topology model file's contents are changed such as a check-out
	 * from an SCM or replace history.
	 * 
	 * If the client is storing references to the in memory model elements they will be proxies at
	 * this time. The client will need to refresh their pointers.
	 * </p>
	 * 
	 * @param model
	 *           the model file wholse contents have changed
	 */
	public void onModelFileChanged(IFile model) {

	}

	/**
	 * <p>
	 * Called when a save edit model event occurs on a topology model file.
	 * </p>
	 * 
	 * @param model
	 *           the model file that the save edit model event occurred on.
	 */
	public void onModelSaved(IFile model) {

	}

	/**
	 * <p>
	 * Called when a loaded resource edit model event occurs on a topology model file.
	 * </p>
	 * 
	 * @param model
	 *           the model file that the loaded resource edit model event occurred on.
	 */
	public void onModelOpened(IFile model) {

	}

	/**
	 * <p>
	 * Called when an unloaded resource edit model event occurs on a topology model file.
	 * </p>
	 * 
	 * @param model
	 *           the model file that the unloaded resource edit model event occurred on.
	 */
	public void onModelClosed(IFile model) {

	}

	/**
	 * <p>
	 * Called when a 'PRE_CLOSE' event is called on a project that contains loaded topology models,
	 * which indicates that these models are about to be unloaded and any clean-up should occur
	 * immediately. The 'PRE_CLOSE' event on the project cannot be stopped from this method.
	 * </p>
	 * 
	 * @param model
	 *           the model files within the project that the 'PRE_CLOSE' event occurred on that are
	 *           about to be unloaded.
	 */
	public void onModelsAboutToBeRemoved(List<IFile> models) {

	}

	/**
	 * <p>
	 * Called when an unloaded resource edit model event occurs on a topology model file. This could
	 * be caused by a model being deleted from the workspace or when the project that this model
	 * belongs to is closed. At this point the model file has already been unloaded.
	 * </p>
	 * 
	 * @param model
	 *           the model file that has been unloaded
	 */
	public void onModelRemoved(IFile model) {

	}

	public void onModelMoved(IFile oldModelLocation, IFile newModelLocation) {

	}

	/**
	 * <p>
	 * Called when a dirty edit model event occurs on a topology diagram.
	 * </p>
	 * 
	 * @param diagram
	 *           the diagram file that the dirty event was fired on.
	 * @param model
	 *           the model file that the diagram is associated with.
	 */
	public void onDiagramChanged(IFile diagram) {

	}

	/**
	 * <p>
	 * Called when a the underlying topology diagram file's contents are changed such as a check-out
	 * from an SCM or replace history.
	 * 
	 * If the client is storing references to the in memory diagram model elements they will be
	 * proxies at this time. The client will need to refresh their pointers.
	 * </p>
	 * 
	 * @param diagram
	 *           the diagram file that was changed
	 */
	public void onDiagramFileChanged(IFile diagram) {

	}

	/**
	 * <p>
	 * Called when a save edit model event occurs on a topology diagram.
	 * </p>
	 * 
	 * @param diagram
	 *           the diagram file that the save event was fired on.
	 * @param model
	 *           the model file that the diagram is associated with.
	 */
	public void onDiagramSaved(IFile diagram) {

	}

	/**
	 * <p>
	 * Called when a resource loaded edit model event occurs on a topology diagram.
	 * </p>
	 * 
	 * @param diagram
	 *           the diagram file that the loaded event was fired on.
	 * @param model
	 *           the model file that the diagram is associated with.
	 */
	public void onDiagramOpened(IFile diagram) {

	}

	/**
	 * <p>
	 * Called when a resource unloaded edit model event occurs on a topology diagram.
	 * </p>
	 * 
	 * @param diagram
	 *           the diagram file that the unloaded event was fired on.
	 * @param model
	 *           TODO
	 */
	public void onDiagramClosed(IFile diagram) {

	}

	/**
	 * <p>
	 * Called when a resource removed edit model event occurs on a topology diagram.
	 * </p>
	 * 
	 * @param diagram
	 *           the diagram file that the removed event was fired on.
	 * @param model
	 *           the model file that the diagram is associated with.
	 */
	public void onDiagramRemoved(IFile diagram) {

	}

	public void onDiagramMoved(IFile oldDiagramLocation, IFile newDiagramLocation) {

	}

	public void onNamespaceRemoved(IContainer namespace) {

	}
}
