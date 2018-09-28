/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.properties;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.composites.InterfaceComposite;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.RequirementLinkChangeManager.RequirementLinkChangeHandler;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.RequirementsToolBarManager.RequirementsToolBarHelper;
import com.ibm.ccl.soa.deploy.core.ui.properties.AbstractTopologyPropertySection;

/**
 * Property section for Requirement view/create/delete
 */
public class RequirementsPropertySection extends AbstractTopologyPropertySection implements
		RequirementsToolBarHelper, RequirementLinkChangeHandler {

	private RequirementsToolBarManager requirementToolBarManager;
	private boolean isNonMutableImport;
	private Unit unit;
	private RequirementsListComposite listComposite;
	private DetailRequirementComposite detailsComposite;
	private InterfaceComposite interfaceComposite;
	private Composite detailPane;
	private StackLayout detailLayout;
	private SashForm sash;
	private Composite parentComposite;

	private RequirementLinkChangeManager hostingChangeListener;
	private Label emptyRequirement;

	public void doCreateControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		parentComposite = parent;

		requirementToolBarManager = new RequirementsToolBarManager(parent, false, null, this,
				actionBars.getToolBarManager());

		TabbedPropertySheetWidgetFactory wf = getWidgetFactory();
		Composite composite = wf.createFlatFormComposite(parent);
		//Couldn't get the layout working properly without the LyingLayout.
		composite.setLayout(new LyingLayout());
		//Create composite.
		sash = new SashForm(composite, SWT.HORIZONTAL);
		//sash.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true));
		//Create list.
		listComposite = new RequirementsListComposite(sash, null, true, requirementToolBarManager
				.showHeaders(), requirementToolBarManager.showLinks());
		listComposite.setShouldResizeShell(false);
		listComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		wf.paintBordersFor(listComposite);
		//Create details.
		detailPane = wf.createComposite(sash);
		//pane2.setAlwaysShowScrollBars(false);
		detailLayout = new StackLayout();
		detailPane.setLayout(detailLayout);
		GridData data2 = new GridData(SWT.FILL, SWT.FILL, true, true);

		detailPane.setLayoutData(data2);
		detailsComposite = new DetailRequirementComposite(detailPane, SWT.None, listComposite
				.getTreeLabelProvider(), wf, false);
		detailsComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		detailsComposite.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		detailsComposite.setBackgroundMode(SWT.INHERIT_DEFAULT);
		wf.paintBordersFor(detailsComposite);

		interfaceComposite = new InterfaceComposite(detailPane, SWT.None, wf);
		detailsComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		wf.paintBordersFor(detailsComposite);

		setCsHelp();

		sash.setWeights(new int[] { 30, 70 });

		requirementToolBarManager.setRequirementListComposite(listComposite);
		setListeners();
	}

	private void setTopControl(Control control) {
		if (detailLayout != null && detailPane != null && !detailPane.isDisposed()) {
			detailLayout.topControl = control;
			detailPane.layout();
		}
	}

	private void setCsHelp() {
		if (sash != null) {
			PlatformUI.getWorkbench().getHelpSystem().setHelp(sash,
					IDeployHelpContextIds.TOPOLOGY_PROPERTIES_REQUIREMENTS_TAB);
		}
		if (parentComposite != null) {
			PlatformUI.getWorkbench().getHelpSystem().setHelp(parentComposite,
					IDeployHelpContextIds.TOPOLOGY_PROPERTIES_REQUIREMENTS_TAB);
		}
		if (listComposite != null) {
			PlatformUI.getWorkbench().getHelpSystem().setHelp(listComposite,
					IDeployHelpContextIds.TOPOLOGY_PROPERTIES_REQUIREMENTS_TAB);
		}
		if (detailsComposite != null) {
			PlatformUI.getWorkbench().getHelpSystem().setHelp(detailsComposite,
					IDeployHelpContextIds.TOPOLOGY_PROPERTIES_REQUIREMENTS_TAB);
		}
	}

	private void setListeners() {
		Listener listListener = new Listener() {
			public void handleEvent(Event event) {
				switch (event.type)
				{
				case SWT.KeyDown:
					if (event.character == SWT.DEL) {
						//The delete key was selected.  Execute the delete requirement action.
						requirementToolBarManager.invokeDeleteRequirementItem();
					}
				}
			}

		};

		listComposite.addTreeListener(SWT.KeyDown, listListener);

		listComposite.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				ISelection sel = event.getSelection();
				if (sel instanceof IStructuredSelection) {
					IStructuredSelection sSel = (IStructuredSelection) sel;
					if (sSel.isEmpty()) {
						hideRequirementDetails();
					} else if (sSel.getFirstElement() instanceof EObject) {
						handleSelectionChanged((EObject) sSel.getFirstElement());
					}
				}

			}

		});

	}

	private void handleSelectionChanged(EObject selection) {

		if (selection == null) {
			hideRequirementDetails();
		} else {
			if (selection instanceof Requirement) {
				showRequirementDetails((Requirement) selection);
			} else if (selection instanceof Interface || selection instanceof UnsetInterface) {

				showInterfaceDetails(selection);

			} else {
				hideRequirementDetails();
			}
		}
	}

	@Override
	protected void setInput(DeployModelObject input) {
		if (input instanceof Unit) {
			setInput((Unit) input);
		}
	}

	private void setInput(Unit newUnit) {
		unit = newUnit;
		isNonMutableImport = unit.getEditTopology() != unit.getTopology();
		requirementToolBarManager.setIsImport(isNonMutableImport);
		hideRequirementDetails();
		listComposite.setInput(unit, isNonMutableImport, true);
		requirementToolBarManager.setInput(unit);
		sash.layout(true);
		Object selectedObj = listComposite.selectFirst();
		if (selectedObj != null && selectedObj instanceof Requirement) {
			showRequirementDetails((Requirement) selectedObj);
		}
		registerHostingChangeListener();
	}

	private void registerHostingChangeListener() {
		if (unit != null && hostingChangeListener == null) {
			hostingChangeListener = new RequirementLinkChangeManager(unit.getEditTopology(), this);
		}
	}

	@Override
	protected ResourceSetListener createEventListener() {
		// we handle the events differently; no need to register the standard listener.
		return null;
	}

	public void refresh() {

		if (listComposite != null) {
			listComposite.refresh();
		}
	}

	@Override
	protected void addMenuActions(IMenuManager menu) {

		// Add menu actions.
		requirementToolBarManager.fillMenu(menu);
	}

	@Override
	protected void addToolBarActions(IToolBarManager toolbar) {
		//Add actions.
		requirementToolBarManager.addActionsToToolbar();
	}

	@Override
	public boolean shouldUseExtraSpace() {
		return true;
	}

	private Control getEmptyRequirement() {
		if (emptyRequirement == null) {
			emptyRequirement = new Label(detailPane, SWT.NONE);
			emptyRequirement.setBackground(getPart().getSite().getShell().getDisplay().getSystemColor(
					SWT.COLOR_WHITE));
		}
		return emptyRequirement;
	}

	public void hideRequirementDetails() {
		setTopControl(getEmptyRequirement());
	}

	public void showRequirementDetails(Requirement requirement) {
		detailsComposite.setInput(requirement);
		setTopControl(detailsComposite);
	}

	public void showInterfaceDetails(Object interfaceOBJ) {
		if (interfaceOBJ instanceof Interface || interfaceOBJ instanceof UnsetInterface) {
			interfaceComposite.setInput(interfaceOBJ);
			setTopControl(interfaceComposite);
		}
	}

	@Override
	protected void doDispose() {
		if (listComposite != null && !listComposite.isDisposed()) {
			listComposite.dispose();
		}
		if (detailsComposite != null && !detailsComposite.isDisposed()) {
			detailsComposite.dispose();
		}
		if (requirementToolBarManager != null) {
			requirementToolBarManager.dispose();
		}
		if (hostingChangeListener != null) {
			hostingChangeListener.dispose();
		}
	}

	public String getSettingsPrefix() {
		return "RequirementsPropertySection"; //$NON-NLS-1$
	}

	public void resizeForLinkColumnVisibilityChange() {
		sash.layout();
	}

	public void handleUpdateActionBars() {
		if (actionBars != null) {
			actionBars.updateActionBars();
		}
	}

	@Override
	protected void doAboutToBeShown() {
		registerHostingChangeListener();
	}

	@Override
	protected void doAboutToBeHidden() {
		if (hostingChangeListener != null) {
			hostingChangeListener.dispose();
			hostingChangeListener = null;
		}
	}

	public IStatus handleRequirementLinkChange(Notification notification) {
		if (listComposite != null) {
			listComposite.handleRequirementLinkChange(notification);
		}
		if (requirementToolBarManager != null) {
			requirementToolBarManager.handleRequirementLinkChange(notification);
		}
		if (detailsComposite != null && !detailsComposite.isDisposed()) {
			detailsComposite.handleRequirementLinkChange(notification);
		}
		return Status.OK_STATUS;
	}

}
