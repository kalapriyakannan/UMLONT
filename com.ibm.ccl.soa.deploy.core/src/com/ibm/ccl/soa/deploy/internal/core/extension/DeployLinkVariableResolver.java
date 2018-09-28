/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import org.eclipse.core.expressions.IVariableResolver;
import org.eclipse.core.runtime.CoreException;

import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.UnitLink;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;

/**
 * 
 */
public class DeployLinkVariableResolver implements IVariableResolver {

	private static final String SOURCE = "com.ibm.ccl.soa.deploy.DeployLink.source"; //$NON-NLS-1$
	private static final String SOURCE_UNIT = "com.ibm.ccl.soa.deploy.DeployLink.sourceUnit"; //$NON-NLS-1$
	private static final String TARGET = "com.ibm.ccl.soa.deploy.DeployLink.target"; //$NON-NLS-1$
	private static final String TARGET_UNIT = "com.ibm.ccl.soa.deploy.DeployLink.targetUnit"; //$NON-NLS-1$

	/**
	 * DeployLink object for which the properties will be resolved.
	 */
	private DeployLink link;

	/**
	 * Public constructor.
	 * 
	 * @param dmo
	 *           supposed to be DeploLink
	 */
	public DeployLinkVariableResolver(DeployModelObject dmo) {
		if (dmo instanceof DeployLink) {
			link = (DeployLink) dmo;
		}
	}

	public Object resolve(String name, Object[] args) throws CoreException {
		if (link == null) {
			return null;
		}
		if (SOURCE.equals(name)) {
			return getLinkSource();
		}
		if (SOURCE_UNIT.equals(name)) {
			return ValidatorUtils.getUnit(getLinkSource());
		}
		if (TARGET.equals(name)) {
			return getLinkTarget();
		}
		if (TARGET_UNIT.equals(name)) {
			return ValidatorUtils.getUnit(getLinkTarget());
		}
		return null;
	}

	private DeployModelObject getLinkSource() {
		if (link instanceof DependencyLink) {
			return ((DependencyLink) link).getSource();
		}
		if (link instanceof UnitLink) {
			return ((UnitLink) link).getSource();
		}
		if (link instanceof ConstraintLink) {
			return ((ConstraintLink) link).getSource();
		}
		if (link instanceof RealizationLink) {
			return ((RealizationLink) link).getSource();
		}
		return null;
	}

	private DeployModelObject getLinkTarget() {
		if (link instanceof DependencyLink) {
			return ((DependencyLink) link).getTarget();
		}
		if (link instanceof UnitLink) {
			return ((UnitLink) link).getTarget();
		}
		if (link instanceof ConstraintLink) {
			return ((ConstraintLink) link).getTarget();
		}
		if (link instanceof RealizationLink) {
			return ((RealizationLink) link).getTarget();
		}
		return null;
	}
}
