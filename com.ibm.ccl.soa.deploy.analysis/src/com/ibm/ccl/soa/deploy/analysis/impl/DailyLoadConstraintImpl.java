/**
 * <copyright>
 * </copyright>
 *
 * $Id: DailyLoadConstraintImpl.java,v 1.2 2007/12/07 18:23:44 nmakin Exp $
 */
package com.ibm.ccl.soa.deploy.analysis.impl;

import com.ibm.ccl.soa.deploy.analysis.AnalysisPackage;
import com.ibm.ccl.soa.deploy.analysis.DailyLoadConstraint;

import java.math.BigInteger;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Daily Load Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.impl.DailyLoadConstraintImpl#getDailyLoad <em>Daily Load</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DailyLoadConstraintImpl extends AnalysisConstraintImpl implements DailyLoadConstraint {
	/**
	 * The default value of the '{@link #getDailyLoad() <em>Daily Load</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDailyLoad()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger DAILY_LOAD_EDEFAULT = new BigInteger("1000"); //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getDailyLoad() <em>Daily Load</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDailyLoad()
	 * @generated
	 * @ordered
	 */
	protected BigInteger dailyLoad = DAILY_LOAD_EDEFAULT;

	/**
	 * This is true if the Daily Load attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean dailyLoadESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DailyLoadConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return AnalysisPackage.Literals.DAILY_LOAD_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getDailyLoad() {
		return dailyLoad;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDailyLoad(BigInteger newDailyLoad) {
		BigInteger oldDailyLoad = dailyLoad;
		dailyLoad = newDailyLoad;
		boolean oldDailyLoadESet = dailyLoadESet;
		dailyLoadESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalysisPackage.DAILY_LOAD_CONSTRAINT__DAILY_LOAD, oldDailyLoad, dailyLoad, !oldDailyLoadESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDailyLoad() {
		BigInteger oldDailyLoad = dailyLoad;
		boolean oldDailyLoadESet = dailyLoadESet;
		dailyLoad = DAILY_LOAD_EDEFAULT;
		dailyLoadESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, AnalysisPackage.DAILY_LOAD_CONSTRAINT__DAILY_LOAD, oldDailyLoad, DAILY_LOAD_EDEFAULT, oldDailyLoadESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDailyLoad() {
		return dailyLoadESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AnalysisPackage.DAILY_LOAD_CONSTRAINT__DAILY_LOAD:
				return getDailyLoad();
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
			case AnalysisPackage.DAILY_LOAD_CONSTRAINT__DAILY_LOAD:
				setDailyLoad((BigInteger)newValue);
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
			case AnalysisPackage.DAILY_LOAD_CONSTRAINT__DAILY_LOAD:
				unsetDailyLoad();
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
			case AnalysisPackage.DAILY_LOAD_CONSTRAINT__DAILY_LOAD:
				return isSetDailyLoad();
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
		result.append(" (dailyLoad: "); //$NON-NLS-1$
		if (dailyLoadESet) result.append(dailyLoad); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //DailyLoadConstraintImpl
