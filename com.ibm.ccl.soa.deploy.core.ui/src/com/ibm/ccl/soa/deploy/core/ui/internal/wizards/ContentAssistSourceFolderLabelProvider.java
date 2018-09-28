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
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.fieldassist.ContentAssistField;
import org.eclipse.ui.model.WorkbenchLabelProvider;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.datamodels.CreateTopologyDataModel;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;

/**
 * This {@link ILabelProvider} is a specialization of a {@link DecoratingLabelProvider} for use with
 * {@link ContentAssistField}s displaying the source folders of a {@link Topology}. This
 * specialization is necessary since the element passed to get the text and image is not an
 * {@link IFolder}. Instead it is a {@link SourceFolderContentProposal}. From the
 * {@link SourceFolderContentProposal} we can get the wrapped {@link IContainer} and delegate to a
 * {@link DecoratingLabelProvider}.
 * 
 */
public class ContentAssistSourceFolderLabelProvider implements ILabelProvider {
	private CreateTopologyDataModel dataModel;
	private DecoratingLabelProvider decoratingLabelProvider;

	/**
	 */
	public ContentAssistSourceFolderLabelProvider() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.ui.internal.wizards.NamespaceLabelProvider#getText(java.lang.Object)
	 */
	public String getText(Object element) {
		SourceFolderContentProposal proposal = (SourceFolderContentProposal) element;
		IPath filter = proposal.getFilterPath();
		if (filter == null || filter.segmentCount() == 0) {
			//No filtering used.
			return proposal.getContainer().getFullPath().makeRelative().toString();
		}
		//Trim the matches segments from the path based on the filter.
		IPath containerPath = proposal.getContainer().getFullPath();
		int matchingSegments = containerPath.matchingFirstSegments(filter);
		if (matchingSegments > 0) {
			if (matchingSegments == filter.segmentCount()) {
				//Exact match.  Just show last segment.
				return containerPath.lastSegment();
			}
			return containerPath.removeFirstSegments(matchingSegments).toString();
		}
		return containerPath.makeRelative().toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.ui.internal.wizards.NamespaceLabelProvider#getImage(java.lang.Object)
	 */
	public Image getImage(Object element) {
		IContainer container = ((SourceFolderContentProposal) element).getContainer();
		if (container.getType() != IResource.PROJECT) {
			INamespaceFragmentRoot root = NamespaceCore.getRoot(container);
			if (root != null) {
				return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
						ISharedImages.IMG_TOPOLOGY_NAMESPACE_ROOT);
			}
		}
		return getDecoratoringLabelProvider().getImage(container);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.ui.internal.wizards.NamespaceLabelProvider#dispose()
	 */
	public void dispose() {
		getDecoratoringLabelProvider().dispose();
	}

	private DecoratingLabelProvider getDecoratoringLabelProvider() {
		if (decoratingLabelProvider == null) {
			decoratingLabelProvider = new DecoratingLabelProvider(new WorkbenchLabelProvider(),
					DeployCoreUIPlugin.getDefault().getWorkbench().getDecoratorManager()
							.getLabelDecorator());
		}
		return decoratingLabelProvider;
	}

	public void addListener(ILabelProviderListener listener) {
	}

	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
	}

}
