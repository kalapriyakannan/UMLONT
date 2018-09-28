/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.wizards;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.ui.ISharedImages;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Topology;

/**
 * An {@link ILabelProvider} for displaying namespaces of a {@link Topology} which are represented
 * as {@link IFolder}s.
 */
class NamespaceLabelProvider implements ILabelProvider {
	private int sourceContainerSegmentCount = 0;

	/**
	 * 
	 * @param aSourceContainer -
	 *           The source {@link IContainer} for the namespaces.
	 */
	public NamespaceLabelProvider(IContainer aSourceContainer) {
		setSourceContainer(aSourceContainer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
	 */
	public Image getImage(Object element) {
		IContainer container = (IContainer) element;
		String imageKey;
		if (hasFiles(container)) {
			imageKey = ISharedImages.IMG_OBJS_LOGICAL_PACKAGE;
		} else {
			imageKey = ISharedImages.IMG_OBJS_EMPTY_PACKAGE;
		}
		return JavaUI.getSharedImages().getImage(imageKey);
	}

	/**
	 * 
	 * @param container -
	 *           An {@link IContainer}.
	 * @return - true if the passed container has any {@link IFile}s.
	 */
	public static boolean hasFiles(IContainer container) {
		try {
			IResource[] members = container.members();
			if (members.length > 0) {
				for (int i = 0; i < members.length; i++) {
					if (members[i].getType() == IResource.FILE) {
						return true;
					}
				}
			}
		} catch (CoreException e) {
			//Fail gracefully.
		}
		return false;
	}

	public String getText(Object element) {
		return getQualifiedName((IContainer) element, sourceContainerSegmentCount);
	}

	/**
	 * 
	 * @param container -
	 *           An {@link IContainer} that is a namespace.
	 * @param sourceFolderSegments -
	 *           The number of segments representing the source folder.
	 * @return A qualified namespace name for the passed container.
	 */
	public static String getQualifiedName(IContainer container, int sourceFolderSegments) {
		IPath containerPath = container.getFullPath();
		containerPath = containerPath.removeFirstSegments(sourceFolderSegments);
		if (containerPath.segmentCount() > 0) {
			if (containerPath.segmentCount() == 1) {
				return containerPath.segment(0);
			}
			String[] segments = containerPath.segments();
			StringBuffer buffer = new StringBuffer();
			for (int i = 0; i < segments.length; i++) {
				if (i > 0) {
					buffer.append('.');
				}
				buffer.append(segments[i]);
			}
			return buffer.toString();
		}
		return IConstants.EMPTY_STRING;
	}

	public void addListener(ILabelProviderListener listener) {
	}

	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
	}

	public void setSourceContainer(IContainer container) {
		if (container != null) {
			this.sourceContainerSegmentCount = container.getFullPath().segmentCount();
		} else {
			this.sourceContainerSegmentCount = 0;
		}
	}

	public void dispose() {
	}
}
