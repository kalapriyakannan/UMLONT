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
 * A representation of the model object '<em><b>DB2 Table Space</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getAutoResize <em>Auto Resize</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getDroppedTableRecovery <em>Dropped Table Recovery</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getEventSize <em>Event Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getFile <em>File</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getIncreaseSize <em>Increase Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getManagedBy <em>Managed By</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getMaxSize <em>Max Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getName1 <em>Name1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getOverhead <em>Overhead</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getPageSize <em>Page Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getPrefetchSize <em>Prefetch Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getTransferRate <em>Transfer Rate</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2TableSpace()
 * @model extendedMetaData="name='DB2TableSpace' kind='elementOnly'"
 * @generated
 */
public interface DB2TableSpace extends Capability {
	/**
	 * Returns the value of the '<em><b>Auto Resize</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Auto Resize</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Auto Resize</em>' attribute.
	 * @see #setAutoResize(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2TableSpace_AutoResize()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='AutoResize'"
	 * @generated
	 */
	String getAutoResize();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getAutoResize <em>Auto Resize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Auto Resize</em>' attribute.
	 * @see #getAutoResize()
	 * @generated
	 */
	void setAutoResize(String value);

	/**
	 * Returns the value of the '<em><b>Dropped Table Recovery</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dropped Table Recovery</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dropped Table Recovery</em>' attribute.
	 * @see #setDroppedTableRecovery(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2TableSpace_DroppedTableRecovery()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='DroppedTableRecovery'"
	 * @generated
	 */
	String getDroppedTableRecovery();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getDroppedTableRecovery <em>Dropped Table Recovery</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dropped Table Recovery</em>' attribute.
	 * @see #getDroppedTableRecovery()
	 * @generated
	 */
	void setDroppedTableRecovery(String value);

	/**
	 * Returns the value of the '<em><b>Event Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Size</em>' attribute.
	 * @see #setEventSize(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2TableSpace_EventSize()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='EventSize'"
	 * @generated
	 */
	String getEventSize();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getEventSize <em>Event Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Size</em>' attribute.
	 * @see #getEventSize()
	 * @generated
	 */
	void setEventSize(String value);

	/**
	 * Returns the value of the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File</em>' attribute.
	 * @see #setFile(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2TableSpace_File()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='File'"
	 * @generated
	 */
	String getFile();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getFile <em>File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File</em>' attribute.
	 * @see #getFile()
	 * @generated
	 */
	void setFile(String value);

	/**
	 * Returns the value of the '<em><b>Increase Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Increase Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Increase Size</em>' attribute.
	 * @see #setIncreaseSize(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2TableSpace_IncreaseSize()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='IncreaseSize'"
	 * @generated
	 */
	String getIncreaseSize();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getIncreaseSize <em>Increase Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Increase Size</em>' attribute.
	 * @see #getIncreaseSize()
	 * @generated
	 */
	void setIncreaseSize(String value);

	/**
	 * Returns the value of the '<em><b>Managed By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Managed By</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Managed By</em>' attribute.
	 * @see #setManagedBy(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2TableSpace_ManagedBy()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ManagedBy'"
	 * @generated
	 */
	String getManagedBy();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getManagedBy <em>Managed By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Managed By</em>' attribute.
	 * @see #getManagedBy()
	 * @generated
	 */
	void setManagedBy(String value);

	/**
	 * Returns the value of the '<em><b>Max Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Size</em>' attribute.
	 * @see #setMaxSize(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2TableSpace_MaxSize()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='MaxSize'"
	 * @generated
	 */
	String getMaxSize();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getMaxSize <em>Max Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Size</em>' attribute.
	 * @see #getMaxSize()
	 * @generated
	 */
	void setMaxSize(String value);

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
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2TableSpace_Name1()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName1();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getName1 <em>Name1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name1</em>' attribute.
	 * @see #getName1()
	 * @generated
	 */
	void setName1(String value);

	/**
	 * Returns the value of the '<em><b>Overhead</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Overhead</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overhead</em>' attribute.
	 * @see #setOverhead(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2TableSpace_Overhead()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Overhead'"
	 * @generated
	 */
	String getOverhead();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getOverhead <em>Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overhead</em>' attribute.
	 * @see #getOverhead()
	 * @generated
	 */
	void setOverhead(String value);

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
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2TableSpace_PageSize()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='PageSize'"
	 * @generated
	 */
	String getPageSize();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getPageSize <em>Page Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Page Size</em>' attribute.
	 * @see #getPageSize()
	 * @generated
	 */
	void setPageSize(String value);

	/**
	 * Returns the value of the '<em><b>Prefetch Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prefetch Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prefetch Size</em>' attribute.
	 * @see #setPrefetchSize(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2TableSpace_PrefetchSize()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='PrefetchSize'"
	 * @generated
	 */
	String getPrefetchSize();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getPrefetchSize <em>Prefetch Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prefetch Size</em>' attribute.
	 * @see #getPrefetchSize()
	 * @generated
	 */
	void setPrefetchSize(String value);

	/**
	 * Returns the value of the '<em><b>Transfer Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transfer Rate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transfer Rate</em>' attribute.
	 * @see #setTransferRate(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2TableSpace_TransferRate()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='TransferRate'"
	 * @generated
	 */
	String getTransferRate();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getTransferRate <em>Transfer Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transfer Rate</em>' attribute.
	 * @see #getTransferRate()
	 * @generated
	 */
	void setTransferRate(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see com.ibm.ccl.soa.deploy.db2high.Db2highPackage#getDB2TableSpace_Type()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Type'"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.db2high.DB2TableSpace#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

} // DB2TableSpace
