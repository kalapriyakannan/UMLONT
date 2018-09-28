/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.j2ee.internal.handlers.util;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

/**
 * A type info element that represent an unresolveable type. This can happen if the search engine
 * reports a type name that doesn't exist in the workspace.
 */
public class UnresolvableTypeInfo extends TypeInfo {

	private final String fPath;

	public UnresolvableTypeInfo(String pkg, String name, char[][] enclosingTypes, int modifiers,
			String path) {
		super(pkg, name, enclosingTypes, modifiers);
		fPath = path;
	}

	public boolean equals(Object obj) {
		if (!UnresolvableTypeInfo.class.equals(obj.getClass())) {
			return false;
		}
		UnresolvableTypeInfo other = (UnresolvableTypeInfo) obj;
		return doEquals(other) && fPath.equals(other.fPath);
	}

	public int getElementType() {
		return TypeInfo.UNRESOLVABLE_TYPE_INFO;
	}

	public String getPath() {
		return fPath;
	}

	public IPath getPackageFragmentRootPath() {
		return new Path(fPath);
	}
}
