/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.virtualization.validator;

import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPlugin;

//import com.ibm.ccl.soa.deploy.core.validator.status.ICoreProblemType;
//import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;
//import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
//import com.ibm.ccl.soa.deploy.virtualization.Activator;
//import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage;

/**
 * {@link IDeployStatus#getValidatorID()} declarations for the {@link VirtualizationPackage}
 * deploy domain.
 */
public interface IVirtualizationDomainValidators {

 /**
 * <ul>
 * <li>ID ={@value}
 * <li>Status = {@link IDeployAttributeStatus}
 * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_INVALID}
 * <li>Description = The {@link AttributeName} value must be a valid MAC address
 * </ul>
 */
 public final static String MAC_ADDRESS_INVALID_SYNTAX = VirtualizationPlugin.PLUGIN_ID
 + ".MAC_ADDRESS_INVALID_SYNTAX"; //$NON-NLS-1$;
 
 
 /**
  * <ul>
  * <li>ID ={@value}
  * <li>Status = {@link IDeployAttributeStatus}
  * <li>Problem = {@link ICoreProblemType#OBJECT_ATTRIBUTE_NOT_UNIQUE}
  * <li>Description = The {@link AttributeName} value must be unique in the direct host
  * </ul>
  */
  public final static String MAC_ADDRESS_NOT_UNIQUE_ON_MACHINE = VirtualizationPlugin.PLUGIN_ID
  + ".MAC_ADDRESS_NOT_UNIQUE_ON_MACHINE"; //$NON-NLS-1$;

}