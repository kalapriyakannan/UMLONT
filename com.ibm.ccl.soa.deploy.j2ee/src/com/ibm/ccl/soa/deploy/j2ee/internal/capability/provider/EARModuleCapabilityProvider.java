/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.internal.capability.provider;

import java.util.ArrayList;

import org.eclipse.jst.j2ee.application.Application;

import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementUsage;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.internal.Messages;

public class EARModuleCapabilityProvider extends J2EEModuleCapabilityProvider {

	/**
	 * Return the array of requirements for an EARApplication
	 */
	public Object[] resolveRequirements(Object anObject) {
		if (anObject instanceof Application) {
			ArrayList reqList = new ArrayList();

			Application ear = (Application) anObject;

			int j2eeVersion = ear.getJ2EEVersionID();
			reqList.add(createJ2EEContainerReq(j2eeVersion));

			Requirement warCardinality = CoreFactory.eINSTANCE.createRequirement();
			warCardinality.setDmoEType(J2eePackage.Literals.WEB_MODULE);
			warCardinality.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
			warCardinality.setUse(RequirementUsage.REQUIRED_LITERAL);
			warCardinality.setName("ContainedWebComponents"); //$NON-NLS-1$
			warCardinality.setDisplayName(Messages.EARModuleCapabilityProvider_Web_Component_);
//			RequirementExpression warCardExpr = OutCardinality.createExpression(0, -1);
//			warCardExpr.setUse(RequirementExpressionUsage.OPTIONAL_LITERAL);
//			warCardinality.getExpressions().add(warCardExpr);
			warCardinality.getConstraints().add(createMemberConstraint(0, Integer.MAX_VALUE));
			reqList.add(warCardinality);

			Requirement ejbCardinality = CoreFactory.eINSTANCE.createRequirement();
			ejbCardinality.setDmoEType(J2eePackage.Literals.EJB_MODULE);
			ejbCardinality.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
			ejbCardinality.setUse(RequirementUsage.REQUIRED_LITERAL);
			ejbCardinality.setName("ContainedEjbComponents"); //$NON-NLS-1$
			ejbCardinality.setDisplayName(Messages.EARModuleCapabilityProvider_EJB_Component_);
//			RequirementExpression ejbCardExpr = OutCardinality.createExpression(0, -1);
//			ejbCardExpr.setUse(RequirementExpressionUsage.OPTIONAL_LITERAL);
//			ejbCardinality.getExpressions().add(ejbCardExpr);
			ejbCardinality.getConstraints().add(createMemberConstraint(0, Integer.MAX_VALUE));
			reqList.add(ejbCardinality);

			Requirement jcaCardinality = CoreFactory.eINSTANCE.createRequirement();
			jcaCardinality.setDmoEType(J2eePackage.Literals.JCA_MODULE);
			jcaCardinality.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
			jcaCardinality.setUse(RequirementUsage.REQUIRED_LITERAL);
			jcaCardinality.setName("ContainedJCAComponents"); //$NON-NLS-1$
			jcaCardinality
					.setDisplayName(Messages.EARModuleCapabilityProvider_JCA_Connector_Component_);
//			RequirementExpression jcaCardExpr = OutCardinality.createExpression(0, -1);
//			jcaCardExpr.setUse(RequirementExpressionUsage.OPTIONAL_LITERAL);
//			jcaCardinality.getExpressions().add(jcaCardExpr);
			jcaCardinality.getConstraints().add(createMemberConstraint(0, Integer.MAX_VALUE));
			reqList.add(jcaCardinality);

			Requirement jarCardinality = CoreFactory.eINSTANCE.createRequirement();
			jarCardinality.setDmoEType(J2eePackage.Literals.JAR_MODULE);
			jarCardinality.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
			jarCardinality.setUse(RequirementUsage.REQUIRED_LITERAL);
			jarCardinality.setName("ContainedUtilityJarComponents"); //$NON-NLS-1$
			jarCardinality.setDisplayName(Messages.EARModuleCapabilityProvider_Utility_Jar_Component_);
//			RequirementExpression jarCardExpr = OutCardinality.createExpression(0, -1);
//			jarCardExpr.setUse(RequirementExpressionUsage.OPTIONAL_LITERAL);
//			jarCardinality.getExpressions().add(jarCardExpr);
			jarCardinality.getConstraints().add(createMemberConstraint(0, Integer.MAX_VALUE));
			reqList.add(jarCardinality);

			Requirement appClientCardinality = CoreFactory.eINSTANCE.createRequirement();
			appClientCardinality.setDmoEType(J2eePackage.Literals.APP_CLIENT);
			appClientCardinality.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
			appClientCardinality.setUse(RequirementUsage.REQUIRED_LITERAL);
			appClientCardinality.setName("ContainedAppClientComponents"); //$NON-NLS-1$
			appClientCardinality
					.setDisplayName(Messages.EARModuleCapabilityProvider_Application_Client_Component_);
//			RequirementExpression appClientCardExpr = OutCardinality.createExpression(0, -1);
//			appClientCardExpr.setUse(RequirementExpressionUsage.OPTIONAL_LITERAL);
//			appClientCardinality.getExpressions().add(appClientCardExpr);
			appClientCardinality.getConstraints().add(createMemberConstraint(0, Integer.MAX_VALUE));
			reqList.add(appClientCardinality);

			return toReqArray(removeDuplicateRequirements(reqList));
		}

		return NO_REQS;
	}

	public Object[] resolveCapabilities(Object anObject) {
		return NO_CAPS;
	}

}
