package com.ibm.ccl.soa.deploy.core.ui.dialogs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CapabilityLinkTypes;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.IRelationshipChecker;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementLinkTypes;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.PopupCloserListener;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.RequirementsPropertiesLabelProvider;
import com.ibm.ccl.soa.deploy.core.ui.preferences.IDeployPreferences;
import com.ibm.ccl.soa.deploy.core.ui.properties.LightweightOperationFactory;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ZoomUtils;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * @since 7.0
 * 
 */
public class CreateDependencyLinkDialog extends RobustPopupDialog implements
		IPropertyChangeListener {
	private boolean _multiTargets = false;
	final private boolean _hasTargets;
	private boolean _canCreateMatches;
	private TreeViewer _requiresTreeView;
	private TreeViewer _providesTreeView;
	private final Set<Unit> _srcUnits;
	private final Set<Unit> _tgtUnits;
	private List<UnitData> _srcDataUnits;
	private List<UnitData> _tgtDataUnits;
	private final Set<Unit> _allSrcUnits = new HashSet<Unit>();
	private final Set<Unit> _allTgtUnits = new HashSet<Unit>();
	private final List<NubData> _requiresCheckList = new ArrayList<NubData>();
	private final List<NubData> _providesCheckList = new ArrayList<NubData>();
	private final Point _location;
	private ToolItem _matchRequirementItem;
	private ToolItem _addCapabilityItem;
	private ToolItem _matchCapabilityItem;
	private ToolItem _deleteNubItem;
	private ToolItem _editNubItem;
	private DeployModelObject _editDmo = null;
	protected boolean _creatingCapabitltiy = false;
	private final EditPart _srcEP;
	private final EditPart _tgtEP;
	private Unit _srcUnit;
	private Unit _tgtUnit;
	final private EditPartViewer _viewer;

	private final List<LinkDescriptor> _selected = new ArrayList<LinkDescriptor>();

	static private LinkType[] linkTypes = new LinkType[] { LinkType.DEPENDENCY, LinkType.CONSTRAINT };

	private PopupDialog popup = null;
	private PopupCloserListener popupCloser;
	private TreeItem _autoSingleCheckedItem = null;
	private List<NubData> _autoSingleCheckedList = null;
	private int _undoActions = 0;
	private Composite applyAreaComposite;

	/**
	 * @since 7.0
	 * 
	 */
	static public class UnitData {
		private final Unit _unit;
		private final List<UnitData> _children = new ArrayList<UnitData>();

		UnitData(Unit unit) {
			_unit = unit;
		}

		public Unit getUnit() {
			return _unit;
		}

		public List<UnitData> getChildren() {
			return _children;
		}

	}

	/**
	 * @since 7.0
	 * 
	 */
	static public class NubData {
		private final DeployModelObject _dmo;
		private final Unit _parentUnit;
		private final LinkDescriptor _descriptor;
		private int _weight;

		NubData(DeployModelObject dmo, Unit unit, LinkDescriptor descriptor, int weight) {
			_dmo = dmo;
			_parentUnit = unit;
			_descriptor = descriptor;
			_weight = weight;
		}

		public DeployModelObject getDmo() {
			return _dmo;
		}

		public int getWeight() {
			return _weight;
		}

		public LinkDescriptor getDescriptor() {
			return _descriptor;
		}

		public Unit getParentUnit() {
			return _parentUnit;
		}

		public void setWeight(int weight) {
			_weight = weight;
		}

	}

	/**
	 * @param parent
	 * @param viewer
	 * @param openLocation
	 * @param srcEP
	 * @param tgtEP
	 * @param descriptorList
	 */
	public CreateDependencyLinkDialog(Shell parent, EditPartViewer viewer, Point openLocation,
			List<LinkDescriptor> descriptorList, EditPart srcEP, EditPart tgtEP) {
		super(parent, SWT.TOOL | SWT.RESIZE | SWT.APPLICATION_MODAL, true, false, true, false, null,
				Messages.CreateDependencyLinkDialog_0);
		_location = openLocation;
		_viewer = viewer;
		_srcEP = srcEP;
		_tgtEP = tgtEP;
		_srcUnits = new HashSet<Unit>();
		_srcUnit = null;
		EObject eo = ViewUtil.resolveSemanticElement((View) srcEP.getModel());
		if (eo instanceof Unit) {
			_srcUnit = (Unit) eo;
			_srcUnits.add(_srcUnit);
		}
		_tgtUnits = new HashSet<Unit>();
		_tgtUnit = null;
		_multiTargets = tgtEP == null;
		if (!_multiTargets) {
			eo = ViewUtil.resolveSemanticElement((View) tgtEP.getModel());
			if (eo instanceof Unit) {
				_tgtUnit = (Unit) eo;
				_tgtUnits.add(_tgtUnit);
			}
		}
		for (LinkDescriptor descriptor : descriptorList) {
			_srcUnits.add(descriptor.getSourceUnit());
			_tgtUnits.add(descriptor.getTargetUnit());
		}
		_hasTargets = _tgtUnits.size() > 0;
		IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
		_canCreateMatches = store != null
				&& store.getBoolean(IDeployPreferences.DEPLOY_DLCP_ALLOW_MATCH_CREATION);
		setBlockOnOpen(true);
	}

	@Override
	protected Point getInitialSize() {
		return new Point(650, 300);
	}

	protected Point getInitialLocation(Point initialSize) {
		return _location;
	}

	protected Control createDialogArea(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		GridLayout layout = new GridLayout(2, true);
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		layout.horizontalSpacing = 0;
		composite.setLayout(layout);

		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_CREATE_DEPENDENCY_LINK);

		// create requirements tree
		Tree requiresTree = new Tree(composite, SWT.CHECK | SWT.SINGLE | SWT.FULL_SELECTION
				| SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.heightHint = requiresTree.getItemHeight() * 12;
		gd.widthHint = 325;
		requiresTree.setLayoutData(gd);
		requiresTree.setHeaderVisible(true);
		requiresTree.setLinesVisible(true);

		TreeColumn requiresColumn = new TreeColumn(requiresTree, SWT.LEFT);
		requiresColumn.setWidth(400);
		requiresColumn.setText(Messages.CreateDependencyLinkDialog_1);
		requiresColumn.setResizable(true);

		_requiresTreeView = new TreeViewer(requiresTree);
		ITreeContentProvider rtreeProvider = new RequiresContentProvider(this);
		_requiresTreeView.setContentProvider(rtreeProvider);
		ITableLabelProvider rlabelProvider = new RequiresLabelProvider();
		_requiresTreeView.setLabelProvider(rlabelProvider);
		_requiresTreeView.addOpenListener(new IOpenListener() {

			public void open(OpenEvent event) {
				handleEditNub();
			}

		});
		_requiresTreeView.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection().isEmpty()) {
					_deleteNubItem.setEnabled(false);
					_editNubItem.setEnabled(false);
					_matchRequirementItem.setEnabled(false);
					_matchCapabilityItem.setEnabled(false);
				}
			}
		});
		requiresTree.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				_deleteNubItem.setEnabled(false);
				_editNubItem.setEnabled(false);
				_matchRequirementItem.setEnabled(false);
				_matchCapabilityItem.setEnabled(false);
				closePopup();
				if (e.getSource() instanceof Tree && e.item instanceof TreeItem) {
					TreeItem item = (TreeItem) e.item;
					if (item.getData() instanceof NubData) {
						Tree tree = (Tree) e.getSource();
						boolean isSelected = Arrays.asList(tree.getSelection()).contains(item);
						_deleteNubItem.setEnabled(isSelected && _canCreateMatches);
						_editNubItem.setEnabled(isSelected);
						NubData nd = (NubData) item.getData();
						// weight of -1 means linked requirement
						_matchCapabilityItem.setEnabled(isSelected && nd.getWeight() >= 0 && _hasTargets
								&& _canCreateMatches);
					}
					refreshCheckList(_requiresTreeView, _providesTreeView, _requiresCheckList,
							_providesCheckList);
				}
			}
		});
		_requiresTreeView.setSorter(new ViewerSorter() {
			public int compare(Viewer viewer, Object o1, Object o2) {
				if (o1 instanceof NubData && o2 instanceof NubData) {
					NubData d1 = (NubData) o1;
					NubData d2 = (NubData) o2;
					if (d1.getWeight() > d2.getWeight()) {
						return -1;
					} else if (d1.getWeight() > d2.getWeight()) {
						return 1;
					} else if (d1.getDmo() != null && d2.getDmo() != null) {
						String s1 = PropertyUtils.getDmoName(d1.getDmo());
						String s2 = PropertyUtils.getDmoName(d2.getDmo());
						return s1.compareTo(s2);
					}
				} else if (o1 instanceof UnitData && o2 instanceof UnitData) {
					UnitData d1 = (UnitData) o1;
					UnitData d2 = (UnitData) o2;
					String s1 = PropertyUtils.getDmoName(d1.getUnit());
					String s2 = PropertyUtils.getDmoName(d2.getUnit());
					return s1.compareTo(s2);
				}
				return super.compare(viewer, o1, o2);
			}
		});

		// create capabilities tree
		Tree providesTree = new Tree(composite, SWT.CHECK | SWT.SINGLE | SWT.FULL_SELECTION
				| SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
		gd = new GridData(GridData.FILL_BOTH);
		gd.heightHint = providesTree.getItemHeight() * 12;
		gd.widthHint = 325;
		providesTree.setLayoutData(gd);
		providesTree.setHeaderVisible(true);
		providesTree.setLinesVisible(true);

		TreeColumn providesColumn = new TreeColumn(providesTree, SWT.LEFT);
		providesColumn.setResizable(true);
		providesColumn.setWidth(400);
		providesColumn.setText(Messages.CreateDependencyLinkDialog_2);

		_providesTreeView = new TreeViewer(providesTree);
		ITreeContentProvider ptreeProvider = new ProvidesContentProvider(this);
		_providesTreeView.setContentProvider(ptreeProvider);
		ITableLabelProvider plabelProvider = new ProvidesLabelProvider();
		_providesTreeView.setLabelProvider(plabelProvider);
		_providesTreeView.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				if (event.getSelection().isEmpty()) {
					_deleteNubItem.setEnabled(false);
					_editNubItem.setEnabled(false);
					_matchRequirementItem.setEnabled(false);
					_matchCapabilityItem.setEnabled(false);
				}
			}
		});
		_providesTreeView.addOpenListener(new IOpenListener() {

			public void open(OpenEvent event) {
				handleEditNub();
			}

		});
		providesTree.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				_deleteNubItem.setEnabled(false);
				_editNubItem.setEnabled(false);
				_matchRequirementItem.setEnabled(false);
				_matchCapabilityItem.setEnabled(false);
				closePopup();

				if (e.getSource() instanceof Tree && e.item instanceof TreeItem) {
					TreeItem item = (TreeItem) e.item;
					if (item.getData() instanceof NubData) {
						Tree tree = (Tree) e.getSource();
						boolean isSelected = Arrays.asList(tree.getSelection()).contains(item);
						_deleteNubItem.setEnabled(isSelected && _canCreateMatches);
						_editNubItem.setEnabled(isSelected);
						_matchRequirementItem.setEnabled(isSelected && _canCreateMatches);
						if (_multiTargets) {
							_viewer.deselectAll();
							NubData data = (NubData) item.getData();
							Unit tgtUnit = GMFUtils.getUnit(data.getDmo());
							List<DeployShapeNodeEditPart> epList = GMFUtils.getOrCreateEditPartsFor(
									_viewer, tgtUnit);
							if (epList.size() > 0) {
								DeployShapeNodeEditPart ep = epList.get(0);
								for (DeployShapeNodeEditPart epx : epList) {
									if (!GMFUtils.isImportTopology(epx)) {
										ep = epx;
										break;
									}
								}
								ZoomUtils.expose(ep);
								if (e.item == item) {
									_viewer.reveal(ep);
								}
								_viewer.appendSelection(ep);
							}
						}
					}
					refreshCheckList(_providesTreeView, _requiresTreeView, _providesCheckList,
							_requiresCheckList);
				}
			}
		});
		_providesTreeView.setSorter(new ViewerSorter() {
			public int compare(Viewer viewer, Object o1, Object o2) {
				if (o1 instanceof NubData && o2 instanceof NubData) {
					NubData d1 = (NubData) o1;
					NubData d2 = (NubData) o2;
					if (d1.getWeight() > d2.getWeight()) {
						return -1;
					} else if (d1.getWeight() > d2.getWeight()) {
						return 1;
					} else if (d1.getDmo() != null && d2.getDmo() != null) {
						DeployModelObject dmo1 = d1.getDmo();
						DeployModelObject dmo2 = d2.getDmo();
						String s1 = PropertyUtils.getDmoName(dmo1);
						String s2 = PropertyUtils.getDmoName(dmo2);
						return s1.compareTo(s2);
					}
				} else if (o1 instanceof UnitData && o2 instanceof UnitData) {
					UnitData d1 = (UnitData) o1;
					UnitData d2 = (UnitData) o2;
					String s1 = PropertyUtils.getDmoName(d1.getUnit());
					String s2 = PropertyUtils.getDmoName(d2.getUnit());
					return s1.compareTo(s2);
				}
				return super.compare(viewer, o1, o2);
			}
		});

		DeployCoreUIPlugin.getDefault().getPreferenceStore().addPropertyChangeListener(this);
		refreshContents();
		return composite;
	}

	private void refreshContents() {
		_requiresCheckList.clear();
		_providesCheckList.clear();
		if (_matchRequirementItem != null) {
			_matchRequirementItem.setEnabled(false);
			_matchCapabilityItem.setEnabled(false);
			_deleteNubItem.setEnabled(false);
			_editNubItem.setEnabled(false);
		}
		_srcDataUnits = processUnits(_srcUnits, _srcEP, _srcUnit, _allSrcUnits, _viewer);
		_tgtDataUnits = processUnits(_tgtUnits, _tgtEP, _tgtUnit, _allTgtUnits, _viewer);
		_requiresTreeView.setInput(new ArrayList<Object>(_srcDataUnits));
		_providesTreeView.setInput(new ArrayList<Object>(_tgtDataUnits));
		_requiresTreeView.expandToLevel(AbstractTreeViewer.ALL_LEVELS);
		_providesTreeView.expandToLevel(AbstractTreeViewer.ALL_LEVELS);
	}

	public void propertyChange(PropertyChangeEvent event) {
		if (event.getProperty().equals(IDeployPreferences.DEPLOY_DLCP_FILTER_0_MATCHES)) {
			refreshContents();
		}
		if (event.getProperty().equals(IDeployPreferences.DEPLOY_DLCP_ALLOW_MATCH_CREATION)) {
			IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
			_canCreateMatches = store != null
					&& store.getBoolean(IDeployPreferences.DEPLOY_DLCP_ALLOW_MATCH_CREATION);
			_addCapabilityItem.setEnabled(_hasTargets && _canCreateMatches);
			_matchRequirementItem.setEnabled(false);
			_matchCapabilityItem.setEnabled(false);
			_deleteNubItem.setEnabled(false);
		}
	}

	protected boolean hasTitleArea() {
		return true;
	}

	protected Control createTitleControl(Composite parent) {
		Composite titleComposite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, false);
		layout.marginHeight = POPUP_MARGINHEIGHT;
		layout.marginWidth = POPUP_MARGINWIDTH;
		layout.verticalSpacing = POPUP_VERTICALSPACING;
		layout.horizontalSpacing = POPUP_HORIZONTALSPACING;
		titleComposite.setLayout(layout);
		titleComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		createToolBar(titleComposite);
		return titleComposite;
	}

	private void createToolBar(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		GridLayout layout = new GridLayout(2, false);
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 0;
		composite.setLayout(layout);

		// provides toolbar
		ToolBar ptoolBar = new ToolBar(composite, SWT.FLAT);
		GridData pgd = new GridData(GridData.FILL_HORIZONTAL | GridData.HORIZONTAL_ALIGN_END);
		ptoolBar.setLayoutData(pgd);

		_matchCapabilityItem = new ToolItem(ptoolBar, SWT.PUSH);
		_matchCapabilityItem.setImage(DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
				ISharedImages.IMG_ADD_MATCHING_CAPABILITY));
		_matchCapabilityItem.setEnabled(false);
		_matchCapabilityItem.setToolTipText(Messages.CreateDependencyLinkDialog_13);
		_matchCapabilityItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
					public void run() {
						handleMatchCapability();
					}
				});
			}
		});

		_addCapabilityItem = new ToolItem(ptoolBar, SWT.PUSH);
		_addCapabilityItem.setImage(DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
				ISharedImages.IMG_ADD_CAPABILTITY_AND_REQUIREMENT));
		_addCapabilityItem.setToolTipText(Messages.CreateDependencyLinkDialog_7);
		_addCapabilityItem.setEnabled(_hasTargets && _canCreateMatches);
		_addCapabilityItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
					public void run() {
						handleAddCapabilityAndRequirement();
					}
				});
			}
		});

		_matchRequirementItem = new ToolItem(ptoolBar, SWT.PUSH);
		_matchRequirementItem.setImage(DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
				ISharedImages.IMG_ADD_MATCHING_REQUIREMENT));
		_matchRequirementItem.setEnabled(false);
		_matchRequirementItem.setToolTipText(Messages.CreateDependencyLinkDialog_8);
		_matchRequirementItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleMatchRequirement();
			}
		});

		_editNubItem = new ToolItem(ptoolBar, SWT.PUSH);
		_editNubItem.setImage(DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
				ISharedImages.IMG_EDIT_REQUIREMENT));
		_editNubItem.setToolTipText(Messages.CreateDependencyLinkDialog_11);
		_editNubItem.setEnabled(false);
		_editNubItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleEditNub();
			}
		});

		_deleteNubItem = new ToolItem(ptoolBar, SWT.PUSH);
		_deleteNubItem.setImage(DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
				ISharedImages.IMG_DELETE));
		_deleteNubItem.setToolTipText(Messages.CreateDependencyLinkDialog_12);
		_deleteNubItem.setEnabled(false);
		_deleteNubItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleDeleteSelections();
			}
		});

	}

	private void handleAddCapabilityAndRequirement() {
		// init if first time
		try {
			PropertyUtils.getETypeFromName(""); //$NON-NLS-1$
		} catch (Throwable t) {
		}
		List<Object> list = new LinkedList<Object>();
		list.addAll(PropertyUtils.getBankedCapabilities());
		list.addAll(PropertyUtils.getInstantiatableCapTypeNames());
		ElementListSelectionDialog dlg = new NewCapabilityCreationDialog(getShell(), PropertyUtils
				.getSoaLabelProvider());
		dlg
				.setTitle(com.ibm.ccl.soa.deploy.core.ui.properties.Messages.NewCapabilityDialog_ADD_CAPABILITY);
		dlg.setHelpAvailable(false);
		dlg.setElements(list.toArray());
		if (dlg.open() == Window.OK) {
			Object sel = dlg.getFirstResult();
			Capability cap = null;
			if (sel instanceof Capability) {
				cap = (Capability) sel;
			} else if (sel instanceof String) {
				String ecName = (String) sel;
				cap = PropertyUtils.createCapability(ecName);
			}
			if (cap != null) {
				final Unit unit = getReceivingUnit(_allTgtUnits, Messages.CreateDependencyLinkDialog_14);
				if (unit == null) {
					return;
				}
				final Capability cap2 = cap;
				PropertyUtils.executeWithUndo(unit,
						com.ibm.ccl.soa.deploy.core.ui.Messages.NubEditDialog_Add_Capabilit_,
						new Runnable() {

							public void run() {
								cap2.setName(UnitUtil.generateUniqueName(unit, cap2.eClass().getName()));
								unit.getCapabilities().add(cap2);
							}
						});
				closePopup();
				_creatingCapabitltiy = true;
				refreshContents();
				selectDmo(cap, _providesTreeView, _providesCheckList);
				handleMatchRequirement();
				_requiresTreeView.expandToLevel(AbstractTreeViewer.ALL_LEVELS);
				selectDmo(cap, _providesTreeView, _providesCheckList);
				_requiresTreeView.refresh();
				_providesTreeView.refresh();
				_creatingCapabitltiy = false;
				_deleteNubItem.setEnabled(true);
				_editNubItem.setEnabled(true);
				_matchRequirementItem.setEnabled(true);
				_applyControl.setEnabled(true);
				_undoActions += 2;
			}
		}
	}

	protected void handleMatchRequirement() {
		// get first selected capability
		Capability cap = null;
		TreeItem[] items = _providesTreeView.getTree().getSelection();
		if (items.length == 0) {
			return;
		}
		TreeItem item = items[0];
		if (item.getData() instanceof NubData) {
			NubData data = (NubData) item.getData();
			if (data.getDmo() instanceof Capability) {
				cap = (Capability) data.getDmo();
			}
		}
		if (cap == null) {
			return;
		}
		final Capability capability = cap;
		final String reqName = "Requires " + PropertyUtils.getDisplayEType(cap.eClass(), ""); //$NON-NLS-1$ //$NON-NLS-2$

		closePopup();
		final Requirement requirement = CoreFactory.eINSTANCE.createRequirement();
		final Unit srcUnit = getReceivingUnit(_allSrcUnits, Messages.CreateDependencyLinkDialog_15);
		if (srcUnit == null) {
			return;
		}
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(srcUnit);
		IUndoableOperation op = new AbstractEMFOperation(
				domain,
				com.ibm.ccl.soa.deploy.core.ui.properties.Messages.RequirementsPropertySection5_Add_Requiremen_) {
			@Override
			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
					throws org.eclipse.core.commands.ExecutionException {
				requirement.setName(generateUniqueName());
				requirement.setDmoEType(capability.eClass());
				srcUnit.getRequirements().add(requirement);
				_undoActions++;
				return Status.OK_STATUS;
			}

			private String generateUniqueName() {
				List<String> names = getReqNames();
				int cnt = 0;
				String candidate = reqName;
				while (names.contains(candidate)) {
					candidate = reqName + ++cnt;
				}

				return candidate;
			}

			private List<String> getReqNames() {
				List<String> retVal = new LinkedList<String>();
				for (Iterator<Requirement> it = srcUnit.getRequirements().iterator(); it.hasNext();) {
					Requirement req = it.next();
					retVal.add(req.getName());
				}
				return retVal;
			}

		};
		LightweightOperationFactory.execute(srcUnit, op);

		if (requirement != null) {
			refreshContents();
			selectDmo(capability, _providesTreeView, _providesCheckList);
			selectDmo(requirement, _requiresTreeView, _requiresCheckList);
			_requiresTreeView.refresh();
			_providesTreeView.refresh();
			_deleteNubItem.setEnabled(true);
			_editNubItem.setEnabled(true);
			_applyControl.setEnabled(true);
		}
	}

	protected void handleMatchCapability() {
		// get first selected requirement
		Requirement req = null;
		TreeItem[] items = _requiresTreeView.getTree().getSelection();
		TreeItem item = items[0];
		if (item.getData() instanceof NubData) {
			NubData data = (NubData) item.getData();
			if (data.getDmo() instanceof Requirement) {
				req = (Requirement) data.getDmo();
			}
		}
		if (req == null) {
			return;
		}
		final Requirement requirement = req;
		String reqDmoEType = PropertyUtils.getDisplayEType(req.getDmoEType(), ""); //$NON-NLS-1$
		if (reqDmoEType.length() == 0) {
			return;
		}

		closePopup();
		// init if first time
		try {
			PropertyUtils.getETypeFromName(""); //$NON-NLS-1$
		} catch (Throwable t) {
		}
		final Capability capability = PropertyUtils.createCapability(reqDmoEType);
		final Unit tgtUnit = getReceivingUnit(_allTgtUnits, Messages.CreateDependencyLinkDialog_14);
		if (tgtUnit == null) {
			return;
		}
		capability.setName(UnitUtil.generateUniqueName(tgtUnit, capability.eClass().getName()));
		capability.setDisplayName(NLS.bind(Messages.CreateDependencyLinkDialog_Provides_0_,
				reqDmoEType));
		PropertyUtils.executeWithUndo(tgtUnit,
				com.ibm.ccl.soa.deploy.core.ui.Messages.NubEditDialog_Add_Capabilit_, new Runnable() {

					public void run() {
						tgtUnit.getCapabilities().add(capability);
						_undoActions++;
					}
				});

		refreshContents();
		selectDmo(requirement, _requiresTreeView, _requiresCheckList);
		selectDmo(capability, _providesTreeView, _providesCheckList);
		_requiresTreeView.refresh();
		_providesTreeView.refresh();
		_deleteNubItem.setEnabled(true);
		_editNubItem.setEnabled(true);
		_applyControl.setEnabled(true);
	}

	private Unit getReceivingUnit(Set<Unit> allUnits, String string) {
		Unit unit = allUnits.iterator().next();
		if (allUnits.size() > 1) {
			String[] list = new String[allUnits.size()];
			int i = 0;
			for (Unit u : allUnits) {
				list[i++] = PropertyUtils.getDmoName(u);
			}
			Dialog dlg = new ChooseOptionDialog(getShell(), Messages.CreateDependencyLinkDialog_17,
					string, list);
			int ret = dlg.open();
			if (ret == ChooseOptionDialog.EXIT) {
				unit = null;
			} else {
				unit = (Unit) allUnits.toArray()[ret];
			}
		}
		return unit;
	}

	private void handleEditNub() {
		closePopup();
		DeployModelObject dmo = null;
		TreeItem[] items = _providesTreeView.getTree().isFocusControl() ? _providesTreeView.getTree()
				.getSelection() : _requiresTreeView.getTree().getSelection();
		if (items.length == 1) {
			TreeItem item = items[0];
			if (item.getData() instanceof NubData) {
				NubData data = (NubData) item.getData();
				dmo = data.getDmo();
			}
		}
		if (dmo instanceof Capability) {
			handleEditCapability(dmo);
		} else if (dmo instanceof Requirement) {
			handleEditRequirement(dmo);
		}
	}

	private void handleEditCapability(DeployModelObject dmo) {
		popup = new NubEditPopupDialog(getShell(), null, dmo);
		Point point = null;
		popup.create();
		Rectangle rect = getShell().getBounds();
		Rectangle detailRect = popup.getShell().getBounds();
		Rectangle monitorBounds = Display.getCurrent().getPrimaryMonitor().getBounds();
		if (rect.x + rect.width + detailRect.width > monitorBounds.width) {
			// Open to the left.
			point = new Point(rect.x - detailRect.width, rect.y);
		} else {
			// Open to the right.
			point = new Point(rect.x + rect.width, rect.y);
		}
		popup.getShell().setLocation(point);
		if (popupCloser == null) {
			popupCloser = new PopupCloserListener(popup);
		}
		popup.open();
		listenForObjectNameChanges(dmo);
		popup.getShell().addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				closePopup();
			}
		});
	}

	protected void handleEditRequirement(DeployModelObject dmo) {
		Unit unit = GMFUtils.getUnit(dmo);
		popup = new RequirementDetailPopupDialog(getShell(), new RequirementsPropertiesLabelProvider(
				PropertyUtils.isProxy(unit)));
		Point point = null;
		popup.create();
		Rectangle rect = getShell().getBounds();
		Rectangle detailRect = popup.getShell().getBounds();
		Rectangle monitorBounds = Display.getCurrent().getPrimaryMonitor().getBounds();
		if (rect.x + rect.width + detailRect.width > monitorBounds.width) {
			// Open to the left.
			point = new Point(rect.x - detailRect.width, rect.y);
		} else {
			// Open to the right.
			point = new Point(rect.x + rect.width, rect.y);
		}
		popup.getShell().setLocation(point);
		if (popupCloser == null) {
			popupCloser = new PopupCloserListener(popup);
		}
		popup.open();
		((RequirementDetailPopupDialog) popup).setInput(dmo);
		listenForObjectNameChanges(dmo);
		final Requirement req = (Requirement) dmo;
		final EClass ec = req.getDmoEType();
		popup.getShell().addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				if (!req.getDmoEType().equals(ec)) {
					refreshContents();
				}
				closePopup();
			}
		});
	}

	private void handleDeleteSelections() {
		deleteRequirements();
		deleteCapabilities();
		closePopup();
		_requiresCheckList.clear();
		_providesCheckList.clear();
		refreshContents();
		_deleteNubItem.setEnabled(false);
		_editNubItem.setEnabled(false);
		_matchRequirementItem.setEnabled(false);
	}

	private void deleteRequirements() {
		if (_requiresTreeView.getTree().isFocusControl()) {
			Map<Unit, Set<Requirement>> requirements = new HashMap<Unit, Set<Requirement>>();
			TreeItem[] items = _requiresTreeView.getTree().getSelection();
			for (int i = 0; i < items.length; i++) {
				TreeItem item = items[i];
				if (item.getData() instanceof NubData) {
					NubData data = (NubData) item.getData();
					if (data.getDmo() instanceof Requirement) {
						Requirement req = (Requirement) data.getDmo();
						Unit unit = GMFUtils.getUnit(req);
						if (!requirements.containsKey(unit)) {
							requirements.put(unit, new HashSet<Requirement>());
						}
						requirements.get(unit).add(req);
					}
				}
			}
			for (Unit unit : requirements.keySet()) {
				PropertyUtils
						.deleteFromModel(
								new ArrayList(requirements.get(unit)),
								unit,
								com.ibm.ccl.soa.deploy.core.ui.properties.Messages.RequirementsPopupDialog_Delete_the_selected_requirement_);
				_undoActions++;
			}
		}
	}

	private void deleteCapabilities() {
		if (_providesTreeView.getTree().isFocusControl()) {
			Map<Unit, Set<Capability>> capabilities = new HashMap<Unit, Set<Capability>>();
			TreeItem[] items = _providesTreeView.getTree().getSelection();
			for (int i = 0; i < items.length; i++) {
				TreeItem item = items[i];
				if (item.getData() instanceof NubData) {
					NubData data = (NubData) item.getData();
					if (data.getDmo() instanceof Capability) {
						Capability cap = (Capability) data.getDmo();
						Unit unit = GMFUtils.getUnit(cap);
						if (!capabilities.containsKey(unit)) {
							capabilities.put(unit, new HashSet<Capability>());
						}
						capabilities.get(unit).add(cap);
					}
				}
			}
			for (Unit unit : capabilities.keySet()) {
				PropertyUtils.deleteFromModel(new ArrayList(capabilities.get(unit)), unit,
						com.ibm.ccl.soa.deploy.core.ui.Messages.NubEditDialog_Delete_Capabilit_);
				_undoActions++;
			}
		}
	}

	protected void fillDialogMenu(IMenuManager dialogMenu) {
		super.fillDialogMenu(dialogMenu);
		dialogMenu.add(new ToggleAutoCreateLinkAction());
		dialogMenu.add(new ToggleCreateMatchAction());
		dialogMenu.add(new ToggleFilterMismatchesAction());
	}

	/**
	 * allow creation of link when there's only one perfect (100%) match
	 */
	private class ToggleAutoCreateLinkAction extends Action {

		ToggleAutoCreateLinkAction() {
			super(Messages.DeployCoreMainPreferencePage_4, IAction.AS_CHECK_BOX);
			IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
			if (store != null) {
				setChecked(store.getBoolean(IDeployPreferences.DEPLOY_DLCD_AUTO_CREATE_LINK));
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.action.IAction#run()
		 */
		public void run() {
			IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
			if (store != null) {
				store.setValue(IDeployPreferences.DEPLOY_DLCD_AUTO_CREATE_LINK, isChecked());
			}
		}
	}

	/**
	 * allow creation of link when there's only one perfect (100%) match
	 */
	private class ToggleCreateMatchAction extends Action {

		ToggleCreateMatchAction() {
			super(Messages.DeployCoreMainPreferencePage_5, IAction.AS_CHECK_BOX);
			IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
			if (store != null) {
				setChecked(store.getBoolean(IDeployPreferences.DEPLOY_DLCP_ALLOW_MATCH_CREATION));
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.action.IAction#run()
		 */
		public void run() {
			IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
			if (store != null) {
				store.setValue(IDeployPreferences.DEPLOY_DLCP_ALLOW_MATCH_CREATION, isChecked());
			}
		}
	}

	/**
	 * allow creation of link when there's only one perfect (100%) match
	 */
	private class ToggleFilterMismatchesAction extends Action {

		ToggleFilterMismatchesAction() {
			super(Messages.DeployCoreMainPreferencePage_6, IAction.AS_CHECK_BOX);
			IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
			if (store != null) {
				setChecked(store.getBoolean(IDeployPreferences.DEPLOY_DLCP_FILTER_0_MATCHES));
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.action.IAction#run()
		 */
		public void run() {
			IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
			if (store != null) {
				store.setValue(IDeployPreferences.DEPLOY_DLCP_FILTER_0_MATCHES, isChecked());
			}
		}
	}

	protected void apply() {
		LinkDescriptor descriptor = _requiresCheckList.get(0).getDescriptor();
		if (descriptor == null) {
			descriptor = _providesCheckList.get(0).getDescriptor();
		}
		if (descriptor == null) {
			DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();
			Requirement requirement = (Requirement) _requiresCheckList.get(0).getDmo();
			Unit srcUnit = GMFUtils.getUnit(requirement);
			Capability capabiltity = (Capability) _providesCheckList.get(0).getDmo();
			Unit tgtUnit = GMFUtils.getUnit(capabiltity);
			descriptor = dvs.getPossibleLinks(srcUnit, requirement, tgtUnit, capabiltity, linkTypes,
					DeployValidatorService.MATCHER_DEPTH_NONE)[0];
		}
		_selected.add(descriptor);
		close();
	}

	protected void cancel() {
		for (int i = 0; i < _undoActions; i++) {
			//		_viewer.getEditDomain().getCommandStack().undo();
		}
		close();
	}

	@Override
	public boolean close() {
		closePopup();
		DeployCoreUIPlugin.getDefault().getPreferenceStore().removePropertyChangeListener(this);
		return super.close();
	}

	protected void closePopup() {
		stopListeningForObjectNameChanges();
		if (popup != null) {
			popup.close();
			popup = null;
		}
		if (popupCloser != null) {
			popupCloser.dispose();
			popupCloser = null;
		}
	}

	protected void refreshCheckList(TreeViewer treeView, TreeViewer treeView2,
			List<NubData> checkList, List<NubData> checkList2) {
		List<NubData> list = new ArrayList<NubData>();
		refreshCheckListHelper(treeView.getTree().getItems(), list);
		if (list.size() != checkList.size() || !list.containsAll(checkList)) {
			if (_autoSingleCheckedItem != null && _autoSingleCheckedList != null) {
				_autoSingleCheckedItem.setChecked(false);
				_autoSingleCheckedList.clear();
				_autoSingleCheckedItem = null;
				_autoSingleCheckedList = null;
			}
			checkList.clear();
			checkList.addAll(list);
			treeView.refresh(false);
			treeView2.refresh(false);
			treeView.expandToLevel(AbstractTreeViewer.ALL_LEVELS);
			treeView2.expandToLevel(AbstractTreeViewer.ALL_LEVELS);
			if (list.size() > 0) {
				checkSingleItem(treeView2, checkList2);
			}
			treeView2.refresh(false);
		}
		_applyControl.setEnabled(_providesCheckList.size() > 0 && _requiresCheckList.size() > 0);
	}

	protected boolean refreshCheckListHelper(TreeItem[] items, List<NubData> list) {
		for (int i = 0; i < items.length; i++) {
			if (refreshCheckListHelper(items[i].getItems(), list)) {
				return true;
			}
			if (items[i].getData() instanceof UnitData) {
				if (items[i].getChecked()) {
					items[i].setChecked(false);
					checkFirstNub(items[i].getItems(), list);
					return true;
				}
			} else if (items[i].getData() instanceof NubData) {
				NubData data = (NubData) items[i].getData();
				if (items[i].getChecked()) {
					list.add(data);
				}
			}
		}

		return false;
	}

	private boolean checkFirstNub(TreeItem[] items, List<NubData> list) {
		for (int i = 0; i < items.length; i++) {
			if (items[i].getData() instanceof NubData) {
				boolean isChecked = !items[i].getChecked();
				items[i].setChecked(isChecked);
				if (isChecked) {
					list.add((NubData) items[i].getData());
				} else {
					list.clear();
				}
				return true;
			} else if (items[i].getData() instanceof UnitData) {
				if (checkFirstNub(items[i].getItems(), list)) {
					return true;
				}
			}
		}
		return false;
	}

	// if there's only one tree item now on the other tree, just check it
	private void checkSingleItem(TreeViewer treeView, List<NubData> checkList) {
		Map<TreeItem, NubData> map = new HashMap<TreeItem, NubData>();
		collectNubData(treeView.getTree().getItems(), map);
		if (map.size() == 1) {
			Entry<TreeItem, NubData> entry = map.entrySet().iterator().next();
			entry.getKey().setChecked(true);
			checkList.clear();
			checkList.add(entry.getValue());
			_applyControl.setEnabled(true);
			_autoSingleCheckedItem = entry.getKey();
			_autoSingleCheckedList = checkList;
		}
	}

	private void collectNubData(TreeItem[] items, Map<TreeItem, NubData> map) {
		for (int i = 0; i < items.length; i++) {
			if (items[i].getData() instanceof NubData) {
				map.put(items[i], (NubData) items[i].getData());
			} else if (items[i].getData() instanceof UnitData) {
				collectNubData(items[i].getItems(), map);
			}
		}
	}

	protected void selectDmo(DeployModelObject dmo, TreeViewer treeView, List<NubData> checkList) {
		checkList.clear();
		selectDmoHelper(dmo, treeView.getTree().getItems(), treeView, checkList);
		treeView.refresh(false);
	}

	private boolean selectDmoHelper(DeployModelObject dmo, TreeItem[] items, TreeViewer treeView,
			List<NubData> checkList) {
		for (int i = 0; i < items.length; i++) {
			if (selectDmoHelper(dmo, items[i].getItems(), treeView, checkList)) {
				return true;
			}
			if (items[i].getData() instanceof NubData) {
				NubData data = (NubData) items[i].getData();
				if (dmo != null && dmo == data.getDmo()) {
					treeView.getTree().setSelection(items[i]);
					items[i].setChecked(true);
					data.setWeight(100);
					checkList.add(data);
					treeView.getTree().setFocus();
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * @return selected link descriptors
	 */
	public List<LinkDescriptor> getSelectedOptions() {
		return _selected;
	}

	private static class RequiresContentProvider implements ITreeContentProvider {
		private static final Object[] NONE = new Object[0];
		private final CreateDependencyLinkDialog _dlg;

		RequiresContentProvider(CreateDependencyLinkDialog dlg) {
			_dlg = dlg;
		}

		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof List) {
				List<?> list = (List<?>) parentElement;
				return list.toArray();
			} else if (parentElement instanceof UnitData) {
				UnitData ud = (UnitData) parentElement;
				List<Object> list = new ArrayList<Object>();
				list.addAll(ud.getChildren());
				Unit srcUnit = ud.getUnit();

				// if requires tree has a checked item only allow that item
				if (_dlg._requiresCheckList.size() > 0) {
					// when multiple sources, only show in the selected source unit
					if (srcUnit != _dlg._requiresCheckList.get(0).getParentUnit()) {
						return list.toArray();
					}
					return _dlg._requiresCheckList.toArray();
				}

				// else if requires has a checked item only show matching capabilities
				DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();
				if (_dlg._providesCheckList.size() > 0) {
					NubData data = _dlg._providesCheckList.get(0);
					Capability capabiltity = null;
					Unit tgtUnit = null;
					if (data.getDmo() instanceof Capability) {
						capabiltity = (Capability) data.getDmo();
						tgtUnit = GMFUtils.getUnit(capabiltity);
					} else {
						tgtUnit = (Unit) data.getDmo();
					}
					LinkDescriptor[] descriptors = dvs.getPossibleLinks(srcUnit, null, tgtUnit,
							capabiltity, linkTypes, DeployValidatorService.MATCHER_DEPTH_NONE);
					for (int i = 0; i < descriptors.length; i++) {
						list.add(new CreateDependencyLinkDialog.NubData(descriptors[i].getSource(),
								srcUnit, descriptors[i], descriptors[i].getLinkWeight()));
					}
					return list.toArray();
				}

				// else just show everything
				Map<DeployModelObject, NubData> map = new HashMap<DeployModelObject, NubData>();
				for (Unit tgtUnit : _dlg._tgtUnits) {
					LinkDescriptor[] descriptors = dvs.getPossibleLinks(srcUnit, null, tgtUnit, null,
							linkTypes, DeployValidatorService.MATCHER_DEPTH_NONE);
					for (int i = 0; i < descriptors.length; i++) {
						DeployModelObject srcDmo = descriptors[i].getSource();
						if (!map.containsKey(srcDmo)) {
							NubData data = new CreateDependencyLinkDialog.NubData(srcDmo, srcUnit, null,
									descriptors[i].getLinkWeight());
							list.add(data);
							map.put(srcDmo, data);
						} else {
							NubData data = map.get(srcDmo);
							if (data.getWeight() < descriptors[i].getLinkWeight()) {
								data.setWeight(descriptors[i].getLinkWeight());
							}
						}
					}
				}

				IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
				if (store == null || _dlg._creatingCapabitltiy
						|| !store.getBoolean(IDeployPreferences.DEPLOY_DLCP_FILTER_0_MATCHES)) {
					//_linkCacheMap;
					IRelationshipChecker relationships = srcUnit.getEditTopology().getRelationships();
					for (Iterator<?> it = srcUnit.getRequirements().iterator(); it.hasNext();) {
						Requirement requirement = (Requirement) it.next();
						if (!map.containsKey(requirement)
								&& (requirement.getLinkType() == RequirementLinkTypes.DEPENDENCY_LITERAL || requirement
										.getLinkType() == RequirementLinkTypes.ANY_LITERAL)) {
							boolean isLinked = relationships.getDependencyTargets(requirement).size() > 0;
							list.add(new CreateDependencyLinkDialog.NubData(requirement, srcUnit, null,
									(isLinked ? -1 : 0)));
						}
					}
				}
				return list.toArray();
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
			// do nothing
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// do nothing
		}

	}

	private static class ProvidesContentProvider implements ITreeContentProvider {

		private static final Object[] NONE = new Object[0];
		private final CreateDependencyLinkDialog _dlg;

		ProvidesContentProvider(CreateDependencyLinkDialog dlg) {
			_dlg = dlg;
		}

		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof List) {
				List<?> list = (List<?>) parentElement;
				return list.toArray();
			} else if (parentElement instanceof UnitData) {
				UnitData ud = (UnitData) parentElement;
				List<Object> list = new ArrayList<Object>();
				list.addAll(ud.getChildren());
				Unit tgtUnit = ud.getUnit();

				// if provides tree has a checked item only allow that item
				if (_dlg._providesCheckList.size() > 0) {
					// when multiple targets, only show in the selected target unit
					if (tgtUnit != _dlg._providesCheckList.get(0).getParentUnit()) {
						return list.toArray();
					}
					return _dlg._providesCheckList.toArray();
				}

				// else if requires has a checked item only show matching capabilities
				DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();
				if (_dlg._requiresCheckList.size() > 0) {
					NubData data = _dlg._requiresCheckList.get(0);
					Requirement requirement = null;
					Unit srcUnit = null;
					if (data.getDmo() instanceof Requirement) {
						requirement = (Requirement) data.getDmo();
						srcUnit = GMFUtils.getUnit(requirement);
					} else {
						srcUnit = (Unit) data.getDmo();
					}
					LinkDescriptor[] descriptors = dvs.getPossibleLinks(srcUnit, requirement, tgtUnit,
							null, linkTypes, DeployValidatorService.MATCHER_DEPTH_NONE);
					for (int i = 0; i < descriptors.length; i++) {
						list.add(new CreateDependencyLinkDialog.NubData(descriptors[i].getTarget(),
								tgtUnit, descriptors[i], descriptors[i].getLinkWeight()));
					}
					return list.toArray();
				}

				// else just show everything
				Map<DeployModelObject, NubData> map = new HashMap<DeployModelObject, NubData>();
				for (Unit srcUnit : _dlg._srcUnits) {
					LinkDescriptor[] descriptors = dvs.getPossibleLinks(srcUnit, null, tgtUnit, null,
							linkTypes, DeployValidatorService.MATCHER_DEPTH_NONE);
					for (int i = 0; i < descriptors.length; i++) {
						DeployModelObject tgtDmo = descriptors[i].getTarget();
						if (!map.containsKey(tgtDmo)) {
							NubData data = new CreateDependencyLinkDialog.NubData(tgtDmo, tgtUnit, null,
									descriptors[i].getLinkWeight());
							list.add(data);
							map.put(tgtDmo, data);
						} else {
							NubData data = map.get(tgtDmo);
							if (data.getWeight() < descriptors[i].getLinkWeight()) {
								data.setWeight(descriptors[i].getLinkWeight());
							}
						}
					}
				}

				IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
				if (store == null || _dlg._creatingCapabitltiy
						|| !store.getBoolean(IDeployPreferences.DEPLOY_DLCP_FILTER_0_MATCHES)) {
					for (Iterator<?> it = tgtUnit.getCapabilities().iterator(); it.hasNext();) {
						Capability capability = (Capability) it.next();
						if (!map.containsKey(capability)
								&& (capability.getLinkType() == CapabilityLinkTypes.DEPENDENCY_LITERAL || capability
										.getLinkType() == CapabilityLinkTypes.ANY_LITERAL)) {
							list.add(new CreateDependencyLinkDialog.NubData(capability, tgtUnit, null, 0));
						}
					}
				}
				return list.toArray();
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
			// do nothing
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// do nothing
		}
	}

	private static class RequiresLabelProvider implements ITableLabelProvider {

		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			switch (columnIndex)
			{
			case 0:
				if (element instanceof UnitData) {
					return PropertyUtils.getDmoName(((UnitData) element).getUnit());
				} else if (element instanceof NubData) {
					NubData data = (NubData) element;
					String weight = data.getWeight() >= 0 ? Integer.toString(data.getWeight()) + "%" //$NON-NLS-1$
					: Messages.CreateDependencyLinkDialog_18;
					if (data.getDmo() instanceof Requirement) {
						Requirement req = (Requirement) data.getDmo();
						return NLS.bind(Messages.CreateDependencyLinkDialog_9, new Object[] { weight,
								PropertyUtils.getDmoName(req),
								PropertyUtils.getDisplayEType(req.getDmoEType(), "*") }); //$NON-NLS-1$
					}
					return NLS.bind(Messages.CreateDependencyLinkDialog_10, weight, PropertyUtils
							.getDmoName(data.getDmo()));
				}
				return ""; //$NON-NLS-1$
			}
			return ""; //$NON-NLS-1$
		}

		public void addListener(ILabelProviderListener arg0) {
		}

		public void dispose() {
		}

		public boolean isLabelProperty(Object arg0, String arg1) {
			return false;
		}

		public void removeListener(ILabelProviderListener arg0) {
		}
	}

	private static class ProvidesLabelProvider implements ITableLabelProvider {

		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			switch (columnIndex)
			{
			case 0:
				if (element instanceof UnitData) {
					return PropertyUtils.getDmoName(((UnitData) element).getUnit());
				} else if (element instanceof NubData) {
					NubData data = (NubData) element;
					String weight = Integer.toString(data.getWeight()) + "%"; //$NON-NLS-1$
					if (data.getDmo() instanceof Capability) {
						Capability cap = (Capability) data.getDmo();
						return NLS.bind(Messages.CreateDependencyLinkDialog_9, new Object[] { weight,
								PropertyUtils.getDmoName(cap),
								PropertyUtils.getDisplayEType(cap.eClass(), "*") }); //$NON-NLS-1$
					}
					return NLS.bind(Messages.CreateDependencyLinkDialog_10, weight, PropertyUtils
							.getDmoName(data.getDmo()));
				}
				return ""; //$NON-NLS-1$
			}
			return ""; //$NON-NLS-1$
		}

		public void addListener(ILabelProviderListener listener) {
		}

		public void dispose() {
		}

		public boolean isLabelProperty(Object element, String property) {
			return false;
		}

		public void removeListener(ILabelProviderListener listener) {
		}
	}

	/**
	 * As a result of user editing of popup's Capabilities, the contents of the list could become
	 * dirty. Listen for changes.
	 */
	private void listenForObjectNameChanges(DeployModelObject dmo) {
		_editDmo = dmo;
		TransactionalEditingDomain theEditingDomain = TransactionUtil.getEditingDomain(dmo);
		if (theEditingDomain != null) {
			theEditingDomain.addResourceSetListener(eventListener);
		}
	}

	private void stopListeningForObjectNameChanges() {
		if (_editDmo != null) {
			TransactionalEditingDomain theEditingDomain = TransactionUtil.getEditingDomain(_editDmo);
			if (theEditingDomain != null) {
				theEditingDomain.removeResourceSetListener(eventListener);
			}
		}
		_editDmo = null;
	}

	/**
	 * event listener; catches multiplexed events and routes them to us. We are interested in<br>
	 * 1. the list of Capabilities changing<br>
	 * 2. the name changing for the current capability.
	 */
	private final ResourceSetListenerImpl eventListener = new ResourceSetListenerImpl(getFilter()) {

		public void resourceSetChanged(ResourceSetChangeEvent event) {

			if (!_requiresTreeView.getTree().isDisposed() && _editDmo != null) {
				getShell().getDisplay().asyncExec(new Runnable() {

					public void run() {
						refreshDmo(_editDmo, _requiresTreeView);
						refreshDmo(_editDmo, _providesTreeView);
					}
				});
			}
		}

		public boolean isPostcommitOnly() {
			return true;
		}

	};

	protected void refreshDmo(DeployModelObject dmo, TreeViewer treeView) {
		refreshDmoHelper(dmo, treeView.getTree().getItems(), treeView);
	}

	private boolean refreshDmoHelper(DeployModelObject dmo, TreeItem[] items, TreeViewer treeView) {
		for (int i = 0; i < items.length; i++) {
			if (refreshDmoHelper(dmo, items[i].getItems(), treeView)) {
				return true;
			}
			if (items[i].getData() instanceof NubData) {
				NubData data = (NubData) items[i].getData();
				if (dmo != null && dmo == data.getDmo()) {
					treeView.refresh(data);
					return true;
				}
			}
		}

		return false;
	}

	private List<UnitData> processUnits(Set<Unit> units, EditPart ep, Unit unit, Set<Unit> allUnits,
			EditPartViewer viewer) {
		List<EditPart> epList = new ArrayList<EditPart>();
		allUnits.clear();
		if (ep != null) {
			epList.add(ep);
		} else {
			for (Unit u : units) {
				List<DeployShapeNodeEditPart> l = GMFUtils.getEditPartsFor(viewer, u);
				if (l.size() > 0) {
					epList.add(l.get(0));
				}
			}
		}
		List<UnitData> list = new ArrayList<UnitData>();
		processUnitsHelper(epList, list, allUnits);
		IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
		if (!_creatingCapabitltiy && store != null
				&& store.getBoolean(IDeployPreferences.DEPLOY_DLCP_FILTER_0_MATCHES)) {
			pruneUnitList(list, units);
		}
		return list;
	}

	private static void processUnitsHelper(List<EditPart> children, List<UnitData> list,
			Set<Unit> allUnits) {
		for (Iterator<EditPart> it = children.iterator(); it.hasNext();) {
			EditPart ep = it.next();
			if (ep instanceof DeployShapeNodeEditPart) {
				DeployShapeNodeEditPart dsep = (DeployShapeNodeEditPart) ep;
				Unit unit = (Unit) dsep.resolveSemanticElement();
				if (!allUnits.contains(unit)) {
					allUnits.add(unit);
					UnitData data = new UnitData(unit);
					list.add(data);
					IGraphicalEditPart child = dsep
							.getChildBySemanticHint(DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
					if (child != null) {
						processUnitsHelper(child.getChildren(), data.getChildren(), allUnits);
					}
					child = dsep.getChildBySemanticHint(DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
					if (child != null) {
						processUnitsHelper(child.getChildren(), data.getChildren(), allUnits);
					}
					child = dsep
							.getChildBySemanticHint(DeployCoreConstants.IMPORTTOPOLOGYLIST_SEMANTICHINT);
					if (child != null) {
						processUnitsHelper(child.getChildren(), data.getChildren(), allUnits);
					}
					child = dsep
							.getChildBySemanticHint(DeployCoreConstants.DIAGRAMNODELIST_SEMANTICHINT);
					if (child != null) {
						processUnitsHelper(child.getChildren(), data.getChildren(), allUnits);
					}
				}
			}
		}
	}

	private void pruneUnitList(List<UnitData> list, Set<Unit> units) {
		boolean[] pruned = new boolean[] { true };
		while (pruned[0]) {
			pruned[0] = false;
			pruneUnitListHelper(list, units, pruned);
		}
	}

	private void pruneUnitListHelper(List<UnitData> list, Set<Unit> units, boolean[] pruned) {
		for (int i = 0; i < list.size(); i++) {
			UnitData data = list.get(i);
			if (data.getChildren().size() == 0) {
				if (!units.contains(data.getUnit())) {
					list.remove(i--);
					pruned[0] = true;
				}
			} else {
				pruneUnitListHelper(data.getChildren(), units, pruned);
			}
		}
	}

	private NotificationFilter getFilter() {
		// We listen to property sets.  We also listen to add/remove (might help with 
		// edit topology {@link Property} overrides
		NotificationFilter retVal = NotificationFilter.createEventTypeFilter(Notification.SET).or(
				NotificationFilter.createEventTypeFilter(Notification.ADD)).or(
				NotificationFilter.createEventTypeFilter(Notification.REMOVE));
		return retVal;
	}
}
