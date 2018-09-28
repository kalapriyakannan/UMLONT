/***************************************************************************************************
 * Copyright (c) 2003, 2008 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.properties;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractNotationPropertiesSection;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.osgi.util.TextProcessor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.IConstants.DecoratorSemanticConstants;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IDecoratorSemanticService;
import com.ibm.ccl.soa.deploy.core.ui.composites.DmoComposite;
import com.ibm.ccl.soa.deploy.core.ui.composites.DmoTabbedComposite;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.LyingLayout;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.UndoRedoActionGroup;
import com.ibm.ccl.soa.deploy.core.ui.navigator.deploy.TopologyDiagramNode;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployColorConstants;

/**
 * Property section, on 'Topology' tab, for topology information.
 * 
 * <p>
 * This section is controlled by a &lt;propertySection&gt; entry within a
 * <code>org.eclipse.ui.views.properties.tabbed.propertySections</code> extension point.
 * 
 * @author jswanke
 * @author Ed Snible
 */
public class TopologyPropertySection extends AbstractNotationPropertiesSection {
	protected static final boolean isLinux = System.getProperty("os.name").equals("Linux"); //$NON-NLS-1$ //$NON-NLS-2$

	private static final String delms = "./"; //$NON-NLS-1$

	// property controls
	protected Text nameText;
	private CCombo typeSemanticCombo = null;
	private Text typeDescText;
	private Label labelNamespace;
	private Label contractLabel;
	private Text contractDescText;
	private IActionBars actionBars;
	private IDecoratorSemanticService dsService;
	protected Object currentProperty;
	protected Widget currentWidget;
	protected Widget currentWidgetFromEvent;

	protected UndoRedoActionGroup undoGroup;

	// listeners
	protected boolean ignoreModifyEvent = false;
	private DmoComposite bodyComposite;

	private class ComboListener implements SelectionListener, ModifyListener {
		protected ComboListener() {
		}

		public void modifyText(ModifyEvent e) {
			if (ignoreModifyEvent) {
				return;
			}
			Widget combo = (Widget) e.getSource();
			if (currentWidget == combo) {
				return;
			}

			try {
				String text = getText(combo);
				currentWidgetFromEvent = combo;
				updateSemantic(text);
			} finally {
				currentWidgetFromEvent = null;
			}
		}

		private String getText(Widget combo) {
			if (combo instanceof CCombo) {
				return ((CCombo) combo).getText();
			} else if (combo instanceof Combo) {
				return ((Combo) combo).getText();
			}

			return null;
		}

		private int getSelectionIndex(Widget combo) {
			if (combo instanceof CCombo) {
				return ((CCombo) combo).getSelectionIndex();
			} else if (combo instanceof Combo) {
				return ((Combo) combo).getSelectionIndex();
			}

			return 0;
		}

		private String getItem(Widget combo, int selectionIndex) {
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
			int selectionIndex = getSelectionIndex(combo);
			if (selectionIndex >= 0) {
				updateSemantic(getItem(combo, selectionIndex));
			}
		}

		public void widgetDefaultSelected(SelectionEvent e) {
		}
	}

	private ComboListener comboListener;

	private Topology topology;

	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		actionBars = aTabbedPropertySheetPage.getSite().getActionBars();
	}

	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);

		if (selection instanceof IStructuredSelection) {
			IStructuredSelection iss = (IStructuredSelection) selection;
			Object sel = iss.getFirstElement();
			if (sel instanceof EditPart) {
				EditPart uep = (EditPart) sel;
				Object obj = uep.getModel();
				if (obj instanceof View) {
					View view = (View) obj;
					EObject ele = view.getElement();
					if (ele instanceof Topology) {
						setTopologyInput((Topology) ele);
					}
				}
			} else if (sel instanceof Topology) {
				setTopologyInput((Topology) sel);
			} else if (sel instanceof TopologyDiagramNode) {

				TopologyDiagramNode tdm = (TopologyDiagramNode) sel;
				if (tdm.getSaveable() != null) {
					List<IFile> modelArtifacts = tdm.getSaveable().getModelArtifacts();
					if (modelArtifacts.size() > 0 && !tdm.getSaveable().getScribbler().isClosed()) {
						Resource resource = tdm.getSaveable().getScribbler().getResource(
								modelArtifacts.get(0));
						if (resource.getContents().size() > 0) {
							EObject object = resource.getContents().get(0);
							if (object instanceof DeployCoreRoot) {
								DeployCoreRoot root = (DeployCoreRoot) object;
								setTopologyInput(root.getTopology());
							}
						}
					}
				}
			}
		} else {
			setTopologyInput(null);
		}
		updateUndoGroup();

	}

	private void setTopologyInput(Topology top) {
		if (topology == top) {
			return;
		}

		topology = top;

		if (top != null) {
			bodyComposite.setInput(topology);

			String name = topology.getDisplayName();
			//String desc = topology.getDescription();
			String typeId = topology.getDecoratorSemantic();
			String type = typeId == null || typeId.length() == 0 ? DecoratorSemanticConstants.BLANK_SEMANTIC
					: getDsService().getDecoratorSemanticName(topology.getDecoratorSemantic());
			String typeDesc = getDsService().getDecoratorSemanticDescription(type);
			if (nameText != null) {
				nameText.setText(name != null ? name : ""); //$NON-NLS-1$
				nameText.setEditable(true);
				nameText.setForeground(DeployColorConstants.enabledTextColor);

				typeSemanticCombo.setText(type != null ? type : ""); //$NON-NLS-1$
				typeDescText.setText(type != null ? typeDesc : ""); //$NON-NLS-1$
				typeSemanticCombo.setEditable(true);
				typeSemanticCombo.setForeground(DeployColorConstants.enabledTextColor);
				typeDescText.setEditable(false);
			}
			typeSemanticCombo.setText(safeText(type));
			//textSemantic.setText(safeText(type));
			String nameSpace = safeText(topology.getNamespace());
			nameSpace = TextProcessor.process(nameSpace, delms);
			labelNamespace.setText(nameSpace);
			if (topology.getConfigurationContract() != null) {
				if (topology.getConfigurationContract().getDisplayName() != null) {
					contractLabel.setText(topology.getConfigurationContract().getDisplayName());
				}
				if (topology.getConfigurationContract().getDescription() != null) {
					contractDescText.setText(topology.getConfigurationContract().getDescription());
				}
			}
		}

	}

	@Override
	protected void initializeControls(Composite parent) {
		createGeneralGroup(parent);
		//Block default scrolling action.
		parent.setLayout(new LyingLayout());
	}

	/**
	 * Create general
	 * 
	 * @param parent
	 *           - parent composite
	 */
	protected Composite createGeneralGroup(Composite parent) {
		bodyComposite = new DmoTabbedComposite(parent, SWT.BORDER, getWidgetFactory()) {
			@Override
			protected void initializeMainContent(@SuppressWarnings("hiding") Composite parent,
					DmoSyncHelper synchHelper) {
				// fill with controls
				createNamingGroup(parent);
				PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
						IDeployHelpContextIds.TOPOLOGY_PROPERTIES_NO_TOP_SEL_TOP_TAB);
			}
		};

		bodyComposite.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_WHITE));

		return bodyComposite;

	}

	/**
	 * Create naming group
	 * 
	 * @param parent
	 *           - parent composite
	 */
	protected Composite createNamingGroup(Composite parent) {
		@SuppressWarnings("hiding")
		Composite composite = getWidgetFactory().createComposite(parent);
		GridLayout layout = new GridLayout(2, false);
		composite.setLayout(layout);
		GridData compGD = new GridData(SWT.FILL, SWT.FILL, true, false);
		composite.setLayoutData(compGD);

		//Caption
		getWidgetFactory().createCLabel(composite, Messages.DetailRequirementComposite_Caption_);
		nameText = getWidgetFactory().createText(composite, ""); //$NON-NLS-1$
		GridData gd1 = new GridData(SWT.FILL, SWT.TOP, true, false);
		gd1.widthHint = 250;
		nameText.setLayoutData(gd1);
		nameText.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
			}

			public void focusLost(FocusEvent e) {
				updateName();
			}
		});

		// Namespace
		CLabel promptNamespace = getWidgetFactory().createCLabel(composite,
				Messages.TopologyPropertySection_Namespace);
		GridData gdPromptNamespace = new GridData();
		gdPromptNamespace.verticalAlignment = SWT.TOP;
		promptNamespace.setLayoutData(gdPromptNamespace);

		labelNamespace = getWidgetFactory().createLabel(composite, ""); //$NON-NLS-1$
		GridData gdNamespace = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gdNamespace.widthHint = 250;
		labelNamespace.setLayoutData(gdNamespace);

		GridData gd2 = new GridData(SWT.FILL, SWT.TOP, true, false);
		gd2.widthHint = 225;

		//Type
		getWidgetFactory().createCLabel(composite, Messages.DiagramPropertySection_TypeLabel);
		typeSemanticCombo = getWidgetFactory().createCCombo(composite, SWT.READ_ONLY | SWT.DROP_DOWN);
		typeSemanticCombo.setLayoutData(gd2);
		if (null == comboListener) {
			comboListener = new ComboListener(/* false */);
		}
		typeSemanticCombo.addSelectionListener(comboListener);

		//Type Description
		CLabel typeDescLabel = getWidgetFactory().createCLabel(composite,
				Messages.TopologyPropertySection_DecSemantic);
		GridData gdTDLabel = new GridData();
		gdTDLabel.verticalAlignment = SWT.TOP;
		typeDescLabel.setLayoutData(gdTDLabel);

		typeDescText = new Text(composite, SWT.MULTI | SWT.WRAP | SWT.READ_ONLY);
		GridData gd4 = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd4.widthHint = 225;
		gd4.heightHint = 50;
		typeDescText.setLayoutData(gd4);
		typeDescText.setBackground(parent.getBackground());

		//Contract
		CLabel contractLabelLabel = getWidgetFactory().createCLabel(composite,
				Messages.TopologyPropertySection_Contract_Type_);
		contractLabelLabel.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));
		contractLabel = getWidgetFactory().createLabel(composite, ""); //$NON-NLS-1$
		GridData gdContract = new GridData(SWT.FILL, SWT.CENTER, true, false);
		contractLabel.setLayoutData(gdContract);

		////////////// set r/o modes  /////////////////////////////////////////////////////////
		if (isReadOnly()) {
			nameText.setEditable(false);
			//descText.setEditable(false);
			nameText.setForeground(DeployColorConstants.disabledTextColor);
			//descText.setForeground(DeployColorConstants.disabledTextColor);
		}

		/*
		 * textSemantic.setEditable(false);
		 * textSemantic.setForeground(DeployColorConstants.disabledTextColor);
		 */
		typeSemanticCombo.setEditable(true);
		typeSemanticCombo.setForeground(DeployColorConstants.enabledTextColor);

		fillTypeSemanticCombo();

		//Contract Description
		CLabel contractDesc = getWidgetFactory().createCLabel(composite,
				Messages.TopologyPropertySection_Contract_Description_);
		contractDesc.setLayoutData(gdTDLabel);
		contractDescText = new Text(composite, SWT.MULTI | SWT.WRAP | SWT.READ_ONLY);

		contractDescText.setLayoutData(gd4);
		contractDescText.setEditable(false);
		contractDescText.setBackground(parent.getBackground());

		return composite;
	} // end method createNamingGroup()

	private void fillTypeSemanticCombo() {
		String[] dsNames = getDsService().getAllDecoratorSemanticNames();
		if (dsNames != null && dsNames.length > 0) {
			typeSemanticCombo.add(DecoratorSemanticConstants.BLANK_SEMANTIC);
		}
		for (int i = 0; i < dsNames.length; i++) {
			typeSemanticCombo.add(dsNames[i]);
		}

	}

	/**
	 * Update display name
	 */
	protected void updateName() {
		if (nameText.getText() != null || !nameText.getText().equals("")) { //$NON-NLS-1$
			DeployDiagramEditPart diagramEP = (DeployDiagramEditPart) getSingleInput();

			if (topology == null) {
				// No semantic element; probably caused by a bug elsewhere
				return;
			}

			if (!nameText.getText().equals(topology.getDisplayName())) {
				List<ICommand> commands = new ArrayList<ICommand>();
				commands.add(createCommand(Messages.DiagramPropertySection_SetProperty,
						((View) diagramEP.getModel()).eResource(), new Runnable() {
							public void run() {
								topology.setDisplayName(nameText.getText());
							}
						}));
				executeAsCompositeCommand(Messages.DiagramPropertySection_SetProperty, commands);
			}
		}
	}

	/**
	 * Semantic description
	 */
	protected void updateSemantic(final String text) {
		List<ICommand> commands = new ArrayList<ICommand>();
		commands.add(createCommand(Messages.DiagramPropertySection_SetProperty, topology.eResource(),
				new Runnable() {
					public void run() {
						topology.setDecoratorSemantic(getDsService().getDecoratorSemanticId(text));
						getDsService().fireDecoratorSemanticChanged();
						updateTypeDescText();
					}

				}));
		executeAsCompositeCommand(Messages.DiagramPropertySection_SetProperty, commands);

	}

	@Override
	protected CommandResult executeAsCompositeCommand(String actionName, List commands) {

		CompositeCommand command = new CompositeCommand(actionName, commands);
		PropertyUtils.executeWithUndo(topology, command);
		refresh();
		return CommandResult.newOKCommandResult();
	}

	private void updateTypeDescText() {
		if (typeDescText != null && !typeDescText.isDisposed()) {
			String typeId = topology.getDecoratorSemantic();
			String type = typeId == null || typeId.length() == 0 ? DecoratorSemanticConstants.BLANK_SEMANTIC
					: getDsService().getDecoratorSemanticName(typeId);
			typeDescText.setText(getDsService().getDecoratorSemanticDescription(type));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.wst.common.ui.properties.internal.provisional.ISection#refresh()
	 */
	public void refresh() {
		super.refresh();

		if (!isDisposed()) {
			actionBars.getMenuManager().removeAll();
			actionBars.getStatusLineManager().removeAll();
			actionBars.getToolBarManager().removeAll();

			actionBars.getToolBarManager().update(true);
		}
	} // end method refresh()

	private static String safeText(String s) {
		return s == null ? IConstants.EMPTY_STRING : s;
	}

	public void update(final Notification notification, final EObject element) {
		if (!isDisposed() && isCurrentSelection(notification, element)) {
			postUpdateRequest(new Runnable() {

				public void run() {
					refresh();
				}
			});
		}
	}

	protected IDecoratorSemanticService getDsService() {
		if (dsService == null) {
			dsService = ExtensionsCore.createDecoratorSemanticService();
		}
		return dsService;
	}

	@Override
	public void aboutToBeShown() {
		super.aboutToBeShown();
		if (actionBars != null) {

			updateUndoGroup();

		}
//		bodyComposite.aboutToBeShown();
	}

	private void updateUndoGroup() {
		IUndoContext undoContext = getUndoContext();
		if (undoGroup == null) {
			IWorkbenchPartSite workbenchSite = getPart().getSite();

			if (undoContext != null) {
				undoGroup = new UndoRedoActionGroup(workbenchSite, undoContext);
			}
		}
		if (undoGroup != null) {
			if (undoContext != null) {
				undoGroup.setUndoContext(undoContext);
				undoGroup.fillActionBars(actionBars);
			} else {
				undoGroup.dispose();
				undoGroup = null;
			}
		}
	}

	private IUndoContext getUndoContext() {
		if (topology != null) {
			return LightweightOperationFactory.createContext(topology);
		}
		return null;
	}

	@Override
	public boolean shouldUseExtraSpace() {
		return true;
	}

	@Override
	public void dispose() {
		super.dispose();
		if (bodyComposite != null) {
			bodyComposite.dispose();
			bodyComposite = null;
		}
		if (undoGroup != null) {
			undoGroup.dispose();
		}
	}

} // end class TopologyPropertySection
