/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.composites;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.fieldassist.DecoratedField;
import org.eclipse.jface.fieldassist.IControlCreator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.ibm.ccl.soa.deploy.core.Artifact;
import com.ibm.ccl.soa.deploy.core.AttributeMetaData;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.ui.handlers.CatchallDmoUIHandler;
import com.ibm.ccl.soa.deploy.core.ui.handlers.CatchallDmoUIHandler.StatusField;
import com.ibm.ccl.soa.deploy.core.ui.properties.DmoSyncHelper;
import com.ibm.ccl.soa.deploy.core.ui.properties.Messages;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;

/**
 * <p>
 * Note: PopupDialogs are usually drawn in <code>
 * Display.getSystemColor(SWT.COLOR_INFO_BACKGROUND)
 * </code>.
 * 
 * @see PopupDialog#applyColors
 * @see CatchallDmoUIHandler
 * 
 * @author Ed Snible
 */
public class SynthDmoComposite extends DmoComposite {

	final static protected List<EStructuralFeature> CORE_DMO_FIELDS = Collections
			.unmodifiableList(Arrays.asList(new EStructuralFeature[] {
					CorePackage.Literals.CAPABILITY__BUILD_VERSION,
					CorePackage.Literals.DEPLOY_MODEL_OBJECT__DESCRIPTION,
					CorePackage.Literals.DEPLOY_MODEL_OBJECT__MUTABLE,
					CorePackage.Literals.DEPLOY_MODEL_OBJECT__NAME,
					CorePackage.Literals.DEPLOY_MODEL_OBJECT__DISPLAY_NAME }));

	// TODO Factor this into parent
	private final List<StatusField> decoratedFieldsNotUnderParentalControl = new LinkedList<StatusField>();

	/**
	 * This constructor is currently used for {@link Constraint}s
	 * 
	 * @param parent
	 * @param dmObject
	 * @param formToolkit
	 */
	public SynthDmoComposite(Composite parent, DeployModelObject dmObject, FormToolkit formToolkit) {
		this(parent, dmObject, formToolkit, true);
	}

	/**
	 * This constructor is currently used for {@link Artifact}s.
	 * 
	 * @param parent
	 * @param dmObject
	 * @param formToolkit
	 * @param suppressConstraints
	 */
	public SynthDmoComposite(Composite parent, DeployModelObject dmObject, FormToolkit formToolkit,
			boolean suppressConstraints) {
		super(parent, SWT.FLAT, formToolkit, false);
		setInput(dmObject);
		dmo = dmObject;
		initializeContents(getSynchHelper());

//		if (!suppressConstraints) {
//			addConstraintSection(this, 2, floating());
//		}
	}

	@Override
	protected void initializeContents(DmoSyncHelper synchHelper) {
		setLayout(new GridLayout(2, false));
		synthFields(getExclusions());

	}

	protected void synthFields(List<EStructuralFeature> synthExclusions) {
		addGenericSection(synthExclusions);
	}

	protected List<EStructuralFeature> getExclusions() {
		return CORE_DMO_FIELDS;
	}

	@Override
	public void aboutToBeShown() {
		super.aboutToBeShown();

		for (Iterator<StatusField> it = decoratedFieldsNotUnderParentalControl.iterator(); it
				.hasNext();) {
			StatusField sf = it.next();
			sf.updateStatus();
		}
	}

	/**
	 * Use EMF.Edit to get a descriptor for each field, excluding CORE_CAPABILITY_FIELDS. Populate
	 * 'parent' with label/field for each descriptor.
	 * 
	 * @param parent
	 */
	protected void addGenericSection(List<EStructuralFeature> exclusions) {

		//			Composite composite = new Composite(parent, SWT.NULL);
		//			composite.setLayoutData(new GridData(GridData.));
		//			setBackground(Display.getDefault().getSystemColor(
		//					SWT.COLOR_BLUE));

		//Caption
		Label captionLabel = createLabel(Messages.DetailRequirementComposite_Caption_);
		createTextEntry(this, CorePackage.Literals.DEPLOY_MODEL_OBJECT__DISPLAY_NAME, SWT.NONE,
				captionLabel);

		// Handle fields of an EObject generically
		List<ItemPropertyDescriptor> fields = getFieldsExcluding(exclusions);
		for (Iterator<ItemPropertyDescriptor> it = fields.iterator(); it.hasNext();) {
			ItemPropertyDescriptor ipd = it.next();

			// Make the label
			Label label = createFieldDisplay(ipd);
			label.setLayoutData(new GridData(SWT.BEGINNING, SWT.BEGINNING, false, false));

			// Make the data entry
			AttributeMetaData amd = getAttributeMetaData(ipd);
			DecoratedField df = createDataEntryForDescriptor(ipd, amd, label);

			// Create a second line, for passwords, for repeat entry
			if (isPassword(amd)) {
				Label repeatPrompt = createLabel(Messages.CatchallCapabilityUIHandler3_Re_enter_);

				DecoratedField dfCopy = createNonDmoSynchedTextField(SWT.PASSWORD);
				PasswordModifyListener listener = new PasswordModifyListener(df, dfCopy);

				Text textCopy = (Text) dfCopy.getControl();
				textCopy.addModifyListener(listener);
				Text textOrig = (Text) df.getControl();
				textOrig.addModifyListener(listener);
				textCopy.setText(textOrig.getText());

				decoratedFieldsNotUnderParentalControl.add(listener);

				getSynchHelper().addDependentControl(df.getControl(), repeatPrompt);
				getSynchHelper().addDependentControl(df.getControl(), textCopy);
			}
		}

		// Handle extended attributes
		for (Iterator<ExtendedAttribute> it = dmo.getExtendedAttributes().iterator(); it.hasNext();) {
			ExtendedAttribute ea = it.next();

			// Make the label
			Label label = createFieldDisplay(ea);

			// Make the data entry
			AttributeMetaData amd = getAttributeMetaData(ea);
			/* DecoratedField df = */
			createDataEntryForDescriptor(ea, amd, label);

			// TODO Password support for extended attributes
		}
	}

	private DecoratedField createNonDmoSynchedTextField(int style) {
		DecoratedField decor = new DecoratedField(this, SWT.BORDER | SWT.FLAT | style,
				getTextControlCreator());

		decor.getLayoutControl().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		//			FieldDecoration fieldDec = new FieldDecoration(getDecorationImage(FieldDecorationRegistry.DEC_WARNING), null);
		//			decor.addFieldDecoration(fieldDec, SWT.LEFT|SWT.BOTTOM, false);

		return decor;
	}

	private AttributeMetaData getAttributeMetaData(ItemPropertyDescriptor ipd) {
		if (ipd.getFeature(dmo) instanceof EStructuralFeature) {
			return getAttributeMetaData((EStructuralFeature) ipd.getFeature(dmo));
		}

		return null;
	}

	private List<ItemPropertyDescriptor> getFieldsExcluding(List<EStructuralFeature> exclusions) {
		List<ItemPropertyDescriptor> retVal = new LinkedList<ItemPropertyDescriptor>();
		IItemPropertySource ips = getPropertySource();
		if (ips != null) {
			List<IItemPropertyDescriptor> descriptors = ips.getPropertyDescriptors(dmo);
			for (Iterator<IItemPropertyDescriptor> it = descriptors.iterator(); it.hasNext();) {
				ItemPropertyDescriptor ipd = (ItemPropertyDescriptor) it.next();
				Object feature = ipd.getFeature(dmo);
				if (feature instanceof EAttribute && !exclusions.contains(feature)) {
					retVal.add(ipd);
				}
			}
		}
		return retVal;
	}

	private Label createFieldDisplay(ItemPropertyDescriptor ipd) {
		return createLabel(getPrompt(ipd) /* , getMutable(ipd) */);
	}

	private Label createFieldDisplay(ExtendedAttribute ea) {
		return createLabel(getPrompt(ea));
	}

	private String getPrompt(ItemPropertyDescriptor ipd) {
		if (booleanField(ipd)) {
			return ""; //$NON-NLS-1$
		}

		return DeployNLS.bind(Messages.CatchallCapabilityUIHandler3_0_, ipd.getDisplayName(dmo));
	}

	protected boolean booleanField(ItemPropertyDescriptor ipd) {
		if (ipd.getFeature(dmo) instanceof EAttribute) {
			EAttribute ea = (EAttribute) ipd.getFeature(dmo);
			return booleanField(ea);
		}

		return false;
	}

	protected String getPrompt(ExtendedAttribute ea) {
		if (booleanField(ea)) {
			return ""; //$NON-NLS-1$
		}

		return DeployNLS.bind(Messages.CatchallCapabilityUIHandler3_0_, canonicalizeLabel(DeployNLS
				.getName(ea)));
	}

	/**
	 * Return value suitable for SWT Label by escaping ampersands
	 */
	protected String canonicalizeLabel(String label) {
		if (label.indexOf('&') < 0) {
			return label;
		}

		return label.replaceAll("&", "&&"); //$NON-NLS-1$//$NON-NLS-2$
	}

	protected Label createLabel(String prompt) {
		Label label = getWidgetFactory().createLabel(this, prompt, SWT.RIGHT);

		//			if (!mutable) {
		//				label.setEnabled(false);
		//			}

		return label;
	}

	private DecoratedField createDataEntryForDescriptor(ItemPropertyDescriptor ipd,
			AttributeMetaData amd, Label label) {
		if (ipd.getFeature(dmo) instanceof EStructuralFeature) {
			EStructuralFeature esf = (EStructuralFeature) ipd.getFeature(dmo);
			if (esf instanceof EAttribute) {
				DecoratedField decField = createDataEntryField(this, (EAttribute) esf, amd, label);

				// createDataEntryField doesn't know about the ItemPropertyDescriptor and
				// this cannot set the checkbox name.  Set it now.
				if (decField.getControl() instanceof Button
						&& (decField.getControl().getStyle() & SWT.CHECK) != 0) {
					Button button = (Button) decField.getControl();
					button.setText(ipd.getDisplayName(dmo));
				}

				return decField;
			}
		}

		// If we get here it's not an EAttribute.  Put in a layout placeholder...
		return createDataEntryField(null);

	}

	private DecoratedField createDataEntryForDescriptor(ExtendedAttribute ea, AttributeMetaData amd,
			Label label) {
		DecoratedField decField = createDataEntryField(this, ea, amd, label);

		if (decField.getControl() instanceof Button) {
			Button button = (Button) decField.getControl();
			button.setText(ea.getName());
		}

		return decField;
	}

	// If the Capability is non-mutable, create read-only
	protected IControlCreator getTextControlCreator() {
		return new IControlCreator() {

			public Control createControl(Composite parent, int style) {
				Text retVal = getWidgetFactory().createText(parent, "", style/* |mutabilityStyle */); //$NON-NLS-1$
				//					retVal.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
				return retVal;
			}
		};
	}

	/**
	 * Get the EMF.Edit ItemPropertySource for the {@link DeployModelObject}.
	 * 
	 * @return an EMF.Edit descriptor with useful stuff like translated display name and description
	 */
	protected IItemPropertySource getPropertySource() {
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(dmo);
		if (editingDomain instanceof AdapterFactoryEditingDomain) {
			AdapterFactoryEditingDomain afed = (AdapterFactoryEditingDomain) editingDomain;
			IItemPropertySource ips = (IItemPropertySource) afed.getAdapterFactory().adapt(dmo,
					IItemPropertySource.class);
			return ips;
		}

		return null;
	}

}
