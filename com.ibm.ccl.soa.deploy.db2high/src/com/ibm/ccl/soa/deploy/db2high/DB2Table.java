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
 * A representation of the model object '<em><b>DB2 Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Table#getAlias <em>Alias</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Table#getIndexTableSpace <em>Index Table Space</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Table#getName1 <em>Name1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Table#getPartioningKey <em>Partioning Key</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2Table#getPartioningMethod <em>Partioning Method</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Table()
 * @model extendedMetaData="name='DB2Table' kind='elementOnly'"
 * @generated
 */
public interface DB2Table extends Capability {
	/**
	 * Returns the value of the '<em><b>Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Alias</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Alias</em>' attribute.
	 * @see #setAlias(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Table_Alias()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Alias'"
	 * @generated
	 */
	String getAlias();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Table#getAlias <em>Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alias</em>' attribute.
	 * @see #getAlias()
	 * @generated
	 */
	void setAlias(String value);

	/**
	 * Returns the value of the '<em><b>Index Table Space</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index Table Space</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index Table Space</em>' attribute.
	 * @see #setIndexTableSpace(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Table_IndexTableSpace()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='IndexTableSpace'"
	 * @generated
	 */
	String getIndexTableSpace();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Table#getIndexTableSpace <em>Index Table Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index Table Space</em>' attribute.
	 * @see #getIndexTableSpace()
	 * @generated
	 */
	void setIndexTableSpace(String value);

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
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Table_Name1()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName1();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Table#getName1 <em>Name1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name1</em>' attribute.
	 * @see #getName1()
	 * @generated
	 */
	void setName1(String value);

	/**
	 * Returns the value of the '<em><b>Partioning Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partioning Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partioning Key</em>' attribute.
	 * @see #setPartioningKey(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Table_PartioningKey()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='PartioningKey'"
	 * @generated
	 */
	String getPartioningKey();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Table#getPartioningKey <em>Partioning Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partioning Key</em>' attribute.
	 * @see #getPartioningKey()
	 * @generated
	 */
	void setPartioningKey(String value);

	/**
	 * Returns the value of the '<em><b>Partioning Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partioning Method</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partioning Method</em>' attribute.
	 * @see #setPartioningMethod(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2Table_PartioningMethod()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='PartioningMethod'"
	 * @generated
	 */
	String getPartioningMethod();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2Table#getPartioningMethod <em>Partioning Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partioning Method</em>' attribute.
	 * @see #getPartioningMethod()
	 * @generated
	 */
	void setPartioningMethod(String value);

} // DB2Table
