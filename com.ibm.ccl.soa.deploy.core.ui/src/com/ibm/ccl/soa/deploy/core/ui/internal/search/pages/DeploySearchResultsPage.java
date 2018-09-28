package com.ibm.ccl.soa.deploy.core.ui.internal.search.pages;

import java.text.Collator;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.EMFEditPlugin;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.common.ui.action.actions.global.GlobalActionManager;
import org.eclipse.gmf.runtime.common.ui.action.global.GlobalActionId;
import org.eclipse.gmf.runtime.common.ui.services.util.CommonLabelProvider;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ColumnLayoutData;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.ISearchResultListener;
import org.eclipse.search.ui.ISearchResultPage;
import org.eclipse.search.ui.ISearchResultViewPart;
import org.eclipse.search.ui.SearchResultEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.part.Page;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.namespace.NamespaceCore;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.internal.search.Messages;
import com.ibm.ccl.soa.deploy.core.ui.internal.search.query.DeploySearchEvent;
import com.ibm.ccl.soa.deploy.core.ui.internal.search.query.DeploySearchResult;
import com.ibm.ccl.soa.deploy.core.ui.internal.search.query.Match;
import com.ibm.ccl.soa.deploy.core.ui.internal.search.query.Match.EObjectLookupCallback;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreSafeRunnable;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

public class DeploySearchResultsPage extends Page implements ISearchResultPage, IAdaptable {

	private static final boolean DEBUG = DeployCoreUIPlugin.getDefault().isDebugging()
			&& Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DeployCoreUIPlugin.PLUGIN_ID
							+ "/debug/" + DeploySearchResultsPage.class.getCanonicalName())); //$NON-NLS-1$

	private static final Object[] EMPTY_ARR = new Object[0];

	private final Object matchMutex = new Object();
	private final Collection matchesToUpdate = new HashSet();
	private final Collection matchesToRemove = new HashSet();

	/**
	 * The popup menu internal id
	 */
	private static final String POPUP_MENU_ID = "#PopupMenu"; //$NON-NLS-1$

	private static final String MENU_END = "-end"; //$NON-NLS-1$

	protected static final int MATCH_TYPE = 0;
	protected static final int FOUND = 1;
	protected static final int REFERENCER_URI = 2;

	/** Provides string based sorting on a given table column. */
	private class ColumnSorter implements Listener {
		private final int _columnIndex;
		private final Collator _collator = Collator.getInstance(Locale.getDefault());

		public ColumnSorter(int columnIndex) {
			_columnIndex = columnIndex;
		}

		/** Performs the column sorting and updates sort direction. */
		public void handleEvent(Event e) {
			sortTable(e);
			updateSortDirection(e);
		}

		/** Toggles the sort direction. */
		void updateSortDirection(Event e) {
			TableColumn sortColumn = fTable.getSortColumn();
			TableColumn currentColumn = (TableColumn) e.widget;
			TableItem[] selected = fTable.getSelection();
			int dir = fTable.getSortDirection();
			if (sortColumn == currentColumn) {
				dir = dir == SWT.UP ? SWT.DOWN : SWT.UP;
			} else {
				fTable.setSortColumn(currentColumn);
				dir = SWT.UP;
			}
			fTable.setSelection(selected);
			fTable.setSortDirection(dir);
		}

		/** Peforms string based sorting on the cached column. */
		void sortTable(Event e) {
			int cc = fTable.getColumnCount();
			TableItem[] items = fTable.getItems();
			for (int i = 1; i < items.length; i++) {
				String value1 = items[i].getText(_columnIndex);
				for (int j = 0; j < i; j++) {
					String value2 = items[j].getText(_columnIndex);
					if (compare(value1, value2)) {
						String[] values = new String[cc];
						Image[] images = new Image[cc];
						getValues(items[i], values, images);
						Object data = items[i].getData();
						items[i].dispose();
						TableItem item = new TableItem(fTable, SWT.NONE, j);
						item.setData(data);
						item.setText(values);
						item.setImage(images);
						items = fTable.getItems();
						break;
					}
				}
			}
		}

		/**
		 * Return <tt>true</tt> if the 2 strings should be different; otherwise returns
		 * <tt>false</tt>
		 */
		boolean compare(String value1, String value2) {
			return fTable.getSortDirection() == SWT.UP ? _collator.compare(value1, value2) < 0
					: _collator.compare(value1, value2) > 0;
		}

		/** caches the supplied item's text and images into the supplied arrays. */
		void getValues(TableItem item, String[] values, Image[] images) {
			for (int i = 0; i < values.length; i++) {
				values[i] = item.getText(i);
				images[i] = item.getImage(i);
			}
		}
	}

	public class TableDecoratingLabelProvider extends CommonLabelProvider implements
			ITableLabelProvider {

		private final AdapterFactoryLabelProvider delegateLabelProvider;

		public TableDecoratingLabelProvider() {
			super();
			delegateLabelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
					EMFEditPlugin.getComposedAdapterFactoryDescriptorRegistry()));
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
		 */
		@SuppressWarnings("unchecked")
		public Image getColumnImage(final Object element, final int columnIndex) {
			if (columnIndex == 0) {
				return null;
			}

			Image image = null;
			Match match = (Match) element;

			if (columnIndex == 1 || columnIndex == 2) {
				try {

					EObject eObject = columnIndex == 1 ? match.getReferencedEObject(false, false, false)
							: match.getReferencerEObject(false, false, false);

					if (NotationPackage.Literals.VIEW.isSuperTypeOf(eObject.eClass())) {

						View view = (View) eObject;
						Object viewElement = getViewElement(view, columnIndex == 1 ? match
								.getReferencedCallback() : match.getReferencerCallback());

						if (null != viewElement) {

							if (viewElement instanceof EObject) {
								image = getImage(new EObjectAdapter((EObject) viewElement));
							}

							if (null == image) {
								image = getImage(viewElement);
							}

							if (null == image) {
								image = getImage(new EObjectAdapter(view));
							}

							if (null == image) {
								image = getImage(view);
							}

						}
					}

					if (null == image) {
						image = getImage(new EObjectAdapter(eObject));
					}

					if (null == image) {
						image = getImage(eObject);
					}

				} catch (CoreException ex) {
					DeployCoreUIPlugin.logError(0, ex.getMessage(), ex);
					return null;
				}

				return null == image ? getImage(match) : image;
			}

			return getImage(ResourcesPlugin.getWorkspace().getRoot().getFile(
					new Path(match.getReferencing().toPlatformString(true))));
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
		 */
		@SuppressWarnings("unchecked")
		public String getColumnText(final Object element, final int columnIndex) {

			String text = null;
			Match match = (Match) element;

			try {

				EObject eObject = columnIndex == FOUND ? match
						.getReferencedEObject(false, false, false) : match.getReferencerEObject(false,
						false, false);

				if (columnIndex == MATCH_TYPE) {

					if (NotationPackage.Literals.VIEW.isSuperTypeOf(eObject.eClass())) {
						return Messages.DeploySearchResultsPage_View_o_;
					}

					return Messages.DeploySearchResultsPage_Reference_t_;
				}

				if (columnIndex == FOUND) {
					return getText(eObject, match, columnIndex);
				}

				if (columnIndex == REFERENCER_URI) {

					text = getText(eObject, match, columnIndex);
					URI uri = EcoreUtil.getURI(eObject);
					IFile file = WorkbenchResourceHelper.getPlatformFile(uri);
					IPath path = file.getFullPath().removeFileExtension();
					INamespaceFragmentRoot[] roots = NamespaceCore.locateRoots(file.getProject(),
							new NullProgressMonitor());
					for (int i = 0; i < roots.length; i++) {
						IPath rootPath = roots[i].getCorrespondingResource().getFullPath();
						int matchingSegments = path.matchingFirstSegments(rootPath);
						if (matchingSegments > 1) {
							path = path.removeFirstSegments(matchingSegments);
							break;
						}
					}

					String[] segments = path.segments();

					for (int i = segments.length - 1; i > -1; i--) {
						text += "::" + segments[i]; //$NON-NLS-1$
					}
					return text;
				}

			} catch (CoreException ex) {
				DeployCoreUIPlugin.logError(0, ex.getMessage(), ex);
				return null;
			}

			return match.getReferencing().toPlatformString(true)
					+ "#" + match.getReferencing().fragment(); //$NON-NLS-1$
		}

		private EObject getViewElement(View view, EObjectLookupCallback callback)
				throws CoreException {
			if (view.eIsProxy()) {
				return lightweightLoadProxy(view, NotationPackage.Literals.VIEW__ELEMENT, callback);
			}

			return view.getElement();
		}

		private EObject lightweightLoadProxy(EObject eObject, EReference eReference,
				EObjectLookupCallback callback) throws CoreException {
			if (!eObject.eIsProxy()) {
				return eObject;
			}

			URI uri = EcoreUtil.getURI(eObject);
			URI ref = (URI) callback.getIndexContext().getProxyData().getValue(uri, eReference);
			EObject proxy = callback.getEObject(ref, false, false, false);

			if (proxy == null) {

				// this means that the proxy (eObject) points to another proxy (ref) and 
				// the ProxyData class does not have any information about the proxy (ref)
//				return loadProxy(uri);
				return eObject;
			}

			return proxy;
		}

		private EObject lightweightLoadProxy(EObject eObject, EObjectLookupCallback callback)
				throws CoreException {
			if (!eObject.eIsProxy()) {
				return eObject;
			}

			URI uri = EcoreUtil.getURI(eObject);
			EObject proxy = callback.getEObject(uri, false, false, false);

			if (proxy == null) {
				return eObject;
			}

			return proxy;
		}

		private EObject loadProxy(URI uri) throws CoreException {
			EObject proxy = null;

			try {

				Resource resource = WorkbenchResourceHelper.getResource(uri, true);
				proxy = resource.getEObject(uri.fragment());

			} catch (Exception ex) {
				throw new CoreException(new Status(IStatus.ERROR, DeployCoreUIPlugin.PLUGIN_ID,
						IStatus.ERROR, ex.toString(), ex));
			}

			return proxy;
		}

		public String getText(EObject eObject, Match match, int column) throws CoreException {

			String text = new String();
			if (NotationPackage.Literals.VIEW.isSuperTypeOf(eObject.eClass())) {
				View view = (View) eObject;
				Object viewElement = getViewElement(view,
						column == DeploySearchResultsPage.FOUND ? match.getReferencedCallback() : match
								.getReferencerCallback());

				if (null != viewElement) {

					if (viewElement instanceof EObject) {
						text = getText(new EObjectAdapter((EObject) viewElement));
					}

					if (null == text || text.trim().length() == 0) {
						text = getText(viewElement);
					}

					if (null == text || text.trim().length() == 0) {
						text = getText(new EObjectAdapter(view));
					}

					if (null == text || text.trim().length() == 0) {
						text = getText(view);
					}
				}
			}

			if (null == text || text.trim().length() == 0) {
				if (CorePackage.Literals.DEPLOY_MODEL_OBJECT.isSuperTypeOf(eObject.eClass())) {
					if (column == DeploySearchResultsPage.FOUND) {
						EObject proxy = match.getReferencedCallback().getEObject(
								EcoreUtil.getURI(eObject), false, true, false);
						text = (String) match.getReferencedCallback().getIndexContext().getProxyData()
								.getValue(EcoreUtil.getURI(proxy),
										CorePackage.Literals.DEPLOY_MODEL_OBJECT__NAME);
					}
				}
			}

			if (null == text || text.trim().length() == 0) {
				EObject loaded = lightweightLoadProxy(eObject,
						column == DeploySearchResultsPage.FOUND ? match.getReferencedCallback() : match
								.getReferencerCallback());

				if (null == text || text.trim().length() == 0) {
					text = getText(loaded);
				}

				if (null == text || text.trim().length() == 0) {
					text = getText(new EObjectAdapter(loaded));
				}

				if ((null == text || text.trim().length() == 0) && null != delegateLabelProvider) {
					text = delegateLabelProvider.getText(eObject);
				}

				if ((null == text || text.trim().length() == 0) && null != delegateLabelProvider) {
					text = delegateLabelProvider.getText(loaded);
				}

				if (null == text || text.trim().length() == 0) {
					text = getText(match);
				}
			}

			return text;
		}

		public void dispose() {
			if (delegateLabelProvider != null) {
				delegateLabelProvider.dispose();
			}
			super.dispose();
		}

	}

	/**
	 * Selection provider adapter object (?)
	 * 
	 */
	private class SelectionProviderAdapter implements ISelectionProvider, ISelectionChangedListener {

		private final ListenerList fListeners = new ListenerList();

		public void addSelectionChangedListener(ISelectionChangedListener listener) {
			fListeners.add(listener);
		}

		public ISelection getSelection() {
			return fViewer.getSelection();
		}

		public void removeSelectionChangedListener(ISelectionChangedListener listener) {
			fListeners.remove(listener);
		}

		public void setSelection(ISelection selection) {
			fViewer.setSelection(selection);
		}

		public void selectionChanged(SelectionChangedEvent event) {
			// forward to my listeners
			SelectionChangedEvent wrappedEvent = new SelectionChangedEvent(this, event.getSelection());
			Object[] listeners = fListeners.getListeners();
			for (int i = 0; i < listeners.length; i++) {
				ISelectionChangedListener listener = (ISelectionChangedListener) listeners[i];
				listener.selectionChanged(wrappedEvent);
			}
		}

	}

	/**
	 * Content provider
	 */
	class SearchResultsContentProvider implements IStructuredContentProvider {

		private DeploySearchResult fResult;

		public void dispose() {
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
		 */
		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof DeploySearchResult) {
				return ((DeploySearchResult) inputElement).getElements().toArray();
			}

			return EMPTY_ARR;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer,
		 *      java.lang.Object, java.lang.Object)
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// clear();
			if (newInput == null) {
				fResult = null;
			} else if (newInput instanceof DeploySearchResult) {
				fResult = (DeploySearchResult) newInput;
				for (Iterator e = fResult.getElements().iterator(); e.hasNext();) {
					getTableViewer().add(e.next());
				}
				getTableViewer().refresh();
			}
		}

		/**
		 * @param objects
		 */
		public void clear() {
			if (getTableViewer() != null && !getTableViewer().getControl().isDisposed()) {
				getTableViewer().refresh();
			}
		}

		/**
		 * @param match -
		 *           add new match to the table
		 */
		public void addMatches(Collection matches) {
			getTableViewer().add(matches.toArray());
			getTableViewer().refresh();
		}

		/**
		 * @param match -
		 *           remove matcvh from the table
		 */
		public void removeMatches(Collection matches) {
			getTableViewer().remove(matches.toArray());
			getTableViewer().refresh();

		}

		/**
		 * @param match -
		 *           add new match to the table
		 */
		public void addMatch(Match match) {
			getTableViewer().add(match);
			getTableViewer().refresh();
		}

		/**
		 * @param match -
		 *           remove matcvh from the table
		 */
		public void removeMatch(Match match) {
			getTableViewer().remove(match);
			getTableViewer().refresh();

		}
	}

	private TableViewer fViewer;

	private DeploySearchResult fInput;

	private MenuManager fMenu;

	private ISearchResultViewPart fViewPart;

	private Table fTable;

	private SelectionProviderAdapter fViewerAdapter;

	private final ISearchResultListener fListener;

	private String fId;

	/**
	 * Cosntructor
	 */
	public DeploySearchResultsPage() {
		super();

		fListener = new ISearchResultListener() {

			public void searchResultChanged(SearchResultEvent e) {
				handleSearchResultsChanged(e);
			}
		};

	}

	public TableViewer getTableViewer() {
		return fViewer;
	}

	// multi-threaded update handling.
	private void handleSearchResultsChanged(final SearchResultEvent e) {
		// Process deltas since last activated
		asyncExec(new Runnable() {
			public void run() {

				SafeRunner.run(new DeployCoreSafeRunnable() {
					public void run() throws Exception {
						DeploySearchEvent me = (DeploySearchEvent) e;
						if (me.getKind() == DeploySearchEvent.REMOVED_ALL) {
							getViewPart().updateLabel();
							((SearchResultsContentProvider) getTableViewer().getContentProvider())
									.removeMatches(me.getMatches());
						} else if (me.getKind() == DeploySearchEvent.ADDED) {
							((SearchResultsContentProvider) getTableViewer().getContentProvider())
									.addMatches(me.getMatches());
						} else if (me.getKind() == DeploySearchEvent.REMOVED) {
							((SearchResultsContentProvider) getTableViewer().getContentProvider())
									.removeMatches(me.getMatches());
						}

						fViewPart.updateLabel();
					}
				});
			}
		});
	}

	@Override
	public void createControl(Composite parent) {

		// The table's column layout data which contains width information for each of the columns of the
		// table.
		ColumnLayoutData columnLayoutData[] = new ColumnLayoutData[3];
		columnLayoutData[0] = new ColumnPixelData(100);
		columnLayoutData[1] = new ColumnPixelData(150);
		columnLayoutData[2] = new ColumnPixelData(450);

		// The table's column headers
		String columnHeaders[] = new String[3];
		columnHeaders[0] = "Match type"; //$NON-NLS-1$
		columnHeaders[1] = "Found"; //$NON-NLS-1$
		columnHeaders[2] = "Referencer URI"; //$NON-NLS-1$

		fViewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.FULL_SELECTION);

		fViewer.setUseHashlookup(true);
//		fViewer.setLabelProvider(new TableDecoratingLabelProvider());
		fViewer.setLabelProvider(new DeploySearchResultsLabelProvider());
		fViewer.setContentProvider(new SearchResultsContentProvider());

		fTable = fViewer.getTable();
		fTable.setLinesVisible(true);
		fTable.setLayoutData(new GridData(GridData.FILL_BOTH));

		TableLayout layout = new TableLayout();
		fTable.setLayout(layout);
		fTable.setHeaderVisible(true);

		for (int i = 0; i < columnHeaders.length; i++) {
			layout.addColumnData(columnLayoutData[i]);
			TableColumn tc = new TableColumn(fTable, SWT.NONE, i);
			tc.setText(columnHeaders[i]);
			tc.setResizable(columnLayoutData[i].resizable);

			tc.addListener(SWT.Selection, new ColumnSorter(i));
		}

		// menus and tool bars
		IToolBarManager tbm = getSite().getActionBars().getToolBarManager();
		tbm.removeAll();

		fillToolbar(tbm);
		tbm.update(false);

		fMenu = new MenuManager(POPUP_MENU_ID);
		fMenu.setRemoveAllWhenShown(true);
		fMenu.setParent(getSite().getActionBars().getMenuManager());
		fMenu.addMenuListener(new IMenuListener() {

			public void menuAboutToShow(IMenuManager manager) {
				fillContextMenu(manager);
			}
		});

		fViewer.getControl().setMenu(fMenu.createContextMenu(fViewer.getControl()));

		fViewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				handleDoubleClick(event);
			}
		});

		fViewerAdapter = new SelectionProviderAdapter();
		fViewer.addSelectionChangedListener(fViewerAdapter);

		getSite().setSelectionProvider(fViewerAdapter);
		// Register menu
		getSite().registerContextMenu(fViewPart.getViewSite().getId(), fMenu, fViewerAdapter);
//		PlatformUI
//				.getWorkbench()
//				.getHelpSystem()
//				.setHelp(
//						parent,
//						com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.search.ui.text.AbstractTextSearchViewPage#fillToolbar(org.eclipse.jface.action.IToolBarManager)
	 */
	protected void fillToolbar(IToolBarManager tbm) {
		IActionBars actionBars = getSite().getActionBars();
		getSite().getWorkbenchWindow();
		if (actionBars != null) {
			actionBars.setGlobalActionHandler(ActionFactory.UNDO.getId(), GlobalActionManager
					.getInstance().createActionHandler(getSite().getPage(), GlobalActionId.UNDO));
			actionBars.setGlobalActionHandler(ActionFactory.REDO.getId(), GlobalActionManager
					.getInstance().createActionHandler(getSite().getPage(), GlobalActionId.REDO));

			actionBars.updateActionBars();

		}

	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {

		fViewer.removeSelectionChangedListener(fViewerAdapter);
		getTableViewer().getLabelProvider().dispose();

		super.dispose();

	}

	/**
	 * @param runnable
	 */
	private void asyncExec(final Runnable runnable) {
		final Control control = getControl();
		if (control != null && !control.isDisposed()) {
			Display currentDisplay = Display.getCurrent();
			if (currentDisplay == null || !currentDisplay.equals(control.getDisplay())) {
				// meaning we're not executing on the display thread of the
				// control
				control.getDisplay().asyncExec(new Runnable() {

					public void run() {
						if (control != null && !control.isDisposed()) {
							runnable.run();
						}
					}
				});
			} else {
				runnable.run();
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void setInput(ISearchResult search, Object viewState) {

		ISearchResult oldSearch = (ISearchResult) fViewer.getInput();
		fViewer.setInput(null);
		if (oldSearch != null) {
			oldSearch.removeListener(fListener);
		}

		fInput = (DeploySearchResult) search;
		if (search != null) {
			search.addListener(fListener);
			fViewer.setInput(search);
			if (viewState instanceof ISelection) {
				fViewer.setSelection((ISelection) viewState, true);
			}

		}
	}

	/**
	 * @param match -
	 *           select this element in the table
	 */
	public void highlight(Match match) {
		getTableViewer().setSelection(new StructuredSelection(match), true);
	}

	/**
	 * @param index
	 * @return
	 */
	public Match getElementAt(int index) {
		return (Match) getTableViewer().getElementAt(index);
	}

	/**
	 * @return
	 */
	public DeploySearchResult getInput() {
		return fInput;
	}

	/**
	 * @return - number of matches
	 */
	public int getElementCount() {
		return getInput() == null ? 0 : getInput().getElements().size();
	}

	/**
	 * Sets the view part
	 * 
	 * @param part
	 *           View part to set
	 */
	public void setViewPart(ISearchResultViewPart part) {
		fViewPart = part;
	}

	/**
	 * Returns the view part set with <code>setViewPart(ISearchResultViewPart)</code>.
	 * 
	 * @return The view part or <code>null</code> if the view part hasn't been set yet (or set to
	 *         null).
	 */
	public ISearchResultViewPart getViewPart() {
		return fViewPart;
	}

	/**
	 * This is called when a the user double clicks on the viewer. The default action is run.
	 * 
	 * @param event
	 *           the DoubleClickEvent, which we don't care about and could be null
	 */
	public void handleDoubleClick(DoubleClickEvent event) {

		if (getTableViewer().getSelection() instanceof StructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection) getTableViewer().getSelection();
			if (selection.isEmpty()) {
				return;
			}

			try {
				IHandlerService handlerService = (IHandlerService) getSite().getService(
						IHandlerService.class);
				handlerService.executeCommand(
						"com.ibm.ccl.soa.deploy.core.ui.search.selectInView", null); //$NON-NLS-1$
			} catch (ExecutionException ex) {
				DeployCoreUIPlugin.logError(0, ex.getMessage(), ex);
				ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
						Messages.DeploySearchResultsPage_Error_Ocurre_, ex.getMessage(), new Status(
								IStatus.ERROR, DeployCoreUIPlugin.PLUGIN_ID, ex.getMessage(), ex));
			} catch (NotDefinedException ex) {
				DeployCoreUIPlugin.logError(0, ex.getMessage(), ex);
				ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
						Messages.DeploySearchResultsPage_Error_Ocurre_, ex.getMessage(), new Status(
								IStatus.ERROR, DeployCoreUIPlugin.PLUGIN_ID, ex.getMessage(), ex));
			} catch (NotEnabledException ex) {
				DeployCoreUIPlugin.logError(0, ex.getMessage(), ex);
				ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
						Messages.DeploySearchResultsPage_Error_Ocurre_, ex.getMessage(), new Status(
								IStatus.ERROR, DeployCoreUIPlugin.PLUGIN_ID, ex.getMessage(), ex));
			} catch (NotHandledException ex) {
				DeployCoreUIPlugin.logError(0, ex.getMessage(), ex);
				ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
						Messages.DeploySearchResultsPage_Error_Ocurre_, ex.getMessage(), new Status(
								IStatus.ERROR, DeployCoreUIPlugin.PLUGIN_ID, ex.getMessage(), ex));
			}
		}

	}

	/**
	 * Adds action for the selected foundElement to the menumanager. These actions could be different
	 * depending on the foundElement. Different actions will be added based on different reasons for
	 * matching
	 * 
	 * @param menu,
	 *           the IMenuManager that the actions for this foundElement will be added to.
	 */
	void fillContextMenu(IMenuManager menu) {

		// to avoid the message Context menu does not contain standard group for
		// additions (additions)

		menu.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
		menu.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS + MENU_END));

	}

	/**
	 * {@inheritDoc}
	 */
	public void setFocus() {
		Control control = fViewer.getControl();
		if (control != null && !control.isDisposed()) {
			control.setFocus();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Control getControl() {
		return getTableViewer().getControl();
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getUIState() {
		return fViewer.getSelection();
	}

	/**
	 * Subclasses may extend this method.
	 */
	public void restoreState(IMemento memento) {
		// nothing for now
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.search.ui.ISearchResultPage#saveState(org.eclipse.ui.IMemento)
	 */
	public void saveState(IMemento memento) {
		// nothing for now
	}

	/**
	 * {@inheritDoc}
	 */
	public void setID(String id) {
		fId = id;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getID() {
		return fId;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getLabel() {
		DeploySearchResult result = getInput();
		if (result == null) {
			return StringStatics.BLANK;
		}
		return result.getLabel();
	}

	/*
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	public Object getAdapter(Class adapter) {
		if (IWorkbenchPart.class == adapter) {
			return getViewPart();
		}

		return null;
	}
}
