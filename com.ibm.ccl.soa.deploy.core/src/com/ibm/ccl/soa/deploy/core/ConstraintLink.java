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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Logical Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 			    Constraint links express a high-level binary constraint pattern between two entities.
 * 			    <p>
 * 			    The endpoints of constraint links can be any type of {@link DeployModelObject}. 
 * 			    The semantics of a constraint link is determined by the child constraint of the link.
 * 			    Constraint links may be created in various ways. There is a UI tool to create constaints links 
 * 			    with a predefined constraint, by using context menu for a pair of selected objects. 
 * 			    Another way to be able to create a constraint link is for a constraint extension to declare 
 * 			    a specialized link matcher in the <code>com.ibm.ccl.soa.deploy.core.constraints</code>
 * 			    extension point (using &lt;linkMatcher/&gt; element).</p>
 * 			    <p>
 * 			    Constraint links will also be used for the old "Logical Link" mechanism (which will be 
 * 			    decrecated in M6 milestone). Below is the description of this mechanism.</p>
 * 			    <p>
 * 			    The semantics of the "logical link" are domain specific. Logical links are created by specialized
 * 			    matchers which are declared using the <code>com.ibm.ccl.soa.deploy.core.logicalLink</code>
 * 			    extension point.</p>
 * 			    <p>
 * 			    Programmatically, logical link instances are created using {@link CoreFactory#createLogicalLink()}.
 * 			    The deployment editor allows users to create logical links using the dependency lollypop or
 * 			    the hosting lollypop.  It is the responsibility of the logical link matcher 
 * 			    {@link com.ibm.ccl.soa.deploy.core.logicallink.LogicalLinkMatcher} to check
 * 			    the preconditions, and create an appropriate descriptor.</p>
 * 			    <p>
 * 			    The {@link com.ibm.ccl.soa.deploy.core.logicallink.LogicalLinkImplementation} class
 * 			    declared in the extension point is responsible for validating that the logical pattern
 * 			    represented by the link has been implemented.  If it has not, then the implementation
 * 			    is also responsible for providing a resolution that will implement it.</p>
 * 			
 * <!-- end-model-doc -->
 *
 *
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getConstraintLink()
 * @model extendedMetaData="name='ConstraintLink' kind='elementOnly'"
 * @generated
 */
public interface ConstraintLink extends DeployLink {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * @return the source of the logical link, or null if not set.
	 */
	DeployModelObject getSource();

	/**
	 * Sets the source of the logical link.
	 * 
	 * @param object
	 *           the deploy model object source.
	 */
	void setSource(DeployModelObject object);

	/**
	 * @return the target of the logical link, or null if not set.
	 */
	DeployModelObject getTarget();

	/**
	 * Returns the unresolved URI of the logical link target.
	 * <p>
	 * Users should invoke {@link #getTarget()} to obtain the resolved target. This method will
	 * typically used to determine if there was a resolution error when {@link #getTarget()} returns
	 * <code>null</code>
	 * 
	 * @return the URI to the target.
	 */
	String getTargetURI();

	/**
	 * Sets the target of the logical link.
	 * 
	 * @param object
	 *           the deploy model object target.
	 */
	void setTarget(DeployModelObject object);

} // LogicalLink
