/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.validator;

import com.ibm.ccl.soa.deploy.core.validator.DomainValidator;
import com.ibm.ccl.soa.deploy.core.validator.IDeployReporter;
import com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher;
import com.ibm.ccl.soa.deploy.internal.core.validator.matcher.RegisteredConstraintLinkMatcher;

/**
 * Validatator for registered constraint (logical) links.
 * 
 */
public class RegisteredConstraintLinkValidator extends DomainValidator {

	/** The singleton instance of this class */
	public static final RegisteredConstraintLinkValidator INSTANCE = new RegisteredConstraintLinkValidator();

	/**
	 * Construct a validator for registered constraint links.
	 */
	public RegisteredConstraintLinkValidator() {
		setDomainID(RegisteredConstraintLinkValidator.class.getName());
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDomainValidator#validate(com.ibm.ccl.soa.deploy.core.validator.IDeployValidationContext,
	 *      com.ibm.ccl.soa.deploy.core.validator.IDeployReporter)
	 */
	public void validate(IDeployValidationContext context, IDeployReporter reporter) {
		// for each logical link
		//    check preconditions
		//       if at least one is satisfied --> maker w/ resolution
		//       else marker --> marker w/ hint of problem (resolution?)

		// AT 7/18/2007: we don't need to have here validation for constraint links 
		// commenting out this code that validated old logical links

		/*
		 * for (Iterator allLinks = context.findAllConstraintLinks(); allLinks.hasNext();) {
		 * ConstraintLink link = (ConstraintLink) allLinks.next(); // Ignore links whose endpoints are
		 * not set or that are to be // uninstalled. if (link.getSource() == null || link.getTarget() ==
		 * null || ValidatorUtils.isGoalNotInstalled(link)) { continue; } // get the implementations
		 * for the logical link and find those that can be applied // LogicalLinkDescriptor[]
		 * descriptors = LogicalLinkManager.getInstance().getLogicalLinkDescriptors();
		 * LogicalLinkDescriptor[] descriptors = LogicalLinkManager.getInstance()
		 * .getLogicalLinkDescriptorsForDecoratorSemantic(
		 * link.getEditTopology().getDecoratorSemantic()); for (int d = 0; d < descriptors.length;
		 * d++) { LogicalLinkDescriptor metadata = descriptors[d]; // check if this metadata applies
		 * to this link if (!metadata.getLogicalLinkTester().isLink(link)) { continue; }
		 * 
		 * LogicalLinkImplementation[] implementations = metadata.getImplementations(); // check if
		 * the logical link is already implemented boolean foundImplemented = false; IStatus[]
		 * validationStatus = new IStatus[implementations.length]; for (int i = 0; i <
		 * implementations.length; i++) { validationStatus[i] = implementations[i].validate(link); if
		 * (validationStatus[i].isOK()) { foundImplemented = true; if
		 * (validationStatus[i].getSeverity() == IStatus.WARNING) { // force guards to put message on
		 * link implementations[i].evaluateGuards(link, context, reporter, false); } break; } } // if
		 * we found an implementation that validates then we can go on to the next link if
		 * (foundImplemented) { break; } // otherwise check each implementation for preconditions
		 * boolean foundImplementable = false; for (int i = 0; i < implementations.length; i++) {
		 * 
		 * IStatus guardStatus = implementations[i].evaluateGuards(link, context, reporter, false);
		 * 
		 * if (guardStatus.isOK()) {
		 * reporter.addStatus(implementations[i].createCanImplementStatus(link, metadata
		 * .getGlobalId())); foundImplementable = true; // TODO add marker for precondition if haven't
		 * already done so // and continue to next implementation break; } } if (!foundImplementable) { //
		 * assume that the guards created the necessary status markers // TODO: what if they didn't ? //
		 * reporter // .addStatus(DeployLogicalLinkMessageFactory // .createLinkNotImplemented( //
		 * link, // metadata.getGlobalId(), // ILogicalLinkValidatorID.LOGICAL_LINK_VALIDATE)); } } }
		 */
	}

	/**
	 * Create a constraint link domain matcher for registered constraint links.
	 */
	protected DomainMatcher createDomainMatcher() {
		return new RegisteredConstraintLinkMatcher();
	}

	/*
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object object) {
		// all instances are equal
		return object instanceof RegisteredConstraintLinkValidator;
	}

	/*
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		// all instances are equal
		return 1;
	}
}
