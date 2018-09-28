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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.operation.UpdateContractOperation;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.decorators.ContractDecorator;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.properties.LightweightOperationFactory;

/**
 * Dialog for editing contract.
 * 
 * @author jswanke
 */
public class ContractDialog extends PopupDialog {

	private final DeployModelObject _modelObject;
	private final List<DeployModelObject> _unitList = new ArrayList<DeployModelObject>();
	private final Point _pt;
	private int _selection;
	private Combo _combo;
	private final Collection<Control> localBkColorExclusions = new LinkedList<Control>();
	private final ContractDecorator _decorator;
	private boolean mouseClick = false;

	/**
	 * @param parentShell
	 * @param ownerEP
	 * @param pt
	 * @param decorator
	 */
	public ContractDialog(Shell parentShell, DeployShapeNodeEditPart ownerEP, Point pt,
			ContractDecorator decorator) {
		super(parentShell, SWT.NO_TRIM, true, false, false, false, null, null);
		_modelObject = (DeployModelObject) ownerEP.resolveSemanticElement();
		_decorator = decorator;
		List<?> selectedList = ownerEP.getViewer().getSelectedEditParts();
		// if owner isn't one of the selected, we are just changing the owner 
		if (!selectedList.contains(ownerEP)) {
			_unitList.add(_modelObject);
		} else {
			// else we are changing everything selected
			for (Iterator<?> it = selectedList.iterator(); it.hasNext();) {
				Object o = it.next();
				if (o instanceof IGraphicalEditPart) {
					EObject eo = ((IGraphicalEditPart) o).resolveSemanticElement();
					if (eo instanceof DeployModelObject) {
						_unitList.add((DeployModelObject) eo);
					}
				}
			}
		}
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
		_combo = new Combo(composite, SWT.SIMPLE | SWT.READ_ONLY);
		_combo.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		localBkColorExclusions.add(_combo);
		_combo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		_combo.setFont(parent.getFont());
		_combo.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent arg0) {
				// if enter pressed, close
				if (arg0.character == '\r') {
					close();
				}
			}

			public void keyReleased(KeyEvent e) {
			}
		});
		_combo.addMouseListener(new MouseListener() {

			public void mouseDoubleClick(MouseEvent arg0) {
			}

			public void mouseDown(MouseEvent arg0) {
				mouseClick = true;
			}

			public void mouseUp(MouseEvent arg0) {
			}

		});

		_combo.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				// if selection changed because of a mouse click, close
				if (mouseClick) {
					close();
				}
			}
		});
	}

	private void initializeControls() {

		ConfigurationContract contract = _modelObject.getTopology().getConfigurationContract();
		if (_modelObject instanceof Import) {
			_combo.add(Messages.SetContractVisibilityAction_Publi_);
			_combo.add(Messages.SetContractVisibilityAction_Privat_);

			if (contract.isPublic(_modelObject)) {
				_selection = 0;
			} else {
				_selection = 1;
			}
		} else {
			_combo.add(Messages.SetContractVisibilityAction_Public_Editabl_);
			_combo.add(Messages.SetContractVisibilityAction_Publi_);
			_combo.add(Messages.SetContractVisibilityAction_Privat_);

			if (contract.isPublicEditable(_modelObject)) {
				_selection = 0;
			} else if (contract.isPublic(_modelObject)) {
				_selection = 1;
			} else {
				_selection = 2;
			}
		}
		_combo.select(_selection);
	}

	public boolean close() {
		int select = _combo.getSelectionIndex();
		if (getReturnCode() != Window.CANCEL && select != _selection) {
			if (_modelObject instanceof Import) {
				++select;
			}
			try {
				IUndoableOperation op = UpdateContractOperation.createUpdateContractOperation(
						_unitList, select, Messages.SetContractVisibilityAction_Update_Contrac_);
				LightweightOperationFactory.execute(_modelObject, op);
				_decorator.refresh();
			} catch (Exception e) {
				DeployCoreUIPlugin.logError(0, e.getMessage(), e);
			}
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
		return _combo;
	}
}
