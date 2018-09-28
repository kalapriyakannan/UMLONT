/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.ServiceImpl;
import com.ibm.ccl.soa.deploy.j2ee.EnterpriseBeanService;
import com.ibm.ccl.soa.deploy.j2ee.J2eePackage;
import com.ibm.ccl.soa.deploy.j2ee.JavaInterface;
import com.ibm.ccl.soa.deploy.j2ee.Vicinity;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Enterprise Bean Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.EnterpriseBeanServiceImpl#getHomeInterface <em>Home Interface</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.EnterpriseBeanServiceImpl#getEjbName <em>Ejb Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.EnterpriseBeanServiceImpl#getJndiName <em>Jndi Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.j2ee.impl.EnterpriseBeanServiceImpl#getVicinity <em>Vicinity</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnterpriseBeanServiceImpl extends ServiceImpl implements EnterpriseBeanService {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getHomeInterface() <em>Home Interface</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getHomeInterface()
	 * @generated
	 * @ordered
	 */
	protected JavaInterface homeInterface;

	/**
	 * The default value of the '{@link #getEjbName() <em>Ejb Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getEjbName()
	 * @generated
	 * @ordered
	 */
	protected static final String EJB_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEjbName() <em>Ejb Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getEjbName()
	 * @generated
	 * @ordered
	 */
	protected String ejbName = EJB_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getJndiName() <em>Jndi Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getJndiName()
	 * @generated
	 * @ordered
	 */
	protected static final String JNDI_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJndiName() <em>Jndi Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getJndiName()
	 * @generated
	 * @ordered
	 */
	protected String jndiName = JNDI_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getVicinity() <em>Vicinity</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getVicinity()
	 * @generated
	 * @ordered
	 */
	protected static final Vicinity VICINITY_EDEFAULT = Vicinity.LOCAL_LITERAL;

	/**
	 * The cached value of the '{@link #getVicinity() <em>Vicinity</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getVicinity()
	 * @generated
	 * @ordered
	 */
	protected Vicinity vicinity = VICINITY_EDEFAULT;

	/**
	 * This is true if the Vicinity attribute has been set. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean vicinityESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EnterpriseBeanServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return J2eePackage.Literals.ENTERPRISE_BEAN_SERVICE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public JavaInterface getHomeInterface() {
		return homeInterface;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHomeInterface(JavaInterface newHomeInterface,
			NotificationChain msgs) {
		JavaInterface oldHomeInterface = homeInterface;
		homeInterface = newHomeInterface;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					J2eePackage.ENTERPRISE_BEAN_SERVICE__HOME_INTERFACE, oldHomeInterface,
					newHomeInterface);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHomeInterface(JavaInterface newHomeInterface) {
		if (newHomeInterface != homeInterface) {
			NotificationChain msgs = null;
			if (homeInterface != null)
				msgs = ((InternalEObject) homeInterface).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- J2eePackage.ENTERPRISE_BEAN_SERVICE__HOME_INTERFACE, null, msgs);
			if (newHomeInterface != null)
				msgs = ((InternalEObject) newHomeInterface).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- J2eePackage.ENTERPRISE_BEAN_SERVICE__HOME_INTERFACE, null, msgs);
			msgs = basicSetHomeInterface(newHomeInterface, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					J2eePackage.ENTERPRISE_BEAN_SERVICE__HOME_INTERFACE, newHomeInterface,
					newHomeInterface));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getEjbName() {
		return ejbName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setEjbName(String newEjbName) {
		String oldEjbName = ejbName;
		ejbName = newEjbName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					J2eePackage.ENTERPRISE_BEAN_SERVICE__EJB_NAME, oldEjbName, ejbName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getJndiName() {
		return jndiName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setJndiName(String newJndiName) {
		String oldJndiName = jndiName;
		jndiName = newJndiName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					J2eePackage.ENTERPRISE_BEAN_SERVICE__JNDI_NAME, oldJndiName, jndiName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Vicinity getVicinity() {
		return vicinity;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setVicinity(Vicinity newVicinity) {
		Vicinity oldVicinity = vicinity;
		vicinity = newVicinity == null ? VICINITY_EDEFAULT : newVicinity;
		boolean oldVicinityESet = vicinityESet;
		vicinityESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					J2eePackage.ENTERPRISE_BEAN_SERVICE__VICINITY, oldVicinity, vicinity,
					!oldVicinityESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetVicinity() {
		Vicinity oldVicinity = vicinity;
		boolean oldVicinityESet = vicinityESet;
		vicinity = VICINITY_EDEFAULT;
		vicinityESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					J2eePackage.ENTERPRISE_BEAN_SERVICE__VICINITY, oldVicinity, VICINITY_EDEFAULT,
					oldVicinityESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetVicinity() {
		return vicinityESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID)
		{
		case J2eePackage.ENTERPRISE_BEAN_SERVICE__HOME_INTERFACE:
			return basicSetHomeInterface(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case J2eePackage.ENTERPRISE_BEAN_SERVICE__HOME_INTERFACE:
			return getHomeInterface();
		case J2eePackage.ENTERPRISE_BEAN_SERVICE__EJB_NAME:
			return getEjbName();
		case J2eePackage.ENTERPRISE_BEAN_SERVICE__JNDI_NAME:
			return getJndiName();
		case J2eePackage.ENTERPRISE_BEAN_SERVICE__VICINITY:
			return getVicinity();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
		case J2eePackage.ENTERPRISE_BEAN_SERVICE__HOME_INTERFACE:
			setHomeInterface((JavaInterface) newValue);
			return;
		case J2eePackage.ENTERPRISE_BEAN_SERVICE__EJB_NAME:
			setEjbName((String) newValue);
			return;
		case J2eePackage.ENTERPRISE_BEAN_SERVICE__JNDI_NAME:
			setJndiName((String) newValue);
			return;
		case J2eePackage.ENTERPRISE_BEAN_SERVICE__VICINITY:
			setVicinity((Vicinity) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID)
		{
		case J2eePackage.ENTERPRISE_BEAN_SERVICE__HOME_INTERFACE:
			setHomeInterface((JavaInterface) null);
			return;
		case J2eePackage.ENTERPRISE_BEAN_SERVICE__EJB_NAME:
			setEjbName(EJB_NAME_EDEFAULT);
			return;
		case J2eePackage.ENTERPRISE_BEAN_SERVICE__JNDI_NAME:
			setJndiName(JNDI_NAME_EDEFAULT);
			return;
		case J2eePackage.ENTERPRISE_BEAN_SERVICE__VICINITY:
			unsetVicinity();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
		case J2eePackage.ENTERPRISE_BEAN_SERVICE__HOME_INTERFACE:
			return homeInterface != null;
		case J2eePackage.ENTERPRISE_BEAN_SERVICE__EJB_NAME:
			return EJB_NAME_EDEFAULT == null ? ejbName != null : !EJB_NAME_EDEFAULT.equals(ejbName);
		case J2eePackage.ENTERPRISE_BEAN_SERVICE__JNDI_NAME:
			return JNDI_NAME_EDEFAULT == null ? jndiName != null : !JNDI_NAME_EDEFAULT
					.equals(jndiName);
		case J2eePackage.ENTERPRISE_BEAN_SERVICE__VICINITY:
			return isSetVicinity();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (ejbName: "); //$NON-NLS-1$
		result.append(ejbName);
		result.append(", jndiName: "); //$NON-NLS-1$
		result.append(jndiName);
		result.append(", vicinity: "); //$NON-NLS-1$
		if (vicinityESet)
			result.append(vicinity);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //EnterpriseBeanServiceImpl
