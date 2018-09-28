/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.parser;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;

/**
 * Parser that displays EClass name for EObject.
 * 
 * @author Ed Snible
 */
public class DeployTypeParser implements IParser {

	private static IParser instance;

	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		return null;
	}

	public String getEditString(IAdaptable element, int flags) {
		return null;
	}

	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		return null;
	}

	public String getPrintString(IAdaptable adaptable, int flags) {
		EObject element = (EObject) adaptable.getAdapter(EObject.class);
		return element.eClass().getName();
	}

	public boolean isAffectingEvent(Object event, int flags) {
		return false;
	}

	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		return null;
	}

	public static IParser getInstance() {
		if (instance == null) {
			instance = new DeployTypeParser();
		}
		return instance;
	}

} // end class TypeParser
