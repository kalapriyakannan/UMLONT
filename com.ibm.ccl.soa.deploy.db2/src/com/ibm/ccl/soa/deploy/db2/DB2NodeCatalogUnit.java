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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>DB2 Node Catalog Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				DB2NodeCatalogUnit represents a connection to a remote DB2 Instance. DB2NodeCatalogUnit carries a {@link
 * 				DB2CatalogedNode} capability to hold the host and port of the remote DB2 Instance. DB2NodeCatalogUnit
 * 				hosts {@link DB2NodeCatalogUnit}s representing databases on the remote instance. By convention,
 * 				DB2NodeCatalogUnits depend upon the remote instance. They are typically hosted by a {@link
 * 				DB2ClientInstanceUnit}.
 * 
 * 				<p>By convention, templates default the nodeType to 'TCPIP' and the port to '50000'.</p>
 * 
 * 				<p>
 * 					A DB2NodeCatalogUnit is said to be installed if it appears in the results of the LIST NODE DIRECTORY
 * 					command. Installation is typically done using the DB2 CATALOG TCPIP NODE or CATALOG LOCAL NODE
 * 					commands. Removal is typically done using the DB2 UNCATALOG NODE command.
 * 				</p>
 * 			
 * <!-- end-model-doc -->
 *
 *
 * @see com.ibm.ccl.soa.deploy.db2.Db2Package#getDB2NodeCatalogUnit()
 * @model extendedMetaData="name='DB2NodeCatalogUnit' kind='elementOnly'"
 * @generated
 */
public interface DB2NodeCatalogUnit extends Unit {
} // DB2NodeCatalogUnit
