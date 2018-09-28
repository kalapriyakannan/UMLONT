/**
 * <copyright>
 * </copyright>
 *
 * $Id: PeakLoadConstraintImpl.java,v 1.2 2007/12/07 18:23:44 nmakin Exp $
 */
package com.ibm.ccl.soa.deploy.analysis.impl;

import com.ibm.ccl.soa.deploy.analysis.AnalysisPackage;
import com.ibm.ccl.soa.deploy.analysis.PeakLoadConstraint;

import java.math.BigInteger;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Peak Load Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.impl.PeakLoadConstraintImpl#getPeakLoad <em>Peak Load</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PeakLoadConstraintImpl extends AnalysisConstraintImpl implements PeakLoadConstraint {
	/**
	 * The default value of the '{@link #getPeakLoad() <em>Peak Load</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeakLoad()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger PEAK_LOAD_EDEFAULT = new BigInteger("10000"); //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getPeakLoad() <em>Peak Load</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeakLoad()
	 * @generated
	 * @ordered
	 */
	protected BigInteger peakLoad = PEAK_LOAD_EDEFAULT;

	/**
	 * This is true if the Peak Load attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean peakLoadESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PeakLoadConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return AnalysisPackage.Literals.PEAK_LOAD_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getPeakLoad() {
		return peakLoad;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPeakLoad(BigInteger newPeakLoad) {
		BigInteger oldPeakLoad = peakLoad;
		peakLoad = newPeakLoad;
		boolean oldPeakLoadESet = peakLoadESet;
		peakLoadESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalysisPackage.PEAK_LOAD_CONSTRAINT__PEAK_LOAD, oldPeakLoad, peakLoad, !oldPeakLoadESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPeakLoad() {
		BigInteger oldPeakLoad = peakLoad;
		boolean oldPeakLoadESet = peakLoadESet;
		peakLoad = PEAK_LOAD_EDEFAULT;
		peakLoadESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, AnalysisPackage.PEAK_LOAD_CONSTRAINT__PEAK_LOAD, oldPeakLoad, PEAK_LOAD_EDEFAULT, oldPeakLoadESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPeakLoad() {
		return peakLoadESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AnalysisPackage.PEAK_LOAD_CONSTRAINT__PEAK_LOAD:
				return getPeakLoad();
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
			case AnalysisPackage.PEAK_LOAD_CONSTRAINT__PEAK_LOAD:
				setPeakLoad((BigInteger)newValue);
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
			case AnalysisPackage.PEAK_LOAD_CONSTRAINT__PEAK_LOAD:
				unsetPeakLoad();
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
			case AnalysisPackage.PEAK_LOAD_CONSTRAINT__PEAK_LOAD:
				return isSetPeakLoad();
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
		result.append(" (peakLoad: "); //$NON-NLS-1$
		if (peakLoadESet) result.append(peakLoad); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //PeakLoadConstraintImpl
