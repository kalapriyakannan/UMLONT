/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.DomainValidator;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.matcher.CoreDomainMatcher;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * A domain validator which follows a pattern of delegating validation to {@link UnitValidator}.
 * <p>
 * Subtypes will typically override the constructor to invoke {@link #addValidator(IUnitValidator)}.
 */
public class UnitDomainValidator extends DomainValidator {

	/** Maps a {@link EClass} to a list of {@link UnitValidator}. */
	protected final Map<EClass, List<IUnitValidator>> eclassValidatorMap = new HashMap<EClass, List<IUnitValidator>>();

	/** The domain used to filter units, or null if none set. */
	protected final EPackage domain;

	/** The unit validator used when no validator has been set. */
	protected List<IUnitValidator> defaultUnitValidatorList;

	/**
	 * Constructs a domain validator operating over units from a specific domain.
	 * 
	 * @param domain
	 *           the domain whose units will be validated (may be null for any).
	 */
	public UnitDomainValidator(EPackage domain) {
		this.domain = domain;
		defaultUnitValidatorList = new ArrayList<IUnitValidator>(0);
		defaultUnitValidatorList.add(new UnitValidator(CorePackage.eINSTANCE.getUnit()));
	}

	/**
	 * Adds a validator for a unit type.
	 * <p>
	 * If the domain has been restricted then the unit must belong to the domain.
	 * 
	 * @param unitValidator
	 *           a unit validator to be added.
	 */
	protected void addValidator(IUnitValidator unitValidator) {
		assert unitValidator != null;
		assert unitValidator.getUnitType() != null;
		if (domain != null) {
			assert unitValidator.getUnitType().getEPackage() == domain : unitValidator.getUnitType()
					.getName()
					+ " not in domain " //$NON-NLS-1$
					+ domain;
		}
		List<IUnitValidator> list = eclassValidatorMap.get(unitValidator.getUnitType());
		if (list == null) {
			list = new LinkedList<IUnitValidator>();
			eclassValidatorMap.put(unitValidator.getUnitType(), list);
		}
		list.add(unitValidator);
	}

	/**
	 * Returns an iterator over all unit validators defined for the specified unit.
	 * 
	 * @param unit
	 *           a deploy unit.
	 * @return Iterator<IUnitValidator>
	 */
	public Iterator<IUnitValidator> getValidators(Unit unit) {
		return getValidators(unit.getEObject().eClass());
	}

	/**
	 * Returns an iterator over all unit validators defined for the specified unit type.
	 * 
	 * @param eclass
	 *           a unit type.
	 * @return Iterator<IUnitValidator>
	 */
	public Iterator<IUnitValidator> getValidators(EClass eclass) {
		List<IUnitValidator> list = eclassValidatorMap.get(eclass);
		if (list == null || list.size() == 0) {
			return defaultUnitValidatorList.iterator();
		}

		return list.iterator();
	}

	/**
	 * Validates the topology using the unit validators added.
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.DomainValidator#validate(com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validate(IDeployValidationContext context, IDeployReporter reporter) {
		Iterator<Unit> unitIter;
		if (domain != null) {
			unitIter = context.findAllUnits(domain);
		} else if (eclassValidatorMap.size() > 0) {
			List<Unit> unitList = new ArrayList<Unit>();
			for (Iterator<EClass> iter = eclassValidatorMap.keySet().iterator(); iter.hasNext();) {
				EClass type = iter.next();
				for (Iterator<Unit> iter2 = context.findAllUnits(type); iter2.hasNext();) {
					unitList.add(iter2.next());
				}
			}
			unitIter = unitList.iterator();
		} else {
			unitIter = context.getTopology().findAllUnits();
		}

		while (unitIter.hasNext()) {
			Unit unit = unitIter.next();
			for (Iterator<IUnitValidator> validatorIter = getValidators(unit); validatorIter.hasNext();) {
				IUnitValidator validator = validatorIter.next();
				if (context.getProgressMonitor().isCanceled()) {
					return;
				}
				if (validator != null) {
					try {
						validator.validate(unit, context, reporter);
					} catch (RuntimeException e) {
						if (!context.getProgressMonitor().isCanceled()) {
							DeployCorePlugin.logError(0, NLS.bind(DeployCoreMessages.Validator_0_failed,
									validator.getUnitType()), e);
						}
					}
				}
			}
		}
	}

	/**
	 * Creates a {@link CoreDomainMatcher}.
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.validator.DomainValidator#createDomainMatcher()
	 */
	protected DomainMatcher createDomainMatcher() {
		return new CoreDomainMatcher();
	}
}
