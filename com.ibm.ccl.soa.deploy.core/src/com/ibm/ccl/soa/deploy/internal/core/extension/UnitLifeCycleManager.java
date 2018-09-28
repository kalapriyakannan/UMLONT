/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jem.util.RegistryReader;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.UnitAmplifier;
import com.ibm.ccl.soa.deploy.core.UnitDiscoverer;
import com.ibm.ccl.soa.deploy.core.UnitFilter;
import com.ibm.ccl.soa.deploy.core.UnitProvider;

/**
 * Parse the <b>com.ibm.ccl.soa.deploy.core.unitLifecycle</b> extension point into structures that
 * can be more easily manipulated.
 * 
 * @since 1.0
 * 
 */
public class UnitLifeCycleManager implements ICommonDeployExtensionConstants {

	/**
	 * The singleton instance of the manager.
	 */
	public static final UnitLifeCycleManager INSTANCE = new UnitLifeCycleManager();

	private static final UnitDiscovererDescriptor[] NO_ELEMENTS_UNIT_DISCOVERER = new UnitDiscovererDescriptor[0];

	private static final UnitAmplifierDescriptor[] NO_ELEMENTS_UNIT_AMPLIFIERS = new UnitAmplifierDescriptor[0];

	private static final UnitFilterDescriptor[] NO_ELEMENTS_UNIT_FILTER = new UnitFilterDescriptor[0];

	private static final UnitProviderDescriptor[] NO_ELEMENTS_UNIT_PROVIDER = new UnitProviderDescriptor[0];

	private final Set<UnitProviderDescriptor> unitProviders = new HashSet<UnitProviderDescriptor>();

	private final Set<UnitDiscovererDescriptor> unitDiscoverers = new HashSet<UnitDiscovererDescriptor>();

	private final Set<UnitFilterDescriptor> unitFilters = new HashSet<UnitFilterDescriptor>();

	private final Set<UnitAmplifierDescriptor> unitAmplifiers = new HashSet<UnitAmplifierDescriptor>();

	private Map<String, UnitProviderDescriptor> unitProvidersById = null;

	private Map<String, UnitProviderDescriptor> unitProvidersByName = null;

	/**
	 * @return The singleton instance of the UnitLifeCycleManager.
	 * @deprecated Use the singleton {@link #INSTANCE}.
	 */
	public static UnitLifeCycleManager getInstance() {
		return INSTANCE;
	}

	private UnitLifeCycleManager() {
		new UnitLifeCycleRegistry().readRegistry();
	}

	public UnitAmplifierDescriptor[] findEnabledTopologyUnitAmplifiersByInputOnly(
			Object aPotentialUnit) {

		List<UnitAmplifierDescriptor> enabledAmplifiers = new ArrayList<UnitAmplifierDescriptor>();

		UnitAmplifierDescriptor descriptor;
		for (Iterator<UnitAmplifierDescriptor> elementsItr = unitAmplifiers.iterator(); elementsItr
				.hasNext();) {
			descriptor = elementsItr.next();
			if (descriptor.isEnabledForInputOnly(aPotentialUnit)) {
				enabledAmplifiers.add(descriptor);
			}
		}

		if (enabledAmplifiers.size() == 0) {
			return NO_ELEMENTS_UNIT_AMPLIFIERS;
		}

		return enabledAmplifiers.toArray(new UnitAmplifierDescriptor[enabledAmplifiers.size()]);

	}

	/**
	 * Search for extensions that may be able to provide useful information about the given argument.
	 * The return type from this method ({@link UnitAmplifierDescriptor} allows clients to create
	 * instances of {@link UnitAmplifier}s that can provide information about
	 * <code>aPotentialTopologyUnit</code>. Clients are required to instantiate and manage the
	 * lifecyle of the instance of {@link UnitAmplifier}.
	 * 
	 * 
	 * @param aPotentialUnit
	 *           An object that may be or may be adaptable to a topology Unit.
	 * @return An array of enabled topology Unit Amplifier extensions or an empty array. <b>null</b>
	 *         will never be returned.
	 */
	public UnitAmplifierDescriptor[] findEnabledTopologyUnitAmplifiersByOutputOnly(
			Object aPotentialUnit) {
		List<UnitAmplifierDescriptor> enabledAmplifiers = new ArrayList<UnitAmplifierDescriptor>();

		UnitAmplifierDescriptor descriptor;
		for (Iterator<UnitAmplifierDescriptor> elementsItr = unitAmplifiers.iterator(); elementsItr
				.hasNext();) {
			descriptor = elementsItr.next();
			if (descriptor.isEnabledForOutputOnly(aPotentialUnit)) {
				enabledAmplifiers.add(descriptor);
			}
		}
		if (enabledAmplifiers.size() == 0) {
			return NO_ELEMENTS_UNIT_AMPLIFIERS;
		}
		return enabledAmplifiers.toArray(new UnitAmplifierDescriptor[enabledAmplifiers.size()]);

	}

	/**
	 * Search for extensions that may be able to provide useful information about the given argument.
	 * The return type from this method ({@link UnitProviderDescriptor} allows clients to create
	 * instances of {@link UnitProvider}s that can provide information about
	 * <code>aPotentialTopologyUnit</code>. Clients are required to instantiate and manage the
	 * lifecyle of the instance of {@link UnitProvider}.
	 * 
	 * 
	 * @param aInputObject
	 *           an input object
	 * @param aOutputObject
	 *           an output object
	 * @return An array of enabled topology Unit Amplifier extensions or an empty array. <b>null</b>
	 *         will never be returned.
	 */
	public UnitAmplifierDescriptor[] findEnabledTopologyUnitAmplifiersByInputAndOutput(
			Object aInputObject, Object aOutputObject) {
		List<UnitAmplifierDescriptor> enabledProviders = new ArrayList<UnitAmplifierDescriptor>();

		UnitAmplifierDescriptor descriptor;
		for (Iterator<UnitAmplifierDescriptor> elementsItr = unitAmplifiers.iterator(); elementsItr
				.hasNext();) {
			descriptor = elementsItr.next();
			if (descriptor.isEnabledForInputAndOutput(aInputObject, aOutputObject)) {
				enabledProviders.add(descriptor);
			}
		}
		if (enabledProviders.size() == 0) {
			return NO_ELEMENTS_UNIT_AMPLIFIERS;
		}
		return enabledProviders.toArray(new UnitAmplifierDescriptor[enabledProviders.size()]);

	}

	/**
	 * Search for extensions that may be able to provide useful information about the given argument.
	 * The return type from this method ({@link UnitDiscovererDescriptor} allows clients to create
	 * instances of {@link UnitDiscoverer}s that can provide information about
	 * <code>aPotentialTopologyUnit</code>. Clients are required to instantiate and manage the
	 * lifecyle of the instance of {@link UnitDiscoverer}.
	 * 
	 * 
	 * @param aPotentialUnit
	 *           An object that may be or may be adaptable to a topology Unit.
	 * @return An array of enabled topology Unit Discoverer extensions or an empty array. <b>null</b>
	 *         will never be returned.
	 */
	public UnitDiscovererDescriptor[] findEnabledTopologyUnitDiscoverersByInputOnly(
			Object aPotentialUnit) {

		List<UnitDiscovererDescriptor> enabledDiscoverers = new ArrayList<UnitDiscovererDescriptor>();

		UnitDiscovererDescriptor descriptor;
		for (Iterator<UnitDiscovererDescriptor> elementsItr = unitDiscoverers.iterator(); elementsItr
				.hasNext();) {
			descriptor = elementsItr.next();
			if (descriptor.isEnabledForInputOnly(aPotentialUnit)) {
				enabledDiscoverers.add(descriptor);
			}
		}

		if (enabledDiscoverers.size() == 0) {
			return NO_ELEMENTS_UNIT_DISCOVERER;
		}

		return enabledDiscoverers.toArray(new UnitDiscovererDescriptor[enabledDiscoverers.size()]);

	}

	/**
	 * Search for extensions that may be able to provide useful information about the given argument.
	 * The return type from this method ({@link UnitDiscovererDescriptor} allows clients to create
	 * instances of {@link UnitDiscoverer}s that can provide information about
	 * <code>aPotentialTopologyUnit</code>. Clients are required to instantiate and manage the
	 * lifecyle of the instance of {@link UnitDiscoverer}.
	 * 
	 * 
	 * @param aPotentialUnit
	 *           An object that may be or may be adaptable to a topology Unit.
	 * @return An array of enabled topology Unit Discoverer extensions or an empty array. <b>null</b>
	 *         will never be returned.
	 */
	public UnitDiscovererDescriptor[] findEnabledTopologyUnitDiscoverersByOutputOnly(
			Object aPotentialUnit) {
		List<UnitDiscovererDescriptor> enabledDiscoverers = new ArrayList<UnitDiscovererDescriptor>();

		UnitDiscovererDescriptor descriptor;
		for (Iterator<UnitDiscovererDescriptor> elementsItr = unitDiscoverers.iterator(); elementsItr
				.hasNext();) {
			descriptor = elementsItr.next();
			if (descriptor.isEnabledForOutputOnly(aPotentialUnit)) {
				enabledDiscoverers.add(descriptor);
			}
		}
		if (enabledDiscoverers.size() == 0) {
			return NO_ELEMENTS_UNIT_DISCOVERER;
		}
		return enabledDiscoverers.toArray(new UnitDiscovererDescriptor[enabledDiscoverers.size()]);

	}

	/**
	 * Search for extensions that may be able to provide useful information about the given argument.
	 * The return type from this method ({@link UnitProviderDescriptor} allows clients to create
	 * instances of {@link UnitProvider}s that can provide information about
	 * <code>aPotentialTopologyUnit</code>. Clients are required to instantiate and manage the
	 * lifecyle of the instance of {@link UnitProvider}.
	 * 
	 * 
	 * @param aInputObject
	 *           an input object
	 * @param aOutputObject
	 *           an output object
	 * @return An array of enabled topology Unit Discoverer extensions or an empty array. <b>null</b>
	 *         will never be returned.
	 */
	public UnitDiscovererDescriptor[] findEnabledTopologyUnitDiscoverersByInputAndOutput(
			Object aInputObject, Object aOutputObject) {
		List<UnitDiscovererDescriptor> enabledProviders = new ArrayList<UnitDiscovererDescriptor>();

		UnitDiscovererDescriptor descriptor;
		for (Iterator<UnitDiscovererDescriptor> elementsItr = unitDiscoverers.iterator(); elementsItr
				.hasNext();) {
			descriptor = elementsItr.next();
			if (descriptor.isEnabledForInputAndOutput(aInputObject, aOutputObject)) {
				enabledProviders.add(descriptor);
			}
		}
		if (enabledProviders.size() == 0) {
			return NO_ELEMENTS_UNIT_DISCOVERER;
		}
		return enabledProviders.toArray(new UnitDiscovererDescriptor[enabledProviders.size()]);

	}

	private void addUnitDiscovererDescriptor(UnitDiscovererDescriptor element) {
		unitDiscoverers.add(element);
	}

	/**
	 * Search for extensions that may be able to provide useful information about the given argument.
	 * The return type from this method ({@link UnitFilterDescriptor} allows clients to create
	 * instances of {@link UnitFilter}s that can provide information about
	 * <code>aPotentialTopologyUnit</code>. Clients are required to instantiate and manage the
	 * lifecyle of the instance of {@link UnitFilter}.
	 * 
	 * 
	 * @param aPotentialUnit
	 *           An object that may be or may be adaptable to a topology Unit.
	 * @return An array of enabled topology Unit Filter extensions or an empty array. <b>null</b>
	 *         will never be returned.
	 */
	public UnitFilterDescriptor[] findEnabledTopologyUnitFiltersByInputOnly(Object aPotentialUnit) {
		List<UnitFilterDescriptor> enabledFilters = new ArrayList<UnitFilterDescriptor>();

		for (Iterator<UnitFilterDescriptor> elementsItr = unitFilters.iterator(); elementsItr
				.hasNext();) {
			UnitFilterDescriptor descriptor = elementsItr.next();
			if (descriptor.isEnabledForInputOnly(aPotentialUnit)) {
				enabledFilters.add(descriptor);
			}
		}
		if (enabledFilters.size() == 0) {
			return NO_ELEMENTS_UNIT_FILTER;
		}
		return enabledFilters.toArray(new UnitFilterDescriptor[enabledFilters.size()]);

	}

	/**
	 * Search for extensions that may be able to provide useful information about the given argument.
	 * The return type from this method ({@link UnitFilterDescriptor} allows clients to create
	 * instances of {@link UnitFilter}s that can provide information about
	 * <code>aPotentialTopologyUnit</code>. Clients are required to instantiate and manage the
	 * lifecyle of the instance of {@link UnitFilter}.
	 * 
	 * 
	 * @param aPotentialUnit
	 *           An object that may be or may be adaptable to a topology Unit.
	 * @return An array of enabled topology Unit Filter extensions or an empty array. <b>null</b>
	 *         will never be returned.
	 */
	public UnitFilterDescriptor[] findEnabledTopologyUnitFiltersByOutputOnly(Object aPotentialUnit) {
		List<UnitFilterDescriptor> enabledFilters = new ArrayList<UnitFilterDescriptor>();

		for (Iterator<UnitFilterDescriptor> elementsItr = unitFilters.iterator(); elementsItr
				.hasNext();) {
			UnitFilterDescriptor descriptor = elementsItr.next();
			if (descriptor.isEnabledForOutputOnly(aPotentialUnit)) {
				enabledFilters.add(descriptor);
			}
		}

		if (enabledFilters.size() == 0) {
			return NO_ELEMENTS_UNIT_FILTER;
		}

		return enabledFilters.toArray(new UnitFilterDescriptor[enabledFilters.size()]);

	}

	/**
	 * Search for extensions that may be able to provide useful information about the given argument.
	 * The return type from this method ({@link UnitProviderDescriptor} allows clients to create
	 * instances of {@link UnitProvider}s that can provide information about
	 * <code>aPotentialTopologyUnit</code>. Clients are required to instantiate and manage the
	 * lifecyle of the instance of {@link UnitProvider}.
	 * 
	 * 
	 * @param aInputObject
	 *           an input object
	 * @param aOutputObject
	 *           an output object
	 * @return An array of enabled topology Unit Discoverer extensions or an empty array. <b>null</b>
	 *         will never be returned.
	 */
	public UnitFilterDescriptor[] findEnabledTopologyUnitFiltersByInputAndOutput(
			Object aInputObject, Object aOutputObject) {
		List<UnitFilterDescriptor> enabledProviders = new ArrayList<UnitFilterDescriptor>();

		for (Iterator<UnitFilterDescriptor> elementsItr = unitFilters.iterator(); elementsItr
				.hasNext();) {
			UnitFilterDescriptor descriptor = elementsItr.next();
			if (descriptor.isEnabledForInputAndOutput(aInputObject, aOutputObject)) {
				enabledProviders.add(descriptor);
			}
		}

		if (enabledProviders.size() == 0) {
			return NO_ELEMENTS_UNIT_FILTER;
		}

		return enabledProviders.toArray(new UnitFilterDescriptor[enabledProviders.size()]);

	}

	private void addUnitFilterDescriptor(UnitFilterDescriptor element) {
		unitFilters.add(element);
	}

	/**
	 * Search for extensions that may be able to provide useful information about the given argument.
	 * The return type from this method ({@link UnitProviderDescriptor} allows clients to create
	 * instances of {@link UnitProvider}s that can provide information about
	 * <code>aPotentialTopologyUnit</code>. Clients are required to instantiate and manage the
	 * lifecyle of the instance of {@link UnitProvider}.
	 * 
	 * 
	 * @param aPotentialUnit
	 *           An object that may be or may be adaptable to a topology Unit.
	 * @return An array of enabled topology Unit Provider extensions or an empty array. <b>null</b>
	 *         will never be returned.
	 */
	public UnitProviderDescriptor[] findEnabledTopologyUnitProvidersByInputOnly(Object aPotentialUnit) {
		List<UnitProviderDescriptor> enabledProviders = new ArrayList<UnitProviderDescriptor>();

		for (Iterator<UnitProviderDescriptor> elementsItr = unitProviders.iterator(); elementsItr
				.hasNext();) {
			UnitProviderDescriptor descriptor = elementsItr.next();
			if (descriptor.isEnabledForInputOnly(aPotentialUnit)) {
				enabledProviders.add(descriptor);
			}
		}

		if (enabledProviders.size() == 0) {
			return NO_ELEMENTS_UNIT_PROVIDER;
		}

		return enabledProviders.toArray(new UnitProviderDescriptor[enabledProviders.size()]);

	}

	/**
	 * Search for extensions that may be able to provide useful information about the given argument.
	 * The return type from this method ({@link UnitProviderDescriptor} allows clients to create
	 * instances of {@link UnitProvider}s that can provide information about
	 * <code>aPotentialTopologyUnit</code>. Clients are required to instantiate and manage the
	 * lifecyle of the instance of {@link UnitProvider}.
	 * 
	 * 
	 * @param aObject
	 *           A Unit
	 * @return An array of enabled topology Unit Provider extensions or an empty array. <b>null</b>
	 *         will never be returned.
	 */
	public UnitProviderDescriptor[] findEnabledTopologyUnitProvidersByOutputOnly(Object aObject) {
		List<UnitProviderDescriptor> enabledProviders = new ArrayList<UnitProviderDescriptor>();

		for (Iterator<UnitProviderDescriptor> elementsItr = unitProviders.iterator(); elementsItr
				.hasNext();) {
			UnitProviderDescriptor descriptor = elementsItr.next();
			if (descriptor.isEnabledForOutputOnly(aObject)) {
				enabledProviders.add(descriptor);
			}
		}

		if (enabledProviders.size() == 0) {
			return NO_ELEMENTS_UNIT_PROVIDER;
		}

		return enabledProviders.toArray(new UnitProviderDescriptor[enabledProviders.size()]);

	}

	/**
	 * Search for extensions that may be able to provide useful information about the given argument.
	 * The return type from this method ({@link UnitProviderDescriptor} allows clients to create
	 * instances of {@link UnitProvider}s that can provide information about
	 * <code>aPotentialTopologyUnit</code>. Clients are required to instantiate and manage the
	 * lifecyle of the instance of {@link UnitProvider}.
	 * 
	 * 
	 * @param aInputObject
	 *           an input object
	 * @param aOutputObject
	 *           an output object
	 * @return An array of enabled topology Unit Provider extensions or an empty array. <b>null</b>
	 *         will never be returned.
	 */
	public UnitProviderDescriptor[] findEnabledTopologyUnitProvidersByInputAndOutput(
			Object aInputObject, Object aOutputObject) {
		List<UnitProviderDescriptor> enabledProviders = new ArrayList<UnitProviderDescriptor>();

		for (Iterator<UnitProviderDescriptor> elementsItr = unitProviders.iterator(); elementsItr
				.hasNext();) {
			UnitProviderDescriptor descriptor = elementsItr.next();
			if (descriptor.isEnabledForInputAndOutput(aInputObject, aOutputObject)) {
				enabledProviders.add(descriptor);
			}
		}

		if (enabledProviders.size() == 0) {
			return NO_ELEMENTS_UNIT_PROVIDER;
		}

		return enabledProviders.toArray(new UnitProviderDescriptor[enabledProviders.size()]);

	}

	/**
	 * Search for extensions that may be able to provide useful information about the given argument.
	 * The return type from this method ({@link UnitProviderDescriptor} allows clients to create
	 * instances of {@link UnitProvider}s that can provide information about
	 * <code>aPotentialTopologyUnit</code>. Clients are required to instantiate and manage the
	 * lifecyle of the instance of {@link UnitProvider}.
	 * 
	 * 
	 * @param aPotentialUnit
	 *           An object that may be or may be adaptable to a topology Unit.
	 * @param decoratorSemanticId
	 *           the decorator semantic to be used to restrict the result
	 * @return An array of enabled topology Unit Provider extensions or an empty array. <b>null</b>
	 *         will never be returned.
	 */
	public UnitProviderDescriptor[] findEnabledTopologyUnitProvidersByInputOnly(
			Object aPotentialUnit, String decoratorSemanticId) {
		List<UnitProviderDescriptor> enabledProviders = new ArrayList<UnitProviderDescriptor>();

		for (Iterator<UnitProviderDescriptor> elementsItr = unitProviders.iterator(); elementsItr
				.hasNext();) {
			UnitProviderDescriptor descriptor = elementsItr.next();
			if (descriptor.isEnabledForInputOnly(aPotentialUnit)
			/*
			 * && DecoratorSemanticService.INSTANCE.isUnitProviderMemberOf(decoratorSemanticId,
			 * descriptor.getClassAttribute())
			 */) {
				enabledProviders.add(descriptor);
			}
		}

		if (enabledProviders.size() == 0) {
			return NO_ELEMENTS_UNIT_PROVIDER;
		}

		return enabledProviders.toArray(new UnitProviderDescriptor[enabledProviders.size()]);

	}

	/**
	 * Search for extensions that may be able to provide useful information about the given argument.
	 * The return type from this method ({@link UnitProviderDescriptor} allows clients to create
	 * instances of {@link UnitProvider}s that can provide information about
	 * <code>aPotentialTopologyUnit</code>. Clients are required to instantiate and manage the
	 * lifecyle of the instance of {@link UnitProvider}.
	 * 
	 * 
	 * @param aObject
	 *           A Unit
	 * @param decoratorSemanticId
	 *           the decorator semantic to be used to restrict the result
	 * @return An array of enabled topology Unit Provider extensions or an empty array. <b>null</b>
	 *         will never be returned.
	 */
	public UnitProviderDescriptor[] findEnabledTopologyUnitProvidersByOutputOnly(Object aObject,
			String decoratorSemanticId) {
		List<UnitProviderDescriptor> enabledProviders = new ArrayList<UnitProviderDescriptor>();

		for (Iterator<UnitProviderDescriptor> elementsItr = unitProviders.iterator(); elementsItr
				.hasNext();) {
			UnitProviderDescriptor descriptor = elementsItr.next();
			if (descriptor.isEnabledForOutputOnly(aObject)
			/*
			 * && DecoratorSemanticService.INSTANCE.isUnitProviderMemberOf(decoratorSemanticId,
			 * descriptor.getClassAttribute())
			 */) {
				enabledProviders.add(descriptor);
			}
		}

		if (enabledProviders.size() == 0) {
			return NO_ELEMENTS_UNIT_PROVIDER;
		}

		return enabledProviders.toArray(new UnitProviderDescriptor[enabledProviders.size()]);

	}

	/**
	 * Search for extensions that may be able to provide useful information about the given argument.
	 * The return type from this method ({@link UnitProviderDescriptor} allows clients to create
	 * instances of {@link UnitProvider}s that can provide information about
	 * <code>aPotentialTopologyUnit</code>. Clients are required to instantiate and manage the
	 * lifecyle of the instance of {@link UnitProvider}.
	 * 
	 * 
	 * @param aInputObject
	 *           an input object
	 * @param aOutputObject
	 *           an output object
	 * @param decoratorSemanticId
	 *           the decorator semantic to be used to restrict the result
	 * @return An array of enabled topology Unit Provider extensions or an empty array. <b>null</b>
	 *         will never be returned.
	 */
	public UnitProviderDescriptor[] findEnabledTopologyUnitProvidersByInputAndOutput(
			Object aInputObject, Object aOutputObject, String decoratorSemanticId) {
		List<UnitProviderDescriptor> enabledProviders = new ArrayList<UnitProviderDescriptor>();

		for (Iterator<UnitProviderDescriptor> elementsItr = unitProviders.iterator(); elementsItr
				.hasNext();) {
			UnitProviderDescriptor descriptor = elementsItr.next();
			if (descriptor.isEnabledForInputAndOutput(aInputObject, aOutputObject)
			/*
			 * && DecoratorSemanticService.INSTANCE.isUnitProviderMemberOf(decoratorSemanticId,
			 * descriptor.getClassAttribute())
			 */) {
				enabledProviders.add(descriptor);
			}
		}

		if (enabledProviders.size() == 0) {
			return NO_ELEMENTS_UNIT_PROVIDER;
		}

		return enabledProviders.toArray(new UnitProviderDescriptor[enabledProviders.size()]);

	}

	private void loadUnitProvidersByIdMap() {
		unitProvidersById = new HashMap<String, UnitProviderDescriptor>();
		for (Iterator<UnitProviderDescriptor> elementsItr = unitProviders.iterator(); elementsItr
				.hasNext();) {
			UnitProviderDescriptor descriptor = elementsItr.next();
			String classId = descriptor.getElement().getAttribute(ATT_CLASS);
			unitProvidersById.put(classId, descriptor);
		}
	}

	private void loadUnitProvidersByNameMap() {
		unitProvidersByName = new HashMap<String, UnitProviderDescriptor>();
		for (Iterator<UnitProviderDescriptor> elementsItr = unitProviders.iterator(); elementsItr
				.hasNext();) {
			UnitProviderDescriptor descriptor = elementsItr.next();
			String name = descriptor.getName();
			unitProvidersByName.put(name, descriptor);
		}
	}

	/**
	 * Return the unit provider descriptor with the specified ID, which is the class attribute in
	 * this case. Potential conflict if two providers in different unitLifecycle extensions have the
	 * same fully-qualified classname
	 * 
	 * @param id
	 * @return the corresponding UnitProviderDescriptor
	 */
	public UnitProviderDescriptor getUnitProviderDescriptor(String id) {
		if (unitProvidersById == null) {
			loadUnitProvidersByIdMap();
		}
		return unitProvidersById.get(id);
	}

	/**
	 * Return the unit provider with the specified name. Potential conflict if two providers in
	 * different unitLifecycle extensions have the same name
	 * 
	 * @param name
	 * @return the corresponding UnitProvider
	 */
	public UnitProvider getUnitProviderByName(String name) {
		if (unitProvidersByName == null) {
			loadUnitProvidersByNameMap();
		}
		UnitProviderDescriptor desc = unitProvidersByName.get(name);

		if (desc != null) {
			return desc.createUnitProvider();
		}
		return null;
	}

	private void addUnitProviderDescriptor(UnitProviderDescriptor element) {
		unitProviders.add(element);
	}

	private void addUnitAmplifierDescriptor(UnitAmplifierDescriptor element) {
		unitAmplifiers.add(element);
	}

	/**
	 * Does the low level work of parsing the Eclipse registry.
	 * 
	 * @since 1.0
	 * 
	 */
	private class UnitLifeCycleRegistry extends RegistryReader implements
			ICommonDeployExtensionConstants {

		private UnitLifeCycleRegistry() {
			super(DeployCorePlugin.PLUGIN_ID, TAG_UNIT_LIFECYCLE);
		}

		public boolean readElement(IConfigurationElement element) {
			if (TAG_UNIT_DISCOVERER.equals(element.getName())) {
				addUnitDiscovererDescriptor(new UnitDiscovererDescriptor(element));
				return true;
			} else if (TAG_UNIT_FILTER.equals(element.getName())) {
				addUnitFilterDescriptor(new UnitFilterDescriptor(element));
				return true;
			} else if (TAG_UNIT_PROVIDER.equals(element.getName())) {
				addUnitProviderDescriptor(new UnitProviderDescriptor(element));
				return true;
			} else if (TAG_UNIT_AMPLIFIER.equals(element.getName())) {
				addUnitAmplifierDescriptor(new UnitAmplifierDescriptor(element));
				return true;
			}
			return false;
		}

	}
} // end class UnitLifeCycleManager
