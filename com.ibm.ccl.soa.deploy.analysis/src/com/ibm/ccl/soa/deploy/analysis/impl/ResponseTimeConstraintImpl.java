/**
 * <copyright>
 * </copyright>
 *
 * $Id: ResponseTimeConstraintImpl.java,v 1.3 2007/12/13 17:55:28 nmakin Exp $
 */
package com.ibm.ccl.soa.deploy.analysis.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.analysis.AnalysisPackage;
import com.ibm.ccl.soa.deploy.analysis.ResponseTimeConstraint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Response Time Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.impl.ResponseTimeConstraintImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.impl.ResponseTimeConstraintImpl#getPercentage <em>Percentage</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResponseTimeConstraintImpl extends AnalysisConstraintImpl implements ResponseTimeConstraint {
	/**
	 * The default value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected static final double DURATION_EDEFAULT = 1.0;

	/**
	 * The cached value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected double duration = DURATION_EDEFAULT;

	/**
	 * This is true if the Duration attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean durationESet;

	/**
	 * The default value of the '{@link #getPercentage() <em>Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPercentage()
	 * @generated
	 * @ordered
	 */
	protected static final double PERCENTAGE_EDEFAULT = 95.0;

	/**
	 * The cached value of the '{@link #getPercentage() <em>Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPercentage()
	 * @generated
	 * @ordered
	 */
	protected double percentage = PERCENTAGE_EDEFAULT;

	/**
	 * This is true if the Percentage attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean percentageESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResponseTimeConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return AnalysisPackage.Literals.RESPONSE_TIME_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDuration() {
		return duration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDuration(double newDuration) {
		double oldDuration = duration;
		duration = newDuration;
		boolean oldDurationESet = durationESet;
		durationESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalysisPackage.RESPONSE_TIME_CONSTRAINT__DURATION, oldDuration, duration, !oldDurationESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDuration() {
		double oldDuration = duration;
		boolean oldDurationESet = durationESet;
		duration = DURATION_EDEFAULT;
		durationESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, AnalysisPackage.RESPONSE_TIME_CONSTRAINT__DURATION, oldDuration, DURATION_EDEFAULT, oldDurationESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDuration() {
		return durationESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPercentage() {
		return percentage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPercentage(double newPercentage) {
		double oldPercentage = percentage;
		percentage = newPercentage;
		boolean oldPercentageESet = percentageESet;
		percentageESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalysisPackage.RESPONSE_TIME_CONSTRAINT__PERCENTAGE, oldPercentage, percentage, !oldPercentageESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetPercentage() {
		double oldPercentage = percentage;
		boolean oldPercentageESet = percentageESet;
		percentage = PERCENTAGE_EDEFAULT;
		percentageESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, AnalysisPackage.RESPONSE_TIME_CONSTRAINT__PERCENTAGE, oldPercentage, PERCENTAGE_EDEFAULT, oldPercentageESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPercentage() {
		return percentageESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AnalysisPackage.RESPONSE_TIME_CONSTRAINT__DURATION:
				return new Double(getDuration());
			case AnalysisPackage.RESPONSE_TIME_CONSTRAINT__PERCENTAGE:
				return new Double(getPercentage());
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
			case AnalysisPackage.RESPONSE_TIME_CONSTRAINT__DURATION:
				setDuration(((Double)newValue).doubleValue());
				return;
			case AnalysisPackage.RESPONSE_TIME_CONSTRAINT__PERCENTAGE:
				setPercentage(((Double)newValue).doubleValue());
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
			case AnalysisPackage.RESPONSE_TIME_CONSTRAINT__DURATION:
				unsetDuration();
				return;
			case AnalysisPackage.RESPONSE_TIME_CONSTRAINT__PERCENTAGE:
				unsetPercentage();
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
			case AnalysisPackage.RESPONSE_TIME_CONSTRAINT__DURATION:
				return isSetDuration();
			case AnalysisPackage.RESPONSE_TIME_CONSTRAINT__PERCENTAGE:
				return isSetPercentage();
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
		result.append(" (duration: "); //$NON-NLS-1$
		if (durationESet) result.append(duration); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", percentage: "); //$NON-NLS-1$
		if (percentageESet) result.append(percentage); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //ResponseTimeConstraintImpl
