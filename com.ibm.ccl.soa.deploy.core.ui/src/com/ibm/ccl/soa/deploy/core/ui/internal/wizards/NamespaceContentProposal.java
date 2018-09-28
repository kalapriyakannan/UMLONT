/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.wizards;

import org.eclipse.core.resources.IFolder;
import org.eclipse.jface.fieldassist.IContentProposal;

import com.ibm.ccl.soa.deploy.core.Topology;

/**
 * An instance of an {@link IContentProposal} that wraps an {@link IFolder} that represents a
 * namespace for a {@link Topology}.
 * 
 */
public class NamespaceContentProposal extends Object implements IContentProposal {

	private IFolder folder;
	private int sourceFolderSegmentCount;

	/**
	 * 
	 * @param folder -
	 *           An {@link IFolder} respresenting a proposed namespace.
	 * @param sourceFolderSegmentCount -
	 *           An int representing the number of segments in the folder's fullPath that are part of
	 *           the source folder.
	 */
	public NamespaceContentProposal(IFolder folder, int sourceFolderSegmentCount) {
		this.folder = folder;
		this.sourceFolderSegmentCount = sourceFolderSegmentCount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.fieldassist.IContentProposal#getContent()
	 */
	public String getContent() {
		return NamespaceLabelProvider.getQualifiedName(folder, sourceFolderSegmentCount);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.fieldassist.IContentProposal#getCursorPosition()
	 */
	public int getCursorPosition() {
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.fieldassist.IContentProposal#getDescription()
	 */
	public String getDescription() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.fieldassist.IContentProposal#getLabel()
	 */
	public String getLabel() {
		return null;
	}

	/**
	 * 
	 * @return A {@link IFolder}.
	 */
	public IFolder getFolder() {
		return this.folder;
	}

}
