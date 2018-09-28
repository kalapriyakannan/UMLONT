/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.navigator.deploy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.IPipelinedTreeContentProvider;
import org.eclipse.ui.navigator.PipelinedShapeModification;
import org.eclipse.ui.navigator.PipelinedViewerUpdate;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceElement;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragment;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.core.ui.ModelFilesUpdateManager;
import com.ibm.ccl.soa.deploy.core.util.TopologyNamespaceUtil;

/**
 * @todo add javadoc comments
 */
public class NamespaceElementContentProvider implements IPipelinedTreeContentProvider {

	private static final Object[] NO_OBJECTS = new Object[0];

	protected ModelFilesUpdateManager updateManager;
	private Viewer viewer;

	public void init(ICommonContentExtensionSite aConfig) {
	}

	public Object[] getChildren(Object aParent) {

		//		 we want to support providing the roots of a project. 
		if (aParent instanceof IProject) {
			INamespaceFragmentRoot[] roots = NamespaceCore.locateRoots(((IProject) aParent),
					new NullProgressMonitor());
			List<INamespaceFragmentRoot> existing = new ArrayList<INamespaceFragmentRoot>();
			for (int i = 0; i < roots.length; i++) {
				if (roots[i].getCorrespondingResource().exists()) {
					existing.add(roots[i]);
				}
			}
			return existing.toArray();
			// when the individual roots are sent in as children, the if statement above will handle their children.
		}

		if (aParent instanceof INamespaceElement) {

			HashSet children = new HashSet();

			if (aParent instanceof INamespaceFragmentRoot) {
				children.addAll(Arrays.asList(((INamespaceFragmentRoot) aParent).namespaces()));
			}

			if (aParent instanceof INamespaceFragment) {

				INamespaceFragment fragment = (INamespaceFragment) aParent;
				IResource[] members = fragment.nonTopologyResources();
				children.addAll(Arrays.asList(members));

				if (fragment.containsTopologies()) {
					IFile[] topologies = fragment.topologies();
					if (topologies != null) {
						children.addAll(Arrays.asList(topologies));
					}
				}

			}

			return children.toArray(new Object[children.size()]);
		}

		return NO_OBJECTS;
	}

	public void getPipelinedChildren(Object aParent, Set children) {

		Object parent = aParent;

		if (aParent instanceof IAdaptable) {
			IProject adapted = (IProject) ((IAdaptable) aParent).getAdapter(IProject.class);

			if (adapted != null) {
				parent = adapted;
			}
		}

		if (parent instanceof IContainer) {

			INamespaceFragmentRoot[] roots = NamespaceCore.locateRoots(((IContainer) parent)
					.getProject(), new NullProgressMonitor());

			// case: where parent is a project and is set as a namespace fragment root
			//Makes Children appear as a child of projects rather than namespace root
			for (int i = 0; i < roots.length; i++) {
				if (roots[i].getCorrespondingResource().equals(parent)) {
					children.clear();
					children.addAll(Arrays.asList(getChildren(roots[i])));
					return;
				}
			}

			// case: parent is a project or folder and contains another folder that is a namespace fragment root
			//Hides resources and makes them appear as Namespace Content
			HashSet childRoots = new HashSet();
			for (Iterator iter = children.iterator(); iter.hasNext();) {
				Object obj = iter.next();

				if (!(obj instanceof IResource) && obj instanceof IAdaptable) {
					IResource resource = (IResource) ((IAdaptable) obj).getAdapter(IResource.class);
					if (resource != null) {
						obj = resource;
					}
				}

				if (obj instanceof IResource) {
					if (((IResource) obj).getType() == IResource.FOLDER
							|| ((IResource) obj).getType() == IResource.PROJECT) {
						for (int i = 0; i < roots.length; i++) {
							if (roots[i].getCorrespondingResource().equals(obj)) {
								iter.remove();
								childRoots.add(roots[i]);
							}
						}
					}
				}
			}

			children.addAll(childRoots);
		}
	}

	public Object getParent(Object child) {

		// case: child is a fragment root need to get the parent of it's corresponding resource
		if (child instanceof INamespaceFragmentRoot) {
			INamespaceFragmentRoot root = (INamespaceFragmentRoot) child;
			if (root.getCorrespondingResource() instanceof IProject) {
				return root.getCorrespondingResource();
			}
			return ((INamespaceFragmentRoot) child).getCorrespondingResource().getParent();
		}

		// case: child is a namespace fragment, it's parent will always be it's root
		if (child instanceof INamespaceFragment) {
			return ((INamespaceFragment) child).getRoot();
		}

		// case: child is a file
		if (child instanceof IFile) {
			IContainer container = ((IFile) child).getParent();
			INamespaceFragmentRoot root = NamespaceCore.getRoot(container);

			if (root == null) {
				return container;
			}

			IResource rootResource = root.getCorrespondingResource();

			IPath ns = container.getProjectRelativePath().removeFirstSegments(
					container.getProjectRelativePath().matchingFirstSegments(
							rootResource.getProjectRelativePath()));
			if (ns.segments().length != 0) { //Topology is under a namspace
				INamespaceFragment nsf = root.resolveNamespace(ns.segments());
				if (nsf != null) {
					return nsf;
				}
			} else if (!(container instanceof IProject)) { //Topology is directly under a namespace root
				return root;
			}
		}

		return null;
	}

	public Object getPipelinedParent(Object child, Object parent) {

		// case: parent is a file
		if (child instanceof IFile) {
			IContainer container = ((IFile) child).getParent();
			INamespaceFragmentRoot root = NamespaceCore.getRoot(container);

			if (root == null) {
				return container;
			}

			IResource rootResource = root.getCorrespondingResource();

			IPath ns = container.getProjectRelativePath().removeFirstSegments(
					container.getProjectRelativePath().matchingFirstSegments(
							rootResource.getProjectRelativePath()));
			if (ns.segments().length != 0) { //Topology is under a namspace
				INamespaceFragment nsf = root.resolveNamespace(ns.segments());
				if (nsf != null) {
					return nsf;
				}
			} else if (!(container instanceof IProject)) { //Topology is directly under a namespace root
				return root;
			}
		}
		//topology is directly under project
		return parent;
	}

	public boolean hasChildren(Object parent) {

		if (parent instanceof INamespaceFragment) {
			INamespaceFragment fragment = (INamespaceFragment) parent;
			if (fragment.containsTopologies() || fragment.containsNonTopologyResources()) {
				return true;
			}

			if (fragment instanceof INamespaceFragmentRoot) {
				return ((INamespaceFragmentRoot) fragment).namespaces().length > 0 ? true : false;
			}
		}

		return false;
	}

	public Object[] getElements(Object inputElement) {
		return this.getChildren(inputElement);
	}

	public void getPipelinedElements(Object element, Set elements) {
		getPipelinedChildren(element, elements);
	}

	public void dispose() {
	}

	public void inputChanged(Viewer aViewer, Object oldInput, Object newInput) {
		viewer = aViewer;
		updateManager = ModelFilesUpdateManager.create((AbstractTreeViewer) viewer);
	}

	/**
	 * {@inheritDoc}
	 */
	public PipelinedShapeModification interceptAdd(PipelinedShapeModification modification) {

		Object element = modification.getParent();
		if (element instanceof IResource) {
			IResource resource = (IResource) element;
			if (resource.getType() == IResource.FOLDER) {
				INamespaceFragmentRoot[] roots = NamespaceCore.locateRoots(resource.getProject(), null);
				for (int r = 0; r < roots.length; r++) {
					INamespaceFragmentRoot root = roots[r];
					if (root.getCorrespondingResource().getProjectRelativePath().isPrefixOf(
							resource.getProjectRelativePath())) {
						IPath path = resource.getProjectRelativePath().removeFirstSegments(
								root.getCorrespondingResource().getProjectRelativePath().segmentCount());
						INamespaceFragment namespace = root.getNamespaceFragment(TopologyNamespaceUtil
								.concatWith(path.segments(), TopologyNamespaceUtil.C_DOT));
						modification.setParent(namespace);
					}
				}
			}
		}
		return modification;
	}

	/**
	 * {@inheritDoc}
	 */
	public PipelinedShapeModification interceptRemove(PipelinedShapeModification modification) {
		Object element = modification.getParent();
		if (element instanceof IResource) {
			IResource resource = (IResource) element;
			if (resource.getType() == IResource.FOLDER) {
				INamespaceFragmentRoot[] roots = NamespaceCore.locateRoots(resource.getProject(), null);
				for (int r = 0; r < roots.length; r++) {
					INamespaceFragmentRoot root = roots[r];
					if (root.getCorrespondingResource().getProjectRelativePath().isPrefixOf(
							resource.getProjectRelativePath())) {
						IPath path = resource.getProjectRelativePath().removeFirstSegments(
								root.getCorrespondingResource().getProjectRelativePath().segmentCount());
						INamespaceFragment namespace = root.getNamespaceFragment(TopologyNamespaceUtil
								.concatWith(path.segments(), TopologyNamespaceUtil.C_DOT));
						modification.setParent(namespace);
					}
				}
			}
		}
		return modification;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean interceptRefresh(PipelinedViewerUpdate update) {
		boolean modified = convertToNamespaceElements(update.getRefreshTargets());
		for (Iterator iter = update.getRefreshTargets().iterator(); iter.hasNext();) {
			updateManager.enqueue(iter.next());
		}
		return modified;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean interceptUpdate(PipelinedViewerUpdate update) {
		boolean modified = convertToNamespaceElements(update.getRefreshTargets());
//		for (Iterator iter = update.getRefreshTargets().iterator(); iter.hasNext();) {
//			Object next = iter.next();
//			if (next instanceof IResource) {
//				updateManager.enqueue(((IResource) next).getParent());
//			}
//		}
		return modified;
	}

	public void saveState(IMemento aMemento) {
	}

	public void restoreState(IMemento aMemento) {
	}

	private boolean convertToNamespaceElements(Set targets) {

		boolean modified = false;
		Set replacements = new HashSet();
		for (Iterator iter = targets.iterator(); iter.hasNext();) {
			Object target = iter.next();
			if (target instanceof IResource) {
				IResource resource = (IResource) target;
				if (resource.getType() == IResource.FOLDER) {
					INamespaceFragmentRoot[] roots = NamespaceCore.locateRoots(resource.getProject(),
							null);
					for (int r = 0; r < roots.length; r++) {
						INamespaceFragmentRoot root = roots[r];
						if (root.getCorrespondingResource().getProjectRelativePath().isPrefixOf(
								resource.getProjectRelativePath())) {
							IPath path = resource.getProjectRelativePath().removeFirstSegments(
									root.getCorrespondingResource().getProjectRelativePath().segmentCount());
							INamespaceFragment namespace = root.getNamespaceFragment(TopologyNamespaceUtil
									.concatWith(path.segments(), TopologyNamespaceUtil.C_DOT));
							replacements.add(namespace);
							iter.remove();
							modified = true;
						}
					}
				} else if (resource.getType() == IResource.FILE) {
					IFile file = (IFile) resource;
					if (IConstants.TOPOLOGYV_EXTENSION.equals(file.getFileExtension())) {
						TopologyDiagramNode diagramNode = new TopologyDiagramNode(file);
						replacements.add(diagramNode);
						modified = true;
					}
				}
			}
		}

		targets.addAll(replacements);
		return modified;
	}
}
