/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>DB2 Runtime Client Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				A DB2RuntimeClientUnit enables applications to access servers. It lets applications access DB2 servers,
 * 				but doesn't include the support for database administration and application development found in the
 * 				{@link DB2AdminClientUnit} or {@link DB2AppDevelClientUnit}. By convention, a DB2RuntimeClientUnit
 * 				contains a {@link DB2RuntimeClient} capability.
 * 			
 * <!-- end-model-doc -->
 *
 *
 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2RuntimeClientUnit()
 * @model extendedMetaData="name='DB2RuntimeClientUnit' kind='elementOnly'"
 * @generated
 */
public interface DB2RuntimeClientUnit extends DB2BaseClientUnit {
} // DB2RuntimeClientUnit
