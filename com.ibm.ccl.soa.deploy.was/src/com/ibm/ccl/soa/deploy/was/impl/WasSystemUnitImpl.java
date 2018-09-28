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
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasSystem;
import com.ibm.ccl.soa.deploy.was.WasSystemUnit;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>System Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class WasSystemUnitImpl extends UnitImpl implements WasSystemUnit {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * 
	 */
	private String specializedTypeId = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WasSystemUnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_SYSTEM_UNIT;
	}

	public String getSpecializedTypeId() {
		if (specializedTypeId != null)
			return specializedTypeId;
		String wasEdition = null;
		String wasVersion = null;
		Iterator it = getCapabilities().iterator();
		while (it.hasNext()) {
			Capability capability = (Capability) it.next();
			if (capability instanceof WasSystem) {
				WasSystem wasSystem = (WasSystem) capability;
				wasEdition = wasSystem.getWasEdition().getLiteral();
				wasVersion = wasSystem.getWasVersion();
				break;
			}
		}
		specializedTypeId = "com.ibm.ccl.soa.deploy.was.WasSystemUnit." + wasVersion //$NON-NLS-1$
				+ "." + wasEdition; //$NON-NLS-1$
		return specializedTypeId;
	}

} //WasSystemUnitImpl
