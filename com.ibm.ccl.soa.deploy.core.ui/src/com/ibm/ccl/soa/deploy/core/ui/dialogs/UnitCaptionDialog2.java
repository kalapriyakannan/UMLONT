/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.dialogs;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.ui.services.properties.ICompositePropertySource;
import org.eclipse.gmf.runtime.common.ui.services.properties.PropertiesService;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.ui.properties.descriptors.EMFCompositeSourcePropertyDescriptor;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellEditorListener;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.IPropertyDescriptor;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.editparts.NameCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.properties.DeployUIWidgetFactory;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.ui.properties.TransactionCommandWrapper2;

/**
 * Dialog for editing caption and setting the value of key properties at the same time.
 * 
 * @author Ed Snible
 */
public class UnitCaptionDialog2 extends PopupDialog {

	private static final int SIZING_TEXT_FIELD_WIDTH = 250;

	private final Unit unit;

	/**
	 * List of {@link ItemPropertyDescriptor}
	 */
	private final List<KeyAttributeDescriptor> keys;

	private Button buttonLink;

	private Text txtFreeform;

	private Command command;

	private final Point loc;

	private final Collection<Control> localBkColorExclusions;

	private Control firstCellEditor;

	private final Character initialChar;

	private final boolean _inPlaceEdit;

	private Composite statusBar;

	private final NameCompartmentEditPart _nameCompartmentEditPart;

	/**
	 * @param parentShell
	 * @param unit
	 * @param loc
	 * @param initialChar
	 * @param inPlaceEdit
	 *           TODO
	 * @param scope
	 */
	public UnitCaptionDialog2(Shell parentShell, Unit unit, Point loc, Character initialChar,
			boolean inPlaceEdit) {
		super(parentShell, inPlaceEdit ? SWT.NO_TRIM : SWT.TOOL, true, false, false, false, null,
				null);

		this.unit = unit;
		this.loc = loc;
		this.initialChar = initialChar;
		_inPlaceEdit = inPlaceEdit;
		_nameCompartmentEditPart = null;

		keys = calculateKeys();
		localBkColorExclusions = new LinkedList<Control>();
	}

	/**
	 * @param shell
	 * @param unit
	 * @param loc
	 * @param initialChar
	 * @param nameCompartmentEditPart
	 * @param inPlaceEdit
	 */
	public UnitCaptionDialog2(Shell shell, Unit unit, Point loc, Character initialChar,
			NameCompartmentEditPart nameCompartmentEditPart, boolean inPlaceEdit) {
		super(shell, inPlaceEdit ? SWT.NO_TRIM : SWT.TOOL, true, false, false, false, null, null);

		this.unit = unit;
		this.loc = loc;
		this.initialChar = initialChar;
		_inPlaceEdit = inPlaceEdit;
		_nameCompartmentEditPart = nameCompartmentEditPart;

		keys = calculateKeys();
		localBkColorExclusions = new LinkedList<Control>();
	}

	protected void handleDispose() {
		close();
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		if (_inPlaceEdit && isSimpleForm()) {
			shell.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		}
	}

	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);

		GridLayout layout = new GridLayout();
		if (_inPlaceEdit && isSimpleForm()) {
			layout.marginWidth = 0;
			layout.marginHeight = 0;
			layout.verticalSpacing = 0;
		}
		composite.setLayout(layout);

		addFreeformSection(composite);
		if (keys.size() > 0) {
			addKeysSection(composite);
		}

		initializeControls();

		//		applyDialogFont(composite);

		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.UNIT_CAPTION_POPUP);

		return composite;
	}

	@Override
	protected Control createContents(Composite parent) {
		Composite parentComp = (Composite) super.createContents(parent);
		if (!isSimpleForm()) {
			statusBar = DeployUIWidgetFactory.INSTANCE.createModifiedStatusBarWithClose(parentComp,
					this);
		}
		return parentComp;
	}

	private void initializeControls() {
		// If no keys, enable freeform by default
		boolean freeForm = isInitiallyFreeform();
		if (buttonLink != null) {
			buttonLink.setSelection(!freeForm);
		}

		// JES 5/14/07 -- use first typed character
		if (initialChar != null && freeForm) {
			txtFreeform.setText(initialChar.toString());
			txtFreeform.setSelection(1, 1);
		} else {
			txtFreeform.setText(unit.getCaptionProvider().title(unit));
			if (freeForm) {
				txtFreeform.setSelection(0, txtFreeform.getText().length());
			}
		}

		dialogChanged();
	}

	/**
	 * @param chr --
	 *           add character to editbox
	 */
	public void addCharacter(Character chr) {
		String s = txtFreeform.getText() + chr;
		txtFreeform.setText(s);
		int n = s.length();
		txtFreeform.setSelection(n, n);
	}

	private boolean isSimpleForm() {
		return keys.size() == 0;
	}

	//5606: Caption setting problems with imported units
	private boolean isEmptyDisplayName() {
		String displayName = unit.getDisplayName();
		return displayName == null || displayName.length() == 0;
	}

	//5606: Caption setting problems with imported units
	private boolean isInitiallyFreeform() {
		return keys.size() == 0 || !isEmptyDisplayName();
	}

	private void dialogChanged() {
		if (buttonLink != null) {
			txtFreeform.setEnabled(!buttonLink.getSelection());
		}
	}

	private void addFreeformSection(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		GridLayout layout = new GridLayout(2, false);
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 0;
		composite.setLayout(layout);

		//		Label promptFreeform = new Label(composite, SWT.NONE);
		//		promptFreeform.setText("Caption:"); //$NON-NLS-1$

		txtFreeform = new Text(composite, SWT.BORDER);
		localBkColorExclusions.add(txtFreeform);
		GridData gdText = new GridData(GridData.FILL_BOTH);
		gdText.widthHint = _inPlaceEdit && isSimpleForm() ? SIZING_TEXT_FIELD_WIDTH * 2 / 3
				: SIZING_TEXT_FIELD_WIDTH;
		txtFreeform.setLayoutData(gdText);

		txtFreeform.addKeyListener(new PopupKeyListener());

		if (keys.size() > 0) {
			buttonLink = new Button(composite, SWT.CHECK);
			//		buttonFreeform.setText("Freeform?"); //$NON-NLS-1$
			buttonLink.setText(getLinkMessage());
			buttonLink.addSelectionListener(new SelectionListener() {

				public void widgetDefaultSelected(SelectionEvent e) {
					// do nothing
				}

				public void widgetSelected(SelectionEvent e) {
					if (buttonLink.getSelection()) {
						refreshCalculatedTitle();
					}

					dialogChanged();

				}
			});
			GridData gdButton = new GridData();
			gdButton.horizontalSpan = 2;
			buttonLink.setLayoutData(gdButton);
		}
	}

	private String getLinkMessage() {
		StringBuffer sb = new StringBuffer(Messages.UnitCaptionDialog2_Link_with_);
		for (Iterator<KeyAttributeDescriptor> it = keys.iterator(); it.hasNext();) {
			KeyAttributeDescriptor kad = it.next();
			sb.append(kad.getPropertyDescriptor().getDisplayName());
			if (it.hasNext()) {
				sb.append(':');
			}
		}
		return sb.toString();
	}

	private void addKeysSection(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		GridLayout layout = new GridLayout(2, false);
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		//		GridLayout layout = new GridLayout();	
		composite.setLayout(layout);

		ICellEditorListener listener = new CellListener();

		boolean isFirst = true;
		for (Iterator<KeyAttributeDescriptor> it = keys.iterator(); it.hasNext();) {
			KeyAttributeDescriptor kad = it.next();
			IPropertyDescriptor ipd = kad.getPropertyDescriptor();
			Label prompt = new Label(composite, SWT.NULL);
			prompt.setText(ipd.getDisplayName());
			Object editValue = null;
			if (ipd instanceof EMFCompositeSourcePropertyDescriptor) {
				EMFCompositeSourcePropertyDescriptor ecspd = (EMFCompositeSourcePropertyDescriptor) ipd;
				editValue = ecspd.getPropertyValue();
			}

			Composite wrapper = createControlToWrapCellEditor(composite);
			CellEditor editor = ipd.createPropertyEditor(wrapper);
			if (editor != null) {
				if (firstCellEditor == null) {
					firstCellEditor = editor.getControl();
				}

				localBkColorExclusions.add(editor.getControl());

				kad.setEditor(editor);

				// Make the editor as wide as possible
				editor.getControl().setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

				// JES 5/14/07 -- use first typed character
				if (isFirst) {
					isFirst = false;
					String value = null;
					if (editValue != null) {
						value = editValue.toString();
					}
					if (initialChar != null) {
						value = initialChar.toString();
					}
					if (value != null) {
						editor.setValue(value);
					}
					if (initialChar != null) {
						((Text) editor.getControl()).setSelection(1, 1);
					}
				} else {
					if (editValue != null) {
						editor.setValue(editValue);
					}
				}

				editor.getControl().setVisible(true);
				// TODO Get color from something in Eclipse in case we're themed
				editor.getControl().setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WHITE));

				editor.addListener(listener /*
				 * new KeyListener(editor, kad.getObject(),
				 * kad.getFeature())
				 */);

				editor.getControl().addFocusListener(new KeyFocusListener(editor));

			} else {
				Label dummy = new Label(composite, SWT.CENTER);
				dummy.setText(Messages.GuiPropertySetResolutionGenerator_0);
			}
		}
	}

	//	private static class WhiteCanvas extends Canvas {
	//
	//		public WhiteCanvas(Composite parent, int style) {
	//			super(parent, style);
	//		}
	//
	//		public void drawBackground(GC gc, int x, int y, int width, int height) {
	//			super.drawBackground(gc, x, y, width, height);
	//			System.out.println("Drew something"); //$NON-NLS-1$
	//		}
	//		
	//	}

	private Composite createControlToWrapCellEditor(Composite parent) {
		Composite retVal = new Composite(parent, SWT.BORDER | SWT.BACKGROUND);
		GridLayout gdWrapper = new GridLayout();
		gdWrapper.marginWidth = 0;
		gdWrapper.marginHeight = 0;
		retVal.setLayout(gdWrapper);

		localBkColorExclusions.add(retVal);

		retVal.setLayoutData(new GridData(GridData.FILL_BOTH));

		return retVal;
	}

	private void refreshCalculatedTitle() {
		String calculatedTitle = unit.getCaptionProvider().calculatedTitle(unit,
				calculateHypotheticals());
		if (calculatedTitle != null) {
			txtFreeform.setText(calculatedTitle);
		}
	}

	private Map<Capability, Map<EAttribute, String>> calculateHypotheticals() {
		Map<Capability, Map<EAttribute, String>> retVal = new HashMap<Capability, Map<EAttribute, String>>();

		// For every key CellEditor, create a hypothethical
		for (Iterator<KeyAttributeDescriptor> it = keys.iterator(); it.hasNext();) {
			KeyAttributeDescriptor kad = it.next();

			Map<EAttribute, String> capMap = retVal.get(kad.getObject());
			if (capMap == null) {
				capMap = new HashMap<EAttribute, String>();
				retVal.put(kad.getObject(), capMap);
			}

			CellEditor editor = kad.getEditor();
			if (editor != null) {
				Object value = editor.getValue();
				if (value instanceof String) {
					capMap.put((EAttribute) kad.getFeature(), (String) value);
				}
			}
		}

		return retVal;
	}

	/** Returns a List of KeyAttributeDescriptor */
	private List<KeyAttributeDescriptor> calculateKeys() {
		// In this implementation, Units can't contribute their own keys.  The properties
		// contribute the keys.
		List<KeyAttributeDescriptor> retVal = new LinkedList<KeyAttributeDescriptor>();
		for (Iterator<Capability> it = unit.getCapabilities().iterator(); it.hasNext();) {
			Object o = it.next();
			//			System.out.println(o);
			if (o instanceof Capability) {
				Capability cap = (Capability) o;
				List<EAttribute> keys = cap.titleKeys();
				if (keys.size() > 0) {
					ICompositePropertySource icp = PropertiesService.getInstance()
							.getPropertySource(cap);
					IPropertyDescriptor[] aipd = icp.getPropertyDescriptors();
					for (int i = 0; i < aipd.length; i++) {
						if (aipd[i].getId() instanceof EStructuralFeature) {
							EStructuralFeature esf = (EStructuralFeature) aipd[i].getId();
							//							if (keys.contains(esf.getName())) {
							if (keys.contains(esf)) {
								// Add, but at the end, so calculateKeys() doesn't reverse cap.titleKeys()
								retVal.add(retVal.size(), new KeyAttributeDescriptor(aipd[i], cap, esf));
							}
						}
					}
					// TODO Handle extended attributes
					// TODO Report any keys that don't get matched 
				}
			}
		}

		return retVal;
	}

	protected void rememberChoice() {
		String newName;
		if (buttonLink != null && !buttonLink.isDisposed() && buttonLink.getSelection()) {
			//5606: Caption setting problems with imported units
			newName = new String(); //Need an Empty string to ensure import link title calculation works.
		} else {
			if (txtFreeform.isDisposed()) {
				return;
			}
			newName = txtFreeform.getText();
		}
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(unit);
		CompoundCommand cc = new CompoundCommand();
		for (Iterator<KeyAttributeDescriptor> it = keys.iterator(); it.hasNext();) {
			KeyAttributeDescriptor kad = it.next();
			if (kad.getEditor() != null) {
				SetCommand scKey = kad.getSetCommand(domain);
				cc.append(scKey);
			}
		}
		//Append set command at the end to garuntee display name has changed
		SetCommand sc = new SetCommand(domain, unit, CorePackage.eINSTANCE
				.getDeployModelObject_DisplayName(), newName);
		cc.append(sc);

		TransactionCommandWrapper2 tcw = new TransactionCommandWrapper2(unit, cc, false);
		//		Command command = new ICommandProxy(tcw);

		//		CompositeTransactionalCommand ctc = 
		//			new CompositeTransactionalCommand(domain, "Set Caption"); //$NON-NLS-1$
		//		SetModelPropertyValueCommand smpvc = new SetModelPropertyValueCommand(
		//				domain, "Set Caption", unit, //$NON-NLS-1$

		//		gefDomain.getCommandStack().execute(command);

		command = new ICommandProxy(tcw);

		//		super.okPressed();
	}

	public boolean close() {
		if (_nameCompartmentEditPart != null) {
			_nameCompartmentEditPart.closeCaptionDlg();
		}

		// If this method was called as a result of the context-sensitive help opening,
		// do not close the dialog. 
		if (PlatformUI.getWorkbench().getHelpSystem().isContextHelpDisplayed()) {
			return false;
		}

		if (/* !isCancel || */getReturnCode() != Window.CANCEL) {
			rememberChoice();

			PropertyUtils.executeWithUndo(unit, command);
		}
		return super.close();
	}

	protected Point getInitialLocation(Point initialSize) {
		return loc;
	}

	@Override
	protected List<Control> getBackgroundColorExclusions() {
		List<Control> retVal = super.getBackgroundColorExclusions();
		retVal.addAll(localBkColorExclusions);
		DeployUIWidgetFactory.INSTANCE.addWithChildren(statusBar, retVal);
		return retVal;
	}

	protected Control getFocusControl() {
		if (isInitiallyFreeform()) {
			return txtFreeform;
		} else if (firstCellEditor != null) {
			return firstCellEditor;
		}

		return super.getFocusControl();
	}

	/**
	 * @return a Command to change the title and perhaps the key values
	 */
	public Command getCommand() {
		return command;
	}

	private class CellListener implements ICellEditorListener {

		protected CellListener(/* CellEditor editor, EObject obj, EStructuralFeature esfAttrib */) {
		}

		public void applyEditorValue() {
			// User has pressed enter.  Close popup.
			close();
		}

		public void cancelEditor() {
			// User has pressed ESC.  Close popup.
			setReturnCode(CANCEL);
			//			isCancel = true;
			close();
		}

		public void editorValueChanged(boolean oldValidState, boolean newValidState) {
			if (buttonLink.getSelection()) {
				refreshCalculatedTitle();
			}
		}

	} // end inner class KeyListener

	private static class KeyAttributeDescriptor {

		private final IPropertyDescriptor ipd;
		private final EStructuralFeature feature;
		private final Capability object;
		private CellEditor editor;

		private KeyAttributeDescriptor(IPropertyDescriptor ipd, Capability object,
				EStructuralFeature feature) {
			this.ipd = ipd;
			this.feature = feature;
			this.object = object;
		}

		protected SetCommand getSetCommand(EditingDomain domain) {
			SetCommand sc = new SetCommand(domain, object, feature, editor.getValue());
			return sc;
		}

		protected CellEditor getEditor() {
			return editor;
		}

		protected void setEditor(CellEditor editor) {
			this.editor = editor;
		}

		protected IPropertyDescriptor getPropertyDescriptor() {
			return ipd;
		}

		protected EStructuralFeature getFeature() {
			return feature;
		}

		protected Capability getObject() {
			return object;
		}

	} // end inner class KeyAttributeDescriptor

	private class KeyFocusListener implements FocusListener {

		private final CellEditor editor;

		protected KeyFocusListener(CellEditor editor) {
			this.editor = editor;
		}

		public void focusGained(FocusEvent e) {
			// do nothing
		}

		public void focusLost(FocusEvent e) {
			editor.getControl().setVisible(true);
		}

	} // end inner class KeyFocusListener

	private class PopupKeyListener implements KeyListener {

		public void keyPressed(KeyEvent e) {
			// do nothing
		}

		public void keyReleased(KeyEvent e) {
			if (e.keyCode == 13) {
				close();
			}

			//			System.out.println(e);
		}

	}
} // end class UnitCaptionDialog2
