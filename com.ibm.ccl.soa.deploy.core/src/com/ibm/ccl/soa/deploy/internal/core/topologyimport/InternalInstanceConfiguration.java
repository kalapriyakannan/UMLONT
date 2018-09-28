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

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.Instantiation;

/**
 * Defines an internal contract between the Import and InstanceConfiguration.
 * 
 * <p>
 * This interface is not part of the public API and should not be called by clients outside of the
 * model.
 * </p>
 * 
 * @since 1.0
 * 
 */
public interface InternalInstanceConfiguration extends InstanceConfiguration {

	/**
	 * A special designation for the {@link Instantiation}s which models the imported Topology.
	 */
	String GLOBAL_CONFIGURATION = "__GlobalConfiguration"; //$NON-NLS-1$

	/**
	 * Inform the instanceconfiguration that the scope service that it's attached to may have
	 * changed.
	 */
	public void updateScopeService();

	/**
	 * Return the Configuration Contract of the Imported Topology.
	 * 
	 * @return The Configuration Contract of the Imported Topology.
	 */
	public ConfigurationContract getImportedContract();

	/**
	 * Create an instantiation for the given source, using the given referenced URI, and name.
	 * 
	 * @param source
	 *           The source that we are logically instantiating.
	 * @return The Instantiation that should manage augmented information about the instantiated
	 *         version of the source.
	 */
	public Instantiation createInstantiation(DeployModelObject source);

	/**
	 * Create an instantiation for the given source, using the given referenced URI, and name.
	 * 
	 * @param source
	 *           The source that we are logically instantiating.
	 * @param referenced
	 *           The relative URI for the referenced DeployModelObject.
	 * @return The Instantiation that should manage augmented information about the instantiated
	 *         version of the source.
	 */
	public Instantiation createInstantiation(DeployModelObject source, String referenced);

	/**
	 * Create an instantiation for the given source, using the given referenced URI, and name.
	 * 
	 * @param source
	 *           The source that we are logically instantiating.
	 * @param referenced
	 *           The relative URI for the referenced DeployModelObject.
	 * @param name
	 *           The name of the property (e.g. feature name of the EClass).
	 * @return The Instantiation that should manage augmented information about the instantiated
	 *         version of the source.
	 */
	public Instantiation createInstantiation(DeployModelObject source, String referenced, String name);

	/**
	 * Retrieve the instantiation for the given name, if available or null otherwise.
	 * 
	 * @param name
	 *           The name of the property (e.g. feature name of the EClass).
	 * @return The Instantiation that should manage augmented information about the instantiated
	 *         version of the source.
	 */
	public Instantiation getInstantiationByName(String name);

	public Object lookupConfiguredValue(DeployModelObject source, String field);

	public ConfigurationContract getImportedContract(InternalScopeService scopeService);

	public List getVisibleUnits(InternalScopeService scopeService, Import imported,
			List<String> visited);

	public EList buildConfiguredList(InternalScopeService scopeService, Import importedSource,
			IProxyConfiguration config, EStructuralFeature feature, EList originalContents);

}
