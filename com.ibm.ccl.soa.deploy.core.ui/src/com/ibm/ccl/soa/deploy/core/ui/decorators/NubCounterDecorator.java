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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.progress.UIJob;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.actions.FilterPreferenceAction;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployGraphicalViewer;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployCoreFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployListItemFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.NubCounterFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.CompositeShapeFigure;
import com.ibm.ccl.soa.deploy.core.ui.preferences.IDeployPreferences;
import com.ibm.ccl.soa.deploy.core.ui.requests.CreateNubEditPopupRequest;

/**
 * @see NubCounterFigure
 */
public class NubCounterDecorator extends DeployDecorator implements IPropertyChangeListener {

	protected EContentAdapter _contentAdapter = null;
	private MouseListener _mouseListener;
	private final Object lock = new Object();
	private boolean isActivated = false;
	private boolean isInList = false;
	private boolean isInDecorator = false;
	private NubCounterFigure nubFigure = null;
	static final int Q = MapModeUtil.getMapMode().DPtoLP(1);

	/**
	 * @param decoratorTarget
	 */
	public NubCounterDecorator(IDecoratorTarget decoratorTarget) {
		super(decoratorTarget);
		// determine if this is an inner hosting list
		GraphicalEditPart editpart = (GraphicalEditPart) decoratorTarget
				.getAdapter(GraphicalEditPart.class);
		IFigure figure = editpart.getFigure();
		isInList = figure instanceof CompositeShapeFigure
				&& ((CompositeShapeFigure) figure).getInnerFigure() instanceof DeployListItemFigure;
		isInDecorator = this instanceof NubInCounterDecorator;
	}

	/**
	 * ============== ACTIVATE ================================================================
	 */
	public void activate() {
		isActivated = true;
		DeployModelObject deployObject = getDeployObject(true);
		if (deployObject == null) {
			return;
		}
		addListener(deployObject);
		refreshStatus(deployObject);
		DeployCoreUIPlugin.getDefault().getPreferenceStore().addPropertyChangeListener(this);
	}

	/*
	 * listen to changes to the element that this nub counter represents and if theres a
	 * modification, call refresh()
	 */
	private void addListener(DeployModelObject deployObject) {
		_contentAdapter = new EContentAdapter() {
			public void notifyChanged(final Notification notification) {
				super.notifyChanged(notification);
				int type = notification.getEventType();
				if (type == Notification.ADD || type == Notification.REMOVING_ADAPTER) {
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
		deployObject.eAdapters().add(_contentAdapter);
	}

	/**
	 * ============= DEACTIVATE=================================================================
	 */
	public void deactivate() {
		isActivated = false;
		DeployModelObject deployObject = getDeployObject(false);
		if (deployObject != null) {
			removeListener(deployObject);
		}
		DeployCoreUIPlugin.getDefault().getPreferenceStore().removePropertyChangeListener(this);
		super.deactivate();
	}

	private void removeListener(DeployModelObject deployObject) {
		if (_contentAdapter != null) {
			deployObject.eAdapters().remove(_contentAdapter);
		}
		_contentAdapter = null;
	}

	/**
	 * ============= PROPERTY LISTENER===========================
	 */

	public void propertyChange(PropertyChangeEvent event) {
		if (event.getProperty().equals(IDeployPreferences.DEPLOY_FILTER_NUBS)) {
			refresh();
		}
	}

	/**
	 * ================ REFRESH STATUS IN DECORATION=============================================
	 */
	public void refresh() {
		if (!isActivated) {
			return;
		}
		View view = (View) getDecoratorTarget().getAdapter(View.class);
		if (view == null) {
			return;
		}
		EObject element = view.getElement();
		if (!(element instanceof DeployModelObject)) {
			return;
		}

		DeployModelObject deployObject = (DeployModelObject) element;
		refreshStatus(deployObject);
	}

	private void refreshStatus(DeployModelObject deployObject) {

		final EditPart editpart = (GraphicalEditPart) getDecoratorTarget().getAdapter(
				GraphicalEditPart.class);
		if (editpart.isActive()) {
			// is user filtering?
			if (FilterPreferenceAction.isFiltered(IDeployPreferences.DEPLOY_FILTER_NUBS,
					(IGraphicalEditPart) editpart)) {
				hideFigure();
				return;
			}

			// this decorator doesn't appear in list
			if (isInList) {
				hideFigure();
				return;
			}

			if (nubFigure == null) {
				nubFigure = new NubCounterFigure(deployObject, isInDecorator, getDecoratorTarget());
				nubFigure.addMouseListener(getMouseListener());
				Locator locator = new Locator() {
					public void relocate(IFigure target) {
						IFigure parentFigure = ((GraphicalEditPart) editpart).getFigure();
						Rectangle r = parentFigure.getBounds().getCopy();
						parentFigure.translateToAbsolute(r);
						target.translateToRelative(r);
						Dimension size = nubFigure.getPreferredSize();
						if (isInDecorator) {
							r.x += 2 * Q;
						} else {
							r.x += r.width - size.width - Q;
							if (parentFigure instanceof CompositeShapeFigure
									&& ((CompositeShapeFigure) parentFigure).getInnerFigure() instanceof DeployCoreFigure
									&& ((DeployCoreFigure) ((CompositeShapeFigure) parentFigure)
											.getInnerFigure()).isOverlapped()) {
								r.x -= 4 * Q;
							}
						}
						r.y += 2 * Q;
						r.setSize(size);
						target.setBounds(r);
						nubFigure.setSize(size);
					}
				};
				setDecoration(getDecoratorTarget().addDecoration(nubFigure, locator, true));
			} else {
				nubFigure.setCount(deployObject);
			}

		}
	}

	private void hideFigure() {
		if (nubFigure != null) {
			nubFigure.setVisible(false);
		}
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
		EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(EditPart.class);

		DeployModelObject deployObject = getDeployObject(true);
		if (deployObject != null) {

			org.eclipse.draw2d.geometry.Point pt = new org.eclipse.draw2d.geometry.Point(me.x, me.y);
			Object source = me.getSource();
			if (source instanceof NubCounterFigure) {
				NubCounterFigure figure = (NubCounterFigure) source;
				pt = figure.getBounds().getBottomRight().getCopy();
				figure.translateToAbsolute(pt);
				org.eclipse.swt.graphics.Point p = new org.eclipse.swt.graphics.Point(0, 0);
				p = editPart.getViewer().getControl().toDisplay(p);
				pt.x += p.x;
				pt.y += p.y;
			}

			((DeployGraphicalViewer) editPart.getViewer()).closeToolTip();

			CreateNubEditPopupRequest request = new CreateNubEditPopupRequest(deployObject, editPart,
					isInDecorator, new Point(pt.x, pt.y));
			final Command cmd = editPart.getCommand(request);
			if (cmd != null && cmd.canExecute()) {
				new UIJob(Messages.ErrorMarkerDecorator_Calculating_quickfixes_) {
					public IStatus runInUIThread(IProgressMonitor monitor) {
						cmd.execute();
						return Status.OK_STATUS;
					}
				}.schedule();
			}
		}

	}

}
