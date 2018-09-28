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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.widgets.Display;

import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.actions.FilterPreferenceAction;
import com.ibm.ccl.soa.deploy.core.ui.figures.AttributesFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.ContractFigure;
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
public class ContractDecorator extends DeployDecorator implements IPropertyChangeListener {

	private boolean isActivated = false;
	private boolean isInList = false;
	private static final int Q = MapModeUtil.getMapMode().DPtoLP(1);
	private ContractFigure contractFigure = null;
	private boolean refreshingStatus = false;

	/**
	 * Create an error decorator.
	 * 
	 * @param decoratorTarget
	 */
	public ContractDecorator(IDecoratorTarget decoratorTarget) {
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
		isActivated = true;
		DeployModelObject deployObject = getDeployObject();
		if (deployObject == null) {
			return;
		}
		refreshStatus(deployObject);
		DeployCoreUIPlugin.getDefault().getPreferenceStore().addPropertyChangeListener(this);
	}

	/**
	 * ============= DEACTIVATE=================================================================
	 */
	public void deactivate() {
		isActivated = false;
		removeDecoration();
		DeployCoreUIPlugin.getDefault().getPreferenceStore().removePropertyChangeListener(this);
		super.deactivate();
	}

	/**
	 * ================ REFRESH STATUS IN DECORATION=============================================
	 */

	/**
	 * ============= PROPERTY LISTENER===========================
	 */

	public void propertyChange(PropertyChangeEvent event) {
		if (event.getProperty().equals(IDeployPreferences.DEPLOY_FILTER_CONTRACTS)
				|| event.getProperty().equals(IDeployPreferences.DEPLOY_FILTER_TYPE_NAMES)) {
			refresh();
		}
	}

	public void refresh() {
		if (!refreshingStatus) {
			refreshingStatus = true;
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					try {
						refreshHelper();
					} finally {
						refreshingStatus = false;
					}
				}
			});
		}
	}

	private void refreshHelper() {
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
		// is user filtering contracts? 
		final EditPart editpart = (GraphicalEditPart) getDecoratorTarget().getAdapter(
				GraphicalEditPart.class);
		if (FilterPreferenceAction.isFiltered(IDeployPreferences.DEPLOY_FILTER_CONTRACTS,
				(IGraphicalEditPart) editpart)
				|| FilterPreferenceAction.isFiltered(IDeployPreferences.DEPLOY_FILTER_TYPE_NAMES,
						(IGraphicalEditPart) editpart)) {
			if (contractFigure != null) {
				contractFigure.setVisible(false);
			}
			return;
		}

		if (deployObject.getTopology() != null) {
			if (deployObject instanceof Unit || deployObject instanceof Import) {
				Locator locator = new Locator() {
					public void relocate(IFigure target) {
						IFigure parentFigure = ((GraphicalEditPart) editpart).getFigure();
						Rectangle r = parentFigure.getBounds().getCopy();
						parentFigure.translateToAbsolute(r);
						target.translateToRelative(r);

						if (!isInList) {
							r.y += MapModeUtil.getMapMode().DPtoLP(DeployCoreFigure.CATEGORYHEIGHT) + Q;
							if (parentFigure instanceof CompositeShapeFigure) {
								DeployCoreFigure fig = (DeployCoreFigure) ((CompositeShapeFigure) parentFigure)
										.getInnerFigure();
								r.x += (r.width - fig.getCategoryWidth()) / 2 - 10 * Q;
							} else {
								r.x += 25 * Q;
							}
						} else {
							r.x += r.width - 14 * Q;
							int itemHeight = GEFUtils.getListItemHeight(parentFigure) / 2;
							r.y += itemHeight - MapModeUtil.getMapMode().DPtoLP(8);
						}
						Dimension size = contractFigure.getPreferredSize();
						r.setSize(size);
						target.setBounds(r);
						contractFigure.setSize(size);
					}
				};

				ConfigurationContract contract = deployObject.getTopology().getConfigurationContract();
				if (contractFigure == null) {
					contractFigure = new ContractFigure(contract, deployObject, getDecoratorTarget(),
							this);
					setDecoration(getDecoratorTarget().addDecoration(contractFigure, locator, true));
				} else {
					contractFigure.setContract(contract, deployObject);
				}

			}
		}
	}

	/**
	 * =======================HELPER =======================================================
	 */

	private DeployModelObject getDeployObject() {
		View view = (View) getDecoratorTarget().getAdapter(View.class);
		if (view == null) {
			return null;
		}
		EObject element = view.getElement();
		if (!(element instanceof DeployModelObject)) {
			return null;
		}

		return (DeployModelObject) element;
	}

}
