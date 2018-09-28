/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.tomcat.config;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class ResourceParameterElementHelper {

	public static final String RESOURCE_PARAMS_ELEMENT = "ResourceParams"; //$NON-NLS-1$

	private final String RESOURCE_PARAMS_NAME_ATTRIBUTE = "name"; //$NON-NLS-1$

	private final String PARAMETER_ELEMENT = "parameter"; //$NON-NLS-1$

	private final String PARAMETER_NAME_ELEMENT = RESOURCE_PARAMS_NAME_ATTRIBUTE;

	private final String PARAMETER_VALUE_ELEMENT = "value"; //$NON-NLS-1$

	public Element createResourceParameterElement(Document document) {
		Element element = document.createElement(RESOURCE_PARAMS_ELEMENT);
		return element;
	}

	public Element createResourceParameterElement(Document document, String name,
			HashMap nameValuePairs, boolean appendChild) {
		Element element = document.createElement(RESOURCE_PARAMS_ELEMENT);
		addNameAttribute(element, name);
		addParameters(document, element, nameValuePairs);
		if (appendChild)
			document.appendChild(element);
		return element;
	}

	public void addNameAttribute(Element element, String name) {
		element.setAttribute(RESOURCE_PARAMS_NAME_ATTRIBUTE, name);
	}

	public void addParameters(Document document, Element resourceParameterElement,
			HashMap nameValuePairs) {
		Collection names = nameValuePairs.keySet();
		for (Iterator iter = names.iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			Element element = createParameterElement(document, name, (String) nameValuePairs.get(name));
			resourceParameterElement.appendChild(element);
		}

	}

	private Element createParameterElement(Document document, String name, String value) {
		Element paramterElement = document.createElement(PARAMETER_ELEMENT);
		Element nameElement = createParameterNameElement(document, name);
		if (value == null)
			value = ""; //$NON-NLS-1$
		Element valueElement = createParameterValueElement(document, value);
		paramterElement.appendChild(nameElement);
		paramterElement.appendChild(valueElement);
		return paramterElement;
	}

	private Element createParameterValueElement(Document document, String value) {
		Element paramterValueElement = document.createElement(PARAMETER_VALUE_ELEMENT);
		Text text = document.createTextNode(value);
		paramterValueElement.appendChild(text);
		return paramterValueElement;

	}

	private Element createParameterNameElement(Document document, String name) {
		Element paramterNameElement = document.createElement(PARAMETER_NAME_ELEMENT);
		Text text = document.createTextNode(name);
		paramterNameElement.appendChild(text);
		return paramterNameElement;

	}

}
