/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Unit Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 			    A generic binding of a {@link Unit} to another {@link Unit}.
 * 			    <p>
 * 			    Unit links are binary relationships.  In the programming interface they are 
 * 			    created by {@link CoreFactory#createUnitLink()}.  In the user interface, they
 * 			    cannot be directly instantiated.  Instead, users instantiate one of their two
 * 			    core subtypes: {@link HostingLink} or {@link MemberLink}.</p>
 * 			    <p>
 * 			    Users may extend {@link UnitLink} to provide new kinds of unit to unit relationships.
 * 			    In such cases, the domain implementation of the abstract domain matcher
 * 			    {@link com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher}
 * 			    must be extended to return link descriptors that generate the subtype instance.</p>
 * 			    <p>
 * 			    The endpoints of unit links are serialized as topology paths obtained
 * 			    using {@link DeployModelObject#getFullPath()}.  In the first release of the Topology
 * 			    Definition Model (TDM), the source of the unit link is the containing unit
 * 			    {@link #getParent()}.  In future versions, unit links may be contained in an object
 * 			    that is different from the source, so users should use {@link #getSource} to
 * 			    obtain the requirement, rather than casting the result of {@link #getParent}.</p>.
 * 			
 * <!-- end-model-doc -->
 *
 *
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getUnitLink()
 * @model extendedMetaData="name='UnitLink' kind='elementOnly'"
 * @generated
 */
public interface UnitLink extends DeployLink {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Return the {@link Unit} which is the target of this link.
	 * 
	 * @return The traget {@link Unit} element.
	 */
	Unit getTarget();

	/**
	 * Set the target {@link Unit} for this link.
	 * 
	 * @param targetUnit -
	 *           A {@link Unit} that will be the target of this link.
	 */
	void setTarget(Unit targetUnit);

	/**
	 * @return the source {@link Unit}.
	 */
	Unit getSource();

	/**
	 * Set the source of this link.
	 * 
	 * @param sourceUnit -
	 *           A {@link Unit} that will be the source of the link. This will be implied when the
	 *           link is added to a {@link Unit} using {@link Unit#getUnitLinks()}.
	 */
	void setSource(Unit sourceUnit);

} // UnitLink
