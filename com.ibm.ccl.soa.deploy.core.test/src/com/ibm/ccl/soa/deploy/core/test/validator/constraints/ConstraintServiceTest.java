/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.test.validator.constraints;

import java.util.List;

import org.eclipse.emf.ecore.util.ExtendedMetaData;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.NotConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ShortConstraintDescriptor;
import com.ibm.ccl.soa.deploy.core.test.TopologyTestCase;
import com.ibm.ccl.soa.deploy.core.validator.ConstraintService;
import com.ibm.ccl.soa.deploy.core.validator.constraints.ConstraintValidator;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkMatcher;
import com.ibm.ccl.soa.deploy.internal.core.extension.ConstraintDescriptor;
import com.ibm.ccl.soa.deploy.internal.core.extension.ConstraintManager;

public class ConstraintServiceTest extends TopologyTestCase {
	public ConstraintServiceTest() {
		super("ConstraintServiceTest");
	}

	public void testConstraintManager() {
		
		ConstraintManager manager = ConstraintManager.INSTANCE;
		
		for (ConstraintDescriptor cd : manager.getAllConstraintDescriptors()) {
			System.out.println("Constraint: " + cd.getDisplayName());
			System.out.println("	ID: " + cd.getId());
			String namespace = cd.getNamespace();
			System.out.println("	Namespace: " + namespace);
			String type = cd.getType();
			System.out.println("	Type: " + type);
			ConstraintValidator validator = cd.createValidator();
			System.out.println("	Validator: " + validator.getClass().getName());
			LinkMatcher matcher = cd.createLinkMatcher();
			System.out.println("	Matcher: " + (matcher == null ? "none" : matcher.getClass().getName()));
			System.out.println();
			
			// tests that 'type' attribute is indeed the type of the constraint
			Constraint c = cd.createConstraint(CoreFactory.eINSTANCE.createUnit());
			if (c == null) {
				fail("Constraint extension ID '" + cd.getId() + 
				"' can not create constraint instance.");
			} else if (!(ExtendedMetaData.INSTANCE.getNamespace(c.eClass()).equals(namespace) && 
					     c.eClass().getName().equals(type))) {
				fail("Constraint extension ID '" + cd.getId() + 
						"' creates constraints of different type than declared in the 'type' attribute.");
			}
			
			// tests that validator can validate the created constraint
			// AT 12/11/2007: this is no longer true, because the ability to validate constraint may rely on the constraint placement and many other factors
//			if (!validator.canValidateConstraint(c)) {
//				fail("Validator declared in the constraint extension ID '" + cd.getId() + 
//						"' can not validate its constraint.");
//			}
		}
	}

	public void testConstraintService() {
		ConstraintService service = ConstraintService.INSTANCE;
		
		NotConstraint not = ConstraintFactory.eINSTANCE.createNotConstraint();
		Capability cap = CoreFactory.eINSTANCE.createCapability();
		cap.getConstraints().add(not);
		
		DeployModelObject[] parents = new DeployModelObject[] { CoreFactory.eINSTANCE.createUnit(), 
														CoreFactory.eINSTANCE.createCapability(),
														CoreFactory.eINSTANCE.createRequirement(),
														CoreFactory.eINSTANCE.createConstraintLink(),
														CoreFactory.eINSTANCE.createDependencyLink(),
														CoreFactory.eINSTANCE.createHostingLink(),
														not,
														ConstraintFactory.eINSTANCE.createEnumerationConstraint(),
														ConstraintFactory.eINSTANCE.createCollocationConstraint()};

		for (int i = 0; i<parents.length; i++) {
			List<ShortConstraintDescriptor> list = service.applicableConstraints(parents[i]);
			System.out.println("Parent DMO: " + parents[i].eClass().getName() + "; applicable constraints:");
			for (ShortConstraintDescriptor scd : list) {
				System.out.println("	" + scd.getTitle());
			}
			System.out.println();
		}

		// if NOT constraint does not have child constraints, it should allow child constraints
		assertTrue(service.applicableConstraints(not).size() > 0);
		
		// if NOT constraint has one child constraint, it should not allow child constraints
		not.getConstraints().add(ConstraintFactory.eINSTANCE.createEnumerationConstraint());
		assertTrue(service.applicableConstraints(not).size() == 0);
	
		Unit unit1 = CoreFactory.eINSTANCE.createUnit();
		unit1.setName("parent1");
		Unit unit2 = CoreFactory.eINSTANCE.createUnit();	
		unit2.setName("parent2");

		System.out.println("Parent DMO1: " + unit1.eClass().getName() + "; parent DMO2: " + unit2.eClass().getName());
		for (ShortConstraintDescriptor scd : service.applicableConstraints(unit1, unit2)) {
			System.out.println("	" + scd.getTitle());
		}
	}
}
