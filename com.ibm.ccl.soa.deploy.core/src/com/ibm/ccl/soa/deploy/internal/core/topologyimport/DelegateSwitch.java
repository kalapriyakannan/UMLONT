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

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * A DelegateSwitch intercepts calls from an invocation handler, identifies the declaring class, and
 * then delegates the call to a {@link TypeDelegate}.
 * 
 * @since 1.0
 * 
 */
public class DelegateSwitch extends MethodHandler {

	private static Map CLASS_INDEXES = new HashMap();

	static {
		CLASS_INDEXES.put(Notifier.class, new NotifierDelegate());
		CLASS_INDEXES.put(EObject.class, new EObjectDelegate());
		CLASS_INDEXES.put(InternalEObject.class, new InternalEObjectDelegate());
		CLASS_INDEXES.put(Object.class, new ObjectDelegate());
		CLASS_INDEXES.put(DeployModelObject.class, new DeployModelObjectDelegate());
		CLASS_INDEXES.put(Unit.class, new UnitDelegate());
		CLASS_INDEXES.put(Requirement.class, new RequirementDelegate());
		CLASS_INDEXES.put(ExtendedAttribute.class, new ExtendedAttributeDelegate());
		CLASS_INDEXES.put(Topology.class, new TopologyDelegate());
	}

	/**
	 * Create a Switch to handle method invocations against known declaring classes.
	 */
	public DelegateSwitch() {
	}

	public Object handle(IProxyConfiguration config, Object proxy, Method method, Object[] args)
			throws Throwable {
		MethodHandler handler = (MethodHandler) CLASS_INDEXES.get(method.getDeclaringClass());
		if (handler != null) {
			return handler.handle(config, proxy, method, args);
		}
		return super.handle(config, proxy, method, args);
	}

}
