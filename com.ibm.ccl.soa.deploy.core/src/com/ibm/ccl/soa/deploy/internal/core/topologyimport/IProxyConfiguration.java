package com.ibm.ccl.soa.deploy.internal.core.topologyimport;

import java.lang.reflect.InvocationHandler;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.InternalEObject;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Topology;

/**
 * Defines a common set of methods used by our custom InvocationHandlers.
 * 
 */
public interface IProxyConfiguration extends InvocationHandler, Notifier {

	/**
	 * The cache service manages reusable instances of the imported Units.
	 * 
	 * @return The associated caching service
	 */
	ProxyCacheService getService();

	/**
	 * The Import associated with the source Unit; may be a Proxy or be contained in a read-only
	 * Topology
	 * 
	 * @return
	 */
	Import getImported();

	/**
	 * The original non-proxy source object
	 * 
	 * @return
	 */
	DeployModelObject getSource();

	void setSource(DeployModelObject newSource);

	String getFullyQualifiedPath();

	/**
	 * Return the associated editable Topology.
	 * 
	 * @return the associated editable Topology.
	 */
	public Topology getEditTopology();

//	/**
//	 * Return the associated editable {@link InstanceConfiguration}.
//	 * 
//	 * @return the associated editable {@link InstanceConfiguration}.
//	 */
//	public InstanceConfiguration getEditableConfiguration();

	/**
	 * Adds a status to the proxy object.
	 * 
	 * @param proxy
	 *           the proxy object
	 * @param aNewStatus
	 *           the new status to be added.
	 * @return the status of the proxy (never null)
	 * @see DeployModelObject#addStatus(IStatus)
	 */
	IStatus addStatus(InternalEObject proxy, IStatus aNewStatus);

	/**
	 * Returns the status of the proxy.
	 * 
	 * @param proxy
	 *           the proxy object.
	 * @return the status of the proxy (never null)
	 * @see DeployModelObject#getStatus()
	 */
	IStatus getStatus();

	/**
	 * Clears the status of the proxy.
	 * 
	 * @param proxy
	 *           the proxy object.
	 * @param withNotification
	 *           true if notification should be sent to listeners.
	 * @see DeployModelObject#clearStatus()
	 */
	void clearStatus(InternalEObject proxy, boolean withNotification);

}