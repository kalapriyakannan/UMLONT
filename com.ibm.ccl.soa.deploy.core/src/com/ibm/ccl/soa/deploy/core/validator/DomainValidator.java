/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator;

import org.eclipse.emf.ecore.EPackage;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployMarker;

/**
 * Provides a standard base class for extenders of the <b>com.ibm.ccl.soa.deploy.core.domains</b>
 * extension point who provide a <b>&lt;validator /&gt;</b> element.
 * 
 * @since 1.0
 */
public abstract class DomainValidator implements IDomainValidator {

	/**
	 * Matcher used for this domain.
	 */
	protected DomainMatcher matcher;

	/**
	 * The namespace URI for the domain being validated.
	 */
	protected String targetNamespace;

	/**
	 * The ID of the extension in which the validator was defined.
	 */
	protected String domainID;

	/**
	 * Returns the domain matcher associated with the validator.
	 * 
	 * @return a domain matcher.
	 * 
	 */
	public final DomainMatcher getDomainMatcher() {
		if (matcher == null) {
			try {
				matcher = createDomainMatcher();
			} catch (UnsupportedOperationException e) {
				matcher = null;
			}
		}
		return matcher;
	}

	/**
	 * Subclasses need to implement to create a {@link DomainMatcher} that is specific to their
	 * domain.
	 * 
	 * @return a Domain
	 */
	protected abstract DomainMatcher createDomainMatcher();

	/**
	 * Validates the topology for this domain creating appropriate deploy markers.
	 * 
	 * @see DeployMarker
	 * 
	 * @param context
	 *           the domain validation context (used to extract the topology).
	 * @param reporter
	 *           used to create deploy markers.
	 */
	public abstract void validate(IDeployValidationContext context, IDeployReporter reporter);

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDomainValidator#getTargetNamespace()
	 */
	public String getDomainNsURI() {
		return targetNamespace;
	}

	/**
	 * Sets the namespace of the domain that this validator validates.
	 * 
	 * @param uri
	 *           a domain URI ({@link EPackage#getNsURI()}.
	 */
	public void setDomainNsURI(String uri) {
		targetNamespace = uri;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDomainValidator#getDomainID()
	 */
	public String getDomainID() {
		return domainID;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDomainValidator#getGroupID()
	 */
	public String getGroupID() {
		return IConstants.DEFAULT_VALIDATOR_GROUP_ID;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.validator.IDomainValidator#getGroupDescription()
	 */
	public String getGroupDescription() {
		return DeployCoreMessages.Model_validation;
	}

	/**
	 * Sets the ID of the extension in which the validator was declared.
	 * 
	 * @param id
	 *           the extension point ID.
	 */
	public void setDomainID(String id) {
		domainID = id;
	}
}
