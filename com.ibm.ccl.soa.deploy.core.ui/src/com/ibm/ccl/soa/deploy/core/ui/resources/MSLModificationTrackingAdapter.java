/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.resources;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

//Copied the code from MSLObjectListener for special handling of transient features.
public class MSLModificationTrackingAdapter extends AdapterImpl {
	public void notifyChanged(Notification notification) {
		EObject notifier = (EObject) notification.getNotifier();
		Resource resource = notifier.eResource();

		Object feature = notification.getFeature();
		switch (notification.getEventType())
		{
		case Notification.SET:
		case Notification.UNSET:
		case Notification.MOVE: {
			if (!notification.isTouch() && !resource.isModified()) {
				if (!isTransient(notifier, feature))
					resource.setModified(true);
			}
			break;
		}
		case Notification.ADD:
		case Notification.REMOVE:
		case Notification.ADD_MANY:
		case Notification.REMOVE_MANY: {
			if (!resource.isModified() && !isTransient(notifier, feature))
				resource.setModified(true);
			break;
		}
		}
	}

	/**
	 * check if the feature or one of its containers is transient
	 * 
	 * @param notifier
	 * @param feature
	 * @param transientChange
	 * @return
	 */
	private boolean isTransient(EObject notifier, Object feature) {
		if (feature instanceof EStructuralFeature) {
			if (((EStructuralFeature) feature).isTransient())
				return true;
			else
				// calling isTransient could be a lengthy operation
				return isTransient(notifier);
		}
		return false;
	}

	/**
	 * Is object transient?
	 */
	private boolean isTransient(EObject eObject) {
		EStructuralFeature containmentFeature = eObject.eContainmentFeature();
		while (containmentFeature != null) {
			if (containmentFeature.isTransient())
				return true;
			eObject = eObject.eContainer();
			if (eObject != null)
				containmentFeature = eObject.eContainmentFeature();
			else
				break;
		}
		return false;
	}
}
