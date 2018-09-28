/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.actions;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ShortConstraintDescriptor;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.CanonicalUtils;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;

/**
 * An action which creates a Constraint beween two Units.
 * 
 * @author Ed Snible
 * @see ConstraintsMenuManager
 */
public class ConstrainAction extends Action implements IAction {

	private final Unit source;
	private final Unit target;
	private final ShortConstraintDescriptor descr;

	/**
	 * @param parent1
	 * @param parent2
	 * @param scd
	 */
	public ConstrainAction(Unit parent1, Unit parent2, ShortConstraintDescriptor scd) {
		Assert.isNotNull(parent1);
		Assert.isNotNull(parent2);
		Assert.isNotNull(scd);

		source = parent1;
		target = parent2;
		descr = scd;
	}

	public void run() {
		// Force a LogicalLink
		final ConstraintLink ll = CoreFactory.eINSTANCE.createConstraintLink();
		ll.setName(UnitUtil.generateUniqueName(source, "cl")); //$NON-NLS-1$
		Constraint constraint = descr.createConstraint(ll);
		constraint.setName(UnitUtil.generateUniqueName(ll, "c")); //$NON-NLS-1$
		ll.getConstraints().add(constraint);
		ll.setTarget(target);
		ll.setSource(source);

		String msg = Messages.ConstrainAction_Add_constrain_;
		PropertyUtils.executeWithUndo(source, msg, new Runnable() {

			public void run() {
				source.getConstraintLinks().add(ll);
				CanonicalUtils.refreshLinks();
			}
		});
	}

	@Override
	public String getText() {
		return descr.getTitle();
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

} // end class ConstrainAction
