/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator;

import java.util.Iterator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.FilterIterator;
import com.ibm.ccl.soa.deploy.core.util.IObjectFilter;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;

/**
 * Default implementation of the validation context.
 */
public class DeployValidationContext implements IDeployValidationContext {

	/**
	 * The topology context of the validation.
	 */
	protected final Topology topology;

	/**
	 * The validator service instance.
	 */
	protected final DeployValidatorService service;

	/**
	 * Monitors validation progress (never null).
	 */
	protected IProgressMonitor progressMonitor;

	/**
	 * Constructs a validation context over the specified topology.
	 * 
	 * @param topology
	 *           the topology context.
	 * @param service
	 *           the validation service instance.
	 * @param monitor
	 *           the validation progress monitor (may be null).
	 */
	public DeployValidationContext(Topology topology, DeployValidatorService service,
			IProgressMonitor monitor) {
		assert topology != null;
		this.topology = topology;
		this.service = service;
		if (monitor == null) {
			progressMonitor = new NullProgressMonitor();
		} else {
			progressMonitor = monitor;
		}
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext#getTopology()
	 */
	public Topology getTopology() {
		return topology;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext#getDeployValidatorService()
	 */
	public DeployValidatorService getDeployValidatorService() {
		return service;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext#getProgressMonitor()
	 */
	public IProgressMonitor getProgressMonitor() {
		return progressMonitor;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext#getAllUnits(org.eclipse.emf.ecore.EPackage)
	 */
	public Iterator findAllUnits(final EPackage domain) {
		assert domain != null;
		// TODO support more efficient indexing
		return new FilterIterator(topology.findAllUnits(), new IObjectFilter() {
			public boolean accept(Object value) {
				if (!(value instanceof Unit)) {
					return false;
				}
				Unit unit = (Unit) value;
				EClass eClass = unit.getEObject().eClass();
				return eClass.eContainer() == domain;
			}
		});
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext#getAllUnits(org.eclipse.emf.ecore.EClass)
	 */
	public Iterator findAllUnits(EClass type) {
		// TODO support more efficient indexing
		return new FilterIterator(topology.findAllUnits(), new TypeObjectFilter(type));
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext#getAllServiceLinks(org.eclipse.emf.ecore.EClass)
	 */
	public Iterator findAllDependencyLinksBySourceType(final EClass sourceClass) {
		assert sourceClass != null;
		// TODO support more efficient indexing
		return new FilterIterator(topology.findAllDependencyLinks(), new IObjectFilter() {
			public boolean accept(Object value) {
				DependencyLink link = (DependencyLink) value;
				Requirement source = link.getSource();
				Requirement reqSource = link.getSource();
				if (source != null) {
					// TODO improve efficiency
					EClass type = source.getDmoEType();
					if (type == null) {
						return false;
					}
					// MK 4/16/2005 modified
					// return type.isSuperTypeOf(sourceClass);
					return sourceClass.isSuperTypeOf(type);
				}
				if (reqSource == null) {
					return false;
				}
				return sourceClass.isSuperTypeOf(reqSource.getDmoEType());
			}
		});
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext#getAllServiceLinksByTargetType(org.eclipse.emf.ecore.EClass)
	 */
	public Iterator findAllDependencyLinksByTargetType(final EClass targetClass) {
		assert targetClass != null;
		// TODO support more efficient indexing
		return new FilterIterator(topology.findAllDependencyLinks(), new IObjectFilter() {
			public boolean accept(Object value) {
				DependencyLink link = (DependencyLink) value;
				Capability target = link.getTarget();
				if (target == null) {
					return false;
				}
				return targetClass.isSuperTypeOf(target.getEObject().eClass());
			}
		});
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext#getAllServiceLinksByEndpointTypes(org.eclipse.emf.ecore.EClass,
	 *      org.eclipse.emf.ecore.EClass)
	 */
	public Iterator findAllDependencyLinksByEndpointTypes(final EClass sourceClass,
			final EClass targetClass) {
		// TODO support more efficient indexing
		return new FilterIterator(findAllDependencyLinksBySourceType(sourceClass),
				new IObjectFilter() {
					public boolean accept(Object value) {
						DependencyLink link = (DependencyLink) value;
						Capability target = link.getTarget();
						if (target == null) {
							return false;
						}
						return targetClass.isSuperTypeOf(target.getEObject().eClass());
					}
				});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext#findAllHostingLinksByServiceType(org.eclipse.emf.ecore.EClass)
	 */
	public Iterator findAllHostingLinksByCapabilityType(final EClass sourceClass) {
		assert sourceClass != null;
		// TODO support more efficient indexing
		return new FilterIterator(topology.findAllHostingLinks(), new IObjectFilter() {
			public boolean accept(Object value) {
				HostingLink link = (HostingLink) value;
				if (link.getHosted() == null) {
					return false;
				}

				for (Iterator iter = link.getHosted().getRequirements().iterator(); iter.hasNext();) {
					Requirement req = (Requirement) iter.next();
					if (req != null && sourceClass.isSuperTypeOf(req.getDmoEType())) {
						return true;
					}
				}
				return false;
			}
		});
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext#getAllServices(org.eclipse.emf.ecore.EClass)
	 */
	public Iterator findAllCapabilities(EClass type) {
		// TODO support more efficient indexing
		return new FilterIterator(topology.findAllCapabilities(), new TypeObjectFilter(type));
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext#getAllProvidedServices(org.eclipse.emf.ecore.EClass)
	 */
	public Iterator findAllNonHostingCapabilities(EClass type) {
		// TODO support more efficient indexing
		return new FilterIterator(topology.findAllNonHostingCapabilities(),
				new TypeObjectFilter(type));
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext#getAllProvidedHostingServices(org.eclipse.emf.ecore.EClass)
	 */
	public Iterator findAllHostingCapabilities(EClass type) {
		// TODO support more efficient indexing
		return new FilterIterator(topology.findAllHostingCapabilities(), new TypeObjectFilter(type));
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext#getAllLogicalLinks()
	 */
	public Iterator findAllConstraintLinks() {
		return topology.findAllConstraintLinks();
	}

}
