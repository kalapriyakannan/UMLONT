package com.ibm.ccl.soa.deploy.uml.test;

/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import junit.framework.Assert;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.uml2.uml.Component;

import com.ibm.ccl.soa.deploy.analysis.AnalysisFactory;
import com.ibm.ccl.soa.deploy.analysis.NodeUnit;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.SoftwareComponent;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.TopologyUnitStub;
import com.ibm.ccl.soa.deploy.core.UnitProvider;
import com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IUnitProviderService;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.util.FilterIterator;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.IDomainValidator;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkFactory;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployStatusIterator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;
import com.ibm.ccl.soa.deploy.core.validator.status.StatusIterator;
import com.ibm.ccl.soa.deploy.uml.internal.validator.IUMLDomainValidators;
import com.ibm.ccl.soa.deploy.uml.internal.validator.IUMLProblemType;
import com.ibm.ccl.soa.deploy.uml.internal.validator.UMLCoreTypeDomainValidator;
import com.ibm.ccl.soa.deploy.uml.test.workspaces.UmlTestWorkspace;
import com.ibm.xtools.uml.navigator.ModelElementDescriptor;
import com.ibm.xtools.uml.navigator.ModelServerElement;

/**
 * Tests that exercise the contents of the UML domain definition.
 * @since 1.0
 */
public class UmlDomainValidatorTest extends TopologyTestCase {

	private static final String PROJECT_NAME = "UmlDomainValidatorTest";
	
	private IProject project;
	public static final String PROJECT = "UmlDomainValidatorTest";

	public UmlDomainValidatorTest() {
		super(PROJECT);
		init();
	}
	
	private void init()
	{
		try {
			UmlTestWorkspace.init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @throws IOException
	 */
	public void testUmlDomainValidation() throws IOException {

		Topology top = createTopology("testDomainRegistration");
		
		//assertHasNoDomainValidator(top, UMLDomainValidator.class);


		// Add compA to top via provider
		Component compA = UmlTestWorkspace.getComponentA();
		
		ModelElementDescriptor desc = new ModelElementDescriptor(compA);
		ModelServerElement elem = new ModelServerElement(desc);

		// Load object from provider
		Object obj = verifyProviderResolved( elem );
		assert obj instanceof SoftwareComponent;
		SoftwareComponent umlcomp = (SoftwareComponent)obj;
		assert umlcomp.getName().equals(compA.getName());
		top.getUnits().add( umlcomp );
		
		//assertHasDomainValidator(top, UMLDomainValidator.class);	
		
		DeployValidatorService validator = new DeployValidatorService();
		validator.validate(top);
		
		// Verify hosting status on umlcomp
		findDeployStatus( umlcomp, "foo" );
		// Verify no comm status on umlcomp
		
	}

	protected boolean findDeployStatus(DeployModelObject object,
			String problemType ) {
		for (Iterator iter = new DeployStatusIterator(object); iter.hasNext();) {
			IDeployStatus status = (IDeployStatus) iter.next();
				for (Iterator iter2 = new FilterIterator(new StatusIterator(object
						.getStatus()), StatusIterator.DEPLOY_STATUS_FILTER); iter2
						.hasNext();) {
					IDeployStatus dStatus = (IDeployStatus) iter2.next();
					if (problemType.equals(dStatus.getProblemType())) {
						return true;
					}
				}
			
		}
		
		System.out.println( "No status with problem type=" + problemType + " found in:\n"
		+ getString(object.getStatus()) );

		return false;
	}
	
	protected Object verifyProviderResolved(Object obj) {
		
		IUnitProviderService ips = ExtensionsCore.createProviderService();
		
		UnitProvider[] provs = ips.findEnabledProvidersByInputOnly(obj);
		if (provs.length == 0) {
			Assert.fail("No Unit Providers found");
		}
		
		for (int i = 0; i < provs.length; i++) {
			UnitProvider provider = provs[i];
			TopologyUnitStub[] stubs = provider.resolveStubs(obj);
			for (int j = 0; j < stubs.length; j++) {
				Object[] objs = provider.resolveUnit(stubs[j], false, null);
				for (int k = 0; k < objs.length; k++) {
					return objs[k];
				}
			}
		}
		Assert
				.fail("Unit Providers failed to resolve DeployModelObject."
						+ obj);
		return null;
	}


	/**
	 * Tests that the core domain {@link UMLCoreDomainValidator} is invoked when
	 * the UML plugin is present.
	 */
	public void testUMLCoreDomainValidator() throws IOException {
		Topology top = createTopology("testUMLCoreDomainValidator");
		Collection<IDomainValidator> validators = getValidatorService()
				.getDomainValidators(top);
		assertNotNull(validators);
		boolean found = false;
		for (IDomainValidator v : validators) {
			if (v instanceof UMLCoreTypeDomainValidator) {
				found = true;
				break;
			}
		}
		assertTrue(found);
	}
	
	/**
	 * Tests that a communication constraint between two {@link SoftwareComponent} instances
	 * hosted on a {@link NodeUnit}.
	 */
	public void testSoftwareComponentCommunication() {
		Topology top = createTopology("testSoftwareComponentCommunication");
		SoftwareComponent c1 = CoreFactory.eINSTANCE.createSoftwareComponent();
		c1.setName("c1");
		top.getUnits().add(c1);

		SoftwareComponent c2 = CoreFactory.eINSTANCE.createSoftwareComponent();
		c2.setName("c2");
		top.getUnits().add(c2);

		NodeUnit n1 = AnalysisFactory.eINSTANCE.createNodeUnit();
		n1.setName("n1");
		top.getUnits().add(n1);

		NodeUnit n2 = AnalysisFactory.eINSTANCE.createNodeUnit();
		n2.setName("n2");
		top.getUnits().add(n2);

		LinkFactory.createHostingLink(n1, c1);
		LinkFactory.createHostingLink(n2, c2);

		ConstraintLink cLink = LinkFactory.createConstraintLink(c1, c2);
		ApplicationCommunicationConstraint constraint = ConstraintFactory.eINSTANCE
				.createApplicationCommunicationConstraint();
		constraint.setName("appCommConstraint");
		cLink.getConstraints().add(constraint);

		validate(top);

		assertHasDeployStatus(cLink,
				IUMLProblemType.COMMUNICATION_LINK_UNDEFINED, IStatus.INFO);
	}
}
