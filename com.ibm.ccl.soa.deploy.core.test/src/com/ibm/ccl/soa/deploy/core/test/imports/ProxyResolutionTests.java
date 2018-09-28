/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.imports;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.core.runtime.Assert;

public class ProxyResolutionTests extends TestCase {

	// interface type for model and proxy object
	public static interface Foo {

		public void setValue(String newValue);

		public String getValue();

		public void setBar(String newBar);

		public String getBar();
	}

	// instance of the model type
	public static class FooImpl implements Foo {

		private String value;
		private String bar;

		public void setValue(String newValue) {
			value = newValue;
		}

		public String getValue() {
			return value;
		}

		public String getBar() {
			return bar;
		}

		public void setBar(String newBar) {
			bar = newBar;
		}

		public int hashCode() {
			final int PRIME = 31;
			int result = 1;
			result = PRIME * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}

		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;

			// instanceof interface matches FooImpl and Proxy of Foo.
			if (!(obj instanceof Foo))
				return false;
			// WARNING: Cannot do this for obj to equal proxy
// if (getClass() != obj.getClass())
// return false;
			final Foo other = (Foo) obj;
			if (value == null) {
				if (other.getValue() != null)
					return false;
			} else if (!value.equals(other.getValue()))
				return false;
			return true;
		}
	}

	// Per object configuration (the instance configuration of the contract)
	public static class Configuration {

		public static Configuration create(Object obj) {
			return new Configuration(obj);
		}

		private Object configured;
		private final Map configuration = new HashMap();

		public Configuration(Object obj) {
			configured = obj;
		}

		public void configure(String key, Object value) {
			Assert.isNotNull(key);
			Assert.isTrue(key.length() > 0);

			StringBuffer methodName = new StringBuffer("get");
			methodName.append(Character.toUpperCase(key.charAt(0)));

			if (key.length() > 1)
				methodName.append(key.substring(1));

			configuration.put(methodName.toString(), value);
		}

		// deconfigure

		// set

		public Object get(String key) {
			return configuration.get(key);
		}

	}

	public class OverrideInvocationHandler implements InvocationHandler {

		private Map overrides;
		private Object instance;

		public OverrideInvocationHandler(Map overrides, Object instance) {
			this.overrides = overrides;
			this.instance = instance;
		}

		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {

			// don't get tricky for any Object.xxx methods
			if (Object.class.equals(method.getDeclaringClass())) {
				return method.invoke(instance, args);
			}

			Configuration config = (Configuration) overrides.get(instance);
			if (config != null) {
				Object override = config.get(method.getName());
				if (override != null)
					return override;
			}
			return method.invoke(instance, args);
		}

	}

	/**
	 * Create an instance of FooImpl, and override its actual field value using
	 * a configuration map.
	 * 
	 * @throws Exception
	 */
	public void testProxyApproach() throws Exception {

		final String UNSET_VALUE = "<unset value>";
		final String SET_VALUE = "Set Value";

		// create the instance set some value
		Foo instance = new FooImpl();
		instance.setValue(UNSET_VALUE);

		// construct a shareable override map; shareable amongst invocation
		// handlers
		Map overrides = new HashMap();

		// override handler must be one per instance in order to track instance
		// associated with proxy
		InvocationHandler overrideHandler = new OverrideInvocationHandler(
				overrides, instance);
		Foo fooProxy = (Foo) Proxy.newProxyInstance(instance.getClass()
				.getClassLoader(), new Class[] { Foo.class }, overrideHandler);

		assertFalse(instance == fooProxy);

		// make sure it looks and smells like the original object
		assertEquals(instance.hashCode(), fooProxy.hashCode());
		assertTrue(instance.equals(fooProxy));

		assertEquals(UNSET_VALUE, fooProxy.getValue());

		// create a configuration object, and override the value
		Configuration config = Configuration.create(instance);
		config.configure("value", SET_VALUE);
		overrides.put(instance, config);

		// ensure the value is correctly overridden
		assertEquals(SET_VALUE, fooProxy.getValue());

	}

	/**
	 * Create an instance of FooImpl, and override its actual field value using
	 * a configuration map.
	 * 
	 * @throws Exception
	 */
	public void testShareOriginalInstance() throws Exception {

		final String UNSET_VALUE = "<unset value>";
		final String ONE_VALUE = "ONE Value";

		final String TWO_VALUE = "TWO Value";

		final String HIGH = "HIGH";

		// create the instance set some value
		Foo instance = new FooImpl();
		instance.setValue(UNSET_VALUE);
		instance.setBar(HIGH);

		/** ********************* */

		// construct a shareable override map; shareable amongst invocation
		// handlers
		Map overrides = new HashMap();
		// ////// Context for Topology A
		// create a configuration object, and override the value
		Configuration config = Configuration.create(instance);
		config.configure("value", ONE_VALUE);
		overrides.put(instance, config);

		// override handler must be one per instance in order to track instance
		// associated with proxy
		InvocationHandler overrideHandler = new OverrideInvocationHandler(
				overrides, instance);
		Foo fooProxy = (Foo) Proxy.newProxyInstance(instance.getClass()
				.getClassLoader(), new Class[] { Foo.class }, overrideHandler);

		/** ********************* */

		// construct a shareable override map; shareable amongst invocation
		// handlers
		Map overrides2 = new HashMap();

		// ////// Context for Topology B
		// create a configuration object, and override the value
		Configuration config2 = Configuration.create(instance);
		config2.configure("value", TWO_VALUE);
		overrides2.put(instance, config2);

		// override handler must be one per instance in order to track instance
		// associated with proxy
		InvocationHandler overrideHandler2 = new OverrideInvocationHandler(
				overrides2, instance);
		Foo fooProxy2 = (Foo) Proxy.newProxyInstance(instance.getClass()
				.getClassLoader(), new Class[] { Foo.class }, overrideHandler2);

		/** ********************* */

		// In reference from A, value is ONE_VALUE
		// ensure the value is correctly overridden
		assertEquals(ONE_VALUE, fooProxy.getValue());
		// ensure that bar is not overridden
		assertEquals(HIGH, fooProxy.getBar());

		// In reference from B, value is TWO_VALUE
		// ensure the value is correctly overridden
		assertEquals(TWO_VALUE, fooProxy2.getValue());
		// ensure bar is not overridden
		assertEquals(HIGH, fooProxy2.getBar());

		// Original instance unchanged
		assertEquals(UNSET_VALUE, instance.getValue());
		assertEquals(HIGH, instance.getBar());

	}

	public static TestSuite suite() {
		return new TestSuite(ProxyResolutionTests.class);
	}

}
