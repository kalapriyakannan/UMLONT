/**
 * <copyright>
 * </copyright>
 *
 * $Id: DailyLoadConstraint.java,v 1.2 2007/12/07 18:23:43 nmakin Exp $
 */
package com.ibm.ccl.soa.deploy.analysis;

import java.math.BigInteger;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Daily Load Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *         		Daily Load (integer): The average number of invocations expected per day (e.g. 1000). 
 *         	
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.DailyLoadConstraint#getDailyLoad <em>Daily Load</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getDailyLoadConstraint()
 * @model extendedMetaData="name='DailyLoadConstraint' kind='elementOnly'"
 * @generated
 */
public interface DailyLoadConstraint extends AnalysisConstraint {
	/**
	 * Returns the value of the '<em><b>Daily Load</b></em>' attribute.
	 * The default value is <code>"1000"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Daily Load</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Daily Load</em>' attribute.
	 * @see #isSetDailyLoad()
	 * @see #unsetDailyLoad()
	 * @see #setDailyLoad(BigInteger)
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getDailyLoadConstraint_DailyLoad()
	 * @model default="1000" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Integer"
	 *        extendedMetaData="kind='attribute' name='dailyLoad'"
	 * @generated
	 */
	BigInteger getDailyLoad();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.DailyLoadConstraint#getDailyLoad <em>Daily Load</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Daily Load</em>' attribute.
	 * @see #isSetDailyLoad()
	 * @see #unsetDailyLoad()
	 * @see #getDailyLoad()
	 * @generated
	 */
	void setDailyLoad(BigInteger value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.DailyLoadConstraint#getDailyLoad <em>Daily Load</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDailyLoad()
	 * @see #getDailyLoad()
	 * @see #setDailyLoad(BigInteger)
	 * @generated
	 */
	void unsetDailyLoad();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.analysis.DailyLoadConstraint#getDailyLoad <em>Daily Load</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Daily Load</em>' attribute is set.
	 * @see #unsetDailyLoad()
	 * @see #getDailyLoad()
	 * @see #setDailyLoad(BigInteger)
	 * @generated
	 */
	boolean isSetDailyLoad();

} // DailyLoadConstraint
