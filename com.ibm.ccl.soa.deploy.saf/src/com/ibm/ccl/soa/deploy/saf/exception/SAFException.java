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
 * This exception can be thrown by methods in ISAFManager to report errors.
 */
public class SAFException extends Exception {

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -5037325510775193492L;

	/**
	 * Default constructor
	 */
	public SAFException() {
		super();
	}

	/**
	 * Creates an exception object from an error message.
	 * 
	 * @param message
	 *           translated text describing the error
	 */
	public SAFException(String message) {
		super(message);
	}

	/**
	 * Creates an exception object from an error message and another exception.
	 * 
	 * @param message
	 *           translated text describing the error
	 * @param cause
	 *           the base exception object
	 */
	public SAFException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Creates an exception object from another exception.
	 * 
	 * @param cause
	 *           the base exception object
	 */
	public SAFException(Throwable cause) {
		super(cause);
	}

}
