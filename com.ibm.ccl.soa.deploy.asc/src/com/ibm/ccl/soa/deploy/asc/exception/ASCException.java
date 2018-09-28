/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.ibm.ccl.soa.deploy.asc.exception;

/**
 * The Exception of exporting asc script .
 * 
 * @author <a href="mailto:fenglin@cn.ibm.com">Ella Feng</a>
 * 
 */
public class ASCException extends Exception {

	private static final long serialVersionUID = 8970040965569484595L;

	protected ASCException() {

	}

	/**
	 * create a new instance of ASCException with message and cause
	 * 
	 * @param msg :
	 *           the message for this exception
	 * @param e :
	 *           the cause of this exception
	 * @return
	 */

	public ASCException(String msg, Throwable e) {
		super(msg, e);
	}

	/**
	 * create a new instance of ASCException with message
	 * 
	 * @param msg :
	 *           the message for this exception
	 * @return
	 */
	public ASCException(String msg) {
		super(msg);
	}

}
