/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.impl;

import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

import org.eclipse.emf.ecore.EObject;

import com.ibm.ccl.soa.deploy.core.Artifact;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitLink;
import com.ibm.ccl.soa.deploy.core.util.FilterIterator;
import com.ibm.ccl.soa.deploy.core.util.IObjectFilter;

/**
 * Iterates over the topology returning objects of the desired type.
 * <p>
 * Attempts to perform an efficient traversal. In the future, should be replaced with an indexed
 * lookup service.
 * <p>
 * Topology objects can be filtered by type:
 * <ul>
 * <li> {@link #UNIT}: All {@link Unit} instances,
 * <li> {@link #CAPABILITY}: All provided {@link Capability} instances,
 * <li> {@link #REQUIREMENT}:All consumed {@link Requirement} instances,
 * <li> {@link #REQUIREMENT_EXPRESSION}:All {@link RequirementExpression} instances,
 * <li> {@link #UNIT_LINK}:All {@link UnitLink} instances,
 * <li> {@link #CONSTRAINT_LINK}:All {@link ConstraintLink} instances,
 * <li> {@link #DEPENDENCY_LINK}:All {@link DependencyLink} instances.
 * <li> {@link #REALIZATION_LINK}:All {@link RealizationLink} instances,
 * <li> {@link #ARTIFACT}:All {@link Artifact} instances,
 * </ul>
 */
public class TopologyFilterIterator implements Iterator {

	public class ContainerFilter implements IObjectFilter {
		final protected EObject container;

		public ContainerFilter(EObject container) {
			this.container = container;
		}

		public boolean accept(Object value) {
			if (value instanceof EObject) {
				return container.equals(((EObject) value).eContainer());
			}
			// TODO Auto-generated method stub
			return false;
		}

	}

	/** Filters all {@link Unit} instances. */
	public static final int UNIT = 2;

	/** Filters all provided {@link Capability} instances. */
	public static final int CAPABILITY = 4;

	/** Filters all consumed {@link Requirement} instances. */
	public static final int REQUIREMENT = 8;

	/** Filters all {@link UnitLink} links. */
	public static final int UNIT_LINK = 16;

	/** Filters all {@link ConstraintLink} links. */
	public static final int CONSTRAINT_LINK = 32;

	/** Filters all {@link DependencyLink} links. */
	public static final int DEPENDENCY_LINK = 64;

	/** Filters all {@link RequirementExpression} links. */
	public static final int REQUIREMENT_EXPRESSION = 512;

	/** Filters all {@link Artifact} instances. */
	public static final int ARTIFACT = 1024;

	/** Filters all {@link RealizationLink} instances. */
	public static final int REALIZATION_LINK = 2048;

	/** Filters all {@link DeployLink} links. */
	public static final int DEPLOY_LINK = UNIT_LINK | CONSTRAINT_LINK | DEPENDENCY_LINK
			| REALIZATION_LINK;

	/** Stack of unit iterators (used for searching down unit containment). */
	protected final Stack unitIterStack = new Stack();

	/** Type of filtering performed. */
	protected final int filterType;

	/** The topology being iterated over. */
	protected final Topology topology;

	/** Iterator over the provided Capabilities set of the current unit. */
	protected Iterator providesCapabilityIter = null;

	/** Iterator over the requirements the current unit. */
	protected Iterator requirementIter = null;

	/** Iterator over the requirement expressions the current unit. */
	protected Iterator requirementExpressionIter = null;

	/** Iterator over the hosting links of the current unit. */
	protected Iterator unitLinkIter = null;

	/** Iterator over the constraint links of the current unit. */
	protected Iterator constraintLinkIter = null;

	/** Iterator over artifacts contained in a unit. */
	protected Iterator artifactIter = null;

	/** Iterator over realization links contained in a unit. */
	protected Iterator realizationLinkIter = null;

	/** Iterator over dependency links contained in the topology. */
	protected Iterator topologyDependencyLinkIter = null;

	/** Iterator over unit links contained in the topology. */
	protected Iterator topologyUnitLinkIter = null;

	/** Iterator over constraint links contained in the topology. */
	protected Iterator topologyConstraintLinkIter = null;

	/** Iterator over realization links contained in the topology. */
	protected Iterator topologyRealizationLinkIter = null;

	/** Next object to be returned (look-ahead). */
	protected DeployModelObject next = null;

	/**
	 * Constructs an iterator over all instances of the specified type contained directly, or
	 * indirectly in the topology.
	 * 
	 * @param topology
	 *           the topology to be recursively iterated over.
	 * @param type
	 *           one of {@link #DEPLOY_MODEL_OBJECT}, {@link #UNIT}, {@link #CAPABILITY},
	 *           {@link #REQUIREMENT}, {@link #UNIT_LINK}, {@link #DEPENDENCY_LINK},
	 *           {@link #CONSTRAINT_LINK}, {@link REQUIREMENT_EXPRESSION}, {@link ARTIFACT},
	 *           {@link REALIZATION_LINK}.
	 */
	public TopologyFilterIterator(Topology topology, int type) {
		assert topology != null;
		this.topology = topology;
		filterType = type;

		// Topology contained links.
		if (showUnitLink() && !topology.getUnitLinks().isEmpty()) {
			topologyUnitLinkIter = topology.getUnitLinks().iterator();
		}
		if (showConstraintLink() && !topology.getConstraintLinks().isEmpty()) {
			topologyConstraintLinkIter = topology.getConstraintLinks().iterator();
		}
		if (showDependencyLink() && !topology.getDependencyLinks().isEmpty()) {
			topologyDependencyLinkIter = topology.getDependencyLinks().iterator();
		}
		if (showRealizationLink() && !topology.getRealizationLinks().isEmpty()) {
			topologyRealizationLinkIter = topology.getRealizationLinks().iterator();
		}

		// Units and unit-contained objects
		unitIterStack.add(topology.getUnits().iterator());
	}

	/**
	 * @return true if units are returned.
	 */
	public boolean showUnit() {
		return (filterType & UNIT) != 0;
	}

	/**
	 * @return true if unit artifacts are returned.
	 */
	public boolean showArtifact() {
		return (filterType & ARTIFACT) != 0;
	}

	/**
	 * @return true if provided capabilities are returned.
	 */
	public boolean showProvidedCapabilities() {
		return (filterType & CAPABILITY) != 0;
	}

	/**
	 * @return true if consumed requirements are returned.
	 */
	public boolean showRequirement() {
		return (filterType & REQUIREMENT) != 0;
	}

	/**
	 * @return true if unit links are returned.
	 */
	public boolean showUnitLink() {
		return (filterType & UNIT_LINK) != 0;
	}

	/**
	 * @return true if unit links are returned.
	 */
	public boolean showConstraintLink() {
		return (filterType & CONSTRAINT_LINK) != 0;
	}

	/**
	 * @return true if dependency links are returned.
	 */
	public boolean showDependencyLink() {
		return (filterType & DEPENDENCY_LINK) != 0;
	}

	/**
	 * @return true if realization links are returned.
	 */
	public boolean showRealizationLink() {
		return (filterType & REALIZATION_LINK) != 0;
	}

	/**
	 * @return true if requirement expressions are returned.
	 */
	public boolean showRequirementExpressions() {
		return (filterType & REQUIREMENT_EXPRESSION) != 0;
	}

	public boolean hasNext() {
		if (next != null) {
			return true;
		}

		// topology contained links
		if (topologyUnitLinkIter != null && showUnitLink() && topologyUnitLinkIter.hasNext()) {
			next = (UnitLink) topologyUnitLinkIter.next();
			return true;
		}
		if (topologyConstraintLinkIter != null && showConstraintLink()
				&& topologyConstraintLinkIter.hasNext()) {
			next = (ConstraintLink) topologyConstraintLinkIter.next();
			return true;
		}
		if (topologyDependencyLinkIter != null && showDependencyLink()
				&& topologyDependencyLinkIter.hasNext()) {
			next = (DependencyLink) topologyDependencyLinkIter.next();
			return true;
		}
		if (topologyRealizationLinkIter != null && showRealizationLink()
				&& topologyRealizationLinkIter.hasNext()) {
			next = (RealizationLink) topologyRealizationLinkIter.next();
			return true;
		}

		// unit contained objects.
		if (setUnitNext()) {
			return true;
		}

		// return next unit at current depth (if it exists)
		while (unitIterStack.size() > 0) {
			Iterator unitIter = (Iterator) unitIterStack.peek();
			while (unitIter.hasNext()) {
				Unit unit = (Unit) unitIter.next();
				boolean isProxyUnit = Proxy.isProxyClass(unit.getClass());

				if (showRequirement() || showRequirementExpressions() || showDependencyLink()) {
					requirementIter = unit.getRequirements().iterator();
				}

				requirementExpressionIter = null;

				if (showProvidedCapabilities()) {
					providesCapabilityIter = unit.getCapabilities().iterator();
				}

				if (showArtifact()) {
					artifactIter = unit.getArtifacts().iterator();
				}

				if (showUnitLink()) {
					unitLinkIter = unit.getUnitLinks().iterator();
					// TODO Temporary measure to deal with the fact that proxies
					// try to be smart on us and return top-level links as well
					if (isProxyUnit && unitLinkIter.hasNext()) {
						unitLinkIter = new FilterIterator(unitLinkIter, new ContainerFilter(unit));
					}
				}

				if (showRealizationLink()) {
					realizationLinkIter = unit.getRealizationLinks().iterator();
					// TODO Temporary measure to deal with the fact that proxies
					// try to be smart on us and return top-level links as well
					if (isProxyUnit && realizationLinkIter.hasNext()) {
						realizationLinkIter = new FilterIterator(realizationLinkIter,
								new ContainerFilter(unit));
					}
				}

				if (showConstraintLink()) {
					constraintLinkIter = unit.getConstraintLinks().iterator();
					// TODO Temporary measure to deal with the fact that proxies
					// try to be smart on us and return top-level links as well
					if (isProxyUnit && constraintLinkIter.hasNext()) {
						constraintLinkIter = new FilterIterator(constraintLinkIter, new ContainerFilter(
								unit));
					}
				}

				if (showUnit()) {
					next = unit;
					return true;
				}

				// Skip unit
				if (showArtifact() && artifactIter != null && artifactIter.hasNext()) {
					next = (Artifact) artifactIter.next();
					return true;
				}

				if (showUnitLink() && unitLinkIter != null && unitLinkIter.hasNext()) {
					next = (UnitLink) unitLinkIter.next();
					return true;
				}

				if (showRealizationLink() && realizationLinkIter != null
						&& realizationLinkIter.hasNext()) {
					next = (RealizationLink) realizationLinkIter.next();
					return true;
				}

				if (showRealizationLink() && constraintLinkIter != null && constraintLinkIter.hasNext()) {
					next = (ConstraintLink) constraintLinkIter.next();
					return true;
				}

				if (setUnitNext()) {
					return true;
				}

				next = null;
			}
			unitIterStack.pop();
		}

		return false;
	}

	/**
	 * Sets the next value to be returned for objects contained in the current unit.
	 * 
	 * @return true if a value was found and set, false otherwise.
	 */
	private boolean setUnitNext() {
		// return next artifact (if applicable)
		if (showArtifact() && artifactIter != null && artifactIter.hasNext()) {
			next = (Artifact) artifactIter.next();
			return true;
		}

		// return next unit link (if it exists)
		if (showUnitLink() && unitLinkIter != null && unitLinkIter.hasNext()) {
			next = (UnitLink) unitLinkIter.next();
			return true;
		}

		// return next realization link (if it exists)
		if (showRealizationLink() && topologyRealizationLinkIter != null
				&& topologyRealizationLinkIter.hasNext()) {
			next = (RealizationLink) topologyRealizationLinkIter.next();
			return true;
		}

		// return next requiremente expression (if it exists)
		if (showRequirementExpressions()) {
			if (requirementExpressionIter != null && requirementExpressionIter.hasNext()) {
				next = (RequirementExpression) requirementExpressionIter.next();
				return true;
			}
		}
		// return next consumed requirement (if it exists)
		if (showRequirement() || showRequirementExpressions()) {
			while (requirementIter != null && requirementIter.hasNext()) {
				Requirement req = (Requirement) requirementIter.next();
				requirementExpressionIter = req.getExpressions().iterator();
				if (showRequirement()) {
					next = req;
					return true;
				}
				if (requirementExpressionIter.hasNext()) {
					next = (RequirementExpression) requirementExpressionIter.next();
					return true;
				}
			}
		} else if (showDependencyLink()) {
			// return dependency link of a requirement (when requirements are
			// returned this is handled by getNext()).
			while (requirementIter != null && requirementIter.hasNext()) {
				Requirement req = (Requirement) requirementIter.next();
				// TODO temporary check for container
				if (req.getLink() != null && req.getLink().eContainer() == req) {
					next = req.getLink();
					return true;
				}
			}
		}

		// return next provided capability (if it exists)
		if (showProvidedCapabilities() && providesCapabilityIter != null
				&& providesCapabilityIter.hasNext()) {
			next = (Capability) providesCapabilityIter.next();
			return true;
		}

		// return next artifact (if applicable)
		if (showArtifact() && artifactIter != null && artifactIter.hasNext()) {
			next = (Artifact) artifactIter.next();
			return true;
		}

		// return next unit link (if it exists)
		if (showUnitLink() && unitLinkIter != null && unitLinkIter.hasNext()) {
			next = (UnitLink) unitLinkIter.next();
			return true;
		}

		// return next realization link (if it exists)
		if (showRealizationLink() && realizationLinkIter != null && realizationLinkIter.hasNext()) {
			next = (RealizationLink) realizationLinkIter.next();
			return true;
		}

		// return next logical link (if it exists)
		if (showConstraintLink() && constraintLinkIter != null && constraintLinkIter.hasNext()) {
			next = (ConstraintLink) constraintLinkIter.next();
			return true;
		}

		return false;
	}

	/*
	 * @see java.util.Iterator#next()
	 */
	public Object next() {
		// force calculation of the next property
		if (!hasNext()) {
			throw new NoSuchElementException();
		}

		Object result = next;

		// capabilities and requirements may be followed by its link (if it
		// exists)
		if (result instanceof Requirement && showDependencyLink()) {
			next = ((Requirement) result).getLink();
		} else {
			next = null;
		}

		return result;
	}

	/*
	 * @see java.util.Iterator#remove()
	 */
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
