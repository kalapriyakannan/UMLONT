/***************************************************************************************************
 * Copyright (c) 2008 IBM Corporation. All rights reserved.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.composites;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Stereotype;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.properties.DmoSyncHelper;
import com.ibm.ccl.soa.deploy.core.ui.properties.Messages;
import com.ibm.ccl.soa.deploy.core.util.ConstraintUtil;

/**
 * This {@link Composite} will be initialized with a {@link TabFolder}.
 * 
 */
public abstract class DmoTabbedComposite extends DmoComposite {

	private CTabFolder tabFolder;
	private CTabItem constraintTab;
	private CTabItem stereotypeTab;
	private CTabItem descriptionTab;
	private CTabItem currentTab;
	private Font previousFont;
	private Font selectedTabFont;

	private StereotypesComposite stereotypesComposite;

	/**
	 * @param parent
	 * @param style
	 * @param formToolkit
	 */
	public DmoTabbedComposite(Composite parent, int style, FormToolkit formToolkit) {
		super(parent, style, formToolkit);
	}

	/**
	 * @param parent
	 * @param style
	 * @param formToolkit
	 * @param shouldInitializeContents
	 */
	public DmoTabbedComposite(Composite parent, int style, FormToolkit formToolkit,
			boolean shouldInitializeContents) {
		super(parent, style, formToolkit, shouldInitializeContents);
	}

	@Override
	protected final void initializeContents(DmoSyncHelper aSynchHelper) {
		GridLayout layout = new GridLayout();
		layout.marginWidth = 5;
		layout.marginHeight = 5;
		setLayout(layout);
		tabFolder = new CTabFolder(this, SWT.BOTTOM | SWT.FLAT);
		tabFolder.setBackgroundMode(SWT.INHERIT_DEFAULT);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		initializeTabSelectionListener();
		//tabFolder.setForeground(getDisplay().getSystemColor(SWT.COLOR_DARK_GRAY));
		initializeTabItems();
		//Set the initial tab labels to ensure the proper count.
		//Must be done after the tabs are defined.
		setConstraintTabLabel();
		setStereotypeTabLabel();
		//Set selection to the first tab.
		setSelectedTab(0);
	}

	private void setSelectedTab(int i) {
		tabFolder.setSelection(i);
		setSelectedTab(tabFolder.getItem(i));

	}

	private void initializeTabSelectionListener() {
		tabFolder.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				CTabItem selectedTab = (CTabItem) e.item;
				setSelectedTab(selectedTab);
			}
		});
	}

	protected void initializeTabItems() {
		initializeGeneralTab();
		initializeConstraintsTab();
		if (shouldAddStereotypes()) {
			initializeStereotypesTab();
		}
		initializeDescriptionTab();
	}

	protected void initializeStereotypesTab() {
		stereotypesComposite = new StereotypesComposite(tabFolder, SWT.FLAT, dmo, formToolkit);
		stereotypesComposite.addStereotypeChangeListener(new Listener() {
			public void handleEvent(Event event) {
				setStereotypeTabLabel();
			}
		});
		stereotypeTab = addTab(NLS.bind(Messages.DmoComposite_Stereotypes_0_, 0),
				stereotypesComposite);
		setStereotypeTabLabel();
	}

	private void setStereotypeTabLabel() {
		if (stereotypeTab != null && dmo != null && !stereotypeTab.isDisposed()) {
			stereotypeTab.setText(NLS.bind(Messages.DmoComposite_Stereotypes_0_, getStereotypes()
					.size()));
		}
	}

	@SuppressWarnings("unchecked")
	protected List<Stereotype> getStereotypes() {
		if (dmo instanceof Unit) {
			return ((Unit) dmo).getStereotypes();
		} else if (dmo instanceof Capability) {
			return ((Capability) dmo).getStereotypes();
		} else {
			return Collections.emptyList();
		}
	}

	protected boolean shouldAddStereotypes() {
		return false;
	}

	protected void initializeDescriptionTab() {
		//Create the composite
		Composite main = new Composite(tabFolder, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginWidth = 5;
		layout.marginHeight = 5;
		main.setLayout(layout);
		Text descriptionText = formToolkit.createText(main,
				"", SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.BORDER); //$NON-NLS-1$
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd.widthHint = 250;
		descriptionText.setLayoutData(gd);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(main,
				IDeployHelpContextIds.TOPOLOGY_PROPERTIES_DESCRIPTION_TAB);

		//Add the Tab
		descriptionTab = addTab(Messages.DmoTabbedComposite_Description_, main);

		//Synch values
		if (!(dmo instanceof Import)) {
			getSynchHelper().synchText(descriptionText,
					CorePackage.eINSTANCE.getDeployModelObject_Description(), true, null);
			getSynchHelper().addModelListener(new AdapterImpl() {
				@Override
				public void notifyChanged(Notification msg) {
					if (CorePackage.Literals.DEPLOY_MODEL_OBJECT__DESCRIPTION == msg.getFeature()) {
						setDescriptionTabLabel();
					}
				}
			});
		}
	}

	private void setDescriptionTabLabel() {
		if (descriptionTab != null && dmo != null && !descriptionTab.isDisposed()) {
			String text = dmo.getEObject().eIsSet(
					CorePackage.Literals.DEPLOY_MODEL_OBJECT__DESCRIPTION) ? Messages.DmoTabbedComposite_Description_Set
					: Messages.DmoTabbedComposite_Description_;
			descriptionTab.setText(text);
		}
	}

	protected void initializeGeneralTab() {
		Composite main = new Composite(tabFolder, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		main.setLayout(layout);
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		main.setLayoutData(gd);
		initializeScrolledMainContent(main, getSynchHelper());
		addTab(Messages.DmoTabbedComposite_Mai_, main);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(main,
				IDeployHelpContextIds.TOPOLOGY_UNIT_PROPERTIES_FLYOUT);
	}

	protected void initializeScrolledMainContent(Composite parent, DmoSyncHelper aSynchHelper) {
		ScrolledComposite scrolled = new ScrolledComposite(parent, SWT.V_SCROLL);
		scrolled.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		scrolled.setBackgroundMode(SWT.INHERIT_DEFAULT);
		Composite main = getWidgetFactory().createComposite(scrolled, SWT.NONE);
		main.setLayout(new GridLayout());
		main.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		initializeMainContent(main, aSynchHelper);

		scrolled.setContent(main);
		scrolled.setExpandVertical(true);
		scrolled.setExpandHorizontal(true);
		//Adjust min size.
		Point size = main.computeSize(SWT.DEFAULT, SWT.DEFAULT);
		scrolled.setMinHeight(size.y);
	}

	/**
	 * Subclasses should override to set the main contents. This is the content that will appear in
	 * the General tab.
	 * 
	 * @param parent
	 * @param synchHelper
	 */
	protected abstract void initializeMainContent(Composite parent, DmoSyncHelper synchHelper);

	protected void initializeConstraintsTab() {
		constraintComposite = new ConstraintComposite(tabFolder, SWT.FLAT, dmo, formToolkit);
		constraintComposite.addConstraintChangeListener(new Listener() {
			public void handleEvent(Event event) {
				setConstraintTabLabel();
			}
		});
		constraintTab = addTab(NLS.bind(Messages.DmoComposite_Constraint_, 0, constraintComposite),
				constraintComposite);
	}

	protected void setConstraintTabLabel() {
		if (constraintTab != null && dmo != null && !constraintTab.isDisposed()) {
			constraintTab
					.setText(NLS.bind(Messages.DmoComposite_Constraint_, computeConstraintSize()));
		}
	}

	/*
	 * When counting constraints we want to count leaf constraints only. Parent constraints should
	 * not be included in the count.
	 */
	private int computeConstraintSize() {
		return ConstraintUtil.computeConstraintSize(dmo);
	}

	protected CTabItem addTab(String tabName, Control tabControl) {
		CTabItem tab = null;
		if (tabName != null && tabControl != null) {
			tab = new CTabItem(tabFolder, SWT.NONE);
			tab.setText(tabName);
			tab.setControl(tabControl);
		}
		return tab;
	}

	private Font getBoldFont(CTabItem tab) {
		if (selectedTabFont == null && tab != null) {
			Font font = tab.getFont();
			FontData[] data = font.getFontData();
			for (int i = 0; i < data.length; i++) {
				data[i].setStyle(SWT.BOLD);
			}
			selectedTabFont = new Font(getDisplay(), data);
		}
		return selectedTabFont;
	}

	@Override
	public void dispose() {
		if (selectedTabFont != null) {
			selectedTabFont.dispose();
			selectedTabFont = null;
		}
		super.dispose();
	}

	private void setSelectedTab(CTabItem selectedTab) {
		if (selectedTab != currentTab) {
			setBold(currentTab, false);
			previousFont = selectedTab.getFont();
			setBold(selectedTab, true);
			currentTab = selectedTab;
		}
	}

	private void setBold(CTabItem tab, boolean b) {
		if (tab != null) {
			Font font = b ? getBoldFont(tab) : previousFont;
			if (font != null) {
				tab.setFont(font);
			}
		}
	}

	@Override
	public void setInput(Object object) {
		super.setInput(object);
		if (object instanceof DeployModelObject) {
			if (stereotypesComposite != null) {
				stereotypesComposite.setInput(dmo);
			}
			if (descriptionTab != null) {
				setDescriptionTabLabel();
			}
		}
	}

	public CTabItem[] getTabs() {
		if (tabFolder != null) {
			return tabFolder.getItems();
		}
		return null;
	}
}
