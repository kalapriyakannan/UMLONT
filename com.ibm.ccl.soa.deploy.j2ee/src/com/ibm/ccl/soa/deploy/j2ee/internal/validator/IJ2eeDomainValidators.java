/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.internal.validator;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.j2ee.EarModule;
import com.ibm.ccl.soa.deploy.j2ee.EjbModule;
import com.ibm.ccl.soa.deploy.j2ee.J2CAuthenticationDataEntry;
import com.ibm.ccl.soa.deploy.j2ee.J2EEDatasource;
import com.ibm.ccl.soa.deploy.j2ee.J2EEDeployPlugin;
import com.ibm.ccl.soa.deploy.j2ee.WebModule;

public interface IJ2eeDomainValidators {

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link J2EEDatasource#getJndiName()} attribute of a requirement
	 * consumed by a {@link EjbModule} is undefined.
	 * </ul>
	 */
	public final static String J2EE_EJB_MODULE_001 = J2EEDeployPlugin.pluginID
			+ ".J2EE_EJB_MODULE_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType.DEPENDENCY_LINK_TARGET_HOSTING_INVALID}
	 * <li>Description = The dependency link of a {@link J2EEDatasource} requirement points to a
	 * {@link Capability} whose host is not the same.
	 * </ul>
	 */
	public final static String J2EE_EJB_MODULE_002 = J2EEDeployPlugin.pluginID
			+ ".J2EE_EJB_MODULE_002"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link J2EEDatasource#getJndiName()} attribute of a requirement
	 * consumed by a {@link WebModule} is undefined.
	 * </ul>
	 */
	public final static String J2EE_WEB_MODULE_001 = J2EEDeployPlugin.pluginID
			+ ".J2EE_WEB_MODULE_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType.DEPENDENCY_LINK_TARGET_HOSTING_INVALID}
	 * <li>Description = The dependency link of a {@link J2EEDatasource} requirement points to a
	 * {@link Capability} whose host is not the same.
	 * </ul>
	 */
	public final static String J2EE_WEB_MODULE_002 = J2EEDeployPlugin.pluginID
			+ ".J2EE_WEB_MODULE_002"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link J2EEDatasource#getJndiName()} attribute of a requirement
	 * consumed by a {@link EarModule} is undefined.
	 * </ul>
	 */
	public final static String J2EE_EAR_MODULE_001 = J2EEDeployPlugin.pluginID
			+ ".J2EE_EAR_MODULE_001"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployStatus}
	 * <li>Problem = {@link ICoreProblemType.DEPENDENCY_LINK_TARGET_HOSTING_INVALID}
	 * <li>Description = The dependency link of a {@link J2EEDatasource} requirement points to a
	 * {@link Capability} whose host is not the same.
	 * </ul>
	 */
	public final static String J2EE_EAR_MODULE_002 = J2EEDeployPlugin.pluginID
			+ ".J2EE_EAR_MODULE_002"; //$NON-NLS-1$

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link J2EEDatasource#getDatasourceName()} must not be null or empty.
	 * </ul>
	 */
	public final static String J2EE_DATA_SOURCE_DATASOURCE_NAME_NOT_EMPTY = J2EEDeployPlugin.pluginID
			+ ".J2EE_DATA_SOURCE_DATASOURCE_NAME_NOT_EMPTY"; //$NON-NLS-1$	

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link J2EEDatasource#getJndiName()} must not be null or empty.
	 * </ul>
	 */
	public final static String J2EE_DATA_SOURCE_JNDI_NAME_NOT_EMPTY = J2EEDeployPlugin.pluginID
			+ ".J2EE_DATA_SOURCE_JNDI_NAME_NOT_EMPTY"; //$NON-NLS-1$		

	/**
	 * <ul>
	 * <li>ID ={@value}
	 * <li>Status = {@link IDeployAttributeStatus}
	 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_UNDEFINED}
	 * <li>Description = The {@link J2CAuthenticationDataEntry#getAlias()} must not be null or
	 * empty.
	 * </ul>
	 */
	public final static String J2C_AUTHENTICATION_DATA_ENTRY_ALIAS_NOT_EMPTY = J2EEDeployPlugin.pluginID
			+ ".J2C_AUTHENTICATION_DATA_ENTRY_ALIAS_NOT_EMPTY"; //$NON-NLS-1$		
}
