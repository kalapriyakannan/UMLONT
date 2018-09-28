/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.validator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.validator.pattern.ConfigurationUnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.pattern.attribute.DeployAttributeStringNotEmptyValidator;
import com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.internal.validator.IJ2eeDomainValidators;

/**
 * {@link J2EEDatasource}
 */
public class J2EEDataSourceValidator extends ConfigurationUnitValidator {

	/**
	 * @param unitType
	 */
	public J2EEDataSourceValidator(EClass unitType) {
		super(unitType);

		this.addCapabilityTypeConstraint(J2eePackage.Literals.J2EE_DATASOURCE,
				CapabilityLinkTypes.DEPENDENCY_LITERAL, 1, 1);
		this.addRequirementTypeConstraint(J2eePackage.Literals.J2C_AUTHENTICATION_DATA_ENTRY,
				RequirementLinkTypes.DEPENDENCY_LITERAL, 0, 1);
		this.addRequirementTypeConstraint(J2eePackage.Literals.J2EE_SERVER,
				RequirementLinkTypes.HOSTING_LITERAL, 0, 1);

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IJ2eeDomainValidators.J2EE_DATA_SOURCE_DATASOURCE_NAME_NOT_EMPTY, J2eePackage.eINSTANCE
						.getJ2EEDatasource_DatasourceName(), IStatus.ERROR));

		addAttributeValidator(new DeployAttributeStringNotEmptyValidator(
				IJ2eeDomainValidators.J2EE_DATA_SOURCE_JNDI_NAME_NOT_EMPTY, J2eePackage.eINSTANCE
						.getJ2EEDatasource_JndiName(), IStatus.ERROR));
	}
}
