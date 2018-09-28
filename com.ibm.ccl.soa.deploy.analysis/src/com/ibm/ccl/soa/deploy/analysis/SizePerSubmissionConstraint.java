/**
 * <copyright>
 * </copyright>
 *
 * $Id: SizePerSubmissionConstraint.java,v 1.2 2007/12/07 18:23:43 nmakin Exp $
 */
package com.ibm.ccl.soa.deploy.analysis;

import java.math.BigInteger;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Size Per Submission Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *         		Size per Submission (bytes): The expected size of any submitted piece of information. 
 *         	
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.SizePerSubmissionConstraint#getBytes <em>Bytes</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getSizePerSubmissionConstraint()
 * @model extendedMetaData="name='SizePerSubmissionConstraint' kind='elementOnly'"
 * @generated
 */
public interface SizePerSubmissionConstraint extends AnalysisConstraint {
	/**
	 * Returns the value of the '<em><b>Bytes</b></em>' attribute.
	 * The default value is <code>"100"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bytes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bytes</em>' attribute.
	 * @see #isSetBytes()
	 * @see #unsetBytes()
	 * @see #setBytes(BigInteger)
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getSizePerSubmissionConstraint_Bytes()
	 * @model default="100" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Integer"
	 *        extendedMetaData="kind='attribute' name='bytes'"
	 * @generated
	 */
	BigInteger getBytes();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.SizePerSubmissionConstraint#getBytes <em>Bytes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bytes</em>' attribute.
	 * @see #isSetBytes()
	 * @see #unsetBytes()
	 * @see #getBytes()
	 * @generated
	 */
	void setBytes(BigInteger value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.SizePerSubmissionConstraint#getBytes <em>Bytes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBytes()
	 * @see #getBytes()
	 * @see #setBytes(BigInteger)
	 * @generated
	 */
	void unsetBytes();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.analysis.SizePerSubmissionConstraint#getBytes <em>Bytes</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Bytes</em>' attribute is set.
	 * @see #unsetBytes()
	 * @see #getBytes()
	 * @see #setBytes(BigInteger)
	 * @generated
	 */
	boolean isSetBytes();

} // SizePerSubmissionConstraint
