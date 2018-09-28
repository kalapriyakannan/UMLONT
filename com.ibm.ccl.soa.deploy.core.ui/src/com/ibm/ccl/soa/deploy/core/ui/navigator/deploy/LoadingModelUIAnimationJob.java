/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation.
 * Licensed Material - Property of IBM. All rights reserved.
 * US Government Users Restricted Rights - Use, duplication or disclosure
 * restricted by GSA ADP Schedule Contract with IBM Corp.
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.navigator.deploy;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.ui.progress.UIJob;

/**
 * 
 * Schedules a call to update() the "pending" node in the 
 * TreeViewer. This Job works in conjunction with the 
 * LabelProvider and LoadingModelNode, which automatically 
 * cycles the icon and text based on a four step iteration; 
 * this causes the appearance of an animated node in the tree, 
 * and maintains a responsive UI for the user while the 
 * background Job runs. 
 * 
 * When the loading job completes, the place holder is 
 * disposed and the animation job ends. 
 *
 */
public class LoadingModelUIAnimationJob extends UIJob {
	 
	/* we update the animation frame every 250 ms */
	private static final long DELAY = 200;
	 
	/* the node holding the place for the model (the "Loading ..." in the tree ) */
	private LoadingModelNode placeHolder;
	private StructuredViewer viewer; 
	 
	public LoadingModelUIAnimationJob(StructuredViewer viewer, LoadingModelNode placeHolder) {
		super(placeHolder.getText()); 
		this.viewer = viewer;
		this.placeHolder = placeHolder;		
		/* this way we don't put alot of noise in the progress view, 
		 * except for power users that turn on "show system jobs" in the view  
		 */
		setSystem(true); 
		setRule(new NonConflictingRule());
	}

	public IStatus runInUIThread(IProgressMonitor monitor) { 
		 
		if(!placeHolder.isDisposed()) {
			
			/* update the animation frame */
			viewer.update(placeHolder, null);
			
			/* reschedule for the next animation frame */
			schedule(DELAY);		
		} 
		return Status.OK_STATUS;
		
	}
 

}
