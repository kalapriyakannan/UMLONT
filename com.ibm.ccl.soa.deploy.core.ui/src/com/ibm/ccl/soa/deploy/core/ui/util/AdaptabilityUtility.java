/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.core.ui.util;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;

/**
 * @since 1.0
 * 
 */
public class AdaptabilityUtility {
	/**
	 * @param anElement
	 * @param anAdapterType
	 * @return Adapted object
	 */
	public static Object getAdapter(Object anElement, Class anAdapterType) {
		if (anElement == null)
			return null;
		else if (anElement instanceof IAdaptable)
			return ((IAdaptable) anElement).getAdapter(anAdapterType);
		else
			return Platform.getAdapterManager().getAdapter(anElement, anAdapterType);
	}
}
