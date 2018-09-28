/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployStatus;

/**
 * Static utility constants and methods related to deploy collections.
 */
public final class DeployCollections {

	private DeployCollections() {
		// prevent instantiation
	}

	/**
	 * An unmodifiable empty list of deploy model objects.
	 * 
	 * @deprecated use {@link Collections#emptyList()}
	 */
	public static final List<DeployModelObject> EMPTY_DEPLOY_MODEL_OBJECT_LIST = Collections
			.unmodifiableList(new ArrayList<DeployModelObject>(0));

	/**
	 * An unmodifiable empty list of units.
	 * 
	 * @deprecated use {@link Collections#emptyList()}
	 */
	public static final List<Unit> EMPTY_UNIT_LIST = Collections
			.unmodifiableList(new ArrayList<Unit>(0));

	/**
	 * An unmodifiable empty list of capabilities.
	 * 
	 * @deprecated use {@link Collections#emptyList()}
	 */
	public static final List<Capability> EMPTY_CAPABILITY_LIST = Collections
			.unmodifiableList(new ArrayList<Capability>(0));

	/**
	 * An unmodifiable empty list of units.
	 * 
	 * @deprecated use {@link Collections#emptyList()}
	 */
	public static final List<Requirement> EMPTY_REQUIREMENT_LIST = Collections
			.unmodifiableList(new ArrayList<Requirement>(0));

	/**
	 * An unmodifiable empty list of hosting links.
	 * 
	 * @deprecated use {@link Collections#emptyList()}
	 */
	public static final List<HostingLink> EMPTY_HOSTING_LINK_LIST = Collections
			.unmodifiableList(new ArrayList<HostingLink>(0));

	/**
	 * An unmodifiable empty list of member links.
	 * 
	 * @deprecated use {@link Collections#emptyList()}
	 */
	public static final List<MemberLink> EMPTY_MEMBER_LINK_LIST = Collections
			.unmodifiableList(new ArrayList<MemberLink>(0));

	/**
	 * An unmodifiable empty list of dependency links.
	 * 
	 * @deprecated use {@link Collections#emptyList()}
	 */
	public static final List<DependencyLink> EMPTY_DEPENDENCY_LINK_LIST = Collections
			.unmodifiableList(new ArrayList<DependencyLink>(0));

	/**
	 * An unmodifiable empty list of realization links.
	 * 
	 * @deprecated use {@link Collections#emptyList()}
	 */
	public static final List<RealizationLink> EMPTY_REALIZATION_LINK_LIST = Collections
			.unmodifiableList(new ArrayList<RealizationLink>(0));

	/**
	 * An unmodifiable empty list of status.
	 * 
	 * @deprecated use {@link Collections#emptyList()}
	 */
	public static final List<IStatus> EMPTY_STATUS_LIST = Collections
			.unmodifiableList(new ArrayList<IStatus>(0));

	/**
	 * An unmodifiable empty list of deploy status.
	 * 
	 * @deprecated use {@link Collections#emptyList()}
	 */
	public static final List<IDeployStatus> EMPTY_DEPLOY_STATUS_LIST = Collections
			.unmodifiableList(new ArrayList<IDeployStatus>(0));

	/**
	 * An unmodifiable empty set of deploy model objects.
	 * 
	 * @deprecated use {@link Collections#emptySet()}
	 */
	public static final Set<DeployModelObject> EMPTY_DEPLOY_MODEL_OBJECT_SET = Collections
			.unmodifiableSet(new HashSet<DeployModelObject>(0));
}
