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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.RequirementExpressionUsage;
import com.ibm.ccl.soa.deploy.core.constraint.TypeConstraint;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.composites.AbstractCompositeFactory;
import com.ibm.ccl.soa.deploy.core.ui.composites.DmoComposite;
import com.ibm.ccl.soa.deploy.core.ui.properties.DmoSyncHelper;
import com.ibm.ccl.soa.deploy.core.ui.properties.DmoSyncHelperModel;
import com.ibm.ccl.soa.deploy.core.ui.properties.Messages;
import com.ibm.ccl.soa.deploy.core.validator.expression.RequirementExpressionService;

/**
 * @since 7.0
 * 
 */
public class RequirementExpressionUIHandler extends AbstractCompositeFactory {
	private static class RequirementExpressionComposite extends DmoComposite {

		public RequirementExpressionComposite(Composite parent, FormToolkit formToolkit) {
			super(parent, SWT.NONE, formToolkit);
		}

		@Override
		protected DmoSyncHelperModel createDmoSyncHelperModel() {
			return new DmoSyncHelperModel() {

				private PropertyDescriptor[] validAttributeNames;
				private PropertyDescriptor[] validInterpreters;

				@Override
				public Image getPropertyImage(EStructuralFeature property) {
					if (CorePackage.Literals.REQUIREMENT_EXPRESSION__USE == property) {
						String imageKey = null;
						switch (((RequirementExpression) dmo).getUse().getValue())
						{
						case RequirementExpressionUsage.OPTIONAL:
							imageKey = ISharedImages.IMG_USE_OPTIONAL;
							break;
						case RequirementExpressionUsage.REQUIRED:
							imageKey = ISharedImages.IMG_USE_REQUIRED;
							break;
						case RequirementExpressionUsage.PROHIBITED:
							imageKey = ISharedImages.IMG_USE_PROHIBITED;
							break;
						}
						if (imageKey != null) {
							return DeployCoreUIPlugin.getDefault().getSharedImages().getImage(imageKey);
						}
					}
					return super.getPropertyImage(property);
				}

				@Override
				public PropertyDescriptor[] getValidPropertyDescriptors(EStructuralFeature feature) {
					if (CorePackage.Literals.REQUIREMENT_EXPRESSION__ATTRIBUTE_NAME == feature) {
						return getValidAttributeNames();
					}
					if (CorePackage.Literals.REQUIREMENT_EXPRESSION__INTERPRETER == feature) {
						return getValidInterpreters();
					}
					return super.getValidPropertyDescriptors(feature);
				}

				private PropertyDescriptor[] getValidInterpreters() {
					if (validInterpreters == null) {
						String[] names = RequirementExpressionService.INSTANCE
								.getExpressionInterpreterNames();
						List<String> descriptorNames = new ArrayList<String>(names.length);
						for (int i = 0; i < names.length; i++) {
							descriptorNames.add(names[i]);
						}
						Collections.sort(descriptorNames);
						validInterpreters = new PropertyDescriptor[descriptorNames.size()];
						int i = 0;
						for (String name : descriptorNames) {
							validInterpreters[i] = new PropertyDescriptor(name, name);
							i++;
						}
					}
					return validInterpreters;
				}

				private PropertyDescriptor[] getValidAttributeNames() {
					if (validAttributeNames == null && dmo != null) {
						List<String> retVal = new LinkedList<String>();
						EClass dmoType = getDMOType((RequirementExpression) dmo);
						if (dmoType != null) {
							for (Iterator<EAttribute> it = dmoType.getEAllAttributes().iterator(); it
									.hasNext();) {
								EAttribute esf = it.next();
								if (!FeatureMapUtil.isFeatureMap(esf)) {
									retVal.add(esf.getName());
								}
							}
							Collections.sort(retVal);
							int i = 0;
							validAttributeNames = new PropertyDescriptor[retVal.size()];
							for (String name : retVal) {
								validAttributeNames[i] = new PropertyDescriptor(name, name);
								i++;
							}
						}
						if (validAttributeNames == null) {
							return new PropertyDescriptor[0];
						}
					}
					return validAttributeNames;
				}

				private EClass getDMOType(Constraint constraint) {
					if (constraint != null) {
						if (constraint instanceof TypeConstraint) {
							return ((TypeConstraint) constraint).getDmoEType();
						} else {
							DeployModelObject parent = constraint.getParent();
							if (parent != null) {
								if (parent instanceof Requirement) {
									return ((Requirement) parent).getDmoEType();
								} else if (parent instanceof Constraint) {
									return getDMOType((Constraint) parent);
								} else {
									return parent.getEObject().eClass();
								}
							}
						}
					}
					return null;
				}
			};
		}

		@Override
		protected void initializeContents(DmoSyncHelper synchHelper) {
			String emptyString = ""; //$NON-NLS-1$
			GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
			//Usage field.
			FormToolkit wf = getWidgetFactory();
			wf.createLabel(this, Messages.DetailRequirementComposite_Usage_);
			Label usageIcon = new Label(this, SWT.NONE);
			Combo usageCombo = new Combo(this, SWT.READ_ONLY);
			usageCombo.setLayoutData(gd);
			synchHelper.synchCombo(usageCombo, CorePackage.Literals.REQUIREMENT_EXPRESSION__USE,
					usageIcon, null);

			//Attribute name
			wf.createLabel(this, Messages.DetailRequirementComposite_Attribut_);
			new Label(this, SWT.NONE);
			Combo attributeCombo = new Combo(this, SWT.NONE);
			attributeCombo.setLayoutData(gd);
			synchHelper.synchCombo(attributeCombo,
					CorePackage.Literals.REQUIREMENT_EXPRESSION__ATTRIBUTE_NAME, null);

			//Interpreter
			wf.createLabel(this, Messages.NewRequirementDialog_Interprete_);
			new Label(this, SWT.NONE);
			Combo interpreterCombo = new Combo(this, SWT.READ_ONLY);
			interpreterCombo.setLayoutData(gd);
			synchHelper.synchCombo(interpreterCombo,
					CorePackage.Literals.REQUIREMENT_EXPRESSION__INTERPRETER, null);

			//Value
			wf.createLabel(this, Messages.DetailRequirementComposite_Valu_);
			new Label(this, SWT.NONE);
			Text valueText = wf.createText(this, emptyString, SWT.BORDER);
			valueText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			synchHelper.synchText(valueText, CorePackage.Literals.REQUIREMENT_EXPRESSION__VALUE, true,
					null);
		}

	};

	/**
	 * 
	 */
	public RequirementExpressionUIHandler() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.ui.composites.AbstractCompositeFactory#createControls(org.eclipse.swt.widgets.Composite,
	 *      com.ibm.ccl.soa.deploy.core.DeployModelObject, org.eclipse.ui.forms.widgets.FormToolkit)
	 */
	@Override
	public DmoComposite createControls(Composite parent, DeployModelObject editDmo, FormToolkit wf) {
		if (editDmo == null) {
			return null;
		}
		DmoComposite main = new RequirementExpressionComposite(parent, wf);
		main.setLayout(new GridLayout(3, false));
		main.setInput(editDmo);
		wf.adapt(main);
		return main;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.saf.ui.handler.AbstractDmoUIHandler#isUIHandlerForDeployModelObject(com.ibm.ccl.soa.deploy.core.DeployModelObject)
	 */
	@Override
	public boolean isUIHandlerForDeployModelObject(DeployModelObject dmo) {
		//This method needs to be removed when the UIInterfaceHandlerService supports enablements.  An
		//enablement is already defined.
		return dmo instanceof RequirementExpression;
	}
}
