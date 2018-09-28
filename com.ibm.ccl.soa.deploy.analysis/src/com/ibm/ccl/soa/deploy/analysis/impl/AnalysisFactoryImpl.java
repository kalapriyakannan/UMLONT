/**
 * <copyright>
 * </copyright>
 *
 * $Id: AnalysisFactoryImpl.java,v 1.9 2008/02/05 22:21:31 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.analysis.impl;

import com.ibm.ccl.soa.deploy.analysis.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.ibm.ccl.soa.deploy.analysis.AnalysisConstraint;
import com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot;
import com.ibm.ccl.soa.deploy.analysis.AnalysisFactory;
import com.ibm.ccl.soa.deploy.analysis.AnalysisPackage;
import com.ibm.ccl.soa.deploy.analysis.AvailabilityConstraint;
import com.ibm.ccl.soa.deploy.analysis.DailyLoadConstraint;
import com.ibm.ccl.soa.deploy.analysis.DataServiceConstraint;
import com.ibm.ccl.soa.deploy.analysis.DataServiceType;
import com.ibm.ccl.soa.deploy.analysis.Deployment;
import com.ibm.ccl.soa.deploy.analysis.DeploymentUnit;
import com.ibm.ccl.soa.deploy.analysis.DeploymentUnitFacet;
import com.ibm.ccl.soa.deploy.analysis.ExecutionServiceConstraint;
import com.ibm.ccl.soa.deploy.analysis.ExecutionServiceType;
import com.ibm.ccl.soa.deploy.analysis.ExpectedLifespanConstraint;
import com.ibm.ccl.soa.deploy.analysis.ExpectedVolumeConstraint;
import com.ibm.ccl.soa.deploy.analysis.LifespanState;
import com.ibm.ccl.soa.deploy.analysis.LocationUnit;
import com.ibm.ccl.soa.deploy.analysis.Node;
import com.ibm.ccl.soa.deploy.analysis.NodeUnit;
import com.ibm.ccl.soa.deploy.analysis.PeakLoadConstraint;
import com.ibm.ccl.soa.deploy.analysis.ResponseTimeConstraint;
import com.ibm.ccl.soa.deploy.analysis.SizePerSubmissionConstraint;
import com.ibm.ccl.soa.deploy.analysis.UsageWindowPerDayConstraint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AnalysisFactoryImpl extends EFactoryImpl implements AnalysisFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AnalysisFactory init() {
		try {
			AnalysisFactory theAnalysisFactory = (AnalysisFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.ibm.com/ccl/soa/deploy/analysis/1.0.0/"); //$NON-NLS-1$ 
			if (theAnalysisFactory != null) {
				return theAnalysisFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AnalysisFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalysisFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case AnalysisPackage.ANALYSIS_CONSTRAINT: return createAnalysisConstraint();
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT: return createAnalysisDeployRoot();
			case AnalysisPackage.AVAILABILITY_CONSTRAINT: return createAvailabilityConstraint();
			case AnalysisPackage.DAILY_LOAD_CONSTRAINT: return createDailyLoadConstraint();
			case AnalysisPackage.DATA_SERVICE_CONSTRAINT: return createDataServiceConstraint();
			case AnalysisPackage.DEPLOYMENT: return createDeployment();
			case AnalysisPackage.DEPLOYMENT_UNIT: return createDeploymentUnit();
			case AnalysisPackage.EXECUTION_SERVICE_CONSTRAINT: return createExecutionServiceConstraint();
			case AnalysisPackage.EXPECTED_LIFESPAN_CONSTRAINT: return createExpectedLifespanConstraint();
			case AnalysisPackage.EXPECTED_VOLUME_CONSTRAINT: return createExpectedVolumeConstraint();
			case AnalysisPackage.LOCATION_UNIT: return createLocationUnit();
			case AnalysisPackage.NODE: return createNode();
			case AnalysisPackage.NODE_UNIT: return createNodeUnit();
			case AnalysisPackage.PEAK_LOAD_CONSTRAINT: return createPeakLoadConstraint();
			case AnalysisPackage.RESPONSE_TIME_CONSTRAINT: return createResponseTimeConstraint();
			case AnalysisPackage.SIZE_PER_SUBMISSION_CONSTRAINT: return createSizePerSubmissionConstraint();
			case AnalysisPackage.USAGE_WINDOW_PER_DAY_CONSTRAINT: return createUsageWindowPerDayConstraint();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case AnalysisPackage.DATA_SERVICE_TYPE:
				return createDataServiceTypeFromString(eDataType, initialValue);
			case AnalysisPackage.DEPLOYMENT_UNIT_FACET:
				return createDeploymentUnitFacetFromString(eDataType, initialValue);
			case AnalysisPackage.EXECUTION_SERVICE_TYPE:
				return createExecutionServiceTypeFromString(eDataType, initialValue);
			case AnalysisPackage.LIFESPAN_STATE:
				return createLifespanStateFromString(eDataType, initialValue);
			case AnalysisPackage.DATA_SERVICE_TYPE_OBJECT:
				return createDataServiceTypeObjectFromString(eDataType, initialValue);
			case AnalysisPackage.DEPLOYMENT_UNIT_FACET_OBJECT:
				return createDeploymentUnitFacetObjectFromString(eDataType, initialValue);
			case AnalysisPackage.EXECUTION_SERVICE_TYPE_OBJECT:
				return createExecutionServiceTypeObjectFromString(eDataType, initialValue);
			case AnalysisPackage.LIFESPAN_STATE_OBJECT:
				return createLifespanStateObjectFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case AnalysisPackage.DATA_SERVICE_TYPE:
				return convertDataServiceTypeToString(eDataType, instanceValue);
			case AnalysisPackage.DEPLOYMENT_UNIT_FACET:
				return convertDeploymentUnitFacetToString(eDataType, instanceValue);
			case AnalysisPackage.EXECUTION_SERVICE_TYPE:
				return convertExecutionServiceTypeToString(eDataType, instanceValue);
			case AnalysisPackage.LIFESPAN_STATE:
				return convertLifespanStateToString(eDataType, instanceValue);
			case AnalysisPackage.DATA_SERVICE_TYPE_OBJECT:
				return convertDataServiceTypeObjectToString(eDataType, instanceValue);
			case AnalysisPackage.DEPLOYMENT_UNIT_FACET_OBJECT:
				return convertDeploymentUnitFacetObjectToString(eDataType, instanceValue);
			case AnalysisPackage.EXECUTION_SERVICE_TYPE_OBJECT:
				return convertExecutionServiceTypeObjectToString(eDataType, instanceValue);
			case AnalysisPackage.LIFESPAN_STATE_OBJECT:
				return convertLifespanStateObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalysisConstraint createAnalysisConstraint() {
		AnalysisConstraintImpl analysisConstraint = new AnalysisConstraintImpl();
		return analysisConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalysisDeployRoot createAnalysisDeployRoot() {
		AnalysisDeployRootImpl analysisDeployRoot = new AnalysisDeployRootImpl();
		return analysisDeployRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AvailabilityConstraint createAvailabilityConstraint() {
		AvailabilityConstraintImpl availabilityConstraint = new AvailabilityConstraintImpl();
		return availabilityConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DailyLoadConstraint createDailyLoadConstraint() {
		DailyLoadConstraintImpl dailyLoadConstraint = new DailyLoadConstraintImpl();
		return dailyLoadConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataServiceConstraint createDataServiceConstraint() {
		DataServiceConstraintImpl dataServiceConstraint = new DataServiceConstraintImpl();
		return dataServiceConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Deployment createDeployment() {
		DeploymentImpl deployment = new DeploymentImpl();
		return deployment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeploymentUnit createDeploymentUnit() {
		DeploymentUnitImpl deploymentUnit = new DeploymentUnitImpl();
		return deploymentUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionServiceConstraint createExecutionServiceConstraint() {
		ExecutionServiceConstraintImpl executionServiceConstraint = new ExecutionServiceConstraintImpl();
		return executionServiceConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpectedLifespanConstraint createExpectedLifespanConstraint() {
		ExpectedLifespanConstraintImpl expectedLifespanConstraint = new ExpectedLifespanConstraintImpl();
		return expectedLifespanConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpectedVolumeConstraint createExpectedVolumeConstraint() {
		ExpectedVolumeConstraintImpl expectedVolumeConstraint = new ExpectedVolumeConstraintImpl();
		return expectedVolumeConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocationUnit createLocationUnit() {
		LocationUnitImpl locationUnit = new LocationUnitImpl();
		return locationUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node createNode() {
		NodeImpl node = new NodeImpl();
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeUnit createNodeUnit() {
		NodeUnitImpl nodeUnit = new NodeUnitImpl();
		return nodeUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PeakLoadConstraint createPeakLoadConstraint() {
		PeakLoadConstraintImpl peakLoadConstraint = new PeakLoadConstraintImpl();
		return peakLoadConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResponseTimeConstraint createResponseTimeConstraint() {
		ResponseTimeConstraintImpl responseTimeConstraint = new ResponseTimeConstraintImpl();
		return responseTimeConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SizePerSubmissionConstraint createSizePerSubmissionConstraint() {
		SizePerSubmissionConstraintImpl sizePerSubmissionConstraint = new SizePerSubmissionConstraintImpl();
		return sizePerSubmissionConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UsageWindowPerDayConstraint createUsageWindowPerDayConstraint() {
		UsageWindowPerDayConstraintImpl usageWindowPerDayConstraint = new UsageWindowPerDayConstraintImpl();
		return usageWindowPerDayConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataServiceType createDataServiceTypeFromString(EDataType eDataType, String initialValue) {
		DataServiceType result = DataServiceType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDataServiceTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeploymentUnitFacet createDeploymentUnitFacetFromString(EDataType eDataType, String initialValue) {
		DeploymentUnitFacet result = DeploymentUnitFacet.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDeploymentUnitFacetToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionServiceType createExecutionServiceTypeFromString(EDataType eDataType, String initialValue) {
		ExecutionServiceType result = ExecutionServiceType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertExecutionServiceTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LifespanState createLifespanStateFromString(EDataType eDataType, String initialValue) {
		LifespanState result = LifespanState.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLifespanStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataServiceType createDataServiceTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createDataServiceTypeFromString(AnalysisPackage.Literals.DATA_SERVICE_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDataServiceTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertDataServiceTypeToString(AnalysisPackage.Literals.DATA_SERVICE_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeploymentUnitFacet createDeploymentUnitFacetObjectFromString(EDataType eDataType, String initialValue) {
		return createDeploymentUnitFacetFromString(AnalysisPackage.Literals.DEPLOYMENT_UNIT_FACET, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDeploymentUnitFacetObjectToString(EDataType eDataType, Object instanceValue) {
		return convertDeploymentUnitFacetToString(AnalysisPackage.Literals.DEPLOYMENT_UNIT_FACET, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionServiceType createExecutionServiceTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createExecutionServiceTypeFromString(AnalysisPackage.Literals.EXECUTION_SERVICE_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertExecutionServiceTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertExecutionServiceTypeToString(AnalysisPackage.Literals.EXECUTION_SERVICE_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LifespanState createLifespanStateObjectFromString(EDataType eDataType, String initialValue) {
		return createLifespanStateFromString(AnalysisPackage.Literals.LIFESPAN_STATE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLifespanStateObjectToString(EDataType eDataType, Object instanceValue) {
		return convertLifespanStateToString(AnalysisPackage.Literals.LIFESPAN_STATE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalysisPackage getAnalysisPackage() {
		return (AnalysisPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static AnalysisPackage getPackage() {
		return AnalysisPackage.eINSTANCE;
	}

} //AnalysisFactoryImpl
