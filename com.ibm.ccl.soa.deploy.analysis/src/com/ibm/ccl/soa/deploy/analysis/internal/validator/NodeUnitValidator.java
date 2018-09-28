/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.analysis.internal.validator;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.analysis.AnalysisPackage;
import com.ibm.ccl.soa.deploy.analysis.LocationUnit;
import com.ibm.ccl.soa.deploy.analysis.internal.AnalysisMessages;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ApplicationCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.BaseCommunicationConstraint;
import com.ibm.ccl.soa.deploy.core.util.UnitCaptionProvider;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.pattern.UnitValidator;
import com.ibm.ccl.soa.deploy.core.validator.status.DeployCoreStatusFactory;

/**
 * Validates a {@link LocationUnit}.
 * 
 * @see AnalysisDomainValidator
 */
public class NodeUnitValidator extends UnitValidator {

	/**
	 * Construct a new {@link LocationUnit} validator.
	 */
	public NodeUnitValidator() {
		this(AnalysisPackage.eINSTANCE.getNodeUnit());
	}

	/**
	 * Construct a validator for a subtype of {@link LocationUnit}.
	 * 
	 * @param unitType
	 *           an {@link LocationUnit} subtype.
	 */
	protected NodeUnitValidator(EClass unitType) {
		super(unitType);
	}
	/**
	 * Overriden by subtypes to perform general purpose unit validation.
	 * <p>
	 * This method will not be invoked if the unit is in install and do not publish state.
	 * 
	 * @param unit
	 *           the unit whose membership link cardinality is to be validated.
	 * @param context
	 *           the validation context.
	 * @param reporter
	 *           used to report validation errors.
	 */
	protected void validateUnit(Unit unit, IDeployValidationContext context, IDeployReporter reporter) {
		assert unit != null;
		assert context != null;
		assert reporter != null;		

		validateCommunicationConstraintLink(reporter, unit);
		
	}
	
	private LocationUnit getMemberOfLocation(Unit member) {
		List<Unit> groupUnits =  ValidatorUtils.getImmediateGroups(member);
		for (Iterator iterator = groupUnits.iterator(); iterator.hasNext();) {
			Unit group = (Unit) iterator.next();
			if(group instanceof LocationUnit){
				return (LocationUnit)group;
			}			
		}
		return null;
	}
	
	public  void validateCommunicationConstraintLink(IDeployReporter reporter,Unit sourceUnit) {
		LocationUnit location1 = getMemberOfLocation(sourceUnit);
		if(location1 != null){
			Iterator iter = sourceUnit.getConstraintLinks().iterator();
			while (iter.hasNext()) {
				ConstraintLink link = (ConstraintLink) iter.next();
				DeployModelObject targetUnit = link.getTarget();
				if(!(targetUnit instanceof Unit)){
					continue;
				}
				LocationUnit location2 = getMemberOfLocation((Unit)targetUnit);
				if(location2 != null){
					if(!location1.equals(location2)){
						if(!hasCommunicationConstraintLink(location1, location2)){
							UnitCaptionProvider ucp = location1.getCaptionProvider();
							reporter.addStatus( DeployCoreStatusFactory.INSTANCE.createDeployStatus(IStatus.INFO,
									IAnalysisDomainValidators.NODE_VALIDATE_LOCATION_COMMUNICATION, IAnalysisProblemType.COMMUNICATION_LINK_UNDEFINED,
									AnalysisMessages.NODE_VALIDATE_LOCATION_COMMUNICATION, new Object[] {
									ucp.title(location1), ucp.title(location2), ucp.title(sourceUnit), ucp.title((Unit)targetUnit)}, link));
						}
					}
				}
			}
		}
		}
	
	private  boolean hasCommunicationConstraintLink(LocationUnit sourceUnit, LocationUnit targetUnit) {
		if (sourceUnit == targetUnit) {
			return true;
		}
		Iterator iter = sourceUnit.getConstraintLinks().iterator();
		while (iter.hasNext()) {
			ConstraintLink link = (ConstraintLink) iter.next();
			if (link.getTarget().getName().equals(targetUnit.getName())) {
				// Check that link has a comm constraint
				Iterator constraints = link.getConstraints().iterator();
				while (constraints.hasNext()) {
					Constraint con = (Constraint) constraints.next();
					//MK: 12/21/2007 [CommunicationConstraint --> ApplicationCommunicationConstraint]					
//					if (con instanceof CommunicationConstraint) {
					if (con instanceof BaseCommunicationConstraint) {
						//Should we explicitly check for network communication?
						return true;
					}
				}
			}
		}

		return false;
	}
}
