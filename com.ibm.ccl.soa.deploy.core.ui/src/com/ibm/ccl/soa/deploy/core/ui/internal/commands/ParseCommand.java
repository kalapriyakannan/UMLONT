/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;

/**
 * An abstract command which applies a user-entered edit string
 * 
 */
abstract public class ParseCommand extends AbstractTransactionalCommand {
	/** an error message indicating the parsing error, otherwise null */
	protected String parseErrorMessage = null;

	protected EObject element;
	protected int flags;
	protected String newString;

	/**
	 * Method ParseCommand.
	 * 
	 * @param element
	 * @param newString
	 * @param flags
	 */
	public ParseCommand(EObject element, String newString, int flags) {
		super(TransactionUtil.getEditingDomain(element), null, null);
		this.element = element;
		this.flags = flags;
		this.newString = newString;
	}

	/**
	 * Tests if the user-entered string is in a valid form that can be parsed.
	 * 
	 * By default, all edit strings are valid. Subclasses should override this method if necessary
	 * 
	 * @return IParserEditStatus the status indicating if the edit string is valid.
	 */
	public IParserEditStatus isValidEditString() {
		return ParserEditStatus.EDITABLE_STATUS;
	}

	/**
	 * Method getDescription.
	 * 
	 * @return String
	 */
	public abstract String getDescription();

	/**
	 * @see org.eclipse.gmf.runtime.common.core.command.ICommand#getLabel()
	 */
	public abstract String getLabel();

	/**
	 * Method getCommandNameResourceEntry.
	 * 
	 * @return String
	 */
	protected final String getCommandNameResourceEntry() {
		return null;
	}

//	/**
//	 * Sets the parsing error message
//	 * @param parseErrorMessage the parsing error message
//	 */
//	protected void setParseErrorMessage(String parseErrorMessage) {
//		this.parseErrorMessage = parseErrorMessage;
//	}
//	
//	/**
//	 * Gets the parsing error message 
//	 * @return the parsing error message, otherwise <code>null</code>
//	 */
//	public String getParseErrorMessage() {
//		return parseErrorMessage;
//	}
}
