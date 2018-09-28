/***************************************************************************************************
 * Copyright (c) 2007 IBM Corporation. All rights reserved.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.marker;

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolution2;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedFonts;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.ReportStatusDialog;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.ResolutionResultsDialog;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployCoreEditor;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.IResolutionListener;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.ResolutionEvent;
import com.ibm.ccl.soa.deploy.core.ui.marker.quickfix.MarkerResolutionHelper;
import com.ibm.ccl.soa.deploy.core.ui.marker.quickfix.MarkerResolutionInformationPresenter;
import com.ibm.ccl.soa.deploy.core.ui.marker.quickfix.TextPresenter;
import com.ibm.ccl.soa.deploy.core.ui.preferences.IDeployPreferences;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ResolutionResultsData;
import com.ibm.ccl.soa.deploy.core.ui.util.ResolutionUIUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ResourceUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.TopologyStateData;
import com.ibm.ccl.soa.deploy.core.util.DeployNLS;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployOperation;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus;

/**
 * A composite used to show resolutions for a DeployStatus.
 * 
 * @link {@link DeployStatus}.
 */
public class DeployResolutionComposite extends Composite {

	private static final boolean IS_MOTIF = Platform.WS_MOTIF.equals(Platform.getWS());

	private Table markerResolutionTable;
	private final Topology topology;
	private IMarkerResolution[] markerResolutions;
	private IDeployResolution[] deployResolutions;
	private MarkerResolutionInformationPresenter resolutionDescriptionPopUp;
	private String resolutionDesc = "unknown"; //$NON-NLS-1$
	private final IResolutionListener resolutionListener;
	private final DeployValidatorService validatorService;
	private MarkerResolutionHelper resolutionHelper;

	/**
	 * @param parent
	 * @param style
	 * @param aTopology
	 * @param aResolutionHelper
	 * @param aResolutionListener
	 */
	public DeployResolutionComposite(Composite parent, int style, Topology aTopology,
			MarkerResolutionHelper aResolutionHelper, IResolutionListener aResolutionListener) {
		super(parent, style);
		topology = aTopology;
		validatorService = ResourceUtils.getActiveDeployEditorValidatorService();
		resolutionListener = aResolutionListener;
		setResolutionHelper(aResolutionHelper);
		initialize();
	}

	public Control getFocusControl() {
		return markerResolutionTable;
	}

	public void setResolutionHelper(MarkerResolutionHelper aResolutionHelper) {
		assert aResolutionHelper != null;
		resolutionHelper = aResolutionHelper;
		markerResolutions = resolutionHelper.getResolutions();
	}

	public void updateResolutions(IStatus status) {
		List<IDeployResolution> rList = validatorService.getResolutions(status);
		deployResolutions = rList.toArray(new IDeployResolution[rList.size()]);
		markerResolutionTable.clearAll();
		initMarkerResolutions();
	}

	private void initialize() {
		GridLayout layout = new GridLayout();
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		setLayout(layout);
		setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		PlatformUI.getWorkbench().getHelpSystem().setHelp(this,
				IDeployHelpContextIds.TOPOLOGY_QUICK_FIX_RESOLUTION_WINDOW);

		createMarkerResolutionTable(this);
		initMarkerResolutions();

		IInformationControlCreator creator = createInformationControlCreator();
		resolutionDescriptionPopUp = new MarkerResolutionInformationPresenter(creator);

		resolutionDescriptionPopUp.install(markerResolutionTable);

		if (resolutionDescriptionPopUp != null) {
			resolutionDescriptionPopUp.setSizeConstraints(200, 10, true, true);
		}

		// add the selection listener
		markerResolutionTable.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				int selected = markerResolutionTable.getSelectionIndex();
				handleShowDescription(selected);
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				markerResolutionSelected();
			}
		});

		resolutionDescriptionPopUp.selectionChanged();

	}

	private IInformationControlCreator createInformationControlCreator() {
		IInformationControlCreator creator = new IInformationControlCreator() {

			public IInformationControl createInformationControl(Shell parent) {
				return new DefaultInformationControl(parent, SWT.NONE, new TextPresenter());
			}

		};
		return creator;
	}

	private void createMarkerResolutionTable(Composite parent) {
		if (IS_MOTIF) {
			markerResolutionTable = new Table(parent, SWT.H_SCROLL | SWT.V_SCROLL);
		} else {
			markerResolutionTable = new Table(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.VIRTUAL);
			Listener listener = new Listener() {
				public void handleEvent(Event event) {
					setData(event);
				}
			};
			markerResolutionTable.addListener(SWT.SetData, listener);

		}
		markerResolutionTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		markerResolutionTable.setHeaderVisible(false);
		markerResolutionTable.setLinesVisible(false);
		markerResolutionTable.setBackground(Display.getCurrent().getSystemColor(
				SWT.COLOR_INFO_BACKGROUND));
		markerResolutionTable.setForeground(Display.getCurrent().getSystemColor(
				SWT.COLOR_INFO_FOREGROUND));

		markerResolutionTable.setFont(DeployCoreUIPlugin.getDefault().getSharedFonts().getFont(
				ISharedFonts.INFO));
	}

	private void initMarkerResolutions() {
		if (isValid(markerResolutionTable)) {
			if (IS_MOTIF) {
				markerResolutionTable.setRedraw(false);
				if (hasResolutions()) {
					markerResolutionTable.setItemCount(markerResolutions.length
							+ deployResolutions.length);
				} else {
					markerResolutionTable.setItemCount(1);
				}
				TableItem[] items = markerResolutionTable.getItems();
				for (int i = 0; i < items.length; i++) {
					setTableItem(items[i], i);
				}
				markerResolutionTable.setRedraw(true);
			} else {
				if (hasResolutions()) {
					markerResolutionTable.setItemCount(markerResolutions.length
							+ deployResolutions.length);
				} else {
					markerResolutionTable.setItemCount(1);
				}
				markerResolutionTable.clearAll();
				// Set table items in response to events (see setData(Event)).
			}
			//markerResolutionTable.setSelection(0);
		}
	}

	private boolean isValid(Widget widget) {
		return widget != null && !widget.isDisposed();
	}

	/**
	 * @return true if the quick-fix has any resolutions, false otherwise.
	 */
	public boolean hasResolutions() {
		return markerResolutions != null && markerResolutions.length > 0 || deployResolutions != null
				&& deployResolutions.length > 0;
	}

	/**
	 * Sets the value of the quick-fix table item.
	 * 
	 * @param item
	 *           the table item to be set.
	 * @param index
	 *           the resolution index.
	 */
	private void setTableItem(TableItem item, int index) {
		if (!hasResolutions()) {
			item.setText(Messages.Resolution_no_suggestions_available);
			return;
		}

		if (index < markerResolutions.length) {
			IMarkerResolution resolution = markerResolutions[index];
			item.setText(resolution.getLabel());
			if (resolution instanceof IMarkerResolution2) {
				item.setImage(((IMarkerResolution2) resolution).getImage());
			}
			if (item.getImage() == null) {
				item.setImage(DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
						ISharedImages.IMG_ACTN_CORRECTION));
			}
			item.setData(resolution);

		} else {
			IDeployResolution resolution = deployResolutions[index - markerResolutions.length];
			item.setText(resolution.getDescription());
			item.setImage(DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
					ISharedImages.IMG_ACTN_CORRECTION));

			// TODO extract status text to create a tree-like view
		}
	}

	/**
	 * @return the selection {@link IMarkerResolution} or {@link IDeployResolution}, or null if no
	 *         selection has been made.
	 */
	private Object getTableSelection() {
		int i = getSelectionIndex();
		if (i < 0) {
			return null;
		} else if (i < markerResolutions.length) {
			resolutionDesc = markerResolutionTable.getItem(i).getText();
			return markerResolutions[i];
		} else if (i < markerResolutions.length + deployResolutions.length) {
			resolutionDesc = markerResolutionTable.getItem(i).getText();
			return deployResolutions[i - markerResolutions.length];
		}
		return null;
	}

	private void setData(Event event) {
		TableItem item = (TableItem) event.item;
		int index = markerResolutionTable.indexOf(item);
		setTableItem(item, index);
	}

	private void markerResolutionSelected() {
		Object resolution = getTableSelection();
		if (resolution instanceof IDeployResolution) {
			resolveWithUI((IDeployResolution) resolution);
		}
	}

	/**
	 * deal with the UI part of the resolution
	 */
	protected void resolveWithUI(final IDeployResolution resolution) {
		// put up wait cursor
		//		Cursor waitCursor = new Cursor(control.getShell().getDisplay(), SWT.CURSOR_WAIT);
		//		control.getShell().setCursor(waitCursor);

		BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {

			public void run() {
				// do the resolution which adds units to model
				IStatus status = resolve(resolution);

				// if the status wasn't success, put up a dialog to tell user
				if (!status.isOK() && status.getSeverity() != IStatus.CANCEL) {
					ReportStatusDialog dialog = new ReportStatusDialog(null, Messages.RESOLUTION_STATUS,
							Messages.RESOLUTION_COMPLETED_WITH_ERRORS, status);
					dialog.open();
				}
			}

		});
	}

	/**
	 * Resolves a deploy status resolution.
	 * 
	 * @param resolution
	 *           the bound resolution.
	 * 
	 * @return the status of resolution.
	 */
	protected IStatus resolve(final IDeployResolution resolution) {
		if (resolution == null) {
			return Status.CANCEL_STATUS;
		}

		/*
		 * 5108 Some resolutions may open another dialog that will cause the resolution dialog to
		 * close thus calling getShell() will throw an exception.
		 */
		final Point shellLocation = getShell().getLocation();
		// TODO run as job
		IStatus result = PropertyUtils.executeWithUndo(topology, new DeployOperation(resolution
				.getDescription()) {

			public IStatus run(IProgressMonitor monitor) {
				try {
					DeployCoreEditor editor = ResourceUtils.getActiveDeployEditDomain();
					if (editor != null) {
						final DeployDiagramEditPart diagramEP = (DeployDiagramEditPart) editor
								.getDiagramEditPart();
						if (diagramEP != null) {
							// save current state of the topology for highlighting topology changes later
							TopologyStateData state = new TopologyStateData(topology);

							// do the resolution
							IStatus localStatus = resolution.resolve(monitor);

							// if status is ok, select the new units/optionally open the results dialog
							if (localStatus == null || localStatus.isOK()) {
								state.markChanges();
								final Map<Object, ResolutionResultsData> results = ResolutionUIUtils
										.refreshAndHighlightTopologyDiff(state, shellLocation, true);
								if (results.size() > 0) {
									// if preference is set to open resolution results dialog, open it now
									IPreferenceStore store = DeployCoreUIPlugin.getDefault()
											.getPreferenceStore();
									if (store
											.getBoolean(IDeployPreferences.DEPLOY_ENABLE_QUICKFIX_RESULTS_DIALOG)) {
										Display.getDefault().asyncExec(new Runnable() {
											public void run() {
												ResolutionResultsDialog dlg = new ResolutionResultsDialog(
														results, null, resolutionDesc, diagramEP.getViewer());
												dlg.open();
											}
										});
									}
								}

							} else if (localStatus.getSeverity() == IStatus.ERROR) {
								// else put up error dialog
								MessageDialog.openError(null, Messages.QuickFixDialog_Resolution_Failur_,
										NLS.bind(Messages.QuickFixDialog_The_resolution_failed_0_,
												localStatus.getMessage()));
								DeployCorePlugin.log(localStatus);
							}
							return localStatus;
						}
					}
					return Status.CANCEL_STATUS;
				} catch (Throwable e) {
					String message = DeployNLS.bind(Messages.Resolution_0_failed_with_message_1,
							resolution, e);
					IStatus status1 = new Status(IStatus.ERROR, DeployCorePlugin.PLUGIN_ID, 0, message,
							e);
					DeployCorePlugin.log(status1);
					return status1;
				}
			}

		});
		if (resolutionListener != null) {
			ResolutionEvent resolutionEvent = new ResolutionEvent(result);
			resolutionListener.handleResolution(resolutionEvent);
		}
		return result;
	}

	/**
	 * @return the table used to display the resolutions
	 */
	public Table getResolutionTable() {
		return markerResolutionTable;
	}

	/**
	 * @return the index of the item selection
	 */
	public int getSelectionIndex() {
		return markerResolutionTable.getSelectionIndex();
	}

	/**
	 * @param selected
	 */
	private void handleShowDescription(int selected) {
		if (markerResolutionTable != null || !markerResolutionTable.isDisposed()) {
			if (selected > -1) {
				if (selected < markerResolutions.length) {
					if (markerResolutions[selected] instanceof IMarkerResolution2) {
						IMarkerResolution2 resolution2 = (IMarkerResolution2) markerResolutions[selected];
						markerResolutionTable.setToolTipText(resolution2.getDescription());
					} else {
						markerResolutionTable.setToolTipText(null);
					}
				} else if (selected - markerResolutions.length < deployResolutions.length) {
					markerResolutionTable.setToolTipText(deployResolutions[selected
							- markerResolutions.length].getDescription());
				} else {
					markerResolutionTable.setToolTipText(null);
				}

			} else {
				markerResolutionTable.setToolTipText(null);
			}
		}
	} // end handleShowDescription()

}
