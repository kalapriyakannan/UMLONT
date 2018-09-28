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

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ShortConstraintDescriptor;
import com.ibm.ccl.soa.deploy.core.ui.composites.IDeployHelpContextIds;
import com.ibm.ccl.soa.deploy.core.validator.ConstraintService;

/**
 * Dialog for editing contract.
 * 
 * @author jswanke
 */
public class ConstraintLinkDialog extends RobustPopupDialog {

	private final Unit _unit1;
	private final Unit _unit2;
	private final Point _pt;
	private org.eclipse.swt.widgets.List _list;
	private ShortConstraintDescriptor _description = null;
	List<ShortConstraintDescriptor> _descList = new ArrayList<ShortConstraintDescriptor>();
	private final Collection<Control> localBkColorExclusions = new LinkedList<Control>();

	/**
	 * @param parentShell
	 * @param unit
	 * @param pt
	 */
	public ConstraintLinkDialog(Shell parentShell, Unit unit1, Unit unit2, Point pt) {
		super(parentShell, SWT.NO_TRIM, true, false, false, false, null, null);
		_unit1 = unit1;
		_unit2 = unit2;
		_pt = pt;
	}

	protected Point getInitialLocation(Point initialSize) {
		return _pt;
	}

	protected void handleDispose() {
		close();
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
	}

	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				IDeployHelpContextIds.TOPOLOGY_SEL_CONSTRAINT_LINK);
		GridLayout layout = new GridLayout();
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		composite.setLayout(layout);
		createControls(composite);
		initializeControls();
		return composite;
	}

	private void createControls(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		GridLayout layout = new GridLayout(1, false);
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		layout.horizontalSpacing = 0;
		composite.setLayout(layout);

		// create combo box
		_list = new org.eclipse.swt.widgets.List(composite, SWT.V_SCROLL | SWT.BORDER);
		_list.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		localBkColorExclusions.add(_list);
		_list.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		_list.setFont(parent.getFont());
		_list.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
	}

	private void initializeControls() {
		_descList.addAll(ConstraintService.INSTANCE.applicableConstraints(_unit1, _unit2));
		for (ShortConstraintDescriptor scd : _descList) {
			_list.add(scd.getTitle());
		}
	}

	@Override
	protected boolean requiresApplyControl() {
		return false;
	}

	public boolean close() {
		int select = _list.getSelectionIndex();
		if (getReturnCode() != Window.CANCEL && select != -1) {
			_description = _descList.get(select);
		}
		return super.close();
	}

	@Override
	protected List<Control> getBackgroundColorExclusions() {
		List<Control> retVal = super.getBackgroundColorExclusions();
		retVal.addAll(localBkColorExclusions);
		return retVal;
	}

	protected Control getFocusControl() {
		return _list;
	}

	public ShortConstraintDescriptor getConstraintDescriptor() {
		return _description;
	}
}
