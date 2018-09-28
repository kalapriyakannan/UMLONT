/**
 * <copyright>
 * </copyright>
 *
 * $Id: VMwareVirtualImageSnapshotContainer.java,v 1.1 2008/04/28 19:50:59 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VMware Virtual Image Snapshot Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This capability is provided by {@link VMwareVirtualImageUnit}s.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImageSnapshotContainer#getCurrentSnapshotUid <em>Current Snapshot Uid</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImageSnapshotContainer#getLastSnapshotUid <em>Last Snapshot Uid</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImageSnapshotContainer#getNumSnapshots <em>Num Snapshots</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualImageSnapshotContainer()
 * @model extendedMetaData="name='VMwareVirtualImageSnapshotContainer' kind='elementOnly'"
 * @generated
 */
public interface VMwareVirtualImageSnapshotContainer extends VirtualImageSnapshotContainer {
	/**
	 * Returns the value of the '<em><b>Current Snapshot Uid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The UID of the current snapshot
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Current Snapshot Uid</em>' attribute.
	 * @see #setCurrentSnapshotUid(String)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualImageSnapshotContainer_CurrentSnapshotUid()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='currentSnapshotUid'"
	 * @generated
	 */
	String getCurrentSnapshotUid();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImageSnapshotContainer#getCurrentSnapshotUid <em>Current Snapshot Uid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Snapshot Uid</em>' attribute.
	 * @see #getCurrentSnapshotUid()
	 * @generated
	 */
	void setCurrentSnapshotUid(String value);

	/**
	 * Returns the value of the '<em><b>Last Snapshot Uid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * e.g. "1"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Last Snapshot Uid</em>' attribute.
	 * @see #setLastSnapshotUid(String)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualImageSnapshotContainer_LastSnapshotUid()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='lastSnapshotUid'"
	 * @generated
	 */
	String getLastSnapshotUid();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImageSnapshotContainer#getLastSnapshotUid <em>Last Snapshot Uid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Snapshot Uid</em>' attribute.
	 * @see #getLastSnapshotUid()
	 * @generated
	 */
	void setLastSnapshotUid(String value);

	/**
	 * Returns the value of the '<em><b>Num Snapshots</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Indicates how many snapshots are available for this image.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Num Snapshots</em>' attribute.
	 * @see #isSetNumSnapshots()
	 * @see #unsetNumSnapshots()
	 * @see #setNumSnapshots(int)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualImageSnapshotContainer_NumSnapshots()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='numSnapshots'"
	 * @generated
	 */
	int getNumSnapshots();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImageSnapshotContainer#getNumSnapshots <em>Num Snapshots</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Num Snapshots</em>' attribute.
	 * @see #isSetNumSnapshots()
	 * @see #unsetNumSnapshots()
	 * @see #getNumSnapshots()
	 * @generated
	 */
	void setNumSnapshots(int value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImageSnapshotContainer#getNumSnapshots <em>Num Snapshots</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNumSnapshots()
	 * @see #getNumSnapshots()
	 * @see #setNumSnapshots(int)
	 * @generated
	 */
	void unsetNumSnapshots();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImageSnapshotContainer#getNumSnapshots <em>Num Snapshots</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Num Snapshots</em>' attribute is set.
	 * @see #unsetNumSnapshots()
	 * @see #getNumSnapshots()
	 * @see #setNumSnapshots(int)
	 * @generated
	 */
	boolean isSetNumSnapshots();

} // VMwareVirtualImageSnapshotContainer
