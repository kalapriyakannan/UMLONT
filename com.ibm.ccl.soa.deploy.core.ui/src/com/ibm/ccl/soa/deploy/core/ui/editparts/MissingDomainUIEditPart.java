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

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ui.figures.DeployCoreFigure;
import com.ibm.ccl.soa.deploy.core.util.DeployModelObjectUtil;

/**
 * Holds a logical node, which is a container capable of holding deployable units.
 */
public class MissingDomainUIEditPart extends UnitEditPart {

	private final static int APPLICATION = 0;
	private final static int SERVER = 1;
	private final static int DATABASE = 2;

	private int _figureType = APPLICATION;

	/**
	 * @param view
	 */
	public MissingDomainUIEditPart(View view) {
		super(view);

		// create a pseudo type name from unit name
		String type = ""; //$NON-NLS-1$
		EObject eo = ViewUtil.resolveSemanticElement(view);
		if (eo instanceof DeployModelObject) {
//			StringBuffer sb = new StringBuffer(((DeployModelObject) eo).getName());
			StringBuffer sb = new StringBuffer(DeployModelObjectUtil.getTitle((DeployModelObject) eo));
			if (sb.length() > 0) {
				sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
			}
			int i = sb.length() - 1;
			while (i > 0) {
				if (!Character.isDigit(sb.charAt(i))) {
					break;
				}
				sb.deleteCharAt(i--);

			}
			type = sb.toString();
		}
		setCategory(type);

		String t = getCategory().toLowerCase();
		if (t.indexOf("server") != -1) { //$NON-NLS-1$
			_figureType = SERVER;
		} else if (t.indexOf("database") != -1) { //$NON-NLS-1$
			_figureType = DATABASE;
		}

	}

	// use general figure
	protected NodeFigure createMainFigure() {
		NodeFigure f = new DeployCoreFigure() {
			protected void paintFigure(Graphics g) {
				switch (_figureType)
				{
				default:
				case APPLICATION:
					paintDeployApplication(g);
					break;
				case SERVER:
					paintDeployServer(g);
					break;
				case DATABASE:
					paintDeployDatabase(g);
					break;
				}
			}
		};
		f.setLayoutManager(new DelegatingLayout());
		return f;
	}
}
