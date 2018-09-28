/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExpectedLifespanConstraint.java,v 1.2 2007/12/07 18:23:43 nmakin Exp $
 */
package com.ibm.ccl.soa.deploy.analysis;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expected Lifespan Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *         		Unit expected lifespan constraint. As an example, a length of time that the data type must be persisted in an active, accessible state.  (e.g. 99.999)
 *         	
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.ExpectedLifespanConstraint#getDuration <em>Duration</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.ExpectedLifespanConstraint#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getExpectedLifespanConstraint()
 * @model extendedMetaData="name='ExpectedLifespanConstraint' kind='elementOnly'"
 * @generated
 */
public interface ExpectedLifespanConstraint extends AnalysisConstraint {
	/**
	 * Returns the value of the '<em><b>Duration</b></em>' attribute.
	 * The default value is <code>"99.9999"</code>.
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
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getExpectedLifespanConstraint_Duration()
	 * @model default="99.9999" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Double"
	 *        extendedMetaData="kind='attribute' name='duration'"
	 * @generated
	 */
	double getDuration();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.ExpectedLifespanConstraint#getDuration <em>Duration</em>}' attribute.
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
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.ExpectedLifespanConstraint#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDuration()
	 * @see #getDuration()
	 * @see #setDuration(double)
	 * @generated
	 */
	void unsetDuration();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.analysis.ExpectedLifespanConstraint#getDuration <em>Duration</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The default value is <code>"active"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.analysis.LifespanState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.analysis.LifespanState
	 * @see #isSetState()
	 * @see #unsetState()
	 * @see #setState(LifespanState)
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getExpectedLifespanConstraint_State()
	 * @model default="active" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='state'"
	 * @generated
	 */
	LifespanState getState();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.ExpectedLifespanConstraint#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.analysis.LifespanState
	 * @see #isSetState()
	 * @see #unsetState()
	 * @see #getState()
	 * @generated
	 */
	void setState(LifespanState value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.ExpectedLifespanConstraint#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetState()
	 * @see #getState()
	 * @see #setState(LifespanState)
	 * @generated
	 */
	void unsetState();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.analysis.ExpectedLifespanConstraint#getState <em>State</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>State</em>' attribute is set.
	 * @see #unsetState()
	 * @see #getState()
	 * @see #setState(LifespanState)
	 * @generated
	 */
	boolean isSetState();

} // ExpectedLifespanConstraint
