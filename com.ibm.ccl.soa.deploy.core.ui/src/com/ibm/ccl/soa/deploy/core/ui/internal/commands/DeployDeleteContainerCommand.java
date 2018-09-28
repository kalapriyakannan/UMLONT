/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.internal.commands;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;
import com.ibm.ccl.soa.deploy.core.ui.util.ContainmentStateUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GEFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ResourceUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.CanonicalUtils.UnitLinkData;

/**
 * Customized delete action for single selected unit
 */
public class DeployDeleteContainerCommand extends DeployTransactionalCommand {

	private final List<DeployShapeNodeEditPart> _epList;

	private final boolean _isDeleteMembers;
	private final boolean _isDeleteNonContainedHostees;
	private final boolean _isDeleteContainedHostees;
	private final boolean _hasMember;
	private final boolean _hasContainedHostee;
	private final boolean _isDeleteViewOnly;

	/**
	 * 
	 * @param epList
	 * @param isDeleteMembers
	 * @param isDeleteNonContainedHostees
	 * @param isDeleteContainedHostees
	 * @param hasMember
	 * @param hasContainedHostee
	 * @param isDeleteViewOnly
	 */
	public DeployDeleteContainerCommand(List<DeployShapeNodeEditPart> epList,
			boolean isDeleteMembers, boolean isDeleteNonContainedHostees,
			boolean isDeleteContainedHostees, boolean hasMember, boolean hasContainedHostee,
			boolean isDeleteViewOnly) {
		super(epList.get(0).getEditingDomain(), DiagramUIMessages.DeleteCommand_Label,
				getAllWorkspaceFiles(epList.get(0).getNotationView()));

		_epList = epList;
		_isDeleteMembers = isDeleteMembers;
		_isDeleteNonContainedHostees = isDeleteNonContainedHostees;
		_isDeleteContainedHostees = isDeleteContainedHostees;
		_hasMember = hasMember;
		_hasContainedHostee = hasContainedHostee;
		_isDeleteViewOnly = isDeleteViewOnly;
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) {

		// for each EditPart to be deleted
		for (DeployShapeNodeEditPart selectedEP : _epList) {
			View selectedView = selectedEP.getNotationView();
			Unit selectedUnit = (Unit) selectedView.getElement();
			DeployDiagramEditPart ddep = GMFUtils.getDeployDiagramEditPart(selectedEP);
			Map<Unit, UnitLinkData> linkCacheMap = ddep.getSemanticCacheData().getLinkCacheMap();
			UnitLinkData linkData = linkCacheMap.get(selectedUnit);

			// if not deleting the children of a view, move child views into parent container
			boolean moveMemberViews = !_isDeleteMembers && _hasMember;
			boolean moveHostViews = !_isDeleteContainedHostees && _hasContainedHostee;
			if (moveMemberViews || moveHostViews) {
				int x = ((Integer) ViewUtil.getStructuralFeatureValue(selectedView,
						NotationPackage.eINSTANCE.getLocation_X())).intValue();
				int y = ((Integer) ViewUtil.getStructuralFeatureValue(selectedView,
						NotationPackage.eINSTANCE.getLocation_Y())).intValue();
				View containerView = (View) selectedView.eContainer();

				List<EObject> containerElements = new ArrayList<EObject>();
				for (Iterator<View> it = containerView.getChildren().iterator(); it.hasNext();) {
					containerElements.add(it.next().getElement());
				}
				boolean isList = false;
				View compartmentView = ViewUtil.getChildBySemanticHint(selectedView,
						DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
				if (compartmentView == null) {
					compartmentView = ViewUtil.getChildBySemanticHint(selectedView,
							DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
					isList = true;
				}
				if (compartmentView != null) {
					int inc = 0;
					List children = new ArrayList(compartmentView.getChildren());
					for (Iterator it = children.iterator(); it.hasNext();) {
						View child = (View) it.next();
						EObject childElement = child.getElement();
						// don't copy a view to parent container if there's one there already
						if (containerElements.contains(childElement)) {
							continue;
						}

						// if hostee is contained
						if (ContainmentStateUtils.isContainedUnit((Unit) childElement)) {
							continue;
						}

						// if moving hostees but not members, don't move if a member
						if (!moveMemberViews && moveHostViews) {
							boolean isMember = false;
							List memberLinks = selectedUnit.getMemberLinks();
							for (int i = memberLinks.size() - 1; i >= 0 && !isMember; i--) {
								MemberLink link = (MemberLink) memberLinks.get(i);
								isMember = link.getTarget().equals(childElement);
							}
							if (isMember) {
								continue;
							}
						}

						// if move member but not hostee, don't move if hostee
						boolean isHostee = false;
						if (linkData != null) {
							List hostingLinks = linkData.getAllHostingLinks();
							for (int i = hostingLinks.size() - 1; i >= 0 && !isHostee; i--) {
								HostingLink link = (HostingLink) hostingLinks.get(i);
								isHostee = link.getHosted().equals(childElement);
							}
						}
						if (moveMemberViews && !moveHostViews) {
							if (isHostee) {
								continue;
							}
						}

						// if this is a dup view going into the canvas, make it as a dup view so it won't get deleted by canonical
						if (containerView instanceof Diagram
								&& GMFUtils.isDuplicateView(selectedEP, child)) {
							DeployStyle deployStyleSelected = (DeployStyle) child
									.getStyle(DeployNotationPackage.eINSTANCE.getDeployStyle());
							deployStyleSelected.setIsDuplicateCanvasView(true);
						}

						// determine the view's position in the parent container
						int newX, newY;
						if (isList) {
							newX = x + inc;
							newY = y + inc;
							inc += 1000;
						} else {
							newX = x
									+ ((Integer) ViewUtil.getStructuralFeatureValue(child,
											NotationPackage.eINSTANCE.getLocation_X())).intValue();
							newY = y
									+ ((Integer) ViewUtil.getStructuralFeatureValue(child,
											NotationPackage.eINSTANCE.getLocation_Y())).intValue();
						}
						ViewUtil.setStructuralFeatureValue(child, NotationPackage.eINSTANCE
								.getLocation_X(), new Integer(newX));
						ViewUtil.setStructuralFeatureValue(child, NotationPackage.eINSTANCE
								.getLocation_Y(), new Integer(newY));
						containerView.insertChild(child, true);
					}
				}
			}

			// if this is just deleting view, handle it ourselves
			if (_isDeleteViewOnly) {
				EditPartViewer viewer = selectedEP.getViewer();
				selectedEP.getCommand(new GroupRequest(RequestConstants.REQ_DELETE)).execute();
				if (_isDeleteNonContainedHostees) {
					// Get all hosted units
					linkData = linkCacheMap.get(selectedUnit);
					if (linkData != null) {
						List hostingLinks = linkData.getHostingLinks();
						for (Iterator i = hostingLinks.iterator(); i.hasNext();) {
							HostingLink hostingLink = (HostingLink) i.next();
							Unit hostee = hostingLink.getHosted();
							if (hostingLink.getHost().equals(selectedUnit)
									&& !ContainmentStateUtils.isContainedUnit(selectedEP, hostee)) {
								// delete all views
								List views = GMFUtils.getAllDuplicateViewsFor(selectedEP, selectedView,
										false);
								for (int j = 0; j < views.size(); j++) {
									View view = (View) views.get(j);
									EditPart ep = (EditPart) viewer.getEditPartRegistry().get(view);
									if (ep != null) {
										ep.getCommand(new GroupRequest(RequestConstants.REQ_DELETE))
												.execute();
									}
								}
							}
						}
					}
				}
			} else {

				// else we're deleting the model element

				// If not deleting members, delete the membership links so that ContainerEditHelper won't delete the members 
				if (!_isDeleteMembers && _hasMember) {
					// Destroy all member links
					List memberLinks = selectedUnit.getMemberLinks();
					for (int i = memberLinks.size() - 1; i >= 0; i--) {
						EcoreUtil.remove((MemberLink) memberLinks.get(i));
					}
				}

				// If not deleting a hostee, delete the hosting link so that ContainerEditHelper won't delete the hostee
				if (linkData != null) {
					List hostingLinks = linkData.getHostingLinks();
					for (int i = hostingLinks.size() - 1; i >= 0; i--) {
						HostingLink hostingLink = (HostingLink) hostingLinks.get(i);
						boolean isContainedHostee = ContainmentStateUtils.isContainedUnit(selectedEP,
								hostingLink.getHosted());
						if (isContainedHostee && !_isDeleteContainedHostees || !isContainedHostee
								&& !_isDeleteNonContainedHostees) {
							EcoreUtil.remove(hostingLink);
						}
					}
				}

				/**
				 * Default delete command from ContainerEditHelper only deletes configuration units, so
				 * non-configuration hosted units have to be deleted here if user requests it
				 */
				Set nonContainedHostess = new HashSet();
				if (_isDeleteNonContainedHostees) {
					// Get all hosted units
					linkData = linkCacheMap.get(selectedUnit);
					if (linkData != null) {
						List hostingLinks = linkData.getHostingLinks();
						for (Iterator i = hostingLinks.iterator(); i.hasNext();) {
							HostingLink hostingLink = (HostingLink) i.next();
							Unit hostee = hostingLink.getHosted();
							if (hostingLink.getHost().equals(selectedUnit)
									&& !ContainmentStateUtils.isContainedUnit(selectedEP, hostee)) {
								List<DeployShapeNodeEditPart> list = GMFUtils.getEditPartsFor(selectedEP,
										hostee);
								if (list.size() > 0) {
									nonContainedHostess.add(list.get(0));
								}
							}
						}
					}
				}

				// remove selected unit from contract
				if (selectedUnit.getEditTopology() != null) {
					ConfigurationContract contract = selectedUnit.getEditTopology()
							.getConfigurationContract();
					if (contract != null) {
						contract.clear(selectedUnit);
					}
				}

				/** Execute the default delete command from ContainerEditHelper */

				// Ensure that the delete action starts from the duplicate edit part
				// on the diagram. Otherwise, the duplicate edit part on the diagram
				// will be assigned topology as its semantic model, leading to ClassCastException 
				// in the UnitEditPart.
				IGraphicalEditPart delStartEP = getDupOnDiagramIfAny(selectedEP);

				// if we're deleting all members and a child member view of this 
				// editpart is also its parent, delete the parent instead
				List<DeployShapeNodeEditPart> refreshList = new ArrayList<DeployShapeNodeEditPart>();
				ResizableCompartmentEditPart compartmentEP = (ResizableCompartmentEditPart) ((GraphicalEditPart) delStartEP)
						.getChildBySemanticHint(DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
				if (compartmentEP == null) {
					compartmentEP = (ResizableCompartmentEditPart) ((GraphicalEditPart) delStartEP)
							.getChildBySemanticHint(DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
				}
				if (compartmentEP != null) {
					if (_isDeleteMembers) {
						for (Iterator it = compartmentEP.getChildren().iterator(); it.hasNext();) {
							GraphicalEditPart ep = (GraphicalEditPart) it.next();
							if (GMFUtils.isMemberOf(ep, (GraphicalEditPart) delStartEP)) {
								List dupParts = GMFUtils.getAllContainedDuplicateEditParts(ep);
								for (Iterator it2 = dupParts.iterator(); it2.hasNext();) {
									IGraphicalEditPart dupEP = (IGraphicalEditPart) it2.next();
									if (GEFUtils.isChildOf(delStartEP, dupEP)) {
										delStartEP = dupEP;
									}
								}
							}
						}
					} else if (_hasMember) {
						refreshList.addAll(compartmentEP.getChildren());
					}
				}

				// if we're deleting hosted units and a hosted unit of this 
				// editpart is also its parent, delete the parent instead
				compartmentEP = (ResizableCompartmentEditPart) ((GraphicalEditPart) delStartEP)
						.getChildBySemanticHint(DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
				if (compartmentEP != null) {
					if (_isDeleteNonContainedHostees || _isDeleteContainedHostees) {
						for (Iterator it = delStartEP.getChildren().iterator(); it.hasNext();) {
							GraphicalEditPart ep = (GraphicalEditPart) it.next();
							if (!(ep instanceof DeployShapeNodeEditPart)) {
								continue;
							}
							if (GMFUtils.isHosteeOf(ep, (GraphicalEditPart) delStartEP)) {
								List dupParts = GMFUtils.getAllContainedDuplicateEditParts(ep);
								for (Iterator it2 = dupParts.iterator(); it2.hasNext();) {
									IGraphicalEditPart dupEP = (IGraphicalEditPart) it2.next();
									if (GEFUtils.isChildOf(delStartEP, dupEP)) {
										delStartEP = dupEP;
									}
								}
							}
						}
					} else if (_hasContainedHostee) {
						refreshList.addAll(compartmentEP.getChildren());
					}
				}

				// create a list of command that will delete the container and any non-contained hostees
				nonContainedHostess.add(delStartEP);
				Request delReq = new EditCommandRequestWrapper(new DestroyElementRequest(delStartEP
						.getEditingDomain(), false));
				CompoundCommand cc = new CompoundCommand(DiagramUIMessages.DeleteCommand_Label);
				for (Iterator it = nonContainedHostess.iterator(); it.hasNext();) {
					cc.add(((DeployShapeNodeEditPart) it.next()).getCommand(delReq));
				}
				cc.execute();
			}
		}

		return CommandResult.newOKCommandResult();
	}

	/**
	 * Get the duplicate edit part on the diagram
	 * 
	 * @return duplicate editpart on the diagram
	 */
	private DeployShapeNodeEditPart getDupOnDiagramIfAny(DeployShapeNodeEditPart ep) {
		if (ep.getParent() instanceof DeployDiagramEditPart) {
			return ep;
		}

		EObject element = ViewUtil.resolveSemanticElement(ep.getNotationView());

		DiagramEditPart diagramEP = ResourceUtils.getActiveDeployEditDomain().getDiagramEditPart();
		for (Iterator i = diagramEP.getChildren().iterator(); i.hasNext();) {
			Object obj = i.next();
			if (obj instanceof DeployShapeNodeEditPart) {
				DeployShapeNodeEditPart childEP = (DeployShapeNodeEditPart) obj;
				View childView = childEP.getNotationView();
				if (element == ViewUtil.resolveSemanticElement(childView)) {
					return childEP;
				}
			}
		}

		return ep;
	}
}
