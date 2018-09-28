/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.db2;

/**
 * IDb2TemplateConstants holds the IDs of GMF SpecializationTypes. Each of these constants
 * corresponds to the <code>id</code> attribute of a &lt;specializationType&gt; in plugin.xml.
 */
public interface IDb2TemplateConstants {

	public static final String DB2_INSTANCE_UNIT = "db2.DB2InstanceUnit.8.infra"; //$NON-NLS-1$
	public static final String DB2_INSTANCE_UNIT_CONCEPTUAL = "db2.DB2InstanceUnit.8.conceptual"; //$NON-NLS-1$

	public static final String DB2_CLIENT_INSTANCE_UNIT = "db2.DB2ClientInstanceUnit.8.infra"; //$NON-NLS-1$
	public static final String DB2_CLIENT_INSTANCE_UNIT_CONCEPTUAL = "db2.DB2ClientInstanceUnit.8.conceptual"; //$NON-NLS-1$

	public static final String DB2_SYSTEM_UNIT = "db2.DB2SystemUnit.8.infra"; //$NON-NLS-1$
	public static final String DB2_SYSTEM_UNIT_CONCEPTUAL = "db2.DB2SystemUnit.8.conceptual"; //$NON-NLS-1$

	public static final String DB2_RUNTIME_CLIENT_UNIT = "db2.DB2RuntimeClientUnit.8.infra"; //$NON-NLS-1$
	public static final String DB2_RUNTIME_CLIENT_UNIT_CONCEPTUAL = "db2.DB2RuntimeClientUnit.8.conceptual"; //$NON-NLS-1$

	public static final String DB2_ADMIN_CLIENT_UNIT_CONCEPTUAL = "db2.DB2AdminClientUnit.8.infra"; //$NON-NLS-1$
	public static final String DB2_ADMIN_CLIENT_UNIT = "db2.DB2AdminClientUnit.8.conceptual"; //$NON-NLS-1$	

	public static final String DB2_APPLICATION_DEVELOPMENT_CLIENT_UNIT = "db2.DB2AppDevelClientUnit.8.infra"; //$NON-NLS-1$
	public static final String DB2_APPLICATION_DEVELOPMENT_CLIENT_UNIT_CONCEPTUAL = "db2.DB2AppDevelClientUnit.8.conceptual"; //$NON-NLS-1$

	public static final String DB2_DATABASE_UNIT = "db2.DB2DatabaseUnit.8.infra"; //$NON-NLS-1$
	public static final String DB2_DATABASE_UNIT_CONCEPTUAL = "db2.DB2DatabaseUnit.8.conceptual"; //$NON-NLS-1$

	public static final String DB2_CATALOG_UNIT = "db2.DB2CatalogUnit.infra"; //$NON-NLS-1$
	public static final String DB2_CATALOG_UNIT_CONCEPTUAL = "db2.DB2CatalogUnit.conceptual"; //$NON-NLS-1$

	public static final String DB2_NODE_CATALOG_UNIT = "db2.DB2NodeCatalogUnit.infra"; //$NON-NLS-1$
	public static final String DB2_NODE_CATALOG_UNIT_CONCEPTUAL = "db2.DB2NodeCatalogUnit.conceptual"; //$NON-NLS-1$
}
