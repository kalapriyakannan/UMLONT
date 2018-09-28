/**
 * <copyright>
 * </copyright>
 *
 * $Id: AnalysisSwitch.java,v 1.10 2008/02/05 22:21:31 chadh Exp $
 */
package com.ibm.ccl.soa.deploy.analysis.util;

import com.ibm.ccl.soa.deploy.analysis.*;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage
 * @generated
 */
public class AnalysisSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AnalysisPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalysisSwitch() {
		if (modelPackage == null) {
			modelPackage = AnalysisPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case AnalysisPackage.ANALYSIS_CONSTRAINT: {
				AnalysisConstraint analysisConstraint = (AnalysisConstraint)theEObject;
				Object result = caseAnalysisConstraint(analysisConstraint);
				if (result == null) result = caseConstraint(analysisConstraint);
				if (result == null) result = caseDeployModelObject(analysisConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnalysisPackage.ANALYSIS_DEPLOY_ROOT: {
				AnalysisDeployRoot analysisDeployRoot = (AnalysisDeployRoot)theEObject;
				Object result = caseAnalysisDeployRoot(analysisDeployRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnalysisPackage.AVAILABILITY_CONSTRAINT: {
				AvailabilityConstraint availabilityConstraint = (AvailabilityConstraint)theEObject;
				Object result = caseAvailabilityConstraint(availabilityConstraint);
				if (result == null) result = caseAnalysisConstraint(availabilityConstraint);
				if (result == null) result = caseConstraint(availabilityConstraint);
				if (result == null) result = caseDeployModelObject(availabilityConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnalysisPackage.DAILY_LOAD_CONSTRAINT: {
				DailyLoadConstraint dailyLoadConstraint = (DailyLoadConstraint)theEObject;
				Object result = caseDailyLoadConstraint(dailyLoadConstraint);
				if (result == null) result = caseAnalysisConstraint(dailyLoadConstraint);
				if (result == null) result = caseConstraint(dailyLoadConstraint);
				if (result == null) result = caseDeployModelObject(dailyLoadConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnalysisPackage.DATA_SERVICE_CONSTRAINT: {
				DataServiceConstraint dataServiceConstraint = (DataServiceConstraint)theEObject;
				Object result = caseDataServiceConstraint(dataServiceConstraint);
				if (result == null) result = caseAnalysisConstraint(dataServiceConstraint);
				if (result == null) result = caseConstraint(dataServiceConstraint);
				if (result == null) result = caseDeployModelObject(dataServiceConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnalysisPackage.DEPLOYMENT: {
				Deployment deployment = (Deployment)theEObject;
				Object result = caseDeployment(deployment);
				if (result == null) result = caseCapability(deployment);
				if (result == null) result = caseDeployModelObject(deployment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnalysisPackage.DEPLOYMENT_UNIT: {
				DeploymentUnit deploymentUnit = (DeploymentUnit)theEObject;
				Object result = caseDeploymentUnit(deploymentUnit);
				if (result == null) result = caseUnit(deploymentUnit);
				if (result == null) result = caseDeployModelObject(deploymentUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnalysisPackage.EXECUTION_SERVICE_CONSTRAINT: {
				ExecutionServiceConstraint executionServiceConstraint = (ExecutionServiceConstraint)theEObject;
				Object result = caseExecutionServiceConstraint(executionServiceConstraint);
				if (result == null) result = caseAnalysisConstraint(executionServiceConstraint);
				if (result == null) result = caseConstraint(executionServiceConstraint);
				if (result == null) result = caseDeployModelObject(executionServiceConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnalysisPackage.EXPECTED_LIFESPAN_CONSTRAINT: {
				ExpectedLifespanConstraint expectedLifespanConstraint = (ExpectedLifespanConstraint)theEObject;
				Object result = caseExpectedLifespanConstraint(expectedLifespanConstraint);
				if (result == null) result = caseAnalysisConstraint(expectedLifespanConstraint);
				if (result == null) result = caseConstraint(expectedLifespanConstraint);
				if (result == null) result = caseDeployModelObject(expectedLifespanConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnalysisPackage.EXPECTED_VOLUME_CONSTRAINT: {
				ExpectedVolumeConstraint expectedVolumeConstraint = (ExpectedVolumeConstraint)theEObject;
				Object result = caseExpectedVolumeConstraint(expectedVolumeConstraint);
				if (result == null) result = caseAnalysisConstraint(expectedVolumeConstraint);
				if (result == null) result = caseConstraint(expectedVolumeConstraint);
				if (result == null) result = caseDeployModelObject(expectedVolumeConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnalysisPackage.LOCATION_UNIT: {
				LocationUnit locationUnit = (LocationUnit)theEObject;
				Object result = caseLocationUnit(locationUnit);
				if (result == null) result = caseUnit(locationUnit);
				if (result == null) result = caseDeployModelObject(locationUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnalysisPackage.NODE: {
				Node node = (Node)theEObject;
				Object result = caseNode(node);
				if (result == null) result = caseCapability(node);
				if (result == null) result = caseDeployModelObject(node);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnalysisPackage.NODE_UNIT: {
				NodeUnit nodeUnit = (NodeUnit)theEObject;
				Object result = caseNodeUnit(nodeUnit);
				if (result == null) result = caseConceptualNode(nodeUnit);
				if (result == null) result = caseUnit(nodeUnit);
				if (result == null) result = caseDeployModelObject(nodeUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnalysisPackage.PEAK_LOAD_CONSTRAINT: {
				PeakLoadConstraint peakLoadConstraint = (PeakLoadConstraint)theEObject;
				Object result = casePeakLoadConstraint(peakLoadConstraint);
				if (result == null) result = caseAnalysisConstraint(peakLoadConstraint);
				if (result == null) result = caseConstraint(peakLoadConstraint);
				if (result == null) result = caseDeployModelObject(peakLoadConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnalysisPackage.RESPONSE_TIME_CONSTRAINT: {
				ResponseTimeConstraint responseTimeConstraint = (ResponseTimeConstraint)theEObject;
				Object result = caseResponseTimeConstraint(responseTimeConstraint);
				if (result == null) result = caseAnalysisConstraint(responseTimeConstraint);
				if (result == null) result = caseConstraint(responseTimeConstraint);
				if (result == null) result = caseDeployModelObject(responseTimeConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnalysisPackage.SIZE_PER_SUBMISSION_CONSTRAINT: {
				SizePerSubmissionConstraint sizePerSubmissionConstraint = (SizePerSubmissionConstraint)theEObject;
				Object result = caseSizePerSubmissionConstraint(sizePerSubmissionConstraint);
				if (result == null) result = caseAnalysisConstraint(sizePerSubmissionConstraint);
				if (result == null) result = caseConstraint(sizePerSubmissionConstraint);
				if (result == null) result = caseDeployModelObject(sizePerSubmissionConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnalysisPackage.USAGE_WINDOW_PER_DAY_CONSTRAINT: {
				UsageWindowPerDayConstraint usageWindowPerDayConstraint = (UsageWindowPerDayConstraint)theEObject;
				Object result = caseUsageWindowPerDayConstraint(usageWindowPerDayConstraint);
				if (result == null) result = caseAnalysisConstraint(usageWindowPerDayConstraint);
				if (result == null) result = caseConstraint(usageWindowPerDayConstraint);
				if (result == null) result = caseDeployModelObject(usageWindowPerDayConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAnalysisConstraint(AnalysisConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deploy Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deploy Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAnalysisDeployRoot(AnalysisDeployRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Availability Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Availability Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAvailabilityConstraint(AvailabilityConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Daily Load Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Daily Load Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDailyLoadConstraint(DailyLoadConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Service Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Service Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDataServiceConstraint(DataServiceConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deployment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deployment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDeployment(Deployment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deployment Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deployment Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDeploymentUnit(DeploymentUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Execution Service Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execution Service Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseExecutionServiceConstraint(ExecutionServiceConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expected Lifespan Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expected Lifespan Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseExpectedLifespanConstraint(ExpectedLifespanConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expected Volume Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expected Volume Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseExpectedVolumeConstraint(ExpectedVolumeConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Location Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Location Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLocationUnit(LocationUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNode(Node object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNodeUnit(NodeUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Peak Load Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Peak Load Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePeakLoadConstraint(PeakLoadConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Response Time Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Response Time Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseResponseTimeConstraint(ResponseTimeConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Size Per Submission Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Size Per Submission Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSizePerSubmissionConstraint(SizePerSubmissionConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Usage Window Per Day Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Usage Window Per Day Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUsageWindowPerDayConstraint(UsageWindowPerDayConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Deploy Model Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Deploy Model Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDeployModelObject(DeployModelObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseConstraint(Constraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUnit(Unit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Capability</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Capability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseCapability(Capability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conceptual Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conceptual Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseConceptualNode(ConceptualNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //AnalysisSwitch
