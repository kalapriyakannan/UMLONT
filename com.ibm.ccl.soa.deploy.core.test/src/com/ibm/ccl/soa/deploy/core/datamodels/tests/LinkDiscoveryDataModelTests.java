/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.datamodels.tests;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelOperation;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitDescriptor;
import com.ibm.ccl.soa.deploy.core.datamodels.LinkDiscoveryDataModel;
import com.ibm.ccl.soa.deploy.core.internal.datamodels.DiscoveryDescriptor;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.test.validator.matcher.implicitlinks.ILLinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.expression.Equals;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.internal.core.extension.DiscoverAndAddService;

/**
 * Unit tests for
 * {@link  com.ibm.ccl.soa.deploy.core.datamodels.LinkDiscoveryDataModel }
 * 
 * <p>
 * Clients should use {@link LinkDiscoveryDataModel#createConfiguredOperation()}
 * to create an instance of this operation, configured with the necessary model
 * properties.
 * </p>
 * 
 * @see com.ibm.ccl.soa.deploy.core.internal.datamodels.LinkDiscoveryDataModelOperation
 * @see com.ibm.ccl.soa.deploy.core.datamodels.LinkDiscoveryDataModel
 */
public class LinkDiscoveryDataModelTests extends TopologyTestCase {

	public LinkDiscoveryDataModelTests(String name) {
		super(name);
	}

	public void testHostingOperationWithRequiredProperties() throws Exception {

		Topology top = createTopology("testHostDiscovery");
		Unit hosted = addUnit(top, "hosted");
		addRequirement(hosted, "hostedReq", RequirementLinkTypes.HOSTING_LITERAL);
		Unit host = addUnit(top, "host");
		addCapability(host, "hostCap", CapabilityLinkTypes.HOSTING_LITERAL);

		LinkDiscoveryDataModel linkDiscoveryDataModel = LinkDiscoveryDataModel.createModel();

		linkDiscoveryDataModel.setUnit(hosted);
		linkDiscoveryDataModel.setIsHosting(true);
		linkDiscoveryDataModel.setIsLogical(false);
		linkDiscoveryDataModel.setIsDependency(false);
		linkDiscoveryDataModel.setIsGroup(false);

		List<DiscoveryDescriptor> hostOptions = wrapHostingTUDs(DiscoverAndAddService.INSTANCE.discoverHostUnitDescriptors(linkDiscoveryDataModel.getUnit()), linkDiscoveryDataModel.getUnit());
		linkDiscoveryDataModel.setDescriptors(hostOptions.toArray());

		IDataModelOperation op = linkDiscoveryDataModel.createConfiguredOperation();

		IProgressMonitor monitor = createProgressMonitor();
		IStatus status = op.execute(monitor, null);

		assertTrue("The operation did not complete successfully.", status.isOK()); // $NON-NLS-1$
		assertFalse(host.getHostingLinks().isEmpty());

	}

	public void testLogicalUnitOperationWithRequiredProperties() throws Exception {

		Topology infraTop = createTopology("Discovery", "test", true);

		// Target

		Unit target = addUnit(infraTop, "target");
		Capability cap = addCapability(target, "dependencyCap", CapabilityLinkTypes.DEPENDENCY_LITERAL);
		cap.setDescription("test");
		target.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		// Source
		Unit source = addUnit(infraTop, "source");
		Requirement req = addRequirement(source, "dependencyReq", CorePackage.Literals.CAPABILITY, RequirementLinkTypes.DEPENDENCY_LITERAL);
		RequirementExpression reqExpr = Equals.createExpression(CorePackage.Literals.DEPLOY_MODEL_OBJECT__DESCRIPTION, "test");
		req.getExpressions().add(reqExpr);
		source.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		target.setMutable(false);
		source.setMutable(false);
		cap.setMutable(false);
		req.setMutable(false);
		reqExpr.setMutable(false);


		LinkDiscoveryDataModel linkDiscoveryDataModel = LinkDiscoveryDataModel.createModel();
		linkDiscoveryDataModel.setUnit(source);
		linkDiscoveryDataModel.setIsHosting(false);
		linkDiscoveryDataModel.setIsLogical(true);
		linkDiscoveryDataModel.setIsDependency(false);
		linkDiscoveryDataModel.setIsGroup(false);
		List<DiscoveryDescriptor> logicalOptions = wrapLogicalLDs(DiscoverAndAddService.INSTANCE.discoverLogicalLinks(linkDiscoveryDataModel.getUnit()));


		linkDiscoveryDataModel.setDescriptors(logicalOptions.toArray());

		IDataModelOperation op = linkDiscoveryDataModel.createConfiguredOperation();

		IProgressMonitor monitor = createProgressMonitor();
		IStatus status = op.execute(monitor, null);

	//	assertTrue("The operation did not complete successfully.", status.isOK()); // $NON-NLS-1$

		
		//bassertTrue(source.getLogicalLinks() != null);

	}

	public void testDependencyUnitOperationWithRequiredProperties() throws Exception {

		Topology infraTop = createTopology("Discovery", "test", true);

		// Target

		Unit target = addUnit(infraTop, "target");
		Capability cap = addCapability(target, "dependencyCap", CapabilityLinkTypes.DEPENDENCY_LITERAL);
		cap.setDescription("test");
		target.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		// Source
		Unit source = addUnit(infraTop, "source");
		Requirement req = addRequirement(source, "dependencyReq", CorePackage.Literals.CAPABILITY, RequirementLinkTypes.DEPENDENCY_LITERAL);
		RequirementExpression reqExpr = Equals.createExpression(CorePackage.Literals.DEPLOY_MODEL_OBJECT__DESCRIPTION, "test");
		req.getExpressions().add(reqExpr);
		source.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		target.setMutable(false);
		source.setMutable(false);
		cap.setMutable(false);
		req.setMutable(false);
		reqExpr.setMutable(false);

		LinkDiscoveryDataModel linkDiscoveryDataModel = LinkDiscoveryDataModel.createModel();
		linkDiscoveryDataModel.setUnit(source);
		Map m = null;
		List<DiscoveryDescriptor> possibilities = new LinkedList<DiscoveryDescriptor>();
		m = DiscoverAndAddService.INSTANCE.discoverDependencyUnitDescriptors(linkDiscoveryDataModel.getUnit());
		if (m != null) {
			List<DiscoveryDescriptor> dependencyOptions = wrapDependencyTUDs(m);
			possibilities.addAll(dependencyOptions);

		}
		linkDiscoveryDataModel.setDescriptors(possibilities.toArray());

		IDataModelOperation op = linkDiscoveryDataModel.createConfiguredOperation();

		IProgressMonitor monitor = createProgressMonitor();
		IStatus status = op.execute(monitor, null);

		assertTrue("The operation did not complete successfully.", status.isOK()); // $NON-NLS-1$

		assertTrue(req.getLink() != null);

	}

	public void testRequirementDiscoveryOperationWithRequiredProperties() throws Exception {

		Topology infraTop = createTopology("Discovery", "test", true);

		// Target

		Unit target = addUnit(infraTop, "target");
		Capability cap = addCapability(target, "dependencyCap", CapabilityLinkTypes.DEPENDENCY_LITERAL);
		cap.setDescription("test");
		target.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		// Source
		Unit source = addUnit(infraTop, "source");
		Requirement req = addRequirement(source, "dependencyReq", CorePackage.Literals.CAPABILITY, RequirementLinkTypes.DEPENDENCY_LITERAL);
		RequirementExpression reqExpr = Equals.createExpression(CorePackage.Literals.DEPLOY_MODEL_OBJECT__DESCRIPTION, "test");
		req.getExpressions().add(reqExpr);
		source.setInitInstallState(InstallState.NOT_INSTALLED_LITERAL);
		target.setMutable(false);
		source.setMutable(false);
		cap.setMutable(false);
		req.setMutable(false);
		reqExpr.setMutable(false);

		LinkDiscoveryDataModel linkDiscoveryDataModel = LinkDiscoveryDataModel.createModel();
		linkDiscoveryDataModel.setRequirement(req);
		Map<Requirement, List<LinkDescriptor>> m = null;
		List<DiscoveryDescriptor> possibilities = new LinkedList<DiscoveryDescriptor>();
		m = DiscoverAndAddService.INSTANCE.discoverDependencyUnitDescriptors(linkDiscoveryDataModel.getRequirement());
		if (m != null) {
			List<DiscoveryDescriptor> dependencyOptions = wrapDependencyTUDs(m);
			possibilities.addAll(dependencyOptions);

		}
		linkDiscoveryDataModel.setDescriptors(possibilities.toArray());

		IDataModelOperation op = linkDiscoveryDataModel.createConfiguredOperation();

		IProgressMonitor monitor = createProgressMonitor();
		IStatus status = op.execute(monitor, null);

		assertTrue("The operation did not complete successfully.", status.isOK()); // $NON-NLS-1$

		assertTrue(req.getLink() != null);

	}

	private List<DiscoveryDescriptor> wrapDependencyTUDs(Map<Requirement, List<LinkDescriptor>> m) {
		List<DiscoveryDescriptor> retVal = new LinkedList<DiscoveryDescriptor>();

		for (Iterator<Map.Entry<Requirement, List<LinkDescriptor>>> it = m.entrySet().iterator(); it.hasNext();) {
			Map.Entry<Requirement, List<LinkDescriptor>> entry = /* (Map.Entry) */it.next();
			Requirement req = /* (Requirement) */entry.getKey();
			List<LinkDescriptor> l = /* (List) */entry.getValue();

			for (LinkDescriptor linkDescriptor : l) {
				if (!(linkDescriptor instanceof ILLinkDescriptor)) {
					retVal.add(new DiscoveryDescriptor(linkDescriptor));
				}
			}
		}

		return retVal;
	}

	public void testGroupOperationWithRequiredProperties() throws Exception {

		Topology top = createTopology("testMemberUnitDiscovery");
		Unit member = addUnit(top, "member");
		Capability memberCap = addCapability(member, "memberCap", CapabilityLinkTypes.ANY_LITERAL);
		Unit group = addGroupUnit(top, "group", 1, 1);

		LinkDiscoveryDataModel typesafeModel = LinkDiscoveryDataModel.createModel();

		typesafeModel.setUnit(member);
		typesafeModel.setIsHosting(false);
		typesafeModel.setIsLogical(false);
		typesafeModel.setIsDependency(false);
		typesafeModel.setIsGroup(true);

		Map m = null;

		List<DiscoveryDescriptor> memberOptions = wrapMemberTUDs(DiscoverAndAddService.INSTANCE.discoverContainerUnitDescriptors(typesafeModel.getUnit()), typesafeModel.getUnit());

		typesafeModel.setDescriptors(memberOptions.toArray());
		IDataModelOperation op = typesafeModel.createConfiguredOperation();

		IProgressMonitor monitor = createProgressMonitor();
		IStatus status = op.execute(monitor, null);

		assertTrue("The operation did not complete successfully.", status.isOK()); // $NON-NLS-1$
		assertTrue(member.getMemberLinks() != null);
		// TODO Verify the proper execution of the operation.

	}

	public IProgressMonitor createProgressMonitor() {
		// TODO Consider using a smarter progress monitor that can enforce a
		// minimum number of messages.
		return new NullProgressMonitor();
	}

	private List<DiscoveryDescriptor> wrapHostingTUDs(List<UnitDescriptor> list, Unit unit) {
		List<DiscoveryDescriptor> retVal = new LinkedList<DiscoveryDescriptor>();

		for (Iterator<UnitDescriptor> it = list.iterator(); it.hasNext();) {
			UnitDescriptor ud = /* (UnitDescriptor) */it.next();
			retVal.add(new DiscoveryDescriptor(ud, unit, ud.getUnitValue().getTopology(), LinkType.HOSTING));
		}

		return retVal;
	}

	private List<DiscoveryDescriptor> wrapMemberTUDs(List<UnitDescriptor> list, Unit unit) {
		List<DiscoveryDescriptor> retVal = new LinkedList<DiscoveryDescriptor>();

		for (Iterator<UnitDescriptor> it = list.iterator(); it.hasNext();) {
			UnitDescriptor ud = /* (UnitDescriptor) */it.next();
			retVal.add(new DiscoveryDescriptor(ud, unit, ud.getUnitValue().getTopology(), LinkType.MEMBER));
		}

		return retVal;
	}

	private List<DiscoveryDescriptor> wrapLogicalLDs(Set<LinkDescriptor> s) {
		List<DiscoveryDescriptor> retVal = new LinkedList<DiscoveryDescriptor>();
		for (Iterator<LinkDescriptor> it = s.iterator(); it.hasNext();) {
			retVal.add(new DiscoveryDescriptor(it.next()));
		}
		return retVal;
	}

}
