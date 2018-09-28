/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DecorationEditPolicy.DecoratorTarget;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.ISharedImages;
import com.ibm.ccl.soa.deploy.core.ui.Messages;
import com.ibm.ccl.soa.deploy.core.ui.decorators.ContractDecorator;
import com.ibm.ccl.soa.deploy.core.ui.dialogs.ContractDialog;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployGraphicalViewer;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployShapeNodeEditPart;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.CompositeShapeFigure;
import com.ibm.ccl.soa.deploy.core.ui.figures.core.DeployDecoratorFigure;
import com.ibm.ccl.soa.deploy.core.ui.properties.PropertyUtils;

/**
 */
public class ContractFigure extends DeployDecoratorFigure {

	private static final Cursor cursor = new Cursor(null, SWT.CURSOR_HAND);
	private DeployShapeNodeEditPart ownerEP = null;
	private final boolean isProxy;
	private final ContractDecorator _contractDecorator;
	private final Dimension _imageSize = new Dimension(MapModeUtil.getMapMode().DPtoLP(12),
			MapModeUtil.getMapMode().DPtoLP(12));

	Image image = null;
	private final Label tooltipLabel = new Label() {
		public Insets getInsets() {
			return new Insets(5);
		}
	};

	/**
	 * @param contract
	 * @param modelObject
	 * @param decoratorTarget
	 * @param contractDecorator
	 */
	public ContractFigure(ConfigurationContract contract, DeployModelObject modelObject,
			DecoratorTarget decoratorTarget, ContractDecorator contractDecorator) {
		super(decoratorTarget);
		ownerEP = (DeployShapeNodeEditPart) decoratorTarget.getAdapter(GraphicalEditPart.class);
		_contractDecorator = contractDecorator;
		setContract(contract, modelObject);
		isProxy = PropertyUtils.isProxy(modelObject);
	}

	/**
	 * @param contract
	 * @param modelObject
	 */
	public void setContract(ConfigurationContract contract, DeployModelObject modelObject) {
		String tooltip = Messages.ContractFigure_Contract_Status_ + " "; //$NON-NLS-1$
		if (contract != null) {
			//Config contract
			if (contract.isPublicEditable(modelObject)) {
				image = DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
						ISharedImages.IMG_CONTRACT_PUBLIC_EDITABLE);
				tooltip += Messages.AttributesDecorator_Public_Editable_;
			} else if (contract.isPublic(modelObject)) {
				image = DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
						ISharedImages.IMG_CONTRACT_PUBLIC);
				tooltip += Messages.AttributesDecorator_Public_;
			} else if (contract.isVisible(modelObject)) {
				image = DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
						ISharedImages.IMG_CONTRACT_PRIVATE_WITH_PUBLIC);
				tooltip += Messages.AttributesDecorator_Private_with_Public;
			} else {
				image = DeployCoreUIPlugin.getDefault().getSharedImages().getImage(
						ISharedImages.IMG_CONTRACT_PRIVATE);
				tooltip += Messages.AttributesDecorator_Private_;
			}
		}
		// don't refresh if the same
		if (!tooltipLabel.getText().equals(tooltip)) {
			tooltipLabel.setText(tooltip);
			setToolTip(tooltipLabel);
			setVisible(true);
			revalidate();
			repaint();
		}
	}

	@Override
	public Dimension getPreferredSize(int hint, int hint2) {
		return _imageSize;
	}

	protected void paintFigure(Graphics graphics) {
		if (image != null) {
			graphics.drawImage(image, getBounds().x, getBounds().y);
		}
	}

	public Cursor getCursor() {
		if (!ownerEP.isDragInProgress() && !isProxy) {
			return cursor;
		}
		return super.getCursor();
	}

	@Override
	public boolean handleButtonUp(int button) {
		// ignore all but left button
		if (button != 1) {
			return false;
		}

		// ignore if highlight has yet been created on figure (to avoid random clicks)
		if (getOwnerFigure() instanceof CompositeShapeFigure) {
			if (!((CompositeShapeFigure) getOwnerFigure()).isEnableDecoratorButton()) {
				return true;
			}
		}

		// kill tooltips
		setToolTip(null);
		((DeployGraphicalViewer) ownerEP.getViewer()).closeToolTip();

		if (isProxy) {
			return true;
		}

		// calc dialog location
		Point p = new Point(getBounds().getBottomLeft());
		translateToAbsolute(p);
		org.eclipse.swt.graphics.Point loc = p.getSWTPoint();
		final org.eclipse.swt.graphics.Point pt = Display.getCurrent().map(
				ownerEP.getViewer().getControl(), null, loc);

		// open dialog
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				ContractDialog cd = new ContractDialog(Display.getCurrent().getShells()[0], ownerEP,
						pt, _contractDecorator);
				cd.open();
			}
		});
		return true;

	}

}
