/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.dialogs;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.ShellListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ISetSelectionTarget;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.composites.AbstractCompositeFactory;
import com.ibm.ccl.soa.deploy.core.ui.composites.ConstraintComposite;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.ui.properties.DeployUIWidgetFactory;

/**
 * A PopupDialog for editing properties on nubs.
 * 
 * @author Ed Snible
 * @see CapabilitiesPopupDialog
 * @see ConstraintComposite
 */
public class NubEditPopupDialog extends PopupDialog implements ISetSelectionTarget {

	private final Point loc;
	private final DeployModelObject editDmo;
	private Composite inner;
	private TabbedPropertySheetWidgetFactory ft;
	private Composite closeSection;

	//private ScrolledComposite scrolledComposite;

	/**
	 * @param shell
	 * @param pos
	 * @param dmo
	 */
	public NubEditPopupDialog(Shell shell, Point pos, DeployModelObject dmo) {
		super(shell, SWT.RESIZE, false, false, false, false, false, null, null);

		loc = pos;
		editDmo = dmo;
	}

	/**
	 * @param shell
	 * @param pos
	 * @param dmo
	 * @param takeFocusOnOpen
	 */
	public NubEditPopupDialog(Shell shell, Point pos, DeployModelObject dmo, boolean takeFocusOnOpen) {
		super(shell, SWT.RESIZE, takeFocusOnOpen, false, false, false, false, null, null);

		loc = pos;
		editDmo = dmo;
	}

	/**
	 * 
	 * @param shell
	 * @param pos
	 * @param dmo
	 * @param style
	 * @param takeFocusOnOpen
	 */
	public NubEditPopupDialog(Shell shell, Point pos, DeployModelObject dmo, int style,
			boolean takeFocusOnOpen) {
		super(shell, SWT.RESIZE | style, takeFocusOnOpen, false, false, false, false, null, null);

		loc = pos;
		editDmo = dmo;
	}

	private boolean isModal() {
		return (getShellStyle() & SWT.APPLICATION_MODAL) != 0;
	}

	/** Call PopupDialog.createContents(), then go back and re-color to avoid hideous yellow. */
	protected Control createContents(Composite parent) {
		Control composite = super.createContents(parent);

		applyForegroundColor(getShell().getDisplay().getSystemColor(SWT.COLOR_LIST_FOREGROUND),
				parent);
		applyBackgroundColor(getShell().getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND),
				parent);

		inner.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
//		scrolledComposite.setContent(inner);
//		Rectangle r = scrolledComposite.getClientArea();
//		scrolledComposite.setMinSize(inner.computeSize(r.width, SWT.DEFAULT));

		return composite;
	}

	/**
	 * We need to keep PopupDialog from setting the background color of anything on the UIHandler. We
	 * don't need to set it, because it was already created with the color it wants. Furthermore, the
	 * default behavior was setting the constraint 'section' title to have a white background rather
	 * than a transparent one, creating cutouts in the section gradient.
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected List<Control> getBackgroundColorExclusions() {
		List<Control> retVal = super.getBackgroundColorExclusions();
		retVal.add(inner);
		retVal.addAll(getAllChildren(inner));
		if (closeSection != null) {
			retVal.add(closeSection);
			retVal.addAll(getAllChildren(closeSection));
		}
		return retVal;
	}

	private Collection<? extends Control> getAllChildren(Composite composite) {
		List<Control> retVal = new LinkedList<Control>();
		for (Control control : composite.getChildren()) {
			if (control instanceof Composite) {
				retVal.add(control);
				retVal.addAll(getAllChildren((Composite) control));
			} else {
				retVal.add(control);
			}
		}

		return retVal;
	}

	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);

		GridLayout layout = new GridLayout();
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		layout.verticalSpacing = 0;
		composite.setLayout(layout);

		ft = new TabbedPropertySheetWidgetFactory();
//		scrolledComposite = ft.createScrolledComposite(composite, SWT.V_SCROLL);
//
//		scrolledComposite.setLayout(new GridLayout());
//		scrolledComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
//		scrolledComposite.setExpandVertical(true);
//		scrolledComposite.setExpandHorizontal(true);
//		scrolledComposite.addControlListener(new ControlAdapter() {
//			public void controlResized(ControlEvent e) {
//				if (inner != null && !inner.isDisposed()) {
//					Rectangle r = scrolledComposite.getClientArea();
//					int width = r.width;
//					scrolledComposite.setMinSize(inner.computeSize(width, SWT.DEFAULT));
//				}
//			}
//		});

		AbstractCompositeFactory acf = DeployCoreUIPlugin.getDefault().getCompositeFactoryService()
				.findDmoUIHandlerForDmo(editDmo);
		inner = acf.createControls(composite, editDmo, ft);
		inner.setLayoutData(new GridData(GridData.FILL_BOTH));

		addCloseSection(composite);

		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_CAPABILITIES_FLYOUT_SEL_CAPABILITY_SHOW_PROPERTIES);

		return composite;
	}

	private void addCloseSection(Composite parent) {
		closeSection = DeployUIWidgetFactory.INSTANCE.createModifiedStatusBarWithClose(parent, this);
	}

	@Override
	public int open() {
		this.getShell().addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				dispose();
			}
		});
		return super.open();
	}

	@Override
	public void create() {
		super.create();
		if (isModal()) {
			//Need to block on open.
			setBlockOnOpen(true);
		}
	}

	/**
	 * Runs the event loop for the given shell.
	 * 
	 * @param loopShell
	 *           the shell
	 */
	private void runEventLoop(Shell loopShell) {

		//Use the display provided by the shell if possible
		Display display;
		if (getShell() == null) {
			display = Display.getCurrent();
		} else {
			display = loopShell.getDisplay();
		}

		while (loopShell != null && !loopShell.isDisposed()) {
			try {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			} catch (Throwable e) {
				DeployCoreUIPlugin.logError(0, null, e);
			}
		}
		display.update();
	}

	@Override
	protected void adjustBounds() {
		Composite comp = (Composite) getContents();
		if (comp != null) {
			Point size = comp.getSize();
			if (size.y > 280) {
				getShell().setSize(size.x, 280);
			}
		}
	}

	private void dispose() {
		if (ft != null) {
			ft.dispose();
		}

		if (inner != null) {
			inner.dispose();
		}
	}

	protected Point getInitialLocation(Point initialSize) {
		if (loc == null) {
			return super.getInitialLocation(initialSize);
		}
		return loc;
	}

	@Override
	protected ShellListener getShellListener() {
		return new ShellAdapter() {
			public void shellClosed(ShellEvent event) {
				setReturnCode(CANCEL);
				close();
			}

		};
	}

	public void selectReveal(ISelection selection) {
		// defect -- currently a no-op
	}

} // end class NubEditPopupDialog
