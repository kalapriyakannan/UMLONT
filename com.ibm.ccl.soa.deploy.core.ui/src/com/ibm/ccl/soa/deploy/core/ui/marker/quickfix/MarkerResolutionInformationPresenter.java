/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.marker.quickfix;

import org.eclipse.jface.text.AbstractInformationControlManager;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IMarkerResolution2;

/**
 * @since 1.0
 * 
 */
public class MarkerResolutionInformationPresenter extends AbstractInformationControlManager {

	private Object lock = new Object();
	private Object threadLock = new Object();
	private Thread thread;
	private Object start;
	private boolean reset;

	private SelectionListener selectionListener = new SelectionListener() {
		public void widgetSelected(SelectionEvent e) {
			selectionChanged();
		}

		public void widgetDefaultSelected(SelectionEvent e) {
		}
	};

	private Runnable runnable = new Runnable() {
		protected static final long DELAY = 700;

		public void run() {
			try {
				while (true) {
					synchronized (lock) {
						if (start != null) {
							synchronized (start) {
								start.notifyAll();
								start = null;
							}
						}
						lock.wait();

						while (true) {
							reset = false;
							lock.wait(DELAY);
							if (!reset)
								break;
						}
					}

					if (getSubjectControl() != null && !getSubjectControl().isDisposed()) {
						getSubjectControl().getDisplay().asyncExec(new Runnable() {
							public void run() {
								if (!reset)
									showInformation();
							}
						});
					}

				}
			} catch (InterruptedException ex) {

			}

			synchronized (threadLock) {
				if (Thread.currentThread() == thread)
					thread = null;
			}

		}

	};

	/**
	 * @param creator
	 */
	public MarkerResolutionInformationPresenter(IInformationControlCreator creator) {
		super(creator);
		setAnchor(ANCHOR_RIGHT);
		setFallbackAnchors(new Anchor[] { ANCHOR_RIGHT, ANCHOR_LEFT, ANCHOR_BOTTOM });

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.text.AbstractInformationControlManager#computeInformation()
	 */
	protected void computeInformation() {
		Control control = this.getSubjectControl();
		if (control == null || control.isDisposed())
			return;
		assert control instanceof Table;

		Table tableControl = (Table) control;
		TableItem[] selection = tableControl.getSelection();
		if (selection != null && selection.length > 0) {
			TableItem item = selection[0];
			String description = null;
			Object data = item.getData();
			if (data instanceof IMarkerResolution2) {
				IMarkerResolution2 resolution = (IMarkerResolution2) data;
				description = resolution.getDescription();
			}
			setMargins(5, 0);
			Rectangle bounds = tableControl.getBounds();
			bounds.x = 0;
			bounds.y = 0;
			setInformation(description, bounds);
		}
	}

	public void install(Control subjectControl) {
		super.install(subjectControl);
		assert subjectControl instanceof Table;
		Table tableControl = (Table) subjectControl;
		tableControl.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_INFO_BACKGROUND));
		tableControl.addSelectionListener(selectionListener);
		synchronized (threadLock) {
			if (thread != null)
				thread.interrupt();
			thread = new Thread(runnable, "Resolution Description"); //$NON-NLS-1$

			start = new Object();
			synchronized (start) {
				thread.start();
				try {
					start.wait();
				} catch (InterruptedException x) {
				}
			}
		}

	}

	/**
	 * Listens to the selection changes in the table
	 */
	public void selectionChanged() {

		if (getSubjectControl() != null && !getSubjectControl().isDisposed()
				&& getSubjectControl().isVisible()) {
			synchronized (lock) {
				reset = true;
				lock.notifyAll();
			}
		}
	}

	public void disposeInformationControl() {
		synchronized (threadLock) {
			if (thread != null) {
				thread.interrupt();
				thread = null;
			}
		}

		if (getSubjectControl() != null && !getSubjectControl().isDisposed()) {
			assert getSubjectControl() instanceof Table;
			Table tableControl = (Table) getSubjectControl();
			tableControl.removeSelectionListener(selectionListener);

		}

		super.disposeInformationControl();
	}

}
