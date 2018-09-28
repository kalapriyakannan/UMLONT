/**
 * <copyright>
 * </copyright>
 *
 * $Id: DataServiceType.java,v 1.1 2007/12/03 20:16:13 nmakin Exp $
 */
package com.ibm.ccl.soa.deploy.analysis;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Data Service Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * 
 * 				The types of data service.
 * 			
 * <!-- end-model-doc -->
 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getDataServiceType()
 * @model extendedMetaData="name='DataServiceType'"
 * @generated
 */
public final class DataServiceType extends AbstractEnumerator {
	/**
	 * The '<em><b>Online Interactive</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Online Interactive</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ONLINE_INTERACTIVE_LITERAL
	 * @model name="onlineInteractive" literal="online interactive"
	 * @generated
	 * @ordered
	 */
	public static final int ONLINE_INTERACTIVE = 0;

	/**
	 * The '<em><b>Offline</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Offline</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OFFLINE_LITERAL
	 * @model name="offline"
	 * @generated
	 * @ordered
	 */
	public static final int OFFLINE = 1;

	/**
	 * The '<em><b>Archive</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Archive</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ARCHIVE_LITERAL
	 * @model name="archive"
	 * @generated
	 * @ordered
	 */
	public static final int ARCHIVE = 2;

	/**
	 * The '<em><b>Replicated</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Replicated</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REPLICATED_LITERAL
	 * @model name="replicated"
	 * @generated
	 * @ordered
	 */
	public static final int REPLICATED = 3;

	/**
	 * The '<em><b>Online Interactive</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ONLINE_INTERACTIVE
	 * @generated
	 * @ordered
	 */
	public static final DataServiceType ONLINE_INTERACTIVE_LITERAL = new DataServiceType(ONLINE_INTERACTIVE, "onlineInteractive", "online interactive"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Offline</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OFFLINE
	 * @generated
	 * @ordered
	 */
	public static final DataServiceType OFFLINE_LITERAL = new DataServiceType(OFFLINE, "offline", "offline"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Archive</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARCHIVE
	 * @generated
	 * @ordered
	 */
	public static final DataServiceType ARCHIVE_LITERAL = new DataServiceType(ARCHIVE, "archive", "archive"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Replicated</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REPLICATED
	 * @generated
	 * @ordered
	 */
	public static final DataServiceType REPLICATED_LITERAL = new DataServiceType(REPLICATED, "replicated", "replicated"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Data Service Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final DataServiceType[] VALUES_ARRAY =
		new DataServiceType[] {
			ONLINE_INTERACTIVE_LITERAL,
			OFFLINE_LITERAL,
			ARCHIVE_LITERAL,
			REPLICATED_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Data Service Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Data Service Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DataServiceType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DataServiceType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Data Service Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DataServiceType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DataServiceType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Data Service Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DataServiceType get(int value) {
		switch (value) {
			case ONLINE_INTERACTIVE: return ONLINE_INTERACTIVE_LITERAL;
			case OFFLINE: return OFFLINE_LITERAL;
			case ARCHIVE: return ARCHIVE_LITERAL;
			case REPLICATED: return REPLICATED_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private DataServiceType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //DataServiceType
