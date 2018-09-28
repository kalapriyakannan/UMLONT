/**
 * <copyright>
 * </copyright>
 *
 * $Id: VMwareIDEDeviceType.java,v 1.2 2008/04/04 02:57:18 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>VMware IDE Device Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareIDEDeviceType()
 * @model extendedMetaData="name='VMwareIDEDeviceType'"
 * @generated
 */
public final class VMwareIDEDeviceType extends AbstractEnumerator {
	/**
	 * The '<em><b>Cdrom Raw</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Cdrom Raw</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CDROM_RAW_LITERAL
	 * @model name="cdromRaw" literal="cdrom-raw"
	 * @generated
	 * @ordered
	 */
	public static final int CDROM_RAW = 0;

	/**
	 * The '<em><b>Cdrom Image</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Cdrom Image</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CDROM_IMAGE_LITERAL
	 * @model name="cdromImage" literal="cdrom-image"
	 * @generated
	 * @ordered
	 */
	public static final int CDROM_IMAGE = 1;

	/**
	 * The '<em><b>Atapi Cdrom</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Atapi Cdrom</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ATAPI_CDROM_LITERAL
	 * @model name="atapiCdrom" literal="atapi-cdrom"
	 * @generated
	 * @ordered
	 */
	public static final int ATAPI_CDROM = 2;

	/**
	 * The '<em><b>Disk</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Disk</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DISK_LITERAL
	 * @model name="disk"
	 * @generated
	 * @ordered
	 */
	public static final int DISK = 3;

	/**
	 * The '<em><b>Raw Disk</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Raw Disk</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RAW_DISK_LITERAL
	 * @model name="rawDisk"
	 * @generated
	 * @ordered
	 */
	public static final int RAW_DISK = 4;

	/**
	 * The '<em><b>Ata Hard Disk</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ata Hard Disk</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ATA_HARD_DISK_LITERAL
	 * @model name="ataHardDisk" literal="ata-hardDisk"
	 * @generated
	 * @ordered
	 */
	public static final int ATA_HARD_DISK = 5;

	/**
	 * The '<em><b>Cdrom Raw</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CDROM_RAW
	 * @generated
	 * @ordered
	 */
	public static final VMwareIDEDeviceType CDROM_RAW_LITERAL = new VMwareIDEDeviceType(CDROM_RAW, "cdromRaw", "cdrom-raw"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Cdrom Image</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CDROM_IMAGE
	 * @generated
	 * @ordered
	 */
	public static final VMwareIDEDeviceType CDROM_IMAGE_LITERAL = new VMwareIDEDeviceType(CDROM_IMAGE, "cdromImage", "cdrom-image"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Atapi Cdrom</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ATAPI_CDROM
	 * @generated
	 * @ordered
	 */
	public static final VMwareIDEDeviceType ATAPI_CDROM_LITERAL = new VMwareIDEDeviceType(ATAPI_CDROM, "atapiCdrom", "atapi-cdrom"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Disk</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DISK
	 * @generated
	 * @ordered
	 */
	public static final VMwareIDEDeviceType DISK_LITERAL = new VMwareIDEDeviceType(DISK, "disk", "disk"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Raw Disk</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RAW_DISK
	 * @generated
	 * @ordered
	 */
	public static final VMwareIDEDeviceType RAW_DISK_LITERAL = new VMwareIDEDeviceType(RAW_DISK, "rawDisk", "rawDisk"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Ata Hard Disk</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ATA_HARD_DISK
	 * @generated
	 * @ordered
	 */
	public static final VMwareIDEDeviceType ATA_HARD_DISK_LITERAL = new VMwareIDEDeviceType(ATA_HARD_DISK, "ataHardDisk", "ata-hardDisk"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>VMware IDE Device Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final VMwareIDEDeviceType[] VALUES_ARRAY =
		new VMwareIDEDeviceType[] {
			CDROM_RAW_LITERAL,
			CDROM_IMAGE_LITERAL,
			ATAPI_CDROM_LITERAL,
			DISK_LITERAL,
			RAW_DISK_LITERAL,
			ATA_HARD_DISK_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>VMware IDE Device Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>VMware IDE Device Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VMwareIDEDeviceType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			VMwareIDEDeviceType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>VMware IDE Device Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VMwareIDEDeviceType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			VMwareIDEDeviceType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>VMware IDE Device Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VMwareIDEDeviceType get(int value) {
		switch (value) {
			case CDROM_RAW: return CDROM_RAW_LITERAL;
			case CDROM_IMAGE: return CDROM_IMAGE_LITERAL;
			case ATAPI_CDROM: return ATAPI_CDROM_LITERAL;
			case DISK: return DISK_LITERAL;
			case RAW_DISK: return RAW_DISK_LITERAL;
			case ATA_HARD_DISK: return ATA_HARD_DISK_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private VMwareIDEDeviceType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //VMwareIDEDeviceType
