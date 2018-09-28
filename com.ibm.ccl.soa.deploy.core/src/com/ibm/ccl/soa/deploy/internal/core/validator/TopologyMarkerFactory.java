/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.validator.IDeployMarker;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

/**
 * Factory for Eclipse SOA deploy topology markers.
 * 
 * @see DeployMarker
 */
public class TopologyMarkerFactory {

	private TopologyMarkerFactory() {
		// static methods only
	}

	/** Character used to separate units in a full object name. */
	public static final char UNIT_SEPARATOR = '/';

	/**
	 * Character used to separate the service from its unit in a full object name.
	 */
	public static final char SERVICE_SEPARATOR = '#';

	/** Character used to indicate that the name is a containment index. */
	public static final char INDEX_ESCAPE = '@';

	/** String appended to full name to extract the link from the service. */
	public static final String LINK_TAG = "$link"; //$NON-NLS-1$

	/**
	 * Returns the IFile associated with the EMF resource of the deploy model object.
	 * 
	 * @param object
	 *           the object whose IFile resource container is needed.
	 * 
	 * @return the IFile, or null if it cannot be resolved.
	 */
	public static IFile getIFile(DeployModelObject object) {
		return WorkbenchResourceHelper.getFile(object.getTopology().getEObject());
	}

	/**
	 * Returns true if the characters in the deploy model object name are valid.
	 * 
	 * @param name
	 *           a candidate for {@link DeployModelObject#setName(String)}
	 * 
	 * @return true if the name is valid.
	 */
	public static boolean isValidDeployModelObjectName(String name) {
		if (name == null || name.length() == 0) {
			return false;
		}

		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			if (c == '/' || c == '@') {
				return false;
			}
		}

		return true;
	}

	/**
	 * Returns true if the name of the deploy model object is unique in its container.
	 * 
	 * @param object
	 *           the deploy object to be checked.
	 * @return true if the object's name is unique in the container.
	 * 
	 * @see DeployModelObject#getName()
	 */
	public static boolean isUniqueDeployModelObjectName(DeployModelObject object) {
		DeployModelObject parent = object.getParent();
		if (parent == null) {
			return true;
		}
		return isUniqueDeployModelObjectName(object, parent.getContainedModelObjects());
	}

	/**
	 * Returns true if the name of the deploy model object is unique in its container.
	 * 
	 * @param object
	 *           the deploy object to be checked.
	 * @param containmentCollection
	 *           the collection of deploy objects to be checked against.
	 * @return true if the object's name is unique in the containmentCollection.
	 * 
	 * @see DeployModelObject#getName()
	 */
	public static boolean isUniqueDeployModelObjectName(DeployModelObject object,
			Collection containmentCollection) {
		if (containmentCollection == null || containmentCollection.isEmpty()) {
			return true;
		}
		String name = object.getName();
		if (name == null || name.length() == 0) {
			return false;
		}
		int count = 0;
		for (Iterator iter = containmentCollection.iterator(); iter.hasNext();) {
			DeployModelObject curr = (DeployModelObject) iter.next();
			if (name.equals(curr.getName())) {
				count++;
			}
		}
		return count <= 1;
	}

	/**
	 * Returns true if the name of the deploy model object is unique in its container.
	 * 
	 * @param object
	 *           the deploy object to be checked.
	 * @param iter
	 *           an iterator over deploy model objects.
	 * @return true if the object's name is unique in the containmentCollection.
	 * 
	 * @see DeployModelObject#getName()
	 */
	public static boolean isUniqueDeployModelObjectName(DeployModelObject object, Iterator iter) {
		if (iter == null || !iter.hasNext()) {
			return true;
		}
		String name = object.getName();
		if (name == null || name.length() == 0) {
			return false;
		}
		int count = 0;
		while (iter.hasNext()) {
			DeployModelObject curr = (DeployModelObject) iter.next();
			if (name.equals(curr.getName())) {
				count++;
			}
		}
		return count <= 1;
	}

	/**
	 * Returns the full name of the deploy model object.
	 * <p>
	 * Example: unit1/unit2#service
	 * 
	 * @param object
	 *           the object whose full name is returned.
	 * @return the full name up to the defined container level.
	 */
	public static String getFullName(DeployModelObject object) {
		if (object != null) {
			return object.getFullPath();
		}
		return null;
	}

	/**
	 * Returns the deployment model object identified by the deployment marker.
	 * 
	 * @param topology
	 *           the topology in which the object is defined.
	 * @param marker
	 *           the deploy marker.
	 * @return the object, or null if not defined.
	 */
	public static DeployModelObject getDeployModelObject(Topology topology, IMarker marker) {
		String name = marker.getAttribute(DeployMarker.OBJECT_ID, null);
		if (name == null) {
			return null;
		}
		return topology.resolve(name);
	}

	/**
	 * Removes all the deployment markers on the topology.
	 * 
	 * @param topology
	 *           the topology whose resource markers should be cleared.
	 * @exception CoreException
	 *               if this method fails {@link IResource#deleteMarkers(String, boolean, int)}
	 */
	public static void deleteDeployMarkers(Topology topology) throws CoreException {
		deleteDeployMarkers(getIFile(topology));
	}

	/**
	 * Removes all the deployment markers on the resource.
	 * 
	 * @param resource
	 *           an Eclipse resource containing a topology.
	 * @exception CoreException
	 *               if this method fails {@link IResource#deleteMarkers(String, boolean, int)}
	 */
	public static void deleteDeployMarkers(IResource resource) throws CoreException {
		if (resource == null) {
			return;
		}
		resource.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
	}

	/**
	 * Returns the deploy markers for the topology.
	 * 
	 * @param topology
	 *           the topology whose markers are returned.
	 * 
	 * @return the topology markers.
	 * @throws CoreException
	 *            if the topology is not saved.
	 */
	public static IMarker[] getMarkers(Topology topology) throws CoreException {
		return getMarkers(getIFile(topology));
	}

	/**
	 * Returns the deploy markers for the topology stored in the resource.
	 * 
	 * @param resource
	 *           a resource containing a topology.
	 * 
	 * @return the topology markers.
	 * @throws CoreException
	 *            if the resource is not saved.
	 */
	public static IMarker[] getMarkers(IResource resource) throws CoreException {
		return resource.findMarkers(IDeployMarker.MARKER_ID, true, IResource.DEPTH_INFINITE);
	}

	/**
	 * Returns true if the topology has been associated with any deploy error markers.
	 * 
	 * @param topology
	 *           the topology whose markers are checked.
	 * @return true if any error markers are found.
	 * @throws CoreException
	 *            if the topology is not saved.
	 */
	public static boolean hasErrorMarkers(Topology topology) throws CoreException {
		return hasErrorMarkers(getIFile(topology));
	}

	/**
	 * Returns true if the resource has been associated with any deploy error markers.
	 * 
	 * @param resource
	 *           the resource queried for deploy error markers.
	 * @return true if any error markers are found.
	 * @throws CoreException
	 *            if the resource is not saved.
	 */
	public static boolean hasErrorMarkers(IResource resource) throws CoreException {
		IMarker[] markers = getMarkers(resource);
		for (int i = 0; i < markers.length; i++) {
			IMarker marker = markers[i];
			Integer severity = (Integer) marker.getAttribute(IMarker.SEVERITY);
			if (severity != null && severity.intValue() == IMarker.SEVERITY_ERROR) {
				return true;
			}
		}
		return false;
	}
}
