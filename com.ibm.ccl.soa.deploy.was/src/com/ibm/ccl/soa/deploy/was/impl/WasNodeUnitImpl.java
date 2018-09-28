/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was.impl;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.impl.UnitImpl;
import com.ibm.ccl.soa.deploy.was.WasNode;
import com.ibm.ccl.soa.deploy.was.WasNodeUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Node Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class WasNodeUnitImpl extends UnitImpl implements WasNodeUnit {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	private String specializedTypeId = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasNodeUnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_NODE_UNIT;
	}

	public String getSpecializedTypeId() {
		if (specializedTypeId != null)
			return specializedTypeId;
		String wasVersion = null;
		String profileType = null;
		Iterator it = getCapabilities().iterator();
		while (it.hasNext()) {
			Capability capability = (Capability) it.next();
			if (capability instanceof WasNode) {
				WasNode node = (WasNode) capability;
				wasVersion = node.getWasVersion();
				profileType = node.getProfileType().getLiteral();
				break;
			}
		}
		specializedTypeId = "com.ibm.ccl.soa.deploy.was.WasCellUnit." + wasVersion + profileType; //$NON-NLS-1$
		return specializedTypeId;
	}

} //WasNodeUnitImpl
