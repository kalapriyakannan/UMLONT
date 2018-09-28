/**
 * <copyright>
 * </copyright>
 *
 * $Id: AnalysisAdapterFactory.java,v 1.10 2008/02/05 22:21:31 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.analysis.util;

import com.ibm.ccl.soa.deploy.analysis.*;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

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
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.ConceptualNode;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage
 * @generated
 */
public class AnalysisAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AnalysisPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalysisAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = AnalysisPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnalysisSwitch modelSwitch =
		new AnalysisSwitch() {
			public Object caseAnalysisConstraint(AnalysisConstraint object) {
				return createAnalysisConstraintAdapter();
			}
			public Object caseAnalysisDeployRoot(AnalysisDeployRoot object) {
				return createAnalysisDeployRootAdapter();
			}
			public Object caseAvailabilityConstraint(AvailabilityConstraint object) {
				return createAvailabilityConstraintAdapter();
			}
			public Object caseDailyLoadConstraint(DailyLoadConstraint object) {
				return createDailyLoadConstraintAdapter();
			}
			public Object caseDataServiceConstraint(DataServiceConstraint object) {
				return createDataServiceConstraintAdapter();
			}
			public Object caseDeployment(Deployment object) {
				return createDeploymentAdapter();
			}
			public Object caseDeploymentUnit(DeploymentUnit object) {
				return createDeploymentUnitAdapter();
			}
			public Object caseExecutionServiceConstraint(ExecutionServiceConstraint object) {
				return createExecutionServiceConstraintAdapter();
			}
			public Object caseExpectedLifespanConstraint(ExpectedLifespanConstraint object) {
				return createExpectedLifespanConstraintAdapter();
			}
			public Object caseExpectedVolumeConstraint(ExpectedVolumeConstraint object) {
				return createExpectedVolumeConstraintAdapter();
			}
			public Object caseLocationUnit(LocationUnit object) {
				return createLocationUnitAdapter();
			}
			public Object caseNode(Node object) {
				return createNodeAdapter();
			}
			public Object caseNodeUnit(NodeUnit object) {
				return createNodeUnitAdapter();
			}
			public Object casePeakLoadConstraint(PeakLoadConstraint object) {
				return createPeakLoadConstraintAdapter();
			}
			public Object caseResponseTimeConstraint(ResponseTimeConstraint object) {
				return createResponseTimeConstraintAdapter();
			}
			public Object caseSizePerSubmissionConstraint(SizePerSubmissionConstraint object) {
				return createSizePerSubmissionConstraintAdapter();
			}
			public Object caseUsageWindowPerDayConstraint(UsageWindowPerDayConstraint object) {
				return createUsageWindowPerDayConstraintAdapter();
			}
			public Object caseDeployModelObject(DeployModelObject object) {
				return createDeployModelObjectAdapter();
			}
			public Object caseConstraint(Constraint object) {
				return createConstraintAdapter();
			}
			public Object caseCapability(Capability object) {
				return createCapabilityAdapter();
			}
			public Object caseUnit(Unit object) {
				return createUnitAdapter();
			}
			public Object caseConceptualNode(ConceptualNode object) {
				return createConceptualNodeAdapter();
			}
			public Object defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisConstraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisConstraint
	 * @generated
	 */
	public Adapter createAnalysisConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot <em>Deploy Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisDeployRoot
	 * @generated
	 */
	public Adapter createAnalysisDeployRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.analysis.AvailabilityConstraint <em>Availability Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.analysis.AvailabilityConstraint
	 * @generated
	 */
	public Adapter createAvailabilityConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.analysis.DailyLoadConstraint <em>Daily Load Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.analysis.DailyLoadConstraint
	 * @generated
	 */
	public Adapter createDailyLoadConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.analysis.DataServiceConstraint <em>Data Service Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.analysis.DataServiceConstraint
	 * @generated
	 */
	public Adapter createDataServiceConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.analysis.Deployment <em>Deployment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.analysis.Deployment
	 * @generated
	 */
	public Adapter createDeploymentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.analysis.DeploymentUnit <em>Deployment Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.analysis.DeploymentUnit
	 * @generated
	 */
	public Adapter createDeploymentUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.analysis.ExecutionServiceConstraint <em>Execution Service Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.analysis.ExecutionServiceConstraint
	 * @generated
	 */
	public Adapter createExecutionServiceConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.analysis.ExpectedLifespanConstraint <em>Expected Lifespan Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.analysis.ExpectedLifespanConstraint
	 * @generated
	 */
	public Adapter createExpectedLifespanConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.analysis.ExpectedVolumeConstraint <em>Expected Volume Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.analysis.ExpectedVolumeConstraint
	 * @generated
	 */
	public Adapter createExpectedVolumeConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.analysis.LocationUnit <em>Location Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.analysis.LocationUnit
	 * @generated
	 */
	public Adapter createLocationUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.analysis.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.analysis.Node
	 * @generated
	 */
	public Adapter createNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.analysis.NodeUnit <em>Node Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.analysis.NodeUnit
	 * @generated
	 */
	public Adapter createNodeUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.analysis.PeakLoadConstraint <em>Peak Load Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.analysis.PeakLoadConstraint
	 * @generated
	 */
	public Adapter createPeakLoadConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.analysis.ResponseTimeConstraint <em>Response Time Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.analysis.ResponseTimeConstraint
	 * @generated
	 */
	public Adapter createResponseTimeConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.analysis.SizePerSubmissionConstraint <em>Size Per Submission Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.analysis.SizePerSubmissionConstraint
	 * @generated
	 */
	public Adapter createSizePerSubmissionConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.analysis.UsageWindowPerDayConstraint <em>Usage Window Per Day Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.analysis.UsageWindowPerDayConstraint
	 * @generated
	 */
	public Adapter createUsageWindowPerDayConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.DeployModelObject <em>Deploy Model Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.DeployModelObject
	 * @generated
	 */
	public Adapter createDeployModelObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.Constraint
	 * @generated
	 */
	public Adapter createConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.Unit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.Unit
	 * @generated
	 */
	public Adapter createUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.Capability <em>Capability</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.Capability
	 * @generated
	 */
	public Adapter createCapabilityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.ibm.ccl.soa.deploy.core.ConceptualNode <em>Conceptual Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.ibm.ccl.soa.deploy.core.ConceptualNode
	 * @generated
	 */
	public Adapter createConceptualNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //AnalysisAdapterFactory
