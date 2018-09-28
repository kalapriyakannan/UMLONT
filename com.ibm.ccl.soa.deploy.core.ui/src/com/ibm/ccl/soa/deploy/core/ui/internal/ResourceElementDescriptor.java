/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.internal;

import java.net.URL;

import org.eclipse.gmf.runtime.emf.type.core.IContainerDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.ISpecializationTypeDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;

import com.ibm.ccl.soa.deploy.internal.core.extension.ResourceTypeUIBindingDescriptor;

/**
 * Descriptor for adding dynamic elements to the ElementTypeRegistry
 * 
 */
public class ResourceElementDescriptor implements ISpecializationTypeDescriptor {

	private final IElementType mtype;
	private final String id;
	private final ResourceTypeUIBindingDescriptor desc;

	ResourceElementDescriptor(IElementType mtype, ResourceTypeUIBindingDescriptor desc) {
		this.mtype = mtype;
		id = desc.getResourceTypeId();
		this.desc = desc;
	}

	public IContainerDescriptor getContainerDescriptor() {
		return null;
	}

	public IEditHelperAdvice getEditHelperAdvice() {
		return new AbstractEditHelperAdvice();
	}

	public IElementMatcher getMatcher() {
		return null;
	}

	public IElementType[] getSpecializedTypes() {
		return new IElementType[] { mtype };
	}

	public URL getIconURL() {
		return desc.getSmallIconURL();
	}

	public String getId() {
		return id;
	}

	public String getKindName() {
		return "resourceTypeKind"; //$NON-NLS-1$
	}

	public String getName() {
		return desc.getName();
	}

	public String getParamValue(String paramName) {
		return null;
	}
}
