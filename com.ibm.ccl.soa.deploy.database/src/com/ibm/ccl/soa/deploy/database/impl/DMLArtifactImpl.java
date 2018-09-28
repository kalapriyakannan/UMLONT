/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.database.impl;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.impl.FileArtifactImpl;
import com.ibm.ccl.soa.deploy.database.DMLArtifact;
import com.ibm.ccl.soa.deploy.database.DatabasePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>DML Artifact</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DMLArtifactImpl extends FileArtifactImpl implements DMLArtifact {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DMLArtifactImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return DatabasePackage.Literals.DML_ARTIFACT;
	}

} //DMLArtifactImpl
