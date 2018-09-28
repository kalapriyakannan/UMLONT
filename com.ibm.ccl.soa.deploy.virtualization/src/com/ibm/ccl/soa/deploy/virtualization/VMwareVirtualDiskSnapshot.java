/**
 * <copyright>
 * </copyright>
 *
 * $Id: VMwareVirtualDiskSnapshot.java,v 1.2 2008/04/24 02:17:02 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VMware Virtual Disk Snapshot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This capability is provided by {@link VMwareVirtualDiskSnapshotUnit}s.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskSnapshot#getDiskFileName <em>Disk File Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskSnapshot#getDiskNum <em>Disk Num</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskSnapshot#getSnapshotDiskFileName <em>Snapshot Disk File Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualDiskSnapshot()
 * @model extendedMetaData="name='VMwareVirtualDiskSnapshot' kind='elementOnly'"
 * @generated
 */
public interface VMwareVirtualDiskSnapshot extends VirtualDiskSnapshot {
	/**
	 * Returns the value of the '<em><b>Disk File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							e.g. "Windows Server 2003 Standard Edition.vmdk" or "Windows Server 2003 Standard
	 * 							Edition-000001.vmdk"
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Disk File Name</em>' attribute.
	 * @see #setDiskFileName(String)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualDiskSnapshot_DiskFileName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='diskFileName'"
	 * @generated
	 */
	String getDiskFileName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskSnapshot#getDiskFileName <em>Disk File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Disk File Name</em>' attribute.
	 * @see #getDiskFileName()
	 * @generated
	 */
	void setDiskFileName(String value);

	/**
	 * Returns the value of the '<em><b>Disk Num</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * e.g. "0"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Disk Num</em>' attribute.
	 * @see #isSetDiskNum()
	 * @see #unsetDiskNum()
	 * @see #setDiskNum(int)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualDiskSnapshot_DiskNum()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='diskNum'"
	 * @generated
	 */
	int getDiskNum();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskSnapshot#getDiskNum <em>Disk Num</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Disk Num</em>' attribute.
	 * @see #isSetDiskNum()
	 * @see #unsetDiskNum()
	 * @see #getDiskNum()
	 * @generated
	 */
	void setDiskNum(int value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskSnapshot#getDiskNum <em>Disk Num</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDiskNum()
	 * @see #getDiskNum()
	 * @see #setDiskNum(int)
	 * @generated
	 */
	void unsetDiskNum();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskSnapshot#getDiskNum <em>Disk Num</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Disk Num</em>' attribute is set.
	 * @see #unsetDiskNum()
	 * @see #getDiskNum()
	 * @see #setDiskNum(int)
	 * @generated
	 */
	boolean isSetDiskNum();

	/**
	 * Returns the value of the '<em><b>Snapshot Disk File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							The name of the file that maintains the disk deltas from the base disk file named by
	 * 							attribute "diskFileName" e.g. "Windows Server 2003 Standard Edition-000001.vmdk"
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Snapshot Disk File Name</em>' attribute.
	 * @see #setSnapshotDiskFileName(String)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualDiskSnapshot_SnapshotDiskFileName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='snapshotDiskFileName'"
	 * @generated
	 */
	String getSnapshotDiskFileName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualDiskSnapshot#getSnapshotDiskFileName <em>Snapshot Disk File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Snapshot Disk File Name</em>' attribute.
	 * @see #getSnapshotDiskFileName()
	 * @generated
	 */
	void setSnapshotDiskFileName(String value);

} // VMwareVirtualDiskSnapshot
