/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.matcher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.RealizationLinkUtil;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreSafeRunnable;
import com.ibm.ccl.soa.deploy.internal.core.validator.matcher.LinkDescriptorFactory;

/**
 * Describes a hypothetical link between two {@link DeployModelObject}s. The link can be created
 * using the {@link #create()} method. Typically, a {@link LinkDescriptor} is created by one of
 * {@link DeployValidatorService#getPossibleLinks(Unit, Unit, LinkType[])},
 * {@link DeployValidatorService#getPossibleLinks(Unit, Unit, LinkType[], int)},
 * {@link DeployValidatorService#getPossibleLinks(Unit, Requirement, Unit, Capability, LinkType[])},
 * or
 * {@link DeployValidatorService#getPossibleLinks(Unit, Requirement, Unit, Capability, LinkType[], int)}.
 * In turn, these are methods are implemented by domain matchers (extend {@link DomainMatcher}).
 * These may use an implementation of {@link AbstractLinkDescriptorFactory} to generate domain
 * specific link descriptors.
 */
public class LinkDescriptor {

	/**
	 * Constant for default link weight.
	 */
	public final static int DEFAULT_LINK_WEIGHT = 50;

	/** maximum link weight */
	public final static int MAX_LINK_WEIGHT = 100;

	/** type of link described by this descriptor */
	protected LinkType type;

	/** implemented link */
	protected DeployModelObject link;

	// MK 2/26/2007 context is always the edit topology
	// /** context of link */
	// final protected Topology context;

	/** source unit containing the link (or containing the source requirement) */
	protected Unit sourceUnit;

	/** target unit (or unit containing the target capability) */
	protected Unit targetUnit;

	/** source object (unit, requirement, capability) */
	protected DeployModelObject sourceObject;

	/** target object (unit, requirement, capability) */
	protected DeployModelObject targetObject;

	/** weight of link descriptor; link weights are in the range 0 to 100 */
	protected int linkWeight = DEFAULT_LINK_WEIGHT;

	protected AbstractLinkDescriptorFactory factory = new LinkDescriptorFactory();

	private static DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();

	protected TopologyState _topologyState = null;
	protected boolean _endpointsChanged = false;

	/**
	 * Constructor for LinkDescriptor. Identifies which units are the source and targets of the link.
	 * In this case, the link cannot be a dependency link.
	 * 
	 * @param type
	 *           type of the link; cannot be DEPENDENCY
	 * @param source
	 *           the source object
	 * @param target
	 *           the target object
	 */
	// MK 2/26/2007 context is always the edit topology
	// public LinkDescriptor (LinkType type, DeployModelObject source,
	// DeployModelObject target) {
	// this (type, source, target, null);
	// }
	//
	// /**
	// * Constructor for LinkDescriptor. Identifies which units are the source
	// and
	// * targets of the link. In this case, the link cannot be a dependency
	// link.
	// *
	// * @param type
	// * type of the link; cannot be DEPENDENCY
	// * @param source
	// * the source object
	// * @param target
	// * the target object
	// * @param context
	// * the context of the link (who should own the link)
	// */
	public LinkDescriptor(LinkType type, DeployModelObject source, DeployModelObject target) { // ,
		// Topology
		// context)
		// {
		// if just two endpoints can't be a depednency link
		assert !LinkType.DEPENDENCY.equals(type);

		// check that endpoints all make sense for various link types
		if (LinkType.REALIZATION.equals(type)) {
			// source and targets are both Units, Capabilities or Requirements
			if (CorePackage.Literals.UNIT.isSuperTypeOf(source.getEObject().eClass())) {
				assert CorePackage.Literals.UNIT.isSuperTypeOf(target.getEObject().eClass());
				sourceUnit = (Unit) source;
				targetUnit = (Unit) target;
			} else if (CorePackage.Literals.CAPABILITY.isSuperTypeOf(source.getEObject().eClass())) {
				assert CorePackage.Literals.CAPABILITY.isSuperTypeOf(target.getEObject().eClass());
				sourceUnit = (Unit) source.getParent();
				targetUnit = (Unit) source.getParent();
			} else if (CorePackage.Literals.REQUIREMENT.isSuperTypeOf(source.getEObject().eClass())) {
				assert CorePackage.Literals.REQUIREMENT.isSuperTypeOf(target.getEObject().eClass());
				sourceUnit = (Unit) source.getParent();
				targetUnit = (Unit) target.getParent();
			} else {
				assert false;
			}

			// MK 2/26/2007 context is always the edit topology
			// context = sourceUnit.getTopology(); // HACK; Needed for
			// calculating unique name later.

		} else if (LinkType.MEMBER.equals(type) || LinkType.HOSTING.equals(type)) {
			assert CorePackage.Literals.UNIT.isSuperTypeOf(source.getEObject().eClass())
					&& CorePackage.Literals.UNIT.isSuperTypeOf(target.getEObject().eClass());
			sourceUnit = (Unit) source;
			targetUnit = (Unit) target;
		} else if (LinkType.CONSTRAINT.equals(type)) {
			// BA 2007/02/28 if source or target are unit types, record them as
			// units in this link descriptor
			if (source instanceof Unit) {
				sourceUnit = (Unit) source;
			}
			if (target instanceof Unit) {
				targetUnit = (Unit) target;
			}
		}

		// create object
		this.type = type;
		sourceObject = source;
		targetObject = target;
		// MK 2/26/2007 context is always the edit topology
		// this.context = context;
	}

	// MK 2/26/2007 context is always the edit topology
	// /**
	// * Constructor for LinkDescriptor. Identifies which units are the source
	// and
	// * targets of the link. In this case, the link cannot be a dependency
	// link.
	// *
	// * @param type
	// * type of the link; cannot be DEPENDENCY
	// * @param source
	// * the source unit
	// * @param target
	// * the target unit
	// * @deprecated
	// */
	// public LinkDescriptor(LinkType type, Unit source, Unit target) {
	// assert !LinkType.DEPENDENCY.equals(type);
	// //TODO - C7 models
	// //if (LinkType.MEMBER.equals(type))
	// // assert
	// CorePackage.Literals.UNIT_COLLECTION.isSuperTypeOf(source.getEObject().eClass());
	//
	// this.type = type;
	// this.sourceUnit = source;
	// this.targetUnit = target;
	// }

	/**
	 * Constructor for LinkDescriptor. Identifies which unit/requirement is the source and which
	 * unit/capability is the source.
	 * 
	 * @param type
	 *           the type of the link
	 * @param source
	 *           the source unit
	 * @param sourceRequirement
	 *           the source requirement; must be non-null for dependency links; may be null for
	 *           logical link; must be null for hosting and unit collection links
	 * @param target
	 *           the target unit
	 * @param targetCapability
	 *           the target capability; must be non-null for dependency links; may be null for
	 *           logical link; must be null for hosting and unit collection links
	 */
	public LinkDescriptor(LinkType type, Unit source, Requirement sourceRequirement, Unit target,
			Capability targetCapability) {
		assert !LinkType.REALIZATION.equals(type);

		if (LinkType.DEPENDENCY.equals(type)) {
			// MK 5/4/2006 relaxed to allow creation of links that also create the requirement
			// assert (null != sourceRequirement) && (null != targetCapability);
			if (LinkType.HOSTING.equals(type)) {
				assert null == sourceRequirement && null == targetCapability;
			}
		}
		if (LinkType.MEMBER.equals(type)) {
			assert null == sourceRequirement && null == targetCapability;
		}

		this.type = type;
		sourceUnit = source;
		sourceObject = sourceRequirement;
		targetUnit = target;
		targetObject = targetCapability;

		if (LinkType.CONSTRAINT.equals(type)) {
			if (null == sourceRequirement) {
				sourceObject = source;
			}
			if (null == targetCapability) {
				targetObject = target;
			}
		}

		// MK 2/26/2007 context is always the edit topology
		// this.context = null;
	}

	/**
	 * Constructor for LinkDescriptor. Identifies which units are the source and targets of the link.
	 * In this case, the link cannot be a dependency link.
	 * 
	 * @param type
	 *           type of the link; cannot be DEPENDENCY
	 * @param source
	 *           the source object
	 * @param target
	 *           the target object
	 * @param linkWeight
	 *           assigned link weight
	 */
	public LinkDescriptor(LinkType type, DeployModelObject source, DeployModelObject target,
			int linkWeight) {
		this(type, source, target); // , null);
		this.linkWeight = linkWeight;
	}

	// MK 2/26/2007 context is always the edit topology
	// /**
	// * Constructor for LinkDescriptor. Identifies which units are the source
	// and
	// * targets of the link. In this case, the link cannot be a dependency
	// link.
	// *
	// * @param type
	// * type of the link; cannot be DEPENDENCY
	// * @param source
	// * the source object
	// * @param target
	// * the target object
	// * @param linkWeight
	// * assigned link weight
	// * @param context
	// * the context of the link (who should own the link)
	// */
	// public LinkDescriptor (LinkType type, DeployModelObject source,
	// DeployModelObject target, int linkWeight, Topology context) {
	// this(type, source, target, context);
	// this.linkWeight = linkWeight;
	// }
	//	
	/**
	 * Constructor for LinkDescriptor. Identifies which unit/requirement is the source and which
	 * unit/capability is the source.
	 * 
	 * @param type
	 *           the type of the link
	 * @param source
	 *           the source unit
	 * @param sourceRequirement
	 *           the source requirement; must be non-null for dependency links; may be null for
	 *           logical link; must be null for hosting and unit collection links
	 * @param target
	 *           the target unit
	 * @param targetCapability
	 *           the target capability; must be non-null for dependency links; may be null for
	 *           logical link; must be null for hosting and unit collection links
	 * @param linkWeight
	 *           assigned link weight
	 */
	public LinkDescriptor(LinkType type, Unit source, Requirement sourceRequirement, Unit target,
			Capability targetCapability, int linkWeight) {
		this(type, source, sourceRequirement, target, targetCapability);
		this.linkWeight = linkWeight;
	}

	/**
	 * Retrieve the source unit of a link or, if the source is a requirment, the unit containing the
	 * source requirment.
	 * 
	 * @return the source unit
	 */
	public Unit getSourceUnit() {
		if (sourceObject == null) {
			return sourceUnit;
		}

		EClass sourceClass = sourceObject.getEObject().eClass();
		if (CorePackage.Literals.UNIT.isSuperTypeOf(sourceClass)) {
			return (Unit) sourceObject;
		} else if (CorePackage.Literals.CAPABILITY.isSuperTypeOf(sourceClass)) {
			if (null != sourceUnit) {
				return sourceUnit;
			}
			return (Unit) sourceObject.getParent();
		} else if (CorePackage.Literals.REQUIREMENT.isSuperTypeOf(sourceClass)) {
			if (null != sourceUnit) {
				return sourceUnit;
			}
			return (Unit) sourceObject.getParent();
		}

		// don't know what to do with this source type
		return null;
	}

	/**
	 * Retrieve the target unit of a link or, if the target is a capability, the unit containing the
	 * target capability.
	 * 
	 * @return the target unit
	 */
	public Unit getTargetUnit() {
		if (targetObject == null) {
			return targetUnit;
		}

		EClass targetClass = targetObject.getEObject().eClass();
		if (CorePackage.Literals.UNIT.isSuperTypeOf(targetClass)) {
			return (Unit) targetObject;
		} else if (CorePackage.Literals.CAPABILITY.isSuperTypeOf(targetClass)) {
			if (null != targetUnit) {
				return targetUnit;
			}
			return (Unit) targetObject.getParent();
		} else if (CorePackage.Literals.REQUIREMENT.isSuperTypeOf(targetClass)) {
			if (null != targetUnit) {
				return targetUnit;
			}
			return (Unit) targetObject.getParent();
		}

		// don't know what to do with this source type
		return null;
	}

	/**
	 * Retrieve the source of a link. Will be:
	 * <ol>
	 * <li>a requirement for dependency links,</li>
	 * <li>a unit for a member or hosting link,</li>
	 * <li>a unit, capability or requirement for a realization link, and
	 * <li>
	 * <li>anything for a logical link.</li>
	 * </ol>
	 * 
	 * @return the source object
	 */
	public DeployModelObject getSource() {
		// if (null != sourceRequirement) {
		// return this.sourceRequirement;
		// }
		//
		return sourceObject;
	}

	protected void setSource(DeployModelObject source) {
		sourceObject = source;
	}

	/**
	 * Retrieve the target of a link. Will be:
	 * <ol>
	 * <li>a capability for dependency links,</li>
	 * <li>a unit for a member or hosting link,</li>
	 * <li>a unit, capability, or requirement for a realization link, and</li>
	 * <li>anything for a logical link.</li>
	 * </ol>
	 * 
	 * @return the target object
	 */
	public DeployModelObject getTarget() {
		// if (null != targetCapability) {
		// return this.targetCapability;
		// }
		return targetObject;
	}

	protected void setTarget(DeployModelObject target) {
		targetObject = target;
	}

	/**
	 * Retrieve the type of the link.
	 * 
	 * @return the link type.
	 */
	public LinkType getType() {
		return type;
	}

	public int getLinkWeight() {
		return linkWeight;
	}

	protected void setLinkDescriptorFactory(AbstractLinkDescriptorFactory f) {
		factory = f;
	}

	/**
	 * Get a factory to create link descriptors.
	 * 
	 * @return the link descriptor factory
	 */
	public AbstractLinkDescriptorFactory getLinkDescriptorFactory() {
		return factory;
	}

	/**
	 * Create the link described by this descriptor.
	 * 
	 * @return the link (as a DeployModelObject).
	 */
	public DeployModelObject create() {
		// MK 2/7/2007 no longer true
		// assert sourceUnit.getTopology() == targetUnit.getTopology();
		// MK 2/26/2007 context is always the edit topology
		// Topology top = null;
		// if (null != this.context) {
		// top = this.context;
		// } else {
		// // default to source topology; does this depend on the type of link?
		// top = sourceUnit.getTopology();
		// }
		Topology top = sourceUnit.getEditTopology();
		ValidatorUtils.executeWriteOperation(top, new ValidatorUtils.ITopologyOperation() {
			public IStatus doExecute(DeployModelObject object, IProgressMonitor monitor,
					IAdaptable info) {
				internalCreate();
				return Status.OK_STATUS;
			}
		});

		return link;
	}

	/**
	 * Create the link described by this descriptor.
	 */
	public void internalCreate() {
		assert sourceUnit != null;
		assert targetUnit != null;

		switch (type.getValue())
		{
		case LinkType.DEPENDENCY_VALUE:
			createDependencyLink();
			break;
		case LinkType.HOSTING_VALUE:
			createHostingLink();
			break;
		case LinkType.CONSTRAINT_VALUE:
			createConstraintLink();
			break;
		case LinkType.MEMBER_VALUE:
			createMemberLink();
			break;
		case LinkType.REALIZATION_VALUE:
			createRealizationLink();
			break;
		default:
			throw new IllegalArgumentException(DeployCoreMessages.LinkDescriptor_UnknownLinkType);
		}

		// Assign unique name (in case the default name conflicted)
		if (link != null && link.getParent() != null && link.isPublicEditable()) {
			UnitUtil.assignUniqueName(link);
		}
	}

	/**
	 * Create a dependency link from the data in this LinkDescriptor.
	 * 
	 * @return the dependency link or null (if not a dependency link descriptor)
	 */
	protected DependencyLink createDependencyLink() {
		// validate input
		if (!LinkType.DEPENDENCY.equals(type)) {
			link = null;
			return null;
		}

		// MK: 9/11/2007 -- removed assert statements and replaced by checks to avoid exceptions
		if (null == sourceObject || null == targetObject) {
			return null;
		}

		if (!CorePackage.Literals.REQUIREMENT.isSuperTypeOf(sourceObject.getEObject().eClass())) {
			return null;
		}
		if (!CorePackage.Literals.CAPABILITY.isSuperTypeOf(targetObject.getEObject().eClass())) {
			return null;
		}
		// MK: 9/11/2007 -- end changes

		// extract inputs
		final Requirement sourceRequirement = (Requirement) sourceObject;
		final Capability targetCapability = (Capability) targetObject;

		// check if link already exists
		DependencyLink currentLink = sourceRequirement.getLink();
		if (currentLink != null) {
			// the link already exists
			// MK: 9/11/2007 -- start changes
			// is it the same link (ie, we won't have to do any work)?
			// to check this, we need to worry about the link existing between realized conceptual units...
			if (RealizationLinkUtil.getImplicitFinalRealization(currentLink.getTarget()) == RealizationLinkUtil
					.getImplicitFinalRealization(targetCapability)) {
				// if (currentLink.getTarget() == targetCapability) {
				// MK: 9/11/2007 -- end chanages
				// trying to create the same link; just return the link
				link = currentLink;
				return currentLink;
			}
			// the link already exists but the target is different:  
			//   delete the current target and replace with the new target:
			// MK 9/11/2007 -- start changes:
			// (a) replace direct call to EcoreUtil.remove() with wrapper
			// (b) we could check if we are allowed to delete the link (as per contract)
			//     but I choose not to because this check will (I hope) change one day
			// (c) return null if we can't delete the link
			if (!deleteLink(currentLink)) {
				return null;
			}
			// EcoreUtil.remove(currentLink);
			// MK 9/11/2007 -- end changes
		}

		// MK 6/4/2007 initial links for each peer
		// identify initial links for sourceRequirement and for targetCapability
		final LinkContext context = new LinkContext(getSourceUnit(), sourceRequirement,
				getTargetUnit(), targetCapability, LinkType.DEPENDENCY);

		final DependencyLink lnk = dependencyLinkCreate(getSourceUnit(), sourceRequirement,
				getTargetUnit(), targetCapability);

		// MK 05/20/2008 - defect 6173
		// Allow successful completion even when exception in post operation
		SafeRunner.run(new DeployCoreSafeRunnable() {

			@Override
			public void run() throws Exception {
				//MK 6/4/2007 respond to new implied links
				// new implied link is context.getRealizedSourceRequirement() --> context.getRealizedTargetCapability()
				implementImpliedDependencyLinkChanges(lnk, context);

				// do any post creation work
				postDependencyLinkCreate(getSourceUnit(), sourceRequirement, getTargetUnit(),
						targetCapability, lnk);
			}

		});

		link = lnk;
		return lnk;
	}

	private void implementImpliedDependencyLinkChanges(DependencyLink lnk, LinkContext context) {

		if (!context.areRealizedOriginal()) {
			LinkDescriptor[] descriptors = context.getLinkDescriptors();
			for (int i = 0; i < descriptors.length; i++) {
				descriptors[i].postDependencyLinkCreate(context.getRealizedSourceUnit(), context
						.getRealizedSourceRequirement(), context.getRealizedTargetUnit(), context
						.getRealizedTargetCapability(), lnk);
			}
		}
	}

	/**
	 * Create a dependency link
	 * 
	 * @param source
	 *           source unit of the link
	 * @param sourceRequirement
	 *           source requirement of the link
	 * @param target
	 *           target unit of the link
	 * @param targetCapability
	 *           target capability of the link
	 * @return the link
	 */
	public DependencyLink dependencyLinkCreate(Unit source, Requirement sourceRequirement,
			Unit target, Capability targetCapability) {
		DependencyLink lnk = CoreFactory.eINSTANCE.createDependencyLink();

		lnk.setTarget(targetCapability);
		lnk.setSource(sourceRequirement);
		sourceRequirement.setLink(lnk);
		lnk.setName(getUniqueLinkName(getSourceUnit(), sourceRequirement.getName()
				+ "To" + targetCapability.getName())); //$NON-NLS-1$
		return lnk;
	}

	/**
	 * Execute any post dependency link creation activities. This method would typically be
	 * overridden by extensions that want to do additional actions when creating a link.
	 * 
	 * @param source
	 *           source unit of the link
	 * @param sourceRequirement
	 *           source requirement of the link
	 * @param target
	 *           target unit of the link
	 * @param targetCapability
	 *           target capability of the link
	 * @param lnk
	 */
	public void postDependencyLinkCreate(Unit source, Requirement sourceRequirement, Unit target,
			Capability targetCapability, DependencyLink lnk) {
		// do nothing
	}

	/**
	 * Create a hosting link from the data in this LinkDescriptor. If the target is already hosted
	 * elsewhere we delete that and start over.
	 * 
	 * @return the hosting link or null (if not a hosting link descriptor)
	 */
	protected HostingLink createHostingLink() {
		// validate input
		if (!LinkType.HOSTING.equals(type)) {
			link = null;
			return null;
		}

		// MK: 9/11/2007 -- removed assert statements and replaced by checks to avoid exceptions
		if (null == getTargetUnit() || null == getSourceUnit()) {
			return null;
		}

		if (!CorePackage.Literals.UNIT.isSuperTypeOf(getTargetUnit().getEObject().eClass())) {
			return null;
		}
		if (!CorePackage.Literals.UNIT.isSuperTypeOf(getSourceUnit().getEObject().eClass())) {
			return null;
		}
		// MK: 9/11/2007 -- end changes

		// extract inputs
		final Unit desiredHostee = getTargetUnit();
		final Unit desiredHost = getSourceUnit();

		// find out if desriedHostee is already hosted somewhere
		HostingLink currentLink = ValidatorUtils.getHostingLink(desiredHostee);
		if (currentLink != null) {
			// desiredHostee is already hosted somewhere
			// Is it the same link (ie, we won't have to do any work)?
			// To check this, we need to worry about the link existing between realized conceptual units...
			// The above call to ValidatorUtils.getHostingLink(desiredHostee) already does this.
			Unit currentHost = currentLink.getSource();
			if (currentHost == desiredHost) {
				// the link is what we want to create; just return it
				link = currentLink;
				return currentLink;
			}

			// the link already exists but the target is different:  
			//   delete the current target and replace with the new target:
			// MK 9/11/2007 -- start changes:
			// (a) replace direct call to EcoreUtil.remove() with wrapper
			// (b) we could check if we are allowed to delete the link (as per contract)
			//     but I choose not to because this check will (I hope) change one day
			// (c) return null if we can't delete the link
// Creating a link shouldn't delete the existing (V8M5)			
//			if (!deleteLink(currentLink)) {
//				return null;
//			}
			// EcoreUtil.remove(currentLink);
			// MK 9/11/2007 -- end changes
		}

		// MK 6/4/2007 initial links for each peer
		// identify initial links for host and for hostee
		final LinkContext context = new LinkContext(desiredHost, desiredHostee, LinkType.HOSTING);

		final HostingLink lnk = hostingLinkCreate(desiredHost, desiredHostee);

		// MK 05/20/2008 - defect 6173
		// Allow successful completion even when exception in post operation
		SafeRunner.run(new DeployCoreSafeRunnable() {

			@Override
			public void run() throws Exception {
				//MK 6/4/2007 respond to new implied links
				// new implied link is finalHost --> (hosts) --> finalHostee
				implementImpliedHostingLinkChanges(lnk, context);

				// do any post creation work
				postHostingLinkCreate(desiredHost, desiredHostee, lnk);
			}

		});

		link = lnk;
		return lnk;
	}

	private void implementImpliedHostingLinkChanges(HostingLink lnk, LinkContext context) {

		if (!context.areRealizedOriginal()) {
			LinkDescriptor[] descriptors = context.getLinkDescriptors();
			for (int i = 0; i < descriptors.length; i++) {
				descriptors[i].postHostingLinkCreate(context.getRealizedSourceUnit(), context
						.getRealizedTargetUnit(), lnk);
			}
		}
	}

	/**
	 * Create a hosting link
	 * 
	 * @param host
	 *           source unit (host) of the link
	 * @param hostee
	 *           target unit (hostee) of the link
	 * @return the link
	 */
	public HostingLink hostingLinkCreate(Unit host, Unit hostee) {
		// link does not exist
		HostingLink lnk = CoreFactory.eINSTANCE.createHostingLink();

		lnk.setHosted(hostee);
		lnk.setSource(host);
		lnk.setName(getUniqueLinkName(host, host.getName() + "Hosts" + hostee.getName())); //$NON-NLS-1$
		host.getHostingLinks().add(lnk);
		return lnk;
	}

	/**
	 * Execute any post dependency link creation activities. This method would typically be
	 * overridden by extensions that want to do additional actions when creating a link.
	 * 
	 * @param host
	 *           source unit (host) of the link
	 * @param hostee
	 *           target unit (hostee) of the link
	 * @param lnk
	 */
	public void postHostingLinkCreate(Unit host, Unit hostee, HostingLink lnk) {
		// do nothing
	}

	/**
	 * Create a hosting link from the data in this LinkDescriptor. If the target is already hosted
	 * elsewhere we delete that and start over.
	 * 
	 * @return the hosting link or null (if not a hosting link descriptor)
	 */
	protected ConstraintLink createConstraintLink() {
		// validate input
		if (!LinkType.CONSTRAINT.equals(type)) {
			link = null;
			return null;
		}

		if (null == getTarget() || null == getTargetUnit() || null == getSource()
				|| null == getSourceUnit()) {
			return null;
		}

		if (!CorePackage.Literals.UNIT.isSuperTypeOf(getTargetUnit().getEObject().eClass())) {
			return null;
		}
		if (!CorePackage.Literals.UNIT.isSuperTypeOf(getSourceUnit().getEObject().eClass())) {
			return null;
		}

		// extract inputs
		final DeployModelObject desiredTarget = getTarget();
		final DeployModelObject desiredSource = getSource();

		// Should this prevent creation of a second link from same source to same target?

		// create link
		final ConstraintLink lnk = constraintLinkCreate(desiredSource, desiredTarget);

		// MK 05/20/2008 - defect 6173
		// Allow successful completion even when exception in post operation
		SafeRunner.run(new DeployCoreSafeRunnable() {

			@Override
			public void run() throws Exception {
				// do any post creation work
				postConstraintLinkCreate(desiredSource, desiredTarget, lnk);
			}

		});

		link = lnk;
		return lnk;
	}

	/**
	 * Create a constraint link
	 * 
	 * @param source
	 *           source object of the link
	 * @param target
	 *           target object of the link
	 * @return the link
	 */
	public ConstraintLink constraintLinkCreate(DeployModelObject source, DeployModelObject target) {
		// link does not exist
		ConstraintLink lnk = CoreFactory.eINSTANCE.createConstraintLink();
		String sourceName = null;
		String targetName = null;

		lnk.setSource(source);
		sourceName = source.getName();
		lnk.setTarget(target);
		targetName = target.getName();

		lnk.setName(getUniqueLinkName(getSourceUnit(), sourceName + "ConstraintTo" + targetName)); //$NON-NLS-1$
		getSourceUnit().getConstraintLinks().add(lnk);
		link = lnk;

		return lnk;
	}

	/**
	 * Execute any post constraint link creation activities. This method would typically be
	 * overridden by extensions that want to do additional actions when creating a link.
	 * 
	 * @param source
	 *           source object of the link
	 * @param target
	 *           target object of the link
	 * @param lnk
	 */
	public void postConstraintLinkCreate(DeployModelObject source, DeployModelObject target,
			ConstraintLink lnk) {
		// do nothing
	}

	/**
	 * Create a member link from the data in this LinkDescriptor.
	 * 
	 * @return the member link or null (if not a member link descriptor)
	 */
	protected MemberLink createMemberLink() {
		// validate input
		if (!LinkType.MEMBER.equals(type)) {
			return null;
		}

		// MK: 9/11/2007 -- removed assert statements and replaced by checks to avoid exceptions
		if (null == getTargetUnit() || null == getSourceUnit()) {
			return null;
		}

		if (!CorePackage.Literals.UNIT.isSuperTypeOf(getTargetUnit().getEObject().eClass())) {
			return null;
		}
		if (!CorePackage.Literals.UNIT.isSuperTypeOf(getSourceUnit().getEObject().eClass())) {
			return null;
		}
		// MK: 9/11/2007 -- end changes

		// extract inputs
		final Unit group = getSourceUnit();
		final Unit member = getTargetUnit();

		// if link has already been created don't do it again
		if (null != link) {
			return (MemberLink) link;
		}

		// MK 6/4/2007 initial links for each peer
		// identify initial links for group and for member
		final LinkContext context = new LinkContext(group, member, LinkType.MEMBER);

		final MemberLink lnk = memberLinkCreate(group, member);

		// MK 05/20/2008 - defect 6173
		// Allow successful completion even when exception in post operation
		SafeRunner.run(new DeployCoreSafeRunnable() {

			@Override
			public void run() throws Exception {
				//MK 6/4/2007 respond to new implied links
				// new implied link is finalHost --> (hosts) --> finalHostee
				implementImpliedMemberLinkChanges(lnk, context);

				// do any post creation work
				postMemberLinkCreate(group, member, lnk);
			}

		});

		link = lnk;
		return lnk;
	}

	/**
	 * Create a dependency link
	 * 
	 * @param group
	 *           source unit (group) of the link
	 * @param member
	 *           target unit (member) of the link
	 * @return the link
	 */
	public MemberLink memberLinkCreate(Unit group, Unit member) {
		MemberLink lnk = CoreFactory.eINSTANCE.createMemberLink();

		lnk.setSource(group);
		lnk.setTarget(member);
		lnk.setName(getUniqueLinkName(group, group.getName() + "Contains" + member.getName())); //$NON-NLS-1$
		group.getUnitLinks().add(lnk);
		return lnk;
	}

	private void implementImpliedMemberLinkChanges(MemberLink lnk, LinkContext context) {

		if (!context.areRealizedOriginal()) {
			LinkDescriptor[] descriptors = context.getLinkDescriptors();
			for (int i = 0; i < descriptors.length; i++) {
				descriptors[i].postMemberLinkCreate(context.getRealizedSourceUnit(), context
						.getRealizedTargetUnit(), lnk);
			}
		}
	}

	/**
	 * Execute any post dependency link creation activities. This method would typically be
	 * overridden by extensions that want to do additional actions when creating a link.
	 * 
	 * @param group
	 *           source unit (group) of the link
	 * @param member
	 *           target unit (member) of the link
	 * @param lnk
	 */
	public void postMemberLinkCreate(Unit group, Unit member, MemberLink lnk) {
		// do nothing
	}

	protected RealizationLink createRealizationLink() {
		// validate inputs
		if (!LinkType.REALIZATION.equals(type)) {
			return null;
		}

		// MK: 9/11/2007 -- removed assert statements and replaced by checks to avoid exceptions
		if (null == sourceObject || null == targetObject) {
			return null;
		}
		// MK: 9/11/2007 -- end changes

//		boolean areUnits = sourceObject instanceof Unit && targetObject instanceof Unit;

		RealizationLink lnk = realizationLinkCreate(sourceObject, targetObject);

// MK 6/11/2007 backed off change because it has problems with imported topologies
// WHEN added back to the code base, re-enable test cases in ImplicityLinkTest
//		// MK 6/4/2007 
//		// in the realization case, we want to create the realization chain first
//		LinkContext context = null;
//		List<LinkContext> contexts = null;
//		if (areUnits) {
//			context = new LinkContext((Unit) sourceObject, (Unit) targetObject, LinkType.REALIZATION);
//			contexts = getLinkContexts(sourceObject, targetObject);
//
//		// MK 05/20/2008 - defect 6173
//		// Allow successful completion even when exception in post operation
//		SafeRunner.run(new DeployCoreSafeRunnable() {
//
//			@Override
//			public void run() throws Exception {
//				//MK 6/4/2007 respond to new implied links
//				// new implied link is finalHost --> (hosts) --> finalHostee
//					implementImpliedRealizationLinkChanges(lnk, context, contexts);
//
//					// do any post creation work
//					postRealizationLinkCreate(sourceObject, targetObject, lnk);
//			}
//
//		});
//		}

		link = lnk;
		return lnk;
	}

	/**
	 * Create a realization link
	 * 
	 * @param source
	 *           source object of the link
	 * @param target
	 *           target object of the link
	 * @return the link
	 */
	public RealizationLink realizationLinkCreate(DeployModelObject source, DeployModelObject target) {

		Topology context = source.getEditTopology();
		RealizationLink lnk = CoreFactory.eINSTANCE.createRealizationLink();
		lnk.setSource(source);
		lnk.setTarget(target);
		lnk.setName(getUniqueLinkName(context, source.getName() + "RealizedBy" + target.getName())); //$NON-NLS-1$
		context.getRealizationLinks().add(lnk);

		return lnk;
	}

	private void implementImpliedRealizationLinkChanges(RealizationLink lnk, LinkContext context,
			List<LinkContext> contexts) {

		if (!context.areRealizedOriginal()) {
			LinkDescriptor[] descriptors = context.getLinkDescriptors();
			for (int i = 0; i < descriptors.length; i++) {
				descriptors[i].postRealizationLinkCreate(context.getRealizedSourceUnit(), context
						.getRealizedTargetUnit(), lnk);
			}
		}
		for (int j = 0; j < contexts.size(); j++) {
			context = contexts.get(j);
			// when creating a realization link the realized target is different
			//if (!context.areRealizedOriginal()) {
			LinkDescriptor[] descriptors = context.getLinkDescriptors();
			for (int i = 0; i < descriptors.length; i++) {
				switch (descriptors[i].getType().getValue())
				{
				case LinkType.DEPENDENCY_VALUE:
					descriptors[i].postDependencyLinkCreate(context.getRealizedSourceUnit(), context
							.getRealizedSourceRequirement(), context.getRealizedTargetUnit(), context
							.getRealizedTargetCapability(), (DependencyLink) context.getLink());
					break;
				case LinkType.HOSTING_VALUE:
					descriptors[i].postHostingLinkCreate(context.getRealizedSourceUnit(), context
							.getRealizedTargetUnit(), (HostingLink) context.getLink());
					break;
				case LinkType.MEMBER_VALUE:
					descriptors[i].postMemberLinkCreate(context.getRealizedSourceUnit(), context
							.getRealizedTargetUnit(), (MemberLink) context.getLink());
					break;
				case LinkType.REALIZATION_VALUE:
					descriptors[i].postRealizationLinkCreate(context.getRealizedSourceUnit(), context
							.getRealizedTargetUnit(), (RealizationLink) context.getLink());
					break;
				default:
					// do nothing
				}
			}
			//}
		}
	}

	/**
	 * Execute any post dependency link creation activities. This method would typically be
	 * overridden by extensions that want to do additional actions when creating a link.
	 * 
	 * @param source
	 *           source object of the link
	 * @param target
	 *           target object of the link
	 * @param lnk
	 */
	public void postRealizationLinkCreate(DeployModelObject source, DeployModelObject target,
			RealizationLink lnk) {
		// do nothing
	}

	private List<LinkContext> getLinkContexts(DeployModelObject source, DeployModelObject target) {
		List<LinkContext> contexts = new ArrayList<LinkContext>();
		if (!CorePackage.Literals.UNIT.isSuperTypeOf(source.getEObject().eClass())) {
			return contexts;
		}
		if (!CorePackage.Literals.UNIT.isSuperTypeOf(target.getEObject().eClass())) {
			return contexts;
		}

		Unit sourceUnit = (Unit) source;
		Unit targetUnit = (Unit) target;

		List<Unit> _hosted = ValidatorUtils.getHosted(sourceUnit);
		List<Unit> _hosts = ValidatorUtils.getAllHosts(sourceUnit);
		List<Unit> _members = ValidatorUtils.getMembers(sourceUnit);
		List<Unit> _groups = ValidatorUtils.getGroups(sourceUnit);
		List<DependencyLinkPair> _targets = getDependencyLinkTargets(sourceUnit);
		List<DependencyLinkPair> _sources = getDependencyLinkSources(sourceUnit);

		for (int i = 0; i < _hosted.size(); i++) {
			contexts.add(new LinkContext(sourceUnit, null, _hosted.get(i), null, targetUnit, null,
					_hosted.get(i), null, LinkType.HOSTING));
		}
		for (int i = 0; i < _hosts.size(); i++) {
			contexts.add(new LinkContext(_hosts.get(i), null, sourceUnit, null, _hosts.get(i), null,
					targetUnit, null, LinkType.HOSTING));
		}
		for (int i = 0; i < _members.size(); i++) {
			contexts.add(new LinkContext(sourceUnit, null, _members.get(i), null, targetUnit, null,
					_members.get(i), null, LinkType.MEMBER));
		}
		for (int i = 0; i < _groups.size(); i++) {
			contexts.add(new LinkContext(_groups.get(i), null, sourceUnit, null, _groups.get(i), null,
					targetUnit, null, LinkType.MEMBER));
		}
		for (int i = 0; i < _targets.size(); i++) {
			Requirement srcReq = _targets.get(i).getSource();
			Capability tgtCap = _targets.get(i).getTarget();
			contexts.add(new LinkContext(sourceUnit, srcReq, (Unit) tgtCap.getParent(), tgtCap,
					targetUnit, null, (Unit) tgtCap.getParent(), tgtCap, LinkType.DEPENDENCY));
		}
		for (int i = 0; i < _sources.size(); i++) {
			Requirement srcReq = _sources.get(i).getSource();
			Capability tgtCap = _sources.get(i).getTarget();
			contexts.add(new LinkContext((Unit) srcReq.getParent(), srcReq, sourceUnit, tgtCap,
					(Unit) srcReq.getParent(), srcReq, targetUnit, null, LinkType.DEPENDENCY));
		}

		return contexts;
	}

	private List<DependencyLinkPair> getDependencyLinkTargets(Unit source) {
		if (null == source) {
			return Collections.EMPTY_LIST;
		}

		List<DependencyLinkPair> targets = new ArrayList<DependencyLinkPair>();
		List<Requirement> reqs = source.getDependencyOrAnyRequirements();
		for (int i = 0; i < reqs.size(); i++) {
			Requirement req = reqs.get(i);
			Capability targetCap = ValidatorUtils.getDependencyLinkTarget(req);
			if (null != targetCap) {
				targets.add(new DependencyLinkPair(req, targetCap));
			}
		}
		return targets;
	}

	private List<DependencyLinkPair> getDependencyLinkSources(Unit target) {
		if (null == target) {
			return Collections.EMPTY_LIST;
		}
		List<DependencyLinkPair> sources = new ArrayList<DependencyLinkPair>();
		List<Capability> caps = target.getDependencyOrAnyCapabilities();
		for (int i = 0; i < caps.size(); i++) {
			Capability cap = caps.get(i);
			List<Requirement> srcReqs = ValidatorUtils.getDependencyLinkSources(cap);
			for (int j = 0; j < srcReqs.size(); j++) {
				sources.add(new DependencyLinkPair(srcReqs.get(j), cap));
			}
		}
		return sources;
	}

	private String getUniqueLinkName(DeployModelObject container, String name) {
		String linkName = name;
		int uniqifier = 0;
		while (null != container.resolve(linkName)) {
			linkName += uniqifier++;
		}

		return linkName;
	}

	public String toString() {
		String output;
		output = type.getDescription() + ": "; //$NON-NLS-1$

		output += null == sourceObject ? sourceUnit.getCaptionProvider().title(sourceUnit)
				: toString(sourceObject);
		// output += toString(sourceObject);
		output += " -> "; //$NON-NLS-1$
		output += null == targetObject ? targetUnit.getCaptionProvider().title(targetUnit)
				: toString(targetObject);
		// output += toString(targetObject);

		output += "(" + linkWeight + ")"; //$NON-NLS-1$//$NON-NLS-2$

		return output;
	}

	protected String toString(DeployModelObject object) {
		String output = ""; //$NON-NLS-1$
		if (null == object) {
			return output;
		}
		if (CorePackage.Literals.CAPABILITY.isSuperTypeOf(object.getEObject().eClass())
				|| CorePackage.Literals.REQUIREMENT.isSuperTypeOf(object.getEObject().eClass())) {
			output += object.getParent().getName() + "."; //$NON-NLS-1$
		}
		output += object.getName();

		return output;
	}

	public int hashCode() {
		final int PRIME = 31;
		// int result = super.hashCode();
		int result = 0;
		// MK 2/26/2007 context is always the edit topology
		// result = PRIME * result + ((context == null) ? 0 :
		// context.hashCode());
		result = PRIME * result + (link == null ? 0 : link.hashCode());
		result = PRIME * result + linkWeight;
		result = PRIME * result + (sourceObject == null ? 0 : sourceObject.hashCode());
		result = PRIME * result + (sourceUnit == null ? 0 : sourceUnit.hashCode());
		result = PRIME * result + (targetObject == null ? 0 : targetObject.hashCode());
		result = PRIME * result + (targetUnit == null ? 0 : targetUnit.hashCode());
		result = PRIME * result + (type == null ? 0 : type.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		// if (!super.equals(obj))
		// return false;
		if (getClass() != obj.getClass()) {
			return false;
		}
		final LinkDescriptor other = (LinkDescriptor) obj;
		// MK 2/26/2007 context is always the edit topology
		// if (context == null) {
		// if (other.context != null)
		// return false;
		// } else if (!context.equals(other.context))
		// return false;
		if (link == null) {
			if (other.link != null) {
				return false;
			}
		} else if (!link.equals(other.link)) {
			return false;
		}
		if (linkWeight != other.linkWeight) {
			return false;
		}
		if (sourceObject == null) {
			if (other.sourceObject != null) {
				return false;
			}
		} else if (!sourceObject.equals(other.sourceObject)) {
			return false;
		}
		if (sourceUnit == null) {
			if (other.sourceUnit != null) {
				return false;
			}
		} else if (!sourceUnit.equals(other.sourceUnit)) {
			return false;
		}
		if (targetObject == null) {
			if (other.targetObject != null) {
				return false;
			}
		} else if (!targetObject.equals(other.targetObject)) {
			return false;
		}
		if (targetUnit == null) {
			if (other.targetUnit != null) {
				return false;
			}
		} else if (!targetUnit.equals(other.targetUnit)) {
			return false;
		}
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		return true;
	}

	/**
	 * Delete link using wrapper to EcoreUtil.remove().
	 * 
	 * @param linkToDelete
	 *           The link to be deleted
	 * @return true if link successfully deleted, false otherwise
	 */
	private boolean deleteLink(DeployLink linkToDelete) {
		// I tried using DeleteModelObjectOperation but got exceptions.  
		// EcoreUtil.remove() seems to work.
//		DeleteModelObjectOperation dmoo = new DeleteModelObjectOperation(linkToDelete,
//				"delete " + linkToDelete); //$NON-NLS-1$
		try {
//			dmoo.execute(new NullProgressMonitor(), null);
			EcoreUtil.remove(linkToDelete);
//		} catch (ExecutionException e) {
		} catch (Throwable e) {
			DeployCorePlugin.log(IStatus.ERROR, 0, NLS.bind(
					DeployCoreMessages.LinkDescriptor_LinkDeletionFails,
					new Object[] { e.getMessage() }, null), null);
			return false;
		}
		DeployCorePlugin.log(IStatus.WARNING, 0,
				DeployCoreMessages.LinkDescriptor_LinkDeletionSuccess, null);
		return true;
	}

	private class LinkContext {

		private final Unit actualSourceUnit;
		private final Unit actualTargetUnit;
		private final Requirement actualSourceRequirement;
		private final Capability actualTargetCapability;
		private final Unit realizedSourceUnit;
		private final Unit realizedTargetUnit;
		private final Requirement realizedSourceRequirement;
		private final Capability realizedTargetCapability;
		private LinkDescriptor[] links = new LinkDescriptor[0];
		private final LinkType linkType;
		private DeployLink link = null;

		public LinkContext(Unit source, Unit target, LinkType type) {
			actualSourceUnit = source;
			actualTargetUnit = target;
			actualSourceRequirement = null;
			actualTargetCapability = null;
			realizedSourceUnit = (Unit) RealizationLinkUtil.getFinalRealization(actualSourceUnit);
			realizedTargetUnit = (Unit) RealizationLinkUtil.getFinalRealization(actualTargetUnit);
			realizedSourceRequirement = null;
			realizedTargetCapability = null;
			linkType = type;
			if (!areRealizedOriginal()) {
				links = dvs.getPossibleLinks(realizedSourceUnit, realizedTargetUnit,
						new LinkType[] { linkType });
			}
			switch (linkType.getValue())
			{
			case LinkType.HOSTING_VALUE:
				link = getHostingLink(source, target);
				break;
			case LinkType.DEPENDENCY_VALUE:
			case LinkType.CONSTRAINT_VALUE:
			case LinkType.MEMBER_VALUE:
			case LinkType.REALIZATION_VALUE:
			default:
				link = null;
			}
		}

		public LinkContext(Unit source, Requirement sourceRequirement, Unit target,
				Capability targetCapability, LinkType type) {
			actualSourceUnit = source;
			actualTargetUnit = target;
			actualSourceRequirement = sourceRequirement;
			actualTargetCapability = targetCapability;
			realizedSourceUnit = (Unit) RealizationLinkUtil.getFinalRealization(actualSourceUnit);
			realizedTargetUnit = (Unit) RealizationLinkUtil.getFinalRealization(actualTargetUnit);
			realizedSourceRequirement = (Requirement) RealizationLinkUtil
					.getImplicitFinalRealization(actualSourceRequirement);
			realizedTargetCapability = (Capability) RealizationLinkUtil
					.getImplicitFinalRealization(actualTargetCapability);
			linkType = type;
			if (!areRealizedOriginal()) {
				links = dvs.getPossibleLinks(realizedSourceUnit, realizedSourceRequirement,
						realizedTargetUnit, realizedTargetCapability, new LinkType[] { linkType });
			}
			switch (linkType.getValue())
			{
			case LinkType.HOSTING_VALUE:
				link = getHostingLink(source, target);
				break;
			case LinkType.DEPENDENCY_VALUE:
			case LinkType.CONSTRAINT_VALUE:
			case LinkType.MEMBER_VALUE:
			case LinkType.REALIZATION_VALUE:
			default:
				link = null;
			}
		}

		public LinkContext(Unit originalLinkSource, Requirement originalLinkSourceReq,
				Unit originalLinkTarget, Capability originalLinkTargetCap, Unit realizedLinkSource,
				Requirement realizedLinkTargetReq, Unit realizedLinkTarget,
				Capability realizedLinkTargetCap, LinkType type) {
			actualSourceUnit = originalLinkSource;
			actualTargetUnit = originalLinkTarget;
			actualSourceRequirement = originalLinkSourceReq;
			actualTargetCapability = originalLinkTargetCap;
			realizedSourceUnit = null == realizedLinkSource ? (Unit) RealizationLinkUtil
					.getFinalRealization(actualSourceUnit) : realizedLinkSource;
			realizedTargetUnit = null == realizedLinkTarget ? (Unit) RealizationLinkUtil
					.getFinalRealization(actualTargetUnit) : realizedLinkTarget;
			if (null == realizedLinkTargetReq) {
				if (null != actualSourceRequirement) {
					realizedSourceRequirement = (Requirement) RealizationLinkUtil
							.getImplicitFinalRealization(actualSourceRequirement);
				} else {
					realizedSourceRequirement = null;
				}
			} else {
				realizedSourceRequirement = realizedLinkTargetReq;
			}
			if (null == realizedLinkTargetCap) {
				if (null != actualSourceRequirement) {
					realizedTargetCapability = (Capability) RealizationLinkUtil
							.getFinalRealization(actualTargetCapability);
				} else {
					realizedTargetCapability = null;
				}
			} else {
				realizedTargetCapability = realizedLinkTargetCap;
			}

			linkType = type;

			// determine what implied links will be
			// to do this, we need to break the existing links 
			// so that the matcher won't complain
			if (!areRealizedOriginal()) {
				DeployModelObject linkSource = null;
				DeployModelObject linkTarget = null;
//				Unit constraintLinkSourceUnit = null;
				switch (linkType.getValue())
				{
				case LinkType.HOSTING_VALUE:
					HostingLink hLink = getHostingLink(actualSourceUnit, actualTargetUnit);
					if (hLink == null) {
						return;
					}
					linkSource = hLink.getHost();
					link = hLink;
					((Unit) linkSource).getHostingLinks().remove(link);
					break;
				case LinkType.DEPENDENCY_VALUE:
					if (actualSourceRequirement == null) {
						return;
					}
					DependencyLink dLink = getDependencyLink(actualSourceRequirement,
							actualTargetCapability);
					if (dLink == null) {
						return;
					}
					linkSource = dLink.getSource();
					linkTarget = dLink.getTarget();
					link = dLink;
					((Requirement) linkSource).setLink(null);
					break;
				case LinkType.CONSTRAINT_VALUE:
//					ConstraintLink cLink = getConstraintLink(source, target);
//					if (cLink == null) {
//						return;
//					}
//					linkSource = cLink.getSource();
//					linkTarget = cLink.getTarget();
//					link = cLink;
//					constraintLinkSourceUnit = linkSource instanceof Unit ? (Unit) linkSource
//							: (Unit) linkSource.getParent();
//					constraintLinkSourceUnit.getConstraintLinks().remove(link);
					break;
				case LinkType.MEMBER_VALUE:
					MemberLink mLink = getMemberLink(actualSourceUnit, actualTargetUnit);
					if (mLink == null) {
						return;
					}
					linkSource = mLink.getSource();
					linkTarget = mLink.getTarget();
					link = mLink;
					((Unit) linkSource).getUnitLinks().remove(link);
					break;
				case LinkType.REALIZATION_VALUE:
				default:
					link = null;
				}

				if (null != realizedSourceRequirement || null != realizedTargetCapability) {
					links = dvs.getPossibleLinks(realizedSourceUnit, realizedSourceRequirement,
							realizedTargetUnit, realizedTargetCapability, new LinkType[] { linkType });
				} else {
					links = dvs.getPossibleLinks(realizedSourceUnit, realizedTargetUnit,
							new LinkType[] { linkType });
				}

				// reconnect links
				switch (linkType.getValue())
				{
				case LinkType.HOSTING_VALUE:
					((Unit) linkSource).getHostingLinks().add(link);
					break;
				case LinkType.DEPENDENCY_VALUE:
					((Requirement) linkSource).setLink((DependencyLink) link);
					break;
				case LinkType.CONSTRAINT_VALUE:
//					((ConstraintLink) link).setSource(linkSource);
//					((ConstraintLink) link).setTarget(linkTarget);
//					constraintLinkSourceUnit.getConstraintLinks().add(link);
					break;
				case LinkType.MEMBER_VALUE:
					((MemberLink) link).setSource((Unit) linkSource);
					((MemberLink) link).setTarget((Unit) linkTarget);
					((Unit) linkSource).getUnitLinks().add(link);
					break;
				case LinkType.REALIZATION_VALUE:
				default:
					// do nothing
				}
			}
		}

		public boolean areRealizedOriginal() {
			return realizedSourceUnit == actualSourceUnit && realizedTargetUnit == actualTargetUnit
					&& realizedSourceRequirement == actualSourceRequirement
					&& realizedTargetCapability == actualTargetCapability;
		}

		public LinkDescriptor[] getLinkDescriptors() {
			return links;
		}

		public Unit getRealizedSourceUnit() {
			return realizedSourceUnit;
		}

		public Unit getRealizedTargetUnit() {
			return realizedTargetUnit;
		}

		public Requirement getRealizedSourceRequirement() {
			return realizedSourceRequirement;
		}

		public Capability getRealizedTargetCapability() {
			return realizedTargetCapability;
		}

		public DeployLink getLink() {
			return link;
		}

		private HostingLink getHostingLink(Unit host, Unit hostee) {
			Set<DeployModelObject> hostPeerSet = RealizationLinkUtil
					.getAllRealizationLinkedObjects(host);
			Set<DeployModelObject> hosteePeerSet = RealizationLinkUtil
					.getAllRealizationLinkedObjects(hostee);
			Topology topology = host.getEditTopology();
			if (topology == null) {
				// cannot determine without topology
				return null;
			}
			// is there a link between hostPeer and hosteePeer ?
			for (Iterator<HostingLink> hostingLinks = topology.findAllHostingLinks(); hostingLinks
					.hasNext();) {
				HostingLink lnk = hostingLinks.next();
				if (hostPeerSet.contains(lnk.getSource()) && hosteePeerSet.contains(lnk.getTarget())) {
					return lnk;
				}
			}
			// should not happen in a valid topology
			return null;
		}

		private DependencyLink getDependencyLink(Requirement source, Capability target) {
			Collection<DeployModelObject> sourcePeerColl = RealizationLinkUtil
					.getAllImplicitRealizationLinkedObjects(source);
			Collection<DeployModelObject> targetPeerColl = RealizationLinkUtil
					.getAllImplicitRealizationLinkedObjects(target);

			for (Iterator<DeployModelObject> sourceIter = sourcePeerColl.iterator(); sourceIter
					.hasNext();) {
				DeployModelObject sourceReq = sourceIter.next();
				if (!CorePackage.Literals.REQUIREMENT.isSuperTypeOf(sourceReq.getEObject().eClass())) {
					continue;
				}
				DependencyLink lnk = ((Requirement) sourceReq).getLink();
				if (null == lnk) {
					continue;
				}
				if (targetPeerColl.contains(lnk.getTarget())) {
					return lnk;
				}
			}
			// should not happen in a valid topology
			return null;
		}

		private MemberLink getMemberLink(Unit group, Unit member) {
			Topology topology = group.getEditTopology();
			if (topology == null) {
				// cannot determine without topology
				return null;
			}
			Set<DeployModelObject> groupPeerSet = RealizationLinkUtil
					.getAllRealizationLinkedObjects(group);
			Set<DeployModelObject> memberPeerSet = RealizationLinkUtil
					.getAllRealizationLinkedObjects(member);
			for (Iterator<MemberLink> memberLinks = topology.findAllMemberLinks(); memberLinks
					.hasNext();) {
				MemberLink lnk = memberLinks.next();
				if (groupPeerSet.contains(lnk.getSource()) && memberPeerSet.contains(lnk.getTarget())) {
					return lnk;
				}
			}
			// should not happen in a valid topology
			return null;
		}

		private ConstraintLink getConstraintLink(Unit source, Unit target) {
			Topology topology = source.getEditTopology();
			if (topology == null) {
				// cannot determine without topology
				return null;
			}
			Set<DeployModelObject> sourcePeerSet = RealizationLinkUtil
					.getAllRealizationLinkedObjects(source);
			Set<DeployModelObject> targetPeerSet = RealizationLinkUtil
					.getAllRealizationLinkedObjects(target);
			for (Iterator<ConstraintLink> constraintLinks = topology.findAllConstraintLinks(); constraintLinks
					.hasNext();) {
				ConstraintLink lnk = constraintLinks.next();
				if (sourcePeerSet.contains(lnk.getSource()) && targetPeerSet.contains(lnk.getTarget())) {
					return lnk;
				}
			}
			// should not happen in a valid topology
			return null;
		}
	}

	private class DependencyLinkPair {
		private final Requirement _source;
		private final Capability _target;

		public DependencyLinkPair(Requirement source, Capability target) {
			_source = source;
			_target = target;
		}

		public Requirement getSource() {
			return _source;
		}

		public Capability getTarget() {
			return _target;
		}
	}

	/**
	 * Retrieve list of units that were added to the diagram during link creation, if any.
	 * <p>
	 * In the core implementation, no units are created. If extensions create links, they need to
	 * record this fact. They can use the provided TopologyState to do so.
	 * 
	 * @return list of new units
	 */
	public List<DeployModelObject> getNewUnits() {
		if (null == _topologyState) {
			return Collections.emptyList();
		}
		return _topologyState.getNewUnits();
	}

	/**
	 * Determine if the link creation used the original endpoints specified by this descriptor or if
	 * the endpoints were changed by the link creation.
	 * <p>
	 * In the core implementation, end original endpoints are always used. Extensions that change
	 * this behavior need to indicate that they have done so.
	 * 
	 * @return indicator whether the link endpoints match the original endpoints specified by this
	 *         descriptor
	 */
	public boolean endpointsChanged() {
		return _endpointsChanged;
	}

	/**
	 * Based on com.ibm.ccl.soa.deploy.core.ui.util.TopologyStateData
	 */
	protected class TopologyState {
		private final Topology _topology;
		private final List<DeployModelObject> _oldUnits = new ArrayList<DeployModelObject>();
		private final List<DeployModelObject> _newUnits = new ArrayList<DeployModelObject>();

		/**
		 * save current topology state
		 * 
		 * @param topology
		 *           topology to be saved
		 */
		public TopologyState(Topology topology) {
			if (topology == null) {
				_topology = null;
				return;
			}
			_topology = topology;

			// save topology state
			for (Iterator<DeployModelObject> it = _topology.findAllUnits(); it.hasNext();) {
				Unit unit = (Unit) it.next();
				//cfgMap.put(unit, new Boolean(unit.isConfigurationUnit()));
				_oldUnits.add(unit);
			}

			// removed code to determine new links
		}

		public void markChanges() {
			if (_topology == null) {
				return;
			}

			for (Iterator<DeployModelObject> it = _topology.findAllUnits(); it.hasNext();) {
				Unit newUnit = (Unit) it.next();
				if (!_oldUnits.contains(newUnit)) {
					_newUnits.add(newUnit);
				}
			}
		}

		/**
		 * @return new units
		 */
		public List<DeployModelObject> getNewUnits() {
			return _newUnits;
		}

	}

}
