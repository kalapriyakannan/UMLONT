/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.was;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Certificate Map Mode</b></em>',
 * and utility methods for working with them. <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.was.WasPackage#getCertificateMapMode()
 * @model extendedMetaData="name='CertificateMapMode'"
 * @generated
 */
public final class CertificateMapMode extends AbstractEnumerator {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The '<em><b>EXACTDN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EXACTDN</b></em>' literal object isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXACTDN_LITERAL
	 * @model literal="EXACT_DN"
	 * @generated
	 * @ordered
	 */
	public static final int EXACTDN = 0;

	/**
	 * The '<em><b>CERTIFICATEFILTER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CERTIFICATEFILTER</b></em>' literal object isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CERTIFICATEFILTER_LITERAL
	 * @model literal="CERTIFICATE_FILTER"
	 * @generated
	 * @ordered
	 */
	public static final int CERTIFICATEFILTER = 1;

	/**
	 * The '<em><b>Other</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Other</b></em>' literal object isn't clear, there really should
	 * be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #OTHER_LITERAL
	 * @model name="other"
	 * @generated
	 * @ordered
	 */
	public static final int OTHER = 2;

	/**
	 * The '<em><b>EXACTDN</b></em>' literal object. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #EXACTDN
	 * @generated
	 * @ordered
	 */
	public static final CertificateMapMode EXACTDN_LITERAL = new CertificateMapMode(EXACTDN, "EXACTDN", "EXACT_DN"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>CERTIFICATEFILTER</b></em>' literal object.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #CERTIFICATEFILTER
	 * @generated
	 * @ordered
	 */
	public static final CertificateMapMode CERTIFICATEFILTER_LITERAL = new CertificateMapMode(CERTIFICATEFILTER, "CERTIFICATEFILTER", "CERTIFICATE_FILTER"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Other</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #OTHER
	 * @generated
	 * @ordered
	 */
	public static final CertificateMapMode OTHER_LITERAL = new CertificateMapMode(OTHER, "other", "other"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Certificate Map Mode</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final CertificateMapMode[] VALUES_ARRAY = new CertificateMapMode[] {
			EXACTDN_LITERAL,
			CERTIFICATEFILTER_LITERAL,
			OTHER_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Certificate Map Mode</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Certificate Map Mode</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static CertificateMapMode get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CertificateMapMode result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Certificate Map Mode</b></em>' literal with the specified name. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static CertificateMapMode getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CertificateMapMode result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Certificate Map Mode</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static CertificateMapMode get(int value) {
		switch (value) {
			case EXACTDN: return EXACTDN_LITERAL;
			case CERTIFICATEFILTER: return CERTIFICATEFILTER_LITERAL;
			case OTHER: return OTHER_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private CertificateMapMode(int value, String name, String literal) {
		super(value, name, literal);
	}

} //CertificateMapMode
