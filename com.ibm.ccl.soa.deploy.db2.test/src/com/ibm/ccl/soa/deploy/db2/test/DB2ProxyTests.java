/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.core.runtime.Assert;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.impl.InstanceConfigurationImpl;
import com.ibm.ccl.soa.deploy.db2.DB2DatabaseUnit;
import com.ibm.ccl.soa.deploy.db2.DB2Instance;
import com.ibm.ccl.soa.deploy.db2.Db2Factory;
import com.ibm.ccl.soa.deploy.db2.Db2Package;
import com.ibm.ccl.soa.deploy.db2.UnixDB2Instance;
import com.ibm.ccl.soa.deploy.internal.core.extension.IProxyCacheService;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.ProxyCacheService;

/**
 * Tests the constants associated with the {@link Db2Package} deploy domain.
 */
public class DB2ProxyTests extends TestCase {

	public void testClassReflection() {
		DB2Instance instance = Db2Factory.eINSTANCE.createDB2Instance();

		Class clazz = instance.getClass();
		System.out.println("Classname: " + clazz.getName());
		Class[] interfaces = clazz.getInterfaces();
		for (int i = 0; i < interfaces.length; i++) {
			System.out.println("Intf[" + i + "]: " + interfaces[i].getName());
		}

		UnixDB2Instance unixDb2 = Db2Factory.eINSTANCE.createUnixDB2Instance();

		Class unixclazz = unixDb2.getClass();
		System.out.println("Classname: " + unixclazz.getName());
		Class[] unixinterfaces = unixclazz.getInterfaces();
		for (int i = 0; i < unixinterfaces.length; i++) {
			System.out.println("Intf[" + i + "]: "
					+ unixinterfaces[i].getName());
		}

		Class[] declaredClasses = unixclazz.getClasses();
		for (int i = 0; i < declaredClasses.length; i++) {
			System.out.println("Declared..[" + i + "]: " + declaredClasses[i]);
		}

	}

	public void testProxyConfigurationZeroOutDegree() throws Exception {

		final String NOTSET_HOSTNAME = "<not set>";
		final String EXPECTED_HOSTNAME = "www.dole96.com";

		IProxyCacheService service = ProxyCacheService.create();

		DB2Instance instance = Db2Factory.eINSTANCE.createDB2Instance();
		instance.setHostname(NOTSET_HOSTNAME);

		Import imported = CoreFactory.eINSTANCE.createImport();

		InstanceConfiguration instanceConfig = new DefaultConfiguration();

		imported.setInstanceConfiguration(instanceConfig);

		DB2Instance proxy = (DB2Instance) service.findProxy(instance, imported);

		proxy.setHostname(EXPECTED_HOSTNAME);

		assertEquals(EXPECTED_HOSTNAME, proxy.getHostname());

		assertEquals(NOTSET_HOSTNAME, instance.getHostname());
	}

	public void testProxyConfigurationFirstOutDegree() throws Exception {

		final String NOTSET_HOSTNAME = "<not set>";
		final String EXPECTED_HOSTNAME = "www.dole96.com";

		IProxyCacheService service = ProxyCacheService.create();

		DB2DatabaseUnit database = Db2Factory.eINSTANCE.createDB2DatabaseUnit();

		DB2Instance instance = Db2Factory.eINSTANCE.createDB2Instance();
		database.getCapabilities().add(instance);
		instance.setHostname(NOTSET_HOSTNAME);

		Import imported = CoreFactory.eINSTANCE.createImport();

		InstanceConfiguration instanceConfig = new DefaultConfiguration();

		imported.setInstanceConfiguration(instanceConfig);

		DB2DatabaseUnit proxy = (DB2DatabaseUnit) service.findProxy(database,
				imported);

		DB2Instance instanceProxy = (DB2Instance) proxy.getCapabilities()
				.get(0);

		instanceProxy.setHostname(EXPECTED_HOSTNAME);

		assertEquals(EXPECTED_HOSTNAME, instanceProxy.getHostname());

		assertEquals(NOTSET_HOSTNAME, instance.getHostname());
	}

	public static class DefaultConfiguration extends InstanceConfigurationImpl
			implements InstanceConfiguration {

		private final Map configurationMaps = new HashMap();

		public synchronized void configure(DeployModelObject source,
				String field, Object value) {
			Assert.isNotNull(field);
			Assert.isTrue(field.length() > 0);

			Map configuration = (Map) configurationMaps.get(source);
			if (configuration == null)
				configurationMaps.put(source, configuration = new HashMap());
			configuration.put(field, value);
		}

		// deconfigure

		// set

		public synchronized Object getConfiguredValue(DeployModelObject source,
				String fieldName) {
			Map configuration = (Map) configurationMaps.get(source);
			if (configuration != null)
				return configuration.get(fieldName);
			return null;
		}

		public List getPublicEditableUnits() {
			// TODO Auto-generated method stub
			return null;
		}

		public List getPublicUnits() {
			// TODO Auto-generated method stub
			return null;
		}

		public boolean isConfigurable(Unit unit) {
			// TODO Auto-generated method stub
			return false;
		}

	};
}
