/**
 * <copyright>
 * </copyright>
 *
 * $Id: AnalysisDeployRoot.java,v 1.7 2007/12/10 21:58:01 nmakin Exp $
 */
package com.ibm.ccl.soa.deploy.analysis;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deploy Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintAvailability <em>Analysis Constraint Availability</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintDailyLoad <em>Analysis Constraint Daily Load</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintDataService <em>Analysis Constraint Data Service</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintExecutionService <em>Analysis Constraint Execution Service</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintExpectedLifespan <em>Analysis Constraint Expected Lifespan</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintExpectedVolume <em>Analysis Constraint Expected Volume</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintPeakLoad <em>Analysis Constraint Peak Load</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintResponseTime <em>Analysis Constraint Response Time</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintSizePerSubmission <em>Analysis Constraint Size Per Submission</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintUsageWindowPerDay <em>Analysis Constraint Usage Window Per Day</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getCapabilityDeployment <em>Capability Deployment</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getCapabilityNode <em>Capability Node</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getConstraintAnalysisConstraint <em>Constraint Analysis Constraint</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getUnitDeploymentUnit <em>Unit Deployment Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getUnitLocation <em>Unit Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getUnitNode <em>Unit Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getAnalysisDeployRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface AnalysisDeployRoot extends EObject {
	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getAnalysisDeployRoot_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XMLNS Prefix Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XMLNS Prefix Map</em>' map.
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getAnalysisDeployRoot_XMLNSPrefixMap()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String" valueType="java.lang.String" transient="true"
	 *        extendedMetaData="kind='attribute' name='xmlns:prefix'"
	 * @generated
	 */
	EMap getXMLNSPrefixMap();

	/**
	 * Returns the value of the '<em><b>XSI Schema Location</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XSI Schema Location</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XSI Schema Location</em>' map.
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getAnalysisDeployRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String" valueType="java.lang.String" transient="true"
	 *        extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
	 * @generated
	 */
	EMap getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Analysis Constraint Availability</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Analysis Constraint Availability</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Analysis Constraint Availability</em>' containment reference.
	 * @see #setAnalysisConstraintAvailability(AvailabilityConstraint)
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getAnalysisDeployRoot_AnalysisConstraintAvailability()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='analysisConstraint.availability' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	AvailabilityConstraint getAnalysisConstraintAvailability();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintAvailability <em>Analysis Constraint Availability</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Analysis Constraint Availability</em>' containment reference.
	 * @see #getAnalysisConstraintAvailability()
	 * @generated
	 */
	void setAnalysisConstraintAvailability(AvailabilityConstraint value);

	/**
	 * Returns the value of the '<em><b>Analysis Constraint Daily Load</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Analysis Constraint Daily Load</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Analysis Constraint Daily Load</em>' containment reference.
	 * @see #setAnalysisConstraintDailyLoad(DailyLoadConstraint)
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getAnalysisDeployRoot_AnalysisConstraintDailyLoad()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='analysisConstraint.dailyLoad' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	DailyLoadConstraint getAnalysisConstraintDailyLoad();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintDailyLoad <em>Analysis Constraint Daily Load</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Analysis Constraint Daily Load</em>' containment reference.
	 * @see #getAnalysisConstraintDailyLoad()
	 * @generated
	 */
	void setAnalysisConstraintDailyLoad(DailyLoadConstraint value);

	/**
	 * Returns the value of the '<em><b>Analysis Constraint Data Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Analysis Constraint Data Service</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Analysis Constraint Data Service</em>' containment reference.
	 * @see #setAnalysisConstraintDataService(DataServiceConstraint)
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getAnalysisDeployRoot_AnalysisConstraintDataService()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='analysisConstraint.dataService' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	DataServiceConstraint getAnalysisConstraintDataService();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintDataService <em>Analysis Constraint Data Service</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Analysis Constraint Data Service</em>' containment reference.
	 * @see #getAnalysisConstraintDataService()
	 * @generated
	 */
	void setAnalysisConstraintDataService(DataServiceConstraint value);

	/**
	 * Returns the value of the '<em><b>Analysis Constraint Execution Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Analysis Constraint Execution Service</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Analysis Constraint Execution Service</em>' containment reference.
	 * @see #setAnalysisConstraintExecutionService(ExecutionServiceConstraint)
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getAnalysisDeployRoot_AnalysisConstraintExecutionService()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='analysisConstraint.executionService' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	ExecutionServiceConstraint getAnalysisConstraintExecutionService();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintExecutionService <em>Analysis Constraint Execution Service</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Analysis Constraint Execution Service</em>' containment reference.
	 * @see #getAnalysisConstraintExecutionService()
	 * @generated
	 */
	void setAnalysisConstraintExecutionService(ExecutionServiceConstraint value);

	/**
	 * Returns the value of the '<em><b>Analysis Constraint Expected Lifespan</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Analysis Constraint Expected Lifespan</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Analysis Constraint Expected Lifespan</em>' containment reference.
	 * @see #setAnalysisConstraintExpectedLifespan(ExpectedLifespanConstraint)
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getAnalysisDeployRoot_AnalysisConstraintExpectedLifespan()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='analysisConstraint.expectedLifespan' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	ExpectedLifespanConstraint getAnalysisConstraintExpectedLifespan();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintExpectedLifespan <em>Analysis Constraint Expected Lifespan</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Analysis Constraint Expected Lifespan</em>' containment reference.
	 * @see #getAnalysisConstraintExpectedLifespan()
	 * @generated
	 */
	void setAnalysisConstraintExpectedLifespan(ExpectedLifespanConstraint value);

	/**
	 * Returns the value of the '<em><b>Analysis Constraint Expected Volume</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Analysis Constraint Expected Volume</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Analysis Constraint Expected Volume</em>' containment reference.
	 * @see #setAnalysisConstraintExpectedVolume(ExpectedVolumeConstraint)
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getAnalysisDeployRoot_AnalysisConstraintExpectedVolume()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='analysisConstraint.expectedVolume' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	ExpectedVolumeConstraint getAnalysisConstraintExpectedVolume();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintExpectedVolume <em>Analysis Constraint Expected Volume</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Analysis Constraint Expected Volume</em>' containment reference.
	 * @see #getAnalysisConstraintExpectedVolume()
	 * @generated
	 */
	void setAnalysisConstraintExpectedVolume(ExpectedVolumeConstraint value);

	/**
	 * Returns the value of the '<em><b>Analysis Constraint Peak Load</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Analysis Constraint Peak Load</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Analysis Constraint Peak Load</em>' containment reference.
	 * @see #setAnalysisConstraintPeakLoad(PeakLoadConstraint)
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getAnalysisDeployRoot_AnalysisConstraintPeakLoad()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='analysisConstraint.peakLoad' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	PeakLoadConstraint getAnalysisConstraintPeakLoad();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintPeakLoad <em>Analysis Constraint Peak Load</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Analysis Constraint Peak Load</em>' containment reference.
	 * @see #getAnalysisConstraintPeakLoad()
	 * @generated
	 */
	void setAnalysisConstraintPeakLoad(PeakLoadConstraint value);

	/**
	 * Returns the value of the '<em><b>Analysis Constraint Response Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Analysis Constraint Response Time</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Analysis Constraint Response Time</em>' containment reference.
	 * @see #setAnalysisConstraintResponseTime(ResponseTimeConstraint)
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getAnalysisDeployRoot_AnalysisConstraintResponseTime()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='analysisConstraint.responseTime' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	ResponseTimeConstraint getAnalysisConstraintResponseTime();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintResponseTime <em>Analysis Constraint Response Time</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Analysis Constraint Response Time</em>' containment reference.
	 * @see #getAnalysisConstraintResponseTime()
	 * @generated
	 */
	void setAnalysisConstraintResponseTime(ResponseTimeConstraint value);

	/**
	 * Returns the value of the '<em><b>Analysis Constraint Size Per Submission</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Analysis Constraint Size Per Submission</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Analysis Constraint Size Per Submission</em>' containment reference.
	 * @see #setAnalysisConstraintSizePerSubmission(SizePerSubmissionConstraint)
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getAnalysisDeployRoot_AnalysisConstraintSizePerSubmission()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='analysisConstraint.sizePerSubmission' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	SizePerSubmissionConstraint getAnalysisConstraintSizePerSubmission();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintSizePerSubmission <em>Analysis Constraint Size Per Submission</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Analysis Constraint Size Per Submission</em>' containment reference.
	 * @see #getAnalysisConstraintSizePerSubmission()
	 * @generated
	 */
	void setAnalysisConstraintSizePerSubmission(SizePerSubmissionConstraint value);

	/**
	 * Returns the value of the '<em><b>Analysis Constraint Usage Window Per Day</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Analysis Constraint Usage Window Per Day</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Analysis Constraint Usage Window Per Day</em>' containment reference.
	 * @see #setAnalysisConstraintUsageWindowPerDay(UsageWindowPerDayConstraint)
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getAnalysisDeployRoot_AnalysisConstraintUsageWindowPerDay()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='analysisConstraint.usageWindowPerDay' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	UsageWindowPerDayConstraint getAnalysisConstraintUsageWindowPerDay();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getAnalysisConstraintUsageWindowPerDay <em>Analysis Constraint Usage Window Per Day</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Analysis Constraint Usage Window Per Day</em>' containment reference.
	 * @see #getAnalysisConstraintUsageWindowPerDay()
	 * @generated
	 */
	void setAnalysisConstraintUsageWindowPerDay(UsageWindowPerDayConstraint value);

	/**
	 * Returns the value of the '<em><b>Capability Deployment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Deployment</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Deployment</em>' containment reference.
	 * @see #setCapabilityDeployment(Deployment)
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getAnalysisDeployRoot_CapabilityDeployment()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.deployment' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	Deployment getCapabilityDeployment();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getCapabilityDeployment <em>Capability Deployment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Deployment</em>' containment reference.
	 * @see #getCapabilityDeployment()
	 * @generated
	 */
	void setCapabilityDeployment(Deployment value);

	/**
	 * Returns the value of the '<em><b>Capability Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Node</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Node</em>' containment reference.
	 * @see #setCapabilityNode(Node)
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getAnalysisDeployRoot_CapabilityNode()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.node' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	Node getCapabilityNode();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getCapabilityNode <em>Capability Node</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Node</em>' containment reference.
	 * @see #getCapabilityNode()
	 * @generated
	 */
	void setCapabilityNode(Node value);

	/**
	 * Returns the value of the '<em><b>Constraint Analysis Constraint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint Analysis Constraint</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint Analysis Constraint</em>' containment reference.
	 * @see #setConstraintAnalysisConstraint(AnalysisConstraint)
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getAnalysisDeployRoot_ConstraintAnalysisConstraint()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='constraint.analysisConstraint' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint'"
	 * @generated
	 */
	AnalysisConstraint getConstraintAnalysisConstraint();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getConstraintAnalysisConstraint <em>Constraint Analysis Constraint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraint Analysis Constraint</em>' containment reference.
	 * @see #getConstraintAnalysisConstraint()
	 * @generated
	 */
	void setConstraintAnalysisConstraint(AnalysisConstraint value);

	/**
	 * Returns the value of the '<em><b>Unit Deployment Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Deployment Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Deployment Unit</em>' containment reference.
	 * @see #setUnitDeploymentUnit(DeploymentUnit)
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getAnalysisDeployRoot_UnitDeploymentUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.deploymentUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	DeploymentUnit getUnitDeploymentUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getUnitDeploymentUnit <em>Unit Deployment Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Deployment Unit</em>' containment reference.
	 * @see #getUnitDeploymentUnit()
	 * @generated
	 */
	void setUnitDeploymentUnit(DeploymentUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Location</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Location</em>' containment reference.
	 * @see #setUnitLocation(LocationUnit)
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getAnalysisDeployRoot_UnitLocation()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.location' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	LocationUnit getUnitLocation();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getUnitLocation <em>Unit Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Location</em>' containment reference.
	 * @see #getUnitLocation()
	 * @generated
	 */
	void setUnitLocation(LocationUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Node</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Node</em>' containment reference.
	 * @see #setUnitNode(NodeUnit)
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getAnalysisDeployRoot_UnitNode()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.node' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit.ConceptualNode'"
	 * @generated
	 */
	NodeUnit getUnitNode();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot#getUnitNode <em>Unit Node</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Node</em>' containment reference.
	 * @see #getUnitNode()
	 * @generated
	 */
	void setUnitNode(NodeUnit value);

} // AnalysisDeployRoot
