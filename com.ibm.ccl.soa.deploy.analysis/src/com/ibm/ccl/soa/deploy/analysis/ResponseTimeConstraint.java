/**
 * <copyright>
 * </copyright>
 *
 * $Id: ResponseTimeConstraint.java,v 1.3 2007/12/13 17:55:28 nmakin Exp $
 */
package com.ibm.ccl.soa.deploy.analysis;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Response Time Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *         		The maximum expected response time for 95% of all invocations of the service - % and time.
 *         	
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.ResponseTimeConstraint#getDuration <em>Duration</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.ResponseTimeConstraint#getPercentage <em>Percentage</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getResponseTimeConstraint()
 * @model extendedMetaData="name='ResponseTimeConstraint' kind='elementOnly'"
 * @generated
 */
public interface ResponseTimeConstraint extends AnalysisConstraint {
	/**
	 * Returns the value of the '<em><b>Duration</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Duration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration</em>' attribute.
	 * @see #isSetDuration()
	 * @see #unsetDuration()
	 * @see #setDuration(double)
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getResponseTimeConstraint_Duration()
	 * @model default="1" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double"
	 *        extendedMetaData="kind='attribute' name='duration'"
	 * @generated
	 */
	double getDuration();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.ResponseTimeConstraint#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration</em>' attribute.
	 * @see #isSetDuration()
	 * @see #unsetDuration()
	 * @see #getDuration()
	 * @generated
	 */
	void setDuration(double value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.ResponseTimeConstraint#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDuration()
	 * @see #getDuration()
	 * @see #setDuration(double)
	 * @generated
	 */
	void unsetDuration();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.analysis.ResponseTimeConstraint#getDuration <em>Duration</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Duration</em>' attribute is set.
	 * @see #unsetDuration()
	 * @see #getDuration()
	 * @see #setDuration(double)
	 * @generated
	 */
	boolean isSetDuration();

	/**
	 * Returns the value of the '<em><b>Percentage</b></em>' attribute.
	 * The default value is <code>"95"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Percentage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Percentage</em>' attribute.
	 * @see #isSetPercentage()
	 * @see #unsetPercentage()
	 * @see #setPercentage(double)
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getResponseTimeConstraint_Percentage()
	 * @model default="95" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double"
	 *        extendedMetaData="kind='attribute' name='percentage'"
	 * @generated
	 */
	double getPercentage();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.ResponseTimeConstraint#getPercentage <em>Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Percentage</em>' attribute.
	 * @see #isSetPercentage()
	 * @see #unsetPercentage()
	 * @see #getPercentage()
	 * @generated
	 */
	void setPercentage(double value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.ResponseTimeConstraint#getPercentage <em>Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPercentage()
	 * @see #getPercentage()
	 * @see #setPercentage(double)
	 * @generated
	 */
	void unsetPercentage();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.analysis.ResponseTimeConstraint#getPercentage <em>Percentage</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Percentage</em>' attribute is set.
	 * @see #unsetPercentage()
	 * @see #getPercentage()
	 * @see #setPercentage(double)
	 * @generated
	 */
	boolean isSetPercentage();

} // ResponseTimeConstraint
