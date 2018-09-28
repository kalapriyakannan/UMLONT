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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.handles.AbstractHandle;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;

import com.ibm.ccl.soa.deploy.core.ui.providers.DeploySemanticType;
import com.ibm.ccl.soa.deploy.core.ui.tools.ConstraintLinkCreationTool;
import com.ibm.ccl.soa.deploy.core.ui.tools.DependencyLinkCreationTool;
import com.ibm.ccl.soa.deploy.core.ui.tools.HostingLinkCreationTool;
import com.ibm.ccl.soa.deploy.core.ui.tools.RealizationLinkCreationTool;
import com.ibm.ccl.soa.deploy.core.ui.util.DeployCoreImages;

/**
 * This is the deploy lolly figure used to represent a connection handle.
 */
public class DeployLollipopFigure extends AbstractHandle {

	/**
	 * An enumeration of lolly types. CONSUMEHOST = a Unit that needs to be deployed to a Host Unit
	 * CONSUMESERVICE = a Unit that needs to consume a Capability on another Unit
	 */
	public static final class LollyType {
		private LollyType() {
			// empty
		}

		/** a Unit that needs to be deployed to a Host Unit */
		public static final LollyType HOSTING = new LollyType();

		/** a Unit that needs to consume a Capability on another Unit */
		public static final LollyType DEPENDENCY = new LollyType();

		/** a Unit that needs to consume a Capability on another Unit */
		public static final LollyType REALIZATION = new LollyType();

		/** a Unit that needs to consume a Capability on another Unit */
		public static final LollyType CONSTRAINT = new LollyType();
	}

	/** direction that the relationship is to be created */
	private LollyType lollyType;

	private final Dimension _imageSize = new Dimension(0, 0);;

	/**
	 * Creates a new <code>ConnectionHandle</code>.
	 * 
	 * @param ownerEditPart
	 *           the editpart for which the handle belongs
	 * @param lollyType
	 *           direction that the relationship is to be created
	 * @param tooltip
	 *           the tooltip
	 * @param isExtendLolly
	 */
	public DeployLollipopFigure(IGraphicalEditPart ownerEditPart, LollyType lollyType, String tooltip) {

		setOwner(ownerEditPart);
		setLollyType(lollyType);
		setToolTip(new Label(tooltip));

		// A stack layout is used so that the error icon can be overlayed on top.
		setLayoutManager(new StackLayout());

		// add ImageFigure with will draw the pop
		Image image;
		if (lollyType == LollyType.HOSTING) {
			image = DeployCoreImages.CONSUMEHOSTLOLLY__IMAGE;
		} else if (lollyType == LollyType.DEPENDENCY) {
			// when language is set to right-to-left, bounds are backwards too
			if (Window.getDefaultOrientation() == SWT.RIGHT_TO_LEFT) {
				image = DeployCoreImages.CONSUMESERVICELOLLY__LEFTIMAGE;
			} else {
				image = DeployCoreImages.CONSUMESERVICELOLLY__IMAGE;
			}
		} else if (lollyType == LollyType.REALIZATION) {
			image = DeployCoreImages.CONSUMEREALIZATIONLOLLY__IMAGE;
		} else if (lollyType == LollyType.CONSTRAINT) {
			image = DeployCoreImages.CONSTRAINTLOLLY__IMAGE;
		} else {
			image = null;
		}
		if (image != null) {
			ImageFigure imageFigure = new ImageFigure(image);
			add(imageFigure);
			_imageSize.width = image.getBounds().width;
			_imageSize.height = image.getBounds().height;
		}
	}

	/**
	 * @see org.eclipse.gef.handles.AbstractHandle#createDragTracker()
	 */
	protected DragTracker createDragTracker() {
		if (lollyType == LollyType.HOSTING) {
			return new HostingLinkCreationTool(DeploySemanticType.HOSTINGLINK);
		} else if (lollyType == LollyType.DEPENDENCY) {
			return new DependencyLinkCreationTool(DeploySemanticType.DEPENDENCYLINK);
		} else if (lollyType == LollyType.REALIZATION) {
			return new RealizationLinkCreationTool(DeploySemanticType.REALIZATIONLINK);
		} else if (lollyType == LollyType.CONSTRAINT) {
			return new ConstraintLinkCreationTool(DeploySemanticType.CONSTRAINTLINK);
		}
		return new HostingLinkCreationTool(DeploySemanticType.HOSTINGLINK);
	}

	/**
	 * @see org.eclipse.draw2d.IFigure#findFigureAt(int, int, org.eclipse.draw2d.TreeSearch)
	 */
	public IFigure findFigureAt(int x, int y, TreeSearch search) {
		// return the ConnectionHandle and not the children figures
		if (containsPoint(x, y)) {
			return this;
		}
		return super.findFigureAt(x, y, search);
	}

	/**
	 * Make public.
	 * 
	 * @see org.eclipse.gef.handles.AbstractHandle#setLocator(org.eclipse.draw2d.Locator)
	 */
	public void setLocator(Locator locator) {
		super.setLocator(locator);
	}

	/**
	 * Make public.
	 * 
	 * @see org.eclipse.gef.handles.AbstractHandle#getOwner()
	 */
	public GraphicalEditPart getOwner() {
		return super.getOwner();
	}

	/**
	 * Sets the direction that the relationship is to be created.
	 * 
	 * @param direction
	 *           the <code>HandleDirection</code> that the relationship is to be created
	 */
	protected void setLollyType(LollyType type) {
		lollyType = type;
	}

	/**
	 * gets the lolly type
	 * 
	 * @return Lollytype
	 */
	public LollyType getLollyType() {
		return lollyType;
	}

	public Dimension getImageSize() {
		return _imageSize;
	}

}
