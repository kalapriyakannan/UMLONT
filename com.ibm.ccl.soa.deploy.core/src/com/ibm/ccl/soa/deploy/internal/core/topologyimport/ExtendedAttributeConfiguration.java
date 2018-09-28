package com.ibm.ccl.soa.deploy.internal.core.topologyimport;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.InternalEObject;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Topology;

public class ExtendedAttributeConfiguration extends TypeDelegate implements IProxyConfiguration {

	private static Map CLASS_INDEXES = new HashMap();

	static {
		CLASS_INDEXES.put(ExtendedAttribute.class, new ExtendedAttributeDelegate());
	}

	private final IProxyConfiguration containerConfiguration;
	private final ExtendedAttribute attribute;

	public ExtendedAttributeConfiguration(IProxyConfiguration sourceConfiguration,
			ExtendedAttribute attr) {
		containerConfiguration = sourceConfiguration;
		attribute = attr;
	}

	public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
			throws Throwable {
		MethodHandler handler = (MethodHandler) CLASS_INDEXES.get(method.getDeclaringClass());
		if (handler != null) {
			return handler.handle(config, proxy, method, args);
		}
//		return super.handle(config, proxy, method, args);
		return method.invoke(((ExtendedAttributeConfiguration) config).getAttribute(), args);
	}

	public ExtendedAttribute getAttribute() {
		return attribute;
	}

	public EList eAdapters() {
		return containerConfiguration.eAdapters();
	}

	public boolean eDeliver() {
		return containerConfiguration.eDeliver();
	}

	public void eNotify(Notification notification) {
		containerConfiguration.eNotify(notification);
	}

	public boolean equals(Object arg0) {
		return containerConfiguration.equals(arg0);
	}

	public void eSetDeliver(boolean deliver) {
		containerConfiguration.eSetDeliver(deliver);
	}

	public int hashCode() {
		return containerConfiguration.hashCode();
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return handle(this, proxy, method, args);
	}

	public void setSource(DeployModelObject newSource) {
		containerConfiguration.setSource(newSource);
	}

	public String toString() {
		return containerConfiguration.toString();
	}

	public Import getImported() {
		return containerConfiguration.getImported();
	}

	public ProxyCacheService getService() {
		return containerConfiguration.getService();
	}

	public DeployModelObject getSource() {
		return containerConfiguration.getSource();
	}

	public IStatus addStatus(InternalEObject proxy, IStatus newStatus) {
		return containerConfiguration.addStatus(proxy, newStatus);
	}

	public void clearStatus(InternalEObject proxy, boolean withNotification) {
		containerConfiguration.clearStatus(proxy, withNotification);

	}

	public String getFullyQualifiedPath() {
		return containerConfiguration.getFullyQualifiedPath();
	}

	public IStatus getStatus() {
		return containerConfiguration.getStatus();
	}

	public Topology getEditTopology() {
		return containerConfiguration.getEditTopology();
	}

}
