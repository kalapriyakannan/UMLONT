/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.navigator.deploy;

import org.eclipse.gmf.runtime.common.ui.services.dnd.drag.AbstractDragSourceListener;
import org.eclipse.gmf.runtime.common.ui.services.dnd.ide.core.IDETransferId;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.DragSourceEvent;

//import com.ibm.ccl.soa.deploy.core.ui.navigator.existing.ServerExplorer;
//import com.ibm.ccl.soa.deploy.core.ui.navigator.existing.ServerItemProvider;

/**
 * Concrete class that implements the IDragSourceListener. This class handles dragging of tree
 * elements from the sample drag view.
 * 
 * @author Vishy Ramaswamy
 */
public final class DragSourceListener extends AbstractDragSourceListener {

	/**
	 * Singleton for DragSourceListener.
	 */
	private static DragSourceListener instance = new DragSourceListener(
			new String[] { IDETransferId.NAV_SELECTION_TRANSFER });

	/**
	 * Method that returns the singleton DragSourceListener.
	 * 
	 * @return DragSourceListener
	 */
	public static DragSourceListener getInstance() {
		return instance;
	}

	/**
	 * Constructor for DragSourceListener.
	 * 
	 * @param transferIds
	 */
	private DragSourceListener(String[] transferIds) {
		super(transferIds);
	}

	/**
	 * @see com.ibm.xtools.common.ui.services.dnd.drag.AbstractDragSourceListener#isDraggable()
	 */
	protected boolean isDraggable() {
		/* Get the selection */
		ISelection selection = getContext().getSelection();
		if (!(selection instanceof IStructuredSelection)) {
			return false;
		}

		/*
		 * Can inspect the selection to determine if the selection is draggable or not
		 */
//		List selectedObjects = ((IStructuredSelection) selection).toList();
//		if (selectedObjects != null && !selectedObjects.isEmpty()) {
//			Iterator iter = selectedObjects.iterator();
//			while (iter.hasNext()) {
//				Object next = iter.next();
////				if (!(next instanceof ServerItemProvider)) {
////					return false;
////				}
//			}
//		}
		return true;
	}

	/**
	 * @see org.eclipse.swt.dnd.DragSourceListener#dragFinished(DragSourceEvent)
	 */
	public void dragFinished(DragSourceEvent event) {
		/* Delete elements if it is a move */
//		if (event.detail == DND.DROP_MOVE) {
//			List selectedObjects = ((IStructuredSelection) getContext()
//				.getSelection()).toList();
//			if (selectedObjects != null && !selectedObjects.isEmpty()) {
//				Iterator iter = selectedObjects.iterator();
//				while (iter.hasNext()) {
//					Object next = iter.next();
////					if (next instanceof ServerItemProvider) {
////						// stuff
////					}
//				}
//				
////				((ServerExplorer)getContext().getActivePart()).getViewer().refresh();
//			}
//		}
	}

	/**
	 * @see org.eclipse.swt.dnd.DragSourceListener#dragSetData(DragSourceEvent)
	 */
	public void dragSetData(DragSourceEvent event) {
		/* Set the event data */
		event.data = getContext().getSelection();
	}
}
