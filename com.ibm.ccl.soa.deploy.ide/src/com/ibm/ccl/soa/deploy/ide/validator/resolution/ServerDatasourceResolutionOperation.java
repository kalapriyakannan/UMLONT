/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.ide.validator.resolution;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.AttributeValueConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.EqualsConstraint;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.ide.operation.AbstractDeploymentResourceOperation;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;

public abstract class ServerDatasourceResolutionOperation extends
		AbstractDeploymentResourceOperation implements IUndoableOperation {

	protected Requirement datasourceReq;

	/**
	 * 
	 */
	public ServerDatasourceResolutionOperation() {
		super();
	}

	/**
	 * @param dataModel
	 */
	public ServerDatasourceResolutionOperation(IDataModel dataModel) {
		super(dataModel);
	}

	protected IStatus doRedo(IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		return null;
	}

	protected IStatus doUndo(IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns the jndi name from the source unit Could move this to J2EE level API
	 * 
	 * @return
	 */
	protected String getJndiNameFromSourceUnit() {
//		String JNDI_EXP_NAME = "Equals jndiName"; //$NON-NLS-1$
//		String JNDI_NAME = "jndiName"; //$NON-NLS-1$

		if (datasourceReq == null) {
			return null;
		}

//		Constraint exp = datasourceReq.getExpression(JNDI_EXP_NAME);
		Constraint exp = findAttributeValueConstraint(datasourceReq.getConstraints(),
				ConstraintPackage.Literals.EQUALS_CONSTRAINT,
				J2eePackage.Literals.J2EE_DATASOURCE__JNDI_NAME);
		if (exp != null && exp instanceof EqualsConstraint) {
			return ((EqualsConstraint) exp).getValue();
		}

		return null;
	}

	protected boolean getCMPFromSourceUnit() {
//		String USED_CMP_EXP = "Equals usedForCmp"; //$NON-NLS-1$
//		String USED_CMP = "usedForCmp"; //$NON-NLS-1$

		if (datasourceReq == null) {
			return false;
		}

//		Constraint exp = datasourceReq.getExpression(USED_CMP_EXP);
		Constraint exp = findAttributeValueConstraint(datasourceReq.getConstraints(),
				ConstraintPackage.Literals.EQUALS_CONSTRAINT,
				J2eePackage.Literals.J2EE_DATASOURCE__USED_FOR_CMP);
		if (exp != null && exp instanceof EqualsConstraint) {
			return new Boolean(((EqualsConstraint) exp).getValue()).booleanValue();
		}

		return false;
	}

	protected Requirement getRequirement(Unit sourceUnit) {
		String reqName = getDataModel().getStringProperty(
				IDatasourceResolutionProperties.DATASOURCE_REQUIREMENT);
		List reqs = sourceUnit.getRequirements();
		Iterator it = reqs.iterator();
		while (it.hasNext()) {
			Requirement req = (Requirement) it.next();
			if (req.getName().equals(reqName)) {
				return req;
			}
		}
		return null;
	}

	protected void createLinkToDatasource(Unit sourceUnit, Unit datasourceUnit) {
		Capability targetCapability = ValidatorUtils.getFirstCapability(datasourceUnit,
				J2eePackage.eINSTANCE.getJ2EEDatasource());
		LinkFactory.createDependencyLink(sourceUnit, datasourceReq, datasourceUnit, targetCapability);
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
