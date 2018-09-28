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

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.decorators.ErrorMarkerDecorator;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployCoreEditor;
import com.ibm.ccl.soa.deploy.core.ui.internal.marker.DeployResolutionComposite;
import com.ibm.ccl.soa.deploy.core.ui.marker.quickfix.MarkerResolutionHelper;
import com.ibm.ccl.soa.deploy.core.ui.marker.quickfix.QuickFixDialog;
import com.ibm.ccl.soa.deploy.core.ui.util.ResourceUtils;
import com.ibm.ccl.soa.deploy.internal.core.validator.DeployValidatorJob;

public class QuickFixPrimaryDialog extends DmoPrimaryPopupDialog {
	private QuickFixStatusComposite statusComposite;
	private final IMarker[] markers;
	private final ErrorMarkerDecorator decorator;
	private IResolutionListener resolutionListener;
	private QuickFixPrimaryDialogToolBarManager quickFixToolBarManager;
	private List<DeployModelObject> dmoList = null;
	private boolean group = false;
	private DeployResolutionComposite resolutionComposite;
	private SashForm sash;
	private IJobChangeListener validationListener;

	public QuickFixPrimaryDialog(Shell parent, DeployModelObject dmo, Point initialPoint,
			String title, String info, IMarker[] markers, ErrorMarkerDecorator decorator) {
		super(parent, dmo, initialPoint, true, false, title, info);
		this.markers = markers;
		this.decorator = decorator;
		watchForValidationJobs();
	}

	public QuickFixPrimaryDialog(Shell parent, DeployModelObject dmo, Point initialPoint,
			String title, String info, IMarker[] markers, ErrorMarkerDecorator decorator,
			List<DeployModelObject> dmoList, boolean group) {
		this(parent, dmo, initialPoint, title, info, markers, decorator);
		this.dmoList = dmoList;
		this.group = group;
		watchForValidationJobs();
	}

	protected boolean shouldUseListColors() {
		return false;
	}

	private Topology getTopology() {
		if (dmoList != null && dmoList.size() > 0) {
			return dmoList.get(0).getTopology();
		}
		return dmo.getTopology();
	}

	protected boolean shouldUseDefaultTitleControl() {
		return false;
	}

	@Override
	protected boolean canReuseDetailDialog(Object currentInput, Object newInput) {
		return true;
	}

	@Override
	protected Composite doCreateDialogArea(Composite parent) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_STATUS);
		sash = new SashForm(parent, SWT.VERTICAL);
		sash.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		resolutionListener = new IResolutionListener() {

			public void handleResolution(ResolutionEvent event) {
				if (event.status == null || event.status.getSeverity() != IStatus.CANCEL) {
					// Don't close after each resolution; the statusComposite will refresh when validation updates
//					close(); 

				}
			}
		};
		statusComposite = new QuickFixStatusComposite(sash, SWT.NONE, dmo, markers, false, decorator,
				dmoList, group);
		if (quickFixToolBarManager != null) {
			quickFixToolBarManager.cacheViewerAndFilter(statusComposite.getTreeViewer(),
					statusComposite.getStatusFilter());
		}
		return statusComposite;
	}

	@Override
	protected TreeViewer getTreeViewer() {
		// TODO Auto-generated method stub
		return statusComposite.getTreeViewer();
	}

	@Override
	protected boolean isTextFilterRequired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean close() {
		if (statusComposite != null) {
			statusComposite.dispose();
		}
		unwatchValidationJobs();
		return super.close();
	}

	protected Text createTextFilter(Composite aTitleComposite) {
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		aTitleComposite.setLayout(layout);
		Label label = new Label(aTitleComposite, SWT.NONE);
		label.setText(Messages.QuickFixPrimaryDialog_Containing_text_);
		Text textFilter = new Text(aTitleComposite, SWT.BORDER);
		textFilter.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		return textFilter;
	}

	@Override
	protected boolean isToolBarRequired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected void setDetailDialogInput(PopupDialog detailDialog, Object newInput) {
		if (newInput instanceof IStatus) {
			((QuickFixDialog) detailDialog).updateResolutions((IStatus) newInput);
		}

	}

	protected void initializeToolBar(Composite parent, ToolBarManager toolBarManager) {
		quickFixToolBarManager = new QuickFixPrimaryDialogToolBarManager(toolBarManager);
		toolBarManager.getControl().setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));
	}

	@Override
	protected void showDetails(Object obj) {
		if (obj instanceof IStatus) {
			DeployResolutionComposite comp = getResolutionComposite();
			sash.setWeights(new int[] { 70, 30 });
			comp.updateResolutions((IStatus) obj);
			sash.layout();
		} else {
			closeDetailDialog();
		}
	}

	@Override
	protected void closeDetailDialog() {
		if (resolutionComposite != null && !resolutionComposite.isDisposed()) {
			resolutionComposite.dispose();
			sash.setWeights(new int[] { 100 });
			resolutionComposite = null;
			sash.layout();
		}
	}

	private DeployResolutionComposite getResolutionComposite() {
		if (resolutionComposite == null) {
			MarkerResolutionHelper resolutionHelper = new MarkerResolutionHelper(new IMarker[0]);
			resolutionComposite = new DeployResolutionComposite(sash, SWT.BORDER, getTopology(),
					resolutionHelper, resolutionListener);
		}
		return resolutionComposite;
	}

	@Override
	protected boolean canShowDetails(Object object) {
		return true;
	}

	@Override
	protected PopupDialog createDetailDialog(Object selectedObject) {
		return null;
	}

	@Override
	protected void fillDialogMenu(IMenuManager dialogMenu) {
		super.fillDialogMenu(dialogMenu);
		dialogMenu
				.add(new Action(Messages.QuickFixPrimaryDialog_Expand_Al_, DeployCoreUIPlugin
						.getDefault().getSharedImages().getImageDescriptor(
								ISharedImages.IMG_EXPAND_ALL_IMAGE)) {
					@Override
					public void run() {
						statusComposite.expandAll();
					}
				});

		dialogMenu.add(new Action(Messages.CollapseAction_Collapse_Al_, DeployCoreUIPlugin
				.getDefault().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_COLLAPSE_ALL_IMAGE)) {
			@Override
			public void run() {
				statusComposite.collapseAll();
			}
		});
	}

	/** Monitor for the end of validation */
	private void watchForValidationJobs() {
		validationListener = new JobChangeAdapter() {
			public void done(IJobChangeEvent event) {
				if (event.getJob() instanceof DeployValidatorJob) {
					validationComplete();
				}
			}
		};

		Job.getJobManager().addJobChangeListener(validationListener);
	}

	/** Stop monitoring of validation */
	private void unwatchValidationJobs() {
		if (validationListener != null) {
			Job.getJobManager().removeJobChangeListener(validationListener);
		}
	}

	private void validationComplete() {

		if (statusComposite != null) {
			final TreeViewer statusTreeViewer = statusComposite.getTreeViewer();
			if (statusTreeViewer != null) {
				Control treeControl = statusTreeViewer.getControl();
				if (!treeControl.isDisposed()) {
					treeControl.getDisplay().syncExec(new Runnable() {

						public void run() {

							Control treeControl = statusTreeViewer.getControl();
							if (!treeControl.isDisposed()) {
								DeployCoreEditor editor = ResourceUtils.getActiveDeployEditDomain();
								if (editor != null) {
									editor.validationComplete();
								}
								// The content provider used by the composite caches its results, 
								// so we must force it to re-evaluate its view of the world
								IContentProvider contentProvider = statusTreeViewer.getContentProvider();
								if (contentProvider != null) {
									if (contentProvider instanceof QuickFixStausContentProvider) {
										((QuickFixStausContentProvider) contentProvider).clearCache();
									}

									if (contentProvider instanceof IStructuredContentProvider) {
										Object[] elements = ((IStructuredContentProvider) contentProvider)
												.getElements(statusTreeViewer.getInput());
										if (elements.length > 0) {
											statusTreeViewer.refresh();
										} else {
											close();
										}
									}
								}
							}
						}
					});
				}
			}
		} else {
			// some how the listener was left hanging
			unwatchValidationJobs();
		}
	}
}
