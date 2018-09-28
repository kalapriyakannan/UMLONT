/**
 * <copyright>
 * </copyright>
 *
 * $Id: DataServiceConstraint.java,v 1.1 2007/12/03 20:16:13 nmakin Exp $
 */
package com.ibm.ccl.soa.deploy.analysis;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Service Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *         		Data Service (Enumeration. Online Interactive, Offline Service, Archive, Replicated). 
 *         	
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.DataServiceConstraint#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getDataServiceConstraint()
 * @model extendedMetaData="name='DataServiceConstraint' kind='elementOnly'"
 * @generated
 */
public interface DataServiceConstraint extends AnalysisConstraint {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"online interactive"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.analysis.DataServiceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.analysis.DataServiceType
	 * @see #isSetType()
	 * @see #unsetType()
	 * @see #setType(DataServiceType)
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getDataServiceConstraint_Type()
	 * @model default="online interactive" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='type'"
	 * @generated
	 */
	DataServiceType getType();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.DataServiceConstraint#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.analysis.DataServiceType
	 * @see #isSetType()
	 * @see #unsetType()
	 * @see #getType()
	 * @generated
	 */
	void setType(DataServiceType value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.DataServiceConstraint#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetType()
	 * @see #getType()
	 * @see #setType(DataServiceType)
	 * @generated
	 */
	void unsetType();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.analysis.DataServiceConstraint#getType <em>Type</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Type</em>' attribute is set.
	 * @see #unsetType()
	 * @see #getType()
	 * @see #setType(DataServiceType)
	 * @generated
	 */
	boolean isSetType();

} // DataServiceConstraint
