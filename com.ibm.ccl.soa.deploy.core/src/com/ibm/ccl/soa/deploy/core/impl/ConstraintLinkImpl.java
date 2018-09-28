/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.impl;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Logical Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ConstraintLinkImpl extends DeployLinkImpl implements ConstraintLink {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstraintLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.CONSTRAINT_LINK;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.LogicalLink#getSource()
	 */
	public DeployModelObject getSource() {
		return getSourceObject();
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.LogicalLink#setSource(com.ibm.ccl.soa.deploy.core.DeployModelObject)
	 */
	public void setSource(DeployModelObject source) {
		setSourceObject(source);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.LogicalLink#getTarget()
	 */
	public DeployModelObject getTarget() {
		return getTargetObject();
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.LogicalLink#setTarget(com.ibm.ccl.soa.deploy.core.DeployModelObject)
	 */
	public void setTarget(DeployModelObject target) {
		setTargetObject(target);
	}

} //LogicalLinkImpl
