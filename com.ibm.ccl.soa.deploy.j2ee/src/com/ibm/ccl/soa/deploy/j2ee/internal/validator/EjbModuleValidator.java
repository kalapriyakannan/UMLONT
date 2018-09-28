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
import com.ibm.ccl.soa.deploy.j2ee.EjbModule;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;

/**
 * Validates {@link EjbModule}.
 * 
 * <ul>
 * <li> {@link IJ2eeDomainValidators#J2EE_EJB_MODULE_001}
 * </ul>
 */
public class EjbModuleValidator extends J2eeModuleValidator {
	/**
	 * Create a validator for {@link EjbModule} unit types.
	 */
	public EjbModuleValidator() {
		this(J2eePackage.eINSTANCE.getEjbModule());
	}

	/**
	 * Create a validator for subtypes of {@link EjbModule}.
	 * 
	 * @param unitType
	 *           the type of unit that is validated (subtype of {@link EjbModule}).
	 */
	public EjbModuleValidator(EClass unitType) {
		super(unitType);
		assert J2eePackage.eINSTANCE.getEjbModule().isSuperTypeOf(unitType);

//		addAttributeValidator(new DeployRequirementAttributeNotNullValidator(
//				IJ2eeDomainValidators.J2EE_EJB_MODULE_001,
//				J2eePackage.Literals.J2EE_DATASOURCE__JNDI_NAME, IStatus.ERROR));
		addDependencyLinkValidator(new DependencyLinkLocalValidator(
				IJ2eeDomainValidators.J2EE_EJB_MODULE_002, J2eePackage.eINSTANCE.getJ2EEDatasource(),
				J2eePackage.eINSTANCE.getJ2EEServer(), IStatus.ERROR));

		this.addRequirementTypeConstraint(J2eePackage.Literals.J2EE_CONTAINER,
				RequirementLinkTypes.HOSTING_LITERAL, 1, Integer.MAX_VALUE);
		this.addRequirementTypeConstraint(J2eePackage.Literals.EJB_CONTAINER,
				RequirementLinkTypes.HOSTING_LITERAL, 0, Integer.MAX_VALUE);
		this.addRequirementTypeConstraint(J2eePackage.Literals.JCA_CONTAINER,
				RequirementLinkTypes.HOSTING_LITERAL, 0, Integer.MAX_VALUE);
		this.addRequirementTypeConstraint(J2eePackage.Literals.J2EE_SERVER,
				RequirementLinkTypes.HOSTING_LITERAL, 0, Integer.MAX_VALUE);

		this.addRequirementTypeConstraint(J2eePackage.Literals.J2EE_DATASOURCE,
				RequirementLinkTypes.DEPENDENCY_LITERAL, 0, Integer.MAX_VALUE);
		this.addRequirementTypeConstraint(J2eePackage.Literals.J2EE_RESOURCE_REQUIREMENT,
				RequirementLinkTypes.DEPENDENCY_LITERAL, 0, Integer.MAX_VALUE);
		this.addRequirementTypeConstraint(J2eePackage.Literals.J2EE_RESOURCE_ENVIRONMENT_REQUIREMENT,
				RequirementLinkTypes.DEPENDENCY_LITERAL, 0, Integer.MAX_VALUE);
	}
}
