/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.constraint;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;

/**
 * Publicly exposed representation of a constraint definition in the 'constraints' extension point.
 */
public interface ShortConstraintDescriptor extends Comparable {

	/**
	 * @return ID of the constraint definition
	 */
	public String getId();

	/**
	 * @return the title of the constraint
	 */
	public String getTitle();

	/**
	 * @return namespace of the EMF package where the constraint is defined.
	 */
	public String getNamespace();

	/**
	 * @return type (XML complex type name) of the constraint.
	 */
	public String getType();

	/**
	 * Creates constraint instance.
	 * 
	 * @param parent
	 *           parent DMO
	 * 
	 * @return created constraint instance. May return NULL.
	 */
	public Constraint createConstraint(DeployModelObject parent);
}
