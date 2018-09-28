/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.navigator.deploy;

//import java.util.ArrayList;
//import java.util.List;

//import org.eclipse.jface.dialogs.MessageDialog;
//import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.dnd.drop.AbstractDropTargetListener;
import org.eclipse.gmf.runtime.common.ui.services.dnd.ide.core.IDETransferId;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;

import com.ibm.ccl.soa.deploy.core.ui.editor.DeployCoreEditor;

/**
 * Concrete class that implements the IDropTargetListener. This class handles dropping of tree
 * elements on the sample drop view.
 * 
 * @author Vishy Ramaswamy
 */
public final class DropTargetListener extends AbstractDropTargetListener {

	/**
	 * Singleton for DropTargetListener.
	 */
	private static DropTargetListener instance = new DropTargetListener(
			new String[] { IDETransferId.NAV_SELECTION_TRANSFER });

	/**
	 * Method that returns the singleton DropTargetListener.
	 * 
	 * @return DropTargetListener
	 */
	public static DropTargetListener getInstance() {
		return instance;
	}

	/**
	 * Constructor for DropTargetListener.
	 * 
	 * @param transferIds
	 */
	private DropTargetListener(String[] transferIds) {
		super(transferIds);
	}

	/**
	 * @see org.eclipse.swt.dnd.DropTargetListener#dragOver(DropTargetEvent)
	 */
	public void dragOver(DropTargetEvent event) {
		/* Check the target */
		if (!canSupport()) {
			event.detail = DND.DROP_NONE;
			return;
		}

		/* Make sure that the data received is in the supported format */
		if (!getCurrentAgent().getTransferId().equals(IDETransferId.NAV_SELECTION_TRANSFER)) {
			event.detail = DND.DROP_NONE;
		} else {
			event.detail = DND.DROP_COPY;
		}
	}

	/**
	 * @see com.ibm.xtools.common.ui.services.dnd.drop.IDropTargetListener#getExecutableContext(DropTargetEvent)
	 */
	public ICommand getExecutableContext(DropTargetEvent event) {
		/*
		 * // Get the label String label = null; if (event.detail == DND.DROP_MOVE) { label = "Move";
		 * //$NON-NLS-1$ } else if (event.detail == DND.DROP_COPY) { label = "Copy"; //$NON-NLS-1$ }
		 * else if (event.detail == DND.DROP_LINK) { } else { return null; }
		 *  // Check the target if (!canSupport()) { return null; }
		 *  // Get the target Object target = getContext().getCurrentTarget();
		 *  // Make sure that the data received is in the supported format List data = null; if
		 * (getCurrentAgent().getTransferId().equals( IDETransferId.NAV_SELECTION_TRANSFER)) { data =
		 * ((IStructuredSelection) event.data).toList(); }
		 *  // The data is no good if (null == data) { return null; }
		 * 
		 * if (event.detail == DND.DROP_MOVE) {
		 * MessageDialog.openInformation(getContext().getActivePart() .getSite().getShell(), "Move
		 * Action", "Element has been dropped"); return null; }
		 * 
		 * DeployableUnit[] array = new DeployableUnit[data.size()]; ArrayList list = new
		 * ArrayList(data); list.toArray(array);
		 *  // Create the drop command //return new CopyCommand("Copy", (DeployToolEditor)
		 * getContext() //.getActivePart(), (SampleDropView.TreeParent) target, array);
		 */
		return null;
	}

	/*
	 * @see com.ibm.xtools.common.ui.internal.dnd.drop.AbstractDropTargetListener#canSupport()
	 */
	public boolean canSupport() {
		int currentOperation = getCurrentEvent().getCurrentOperation();
		if (!(currentOperation == DND.DROP_MOVE || currentOperation == DND.DROP_COPY)) {
			return false;
		}

		/* Get the target */
		Object target = getContext().getCurrentTarget();

		/* Check if the target is a tree parent */
		if (target instanceof DeployCoreEditor) {
			return true;
		}

		return false;
	}
}
