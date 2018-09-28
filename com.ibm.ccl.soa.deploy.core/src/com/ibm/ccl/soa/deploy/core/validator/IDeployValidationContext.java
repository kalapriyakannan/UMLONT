/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator;

import java.util.Iterator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Topology;

/**
 * The context on which the {@link DomainValidator} has been invoked.
 * <p>
 * Currently the context is limited to the topology. In the future, the context may offer indexed
 * lookups and other services.
 */
public interface IDeployValidationContext {

	/**
	 * Returns the topology over which the domain validator should evaluato.
	 * 
	 * @return the topology to be validated.
	 */
	public Topology getTopology();

	/**
	 * Returns the validator service which invoked this domain validator.
	 * 
	 * @return the validator service.
	 */
	public DeployValidatorService getDeployValidatorService();

	/**
	 * Returns the progress monitor for the validation.
	 * 
	 * @return the progress monitor (never null).
	 */
	public IProgressMonitor getProgressMonitor();

	/**
	 * Returns an iterator over all units in the topology which are instances of a type in the
	 * domain.
	 * 
	 * @param domain
	 *           a SOA deploy domain extension.
	 * @return Iterator<Unit>
	 */
	public Iterator findAllUnits(EPackage domain);

	/**
	 * Returns an iterator over all units directly or indirectly contained in the topology of the
	 * specified type.
	 * 
	 * @param type
	 *           the type of the unit.
	 * @return Iterator<Unit>
	 */
	public Iterator findAllUnits(EClass type);

	/**
	 * Returns an iterator over all capabilities in the topology which are instances of the
	 * capability type.
	 * 
	 * @param type
	 *           a subtype of {@link Capability}.
	 * 
	 * @return Iterator<Capability>
	 */
	public Iterator findAllCapabilities(EClass type);

	/**
	 * Returns an iterator over all non-hosting capabilities in the topology which are instances of
	 * the capability type.
	 * 
	 * @param type
	 *           a subtype of {@link Capability}.
	 * 
	 * @return Iterator<Capability>
	 */
	public Iterator findAllNonHostingCapabilities(EClass type);

	/**
	 * Returns an iterator over all provided hosting capabilities in the topology which are instances
	 * of the capability type.
	 * 
	 * @param type
	 *           a subtype of {@link Capability}.
	 * 
	 * @return Iterator<Capability>
	 */
	public Iterator findAllHostingCapabilities(EClass type);

	/**
	 * Returns an iterator over all the dependency links whose source is a subtype of the type.
	 * 
	 * @param sourceClass
	 *           the type of the link's source.
	 * @return Iterator<DependencyLink>
	 */
	public Iterator findAllDependencyLinksBySourceType(EClass sourceClass);

	/**
	 * Returns an iterator over all the dependency links whose target is a subtype of the type.
	 * 
	 * @param targetClass
	 *           the type of the link's target.
	 * @return Iterator<DependencyLink>
	 */
	public Iterator findAllDependencyLinksByTargetType(EClass targetClass);

	/**
	 * Returns an iterator over all the dependency links whose source is a subtype of the type.
	 * 
	 * @param sourceClass
	 *           the type of the link's source.
	 * @param targetClass
	 *           the type of the link's target.
	 * @return Iterator<DependencyLink>
	 */
	public Iterator findAllDependencyLinksByEndpointTypes(EClass sourceClass, EClass targetClass);

	/**
	 * Returns an iterator over all the hosting links whose hostee consumes a capability that is a
	 * subtype of the capability class.
	 * 
	 * @param capabilityClass
	 *           a capability class.
	 * @return Iterator<HostingLink>
	 */
	public Iterator findAllHostingLinksByCapabilityType(final EClass capabilityClass);

	/**
	 * Returns an iterator over all the logical links.
	 * 
	 * @return Iterator<LogicalLink>
	 */
	public Iterator findAllConstraintLinks();
}
