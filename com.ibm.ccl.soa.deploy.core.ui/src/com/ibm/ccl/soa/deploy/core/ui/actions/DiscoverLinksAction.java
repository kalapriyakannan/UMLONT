/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.datamodels.LinkDiscoveryDataModel;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.properties.NewLinkWizard;
import com.ibm.ccl.soa.deploy.core.ui.validator.resolution.UnitRequirement;

/**
 * Context action: Discover Links
 * 
 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
 * @author snible@us.ibm.com
 * @see DiscoverLinksActionGroup
 * @deprecated
 */
public class DiscoverLinksAction extends Action {
	private IStructuredSelection selection;
	private IWorkbenchPage page;
	private final boolean fromContext;

//	private ROTopologyModelManager.Listener listener = new ROTopologyModelManager.Listener() {
//
//		public void onUnload(IFile unloadedResource) { 
//			
//		}
//		
//	};

	/**
	 * @param wbPage
	 */
	public DiscoverLinksAction(IWorkbenchPage wbPage) {
		fromContext = true;
		page = wbPage;
		setText(Messages.TOPOLOGY_DISCOVERY_MENU);
	}

	/**
	 * <pre>
	 * <code>
	 * IStructuredSelection selection = new StructuredSelection(graphicalPart);
	 * or IStructuredSelection selection = new StructuredSelection(unit);
	 * DiscoverHostLinksAction action = new DiscoverHostLinksAction(selection);
	 * </code>
	 * </pre>
	 * 
	 * @param selection
	 *           the instance of structured selection
	 * @param qfEditDomain
	 *           domain (for Undo)
	 */
	public DiscoverLinksAction(IStructuredSelection selection) {
		fromContext = false;
		this.selection = selection;
		setText(Messages.TOPOLOGY_DISCOVERY_MENU);
	}

	public void run() {
		if (fromContext) {
			selection = (IStructuredSelection) page.getSelection();
		}

//		List selectedUnits = getSelectedUninstalledUnits();
		Object firstEle = selection.getFirstElement();
		Unit unit = null;
		Requirement req = null;

		if (firstEle instanceof DeployShapeNodeEditPart) {
			DeployShapeNodeEditPart ep = (DeployShapeNodeEditPart) firstEle;
			EObject eo = ep.getNotationView().getElement();
			if (eo instanceof Unit) {
				unit = (Unit) eo;
			}
		} else if (firstEle instanceof Unit) {
			unit = (Unit) firstEle;
		} else if (firstEle instanceof UnitRequirement) {
			// MK 03-01-2008 when the requirement is known, it should be set
			// the old way of using Unit is left as an option (ex. for hosting links)
			unit = ((UnitRequirement) firstEle).getUnit();
			req = ((UnitRequirement) firstEle).getRequirment();
		}

//		IWorkbench workbench = PlatformUI.getWorkbench();
		Shell parentShell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

		if (unit != null) {
//			TopologyDiscoveryWizard wizard = new TopologyDiscoveryWizard(selectedUnits);
//			WizardDialog dialog = new WizardDialog(parentShell, wizard);
//			dialog.create();
//			dialog.open();
			LinkDiscoveryDataModel linkDiscoveryModel = LinkDiscoveryDataModel.createModel();
			linkDiscoveryModel.setUnit(unit);
			// MK 03-01-2008 when the requirement is known, it should be set
			if (null != req) {
				linkDiscoveryModel.setRequirement(req);
			}
			IWizard wizard = new NewLinkWizard(linkDiscoveryModel);
			WizardDialog dialog = new WizardDialog(parentShell, wizard);
			dialog.create();
			dialog.open();
		} else {
//			Object firstEle = selection.getFirstElement();
			String warningMsg = Messages.TOPOLOGY_DISCOVERY_NO_DEPLOYABLE_SELECTED;
			if (firstEle instanceof IFile || firstEle instanceof Topology) {
				warningMsg = Messages.TOPOLOGY_DISCOVERY_NO_TOPOLOGY_CONTAINING_DEPLOYABLE_SELECTED;
			}

			// Popup a warning dialog to prompt user to select one deployable unit at least
			MessageBox msgBox = new MessageBox(parentShell, SWT.ICON_WARNING);
			msgBox.setMessage(warningMsg);
			msgBox.open();
		}
	}

//	/**
//	 * If selection is the topology file, get all units contained in the file; 
//	 * if selection is the list of selected editparts, get unit list.
//	 * @return Selected units
//	 */
//	private List getSelectedUninstalledUnits() {
//		Object firstEle = selection.getFirstElement();
//		if (firstEle instanceof IFile) {
//			IFile topologyFile = (IFile) firstEle;	
//						
//			ROTopologyModelManager modelManager = null;
//			List units = Collections.EMPTY_LIST;
//			try {
//				modelManager = ROTopologyModelManager.create();
//				Topology topology = modelManager.openModel(topologyFile, listener);
//				units = getAllUninstalledUnits(topology);
//			} finally {
//				if(modelManager != null)
//					modelManager.dispose();
//			}
//			
//
//		} else if (firstEle instanceof Topology) {
//			return getAllUninstalledUnits((Topology) firstEle);
//
//		} else if (firstEle instanceof IGraphicalEditPart) {
//			List list = new ArrayList();
//			Iterator iterator = selection.iterator();
//			while (iterator.hasNext()) {
//				IGraphicalEditPart editPart = (IGraphicalEditPart) iterator
//						.next();
//				Unit unit = (Unit) editPart.getNotationView().getElement();
//				if (!unit.getInitInstallState().equals(
//						InstallState.INSTALLED_LITERAL))
//					list.add(unit);
//			}
//			return list;
//		} else if (firstEle instanceof Unit) {
//			List list = new ArrayList();
//			Iterator iterator = selection.iterator();
//			while (iterator.hasNext()) {
//				Unit unit = (Unit) iterator.next();
//				if (!unit.getInitInstallState().equals(
//						InstallState.INSTALLED_LITERAL))
//					list.add(unit);
//			}
//			return list;
//		}
//
//		return Collections.EMPTY_LIST;
//	}

//	private List getAllUninstalledUnits(Topology topology) {
//		List uninstalledUnits = new ArrayList();
//		List units = topology.getUnits();
//		for(int i=0; i<units.size(); i++) {
//			Unit unit = (Unit)units.get(i);
//			if (!unit.getInitInstallState().equals(
//					InstallState.INSTALLED_LITERAL))
//				uninstalledUnits.add(unit);
//		}
//		
//		return uninstalledUnits;
//	}

} // end class DiscoverLinksAction
