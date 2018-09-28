/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.util;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.ibm.ccl.soa.deploy.core.Artifact;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;

/**
 * Filter ECore objects of a specified type.
 */
public final class EObjectTypeFilter<T extends EObject> implements IObjectFilter<T> {

	/** Filters objects that are instances of {@link HostingLink} */
	public static final IObjectFilter HOSTING_LINK_FILTER = new EObjectTypeFilter(
			CorePackage.eINSTANCE.getHostingLink(), true);

	/** Filters objects that are instances of {@link MemberLink} */
	public static final IObjectFilter MEMBER_LINK_FILTER = new EObjectTypeFilter(
			CorePackage.eINSTANCE.getMemberLink(), true);

	/** Filters objects that are instances of {@link RealizationLink} */
	public static final IObjectFilter REALIZATION_LINK_FILTER = new EObjectTypeFilter(
			CorePackage.eINSTANCE.getRealizationLink(), true);

	/** Filters objects that are instances of {@link Artifact} */
	public static final IObjectFilter ARTIFACT_FILTER = new EObjectTypeFilter(CorePackage.eINSTANCE
			.getArtifact(), true);

	/** Filters objects that are instances of {@link RequirementExpression} */
	public static final IObjectFilter REQ_EXPR_FILTER = new EObjectTypeFilter(CorePackage.eINSTANCE
			.getRequirementExpression(), true);

	/** Filters objects that are instances of {@link Requirement} */
	public static final IObjectFilter REQUIREMENT_FILTER = new EObjectTypeFilter(
			CorePackage.eINSTANCE.getRequirement(), true);

	/** EObject type accepted. */
	private final EClass type;

	/** True if subtypes are accepted. */
	private final boolean subtypeMatch;

	/**
	 * Construct a type-based deploy model object filter.
	 * 
	 * @param type
	 *           an ECore class.
	 * @param subtypeMatch
	 *           true if subtypes of the type argument should be accepted.
	 */
	public EObjectTypeFilter(EClass type, boolean subtypeMatch) {
		assert type != null;
		this.type = type;
		this.subtypeMatch = subtypeMatch;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.internal.core.validator.ObjectFilter#checkFilterAccept(java.lang.Object)
	 */
	public boolean accept(T value) {
		if (!(value instanceof EObject)) {
			return false;
		}
		EObject object = value;
		if (subtypeMatch) {
			return type.isSuperTypeOf(object.eClass());
		}
		return type == object.eClass();
	}
}
