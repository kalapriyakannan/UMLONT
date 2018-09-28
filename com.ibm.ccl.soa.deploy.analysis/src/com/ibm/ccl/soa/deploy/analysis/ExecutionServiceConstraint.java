/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExecutionServiceConstraint.java,v 1.1 2007/12/03 20:16:13 nmakin Exp $
 */
package com.ibm.ccl.soa.deploy.analysis;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution Service Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *         		Execution Service (Enumeration. "Online Interactive, Offline Service, Real-time Service"). 
 *         	
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.ExecutionServiceConstraint#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getExecutionServiceConstraint()
 * @model extendedMetaData="name='ExecutionServiceConstraint' kind='elementOnly'"
 * @generated
 */
public interface ExecutionServiceConstraint extends AnalysisConstraint {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"online interactive"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.analysis.ExecutionServiceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.analysis.ExecutionServiceType
	 * @see #isSetType()
	 * @see #unsetType()
	 * @see #setType(ExecutionServiceType)
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getExecutionServiceConstraint_Type()
	 * @model default="online interactive" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='type'"
	 * @generated
	 */
	ExecutionServiceType getType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.ExecutionServiceConstraint#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.analysis.ExecutionServiceType
	 * @see #isSetType()
	 * @see #unsetType()
	 * @see #getType()
	 * @generated
	 */
	void setType(ExecutionServiceType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.ExecutionServiceConstraint#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetType()
	 * @see #getType()
	 * @see #setType(ExecutionServiceType)
	 * @generated
	 */
	void unsetType();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.analysis.ExecutionServiceConstraint#getType <em>Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Type</em>' attribute is set.
	 * @see #unsetType()
	 * @see #getType()
	 * @see #setType(ExecutionServiceType)
	 * @generated
	 */
	boolean isSetType();

} // ExecutionServiceConstraint
