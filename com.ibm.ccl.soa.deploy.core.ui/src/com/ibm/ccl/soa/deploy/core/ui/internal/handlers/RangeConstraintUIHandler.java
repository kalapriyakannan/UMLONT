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
import com.ibm.ccl.soa.deploy.core.constraint.RangeConstraint;
import com.ibm.ccl.soa.deploy.core.ui.composites.DmoComposite;
import com.ibm.ccl.soa.deploy.core.ui.properties.DmoSyncHelperModel;
import com.ibm.ccl.soa.deploy.core.ui.properties.Messages;

/**
 * SAF UI handler for a {@link MemberCardinalityConstraint}.
 * 
 * <p>
 * Registered through the <code>com.ibm.ccl.soa.deploy.saf.ui.uihandlers</code> extension point.
 * 
 * @author Ed Snible
 */
public class RangeConstraintUIHandler extends AttributeValueUIHandler {

	/**
	 * 
	 */
	public RangeConstraintUIHandler() {
		// do nothing
	}

	/**
	 * @param dmo
	 * @return <code>true</code> if this instance can provide a UI handler for <code>dmo</code>
	 */
	public boolean isUIHandlerForDeployModelObject(DeployModelObject dmo) {
		return dmo.eClass() == ConstraintPackage.eINSTANCE.getRangeConstraint();
	}

	public DmoComposite createControls(Composite parent, DeployModelObject editDmo,
			FormToolkit formToolkit) /* throws SAFException */{

		RangeConstraintValueComposite composite = new RangeConstraintValueComposite(parent,
				(RangeConstraint) editDmo, formToolkit);
		formToolkit.adapt(composite);
		//		composite.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_MAGENTA));
		return composite;
	}

	private static class RangeConstraintValueComposite extends
			AttributeValueUIHandler.AttributeValueComposite implements Adapter {

		private Combo minCombo;
		private Text minText;
		private Combo maxCombo;
		private Text maxText;

		protected RangeConstraintValueComposite(Composite parent, RangeConstraint mcc,
				FormToolkit formToolkit) {
			super(parent, mcc, formToolkit);

			setInput(mcc);
			assert formToolkit != null;
		}

		@Override
		protected List<EStructuralFeature> getExclusions() {
			List<EStructuralFeature> retVal = new LinkedList<EStructuralFeature>(super.getExclusions());
			retVal.add(ConstraintPackage.eINSTANCE.getRangeConstraint_MinValue());
			retVal.add(ConstraintPackage.eINSTANCE.getRangeConstraint_MinValueInclusive());
			retVal.add(ConstraintPackage.eINSTANCE.getRangeConstraint_MaxValue());
			retVal.add(ConstraintPackage.eINSTANCE.getRangeConstraint_MaxValueInclusive());
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

			getSynchHelper().synchCombo(minCombo, RCSyncHelperModel.fakeMinComboAttribute,
					new Label[] { minPrompt });
			getSynchHelper().synchText(minText,
					ConstraintPackage.Literals.RANGE_CONSTRAINT__MIN_VALUE, true,
					new Label[] { minPrompt });

			getSynchHelper().synchCombo(maxCombo, RCSyncHelperModel.fakeMaxComboAttribute,
					new Label[] { maxPrompt });
			getSynchHelper().synchText(maxText,
					ConstraintPackage.Literals.RANGE_CONSTRAINT__MAX_VALUE, true,
					new Label[] { maxPrompt });
		}

		@Override
		public void setInput(Object object) {
			assert object instanceof RangeConstraint;
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
			if (notification.getFeature() == ConstraintPackage.Literals.RANGE_CONSTRAINT__MIN_VALUE) {
				getSynchHelper().updateUIWithModel(RCSyncHelperModel.fakeMinComboAttribute);
			} else if (notification.getFeature() == ConstraintPackage.Literals.RANGE_CONSTRAINT__MAX_VALUE) {
				getSynchHelper().updateUIWithModel(RCSyncHelperModel.fakeMaxComboAttribute);
			}
		}

		public void setTarget(Notifier newTarget) {
			// do nothing
		}

		protected DmoSyncHelperModel createDmoSyncHelperModel() {
			RCSyncHelperModel model = new RCSyncHelperModel();
			model.addListener(this);
			return model;
		}

		private static class RCSyncHelperModel extends AttributeValueSynchHelperModel {

			private final static String NONE = Messages.GroupCardinalityConstraintUIHandler_Non_;
			private final static String LT = Messages.GroupCardinalityConstraintUIHandler_LT_;
			private final static String LTE = Messages.GroupCardinalityConstraintUIHandler_LTE_;
			private final static String GT = Messages.GroupCardinalityConstraintUIHandler_GT_;
			private final static String GTE = Messages.GroupCardinalityConstraintUIHandler_GTE_;
			private static final Object EMPTY_STRING = ""; //$NON-NLS-1$
			private static final PropertyDescriptor PD_NONE = new PropertyDescriptor(NONE, NONE);
			private static final PropertyDescriptor PD_LTE = new PropertyDescriptor(LTE, LTE);
			private static final PropertyDescriptor PD_GTE = new PropertyDescriptor(GTE, GTE);
			private static final PropertyDescriptor PD_LT = new PropertyDescriptor(LT, LT);
			private static final PropertyDescriptor PD_GT = new PropertyDescriptor(GT, GT);
			private static final EStructuralFeature fakeMinComboAttribute = EcoreFactory.eINSTANCE
					.createEAttribute();
			private static final EStructuralFeature fakeMaxComboAttribute = EcoreFactory.eINSTANCE
					.createEAttribute();
			private static final PropertyDescriptor[] minComboDescrs = new PropertyDescriptor[] {
					PD_NONE, PD_GT, PD_GTE };
			private static final PropertyDescriptor[] maxComboDescrs = new PropertyDescriptor[] {
					PD_NONE, PD_LT, PD_LTE };
			// AT 12/13/2007: no need for special values
			private static String NO_MINIMUM = ""; //$NON-NLS-1$
			private static String NO_MAXIMUM = ""; //$NON-NLS-1$

			@Override
			public PropertyDescriptor[] getValidPropertyDescriptors(EStructuralFeature esf) {
				if (esf == RCSyncHelperModel.fakeMinComboAttribute) {
					return minComboDescrs;
				} else if (esf == RCSyncHelperModel.fakeMaxComboAttribute) {
					return maxComboDescrs;
				}

				return super.getValidPropertyDescriptors(esf);
			}

			@Override
			public PropertyDescriptor getPropertyDescriptor(EStructuralFeature propertyName) {
				if (propertyName == fakeMinComboAttribute) {
					if (!isSetMin()) {
						return PD_NONE;
					}
					RangeConstraint rc = getCardinalityConstraint();
					return rc.isMinValueInclusive() ? PD_GTE : PD_GT;
				} else if (propertyName == fakeMaxComboAttribute) {
//					return isSetMax() ? PD_LTE : PD_NONE;
					if (!isSetMax()) {
						return PD_NONE;
					}
					RangeConstraint rc = getCardinalityConstraint();
					return rc.isMaxValueInclusive() ? PD_LTE : PD_LT;
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
				RangeConstraint gcc = getCardinalityConstraint();
				return gcc.getMaxValue() != null && !gcc.getMaxValue().equals(NO_MAXIMUM)
						&& gcc.getMaxValue().length() != 0;
			}

			private boolean isSetMin() {
				RangeConstraint gcc = getCardinalityConstraint();
				return gcc.getMinValue() != null && !gcc.getMinValue().equals(NO_MINIMUM)
						&& gcc.getMinValue().length() != 0;
			}

			private RangeConstraint getCardinalityConstraint() {
				return (RangeConstraint) dmo;
			}

			@Override
			protected void doSetProperty(EStructuralFeature propertyName, Object value) {
				if (propertyName == fakeMinComboAttribute) {
					if (value == NONE) {
						super.doSetProperty(ConstraintPackage.Literals.RANGE_CONSTRAINT__MIN_VALUE,
								NO_MINIMUM);
					} else if (value == GT) {
						super.doSetProperty(
								ConstraintPackage.Literals.RANGE_CONSTRAINT__MIN_VALUE_INCLUSIVE, false);
					} else if (value == GTE) {
						super.doSetProperty(
								ConstraintPackage.Literals.RANGE_CONSTRAINT__MIN_VALUE_INCLUSIVE, true);
					}
					return;
				} else if (propertyName == fakeMaxComboAttribute) {
					if (value == NONE) {
						super.doSetProperty(ConstraintPackage.Literals.RANGE_CONSTRAINT__MAX_VALUE,
								NO_MAXIMUM);
					} else if (value == LT) {
						super.doSetProperty(
								ConstraintPackage.Literals.RANGE_CONSTRAINT__MAX_VALUE_INCLUSIVE, false);
					} else if (value == LTE) {
						super.doSetProperty(
								ConstraintPackage.Literals.RANGE_CONSTRAINT__MAX_VALUE_INCLUSIVE, true);
					}
					return;
				} else if (propertyName == ConstraintPackage.Literals.RANGE_CONSTRAINT__MIN_VALUE) {
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
				} else if (propertyName == ConstraintPackage.Literals.RANGE_CONSTRAINT__MAX_VALUE) {
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

		} // end static inner class RCSyncHelperModel

	} // end static inner class RangeConstraintValueComposite

} // end class RangeConstraintUIHandler

