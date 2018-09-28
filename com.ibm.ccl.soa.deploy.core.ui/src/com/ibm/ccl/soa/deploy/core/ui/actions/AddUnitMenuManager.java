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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.ui.action.ActionMenuManager;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitFilter;
import com.ibm.ccl.soa.deploy.core.UnitFilter.UnitFilterAction;
import com.ibm.ccl.soa.deploy.core.UnitFilter.UnitFilterTemplate;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployPopupBarEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.internal.DeployableUnitElementUIService;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreImages;

/**
 * This menu manager contributes to "Add Configuration Unit" menu in the diagram context popup menu
 * when user right-clicks on the unit which have some deployable units.
 * 
 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
 * @author Ed Snible
 * 
 * @see DeployPopupBarEditPolicy for a completely different way to get the same functionality.
 */
public class AddUnitMenuManager extends ActionMenuManager {
	private final IWorkbenchPage workbenchPage;

	/**
	 * @param page
	 */
	public AddUnitMenuManager(IWorkbenchPage page) {
		super(DeployActionIds.MENU_ADD_UNIT, new AddUnitMenuAction(), true);

		workbenchPage = page;

		populateMenu();
	}

	/**
	 * Populate the action content of "Add Configuration Unit" menu for selected unit
	 * 
	 */
	private void populateMenu() {
		IStructuredSelection selection = (IStructuredSelection) workbenchPage.getSelection();
		if (!(selection.getFirstElement() instanceof DeployShapeNodeEditPart)) {
			setVisible(false);
			return;
		}
		DeployShapeNodeEditPart selectedEP = (DeployShapeNodeEditPart) selection.getFirstElement();
		EObject eo = selectedEP.getNotationView().getElement();

		if (!(eo instanceof Unit)) {
			setVisible(false);
			return;
		}
		Unit hostUnit = (Unit) eo;

		/** Call supporting service to get a list of ElementType for deployable configuration units */
		//		List addableUnits = new LinkedList(DeployableUnitElementUIService.getInstance()
		//				.getAllowableMemberUnitElements(hostUnit));
		//		addableUnits.addAll(DeployableUnitElementUIService.getInstance()
		//				.getAllowableHostingUnitElements(hostUnit));
		List<Object> types = new ArrayList<Object>();
		List<?> memberTypes2 = DeployableUnitElementUIService.getInstance()
				.getAllowableMemberUnitElements(hostUnit);
		List<?> hosteeTypes2 = DeployableUnitElementUIService.getInstance()
				.getAllowableHostingUnitElements(hostUnit);
		types.addAll(memberTypes2);
		types.addAll(hosteeTypes2);
		List<?> hosteeTypes = flatten(hosteeTypes2);
		List<?> memberTypes = flatten(memberTypes2);

		/** hide this menu if selected unit has no deployable configuration units */
		//		if (addableUnits.size() == 0) {
		if (hosteeTypes.size() == 0 && memberTypes.size() == 0) {
			setVisible(false);

			return;
		}

		//		/** Get HostingListCompartmentEditPart */
		//		IGraphicalEditPart hostingListCompartmentEP = selectedEP
		//				.getChildBySemanticHint(DeployCoreConstants.HOSTINGLIST_SEMANTICHINT);

		/**
		 * iterate hostingList list, get label and image from each element type and create one menu
		 * Action
		 */
		//		for (int i = 0; i < addableUnits.size(); i++) {
		//			Object obj = addableUnits.get(i);
		//			if (obj instanceof IElementType) {
		//				IElementType elementType = (IElementType) obj;
		//				String name = elementType.getDisplayName(); // get name
		//				ImageDescriptor icon = ImageDescriptor.createFromURL(elementType.getIconURL()); // get icon
		//				// Add Action for each configuration unit
		//				add(new AddUnitAction(name, icon, hostingListCompartmentEP, elementType));
		//			} else {
		//				System.out.println("@@@" + obj.getClass()); //$NON-NLS-1$
		//			}
		//		}
		for (Iterator<?> it = hosteeTypes.iterator(); it.hasNext();) {
			add(getActionForChoice(hostUnit, it.next(), UnitFilter.HOSTEE, selectedEP));
		}
		for (Iterator<?> it = memberTypes.iterator(); it.hasNext();) {
			add(getActionForChoice(hostUnit, it.next(), UnitFilter.MEMBER, selectedEP));
		}
	} // end method populateMenu()

	private IAction getActionForChoice(Unit unit, Object obj, int type, IGraphicalEditPart ep) {

		return new AddSuggestedUnitAction(unit, DeployableUnitElementUIService
				.getIconDescriptorForSelection(obj), DeployableUnitElementUIService
				.getNameForSelection(obj), obj, type, ep);
	}

	private List<Object> flatten(List<?> listOfLists) {
		List<Object> retVal = new ArrayList<Object>();
		flatten(listOfLists, retVal);
		return retVal;
	}

	private List<?> flatten(List<?> listOfLists, List<Object> retVal) {
		for (Iterator<?> it = listOfLists.iterator(); it.hasNext();) {
			Object obj = it.next();
			if (obj instanceof IElementType || obj instanceof UnitFilterAction
					|| obj instanceof UnitFilterTemplate) {
				retVal.add(obj);
			} else if (obj instanceof List) {
				List<?> l = (List<?>) obj;
				flatten(l, retVal);
			} else {
				DeployCoreUIPlugin.log(IStatus.WARNING, 0, "Unknown UnitFilter tool type " + obj, null); //$NON-NLS-1$
			}
		}

		return retVal;
	}

	private static class AddUnitMenuAction extends Action {
		/**
		 * Constructor
		 */
		public AddUnitMenuAction() {
			setText(Messages.ADD_CONFIG_UNIT_MENU);
			setImageDescriptor(DeployCoreImages.IMAGEDSC_ADD_CONFIG_UNIT_MENU);
		}
	}

	private static class AddSuggestedUnitAction extends Action {
		private final int type;
		private final Object action;
		private final Unit unit;
		private final IGraphicalEditPart ep;

		private AddSuggestedUnitAction(Unit createUnit, ImageDescriptor icon, String label,
				Object createAction, int createType, IGraphicalEditPart originatingEditPart) {
			super(label, icon);
			type = createType;
			action = createAction;
			unit = createUnit;
			ep = originatingEditPart;
		}

		public void run() {

			Command createCmd = DeployableUnitElementUIService.getGefCommandForSelection(unit, action,
					type, ep);

			if (createCmd != null && createCmd.canExecute()) {
				PropertyUtils.executeWithUndo(unit, createCmd);
			}
		}
	}

	//	private class AddUnitAction extends Action {
	//		private final IGraphicalEditPart containerEP;
	//		private final IElementType elementType;
	//
	//		/**
	//		 * @param label
	//		 * @param icon
	//		 * @param containerEP
	//		 * @param elementType
	//		 */
	//		public AddUnitAction(String label, ImageDescriptor icon, IGraphicalEditPart containerEP,
	//				IElementType elementType) {
	//			super(label, icon);
	//
	//			assert containerEP != null;
	//			assert elementType != null;
	//
	//			this.containerEP = containerEP;
	//			this.elementType = elementType;
	//		}
	//
	//		public void run() {
	//			/** Create Unit in the host's HostingListCompartment */
	//
	//			// Get CreateViewAndElementRequest for Unit Creation
	//			CreateViewRequest createRequest = CreateViewRequestFactory.getCreateShapeRequest(
	//					elementType, containerEP.getDiagramPreferencesHint());
	//
	//			// Get Unit Creation command from Container EditPart
	//			Command createCmd = containerEP.getCommand(createRequest);
	//			if (createCmd != null && createCmd.canExecute()) {
	//				DiagramCommandStack cmdStack = containerEP.getDiagramEditDomain()
	//						.getDiagramCommandStack();
	//				cmdStack.execute(createCmd);
	//			}
	//		}
	//		
	//	} // end class AddUnitAction

} // end class AddUnitMenuManager
