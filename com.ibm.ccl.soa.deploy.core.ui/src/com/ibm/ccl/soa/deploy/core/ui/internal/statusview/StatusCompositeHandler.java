/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.statusview;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.IFormColors;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.internal.marker.DeployResolutionComposite;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.QuickFixStatusLabelProvider;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.StatusViewFilter;
import com.ibm.ccl.soa.deploy.core.ui.marker.quickfix.MarkerResolutionHelper;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatus;
import com.ibm.ccl.soa.deploy.internal.core.validator.status.DeployStatusGrouper;

public class StatusCompositeHandler extends CompositeHandler {
	private Label labelImage = null;
	private static Color titleForeGroundColor = new Color(Display.getCurrent(), 53, 53, 53);
	private static Color ErrorColor = new Color(Display.getCurrent(), 255, 228, 225);
	public final static String EMPTY_STRING = ""; //$NON-NLS-1$

	private final static Image ERROR_IMAGE = DeployCoreUIPlugin.getDefault().getSharedImages()
			.getImage(ISharedImages.IMG_ERROR16);
	public final static Image SUCCESS_IMAGE = DeployCoreUIPlugin.getDefault().getSharedImages()
			.getImage(ISharedImages.IMG_SUCCESS_IMAGE);
	private boolean showContainer;
	private DeployResolutionComposite resolutionComposite;
	private TreeViewer treeViewer;
	private Topology editTopology;
	private final String sectionType;
	private int sizeVariable = 1;
	private StatusViewFilter filter;

	public StatusCompositeHandler(FormToolkit toolKit, Section section, Label labelImage,
			String sectionType) {
		super(toolKit, section);
		this.labelImage = labelImage;
		this.sectionType = sectionType;
		createTreeViewer(sectionClient);
		toolKit.paintBordersFor(section);
		toolKit.paintBordersFor(sectionClient);
	}

	@Override
	protected Composite createClientComposite() {
		sectionClient = toolKit.createComposite(section, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		sectionClient.setLayout(layout);
		sectionClient.setLayoutData(new GridData(GridData.FILL_BOTH));
		section.setTitleBarForeground(titleForeGroundColor);
		section.update();
		sectionClient.update();
		//createToolBar();
		return sectionClient;
	}

	private void createToolBar() {
		ToolBar toolBar = new ToolBar(section, SWT.BORDER);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.heightHint = 5;
		toolBar.setLayoutData(gridData);
		ToolBarManager toolBarManager = new ToolBarManager(toolBar);
		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		toolBar.setLayout(layout);
		initalizeToolBar(toolBarManager);
		toolBarManager.update(true);
		section.setTextClient(toolBar);

	}

	private void initalizeToolBar(ToolBarManager toolBarManager) {
		toolBarManager.getControl().setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));
	}

	public void handleFilter(int type) {
		switch (type)
		{
		case IStatus.ERROR: {
			filter.setFilterError(!filter.isFilterError());
			break;
		}
		case IStatus.WARNING: {
			filter.setFilterWarning(!filter.isFilterWarning());
			break;
		}
		case IStatus.INFO: {
			filter.setFilterInfo(!filter.isFilterInfo());
			break;
		}

		default:
			break;
		}

		treeViewer.refresh();
		if (section.isExpanded()) {
			treeViewer.getTree().pack();
			sectionClient.pack();
			section.layout();
			section.getParent().layout();
		}

	}

	public void update(DeployStatusGrouper grouper, boolean shouldUpdateTitle) {
		labelImage.setVisible(true);
		editTopology = grouper.getTopology();
		treeViewer.setInput(grouper);
		int errorCount = grouper.getCount(sectionType, IStatus.ERROR);
		if (shouldUpdateTitle) {
			setTitle(grouper);
			updateImage(errorCount == 0);
			setTitleBarColor(errorCount != 0);
		}
		treeViewer.expandToLevel(2);
		super.update(grouper, shouldUpdateTitle);
	}

	private int setTitle(DeployStatusGrouper grouper) {
		String text = section.getText();

		int localErrorCount = grouper.getCount(sectionType, IStatus.ERROR);
		int localWarningCount = grouper.getCount(sectionType, IStatus.WARNING);
		int localInfoCount = grouper.getCount(sectionType, IStatus.INFO);
		text = sectionType + getCountHeader(localErrorCount, localWarningCount, localInfoCount);
		section.setText(text);
		super.refresh();
		return localErrorCount;

	}

	private String getCountHeader(int localErrorCount, int localWarningCount, int localInfoCount) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("  (");//$NON-NLS-1$
		buffer.append(localErrorCount);
		buffer.append('|');
		buffer.append(localWarningCount);
		buffer.append('|');
		buffer.append(localInfoCount);
		buffer.append(')');
		return buffer.toString();

	}

	private void createTreeViewer(Composite sectionClient) {
		Tree tree = new Tree(sectionClient, SWT.NONE);
		GridData data = new GridData(GridData.FILL_BOTH);
		tree.setLayoutData(data);
		tree.pack();
		treeViewer = new TreeViewer(tree);
		ILabelDecorator decorator = PlatformUI.getWorkbench().getDecoratorManager()
				.getLabelDecorator();
		if (decorator == null) {
			return;
		}
		DecoratingLabelProvider decoratingLabelProvider = new DecoratingLabelProvider(
				new QuickFixStatusLabelProvider(), decorator);
		treeViewer.setLabelProvider(decoratingLabelProvider);
		treeViewer.setContentProvider(new SectionStatusContentProvider(sectionType));
		filter = new StatusViewFilter();

		treeViewer.addFilter(filter);
		createChangeListener();

	}

	public void updateImage(boolean success) {
		if (success) {
			labelImage.setImage(SUCCESS_IMAGE);
		} else {
			labelImage.setImage(ERROR_IMAGE);
		}

	}

	public void expand(boolean expanded) {
		section.setExpanded(expanded);

	}

	public void dispose() {
	}

	private void fireSelectionChanged(ISelection selection) {
		if (selection.isEmpty()) {
			closeResolutions();
		} else {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			Object object = structuredSelection.getFirstElement();
			if (object instanceof IStatus) {
				openResolutions((IStatus) object);
				reveal((IStatus) object);
			} else {
				closeResolutions();
			}
		}
	}

	private void reveal(IStatus status) {
		if (status instanceof DeployStatus) {
			DeployModelObject dmo = ((DeployStatus) status).getDeployObject();
			while (dmo != null && !(dmo instanceof Unit)) {
				dmo = dmo.getParent();
			}
			if (dmo != null) {
				PropertyUtils.reveal(dmo);
			}
		}
	}

	private void setTitleBarColor(boolean errorExist) {
		if (errorExist) {
			section.setBackground(ErrorColor);
			section.layout();

		} else {
			section.setBackground(toolKit.getColors().getColor(IFormColors.H_GRADIENT_START));

		}
		if (sizeVariable > 1) {
			section.setSize(section.getSize().x - 1, section.getSize().y);
			sizeVariable++;
		} else {
			section.setSize(section.getSize().x + 1, section.getSize().y);
			sizeVariable--;
		}
		super.refresh();

	}

	private void layout(Control[] controls) {
		if (controls == null) {
			controls = section.getChildren();
		}
		for (int i = 0; i < controls.length; i++) {
			Control control = controls[i];
			control.update();

		}
	}

	public Shell getShell() {
		return section.getClient().getShell();
	}

	private DeployResolutionComposite getResolutionComposite() {
		if (resolutionComposite == null) {
			MarkerResolutionHelper resolutionHelper = new MarkerResolutionHelper(new IMarker[0]);
			resolutionComposite = new DeployResolutionComposite((Composite) section.getClient(),
					SWT.BORDER, editTopology, resolutionHelper, null);
		}
		return resolutionComposite;
	}

	/*
	 * Show the resolution view just below the list.
	 */
	private void openResolutions(IStatus deployStatus) {
		DeployResolutionComposite comp = getResolutionComposite();
		comp.updateResolutions(deployStatus);
		comp.setVisible(true);
		section.getParent().layout();
	}

	private void closeResolutions() {
		if (resolutionComposite != null && !resolutionComposite.isDisposed()) {
			resolutionComposite.setVisible(false);
			section.getParent().layout();
		}
	}

	private void createChangeListener() {
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = event.getSelection();
				fireSelectionChanged(selection);
			}

		});

	}

	protected Point getInitialSize() {
		//return treeViewer.getTree().getShell().computeSize(SWT.DEFAULT, SWT.DEFAULT, true);
		return treeViewer.getTree().computeSize(SWT.DEFAULT, SWT.DEFAULT, true);

	}

	public void handleParentAction(boolean showContainer) {
		SectionStatusContentProvider contentProvider = (SectionStatusContentProvider) treeViewer
				.getContentProvider();
		contentProvider.setShowContainer(showContainer);
		treeViewer.refresh();
		if (section.isExpanded()) {
			treeViewer.getTree().pack();
			sectionClient.layout();
			section.getParent().layout();
		}

	}

	public void clear() {
		section.setText(EMPTY_STRING);
		labelImage.setVisible(false);
		treeViewer.setInput(null);
		section.setExpanded(false);
	}

	public String getSectionType() {
		return sectionType;
	};

}
