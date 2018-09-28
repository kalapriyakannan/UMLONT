package com.ibm.ccl.soa.deploy.core.ui.internal.search.scopes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.MultiRule;

public class Scope {

	protected static final Collection<IContentType> EMPTY_TYPES_COLLECTION = new ArrayList<IContentType>(
			0);
	protected static final Collection<IResource> EMPTY_RESOURCES_COLLECTION = new ArrayList<IResource>(
			0);

	private final Collection<IContentType> types;
	private final Collection<IResource> resources;
	private final boolean includeUnloadedResources;
	private final boolean includeDeployedResources;

	protected Scope(Collection<IContentType> types, Collection<IResource> resources,
			boolean includeUnloadedResources, boolean includeDeployedResources) {
		this.types = types;
		this.resources = resources;
		this.includeUnloadedResources = includeUnloadedResources;
		this.includeDeployedResources = includeDeployedResources;
	}

	public Collection<IContentType> getContentTypes() {
		return types;
	}

	public Collection<IResource> getResources() {
		return resources;
	}

	public boolean includeUnloadedResources() {
		return includeUnloadedResources;
	}

	public boolean includeDeployedResources() {
		return includeDeployedResources;
	}

	public ISchedulingRule getSchedulingRule() {
		if (null == resources || resources.size() == 0) {
			return ResourcesPlugin.getWorkspace().getRoot();
		}

		return new MultiRule(resources.toArray(new ISchedulingRule[resources.size()]));
	}

	public static Scope getDocumentScope(IFile document) {
		return getResourceScope(EMPTY_TYPES_COLLECTION, document, true, false);
	}

	public static Scope getProjectScope(IProject project, boolean includeUnloadedResources) {
		return getProjectScope(EMPTY_TYPES_COLLECTION, project, includeUnloadedResources);
	}

	public static Scope getProjectScope(Collection<IContentType> types, IProject project,
			boolean includeUnloadedResources) {
		return getResourceScope(types, project, includeUnloadedResources, false);
	}

	public static Scope getWorkspaceScope(boolean includeUnloadedResources,
			boolean includeDeployedResources) {
		return getWorkspaceScope(EMPTY_TYPES_COLLECTION, includeUnloadedResources,
				includeDeployedResources);
	}

	public static Scope getWorkspaceScope(Collection<IContentType> types,
			boolean includeUnloadedResources, boolean includeDeployedResources) {
		return getResourceScope(types, ResourcesPlugin.getWorkspace().getRoot(),
				includeUnloadedResources, includeDeployedResources);
	}

	public static Scope getResourcesScope(Collection<IResource> resources,
			boolean includeUnloadedResources, boolean includeDeployedResources) {
		return new Scope(EMPTY_TYPES_COLLECTION, resources, includeUnloadedResources,
				includeDeployedResources);
	}

	private static Scope getResourceScope(Collection<IContentType> types, IResource resource,
			boolean includeUnloadedResources, boolean includeDeployedResources) {
		return new Scope(types, Arrays.asList(new IResource[] { resource }),
				includeUnloadedResources, includeDeployedResources);
	}
}
