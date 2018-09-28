/**
 * <copyright>
 * </copyright>
 *
 * $Id: AnalysisDeployRootImpl.java,v 1.6 2007/12/13 17:55:28 nmakin Exp $
 */
package com.ibm.ccl.soa.deploy.analysis.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.ibm.ccl.soa.deploy.analysis.AnalysisConstraint;
import com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot;
import com.ibm.ccl.soa.deploy.analysis.AnalysisPackage;
import com.ibm.ccl.soa.deploy.analysis.AvailabilityConstraint;
import com.ibm.ccl.soa.deploy.analysis.DailyLoadConstraint;
import com.ibm.ccl.soa.deploy.analysis.DataServiceConstraint;
import com.ibm.ccl.soa.deploy.analysis.Deployment;
import com.ibm.ccl.soa.deploy.analysis.DeploymentUnit;
import com.ibm.ccl.soa.deploy.analysis.ExecutionServiceConstraint;
import com.ibm.ccl.soa.deploy.analysis.ExpectedLifespanConstraint;
import com.ibm.ccl.soa.deploy.analysis.ExpectedVolumeConstraint;
import com.ibm.ccl.soa.deploy.analysis.LocationUnit;
import com.ibm.ccl.soa.deploy.analysis.Node;
import com.ibm.ccl.soa.deploy.analysis.NodeUnit;
import com.ibm.ccl.soa.deploy.analysis.PeakLoadConstraint;
import com.ibm.ccl.soa.deploy.analysis.ResponseTimeConstraint;
import com.ibm.ccl.soa.deploy.analysis.SizePerSubmissionConstraint;
import com.ibm.ccl.soa.deploy.analysis.UsageWindowPerDayConstraint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Deploy Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.impl.AnalysisDeployRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.impl.AnalysisDeployRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.impl.AnalysisDeployRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.impl.AnalysisDeployRootImpl#getAnalysisConstraintAvailability <em>Analysis Constraint Availability</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.impl.AnalysisDeployRootImpl#getAnalysisConstraintDailyLoad <em>Analysis Constraint Daily Load</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.impl.AnalysisDeployRootImpl#getAnalysisConstraintDataService <em>Analysis Constraint Data Service</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.impl.AnalysisDeployRootImpl#getAnalysisConstraintExecutionService <em>Analysis Constraint Execution Service</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.impl.AnalysisDeployRootImpl#getAnalysisConstraintExpectedLifespan <em>Analysis Constraint Expected Lifespan</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.impl.AnalysisDeployRootImpl#getAnalysisConstraintExpectedVolume <em>Analysis Constraint Expected Volume</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.impl.AnalysisDeployRootImpl#getAnalysisConstraintPeakLoad <em>Analysis Constraint Peak Load</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.impl.AnalysisDeployRootImpl#getAnalysisConstraintResponseTime <em>Analysis Constraint Response Time</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.impl.AnalysisDeployRootImpl#getAnalysisConstraintSizePerSubmission <em>Analysis Constraint Size Per Submission</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.impl.AnalysisDeployRootImpl#getAnalysisConstraintUsageWindowPerDay <em>Analysis Constraint Usage Window Per Day</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.impl.AnalysisDeployRootImpl#getCapabilityDeployment <em>Capability Deployment</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.impl.AnalysisDeployRootImpl#getCapabilityNode <em>Capability Node</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.impl.AnalysisDeployRootImpl#getConstraintAnalysisConstraint <em>Constraint Analysis Constraint</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.impl.AnalysisDeployRootImpl#getUnitDeploymentUnit <em>Unit Deployment Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.impl.AnalysisDeployRootImpl#getUnitLocation <em>Unit Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.analysis.impl.AnalysisDeployRootImpl#getUnitNode <em>Unit Node</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnalysisDeployRootImpl extends EObjectImpl implements AnalysisDeployRoot {
	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXMLNSPrefixMap()
	 * @generated
	 * @ordered
	 */
	protected EMap xMLNSPrefixMap;

	/**
	 * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXSISchemaLocation()
	 * @generated
	 * @ordered
	 */
	protected EMap xSISchemaLocation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnalysisDeployRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, AnalysisPackage.ANALYSIS_DEPLOY_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, AnalysisPackage.ANALYSIS_DEPLOY_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, AnalysisPackage.ANALYSIS_DEPLOY_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AvailabilityConstraint getAnalysisConstraintAvailability() {
		return (AvailabilityConstraint)getMixed().get(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_AVAILABILITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnalysisConstraintAvailability(AvailabilityConstraint newAnalysisConstraintAvailability, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_AVAILABILITY, newAnalysisConstraintAvailability, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnalysisConstraintAvailability(AvailabilityConstraint newAnalysisConstraintAvailability) {
		((FeatureMap.Internal)getMixed()).set(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_AVAILABILITY, newAnalysisConstraintAvailability);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DailyLoadConstraint getAnalysisConstraintDailyLoad() {
		return (DailyLoadConstraint)getMixed().get(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_DAILY_LOAD, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnalysisConstraintDailyLoad(DailyLoadConstraint newAnalysisConstraintDailyLoad, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_DAILY_LOAD, newAnalysisConstraintDailyLoad, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnalysisConstraintDailyLoad(DailyLoadConstraint newAnalysisConstraintDailyLoad) {
		((FeatureMap.Internal)getMixed()).set(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_DAILY_LOAD, newAnalysisConstraintDailyLoad);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataServiceConstraint getAnalysisConstraintDataService() {
		return (DataServiceConstraint)getMixed().get(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_DATA_SERVICE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnalysisConstraintDataService(DataServiceConstraint newAnalysisConstraintDataService, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_DATA_SERVICE, newAnalysisConstraintDataService, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnalysisConstraintDataService(DataServiceConstraint newAnalysisConstraintDataService) {
		((FeatureMap.Internal)getMixed()).set(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_DATA_SERVICE, newAnalysisConstraintDataService);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionServiceConstraint getAnalysisConstraintExecutionService() {
		return (ExecutionServiceConstraint)getMixed().get(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXECUTION_SERVICE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnalysisConstraintExecutionService(ExecutionServiceConstraint newAnalysisConstraintExecutionService, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXECUTION_SERVICE, newAnalysisConstraintExecutionService, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnalysisConstraintExecutionService(ExecutionServiceConstraint newAnalysisConstraintExecutionService) {
		((FeatureMap.Internal)getMixed()).set(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXECUTION_SERVICE, newAnalysisConstraintExecutionService);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpectedLifespanConstraint getAnalysisConstraintExpectedLifespan() {
		return (ExpectedLifespanConstraint)getMixed().get(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXPECTED_LIFESPAN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnalysisConstraintExpectedLifespan(ExpectedLifespanConstraint newAnalysisConstraintExpectedLifespan, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXPECTED_LIFESPAN, newAnalysisConstraintExpectedLifespan, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnalysisConstraintExpectedLifespan(ExpectedLifespanConstraint newAnalysisConstraintExpectedLifespan) {
		((FeatureMap.Internal)getMixed()).set(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXPECTED_LIFESPAN, newAnalysisConstraintExpectedLifespan);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpectedVolumeConstraint getAnalysisConstraintExpectedVolume() {
		return (ExpectedVolumeConstraint)getMixed().get(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXPECTED_VOLUME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnalysisConstraintExpectedVolume(ExpectedVolumeConstraint newAnalysisConstraintExpectedVolume, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXPECTED_VOLUME, newAnalysisConstraintExpectedVolume, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnalysisConstraintExpectedVolume(ExpectedVolumeConstraint newAnalysisConstraintExpectedVolume) {
		((FeatureMap.Internal)getMixed()).set(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXPECTED_VOLUME, newAnalysisConstraintExpectedVolume);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PeakLoadConstraint getAnalysisConstraintPeakLoad() {
		return (PeakLoadConstraint)getMixed().get(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_PEAK_LOAD, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnalysisConstraintPeakLoad(PeakLoadConstraint newAnalysisConstraintPeakLoad, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_PEAK_LOAD, newAnalysisConstraintPeakLoad, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnalysisConstraintPeakLoad(PeakLoadConstraint newAnalysisConstraintPeakLoad) {
		((FeatureMap.Internal)getMixed()).set(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_PEAK_LOAD, newAnalysisConstraintPeakLoad);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResponseTimeConstraint getAnalysisConstraintResponseTime() {
		return (ResponseTimeConstraint)getMixed().get(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_RESPONSE_TIME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnalysisConstraintResponseTime(ResponseTimeConstraint newAnalysisConstraintResponseTime, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_RESPONSE_TIME, newAnalysisConstraintResponseTime, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnalysisConstraintResponseTime(ResponseTimeConstraint newAnalysisConstraintResponseTime) {
		((FeatureMap.Internal)getMixed()).set(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_RESPONSE_TIME, newAnalysisConstraintResponseTime);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SizePerSubmissionConstraint getAnalysisConstraintSizePerSubmission() {
		return (SizePerSubmissionConstraint)getMixed().get(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_SIZE_PER_SUBMISSION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnalysisConstraintSizePerSubmission(SizePerSubmissionConstraint newAnalysisConstraintSizePerSubmission, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_SIZE_PER_SUBMISSION, newAnalysisConstraintSizePerSubmission, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnalysisConstraintSizePerSubmission(SizePerSubmissionConstraint newAnalysisConstraintSizePerSubmission) {
		((FeatureMap.Internal)getMixed()).set(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_SIZE_PER_SUBMISSION, newAnalysisConstraintSizePerSubmission);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UsageWindowPerDayConstraint getAnalysisConstraintUsageWindowPerDay() {
		return (UsageWindowPerDayConstraint)getMixed().get(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_USAGE_WINDOW_PER_DAY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnalysisConstraintUsageWindowPerDay(UsageWindowPerDayConstraint newAnalysisConstraintUsageWindowPerDay, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_USAGE_WINDOW_PER_DAY, newAnalysisConstraintUsageWindowPerDay, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnalysisConstraintUsageWindowPerDay(UsageWindowPerDayConstraint newAnalysisConstraintUsageWindowPerDay) {
		((FeatureMap.Internal)getMixed()).set(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_USAGE_WINDOW_PER_DAY, newAnalysisConstraintUsageWindowPerDay);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Deployment getCapabilityDeployment() {
		return (Deployment)getMixed().get(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__CAPABILITY_DEPLOYMENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityDeployment(Deployment newCapabilityDeployment, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__CAPABILITY_DEPLOYMENT, newCapabilityDeployment, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityDeployment(Deployment newCapabilityDeployment) {
		((FeatureMap.Internal)getMixed()).set(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__CAPABILITY_DEPLOYMENT, newCapabilityDeployment);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getCapabilityNode() {
		return (Node)getMixed().get(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__CAPABILITY_NODE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityNode(Node newCapabilityNode, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__CAPABILITY_NODE, newCapabilityNode, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityNode(Node newCapabilityNode) {
		((FeatureMap.Internal)getMixed()).set(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__CAPABILITY_NODE, newCapabilityNode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalysisConstraint getConstraintAnalysisConstraint() {
		return (AnalysisConstraint)getMixed().get(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__CONSTRAINT_ANALYSIS_CONSTRAINT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConstraintAnalysisConstraint(AnalysisConstraint newConstraintAnalysisConstraint, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__CONSTRAINT_ANALYSIS_CONSTRAINT, newConstraintAnalysisConstraint, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraintAnalysisConstraint(AnalysisConstraint newConstraintAnalysisConstraint) {
		((FeatureMap.Internal)getMixed()).set(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__CONSTRAINT_ANALYSIS_CONSTRAINT, newConstraintAnalysisConstraint);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeploymentUnit getUnitDeploymentUnit() {
		return (DeploymentUnit)getMixed().get(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__UNIT_DEPLOYMENT_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitDeploymentUnit(DeploymentUnit newUnitDeploymentUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__UNIT_DEPLOYMENT_UNIT, newUnitDeploymentUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitDeploymentUnit(DeploymentUnit newUnitDeploymentUnit) {
		((FeatureMap.Internal)getMixed()).set(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__UNIT_DEPLOYMENT_UNIT, newUnitDeploymentUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocationUnit getUnitLocation() {
		return (LocationUnit)getMixed().get(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__UNIT_LOCATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitLocation(LocationUnit newUnitLocation, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__UNIT_LOCATION, newUnitLocation, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitLocation(LocationUnit newUnitLocation) {
		((FeatureMap.Internal)getMixed()).set(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__UNIT_LOCATION, newUnitLocation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeUnit getUnitNode() {
		return (NodeUnit)getMixed().get(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__UNIT_NODE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitNode(NodeUnit newUnitNode, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__UNIT_NODE, newUnitNode, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitNode(NodeUnit newUnitNode) {
		((FeatureMap.Internal)getMixed()).set(AnalysisPackage.Literals.ANALYSIS_DEPLOY_ROOT__UNIT_NODE, newUnitNode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__MIXED:
				return ((InternalEList)getMixed()).basicRemove(otherEnd, msgs);
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_AVAILABILITY:
				return basicSetAnalysisConstraintAvailability(null, msgs);
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_DAILY_LOAD:
				return basicSetAnalysisConstraintDailyLoad(null, msgs);
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_DATA_SERVICE:
				return basicSetAnalysisConstraintDataService(null, msgs);
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXECUTION_SERVICE:
				return basicSetAnalysisConstraintExecutionService(null, msgs);
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXPECTED_LIFESPAN:
				return basicSetAnalysisConstraintExpectedLifespan(null, msgs);
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXPECTED_VOLUME:
				return basicSetAnalysisConstraintExpectedVolume(null, msgs);
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_PEAK_LOAD:
				return basicSetAnalysisConstraintPeakLoad(null, msgs);
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_RESPONSE_TIME:
				return basicSetAnalysisConstraintResponseTime(null, msgs);
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_SIZE_PER_SUBMISSION:
				return basicSetAnalysisConstraintSizePerSubmission(null, msgs);
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_USAGE_WINDOW_PER_DAY:
				return basicSetAnalysisConstraintUsageWindowPerDay(null, msgs);
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__CAPABILITY_DEPLOYMENT:
				return basicSetCapabilityDeployment(null, msgs);
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__CAPABILITY_NODE:
				return basicSetCapabilityNode(null, msgs);
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__CONSTRAINT_ANALYSIS_CONSTRAINT:
				return basicSetConstraintAnalysisConstraint(null, msgs);
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__UNIT_DEPLOYMENT_UNIT:
				return basicSetUnitDeploymentUnit(null, msgs);
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__UNIT_LOCATION:
				return basicSetUnitLocation(null, msgs);
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__UNIT_NODE:
				return basicSetUnitNode(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_AVAILABILITY:
				return getAnalysisConstraintAvailability();
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_DAILY_LOAD:
				return getAnalysisConstraintDailyLoad();
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_DATA_SERVICE:
				return getAnalysisConstraintDataService();
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXECUTION_SERVICE:
				return getAnalysisConstraintExecutionService();
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXPECTED_LIFESPAN:
				return getAnalysisConstraintExpectedLifespan();
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXPECTED_VOLUME:
				return getAnalysisConstraintExpectedVolume();
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_PEAK_LOAD:
				return getAnalysisConstraintPeakLoad();
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_RESPONSE_TIME:
				return getAnalysisConstraintResponseTime();
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_SIZE_PER_SUBMISSION:
				return getAnalysisConstraintSizePerSubmission();
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_USAGE_WINDOW_PER_DAY:
				return getAnalysisConstraintUsageWindowPerDay();
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__CAPABILITY_DEPLOYMENT:
				return getCapabilityDeployment();
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__CAPABILITY_NODE:
				return getCapabilityNode();
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__CONSTRAINT_ANALYSIS_CONSTRAINT:
				return getConstraintAnalysisConstraint();
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__UNIT_DEPLOYMENT_UNIT:
				return getUnitDeploymentUnit();
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__UNIT_LOCATION:
				return getUnitLocation();
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__UNIT_NODE:
				return getUnitNode();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_AVAILABILITY:
				setAnalysisConstraintAvailability((AvailabilityConstraint)newValue);
				return;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_DAILY_LOAD:
				setAnalysisConstraintDailyLoad((DailyLoadConstraint)newValue);
				return;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_DATA_SERVICE:
				setAnalysisConstraintDataService((DataServiceConstraint)newValue);
				return;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXECUTION_SERVICE:
				setAnalysisConstraintExecutionService((ExecutionServiceConstraint)newValue);
				return;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXPECTED_LIFESPAN:
				setAnalysisConstraintExpectedLifespan((ExpectedLifespanConstraint)newValue);
				return;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXPECTED_VOLUME:
				setAnalysisConstraintExpectedVolume((ExpectedVolumeConstraint)newValue);
				return;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_PEAK_LOAD:
				setAnalysisConstraintPeakLoad((PeakLoadConstraint)newValue);
				return;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_RESPONSE_TIME:
				setAnalysisConstraintResponseTime((ResponseTimeConstraint)newValue);
				return;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_SIZE_PER_SUBMISSION:
				setAnalysisConstraintSizePerSubmission((SizePerSubmissionConstraint)newValue);
				return;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_USAGE_WINDOW_PER_DAY:
				setAnalysisConstraintUsageWindowPerDay((UsageWindowPerDayConstraint)newValue);
				return;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__CAPABILITY_DEPLOYMENT:
				setCapabilityDeployment((Deployment)newValue);
				return;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__CAPABILITY_NODE:
				setCapabilityNode((Node)newValue);
				return;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__CONSTRAINT_ANALYSIS_CONSTRAINT:
				setConstraintAnalysisConstraint((AnalysisConstraint)newValue);
				return;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__UNIT_DEPLOYMENT_UNIT:
				setUnitDeploymentUnit((DeploymentUnit)newValue);
				return;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__UNIT_LOCATION:
				setUnitLocation((LocationUnit)newValue);
				return;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__UNIT_NODE:
				setUnitNode((NodeUnit)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__MIXED:
				getMixed().clear();
				return;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_AVAILABILITY:
				setAnalysisConstraintAvailability((AvailabilityConstraint)null);
				return;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_DAILY_LOAD:
				setAnalysisConstraintDailyLoad((DailyLoadConstraint)null);
				return;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_DATA_SERVICE:
				setAnalysisConstraintDataService((DataServiceConstraint)null);
				return;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXECUTION_SERVICE:
				setAnalysisConstraintExecutionService((ExecutionServiceConstraint)null);
				return;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXPECTED_LIFESPAN:
				setAnalysisConstraintExpectedLifespan((ExpectedLifespanConstraint)null);
				return;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXPECTED_VOLUME:
				setAnalysisConstraintExpectedVolume((ExpectedVolumeConstraint)null);
				return;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_PEAK_LOAD:
				setAnalysisConstraintPeakLoad((PeakLoadConstraint)null);
				return;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_RESPONSE_TIME:
				setAnalysisConstraintResponseTime((ResponseTimeConstraint)null);
				return;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_SIZE_PER_SUBMISSION:
				setAnalysisConstraintSizePerSubmission((SizePerSubmissionConstraint)null);
				return;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_USAGE_WINDOW_PER_DAY:
				setAnalysisConstraintUsageWindowPerDay((UsageWindowPerDayConstraint)null);
				return;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__CAPABILITY_DEPLOYMENT:
				setCapabilityDeployment((Deployment)null);
				return;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__CAPABILITY_NODE:
				setCapabilityNode((Node)null);
				return;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__CONSTRAINT_ANALYSIS_CONSTRAINT:
				setConstraintAnalysisConstraint((AnalysisConstraint)null);
				return;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__UNIT_DEPLOYMENT_UNIT:
				setUnitDeploymentUnit((DeploymentUnit)null);
				return;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__UNIT_LOCATION:
				setUnitLocation((LocationUnit)null);
				return;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__UNIT_NODE:
				setUnitNode((NodeUnit)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_AVAILABILITY:
				return getAnalysisConstraintAvailability() != null;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_DAILY_LOAD:
				return getAnalysisConstraintDailyLoad() != null;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_DATA_SERVICE:
				return getAnalysisConstraintDataService() != null;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXECUTION_SERVICE:
				return getAnalysisConstraintExecutionService() != null;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXPECTED_LIFESPAN:
				return getAnalysisConstraintExpectedLifespan() != null;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXPECTED_VOLUME:
				return getAnalysisConstraintExpectedVolume() != null;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_PEAK_LOAD:
				return getAnalysisConstraintPeakLoad() != null;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_RESPONSE_TIME:
				return getAnalysisConstraintResponseTime() != null;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_SIZE_PER_SUBMISSION:
				return getAnalysisConstraintSizePerSubmission() != null;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_USAGE_WINDOW_PER_DAY:
				return getAnalysisConstraintUsageWindowPerDay() != null;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__CAPABILITY_DEPLOYMENT:
				return getCapabilityDeployment() != null;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__CAPABILITY_NODE:
				return getCapabilityNode() != null;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__CONSTRAINT_ANALYSIS_CONSTRAINT:
				return getConstraintAnalysisConstraint() != null;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__UNIT_DEPLOYMENT_UNIT:
				return getUnitDeploymentUnit() != null;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__UNIT_LOCATION:
				return getUnitLocation() != null;
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT__UNIT_NODE:
				return getUnitNode() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (mixed: "); //$NON-NLS-1$
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //AnalysisDeployRootImpl
