/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;
import com.ibm.ccl.soa.deploy.core.validator.IDeployMarker;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployStatusIterator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployPublishStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

/**
 * Constants and static utility methods related to SOA deploy model markers generated during
 * validation.
 * <p>
 * Extends the WST <code>org.eclipse.wst.validation.problemmarker</code> marker.
 * 
 * @see IMarker
 * @see CorePackage
 * 
 * This class should never be instantiated or subclassed. It is intended to provide constants for
 * {@link IMarker#getAttribute(String)} attributes, and static methods for strongly typed access to
 * marker attribute values.
 */
public final class DeployMarker implements IDeployMarker {

	/* Prevent instantiation. */
	private DeployMarker() {
	}

	/**
	 * Returns the Eclipse file resource in which the topology is stored.
	 * 
	 * @param top
	 *           a topology saved in a file.
	 * @return the file storing the topology (never null).
	 * 
	 * @exception IllegalArgumentException
	 *               if the topology EMF resource has not been saved in an Eclipse resource.
	 * @deprecated use {@link WorkbenchResourceHelper#getFile(org.eclipse.emf.ecore.EObject)}
	 */
	public static IFile getIFile(Topology top) throws IllegalArgumentException {
		return WorkbenchResourceHelper.getFile(top.getEObject());
	}

	/**
	 * Returns true if the marker is a deploy marker.
	 * 
	 * @param marker
	 *           an Eclipse marker.
	 * 
	 * @return true if the marker is a subtype of {@link IDeployMarker#MARKER_ID}.
	 */
	public static boolean isInstance(IMarker marker) {
		try {
			return marker.isSubtypeOf(IDeployMarker.MARKER_ID);
		} catch (CoreException e) {
			return false;
		}
	}

	/**
	 * Returns the deploy markers on the {@link IFile} containing the topology.
	 * 
	 * @param top
	 *           the topology whose EMF {@link Resource} is saved as an Eclipse {@link IFile}.
	 * @return an array of markers on the topology (never null).
	 * @exception CoreException
	 *               if the markers could not be retrieved.
	 * 
	 * @see IResource#findMarkers(String, boolean, int)
	 */
	public static IMarker[] getInstances(Topology top) throws CoreException {
		IFile file = WorkbenchResourceHelper.getFile(top);
		if (file != null) {
			return file.findMarkers(IDeployMarker.MARKER_ID, true, IResource.DEPTH_INFINITE);
		}
		return new IMarker[0];
	}

	/**
	 * Deletes all the deployment markers on the topology.
	 * 
	 * @param top
	 *           the topology whose markers should be deleted.
	 * 
	 * @throws CoreException
	 *            if the markers cannot be deleted.
	 * 
	 * @see IResource#deleteMarkers(String, boolean, int)
	 */
	public static void deleteInstances(Topology top) throws CoreException {
		IFile file = WorkbenchResourceHelper.getFile(top);
		if (file != null) {
			file.deleteMarkers(IDeployMarker.MARKER_ID, true, IResource.DEPTH_INFINITE);
		}
	}

	/**
	 * Returns the problem type of the deploy marker.
	 * 
	 * @param marker
	 *           a deploy marker (@link #MARKER_ID}.
	 * @return the {@link IDeployMarker#PROBLEM_TYPE}.
	 */
	public static String getProblemType(IMarker marker) {
		assert isInstance(marker);
		return marker.getAttribute(IDeployMarker.PROBLEM_TYPE, null);
	}

	/**
	 * Sets the problem type of the marker.
	 * 
	 * @param marker
	 *           the deploy marker whose type should be set.
	 * @param problemType
	 *           a deploy marker {@link IDeployMarker#PROBLEM_TYPE}.
	 * @throws CoreException
	 */
	public static void setProblemType(IMarker marker, String problemType) throws CoreException {
		assert isInstance(marker);
		marker.setAttribute(IDeployMarker.PROBLEM_TYPE, problemType);
	}

	/**
	 * Returns the ID of the validator that created this marker.
	 * 
	 * @param marker
	 *           a deploy marker.
	 * @return the validator ID, or null if not set.
	 */
	public static String getValidatorID(IMarker marker) {
		assert isInstance(marker);
		return marker.getAttribute(VALIDATOR_ID, null);
	}

	/**
	 * Sets the ID of the validator that created the marker.
	 * 
	 * @param marker
	 *           a deploy marker.
	 * @param validatorID
	 *           the ID of the validator creating the marker.
	 * @throws CoreException
	 *            if the marker does not exist.
	 */
	public static void setValidatorID(IMarker marker, String validatorID) throws CoreException {
		assert isInstance(marker);
		marker.setAttribute(VALIDATOR_ID, validatorID);
	}

	/**
	 * Returns the ID of the validator thread that created this marker.
	 * 
	 * @param marker
	 *           a deploy marker.
	 * @return the validator thread ID, or null if not set.
	 */
	public static String getValidatorThreadID(IMarker marker) {
		assert isInstance(marker);
		return marker.getAttribute(VALIDATOR_GROUP_ID, null);
	}

	/**
	 * Sets the ID of the validator thread that created the marker.
	 * 
	 * @param marker
	 *           a deploy marker.
	 * @param validatorThreadID
	 *           the ID of the validator thread creating the marker.
	 * @throws CoreException
	 *            if the marker does not exist.
	 */
	public static void setValidatorThreadID(IMarker marker, String validatorThreadID)
			throws CoreException {
		assert isInstance(marker);
		marker.setAttribute(VALIDATOR_GROUP_ID, validatorThreadID);
	}

	/**
	 * Returns the bundle of the message that was serialized in this marker.
	 * 
	 * @param marker
	 *           a deploy marker.
	 * @return the message bundle, or null if not set.
	 */
	public static String getMessageBundle(IMarker marker) {
		assert isInstance(marker);
		return marker.getAttribute(STATUS_BUNDLE, null);
	}

	/**
	 * Sets the bundle of the massage that was serialized in this marker.
	 * 
	 * @param marker
	 *           a deploy marker.
	 * @param bundle
	 *           the bundle of the message that created this marker.
	 * @throws CoreException
	 *            if the marker does not exist.
	 */
	public static void setMessageBundle(IMarker marker, String bundle) throws CoreException {
		assert isInstance(marker);
		marker.setAttribute(STATUS_BUNDLE, bundle);
	}

	/**
	 * Returns the class of the message that was serialized in this marker.
	 * 
	 * @param marker
	 *           a deploy marker.
	 * @return the message class, or null if not set.
	 */
	public static String getMessageClass(IMarker marker) {
		assert isInstance(marker);
		return marker.getAttribute(STATUS_CLASS, null);
	}

	/**
	 * Sets the class of the massage that was serialized in this marker.
	 * 
	 * @param marker
	 *           a deploy marker.
	 * @param messageClass
	 *           the class of the message that created this marker.
	 * @throws CoreException
	 *            if the marker does not exist.
	 */
	public static void setMessageClass(IMarker marker, String messageClass) throws CoreException {
		assert isInstance(marker);
		marker.setAttribute(STATUS_CLASS, messageClass);
	}

	/**
	 * Sets the ID of the validator that created the marker.
	 * 
	 * @param marker
	 *           a deploy marker.
	 * @param validatorClass
	 *           the class of the validator.
	 * @throws CoreException
	 *            if the marker does not exist.
	 */
	public static void setValidator(IMarker marker, EClass validatorClass) throws CoreException {
		if (validatorClass == null) {
			setValidatorID(marker, null);
		} else {
			setValidatorID(marker, validatorClass.getName());
		}
	}

	/**
	 * Returns a string description of the marker.
	 * 
	 * @param marker
	 *           the marker whose description is to be returned.
	 * @return a string description of the marker.
	 */
	public static String toString(IMarker marker) {
		StringBuffer buffer = new StringBuffer();
		try {
			buffer.append(marker.getResource().getFullPath().toString());
			buffer.append(": "); //$NON-NLS-1$
			buffer.append(marker.getType());
			buffer.append(" ("); //$NON-NLS-1$
			buffer.append(marker.getId());
			buffer.append(')');
			buffer.append(" {"); //$NON-NLS-1$
			Map attributeMap = marker.getAttributes();
			if (attributeMap != null) {
				Set attributeNameSet = new TreeSet();
				attributeNameSet.addAll(attributeMap.keySet());
				for (Iterator iter = attributeNameSet.iterator(); iter.hasNext();) {
					String name = (String) iter.next();
					Object value = attributeMap.get(name);
					buffer.append("\n\t"); //$NON-NLS-1$
					buffer.append(name);
					buffer.append('=');
					buffer.append(value);
					if (iter.hasNext()) {
						buffer.append(',');
					}

				}
			}
			buffer.append(" }"); //$NON-NLS-1$
			return buffer.toString();
		} catch (Throwable e) {
			return e.getMessage();
		}
	}

	/**
	 * Creates a deploy message with the specified problem type.
	 * 
	 * @param type
	 *           the deploy problem type.
	 * @param topology
	 *           the deploy topology marked (used to obtain
	 * @return the deploy message.
	 * 
	 * @deprecated use {@link DeployCoreStatusFactory#createDeployStatus(IMarker, Topology)}
	 */
	public static IDeployStatus createMessage(String type, Topology topology) {
		return DeployCoreStatusFactory.INSTANCE.createDeployStatus(type, topology);
	}

	/**
	 * Creates markers for the deploy status messages in the topology.
	 * 
	 * @param topology
	 *           a topology.
	 * @param monitor
	 *           the creation progress monitor.
	 * 
	 * @exception CoreException
	 *               if the markers could not be created.
	 */
	public static void createMarkers(Topology topology, IProgressMonitor monitor)
			throws CoreException {

		DeployMarker.deleteInstances(topology);

		List<IDeployStatus> deployStatusList = new ArrayList<IDeployStatus>();
		for (Iterator iter = topology.findAllDeployModelObjects(); iter.hasNext();) {
			DeployModelObject object = (DeployModelObject) iter.next();
			gatherStatusObjects(object, deployStatusList);
		}

		// The Topologies could have status as well.
		for (Iterator<Topology> iter = TopologyUtil.getAllImportedTopologies(topology, true)
				.iterator(); iter.hasNext();) {
			Topology cur = iter.next();
			gatherStatusObjects(cur, deployStatusList);
		}

		if (monitor != null) {
			monitor.beginTask(DeployCoreMessages.Saving_markers_job, deployStatusList.size());
		}

		try {
			for (Iterator<IDeployStatus> iter = deployStatusList.iterator(); iter.hasNext();) {
				IDeployStatus status = iter.next();
				if (status != null) {
					try {
						status.createMarker();
					} catch (Exception e) {
						DeployCorePlugin.logError(0, "" + e.getMessage(), e);//$NON-NLS-1$
					}
				}
				if (monitor != null) {
					monitor.worked(1);
				}
			}
		} finally {
			if (monitor != null) {
				monitor.done();
			}
		}
	}

	private static void gatherStatusObjects(DeployModelObject dmo,
			Collection<IDeployStatus> deployStatusList) {
		if (!dmo.getStatus().isOK()) {
			for (Iterator<IDeployStatus> iter2 = new DeployStatusIterator(dmo); iter2.hasNext();) {
				IDeployStatus status = iter2.next();
				if (!(status instanceof IDeployPublishStatus)) {
					deployStatusList.add(status);
				}
			}
		}
	}

	/**
	 * Returns the object identified by the deploy object marker.
	 * 
	 * @param marker
	 *           a deploy object marker (@link #MARKER_ID}.
	 * @param topology
	 *           used to resolve the object ID.
	 * @return the marked object, or null if the object ID is not set, or the topology cannot resolve
	 *         the name.
	 */
	public static DeployModelObject getObject(IMarker marker, Topology topology) {
		assert DeployMarker.isInstance(marker);
		String id = marker.getAttribute(IDeployMarker.OBJECT_ID, null);
		if (id == null || id.length() == 0) {
			return null;
		}
		return topology.resolve(id);
	}

	/**
	 * Returns the object ID of the deploy object marker.
	 * 
	 * @param marker
	 *           a deploy object marker (@link #MARKER_ID}.
	 * @return the {@link #OBJECT_ID}.
	 */
	public static String getObjectID(IMarker marker) {
		assert DeployMarker.isInstance(marker);
		return marker.getAttribute(OBJECT_ID, null);
	}

	/**
	 * Sets the object ID of the deploy object marker.
	 * 
	 * @param marker
	 *           the deploy object marker whose object ID should be set.
	 * @param id
	 *           the ID of the object.
	 * @throws CoreException
	 *            if the marker does not exist.
	 */
	public static void setObjectID(IMarker marker, String id) throws CoreException {
		assert DeployMarker.isInstance(marker);
		marker.setAttribute(OBJECT_ID, id);
	}

	/**
	 * Returns the type of the object of the deploy object marker.
	 * 
	 * @param marker
	 *           a deploy object marker (@link #MARKER_ID}.
	 * @return the type of the object (@link #OBJECT_TYPE}, or null if not set.
	 */
	public static String getObjectTypeName(IMarker marker) {
		assert DeployMarker.isInstance(marker);
		return marker.getAttribute(OBJECT_TYPE, null);
	}

	/**
	 * Sets the object ID of the deploy object marker.
	 * 
	 * @param marker
	 *           the deploy object marker whose object ID should be set.
	 * @param eClass
	 *           the type of the object.
	 * 
	 * @throws CoreException
	 *            if the marker does not exist.
	 */
	public static void setObjectType(IMarker marker, EClass eClass) throws CoreException {
		marker.setAttribute(OBJECT_TYPE, eClass.getName());
	}

	/**
	 * Sets the object ID and type of the deploy object marker.
	 * 
	 * @param marker
	 *           the deploy object marker whose object ID and type should be set.
	 * @param object
	 *           the deploy model object.
	 * @throws CoreException
	 *            if the marker does not exist.
	 */
	public static void setObject(IMarker marker, DeployModelObject object) throws CoreException {
		assert DeployMarker.isInstance(marker);
		assert object != null;
		marker.setAttribute(OBJECT_ID, object.getFullPath());
		marker.setAttribute(OBJECT_TYPE, object.getEObject().eClass().getName());
	}
}
