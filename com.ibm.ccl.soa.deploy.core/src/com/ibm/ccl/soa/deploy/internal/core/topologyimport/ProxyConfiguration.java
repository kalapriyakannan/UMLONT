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

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.BasicNotifierImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceElement;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.extension.IProxyCacheService;

/**
 * The ProxyConfiguration manages state for a proxy that is intercepting method calls for a
 * read-only EMF model object.
 * 
 * @since 1.0
 * 
 */
public class ProxyConfiguration extends BasicNotifierImpl implements IProxyConfiguration {

	// Does this have to be "protected" access?
	/**
	 * The list of {@link org.eclipse.emf.common.notify.Adapter}s associated with the notifier.
	 */
	protected BasicEList eAdapters;

	private final ProxyCacheService service;
	private Import imported;
	private DeployModelObject source;
	private String fullPath = null;

	/** Status associated with the proxy (local copy of status). */
	private IStatus status;

	/**
	 * Create a delegate backed by the given cache service to wrap the given dmo which should be
	 * backed by the configuration in the given referenced object.
	 * 
	 * @param cacheService
	 * @param dmo
	 * @param referenced
	 */
	public ProxyConfiguration(ProxyCacheService cacheService, DeployModelObject dmo,
			Import referenced) {
		Assert.isNotNull(cacheService);
		Assert.isNotNull(dmo);
		Assert.isNotNull(referenced);
		service = cacheService;
		source = dmo;
		imported = referenced;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.internal.core.topologyimport.IProxyConfiguration#invoke(java.lang.Object,
	 *      java.lang.reflect.Method, java.lang.Object[])
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return service.getDelegateSwitch().handle(this, proxy, method, args);
	}

	public String getFullyQualifiedPath() {
		if (fullPath == null) {
			if (Proxy.isProxyClass(source.getClass())) {
				fullPath = source.getFullPath();
			} else {
				Topology topology = source.getTopology();
				String namespace = topology.getNamespace();
				StringBuffer path = new StringBuffer();
				if (namespace != null && !INamespaceElement.DEFAULT_NAMESPACE.equals(namespace)) {
					path.append(namespace).append(IConstants.DOT_SEPARATOR);
				}
				path.append(topology.getName()).append(IConstants.TOPOLOGY_SEPARATOR).append(
						source.getFullPath());
				fullPath = path.toString();
			}
		}
		return fullPath;
	}

	/**
	 * Adds a status to the proxy object.
	 * 
	 * @param proxy
	 *           the proxy object
	 * @param aNewStatus
	 *           the new status to be added.
	 * @see DeployModelObject#addStatus(IStatus)
	 */
	public IStatus addStatus(InternalEObject proxy, IStatus aNewStatus) {
		if (aNewStatus != null) {
			if (status == null) {
				status = aNewStatus;
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(proxy, Notification.SET,
							CorePackage.Literals.DEPLOY_MODEL_OBJECT__STATUS, Status.OK_STATUS, status));
				}
			} else {
				IStatus oldStatus = status;
				if (!status.isMultiStatus()) {
					status = new MultiStatus(DeployCorePlugin.PLUGIN_ID, 0, new IStatus[] { oldStatus,
							aNewStatus }, DeployCoreMessages.Model_consistency_status_message, null);
					if (eNotificationRequired()) {
						eNotify(new ENotificationImpl(proxy, Notification.ADD,
								CorePackage.Literals.DEPLOY_MODEL_OBJECT__STATUS, oldStatus, status, 1));
					}
				} else {
					MultiStatus multiStatus = (MultiStatus) status;
					int index = multiStatus.getChildren().length;
					multiStatus.add(aNewStatus);
					if (eNotificationRequired()) {
						eNotify(new ENotificationImpl(proxy, Notification.ADD,
								CorePackage.Literals.DEPLOY_MODEL_OBJECT__STATUS, oldStatus, status, index));
					}
				}
			}
		}
		return getStatus();
	}

	/**
	 * Clears the status of the proxy.
	 * 
	 * @param proxy
	 *           the proxy object.
	 * @param withNotification
	 *           true if notification should be sent to listeners.
	 * @see DeployModelObject#clearStatus()
	 */
	public void clearStatus(InternalEObject proxy, boolean withNotification) {
		IStatus oldStatus = status;
		status = null;
		if (withNotification && eNotificationRequired()) {
			eNotify(new ENotificationImpl(proxy, Notification.SET,
					CorePackage.Literals.DEPLOY_MODEL_OBJECT__STATUS, oldStatus, getStatus()));
		}
	}

	/**
	 * Returns the status of the proxy.
	 * 
	 * @param proxy
	 *           the proxy object.
	 * @return the status of the proxy (never null)
	 * @see DeployModelObject#getStatus()
	 */
	public IStatus getStatus() {
		return status == null ? Status.OK_STATUS : status;
	}

	/*
	 * @see org.eclipse.emf.common.notify.impl.BasicNotifierImpl#eAdapters()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.internal.core.topologyimport.IProxyConfiguration#eAdapters()
	 */
	public EList eAdapters() {
		if (eAdapters == null) {

			IProxyCacheService cacheService = service != null && service.getScopeService() != null ? service
					.getScopeService().getCacheService()
					: null;

			if (cacheService != null) {
				eAdapters = new EAdapterList(cacheService.findProxy(getSource(), getImported()));
			}
		}
		return eAdapters;
	}

	/*
	 * @see org.eclipse.emf.common.notify.impl.BasicNotifierImpl#eBasicAdapters()
	 */
	protected BasicEList eBasicAdapters() {
		return eAdapters;
	}

	/*
	 * @see org.eclipse.emf.common.notify.impl.BasicNotifierImpl#eDeliver()
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.internal.core.topologyimport.IProxyConfiguration#eDeliver()
	 */
	public boolean eDeliver() {
		return true;
	}

	public final ProxyCacheService getService() {
		return service;
	}

	public final DeployModelObject getSource() {
		if (source.eIsProxy()) {
			DeployModelObject resolved = service.getScopeService().resolve(getFullyQualifiedPath(),
					false);
			if (resolved != null) {
				source = resolved;
			}
		}
		return source;
	}

	public final Import getImported() {
		if (imported.getParent() == null) {
			Topology topology = getService().getScopeService().getManagingTopology();
			if (topology != null) {
				Import newImported = topology.getImport(imported.getNamespace(), imported.getPattern());
				if (newImported != null) {
					imported = newImported;
				}
			}

		}
		return imported;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.internal.core.topologyimport.IProxyConfiguration#setSource(com.ibm.ccl.soa.deploy.core.DeployModelObject)
	 */
	public void setSource(DeployModelObject newSource) {
		service.clearResults(source);
		source = newSource;
	}

	/**
	 * Returns the source of the proxied object.
	 * 
	 * @param object
	 *           an object that may be an proxy view.
	 * @return the proxy source or null if not found.
	 */
	public static Object getSource(Object object) {
		if (object == null) {
			return null;
		}
		if (!Proxy.isProxyClass(object.getClass())) {
			return null;
		}
		InvocationHandler handler = Proxy.getInvocationHandler(object);
		if (handler instanceof IProxyConfiguration) {
			return ((IProxyConfiguration) handler).getSource();
		}
		// Not our proxy!
		return null;
	}

	public Topology getEditTopology() {
		return service.getScopeService().getManagingTopology();
	}
}
