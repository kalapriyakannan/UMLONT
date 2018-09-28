/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExpectedVolumeConstraint.java,v 1.2 2007/12/07 18:23:43 nmakin Exp $
 */
package com.ibm.ccl.soa.deploy.analysis;

import java.math.BigInteger;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expected Volume Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *         		Unit expected volume constraint. As an example, the number of expected instances of this data type in a repository. 
 *         	
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.ExpectedVolumeConstraint#getGrowthRatePercentage <em>Growth Rate Percentage</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.ExpectedVolumeConstraint#getInitialSize <em>Initial Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getExpectedVolumeConstraint()
 * @model extendedMetaData="name='ExpectedVolumeConstraint' kind='elementOnly'"
 * @generated
 */
public interface ExpectedVolumeConstraint extends AnalysisConstraint {
	/**
	 * Returns the value of the '<em><b>Growth Rate Percentage</b></em>' attribute.
	 * The default value is <code>"10"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Growth Rate Percentage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Growth Rate Percentage</em>' attribute.
	 * @see #isSetGrowthRatePercentage()
	 * @see #unsetGrowthRatePercentage()
	 * @see #setGrowthRatePercentage(double)
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getExpectedVolumeConstraint_GrowthRatePercentage()
	 * @model default="10" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double"
	 *        extendedMetaData="kind='attribute' name='growthRatePercentage'"
	 * @generated
	 */
	double getGrowthRatePercentage();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.ExpectedVolumeConstraint#getGrowthRatePercentage <em>Growth Rate Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Growth Rate Percentage</em>' attribute.
	 * @see #isSetGrowthRatePercentage()
	 * @see #unsetGrowthRatePercentage()
	 * @see #getGrowthRatePercentage()
	 * @generated
	 */
	void setGrowthRatePercentage(double value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.ExpectedVolumeConstraint#getGrowthRatePercentage <em>Growth Rate Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetGrowthRatePercentage()
	 * @see #getGrowthRatePercentage()
	 * @see #setGrowthRatePercentage(double)
	 * @generated
	 */
	void unsetGrowthRatePercentage();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.analysis.ExpectedVolumeConstraint#getGrowthRatePercentage <em>Growth Rate Percentage</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Growth Rate Percentage</em>' attribute is set.
	 * @see #unsetGrowthRatePercentage()
	 * @see #getGrowthRatePercentage()
	 * @see #setGrowthRatePercentage(double)
	 * @generated
	 */
	boolean isSetGrowthRatePercentage();

	/**
	 * Returns the value of the '<em><b>Initial Size</b></em>' attribute.
	 * The default value is <code>"10"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Size</em>' attribute.
	 * @see #isSetInitialSize()
	 * @see #unsetInitialSize()
	 * @see #setInitialSize(BigInteger)
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getExpectedVolumeConstraint_InitialSize()
	 * @model default="10" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Integer"
	 *        extendedMetaData="kind='attribute' name='initialSize'"
	 * @generated
	 */
	BigInteger getInitialSize();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.ExpectedVolumeConstraint#getInitialSize <em>Initial Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Size</em>' attribute.
	 * @see #isSetInitialSize()
	 * @see #unsetInitialSize()
	 * @see #getInitialSize()
	 * @generated
	 */
	void setInitialSize(BigInteger value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.ExpectedVolumeConstraint#getInitialSize <em>Initial Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInitialSize()
	 * @see #getInitialSize()
	 * @see #setInitialSize(BigInteger)
	 * @generated
	 */
	void unsetInitialSize();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.analysis.ExpectedVolumeConstraint#getInitialSize <em>Initial Size</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Initial Size</em>' attribute is set.
	 * @see #unsetInitialSize()
	 * @see #getInitialSize()
	 * @see #setInitialSize(BigInteger)
	 * @generated
	 */
	boolean isSetInitialSize();

} // ExpectedVolumeConstraint
