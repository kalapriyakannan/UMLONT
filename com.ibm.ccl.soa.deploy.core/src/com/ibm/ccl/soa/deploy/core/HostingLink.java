/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Hosting Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				A HostingLink expresses the relationship between a hosting {@link Requirement} and
 * 				a hosting {@link Capability}.
 * 			
 * <!-- end-model-doc -->
 *
 *
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getHostingLink()
 * @model extendedMetaData="name='HostingLink' kind='elementOnly'"
 * @generated
 */
public interface HostingLink extends UnitLink {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Return the {@link Unit} which is the target of this link. This indicates that the host of this
	 * link is hosting the returned {@link Unit}.
	 * 
	 * @return The hosted {@link Unit} element.
	 * 
	 * @see #getHost()
	 */
	Unit getHosted();

	/**
	 * Set the hosted {@link Unit} for this link.
	 * 
	 * @param hosted -
	 *           A {@link Unit} that will be hosted on the host.
	 * 
	 * @see #getHost()
	 */
	void setHosted(Unit hosted);

	/**
	 * @return the host {@link Unit}.
	 */
	Unit getHost();

} // HostingLink
