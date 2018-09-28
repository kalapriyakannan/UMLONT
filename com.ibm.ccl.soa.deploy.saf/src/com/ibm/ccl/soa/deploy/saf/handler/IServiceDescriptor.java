/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.saf.handler;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;

/**
 * Describes an available service, including the EMF Model Element Type ({@link #getEType()} as
 * well as the fully qualified Java class {@link #getServiceType()}.
 * <p>
 * The {@link EClass} is available, but caution should be used in acquiring it as it can cause
 * plugins to load.
 * </p>
 * <p>
 * This interface is not intended to be implemented by clients.
 * </p>
 * 
 */
public interface IServiceDescriptor extends ICommonDescriptor {

	/**
	 * Return the fully qualified Java class name of this Service.
	 * 
	 * @return The fully qualified Java class name of this Service.
	 */
	String getServiceType();

	/**
	 * Return the EMF Short name of this class (equivalent to
	 * {@link ENamedElement#getName() EClass.getName()}, but does not force other plugins to load.)
	 * 
	 * @return The EMF Short name of this class
	 */
	String getEType();

	/**
	 * Forces the resolution o the EClass. <b>WARNING: This method should be used sparingly as it
	 * forces the load of plugins.</b>
	 * 
	 * @return The resolved EClass or <b>null</b> if not available.
	 */
	EClass resolveType();
}
