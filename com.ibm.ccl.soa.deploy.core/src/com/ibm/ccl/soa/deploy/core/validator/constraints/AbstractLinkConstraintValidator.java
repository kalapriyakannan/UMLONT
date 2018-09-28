/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.constraints;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.link.MultiplicityChecker;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Extended by constraint validators for logic that can operate over linked objects.
 * <p>
 * Objects may be linked explicitly, or implicitly. In an implicit link, the constraint's context is
 * a {@link DeployLink}. In an implicit link, the constraint's context is a {@link Requirement}.
 */
public abstract class AbstractLinkConstraintValidator extends ConstraintValidator {

	/**
	 * Represents an ordered pair of deploy model objects.
	 */
	public class LinkedObjects {
		protected final DeployModelObject sourceContext;
		protected final DeployModelObject targetContext;

		/**
		 * Construct a pair of linked objects.
		 * 
		 * @param source
		 *           the source object.
		 * @param target
		 *           the target object.
		 */
		public LinkedObjects(DeployModelObject source, DeployModelObject target) {
			sourceContext = source;
			targetContext = target;
		}

		/**
		 * @return the source object in the pair (may be null).
		 */
		public DeployModelObject getSource() {
			return sourceContext;
		}

		/**
		 * @return the target object in the pair (may be null).
		 */
		public DeployModelObject getTarget() {
			return targetContext;
		}

		/**
		 * @return the source object's unit (may be null).
		 */
		public Unit getSourceUnit() {
			return ValidatorUtils.getUnit(getSource());
		}

		/**
		 * @return the target object's unit (may be null).
		 */
		public Unit getTargetUnit() {
			return ValidatorUtils.getUnit(getSource());
		}
	}

	/** True if discovery should be used for implicit links. */
	protected boolean useDiscovery = false;

	/**
	 * Constraint a constraint link validator.
	 * 
	 * @param useDiscoveryForImplicitLinks
	 *           true if the constraint link validator should use discovery for implicit links. False
	 *           if only topology-level links should be examined.
	 */
	public AbstractLinkConstraintValidator(boolean useDiscoveryForImplicitLinks) {
		useDiscovery = useDiscoveryForImplicitLinks;
	}

	/**
	 * @return true if discovery is used for implicit links (over requirements).
	 */
	public boolean getUseDiscoveryForImplicitLinks() {
		return useDiscovery;
	}

	@Override
	public final IStatus validate(Constraint constraint, DeployModelObject context,
			IProgressMonitor monitor) {
		if (context == null) {
			return Status.CANCEL_STATUS;
		}
		List<LinkedObjects> list = getLinkedObjects(context, monitor);
		IStatus result = null;
		IStatus cancel = null;
		for (LinkedObjects pair : list) {
			IStatus status = validate(constraint, context, pair.getSource(), pair.getTarget(), monitor);
			switch (status.getSeverity())
			{
			case IStatus.OK:
				// ignore
				break;
			case IStatus.CANCEL:
				cancel = status;
				break;
			default:
				if (result == null) {
					result = status;
				} else if (result.isMultiStatus()) {
					((MultiStatus) result).add(status);
				} else {
					result = new MultiStatus(DeployCorePlugin.PLUGIN_ID, 0, new IStatus[] { result,
							status }, DeployCoreMessages.Model_consistency_status_message, null);
				}
			}

		}

		if (result != null) {
			return result;
		}
		if (cancel != null) {
			return cancel;
		}
		return Status.OK_STATUS;
	}

	/**
	 * Returns a list of directly or implicitly linked objects.
	 * 
	 * @param context
	 *           a {@link DeployLink} or a {@link Requirement}
	 * @param monitor
	 *           the progress monitor.
	 * @return a list of non-null pairs (may be empty).
	 */
	protected List<LinkedObjects> getLinkedObjects(DeployModelObject context,
			IProgressMonitor monitor) {
		if (context == null) {
			return Collections.emptyList();
		}

		if (context instanceof DeployLink) {
			DeployLink link = (DeployLink) context;
			if (link.getSourceURI() == null || link.getTargetURI() == null) {
				return Collections.emptyList();
			}
			DeployModelObject source = link.resolve(link.getSourceURI());
			if (source == null) {
				return Collections.emptyList();
			}
			DeployModelObject target = link.resolve(link.getTargetURI());
			if (target == null) {
				return Collections.emptyList();
			}

			return Collections.singletonList(new LinkedObjects(source, target));
		}

		if (!(context instanceof Requirement)) {
			return Collections.emptyList();
		}
		Requirement req = (Requirement) context;
		Unit sourceUnit = ValidatorUtils.getUnit(req);
		if (sourceUnit == null) {
			return Collections.emptyList();
		}
		Topology topology = req.getEditTopology();
		switch (req.getLinkType().getValue())
		{
		case RequirementLinkTypes.DEPENDENCY:
			if (getUseDiscoveryForImplicitLinks()) {
				// TODO discovery should offer a method to return all discovered targets
				UnitDescriptor descr = TopologyDiscovererService.INSTANCE.findTarget(sourceUnit, req,
						topology, monitor);
				if (descr != null) {
					Unit target = descr.getUnitValue();
					if (target != null) {
						return Collections.singletonList(new LinkedObjects(sourceUnit, target));
					}
				}
				return Collections.emptyList();
			}
			return createList(req, topology.getRelationships().getDependencyTargets(req));
		case RequirementLinkTypes.HOSTING:
			if (getUseDiscoveryForImplicitLinks()) {
				List<UnitDescriptor> descrs = TopologyDiscovererService.INSTANCE.findAllHosts(
						sourceUnit, topology, monitor);
				return createListFromDescriptors(sourceUnit, descrs);
			}
			return createList(sourceUnit, topology.getRelationships().getHost(sourceUnit));
		case RequirementLinkTypes.MEMBER:
			boolean isGroup = MultiplicityChecker.isGroup(req);
			if (getUseDiscoveryForImplicitLinks()) {
				List<UnitDescriptor> descrs;
				if (isGroup) {
					descrs = TopologyDiscovererService.INSTANCE.getMembers(sourceUnit, req, topology,
							monitor);
				} else {
					descrs = TopologyDiscovererService.INSTANCE.getGroups(sourceUnit, req, topology,
							monitor);
				}
				return createListFromDescriptors(sourceUnit, descrs);
			}
			if (isGroup) {
				// FIXME filter out members from other requirements
				return createList(sourceUnit, topology.getRelationships().getMembers(sourceUnit));
			} else {
				return createList(sourceUnit, ValidatorUtils.getGroups(sourceUnit, req));
			}
		default:
			// ignore
		}
		return Collections.emptyList();
	}

	/**
	 * Creates a list of linked object pairs between the source and each unit represented by the
	 * descriptor.
	 * 
	 * @param source
	 *           the source unit.
	 * @param descrs
	 *           a list of unit descriptor.
	 * @return a list of linked objects for the source and every non-null unit returned by a
	 *         descriptor.
	 */
	protected List<LinkedObjects> createListFromDescriptors(Unit source, List<UnitDescriptor> descrs) {
		if (source == null || descrs == null || descrs.size() == 0) {
			return Collections.emptyList();
		}
		if (descrs.size() == 1) {
			Unit target = descrs.get(0).getUnitValue();
			if (target == null) {
				return Collections.emptyList();
			}
			return Collections.singletonList(new LinkedObjects(source, target));
		}
		List<LinkedObjects> results = new ArrayList<LinkedObjects>(descrs.size());
		for (UnitDescriptor descr : descrs) {
			Unit target = descr.getUnitValue();
			if (target != null) {
				results.add(new LinkedObjects(source, target));
			}
		}

		return results;
	}

	/**
	 * Creates a list of linked object pairs between the source and the target objects in the list.
	 * 
	 * @param source
	 *           the source object.
	 * @param targets
	 *           a collection of deploy model objects.
	 * @return a list of linked objects for the source and every non-null object contained in the
	 *         target list.
	 */
	private List<LinkedObjects> createList(DeployModelObject source, Collection<?> targets) {
		if (source == null || targets == null || targets.size() == 0) {
			return Collections.emptyList();
		}
		if (targets.size() == 1) {
			DeployModelObject target = (DeployModelObject) targets.iterator().next();
			if (target == null) {
				return Collections.emptyList();
			}
			return Collections.singletonList(new LinkedObjects(source, null));
		}
		List<LinkedObjects> results = new ArrayList<LinkedObjects>(targets.size());
		for (DeployModelObject target : (List<DeployModelObject>) targets) {
			if (target != null) {
				results.add(new LinkedObjects(source, target));
			}
		}

		return results;
	}

	/**
	 * Validates the link constraint over the source and target objects.
	 * <p>
	 * If this validator is not designed to validate the constraint over the specified context, it
	 * should return CANCEL_STATUS ({@link #CANCEL_STATUS}).
	 * 
	 * @param constraint
	 *           constraint to validate.
	 * @param context
	 *           the general context of the constraint.
	 * @param sourceContext
	 *           the source object context of the constraint.
	 * @param targetContext
	 *           the target object context of the constraint.
	 * @param monitor
	 *           a progress monitor for validation.
	 * @return the validation status. If this validator is not designed to validate the constraint,
	 *         it should return CANCEL_STATUS ({@link #CANCEL_STATUS}).
	 * 
	 * @see ConstraintUtil for useful utility methods.
	 */
	protected abstract IStatus validate(Constraint constraint, DeployModelObject context,
			DeployModelObject sourceContext, DeployModelObject targetContext, IProgressMonitor monitor);
}
