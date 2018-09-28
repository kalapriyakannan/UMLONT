/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExpectedVolumeConstraintImpl.java,v 1.2 2007/12/07 18:23:44 nmakin Exp $
 */
package com.ibm.ccl.soa.deploy.analysis.impl;

import com.ibm.ccl.soa.deploy.analysis.AnalysisPackage;
import com.ibm.ccl.soa.deploy.analysis.ExpectedVolumeConstraint;

import java.math.BigInteger;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expected Volume Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.impl.ExpectedVolumeConstraintImpl#getGrowthRatePercentage <em>Growth Rate Percentage</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.impl.ExpectedVolumeConstraintImpl#getInitialSize <em>Initial Size</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpectedVolumeConstraintImpl extends AnalysisConstraintImpl implements ExpectedVolumeConstraint {
	/**
	 * The default value of the '{@link #getGrowthRatePercentage() <em>Growth Rate Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGrowthRatePercentage()
	 * @generated
	 * @ordered
	 */
	protected static final double GROWTH_RATE_PERCENTAGE_EDEFAULT = 10.0;

	/**
	 * The cached value of the '{@link #getGrowthRatePercentage() <em>Growth Rate Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGrowthRatePercentage()
	 * @generated
	 * @ordered
	 */
	protected double growthRatePercentage = GROWTH_RATE_PERCENTAGE_EDEFAULT;

	/**
	 * This is true if the Growth Rate Percentage attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean growthRatePercentageESet;

	/**
	 * The default value of the '{@link #getInitialSize() <em>Initial Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialSize()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger INITIAL_SIZE_EDEFAULT = new BigInteger("10"); //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getInitialSize() <em>Initial Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialSize()
	 * @generated
	 * @ordered
	 */
	protected BigInteger initialSize = INITIAL_SIZE_EDEFAULT;

	/**
	 * This is true if the Initial Size attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean initialSizeESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpectedVolumeConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return AnalysisPackage.Literals.EXPECTED_VOLUME_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getGrowthRatePercentage() {
		return growthRatePercentage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGrowthRatePercentage(double newGrowthRatePercentage) {
		double oldGrowthRatePercentage = growthRatePercentage;
		growthRatePercentage = newGrowthRatePercentage;
		boolean oldGrowthRatePercentageESet = growthRatePercentageESet;
		growthRatePercentageESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalysisPackage.EXPECTED_VOLUME_CONSTRAINT__GROWTH_RATE_PERCENTAGE, oldGrowthRatePercentage, growthRatePercentage, !oldGrowthRatePercentageESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetGrowthRatePercentage() {
		double oldGrowthRatePercentage = growthRatePercentage;
		boolean oldGrowthRatePercentageESet = growthRatePercentageESet;
		growthRatePercentage = GROWTH_RATE_PERCENTAGE_EDEFAULT;
		growthRatePercentageESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, AnalysisPackage.EXPECTED_VOLUME_CONSTRAINT__GROWTH_RATE_PERCENTAGE, oldGrowthRatePercentage, GROWTH_RATE_PERCENTAGE_EDEFAULT, oldGrowthRatePercentageESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetGrowthRatePercentage() {
		return growthRatePercentageESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getInitialSize() {
		return initialSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialSize(BigInteger newInitialSize) {
		BigInteger oldInitialSize = initialSize;
		initialSize = newInitialSize;
		boolean oldInitialSizeESet = initialSizeESet;
		initialSizeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalysisPackage.EXPECTED_VOLUME_CONSTRAINT__INITIAL_SIZE, oldInitialSize, initialSize, !oldInitialSizeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetInitialSize() {
		BigInteger oldInitialSize = initialSize;
		boolean oldInitialSizeESet = initialSizeESet;
		initialSize = INITIAL_SIZE_EDEFAULT;
		initialSizeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, AnalysisPackage.EXPECTED_VOLUME_CONSTRAINT__INITIAL_SIZE, oldInitialSize, INITIAL_SIZE_EDEFAULT, oldInitialSizeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInitialSize() {
		return initialSizeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AnalysisPackage.EXPECTED_VOLUME_CONSTRAINT__GROWTH_RATE_PERCENTAGE:
				return new Double(getGrowthRatePercentage());
			case AnalysisPackage.EXPECTED_VOLUME_CONSTRAINT__INITIAL_SIZE:
				return getInitialSize();
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
			case AnalysisPackage.EXPECTED_VOLUME_CONSTRAINT__GROWTH_RATE_PERCENTAGE:
				setGrowthRatePercentage(((Double)newValue).doubleValue());
				return;
			case AnalysisPackage.EXPECTED_VOLUME_CONSTRAINT__INITIAL_SIZE:
				setInitialSize((BigInteger)newValue);
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
			case AnalysisPackage.EXPECTED_VOLUME_CONSTRAINT__GROWTH_RATE_PERCENTAGE:
				unsetGrowthRatePercentage();
				return;
			case AnalysisPackage.EXPECTED_VOLUME_CONSTRAINT__INITIAL_SIZE:
				unsetInitialSize();
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
			case AnalysisPackage.EXPECTED_VOLUME_CONSTRAINT__GROWTH_RATE_PERCENTAGE:
				return isSetGrowthRatePercentage();
			case AnalysisPackage.EXPECTED_VOLUME_CONSTRAINT__INITIAL_SIZE:
				return isSetInitialSize();
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
		result.append(" (growthRatePercentage: "); //$NON-NLS-1$
		if (growthRatePercentageESet) result.append(growthRatePercentage); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", initialSize: "); //$NON-NLS-1$
		if (initialSizeESet) result.append(initialSize); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //ExpectedVolumeConstraintImpl
