/**
 * <copyright>
 * </copyright>
 *
 * $Id: LifespanState.java,v 1.1 2007/12/03 20:16:13 nmakin Exp $
 */
package com.ibm.ccl.soa.deploy.analysis;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Lifespan State</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * 
 * 				The state of the lifespan of service.
 * 			
 * <!-- end-model-doc -->
 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getLifespanState()
 * @model extendedMetaData="name='LifespanState'"
 * @generated
 */
public final class LifespanState extends AbstractEnumerator {
	/**
	 * The '<em><b>Active</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Active</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACTIVE_LITERAL
	 * @model name="active"
	 * @generated
	 * @ordered
	 */
	public static final int ACTIVE = 0;

	/**
	 * The '<em><b>Accessible</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Accessible</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACCESSIBLE_LITERAL
	 * @model name="accessible"
	 * @generated
	 * @ordered
	 */
	public static final int ACCESSIBLE = 1;

	/**
	 * The '<em><b>Active</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACTIVE
	 * @generated
	 * @ordered
	 */
	public static final LifespanState ACTIVE_LITERAL = new LifespanState(ACTIVE, "active", "active"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Accessible</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACCESSIBLE
	 * @generated
	 * @ordered
	 */
	public static final LifespanState ACCESSIBLE_LITERAL = new LifespanState(ACCESSIBLE, "accessible", "accessible"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Lifespan State</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final LifespanState[] VALUES_ARRAY =
		new LifespanState[] {
			ACTIVE_LITERAL,
			ACCESSIBLE_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Lifespan State</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Lifespan State</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LifespanState get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			LifespanState result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Lifespan State</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LifespanState getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			LifespanState result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Lifespan State</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LifespanState get(int value) {
		switch (value) {
			case ACTIVE: return ACTIVE_LITERAL;
			case ACCESSIBLE: return ACCESSIBLE_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private LifespanState(int value, String name, String literal) {
		super(value, name, literal);
	}

} //LifespanState
