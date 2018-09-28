package com.ibm.ccl.soa.deploy.core.ui.savables;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.ISafeRunnable;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;

/**
 * <p>
 * Implementation of ISafeRunnable that is used by the TopologyArtifactsMonitor to fire
 * ArtifactEvents on it's list of registered ArtifactListeners.
 * </p>
 * 
 * @author Tim Pouyer <tpouyer@us.ibm.com>
 * @since 7.0
 * 
 */
public class ArtifactEventNotifier implements ISafeRunnable {

	private final ArtifactListener listener;
	private final ArtifactEvent event;

	/**
	 * <p>
	 * Constructs a new instance of the ArtifactEventNotifier.
	 * </p>
	 * 
	 * @param listener
	 *           an instance of an ArtifactListener
	 * @param event
	 *           an Instance of an ArtifactEvent
	 */
	public ArtifactEventNotifier(ArtifactListener listener, ArtifactEvent event) {
		this.listener = listener;
		this.event = event;
	}

	/**
	 * {@inheritDoc}
	 */
	public void run() throws Exception {
		switch (event.getEventCode())
		{

		case ArtifactEvent.MODEL_CHANGED:
			if (event.getAffectedModels().size() > 0) {
				listener.onModelChanged(event.getAffectedModels().get(0));
			}
			break;
		case ArtifactEvent.MODEL_FILE_CHANGED:
			if (event.getAffectedModels().size() > 0) {
				listener.onModelFileChanged(event.getAffectedModels().get(0));
			}
			break;
		case ArtifactEvent.MODEL_CLOSED:
			if (event.getAffectedModels().size() > 0) {
				listener.onModelClosed(event.getAffectedModels().get(0));
			}
			break;

		case ArtifactEvent.MODEL_OPENED:
			if (event.getAffectedModels().size() > 0) {
				listener.onModelOpened(event.getAffectedModels().get(0));
			}
			break;

		case ArtifactEvent.MODEL_SAVED:
			if (event.getAffectedModels().size() > 0) {
				listener.onModelSaved(event.getAffectedModels().get(0));
			}
			break;

		case ArtifactEvent.MODEL_PRE_REMOVE:
			if (event.getAffectedModels().size() > 0) {
				listener.onModelsAboutToBeRemoved(event.getAffectedModels());
			}
			break;

		case ArtifactEvent.MODEL_REMOVED:
			if (event.getAffectedModels().size() > 0) {
				listener.onModelRemoved(event.getAffectedModels().get(0));
			}
			break;

		case ArtifactEvent.MODEL_MOVED:
			if (event.getAffectedModels().size() > 0) {
				ArtifactMovedEvent moved = (ArtifactMovedEvent) event;
				IFile newModelLocation = event.getAffectedModels().get(0);
				listener.onModelMoved(moved.getOldFileLocation(newModelLocation), newModelLocation);
			}
			break;

		case ArtifactEvent.DIAGRAM_CHANGED:
			if (event.getAffectedDiagrams().size() > 0) {
				listener.onDiagramChanged(event.getAffectedDiagrams().get(0));
			}
			break;

		case ArtifactEvent.DIAGRAM_FILE_CHANGED:
			if (event.getAffectedDiagrams().size() > 0) {
				listener.onDiagramFileChanged(event.getAffectedDiagrams().get(0));
			}
			break;

		case ArtifactEvent.DIAGRAM_CLOSED:
			if (event.getAffectedDiagrams().size() > 0) {
				listener.onDiagramClosed(event.getAffectedDiagrams().get(0));
			}
			break;

		case ArtifactEvent.DIAGRAM_OPENED:
			if (event.getAffectedDiagrams().size() > 0) {
				listener.onDiagramOpened(event.getAffectedDiagrams().get(0));
			}
			break;

		case ArtifactEvent.DIAGRAM_SAVED:
			if (event.getAffectedDiagrams().size() > 0) {
				listener.onDiagramSaved(event.getAffectedDiagrams().get(0));
			}
			break;

		case ArtifactEvent.DIAGRAM_REMOVED:
			if (event.getAffectedDiagrams().size() > 0) {
				listener.onDiagramRemoved(event.getAffectedDiagrams().get(0));
			}
			break;

		case ArtifactEvent.DIAGRAM_MOVED:
			if (event.getAffectedDiagrams().size() > 0) {
				ArtifactMovedEvent moved = (ArtifactMovedEvent) event;
				IFile newDiagramLocation = event.getAffectedDiagrams().get(0);
				listener.onDiagramMoved(moved.getOldFileLocation(newDiagramLocation),
						newDiagramLocation);
			}
			break;

		case ArtifactEvent.NAMESPACE_REMOVED:
			if (event.getAffectedNamespaces().size() > 0) {
				listener.onNamespaceRemoved(event.getAffectedNamespaces().get(0));
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void handleException(Throwable exception) {
		DeployCorePlugin.logError(0, exception.getMessage(), exception);
	}
}
