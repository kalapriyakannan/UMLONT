/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.util;

import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;

/**
 * Adapts a {@link Requirement} by setting its {@link Requirement#getLinkType()} property.
 * <p>
 * TODO provide a constructor and generic implementation (as per {@link RequirementLinkTypeFilter}).
 */
public class RequirementLinkTypeAdapter {

	private RequirementLinkTypeAdapter() {
		// prevent instantiation for now.
	}

	/**
	 * Adapts a {@link Requirement} by setting {@link Requirement#getLinkType()} to
	 * {@link RequirementLinkTypes#ANY} if it is not {@link RequirementLinkTypes#HOSTING}.
	 */
	public static final IObjectAdapter SET_REQUIREMENT_LINK_TYPE_ANY_IF_NON_HOSTING_ADAPTER = new IObjectAdapter() {
		public Object adapt(Object object) {
			if (object instanceof Requirement) {
				Requirement r = (Requirement) object;
				if ((r.getLinkType() != RequirementLinkTypes.HOSTING_LITERAL)
						&& (r.getLinkType() != RequirementLinkTypes.ANY_LITERAL)) {
					r.setLinkType(RequirementLinkTypes.ANY_LITERAL);
				}
				return r;
			}
			return null;
		}
	};

	/**
	 * Adapts a {@link Requirement} by setting {@link Requirement#getLinkType()} to
	 * {@link RequirementLinkTypes#ANY} if it is not {@link RequirementLinkTypes#DEPENDENCY}.
	 */
	public static final IObjectAdapter SET_REQUIREMENT_LINK_TYPE_ANY_IF_NON_DEPENDENCY_ADAPTER = new IObjectAdapter() {
		public Object adapt(Object object) {
			if (object instanceof Requirement) {
				Requirement r = (Requirement) object;
				if ((r.getLinkType() != RequirementLinkTypes.DEPENDENCY_LITERAL)
						&& (r.getLinkType() != RequirementLinkTypes.ANY_LITERAL)) {
					r.setLinkType(RequirementLinkTypes.ANY_LITERAL);
				}
				return r;
			}
			return null;
		}
	};

	/**
	 * Adapts a {@link Requirement} by setting {@link Requirement#getLinkType()} to
	 * {@link RequirementLinkTypes#ANY} if it is not {@link RequirementLinkTypes#MEMBER}.
	 */
	public static final IObjectAdapter SET_REQUIREMENT_LINK_TYPE_ANY_IF_NON_MEMBER_ADAPTER = new IObjectAdapter() {
		public Object adapt(Object object) {
			if (object instanceof Requirement) {
				Requirement r = (Requirement) object;
				if ((r.getLinkType() != RequirementLinkTypes.MEMBER_LITERAL)
						&& (r.getLinkType() != RequirementLinkTypes.ANY_LITERAL)) {
					r.setLinkType(RequirementLinkTypes.ANY_LITERAL);
				}
				return r;
			}
			return null;
		}
	};

	/**
	 * Adapts a {@link Requirement} by setting {@link Requirement#getLinkType()} to
	 * {@link RequirementLinkTypes#HOSTING}.
	 */
	public static final IObjectAdapter SET_REQUIREMENT_LINK_TYPE_HOSTING_ADAPTER = new IObjectAdapter() {
		public Object adapt(Object object) {
			if (object instanceof Requirement) {
				Requirement r = (Requirement) object;
				if (r.getLinkType() != RequirementLinkTypes.HOSTING_LITERAL) {
					r.setLinkType(RequirementLinkTypes.HOSTING_LITERAL);
				}
				return r;
			}
			return null;
		}
	};

	/**
	 * Adapts a {@link Requirement} by setting {@link Requirement#getLinkType()} to
	 * {@link RequirementLinkTypes#DEPENDENCY}.
	 */
	public static final IObjectAdapter SET_REQUIREMENT_LINK_TYPE_DEPENDENCY_ADAPTER = new IObjectAdapter() {
		public Object adapt(Object object) {
			if (object instanceof Requirement) {
				Requirement r = (Requirement) object;
				if (r.getLinkType() != RequirementLinkTypes.DEPENDENCY_LITERAL) {
					r.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
				}
				return r;
			}
			return null;
		}
	};

	/**
	 * Adapts a {@link Requirement} by setting {@link Requirement#getLinkType()} to
	 * {@link RequirementLinkTypes#ANY}.
	 */
	public static final IObjectAdapter SET_REQUIREMENT_LINK_TYPE_EXPOSED_HOSTING_ADAPTER = new IObjectAdapter() {
		public Object adapt(Object object) {
			if (object instanceof Requirement) {
				Requirement r = (Requirement) object;
				if (r.getLinkType() != RequirementLinkTypes.ANY_LITERAL) {
					r.setLinkType(RequirementLinkTypes.ANY_LITERAL);
				}
				return r;
			}
			return null;
		}
	};

	/**
	 * Adapts a {@link Requirement} by setting {@link Requirement#getLinkType()} to
	 * {@link RequirementLinkTypes#DEPENDENCY}.
	 */
	public static final IObjectAdapter SET_REQUIREMENT_DEPENDENCY_LINK_TYPE_ADAPTER = new IObjectAdapter() {
		public Object adapt(Object object) {
			if (object instanceof Requirement) {
				Requirement r = (Requirement) object;
				if (r.getLinkType() != RequirementLinkTypes.DEPENDENCY_LITERAL) {
					r.setLinkType(RequirementLinkTypes.DEPENDENCY_LITERAL);
				}
				return r;
			}
			return null;
		}
	};

	/**
	 * Adapts a {@link Requirement} by setting {@link Requirement#getLinkType()} to
	 * {@link RequirementLinkTypes#MEMBER}.
	 */
	public static final IObjectAdapter SET_REQUIREMENT_MEMBER_LINK_TYPE_ADAPTER = new IObjectAdapter() {
		public Object adapt(Object object) {
			if (object instanceof Requirement) {
				Requirement r = (Requirement) object;
				if (r.getLinkType() != RequirementLinkTypes.MEMBER_LITERAL) {
					r.setLinkType(RequirementLinkTypes.MEMBER_LITERAL);
				}
				return r;
			}
			return null;
		}
	};

}
