package com.ibm.ccl.soa.deploy.internal.core.topologyimport;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.internal.core.InternalTopology;
import com.ibm.ccl.soa.deploy.internal.core.extension.IProxyCacheService;
import com.ibm.ccl.soa.deploy.internal.core.extension.IScopeService;

/**
 * Re-notifies events from "Facaded" conainers (like Augmentations) to their real source (like a
 * proxied imported object).
 * 
 */
public class EchoAdapter extends AdapterImpl {

	/**
	 * @param augmentation
	 * @param interceptedFeature
	 *           The feature that was actually changed.
	 * @param shadowedFeature
	 *           The feature to use for the notification.
	 * @param source
	 * @param configuration
	 * @return The adapter associated with the given notifier.
	 */
	public static EchoAdapter findAdapter(Notifier augmentation,
			EStructuralFeature interceptedFeature, EStructuralFeature shadowedFeature,
			DeployModelObject source, InstanceConfiguration configuration) {
		Map<EStructuralFeature, EStructuralFeature> echoedFeatures = new HashMap<EStructuralFeature, EStructuralFeature>(
				2);
		echoedFeatures.put(interceptedFeature, shadowedFeature);
		return findAdapter(augmentation, echoedFeatures, source, configuration);
	}

	/**
	 * @param augmentation
	 * @param echoedFeatures
	 *           A map of the feature that was actually changed to the feature to use for the
	 *           notification.
	 * @param source
	 * @param configuration
	 * @return The adapter associated with the given notifier.
	 */
	public static EchoAdapter findAdapter(Notifier augmentation,
			Map<EStructuralFeature, EStructuralFeature> echoedFeatures, DeployModelObject source,
			InstanceConfiguration configuration) {
		return findAdapter(augmentation, echoedFeatures, source, configuration, true);
	}

	/**
	 * @param augmentation
	 * @param echoedFeatures
	 * @param source
	 * @param configuration
	 * @param convertEntries
	 * @return The adapter associated with the given notifier.
	 */
	public static EchoAdapter findAdapter(Notifier augmentation,
			Map<EStructuralFeature, EStructuralFeature> echoedFeatures, DeployModelObject source,
			InstanceConfiguration configuration, boolean convertEntries) {
		EchoAdapter adapter = (EchoAdapter) EcoreUtil.getAdapter(augmentation.eAdapters(),
				echoedFeatures);
		if (adapter == null) {
			adapter = new EchoAdapter(echoedFeatures, source, configuration, convertEntries);
			augmentation.eAdapters().add(adapter);
		}
		return adapter;
	}

	private final InstanceConfiguration configuration;
	private final DeployModelObject source;
	private final Map<EStructuralFeature, EStructuralFeature> echoedFeatures;
	private boolean convertEntries = true;
	private boolean forwardUnrecognizedEvents = false;

	/**
	 * @param echoedFeatures
	 * @param source
	 * @param configuration
	 * @param convertEntries
	 */
	public EchoAdapter(Map<EStructuralFeature, EStructuralFeature> echoedFeatures,
			DeployModelObject source, InstanceConfiguration configuration, boolean convertEntries) {
		this.echoedFeatures = echoedFeatures;
		this.source = source;
		this.configuration = configuration;
		this.convertEntries = convertEntries;
	}

	/**
	 * @param echoedFeatures
	 * @param source
	 * @param configuration
	 */
	public EchoAdapter(Map<EStructuralFeature, EStructuralFeature> echoedFeatures,
			DeployModelObject source, InstanceConfiguration configuration) {
		this(echoedFeatures, source, configuration, true);

	}

	public Notifier getTarget() {
		return target;
	}

	public boolean isAdapterForType(Object type) {
		if (type instanceof Map) {
			return echoedFeatures.keySet().containsAll(((Map) type).keySet());
		}
		return false;
	}

	public void notifyChanged(Notification notification) {
		InternalScopeService scopeService = (InternalScopeService) IScopeService.Locator
				.findScopeService(configuration);
		if (scopeService != null) {
			IProxyCacheService cacheService = scopeService.getCacheService();
			DeployModelObject proxy = cacheService.findProxy(source, configuration.getImported());

			if (proxy != null) {
				Object oldValue = notification.getOldValue();
				Object newValue = notification.getNewValue();

				if (convertEntries && oldValue instanceof FeatureMap.Entry) {
					oldValue = ((FeatureMap.Entry) oldValue).getValue();
				}

				if (convertEntries && newValue instanceof FeatureMap.Entry) {
					newValue = ((FeatureMap.Entry) newValue).getValue();
				}

				Notification shadow = null;

				if (notification.getFeature() instanceof EStructuralFeature) {
					EStructuralFeature translatedFeature = (EStructuralFeature) notification
							.getFeature();
					translatedFeature = echoedFeatures.get(notification.getFeature());
					if (translatedFeature != null) {
						shadow = new ENotificationImpl((InternalEObject) proxy.getEObject(), notification
								.getEventType(), translatedFeature, oldValue, newValue, notification
								.getPosition(), notification.wasSet());
					}
				}

				if (shadow == null && forwardUnrecognizedEvents) {
					final Object originalFeature = notification.getFeature();
					shadow = new ENotificationImpl((InternalEObject) proxy.getEObject(), notification
							.getEventType(), null, oldValue, newValue, notification.getPosition(),
							notification.wasSet()) {
						@Override
						public Object getFeature() {
							return originalFeature;
						}
					};
				}

				if (shadow != null) {
					proxy.getEObject().eNotify(shadow);
					((InternalTopology) proxy.getEditTopology()).notifyTopologyListeners(shadow);
				}
			}
		}

	}

	public void setTarget(Notifier newTarget) {
		target = newTarget;
	}

	public void setForwardUnrecognizedEvents(boolean forwardUnrecognizedEvents) {
		this.forwardUnrecognizedEvents = forwardUnrecognizedEvents;
	}

	public boolean isForwardUnrecognizedEvents() {
		return forwardUnrecognizedEvents;
	}

}
