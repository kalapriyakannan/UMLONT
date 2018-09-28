/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.impl;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Property;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.Visibility;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreSafeRunnable;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Configuration Contract</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class ConfigurationContractImpl extends DeployModelObjectImpl implements
		ConfigurationContract {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationContractImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.CONFIGURATION_CONTRACT;
	}

	public List<Unit> getPublicEditableUnits() {
		return getVisibleUnits();
	}

	public List<Unit> getPublicUnits() {
		return getVisibleUnits();
	}

	public boolean isVisible(DeployModelObject source) {
		return false;
	}

	public boolean isPublic(DeployModelObject source) {
		return false;
	}

	public boolean isPublicEditable(DeployModelObject source) {
		return false;
	}

	public void export(DeployModelObject source, boolean configurable) {

	}

	public void export(DeployModelObject source, EStructuralFeature feature) {

	}

	public Property exportProperty(String propertyName) {
		return null;
	}

	protected final void fireVisibilityChanged(DeployModelObject dmo, Visibility oldValue,
			Visibility newValue) {
		fireNotificationForDMO(dmo, new VisibilityNotification(dmo, oldValue, newValue));
	}

	protected final void fireExportedProperty(DeployModelObject dmo,
			EStructuralFeature exportedProperty) {
		fireNotificationForDMO(dmo, new VisibilityNotification(dmo, null, exportedProperty));
	}

	protected final void fireUnexportedProperty(DeployModelObject dmo,
			EStructuralFeature unExportedProperty) {
		fireNotificationForDMO(dmo, new VisibilityNotification(dmo, unExportedProperty, null));
	}

	protected final void fireExportedProperty(DeployModelObject dmo, String exportedPropertyName) {
		fireNotificationForDMO(dmo, new VisibilityNotification(dmo, null, exportedPropertyName));
	}

	protected final void fireUnexportedProperty(DeployModelObject dmo, String unExportedPropertyName) {
		fireNotificationForDMO(dmo, new VisibilityNotification(dmo, unExportedPropertyName, null));
	}

	protected final void fireExportedGlobalProperty(DeployModelObject dmo, Property property) {
		fireNotificationForDMO(dmo, new VisibilityNotification(dmo, null, property));
	}

	protected final void fireUnexportedGlobalProperty(DeployModelObject dmo, Property property) {
		fireNotificationForDMO(dmo, new VisibilityNotification(dmo, property, null));
	}

	protected final void fireNotificationForDMO(DeployModelObject dmo, Notification msg) {
		SafeNotifier notifier = new SafeNotifier(msg);
		EList adapters = dmo.getEObject().eAdapters();
		for (Iterator<Adapter> iterator = adapters.iterator(); iterator.hasNext();) {
			Adapter adapter = iterator.next();
			notifier.setAdapter(adapter);
			SafeRunner.run(notifier);
		}
	}

	protected class VisibilityNotification extends NotificationImpl {

		private final DeployModelObject notifier;
		private final EStructuralFeature feature;

		/**
		 * Create a notification object for the
		 * {@link CorePackage.Literals#DEPLOY_MODEL_OBJECT__VISIBILITY} feature.
		 * 
		 * @param source
		 *           The source of the notification.
		 * @param oldVisibility
		 *           The old visibility of the source of the visibility change
		 * @param newVisibility
		 *           The new visibility of the source of the visibility change
		 * 
		 */
		public VisibilityNotification(DeployModelObject source, Visibility oldVisibility,
				Visibility newVisibility) {
			super(Notification.SET, null, null);
			notifier = source;
			feature = CorePackage.Literals.DEPLOY_MODEL_OBJECT__VISIBILITY;
			oldValue = oldVisibility;
			newValue = newVisibility;
		}

		/**
		 * Create a notification object for the
		 * {@link CorePackage.Literals#DEPLOY_MODEL_OBJECT__EXPORTED_PROPERTIES} feature.
		 * 
		 * @param source
		 *           The source of the notification.
		 * @param unexportedPropertyName
		 *           The property that was removed from the contract, or null if none.
		 * @param exportedPropertyName
		 *           The property that was added to the contract, or null if none.
		 */
		public VisibilityNotification(DeployModelObject source, String unexportedPropertyName,
				String exportedPropertyName) {
			super(unexportedPropertyName != null ? Notification.REMOVE : Notification.ADD,
					unexportedPropertyName, exportedPropertyName);
			notifier = source;
			feature = CorePackage.Literals.DEPLOY_MODEL_OBJECT__EXPORTED_PROPERTIES;
		}

		/**
		 * Create a notification object for the
		 * {@link CorePackage.Literals#DEPLOY_MODEL_OBJECT__EXPORTED_PROPERTIES} feature.
		 * 
		 * @param source
		 *           The source of the notification.
		 * @param unexportedProperty
		 *           The property that was removed from the contract, or null if none.
		 * @param exportedProperty
		 *           The property that was added to the contract, or null if none.
		 */
		public VisibilityNotification(DeployModelObject source,
				EStructuralFeature unexportedProperty, EStructuralFeature exportedProperty) {
			super(unexportedProperty != null ? Notification.REMOVE : Notification.ADD,
					unexportedProperty, exportedProperty);
			notifier = source;
			feature = CorePackage.Literals.DEPLOY_MODEL_OBJECT__EXPORTED_PROPERTIES;
		}

		/**
		 * Create a notification object for the
		 * {@link CorePackage.Literals#DEPLOY_MODEL_OBJECT__VISIBILITY} feature.
		 * 
		 * @param source
		 *           The source of the notification.
		 * @param unexportedProperty
		 *           The property that was removed from the contract, or null if none.
		 * @param exportedProperty
		 *           The property that was added to the contract, or null if none.
		 */
		public VisibilityNotification(DeployModelObject source, Property unexportedProperty,
				Property exportedProperty) {
			super(unexportedProperty != null ? Notification.REMOVE : Notification.ADD,
					unexportedProperty, exportedProperty);
			notifier = source;
			feature = CorePackage.Literals.TOPOLOGY__GLOBAL_PROPERTIES;
		}

		public Object getNotifier() {
			return notifier;
		}

		public Object getFeature() {
			return feature;
		}

	}

	protected class SafeNotifier extends DeployCoreSafeRunnable {

		private final Notification msg;
		private Adapter adapter;

		/**
		 * Creates an ISafeRunnable that notifies EMF Adapters. The {@link #setAdapter(Adapter)} must
		 * be called before {@link SafeRunner#run(ISafeRunnable)}.
		 * 
		 * @param msg
		 *           The notification to send out to the adapter.
		 */
		public SafeNotifier(Notification msg) {
			this.msg = msg;
		}

		protected void setAdapter(Adapter adapter) {
			this.adapter = adapter;
		}

		public void run() throws Exception {
			if (adapter != null) {
				adapter.notifyChanged(msg);
			}

		}
	}

	public List<Property> getGlobalProperties() {
		return Collections.emptyList();
	}

} //ConfigurationContractImpl
