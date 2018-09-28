/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.statusview.filter;

import java.util.Collection;
import java.util.List;
import java.util.Vector;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.IWorkingSetSelectionDialog;

import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.FieldMessage;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.IStatusField;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.Messages;
import com.ibm.ccl.soa.deploy.core.ui.internal.statusview.Util;

/**
 * 
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */

public class FilterDialog extends TrayDialog {

	/**
	 * button IDs
	 */
	protected static final int RESET_ID = IDialogConstants.CLIENT_ID;

	protected class FieldValueGroup {
		private Button enablementButton;

		private Combo combo;

		private Text description;

		private String contains = Messages.Combo_Contains;

		private String doesNotContain = Messages.Combo_Does_Not_Contain;

		/**
		 * Create a descriptor group.
		 * 
		 * @param parent
		 * @param field
		 */
		public FieldValueGroup(Composite parent, IStatusField field) {
			Composite descriptionComposite = new Composite(parent, SWT.NONE);
			descriptionComposite.setLayout(new GridLayout(2, false));
			descriptionComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			enablementButton = createCheckButton(descriptionComposite, field.getColumnHeaderText(),
					updateSelectionListener);

			combo = new Combo(descriptionComposite, SWT.READ_ONLY);
			combo.setFont(parent.getFont());
			combo.add(contains);
			combo.add(doesNotContain);
			combo.addSelectionListener(updateSelectionListener);
			// Prevent Esc and Return from closing the dialog when the combo is
			// active.
			combo.addTraverseListener(new TraverseListener() {
				public void keyTraversed(TraverseEvent e) {
					if (e.detail == SWT.TRAVERSE_ESCAPE || e.detail == SWT.TRAVERSE_RETURN) {
						e.doit = false;
					}
				}
			});

			description = new Text(descriptionComposite, SWT.SINGLE | SWT.BORDER);
			description.setFont(parent.getFont());
			GridData data = new GridData(GridData.FILL_HORIZONTAL);
			data.horizontalSpan = 2;

			description.setLayoutData(data);
			description.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent e) {
					markDirty();
				}
			});
		}

		protected void updateEnabledState(boolean enabled) {
			enablementButton.setEnabled(enabled);
			boolean enableCombo = enabled && enablementButton.getSelection();
			combo.setEnabled(enableCombo);
			description.setEnabled(enableCombo);

		}

		void updateUIWithStringFilter(FieldValueFilter filter) {
			enablementButton.setSelection(filter.isEnable());
			if (enablementButton.getSelection()) {
				if (filter.contains()) {
					combo.select(combo.indexOf(contains));
				} else {
					combo.select(combo.indexOf(doesNotContain));
				}
				description.setText(filter.getSearchString());
			}
		}

		void updateStringFilterWithUI(FieldValueFilter filter) {
			filter.setEnable(enablementButton.getSelection());
			if (filter.isEnable()) {
				filter.setContains(combo.getSelectionIndex() == combo.indexOf(contains));
				filter.setSearchString(description.getText());
			}
		}

		void reset() {
			enablementButton.setSelection(false);
		}

	}

	protected class SeverityGroup {
		private Button enablementButton;

		private Button errorButton;

		private Button warningButton;

		private Button infoButton;

		/**
		 * Create a group for severity.
		 * 
		 * @param parent
		 */
		public SeverityGroup(Composite parent) {

			Composite severityComposite = new Composite(parent, SWT.NONE);
			severityComposite.setLayout(new GridLayout(4, false));
			severityComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
					| GridData.GRAB_HORIZONTAL));

			SelectionListener severityListener = updateSelectionListener;
			enablementButton = createCheckButton(severityComposite, Messages.Button_Severity,
					severityListener);

			errorButton = createCheckButton(severityComposite, Messages.Button_Severity_Error,
					severityListener);

			warningButton = createCheckButton(severityComposite, Messages.Button_Severity_Warn,
					severityListener);
			infoButton = createCheckButton(severityComposite, Messages.Button_Severity_Info,
					severityListener);
			//updateEnabledState(true);

		}

		/**
		 * Update enablement based on the enabled flag.
		 * 
		 * @param enabled
		 */
		public void updateEnablement(boolean enabled) {

			boolean showingSeverity = enablementButton.getSelection() && enabled;
			enablementButton.setEnabled(enabled);

			errorButton.setEnabled(showingSeverity);
			warningButton.setEnabled(showingSeverity);
			infoButton.setEnabled(showingSeverity);

		}

		void updateUIWithSeverityFilter(SeverityFilter filter) {
			enablementButton.setSelection(filter.isEnabled());
			boolean selection = (filter.getInterestedSeverities() & IStatus.ERROR) != 0;
			errorButton.setSelection(selection);
			selection = (filter.getInterestedSeverities() & IStatus.WARNING) != 0;
			warningButton.setSelection(selection);
			selection = (filter.getInterestedSeverities() & IStatus.INFO) != 0;
			infoButton.setSelection(selection);
		}

		void updateSeverityFilterWithUI(SeverityFilter filter) {
			filter.setEnabled(enablementButton.getSelection());
			int severity = 0;
			severity = errorButton.getSelection() ? severity | IStatus.ERROR : severity;
			severity = warningButton.getSelection() ? severity | IStatus.WARNING : severity;
			severity = infoButton.getSelection() ? severity | IStatus.INFO : severity;
			filter.setInterestedSeverities(severity);
		}

		void reset() {
			updateEnablement(false);

		}
	}

	/**
	 * Creates and manages a group of widgets for selecting a working set marker filter.
	 */
	private class ResourceGroup {

		private Button onSelectWorkingSetButton;

		private Button selectWorkingSetButton;
		private Button onAnyResourceButton;
		private Button onSelectedResourceButton;

		/**
		 * Creates the working set filter selection widgets.
		 * 
		 * @param parent
		 *           the parent composite of the working set widgets
		 */
		ResourceGroup(Composite parent) {
			// radio button has to be part of main radio button group
			Composite group = new Composite(parent, SWT.NONE);
			group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			group.setLayout(new GridLayout());
			group.setFont(parent.getFont());
			onAnyResourceButton = createRadioButton(group, Messages.Button_Resource_Any);

			onSelectedResourceButton = createRadioButton(group, Messages.Button_Resource_Selected);
			onSelectWorkingSetButton = createRadioButton(group, NLS.bind(
					Messages.Button_Resource_WorkingSet, Messages.Button_Resource_NoWorkingSet));
			GridData data = new GridData(GridData.FILL_HORIZONTAL);
			onSelectWorkingSetButton.setLayoutData(data);

			Composite composite = new Composite(parent, SWT.NONE);
			composite.setFont(parent.getFont());
			GridLayout layout = new GridLayout();
			Button radio = new Button(parent, SWT.RADIO);
			layout.marginWidth = radio.computeSize(SWT.DEFAULT, SWT.DEFAULT).x;
			layout.marginHeight = 0;
			radio.dispose();
			composite.setLayout(layout);
			selectWorkingSetButton = createPushButton(composite, Messages.Button_Select_More);
			selectWorkingSetButton.addSelectionListener(new SelectionAdapter() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
				 */
				public void widgetSelected(SelectionEvent e) {
					selectPressed();
				}

			});
		}

		/**
		 * Returns wether or not a working set filter should be used
		 * 
		 * @return true=a working set filter should be used false=a working set filter should not be
		 *         used
		 */
		boolean getSelection() {
			return onSelectWorkingSetButton.getSelection();
		}

		/**
		 * Returns the selected working set filter or null if none is selected.
		 * 
		 * @return the selected working set filter or null if none is selected.
		 */
		IWorkingSet getWorkingSet() {
			return (IWorkingSet) onSelectWorkingSetButton.getData();
		}

		/**
		 * Sets the working set filter selection.
		 * 
		 * @param selected
		 *           true=a working set filter should be used false=no working set filter should be
		 *           used
		 */
		void setSelection(boolean selected) {
			onSelectWorkingSetButton.setSelection(selected);
			if (selected) {
				onAnyResourceButton.setSelection(false);
				onSelectedResourceButton.setSelection(false);
			}
		}

		/**
		 * Opens the working set selection dialog.
		 */
		void selectPressed() {
			IWorkingSetSelectionDialog dialog = PlatformUI.getWorkbench().getWorkingSetManager()
					.createWorkingSetSelectionDialog(getShell(), false);
			IWorkingSet workingSet = getWorkingSet();

			if (workingSet != null) {
				dialog.setSelection(new IWorkingSet[] { workingSet });
			}
			if (dialog.open() == Window.OK) {
				markDirty();
				IWorkingSet[] result = dialog.getSelection();
				if (result != null && result.length > 0) {
					setWorkingSet(result[0]);
				} else {
					setWorkingSet(null);
				}
				if (getSelection() == false) {
					setSelection(true);
				}
			}
		}

		/**
		 * Sets the specified working set.
		 * 
		 * @param workingSet
		 *           the working set
		 */
		void setWorkingSet(IWorkingSet workingSet) {
			onSelectWorkingSetButton.setData(workingSet);
			if (workingSet != null) {
				onSelectWorkingSetButton.setText(NLS.bind(Messages.Button_Resource_WorkingSet,
						workingSet.getLabel()));
			} else {
				onSelectWorkingSetButton.setText(NLS.bind(Messages.Button_Resource_WorkingSet,
						Messages.Button_Resource_NoWorkingSet));
			}
		}

		void setEnabled(boolean enabled) {

			onSelectWorkingSetButton.setEnabled(enabled);
			selectWorkingSetButton.setEnabled(enabled);
		}

		void updateEnabledState(boolean enabled) {
			onAnyResourceButton.setEnabled(enabled);
			onSelectedResourceButton.setEnabled(enabled);
			onSelectWorkingSetButton.setEnabled(enabled);
			if (onSelectWorkingSetButton.getSelection() && enabled) {
				selectWorkingSetButton.setEnabled(true);
			} else {
				selectWorkingSetButton.setEnabled(false);
			}

		}

		void updateUIWithFilter(FilterConfig filter) {
			int focus = filter.getFocus();
			onAnyResourceButton.setSelection(focus == FilterConfig.Focus_On_Any);
			onSelectedResourceButton.setSelection(focus == FilterConfig.Focus_On_Selected);
			onSelectWorkingSetButton.setSelection(focus == FilterConfig.Focus_On_WorkingSet);
			if (onSelectWorkingSetButton.getSelection()) {
				setWorkingSet(Util.getWorkingSet(filter.getSelectedWorkingSetName()));
			}
		}

		void updateFilterWithUI(FilterConfig filter) {

			if (onAnyResourceButton.getSelection()) {
				filter.setFocus(FilterConfig.Focus_On_Any);
			} else if (onSelectedResourceButton.getSelection()) {
				filter.setFocus(FilterConfig.Focus_On_Selected);
			} else if (onSelectWorkingSetButton.getSelection()) {
				filter.setFocus(FilterConfig.Focus_On_WorkingSet);
				filter.setSelectedWorkingSetName(getWorkingSet().getName());

			}

		}

		void reset() {
			onAnyResourceButton.setSelection(true);
		}
	}

	protected class EntryListGroup {
		Button enablementButton;
		CheckboxTableViewer tableList;
		Composite listArea;

		IStatusField field;

		/**
		 * 
		 * @param parent
		 * @param field
		 */
		public EntryListGroup(Composite parent, IStatusField field) {
			this.field = field;
			Composite entryListComposite = new Composite(parent, SWT.NONE);
			entryListComposite.setLayout(new GridLayout(1, false));
			entryListComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
					| GridData.GRAB_HORIZONTAL));

			SelectionListener listener = updateSelectionListener;

			enablementButton = new Button(entryListComposite, SWT.CHECK);
			GridData data = new GridData(GridData.FILL_HORIZONTAL);
			enablementButton.setLayoutData(data);
			enablementButton.setFont(parent.getFont());
			enablementButton.setText(NLS.bind(Messages.Button_Entry_Enablement, field
					.getColumnHeaderText()));
			enablementButton.addSelectionListener(listener);

			setButtonLayoutData(enablementButton);
			listArea = createEntryListArea(entryListComposite, field.getColumnHeaderText());
		}

		protected Composite createEntryListArea(Composite parent, String text) {

			Button selectAllButton;
			Button deselectAllButton;
			Composite listArea = new Composite(parent, SWT.NONE);
			listArea.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			listArea.setLayout(new GridLayout());
			listArea.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

			Label title = new Label(listArea, SWT.NONE);
			title.setText(text);
			GridData titleData = new GridData();
			titleData.horizontalSpan = 2;
			title.setLayoutData(titleData);
			tableList = CheckboxTableViewer.newCheckList(listArea, SWT.BORDER);
			GridData listData = new GridData(SWT.FILL, SWT.FILL, true, true);
			listData.widthHint = convertHorizontalDLUsToPixels(100);
			tableList.getControl().setLayoutData(listData);
			Composite buttons = new Composite(listArea, SWT.NONE);
			GridLayout buttonLayout = new GridLayout(2, false);
			buttonLayout.marginWidth = 0;
			buttons.setLayout(buttonLayout);
			selectAllButton = createPushButton(buttons, Messages.Button_Select_All);
			deselectAllButton = createPushButton(buttons, Messages.Button_Deselect_All);
			selectAllButton.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					tableList.setAllChecked(true);
					updateForSelection();
				}
			});
			deselectAllButton.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					tableList.setAllChecked(false);
					updateForSelection();
				}
			});
			tableList.setContentProvider(new IStructuredContentProvider() {

				public Object[] getElements(Object inputElement) {
					return field.getEntries().toArray();
				}

				public void dispose() {

				}

				public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

				}

			});
			tableList.addCheckStateListener(new ICheckStateListener() {

				public void checkStateChanged(CheckStateChangedEvent event) {
					updateForSelection();

				}

			});
			tableList.setLabelProvider(new LabelProvider());
			tableList.setInput(this);
			return listArea;
		}

		protected void updateEnabledState(boolean enabled) {
			enablementButton.setEnabled(enabled);
			boolean enableListArea = enabled && enablementButton.getSelection();
			listArea.setVisible(enableListArea);
		}

		void updateUIWithFilter(FieldEntryFilter filter) {

			enablementButton.setSelection(filter.isEnable());
			updateEnabledState(true);
			tableList.setCheckedElements(filter.getEntryList().toArray());

		}

		void updateFilterWithUI(FieldEntryFilter filter) {
			filter.setEnable(enablementButton.getSelection());
			Object[] checkedElements = tableList.getCheckedElements();
			filter.getEntryList().clear();
			for (int i = 0; i < checkedElements.length; i++) {
				filter.getEntryList().add(checkedElements[i]);
			}
		}

		void reset() {
			enablementButton.setSelection(false);
		}
	}

	protected class FilterListGroup {
		private CheckboxTableViewer tableList;

		/**
		 * Create the area for the user to select thier filters.
		 * 
		 * @param listArea
		 */
		void createUserFiltersArea(Composite listArea) {

			Composite userComposite = new Composite(listArea, SWT.NONE);
			userComposite.setLayout(new GridLayout(2, false));
			userComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

			Label title = new Label(userComposite, SWT.NONE);
			title.setText(Messages.Filter_Area_UserFilter_Label);
			GridData titleData = new GridData();
			titleData.horizontalSpan = 2;
			title.setLayoutData(titleData);

			tableList = CheckboxTableViewer.newCheckList(userComposite, SWT.BORDER);
			tableList.setContentProvider(new IStructuredContentProvider() {
				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
				 */
				public Object[] getElements(Object inputElement) {
					return filters;
				}

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
				 */
				public void dispose() {
					// Do nothing
				}

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer,
				 *      java.lang.Object, java.lang.Object)
				 */
				public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
					// Do nothing
				}
			});
			tableList.setLabelProvider(new LabelProvider() {
				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
				 */
				public String getText(Object element) {
					return ((FilterConfig) element).getName();
				}
			});

			checkedFilters = new FilterConfig[] { filters[0] };
			tableList.setSelection(new StructuredSelection(checkedFilters));
			tableList.addCheckStateListener(new ICheckStateListener() {

				public void checkStateChanged(CheckStateChangedEvent event) {
					FilterConfig filter = (FilterConfig) event.getElement();
					boolean checked = event.getChecked();
					filter.setEnabled(checked);
					markDirty();
				}

			});
			tableList.addSelectionChangedListener(new ISelectionChangedListener() {

				/*
				 * (non-Javadoc)
				 * 
				 * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
				 */
				public void selectionChanged(SelectionChangedEvent event) {
					updateFilterFromUI();
					setSelectedFilter(event);

				}
			});

			tableList.setInput(this);
			for (int i = 0; i < filters.length; i++) {
				tableList.setChecked(filters[i], filters[i].isEnabled());
			}

			GridData listData = new GridData(SWT.FILL, SWT.FILL, true, true);
			listData.widthHint = convertHorizontalDLUsToPixels(100);
			tableList.getControl().setLayoutData(listData);

			Composite buttons = new Composite(userComposite, SWT.NONE);
			GridLayout buttonLayout = new GridLayout(1, false);
			buttonLayout.marginWidth = 0;
			buttons.setLayout(buttonLayout);
			GridData buttonsData = new GridData();
			buttonsData.verticalAlignment = GridData.BEGINNING;
			buttons.setLayoutData(buttonsData);

			Button addNew = new Button(buttons, SWT.PUSH);
			addNew.setText(Messages.Button_New);
			addNew.addSelectionListener(new SelectionAdapter() {

				public void widgetSelected(SelectionEvent e) {
					InputDialog newDialog = new InputDialog(getShell(),
							Messages.Dialog_Add_New_Filter_Title, Messages.Dialog_Add_New_Filter_Message,
							NLS.bind(Messages.Dialog_Add_New_Filter_InitValue, new Object[] { new Integer(
									filters.length) }), new IInputValidator() {
								/*
								 * (non-Javadoc)
								 * 
								 * @see org.eclipse.jface.dialogs.IInputValidator#isValid(java.lang.String)
								 */
								public String isValid(String newText) {
									if (newText.length() == 0) {
										return Messages.Dialog_Add_New_Filter_EmptyName;
									}
									for (int i = 0; i < filters.length; i++) {
										if (filters[i].getName().equalsIgnoreCase(newText)) {
											return Messages.Dialog_Add_New_Filter_InvalidName;
										}
									}
									return null;
								}

							});
					newDialog.open();
					String newName = newDialog.getValue();
					if (newName != null) {
						createNewFilter(newName);
					}
				}
			});
			setButtonLayoutData(addNew);

			Button remove = new Button(buttons, SWT.PUSH);
			remove.setText(Messages.Button_Remove);
			remove.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					removeFilters(tableList.getSelection());
				}
			});
			setButtonLayoutData(remove);
		}

		FilterListGroup(Composite parent) {
			Composite listArea = new Composite(parent, SWT.NONE);
			listArea.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			listArea.setLayout(new GridLayout());
			createUserFiltersArea(listArea);
			Composite buttons = new Composite(listArea, SWT.NONE);
			GridLayout buttonLayout = new GridLayout(2, false);
			buttonLayout.marginWidth = 0;
			buttons.setLayout(buttonLayout);
			Button selectAllButton = createPushButton(buttons, Messages.Button_Select_All);
			Button deselectAllButton = createPushButton(buttons, Messages.Button_Deselect_All);
			selectAllButton.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					tableList.setAllChecked(true);
				}
			});
			deselectAllButton.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					tableList.setAllChecked(false);
				}
			});
		}

		/**
		 * Remove the filters in selection.
		 * 
		 * @param selection
		 */
		protected void removeFilters(ISelection selection) {
			if (selection instanceof IStructuredSelection) {
				List toRemove = ((IStructuredSelection) selection).toList();
				FilterConfig[] newFilters = new FilterConfig[filters.length - toRemove.size()];
				int index = 0;
				for (int i = 0; i < filters.length; i++) {
					if (toRemove.contains(filters[i])) {
						continue;
					}
					newFilters[index] = filters[i];
					index++;
				}

				filters = newFilters;
				tableList.refresh();
				updateUIFromFilter();
				markDirty();
			}
		}

		/**
		 * Create a new filter called newName.
		 * 
		 * @param newName
		 */
		private void createNewFilter(String newName) {
			FilterConfig[] newFilters = new FilterConfig[filters.length + 1];
			System.arraycopy(filters, 0, newFilters, 0, filters.length);
			FilterConfig filter = newFilter(newName);
			newFilters[filters.length] = filter;
			filters = newFilters;
			tableList.refresh();
			tableList.setSelection(new StructuredSelection(filter), true);
			tableList.getControl().setFocus();
			markDirty();
		}

		/**
		 * Crate a newFilter called newName with filter fields
		 * 
		 * @param newName
		 * @return FilterConfig
		 */
		protected FilterConfig newFilter(String newName) {
			IStatusField[] fields = new IStatusField[stringFields.length + entryFields.length];
			System.arraycopy(stringFields, 0, fields, 0, stringFields.length);
			System.arraycopy(entryFields, 0, fields, stringFields.length, entryFields.length);
			return new FilterConfig(newName, fields);
		}

	}

	private IStatusField[] stringFields = new IStatusField[0];
	private IStatusField[] entryFields = new IStatusField[1];
	private FilterListGroup filterListGroup;
	private FieldValueGroup[] stringGroup;
	private SeverityGroup severityGroup;
	private EntryListGroup[] entryListGroup;
	private ResourceGroup resourceGroup;

	private FilterConfig[] checkedFilters;
	private FilterConfig[] filters;

	private boolean dirty = false;
	private boolean createSelectResource = true;

	SelectionListener updateSelectionListener = new SelectionAdapter() {
		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
		 */
		public void widgetSelected(SelectionEvent e) {

			updateForSelection();
		}
	};

	/**
	 * Create a new instance of the receiver.
	 * 
	 * @param parentShell
	 * @param filtersList
	 * @param extendFilterFields
	 * @param createResource
	 *           TODO
	 */
	public FilterDialog(Shell parentShell, FilterConfig[] filtersList,
			IStatusField[] extendFilterFields, boolean createResource) {
		super(parentShell);
		this.createSelectResource = createResource;
		setFilters(filtersList);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		Vector containList = new Vector();
		Vector entryList = new Vector();
		containList.add(FieldMessage.INSTANCE);
		if (extendFilterFields != null) {
			for (int i = 0; i < extendFilterFields.length; i++) {
				if (extendFilterFields[i].hasEntry()) {
					entryList.add(extendFilterFields[i]);
				} else {
					containList.add(extendFilterFields[i]);
				}

			}
		}
		this.entryFields = new IStatusField[entryList.size()];
		entryFields = (IStatusField[]) entryList.toArray(this.entryFields);
		stringFields = new IStatusField[containList.size()];
		stringFields = (IStatusField[]) containList.toArray(stringFields);

	}

	/**
	 * Set the filters in the filtersList by copying them.
	 * 
	 * @param initialFilters
	 */
	private void setFilters(FilterConfig[] initialFilters) {
		FilterConfig[] newFilters = new FilterConfig[initialFilters.length];
		for (int i = 0; i < initialFilters.length; i++) {
			FilterConfig newFilter;
			newFilter = (FilterConfig) initialFilters[i].clone();

			newFilters[i] = newFilter;

		}
		filters = newFilters;
	}

	/**
	 * Method declared on Window.
	 */
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText(Messages.Filter_Dialog_Title);
	}

	protected void createResetArea(Composite parent) {

		Button reset = new Button(parent, SWT.PUSH);
		reset.setText(Messages.Button_Reset);
		reset.setData(new Integer(RESET_ID));

		reset.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				resetPressed();
				markDirty();
			}
		});

		GridData data = new GridData(GridData.HORIZONTAL_ALIGN_END);
		int widthHint = convertHorizontalDLUsToPixels(IDialogConstants.BUTTON_WIDTH);
		Point minSize = reset.computeSize(SWT.DEFAULT, SWT.DEFAULT, true);
		data.widthHint = Math.max(widthHint, minSize.x);
		data.horizontalSpan = 2;
		reset.setLayoutData(data);
	}

	/**
	 * Creates a check box button with the given parent and text.
	 * 
	 * @param parent
	 *           the parent composite
	 * @param text
	 *           the text for the check box
	 * @param grabRow
	 *           <code>true</code>to grab the remaining horizontal space, <code>false</code>
	 *           otherwise
	 * @return the check box button
	 */
	protected Button createCheckbox(Composite parent, String text, boolean grabRow) {
		Button button = new Button(parent, SWT.CHECK);
		if (grabRow) {
			GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
			button.setLayoutData(gridData);
		}
		button.setText(text);
		button.addSelectionListener(updateSelectionListener);
		button.setFont(parent.getFont());
		return button;
	}

	/**
	 * Creates a combo box with the given parent, items, and selection
	 * 
	 * @param parent
	 *           the parent composite
	 * @param items
	 *           the items for the combo box
	 * @param selectionIndex
	 *           the index of the item to select
	 * @return the combo box
	 */
	protected Combo createCombo(Composite parent, String[] items, int selectionIndex) {
		Combo combo = new Combo(parent, SWT.DROP_DOWN | SWT.READ_ONLY);
		combo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		combo.setFont(parent.getFont());
		combo.setItems(items);
		combo.select(selectionIndex);
		combo.addSelectionListener(updateSelectionListener);
		return combo;
	}

	/**
	 * Method declared on Dialog.
	 */
	protected Control createDialogArea(Composite parent) {

		Composite dialogArea = (Composite) super.createDialogArea(parent);

		dialogArea.setLayout(new GridLayout(2, false));

		createFilterListArea(dialogArea);//left

		createConfigFilterArea(dialogArea);//right
		createResetArea(dialogArea);
		createSeparatorLine(dialogArea);
		applyDialogFont(dialogArea);
		//filtersList.setSelection(new StructuredSelection(filters[0]));
		updateEnabledState(true);
		updateUIFromFilter();

		return dialogArea;
	}

	/**
	 * Create the list in the receiver.
	 * 
	 * @param dialogArea
	 */
	/**
	 * @param dialogArea
	 */
	protected void createFilterListArea(Composite dialogArea) {
		filterListGroup = new FilterListGroup(dialogArea);
	}

	/**
	 * Set the selected filter from event.
	 * 
	 * @param event
	 */
	protected void setSelectedFilter(SelectionChangedEvent event) {

		ISelection selection = event.getSelection();
		if (selection instanceof IStructuredSelection) {
			Collection list = ((IStructuredSelection) selection).toList();
			FilterConfig[] selected = new FilterConfig[list.size()];
			list.toArray(selected);
			checkedFilters = selected;

		} else {
			checkedFilters = new FilterConfig[0];
		}
		updateUIFromFilter();

	}

	/**
	 * Create the area for the selected filter.
	 * 
	 * @param composite
	 */
	protected Composite createConfigFilterArea(Composite composite) {
		//initialize
		//1.create on select resource composite
		Composite settingComposite = new Composite(composite, SWT.NONE);
		settingComposite.setLayout(new GridLayout(2, true));
		settingComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		Composite leftComposite = new Composite(settingComposite, SWT.NONE);
		leftComposite.setLayout(new GridLayout(1, false));
		leftComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		//2.create severity area;
		createLeftArea(leftComposite);
		if (entryFields.length > 0) {

			Composite rightComposite = new Composite(settingComposite, SWT.NONE);
			rightComposite.setLayout(new GridLayout(entryFields.length, false));
			rightComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			createRightArea(rightComposite);
		} else
			entryListGroup = new EntryListGroup[0];

		//4. create entry select area;
		return null;
	}

	private void createLeftArea(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setFont(parent.getFont());
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		GridLayout layout = new GridLayout(1, false);

		composite.setLayout(layout);
		if (createSelectResource) {
			createResourceArea(composite);
		}
		severityGroup = new SeverityGroup(composite);
		stringGroup = new FieldValueGroup[stringFields.length];
		for (int i = 0; i < stringFields.length; i++) {
			stringGroup[i] = new FieldValueGroup(composite, stringFields[i]);
		}

	}

	private void createRightArea(Composite parent) {
		if (entryFields.length > 0) {
			entryListGroup = new EntryListGroup[entryFields.length];
			for (int i = 0; i < entryFields.length; i++) {
				entryListGroup[i] = new EntryListGroup(parent, entryFields[i]);
			}
		} else
			entryListGroup = new EntryListGroup[0];
	}

	private void createResourceArea(Composite parent) {

		resourceGroup = new ResourceGroup(parent);
	}

	/**
	 * Creates a separator line above the OK/Cancel buttons bar
	 * 
	 * @param parent
	 *           the parent composite
	 */
	protected void createSeparatorLine(Composite parent) {
		// Build the separator line
		Label separator = new Label(parent, SWT.HORIZONTAL | SWT.SEPARATOR);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		separator.setLayoutData(gd);
	}

	/**
	 * Get the currently selected marker filter if there is only one selection.
	 * 
	 * @return PublishViewFilter or <code>null</code>.
	 */
	protected FilterConfig getSelectedFilter() {

		if (checkedFilters.length == 1) {
			return checkedFilters[0];
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
	 */
	protected void okPressed() {
		/**
		 * Updates the filter from the UI state. Must be done here rather than by extending open()
		 * because after super.open() is called, the widgetry is disposed.
		 */
		updateFilterFromUI();

		super.okPressed();
	}

	/**
	 * Handles a press of the Reset button. Updates the UI state to correspond to a reset filter, but
	 * doesn't actually reset our filter.
	 */
	protected void resetPressed() {

		updateEnabledState(true);
	}

	/**
	 * Updates the enabled state of the widgetry based on whether or not it is enabled.
	 */
	protected void updateEnabledState(boolean enabled) {
		if (this.createSelectResource) {
			resourceGroup.updateEnabledState(enabled);
		}
		severityGroup.updateEnablement(enabled);
		for (int i = 0; i < stringGroup.length; i++) {
			stringGroup[i].updateEnabledState(enabled);
		}
		for (int i = 0; i < entryListGroup.length; i++) {
			entryListGroup[i].updateEnabledState(enabled);
		}

	}

	/**
	 * Updates the given filter from the UI state.
	 */
	protected void updateFilterFromUI() {

		FilterConfig filter = getSelectedFilter();

		if (filter == null) {
			updateEnabledState(false);
			return;
		}

		updateFilterFromUI(filter);
	}

	/**
	 * Update the selected filter from the UI.
	 * 
	 * @param filter
	 */
	protected void updateFilterFromUI(FilterConfig filter) {
		if (createSelectResource) {
			resourceGroup.updateFilterWithUI(filter);
		}
		severityGroup.updateSeverityFilterWithUI(filter.getSeverityFilter());
		for (int i = 0; i < stringFields.length; i++) {
			FieldValueFilter fieldValueFilter = filter.getValueFilters(stringFields[i]);
			stringGroup[i].updateStringFilterWithUI(fieldValueFilter);
		}
		for (int i = 0; i < entryFields.length; i++) {
			FieldEntryFilter entryFilter = filter.getEntryListFilter(entryFields[i]);
			entryListGroup[i].updateFilterWithUI(entryFilter);
		}
	}

	/**
	 * Updates the UI state from the given filter.
	 */
	protected final void updateUIFromFilter() {

		FilterConfig filter = getSelectedFilter();
		if (filter == null) {
			updateEnabledState(false);
			return;
		}

		updateUIWithFilter(filter);
		updateEnabledState(true);
	}

	/**
	 * Update the UI with the contents of filter.
	 * 
	 * @param filter
	 */
	protected void updateUIWithFilter(FilterConfig filter) {
		if (createSelectResource) {
			resourceGroup.updateUIWithFilter(filter);
		}
		severityGroup.updateUIWithSeverityFilter(filter.getSeverityFilter());
		for (int i = 0; i < stringFields.length; i++) {
			FieldValueFilter fieldValueFilter = filter.getValueFilters(stringFields[i]);
			stringGroup[i].updateUIWithStringFilter(fieldValueFilter);
		}
		for (int i = 0; i < entryFields.length; i++) {
			FieldEntryFilter entryFilter = filter.getEntryListFilter(entryFields[i]);
			entryListGroup[i].updateUIWithFilter(entryFilter);
		}
	}

	/**
	 * @return <code>true</code> if the dirty flag has been set otherwise <code>false</code>.
	 */
	public boolean isDirty() {
		return dirty;
	}

	/**
	 * Marks the dialog as dirty.
	 */
	void markDirty() {
		dirty = true;
	}

	/**
	 * Set the marker filter.
	 * 
	 * @param newFilter
	 */
	public void setFilter(FilterConfig newFilter) {
		setFilters(new FilterConfig[] { newFilter });
		updateUIFromFilter();
	}

	/**
	 * @return the PublishViewFilter associated with the dialog.
	 */
	public FilterConfig[] getFilters() {
		return filters;
	}

	/**
	 * A selection has occured on one of the checkboxes or combos. Update.
	 * 
	 */
	protected void updateForSelection() {
		updateEnabledState(true);
		markDirty();
	}

	/**
	 * Creates a radio button with the given parent and text.
	 * 
	 * @param parent
	 *           the parent composite
	 * @param text
	 *           the text for the check box
	 * @return the radio box button
	 */
	protected Button createRadioButton(Composite parent, String text) {
		Button button = new Button(parent, SWT.RADIO);
		button.setText(text);
		button.setFont(parent.getFont());
		button.addSelectionListener(updateSelectionListener);
		return button;
	}

	protected Button createPushButton(Composite parent, String text) {
		Button newButton = new Button(parent, SWT.PUSH);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		newButton.setLayoutData(data);
		newButton.setFont(parent.getFont());
		newButton.setText(text);
		setButtonLayoutData(newButton);
		return newButton;
	}

	protected Button createCheckButton(Composite parent, String text, SelectionListener listener) {
		Button enablementButton = new Button(parent, SWT.CHECK);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		enablementButton.setLayoutData(data);
		enablementButton.setFont(parent.getFont());
		enablementButton.setText(text);
		if (listener != null)
			enablementButton.addSelectionListener(listener);
		return enablementButton;
	}

}
