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

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.draw2d.ToolTipHelper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MenuDetectEvent;
import org.eclipse.swt.events.MenuDetectListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.CompoundContributionItem;
import org.eclipse.ui.forms.HyperlinkGroup;
import org.eclipse.ui.forms.HyperlinkSettings;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.internal.misc.StringMatcher;
import org.eclipse.ui.part.PageBook;

import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.constraint.BooleanOperator;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintFactory;
import com.ibm.ccl.soa.deploy.core.constraint.OrConstraint;
import com.ibm.ccl.soa.deploy.core.constraint.ShortConstraintDescriptor;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedFonts;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.actions.BasicToolbarAction;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.NubEditPopupDialog;
import com.ibm.ccl.soa.deploy.core.ui.internal.SoaDeployUiUtil;
import com.ibm.ccl.soa.deploy.core.ui.marker.quickfix.MarkerResolutionHelper;
import com.ibm.ccl.soa.deploy.core.ui.marker.quickfix.QuickFixDialog;
import com.ibm.ccl.soa.deploy.core.ui.properties.Messages;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.core.validator.ConstraintService;

/**
 * UI for managing the {@link Constraint}s on a {@link DeployModelObject}.
 * 
 * <p>
 * The UI includes some radio buttons and a tree or list.
 */
public class ConstraintComposite extends ModifiedSectionComposite {

	private ImageHyperlink rootTypeHyperlink;
	private Menu rootTypeMenu;
	private MenuManager rootTypeMenuMgr;
	private IAction rootTypeANDAction;
	private IAction rootTypeORAction;
	private IAction rootTypeAdvancedAction;
	private int rootTypeSelection;
	private IAction addAction;
	private IAction addChildAction;
	private IAction deleteAction;
	private IAction editAction;

	private TreeViewer advanced;

	private PopupDialog popup; // Constraint being edited
	private Constraint constraintBeingEdited;
	protected TreePath newSelection;
	private SelectionListener selectionListener;
	private KeyAdapter keyListener;
	private TableViewer simple;
	private PageBook pagebook;
	private boolean inSimple;
	protected Constraint newConstraint;

	private final List<Listener> constraintChangeListeners = new LinkedList<Listener>();
	private MenuManager contextMenuMgr;
	private MenuManager addChildMenuMgr;

	class CreateConstraintAction extends Action {
		private final boolean topLevel;
		private ShortConstraintDescriptor descriptor = null;

		protected CreateConstraintAction(ShortConstraintDescriptor d, boolean isTopLevel) {
			super(d.getTitle(), DeployCoreUIPlugin.getDefault().getSharedImages().getImageDescriptor(
					ISharedImages.IMG_CONSTRAINT));
			descriptor = d;
			topLevel = isTopLevel;
		}

		@Override
		public void run() {
			DeployModelObject context;
			if (topLevel) {
				context = (DeployModelObject) (isRootTypeORSelected() ? dmo.getConstraints().get(0)
						: dmo);
			} else {
				context = selectedConstraint();
			}
			addConstraint(context, descriptor);
		}
	}

	/**
	 * @param parent
	 * @param style
	 * @param deployModelObject
	 * @param ft
	 */
	public ConstraintComposite(Composite parent, int style, DeployModelObject deployModelObject,
			FormToolkit ft) {
		super(parent, style, deployModelObject, ft);

		PlatformUI.getWorkbench().getHelpSystem().setHelp(this,
				IDeployHelpContextIds.TOPOLOGY_CONSTRAINT_COMPOSITE);

		this.addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				dispose();
			}
		});
	}

	/**
	 * 
	 * @param parent
	 * @param style
	 * @param deployModelObject
	 * @param ft
	 */
	public ConstraintComposite(DmoComposite parent, int style, DeployModelObject deployModelObject,
			FormToolkit ft) {
		super(parent, style, deployModelObject, ft);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(this,
				IDeployHelpContextIds.TOPOLOGY_CONSTRAINT_COMPOSITE);
	}

	@Override
	protected void initializeBody() {
		createTreeTablePageBook();
	}

	private void initializeContextMenu() {
		contextMenuMgr = new MenuManager();
		contextMenuMgr.add(editAction);
		//Create Add submenu
		MenuManager addMenuMgr = new MenuManager(addAction.getText(), addAction.getImageDescriptor(),
				addAction.getId());
		addMenuMgr.add(new CompoundContributionItem() {
			@Override
			protected IContributionItem[] getContributionItems() {
				List<ShortConstraintDescriptor> applicableConstraints = ConstraintService.INSTANCE
						.applicableConstraints(dmo);
				if (applicableConstraints.isEmpty()) {
					return new IContributionItem[] { new ActionContributionItem(BasicToolbarAction
							.createDisabledImage(addAction.getImageDescriptor())) };
				}
				IContributionItem[] result = new IContributionItem[applicableConstraints.size()];
				int i = 0;
				for (ShortConstraintDescriptor d : applicableConstraints) {
					result[i++] = new ActionContributionItem(new CreateConstraintAction(d, true));
				}
				return result;
			}
		});

		contextMenuMgr.add(addMenuMgr);

		//Create Add Child submenu
		addChildMenuMgr = new MenuManager(addChildAction.getText(), addChildAction
				.getImageDescriptor(), addChildAction.getId());
		addChildMenuMgr.add(new CompoundContributionItem() {
			@Override
			protected IContributionItem[] getContributionItems() {
				DeployModelObject context = selectedConstraint() != null ? selectedConstraint() : null;
				List<ShortConstraintDescriptor> applicableConstraints = ConstraintService.INSTANCE
						.applicableConstraints(context);
				if (applicableConstraints.isEmpty()) {
					return new IContributionItem[] { new ActionContributionItem(BasicToolbarAction
							.createDisabledImage(addChildAction.getImageDescriptor())) };
				}
				IContributionItem[] result = new IContributionItem[applicableConstraints.size()];
				int i = 0;
				for (ShortConstraintDescriptor d : applicableConstraints) {
					result[i++] = new ActionContributionItem(new CreateConstraintAction(d, false));
				}
				return result;
			}
		});

		contextMenuMgr.add(addChildMenuMgr);

		contextMenuMgr.add(deleteAction);

		contextMenuMgr.createContextMenu(pagebook);
	}

	@Override
	protected void createToolbarTitleControls(Composite parent) {
		createRootTypeMenuControl(parent);
	}

	private void createRootTypeMenuControl(Composite parent) {
		initializeRootTypeMenuActions();
		Composite comp = new Composite(parent, SWT.NONE);
		GridLayout gl = new GridLayout(2, false);
		gl.marginWidth = 0;
		gl.marginHeight = 0;
		comp.setLayout(gl);
		comp.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		Label label = new Label(comp, SWT.NONE);
		label.setText(Messages.Simple_Constraint_Label);
		label.setFont(DeployCoreUIPlugin.getDefault().getSharedFonts().getFont(
				ISharedFonts.FIG_CATEGORY));
		rootTypeHyperlink = new ImageHyperlink(comp, SWT.RIGHT);
		rootTypeHyperlink.setImage(DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
				ISharedImages.IMG_DROP_DOWN_MENU));
		rootTypeHyperlink.setMenu(getRootTypeMenu(rootTypeHyperlink));
		rootTypeHyperlink.addHyperlinkListener(new IHyperlinkListener() {

			public void linkExited(HyperlinkEvent e) {
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkActivated(HyperlinkEvent e) {
				// Open Menu
				Menu menu = rootTypeHyperlink.getMenu();
				Rectangle rect = rootTypeHyperlink.getBounds();
				Point pt = rootTypeHyperlink.getParent().toDisplay(rootTypeHyperlink.getLocation());
				menu.setLocation(pt.x, pt.y + rect.height);
				menu.setVisible(true);
			}

		});
		HyperlinkGroup group = new HyperlinkGroup(null);
		group.setActiveBackground(getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
		group.setActiveForeground(null);
		group.setHyperlinkUnderlineMode(HyperlinkSettings.UNDERLINE_NEVER);
		group.add(rootTypeHyperlink);
	}

	@Override
	protected void initializeToolBar(ToolBarManager toolbarMgr) {
		//Edit Action
		editAction = createToolBarEditAction();
		toolbarMgr.add(editAction);
		//Add Action
		addAction = createToolBarAddAction();
		toolbarMgr.add(addAction);
		//Add child action
		addChildAction = createToolBarAddChildAction();
		toolbarMgr.add(addChildAction);
		//Delete Action
		deleteAction = createToolBarDeleteAction();
		toolbarMgr.add(deleteAction);

	}

	private IAction createToolBarEditAction() {
		IAction action = new Action(null, IAction.AS_PUSH_BUTTON) {
			@Override
			public void run() {
				openSelection(null);
			}
		};
		action.setToolTipText(Messages.ConstraintComposite_Edit_constraint_propertie_);
		action.setText(Messages.ConstraintComposite_Edit);
		action.setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_EDIT_REQUIREMENT));
		return action;
	}

	private IAction createToolBarDeleteAction() {
		IAction action = new Action(null, IAction.AS_PUSH_BUTTON) {
			@Override
			public void run() {
				deleteConstraint();
			}
		};
		action.setText(Messages.ConstraintComposite_Remove_constrain_);
		action.setToolTipText(Messages.ConstraintComposite_Remove_constrain_);
		action.setImageDescriptor(DeployCoreUIPlugin.getDefault().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_DELETE));
		return action;
	}

	private BasicToolbarAction createToolBarAddAction() {

		ImageDescriptor addImage = DeployCoreUIPlugin.getDefault().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_ADD);
		BasicToolbarAction action = new BasicToolbarAction(
				Messages.ConstraintComposite_Add_new_constrain_, addImage, addImage, true, false) {

			@Override
			public void run() {
				openToolBarPopupMenu(1, this);
			}

			@Override
			public IAction createDefaultAction(IWorkbenchPage activePage) {
				return null;
			}

			@Override
			public boolean isEnabled(IStructuredSelection selection) {
				return true;
			}

			@Override
			public void populateMenu(IWorkbenchPage activePage, Menu emptyMenu) {
				List<ShortConstraintDescriptor> applicableConstraints = ConstraintService.INSTANCE
						.applicableConstraints(dmo);

				for (ShortConstraintDescriptor d : applicableConstraints) {
					createMenuItem(new CreateConstraintAction(d, true), emptyMenu);
				}
			}
		};
		action.setToolTipText(Messages.ConstraintComposite_Add_new_constrain_);
		return action;
	}

	private BasicToolbarAction createToolBarAddChildAction() {

		ImageDescriptor addImage = DeployCoreUIPlugin.getDefault().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_ADD_CHILD_CONSTRAINT);
		ImageDescriptor disabledImage = DeployCoreUIPlugin.getDefault().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_ADD_CHILD_CONSTRAINT_DIS);
		BasicToolbarAction action = new BasicToolbarAction(
				Messages.ConstraintComposite_Add_new_constraint_as_chil_, addImage, disabledImage,
				true, false) {

			@Override
			public void run() {
				openToolBarPopupMenu(2, this);
			}

			@Override
			public IAction createDefaultAction(IWorkbenchPage activePage) {
				return null;
			}

			@Override
			public boolean isEnabled(IStructuredSelection selection) {
				return selection.size() == 1;
			}

			@Override
			public void populateMenu(IWorkbenchPage activePage, Menu emptyMenu) {
				DeployModelObject context = selectedConstraint() != null ? selectedConstraint() : null;
				List<ShortConstraintDescriptor> applicableConstraints = ConstraintService.INSTANCE
						.applicableConstraints(context);

				for (ShortConstraintDescriptor d : applicableConstraints) {
					createMenuItem(new CreateConstraintAction(d, false), emptyMenu);
				}
			}
		};
		action.setToolTipText(Messages.ConstraintComposite_Add_new_constraint_as_chil_);
		return action;
	}

	private void updateRootTypeHyperlink(int i) {
		rootTypeSelection = i;
		if (rootTypeHyperlink == null) {
			return;
		}
		switch (i)
		{
		case 0:
			rootTypeHyperlink.setText(Messages.ConstraintComposite_All_are_require_);
			break;
		case 1:
			rootTypeHyperlink.setText(Messages.ConstraintComposite_At_least_one_is_require_);
			break;
		case 2:
			rootTypeHyperlink.setText(Messages.ConstraintComposite_Customiz_);
			break;
		}
		rootTypeHyperlink.getParent().layout();
	}

	protected Menu getRootTypeMenu(Control parent) {
		if (rootTypeMenu == null) {
			if (rootTypeMenuMgr == null) {
				rootTypeMenuMgr = new MenuManager();
				fillRootTypeMenu();
			}
			rootTypeMenu = rootTypeMenuMgr.createContextMenu(parent);
		}
		return rootTypeMenu;
	}

	private void initializeRootTypeMenuActions() {
		//Root AND
		rootTypeANDAction = new Action(Messages.ConstraintComposite_All_are_require_) {
			@Override
			public void run() {
				updateRootTypeHyperlink(0);
				removeOr();
				showSimple();
			}
		};

		//Root OR
		rootTypeORAction = new Action(Messages.ConstraintComposite_At_least_one_is_require_) {
			@Override
			public void run() {
				updateRootTypeHyperlink(1);
				createOr();
				showSimple();
			}
		};

		//Root Advanced
		rootTypeAdvancedAction = new Action(Messages.ConstraintComposite_Customiz_) {
			@Override
			public void run() {
				updateRootTypeHyperlink(2);
				showAdvanced();
			}
		};
	}

	private void fillRootTypeMenu() {
		//Root ADD
		rootTypeMenuMgr.add(rootTypeANDAction);

		//Root OR
		rootTypeMenuMgr.add(rootTypeORAction);

		//Root Advanced
		rootTypeMenuMgr.add(rootTypeAdvancedAction);
	}

	/**
	 * @param newDmo
	 */
	public void setInput(DeployModelObject newDmo) {
		super.setInput(newDmo);
		advanced.setInput(newDmo);
		advanced.expandAll();
		simple.setInput(newDmo);
		updateRootTypeHyperlinkForInput();
		enableDisableControls();
		notifyConstraintListeners();
		resizeSimpleTable();
	}

	private Composite createTreeTablePageBook() {

		Composite treeComp = new Composite(this, SWT.NONE);
		GridLayout gl = new GridLayout();
		gl.marginLeft = 0;
		gl.marginRight = 0;
		gl.marginHeight = 0;
		gl.verticalSpacing = 2;
		treeComp.setLayout(gl);
		treeComp.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		treeComp.setBackgroundMode(SWT.INHERIT_DEFAULT);
		pagebook = new PageBook(treeComp, SWT.FLAT);
		formToolkit.adapt(pagebook);

		initializeContextMenu();

		selectionListener = new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				// do nothing
			}

			public void widgetSelected(SelectionEvent e) {
				enableDisableControls();
			}
		};

		keyListener = new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR && e.stateMask == 0) {
					openSelection(null);
				} else if (e.character == SWT.DEL && e.stateMask == 0) {
					deleteConstraint();
				}
			}
		};

		createSimpleTable(pagebook);
		createAdvancedTree(pagebook);
		GridData treeGD = new GridData(SWT.FILL, SWT.FILL, true, true);
		treeGD.minimumHeight = 85;
		pagebook.setLayoutData(treeGD);

		if (isRootTypeAdvancedSelected()) {
			showAdvanced();
		} else {
			showSimple();
		}
		return treeComp;
	}

	private boolean isRootTypeAdvancedSelected() {
		return rootTypeSelection == 2;
	}

	private boolean isRootTypeANDSelected() {
		return rootTypeSelection == 0;
	}

	private boolean isRootTypeORSelected() {
		return rootTypeSelection == 1;
	}

	private void createSimpleTable(Composite parent) {
		Table table = formToolkit.createTable(parent, SWT.MULTI | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		TableLayout layout = new TableLayout();
		layout.addColumnData(new ColumnWeightData(100, 200));
		table.setLayout(layout);
		new TableColumn(table, SWT.RIGHT);

		table.addSelectionListener(selectionListener);
		table.addKeyListener(keyListener);
		table.addMenuDetectListener(new MenuDetectListener() {
			public void menuDetected(MenuDetectEvent e) {
				Menu menu = contextMenuMgr.getMenu();
				menu.setLocation(e.x, e.y);
				menu.setVisible(true);
			}
		});

		table.addControlListener(new ControlListener() {
			public void controlResized(ControlEvent e) {
				resizeSimpleTable();
			}

			public void controlMoved(ControlEvent e) {
			}
		});

		ConstraintMouseListener listener = new ConstraintMouseListener();
		table.addMouseTrackListener(listener);
		table.addMouseListener(listener);

		simple = new TableViewer(table);
		simple.setLabelProvider(PropertyUtils.getSoaLabelProvider());
		simple.setContentProvider(new ConstraintModelTableProvider());
	}

	/**
	 * Force the resize of the tree based on the shell bounds.
	 */
	protected void resizeSimpleTable() {
		Table table = simple.getTable();
		if (!table.isDisposed() && table.isVisible() && table.getColumnCount() > 0) {
			int w = table.getBounds().width;
			//Adjust for the vertical scroll bar.
			if (table.getVerticalBar().isVisible()) {
				w -= table.getVerticalBar().getSize().x;
			}
			TableColumn col = table.getColumn(0);
			if (w < 400) {
				w = 400;
			}
			col.setWidth(w);
		}
	}

	private void createAdvancedTree(Composite parent) {
		Tree tree = formToolkit.createTree(parent, SWT.MULTI | SWT.FULL_SELECTION);
		//		GridData treeGD = new GridData(SWT.FILL, SWT.BEGINNING, true, true);
		//		treeGD.minimumHeight = 85;
		//		tree.setLayoutData(treeGD);
		tree.setLinesVisible(true);
		tree.addSelectionListener(selectionListener);
		tree.addKeyListener(keyListener);

		tree.addMenuDetectListener(new MenuDetectListener() {
			public void menuDetected(MenuDetectEvent e) {
				Menu menu = contextMenuMgr.getMenu();
				menu.setLocation(e.x, e.y);
				menu.setVisible(true);
			}
		});

		ConstraintMouseListener listener = new ConstraintMouseListener();
		tree.addMouseTrackListener(listener);
		tree.addMouseListener(listener);

		advanced = new TreeViewer(tree);
		advanced.setContentProvider(new ConstraintModelTreeProvider());
		advanced.setLabelProvider(PropertyUtils.getSoaLabelProvider());
	}

	private void updateRootTypeHyperlinkForInput() {
		if (canBeSimple()) {
			if (singleOrAlreadyExists()) {
				updateRootTypeHyperlink(1);
			} else {
				updateRootTypeHyperlink(0);
			}
		} else {
			updateRootTypeHyperlink(2);
		}
	}

	/** There may have been a root {@link OrConstraint}; if so remove it */
	@SuppressWarnings("unchecked")
	protected void removeOr() {
		if (singleOrAlreadyExists()) {
			final OrConstraint orConstraint = (OrConstraint) dmo.getConstraints().get(0);
			final List<Constraint> children = new LinkedList<Constraint>(orConstraint.getConstraints());

			String msg = Messages.ConstraintComposite_Change_Constraint_Grou_;
			PropertyUtils.executeWithUndo(dmo, msg, new Runnable() {

				public void run() {
					dmo.getConstraints().remove(orConstraint);
					dmo.getConstraints().addAll(children);
				}
			} // end anonymous Runnable
					);
		}
	}

	private boolean singleOrAlreadyExists() {
		if (dmo == null || dmo.getConstraints().size() != 1) {
			return false;
		}

		return dmo.getConstraints().get(0) instanceof OrConstraint;
	}

	/** Create root {@link OrConstraint} */
	@SuppressWarnings("unchecked")
	protected void createOr() {
		if (!singleOrAlreadyExists()) {
			final List<Constraint> children = new LinkedList<Constraint>(dmo.getConstraints());

			String msg = Messages.ConstraintComposite_Change_Constraint_Grou_;
			PropertyUtils.executeWithUndo(dmo, msg, new Runnable() {

				public void run() {
					dmo.getConstraints().removeAll(children);
					OrConstraint orConstraint = ConstraintFactory.eINSTANCE.createOrConstraint();
					orConstraint.setName(UnitUtil.generateUniqueName(dmo, "c")); //$NON-NLS-1$
					orConstraint.getConstraints().addAll(children);
					dmo.getConstraints().add(orConstraint);
					//							System.out
					//									.println("@@@ Dmo now has " + dmo.getConstraints().size() + " constraints"); //$NON-NLS-1$ //$NON-NLS-2$
				}
			} // end anonymous Runnable
					);
		} // end if
	}

	protected void showSimple() {
		inSimple = true;
		pagebook.showPage(simple.getTable());
		enableDisableControls();
		resizeSimpleTable();
	}

	protected void showAdvanced() {
		inSimple = false;
		advanced.expandAll();
		pagebook.showPage(advanced.getTree());
		enableDisableControls();
	}

	protected void enableDisableControls() {
		List<Constraint> constraints = getSelectedConstraints();
		boolean selected = constraints != null;
		boolean oneSelected = selected && constraints.size() == 1;

		editAction.setEnabled(isMutable() && oneSelected);
		addAction.setEnabled(isMutable());
		deleteAction.setEnabled(isMutable() && selected && canModify(constraints));
		addChildAction.setEnabled(oneSelected);
		addChildMenuMgr.setVisible(oneSelected);

		boolean canBeSimple = canBeSimple();
		boolean singleOrAlreadyExists = singleOrAlreadyExists();
		rootTypeANDAction.setEnabled(canBeSimple);
		rootTypeORAction.setEnabled(canBeSimple);

		if (inSimple) {
			if (!canBeSimple) {
				updateRootTypeHyperlinkForInput();
				showAdvanced();
			} else if (isRootTypeANDSelected() && singleOrAlreadyExists) {
				updateRootTypeHyperlinkForInput();
			}
		}

	}

	/**
	 * A list of {@link Constraint}s can be 'simple' if it is a single {@link OrConstraint} or has
	 * no {@link BooleanOperator}s.
	 */
	@SuppressWarnings("unchecked")
	private boolean canBeSimple() {
		if (dmo == null) {
			return true;
		}

		if (dmo.getConstraints().size() == 1 && dmo.getConstraints().get(0) instanceof OrConstraint) {
			Constraint orConstraint = (Constraint) dmo.getConstraints().get(0);
//			return noBooleans(orConstraint.getConstraints());
			return noTrees(orConstraint.getConstraints());
		}

//		return noBooleans(dmo.getConstraints());
		return noTrees(dmo.getConstraints());
	}

//	/** true if no BooleanOperators */
//	private boolean noBooleans(List<Constraint> constraints) {
//		for (Constraint c : constraints) {
//			if (c instanceof BooleanOperator) {
//				return false;
//			}
//		}
//
//		return true;
//	}

	/** true if no BooleanOperators */
	private boolean noTrees(List<Constraint> constraints) {
		for (Constraint c : constraints) {
			if (c.getConstraints().size() > 0) {
				return false;
			}
		}

		return true;
	}

	private List<Constraint> getSelectedConstraints() {
		if (treeVisible()) {
			return getSelectedConstraints(advanced);
		}

		if (!simple.getTable().isDisposed()) {
			return getSelectedConstraints(simple);
		}

		return Collections.emptyList();
	}

	@SuppressWarnings("unchecked")
	private List<Constraint> getSelectedConstraints(ISelectionProvider isp) {
		if (isp.getSelection() instanceof StructuredSelection) {
			StructuredSelection ss = (StructuredSelection) isp.getSelection();
			if (ss.getFirstElement() instanceof Constraint) {
				return ss.toList();
			}
		}

		return null;
	}

	private boolean treeVisible() {
//		Display.getDefault().asyncExec(new Runnable() {
//			public void run() {
//				isTreeVisable = !isDisposed() && isRootTypeAdvancedSelected();
//
//			}
//		});
		return !inSimple && !isDisposed();

	}

	protected void deleteConstraint() {
		PropertyUtils.deleteFromModel(getSelectedConstraints(), dmo,
				Messages.ConstraintComposite_Delete_Constraint_);
		//		advanced.refresh(false);
		//		enableDisableControls();
		if (popup != null) {
			popup.close();
			constraintBeingEdited = null;
		}
	}

	private void addConstraint(ShortConstraintDescriptor descr) {
		if (isRootTypeORSelected()) {
			addConstraint((OrConstraint) dmo.getConstraints().get(0), descr);
		} else {
			addConstraint(dmo, descr);
		}
	}

	private void addChildConstraint(ShortConstraintDescriptor descr) {
		addConstraint(getSelectedConstraints().get(0), descr);
	}

	private void addConstraint(final DeployModelObject container,
			final ShortConstraintDescriptor descr) {
		String msg = Messages.ConstraintComposite_Add_Constrain_;
		PropertyUtils.executeWithUndo(container, msg, new Runnable() {

			@SuppressWarnings("unchecked")
			public void run() {
				newConstraint = descr.createConstraint(container);
				newSelection = constraintToPath(container, newConstraint);
				newConstraint.setName(UnitUtil.generateUniqueName(container, "c")); //$NON-NLS-1$
				container.getConstraints().add(newConstraint);
			}
		});
	}

	/** This method lets us select a constraint */
	private TreePath constraintToPath(DeployModelObject container, Constraint constraint) {
		List<Constraint> l = new LinkedList<Constraint>();
		l.add(constraint);
		while (container instanceof Constraint) {
			l.add(0, (Constraint) container);
			container = container.getParent();
		}

		return new TreePath(l.toArray());
	}

	private void openSelection(MouseEvent e) {
		List<Constraint> constraints = getSelectedConstraints();
		if (constraints == null || constraints.size() != 1) {
			return;
		}

		Constraint constraint = constraints.get(0);

		if (constraint == constraintBeingEdited && popup != null) {
			return;
		}

		if (popup != null) {
			popup.close();
			popup = null;
		}

		//Don't open if this is a BooleanOperator constraint.
		if (constraint instanceof BooleanOperator) {
			return;
		}

		popup = createFlyingEditComposite(getShell(), constraint, e);

		//		try {
		popup.create();

		popup.getShell().addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent event) {
				popup = null;
			}
		});

		//Set on popupCloser to ensure the parent closes when focus moves off of the popup.
		if (popupCloser != null) {
			popupCloser.setSecondaryPopup(popup);
		}
		popup.open();
		//		} catch (Exception ex) {
		//			ex.printStackTrace();
		//		}

		constraintBeingEdited = constraint;
	}

	private PopupDialog createFlyingEditComposite(Shell shell, DeployModelObject dmoToEdit,
			Point rowRelativePosition) {
		Point pos = null;
		//Select a point just below the current selection.
		if (treeVisible()) {
			pos = getTreeRelativePosition(dmoToEdit, rowRelativePosition, 20);
		} else {
			pos = getTableRelativePosition(dmoToEdit, rowRelativePosition, 20);
		}
		if (pos == null) {
			pos = new Point(shell.getDisplay().getCursorLocation().x + 20, shell.getDisplay()
					.getCursorLocation().y);
		}
		return new NubEditPopupDialog(shell, pos, dmoToEdit, SWT.APPLICATION_MODAL, true);
	}

	private PopupDialog createFlyingEditComposite(Shell shell, DeployModelObject dmoToEdit,
			MouseEvent e) {
		Point point = e != null ? new Point(e.x, e.y) : null;
		return createFlyingEditComposite(shell, dmoToEdit, point);
	}

	private Point getTreeRelativePosition(Object data, Point rowLocation, int xOffset) {
		Tree control = advanced.getTree();
		TreeItem item = null;
		if (rowLocation != null) {
			item = control.getItem(rowLocation);
		} else if (data != null) {
			item = getSelectedTreeItem(data, control.getItems());
		}
		if (item != null) {
			Rectangle itemBounds = item.getTextBounds(0);
			return control.toDisplay(itemBounds.x + 20, itemBounds.y + itemBounds.height);
		}
		return null;
	}

	private TreeItem getSelectedTreeItem(Object data, TreeItem[] items) {
		for (int i = 0; i < items.length; i++) {
			if (data == items[i].getData()) {
				return items[i];
			} else {
				TreeItem[] children = items[i].getItems();
				TreeItem item = getSelectedTreeItem(data, children);
				if (item != null) {
					return item;
				}
			}
		}
		return null;
	}

	private Point getTableRelativePosition(Object data, Point rowLocation, int xOffset) {
		Table control = simple.getTable();
		TableItem item = null;
		if (rowLocation != null) {
			item = control.getItem(rowLocation);
		} else if (data != null) {
			TableItem[] items = control.getItems();
			for (int i = 0; i < items.length; i++) {
				if (data == items[i].getData()) {
					item = items[i];
					break;
				}
			}
		}
		if (item != null) {
			Rectangle itemBounds = item.getTextBounds(0);
			return control.toDisplay(itemBounds.x + 20, itemBounds.y + itemBounds.height);
		}
		return null;
	}

	private void notifyConstraintListeners() {
		if (constraintChangeListeners != null) {
			// Make a fake event.
			Event event = new Event();
			event.widget = this; // if widget is null the CCombo handleEvent() gets confused...

			for (Listener listener : constraintChangeListeners) {
				listener.handleEvent(event);
			}
		}
	}

//	/**
//	 * event listener; catches multiplexed events and routes them to us. We are interested in<br>
//	 * 1. the list of Capabilities changing<br>
//	 * 2. the name changing for the current capability.
//	 */
//	private final ResourceSetListenerImpl eventListener = new ResourceSetListenerImpl(getFilter()) {
//
//		public void resourceSetChanged(ResourceSetChangeEvent event) {
//
//			// We just assume, if we get a notification 
//			boolean constraintsListStale = false;
//
//			//
//			for (Iterator<Notification> it = event.getNotifications().iterator(); it.hasNext()
//					&& !constraintsListStale;) {
//				Notification notif = it.next();
//
//				constraintsListStale |= notif.getFeature() == CorePackage.eINSTANCE
//						.getDeployModelObject_ConstraintGroup();
//				constraintsListStale |= notif.getNotifier() instanceof Constraint;
//			}
//
//			if (constraintsListStale && !advanced.getTree().isDisposed()) {
//				// If any of the notifications changed the {@link Unit#getCapabilityGroup} ref, refresh table
//				Display.getDefault().asyncExec(new Runnable() {
//					public void run() {
//						boolean simpleDisposed = true;
//						if (simple != null && !simple.getControl().isDisposed()) {
//							simpleDisposed = false;
//							simple.refresh(true);
//						}
//
//						boolean advancedDisposed = true;
//						if (advanced != null && !advanced.getControl().isDisposed()) {
//							advancedDisposed = false;
//							advanced.refresh(true);
//						}
//
//						if (newSelection != null) {
//							if (!advancedDisposed) {
//								StructuredSelection ss = new StructuredSelection(newSelection);
//								advanced.setSelection(ss, true);
//							}
//
//							if (!simpleDisposed) {
//								StructuredSelection ss = new StructuredSelection(newConstraint);
//								simple.setSelection(ss, true);
//							}
//
//							openSelection();
//
//							newSelection = null;
//							newConstraint = null;
//						}
//
//						if (!isDisposed()) {
//							enableDisableControls();
//						}
//
//						notifyConstraintListeners();
//					}
//
//				});
//			}
//		}
//
//		public boolean isPostcommitOnly() {
//			return true;
//		}
//
//	};
//
//	private NotificationFilter getFilter() {
//		NotificationFilter retVal = NotificationFilter.createEventTypeFilter(Notification.SET).or(
//				NotificationFilter.createEventTypeFilter(Notification.ADD)).or(
//				NotificationFilter.createEventTypeFilter(Notification.REMOVE));
//		return retVal;
//	}

	/**
	 * Called when the list of constraints changes
	 * 
	 * @param listener
	 */
	public void addConstraintChangeListener(Listener listener) {
		constraintChangeListeners.add(listener);
	}

	protected DeployModelObject selectedConstraint() {
		List<Constraint> constraints = getSelectedConstraints();
		Constraint first = constraints != null && constraints.size() > 0 ? constraints.get(0) : null;
		return first;
	}

	private static class ConstraintModelTableProvider implements IStructuredContentProvider {

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof DeployModelObject) {
				DeployModelObject dmo = (DeployModelObject) inputElement;

				// If there is only one Constraint, and it's an OrConstraint, use it's children as content
				if (dmo.getConstraints().size() == 1) {
					Constraint constraint = (Constraint) dmo.getConstraints().get(0);
					if (constraint instanceof OrConstraint) {
						return constraint.getConstraints().toArray();
					}
				}

				// Otherwise, use everything
				return dmo.getConstraints().toArray();
			}

			return new Object[0];
		}

		public void dispose() {
			// do nothing
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// do nothing
		}

	}

	/**
	 * The constraints, as a tree, corresponding to the model
	 */
	private static class ConstraintModelTreeProvider implements ITreeContentProvider {

		private final static Object[] NONE = new Object[0];

		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof DeployModelObject) {
				DeployModelObject dmo = (DeployModelObject) parentElement;
				return dmo.getConstraints().toArray();
			}

			return NONE;
		}

		public Object getParent(Object element) {
			return null;
		}

		public boolean hasChildren(Object element) {
			return getChildren(element).length > 0;
		}

		public Object[] getElements(Object inputElement) {
			return getChildren(inputElement);
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

	}

	private static class LableBasedTableFilter extends ViewerFilter {

		private StringMatcher matcher;
		private final ILabelProvider labelProvider;

		protected LableBasedTableFilter(ILabelProvider provider) {
			matcher = new StringMatcher("*", true, false); //$NON-NLS-1$
			labelProvider = provider;
		}

		protected void setMatchString(String text) {
			matcher = new StringMatcher(text + '*', true, false);
		}

		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			// entries only match if they match the regexp input
			String text = labelProvider.getText(element);

			if (matcher.match(text)) {
				return true;
			}

			return false;
		}

	}

	private static class ListTableContentProvider implements IStructuredContentProvider {

		private final static Object[] NONE = new Object[0];

		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof List) {
				List<?> l = (List<?>) inputElement;
				return l.toArray();
			}

			return NONE;
		}

		public void dispose() {
			// do nothing
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// do nothing
		}

	} // end static inner class ListTableContentProvider

	private class ConstraintMouseListener extends MouseTrackAdapter implements MouseListener {

		private ToolTipHelper toolTip;

		public void mouseHover(MouseEvent e) {
			String tipText = null;

			if (overIcon(e)) {
				Object data = getTreeItemData(e.widget, e.x, e.y);
				if (data instanceof Constraint) {
					Constraint constraint = (Constraint) data;
					if (!constraint.getStatus().isOK()) {
						tipText = constraint.getStatus().toString();
					}
				}
			}

			if (tipText != null) {
				Point ptAbs = ((Control) e.widget).toDisplay(new org.eclipse.swt.graphics.Point(e.x,
						e.y));
				org.eclipse.draw2d.Label draw2dLabel = new org.eclipse.draw2d.Label();
				draw2dLabel.setText(tipText);
				getToolTipHelper().displayToolTipNear(new org.eclipse.draw2d.Label(), draw2dLabel,
						ptAbs.x, ptAbs.y);
			} else {
				// Remove existing tooltip
				getToolTipHelper().updateToolTip(null, null, 0, 0);
			}
		}

		public void mouseDoubleClick(MouseEvent e) {
			openSelection(e);
		}

		public void mouseDown(MouseEvent e) {
//			Object data = getTreeItemData(e.widget, e.x, e.y);
//			if (data instanceof DeployModelObject) {
//				if (overIcon(e)) {
//					DeployModelObject dmObject = (DeployModelObject) data;
//					popupResolutions(dmObject);
//					return;
//				}
//			}
//
//			if (overConstraint(e)) {
//				openSelection(e);
//			}
		}

		public void mouseUp(MouseEvent e) {
			// do nothing
		}

		@SuppressWarnings("unchecked")
		private void popupResolutions(DeployModelObject selectedDMO) {
			IMarker[] markers = SoaDeployUiUtil.getMarkers(selectedDMO).toArray(new IMarker[0]);
			if (markers.length > 0 || !selectedDMO.getStatus().isOK()) {
				MarkerResolutionHelper mrh = new MarkerResolutionHelper(markers);
				QuickFixDialog qfd = new QuickFixDialog(getShell(), selectedDMO.getTopology(), mrh,
						selectedDMO.getStatus(), PlatformUI.getWorkbench().getDisplay()
								.getCursorLocation(), true);
				qfd.open();
			}
		}

		private ToolTipHelper getToolTipHelper() {
			if (toolTip == null) {
				toolTip = new ToolTipHelper(advanced.getTree());
			}
			return toolTip;
		}

		private Object getTreeItemData(Widget widget, int x, int y) {
			if (widget instanceof Tree) {
				Tree table = (Tree) widget;
				TreeItem item = table.getItem(new Point(x, y));
				if (item != null) {
					return item.getData();
				}
			} else if (widget instanceof Table) {
				Table table = (Table) widget;
				TableItem item = table.getItem(new Point(x, y));
				if (item != null) {
					return item.getData();
				}
			}

			return null;
		}

		private boolean overConstraint(MouseEvent e) {
			Rectangle bounds = getBounds(e.widget, e.x, e.y, 0);
			if (bounds == null) {
				return false;
			}

			// The rectangle seems to be for the text area, not the icon,
			// so check if the click has a negative offset from the bounds.
			int xRel = e.x - bounds.x;
			return xRel > 16;
		}

		private boolean overIcon(MouseEvent e) {
			Rectangle bounds = getBounds(e.widget, e.x, e.y, 0);
			if (bounds == null) {
				return false;
			}

			// The rectangle seems to be for the text area, not the icon,
			// so check if the click has a negative offset from the bounds.
			int xRel = e.x - bounds.x;
			return 0 < xRel && xRel <= 16;
		}

		private Rectangle getBounds(Widget w, int x, int y, int column) {
			if (w instanceof Tree) {
				return getTreeBounds((Tree) w, x, y, column);
			}
			return getTableBounds((Table) w, x, y, column);
		}

		private Rectangle getTreeBounds(Tree tree, int x, int y, int column) {
			TreeItem item = tree.getItem(new Point(x, y));

			if (item == null) {
				return null;
			}

			// The rectangle seems to be for the text area, not the icon
			return item.getBounds(column);
		}

		private Rectangle getTableBounds(Table table, int x, int y, int column) {
			TableItem item = table.getItem(new Point(x, y));

			if (item == null) {
				return null;
			}

			// The rectangle seems to be for the text area, not the icon
			return item.getBounds(column);
		}

	} // end inner class ConstraintMouseListener

	@Override
	public void dispose() {
		if (rootTypeMenuMgr != null) {
			rootTypeMenuMgr.dispose();
		}
		if (rootTypeMenu != null) {
			rootTypeMenu.dispose();
		}
		super.dispose();
	}

	private void refreshViews() {
		if (!advanced.getTree().isDisposed()) {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					boolean simpleDisposed = true;
					if (simple != null && !simple.getControl().isDisposed()) {
						simpleDisposed = false;
						simple.refresh(true);
					}

					boolean advancedDisposed = true;
					if (advanced != null && !advanced.getControl().isDisposed()) {
						advancedDisposed = false;
						advanced.refresh(true);
					}

					if (newSelection != null) {
						if (!advancedDisposed) {
							StructuredSelection ss = new StructuredSelection(newSelection);
							advanced.setSelection(ss, true);
						}

						if (!simpleDisposed) {
							StructuredSelection ss = new StructuredSelection(newConstraint);
							simple.setSelection(ss, true);
						}
						newSelection = null;
						newConstraint = null;
						openSelection(null);
					}

					if (!isDisposed()) {
						enableDisableControls();
					}

					notifyConstraintListeners();
				}

			});
		}
	}

	@Override
	protected ModelListener createModelListener() {
		return new ConstraintListener();
	}

	private class ConstraintListener extends ModelListener {
		@SuppressWarnings("unchecked")
		public void notifyChanged(Notification notification) {
			switch (notification.getEventType())
			{
			case Notification.ADD:
				if (CorePackage.Literals.DEPLOY_MODEL_OBJECT__CONSTRAINT_GROUP == notification
						.getFeature()) {
					FeatureMap.Entry map = (FeatureMap.Entry) notification.getNewValue();
					adaptTarget((Constraint) map.getValue());
				} else if (CorePackage.Literals.DEPLOY_MODEL_OBJECT__CONSTRAINTS == notification
						.getFeature()) {
					adaptTarget((Constraint) notification.getNewValue());
				}
				refreshViews();
				break;
			case Notification.ADD_MANY:
				if (CorePackage.Literals.DEPLOY_MODEL_OBJECT__CONSTRAINT_GROUP == notification
						.getFeature()) {
					List<FeatureMap.Entry> entries = (List<FeatureMap.Entry>) notification.getNewValue();
					for (Entry entry : entries) {
						adaptTarget((Constraint) entry.getValue());
					}
				} else if (CorePackage.Literals.DEPLOY_MODEL_OBJECT__CONSTRAINTS == notification
						.getFeature()) {
					List<Constraint> constraints = (List<Constraint>) notification.getNewValue();
					for (Constraint constraint : constraints) {
						adaptTarget(constraint);
					}
				}
				refreshViews();
				break;
			case Notification.REMOVE:
				if (CorePackage.Literals.DEPLOY_MODEL_OBJECT__CONSTRAINT_GROUP == notification
						.getFeature()) {
					FeatureMap.Entry map = (FeatureMap.Entry) notification.getOldValue();
					((Constraint) map.getValue()).getEObject().eAdapters().remove(this);
				} else if (CorePackage.Literals.DEPLOY_MODEL_OBJECT__CONSTRAINTS == notification
						.getFeature()) {
					removeTarget(((Constraint) notification.getOldValue()).getEObject());
				}
				refreshViews();
				break;
			case Notification.REMOVE_MANY:
				if (CorePackage.Literals.DEPLOY_MODEL_OBJECT__CONSTRAINT_GROUP == notification
						.getFeature()) {
					List<FeatureMap.Entry> entries = (List<FeatureMap.Entry>) notification.getOldValue();
					for (Entry entry : entries) {
						Constraint constraint = (Constraint) entry.getValue();
						removeTarget(constraint.getEObject());
					}
				} else if (CorePackage.Literals.DEPLOY_MODEL_OBJECT__CONSTRAINTS == notification
						.getFeature()) {
					List<Constraint> constraints = (List<Constraint>) notification.getNewValue();
					for (Constraint constraint : constraints) {
						removeTarget(constraint.getEObject());
					}
				}
				refreshViews();
				break;
			default:
				// We need to refresh views even if the notifier ISN'T a
				// constraint.  The notifier might be a child of a constraint,
				// such as SingleValue for an EnumerationConstraint, but
				// still affect the label for the constraint.
				refreshViews();
			}
		}

		/**
		 * Handles installation of the adapter on an EObject by adding the adapter to each of the
		 * directly contained objects.
		 */
		@SuppressWarnings("unchecked")
		protected void setTarget(EObject aTarget) {
			basicSetTarget(aTarget);
			if (aTarget instanceof DeployModelObject) {
				List<Constraint> constraints = ((DeployModelObject) aTarget).getConstraints();
				if (!constraints.isEmpty()) {
					Iterator<Constraint> it = constraints.iterator();
					while (it.hasNext()) {
						addAdapter(it.next());
					}
				}
			}
		}
	};

} // end class ConstraintComposite
