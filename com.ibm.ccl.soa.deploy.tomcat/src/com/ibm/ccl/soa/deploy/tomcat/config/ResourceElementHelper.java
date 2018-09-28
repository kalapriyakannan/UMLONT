/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tomcat.config;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ResourceElementHelper {

	public static final String RESOURCE_ELEMENT = "Resource"; //$NON-NLS-1$
	public static final String NAME_ATTRIBUTE = "name"; //$NON-NLS-1$
	private final String AUTH_ATTRIBUTE = "auth"; //$NON-NLS-1$
	private final String TYPE_ATTRIBUTE = "type"; //$NON-NLS-1$
	private Document document;

	public ResourceElementHelper(Document document) {
		this.document = document;
	}

	public Element createResourceElement() {
		Element element = document.createElement(RESOURCE_ELEMENT);
		return element;
	}

	public Element createResourceElement(String name, String container, String type) {
		Element element = document.createElement(RESOURCE_ELEMENT);
		addNameAttribute(element, name);
		addAuthAttribute(element, container);
		addTypeAttributte(element, type);
		return element;
	}

	public void addTypeAttributte(Element element, String type) {
		element.setAttribute(TYPE_ATTRIBUTE, type);

	}

	public void addAuthAttribute(Element element, String container) {
		element.setAttribute(AUTH_ATTRIBUTE, container);

	}

	public void addNameAttribute(Element element, String name) {
		element.setAttribute(NAME_ATTRIBUTE, name);

	}

}
