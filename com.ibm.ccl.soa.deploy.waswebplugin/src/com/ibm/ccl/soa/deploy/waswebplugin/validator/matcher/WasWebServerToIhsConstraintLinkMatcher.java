/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.waswebplugin.validator.matcher;

import org.eclipse.emf.ecore.EClass;

import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.validator.pattern.matcher.ConstraintDependencyLinkMatcher;
import com.ibm.ccl.soa.deploy.core.validator.pattern.matcher.ConstraintLinkDescriptorFactory;
import com.ibm.ccl.soa.deploy.ihs.IhsPackage;
import com.ibm.ccl.soa.deploy.was.WasPackage;
import com.ibm.ccl.soa.deploy.was.WasWebServerUnit;
import com.ibm.ccl.soa.deploy.waswebplugin.IhsWasPluginUnit;
import com.ibm.ccl.soa.deploy.waswebplugin.WaswebpluginPackage;

/**
 * Matches a {@link ConstraintLink} from {@link WasWebServerUnit} to {@link IhsWasPluginUnit}.
 */
public class WasWebServerToIhsConstraintLinkMatcher extends ConstraintDependencyLinkMatcher {

	/**
	 * Matches a {@link ConstraintLink} from {@link WasWebServerUnit} to {@link IhsWasPluginUnit}.
	 */
	public WasWebServerToIhsConstraintLinkMatcher() {
		super(new EClass[] { WasPackage.Literals.WAS_WEB_SERVER_UNIT }, new EClass[] {},
				new EClass[] { WaswebpluginPackage.Literals.IHS_WAS_PLUGIN_UNIT,
						IhsPackage.Literals.IHS_SERVER_UNIT, IhsPackage.Literals.IHS_SYSTEM_UNIT },
				new EClass[] {}, true);
		setLinkDescritptorFactory(new ConstraintLinkDescriptorFactory(
				new WasWebServerToIhsConstraintFactory()));
	}
}
