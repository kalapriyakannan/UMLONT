/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.sca;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SCA Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilityGenericSCAImplementation <em>Capability Generic SCA Implementation</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCABinding <em>Capability SCA Binding</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilityScaComponent <em>Capability Sca Component</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCAImplementationBPEL <em>Capability SCA Implementation BPEL</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCAImplementationComposite <em>Capability SCA Implementation Composite</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCAImplementationCplusplus <em>Capability SCA Implementation Cplusplus</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCAImplementationJava <em>Capability SCA Implementation Java</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCAInterface <em>Capability SCA Interface</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCAOperation <em>Capability SCA Operation</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCAPolicyIntent <em>Capability SCA Policy Intent</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCAPolicySet <em>Capability SCA Policy Set</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilityScaProperty <em>Capability Sca Property</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilityScaPropertyValue <em>Capability Sca Property Value</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCAReference <em>Capability SCA Reference</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilityScaService <em>Capability Sca Service</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitGenericscaImplementationUnit <em>Unit Genericsca Implementation Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCABindingUnit <em>Unit SCA Binding Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitScaComponentUnit <em>Unit Sca Component Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCAImplementationBPELUnit <em>Unit SCA Implementation BPEL Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCAImplementationCompositeUnit <em>Unit SCA Implementation Composite Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCAImplementationCplusplusUnit <em>Unit SCA Implementation Cplusplus Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCAImplementationJavaUnit <em>Unit SCA Implementation Java Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCAInterfaceUnit <em>Unit SCA Interface Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCAOperationUnit <em>Unit SCA Operation Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCAPolicyIntentUnit <em>Unit SCA Policy Intent Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCAPolicySetUnit <em>Unit SCA Policy Set Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitScaPropertyUnit <em>Unit Sca Property Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitScaPropertyValueUnit <em>Unit Sca Property Value Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCAReferenceUnit <em>Unit SCA Reference Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitScaServiceUnit <em>Unit Sca Service Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCARoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface SCARoot extends EObject {
	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCARoot_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XMLNS Prefix Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XMLNS Prefix Map</em>' map.
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCARoot_XMLNSPrefixMap()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String" valueType="java.lang.String" transient="true"
	 *        extendedMetaData="kind='attribute' name='xmlns:prefix'"
	 * @generated
	 */
	EMap getXMLNSPrefixMap();

	/**
	 * Returns the value of the '<em><b>XSI Schema Location</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XSI Schema Location</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XSI Schema Location</em>' map.
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCARoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry" keyType="java.lang.String" valueType="java.lang.String" transient="true"
	 *        extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
	 * @generated
	 */
	EMap getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Capability Generic SCA Implementation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Generic SCA Implementation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Generic SCA Implementation</em>' containment reference.
	 * @see #setCapabilityGenericSCAImplementation(GenericSCAImplementation)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCARoot_CapabilityGenericSCAImplementation()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.genericSCAImplementation' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	GenericSCAImplementation getCapabilityGenericSCAImplementation();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilityGenericSCAImplementation <em>Capability Generic SCA Implementation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Generic SCA Implementation</em>' containment reference.
	 * @see #getCapabilityGenericSCAImplementation()
	 * @generated
	 */
	void setCapabilityGenericSCAImplementation(GenericSCAImplementation value);

	/**
	 * Returns the value of the '<em><b>Capability SCA Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability SCA Binding</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability SCA Binding</em>' containment reference.
	 * @see #setCapabilitySCABinding(SCABinding)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCARoot_CapabilitySCABinding()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.SCABinding' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	SCABinding getCapabilitySCABinding();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCABinding <em>Capability SCA Binding</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability SCA Binding</em>' containment reference.
	 * @see #getCapabilitySCABinding()
	 * @generated
	 */
	void setCapabilitySCABinding(SCABinding value);

	/**
	 * Returns the value of the '<em><b>Capability Sca Component</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Sca Component</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Sca Component</em>' containment reference.
	 * @see #setCapabilityScaComponent(SCAComponent)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCARoot_CapabilityScaComponent()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.scaComponent' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	SCAComponent getCapabilityScaComponent();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilityScaComponent <em>Capability Sca Component</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Sca Component</em>' containment reference.
	 * @see #getCapabilityScaComponent()
	 * @generated
	 */
	void setCapabilityScaComponent(SCAComponent value);

	/**
	 * Returns the value of the '<em><b>Capability SCA Implementation BPEL</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability SCA Implementation BPEL</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability SCA Implementation BPEL</em>' containment reference.
	 * @see #setCapabilitySCAImplementationBPEL(SCAImplementationBPEL)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCARoot_CapabilitySCAImplementationBPEL()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.SCAImplementationBPEL' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	SCAImplementationBPEL getCapabilitySCAImplementationBPEL();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCAImplementationBPEL <em>Capability SCA Implementation BPEL</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability SCA Implementation BPEL</em>' containment reference.
	 * @see #getCapabilitySCAImplementationBPEL()
	 * @generated
	 */
	void setCapabilitySCAImplementationBPEL(SCAImplementationBPEL value);

	/**
	 * Returns the value of the '<em><b>Capability SCA Implementation Composite</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability SCA Implementation Composite</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability SCA Implementation Composite</em>' containment reference.
	 * @see #setCapabilitySCAImplementationComposite(SCAImplementationComposite)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCARoot_CapabilitySCAImplementationComposite()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.SCAImplementationComposite' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	SCAImplementationComposite getCapabilitySCAImplementationComposite();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCAImplementationComposite <em>Capability SCA Implementation Composite</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability SCA Implementation Composite</em>' containment reference.
	 * @see #getCapabilitySCAImplementationComposite()
	 * @generated
	 */
	void setCapabilitySCAImplementationComposite(SCAImplementationComposite value);

	/**
	 * Returns the value of the '<em><b>Capability SCA Implementation Cplusplus</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability SCA Implementation Cplusplus</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability SCA Implementation Cplusplus</em>' containment reference.
	 * @see #setCapabilitySCAImplementationCplusplus(SCAImplementationCplusplus)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCARoot_CapabilitySCAImplementationCplusplus()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.SCAImplementationCplusplus' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	SCAImplementationCplusplus getCapabilitySCAImplementationCplusplus();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCAImplementationCplusplus <em>Capability SCA Implementation Cplusplus</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability SCA Implementation Cplusplus</em>' containment reference.
	 * @see #getCapabilitySCAImplementationCplusplus()
	 * @generated
	 */
	void setCapabilitySCAImplementationCplusplus(SCAImplementationCplusplus value);

	/**
	 * Returns the value of the '<em><b>Capability SCA Implementation Java</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability SCA Implementation Java</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability SCA Implementation Java</em>' containment reference.
	 * @see #setCapabilitySCAImplementationJava(SCAImplementationJava)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCARoot_CapabilitySCAImplementationJava()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.SCAImplementationJava' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	SCAImplementationJava getCapabilitySCAImplementationJava();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCAImplementationJava <em>Capability SCA Implementation Java</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability SCA Implementation Java</em>' containment reference.
	 * @see #getCapabilitySCAImplementationJava()
	 * @generated
	 */
	void setCapabilitySCAImplementationJava(SCAImplementationJava value);

	/**
	 * Returns the value of the '<em><b>Capability SCA Interface</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability SCA Interface</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability SCA Interface</em>' containment reference.
	 * @see #setCapabilitySCAInterface(SCAInterface)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCARoot_CapabilitySCAInterface()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.SCAInterface' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	SCAInterface getCapabilitySCAInterface();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCAInterface <em>Capability SCA Interface</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability SCA Interface</em>' containment reference.
	 * @see #getCapabilitySCAInterface()
	 * @generated
	 */
	void setCapabilitySCAInterface(SCAInterface value);

	/**
	 * Returns the value of the '<em><b>Capability SCA Operation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability SCA Operation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability SCA Operation</em>' containment reference.
	 * @see #setCapabilitySCAOperation(SCAOperation)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCARoot_CapabilitySCAOperation()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.SCAOperation' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	SCAOperation getCapabilitySCAOperation();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCAOperation <em>Capability SCA Operation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability SCA Operation</em>' containment reference.
	 * @see #getCapabilitySCAOperation()
	 * @generated
	 */
	void setCapabilitySCAOperation(SCAOperation value);

	/**
	 * Returns the value of the '<em><b>Capability SCA Policy Intent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability SCA Policy Intent</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability SCA Policy Intent</em>' containment reference.
	 * @see #setCapabilitySCAPolicyIntent(SCAPolicyIntent)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCARoot_CapabilitySCAPolicyIntent()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.SCAPolicyIntent' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	SCAPolicyIntent getCapabilitySCAPolicyIntent();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCAPolicyIntent <em>Capability SCA Policy Intent</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability SCA Policy Intent</em>' containment reference.
	 * @see #getCapabilitySCAPolicyIntent()
	 * @generated
	 */
	void setCapabilitySCAPolicyIntent(SCAPolicyIntent value);

	/**
	 * Returns the value of the '<em><b>Capability SCA Policy Set</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability SCA Policy Set</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability SCA Policy Set</em>' containment reference.
	 * @see #setCapabilitySCAPolicySet(SCAPolicySet)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCARoot_CapabilitySCAPolicySet()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.SCAPolicySet' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	SCAPolicySet getCapabilitySCAPolicySet();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCAPolicySet <em>Capability SCA Policy Set</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability SCA Policy Set</em>' containment reference.
	 * @see #getCapabilitySCAPolicySet()
	 * @generated
	 */
	void setCapabilitySCAPolicySet(SCAPolicySet value);

	/**
	 * Returns the value of the '<em><b>Capability Sca Property</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Sca Property</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Sca Property</em>' containment reference.
	 * @see #setCapabilityScaProperty(SCAProperty)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCARoot_CapabilityScaProperty()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.scaProperty' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	SCAProperty getCapabilityScaProperty();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilityScaProperty <em>Capability Sca Property</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Sca Property</em>' containment reference.
	 * @see #getCapabilityScaProperty()
	 * @generated
	 */
	void setCapabilityScaProperty(SCAProperty value);

	/**
	 * Returns the value of the '<em><b>Capability Sca Property Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Sca Property Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Sca Property Value</em>' containment reference.
	 * @see #setCapabilityScaPropertyValue(ScaPropertyValue)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCARoot_CapabilityScaPropertyValue()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.scaPropertyValue' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	ScaPropertyValue getCapabilityScaPropertyValue();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilityScaPropertyValue <em>Capability Sca Property Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Sca Property Value</em>' containment reference.
	 * @see #getCapabilityScaPropertyValue()
	 * @generated
	 */
	void setCapabilityScaPropertyValue(ScaPropertyValue value);

	/**
	 * Returns the value of the '<em><b>Capability SCA Reference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability SCA Reference</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability SCA Reference</em>' containment reference.
	 * @see #setCapabilitySCAReference(SCAReference)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCARoot_CapabilitySCAReference()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.SCAReference' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	SCAReference getCapabilitySCAReference();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilitySCAReference <em>Capability SCA Reference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability SCA Reference</em>' containment reference.
	 * @see #getCapabilitySCAReference()
	 * @generated
	 */
	void setCapabilitySCAReference(SCAReference value);

	/**
	 * Returns the value of the '<em><b>Capability Sca Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capability Sca Service</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability Sca Service</em>' containment reference.
	 * @see #setCapabilityScaService(SCAService)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCARoot_CapabilityScaService()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='capability.scaService' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#capability'"
	 * @generated
	 */
	SCAService getCapabilityScaService();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getCapabilityScaService <em>Capability Sca Service</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability Sca Service</em>' containment reference.
	 * @see #getCapabilityScaService()
	 * @generated
	 */
	void setCapabilityScaService(SCAService value);

	/**
	 * Returns the value of the '<em><b>Unit Genericsca Implementation Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Genericsca Implementation Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Genericsca Implementation Unit</em>' containment reference.
	 * @see #setUnitGenericscaImplementationUnit(GenericSCAImplementationUnit)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCARoot_UnitGenericscaImplementationUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.genericscaImplementationUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	GenericSCAImplementationUnit getUnitGenericscaImplementationUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitGenericscaImplementationUnit <em>Unit Genericsca Implementation Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Genericsca Implementation Unit</em>' containment reference.
	 * @see #getUnitGenericscaImplementationUnit()
	 * @generated
	 */
	void setUnitGenericscaImplementationUnit(GenericSCAImplementationUnit value);

	/**
	 * Returns the value of the '<em><b>Unit SCA Binding Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit SCA Binding Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit SCA Binding Unit</em>' containment reference.
	 * @see #setUnitSCABindingUnit(SCABindingUnit)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCARoot_UnitSCABindingUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.SCABindingUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	SCABindingUnit getUnitSCABindingUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCABindingUnit <em>Unit SCA Binding Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit SCA Binding Unit</em>' containment reference.
	 * @see #getUnitSCABindingUnit()
	 * @generated
	 */
	void setUnitSCABindingUnit(SCABindingUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Sca Component Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Sca Component Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Sca Component Unit</em>' containment reference.
	 * @see #setUnitScaComponentUnit(SCAComponentUnit)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCARoot_UnitScaComponentUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.scaComponentUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	SCAComponentUnit getUnitScaComponentUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitScaComponentUnit <em>Unit Sca Component Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Sca Component Unit</em>' containment reference.
	 * @see #getUnitScaComponentUnit()
	 * @generated
	 */
	void setUnitScaComponentUnit(SCAComponentUnit value);

	/**
	 * Returns the value of the '<em><b>Unit SCA Implementation BPEL Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit SCA Implementation BPEL Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit SCA Implementation BPEL Unit</em>' containment reference.
	 * @see #setUnitSCAImplementationBPELUnit(SCAImplementationBPELUnit)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCARoot_UnitSCAImplementationBPELUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.SCAImplementationBPELUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	SCAImplementationBPELUnit getUnitSCAImplementationBPELUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCAImplementationBPELUnit <em>Unit SCA Implementation BPEL Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit SCA Implementation BPEL Unit</em>' containment reference.
	 * @see #getUnitSCAImplementationBPELUnit()
	 * @generated
	 */
	void setUnitSCAImplementationBPELUnit(SCAImplementationBPELUnit value);

	/**
	 * Returns the value of the '<em><b>Unit SCA Implementation Composite Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit SCA Implementation Composite Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit SCA Implementation Composite Unit</em>' containment reference.
	 * @see #setUnitSCAImplementationCompositeUnit(SCAImplementationCompositeUnit)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCARoot_UnitSCAImplementationCompositeUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.SCAImplementationCompositeUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	SCAImplementationCompositeUnit getUnitSCAImplementationCompositeUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCAImplementationCompositeUnit <em>Unit SCA Implementation Composite Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit SCA Implementation Composite Unit</em>' containment reference.
	 * @see #getUnitSCAImplementationCompositeUnit()
	 * @generated
	 */
	void setUnitSCAImplementationCompositeUnit(SCAImplementationCompositeUnit value);

	/**
	 * Returns the value of the '<em><b>Unit SCA Implementation Cplusplus Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit SCA Implementation Cplusplus Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit SCA Implementation Cplusplus Unit</em>' containment reference.
	 * @see #setUnitSCAImplementationCplusplusUnit(SCAImplementationCplusplusUnit)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCARoot_UnitSCAImplementationCplusplusUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.SCAImplementationCplusplusUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	SCAImplementationCplusplusUnit getUnitSCAImplementationCplusplusUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCAImplementationCplusplusUnit <em>Unit SCA Implementation Cplusplus Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit SCA Implementation Cplusplus Unit</em>' containment reference.
	 * @see #getUnitSCAImplementationCplusplusUnit()
	 * @generated
	 */
	void setUnitSCAImplementationCplusplusUnit(SCAImplementationCplusplusUnit value);

	/**
	 * Returns the value of the '<em><b>Unit SCA Implementation Java Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit SCA Implementation Java Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit SCA Implementation Java Unit</em>' containment reference.
	 * @see #setUnitSCAImplementationJavaUnit(SCAImplementationJavaUnit)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCARoot_UnitSCAImplementationJavaUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.SCAImplementationJavaUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	SCAImplementationJavaUnit getUnitSCAImplementationJavaUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCAImplementationJavaUnit <em>Unit SCA Implementation Java Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit SCA Implementation Java Unit</em>' containment reference.
	 * @see #getUnitSCAImplementationJavaUnit()
	 * @generated
	 */
	void setUnitSCAImplementationJavaUnit(SCAImplementationJavaUnit value);

	/**
	 * Returns the value of the '<em><b>Unit SCA Interface Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit SCA Interface Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit SCA Interface Unit</em>' containment reference.
	 * @see #setUnitSCAInterfaceUnit(SCAInterfaceUnit)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCARoot_UnitSCAInterfaceUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.SCAInterfaceUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	SCAInterfaceUnit getUnitSCAInterfaceUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCAInterfaceUnit <em>Unit SCA Interface Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit SCA Interface Unit</em>' containment reference.
	 * @see #getUnitSCAInterfaceUnit()
	 * @generated
	 */
	void setUnitSCAInterfaceUnit(SCAInterfaceUnit value);

	/**
	 * Returns the value of the '<em><b>Unit SCA Operation Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit SCA Operation Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit SCA Operation Unit</em>' containment reference.
	 * @see #setUnitSCAOperationUnit(SCAOperationUnit)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCARoot_UnitSCAOperationUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.SCAOperationUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	SCAOperationUnit getUnitSCAOperationUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCAOperationUnit <em>Unit SCA Operation Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit SCA Operation Unit</em>' containment reference.
	 * @see #getUnitSCAOperationUnit()
	 * @generated
	 */
	void setUnitSCAOperationUnit(SCAOperationUnit value);

	/**
	 * Returns the value of the '<em><b>Unit SCA Policy Intent Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit SCA Policy Intent Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit SCA Policy Intent Unit</em>' containment reference.
	 * @see #setUnitSCAPolicyIntentUnit(SCAPolicyIntentUnit)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCARoot_UnitSCAPolicyIntentUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.SCAPolicyIntentUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	SCAPolicyIntentUnit getUnitSCAPolicyIntentUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCAPolicyIntentUnit <em>Unit SCA Policy Intent Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit SCA Policy Intent Unit</em>' containment reference.
	 * @see #getUnitSCAPolicyIntentUnit()
	 * @generated
	 */
	void setUnitSCAPolicyIntentUnit(SCAPolicyIntentUnit value);

	/**
	 * Returns the value of the '<em><b>Unit SCA Policy Set Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit SCA Policy Set Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit SCA Policy Set Unit</em>' containment reference.
	 * @see #setUnitSCAPolicySetUnit(SCAPolicySetUnit)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCARoot_UnitSCAPolicySetUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.SCAPolicySetUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	SCAPolicySetUnit getUnitSCAPolicySetUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCAPolicySetUnit <em>Unit SCA Policy Set Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit SCA Policy Set Unit</em>' containment reference.
	 * @see #getUnitSCAPolicySetUnit()
	 * @generated
	 */
	void setUnitSCAPolicySetUnit(SCAPolicySetUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Sca Property Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Sca Property Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Sca Property Unit</em>' containment reference.
	 * @see #setUnitScaPropertyUnit(SCAPropertyUnit)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCARoot_UnitScaPropertyUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.scaPropertyUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	SCAPropertyUnit getUnitScaPropertyUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitScaPropertyUnit <em>Unit Sca Property Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Sca Property Unit</em>' containment reference.
	 * @see #getUnitScaPropertyUnit()
	 * @generated
	 */
	void setUnitScaPropertyUnit(SCAPropertyUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Sca Property Value Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Sca Property Value Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Sca Property Value Unit</em>' containment reference.
	 * @see #setUnitScaPropertyValueUnit(SCAPropertyValueUnit)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCARoot_UnitScaPropertyValueUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.scaPropertyValueUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	SCAPropertyValueUnit getUnitScaPropertyValueUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitScaPropertyValueUnit <em>Unit Sca Property Value Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Sca Property Value Unit</em>' containment reference.
	 * @see #getUnitScaPropertyValueUnit()
	 * @generated
	 */
	void setUnitScaPropertyValueUnit(SCAPropertyValueUnit value);

	/**
	 * Returns the value of the '<em><b>Unit SCA Reference Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit SCA Reference Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit SCA Reference Unit</em>' containment reference.
	 * @see #setUnitSCAReferenceUnit(SCAReferenceUnit)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCARoot_UnitSCAReferenceUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.SCAReferenceUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	SCAReferenceUnit getUnitSCAReferenceUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitSCAReferenceUnit <em>Unit SCA Reference Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit SCA Reference Unit</em>' containment reference.
	 * @see #getUnitSCAReferenceUnit()
	 * @generated
	 */
	void setUnitSCAReferenceUnit(SCAReferenceUnit value);

	/**
	 * Returns the value of the '<em><b>Unit Sca Service Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Sca Service Unit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Sca Service Unit</em>' containment reference.
	 * @see #setUnitScaServiceUnit(SCAServiceUnit)
	 * @see com.ibm.ccl.soa.deploy.sca.ScaPackage#getSCARoot_UnitScaServiceUnit()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='unit.scaServiceUnit' namespace='##targetNamespace' affiliation='http://www.ibm.com/ccl/soa/deploy/core/1.0.0/#unit'"
	 * @generated
	 */
	SCAServiceUnit getUnitScaServiceUnit();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.sca.SCARoot#getUnitScaServiceUnit <em>Unit Sca Service Unit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit Sca Service Unit</em>' containment reference.
	 * @see #getUnitScaServiceUnit()
	 * @generated
	 */
	void setUnitScaServiceUnit(SCAServiceUnit value);

} // SCARoot
