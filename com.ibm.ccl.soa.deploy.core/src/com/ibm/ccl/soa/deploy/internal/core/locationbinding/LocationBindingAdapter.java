/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.locationbinding;

import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.locationbinding.LocationBindingService;
import com.ibm.ccl.soa.deploy.core.util.CoreResourceImpl;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreSafeRunnable;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

/**
 * 
 * Monitors artifacts for changes that would require a save operation of the location resource.
 * 
 * The Lifecycle of the object:
 * 
 * (1) First {@link #install(Resource) installed} onto the Resource of the {@link Topology} in the
 * constructor of {@link CoreResourceImpl#CoreResourceImpl(org.eclipse.emf.common.util.URI)} with a
 * null location resource.
 * 
 * (2) When the location resource is loaded in {@link LocationBindingService#getLocationBinding()},
 * the adapter is {@link #update(Resource, Resource) updated} with a non-null location resource.
 * 
 * (3) As modification events are generated on the {@link Topology}'s resource, the location
 * resource (if non-null) will also be marked dirty.
 * 
 * (4) If the the preference store is updated to use or not use a binding sidefile, then the
 * {@link Topology}'s resource is re-loaded.
 * 
 * @since 1.0
 * 
 */
public class LocationBindingAdapter extends AdapterImpl {

	private static final Object lock = new Object();

	private static final Class<LocationBindingAdapter> ADAPTER_TYPE = LocationBindingAdapter.class;

	private Resource locationResource;

	/**
	 * Create a location binding adapter for the given location resource.
	 * 
	 */
	private LocationBindingAdapter() {

	}

	/**
	 * Create a location binding adapter for the given location resource.
	 * 
	 * @param locationResource
	 */
	private LocationBindingAdapter(Resource locationResource) {
		this.locationResource = locationResource;
	}

	/**
	 * Install the adapter on the core resource with the given location resource or null if there is
	 * none. If initialized with "null", it should later be initialized with a non-null resource
	 * (same call).
	 * 
	 * @param coreResource
	 * @param locationResource
	 * @return
	 */
	public static LocationBindingAdapter install(Resource coreResource) {
		synchronized (lock) {
			if (coreResource != null) {
				LocationBindingAdapter adapter = (LocationBindingAdapter) EcoreUtil.getAdapter(
						coreResource.eAdapters(), ADAPTER_TYPE);
				if (adapter == null) {
					coreResource.eAdapters().add(adapter = new LocationBindingAdapter());
					adapter.configure(false);
				}
				return adapter;
			}
		}
		return null;
	}

	/**
	 * Install the adapter on the core resource with the given location resource or null if there is
	 * none. If initialized with "null", it should later be initialized with a non-null resource
	 * (same call).
	 * 
	 * @param coreResource
	 * @param locationResource
	 * @return
	 */
	public static LocationBindingAdapter update(Resource coreResource, Resource locationResource) {
		synchronized (lock) {
			if (coreResource != null) {
				LocationBindingAdapter adapter = (LocationBindingAdapter) EcoreUtil.getAdapter(
						coreResource.eAdapters(), ADAPTER_TYPE);
				if (adapter == null) {
					coreResource.eAdapters().add(adapter = new LocationBindingAdapter());
				}
				if (LocationBindingService.INSTANCE.isLocationBindingUsage(coreResource)) {
					adapter.setLocationResource(locationResource);
				}
				return adapter;
			}
		}
		return null;
	}

	/**
	 * @param coreResource
	 * @return
	 */
	public static LocationBindingAdapter uninstall(Resource coreResource) {
		synchronized (lock) {
			LocationBindingAdapter adapter = (LocationBindingAdapter) EcoreUtil.getAdapter(
					coreResource.eAdapters(), ADAPTER_TYPE);
			if (adapter != null) {
				coreResource.eAdapters().remove(adapter);
			}
			return adapter;
		}
	}

	@Override
	public void setTarget(Notifier newTarget) {
		super.setTarget(newTarget);
//		System.out.println("LocationBindingAdapter added to " + newTarget); //$NON-NLS-1$
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return type == ADAPTER_TYPE;
	}

	@Override
	public void notifyChanged(Notification msg) {
		if (locationResource == null) {
			configure(false);
		}
		if (locationResource != null) {
			if (msg.getFeatureID(Resource.class) == Resource.RESOURCE__IS_MODIFIED) {
				if (msg.getNewBooleanValue()) {
					locationResource.setModified(true);
				}
			}
		}
	}

	protected void configure(boolean reload) {

		Notifier source = getTarget();
		if (source instanceof Resource
				&& LocationBindingService.INSTANCE.isLocationBindingUsage((Resource) source)) {
			if (source instanceof Resource) {
				final Resource topologyResource = (Resource) source;
				if (topologyResource.getResourceSet() != null) {
					if (topologyResource.isLoaded() && reload) {
						SafeRunner.run(new DeployCoreSafeRunnable() {

							@Override
							public void run() throws Exception {
//									System.out.println("Reloading \"" + topologyResource.getURI() + "\" in LocationBindingAdapter.");  //$NON-NLS-1$//$NON-NLS-2$
								topologyResource.unload();
								topologyResource.load(Collections.emptyMap());
								topologyResource.setModified(false);
							}

						});
					}

					IFile topologyFile = WorkbenchResourceHelper.getFile(topologyResource);
					if (topologyFile != null) {
						IFile bindingFile = LocationBindingService.INSTANCE
								.resolveBindingFile(topologyFile);

						URI locationFileURI = URI.createPlatformResourceURI(bindingFile.getFullPath()
								.toString());
						Resource locationResource = topologyResource.getResourceSet().getResource(
								locationFileURI, bindingFile.exists());
						setLocationResource(locationResource);
					}
				}
			}
		} else {
			setLocationResource(null);
		}
	}

	protected Resource getLocationResource() {
		return locationResource;
	}

	protected void setLocationResource(Resource locationResource) {
		this.locationResource = locationResource;
	}

	public void onChange() {
//		System.out.println("Adapter for " + ( locationResource != null ? locationResource.getURI().toString() : "<No Resource>" ) + " received change event."); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		configure(true);
	}

}
