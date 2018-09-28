/**
 * <copyright>
 * </copyright>
 *
 * $Id: VMwareVirtualServerSnapshot.java,v 1.3 2008/04/28 19:50:59 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VMware Virtual Server Snapshot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * This capability is provided by {@link VMwareVirtualServerSnapshotUnit}s.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getCreateTimeHigh <em>Create Time High</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getCreateTimeLow <em>Create Time Low</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#isCurrent <em>Current</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getDesiredSnapshotState <em>Desired Snapshot State</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getFilename <em>Filename</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getNumDisks <em>Num Disks</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getParentSnapshotUid <em>Parent Snapshot Uid</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getSnapshotType <em>Snapshot Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getUid <em>Uid</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualServerSnapshot()
 * @model extendedMetaData="name='VMwareVirtualServerSnapshot' kind='elementOnly'"
 * @generated
 */
public interface VMwareVirtualServerSnapshot extends VirtualServerSnapshot {
	/**
	 * Returns the value of the '<em><b>Create Time High</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							High order 32 bits of 64-bit value microseconds since January 1, 1970. e.g. "281325"
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Create Time High</em>' attribute.
	 * @see #isSetCreateTimeHigh()
	 * @see #unsetCreateTimeHigh()
	 * @see #setCreateTimeHigh(long)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualServerSnapshot_CreateTimeHigh()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Long"
	 *        extendedMetaData="kind='attribute' name='createTimeHigh'"
	 * @generated
	 */
	long getCreateTimeHigh();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getCreateTimeHigh <em>Create Time High</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Create Time High</em>' attribute.
	 * @see #isSetCreateTimeHigh()
	 * @see #unsetCreateTimeHigh()
	 * @see #getCreateTimeHigh()
	 * @generated
	 */
	void setCreateTimeHigh(long value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getCreateTimeHigh <em>Create Time High</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCreateTimeHigh()
	 * @see #getCreateTimeHigh()
	 * @see #setCreateTimeHigh(long)
	 * @generated
	 */
	void unsetCreateTimeHigh();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getCreateTimeHigh <em>Create Time High</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Create Time High</em>' attribute is set.
	 * @see #unsetCreateTimeHigh()
	 * @see #getCreateTimeHigh()
	 * @see #setCreateTimeHigh(long)
	 * @generated
	 */
	boolean isSetCreateTimeHigh();

	/**
	 * Returns the value of the '<em><b>Create Time Low</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							Low order 32 bits of 64-bit value microseconds since January 1, 1970. e.g. "-2028843496"
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Create Time Low</em>' attribute.
	 * @see #isSetCreateTimeLow()
	 * @see #unsetCreateTimeLow()
	 * @see #setCreateTimeLow(long)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualServerSnapshot_CreateTimeLow()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Long"
	 *        extendedMetaData="kind='attribute' name='createTimeLow'"
	 * @generated
	 */
	long getCreateTimeLow();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getCreateTimeLow <em>Create Time Low</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Create Time Low</em>' attribute.
	 * @see #isSetCreateTimeLow()
	 * @see #unsetCreateTimeLow()
	 * @see #getCreateTimeLow()
	 * @generated
	 */
	void setCreateTimeLow(long value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getCreateTimeLow <em>Create Time Low</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCreateTimeLow()
	 * @see #getCreateTimeLow()
	 * @see #setCreateTimeLow(long)
	 * @generated
	 */
	void unsetCreateTimeLow();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getCreateTimeLow <em>Create Time Low</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Create Time Low</em>' attribute is set.
	 * @see #unsetCreateTimeLow()
	 * @see #getCreateTimeLow()
	 * @see #setCreateTimeLow(long)
	 * @generated
	 */
	boolean isSetCreateTimeLow();

	/**
	 * Returns the value of the '<em><b>Current</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Indicates whether this snapshot the current snapshot.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Current</em>' attribute.
	 * @see #isSetCurrent()
	 * @see #unsetCurrent()
	 * @see #setCurrent(boolean)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualServerSnapshot_Current()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='current'"
	 * @generated
	 */
	boolean isCurrent();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#isCurrent <em>Current</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current</em>' attribute.
	 * @see #isSetCurrent()
	 * @see #unsetCurrent()
	 * @see #isCurrent()
	 * @generated
	 */
	void setCurrent(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#isCurrent <em>Current</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCurrent()
	 * @see #isCurrent()
	 * @see #setCurrent(boolean)
	 * @generated
	 */
	void unsetCurrent();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#isCurrent <em>Current</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Current</em>' attribute is set.
	 * @see #unsetCurrent()
	 * @see #isCurrent()
	 * @see #setCurrent(boolean)
	 * @generated
	 */
	boolean isSetCurrent();

	/**
	 * Returns the value of the '<em><b>Desired Snapshot State</b></em>' attribute.
	 * The default value is <code>"unknown"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.virtualization.DesiredSnapshotStateType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							May be used to indicate that the virtual machine should be restored to this snapshot.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Desired Snapshot State</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.virtualization.DesiredSnapshotStateType
	 * @see #isSetDesiredSnapshotState()
	 * @see #unsetDesiredSnapshotState()
	 * @see #setDesiredSnapshotState(DesiredSnapshotStateType)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualServerSnapshot_DesiredSnapshotState()
	 * @model default="unknown" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='desiredSnapshotState'"
	 * @generated
	 */
	DesiredSnapshotStateType getDesiredSnapshotState();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getDesiredSnapshotState <em>Desired Snapshot State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Desired Snapshot State</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.virtualization.DesiredSnapshotStateType
	 * @see #isSetDesiredSnapshotState()
	 * @see #unsetDesiredSnapshotState()
	 * @see #getDesiredSnapshotState()
	 * @generated
	 */
	void setDesiredSnapshotState(DesiredSnapshotStateType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getDesiredSnapshotState <em>Desired Snapshot State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDesiredSnapshotState()
	 * @see #getDesiredSnapshotState()
	 * @see #setDesiredSnapshotState(DesiredSnapshotStateType)
	 * @generated
	 */
	void unsetDesiredSnapshotState();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getDesiredSnapshotState <em>Desired Snapshot State</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Desired Snapshot State</em>' attribute is set.
	 * @see #unsetDesiredSnapshotState()
	 * @see #getDesiredSnapshotState()
	 * @see #setDesiredSnapshotState(DesiredSnapshotStateType)
	 * @generated
	 */
	boolean isSetDesiredSnapshotState();

	/**
	 * Returns the value of the '<em><b>Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * e.g. "windows server 2003 standard edition-Snapshot2.vmsn"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Filename</em>' attribute.
	 * @see #setFilename(String)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualServerSnapshot_Filename()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='filename'"
	 * @generated
	 */
	String getFilename();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getFilename <em>Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filename</em>' attribute.
	 * @see #getFilename()
	 * @generated
	 */
	void setFilename(String value);

	/**
	 * Returns the value of the '<em><b>Num Disks</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * e.g. "1"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Num Disks</em>' attribute.
	 * @see #isSetNumDisks()
	 * @see #unsetNumDisks()
	 * @see #setNumDisks(int)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualServerSnapshot_NumDisks()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='numDisks'"
	 * @generated
	 */
	int getNumDisks();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getNumDisks <em>Num Disks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Num Disks</em>' attribute.
	 * @see #isSetNumDisks()
	 * @see #unsetNumDisks()
	 * @see #getNumDisks()
	 * @generated
	 */
	void setNumDisks(int value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getNumDisks <em>Num Disks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetNumDisks()
	 * @see #getNumDisks()
	 * @see #setNumDisks(int)
	 * @generated
	 */
	void unsetNumDisks();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getNumDisks <em>Num Disks</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Num Disks</em>' attribute is set.
	 * @see #unsetNumDisks()
	 * @see #getNumDisks()
	 * @see #setNumDisks(int)
	 * @generated
	 */
	boolean isSetNumDisks();

	/**
	 * Returns the value of the '<em><b>Parent Snapshot Uid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * e.g. "1", or null if no parent snapshot.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parent Snapshot Uid</em>' attribute.
	 * @see #setParentSnapshotUid(String)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualServerSnapshot_ParentSnapshotUid()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='parentSnapshotUid'"
	 * @generated
	 */
	String getParentSnapshotUid();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getParentSnapshotUid <em>Parent Snapshot Uid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Snapshot Uid</em>' attribute.
	 * @see #getParentSnapshotUid()
	 * @generated
	 */
	void setParentSnapshotUid(String value);

	/**
	 * Returns the value of the '<em><b>Snapshot Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * e.g. "1", or "0"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Snapshot Type</em>' attribute.
	 * @see #setSnapshotType(String)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualServerSnapshot_SnapshotType()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='snapshotType'"
	 * @generated
	 */
	String getSnapshotType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getSnapshotType <em>Snapshot Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Snapshot Type</em>' attribute.
	 * @see #getSnapshotType()
	 * @generated
	 */
	void setSnapshotType(String value);

	/**
	 * Returns the value of the '<em><b>Uid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * e.g. "2"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Uid</em>' attribute.
	 * @see #setUid(String)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualServerSnapshot_Uid()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='uid'"
	 * @generated
	 */
	String getUid();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot#getUid <em>Uid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uid</em>' attribute.
	 * @see #getUid()
	 * @generated
	 */
	void setUid(String value);

} // VMwareVirtualServerSnapshot
