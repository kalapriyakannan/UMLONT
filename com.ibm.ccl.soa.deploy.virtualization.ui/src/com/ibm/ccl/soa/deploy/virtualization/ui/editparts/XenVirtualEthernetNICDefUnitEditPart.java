/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.virtualization.ui.editparts;

import org.eclipse.draw2d.DelegatingLayout;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.ibm.ccl.soa.deploy.core.ui.editparts.UnitEditPart;
import com.ibm.ccl.soa.deploy.virtualization.ui.figures.VirtualizationFigureFactory;
import com.ibm.ccl.soa.deploy.virtualization.ui.Messages;

/**
 * Holds a logical node, which is a container capable of holding deployable units.
 */
public class XenVirtualEthernetNICDefUnitEditPart extends UnitEditPart {
	/**
	 * @param view
	 */
	public XenVirtualEthernetNICDefUnitEditPart(View view) {
		super(view);
		// determine figure category description
		setCategory(Messages.XenVirtualEthernetNICDefUnitEditPart_Xen_Virtual_Ethernet_NIC_Def); 
	}

	@Override
	protected NodeFigure createMainFigure() {
		NodeFigure f = VirtualizationFigureFactory.createNewVirtualizationUnitFigure();
		f.setLayoutManager(new DelegatingLayout());
		return f;
	}
}
