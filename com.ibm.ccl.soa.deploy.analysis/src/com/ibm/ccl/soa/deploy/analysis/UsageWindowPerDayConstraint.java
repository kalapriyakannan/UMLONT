/**
 * <copyright>
 * </copyright>
 *
 * $Id: UsageWindowPerDayConstraint.java,v 1.2 2007/12/07 18:23:43 nmakin Exp $
 */
package com.ibm.ccl.soa.deploy.analysis;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Usage Window Per Day Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *         		Usage Window Per Day (number of hours): The length of time that the service should be anticipated for use per day. 
 *         	
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.UsageWindowPerDayConstraint#getDuration <em>Duration</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getUsageWindowPerDayConstraint()
 * @model extendedMetaData="name='UsageWindowPerDayConstraint' kind='elementOnly'"
 * @generated
 */
public interface UsageWindowPerDayConstraint extends AnalysisConstraint {
	/**
	 * Returns the value of the '<em><b>Duration</b></em>' attribute.
	 * The default value is <code>"24"</code>.
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
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getUsageWindowPerDayConstraint_Duration()
	 * @model default="24" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double"
	 *        extendedMetaData="kind='attribute' name='duration'"
	 * @generated
	 */
	double getDuration();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.UsageWindowPerDayConstraint#getDuration <em>Duration</em>}' attribute.
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
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.UsageWindowPerDayConstraint#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDuration()
	 * @see #getDuration()
	 * @see #setDuration(double)
	 * @generated
	 */
	void unsetDuration();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.analysis.UsageWindowPerDayConstraint#getDuration <em>Duration</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Duration</em>' attribute is set.
	 * @see #unsetDuration()
	 * @see #getDuration()
	 * @see #setDuration(double)
	 * @generated
	 */
	boolean isSetDuration();

} // UsageWindowPerDayConstraint
