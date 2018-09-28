/***************************************************************************************************
 * Copyright (c) 2003, 2008 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.internal.j2ee.validator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Reference;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.j2ee.EarModule;
import com.ibm.ccl.soa.deploy.j2ee.EnterpriseBeanService;
import com.ibm.ccl.soa.deploy.j2ee.EntityService;
import com.ibm.ccl.soa.deploy.j2ee.J2EESecurityRole;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.WebModule;
import com.ibm.ccl.soa.deploy.j2ee.bindings.IBindingsHelper;
import com.ibm.ccl.soa.deploy.was.ClassloaderMode;
import com.ibm.ccl.soa.deploy.was.ClassloaderPolicyType;
import com.ibm.ccl.soa.deploy.was.WasEarClassloaderPolicyConstraint;
import com.ibm.ccl.soa.deploy.was.WasFactory;
import com.ibm.ccl.soa.deploy.was.WasJNDIBindingConstraint;
import com.ibm.ccl.soa.deploy.was.WasModuleStartWeightConstraint;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSecuritySubjectConstraint;
import com.ibm.ccl.soa.deploy.was.WasWarClassloaderPolicyConstraint;

public class WasJ2eeConstraintUtils {

	public static void addSecuritySubjectConstraints(List<Unit> units, IBindingsHelper bindingsHelper) {
		// add security role constraints
		List<Capability> securityRoles = new ArrayList<Capability>();
		for (Iterator<Unit> iter = units.iterator(); iter.hasNext();) {
			securityRoles.addAll(ValidatorUtils.getCapabilities(iter.next(),
					J2eePackage.Literals.J2EE_SECURITY_ROLE));
		}

		for (int i = 0; i < securityRoles.size(); i++) {
			// String subject = WasDefaultSecuritySubjectEnum.ALL_AUTHENTICATED_LITERAL.toString();
			J2EESecurityRole securityRole = (J2EESecurityRole) securityRoles.get(i);
//			List<Constraint> constraints = ValidatorUtils.getConstraints(securityRole,
//					WasPackage.Literals.WAS_SECURITY_SUBJECT_CONSTRAINT);
//			securityRole.getConstraints().removeAll(constraints);
			List<String> subjects = bindingsHelper.getBindings(securityRole);
			for (Iterator<String> iter = subjects.iterator(); iter.hasNext();) {
				createOrModifyWasSecuritySubjectConstraint(securityRole, iter.next());
			}

			if (subjects.size() == 0) {
				createOrModifyWasSecuritySubjectConstraint(securityRole, new String());
			}
		}
	}

	public static void addSecuritySubjectConstraint(J2EESecurityRole securityRole,
			IBindingsHelper bindingsHelper) {
		List<String> subjects = bindingsHelper.getBindings(securityRole);
		for (Iterator<String> iter = subjects.iterator(); iter.hasNext();) {
			createOrModifyWasSecuritySubjectConstraint(securityRole, iter.next());
		}
	}

	public static void addClassloaderPolicyConstraints(List<Unit> units) {
		for (Iterator<Unit> iter = units.iterator(); iter.hasNext();) {
			Unit unit = iter.next();
			if (J2eePackage.Literals.WEB_MODULE.isSuperTypeOf(unit.getEObject().eClass())) {
				createOrModifyWasWarClassloaderPolicyConstraint((WebModule) unit);
			} else if (J2eePackage.Literals.EAR_MODULE.isSuperTypeOf(unit.getEObject().eClass())) {
				createOrModifyWasEarClassloaderPolicyConstraint((EarModule) unit);
			}
		}
	}

	public static void addStartWeightConstraints(List<Unit> units) {
		for (Iterator<Unit> iter = units.iterator(); iter.hasNext();) {
			Unit unit = iter.next();
			if (J2eePackage.Literals.EJB_MODULE.isSuperTypeOf(unit.getEObject().eClass())
					|| J2eePackage.Literals.WEB_MODULE.isSuperTypeOf(unit.getEObject().eClass())) {
				createOrModifyWasModuleStartWeightConstraint(unit);
			}
		}
	}

	public static void addJNDIBindingConstraints(List<Unit> units, IBindingsHelper bindingsHelper) {
		for (Iterator<Unit> iter = units.iterator(); iter.hasNext();) {
			Unit unit = iter.next();
			if (J2eePackage.Literals.EJB_MODULE.isSuperTypeOf(unit.getEObject().eClass())
					|| J2eePackage.Literals.WEB_MODULE.isSuperTypeOf(unit.getEObject().eClass())
					|| J2eePackage.Literals.EAR_MODULE.isSuperTypeOf(unit.getEObject().eClass())) {
				createOrModifyWasJNDIBindingConstraints(unit, bindingsHelper);
			}
		}
	}

	public static void addJNDIBindingConstraint(DeployModelObject object,
			IBindingsHelper bindingsHelper) {
		EClass objectType = object.getEObject().eClass();

		if (J2eePackage.Literals.ENTERPRISE_BEAN_SERVICE.isSuperTypeOf(objectType)) {
			EnterpriseBeanService ejbService = (EnterpriseBeanService) object;
			String jndiName = bindingsHelper.getJNDIName(ejbService);
			ejbService.setJndiName(jndiName);
			createOrModifyWasJNDIBindingConstraint(ejbService, jndiName);
		} else if (CorePackage.Literals.REFERENCE.isSuperTypeOf(objectType)
				&& J2eePackage.Literals.ENTERPRISE_BEAN_SERVICE.isSuperTypeOf(((Reference) object)
						.getDmoEType())) {
			Reference ejbReference = (Reference) object;
			createOrModifyWasJNDIBindingConstraint(ejbReference, bindingsHelper
					.getJNDINameForRequirement(ejbReference));
		} else if (CorePackage.Literals.REQUIREMENT.isSuperTypeOf(objectType)
				&& J2eePackage.Literals.J2EE_DATASOURCE.isSuperTypeOf(((Requirement) object)
						.getDmoEType())) {
			Requirement datasourceRequirement = (Requirement) object;
			createOrModifyWasJNDIBindingConstraint(datasourceRequirement, bindingsHelper
					.getJNDINameForRequirement(datasourceRequirement));

		}

	}

	private static WasSecuritySubjectConstraint createOrModifyWasSecuritySubjectConstraint(
			J2EESecurityRole role, String subjectName) {

		// don't add the constraints if the securityRole is not public
		if (role.getTopology() != role.getEditTopology()) {
			if (!role.getTopology().getConfigurationContract().isPublic(role)) {
				return null;
			}
		}

		WasSecuritySubjectConstraint constraint = null;
		List<Constraint> constraints = ValidatorUtils.getConstraints(role,
				WasPackage.Literals.WAS_SECURITY_SUBJECT_CONSTRAINT);
		for (Iterator<Constraint> iter = constraints.iterator(); iter.hasNext();) {
			WasSecuritySubjectConstraint aConstraint = (WasSecuritySubjectConstraint) iter.next();
			if (subjectName.equals(aConstraint.getWasSecuritySubject())) {
				constraint = aConstraint;
			}
		}

		if (constraint == null) {
			constraint = WasFactory.eINSTANCE.createWasSecuritySubjectConstraint();
		}

		constraint.setName(UnitUtil.generateUniqueName(role, role.getName()
				+ "_" + WasSecuritySubjectConstraint.class.getName())); //$NON-NLS-1$
		constraint.setDisplayName(WasSecuritySubjectConstraint.class.getSimpleName()
				+ "(" + role.getName() + ")"); //$NON-NLS-1$ //$NON-NLS-2$
		if (subjectName != null && !subjectName.equalsIgnoreCase(new String())) {
			constraint.setWasSecuritySubject(subjectName);
		}

		if (constraint.getParent() == null) {
			role.getConstraints().add(constraint);
		}

		return constraint;
	}

	private static WasWarClassloaderPolicyConstraint createOrModifyWasWarClassloaderPolicyConstraint(
			WebModule webModule) {

		// don't add the constraints if the module is not public
		if (webModule.getTopology() != webModule.getEditTopology()) {
			if (!webModule.getTopology().getConfigurationContract().isPublic(webModule)) {
				return null;
			}
		}

		WasWarClassloaderPolicyConstraint constraint = null;
		List<Constraint> constraints = ValidatorUtils.getConstraints(webModule,
				WasPackage.Literals.WAS_WAR_CLASSLOADER_POLICY_CONSTRAINT);
		for (Iterator<Constraint> iter = constraints.iterator(); iter.hasNext();) {
			WasWarClassloaderPolicyConstraint aConstraint = (WasWarClassloaderPolicyConstraint) iter
					.next();
			constraint = aConstraint;
		}

		if (constraint == null) {
			constraint = WasFactory.eINSTANCE.createWasWarClassloaderPolicyConstraint();
		}

		constraint.setName(UnitUtil.generateUniqueName(webModule,
				WasWarClassloaderPolicyConstraint.class.getName()));
		constraint.setDisplayName(WasWarClassloaderPolicyConstraint.class.getSimpleName()
				+ "(" + webModule.getDisplayName() + ")"); //$NON-NLS-1$ //$NON-NLS-2$
		constraint.setOrder(ClassloaderMode.PARENTFIRST_LITERAL);

		if (constraint.getParent() == null) {
			webModule.getConstraints().add(constraint);
		}

		return constraint;
	}

	private static WasEarClassloaderPolicyConstraint createOrModifyWasEarClassloaderPolicyConstraint(
			EarModule earModule) {

		// don't add the constraints if the module is not public
		if (earModule.getTopology() != earModule.getEditTopology()) {
			if (!earModule.getTopology().getConfigurationContract().isPublic(earModule)) {
				return null;
			}
		}

		WasEarClassloaderPolicyConstraint constraint = null;
		List<Constraint> constraints = ValidatorUtils.getConstraints(earModule,
				WasPackage.Literals.WAS_EAR_CLASSLOADER_POLICY_CONSTRAINT);
		for (Iterator<Constraint> iter = constraints.iterator(); iter.hasNext();) {
			WasEarClassloaderPolicyConstraint aConstraint = (WasEarClassloaderPolicyConstraint) iter
					.next();
			constraint = aConstraint;
		}

		if (constraint == null) {
			constraint = WasFactory.eINSTANCE.createWasEarClassloaderPolicyConstraint();
		}

		constraint.setName(UnitUtil.generateUniqueName(earModule,
				WasEarClassloaderPolicyConstraint.class.getName()));
		constraint.setDisplayName(WasEarClassloaderPolicyConstraint.class.getSimpleName()
				+ "(" + earModule.getDisplayName() + ")"); //$NON-NLS-1$ //$NON-NLS-2$
		// TODO add correct default value
		constraint.setReloadInterval(15);
		constraint.setReloadClasses(true);
		constraint.setPolicy(ClassloaderPolicyType.MULTIPLE_LITERAL);
		constraint.setOrder(ClassloaderMode.PARENTFIRST_LITERAL);

		if (constraint.getParent() == null) {
			earModule.getConstraints().add(constraint);
		}

		return constraint;
	}

	private static WasModuleStartWeightConstraint createOrModifyWasModuleStartWeightConstraint(
			DeployModelObject dmo) {

		// don't add the constraints if the module is not public
		if (dmo.getTopology() != dmo.getEditTopology()) {
			if (!dmo.getTopology().getConfigurationContract().isPublic(dmo)) {
				return null;
			}
		}

		WasModuleStartWeightConstraint constraint = null;

		if (J2eePackage.Literals.EJB_MODULE.isSuperTypeOf(dmo.getEObject().eClass())
				|| J2eePackage.Literals.WEB_MODULE.isSuperTypeOf(dmo.getEObject().eClass())) {

			List<Constraint> constraints = ValidatorUtils.getConstraints(dmo,
					WasPackage.Literals.WAS_MODULE_START_WEIGHT_CONSTRAINT);
			for (Iterator<Constraint> iter = constraints.iterator(); iter.hasNext();) {
				WasModuleStartWeightConstraint aConstraint = (WasModuleStartWeightConstraint) iter
						.next();
				constraint = aConstraint;
			}

			if (constraint == null) {
				constraint = WasFactory.eINSTANCE.createWasModuleStartWeightConstraint();
			}

			constraint.setName(UnitUtil.generateUniqueName(dmo, WasModuleStartWeightConstraint.class
					.getName()));
			constraint.setDisplayName(WasModuleStartWeightConstraint.class.getSimpleName()
					+ "(" + dmo.getDisplayName() + ")"); //$NON-NLS-1$ //$NON-NLS-2$
			constraint.setStartingWeight(0);

			if (constraint.getParent() == null) {
				dmo.getConstraints().add(constraint);
			}
		}

		return constraint;
	}

	private static List<Constraint> createOrModifyWasJNDIBindingConstraints(Unit unit,
			IBindingsHelper bindingsHelper) {
		List<Constraint> constraints = new ArrayList<Constraint>();

		List ejbCapabilities = ValidatorUtils.getCapabilities(unit,
				J2eePackage.Literals.ENTERPRISE_BEAN_SERVICE);
		for (Iterator iter = ejbCapabilities.iterator(); iter.hasNext();) {
			EnterpriseBeanService ejbService = (EnterpriseBeanService) iter.next();
			String jndiName = bindingsHelper.getJNDIName(ejbService);
			ejbService.setJndiName(jndiName);
			WasJNDIBindingConstraint constraint = createOrModifyWasJNDIBindingConstraint(ejbService,
					jndiName);
			constraints.add(constraint);
		}

		List ejbRequirements = ValidatorUtils.getRequirements(unit,
				J2eePackage.Literals.ENTERPRISE_BEAN_SERVICE);
		for (Iterator iter = ejbRequirements.iterator(); iter.hasNext();) {
			Reference ejbReference = (Reference) iter.next();
			WasJNDIBindingConstraint constraint = createOrModifyWasJNDIBindingConstraint(ejbReference,
					bindingsHelper.getJNDINameForRequirement(ejbReference));
			constraints.add(constraint);
		}

//		List datasourceCapabilities = ValidatorUtils.getCapabilities(unit,
//				J2eePackage.Literals.J2EE_DATASOURCE);
//		for (Iterator iter = datasourceCapabilities.iterator(); iter.hasNext();) {
//			J2EEDatasource datasource = (J2EEDatasource) iter.next();
//			WasJNDIBindingConstraint constraint = createOrModifyWasJNDIBindingConstraint(datasource,
//					bindingsHelper.);
//			constraints.add(constraint);
//		}

//		List datasourceRequirements = ValidatorUtils.getRequirements(unit,
//				J2eePackage.Literals.J2EE_DATASOURCE);
//		for (Iterator iter = datasourceRequirements.iterator(); iter.hasNext();) {
//			Requirement datasourceRequirement = (Requirement) iter.next();
//			WasJNDIBindingConstraint constraint = createOrModifyWasJNDIBindingConstraint(
//					datasourceRequirement, bindingsHelper.getJNDINameForRequirement(datasourceRequirement));
//			constraints.add(constraint);
//		}

		List datasourceRequirements = ValidatorUtils.getRequirements(unit,
				J2eePackage.Literals.J2EE_DATASOURCE);
		for (Iterator iter = datasourceRequirements.iterator(); iter.hasNext();) {
			Requirement datasourceRequirement = (Requirement) iter.next();
			boolean usedForCmp = isUsedForCmp(datasourceRequirement);
			String jndiName = new String();

			if (usedForCmp) {
				List<Capability> caps = ValidatorUtils.getCapabilities(unit,
						J2eePackage.Literals.ENTITY_SERVICE);
				if (caps.size() > 0) {
					jndiName = bindingsHelper.getJNDINameForDefaultDataSource((EntityService) caps
							.get(0));
				}
			} else {
				jndiName = bindingsHelper.getJNDINameForRequirement(datasourceRequirement);
			}

			WasJNDIBindingConstraint constraint = createOrModifyWasJNDIBindingConstraint(
					datasourceRequirement, jndiName);
			constraints.add(constraint);
		}

		return constraints;
	}

	private static WasJNDIBindingConstraint createOrModifyWasJNDIBindingConstraint(
			DeployModelObject dmo, String jndiName) {

		// don't add the constraints if the module is not public
		if (dmo.getTopology() != dmo.getEditTopology()) {
			if (!dmo.getTopology().getConfigurationContract().isPublic(dmo)) {
				return null;
			}
		}

		WasJNDIBindingConstraint constraint = null;

		List<Constraint> constraints = ValidatorUtils.getConstraints(dmo,
				WasPackage.Literals.WAS_JNDI_BINDING_CONSTRAINT);
		for (Iterator<Constraint> iter = constraints.iterator(); iter.hasNext();) {
			WasJNDIBindingConstraint aConstraint = (WasJNDIBindingConstraint) iter.next();
			constraint = aConstraint;
		}

		if (constraint == null) {
			constraint = WasFactory.eINSTANCE.createWasJNDIBindingConstraint();
		}

		constraint.setName(UnitUtil.generateUniqueName(dmo, WasJNDIBindingConstraint.class
				.getSimpleName()));
//		constraint.setDisplayName(WasJNDIBindingConstraint.class.getSimpleName()
//				+ "(" + dmo.getDisplayName() + ")"); //$NON-NLS-1$ //$NON-NLS-2$
		constraint.setJndiName(jndiName);

		if (constraint.getParent() == null) {
			dmo.getConstraints().add(constraint);
		}

		return constraint;
	}

	private static boolean isUsedForCmp(Requirement req) {
		if (J2eePackage.Literals.J2EE_DATASOURCE.isSuperTypeOf(req.getDmoEType())) {

			for (Constraint ec : ConstraintUtil.getConstraints(req,
					ConstraintPackage.Literals.EQUALS_CONSTRAINT)) {
				if (J2eePackage.Literals.J2EE_DATASOURCE__USED_FOR_CMP.getName().equals(
						((EqualsConstraint) ec).getAttributeName())) {
					return true;
				}
			}
// MK: 2/10/2008: Defect 5328 - Remove usage of Requirement Expressions from the WAS domain
//			for (Iterator exprIter = req.getExpressions().iterator(); exprIter.hasNext();) {
//				RequirementExpression expr = (RequirementExpression) exprIter.next();
//				if (J2eePackage.Literals.J2EE_DATASOURCE__USED_FOR_CMP.getName().equals(
//						expr.getAttributeName())) {
//					return true;
//				}
//			}
		}

		return false;
	}

}
