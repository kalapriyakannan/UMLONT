/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.uml.internal.provider;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;

import com.ibm.xtools.uml.navigator.FileViewerElement;

/**
 * A &lt;extension point="org.eclipse.core.expressions.propertyTesters"&gt;
 * 
 * @see UMLInteractionProvider
 */
public class UMLFilePropertyTester extends PropertyTester {

	private final String prop = "isDnxFile"; //$NON-NLS-1$
	private final String DNX_EXT = "dnx"; //$NON-NLS-1$

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (property.equals(prop)) {
			if (receiver instanceof FileViewerElement) {
				FileViewerElement fileElement = (FileViewerElement) receiver;
				Object element = fileElement.getElement();
				if (element instanceof IFile) {
					IFile file = (IFile) element;
					String extension = file.getFileExtension();
					if (extension.equals(DNX_EXT)) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
