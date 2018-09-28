package com.ibm.ccl.soa.deploy.core.ui.savables;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.Resource;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.infrastructure.emf.DefaultScribblerDomain;
import com.ibm.ccl.soa.infrastructure.emf.IResourceDescriptor;
import com.ibm.ccl.soa.infrastructure.emf.ITechnologyFlavorLifecycle;

/**
 * <p>
 * Implementation of an IScribblerDomain that registers it's interest in only topology artifacts. (
 * *.topology and *.topologv files )
 * </p>
 * 
 * @author Tim Pouyer <tpouyer@us.ibm.com>
 * @since 7.0
 * 
 */
public class TopologyArtifactsDomain extends DefaultScribblerDomain {

	/**
	 * A generated EditModel label
	 * 
	 * @param project
	 *           The relevant project
	 * @return A generated EditModel label
	 */
	public static final String generateEditModelLable(IProject project) {
		return project.getName() + ".readonly"; //$NON-NLS-1$
	}

	private final IProject project;

	/**
	 * <p>
	 * Creates a new instance of TopologyArtifactsDomain with the given IProject.
	 * </p>
	 * 
	 * @param aProject
	 *           the IProject for this instance of TopologyArtifactsDomain.
	 */
	public TopologyArtifactsDomain(IProject aProject) {
		project = aProject;
	}

	/**
	 * {@inheritDoc}
	 */
	public void addTechnologyFlavorLifecycle(ITechnologyFlavorLifecycle flavorManager) {
	}

	/**
	 * {@inheritDoc}
	 */
	public String getEditModelLabel() {
		return generateEditModelLable(project);
	}

	/**
	 * {@inheritDoc}
	 */
	public IResourceDescriptor[] getResourceDescriptors() {
		return new IResourceDescriptor[0];
	}

	/**
	 * {@inheritDoc}
	 */
	public ITechnologyFlavorLifecycle getTechnologyFlavorLifecycle(String technologyFlavorId) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public ITechnologyFlavorLifecycle[] getTechnologyFlavorLifecycles() {
		return new ITechnologyFlavorLifecycle[0];
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isContained(IResourceDescriptor aResourceDescriptor) {
		String extension = aResourceDescriptor.getLocalPath().getFileExtension();
		if (IConstants.TOPOLOGY_EXTENSION.equals(extension)
				|| IConstants.TOPOLOGYV_EXTENSION.equals(extension)) {
			return true;
		}

		return false;
	}

	/**
	 * <p>
	 * Determines if the passed in resource is one of a topology model file ( *.topology ) or
	 * topology diagram file ( *.topologyv ).
	 * </p>
	 * 
	 * @param aResource
	 *           the resource to determine if it is contained.
	 */
	public boolean isContained(Resource aResource) {
		String extension = aResource.getURI().fileExtension();
		if (IConstants.TOPOLOGY_EXTENSION.equals(extension)
				|| IConstants.TOPOLOGYV_EXTENSION.equals(extension)) {
			return true;
		}

		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getLabel() {
		return getEditModelLabel();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean matches(IUndoContext context) {
		return false;
	}

	@Override
	public boolean isAutoManaged(Resource resource) {
		return !isContained(resource);
	}
}
