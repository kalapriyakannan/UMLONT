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
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.EditHelperContext;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.DiagramImpl;
import org.eclipse.jface.util.Assert;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.TopologyEditPart;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;
import com.ibm.ccl.soa.deploy.core.ui.providers.DeployCoreViewProvider;
import com.ibm.ccl.soa.deploy.core.ui.tools.common.CreationToolWithFeedback;
import com.ibm.ccl.soa.deploy.core.ui.util.ContainmentStateUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GEFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.IUnitElementType;
import com.ibm.ccl.soa.deploy.core.ui.util.ResolutionUIUtils;
import com.ibm.ccl.soa.infrastructure.emf.WorkbenchResourceHelper;

/**
 * @since 1.0
 * 
 */
public class DeployCreateElementAndViewCommand extends DeployTransactionalCommand {

	protected CreateViewAndElementRequest cveRequest = null;
	protected CreateElementRequest ceRequest = null;
	protected Point point = null;
	protected int containerType = DIAGRAM_CONTAINER;
	protected String semanticHint;
	protected List viewDescriptors = null;
	protected EditPart hostEP = null;
	protected DeployDiagramEditPart diagramEP = null;
	protected View containerView = null;
	private static Map adviceMap = new HashMap();
	public static String CREATEDROOTVIEWS = "createdRootViews"; //$NON-NLS-1$
	private boolean _isCreatingShapeContainer = false;

	/**
	 * creating element in diagram
	 */
	public static final int DIAGRAM_CONTAINER = 0;
	/**
	 * creating element in list or shape container
	 */
	public static final int HYBRID_SHAPE_CONTAINER = 1;
	/**
	 * creating element in hybrid list (a root list that contains members and hostees)
	 */
	public static final int HYBRID_LIST_CONTAINER = 2;

	/**
	 * @param editingDomain
	 * @param point
	 * @param isCreatingGroup --
	 *           are we creating a group -- used to determine if command should aquire overlapped
	 *           figures
	 * @param containerType --
	 *           where are we creating this unit (diagram, group, hosting list, conceptual node)
	 * @param semanticHint
	 * @param cveRequest
	 * @param ceRequest
	 * @param hostEP
	 * @param containerView
	 * @param viewDescriptors
	 */
	public DeployCreateElementAndViewCommand(TransactionalEditingDomain editingDomain, Point point,
			int containerType, String semanticHint, CreateViewAndElementRequest cveRequest,
			CreateElementRequest ceRequest, EditPart hostEP, View containerView) {

		super(editingDomain, DiagramUIMessages.CreateCommand_Label,
				getAllWorkspaceFiles(containerView));

		Assert.isNotNull(point);
		Assert.isNotNull(cveRequest);
		Assert.isNotNull(ceRequest);
		Assert.isNotNull(hostEP);

		this.point = point.getCopy();

		// adjust point if diagram is scrolled
		diagramEP = GMFUtils.getDeployDiagramEditPart(hostEP);
		IFigure diagramFigure = diagramEP.getFigure();
		diagramFigure.translateToRelative(this.point);
		diagramFigure.translateFromParent(this.point);

		this.containerType = containerType;
		this.semanticHint = semanticHint;
		this.cveRequest = cveRequest;
		this.ceRequest = ceRequest;
		this.hostEP = hostEP;
		this.containerView = containerView;

		// adjust point if add to a group
		if (containerType == HYBRID_SHAPE_CONTAINER) {
			translateToGroupContainer(this.point, (TopologyEditPart) hostEP.getParent());
		}

		IElementType type = ceRequest.getElementType();
		this.setLabel(Messages.CREATE + " " + type.getDisplayName()); //$NON-NLS-1$

		setResult(CommandResult.newOKCommandResult(ceRequest));
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException {
		// have ResolutionUtils do the element creation and return the elements added to the topology
		IElementType type = ceRequest.getElementType();
		if (!(type instanceof IUnitElementType)) {
			return CommandResult.newErrorCommandResult("Wrong Element Type"); //$NON-NLS-1$
		}
		DiagramImpl diagram = (DiagramImpl) ceRequest.getContainer();
		Topology topology = (Topology) diagram.getElement();

		// create template objects in topology and get the root elements, hosting links and member links
		Collection<Unit> rootElements = new ArrayList<Unit>();
		Collection<HostingLink> newHostingLinks = new ArrayList<HostingLink>();
		Collection<MemberLink> newMemberLinks = new ArrayList<MemberLink>();
		String templateURI = ResolutionUIUtils.getTemplateURI(type);
		String templateVUri = ResolutionUIUtils.getTemplateVURI(type);

		// if unit template also has a topologyv file, create the units and views using that file
		if (templateVUri != null) {
			URI uri = org.eclipse.emf.common.util.URI.createURI(templateVUri);
			IFile platformFile = WorkbenchResourceHelper.getPlatformFile(uri);
			if (platformFile != null && platformFile.isAccessible()) {
				com.ibm.ccl.soa.deploy.core.ui.util.ViewUtil.copyTemplateElementsAndViews(templateURI,
						templateVUri, containerView, diagramEP, point);
				return CommandResult.newOKCommandResult();
			}
		}

		boolean isDynamic = ExtensionsCore.createResourceTypeService().isDynamicPaletteEntry(
				type.getId());
		Collection<Unit> newObjects = GMFUtils.createElements(templateURI, topology, rootElements,
				newHostingLinks, newMemberLinks, diagramEP, isDynamic);

		// if multiple element creation, loop to create other elements
		Dimension multiElements = CreationToolWithFeedback.getMultiElementSize();
		if (multiElements != null) {
			newObjects = new ArrayList<Unit>(newObjects);
			int totalUnits = multiElements.width * multiElements.height - 1;
			for (int i = 0; i < totalUnits; i++) {
				newObjects.addAll(GMFUtils.createElements(templateURI, topology, rootElements,
						newHostingLinks, newMemberLinks, diagramEP, isDynamic));
			}
		}

		// determine if we are creating a shape container
		_isCreatingShapeContainer = rootElements.size() == 1
				&& CreationToolWithFeedback.getLassoBounds() != null;

		// create the root views
		// if the user dragged the cursor when creating the unit, we are always creating a shape container
		if (_isCreatingShapeContainer) {
			DeployCoreViewProvider.setOverridePreference(DeployCoreViewProvider.FORCE_SHAPES);
		}
		List<View> createdRootViews = new ArrayList<View>();
		viewDescriptors = createRootViews(rootElements, createdRootViews, _isCreatingShapeContainer,
				multiElements);
		DeployCoreViewProvider.setOverridePreference(0);
		cveRequest.getExtendedData().put(CREATEDROOTVIEWS, createdRootViews);

		// get the hosting links to just config units (needed for createAttachedViews())
		// (hosting links to non config units not need because they exist in the diagram/group and were created by createRootViews()) 
		List configHostingLinks = new ArrayList();
		for (Iterator itHost = newHostingLinks.iterator(); itHost.hasNext();) {
			HostingLink link = (HostingLink) itHost.next();
			if (link.getHosted() != null && link.getHosted().isConfigurationUnit()) {
				configHostingLinks.add(link);
			}
		}

		// now add any remaining attached views onto root views using links as the guide 
		int failsafe = 0;
		List<View> createdViews = new ArrayList<View>(createdRootViews);
		while ((newHostingLinks.size() > 0 || newMemberLinks.size() > 0) && createdViews.size() > 0
				&& failsafe++ < 10) {
			createdViews = createAttachedViews(createdViews, configHostingLinks, newMemberLinks);
		}

		// if we are creating a single group unit, add any views that were overlapped by the 
		// group tool as members to this group
		Shell parentShell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		if (_isCreatingShapeContainer) {
			CommandResult result = aquireOverlappedUnits(newObjects, monitor, info);
			if (result.getStatus().getCode() != IStatus.OK) {
				MessageBox msgBox = new MessageBox(parentShell, SWT.ICON_ERROR);
				msgBox.setText(Messages.CREATION_FAILURE);
				msgBox
						.setMessage(Messages.DeployCreateElementAndViewCommand_Could_not_contain_these_units_as_me_);
				msgBox.open();
				throw new ExecutionException("couldn't aquire members" + result.toString()); //$NON-NLS-1$
			}
			// expand it too
			if (createdRootViews.size() == 1) {
				View view = createdRootViews.get(0);
				View areaView = ViewUtil.getChildBySemanticHint(view,
						DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
				DeployStyle style = (DeployStyle) view.getStyle(DeployNotationPackage.eINSTANCE
						.getDeployStyle());
				if (areaView != null && style != null) {
					Rectangle size = CreationToolWithFeedback.getLassoBounds().getCopy();
					style.setCollapseWidth(size.width);
					style.setExpandWidth(size.width);
					style.setExpandHeight(size.height);
					ViewUtil.setStructuralFeatureValue(areaView, NotationPackage.eINSTANCE
							.getDrawerStyle_Collapsed(), new Boolean(false));
				}
			}
		}

		// if we are creating our new objects inside of a container, add a memberlink or hostinglink from each root unit to the host unit
		if (containerType == HYBRID_SHAPE_CONTAINER || containerType == HYBRID_LIST_CONTAINER) {
			Map<Unit, Object> linksCreatedMap = new HashMap<Unit, Object>();
			CommandResult result = createMemberOrHostingLinks(rootElements, newObjects,
					newHostingLinks, linksCreatedMap, monitor, info);
			if (result.getStatus().getCode() != IStatus.OK) {
				MessageBox msgBox = new MessageBox(parentShell, SWT.ICON_ERROR);
				msgBox.setText(Messages.CREATION_FAILURE);
				msgBox
						.setMessage(Messages.DeployCreateElementAndViewCommand_Could_not_create_membership_or_host_);
				msgBox.open();
				throw new ExecutionException("couldn't create hosting/member links" + result.toString()); //$NON-NLS-1$
			} else {
				//if a hosting link was created for one or more root units, mark it as contained
				for (Iterator<View> it = createdRootViews.iterator(); it.hasNext();) {
					View view = it.next();
					EObject eo = view.getElement();
					if (rootElements.contains(eo)) {
						Object o = linksCreatedMap.get(eo);
						if (o instanceof HostingLink) {
							ContainmentStateUtils.setContainedUnitState(view, true);
						}
					}
				}

			}
		}

		// execute post edit helpers if any 
		IEditHelperAdvice[] advices = (IEditHelperAdvice[]) adviceMap.get(type);
		if (advices == null) {
			Object editHelperContext = new EditHelperContext(type, ceRequest.getClientContext());
			advices = ElementTypeRegistry.getInstance().getEditHelperAdvice(editHelperContext);
			if (advices != null) {
				adviceMap.put(type, advices);
			}
		}
		if (advices != null) {
			class NewObjectInfo implements IAdaptable {
				Collection newObjects1;

				NewObjectInfo(Collection newObjects) {
					newObjects1 = newObjects;
				}

				public Object getAdapter(Class adapter) {
					if (adapter == Collection.class) {
						return newObjects1;
					}
					return null;
				}
			}
			for (int i = 0; i < advices.length; i++) {
				IEditHelperAdvice nextAdvice = advices[i];
				ICommand afterAdvice = nextAdvice.getAfterEditCommand(ceRequest);
				if (afterAdvice != null && afterAdvice.canExecute()) {
					afterAdvice.execute(new NullProgressMonitor(), new NewObjectInfo(newObjects));
				}
			}
		}

		/*
		 * next we arrange the canvas/group around the new items-- no need to arrange if creating
		 * multi elements since they are already created in a grid
		 */
		if (multiElements == null) {
			DeployDeferredLayoutCommand arrangeCommand = new DeployDeferredLayoutCommand(diagramEP
					.getEditingDomain(), viewDescriptors, diagramEP, hostEP, null, false, false);
			if (arrangeCommand.canExecute()) {
				arrangeCommand.execute(new NullProgressMonitor(), null);
			}
		}

		// edit policies will fill in the link views, if any
		return CommandResult.newOKCommandResult();
	}

	private CommandResult createMemberOrHostingLinks(Collection<Unit> rootElements,
			Collection<Unit> newObjects, Collection<HostingLink> newHostingLinks,
			Map<Unit, Object> linkCreatedMap, IProgressMonitor monitor, IAdaptable info) {
		// for each root element create a host link or member link
		int addedViews = 0;
		for (Iterator<Unit> it = rootElements.iterator(); it.hasNext();) {
			Unit unit = it.next();
			AbstractTransactionalCommand linkCommand = null;
			linkCommand = new CreateMemberOrHostingLinkCommand(getEditingDomain(), unit, containerView);
			if (linkCommand.canExecute()) {
				try {
					linkCommand.execute(monitor, info);
					CommandResult result = linkCommand.getCommandResult();
					if (result.getStatus().getSeverity() != IStatus.OK) {
						for (Iterator<Unit> it2 = newObjects.iterator(); it2.hasNext();) {
							EcoreUtil.remove(it2.next());
						}
						return CommandResult.newErrorCommandResult(result.getStatus().getMessage());
					} else {
						linkCreatedMap.put(unit, result.getReturnValue());
					}

				} catch (ExecutionException e) {
					return CommandResult.newErrorCommandResult(e.getMessage());
				}
				addedViews++;
			} else {
				return CommandResult.newErrorCommandResult(""); //$NON-NLS-1$
			}
		}

		// if something added to hosting list, make sure it's popped open
		if (addedViews > 0) {
			ViewUtil.setStructuralFeatureValue(containerView, NotationPackage.eINSTANCE
					.getDrawerStyle_Collapsed(), new Boolean(false));
		}

		return CommandResult.newOKCommandResult();
	}

	/*
	 * add member links to overlapped units
	 */
	private CommandResult aquireOverlappedUnits(Collection newObjects, IProgressMonitor monitor,
			IAdaptable info) {
		final List<View> lassoedViews = CreationToolWithFeedback.getLassoedViews(diagramEP,
				TopologyEditPart.class);
		if (lassoedViews.size() > 0) {
			AquireUnitsCommand aquireUnitsCommand = new AquireUnitsCommand(getEditingDomain(),
					(ViewDescriptor) viewDescriptors.get(0), lassoedViews, diagramEP, (View) diagramEP
							.getModel());
			if (aquireUnitsCommand.canExecute()) {
				try {
					aquireUnitsCommand.execute(monitor, info);
					CommandResult result = aquireUnitsCommand.getCommandResult();
					if (result.getStatus().getSeverity() != IStatus.OK) {
						for (Iterator it = newObjects.iterator(); it.hasNext();) {
							EcoreUtil.remove((EObject) it.next());
						}
						return CommandResult.newErrorCommandResult(result.getStatus().getMessage());
					}
				} catch (ExecutionException e) {
					return CommandResult.newErrorCommandResult(e.getMessage());
				}
			}
		}
		return CommandResult.newOKCommandResult();
	}

	/*
	 * add all the remaing new objects as attachment views, some may even create duplicate views
	 */
	private List createAttachedViews(List views, Collection newHostingLinks,
			Collection newMemberLinks) {

		List createdViews = new ArrayList();
		Map processedHostingLink = new HashMap();
		Map processedMemberLink = new HashMap();

		for (Iterator it = views.iterator(); it.hasNext();) {
			View view = (View) it.next();
			Unit unit = (Unit) view.getElement();

			// determine the container
			View containerView = ViewUtil.getChildBySemanticHint(view,
					DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
			if (containerView == null) {
				containerView = ViewUtil.getChildBySemanticHint(view,
						DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
			}
			int x = 0;
			int y = 0;
			int max = 1000000;
			if (CreationToolWithFeedback.getLassoBounds() != null) {
				max = CreationToolWithFeedback.getLassoBounds().width;
			}

			// iterate through newHostingLinks looking for config units hosted in this unit
			for (Iterator itHost = newHostingLinks.iterator(); itHost.hasNext();) {
				HostingLink link = (HostingLink) itHost.next();
				if (link.getHost() == unit && link.getHosted().isConfigurationUnit()) {
					Node newView = ViewService.getInstance().createNode(
							new EObjectAdapter(link.getHosted()), containerView,
							"", ViewUtil.APPEND, true, //$NON-NLS-1$
							diagramEP.getDiagramPreferencesHint());
					ViewUtil.setStructuralFeatureValue(newView, NotationPackage.eINSTANCE
							.getLocation_X(), new Integer(x));
					ViewUtil.setStructuralFeatureValue(newView, NotationPackage.eINSTANCE
							.getLocation_Y(), new Integer(y));
					createdViews.add(newView);
					x += DeployCoreConstants.SERVER_UNIT_WIDTH * 3 / 2;
					if (x + DeployCoreConstants.SERVER_UNIT_WIDTH > max) {
						x = 0;
						y += DeployCoreConstants.SERVER_UNIT_HEIGHT * 3 / 2;
					}
					processedHostingLink.put(link, null);
				}
			}

			// iterate through newMemberLinks looking for members of this unit
			for (Iterator itGroup = newMemberLinks.iterator(); itGroup.hasNext();) {
				MemberLink link = (MemberLink) itGroup.next();
				if (link.getSource() == unit) {
					Node newView = ViewService.getInstance().createNode(
							new EObjectAdapter(link.getTarget()), containerView,
							"", ViewUtil.APPEND, true, //$NON-NLS-1$
							diagramEP.getDiagramPreferencesHint());
					ViewUtil.setStructuralFeatureValue(newView, NotationPackage.eINSTANCE
							.getLocation_X(), new Integer(x));
					ViewUtil.setStructuralFeatureValue(newView, NotationPackage.eINSTANCE
							.getLocation_Y(), new Integer(y));
					createdViews.add(newView);
					x += DeployCoreConstants.SERVER_UNIT_WIDTH * 3 / 2;
					if (x + DeployCoreConstants.SERVER_UNIT_WIDTH > max) {
						x = 0;
						y += DeployCoreConstants.SERVER_UNIT_HEIGHT * 3 / 2;
					}
					processedMemberLink.put(link, null);
				}
			}
		}
		newHostingLinks.removeAll(processedHostingLink.keySet());
		newMemberLinks.removeAll(processedMemberLink.keySet());
		return createdViews;
	}

	/*
	 * get a container that's a group or the diagram
	 */
	private View getGroupOrDiagram() {
		EObject walker = containerView;
		while (walker != null) {
			if (walker instanceof View
					&& ((View) walker).getType() != null
					&& (((View) walker).getType().equals(DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT) || ((View) walker)
							.getType().equals(DeployCoreConstants.DEPLOY_CORE))) {
				return (View) walker;
			}
			walker = walker.eContainer();

		}
		return containerView;
	}

	/*
	 * create the root element views
	 */
	private List createRootViews(Collection rootElements, List<View> createdViews,
			boolean isCreatingShapeContainer, Dimension multiElements) {
		// create the view descritptors
		List viewDescriptors = new ArrayList();
		for (Iterator it = rootElements.iterator(); it.hasNext();) {
			viewDescriptors.add(new CreateViewRequest.ViewDescriptor(new EObjectAdapter((EObject) it
					.next()), Node.class, diagramEP.getDiagramPreferencesHint()));
		}

		// now create all the views 
		View containView = containerView;
		int x = point.x;
		int y = point.y;
		int col = 0;
		for (Iterator it = viewDescriptors.iterator(); it.hasNext();) {
			CreateViewRequest.ViewDescriptor viewDescriptor = (ViewDescriptor) it.next();

			containView = containerView;

			View newView = com.ibm.ccl.soa.deploy.core.ui.util.ViewUtil.createView(viewDescriptor
					.getViewKind(), viewDescriptor.getElementAdapter(), containView, viewDescriptor
					.getSemanticHint(), viewDescriptor.getIndex(), viewDescriptor.isPersisted(),
					viewDescriptor.getPreferencesHint());
			Assert.isNotNull(newView, "failed to create a view"); //$NON-NLS-1$
			viewDescriptor.setView(newView);
			createdViews.add(newView);
			// if we set it into this descriptor, DeploySetBoundsCommand will
			//  which follows this command in the command chain will position this
			// view-- however we will have already postioned this
			// view using LayoutUtils
//			if (viewDescriptors.size() == 1) {
//				cveRequest.getViewAndElementDescriptor().setView(newView);
//			}

			// stack all parts at same spot on canvas-- layout will arrange
			ViewUtil.setStructuralFeatureValue(newView, NotationPackage.eINSTANCE.getLocation_X(),
					new Integer(x));
			ViewUtil.setStructuralFeatureValue(newView, NotationPackage.eINSTANCE.getLocation_Y(),
					new Integer(y));
			// if creating a shape container, initialize to tool drag size
			if (isCreatingShapeContainer) {
				Rectangle size = CreationToolWithFeedback.getLassoBounds();
				ViewUtil.setStructuralFeatureValue(newView, NotationPackage.eINSTANCE.getSize_Width(),
						new Integer(size.width));
				ViewUtil.setStructuralFeatureValue(newView, NotationPackage.eINSTANCE.getSize_Height(),
						new Integer(size.height));
				// else if creating multiple elements, create in a nice grid
			} else if (multiElements != null) {
				x += DeployCoreConstants.SERVER_UNIT_WIDTH * 3 / 2;
				if (++col >= multiElements.width) {
					col = 0;
					x = point.x;
					y += DeployCoreConstants.SERVER_UNIT_HEIGHT * 3 / 2;
				}
			}
		}
		return viewDescriptors;
	}

	/**
	 * @param location
	 * @param editpart
	 */
	private void translateToGroupContainer(Point location, DeployShapeNodeEditPart editpart) {
		EditPart ep = editpart;
		while (ep != null && !(ep instanceof DeployDiagramEditPart)) {
			if (DeployShapeNodeEditPart.isShapesMode(ep)) {
				View groupView = (View) ((DeployShapeNodeEditPart) ep).getModel();
				location.x -= ((Integer) ViewUtil.getStructuralFeatureValue(groupView,
						NotationPackage.eINSTANCE.getLocation_X())).intValue();
				location.y -= ((Integer) ViewUtil.getStructuralFeatureValue(groupView,
						NotationPackage.eINSTANCE.getLocation_Y())).intValue();
				location.x -= DeployCoreConstants.SHAPES_UNIT_INSET;
				location.y -= GEFUtils.getShapesHeaderHeight(((IGraphicalEditPart) ep).getFigure());
			}
			ep = ep.getParent();
		}
	}

	public boolean canExecute() {
		return true;
	}

}
