/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.validator.matcher;

import java.util.ArrayList;
import java.util.List;

import com.ibm.ccl.soa.deploy.core.BundleCapability;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.VersionConstraint;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.deploy.j2ee.EarModule;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.WebModule;
import com.ibm.ccl.soa.deploy.j2ee.bindings.BindingsHelperManager;
import com.ibm.ccl.soa.deploy.j2ee.bindings.IBindingsHelper;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.internal.j2ee.validator.WasJ2eeConstraintUtils;
import com.ibm.ccl.soa.deploy.was.internal.j2ee.validator.WasJ2eeValidatorUtils;

/**
 * Link Descriptor for WebSphere. Overrides create methods.
 */
public class WasLinkDescriptor extends LinkDescriptor {

	protected final WasLinkDescriptorFactory ldFactory = new WasLinkDescriptorFactory();

	public WasLinkDescriptor(LinkType type, DeployModelObject source, DeployModelObject target) {
		super(type, source, target);
		this.setLinkDescriptorFactory(ldFactory);
	}

	public WasLinkDescriptor(LinkType type, Unit source, Requirement sourceRequirement, Unit target,
			Capability targetCapability) {
		super(type, source, sourceRequirement, target, targetCapability);
		this.setLinkDescriptorFactory(ldFactory);
	}

	public WasLinkDescriptor(LinkType type, DeployModelObject source, DeployModelObject target,
			int linkWeight) {
		super(type, source, target, linkWeight);
		this.setLinkDescriptorFactory(ldFactory);
	}

	public WasLinkDescriptor(LinkType type, Unit source, Requirement sourceRequirement, Unit target,
			Capability targetCapability, int linkWeight) {
		super(type, source, sourceRequirement, target, targetCapability, linkWeight);
		this.setLinkDescriptorFactory(ldFactory);
	}

//	@Override
//	protected DependencyLink createDependencyLink() {
//		DependencyLink link = super.createDependencyLink();
//
//		Requirement source = link.getSource();
//		Unit sourceUnit = (Unit) source.getParent();
//		Capability target = link.getTarget();
//		Unit targetUnit = (Unit) target.getParent();
//
//		// FIXME: this matcher is never called
//		if (WasPackage.Literals.SHARED_LIBRARY_ENTRY.isSuperTypeOf(source.getDmoEType())) {
//			// add optional dependency requirement for SharedLibraryEntry
//			// if not already present AND if there is not already an unlinked one
//			addSharedLibraryEntryRequirement(sourceUnit);
//		}
//
//		if (CorePackage.Literals.BUNDLE_CAPABILITY.isSuperTypeOf(source.getDmoEType())
//				&& WasPackage.Literals.WAS_SHARED_LIBRARY_ENTRY_UNIT.isSuperTypeOf(sourceUnit
//						.getEObject().eClass())
//				&& J2eePackage.Literals.JAR_MODULE.isSuperTypeOf(targetUnit.getEObject().eClass())) {
//			updateBundleCapabilityRequirementExpresssions(source, (BundleCapability) target);
//			addBundleCapabilityRequirement(sourceUnit);
//		}
//
//		return link;
//	}
//
	@Override
	public void postDependencyLinkCreate(Unit source, Requirement sourceRequirement, Unit target,
			Capability targetCapability, DependencyLink lnk) {

		if (WasPackage.Literals.SHARED_LIBRARY_ENTRY.isSuperTypeOf(sourceRequirement.getDmoEType())) {
			// add optional dependency requirement for SharedLibraryEntry
			// if not already present AND if there is not already an unlinked one
			addSharedLibraryEntryRequirement(source);
		}

		if (CorePackage.Literals.BUNDLE_CAPABILITY.isSuperTypeOf(sourceRequirement.getDmoEType())
				&& WasPackage.Literals.WAS_SHARED_LIBRARY_ENTRY_UNIT.isSuperTypeOf(source.getEObject()
						.eClass())
				&& J2eePackage.Literals.JAR_MODULE.isSuperTypeOf(target.getEObject().eClass())) {
			updateBundleCapabilityRequirementExpresssions(sourceRequirement,
					(BundleCapability) targetCapability);
			addBundleCapabilityRequirement(source);
		}

	}

	@Override
	public void postHostingLinkCreate(Unit host, Unit hostee, HostingLink link) {
		// if this method changes, may need to change {@link WasHostingLinkMatcherFilter} 
		// to ensure that the new actions are permissible (ie, that method is contract aware)

		List<Unit> units = new ArrayList<Unit>();
		units.add(host);
		units.add(hostee);

		if (hostee instanceof EarModule) {
			// add optional dependency requirement for SharedLibraryEntry
			// if not already present AND if there is not already an unlinked one
			addSharedLibraryEntryRequirement(hostee);

			// add optional dependency requirement for SharedLibraryEntry to each contained WebModule
			List<Unit> containedModules = ValidatorUtils.getMembers(hostee);
			for (int i = 0; i < containedModules.size(); i++) {
				Unit module = containedModules.get(i);
				if (module instanceof WebModule) {
					addSharedLibraryEntryRequirement(module);
				}
			}

			// create any obvious links between the hostee and host
			units.addAll(ValidatorUtils.getMembers(hostee));
		}

		if (hostee instanceof WebModule) {
			// add optional dependency requirement for SharedLibraryEntry
			// if not already present AND if there is not already an unlinked one
			addSharedLibraryEntryRequirement(hostee);
		}

		BindingsHelperManager bindingsManager = BindingsHelperManager.getInstance();
		IBindingsHelper[] helpers = bindingsManager.findEnabledBindingsHelpers(host);
		IBindingsHelper helper = helpers.length == 0 ? bindingsManager.getDefault() : helpers[0];

		// add jndi binding constraints
		WasJ2eeConstraintUtils.addJNDIBindingConstraints(units, helper);

		// add security role constraints
		WasJ2eeConstraintUtils.addSecuritySubjectConstraints(units, helper);

		// add start weight constraints
		WasJ2eeConstraintUtils.addStartWeightConstraints(units);

		// add classloader policy constraints
		WasJ2eeConstraintUtils.addClassloaderPolicyConstraints(units);

		// create any obvious links between the hostee and host
		resolveLinks(units, host);
	}

//	private void addSecuritySubjectConstraints(List<Unit> units, IBindingsHelper bindingsHelper) {
//		// add security role constraints
//		List<Capability> securityRoles = new ArrayList<Capability>();
//		for (Iterator<Unit> iter = units.iterator(); iter.hasNext();) {
//			securityRoles.addAll(ValidatorUtils.getCapabilities(iter.next(),
//					J2eePackage.Literals.J2EE_SECURITY_ROLE));
//		}
//
//		for (int i = 0; i < securityRoles.size(); i++) {
//			// String subject = WasDefaultSecuritySubjectEnum.ALL_AUTHENTICATED_LITERAL.toString();
//			J2EESecurityRole securityRole = (J2EESecurityRole) securityRoles.get(i);
//			List<Constraint> constraints = ValidatorUtils.getConstraints(securityRole,
//					WasPackage.Literals.WAS_SECURITY_SUBJECT_CONSTRAINT);
//			securityRole.getConstraints().removeAll(constraints);
//			List<String> subjects = bindingsHelper.getBindings(securityRole);
//			for (Iterator<String> iter = subjects.iterator(); iter.hasNext();) {
//				createOrModifyWasSecuritySubjectConstraint(securityRole, iter.next());
//			}
//
//			if (subjects.size() == 0) {
//				createOrModifyWasSecuritySubjectConstraint(securityRole, new String());
//			}
//		}
//	}
//
//	private void addClassloaderPolicyConstraints(List<Unit> units) {
//		for (Iterator<Unit> iter = units.iterator(); iter.hasNext();) {
//			Unit unit = iter.next();
//			if (J2eePackage.Literals.WEB_MODULE.isSuperTypeOf(unit.getEObject().eClass())) {
//				createOrModifyWasWarClassloaderPolicyConstraint((WebModule) unit);
//			} else if (J2eePackage.Literals.EAR_MODULE.isSuperTypeOf(unit.getEObject().eClass())) {
//				createOrModifyWasEarClassloaderPolicyConstraint((EarModule) unit);
//			}
//		}
//	}
//
//	private void addStartWeightConstraints(List<Unit> units) {
//		for (Iterator<Unit> iter = units.iterator(); iter.hasNext();) {
//			Unit unit = iter.next();
//			if (J2eePackage.Literals.EJB_MODULE.isSuperTypeOf(unit.getEObject().eClass())
//					|| J2eePackage.Literals.WEB_MODULE.isSuperTypeOf(unit.getEObject().eClass())) {
//				createOrModifyWasModuleStartWeightConstraint(unit);
//			}
//		}
//	}
//
//	private void addJNDIBindingConstraints(List<Unit> units, IBindingsHelper bindingsHelper) {
//		for (Iterator<Unit> iter = units.iterator(); iter.hasNext();) {
//			Unit unit = iter.next();
//			if (J2eePackage.Literals.EJB_MODULE.isSuperTypeOf(unit.getEObject().eClass())
//					|| J2eePackage.Literals.WEB_MODULE.isSuperTypeOf(unit.getEObject().eClass())
//					|| J2eePackage.Literals.EAR_MODULE.isSuperTypeOf(unit.getEObject().eClass())) {
//				createOrModifyWasJNDIBindingConstraints(unit, bindingsHelper);
//			}
//		}
//	}
//
	private void addSharedLibraryEntryRequirement(Unit module) {
		Requirement r = WasJ2eeValidatorUtils.getAvailableRequirement(module,
				WasPackage.Literals.SHARED_LIBRARY_ENTRY);
		if (null != r) {
			// there is already an available requirement for linking
			return;
		}

		// add a SharedLibraryReference requirement
		WasJ2eeValidatorUtils.addSharedLibraryEntryRequirement(module);

	}

	private void updateBundleCapabilityRequirementExpresssions(Requirement source,
			BundleCapability target) {

//		MK 2008/02/07 Defect 5328: Remove usage of Requirement Expressions from the WAS domain				
//		RequirementExpression re = CoreFactory.eINSTANCE.createRequirementExpression();
//		String attributeName = CorePackage.Literals.BUNDLE_CAPABILITY__ID.getName();
//		re.setAttributeName(attributeName);
//		re.setInterpreter(Equals.INTERPRETER_ID);
//		re.setUse(RequirementExpressionUsage.REQUIRED_LITERAL);
//		re.setValue(target.getId());
//		re.setName(WasJ2eeValidatorUtils.getUniqueName(source, attributeName));
//		source.getExpressions().add(re);
//
//		re = CoreFactory.eINSTANCE.createRequirementExpression();
//		attributeName = CorePackage.Literals.BUNDLE_CAPABILITY__VERSION.getName();
//		re.setAttributeName(attributeName);
//		re.setInterpreter(GreaterThanEquals.INTERPRETER_ID);
//		re.setUse(RequirementExpressionUsage.REQUIRED_LITERAL);
//		re.setValue(target.getVersion());
//		re.setName(WasJ2eeValidatorUtils.getUniqueName(source, attributeName));
//		source.getExpressions().add(re);
//
//		re = CoreFactory.eINSTANCE.createRequirementExpression();
//		attributeName = CorePackage.Literals.BUNDLE_CAPABILITY__VERSION.getName();
//		re.setAttributeName(attributeName);
//		re.setInterpreter(LessThanEquals.INTERPRETER_ID);
//		re.setUse(RequirementExpressionUsage.REQUIRED_LITERAL);
//		re.setValue(target.getVersion());
//		re.setName(WasJ2eeValidatorUtils.getUniqueName(source, attributeName));
//		source.getExpressions().add(re);

		EqualsConstraint ec = ConstraintFactory.eINSTANCE.createEqualsConstraint();
		String attributeName = CorePackage.Literals.BUNDLE_CAPABILITY__ID.getName();
		ec.setAttributeName(attributeName);
		ec.setValue(target.getId());
		ec.setName(WasJ2eeValidatorUtils.getUniqueName(source, attributeName));
		source.getConstraints().add(ec);

		VersionConstraint vc = ConstraintFactory.eINSTANCE.createVersionConstraint();
		attributeName = CorePackage.Literals.BUNDLE_CAPABILITY__VERSION.getName();
		vc.setAttributeName(attributeName);
		vc.setValue(target.getVersion());
		vc.setName(WasJ2eeValidatorUtils.getUniqueName(source, attributeName));
		source.getConstraints().add(vc);
	}

	private void addBundleCapabilityRequirement(Unit module) {
		Requirement r = WasJ2eeValidatorUtils.getAvailableRequirement(module,
				CorePackage.Literals.BUNDLE_CAPABILITY);
		if (null != r) {
			// there is already an available requirement for linking
			return;
		}

		// add a BundleCapability requirement
		WasJ2eeValidatorUtils.addBundleCapabilityRequirement(module);
	}

	protected void resolveLinks(List<Unit> units, Unit host) {
		DeployValidatorService validator = DeployValidatorService.getDefaultValidatorService();
		for (Unit sourceUnit : units) {
			// prevent links from the host back to the hostee (and its member units)
			if (sourceUnit == host) {
				continue;
			}
			for (int k = 0; k < units.size(); k++) {
				Unit targetUnit = units.get(k);
				LinkDescriptor[] possibleLinks = validator.getPossibleLinks(sourceUnit, targetUnit,
						LinkType.DEPENDENCY_SET);
				createExactLinks(possibleLinks);
			}
		}
	}

	private void createExactLinks(LinkDescriptor[] possibleLinks) {
		for (int i = 0; i < possibleLinks.length; i++) {
			//Perfect matches only.
			if (possibleLinks[i].getLinkWeight() == LinkDescriptor.MAX_LINK_WEIGHT) {
				possibleLinks[i].create();
			}
		}
	}

//	private WasSecuritySubjectConstraint createOrModifyWasSecuritySubjectConstraint(
//			J2EESecurityRole role, String subjectName) {
//
//		WasSecuritySubjectConstraint constraint = null;
//		List<Constraint> constraints = ValidatorUtils.getConstraints(role,
//				WasPackage.Literals.WAS_SECURITY_SUBJECT_CONSTRAINT);
//		for (Iterator<Constraint> iter = constraints.iterator(); iter.hasNext();) {
//			WasSecuritySubjectConstraint aConstraint = (WasSecuritySubjectConstraint) iter.next();
//			if (aConstraint.getWasSecuritySubject().equals(subjectName)) {
//				constraint = aConstraint;
//			}
//		}
//
//		if (constraint == null) {
//			constraint = WasFactory.eINSTANCE.createWasSecuritySubjectConstraint();
//		}
//
//		constraint.setName(UnitUtil.generateUniqueName(role, role.getName()
//				+ "_" + WasSecuritySubjectConstraint.class.getName())); //$NON-NLS-1$
//		constraint.setDisplayName(WasSecuritySubjectConstraint.class.getSimpleName()
//				+ "(" + role.getName() + ")"); //$NON-NLS-1$ //$NON-NLS-2$
//		if (subjectName != null && !subjectName.equalsIgnoreCase(new String())) {
//			constraint.setWasSecuritySubject(subjectName);
//		}
//
//		if (constraint.getParent() == null) {
//			role.getConstraints().add(constraint);
//		}
//
//		return constraint;
//	}
//
//	private WasWarClassloaderPolicyConstraint createOrModifyWasWarClassloaderPolicyConstraint(
//			WebModule webModule) {
//
//		WasWarClassloaderPolicyConstraint constraint = null;
//		List<Constraint> constraints = ValidatorUtils.getConstraints(webModule,
//				WasPackage.Literals.WAS_WAR_CLASSLOADER_POLICY_CONSTRAINT);
//		for (Iterator<Constraint> iter = constraints.iterator(); iter.hasNext();) {
//			WasWarClassloaderPolicyConstraint aConstraint = (WasWarClassloaderPolicyConstraint) iter
//					.next();
//			constraint = aConstraint;
//		}
//
//		if (constraint == null) {
//			constraint = WasFactory.eINSTANCE.createWasWarClassloaderPolicyConstraint();
//		}
//
//		constraint.setName(UnitUtil.generateUniqueName(webModule,
//				WasWarClassloaderPolicyConstraint.class.getName()));
//		constraint.setDisplayName(WasWarClassloaderPolicyConstraint.class.getSimpleName()
//				+ "(" + webModule.getDisplayName() + ")"); //$NON-NLS-1$ //$NON-NLS-2$
//		constraint.setOrder(ClassloaderMode.PARENTFIRST_LITERAL);
//
//		if (constraint.getParent() == null) {
//			webModule.getConstraints().add(constraint);
//		}
//
//		return constraint;
//	}
//
//	private WasEarClassloaderPolicyConstraint createOrModifyWasEarClassloaderPolicyConstraint(
//			EarModule earModule) {
//
//		WasEarClassloaderPolicyConstraint constraint = null;
//		List<Constraint> constraints = ValidatorUtils.getConstraints(earModule,
//				WasPackage.Literals.WAS_EAR_CLASSLOADER_POLICY_CONSTRAINT);
//		for (Iterator<Constraint> iter = constraints.iterator(); iter.hasNext();) {
//			WasEarClassloaderPolicyConstraint aConstraint = (WasEarClassloaderPolicyConstraint) iter
//					.next();
//			constraint = aConstraint;
//		}
//
//		if (constraint == null) {
//			constraint = WasFactory.eINSTANCE.createWasEarClassloaderPolicyConstraint();
//		}
//
//		constraint.setName(UnitUtil.generateUniqueName(earModule,
//				WasEarClassloaderPolicyConstraint.class.getName()));
//		constraint.setDisplayName(WasEarClassloaderPolicyConstraint.class.getSimpleName()
//				+ "(" + earModule.getDisplayName() + ")"); //$NON-NLS-1$ //$NON-NLS-2$
//		// TODO add correct default value
//		constraint.setReloadInterval(15);
//		constraint.setReloadClasses(true);
//		constraint.setPolicy(ClassloaderPolicyType.MULTIPLE_LITERAL);
//		constraint.setOrder(ClassloaderMode.PARENTFIRST_LITERAL);
//
//		if (constraint.getParent() == null) {
//			earModule.getConstraints().add(constraint);
//		}
//
//		return constraint;
//	}
//
//	private WasModuleStartWeightConstraint createOrModifyWasModuleStartWeightConstraint(
//			DeployModelObject dmo) {
//
//		WasModuleStartWeightConstraint constraint = null;
//
//		if (J2eePackage.Literals.EJB_MODULE.isSuperTypeOf(dmo.getEObject().eClass())
//				|| J2eePackage.Literals.WEB_MODULE.isSuperTypeOf(dmo.getEObject().eClass())) {
//
//			List<Constraint> constraints = ValidatorUtils.getConstraints(dmo,
//					WasPackage.Literals.WAS_MODULE_START_WEIGHT_CONSTRAINT);
//			for (Iterator<Constraint> iter = constraints.iterator(); iter.hasNext();) {
//				WasModuleStartWeightConstraint aConstraint = (WasModuleStartWeightConstraint) iter
//						.next();
//				constraint = aConstraint;
//			}
//
//			if (constraint == null) {
//				constraint = WasFactory.eINSTANCE.createWasModuleStartWeightConstraint();
//			}
//
//			constraint.setName(UnitUtil.generateUniqueName(dmo, WasModuleStartWeightConstraint.class
//					.getName()));
//			constraint.setDisplayName(WasModuleStartWeightConstraint.class.getSimpleName()
//					+ "(" + dmo.getDisplayName() + ")"); //$NON-NLS-1$ //$NON-NLS-2$
//			constraint.setStartingWeight(0);
//
//			if (constraint.getParent() == null) {
//				dmo.getConstraints().add(constraint);
//			}
//		}
//
//		return constraint;
//	}
//
//	private List<Constraint> createOrModifyWasJNDIBindingConstraints(Unit unit,
//			IBindingsHelper bindingsHelper) {
//		List<Constraint> constraints = new ArrayList<Constraint>();
//
//		List ejbCapabilities = ValidatorUtils.getCapabilities(unit,
//				J2eePackage.Literals.ENTERPRISE_BEAN_SERVICE);
//		for (Iterator iter = ejbCapabilities.iterator(); iter.hasNext();) {
//			EnterpriseBeanService ejbService = (EnterpriseBeanService) iter.next();
//			String jndiName = bindingsHelper.getJNDIName(ejbService);
//			ejbService.setJndiName(jndiName);
//			WasJNDIBindingConstraint constraint = createOrModifyWasJNDIBindingConstraint(ejbService,
//					jndiName);
//			constraints.add(constraint);
//		}
//
//		List ejbRequirements = ValidatorUtils.getRequirements(unit,
//				J2eePackage.Literals.ENTERPRISE_BEAN_SERVICE);
//		for (Iterator iter = ejbRequirements.iterator(); iter.hasNext();) {
//			Reference ejbReference = (Reference) iter.next();
//			WasJNDIBindingConstraint constraint = createOrModifyWasJNDIBindingConstraint(ejbReference,
//					bindingsHelper.getJNDINameForRef(ejbReference));
//			constraints.add(constraint);
//		}
//
////		List datasourceCapabilities = ValidatorUtils.getCapabilities(unit,
////				J2eePackage.Literals.J2EE_DATASOURCE);
////		for (Iterator iter = datasourceCapabilities.iterator(); iter.hasNext();) {
////			J2EEDatasource datasource = (J2EEDatasource) iter.next();
////			WasJNDIBindingConstraint constraint = createOrModifyWasJNDIBindingConstraint(datasource,
////					bindingsHelper.);
////			constraints.add(constraint);
////		}
//
//		List datasourceRequirements = ValidatorUtils.getRequirements(unit,
//				J2eePackage.Literals.J2EE_DATASOURCE);
//		for (Iterator iter = datasourceRequirements.iterator(); iter.hasNext();) {
//			Requirement datasourceRequirement = (Requirement) iter.next();
//			WasJNDIBindingConstraint constraint = createOrModifyWasJNDIBindingConstraint(
//					datasourceRequirement, bindingsHelper.getJNDINameForRef(datasourceRequirement));
//			constraints.add(constraint);
//		}
//
//		List datasourceRequirements = ValidatorUtils.getRequirements(unit,
//				J2eePackage.Literals.J2EE_DATASOURCE);
//		for (Iterator iter = datasourceRequirements.iterator(); iter.hasNext();) {
//			Requirement datasourceRequirement = (Requirement) iter.next();
//			boolean usedForCmp = isUsedForCmp(datasourceRequirement);
//			String jndiName = new String();
//
//			if (usedForCmp) {
//				List<Capability> caps = ValidatorUtils.getCapabilities(unit,
//						J2eePackage.Literals.ENTITY_SERVICE);
//				if (caps.size() > 0) {
//					jndiName = bindingsHelper.getJNDINameForDefaultDataSource((EntityService) caps
//							.get(0));
//				}
//			} else {
//				jndiName = bindingsHelper.getJNDINameForRef(datasourceRequirement);
//			}
//
//			WasJNDIBindingConstraint constraint = createOrModifyWasJNDIBindingConstraint(
//					datasourceRequirement, jndiName);
//			constraints.add(constraint);
//		}
//
//		return constraints;
//	}
//
//	private WasJNDIBindingConstraint createOrModifyWasJNDIBindingConstraint(DeployModelObject dmo,
//			String jndiName) {
//
//		WasJNDIBindingConstraint constraint = null;
//
//		List<Constraint> constraints = ValidatorUtils.getConstraints(dmo,
//				WasPackage.Literals.WAS_JNDI_BINDING_CONSTRAINT);
//		for (Iterator<Constraint> iter = constraints.iterator(); iter.hasNext();) {
//			WasJNDIBindingConstraint aConstraint = (WasJNDIBindingConstraint) iter.next();
//			constraint = aConstraint;
//		}
//
//		if (constraint == null) {
//			constraint = WasFactory.eINSTANCE.createWasJNDIBindingConstraint();
//		}
//
//		constraint.setName(UnitUtil.generateUniqueName(dmo, WasJNDIBindingConstraint.class
//				.getSimpleName()));
//		constraint.setDisplayName(WasJNDIBindingConstraint.class.getSimpleName()
//				+ "(" + dmo.getDisplayName() + ")"); //$NON-NLS-1$ //$NON-NLS-2$
//		constraint.setJndiName(jndiName);
//
//		if (constraint.getParent() == null) {
//			dmo.getConstraints().add(constraint);
//		}
//
//		return constraint;
//	}
//
//	private boolean isUsedForCmp(Requirement req) {
//		if (J2eePackage.Literals.J2EE_DATASOURCE.isSuperTypeOf(req.getDmoEType())) {
//			for (Iterator exprIter = req.getExpressions().iterator(); exprIter.hasNext();) {
//				RequirementExpression expr = (RequirementExpression) exprIter.next();
//				if (J2eePackage.Literals.J2EE_DATASOURCE__USED_FOR_CMP.getName().equals(
//						expr.getAttributeName())) {
//					return true;
//				}
//			}
//		}
//
//		return false;
//	}
}
