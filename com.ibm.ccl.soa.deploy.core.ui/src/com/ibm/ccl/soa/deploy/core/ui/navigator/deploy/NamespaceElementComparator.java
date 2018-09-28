package com.ibm.ccl.soa.deploy.core.ui.navigator.deploy;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.ContentViewer;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.ui.model.IWorkbenchAdapter;

import com.ibm.ccl.soa.deploy.core.namespace.INamespaceElement;

public class NamespaceElementComparator extends ViewerComparator {

	private static final int PROJECTS = 1;
	private static final int NAMESPACEFRAGMENTROOTS = 2;
	private static final int NAMESPACEFRAGMENT = 3;

	private static final int RESOURCEFOLDERS = 4;
	private static final int RESOURCES = 5;

	private static final int OTHERS = 51;

	/**
	 * Constructor.
	 */
	public NamespaceElementComparator() {
		super(null); // delay initialization of collator
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ViewerComparator#category(java.lang.Object)
	 */
	public int category(Object element) {
		if (element instanceof INamespaceElement) {
			INamespaceElement ne = (INamespaceElement) element;

			switch (ne.getType())
			{
			case INamespaceElement.TOPOLOGY_NAMESPACE:
				return NAMESPACEFRAGMENT;
			case INamespaceElement.TOPOLOGY_NAMESPACE_ROOT:
				return NAMESPACEFRAGMENTROOTS;
			}
		} else if (element instanceof IFile) {
			return RESOURCES;
		} else if (element instanceof IProject) {
			return PROJECTS;
		} else if (element instanceof IContainer) {
			return RESOURCEFOLDERS;
		}
		return OTHERS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ViewerComparator#compare(org.eclipse.jface.viewers.Viewer,
	 *      java.lang.Object, java.lang.Object)
	 */
	public int compare(Viewer viewer, Object e1, Object e2) {
		int cat1 = category(e1);
		int cat2 = category(e2);

		if (cat1 != cat2) {
			return cat1 - cat2;
		}

		if (cat1 == PROJECTS || cat1 == RESOURCES || cat1 == RESOURCEFOLDERS || cat1 == OTHERS) {
			String name1 = getNonNamespaceElementLabel(viewer, e1);
			String name2 = getNonNamespaceElementLabel(viewer, e2);
			if (name1 != null && name2 != null) {
				return getComparator().compare(name1, name2);
			}
			return 0; // can't compare
		}

		String name1 = getElementName(e1);
		String name2 = getElementName(e2);

		int cmp = getComparator().compare(name1, name2);
		if (cmp != 0) {
			return cmp;
		}

		return 0;
	}

	private String getNonNamespaceElementLabel(Viewer viewer, Object element) {
		// try to use the workbench adapter for non - namespace resources or if not available, use the viewers label provider
		if (element instanceof IResource) {
			return ((IResource) element).getName();
		}
		if (element instanceof IStorage) {
			return ((IStorage) element).getName();
		}
		if (element instanceof IAdaptable) {
			IWorkbenchAdapter adapter = (IWorkbenchAdapter) ((IAdaptable) element)
					.getAdapter(IWorkbenchAdapter.class);
			if (adapter != null) {
				return adapter.getLabel(element);
			}
		}
		if (viewer instanceof ContentViewer) {
			IBaseLabelProvider prov = ((ContentViewer) viewer).getLabelProvider();
			if (prov instanceof ILabelProvider) {
				return ((ILabelProvider) prov).getText(element);
			}
		}
		return null;
	}

	private String getElementName(Object element) {
		if (element instanceof INamespaceElement) {
			return ((INamespaceElement) element).getQualifiedName();
		} else {
			return element.toString();
		}
	}
}
