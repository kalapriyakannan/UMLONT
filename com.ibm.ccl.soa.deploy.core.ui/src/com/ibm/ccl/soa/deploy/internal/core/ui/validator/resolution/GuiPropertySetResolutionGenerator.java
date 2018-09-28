/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.internal.core.ui.validator.resolution;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.ui.services.properties.PropertiesServiceAdapterFactory;
import org.eclipse.gmf.runtime.common.ui.services.properties.descriptors.ICompositeSourcePropertyDescriptor;
import org.eclipse.gmf.runtime.emf.ui.properties.descriptors.EMFCompositeSourcePropertyDescriptor;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellEditorListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;

import com.ibm.ccl.soa.deploy.core.AttributeMetaData;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.PasswordDialog;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.core.validator.resolution.DeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionContext;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolutionGenerator;
import com.ibm.ccl.soa.deploy.core.validator.status.IDeployAttributeStatus;

/**
 * Dialog box resolution for individual attribute value-setting.
 * 
 * @author snible@us.ibm.com
 */
public class GuiPropertySetResolutionGenerator implements IDeployResolutionGenerator {

	// MK 7/19/2007: added an ExtendedAttribute that is passed around in addition to the EStructuralFeature
	// if the attribute being set is an ExtendedAttribute, the offendingEsf will be null, 
	// if the attribute is a model attribute, the ea will be null
	private DeployModelObject offendingDmo;
	private EStructuralFeature offendingEsf;
	private final ExtendedAttribute ea = null;

	private final static IPropertySourceProvider ipsp = new PropertiesServiceAdapterFactory();

	private IPropertyDescriptor ipd;

	public IDeployResolution[] getResolutions(IDeployResolutionContext context) {

		String label = null;
		if (offendingDmo instanceof Capability) {
			Capability cap = (Capability) offendingDmo;
			Unit capParentUnit = (Unit) cap.getParent();
			if (capParentUnit != null) {
				if (ValidatorUtils.getCapabilities(capParentUnit, cap.eClass()).size() > 1) {
					label = NLS.bind(Messages.GuiPropertySetResolutionGenerator_Set_0_on_1, ipd
							.getDisplayName(), offendingDmo.getDisplayName());
				}
			}
		}
		if (label == null) {
			label = NLS.bind(Messages.GuiPropertySetResolutionGenerator_Set_0_, ipd.getDisplayName());
		}

		DeployResolution resolution = new GuiResolution(context, this, label, ipd, offendingDmo,
				offendingEsf, ea);

		resolution.setPriority(-100);
		return new IDeployResolution[] { resolution };
	}

	public boolean hasResolutions(IDeployResolutionContext context) {
		offendingDmo = context.getDeployStatus().getDeployObject();
		IDeployAttributeStatus idas = (IDeployAttributeStatus) context.getDeployStatus();
		offendingEsf = idas.getAttributeType();

		IPropertySource ips = ipsp.getPropertySource(offendingDmo);
		if (ips == null) {
			ips = new MyCapSource(offendingDmo);
			// return false;
		}

		IPropertyDescriptor[] aipd = ips.getPropertyDescriptors();
		if (aipd != null) {
			for (int i = 0; i < aipd.length; i++) {
				if (aipd[i] instanceof EMFCompositeSourcePropertyDescriptor) {
					EMFCompositeSourcePropertyDescriptor emfDescr = (EMFCompositeSourcePropertyDescriptor) aipd[i];
					if (emfDescr.getFeature() == offendingEsf) {
						ipd = emfDescr;
						break;
					}
				} else if (aipd[i] instanceof MyPropertyDescriptor) {
					EStructuralFeature feature = ((MyPropertyDescriptor) aipd[i]).getFeature();
					if (feature == offendingEsf) {
						ipd = aipd[i];
						break;
					}
//				} else if (aipd[i] instanceof ExtendedAttributePropertyDescriptor) {
//					ea = ((ExtendedAttributePropertyDescriptor) aipd[i]).getExtendedAttribute();
//					if (null == ea) {
//						continue;
//					}
//					String attributeName = ea.getName();
//					if (null == attributeName || 0 == attributeName.length()) {
//						continue;
//					}
//					if (attributeName.equals(idas.getAttributeName())) {
//						ipd = aipd[i];
//						break;
//					}
				}
			}
		}

		if (ipd == null) {
			return false;
		}

		if (ipd instanceof ICompositeSourcePropertyDescriptor) {
			ICompositeSourcePropertyDescriptor icspd = (ICompositeSourcePropertyDescriptor) ipd;
			return !icspd.isReadOnly();
		}

		return true;
	}

	private static class GuiResolution extends DeployResolution {

		private final DeployModelObject offendingDmo;
		private final EStructuralFeature offendingEsf;
		private final ExtendedAttribute ea;

		private final IPropertyDescriptor ipd;

		protected GuiResolution(IDeployResolutionContext context,
				IDeployResolutionGenerator generator, String description, IPropertyDescriptor ipd /*
																															 * IItemPropertyDescriptor
																															 * offendingIIPD
																															 * ,
																															 * DeployModelObject
																															 * offendingDmo
																															 * ,
																															 * EDataType
																															 * eDataType
																															 */
				, DeployModelObject offendingDmo, EStructuralFeature offendingEsf, ExtendedAttribute ea) {
			super(context, generator, description);
			setRequiresUserInput(true);

			this.ipd = ipd;

			this.offendingDmo = offendingDmo;
			this.offendingEsf = offendingEsf;
			this.ea = ea;
		}

		public IStatus resolve(IProgressMonitor monitor) {
			if (isPassword(offendingDmo, offendingEsf)) {
				return resolvePassword(/* monitor */);
			}

			return resolveNotPassword(/* monitor */);
		}

		private IStatus resolvePassword(/* IProgressMonitor monitor */) {
			PasswordDialog pd = new PasswordDialog(new Shell(), ipd.getDisplayName()/*
																											 * offendingEsf.getName
																											 * ()
																											 */);
			if (pd.open() == Window.OK) {
				String newValue = pd.getValue();
				offendingDmo.eSet(offendingEsf, newValue);
				return Status.OK_STATUS;
			}

			return Status.CANCEL_STATUS;
		}

		private IStatus resolveNotPassword(/* IProgressMonitor monitor */) {
			Dialog dlg = new GuiPropertySetDialog(new Shell(), ipd, offendingDmo, offendingEsf, ea);
			try {
				dlg.create();
				dlg.open();
			} catch (Exception ex) {
				DeployCoreUIPlugin.logError(0, ex.getMessage(), ex);
			}

			return Status.OK_STATUS;
		}

		private boolean isPassword(DeployModelObject dmo, EStructuralFeature esf) {
			AttributeMetaData md = dmo.getAttributeMetaData(esf.getName());
			if (md != null) {
				return md.isEncrypted();
			}

			return false;
		}

		/*
		 * @see java.lang.Object#hashCode()
		 */
		public int hashCode() {
			if (offendingDmo == null && offendingEsf == null) {
				return 0;
			}
			if (offendingDmo == null) {
				return offendingEsf.hashCode();
			}
			if (offendingEsf == null) {
				return offendingDmo.hashCode();
			}
			return offendingDmo.hashCode() ^ offendingEsf.hashCode();
		}

		/*
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		public boolean equals(Object obj) {
			if (!(obj instanceof GuiResolution)) {
				return false;
			}

			GuiResolution res = (GuiResolution) obj;
			return offendingDmo == res.offendingDmo && offendingEsf == res.offendingEsf;
		}

	} // end inner class GuiResolution

	public static class GuiPropertySetDialog extends Dialog {

		private final DeployModelObject offendingDmo;
		private final EStructuralFeature offendingEsf;
		private final ExtendedAttribute ea;
		private final IPropertyDescriptor ipd;
		private int applied = 0;

		private final Object suggestedValue;

		protected CellEditor editor;

		public GuiPropertySetDialog(Shell parentShell, IPropertyDescriptor ipd,
				DeployModelObject offendingDmo, EStructuralFeature offendingEsf, ExtendedAttribute ea) {
			this(parentShell, ipd, offendingDmo, offendingEsf, ea, null);
		}

		public GuiPropertySetDialog(Shell parentShell, IPropertyDescriptor ipd,
				DeployModelObject offendingDmo, EStructuralFeature offendingEsf, ExtendedAttribute ea,
				Object suggestedValue) {
			super(parentShell);

			this.ipd = ipd;

			// MK: 7/19/2007 only one of offendingEsf or ea will be non-null
			assert !(null == offendingEsf && null == ea);
//			if (ea != null) {
//				offendingEsf = null;
//			}

			this.offendingDmo = offendingDmo;
			this.offendingEsf = offendingEsf;
			this.ea = ea;
			this.suggestedValue = suggestedValue;
		}

		protected void configureShell(Shell shell) {
			super.configureShell(shell);
			shell.setText(NLS.bind(Messages.GuiPropertySetResolutionGenerator_Set_0_, ipd
					.getDisplayName()));
			// minimum size to ensure dialog has enough room for the title
			shell.setMinimumSize(300, 100);
		}

		protected Control createDialogArea(Composite parent) {
			Composite composite = (Composite) super.createDialogArea(parent);

			GridLayout layout = new GridLayout(2, false);
			layout.marginTop = 5;
			layout.marginBottom = 5;
			layout.marginLeft = 2;
			layout.marginRight = 2;
			composite.setLayout(layout);

			if (offendingDmo instanceof Capability) {
				Capability cap = (Capability) offendingDmo;
				Unit capParentUnit = (Unit) cap.getParent();
				if (capParentUnit != null) {
					if (ValidatorUtils.getCapabilities(capParentUnit, cap.eClass()).size() > 1) {
						if (offendingDmo.getDisplayName() != null) {
							Label labelDisplayName = new Label(composite, SWT.NONE);
							labelDisplayName.setText(NLS.bind(
									Messages.GuiPropertySetResolutionGenerator_Set_0_on_1, ipd
											.getDisplayName(), offendingDmo.getDisplayName()));
							//							Label labelDummy = new Label(composite, SWT.NONE);
							//							labelDummy.setText(""); //$NON-NLS-1$
							GridData gdLabelDisplay = new GridData();
							gdLabelDisplay.horizontalSpan = 2;
							labelDisplayName.setLayoutData(gdLabelDisplay);
						}
					}
				}
			}

			Label labelMinutes = new Label(composite, SWT.NONE);
			//			labelMinutes.setText(offendingIIPD.getDisplayName(offendingDmo));
			labelMinutes.setText(ipd.getDisplayName() + ":"); //$NON-NLS-1$

			// because the editor that's created is intended for a table cell, it doesn't have a border
			// therefore we fake a border here....
			Composite border = new Composite(composite, SWT.BORDER);
			border.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			GridLayout gl = new GridLayout(1, false);
			gl.marginHeight = gl.marginWidth = 0;
			border.setLayout(gl);

			editor = ipd.createPropertyEditor(border);

			if (editor != null) {

				// Make the editor as wide as possible
				editor.getControl().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

				Object editValue = null;
				if (suggestedValue != null) {
					editValue = suggestedValue;
				} else if (null != ea) {
					editValue = ea.getValue();
				} else if (null != offendingEsf) {
					editValue = offendingDmo.eGet(offendingEsf);
				}
				setInitialEditorValue(editValue);

				editor.getControl().setVisible(true);
				// TODO Get color from something in Eclipse in case we're themed
				editor.getControl().setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));

				editor.addListener(new ICellEditorListener() {

					public void applyEditorValue() {
						if (applyValue()) {
							if (isEnumType()) {
								/*
								 * We have to call okPressed() in an asycExec because this call may have
								 * been invoked from clicking the OK button which forced a focusLost even
								 * first. If we call okPressed() first then we will get an NPE updating the
								 * shell menu.
								 */
								Display.getCurrent().asyncExec(new Runnable() {
									public void run() {
										if (!GuiPropertySetDialog.this.getDialogArea().isDisposed()) {
											GuiPropertySetDialog.super.okPressed();
										}
									}
								});
							} else {
								GuiPropertySetDialog.super.okPressed();
							}
						}
					}

					public void cancelEditor() {
						cancelPressed();
					}

					public void editorValueChanged(boolean oldValidState, boolean newValidState) {

					}

				});

				editor.setFocus();

			} else {
				Label dummy = new Label(composite, SWT.CENTER);
				dummy.setText(Messages.GuiPropertySetResolutionGenerator_0);
			}

			//			initializeControls();

			applyDialogFont(composite);

			PlatformUI.getWorkbench().getHelpSystem().setHelp(composite,
					IDeployHelpContextIds.RESOLUTION_PROPERTY_SET_DIALOG);

			return composite;
		}

		private void setInitialEditorValue(final Object editValue) {
			if (isEnumType()) {
				/*
				 * We have to set the value in an asycExec because a focusLost event may refresh the
				 * enum items and reset the value to the first item.
				 */
				Display.getCurrent().asyncExec(new Runnable() {
					public void run() {
						if (!GuiPropertySetDialog.this.getDialogArea().isDisposed()) {
							editor.setValue(editValue);
						}
					}
				});
			} else {
				editor.setValue(editValue);
			}
		}

		protected Control createButtonBar(Composite parent) {
			Control retVal = super.createButtonBar(parent);

			// By default, EMFCompositeSourcePropertyDescriptor.createDataTypeCellEditor()
			// creates a CellEditor that gets deactivated and disappears when it loses focus.
			// We can't easily stop that, but we can immediately set the field to visible.
			Control ctrl = editor.getControl();
			if (ctrl != null) {
				ctrl.addFocusListener(new FocusListener() {

					public void focusGained(FocusEvent e) {
						// do nothing
					}

					public void focusLost(FocusEvent e) {
						if (!editor.getControl().isDisposed()) {
							editor.getControl().setVisible(true);
						}
					}
				});
			}
			return retVal;
		}

		protected void okPressed() {
			//			System.out.println(offendingIIPD.getClass());

			//			String txtVal = textValue.getText();
			//			Object newValue = EcoreUtil.createFromString(eDataType, txtVal);
			//			offendingIIPD.setPropertyValue(offendingDmo, newValue);

			applyValue();
			super.okPressed();
		}

		protected final boolean applyValue() {
			applied++;
			Object newValue = editor.getValue();

			// EMF won't let us set a list to null
			if (null != offendingEsf) {

				doApplyValue(newValue);

				if (isEnumType() && applied == 1) {
					return false; /* should not close */
				}
			}
			return true; /* should close */
		}

		protected void doApplyValue(Object newValue) {
			boolean cantSafelySet = offendingEsf.isMany() && newValue == null;
			if (!cantSafelySet) {
				offendingDmo.eSet(offendingEsf, newValue);
			}
		}

		private boolean isEnumType() {
			return offendingEsf.getEType() instanceof EEnum;
		}

	} // end class GuiPropertySetDialog

	public static class MyCapSource implements IPropertySource {

		// actually, dmo is a Capability here
		private final DeployModelObject dmo;

		public MyCapSource(DeployModelObject dmo) {
			this.dmo = dmo;
		}

		public Object getEditableValue() {
			return null;
		}

		public IPropertyDescriptor[] getPropertyDescriptors() {
			EList features = dmo.eClass().getEAllAttributes();
			IPropertyDescriptor[] retVal = new IPropertyDescriptor[features.size()];
			for (int i = 0; i < retVal.length; i++) {
				EAttribute feature = (EAttribute) features.get(i);
				retVal[i] = new MyPropertyDescriptor(feature);
			}
			return retVal;
		}

		public Object getPropertyValue(Object id) {
			return id;
		}

		public boolean isPropertySet(Object id) {
			return true;
		}

		public void resetPropertyValue(Object id) {
			// do nothing
		}

		public void setPropertyValue(Object id, Object value) {
			// do nothing
		}

	}

	public static class MyPropertyDescriptor implements IPropertyDescriptor {

		private static final ILabelProvider labelProvider = new MyLabelProvider();
		private final EAttribute attribute;

		/**
		 * @param attribute
		 */
		public MyPropertyDescriptor(EAttribute attribute) {
			assert attribute != null;
			this.attribute = attribute;
		}

		public CellEditor createPropertyEditor(Composite parent) {
			return null;
		}

		public String getCategory() {
			return null;
		}

		public String getDescription() {
			return attribute.getName();
		}

		public String getDisplayName() {
			return attribute.getName();
		}

		public String[] getFilterFlags() {
			return null;
		}

		public Object getHelpContextIds() {
			return null;
		}

		public Object getId() {
			return attribute.getName();
		}

		public ILabelProvider getLabelProvider() {
			return labelProvider;
		}

		public boolean isCompatibleWith(IPropertyDescriptor anotherProperty) {
			return false;
		}

		public EStructuralFeature getFeature() {
			return attribute;
		}

	} // end inner class MyPropertyDescriptor

	/** LabelProvider for the Capability names themselves */
	private static class MyLabelProvider extends LabelProvider {

		public Image getImage(Object element) {
			//	    	if (element instanceof DeployModelObject) {
			//	    		DeployModelObject dmo = (DeployModelObject) element;
			//	    		if (dmo.getStatus() != null && dmo.getStatus().getSeverity() != IStatus.OK) {
			//	    			return ErrorMarkerFigureFactory.getFigureImage(dmo.getStatus());
			//	    		}
			//	    	}
			//	    	
			return null;
		}

		public String getText(Object element) {
			if (element instanceof DeployModelObject) {
				DeployModelObject dmo = (DeployModelObject) element;
				return PropertyUtils.getDisplayEType(dmo.eClass(), ""); //$NON-NLS-1$
			}
			return ""; //$NON-NLS-1$
		}
	} // end inner class MyLabelProvider+

} // end class GuiPropertySetResolutionGenerator
