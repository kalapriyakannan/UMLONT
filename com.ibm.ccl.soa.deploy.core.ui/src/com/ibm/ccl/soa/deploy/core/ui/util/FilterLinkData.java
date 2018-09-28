/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.util;

import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Edge;

/**
 * @since 7.0 data class for filtering duplicate links
 * 
 */
public class FilterLinkData {
	private final GraphicalEditPart _sourceEP;
	private final GraphicalEditPart _targetEP;
	private final Edge _existingEdge;

	/**
	 * collects info on potential duplicate links
	 * 
	 * @param sourceEP
	 * @param targetEP
	 * @param existingEdge
	 */
	public FilterLinkData(GraphicalEditPart sourceEP, GraphicalEditPart targetEP, Edge existingEdge) {
		_sourceEP = sourceEP;
		_targetEP = targetEP;
		_existingEdge = existingEdge;
	}

	/**
	 * @return source of potential link
	 */
	public GraphicalEditPart getSource() {
		return _sourceEP;
	}

	/**
	 * @return target of potential link
	 */
	public GraphicalEditPart getTarget() {
		return _targetEP;
	}

	/**
	 * @return an existing Edge between this source and target
	 */
	public Edge getExistingEdge() {
		return _existingEdge;
	}

	/**
	 * @return has an existing Edge between this source and target
	 */
	public boolean hasExistingEdge() {
		return _existingEdge != null;
	}
}
