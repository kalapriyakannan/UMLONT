/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core;

import java.util.Arrays;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.ibm.ccl.soa.deploy.core.locationbinding.LocationBindingService;
import com.ibm.ccl.soa.infrastructure.emf.DefaultScribblerDomain;
import com.ibm.ccl.soa.infrastructure.emf.EclipseResourceDescriptor;
import com.ibm.ccl.soa.infrastructure.emf.EditModelException;
import com.ibm.ccl.soa.infrastructure.emf.IEditModel;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelFactory;
import com.ibm.ccl.soa.infrastructure.emf.IEditModelScribbler;
import com.ibm.ccl.soa.infrastructure.emf.IResourceDescriptor;
import com.ibm.ccl.soa.infrastructure.emf.IScribblerDomain;

/**
 * Defines a logical set of resources that are treated as one unit of work.
 * 
 */
public class DeploymentTopologyDomain extends DefaultScribblerDomain implements IScribblerDomain {

	private static final String TOPOLOGY_EXTENSION = "." + IConstants.TOPOLOGY_EXTENSION; //$NON-NLS-1$

	/**
	 * A constant to describe cases where no known diagram is available.
	 */
	private static final IFile[] NO_KNOWN_DIAGRAMS = new IFile[0];

	private IResourceDescriptor[] descriptors;

	private final EclipseResourceDescriptor topologyDescriptor;

	private EclipseResourceDescriptor locbindingRD;

	private final IFile[] openedDiagrams;

	private final IFile topologyFile;
	private IFile locbindingFile;

	/**
	 * Return the name of the model file. This is a handle only method and does not address cases
	 * where the internal name of the model does not match the file name.
	 * 
	 * @param modelFile
	 *           An IFile for the model file.
	 * @return A label for the Topology file.
	 */
	public static String getTopologyName(IFile modelFile) {
		int extLoc = modelFile.getName().indexOf(TOPOLOGY_EXTENSION);
		if (extLoc >= 0) {
			return modelFile.getName().substring(0, extLoc);
		}
		return modelFile.getName(); // Unknown extension; leave it on
	}

	/**
	 * Generate the {@link IEditModel} namespace associated with this group of resources.
	 * 
	 * @param modelFile
	 * @return A label used to identify a logically equivalent set of resources.
	 */
	public static String generateEditModelLabel(IFile modelFile) {
		return modelFile.getFullPath().toString();
	}

	/**
	 * Creates an {@link IScribblerDomain} that knows about a model with the given name in the given
	 * folder.
	 * 
	 * @param folder
	 *           The container for the {@link Topology}.
	 * @param topologyName
	 *           The name of the [@link {@link Topology}.
	 */
	public DeploymentTopologyDomain(IFolder folder, String topologyName) {
		this(folder.getFile(new Path(topologyName + TOPOLOGY_EXTENSION)), NO_KNOWN_DIAGRAMS);
	}

	/**
	 * Create an {@link IScribblerDomain} that knows about the given model file. When used, calls to
	 * {@link #getDefaultDiagramFile()} will use a standard pattern of "<topology-name>.topologyv"
	 * in the same folder as the model file.
	 * 
	 * @param theTopologyFile
	 *           The model file to be loaded.
	 */
	public DeploymentTopologyDomain(IFile theTopologyFile) {
		this(theTopologyFile, NO_KNOWN_DIAGRAMS);
	}

	/**
	 * Create an {@link IScribblerDomain} that knows about the given model file and the particular
	 * diagram to focus on.
	 * 
	 * @param theTopologyFile
	 *           The model file to be loaded.
	 * @param theDiagramFile
	 *           The particular diagram to focus on.
	 */
	public DeploymentTopologyDomain(IFile theTopologyFile, IFile theDiagramFile) {
		this(theTopologyFile, new IFile[] { theDiagramFile });
	}

	/**
	 * Create an {@link IScribblerDomain} that knows about the given model file and the array of
	 * diagrams. The array of diagrams does not need to be complete.
	 * 
	 * @param theTopologyFile
	 *           The model file to be loaded.
	 * @param theDiagramFiles
	 *           The array of diagrams; does not need to be complete.
	 */
	public DeploymentTopologyDomain(IFile theTopologyFile, IFile[] theDiagramFiles) {
		topologyFile = theTopologyFile;
		topologyDescriptor = new EclipseResourceDescriptor(topologyFile);
		openedDiagrams = theDiagramFiles;

		if (getLocationInUse()) {
			locbindingFile = LocationBindingService.INSTANCE.resolveBindingFile(topologyFile);
			locbindingRD = new EclipseResourceDescriptor(locbindingFile);
		}
	}

	/**
	 * Create an {@link IEditModelScribbler} for write purposes using this domain.
	 * 
	 * @return an {@link IEditModelScribbler} for write purposes using this domain.
	 * @throws EditModelException
	 *            If a problem occurs while trying to initialize the {@link IEditModelScribbler}
	 */
	public IEditModelScribbler createScribblerForWrite() throws EditModelException {
		return IEditModelFactory.eINSTANCE.createScribblerForWrite(getProject(), this);
	}

	/**
	 * Create an {@link IEditModelScribbler} for read-only purposes using this domain.
	 * 
	 * @return an {@link IEditModelScribbler} for read-only purposes using this domain.
	 * @throws EditModelException
	 *            If a problem occurs while trying to initialize the {@link IEditModelScribbler}
	 */
	public IEditModelScribbler createScribblerForRead() throws EditModelException {
		return IEditModelFactory.eINSTANCE.createScribblerForRead(getProject(), this);
	}

	/**
	 * Return the project that contains the {@link Topology} model tracked by this
	 * {@link DeploymentTopologyDomain}.
	 * 
	 * @return The project that contains the {@link Topology} model tracked by this
	 *         {@link DeploymentTopologyDomain}.
	 */
	public IProject getProject() {
		return topologyFile.getProject();
	}

	public IResourceDescriptor[] getResourceDescriptors() {
		if (descriptors == null) {
			if (getLocationInUse()) {
				descriptors = new IResourceDescriptor[] { topologyDescriptor, locbindingRD };
			} else {
				descriptors = new IResourceDescriptor[] { topologyDescriptor };
			}
		}
		return descriptors;
	}

	public String getLabel() {
		return getTopologyName(topologyFile);
	}

	/**
	 * Return the resource descriptor associated with the model file.
	 * 
	 * @see #getTopologyFile()
	 * @return The resource descriptor associated with the model file.
	 */
	public IResourceDescriptor getTopologyResource() {
		return topologyDescriptor;
	}

	/**
	 * Return the resource descriptor associated with the location binding file.
	 * 
	 * @see #getLocationFile()
	 * @return The resource descriptor associated with the location binding file.
	 */
	public IResourceDescriptor getLocBindingResource() {
		return locbindingRD;
	}

	/**
	 * The {@link IFile} of the interesting model file.
	 * 
	 * @return The {@link IFile} of the interesting model file.
	 */
	public IFile getTopologyFile() {
		return topologyFile;
	}

	/**
	 * An IFile describing the default diagram file. The default diagram is defined as the first
	 * diagram supplied to the domain or <topology-name>.topologyv if none was supplied to the
	 * domain.
	 * 
	 * @return An IFile describing the default diagram file.
	 */
	public IFile getDefaultDiagramFile() {
		if (openedDiagrams.length == 0) {
			IContainer container = topologyFile.getParent();

			IPath diagramFile = new Path(getTopologyName(topologyFile)
					+ IConstants.TOPOLOGYV_EXTENSION);
			return container.getFile(diagramFile);
		}
		return openedDiagrams[0];
	}

	/**
	 * An IFile describing the location binding file.
	 * 
	 * @return An IFile describing the location binding file.
	 */
	public IFile getLocationFile() {
		return locbindingFile;
	}

	public String getEditModelLabel() {
		return getTopologyFile().getFullPath().toString();
	}

	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + DeploymentTopologyDomain.hashCode(descriptors);
		result = PRIME * result + (topologyDescriptor == null ? 0 : topologyDescriptor.hashCode());
		result = PRIME * result + (locbindingRD == null ? 0 : locbindingRD.hashCode());
		return result;
	}

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
		final DeploymentTopologyDomain other = (DeploymentTopologyDomain) obj;
		if (!Arrays.equals(descriptors, other.descriptors)) {
			return false;
		}
		if (topologyDescriptor == null) {
			if (other.topologyDescriptor != null) {
				return false;
			}
		} else if (!topologyDescriptor.equals(other.topologyDescriptor)) {
			return false;
		}
		if (locbindingRD == null) {
			if (other.locbindingRD != null) {
				return false;
			}
		} else if (!locbindingRD.equals(other.locbindingRD)) {
			return false;
		}
		return true;
	}

	private static int hashCode(Object[] array) {
		final int PRIME = 31;
		if (array == null) {
			return 0;
		}
		int result = 1;
		for (int index = 0; index < array.length; index++) {
			result = PRIME * result + (array[index] == null ? 0 : array[index].hashCode());
		}
		return result;
	}

	private boolean getLocationInUse() {
		return LocationBindingService.INSTANCE.isLocationBindingUsage(getTopologyFile());
	}

}
