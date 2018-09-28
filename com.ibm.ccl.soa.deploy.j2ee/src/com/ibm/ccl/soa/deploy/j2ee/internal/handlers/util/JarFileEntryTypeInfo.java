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
import org.eclipse.jdt.core.search.IJavaSearchScope;

/**
 * A <tt>JarFileEntryTypeInfo</tt> represents a type in a Jar file.
 */
public class JarFileEntryTypeInfo extends TypeInfo {

	private final String fJar;
	private final String fFileName;
	private final String fExtension;

	public JarFileEntryTypeInfo(String pkg, String name, char[][] enclosingTypes, int modifiers,
			String jar, String fileName, String extension) {
		super(pkg, name, enclosingTypes, modifiers);
		fJar = jar;
		fFileName = fileName;
		fExtension = extension;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!JarFileEntryTypeInfo.class.equals(obj.getClass())) {
			return false;
		}
		JarFileEntryTypeInfo other = (JarFileEntryTypeInfo) obj;
		return doEquals(other) && fJar.equals(other.fJar) && fFileName.equals(other.fFileName)
				&& fExtension.equals(other.fExtension);
	}

	public int getElementType() {
		return TypeInfo.JAR_FILE_ENTRY_TYPE_INFO;
	}

	public String getJar() {
		return fJar;
	}

	public String getFileName() {
		return fFileName;
	}

	public String getExtension() {
		return fExtension;
	}

	public IPath getPackageFragmentRootPath() {
		return new Path(fJar);
	}

	public String getPath() {
		StringBuffer result = new StringBuffer(fJar);
		result.append(IJavaSearchScope.JAR_FILE_ENTRY_SEPARATOR);
		getElementPath(result);
		return result.toString();
	}

	private void getElementPath(StringBuffer result) {
		String pack = getPackageName();
		if (pack != null && pack.length() > 0) {
			result.append(pack.replace(TypeInfo.PACKAGE_PART_SEPARATOR, TypeInfo.SEPARATOR));
			result.append(TypeInfo.SEPARATOR);
		}
		result.append(getFileName());
		result.append('.');
		result.append(getExtension());
	}
}
