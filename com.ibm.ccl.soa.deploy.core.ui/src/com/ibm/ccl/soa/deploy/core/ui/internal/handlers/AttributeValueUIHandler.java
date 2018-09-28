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
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.constraint.AttributeValueConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.constraint.RangeConstraint;
import com.ibm.ccl.soa.deploy.core.ui.composites.AbstractCompositeFactory;
import com.ibm.ccl.soa.deploy.core.ui.composites.DmoComposite;
import com.ibm.ccl.soa.deploy.core.ui.composites.SynthDmoComposite;
import com.ibm.ccl.soa.deploy.core.ui.properties.DmoSyncHelperModel;
import com.ibm.ccl.soa.deploy.core.ui.properties.Messages;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;

/**
 * SAF UI handler for a {@link RangeConstraint}.
 * 
 * <p>
 * Registered through the <code>com.ibm.ccl.soa.deploy.saf.ui.uihandlers</code> extension point.
 * 
 * @author Ed Snible
 */
public class AttributeValueUIHandler extends AbstractCompositeFactory {

	/**
	 * 
	 */
	public AttributeValueUIHandler() {
		// do nothing
	}

	/**
	 * @param dmo
	 * @return <code>true</code> if this instance can provide a UI handler for <code>dmo</code>
	 */
	public boolean isUIHandlerForDeployModelObject(DeployModelObject dmo) {
		//		return dmo instanceof AttributeValueConstraint;
		return dmo.eClass() == ConstraintPackage.eINSTANCE.getExclusionConstraint()
//				|| dmo.eClass() == ConstraintPackage.eINSTANCE.getRangeConstraint()
				|| dmo.eClass() == ConstraintPackage.eINSTANCE.getVersionConstraint()
				|| dmo.eClass() == ConstraintPackage.eINSTANCE.getEqualsConstraint()
				|| dmo.eClass() == ConstraintPackage.eINSTANCE.getAttributeDefinedConstraint();
	}

	public DmoComposite createControls(Composite parent, DeployModelObject editDmo,
			FormToolkit formToolkit) /* throws SAFException */{

		DmoComposite composite = new AttributeValueComposite(parent,
				(AttributeValueConstraint) editDmo, formToolkit);
		formToolkit.adapt(composite);
		//		composite.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_MAGENTA));
		return composite;
	}

	static class AttributeValueComposite extends SynthDmoComposite {

		protected AttributeValueComposite(Composite parent, AttributeValueConstraint avc,
				FormToolkit formToolkit) {
			super(parent, avc, formToolkit);
			setInput(avc);
		}

		protected void synthFields(List<EStructuralFeature> synthExclusions) {
			addAttributeNameSection();
			addGenericSection(synthExclusions);
		}

		protected List<EStructuralFeature> getExclusions() {
			List<EStructuralFeature> retVal = new LinkedList<EStructuralFeature>(CORE_DMO_FIELDS);
			retVal.add(ConstraintPackage.eINSTANCE.getAttributeValueConstraint_AttributeName());
			return retVal;
		}

		/** 
		 */
		private void addAttributeNameSection() {

			Label l = createLabel(Messages.DetailRequirementComposite_Attribut_);
			createComboEntry(this,
					ConstraintPackage.Literals.ATTRIBUTE_VALUE_CONSTRAINT__ATTRIBUTE_NAME, l);
		}

		/**
		 * Subclasses should override if a custom model is required.
		 * 
		 * @return {@link DmoSyncHelperModel}.
		 */
		protected DmoSyncHelperModel createDmoSyncHelperModel() {
			return new AttributeValueSynchHelperModel();
		}

		protected static class AttributeValueSynchHelperModel extends DmoSyncHelperModel {

			private Map<String, PropertyDescriptor> attrNameToPD;

			protected AttributeValueSynchHelperModel() {
				// do nothing
			}

			@Override
			public void setInput(DeployModelObject input) {
				super.setInput(input);

				Constraint constraint = (Constraint) input;
//				DeployModelObject parent = (DeployModelObject) constraint.eContainer();
				DeployModelObject context = ConstraintUtil.getExpectedContext(constraint);
				EClass clazz = ConstraintUtil.getExpectedContextDmoType(constraint);

				attrNameToPD = new HashMap<String, PropertyDescriptor>();

				// Add all ESFs
				IItemPropertySource iips = PropertyUtils.getPropertySource(context);
				for (EAttribute ea : clazz.getEAllAttributes()) {
					if (suitableAttribute(ea)) {
						ItemPropertyDescriptor ipd = PropertyUtils.getItemPropertyDescriptor(iips,
								context, ea);
						String displayName = ipd != null ? ipd.getDisplayName(context) : ea.getName();
						attrNameToPD.put(ea.getName(), new PropertyDescriptor(displayName, ea.getName()));
					}
				}

				// Add all ExtendedAttributes
				for (ExtendedAttribute ea : (List<ExtendedAttribute>) context.getExtendedAttributes()) {
					attrNameToPD.put(ea.getName(), new PropertyDescriptor(ea.getName(), ea.getName()));
				}
				String currentAttributeName = null;
				if (ConstraintPackage.Literals.ATTRIBUTE_VALUE_CONSTRAINT.isSuperTypeOf(constraint
						.getEObject().eClass())) {
					currentAttributeName = (String) constraint
							.eGet(ConstraintPackage.Literals.ATTRIBUTE_VALUE_CONSTRAINT__ATTRIBUTE_NAME);
				}
				if (currentAttributeName != null && !attrNameToPD.containsKey(currentAttributeName)) {
					attrNameToPD.put(currentAttributeName, new PropertyDescriptor(currentAttributeName,
							currentAttributeName));
				}

			}

			@Override
			public PropertyDescriptor[] getValidPropertyDescriptors(EStructuralFeature esf) {
				if (esf == ConstraintPackage.Literals.ATTRIBUTE_VALUE_CONSTRAINT__ATTRIBUTE_NAME) {

					return getAttributeNames();
				}

				return super.getValidPropertyDescriptors(esf);
			}

			private PropertyDescriptor[] getAttributeNames() {

				ArrayList<String> attrNamesAsString = new ArrayList<String>();
				for (String str : attrNameToPD.keySet()) {
					attrNamesAsString.add(str);
				}
				Collections.sort(attrNamesAsString);
				PropertyDescriptor[] attrNamesAsPD = new PropertyDescriptor[attrNamesAsString.size()];
				int i = 0;
				for (String name : attrNamesAsString) {
					attrNamesAsPD[i] = attrNameToPD.get(name);
					i++;
				}
				return attrNamesAsPD;
			}

			@Override
			public PropertyDescriptor getPropertyDescriptor(EStructuralFeature esf) {
				if (esf == ConstraintPackage.Literals.ATTRIBUTE_VALUE_CONSTRAINT__ATTRIBUTE_NAME) {
					AttributeValueConstraint avc = (AttributeValueConstraint) dmo;
					PropertyDescriptor pd = attrNameToPD.get(avc.getAttributeName());
					return pd != null ? pd : new PropertyDescriptor("", ""); //$NON-NLS-2$ //$NON-NLS-1$;
				}

				return super.getPropertyDescriptor(esf);
			}

			private boolean suitableAttribute(EStructuralFeature esf) {
				// Don't use attributes that are feature maps.
				if (FeatureMapUtil.isFeatureMap(esf)) {
					return false;
				}

				// According to https://cs.opensource.ibm.com/bugzilla/show_bug.cgi?id=12483
				// we must include "single valued EReferences"
				if (esf.getUpperBound() != 1) {
					return false;
				}

				return true;
			}

		} // end static inner class AttributeValueSynchHelperModel

	} // end static inner class AttributeValueComposite

} // end class ScriptUIHandler

