/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.properties;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.composites.AbstractCompositeFactory;
import com.ibm.ccl.soa.deploy.core.ui.composites.DmoComposite;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.composites.InterfaceComposite;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.CapabilitiesListComposite;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.CapabilitiesToolBarManager;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.LyingLayout;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.CapabilitiesToolBarManager.CapabilitiesToolBarHelper;

/**
 * Property section, on 'Capabilities' tab, for {@link Capability}s on a {@link Unit}.
 * 
 * <p>
 * This section is controlled by a &lt;propertySection&gt; entry within a
 * <code>org.eclipse.ui.views.properties.tabbed.propertySections</code> extension point.
 * 
 * @author Ed Snible <snible@us.ibm.com>
 */
public class CapabilitiesPropertySection2 extends AbstractTopologyPropertySection implements
		CapabilitiesToolBarHelper {

	private Unit unit;

	private CapabilitiesToolBarManager toolBarMgr;
	private CapabilitiesListComposite capsListComposite;

	private Composite propsWrapper;
	private StackLayout propsWrapperLayout;

	private Capability capShowing;

	private SashForm sf;

	private InterfaceComposite interfaceComposite;

	private DmoComposite compositeShowing;

	public void doCreateControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_PROPERTIES_CAPABILITIES_TAB);
		// Create a new section to wrap and layout our table
		Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		composite.setLayout(new LyingLayout());
		composite.setBackgroundMode(SWT.INHERIT_NONE);

		toolBarMgr = new CapabilitiesToolBarManager(parent, false, null, this, actionBars
				.getToolBarManager());

		/* SashForm */sf = new SashForm(composite, SWT.HORIZONTAL);
		//sf.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		createCapabilitiesPane(sf);

		createCapabilityPane(sf);

		sf.setWeights(new int[] { 1, 2 });

	}

	/** Create the list of capabilities on the left-hand side */
	private void createCapabilitiesPane(Composite parent) {
		// Create a new section to wrap and layout our table & buttons
		capsListComposite = new CapabilitiesListComposite(parent, SWT.NONE);
		capsListComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		capsListComposite.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				ISelection sel = event.getSelection();
				if (sel instanceof IStructuredSelection) {
					IStructuredSelection sSel = (IStructuredSelection) sel;
					if (sSel.isEmpty()) {
						hideCapabilityDetails();
					} else if (sSel.getFirstElement() instanceof EObject) {
						handleSelectionChanged((EObject) sSel.getFirstElement());
					}
				}
			}

		});

		Listener listListener = new Listener() {
			public void handleEvent(Event event) {
				switch (event.type)
				{
				case SWT.KeyDown:
					if (event.character == SWT.DEL) {
						//The delete key was selected.  Execute the delete requirement action.
						toolBarMgr.invokeDeleteCapabilityItem();
					}
				}
			}

		};
		capsListComposite.addTreeListener(SWT.KeyDown, listListener);

		toolBarMgr.setCapabilityListComposite(capsListComposite);
	}

	private void showInterfaceDetails(Object interfaze) {
		interfaceComposite.setInput(interfaze);
		setTopControl(interfaceComposite);
	}

	private void createCapabilityPane(Composite parent) {

		propsWrapperLayout = new StackLayout();
		propsWrapper = getWidgetFactory().createComposite(parent);
		propsWrapper.setLayout(propsWrapperLayout);

		interfaceComposite = new InterfaceComposite(propsWrapper, SWT.None, getWidgetFactory());
	}

	@Override
	protected void setInput(DeployModelObject input) {
		if (input instanceof Unit) {
			setInput((Unit) input);
		}
	}

	private void setInput(Unit input) {
		if (unit == input) {
			return;
		}
		unit = input;
		toolBarMgr.setInput(input);
		if (input != null) {
			boolean isNonMutableImport = input.getEditTopology() != input.getTopology();
			toolBarMgr.setIsImport(isNonMutableImport);
			capsListComposite.setInput(input, isNonMutableImport);
			capsListComposite.selectFirst();
			showSelectedCapability();
		}
	}

	public boolean shouldUseExtraSpace() {
		return true;
	}

	public void doAboutToBeShown() {

		refreshCaps();
	}

	protected void doAboutToBeHidden() {
		if (compositeShowing != null) {
			compositeShowing.aboutToBeHidden();
		}
	}

	public void refresh() {

	}

	@Override
	protected void addToolBarActions(IToolBarManager toolbar) {
		if (toolBarMgr != null) {
			toolBarMgr.addActionsToToolbar();
			toolBarMgr.fillMenu(actionBars.getMenuManager());
		}
	}

	private void refreshCaps() {
		if (!capsListComposite.isDisposed()) {
			capsListComposite.refresh();

			if (capsListComposite.getTreeViewer().getSelection().isEmpty()) {
				removeCapPane();

				// This happens when the list is empty.  We still need something, otherwise there may be
				// layout issues, and also a big grey rectangle.
				Label l = new Label(propsWrapper, SWT.NONE);
				l.setBackground(getPart().getSite().getShell().getDisplay().getSystemColor(
						SWT.COLOR_WHITE));
				setTopControl(l);
			}
		}
	}

	private void setTopControl(Control control) {
		propsWrapperLayout.topControl = control;
		propsWrapper.layout();
	}

	/**
	 * event listener; catches multiplexed events and routes them to us. We are interested in<br>
	 * 1. the list of Capabilities changing<br>
	 * 2. the name changing for the current capability.
	 */

	protected ResourceSetListener createEventListener() {

		return new ResourceSetListenerImpl(getFilter()) {

			public void resourceSetChanged(ResourceSetChangeEvent event) {

				boolean capsListStale = false;
				boolean extendedAttributesStale = false;

				for (Iterator<Notification> it = event.getNotifications().iterator(); it.hasNext();) {
					Notification notif = it.next();

					capsListStale |= notif.getFeature() == CorePackage.eINSTANCE
							.getUnit_CapabilityGroup();
					capsListStale |= notif.getFeature() == CorePackage.eINSTANCE
							.getInstantiation_ConfiguredCapabilityGroup();

//					System.out.println(notif.getNotifier().getClass().getName() + '/' + notif.getFeature());
					// We want to redraw if an EA is added/removed (this line seems buggy, notifications are sometimes lost...)
					extendedAttributesStale |= notif.getFeature() == CorePackage.Literals.DEPLOY_MODEL_OBJECT__EXTENDED_ATTRIBUTES;
					// We want to redraw if something on an EA has changed, like it's name or type
//					extendedAttributesStale |= ExtendedAttribute.class.isInstance(notif.getNotifier());
					if (ExtendedAttribute.class.isInstance(notif.getNotifier())) {
						// Did the name change (because the user was editing structure elsewhere?
						// Note that the user is also permitted to change the *type*, and we don't check
						// that, because there is no notification when an ExtendedAttribute's type changes.
						// See ExtendedAttributeImpl.setInstanceType() for TO DO.
						// Note that We *don't* want to redraw when the value changes (Defect 3116)
						if (notif.getFeature() == CorePackage.Literals.EXTENDED_ATTRIBUTE__NAME) {
							extendedAttributesStale = true;
						}
					}
//					System.out.println(extendedAttributesStale);
				}

				final boolean eaStale = extendedAttributesStale;
				final boolean clStale = capsListStale;

				final org.eclipse.jface.viewers.TreeViewer treeViewer = capsListComposite
						.getTreeViewer();
				if (!treeViewer.getTree().isDisposed()) {
					// If any of the notifications changed the {@link Unit#getCapabilityGroup} ref, refresh table
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							if (clStale) {
								refreshCaps();
								//	enableDisableButtons();
							}

							if (eaStale) {
								removeCapPane();
								capShowing = null;
								showSelectedCapability();
							}
						} // end method run()
					}); // end anonymous Runnable
				} // end if isDisposed

			} // end method resourceSetChanged()

			public boolean isPostcommitOnly() {
				return true;
			}

		};
	}

	protected NotificationFilter getFilter() {
		NotificationFilter retVal = NotificationFilter.createEventTypeFilter(Notification.SET).or(
				NotificationFilter.createEventTypeFilter(Notification.ADD)).or(
				NotificationFilter.createEventTypeFilter(Notification.REMOVE)).or(
				NotificationFilter.createEventTypeFilter(Notification.ADD_MANY)).or(
				NotificationFilter.createEventTypeFilter(Notification.REMOVE_MANY));
		return retVal;
	}

	/** The capability selected in the table has changed */
	private void showSelectedCapability() {
		showCapabilityDetails(getSelectedCapability());
	}

	private void removeCapPane() {

		if (compositeShowing != null) {
			compositeShowing.aboutToBeHidden();
		}

		List<Control> l = Arrays.asList(propsWrapper.getChildren());
		for (Iterator<Control> iter = l.iterator(); iter.hasNext();) {
			Control control = iter.next();
			if (control != interfaceComposite) {
				control.dispose();
				propsWrapperLayout.topControl = null;
			}
		}
		capShowing = null;
	}

	private Capability getSelectedCapability() {
		ISelection sel = capsListComposite.getTreeViewer().getSelection();
		if (sel instanceof StructuredSelection) {
			StructuredSelection ss = (StructuredSelection) sel;
			if (ss.getFirstElement() instanceof Capability) {
				return (Capability) ss.getFirstElement();
			}
		}

		return null;
	}

	private Object getSelectedObject() {
		ISelection sel = capsListComposite.getTreeViewer().getSelection();
		if (sel instanceof StructuredSelection) {
			StructuredSelection ss = (StructuredSelection) sel;
			return ss.getFirstElement();
		}

		return null;
	}

	@Override
	public void doDispose() {
		if (toolBarMgr != null) {
			toolBarMgr.dispose();
		}
	}

	public String getSettingsPrefix() {
		return "CapabilitiesPropertySection2"; //$NON-NLS-1$
	}

	public void hideCapabilityDetails() {
		removeCapPane();
	}

	public void showCapabilityDetails(Capability capToShow) {
		if (capShowing != capToShow) {
			removeCapPane();
			capShowing = capToShow;
			if (capToShow != null) {
				AbstractCompositeFactory uiShowing = DeployCoreUIPlugin.getDefault()
						.getCompositeFactoryService().findDmoUIHandlerForDmo(capToShow);

				compositeShowing = uiShowing
						.createControls(propsWrapper, capToShow, getWidgetFactory());
				compositeShowing.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
				setTopControl(compositeShowing);

				compositeShowing.aboutToBeShown();

			}

		}

	}

	public void handleUpdateActionBars() {
		if (actionBars != null) {
			actionBars.updateActionBars();
		}

	}

	private void handleSelectionChanged(EObject selection) {
		if (selection instanceof Capability) {
			showCapabilityDetails((Capability) selection);
		} else if (selection != null) {
			capShowing = null;
			showInterfaceDetails(selection);
		} else {
			//Nothing to show so ensure the details view is hidden.
			hideCapabilityDetails();
		}
	}
} // end class CapabilitiesPropertySection
