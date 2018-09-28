/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.db2high;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DB2 Buffer Pool</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2BufferPool#getImmediateOrDeferred <em>Immediate Or Deferred</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2BufferPool#getName1 <em>Name1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2BufferPool#getPageSize <em>Page Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2BufferPool#getSize <em>Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2BufferPool()
 * @model extendedMetaData="name='DB2BufferPool' kind='elementOnly'"
 * @generated
 */
public interface DB2BufferPool extends Capability {
	/**
	 * Returns the value of the '<em><b>Immediate Or Deferred</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Immediate Or Deferred</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Immediate Or Deferred</em>' attribute.
	 * @see #setImmediateOrDeferred(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2BufferPool_ImmediateOrDeferred()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ImmediateOrDeferred'"
	 * @generated
	 */
	String getImmediateOrDeferred();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2BufferPool#getImmediateOrDeferred <em>Immediate Or Deferred</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Immediate Or Deferred</em>' attribute.
	 * @see #getImmediateOrDeferred()
	 * @generated
	 */
	void setImmediateOrDeferred(String value);

	/**
	 * Returns the value of the '<em><b>Name1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name1</em>' attribute.
	 * @see #setName1(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2BufferPool_Name1()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName1();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2BufferPool#getName1 <em>Name1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name1</em>' attribute.
	 * @see #getName1()
	 * @generated
	 */
	void setName1(String value);

	/**
	 * Returns the value of the '<em><b>Page Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Page Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Page Size</em>' attribute.
	 * @see #setPageSize(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2BufferPool_PageSize()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='PageSize'"
	 * @generated
	 */
	String getPageSize();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2BufferPool#getPageSize <em>Page Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Page Size</em>' attribute.
	 * @see #getPageSize()
	 * @generated
	 */
	void setPageSize(String value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2BufferPool_Size()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Size'"
	 * @generated
	 */
	String getSize();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2BufferPool#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(String value);

} // DB2BufferPool
