/**
 * <copyright>
 * </copyright>
 *
 * $Id: PeakLoadConstraint.java,v 1.2 2007/12/07 18:23:43 nmakin Exp $
 */
package com.ibm.ccl.soa.deploy.analysis;

import java.math.BigInteger;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Peak Load Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *         		Peak Load (integer): The maximum number of invocations expected per day (e.g. 10000).
 *         	
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.PeakLoadConstraint#getPeakLoad <em>Peak Load</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getPeakLoadConstraint()
 * @model extendedMetaData="name='PeakLoadConstraint' kind='elementOnly'"
 * @generated
 */
public interface PeakLoadConstraint extends AnalysisConstraint {
	/**
	 * Returns the value of the '<em><b>Peak Load</b></em>' attribute.
	 * The default value is <code>"10000"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Peak Load</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Peak Load</em>' attribute.
	 * @see #isSetPeakLoad()
	 * @see #unsetPeakLoad()
	 * @see #setPeakLoad(BigInteger)
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getPeakLoadConstraint_PeakLoad()
	 * @model default="10000" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Integer"
	 *        extendedMetaData="kind='attribute' name='peakLoad'"
	 * @generated
	 */
	BigInteger getPeakLoad();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.PeakLoadConstraint#getPeakLoad <em>Peak Load</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Peak Load</em>' attribute.
	 * @see #isSetPeakLoad()
	 * @see #unsetPeakLoad()
	 * @see #getPeakLoad()
	 * @generated
	 */
	void setPeakLoad(BigInteger value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.PeakLoadConstraint#getPeakLoad <em>Peak Load</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPeakLoad()
	 * @see #getPeakLoad()
	 * @see #setPeakLoad(BigInteger)
	 * @generated
	 */
	void unsetPeakLoad();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.analysis.PeakLoadConstraint#getPeakLoad <em>Peak Load</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Peak Load</em>' attribute is set.
	 * @see #unsetPeakLoad()
	 * @see #getPeakLoad()
	 * @see #setPeakLoad(BigInteger)
	 * @generated
	 */
	boolean isSetPeakLoad();

} // PeakLoadConstraint
