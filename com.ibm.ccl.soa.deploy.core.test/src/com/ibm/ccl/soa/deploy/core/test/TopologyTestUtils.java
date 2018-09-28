/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.ProxyConfiguration;

/**
 * Static {@link Topology} test utility methods.
 */
public final class TopologyTestUtils {

	private TopologyTestUtils() {
		// static methods only
	}

	/**
	 * Recursively invokes all methods on the topology and all its contained
	 * units, asserting that all DMOs returned are proxies, or are writable
	 * objects.
	 * 
	 * @param top
	 *            an imported topology.
	 */
	public static void assertAllTopologyMethodsReturnProxyObjects(Topology top) {
		assert top != null : "null topology argument";

		/** Set of methods that returned non-proxied DMOs. */
		Set badMethods = new LinkedHashSet();

		// Check topology methods
		internalAddMethodsReturningNonProxyDMOs(top, badMethods);

		// Check methods on all contained DMOs (recursive)
		for (Iterator iter = top.findLocalDeployModelObjects(); iter.hasNext();) {
			DeployModelObject dmo = (DeployModelObject) iter.next();
			internalAddMethodsReturningNonProxyDMOs(dmo, badMethods);
		}

		if (badMethods.size() == 0) {
			// No bad methods found!
			return;
		}

		//
		// Report error: sort methods and create message
		//
		List list = new ArrayList(badMethods);
		Collections.sort(list, new Comparator() {
			public int compare(Object arg0, Object arg1) {
				Method m1 = (Method) arg0;
				Method m2 = (Method) arg1;
				if (m1.getDeclaringClass() == m2.getDeclaringClass()) {
					return m1.getName().compareTo(m1.getName());
				}
				return m1.getDeclaringClass().getName().compareTo(
						m2.getDeclaringClass().getName());

			}

		});

		StringBuffer message = new StringBuffer();
		message
				.append("The following methods returned non-proxied objects in methods:\r\n");
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Method method = (Method) iter.next();
			message.append(method);
			message.append('\r');
			message.append('\n');
		}

		throw new RuntimeException(message.toString());
	}

	/**
	 * Returns true if the object is a proxy object.
	 * 
	 * @param object
	 *            a Java object (may be null).
	 * @return true if the object is a proxy object.
	 */
	public static boolean isProxy(Object object) {
		if (object == null) {
			return false;
		}
		return Proxy.isProxyClass(object.getClass());
	}

	/**
	 * Returns true if the object is a proxy or editable.
	 * 
	 * @param object
	 *            an object.
	 * @return true if the object is a proxy or editable.
	 */
	public static boolean isProxyOrEditable(Object object) {
		if (isProxy(object)) {
			return true;
		}
		if (object instanceof DeployModelObject) {
			return true;
		}
		DeployModelObject dmo = (DeployModelObject) object;
		Topology top = dmo.getTopology();
		if (top == null) {
			return true;
		}

		// TODO there must be a better way to find out if we have a writable
		// scribler
		try {
			String description = dmo.getDescription();
			dmo.setDescription(TopologyTestUtils.class.getName());
			dmo.setDescription(description);
			return true;
		} catch (Throwable e) {
			return false;
		}
	}

	/**
	 * Collects all object methods which return a DMO that is not a proxy.
	 * 
	 * @param dmo
	 *            a deploy model object.
	 * @param badMethods
	 *            the set of methods returning invalid objects.
	 */
	private static void internalAddMethodsReturningNonProxyDMOs(
			DeployModelObject dmo, Set badMethods) {
		assert Proxy.isProxyClass(dmo.getClass()) : dmo;
		Method[] methods = dmo.getClass().getMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			if ((method.getParameterTypes().length == 0)
					&& (!method.getName().startsWith("unset"))
					&& (EObject.class.isAssignableFrom(method
							.getDeclaringClass()))
					&& (method.getReturnType() != null)
					&& (method.getReturnType() != Void.class)) {
				Object result = null;
				try {
					result = method.invoke(dmo, null);
				} catch (InvocationTargetException e) {
					System.err.println("Error invoking method "
							+ method.getName() + " on object " + dmo.getName()
							+ " of type " + dmo.eClass().getName());
					e.getCause().printStackTrace();
				} catch (RuntimeException e) {
					System.err.println("Error invoking method "
							+ method.getName() + " on object " + dmo.getName()
							+ " of type " + dmo.eClass().getName());
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// ok to ignore
				}

				if (result == null) {
					// ignore
				} else if (result instanceof DeployModelObject) {
					if (!isProxyOrEditable(result)) {
						badMethods.add(method);
						break;
					}
				} else if (result instanceof Collection) {
					Collection c = (Collection) result;
					for (Iterator iter = c.iterator(); iter.hasNext();) {
						Object obj = iter.next();
						if (obj instanceof DeployModelObject) {
							if (!isProxyOrEditable(obj)) {
								badMethods.add(method);
								break;
							}
						}
					}
				} else if (result instanceof Iterator) {
					Iterator iter = (Iterator) result;
					while (iter.hasNext()) {
						Object obj = iter.next();
						if (obj instanceof DeployModelObject) {
							if (!isProxyOrEditable(obj)) {
								badMethods.add(method);
								break;
							}
						}
					}
				} else if (result.getClass().isArray()) {
					Object[] array = (Object[]) result;
					for (int a = 0; a < array.length; a++) {
						if (array[a] instanceof DeployModelObject) {
							if (!isProxyOrEditable(array[a])) {
								badMethods.add(method);
								break;
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Returns the topology which imported the topology.
	 * 
	 * @param top
	 *            a topology.
	 * @return the topology which imported the topology, or null if not
	 *         imported.
	 */
	public static Topology getImporter(Topology top) {
		return (Topology) ProxyConfiguration.getSource(top);
	}
}
