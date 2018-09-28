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

import java.math.BigInteger;

import javax.xml.namespace.QName;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditDomain;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.fieldassist.DecoratedField;
import org.eclipse.jface.fieldassist.IControlCreator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.part.PageBook;

import com.ibm.ccl.soa.deploy.core.AttributeMetaData;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.handlers.CatchallDmoUIHandler;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.PopupCloserListener;
import com.ibm.ccl.soa.deploy.core.ui.properties.DmoSyncHelper;
import com.ibm.ccl.soa.deploy.core.ui.properties.DmoSyncHelperModel;
import com.ibm.ccl.soa.deploy.core.ui.properties.Messages;

/**
 * A Composite with the ability to synchronized between the UI and a {@link DeployModelObject}.
 * 
 * @author Ed Snible
 */
public class DmoComposite extends Composite {

	static class PasswordModifyListener extends CatchallDmoUIHandler.StatusField implements
			ModifyListener {

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

		public void updateStatus() {
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

	protected final FormToolkit formToolkit;
	private DmoSyncHelper synchHelper = null;
	//	private EditDomain gefDomain;
	protected DeployModelObject dmo;

	/*
	 * This field is used to hold a PopupCloserListener that would be set but PopupDialogs to ensure
	 * that they close when a downstream composite opens another popup dialog.
	 */
	protected PopupCloserListener popupCloser;

	protected ConstraintComposite constraintComposite;

	/**
	 * @param parent
	 * @param style
	 * @param gefDomain
	 * @param formToolkit
	 * @deprecated use constructor that doesn't take an EditDomain
	 */
	public DmoComposite(Composite parent, int style,
			@SuppressWarnings("unused") EditDomain gefDomain, FormToolkit formToolkit) {
		super(parent, style);
		synchHelper = new DmoSyncHelper(createDmoSyncHelperModel());
		//		this.gefDomain = gefDomain;
		this.formToolkit = formToolkit;
		setBackgroundMode(SWT.INHERIT_DEFAULT);
	}

	/**
	 * @param parent
	 * @param style
	 * @param formToolkit
	 */
	public DmoComposite(Composite parent, int style, FormToolkit formToolkit) {
		this(parent, style, formToolkit, true);
	}

	/**
	 * @param parent
	 * @param style
	 * @param formToolkit
	 * @param shouldInitializeContents
	 *           If true then {@link #initializeContents(DmoSyncHelper)} will be called. If false
	 *           then the caller must call {@link #initializeContents(DmoSyncHelper)} themselves.
	 */
	public DmoComposite(Composite parent, int style, FormToolkit formToolkit,
			boolean shouldInitializeContents) {
		super(parent, style);
		synchHelper = new DmoSyncHelper(createDmoSyncHelperModel());
		//		this.gefDomain = gefDomain;
		this.formToolkit = formToolkit;
		setBackgroundMode(SWT.INHERIT_DEFAULT);
		if (shouldInitializeContents) {
			initializeContents(synchHelper);
		}
	}

	/**
	 * Subclasses should override if a custom model is required.
	 * 
	 * @return {@link DmoSyncHelperModel}.
	 */
	protected DmoSyncHelperModel createDmoSyncHelperModel() {
		return new DmoSyncHelperModel();
	}

	/**
	 * Subclasses should override this method to initialize the contents of the composite and use the
	 * synchHelper to bind the controls.
	 * 
	 * @param synchHelper
	 *           A {@link DmoSyncHelper} used to bind controls.
	 */
	protected void initializeContents(DmoSyncHelper aSynchHelper) {
	}

	/**
	 * Sets the DMO on the Composite
	 * 
	 * @param dmo
	 */
	public void setInput(Object object) {

		if (!isDisposed()) {

			if (object instanceof DeployModelObject) {
				if (dmo != null) {
					//If input changes without composite being disposed
					//disposeSynchHelper();
					//DCB Creating a new helper is an error since all the controls are already bound.
					//synchHelper = new DmoSyncHelper();
				}

				if (synchHelper == null) {
					synchHelper = new DmoSyncHelper(createDmoSyncHelperModel());
					initializeContents(synchHelper);
				}
				dmo = (DeployModelObject) object;
				synchHelper.setInput(dmo);

				if (constraintComposite != null) {
					constraintComposite.setInput(dmo);
				}
			}
		}
	}

	protected FormToolkit getWidgetFactory() {
		return formToolkit;
	}

	protected AttributeMetaData getAttributeMetaData(EStructuralFeature esf) {
		return dmo.getAttributeMetaData(esf.getName());
	}

	/** @deprecated */
	protected DecoratedField createDataEntryField(EAttribute attribute) {
		return createDataEntryField(this, attribute, null, null);
	}

	protected DecoratedField createDataEntryField(Composite parent, EAttribute attribute,
			AttributeMetaData amd, Label label) {

		DecoratedField retVal = null;

		if (attribute != null) {
			EClassifier eType = attribute.getEType();
			if (eType == null) {
				// If a fields type has an error, create a display label for it.
				DeployCoreUIPlugin.log(IStatus.WARNING, 0,
						"Attribute has no type: " + attribute.getName(), null); //$NON-NLS-1$
				retVal = createCatchallEntry(parent, attribute, label);
			} else if (attribute.isMany()) {
				// If we have a maxOccurs>1, we are building a composite, with a read-only AND a push button
				retVal = createListEntry(parent, attribute, label);
			} else if (eType.getInstanceClass() == String.class) {
				retVal = createTextEntry(parent, attribute, isPassword(amd) ? SWT.PASSWORD : SWT.NULL,
						label);
			} else if (isIntegerType(eType)) {
				retVal = createIntegerTextEntry(parent, attribute, label);
			} else if (isFloatType(eType)) {
				retVal = createFloatTextEntry(parent, attribute, label);
			} else if (booleanField(attribute)) {
				retVal = createCheckboxEntry(parent, attribute, label);
			} else if (eType instanceof EEnum) {
				retVal = createComboEntry(parent, attribute, label, SWT.READ_ONLY);
			} else if (eType.getInstanceClass() == QName.class) {
				retVal = createTextEntry(parent, attribute, SWT.READ_ONLY, label);
			} else {
				// If we don't know a field's type, create a display label for it.
				//			System.out.println("type="+attribute.getEType()); //$NON-NLS-1$
				retVal = createCatchallEntry(parent, attribute, label);
			}
		}

		return retVal;
	}

	private boolean isIntegerType(EClassifier eType) {
		Class typeClass = eType.getInstanceClass();
		return typeClass == Integer.class || typeClass == int.class || typeClass == BigInteger.class
				|| typeClass == Byte.class || typeClass == byte.class || typeClass == Short.class
				|| typeClass == short.class || typeClass == Long.class || typeClass == long.class;
	}

	private boolean isFloatType(EClassifier eType) {
		return eType.getInstanceClass() == Float.class || eType.getInstanceClass() == Double.class
				|| eType.getInstanceClass() == float.class || eType.getInstanceClass() == double.class;
	}

	protected boolean booleanField(EAttribute ea) {
		EClassifier eType = ea.getEType();
		if (eType == null) {
			return false;
		}
		return eType.getInstanceClass() == boolean.class || eType.getInstanceClass() == Boolean.class;
	}

	/**
	 * @param amd
	 * @return <code>true</code> if amd indicates attribute should be encrypted
	 */
	protected boolean isPassword(AttributeMetaData amd) {
		if (amd == null) {
			return false;
		}

		return amd.isEncrypted();
	}

	protected DecoratedField createCatchallEntry(Composite parent, EAttribute attribute, Label label) {
		DecoratedField decor = new DecoratedField(parent, SWT.BORDER, getLabelControlCreator());
		Label l = (Label) decor.getControl();
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalIndent = 3;
		decor.getLayoutControl().setLayoutData(gd);
		if (attribute != null) {
			getSynchHelper().synchLabel(l, attribute, label == null ? null : new Label[] { label });
		}

		return decor;
	}

	protected DecoratedField createComboEntry(Composite parent, EAttribute attribute, Label label) {
		return createComboEntry(parent, attribute, label, SWT.NONE);
	}

	protected DecoratedField createComboEntry(Composite parent, EAttribute attribute, Label label,
			int style) {
		DecoratedField decor = new DecoratedField(parent, SWT.BORDER, getComboControlCreator(style));
		decor.getLayoutControl().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		Combo combo = (Combo) decor.getControl();

		getSynchHelper().registerDecoratedField(decor, attribute);
		getSynchHelper().synchCombo(combo, attribute, label == null ? null : new Label[] { label });
		return decor;
	}

	private DecoratedField createListEntry(Composite parent, EAttribute attribute, Label label) {
		DecoratedField decor = new DecoratedField(parent, SWT.NULL, getPopupListControlCreator());

		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalIndent = 7;
		decor.getLayoutControl().setLayoutData(gd);

		AttributeValueListComposite avlc = (AttributeValueListComposite) decor.getControl();
		getSynchHelper().synchPopupList(avlc, attribute, null);

		//		button.addSelectionListener(new PopupInvokerSelectionListener(attribute, getSynchHelper(), getShell()));

		return decor;
	}

//	private DecoratedField createListEntry(Composite parent, EAttribute attribute /*
//			 * , Label label,
//			 * Control control
//			 */) {
//				DecoratedField decor = new DecoratedField(parent, SWT.NULL, getPopupListControlCreator());
//
//				//decor.getLayoutControl().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
//				Button button = (Button) decor.getControl();
////				List<Control> controls = new LinkedList<Control>();
////				if (label != null) {
////					controls.add(label);
////				}
////				if (control != null) {
////					controls.add(control);
////				}
////				getSynchHelper().synchPopupList(button, attribute,
////						controls.size() == 0 ? null : controls.toArray(new Control[0]));
//				getSynchHelper().synchPopupList(button, attribute, null);
//
//				//		button.addSelectionListener(new PopupInvokerSelectionListener(attribute, getSynchHelper(), getShell()));
//
//				return decor;
//			}

	protected DecoratedField createCheckboxEntry(Composite parent, EAttribute attribute, Label label) {
		DecoratedField decor = new DecoratedField(parent, SWT.NULL, getCheckboxControlCreator());
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalIndent = 8;
		decor.getLayoutControl().setLayoutData(gd);
		Button button = (Button) decor.getControl();
		getSynchHelper().synchCheckbox(button, attribute,
				label == null ? null : new Label[] { label });
		return decor;
	}

	protected DecoratedField createIntegerTextEntry(Composite parent, EAttribute attribute,
			Label label) {
		// TODO Add filtering so field must be an integer...
		DecoratedField decor = new DecoratedField(parent, SWT.BORDER /* |SWT.RIGHT */,
				getTextControlCreator());

		Text text = (Text) decor.getControl();
		decor.getLayoutControl().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		getSynchHelper().registerDecoratedField(decor, attribute);
		getSynchHelper().synchText(text, attribute, true,
				label == null ? null : new Label[] { label });
		return decor;
	}

	protected DecoratedField createFloatTextEntry(Composite parent, EAttribute attribute, Label label) {
		// TODO Add filtering so field must be a float/double.
		DecoratedField decor = new DecoratedField(parent, SWT.BORDER /* |SWT.RIGHT */,
				getTextControlCreator());

		Text text = (Text) decor.getControl();
		decor.getLayoutControl().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		getSynchHelper().registerDecoratedField(decor, attribute);
		getSynchHelper().synchText(text, attribute, true,
				label == null ? null : new Label[] { label });
		return decor;
	}

	protected DecoratedField createTextEntry(EAttribute attribute, int style, Label label) {
		return createTextEntry(this, attribute, style, label);
	}

	protected DecoratedField createTextEntry(Composite parent, EAttribute attribute, int style,
			Label label) {
		DecoratedField decor = new DecoratedField(parent, SWT.BORDER | style, getTextControlCreator());

		Text text = (Text) decor.getControl();
		decor.getLayoutControl().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		getSynchHelper().registerDecoratedField(decor, attribute);
		getSynchHelper().synchText(text, attribute, true,
				label == null ? null : new Label[] { label });
		return decor;
	}

	/**
	 * This method needs to be private because it's output is an internal class; we don't want other
	 * plugins getting the helper and being unable to use it.
	 * 
	 * @deprecated (until we mark it private)
	 * 
	 *             Instead of calling this we need a way to synch everything, I suggest the new
	 *             method aboutToBeShown() which does.
	 */
	public DmoSyncHelper getSynchHelper() {
		return synchHelper;
	}

	/**
	 * Get the EMF.Edit ItemPropertySource for the {@link DeployModelObject}.
	 * 
	 * @return an EMF.Edit descriptor with useful stuff like translated display name and description
	 */
	protected IItemPropertySource getPropertySource(DeployModelObject dmo) {
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(dmo);
		if (editingDomain instanceof AdapterFactoryEditingDomain) {
			AdapterFactoryEditingDomain afed = (AdapterFactoryEditingDomain) editingDomain;
			IItemPropertySource ips = (IItemPropertySource) afed.getAdapterFactory().adapt(dmo,
					IItemPropertySource.class);
			return ips;
		}

		return null;
	}

	/**
	 * @deprecated see comments on getSynchHelper(), call aboutToBeHidden() instead
	 */
	public void disposeSynchHelper() {
		if (synchHelper != null) {
			synchHelper.dispose();
			synchHelper = null;
		}
	}

	public void dispose() {
		disposeSynchHelper();
		aboutToBeHidden();
		saveDialogSettings();
//		if (constraintComposite != null) {
//			constraintComposite.dispose();
//		}
		super.dispose();
	}

	/**
	 * Subclasses should override to save dialog settings.
	 */
	protected void saveDialogSettings() {

	}

	/**
	 * Prepare resources to maintain UI
	 */
	public void aboutToBeShown() {
		getSynchHelper().synchAllUIWithModel();
	}

	/**
	 * Stops using resources to maintain UI.
	 * 
	 * NOTE: It appears the popups don't call this! So it is no longer a useful place to clean up.
	 * Use {@link #dispose()} instead.
	 */
	public void aboutToBeHidden() {
		disposeSynchHelper();
//		saveDialogSettings();

		// Don't explicitly dispose anything; it isn't safe; Eclipse might re-use this Composite
//		if (constraintComposite != null) {
//			constraintComposite.dispose();
//			constraintComposite = null;
//		}
	}

	/**
	 * @deprecated
	 * @return
	 */
	public boolean isModal() {
		return getSynchHelper().isModal();
	}

	protected IControlCreator getLabelControlCreator() {
		return new IControlCreator() {

			public Control createControl(Composite parent, int style) {
				return getWidgetFactory().createLabel(parent, "", style); //$NON-NLS-1$
			}
		};
	}

	protected IControlCreator getTextControlCreator() {
		return new IControlCreator() {

			public Control createControl(Composite parent, int style) {
				return getWidgetFactory().createText(parent, "", style); //$NON-NLS-1$
			}
		};
	}

	protected IControlCreator getComboControlCreator(final int comboStyle) {
		return new IControlCreator() {

			public Control createControl(Composite parent, int style) {
				Combo combo = new Combo(parent, SWT.DROP_DOWN | comboStyle | style);
				//				CCombo combo = new CCombo(parent, SWT.DROP_DOWN | SWT.READ_ONLY | style);
				getWidgetFactory().adapt(combo, false, false);
				return combo;
			}
		};
	}

	protected IControlCreator getCheckboxControlCreator() {
		return new IControlCreator() {

			public Control createControl(Composite parent, int style) {
				return getWidgetFactory().createButton(parent, "", SWT.CHECK | style); //$NON-NLS-1$
			}
		};
	}

	protected IControlCreator getPopupListControlCreator() {
		return new IControlCreator() {

			public Control createControl(Composite parent, int style) {
//				String msg = Messages.DmoComposite_Edit_;
//				return getWidgetFactory().createButton(parent, msg, SWT.PUSH | style);
				Composite comp = new AttributeValueListComposite(parent, style);
				getWidgetFactory().adapt(comp);
				return comp;
			}
		};
	}

	private IDialogSettings getDialogSettings() {
		return DeployCoreUIPlugin.getDefault().getDialogSettings();
	}

	protected boolean floating() {
		// TODO This is a really bad implementation, but I can't think of an obvious
		// way to do this other than passing around explicit variable, which would require
		// changing the SAF method signatures...
		Composite comp = getParent();
		while (comp != null) {
			if (comp instanceof PageBook) {
				return false;
			}
			//			System.out.println(comp.getClass());
			comp = comp.getParent();
		}
		return true;
	}

	/**
	 * Create a UI for displaying {@link Constraint}s.
	 */
	protected void addConstraintSection(Composite parent) {
		constraintComposite = new ConstraintComposite(parent, SWT.FLAT, dmo, formToolkit);
		getWidgetFactory().adapt(constraintComposite);
		constraintComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	}

	private Composite getConstraintComposite() {
		if (constraintComposite == null) {
			constraintComposite = new ConstraintComposite(this, SWT.FLAT, dmo, formToolkit);
		}
		return constraintComposite;
	}

	protected AttributeMetaData getAttributeMetaData(ExtendedAttribute ea) {
		return dmo.getAttributeMetaData(ea.getName());
	}

	/**
	 * This setter is to be used by {@link PopupDialog} clients to allow the caller to pass an
	 * instance of a {@link PopupCloserListener} which will ensure the primary dialog closes when
	 * focus moves to a another shell from a secondary dialog opened by downstream composite.
	 * 
	 * @param aPopupCloser
	 *           The popupCloser to set.
	 * 
	 * @see PopupCloserListener#setSecondaryPopup(org.eclipse.jface.window.Window)
	 */
	public void setPopupCloser(PopupCloserListener aPopupCloser) {
		popupCloser = aPopupCloser;

		if (constraintComposite != null) {
			constraintComposite.setPopupCloser(aPopupCloser);
		}
	}
} // end class DmoComposite
