/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.Assert;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * An adapter logging all EMF events on an {@link EObject}.
 * <p>
 * Used for testing.
 */
public class EObjectEventLogger implements Adapter {

	protected Notifier target = null;

	protected List list = new ArrayList();

	/*
	 * @see org.eclipse.emf.common.notify.Adapter#getTarget()
	 */
	public Notifier getTarget() {
		return target;
	}

	/*
	 * @see org.eclipse.emf.common.notify.Adapter#isAdapterForType(java.lang.Object)
	 */
	public boolean isAdapterForType(Object type) {
		return true;
	}

	/*
	 * @see org.eclipse.emf.common.notify.Adapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	public void notifyChanged(Notification notification) {
		list.add(notification);
	}

	/*
	 * @see org.eclipse.emf.common.notify.Adapter#setTarget(org.eclipse.emf.common.notify.Notifier)
	 */
	public void setTarget(Notifier newTarget) {
		this.target = newTarget;
		list.clear();
	}

	/**
	 * Returns a list of {@link Notification} events logs using
	 * {@link #notifyChanged(Notification)}.
	 * 
	 * @return List<Notification>
	 */
	public List getNotifications() {
		return list;
	}

	public static void assertNotification(Notification notfication1,
			int expectedEventType, final EObject publicUnit,
			EStructuralFeature expectedFeature, Object expectedOldValue,
			Object expectedNewValue) {
		Assert.assertEquals(expectedEventType, notfication1.getEventType());
		Assert.assertEquals(expectedFeature, notfication1.getFeature());
		Assert.assertEquals(publicUnit, notfication1.getNotifier());
		Assert.assertEquals(expectedOldValue, notfication1.getOldValue());
		Assert.assertEquals(expectedNewValue, notfication1.getNewValue());
	}
	

	public static void assertNotification(Notification notfication1,
			int expectedEventType, final EObject publicUnit,
			EStructuralFeature expectedFeature, List expectedOldValue,
			List expectedNewValue) {
		Assert.assertEquals(expectedEventType, notfication1.getEventType());
		Assert.assertEquals(expectedFeature, notfication1.getFeature());
		Assert.assertEquals(publicUnit, notfication1.getNotifier()); 
		if(notfication1.getOldValue() != null)
			Assert.assertTrue(Arrays.equals(expectedOldValue.toArray(), ((List)notfication1.getOldValue()).toArray()));
		else 
			Assert.assertNull(expectedOldValue);
		
		
		if(notfication1.getNewValue() != null) {
			boolean equals = Arrays.equals(expectedNewValue.toArray(), ((List)notfication1.getNewValue()).toArray());
			Assert.assertTrue(equals);
		}
		else 
			Assert.assertNull(expectedNewValue);
	}
}
