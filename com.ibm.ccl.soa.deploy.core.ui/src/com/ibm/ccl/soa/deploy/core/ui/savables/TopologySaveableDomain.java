package com.ibm.ccl.soa.deploy.core.ui.savables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IResource;

import com.ibm.ccl.soa.infrastructure.emf.DefaultScribblerDomain;
import com.ibm.ccl.soa.infrastructure.emf.EclipseResourceDescriptor;
import com.ibm.ccl.soa.infrastructure.emf.IResourceDescriptor;
import com.ibm.ccl.soa.infrastructure.emf.IScribblerDomain;

/**
 * <p>
 * Implementation of IScribblerDomain that registers it's interest in a single file passed in during
 * construction.
 * </p>
 * 
 * @author Tim Pouyer <tpouyer@us.ibm.com>
 * @since 7.0
 * 
 */
public class TopologySaveableDomain extends DefaultScribblerDomain implements IScribblerDomain {

	private String label = new String();
	private final List<IResource> resources = Collections
			.synchronizedList(new ArrayList<IResource>());
	private final List<IResourceDescriptor> descriptors = Collections
			.synchronizedList(new ArrayList<IResourceDescriptor>());

	public TopologySaveableDomain(IResource resource) {
		this(Arrays.asList(new IResource[] { resource }));
	}

	public TopologySaveableDomain(List<IResource> resources) {
		this(resources.get(0).getProject().getName() + ".saveables", resources); //$NON-NLS-1$
	}

	public TopologySaveableDomain(String label, List<IResource> resources) {
		assert null != resources;

		this.label = label;
		for (Iterator<IResource> iter = resources.iterator(); iter.hasNext();) {
			addResource(iter.next());
		}
	}

	public void addResource(IResource resource) {
		assert null != resource;

		if (!resources.contains(resource)) {
			resources.add(resource);
			descriptors.add(new EclipseResourceDescriptor(resource.getProjectRelativePath(), resource
					.getFullPath()));
		}
	}

	public void removeResource(IResource resource) {
		assert null != resource;

		if (resources.contains(resource)) {
			resources.remove(resource);
			EclipseResourceDescriptor descriptor = new EclipseResourceDescriptor(resource
					.getProjectRelativePath(), resource.getFullPath());
			descriptors.remove(descriptor);
		}
	}

	public String getEditModelLabel() {
		return label;
	}

	public IResourceDescriptor[] getResourceDescriptors() {
		return descriptors.toArray(new IResourceDescriptor[descriptors.size()]);
	}

	public IResource[] getResources() {
		return resources.toArray(new IResource[resources.size()]);
	}

	public boolean isContained(IResource resource) {
		if (resources.contains(resource)) {
			return true;
		}

		return false;
	}

}
