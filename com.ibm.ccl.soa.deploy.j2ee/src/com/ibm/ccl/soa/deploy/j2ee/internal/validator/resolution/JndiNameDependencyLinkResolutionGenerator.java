/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.internal.validator.resolution;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.constraint.AttributeValueConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.pattern.DeploySetAttributeResolution;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;

/**
 * Resolution generator for dependency links mismatched in the {@link J2EEDatasource#getJndiName()}
 * attribute.
 */
public class JndiNameDependencyLinkResolutionGenerator extends DeployResolutionGenerator {

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#getResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		if (!hasResolutions(context)) {
			return EMPTY_RESOLUTION_ARRAY;
		}
		IDeployStatus status = context.getDeployStatus();
		DependencyLink link = (DependencyLink) status.getDeployObject();
		Object expectedValue = ((DependencyLink) status.getDeployObject()).getSource().getExpression(
				J2eePackage.eINSTANCE.getJ2EEDatasource_JndiName().getName()).getValue();
		String attributeName = J2eePackage.eINSTANCE.getJ2EEDatasource_JndiName().getName();
		String message = NLS.bind(DeployCoreMessages.Resolution_set_attribute_0_to_value_1,
				attributeName, expectedValue);
		return new IDeployResolution[] { new DeploySetAttributeResolution(context, this,
				attributeName, expectedValue, message, link.getTarget()) };
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator#hasResolutions(com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext)
	 */
	public boolean hasResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();
		if (!(status.getDeployObject() instanceof DependencyLink)) {
			return false;
		}
		DependencyLink link = (DependencyLink) status.getDeployObject();
		if (!(link.getTarget() instanceof J2EEDatasource)) {
			return false;
		}
		if (link.getSource() == null) {
			return false;
		}
		Requirement req = link.getSource();
//		RequirementExpression expr = req.getExpression(J2eePackage.eINSTANCE
//				.getJ2EEDatasource_JndiName().getName());
		EqualsConstraint constraint = (EqualsConstraint) findAttributeValueConstraint(req
				.getConstraints(), ConstraintPackage.Literals.EQUALS_CONSTRAINT,
				J2eePackage.Literals.J2EE_DATASOURCE__JNDI_NAME);
		if (constraint == null || constraint.getValue() == null) {
			return false;
		}

		return true;
	}

	private AttributeValueConstraint findAttributeValueConstraint(List<Constraint> constraints,
			EClass constraintType, EAttribute attribute) {
		for (Iterator<Constraint> iter = constraints.iterator(); iter.hasNext();) {
			Constraint constraint = iter.next();
			if (constraintType.isSuperTypeOf(constraint.getEObject().eClass())) {
				if (ConstraintPackage.Literals.ATTRIBUTE_VALUE_CONSTRAINT.isSuperTypeOf(constraint
						.getEObject().eClass())) {
					AttributeValueConstraint attrConstraint = (AttributeValueConstraint) constraint;
					if (attrConstraint.getAttributeName().equals(attribute.getName())) {
						return attrConstraint;
					}
				}
			}
		}

		return null;
	}
}
