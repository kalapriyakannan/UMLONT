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
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Node;

import com.ibm.xtools.uml.navigator.ModelServerElement;

/**
 * A &lt;extension point="org.eclipse.core.expressions.propertyTesters"&gt;
 * 
 * @see UMLElementPropertyTester
 */
public class UMLElementPropertyTester extends PropertyTester {

	private final String componentProperty = "isComponent"; //$NON-NLS-1$
	private final String actorProperty = "isActor"; //$NON-NLS-1$
	private final String nodeProperty = "isNode"; //$NON-NLS-1$
	private final String diagramProperty = "isDiagram"; //$NON-NLS-1$
	private final String interactionProperty = "isInteraction"; //$NON-NLS-1$
	private final String collaborationProperty = "isCollaboration"; //$NON-NLS-1$

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (receiver instanceof ModelServerElement) {
			ModelServerElement modelServerElement = (ModelServerElement) receiver;
			Object element = modelServerElement.getElement();
			if (property.equals(componentProperty)) {
				if (element instanceof Component) {
					return true;
				}
			} else if (property.equals(actorProperty)) {
				if (element instanceof Actor) {
					return true;
				}
			} else if (property.equals(nodeProperty)) {
				if (element instanceof Node) {
					return true;
				}
			} else if (property.equals(diagramProperty)) {
				if (element instanceof Diagram) {
					return true;
				}

			} else if (property.equals(interactionProperty)) {
				if (element instanceof Interaction) {
					return true;
				}

			} else if (property.equals(collaborationProperty)) {
				if (element instanceof Collaboration) {
					return true;
				}

			}
		}

		return false;
	}

}
