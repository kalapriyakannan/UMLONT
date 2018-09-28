/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.db2;

import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>DB2 Catalog Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				DB2CatalogUnits are a way of using indirection to configure programs that use databases. A
 * 				DB2CatalogUnit represents a remote DB2 database or an alias to a local database. By convention
 * 				DB2CatalogUnit is a configuration unit and carries a {@link DB2Database} capability representing the
 * 				remote database. The type 2 WAS Data Source depends on a DB2Database held by a local {@link
 * 				DB2DatabaseUnit} or by this {@link DB2CatalogUnit}. DB2CatalogUnit is typically hosted by a {@link
 * 				DB2NodeCatalogUnit}.
 * 
 * 				<p>
 * 					A DB2CatalogUnit is said to be installed if a connection to a database of that name would be
 * 					successful. Installation is typically done using the DB2 CATALOG DATABASE command. Removal is
 * 					typically done with the UNCATALOG DATABASE command.
 * 				</p>
 * 			
 * <!-- end-model-doc -->
 *
 *
 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2CatalogUnit()
 * @model extendedMetaData="name='DB2CatalogUnit' kind='elementOnly'"
 * @generated
 */
public interface DB2CatalogUnit extends Unit {
} // DB2CatalogUnit
