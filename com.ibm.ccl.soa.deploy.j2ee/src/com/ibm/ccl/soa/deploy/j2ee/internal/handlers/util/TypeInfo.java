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
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.compiler.CharOperation;
import org.eclipse.jdt.core.search.IJavaSearchScope;

public abstract class TypeInfo {
	final String fName;
	final String fPackage;
	final char[][] fEnclosingNames;

	int fModifiers;

	public static final int UNRESOLVABLE_TYPE_INFO = 1;
	public static final int JAR_FILE_ENTRY_TYPE_INFO = 2;
	public static final int IFILE_TYPE_INFO = 3;

	static final char SEPARATOR = '/';
	static final char EXTENSION_SEPARATOR = '.';
	static final char PACKAGE_PART_SEPARATOR = '.';

	static final String EMPTY_STRING = ""; //$NON-NLS-1$

	protected TypeInfo(String pkg, String name, char[][] enclosingTypes, int modifiers) {
		fPackage = pkg;
		fName = name;
		fModifiers = modifiers;
		fEnclosingNames = enclosingTypes;
	}

	public int hashCode() {
		return (fPackage.hashCode() << 16) + fName.hashCode();
	}

	/**
	 * Returns this type info's kind encoded as an integer.
	 * 
	 * @return the type info's kind
	 */
	public abstract int getElementType();

	/**
	 * Returns the path reported by the <tt>ITypeNameRequestor</tt>.
	 * 
	 * @return the path of the type info
	 */
	public abstract String getPath();

	/**
	 * Returns the package fragment root path of this type info.
	 * 
	 * @return the package fragment root as an <tt>IPath</tt>.
	 */
	public abstract IPath getPackageFragmentRootPath();

	/**
	 * Returns the type's modifiers
	 * 
	 * @return the type's modifiers
	 */
	public int getModifiers() {
		return fModifiers;
	}

	/**
	 * Sets the modifiers to the given value.
	 * 
	 * @param modifiers
	 *           the new modifiers
	 */
	public void setModifiers(int modifiers) {
		fModifiers = modifiers;
	}

	/**
	 * Returns the type name.
	 * 
	 * @return the info's type name.
	 */
	public String getTypeName() {
		return fName;
	}

	/**
	 * Returns the package name.
	 * 
	 * @return the info's package name.
	 */
	public String getPackageName() {
		return fPackage;
	}

	/**
	 * Returns true iff the type info describes an interface.
	 */
	public boolean isInterface() {
		return Flags.isInterface(fModifiers);
	}

	/**
	 * Returns true if the info is enclosed in the given scope
	 */
	public boolean isEnclosed(IJavaSearchScope scope) {
		return scope.encloses(getPath());
	}

	public boolean isInnerType() {
		return fEnclosingNames != null && fEnclosingNames.length > 0;
	}

	/**
	 * Gets the type qualified name: Includes enclosing type names, but not package name. Identifiers
	 * are separated by dots.
	 */
	public String getTypeQualifiedName() {
		if (fEnclosingNames != null && fEnclosingNames.length > 0) {
			StringBuffer buf = new StringBuffer();
			for (int i = 0; i < fEnclosingNames.length; i++) {
				buf.append(fEnclosingNames[i]);
				buf.append('.');
			}
			buf.append(fName);
			return buf.toString();
		}
		return fName;
	}

	/**
	 * Gets the fully qualified type name: Includes enclosing type names and package. All identifiers
	 * are separated by dots.
	 */
	public String getFullyQualifiedName() {
		StringBuffer buf = new StringBuffer();
		if (fPackage.length() > 0) {
			buf.append(fPackage);
			buf.append('.');
		}
		if (fEnclosingNames != null) {
			for (int i = 0; i < fEnclosingNames.length; i++) {
				buf.append(fEnclosingNames[i]);
				buf.append('.');
			}
		}
		buf.append(fName);
		return buf.toString();
	}

	protected boolean doEquals(TypeInfo other) {
		// Don't compare the modifiers since they aren't relevant to identify
		// a type.
		return fName.equals(other.fName) && fPackage.equals(other.fPackage)
				&& CharOperation.equals(fEnclosingNames, other.fEnclosingNames);
	}

	protected static boolean equals(String s1, String s2) {
		if (s1 == null || s2 == null) {
			return s1 == s2;
		}
		return s1.equals(s2);
	}
}
