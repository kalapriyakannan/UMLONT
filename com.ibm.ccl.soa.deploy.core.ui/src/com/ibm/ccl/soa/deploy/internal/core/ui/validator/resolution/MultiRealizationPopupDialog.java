/***************************************************************************************************
 * Copyright (c) 2003, 2008 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.ui.validator.resolution;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.properties.DeployUIWidgetFactory;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreImages;
import com.ibm.ccl.soa.deploy.core.ui.validator.resolution.Messages;
import com.ibm.ccl.soa.deploy.core.util.IObjectFilter;

/**
 * <pre>
 * +--------------------------------------+
 * |Conceptual Unit       Target          |
 * |+-----------------+   +--------------+|
 * ||                 |   |              ||
 * ||                 |   |              ||
 * ||                 |   |              ||
 * |+-----------------+   +--------------+|
 * |
 * |+------------------------------------+|
 * ||                                    ||
 * ||                                    ||
 * ||                                    ||
 * |+------------------------------------+|
 * |                    [realize] [close] |
 * +--------------------------------------+
 * </pre>
 * 
 * The trees on the upper left and right are a {@link TwoStacksComposite} and the table on the
 * bottom is a {@link RealizationsCreatedComposite}.
 * 
 * @since 7.0
 * @see RealizationAssistantResolutionGenerator
 */
public class MultiRealizationPopupDialog extends PopupDialog {

	private final Topology top;
	private TwoStacksComposite tsc;
	private RealizationsCreatedComposite rcc;
	private final DeployModelObject initial;
	private Composite modifiedStatusBar;

	/**
	 * @param parent
	 * @param topology
	 * @param initialDMO
	 *           preferred Unit to start selection process with
	 */
	public MultiRealizationPopupDialog(Shell parent, Topology topology, DeployModelObject initialDMO) {
		super(parent, SWT.RESIZE | SWT.APPLICATION_MODAL, true, false, true, false,
				Messages.MultiRealizationPopupDialog_Realization_Assistan_,
				Messages.MultiRealizationPopupDialog_Find_and_map_groups_of_Unit_);

		top = topology;
		initial = initialDMO;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.REALIZATION_ASSISTANT);
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayout(new GridLayout());

		RealizationMapHelper mapUtil = new RealizationMapHelper(top,
				new RealizationMapHelper.Runner() {

					public void run(Runnable runnable) {
						BusyIndicator.showWhile(getShell().getDisplay(), runnable);
					}
				}, new IObjectFilter<Unit>() {
					public boolean accept(Unit unit) {
						return tsc.acceptAsTarget(unit);
					}
				});

		Unit defaultConceptual = initial instanceof Unit ? (Unit) initial : null;
		tsc = new TwoStacksComposite(composite, mapUtil /* , defaultConceptual */);
		tsc.setLayoutData(new GridData(GridData.FILL_BOTH));
		mapUtil.addView(tsc);

		rcc = new RealizationsCreatedComposite(composite, mapUtil);
		rcc.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		mapUtil.addView(rcc);

		final RealizationPopupControlsComposite rpcc = new RealizationPopupControlsComposite(
				composite, mapUtil);
		rpcc.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		rpcc.setConfirmationListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				tsc.confirmCurrentChoice();
//				System.out.println("@@@ widgetSelected"); //$NON-NLS-1$
				rpcc.setCanConfirmCurrentChoice(tsc.canConfirmCurrentChoice());
			}
		});

		tsc.setSelectionChangeListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
//				System.out.println("@@@ selectionChanged"); //$NON-NLS-1$
				rpcc.setCanConfirmCurrentChoice(tsc.canConfirmCurrentChoice());
			}
		});

//		rpcc.setCanConfirmCurrentChoice(tsc.canConfirmCurrentChoice());

		tsc.setSourceSelection(defaultConceptual);

		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		return composite;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List getBackgroundColorExclusions() {
		List<Control> retVal = new LinkedList<Control>(super.getBackgroundColorExclusions());
		retVal.addAll(tsc.getBackgroundColorExclusions());
		retVal.addAll(rcc.getBackgroundColorExclusions());
		DeployUIWidgetFactory.INSTANCE.addWithChildren(modifiedStatusBar, retVal);
		return retVal;
	}

	private class RealizationPopupControlsComposite extends Composite {

		private SelectionListener confirmationListener;
		private final Button next;
		private final CLabel message;
		private final RealizationMapHelper mapUtil;

		private RealizationPopupControlsComposite(Composite parent, RealizationMapHelper mapHelper) {
			super(parent, SWT.NULL);

			setLayout(new GridLayout(2, false));

			mapUtil = mapHelper;

			message = new CLabel(this, SWT.NULL);
			message.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

			next = new Button(this, SWT.PUSH);
			next.setText(Messages.MultiRealizationPopupDialog_Realiz_);
			next.addSelectionListener(new SelectionAdapter() {

				public void widgetSelected(SelectionEvent e) {
					confirmationListener.widgetSelected(e);
				}
			});
		}

		/**
		 * @param canConfirmCurrentChoice
		 */
		public void setCanConfirmCurrentChoice(boolean canConfirmCurrentChoice) {
//			System.out.println("@@@setCanConfirmCurrentChoice(" + canConfirmCurrentChoice + ')'); //$NON-NLS-1$
			next.setEnabled(canConfirmCurrentChoice);

			if (mapUtil.getValidTargets().size() == 0) {
				message.setImage(DeployCoreImages.IMAGE_ERROR_TBL);
				message.setText(Messages.MultiRealizationPopupDialog_No_legal_realization_);
			} else {
				message.setImage(null);
				message.setText(""); //$NON-NLS-1$
			}

		}

		private void setConfirmationListener(SelectionListener listener) {
			confirmationListener = listener;
		}
	} // end private inner class RealizationPopupControlsComposite

	@Override
	protected Control createInfoTextArea(Composite parent) {
		modifiedStatusBar = DeployUIWidgetFactory.INSTANCE.createModifiedDialogStatusBar(parent, 2);
		Label label = (Label) super.createInfoTextArea(modifiedStatusBar);
		//Switch alignment to the left.
		label.setAlignment(SWT.LEFT);
		DeployUIWidgetFactory.INSTANCE.createCloseHyperlink(modifiedStatusBar, this);
		return modifiedStatusBar;
	}
}
