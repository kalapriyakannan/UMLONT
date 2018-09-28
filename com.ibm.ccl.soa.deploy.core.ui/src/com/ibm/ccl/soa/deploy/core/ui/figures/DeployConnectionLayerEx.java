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

import org.eclipse.draw2d.AutomaticRouter;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayeredPane;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Ray;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.internal.routers.FanRouter;
import org.eclipse.gmf.runtime.draw2d.ui.internal.routers.ObliqueRouter;
import org.eclipse.jface.util.IPropertyChangeListener;

import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.editor.DeployManhattanConnectionRouter;
import com.ibm.ccl.soa.deploy.core.ui.figures.common.ConnectionLayerExEx;
import com.ibm.ccl.soa.deploy.core.ui.preferences.IDeployPreferences;

/**
 * @author jswanke
 * 
 */
public class DeployConnectionLayerEx extends ConnectionLayerExEx implements IPropertyChangeListener {

	private ConnectionRouter obliqueRouter = null;
	private ConnectionRouter manhattanRouter = null;
	private boolean isValidateEnabled = true;
	private boolean differedValidate = false;

	@Override
	public void removeNotify() {
		DeployCoreUIPlugin.getDefault().getPreferenceStore().removePropertyChangeListener(this);
		super.removeNotify();
	}

	/**
	 * @param parentFigure
	 */
	public DeployConnectionLayerEx(IFigure parentFigure) {
		super();
		// use our own router
		manhattanRouter = new DeployManhattanConnectionRouter((LayeredPane) parentFigure);

	}

	/**
	 * @param diagramEditPart
	 */
	public void setDiagramEditPart(DiagramEditPart diagramEditPart) {
		super.setDiagramEditPart(diagramEditPart);
		DeployCoreUIPlugin.getDefault().getPreferenceStore().addPropertyChangeListener(this);
	}

	/**
	 * listen for changes in preference store and update diagram accordingly
	 */

	public void propertyChange(org.eclipse.jface.util.PropertyChangeEvent event) {
		if (event.getProperty().equals(IDeployPreferences.DEPLOY_DISABLE_LINK_LABELS)) {
			removeConnectionLabels(true);
			updateConnectionLabels();
		}
	}

	public ConnectionRouter getRectilinearRouter() {
		return manhattanRouter;
	}

	public ConnectionRouter getObliqueRouter() {
		if (obliqueRouter == null) {
			AutomaticRouter router = new FanRouter();
			router.setNextRouter(new ObliqueRouter() {

				@Override
				public boolean isAvoidingObstructions(Connection conn) {
					Point p1 = conn.getSourceAnchor().getReferencePoint().getCopy();
					conn.translateToRelative(p1);
					Point p2 = conn.getTargetAnchor().getReferencePoint().getCopy();
					conn.translateToRelative(p2);
					Ray ray = new Ray(p1, p2);
					// don't use obstruction avoidance for shorter/longer links
					double d = ray.length();
					return d < 10000.0 || d > 20000.0 ? false : super.isAvoidingObstructions(conn);
				}

			});
			obliqueRouter = router;
		}

		return obliqueRouter;
	}

	/**
	 * @param isValidateEnabled
	 */
	public void toggleValidateEnabled(boolean isValidateEnabled) {
		this.isValidateEnabled = isValidateEnabled;
		if (differedValidate) {
			differedValidate = false;
			validate();
		}
	}

	@Override
	public void validate() {
		if (isValidateEnabled) {
			super.validate();
		} else {
			differedValidate = true;
		}
	}

}
