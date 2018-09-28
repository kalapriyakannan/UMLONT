/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.os.validator.pattern.attribute;

import java.util.List;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.validator.ValidatorUtils;
import com.ibm.ccl.soa.deploy.os.OperatingSystem;
import com.ibm.ccl.soa.deploy.os.OsPackage;
import com.ibm.ccl.soa.deploy.os.Port;
import com.ibm.ccl.soa.deploy.os.PortConfigUnit;

/**
 * Static {@link OperatingSystem} verification utility methods.
 */
public final class OsValidatorUtils {

	/** Path separator for Windows Systems "{@value}". */
	public static final String WINDOWS_PATH_SEPARATOR = "\\"; //$NON-NLS-1$

	/** Path separator for UNIX Systems "{@value}". */
	public static final String UNIX_PATH_SEPARATOR = "/"; //$NON-NLS-1$

	private OsValidatorUtils() {
		// static methods only
	}

	/**
	 * 
	 * @param osType
	 * @return true if the osType string indicates a Windows operating system
	 */
	public static boolean isWindowsOsType(String osType) {
		// TODO Operating system type should be from a list of
		// known valid values		
		// Windows, Windows-Cygwin
		if (osType == null) {
			return false;
		}
		return osType.length() >= 7 && osType.substring(0, 7).equalsIgnoreCase("Windows"); //$NON-NLS-1$
	}

	/**
	 * @param osType
	 * @return true if the osType string indicates a Unix operating system
	 */
	public static boolean isUnixOsType(String osType) {
		// TODO Operating system type should be from a list of
		// known valid values	
		if (osType == null) {
			return false;
		}
		return osType.equalsIgnoreCase("AIX") || //$NON-NLS-1$
				osType.equalsIgnoreCase("Solaris") || //$NON-NLS-1$
				osType.equalsIgnoreCase("Linux"); //$NON-NLS-1$
	}

	/**
	 * Attempts to guess the path separator from another path.
	 * 
	 * @param path
	 *           a path.
	 * @return the guessed separator, or null if unknown.
	 */
	public static String guessPathSeparatorFromPath(String path) {
		if (path == null) {
			return null;
		}
		int unixIndex = path.indexOf('/');
		int windowsIndex = path.indexOf('\\');
		if (unixIndex != -1 && windowsIndex == -1) {
			return UNIX_PATH_SEPARATOR;
		}
		if (unixIndex == -1 && windowsIndex != -1) {
			return WINDOWS_PATH_SEPARATOR;
		}
		return null;
	}

	/**
	 * Returns the path separator for the OS hosting the object directly or indirectly.
	 * <p>
	 * Warning: uses discovery
	 * 
	 * @param object
	 *           a deploy model object.
	 * @return the separator charactered inferred by discovering the operating system hosting the
	 *         deploy object, or null if the OS is not found.
	 */
	public static String getPathSeparator(DeployModelObject object) {
		if (object == null) {
			return null;
		}
		OperatingSystem os = (OperatingSystem) ValidatorUtils.discoverHostCapability(ValidatorUtils
				.getUnit(object), OsPackage.Literals.OPERATING_SYSTEM, null);
		if (os == null || os.getOsType() == null) {
			return null;
		}
		if (isWindowsOsType(os.getOsType())) {
			return WINDOWS_PATH_SEPARATOR;
		}
		return UNIX_PATH_SEPARATOR;
	}

	/**
	 * Returns the path separator for the OS hosting the object directly or indirectly.
	 * <p>
	 * Warning: uses discovery
	 * 
	 * @param object
	 *           a deploy model object.
	 * @return the separator charactered inferred by discovering the operating system hosting the
	 *         deploy object, or null if the OS is not found.
	 */
	public static String getOsType(DeployModelObject object) {
		if (object == null) {
			return null;
		}
		OperatingSystem os = (OperatingSystem) ValidatorUtils.discoverHostCapability(ValidatorUtils
				.getUnit(object), OsPackage.Literals.OPERATING_SYSTEM, null);
		if (os == null) {
			return null;
		}
		return os.getOsType();
	}

	/**
	 * Returns the path separator for the OS hosting the object directly or indirectly, or guesses
	 * from the sample.
	 * <p>
	 * Warning: uses discovery
	 * 
	 * @see #guessPathSeparatorFromPath(String)
	 * @see #getPathSeparator(DeployModelObject)
	 * 
	 * @param object
	 *           a deploy model object.
	 * @param samplePath
	 *           a sample path to guess if the OS host is not found.
	 * @return the separator charactered inferred by discovering the operating system hosting the
	 *         deploy object, or null if the OS is not found.
	 */
	public static String getPathSeparator(DeployModelObject object, String samplePath) {
		String sep = getPathSeparator(object);
		if (sep != null) {
			return sep;
		}
		return guessPathSeparatorFromPath(samplePath);
	}

	/**
	 * @param p
	 *           an install path
	 * @param allowForwardSlashes
	 *           set to true to allow forward slashes in a windows path.
	 * @param allowLeadingDollarChar
	 *           set to true to allow leading $ character as substitute for drive letter
	 * @return true if valid installdir string, false otherwise
	 */
	public static boolean isValidWindowsPathWithDriveLetter(String p, boolean allowForwardSlashes,
			boolean allowLeadingDollarChar) {
		if (!isValidWindowsPath(p, allowForwardSlashes)) {
			return false;
		}

		// DB2 installer wants a volume name. No UNC name.
		if (p.charAt(1) != ':') {
			if (!(p.charAt(0) == '$' && allowLeadingDollarChar)) {
				return false;
			}
		}

		// DB2 GUI installer limits installdir pathlength to 240 characters
//		if (p.length() > 260) {
//			return false;
//		}

		return true;
	}

	/**
	 * Forward slashes disallowed by default.
	 * 
	 * @param p
	 *           an install path
	 * @return true if valid installdir string, false otherwise
	 */
	public static boolean isValidWindowsPathWithDriveLetter(String p) {
		return isValidWindowsPathWithDriveLetter(p, false, false);
	}

	/**
	 * @param p
	 *           an install path
	 * @param allowLeadingDollarChar
	 *           set to true to allow a leading $ character to substitute for a leading slash
	 * @return true if valid rooted installdir string, false otherwise
	 */
	public static boolean isValidRootedUnixPath(String p, boolean allowLeadingDollarChar) {
		if (!isValidUnixPath(p)) {
			return false;
		}

		// disallow relative paths (for install purposes)
		if (p.charAt(0) != '/' && !(allowLeadingDollarChar && p.charAt(0) == '$')) {
			return false;
		}

		return true;
	}

	/**
	 * @param p
	 *           an install path
	 * @return true if valid rooted installdir string, false otherwise
	 */
	public static boolean isValidRootedUnixPath(String p) {
		return isValidRootedUnixPath(p, false);
	}

	/**
	 * @param p
	 *           a path
	 * @param allowForwardSlashes
	 *           set to true to allow forward slashes in a windows path
	 * @return true if valid windows path string for components, false otherwise
	 */
	public static boolean isValidWindowsPath(String p, boolean allowForwardSlashes) {
		// Don't throw an exception if p is null, or "", or "x"
		if (p == null || p.length() < 2) {
			return false;
		}

		// Volume name or UNC name
//		if (!(p.charAt(1) == ':') && !(p.startsWith("\\\\"))){ //$NON-NLS-1$
//			return false;
//		}		

		// Volume name should start with a character.
		if (p.charAt(1) == ':') {
			char c = p.charAt(0);
			if (!(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')) {
				return false;
			}
		}
		// No invalid characters
		// These characters are invalid for NTFS filenames (various sources)
		// '\' is also invalid in a filename, but it is allowed in a pathname.
		for (int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);

			if (!allowForwardSlashes && c == '/') {
				return false;
			}
			if (c == '?' || c == '<' || c == '>' || c == '*' || c == '|' || c == '"') {
				return false;
			}
			if (c == ':' && i != 1) {
				return false;
			}
			if (c < 0x1f) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Forward slashes are disallowed.
	 * 
	 * @param p
	 *           a path
	 * @return true if valid windows path string for components, false otherwise
	 */
	public static boolean isValidWindowsPath(String p) {
		return isValidWindowsPath(p, false);
	}

	/**
	 * @param p
	 *           a path
	 * @return true if valid unix path string for components, false otherwise
	 */
	public static boolean isValidUnixPath(String p) {
		// Don't throw an exception if p is null, or "", or "x"
		if (p == null || p.length() < 2) {
			return false;
		}

		// No part between "/" characters or at beginning or end may be > 255 characters. 
		String parts[] = p.split("/");; //$NON-NLS-1$
		for (int i = 0; i < parts.length; ++i) {
			if (parts[i].length() > 255) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Returns the port capability of the specified name.
	 * 
	 * @param capability
	 *           a capability provided by a unit hosting a {@link PortConfigUnit} or the
	 *           {@link PortConfigUnit} itself.
	 * @param portName
	 *           the name to match against {@link Port#getPortName()} (null matches any name).
	 * @return the port number, or null if not found or undefined.
	 */
	public static Port getPort(Capability capability, String portName) {
		if (capability == null || !(capability.getParent() instanceof Unit)) {
			return null;
		}
		return getPort((Unit) capability.getParent(), portName);
	}

	/**
	 * Returns the port capability of the specified name.
	 * 
	 * @param unit
	 *           a unit hosting a {@link PortConfigUnit} or the {@link PortConfigUnit} itself.
	 * @param portName
	 *           the name to match against {@link Port#getPortName()} (null matches any name).
	 * @return the port number, or null if not found or undefined.
	 */
	public static Port getPort(Unit unit, String portName) {
		if (unit == null) {
			return null;
		}
		PortConfigUnit portUnit;
		if (unit instanceof PortConfigUnit) {
			portUnit = (PortConfigUnit) unit;
		} else {
			List<Unit> list = ValidatorUtils.discoverHosted(unit, OsPackage.eINSTANCE
					.getPortConfigUnit(), null);
			if (list.size() == 0) {
				return null;
			}
			portUnit = (PortConfigUnit) list.get(0);
		}
		List<Capability> list = portUnit.getCapabilities();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof Port) {
				Port port = (Port) list.get(i);
				if (portName == null || portName.equals(port.getPortName())) {
					return port;
				}
			}
		}
		return null;
	}
}
