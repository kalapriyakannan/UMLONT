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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.constraint.CollocationConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.ui.composites.DmoComposite;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.composites.SynthDmoComposite;
import com.ibm.ccl.soa.deploy.core.ui.properties.Messages;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;

/**
 * SAF UI handler for a {@link CollocationConstraint}.
 * 
 * <p>
 * Registered through the <code>com.ibm.ccl.soa.deploy.saf.ui.uihandlers</code> extension point.
 * 
 * @author Ed Snible
 * @see TypeConstraintUIHandler
 */
public class CollocationConstraintUIHandler extends AttributeValueUIHandler {

	private static class CollocationConstraintBrowseDialog extends ElementListSelectionDialog {

		public CollocationConstraintBrowseDialog(Shell parent, ILabelProvider renderer) {
			super(parent, renderer);
		}

		protected Control createDialogArea(Composite parent) {
			PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
					IDeployHelpContextIds.TOPOLOGY_COLLOCATION_CONSTRAINT_BROWSE);
			return super.createDialogArea(parent);
		}

	}

	/**
	 * 
	 */
	public CollocationConstraintUIHandler() {
		// do nothing
	}

	/**
	 * @param dmo
	 * @return <code>true</code> if this instance can provide a UI handler for <code>dmo</code>
	 */
	public boolean isUIHandlerForDeployModelObject(DeployModelObject dmo) {
		return dmo.eClass() == ConstraintPackage.Literals.COLLOCATION_CONSTRAINT;
	}

	public DmoComposite createControls(Composite parent, DeployModelObject editDmo,
			FormToolkit formToolkit) /* throws SAFException */{

		CollocationConstraintValueComposite composite = new CollocationConstraintValueComposite(
				parent, (CollocationConstraint) editDmo, formToolkit);
		formToolkit.adapt(composite);
		return composite;
	}

	/**
	 * Constraint for handling Dmos with a CapabilityType field
	 */
	public static class CollocationConstraintValueComposite extends SynthDmoComposite {

		private CollocationConstraint collocationConstraint;
		private Text textDmoType;

		protected CollocationConstraintValueComposite(Composite parent, CollocationConstraint cc,
				FormToolkit formToolkit) {
			super(parent, cc, formToolkit);

			setInput(cc);
			collocationConstraint = cc;
		}

		protected void synthFields(List<EStructuralFeature> synthExclusions) {
			super.synthFields(synthExclusions);

			addDmoTypeSection();
		}

		@Override
		protected List<EStructuralFeature> getExclusions() {
			List<EStructuralFeature> retVal = new LinkedList<EStructuralFeature>(super.getExclusions());
			retVal.add(ConstraintPackage.eINSTANCE.getCollocationConstraint_CapabilityType());
			return retVal;
		}

		/**
		 * Type: [read-only] [browse...]
		 */
		private void addDmoTypeSection() {
//			Composite comp = getWidgetFactory().createComposite(this);
//			GridData gdComp = new GridData();
//			gdComp.horizontalSpan = 2;
//			comp.setLayoutData(gdComp);
//			comp.setLayout(new GridLayout(3, false));

			Label label = getWidgetFactory().createLabel(this,
					Messages.CollocationConstraintUIHandler_Cap_Type_);

			Composite comp = getWidgetFactory().createComposite(this);
			comp.setLayout(new GridLayout(2, false));
			comp.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

			// We cannot create a DecoratedField for dmoType, because it is a QName.  The Sync Helper
			// and value converter aren't able to deal with SWT Text fields editing QNames (as of M6).
//			DecoratedField df = createTextEntry(comp,
//					ConstraintPackage.Literals.TYPE_CONSTRAINT__DMO_TYPE, SWT.READ_ONLY, label);
			textDmoType = getWidgetFactory().createText(comp, "", SWT.READ_ONLY); //$NON-NLS-1$
			textDmoType.setText(PropertyUtils.getDisplayEType(collocationConstraint
					.getCapabilityEType(), "*")); //$NON-NLS-1$
			GridData gdDmoType = new GridData(SWT.FILL, SWT.CENTER, true, false);
			gdDmoType.widthHint = 200;
			textDmoType.setLayoutData(gdDmoType);

			Button buttonBrowse = getWidgetFactory().createButton(comp,
					Messages.TypeConstraintUIHandler_Browse_, SWT.PUSH);
			buttonBrowse.addSelectionListener(new SelectionAdapter() {

				public void widgetSelected(SelectionEvent e) {
					browse();
				}
			});

			// Disable the button when the field is disabled
//			textDmoType = (Text) df.getControl();
//			getSynchHelper().synchText(textDmoType,
//					ConstraintPackage.Literals.TYPE_CONSTRAINT__DMO_TYPE, true,
//					new Control[] { label, buttonBrowse });

			if (!PropertyUtils.isEditable(collocationConstraint,
					ConstraintPackage.Literals.COLLOCATION_CONSTRAINT__CAPABILITY_TYPE)) {
				label.setEnabled(false);
				buttonBrowse.setEnabled(false);
			}
		}

		protected void browse() {
			ElementListSelectionDialog elsd = new CollocationConstraintBrowseDialog(getShell(),
					PropertyUtils.getSoaLabelProvider());
			elsd.setTitle(Messages.TypeConstraintUIHandler_Set_Constraint_Match_Typ_);
			List<String> elements = new ArrayList<String>();
			elements.addAll(PropertyUtils.getCapTypeNames());
//			elements.addAll(PropertyUtils.getUnitTypeNames());
			elsd.setElements(elements.toArray());
			if (elsd.open() == Window.OK) {
				String ecName = (String) elsd.getFirstResult();
				final EClass ec = PropertyUtils.getETypeFromName(ecName);
				String msg = Messages.TypeConstraintUIHandler_Set_Constraint_Match_Typ_;
				PropertyUtils.executeWithUndo(collocationConstraint, msg, new Runnable() {

					public void run() {
						collocationConstraint.setCapabilityEType(ec);
					}
				});

//				textDmoType.setText(typeConstraint.getDmoType().toString());
				textDmoType.setText(PropertyUtils.getDisplayEType(ec, "*")); //$NON-NLS-1$
			}
		}

		@Override
		public void setInput(Object object) {
			assert object instanceof CollocationConstraint;
			super.setInput(object);
			collocationConstraint = (CollocationConstraint) object;
//			mutable = DeployModelObjectUtil.isMutable(typeConstraint);
		}

	} // end static inner class TypeConstraintValueComposite

} // end class CollocationConstraintUIHandler

