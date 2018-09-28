/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jem.util.RegistryReader;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Parse the <b>com.ibm.ccl.soa.deploy.core.topology/publisher</b> extension point into structures
 * that can be more easily manipulated.
 * 
 * @since 1.0
 * 
 */
public class TopologyManager {

	/**
	 * The singleton instance of the manager.
	 */
	public static final TopologyManager INSTANCE = new TopologyManager();

	private final Set publishers = new HashSet();
	private final Set exporters = new HashSet();
	private final Set discoverers = new HashSet();
	private final Hashtable decoratorSemantics = new Hashtable();
	private final Hashtable decoratorSemanticBindings = new Hashtable();

	/**
	 * @return The singleton instance of the TopologyManager.
	 * @deprecated Use the singleton {@link #INSTANCE}.
	 */
	public static TopologyManager getInstance() {
		return INSTANCE;
	}

	private TopologyManager() {
		new TopologyRegistry().readRegistry();
	}

	/**
	 * 
	 * 
	 * @param aTopology
	 *           A topology for export
	 * @return An array of enabled topology exporter extensions or an empty array. <b>null</b> will
	 *         never be returned.
	 */
	public TopologyExporterDescriptor[] findAvailableExporters(Topology aTopology) {
		return (TopologyExporterDescriptor[]) exporters
				.toArray(new TopologyExporterDescriptor[exporters.size()]);
	}

	private void addTopologyExporterDescriptor(TopologyExporterDescriptor element) {
		exporters.add(element);
	}

	/**
	 * 
	 * @param aTopology
	 *           A topology for export
	 * @return An array of enabled topology publisher extensions or an empty array. <b>null</b> will
	 *         never be returned.
	 */
	public TopologyPublisherDescriptor[] findAvailablePublishers(Topology aTopology) {
		return (TopologyPublisherDescriptor[]) publishers
				.toArray(new TopologyPublisherDescriptor[publishers.size()]);
	}

	private void addTopologyPublisherDescriptor(TopologyPublisherDescriptor element) {
		publishers.add(element);
	}

	/**
	 * 
	 * 
	 * @param aTopology
	 *           A topology for discovery
	 * @return An array of enabled topology discoverer extensions or an empty array. <b>null</b>
	 *         will never be returned.
	 */
	public TopologyDiscovererDescriptor[] findAvailableDiscoverers(Topology aTopology) {
		return (TopologyDiscovererDescriptor[]) discoverers
				.toArray(new TopologyDiscovererDescriptor[discoverers.size()]);
	}

	private void addTopologyDiscovererDescriptor(TopologyDiscovererDescriptor element) {
		discoverers.add(element);
	}

	/**
	 * 
	 * @return An array of enabled decoratorSemantic extensions or an empty array. <b>null</b> will
	 *         never be returned.
	 */
	public DecoratorSemanticDescriptor[] findAvailableDecoratorSemantics() {
		return (DecoratorSemanticDescriptor[]) decoratorSemantics.values().toArray(
				new DecoratorSemanticDescriptor[decoratorSemantics.size()]);
	}

	/**
	 * @param id
	 *           The id of the decorator semantic descriptor to return
	 * @return The DecoratorSemanticDescriptor matching the specified id, null if there is no match.
	 */
	public DecoratorSemanticDescriptor findDecoratorSemantic(String id) {
		return (DecoratorSemanticDescriptor) decoratorSemantics.get(id);
	}

	private void addDecoratorSemanticDescriptor(String id, DecoratorSemanticDescriptor element) {
		// Keying this hash with id for easier lookup
		if (decoratorSemantics.containsKey(id)) {
			DecoratorSemanticDescriptor existing = (DecoratorSemanticDescriptor) decoratorSemantics
					.get(id);
			String message = NLS.bind(
					DeployCoreMessages.TopologyManager_Duplicate_decoratorSemantic_ids_0_found_1_and_2,
					new Object[] { id,
							existing.getElement().getDeclaringExtension().getNamespaceIdentifier(),
							element.getElement().getDeclaringExtension().getNamespaceIdentifier() });
			DeployCorePlugin.logError(0, message, null);
			return;
		}

		decoratorSemantics.put(id, element);
	}

	/**
	 * 
	 * @return An array of all decorator semantic pattern binding extensions or an empty array.
	 *         <b>null</b> will never be returned.
	 */
	public DecoratorSemanticPatternBindingDescriptor[] findAvailableDecoratorSemanticPatternBindings() {
		List allDescs = new ArrayList();
		Iterator it = decoratorSemanticBindings.values().iterator();
		while (it.hasNext()) {
			List descs = (List) it.next();
			if (descs != null) {
				allDescs.addAll(descs);
			}
		}

		return (DecoratorSemanticPatternBindingDescriptor[]) allDescs
				.toArray(new DecoratorSemanticPatternBindingDescriptor[allDescs.size()]);

	}

	/**
	 * @param decoratorSemanticId
	 *           The id of the decorator semantic descriptor to which to find pattern bindings
	 * @return The DecoratorSemanticDescriptor matching the specified id, null if there is no match.
	 */
	public DecoratorSemanticPatternBindingDescriptor[] findDecoratorSemanticPatternBindings(
			String decoratorSemanticId) {
		List descList = (List) decoratorSemanticBindings.get(decoratorSemanticId);
		if (descList != null) {
			return (DecoratorSemanticPatternBindingDescriptor[]) descList
					.toArray(new DecoratorSemanticPatternBindingDescriptor[descList.size()]);
		}

		return null;
	}

	private void addDecoratorSemanticPatternBindingDescriptor(String decoratorSemanticId,
			DecoratorSemanticPatternBindingDescriptor element) {
		List descs = (List) decoratorSemanticBindings.get(decoratorSemanticId);
		if (descs == null) {
			descs = new ArrayList();
		}
		descs.add(element);
		decoratorSemanticBindings.put(decoratorSemanticId, descs);
	}

	/**
	 * Does the low level work of parsing the Eclipse registry.
	 * 
	 * @since 1.0
	 * 
	 */
	private class TopologyRegistry extends RegistryReader implements ICommonDeployExtensionConstants {

		private TopologyRegistry() {
			super(DeployCorePlugin.PLUGIN_ID, TAG_TOPOLOGY);
		}

		public boolean readElement(IConfigurationElement element) {
			if (TAG_PUBLISHER.equals(element.getName())) {
				addTopologyPublisherDescriptor(new TopologyPublisherDescriptor(element));
				return true;
			} else if (TAG_DISCOVERER.equals(element.getName())) {
				addTopologyDiscovererDescriptor(new TopologyDiscovererDescriptor(element));
				return true;
			} else if (TAG_EXPORTER.equals(element.getName())) {
				addTopologyExporterDescriptor(new TopologyExporterDescriptor(element));
				return true;
			} else if (TAG_DECORATOR_SEMANTIC.equals(element.getName())) {
				DecoratorSemanticDescriptor ds = new DecoratorSemanticDescriptor(element);
				addDecoratorSemanticDescriptor(ds.getId(), ds);
				return true;
			} else if (TAG_DECORATOR_SEMANTIC_PATTERN_BINDING.equals(element.getName())) {
				DecoratorSemanticPatternBindingDescriptor ds = new DecoratorSemanticPatternBindingDescriptor(
						element);
				addDecoratorSemanticPatternBindingDescriptor(ds.getDecoratorSemanticId(), ds);
				return true;
			}
			// the other tag from the .topology extension
			return false;
		}

	}
}
