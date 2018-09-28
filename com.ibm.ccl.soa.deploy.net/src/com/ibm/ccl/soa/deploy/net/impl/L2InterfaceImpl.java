/**
 * <copyright>
 * </copyright>
 *
 * $Id: L2InterfaceImpl.java,v 1.1 2008/02/01 18:53:29 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.net.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.net.DuplexType;
import com.ibm.ccl.soa.deploy.net.L2Interface;
import com.ibm.ccl.soa.deploy.net.NetPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>L2 Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.impl.L2InterfaceImpl#isAutoNegotiation <em>Auto Negotiation</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.impl.L2InterfaceImpl#isBroadcast <em>Broadcast</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.impl.L2InterfaceImpl#getDuplex <em>Duplex</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.impl.L2InterfaceImpl#getEncapsulation <em>Encapsulation</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.impl.L2InterfaceImpl#getHwAddress <em>Hw Address</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.impl.L2InterfaceImpl#getIndex <em>Index</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.impl.L2InterfaceImpl#getL2InterfaceName <em>L2 Interface Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.impl.L2InterfaceImpl#isLoopback <em>Loopback</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.impl.L2InterfaceImpl#getMtu <em>Mtu</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.impl.L2InterfaceImpl#isPrivate <em>Private</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.impl.L2InterfaceImpl#isPromiscuous <em>Promiscuous</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.net.impl.L2InterfaceImpl#getSpeed <em>Speed</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class L2InterfaceImpl extends CapabilityImpl implements L2Interface {
	/**
	 * The default value of the '{@link #isAutoNegotiation() <em>Auto Negotiation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAutoNegotiation()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AUTO_NEGOTIATION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAutoNegotiation() <em>Auto Negotiation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAutoNegotiation()
	 * @generated
	 * @ordered
	 */
	protected boolean autoNegotiation = AUTO_NEGOTIATION_EDEFAULT;

	/**
	 * This is true if the Auto Negotiation attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean autoNegotiationESet;

	/**
	 * The default value of the '{@link #isBroadcast() <em>Broadcast</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBroadcast()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BROADCAST_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBroadcast() <em>Broadcast</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBroadcast()
	 * @generated
	 * @ordered
	 */
	protected boolean broadcast = BROADCAST_EDEFAULT;

	/**
	 * This is true if the Broadcast attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean broadcastESet;

	/**
	 * The default value of the '{@link #getDuplex() <em>Duplex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuplex()
	 * @generated
	 * @ordered
	 */
	protected static final DuplexType DUPLEX_EDEFAULT = DuplexType.HALF_DUPLEX_LITERAL;

	/**
	 * The cached value of the '{@link #getDuplex() <em>Duplex</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuplex()
	 * @generated
	 * @ordered
	 */
	protected DuplexType duplex = DUPLEX_EDEFAULT;

	/**
	 * This is true if the Duplex attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean duplexESet;

	/**
	 * The default value of the '{@link #getEncapsulation() <em>Encapsulation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEncapsulation()
	 * @generated
	 * @ordered
	 */
	protected static final String ENCAPSULATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEncapsulation() <em>Encapsulation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEncapsulation()
	 * @generated
	 * @ordered
	 */
	protected String encapsulation = ENCAPSULATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getHwAddress() <em>Hw Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHwAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String HW_ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHwAddress() <em>Hw Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHwAddress()
	 * @generated
	 * @ordered
	 */
	protected String hwAddress = HW_ADDRESS_EDEFAULT;

	/**
	 * The default value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected int index = INDEX_EDEFAULT;

	/**
	 * This is true if the Index attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean indexESet;

	/**
	 * The default value of the '{@link #getL2InterfaceName() <em>L2 Interface Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2InterfaceName()
	 * @generated
	 * @ordered
	 */
	protected static final String L2_INTERFACE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getL2InterfaceName() <em>L2 Interface Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getL2InterfaceName()
	 * @generated
	 * @ordered
	 */
	protected String l2InterfaceName = L2_INTERFACE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #isLoopback() <em>Loopback</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLoopback()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOOPBACK_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isLoopback() <em>Loopback</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLoopback()
	 * @generated
	 * @ordered
	 */
	protected boolean loopback = LOOPBACK_EDEFAULT;

	/**
	 * This is true if the Loopback attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean loopbackESet;

	/**
	 * The default value of the '{@link #getMtu() <em>Mtu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMtu()
	 * @generated
	 * @ordered
	 */
	protected static final int MTU_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMtu() <em>Mtu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMtu()
	 * @generated
	 * @ordered
	 */
	protected int mtu = MTU_EDEFAULT;

	/**
	 * This is true if the Mtu attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean mtuESet;

	/**
	 * The default value of the '{@link #isPrivate() <em>Private</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrivate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PRIVATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPrivate() <em>Private</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPrivate()
	 * @generated
	 * @ordered
	 */
	protected boolean private_ = PRIVATE_EDEFAULT;

	/**
	 * This is true if the Private attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean privateESet;

	/**
	 * The default value of the '{@link #isPromiscuous() <em>Promiscuous</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPromiscuous()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PROMISCUOUS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPromiscuous() <em>Promiscuous</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPromiscuous()
	 * @generated
	 * @ordered
	 */
	protected boolean promiscuous = PROMISCUOUS_EDEFAULT;

	/**
	 * This is true if the Promiscuous attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean promiscuousESet;

	/**
	 * The default value of the '{@link #getSpeed() <em>Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeed()
	 * @generated
	 * @ordered
	 */
	protected static final long SPEED_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getSpeed() <em>Speed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpeed()
	 * @generated
	 * @ordered
	 */
	protected long speed = SPEED_EDEFAULT;

	/**
	 * This is true if the Speed attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean speedESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected L2InterfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return NetPackage.Literals.L2_INTERFACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAutoNegotiation() {
		return autoNegotiation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAutoNegotiation(boolean newAutoNegotiation) {
		boolean oldAutoNegotiation = autoNegotiation;
		autoNegotiation = newAutoNegotiation;
		boolean oldAutoNegotiationESet = autoNegotiationESet;
		autoNegotiationESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetPackage.L2_INTERFACE__AUTO_NEGOTIATION, oldAutoNegotiation, autoNegotiation, !oldAutoNegotiationESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetAutoNegotiation() {
		boolean oldAutoNegotiation = autoNegotiation;
		boolean oldAutoNegotiationESet = autoNegotiationESet;
		autoNegotiation = AUTO_NEGOTIATION_EDEFAULT;
		autoNegotiationESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, NetPackage.L2_INTERFACE__AUTO_NEGOTIATION, oldAutoNegotiation, AUTO_NEGOTIATION_EDEFAULT, oldAutoNegotiationESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetAutoNegotiation() {
		return autoNegotiationESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBroadcast() {
		return broadcast;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBroadcast(boolean newBroadcast) {
		boolean oldBroadcast = broadcast;
		broadcast = newBroadcast;
		boolean oldBroadcastESet = broadcastESet;
		broadcastESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetPackage.L2_INTERFACE__BROADCAST, oldBroadcast, broadcast, !oldBroadcastESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBroadcast() {
		boolean oldBroadcast = broadcast;
		boolean oldBroadcastESet = broadcastESet;
		broadcast = BROADCAST_EDEFAULT;
		broadcastESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, NetPackage.L2_INTERFACE__BROADCAST, oldBroadcast, BROADCAST_EDEFAULT, oldBroadcastESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBroadcast() {
		return broadcastESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DuplexType getDuplex() {
		return duplex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDuplex(DuplexType newDuplex) {
		DuplexType oldDuplex = duplex;
		duplex = newDuplex == null ? DUPLEX_EDEFAULT : newDuplex;
		boolean oldDuplexESet = duplexESet;
		duplexESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetPackage.L2_INTERFACE__DUPLEX, oldDuplex, duplex, !oldDuplexESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDuplex() {
		DuplexType oldDuplex = duplex;
		boolean oldDuplexESet = duplexESet;
		duplex = DUPLEX_EDEFAULT;
		duplexESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, NetPackage.L2_INTERFACE__DUPLEX, oldDuplex, DUPLEX_EDEFAULT, oldDuplexESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDuplex() {
		return duplexESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEncapsulation() {
		return encapsulation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEncapsulation(String newEncapsulation) {
		String oldEncapsulation = encapsulation;
		encapsulation = newEncapsulation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetPackage.L2_INTERFACE__ENCAPSULATION, oldEncapsulation, encapsulation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHwAddress() {
		return hwAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHwAddress(String newHwAddress) {
		String oldHwAddress = hwAddress;
		hwAddress = newHwAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetPackage.L2_INTERFACE__HW_ADDRESS, oldHwAddress, hwAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndex(int newIndex) {
		int oldIndex = index;
		index = newIndex;
		boolean oldIndexESet = indexESet;
		indexESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetPackage.L2_INTERFACE__INDEX, oldIndex, index, !oldIndexESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIndex() {
		int oldIndex = index;
		boolean oldIndexESet = indexESet;
		index = INDEX_EDEFAULT;
		indexESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, NetPackage.L2_INTERFACE__INDEX, oldIndex, INDEX_EDEFAULT, oldIndexESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIndex() {
		return indexESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getL2InterfaceName() {
		return l2InterfaceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setL2InterfaceName(String newL2InterfaceName) {
		String oldL2InterfaceName = l2InterfaceName;
		l2InterfaceName = newL2InterfaceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetPackage.L2_INTERFACE__L2_INTERFACE_NAME, oldL2InterfaceName, l2InterfaceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLoopback() {
		return loopback;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoopback(boolean newLoopback) {
		boolean oldLoopback = loopback;
		loopback = newLoopback;
		boolean oldLoopbackESet = loopbackESet;
		loopbackESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetPackage.L2_INTERFACE__LOOPBACK, oldLoopback, loopback, !oldLoopbackESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLoopback() {
		boolean oldLoopback = loopback;
		boolean oldLoopbackESet = loopbackESet;
		loopback = LOOPBACK_EDEFAULT;
		loopbackESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, NetPackage.L2_INTERFACE__LOOPBACK, oldLoopback, LOOPBACK_EDEFAULT, oldLoopbackESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLoopback() {
		return loopbackESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMtu() {
		return mtu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMtu(int newMtu) {
		int oldMtu = mtu;
		mtu = newMtu;
		boolean oldMtuESet = mtuESet;
		mtuESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetPackage.L2_INTERFACE__MTU, oldMtu, mtu, !oldMtuESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMtu() {
		int oldMtu = mtu;
		boolean oldMtuESet = mtuESet;
		mtu = MTU_EDEFAULT;
		mtuESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, NetPackage.L2_INTERFACE__MTU, oldMtu, MTU_EDEFAULT, oldMtuESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMtu() {
		return mtuESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPrivate() {
		return private_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrivate(boolean newPrivate) {
		boolean oldPrivate = private_;
		private_ = newPrivate;
		boolean oldPrivateESet = privateESet;
		privateESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetPackage.L2_INTERFACE__PRIVATE, oldPrivate, private_, !oldPrivateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPrivate() {
		boolean oldPrivate = private_;
		boolean oldPrivateESet = privateESet;
		private_ = PRIVATE_EDEFAULT;
		privateESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, NetPackage.L2_INTERFACE__PRIVATE, oldPrivate, PRIVATE_EDEFAULT, oldPrivateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPrivate() {
		return privateESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPromiscuous() {
		return promiscuous;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPromiscuous(boolean newPromiscuous) {
		boolean oldPromiscuous = promiscuous;
		promiscuous = newPromiscuous;
		boolean oldPromiscuousESet = promiscuousESet;
		promiscuousESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetPackage.L2_INTERFACE__PROMISCUOUS, oldPromiscuous, promiscuous, !oldPromiscuousESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPromiscuous() {
		boolean oldPromiscuous = promiscuous;
		boolean oldPromiscuousESet = promiscuousESet;
		promiscuous = PROMISCUOUS_EDEFAULT;
		promiscuousESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, NetPackage.L2_INTERFACE__PROMISCUOUS, oldPromiscuous, PROMISCUOUS_EDEFAULT, oldPromiscuousESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPromiscuous() {
		return promiscuousESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getSpeed() {
		return speed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpeed(long newSpeed) {
		long oldSpeed = speed;
		speed = newSpeed;
		boolean oldSpeedESet = speedESet;
		speedESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetPackage.L2_INTERFACE__SPEED, oldSpeed, speed, !oldSpeedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSpeed() {
		long oldSpeed = speed;
		boolean oldSpeedESet = speedESet;
		speed = SPEED_EDEFAULT;
		speedESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, NetPackage.L2_INTERFACE__SPEED, oldSpeed, SPEED_EDEFAULT, oldSpeedESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSpeed() {
		return speedESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NetPackage.L2_INTERFACE__AUTO_NEGOTIATION:
				return isAutoNegotiation() ? Boolean.TRUE : Boolean.FALSE;
			case NetPackage.L2_INTERFACE__BROADCAST:
				return isBroadcast() ? Boolean.TRUE : Boolean.FALSE;
			case NetPackage.L2_INTERFACE__DUPLEX:
				return getDuplex();
			case NetPackage.L2_INTERFACE__ENCAPSULATION:
				return getEncapsulation();
			case NetPackage.L2_INTERFACE__HW_ADDRESS:
				return getHwAddress();
			case NetPackage.L2_INTERFACE__INDEX:
				return new Integer(getIndex());
			case NetPackage.L2_INTERFACE__L2_INTERFACE_NAME:
				return getL2InterfaceName();
			case NetPackage.L2_INTERFACE__LOOPBACK:
				return isLoopback() ? Boolean.TRUE : Boolean.FALSE;
			case NetPackage.L2_INTERFACE__MTU:
				return new Integer(getMtu());
			case NetPackage.L2_INTERFACE__PRIVATE:
				return isPrivate() ? Boolean.TRUE : Boolean.FALSE;
			case NetPackage.L2_INTERFACE__PROMISCUOUS:
				return isPromiscuous() ? Boolean.TRUE : Boolean.FALSE;
			case NetPackage.L2_INTERFACE__SPEED:
				return new Long(getSpeed());
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
			case NetPackage.L2_INTERFACE__AUTO_NEGOTIATION:
				setAutoNegotiation(((Boolean)newValue).booleanValue());
				return;
			case NetPackage.L2_INTERFACE__BROADCAST:
				setBroadcast(((Boolean)newValue).booleanValue());
				return;
			case NetPackage.L2_INTERFACE__DUPLEX:
				setDuplex((DuplexType)newValue);
				return;
			case NetPackage.L2_INTERFACE__ENCAPSULATION:
				setEncapsulation((String)newValue);
				return;
			case NetPackage.L2_INTERFACE__HW_ADDRESS:
				setHwAddress((String)newValue);
				return;
			case NetPackage.L2_INTERFACE__INDEX:
				setIndex(((Integer)newValue).intValue());
				return;
			case NetPackage.L2_INTERFACE__L2_INTERFACE_NAME:
				setL2InterfaceName((String)newValue);
				return;
			case NetPackage.L2_INTERFACE__LOOPBACK:
				setLoopback(((Boolean)newValue).booleanValue());
				return;
			case NetPackage.L2_INTERFACE__MTU:
				setMtu(((Integer)newValue).intValue());
				return;
			case NetPackage.L2_INTERFACE__PRIVATE:
				setPrivate(((Boolean)newValue).booleanValue());
				return;
			case NetPackage.L2_INTERFACE__PROMISCUOUS:
				setPromiscuous(((Boolean)newValue).booleanValue());
				return;
			case NetPackage.L2_INTERFACE__SPEED:
				setSpeed(((Long)newValue).longValue());
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
			case NetPackage.L2_INTERFACE__AUTO_NEGOTIATION:
				unsetAutoNegotiation();
				return;
			case NetPackage.L2_INTERFACE__BROADCAST:
				unsetBroadcast();
				return;
			case NetPackage.L2_INTERFACE__DUPLEX:
				unsetDuplex();
				return;
			case NetPackage.L2_INTERFACE__ENCAPSULATION:
				setEncapsulation(ENCAPSULATION_EDEFAULT);
				return;
			case NetPackage.L2_INTERFACE__HW_ADDRESS:
				setHwAddress(HW_ADDRESS_EDEFAULT);
				return;
			case NetPackage.L2_INTERFACE__INDEX:
				unsetIndex();
				return;
			case NetPackage.L2_INTERFACE__L2_INTERFACE_NAME:
				setL2InterfaceName(L2_INTERFACE_NAME_EDEFAULT);
				return;
			case NetPackage.L2_INTERFACE__LOOPBACK:
				unsetLoopback();
				return;
			case NetPackage.L2_INTERFACE__MTU:
				unsetMtu();
				return;
			case NetPackage.L2_INTERFACE__PRIVATE:
				unsetPrivate();
				return;
			case NetPackage.L2_INTERFACE__PROMISCUOUS:
				unsetPromiscuous();
				return;
			case NetPackage.L2_INTERFACE__SPEED:
				unsetSpeed();
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
			case NetPackage.L2_INTERFACE__AUTO_NEGOTIATION:
				return isSetAutoNegotiation();
			case NetPackage.L2_INTERFACE__BROADCAST:
				return isSetBroadcast();
			case NetPackage.L2_INTERFACE__DUPLEX:
				return isSetDuplex();
			case NetPackage.L2_INTERFACE__ENCAPSULATION:
				return ENCAPSULATION_EDEFAULT == null ? encapsulation != null : !ENCAPSULATION_EDEFAULT.equals(encapsulation);
			case NetPackage.L2_INTERFACE__HW_ADDRESS:
				return HW_ADDRESS_EDEFAULT == null ? hwAddress != null : !HW_ADDRESS_EDEFAULT.equals(hwAddress);
			case NetPackage.L2_INTERFACE__INDEX:
				return isSetIndex();
			case NetPackage.L2_INTERFACE__L2_INTERFACE_NAME:
				return L2_INTERFACE_NAME_EDEFAULT == null ? l2InterfaceName != null : !L2_INTERFACE_NAME_EDEFAULT.equals(l2InterfaceName);
			case NetPackage.L2_INTERFACE__LOOPBACK:
				return isSetLoopback();
			case NetPackage.L2_INTERFACE__MTU:
				return isSetMtu();
			case NetPackage.L2_INTERFACE__PRIVATE:
				return isSetPrivate();
			case NetPackage.L2_INTERFACE__PROMISCUOUS:
				return isSetPromiscuous();
			case NetPackage.L2_INTERFACE__SPEED:
				return isSetSpeed();
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
		result.append(" (autoNegotiation: "); //$NON-NLS-1$
		if (autoNegotiationESet) result.append(autoNegotiation); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", broadcast: "); //$NON-NLS-1$
		if (broadcastESet) result.append(broadcast); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", duplex: "); //$NON-NLS-1$
		if (duplexESet) result.append(duplex); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", encapsulation: "); //$NON-NLS-1$
		result.append(encapsulation);
		result.append(", hwAddress: "); //$NON-NLS-1$
		result.append(hwAddress);
		result.append(", index: "); //$NON-NLS-1$
		if (indexESet) result.append(index); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", l2InterfaceName: "); //$NON-NLS-1$
		result.append(l2InterfaceName);
		result.append(", loopback: "); //$NON-NLS-1$
		if (loopbackESet) result.append(loopback); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", mtu: "); //$NON-NLS-1$
		if (mtuESet) result.append(mtu); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", private: "); //$NON-NLS-1$
		if (privateESet) result.append(private_); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", promiscuous: "); //$NON-NLS-1$
		if (promiscuousESet) result.append(promiscuous); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", speed: "); //$NON-NLS-1$
		if (speedESet) result.append(speed); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //L2InterfaceImpl
