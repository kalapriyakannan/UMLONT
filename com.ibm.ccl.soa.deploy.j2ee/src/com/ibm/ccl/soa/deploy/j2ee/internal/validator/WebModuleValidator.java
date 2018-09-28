/***************************************************************************************************
 * Copyright (c) 2003, 2008 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.internal.validator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.validator.pattern.link.DependencyLinkLocalValidator;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.WebModule;

/**
 * Validates instances of the {@link WebModule} unit.
 */
public class WebModuleValidator extends J2eeModuleValidator {

	/**
	 * Construct a unit validator for the {@link WebModule} unit type.
	 */
	public WebModuleValidator() {
		this(J2eePackage.eINSTANCE.getWebModule());
	}

	/**
	 * Construct a unit validator for subtype of {@link WebModule}.
	 * 
	 * @param unitType
	 *           a subtype of {@link WebModule}.
	 */
	protected WebModuleValidator(EClass unitType) {
		super(unitType);
		assert J2eePackage.eINSTANCE.getWebModule().isSuperTypeOf(unitType);

//		addAttributeValidator(new DeployRequirementAttributeNotNullValidator(
//				IJ2eeDomainValidators.J2EE_WEB_MODULE_001, J2eePackage.eINSTANCE
//						.getJ2EEDatasource_JndiName(), IStatus.ERROR));
		addDependencyLinkValidator(new DependencyLinkLocalValidator(
				IJ2eeDomainValidators.J2EE_WEB_MODULE_002, J2eePackage.eINSTANCE.getJ2EEDatasource(),
				J2eePackage.eINSTANCE.getJ2EEServer(), IStatus.ERROR));

		/* Removing per bug 11884 */
		//this.addRequirementTypeConstraint(J2eePackage.Literals.J2EE_CONTAINER, RequirementLinkTypes.HOSTING_LITERAL, 1, Integer.MAX_VALUE);
		this.addRequirementTypeConstraint(J2eePackage.Literals.JSP_CONTAINER,
				RequirementLinkTypes.HOSTING_LITERAL, 0, Integer.MAX_VALUE);
		this.addRequirementTypeConstraint(J2eePackage.Literals.SERVLET_CONTAINER,
				RequirementLinkTypes.HOSTING_LITERAL, 0, Integer.MAX_VALUE);

		this.addRequirementTypeConstraint(J2eePackage.Literals.J2EE_SERVER,
				RequirementLinkTypes.HOSTING_LITERAL, 0, Integer.MAX_VALUE);
		this.addRequirementTypeConstraint(J2eePackage.Literals.JCA_CONTAINER,
				RequirementLinkTypes.HOSTING_LITERAL, 0, Integer.MAX_VALUE);

		this.addRequirementTypeConstraint(J2eePackage.Literals.J2EE_DATASOURCE,
				RequirementLinkTypes.DEPENDENCY_LITERAL, 0, Integer.MAX_VALUE);
		this.addRequirementTypeConstraint(J2eePackage.Literals.J2EE_RESOURCE_REQUIREMENT,
				RequirementLinkTypes.DEPENDENCY_LITERAL, 0, Integer.MAX_VALUE);
		this.addRequirementTypeConstraint(J2eePackage.Literals.J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT,
				RequirementLinkTypes.DEPENDENCY_LITERAL, 0, Integer.MAX_VALUE);
	}
}
