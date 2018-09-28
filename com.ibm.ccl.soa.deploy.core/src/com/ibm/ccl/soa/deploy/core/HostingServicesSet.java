/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Hosting Services Set</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * </ul>
 * </p>
 * 
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getHostingServicesSet()
 * @model features="hostingGroup hosting"
 *        hostingGroupType="org.eclipse.emf.ecore.util.FeatureMap$Entry" hostingGroupUnique="false"
 *        hostingGroupDataType="org.eclipse.emf.ecore.EFeatureMapEntry" hostingGroupMany="true"
 *        hostingGroupSuppressedGetVisibility="true" hostingGroupSuppressedSetVisibility="true"
 *        hostingGroupExtendedMetaData="kind='group' name='hosting:group'
 *        namespace='##targetNamespace'" hostingType="com.ibm.ccl.soa.deploy.core.HostingCapability"
 *        hostingContainment="true" hostingResolveProxies="false" hostingMany="true"
 *        hostingTransient="true" hostingVolatile="true" hostingDerived="true"
 *        hostingSuppressedGetVisibility="true" hostingSuppressedSetVisibility="true"
 *        hostingExtendedMetaData="kind='element' name='hosting' namespace='##targetNamespace'
 *        group='hosting:group'" extendedMetaData="name='HostingServicesSet' kind='elementOnly'"
 * @generated
 */
public interface HostingServicesSet extends EObject {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Return a list of {@link HostingCapability} elements.
	 * 
	 * @return list of {@link HostingCapability} elements
	 */
	List getHosting();

} // HostingServicesSet
