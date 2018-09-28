/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.navigator.deploy;

import org.eclipse.gmf.runtime.common.ui.services.dnd.core.AbstractDragDropListenerProvider;
import org.eclipse.gmf.runtime.common.ui.services.dnd.core.IDragListenerContext;
import org.eclipse.gmf.runtime.common.ui.services.dnd.core.IDropListenerContext;
import org.eclipse.gmf.runtime.common.ui.services.dnd.drag.IDragSourceListener;
import org.eclipse.gmf.runtime.common.ui.services.dnd.drop.IDropTargetListener;

/**
 * Concrete class that implements the <code>IDragDropListenerProvider</code>.
 * 
 * @author Vishy Ramaswamy
 */
public final class DragDropListenerProvider extends AbstractDragDropListenerProvider {
	/**
	 * Attribute for the listeners
	 */
	private IDragSourceListener[] dragSourceListeners = new IDragSourceListener[] { DragSourceListener
			.getInstance() };
	private IDropTargetListener[] dropTargetListeners = new IDropTargetListener[] { DropTargetListener
			.getInstance() };

	/**
	 * Constructor for DragDropListenerProvider.
	 */
	public DragDropListenerProvider() {
		super();
	}

	/*
	 * @see com.ibm.xtools.common.ui.services.internal.dnd.IDragDropListenerProvider#getDragSourceListeners(com.ibm.xtools.common.ui.services.internal.dnd.IDragListenerContext)
	 */
	public IDragSourceListener[] getDragSourceListeners(IDragListenerContext context) {
		return dragSourceListeners;
	}

	/*
	 * @see com.ibm.xtools.common.ui.services.internal.dnd.IDragDropListenerProvider#getDropTargetListeners(com.ibm.xtools.common.ui.services.internal.dnd.IDropListenerContext)
	 */
	public IDropTargetListener[] getDropTargetListeners(IDropListenerContext context) {
		return dropTargetListeners;
	}
}
