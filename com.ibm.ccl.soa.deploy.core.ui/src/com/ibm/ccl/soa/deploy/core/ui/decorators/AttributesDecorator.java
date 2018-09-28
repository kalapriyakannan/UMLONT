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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.widgets.Display;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.InstallState;
import com.ibm.ccl.soa.deploy.core.PublishIntent;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.actions.FilterPreferenceAction;
import com.ibm.ccl.soa.deploy.core.ui.figures.AttributesFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployCoreFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployListItemFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.CompositeShapeFigure;
import com.ibm.ccl.soa.deploy.core.ui.preferences.IDeployPreferences;
import com.ibm.ccl.soa.deploy.core.ui.providers.DeployDecoratorProvider;
import com.ibm.ccl.soa.deploy.core.ui.util.GEFUtils;

/**
 * @see DeployDecoratorProvider
 * @see AttributesFigure
 */
public class AttributesDecorator extends DeployDecorator implements IPropertyChangeListener {
	protected EContentAdapter _contentAdapter = null;
	private boolean isActivated = false;
	private boolean isInList = false;
	private Map<String, AttributesFigure.AttributeIcon> cache;
	private AttributesFigure attributesFigure = null;
	static final int Q = MapModeUtil.getMapMode().DPtoLP(1);

	/**
	 * Create an error decorator.
	 * 
	 * @param decoratorTarget
	 */
	public AttributesDecorator(IDecoratorTarget decoratorTarget) {
		super(decoratorTarget);
		// determine if this is an inner hosting list
		final GraphicalEditPart editpart = (GraphicalEditPart) decoratorTarget
				.getAdapter(GraphicalEditPart.class);
		IFigure figure = editpart.getFigure();
		isInList = figure instanceof CompositeShapeFigure
				&& ((CompositeShapeFigure) figure).getInnerFigure() instanceof DeployListItemFigure;
	}

	/**
	 * ============== ACTIVATE ================================================================
	 */
	public void activate() {
		DeployModelObject deployObject = getDeployObject(true);
		if (deployObject == null) {
			return;
		}
		isActivated = true;
		addListener(deployObject);
		refreshStatus(deployObject);
		DeployCoreUIPlugin.getDefault().getPreferenceStore().addPropertyChangeListener(this);
	}

	/*
	 * listen to changes to the element that this errormarker represents and if theres a
	 * modification, call refresh()
	 */
	private void addListener(DeployModelObject deployObject) {
		_contentAdapter = new EContentAdapter() {
			public void notifyChanged(final Notification notification) {
				super.notifyChanged(notification);
				if (notification.getNewValue() instanceof InstallState
						|| notification.getNewValue() instanceof PublishIntent) {
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
		removeDecoration();
		clearCache();
		DeployCoreUIPlugin.getDefault().getPreferenceStore().removePropertyChangeListener(this);
		super.deactivate();
	}

	private void clearCache() {
		if (cache != null) {
			cache.clear();
			cache = null;
		}

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
		if (event.getProperty().equals(IDeployPreferences.DEPLOY_FILTER_ATTRIBUTES)) {
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
		// is user filtering?
		final EditPart editpart = (GraphicalEditPart) getDecoratorTarget().getAdapter(
				GraphicalEditPart.class);
		if (FilterPreferenceAction.isFiltered(IDeployPreferences.DEPLOY_FILTER_ATTRIBUTES,
				(IGraphicalEditPart) editpart)) {
			hideFigure();
			return;
		}

		if (!(deployObject instanceof Unit)) {
			hideFigure();
			return;
		}
		Unit unit = (Unit) deployObject;

		// *** also make sure to update the listerner above too ***
		List<AttributesFigure.AttributeIcon> attributesList = new ArrayList<AttributesFigure.AttributeIcon>();

		//Install States 
		if (unit.getGoalInstallState().getValue() == InstallState.NOT_INSTALLED) {
			if (unit.getInitInstallState().getValue() == InstallState.INSTALLED) {
				attributesList.add(getCache().get(ISharedImages.IMG_INSTALL_UNINSTALL));
			} else if (unit.getInitInstallState().getValue() == InstallState.NOT_INSTALLED) {
				attributesList.add(getCache().get(ISharedImages.IMG_UNINSTALLED));
			} else if (unit.getInitInstallState().getValue() == InstallState.UNKNOWN) {
				attributesList.add(getCache().get(ISharedImages.IMG_UNKNOWN_UNINSTALL));
			}
		} else if (unit.getGoalInstallState().getValue() == InstallState.INSTALLED) {
			if (unit.getInitInstallState().getValue() == InstallState.NOT_INSTALLED) {
				attributesList.add(getCache().get(ISharedImages.IMG_UNINSTALL_INSTALL));
			} else if (unit.getInitInstallState().getValue() == InstallState.INSTALLED) {
				attributesList.add(getCache().get(ISharedImages.IMG_INSTALLED));
			} else if (unit.getInitInstallState().getValue() == InstallState.UNKNOWN) {
				attributesList.add(getCache().get(ISharedImages.IMG_UNKNOWN_INSTALL));
			}
		} else if (unit.getGoalInstallState().getValue() == InstallState.UNKNOWN) {
			if (unit.getInitInstallState().getValue() == InstallState.NOT_INSTALLED) {
				attributesList.add(getCache().get(ISharedImages.IMG_UNINSTALLED_UNKNOWN));
			} else if (unit.getInitInstallState().getValue() == InstallState.INSTALLED) {
				attributesList.add(getCache().get(ISharedImages.IMG_INSTALLED_UNKNOWN));
			} else if (unit.getInitInstallState().getValue() == InstallState.UNKNOWN) {
				// Don't add explicit icon for install state when its (UNKNOWN, UNKNOWN)
			}
		}

		//Publish State
		if (unit.getPublishIntent().getValue() == PublishIntent.DO_NOT_PUBLISH) {
			attributesList.add(getCache().get(ISharedImages.IMAGE_PUBLISH_ATTRIBUTE));
		}

		//Bound State
		if (unit.isBound()) {
			attributesList.add(getCache().get(ISharedImages.IMG_BOUND_STATE));
		}

		// keep a place holder so figure can open attribute menu
		if (attributesList.size() == 0) {
			attributesList.add(getCache().get(ISharedImages.IMG_NO_ATTRIBUTES));
		}

		if (attributesFigure == null) {
			attributesFigure = new AttributesFigure(attributesList, getDecoratorTarget());
			Locator locator = new Locator() {
				public void relocate(IFigure target) {
					IFigure parentFigure = ((GraphicalEditPart) editpart).getFigure();
					Rectangle r = parentFigure.getBounds().getCopy();
					parentFigure.translateToAbsolute(r);
					target.translateToRelative(r);
					Dimension size = attributesFigure.getPreferredSize();
					r.x += r.width - size.width - 2 * Q;
					// if attribute is on a hosting list item we need to center it
					if (isInList) {
						int itemHeight = GEFUtils.getListItemHeight(parentFigure) / 2;
						r.y += itemHeight - size.height / 2;
						r.x -= MapModeUtil.getMapMode().DPtoLP(14);
					} else {
						r.y += r.height - size.height;
						if (parentFigure instanceof CompositeShapeFigure
								&& ((CompositeShapeFigure) parentFigure).getInnerFigure() instanceof DeployCoreFigure
								&& ((DeployCoreFigure) ((CompositeShapeFigure) parentFigure)
										.getInnerFigure()).isOverlapped()) {
							r.x -= 4 * Q;
						}
					}
					r.setSize(size);
					target.setBounds(r);
					attributesFigure.setSize(size);
				}
			};
			setDecoration(getDecoratorTarget().addDecoration(attributesFigure, locator, true));
		} else {
			attributesFigure.setList(attributesList);
		}
	}

	private void hideFigure() {
		if (attributesFigure != null) {
			attributesFigure.setVisible(false);
		}

	}

	private Map<String, AttributesFigure.AttributeIcon> getCache() {

		if (cache == null) {
			cache = new HashMap<String, AttributesFigure.AttributeIcon>();
		}

		String installState = Messages.AttributesDecorator_Install_State_;
		ISharedImages sharedImages = DeployCoreUIPlugin.getDefault().getSharedImages();

		// 0: uninstalled > installed
		String message = installState
				+ com.ibm.ccl.soa.deploy.core.ui.properties.Messages.GeneralDmoSyncHelperModel_uninstalled_installed_;//0
		cache.put(ISharedImages.IMG_UNINSTALL_INSTALL, new AttributesFigure.AttributeIcon(
				sharedImages.getImage(ISharedImages.IMG_UNINSTALL_INSTALL), message));

		// 1: installed > uninstalled
		message = installState
				+ com.ibm.ccl.soa.deploy.core.ui.properties.Messages.GeneralDmoSyncHelperModel_installed_uninstalled_;//1
		cache.put(ISharedImages.IMG_INSTALL_UNINSTALL, new AttributesFigure.AttributeIcon(
				sharedImages.getImage(ISharedImages.IMG_INSTALL_UNINSTALL), message));

		// 2: installed > installed
		message = installState
				+ com.ibm.ccl.soa.deploy.core.ui.properties.Messages.GeneralDmoSyncHelperModel_installed_;//2
		cache.put(ISharedImages.IMG_INSTALLED, new AttributesFigure.AttributeIcon(sharedImages
				.getImage(ISharedImages.IMG_INSTALLED), message));

		// 3: uninstalled > uninstalled
		message = installState
				+ com.ibm.ccl.soa.deploy.core.ui.properties.Messages.GeneralDmoSyncHelperModel_uninstalled_;//3
		cache.put(ISharedImages.IMG_UNINSTALLED, new AttributesFigure.AttributeIcon(sharedImages
				.getImage(ISharedImages.IMG_UNINSTALLED), message));

		// 4: unknown > unknown (no icon)

		// 5: unknown > installed
		message = installState
				+ com.ibm.ccl.soa.deploy.core.ui.properties.Messages.GeneralDmoSyncHelperModel_unknown_installed_;//5
		cache.put(ISharedImages.IMG_UNKNOWN_INSTALL, new AttributesFigure.AttributeIcon(sharedImages
				.getImage(ISharedImages.IMG_UNKNOWN_INSTALL), message));

		// 6: unknown > uninstalled
		message = installState
				+ com.ibm.ccl.soa.deploy.core.ui.properties.Messages.GeneralDmoSyncHelperModel_unknown_uninstalled_;//6
		cache.put(ISharedImages.IMG_UNKNOWN_UNINSTALL, new AttributesFigure.AttributeIcon(
				sharedImages.getImage(ISharedImages.IMG_UNKNOWN_UNINSTALL), message));

		// 7: installed > unknown
		message = installState
				+ com.ibm.ccl.soa.deploy.core.ui.properties.Messages.GeneralDmoSyncHelperModel_installed_unknown_;//7
		cache.put(ISharedImages.IMG_INSTALLED_UNKNOWN, new AttributesFigure.AttributeIcon(
				sharedImages.getImage(ISharedImages.IMG_INSTALLED_UNKNOWN), message));

		// 8: uninstalled > unknown
		message = installState
				+ com.ibm.ccl.soa.deploy.core.ui.properties.Messages.GeneralDmoSyncHelperModel_uninstalled_unknown_;//8
		cache.put(ISharedImages.IMG_UNINSTALLED_UNKNOWN, new AttributesFigure.AttributeIcon(
				sharedImages.getImage(ISharedImages.IMG_UNINSTALLED_UNKNOWN), message));

		// Publish state
		cache.put(ISharedImages.IMAGE_PUBLISH_ATTRIBUTE,
				new AttributesFigure.AttributeIcon(sharedImages
						.getImage(ISharedImages.IMAGE_PUBLISH_ATTRIBUTE), Messages.DoNotPublishUnit));
		cache.put(ISharedImages.IMG_BOUND_STATE, new AttributesFigure.AttributeIcon(sharedImages
				.getImage(ISharedImages.IMG_BOUND_STATE), Messages.AttributesDecorator_Unit_is_boun_));
		cache
				.put(ISharedImages.IMG_NO_ATTRIBUTES, new AttributesFigure.AttributeIcon(sharedImages
						.getImage(ISharedImages.IMG_NO_ATTRIBUTES),
						Messages.AttributesDecorator_No_Attribute_));

		return cache;
	}

}
