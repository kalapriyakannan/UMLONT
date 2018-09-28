package com.ibm.ccl.soa.deploy.core.ui.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.internal.update.CoreUnitRefresherFactory;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.commands.VisualizeFromSemanticCommand;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployCoreEditor;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ImportTopologyEditPart;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ResourceUtils;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

public class RefreshUnitAction extends DiagramAction {
	private final IWorkbenchPage wbPage;
	private Unit unit;
	private DeployCoreEditor editor;
	private Topology topology;

	public RefreshUnitAction(IWorkbenchPage wbPage) {
		super(wbPage);
		setText(Messages.RefreshUnitAction_Refres_);
		setToolTipText(Messages.RefreshUnitAction_Refreshes_unit_with_backing_environ_);
		this.wbPage = wbPage;

	}

	@Override
	protected boolean calculateEnabled() {
		return isEnabled();
	}

	public boolean isEnabled() {
		EObject dmo = getEOjectSelection();
		if (dmo instanceof Unit) {
			unit = (Unit) dmo;
			return unit.isBound();
		}
		return false;
	}

	@Override
	protected void doRun(IProgressMonitor progressMonitor) {
		run();
	}

	@Override
	public void run() {
		if (openMessageDialog()) {
			CoreUnitRefresherFactory refresherFactory = new CoreUnitRefresherFactory(unit);
			refresherFactory.refresh();
			List<DeployModelObject> newDeployModelObjects = refresherFactory.getCreatedUnits();
			topology = unit.getEditTopology();
			if (newDeployModelObjects != null && !newDeployModelObjects.isEmpty()) {
				visualize(newDeployModelObjects);
			}
			List<DeployModelObject> existingDeployModelObjects = refresherFactory
					.getExistingRefreshedUnits();
			if (existingDeployModelObjects != null && !existingDeployModelObjects.isEmpty()) {
				visualRefresh(existingDeployModelObjects);
			}
			Map<DeployModelObject, DeployModelObject> replaceDeployModelObjects = refresherFactory
					.getReplaceUnits();
			if (replaceDeployModelObjects != null && !replaceDeployModelObjects.isEmpty()) {
				visualReplace(replaceDeployModelObjects);
			}
		}

	}

	private boolean openMessageDialog() {
		boolean open = MessageDialog
				.openConfirm(
						Display.getDefault().getActiveShell(),
						"Refresh unit(s)from environment", "This will merge(non-intalled) units from the environment. If unit is installed will overwrite existing data.   "); //$NON-NLS-1$//$NON-NLS-2$
		// TODO Auto-generated method stub
		return open;
	}

	private void visualReplace(Map<DeployModelObject, DeployModelObject> replaceDeployModelObjects) {
		for (Iterator iterator = replaceDeployModelObjects.keySet().iterator(); iterator.hasNext();) {
			DeployModelObject deployModelObject = (DeployModelObject) iterator.next();
			DeployCoreEditor editor = getDeployCoreEditor();
			if (editor == null) {
				return;
			}
			List<DeployShapeNodeEditPart> editParts = GMFUtils.getEditPartsFor(editor
					.getDiagramGraphicalViewer(), deployModelObject);

			replaceSemantics(editParts, deployModelObject, replaceDeployModelObjects
					.get(deployModelObject));
		}

	}

	private void replaceSemantics(final List<DeployShapeNodeEditPart> editParts,
			final DeployModelObject sourceDeployModelObject,
			final DeployModelObject targetDeployModelObject) {

		TransactionalEditingDomain ed = TransactionUtil.getEditingDomain(sourceDeployModelObject);
		AbstractEMFOperation update = new AbstractEMFOperation(ed,
				DeployCoreMessages.UnitRefresherFactory_refrsh_unit_s_) {
			@Override
			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				for (Iterator iterator = editParts.iterator(); iterator.hasNext();) {
					DeployShapeNodeEditPart deployShapeNodeEditPart = (DeployShapeNodeEditPart) iterator
							.next();
					Node node = (Node) deployShapeNodeEditPart.getModel();
					node.setElement(targetDeployModelObject);
					Topology topology = sourceDeployModelObject.getEditTopology();
					topology.getUnits().remove(sourceDeployModelObject);
					topology.getUnits().add(targetDeployModelObject);
					deployShapeNodeEditPart.refresh();

				}

				return org.eclipse.core.runtime.Status.OK_STATUS;
			}

		};
		try {
			if (update != null) {
				update.execute(new NullProgressMonitor(), null);
			}
		} catch (ExecutionException e) {
			DeployCorePlugin.logError(0,
					DeployCoreMessages.UnitRefresherFactory_Error_occurred_refreshing_uni_, e);
		}

	}

	private void visualRefresh(List<DeployModelObject> existingDeployModelObjects) {
		for (Iterator iterator = existingDeployModelObjects.iterator(); iterator.hasNext();) {
			DeployModelObject deployModelObject = (DeployModelObject) iterator.next();
			DeployCoreEditor editor = getDeployCoreEditor();
			if (editor == null) {
				return;
			}
			List<DeployShapeNodeEditPart> editParts = GMFUtils.getEditPartsFor(editor
					.getDiagramGraphicalViewer(), deployModelObject);
			if (editParts != null && !editParts.isEmpty()) {
				refreshEditParts(editParts);
			} else {
				List<DeployModelObject> noEditPartDeployModelObjects = new ArrayList<DeployModelObject>();
				noEditPartDeployModelObjects.add(deployModelObject);
				visualize(noEditPartDeployModelObjects);
			}
		}

	}

	private void refreshEditParts(List<DeployShapeNodeEditPart> editParts) {

		for (Iterator iterator = editParts.iterator(); iterator.hasNext();) {
			DeployShapeNodeEditPart deployShapeNodeEditPart = (DeployShapeNodeEditPart) iterator
					.next();
			deployShapeNodeEditPart.refresh();

		}

	}

	private DeployCoreEditor getDeployCoreEditor() {
		Object part = ResourceUtils.getActiveEditorPart();
		if (part instanceof DeployCoreEditor) {
			return (DeployCoreEditor) part;
		}
		return null;
	}

	private EObject getEOjectSelection() {
		EObject retVal = null;
		ISelection selection = getSelection();
		if (selection instanceof StructuredSelection) {
			StructuredSelection ss = (StructuredSelection) selection;
			if (ss.size() == 1) {
				Object element = ss.getFirstElement();
				if (element instanceof DeployShapeNodeEditPart) {
					DeployShapeNodeEditPart editPart = (DeployShapeNodeEditPart) element;
					if (editPart instanceof ImportTopologyEditPart
							&& ((ImportTopologyEditPart) editPart).isImportDiagram()) {
						retVal = ((ImportTopologyEditPart) editPart).getImportDiagram();
					} else {
						retVal = editPart.resolveSemanticElement();
					}
				}
			}
		}
		return retVal;
	}

	public void visualize(List<DeployModelObject> deployModelObjects) {
		if (deployModelObjects.isEmpty()) {
			return;
		}
		Object part = ResourceUtils.getActiveEditorPart();
		if (part instanceof DeployCoreEditor) {
			DeployCoreEditor dce = (DeployCoreEditor) part;
			final DiagramCommandStack cmdStack = dce.getDiagramEditPart().getDiagramEditDomain()
					.getDiagramCommandStack();
			final VisualizeFromSemanticCommand visualizeCmd = new VisualizeFromSemanticCommand(dce
					.getEditingDomain(), dce.getDiagramEditPart(), deployModelObjects, null, null);
			if (visualizeCmd.canExecute()) {
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						cmdStack.execute(new ICommandProxy(visualizeCmd));
					}
				});
			}
			dce.getDiagramEditPart().refresh();
		}
	}

	@Override
	protected Request createTargetRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isSelectionListener() {
		// TODO Auto-generated method stub
		return false;
	}

}
