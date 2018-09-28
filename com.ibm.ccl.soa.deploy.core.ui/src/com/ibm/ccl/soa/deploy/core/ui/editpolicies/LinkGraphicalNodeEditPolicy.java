/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.editpolicies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.Connection;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.DropRequest;
import org.eclipse.gef.requests.LocationRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SemanticCreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest.ConnectionViewAndElementDescriptor;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.HostingLinkEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.IFeedbackEditPart;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.DeployTransactionalCommand;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.ui.requests.RequestConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.CanonicalUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployColorConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;

/**
 * Customize how link is drawn when creating it Also provides color feedback on units when creating
 * links
 * 
 * @since 1.0
 * 
 */
public class LinkGraphicalNodeEditPolicy extends GraphicalNodeEditPolicy implements EditPolicy,
		RequestConstants {

	private final class CreateNestConfigUnitViewCommand extends DeployTransactionalCommand {
		private final Unit serverUnit;
		private final boolean isConstraintLink;
		private final CreateRelationshipRequest createElementRequest;
		private final Command viewCommand;
		private final View configView;
		private final Unit configUnit;
		private final View serverView;

		private CreateNestConfigUnitViewCommand(TransactionalEditingDomain domain, Unit aServerUnit,
				boolean isConstraint, CreateRelationshipRequest aRequest, Command viewCmd,
				View aConfigView, Unit aConfigUnit, View aServerView) {
			super(domain, "", getWorkspaceFiles(aServerView)); //$NON-NLS-1$
			serverUnit = aServerUnit;
			isConstraintLink = isConstraint;
			createElementRequest = aRequest;
			viewCommand = viewCmd;
			configView = aConfigView;
			configUnit = aConfigUnit;
			serverView = aServerView;
		}

		protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) {

			// if not creating a deferred hosting link, just create the view
			if (isConstraintLink && !GMFUtils.isHostingLink(createElementRequest.getNewElement())) {
				viewCommand.execute();
			} else {

				// expand target's hosting list
				View hostingListView = ViewUtil.getChildBySemanticHint(serverView,
						DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
				ViewUtil.setStructuralFeatureValue(hostingListView, NotationPackage.eINSTANCE
						.getDrawerStyle_Collapsed(), new Boolean(false));

				// create new view in target's hosting list view
				DeployDiagramEditPart diagramEP = GMFUtils.getDeployDiagramEditPart(getHost());
				ViewService.getInstance().createNode(new EObjectAdapter(configUnit), hostingListView,
						configView.getType(), ViewUtil.APPEND, true,
						diagramEP.getDiagramPreferencesHint());

				// if the server is no longer visible because of a link cycle problem, create a new server view on the canvas
				GMFUtils.createDupViewForLinkCycleProblem(getEditingDomain(), diagramEP, serverUnit);

				// delete source view
				// if this is duplicate view, original config unit view has already been deleted
				// only delete if on canvas-- else it's contained and we are creating a dup view in list
				if (configView.eContainer() instanceof Diagram) {
					ViewUtil.destroy(configView);
				}
			}

			return CommandResult.newOKCommandResult();
		}
	}

	protected List sourcefeedback = new ArrayList();

	protected List targetfeedback = new ArrayList();

	private boolean initialized;

	private IFeedbackEditPart source;

	protected static final int Q = MapModeUtil.getMapMode().DPtoLP(1);

	/**
	 * when creating a hosting link from a config unit to a server we remove the config unit view and
	 * add it to the server's hosting list view
	 */
	protected Command getConnectionAndRelationshipCompleteCommand(
			CreateConnectionViewAndElementRequest request) {

		// get the element descriptor
		CreateElementRequestAdapter requestAdapter = request.getConnectionViewAndElementDescriptor()
				.getCreateElementRequestAdapter();
		// get the semantic request
		final CreateRelationshipRequest createElementRequest = (CreateRelationshipRequest) requestAdapter
				.getAdapter(CreateRelationshipRequest.class);

		createElementRequest.setPrompt(!request.isUISupressed());

		// complete the semantic request by filling in the source and
		// destination
		final EditPart sourceEP = request.getSourceEditPart();
		final INodeEditPart targetEP = getConnectionCompleteEditPart(request);
		View sourceView = (View) sourceEP.getModel();
		View targetView = (View) targetEP.getModel();

		// resolve the source
		EObject source = ViewUtil.resolveSemanticElement(sourceView);
		if (source == null) {
			source = sourceView;
		}
		createElementRequest.setSource(source);

		// resolve the target
		EObject target = ViewUtil.resolveSemanticElement(targetView);
		if (target == null) {
			target = targetView;
		}
		createElementRequest.setTarget(target);

		/*
		 * create the semantic command to create the model link (CreateHostingLinkCommand)
		 */
		Command createElementCommand = targetEP.getCommand(new EditCommandRequestWrapper(
				(CreateRelationshipRequest) requestAdapter.getAdapter(CreateRelationshipRequest.class),
				request.getExtendedData()));
		if (null == createElementCommand) {
			return null;
		}
		SemanticCreateCommand semanticCommand = new SemanticCreateCommand(requestAdapter,
				createElementCommand);
		CompositeCommand cc = new CompositeCommand(semanticCommand.getLabel());
		cc.compose(semanticCommand);

		/*
		 * MOVES CONFIG UNIT INTO A TREE LIST WHEN A HOSTING LINK IS CREATED
		 */
		final Command viewCommand = getConnectionCompleteCommand(request);
		String hint = getSemanticHint(createElementRequest);
		final boolean isConstraintLink = hint.equals(DeployCoreConstants.CONSTRAINTLINK_SEMANTICHINT);
		// don't do it if it's a proxy from an import
		if ((hint.equals(DeployCoreConstants.HOSTINGLINK_SEMANTICHINT) || isConstraintLink)
				&& source instanceof Unit && !PropertyUtils.isProxy((DeployModelObject) source)
				&& target instanceof Unit && ((Unit) source).isConfigurationUnit()) {
			TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
					.getEditingDomain();
			/*
			 * move the config unit view to the server's hosting list
			 */
			final Unit configUnit = (Unit) source;
			final View configView = sourceView;
			final View serverView = targetView;
			final Unit serverUnit = (Unit) target;
			cc.compose(new CreateNestConfigUnitViewCommand(editingDomain, serverUnit,
					isConstraintLink, createElementRequest, viewCommand, configView, configUnit,
					serverView));
		} else {
			/*
			 * else create the normal link view command
			 */
			if (null == viewCommand) {
				return null;
			}
			// form the compound command and return
			cc.compose(new CommandProxy(viewCommand));
		}
		return new ICommandProxy(cc);
	}

	protected String getSemanticHint(CreateRelationshipRequest createElementRequest) {
		String semanticHint = null;
		if (createElementRequest.getElementType() != null) {
			semanticHint = ((IHintedType) createElementRequest.getElementType()).getSemanticHint();
		}
		return semanticHint;
	}

	/**
	 * create drag link between units
	 */
	protected Connection createDummyConnection(Request req) {

		Color color = getLinkColor(req);
		EditorPolylineConnection conn = new EditorPolylineConnection(color, null);

		return conn;
	}

	private Color getLinkColor(Request req) {
		String semanticHint = ""; //$NON-NLS-1$
		if (req instanceof CreateConnectionViewAndElementRequest) {
			CreateConnectionViewAndElementRequest request = (CreateConnectionViewAndElementRequest) req;
			ConnectionViewAndElementDescriptor desc = request.getConnectionViewAndElementDescriptor();
			semanticHint = desc.getSemanticHint();
		}
		Color color = null;
		if (semanticHint.equals(DeployCoreConstants.HOSTINGLINK_SEMANTICHINT)) {
			color = DeployColorConstants.hostingLinkColor;
		} else if (semanticHint.equals(DeployCoreConstants.REALIZATIONLINK_SEMANTICHINT)) {
			color = DeployColorConstants.realizationLinkInner;
		} else {
			color = DeployColorConstants.dependencyLinkColor;
		}
		return color;
	}

	protected void eraseCreationFeedback(CreateConnectionRequest request) {
		super.eraseCreationFeedback(request);

		if (source != null) {
			source.setFeedbackState(REQ_NONE);
			source = null;
		}

		for (int i = 0; i < sourcefeedback.size(); i++) {
			IFeedbackEditPart ep = (IFeedbackEditPart) sourcefeedback.get(i);
			if (ep != null) {
				ep.setFeedbackState(REQ_NONE);
			}
		}
		sourcefeedback.clear();

		initialized = false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#eraseTargetConnectionFeedback(org.eclipse.gef.requests.DropRequest)
	 */
	protected void eraseTargetConnectionFeedback(DropRequest request) {
		super.eraseTargetConnectionFeedback(request);

		for (int i = 0; i < targetfeedback.size(); i++) {
			IFeedbackEditPart ep = (IFeedbackEditPart) targetfeedback.get(i);
			if (ep != null) {
				ep.setFeedbackState(REQ_NONE);
			}
		}
		targetfeedback.clear();
	}

	/**
	 * @param request
	 *           Request for the policy
	 */
	protected void showTargetConnectionFeedback(DropRequest dropRequest) {

		Request request = (Request) dropRequest;
		if (REQ_CONNECTION_START.equals(request.getType())) {
			eraseSourceFeedback(request);
		}

		if (getHost() instanceof IFeedbackEditPart && !targetfeedback.contains(getHost())) {
			targetfeedback.add(getHost());
		}

		for (int i = 0; i < targetfeedback.size(); i++) {
			IFeedbackEditPart ep = (IFeedbackEditPart) targetfeedback.get(i);

			if (REQ_CONNECTION_START.equals(request.getType())) {
				ep.setFeedbackState(REQ_HOVER);
			} else if (REQ_CONNECTION_END.equals(request.getType())
					&& REQ_TARGET.equals(ep.getFeedbackState())) {
				ep.setFeedbackState(REQ_TARGET_HOVER);
			} else if (REQ_RECONNECT_SOURCE.equals(request.getType())

			&& REQ_TARGET.equals(ep.getFeedbackState())) {
				ep.setFeedbackState(REQ_TARGET_HOVER);
			} else if (REQ_RECONNECT_TARGET.equals(request.getType())
					&& REQ_TARGET.equals(ep.getFeedbackState())) {
				ep.setFeedbackState(REQ_TARGET_HOVER);
			}
		}

	}

	public void showTargetFeedback(Request request) {
		if (!(request instanceof LocationRequest)) {
			return;
		}
		if (REQ_SELECTION.equals(request.getType()) || REQ_SELECTION_HOVER.equals(request.getType())) {
			CreateConnectionRequest req = new CreateConnectionRequest();
			req.setType(org.eclipse.gef.RequestConstants.REQ_CONNECTION_START);
			req.setTargetEditPart(getHost());

			//	if (getHost().getCommand(req) != null)
			super.showTargetFeedback(req);
		} else {
			super.showTargetFeedback(request);
		}
	}

	public void eraseTargetFeedback(Request request) {
		if (!(request instanceof LocationRequest)) {
			return;
		}
		if (REQ_SELECTION.equals(request.getType()) || REQ_SELECTION_HOVER.equals(request.getType())) {
			CreateConnectionRequest req = new CreateConnectionRequest();
			req.setType(org.eclipse.gef.RequestConstants.REQ_CONNECTION_START);
			req.setTargetEditPart(getHost());

			//	if (getHost().getCommand(req) != null)
			super.eraseTargetFeedback(req);
		} else {
			super.eraseTargetFeedback(request);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#showCreationFeedback(org.eclipse.gef.requests.CreateConnectionRequest)
	 */
	protected void showCreationFeedback(CreateConnectionRequest request) {
		super.showCreationFeedback(request);

		if (!initialized) {
			eraseTargetFeedback(request);

			if (request.getSourceEditPart() instanceof IFeedbackEditPart) {
				source = (IFeedbackEditPart) request.getSourceEditPart();
			}

			initialized = true;
		}

		if (source != null) {
			source.setFeedbackState(REQ_SELECTED, getLinkColor(request));
		}

		for (int i = 0; i < sourcefeedback.size(); i++) {
			IFeedbackEditPart ep = (IFeedbackEditPart) sourcefeedback.get(i);
			if (ep != null) {
				ep.setFeedbackState(REQ_TARGET);
			}
		}
	}

	// let the canonical edit policies fill in the links after a reorientation
	protected Command getReconnectSourceCommand(ReconnectRequest request) {
		return request.getConnectionEditPart() instanceof HostingLinkEditPart ? null
				: refreshEndpoints(super.getReconnectSourceCommand(request), request);
	}

	protected Command getReconnectTargetCommand(ReconnectRequest request) {
		return request.getConnectionEditPart() instanceof HostingLinkEditPart ? null
				: refreshEndpoints(super.getReconnectTargetCommand(request), request);
	}

	private Command refreshEndpoints(Command reorientCmd, final ReconnectRequest request) {
		CompositeCommand cc = new CompositeCommand(reorientCmd.getLabel());
		cc.compose(new CommandProxy(reorientCmd));
		cc.compose(new AbstractTransactionalCommand(((IGraphicalEditPart) getHost())
				.getEditingDomain(), "refresh endpoints", null) { //$NON-NLS-1$
					protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor,
							IAdaptable info) {
						Display.getDefault().asyncExec(new Runnable() {
							public void run() {
								CanonicalUtils.refresh((IGraphicalEditPart) request.getTarget(), false);
								if (request.getConnectionEditPart().getSource() != null) {
									CanonicalUtils.refresh((IGraphicalEditPart) request
											.getConnectionEditPart().getSource(), false);
								}
								if (request.getConnectionEditPart().getTarget() != null) {
									CanonicalUtils.refresh((IGraphicalEditPart) request
											.getConnectionEditPart().getTarget(), false);
								}
							}
						});
						return CommandResult.newOKCommandResult();
					}
				});
		return new ICommandProxy(cc);
	}
}
