/**
 * <copyright>
 * </copyright>
 *
 * $Id: DeploymentUnitImpl.java,v 1.4 2007/10/10 20:13:27 nmakin Exp $
 */
package com.ibm.ccl.soa.deploy.analysis.impl;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.analysis.AnalysisPackage;
import com.ibm.ccl.soa.deploy.analysis.DeploymentUnit;
import com.ibm.ccl.soa.deploy.core.impl.UnitImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Deployment Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DeploymentUnitImpl extends UnitImpl implements DeploymentUnit {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeploymentUnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return AnalysisPackage.Literals.DEPLOYMENT_UNIT;
	}

} //DeploymentUnitImpl
