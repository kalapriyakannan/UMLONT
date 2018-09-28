/**
 * <copyright>
 * </copyright>
 *
 * $Id: VirtualImageCollectionUnit.java,v 1.2 2008/04/28 19:50:59 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization;

import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Virtual Image Collection Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				A VirtualImageCollectionUnit represents a group of {@link VirtualImageUnit}s.
 * 
 * 				<p>
 * 					VirtualImageCollectionUnits are by convention non-configuration {@link Unit}s and may contain [0.*]
 * 					member {@link VirtualImageUnit}s
 * 				</p>
 * 			
 * <!-- end-model-doc -->
 *
 *
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualImageCollectionUnit()
 * @model extendedMetaData="name='VirtualImageCollectionUnit' kind='elementOnly'"
 * @generated
 */
public interface VirtualImageCollectionUnit extends Unit {
} // VirtualImageCollectionUnit
