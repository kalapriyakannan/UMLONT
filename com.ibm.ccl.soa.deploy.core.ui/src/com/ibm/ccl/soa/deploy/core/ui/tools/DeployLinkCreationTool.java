/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Cursors;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.tools.ConnectionCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.wst.common.frameworks.datamodel.IDataModel;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.ConceptualNode;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.DeploymentTopologyDomain;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.DeployToggleCanonicalModeCommand;
import com.ibm.ccl.soa.deploy.core.ui.preferences.IDeployPreferences;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreImages;
import com.ibm.ccl.soa.deploy.core.ui.util.FilterLinkData;
import com.ibm.ccl.soa.deploy.core.ui.util.FilteringUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.SelectionUtils;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;
import com.ibm.ccl.soa.infrastructure.emf.IScribblerDomain;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;
import com.ibm.ccl.soa.infrastructure.operations.IAbstractScribblerDataModelProperties;

/**
 * 
 * @since 1.0
 * 
 */
abstract public class DeployLinkCreationTool extends ConnectionCreationTool implements DragTracker {

	/**
	 * key to request map that saves the link descriptor for the create link command
	 */
	final static public String DESCRIPTOR = "descriptor"; //$NON-NLS-1$
	final static public String LINKRESULTMAP = "linkresultmap"; //$NON-NLS-1$
	private EditPartViewer _viewer;

	/**
	 * 
	 * @param elementType
	 */
	public DeployLinkCreationTool(IElementType elementType) {
		super(elementType);
		init();
	}

	private void init() {
		setDefaultCursor(DeployCoreImages.CONNECT_CURSOR);
		setDisabledCursor(DeployCoreImages.CONNECT_CURSOR);
	}

	// user is dragging tool
	protected boolean handleDragStarted() {
		// when tool starts to drag unfade other figures so user can see them
		SelectionUtils.unfadeFigures();
		return super.handleDragStarted();
	}

	@Override
	protected boolean handleMove() {
		if (getTargetEditPart() instanceof DeployDiagramEditPart) {
			boolean isLinkCanvasSearch = false;
			// get starting point
			Request req = this.getSourceRequest();
			if (req instanceof CreateConnectionViewAndElementRequest) {
				CreateConnectionViewAndElementRequest request = (CreateConnectionViewAndElementRequest) req;
				EditPart srcEP = request.getSourceEditPart();
				if (srcEP instanceof DeployShapeNodeEditPart) {
					ConnectionAnchor anchor = ((DeployShapeNodeEditPart) srcEP)
							.getSourceConnectionAnchor(request);
					Point pt = anchor.getLocation(anchor.getReferencePoint());
					if (pt != null) {
						Dimension d = getLocation().getDifference(pt);
						int h = Math.abs(d.height);
						int w = Math.abs(d.width);
						isLinkCanvasSearch = h > 20 || w > 20;
					}
				}
			}
			((DeployDiagramEditPart) getTargetEditPart()).setLinkCanvasSearch(isLinkCanvasSearch);
		}
		return super.handleMove();
	}

	// user has pressed enter key on the palette, create the links
	protected void createConnection() {
		List selectedEditParts = getCurrentViewer().getSelectedEditParts();
		if (!selectedEditParts.isEmpty()) {
			IGraphicalEditPart srcEP = (IGraphicalEditPart) selectedEditParts.get(0);
			IGraphicalEditPart tgtEP = selectedEditParts.size() == 2 ? (IGraphicalEditPart) selectedEditParts
					.get(1)
					: srcEP;
			createConnection(srcEP, tgtEP);
		}
	}

	// user has released mouse tool, create the link(s)
	protected boolean handleCreateConnection() {
		boolean bRet = false;
		setAvoidDeactivation(true);
		Request req = this.getSourceRequest();
		if (req instanceof CreateConnectionViewAndElementRequest) {
			CreateConnectionViewAndElementRequest request = (CreateConnectionViewAndElementRequest) req;
			EditPart srcEP = request.getSourceEditPart();
			EditPart tgtEP = request.getTargetEditPart();
			bRet = createConnection(srcEP, tgtEP);
		}
		setAvoidDeactivation(false);
		eraseSourceFeedback();
		deactivate();
		return bRet;
	}

	/*
	 * common method to create links from keyboard or mouse
	 */
	private boolean createConnection(EditPart srcEP, EditPart tgtEP) {
		/*
		 * prompt user to ask what links they want to create
		 */
		_viewer = srcEP.getViewer();
		EObject srcObj = ViewUtil.resolveSemanticElement((View) srcEP.getModel());
		EObject tgtObj = tgtEP != null ? ViewUtil.resolveSemanticElement((View) tgtEP.getModel())
				: null;
		DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();

		org.eclipse.swt.graphics.Point point = null;// = new Point (100,100); // to do work on algorithm
		GraphicalEditPart gep = (GraphicalEditPart) tgtEP.getAdapter(GraphicalEditPart.class);
		if (gep != null) {
			Rectangle bounds = gep.getFigure().getBounds().getCopy();
			gep.getFigure().translateToAbsolute(bounds);
			org.eclipse.swt.graphics.Point p = new org.eclipse.swt.graphics.Point(bounds.x
					+ bounds.width, bounds.y);
			p = gep.getViewer().getControl().toDisplay(p);
			point = p;
		}
		Unit unit1 = null;
		Unit unit2 = null;
		Requirement requirement = null;
		Capability capability = null;

		if (srcObj instanceof Unit) {
			unit1 = (Unit) srcObj;
		} else if (srcObj instanceof Requirement) {
			requirement = (Requirement) srcObj;
			DeployModelObject parent = requirement.getParent();
			if (parent != null && parent instanceof Unit) {
				unit1 = (Unit) requirement.getParent();
			}
		}

		if (tgtObj instanceof Unit) {
			unit2 = (Unit) tgtObj;
		} else if (tgtObj instanceof Capability) {
			capability = (Capability) tgtObj;
			DeployModelObject parent = capability.getParent();
			if (parent != null && parent instanceof Unit) {
				unit2 = (Unit) parent;
			}
		}
		LinkType[] linkTypes = getLinkTypes();

		if (unit1 != null && unit2 != null) {

			if (isModelReversed()) {
				unit1 = unit2;
				unit2 = (Unit) srcObj;
			}
			if (unit1 instanceof ConceptualNode && unit2 instanceof ConceptualNode) {
				LinkDescriptor[] links = dvs.getPossibleLinks(unit1, requirement, unit2, capability,
						linkTypes, DeployValidatorService.MATCHER_DEPTH_ALL);
				if (links.length > 0) {
					if (links.length == 1) {
						List list = new ArrayList();
						list.add(links[0]);
						createLinks(list);
					} else {
						List<LinkDescriptor> filteredLinks = promptForConceptualNodeLinks(unit1, unit2,
								point, links);
						LinkDescriptor[] filteredLinkz = new LinkDescriptor[filteredLinks.size()];
						filteredLinks.toArray(filteredLinkz);
						createLinks(filteredLinks);
					}
				}
				return false;
			}
			// if getUserSelection() can create matches (ex: add capabilities to the unit to allow a link creation)
			if (canPromptCreateMatches()) {
				LinkDescriptor[] links = dvs.getPossibleLinks(unit1, null, unit2, null, linkTypes,
						DeployValidatorService.MATCHER_DEPTH_ALL);
				// if there's just one possible link, just use it if the user preference is set
				IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
				boolean isAutoCreate100Link = store != null
						&& store.getBoolean(IDeployPreferences.DEPLOY_DLCD_AUTO_CREATE_LINK);
				boolean isCreateMatches = store != null
						&& store.getBoolean(IDeployPreferences.DEPLOY_DLCP_ALLOW_MATCH_CREATION);
				if (isAutoCreate100Link && links.length == 1 && links[0].getLinkWeight() == 100) {
					createLinks(Arrays.asList(links));
				} else if (isCreateMatches || links.length > 0) {
					// else put up selection dialog
					List userSelections = getUserSelections(srcEP, tgtEP, links);
					if (userSelections != null && userSelections.size() > 0) {
						createLinks(userSelections);
					}
				}
				// else getUserSelection() cannot create a match-- so see if there are any matches
			} else if (dvs.canCreateLink(unit1, requirement, unit2, capability, linkTypes,
					DeployValidatorService.MATCHER_DEPTH_ALL).isOK()) {
				LinkDescriptor[] links = dvs.getPossibleLinks(unit1, requirement, unit2, capability,
						linkTypes, DeployValidatorService.MATCHER_DEPTH_ALL);
				if (links.length > 0) {
					List tgtList = getTargetLists(links);

					// returns a list of lists (each link can be to multiple duplicate views)
					// if there's just one possible link, just use it
					List choices = (List) tgtList.get(0);
					if (links.length == 1 && (choices.contains(tgtEP) || choices.contains(capability))) {
						List list = new ArrayList();
						list.add(links[0]);
						createLinks(list);
					} else {
						// else prompt user with choices
						List userSelections = getUserSelections(unit1, links);
						if (userSelections != null) {
							createLinks(userSelections);
						} else {
							return true;
						}
					}
				}
				// if not, see if there are any matches within this container
			} else if (tgtEP instanceof GraphicalEditPart) {
				List<Unit> matchingOptions = GMFUtils.findContainedMatchingOptions(unit2, dvs, tgtEP
						.getChildren());

				Set<LinkDescriptor> links = new HashSet<LinkDescriptor>();
				for (Iterator<Unit> iterator = matchingOptions.iterator(); iterator.hasNext();) {
					Unit targetUnit = iterator.next();
					LinkDescriptor[] descriptors = dvs.getPossibleLinks(targetUnit, requirement, unit2,
							capability, linkTypes, DeployValidatorService.MATCHER_DEPTH_ALL);
					links.addAll(Arrays.asList(descriptors));
				}
				LinkDescriptor[] availableDescriptors = links.toArray(new LinkDescriptor[links.size()]);
				if (availableDescriptors.length > 0) {

					// returns a list of lists (each link can be to multiple duplicate views)
					// prompt user with choices
					List userSelections = getUserSelections(unit1, availableDescriptors);
					if (userSelections != null) {
						createLinks(userSelections);
					} else {
						return true;
					}

				}
			}
			// if just dragged to canvas, try searching the model for a match
		} else if (tgtEP instanceof DeployDiagramEditPart
				&& ((DeployDiagramEditPart) tgtEP).isLinkCanvasSearch()) {
			DeployDiagramEditPart ddep = (DeployDiagramEditPart) tgtEP;
			ddep.setLinkCanvasSearch(false);

			// build list of possible LinkDescriptors from children of canvas
			setCursor(Cursors.WAIT);
			List allPossibleLinks = new ArrayList();
			try {
				Topology top = (Topology) ddep.resolveSemanticElement();
				for (Iterator<Unit> it = top.findAllUnits(); it.hasNext();) {
					Unit eo = it.next();
					unit1 = isModelReversed() ? (Unit) eo : (Unit) srcObj;
					unit2 = isModelReversed() ? (Unit) srcObj : (Unit) eo;
					if (dvs.canCreateLink(unit1, requirement, unit2, capability, linkTypes,
							DeployValidatorService.MATCHER_DEPTH_ALL).isOK()) {
						LinkDescriptor[] links = dvs.getPossibleLinks(unit1, requirement, unit2,
								capability, linkTypes, DeployValidatorService.MATCHER_DEPTH_NONE);
						allPossibleLinks.addAll(Arrays.asList(links));
					}
				}
			} finally {
				setCursor(Cursors.ARROW);
			}
			LinkDescriptor[] allPossibleLinkz = new LinkDescriptor[allPossibleLinks.size()];
			allPossibleLinks.toArray(allPossibleLinkz);
			List userSelections = null;
			if (canPromptCreateMatches()) {
				userSelections = getUserSelections(srcEP, null, allPossibleLinkz);
			} else {
				userSelections = getUserSelections(unit1, allPossibleLinkz);
			}

			srcEP.getViewer().reveal(srcEP);
			srcEP.getViewer().select(srcEP);
			if (userSelections != null) {
				LinkDescriptor[] selectedLinkz = new LinkDescriptor[userSelections.size()];
				userSelections.toArray(selectedLinkz);
				createLinks(userSelections);
			} else {
				return true;
			}
		}
		return false;
	}

	@Override
	protected void eraseSourceFeedback() {
		setAvoidDeactivation(false);
		super.eraseSourceFeedback();
	}

	protected void setupScribblerParameters(EObject obj, IDataModel model) {
		IProject project = WorkbenchResourceHelper.getProject(obj.eResource());
		IFile file = WorkbenchResourceHelper.getFile(obj.eResource());
		model.setProperty(IAbstractScribblerDataModelProperties.EDIT_MODEL_LABEL,
				DeploymentTopologyDomain.generateEditModelLabel(file));
		model.setProperty(IAbstractScribblerDataModelProperties.SCRIBBLER_DOMAINS,
				new IScribblerDomain[] { new DeploymentTopologyDomain(file) });
		model.setProperty(IAbstractScribblerDataModelProperties.PROJECT_NAME, project.getName());
	}

	/*
	 * creates every link to every duplicate view
	 */
	protected void createLinks(List<LinkDescriptor> descriptorList) {
		// for every link the user chose to create from dialog
		int i = 0;
		Command command = null;
		List<DeployShapeNodeEditPart> toggleList = new ArrayList<DeployShapeNodeEditPart>();
		for (Iterator<LinkDescriptor> it = descriptorList.iterator(); it.hasNext(); i++) {

			// setup for creation of this link type (hosting, etc)
			LinkDescriptor descriptor = it.next();
			IElementType elementType = getElementType(descriptor);
			if (elementType == null) {
				continue;
			}
			setSemanticRequestType(elementType);

			// get all sources and targets for this link
			List<DeployShapeNodeEditPart> srcList = getSourceList(descriptor);
			List<DeployShapeNodeEditPart> tgtList = getTargetList(descriptor);

			// collect all the possible duplicate links
			List<FilterLinkData> potentialList = new ArrayList<FilterLinkData>();
			for (Iterator<DeployShapeNodeEditPart> srcIt = srcList.iterator(); srcIt.hasNext();) {
				DeployShapeNodeEditPart srcEP = srcIt.next();
				for (Iterator<DeployShapeNodeEditPart> tgtIt = tgtList.iterator(); tgtIt.hasNext();) {
					DeployShapeNodeEditPart tgtEP = tgtIt.next();
					potentialList.add(new FilterLinkData(srcEP, tgtEP, null));
				}
			}

			// add the canonical toggle commands to prevent view refresh until all link views are created
			if (command != null) {
				command = command.chain(DeployToggleCanonicalModeCommand.getToggleCanonicalModeCommand(
						srcList, true, false, false));
			} else {
				command = DeployToggleCanonicalModeCommand.getToggleCanonicalModeCommand(srcList, true,
						false, false);
			}

			if (command != null) {
				command = command.chain(DeployToggleCanonicalModeCommand.getToggleCanonicalModeCommand(
						tgtList, true, false, false));
			} else {
				command = DeployToggleCanonicalModeCommand.getToggleCanonicalModeCommand(tgtList, true,
						false, false);
			}

			toggleList.addAll(srcList);
			toggleList.addAll(tgtList);

			// if there are duplicate links, optionally filter out the secondary duplicate links
			if (potentialList.size() > 1) {
				IPreferenceStore store = DeployCoreUIPlugin.getDefault().getPreferenceStore();
				if (store.getBoolean(IDeployPreferences.DEPLOY_FILTER_SECONDARY_DUP_LINKS)) {
					FilteringUtils.filterDupLinks(potentialList, null);
				}
			}

			// now create the filtered links commands		
			Map<LinkDescriptor, DeployModelObject> linkResultMap = new HashMap<LinkDescriptor, DeployModelObject>();
			for (Iterator<FilterLinkData> itFiltered = potentialList.iterator(); itFiltered.hasNext();) {
				FilterLinkData filterData = itFiltered.next();

				Command cmd = getCreateConnection(filterData.getSource(), filterData.getTarget(),
						descriptor, linkResultMap);
				if (cmd != null && cmd.canExecute()) {
					if (command != null) {
						command = command.chain(cmd);
					} else {
						command = cmd;
					}
					command.setLabel(cmd.getLabel());
				}
			}
		}

		// now execute the command and select the new objects
		if (command != null) {
			// re-enable the the canonical policies
			command = command.chain(DeployToggleCanonicalModeCommand.getToggleCanonicalModeCommand(
					toggleList, true, true, false));
			setCurrentCommand(command);
			executeCurrentCommand();
			selectAddedObject(getViewer(), DiagramCommandStack.getReturnValues(command));
		}

		setAvoidDeactivation(false);
		eraseSourceFeedback();
		deactivate();
	}

	protected Command getCreateConnection(IGraphicalEditPart sourceEditPart,
			IGraphicalEditPart targetEditPart, LinkDescriptor descriptor,
			Map<LinkDescriptor, DeployModelObject> linkResultMap) {

		CreateConnectionRequest connectionRequest = (CreateConnectionRequest) createTargetRequest();

		connectionRequest.setTargetEditPart(sourceEditPart);
		connectionRequest.setType(org.eclipse.gef.RequestConstants.REQ_CONNECTION_START);
		connectionRequest.setLocation(new Point(0, 0));

		// only if the connection is supported will we get a non null
		// command from the sourceEditPart
		if (sourceEditPart.getCommand(connectionRequest) != null) {

			connectionRequest.setSourceEditPart(sourceEditPart);
			connectionRequest.setTargetEditPart(targetEditPart);
			connectionRequest.setType(org.eclipse.gef.RequestConstants.REQ_CONNECTION_END);
			connectionRequest.setLocation(new Point(0, 0));
			connectionRequest.getExtendedData().put(DESCRIPTOR, descriptor);
			connectionRequest.getExtendedData().put(LINKRESULTMAP, linkResultMap);

			return targetEditPart.getCommand(connectionRequest);
		}
		return null;

	}

	private IElementType getElementType(LinkDescriptor descriptor) {
		LinkType[] linkTypes = getLinkTypes();
		IElementType[] semanticTypes = getSemanticTypes();
		for (int i = 0; i < linkTypes.length; i++) {
			if (descriptor.getType() == linkTypes[i]) {
				return semanticTypes[i];
			}
		}
		return null;
	}

	protected EditPartViewer getViewer() {
		return _viewer;
	}

	protected boolean isModelReversed() {
		return false;
	}

	abstract protected List<DeployShapeNodeEditPart> getSourceList(LinkDescriptor link);

	abstract protected List<DeployShapeNodeEditPart> getTargetList(LinkDescriptor link);

	abstract protected List<List<DeployShapeNodeEditPart>> getTargetLists(LinkDescriptor[] link);

	abstract protected List getUserSelections(Unit srcUnit, LinkDescriptor[] links);

	// next two methods used by createdependencylink dialog to create matches
	protected boolean canPromptCreateMatches() {
		return false;
	}

	protected List getUserSelections(EditPart srcEP, EditPart tgtEP, LinkDescriptor[] links) {
		return Collections.EMPTY_LIST;
	}

	abstract protected LinkType[] getLinkTypes();

	abstract protected IElementType[] getSemanticTypes();

	protected List<LinkDescriptor> promptForConceptualNodeLinks(Unit srcUnit, Unit targetUnit,
			org.eclipse.swt.graphics.Point point, LinkDescriptor[] linkDescriptors) {
		// default to normal link creation
		// dependency link overrides to get communictaion artifacts
		return getUserSelections(srcUnit, linkDescriptors);
	}

}
