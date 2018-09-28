/**
 * <copyright>
 * </copyright>
 *
 * $Id: AnalysisFactory.java,v 1.5 2007/12/10 21:58:01 nmakin Exp $
 */
package com.ibm.ccl.soa.deploy.analysis;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage
 * @generated
 */
public interface AnalysisFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AnalysisFactory eINSTANCE = com.ibm.ccl.soa.deploy.analysis.impl.AnalysisFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constraint</em>'.
	 * @generated
	 */
	AnalysisConstraint createAnalysisConstraint();

	/**
	 * Returns a new object of class '<em>Deploy Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deploy Root</em>'.
	 * @generated
	 */
	AnalysisDeployRoot createAnalysisDeployRoot();

	/**
	 * Returns a new object of class '<em>Availability Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Availability Constraint</em>'.
	 * @generated
	 */
	AvailabilityConstraint createAvailabilityConstraint();

	/**
	 * Returns a new object of class '<em>Daily Load Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Daily Load Constraint</em>'.
	 * @generated
	 */
	DailyLoadConstraint createDailyLoadConstraint();

	/**
	 * Returns a new object of class '<em>Data Service Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Service Constraint</em>'.
	 * @generated
	 */
	DataServiceConstraint createDataServiceConstraint();

	/**
	 * Returns a new object of class '<em>Deployment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deployment</em>'.
	 * @generated
	 */
	Deployment createDeployment();

	/**
	 * Returns a new object of class '<em>Deployment Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deployment Unit</em>'.
	 * @generated
	 */
	DeploymentUnit createDeploymentUnit();

	/**
	 * Returns a new object of class '<em>Execution Service Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution Service Constraint</em>'.
	 * @generated
	 */
	ExecutionServiceConstraint createExecutionServiceConstraint();

	/**
	 * Returns a new object of class '<em>Expected Lifespan Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expected Lifespan Constraint</em>'.
	 * @generated
	 */
	ExpectedLifespanConstraint createExpectedLifespanConstraint();

	/**
	 * Returns a new object of class '<em>Expected Volume Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expected Volume Constraint</em>'.
	 * @generated
	 */
	ExpectedVolumeConstraint createExpectedVolumeConstraint();

	/**
	 * Returns a new object of class '<em>Location Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Location Unit</em>'.
	 * @generated
	 */
	LocationUnit createLocationUnit();

	/**
	 * Returns a new object of class '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Node</em>'.
	 * @generated
	 */
	Node createNode();

	/**
	 * Returns a new object of class '<em>Node Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Node Unit</em>'.
	 * @generated
	 */
	NodeUnit createNodeUnit();

	/**
	 * Returns a new object of class '<em>Peak Load Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Peak Load Constraint</em>'.
	 * @generated
	 */
	PeakLoadConstraint createPeakLoadConstraint();

	/**
	 * Returns a new object of class '<em>Response Time Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Response Time Constraint</em>'.
	 * @generated
	 */
	ResponseTimeConstraint createResponseTimeConstraint();

	/**
	 * Returns a new object of class '<em>Size Per Submission Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Size Per Submission Constraint</em>'.
	 * @generated
	 */
	SizePerSubmissionConstraint createSizePerSubmissionConstraint();

	/**
	 * Returns a new object of class '<em>Usage Window Per Day Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Usage Window Per Day Constraint</em>'.
	 * @generated
	 */
	UsageWindowPerDayConstraint createUsageWindowPerDayConstraint();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AnalysisPackage getAnalysisPackage();

} //AnalysisFactory
