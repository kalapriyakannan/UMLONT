/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;

import com.ibm.ccl.soa.deploy.core.AttributeMetaData;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.IRelationshipChecker;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.SoftwareComponent;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.UnitLink;
import com.ibm.ccl.soa.deploy.core.constraint.GroupCardinalityConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.MemberCardinalityConstraint;
import com.ibm.ccl.soa.deploy.core.impl.DeployLinkImpl;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.util.EObjectTypeFilter;
import com.ibm.ccl.soa.deploy.core.util.FilterIterator;
import com.ibm.ccl.soa.deploy.core.util.IObjectFilter;
import com.ibm.ccl.soa.deploy.core.util.RealizationLinkUtil;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;
import com.ibm.ccl.soa.deploy.core.util.Trace;
import com.ibm.ccl.soa.deploy.core.validator.expression.InCardinality;
import com.ibm.ccl.soa.deploy.core.validator.expression.OutCardinality;
import com.ibm.ccl.soa.deploy.core.validator.expression.RequirementUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusUtil;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployStatusIterator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCoreValidators;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployPublishStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.StatusIterator;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployWrapperStatus;

/**
 * Utility methods to support validation, matching and resolution.
 */
public class ValidatorUtils {

	/**
	 * Provided services.
	 */
	public static final int PROVIDED_SERVICE = 0;

	/**
	 * Provided hosting services.
	 */
	public static final int PROVIDED_HOSTING_SERVICE = 2;

	private static final SortedSet<Unit> EMPTY_SORTED_SET = new TreeSet<Unit>();

	private static final Class<?> THIS_CLASS = ValidatorUtils.class;

	private static final boolean SHOULD_TRACE = Trace.shouldTrace(DeployCorePlugin.getDefault(),
			Trace.VALIDATION);

	/**
	 * An operation over a deploy topology.
	 */
	public interface ITopologyOperation {
		/**
		 * Execute the operation.
		 * 
		 * @param object
		 *           a deploy model object parameterizing the operation. the topology context.
		 * @param monitor
		 *           the progress monitor.
		 * @param info
		 *           additional info.
		 * @return the status of execution.
		 */
		IStatus doExecute(DeployModelObject object, IProgressMonitor monitor, IAdaptable info);
	}

	/**
	 * Executes a write operation over the topology.
	 * 
	 * @param object
	 *           the object parameter to the operation.
	 * @param operation
	 *           the operation to be invoked.
	 * @return the status of execution.
	 */
	public static IStatus executeWriteOperation(final DeployModelObject object,
			final ITopologyOperation operation) {
		assert operation != null;
		Topology top = null;
		if (object instanceof Topology) {
			top = (Topology) object;
		} else if (object != null) {
			top = object.getTopology();
		}
		TransactionalEditingDomain editingDomain = null;
		if (top != null) {
			editingDomain = TransactionUtil.getEditingDomain(top);
		}
		if (editingDomain == null) {
			editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain();
		}
		AbstractEMFOperation emfOperation = new AbstractEMFOperation(editingDomain,
				IConstants.EMPTY_STRING) {
			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) {
				return operation.doExecute(object, monitor, info);
			}
		};
		try {
			return emfOperation.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			String message = e.getMessage();
			if (message == null) {
				message = e.getClass().getName();
			}
			DeployCorePlugin.logError(0, message, e);
			return new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, 0, message, e);
		}
	}

	/**
	 * Null-safe method for obtaining the progress monitor from a context.
	 * 
	 * @param context
	 *           a validation context (may be null).
	 * @return the validation context monitor (may be null).
	 */
	private static IProgressMonitor getMonitor(IDeployValidationContext context) {
		if (context == null) {
			return null;
		}
		return context.getProgressMonitor();
	}

	/**
	 * Retrieve a list of the capabilities of a particular type from a unit.
	 * 
	 * @param unit
	 *           the unit being searched
	 * @param type
	 *           the type of the capability being sought
	 * @return a list of the capabilities
	 */
	public static List<Capability> getCapabilities(Unit unit, EClass type) {
		if (unit == null) {
			return Collections.emptyList();
		}
		ArrayList<Capability> list = new ArrayList<Capability>();
		for (Iterator<Capability> capabilities = unit.getCapabilities().iterator(); capabilities
				.hasNext();) {
			Capability cap = capabilities.next();
			if (type.isSuperTypeOf(cap.getEObject().eClass())) {
				list.add(cap);
			}
		}
		return list;
	}

	/**
	 * Retrieve a list of the requirements of a particular type from a unit.
	 * 
	 * @param unit
	 *           the unit being searched
	 * @param type
	 *           the type of the requirment being sought
	 * @return a list of the requirements
	 */
	public static List<Requirement> getRequirements(Unit unit, EClass type) {
		if (unit == null || type == null) {
			return Collections.emptyList();
		}

//		ArrayList<Requirement> list = new ArrayList<Requirement>();
//		for (Iterator<Requirement> requirements = unit.getRequirements().iterator(); requirements
//				.hasNext();) {
//			Requirement req = requirements.next();
//			if (req.getDmoEType() == null) {
//				continue;
//			}
//			// if (req.getDmoEType().equals(type)) {
//			if (type.isSuperTypeOf(req.getDmoEType())) {
//				list.add(req);
//			}
//		}
//		return list;

		return ValidatorUtils.findRequirements(unit, type, null);
	}

	/**
	 * Retrieve a list of the constraints of a particular type from a DeployModelObject.
	 * 
	 * @param dmo
	 *           the DeployModelObject being searched
	 * @param type
	 *           the type of the constraint being sought
	 * @return a list of the constraints
	 */
	public static List<Constraint> getConstraints(DeployModelObject dmo, EClass type) {
		if (dmo == null || type == null) {
			return Collections.EMPTY_LIST;
		}

		ArrayList<Constraint> list = new ArrayList<Constraint>();
		List<Constraint> cList = dmo.getConstraints();
//		for (Constraint constraint : cList) {
		for (int i = 0; i < cList.size(); i++) {
			Constraint constraint = cList.get(i);
			if (type.isSuperTypeOf(constraint.getEObject().eClass())) {
				list.add(constraint);
			}
		}
		// MK 7/5/2007 found problem with call to hasNext(); cf. Jazz Defect 2521
//		for (Iterator<Constraint> constraints = cList.iterator(); constraints.hasNext();) {
//			Constraint constraint = constraints.next();
//			if (type.isSuperTypeOf(constraint.getEObject().eClass())) {
//				list.add(constraint);
//			}
//		}

		return list;
	}

	/**
	 * Retrieve a list of the member requirements of a particular type from a unit.
	 * 
	 * @param unit
	 *           the unit being searched
	 * @param type
	 *           the type of the requirment being sought
	 * @return a list of the requirements
	 */
	public static List<Requirement> getMemberRequirements(Unit unit, EClass type) {
		List<Requirement> list = new ArrayList<Requirement>();
		List<Requirement> requirements = getRequirements(unit, type);
		for (int i = 0; i < requirements.size(); i++) {
			Requirement req = requirements.get(i);
			if (RequirementLinkTypes.MEMBER_LITERAL.equals(req.getLinkType())) {
				list.add(req);
			}
		}
		return list;
	}

	/**
	 * Retrieve one capability of a particular type from a unit.
	 * 
	 * @param unit
	 *           the unit being searched
	 * @param type
	 *           the type of the capability being sought
	 * @return one capability or null if there are no capabilities
	 */
	public static Capability getFirstCapability(Unit unit, EClass type) {
		if (unit == null || type == null) {
			return null;
		}
//		List list = unit.getCapabilities();
//		for (int i = 0; i < list.size(); i++) {
//			if (type.isInstance(list.get(i))) {
//				return (Capability) list.get(i);
//			}
//		}
//		return null;
//		List list = unit.getCapabilities();
		for (Iterator it = unit.getCapabilities().iterator(); it.hasNext();) {
//			if (type.isInstance(list.get(i))) {
			Object candidate = it.next();
			if (type.isInstance(candidate)) {
				return (Capability) candidate;
			}
		}
		return null;
	}

	/**
	 * Returns the first capability of the collection's objects of the specified type.
	 * 
	 * @param objects
	 *           a collection of {@link Unit} or {@link Capability} objects.
	 * @param type
	 *           a subtype of {@link Capability}.
	 * @return the first capability instance of the specified type, or null if not found.
	 */
	public static Capability getFirstCapability(Collection objects, EClass type) {
		if (objects == null) {
			return null;
		}
		for (Iterator iter = objects.iterator(); iter.hasNext();) {
			Object object = iter.next();
			if (object instanceof Unit) {
				Capability cap = getFirstCapability((Unit) object, type);
				if (cap != null) {
					return cap;
				}
			} else if (object instanceof Capability) {
				if (type.isInstance(object)) {
					return (Capability) object;
				}
			}
		}
		return null;
	}

	/**
	 * Retrieve one capability from a unit, that is a supertype of a given capability type.
	 * 
	 * @param unit
	 *           the unit being searched
	 * @param type
	 *           the type of the capability
	 * @return one capability or null if there are no capabilities
	 */
	public static Capability getFirstCapabilitySupertype(Unit unit, EClass type) {
		if (unit == null || type == null) {
			return null;
		}
		for (Iterator<Capability> it = unit.getCapabilities().iterator(); it.hasNext();) {
			Capability candidate = it.next();
			if (candidate.getEObject().eClass().isSuperTypeOf(type)) {
				return candidate;
			}
		}
		return null;
	}

	/**
	 * Returns the unit of the dependency link source requirement.
	 * 
	 * @param link
	 *           a dependency link.
	 * @return the unit or null if not reachable.
	 */
	public static Unit getSourceUnit(DependencyLink link) {
		if (link == null) {
			return null;
		}
		if (link.getSource() == null) {
			return null;
		}
		Requirement req = link.getSource();
		if (req == null) {
			return null;
		}
		if (!(req.getParent() instanceof Unit)) {
			return null;
		}
		Unit unit = (Unit) req.getParent();
		return unit;
	}

	/**
	 * Returns the unit of the dependency link target requirement.
	 * 
	 * @param link
	 *           a dependency link.
	 * @return the unit or null if not reachable.
	 */
	public static Unit getTargetUnit(DependencyLink link) {
		if (link == null) {
			return null;
		}
		if (link.getSource() == null) {
			return null;
		}
		Capability cap = link.getTarget();
		if (cap == null) {
			return null;
		}
		if (!(cap.getParent() instanceof Unit)) {
			return null;
		}
		Unit unit = (Unit) cap.getParent();
		return unit;
	}

	/**
	 * Retrieve one requirement of a particular type from a unit.
	 * 
	 * @param unit
	 *           the unit being searched
	 * @param type
	 *           the type of the requirement being sought
	 * @return one requirement or null if there are no requirements
	 */
	public static Requirement getFirstRequirement(Unit unit, EClass type) {
		return getFirstRequirement(unit, type, false);
	}

	/**
	 * Retrieve one requirement of a particular type from a unit.
	 * 
	 * @param unit
	 *           the unit being searched
	 * @param type
	 *           the type of the requirement being sought
	 * @param isMatchingCapabilityType
	 *           flag indicating that the type is the type of a matching {@link Capability}
	 * @return one requirement or null if there are no requirements
	 */
	public static Requirement getFirstRequirement(Unit unit, EClass type,
			boolean isMatchingCapabilityType) {
		if (unit == null) {
			return null;
		}
		if (type == null) {
			if (unit.getRequirements().size() > 0) {
				return (Requirement) unit.getRequirements().get(0);
			}
			return null;
		}
		for (Iterator<Requirement> requirements = unit.getRequirements().iterator(); requirements
				.hasNext();) {
			Requirement req = requirements.next();
			if (isMatchingCapabilityType) {
				if (RequirementUtil.doesRequirementSatisfyTypeOf(req, type)) {
					return req;
				}
			} else {
				if (RequirementUtil.isRequirementOfType(req, type)) {
					return req;
				}
			}
		}
		return null;
	}

	/**
	 * Retrieve one requirement of a particular type from a unit of the capability.
	 * 
	 * @param cap
	 *           a capability of a unit.
	 * @param type
	 *           the type of the requirement being sought
	 * @return one requirement or null if there are no requirements
	 */
	public static Requirement getFirstRequirement(Capability cap, EClass type) {
		if (cap == null || !(cap.getParent() instanceof Unit)) {
			return null;
		}
		return getFirstRequirement((Unit) cap.getParent(), type);
	}

	/**
	 * Finds the link target unit of a requirement.
	 * <p>
	 * Assumes that the source and target are in a common topology.
	 * 
	 * 
	 * @param req
	 *           a requirement
	 * @return one target capability unit of the requirement's link or null if there is no
	 *         requirement or it has no link.
	 */
	public static Unit getLinkTargetUnit(Requirement req) {
		Capability cap = getLinkTargetCapability(req);
		if (cap == null) {
			return null;
		}
		if (cap == null || !(cap.getParent() instanceof Unit)) {
			return null;
		}
		return (Unit) cap.getParent();
	}

	/**
	 * Discovers the link target of a requirement of the capability's unit.
	 * 
	 * @param cap
	 *           a capability whose parent is a unit.
	 * @param type
	 *           the type of the requirement being sought.
	 * @param monitor
	 *           the discovery progress and cancellation monitor (may be null).
	 * @return one target of the requirement's link or null if there is no requirement or it has not
	 *         link.
	 */
	public static Capability discoverFirstRequirementLinkTarget(Capability cap, EClass type,
			IProgressMonitor monitor) {
		if (cap == null || !(cap.getParent() instanceof Unit)) {
			return null;
		}
		return discoverFirstRequirementLinkTarget((Unit) cap.getParent(), type, monitor);
	}

	/**
	 * Discovers the link target of a requirement of the unit.
	 * 
	 * @param unit
	 *           a unit.
	 * @param type
	 *           the type of the requirement being sought.
	 * @param monitor
	 *           the discovery progress and cancellation monitor (may be null).
	 * @return one target of the requirement's link or null if there is no requirement or it has not
	 *         link.
	 */
	public static Capability discoverFirstRequirementLinkTarget(Unit unit, EClass type,
			IProgressMonitor monitor) {
		Unit targetUnit = discoverFirstRequirementLinkTargetUnit(unit, type, monitor);
		if (targetUnit == null) {
			return null;
		}
		return getFirstCapability(targetUnit, type);
	}

	/**
	 * Discovers the link target unit of a requirement of the capability's unit.
	 * 
	 * @param cap
	 *           a capability whose parent is a unit.
	 * @param type
	 *           the type of the requirement being sought.
	 * @param monitor
	 *           the discovery progress and cancellation monitor (may be null).
	 * @return one target capability unit of the requirement's link or null if there is no
	 *         requirement or it has not link.
	 */
	public static Unit discoverFirstRequirementLinkTargetUnit(Capability cap, EClass type,
			IProgressMonitor monitor) {
		if (cap == null || !(cap.getParent() instanceof Unit)) {
			return null;
		}
		return discoverFirstRequirementLinkTargetUnit((Unit) cap.getParent(), type, monitor);
	}

	/**
	 * Discovers the link target unit of a requirement of the unit.
	 * 
	 * @param unit
	 *           a unit.
	 * @param type
	 *           the type of the requirement being sought.
	 * @param monitor
	 *           the discovery progress and cancellation monitor (may be null).
	 * @return one target capability unit of the requirement's link or null if there is no
	 *         requirement or it has not link.
	 */
	public static Unit discoverFirstRequirementLinkTargetUnit(Unit unit, EClass type,
			IProgressMonitor monitor) {
		Requirement req = getFirstRequirement(unit, type);
		if (req == null) {
			return null;
		}
		UnitDescriptor descr = TopologyDiscovererService.INSTANCE.findTarget(unit, req, unit
				.getTopology(), monitor);
		if (descr == null) {
			return null;
		}
		Unit targetUnit = descr.getUnitValue();
		return targetUnit;
	}

	/**
	 * Finds the dependency link target capability of a requirement.
	 * <p>
	 * Assumes that the source and target are in a common topology.
	 * 
	 * 
	 * @param req
	 *           a requirement
	 * @return one target capability of the requirement's link or null if there is no requirement or
	 *         it has no link.
	 */
	public static Capability getLinkTargetCapability(Requirement req) {
		if (req == null) {
			return null;
		}
		if (req.getLink() == null) {
			return null;
		}
		Capability cap = req.getLink().getTarget();
		return cap;
	}

	/**
	 * Find the link target unit of the first requirement of the unit.
	 * <p>
	 * Assumes that the source and target are in a common topology.
	 * 
	 * @param unit
	 *           a unit.
	 * @param type
	 *           the type of the requirement being sought.
	 * @return one target capability unit of the requirement's link or null if there is no
	 *         requirement or it has not link.
	 */
	public static Unit getFirstRequirementLinkTargetUnit(Unit unit, EClass type) {
		Requirement req = getFirstRequirement(unit, type);

		return getLinkTargetUnit(req);
	}

	/**
	 * Find the link target capability of the first requirement of the unit.
	 * <p>
	 * Assumes that the source and target are in a common topology.
	 * 
	 * @param unit
	 *           a unit.
	 * @param type
	 *           the type of the requirement being sought.
	 * @return one target capability of the requirement's link or null if there is no requirement or
	 *         it has not link.
	 */
	public static Capability getFirstRequirementLinkTargetCapability(Unit unit, EClass type) {
		Requirement req = getFirstRequirement(unit, type);
		return getLinkTargetCapability(req);
	}

	/**
	 * Find the link target unit of a requirement of the capability's unit.
	 * <p>
	 * Assumes that the source and target are in a common topology.
	 * 
	 * @param cap
	 *           a capability whose parent is a unit.
	 * @param type
	 *           the type of the requirement being sought.
	 * @return one target capability unit of the requirement's link or null if there is no
	 *         requirement or it has not link.
	 */
	public static Unit getFirstRequirmentLinkTargetUnit(Capability cap, EClass type) {
		if (cap == null || !(cap.getParent() instanceof Unit)) {
			return null;
		}
		return getFirstRequirementLinkTargetUnit((Unit) cap.getParent(), type);
	}

	/**
	 * Find the link target capability of a requirement of the capability's unit.
	 * <p>
	 * Assumes that the source and target are in a common topology.
	 * 
	 * @param cap
	 *           a capability whose parent is a unit.
	 * @param type
	 *           the type of the requirement being sought.
	 * @return one target capability of the requirement's link or null if there is no requirement or
	 *         it has not link.
	 */
	public static Capability getFirstRequirementLinkTargetCapability(Capability cap, EClass type) {
		if (cap == null || !(cap.getParent() instanceof Unit)) {
			return null;
		}
		return getFirstRequirementLinkTargetCapability((Unit) cap.getParent(), type);
	}

	/**
	 * @param requirements
	 * @param type
	 * @param linkType
	 *           if null, will return requirements of all link types
	 * @return list of requirements
	 */
	public static List<Requirement> findRequirements(List requirements, EClass type,
			RequirementLinkTypes linkType) {
		ArrayList<Requirement> list = new ArrayList<Requirement>();
		for (Iterator<Requirement> iter = requirements.iterator(); iter.hasNext();) {
			Requirement r = iter.next();
			if (linkType == null || r.getLinkType().equals(linkType)) {
				if (RequirementUtil.isRequirementOfType(r, type)) {
					list.add(r);
				}
			}
		}
		return list;
	}

	/**
	 * @param unit
	 * @param type
	 * @param linkType
	 * @return list of requirements
	 */
	public static List<Requirement> findRequirements(Unit unit, EClass type,
			RequirementLinkTypes linkType) {
		if (unit == null) {
			return Collections.emptyList();
		}

		List<Requirement> requirements = unit.getRequirements();
		return findRequirements(requirements, type, linkType);
	}

	/**
	 * Retrieve a list of the capabilities of a particular type attached to a unit
	 * 
	 * @param unit
	 *           the unit owning capabilities being searched
	 * @param type
	 *           the type of the capability being sought
	 * @return a list of the capabilities of the desired type
	 */
	public static List<Capability> findCapabilities(Unit unit, EClass type) {
		if (unit == null) {
			return Collections.emptyList();
		}
		ArrayList<Capability> list = new ArrayList<Capability>();
		for (Iterator<Capability> iter = unit.getCapabilities().iterator(); iter.hasNext();) {
			Capability capability = iter.next();
			if (type.isSuperTypeOf(capability.getEObject().eClass())) {
				list.add(capability);
			}
		}
		return list;
	}

	/**
	 * Returns the most realized host of the unit in the topology and its imported topologies.
	 * <p>
	 * See {@link #getAllHosts(Unit, boolean)} for description of algorithm.
	 * 
	 * @param capability
	 *           the capability
	 * @return the owning unit
	 */
	public static Unit getOwningUnit(Capability capability) {
		if (capability == null) {
			return null;
		}
		return (Unit) capability.getParent();
	}

	/**
	 * Retrieve the unit containing a particular requirement.
	 * 
	 * @param requirement
	 *           the requirement
	 * @return the owning unit
	 */
	public static Unit getOwningUnit(Requirement requirement) {
		return (Unit) requirement.getParent();
	}

	/**
	 * Returns the most realized host of the unit in the topology and its imported topologies.
	 * <p>
	 * See {@link #getAllHosts(Unit, boolean)} for description of algorithm.
	 * 
	 * @param unit
	 *           the hosted unit
	 * @return the hoster if one exists, null if not or ambiguous.
	 * 
	 * @see #getImmediateHost(Unit, boolean)
	 * @see TopologyUtil#getImmediateHostingLinksIn(Unit)
	 * @see TopologyUtil#getImmediateHostingLinksOut(Unit)
	 */
	public static Unit getHost(Unit unit) {
		List<Unit> hosts = getAllHosts(unit);
		if (hosts.size() == 1) {
			return hosts.get(0);
		}
		return null;
	}

	/**
	 * Returns all the most realized hosts of the unit in the topology and its imported topologies.
	 * <p>
	 * Does not perform discovery (matcher safe).
	 * <ul>
	 * Algorithm:
	 * <li>
	 * <li>Consults the hosting links unit as well as all its realization linked units (
	 * {@link RealizationLinkUtil#getAllRealizationLinkedObjects(DeployModelObject)}.
	 * <li>For each host, it identifies the most realized unit (
	 * {@link RealizationLinkUtil#getFinalRealization(DeployModelObject)}.
	 * </ul>
	 * 
	 * @param unit
	 *           the hosted unit
	 * @return List<Unit> list of all hosters (never null).
	 */
	public static List<Unit> getAllHosts(Unit unit) {

		Trace.entering(DeployCorePlugin.getDefault(), Trace.VALIDATION, THIS_CLASS, "getAllHosts"); //$NON-NLS-1$

		List<Unit> finalComputedHosts = new ArrayList<Unit>();
		Set<Unit> localHostsRealizationSet = getDisambiguatedHosts(unit);

		if (SHOULD_TRACE) {
			for (Unit host : localHostsRealizationSet) {
				Trace.trace(DeployCorePlugin.getDefault(), Trace.VALIDATION, unit,
						"Locally Hosted by " + host.getDisplayName()); //$NON-NLS-1$
			}
		}

		List<DeployModelObject> upstreamRealiationSources = RealizationLinkUtil
				.getRealizationLinkedPath(unit, RealizationLinkUtil.WALK_UP);

		upstreamRealiationSources.remove(0); // remove the original Unit

		// we use a LinkedHashSet to preserve the order that hosts are added to the Set
		if (!upstreamRealiationSources.isEmpty()) {
			Set<Unit> upstreamHosts = new LinkedHashSet<Unit>();
			upstreamHosts.addAll(localHostsRealizationSet);
			for (DeployModelObject realization : upstreamRealiationSources) {
				if (realization instanceof Unit) {
					Set<Unit> disambiguatedHosts = getDisambiguatedHosts((Unit) realization);

					if (SHOULD_TRACE) {
						for (Unit host : disambiguatedHosts) {
							Trace
									.trace(
											DeployCorePlugin.getDefault(),
											Trace.VALIDATION,
											realization,
											"Upstream Realization of " + unit.getDisplayName() + " Hosted by " + host.getDisplayName()); //$NON-NLS-1$ //$NON-NLS-2$
						}
					}
					if (upstreamHosts.isEmpty()) {
						upstreamHosts.addAll(disambiguatedHosts); // inherit a default set
					} else if (disambiguatedHosts.size() > 0) {
						upstreamHosts.retainAll(disambiguatedHosts); // compute the intersection
					}
				}
			}

			if (localHostsRealizationSet.isEmpty()) {
				finalComputedHosts.addAll(upstreamHosts);
			} else {

				for (Unit upstreamHost : upstreamHosts) {
					if (localHostsRealizationSet.contains(upstreamHost)) {

						if (SHOULD_TRACE) {
							Trace.trace(DeployCorePlugin.getDefault(), Trace.VALIDATION, upstreamHost,
									"Upstream Realization of " + unit.getDisplayName() + " RETAINED "); //$NON-NLS-1$ //$NON-NLS-2$
						}

						finalComputedHosts.add(upstreamHost);
					}
					// otherwise the host will be ignored because it is 
					// inconsistent with the realization stack of the given Unit
				}
			}
		} else {
			finalComputedHosts.addAll(localHostsRealizationSet);
		}

		if (localHostsRealizationSet.size() == 0 && unit instanceof SoftwareComponent) {
			IRelationshipChecker relationships = unit.getEditTopology().getRelationships();
			Collection<Unit> containers = relationships.getContainer(unit);
			for (Unit container : containers) {
				// check for cycles
				if (!relationships.getContainer(container).contains(unit)) {
					localHostsRealizationSet.addAll(getAllHosts(container));
				}
			}

		}

		Trace.exiting(DeployCorePlugin.getDefault(), Trace.VALIDATION, THIS_CLASS, "getAllHosts"); //$NON-NLS-1$

		if (!finalComputedHosts.isEmpty()) {
			return finalComputedHosts;
		}

		return Collections.emptyList();
	}

	/**
	 * Return the disambiguated set of hosts from the given Unit including the final unique
	 * realization targets of the Unit and considering any disambiguating links from the Unit to a
	 * host in the set.
	 * 
	 * @param unit
	 *           The Unit to search for unique hosts.
	 * @return The disambiguated set of hosts from the given Unit including the final unique
	 *         realization targets of the Unit and considering any disambiguating links from the Unit
	 *         to a host in the set.
	 */
	public static Set<Unit> getDisambiguatedHosts(Unit unit) {

		if (unit == null || unit.getGoalInstallState() == InstallState.NOT_INSTALLED_LITERAL) {
			return EMPTY_SORTED_SET;
		}

		Topology topology = unit.getEditTopology();
		if (topology == null) {
			// cannot determine host without topology
			return EMPTY_SORTED_SET;
		}

		Set<Unit> disambiguations = new HashSet<Unit>();

		List<DeployModelObject> peerSet = RealizationLinkUtil.getRealizationLinkedPath(unit,
				RealizationLinkUtil.WALK_DOWN);
		Set<Unit> peerHosts = new HashSet<Unit>();
		for (Iterator<DeployModelObject> iter = peerSet.iterator(); iter.hasNext();) {
			DeployModelObject object = iter.next();
			if (object instanceof Unit) {
				Unit[] hosters = topology.findHosts((Unit) object);

				Set<Unit> directHosts = new HashSet<Unit>(Arrays.asList(hosters));
				peerHosts.addAll(directHosts);
				// we track the walked hosts to ensure that as we find more refined 
				// realization target hosts, we remove the source realizations
				for (int i = 0; i < hosters.length; i++) {
					List<DeployModelObject> hostRealizations = RealizationLinkUtil
							.getRealizationLinkedPath(hosters[i], RealizationLinkUtil.WALK_DOWN);
					for (DeployModelObject target : hostRealizations) {

						if (target != unit && target instanceof Unit) {
							Unit host = (Unit) target;
							if (host.getGoalInstallState() != InstallState.NOT_INSTALLED_LITERAL) {
								if (target != hosters[i] && directHosts.contains(target)) {
									// disambiguation link; ignore other paths
									disambiguations.add(host);
								}
							}
						}
					}
				}
			}
		}

		Set<Unit> finalHosts = disambiguations.size() > 0 ? disambiguations : peerHosts;
		// we use a LinkedHashSet to preserve the order that hosts are added to the Set
		Set<Unit> finalRealizedHosts = new LinkedHashSet<Unit>();

		for (Unit host : finalHosts) {
			DeployModelObject[] finalRealizations = RealizationLinkUtil.getFinalRealizations(host);
			if (finalRealizations.length > 0) {
				finalRealizedHosts
						.addAll((Collection<? extends Unit>) Arrays.asList(finalRealizations));
			}
		}
		return finalRealizedHosts;
	}

	/**
	 * Returns the <em>first</em> concrete unit which realizes the conceptual unit argument.
	 * <p>
	 * Follows the realization link chain until a concrete unit is found. Detects realization cycles,
	 * and returns null.
	 * 
	 * @param unit
	 *           a conceptual unit.
	 * @return the concrete unit by which this unit is directly, or indirectly realized.
	 */
	public static Unit getNonConceptualUnit(Unit unit) {
		if (unit == null) {
			return null;
		}

		Unit cur = getRealizationUnit(unit);
		if (cur == null) {
			return null;
		}
		// Optimization: if link has length 1 don't bother with cycle detection
		if (!cur.isConceptual()) {
			return cur;
		}
		// Chained realizations (need to worry about cycles)
		Set<Unit> set = new HashSet<Unit>();
		while (cur != null && cur.isConceptual()) {
			if (set.contains(cur)) {
				// Cycle found
				return null;
			}
			set.add(cur);
			cur = getRealizationUnit(cur);
		}
		return cur;
	}

	/**
	 * Returns the realization link for the conceptual unit.
	 * <p>
	 * <em>Warning</em>: does not perform discovery.
	 * 
	 * @param unit
	 *           a conceptual unit that is the source of a {@link RealizationLink}.
	 * @return the <em>first</em> realization link where the unit is a source, if one exists.
	 * @see #getRealizationUnit(Unit)
	 */
	public static RealizationLink getRealizationLink(Unit unit) {
		if (unit == null) {
			return null;
		}

		Topology top = unit.getEditTopology();
		if (top == null) {
			return null;
		}

		for (Iterator<RealizationLink> iter = top.findAllRealizationLinks(); iter.hasNext();) {
			RealizationLink link = iter.next();
			if (unit.equals(link.getSource())) {
				return link;
			}
		}
		return null;
	}

	/**
	 * Returns the realization link for the conceptual unit.
	 * <p>
	 * <em>Warning</em>: does not perform discovery.
	 * 
	 * @param sourceUnit
	 *           unit a conceptual unit that is the source of a {@link RealizationLink}.
	 * @param targetUnit
	 *           unit a unit that is the target of a {@link RealizationLink}.
	 * @return the <em>first</em> realization link where the unit is a source, and target is the the
	 *         target if one exists.
	 * @see #getRealizationUnit(Unit)
	 */
	public static RealizationLink getRealizationLink(Unit sourceUnit, Unit targetUnit) {
		if (sourceUnit == null || targetUnit == null) {
			return null;
		}
		Topology top = sourceUnit.getEditTopology();
		if (top == null) {
			return null;
		}

		IRelationshipChecker relationships = top.getRelationships();
		Iterator<RealizationLink> links = relationships.getRealizedByLinks(sourceUnit).iterator();
		while (links.hasNext()) {
			RealizationLink link = links.next();
			if (targetUnit.equals(link.getTarget())) {
				return link;
			}
		}

		return null;
	}

	/**
	 * Returns all the realization links for which the unit is the <em>source</em> (conceptual).
	 * <p>
	 * <em>Warning</em>: does not perform discovery.
	 * 
	 * @param sourceUnit
	 *           a conceptual unit that is the source of a {@link RealizationLink}.
	 * @return List<RealizationLink> where the unit is a source (never null).
	 * @see #getRealizationUnit(Unit)
	 */
	public static List<RealizationLink> getSourceRealizationLinks(Unit sourceUnit) {
		return getRealizationLinks(sourceUnit, true);
	}

	/**
	 * Returns all the realization links for which the unit is the <em>target</em> (conceptual).
	 * <p>
	 * <em>Warning</em>: does not perform discovery.
	 * 
	 * @param targetUnit
	 *           a unit that is the target of a {@link RealizationLink}.
	 * @return List<RealizationLink> where the unit is a target (never null).
	 * @see #getRealizationUnit(Unit)
	 */
	public static List<RealizationLink> getTargetRealizationLinks(Unit targetUnit) {
		return getRealizationLinks(targetUnit, false);
	}

	/**
	 * Returns all the realization links for which the capability is the <em>source</em>
	 * (conceptual).
	 * <p>
	 * <em>Warning</em>: does not perform discovery.
	 * 
	 * @param sourceCap
	 *           a capability that is the source of a {@link RealizationLink}.
	 * @return List<RealizationLink> where the capability is a source (never null).
	 * @see #getRealizationUnit(Unit)
	 */
	public static List<RealizationLink> getSourceRealizationLinks(Capability sourceCap) {
		return getRealizationLinks(sourceCap, true);
	}

	/**
	 * Returns all the realization links for which the capability is the <em>target</em>
	 * (conceptual).
	 * <p>
	 * <em>Warning</em>: does not perform discovery.
	 * 
	 * @param targetCap
	 *           a capability that is the target of a {@link RealizationLink}.
	 * @return List<RealizationLink> where the capability is a target (never null).
	 * @see #getRealizationUnit(Unit)
	 */
	public static List<RealizationLink> getTargetRealizationLinks(Capability targetCap) {
		return getRealizationLinks(targetCap, false);
	}

	/**
	 * Returns all the realization links for which the requirement is the <em>source</em>
	 * (conceptual).
	 * <p>
	 * <em>Warning</em>: does not perform discovery.
	 * 
	 * @param sourceReq
	 *           a requirement that is the source of a {@link RealizationLink}.
	 * @return List<RealizationLink> where the requirement is a source (never null).
	 * @see #getRealizationUnit(Unit)
	 */
	public static List<RealizationLink> getSourceRealizationLinks(Requirement sourceReq) {
		return getRealizationLinks(sourceReq, true);
	}

	/**
	 * Returns all the realization links for which the requirement is the <em>target</em>
	 * (conceptual).
	 * <p>
	 * <em>Warning</em>: does not perform discovery.
	 * 
	 * @param targetReq
	 *           a requirement that is the target of a {@link RealizationLink}.
	 * @return List<RealizationLink> where the requirement is a target (never null).
	 * @see #getRealizationUnit(Unit)
	 */
	public static List<RealizationLink> getTargetRealizationLinks(Requirement targetReq) {
		return getRealizationLinks(targetReq, false);
	}

	/**
	 * Returns all the realization links for which the dmo is the source or target.
	 * <p>
	 * <em>Warning</em>: does not perform discovery.
	 * 
	 * @param dmo
	 *           a conceptual unit or capability or requirement contained by a conceptual unit, that
	 *           is the source or target of a {@link RealizationLink}.
	 * @param isSource
	 *           true if dmo should be source of the link, false if target.
	 * @return List<RealizationLink> where the dmo is a source or target(never null).
	 * @see #getRealizationUnit(Unit)
	 */
	private static List<RealizationLink> getRealizationLinks(DeployModelObject dmo, boolean isSource) {
		if (dmo == null) {
			return Collections.emptyList();
		}

		Topology editTopology = dmo.getEditTopology();
		if (dmo.getTopology() == null || editTopology == null) {
			if (dmo instanceof Unit) {
				return ((Unit) dmo).getRealizationLinks();
			}
			return Collections.emptyList();
		}

		RealizationLink singleResult = null;
		List<RealizationLink> resultList = null;
		if (isSource) {
			for (RealizationLink link : editTopology.getRelationships().getRealizedByLinks(dmo)) {
				if (singleResult == null || singleResult == link) {
					singleResult = link;
				} else {
					if (resultList == null) {
						resultList = new LinkedList<RealizationLink>();
						resultList.add(singleResult);
					}
					if (!resultList.contains(link)) {
						resultList.add(link);
					}
				}
			}

		} else {
			for (RealizationLink link : editTopology.getRelationships().getRealizesLinks(dmo)) {
				if (singleResult == null || singleResult == link) {
					singleResult = link;
				} else {
					if (resultList == null) {
						resultList = new LinkedList<RealizationLink>();
						resultList.add(singleResult);
					}
					if (!resultList.contains(link)) {
						resultList.add(link);
					}
				}
			}
		}

		if (resultList != null) {
			return resultList;
		}
		if (singleResult == null) {
			return Collections.emptyList();
		}
		return Collections.singletonList(singleResult);
	}

	/**
	 * Returns the unit that realizes the argument unit.
	 * <p>
	 * <em>Warning</em>: does not perform discovery.
	 * 
	 * @param unit
	 *           a conceptual unit that is the source of a {@link RealizationLink}.
	 * @return the target unit of the <em>first</em> realization link, if one exists.
	 * @see #getRealizationLink(Unit)
	 */
	public static Unit getRealizationUnit(Unit unit) {
		RealizationLink link = getRealizationLink(unit);
		if (link != null && link.getTarget() instanceof Unit) {
			return (Unit) link.getTarget();
		}
		return null;
	}

	/**
	 * Returns the unit that is realized by the argument unit.
	 * <p>
	 * <em>Warning</em>: does not perform discovery.
	 * 
	 * @param unit
	 *           a unit that is the target of a {@link RealizationLink}.
	 * @return the <em>first</em> source unit of the realization link, if one exists.
	 * @see RealizationLink
	 */
	public static Unit getRealizedUnit(Unit unit) {
		if (unit == null) {
			return null;
		}
		// Currently, realization links are only contained in the topology
		Topology top = unit.getTopology();
		if (top == null) {
			return null;
		}
		List<RealizationLink> list = top.getRealizationLinks();
		for (int i = 0; i < list.size(); i++) {
			RealizationLink link = list.get(i);
			if (unit.equals(link.getTarget()) && link.getSource() instanceof Unit) {
				return (Unit) link.getSource();
			}
		}

		return null;
	}

	/**
	 * Returns the first capability of the specified type on the unit's host.
	 * <p>
	 * The unit's host must be on the topology. To perform discovery, use
	 * {@link #discoverHostCapability(Unit, EClass)}.
	 * 
	 * @param unit
	 *           a topology unit.
	 * @param capabilityType
	 *           the type of the unit's host capability that will be returned.
	 * @return the first host capability of the specified type, or null if not found.
	 */
	public static Capability getHostCapability(Unit unit, EClass capabilityType) {
		Unit host = getHost(unit);
		if (host == null) {
			return null;
		}
		return getFirstCapability(host, capabilityType);
	}

	/**
	 * Retrieve the hosting link from the hoster of a unit to the unit
	 * 
	 * @param unit
	 *           the hosted unit
	 * @return the hosting link from the hoster of a unit to the unit, or null if no hosting link
	 *         found
	 */
	public static HostingLink getHostingLink(Unit unit) {
		if (unit == null) {
			return null;
		}
		Unit host = getHost(unit);
		if (host == null) {
			return null;
		}
		for (Iterator<HostingLink> hlIter = host.getHostingLinks().iterator(); hlIter.hasNext();) {
			HostingLink hl = hlIter.next();
			if (hl != null && hl.getTarget() != null && hl.getTarget().equals(unit)) {
				return hl;
			}
		}

		return null;
	}

	/**
	 * Retrieve the groups to which a unit may belong.
	 * 
	 * @param member
	 *           the unit
	 * @param req
	 *           a membership requirement hinting at the group; if null all groups are returned
	 * @return the groups the unit is a member of
	 */
	public static List<Unit> findGroups(Unit member, Requirement req) {
		List<Unit> result = new ArrayList<Unit>();

		if (null == member || member.getTopology() == null) {
			return result;
		}

		Unit[] groups = member.getTopology().findMemberOf(member);
		for (int i = 0; i < groups.length; i++) {
			Unit group = groups[i];
			if (null == group) {
				continue;
			}

			// if there are member requirements, check that they are satisfied
			// by this group
			if (null != req) {
				if (!areInRequirementsSatisfied(group, member, Arrays.asList(new Requirement[] { req }))) {
					continue;
				}
			}

			result.add(group);
		}

		return result;
	}

	/**
	 * Test that membership requirements are satisfied by a group, member pair.
	 * 
	 * @param group
	 *           the group
	 * @param member
	 *           the member
	 * @param inRequirements
	 *           the requirements
	 * @return true if satisified, false otherwise
	 */
	public static boolean areInRequirementsSatisfied(Unit group, Unit member, List inRequirements) {
		if (group == null) {
			return false;
		}
		if (member == null) {
			return false;
		}
		if (inRequirements.size() == 0) {
			return false;
		}

		for (Iterator rIt = inRequirements.iterator(); rIt.hasNext();) {
			Requirement inReq = (Requirement) rIt.next();
			if (!RequirementLinkTypes.MEMBER_LITERAL.equals(inReq.getLinkType())) {
				// skip this one
				continue;
			}

			// check that types match
			if (!inReq.getDmoEType().isSuperTypeOf(group.getEObject().eClass())) {
				// skip this one
				continue;
			}

			List constraintList = inReq.getConstraints();
			if (constraintList.size() == 0) {
				// implies GroupCardinality 0..unbounded for all groups
				return true;
			}

			for (Iterator innerIter = constraintList.iterator(); innerIter.hasNext();) {
				Constraint constraint = (Constraint) innerIter.next();

				if (constraint instanceof GroupCardinalityConstraint) {
					return true;
				}
				if (constraint instanceof RequirementExpression) {
					RequirementExpression re = (RequirementExpression) constraint;
					if (InCardinality.INTERPRETER_ID.equals(re.getInterpreter())) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Test that membership requirements are satisfied by a group, member pair.
	 * 
	 * @param group
	 *           the group
	 * @param member
	 *           the member
	 * @param outRequirements
	 *           the requirements
	 * @return true if satisified, false otherwise
	 */
	public static boolean areOutRequirementsSatisfied(Unit group, Unit member, List outRequirements) {
		if (group == null) {
			return false;
		}
		if (member == null) {
			return false;
		}
		if (outRequirements.size() == 0) {
			return false;
		}

		for (Iterator rIt = outRequirements.iterator(); rIt.hasNext();) {
			Requirement outReq = (Requirement) rIt.next();
			if (!RequirementLinkTypes.MEMBER_LITERAL.equals(outReq.getLinkType())) {
				// skip this one
				continue;
			}

			EClass memberType = outReq.getDmoEType();
			// Treat null member type requirement as any unit instance
			if (memberType == null) {
				memberType = CorePackage.Literals.UNIT;
			}
			// check that types match
			if (!memberType.isSuperTypeOf(member.getEObject().eClass())) {
				// skip this one
				continue;
			}

			List constraintList = outReq.getConstraints();
			if (constraintList.size() == 0) {
				// implies all units can be member of group
				return true;
			}

			for (Iterator innerIter = constraintList.iterator(); innerIter.hasNext();) {
				Constraint constraint = (Constraint) innerIter.next();
				if (constraint instanceof MemberCardinalityConstraint) {
					return true;
				}
				if (constraint instanceof RequirementExpression) {
					RequirementExpression re = (RequirementExpression) constraint;
					if (re.getInterpreter().equals(OutCardinality.INTERPRETER_ID)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Discovers the host of the unit.
	 * 
	 * @param unit
	 *           a topology unit.
	 * @param monitor
	 *           the discovery progress and cancellation monitor (may be null).
	 * @return the unit's host or null if not found.
	 */
	public static Unit discoverHost(Unit unit, IProgressMonitor monitor) {
		if (unit == null) {
			return null;
		}
		return TopologyDiscovererService.INSTANCE.findHost(unit, unit.getEditTopology(), monitor);
	}

	/**
	 * Discovers the host of a unit in the topology and adds it to the topology if it is not already
	 * present.
	 * 
	 * @param unit
	 *           a unit that is hosted by a unit in the topology or the infrastructure.
	 * @param monitor
	 *           the discovery progress and cancellation monitor (may be null).
	 * @return the hosting unit, or null if not found or could not be added.
	 */
	public static Unit discoverHostAndAddToTopology(Unit unit, IProgressMonitor monitor) {
		if (unit == null || unit.getEditTopology() == null) {
			return null;
		}
		UnitDescriptor descriptor = TopologyDiscovererService.INSTANCE.findHostUD(unit, unit
				.getEditTopology(), monitor);
		if (descriptor == null) {
			return null;
		}
		return descriptor.getUnitValueAndAddToTopology(unit.getEditTopology());
	}

	/**
	 * Discover the host of the unit of a specified unit type.
	 * <p>
	 * Warning: do not use this method in a matcher!
	 * 
	 * @param unit
	 *           a hosted unit (may be null).
	 * @param unitType
	 *           the type of the returned hosting unit.
	 * @param monitor
	 *           the discovery progress and cancellation monitor (may be null).
	 * @return the host if one exists of the specified type, null otherwise.
	 */
	public static Unit discoverHost(Unit unit, EClass unitType, IProgressMonitor monitor) {
		if (unit == null) {
			return null;
		}
		Unit host = TopologyDiscovererService.INSTANCE
				.findHost(unit, unit.getEditTopology(), monitor);
		if (host == null) {
			return null;
		}
		if (unitType != null && unitType.isInstance(unit)) {
			return null;
		}
//		if (unitType != null && unit != null && unitType.isSuperTypeOf(unit.getEObject().eClass())) {
//			return host;
//		}
//		return null;
		return host;
	}

	/**
	 * Discover the host of the unit of a specified unit type.
	 * <p>
	 * Warning: do not use this method in a matcher!
	 * 
	 * @param cap
	 *           a capability whose parent is a unit (may be null).
	 * @param unitType
	 *           the type of the returned hosting unit.
	 * @param monitor
	 *           the discovery progress and cancellation monitor (may be null).
	 * @return the host if one exists of the specified type, null otherwise.
	 */
	public static Unit discoverHost(Capability cap, EClass unitType, IProgressMonitor monitor) {
		Unit host = discoverHost(cap, monitor);
		if (host == null) {
			return null;
		}
		if (unitType != null && !unitType.isInstance(cap)) {
			return null;
		}
		return host;
	}

	/**
	 * Retrieve the first capability of a host down the hosting stack of the specified type.
	 * <p>
	 * Warning: do not use this method in a matcher!
	 * 
	 * @param cap
	 *           a capability of a hosted unit.
	 * @param capabilityType
	 *           the type of the hosting unit's capability.
	 * @param recurse
	 *           true if the host's hosts should be considered.
	 * @param monitor
	 *           the discovery progress and cancellation monitor (may be null).
	 * @return the capability hoster if one exists, null otherwise.
	 */
	public static Capability discoverHostCapability(Capability cap, EClass capabilityType,
			boolean recurse, IProgressMonitor monitor) {
		if (cap == null || !(cap.getParent() instanceof Unit)) {
			return null;
		}
		return discoverHostCapability((Unit) cap.getParent(), capabilityType, recurse, monitor);
	}

	/**
	 * Retrieve the first capability of a host down the hosting stack of the specified type.
	 * <p>
	 * Warning: do not use this method in a matcher!
	 * 
	 * @param unit
	 *           the hosted unit
	 * @param capabilityType
	 *           the type of the hosting unit's capability.
	 * @param recurse
	 *           true if the host's hosts should be considered.
	 * @return the capability hoster if one exists, null otherwise.
	 */
	public static Capability discoverHostCapability(Unit unit, EClass capabilityType,
			boolean recurse, IProgressMonitor monitor) {
		Unit host = discoverHost(unit, monitor);
		while (host != null) {
			Capability cap = getFirstCapability(host, capabilityType);
			if (cap != null) {
				return cap;
			}
			if (!recurse) {
				return null;
			}
			host = discoverHost(host, monitor);
		}
		return null;
	}

	/**
	 * Retrieve a capability of the unit's host using discovery
	 * <p>
	 * Equivalent to invoking {@link #discoverHost(Unit)}, then
	 * {@link #getFirstCapability(Unit, EClass)} on the host.
	 * <p>
	 * Warning: do not use this method in a matcher!
	 * 
	 * @param unit
	 *           the hosted unit
	 * @param capabilityType
	 *           the type of the hosting unit's capability.
	 * @return the capability hoster if one exists, null otherwise.
	 */
	public static Capability discoverHostCapability(Unit unit, EClass capabilityType,
			IProgressMonitor monitor) {
		Unit host = discoverHost(unit, monitor);
		if (host == null) {
			return null;
		}
		return getFirstCapability(host, capabilityType);
	}

	/**
	 * Retrieve the hoster of the capability's unit using discovery.
	 * <p>
	 * Equivalent to {@link #discoverHost(Unit)} on {@link Capability#getParent()}.
	 * <p>
	 * Warning: do not use this method in a matcher!
	 * 
	 * @param cap
	 *           a capability of a unit.
	 * @return the host of the capability's unit, or null.
	 */
	public static Unit discoverHost(Capability cap, IProgressMonitor monitor) {
		if (cap == null || !(cap.getParent() instanceof Unit)) {
			return null;
		}
		return discoverHost((Unit) cap.getParent(), monitor);
	}

	/**
	 * Retrieve a capability of the capability's unit host using discovery
	 * <p>
	 * Equivalent to invoking {@link #discoverHost(Capability)}, then
	 * {@link #getFirstCapability(Unit, EClass)} on the host.
	 * <p>
	 * Warning: do not use this method in a matcher!
	 * 
	 * @param cap
	 *           a capability whose parent is a unit.
	 * @param capabilityType
	 *           the type of the hosting unit's capability.
	 * @return the capability hoster if one exists, null otherwise.
	 */
	public static Capability discoverHostCapability(Capability cap, EClass capabilityType,
			IProgressMonitor monitor) {
		Unit host = discoverHost(cap, monitor);
		if (host == null) {
			return null;
		}
		return getFirstCapability(host, capabilityType);
	}

	/**
	 * Returns a list of all direct and indirect hosts of this unit.
	 * 
	 * @param unit
	 *           a deploy unit.
	 * @return List<Unit>
	 */
	public static List<Unit> discoverHostsRecursive(Unit unit, IProgressMonitor monitor) {
		if (unit == null) {
			return Collections.emptyList();
		}
		Unit cur = discoverHost(unit, monitor);
		List<Unit> list = null;
		while (cur != null) {
			if (list == null) {
				list = new ArrayList<Unit>();
			}
			list.add(cur);
			cur = discoverHost(cur, monitor);
		}
		if (list == null) {
			return Collections.emptyList();
		}
		return list;
	}

	/**
	 * Retrieve the uppermost host which is a subtype of the parameter type from the hosting stack of
	 * a unit. Does not use discovery.
	 * 
	 * @param unit
	 *           the hosted unit
	 * @param unitType
	 *           the type of the hoster unit in the hosting stack
	 * @return the hoster unit, or null if none of the specified type can be found
	 */
	public static Unit findHostInStack(Unit unit, EClass unitType) {
		while (unit != null) {
			if (unitType.isSuperTypeOf(unit.eClass())) {
				return unit;
			}
			unit = ValidatorUtils.getHost(unit);
		}
		return unit;
	}

	/**
	 * Retrieve the uppermost host which has a capability that is a subtype of the parameter type
	 * from the hosting stack of a unit. Does not use discovery.
	 * 
	 * @param unit
	 *           the hosted unit
	 * @param capType
	 *           the type of the hoster unit in the hosting stack
	 * @return the unit with the specified capability, or null if none of the specified type can be
	 *         found
	 */
	public static Unit findHostInStackWithCapability(Unit unit, EClass capType) {
		while (unit != null) {
			if (ValidatorUtils.getCapability(unit, capType) != null) {
				return unit;
			}
			unit = ValidatorUtils.getHost(unit);
		}
		return unit;
	}

	/**
	 * Retrieve a host of a particular type from the hosting stack of a unit, using discovery
	 * 
	 * @param unit
	 *           the hosted unit
	 * @param type
	 *           the type of the hoster in the hosting stack
	 * @return the hoster or null if none of the specified type can be found
	 */
	public static Unit discoverHostInStack(Unit unit, EClass type, IProgressMonitor monitor) {
		// Unit hostingUnit = unit;
		// while ((hostingUnit != null) &&
		// !type.isSuperTypeOf(hostingUnit.getEObject().eClass())) {
		// hostingUnit =
		// TopologyDiscovererService.INSTANCE.findHost(hostingUnit,
		// unit.getTopology());
		// // System.out.println("HostingUnit: " + hostingUnit.getName());
		// 
		// }
		//		
		// return hostingUnit;
		return TopologyDiscovererService.INSTANCE.findHost(unit, type, unit.getEditTopology(),
				monitor);
	}

	/**
	 * Returns the first unit down the hosting stack of the unit which provides a capability of the
	 * specified type.
	 * 
	 * @param unit
	 *           a unit whose hosting stack will be examined.
	 * @param capType
	 *           the type of capability provided.
	 * @return the unit with the specified capability, or null if not found.
	 */
	public static Unit discoverHostInStackWithCapability(Unit unit, EClass capType,
			IProgressMonitor monitor) {
		assert CorePackage.eINSTANCE.getCapability().isSuperTypeOf(capType);
		Unit cur = TopologyDiscovererService.INSTANCE.findHost(unit, unit.getEditTopology(), monitor);
		while (cur != null) {
			Capability cap = ValidatorUtils.getCapability(cur, capType);
			if (cap != null) {
				return cur;
			}

			cur = TopologyDiscovererService.INSTANCE.findHost(cur, unit.getEditTopology(), monitor);
		}
		return null;
	}

	/**
	 * Retrieve unit descriptor for a host of a particular type from the hosting stack of a unit,
	 * using discovery
	 * 
	 * @param unit
	 *           the hosted unit
	 * @param type
	 *           the type of the hoster in the hosting stack
	 * @return UnitDescriptor of the hoster or null if none of the specified type can be found
	 */
	public static UnitDescriptor discoverHostUDInStack(Unit unit, EClass type,
			IProgressMonitor monitor) {
		Unit hostingUnit = unit;
		UnitDescriptor hostingUnitUD = null;
		while (hostingUnit != null && !type.isSuperTypeOf(hostingUnit.getEObject().eClass())) {
			hostingUnitUD = TopologyDiscovererService.INSTANCE.findHostUD(hostingUnit, unit
					.getEditTopology(), monitor);
			if (hostingUnitUD == null) {
				hostingUnit = null;
				continue;
			}
			hostingUnit = hostingUnitUD.getUnitValue();
			// System.out.println("HostingUnit: " + hostingUnit.getName());
			// 
		}
		return hostingUnitUD;
	}

	/**
	 * NOTE: copied from UnitValidator and made static Returns the first Capability of the specified
	 * type, null if none exists.
	 * 
	 * @param unit
	 *           unit to search capability list on
	 * @param type
	 *           the type of a capability.
	 * @return the first service that is a subtype of the type.
	 */
	public static Capability getCapability(Unit unit, EClass type) {
		if (unit == null || type == null) {
			return null;
		}
		for (Iterator<Capability> iter = unit.getCapabilities().iterator(); iter.hasNext();) {
			Capability capability = iter.next();
			if (type.isSuperTypeOf(capability.getEObject().eClass())) {
				return capability;
			}
		}

		return null;
	}

	/**
	 * Returns the true if the unit has a capability of the specified type.
	 * 
	 * @param unit
	 *           the unit.
	 * @param type
	 *           the type of capability to be checked.
	 * @return true if the unit has at least one instance of the capability type, false otherwise.
	 */
	public static boolean hasCapability(Unit unit, EClass type) {
		assert CorePackage.eINSTANCE.getCapability().isSuperTypeOf(type);
		return getCapability(unit, type) != null;
	}

	/**
	 * Returns the number of instances of capabilities in the list that are subtypes of the type.
	 * 
	 * @param list
	 *           a list of capabilities (List<Capability>)
	 * @param type
	 *           the type of a capability
	 * @return the capability count.
	 */
	public static int getCapabilityCount(List<Capability> list, EClass type) {
		int count = 0;
		for (Iterator<Capability> iter = list.iterator(); iter.hasNext();) {
			Capability capability = iter.next();
			if (type.isSuperTypeOf(capability.getEObject().eClass())) {
				count++;
			}
		}

		return count;
	}

	/**
	 * Removes all {@link IDeployPublishStatus} set on objects contained in the topology.
	 * 
	 * @param topology
	 *           a deployment topology.
	 */
	public static void clearPublishStatus(Topology topology) {
		clearTopologyStatus(topology, new IObjectFilter() {
			public boolean accept(Object value) {
				return value instanceof IDeployPublishStatus;
			}

		});
	}

	/**
	 * Removes all statuses from topology objects which match the filter expression.
	 * 
	 * @param topology
	 *           a deployment topology.
	 * @param filter
	 *           a status filter.
	 */
	public static void clearTopologyStatus(Topology topology, IObjectFilter filter) {
		clearObjectStatus(topology, filter);
		for (Iterator iter = topology.findAllDeployModelObjects(); iter.hasNext();) {
			DeployModelObject object = (DeployModelObject) iter.next();
			clearObjectStatus(object, filter);
		}
	}

	/**
	 * Removes all statuses from the deploy object which match the filter expression.
	 * 
	 * @param object
	 *           a deploy object.
	 * @param filter
	 *           a status filter.
	 * 
	 * @see DeployModelObject#getStatus()
	 */
	public static void clearObjectStatus(DeployModelObject object, IObjectFilter filter) {
		IStatus status = object.getStatus();
		if (status == Status.OK_STATUS) {
			return;
		}

		if (filter.accept(status)) {
			object.clearStatus();
			return;
		}

		if (status instanceof MultiStatus) {
			MultiStatus multiStatus = (MultiStatus) status;
			IStatus[] children = multiStatus.getChildren();
			int nonDeployMessageStatusCount = 0;
			int lastNonDeployMessageStatusIndex = -1;
			for (int i = 0; i < children.length; i++) {
				if (!filter.accept(children[i])) {
					nonDeployMessageStatusCount++;
					lastNonDeployMessageStatusIndex = i;
				}
			}
			if (nonDeployMessageStatusCount == 0) {
				object.clearStatus();
			} else if (nonDeployMessageStatusCount == 1) {
				object.clearStatus();
				object.addStatus(children[lastNonDeployMessageStatusIndex]);
			} else {
				IStatus[] newChildren = new IStatus[nonDeployMessageStatusCount];
				int newIndex = 0;
				for (int i = 0; i < children.length; i++) {
					if (!filter.accept(children[i])) {
						newChildren[newIndex++] = children[i];
					}
				}
				MultiStatus newStatus = new MultiStatus(multiStatus.getPlugin(), multiStatus.getCode(),
						newChildren, multiStatus.getMessage(), null);
				object.clearStatus();
				object.addStatus(newStatus);
			}
		}
	}

	/**
	 * Compares two object in a null-safe and {@link Comparable}-safe manner.
	 * 
	 * @param obj1
	 *           first object.
	 * @param obj2
	 *           second object.
	 * @return the value of obj1.compareTo(obj2) or the value of
	 *         obj1.toString().compareTo(obj2.toString()). Null is treated as the smallest value.
	 * @see Comparable#compareTo(Object)
	 */
	public static int compare(Object obj1, Object obj2) {
		if (obj1 == null && obj2 == null) {
			return 0;
		}
		if (obj1 == null) {
			return 1;
		}
		if (obj2 == null) {
			return -1;
		}
		if (obj1.equals(obj2)) {
			return 0;
		}
		if (obj1 instanceof Comparable) {
			try {
				return ((Comparable) obj1).compareTo(obj2);
			} catch (RuntimeException e) {
				// ignore we'll compare their hash codes
			}
		}
		String s1 = obj1.toString();
		String s2 = obj2.toString();
		if (s1 == null && s2 == null) {
			return 0;
		}
		if (s1 == null) {
			return 1;
		}
		if (s2 == null) {
			return -1;
		}

		return s1.compareTo(s2);
	}

	/**
	 * Compares two deploy object paths in a null-safe and {@link Comparable}-safe manner.
	 * 
	 * @param obj1
	 *           first deploy object.
	 * @param obj2
	 *           second deploy object.
	 * @return the value of obj1.getFullPath().compareTo(obj2.getFullPath())
	 * @see Comparable#compareTo(Object)
	 * @see DeployModelObject#getFullPath()
	 */
	public static int compareObjectPaths(DeployModelObject obj1, DeployModelObject obj2) {
		if (obj1 == null && obj2 == null) {
			return 0;
		}
		if (obj1 == null) {
			return 1;
		}
		if (obj2 == null) {
			return -1;
		}
		if (obj1.equals(obj2)) {
			return 0;
		}
		String s1 = obj1.getFullPath();
		String s2 = obj2.getFullPath();
		if (s1 == null && s2 == null) {
			return 0;
		}
		if (s1 == null) {
			return 1;
		}
		if (s2 == null) {
			return -1;
		}

		return s1.compareTo(s2);
	}

	/**
	 * Returns the hashcode for the object in a null-safe manner.
	 * 
	 * @param obj
	 *           an object (may be null).
	 * @return the hash code of the object, or 0 if the object is null.
	 */
	public static int hashCode(Object obj) {
		if (obj == null) {
			return 0;
		}
		return obj.hashCode();
	}

	/**
	 * Compares two object for equality in a null-safe manner.
	 * 
	 * @param obj1
	 *           first object.
	 * @param obj2
	 *           second object.
	 * @return true if both objects are null or {@link Object#equals(Object)}.
	 */
	public static boolean equals(Object obj1, Object obj2) {
		if (obj1 == null) {
			return obj2 == null;
		}
		if (obj2 == null) {
			return false;
		}
		if (obj1.getClass().isArray() && obj2.getClass().isArray()) {
			return equalsArray(((Object[]) obj1), ((Object[]) obj2));
		}
		return obj1.equals(obj2);
	}

	/**
	 * Compares two object arrays for equality in a null-safe manner.
	 * 
	 * @param obj1
	 *           first object array.
	 * @param obj2
	 *           second object array.
	 * @return true if both arrays contain equal elements compared using
	 *         {@link #equals(Object, Object)}.
	 */
	public static boolean equalsArray(Object[] obj1, Object[] obj2) {
		if (obj1 == null) {
			return obj2 == null;
		}
		if (obj2 == null) {
			return false;
		}
		if (obj1.length != obj2.length) {
			return false;
		}
		for (int i = 0; i < obj1.length; i++) {
			if (!equals(obj1[i], obj2[i])) {
				return false;
			}
		}
		return true;
	}

	/** Empty deploy status array. */
	public final static IDeployStatus[] EMPTY_DEPLOY_STATUS = new IDeployStatus[0];

	/**
	 * Returns an array of deploy status associated with this object.
	 * 
	 * @param object
	 *           a deploy object with {@link DeployModelObject#getStatus()}.
	 * 
	 * @return an array of deploy status (never null).
	 */
	public static IDeployStatus[] getDeployStatus(DeployModelObject object) {
		if (object == null || !(object instanceof IDeployStatus)
				&& !object.getStatus().isMultiStatus()) {
			return EMPTY_DEPLOY_STATUS;
		}
		return getDeployStatus(object.getStatus());
	}

	/**
	 * Returns an array of deploy status contained in the status..
	 * 
	 * @param status
	 *           a status that may be, or contain, a deploy status.
	 * 
	 * @return an array of deploy status (never null).
	 */
	public static IDeployStatus[] getDeployStatus(IStatus status) {
		int count = 0;
		for (Iterator iter = new StatusIterator(status); iter.hasNext();) {
			IStatus next = (IStatus) iter.next();
			if (next instanceof IDeployStatus) {
				count++;
			}
		}
		if (count == 0) {
			return EMPTY_DEPLOY_STATUS;
		}
		IDeployStatus[] result = new IDeployStatus[count];
		int i = 0;
		for (Iterator<IStatus> iter = new StatusIterator(status); iter.hasNext();) {
			IStatus next = iter.next();
			if (next instanceof IDeployStatus) {
				result[i] = (IDeployStatus) next;
				i++;
			}
		}
		return result;
	}

	/**
	 * @param uriString
	 * @return true if parseable as valid URI, false otherwise
	 * @deprecated extend {@link ModuleValidator}
	 */
	public static boolean validURI(String uriString) {
		try {
			new URI(uriString);
			return true;
		} catch (URISyntaxException e) {
			return false;
		} finally {
		}
	}

	/**
	 * @param classname
	 * @return <code>true</code> if 'classname' obeys the rules of a package-qualified Java class
	 *         name.
	 */
	public static boolean validJavaClassname(String classname) {
		return validJavaName(classname);
	}

	/**
	 * See Gosling et al, _The Java Language Specification_, first edition, section 19.5.
	 * 
	 * RECURSIVE.
	 */
	private static boolean validJavaName(String name) {
		if (name == null || name.length() == 0) {
			return false;
		}

		int pos = name.lastIndexOf('.');
		if (pos >= 0) {
			String qualifier = name.substring(0, pos);
			if (!validJavaName(qualifier)) {
				return false;
			}

			name = name.substring(pos + 1);
		}

		return validJavaIdentifier(name);
	}

	/**
	 * See Gosling et al, _The Java Language Specification_, first edition, section 3.8
	 * 
	 * Bugs: doesn't check reserved words, so considers 'boolean' a valid Java identifier (it's not)
	 */
	private static boolean validJavaIdentifier(String name) {
		if (name == null || name.length() == 0) {
			return false;
		}

		if (!Character.isJavaIdentifierStart(name.charAt(0))) {
			return false;
		}

		for (int i = 1; i < name.length(); i++) {
			if (!Character.isJavaIdentifierPart(name.charAt(i))) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Replaced by CapabilityAttributeUniqueInHostValidator
	 * 
	 * The value of the eAttribute should be different for each similar unit hosted by the host of
	 * the unit
	 * 
	 * @param unit
	 *           unit owning capability to check.
	 * @param eClass
	 *           EClass of capability on unit with attribute
	 * @param eAttribute
	 *           EAttribute to check
	 * @param reporter
	 * @param specificStatus
	 *           Status to report. If null, defaults to ObjectAttributeInvalidStatus
	 */
	// public static void validateEAttributeUniqueness(Unit unit, EClass eClass,
	// EAttribute eAttribute, IDeployReporter reporter, IDeployStatus
	// specificStatus) {
	// // Unit hostsOfUnit[] = unit.getTopology().findHosts(unit);
	// Unit hostOfUnit = TopologyDiscovererService.INSTANCE.findHost(unit,
	// unit.getTopology()).getUnitValue();
	// int valueEqualityCount = 0;
	// assert CorePackage.eINSTANCE.getCapability().isSuperTypeOf(eClass);
	// assert eClass.getEAllAttributes().contains(eAttribute);
	//		
	// // if (hostsOfUnit.length == 0) {
	// if (hostOfUnit == null) {
	// return;
	// }
	// List matchingCapsForUnit = ValidatorUtils.findCapabilities(unit, eClass);
	// //assert (matchingCapsForUnit.size() > 0);
	// if (matchingCapsForUnit.size() == 0) {
	// return;
	// }
	// Capability c = (Capability) matchingCapsForUnit.get(0);
	// if (c == null) {
	// return;
	// }
	// Object valueOnUnit = c.getEObject().eGet(eAttribute);
	// if (valueOnUnit == null) {
	// return;
	// }
	// List hostedByHostUnitDescriptors =
	// TopologyDiscovererService.INSTANCE.findHosted(hostOfUnit,
	// hostOfUnit.getTopology());
	// // for (Iterator iter = hostOfUnit.getHostingLinks().iterator();
	// iter.hasNext();) {
	// for (Iterator iter = hostedByHostUnitDescriptors.iterator();
	// iter.hasNext();) {
	// // HostingLink hostingLink = (HostingLink) iter.next();
	// // if (hostingLink.getHosted() == null) {
	// // continue;
	// // }
	// UnitDescriptor hostedUnitDescriptor = (UnitDescriptor) iter.next();
	// Unit hostedUnit = hostedUnitDescriptor.getUnitValue();
	// if (hostedUnit == null) {
	// continue;
	// }
	// // for (Iterator allCapabilitiesProvidedByHostedIter =
	// hostingLink.getHosted().getCapabilities().iterator();
	// for (Iterator allCapabilitiesProvidedByHostedIter =
	// hostedUnit.getCapabilities().iterator();
	// allCapabilitiesProvidedByHostedIter.hasNext();) {
	// Capability providedCapability = (Capability)
	// allCapabilitiesProvidedByHostedIter.next();
	// if (!eClass.isSuperTypeOf(providedCapability.getEObject().eClass())) {
	// continue;
	// }
	// Object testValue = providedCapability.getEObject().eGet(eAttribute);
	// if (testValue == null) {
	// continue;
	// }
	// if (testValue.equals(valueOnUnit)) {
	// ++valueEqualityCount;
	// }
	// }
	// }
	// // assert(valueEqualityCount == 1);
	// // assert(false);
	// if (valueEqualityCount > 1) {
	// if (specificStatus != null) {
	// reporter.addStatus(specificStatus);
	// } else {
	// IDeployStatus status =
	// DeployCoreStatusUtil.createObjectAttributeInvalidStatus(c, eAttribute,
	// valueOnUnit);
	// reporter.addStatus(status);
	// }
	//			
	// }
	// }
	/**
	 * @param eDataType
	 * @param value
	 * @return true if value is valid, false if invalid (error)
	 */
	public static boolean validateEDataType(EDataType eDataType, Object value) {
		Diagnostic diag = Diagnostician.INSTANCE.validate(eDataType, value);
		if (diag.getSeverity() == Diagnostic.ERROR) {
			// Uncomment to see diagnostics printed to console
			// System.err.println(diag.getMessage());
			// for (Iterator i = diag.getChildren().iterator(); i.hasNext();) {
			// Diagnostic childDiag = (Diagnostic) i.next();
			// if (childDiag.getSeverity() == Diagnostic.ERROR) {
			// System.err.println(childDiag.getMessage());
			// }
			// }
			return false;
		}
		return true;
	}

	/**
	 * Check EAttribute on DeployModelObject as if it were a string representing a dotted version
	 * number. One part version number "x" at a minimum
	 * 
	 * @param dmo
	 *           DeployModelObject with version attribute to check
	 * @param ea
	 *           EAttribute for version attribute to check
	 * @param reporter
	 */
	public static void validateStrictVersionNumberSyntax(DeployModelObject dmo, EAttribute ea,
			IDeployReporter reporter) {
		if (dmo != null && ea != null && reporter != null) {
			String versionNumberString = (String) dmo.getEObject().eGet(ea);
			if (versionNumberString == null || versionNumberString.trim().length() == 0) {
				IDeployStatus message = DeployCoreStatusUtil.createAttributeUndefinedStatus(
						IStatus.ERROR, IDeployCoreValidators.VERSION_STRING_001, dmo, ea);
				reporter.addStatus(message);
			} else {
				// TODO change core "version" type to correspond
				boolean validOnePartVersionString = false;
				if (versionNumberString.indexOf(".") == -1) { //$NON-NLS-1$
					validOnePartVersionString = true;
					for (int i = 0; i < versionNumberString.length(); ++i) {
						if (!Character.isDigit(versionNumberString.charAt(i))) {
							validOnePartVersionString = false;
							break;
						}
					}
				}
				if (!validOnePartVersionString
						&& !ValidatorUtils.validateEDataType(CorePackage.eINSTANCE.getVersionString(),
								versionNumberString)) {
					IDeployStatus message = DeployCoreStatusUtil.createAttributeInvalidStatus(
							IStatus.ERROR, IDeployCoreValidators.VERSION_STRING_002, dmo, ea);
					reporter.addStatus(message);
				}
			}
		}
	}

	/**
	 * Check EAttribute on DeployModelObject as if it were a string representing a required version
	 * number. Legacy formats acceptable
	 * 
	 * @param dmo
	 *           DeployModelObject with version attribute to check
	 * @param ea
	 *           EAttribute for version attribute to check
	 * @param reporter
	 */
	public static void validateLooseVersionNumberSyntax(DeployModelObject dmo, EAttribute ea,
			IDeployReporter reporter) {
		if (dmo != null && ea != null && reporter != null) {
			String versionNumberString = (String) dmo.getEObject().eGet(ea);
			if (versionNumberString == null || versionNumberString.length() == 0) {
				IDeployStatus message = DeployCoreStatusUtil.createObjectAttributeUndefinedStatus(dmo,
						ea);
				reporter.addStatus(message);
			} else {
				if (!ValidatorUtils.validateEDataType(CorePackage.eINSTANCE.getGenericVersionString(),
						versionNumberString)) {
					IDeployStatus message = DeployCoreStatusUtil.createObjectAttributeInvalidStatus(dmo,
							ea);
					reporter.addStatus(message);
				}
			}
		}
	}

	/**
	 * @param sourceUnit
	 * @param targetUnit
	 * @param bottomUnitType
	 * @return true if the units are definitely non local, false if they are not or it is
	 *         undeterminable.
	 */
	public static boolean unitsAreNonLocal(Unit sourceUnit, Unit targetUnit, EClass bottomUnitType) {

		Unit current = sourceUnit;
		Unit baseSourceSideUnit = null;
		Topology topology = sourceUnit.getTopology();
		while (baseSourceSideUnit == null && current != null) {
			if (bottomUnitType.isSuperTypeOf(current.getEObject().eClass())) {
				baseSourceSideUnit = current;
			}
			// Unit[] hosts = current.getTopology().findHosts(current);
			// if (hosts.length == 1) {
			// current = hosts[0];
			// } else {
			// current = null;
			// }
			current = TopologyDiscovererService.INSTANCE.findHost(current, topology);
		}

		current = targetUnit;
		Unit baseTargetSideUnit = null;
		while (baseTargetSideUnit == null && current != null) {
			// if (current.getTopology() == null) {
			// // defend for dangling units
			// return false;
			// }

			if (bottomUnitType.isSuperTypeOf(current.getEObject().eClass())) {
				baseTargetSideUnit = current;
			}
			// Unit[] hosts = current.getTopology().findHosts(current);
			// if (hosts.length == 1) {
			// current = hosts[0];
			// } else {
			// current = null;
			// }
			current = TopologyDiscovererService.INSTANCE.findHost(current, topology);
		}

		if (baseSourceSideUnit == null || baseTargetSideUnit == null) {
			return false;
		}

		if (!baseSourceSideUnit.equals(baseTargetSideUnit)) {
			return true;
		}
		return false;
	}

	/**
	 * Retrieve a list of the capabilities of a particular type attached to a unit
	 * 
	 * @param host
	 *           the unit hosting other units being searched
	 * @return List<Unit> a list of the hosted units of the desired type
	 */
	public static List<Unit> getHosted(Unit host) {
		return getHosted(host, null);
	}

	/**
	 * Retrieve a list of the most realized units of the specified type that are hosted by the host
	 * unit or its realization peers
	 * 
	 * @param host
	 *           the unit hosting other units being searched
	 * @param hostedUnitType
	 *           the type of the hosted unit being sought
	 * @return a list of the hosted units of the desired type
	 */
	public static List<Unit> getHosted(Unit host, EClass hostedUnitType) {
		if (host == null || host.getGoalInstallState() == InstallState.NOT_INSTALLED_LITERAL) {
			return Collections.emptyList();
		}
		Topology topology = host.getEditTopology();
		if (topology == null) {
			// cannot determine host without topology
			return Collections.emptyList();
		}
		List<DeployModelObject> peerSet = RealizationLinkUtil.getRealizationLinkedPath(host,
				RealizationLinkUtil.WALK_UP);
		List<Unit> hostedUnits = new ArrayList<Unit>();
		for (Iterator<DeployModelObject> iter = peerSet.iterator(); iter.hasNext();) {
			DeployModelObject object = iter.next();
			if (object instanceof Unit) {
				Unit unit = (Unit) object;
				Collection<HostingLink> hostingLinks = topology.getRelationships().getHostedLinks(unit);
				for (Iterator<HostingLink> iter2 = hostingLinks.iterator(); iter2.hasNext();) {
					HostingLink link = iter2.next();
					if (link.getTarget() != null) {
						DeployModelObject target = RealizationLinkUtil.getFinalRealization(link
								.getTarget());
						if (target != host
								&& target instanceof Unit
								&& !hostedUnits.contains(target)
								&& (hostedUnitType == null || hostedUnitType.isSuperTypeOf(target
										.getEObject().eClass()))) {
							Unit hosted = (Unit) target;
							if (hosted.getGoalInstallState() != InstallState.NOT_INSTALLED_LITERAL) {
								List<Unit> disambiguatedHosts = getAllHosts(hosted);
								List<Unit> disambiguatedPaths = new ArrayList<Unit>();
								for (Iterator<Unit> disIter = disambiguatedHosts.iterator(); disIter
										.hasNext();) {
									disambiguatedPaths
											.addAll((Collection<? extends Unit>) RealizationLinkUtil
													.getRealizationLinkedPath(disIter.next(),
															RealizationLinkUtil.WALK_UP));
								}
								if (disambiguatedPaths.contains(host)
										|| peerSet.containsAll(disambiguatedHosts)) {
									hostedUnits.add(hosted);
								}
							}
						}

					}
				}
			}
		}
		return hostedUnits;
	}

	/**
	 * Retrieve a the first capabilities of a particular type provided by a hosted unit.
	 * <p>
	 * Warning: does not perform discovery.
	 * 
	 * @param host
	 *           the unit hosting other units being searched
	 * @param hostedCapabilityType
	 *           the type of the hosted capability being sought
	 * @return a list of the hosted units of the desired type
	 */
	public static Capability getFirstHostedCapability(Unit host, EClass hostedCapabilityType) {
		if (host == null || hostedCapabilityType == null) {
			return null;
		}
		for (Iterator<HostingLink> iter = host.getHostingLinks().iterator(); iter.hasNext();) {
			HostingLink hosteeHL = iter.next();
			if (hosteeHL == null) {
				continue;
			}
			Unit hostee = hosteeHL.getTarget();
			if (hostee == null) {
				continue;
			}
			Capability cap = getFirstCapability(hostee, hostedCapabilityType);
			if (cap != null) {
				return cap;
			}
		}
		return null;
	}

	/**
	 * Discover all units hosted by a unit.
	 * 
	 * @param host
	 *           the host unit.
	 * @param top
	 *           typically the edit topology
	 * @return a list of all the hosted units.
	 */
	public static List<Unit> discoverHosted(Unit host, Topology top, IProgressMonitor monitor) {
		List<UnitDescriptor> hostedByHostUnitDescriptors = TopologyDiscovererService.INSTANCE
				.findHosted(host, top, monitor);
		ArrayList<Unit> retList = new ArrayList<Unit>(hostedByHostUnitDescriptors.size());
		for (Iterator<UnitDescriptor> iter = hostedByHostUnitDescriptors.iterator(); iter.hasNext();) {
			UnitDescriptor hosteeUD = iter.next();
			if (hosteeUD == null) {
				continue;
			}
			Unit hostee = hosteeUD.getUnitValue();
			if (hostee != null) {
				retList.add(hostee);
			}
		}
		return retList;
	}

	/**
	 * Discover all units hosted by a unit.
	 * 
	 * @param host
	 *           the host unit.
	 * @return a list of all the hosted units.
	 */
	public static List<Unit> discoverHosted(Unit host, IProgressMonitor monitor) {
		return discoverHosted(host, host.getEditTopology(), monitor);
	}

	/**
	 * Retrieve a list of the units of a particular type attached to a unit, using discovery
	 * 
	 * @param host
	 *           the unit hosting other units being searched
	 * @param hostedUnitType
	 *           the type of the hosted unit being sought
	 * @return a list of the hosted units of the desired type
	 */
	public static List<Unit> discoverHosted(Unit host, EClass hostedUnitType,
			IProgressMonitor monitor) {
		ArrayList<Unit> retList = new ArrayList<Unit>();
		List<UnitDescriptor> hostedByHostUnitDescriptors = TopologyDiscovererService.INSTANCE
				.findHosted(host, host.getTopology(), monitor);
		for (Iterator<UnitDescriptor> iter = hostedByHostUnitDescriptors.iterator(); iter.hasNext();) {
			UnitDescriptor hosteeUD = iter.next();
			if (hosteeUD == null) {
				continue;
			}
			Unit hostee = hosteeUD.getUnitValue();
			if (hostee != null && hostedUnitType.isSuperTypeOf(hostee.getEObject().eClass())) {
				retList.add(hostee);
			}
		}
		return retList;
	}

	/**
	 * Discover all the hosted units with a capability of the specified type.
	 * 
	 * @param unit
	 *           a unit hosting other units.
	 * @param capType
	 *           the capability type.
	 * @param recurse
	 *           true if the hostees of the hostees should be searched.
	 * @return List<Unit>
	 */
	public static List<Unit> discoverHostedWithCapability(Unit unit, EClass capType,
			boolean recurse, IProgressMonitor monitor) {
		assert CorePackage.eINSTANCE.getCapability().isSuperTypeOf(capType);
		List<Unit> retList = null;
		List<UnitDescriptor> hostedByHostUnitDescriptors = TopologyDiscovererService.INSTANCE
				.findHosted(unit, unit.getTopology(), monitor);
		for (Iterator<UnitDescriptor> iter = hostedByHostUnitDescriptors.iterator(); iter.hasNext();) {
			UnitDescriptor hosteeUD = iter.next();
			if (hosteeUD == null) {
				continue;
			}
			Unit hostee = hosteeUD.getUnitValue();
			if (hostee == null) {
				continue;
			}
			for (Iterator<Capability> iter2 = hostee.getCapabilities().iterator(); iter2.hasNext();) {
				Capability cap = iter2.next();
				if (capType.isInstance(cap)) {
					if (retList == null) {
						retList = new ArrayList<Unit>();
					}
					retList.add(hostee);
					break;
				}
			}

			if (recurse) {
				List<Unit> subList = discoverHostedWithCapability(hostee, capType, true, monitor);
				if (subList.size() > 0) {
					if (retList == null) {
						retList = subList;
					} else {
						retList.addAll(subList);
					}
				}
			}

		}
		if (retList == null) {
			return Collections.emptyList();
		}
		return retList;
	}

	/**
	 * Discover all the hosted unit capabilities of the specified type.
	 * 
	 * @param unit
	 *           a unit hosting other units.
	 * @param capType
	 *           the capability type.
	 * @param recurse
	 *           true if the hostees of the hostees should be searched.
	 * @param monitor
	 *           a progress monitor for discovery.
	 * @return List<Capability>
	 */
	public static List<Capability> discoverHostedCapabilities(Unit unit, EClass capType,
			boolean recurse, IProgressMonitor monitor) {
		if (capType == null) {
			capType = CorePackage.eINSTANCE.getCapability();
		}
		assert CorePackage.eINSTANCE.getCapability().isSuperTypeOf(capType);
		if (unit == null) {
			return Collections.emptyList();
		}
		List<Capability> retList = null;

		// List of hostees to recurse and detect cycles
		List<Unit> hosteeList;
		if (recurse) {
			hosteeList = new ArrayList<Unit>();
			hosteeList.add(unit);
		} else {
			hosteeList = Collections.singletonList(unit);
		}
		int index = 0;
		while (hosteeList.size() > index) {
			Unit curr = hosteeList.get(index++);
			List<UnitDescriptor> hostedByHostUnitDescriptors = TopologyDiscovererService.INSTANCE
					.findHosted(curr, curr.getTopology(), monitor);
			for (Iterator<UnitDescriptor> iter = hostedByHostUnitDescriptors.iterator(); iter
					.hasNext();) {
				UnitDescriptor hosteeUD = iter.next();
				if (hosteeUD == null) {
					continue;
				}
				Unit hostee = hosteeUD.getUnitValue();
				if (hostee == null) {
					continue;
				}
				for (Iterator<Capability> iter2 = hostee.getCapabilities().iterator(); iter2.hasNext();) {
					Capability cap = iter2.next();
					if (capType.isInstance(cap)) {
						if (retList == null) {
							retList = new ArrayList<Capability>();
						}
						retList.add(cap);
					}
				}

				if (recurse && !hosteeList.contains(hostee)) {
					hosteeList.add(hostee);
				}
			}
		}

		if (retList == null) {
			return Collections.emptyList();
		}
		return retList;
	}

	/**
	 * Finds all the hosted unit capabilities of the specified type.
	 * <p>
	 * Does not perform discovery. Use
	 * {@link #discoverHostedCapabilities(Unit, EClass, boolean, IProgressMonitor)} instead.
	 * 
	 * @param unit
	 *           a unit hosting other units.
	 * @param capType
	 *           the capability type.
	 * @param recurse
	 *           true if the hostees of the hostees should be searched.
	 * @return List<Capability> a list of capabilities provided by hosted units of type captype.
	 */
	public static List<Capability> getHostedCapabilities(Unit unit, EClass capType, boolean recurse) {
		if (capType == null) {
			capType = CorePackage.eINSTANCE.getCapability();
		}
		assert CorePackage.eINSTANCE.getCapability().isSuperTypeOf(capType);

		if (unit == null || unit.getTopology() == null) {
			return Collections.emptyList();
		}

		List<Capability> retList = null;

		// List of hostees to recurse and detect cycles
		List<Unit> hosteeList;
		if (recurse) {
			hosteeList = new ArrayList<Unit>();
			hosteeList.add(unit);
		} else {
			hosteeList = Collections.singletonList(unit);
		}
		int index = 0;
		while (hosteeList.size() > index) {
			Unit curr = hosteeList.get(index++);
			List<Unit> hostedUnits = (List<Unit>) curr.getTopology().getRelationships()
					.getHosted(curr);
			for (Unit hostee : hostedUnits) {
				for (Iterator<Capability> iter2 = hostee.getCapabilities().iterator(); iter2.hasNext();) {
					Capability cap = iter2.next();
					if (capType.isInstance(cap)) {
						if (retList == null) {
							retList = new ArrayList<Capability>();
						}
						retList.add(cap);
					}
				}
				if (recurse && !hosteeList.contains(hostee)) {
					hosteeList.add(hostee);
				}
			}
		}

		if (retList == null) {
			return Collections.emptyList();
		}
		return retList;
	}

	/**
	 * Discover all the member units of a unit.
	 * 
	 * @param group
	 *           a unit grouping other units.
	 * @param top
	 *           typically the edit topology
	 * @return List<Unit>
	 */
	public static List<Unit> discoverMembers(Unit group, Topology top, IProgressMonitor monitor) {
		if (group == null) {
			return Collections.emptyList();
		}
		List<Unit> retList = null;
		List<UnitDescriptor> memberUnitDescriptors = TopologyDiscovererService.INSTANCE.getMembers(
				group, null, top, monitor);
		for (Iterator<UnitDescriptor> iter = memberUnitDescriptors.iterator(); iter.hasNext();) {
			UnitDescriptor memberUD = iter.next();
			if (memberUD == null) {
				continue;
			}
			Unit member = memberUD.getUnitValue();
			if (member != null) {
				if (retList == null) {
					retList = new ArrayList<Unit>();
				}
				retList.add(member);
			}
		}

		if (retList == null) {
			return Collections.emptyList();
		}

		return retList;
	}

	/**
	 * Discover all the member units of a unit.
	 * 
	 * @param group
	 *           a unit grouping other units.
	 * @param top
	 *           typically the edit topology
	 * @return List<Unit>
	 */
	public static List<Unit> discoverMembers(Unit group, IProgressMonitor monitor) {
		return discoverMembers(group, group.getEditTopology(), monitor);
	}

	/**
	 * Discover all the member units of the specified type.
	 * 
	 * @param unit
	 *           a unit grouping other units.
	 * @param unitType
	 *           the member unit type.
	 * @return List<Unit>
	 */
	public static List<Unit> discoverMembers(Unit unit, EClass unitType, IProgressMonitor monitor) {
		assert CorePackage.eINSTANCE.getUnit().isSuperTypeOf(unitType);
		if (unit == null) {
			return Collections.emptyList();
		}
		List<Unit> retList = null;
		for (Iterator<Requirement> reqIter = unit.getRequirements().iterator(); reqIter.hasNext();) {
			Requirement req = reqIter.next();
			if (unitType != null && req.getDmoEType() != null
					&& !unitType.isSuperTypeOf(req.getDmoEType())) {
				continue;
			}
			List<UnitDescriptor> memberUnitDescriptors = TopologyDiscovererService.INSTANCE
					.getMembers(unit, req, unit.getTopology(), monitor);
			for (Iterator<UnitDescriptor> iter = memberUnitDescriptors.iterator(); iter.hasNext();) {
				UnitDescriptor memberUD = iter.next();
				if (memberUD == null) {
					continue;
				}
				Unit member = memberUD.getUnitValue();
				if (member != null) {
					if (retList == null) {
						retList = new ArrayList<Unit>();
					}
					retList.add(member);
				}
			}
		}

		if (retList == null) {
			return Collections.emptyList();
		}
		return retList;
	}

	/**
	 * Discover all the member unit capabilities of the specified type.
	 * 
	 * @param unit
	 *           a unit grouping other units.
	 * @param unitType
	 *           the member unit type.
	 * @param capabilityType
	 *           the capability type of the member unit that is added to the list.
	 * @return List<Capability>
	 */
	public static List<Capability> discoverMemberCapabilities(Unit unit, EClass unitType,
			EClass capabilityType, IProgressMonitor monitor) {
		assert CorePackage.eINSTANCE.getUnit().isSuperTypeOf(unitType);
		assert CorePackage.eINSTANCE.getCapability().isSuperTypeOf(capabilityType);
		if (unit == null) {
			return Collections.emptyList();
		}
		List<Capability> retList = null;
		for (Iterator<Requirement> reqIter = unit.getMemberOrAnyRequirements().iterator(); reqIter
				.hasNext();) {
			Requirement req = reqIter.next();
			if (unitType != null && !unitType.isSuperTypeOf(req.getDmoEType())) {
				continue;
			}
			List<UnitDescriptor> memberUnitDescriptors = TopologyDiscovererService.INSTANCE
					.getMembers(unit, req, unit.getTopology(), monitor);
			for (Iterator<UnitDescriptor> iter = memberUnitDescriptors.iterator(); iter.hasNext();) {
				UnitDescriptor memberUD = iter.next();
				if (memberUD == null) {
					continue;
				}
				Unit member = memberUD.getUnitValue();
				if (member == null) {
					continue;
				}
				for (Iterator<Capability> iter2 = member.getCapabilities().iterator(); iter2.hasNext();) {
					Capability cap = iter2.next();
					if (capabilityType == null || capabilityType.isInstance(cap)) {
						if (retList == null) {
							retList = new ArrayList<Capability>();
						}
						retList.add(cap);
					}
				}
			}
		}

		if (retList == null) {
			return Collections.emptyList();
		}
		return retList;
	}

	/**
	 * Returns the unit containing the object directly or indirectly.
	 * 
	 * @param object
	 *           a deploy object.
	 * @return the unit containing the object directly or indirectly.
	 */
	public static Unit getUnit(DeployModelObject object) {
		while (object != null && !(object instanceof Unit)) {
			object = object.getParent();
		}
		return (Unit) object;
	}

	/**
	 * Returns true if the object is contained in a unit that is conceptual, false if the unit is not
	 * found or is not conceptual.
	 * 
	 * @param object
	 *           a deploy object.
	 * @return true if the object is contained in a conceptual unit, false otherwise.
	 */
	public static boolean isConceptual(DeployModelObject object) {
		if (object == null) {
			return false;
		}
		Unit unit = getUnit(object);
		if (unit == null) {
			return false;
		}
		return unit.isConceptual();
	}

	/**
	 * Returns the deploy statuses of the object and all its contained objects.
	 * 
	 * @param object
	 *           a deploy object.
	 * @param statusType
	 *           a subtype of {@link IDeployStatus}; optional, may be null.
	 * @return List<IDeployStatus>
	 */
	public static List<IDeployStatus> getDeployStatusRecursive(DeployModelObject object,
			Class statusType) {
		if (object == null) {
			return Collections.emptyList();
		}

		Topology t = object.getEditTopology();
		List<IDeployStatus> wrappedStatuses = new ArrayList<IDeployStatus>();
		for (Iterator iter = t.findAllDeployModelObjects(); iter.hasNext();) {
			DeployModelObject dmo = (DeployModelObject) iter.next();
			if (dmo.getStatus().isOK()) {
				continue;
			}
			for (Iterator<IDeployStatus> iter2 = new DeployStatusIterator(dmo,
					DeployWrapperStatus.class); iter2.hasNext();) {
				wrappedStatuses.add(((DeployWrapperStatus) iter2.next()).getWrappedStatus());
			}
		}

		List<IDeployStatus> result = new ArrayList<IDeployStatus>();
		List<DeployModelObject> stack = new LinkedList<DeployModelObject>();
		stack.add(object);
		while (stack.size() > 0) {
			DeployModelObject cur = stack.remove(0);
			for (Iterator<DeployModelObject> iter = cur.getContainedModelObjects().iterator(); iter
					.hasNext();) {
				stack.add(iter.next());
			}

			if (cur.getStatus() != Status.OK_STATUS) {
				for (Iterator<IDeployStatus> iter2 = new DeployStatusIterator(cur, statusType); iter2
						.hasNext();) {
					IDeployStatus status = iter2.next();
					result.add(status);
				}
			}

			for (IDeployStatus status : wrappedStatuses) {
				if (cur == status.getDeployObject()) {
					result.add(status);
				}
			}
		}
		return result;
	}

	/**
	 * Finds the first group of the specified unit type which contains the member unit in the
	 * topology.
	 * <p>
	 * Note: does not perform discovery. Use {@link #discoverGroupByUnitType(Unit, EClass)}.
	 * 
	 * @param member
	 *           the member unit of the group.
	 * @param groupUnitType
	 *           the type of the group unit.
	 * @return the first unit of the specified type grouping the member in the topology, or null if
	 *         not found.
	 */
	public static Unit findGroupByUnitType(Unit member, EClass groupUnitType) {
		if (member == null || member.getTopology() == null || groupUnitType == null) {
			return null;
		}

		Unit[] groupUnits = member.getTopology().findMemberOf(member);
		for (int i = 0; i < groupUnits.length; i++) {
			if (groupUnitType.isInstance(groupUnits[i])) {
				return groupUnits[i];
			}
		}

		return null;
	}

	public static List<Unit> findAllRGroupsByUnitType(Unit member, EClass groupUnitType) {
		if (member == null || member.getEditTopology() == null || groupUnitType == null) {
			return null;
		}

		for (Requirement req : (List<Requirement>) member.getMemberOrAnyRequirements()) {
			if (groupUnitType.isSuperTypeOf(req.getDmoEType())) {
				return getGroups(member, req);
			}
		}

		return Collections.emptyList();
	}

	public static Unit findRGroupsByUnitType(Unit member, EClass groupUnitType) {
		List<Unit> groups = findAllRGroupsByUnitType(member, groupUnitType);
		return groups.get(0);
	}

	/**
	 * Finds the first group of the providing the specifiec capability type which contains the member
	 * unit in the topology.
	 * <p>
	 * Note: does not perform discovery. Use {@link #discoverGroupByCapabilityType(Unit, EClass)}.
	 * 
	 * @param member
	 *           the member unit of the group.
	 * @param groupCapabilityType
	 *           a capability type provided by the group unit.
	 * @return the first unit of the specified type grouping the member in the topology, or null if
	 *         not found.
	 */
	public static Capability findGroupByCapabilityType(Unit member, EClass groupCapabilityType) {
		if (member == null || member.getTopology() == null || groupCapabilityType == null) {
			return null;
		}

		Unit[] groupUnits = member.getTopology().findMemberOf(member);
		for (int i = 0; i < groupUnits.length; i++) {
			for (Iterator iter = groupUnits[i].getCapabilities().iterator(); iter.hasNext();) {
				Capability cap = (Capability) iter.next();
				if (groupCapabilityType.isInstance(cap)) {
					return cap;
				}
			}
		}

		return null;
	}

	/**
	 * Discover all the units which group the member.
	 * 
	 * @param member
	 *           a topology unit.
	 * @return List<Unit>
	 */
	public static List<Unit> discoverGroups(Unit member, IProgressMonitor monitor) {
		if (member == null) {
			return Collections.emptyList();
		}
		List<Unit> retList = null;
		List<UnitDescriptor> groupUnitDescriptors = TopologyDiscovererService.INSTANCE.getGroups(
				member, null, member.getTopology(), monitor);
		for (Iterator<UnitDescriptor> iter = groupUnitDescriptors.iterator(); iter.hasNext();) {
			UnitDescriptor groupUD = iter.next();
			if (groupUD == null) {
				continue;
			}
			Unit group = groupUD.getUnitValue();
			if (group != null) {
				if (retList == null) {
					retList = new ArrayList<Unit>();
				}
				retList.add(group);
			}
		}

		if (retList == null) {
			return Collections.emptyList();
		}

		return retList;
	}

	/**
	 * Discovers the first group of the specified unit type which contains the member unit.
	 * 
	 * @param member
	 *           the member unit of the group.
	 * @param groupUnitType
	 *           the type of the group unit.
	 * @return the first unit of the specified type grouping the member.
	 */
	public static Unit discoverGroupByUnitType(Unit member, EClass groupUnitType,
			IProgressMonitor monitor) {
		if (member == null || member.getTopology() == null || groupUnitType == null) {
			return null;
		}

		// Look in topology first.
		//MK 8/8/2007 want to find most realized groups as discovery will
//		Unit group = findGroupByUnitType(member, groupUnitType);
//		if (group != null) {
//			return group;
//		}
		List<Unit> gps = findAllRGroupsByUnitType(member, groupUnitType);
		if (gps != null && gps.size() > 0) {
			return gps.get(0);
		}

		// Fallback to discovery.
		List<UnitDescriptor> groups = TopologyDiscovererService.INSTANCE.getGroups(member, null,
				member.getTopology(), monitor);
		for (Iterator<UnitDescriptor> iter = groups.iterator(); iter.hasNext();) {
			UnitDescriptor descr = iter.next();
			Unit unit = descr.getUnitValue();
			if (groupUnitType.isInstance(unit)) {
				return unit;
			}
		}

		return null;
	}

	/**
	 * Discovers the groups of the specified unit type which contains the member unit.
	 * 
	 * @param member
	 *           the member unit of the group.
	 * @param groupUnitType
	 *           the type of the group unit.
	 * @param top
	 *           the topology to do discovery on
	 * @return list of groups of the specified type grouping the member.
	 */
	public static List<Unit> discoverGroupsByUnitType(Unit member, EClass groupUnitType,
			Topology top, IProgressMonitor monitor) {
		if (member == null || groupUnitType == null) {
			return Collections.emptyList();
		}

		// MK 8/8/2007: 
//		// Look in topology first.
//		Unit groupsArray[] = top.findMemberOf(member);
//		if (groupsArray.length != 0) {
//			ArrayList<Unit> groups = new ArrayList<Unit>();
//			for (int i = 0; i < groupsArray.length; i++) {
//				if (groupUnitType.isInstance(groupsArray[i])) {
//					groups.add(groupsArray[i]);
//				}
//			}
//			return groups;
//		}
		List<Unit> gps = findAllRGroupsByUnitType(member, groupUnitType);
		if (gps != null && gps.size() > 0) {
			return gps;
		}

		// MK: not sure why we "fall back"  Seem like we should always call discovery
		// Fallback to discovery.
		List<UnitDescriptor> allGroups = TopologyDiscovererService.INSTANCE.getGroups(member, null,
				top, monitor);
		ArrayList<Unit> groups = new ArrayList<Unit>();
		for (Iterator<UnitDescriptor> iter = allGroups.iterator(); iter.hasNext();) {
			UnitDescriptor descr = iter.next();
			Unit unit = descr.getUnitValue();
			if (groupUnitType.isInstance(unit)) {
				groups.add(unit);
			}
		}
		return groups;
	}

	/**
	 * Discovers the first group of the specified unit type which contains the member unit.
	 * 
	 * @param member
	 *           the member unit of the group.
	 * @param groupCapabilityType
	 *           a capability type provided by the group unit.
	 * @return the first unit of the specified type grouping the member, or null if not found.
	 */
	public static Capability discoverGroupByCapabilityType(Unit member, EClass groupCapabilityType,
			IProgressMonitor monitor) {
		if (member == null || member.getTopology() == null || groupCapabilityType == null) {
			return null;
		}

		// Look in topology first.
		Capability cap = findGroupByCapabilityType(member, groupCapabilityType);
		if (cap != null) {
			return cap;
		}

		// Fallback to discovery.
		List groups = TopologyDiscovererService.INSTANCE.getGroups(member, null,
				member.getTopology(), monitor);
		for (Iterator iter = groups.iterator(); iter.hasNext();) {
			UnitDescriptor descr = (UnitDescriptor) iter.next();
			Unit unit = descr.getUnitValue();
			for (Iterator iter2 = unit.getCapabilities().iterator(); iter2.hasNext();) {
				cap = (Capability) iter2.next();
				if (groupCapabilityType.isInstance(cap)) {
					return cap;
				}
			}
		}

		return null;
	}

	/**
	 * Discovers the first group of the specified unit type which contains the member unit.
	 * 
	 * @param member
	 *           the member unit of the group.
	 * @param groupCapabilityType
	 *           a capability type provided by the group unit.
	 * @return the unit descriptor of the first unit providing the specified capability.
	 */
	public static UnitDescriptor discoverGroupDescriptorByCapabilityType(Unit member,
			EClass groupCapabilityType, IProgressMonitor monitor) {
		if (member == null || member.getTopology() == null || groupCapabilityType == null) {
			return null;
		}

		List groups = TopologyDiscovererService.INSTANCE.getGroups(member, null,
				member.getTopology(), monitor);
		for (Iterator iter = groups.iterator(); iter.hasNext();) {
			UnitDescriptor descr = (UnitDescriptor) iter.next();
			Unit unit = descr.getUnitValue();
			for (Iterator iter2 = unit.getCapabilities().iterator(); iter2.hasNext();) {
				Capability cap = (Capability) iter2.next();
				if (groupCapabilityType.isInstance(cap)) {
					return descr;
				}
			}
		}

		return null;
	}

	public static int ncFilteredSize(List<Unit> inputUnits) {
		if (null == inputUnits || inputUnits.isEmpty()) {
			return 0;
		}

		int size = 0;
		for (Unit in : inputUnits) {
			if (!in.isConceptual()) {
				size++;
			}
		}

		if (0 == size) {
			// no concrete units; there is at least one conceptual unit
			size = 1;
		}

		return size;
	}

	/**
	 * Validates the propagation of the source attribute to the target attribute.
	 * 
	 * @param source
	 *           the source object.
	 * @param sourceAttribute
	 *           the source object's attribute.
	 * @param target
	 *           the target object.
	 * @param targetAttribute
	 *           the target object's attribute.
	 * @param validatorID
	 *           the ID of the validator if the propagation check fails.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           the validation status reporter.
	 */
	public static void validatePropagation(DeployModelObject source, EAttribute sourceAttribute,
			DeployModelObject target, EAttribute targetAttribute, String validatorID,
			IDeployValidationContext context, IDeployReporter reporter) {
		assert context != null;
		if (source == null || target == null) {
			return;
		}
		if (sourceAttribute == null || targetAttribute == null) {
			return;
		}
		if (!sourceAttribute.getContainerClass().isInstance(source)) {
			DeployCorePlugin.log(IStatus.ERROR, 0, "Propagation source is not an instance of "//$NON-NLS-1$ 
					+ sourceAttribute.getEContainingClass().getName() + ": " //$NON-NLS-1$
					+ source.eClass().getName(), new Exception());
			return;
		}
		if (!targetAttribute.getContainerClass().isInstance(target)) {
			DeployCorePlugin.log(IStatus.ERROR, 0, "Propagation target is not an instance of "//$NON-NLS-1$ 
					+ sourceAttribute.getEContainingClass().getName() + ": " //$NON-NLS-1$
					+ target.eClass().getName(), new Exception());
			return;
		}
		Object sourceValue = source.eGet(sourceAttribute);
		Object targetValue = target.eGet(targetAttribute);
		if (sourceValue == null) {
			// treat null as don't care
			return;
		}

		if (!sourceValue.equals(targetValue)) {
			reporter.addStatus(DeployCoreStatusUtil.createAttributeInvalidSourceValueStatus(
					IStatus.ERROR, validatorID, target, targetAttribute, source, sourceAttribute));
		}
	}

	/**
	 * Validates the value of a deploy object attribute.
	 * 
	 * @param object
	 *           the deploy object.
	 * @param attribute
	 *           the deploy object's attribute.
	 * @param expectedValue
	 *           the desired value.
	 * @param validatorID
	 *           the ID of the validator if the propagation check fails.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           the validation status reporter.
	 */
	public static void validateEquals(DeployModelObject object, EAttribute attribute,
			Object expectedValue, String validatorID, IDeployValidationContext context,
			IDeployReporter reporter) {
		assert context != null;
		if (object == null || attribute == null) {
			return;
		}
		if (!attribute.getContainerClass().isInstance(object)) {
			return;
		}
		Object currentValue = object.eGet(attribute);

		if (!equals(currentValue, expectedValue)) {
			reporter.addStatus(DeployCoreStatusUtil.createAttributeInvalidStatus(IStatus.ERROR,
					validatorID, object, attribute, expectedValue));
		}
	}

	/**
	 * Returns true if the object is null or is an empty string.
	 * 
	 * @param object
	 *           an object.
	 * @return true if the object is null or is an empty string.
	 */
	public static boolean isNullOrEmpty(Object object) {
		if (object == null) {
			return true;
		}
		if (object instanceof String) {
			return ((String) object).length() == 0;
		}
		return false;
	}

	/**
	 * Returns the first member link from the group to the member.
	 * 
	 * @param group
	 *           the member link source.
	 * @param member
	 *           the member link target.
	 * @return the first matching member link, or null if not found.
	 */
	public static MemberLink getFirstMemberLink(Unit group, Unit member) {
		if (group == null || member == null) {
			return null;
		}
		for (Iterator iter = group.getMemberLinks().iterator(); iter.hasNext();) {
			MemberLink mLink = (MemberLink) iter.next();
			if (mLink.getTarget() == member) {
				return mLink;

			}
		}
		return null;
	}

	/**
	 * Checks if the first unit hosts the second unit argument.
	 * 
	 * @param host
	 *           the host unit.
	 * @param hosted
	 *           the hosted unit.
	 * @return true if host has a hosting link to the hosted.
	 */
	public static boolean hosts(Unit host, Unit hosted) {
		if (host == null || host.getTopology() == null || hosted == null) {
			return false;
		}
		for (Iterator iter = host.getHostingLinks().iterator(); iter.hasNext();) {
			HostingLink link = (HostingLink) iter.next();
			if (link.getTarget() == hosted) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if the first unit groups the second unit argument.
	 * 
	 * @param group
	 *           the group unit.
	 * @param member
	 *           the member unit.
	 * @return true if group has a member link to the member.
	 */
	public static boolean groups(Unit group, Unit member) {
		if (group == null || group.getTopology() == null || member == null) {
			return false;
		}
		for (Iterator iter = group.getMemberLinks().iterator(); iter.hasNext();) {
			MemberLink link = (MemberLink) iter.next();
			if (link.getTarget() == member) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Discovers a unit grouping the member unit by unit or capability type.
	 * 
	 * @param member
	 *           the member unit.
	 * @param type
	 *           the capability or requirement type of the group.
	 * @return the group unit if found, null if not.
	 */
	public static Unit discoverGroupAndAddToTopology(Unit member, EClass type,
			IProgressMonitor monitor) {
		if (member == null || member.getTopology() == null || type == null) {
			return null;
		}
		for (Iterator iter = member.getMemberOrAnyRequirements().iterator(); iter.hasNext();) {
			Requirement req = (Requirement) iter.next();
			if (type.equals(req.getDmoEType())) {
				List list = TopologyDiscovererService.INSTANCE.getGroups(member, req, member
						.getTopology(), monitor);
				for (Iterator iter2 = list.iterator(); iter2.hasNext();) {
					UnitDescriptor descriptor = (UnitDescriptor) iter2.next();
					return descriptor.getUnitValueAndAddToTopology(member.getTopology());
				}
			}
		}
		return null;
	}

	/**
	 * Returns an iterator over all instances of a specified type contained in the topology.
	 * 
	 * @param top
	 *           a deployment topology.
	 * @param type
	 *           a subtype of {@link DeployModelObject}.
	 * @return Iterator<type>
	 */
	public static Iterator findAllInstances(Topology top, EClass type) {
		if (type == null || type == CorePackage.Literals.DEPLOY_MODEL_OBJECT) {
			return top.findAllDeployModelObjects();
		}
		EObjectTypeFilter filter = new EObjectTypeFilter(type, true);
		if (CorePackage.Literals.UNIT.isSuperTypeOf(type)) {
			return new FilterIterator(top.findAllUnits(), filter);
		}
		if (CorePackage.Literals.CAPABILITY.isSuperTypeOf(type)) {
			return new FilterIterator(top.findAllCapabilities(), filter);
		}
		return new FilterIterator(top.findAllDeployModelObjects(), filter);
	}

	/**
	 * Determines if the unit or any other units that it is a member of ( recursivly ) is hosted.
	 * 
	 * @param unit
	 *           the unit that will be tested for hosted status
	 * @return true if the unit or any of the units it's a member of ( recursivly ) are hosted
	 */
	public static boolean isHosted(Unit unit) {
		List hosts = findHosts(unit);
		if (hosts.size() > 0) {
			return true;
		}

		// MK 08/07/2008 - defect 6781: limit this to SoftwareComponents
		if (CorePackage.Literals.SOFTWARE_COMPONENT.isSuperTypeOf(unit.getEObject().eClass())) {
			Unit sc = ValidatorUtils
					.findGroupByUnitType(unit, CorePackage.Literals.SOFTWARE_COMPONENT);
			if (null != sc) {
				return isHosted(sc);
			}
		}

		return false;
	}

	/**
	 * Returns a List of all the units that the passed in unit is considered to be hosted on.
	 * 
	 * @param unit
	 *           the unit that is hosted by the returned list of units
	 * @return a list of units that conscider the passed in unit to be hosted on.
	 * @deprecated use {@link #getAllHosts(Unit)}.
	 */
	public static List findHosts(Unit unit) {
		return getAllHosts(unit);
	}

	/**
	 * Returns a List of all the units that the passed in unit is considered to be a member of.
	 * 
	 * @param member
	 *           the unit that is a member of the units returned by this method.
	 * @return a list of units that consider the passed in unit to be a member of.
	 */
	public static List<Unit> findMemberships(Unit member) {
		return getGroups(member);
	}

	/**
	 * Returns a List of all the units that are considered members of the passed in unit.
	 * 
	 * @param unit
	 *           the unit to look for members on.
	 * @return a list of all the units that are considered members of the passed in unit.
	 * @deprecated use {@link #getMembers(Unit)}.
	 */
	public static List findMembers(Unit unit) {
		return getMembers(unit);
	}

	/**
	 * Returns the immediate host of the unit in the topology and its imported topologies.
	 * <p>
	 * Unlike {@link #getHost(Unit)} which navigates the unit's and its host realization links to
	 * find the most realized unit, this method returns the immediate host of the unit, independent
	 * of whether it is conceptual or not.
	 * 
	 * @param unit
	 *           a hosted topology unit.
	 * @return the immediate host unit, or null if it does not exist or is ambiguous.
	 * 
	 * @see #getHost(Unit, boolean)
	 */
	public static Unit getImmediateHost(Unit unit) {
		List hosts = getImmediateHosts(unit);
		if (hosts.size() != 1) {
			return null;
		}
		return (Unit) hosts.get(0);
	}

	/**
	 * Returns the set of immediate hosts of the unit in the topology and its imported topologies.
	 * 
	 * @param unit
	 *           a hosted topology unit.
	 * @return Set<Unit> the immediate host units.
	 * 
	 * @see #getHost(Unit, boolean)
	 */
	public static List<Unit> getImmediateHosts(Unit unit) {
		Topology topology = unit.getTopology();
		if (topology == null) {
			// cannot determine host without topology
			return Collections.emptyList();
		}
		Unit[] hosters = topology.findHosts(unit);
		if (hosters.length == 1) {
			return Collections.singletonList(hosters[0]);
		} else if (hosters.length > 1) {
			return Arrays.asList(hosters);
		}
		return Collections.emptyList();
	}

	/**
	 * Returns a list of units immediately hosted by the unit in the topology and its imported
	 * topologies.
	 * <p>
	 * Does not perform discovery. Validators should use {@link #discoverHosted(Unit, EClass)}.
	 * 
	 * @param host
	 *           the host unit.
	 * @return List<Unit> of units hosted directly (may include conceptual units).
	 * @see #getHosted(Unit, EClass)
	 */
	public static List<Unit> getImmediateHosted(Unit host) {
		return getImmediateHosted(host, null);
	}

	/**
	 * Returns a list of units filtered by type that are immediately hosted by the unit in the
	 * topology and its imported topologies.
	 * <p>
	 * Does not perform discovery. Validators should use {@link #discoverHosted(Unit, EClass)}.
	 * 
	 * @param host
	 *           the host unit.
	 * @param type
	 *           an optional unit or capability type used to filter the list of hosted units returned
	 *           (null means any).
	 * @return List<Unit> of units hosted directly (may include conceptual units).
	 * @see #getHosted(Unit, EClass)
	 */
	public static List<Unit> getImmediateHosted(Unit host, EClass type) {
		if (host == null) {
			return Collections.emptyList();
		}
		Topology editTopology = host.getEditTopology();
		if (editTopology == null) {
			return Collections.emptyList();
		}

		ArrayList<Unit> list = null;

//		for (Iterator<Unit> iter = editTopology.findAllHostingLinks(); iter.hasNext();) {
//			HostingLink link = (HostingLink) iter.next();
//			if (host.equals(link.getSource())) {
//				Unit hosted = link.getTarget();
		for (Unit hosted : editTopology.getRelationships().getHosted(host)) {
			if (type == null || CorePackage.Literals.UNIT.isSuperTypeOf(type)
					&& type.isInstance(hosted) || CorePackage.Literals.CAPABILITY.isSuperTypeOf(type)
					&& ValidatorUtils.getFirstCapability(hosted, type) != null) {
				if (list == null) {
					list = new ArrayList<Unit>();
				}
				list.add(hosted);
			}
		}
		if (list == null) {
			return Collections.emptyList();
		}
		return list;
	}

	/**
	 * Returns the immediate target of the dependency link.
	 * <p>
	 * Dependency links on requirements in the edit topology are contained by the requirement, and on
	 * imported topologies may be contained in the topology or on the requirement.
	 * <p>
	 * Because dependency links can be contained in the topology, it is possible to have multiple
	 * dependency links from a requirement. This is not semantically valid.
	 * 
	 * @param req
	 *           a topology requirement.
	 * @return the capability linked to the requirement, or null if none or ambigious.
	 */
	public static Capability getImmediateDependencyLinkTarget(Requirement req) {
		if (req == null) {
			return null;
		}
		if (req.getLink() == null) {
			return null;
		}
		return req.getLink().getTarget();
	}

	/**
	 * Returns the list of dependency link capability targets whose immediate source is the
	 * requirement.
	 * 
	 * @param req
	 *           a topology requirement.
	 * @return List<Capability>
	 */
	public static List<Capability> getImmediateDependencyLinkTargets(Requirement req) {
		if (req == null) {
			return Collections.emptyList();
		}
		Topology editTopology = req.getEditTopology();
		if (editTopology == null) {
			return Collections.emptyList();
		}

		List<Capability> list = null;
		Capability target = null;
//		for (Iterator<DependencyLink> iter = req.getEditTopology().findAllDependencyLinks(); iter
//				.hasNext();) {
//			DependencyLink link = iter.next();
		for (DependencyLink link : editTopology.getRelationships().getDependencyTargetsLinks(req)) {
			if (req.equals(link.getSource()) && link.getTarget() != null) {
				if (target == null) {
					target = link.getTarget();
				} else {
					if (list == null) {
						list = new ArrayList<Capability>();
						list.add(target);
					}
					list.add(link.getTarget());
				}
			}
		}
		if (list != null) {
			return list;
		}
		if (target != null) {
			return Collections.singletonList(target);
		}
		return Collections.emptyList();
	}

	/**
	 * Returns a list of requirements that immediately depend on the capability.
	 * 
	 * @param cap
	 *           a topology capability.
	 * @return List<Requirement> that are sources to dependency links whose target is the capability.
	 */
	public static List<Requirement> getImmediateDependencyLinkSources(Capability cap) {
		if (cap == null) {
			return Collections.emptyList();
		}
		Topology top = cap.getEditTopology();
		if (top == null) {
			return Collections.emptyList();
		}
		Requirement[] reqs = top.findDependentRequirements(cap);
		if (reqs.length == 0) {
			return Collections.emptyList();
		}
		return Arrays.asList(reqs);
	}

	/**
	 * Returns a list of groups that are immediate sources to a member link whose target is the
	 * member.
	 * <p>
	 * This methods will return all units that group a unit independent of the group unit type (see
	 * {@link #getImmediateGroups(Unit, Requirement)}).
	 * 
	 * @param member
	 *           the topology unit.
	 * @return List<Unit> of units that are sources to hosting links targeting the member.
	 */
	public static List<Unit> getImmediateGroups(Unit member) {
		if (member == null) {
			return Collections.emptyList();
		}
		Topology top = member.getEditTopology();
		if (top == null) {
			return Collections.emptyList();
		}
		Unit[] groups = top.findMemberOf(member);
		if (groups.length == 0) {
			return Collections.emptyList();
		}
		return Arrays.asList(groups);
	}

	/**
	 * Returns a list of members that are immediate targets to a member link whose source is the
	 * group.
	 * <p>
	 * This methods will return all units that group a unit independent of the group unit type (see
	 * {@link #getImmediateMembers(Unit, Requirement)}).
	 * 
	 * @param group
	 *           the topology unit.
	 * @return List<Unit> of units that are targets to hosting links whose source is the group.
	 */
	public static List<Unit> getImmediateMembers(Unit group) {
		if (group == null) {
			return Collections.emptyList();
		}
		Topology editTopology = group.getEditTopology();
		if (editTopology == null) {
			return Collections.emptyList();
		}

		List<Unit> result = new ArrayList<Unit>();
		for (Iterator<MemberLink> iter = editTopology.findAllMemberLinks(); iter.hasNext();) {
			MemberLink link = iter.next();
			if (group.equals(link.getSource())) {
				Unit target = link.getTarget();
				if (target != null) {
					result.add(target);
				}
			}
		}
		return result;
	}

	/**
	 * Returns a list of groups that have a member link to the member unit on a specific requirement
	 * DMO type.
	 * 
	 * @param member
	 *           the member unit.
	 * @param req
	 *           the requirement identifying the group unit or capability type (null means any).
	 * @return List<Unit> list of groups of the specified requirement type.
	 */
	public static List<Unit> getImmediateGroups(Unit member, Requirement req) {
		if (member == null) {
			return Collections.emptyList();
		}
		if (req == null || req.getDmoEType() == null) {
			return getImmediateGroups(member);
		}
		Topology top = member.getEditTopology();
		if (top == null) {
			return Collections.emptyList();
		}
		Unit[] groups = top.findMemberOf(member);
		if (groups.length == 0) {
			return Collections.emptyList();
		}

		EClass type = req.getDmoEType();
		if (CorePackage.Literals.UNIT.isSuperTypeOf(type)) {
			ArrayList<Unit> list = new ArrayList<Unit>(groups.length);
			for (int i = 0; i < groups.length; i++) {
				if (type.isInstance(groups[i])) {
					list.add(groups[i]);
				}
			}
			return list;
		}
		if (CorePackage.Literals.CAPABILITY.isSuperTypeOf(type)) {
			ArrayList<Unit> list = new ArrayList<Unit>(groups.length);
			for (int i = 0; i < groups.length; i++) {
				if (getFirstCapability(groups[i], type) != null) {
					list.add(groups[i]);
				}
			}
			return list;
		}
		return Collections.emptyList();
	}

	/**
	 * Returns a list of units that are targets of hosting links whose source is the group.
	 * 
	 * @param group
	 *           a topology unit.
	 * @return List<Unit> of units that are targets of hosting links whose source is the group unit.
	 */
	public static List<Unit> findImmediateMembers(Unit group) {
		if (group == null) {
			return Collections.emptyList();
		}
		List<HostingLink> hostingLinks = group.getHostingLinks();
		if (hostingLinks.size() == 0) {
			return Collections.emptyList();
		}
		if (hostingLinks.size() == 1) {
			HostingLink link = hostingLinks.get(0);
			if (link.getTarget() == null) {
				return Collections.emptyList();
			}
			return Collections.singletonList(link.getTarget());
		}
		ArrayList<Unit> list = new ArrayList<Unit>(hostingLinks.size());
		for (int i = 0; i < hostingLinks.size(); i++) {
			HostingLink link = hostingLinks.get(i);
			if (link.getTarget() != null) {
				list.add(link.getTarget());
			}
		}
		return list;
	}

	/**
	 * Discovers the target unit of the requirement's dependency link.
	 * 
	 * @param req
	 *           a unit requirement.
	 * @param top
	 *           typically the edit topology
	 * @return the unit containing the capability that the requirement targets, or null if not found.
	 */
	public static Unit discoverDependencyLinkTargetUnit(Requirement req, Topology top,
			IProgressMonitor monitor) {
		if (req == null) {
			return null;
		}

		Unit unit = getUnit(req);
		if (unit == null) {
			return null;
		}

		UnitDescriptor ud = TopologyDiscovererService.INSTANCE.findTarget(unit, req, top);
		if (ud == null) {
			return null;
		}
		Unit targetUnit = ud.getUnitValue();
		if (targetUnit == null) {
			return null;
		}

		return targetUnit;
	}

	public static Unit discoverDependencyLinkTargetUnit(Requirement req, IProgressMonitor monitor) {
		return discoverDependencyLinkTargetUnit(req, req.getEditTopology(), monitor);
	}

	/**
	 * Discovers the target of the requirement's dependency link.
	 * 
	 * @param req
	 *           a unit requirement.
	 * @param top
	 *           typically the edit topology
	 * @param relaxedDmoType
	 *           if false: discover target that is an instance of req.dmoType if true: discover
	 *           target that may not only be an instance of req.dmoType, but possibly also a
	 *           supertype of req.dmoType.
	 * @return the capability that the requirement targets, or null if not found.
	 */
	public static Capability discoverDependencyLinkTarget(Requirement req, Topology top,
			boolean relaxedDmoType, IProgressMonitor monitor) {
//		if (req == null) {
//			return null;
//		}
//
//		Unit unit = getUnit(req);
//		if (unit == null) {
//			return null;
//		}
//		UnitDescriptor ud = TopologyDiscovererService.INSTANCE.findTarget(unit,
//				req, top);
//		if (ud == null) {
//			return null;
//		}
//		Unit targetUnit = ud.getUnitValue();
		Unit targetUnit = discoverDependencyLinkTargetUnit(req, top, monitor);
		if (targetUnit == null) {
			return null;
		}
		if (req.getDmoEType() == null) {
			if (targetUnit.getCapabilities().size() > 0) {
				return (Capability) targetUnit.getCapabilities().get(0);
			}
			return null;
		}

		Capability cap = getFirstCapability(targetUnit, req.getDmoEType());
		if (cap != null) {
			return cap;
		}
		if (relaxedDmoType) {
			// will llok also for capabilities that are supertypes of req.getDmoEtype()
			return getFirstCapabilitySupertype(targetUnit, req.getDmoEType());
		}
		return cap;
	}

	/**
	 * Discovers the target of the requirement's dependency link.
	 * 
	 * @param req
	 *           a unit requirement.
	 * @param top
	 *           typically the edit topology
	 * @return the capability that the requirement targets, or null if not found.
	 */
	public static Capability discoverDependencyLinkTarget(Requirement req, Topology top,
			IProgressMonitor monitor) {
		return discoverDependencyLinkTarget(req, top, false, monitor);
	}

	/**
	 * Discovers the target of the requirement's dependency link.
	 * 
	 * @param req
	 *           a unit requirement.
	 * @return the capability that the requirement targets, or null if not found.
	 */
	public static Capability discoverDependencyLinkTarget(Requirement req, IProgressMonitor monitor) {
		return discoverDependencyLinkTarget(req, req.getEditTopology(), monitor);
	}

	/**
	 * Discover the requirements that are depending on the capability.
	 * 
	 * @param cap
	 *           a topology capability.
	 * @param top
	 *           typically the edit topology
	 * @return List<Requirement> of requirements depending on the capability.
	 */
	public static List<Requirement> discoverDependencyLinkSources(Capability cap, Topology top,
			IProgressMonitor monitor) {
		if (cap == null) {
			return Collections.emptyList();
		}
		Unit unit = getUnit(cap);
		if (unit == null) {
			return Collections.emptyList();
		}
		List<UnitDescriptor> udList = TopologyDiscovererService.INSTANCE.findSources(unit, cap, top,
				monitor);
		if (udList.size() == 0) {
			return Collections.emptyList();
		}
		List<Requirement> reqList = new ArrayList<Requirement>(udList.size());
		for (int i = 0; i < udList.size(); i++) {
			UnitDescriptor ud = udList.get(i);
			Unit sourceUnit = ud.getUnitValue();
			if (sourceUnit != null) {
				Requirement req = getFirstRequirement(sourceUnit, cap.getEObject().eClass(), true);
				if (req != null) {
					reqList.add(req);
				}
			}
		}
		return reqList;
	}

	/**
	 * Discover the requirements that are depending on the capability.
	 * 
	 * @param cap
	 *           a topology capability.
	 * @return List<Requirement> of requirements depending on the capability.
	 */
	public static List<Requirement> discoverDependencyLinkSources(Capability cap,
			IProgressMonitor monitor) {
		return discoverDependencyLinkSources(cap, cap.getEditTopology(), monitor);
	}

	/**
	 * Finds the most realized target of the requirement's dependency link.
	 * 
	 * @param req
	 *           a topology requirement.
	 * @return the most realized capability, or null if not defined or ambigious.
	 */
	public static Capability getDependencyLinkTarget(Requirement req) {
		List<Capability> list = getDependencyLinkTargets(req);
		if (list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * Finds the most realized target of the requirement's dependency link.
	 * 
	 * @param req
	 *           a topology requirement.
	 * @return Set<Capability> the most realized capabilities that are the target of the
	 *         requirement's link.
	 */
	public static List<Capability> getDependencyLinkTargets(Requirement req) {
		if (req == null) {
			return Collections.emptyList();
		}
		Unit reqUnit = getUnit(req);
		Topology topology = req.getEditTopology();
		if (reqUnit == null || topology == null) {
			return Collections.emptyList();
		}
		if (reqUnit.getGoalInstallState() == InstallState.NOT_INSTALLED_LITERAL) {
			return Collections.emptyList();
		}
		Collection<DeployModelObject> reqPeerColl = RealizationLinkUtil
				.getAllImplicitRealizationLinkedObjects(req);
		List<Capability> targetList = new ArrayList<Capability>();
		for (DeployModelObject object : reqPeerColl) {
			if (object instanceof Requirement) {
				Requirement reqPeerReal = (Requirement) object;
				if (reqPeerReal.getLink() != null && reqPeerReal.getLink().getTarget() != null) {
					Capability cap = reqPeerReal.getLink().getTarget();
					DeployModelObject capReal = RealizationLinkUtil.getImplicitFinalRealization(cap);
					if (capReal instanceof Capability && !targetList.contains(capReal)) {
						Unit capUnit = getUnit(capReal);
						if (capUnit == null
								|| capUnit.getGoalInstallState() != InstallState.NOT_INSTALLED_LITERAL) {
							targetList.add((Capability) capReal);
						}
					}
				}
			}
		}
		return targetList;
	}

	/**
	 * Finds the most realized sources of dependency links to the capability.
	 * 
	 * @param cap
	 *           a topology capability.
	 * @return List<Requirement> the most realized realized that are the target of the requirement's
	 *         link.
	 */
	public static List<Requirement> getDependencyLinkSources(Capability cap) {
		if (cap == null) {
			return Collections.emptyList();
		}
		Unit capUnit = getUnit(cap);
		Topology topology = cap.getEditTopology();
		if (capUnit == null || topology == null) {
			return Collections.emptyList();
		}
		if (capUnit.getGoalInstallState() == InstallState.NOT_INSTALLED_LITERAL) {
			return Collections.emptyList();
		}
		Collection<DeployModelObject> capPeerColl = RealizationLinkUtil
				.getAllImplicitRealizationLinkedObjects(cap);
		List<Requirement> targetList = new ArrayList<Requirement>();
		for (DeployModelObject object : capPeerColl) {
			if (object instanceof Capability) {
				Capability peerCap = (Capability) object;
				Requirement[] reqs = topology.findDependentRequirements(peerCap);
				for (int i = 0; i < reqs.length; i++) {
					DeployModelObject target = RealizationLinkUtil.getImplicitFinalRealization(reqs[i]);
					if (target instanceof Requirement && !targetList.contains(target)) {
						Unit reqUnit = getUnit(target);
						if (reqUnit == null
								|| reqUnit.getGoalInstallState() != InstallState.NOT_INSTALLED_LITERAL) {
							targetList.add((Requirement) target);
						}
					}
				}
			}
		}
		return targetList;
	}

	/**
	 * Returns the most realized members of the group
	 * 
	 * @param group
	 *           a unit which groups units with member links.
	 * @return List<Unit> of group members (immutable).
	 */
	public static List<Unit> getMembers(Unit group) {
		if (group == null || group.getGoalInstallState() == InstallState.NOT_INSTALLED_LITERAL) {
			return Collections.emptyList();
		}
		Topology topology = group.getTopology();
		if (topology == null) {
			// cannot determine host without topology
			return Collections.emptyList();
		}
		Set<DeployModelObject> peerSet = RealizationLinkUtil.getAllRealizationLinkedObjects(group);
		List<Unit> memberList = new ArrayList<Unit>();
		for (Iterator<DeployModelObject> iter = peerSet.iterator(); iter.hasNext();) {
			DeployModelObject object = iter.next();
			if (!(object instanceof Unit)) {
				continue;
			}
			Unit unit = (Unit) object;
			for (Iterator<MemberLink> iter2 = unit.getMemberLinks().iterator(); iter2.hasNext();) {
				MemberLink link = iter2.next();
				if (link.getTarget() == null) {
					continue;
				}
				DeployModelObject target = RealizationLinkUtil.getFinalRealization(link.getTarget());
				if (target != group && target instanceof Unit && !memberList.contains(target)) {
					Unit member = (Unit) target;
					if (member.getGoalInstallState() != InstallState.NOT_INSTALLED_LITERAL) {
						memberList.add(member);
					}
				}
			}
		}
		return memberList;
	}

	/**
	 * Returns the most realized groups in which the unit is a member.
	 * 
	 * @param member
	 *           a topology unit.
	 * @return List<Unit> of the most realized units which group the member.
	 */
	public static List<Unit> getGroups(Unit member) {
		return getGroups(member, null);
	}

	/**
	 * Returns the most realized groups in which the unit is a member.
	 * 
	 * @param member
	 *           a topology unit.
	 * @param groupReq
	 *           the specific group requirement used to filter the groups returned (may be null).
	 * @return List<Unit> of the most realized units which group the member under the requirement's
	 *         constraints..
	 */
	public static List<Unit> getGroups(Unit member, Requirement groupReq) {
		if (member == null || member.getGoalInstallState() == InstallState.NOT_INSTALLED_LITERAL) {
			return Collections.emptyList();
		}
		Topology topology = member.getTopology();
		if (topology == null) {
			// cannot determine membership without topology
			return Collections.emptyList();
		}
		List<Requirement> groupReqList = null;
		if (groupReq != null) {
			groupReqList = Collections.singletonList(groupReq);
		}
		Set<DeployModelObject> peerSet = RealizationLinkUtil.getAllRealizationLinkedObjects(member);
		List<Unit> groupList = new ArrayList<Unit>();
		for (Iterator<DeployModelObject> iter = peerSet.iterator(); iter.hasNext();) {
			DeployModelObject peerMember = iter.next();
			if (peerMember instanceof Unit) {
				Unit[] groups = topology.findMemberOf((Unit) peerMember);
				for (int i = 0; i < groups.length; i++) {
					DeployModelObject target = RealizationLinkUtil.getFinalRealization(groups[i]);
					if (target != member && target instanceof Unit && !groupList.contains(target)) {
						Unit group = (Unit) target;
						if (group.getGoalInstallState() != InstallState.NOT_INSTALLED_LITERAL
								&& (groupReq == null || areInRequirementsSatisfied(group, member,
										groupReqList))) {
							groupList.add(group);
						}
					}
				}
			}
		}

		return groupList;
	}

	/**
	 * Returns true if the parameter identifies a parameter in the object.
	 * <p>
	 * Parameters are currently identified by two model mechanisms, both of which are checked:
	 * <ul>
	 * <li> {@link AttributeMetaData#isParameter()}
	 * <li> {@link ConfigurationContract#isPublicEditable(DeployModelObject)}
	 * </ul>
	 * 
	 * @param object
	 *           a deploy attribute object.
	 * @param attribute
	 *           the full or relative attribute name.
	 * @return true if it is defined as a parameter in the instance.
	 */
	public static boolean isParameter(DeployModelObject object, String attribute) {
		if (object == null || attribute == null) {
			return false;
		}

		//
		// Check AttributeMetaData#isParameter()
		//
		int index = attribute.indexOf(IDeployAttributeStatus.ATTRIBUTE_NAME_CLASS_SEPARATOR);
		if (index != -1) {
			if (index + 1 == attribute.length()) {
				attribute = IConstants.EMPTY_STRING;
			} else {
				attribute = attribute.substring(index + 1);
			}
		}
		AttributeMetaData meta = object.getAttributeMetaData(attribute);
		if (meta != null && meta.isParameter()) {
			return true;
		}

		//
		// Check ConfigurationContract#isConfigurable(DeployModelObject)
		//
		if (object.getTopology() != null) {
			ConfigurationContract contract = object.getTopology().getConfigurationContract();
			if (contract != null && contract.isPublicEditable(object)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Returns true if the unit of the deploy object has a goal state of "not installed"
	 * 
	 * @param object
	 *           a deploy object.
	 * @return true if the unit of the object can be found and has a goal state of "not installed",
	 *         false otherwise.
	 * @see #getUnit(DeployModelObject)
	 * @see Unit#getGoalInstallState()
	 * @see InstallState#NOT_INSTALLED
	 */
	public static boolean isGoalNotInstalled(DeployModelObject object) {
		if (object == null) {
			return false;
		}

		if (object instanceof UnitLink) {
			UnitLink link = (UnitLink) object;
			return isGoalNotInstalled(link.getSource()) || isGoalNotInstalled(link.getTarget());
		} else if (object instanceof ConstraintLink) {
			ConstraintLink link = (ConstraintLink) object;
			// Make sure we don't infinite loop if logical link points to
			// itself!
			if (link.getSource() != object && isGoalNotInstalled(link.getSource())) {
				return true;
			}
			if (link.getTarget() != object && isGoalNotInstalled(link.getTarget())) {
				return true;
			}
			return false;
		} else if (object instanceof DependencyLink) {
			DependencyLink link = (DependencyLink) object;
			return isGoalNotInstalled(link.getSource()) || isGoalNotInstalled(link.getTarget());
		}

		Unit unit = getUnit(object);
		if (unit != null) {
			return unit.getGoalInstallState() == InstallState.NOT_INSTALLED_LITERAL;
		}

		return false;
	}

	/**
	 * Return true if the parent units of each dmo are distinct but in the same realization set
	 * 
	 * @param dmo1
	 *           One DeployModelObject
	 * @param dmo2
	 *           Another DeployModelObject
	 * @return true if the parent units of each dmo are distinct but in the same realization set
	 */
	public static boolean dmoParentUnitsSameRealizationSet(DeployModelObject dmo1,
			DeployModelObject dmo2) {
		Unit dmo1Unit = ValidatorUtils.getUnit(dmo1);
		Unit dmo2Unit = ValidatorUtils.getUnit(dmo2);
		if (dmo1Unit != null && dmo2Unit != null) {
			Set realizationSet = RealizationLinkUtil.getAllRealizationLinkedObjects(dmo1Unit);
			if (realizationSet.size() > 1 && realizationSet.contains(dmo2Unit)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Determine if a set of hosting capabilities are public.
	 * 
	 * @param unit
	 *           the unit containing the hosting capabilities
	 * @param types
	 *           the types that should be public
	 * @return true if all of the capability types are present and are public
	 */
	public static boolean areHostingCapabilitiesPublic(Unit unit, EClass[] types) {
		List<Capability> hostingCapabilties = unit.getHostingOrAnyCapabilities();
		ConfigurationContract contract = unit.getTopology().getConfigurationContract();
		int size = hostingCapabilties.size();
		for (int j = 0; j < types.length; j++) {
			boolean foundType = false;
			for (int i = 0; i < size; i++) {
				Capability hCap = hostingCapabilties.get(i);
				if (types[j].isSuperTypeOf(hCap.getEObject().eClass())) {
					if (!contract.isPublic(hCap)) {
						return false;
					}
					foundType = true;
					break;
				}
			}
			if (!foundType) {
				// one of the required types was not found
				return false;
			}
		}
		return true;
	}

	/**
	 * Add a status to an existing status. Creates a multistatus if needed.
	 * 
	 * @param currentStatus
	 *           the current status; may be null
	 * @param newStatus
	 *           the new status; currentStatus is returned if this is null
	 * @return the (perhaps multi-) status
	 */
	public static IStatus addStatus(IStatus currentStatus, IStatus newStatus) {

		if (newStatus != null && newStatus.getSeverity() != IStatus.OK) {
			if (currentStatus == null) {
				currentStatus = newStatus;
			} else if (currentStatus instanceof MultiStatus) {
				((MultiStatus) currentStatus).add(newStatus);
			} else {
				currentStatus = new MultiStatus(DeployCorePlugin.PLUGIN_ID, 0, new IStatus[] {
						currentStatus, newStatus }, DeployCoreMessages.Model_consistency_status_message,
						null);
			}
		}
		return currentStatus;
	}

	/**
	 * returns the source object of a deploy link.
	 * 
	 * @param link
	 *           a deploy link.
	 * @return the source object of the link if its uri has been defined and can be resolved.
	 * 
	 * @see DeployLink#getSourceuri()
	 * @see DeployModelObject#resolve(string)
	 */
	public static DeployModelObject getSource(DeployLink link) {
		if (link == null) {
			return null;
		}
		if (link instanceof DeployLinkImpl) {
			return ((DeployLinkImpl) link).getSourceObject();
		}
		String uri = link.getSourceURI();
		if (uri == null) {
			return null;
		}
		return link.resolve(uri);
	}

	/**
	 * Returns the target object of a deploy link.
	 * 
	 * @param link
	 *           a deploy link.
	 * @return the target object of the link if its uri has been defined and can be resolved.
	 * 
	 * @see DeployLink#getTargeturi()
	 * @see DeployModelObject#resolve(string)
	 */
	public static DeployModelObject getTarget(DeployLink link) {
		if (link == null) {
			return null;
		}
		if (link instanceof DeployLinkImpl) {
			return ((DeployLinkImpl) link).getTargetObject();
		}
		String uri = link.getTargetURI();
		if (uri == null) {
			return null;
		}
		return link.resolve(uri);
	}

	// Re-exposed from RealizationLinkUtil to avoid having to depend on too much Deployment Architecture Platform API

	/**
	 * Retrieve the last realization in a chain of realization from a {@link DeployModelObject} in a
	 * given context.
	 * <p>
	 * This method searches for a single unambiguous
	 * <p>
	 * If a unit has no realizations, the unit itself is returned.
	 * <p>
	 * Realization links should only have sources which are of type: {@link Unit}, {@link Capability}
	 * , or {@link Requirement}. Again, this method does not check this condition.
	 * <p>
	 * The source of a realization link should be on a conceptual {@link Unit}. Again, this is not
	 * verified in this method.
	 * 
	 * @param source
	 *           the source of the realization link
	 * @return the target of a realization chain (never null unless source is null).
	 */
	public static DeployModelObject getFinalRealization(DeployModelObject source) {
		return RealizationLinkUtil.getFinalRealization(source);
	}

	// Re-exposed with a List<DMO> return type to be consistent with the rest of the API in ValidatorUtils
	/**
	 * Retrieve the set of realization in a chain of realization from a {@link DeployModelObject} in
	 * a given context.
	 * <p>
	 * There should be only once realization of the object. This method does not check this
	 * condition. Instead it returns the first realization found, if any at any step in the process.
	 * If a realization link cycle is found, then the last object in the cycle is returned.
	 * <p>
	 * If a unit has no realizations, the unit itself is returned.
	 * <p>
	 * Realization links should only have sources which are of type: {@link Unit}, {@link Capability}
	 * , or {@link Requirement}. Again, this method does not check this condition.
	 * <p>
	 * The source of a realization link should be on a conceptual {@link Unit}. Again, this is not
	 * verified in this method.
	 * 
	 * @param source
	 *           the source of the realization link
	 * @return the target of a realization chain (never null unless source is null).
	 */
	public static <D extends DeployModelObject> List<D> getFinalRealizations(D source) {
		return (List<D>) Arrays.asList(RealizationLinkUtil.getFinalRealizations(source));
	}
}
