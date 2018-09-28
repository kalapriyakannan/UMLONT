/**
 * <copyright>
 * </copyright>
 *
 * $Id: AnalysisPackageImpl.java,v 1.13 2007/12/13 17:55:28 nmakin Exp $
 */
package com.ibm.ccl.soa.deploy.analysis.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

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
import com.ibm.ccl.soa.deploy.core.CorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AnalysisPackageImpl extends EPackageImpl implements AnalysisPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass analysisConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass analysisDeployRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass availabilityConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dailyLoadConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataServiceConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deploymentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deploymentUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass executionServiceConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expectedLifespanConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expectedVolumeConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass locationUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeUnitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass peakLoadConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass responseTimeConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sizePerSubmissionConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass usageWindowPerDayConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum dataServiceTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum deploymentUnitFacetEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum executionServiceTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum lifespanStateEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType dataServiceTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType deploymentUnitFacetObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType executionServiceTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType lifespanStateObjectEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AnalysisPackageImpl() {
		super(eNS_URI, AnalysisFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AnalysisPackage init() {
		if (isInited) return (AnalysisPackage)EPackage.Registry.INSTANCE.getEPackage(AnalysisPackage.eNS_URI);

		// Obtain or create and register package
		AnalysisPackageImpl theAnalysisPackage = (AnalysisPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof AnalysisPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new AnalysisPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theAnalysisPackage.createPackageContents();

		// Initialize created meta-data
		theAnalysisPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAnalysisPackage.freeze();

		return theAnalysisPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnalysisConstraint() {
		return analysisConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnalysisDeployRoot() {
		return analysisDeployRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnalysisDeployRoot_Mixed() {
		return (EAttribute)analysisDeployRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnalysisDeployRoot_XMLNSPrefixMap() {
		return (EReference)analysisDeployRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnalysisDeployRoot_XSISchemaLocation() {
		return (EReference)analysisDeployRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnalysisDeployRoot_AnalysisConstraintAvailability() {
		return (EReference)analysisDeployRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnalysisDeployRoot_AnalysisConstraintDailyLoad() {
		return (EReference)analysisDeployRootEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnalysisDeployRoot_AnalysisConstraintDataService() {
		return (EReference)analysisDeployRootEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnalysisDeployRoot_AnalysisConstraintExecutionService() {
		return (EReference)analysisDeployRootEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnalysisDeployRoot_AnalysisConstraintExpectedLifespan() {
		return (EReference)analysisDeployRootEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnalysisDeployRoot_AnalysisConstraintExpectedVolume() {
		return (EReference)analysisDeployRootEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnalysisDeployRoot_AnalysisConstraintPeakLoad() {
		return (EReference)analysisDeployRootEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnalysisDeployRoot_AnalysisConstraintResponseTime() {
		return (EReference)analysisDeployRootEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnalysisDeployRoot_AnalysisConstraintSizePerSubmission() {
		return (EReference)analysisDeployRootEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnalysisDeployRoot_AnalysisConstraintUsageWindowPerDay() {
		return (EReference)analysisDeployRootEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnalysisDeployRoot_CapabilityDeployment() {
		return (EReference)analysisDeployRootEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnalysisDeployRoot_CapabilityNode() {
		return (EReference)analysisDeployRootEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnalysisDeployRoot_ConstraintAnalysisConstraint() {
		return (EReference)analysisDeployRootEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnalysisDeployRoot_UnitDeploymentUnit() {
		return (EReference)analysisDeployRootEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnalysisDeployRoot_UnitLocation() {
		return (EReference)analysisDeployRootEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnalysisDeployRoot_UnitNode() {
		return (EReference)analysisDeployRootEClass.getEStructuralFeatures().get(18);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAvailabilityConstraint() {
		return availabilityConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAvailabilityConstraint_Percentage() {
		return (EAttribute)availabilityConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDailyLoadConstraint() {
		return dailyLoadConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDailyLoadConstraint_DailyLoad() {
		return (EAttribute)dailyLoadConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataServiceConstraint() {
		return dataServiceConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataServiceConstraint_Type() {
		return (EAttribute)dataServiceConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeployment() {
		return deploymentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDeployment_Facet() {
		return (EAttribute)deploymentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeploymentUnit() {
		return deploymentUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExecutionServiceConstraint() {
		return executionServiceConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExecutionServiceConstraint_Type() {
		return (EAttribute)executionServiceConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpectedLifespanConstraint() {
		return expectedLifespanConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpectedLifespanConstraint_Duration() {
		return (EAttribute)expectedLifespanConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpectedLifespanConstraint_State() {
		return (EAttribute)expectedLifespanConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpectedVolumeConstraint() {
		return expectedVolumeConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpectedVolumeConstraint_GrowthRatePercentage() {
		return (EAttribute)expectedVolumeConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpectedVolumeConstraint_InitialSize() {
		return (EAttribute)expectedVolumeConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocationUnit() {
		return locationUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNode() {
		return nodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNodeUnit() {
		return nodeUnitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPeakLoadConstraint() {
		return peakLoadConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPeakLoadConstraint_PeakLoad() {
		return (EAttribute)peakLoadConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResponseTimeConstraint() {
		return responseTimeConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResponseTimeConstraint_Duration() {
		return (EAttribute)responseTimeConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResponseTimeConstraint_Percentage() {
		return (EAttribute)responseTimeConstraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSizePerSubmissionConstraint() {
		return sizePerSubmissionConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSizePerSubmissionConstraint_Bytes() {
		return (EAttribute)sizePerSubmissionConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUsageWindowPerDayConstraint() {
		return usageWindowPerDayConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUsageWindowPerDayConstraint_Duration() {
		return (EAttribute)usageWindowPerDayConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDataServiceType() {
		return dataServiceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDeploymentUnitFacet() {
		return deploymentUnitFacetEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getExecutionServiceType() {
		return executionServiceTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLifespanState() {
		return lifespanStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getDataServiceTypeObject() {
		return dataServiceTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getDeploymentUnitFacetObject() {
		return deploymentUnitFacetObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getExecutionServiceTypeObject() {
		return executionServiceTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLifespanStateObject() {
		return lifespanStateObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalysisFactory getAnalysisFactory() {
		return (AnalysisFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		analysisConstraintEClass = createEClass(ANALYSIS_CONSTRAINT);

		analysisDeployRootEClass = createEClass(ANALYSIS_DEPLOY_ROOT);
		createEAttribute(analysisDeployRootEClass, ANALYSIS_DEPLOY_ROOT__MIXED);
		createEReference(analysisDeployRootEClass, ANALYSIS_DEPLOY_ROOT__XMLNS_PREFIX_MAP);
		createEReference(analysisDeployRootEClass, ANALYSIS_DEPLOY_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(analysisDeployRootEClass, ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_AVAILABILITY);
		createEReference(analysisDeployRootEClass, ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_DAILY_LOAD);
		createEReference(analysisDeployRootEClass, ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_DATA_SERVICE);
		createEReference(analysisDeployRootEClass, ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXECUTION_SERVICE);
		createEReference(analysisDeployRootEClass, ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXPECTED_LIFESPAN);
		createEReference(analysisDeployRootEClass, ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_EXPECTED_VOLUME);
		createEReference(analysisDeployRootEClass, ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_PEAK_LOAD);
		createEReference(analysisDeployRootEClass, ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_RESPONSE_TIME);
		createEReference(analysisDeployRootEClass, ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_SIZE_PER_SUBMISSION);
		createEReference(analysisDeployRootEClass, ANALYSIS_DEPLOY_ROOT__ANALYSIS_CONSTRAINT_USAGE_WINDOW_PER_DAY);
		createEReference(analysisDeployRootEClass, ANALYSIS_DEPLOY_ROOT__CAPABILITY_DEPLOYMENT);
		createEReference(analysisDeployRootEClass, ANALYSIS_DEPLOY_ROOT__CAPABILITY_NODE);
		createEReference(analysisDeployRootEClass, ANALYSIS_DEPLOY_ROOT__CONSTRAINT_ANALYSIS_CONSTRAINT);
		createEReference(analysisDeployRootEClass, ANALYSIS_DEPLOY_ROOT__UNIT_DEPLOYMENT_UNIT);
		createEReference(analysisDeployRootEClass, ANALYSIS_DEPLOY_ROOT__UNIT_LOCATION);
		createEReference(analysisDeployRootEClass, ANALYSIS_DEPLOY_ROOT__UNIT_NODE);

		availabilityConstraintEClass = createEClass(AVAILABILITY_CONSTRAINT);
		createEAttribute(availabilityConstraintEClass, AVAILABILITY_CONSTRAINT__PERCENTAGE);

		dailyLoadConstraintEClass = createEClass(DAILY_LOAD_CONSTRAINT);
		createEAttribute(dailyLoadConstraintEClass, DAILY_LOAD_CONSTRAINT__DAILY_LOAD);

		dataServiceConstraintEClass = createEClass(DATA_SERVICE_CONSTRAINT);
		createEAttribute(dataServiceConstraintEClass, DATA_SERVICE_CONSTRAINT__TYPE);

		deploymentEClass = createEClass(DEPLOYMENT);
		createEAttribute(deploymentEClass, DEPLOYMENT__FACET);

		deploymentUnitEClass = createEClass(DEPLOYMENT_UNIT);

		executionServiceConstraintEClass = createEClass(EXECUTION_SERVICE_CONSTRAINT);
		createEAttribute(executionServiceConstraintEClass, EXECUTION_SERVICE_CONSTRAINT__TYPE);

		expectedLifespanConstraintEClass = createEClass(EXPECTED_LIFESPAN_CONSTRAINT);
		createEAttribute(expectedLifespanConstraintEClass, EXPECTED_LIFESPAN_CONSTRAINT__DURATION);
		createEAttribute(expectedLifespanConstraintEClass, EXPECTED_LIFESPAN_CONSTRAINT__STATE);

		expectedVolumeConstraintEClass = createEClass(EXPECTED_VOLUME_CONSTRAINT);
		createEAttribute(expectedVolumeConstraintEClass, EXPECTED_VOLUME_CONSTRAINT__GROWTH_RATE_PERCENTAGE);
		createEAttribute(expectedVolumeConstraintEClass, EXPECTED_VOLUME_CONSTRAINT__INITIAL_SIZE);

		locationUnitEClass = createEClass(LOCATION_UNIT);

		nodeEClass = createEClass(NODE);

		nodeUnitEClass = createEClass(NODE_UNIT);

		peakLoadConstraintEClass = createEClass(PEAK_LOAD_CONSTRAINT);
		createEAttribute(peakLoadConstraintEClass, PEAK_LOAD_CONSTRAINT__PEAK_LOAD);

		responseTimeConstraintEClass = createEClass(RESPONSE_TIME_CONSTRAINT);
		createEAttribute(responseTimeConstraintEClass, RESPONSE_TIME_CONSTRAINT__DURATION);
		createEAttribute(responseTimeConstraintEClass, RESPONSE_TIME_CONSTRAINT__PERCENTAGE);

		sizePerSubmissionConstraintEClass = createEClass(SIZE_PER_SUBMISSION_CONSTRAINT);
		createEAttribute(sizePerSubmissionConstraintEClass, SIZE_PER_SUBMISSION_CONSTRAINT__BYTES);

		usageWindowPerDayConstraintEClass = createEClass(USAGE_WINDOW_PER_DAY_CONSTRAINT);
		createEAttribute(usageWindowPerDayConstraintEClass, USAGE_WINDOW_PER_DAY_CONSTRAINT__DURATION);

		// Create enums
		dataServiceTypeEEnum = createEEnum(DATA_SERVICE_TYPE);
		deploymentUnitFacetEEnum = createEEnum(DEPLOYMENT_UNIT_FACET);
		executionServiceTypeEEnum = createEEnum(EXECUTION_SERVICE_TYPE);
		lifespanStateEEnum = createEEnum(LIFESPAN_STATE);

		// Create data types
		dataServiceTypeObjectEDataType = createEDataType(DATA_SERVICE_TYPE_OBJECT);
		deploymentUnitFacetObjectEDataType = createEDataType(DEPLOYMENT_UNIT_FACET_OBJECT);
		executionServiceTypeObjectEDataType = createEDataType(EXECUTION_SERVICE_TYPE_OBJECT);
		lifespanStateObjectEDataType = createEDataType(LIFESPAN_STATE_OBJECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Add supertypes to classes
		analysisConstraintEClass.getESuperTypes().add(theCorePackage.getConstraint());
		availabilityConstraintEClass.getESuperTypes().add(this.getAnalysisConstraint());
		dailyLoadConstraintEClass.getESuperTypes().add(this.getAnalysisConstraint());
		dataServiceConstraintEClass.getESuperTypes().add(this.getAnalysisConstraint());
		deploymentEClass.getESuperTypes().add(theCorePackage.getCapability());
		deploymentUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		executionServiceConstraintEClass.getESuperTypes().add(this.getAnalysisConstraint());
		expectedLifespanConstraintEClass.getESuperTypes().add(this.getAnalysisConstraint());
		expectedVolumeConstraintEClass.getESuperTypes().add(this.getAnalysisConstraint());
		locationUnitEClass.getESuperTypes().add(theCorePackage.getUnit());
		nodeEClass.getESuperTypes().add(theCorePackage.getCapability());
		nodeUnitEClass.getESuperTypes().add(theCorePackage.getConceptualNode());
		peakLoadConstraintEClass.getESuperTypes().add(this.getAnalysisConstraint());
		responseTimeConstraintEClass.getESuperTypes().add(this.getAnalysisConstraint());
		sizePerSubmissionConstraintEClass.getESuperTypes().add(this.getAnalysisConstraint());
		usageWindowPerDayConstraintEClass.getESuperTypes().add(this.getAnalysisConstraint());

		// Initialize classes and features; add operations and parameters
		initEClass(analysisConstraintEClass, AnalysisConstraint.class, "AnalysisConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(analysisDeployRootEClass, AnalysisDeployRoot.class, "AnalysisDeployRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getAnalysisDeployRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAnalysisDeployRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAnalysisDeployRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAnalysisDeployRoot_AnalysisConstraintAvailability(), this.getAvailabilityConstraint(), null, "analysisConstraintAvailability", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAnalysisDeployRoot_AnalysisConstraintDailyLoad(), this.getDailyLoadConstraint(), null, "analysisConstraintDailyLoad", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAnalysisDeployRoot_AnalysisConstraintDataService(), this.getDataServiceConstraint(), null, "analysisConstraintDataService", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAnalysisDeployRoot_AnalysisConstraintExecutionService(), this.getExecutionServiceConstraint(), null, "analysisConstraintExecutionService", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAnalysisDeployRoot_AnalysisConstraintExpectedLifespan(), this.getExpectedLifespanConstraint(), null, "analysisConstraintExpectedLifespan", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAnalysisDeployRoot_AnalysisConstraintExpectedVolume(), this.getExpectedVolumeConstraint(), null, "analysisConstraintExpectedVolume", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAnalysisDeployRoot_AnalysisConstraintPeakLoad(), this.getPeakLoadConstraint(), null, "analysisConstraintPeakLoad", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAnalysisDeployRoot_AnalysisConstraintResponseTime(), this.getResponseTimeConstraint(), null, "analysisConstraintResponseTime", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAnalysisDeployRoot_AnalysisConstraintSizePerSubmission(), this.getSizePerSubmissionConstraint(), null, "analysisConstraintSizePerSubmission", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAnalysisDeployRoot_AnalysisConstraintUsageWindowPerDay(), this.getUsageWindowPerDayConstraint(), null, "analysisConstraintUsageWindowPerDay", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAnalysisDeployRoot_CapabilityDeployment(), this.getDeployment(), null, "capabilityDeployment", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAnalysisDeployRoot_CapabilityNode(), this.getNode(), null, "capabilityNode", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAnalysisDeployRoot_ConstraintAnalysisConstraint(), this.getAnalysisConstraint(), null, "constraintAnalysisConstraint", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAnalysisDeployRoot_UnitDeploymentUnit(), this.getDeploymentUnit(), null, "unitDeploymentUnit", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAnalysisDeployRoot_UnitLocation(), this.getLocationUnit(), null, "unitLocation", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAnalysisDeployRoot_UnitNode(), this.getNodeUnit(), null, "unitNode", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(availabilityConstraintEClass, AvailabilityConstraint.class, "AvailabilityConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getAvailabilityConstraint_Percentage(), theXMLTypePackage.getDouble(), "percentage", "99.9999", 0, 1, AvailabilityConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(dailyLoadConstraintEClass, DailyLoadConstraint.class, "DailyLoadConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDailyLoadConstraint_DailyLoad(), theXMLTypePackage.getInteger(), "dailyLoad", "1000", 0, 1, DailyLoadConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(dataServiceConstraintEClass, DataServiceConstraint.class, "DataServiceConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDataServiceConstraint_Type(), this.getDataServiceType(), "type", "online interactive", 0, 1, DataServiceConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(deploymentEClass, Deployment.class, "Deployment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDeployment_Facet(), this.getDeploymentUnitFacet(), "facet", "undefined", 0, 1, Deployment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(deploymentUnitEClass, DeploymentUnit.class, "DeploymentUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(executionServiceConstraintEClass, ExecutionServiceConstraint.class, "ExecutionServiceConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getExecutionServiceConstraint_Type(), this.getExecutionServiceType(), "type", "online interactive", 0, 1, ExecutionServiceConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(expectedLifespanConstraintEClass, ExpectedLifespanConstraint.class, "ExpectedLifespanConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getExpectedLifespanConstraint_Duration(), theXMLTypePackage.getDouble(), "duration", "99.9999", 0, 1, ExpectedLifespanConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getExpectedLifespanConstraint_State(), this.getLifespanState(), "state", "active", 0, 1, ExpectedLifespanConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(expectedVolumeConstraintEClass, ExpectedVolumeConstraint.class, "ExpectedVolumeConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getExpectedVolumeConstraint_GrowthRatePercentage(), theXMLTypePackage.getDouble(), "growthRatePercentage", "10", 0, 1, ExpectedVolumeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getExpectedVolumeConstraint_InitialSize(), theXMLTypePackage.getInteger(), "initialSize", "10", 0, 1, ExpectedVolumeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(locationUnitEClass, LocationUnit.class, "LocationUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(nodeEClass, Node.class, "Node", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(nodeUnitEClass, NodeUnit.class, "NodeUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(peakLoadConstraintEClass, PeakLoadConstraint.class, "PeakLoadConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getPeakLoadConstraint_PeakLoad(), theXMLTypePackage.getInteger(), "peakLoad", "10000", 0, 1, PeakLoadConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(responseTimeConstraintEClass, ResponseTimeConstraint.class, "ResponseTimeConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getResponseTimeConstraint_Duration(), theXMLTypePackage.getDouble(), "duration", "1", 0, 1, ResponseTimeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getResponseTimeConstraint_Percentage(), theXMLTypePackage.getDouble(), "percentage", "95", 0, 1, ResponseTimeConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(sizePerSubmissionConstraintEClass, SizePerSubmissionConstraint.class, "SizePerSubmissionConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getSizePerSubmissionConstraint_Bytes(), theXMLTypePackage.getInteger(), "bytes", "100", 0, 1, SizePerSubmissionConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(usageWindowPerDayConstraintEClass, UsageWindowPerDayConstraint.class, "UsageWindowPerDayConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getUsageWindowPerDayConstraint_Duration(), theXMLTypePackage.getDouble(), "duration", "24", 0, 1, UsageWindowPerDayConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		// Initialize enums and add enum literals
		initEEnum(dataServiceTypeEEnum, DataServiceType.class, "DataServiceType"); //$NON-NLS-1$
		addEEnumLiteral(dataServiceTypeEEnum, DataServiceType.ONLINE_INTERACTIVE_LITERAL);
		addEEnumLiteral(dataServiceTypeEEnum, DataServiceType.OFFLINE_LITERAL);
		addEEnumLiteral(dataServiceTypeEEnum, DataServiceType.ARCHIVE_LITERAL);
		addEEnumLiteral(dataServiceTypeEEnum, DataServiceType.REPLICATED_LITERAL);

		initEEnum(deploymentUnitFacetEEnum, DeploymentUnitFacet.class, "DeploymentUnitFacet"); //$NON-NLS-1$
		addEEnumLiteral(deploymentUnitFacetEEnum, DeploymentUnitFacet.UNDEFINED_LITERAL);
		addEEnumLiteral(deploymentUnitFacetEEnum, DeploymentUnitFacet.PRESENTATION_LITERAL);
		addEEnumLiteral(deploymentUnitFacetEEnum, DeploymentUnitFacet.EXECUTION_LITERAL);
		addEEnumLiteral(deploymentUnitFacetEEnum, DeploymentUnitFacet.DATA_LITERAL);

		initEEnum(executionServiceTypeEEnum, ExecutionServiceType.class, "ExecutionServiceType"); //$NON-NLS-1$
		addEEnumLiteral(executionServiceTypeEEnum, ExecutionServiceType.ONLINE_INTERACTIVE_LITERAL);
		addEEnumLiteral(executionServiceTypeEEnum, ExecutionServiceType.OFFLINE_LITERAL);
		addEEnumLiteral(executionServiceTypeEEnum, ExecutionServiceType.REAL_TIME_LITERAL);

		initEEnum(lifespanStateEEnum, LifespanState.class, "LifespanState"); //$NON-NLS-1$
		addEEnumLiteral(lifespanStateEEnum, LifespanState.ACTIVE_LITERAL);
		addEEnumLiteral(lifespanStateEEnum, LifespanState.ACCESSIBLE_LITERAL);

		// Initialize data types
		initEDataType(dataServiceTypeObjectEDataType, DataServiceType.class, "DataServiceTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(deploymentUnitFacetObjectEDataType, DeploymentUnitFacet.class, "DeploymentUnitFacetObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(executionServiceTypeObjectEDataType, ExecutionServiceType.class, "ExecutionServiceTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEDataType(lifespanStateObjectEDataType, LifespanState.class, "LifespanStateObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData"; //$NON-NLS-1$				
		addAnnotation
		  (analysisConstraintEClass, 
		   source, 
		   new String[] {
			 "name", "AnalysisConstraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (analysisDeployRootEClass, 
		   source, 
		   new String[] {
			 "name", "", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getAnalysisDeployRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", ":mixed" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getAnalysisDeployRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xmlns:prefix" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getAnalysisDeployRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "xsi:schemaLocation" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getAnalysisDeployRoot_AnalysisConstraintAvailability(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "analysisConstraint.availability", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getAnalysisDeployRoot_AnalysisConstraintDailyLoad(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "analysisConstraint.dailyLoad", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getAnalysisDeployRoot_AnalysisConstraintDataService(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "analysisConstraint.dataService", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getAnalysisDeployRoot_AnalysisConstraintExecutionService(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "analysisConstraint.executionService", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getAnalysisDeployRoot_AnalysisConstraintExpectedLifespan(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "analysisConstraint.expectedLifespan", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getAnalysisDeployRoot_AnalysisConstraintExpectedVolume(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "analysisConstraint.expectedVolume", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getAnalysisDeployRoot_AnalysisConstraintPeakLoad(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "analysisConstraint.peakLoad", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getAnalysisDeployRoot_AnalysisConstraintResponseTime(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "analysisConstraint.responseTime", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getAnalysisDeployRoot_AnalysisConstraintSizePerSubmission(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "analysisConstraint.sizePerSubmission", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getAnalysisDeployRoot_AnalysisConstraintUsageWindowPerDay(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "analysisConstraint.usageWindowPerDay", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getAnalysisDeployRoot_CapabilityDeployment(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.deployment", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getAnalysisDeployRoot_CapabilityNode(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "capability.node", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getAnalysisDeployRoot_ConstraintAnalysisConstraint(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "constraint.analysisConstraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#constraint" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getAnalysisDeployRoot_UnitDeploymentUnit(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.deploymentUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getAnalysisDeployRoot_UnitLocation(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.location", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getAnalysisDeployRoot_UnitNode(), 
		   source, 
		   new String[] {
			 "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "unit.node", //$NON-NLS-1$ //$NON-NLS-2$
			 "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
			 "affiliation", "http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit.ConceptualNode" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (availabilityConstraintEClass, 
		   source, 
		   new String[] {
			 "name", "AvailabilityConstraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getAvailabilityConstraint_Percentage(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "percentage" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (dailyLoadConstraintEClass, 
		   source, 
		   new String[] {
			 "name", "DailyLoadConstraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDailyLoadConstraint_DailyLoad(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "dailyLoad" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (dataServiceConstraintEClass, 
		   source, 
		   new String[] {
			 "name", "DataServiceConstraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDataServiceConstraint_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "type" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (dataServiceTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "DataServiceType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (dataServiceTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "DataServiceType:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "DataServiceType" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (deploymentEClass, 
		   source, 
		   new String[] {
			 "name", "Deployment", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getDeployment_Facet(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "facet" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (deploymentUnitEClass, 
		   source, 
		   new String[] {
			 "name", "DeploymentUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (deploymentUnitFacetEEnum, 
		   source, 
		   new String[] {
			 "name", "DeploymentUnitFacet" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (deploymentUnitFacetObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "DeploymentUnitFacet:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "DeploymentUnitFacet" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (executionServiceConstraintEClass, 
		   source, 
		   new String[] {
			 "name", "ExecutionServiceConstraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getExecutionServiceConstraint_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "type" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (executionServiceTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "ExecutionServiceType" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (executionServiceTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "ExecutionServiceType:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "ExecutionServiceType" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (expectedLifespanConstraintEClass, 
		   source, 
		   new String[] {
			 "name", "ExpectedLifespanConstraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getExpectedLifespanConstraint_Duration(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "duration" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getExpectedLifespanConstraint_State(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "state" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (expectedVolumeConstraintEClass, 
		   source, 
		   new String[] {
			 "name", "ExpectedVolumeConstraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getExpectedVolumeConstraint_GrowthRatePercentage(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "growthRatePercentage" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getExpectedVolumeConstraint_InitialSize(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "initialSize" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (lifespanStateEEnum, 
		   source, 
		   new String[] {
			 "name", "LifespanState" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (lifespanStateObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "LifespanState:Object", //$NON-NLS-1$ //$NON-NLS-2$
			 "baseType", "LifespanState" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (locationUnitEClass, 
		   source, 
		   new String[] {
			 "name", "LocationUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (nodeEClass, 
		   source, 
		   new String[] {
			 "name", "Node", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (nodeUnitEClass, 
		   source, 
		   new String[] {
			 "name", "NodeUnit", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (peakLoadConstraintEClass, 
		   source, 
		   new String[] {
			 "name", "PeakLoadConstraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getPeakLoadConstraint_PeakLoad(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "peakLoad" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (responseTimeConstraintEClass, 
		   source, 
		   new String[] {
			 "name", "ResponseTimeConstraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getResponseTimeConstraint_Duration(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "duration" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getResponseTimeConstraint_Percentage(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "percentage" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (sizePerSubmissionConstraintEClass, 
		   source, 
		   new String[] {
			 "name", "SizePerSubmissionConstraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getSizePerSubmissionConstraint_Bytes(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "bytes" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (usageWindowPerDayConstraintEClass, 
		   source, 
		   new String[] {
			 "name", "UsageWindowPerDayConstraint", //$NON-NLS-1$ //$NON-NLS-2$
			 "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
		   });		
		addAnnotation
		  (getUsageWindowPerDayConstraint_Duration(), 
		   source, 
		   new String[] {
			 "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
			 "name", "duration" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

} //AnalysisPackageImpl
