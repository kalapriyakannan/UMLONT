/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.editparts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.Cursors;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gef.requests.SelectionRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DecorationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest.ConnectionViewAndElementDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest.ConnectionViewDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.tools.DragEditPartsTrackerEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.LineStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.IRelationshipChecker;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Stereotype;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.actions.FilterPreferenceAction;
import com.ibm.ccl.soa.deploy.core.ui.actions.OpenDefaultEditorAction;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployCoreEditor;
import com.ibm.ccl.soa.deploy.core.ui.editparts.core.CompositeShapeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.ConstraintLinkCanonicalConnectorEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.ContainerCreationEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DependencyLinkCanonicalConnectorEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployConstrainedToolbarLayoutEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployContainerEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployDragEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployEditPolicyRoles;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployLollipopEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployPopupBarEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployPropertyHandlerEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DeployResizableEditPolicyEx;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.DuplicateEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.HostingLinkCanonicalConnectorEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.LinkGraphicalNodeEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.NubEditEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.QuickFixEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.RealizationLinkCanonicalConnectorEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.editpolicies.ShowConnectionErrorEditPolicy;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployConnectorAnchor;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployCoreFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployListItemFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeploySlidableAnchor;
import com.ibm.ccl.soa.deploy.core.ui.figures.DragFeedbackFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.IFeedbackFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.common.NodeFigureEx;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.CompositeShapeFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.DeployDecoratorFigure;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.ArrangeSnappedViewsCommand;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.SnapViewCommand;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.ToggleHostingListCommand;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;
import com.ibm.ccl.soa.deploy.core.ui.preferences.IDeployPreferences;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ContainmentStateUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreConstants;
import com.ibm.ccl.soa.deploy.core.ui.util.GEFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.LayoutUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ResourceUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.SelectionUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.ViewUtil;
import com.ibm.ccl.soa.deploy.core.ui.util.ZoomUtils;
import com.ibm.ccl.soa.deploy.core.ui.util.CanonicalUtils.UnitLinkData;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;

/**
 * This is a base class for all Deploy Core Edit Parts
 */
public abstract class DeployShapeNodeEditPart extends CompositeShapeEditPart implements
		IFeedbackEditPart, IPropertyChangeListener {

	protected String category = null;
	private EObject savedRef = null;
	boolean isDeactivated = false;
	protected EContentAdapter _contentAdapter = null;
	private boolean isConfiguationUnit = false;
	private boolean isTreeItem = false;
	private Color styleFillColor = null;
	private Color styleLiteFillColor = null;
	private Color styleDarkFillColor = null;
	private Color styleLineColor = null;
	private boolean isDragInProgress = false;
	private static Color ghostFillColor = new Color(null, 40, 40, 40);
	private static Color ghostLineColor = new Color(null, 0, 0, 0);
	private DeployDragEditPolicy _dragPolicy = null;
	private DeployDragEditPolicy _dragPolicyList = null;
	private static boolean lastClickWasMove = false;
	private String _missingUnitCategory = null;

	// relationships to container
	final static public int NOCONTAINER = 0;
	final static public int HOSTEE = 1;
	final static public int MEMBER = 2;
	final static public int DEFERREDHOSTEE = 3;

	/**
	 * @return was the last time the user clicked the canvas for a move or a selection
	 */
	public static boolean isLastClickWasMove() {
		return lastClickWasMove;
	}

	public void activate() {
		EObject eo = resolveSemanticElement();
		if (eo instanceof Unit) {
			isConfiguationUnit = ((Unit) eo).isConfigurationUnit();
		}
		isTreeItem = getParent() instanceof DeployListCompartmentEditPart;
		addListener(this.resolveSemanticElement());
		DeployCoreUIPlugin.getDefault().getPreferenceStore().addPropertyChangeListener(this);
		super.activate();
	}

	public void deactivate() {
		isDeactivated = true;
		EObject resolved = getSemanticElementIfResolved();
		if (resolved != null && !resolved.eIsProxy()) {
			removeListener(resolved);
		}
		DeployCoreUIPlugin.getDefault().getPreferenceStore().removePropertyChangeListener(this);
		if (styleFillColor != null) {
			styleFillColor.dispose();
			styleLiteFillColor.dispose();
			styleDarkFillColor.dispose();
		}
		if (styleLineColor != null) {
			styleLineColor.dispose();
		}
		super.deactivate();
	}

	protected EObject getSemanticElementIfResolved() {
		EObject semanticElement = null;
		Object basicModel = basicGetModel();
		if (hasNotationView()) {
			semanticElement = (EObject) ((View) basicModel).eGet(
					NotationPackage.Literals.VIEW__ELEMENT, false);
		} else if (basicModel instanceof EObject) {
			semanticElement = (EObject) basicModel;
		}
		return semanticElement;
	}

	// if a dependency link is deleted from properties and then a canonical refresh deletes the editpart
	// the undo doesn't restore the editpart because it the view wasn't deleted
	// therefore we run the canonical policy ourselves here
	// because of the semantic model, hosting links/realization links do notify this editpart when they are undone 
	private void addListener(EObject eo) {
		if (eo == null) {
			return;
		}
		_contentAdapter = new EContentAdapter() {
			public void notifyChanged(final Notification n) {
				super.notifyChanged(n);
				if (isDeactivated) {
					return;
				}
				if (n.getEventType() == Notification.SET) {
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							if (n.getNewValue() instanceof DependencyLink) {
								Object ep = getEditPolicy(DeployEditPolicyRoles.DEPENDENCY_CANONICAL_ROLE);
								if (ep instanceof DependencyLinkCanonicalConnectorEditPolicy) {
									((DependencyLinkCanonicalConnectorEditPolicy) ep).refresh();
								}
							}
							if (n.getNewValue() instanceof ConstraintLink) {
								Object ep = getEditPolicy(DeployEditPolicyRoles.LOGICAL_CANONICAL_ROLE);
								if (ep instanceof ConstraintLinkCanonicalConnectorEditPolicy) {
									((ConstraintLinkCanonicalConnectorEditPolicy) ep).refresh();
								}
							}
						}
					});
				}
				if (n.getNewValue() instanceof Stereotype || n.getNotifier() instanceof Stereotype) {
					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							refreshValues();
							refreshBounds();

							Display.getDefault().asyncExec(new Runnable() {
								public void run() {
									ArrangeSnappedViewsCommand.arrangeSnappedViews(getEditingDomain(),
											getNotationView(), getViewer(), 0, null);
								}
							});

						}
					});
				}
			}
		};
		eo.eAdapters().add(_contentAdapter);
	}

	private void removeListener(EObject eo) {
		if (_contentAdapter != null && eo != null) {
			eo.eAdapters().remove(_contentAdapter);
		}
		_contentAdapter = null;
	}

	/**
	 * @param view
	 */
	public DeployShapeNodeEditPart(View view) {
		super(view);
		// initialize category with anchor name stripped of appended numbers 
		EObject eo = org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.resolveSemanticElement(view);
		if (eo instanceof DeployModelObject) {
			DeployModelObject dmo = (DeployModelObject) eo;
			String name = DeployModelObjectUtil.getTitle(dmo);
			if (name != null) {
				for (int i = name.length() - 1; i >= 0; i--) {
					if (!Character.isDigit(name.charAt(i))) {
						category = name.substring(0, i + 1);
						break;
					}
				}
			}
		} else if (eo == null) {
			DeployStyle style = (DeployStyle) view.getStyle(DeployNotationPackage.eINSTANCE
					.getDeployStyle());
			if (style != null) {
				category = _missingUnitCategory = style.getElementCategory();
			}
		}
	}

	/*
	 * if editor is removing this node, delete any edges to this node too
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#removeNotify()
	 */
	public void removeNotify() {
		// delete any decorators on the editpart
		DecorationEditPolicy policy = (DecorationEditPolicy) getEditPolicy(EditPolicyRoles.DECORATION_ROLE);
		if (policy != null) {
			policy.deactivate();
		}
		super.removeNotify();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.xtools.presentation.internal.editparts.ShapeEditPart#getPrimaryDragEditPolicy()
	 */
	public EditPolicy getPrimaryDragEditPolicy() {
		_dragPolicy = new DeployDragEditPolicy();
		return _dragPolicy;
	}

	@Override
	public DragTracker getDragTracker(Request request) {
		return new DragEditPartsTrackerEx(this) {

			private boolean wasDragged = false;
			private boolean disableSelection = false;

			@Override
			protected boolean handleButtonDown(int button) {
				wasDragged = false;
				return super.handleButtonDown(button);
			}

			// don't fade if they're just dragging
			@Override
			protected boolean handleDragInProgress() {
				lastClickWasMove = wasDragged = true;
				isDragInProgress = true;
				SelectionUtils.unfadeFigures();
				getCurrentViewer().setCursor(Cursors.ARROW);
				return super.handleDragInProgress();
			}

			@Override
			protected boolean handleButtonUp(int button) {
				if (!wasDragged && lastClickWasMove) {
					DeployResizableEditPolicyEx policy = (DeployResizableEditPolicyEx) getEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE);
					if (policy == null) {
						policy = (DeployResizableEditPolicyEx) getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
					}
					if (policy != null) {
						policy.showFadeFeedback();
					}
				}
				lastClickWasMove = wasDragged;
				isDragInProgress = false;
				// any dialogs to be openned on a decorator can be openned now
				// this avoids a dialog openning when the user just wants to drag the unit
				if (getSourceEditPart() instanceof GraphicalEditPart) {
					Point p = getLocation();
					IFigure f = ((FigureCanvas) getSourceEditPart().getViewer().getControl())
							.getLightweightSystem().getRootFigure().findFigureAt(p.x, p.y);
					if (f instanceof DeployDecoratorFigure) {
						disableSelection = ((DeployDecoratorFigure) f).handleButtonUp(button);
					}
				}
				return super.handleButtonUp(button);
			}

			protected void performSelection() {
				if (!disableSelection) {
					super.performSelection();
				}
			}

			@Override
			protected boolean handleKeyDown(KeyEvent e) {
				if (e.keyCode == SWT.ALT) {
					if (_dragPolicy != null && _dragPolicy.getFeedback() instanceof DragFeedbackFigure) {
						((DragFeedbackFigure) _dragPolicy.getFeedback()).altKeyPressed();
					}
					if (_dragPolicyList != null
							&& _dragPolicyList.getFeedback() instanceof DragFeedbackFigure) {
						((DragFeedbackFigure) _dragPolicyList.getFeedback()).altKeyPressed();
					}
				}
				if (e.keyCode == SWT.CTRL) {
					if (_dragPolicy != null && _dragPolicy.getFeedback() instanceof DragFeedbackFigure) {
						((DragFeedbackFigure) _dragPolicy.getFeedback()).ctrlKeyPressed();
					}
					if (_dragPolicyList != null
							&& _dragPolicyList.getFeedback() instanceof DragFeedbackFigure) {
						((DragFeedbackFigure) _dragPolicyList.getFeedback()).ctrlKeyPressed();
					}
				}
				return super.handleKeyDown(e);
			}

			@Override
			protected void setCloneActive(boolean cloneActive) {
				// we use ctrl key for attachment
			}
		};
	}

	/**
	 * @return is drag in progress
	 */
	public boolean isDragInProgress() {
		return isDragInProgress;
	}

	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);
		if (!isActive()) {
			return;
		}
		// if user changed conceptual state 
		if (notification.getFeature() == CorePackage.eINSTANCE.getUnit_Conceptual()
				&& notification.getEventType() == Notification.SET) {
			refreshValues();
		}

		// if user changed configuration unit status of this unit, 
		if (notification.getFeature() == CorePackage.eINSTANCE.getUnit_ConfigurationUnit()
				&& notification.getEventType() == Notification.SET) {

			// don't execute unless something changed
			if (isConfiguationUnit == notification.getNewBooleanValue()) {
				return;
			}
			isConfiguationUnit = !isConfiguationUnit;

			// if this unit is hosted, toggle it into/out of a hosting list
			HostingLink link = getHostingLink();
			if (link != null) {
				ToggleHostingListCommand cmd = new ToggleHostingListCommand(getEditingDomain(),
						Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE), GMFUtils
								.getDeployDiagramEditPart(this), link.getHosted(), link.getHost(),
						notification.getNewBooleanValue());
				if (cmd.canExecute()) {
					try {
						cmd.execute(new NullProgressMonitor(), null);
					} catch (ExecutionException e) {
						DeployCoreUIPlugin.logError(0, e.getMessage(), e);
					}
				}
			}
		}

		// if user changed the name and this editpart has atachments, realign attachments 
		if (notification.getFeature() == CorePackage.eINSTANCE.getDeployModelObject_DisplayName()
				&& notification.getEventType() == Notification.SET) {

			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					ArrangeSnappedViewsCommand.arrangeSnappedViews(getEditingDomain(),
							getNotationView(), getViewer(), 0, null);
					if (isTreeItem && ZoomUtils.isExposed(DeployShapeNodeEditPart.this)) {
						EditPart topEP = GEFUtils.getTopEditPart(DeployShapeNodeEditPart.this);
						if (!(topEP instanceof DeployShapeNodeEditPart)
								|| !((DeployShapeNodeEditPart) topEP).isInSnapGroup()) {
							LayoutUtils.layoutNewTreeItem(DeployShapeNodeEditPart.this);
						}
					}
				}
			});
		}
		// update colors
		if (notification.getNotifier() instanceof ShapeStyle) {
			refreshColors();
		}
		// update selection if conceptual changes
		if (notification.getFeature() == CorePackage.eINSTANCE.getUnit_Conceptual()
				&& notification.getEventType() == Notification.SET) {
			EditPartViewer viewer = getViewer();
			if (viewer.getSelectedEditParts().contains(this)) {
				viewer.deselect(this);
				viewer.appendSelection(this);
			}
		}

	}

	public void propertyChange(PropertyChangeEvent event) {
		if (isActive()) {
			if (event.getProperty().equals(IDeployPreferences.DEPLOY_FILTER_TYPE_NAMES)) {
				refresh();
			} else {
				refreshColors();
			}
		}
	}

	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshValues();
		refreshColors();
	}

	/**
	 * refresh category can conceptual
	 */
	public void refreshValues() {
		NodeFigure figure = (NodeFigure) getMainFigure();
		EObject eo = resolveSemanticElement();
		if (eo != null && eo instanceof Unit) {
			Unit unit = (Unit) eo;
			Import imprt = unit.getTopology() != unit.getEditTopology() ? GMFUtils.getImport(unit)
					: null;

			// get stereotype(s)
			String stereotype = computeStereotypedTypeName(unit);

			boolean filterTypeName = FilterPreferenceAction.isFiltered(
					IDeployPreferences.DEPLOY_FILTER_TYPE_NAMES, this);

			// contained Config unit figure
			if (figure instanceof DeployListItemFigure) {
				DeployListItemFigure fig = (DeployListItemFigure) figure;

				if (!filterTypeName) {
					String tt = stereotype != null ? stereotype : category;
					// add import to tooltip
					if (imprt != null) {
						String name = imprt.getNamespace();
						if (name != null && name.length() > 0) {
							name += "#";//$NON-NLS-1$
						}
						name += imprt.getDisplayName();
						tt = tt + "/" + NLS.bind(Messages.IMPORT_PROXY, name); //$NON-NLS-1$
					}
					Label toolTip = new Label(tt) {
						public Insets getInsets() {
							return new Insets(2);
						}
					};
					figure.setToolTip(toolTip);
				}
				fig.setElement(eo);
				fig.setConceptual(unit.isConceptual());
				setImportStatus(fig, unit);
				// large figure
			} else if (figure instanceof DeployCoreFigure) {
				DeployCoreFigure fig = (DeployCoreFigure) figure;
				fig.setCategory(stereotype != null ? stereotype : category);
				fig.setConceptual(unit.isConceptual());
				fig.setElement(eo);
				fig.setFilterCategory(filterTypeName);
				if (imprt != null) {
					fig.setImport(imprt);
				}
				NodeFigureEx nodeFigure = (NodeFigureEx) getFigure();
				nodeFigure.setConnectionAlwaysOnTop(isInSnapGroup());

				// add import to tooltip
				if (imprt != null) {
					String name = imprt.getNamespace();
					if (name != null && name.length() > 0) {
						name += "#";//$NON-NLS-1$
					}
					name += imprt.getDisplayName();
					Label toolTip = new Label(NLS.bind(Messages.IMPORT_PROXY, name)) {
						public Insets getInsets() {
							return new Insets(2);
						}
					};
					figure.setToolTip(toolTip);
				}
			}
			ViewUtil.refreshDeployStyle(this);
		}
	}

	protected void refreshBackgroundColor() {
		FillStyle style = (FillStyle) getPrimaryView().getStyle(NotationPackage.Literals.FILL_STYLE);
		if (style != null) {
			Color clr = DiagramColorRegistry.getInstance().getColor(new Integer(style.getFillColor()));
			if (getFigure() != null && clr != getFigure().getBackgroundColor()) {
				setBackgroundColor(clr);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private String computeStereotypedTypeName(Unit unit) {
		List<Stereotype> stereotypes = unit.getStereotypes();
		if (stereotypes != null && !stereotypes.isEmpty()) {
			StringBuffer buf = new StringBuffer();
			buf.append('<').append('<');
			int size = stereotypes.size();
			for (int i = 0; i < size; i++) {
				Stereotype st = stereotypes.get(i);
				buf.append(st.getKeyword());
				if (i + 1 < size) {
					buf.append(',').append(' ');
				}
			}
			buf.append('>').append('>');
			return buf.toString();
		}
		return null;
	}

	protected void refreshColors() {
		// get DeployCoreFigure
		CompositeShapeFigure f = (CompositeShapeFigure) getFigure();
		if (!(f.getInnerFigure() instanceof DeployCoreFigure)) {
			return;
		}
		DeployCoreFigure fig = (DeployCoreFigure) f.getInnerFigure();

		// then see if they've override the fill color on this figure
		Color fillColor = null;
		Color liteFillColor = null;
		Color darkFillColor = null;
		FillStyle fillStyle = (FillStyle) getPrimaryView().getStyle(
				NotationPackage.Literals.FILL_STYLE);
		if (fillStyle != null) {
			if (fillStyle.eIsSet(NotationPackage.Literals.FILL_STYLE__FILL_COLOR)) {
				int fillClr = fillStyle.getFillColor();
				if (styleFillColor == null || styleFillColor.isDisposed()
						|| fillClr != FigureUtilities.RGBToInteger(styleFillColor.getRGB())) {
					if (styleFillColor != null) {
						styleFillColor.dispose();
						styleLiteFillColor.dispose();
						styleDarkFillColor.dispose();
					}
					RGB fillRGB = FigureUtilities.integerToRGB(fillClr);
					styleFillColor = getLiteColor(fillRGB, 0.8f);
					styleLiteFillColor = getLiteColor(fillRGB, 0.6f);
					styleDarkFillColor = getDarkColor(fillRGB, 0.9f);
				}
				fillColor = styleFillColor;
				liteFillColor = styleLiteFillColor;
				darkFillColor = styleDarkFillColor;
			}
		}
		fig.setFillColors(fillColor, liteFillColor, darkFillColor);

		// then see if they've override the line color on this figure
		Color lineColor = null;
		LineStyle lineStyle = (LineStyle) getPrimaryView().getStyle(
				NotationPackage.Literals.LINE_STYLE);
		if (lineStyle != null) {
			if (lineStyle.eIsSet(NotationPackage.Literals.LINE_STYLE__LINE_COLOR)) {
				int lineClr = lineStyle.getLineColor();
				if (styleLineColor == null || styleLineColor.isDisposed()
						|| lineClr != FigureUtilities.RGBToInteger(styleLineColor.getRGB())) {
					if (styleLineColor != null) {
						styleLineColor.dispose();
					}
					styleLineColor = new Color(null, FigureUtilities.integerToRGB(lineClr));
				}
				lineColor = styleLineColor;
			}
		}
		fig.setLineColor(lineColor);

	}

	private Color getDarkColor(RGB fillRGB, float f) {
		return new Color(null, (int) (fillRGB.red * f), (int) (fillRGB.green * f),
				(int) (fillRGB.blue * f));
	}

	private Color getLiteColor(RGB fillRGB, float f) {
		return new Color(null, Math.max(2, Math.min((int) (fillRGB.red / f), 255)), Math.max(2, Math
				.min((int) (fillRGB.green / f), 255)), Math.max(2, Math.min((int) (fillRGB.blue / f),
				255)));
	}

	@Override
	protected void registerModel() {
		super.registerModel();
		EObject ref = ((View) getModel()).getElement();
		if (ref == null) {
			return;
		}
		savedRef = ref;
		GMFUtils.getDeployDiagramEditPart(this).registerEditPartForElement(ref, this);
	}

	@Override
	protected void unregisterModel() {
		super.unregisterModel();
		GMFUtils.getDeployDiagramEditPart(this).unregisterEditPartForElement(savedRef, this);
	}

	private HostingLink getHostingLink() {
		Unit unit = (Unit) org.eclipse.gmf.runtime.diagram.core.util.ViewUtil
				.resolveSemanticElement((View) getModel());
		if (unit != null) {
			DeployDiagramEditPart ddep = GMFUtils.getDeployDiagramEditPart(this);
			Map<Unit, UnitLinkData> linkCacheMap = ddep.getSemanticCacheData().getLinkCacheMap();
			UnitLinkData linkData = linkCacheMap.get(unit);
			if (linkData != null && linkData.hasHostingLinks()) {
				for (Iterator it = linkData.getAllHostingLinks().iterator(); it.hasNext();) {
					HostingLink link = (HostingLink) it.next();
					if (link.getHosted() == unit) {
						return link;
					}
				}
			}
		}
		return null;
	}

	protected void setImport(DeployCoreFigure fig, Unit unit) {
		// if this unit is in an imported topology
		if (unit.getTopology() != unit.getEditTopology()) {
			Import imprt = GMFUtils.getImport(unit);
			fig.setImport(imprt);
		}
	}

	protected void setImportStatus(DeployListItemFigure fig, Unit unit) {
		if (unit.getTopology() == unit.getEditTopology()) {
			GraphicalEditPart ep = GMFUtils.getTopList(this);
			if (ep != null) {
				EObject eo = GMFUtils.getTopList(this).resolveSemanticElement();
				if (eo instanceof Import || eo instanceof DeployModelObject
						&& PropertyUtils.isProxy((DeployModelObject) eo)) {
					fig.setImportStatus(DeployListItemFigure.IMPORT_FORIEGN_UNIT);
				}
			}
		}
	}

	/**
	 * Adds support for diagram links.
	 * 
	 * @see com.ibm.xtools.diagram.ui.editparts.GraphicalEditPart#createDefaultEditPolicies()
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();

		installEditPolicy(EditPolicy.CONNECTION_ROLE, new ShowConnectionErrorEditPolicy());

		// link edit policies
		installEditPolicy(DeployEditPolicyRoles.HOSTING_CANONICAL_ROLE,
				new HostingLinkCanonicalConnectorEditPolicy());
		installEditPolicy(DeployEditPolicyRoles.DEPENDENCY_CANONICAL_ROLE,
				new DependencyLinkCanonicalConnectorEditPolicy());
		installEditPolicy(DeployEditPolicyRoles.LOGICAL_CANONICAL_ROLE,
				new ConstraintLinkCanonicalConnectorEditPolicy());
		installEditPolicy(DeployEditPolicyRoles.REALIZATION_CANONICAL_ROLE,
				new RealizationLinkCanonicalConnectorEditPolicy());

		// property commands
		removeEditPolicy(EditPolicyRoles.PROPERTY_HANDLER_ROLE);
		installEditPolicy(EditPolicyRoles.PROPERTY_HANDLER_ROLE,
				new DeployPropertyHandlerEditPolicy());

		// remove drop down handle from inside of config unit list
		removeEditPolicy(EditPolicy.LAYOUT_ROLE);
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new DeployConstrainedToolbarLayoutEditPolicy());

		if (getParent() instanceof DeployListCompartmentEditPart) {
			// tree item selection uses our special color/handles
			installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new DeployResizableEditPolicyEx());
			// allow tree items to be dragged from a list to canvas/group
			_dragPolicyList = new DeployDragEditPolicy();
			installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, _dragPolicyList);
		}

		// allow services/references to be editted
		installEditPolicy(DeployEditPolicyRoles.NUB_EDIT_ROLE, new NubEditEditPolicy());

		// kill those connector handles and add our own!!!
		removeEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);
		installEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE, new DeployLollipopEditPolicy());

		// override to provide support for arranging groups
		removeEditPolicy(EditPolicy.CONTAINER_ROLE);
		installEditPolicy(EditPolicy.CONTAINER_ROLE, new DeployContainerEditPolicy());

		removeEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE);

		// modify connector link
		removeEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE);
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new LinkGraphicalNodeEditPolicy());

		// creates quickfix dialog when error marker is clicked
		installEditPolicy(DeployEditPolicyRoles.QUICK_FIX_ROLE, new QuickFixEditPolicy());

		// Install the DuplicateEditPolicy which handles updating duplicate tags.
		installEditPolicy(DeployEditPolicyRoles.DUPLICATE_ROLE, new DuplicateEditPolicy());

		// install PopupBarEditPolicy to show context popup bar
		removeEditPolicy(EditPolicyRoles.POPUPBAR_ROLE);
		installEditPolicy(EditPolicyRoles.POPUPBAR_ROLE, new DeployPopupBarEditPolicy() {
			protected int getAppearanceDelay() {
				return 250;
			}

			protected int getDisappearanceDelayUponExit() {
				return 250;
			}
		});

		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new ContainerCreationEditPolicy());

		// allow units dragged within a group compartment to be seen
		if (getParent() instanceof HybridShapesCompartmentEditPart) {
			installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new DeployResizableEditPolicyEx() {
				protected IFigure createDragSourceFeedbackFigure() {
					RectangleFigure r = new RectangleFigure();
					r.setFillXOR(true);
					r.setOutlineXOR(true);
					r.setLineStyle(Graphics.LINE_DOT);
					r.setBackgroundColor(ghostFillColor);
					r.setForegroundColor(ghostLineColor);
					r.setBounds(getInitialFeedbackBounds());
					addFeedback(r);
					return r;
				}
			});
		}

		// allow users to open flyout dialog by double-clicking on item
		installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenEditPolicy() {
			protected Command getOpenCommand(Request request) {
				// else we open the property dialog
				DeployShapeNodeEditPart ep = (DeployShapeNodeEditPart) getHost();
				EObject eo = ep.resolveSemanticElement();
				if (eo instanceof Unit) {
					Unit unit = (Unit) eo;
					if (request instanceof SelectionRequest) {
						Rectangle rect = getFigure().getBounds();
						NameCompartmentEditPart.popupGeneralPropertyFlyout(getFigure(), getViewer(), rect
								.getTopRight(), unit);
					}
				} else {
					// open diagrams/imports/import diagrams on a double-click
					EObject openEO = GMFUtils.getDiagram(ep);
					if (openEO == null && eo instanceof Import) {
						openEO = eo;
					}
					OpenDefaultEditorAction.open(openEO);
				}
				return null;
			}
		});
	}

	/**
	 * this method will return the primary child EditPart inside this edit part
	 * 
	 * @return the primary child view inside this edit part
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(DeployCoreConstants.DEPLOY_NAME);
	}

	public Object getAdapter(Class adapter) {
		if (adapter == String.class) {
			return DeployCoreConstants.DEPLOY_NAME;
		}

		return super.getAdapter(adapter);
	}

	/**
	 * @return list of compartment editparts which can be expanded
	 */

	public List getExpandableCompartmentEditParts() {
		List list = new ArrayList();
		IGraphicalEditPart ep = getChildBySemanticHint(DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
		if (ep != null) {
			list.add(ep);
		}
		ep = getChildBySemanticHint(DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
		if (ep != null) {
			list.add(ep);
		}
		return list;
	}

	/**
	 * @return is this group in hybrid tree mode
	 */
	public boolean isHybridList() {
		return getChildBySemanticHint(DeployCoreConstants.HYBRIDLIST_SEMANTICHINT) != null;
	}

	/**
	 * @return xx
	 */
	public String getFeedbackState() {
		if (getFigure() instanceof IFeedbackFigure) {
			return ((IFeedbackFigure) getFigure()).getFeedbackState();
		}
		return null;
	}

	/**
	 * @param state
	 */
	public void setFeedbackState(String state) {
		if (getFigure() instanceof IFeedbackFigure
				&& (!IFeedbackFigure.STATE_LINK_SELECTED.equals(state) || !isInSnapGroup())) {
			((IFeedbackFigure) getFigure()).setFeedbackState(state);
		}
	}

	/**
	 * @param state
	 * @param c
	 */
	public void setFeedbackState(String state, Color c) {
		if (getFigure() instanceof IFeedbackFigure) {
			((IFeedbackFigure) getFigure()).setFeedbackState(state, c);
		}
	}

	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
		// if the link is to a hosting list figure, we do left or right anchor
		NodeFigure figure = (NodeFigure) getMainFigure();
		if (figure instanceof DeployListItemFigure) {
			int anchorType = DeployConnectorAnchor.LEFT_OR_RIGHT_TERMINAL_SOURCE;
			return new DeployConnectorAnchor(this, connection, anchorType);

			// else if a link from a snap group to outside of snap group
		} else if (isInSnapGroup() && !DeployConnectionNodeEditPart.isInnerSnapLink(connection)) {
			EList rows = getOwnerSnapGroup().getPersistedChildren();
			int anchorType = DeployConnectorAnchor.LEFT_OR_RIGHT_SOURCE;
			int inx = rows.indexOf(getOwnerSnapRow());
			if (inx == 0) {
				anchorType = DeployConnectorAnchor.LEFT_OR_RIGHT_OR_TOP_SOURCE;
			} else if (inx == rows.size() - 1) {
				if (connection instanceof HostingLinkEditPart) {
					anchorType = DeployConnectorAnchor.BOTTOM_TERMINAL;
				} else {
					anchorType = DeployConnectorAnchor.LEFT_OR_RIGHT_OR_BOTTOM_SOURCE;
				}
			}
			return new DeployConnectorAnchor(this, connection, anchorType);
			// else if the link is a hosting link, we do a bottom anchor for source
		} else if (connection instanceof DeployConnectionNodeEditPart
				&& GMFUtils.isHostingLink(((DeployConnectionNodeEditPart) connection)
						.resolveSemanticElement())) {
			int anchorType = DeployConnectorAnchor.BOTTOM_TERMINAL;
			return new DeployConnectorAnchor(this, connection, anchorType);
		}
		// else we do a sliding anchor for dependency, logical and other links 
		return new DeploySlidableAnchor(getFigure(), connection);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.NodeEditPart#getTargetConnectionAnchor(org.eclipse.gef.ConnectionEditPart)
	 */
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
		// if the link is to a hosting list figure, we do left or right anchor
		NodeFigure figure = (NodeFigure) getMainFigure();
		if (figure instanceof DeployListItemFigure) {
			int anchorType = DeployConnectorAnchor.LEFT_OR_RIGHT_TERMINAL_TARGET;
			return new DeployConnectorAnchor(this, connection, anchorType);

			// else if a link from a snap group to outside of snap group
		} else if (isInSnapGroup() && !DeployConnectionNodeEditPart.isInnerSnapLink(connection)) {
			EList rows = getOwnerSnapGroup().getPersistedChildren();
			int anchorType = DeployConnectorAnchor.LEFT_OR_RIGHT_TARGET;
			int inx = rows.indexOf(getOwnerSnapRow());
			if (inx == 0) {
				if (connection instanceof HostingLinkEditPart) {
					anchorType = DeployConnectorAnchor.TOP_TERMINAL;
				} else {
					anchorType = DeployConnectorAnchor.LEFT_OR_RIGHT_OR_TOP_TARGET;
				}
			} else if (inx == rows.size() - 1) {
				anchorType = DeployConnectorAnchor.LEFT_OR_RIGHT_OR_BOTTOM_TARGET;
			}
			return new DeployConnectorAnchor(this, connection, anchorType);
			// else if this is a hosting link, we do a top anchor for target
		} else if (connection instanceof DeployConnectionNodeEditPart
				&& GMFUtils.isHostingLink(((DeployConnectionNodeEditPart) connection)
						.resolveSemanticElement())) {
			int anchorType = DeployConnectorAnchor.TOP_TERMINAL;
			return new DeployConnectorAnchor(this, connection, anchorType);
		}
		// else we do a sliding anchor for dependency, logical and other links 
		return new DeploySlidableAnchor(getFigure(), connection);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.NodeEditPart#getSourceConnectionAnchor(org.eclipse.gef.Request)
	 */
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		if (isHostingConnection(request)) {
			return new DeployConnectorAnchor(this, DeployConnectorAnchor.BOTTOM_TERMINAL);
		} else if (isRealizeConnection(request)) {
			return new DeployConnectorAnchor(this, DeployConnectorAnchor.RIGHT_BOTTOM4_TERMINAL);
		} else if (isConstraintConnection(request)) {
			return new DeployConnectorAnchor(this, DeployConnectorAnchor.LEFT_BOTTOM8_TERMINAL);
		}
		return new DeployConnectorAnchor(this, DeployConnectorAnchor.RIGHT_TERMINAL);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gef.NodeEditPart#getTargetConnectionAnchor(org.eclipse.gef.Request)
	 */
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		if (isHostingConnection(request)) {
			return new DeployConnectorAnchor(this, DeployConnectorAnchor.TOP_TERMINAL);
		} else if (isRealizeConnection(request)) {
			return new DeployConnectorAnchor(this, DeployConnectorAnchor.CENTER_TERMINAL);
		} else if (isConstraintConnection(request)) {
			return new DeployConnectorAnchor(this, DeployConnectorAnchor.CENTER_TERMINAL);
		}
		return new DeployConnectorAnchor(this, DeployConnectorAnchor.LEFT_TERMINAL);
	}

	protected boolean isHostingConnection(Request req) {
		String semanticHint = getSemanticHint(req);
		if (semanticHint != null && semanticHint.equals(DeployCoreConstants.HOSTINGLINK_SEMANTICHINT)) {
			return true;
		} else if (req instanceof ReconnectRequest) {
			ReconnectRequest rreq = (ReconnectRequest) req;
			return rreq.getConnectionEditPart() instanceof HostingLinkEditPart;
		}
		return false;
	}

	protected boolean isRealizeConnection(Request req) {
		String semanticHint = getSemanticHint(req);
		if (semanticHint != null
				&& semanticHint.equals(DeployCoreConstants.REALIZATIONLINK_SEMANTICHINT)) {
			return true;
		} else if (req instanceof ReconnectRequest) {
			ReconnectRequest rreq = (ReconnectRequest) req;
			return rreq.getConnectionEditPart() instanceof RealizationLinkEditPart;
		}
		return false;
	}

	protected boolean isConstraintConnection(Request req) {
		String semanticHint = getSemanticHint(req);
		if (semanticHint != null
				&& semanticHint.equals(DeployCoreConstants.CONSTRAINTLINK_SEMANTICHINT)) {
			return true;
		} else if (req instanceof ReconnectRequest) {
			ReconnectRequest rreq = (ReconnectRequest) req;
			return rreq.getConnectionEditPart() instanceof ConstraintLinkEditPart;
		}
		return false;
	}

	private String getSemanticHint(Request req) {
		String semanticHint = null;
		if (req instanceof CreateConnectionViewAndElementRequest) {
			CreateConnectionViewAndElementRequest request = (CreateConnectionViewAndElementRequest) req;
			ConnectionViewAndElementDescriptor desc = request.getConnectionViewAndElementDescriptor();
			semanticHint = desc.getSemanticHint();
		} else if (req instanceof CreateConnectionViewRequest) {
			CreateConnectionViewRequest request = (CreateConnectionViewRequest) req;
			ConnectionViewDescriptor desc = request.getConnectionViewDescriptor();
			semanticHint = desc.getSemanticHint();
		}
		return semanticHint;
	}

	/**
	 * @param category
	 */
	public void setCategory(String cat) {
		if (_missingUnitCategory != null) {
			category = _missingUnitCategory;
		} else {
			category = cat;
		}
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				NodeFigure fig = (NodeFigure) getMainFigure();
				if (fig instanceof DeployCoreFigure) {
					DeployCoreFigure f = (DeployCoreFigure) fig;
					EObject dmo = f.getElement();
					//Ignore if we have stereotypes because the category has already been replaced by the stereotype.
					if (dmo == null
							|| !(dmo instanceof Unit && !((Unit) dmo).getStereotypes().isEmpty())) {
						f.setCategory(category);
						f.invalidate();
						f.repaint();
					}
				}
			}
		});
	}

	/**
	 * @return category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * 
	 */
	public void refreshFigure() {
		IFigure figure = getMainFigure();
		if (figure != null) {
			figure.invalidate();
		}
	}

	public boolean isSelectable() {
		// allow a DeployShapeNodeEditPart to always be selected by Select All action
		// even if the shape is inside of a collapsed container
		return true;
	}

	public Command getCommand(Request request) {
		if (GMFUtils.isDeleteRequest(request)) {
			// don't allow import editparts to be deleted unless they are an actual import topology editpart
			if (resolveSemanticElement() != null
					&& GMFUtils.isNonMutableImport(this)
					&& !(this instanceof ImportTopologyEditPart || getParent() instanceof DeployDiagramEditPart)) {
				return new ICommandProxy(new AbstractTransactionalCommand(getEditingDomain(),
						"Non Delete", null) { //$NON-NLS-1$
							public boolean canExecute() {
								return false;
							}

							protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor,
									IAdaptable info) {
								return CommandResult.newOKCommandResult();
							}
						});
				// if a member of a snap group, add a command to detach from that group
			}

			// update containement state-- if this is the last view removed for thsi unit,
			// remove the unit from the state arrays in the diagram
			Command cmd = new ICommandProxy(new AbstractTransactionalCommand(getEditingDomain(),
					"", null) { //$NON-NLS-1$
						protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor,
								IAdaptable info) {
							ContainmentStateUtils.updateStates(DeployShapeNodeEditPart.this
									.getNotationView());
							return CommandResult.newOKCommandResult();
						}
					});

			if (isInSnapGroup()) {
				cmd.chain(new ICommandProxy(new SnapViewCommand(getEditingDomain(), null, this, null,
						null, false)));
			}
			return cmd.chain(super.getCommand(request));
		}
		return super.getCommand(request);
	}

	protected int getRelationshipToContainer() {
		if (getParent() != null) {
			EditPart parentEP = getParent().getParent();
			if (parentEP instanceof TopologyEditPart) {
				EObject eb = resolveSemanticElement();
				if (eb instanceof Unit) {
					Unit containedUnit = (Unit) eb;
					EObject eo = ((DeployShapeNodeEditPart) parentEP).resolveSemanticElement();
					if (eo instanceof Unit) {
						for (Iterator<?> it = ((Unit) eo).getMemberLinks().iterator(); it.hasNext();) {
							MemberLink link = (MemberLink) it.next();
							if (containedUnit.equals(link.getTarget())) {
								return MEMBER;
							}
						}
						if (containedUnit.getEditTopology() != null) {
							IRelationshipChecker relationships = containedUnit.getEditTopology()
									.getRelationships();
							for (Iterator<?> it = relationships.getConstraintLinkTargetsLinks(
									containedUnit).iterator(); it.hasNext();) {
								if (GMFUtils.isHostingLink((ConstraintLink) it.next())) {
									return DEFERREDHOSTEE;
								}
							}
						}
					}
				}
				return HOSTEE;
			}
		}
		return NOCONTAINER;
	}

	/**
	 * @return whether a figure's parent is a collpased compartment
	 */
	public boolean isParentCollapsed() {
		CompositeShapeFigure fig = (CompositeShapeFigure) getFigure();
		return isParentCollapsedHelper(fig.getInnerFigure());
	}

	private boolean isParentCollapsedHelper(IFigure fig) {
		IFigure walker = fig;
		while (walker != null) {
			if (walker instanceof ResizableCompartmentFigure) {
				ResizableCompartmentFigure compartment = (ResizableCompartmentFigure) walker;
				if (!compartment.isExpanded()) {
					return true;
				}
			}
			walker = walker.getParent();
		}
		return false;
	}

	protected List getModelSourceConnections() {
		View view = (View) getModel();
		if (!view.eIsSet(NotationPackage.Literals.VIEW__SOURCE_EDGES)) {
			return Collections.EMPTY_LIST;
		}
		List sourceConnections = new ArrayList();
		Iterator iter = view.getSourceEdges().iterator();
		while (iter.hasNext()) {
			Edge edge = (Edge) iter.next();
			View target = edge.getTarget();
			// fix NPE's in GMF classes 
			if (target != null && edge.isVisible() && isViewVisible(target)) {
				sourceConnections.add(edge);
			}

		}
		return sourceConnections;
	}

	protected List getModelTargetConnections() {
		View view = (View) getModel();
		if (!view.eIsSet(NotationPackage.Literals.VIEW__TARGET_EDGES)) {
			return Collections.EMPTY_LIST;
		}
		List targteConnections = new ArrayList();
		Iterator iter = view.getTargetEdges().iterator();
		while (iter.hasNext()) {
			Edge edge = (Edge) iter.next();
			View source = edge.getSource();
			// fix NPE's in GMF classes 
			if (source != null && edge.isVisible() && isViewVisible(source)) {
				targteConnections.add(edge);
			}
		}
		return targteConnections;

	}

	private static boolean isViewVisible(View target) {
		if (target.isVisible()) {
			EObject parent = target.eContainer();
			if (parent instanceof View) {
				return isViewVisible((View) parent);
			}
			return true;
		}
		return false;
	}

	/**
	 * @return is this part in tree mode
	 */
	static public boolean isTreeMode(EditPart ep) {
		return getListCompartment(ep) != null;
	}

	/**
	 * @return contained list container else null
	 */
	static public IGraphicalEditPart getListCompartment(EditPart ep) {
		IGraphicalEditPart shapesCompartmentEP = null;
		if (ep instanceof DeployShapeNodeEditPart) {
			DeployShapeNodeEditPart dep = (DeployShapeNodeEditPart) ep;
			shapesCompartmentEP = dep
					.getChildBySemanticHint(DeployCoreConstants.HYBRIDLIST_SEMANTICHINT);
			if (shapesCompartmentEP == null) {
				shapesCompartmentEP = dep
						.getChildBySemanticHint(DeployCoreConstants.IMPORTTOPOLOGYLIST_SEMANTICHINT);
			}
			if (shapesCompartmentEP == null) {
				shapesCompartmentEP = dep
						.getChildBySemanticHint(DeployCoreConstants.DIAGRAMNODELIST_SEMANTICHINT);
			}
		}
		return shapesCompartmentEP;
	}

	/**
	 * @return is this part in shapes mode
	 */
	static public boolean isShapesMode(EditPart ep) {
		return getShapesCompartment(ep) != null;
	}

	/**
	 * @return contained shapes container else null
	 */
	static public IGraphicalEditPart getShapesCompartment(EditPart ep) {
		IGraphicalEditPart shapesCompartmentEP = null;
		if (ep instanceof DeployShapeNodeEditPart) {
			DeployShapeNodeEditPart dep = (DeployShapeNodeEditPart) ep;
			shapesCompartmentEP = dep
					.getChildBySemanticHint(DeployCoreConstants.HYBRIDSHAPES_SEMANTICHINT);
			if (shapesCompartmentEP == null) {
				shapesCompartmentEP = dep
						.getChildBySemanticHint(DeployCoreConstants.IMPORTTOPOLOGYSHAPES_SEMANTICHINT);
			}
			if (shapesCompartmentEP == null) {
				shapesCompartmentEP = dep
						.getChildBySemanticHint(DeployCoreConstants.DIAGRAMNODESHAPES_SEMANTICHINT);
			}
		}
		return shapesCompartmentEP;
	}

	/**
	 * @return any EditParts attached to this EditPart
	 */
	public boolean isInSnapGroup() {
		View snapGroup = getOwnerSnapGroup();
		return snapGroup != null && SnapViewCommand.getMemberSize(snapGroup) > 1;
	}

	/**
	 * @return any EditParts attached to this EditPart
	 */
	public View getOwnerSnapGroup() {
		EObject eo = getOwnerSnapRow();
		if (eo instanceof View) {
			View row = (View) eo;
			// make sure this row isn't corrupted
			DeployStyle style = (DeployStyle) row.getStyle(DeployNotationPackage.eINSTANCE
					.getDeployStyle());
			if (style != null && style.getSnapChildren().contains(getNotationView())) {
				return (View) ((View) eo).eContainer();
			}
		}
		return null;
	}

	/**
	 * @return any EditParts attached to this EditPart
	 */
	public View getOwnerSnapRow() {
		DeployStyle style = (DeployStyle) getNotationView().getStyle(
				DeployNotationPackage.eINSTANCE.getDeployStyle());
		if (style != null && style.getSnapParent() instanceof View) {
			return style.getSnapParent();
		}
		return null;
	}

	// make getViewer more robust
	@Override
	public EditPartViewer getViewer() {
		if (getRoot() != null) {
			return super.getViewer();
		}
		DeployCoreEditor editor = ResourceUtils.getActiveDeployEditDomain();
		if (editor != null) {
			return editor.getDiagramGraphicalViewer();
		}
		return null;
	}

}
