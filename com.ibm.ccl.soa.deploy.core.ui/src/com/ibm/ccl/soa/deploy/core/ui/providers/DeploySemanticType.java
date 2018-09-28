/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.runtime.emf.type.core.AbstractElementTypeEnumerator;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import com.ibm.ccl.soa.deploy.internal.core.ui.providers.DeployDynamicPaletteFactory;

/**
 * Element types.
 * 
 * @author John Swanke, Manish Bhargava
 */
public class DeploySemanticType extends AbstractElementTypeEnumerator {

	public static final IElementType DEPENDENCYLINK = getElementType("deploy.dependencylink"); //$NON-NLS-1$
	public static final IElementType HOSTINGLINK = getElementType("deploy.hostinglink"); //$NON-NLS-1$
	public static final IElementType REALIZATIONLINK = getElementType("deploy.realizationlink"); //$NON-NLS-1$
	public static final IElementType CONSTRAINTLINK = getElementType("deploy.contraintlink"); //$NON-NLS-1$
	public static final IElementType UNITGROUP = DeployDynamicPaletteFactory
			.createSpecializationType("deploy.unitGroup"); //$NON-NLS-1$

	private static List shapeElements = new ArrayList();
	private static IElementType referenceElementType = null;
	private static IElementType serviceElementType = null;
	static {
		shapeElements.add(DEPENDENCYLINK);
		shapeElements.add(HOSTINGLINK);
		shapeElements.add(REALIZATIONLINK);
		shapeElements.add(CONSTRAINTLINK);
	}

	public static final IElementType getElementTypeById(String elementId) {
		IElementType elementType = getElementType(elementId);
		if (!shapeElements.contains(elementType)) {
			shapeElements.add(elementType);
		}

		return elementType;
	}

	/**
	 * Gets a list of all the possible shape types. This is used by the connector handles.
	 * 
	 * @return a list of shape types
	 */
	public static List getShapeTypes() {
		List shapes = new ArrayList();
		return shapes;
	}

	/**
	 * Gets a list of all the possible connector types. This is used by the connector handles.
	 * 
	 * @return a list of connector types
	 */
	public static List getConnectorTypes() {
		List connectors = new ArrayList();

		connectors.add(DEPENDENCYLINK);
		connectors.add(HOSTINGLINK);
		connectors.add(REALIZATIONLINK);
		connectors.add(CONSTRAINTLINK);

		return connectors;
	}

	public static IElementType getComponentServiceElementType() {
		if (serviceElementType == null) {
			serviceElementType = getElementType("deploy.Service"); //$NON-NLS-1$
		}
		return serviceElementType;
	}

	public static IElementType getComponentReferenceElementType() {
		if (referenceElementType == null) {
			referenceElementType = getElementType("deploy.Reference"); //$NON-NLS-1$
		}
		return referenceElementType;
	}
}
