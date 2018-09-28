/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.editpolicies;

import com.ibm.ccl.soa.deploy.core.RealizationLink;

/**
 * @since 1.0
 * 
 */
public interface DeployEditPolicyRoles {
	/**
	 * The key used to install a <i>decoration</i> EditPolicy, one that handles creation and removal
	 * of decorations.
	 */
	public static final String QUICK_FIX_ROLE = "QuickFixPolicy"; //$NON-NLS-1$

	/**
	 * The key used to install a <i>nub decoration</i> EditPolicy, one that handles creation and
	 * removal of decorations.
	 */
	public static final String NUB_EDIT_ROLE = "NubEditPolicy"; //$NON-NLS-1$

//	/**
//	 * The key used to install a <i>deploy filter</i> EditPolicy, one that handles
//	 * hiding/showing figures.
//	 */
//	public static final String CUSTOM_FILTER_ROLE = "SoaCustomFilterRole"; //$NON-NLS-1$

	/**
	 * The key used to install a <i>canonical diagram</i> EditPolicy, one that handles updating
	 * views in the diagram. The default CANONICAL_ROLE prevents just the view from being deleted
	 */
	public static final String DIAGRAM_CANONICAL_ROLE = "DiagramCanonical"; //$NON-NLS-1$

	/**
	 * The key used to install a <i>canonical hosting link</i> EditPolicy, one that handles updating
	 * hosting link views.
	 */
	public static final String HOSTING_CANONICAL_ROLE = "HostingCanonical"; //$NON-NLS-1$

	/**
	 * The key used to install a <i>canonical dependency link</i> EditPolicy, one that handles
	 * updating dependency link views.
	 */
	public static final String DEPENDENCY_CANONICAL_ROLE = "DependencyCanonical"; //$NON-NLS-1$

	/**
	 * The key used to install a <i>canonical logical link</i> EditPolicy, one that handles updating
	 * logical link views.
	 */
	public static final String LOGICAL_CANONICAL_ROLE = "LogicalCanonical"; //$NON-NLS-1$

	/**
	 * The key used to install a <i>canonical realization link</i> EditPolicy, one that handles
	 * updating {@link RealizationLink} views.
	 * 
	 * @see RealizationLinkCanonicalConnectorEditPolicy
	 */
	public static final String REALIZATION_CANONICAL_ROLE = "RealizationCanonical"; //$NON-NLS-1$

	/**
	 * The role used to install a Duplicate Editpolicy which handles updating duplicate tag and
	 * index.
	 */
	public static final String DUPLICATE_ROLE = "DeployDuplicate"; //$NON-NLS-1$
}
