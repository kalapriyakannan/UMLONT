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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.ui.services.icon.IconOptions;
import org.eclipse.gmf.runtime.common.ui.services.icon.IconService;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.jface.fieldassist.DecoratedField;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.fieldassist.IControlCreator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.ibm.ccl.soa.deploy.core.AttributeMetaData;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.Stereotype;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.CapabilitySyncHelperModel;
import com.ibm.ccl.soa.deploy.core.ui.properties.DmoSyncHelper;
import com.ibm.ccl.soa.deploy.core.ui.properties.DmoSyncHelperModel;
import com.ibm.ccl.soa.deploy.core.ui.properties.Messages;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;

/**
 * A Composite able to show any Capability.
 */
public class SynthCapabilityComposite extends DmoTabbedComposite {

	final static protected List<EStructuralFeature> CORE_CAPABILITY_FIELDS = Arrays
			.asList(new EStructuralFeature[] { CorePackage.eINSTANCE.getCapability_BuildVersion(),
					CorePackage.eINSTANCE.getCapability_LinkType(),
					CorePackage.eINSTANCE.getCapability_Origin(),
					CorePackage.eINSTANCE.getDeployModelObject_Description(),
					CorePackage.eINSTANCE.getDeployModelObject_Mutable(),
					CorePackage.eINSTANCE.getDeployModelObject_Name(),
					CorePackage.eINSTANCE.getDeployModelObject_DisplayName() });

	/**
	 * An attribute on the Capabilities property section, but isn't on the Capability.
	 */
	public static final EAttribute fakeAttributeForCapContract = CorePackage.Literals.DEPLOY_MODEL_OBJECT__VISIBILITY;

	private final Capability capability;

	// TODO Factor this into parent
	private final List<StatusField> decoratedFieldsNotUnderParentalControl = new LinkedList<StatusField>();

	private DecoratedField contractCombo;

	private Label typeIcon;

	private Label typeLabel;

	private ConfigurationContract contract;

	private boolean capPublicEditable;

	private class StereoTypeListener extends ModelListener {
		@Override
		public void notifyChanged(final Notification msg) {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					safeNotify(msg);
				}
			});
		}

		private void safeNotify(Notification msg) {
			if (msg.getNotifier() instanceof Stereotype) {
				computeTypeLabel();
			} else if (msg.getNewValue() instanceof Stereotype) {
				adaptTarget((Stereotype) msg.getNewValue());
				computeTypeLabel();
			} else if (msg.getOldValue() instanceof Stereotype) {
				removeTarget((Stereotype) msg.getOldValue());
				computeTypeLabel();
			}
		}
	}

	final private ModelListener stereotypeListener = new StereoTypeListener();

	/**
	 * @param parent
	 * @param cap
	 * @param formToolkit
	 */
	public SynthCapabilityComposite(Composite parent, Capability cap, FormToolkit formToolkit) {
		super(parent, SWT.FLAT, formToolkit, false);
		setInput(cap);

		capability = cap;

		initializeContents(getSynchHelper());
	}

	@Override
	public void setInput(Object newCap) {
		if (dmo != null) {
			stereotypeListener.removeTarget(dmo);
		}
		super.setInput(newCap);

		contract = dmo.getTopology().getConfigurationContract();
		capPublicEditable = contract != null && contract.isPublicEditable(dmo);

		if (dmo != null) {
			stereotypeListener.setTarget(dmo);
		}
	}

	@Override
	public void dispose() {
		stereotypeListener.dispose();
		super.dispose();
	}

	protected List<EStructuralFeature> getExclusions() {
		return CORE_CAPABILITY_FIELDS;
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

	private ItemPropertyDescriptor getItemPropertyDescriptor(EStructuralFeature esf) {
		IItemPropertySource ips = getPropertySource();
		if (ips != null) {
			List<IItemPropertyDescriptor> descriptors = ips.getPropertyDescriptors(capability);
			for (Iterator<IItemPropertyDescriptor> it = descriptors.iterator(); it.hasNext();) {
				ItemPropertyDescriptor ipd = (ItemPropertyDescriptor) it.next();
				Object feature = ipd.getFeature(capability);
				if (feature == esf) {
					return ipd;
				}
			}
		}

		return null;
	}

	/**
	 * Use EMF.Edit to get a descriptor for each field, excluding CORE_CAPABILITY_FIELDS. Populate
	 * 'parent' with label/field for each descriptor.
	 * 
	 * @param parent
	 */
	private void addGenericControls(Composite parent, List<EStructuralFeature> synthExclusions) {

		//			Composite composite = new Composite(parent, SWT.NULL);
		//			composite.setLayoutData(new GridData(GridData.));
		//			setBackground(Display.getDefault().getSystemColor(
		//					SWT.COLOR_BLUE));

		// Handle fields of an EObject generically
		List<ItemPropertyDescriptor> fields = getFieldsExcluding(synthExclusions);
		for (Iterator<ItemPropertyDescriptor> it = fields.iterator(); it.hasNext();) {
			ItemPropertyDescriptor ipd = it.next();

			// Make the label
			Label label = createFieldDisplay(parent, ipd);

			//Filler
			new Label(parent, SWT.NONE);

			// Make the data entry
			AttributeMetaData amd = getAttributeMetaData(ipd);
			DecoratedField df = createDataEntryForDescriptor(parent, ipd, amd, label);

			// Make the visibility override indicator
			createVisibilityOverride(parent, ipd);

			// Create a second line, for passwords, for repeat entry
			if (isPassword(amd) && df.getControl() instanceof Text) {
				Label repeatPrompt = createLabel(parent,
						Messages.CatchallCapabilityUIHandler3_Re_enter_);
				//Filler
				new Label(parent, SWT.NONE);
				DecoratedField dfCopy = createNonDmoSynchedTextField(parent, SWT.PASSWORD);
				PasswordModifyListener listener = new PasswordModifyListener(df, dfCopy);

				Text textCopy = (Text) dfCopy.getControl();
				textCopy.addModifyListener(listener);
				Text textOrig = (Text) df.getControl();
				textOrig.addModifyListener(listener);
				textCopy.setText(textOrig.getText());

				decoratedFieldsNotUnderParentalControl.add(listener);

				//Filler
				new Label(parent, SWT.NONE);

				// bug 2423: labelRepeat and textCopy should be disabled when df is,
				// which means they should be 1) dependent controls or 2) explicitly ask the model
				// if the attribute is enabled.
				// 1 is hard because we haven't yet created the repeat fields when we bind
				// 2 is hard because the sync helper hides the model from us, and doesn't
				// provide an easy way to link additional dependent controls.
				// So we recalculate here, hoping we have the same info
				getSynchHelper().addDependentControl(df.getControl(), repeatPrompt);
				getSynchHelper().addDependentControl(df.getControl(), textCopy);
			}
		}

		// Handle extended attributes
		for (Iterator<ExtendedAttribute> it = dmo.getExtendedAttributes().iterator(); it.hasNext();) {
			ExtendedAttribute ea = it.next();

			// Make the label
			Label label = createFieldDisplay(parent, ea);
			//Filler
			new Label(parent, SWT.NONE);
			// Make the data entry
			AttributeMetaData amd = getAttributeMetaData(ea);
			/* DecoratedField df = */
			createDataEntryForDescriptor(parent, ea, amd, label);

			createVisibilityOverride(parent, ea.getName());

			// TODO Password support for extended attributes
		}
	}

	protected void createVisibilityOverride(Composite parent, ItemPropertyDescriptor ipd) {
		String name = null;

		Object feature = ipd.getFeature(dmo);
		if (feature instanceof EStructuralFeature) {
			EStructuralFeature esf = (EStructuralFeature) feature;
			name = esf.getName();
		}

		createVisibilityOverride(parent, name);
	}

	protected void createVisibilityOverride(Composite parent, String name) {
		Label override = createLabel(parent, ""); //$NON-NLS-1$

		// Because we can only make an attribute more public, not less public, we only
		// set an icon if the Capability itself isn't public-editable.
		if (name != null && capability.getEditTopology() != capability.getTopology()) {
			boolean propertyPublicEditable = contract != null && dmo.isPublicEditable(name);
			if (propertyPublicEditable != capPublicEditable) {
				Image image = propertyPublicEditable ? DeployCoreUIPlugin.getDefault()
						.getSharedImages().getImage(ISharedImages.IMG_CONTRACT_PUBLIC_EDITABLE)
						: DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
								ISharedImages.IMG_CONTRACT_PRIVATE);
				override.setImage(image);

				String msg = propertyPublicEditable ? com.ibm.ccl.soa.deploy.core.ui.Messages.AttributesDecorator_Public_Editable_
						: com.ibm.ccl.soa.deploy.core.ui.Messages.AttributesDecorator_Private_;
				String tooltip = com.ibm.ccl.soa.deploy.core.ui.Messages.ContractFigure_Contract_Status_
						+ " " + msg; //$NON-NLS-1$
				override.setToolTipText(tooltip);
			}
		}

		// Set the size to the size it would be if the icon were present, currently 16x16
		GridData gdVisibilityOverride = new GridData();
		gdVisibilityOverride.widthHint = DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
				ISharedImages.IMG_CONTRACT_PUBLIC_EDITABLE).getBounds().width;
		gdVisibilityOverride.heightHint = DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
				ISharedImages.IMG_CONTRACT_PUBLIC_EDITABLE).getBounds().height;
		override.setLayoutData(gdVisibilityOverride);
	}

	private DecoratedField createNonDmoSynchedTextField(Composite parent, int style) {
		DecoratedField decor = new DecoratedField(parent, SWT.BORDER | SWT.FLAT | style,
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
			List<IItemPropertyDescriptor> descriptors = ips.getPropertyDescriptors(capability);
			for (Iterator<IItemPropertyDescriptor> it = descriptors.iterator(); it.hasNext();) {
				ItemPropertyDescriptor ipd = (ItemPropertyDescriptor) it.next();
				Object feature = ipd.getFeature(capability);
				if (feature instanceof EAttribute && !exclusions.contains(feature)) {
					retVal.add(ipd);
				}
			}
		}
		return retVal;
	}

	private Label createFieldDisplay(Composite parent, ItemPropertyDescriptor ipd) {
		return createLabel(parent, getPrompt(ipd) /* , getMutable(ipd) */);
	}

	private Label createFieldDisplay(Composite parent, ExtendedAttribute ea) {
		return createLabel(parent, getPrompt(ea));
	}

	private String getPrompt(ItemPropertyDescriptor ipd) {
		if (booleanField(ipd)) {
			return ""; //$NON-NLS-1$
		}

		return DeployNLS.bind(Messages.CatchallCapabilityUIHandler3_0_, ipd
				.getDisplayName(capability));
	}

	protected boolean booleanField(ItemPropertyDescriptor ipd) {
		if (ipd.getFeature(capability) instanceof EAttribute) {
			EAttribute ea = (EAttribute) ipd.getFeature(capability);
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
		if (label == null) {
			return com.ibm.ccl.soa.deploy.core.ui.Messages.PropertyUtils_null_;
		}

		if (label.indexOf('&') < 0) {
			return label;
		}

		return label.replaceAll("&", "&&"); //$NON-NLS-1$//$NON-NLS-2$
	}

//	private String getPrompt(ExtendedAttribute ea) {
//		if (booleanField(ea)) {
//			return ""; //$NON-NLS-1$
//		}
//
//		return DeployNLS.bind(Messages.CatchallCapabilityUIHandler3_0_, ea.getName());
//	}

	private Label createLabel(String prompt) {
		return createLabel(this, prompt);
	}

	protected Label createLabel(Composite parent, String prompt) {
		Label label = getWidgetFactory().createLabel(parent, prompt, SWT.NONE);

		//			if (!mutable) {
		//				label.setEnabled(false);
		//			}

		return label;
	}

	private DecoratedField createDataEntryForDescriptor(Composite parent,
			ItemPropertyDescriptor ipd, AttributeMetaData amd, Label label) {
		if (ipd.getFeature(capability) instanceof EStructuralFeature) {
			EStructuralFeature esf = (EStructuralFeature) ipd.getFeature(capability);
			if (esf instanceof EAttribute) {
				DecoratedField decField = createDataEntryField(parent, (EAttribute) esf, amd, label);

				// createDataEntryField doesn't know about the ItemPropertyDescriptor and
				// this cannot set the checkbox name.  Set it now.
				if (decField.getControl() instanceof Button
						&& (decField.getControl().getStyle() & SWT.CHECK) != 0) {
					Button button = (Button) decField.getControl();
					button.setText(ipd.getDisplayName(capability));
				}

				return decField;
			}
		}

		// If we get here it's not an EAttribute.  Put in a layout placeholder...
		return createDataEntryField(null);

	}

	private DecoratedField createDataEntryForDescriptor(Composite parent, ExtendedAttribute ea,
			AttributeMetaData amd, Label label) {
		DecoratedField decField = createDataEntryField(parent, ea, amd, label);

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
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(capability);
		if (editingDomain instanceof AdapterFactoryEditingDomain) {
			AdapterFactoryEditingDomain afed = (AdapterFactoryEditingDomain) editingDomain;
			IItemPropertySource ips = (IItemPropertySource) afed.getAdapterFactory().adapt(capability,
					IItemPropertySource.class);
			return ips;
		}

		return null;
	}

	/**
	 * Subclasses should override if a custom model is required.
	 * 
	 * @return {@link DmoSyncHelperModel}.
	 */
	protected DmoSyncHelperModel createDmoSyncHelperModel() {
		return new CapabilitySyncHelperModel();
	}

	@Override
	protected void initializeMainContent(Composite parent, DmoSyncHelper synchHelper) {
		Composite body = addGeneralContents(parent, synchHelper, getExclusions());
		body.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	}

	@Override
	protected boolean shouldAddStereotypes() {
		return true;
	}

	/**
	 * addGeneralContents() always makes a Composite with 3 columns. The first column is for labels.
	 * The second column is for an optional icon. The third column is for the data entry field.
	 * 
	 * <p>
	 * It is possible for the caller to add additional fields into this composite rather than in its
	 * own sibling composite. This allows the general fields and the custom fields to have aligning
	 * labels.
	 * 
	 * @param parent
	 * @param synchHelper
	 * @param synthExclusions
	 * @return
	 */
	protected Composite addGeneralContents(Composite parent, DmoSyncHelper synchHelper,
			List<EStructuralFeature> synthExclusions) {
		FormToolkit wf = getWidgetFactory();
		Composite body = wf.createComposite(parent, SWT.NONE);
		body.setLayout(new GridLayout(4, false));
		String emptyString = ""; //$NON-NLS-1$

		//Caption
		Label captionLabel = wf.createLabel(body, Messages.DetailRequirementComposite_Caption_);
		new Label(body, SWT.NONE);
		createTextEntry(body, CorePackage.Literals.DEPLOY_MODEL_OBJECT__DISPLAY_NAME, SWT.NONE,
				captionLabel);
		// Visibility
		createVisibilityOverride(body, CorePackage.Literals.DEPLOY_MODEL_OBJECT__DISPLAY_NAME
				.getName());

		//Type
		wf.createLabel(body, Messages.DiagramPropertySection_TypeLabel, SWT.FLAT);
		typeIcon = wf.createLabel(body, emptyString, SWT.NONE);
		typeIcon.setLayoutData(new GridData(16, SWT.DEFAULT));
		typeLabel = wf.createLabel(body, emptyString, SWT.NONE);
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, false);
		gd.horizontalIndent = 7;
		typeLabel.setLayoutData(gd);
		typeIcon.setImage(IconService.getInstance().getIcon(new EObjectAdapter(dmo),
				IconOptions.GET_STEREOTYPE_IMAGE_FOR_ELEMENT.intValue()));
		computeTypeLabel();
		//Add listener for stereotype changes.
		synchHelper.addModelListener(new StereoTypeListener());
		//Filler
		new Label(body, SWT.NONE);

		//Contract
		Label contractLabel = getWidgetFactory().createLabel(body,
				Messages.GeneralPropertyComposite_Contract_);
		Label contractIcon = getWidgetFactory().createLabel(body, emptyString);
		contractCombo = createComboEntry(body, CorePackage.Literals.DEPLOY_MODEL_OBJECT__VISIBILITY,
				contractLabel, SWT.READ_ONLY);
		synchHelper.synchCombo((Combo) contractCombo.getControl(),
				CorePackage.Literals.DEPLOY_MODEL_OBJECT__VISIBILITY, contractIcon,
				new Control[] { contractLabel });
		//Filler
		new Label(body, SWT.NONE);

		//Link type
		Label linkLabel = createLabel(body, Messages.DetailRequirementComposite_Link_type_);
		Label linkIcon = wf.createLabel(body, emptyString, SWT.NONE);
		linkIcon.setLayoutData(new GridData(16, SWT.DEFAULT));
		DecoratedField linkTypeCombo = createComboEntry(body,
				CorePackage.Literals.CAPABILITY__LINK_TYPE, linkLabel, SWT.READ_ONLY);
		this.getSynchHelper().synchCombo((Combo) linkTypeCombo.getControl(),
				CorePackage.Literals.CAPABILITY__LINK_TYPE, linkIcon, new Label[] { linkLabel });
		//Filler
		new Label(body, SWT.NONE);

		//Add all other generic controls.
		addGenericControls(body, synthExclusions);

		return body;
	}

	@SuppressWarnings("unchecked")
	private void computeTypeLabel() {
		if (typeLabel != null && !typeLabel.isDisposed()) {
			List<Stereotype> stereotypes = ((Capability) dmo).getStereotypes();
			StringBuffer buf = null;
			if (!stereotypes.isEmpty()) {
				buf = new StringBuffer("<"); //$NON-NLS-1$
				Iterator<Stereotype> it = stereotypes.iterator();
				while (it.hasNext()) {
					buf.append(it.next().getKeyword());
					if (it.hasNext()) {
						buf.append(',');
					}
				}
				buf.append("> "); //$NON-NLS-1$
			}
			String label = PropertyUtils.getDisplayEType(dmo.eClass(), "*"); //$NON-NLS-1$
			if (buf != null) {
				label = buf.toString() + label;
			}
			typeLabel.setText(label);
		}
	}

// TODO Combine with DmoSyncHelper.FieldAndStatusDec
	static abstract private class StatusField {
		private final DecoratedField df;
		private final FieldDecoration fieldDec;

		protected StatusField(DecoratedField df) {
			this.df = df;
			// We give it an original icon, so that it lays out correctly.
			fieldDec = new FieldDecoration(getDecorationImage(FieldDecorationRegistry.DEC_WARNING),
					null);

			df.addFieldDecoration(fieldDec, SWT.LEFT | SWT.BOTTOM, false);
		}

		protected void setStatus(int severity, String errMsg) {
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

		protected abstract void updateStatus();

	} // end class StatusField

	// TODO Refactor into utility for DmoComposite
	static private class PasswordModifyListener extends StatusField implements ModifyListener {

		private final DecoratedField dfPassword;
		private final DecoratedField dfCopy;

		protected PasswordModifyListener(DecoratedField dfPassword, DecoratedField dfCopy) {
			super(dfCopy);

			this.dfPassword = dfPassword;
			assert dfPassword.getControl() instanceof Text;
			this.dfCopy = dfCopy;
		}

		public void modifyText(ModifyEvent e) {
			updateStatus();
		}

		protected void updateStatus() {
			boolean matches = getPasswordCopy().equals(getPassword());
			setStatus(matches ? IStatus.OK : IStatus.ERROR, matches ? null
					: Messages.SynthCapabilityComposite_Passwords_must_matc_);
		}

		private String getPasswordCopy() {
			Text text = (Text) dfCopy.getControl();
			return text.getText();
		}

		private String getPassword() {
			Text text = (Text) dfPassword.getControl();
			return text.getText();
		}

	}

} // end class SynthCapabilityComposite
