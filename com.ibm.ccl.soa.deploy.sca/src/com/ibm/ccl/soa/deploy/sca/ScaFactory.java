/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.sca;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage
 * @generated
 */
public interface ScaFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ScaFactory eINSTANCE = com.ibm.ccl.soa.deploy.sca.impl.ScaFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Generic SCA Implementation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Generic SCA Implementation</em>'.
	 * @generated
	 */
	GenericSCAImplementation createGenericSCAImplementation();

	/**
	 * Returns a new object of class '<em>Generic SCA Implementation Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Generic SCA Implementation Unit</em>'.
	 * @generated
	 */
	GenericSCAImplementationUnit createGenericSCAImplementationUnit();

	/**
	 * Returns a new object of class '<em>SCA Binding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCA Binding</em>'.
	 * @generated
	 */
	SCABinding createSCABinding();

	/**
	 * Returns a new object of class '<em>SCA Binding Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCA Binding Unit</em>'.
	 * @generated
	 */
	SCABindingUnit createSCABindingUnit();

	/**
	 * Returns a new object of class '<em>SCA Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCA Component</em>'.
	 * @generated
	 */
	SCAComponent createSCAComponent();

	/**
	 * Returns a new object of class '<em>SCA Component Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCA Component Unit</em>'.
	 * @generated
	 */
	SCAComponentUnit createSCAComponentUnit();

	/**
	 * Returns a new object of class '<em>SCA Implementation BPEL</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCA Implementation BPEL</em>'.
	 * @generated
	 */
	SCAImplementationBPEL createSCAImplementationBPEL();

	/**
	 * Returns a new object of class '<em>SCA Implementation BPEL Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCA Implementation BPEL Unit</em>'.
	 * @generated
	 */
	SCAImplementationBPELUnit createSCAImplementationBPELUnit();

	/**
	 * Returns a new object of class '<em>SCA Implementation Composite</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCA Implementation Composite</em>'.
	 * @generated
	 */
	SCAImplementationComposite createSCAImplementationComposite();

	/**
	 * Returns a new object of class '<em>SCA Implementation Composite Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCA Implementation Composite Unit</em>'.
	 * @generated
	 */
	SCAImplementationCompositeUnit createSCAImplementationCompositeUnit();

	/**
	 * Returns a new object of class '<em>SCA Implementation Cplusplus</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCA Implementation Cplusplus</em>'.
	 * @generated
	 */
	SCAImplementationCplusplus createSCAImplementationCplusplus();

	/**
	 * Returns a new object of class '<em>SCA Implementation Cplusplus Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCA Implementation Cplusplus Unit</em>'.
	 * @generated
	 */
	SCAImplementationCplusplusUnit createSCAImplementationCplusplusUnit();

	/**
	 * Returns a new object of class '<em>SCA Implementation Java</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCA Implementation Java</em>'.
	 * @generated
	 */
	SCAImplementationJava createSCAImplementationJava();

	/**
	 * Returns a new object of class '<em>SCA Implementation Java Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCA Implementation Java Unit</em>'.
	 * @generated
	 */
	SCAImplementationJavaUnit createSCAImplementationJavaUnit();

	/**
	 * Returns a new object of class '<em>SCA Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCA Interface</em>'.
	 * @generated
	 */
	SCAInterface createSCAInterface();

	/**
	 * Returns a new object of class '<em>SCA Interface Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCA Interface Unit</em>'.
	 * @generated
	 */
	SCAInterfaceUnit createSCAInterfaceUnit();

	/**
	 * Returns a new object of class '<em>SCA Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCA Operation</em>'.
	 * @generated
	 */
	SCAOperation createSCAOperation();

	/**
	 * Returns a new object of class '<em>SCA Operation Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCA Operation Unit</em>'.
	 * @generated
	 */
	SCAOperationUnit createSCAOperationUnit();

	/**
	 * Returns a new object of class '<em>SCA Policy Intent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCA Policy Intent</em>'.
	 * @generated
	 */
	SCAPolicyIntent createSCAPolicyIntent();

	/**
	 * Returns a new object of class '<em>SCA Policy Intent Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCA Policy Intent Unit</em>'.
	 * @generated
	 */
	SCAPolicyIntentUnit createSCAPolicyIntentUnit();

	/**
	 * Returns a new object of class '<em>SCA Policy Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCA Policy Set</em>'.
	 * @generated
	 */
	SCAPolicySet createSCAPolicySet();

	/**
	 * Returns a new object of class '<em>SCA Policy Set Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCA Policy Set Unit</em>'.
	 * @generated
	 */
	SCAPolicySetUnit createSCAPolicySetUnit();

	/**
	 * Returns a new object of class '<em>SCA Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCA Property</em>'.
	 * @generated
	 */
	SCAProperty createSCAProperty();

	/**
	 * Returns a new object of class '<em>SCA Property Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCA Property Unit</em>'.
	 * @generated
	 */
	SCAPropertyUnit createSCAPropertyUnit();

	/**
	 * Returns a new object of class '<em>Property Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Value</em>'.
	 * @generated
	 */
	ScaPropertyValue createScaPropertyValue();

	/**
	 * Returns a new object of class '<em>SCA Property Value Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCA Property Value Unit</em>'.
	 * @generated
	 */
	SCAPropertyValueUnit createSCAPropertyValueUnit();

	/**
	 * Returns a new object of class '<em>SCA Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCA Reference</em>'.
	 * @generated
	 */
	SCAReference createSCAReference();

	/**
	 * Returns a new object of class '<em>SCA Reference Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCA Reference Unit</em>'.
	 * @generated
	 */
	SCAReferenceUnit createSCAReferenceUnit();

	/**
	 * Returns a new object of class '<em>SCA Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCA Root</em>'.
	 * @generated
	 */
	SCARoot createSCARoot();

	/**
	 * Returns a new object of class '<em>SCA Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCA Service</em>'.
	 * @generated
	 */
	SCAService createSCAService();

	/**
	 * Returns a new object of class '<em>SCA Service Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCA Service Unit</em>'.
	 * @generated
	 */
	SCAServiceUnit createSCAServiceUnit();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ScaPackage getScaPackage();

} //ScaFactory
