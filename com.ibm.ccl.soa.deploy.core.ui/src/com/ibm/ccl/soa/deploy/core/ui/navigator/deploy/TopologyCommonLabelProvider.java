/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.navigator.deploy;

import org.eclipse.gmf.runtime.common.ui.services.util.CommonLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.graphics.Image;

import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.extension.ExtensionsCore;
import com.ibm.ccl.soa.deploy.core.extension.IDecoratorSemanticService;
import com.ibm.ccl.soa.deploy.core.ui.DeployCoreUIPlugin;
import com.ibm.ccl.soa.deploy.core.ui.editparts.DeployDiagramEditPart;

/**
 * Overrides common label provider to return images based on decorator semantic for the topology
 * property sheet.
 * 
 * @author NKruk
 */
public class TopologyCommonLabelProvider extends CommonLabelProvider {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.DecoratingLabelProvider#getImage(java.lang.Object)
	 */
	public Image getImage(Object element) {
		if (element instanceof IStructuredSelection) {
			IStructuredSelection ss = (IStructuredSelection) element;
			Object firstElement = null;
			if (ss.size() == 1) {
				firstElement = ss.getFirstElement();
				if (firstElement instanceof DeployDiagramEditPart) {
					DeployDiagramEditPart part = (DeployDiagramEditPart) firstElement;
					Object adapted = part.getAdapter(Topology.class);
					if (adapted != null) {
						Topology top = (Topology) adapted;
						//Return image based on semantic 

						IDecoratorSemanticService dsService = ExtensionsCore
								.createDecoratorSemanticService();
						String imgPath = dsService.getDecoratorSemanticIcon(top.getDecoratorSemantic());
						if (imgPath != null && imgPath.trim().length() != 0) {
							return DeployCoreUIPlugin.getDefault().getSharedImages().getImageFromPath(
									imgPath);
						}
					}
				}
			}
		}
		return super.getImage(element);
	}
}
