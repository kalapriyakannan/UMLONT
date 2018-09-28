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
import com.ibm.ccl.soa.deploy.was.WasCell;
import com.ibm.ccl.soa.deploy.was.WasCellUnit;
import com.ibm.ccl.soa.deploy.was.WasPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Cell Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class WasCellUnitImpl extends UnitImpl implements WasCellUnit {
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
	protected WasCellUnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return WasPackage.Literals.WAS_CELL_UNIT;
	}

	public String getSpecializedTypeId() {
		if (specializedTypeId != null)
			return specializedTypeId;
		String wasVersion = null;
		String isDistributed = null;
		Iterator it = getCapabilities().iterator();
		while (it.hasNext()) {
			Capability capability = (Capability) it.next();
			if (capability instanceof WasCell) {
				WasCell cell = (WasCell) capability;
				wasVersion = cell.getWasVersion();
				if (cell.isIsDistributed())
					isDistributed = ".true"; //$NON-NLS-1$
				else
					isDistributed = ".false"; //$NON-NLS-1$				
				break;
			}
		}
		specializedTypeId = "com.ibm.ccl.soa.deploy.was.WasCellUnit." + wasVersion + isDistributed; //$NON-NLS-1$
		return specializedTypeId;
	}

} //WasCellUnitImpl
