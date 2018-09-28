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

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.util.Geometry;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.dialogs.PatternFilter;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.properties.DeployUIWidgetFactory;
import com.ibm.ccl.soa.deploy.core.ui.util.ResourceUtils;

/**
 * @since 7.0
 * 
 */
public abstract class DmoPrimaryPopupDialog extends PopupDialog {

	private final class DetailsAdapter implements Adapter {
		private EObject detail;

		public void setTarget(Notifier newTarget) {
		}

		public void notifyChanged(final Notification notification) {
			Runnable runnable = new Runnable() {
				public void run() {
					if (treeViewer != null && !treeViewer.getTree().isDisposed()) {
						treeViewer.update(new Object[] { notification.getNotifier() }, null);
					}
				}
			};

			if (Display.getCurrent() == null) {
				Display.getDefault().syncExec(runnable);
			} else {
				runnable.run();
			}
		}

		public boolean isAdapterForType(Object type) {
			return false;
		}

		public Notifier getTarget() {
			return null;
		}

		public void setDetial(EObject newDetail) {
			if (detail != null) {
				if (detail == newDetail) {
					return;
				}
				detail.eAdapters().remove(this);
			}
			detail = newDetail;
			if (detail != null) {
				detail.eAdapters().add(this);
			}
		}

		public void dispose() {
			if (detail != null) {
				detail.eAdapters().remove(this);
			}
		}
	}

	/*
	 * The delay before showing a secondary popup.
	 */
	private static final int POPUP_DELAY = 250;

	/*
	 * The listener installed in order to close the popup.
	 */
	protected PopupCloserListener popupCloser;
	private Thread detailDialogThread;
	private Object cacheObj;
	private PatternFilter filter;
	private ToolBarManager toolBarManager;
	private DetailsAdapter detailsAdapter;

	private final Point initialLocation;
	private boolean isDmoImported = false;
	protected DeployModelObject dmo;

	protected PopupDialog detailDialog;

	private Text textFilter;

	private Composite dialogComposite;

	private TreeViewer treeViewer;

	private Object currentDetailInput;

	private Composite titleComposite;

	private UndoRedoActionGroup globalActionGroup;

	private Composite modifiedStatusBar;

	/**
	 * 
	 * @param parent
	 *           Parent {@link Shell}.
	 * @param aDmo
	 *           A {@link DeployModelObject} that is the context of this dialog.
	 * @param initialPoint
	 *           The {@link Point} for the initial location.
	 * @param title
	 *           An optional title string.
	 * @param info
	 *           An optional status string.
	 */
	public DmoPrimaryPopupDialog(Shell parent, DeployModelObject aDmo, Point initialPoint,
			String title, String info) {
		this(parent, aDmo, initialPoint, true, true, title, info);
	}

	/**
	 * 
	 * @param parent
	 *           Parent {@link Shell}.
	 * @param aDmo
	 *           A {@link DeployModelObject} that is the context of this dialog.
	 * @param initialPoint
	 *           The {@link Point} for the initial location.
	 * @param persistSize
	 *           A boolean indicating whether the size should be persisted upon close of the dialog.
	 *           The size can only be persisted if the dialog settings for persisting the bounds are
	 *           also specified. If a menu action will be provided that allows the user to control
	 *           this feature, then the last known value of the user's setting will be used instead
	 *           of this flag.
	 * @param showPersistAction
	 *           A boolean indicating whether an action allowing the user to control the persisting
	 *           of the dialog bounds should be shown in the dialog menu. This parameter has no
	 *           effect if <code>showDialogMenu</code> is <code>false</code>.
	 * @param title
	 *           An optional title string.
	 * @param info
	 *           An optional status string.
	 */
	public DmoPrimaryPopupDialog(Shell parent, DeployModelObject aDmo, Point initialPoint,
			boolean persistSize, boolean showPersistAction, String title, String info) {
		super(parent, SWT.RESIZE, true, persistSize, false, true, showPersistAction, title, info);
		initialLocation = initialPoint;
		if (aDmo != null) {
			isDmoImported = aDmo.getTopology() != aDmo.getEditTopology();
		}
		dmo = aDmo;
	}

	protected boolean isImportedDmo() {
		return isDmoImported;
	}

	protected Point getInitialLocation() {
		return initialLocation;
	}

	protected Point getInitialLocation(Point initialSize) {
		return initialLocation;
	}

	/**
	 * This method is extended in order to add the control listener when the popup is opened.
	 */
	public int open() {
		int retVal = super.open();
		registerKeyBindings();
		if (textFilter != null) {
			textFilter.setFocus();
			textFilter.selectAll();
		}
		if (popupCloser == null) {
			popupCloser = createPopupCloseListener();
		}
		return retVal;
	}

	protected PopupCloserListener createPopupCloseListener() {
		return new PopupCloserListener(this);
	}

	private void registerKeyBindings() {
		//Register action group.
		IEditorPart editorPart = ResourceUtils.getActiveEditorPart();
		if (editorPart != null) {
			globalActionGroup = new UndoRedoActionGroup(editorPart);
		}
	}

	/**
	 * Closes this popup. This method is extended to remove the control listener.
	 * 
	 * @return <code>true</code> if the window is (or was already) closed, and <code>false</code>
	 *         if it is still open
	 */
	public boolean close() {
		if (popupCloser != null) {
			popupCloser.dispose();
		}
		if (detailDialog != null) {
			detailDialog.close();
		}
		if (detailsAdapter != null) {
			detailsAdapter.dispose();
		}
		if (toolBarManager != null) {
			toolBarManager.dispose();
		}
		if (globalActionGroup != null) {
			globalActionGroup.dispose();
		}
		return super.close();
	}

	/*
	 * Overridden to force change of colors. See https://bugs.eclipse.org/bugs/show_bug.cgi?id=136244
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.PopupDialog#createContents(org.eclipse.swt.widgets.Composite)
	 */
	protected Control createContents(Composite parent) {
		if (isTextFilterRequired()) {
			filter = new PatternFilter();
		}
		Control control = super.createContents(parent);
		changeDefaultColors(parent);
		if (!hasInfoArea()) {
			DeployUIWidgetFactory.INSTANCE.createModifiedStatusBarWithClose(parent, this);
		}
		if (isTextFilterRequired()) {
			setTreeFilter(filter);
			textFilter.setFocus();
		}
		return control;
	}

	/*
	 * Set the colors of the popup. The contents have already been created.
	 */
	private void changeDefaultColors(Control control) {
		if (shouldUseListColors()) {
			applyForegroundColor(getShell().getDisplay().getSystemColor(SWT.COLOR_LIST_FOREGROUND),
					control);
			applyBackgroundColor(getShell().getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND),
					control);
		}
	}

	@Override
	protected final Control createDialogArea(Composite parent) {
		dialogComposite = doCreateDialogArea(parent);
		treeViewer = getTreeViewer();
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
//				System.out.println("selection changed"); //$NON-NLS-1$
				if (event.getSelection() instanceof IStructuredSelection) {
					IStructuredSelection ss = (IStructuredSelection) event.getSelection();
					if (ss.size() != 1) {
//						System.out.println("size not 1::closing"); //$NON-NLS-1$
						closeDetailDialog();
					} else {
						Object selection = ss.getFirstElement();
//						System.out.println("showing first element = " + selection); //$NON-NLS-1$
						if (selection != null) {
							showDetails(selection);
						} else {
							closeDetailDialog();
						}
					}
				} else {
					closeDetailDialog();
				}
			}
		});
		return dialogComposite;
	}

	/*
	 * Show the details in a secondary popup.
	 */
	protected void showDetails(final Object obj) {
//		System.out.println("show details"); //$NON-NLS-1$
		if (!canShowDetails(obj)) {

			closeDetailDialog();
			return;
		}
//		System.out.println("Can show details"); //$NON-NLS-1$
		if (dialogComposite.isDisposed()) {
//			System.out.println("dialogComposite is disposed"); //$NON-NLS-1$
			return;
		}
		if (detailDialogThread != null && detailDialogThread.isAlive()) {
			detailDialogThread.interrupt();
		}
		getShell().getDisplay().syncExec(new Runnable() {

			public void run() {
				if (obj == null) {
//					System.out.println("close details"); //$NON-NLS-1$
					closeDetailDialog();
					return;
				}
				if (currentDetailInput == obj && detailDialog != null
						&& !detailDialog.getShell().isDisposed()) {
//					System.out.println("current detail input is the same"); //$NON-NLS-1$
					//It's the same input object so there is nothing to do.
					return;
				}
				currentDetailInput = obj;
				if (internalCanReuseDetailDialog(obj)) {
//					System.out.println("reusing current dialog"); //$NON-NLS-1$
					internalSetDetailDialogInput(detailDialog, obj);
				} else {
					//Cannot reuse it so make sure we close any that are open.
					closeDetailDialog();
//					System.out.println("Trying show details"); //$NON-NLS-1$
					Runnable runnable = new Runnable() {
						public void run() {
							try {
								Thread.sleep(POPUP_DELAY);
							} catch (InterruptedException e) {
							}
							if (dialogComposite.isDisposed() || getShell() == null
									|| getShell().isDisposed() || getShell().getDisplay() == null) {

								return;
							}
							getShell().getDisplay().syncExec(new Runnable() {
								public void run() {
									//If the detailDialog is not open and there are multiple shells then 
									//another window has opened before we did so don't open now.
									/*
									 * if (detailDialog == null && getShell().getShells().length > 0) {
									 * detailDialog = createDetailDialog(obj); return; }
									 */
									// Query the current selection since we have
									// been delayed
									if (cacheObj != null && cacheObj.getClass() != obj.getClass()) {
//										System.out.println("current selection no good anymore"); //$NON-NLS-1$
										closeDetailDialog();
										return;
									}
//									System.out.println("Finally show details"); //$NON-NLS-1$
									Point point = null;
									detailDialog = createDetailDialog(obj);
									if (detailDialog != null) {
										detailDialog.create();
										internalSetDetailDialogInput(detailDialog, obj);
										Rectangle rect = getShell().getBounds();
										Rectangle detailRect = getAdjustedDetailDialogBounds();
										Monitor monitor = getActiveMonitor();
										if (monitor != null) {
											Rectangle monitorBounds = monitor.getBounds();
											if (rect.x - monitorBounds.x + rect.width + detailRect.width > monitorBounds.width) {
												// Open to the left.
												point = new Point(rect.x - detailRect.width, rect.y);
											} else {
												// Open to the right.
												point = new Point(rect.x + rect.width, rect.y);
											}
											detailDialog.getShell().setLocation(point);
											if (popupCloser == null) {
												return;
											}
											popupCloser.setSecondaryPopup(detailDialog);
											detailDialog.open();
											detailDialog.getShell().addDisposeListener(new DisposeListener() {
												public void widgetDisposed(DisposeEvent event) {
//													System.out.println("setting detail dialog to null"); //$NON-NLS-1$
													detailDialog = null;
												}
											});
										}
									}
								}
							});
						}
					};

					cacheObj = obj;

					detailDialogThread = new Thread(runnable);
					detailDialogThread.start();

				}
			}
		});
	}

	protected Monitor getActiveMonitor() {
		Monitor activeMonitor = null;
		Display display = Display.getCurrent();
		if (display != null) {
			Point location = getShell().getLocation();
			Monitor[] monitors = display.getMonitors();
			if (monitors.length == 1) {
				activeMonitor = monitors[0];
			} else if (monitors.length > 0) {
				int closest = Integer.MAX_VALUE;
				for (Monitor monitor : monitors) {
					Rectangle clientArea = monitor.getClientArea();

					if (clientArea.contains(location)) {
						activeMonitor = monitor;
						break;
					}

					int distance = Geometry.distanceSquared(Geometry.centerPoint(clientArea), location);
					if (distance < closest) {
						closest = distance;
						activeMonitor = monitor;
					}
				}
			}
		}
		return activeMonitor;
	}

	/**
	 * Create a new {@link PopupDialog} for the detail popup. The selectedObject may be used to
	 * determine the type of dialog to create but it is not necessary to set the input of the dialog
	 * at this time since {@link #setDetailDialogInput(PopupDialog, Object)} will be called.
	 * 
	 * @param selectedObject
	 * @return A {@link PopupDialog}
	 */
	protected abstract PopupDialog createDetailDialog(Object selectedObject);

	private void internalSetDetailDialogInput(PopupDialog aDetailDialog, Object newInput) {
		if (newInput instanceof EObject) {
			getDetailsAdapter().setDetial((EObject) newInput);
		}
		setDetailDialogInput(aDetailDialog, newInput);
	}

	/**
	 * 
	 * @param aDetailDialog
	 *           The detail {@link Dialog}.
	 * @param newInput
	 *           The new input object.
	 */
	protected abstract void setDetailDialogInput(PopupDialog aDetailDialog, Object newInput);

	/**
	 * 
	 * @param object
	 * @return True if a details dialog can be opened on the selected object.
	 */
	protected abstract boolean canShowDetails(Object object);

	protected abstract Composite doCreateDialogArea(Composite parent);

	/**
	 * Subclasses should override if they do NOT want list colors (i.e., white) for the background.
	 * 
	 * @return A boolean
	 */
	protected boolean shouldUseListColors() {
		return true;
	}

	protected boolean shouldUseDefaultTitleControl() {
		return false;
	}

	protected Control createTitleControl(Composite parent) {
		if (shouldUseDefaultTitleControl()) {
			return super.createTitleControl(parent);
		}
		titleComposite = new Composite(parent, SWT.NONE);
		int columns = isToolBarRequired() ? 2 : 1;
		GridLayout layout = new GridLayout(columns, false);
		layout.marginHeight = POPUP_MARGINHEIGHT;
		layout.marginWidth = POPUP_MARGINWIDTH;
		layout.verticalSpacing = POPUP_VERTICALSPACING;
		layout.horizontalSpacing = POPUP_HORIZONTALSPACING;
		titleComposite.setLayout(layout);
		titleComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		if (isTextFilterRequired()) {
			textFilter = createTextFilter(titleComposite);
			addListenerFilterListeners();
		}
		if (isToolBarRequired()) {
			createToolBar(titleComposite);
		}

		return titleComposite;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List getBackgroundColorExclusions() {
		List result = super.getBackgroundColorExclusions();
		DeployUIWidgetFactory.INSTANCE.addWithChildren(modifiedStatusBar, result);
		return result;
	}

	@Override
	protected Control createInfoTextArea(Composite parent) {
		modifiedStatusBar = DeployUIWidgetFactory.INSTANCE.createModifiedDialogStatusBar(parent, 2);
		Label label = (Label) super.createInfoTextArea(modifiedStatusBar);
		//Switch alignment to the left.
		label.setAlignment(SWT.LEFT);
		DeployUIWidgetFactory.INSTANCE.createCloseHyperlink(modifiedStatusBar, this);
		return modifiedStatusBar;
	}

	protected Text createTextFilter(Composite aTitleComposite) {
		textFilter = new Text(titleComposite, SWT.NULL);
		textFilter.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		textFilter.setText(Messages.QuickPalettePopup_Enter_a_value_to_filter_list_);
		return textFilter;
	}

	private void addListenerFilterListeners() {
		textFilter.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				expandTree();
				filter.setPattern(textFilter.getText());
				refreshTree();
				selectFirstInTree();
			}
		});
		textFilter.addKeyListener(new KeyListener() {

			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.ARROW_DOWN) {
					setTreeFocus();
				}
			}

			public void keyReleased(KeyEvent e) {
				// do nothing
			}
		});
	}

	/**
	 * This method must be implemented if {@link #isToolBarRequired()} returns true.
	 * 
	 * @param parent
	 *           The parent {@link Composite};
	 * 
	 * @see #isToolBarRequired()
	 */
	protected void createToolBar(Composite parent) {
		ToolBar toolBar = new ToolBar(parent, SWT.FLAT);
		toolBar.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));
		toolBarManager = new ToolBarManager(toolBar);
		initializeToolBar(toolBar, toolBarManager);
		toolBarManager.update(true);
	}

	/**
	 * @return True if you want to filter the tree items using a text filter in the title.
	 * 
	 * @see #expandTree()
	 */
	protected abstract boolean isTextFilterRequired();

	/**
	 * Must implement if {@link #isTextFilterRequired()} returns true.
	 */
	protected void expandTree() {
		if (treeViewer != null) {
			treeViewer.expandAll();
		}
	}

	private void selectFirstInTree() {
		if (treeViewer != null) {
			Object result = null;
			// Select the first in the tree
			TreeItem rootItems[] = treeViewer.getTree().getItems();
			if (rootItems.length > 0) {
				result = rootItems[0].getData();
				treeViewer.setSelection(new StructuredSelection(result), true);
			}
		}
	}

	private void refreshTree() {
		if (treeViewer != null) {
			treeViewer.refresh();
		}
	}

	private void setTreeFocus() {
		dialogComposite.setFocus();
	}

	private void setTreeFilter(PatternFilter aFilter) {
		if (treeViewer != null) {
			treeViewer.addFilter(aFilter);
		}
	}

	/**
	 * Must implement {@link #createToolBar(Composite)} if this returns true.
	 * 
	 * @return A booelan
	 * 
	 * @see #initializeToolBar(Composite, ToolBarManager)
	 */
	protected abstract boolean isToolBarRequired();

	/**
	 * You must implement this method if you return true for {@link #isToolBarRequired()}. This is
	 * your opportunity to add actions to the toolbar.
	 * 
	 * @param parent
	 *           The parent {@link Composite}.
	 * @param aToolBarManager
	 *           A {@link ToolBarManager}.
	 */
	protected void initializeToolBar(Composite parent, ToolBarManager aToolBarManager) {
	}

	/**
	 * Return the tree viewer that is created for this dialog.
	 * 
	 * @return A {@link TreeViewer}.
	 */
	protected abstract TreeViewer getTreeViewer();

	@Override
	protected IDialogSettings getDialogSettings() {
		return DeployCoreUIPlugin.getDefault().getDialogSettings();
	}

	private DetailsAdapter getDetailsAdapter() {
		if (detailsAdapter == null) {
			detailsAdapter = new DetailsAdapter();
		}
		return detailsAdapter;
	}

	protected void closeDetailDialog() {
		cacheObj = null;
		currentDetailInput = null;
//		System.out.println("close detail"); //$NON-NLS-1$
		if (detailDialog != null) {
//			System.out.println("really closing"); //$NON-NLS-1$
			detailDialog.close();
		}
		if (detailsAdapter != null) {
			detailsAdapter.setDetial(null);
		}
	}

	private boolean internalCanReuseDetailDialog(Object newInput) {
		if (detailDialog == null || detailDialog.getShell() == null
				|| detailDialog.getShell().isDisposed()) {
			return false;
		}
		return canReuseDetailDialog(currentDetailInput, newInput);
	}

	/**
	 * Return true if the currently open detail dialog can be reused for the newInput givne the
	 * currentInput.
	 * 
	 * @param currentInput
	 *           The current input for the detail dialog that is open.
	 * @param newInput
	 *           The new input about to be set.
	 * @return A boolean.
	 */
	protected abstract boolean canReuseDetailDialog(Object currentInput, Object newInput);

	/**
	 * @return Returns the titleComposite.
	 */
	protected Composite getTitleComposite() {
		return titleComposite;
	}

	protected final PopupDialog getDetailDialog() {
		return detailDialog;
	}

	protected Rectangle getAdjustedDetailDialogBounds() {
		return detailDialog.getShell().getBounds();
	}
}
