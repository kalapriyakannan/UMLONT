/**
 * <copyright>
 * </copyright>
 *
 * $Id: VMwareVirtualServerSnapshotImpl.java,v 1.2 2008/04/24 02:17:02 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization.impl;

import com.ibm.ccl.soa.deploy.virtualization.DesiredSnapshotStateType;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualServerSnapshot;
import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>VMware Virtual Server Snapshot</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualServerSnapshotImpl#getCreateTimeHigh <em>Create Time High</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualServerSnapshotImpl#getCreateTimeLow <em>Create Time Low</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualServerSnapshotImpl#isCurrent <em>Current</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualServerSnapshotImpl#getDesiredSnapshotState <em>Desired Snapshot State</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualServerSnapshotImpl#getFilename <em>Filename</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualServerSnapshotImpl#getNumDisks <em>Num Disks</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualServerSnapshotImpl#getParentSnapshotUid <em>Parent Snapshot Uid</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualServerSnapshotImpl#getSnapshotType <em>Snapshot Type</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VMwareVirtualServerSnapshotImpl#getUid <em>Uid</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VMwareVirtualServerSnapshotImpl extends VirtualServerSnapshotImpl implements VMwareVirtualServerSnapshot {
	/**
	 * The default value of the '{@link #getCreateTimeHigh() <em>Create Time High</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreateTimeHigh()
	 * @generated
	 * @ordered
	 */
	protected static final long CREATE_TIME_HIGH_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getCreateTimeHigh() <em>Create Time High</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreateTimeHigh()
	 * @generated
	 * @ordered
	 */
	protected long createTimeHigh = CREATE_TIME_HIGH_EDEFAULT;

	/**
	 * This is true if the Create Time High attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean createTimeHighESet;

	/**
	 * The default value of the '{@link #getCreateTimeLow() <em>Create Time Low</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreateTimeLow()
	 * @generated
	 * @ordered
	 */
	protected static final long CREATE_TIME_LOW_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getCreateTimeLow() <em>Create Time Low</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreateTimeLow()
	 * @generated
	 * @ordered
	 */
	protected long createTimeLow = CREATE_TIME_LOW_EDEFAULT;

	/**
	 * This is true if the Create Time Low attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean createTimeLowESet;

	/**
	 * The default value of the '{@link #isCurrent() <em>Current</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCurrent()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CURRENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCurrent() <em>Current</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCurrent()
	 * @generated
	 * @ordered
	 */
	protected boolean current = CURRENT_EDEFAULT;

	/**
	 * This is true if the Current attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean currentESet;

	/**
	 * The default value of the '{@link #getDesiredSnapshotState() <em>Desired Snapshot State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDesiredSnapshotState()
	 * @generated
	 * @ordered
	 */
	protected static final DesiredSnapshotStateType DESIRED_SNAPSHOT_STATE_EDEFAULT = DesiredSnapshotStateType.UNKNOWN_LITERAL;

	/**
	 * The cached value of the '{@link #getDesiredSnapshotState() <em>Desired Snapshot State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDesiredSnapshotState()
	 * @generated
	 * @ordered
	 */
	protected DesiredSnapshotStateType desiredSnapshotState = DESIRED_SNAPSHOT_STATE_EDEFAULT;

	/**
	 * This is true if the Desired Snapshot State attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean desiredSnapshotStateESet;

	/**
	 * The default value of the '{@link #getFilename() <em>Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilename()
	 * @generated
	 * @ordered
	 */
	protected static final String FILENAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFilename() <em>Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilename()
	 * @generated
	 * @ordered
	 */
	protected String filename = FILENAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumDisks() <em>Num Disks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumDisks()
	 * @generated
	 * @ordered
	 */
	protected static final int NUM_DISKS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumDisks() <em>Num Disks</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumDisks()
	 * @generated
	 * @ordered
	 */
	protected int numDisks = NUM_DISKS_EDEFAULT;

	/**
	 * This is true if the Num Disks attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean numDisksESet;

	/**
	 * The default value of the '{@link #getParentSnapshotUid() <em>Parent Snapshot Uid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentSnapshotUid()
	 * @generated
	 * @ordered
	 */
	protected static final String PARENT_SNAPSHOT_UID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParentSnapshotUid() <em>Parent Snapshot Uid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentSnapshotUid()
	 * @generated
	 * @ordered
	 */
	protected String parentSnapshotUid = PARENT_SNAPSHOT_UID_EDEFAULT;

	/**
	 * The default value of the '{@link #getSnapshotType() <em>Snapshot Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSnapshotType()
	 * @generated
	 * @ordered
	 */
	protected static final String SNAPSHOT_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSnapshotType() <em>Snapshot Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSnapshotType()
	 * @generated
	 * @ordered
	 */
	protected String snapshotType = SNAPSHOT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getUid() <em>Uid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUid()
	 * @generated
	 * @ordered
	 */
	protected static final String UID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUid() <em>Uid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUid()
	 * @generated
	 * @ordered
	 */
	protected String uid = UID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VMwareVirtualServerSnapshotImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return VirtualizationPackage.Literals.VMWARE_VIRTUAL_SERVER_SNAPSHOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getCreateTimeHigh() {
		return createTimeHigh;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreateTimeHigh(long newCreateTimeHigh) {
		long oldCreateTimeHigh = createTimeHigh;
		createTimeHigh = newCreateTimeHigh;
		boolean oldCreateTimeHighESet = createTimeHighESet;
		createTimeHighESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__CREATE_TIME_HIGH, oldCreateTimeHigh, createTimeHigh, !oldCreateTimeHighESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCreateTimeHigh() {
		long oldCreateTimeHigh = createTimeHigh;
		boolean oldCreateTimeHighESet = createTimeHighESet;
		createTimeHigh = CREATE_TIME_HIGH_EDEFAULT;
		createTimeHighESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__CREATE_TIME_HIGH, oldCreateTimeHigh, CREATE_TIME_HIGH_EDEFAULT, oldCreateTimeHighESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCreateTimeHigh() {
		return createTimeHighESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getCreateTimeLow() {
		return createTimeLow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreateTimeLow(long newCreateTimeLow) {
		long oldCreateTimeLow = createTimeLow;
		createTimeLow = newCreateTimeLow;
		boolean oldCreateTimeLowESet = createTimeLowESet;
		createTimeLowESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__CREATE_TIME_LOW, oldCreateTimeLow, createTimeLow, !oldCreateTimeLowESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCreateTimeLow() {
		long oldCreateTimeLow = createTimeLow;
		boolean oldCreateTimeLowESet = createTimeLowESet;
		createTimeLow = CREATE_TIME_LOW_EDEFAULT;
		createTimeLowESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__CREATE_TIME_LOW, oldCreateTimeLow, CREATE_TIME_LOW_EDEFAULT, oldCreateTimeLowESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCreateTimeLow() {
		return createTimeLowESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCurrent() {
		return current;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrent(boolean newCurrent) {
		boolean oldCurrent = current;
		current = newCurrent;
		boolean oldCurrentESet = currentESet;
		currentESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__CURRENT, oldCurrent, current, !oldCurrentESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCurrent() {
		boolean oldCurrent = current;
		boolean oldCurrentESet = currentESet;
		current = CURRENT_EDEFAULT;
		currentESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__CURRENT, oldCurrent, CURRENT_EDEFAULT, oldCurrentESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCurrent() {
		return currentESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DesiredSnapshotStateType getDesiredSnapshotState() {
		return desiredSnapshotState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDesiredSnapshotState(DesiredSnapshotStateType newDesiredSnapshotState) {
		DesiredSnapshotStateType oldDesiredSnapshotState = desiredSnapshotState;
		desiredSnapshotState = newDesiredSnapshotState == null ? DESIRED_SNAPSHOT_STATE_EDEFAULT : newDesiredSnapshotState;
		boolean oldDesiredSnapshotStateESet = desiredSnapshotStateESet;
		desiredSnapshotStateESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__DESIRED_SNAPSHOT_STATE, oldDesiredSnapshotState, desiredSnapshotState, !oldDesiredSnapshotStateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDesiredSnapshotState() {
		DesiredSnapshotStateType oldDesiredSnapshotState = desiredSnapshotState;
		boolean oldDesiredSnapshotStateESet = desiredSnapshotStateESet;
		desiredSnapshotState = DESIRED_SNAPSHOT_STATE_EDEFAULT;
		desiredSnapshotStateESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__DESIRED_SNAPSHOT_STATE, oldDesiredSnapshotState, DESIRED_SNAPSHOT_STATE_EDEFAULT, oldDesiredSnapshotStateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDesiredSnapshotState() {
		return desiredSnapshotStateESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilename(String newFilename) {
		String oldFilename = filename;
		filename = newFilename;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__FILENAME, oldFilename, filename));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumDisks() {
		return numDisks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumDisks(int newNumDisks) {
		int oldNumDisks = numDisks;
		numDisks = newNumDisks;
		boolean oldNumDisksESet = numDisksESet;
		numDisksESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__NUM_DISKS, oldNumDisks, numDisks, !oldNumDisksESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetNumDisks() {
		int oldNumDisks = numDisks;
		boolean oldNumDisksESet = numDisksESet;
		numDisks = NUM_DISKS_EDEFAULT;
		numDisksESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__NUM_DISKS, oldNumDisks, NUM_DISKS_EDEFAULT, oldNumDisksESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetNumDisks() {
		return numDisksESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getParentSnapshotUid() {
		return parentSnapshotUid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentSnapshotUid(String newParentSnapshotUid) {
		String oldParentSnapshotUid = parentSnapshotUid;
		parentSnapshotUid = newParentSnapshotUid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__PARENT_SNAPSHOT_UID, oldParentSnapshotUid, parentSnapshotUid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSnapshotType() {
		return snapshotType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSnapshotType(String newSnapshotType) {
		String oldSnapshotType = snapshotType;
		snapshotType = newSnapshotType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__SNAPSHOT_TYPE, oldSnapshotType, snapshotType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUid(String newUid) {
		String oldUid = uid;
		uid = newUid;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__UID, oldUid, uid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__CREATE_TIME_HIGH:
				return new Long(getCreateTimeHigh());
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__CREATE_TIME_LOW:
				return new Long(getCreateTimeLow());
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__CURRENT:
				return isCurrent() ? Boolean.TRUE : Boolean.FALSE;
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__DESIRED_SNAPSHOT_STATE:
				return getDesiredSnapshotState();
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__FILENAME:
				return getFilename();
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__NUM_DISKS:
				return new Integer(getNumDisks());
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__PARENT_SNAPSHOT_UID:
				return getParentSnapshotUid();
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__SNAPSHOT_TYPE:
				return getSnapshotType();
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__UID:
				return getUid();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__CREATE_TIME_HIGH:
				setCreateTimeHigh(((Long)newValue).longValue());
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__CREATE_TIME_LOW:
				setCreateTimeLow(((Long)newValue).longValue());
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__CURRENT:
				setCurrent(((Boolean)newValue).booleanValue());
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__DESIRED_SNAPSHOT_STATE:
				setDesiredSnapshotState((DesiredSnapshotStateType)newValue);
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__FILENAME:
				setFilename((String)newValue);
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__NUM_DISKS:
				setNumDisks(((Integer)newValue).intValue());
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__PARENT_SNAPSHOT_UID:
				setParentSnapshotUid((String)newValue);
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__SNAPSHOT_TYPE:
				setSnapshotType((String)newValue);
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__UID:
				setUid((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__CREATE_TIME_HIGH:
				unsetCreateTimeHigh();
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__CREATE_TIME_LOW:
				unsetCreateTimeLow();
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__CURRENT:
				unsetCurrent();
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__DESIRED_SNAPSHOT_STATE:
				unsetDesiredSnapshotState();
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__FILENAME:
				setFilename(FILENAME_EDEFAULT);
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__NUM_DISKS:
				unsetNumDisks();
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__PARENT_SNAPSHOT_UID:
				setParentSnapshotUid(PARENT_SNAPSHOT_UID_EDEFAULT);
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__SNAPSHOT_TYPE:
				setSnapshotType(SNAPSHOT_TYPE_EDEFAULT);
				return;
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__UID:
				setUid(UID_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__CREATE_TIME_HIGH:
				return isSetCreateTimeHigh();
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__CREATE_TIME_LOW:
				return isSetCreateTimeLow();
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__CURRENT:
				return isSetCurrent();
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__DESIRED_SNAPSHOT_STATE:
				return isSetDesiredSnapshotState();
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__FILENAME:
				return FILENAME_EDEFAULT == null ? filename != null : !FILENAME_EDEFAULT.equals(filename);
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__NUM_DISKS:
				return isSetNumDisks();
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__PARENT_SNAPSHOT_UID:
				return PARENT_SNAPSHOT_UID_EDEFAULT == null ? parentSnapshotUid != null : !PARENT_SNAPSHOT_UID_EDEFAULT.equals(parentSnapshotUid);
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__SNAPSHOT_TYPE:
				return SNAPSHOT_TYPE_EDEFAULT == null ? snapshotType != null : !SNAPSHOT_TYPE_EDEFAULT.equals(snapshotType);
			case VirtualizationPackage.VMWARE_VIRTUAL_SERVER_SNAPSHOT__UID:
				return UID_EDEFAULT == null ? uid != null : !UID_EDEFAULT.equals(uid);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (createTimeHigh: "); //$NON-NLS-1$
		if (createTimeHighESet) result.append(createTimeHigh); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", createTimeLow: "); //$NON-NLS-1$
		if (createTimeLowESet) result.append(createTimeLow); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", current: "); //$NON-NLS-1$
		if (currentESet) result.append(current); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", desiredSnapshotState: "); //$NON-NLS-1$
		if (desiredSnapshotStateESet) result.append(desiredSnapshotState); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", filename: "); //$NON-NLS-1$
		result.append(filename);
		result.append(", numDisks: "); //$NON-NLS-1$
		if (numDisksESet) result.append(numDisks); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", parentSnapshotUid: "); //$NON-NLS-1$
		result.append(parentSnapshotUid);
		result.append(", snapshotType: "); //$NON-NLS-1$
		result.append(snapshotType);
		result.append(", uid: "); //$NON-NLS-1$
		result.append(uid);
		result.append(')');
		return result.toString();
	}

} //VMwareVirtualServerSnapshotImpl
