/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.internal.provider;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;

/**
 * A &lt;extension point="org.eclipse.core.expressions.propertyTesters"&gt;
 * 
 * @see ScriptUnitProvider
 * @author Ed Snible (based on ArchiveTypePropertyTester)
 */
public class PropertiesFilePropertyTester extends PropertyTester {

	private String property = "isPropertiesFile"; //$NON-NLS-1$
	private String PROPERTIES_EXT = "properties"; //$NON-NLS-1$

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (this.property.equals(property)) {
			if (receiver instanceof IFile) {
				IFile propsFile = (IFile) receiver;
				String extension = propsFile.getFileExtension();
				return extension.equals(PROPERTIES_EXT);
			}
		}

		return false;
	}

} // end class PropertiesFilePropertyTester
