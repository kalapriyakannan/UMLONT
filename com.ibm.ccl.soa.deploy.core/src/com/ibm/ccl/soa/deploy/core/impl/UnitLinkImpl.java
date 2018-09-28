/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.impl;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitLink;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Unit Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class UnitLinkImpl extends DeployLinkImpl implements UnitLink {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected UnitLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.UNIT_LINK;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.UnitLink#getTarget()
	 */
	public Unit getTarget() {
		DeployModelObject target = getTargetObject();
		if (target instanceof Unit) {
			return (Unit) getTargetObject();
		}
		return null;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.UnitLink#getSource()
	 */
	public Unit getSource() {
		DeployModelObject source = getSourceObject();
		if (!(source instanceof Unit)) {
			source = null;
			// alternative: return null;
		}
		Unit sourceUnit = (Unit) source;
		// TODO remove compatibility code (container is source if not defined)
		if (sourceUnit == null && getParent() instanceof Unit) {
			return (Unit) getParent();
		}
		return sourceUnit;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.UnitLink#setTarget(com.ibm.ccl.soa.deploy.core.Unit)
	 */
	public void setTarget(Unit target) {
		setTargetObject(target);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.UnitLink#setSource(com.ibm.ccl.soa.deploy.core.Unit)
	 */
	public void setSource(Unit source) {
		setSourceObject(source);
	}
} //UnitLinkImpl
