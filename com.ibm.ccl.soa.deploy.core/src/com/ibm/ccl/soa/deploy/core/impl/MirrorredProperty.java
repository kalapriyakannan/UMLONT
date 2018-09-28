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

import java.util.Iterator;

import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Instantiation;
import com.ibm.ccl.soa.deploy.core.Property;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreSafeRunnable;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.InternalInstanceConfiguration;

/**
 * @since 1.0
 * 
 */
public class MirrorredProperty extends DeployModelObjectImpl implements Property {

	private final InternalInstanceConfiguration configuration;
	private Instantiation container;

	public MirrorredProperty(InternalInstanceConfiguration configuration, String name) {
		this.configuration = configuration;
		setName(name);
	}

	// select is unsupported for MirroredProperties
	public void setSelect(String value) {
		setName(value);
	}

	public String getSelect() {
		return null;
	}

	public String getValue() {
		synchronized (this) {
			if (container == null) {
				container = configuration
						.getInstantiationByName(InternalInstanceConfiguration.GLOBAL_CONFIGURATION);
			}
		}
		if (container != null) {
			Property instantiatedProperty = container.getProperty(name);
			if (instantiatedProperty != null) {
				if (instantiatedProperty.getValue() != null
						&& instantiatedProperty.getValue().length() > 0) {
					return instantiatedProperty.getValue();
				}
			}
		}
		ConfigurationContract contract = configuration.getImportedContract();
		if (contract != null) {
			Property property = contract.getProperty(getName());
			return property.getValue();
		}
		return null;
	}

	public void setValue(String value) {
		synchronized (this) {
			if (container == null) {
				container = configuration.createInstantiation(configuration.getImportedContract(),
						null, InternalInstanceConfiguration.GLOBAL_CONFIGURATION);
			}
		}

		Property instantiatedProperty = container.getProperty(name);
		String deltaValue = null;
		if (value != null && value.length() > 0) {
			if (instantiatedProperty == null) {
				deltaValue = getValue();
				instantiatedProperty = CoreFactory.eINSTANCE.createProperty();
				instantiatedProperty.setName(getName());
				container.getConfiguredProperties().add(instantiatedProperty);
			} else {
				deltaValue = instantiatedProperty.getValue();
			}
			instantiatedProperty.setValue(value);
			fireNotification(new ValueNotification(this, deltaValue, value));
		} else {
			if (instantiatedProperty != null) {
				container.getConfiguredProperties().remove(instantiatedProperty);
				ConfigurationContract contract = configuration.getImportedContract();
				if (contract != null) {
					Property property = contract.getProperty(getName());
					deltaValue = property.getValue();
				}
				fireNotification(new ValueNotification(this, instantiatedProperty.getValue(),
						deltaValue));
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (name == null ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Property)) {
			return false;
		}
		final Property other = (Property) obj;
		if (name == null) {
			if (other.getName() != null) {
				return false;
			}
		} else if (!name.equals(other.getName())) {
			return false;
		}
		return other.getSelect() == null;
	}

	protected final void fireNotification(Notification msg) {
		SafeNotifier notifier = new SafeNotifier(msg);
		for (Iterator<Adapter> iterator = eAdapters().iterator(); iterator.hasNext();) {
			Adapter adapter = iterator.next();
			notifier.setAdapter(adapter);
			SafeRunner.run(notifier);
		}
	}

	protected class ValueNotification extends NotificationImpl {

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
		public ValueNotification(DeployModelObject source, String oldValue, String newValue) {
			super(Notification.SET, oldValue, newValue);
			notifier = source;
			feature = CorePackage.Literals.PROPERTY__VALUE;
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

}
