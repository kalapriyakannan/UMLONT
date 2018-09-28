/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator.resolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.FilterIterator;
import com.ibm.ccl.soa.deploy.core.util.IObjectFilter;
import com.ibm.ccl.soa.deploy.core.util.ObjectTypeFilter;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeValueStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.StatusIterator;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 */
public class RealizeAllConceptualUnitsInTopologyResolution extends DeployResolution {

	/**
	 * Default number of iterations of validation and resolution (to break cycles).
	 */
	public final static int DEFAULT_MAX_PASS_COUNT = 100;

	/**
	 * Filters instances of {@link IDeployAttributeValueStatus}.
	 * 
	 * @see FilterIterator
	 */
	public static final IObjectFilter DEPLOY_ATTRIBUTE_VALUE_STATUS_FILTER = new ObjectTypeFilter(
			IDeployAttributeValueStatus.class, true);
	public static final IObjectFilter CONCEPTUAL_UNIT_NOT_REALIZED_FILTER = new ObjectTypeFilter(
			IDeployAttributeValueStatus.class, true);

	/**
	 * Maximum number of validate/resolve iterations.
	 */
	protected int maxPassCount = DEFAULT_MAX_PASS_COUNT;

	/**
	 * Construct a deploy resolution for the specified status and generator.
	 * 
	 * @param context
	 *           the context of the deploy resolution.
	 * @param generator
	 *           the generator used to create this status.
	 */
	public RealizeAllConceptualUnitsInTopologyResolution(IDeployResolutionContext context,
			IDeployResolutionGenerator generator) {
		super(context, generator,
				DeployCoreMessages.Resolution_realize_all_conceptual_units_in_topology);
		setPriority(-50);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution#resolve(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus resolve(IProgressMonitor monitor) {
		monitor.beginTask(DeployCoreMessages.Resolution_realize_all_conceptual_units_in_topology, 3);

		//
		// Copy topology to experiment with validation & resolutions
		//
		monitor.subTask(DeployCoreMessages.Resolution_duplicating_topology);
		Topology copy = SetAllAttributesInTopologyResolution.duplicate(context.getTopology());
		monitor.worked(1);

		//
		// Search for attribute values
		//
		monitor.subTask(DeployCoreMessages.Resolution_searching_conceptual_units);

		/**
		 * Number of conceptual units realized in the last validation/resolution cycle.
		 */
		int realizedCount = 0;

		/** Number of validate/resolve iterations. */
		int passCount = 0;

		/**
		 * Map<String, String> source unit (full path) and target unit (full path) for realization
		 * link.
		 */
		Map sourceTargetMap = new HashMap();

		/**
		 * List of realization links to create.
		 */
		Map linksToCreate = new HashMap();

		do {
			passCount++;
			realizedCount = 0;

			// Validate
			context.getDeployValidatorService().validate(copy);

			// Collect all the {@link IDeployAttributeValueStatus} on objects
			// of the topology into the <code>passKeyStatusMap</code>.
			linksToCreate.clear();
			for (Iterator iter = copy.findAllDeployModelObjects(); iter.hasNext();) {
				DeployModelObject dmo = (DeployModelObject) iter.next();
				if (dmo.getStatus().isOK()) {
					continue;
				}

				// continue only for Units
				if (!(dmo instanceof Unit)) {
					continue;
				}

//				for (Iterator iter2 = new StatusIterator(dmo); iter2.hasNext();) {
//					IStatus status = (IStatus) iter2.next();
//					if (status instanceof MultiStatus) continue;
//					System.out.println (status);
//					if (status instanceof IDeployStatus) System.out.println ("    IDeployStatus"); //$NON-NLS-1$
//				}
//				
				for (Iterator iter2 = new StatusIterator(dmo); iter2.hasNext();) {
					IStatus s = (IStatus) iter2.next();
					if (!(s instanceof IDeployStatus)) {
						continue;
					}
					IDeployStatus status = (IDeployStatus) s;
					// skip other problems
					if (!ICoreProblemType.CONCEPTUAL_UNIT_NOT_REALIZED.equals(status.getProblemType())) {
						continue;
					}

					IDeployResolutionContext context2 = createResolutionContext(status, context);
					List possibleRealizations = calculateMatches((Unit) dmo, context2);
					if (possibleRealizations.size() == 1) {
						// we have just one possible target; yeah!
						linksToCreate.put(possibleRealizations.get(0), status);
					}
				}
			}

			//
			// Apply realizations to copy topology.
			//
			for (Iterator iter2 = linksToCreate.entrySet().iterator(); iter2.hasNext();) {
				Map.Entry entry = (Map.Entry) iter2.next();
				LinkDescriptor ld = (LinkDescriptor) entry.getKey();
				IDeployStatus status = (IDeployStatus) entry.getValue();

				IDeployResolutionContext context2 = createResolutionContext(status, context);
				GenericRealizationSatisfactionResolution resolution = new GenericRealizationSatisfactionResolution(
						context2, generator, ld, null);
				IStatus resolveStatus = resolution.resolve(monitor);
				if (!resolveStatus.isOK()) {
					return resolveStatus;
				}
				realizedCount++;

				// keep track of the successful change so that can apply it to the current topology
				sourceTargetMap.put(SetAllAttributesInTopologyResolution.getOriginalPath(ld
						.getSourceUnit()), SetAllAttributesInTopologyResolution.getOriginalPath(ld
						.getTargetUnit()));
			}

			if (passCount > maxPassCount) {
				return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, 0,
						DeployCoreMessages.Resolution_propagation_cycle_found_or_max_length_exceeded,
						null);
			}
		} while (realizedCount > 0);

		monitor.worked(1);

		//
		// Apply realization updates on current topology
		//
		monitor.subTask(DeployCoreMessages.Resolution_setting_attribute_values);
		for (Iterator iter2 = sourceTargetMap.entrySet().iterator(); iter2.hasNext();) {
			Map.Entry entry = (Map.Entry) iter2.next();

			DeployModelObject source = context.getTopology().resolve((String) entry.getKey());
			DeployModelObject target = context.getTopology().resolve((String) entry.getValue());
//			 MK 2/26/2007 context is always the edit topology
			LinkFactory.createRealizationLink(source, target); //, context.getTopology());
		}
		monitor.worked(1);
		monitor.done();

		return Status.OK_STATUS;
	}

//	/**
//	 * Duplicate all objects in a topology
//	 * 
//	 * @param top
//	 *            the topology to be duplicated.
//	 * @return a copy of the topology.
//	 */
//	public static Topology duplicate(Topology top) {
//		// TODO this logic is not general. We now have non-unit contents in
//		// topologies such as ConfigurationContract. We could expand the logic,
//		// or generalize the proxy layer and use one here as well. M5 material.
//		Topology copy = CoreFactory.eINSTANCE.createTopology();
//		copy.setDecoratorSemantic(top.getDecoratorSemantic());
//		copy.setName(top.getName());
//		copy.setDisplayName(top.getDisplayName());
//		
//		ArrayList unitList = new ArrayList();
//		for (Iterator iter = top.findAllUnits(); iter.hasNext();) {
//			unitList.add(iter.next());
//		}
//		Collection unitCopies = ResolutionUtils.intelligentDeepCopy(unitList,
//				copy);
//		for (Iterator iter = unitCopies.iterator(); iter.hasNext();) {
//			Unit unitCopy = (Unit) iter.next();
//			copy.getUnits().add(unitCopy);
//		}
//		// Topology-level links should have been handled by the proxy's
//		// interception of getXXXLinks().
//		
//		// we explicitly do the realizaion links
//		// copy realization links: owned by topology
//		for (Iterator it = top.findAllRealizationLinks(); it.hasNext();) {
//			RealizationLink link = (RealizationLink) it.next();     // MK 2/27/2007
//			DeployModelObject source = copy.resolve(link.getSource().getFullPath());
//			DeployModelObject target = copy.resolve(link.getTarget().getFullPath());
//			LinkFactory.createRealizationLink(source, target); //, copy);
//		}
//		return copy;
//	}
//	
	// Adapted from SelectTargetWizard
	private List calculateMatches(Unit srcUnit, IDeployResolutionContext context) {
		LinkType[] linkTypes = new LinkType[] { LinkType.REALIZATION };

		DeployValidatorService dvs = context.getDeployValidatorService();

		List retVal = new ArrayList();

		Topology top = context.getTopology();

		// Per agreement, look only in local topology
		for (Iterator it = top.getUnits().iterator(); it.hasNext();) {
			Unit candidate = (Unit) it.next();

			if (candidate == null) {
				continue;
			}
			if (candidate != srcUnit) {
				LinkDescriptor[] linkDescriptorArray = dvs.getPossibleLinks(srcUnit, candidate,
						linkTypes);
				if (linkDescriptorArray.length > 0) {
					// retVal.add(candidate);
					retVal.add(linkDescriptorArray[0]);
				}
			}
		}

		return retVal;
	}

	/*
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof RealizeAllConceptualUnitsInTopologyResolution)) {
			return false;
		}

		if (getDeployStatus().getDeployObject().getTopology() == null) {
			return false;
		}
		return getDeployStatus().getDeployObject().getTopology().equals(
				((RealizeAllConceptualUnitsInTopologyResolution) obj).getDeployStatus()
						.getDeployObject().getTopology());
	}

	/*
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		if (getDeployStatus().getDeployObject().getTopology() == null) {
			return super.hashCode();
		}
		return getDeployStatus().getDeployObject().getTopology().hashCode();
	}
}
