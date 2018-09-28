package com.ibm.ccl.soa.deploy.core.ui.savables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;

import com.ibm.ccl.soa.deploy.core.IConstants;

/**
 * <p>
 * Represents a normalized event that occurs on a Zephyr topology artifact. Zephyr artifacts can be
 * one of a topology model file ( *.topology ) or a diagram file ( *.topologyv ). The ArtifactEvent
 * contains an event code and two lists of IFile handles that represent the affected model and
 * diagram files.
 * </p>
 * 
 * @author Tim Pouyer <tpouyer@us.ibm.com>
 * @since 7.0
 * 
 */
public class ArtifactEvent {

	/**
	 * <p>
	 * Event code for a change to a topology model file ( *.topology )
	 * </p>
	 */
	public static final int MODEL_CHANGED = 0;

	/**
	 * <p>
	 * Event code for a save event occuring to a topology model file ( *.topology )
	 * </p>
	 */
	public static final int MODEL_SAVED = 1;

	/**
	 * <p>
	 * Event code for a resource load event occuring to a topology model file ( *.topology )
	 * </p>
	 */
	public static final int MODEL_OPENED = 2;

	/**
	 * <p>
	 * Event code for a resource unloaded event occuring to a topology model file ( *.topology )
	 * </p>
	 */
	public static final int MODEL_CLOSED = 3;

	/**
	 * <p>
	 * Event code for a resource unloaded event that is about to occur, due to a project close event,
	 * on a topology file ( *.topology )
	 * </p>
	 */
	public static final int MODEL_PRE_REMOVE = 4;

	/**
	 * <p>
	 * Event code for a resource removed event, occurs when a project is closed or deleted, or when a
	 * model is deleted, on a topology file ( *.topology )
	 * </p>
	 */
	public static final int MODEL_REMOVED = 5;

	/**
	 * <p>
	 * Event code for a resource changed event on a topology diagram file ( *.topologyv ).
	 * </p>
	 */
	public static final int DIAGRAM_CHANGED = 6;

	/**
	 * <p>
	 * Event code for a resource saved event on a topology diagram file ( *.topologyv )
	 * </p>
	 */
	public static final int DIAGRAM_SAVED = 7;

	/**
	 * <p>
	 * Event code for a resource loaded event on a topology diagram file ( *.topologyv )
	 * </p>
	 */
	public static final int DIAGRAM_OPENED = 8;

	/**
	 * <p>
	 * Event code for a resource unloaded event on a topology diagram fiel ( *.topologyv )
	 * </p>
	 */
	public static final int DIAGRAM_CLOSED = 9;

	/**
	 * <p>
	 * Event code for a resource unloaded event that is about to occur, due to a project close event,
	 * on a topology diagram file ( *.topologyv ).
	 * </p>
	 */
	public static final int DIAGRAM_PRE_REMOVED = 10;

	/**
	 * <p>
	 * Event code for a resource removed event, occurs when a project is closed or deleted, or when a
	 * diagram is deleted, on a topology diagram file ( *.topologyv ).
	 * </p>
	 */
	public static final int DIAGRAM_REMOVED = 11;

	public static final int MODEL_MOVED = 12;

	public static final int DIAGRAM_MOVED = 13;
	
	public static final int NAMESPACE_REMOVED = 14;

	/**
	 * <p>
	 * Event code for a change to a the underlying contents of the topology model file ( *.topology ).
	 * This typically results in a forced unload of the model resources. Clients should typically
	 * refresh their content.
	 * </p>
	 */
	public static final int MODEL_FILE_CHANGED = 15;

	/**
	 * <p>
	 * Event code for a change to a the underlying contents of the topology diagram file (
	 * *.topologyv ). This typically results in a forced unload of the model resources. Clients
	 * should typically refresh their content.
	 * </p>
	 */
	public static final int DIAGRAM_FILE_CHANGED = 16;

	private final List<IResource> artifacts = new ArrayList<IResource>();

	private final int event;

	/**
	 * <p>
	 * Creates a new ArtifactEvent with the given event code and a list of IFile handles to all of
	 * the affected topology artifacts.
	 * </p>
	 * 
	 * @param event
	 *           the event code for this ArtifactEvent
	 * @param artifacts
	 *           list of IFile handles representing all of the artifacts that are affected by this
	 *           event. This list should contain all of the affected artifacts ( both model and
	 *           diagram files ).
	 */
	public ArtifactEvent(int event, List<IResource> artifacts) {
		this.event = event;
		this.artifacts.addAll(artifacts);
	}

	/**
	 * <p>
	 * Creates a new ArtifactEvent with the given event code and an array of IFile handles to all of
	 * the affected topology artifacts.
	 * </p>
	 * 
	 * @param event
	 *           the event code for this ArtifactEvent
	 * @param artifacts
	 *           Array of IFile handles representing all of the artifacts that are affected by this
	 *           event. This array should contain all of the affected artifacts ( both model and
	 *           diagram files ).
	 */
	public ArtifactEvent(int event, IResource[] artifacts) {
		this.event = event;
		this.artifacts.addAll(Arrays.asList(artifacts));
	}

	/**
	 * <p>
	 * Returns the event code of this ArtifactEvent.
	 * </p>
	 * 
	 * @return int representing the event code of this ArtifactEvent.
	 */
	public int getEventCode() {
		return event;
	}

	/**
	 * <p>
	 * Returns a List of IFile handles for all of the affected topology model files for this
	 * ArtifactEvent.
	 * </p>
	 * 
	 * @return a list of affected topology model files for this event.
	 */
	public List<IFile> getAffectedModels() {
		return findArtifactsByExtension(IConstants.TOPOLOGY_EXTENSION);
	}

	/**
	 * <p>
	 * Returns a List of IFile handles for all of the affected topology diagram files for this
	 * ArtifactEvent.
	 * </p>
	 * 
	 * @return a list of affected topology diagram files for this event.
	 */
	public List<IFile> getAffectedDiagrams() {
		return findArtifactsByExtension(IConstants.TOPOLOGYV_EXTENSION);
	}

	public List<IContainer> getAffectedNamespaces() {
		return findContainerArtifacts();
	}

	private List<IFile> findArtifactsByExtension(String extension) {
		List<IFile> matches = new ArrayList<IFile>();
		for (Iterator<IResource> iter = artifacts.iterator(); iter.hasNext();) {
			IResource artifact = iter.next();
			if (artifact != null && artifact.getType() == IResource.FILE) {
				String ending = artifact.getFileExtension();
				if (extension.equals(ending)) {
					matches.add((IFile) artifact);
				}
			}
		}

		return matches;
	}

	private List<IContainer> findContainerArtifacts() {
		List<IContainer> matches = new ArrayList<IContainer>();
		for (Iterator<IResource> iter = artifacts.iterator(); iter.hasNext();) {
			IResource artifact = iter.next();
			if (artifact != null && artifact instanceof IContainer) {
				if (!matches.contains(artifact)) {
					matches.add((IContainer) artifact);
				}
			}
		}

		return matches;
	}
}
