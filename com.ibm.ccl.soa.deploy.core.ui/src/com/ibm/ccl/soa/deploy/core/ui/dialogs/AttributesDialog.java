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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.jface.viewers.StructuredSelection;
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

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.PublishIntent;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployCoreEditor;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ResourceUtils;

/**
 * Dialog for editing contract.
 * 
 * @author jswanke
 */
public class AttributesDialog extends PopupDialog {

	private final EditPartViewer _editPartViewer;
	private final Unit _unit;
	private final List<EditPart> _selectedEditParts = new ArrayList<EditPart>();
	private final List<Unit> _unitList = new ArrayList<Unit>();
	private final Point _pt;
	private int _selection;
	private boolean _donotpublish;
	private boolean _isConceptual;
	private Combo _combo;
	private final Collection<Control> localBkColorExclusions = new LinkedList<Control>();
	private final boolean _isProxy;
	private boolean reselect = false;
	private boolean mouseClick = false;

	/**
	 * @param parentShell
	 * @param ownerEP
	 * @param pt
	 */
	public AttributesDialog(Shell parentShell, DeployShapeNodeEditPart ownerEP, Point pt) {
		super(parentShell, SWT.NO_TRIM, true, false, false, false, null, null);
		_unit = (Unit) ownerEP.resolveSemanticElement();
		_editPartViewer = ownerEP.getViewer();
		_isProxy = PropertyUtils.isProxy(_unit);
		List<?> selectedList = ownerEP.getViewer().getSelectedEditParts();
		// if owner isn't one of the selected, we are just changing the owner 
		if (!selectedList.contains(ownerEP)) {
			_unitList.add(_unit);
			_selectedEditParts.add(ownerEP);
		} else {
			// else we are changing everything selected
			for (Iterator<?> it = selectedList.iterator(); it.hasNext();) {
				Object o = it.next();
				if (o instanceof IGraphicalEditPart) {
					EObject eo = ((IGraphicalEditPart) o).resolveSemanticElement();
					if (eo instanceof Unit) {
						_unitList.add((Unit) eo);
						_selectedEditParts.add((EditPart) o);
					}
				}
			}
			reselect = true;
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
		_combo = new Combo(composite, SWT.SIMPLE | SWT.READ_ONLY | SWT.MULTI);
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
		// 0: uninstalled > installed
		_combo
				.add(com.ibm.ccl.soa.deploy.core.ui.properties.Messages.GeneralDmoSyncHelperModel_uninstalled_installed_);//0
		// 1: installed > uninstalled
		_combo
				.add(com.ibm.ccl.soa.deploy.core.ui.properties.Messages.GeneralDmoSyncHelperModel_installed_uninstalled_);//1
		// 2: installed > installed
		_combo
				.add(com.ibm.ccl.soa.deploy.core.ui.properties.Messages.GeneralDmoSyncHelperModel_installed_);//2
		// 3: uninstalled > uninstalled
		_combo
				.add(com.ibm.ccl.soa.deploy.core.ui.properties.Messages.GeneralDmoSyncHelperModel_uninstalled_);//3
		// 4: unknown > unknown
		_combo
				.add(com.ibm.ccl.soa.deploy.core.ui.properties.Messages.GeneralDmoSyncHelperModel_unknown_);//4
		// 5: unknown > installed
		_combo
				.add(com.ibm.ccl.soa.deploy.core.ui.properties.Messages.GeneralDmoSyncHelperModel_unknown_installed_);//5
		// 6: unknown > uninstalled
		_combo
				.add(com.ibm.ccl.soa.deploy.core.ui.properties.Messages.GeneralDmoSyncHelperModel_unknown_uninstalled_);//6
		// 7: installed > unknown
		_combo
				.add(com.ibm.ccl.soa.deploy.core.ui.properties.Messages.GeneralDmoSyncHelperModel_installed_unknown_);//7
		// 8: uninstalled > unknown
		_combo
				.add(com.ibm.ccl.soa.deploy.core.ui.properties.Messages.GeneralDmoSyncHelperModel_uninstalled_unknown_);//8

		_donotpublish = _unit.getPublishIntent().getValue() == PublishIntent.DO_NOT_PUBLISH;
		_combo.add(_donotpublish ? Messages.AttributesDialog_publis_
				: Messages.AttributesDialog_do_not_publis_);//7
		if (!_isProxy) {
			_isConceptual = _unit.isConceptual();
			_combo.add(_isConceptual ? Messages.AttributesDialog_nonconceptua_
					: Messages.AttributesDialog_conceptua_);//8
		}
		_selection = 0;
		int init = _unit.getInitInstallState().getValue();
		int goal = _unit.getGoalInstallState().getValue();

		if (init == InstallState.NOT_INSTALLED && goal == InstallState.INSTALLED) {
			// 0: uninstalled > installed
			_selection = 0;
		} else if (init == InstallState.INSTALLED && goal == InstallState.NOT_INSTALLED) {
			// 1: installed > uninstalled
			_selection = 1;
		} else if (init == InstallState.INSTALLED && goal == InstallState.INSTALLED) {
			// 2: installed > installed
			_selection = 2;
		} else if (init == InstallState.NOT_INSTALLED && goal == InstallState.NOT_INSTALLED) {
			// 3: uninstalled > uninstalled
			_selection = 3;
		} else if (init == InstallState.UNKNOWN && goal == InstallState.UNKNOWN) {
			// 4: unknown > unknown
			_selection = 4;
		} else if (init == InstallState.UNKNOWN && goal == InstallState.INSTALLED) {
			// 5: unknown > installed
			_selection = 5;
		} else if (init == InstallState.UNKNOWN && goal == InstallState.NOT_INSTALLED) {
			// 6: unknown > uninstalled
			_selection = 6;
		} else if (init == InstallState.INSTALLED && goal == InstallState.UNKNOWN) {
			// 7: installed > unknown
			_selection = 7;
		} else if (init == InstallState.NOT_INSTALLED && goal == InstallState.UNKNOWN) {
			// 8: uninstalled > unknown
			_selection = 8;
		}
		_combo.select(_selection);
	}

	public boolean close() {
		final int select = _combo.getSelectionIndex();
		if (getReturnCode() != Window.CANCEL && select != _selection) {
			switch (select)
			{
			case 0:
				// 0: uninstalled > installed
				setInstallState(InstallState.NOT_INSTALLED_LITERAL, InstallState.INSTALLED_LITERAL);
				break;
			case 1:
				// 1: installed > uninstalled
				setInstallState(InstallState.INSTALLED_LITERAL, InstallState.NOT_INSTALLED_LITERAL);
				break;
			case 2:
				// 2: installed > installed
				setInstallState(InstallState.INSTALLED_LITERAL, InstallState.INSTALLED_LITERAL);
				break;
			case 3:
				// 3: uninstalled > uninstalled
				setInstallState(InstallState.NOT_INSTALLED_LITERAL, InstallState.NOT_INSTALLED_LITERAL);
				break;
			case 4:
				// 4: unknown > unknown
				setInstallState(InstallState.UNKNOWN_LITERAL, InstallState.UNKNOWN_LITERAL);
				break;
			case 5:
				// 5: unknown > installed
				setInstallState(InstallState.UNKNOWN_LITERAL, InstallState.INSTALLED_LITERAL);
				break;
			case 6:
				// 6: unknown > uninstalled
				setInstallState(InstallState.UNKNOWN_LITERAL, InstallState.NOT_INSTALLED_LITERAL);
				break;
			case 7:
				// 7: installed > unknown
				setInstallState(InstallState.INSTALLED_LITERAL, InstallState.UNKNOWN_LITERAL);
				break;
			case 8:
				// 8: uninstalled > unknown
				setInstallState(InstallState.NOT_INSTALLED_LITERAL, InstallState.UNKNOWN_LITERAL);
				break;
			case 9:
				setPublishState(_donotpublish);
				break;
			case 10:
				setConceptualState(_isConceptual);
				break;
			}
		}
		return super.close();
	}

	private void setInstallState(final Object initialState, final Object goalState) {
		execute(new ICommandProxy(new AbstractTransactionalCommand(TransactionUtil
				.getEditingDomain(_unit), Messages.AttributesDialog_0, null) {
			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor,
					IAdaptable info) {
				for (Iterator<Unit> it = _unitList.iterator(); it.hasNext();) {
					Unit unit = it.next();
					unit.eSet(CorePackage.Literals.UNIT__INIT_INSTALL_STATE, initialState);
					unit.eSet(CorePackage.Literals.UNIT__GOAL_INSTALL_STATE, goalState);
				}
				return CommandResult.newOKCommandResult();
			}
		}));
	}

	private void setPublishState(final boolean donotpublish) {
		execute(new ICommandProxy(new AbstractTransactionalCommand(TransactionUtil
				.getEditingDomain(_unit), Messages.AttributesDialog_1, null) {
			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor,
					IAdaptable info) {
				for (Iterator<Unit> it = _unitList.iterator(); it.hasNext();) {
					Unit unit = it.next();
					unit.eSet(CorePackage.Literals.UNIT__PUBLISH_INTENT,
							(donotpublish ? PublishIntent.PUBLISH_LITERAL
									: PublishIntent.DO_NOT_PUBLISH_LITERAL));
				}
				return CommandResult.newOKCommandResult();
			}
		}));
	}

	private void setConceptualState(final boolean isConceptual) {
		execute(new ICommandProxy(new AbstractTransactionalCommand(TransactionUtil
				.getEditingDomain(_unit), Messages.AttributesDialog_2, null) {
			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor,
					IAdaptable info) {
				for (Iterator<Unit> it = _unitList.iterator(); it.hasNext();) {
					Unit unit = it.next();
					unit.setConceptual(!isConceptual);
				}
				return CommandResult.newOKCommandResult();
			}
		}));
		// we reselect to update conceptual dotted selection-- but not if this ep wasn't selected before
		if (reselect) {
			_editPartViewer.deselectAll();
			_editPartViewer.setSelection(new StructuredSelection(_selectedEditParts));
		}
	}

	private void execute(ICommandProxy commandProxy) {
		DeployCoreEditor editor = ResourceUtils.getActiveDeployEditDomain();
		editor.getDiagramGraphicalViewer().getDiagramEditDomain().getDiagramCommandStack().execute(
				commandProxy);
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
