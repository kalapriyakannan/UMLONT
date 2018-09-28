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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Capability Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 			    Binds a {@link Requirement} to a {@link Capability} which satisfies it.
 * 			    <p>
 * 			    Dependency links are binary relationships.  In the programming interface they are 
 * 			    created by {@link CoreFactory#createDependencyLink()}.  In the user interface, they
 * 			    are created  by the {@link com.ibm.ccl.soa.deploy.core.validator.matcher.DomainMatcher}
 * 			    using the<code>getPossibleLinks</code> methods.  They may be extended to associate
 * 			    additional information with the binding.  In such cases, the user must also modify
 * 			    the matcher to return descriptors that will create the required subtype.</p>
 * 			    <p>
 * 			    The endpoints of the dependency links are serialized as topology paths obtained
 * 			    using {@link DeployModelObject#getFullPath()}.  In the first release of the Topology
 * 			    Definition Model (TDM), the source of the dependency link is the containing requirement
 * 			    {@link #getParent()}.  In future versions, dependency links may be contained in an
 * 			    object that is different from the source, so users should use {@link #getSource} to
 * 			    obtain the requirement, rather than casting the result of {@link #getParent}.</p>
 * 			
 * <!-- end-model-doc -->
 *
 *
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getDependencyLink()
 * @model extendedMetaData="name='DependencyLink' kind='elementOnly'"
 * @generated
 */
public interface DependencyLink extends DeployLink {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * Returns the requirement source of the dependency link.
	 * 
	 * @return a {@link Requirement} element which is the source of this link.
	 * 
	 * Null will be returned in the case that no source was set. If a source was set but failed to
	 * resolve then a {@link Requirement} element will be returned with an error status. Be sure to
	 * check the status of the returned {@link Requirement} using the {@link #getStatus()} method.
	 */
	Requirement getSource();

	/**
	 * Returns the unresolved URI of the dependency link target.
	 * <p>
	 * Users should invoke {@link #getTarget()} to obtain the resolved target. This method will
	 * typically used to determine if there was a resolution error when {@link #getTarget()} returns
	 * <code>null</code>
	 * 
	 * @return the URI to the target.
	 */
	String getTargetURI();

	/**
	 * @return a {@link Capability} element which is the target of this link.
	 * 
	 * Null will be returned in the case that no source was set. If a source was set but failed to
	 * resolve then a {@link Capability} element will be returned with an error status. Be sure to
	 * check the status of the returned {@link Capability} using the {@link #getStatus()} method.
	 */
	Capability getTarget();

	/**
	 * This API is used to set the target element of this link to the passed {@link Capability}
	 * object.
	 * 
	 * @param service -
	 *           the {@link Capability} object that will be used as the target of this link.
	 */
	void setTarget(Capability service);

	/**
	 * This API is used to set the source element of this link to the passed {@link Requirement}
	 * object.
	 * 
	 * @param req -
	 *           the {@link Requirement} object that will be used as the source of this link.
	 */
	void setSource(Requirement req);

} // DependencyLink
