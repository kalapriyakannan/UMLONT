/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.marker.quickfix;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.QuickFixPopUpCommand;
import com.ibm.ccl.soa.deploy.core.ui.internal.marker.DeployResolutionComposite;
import com.ibm.ccl.soa.deploy.core.ui.internal.properties.IResolutionListener;
import com.ibm.ccl.soa.deploy.core.validator.resolution.IDeployResolution;

/**
 * The method {@link #showMarkerResolutions()} creates a GUI containing marker resolutions.
 * 
 * @since 1.0
 * @see QuickFixPopUpCommand
 */
public class QuickFixDialog extends PopupDialog {

	private final String DIALOG_SETTINGS_ID = "topology.diagram.quickfix"; //$NON-NLS-1$

	private DeployResolutionComposite resolutionComposite;

	private final MarkerResolutionHelper resolutionHelper;

	private final Topology topology;

	private final Point initialLocation;

	private IResolutionListener resolutionListener = null;

	private final IStatus initialStatus;

	/**
	 * Construct a deploy status {@link IDeployResolution} quick-fix pop-up.
	 * <p>
	 * Includes supports for legacy errors represented as markers.
	 * 
	 * @param topology
	 *           the topology over which the resolutions will be applied.
	 * @param resolutionHelper
	 *           legacy Eclipse marker-based errors.
	 * @param status
	 *           the deploy status that needs to be resolved (may be a multi-status).
	 * @param p
	 *           the point.
	 */
	public QuickFixDialog(Topology topology, MarkerResolutionHelper resolutionHelper,
			IStatus status, Point p, boolean takeFocusOnOpen) {
		this(new Shell(SWT.RESIZE), topology, resolutionHelper, status, p, takeFocusOnOpen);
	}

	/**
	 * Construct a deploy status {@link IDeployResolution} quick-fix pop-up.
	 * <p>
	 * Includes supports for legacy errors represented as markers.
	 * 
	 * @param parentShell
	 *           The parent {@link Shell}.
	 * @param topology
	 *           the topology over which the resolutions will be applied.
	 * @param resolutionHelper
	 *           legacy Eclipse marker-based errors.
	 * @param status
	 *           the deploy status that needs to be resolved (may be a multi-status).
	 * @param control
	 *           control's shell is the parent shell for the GUI window
	 * @param p
	 *           the point.
	 */
	public QuickFixDialog(Shell parentShell, Topology topology,
			MarkerResolutionHelper resolutionHelper, IStatus status, Point p, boolean takeFocusOnOpen) {
		super(parentShell, SWT.RESIZE, takeFocusOnOpen, true, false, true, null,
				Messages.QuickFixPopUp_Select_an_action_to_fix_the_problem_);

		assert p != null;

		this.topology = topology;
		this.resolutionHelper = resolutionHelper;
		initialLocation = p;
		initialStatus = status;
	}

	public QuickFixDialog(Shell parentShell, Topology topology,
			MarkerResolutionHelper resolutionHelper, IStatus status, Control control, Point p) {
		this(parentShell, topology, resolutionHelper, status, p, false);
	}

	public QuickFixDialog(Shell parentShell, Topology topology,
			MarkerResolutionHelper resolutionHelper, IStatus status, Point p, boolean takeFocusOnOpen,
			IResolutionListener listener) {
		this(parentShell, topology, resolutionHelper, status, p, takeFocusOnOpen);
		resolutionListener = listener;
		//updateResolutions(status);
	}

	public void updateResolutions(IStatus status) {
		if (resolutionComposite != null) {
			resolutionComposite.updateResolutions(status);
		}
	}

	@Override
	protected Control getFocusControl() {
		return resolutionComposite != null ? resolutionComposite.getFocusControl() : null;
	}

	protected Point getInitialLocation(Point initialSize) {
		// we don't call super because we 
		// ignore the initial location settings
		return initialLocation;
	}

	protected Point getInitialSize() {
		IDialogSettings settings = DeployCoreUIPlugin.getDefault().getDialogSettings().getSection(
				DIALOG_SETTINGS_ID);
		if (settings == null) {
			DeployCoreUIPlugin.getDefault().getDialogSettings().addNewSection(DIALOG_SETTINGS_ID);
			return new Point(300, 150);
		}
		return super.getInitialSize();
	}

	protected IDialogSettings getDialogSettings() {
		IDialogSettings settings = DeployCoreUIPlugin.getDefault().getDialogSettings().getSection(
				DIALOG_SETTINGS_ID);

		if (settings == null) {
			settings = DeployCoreUIPlugin.getDefault().getDialogSettings().addNewSection(
					DIALOG_SETTINGS_ID);
		}
		return settings;
	}

	protected Control createDialogArea(Composite parent) {
		resolutionComposite = new DeployResolutionComposite(parent, SWT.NONE, topology,
				resolutionHelper, resolutionListener);
		return resolutionComposite;

	}

	@Override
	public void create() {
		super.create();
		if (initialStatus != null) {
			updateResolutions(initialStatus);
		}
	}

} // end class QuickFixDialog
