/***************************************************************************************************
 * Copyright (c) 2003, 2008 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.figures;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.geometry.PrecisionPointList;
import org.eclipse.gmf.runtime.gef.ui.figures.SlidableAnchor;

import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployConnectionNodeEditPart;

/**
 * @since 7.0
 * 
 */
public class DeploySlidableAnchor extends SlidableAnchor {

	private final ConnectionEditPart _connectionEP;

	/**
	 * @param f
	 * @param connectionEP
	 */
	public DeploySlidableAnchor(IFigure f, ConnectionEditPart connectionEP) {
		super(f);
		_connectionEP = connectionEP;
	}

	@Override
	protected Rectangle getBox() {
		Rectangle rBox = super.getBox();
		if (DeployConnectionNodeEditPart.isInnerSnapLink(_connectionEP)) {
			rBox.shrink(10, 10);
		}
		return rBox;
	}

	protected PointList getPolygonPoints() {
		PrecisionRectangle r = new PrecisionRectangle(getBox());
		PrecisionPointList ptList = new PrecisionPointList(5);
		ptList.addPoint(new PrecisionPoint(r.preciseX, r.preciseY));
		ptList.addPoint(new PrecisionPoint(r.preciseX + r.preciseWidth, r.preciseY));
		ptList
				.addPoint(new PrecisionPoint(r.preciseX + r.preciseWidth, r.preciseY + r.preciseHeight));
		ptList.addPoint(new PrecisionPoint(r.preciseX, r.preciseY + r.preciseHeight));
		ptList.addPoint(new PrecisionPoint(r.preciseX, r.preciseY));
		return ptList;
	}

}
