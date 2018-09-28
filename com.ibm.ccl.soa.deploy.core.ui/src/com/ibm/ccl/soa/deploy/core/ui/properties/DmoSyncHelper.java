/***************************************************************************************************
 * Copyright (c) 2007 IBM Corporation and others. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.properties;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.fieldassist.DecoratedField;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.wst.common.frameworks.datamodel.IDataModelListener;
import org.eclipse.wst.common.frameworks.internal.ui.TimedModifyListener;

import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.ConvertedValue;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.ui.composites.CompositeForDmoComposite;
import com.ibm.ccl.soa.deploy.core.ui.properties.DmoSyncHelperModel.PropertyDescriptor;

/**
 * This class is EXPERIMENTAL and is subject to substantial changes.
 * 
 * @see DmoSyncHelperModel
 */
final public class DmoSyncHelper implements Adapter {
	/*
	 * This is the time in miliseconds to delay for text fields that required timed delay.
	 */
	private static final int DELAY_TIME = 400;

	private static final boolean isLinux = System.getProperty("os.name").equals("Linux"); //$NON-NLS-1$ //$NON-NLS-2$

	private final DmoSyncHelperModel model;
	//Updated to add the ability to map widgets to multiple features
	private final Map<Widget, List<EStructuralFeature>> widgetToPropertyHash = new HashMap<Widget, List<EStructuralFeature>>();
	private final Map<EStructuralFeature, Widget> propertyToWidgetHash = new HashMap<EStructuralFeature, Widget>();
	private Map<Widget, Control[]> widgetToDepControls;
	private Map<Widget, Label> widgetToImageMap;

	//	protected EStructuralFeature currentProperty;
	private Object currentProperty;
	private Widget currentWidget;
	private Widget currentWidgetFromEvent; // TODO M4 see if this should be set with for
	// listeners
	private boolean ignoreModifyEvent = false;

	private final Map<EStructuralFeature, FieldAndStatusDec> allProps = new HashMap<EStructuralFeature, FieldAndStatusDec>();

	private ConfigurationContract contract;
	private final DmoFeatureValueConverter converter;

	/**
	 * <code>true</code> if the sync helper is doing something complex that requires modal behavior
	 * from its container, such as opening a heavyweight dialog.
	 */
	private boolean modal;

	/*
	 * Added in support of 4907.
	 */
	private final class DmoTimedModifyListener extends TimedModifyListener implements ActionListener {
		//Used to hold the modified text value if a forcePost
		//is called and the widget has been disposed.
		private String modifiedText = null;

		public DmoTimedModifyListener() {
			super(DELAY_TIME, null);
			addActionListener(this);
		}

		public void modifyText(ModifyEvent e) {
			if (ignoreModifyEvent) {
				return;
			}
			Text textWidget = (Text) e.getSource();
			if (textWidget != null && !textWidget.isDisposed()) {
				modifiedText = textWidget.getText();
			}
			super.modifyText(e);
		}

		public void actionPerformed(ActionEvent e) {
			Widget w = (Widget) e.getSource();
			postValue(w);
		}

		private void postValue(Widget w) {
			if (currentWidget == w || widgetToPropertyHash == null) {
				return;
			}
			List<EStructuralFeature> esf = widgetToPropertyHash.get(w);
			if (esf != null) {
				for (int i = 0; i < esf.size(); i++) {
					if (w.isDisposed() && modifiedText != null) {
						setProperty(esf, modifiedText);
					} else {
						setTextProperty(esf.get(i), (Text) w);
					}
				}
			}
		}

		void forcePost() {
			if (isRunning()) {
				stop();
				postValue((Widget) getSource());
			}
		}
	};

	private class ModifyTextListener implements ModifyListener {
		public void modifyText(ModifyEvent e) {
			if (ignoreModifyEvent) {
				return;
			}
			Text text = (Text) e.getSource();
			if (currentWidget == text) {
				return;
			}

			List<EStructuralFeature> props = widgetToPropertyHash.get(text);
			setProperty(props, text);
			updateImageControl(text, props);
		}
	}

	private IStatus setProperty(List<EStructuralFeature> features, Object obj) {
		IStatus status = Status.OK_STATUS;
		for (int i = 0; i < features.size() && status.isOK(); i++) {
			status = setProperty(features.get(i), obj);
		}
		return status;
	}

	private ModifyTextListener modifyTextListener;
	private DmoTimedModifyListener timedModifyListener;

	private class ComboListener implements SelectionListener, ModifyListener {
		//		private boolean isCCombo = false;

		protected ComboListener(/* boolean isCCombo */) {
			//			this.isCCombo = isCCombo;
		}

		public void modifyText(ModifyEvent e) {
			if (ignoreModifyEvent) {
				return;
			}
			Widget combo = (Widget) e.getSource();
			if (currentWidget == combo) {
				return;
			}

			// If we are disposed it is too late to do anything!
			if (widgetToPropertyHash == null) {
				return;
			}

			//Ignore the modifyText event for a read-only combo box.
			if ((combo.getStyle() & SWT.READ_ONLY) != 0) {
				return;
			}

			try {
				String text = getText(combo);
				currentWidgetFromEvent = combo;
				List<EStructuralFeature> feature = widgetToPropertyHash.get(combo);
				//I think we can just look at the first feature here as descriptors should be the same
				//as all features are using the same composite-- Subclasses of the model should be responsible for
				//making sure they return the same values for each property regardless of which is registered first
				PropertyDescriptor[] descriptors = model.getValidPropertyDescriptors(feature.get(0));
				String description = text;
				// On a combo selection linux fires 2 events;
				// the first clears the value which needs to be ignored when the type is not String
				// the second sets the new value
				if (isLinux && description.length() == 0 && descriptors.length != 0
						&& !(descriptors[0].getPropertyValue() instanceof String)) {
					return;
				}
				for (int i = 0; i < descriptors.length; i++) {
					if (description.equals(descriptors[i].getPropertyText())) {
						setProperty(feature, descriptors[i].getPropertyValue());
						return;
					}
				}
				setProperty(feature, text);
				updateImageControl(combo, feature);
			} finally {
				currentWidgetFromEvent = null;
			}
		}

		private String getText(Widget combo) {
			//			isCCombo ? ((CCombo) combo).getText() : ((Combo) combo).getText();
			if (combo instanceof CCombo) {
				return ((CCombo) combo).getText();
			} else if (combo instanceof Combo) {
				return ((Combo) combo).getText();
			}

			return null;
		}

		private int getSelectionIndex(Widget combo) {
			//			int selectionIndex = isCCombo ? ((CCombo) combo).getSelectionIndex() : ((Combo) combo).getSelectionIndex();
			if (combo instanceof CCombo) {
				return ((CCombo) combo).getSelectionIndex();
			} else if (combo instanceof Combo) {
				return ((Combo) combo).getSelectionIndex();
			}

			return 0;
		}

		private String getItem(Widget combo, int selectionIndex) {
			//			String description = isCCombo ? ((CCombo)combo).getItem(selectionIndex) : ((Combo) combo).getItem(selectionIndex);
			if (combo instanceof CCombo) {
				return ((CCombo) combo).getItem(selectionIndex);
			} else if (combo instanceof Combo) {
				return ((Combo) combo).getItem(selectionIndex);
			}

			return null;
		}

		public void widgetSelected(SelectionEvent e) {
			Widget combo = (Widget) e.getSource();
			if (currentWidget == combo) {
				return;
			}
			List<EStructuralFeature> feature = widgetToPropertyHash.get(combo);
			int selectionIndex = getSelectionIndex(combo);
			if (selectionIndex >= 0) {
				PropertyDescriptor[] descriptors = model.getValidPropertyDescriptors(feature.get(0));
				String description = getItem(combo, selectionIndex);
				for (int i = 0; i < descriptors.length; i++) {
					if (description.equals(descriptors[i].getPropertyText())) {
						setProperty(feature, descriptors[i].getPropertyValue());
						return;
					}
				}
				setProperty(feature, description);
				updateImageControl(combo, feature);
			}
		}

		public void widgetDefaultSelected(SelectionEvent e) {
		}
	}

	private ComboListener comboListener;

	private class CheckboxSelectionListener implements SelectionListener {
		public void widgetSelected(SelectionEvent e) {
			Button button = (Button) e.getSource();
			if (currentWidget == button) {
				return;
			}
			//			setProperty(widgetToPropertyHash.get(button), new Boolean(button.getSelection()));
			List<EStructuralFeature> esf = widgetToPropertyHash.get(button);
			if (esf != null) {
				setProperty(esf, Boolean.valueOf(button.getSelection()));
			}
		}

		public void widgetDefaultSelected(SelectionEvent e) {
		}
	}

	private CheckboxSelectionListener checkboxSelectionListener;

	/**
	 * Constructor.
	 * 
	 * @param aSynchHelperModel
	 *           A {@link DmoSyncHelperModel} used to provide information to this
	 *           {@link DmoSyncHelper}.
	 */
	public DmoSyncHelper(DmoSyncHelperModel aSynchHelperModel) {

		assert aSynchHelperModel != null;

		model = aSynchHelperModel;
		converter = new DmoFeatureValueConverter();

		model.addListener(this);
	}

	/**
	 * Must be called before sync helper can be used
	 * 
	 * @param dmo
	 */
	public void setInput(DeployModelObject dmo) {
		//listen to the contract	
		if (contract != null) {
			contract.eAdapters().remove(this);
		}
		Topology top = dmo.getTopology();
		if (top != null) {
			contract = top.getConfigurationContract();
		}

		if (contract != null) {
			contract.eAdapters().add(this);
		}

		model.setInput(dmo);
		synchAllUIWithModel();
	}

	/**
	 * Add a listener to the underlying {@link DmoSyncHelperModel} which receives EMF change
	 * notifications.
	 * 
	 * @param anAdapter
	 *           An EMF {@link Adapter}.
	 */
	public void addModelListener(Adapter anAdapter) {
		if (anAdapter != null) {
			model.addListener(anAdapter);
		}
	}

	/**
	 * Remove a listener to the underlying {@link DmoSyncHelperModel}.
	 * 
	 * @param anAdapter
	 *           An EMF {@link Adapter}.
	 */
	public void removeModelListener(Adapter anAdapter) {
		if (anAdapter != null) {
			model.removeListener(anAdapter);
		}
	}

	private CheckBoxViewerListener checkBoxViewerStateListener;

//	private PopupSelectionListener popupSelectionListener;

	private class CheckBoxViewerListener implements ICheckStateListener {
		public void checkStateChanged(CheckStateChangedEvent event) {
			StructuredViewer viewer = (StructuredViewer) event.getSource();
			CheckboxTableViewer checkBoxTableViewer;
			CheckboxTreeViewer checkBoxTreeViewer;
			Object[] items = null;
			if (viewer instanceof CheckboxTableViewer) {
				checkBoxTableViewer = (CheckboxTableViewer) viewer;
				items = checkBoxTableViewer.getCheckedElements();
			} else if (viewer instanceof CheckboxTreeViewer) {
				checkBoxTreeViewer = (CheckboxTreeViewer) viewer;
				items = checkBoxTreeViewer.getCheckedElements();
			}
			List<EStructuralFeature> props = widgetToPropertyHash.get(viewer.getControl());
			for (int i = 0; i < props.size(); i++) {
				setPropertyItems(props.get(i), items);
			}
		}
	}

	private IStatus setProperty(EStructuralFeature propertyName, Object value) {
		currentProperty = propertyName;
		try {
			// ECS 3/30/07, prevent ClassCastException on enums
			if (value instanceof EEnumLiteral) {
				EEnumLiteral eel = (EEnumLiteral) value;
				value = eel.getInstance();
			}
			//Check to make sure we're not setting the property value multiple times
			PropertyDescriptor desc = model.getPropertyDescriptor(propertyName);
			if (desc.getPropertyValue() == null || !desc.getPropertyValue().equals(value)) {
				IStatus status = model.setProperty(propertyName, value);
				if (!status.isOK()) {
					synchUIWithModel(propertyName);
				}
				return status;
			}
		} finally {
			currentProperty = null;
		}
		return Status.OK_STATUS;
	}

	private IStatus setPropertyItems(EStructuralFeature propertyName, Object[] items) {
		currentProperty = propertyName;
		try {
			//Check to make sure we're not setting the property value multiple times
			PropertyDescriptor desc = model.getPropertyDescriptor(propertyName);
			if (desc.getPropertyValue() == null || !desc.getPropertyValue().equals(items)) {
				IStatus status = model.setProperty(propertyName, items);
				if (!status.isOK()) {
					synchUIWithModel(propertyName);
				}
				return status;
			}
		} finally {
			currentProperty = null;
		}
		return Status.OK_STATUS;
	}

	/**
	 * Force the UI to update for a given property.
	 * 
	 * @param property
	 *           An {@link EStructuralFeature} that is registered with this {@link DmoSyncHelper}.
	 */
	public void updateUIWithModel(EStructuralFeature property) {
		synchUIWithModel(property);
	}

	/**
	 * Sets the UI to have the property value defined in the model
	 * 
	 * @param propertyName
	 * @see IDataModelListener for the flag values.
	 */
	private void synchUIWithModel(final EStructuralFeature propertyName) {
		if (null != propertyToWidgetHash && hasInput()
				&& propertyToWidgetHash.containsKey(propertyName)) {
			Display.getDefault().syncExec(new Runnable() {
				public void run() {
					try {
						currentWidget = propertyToWidgetHash.get(propertyName);
						Widget widget = currentWidget;
						if (currentWidget != null && currentWidget != currentWidgetFromEvent) {
							//We must hold a copy in a temp variable because setting the widget value
							//may trigger an event that will cause this method to be called again.

							try {
								ignoreModifyEvent = true;
								if (!widget.isDisposed()) {
									if (currentWidget instanceof Text) {
										setWidgetValue(propertyName, (Text) currentWidget);
									} else if (currentWidget instanceof Combo) {
										setWidgetValue(propertyName, (Combo) currentWidget);
									} else if (currentWidget instanceof CCombo) {
										setWidgetValue(propertyName, (CCombo) currentWidget);
									} else if (currentWidget instanceof Button) {
										setWidgetValue(propertyName, (Button) currentWidget);
									} else if (currentWidget instanceof Label) {
										setWidgetValue(propertyName, (Label) currentWidget);
									} else if (currentWidget instanceof Hyperlink) {
										setWidgetValue(propertyName, (Hyperlink) currentWidget);
									} else if (currentWidget instanceof org.eclipse.swt.widgets.List) {
										setWidgetValue(propertyName,
												(org.eclipse.swt.widgets.List) currentWidget);
									} else if (currentWidget instanceof Table) {
										setWidgetValue(propertyName, (Table) currentWidget);
									} else if (currentWidget instanceof Tree) {
										setWidgetValue(propertyName, (Tree) currentWidget);
									} else if (currentWidget instanceof CompositeForDmoComposite) {
										setWidgetValue(propertyName, (CompositeForDmoComposite) currentWidget);
									}
								}
							} finally {
								ignoreModifyEvent = false;
							}

							// TODO There is no point in updating the decorations here because the
							// validation has not yet been run!  - ECS 4/3/07

							//update decorations
							FieldAndStatusDec fasd = allProps.get(propertyName);
							if (fasd != null) {
								IStatus status = model.getPropertyStatus(propertyName);
								updateStatus(fasd, status);
							}

							if (!widget.isDisposed()) {
								//Pass the copy of the currentWidget
								setEnablement((Control) widget, model.isPropertyEnabled(propertyName));
							}
						}
						//Still need to update image
						if (!widget.isDisposed()) {
							updateImageControl(widget, propertyName);
						}
					} finally {
						currentWidget = null;
					}
				}
			});
		} else if (propertyName == CorePackage.Literals.DEPLOY_MODEL_OBJECT__STATUS) {
			// At this point, validation has completed and the status is ready to be read.
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					for (Iterator<Map.Entry<EStructuralFeature, FieldAndStatusDec>> it = allProps
							.entrySet().iterator(); it.hasNext();) {
						Map.Entry<EStructuralFeature, FieldAndStatusDec> entry = it.next();
						IStatus stat = model.getPropertyStatus(entry.getKey());
						updateStatus(entry.getValue(), stat);
					}
				}
			});
		}
	}

	private void updateImageControl(Widget widget, List<EStructuralFeature> properties) {
		for (int i = 0; i < properties.size(); i++) {
			updateImageControl(widget, properties.get(i));
		}
	}

	private void updateImageControl(Widget widget, EStructuralFeature property) {
		if (widgetToImageMap != null) {
			Label imageLabel = widgetToImageMap.get(widget);
			if (imageLabel != null) {
				imageLabel.setImage(model.getPropertyImage(property));
			}
		}
	}

	private void updateStatus(FieldAndStatusDec fasd, IStatus stat) {
		if (stat != null) {
			fasd.showStatus(stat.getSeverity(), getStatusMessage(stat));
		} else {
			fasd.showStatus(IStatus.OK, null);
		}
	}

	private static String getStatusMessage(IStatus status) {
		String message = status.isMultiStatus() ? status.getChildren()[0].getMessage() : status
				.getMessage();
		return message;
	}

	/**
	 * @param control
	 * @param enabled
	 */
	private void setEnablement(Control control, boolean enabled) {
		if (control.isEnabled() != enabled) {
			control.setEnabled(enabled);
		}
		setDependentControlEnablement(control, enabled);
	}

	//	private void setEnablement(final String propertyName, final boolean enabled) {
	//		if (propertyToWidgetHash != null) {
	//			Display.getDefault().syncExec(new Runnable() {
	//				public void run() {
	//					Control control = (Control) propertyToWidgetHash.get(propertyName);
	//					if (control != null) {
	//						setEnablement(control, enabled);
	//					}
	//				}
	//			});
	//		}
	//	}

	/**
	 * @param control
	 * @param enabled
	 */
	private void setDependentControlEnablement(Control control, boolean enabled) {
		if (widgetToDepControls != null) {
			Control[] dependents = widgetToDepControls.get(control);
			if (dependents != null) {
				Control dep = null;
				for (int i = 0; i < dependents.length; i++) {
					dep = dependents[i];
					if (dep.isEnabled() != enabled) {
						dep.setEnabled(enabled);
					}
				}
			}
		}
	}

	private void setWidgetValue(EStructuralFeature esf, CompositeForDmoComposite avlc) {
		avlc.showValue(/* model, esf */);
	}

	private void setWidgetValue(EStructuralFeature propertyName, Button button) {
		if ((button.getStyle() & SWT.CHECK) == SWT.CHECK
				|| (button.getStyle() & SWT.RADIO) == SWT.RADIO) {
			boolean checked = model.getBooleanProperty(propertyName);
			if (button.getSelection() != checked) {
				button.setSelection(checked);
			}
		}
	}

	private void setWidgetValue(EStructuralFeature propertyName, Combo combo) {
		if (combo.getItemCount() == 0 || model.validPropertyDescriptorsChanged(propertyName)) {
			// Display properties should only fire if the contents change.
			PropertyDescriptor[] descriptors = model.getValidPropertyDescriptors(propertyName);
			String[] items = new String[descriptors.length];
			for (int i = 0; i < descriptors.length; i++) {
				items[i] = descriptors[i].getPropertyText();
			}
			combo.setItems(items);
		}
		String newText = model.getPropertyDescriptor(propertyName).getPropertyText();
		int selIndex = combo.getSelectionIndex();
		if (selIndex < 0 || !newText.equals(combo.getItem(selIndex))) {
			String[] items = combo.getItems();
			for (int i = 0; i < items.length; i++) {
				if (items[i].equals(newText)) {
					combo.select(i);
					return;
				}
			}
		}
		combo.setText(newText);
	}

	private void setWidgetValue(EStructuralFeature propertyName, CCombo combo) {
		if (combo.getItemCount() == 0 || model.validPropertyDescriptorsChanged(propertyName)) {
			// Display properties should only fire if the contents change.
			PropertyDescriptor[] descriptors = model.getValidPropertyDescriptors(propertyName);
			String[] items = new String[descriptors.length];
			for (int i = 0; i < descriptors.length; i++) {
				items[i] = descriptors[i].getPropertyText();
			}
			combo.setItems(items);
		}
		String newText = model.getPropertyDescriptor(propertyName).getPropertyText();
		int selIndex = combo.getSelectionIndex();
		if (selIndex < 0 || !newText.equals(combo.getItem(selIndex))) {
			String[] items = combo.getItems();
			for (int i = 0; i < items.length; i++) {
				if (items[i].equals(newText)) {
					combo.select(i);
					return;
				}
			}
		}
		combo.setText(newText);
	}

	private void setWidgetValue(EStructuralFeature propertyName, Text text) {
		String newText = model.getStringProperty(propertyName);
		//TODO newText should not be returning null-- need to investigate for capabilities
		if (newText != null && !newText.equals(text.getText())) {
			int caretPos = text.getCaretPosition();
			text.setText(newText);
			if (caretPos > 0) {
				//set caret at the end of the new text
				text.setSelection(newText.length());
			}
		}
	}

	private void setWidgetValue(EStructuralFeature propertyName, Table table) {
		Object[] elements = (Object[]) model.getProperty(propertyName);
		if (elements == null || elements.length == 0) {
			setTableItemsChecked(table.getItems(), false);
			return;
		}
		List elementList = Arrays.asList(elements);
		TableItem[] tableItems = table.getItems();
		for (int i = 0; i < tableItems.length; i++) {
			TableItem item = tableItems[i];
			if (elementList.contains(item.getData())) {
				item.setChecked(true);
			} else {
				item.setChecked(false);
			}
		}
	}

	private void setTableItemsChecked(TableItem[] tableItems, boolean b) {
		for (int i = 0; i < tableItems.length; i++) {
			tableItems[i].setChecked(b);
		}
	}

	private void setWidgetValue(EStructuralFeature propertyName, Tree tree) {
		Object[] elements = (Object[]) model.getProperty(propertyName);
		if (elements == null) {
			return;
		}
		List elementList = Arrays.asList(elements);
		TreeItem[] treeItems = tree.getItems();
		if (elementList.size() == 0) {
			setTreeItemsGrey(treeItems, false);
			return;
		}
		if (treeItems.length > 0) {
			setTreeItemChecked(treeItems, elementList);
		}
	}

	public void setTreeItemsGrey(TreeItem[] treeItems, boolean b) {
		for (int i = 0; i < treeItems.length; i++) {
			TreeItem item = treeItems[i];
			item.setGrayed(b);
			setTreeItemsGrey(treeItems[i].getItems(), b);
		}
	}

	private void setTreeItemChecked(TreeItem[] treeItems, List items) {
		for (int i = 0; i < treeItems.length; i++) {
			if (items.contains(treeItems[i].getData())) {
				treeItems[i].setChecked(true);
				treeItems[i].setGrayed(false);
			} else {
				treeItems[i].setGrayed(true);
			}
			TreeItem[] childernItems = treeItems[i].getItems();
			if (childernItems.length > 0) {
				treeItems[i].setExpanded(true);
				setTreeItemChecked(childernItems, items);
			}
		}
	}

	private void setWidgetValue(EStructuralFeature propertyName, Label label) {
		String newText = model.getStringProperty(propertyName);
		if (!newText.equals(label.getText())) {
			label.setText(newText);
		}
	}

	private void setWidgetValue(EStructuralFeature propertyName, Hyperlink hyperlink) {
		String newText = model.getStringProperty(propertyName);
		if (!newText.equals(hyperlink.getText())) {
			hyperlink.setText(newText);
		}
	}

	private void setWidgetValue(EStructuralFeature propertyName, org.eclipse.swt.widgets.List list) {
		Object newContents = model.getProperty(propertyName);
		if (newContents == null) {
			list.setItems(new String[0]);
			return;
		}
		if (newContents instanceof List) {
			List modelContents = (List) newContents;
			String[] items = new String[modelContents.size()];
			for (int i = 0; i < modelContents.size(); i++) {
				items[i] = modelContents.get(i).toString();
			}
			list.setItems(items);
		} else if (newContents instanceof String[]) {
			list.setItems((String[]) newContents);
		}
	}

	public void synchAllUIWithModel() {
		if (null != propertyToWidgetHash) {
			Collection<EStructuralFeature> keys = propertyToWidgetHash.keySet();
			if (!keys.isEmpty()) {
				Iterator<EStructuralFeature> propertyNames = keys.iterator();
				//				EStructuralFeature propertyName = null;
				while (propertyNames.hasNext()) {
					synchUIWithModel(propertyNames.next());
				}
			}
		}
	}

	private void synchComposite(Widget widget, EStructuralFeature propertyName, Control[] depControls) {
		synchComposite(widget, propertyName, null, depControls);
	}

	/**
	 * Add another dependent control. Dependent controls are disabled when their owner's model
	 * property is disabled.
	 * 
	 * @param widget
	 * @param dependent
	 */
	public void addDependentControl(Widget widget, Widget dependent) {
		List<Widget> deps = new LinkedList<Widget>(Arrays.asList(widgetToDepControls.get(widget)));
		deps.add(dependent);
		widgetToDepControls.put(widget, deps.toArray(new Control[0]));

		// Defect 5732.  We now call call synchUIWithModel()/setEnablement() during field creation
		// so adding dependent controls no longer puts them into a future enablement update.  So
		// if the field is disabled, disable it now.
		List<EStructuralFeature> esf = widgetToPropertyHash.get(widget);
		if (esf.size() > 0) {
			if (!model.isPropertyEnabled(esf.get(0))) {
				if (dependent instanceof Control) {
					Control cdd = (Control) dependent;
					cdd.setEnabled(false);
				}
			}
		}
//		System.out.println("Added " + dependent + " as dependent of " + widget); //$NON-NLS-1$ //$NON-NLS-2$
	}

	private void synchComposite(Widget widget, EStructuralFeature propertyName, Label imageControl,
			Control[] depControls) {
//		if (null == widgetToPropertyHash) {
//			widgetToPropertyHash = new HashMap<Widget, List<EStructuralFeature>>();
//		}
//		if (propertyToWidgetHash == null) {
//			propertyToWidgetHash = new HashMap<EStructuralFeature, Widget>();
//		}
		if (widgetToPropertyHash.containsKey(widget)) {
			widgetToPropertyHash.get(widget).add(propertyName);
		} else {
			List<EStructuralFeature> list = new LinkedList<EStructuralFeature>();
			list.add(propertyName);
			widgetToPropertyHash.put(widget, list);
		}

		propertyToWidgetHash.put(propertyName, widget);
		if (depControls != null) {
			if (widgetToDepControls == null) {
				widgetToDepControls = new HashMap<Widget, Control[]>();
			}
			widgetToDepControls.put(widget, depControls);
//			System.out.println("Set " + Arrays.asList(depControls) + " as dependent(s) of " + widget); //$NON-NLS-1$ //$NON-NLS-2$
		}
		if (imageControl != null) {
			if (widgetToImageMap == null) {
				widgetToImageMap = new HashMap<Widget, Label>();
			}
			widgetToImageMap.put(widget, imageControl);
		}
		synchUIWithModel(propertyName);
	}

	private Map<Widget, Control[]> getWidgetToDepControls() {
		if (widgetToDepControls == null) {
			widgetToDepControls = new HashMap<Widget, Control[]>();
		}

		return widgetToDepControls;
	}

	public void synchText(Text text, EStructuralFeature propertyName, Control[] dependentControls) {
		synchText(text, propertyName, false, dependentControls);
	}

	/**
	 * Register a {@link Text} widget.
	 * 
	 * @param text
	 *           A {@link Text} widget.
	 * @param property
	 *           An {@link EStructuralFeature} to bind to.
	 * @param imageControl
	 *           A {@link Label} widget that will have an icon for the text field.
	 * @param dependentControls
	 *           An {@link Control}[] for other controls that will requirement enablement support
	 *           that is linked to this text widget.
	 */
	public void synchText(Text text, EStructuralFeature property, Label imageControl,
			Control[] dependentControls) {
		synchText(text, property, false, imageControl, dependentControls);
	}

	/**
	 * Register a {@link Text} control for sending modification events.
	 * 
	 * @param text
	 * @param propertyName
	 * @param isTimeModified
	 * @param dependentControls
	 */
	public void synchText(Text text, EStructuralFeature propertyName, boolean isTimeModified,
			Control[] dependentControls) {
		synchText(text, propertyName, isTimeModified, null, dependentControls);
	}

	/**
	 * Register a {@link Text} control for sending modification events.
	 * 
	 * @param text
	 * @param propertyName
	 * @param isTimeModified
	 * @param imageControl
	 * @param dependentControls
	 */
	public void synchText(Text text, EStructuralFeature propertyName, boolean isTimeModified,
			Label imageControl, Control[] dependentControls) {
		synchComposite(text, propertyName, imageControl, dependentControls);
		if (isTimeModified) {
			text.addModifyListener(getTimedListener());
		} else {
			text.addModifyListener(getModifyTextListener());
		}
	}

	public void synchLabel(Label label, EStructuralFeature propertyName, Control[] dependentControls) {
		synchComposite(label, propertyName, dependentControls);
	}

	public void synchLabel(Label label, EStructuralFeature propertyName, Label imageControl,
			Control[] dependentControls) {
		synchComposite(label, propertyName, imageControl, dependentControls);
	}

	public void synchHyperlink(Hyperlink hyperLink, EStructuralFeature propertyName,
			Control[] dependentControls) {
		synchComposite(hyperLink, propertyName, dependentControls);
	}

	/**
	 * Use this to synch the contents of the <code>list</code> to the List elements returned from
	 * the <code>propertyName</code>.
	 */
	public void synchList(org.eclipse.swt.widgets.List list, EStructuralFeature propertyName,
			Control[] dependentControls) {
		synchComposite(list, propertyName, dependentControls);
	}

	/**
	 * Use this to synch the value of the specified Combo with the specified propertyName. The
	 * possible values displayed to the user are determined by return of
	 * IDataModel.getValidPropertyDescriptors(String).
	 * 
	 * @param combo
	 * @param propertyName
	 * @param dependentControls
	 */
	public void synchCombo(Combo combo, EStructuralFeature propertyName, Control[] dependentControls) {
		synchComposite(combo, propertyName, dependentControls);
		if (null == comboListener) {
			comboListener = new ComboListener(/* false */);
		}
		combo.addSelectionListener(comboListener);
		combo.addModifyListener(comboListener);
	}

	/**
	 * Use this to synch the value of the specified Combo with the specified propertyName. The
	 * possible values displayed to the user are determined by return of
	 * IDataModel.getValidPropertyDescriptors(String).
	 * 
	 * @param combo
	 * @param propertyName
	 * @param imageControl
	 *           A {@link Label} that will have an icon synchronized with the combo value.
	 * @param dependentControls
	 */
	public void synchCombo(Combo combo, EStructuralFeature propertyName, Label imageControl,
			Control[] dependentControls) {
		synchComposite(combo, propertyName, imageControl, dependentControls);
		if (null == comboListener) {
			comboListener = new ComboListener(/* false */);
		}
		combo.addSelectionListener(comboListener);
		combo.addModifyListener(comboListener);
	}

	/**
	 * Use this to synch the value of the specified Combo with the specified propertyName. The
	 * possible values displayed to the user are determined by return of
	 * IDataModel.getValidPropertyDescriptors(String).
	 * 
	 * @param combo
	 * @param propertyName
	 * @param dependentControls
	 */
	public void synchCombo(CCombo combo, EStructuralFeature propertyName, Control[] dependentControls) {
		this.synchCombo(combo, propertyName, null, dependentControls);
	}

	/**
	 * Use this to synch the value of the specified Combo with the specified propertyName. The
	 * possible values displayed to the user are determined by return of
	 * IDataModel.getValidPropertyDescriptors(String).
	 * 
	 * @param combo
	 * @param propertyName
	 * @param imageControl
	 *           The {@link Label} used to display an image for the value of the combo.
	 * @param dependentControls
	 */
	public void synchCombo(CCombo combo, EStructuralFeature propertyName, Label imageControl,
			Control[] dependentControls) {
		synchComposite(combo, propertyName, imageControl, dependentControls);
		if (null == comboListener) {
			comboListener = new ComboListener(/* true */);
		}
		combo.addSelectionListener(comboListener);
		combo.addModifyListener(comboListener);
	}

//	/**
//	 * Use this to get error marking on the control that represents an EMF EList.
//	 * 
//	 * @param control
//	 * @param propertyName
//	 * @param dependentControls
//	 */
//	public void synchPopupList(Button control, EStructuralFeature propertyName,
//			Control[] dependentControls) {
//		// We don't want to sync, because ELists already have a listening Label
//		synchComposite(control, propertyName, dependentControls);
//		control.addSelectionListener(getPopupSelectionListener());
//	}

	/**
	 * Use this to get error marking on the control that represents an EMF EList.
	 * 
	 * @param control
	 * @param propertyName
	 * @param dependentControls
	 */
	public void synchPopupList(Widget avlc, EAttribute attribute, Control[] dependentControls) {
		assert avlc instanceof CompositeForDmoComposite;

		CompositeForDmoComposite cfdc = (CompositeForDmoComposite) avlc;
		cfdc.setup(model, attribute);

		//@6876: Problems adding URL Patterns to URL Service
		//We have to set the model prior to synching.
		synchComposite(avlc, attribute, dependentControls);
	}

//	private SelectionListener getPopupSelectionListener() {
//		if (null == popupSelectionListener) {
//			popupSelectionListener = new PopupSelectionListener();
//		}
//
//		return popupSelectionListener;
//	}

	/**
	 * Use this to sync the state of the specified checkbox with the value of the specified
	 * propertyName. The specified propertyName must contain a java.lang.Boolean typed Object.
	 * 
	 * @param checkbox
	 * @param propertyName
	 * @param dependentControls
	 */
	public void synchCheckbox(Button checkbox, EStructuralFeature propertyName,
			Control[] dependentControls) {
		synchComposite(checkbox, propertyName, dependentControls);
		if (null == checkboxSelectionListener) {
			checkboxSelectionListener = new CheckboxSelectionListener();
		}
		checkbox.addSelectionListener(checkboxSelectionListener);
	}

	public void synchCheckBoxTableViewer(CheckboxTableViewer tableViewer,
			EStructuralFeature propertyName, Control[] dependentControls) {
		synchComposite(tableViewer.getControl(), propertyName, dependentControls);
		if (null == checkBoxViewerStateListener) {
			checkBoxViewerStateListener = new CheckBoxViewerListener();
		}
		tableViewer.addCheckStateListener(checkBoxViewerStateListener);
	}

	public void synchCheckBoxTreeViewer(CheckboxTreeViewer treeViewer,
			EStructuralFeature propertyName, Control[] dependentControls) {
		treeViewer.expandAll();
		synchComposite(treeViewer.getControl(), propertyName, dependentControls);
		if (null == checkBoxViewerStateListener) {
			checkBoxViewerStateListener = new CheckBoxViewerListener();
		}
		treeViewer.addCheckStateListener(checkBoxViewerStateListener);
	}

	public void synchRadio(Button radio, EStructuralFeature propertyName, Control[] dependentControls) {
		synchCheckbox(radio, propertyName, dependentControls); //Use checkbox
	}

	private TimedModifyListener getTimedListener() {
		if (timedModifyListener == null) {
			timedModifyListener = new DmoTimedModifyListener();
		}
		return timedModifyListener;
	}

	private void setTextProperty(EStructuralFeature esf, Text text) {
		convertAndSetProperty(esf, text.getText());
	}

	private void convertAndSetProperty(EStructuralFeature esf, String value) {
//		Object newValue = converter.convertValue(value, esf);
		Object newValue = null;
		if (esf instanceof EAttribute) {
			try {
				newValue = EcoreUtil.createFromString(((EAttribute) esf).getEAttributeType(), value);
			} catch (NumberFormatException e) {
				newValue = ConvertedValue.parse(value, (EAttribute) esf);
			}
		} else {
			newValue = value;
		}
		//5297:  If an empty string then unset the model value.
		if (newValue != null && newValue instanceof String && ((String) newValue).length() == 0) {
			//Setting to null will cause an unset.
			newValue = null;
		}
		setProperty(esf, newValue);
	}

	private ModifyTextListener getModifyTextListener() {
		if (null == modifyTextListener) {
			modifyTextListener = new ModifyTextListener();
		}
		return modifyTextListener;
	}

	/**
	 * Clean up and shut down this helper.
	 */
	public synchronized void dispose() {
		//4907
		if (timedModifyListener != null) {
			//Force the posting of the event.
			timedModifyListener.forcePost();
		}
		if (contract != null) {
			contract.eAdapters().remove(this);
			contract = null;
		}

		if (model != null) {
			model.dispose();
		}

		checkboxSelectionListener = null;
		currentWidget = null;
		modifyTextListener = null;
		timedModifyListener = null;
		widgetToDepControls = null;
	}

	public Notifier getTarget() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isAdapterForType(Object type) {
		// TODO Auto-generated method stub
		return false;
	}

	public void notifyChanged(Notification notification) {
		synchUIWithModel((EStructuralFeature) notification.getFeature());
	}

	public void setTarget(Notifier newTarget) {
		// TODO Auto-generated method stub

	}

	private static Image getDecorationImage(String key) {
		FieldDecoration originalDec = FieldDecorationRegistry.getDefault().getFieldDecoration(key);
		return originalDec != null ? originalDec.getImage() : null;
	}

	/**
	 * Registers a decorated field based on the Estructural feature. Registered fields get UI status
	 * indications when {@link DeployModelObject#getStatus()} indicates they are the cause of a
	 * validation problem.
	 * 
	 * @param decor
	 * @param propertyName
	 */
	public void registerDecoratedField(DecoratedField decor, EStructuralFeature propertyName) {
		FieldDecoration fieldDec = new FieldDecoration(
				getDecorationImage(FieldDecorationRegistry.DEC_WARNING), null);
		decor.addFieldDecoration(fieldDec, SWT.LEFT | SWT.BOTTOM, false);
		allProps.put(propertyName, new FieldAndStatusDec(decor, fieldDec));
	}

	// TODO Make this a public class?
	private static class FieldAndStatusDec {

		private final DecoratedField decor;
		private final FieldDecoration fieldDec;

		protected FieldAndStatusDec(DecoratedField decor, FieldDecoration fieldDec) {
			this.decor = decor;
			this.fieldDec = fieldDec;
		}

		private void showStatus(int severity, String message) {
			fieldDec.setDescription(message);
			fieldDec.setImage(getStatusImage(severity));
			decor.updateDecoration(fieldDec);
		}

		private Image getStatusImage(int status) {
			if (status == IStatus.ERROR) {
				return getErrorDecorationImage();
			} else if (status == IStatus.WARNING) {
				return getWarningDecorationImage();
			} else if (status == IStatus.INFO) {
				return getInfoDecorationImage();
			}

			// IStatus.OK, etc.
			return null;
		}

		private Image getInfoDecorationImage() {
			return getDecorationImage(FieldDecorationRegistry.DEC_INFORMATION);
		}

		private Image getWarningDecorationImage() {
			return getDecorationImage(FieldDecorationRegistry.DEC_WARNING);
		}

		private Image getErrorDecorationImage() {
			return getDecorationImage(FieldDecorationRegistry.DEC_ERROR);
		}

	} // end static inner class FieldAndStatusDec

	private boolean hasInput() {
//		return model != null && model.dmo != null;
		return model != null && model.hasInput();
	}

	/**
	 * @return <code>true</code> if the helper is doing something complex, like hosting another UI,
	 *         and requesting that it's UI behave modally
	 * @deprecated
	 */
	public boolean isModal() {
		return modal;
	}

} // end class DmoSyncHelper
