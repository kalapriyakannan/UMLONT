/**
 * <copyright>
 * </copyright>
 *
 * $Id: AvailabilityConstraint.java,v 1.5 2007/12/13 17:55:28 nmakin Exp $
 */
package com.ibm.ccl.soa.deploy.analysis;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Availability Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *         		Unit availability constraint. As an example, the percentage amount of time per year that the data or service must be available (e.g. 99.999)
 *         	
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.AvailabilityConstraint#getPercentage <em>Percentage</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getAvailabilityConstraint()
 * @model extendedMetaData="name='AvailabilityConstraint' kind='elementOnly'"
 * @generated
 */
public interface AvailabilityConstraint extends AnalysisConstraint {
	/**
	 * Returns the value of the '<em><b>Percentage</b></em>' attribute.
	 * The default value is <code>"99.9999"</code>.
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
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getAvailabilityConstraint_Percentage()
	 * @model default="99.9999" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double"
	 *        extendedMetaData="kind='attribute' name='percentage'"
	 * @generated
	 */
	double getPercentage();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.AvailabilityConstraint#getPercentage <em>Percentage</em>}' attribute.
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
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.AvailabilityConstraint#getPercentage <em>Percentage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPercentage()
	 * @see #getPercentage()
	 * @see #setPercentage(double)
	 * @generated
	 */
	void unsetPercentage();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.analysis.AvailabilityConstraint#getPercentage <em>Percentage</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Percentage</em>' attribute is set.
	 * @see #unsetPercentage()
	 * @see #getPercentage()
	 * @see #setPercentage(double)
	 * @generated
	 */
	boolean isSetPercentage();

} // AvailabilityConstraint
