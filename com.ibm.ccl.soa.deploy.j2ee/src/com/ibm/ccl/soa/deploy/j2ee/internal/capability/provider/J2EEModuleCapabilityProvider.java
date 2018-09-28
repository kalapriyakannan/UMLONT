/***************************************************************************************************
 * Copyright (c) 2003, 2008 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.internal.capability.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jst.j2ee.common.ResourceRef;
import org.eclipse.jst.j2ee.common.SecurityRole;
import org.eclipse.jst.j2ee.common.SecurityRoleRef;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityProvider;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.Reference;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementUsage;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.MemberCardinalityConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.TypeConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.VersionConstraint;
import com.ibm.ccl.soa.deploy.database.DatabasePackage;
import com.ibm.ccl.soa.deploy.j2ee.EJBContainerVersion;
import com.ibm.ccl.soa.deploy.j2ee.J2EEContainerVersion;
import com.ibm.ccl.soa.deploy.j2ee.J2EESecurityRole;
import com.ibm.ccl.soa.deploy.j2ee.J2eeFactory;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.JCAContainerVersion;
import com.ibm.ccl.soa.deploy.j2ee.JSPContainerVersion;
import com.ibm.ccl.soa.deploy.j2ee.ServletContainerVersion;
import com.ibm.ccl.soa.deploy.j2ee.internal.provider.J2EEDeployUtils;
import com.ibm.ccl.soa.deploy.j2ee.internal.provider.J2EEVersionConstants;

public abstract class J2EEModuleCapabilityProvider extends CapabilityProvider {
	protected final String KEY_BASE_J2EE = "j2ee."; //$NON-NLS-1$
	protected final String KEY_BASE_EJB = "ejb."; //$NON-NLS-1$
	protected final String KEY_BASE_SERVLET = "servlet."; //$NON-NLS-1$
	protected final String KEY_BASE_JSP = "jsp."; //$NON-NLS-1$
	protected final String KEY_BASE_JCA = "jca."; //$NON-NLS-1$
	protected final String KEY_MANIFEST_CLASSPATH = "Class-Path"; //$NON-NLS-1$
	protected final String KEY_BASE_SECURITY = "security."; //$NON-NLS-1$

	/**
	 * For performance list are converted to []
	 * 
	 * @since 1.0
	 * @return Requirement[]
	 */

	protected Requirement[] toReqArray(Collection reqList) {
		if (reqList == null) {
			return null;
		}
		return (Requirement[]) reqList.toArray(new Requirement[reqList.size()]);

	}

	/**
	 * For performance list are converted to []
	 * 
	 * @since 1.0
	 * @return Capability[]
	 */

	protected Capability[] toCapArray(Collection capList) {
		if (capList == null) {
			return null;
		}
		return (Capability[]) capList.toArray(new Capability[capList.size()]);

	}

	protected Requirement createJ2EEContainerReq(int j2eeVersion) {
		Requirement j2eeContainerReq = CoreFactory.eINSTANCE.createRequirement();
		j2eeContainerReq.setDmoEType(J2eePackage.Literals.J2EE_CONTAINER);
		j2eeContainerReq.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		switch (j2eeVersion)
		{
		case J2EEVersionConstants.J2EE_1_2_ID:
//			j2eeContainerReq.getExpressions().add(
//					GreaterThanEquals.createExpression(
//							J2eePackage.Literals.J2EE_CONTAINER__CONTAINER_VERSION,
//							J2EEContainerVersion._12_LITERAL));

			j2eeContainerReq.getConstraints().add(
					createVersionConstraint(J2eePackage.Literals.J2EE_CONTAINER__CONTAINER_VERSION,
							J2EEContainerVersion._12_LITERAL.getLiteral() + "+")); //$NON-NLS-1$

			j2eeContainerReq.setName(J2EEDeployUtils.J2EE_CONTAINER_SERVICE_NAME_12);
			j2eeContainerReq.setDisplayName(j2eeContainerReq.getName());
			break;
		case J2EEVersionConstants.J2EE_1_3_ID:
//			j2eeContainerReq.getExpressions().add(
//					GreaterThanEquals.createExpression(
//							J2eePackage.Literals.J2EE_CONTAINER__CONTAINER_VERSION,
//							J2EEContainerVersion._13_LITERAL));

			j2eeContainerReq.getConstraints().add(
					createVersionConstraint(J2eePackage.Literals.J2EE_CONTAINER__CONTAINER_VERSION,
							J2EEContainerVersion._13_LITERAL.getLiteral() + "+")); //$NON-NLS-1$

			j2eeContainerReq.setName(J2EEDeployUtils.J2EE_CONTAINER_SERVICE_NAME_13);
			j2eeContainerReq.setDisplayName(j2eeContainerReq.getName());
			break;
		case J2EEVersionConstants.J2EE_1_4_ID:
		default:
//			j2eeContainerReq.getExpressions().add(
//					GreaterThanEquals.createExpression(
//							J2eePackage.Literals.J2EE_CONTAINER__CONTAINER_VERSION,
//							J2EEContainerVersion._14_LITERAL));

			j2eeContainerReq.getConstraints().add(
					createVersionConstraint(J2eePackage.Literals.J2EE_CONTAINER__CONTAINER_VERSION,
							J2EEContainerVersion._14_LITERAL.getLiteral() + "+")); //$NON-NLS-1$

			j2eeContainerReq.setName(J2EEDeployUtils.J2EE_CONTAINER_SERVICE_NAME_14);
			j2eeContainerReq.setDisplayName(j2eeContainerReq.getName());
			break;
		}
		return j2eeContainerReq;
	}

	protected Requirement createServletContainerReq(int servletVersion) {
		Requirement servletContainerReq = CoreFactory.eINSTANCE.createRequirement();
		servletContainerReq.setDmoEType(J2eePackage.Literals.SERVLET_CONTAINER);
		servletContainerReq.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		switch (servletVersion)
		{
		case J2EEVersionConstants.SERVLET_2_2:
//			servletContainerReq.getExpressions().add(
//					GreaterThanEquals.createExpression(
//							J2eePackage.Literals.SERVLET_CONTAINER__CONTAINER_VERSION,
//							ServletContainerVersion._22_LITERAL));

			servletContainerReq.getConstraints().add(
					createVersionConstraint(J2eePackage.Literals.SERVLET_CONTAINER__CONTAINER_VERSION,
							ServletContainerVersion._22_LITERAL.getLiteral() + "+")); //$NON-NLS-1$

			servletContainerReq.setName(J2EEDeployUtils.SERVLET_CONTAINER_SERVICE_NAME_22);
			servletContainerReq.setDisplayName(servletContainerReq.getName());
			break;
		case J2EEVersionConstants.SERVLET_2_3:
//			servletContainerReq.getExpressions().add(
//					GreaterThanEquals.createExpression(
//							J2eePackage.Literals.SERVLET_CONTAINER__CONTAINER_VERSION,
//							ServletContainerVersion._23_LITERAL));

			servletContainerReq.getConstraints().add(
					createVersionConstraint(J2eePackage.Literals.SERVLET_CONTAINER__CONTAINER_VERSION,
							ServletContainerVersion._23_LITERAL.getLiteral() + "+")); //$NON-NLS-1$

			servletContainerReq.setName(J2EEDeployUtils.SERVLET_CONTAINER_SERVICE_NAME_23);
			servletContainerReq.setDisplayName(servletContainerReq.getName());
			break;
		case J2EEVersionConstants.SERVLET_2_4:
		default:
//			servletContainerReq.getExpressions().add(
//					GreaterThanEquals.createExpression(
//							J2eePackage.Literals.SERVLET_CONTAINER__CONTAINER_VERSION,
//							ServletContainerVersion._24_LITERAL));

			servletContainerReq.getConstraints().add(
					createVersionConstraint(J2eePackage.Literals.SERVLET_CONTAINER__CONTAINER_VERSION,
							ServletContainerVersion._24_LITERAL.getLiteral() + "+")); //$NON-NLS-1$

			servletContainerReq.setName(J2EEDeployUtils.SERVLET_CONTAINER_SERVICE_NAME_24);
			servletContainerReq.setDisplayName(servletContainerReq.getName());
			break;
		}
		return servletContainerReq;
	}

	protected Requirement createJSPContainerReq(int jspVersion) {
		Requirement jspContainerReq = CoreFactory.eINSTANCE.createRequirement();
		jspContainerReq.setDmoEType(J2eePackage.Literals.JSP_CONTAINER);
		jspContainerReq.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		switch (jspVersion)
		{
		case J2EEVersionConstants.JSP_1_1_ID:
//			jspContainerReq.getExpressions().add(
//					GreaterThanEquals.createExpression(
//							J2eePackage.Literals.JSP_CONTAINER__CONTAINER_VERSION,
//							JSPContainerVersion._11_LITERAL));

			jspContainerReq.getConstraints().add(
					createVersionConstraint(J2eePackage.Literals.JSP_CONTAINER__CONTAINER_VERSION,
							JSPContainerVersion._11_LITERAL.getLiteral() + "+")); //$NON-NLS-1$

			jspContainerReq.setName(J2EEDeployUtils.JSP_CONTAINER_SERVICE_NAME_11);
			jspContainerReq.setDisplayName(jspContainerReq.getName());
			break;
		case J2EEVersionConstants.JSP_1_2_ID:
//			jspContainerReq.getExpressions().add(
//					GreaterThanEquals.createExpression(
//							J2eePackage.Literals.JSP_CONTAINER__CONTAINER_VERSION,
//							JSPContainerVersion._12_LITERAL));

			jspContainerReq.getConstraints().add(
					createVersionConstraint(J2eePackage.Literals.JSP_CONTAINER__CONTAINER_VERSION,
							JSPContainerVersion._12_LITERAL.getLiteral() + "+")); //$NON-NLS-1$

			jspContainerReq.setName(J2EEDeployUtils.JSP_CONTAINER_SERVICE_NAME_12);
			jspContainerReq.setDisplayName(jspContainerReq.getName());
			break;
		case J2EEVersionConstants.JSP_2_0_ID:
		default:
//			jspContainerReq.getExpressions().add(
//					GreaterThanEquals.createExpression(
//							J2eePackage.Literals.JSP_CONTAINER__CONTAINER_VERSION,
//							JSPContainerVersion._20_LITERAL));

			jspContainerReq.getConstraints().add(
					createVersionConstraint(J2eePackage.Literals.JSP_CONTAINER__CONTAINER_VERSION,
							JSPContainerVersion._20_LITERAL.getLiteral() + "+")); //$NON-NLS-1$

			jspContainerReq.setName(J2EEDeployUtils.JSP_CONTAINER_SERVICE_NAME_20);
			jspContainerReq.setDisplayName(jspContainerReq.getName());
			break;
		}
		return jspContainerReq;
	}

	protected Requirement createEJBContainerReq(int ejbVersion) {
		Requirement ejbContainerReq = CoreFactory.eINSTANCE.createRequirement();
		ejbContainerReq.setDmoEType(J2eePackage.Literals.EJB_CONTAINER);
		ejbContainerReq.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		switch (ejbVersion)
		{
		case J2EEVersionConstants.EJB_1_1_ID:
//			ejbContainerReq.getExpressions().add(
//					GreaterThanEquals.createExpression(
//							J2eePackage.Literals.EJB_CONTAINER__CONTAINER_VERSION,
//							EJBContainerVersion._11_LITERAL));

			ejbContainerReq.getConstraints().add(
					createVersionConstraint(J2eePackage.Literals.EJB_CONTAINER__CONTAINER_VERSION,
							EJBContainerVersion._11_LITERAL.getLiteral() + "+")); //$NON-NLS-1$

			ejbContainerReq.setName(J2EEDeployUtils.EJB_CONTAINER_SERVICE_NAME_11);
			ejbContainerReq.setDisplayName(ejbContainerReq.getName());
			break;
		case J2EEVersionConstants.EJB_2_0_ID:
//			ejbContainerReq.getExpressions().add(
//					GreaterThanEquals.createExpression(
//							J2eePackage.Literals.EJB_CONTAINER__CONTAINER_VERSION,
//							EJBContainerVersion._20_LITERAL));

			ejbContainerReq.getConstraints().add(
					createVersionConstraint(J2eePackage.Literals.EJB_CONTAINER__CONTAINER_VERSION,
							EJBContainerVersion._20_LITERAL.getLiteral() + "+")); //$NON-NLS-1$

			ejbContainerReq.setName(J2EEDeployUtils.EJB_CONTAINER_SERVICE_NAME_20);
			ejbContainerReq.setDisplayName(ejbContainerReq.getName());
			break;
		case J2EEVersionConstants.EJB_2_1_ID:
		default:
//			ejbContainerReq.getExpressions().add(
//					GreaterThanEquals.createExpression(
//							J2eePackage.Literals.EJB_CONTAINER__CONTAINER_VERSION,
//							EJBContainerVersion._21_LITERAL));

			ejbContainerReq.getConstraints().add(
					createVersionConstraint(J2eePackage.Literals.EJB_CONTAINER__CONTAINER_VERSION,
							EJBContainerVersion._21_LITERAL.getLiteral() + "+")); //$NON-NLS-1$

			ejbContainerReq.setName(J2EEDeployUtils.EJB_CONTAINER_SERVICE_NAME_21);
			ejbContainerReq.setDisplayName(ejbContainerReq.getName());
			break;
		}
		return ejbContainerReq;
	}

	protected Requirement createJCAContainerReq(int jcaVersion) {
		Requirement jcaContainerReq = CoreFactory.eINSTANCE.createRequirement();
		jcaContainerReq.setDmoEType(J2eePackage.Literals.JCA_CONTAINER);
		jcaContainerReq.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
		switch (jcaVersion)
		{
		case J2EEVersionConstants.JCA_1_0_ID:
//			jcaContainerReq.getExpressions().add(
//					GreaterThanEquals.createExpression(
//							J2eePackage.Literals.JCA_CONTAINER__CONTAINER_VERSION,
//							JCAContainerVersion._10_LITERAL));

			jcaContainerReq.getConstraints().add(
					createVersionConstraint(J2eePackage.Literals.JCA_CONTAINER__CONTAINER_VERSION,
							JCAContainerVersion._10_LITERAL.getLiteral() + "+")); //$NON-NLS-1$

			jcaContainerReq.setName(J2EEDeployUtils.JCA_CONTAINER_SERVICE_NAME_10);
			jcaContainerReq.setDisplayName(jcaContainerReq.getName());
			break;
		case J2EEVersionConstants.JCA_1_5_ID:
		default:
//			jcaContainerReq.getExpressions().add(
//					GreaterThanEquals.createExpression(
//							J2eePackage.Literals.JCA_CONTAINER__CONTAINER_VERSION,
//							JCAContainerVersion._15_LITERAL));

			jcaContainerReq.getConstraints().add(
					createVersionConstraint(J2eePackage.Literals.JCA_CONTAINER__CONTAINER_VERSION,
							JCAContainerVersion._15_LITERAL.getLiteral() + "+")); //$NON-NLS-1$

			jcaContainerReq.setName(J2EEDeployUtils.JCA_CONTAINER_SERVICE_NAME_15);
			jcaContainerReq.setDisplayName(jcaContainerReq.getName());
			break;
		}
		return jcaContainerReq;
	}

	// TODO revisit in C5
	protected boolean checkForSQLType(ResourceRef ref) {
		return ref.getType() != null && ref.getType().equals("javax.sql.DataSource"); //$NON-NLS-1$
	}

	protected List createDataSourceRequirement(Unit aUnit, String name, String jndiName,
			boolean isForCMP) {
		List requirements = new ArrayList();

		// First create the datasource requirement
		Requirement dataSourceReq = CoreFactory.eINSTANCE.createRequirement();
		dataSourceReq.setDmoEType(J2eePackage.Literals.J2EE_DATASOURCE);
		dataSourceReq.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
		dataSourceReq.setName(name);
		dataSourceReq.setDisplayName(name);
//		dataSourceReq.getExpressions().add(
//				Equals.createExpression(J2eePackage.Literals.J2EE_DATASOURCE__JNDI_NAME, jndiName));
		if (jndiName != null) {
			dataSourceReq.getConstraints().add(
					createEqualsConstraint(J2eePackage.Literals.J2EE_DATASOURCE__JNDI_NAME, jndiName));
		}
		if (isForCMP) {
//			dataSourceReq.getExpressions().add(
//					Equals.createExpression(J2eePackage.Literals.J2EE_DATASOURCE__USED_FOR_CMP,
//							Boolean.TRUE));
			dataSourceReq.getConstraints().add(
					createEqualsConstraint(J2eePackage.Literals.J2EE_DATASOURCE__USED_FOR_CMP,
							Boolean.TRUE.toString()));
		}
		requirements.add(dataSourceReq);

		// Next create a matching logical database definition reference
		Requirement databaseDefinition = createLogicalDatabaseDefinitionReference(aUnit, name);
		requirements.add(databaseDefinition);

		return requirements;
	}

	// TODO revisit in C5
	protected List createDataSourceReq(Unit aUnit, String name, String jndiName) {
		return createDataSourceRequirement(aUnit, fixupName(name), jndiName, false);
	}

	// TODO revisit in C5
	protected List createDataSourceReq(Unit aUnit, ResourceRef ref, String jndiName) {
		return createDataSourceReq(aUnit, fixupName(ref.getName()), jndiName);
	}

	private Reference createLogicalDatabaseDefinitionReference(Unit aUnit, String refName) {
		String fixedReferenceName = fixupName(refName);
		Reference reference = CoreFactory.eINSTANCE.createReference();
		String name = null;
		if (fixedReferenceName.indexOf('/') > -1) {
			name = fixedReferenceName.replace('/', '_');
		}
		reference.setName(name);
		reference.setDisplayName(refName + "_dbref"); //$NON-NLS-1$
		reference.setDmoEType(DatabasePackage.Literals.DATABASE_DEFINITION);
		reference.setUse(RequirementUsage.OPTIONAL_LITERAL);
		return reference;
	}

	protected Requirement createSecurityRoleRequirement(SecurityRoleRef securityRef) {
		Requirement securityReq = CoreFactory.eINSTANCE.createRequirement();
		securityReq.setDmoEType(J2eePackage.Literals.J2EE_SECURITY_ROLE);
		securityReq.setName(securityRef.getName().replace('/', '_'));
		securityReq.setDisplayName(securityReq.getName());
		securityReq.setDescription(securityRef.getDescription());
//		securityReq.getExpressions().add(
//				Equals.createExpression(J2eePackage.Literals.J2EE_SECURITY_ROLE__ROLE, securityRef
//						.getLink()));
		securityReq.getConstraints().add(
				createEqualsConstraint(J2eePackage.Literals.J2EE_SECURITY_ROLE__ROLE, securityRef
						.getLink()));

		return securityReq;
	}

	protected Capability createSecurityRoleCapability(SecurityRole securityRole) {
		J2EESecurityRole role = J2eeFactory.eINSTANCE.createJ2EESecurityRole();
		role.setName(securityRole.getRoleName().replace('/', '_'));
		role.setRole(securityRole.getRoleName());
		role.setDescription(securityRole.getDescription());
		return role;
	}

	protected Constraint createMemberConstraint(int minValue, int maxValue) {
		MemberCardinalityConstraint membership = ConstraintFactory.eINSTANCE
				.createMemberCardinalityConstraint();
		membership.setName("AllowedNumberOfMembers"); //$NON-NLS-1$
		membership.setDisplayName(membership.getName());
		membership.setMinValue(Integer.toString(minValue));
		membership.setMaxValue(Integer.toString(maxValue));
		return membership;
	}

	protected Constraint createEqualsConstraint(EAttribute attribute, String value) {
		EqualsConstraint constraint = ConstraintFactory.eINSTANCE.createEqualsConstraint();
		constraint.setName(attribute.getName() + "MustEqual"); //$NON-NLS-1$
		constraint.setDisplayName(constraint.getName());
		constraint.setAttributeName(attribute.getName());
		constraint.setValue(value);
		return constraint;
	}

	protected Constraint createVersionConstraint(EAttribute attribute, String value) {
		VersionConstraint version = ConstraintFactory.eINSTANCE.createVersionConstraint();
		version.setName("VersionSpecification"); //$NON-NLS-1$
		version.setDisplayName(version.getName());
		version.setAttributeName(attribute.getName());
		version.setValue(value);
		return version;
	}

	protected String fixupName(String name) {
		if (name == null) {
			return null;
		}

		char[] chars = name.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			if (!Character.isLetter(chars[i]) && !Character.isDigit(chars[i])
					&& !Character.isWhitespace(chars[i]) && chars[i] != '_') {
				chars[i] = '_';
			}
		}
		return new String(chars);
	}

	protected String removeFileNameExtension(String name) {
		if (name == null) {
			return null;
		}

		int index = name.lastIndexOf('.');
		if (index > 0) {
			return name.substring(0, index);
		}
		return name;
	}

	protected Collection removeDuplicateRequirements(List reqList) {
		Map newReqs = new HashMap();

		for (int i = 0; i < reqList.size(); i++) {
			Requirement req = (Requirement) reqList.get(i);
			EClass capType = req.getDmoEType();
			if (!newReqs.containsKey(capType)) {
				List reqs = new ArrayList();
				reqs.add(req);
				newReqs.put(capType, reqs);
			} else {
				List reqs = (List) newReqs.get(capType);
				boolean addReq = true;
				for (int j = 0; j < reqs.size(); j++) {
					Requirement existingReq = (Requirement) reqs.get(j);
					if (areEquivalent(req, existingReq)) {
						addReq = false;
						break;
					}
//					// TODO handle multiple expressions
//					RequirementExpression existExp = (RequirementExpression) existingReq
//							.getExpressions().get(0);
//					RequirementExpression exp = (RequirementExpression) req.getExpressions().get(0);
//					if (exp.getValue().equals(existExp.getValue())) {
//						addReq = false;
//						break;
//					}
				}
				if (addReq) {
					reqs.add(req);
					newReqs.put(capType, reqs);
				}
			}
		}

		Iterator iter = newReqs.values().iterator();
		List newReqList = new ArrayList();
		while (iter.hasNext()) {
			List reqs = (List) iter.next();
			newReqList.addAll(reqs);
		}

		return newReqList;
	}

	/**
	 * <p>
	 * This method tests the equivalency of two respective Requirements. This method can accept null
	 * parameters. The properties of the {@link Requirement}s tested for equivalency are as follows:
	 * </p>
	 * 
	 * <p>
	 * What properties are tested for equality
	 * </p>
	 * <ul>
	 * <li>{@link Requirement#getClass()}
	 * <li>{@link Requirement#getDmoEType()}
	 * <li>{@link Requirement#getLinkType()}
	 * <li>{@link Requirement#getUse()}
	 * <li>{@link Requirement#getConstraints()} ( Note, size of list must match and each expression
	 * must be equivalent {@link #areEquivalent(Constraint, Constraint)}
	 * </ul>
	 * 
	 * @param aReq
	 *           a requirement to test
	 * @param bReq
	 *           a requirement to test
	 * @return true if all the properties listed above of the two {@link Requirement}s are equal
	 *         using the equals() method except where noted for the collection of {@link Constraint}s.
	 */
	private static boolean areEquivalent(Requirement aReq, Requirement bReq) {
		if (aReq == bReq) {
			return true;
		}
		if (bReq == null) {
			return false;
		}
		if (aReq.getClass() != bReq.getClass()) {
			return false;
		}
		if (aReq.getDmoEType() == null) {
			if (bReq.getDmoEType() != null) {
				return false;
			}
		} else if (!aReq.getDmoEType().equals(bReq.getDmoEType())) {
			return false;
		}
		if (aReq.getDmoEType() == null) {
			if (bReq.getDmoEType() != null) {
				return false;
			}
		} else if (!aReq.getDmoEType().equals(bReq.getDmoEType())) {
			return false;
		}
		if (aReq.getLinkType() == null) {
			if (bReq.getLinkType() != null) {
				return false;
			}
		} else if (!aReq.getLinkType().equals(bReq.getLinkType())) {
			return false;
		}
		if (aReq.getUse() == null) {
			if (bReq.getUse() != null) {
				return false;
			}
		} else if (!aReq.getUse().equals(bReq.getUse())) {
			return false;
		}
		if (aReq.getConstraints() == null) {
			if (bReq.getConstraints() != null) {
				return false;
			}
		} else {
			if (!areEquivalent(aReq.getConstraints(), bReq.getConstraints())) {
				return false;
			}
		}

		return true;
	}

	/**
	 * This method tests the equivalency of two lists of constraints. It will return false if there
	 * is uncertainty about the equivalence.
	 * 
	 * @param aConstraintList
	 * @param bConstraintList
	 * @return
	 */
	private static boolean areEquivalent(List<Constraint> aConstraintList,
			List<Constraint> bConstraintList) {
		if (aConstraintList.size() != bConstraintList.size()) {
			return false;
		}
		for (Constraint aConstraint : aConstraintList) {
			boolean foundMatch = false;
			for (Constraint bConstraint : bConstraintList) {
				if (areEquivalent(aConstraint, bConstraint)) {
					foundMatch = true;
					break;
				}
			}
			if (!foundMatch) {
				return false;
			}
		}
		for (Constraint bConstraint : bConstraintList) {
			boolean foundMatch = false;
			for (Constraint aConstraint : aConstraintList) {
				if (areEquivalent(bConstraint, aConstraint)) {
					foundMatch = true;
					break;
				}
			}
			if (!foundMatch) {
				return false;
			}
		}
		return true;
	}

	/**
	 * This method tests the equivalency of two constraints. It will delegate to the TypeConstraint
	 * or RequirementExpression comparator as required, else it will do generic comparison.
	 * 
	 * @param aConstraint
	 * @param bConstraint
	 * @return
	 */
	private static boolean areEquivalent(Constraint aConstraint, Constraint bConstraint) {
		// Delegate if known comparator
		if (aConstraint instanceof TypeConstraint && bConstraint instanceof TypeConstraint) {
			return areEquivalent((TypeConstraint) aConstraint, (TypeConstraint) bConstraint);
		}
		// No comparator to delegate to - do generic comparison.
		if (!areEquivalent(aConstraint.getConstraints(), bConstraint.getConstraints())) {
			return false;
		}

		return aConstraint.equals(bConstraint);
	}

	/**
	 * <p>
	 * This method tests the equivalency of two respective TypeConstraints. This method can accept
	 * null parameters. The properties of the {@link TypeConstraint}s that are tested for
	 * equivalency are as follows:
	 * </p>
	 * 
	 * TODO core constraints should implement equals
	 * 
	 * <p>
	 * What properties are tested for equivalency.
	 * </p>
	 * <ul>
	 * <li>{@link TypeConstraint#getClass()}
	 * <li>{@link TypeConstraint#getDmoType()}
	 * <li>{@link TypeConstraint#getConstraints()}
	 * </ul>
	 * 
	 * @param aTypeConstraint
	 *           a {@link TypeConstraint} to test
	 * @param bTypeConstraint
	 *           a {@link TypeConstraint} to test
	 * @return true if the properties listed above are equal between the two {@link TypeConstraint}s
	 */
	private static boolean areEquivalent(TypeConstraint aTypeConstraint,
			TypeConstraint bTypeConstraint) {
		if (aTypeConstraint == bTypeConstraint) {
			return true;
		}
		if (aTypeConstraint == null) {
			return false;
		}
		if (aTypeConstraint.getClass() != bTypeConstraint.getClass()) {
			return false;
		}
		if (aTypeConstraint.equals(bTypeConstraint)) {
			return true;
		}
		if (aTypeConstraint.getDmoEType() != null && aTypeConstraint.getDmoEType() == null) {
			return false;
		}
		if (aTypeConstraint.getDmoEType() == null && aTypeConstraint.getDmoEType() != null) {
			return false;
		}
		if (aTypeConstraint.getDmoEType() != null && aTypeConstraint.getDmoEType() != null) {
			if (!aTypeConstraint.getDmoEType().equals(bTypeConstraint.getDmoEType())) {
				return false;
			}
		}
		if (!areEquivalent(aTypeConstraint.getConstraints(), bTypeConstraint.getConstraints())) {
			return false;
		}

		return true;
	}

}
