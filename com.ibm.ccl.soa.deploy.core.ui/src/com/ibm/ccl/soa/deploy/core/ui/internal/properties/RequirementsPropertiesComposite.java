/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.properties;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;

/**
 * @author daberg
 * @deprecated
 * @see DetailRequirementComposite
 */
public class RequirementsPropertiesComposite extends Composite {

	private SashForm sashForm = null;

	public RequirementsPropertiesComposite(Composite parent, int style) {
		super(parent, style);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_REQUIREMENTS_FLYOUT_DETAILS);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
		this.setLayout(new GridLayout());
		createSashForm();
		this.setSize(new Point(549, 219));

	}

	/**
	 * This method initializes sashForm
	 * 
	 */
	private void createSashForm() {
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		sashForm = new SashForm(this, SWT.NONE);
		sashForm.setLayoutData(gridData);
	}

} //  @jve:decl-index=0:visual-constraint="10,10"
