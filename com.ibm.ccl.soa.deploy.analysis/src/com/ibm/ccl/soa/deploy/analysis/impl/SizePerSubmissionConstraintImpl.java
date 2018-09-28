/**
 * <copyright>
 * </copyright>
 *
 * $Id: SizePerSubmissionConstraintImpl.java,v 1.2 2007/12/07 18:23:44 nmakin Exp $
 */
package com.ibm.ccl.soa.deploy.analysis.impl;

import com.ibm.ccl.soa.deploy.analysis.AnalysisPackage;
import com.ibm.ccl.soa.deploy.analysis.SizePerSubmissionConstraint;

import java.math.BigInteger;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Size Per Submission Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.impl.SizePerSubmissionConstraintImpl#getBytes <em>Bytes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SizePerSubmissionConstraintImpl extends AnalysisConstraintImpl implements SizePerSubmissionConstraint {
	/**
	 * The default value of the '{@link #getBytes() <em>Bytes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBytes()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger BYTES_EDEFAULT = new BigInteger("100"); //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getBytes() <em>Bytes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBytes()
	 * @generated
	 * @ordered
	 */
	protected BigInteger bytes = BYTES_EDEFAULT;

	/**
	 * This is true if the Bytes attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean bytesESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SizePerSubmissionConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return AnalysisPackage.Literals.SIZE_PER_SUBMISSION_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getBytes() {
		return bytes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBytes(BigInteger newBytes) {
		BigInteger oldBytes = bytes;
		bytes = newBytes;
		boolean oldBytesESet = bytesESet;
		bytesESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalysisPackage.SIZE_PER_SUBMISSION_CONSTRAINT__BYTES, oldBytes, bytes, !oldBytesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBytes() {
		BigInteger oldBytes = bytes;
		boolean oldBytesESet = bytesESet;
		bytes = BYTES_EDEFAULT;
		bytesESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, AnalysisPackage.SIZE_PER_SUBMISSION_CONSTRAINT__BYTES, oldBytes, BYTES_EDEFAULT, oldBytesESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBytes() {
		return bytesESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AnalysisPackage.SIZE_PER_SUBMISSION_CONSTRAINT__BYTES:
				return getBytes();
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
			case AnalysisPackage.SIZE_PER_SUBMISSION_CONSTRAINT__BYTES:
				setBytes((BigInteger)newValue);
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
			case AnalysisPackage.SIZE_PER_SUBMISSION_CONSTRAINT__BYTES:
				unsetBytes();
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
			case AnalysisPackage.SIZE_PER_SUBMISSION_CONSTRAINT__BYTES:
				return isSetBytes();
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
		result.append(" (bytes: "); //$NON-NLS-1$
		if (bytesESet) result.append(bytes); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //SizePerSubmissionConstraintImpl
