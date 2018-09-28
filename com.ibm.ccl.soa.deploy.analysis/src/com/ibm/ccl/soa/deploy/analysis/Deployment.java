/**
 * <copyright>
 * </copyright>
 *
 * $Id: Deployment.java,v 1.2 2007/10/10 20:13:27 nmakin Exp $
 */
package com.ibm.ccl.soa.deploy.analysis;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deployment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				The capability of the deployment unit.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.Deployment#getFacet <em>Facet</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getDeployment()
 * @model extendedMetaData="name='Deployment' kind='elementOnly'"
 * @generated
 */
public interface Deployment extends Capability {
	/**
	 * Returns the value of the '<em><b>Facet</b></em>' attribute.
	 * The default value is <code>"undefined"</code>.
	 * The literals are from the enumeration {@link com.ibm.ccl.soa.deploy.analysis.DeploymentUnitFacet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facet</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facet</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.analysis.DeploymentUnitFacet
	 * @see #isSetFacet()
	 * @see #unsetFacet()
	 * @see #setFacet(DeploymentUnitFacet)
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getDeployment_Facet()
	 * @model default="undefined" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='facet'"
	 * @generated
	 */
	DeploymentUnitFacet getFacet();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.Deployment#getFacet <em>Facet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facet</em>' attribute.
	 * @see com.ibm.ccl.soa.deploy.analysis.DeploymentUnitFacet
	 * @see #isSetFacet()
	 * @see #unsetFacet()
	 * @see #getFacet()
	 * @generated
	 */
	void setFacet(DeploymentUnitFacet value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.Deployment#getFacet <em>Facet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetFacet()
	 * @see #getFacet()
	 * @see #setFacet(DeploymentUnitFacet)
	 * @generated
	 */
	void unsetFacet();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.analysis.Deployment#getFacet <em>Facet</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Facet</em>' attribute is set.
	 * @see #unsetFacet()
	 * @see #getFacet()
	 * @see #setFacet(DeploymentUnitFacet)
	 * @generated
	 */
	boolean isSetFacet();

} // Deployment
