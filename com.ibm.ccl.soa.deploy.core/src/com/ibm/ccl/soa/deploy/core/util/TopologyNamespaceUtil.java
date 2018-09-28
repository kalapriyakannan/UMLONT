/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.util;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;

import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.IConstants;

public class TopologyNamespaceUtil {

	/**
	 * Constant for an empty char array
	 */
	public static final char[] NO_CHAR = new char[0];

	/**
	 * Constant for an empty char array with two dimensions.
	 */
	public static final char[][] NO_CHAR_CHAR = new char[0][];

	/**
	 * Constant for an empty String array.
	 * 
	 * @since 3.1
	 */
	public static final String[] NO_STRINGS = new String[0];

	/**
	 * Character constant indicating the dot in a signature. Value is <code>'.'</code>.
	 */
	public static final char C_DOT = '.';

	/**
	 * Character constant indicating the start of a formal type parameter (or type argument) list in
	 * a signature. Value is <code>'&lt;'</code>.
	 * 
	 * @since 3.0
	 */
	public static final char C_GENERIC_START = '<';

	/**
	 * Returns all segments of the given dot-separated qualified name. Returns an array with only the
	 * given name if it is not qualified. Returns an empty array if the name is empty.
	 * <p>
	 * For example:
	 * 
	 * <pre>
	 * <code>
	 * getSimpleNames(&quot;java.lang.Object&quot;) -&gt; {&quot;java&quot;, &quot;lang&quot;, &quot;Object&quot;}
	 * getSimpleNames(&quot;Object&quot;) -&gt; {&quot;Object&quot;}
	 * getSimpleNames(&quot;&quot;) -&gt; {}
	 * getSimpleNames(&quot;java.util.List&lt;java.lang.String&gt;&quot;) -&gt; 
	 *   {&quot;java&quot;, &quot;util&quot;, &quot;List&lt;java.lang.String&gt;&quot;}
	 * </code>
	 * </pre>
	 * 
	 * @param name
	 *           the name
	 * @return the list of simple names, possibly empty
	 * @exception NullPointerException
	 *               if name is null
	 */
	public static String[] getSimpleNames(String name) {
		return toStrings(getSimpleNames(name.toCharArray()));
	}

	public static char[][] getSimpleNames(char[] name) {
		int length = name == null ? 0 : name.length;
		if (length == 0) {
			return NO_CHAR_CHAR;
		}

		int wordCount = 1;
		countingWords: for (int i = 0; i < length; i++) {
			switch (name[i])
			{
			case C_DOT:
				wordCount++;
				break;
			case C_GENERIC_START:
				break countingWords;
			}
		}
		char[][] split = new char[wordCount][];
		int last = 0, currentWord = 0;
		for (int i = 0; i < length; i++) {
			if (name[i] == C_GENERIC_START) {
				break;
			}
			if (name[i] == C_DOT) {
				split[currentWord] = new char[i - last];
				System.arraycopy(name, last, split[currentWord++], 0, i - last);
				last = i + 1;
			}
		}
		split[currentWord] = new char[length - last];
		System.arraycopy(name, last, split[currentWord], 0, length - last);
		return split;
	}

	/**
	 * Returns a trimmed version the simples names returned by Signature.
	 */
	public static String[] getTrimmedSimpleNames(String name) {
		String[] result = getSimpleNames(name);
		for (int i = 0, length = result.length; i < length; i++) {
			result[i] = result[i].trim();
		}
		return result;
	}

	/**
	 * Answers an array of strings from the given array of char array.
	 * 
	 * @param array
	 *           the given array
	 * @return an array of strings
	 * @since 3.0
	 */
	final static public String[] toStrings(char[][] array) {
		if (array == null) {
			return NO_STRINGS;
		}
		int length = array.length;
		if (length == 0) {
			return NO_STRINGS;
		}
		String[] result = new String[length];
		for (int i = 0; i < length; i++) {
			result[i] = new String(array[i]);
		}
		return result;
	}

	/**
	 * Returns true if the given folder name is valid for a package, false if it is not.
	 */
	public static boolean isValidFolderNameForNamespace(String folderName) {
		return validateIdentifier(folderName).getSeverity() != IStatus.ERROR;
	}

	/**
	 * Returns true if the given file name is valid for a topology file, false if it is not.
	 */
	public static boolean isValidTopologyFileName(String fileName) {
		return fileName.endsWith("." + IConstants.TOPOLOGY_EXTENSION); //$NON-NLS-1$
	}

	/**
	 * Validate the given Java identifier. The identifier must not have the same spelling as a Java
	 * keyword, boolean literal (<code>"true"</code>, <code>"false"</code>), or null literal (<code>"null"</code>).
	 * See section 3.8 of the <em>Java Language Specification, Second Edition</em> (JLS2). A valid
	 * identifier can act as a simple type name, method name or field name.
	 * 
	 * @param id
	 *           the Java identifier
	 * @return a status object with code <code>IStatus.OK</code> if the given identifier is a valid
	 *         Java identifier, otherwise a status object indicating what is wrong with the
	 *         identifier
	 */
	public static IStatus validateIdentifier(String id) {
		return new Status(IStatus.OK, DeployCorePlugin.PLUGIN_ID, IStatus.OK,
				"ValidIdentifierStatus", null); //$NON-NLS-1$
	}

	/**
	 * Returns the concatenation of the given array parts using the given separator between each
	 * part. <br>
	 * <br>
	 * For example:<br>
	 * <ol>
	 * <li>
	 * 
	 * <pre>
	 *    array = {&quot;a&quot;, &quot;b&quot;}
	 *    separator = '.'
	 *    =&gt; result = &quot;a.b&quot;
	 * </pre>
	 * 
	 * </li>
	 * <li>
	 * 
	 * <pre>
	 *    array = {}
	 *    separator = '.'
	 *    =&gt; result = &quot;&quot;
	 * </pre>
	 * 
	 * </li>
	 * </ol>
	 * 
	 * @param array
	 *           the given array
	 * @param separator
	 *           the given separator
	 * @return the concatenation of the given array parts using the given separator between each part
	 */
	public static final String concatWith(String[] array, char separator) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0, length = array.length; i < length; i++) {
			buffer.append(array[i]);
			if (i < length - 1) {
				buffer.append(separator);
			}
		}
		return buffer.toString();
	}

	/**
	 * Combines two hash codes to make a new one.
	 */
	public static int combineHashCodes(int hashCode1, int hashCode2) {
		return hashCode1 * 17 + hashCode2;
	}

	public static String[] getNamespacePath(String[] root, String[] namespace) {
		String[] destination = new String[namespace.length - root.length];
		System.arraycopy(namespace, root.length, destination, 0, destination.length);
		return destination;
	}

	public static IPath concatenate(IPath begining, IPath end) {
		IPath path = new Path(TopologyNamespaceUtil.concatWith(begining.segments(), IPath.SEPARATOR));
		path.append(new Path(TopologyNamespaceUtil.concatWith(end.segments(), IPath.SEPARATOR)));

		return path;
	}

	/**
	 * Splits the qualified names as a String array. The first index contains the namespace, if
	 * present. Second index contains the name of the topology. Eg: java.lang.util.String returns new
	 * String[] {"java.lang.util", "String"} StringBuffer returns new String[]{"", "StringBuffer"}
	 * 
	 * @param qName
	 * @return the string array with split namespace and name
	 */
	public static String[] splitQualifiedName(String qName) {
		String[] simpleNames = getSimpleNames(qName);
		if (simpleNames.length == 1) {
			return new String[] { "", simpleNames[0] }; //$NON-NLS-1$
		}
		String[] names = new String[2];
		//name of the topology
		names[1] = simpleNames[simpleNames.length - 1];
		//namespace of the topology
		names[0] = qName.substring(0, qName.length() - names[1].length() - 1);
		return names;
	}
}
