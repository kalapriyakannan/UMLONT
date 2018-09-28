/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLSave.XMLTypeInfo;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.xml.sax.InputSource;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.locationbinding.LocationBindingService;
import com.ibm.ccl.soa.deploy.internal.core.InternalTopology;
import com.ibm.ccl.soa.deploy.internal.core.extension.IScopeService;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.InternalScopeService;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployMarker;
import com.ibm.ccl.soa.infrastructure.emf.EditModelException;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

/**
 * <!-- begin-user-doc --> The <b>Resource </b> associated with the package. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.core.util.CoreResourceFactoryImpl
 * @generated
 */
public class CoreResourceImpl extends XMLResourceImpl {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	//Cached topology to improve performance for delegating notifications 
	//from the modification tracking adapter.
	private InternalTopology topology;

	private final class CoreXMLTypeInfo implements XMLTypeInfo {

		public boolean shouldSaveType(EClass objectType, EClassifier featureType,
				EStructuralFeature feature) {
			return false;
		}

		public boolean shouldSaveType(EClass objectType, EClass featureType,
				EStructuralFeature feature) {
			return false;
		}

	}

	/**
	 * An adapter implementation for tracking resource modification.
	 */
	protected class CoreResourceModificationTrackingAdapter extends AdapterImpl {
		public void notifyChanged(Notification notification) {
			switch (notification.getEventType())
			{
			case Notification.SET:
			case Notification.UNSET:
			case Notification.MOVE: {
				if (CorePackage.Literals.DEPLOY_MODEL_OBJECT__STATUS != notification.getFeature()
						&& !notification.isTouch()) {
					setModified(true);
				}
				break;
			}
			case Notification.ADD:
			case Notification.REMOVE:
			case Notification.ADD_MANY:
			case Notification.REMOVE_MANY: {
				if (CorePackage.Literals.DEPLOY_MODEL_OBJECT__STATUS != notification.getFeature()) {
					setModified(true);
				}
				break;
			}
			}
			//Delete for topology listeners.
			delegateToTopology(notification);
		}
	}

	private final InternalScopeService scopeService;

	/**
	 * Creates an instance of the resource. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param uri
	 *           the URI of the new resource.
	 * @generated NOT
	 */
	public CoreResourceImpl(URI uri) {
		super(uri);

		scopeService = (InternalScopeService) IScopeService.Locator.install(this);
		LocationBindingService.INSTANCE.install(this);

	}

//	public void load(Map<?, ?> options) throws IOException {
//
//		scopeService = (InternalScopeService) IScopeService.Locator.install(this);
//		LocationBindingService.INSTANCE.install(this);
//		super.load(options);
//	}

	/*
	 * Delegate the notification to the Topology if it exists. The topology will be cached to improve
	 * performance.
	 */
	protected void delegateToTopology(Notification notification) {
		if (topology == null) {
			//Topology will always be a single root element.
			List<EObject> contents = getContents();
			if (!contents.isEmpty()) {
				DeployCoreRoot root = (DeployCoreRoot) contents.get(0);
				topology = (InternalTopology) root.getTopology();
			}
		}
		if (topology != null) {
			topology.notifyTopologyListeners(notification);
		}
	}

	protected Adapter createModificationTrackingAdapter() {
		return new CoreResourceModificationTrackingAdapter();
	}

	/**
	 * @generated NOT
	 */
	protected XMLHelper createXMLHelper() {
		return new DeployEncryptingXmlHelper(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl#doSave(java.io.OutputStream,
	 *      java.util.Map)
	 */
	public void doSave(OutputStream outputStream, Map options) throws IOException {
		saveLocationBinding();
		super.doSave(outputStream, options);
		saveMarkers();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl#doSave(java.io.Writer, java.util.Map)
	 */
	public void doSave(Writer writer, Map options) throws IOException {
		saveLocationBinding();
		super.doSave(writer, options);
		saveMarkers();
	}

	protected void init() {
		super.init();
		encoding = "UTF-8"; //$NON-NLS-1$
	}

	/**
	 * Saves all the markers of the current {@link Topology} if it has been associated with a
	 * workspace resource.
	 * 
	 * @throws IOException
	 *            if an IO error occurred while saving the markers.
	 * @return true if the markers were saved, false if they could not be saved.
	 */
	private boolean saveMarkers() throws IOException {
		if (!getContents().isEmpty()) {
			// There should only be one root element in the resource.
			DeployCoreRoot root = (DeployCoreRoot) getContents().get(0);
			// We only care about the topology element in the root.
			Topology topology = root.getTopology();

			if (topology != null && WorkbenchResourceHelper.getFile(topology) != null) {
				try {
					// We don't have access to a monitor at this point.
					DeployMarker.createMarkers(topology, null);
					return true;
				} catch (CoreException e) {
					e.printStackTrace();
					throw new IOWrappedException(e);
				}
			}
		}
		return false;
	}

	/**
	 * Saves the location binding for the current topology {@link Topology}.
	 * 
	 */
	private void saveLocationBinding() throws IOException {

		if (!getContents().isEmpty()) {
			// There should only be one root element in the resource.
			DeployCoreRoot root = (DeployCoreRoot) getContents().get(0);
			// We only care about the topology element in the root.
			Topology topology = root.getTopology();
			if (topology != null) {
				if (LocationBindingService.INSTANCE.isLocationBindingUsage(topology)) {
					LocationBindingService.INSTANCE.saveLocationBinding(topology);
				}
			}
		}
	}

	public EObject getEObject(String uriFragment) {
		EObject eObj = scopeService.eGetFromURI(uriFragment);

		if (eObj != null) {
			return eObj;
		}

		if (!getContents().isEmpty()) {
			// There should only be one root element in the resource.
			DeployCoreRoot root = (DeployCoreRoot) getContents().get(0);
			// We only care about the topology element in the root.
			Topology topology = root.getTopology();
			if (topology != null) {
				eObj = topology.resolve(uriFragment);
			}
		}

		return eObj != null ? eObj : super.getEObject(uriFragment);
	}

	public String getURIFragment(EObject eObject) {
		String uri = scopeService.eGetURIFragment(eObject);
		if (eObject instanceof DeployModelObject) {
			return ((DeployModelObject) eObject).getFullPath();
		}
		return uri != null ? uri : super.getURIFragment(eObject);
	}

	@Override
	public void doLoad(InputSource inputSource, Map<?, ?> options) throws IOException {
		super.doLoad(inputSource, options);
		try {
			scopeService.setContext(this);
		} catch (EditModelException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
	}

	@Override
	public void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		super.doLoad(inputStream, options);
		try {
			scopeService.setContext(this);
		} catch (EditModelException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
	}

	@Override
	protected void doUnload() {
		//Ensure the cached topology is cleared.
		topology = null;
		super.doUnload();
		try {
			scopeService.setContext(null);
		} catch (EditModelException e) {
			DeployCorePlugin.logError(0, e.getMessage(), e);
		}
//		LocationBindingService.INSTANCE.uninstall(this);
	}

} // CoreResourceImpl
