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
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.fieldassist.IContentProposal;

import com.ibm.ccl.soa.deploy.core.Topology;

/**
 * An instance of an {@link IContentProposal} that wraps an {@link IFolder} that represents a
 * namespace for a {@link Topology}.
 * 
 */
public class SourceFolderContentProposal extends Object implements IContentProposal {

	private IContainer container;
	private IPath filterPath;

	/**
	 * 
	 * @param container -
	 *           An {@link IContainer} respresenting a proposed source folder.
	 * @param filterPath -
	 *           An {@link IPath} representing filter for the proposals.
	 */
	public SourceFolderContentProposal(IContainer container, IPath filterPath) {
		this.container = container;
		this.filterPath = filterPath;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.fieldassist.IContentProposal#getContent()
	 */
	public String getContent() {
		return container.getFullPath().makeRelative().toString();
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
	 * @return A {@link IContainer}.
	 */
	public IContainer getContainer() {
		return this.container;
	}

	/**
	 * 
	 * @return An {@link IPath} used for filtering.
	 */
	public IPath getFilterPath() {
		return this.filterPath;
	}

}
