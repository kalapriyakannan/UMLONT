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

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.Request;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.DropRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.NoteEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest.ConnectionViewAndElementDescriptor;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Rectangle;

import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.editparts.BusinessComponentEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ConstraintLinkEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DependencyLinkEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.HostingLinkEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.RealizationLinkEditPart;
import com.ibm.ccl.soa.deploy.core.ui.figures.ErrorFeedbackFigure;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.validator.DeployValidatorService;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkDescriptor;
import com.ibm.ccl.soa.deploy.core.validator.matcher.LinkType;

/**
 * Created on Oct 23, 2004
 * 
 * @author tonychau
 * 
 */
public class ShowConnectionErrorEditPolicy extends GraphicalEditPolicy {

	private static final IStatus NOT_A_VALID_UNIT_STATUS = DeployCoreUIPlugin.createErrorStatus(0,
			Messages.NOT_A_VALID_UNIT, null);

	private static final String NEW_LINE = "\n"; //$NON-NLS-1$

	protected ErrorFeedbackFigure feedback;

	protected IFigure getScaledFeedbackLayer() {
		return getLayer(LayerConstants.FEEDBACK_LAYER);
	}

	public void eraseTargetFeedback(Request request) {
		super.eraseTargetFeedback(request);
		eraseMessage();
	}

	@Override
	public void deactivate() {
		super.deactivate();
		eraseMessage();
	}

	private void eraseMessage() {
		if (feedback != null) {
			getScaledFeedbackLayer().remove(feedback);
			feedback = null;
		}
	}

	private IStatus isValidHostingStartPoint(DeployValidatorService dvs, GraphicalEditPart sourceEP) {
		EObject eObject = sourceEP.resolveSemanticElement();
		IStatus status = null;
		if (eObject instanceof Unit) {
			// MK
			//			status = dvs.canBeHosted((Unit)eObject);
			status = dvs.canBeLinkTarget((Unit) eObject, new LinkType[] { LinkType.HOSTING,
					LinkType.CONSTRAINT });
			if (!status.isOK()) {
				status = DeployCoreUIPlugin.createErrorStatus(0,
						Messages.UNIT_DOES_NOT_REQUIRE_HOSTING, null);
			}
		} else {
			status = DeployCoreUIPlugin.createErrorStatus(0, Messages.NOT_A_VALID_HOSTING_LINK_SOURCE,
					null);
		}
		return status;
	}

	private IStatus isValidRealizationStartPoint(DeployValidatorService dvs,
			GraphicalEditPart sourceEP) {
		EObject eObject = sourceEP.resolveSemanticElement();
		IStatus status = null;
		if (eObject instanceof Unit) {
			status = dvs.canBeLinkSource((Unit) eObject, new LinkType[] { LinkType.REALIZATION });
			if (!status.isOK()) {
				status = DeployCoreUIPlugin.createErrorStatus(0,
						Messages.ShowConnectionErrorEditPolicy_Unit_does_not_require_realizatio_, null);
			}
		} else {
			status = DeployCoreUIPlugin.createErrorStatus(0,
					Messages.ShowConnectionErrorEditPolicy_Not_a_valid_realization_sourc_, null);
		}
		return status;
	}

	private IStatus isValidServiceStartPoint(DeployValidatorService dvs, GraphicalEditPart sourceEP) {
		IStatus status = null;
		if (sourceEP instanceof DeployShapeNodeEditPart) {
			EObject eObject = sourceEP.resolveSemanticElement();
			if (eObject instanceof Unit) {
				Unit unit = (Unit) eObject;
				status = dvs.canBeLinkSource(unit, new LinkType[] { LinkType.DEPENDENCY,
						LinkType.CONSTRAINT });
				if (!status.isOK()) {
					status = DeployCoreUIPlugin.createErrorStatus(0,
							Messages.UNIT_DOES_NOT_CONSUME_SERVICES, null);
				}
			} else {
				status = DeployCoreUIPlugin.createErrorStatus(0,
						Messages.NOT_A_VALID_HOSTING_LINK_SOURCE, null);
			}
		}
		return status;
	}

	private IStatus isValidHostingEndPoint(DeployValidatorService dvs, GraphicalEditPart targetEP) {
		EObject eObject = targetEP.resolveSemanticElement();
		IStatus status = null;
		if (eObject instanceof Unit) {
			// MK
			//			status = dvs.canBeHostingLinkEndoint((Unit)eObject);
			status = dvs.canBeLinkEndpoint((Unit) eObject, new LinkType[] { LinkType.HOSTING,
					LinkType.CONSTRAINT }, DeployValidatorService.MATCHER_DEPTH_ALL);
			if (!status.isOK()) {
				status = DeployCoreUIPlugin.createErrorStatus(0, Messages.UNIT_IS_NOT_A_VALID_HOST,
						null);
			}
		} else {
			status = NOT_A_VALID_UNIT_STATUS;
		}
		return status;
	}

	private IStatus isValidRealizationEndPoint(DeployValidatorService dvs, GraphicalEditPart targetEP) {
		EObject eObject = targetEP.resolveSemanticElement();
		IStatus status = null;
		if (eObject instanceof Unit) {
			status = dvs.canBeLinkEndpoint((Unit) eObject, LinkType.REALIZATION_SET,
					DeployValidatorService.MATCHER_DEPTH_ALL);
			if (!status.isOK()) {
				status = DeployCoreUIPlugin.createErrorStatus(0,
						Messages.ShowConnectionErrorEditPolicy_Unit_does_not_realiz_, null);
			}
		} else {
			status = DeployCoreUIPlugin.createErrorStatus(0,
					Messages.ShowConnectionErrorEditPolicy_Not_a_valid_realization_targe_, null);
		}
		return status;
	}

	private IStatus isValidDependencyLinkEndPoint(DeployValidatorService dvs,
			GraphicalEditPart targetEP) {
		EObject eObject = targetEP.resolveSemanticElement();
		IStatus status = null;
		if (eObject instanceof Unit) {
			status = dvs.canBeLinkEndpoint((Unit) eObject, new LinkType[] { LinkType.DEPENDENCY,
					LinkType.CONSTRAINT }, DeployValidatorService.MATCHER_DEPTH_ALL);
			if (!status.isOK()) {
				status = DeployCoreUIPlugin.createErrorStatus(0,
						Messages.UNIT_DOES_NOT_PROVIDE_ANY_SERVICE, null);
			}
		} else {
			status = NOT_A_VALID_UNIT_STATUS;
		}
		return status;
	}

	private IStatus canCreateDependencyLink(DeployValidatorService dvs, GraphicalEditPart sourceEP,
			GraphicalEditPart targetEP) {
		IStatus status = null;

		if (sourceEP instanceof DeployShapeNodeEditPart
				&& targetEP instanceof DeployShapeNodeEditPart) {

			Unit sourceUnit = (Unit) sourceEP.resolveSemanticElement();
			Unit targetUnit = (Unit) targetEP.resolveSemanticElement();

			if (sourceUnit != null && targetUnit != null) {
				// MK
				//				status = dvs.canCreateDependencyLink( sourceUnit, targetUnit);
				//				status = dvs.canCreateLink( sourceUnit, targetUnit, LinkType.DEPENDENCY_SET);
				status = dvs.canCreateLink(sourceUnit, targetUnit, new LinkType[] {
						LinkType.DEPENDENCY, LinkType.CONSTRAINT },
						DeployValidatorService.MATCHER_DEPTH_ALL);
				if (!status.isOK()) {
					// WCA use status returned for message, if not OK				
					//					 status =   DeployCoreUIPlugin.createErrorStatus(0, Messages.SERVICE_LINK_CANNOT_BE_CREATED_BETWEEN_THE_UNITS, null); 
				}
			} else {
				status = NOT_A_VALID_UNIT_STATUS;
			}

		} else if (!(sourceEP instanceof NoteEditPart || targetEP instanceof NoteEditPart)) {
			status = DeployCoreUIPlugin.createErrorStatus(0, Messages.MATCH_NOT_FOUND, null);
		}

		return status;
	}

	private IStatus canCreateRealizationLink(DeployValidatorService dvs, GraphicalEditPart sourceEP,
			GraphicalEditPart targetEP) {
		IStatus status = null;

		if (sourceEP instanceof DeployShapeNodeEditPart
				&& targetEP instanceof DeployShapeNodeEditPart) {

			Unit sourceUnit = (Unit) sourceEP.resolveSemanticElement();
			Unit targetUnit = (Unit) targetEP.resolveSemanticElement();

			if (sourceUnit != null && targetUnit != null) {
				status = dvs.canCreateLink(sourceUnit, targetUnit, LinkType.REALIZATION_SET,
						DeployValidatorService.MATCHER_DEPTH_ALL);
			} else {
				status = NOT_A_VALID_UNIT_STATUS;
			}

		} else if (!(sourceEP instanceof NoteEditPart || targetEP instanceof NoteEditPart)) {
			status = DeployCoreUIPlugin.createErrorStatus(0, Messages.MATCH_NOT_FOUND, null);
		}

		return status;
	}

	private IStatus canCreateHostingLink(DeployValidatorService dvs, GraphicalEditPart sourceEP,
			GraphicalEditPart targetEP) {
		IStatus status = null;
		if (sourceEP instanceof DeployShapeNodeEditPart
				&& targetEP instanceof DeployShapeNodeEditPart) {
			Unit sourceUnit = (Unit) sourceEP.resolveSemanticElement();
			Unit targetUnit = (Unit) targetEP.resolveSemanticElement();

			status = canCreateHostingLink(dvs, sourceUnit, targetUnit);
		} else {
			DeployCoreUIPlugin.createErrorStatus(0, Messages.MATCH_NOT_FOUND, null);
		}
		return status;
	}

	private IStatus canCreateHostingLink(DeployValidatorService dvs, Unit sourceUnit, Unit targetUnit) {
		IStatus status;
		if (sourceUnit != null && targetUnit != null) {
			//MK 4/6/2005 switched order of inputs to be host, hostee
			// MK
			//				status = dvs.canCreateHostingLink( targetUnit, sourceUnit);
			status = dvs.canCreateLink(targetUnit, sourceUnit, new LinkType[] { LinkType.HOSTING,
					LinkType.CONSTRAINT }, DeployValidatorService.MATCHER_DEPTH_ALL);
			if (status.isOK()) {
				// need an additional test to make sure a host isn't hosted on a deployable
				// MK 4/6/2005 switched order of inputs to be host, hostee
				// MK
				//					LinkDescriptor [] hld = dvs.getPossibleHostingLinks(targetUnit, sourceUnit);
				LinkDescriptor[] hld = dvs
						.getPossibleLinks(targetUnit, sourceUnit, new LinkType[] { LinkType.HOSTING,
								LinkType.CONSTRAINT }, DeployValidatorService.MATCHER_DEPTH_ALL);
				// MK 8/24/2006 lets trust the matcher a little more :-)
				if (hld.length < 1) {// || hld[0].getTargetUnit() != sourceUnit || hld[0].getSourceUnit() != targetUnit ) {
					status = DeployCoreUIPlugin.createErrorStatus(0,
							Messages.HOSTING_LINK_CANNOT_BE_CREATED_BETWEEN_THE_UNITS, null);
				}
			} else {
				// WCA  use status returned for message, if not OK				
				// 					status =   DeployCoreUIPlugin.createErrorStatus(0, Messages.HOSTING_LINK_CANNOT_BE_CREATED_BETWEEN_THE_UNITS, null);
			}
		} else {
			status = NOT_A_VALID_UNIT_STATUS;
		}
		return status != null ? status : NOT_A_VALID_UNIT_STATUS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.EditPolicy#showTargetFeedback(org.eclipse.gef.Request)
	 */
	public void showTargetFeedback(Request request) {
		//  if (!PreferenceConstants.isAlways(PreferenceConstants.PREFERENCE_SHOW_INFO_ON_WIRING))
		// 	return;
		try {
			IStatus status = null;
			boolean doCanvasSearch = false;
			boolean doConstraintSearch = false;
			boolean doLinkMove = false;

			GraphicalEditPart sourceEP = null;
			GraphicalEditPart targetEP = null;
			DeployValidatorService dvs = DeployValidatorService.getDefaultValidatorService();

			if (isDeployLinkConnection(request)) {
				if (REQ_CONNECTION_START.equals(request.getType())) {

					sourceEP = (GraphicalEditPart) ((CreateConnectionRequest) request)
							.getTargetEditPart();

					if (sourceEP != null && !(sourceEP instanceof DeployDiagramEditPart)) {
						if (isHostingLinkConnection(request)) {
							status = isValidHostingStartPoint(dvs, sourceEP);
						} else if (isRealizationLinkConnection(request)) {
							status = isValidRealizationStartPoint(dvs, sourceEP);
						} else if (isConstraintLinkConnection(request)) {
							status = Status.OK_STATUS;
						} else {
							status = isValidServiceStartPoint(dvs, sourceEP);
						}
					}

				} else if (REQ_CONNECTION_END.equals(request.getType())) {

					sourceEP = (GraphicalEditPart) ((CreateConnectionRequest) request)
							.getSourceEditPart();
					targetEP = (GraphicalEditPart) ((CreateConnectionRequest) request)
							.getTargetEditPart();

					doConstraintSearch = isConstraintLinkConnection(request);
					doCanvasSearch = !doConstraintSearch
							&& (targetEP == null || targetEP instanceof DeployDiagramEditPart);

					if (targetEP != null && sourceEP != null) {

						if (targetEP instanceof DeployDiagramEditPart) {
							doCanvasSearch = ((DeployDiagramEditPart) targetEP).isLinkCanvasSearch();
						} else if (isHostingLinkConnection(request)) {
							// check to see if target is valid 
							status = isValidHostingEndPoint(dvs, targetEP);
							if (status.isOK()) {
								status = canCreateHostingLink(dvs, sourceEP, targetEP);
							}
							// find compatible sources that are contained visually
							if (status != null && !status.isOK()
									&& targetEP instanceof DeployShapeNodeEditPart) {

								EObject semanticElement = sourceEP.resolveSemanticElement();
								if (semanticElement instanceof Unit) {
									Unit sourceUnit = (Unit) semanticElement;
									List children = ((DeployShapeNodeEditPart) targetEP).getChildren();
									//5600: Set to temp variable to avoid hiding real status problem.
									IStatus childStatus = GMFUtils.hasContainedMatchingOptions(sourceUnit,
											dvs, children);
									if (childStatus.isOK()) {
										status = childStatus;
									}
								}
							}
						} else if (isRealizationLinkConnection(request)) {
							// check to see if target is valid 
							status = isValidRealizationEndPoint(dvs, targetEP);
							if (status != null && status.isOK()) {
								status = canCreateRealizationLink(dvs, sourceEP, targetEP);
							}
						} else if (isConstraintLinkConnection(request)) {
							status = sourceEP == targetEP ? DeployCoreUIPlugin.createErrorStatus(0,
									Messages.ShowConnectionErrorEditPolicy_Constraint_not_allowed_to_itsel_,
									null) : Status.OK_STATUS;
						} else {
							status = isValidDependencyLinkEndPoint(dvs, targetEP);
							if (status != null && status.isOK()) {
								status = canCreateDependencyLink(dvs, sourceEP, targetEP);
							}
						}
					}

				} else if (REQ_RECONNECT_SOURCE.equals(request.getType())) {

					sourceEP = (GraphicalEditPart) ((ReconnectRequest) request).getTarget();
					targetEP = (GraphicalEditPart) ((ReconnectRequest) request).getConnectionEditPart()
							.getTarget();
					if (sourceEP != null) {
						if (sourceEP instanceof DeployDiagramEditPart) {
							doLinkMove = true;
						} else if (isHostingLinkConnection(request)) {
							status = isValidHostingStartPoint(dvs, sourceEP);
						}
					}

				} else if (REQ_RECONNECT_TARGET.equals(request.getType())) {

					sourceEP = (GraphicalEditPart) ((ReconnectRequest) request).getConnectionEditPart()
							.getSource();
					targetEP = (GraphicalEditPart) ((ReconnectRequest) request).getTarget();

					if (targetEP != null && sourceEP != null) {
						if (targetEP instanceof DeployDiagramEditPart) {
							doLinkMove = true;
						} else if (isHostingLinkConnection(request)) {
							// check to see if target is valid 
							status = isValidHostingEndPoint(dvs, targetEP);
						}
					}

				}
			}

			int type = ErrorFeedbackFigure.TYPE_SUCCESS;
			String message = null;
			// tell user why they can't connect
			if (status != null && !status.isOK()) {
				if (sourceEP instanceof BusinessComponentEditPart
						&& targetEP instanceof BusinessComponentEditPart
						&& isDependencyLinkConnection(request)) {
					type = ErrorFeedbackFigure.TYPE_CREATE;
					message = Messages.ShowConnectionErrorEditPolicy_Create_a_Matc_;
				} else {
					type = ErrorFeedbackFigure.TYPE_ERROR;
					message = getMessage(status);
				}
			} else if (sourceEP == null || targetEP == null
					|| sourceEP instanceof DeployDiagramEditPart
					|| targetEP instanceof DeployDiagramEditPart) {
				type = ErrorFeedbackFigure.TYPE_SEARCH;
				if (doCanvasSearch) {
					message = Messages.ShowConnectionErrorEditPolicy_Search_For_Matc_;
				} else if (doConstraintSearch) {
					message = Messages.ShowConnectionErrorEditPolicy_all_units_suitable0;
				} else if (doLinkMove) {
					message = Messages.ShowConnectionErrorEditPolicy_Moving_Lin_;
				} else if (feedback != null) {
					eraseMessage();
				}
				// tell user what they're connecting to
			} else if (targetEP != null) {
				String tgtName = GMFUtils.getDmoName(targetEP.resolveSemanticElement());
				String srcName = GMFUtils.getDmoName(sourceEP.resolveSemanticElement());
				if (tgtName == null) {
					tgtName = ""; //$NON-NLS-1$
				}
				if (srcName != null && srcName.length() > 0) {
					message = NLS.bind(Messages.LINKINGTO, srcName, tgtName);
				}
			}
			// put up message
			if (message != null) {

				if (feedback == null) {
					getScaledFeedbackLayer().add(feedback = new ErrorFeedbackFigure(type, message));
				} else {
					feedback.setText(message);
				}

				PrecisionPoint p = new PrecisionPoint(((DropRequest) request).getLocation());
				IFigure figure = getLayer(LayerConstants.SCALABLE_LAYERS);
				PrecisionPoint d = new PrecisionPoint(0, 0);
				figure.translateToRelative(d);
				p.translate(d.x, d.y);

				Dimension siz = feedback.calculatePreferredSize();
				Rectangle r = getHost().getViewer().getControl().getBounds();
				r.width += d.x - 15;
				r.height += d.y - 15;
				p.translate(0, -siz.height);
				if (p.x + siz.width > r.width) {
					p.x = r.width - siz.width - 2;
				}
				if (p.y + siz.height > r.height) {
					p.y = r.height - siz.height - 2;
				}
				feedback.setLocation(p);
			}

		} catch (Exception ex) {
			DeployCoreUIPlugin.logError(0, ex.getMessage(), ex);
		}
	}

	private String getMessage(IStatus status) {
		if (status.isMultiStatus()) {
			String message = null;
			IStatus[] children = status.getChildren();
			for (int x = 0; x < children.length; ++x) {
				if (x == 2) {
					break; // show 2 messages
				}
				if (x == 0) {
					message = children[x].getMessage();
				} else {
					message += NEW_LINE + children[x].getMessage();
				}
			}
			return message;
		}
		return status.getMessage();
	}

	private boolean isDeployLinkConnection(Request req) {
		String semanticHint = null;
		if (req instanceof CreateConnectionViewAndElementRequest) {
			CreateConnectionViewAndElementRequest request = (CreateConnectionViewAndElementRequest) req;
			ConnectionViewAndElementDescriptor desc = request.getConnectionViewAndElementDescriptor();
			semanticHint = desc.getSemanticHint();
			return semanticHint != null
					&& (semanticHint.equals(DeployCoreConstants.HOSTINGLINK_SEMANTICHINT)
							|| semanticHint.equals(DeployCoreConstants.REALIZATIONLINK_SEMANTICHINT)
							|| semanticHint.equals(DeployCoreConstants.CONSTRAINTLINK_SEMANTICHINT) || semanticHint
							.equals(DeployCoreConstants.DEPENDENCYLINK_SEMANTICHINT));
		} else if (req instanceof ReconnectRequest) {
			ReconnectRequest request = (ReconnectRequest) req;
			ConnectionEditPart ep = request.getConnectionEditPart();
			return ep instanceof HostingLinkEditPart || ep instanceof RealizationLinkEditPart
					|| ep instanceof ConstraintLinkEditPart || ep instanceof DependencyLinkEditPart;
		}
		return false;
	}

	private boolean isHostingLinkConnection(Request req) {
		String semanticHint = null;
		if (req instanceof CreateConnectionViewAndElementRequest) {
			CreateConnectionViewAndElementRequest request = (CreateConnectionViewAndElementRequest) req;
			ConnectionViewAndElementDescriptor desc = request.getConnectionViewAndElementDescriptor();
			semanticHint = desc.getSemanticHint();
			return semanticHint != null
					&& semanticHint.equals(DeployCoreConstants.HOSTINGLINK_SEMANTICHINT);
		} else if (req instanceof ReconnectRequest) {
			ReconnectRequest request = (ReconnectRequest) req;
			return request.getConnectionEditPart() instanceof HostingLinkEditPart;
		}
		return false;
	}

	private boolean isRealizationLinkConnection(Request req) {
		String semanticHint = null;
		if (req instanceof CreateConnectionViewAndElementRequest) {
			CreateConnectionViewAndElementRequest request = (CreateConnectionViewAndElementRequest) req;
			ConnectionViewAndElementDescriptor desc = request.getConnectionViewAndElementDescriptor();
			semanticHint = desc.getSemanticHint();
			return semanticHint != null
					&& semanticHint.equals(DeployCoreConstants.REALIZATIONLINK_SEMANTICHINT);
		} else if (req instanceof ReconnectRequest) {
			ReconnectRequest request = (ReconnectRequest) req;
			return request.getConnectionEditPart() instanceof RealizationLinkEditPart;
		}
		return false;
	}

	private boolean isConstraintLinkConnection(Request req) {
		String semanticHint = null;
		if (req instanceof CreateConnectionViewAndElementRequest) {
			CreateConnectionViewAndElementRequest request = (CreateConnectionViewAndElementRequest) req;
			ConnectionViewAndElementDescriptor desc = request.getConnectionViewAndElementDescriptor();
			semanticHint = desc.getSemanticHint();
			return semanticHint != null
					&& semanticHint.equals(DeployCoreConstants.CONSTRAINTLINK_SEMANTICHINT);
		} else if (req instanceof ReconnectRequest) {
			ReconnectRequest request = (ReconnectRequest) req;
			return request.getConnectionEditPart() instanceof ConstraintLinkEditPart;
		}
		return false;
	}

	private boolean isDependencyLinkConnection(Request req) {
		String semanticHint = null;
		if (req instanceof CreateConnectionViewAndElementRequest) {
			CreateConnectionViewAndElementRequest request = (CreateConnectionViewAndElementRequest) req;
			ConnectionViewAndElementDescriptor desc = request.getConnectionViewAndElementDescriptor();
			semanticHint = desc.getSemanticHint();
			return semanticHint != null
					&& semanticHint.equals(DeployCoreConstants.DEPENDENCYLINK_SEMANTICHINT);
		} else if (req instanceof ReconnectRequest) {
			ReconnectRequest request = (ReconnectRequest) req;
			return request.getConnectionEditPart() instanceof DependencyLinkEditPart;
		}
		return false;
	}

} // end class ShowConnectionErrorEditPolicy
