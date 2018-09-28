/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.marker.quickfix;

import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.jface.text.TextPresentation;
import org.eclipse.swt.widgets.Display;

/**
 * @since 1.0
 * 
 */
public class TextPresenter implements DefaultInformationControl.IInformationPresenter {

	/**
	 * 
	 */
	public TextPresenter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String updatePresentation(Display display, String hoverInfo,
			TextPresentation presentation, int maxWidth, int maxHeight) {
		return hoverInfo;
	}

}
