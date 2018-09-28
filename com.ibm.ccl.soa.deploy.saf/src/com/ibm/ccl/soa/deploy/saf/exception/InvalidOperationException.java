/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.saf.exception;

/**
 * This exception is thrown by methods in ISAFManager to report errors when an operation invoked by
 * the client program cannot be performed. The error message may be displayed to the user in an
 * error dialog, so it should be easy to understand.
 */
public class InvalidOperationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5506166310947551473L;

	/**
	 * Creates an exception object from an error message. The message will potentially be displayed
	 * to the user through an error dialog, so it must be easy to understand.
	 * 
	 * @param message
	 *           translated text describing the error
	 */
	public InvalidOperationException(String message) {
		super(message);
	}

	/**
	 * Creates an exception object from an error message and another exception. The message will
	 * potentially be displayed to the user through an error dialog, so it must be easy to
	 * understand.
	 * 
	 * @param message
	 *           translated text describing the error
	 * @param cause
	 *           the base exception object
	 */
	public InvalidOperationException(String message, Throwable cause) {
		super(message, cause);
	}

}
