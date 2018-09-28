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

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.was.internal.validator.WasDomainMessages;

/**
 * Generator for resolution to add a class loader policy constraint.
 */
public class AddJ2eeWasConstraintsResolutionGenerator extends DeployResolutionGenerator {

	private static final IDeployResolutionGenerator clGenerator = new AddWasClassloaderPolicyConstraintResolutionGenerator();
	private static final IDeployResolutionGenerator swGenerator = new AddWasModuleStartWeightConstraintResolutionGenerator();
	private static final IDeployResolutionGenerator jndiGenerator = new AddWasJNDIBindingConstraintResolutionGenerator();
	private static final IDeployResolutionGenerator ssGenerator = new AddWasSecuritySubjectConstraintResolutionGenerator();

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {
		// sanity check
		if (!hasResolutions(context)) {
			return new IDeployResolution[0];
		}

		String description = WasDomainMessages.Resolution_add__all_WAS_specific_constraints;

		DeployModelObject object = context.getDeployStatus().getDeployObject();
		EClass objectType = object.getEObject().eClass();

		Unit unit = null;
		// identify hosting container
		if (J2eePackage.Literals.EAR_MODULE.isSuperTypeOf(objectType)) {
			unit = (Unit) object;
		} else if (J2eePackage.Literals.EJB_MODULE.isSuperTypeOf(objectType)
				|| J2eePackage.Literals.WEB_MODULE.isSuperTypeOf(objectType)) {
			unit = getModule((Unit) object, objectType, context);
		} else if (J2eePackage.Literals.ENTERPRISE_BEAN_SERVICE.isSuperTypeOf(objectType)) {
			unit = getModule((Unit) object.getParent(), object.getParent().getEObject().eClass(),
					context);
		} else if (CorePackage.Literals.REQUIREMENT.isSuperTypeOf(objectType)
				&& J2eePackage.Literals.ENTERPRISE_BEAN_SERVICE.isSuperTypeOf(((Requirement) object)
						.getDmoEType())) {
			unit = getModule((Unit) object.getParent(), object.getParent().getEObject().eClass(),
					context);
		} else if (CorePackage.Literals.REQUIREMENT.isSuperTypeOf(objectType)
				&& J2eePackage.Literals.J2EE_DATASOURCE.isSuperTypeOf(((Requirement) object)
						.getDmoEType())) {
			unit = getModule((Unit) object.getParent(), object.getParent().getEObject().eClass(),
					context);
		}

		return new IDeployResolution[] { new AddJ2eeWasConstraintsResolution(context, this,
				description, unit) };
	}

	private Unit getModule(Unit object, EClass objectType, IDeployResolutionContext context) {
		Unit unit = null;
		if (J2eePackage.Literals.EJB_MODULE.isSuperTypeOf(objectType)
				|| J2eePackage.Literals.WEB_MODULE.isSuperTypeOf(objectType)) {
			Unit host = ValidatorUtils.getHost(object);
			// if Ejb/Web module is directly hosted then return this module
			if (null != host) {
				unit = host;
			} else {
				unit = ValidatorUtils.discoverGroupByUnitType(object, J2eePackage.Literals.EAR_MODULE,
						context.getProgressMonitor());
			}
		}
		return unit;
	}

	public boolean hasResolutions(IDeployResolutionContext context) {

		if (clGenerator.hasResolutions(context)) {
			return true;
		}

		if (swGenerator.hasResolutions(context)) {
			return true;
		}

		if (jndiGenerator.hasResolutions(context)) {
			return true;
		}

		if (ssGenerator.hasResolutions(context)) {
			return true;
		}

		return false;
	}

}
