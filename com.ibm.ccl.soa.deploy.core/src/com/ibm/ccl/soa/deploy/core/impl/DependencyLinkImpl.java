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

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Capability Link</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DependencyLinkImpl extends DeployLinkImpl implements DependencyLink {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DependencyLinkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.DEPENDENCY_LINK;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.DependencyLink#getSource()
	 */
	public Requirement getSource() {
		DeployModelObject source = getSourceObject();
		if (!(sourceObject instanceof Requirement)) {
			source = null;
			// alternative: return null;
		}
		Requirement sourceReq = (Requirement) source;
		// TODO remove compatibility code (if source is null, use container requirement)
		if (sourceReq == null && getParent() instanceof Requirement) {
			return (Requirement) getParent();
		}
		return sourceReq;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.DependencyLink#setSource(com.ibm.ccl.soa.deploy.core.Requirement)
	 */
	public void setSource(Requirement req) {
		setSourceObject(req);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.DependencyLink#getTarget()
	 */
	public Capability getTarget() {
		DeployModelObject target = getTargetObject();
		if (target instanceof Capability) {
			return (Capability) target;
		}
		return null;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.DependencyLink#setTarget(com.ibm.ccl.soa.deploy.core.Capability)
	 */
	public void setTarget(Capability service) {
		setTargetObject(service);
	}
} //DependencyLinkImpl
