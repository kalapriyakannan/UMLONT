/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.was.j2ee.validator.resolution;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Reference;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDeployStatus;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;
import com.ibm.ccl.soa.deploy.was.internal.validator.util.WasValidationUtil;
import com.ibm.ccl.soa.deploy.was.validator.IWASProblemType;

/**
 * Generator for resolution to add a JNDI binding
 */
public class AddWasJNDIBindingConstraintResolutionGenerator extends DeployResolutionGenerator {

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		// sanity check
		if (!hasResolutions(context)) {
			return new IDeployResolution[0];
		}

		DeployModelObject dmo = context.getDeployStatus().getDeployObject();

		String description;
		if (CorePackage.Literals.CAPABILITY.isSuperTypeOf(dmo.getEObject().eClass())) {
			Capability c = (Capability) dmo;
			description = DeployNLS.bind(
					WasDomainMessages.Resolution_add_WasJNDIBindingConstraint_on_0, new Object[] { c
							.getCaptionProvider().titleWithContext(c) });
		} else if (CorePackage.Literals.REQUIREMENT.isSuperTypeOf(dmo.getEObject().eClass())) {
			Requirement r = (Requirement) dmo;
			description = DeployNLS.bind(
					WasDomainMessages.Resolution_add_WasJNDIBindingConstraint_on_0, new Object[] { r
							.getDisplayName() });
		} else {
			description = DeployNLS.bind(
					WasDomainMessages.Resolution_add_WasJNDIBindingConstraint_on_0, new Object[] { dmo
							.getDisplayName() });
		}

		WasDeployStatus status = (WasDeployStatus) context.getDeployStatus();
		Unit host = (Unit) status.getAttribute(WasValidationUtil.WAS_HOST);

		return new IDeployResolution[] { new AddWasJNDIBindingConstraintResolution(context, this,
				description, dmo, host) };
	}

	public boolean hasResolutions(IDeployResolutionContext context) {
		IDeployStatus status = context.getDeployStatus();

		if (!(status instanceof WasDeployStatus)) {
			return false;
		}

		if (!IWASProblemType.OPTIONAL_CONSTRAINT_NOT_PRESENT.equals(status.getProblemType())) {
			return false;
		}

		EClass constraintType = (EClass) ((WasDeployStatus) status)
				.getAttribute(WasValidationUtil.CONSTRAINT_TYPE);
		if (null == constraintType) {
			return false;
		}

		if (!WasPackage.Literals.WAS_JNDI_BINDING_CONSTRAINT.isSuperTypeOf(constraintType)) {
			return false;
		}

		// to add a constraint, the object must be public
		DeployModelObject object = status.getDeployObject();

//		if (object.getTopology() != object.getEditTopology()) {
//			if (!object.getTopology().getConfigurationContract().isPublic(object)) {
//				return false;
//			}
//		}
		if (!object.isPublic()) {
			return false;
		}

		// this resolution works on certain types of objects
		// 1) Every EnterpriseBeanService should have a JNDIBindingConsraint
		// 2) Every reference to an EnterpriseBeanService should have a JNDIBindingConstraint
		// 3) Every requirement to a J2EEDatasource should have a JNDIBindingConstraint

		EClass objectType = object.getEObject().eClass();

		if (CorePackage.Literals.REFERENCE.isSuperTypeOf(objectType)
				&& J2eePackage.Literals.ENTERPRISE_BEAN_SERVICE.isSuperTypeOf(((Reference) object)
						.getDmoEType())) {
			return true;
		}

		if (CorePackage.Literals.REQUIREMENT.isSuperTypeOf(objectType)
				&& J2eePackage.Literals.J2EE_DATASOURCE.isSuperTypeOf(((Requirement) object)
						.getDmoEType())) {
			return true;
		}

		if (J2eePackage.Literals.ENTERPRISE_BEAN_SERVICE.isSuperTypeOf(objectType)) {
			return true;
		}

		return false;
	}

}
