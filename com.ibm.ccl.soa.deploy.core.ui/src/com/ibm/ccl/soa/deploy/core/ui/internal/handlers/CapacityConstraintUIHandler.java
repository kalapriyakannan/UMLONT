/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.handlers;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.constraint.CapacityConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.TypeConstraint;
import com.ibm.ccl.soa.deploy.core.ui.composites.DmoComposite;

/**
 * Composite Factory for a {@link CapacityConstraint}.
 * 
 * <p>
 * Registered through the <code>com.ibm.ccl.soa.deploy.ui.compositeFactories</code> extension
 * point.
 * 
 */
public class CapacityConstraintUIHandler extends AttributeValueUIHandler {

	/**
	 * 
	 */
	public CapacityConstraintUIHandler() {
		// do nothing
	}

	/**
	 * @param dmo
	 * @return <code>true</code> if this instance can provide a UI handler for <code>dmo</code>
	 */
	public boolean isUIHandlerForDeployModelObject(DeployModelObject dmo) {
		return dmo.eClass() == ConstraintPackage.Literals.CAPACITY_CONSTRAINT;
	}

	public DmoComposite createControls(Composite parent, DeployModelObject editDmo,
			FormToolkit formToolkit) /* throws SAFException */{

		TypeConstraintValueComposite composite = new TypeConstraintValueComposite(parent,
				(TypeConstraint) editDmo, formToolkit, true, true);
		formToolkit.adapt(composite);
		return composite;
	}

} // end class TypeConstraintUIHandler

