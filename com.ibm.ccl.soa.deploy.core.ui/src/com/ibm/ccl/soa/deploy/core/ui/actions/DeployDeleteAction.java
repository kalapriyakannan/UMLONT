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
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.ui.util.IPartSelector;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitLink;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.DeleteConsolidatedLinkDialog;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.DeployDeleteContainerDialog;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ConsolidationLinkEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployConnectionNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DiagramNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ImportListCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ImportShapesCompartmentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ImportTopologyEditPart;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.DeployDeleteContainerCommand;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.DeployToggleCanonicalModeCommand;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;
import com.ibm.ccl.soa.deploy.core.ui.preferences.IDeployPreferences;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.CanonicalUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ContainmentStateUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.DeferredHostingLinkImpl;
import com.ibm.ccl.soa.deploy.core.ui.util.GEFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.SelectionUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ViewUtil;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;

/**
 * Customized deletion action
 * 
 * @author <a href="mailto:sunyingl@cn.ibm.com">Neo Sun</a>
 * @author <a href="mailto:snible@us.ibm.com">Ed Snible</a>
 * 
 * notes:
 * 
 * 1) To delete views, just delete them using GROUP request to get a DeleteCommand which just calls
 * ViewUtils.destroy() on the view
 * 
 * 2) If deleting a view whose parent is also selected to be deleted, don't delete the child-- it
 * will be deleted when the parent is deleted.
 * 
 * 3) If deleting from the model, all duplicate views/edges that depend on that element MUST BE
 * DELETED first so that there isn't a point when the element has been deleted but the a view
 * anywhere still exists (during deletion or undo)
 * 
 * 4) If deleting an ImportTopologyEditPart from the model, since these can all represent the same
 * Import element, only one ImportTopologyEditPart should be deleted from the model, and the rest
 * should be deleted from the diagram first
 * 
 * 5) If delete from container, we just delete the hosting/member link from the model AND the view
 * from all containers
 * 
 */
public class DeployDeleteAction extends DiagramAction {
	// deleteWhat -- delete view, model, container link
	public static final int DELETE_FROM_DIAGRAM = 1;
	public static final int DELETE_FROM_MODEL = 2;
	public static final int DELETE_FROM_CONTAINER = 3;

	// deleteHow -- delete from menu action or keyboard "Del" key
	public static final int MENUACTION_DELETE = 1;
	public static final int DELKEY_DELETE = 2;

	private int _deleteFrom = 0;
	private int _deleteHow = 0;

	List<ConsolidationLinkEditPart> _partialConsolidatedDeleteList = new ArrayList<ConsolidationLinkEditPart>();

	/**
	 * @param page
	 * @param deleteFrom --
	 *           delete from diagram, model, container link
	 * @param deleteHow --
	 *           delete from menu action or keyboard "Del" key
	 */
	public DeployDeleteAction(IWorkbenchPage page, int deleteFrom, int deleteHow) {
		super(page);

		init();
		_deleteFrom = deleteFrom;
		_deleteHow = deleteHow;
		String id;
		String label;
		switch (_deleteFrom)
		{
		default:
		case DELETE_FROM_DIAGRAM:
			id = DeployActionIds.DEPLOY_DELETE_VIEW;
			label = Messages.DELETE_VIEW_ACTION_LABEL;
			break;
		case DELETE_FROM_MODEL:
			id = DeployActionIds.DEPLOY_DELETE_MODEL;
			label = Messages.DELETE_MODEL_ACTION_LABEL;
			break;
		case DELETE_FROM_CONTAINER:
			id = DeployActionIds.DEPLOY_DELETE_FROM_CONTAINER;
			label = Messages.DeployDeleteAction_Delete_from_Containe_;
			break;
		}
		setId(id);
		setText(label);
		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
		setDisabledImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE_DISABLED));
		setPartSelector(new IPartSelector() {
			public boolean selects(IWorkbenchPart p) {
				return p instanceof IDiagramWorkbenchPart;
			}
		});

	}

	protected Request createTargetRequest() {
		return null;
	}

	protected boolean isSelectionListener() {
		return true;
	}

	protected boolean calculateEnabled() {
		//		return true;

		// It's now illegal to delete objects that are owned by immutables
		boolean isAllContainedEditParts = true;
		List<?> selectedObjs = getFilteredSelectedObjects();
		if (selectedObjs.size() == 0) {
			return false;
		}
		for (Iterator it = selectedObjs.iterator(); it.hasNext();) {
			Object selectedObj = it.next();
			if (!canDelete(selectedObj)) {
				return false;
			}
			// determine contained state of selected editparts
			if (!(selectedObj instanceof EditPart && isContainedUnit((EditPart) selectedObj,
					getSelectedObjects()))) {
				isAllContainedEditParts = false;
			}
		}
		// if this is a container delete, all units must be contained for this action to be enabled
		if (_deleteFrom == DELETE_FROM_CONTAINER) {
			return isAllContainedEditParts;
		}

		return true;
	}

	private boolean canDelete(Object obj) {
		if (obj instanceof EditPart) {
			EditPart ep = (EditPart) obj;

			// detached views can always be deleted!
			if (!(ep instanceof DeployConnectionNodeEditPart)
					&& (!(ep instanceof GraphicalEditPart) || ((GraphicalEditPart) ep)
							.resolveSemanticElement() == null)) {
				return _deleteFrom == DELETE_FROM_DIAGRAM || _deleteHow == DELKEY_DELETE;
			}

			// if delete from diagram action, links can only be deleted from the model
			// (we let the DEL key action thru -- user is given chance to delete link from model in doRun())
			if (_deleteFrom == DELETE_FROM_DIAGRAM && _deleteHow == MENUACTION_DELETE
					&& ep instanceof DeployConnectionNodeEditPart) {
				return false;
			}

			// if deleting from model action-- don't allow diagram nodes to be deleted from the model (there is no model)
			if (_deleteFrom == DELETE_FROM_MODEL && getSelectedObjects().size() == 1
					&& ep instanceof DiagramNodeEditPart) {
				return false;
			}

			// if deleting from model action-- don't enable for a single proxy--
			// model deletes of proxies are just turned into view deletes anyway, 
			//  but this warns user it's just a view delete 
			if (_deleteFrom == DELETE_FROM_MODEL
					&& (getSelectedObjects().size() == 1 || _deleteHow == MENUACTION_DELETE)
					&& ep instanceof IGraphicalEditPart
					&& ((IGraphicalEditPart) ep).resolveSemanticElement() instanceof DeployModelObject
					&& PropertyUtils.isProxy((DeployModelObject) ((IGraphicalEditPart) ep)
							.resolveSemanticElement())) {
				return false;
			}

			// don't allow delete from a diagram/import diagram/import unless unit doesn't live there
			ImportTopologyEditPart itep = GMFUtils.getImportTopologyEP(ep);
			if (!(ep instanceof ImportTopologyEditPart) && itep != null) {
				EditPart parentEP = ep.getParent();
				if (parentEP instanceof ImportListCompartmentEditPart
						|| parentEP instanceof ImportShapesCompartmentEditPart) {
					return false;
				} else if (parentEP != null && parentEP.getParent() instanceof GraphicalEditPart) {
					GraphicalEditPart gep = (GraphicalEditPart) ep.getParent().getParent();
					EObject gepEO = gep.resolveSemanticElement();
					EObject selctEO = ((GraphicalEditPart) ep).resolveSemanticElement();
					if (gepEO instanceof Unit && selctEO instanceof Unit
							&& ((Unit) gepEO).getTopology() == ((Unit) selctEO).getTopology()) {
						return false;
					}
				}

			}
			if (!(ep instanceof DiagramNodeEditPart) && GMFUtils.isDiagramNode(ep)) {
				return false;
			}

			// It's forbidden to delete unit links originating in immutable units
			Object model = ep.getModel();
			if (model instanceof Edge) {
				Edge edge = (Edge) model;
				if (edge.getElement() instanceof UnitLink) {
					UnitLink link = (UnitLink) edge.getElement();
					return DeployModelObjectUtil.isMutable(link.getParent());
				}
			}
		}

		return true;
	}

	protected void doRun(IProgressMonitor progressMonitor) {
		Command deleteCmd = null;
		final List<?> selectedObjs = getFilteredSelectedObjects();

		// if just delete from container, get "delete from container" command
		if (_deleteFrom == DELETE_FROM_CONTAINER) {
			// warn user that only contained unit links are deleted from the model along with the view
			//if (_isKeyboardDelete) {
			IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
			String pref = store.getString(IDeployPreferences.DEPLOY_DELETE_CONTAINED_REMINDER);
			if (pref != null && pref.equals(Messages.DeployCoreMainPreferencePage_promp_)) {
				MessageDialogWithToggle dlg = MessageDialogWithToggle.openYesNoQuestion(Display
						.getCurrent().getActiveShell(),
						Messages.DeployDeleteAction_Delete_Contained_Uni_,
						Messages.DeployDeleteAction_This_action_will_only_delete_the_li_,
						Messages.DeployDeleteAction_Disable_this_messag_, false, store,
						IDeployPreferences.DEPLOY_DELETE_CONTAINED_REMINDER);
				if (dlg.getReturnCode() != IDialogConstants.YES_ID) {
					return;
				}
			}
			//}
			deleteCmd = getDeleteFromContainerCommand(selectedObjs);
		} else {
			// else get "delete from diagram or model" command

			// if this is a keyboard delete
			if (_deleteHow == DELKEY_DELETE) {
				//  if at least one non-link is selected, warn user that this is just a delete from diagram
				int nLinks = getNumberOfLinks(selectedObjs);
				if (_deleteFrom == DELETE_FROM_DIAGRAM && nLinks != selectedObjs.size()) {
					IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
					String pref = store.getString(IDeployPreferences.DEPLOY_DELETE_DIAGRAM_REMINDER);
					if (pref != null && pref.equals(Messages.DeployCoreMainPreferencePage_promp_)) {
						MessageDialogWithToggle dlg = MessageDialogWithToggle.openYesNoQuestion(Display
								.getCurrent().getActiveShell(), Messages.DELETE_VIEW_ACTION_LABEL,
								Messages.DeployDeleteAction_Using_Delete_from_Diagram_or_the,
								Messages.DeployDeleteAction_Disable_this_messag_, false, store,
								IDeployPreferences.DEPLOY_DELETE_DIAGRAM_REMINDER);
						if (dlg.getReturnCode() != IDialogConstants.YES_ID) {
							return;
						}
					}
				}
				// if at least one link is selected, warn user that links will be deleted from the model
				if (nLinks != 0) {
					IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
					String pref = store.getString(IDeployPreferences.DEPLOY_DELETE_LINK_REMINDER);
					if (pref != null && pref.equals(Messages.DeployCoreMainPreferencePage_promp_)) {
						MessageDialogWithToggle dlg = MessageDialogWithToggle.openYesNoQuestion(Display
								.getCurrent().getActiveShell(),
								Messages.DeployDeleteAction_Delete_Link_From_Mode_, NLS.bind(
										Messages.DeployDeleteAction_Because_links_are_automatically_add__2,
										Messages.DeployDeleteAction_lin_),
								Messages.DeployDeleteAction_Disable_this_messag_, false, store,
								IDeployPreferences.DEPLOY_DELETE_LINK_REMINDER);
						if (dlg.getReturnCode() != IDialogConstants.YES_ID) {
							return;
						}
					}
				}
			}

			// if delete from model action of an import or import diagram -- warn user that this will also delete all 
			//   other imports/import diagrams from the model
			boolean isDeletingImport = false;
			if (_deleteFrom == DELETE_FROM_MODEL) {
				for (Iterator it = selectedObjs.iterator(); it.hasNext();) {
					Object selectedObj = it.next();
					if (selectedObj instanceof ImportTopologyEditPart) {
						isDeletingImport = true;
						break;
					}
				}
			}

			// unpack any selected consolidated links into their constituant edit parts
			List<ConsolidationLinkEditPart> consolidatedEPList = new ArrayList<ConsolidationLinkEditPart>();
			List<DeployConnectionNodeEditPart> unpackedEPList = new ArrayList<DeployConnectionNodeEditPart>();
			for (Iterator<?> it = selectedObjs.iterator(); it.hasNext();) {
				Object o = it.next();
				if (o instanceof ConsolidationLinkEditPart) {
					ConsolidationLinkEditPart consolidationLinkEP = (ConsolidationLinkEditPart) o;
					// don't bother if a source or target of a link is also being deleted
					//  since whole line gets deleted anyways
					if (!selectedObjs.contains(consolidationLinkEP.getSource())
							&& !selectedObjs.contains(consolidationLinkEP.getTarget())) {
						consolidatedEPList.add(consolidationLinkEP);
						unpackedEPList.addAll(consolidationLinkEP.getConsolidatedLinkList());
					}
				}
			}
			// if there are consolidation links, ask user to select inner links to delete, 
			//  then replace selected objects with those choices
			if (consolidatedEPList.size() > 0) {
				EditPartViewer viewer = getDiagramGraphicalViewer();
				Point location = (Point) MapModeUtil.getMapMode().LPtoDP(
						unpackedEPList.get(0).getFigure().getBounds().getCenter());
				org.eclipse.swt.graphics.Point initialLocation = viewer.getControl().toDisplay(
						new org.eclipse.swt.graphics.Point(location.x, location.y));

				final DeleteConsolidatedLinkDialog dlg = new DeleteConsolidatedLinkDialog(viewer
						.getControl().getShell(), initialLocation, unpackedEPList);
				Display.getDefault().syncExec(new Runnable() {
					public void run() {
						dlg.open();
					}
				});
				if (dlg.getSelectedOptions().size() == 0) {
					return;
				}
				List deleteInnerLinks = new ArrayList(dlg.getSelectedOptions());
				// see if we should delete the consolidated link
				for (ConsolidationLinkEditPart clep : consolidatedEPList) {
					List list = new ArrayList(clep.getConsolidatedLinkList());
					list.removeAll(deleteInnerLinks);
					if (list.size() > 1) {
						selectedObjs.remove(clep);
					} else if (list.size() == 1) {
						// we will be deleting the consolidation link but leave the last inner link alone
						_partialConsolidatedDeleteList.add(clep);
					}
				}
				selectedObjs.addAll(deleteInnerLinks);
			}

			// build a list of containers
			boolean hasMembers = false;
			boolean hasContainedHostee = false;
			boolean hasNonContainedHostee = false;
			List<DeployShapeNodeEditPart> containerList = new ArrayList<DeployShapeNodeEditPart>();
			for (Iterator<?> it = selectedObjs.iterator(); it.hasNext();) {
				Object o = it.next();
				// can't delete members/contained units of proxies
				if (o instanceof DeployShapeNodeEditPart && !isProxyEditPart(o)) {
					DeployShapeNodeEditPart ep = (DeployShapeNodeEditPart) o;
					// set container booleans
					boolean __hasMembers = false;
					boolean __hasContainedHostee = false;
					boolean __hasNonContainedHostee = false;
					EObject eo = ep.resolveSemanticElement();
					if (eo instanceof Unit) {
						Unit unit = (Unit) eo;
						__hasMembers = unit.getMemberLinks().size() > 0;
						for (Iterator<?> itLink = GMFUtils.getAllHostedLinks(unit).iterator(); itLink
								.hasNext();) {
							HostingLink link = (HostingLink) itLink.next();
							if (ContainmentStateUtils.isContainedUnit(ep, link.getHosted())) {
								__hasContainedHostee = true;
							} else {
								if (GMFUtils.getEditPartsFor(ep, link.getHosted()).size() > 0) {
									__hasNonContainedHostee = true;
								}
							}
						}
					}
					if (__hasMembers || __hasContainedHostee || __hasNonContainedHostee) {
						hasMembers = hasMembers || __hasMembers;
						hasContainedHostee = hasContainedHostee || __hasContainedHostee;
						hasNonContainedHostee = hasNonContainedHostee || __hasNonContainedHostee;
						containerList.add(ep);
					}
				}
			}

			// if deleting a container, prompt user to see if we delete contained units too
			if (containerList.size() > 0) {
				boolean isDeleteFromDiagram = _deleteFrom == DELETE_FROM_DIAGRAM;
				DeployDeleteContainerDialog deleteDialog = new DeployDeleteContainerDialog(Display
						.getCurrent().getActiveShell(), hasMembers, hasContainedHostee,
						hasNonContainedHostee, isDeleteFromDiagram);
				deleteDialog.open();
				if (deleteDialog.getReturnCode() == Window.CANCEL) {
					return;
				}

				// Get the container delete command
				DeployDeleteContainerCommand deployDelCmd = new DeployDeleteContainerCommand(
						containerList, deleteDialog.isDeleteMembers(), deleteDialog
								.isDeleteNonContainedHostees(), deleteDialog.isDeleteContainedHostees(),
						hasMembers, hasContainedHostee, isDeleteFromDiagram);
				deleteCmd = new ICommandProxy(deployDelCmd);
			}

			// if there are non containers, use default delete command too
			if (containerList.size() < selectedObjs.size()) {
				List nonContainerList = new ArrayList(selectedObjs);
				nonContainerList.removeAll(containerList);
				Command nonContainerDeleteCmd = createDefaultDeleteCommand(nonContainerList);
				if (deleteCmd == null) {
					deleteCmd = nonContainerDeleteCmd;
				} else {
					deleteCmd = deleteCmd.chain(nonContainerDeleteCmd);
				}
			}

			// if deleting an import from model, delete all editparts (import/import diagram) that uses that import
			if (isDeletingImport) {
				deleteCmd = prependDeleteImportViewsCommand(deleteCmd, selectedObjs);
			}
		}

		// if deleting from the model or container, prepend delete command with a delete 
		// of any links or duplicate views first (otherwise we get undo problems)
		if (_deleteFrom == DELETE_FROM_MODEL || _deleteFrom == DELETE_FROM_CONTAINER) {
			deleteCmd = prependDeleteLinksAndDupViews(deleteCmd, selectedObjs);
		}

		// gather ep's that connect to this editpart whose links must be refreshed after a delete 
		Set<DeployShapeNodeEditPart> epSet = new HashSet<DeployShapeNodeEditPart>();
		collectRefreshEPLinks(selectedObjs, epSet);

		// unselect any associated highlights
		getDiagramGraphicalViewer().deselectAll();
		SelectionUtils.unfadeFigures();

		// when pause cache refresh during delete
		// when deleting links, stop canonical refresh on source and target of link
		CompositeCommand cc = new CompositeCommand(deleteCmd.getLabel());
		DeployToggleCanonicalModeCommand tcmd = DeployToggleCanonicalModeCommand
				.getToggleCanonicalModeCommand(getAffectedEditPartList(selectedObjs), true, false, true);
		cc.compose(new CommandProxy(tcmd));
		cc.compose(new CommandProxy(deleteCmd));
		// add a command to refresh links in case a duplicate unit was deleted which had links to it
		if (epSet.size() > 0) {
			cc.compose(getLinkRefreshCommand(epSet));
		}
		cc.compose(new CommandProxy(DeployToggleCanonicalModeCommand.getToggleCanonicalModeCommand(
				tcmd, true, true, true)));
		deleteCmd = new ICommandProxy(cc);

		GEFUtils.toggleConnectionLayerValidateEnabled(false);
		try {
			execute(deleteCmd, progressMonitor);
		} finally {
			GEFUtils.toggleConnectionLayerValidateEnabled(true);
		}
	}

	private IUndoableOperation getLinkRefreshCommand(final Set<DeployShapeNodeEditPart> epSet) {
		final DeployDiagramEditPart ddep = (DeployDiagramEditPart) getDiagramEditPart();
		AbstractTransactionalCommand cmd = new AbstractTransactionalCommand(ddep.getEditingDomain(),
				"", null) { //$NON-NLS-1$
			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor,
					IAdaptable info) {
				CanonicalUtils.refreshLinks(epSet);
				return CommandResult.newOKCommandResult();
			}

			@Override
			protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				CanonicalUtils.refreshLinks(epSet);
				return super.doRedo(monitor, info);
			}

			@Override
			protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				CanonicalUtils.refreshLinks(epSet);
				return super.doUndo(monitor, info);
			}
		};
		return cmd;
	}

	private void collectRefreshEPLinks(List<?> selectedObjs, Set<DeployShapeNodeEditPart> epSet) {
		for (Iterator<?> it = selectedObjs.iterator(); it.hasNext();) {
			Object selectedObj = it.next();
			if (selectedObj instanceof DeployShapeNodeEditPart) {
				DeployShapeNodeEditPart ep = (DeployShapeNodeEditPart) selectedObj;
				// also build list of all editparts that connect to this editpart to refresh link 
				// canoinical edit policies to possibly create new links
				for (Iterator<?> it2 = ep.getSourceConnections().iterator(); it2.hasNext();) {
					ConnectionEditPart linkEP = (ConnectionEditPart) it2.next();
					EditPart tgtEP = linkEP.getTarget();
					if (tgtEP instanceof DeployShapeNodeEditPart && !selectedObjs.contains(tgtEP)) {
						epSet.add((DeployShapeNodeEditPart) tgtEP);
					}
				}
				for (Iterator<?> it2 = ep.getTargetConnections().iterator(); it2.hasNext();) {
					ConnectionEditPart linkEP = (ConnectionEditPart) it2.next();
					EditPart srcEP = linkEP.getSource();
					if (srcEP instanceof DeployShapeNodeEditPart && !selectedObjs.contains(srcEP)) {
						epSet.add((DeployShapeNodeEditPart) srcEP);
					}
				}
			}
		}
	}

	// for all editparts that are to be deleted, also delete any links to them and any duplicate views of them 
	private Command prependDeleteLinksAndDupViews(Command deleteCmd, List<?> selectedObjs) {
		// if we're doing a containing link delete, we only delete dup views that reside in duplicate parent views
		List<Unit> parentDmoList = null;
		if (_deleteFrom == DELETE_FROM_CONTAINER) {
			parentDmoList = new ArrayList<Unit>();
			for (Iterator<?> it = selectedObjs.iterator(); it.hasNext();) {
				GraphicalEditPart ep = (GraphicalEditPart) it.next();
				parentDmoList.add((Unit) ((GraphicalEditPart) ep.getParent()).resolveSemanticElement());
			}
		}

		// build a set of all duplicate views and links associated with the deleted editparts
		Set<IGraphicalEditPart> viewSet = new HashSet<IGraphicalEditPart>();
		for (Iterator<?> it = selectedObjs.iterator(); it.hasNext();) {
			Object selectedObj = it.next();
			if (selectedObj instanceof DeployConnectionNodeEditPart) {
				DeployConnectionNodeEditPart linkEP = (DeployConnectionNodeEditPart) selectedObj;
				viewSet.addAll(GMFUtils.getLinkEditPartsFor(linkEP.getViewer(), linkEP
						.resolveSemanticElement()));
			} else if (selectedObj instanceof DeployShapeNodeEditPart
					&& !(selectedObj instanceof ImportTopologyEditPart) && !isProxyEditPart(selectedObj)) {
				DeployShapeNodeEditPart ep = (DeployShapeNodeEditPart) selectedObj;
				if (ep.resolveSemanticElement() instanceof DeployModelObject) {
					DeployModelObject dmo = (DeployModelObject) ep.resolveSemanticElement();
					for (Iterator<DeployShapeNodeEditPart> it2 = GMFUtils.getEditPartsFor(ep, dmo)
							.iterator(); it2.hasNext();) {
						DeployShapeNodeEditPart ep2 = it2.next();
						// if delete containing link, only add a view that shares a parent with the deleted view
						if (!selectedObjs.contains(ep2)
								&& (parentDmoList == null || parentDmoList
										.contains(((GraphicalEditPart) ep2.getParent())
												.resolveSemanticElement()))) {
							viewSet.add(ep2);
							viewSet.addAll(ep2.getSourceConnections());
							viewSet.addAll(ep2.getTargetConnections());
						}
					}
				}
			}
		}
		if (viewSet.size() > 0) {
			CompoundCommand cc = new CompoundCommand(DiagramUIMessages.DeleteCommand_Label);
			for (Iterator<IGraphicalEditPart> it = viewSet.iterator(); it.hasNext();) {
				IGraphicalEditPart ep = it.next();
				if (!selectedObjs.contains(ep)) {
					cc.add(new ICommandProxy(new DeleteCommand(ep.getEditingDomain(), ep
							.getNotationView())));
				}
			}
			if (!cc.isEmpty()) {
				deleteCmd = cc.chain(deleteCmd);
			}
		}
		return deleteCmd;
	}

	// if an Import object is being deleted, delete all editparts that use that Import
	private Command prependDeleteImportViewsCommand(Command deleteCmd, List selectedObjs) {
		// build a list of import editparts that use an import that will be deleted from model
		Set<GraphicalEditPart> duplicateImportAndProxyEP = new HashSet<GraphicalEditPart>();
		for (Iterator<?> it = selectedObjs.iterator(); it.hasNext();) {
			Object selectedObj = it.next();
			if (selectedObj instanceof ImportTopologyEditPart) {
				ImportTopologyEditPart ep = (ImportTopologyEditPart) selectedObj;
				Import imprt = (Import) ep.resolveSemanticElement();
				// find all ep's that view this Import that won't be deleted
				for (Iterator it2 = ep.getParent().getChildren().iterator(); it2.hasNext();) {
					Object o = it2.next();
					// if this editpart is getting deleted, don't worry about it
					if (!selectedObjs.contains(o)) {
						// if another ImportTopologyEditPart is also referring to this import, don't allow model delete
						if (o instanceof ImportTopologyEditPart
								&& ((ImportTopologyEditPart) o).resolveSemanticElement() == imprt) {
							duplicateImportAndProxyEP.add((ImportTopologyEditPart) o);
						}
					}
				}

				// also add any external proxy views that belong to this topology
				InstanceConfiguration ic = imprt.getInstanceConfiguration();
				if (ic.getVisibleUnits().size() > 0) {
					List list = ((DeployDiagramEditPart) getDiagramEditPart())
							.findProxyEditPartsForTopology(ic.getVisibleUnits().get(0).getTopology());
					if (list != null) {
						duplicateImportAndProxyEP.addAll(list);
					}
				}
			}
		}

		// if there are any views to delete, prepend delete view commands to the model delete command
		if (duplicateImportAndProxyEP.size() > 0) {
			CompoundCommand cc = new CompoundCommand(DiagramUIMessages.DeleteCommand_Label);
			for (Iterator<GraphicalEditPart> it = duplicateImportAndProxyEP.iterator(); it.hasNext();) {
				GraphicalEditPart ep = it.next();
				cc
						.add(new ICommandProxy(new DeleteCommand(ep.getEditingDomain(), ep
								.getNotationView())));
			}
			if (!cc.isEmpty()) {
				deleteCmd = cc.chain(deleteCmd);
			}
		}
		return deleteCmd;
	}

	/*
	 * we are just deleting links to units and their views
	 */
	private Command getDeleteFromContainerCommand(final List selectedObjs) {
		final DeployDiagramEditPart ddep = (DeployDiagramEditPart) getDiagramEditPart();
		return new ICommandProxy(new AbstractTransactionalCommand(ddep.getEditingDomain(), "", null) { //$NON-NLS-1$
					protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor,
							IAdaptable info) throws ExecutionException {

						// for each selected editpart
						for (Iterator<?> it = selectedObjs.iterator(); it.hasNext();) {
							Object o = it.next();
							if (o instanceof DeployShapeNodeEditPart) {
								DeployShapeNodeEditPart ep = (DeployShapeNodeEditPart) o;
								Unit unit = (Unit) ep.resolveSemanticElement();
								if (ep.getParent() != null
										&& ep.getParent().getParent() instanceof DeployShapeNodeEditPart) {
									DeployShapeNodeEditPart parentEP = (DeployShapeNodeEditPart) ep
											.getParent().getParent();
									EObject eo = parentEP.resolveSemanticElement();
									if (eo instanceof Unit) {
										Unit containerUnit = (Unit) eo;

										// Destroy any member link
										List memberLinks = containerUnit.getMemberLinks();
										for (int i = memberLinks.size() - 1; i >= 0; i--) {
											MemberLink link = (MemberLink) memberLinks.get(i);
											if (link.getTarget().equals(unit)) {
												EcoreUtil.remove(link);
											}
										}

										// Destroy any hosting link
										List hostingLinks = GMFUtils.getAllHostLinks(unit);
										for (int i = hostingLinks.size() - 1; i >= 0; i--) {
											HostingLink link = (HostingLink) hostingLinks.get(i);
											if (link.getHosted().equals(unit)) {
												if (link instanceof DeferredHostingLinkImpl) {
													EcoreUtil.remove(((DeferredHostingLinkImpl) link)
															.getContraintLink());
												} else {
													EcoreUtil.remove(link);
												}
											}
										}
										// stick view in diagram
										ViewUtil.insertViewNextToParent(ep.getNotationView());
									}
								}
							}
						}
						return CommandResult.newOKCommandResult();
					}
				});
	}

	// filter out selected editpart
	private List<?> getFilteredSelectedObjects() {
		List<?> rawList = getSelectedObjects();
		List filteredList = new ArrayList();
		List<Import> importList = new ArrayList<Import>();
		for (Iterator<?> it = rawList.iterator(); it.hasNext();) {
			Object obj = it.next();
			if (obj instanceof DeployDiagramEditPart || !(obj instanceof AbstractGraphicalEditPart)) {
				continue;
			}
			// pass thru all non deploy shapes and shapes that have no element
			else if (obj instanceof DeployShapeNodeEditPart) {
				DeployShapeNodeEditPart ep = (DeployShapeNodeEditPart) obj;
				EObject eo = ep.resolveSemanticElement();
				if (eo != null) {

					// filter out views whose parents are already selected
					if (isAnyParentSelected(ep, rawList)) {
						continue;
					}

					// SPECIAL CASE: if deleting ImportTopologyEditPart from the model, since multiple ImportTopologyEditParts
					// can point to the same Import, we only need one ImportTopologyEditPart to be deleted per Import--
					// the other's views will be deleted by prependDeleteImportViewsCommand
					if (_deleteFrom == DELETE_FROM_MODEL && eo instanceof Import) {
						if (importList.contains(eo)) {
							continue;
						}
						importList.add((Import) eo);
					}
				}

			}
			filteredList.add(obj);
		}
		return filteredList;
	}

	// no need to delete an editpart if its parent is selected since deleting the parent will delete this child
	private boolean isAnyParentSelected(IGraphicalEditPart ep, List selectedObjs) {
		EditPart walker = ep;
		while (walker != null && !(walker instanceof DeployDiagramEditPart)) {
			walker = walker.getParent();
			if (selectedObjs.contains(walker)) {
				return true;
			}
		}
		return false;
	}

	// determine the number of selected objects which are links
	private int getNumberOfLinks(List<?> selectedObjects) {
		int c = 0;
		for (Iterator<?> it = selectedObjects.iterator(); it.hasNext();) {
			if (it.next() instanceof DeployConnectionNodeEditPart) {
				c++;
			}
		}
		return c;
	}

	// build a list of editparts that we need to kill the canonical refresh on during this delete
	private Collection getAffectedEditPartList(List selectedObjects) {
		Set<IGraphicalEditPart> set = new HashSet<IGraphicalEditPart>();
		for (Iterator<?> it = selectedObjects.iterator(); it.hasNext();) {
			EditPart ep = (EditPart) it.next();
			if (ep instanceof DeployConnectionNodeEditPart) {
				DeployConnectionNodeEditPart conn = (DeployConnectionNodeEditPart) ep;
				set.add((IGraphicalEditPart) conn.getSource());
				set.add((IGraphicalEditPart) conn.getTarget());
			} else if (ep instanceof DeployShapeNodeEditPart) {
				EObject eo = ((DeployShapeNodeEditPart) ep).resolveSemanticElement();
				if (eo instanceof DeployModelObject) {
					DeployModelObject dmo = (DeployModelObject) eo;
					for (Iterator<DeployShapeNodeEditPart> it2 = GMFUtils.getEditPartsFor(ep, dmo)
							.iterator(); it2.hasNext();) {
						DeployShapeNodeEditPart ep2 = it2.next();
						set.add(ep2);
						// also do all parents
						EditPart walker = ep2.getParent();
						while (walker != null) {
							if (walker instanceof DeployShapeNodeEditPart
									|| walker instanceof DeployDiagramEditPart) {
								set.add((IGraphicalEditPart) walker);
							}
							walker = walker.getParent();
						}
					}
				}
			}
		}
		return set;
	}

	/**
	 * @param viewer
	 * @return are all current selections contained units?
	 */
	static public boolean isAllContainedEditParts(EditPartViewer viewer) {
		List<?> list = viewer.getSelectedEditParts();
		for (Iterator<?> it = list.iterator(); it.hasNext();) {
			Object selectedObj = it.next();
			if (!(selectedObj instanceof EditPart && isContainedUnit((EditPart) selectedObj, list))) {
				return false;
			}
		}
		return true;
	}

	// is a unit that's contained by another unit selected
	static private boolean isContainedUnit(EditPart ep, List<?> selectedObjects) {
		return !(ep instanceof ConnectionNodeEditPart)
				&& !selectedObjects.contains(GEFUtils.getTopEditPart(ep));
	}

	// create a delete command
	private Command createDefaultDeleteCommand(List selectedObjs) {
		if (selectedObjs.isEmpty()) {
			return null;
		}
		CompoundCommand cc = new CompoundCommand(DiagramUIMessages.DeleteCommand_Label);
		for (Iterator<?> i = selectedObjs.iterator(); i.hasNext();) {
			final IGraphicalEditPart ep = (IGraphicalEditPart) i.next();
			switch (_deleteFrom)
			{
			case DELETE_FROM_DIAGRAM:
				// if we're deleting the view of an editpart that's contained,
				//  we just make the view invisible (so that canonical refresh doesn't just recreate the view)
				if (isContainedUnit(ep, selectedObjs)) {
					cc.add(new ICommandProxy(new AbstractTransactionalCommand(ep.getEditingDomain(),
							"", null) {//$NON-NLS-1$
								protected CommandResult doExecuteWithResult(
										IProgressMonitor progressMonitor, IAdaptable info) {
									if (ep.getParent() != null
											&& ep.getParent().getParent() instanceof GraphicalEditPart) {
										GraphicalEditPart parentEP = (GraphicalEditPart) ep.getParent()
												.getParent();

										// prevent canonical edit policies from recreating
										View parentView = parentEP.getNotationView();
										DeployStyle parentStyle = (DeployStyle) parentView
												.getStyle(DeployNotationPackage.eINSTANCE.getDeployStyle());
										if (parentStyle != null) {
											parentStyle.getFilteredSemanticElements().add(
													ep.resolveSemanticElement());
										}

										// delete view
										Command cmd = ep.getCommand(new GroupRequest(
												RequestConstants.REQ_DELETE));
										if (cmd != null) {
											cmd.execute();
										}
									}
									return CommandResult.newOKCommandResult();
								}
							}));
				} else {
					// else gets DeleteCommand which just does a ViewUtil.destroy(ep.getNotationView)
					cc.add(ep.getCommand(new GroupRequest(RequestConstants.REQ_DELETE)));
				}
				break;
			case DELETE_FROM_MODEL:
				// a proxy edit part delete just deletes its view
				// or if this is the second model delete of the same import
				if (isProxyEditPart(ep)) {
					cc.add(ep.getCommand(new GroupRequest(RequestConstants.REQ_DELETE)));
				} else {
					Request request = new EditCommandRequestWrapper(new DestroyElementRequest(ep
							.getEditingDomain(), false));
					// if we're deleting the consolidated link and not its children
					if (_partialConsolidatedDeleteList.contains(ep)) {
						request.getExtendedData().put(ConsolidationLinkEditPart.IGNORE_INNER_LINKS, null);
					}

					// gets delete command from ContainerEditHelper.getDestroyElementCommand()
					cc.add(ep.getCommand(request));
				}
				break;
			case DELETE_FROM_CONTAINER:
				// never occurs-- "delete from container" command handled above by calling getDeleteFromContainerCommand()
				// creates a command that deletes the link to the container and the view
				break;
			}
		}
		return cc;
	}

	// does this editpart represent a proxy?
	private boolean isProxyEditPart(Object object) {
		if (object instanceof DeployShapeNodeEditPart) {
			DeployShapeNodeEditPart ep = (DeployShapeNodeEditPart) object;
			EObject eo = ep.resolveSemanticElement();
			if (eo instanceof DeployModelObject) {
				return PropertyUtils.isProxy((DeployModelObject) eo);
			}
		}
		return false;
	}
}
