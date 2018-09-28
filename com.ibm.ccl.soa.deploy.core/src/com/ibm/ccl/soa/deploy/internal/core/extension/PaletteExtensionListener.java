/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.extension;

import java.util.EventListener;


/**
 * Listens to changes which mandate a change to the palette.
 */
public interface PaletteExtensionListener extends EventListener {

	/**
	 * The {@link ResourceTypeService} has a new Palette Entry
	 */
	void paletteRegistryChanged();
}
