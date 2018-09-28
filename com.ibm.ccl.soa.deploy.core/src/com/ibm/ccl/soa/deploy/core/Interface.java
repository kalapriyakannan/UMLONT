/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Interface</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * 
 * An Interface describes a business level contract between two parties.
 * 
 * <!-- end-model-doc -->
 * 
 * 
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getInterface()
 * @model abstract="true" extendedMetaData="name='Interface' kind='empty'"
 * @generated NOT
 * @extends Substitutable
 */
public interface Interface extends EObject, Substitutable {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * <p>
	 * This API should be used to determine if two interfaces are possibly equivalent. This is
	 * intended to be a quick check that is not expected to be an exhaustive check. If you need an
	 * exhaustive check you should use {@link #isEquivalent(Interface)}.
	 * </p>
	 * 
	 * @param anotherInterface -
	 *           An {@link Interface} to be compared.
	 * @return True if the passed {@link Interface} is possibly equivalent to this interface.
	 */
	boolean isFastEquivalencyCheck(Interface anotherInterface);

	/**
	 * <p>
	 * This API should be used to determine if two interfaces are the same or equivalent. You should
	 * not assume that calling {@link #equals(Object)} will produce the same results.
	 * 
	 * This method may be more exhaustive and clients should be prepared that this call may take more
	 * time. If a quicker check is required you may use {@link #isFastEquivalencyCheck(Interface)}.
	 * </p>
	 * 
	 * @param anotherInterface -
	 *           An {@link Interface} to be compared.
	 * @return True if the passed {@link Interface} is equivalent to this interface.
	 */
	boolean isEquivalent(Interface anotherInterface);

	/**
	 * 
	 * @return {@link String} A human readable string that describes this interface.
	 */
	String getDisplayString();

} // Interface
