/***************************************************************************************************
 * Copyright (c) 2008 IBM Corporation. All rights reserved.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.handlers;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.composites.AbstractCompositeFactory;
import com.ibm.ccl.soa.deploy.core.ui.composites.DmoComposite;
import com.ibm.ccl.soa.deploy.core.ui.composites.SynthDmoComposite;
import com.ibm.ccl.soa.deploy.core.ui.properties.DmoSyncHelper;

/**
 * @since 7.0
 * 
 */
public class StereotypeConstraintUIHandler extends AbstractCompositeFactory {

	private static final class StereotypeConstraintComposite extends SynthDmoComposite {

		/**
		 * @param parent
		 * @param dmObject
		 * @param ft
		 */
		protected StereotypeConstraintComposite(Composite parent, DeployModelObject dmObject,
				FormToolkit ft) {
			super(parent, dmObject, ft);
		}

		@Override
		protected void initializeContents(DmoSyncHelper synchHelper) {
			setLayout(new GridLayout(2, false));
			//Caption
			Label captionLabel = createLabel(com.ibm.ccl.soa.deploy.core.ui.properties.Messages.DetailRequirementComposite_Caption_);
			createTextEntry(this, CorePackage.Literals.DEPLOY_MODEL_OBJECT__DISPLAY_NAME, SWT.NONE,
					captionLabel);
			//Add includes field.
			Label stereotypeLabel = createLabel(Messages.StereotypeConstraintUIHandler_Includes_);
			createTextEntry(this, ConstraintPackage.Literals.STEREOTYPE_CONSTRAINT__INCLUDES,
					SWT.NONE, stereotypeLabel);

			//Add descriptive label.
			new Label(this, SWT.NONE); //filler
			Label label = new Label(this, SWT.NONE);
			label.setText(Messages.StereotypeConstraintUIHandler_Enter_one_or_more_stereotype_keys_);
			GridData gd = new GridData(SWT.BEGINNING, SWT.CENTER, true, false);
			gd.horizontalIndent = 5;
			label.setLayoutData(gd);
		}
	}

	/**
	 * 
	 */
	public StereotypeConstraintUIHandler() {
	}

	/**
	 * @param dmo
	 * @return <code>true</code> if this instance can provide a UI handler for <code>dmo</code>
	 */
	public boolean isUIHandlerForDeployModelObject(DeployModelObject dmo) {
		return dmo.eClass() == ConstraintPackage.Literals.STEREOTYPE_CONSTRAINT;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.ui.composites.AbstractCompositeFactory#createControls(org.eclipse.swt.widgets.Composite,
	 *      com.ibm.ccl.soa.deploy.core.DeployModelObject, org.eclipse.ui.forms.widgets.FormToolkit)
	 */
	@Override
	public DmoComposite createControls(Composite parent, DeployModelObject editDmo,
			FormToolkit factory) {
		DmoComposite composite = new StereotypeConstraintComposite(parent, editDmo, factory);
		factory.adapt(composite);
		return composite;
	}

}
