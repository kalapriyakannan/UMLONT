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
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;

import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.ui.decorators.ConstraintLinkDecoration;
import com.ibm.ccl.soa.deploy.core.ui.decorators.DependencyLinkDecoration;
import com.ibm.ccl.soa.deploy.core.ui.decorators.HostingLinkDecoration;
import com.ibm.ccl.soa.deploy.core.ui.decorators.RealizationLinkDecoration;
import com.ibm.ccl.soa.deploy.core.ui.editparts.ConsolidationLinkEditPart;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployConnectionNodeEditPart;

/**
 * This class is used to create figures.
 */
public class DeployCoreFigureFactory {
	/**
	 * 
	 * @param connectionEP
	 * @return PolylineConnectionEx
	 */
	public static PolylineConnectionEx createNewHostingLink(DeployConnectionNodeEditPart connectionEP) {
		PolylineConnectionEx conn = new HostingLinkConnection(connectionEP);
		conn.setLineStyle(Graphics.LINE_SOLID);
		conn.setLineWidth(1);
		conn.setSourceDecoration(new HostingLinkDecoration(true));
		conn.setTargetDecoration(new HostingLinkDecoration(false));
		return conn;
	}

	/**
	 * 
	 * @param connectionEP
	 * @return PolylineConnectionEx
	 */
	public static PolylineConnectionEx createNewConstraintLink(
			DeployConnectionNodeEditPart connectionEP) {
		if (ConstraintLinkConnection.isCollocation(connectionEP)
				|| ConstraintLinkConnection.isAnticollocation(connectionEP)) {
			PolylineConnectionEx conn = new ConstraintLinkConnection(connectionEP);
			conn.setLineStyle(Graphics.LINE_DASH);
			conn.setLineWidth(3);
			conn.setSourceDecoration(new ConstraintLinkDecoration(true));
			conn.setTargetDecoration(new ConstraintLinkDecoration(false));
			return conn;
		}

		if (ConstraintLinkConnection.isDeferredHosting(connectionEP)) {
			PolylineConnectionEx conn = new HostingLinkConnection(connectionEP);
			conn.setLineStyle(Graphics.LINE_DASH);
			conn.setLineWidth(1);
			conn.setSourceDecoration(new ConstraintLinkDecoration(true));
			conn.setTargetDecoration(new ConstraintLinkDecoration(false));
			return conn;
		}

		PolylineConnectionEx conn = new DependencyLinkConnection(connectionEP);
		conn.setLineStyle(Graphics.LINE_SOLID);
		conn.setLineWidth(1);
		conn.setSourceDecoration(new ConstraintLinkDecoration(true));
		conn.setTargetDecoration(new ConstraintLinkDecoration(false));
		return conn;
	}

	/**
	 * 
	 * @param connectionEP
	 * @return PolylineConnectionEx
	 */
	public static PolylineConnectionEx createNewDependencyLink(
			DeployConnectionNodeEditPart connectionEP) {
		PolylineConnectionEx conn = new DependencyLinkConnection(connectionEP);
		conn.setLineStyle(Graphics.LINE_SOLID);
		conn.setLineWidth(1);
		conn.setSourceDecoration(new DependencyLinkDecoration(true));
		conn.setTargetDecoration(new DependencyLinkDecoration(false));
		return conn;
	}

	/**
	 * @return UnitFigure
	 */
	public static NodeFigure createNewUnitFigure() {
		return new UnitFigure();
	}

	/**
	 * @param connectionEP
	 * @return Figure representing a {@link RealizationLink}
	 */
	public static PolylineConnectionEx createNewRealizationLink(
			DeployConnectionNodeEditPart connectionEP) {
		PolylineConnectionEx conn = new RealizationLinkConnection(connectionEP);
		conn.setLineStyle(Graphics.LINE_SOLID);
		conn.setLineWidth(1);
		conn.setSourceDecoration(new RealizationLinkDecoration(true));
		conn.setTargetDecoration(new RealizationLinkDecoration(false));
		return conn;
	}

	/**
	 * @param connectionEP
	 * @return Figure representing a consolidated link
	 */
	public static PolylineConnectionEx createNewConsolidationLink(
			ConsolidationLinkEditPart connectionEP) {
		PolylineConnectionEx conn = new ConsolidationLinkConnection(connectionEP);
		conn.setLineStyle(Graphics.LINE_SOLID);
		conn.setLineWidth(2);
		conn.setSourceDecoration(new HostingLinkDecoration(true));
		conn.setTargetDecoration(new HostingLinkDecoration(true));
		return conn;
	}
}
