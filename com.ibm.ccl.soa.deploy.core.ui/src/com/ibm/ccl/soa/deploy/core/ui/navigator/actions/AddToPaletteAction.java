package com.ibm.ccl.soa.deploy.core.ui.navigator.actions;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.jem.util.emf.workbench.ProjectUtilities;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.core.ChangeScope;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.constraint.ConstraintPackage;
import com.ibm.ccl.soa.deploy.core.datamodels.AddToPaletteDataModel;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.internal.wizards.AddToPaletteDataModelWizard;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;

public class AddToPaletteAction extends Action {
	ISelection selection = null;
	AddToPaletteDataModel dataModel;
	private IWorkbenchPage page;
	private boolean fromContext;
	private IFile file;

	public AddToPaletteAction(AddToPaletteDataModel dataModel) {
		this.dataModel = dataModel;
		setText(Messages.BankUnitAction_Bank_Unit_s_);
	}

	public AddToPaletteAction(AddToPaletteDataModel dataModel, IFile aFile) {
		this.dataModel = dataModel;
		setText(Messages.BankUnitAction_Bank_Unit_s_);
		file = aFile;
	}

	public AddToPaletteAction(IWorkbenchPage wbPage) {
		fromContext = true;
		page = wbPage;
		setText(Messages.BankUnitAction_Bank_Unit_s_);
	}

	@Override
	public void run() {
		if (fromContext) {
			createDataModel();
		} else {
			if (!loadTopology()) {
				return;
			}
		}
		Shell shell = Display.getDefault().getActiveShell();
		if (shell == null) {
			return;
		}
		dataModel.setEnableCaptureVisuals(getSelectedUnits().size() == 0);
		AddToPaletteDataModelWizard wizard = new AddToPaletteDataModelWizard(dataModel);
		WizardDialog dialog = new WizardDialog(shell, wizard);
		dialog.create();
		dialog.open();
	}

	private boolean loadTopology() {
		Topology topology = getTopology(file);
		dataModel.setTopology(topology);
		List<Constraint> constraints = ValidatorUtils.getConstraints(topology,
				ConstraintPackage.eINSTANCE.getPaletteConstraint());
		if (!constraints.isEmpty()) {
			MessageDialog.openInformation(Display.getDefault().getActiveShell(),
					Messages.AddToPaletteAction_Add_to_Palette_Inf_,
					Messages.AddToPaletteAction_Topology_is_already_a_template_);
			return false;
		}
		return true;
	}

	private void createDataModel() {
		dataModel = AddToPaletteDataModel.createModel();
		selection = page.getSelection();
		List<Unit> srcUnits = getSelectedUnits();
		Unit[] units = srcUnits.toArray(new Unit[srcUnits.size()]);
		dataModel.setUnits(units);
		dataModel.setAddToPalette(true);
		if (units.length > 0) {
			IProject project = ProjectUtilities.getProject(units[0]);
			dataModel.setProjectName(project.getName());
			dataModel.setTopology(units[0].getEditTopology());
		}
	}

	private List<Unit> getSelectedUnits() {
		List<Unit> retVal = new LinkedList<Unit>();

		if (selection instanceof StructuredSelection) {
			StructuredSelection ss = (StructuredSelection) selection;
			for (Iterator it = ss.iterator(); it.hasNext();) {
				Object element = it.next();
				if (element instanceof DeployShapeNodeEditPart) {
					addIncludingChildren(retVal, (EditPart) element);
				}
			}
		}

		return retVal;
	}

	private void addIncludingChildren(List<Unit> outUnits, EditPart ep) {
		if (ep.getModel() instanceof Node) {
			Node node = (Node) ep.getModel();
			if (node.getElement() instanceof Unit) {
				Unit unit = (Unit) node.getElement();
				if (!outUnits.contains(unit)) {
					outUnits.add(unit);
				}
			}
		}

		for (EditPart epChild : (List<EditPart>) ep.getChildren()) {
			addIncludingChildren(outUnits, epChild);
		}
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	private Topology getTopology(IFile file) {
		ChangeScope<Topology, DeploymentTopologyDomain> changeScope = ChangeScope
				.createChangeScopeForRead(file);
		try {
			DeployCoreRoot root = changeScope.openModel(file, CorePackage.eINSTANCE
					.getDeployCoreRoot(), false);
			if (root != null) {
				return root.getTopology();
			}
			return null;
		} finally {
			if (changeScope != null) {
				changeScope.close(new NullProgressMonitor());
			}
		}
	}

}
