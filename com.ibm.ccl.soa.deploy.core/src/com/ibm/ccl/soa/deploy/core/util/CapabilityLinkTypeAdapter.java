/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.util;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;

/**
 * Adapts a {@link Capability} by setting its {@link Capability#getLinkType()} property.
 * <p>
 * TODO provide a constructor and generic implementation (as per {@link CapabilityLinkTypeFilter}).
 */
public class CapabilityLinkTypeAdapter {

	private CapabilityLinkTypeAdapter() {
		// prevent instantiation for now.
	}

	/**
	 * Adapts a {@link Capability} by setting {@link Capability#getLinkType()} to
	 * {@link CapabilityLinkTypes#ANY} if the link type is not {@link CapabilityLinkTypes#HOSTING}.
	 */
	public static final IObjectAdapter SET_CAPABILITY_LINK_TYPE_ANY_IF_NON_HOSTING_ADAPTER = new IObjectAdapter() {
		public Object adapt(Object object) {
			if (object instanceof Capability) {
				Capability c = (Capability) object;
				if ((c.getLinkType() != CapabilityLinkTypes.HOSTING_LITERAL)
						&& (c.getLinkType() != CapabilityLinkTypes.ANY_LITERAL)) {
					c.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
				}
				return c;
			}
			return null;
		}
	};

	/**
	 * Adapts a {@link Capability} by setting {@link Capability#getLinkType()} to
	 * {@link CapabilityLinkTypes#ANY} if the link type is not {@link CapabilityLinkTypes#DEPENDENCY}.
	 */
	public static final IObjectAdapter SET_CAPABILITY_LINK_TYPE_ANY_IF_NON_DEPENDENCY_ADAPTER = new IObjectAdapter() {
		public Object adapt(Object object) {
			if (object instanceof Capability) {
				Capability c = (Capability) object;
				if ((c.getLinkType() != CapabilityLinkTypes.DEPENDENCY_LITERAL)
						&& (c.getLinkType() != CapabilityLinkTypes.ANY_LITERAL)) {
					c.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
				}
				return c;
			}
			return null;
		}
	};

	/**
	 * Adapts a {@link Capability} by setting {@link Capability#getLinkType()} to
	 * {@link CapabilityLinkTypes#ANY}.
	 */
	public static final IObjectAdapter SET_CAPABILITY_LINK_TYPE_ANY_ADAPTER = new IObjectAdapter() {
		public Object adapt(Object object) {
			if (object instanceof Capability) {
				Capability c = (Capability) object;
				if (c.getLinkType() != CapabilityLinkTypes.ANY_LITERAL) {
					c.setLinkType(CapabilityLinkTypes.ANY_LITERAL);
				}
				return c;
			}
			return null;
		}
	};

	/**
	 * Adapts a {@link Capability} by setting {@link Capability#getLinkType()} to
	 * {@link CapabilityLinkTypes#DEPENDENCY}.
	 */
	public static final IObjectAdapter SET_CAPABILITY_LINK_TYPE_DEPENDENCY_ADAPTER = new IObjectAdapter() {
		public Object adapt(Object object) {
			if (object instanceof Capability) {
				Capability c = (Capability) object;
				if (c.getLinkType() != CapabilityLinkTypes.DEPENDENCY_LITERAL) {
					c.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
				}
				return c;
			}
			return null;
		}
	};

	/**
	 * Adapts a {@link Capability} by setting {@link Capability#getLinkType()} to
	 * {@link CapabilityLinkTypes#HOSTING}.
	 */
	public static final IObjectAdapter SET_CAPABILITY_LINK_TYPE_HOSTING_ADAPTER = new IObjectAdapter() {
		public Object adapt(Object object) {
			if (object instanceof Capability) {
				Capability c = (Capability) object;
				if (c.getLinkType() != CapabilityLinkTypes.HOSTING_LITERAL) {
					c.setLinkType(CapabilityLinkTypes.HOSTING_LITERAL);
				}
				return c;
			}
			return null;
		}
	};

	/**
	 * Adapts a {@link Capability} by setting {@link Capability#getLinkType()} to
	 * {@link CapabilityLinkTypes#DEPENDENCY}.
	 */
	public static final IObjectAdapter SET_CAPABILITY_DEPENDENCY_LINK_TYPE_ADAPTER = new IObjectAdapter() {
		public Object adapt(Object object) {
			if (object instanceof Capability) {
				Capability c = (Capability) object;
				if (c.getLinkType() != CapabilityLinkTypes.DEPENDENCY_LITERAL) {
					c.setLinkType(CapabilityLinkTypes.DEPENDENCY_LITERAL);
				}
				return c;
			}
			return null;
		}
	};

}
