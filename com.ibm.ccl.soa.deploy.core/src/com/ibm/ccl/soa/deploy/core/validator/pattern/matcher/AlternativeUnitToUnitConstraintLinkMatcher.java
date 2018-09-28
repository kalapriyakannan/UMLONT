/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.validator.pattern.matcher;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.Unit;

/**
 * A generic matcher for unit-to-unit logical links based on unit type.
 */
public class AlternativeUnitToUnitConstraintLinkMatcher extends ConstraintDependencyLinkMatcher {

	/**
	 * Construct a logical link matcher between the two units.
	 * 
	 * @param sourceType
	 *           the type of the link source, a subtype of {@link Unit}.
	 * @param targetType
	 *           the type of the link targeta subtype of {@link Unit}
	 * @param singleton
	 *           true if only one instance of this link can be created.
	 */
	public AlternativeUnitToUnitConstraintLinkMatcher(EClass sourceType, EClass targetType,
			boolean singleton) {
		super(new EClass[] { sourceType }, new EClass[] {}, new EClass[] { targetType },
				new EClass[] {}, singleton);
	}
}
