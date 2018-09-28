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

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.MemberCardinalityConstraint;
import com.ibm.ccl.soa.deploy.core.ui.composites.DmoComposite;
import com.ibm.ccl.soa.deploy.core.ui.composites.SynthDmoComposite;
import com.ibm.ccl.soa.deploy.core.ui.properties.DmoSyncHelperModel;
import com.ibm.ccl.soa.deploy.core.ui.properties.Messages;

// TODO switch to common CardinalityConstraintUIHandler when properties (message) files are unlocked

/**
 * SAF UI handler for a {@link MemberCardinalityConstraint}.
 * 
 * <p>
 * Registered through the <code>com.ibm.ccl.soa.deploy.saf.ui.uihandlers</code> extension point.
 * 
 * @author Bill Arnold cloned from GroupCardinalityConstraintUIHandler
 */
public class MemberCardinalityConstraintUIHandler extends AttributeValueUIHandler {

	/**
	 * 
	 */
	public MemberCardinalityConstraintUIHandler() {
		// do nothing
	}

	/**
	 * @param dmo
	 * @return <code>true</code> if this instance can provide a UI handler for <code>dmo</code>
	 */
	public boolean isUIHandlerForDeployModelObject(DeployModelObject dmo) {
		return dmo.eClass() == ConstraintPackage.eINSTANCE.getMemberCardinalityConstraint();
	}

	public DmoComposite createControls(Composite parent, DeployModelObject editDmo,
			FormToolkit formToolkit) /* throws SAFException */{

		MemberCardinalityConstraintValueComposite composite = new MemberCardinalityConstraintValueComposite(
				parent, (MemberCardinalityConstraint) editDmo, formToolkit);
		formToolkit.adapt(composite);
		//		composite.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_MAGENTA));
		return composite;
	}

	private static class MemberCardinalityConstraintValueComposite extends SynthDmoComposite
			implements Adapter {

		private Combo minCombo;
		private Text minText;
		private Combo maxCombo;
		private Text maxText;

		protected MemberCardinalityConstraintValueComposite(Composite parent,
				MemberCardinalityConstraint mcc, FormToolkit formToolkit) {
			super(parent, mcc, formToolkit);

			setInput(mcc);
//			memberConstraint = mcc;
			assert formToolkit != null;
		}

		@Override
		protected List<EStructuralFeature> getExclusions() {
			List<EStructuralFeature> retVal = new LinkedList<EStructuralFeature>(super.getExclusions());
			retVal.add(ConstraintPackage.eINSTANCE.getMemberCardinalityConstraint_MinValue());
			retVal.add(ConstraintPackage.eINSTANCE.getMemberCardinalityConstraint_MaxValue());
			return retVal;
		}

		protected void synthFields(List<EStructuralFeature> synthExclusions) {
			super.synthFields(synthExclusions);

			addMinMaxSection();
		}

		private void addMinMaxSection() {
			Composite minMax = getWidgetFactory().createComposite(this, SWT.FLAT);
			minMax.setLayout(new GridLayout(3, false));
			GridData gdMinMax = new GridData(SWT.FILL, SWT.FILL, true, true);
			gdMinMax.horizontalSpan = 2;
			minMax.setLayoutData(gdMinMax);

			Label minPrompt = getWidgetFactory().createLabel(minMax,
					Messages.GroupCardinalityConstraintUIHandler_Min_);
			minCombo = new Combo(minMax, SWT.READ_ONLY);
			minText = new Text(minMax, SWT.BORDER);
			minText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

			Label maxPrompt = getWidgetFactory().createLabel(minMax,
					Messages.GroupCardinalityConstraintUIHandler_Max_);
			maxCombo = new Combo(minMax, SWT.READ_ONLY);
			maxText = new Text(minMax, SWT.BORDER);
			maxText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

			getSynchHelper().synchCombo(minCombo, MCCSyncHelperModel.fakeMinComboAttribute,
					new Label[] { minPrompt });
			getSynchHelper().synchText(minText,
					ConstraintPackage.Literals.MEMBER_CARDINALITY_CONSTRAINT__MIN_VALUE, true,
					new Label[] { minPrompt });

			getSynchHelper().synchCombo(maxCombo, MCCSyncHelperModel.fakeMaxComboAttribute,
					new Label[] { maxPrompt });
			getSynchHelper().synchText(maxText,
					ConstraintPackage.Literals.MEMBER_CARDINALITY_CONSTRAINT__MAX_VALUE, true,
					new Label[] { maxPrompt });
		}

		@Override
		public void setInput(Object object) {
			assert object instanceof MemberCardinalityConstraint;
			super.setInput(object);
		}

		public Notifier getTarget() {
			return null;
		}

		public boolean isAdapterForType(Object type) {
			return false;
		}

		public void notifyChanged(Notification notification) {
			// DmoSyncHelper doesn't let us sync two controls to changes in the same feature,
			// so hook the change ourself
			if (notification.getFeature() == ConstraintPackage.Literals.MEMBER_CARDINALITY_CONSTRAINT__MIN_VALUE) {
				getSynchHelper().updateUIWithModel(MCCSyncHelperModel.fakeMinComboAttribute);
			} else if (notification.getFeature() == ConstraintPackage.Literals.MEMBER_CARDINALITY_CONSTRAINT__MAX_VALUE) {
				getSynchHelper().updateUIWithModel(MCCSyncHelperModel.fakeMaxComboAttribute);
			}
		}

		public void setTarget(Notifier newTarget) {
			// do nothing
		}

		protected DmoSyncHelperModel createDmoSyncHelperModel() {
			MCCSyncHelperModel model = new MCCSyncHelperModel();
			model.addListener(this);
			return model;
		}

		private static class MCCSyncHelperModel extends DmoSyncHelperModel {

			private final static String NONE = Messages.GroupCardinalityConstraintUIHandler_Non_;
//			private final static String LT = "<";
			private final static String LTE = Messages.GroupCardinalityConstraintUIHandler_LTE_;
//			private final static String GT = ">";
			private final static String GTE = Messages.GroupCardinalityConstraintUIHandler_GTE_;
			private static final Object EMPTY_STRING = ""; //$NON-NLS-1$
			private static final PropertyDescriptor PD_NONE = new PropertyDescriptor(NONE, NONE);
			private static final PropertyDescriptor PD_LTE = new PropertyDescriptor(LTE, LTE);
			private static final PropertyDescriptor PD_GTE = new PropertyDescriptor(GTE, GTE);
			private static final EStructuralFeature fakeMinComboAttribute = EcoreFactory.eINSTANCE
					.createEAttribute();
			private static final EStructuralFeature fakeMaxComboAttribute = EcoreFactory.eINSTANCE
					.createEAttribute();
			private static final PropertyDescriptor[] minComboDescrs = new PropertyDescriptor[] {
					PD_NONE, PD_GTE };
			private static final PropertyDescriptor[] maxComboDescrs = new PropertyDescriptor[] {
					PD_NONE, PD_LTE };
			private static String NO_MINIMUM = "0"; //$NON-NLS-1$
			private static String NO_MAXIMUM = "unbounded"; //$NON-NLS-1$

			@Override
			public PropertyDescriptor[] getValidPropertyDescriptors(EStructuralFeature esf) {
				if (esf == MCCSyncHelperModel.fakeMinComboAttribute) {
					return minComboDescrs;
				} else if (esf == MCCSyncHelperModel.fakeMaxComboAttribute) {
					return maxComboDescrs;
				}

				return super.getValidPropertyDescriptors(esf);
			}

			@Override
			public PropertyDescriptor getPropertyDescriptor(EStructuralFeature propertyName) {
				if (propertyName == fakeMinComboAttribute) {
					return isSetMin() ? PD_GTE : PD_NONE;
				} else if (propertyName == fakeMaxComboAttribute) {
					return isSetMax() ? PD_LTE : PD_NONE;
				}

				return super.getPropertyDescriptor(propertyName);
			}

			public Object getProperty(EStructuralFeature propertyName) {
				if (propertyName == ConstraintPackage.Literals.MEMBER_CARDINALITY_CONSTRAINT__MIN_VALUE) {
					return isSetMin() ? super.getProperty(propertyName) : EMPTY_STRING;
				} else if (propertyName == ConstraintPackage.Literals.MEMBER_CARDINALITY_CONSTRAINT__MAX_VALUE) {
					return isSetMax() ? super.getProperty(propertyName) : EMPTY_STRING;
				}

				return super.getProperty(propertyName);
			}

			private boolean isSetMax() {
				MemberCardinalityConstraint gcc = getCardinalityConstraint();
				return gcc.getMaxValue() != null && !gcc.getMaxValue().equals(NO_MAXIMUM)
						&& gcc.getMaxValue().length() != 0;
			}

			private boolean isSetMin() {
				MemberCardinalityConstraint gcc = getCardinalityConstraint();
				return gcc.getMinValue() != null && !gcc.getMinValue().equals(NO_MINIMUM)
						&& gcc.getMinValue().length() != 0;
			}

			private MemberCardinalityConstraint getCardinalityConstraint() {
				return (MemberCardinalityConstraint) dmo;
			}

			@Override
			protected void doSetProperty(EStructuralFeature propertyName, Object value) {
				if (propertyName == fakeMinComboAttribute) {
					if (value == NONE) {
						super.doSetProperty(
								ConstraintPackage.Literals.MEMBER_CARDINALITY_CONSTRAINT__MIN_VALUE,
								NO_MINIMUM);
					}
					return;
				} else if (propertyName == fakeMaxComboAttribute) {
					if (value == NONE) {
						super.doSetProperty(
								ConstraintPackage.Literals.MEMBER_CARDINALITY_CONSTRAINT__MAX_VALUE,
								NO_MAXIMUM);
					}
					return;
				} else if (propertyName == ConstraintPackage.Literals.MEMBER_CARDINALITY_CONSTRAINT__MIN_VALUE) {
					if (value instanceof String) {
						String sval = (String) value;
						if (sval.equals(NO_MINIMUM) || sval.length() == 0) {
							super.doSetProperty(propertyName, NO_MINIMUM);
							return;
						} else {
							super.doSetProperty(propertyName, value);
							return;
						}
					}
				} else if (propertyName == ConstraintPackage.Literals.MEMBER_CARDINALITY_CONSTRAINT__MAX_VALUE) {
					if (value instanceof String) {
						String sval = (String) value;
						if (sval.equals(NO_MAXIMUM) || sval.length() == 0) {
							super.doSetProperty(propertyName, NO_MAXIMUM);
							return;
						} else {
							super.doSetProperty(propertyName, value);
							return;
						}
					}
				}

				super.doSetProperty(propertyName, value);
			}

		} // end static inner class MCCSyncHelperModel

	} // end static inner class MemberCardinalityConstraintValueComposite

} // end class MemberCardinalityConstraintUIHandler

