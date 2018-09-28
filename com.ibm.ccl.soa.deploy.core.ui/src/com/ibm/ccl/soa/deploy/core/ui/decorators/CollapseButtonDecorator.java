/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.decorators;

import java.util.Map;

import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.DrawerStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.NodeImpl;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;

import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployCollapseFigure;
import com.ibm.ccl.soa.deploy.core.ui.internal.commands.CollapseCommand;
import com.ibm.ccl.soa.deploy.core.ui.properties.LightweightOperationFactory;
import com.ibm.ccl.soa.deploy.core.ui.properties.Messages;
import com.ibm.ccl.soa.deploy.core.ui.providers.DeployDecoratorProvider;
import com.ibm.ccl.soa.deploy.core.ui.util.GMFUtils;

/**
 * @see DeployDecoratorProvider
 */
public abstract class CollapseButtonDecorator extends DeployDecorator {

	protected EContentAdapter _contentAdapterView = null;
	protected EContentAdapter _contentAdapterObject = null;
	private MouseListener _mouseListener;
	private final Object lock = new Object();
	protected DeployCollapseFigure collapseFigure = null;

	private boolean isActivated = false;

	/**
	 * @param decoratorTarget
	 */
	public CollapseButtonDecorator(IDecoratorTarget decoratorTarget) {
		super(decoratorTarget);
	}

	/**
	 * ============== ACTIVATE ================================================================
	 */
	public void activate() {
		View view = getCompartmentView();
		if (view == null) {
			return;
		}
		EObject object = getEObject(true);
		if (object == null) {
			return;
		}
		isActivated = true;
		addViewListener(view);
		addObjectListener(object);
		refreshStatus(view, object);

	}

	/*
	 * listen to changes to the element that this errormarker represents and if theres a
	 * modification, call refresh()
	 */
	private void addViewListener(View view) {
		_contentAdapterView = new EContentAdapter() {
			public void notifyChanged(final Notification notification) {
				super.notifyChanged(notification);
				int type = notification.getEventType();
				Object obj = notification.getNotifier();
				if (type == Notification.SET && obj instanceof DrawerStyle || type == Notification.ADD
						&& obj instanceof NodeImpl) {
					refresh();
					if (collapseFigure != null) {
						View compartmentView = getCompartmentView();
						if (compartmentView != null) {
							DrawerStyle style = (DrawerStyle) compartmentView
									.getStyle(NotationPackage.eINSTANCE.getDrawerStyle());
							boolean isCollapsed = style != null ? style.isCollapsed() : true;
							collapseFigure.setCollapsed(isCollapsed);
						}
					}
				}
			}
		};
		view.eAdapters().add(_contentAdapterView);
	}

	private void addObjectListener(EObject eObject) {
		_contentAdapterObject = new EContentAdapter() {
			public void notifyChanged(final Notification notification) {
				super.notifyChanged(notification);
				final int type = notification.getEventType();
				if (type == Notification.SET && notification.getNewValue() instanceof HostingLink
						|| type == Notification.REMOVE || type == Notification.ADD) {
					Display display = Display.getCurrent() != null ? Display.getCurrent() : Display
							.getDefault();
					display.asyncExec(new Runnable() {
						public void run() {
							refresh();
						}
					});
				}
			}
		};
		eObject.eAdapters().add(_contentAdapterObject);
	}

	/**
	 * ============= DEACTIVATE=================================================================
	 */
	public void deactivate() {
		isActivated = false;
		View view = getCompartmentView();
		if (view != null) {
			removeViewListener(view);
		}
		EObject eObject = getEObject(false);
		if (eObject != null) {
			removeObjectListener(eObject);
		}
		removeDecoration();
		super.deactivate();
	}

	private void removeViewListener(View view) {
		if (_contentAdapterView != null) {
			view.eAdapters().remove(_contentAdapterView);
		}
		_contentAdapterView = null;
	}

	private void removeObjectListener(EObject eObject) {
		if (_contentAdapterObject != null) {
			eObject.eAdapters().remove(_contentAdapterObject);
		}
		_contentAdapterObject = null;
	}

	/**
	 * ================ REFRESH STATUS IN DECORATION=============================================
	 */
	public void refresh() {
		if (!isActivated) {
			return;
		}
		View view = getCompartmentView();
		if (view == null) {
			return;
		}
		EObject object = getEObject(true);
		if (object == null) {
			return;
		}
		refreshStatus(view, object);
	}

	protected abstract void refreshStatus(View view, EObject object);

	// if the status on this shape element is an error, creates a MarkerFigure on the figure (with a listener that allows resolution)
	protected void addCollapsedDecoration(boolean isCollapsed) {
		if (collapseFigure == null) {
			collapseFigure = new DeployCollapseFigure(useTreeEmulation(), getDecoratorTarget());
			collapseFigure.setCollapsed(isCollapsed);
			collapseFigure.addMouseListener(getMouseListener());
			final GraphicalEditPart editpart = (GraphicalEditPart) getDecoratorTarget().getAdapter(
					GraphicalEditPart.class);
			Locator locator = getLocator(editpart);
			setDecoration(getDecoratorTarget().addDecoration(collapseFigure, locator, true));
		} else {
			collapseFigure.setVisible(true);
		}
	}

	protected void hideFigure() {
		if (collapseFigure != null) {
			collapseFigure.setVisible(false);
		}
	}

	protected abstract Locator getLocator(final GraphicalEditPart editpart);

	protected boolean useTreeEmulation() {
		return false;
	}

	// listen to decoration we add to edge or shape
	private MouseListener getMouseListener() {
		if (_mouseListener == null) {
			synchronized (lock) {
				if (_mouseListener == null) {
					_mouseListener = new MouseListener() {

						public void mousePressed(MouseEvent me) {
							if (isActivated) {
								onMousePressed(me);
							}
						}

						public void mouseReleased(MouseEvent me) {
						}

						public void mouseDoubleClicked(MouseEvent me) {
						}

					};
				}

			}
		}
		return _mouseListener;
	}

	// the command we execute when decoration is clicked
	protected void onMousePressed(MouseEvent me) {
		final GraphicalEditPart editpart = (GraphicalEditPart) getDecoratorTarget().getAdapter(
				GraphicalEditPart.class);
		// if on a bad part, just exit
		if (editpart.resolveSemanticElement() == null) {
			return;
		}
		// get its editpart
		EditPartViewer viewer = editpart.getViewer();
		Map map = viewer.getEditPartRegistry();
		View listVw = getCompartmentView();
		final GraphicalEditPart listEP = (GraphicalEditPart) map.get(listVw);

		DrawerStyle style = (DrawerStyle) listVw.getStyle(NotationPackage.eINSTANCE.getDrawerStyle());
		final boolean isCollapsed = !(style != null ? style.isCollapsed() : true);
		final String commandLabel = isCollapsed ? Messages.CapabilitiesPropertySection_Collaps_
				: Messages.CapabilitiesPropertySection_Expan_;

		if (listEP == null) {
			return;
		}

		BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {

			public void run() {
				CollapseCommand collapseCommand = new CollapseCommand(listEP.getEditingDomain(),
						listEP, isCollapsed);
				collapseCommand.setLabel(commandLabel);
				Diagram diagram = GMFUtils.getDiagram(editpart);
				if (diagram == null) {
					LightweightOperationFactory.execute(editpart.resolveSemanticElement(),
							collapseCommand);
				} else {
					LightweightOperationFactory.execute(diagram, collapseCommand);
				}
			}
		});

	}

	/**
	 * =======================HELPER =======================================================
	 */
	protected abstract View getCompartmentView();

}
