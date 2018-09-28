/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.validator.matcher;

import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * Link type definitions.
 * 
 * @see LinkDescriptor
 */
public class LinkType {

	/** dependency link type value */
	public static final int DEPENDENCY_VALUE = 1;
	/** dependency link type */
	public static final LinkType DEPENDENCY = new LinkType(DEPENDENCY_VALUE,
			DeployCoreMessages.DEPENDENCY);

	/** set containing just DEPENDENCY link types */
	public static final LinkType[] DEPENDENCY_SET = new LinkType[] { DEPENDENCY };

	/** hosting link type value */
	public static final int HOSTING_VALUE = 2;
	/** hosting link type */
	public static final LinkType HOSTING = new LinkType(HOSTING_VALUE, DeployCoreMessages.HOSTING);

	/** set containing just HOSTING link types */
	public static final LinkType[] HOSTING_SET = new LinkType[] { HOSTING };

	/** constraint link type value */
	public static final int CONSTRAINT_VALUE = 3;
	/** logical link type */
	public static final LinkType CONSTRAINT = new LinkType(CONSTRAINT_VALUE,
			DeployCoreMessages.CONSTRAINT);

	/** set containing just LOGICAL link types */
	public static final LinkType[] CONSTRAINT_SET = new LinkType[] { CONSTRAINT };

	/** member link type value */
	public static final int MEMBER_VALUE = 4;
	/** member link type */
	public static final LinkType MEMBER = new LinkType(MEMBER_VALUE, DeployCoreMessages.MEMBER);

	/** set containing just MEMBER link types */
	public static final LinkType[] MEMBER_SET = new LinkType[] { MEMBER };

	/** realization link type value */
	public static final int REALIZATION_VALUE = 5;
	/** realization link type */
	public static final LinkType REALIZATION = new LinkType(REALIZATION_VALUE,
			DeployCoreMessages.REALIZATION);

	/** set containing just REALIZATION link types */
	public static final LinkType[] REALIZATION_SET = new LinkType[] { REALIZATION };

	/** all link types */
	public static final LinkType[] ALL_LINK_TYPES = new LinkType[] { DEPENDENCY, HOSTING,
			CONSTRAINT, MEMBER, REALIZATION };

	/** link type as integer */
	private final int value;

	/** link type description */
	private final String description;

	/**
	 * No public constructor. Only static finals defined above are externally visible.
	 * 
	 * @param value
	 *           link type value
	 * @param description
	 *           link type description
	 */
	private LinkType(int value, String description) {
		this.value = value;
		this.description = description;
	}

	/**
	 * Retrieve the link type description.
	 * 
	 * @return link type description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Return the integer type values associated with this link type
	 * 
	 * @return type value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Determine if this link type is in a given array of link types.
	 * 
	 * @param array
	 *           array of link types to inspect
	 * @return true if this is in the array
	 */
	public boolean memberOf(LinkType[] array) {
		if (null == array) {
			return false;
		}
		for (int i = 0; i < array.length; i++) {
			if (this.equals(array[i])) {
				return true;
			}
		}
		return false;
	}

	public boolean equals(Object type) {
		return value == ((LinkType) type).value;
	}
}
