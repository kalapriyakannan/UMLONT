/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.test.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitProvider;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IUnitProviderService;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;

/**
 * Unit test provider of units from a topology.
 * <p>
 * The provided type is the path wrapper {@link JUnitObjectPathReference}.
 */
public class JUnitTopologyProvider extends UnitProvider {
	protected Topology topology = null;

	public static final String ANNOTATION_KEY = JUnitTopologyProvider.class
			.getName();

	/**
	 * Shared instance of the topology provider.
	 */
	private static JUnitTopologyProvider instance;

	/**
	 * Shared instance of the unit provider service.
	 */
	private static IUnitProviderService service;

	/**
	 * Returns the shared unit provider service instance for unit-tests.
	 * 
	 * @return the unit provider service.
	 */
	public static IUnitProviderService getUnitProviderService() {
		synchronized (TopologyTestCase.class) {
			if (service == null) {
				service = ExtensionsCore.createProviderService();
			}
		}
		return service;
	}

	/**
	 * Returns the instance of the provider in the shared service.
	 * 
	 * @return the provider instance.
	 * @see #getUnitProviderService()
	 */
	public static JUnitTopologyProvider getInstance() {
		synchronized (TopologyTestCase.class) {
			if (instance == null) {
				IUnitProviderService service = getUnitProviderService();
				Unit unit = CoreFactory.eINSTANCE.createUnit();
				unit.setName("unit");
				JUnitObjectPathReference ref = new JUnitObjectPathReference(
						unit);
				UnitProvider[] provs = service
						.findEnabledProvidersByInputOnly(ref);
				if ((provs == null) || (provs.length == 0)) {
					throw new RuntimeException("No provider found for "
							+ ref.getClass().getName());
				} else if (provs.length > 1) {
					throw new RuntimeException("Multiple providers found for "
							+ ref.getClass().getName());

				}
				instance = (JUnitTopologyProvider) provs[0];
			}
		}
		return instance;
	}

	public void setTopology(Topology top) {
		this.topology = top;
	}

	protected String getAnnotationPath(DeployModelObject object) {
		if (object == null) {
			return null;
		}
		Annotation a = object.findAnnotation(ANNOTATION_KEY);
		if (a == null) {
			return null;
		}
		return (String) a.getDetails().get(ANNOTATION_KEY);
	}

	/**
	 * Given an object with an annotation, returns the topology object that
	 * provided it.
	 * 
	 * @param object
	 *            a topology object.
	 * @return the original object or null if not found.
	 */
	public DeployModelObject lookupOriginal(DeployModelObject object) {
		if (topology == null) {
			return null;
		}
		assert object != null;
		assert topology != object.getTopology();

		Unit unit = ValidatorUtils.getUnit(object);
		if (unit == null) {
			return null;
		}
		String path = getAnnotationPath(unit);
		if (path == null) {
			return null;
		}
		DeployModelObject originalUnit = (Unit) topology.resolve(path);
		if ((originalUnit == null)
				|| (!(originalUnit.eClass() == unit.eClass()))) {
			return null;
		}
		if (unit == object) {
			return originalUnit;
		}

		DeployModelObject original = originalUnit.resolve(object
				.getRelativePath(unit));
		if ((original == null) || (!original.eClass().equals(object.eClass()))) {
			return null;
		}
		return original;
	}

	/**
	 * Given an original object returns the provided copy in the topology.
	 * 
	 * @param original
	 *            a infrastructure topology object.
	 * @param copyTopolgy
	 *            the topology into which the original was provided.
	 * @return the provided copy of the original object in the copy topology, or
	 *         null if it has not been provided.
	 */
	public DeployModelObject lookupProvided(DeployModelObject original,
			Topology copyTopology) {
		assert copyTopology != null;
		assert original != null;

		Unit originalUnit = ValidatorUtils.getUnit(original);
		if (originalUnit == null) {
			return null;
		}
		String originalUnitPath = originalUnit.getFullPath();
		for (Iterator<Unit> iter = copyTopology.findAllUnits(); iter.hasNext();) {
			Unit cur = iter.next();
			String path = getAnnotationPath(cur);
			if ((path != null) && (path.equals(originalUnitPath))
					&& (originalUnit.eClass() == cur.eClass())) {
				if (original == originalUnit) {
					return cur;
				}
				DeployModelObject provided = cur.resolve(original
						.getRelativePath(originalUnit));
				if ((provided != null)
						&& (provided.eClass() == original.eClass())) {
					return provided;
				}
			}
		}
		return null;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.UnitProvider#resolveLinks(java.util.List,
	 *      org.eclipse.core.runtime.IProgressMonitor)
	 */
	public boolean resolveLinks(List deployModelObjects,
			IProgressMonitor monitor) {
		if (topology == null) {
			return false;
		}

		for (DeployModelObject object : (List<DeployModelObject>) deployModelObjects) {
			DeployModelObject original = lookupOriginal(object);
			if (original instanceof Unit) {
				Unit unit = (Unit) object;
				Unit originalUnit = (Unit) original;

				// Check for hosting links in
				for (HostingLink link : TopologyUtil
						.getImmediateHostingLinksIn(originalUnit)) {
					if (link.getSource() == null) {
						continue;
					}
					Unit host = (Unit) lookupProvided(link.getSource(), object
							.getTopology());
					if (host == null) {
						continue;
					}
					List<Unit> hosts = ValidatorUtils.getAllHosts(unit);
					if (!hosts.contains(host)) {
						LinkFactory.createHostingLink(host, unit);
					}
				}

				// Check for hosting links out
				for (HostingLink link : TopologyUtil
						.getImmediateHostingLinksOut(originalUnit)) {
					if (link.getTarget() == null) {
						continue;
					}
					Unit hosted = (Unit) lookupProvided(link.getTarget(),
							object.getTopology());
					if (hosted == null) {
						continue;
					}
					List<Unit> hostedList = ValidatorUtils.getHosted(unit);
					if (!hostedList.contains(hosted)) {
						LinkFactory.createHostingLink(unit, hosted);
					}
				}

				// Check for member links in
				for (MemberLink link : TopologyUtil
						.getImmediateMemberLinksIn(originalUnit)) {
					if (link.getSource() == null) {
						continue;
					}
					Unit group = (Unit) lookupProvided(link.getSource(), object
							.getTopology());
					if (group == null) {
						continue;
					}
					List<Unit> groups = ValidatorUtils.getGroups(unit);
					if (!groups.contains(group)) {
						LinkFactory.createMemberLink(group, unit);
					}
				}

				// Check for member links out
				for (MemberLink link : TopologyUtil
						.getImmediateMemberLinksOut(originalUnit)) {
					if (link.getTarget() == null) {
						continue;
					}
					Unit member = (Unit) lookupProvided(link.getTarget(),
							object.getTopology());
					if (member == null) {
						continue;
					}
					List<Unit> memberList = ValidatorUtils.getMembers(unit);
					if (!memberList.contains(member)) {
						LinkFactory.createMemberLink(unit, member);
					}
				}
			} else if (original instanceof Requirement) {
				Requirement req = (Requirement) object;
				Requirement originalReq = (Requirement) original;
				// Check for dependency links out
				for (DependencyLink link : TopologyUtil
						.getImmediateDependencyLinksOut(originalReq)) {
					if (link.getTarget() == null) {
						continue;
					}
					Capability cap = (Capability) lookupProvided(link
							.getTarget(), object.getTopology());
					if (cap == null) {
						continue;
					}
					Capability currentCap = ValidatorUtils
							.getDependencyLinkTarget(req);
					if (cap != currentCap) {
						LinkFactory.createDependencyLink(req, cap);
					}
				}
			} else if (original instanceof Capability) {
				Capability cap = (Capability) object;
				Capability originalCap = (Capability) original;
				// Check for dependency links in
				for (DependencyLink link : TopologyUtil
						.getImmediateDependencyLinksIn(originalCap)) {
					if (link.getSource() == null) {
						continue;
					}
					Requirement req = (Requirement) lookupProvided(link
							.getSource(), object.getTopology());
					if (req == null) {
						continue;
					}
					List<Requirement> reqList = ValidatorUtils
							.getDependencyLinkSources(cap);
					if (!reqList.contains(req)) {
						LinkFactory.createDependencyLink(req, cap);
					}
				}
			}

		}

		return false;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.UnitProvider#resolveStubs(java.lang.Object)
	 */
	public TopologyUnitStub[] resolveStubs(Object object) {
		if (!(object instanceof JUnitObjectPathReference)) {
			return NO_STUBS;
		}
		JUnitObjectPathReference ref = (JUnitObjectPathReference) object;
		TopologyUnitStub stub = new TopologyUnitStub(ref.getTitle(), ref
				.getTypeName(), null, object);
		return new TopologyUnitStub[] { stub };
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.UnitProvider#resolveUnit(com.ibm.ccl.soa.deploy.core.TopologyUnitStub,
	 *      boolean, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public Object[] resolveUnit(TopologyUnitStub stub, boolean toResolveLazily,
			IProgressMonitor monitor) {
		if (topology == null) {
			return NO_MODEL_OBJS;
		}
		if (!(stub.getInput() instanceof JUnitObjectPathReference)) {
			return NO_MODEL_OBJS;
		}
		JUnitObjectPathReference ref = (JUnitObjectPathReference) stub
				.getInput();
		DeployModelObject object = topology.resolve(ref.getPath());
		if (!(object instanceof Unit)) {
			return NO_MODEL_OBJS;
		}
		Unit unit = (Unit) object;
		Unit copy = copyUnitWithoutLinks(unit);
		return new Object[] { copy };
	}

	/**
	 * Copies the unit and all its contained objects except links (recursive).
	 * <p>
	 * Uses {@link EcoreUtil#copy(EObject)} and removes any copied contained
	 * instances of {@link DeployLink}.
	 * 
	 * @param unit
	 *            the unit to be copied.
	 * @return the copy of the unit.
	 */
	public static Unit copyUnitWithoutLinks(Unit unit) {
		Unit copy = (Unit) EcoreUtil.copy(unit);
		List<EObject> list = new ArrayList<EObject>();
		for (Iterator<EObject> iter = copy.getEObject().eAllContents(); iter
				.hasNext();) {
			EObject containedObject = iter.next();
			list.add(containedObject);
		}
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			EObject containedObject = (EObject) iter.next();
			if (containedObject instanceof DeployLink) {
				assert containedObject.eContainmentFeature() != null;
				Object container = containedObject.eContainer().eGet(
						containedObject.eContainmentFeature());
				if (container instanceof List) {
					List clist = (List) container;
					assert clist != null;
					assert clist.contains(containedObject) : containedObject
							.eContainer()
							+ "\n" + clist + "\n" + containedObject;
					clist.remove(containedObject);
				} else if (!(container instanceof Collection)) {
					containedObject.eContainer().eUnset(
							containedObject.eContainmentFeature());
				}
			}
		}
		Annotation a = CoreFactory.eINSTANCE.createAnnotation();
		a.setContext(ANNOTATION_KEY);
		a.getDetails().put(ANNOTATION_KEY, unit.getFullPath());
		copy.getAnnotations().add(a);
		copy.setInitInstallState(InstallState.INSTALLED_LITERAL);

		return copy;
	}
}
