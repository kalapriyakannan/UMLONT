/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.internal.core.namespace;

import java.util.Arrays;

import org.eclipse.core.runtime.PlatformObject;

import com.ibm.ccl.soa.deploy.core.namespace.INamespaceElement;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceFragmentRoot;
import com.ibm.ccl.soa.deploy.core.util.TopologyNamespaceUtil;

/**
 * 
 * @since 1.0
 * 
 */
public abstract class NamespaceElement extends PlatformObject implements INamespaceElement {

	private static int hashCode(Object[] array) {
		final int PRIME = 31;
		if (array == null)
			return 0;
		int result = 1;
		for (int index = 0; index < array.length; index++) {
			result = PRIME * result + (array[index] == null ? 0 : array[index].hashCode());
		}
		return result;
	}

	protected String[] name;

	protected int type = 0;

	/**
	 * Creates new topology element with the given name.
	 * 
	 * @param aName
	 */
	protected NamespaceElement(String aName) {
		name = TopologyNamespaceUtil.getSimpleNames(aName);
	}

	protected NamespaceElement(String[] aName) {
		name = aName;
	}

	public String getName() {
		return name[name.length - 1];
	}

	public String getQualifiedName() {
		return TopologyNamespaceUtil.concatWith(name, '.');
	}

	public int getType() {
		return type;
	}

	public abstract INamespaceFragmentRoot getRoot();

	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + NamespaceElement.hashCode(name);
		result = PRIME * result + type;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final NamespaceElement other = (NamespaceElement) obj;
		if (!Arrays.equals(name, other.name))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

}
