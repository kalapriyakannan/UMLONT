/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExecutionServiceType.java,v 1.1 2007/12/03 20:16:13 nmakin Exp $
 */
package com.ibm.ccl.soa.deploy.analysis;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Execution Service Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * 
 * 				The types of execution service.
 * 			
 * <!-- end-model-doc -->
 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getExecutionServiceType()
 * @model extendedMetaData="name='ExecutionServiceType'"
 * @generated
 */
public final class ExecutionServiceType extends AbstractEnumerator {
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
	 * The '<em><b>Real Time</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Real Time</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REAL_TIME_LITERAL
	 * @model name="realTime" literal="real time"
	 * @generated
	 * @ordered
	 */
	public static final int REAL_TIME = 2;

	/**
	 * The '<em><b>Online Interactive</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ONLINE_INTERACTIVE
	 * @generated
	 * @ordered
	 */
	public static final ExecutionServiceType ONLINE_INTERACTIVE_LITERAL = new ExecutionServiceType(ONLINE_INTERACTIVE, "onlineInteractive", "online interactive"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Offline</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OFFLINE
	 * @generated
	 * @ordered
	 */
	public static final ExecutionServiceType OFFLINE_LITERAL = new ExecutionServiceType(OFFLINE, "offline", "offline"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Real Time</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REAL_TIME
	 * @generated
	 * @ordered
	 */
	public static final ExecutionServiceType REAL_TIME_LITERAL = new ExecutionServiceType(REAL_TIME, "realTime", "real time"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Execution Service Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ExecutionServiceType[] VALUES_ARRAY =
		new ExecutionServiceType[] {
			ONLINE_INTERACTIVE_LITERAL,
			OFFLINE_LITERAL,
			REAL_TIME_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Execution Service Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Execution Service Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExecutionServiceType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ExecutionServiceType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Execution Service Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExecutionServiceType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ExecutionServiceType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Execution Service Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExecutionServiceType get(int value) {
		switch (value) {
			case ONLINE_INTERACTIVE: return ONLINE_INTERACTIVE_LITERAL;
			case OFFLINE: return OFFLINE_LITERAL;
			case REAL_TIME: return REAL_TIME_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ExecutionServiceType(int value, String name, String literal) {
		super(value, name, literal);
	}

} //ExecutionServiceType
