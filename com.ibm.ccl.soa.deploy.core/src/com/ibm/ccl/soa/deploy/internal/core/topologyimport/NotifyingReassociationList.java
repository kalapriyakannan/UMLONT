/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.topologyimport;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.internal.core.FeatureAdapter;

/**
 * A re-association list will redirect all additions to the list to one of the two delegate lists.
 * In addition, whenever a modification occurs, an EMF event is generated.
 * 
 * @since 1.0
 * 
 */
public class NotifyingReassociationList extends ReassociationList {

	private final DeployModelObject notifier;
	private final EStructuralFeature baseFeature;
	private final DeployModelObject notificationSource;

	/**
	 * An iterator that notifies listeners when objects are removed.
	 * 
	 * @since 1.0
	 * 
	 */
	public class NotifyingCompoundIterator extends CompoundIterator {

		public NotifyingCompoundIterator(Iterator[] iterables, Modifiable modifiable) {
			super(iterables, modifiable);
		}

		private Object last = null;

		public Object next() {
			last = super.next();
			return last;
		}

		public void remove() {
			super.remove();
			if (last instanceof EObject) {
				NotifyingReassociationList.this.notify(new ReassocationNotification(
						Notification.REMOVE, (EObject) last, null));
			}
		}

	}

	/**
	 * Create a reassociation list that also notifies.
	 * 
	 * @param nonProxyNotifier
	 * @param feature
	 * @param proxySource
	 * @param container
	 * @param unit
	 */
	public NotifyingReassociationList(DeployModelObject nonProxyNotifier,
			EStructuralFeature feature, DeployModelObject proxySource, EList container, List unit) {
		super(proxySource, feature, container, unit);
		notifier = nonProxyNotifier;
		notificationSource = proxySource;
		baseFeature = feature;
	}

	public boolean add(final Object added) {
		boolean success = super.add(added);
		if (added instanceof EObject) {
			notify(new ReassocationNotification(Notification.ADD, null, (EObject) added));
		}
		return success;
	}

//	public boolean removeAll(Collection removed) {
//		boolean success = super.removeAll(removed);
//		if (removed instanceof EObject) {
//			notify(new ReassocationNotification(Notification.REMOVE_MANY, removed, null) {
//				public Object getNotifier() {
//					return notifier;
//				}
//
//				public Object getFeature() {
//					return baseFeature;
//				}
//			});
//		}
//		return success;
//	}

	public boolean remove(final Object removed) {
		boolean success = super.remove(removed);
		if (removed instanceof EObject) {
			notify(new ReassocationNotification(Notification.REMOVE, (EObject) removed, null));
		}
		return success;
	}

	public Object remove(final int index) {
		final Object result = super.remove(index);
		if (result instanceof EObject) {
			notify(new ReassocationNotification(Notification.REMOVE, (EObject) result, null));
		}
		return result;
	}

	public Iterator iterator() {
		return new NotifyingCompoundIterator(new Iterator[] { editableList.iterator(),
				readOnlyList.iterator() }, this);
	}

	private void notify(Notification notification) {
		if (notifier != null) {
			EList adapters = notifier.getEObject().eAdapters();
			for (Iterator iterator = adapters.iterator(); iterator.hasNext();) {
				Adapter adapter = (Adapter) iterator.next();
				adapter.notifyChanged(notification);
			}
		}
	}

	private class ReassocationNotification extends NotificationImpl {

		private final EObject result;

		/**
		 * Create a notification that will return the correct notifier and feature.
		 * 
		 * @param type
		 * @param oldValue
		 * @param newValue
		 */
		public ReassocationNotification(int type, EObject oldValue, EObject newValue) {
			super(type, oldValue, newValue);
			result = oldValue != null ? oldValue : newValue;
		}

		public Object getNotifier() {
			return notificationSource;
		}

		public Object getFeature() {
			return FeatureAdapter.getFeature(result, baseFeature);
		}
	}

}
