/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.handlers;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.fieldassist.DecoratedField;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ui.composites.AbstractCompositeFactory;
import com.ibm.ccl.soa.deploy.core.ui.composites.DmoComposite;
import com.ibm.ccl.soa.deploy.core.ui.composites.SynthDmoComposite;

/**
 * This class is DEPRECATED because it only exists as a proof-of-concept for pop-up editing of
 * capabilities. It will be highly refactored soon.
 * 
 * <p>
 * Registered through the <code>com.ibm.ccl.soa.deploy.saf.ui.uihandlers</code> extension point.
 * 
 * @author Ed Snible
 */
public class CatchallDmoUIHandler extends AbstractCompositeFactory {

	private final boolean includeConstraints;

	/**
	 * 
	 */
	public CatchallDmoUIHandler() {
		this(false);
	}

	/**
	 * @param showConstraints
	 * 
	 */
	public CatchallDmoUIHandler(boolean showConstraints) {
		includeConstraints = showConstraints;
	}

	/**
	 * @param dmo
	 * @return <code>true</code> if this instance can provide a UI handler for <code>dmo</code>
	 */
	public boolean isUIHandlerForDeployModelObject(DeployModelObject dmo) {
		return true;
	}

	public DmoComposite createControls(Composite parent, DeployModelObject editDmo,
			FormToolkit formToolkit) /* throws SAFException */{

		DmoComposite composite = new SynthDmoComposite(parent, editDmo, formToolkit,
				!includeConstraints);
		formToolkit.adapt(composite);
		return composite;
	}

	// TODO Combine with DmoSyncHelper.FieldAndStatusDec
	public static abstract class StatusField {
		private final DecoratedField df;
		private final FieldDecoration fieldDec;

		protected StatusField(DecoratedField df) {
			this.df = df;
			// We give it an original icon, so that it lays out correctly.
			fieldDec = new FieldDecoration(getDecorationImage(FieldDecorationRegistry.DEC_WARNING),
					null);

			df.addFieldDecoration(fieldDec, SWT.LEFT | SWT.BOTTOM, false);
		}

		public void setStatus(int severity, String errMsg) {
			fieldDec.setDescription(errMsg);
			fieldDec.setImage(getStatusImage(severity));
			df.updateDecoration(fieldDec);
		}

		protected static Image getDecorationImage(String key) {
			FieldDecoration originalDec = FieldDecorationRegistry.getDefault().getFieldDecoration(key);
			return originalDec != null ? originalDec.getImage() : null;
		}

		protected Image getStatusImage(int status) {
			if (status == IStatus.ERROR) {
				return getErrorDecorationImage();
			} else if (status == IStatus.WARNING) {
				return getWarningDecorationImage();
			} else if (status == IStatus.INFO) {
				return null; // getInfoDecorationImage();
			}

			// IStatus.OK, etc.
			return null;
		}

		private Image getWarningDecorationImage() {
			return getDecorationImage(FieldDecorationRegistry.DEC_WARNING);
		}

		private Image getErrorDecorationImage() {
			return getDecorationImage(FieldDecorationRegistry.DEC_ERROR);
		}

		public abstract void updateStatus();

	} // end class StatusField

} // end class CatchallCapabilityUIHandler2

