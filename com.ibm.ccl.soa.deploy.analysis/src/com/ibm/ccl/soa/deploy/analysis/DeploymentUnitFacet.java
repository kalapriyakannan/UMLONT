/**
 * <copyright>
 * </copyright>
 *
 * $Id: DeploymentUnitFacet.java,v 1.1 2007/10/10 20:13:27 nmakin Exp $
 */
package com.ibm.ccl.soa.deploy.analysis;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.AbstractEnumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Deployment Unit Facet</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * 
 * 				This represents the different facet of the deployment unit like Presentation, Execution and Data.
 * 			
 * <!-- end-model-doc -->
 * @see com.ibm.ccl.soa.deploy.analysis.AnalysisPackage#getDeploymentUnitFacet()
 * @model extendedMetaData="name='DeploymentUnitFacet'"
 * @generated
 */
public final class DeploymentUnitFacet extends AbstractEnumerator {
	/**
	 * The '<em><b>Undefined</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Undefined</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNDEFINED_LITERAL
	 * @model name="undefined"
	 * @generated
	 * @ordered
	 */
	public static final int UNDEFINED = 0;

	/**
	 * The '<em><b>Presentation</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Presentation</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PRESENTATION_LITERAL
	 * @model name="presentation"
	 * @generated
	 * @ordered
	 */
	public static final int PRESENTATION = 1;

	/**
	 * The '<em><b>Execution</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Execution</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXECUTION_LITERAL
	 * @model name="execution"
	 * @generated
	 * @ordered
	 */
	public static final int EXECUTION = 2;

	/**
	 * The '<em><b>Data</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Data</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DATA_LITERAL
	 * @model name="data"
	 * @generated
	 * @ordered
	 */
	public static final int DATA = 3;

	/**
	 * The '<em><b>Undefined</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNDEFINED
	 * @generated
	 * @ordered
	 */
	public static final DeploymentUnitFacet UNDEFINED_LITERAL = new DeploymentUnitFacet(UNDEFINED, "undefined", "undefined"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Presentation</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PRESENTATION
	 * @generated
	 * @ordered
	 */
	public static final DeploymentUnitFacet PRESENTATION_LITERAL = new DeploymentUnitFacet(PRESENTATION, "presentation", "presentation"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Execution</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXECUTION
	 * @generated
	 * @ordered
	 */
	public static final DeploymentUnitFacet EXECUTION_LITERAL = new DeploymentUnitFacet(EXECUTION, "execution", "execution"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * The '<em><b>Data</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DATA
	 * @generated
	 * @ordered
	 */
	public static final DeploymentUnitFacet DATA_LITERAL = new DeploymentUnitFacet(DATA, "data", "data"); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * An array of all the '<em><b>Deployment Unit Facet</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final DeploymentUnitFacet[] VALUES_ARRAY =
		new DeploymentUnitFacet[] {
			UNDEFINED_LITERAL,
			PRESENTATION_LITERAL,
			EXECUTION_LITERAL,
			DATA_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Deployment Unit Facet</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Deployment Unit Facet</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DeploymentUnitFacet get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DeploymentUnitFacet result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Deployment Unit Facet</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DeploymentUnitFacet getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			DeploymentUnitFacet result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Deployment Unit Facet</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DeploymentUnitFacet get(int value) {
		switch (value) {
			case UNDEFINED: return UNDEFINED_LITERAL;
			case PRESENTATION: return PRESENTATION_LITERAL;
			case EXECUTION: return EXECUTION_LITERAL;
			case DATA: return DATA_LITERAL;
		}
		return null;
	}

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private DeploymentUnitFacet(int value, String name, String literal) {
		super(value, name, literal);
	}

} //DeploymentUnitFacet
