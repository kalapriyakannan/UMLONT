/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.navigator.deploy;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.progress.UIJob;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;

/**
 * Makes Conceptual Units within the Deployment Navigator appear in Italics.
 * 
 * @author NKruk
 * 
 */
public class ConceptualNodeDecorator extends LabelProvider implements ILightweightLabelDecorator,
		Adapter {
	protected Unit target;
	private boolean remove = false;
	private Font conceptual;
	private Font nonConceptual;
	private final Object lock = new Object();
	private final Job fetchFontJob;

	/**
	 * Constructor grabs the System font in a UIJob and sets up the conceptual and nonConceptual Font
	 * instances.
	 * 
	 */
	public ConceptualNodeDecorator() {
		fetchFontJob = new UIJob(Messages.ConceptualNodeDecorator_) {
			public IStatus runInUIThread(IProgressMonitor monitor) {
				synchronized (lock) {
					Font systemFont = Display.getCurrent().getSystemFont();
					setNonConceptualFont(systemFont);
					FontData[] data = systemFont.getFontData();
					if (data != null && data.length > 0) {
						FontData d = new FontData(data[0].toString());
						d.setStyle(SWT.ITALIC);
						Font temp = new Font(Display.getCurrent(), d);
						setConceptualFont(temp);
					} else {
						setConceptualFont(systemFont);
					}
					lock.notifyAll();
				}
				return Status.OK_STATUS;
			}
		};
		fetchFontJob.schedule();
	}

	public void notifyChanged(Notification notification) {
		if (remove) { //If dispose has been called, remove ourselves from the unit
			Object feature = notification.getFeature();
			Unit unit = (Unit) feature;
			Adapter a = EcoreUtil.getAdapter(unit.eAdapters(), this);
			if (a != null) {
				unit.eAdapters().remove(a);
			}
		}
		//Decorate the unit if conceptual is set
		int featureID = notification.getFeatureID(Unit.class);
		if (featureID == CorePackage.eINSTANCE.getUnit_Conceptual().getFeatureID()) {
			if (notification.getEventType() == Notification.SET) {
				//Decorate the unit
				fireLabelProviderChanged(new LabelProviderChangedEvent(this, notification.getNotifier()));
			}
		}
	}

	public void decorate(Object element, IDecoration decoration) {
		if (element == null)
			return;
		if (element instanceof Unit) {
			Unit unit = (Unit) element;
			if (EcoreUtil.getAdapter(unit.eAdapters(), unit) == null) { //Listen to this unit
				unit.eAdapters().add(this);
			}
			if (unit.isConceptual()) {
				decoration.setFont(getConceptualFont());
			} else {
				decoration.setFont(getNonConceptualFont());
			}
		}
	}

	protected final Font getConceptualFont() {
		synchronized (lock) {
			// make sure the Job isn't Running/Waiting/Sleeping  
			try {
				while (conceptual == null) {
					lock.wait();
				}
			} catch (Exception e) {
				DeployCorePlugin.logError(0, e.getMessage(), e);
			}
			return conceptual;
		}
	}

	protected final void setConceptualFont(Font font) {
		synchronized (lock) {
			conceptual = font;
		}
	}

	protected final Font getNonConceptualFont() {
		synchronized (lock) {
			// make sure the Job isn't Running/Waiting/Sleeping  
			try {
				while (nonConceptual == null) {
					lock.wait();
				}
			} catch (Exception e) {
				DeployCorePlugin.logError(0, e.getMessage(), e);
			}
			return nonConceptual;
		}
	}

	protected final void setNonConceptualFont(Font font) {
		synchronized (lock) {
			nonConceptual = font;
		}
	}

	public void dispose() {
		remove = true;
		conceptual.dispose();
	}

	public Notifier getTarget() {
		return target;
	}

	public void setTarget(Notifier newTarget) {
		this.target = (Unit) newTarget;
	}

	public boolean isAdapterForType(Object type) {
		return type instanceof Unit;
	}

}
