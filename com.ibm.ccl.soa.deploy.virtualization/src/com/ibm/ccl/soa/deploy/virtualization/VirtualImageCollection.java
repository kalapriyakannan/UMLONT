/**
 * <copyright>
 * </copyright>
 *
 * $Id: VirtualImageCollection.java,v 1.2 2008/04/28 19:50:59 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Virtual Image Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This capability is provided by {@link VirtualImageCollectionUnit}s.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualImageCollection#getCollectionId <em>Collection Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualImageCollection()
 * @model extendedMetaData="name='VirtualImageCollection' kind='elementOnly'"
 * @generated
 */
public interface VirtualImageCollection extends Capability {
	/**
	 * Returns the value of the '<em><b>Collection Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							an identifying string for the collection of virtual machine images
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Collection Id</em>' attribute.
	 * @see #setCollectionId(String)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualImageCollection_CollectionId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='collectionId'"
	 * @generated
	 */
	String getCollectionId();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualImageCollection#getCollectionId <em>Collection Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collection Id</em>' attribute.
	 * @see #getCollectionId()
	 * @generated
	 */
	void setCollectionId(String value);

} // VirtualImageCollection
