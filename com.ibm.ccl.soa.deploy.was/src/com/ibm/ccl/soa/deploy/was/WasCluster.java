/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Cluster</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasCluster#getClusterName <em>Cluster Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasCluster#isCreateReplicationDomain <em>Create Replication Domain</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasCluster#isPreferLocal <em>Prefer Local</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.was.WasCluster#getWasVersion <em>Was Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasCluster()
 * @model extendedMetaData="name='WasCluster' kind='elementOnly'"
 * @generated
 */
public interface WasCluster extends WasJ2EEServer {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Cluster Name</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Cluster Name</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cluster Name</em>' attribute.
	 * @see #setClusterName(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasCluster_ClusterName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='clusterName'"
	 * @generated
	 */
	String getClusterName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasCluster#getClusterName <em>Cluster Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cluster Name</em>' attribute.
	 * @see #getClusterName()
	 * @generated
	 */
	void setClusterName(String value);

	/**
	 * Returns the value of the '<em><b>Create Replication Domain</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Create Replication Domain</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Create Replication Domain</em>' attribute.
	 * @see #isSetCreateReplicationDomain()
	 * @see #unsetCreateReplicationDomain()
	 * @see #setCreateReplicationDomain(boolean)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasCluster_CreateReplicationDomain()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='createReplicationDomain'"
	 * @generated
	 */
	boolean isCreateReplicationDomain();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasCluster#isCreateReplicationDomain <em>Create Replication Domain</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Create Replication Domain</em>' attribute.
	 * @see #isSetCreateReplicationDomain()
	 * @see #unsetCreateReplicationDomain()
	 * @see #isCreateReplicationDomain()
	 * @generated
	 */
	void setCreateReplicationDomain(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasCluster#isCreateReplicationDomain <em>Create Replication Domain</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetCreateReplicationDomain()
	 * @see #isCreateReplicationDomain()
	 * @see #setCreateReplicationDomain(boolean)
	 * @generated
	 */
	void unsetCreateReplicationDomain();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasCluster#isCreateReplicationDomain <em>Create Replication Domain</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Create Replication Domain</em>' attribute is set.
	 * @see #unsetCreateReplicationDomain()
	 * @see #isCreateReplicationDomain()
	 * @see #setCreateReplicationDomain(boolean)
	 * @generated
	 */
	boolean isSetCreateReplicationDomain();

	/**
	 * Returns the value of the '<em><b>Prefer Local</b></em>' attribute.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Prefer Local</em>' attribute isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prefer Local</em>' attribute.
	 * @see #isSetPreferLocal()
	 * @see #unsetPreferLocal()
	 * @see #setPreferLocal(boolean)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasCluster_PreferLocal()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='preferLocal'"
	 * @generated
	 */
	boolean isPreferLocal();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasCluster#isPreferLocal <em>Prefer Local</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prefer Local</em>' attribute.
	 * @see #isSetPreferLocal()
	 * @see #unsetPreferLocal()
	 * @see #isPreferLocal()
	 * @generated
	 */
	void setPreferLocal(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasCluster#isPreferLocal <em>Prefer Local</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSetPreferLocal()
	 * @see #isPreferLocal()
	 * @see #setPreferLocal(boolean)
	 * @generated
	 */
	void unsetPreferLocal();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.was.WasCluster#isPreferLocal <em>Prefer Local</em>}' attribute is set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return whether the value of the '<em>Prefer Local</em>' attribute is set.
	 * @see #unsetPreferLocal()
	 * @see #isPreferLocal()
	 * @see #setPreferLocal(boolean)
	 * @generated
	 */
	boolean isSetPreferLocal();

	/**
	 * Returns the value of the '<em><b>Was Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Was Version</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Was Version</em>' attribute.
	 * @see #setWasVersion(String)
	 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getWasCluster_WasVersion()
	 * @model dataType="com.ibm.ccl.soa.deploy.core.VersionString"
	 *        extendedMetaData="kind='attribute' name='wasVersion'"
	 * @generated
	 */
	String getWasVersion();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.was.WasCluster#getWasVersion <em>Was Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Was Version</em>' attribute.
	 * @see #getWasVersion()
	 * @generated
	 */
	void setWasVersion(String value);

} // WasCluster
