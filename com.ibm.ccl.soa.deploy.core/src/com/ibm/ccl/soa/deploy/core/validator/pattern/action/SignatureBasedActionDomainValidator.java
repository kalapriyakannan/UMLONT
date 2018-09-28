/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.DomainValidator;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Defines a {@link DomainValidator} that tests action preconditions
 */
public class SignatureBasedActionDomainValidator extends DomainValidator {

	/** Maps a {@link EClass} to a {@link UnitValidator}. */
	protected final Map<ISignature, List<IActionPreconditionTest>> eclassTestMap = new HashMap<ISignature, List<IActionPreconditionTest>>();

	/** The domain used to filter units, or null if none set. */
	protected final EPackage domain;

	/** The unit validator used when no validator has been set. */
	protected List<IActionPreconditionTest> defaultActionPreconditionTests;

	/**
	 * Constructs a domain validator operating over units from a specific domain.
	 * 
	 * @param domain
	 *           the domain whose units will be validated (may be null for any).
	 */
	public SignatureBasedActionDomainValidator(EPackage domain) {
		this.domain = domain;
		defaultActionPreconditionTests = new ArrayList<IActionPreconditionTest>(0);
	}

	/**
	 * Adds a validator for a unit type.
	 * <p>
	 * If the domain has been restricted then the unit must belong to the domain.
	 * 
	 * @param unitValidator
	 *           a unit validator to be added.
	 */
	protected void addActionPreconditionTest(IActionPreconditionTest test) {
		assert test != null;
		assert test.getSignature() != null;

		ISignature signature = test.getSignature();
		List<IActionPreconditionTest> list = eclassTestMap.get(signature);
		if (list == null) {
			list = new LinkedList<IActionPreconditionTest>();
			eclassTestMap.put(signature, list);
		}
		list.add(test);

	}

	/**
	 * Returns an iterator over all unit validators defined for the specified unit.
	 * 
	 * @param unit
	 *           a deploy unit.
	 * @return Iterator<UnitValidator>
	 */
	public Iterator<IActionPreconditionTest> getValidators(Unit unit) {
		return getValidators(unit.getEObject().eClass());
	}

	/**
	 * Returns an iterator over all unit validators defined for the specified unit type.
	 * 
	 * @param eclass
	 *           a unit type.
	 * @return Iterator<UnitValidator>
	 */
	public Iterator<IActionPreconditionTest> getValidators(EClass eclass) {
		List<IActionPreconditionTest> list = eclassTestMap.get(eclass);
		if (list == null || list.size() == 0) {
			return defaultActionPreconditionTests.iterator();
		}

		return list.iterator();
	}

	@Override
	public void validate(IDeployValidationContext context, IDeployReporter reporter) {

		// approach: given a domain, get all the action testers 
		// (they are indexed by their signature)
		// for each tester find all combinations of the parameters; that some are in the domain
		// or not is not important; the domain mechanism is just a way to group testers
		for (Iterator<ISignature> signatures = eclassTestMap.keySet().iterator(); signatures
				.hasNext();) {
			ISignature signature = signatures.next();
			if (context.getProgressMonitor().isCanceled()) {
				return;
			}
			List<IActionPreconditionTest> applicableTests = eclassTestMap.get(signature);
			//if there are applicable tests, retrieve signature combinations
			if (applicableTests.size() == 0) {
				return;
			}

			for (Iterator<List<DeployModelObject>> instances = new SignatureInstanceIterator(
					signature, context.getTopology()); instances.hasNext();) {
				List<DeployModelObject> inst = instances.next();
				if (context.getProgressMonitor().isCanceled()) {
					return;
				}
				if (!inst.contains(null) && inst.size() > 0) {

					for (int i = 0; i < applicableTests.size(); i++) {
						IActionPreconditionTest test = applicableTests.get(i);
						if (null != test) {
							try {
								if (!test.appliesTo(signature)) {
									DeployCorePlugin.logError(0, NLS
											.bind(DeployCoreMessages.Action_Precondition_Test_0_failed, test
													.getId()), null);
								}

								//System.out.println ("next instance: " + dumpInstances (inst)); //$NON-NLS-1$
								test.testActionPreconditions(inst, context, reporter);

							} catch (Throwable e) {
								DeployCorePlugin.logError(0, NLS.bind(
										DeployCoreMessages.Action_Precondition_Test_0_failed, test.getId()),
										e);
							}
						}
					}
				}
			}
		}
	}

	@Override
	protected DomainMatcher createDomainMatcher() {
		// domain matcher should not be supported by an action validator
		throw new UnsupportedOperationException();
	}

	// for debugging
	public static String dumpInstances(List<DeployModelObject> instances) {
		if (null == instances) {
			return "[]"; //$NON-NLS-1$
		}
		String output = "["; //$NON-NLS-1$
		for (int i = 0; i < instances.size(); i++) {
			if (i > 0) {
				output += ","; //$NON-NLS-1$
			}
			DeployModelObject o = instances.get(i);
			if (null == o) {
				output += "null"; //$NON-NLS-1$
			} else {
				output += o instanceof Unit ? ((Unit) o).getCaptionProvider().title((Unit) o) : o
						.getName();
			}
		}
		output += "]"; //$NON-NLS-1$
		return output;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.DomainValidator#getGroupID()
	 */
	@Override
	public String getGroupID() {
		return getClass().getName();
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDomainValidator#getGroupDescription()
	 */
	@Override
	public String getGroupDescription() {
		return DeployCoreMessages.Model_actions;
	}

}
