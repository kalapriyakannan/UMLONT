/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.os;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Operating System Type</b></em>',
 * and utility methods for working with them. <!-- end-user-doc --> <!-- begin-model-doc -->
 * 
 * This type defines operating system types known to be allowed by TPM Because list is not
 * exclusive, these values are only used during validation.
 * 
 * <!-- end-model-doc -->
 * 
 * @see com.ibm.ccl.soa.deploy.os.OsPackage#getOperatingSystemType()
 * @model
 * @generated
 */
public final class OperatingSystemType extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>AIX</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AIX</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AIX_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int AIX = 0;

	/**
	 * The '<em><b>Windows Cygwin</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Windows Cygwin</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WINDOWS_CYGWIN_LITERAL
	 * @model name="WindowsCygwin" literal="Windows-Cygwin"
	 * @generated
	 * @ordered
	 */
	public static final int WINDOWS_CYGWIN = 1;

	/**
	 * The '<em><b>HPUX</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HPUX</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HPUX_LITERAL
	 * @model literal="HP-UX"
	 * @generated
	 * @ordered
	 */
	public static final int HPUX = 2;

	/**
	 * The '<em><b>Linux</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Linux</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LINUX_LITERAL
	 * @model name="Linux"
	 * @generated
	 * @ordered
	 */
	public static final int LINUX = 3;

	/**
	 * The '<em><b>Solaris</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Solaris</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SOLARIS_LITERAL
	 * @model name="Solaris"
	 * @generated
	 * @ordered
	 */
	public static final int SOLARIS = 4;

	/**
	 * The '<em><b>Windows</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Windows</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WINDOWS_LITERAL
	 * @model name="Windows"
	 * @generated
	 * @ordered
	 */
	public static final int WINDOWS = 5;

	/**
	 * The '<em><b>Open MVS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Open MVS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OPEN_MVS_LITERAL
	 * @model name="OpenMVS"
	 * @generated
	 * @ordered
	 */
	public static final int OPEN_MVS = 6;

	/**
	 * The '<em><b>I5 Operating System</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>I5 Operating System</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #I5_OPERATING_SYSTEM_LITERAL
	 * @model name="i5OperatingSystem"
	 * @generated
	 * @ordered
	 */
	public static final int I5_OPERATING_SYSTEM = 7;

	/**
	 * The '<em><b>Mac OS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Mac OS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MAC_OS_LITERAL
	 * @model name="MacOS"
	 * @generated
	 * @ordered
	 */
	public static final int MAC_OS = 8;

	/**
	 * The '<em><b>Net Ware</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Net Ware</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NET_WARE_LITERAL
	 * @model name="NetWare"
	 * @generated
	 * @ordered
	 */
	public static final int NET_WARE = 9;

	/**
	 * The '<em><b>VMware ESX</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VMware ESX</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VMWARE_ESX_LITERAL
	 * @model name="VMwareESX"
	 * @generated
	 * @ordered
	 */
	public static final int VMWARE_ESX = 10;

	/**
	 * The '<em><b>Darwin</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Darwin</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DARWIN_LITERAL
	 * @model name="Darwin"
	 * @generated
	 * @ordered
	 */
	public static final int DARWIN = 11;

	/**
	 * The '<em><b>Tru64</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Tru64</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRU64_LITERAL
	 * @model name="Tru64"
	 * @generated
	 * @ordered
	 */
	public static final int TRU64 = 12;

	/**
	 * The '<em><b>Free BSD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Free BSD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FREE_BSD_LITERAL
	 * @model name="FreeBSD"
	 * @generated
	 * @ordered
	 */
	public static final int FREE_BSD = 13;

	/**
	 * The '<em><b>IPSO</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>IPSO</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IPSO_LITERAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int IPSO = 14;

	/**
	 * The '<em><b>ZOS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ZOS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ZOS_LITERAL
	 * @model name="zOS" literal="z/OS"
	 * @generated
	 * @ordered
	 */
	public static final int ZOS = 15;

	/**
	 * The '<em><b>ZVM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ZVM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ZVM_LITERAL
	 * @model name="zVM" literal="z/VM"
	 * @generated
	 * @ordered
	 */
	public static final int ZVM = 16;

	/**
	 * The '<em><b>ZLinux</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ZLinux</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ZLINUX_LITERAL
	 * @model name="zLinux" literal="z/Linux"
	 * @generated
	 * @ordered
	 */
	public static final int ZLINUX = 17;

	/**
	 * The '<em><b></b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b></b></em>' literal object isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #__LITERAL
	 * @model literal=""
	 * @generated
	 * @ordered
	 */
	public static final int _ = 18;

	/**
	 * The '<em><b>AIX</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #AIX
	 * @generated
	 * @ordered
	 */
	public static final OperatingSystemType AIX_LITERAL = new OperatingSystemType(AIX, "AIX", "AIX"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Windows Cygwin</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #WINDOWS_CYGWIN
	 * @generated
	 * @ordered
	 */
	public static final OperatingSystemType WINDOWS_CYGWIN_LITERAL = new OperatingSystemType(
			WINDOWS_CYGWIN, "WindowsCygwin", "Windows-Cygwin"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>HPUX</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #HPUX
	 * @generated
	 * @ordered
	 */
	public static final OperatingSystemType HPUX_LITERAL = new OperatingSystemType(HPUX,
			"HPUX", "HP-UX"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Linux</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #LINUX
	 * @generated
	 * @ordered
	 */
	public static final OperatingSystemType LINUX_LITERAL = new OperatingSystemType(LINUX,
			"Linux", "Linux"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Solaris</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #SOLARIS
	 * @generated
	 * @ordered
	 */
	public static final OperatingSystemType SOLARIS_LITERAL = new OperatingSystemType(SOLARIS,
			"Solaris", "Solaris"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Windows</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #WINDOWS
	 * @generated
	 * @ordered
	 */
	public static final OperatingSystemType WINDOWS_LITERAL = new OperatingSystemType(WINDOWS,
			"Windows", "Windows"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Open MVS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OPEN_MVS
	 * @generated
	 * @ordered
	 */
	public static final OperatingSystemType OPEN_MVS_LITERAL = new OperatingSystemType(OPEN_MVS,
			"OpenMVS", "OpenMVS"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>I5 Operating System</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #I5_OPERATING_SYSTEM
	 * @generated
	 * @ordered
	 */
	public static final OperatingSystemType I5_OPERATING_SYSTEM_LITERAL = new OperatingSystemType(
			I5_OPERATING_SYSTEM, "i5OperatingSystem", "i5OperatingSystem"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Mac OS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAC_OS
	 * @generated
	 * @ordered
	 */
	public static final OperatingSystemType MAC_OS_LITERAL = new OperatingSystemType(MAC_OS,
			"MacOS", "MacOS"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Net Ware</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NET_WARE
	 * @generated
	 * @ordered
	 */
	public static final OperatingSystemType NET_WARE_LITERAL = new OperatingSystemType(NET_WARE,
			"NetWare", "NetWare"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>VMware ESX</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VMWARE_ESX
	 * @generated
	 * @ordered
	 */
	public static final OperatingSystemType VMWARE_ESX_LITERAL = new OperatingSystemType(VMWARE_ESX,
			"VMwareESX", "VMwareESX"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Darwin</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DARWIN
	 * @generated
	 * @ordered
	 */
	public static final OperatingSystemType DARWIN_LITERAL = new OperatingSystemType(DARWIN,
			"Darwin", "Darwin"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Tru64</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRU64
	 * @generated
	 * @ordered
	 */
	public static final OperatingSystemType TRU64_LITERAL = new OperatingSystemType(TRU64,
			"Tru64", "Tru64"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Free BSD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FREE_BSD
	 * @generated
	 * @ordered
	 */
	public static final OperatingSystemType FREE_BSD_LITERAL = new OperatingSystemType(FREE_BSD,
			"FreeBSD", "FreeBSD"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>IPSO</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IPSO
	 * @generated
	 * @ordered
	 */
	public static final OperatingSystemType IPSO_LITERAL = new OperatingSystemType(IPSO,
			"IPSO", "IPSO"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>ZOS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZOS
	 * @generated
	 * @ordered
	 */
	public static final OperatingSystemType ZOS_LITERAL = new OperatingSystemType(ZOS, "zOS", "z/OS"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>ZVM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZVM
	 * @generated
	 * @ordered
	 */
	public static final OperatingSystemType ZVM_LITERAL = new OperatingSystemType(ZVM, "zVM", "z/VM"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>ZLinux</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZLINUX
	 * @generated
	 * @ordered
	 */
	public static final OperatingSystemType ZLINUX_LITERAL = new OperatingSystemType(ZLINUX,
			"zLinux", "z/Linux"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b></b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #_
	 * @generated
	 * @ordered
	 */
	public static final OperatingSystemType __LITERAL = new OperatingSystemType(_, "_", ""); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Operating System Type</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final OperatingSystemType[] VALUES_ARRAY = new OperatingSystemType[] {
			AIX_LITERAL, WINDOWS_CYGWIN_LITERAL, HPUX_LITERAL, LINUX_LITERAL, SOLARIS_LITERAL,
			WINDOWS_LITERAL, OPEN_MVS_LITERAL, I5_OPERATING_SYSTEM_LITERAL, MAC_OS_LITERAL,
			NET_WARE_LITERAL, VMWARE_ESX_LITERAL, DARWIN_LITERAL, TRU64_LITERAL, FREE_BSD_LITERAL,
			IPSO_LITERAL, ZOS_LITERAL, ZVM_LITERAL, ZLINUX_LITERAL, __LITERAL, };

	/**
	 * A public read-only list of all the '<em><b>Operating System Type</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Operating System Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static OperatingSystemType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			OperatingSystemType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Operating System Type</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static OperatingSystemType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			OperatingSystemType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Operating System Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static OperatingSystemType get(int value) {
		switch (value)
		{
		case AIX:
			return AIX_LITERAL;
		case WINDOWS_CYGWIN:
			return WINDOWS_CYGWIN_LITERAL;
		case HPUX:
			return HPUX_LITERAL;
		case LINUX:
			return LINUX_LITERAL;
		case SOLARIS:
			return SOLARIS_LITERAL;
		case WINDOWS:
			return WINDOWS_LITERAL;
		case OPEN_MVS:
			return OPEN_MVS_LITERAL;
		case I5_OPERATING_SYSTEM:
			return I5_OPERATING_SYSTEM_LITERAL;
		case MAC_OS:
			return MAC_OS_LITERAL;
		case NET_WARE:
			return NET_WARE_LITERAL;
		case VMWARE_ESX:
			return VMWARE_ESX_LITERAL;
		case DARWIN:
			return DARWIN_LITERAL;
		case TRU64:
			return TRU64_LITERAL;
		case FREE_BSD:
			return FREE_BSD_LITERAL;
		case IPSO:
			return IPSO_LITERAL;
		case ZOS:
			return ZOS_LITERAL;
		case ZVM:
			return ZVM_LITERAL;
		case ZLINUX:
			return ZLINUX_LITERAL;
		case _:
			return __LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private OperatingSystemType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //OperatingSystemType
