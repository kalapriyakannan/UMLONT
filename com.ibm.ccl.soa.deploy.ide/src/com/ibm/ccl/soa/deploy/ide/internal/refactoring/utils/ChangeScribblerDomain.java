package com.ibm.ccl.soa.deploy.ide.internal.refactoring.utils;

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

public class ChangeScribblerDomain extends DefaultScribblerDomain implements IScribblerDomain {

	private String label = new String();
	private final List<IResource> resources = Collections
			.synchronizedList(new ArrayList<IResource>());
	private final List<IResourceDescriptor> descriptors = Collections
			.synchronizedList(new ArrayList<IResourceDescriptor>());

	public ChangeScribblerDomain(IResource resource) {
		this(Arrays.asList(new IResource[] { resource }));
	}

	public ChangeScribblerDomain(List<IResource> resources) {
		this(resources.get(0).getProject().getName() + ".changeScribbler", resources); //$NON-NLS-1$
	}

	public ChangeScribblerDomain(String label, List<IResource> resources) {
		assert null != resources;

		this.label = label;
		for (Iterator<IResource> iter = resources.iterator(); iter.hasNext();) {
			addResource(iter.next());
		}
	}

	public void addResource(IResource resource) {
		assert null != resource;

		resources.add(resource);
		descriptors.add(new EclipseResourceDescriptor(resource.getProjectRelativePath(), resource
				.getFullPath()));
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

}
