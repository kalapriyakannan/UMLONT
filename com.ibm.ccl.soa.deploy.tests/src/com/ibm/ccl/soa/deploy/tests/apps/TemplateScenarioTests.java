/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.tests.apps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.emf.common.util.URI;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.ExplicitContract;
import com.ibm.ccl.soa.deploy.core.IDecoratorSemanticConstants;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.Visibility;
import com.ibm.ccl.soa.deploy.core.provider.discovery.TopologyDiscovererService;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.util.FilterIterator;
import com.ibm.ccl.soa.deploy.core.util.TopologyUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployCoreValidators;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.StatusIterator;
import com.ibm.ccl.soa.deploy.internal.core.validator.resolution.GenericConnectedSetRealizationSatisfactionResolution;
import com.ibm.ccl.soa.deploy.was.db2.DatasourceSatisfactionConstraint;
import com.ibm.ccl.soa.deploy.was.db2.ui.eartodb.resolution.ConfigureJ2eeModuleAccessToDatatbaseResolution;
import com.ibm.ccl.soa.deploy.was.db2.validator.status.DatasourceSatisfactionStatus;

/**
 * Tests the execution of logical links in the Plants by WebSphere topologies.
 * <p>
 * Loads complete topologies from the test plug-in and executes their logical
 * link, asserting that all errors are fixed.
 */
public class TemplateScenarioTests extends TopologyTestCase {

	/** Platform path to test topology files. */
	public static final String URL_PREFIX = "platform:/plugin/com.ibm.ccl.soa.deploy.tests/testData/topologies";

	public static final String LAS_PLUS_DEVELOPER = URL_PREFIX
	+ "/assemblies/LASPlusDeveloper.topology";
	
	public static final String LAS_PLUS_TESTING = URL_PREFIX
	+ "/assemblies/LASPlusTesting.topology";
	
	public static final String INFRA = URL_PREFIX
	+ "/infra/Infra1.topology";

	public TemplateScenarioTests() {
		super("TemplateScenarioTests");
		setDeleteProjectOnTearDown(false);
	}

	/**
	 * Finds the logical links in the topology and resolves them, asserting
	 * that no errors will be left.
	 * 
	 * @param top
	 *            the topology checked.
	 * @param dvs 
	 *            deploy validator service
	 * @throws Exception
	 */
	static public void resolveConstraintLinks(Topology top, DeployValidatorService dvs) throws Exception {
		// find logical link ...
		List<ConstraintLink> links = new ArrayList();
		for (Iterator<ConstraintLink> iter = top.findAllConstraintLinks(); iter.hasNext();) {
			links.add(iter.next());
		}
		assert links.size() > 0;

		for (Iterator<ConstraintLink> linksIter = links.iterator(); linksIter.hasNext();) {
			ConstraintLink link = linksIter.next();
			// Validate topology and identify logical link error status
			wrappedValidate(dvs, top);
			List<Constraint> constraints = link.getConstraints();
			assert constraints.size() == 1 : "too many constraints on constraint link";
			if (constraints.get(0) instanceof DatasourceSatisfactionConstraint) {
				DatasourceSatisfactionConstraint constraint = (DatasourceSatisfactionConstraint) constraints
						.get(0);
				if (!constraint.getStatus().isOK()) {
					assert constraint.getStatus() instanceof DatasourceSatisfactionStatus : "too many logical link errors";
					DatasourceSatisfactionStatus status = (DatasourceSatisfactionStatus) constraint
							.getStatus();
					status.setUser("db2admin");

					// Find error status resolutions
					List<IDeployResolution> resolutions = dvs
							.getResolutions(status);
					assert resolutions.size() != 0 : "No resolutions found for: \n"
							+ link.getStatus().toString();
					assert resolutions.size() == 1 : "Too many resolutions found ("
							+ resolutions.size()
							+ "):\n"
							+ link.getStatus().toString();

					// Resolve and check for zero validation errors.
					// prime with a particular user so that the the resolution
					// asks
					// not
					if (resolutions.get(0) instanceof ConfigureJ2eeModuleAccessToDatatbaseResolution) {
						IDeployResolution resolution = resolutions.get(0);
						resolution.resolve(resolution
								.getDeployResolutionContext()
								.getProgressMonitor());
					}
				}
			}
		}
	}
	
	private static void wrappedValidate(DeployValidatorService dvs, Topology top) {
		TopologyDiscovererService.INSTANCE.enterDefaultDiscoveryCache();
		dvs.validate(top);
		TopologyDiscovererService.INSTANCE.leaveDefaultDiscoveryCache();
		
	}

	/**
	 * Finds unrealized connected set realization resolutions, and runs them 
	 * 
	 * @param top
	 *            the topology checked.
   	 * @param maxTries
   	 * 			  the maximum number of validation/realization tries. 
	 * @param dvs 
	 *  		  deploy validator service
	 * @throws Exception
	 */

	static public void realizationResolution(Topology top, int maxTries, DeployValidatorService dvs) throws Exception {
		// Validate topology and identify logical link error status

		int originalRealizationLinksCount = allRealizationLinksCount(top);

		for (int i = 0; i < maxTries; ++i) {
			wrappedValidate(dvs, top);
			boolean foundConnectedSetRealizationResolution = false;
			boolean foundUnrealizedUnit = false;
			for (Iterator<Unit> unitsIter = top.findAllUnits(); unitsIter.hasNext();) {
				Unit u = unitsIter.next();
				if (hasNotRealizedStatus(u)) {
					foundUnrealizedUnit = true;
					IStatus status = u.getStatus();
					List<IDeployResolution> resolutions = dvs.getResolutions(status);
					for (IDeployResolution resolution : resolutions) {
						if (resolution instanceof GenericConnectedSetRealizationSatisfactionResolution) {
							// TODO handle choice of stack realization.
							resolution.resolve(null);
							foundConnectedSetRealizationResolution = true;
							break;
						}
					}
					break;
				}
			}
			if (!foundUnrealizedUnit) {
				break;
			}
			assert (foundConnectedSetRealizationResolution);
		}
		assert allRealizationLinksCount(top) > 0;
//		System.out.println("RealizationLinks created = "
//				+ (allRealizationLinksCount(top) - originalRealizationLinksCount));
	}	
	
	
	private void testConceptualPlusInfra(String conceptualTopURI, String infraTopURI, String editTopName) throws Exception {
		Topology targetTop = createTopology(editTopName);
		targetTop.setDecoratorSemantic(IDecoratorSemanticConstants.DeploymentDS_ID);
		addNullContract(targetTop);
		
		Topology top1 = loadTopology(conceptualTopURI);
		assert top1.getConfigurationContract() != null;
		URI uri = getURI(top1.getName(), top1.getNamespace());
		String uris = uri.toString();
		top1.eResource().setURI(getURI(top1.getName(), top1.getNamespace()));
		save(top1);
		Import importDcl1 = TopologyUtil.importTopology(top1, targetTop);
		save(targetTop);
		Topology importTop1 = resolve(importDcl1);

		assert top1 != null;
		assert allUnitsCount(top1) > 0;

		Topology top2 = loadTopology(infraTopURI);
		assert top2.getConfigurationContract() != null;
		top2.eResource().setURI(getURI(top2.getName(), top2.getNamespace()));
		save(top2);
		Import importDcl2 = TopologyUtil.importTopology(top2, targetTop);
		save(targetTop);
		Topology importTop2 = resolve(importDcl2);
		
		assert top2 != null;
		assert allUnitsCount(top2) > 0;
		
		int cntImported = (allUnitsCount(top1) + allUnitsCount(top2));
		int cntTarget= allUnitsCount(targetTop);
		assert(cntImported == cntTarget);
		
		realizationResolution(targetTop, 2, getValidatorService());
		save(targetTop);
		TemplateScenarioTests.resolveConstraintLinks(targetTop, getValidatorService());
		save(targetTop);
		
		save(targetTop);
		getValidatorService().validate(targetTop);
		assertHasNoErrorStatus(targetTop);
	}

	/**
	 * @throws Exception 
	 */
	public void testLASPlusDeveloper() throws Exception {
		testConceptualPlusInfra(LAS_PLUS_DEVELOPER, INFRA, "DeploymentLASPlusDeveloper");
	}
	
	/**
	 * @throws Exception 
	 */
	public void testLASPlusTesting() throws Exception {
		testConceptualPlusInfra(LAS_PLUS_TESTING, INFRA, "DeploymentLASPlusTesting");
	}
	
	private int allUnitsCount(Topology top) {
		int count = 0;
		for (Iterator<Unit> unitsIter = top.findAllUnits(); unitsIter.hasNext();) {
			Unit u = unitsIter.next();
			++count;
		}
		return count;
	}
	
	
	private static int allRealizationLinksCount(Topology top) {
		int count = 0;
		for (Iterator<RealizationLink> rlIter = top.findAllRealizationLinks(); rlIter.hasNext();) {
			RealizationLink u = rlIter.next();
			++count;
		}
		return count;
	}
	
	private static boolean hasNotRealizedStatus(Unit unit) {
		if (unit.getStatus().getSeverity() == IStatus.ERROR) {
			assert (unit.getStatus() instanceof IDeployStatus || unit.getStatus() instanceof MultiStatus);
			for (Iterator iter2 = new FilterIterator(new StatusIterator(unit.getStatus()),
					StatusIterator.DEPLOY_STATUS_FILTER); iter2.hasNext();) {
				IDeployStatus deployStatus = (IDeployStatus) iter2.next();
				if (deployStatus.getValidatorID().equals(IDeployCoreValidators.CONCEPTUAL_UNIT_001)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private void addNullContract(Topology top) {
		ExplicitContract nc = CoreFactory.eINSTANCE.createExplicitContract();
		nc.setName("Null0");
		nc.setDisplayName("Null contract");
		nc.setDefaultConceptualPolicy(Visibility.PRIVATE_LITERAL);
		nc.setDefaultPolicy(Visibility.PRIVATE_LITERAL);
		top.setConfigurationContract(nc);
	}


}
