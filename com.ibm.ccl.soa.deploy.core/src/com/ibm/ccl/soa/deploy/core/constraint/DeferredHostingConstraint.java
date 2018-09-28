/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.constraint;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Deferred Hosting Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 			    Structural constraint representing the deferred hosting relationship (between two units). 
 * 			    This relationship indicates that one of the units (the source of the (constraint) link that 
 * 			    contains the constraint) is hosted on the other unit (the target of the link that contains
 * 			    the constraint), not necessarily directly, but potentially through a chain of other 
 * 			    units (i.e., the hosting stack).
 * 			
 * <!-- end-model-doc -->
 *
 *
 * @see com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage#getDeferredHostingConstraint()
 * @model extendedMetaData="name='DeferredHostingConstraint' kind='elementOnly'"
 * @generated
 */
public interface DeferredHostingConstraint extends StructuralConstraint {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

} // DeferredHostingConstraint
