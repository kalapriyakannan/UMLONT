/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.db2high.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.db2high.DB2TableSpace;
import com.ibm.ccl.soa.deploy.db2high.Db2highPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DB2 Table Space</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2TableSpaceImpl#getAutoResize <em>Auto Resize</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2TableSpaceImpl#getDroppedTableRecovery <em>Dropped Table Recovery</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2TableSpaceImpl#getEventSize <em>Event Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2TableSpaceImpl#getFile <em>File</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2TableSpaceImpl#getIncreaseSize <em>Increase Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2TableSpaceImpl#getManagedBy <em>Managed By</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2TableSpaceImpl#getMaxSize <em>Max Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2TableSpaceImpl#getName1 <em>Name1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2TableSpaceImpl#getOverhead <em>Overhead</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2TableSpaceImpl#getPageSize <em>Page Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2TableSpaceImpl#getPrefetchSize <em>Prefetch Size</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2TableSpaceImpl#getTransferRate <em>Transfer Rate</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2TableSpaceImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DB2TableSpaceImpl extends CapabilityImpl implements DB2TableSpace {
	/**
	 * The default value of the '{@link #getAutoResize() <em>Auto Resize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAutoResize()
	 * @generated
	 * @ordered
	 */
	protected static final String AUTO_RESIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAutoResize() <em>Auto Resize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAutoResize()
	 * @generated
	 * @ordered
	 */
	protected String autoResize = AUTO_RESIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDroppedTableRecovery() <em>Dropped Table Recovery</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDroppedTableRecovery()
	 * @generated
	 * @ordered
	 */
	protected static final String DROPPED_TABLE_RECOVERY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDroppedTableRecovery() <em>Dropped Table Recovery</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDroppedTableRecovery()
	 * @generated
	 * @ordered
	 */
	protected String droppedTableRecovery = DROPPED_TABLE_RECOVERY_EDEFAULT;

	/**
	 * The default value of the '{@link #getEventSize() <em>Event Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventSize()
	 * @generated
	 * @ordered
	 */
	protected static final String EVENT_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEventSize() <em>Event Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventSize()
	 * @generated
	 * @ordered
	 */
	protected String eventSize = EVENT_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFile() <em>File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFile()
	 * @generated
	 * @ordered
	 */
	protected static final String FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFile() <em>File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFile()
	 * @generated
	 * @ordered
	 */
	protected String file = FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getIncreaseSize() <em>Increase Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncreaseSize()
	 * @generated
	 * @ordered
	 */
	protected static final String INCREASE_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIncreaseSize() <em>Increase Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncreaseSize()
	 * @generated
	 * @ordered
	 */
	protected String increaseSize = INCREASE_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getManagedBy() <em>Managed By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManagedBy()
	 * @generated
	 * @ordered
	 */
	protected static final String MANAGED_BY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getManagedBy() <em>Managed By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManagedBy()
	 * @generated
	 * @ordered
	 */
	protected String managedBy = MANAGED_BY_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxSize() <em>Max Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxSize()
	 * @generated
	 * @ordered
	 */
	protected static final String MAX_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMaxSize() <em>Max Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxSize()
	 * @generated
	 * @ordered
	 */
	protected String maxSize = MAX_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getName1() <em>Name1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName1()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName1() <em>Name1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName1()
	 * @generated
	 * @ordered
	 */
	protected String name1 = NAME1_EDEFAULT;

	/**
	 * The default value of the '{@link #getOverhead() <em>Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverhead()
	 * @generated
	 * @ordered
	 */
	protected static final String OVERHEAD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOverhead() <em>Overhead</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverhead()
	 * @generated
	 * @ordered
	 */
	protected String overhead = OVERHEAD_EDEFAULT;

	/**
	 * The default value of the '{@link #getPageSize() <em>Page Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageSize()
	 * @generated
	 * @ordered
	 */
	protected static final String PAGE_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPageSize() <em>Page Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPageSize()
	 * @generated
	 * @ordered
	 */
	protected String pageSize = PAGE_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPrefetchSize() <em>Prefetch Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrefetchSize()
	 * @generated
	 * @ordered
	 */
	protected static final String PREFETCH_SIZE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrefetchSize() <em>Prefetch Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrefetchSize()
	 * @generated
	 * @ordered
	 */
	protected String prefetchSize = PREFETCH_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransferRate() <em>Transfer Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransferRate()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSFER_RATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransferRate() <em>Transfer Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransferRate()
	 * @generated
	 * @ordered
	 */
	protected String transferRate = TRANSFER_RATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DB2TableSpaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Db2highPackage.Literals.DB2_TABLE_SPACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAutoResize() {
		return autoResize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAutoResize(String newAutoResize) {
		String oldAutoResize = autoResize;
		autoResize = newAutoResize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_TABLE_SPACE__AUTO_RESIZE, oldAutoResize, autoResize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDroppedTableRecovery() {
		return droppedTableRecovery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDroppedTableRecovery(String newDroppedTableRecovery) {
		String oldDroppedTableRecovery = droppedTableRecovery;
		droppedTableRecovery = newDroppedTableRecovery;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_TABLE_SPACE__DROPPED_TABLE_RECOVERY, oldDroppedTableRecovery, droppedTableRecovery));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEventSize() {
		return eventSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventSize(String newEventSize) {
		String oldEventSize = eventSize;
		eventSize = newEventSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_TABLE_SPACE__EVENT_SIZE, oldEventSize, eventSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFile() {
		return file;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFile(String newFile) {
		String oldFile = file;
		file = newFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_TABLE_SPACE__FILE, oldFile, file));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIncreaseSize() {
		return increaseSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncreaseSize(String newIncreaseSize) {
		String oldIncreaseSize = increaseSize;
		increaseSize = newIncreaseSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_TABLE_SPACE__INCREASE_SIZE, oldIncreaseSize, increaseSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getManagedBy() {
		return managedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setManagedBy(String newManagedBy) {
		String oldManagedBy = managedBy;
		managedBy = newManagedBy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_TABLE_SPACE__MANAGED_BY, oldManagedBy, managedBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMaxSize() {
		return maxSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxSize(String newMaxSize) {
		String oldMaxSize = maxSize;
		maxSize = newMaxSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_TABLE_SPACE__MAX_SIZE, oldMaxSize, maxSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName1() {
		return name1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName1(String newName1) {
		String oldName1 = name1;
		name1 = newName1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_TABLE_SPACE__NAME1, oldName1, name1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOverhead() {
		return overhead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOverhead(String newOverhead) {
		String oldOverhead = overhead;
		overhead = newOverhead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_TABLE_SPACE__OVERHEAD, oldOverhead, overhead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPageSize() {
		return pageSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPageSize(String newPageSize) {
		String oldPageSize = pageSize;
		pageSize = newPageSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_TABLE_SPACE__PAGE_SIZE, oldPageSize, pageSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPrefetchSize() {
		return prefetchSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrefetchSize(String newPrefetchSize) {
		String oldPrefetchSize = prefetchSize;
		prefetchSize = newPrefetchSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_TABLE_SPACE__PREFETCH_SIZE, oldPrefetchSize, prefetchSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransferRate() {
		return transferRate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransferRate(String newTransferRate) {
		String oldTransferRate = transferRate;
		transferRate = newTransferRate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_TABLE_SPACE__TRANSFER_RATE, oldTransferRate, transferRate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_TABLE_SPACE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Db2highPackage.DB2_TABLE_SPACE__AUTO_RESIZE:
				return getAutoResize();
			case Db2highPackage.DB2_TABLE_SPACE__DROPPED_TABLE_RECOVERY:
				return getDroppedTableRecovery();
			case Db2highPackage.DB2_TABLE_SPACE__EVENT_SIZE:
				return getEventSize();
			case Db2highPackage.DB2_TABLE_SPACE__FILE:
				return getFile();
			case Db2highPackage.DB2_TABLE_SPACE__INCREASE_SIZE:
				return getIncreaseSize();
			case Db2highPackage.DB2_TABLE_SPACE__MANAGED_BY:
				return getManagedBy();
			case Db2highPackage.DB2_TABLE_SPACE__MAX_SIZE:
				return getMaxSize();
			case Db2highPackage.DB2_TABLE_SPACE__NAME1:
				return getName1();
			case Db2highPackage.DB2_TABLE_SPACE__OVERHEAD:
				return getOverhead();
			case Db2highPackage.DB2_TABLE_SPACE__PAGE_SIZE:
				return getPageSize();
			case Db2highPackage.DB2_TABLE_SPACE__PREFETCH_SIZE:
				return getPrefetchSize();
			case Db2highPackage.DB2_TABLE_SPACE__TRANSFER_RATE:
				return getTransferRate();
			case Db2highPackage.DB2_TABLE_SPACE__TYPE:
				return getType();
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
			case Db2highPackage.DB2_TABLE_SPACE__AUTO_RESIZE:
				setAutoResize((String)newValue);
				return;
			case Db2highPackage.DB2_TABLE_SPACE__DROPPED_TABLE_RECOVERY:
				setDroppedTableRecovery((String)newValue);
				return;
			case Db2highPackage.DB2_TABLE_SPACE__EVENT_SIZE:
				setEventSize((String)newValue);
				return;
			case Db2highPackage.DB2_TABLE_SPACE__FILE:
				setFile((String)newValue);
				return;
			case Db2highPackage.DB2_TABLE_SPACE__INCREASE_SIZE:
				setIncreaseSize((String)newValue);
				return;
			case Db2highPackage.DB2_TABLE_SPACE__MANAGED_BY:
				setManagedBy((String)newValue);
				return;
			case Db2highPackage.DB2_TABLE_SPACE__MAX_SIZE:
				setMaxSize((String)newValue);
				return;
			case Db2highPackage.DB2_TABLE_SPACE__NAME1:
				setName1((String)newValue);
				return;
			case Db2highPackage.DB2_TABLE_SPACE__OVERHEAD:
				setOverhead((String)newValue);
				return;
			case Db2highPackage.DB2_TABLE_SPACE__PAGE_SIZE:
				setPageSize((String)newValue);
				return;
			case Db2highPackage.DB2_TABLE_SPACE__PREFETCH_SIZE:
				setPrefetchSize((String)newValue);
				return;
			case Db2highPackage.DB2_TABLE_SPACE__TRANSFER_RATE:
				setTransferRate((String)newValue);
				return;
			case Db2highPackage.DB2_TABLE_SPACE__TYPE:
				setType((String)newValue);
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
			case Db2highPackage.DB2_TABLE_SPACE__AUTO_RESIZE:
				setAutoResize(AUTO_RESIZE_EDEFAULT);
				return;
			case Db2highPackage.DB2_TABLE_SPACE__DROPPED_TABLE_RECOVERY:
				setDroppedTableRecovery(DROPPED_TABLE_RECOVERY_EDEFAULT);
				return;
			case Db2highPackage.DB2_TABLE_SPACE__EVENT_SIZE:
				setEventSize(EVENT_SIZE_EDEFAULT);
				return;
			case Db2highPackage.DB2_TABLE_SPACE__FILE:
				setFile(FILE_EDEFAULT);
				return;
			case Db2highPackage.DB2_TABLE_SPACE__INCREASE_SIZE:
				setIncreaseSize(INCREASE_SIZE_EDEFAULT);
				return;
			case Db2highPackage.DB2_TABLE_SPACE__MANAGED_BY:
				setManagedBy(MANAGED_BY_EDEFAULT);
				return;
			case Db2highPackage.DB2_TABLE_SPACE__MAX_SIZE:
				setMaxSize(MAX_SIZE_EDEFAULT);
				return;
			case Db2highPackage.DB2_TABLE_SPACE__NAME1:
				setName1(NAME1_EDEFAULT);
				return;
			case Db2highPackage.DB2_TABLE_SPACE__OVERHEAD:
				setOverhead(OVERHEAD_EDEFAULT);
				return;
			case Db2highPackage.DB2_TABLE_SPACE__PAGE_SIZE:
				setPageSize(PAGE_SIZE_EDEFAULT);
				return;
			case Db2highPackage.DB2_TABLE_SPACE__PREFETCH_SIZE:
				setPrefetchSize(PREFETCH_SIZE_EDEFAULT);
				return;
			case Db2highPackage.DB2_TABLE_SPACE__TRANSFER_RATE:
				setTransferRate(TRANSFER_RATE_EDEFAULT);
				return;
			case Db2highPackage.DB2_TABLE_SPACE__TYPE:
				setType(TYPE_EDEFAULT);
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
			case Db2highPackage.DB2_TABLE_SPACE__AUTO_RESIZE:
				return AUTO_RESIZE_EDEFAULT == null ? autoResize != null : !AUTO_RESIZE_EDEFAULT.equals(autoResize);
			case Db2highPackage.DB2_TABLE_SPACE__DROPPED_TABLE_RECOVERY:
				return DROPPED_TABLE_RECOVERY_EDEFAULT == null ? droppedTableRecovery != null : !DROPPED_TABLE_RECOVERY_EDEFAULT.equals(droppedTableRecovery);
			case Db2highPackage.DB2_TABLE_SPACE__EVENT_SIZE:
				return EVENT_SIZE_EDEFAULT == null ? eventSize != null : !EVENT_SIZE_EDEFAULT.equals(eventSize);
			case Db2highPackage.DB2_TABLE_SPACE__FILE:
				return FILE_EDEFAULT == null ? file != null : !FILE_EDEFAULT.equals(file);
			case Db2highPackage.DB2_TABLE_SPACE__INCREASE_SIZE:
				return INCREASE_SIZE_EDEFAULT == null ? increaseSize != null : !INCREASE_SIZE_EDEFAULT.equals(increaseSize);
			case Db2highPackage.DB2_TABLE_SPACE__MANAGED_BY:
				return MANAGED_BY_EDEFAULT == null ? managedBy != null : !MANAGED_BY_EDEFAULT.equals(managedBy);
			case Db2highPackage.DB2_TABLE_SPACE__MAX_SIZE:
				return MAX_SIZE_EDEFAULT == null ? maxSize != null : !MAX_SIZE_EDEFAULT.equals(maxSize);
			case Db2highPackage.DB2_TABLE_SPACE__NAME1:
				return NAME1_EDEFAULT == null ? name1 != null : !NAME1_EDEFAULT.equals(name1);
			case Db2highPackage.DB2_TABLE_SPACE__OVERHEAD:
				return OVERHEAD_EDEFAULT == null ? overhead != null : !OVERHEAD_EDEFAULT.equals(overhead);
			case Db2highPackage.DB2_TABLE_SPACE__PAGE_SIZE:
				return PAGE_SIZE_EDEFAULT == null ? pageSize != null : !PAGE_SIZE_EDEFAULT.equals(pageSize);
			case Db2highPackage.DB2_TABLE_SPACE__PREFETCH_SIZE:
				return PREFETCH_SIZE_EDEFAULT == null ? prefetchSize != null : !PREFETCH_SIZE_EDEFAULT.equals(prefetchSize);
			case Db2highPackage.DB2_TABLE_SPACE__TRANSFER_RATE:
				return TRANSFER_RATE_EDEFAULT == null ? transferRate != null : !TRANSFER_RATE_EDEFAULT.equals(transferRate);
			case Db2highPackage.DB2_TABLE_SPACE__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
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
		result.append(" (autoResize: "); //$NON-NLS-1$
		result.append(autoResize);
		result.append(", droppedTableRecovery: "); //$NON-NLS-1$
		result.append(droppedTableRecovery);
		result.append(", eventSize: "); //$NON-NLS-1$
		result.append(eventSize);
		result.append(", file: "); //$NON-NLS-1$
		result.append(file);
		result.append(", increaseSize: "); //$NON-NLS-1$
		result.append(increaseSize);
		result.append(", managedBy: "); //$NON-NLS-1$
		result.append(managedBy);
		result.append(", maxSize: "); //$NON-NLS-1$
		result.append(maxSize);
		result.append(", name1: "); //$NON-NLS-1$
		result.append(name1);
		result.append(", overhead: "); //$NON-NLS-1$
		result.append(overhead);
		result.append(", pageSize: "); //$NON-NLS-1$
		result.append(pageSize);
		result.append(", prefetchSize: "); //$NON-NLS-1$
		result.append(prefetchSize);
		result.append(", transferRate: "); //$NON-NLS-1$
		result.append(transferRate);
		result.append(", type: "); //$NON-NLS-1$
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //DB2TableSpaceImpl
