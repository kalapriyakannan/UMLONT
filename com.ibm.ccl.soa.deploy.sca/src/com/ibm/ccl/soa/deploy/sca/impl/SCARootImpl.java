/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.sca.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.ibm.ccl.soa.deploy.sca.GenericSCAImplementation;
import com.ibm.ccl.soa.deploy.sca.GenericSCAImplementationUnit;
import com.ibm.ccl.soa.deploy.sca.SCABinding;
import com.ibm.ccl.soa.deploy.sca.SCABindingUnit;
import com.ibm.ccl.soa.deploy.sca.SCAComponent;
import com.ibm.ccl.soa.deploy.sca.SCAComponentUnit;
import com.ibm.ccl.soa.deploy.sca.SCAImplementationBPEL;
import com.ibm.ccl.soa.deploy.sca.SCAImplementationBPELUnit;
import com.ibm.ccl.soa.deploy.sca.SCAImplementationComposite;
import com.ibm.ccl.soa.deploy.sca.SCAImplementationCompositeUnit;
import com.ibm.ccl.soa.deploy.sca.SCAImplementationCplusplus;
import com.ibm.ccl.soa.deploy.sca.SCAImplementationCplusplusUnit;
import com.ibm.ccl.soa.deploy.sca.SCAImplementationJava;
import com.ibm.ccl.soa.deploy.sca.SCAImplementationJavaUnit;
import com.ibm.ccl.soa.deploy.sca.SCAInterface;
import com.ibm.ccl.soa.deploy.sca.SCAInterfaceUnit;
import com.ibm.ccl.soa.deploy.sca.SCAOperation;
import com.ibm.ccl.soa.deploy.sca.SCAOperationUnit;
import com.ibm.ccl.soa.deploy.sca.SCAPolicyIntent;
import com.ibm.ccl.soa.deploy.sca.SCAPolicyIntentUnit;
import com.ibm.ccl.soa.deploy.sca.SCAPolicySet;
import com.ibm.ccl.soa.deploy.sca.SCAPolicySetUnit;
import com.ibm.ccl.soa.deploy.sca.SCAProperty;
import com.ibm.ccl.soa.deploy.sca.SCAPropertyUnit;
import com.ibm.ccl.soa.deploy.sca.SCAPropertyValueUnit;
import com.ibm.ccl.soa.deploy.sca.SCAReference;
import com.ibm.ccl.soa.deploy.sca.SCAReferenceUnit;
import com.ibm.ccl.soa.deploy.sca.SCARoot;
import com.ibm.ccl.soa.deploy.sca.SCAService;
import com.ibm.ccl.soa.deploy.sca.SCAServiceUnit;
import com.ibm.ccl.soa.deploy.sca.ScaPackage;
import com.ibm.ccl.soa.deploy.sca.ScaPropertyValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SCA Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl#getCapabilityGenericSCAImplementation <em>Capability Generic SCA Implementation</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl#getCapabilitySCABinding <em>Capability SCA Binding</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl#getCapabilityScaComponent <em>Capability Sca Component</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl#getCapabilitySCAImplementationBPEL <em>Capability SCA Implementation BPEL</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl#getCapabilitySCAImplementationComposite <em>Capability SCA Implementation Composite</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl#getCapabilitySCAImplementationCplusplus <em>Capability SCA Implementation Cplusplus</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl#getCapabilitySCAImplementationJava <em>Capability SCA Implementation Java</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl#getCapabilitySCAInterface <em>Capability SCA Interface</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl#getCapabilitySCAOperation <em>Capability SCA Operation</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl#getCapabilitySCAPolicyIntent <em>Capability SCA Policy Intent</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl#getCapabilitySCAPolicySet <em>Capability SCA Policy Set</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl#getCapabilityScaProperty <em>Capability Sca Property</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl#getCapabilityScaPropertyValue <em>Capability Sca Property Value</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl#getCapabilitySCAReference <em>Capability SCA Reference</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl#getCapabilityScaService <em>Capability Sca Service</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl#getUnitGenericscaImplementationUnit <em>Unit Genericsca Implementation Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl#getUnitSCABindingUnit <em>Unit SCA Binding Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl#getUnitScaComponentUnit <em>Unit Sca Component Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl#getUnitSCAImplementationBPELUnit <em>Unit SCA Implementation BPEL Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl#getUnitSCAImplementationCompositeUnit <em>Unit SCA Implementation Composite Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl#getUnitSCAImplementationCplusplusUnit <em>Unit SCA Implementation Cplusplus Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl#getUnitSCAImplementationJavaUnit <em>Unit SCA Implementation Java Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl#getUnitSCAInterfaceUnit <em>Unit SCA Interface Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl#getUnitSCAOperationUnit <em>Unit SCA Operation Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl#getUnitSCAPolicyIntentUnit <em>Unit SCA Policy Intent Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl#getUnitSCAPolicySetUnit <em>Unit SCA Policy Set Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl#getUnitScaPropertyUnit <em>Unit Sca Property Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl#getUnitScaPropertyValueUnit <em>Unit Sca Property Value Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl#getUnitSCAReferenceUnit <em>Unit SCA Reference Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.SCARootImpl#getUnitScaServiceUnit <em>Unit Sca Service Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SCARootImpl extends EObjectImpl implements SCARoot {
	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXMLNSPrefixMap()
	 * @generated
	 * @ordered
	 */
	protected EMap xMLNSPrefixMap;

	/**
	 * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXSISchemaLocation()
	 * @generated
	 * @ordered
	 */
	protected EMap xSISchemaLocation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SCARootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ScaPackage.Literals.SCA_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, ScaPackage.SCA_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, ScaPackage.SCA_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, ScaPackage.SCA_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericSCAImplementation getCapabilityGenericSCAImplementation() {
		return (GenericSCAImplementation)getMixed().get(ScaPackage.Literals.SCA_ROOT__CAPABILITY_GENERIC_SCA_IMPLEMENTATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityGenericSCAImplementation(GenericSCAImplementation newCapabilityGenericSCAImplementation, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ScaPackage.Literals.SCA_ROOT__CAPABILITY_GENERIC_SCA_IMPLEMENTATION, newCapabilityGenericSCAImplementation, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityGenericSCAImplementation(GenericSCAImplementation newCapabilityGenericSCAImplementation) {
		((FeatureMap.Internal)getMixed()).set(ScaPackage.Literals.SCA_ROOT__CAPABILITY_GENERIC_SCA_IMPLEMENTATION, newCapabilityGenericSCAImplementation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCABinding getCapabilitySCABinding() {
		return (SCABinding)getMixed().get(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_BINDING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilitySCABinding(SCABinding newCapabilitySCABinding, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_BINDING, newCapabilitySCABinding, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilitySCABinding(SCABinding newCapabilitySCABinding) {
		((FeatureMap.Internal)getMixed()).set(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_BINDING, newCapabilitySCABinding);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAComponent getCapabilityScaComponent() {
		return (SCAComponent)getMixed().get(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_COMPONENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityScaComponent(SCAComponent newCapabilityScaComponent, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_COMPONENT, newCapabilityScaComponent, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityScaComponent(SCAComponent newCapabilityScaComponent) {
		((FeatureMap.Internal)getMixed()).set(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_COMPONENT, newCapabilityScaComponent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAImplementationBPEL getCapabilitySCAImplementationBPEL() {
		return (SCAImplementationBPEL)getMixed().get(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_BPEL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilitySCAImplementationBPEL(SCAImplementationBPEL newCapabilitySCAImplementationBPEL, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_BPEL, newCapabilitySCAImplementationBPEL, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilitySCAImplementationBPEL(SCAImplementationBPEL newCapabilitySCAImplementationBPEL) {
		((FeatureMap.Internal)getMixed()).set(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_BPEL, newCapabilitySCAImplementationBPEL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAImplementationComposite getCapabilitySCAImplementationComposite() {
		return (SCAImplementationComposite)getMixed().get(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_COMPOSITE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilitySCAImplementationComposite(SCAImplementationComposite newCapabilitySCAImplementationComposite, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_COMPOSITE, newCapabilitySCAImplementationComposite, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilitySCAImplementationComposite(SCAImplementationComposite newCapabilitySCAImplementationComposite) {
		((FeatureMap.Internal)getMixed()).set(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_COMPOSITE, newCapabilitySCAImplementationComposite);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAImplementationCplusplus getCapabilitySCAImplementationCplusplus() {
		return (SCAImplementationCplusplus)getMixed().get(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_CPLUSPLUS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilitySCAImplementationCplusplus(SCAImplementationCplusplus newCapabilitySCAImplementationCplusplus, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_CPLUSPLUS, newCapabilitySCAImplementationCplusplus, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilitySCAImplementationCplusplus(SCAImplementationCplusplus newCapabilitySCAImplementationCplusplus) {
		((FeatureMap.Internal)getMixed()).set(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_CPLUSPLUS, newCapabilitySCAImplementationCplusplus);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAImplementationJava getCapabilitySCAImplementationJava() {
		return (SCAImplementationJava)getMixed().get(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_JAVA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilitySCAImplementationJava(SCAImplementationJava newCapabilitySCAImplementationJava, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_JAVA, newCapabilitySCAImplementationJava, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilitySCAImplementationJava(SCAImplementationJava newCapabilitySCAImplementationJava) {
		((FeatureMap.Internal)getMixed()).set(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_JAVA, newCapabilitySCAImplementationJava);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAInterface getCapabilitySCAInterface() {
		return (SCAInterface)getMixed().get(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_INTERFACE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilitySCAInterface(SCAInterface newCapabilitySCAInterface, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_INTERFACE, newCapabilitySCAInterface, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilitySCAInterface(SCAInterface newCapabilitySCAInterface) {
		((FeatureMap.Internal)getMixed()).set(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_INTERFACE, newCapabilitySCAInterface);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAOperation getCapabilitySCAOperation() {
		return (SCAOperation)getMixed().get(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_OPERATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilitySCAOperation(SCAOperation newCapabilitySCAOperation, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_OPERATION, newCapabilitySCAOperation, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilitySCAOperation(SCAOperation newCapabilitySCAOperation) {
		((FeatureMap.Internal)getMixed()).set(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_OPERATION, newCapabilitySCAOperation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAPolicyIntent getCapabilitySCAPolicyIntent() {
		return (SCAPolicyIntent)getMixed().get(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_POLICY_INTENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilitySCAPolicyIntent(SCAPolicyIntent newCapabilitySCAPolicyIntent, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_POLICY_INTENT, newCapabilitySCAPolicyIntent, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilitySCAPolicyIntent(SCAPolicyIntent newCapabilitySCAPolicyIntent) {
		((FeatureMap.Internal)getMixed()).set(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_POLICY_INTENT, newCapabilitySCAPolicyIntent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAPolicySet getCapabilitySCAPolicySet() {
		return (SCAPolicySet)getMixed().get(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_POLICY_SET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilitySCAPolicySet(SCAPolicySet newCapabilitySCAPolicySet, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_POLICY_SET, newCapabilitySCAPolicySet, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilitySCAPolicySet(SCAPolicySet newCapabilitySCAPolicySet) {
		((FeatureMap.Internal)getMixed()).set(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_POLICY_SET, newCapabilitySCAPolicySet);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAProperty getCapabilityScaProperty() {
		return (SCAProperty)getMixed().get(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_PROPERTY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityScaProperty(SCAProperty newCapabilityScaProperty, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_PROPERTY, newCapabilityScaProperty, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityScaProperty(SCAProperty newCapabilityScaProperty) {
		((FeatureMap.Internal)getMixed()).set(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_PROPERTY, newCapabilityScaProperty);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScaPropertyValue getCapabilityScaPropertyValue() {
		return (ScaPropertyValue)getMixed().get(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_PROPERTY_VALUE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityScaPropertyValue(ScaPropertyValue newCapabilityScaPropertyValue, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_PROPERTY_VALUE, newCapabilityScaPropertyValue, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityScaPropertyValue(ScaPropertyValue newCapabilityScaPropertyValue) {
		((FeatureMap.Internal)getMixed()).set(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_PROPERTY_VALUE, newCapabilityScaPropertyValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAReference getCapabilitySCAReference() {
		return (SCAReference)getMixed().get(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_REFERENCE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilitySCAReference(SCAReference newCapabilitySCAReference, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_REFERENCE, newCapabilitySCAReference, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilitySCAReference(SCAReference newCapabilitySCAReference) {
		((FeatureMap.Internal)getMixed()).set(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_REFERENCE, newCapabilitySCAReference);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAService getCapabilityScaService() {
		return (SCAService)getMixed().get(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_SERVICE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityScaService(SCAService newCapabilityScaService, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_SERVICE, newCapabilityScaService, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityScaService(SCAService newCapabilityScaService) {
		((FeatureMap.Internal)getMixed()).set(ScaPackage.Literals.SCA_ROOT__CAPABILITY_SCA_SERVICE, newCapabilityScaService);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenericSCAImplementationUnit getUnitGenericscaImplementationUnit() {
		return (GenericSCAImplementationUnit)getMixed().get(ScaPackage.Literals.SCA_ROOT__UNIT_GENERICSCA_IMPLEMENTATION_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitGenericscaImplementationUnit(GenericSCAImplementationUnit newUnitGenericscaImplementationUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ScaPackage.Literals.SCA_ROOT__UNIT_GENERICSCA_IMPLEMENTATION_UNIT, newUnitGenericscaImplementationUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitGenericscaImplementationUnit(GenericSCAImplementationUnit newUnitGenericscaImplementationUnit) {
		((FeatureMap.Internal)getMixed()).set(ScaPackage.Literals.SCA_ROOT__UNIT_GENERICSCA_IMPLEMENTATION_UNIT, newUnitGenericscaImplementationUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCABindingUnit getUnitSCABindingUnit() {
		return (SCABindingUnit)getMixed().get(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_BINDING_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitSCABindingUnit(SCABindingUnit newUnitSCABindingUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_BINDING_UNIT, newUnitSCABindingUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitSCABindingUnit(SCABindingUnit newUnitSCABindingUnit) {
		((FeatureMap.Internal)getMixed()).set(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_BINDING_UNIT, newUnitSCABindingUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAComponentUnit getUnitScaComponentUnit() {
		return (SCAComponentUnit)getMixed().get(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_COMPONENT_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitScaComponentUnit(SCAComponentUnit newUnitScaComponentUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_COMPONENT_UNIT, newUnitScaComponentUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitScaComponentUnit(SCAComponentUnit newUnitScaComponentUnit) {
		((FeatureMap.Internal)getMixed()).set(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_COMPONENT_UNIT, newUnitScaComponentUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAImplementationBPELUnit getUnitSCAImplementationBPELUnit() {
		return (SCAImplementationBPELUnit)getMixed().get(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_BPEL_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitSCAImplementationBPELUnit(SCAImplementationBPELUnit newUnitSCAImplementationBPELUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_BPEL_UNIT, newUnitSCAImplementationBPELUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitSCAImplementationBPELUnit(SCAImplementationBPELUnit newUnitSCAImplementationBPELUnit) {
		((FeatureMap.Internal)getMixed()).set(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_BPEL_UNIT, newUnitSCAImplementationBPELUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAImplementationCompositeUnit getUnitSCAImplementationCompositeUnit() {
		return (SCAImplementationCompositeUnit)getMixed().get(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_COMPOSITE_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitSCAImplementationCompositeUnit(SCAImplementationCompositeUnit newUnitSCAImplementationCompositeUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_COMPOSITE_UNIT, newUnitSCAImplementationCompositeUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitSCAImplementationCompositeUnit(SCAImplementationCompositeUnit newUnitSCAImplementationCompositeUnit) {
		((FeatureMap.Internal)getMixed()).set(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_COMPOSITE_UNIT, newUnitSCAImplementationCompositeUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAImplementationCplusplusUnit getUnitSCAImplementationCplusplusUnit() {
		return (SCAImplementationCplusplusUnit)getMixed().get(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_CPLUSPLUS_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitSCAImplementationCplusplusUnit(SCAImplementationCplusplusUnit newUnitSCAImplementationCplusplusUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_CPLUSPLUS_UNIT, newUnitSCAImplementationCplusplusUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitSCAImplementationCplusplusUnit(SCAImplementationCplusplusUnit newUnitSCAImplementationCplusplusUnit) {
		((FeatureMap.Internal)getMixed()).set(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_CPLUSPLUS_UNIT, newUnitSCAImplementationCplusplusUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAImplementationJavaUnit getUnitSCAImplementationJavaUnit() {
		return (SCAImplementationJavaUnit)getMixed().get(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_JAVA_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitSCAImplementationJavaUnit(SCAImplementationJavaUnit newUnitSCAImplementationJavaUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_JAVA_UNIT, newUnitSCAImplementationJavaUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitSCAImplementationJavaUnit(SCAImplementationJavaUnit newUnitSCAImplementationJavaUnit) {
		((FeatureMap.Internal)getMixed()).set(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_JAVA_UNIT, newUnitSCAImplementationJavaUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAInterfaceUnit getUnitSCAInterfaceUnit() {
		return (SCAInterfaceUnit)getMixed().get(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_INTERFACE_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitSCAInterfaceUnit(SCAInterfaceUnit newUnitSCAInterfaceUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_INTERFACE_UNIT, newUnitSCAInterfaceUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitSCAInterfaceUnit(SCAInterfaceUnit newUnitSCAInterfaceUnit) {
		((FeatureMap.Internal)getMixed()).set(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_INTERFACE_UNIT, newUnitSCAInterfaceUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAOperationUnit getUnitSCAOperationUnit() {
		return (SCAOperationUnit)getMixed().get(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_OPERATION_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitSCAOperationUnit(SCAOperationUnit newUnitSCAOperationUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_OPERATION_UNIT, newUnitSCAOperationUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitSCAOperationUnit(SCAOperationUnit newUnitSCAOperationUnit) {
		((FeatureMap.Internal)getMixed()).set(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_OPERATION_UNIT, newUnitSCAOperationUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAPolicyIntentUnit getUnitSCAPolicyIntentUnit() {
		return (SCAPolicyIntentUnit)getMixed().get(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_POLICY_INTENT_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitSCAPolicyIntentUnit(SCAPolicyIntentUnit newUnitSCAPolicyIntentUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_POLICY_INTENT_UNIT, newUnitSCAPolicyIntentUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitSCAPolicyIntentUnit(SCAPolicyIntentUnit newUnitSCAPolicyIntentUnit) {
		((FeatureMap.Internal)getMixed()).set(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_POLICY_INTENT_UNIT, newUnitSCAPolicyIntentUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAPolicySetUnit getUnitSCAPolicySetUnit() {
		return (SCAPolicySetUnit)getMixed().get(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_POLICY_SET_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitSCAPolicySetUnit(SCAPolicySetUnit newUnitSCAPolicySetUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_POLICY_SET_UNIT, newUnitSCAPolicySetUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitSCAPolicySetUnit(SCAPolicySetUnit newUnitSCAPolicySetUnit) {
		((FeatureMap.Internal)getMixed()).set(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_POLICY_SET_UNIT, newUnitSCAPolicySetUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAPropertyUnit getUnitScaPropertyUnit() {
		return (SCAPropertyUnit)getMixed().get(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_PROPERTY_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitScaPropertyUnit(SCAPropertyUnit newUnitScaPropertyUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_PROPERTY_UNIT, newUnitScaPropertyUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitScaPropertyUnit(SCAPropertyUnit newUnitScaPropertyUnit) {
		((FeatureMap.Internal)getMixed()).set(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_PROPERTY_UNIT, newUnitScaPropertyUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAPropertyValueUnit getUnitScaPropertyValueUnit() {
		return (SCAPropertyValueUnit)getMixed().get(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_PROPERTY_VALUE_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitScaPropertyValueUnit(SCAPropertyValueUnit newUnitScaPropertyValueUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_PROPERTY_VALUE_UNIT, newUnitScaPropertyValueUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitScaPropertyValueUnit(SCAPropertyValueUnit newUnitScaPropertyValueUnit) {
		((FeatureMap.Internal)getMixed()).set(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_PROPERTY_VALUE_UNIT, newUnitScaPropertyValueUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAReferenceUnit getUnitSCAReferenceUnit() {
		return (SCAReferenceUnit)getMixed().get(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_REFERENCE_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitSCAReferenceUnit(SCAReferenceUnit newUnitSCAReferenceUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_REFERENCE_UNIT, newUnitSCAReferenceUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitSCAReferenceUnit(SCAReferenceUnit newUnitSCAReferenceUnit) {
		((FeatureMap.Internal)getMixed()).set(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_REFERENCE_UNIT, newUnitSCAReferenceUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCAServiceUnit getUnitScaServiceUnit() {
		return (SCAServiceUnit)getMixed().get(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_SERVICE_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitScaServiceUnit(SCAServiceUnit newUnitScaServiceUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_SERVICE_UNIT, newUnitScaServiceUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitScaServiceUnit(SCAServiceUnit newUnitScaServiceUnit) {
		((FeatureMap.Internal)getMixed()).set(ScaPackage.Literals.SCA_ROOT__UNIT_SCA_SERVICE_UNIT, newUnitScaServiceUnit);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ScaPackage.SCA_ROOT__MIXED:
				return ((InternalEList)getMixed()).basicRemove(otherEnd, msgs);
			case ScaPackage.SCA_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList)getXMLNSPrefixMap()).basicRemove(otherEnd, msgs);
			case ScaPackage.SCA_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList)getXSISchemaLocation()).basicRemove(otherEnd, msgs);
			case ScaPackage.SCA_ROOT__CAPABILITY_GENERIC_SCA_IMPLEMENTATION:
				return basicSetCapabilityGenericSCAImplementation(null, msgs);
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_BINDING:
				return basicSetCapabilitySCABinding(null, msgs);
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_COMPONENT:
				return basicSetCapabilityScaComponent(null, msgs);
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_BPEL:
				return basicSetCapabilitySCAImplementationBPEL(null, msgs);
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_COMPOSITE:
				return basicSetCapabilitySCAImplementationComposite(null, msgs);
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_CPLUSPLUS:
				return basicSetCapabilitySCAImplementationCplusplus(null, msgs);
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_JAVA:
				return basicSetCapabilitySCAImplementationJava(null, msgs);
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_INTERFACE:
				return basicSetCapabilitySCAInterface(null, msgs);
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_OPERATION:
				return basicSetCapabilitySCAOperation(null, msgs);
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_POLICY_INTENT:
				return basicSetCapabilitySCAPolicyIntent(null, msgs);
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_POLICY_SET:
				return basicSetCapabilitySCAPolicySet(null, msgs);
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_PROPERTY:
				return basicSetCapabilityScaProperty(null, msgs);
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_PROPERTY_VALUE:
				return basicSetCapabilityScaPropertyValue(null, msgs);
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_REFERENCE:
				return basicSetCapabilitySCAReference(null, msgs);
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_SERVICE:
				return basicSetCapabilityScaService(null, msgs);
			case ScaPackage.SCA_ROOT__UNIT_GENERICSCA_IMPLEMENTATION_UNIT:
				return basicSetUnitGenericscaImplementationUnit(null, msgs);
			case ScaPackage.SCA_ROOT__UNIT_SCA_BINDING_UNIT:
				return basicSetUnitSCABindingUnit(null, msgs);
			case ScaPackage.SCA_ROOT__UNIT_SCA_COMPONENT_UNIT:
				return basicSetUnitScaComponentUnit(null, msgs);
			case ScaPackage.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_BPEL_UNIT:
				return basicSetUnitSCAImplementationBPELUnit(null, msgs);
			case ScaPackage.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_COMPOSITE_UNIT:
				return basicSetUnitSCAImplementationCompositeUnit(null, msgs);
			case ScaPackage.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_CPLUSPLUS_UNIT:
				return basicSetUnitSCAImplementationCplusplusUnit(null, msgs);
			case ScaPackage.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_JAVA_UNIT:
				return basicSetUnitSCAImplementationJavaUnit(null, msgs);
			case ScaPackage.SCA_ROOT__UNIT_SCA_INTERFACE_UNIT:
				return basicSetUnitSCAInterfaceUnit(null, msgs);
			case ScaPackage.SCA_ROOT__UNIT_SCA_OPERATION_UNIT:
				return basicSetUnitSCAOperationUnit(null, msgs);
			case ScaPackage.SCA_ROOT__UNIT_SCA_POLICY_INTENT_UNIT:
				return basicSetUnitSCAPolicyIntentUnit(null, msgs);
			case ScaPackage.SCA_ROOT__UNIT_SCA_POLICY_SET_UNIT:
				return basicSetUnitSCAPolicySetUnit(null, msgs);
			case ScaPackage.SCA_ROOT__UNIT_SCA_PROPERTY_UNIT:
				return basicSetUnitScaPropertyUnit(null, msgs);
			case ScaPackage.SCA_ROOT__UNIT_SCA_PROPERTY_VALUE_UNIT:
				return basicSetUnitScaPropertyValueUnit(null, msgs);
			case ScaPackage.SCA_ROOT__UNIT_SCA_REFERENCE_UNIT:
				return basicSetUnitSCAReferenceUnit(null, msgs);
			case ScaPackage.SCA_ROOT__UNIT_SCA_SERVICE_UNIT:
				return basicSetUnitScaServiceUnit(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ScaPackage.SCA_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case ScaPackage.SCA_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return getXMLNSPrefixMap();
				else return getXMLNSPrefixMap().map();
			case ScaPackage.SCA_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return getXSISchemaLocation();
				else return getXSISchemaLocation().map();
			case ScaPackage.SCA_ROOT__CAPABILITY_GENERIC_SCA_IMPLEMENTATION:
				return getCapabilityGenericSCAImplementation();
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_BINDING:
				return getCapabilitySCABinding();
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_COMPONENT:
				return getCapabilityScaComponent();
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_BPEL:
				return getCapabilitySCAImplementationBPEL();
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_COMPOSITE:
				return getCapabilitySCAImplementationComposite();
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_CPLUSPLUS:
				return getCapabilitySCAImplementationCplusplus();
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_JAVA:
				return getCapabilitySCAImplementationJava();
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_INTERFACE:
				return getCapabilitySCAInterface();
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_OPERATION:
				return getCapabilitySCAOperation();
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_POLICY_INTENT:
				return getCapabilitySCAPolicyIntent();
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_POLICY_SET:
				return getCapabilitySCAPolicySet();
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_PROPERTY:
				return getCapabilityScaProperty();
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_PROPERTY_VALUE:
				return getCapabilityScaPropertyValue();
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_REFERENCE:
				return getCapabilitySCAReference();
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_SERVICE:
				return getCapabilityScaService();
			case ScaPackage.SCA_ROOT__UNIT_GENERICSCA_IMPLEMENTATION_UNIT:
				return getUnitGenericscaImplementationUnit();
			case ScaPackage.SCA_ROOT__UNIT_SCA_BINDING_UNIT:
				return getUnitSCABindingUnit();
			case ScaPackage.SCA_ROOT__UNIT_SCA_COMPONENT_UNIT:
				return getUnitScaComponentUnit();
			case ScaPackage.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_BPEL_UNIT:
				return getUnitSCAImplementationBPELUnit();
			case ScaPackage.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_COMPOSITE_UNIT:
				return getUnitSCAImplementationCompositeUnit();
			case ScaPackage.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_CPLUSPLUS_UNIT:
				return getUnitSCAImplementationCplusplusUnit();
			case ScaPackage.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_JAVA_UNIT:
				return getUnitSCAImplementationJavaUnit();
			case ScaPackage.SCA_ROOT__UNIT_SCA_INTERFACE_UNIT:
				return getUnitSCAInterfaceUnit();
			case ScaPackage.SCA_ROOT__UNIT_SCA_OPERATION_UNIT:
				return getUnitSCAOperationUnit();
			case ScaPackage.SCA_ROOT__UNIT_SCA_POLICY_INTENT_UNIT:
				return getUnitSCAPolicyIntentUnit();
			case ScaPackage.SCA_ROOT__UNIT_SCA_POLICY_SET_UNIT:
				return getUnitSCAPolicySetUnit();
			case ScaPackage.SCA_ROOT__UNIT_SCA_PROPERTY_UNIT:
				return getUnitScaPropertyUnit();
			case ScaPackage.SCA_ROOT__UNIT_SCA_PROPERTY_VALUE_UNIT:
				return getUnitScaPropertyValueUnit();
			case ScaPackage.SCA_ROOT__UNIT_SCA_REFERENCE_UNIT:
				return getUnitSCAReferenceUnit();
			case ScaPackage.SCA_ROOT__UNIT_SCA_SERVICE_UNIT:
				return getUnitScaServiceUnit();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ScaPackage.SCA_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case ScaPackage.SCA_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)getXMLNSPrefixMap()).set(newValue);
				return;
			case ScaPackage.SCA_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)getXSISchemaLocation()).set(newValue);
				return;
			case ScaPackage.SCA_ROOT__CAPABILITY_GENERIC_SCA_IMPLEMENTATION:
				setCapabilityGenericSCAImplementation((GenericSCAImplementation)newValue);
				return;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_BINDING:
				setCapabilitySCABinding((SCABinding)newValue);
				return;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_COMPONENT:
				setCapabilityScaComponent((SCAComponent)newValue);
				return;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_BPEL:
				setCapabilitySCAImplementationBPEL((SCAImplementationBPEL)newValue);
				return;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_COMPOSITE:
				setCapabilitySCAImplementationComposite((SCAImplementationComposite)newValue);
				return;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_CPLUSPLUS:
				setCapabilitySCAImplementationCplusplus((SCAImplementationCplusplus)newValue);
				return;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_JAVA:
				setCapabilitySCAImplementationJava((SCAImplementationJava)newValue);
				return;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_INTERFACE:
				setCapabilitySCAInterface((SCAInterface)newValue);
				return;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_OPERATION:
				setCapabilitySCAOperation((SCAOperation)newValue);
				return;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_POLICY_INTENT:
				setCapabilitySCAPolicyIntent((SCAPolicyIntent)newValue);
				return;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_POLICY_SET:
				setCapabilitySCAPolicySet((SCAPolicySet)newValue);
				return;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_PROPERTY:
				setCapabilityScaProperty((SCAProperty)newValue);
				return;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_PROPERTY_VALUE:
				setCapabilityScaPropertyValue((ScaPropertyValue)newValue);
				return;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_REFERENCE:
				setCapabilitySCAReference((SCAReference)newValue);
				return;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_SERVICE:
				setCapabilityScaService((SCAService)newValue);
				return;
			case ScaPackage.SCA_ROOT__UNIT_GENERICSCA_IMPLEMENTATION_UNIT:
				setUnitGenericscaImplementationUnit((GenericSCAImplementationUnit)newValue);
				return;
			case ScaPackage.SCA_ROOT__UNIT_SCA_BINDING_UNIT:
				setUnitSCABindingUnit((SCABindingUnit)newValue);
				return;
			case ScaPackage.SCA_ROOT__UNIT_SCA_COMPONENT_UNIT:
				setUnitScaComponentUnit((SCAComponentUnit)newValue);
				return;
			case ScaPackage.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_BPEL_UNIT:
				setUnitSCAImplementationBPELUnit((SCAImplementationBPELUnit)newValue);
				return;
			case ScaPackage.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_COMPOSITE_UNIT:
				setUnitSCAImplementationCompositeUnit((SCAImplementationCompositeUnit)newValue);
				return;
			case ScaPackage.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_CPLUSPLUS_UNIT:
				setUnitSCAImplementationCplusplusUnit((SCAImplementationCplusplusUnit)newValue);
				return;
			case ScaPackage.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_JAVA_UNIT:
				setUnitSCAImplementationJavaUnit((SCAImplementationJavaUnit)newValue);
				return;
			case ScaPackage.SCA_ROOT__UNIT_SCA_INTERFACE_UNIT:
				setUnitSCAInterfaceUnit((SCAInterfaceUnit)newValue);
				return;
			case ScaPackage.SCA_ROOT__UNIT_SCA_OPERATION_UNIT:
				setUnitSCAOperationUnit((SCAOperationUnit)newValue);
				return;
			case ScaPackage.SCA_ROOT__UNIT_SCA_POLICY_INTENT_UNIT:
				setUnitSCAPolicyIntentUnit((SCAPolicyIntentUnit)newValue);
				return;
			case ScaPackage.SCA_ROOT__UNIT_SCA_POLICY_SET_UNIT:
				setUnitSCAPolicySetUnit((SCAPolicySetUnit)newValue);
				return;
			case ScaPackage.SCA_ROOT__UNIT_SCA_PROPERTY_UNIT:
				setUnitScaPropertyUnit((SCAPropertyUnit)newValue);
				return;
			case ScaPackage.SCA_ROOT__UNIT_SCA_PROPERTY_VALUE_UNIT:
				setUnitScaPropertyValueUnit((SCAPropertyValueUnit)newValue);
				return;
			case ScaPackage.SCA_ROOT__UNIT_SCA_REFERENCE_UNIT:
				setUnitSCAReferenceUnit((SCAReferenceUnit)newValue);
				return;
			case ScaPackage.SCA_ROOT__UNIT_SCA_SERVICE_UNIT:
				setUnitScaServiceUnit((SCAServiceUnit)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case ScaPackage.SCA_ROOT__MIXED:
				getMixed().clear();
				return;
			case ScaPackage.SCA_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case ScaPackage.SCA_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case ScaPackage.SCA_ROOT__CAPABILITY_GENERIC_SCA_IMPLEMENTATION:
				setCapabilityGenericSCAImplementation((GenericSCAImplementation)null);
				return;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_BINDING:
				setCapabilitySCABinding((SCABinding)null);
				return;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_COMPONENT:
				setCapabilityScaComponent((SCAComponent)null);
				return;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_BPEL:
				setCapabilitySCAImplementationBPEL((SCAImplementationBPEL)null);
				return;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_COMPOSITE:
				setCapabilitySCAImplementationComposite((SCAImplementationComposite)null);
				return;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_CPLUSPLUS:
				setCapabilitySCAImplementationCplusplus((SCAImplementationCplusplus)null);
				return;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_JAVA:
				setCapabilitySCAImplementationJava((SCAImplementationJava)null);
				return;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_INTERFACE:
				setCapabilitySCAInterface((SCAInterface)null);
				return;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_OPERATION:
				setCapabilitySCAOperation((SCAOperation)null);
				return;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_POLICY_INTENT:
				setCapabilitySCAPolicyIntent((SCAPolicyIntent)null);
				return;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_POLICY_SET:
				setCapabilitySCAPolicySet((SCAPolicySet)null);
				return;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_PROPERTY:
				setCapabilityScaProperty((SCAProperty)null);
				return;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_PROPERTY_VALUE:
				setCapabilityScaPropertyValue((ScaPropertyValue)null);
				return;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_REFERENCE:
				setCapabilitySCAReference((SCAReference)null);
				return;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_SERVICE:
				setCapabilityScaService((SCAService)null);
				return;
			case ScaPackage.SCA_ROOT__UNIT_GENERICSCA_IMPLEMENTATION_UNIT:
				setUnitGenericscaImplementationUnit((GenericSCAImplementationUnit)null);
				return;
			case ScaPackage.SCA_ROOT__UNIT_SCA_BINDING_UNIT:
				setUnitSCABindingUnit((SCABindingUnit)null);
				return;
			case ScaPackage.SCA_ROOT__UNIT_SCA_COMPONENT_UNIT:
				setUnitScaComponentUnit((SCAComponentUnit)null);
				return;
			case ScaPackage.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_BPEL_UNIT:
				setUnitSCAImplementationBPELUnit((SCAImplementationBPELUnit)null);
				return;
			case ScaPackage.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_COMPOSITE_UNIT:
				setUnitSCAImplementationCompositeUnit((SCAImplementationCompositeUnit)null);
				return;
			case ScaPackage.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_CPLUSPLUS_UNIT:
				setUnitSCAImplementationCplusplusUnit((SCAImplementationCplusplusUnit)null);
				return;
			case ScaPackage.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_JAVA_UNIT:
				setUnitSCAImplementationJavaUnit((SCAImplementationJavaUnit)null);
				return;
			case ScaPackage.SCA_ROOT__UNIT_SCA_INTERFACE_UNIT:
				setUnitSCAInterfaceUnit((SCAInterfaceUnit)null);
				return;
			case ScaPackage.SCA_ROOT__UNIT_SCA_OPERATION_UNIT:
				setUnitSCAOperationUnit((SCAOperationUnit)null);
				return;
			case ScaPackage.SCA_ROOT__UNIT_SCA_POLICY_INTENT_UNIT:
				setUnitSCAPolicyIntentUnit((SCAPolicyIntentUnit)null);
				return;
			case ScaPackage.SCA_ROOT__UNIT_SCA_POLICY_SET_UNIT:
				setUnitSCAPolicySetUnit((SCAPolicySetUnit)null);
				return;
			case ScaPackage.SCA_ROOT__UNIT_SCA_PROPERTY_UNIT:
				setUnitScaPropertyUnit((SCAPropertyUnit)null);
				return;
			case ScaPackage.SCA_ROOT__UNIT_SCA_PROPERTY_VALUE_UNIT:
				setUnitScaPropertyValueUnit((SCAPropertyValueUnit)null);
				return;
			case ScaPackage.SCA_ROOT__UNIT_SCA_REFERENCE_UNIT:
				setUnitSCAReferenceUnit((SCAReferenceUnit)null);
				return;
			case ScaPackage.SCA_ROOT__UNIT_SCA_SERVICE_UNIT:
				setUnitScaServiceUnit((SCAServiceUnit)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ScaPackage.SCA_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case ScaPackage.SCA_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case ScaPackage.SCA_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case ScaPackage.SCA_ROOT__CAPABILITY_GENERIC_SCA_IMPLEMENTATION:
				return getCapabilityGenericSCAImplementation() != null;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_BINDING:
				return getCapabilitySCABinding() != null;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_COMPONENT:
				return getCapabilityScaComponent() != null;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_BPEL:
				return getCapabilitySCAImplementationBPEL() != null;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_COMPOSITE:
				return getCapabilitySCAImplementationComposite() != null;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_CPLUSPLUS:
				return getCapabilitySCAImplementationCplusplus() != null;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_IMPLEMENTATION_JAVA:
				return getCapabilitySCAImplementationJava() != null;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_INTERFACE:
				return getCapabilitySCAInterface() != null;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_OPERATION:
				return getCapabilitySCAOperation() != null;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_POLICY_INTENT:
				return getCapabilitySCAPolicyIntent() != null;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_POLICY_SET:
				return getCapabilitySCAPolicySet() != null;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_PROPERTY:
				return getCapabilityScaProperty() != null;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_PROPERTY_VALUE:
				return getCapabilityScaPropertyValue() != null;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_REFERENCE:
				return getCapabilitySCAReference() != null;
			case ScaPackage.SCA_ROOT__CAPABILITY_SCA_SERVICE:
				return getCapabilityScaService() != null;
			case ScaPackage.SCA_ROOT__UNIT_GENERICSCA_IMPLEMENTATION_UNIT:
				return getUnitGenericscaImplementationUnit() != null;
			case ScaPackage.SCA_ROOT__UNIT_SCA_BINDING_UNIT:
				return getUnitSCABindingUnit() != null;
			case ScaPackage.SCA_ROOT__UNIT_SCA_COMPONENT_UNIT:
				return getUnitScaComponentUnit() != null;
			case ScaPackage.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_BPEL_UNIT:
				return getUnitSCAImplementationBPELUnit() != null;
			case ScaPackage.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_COMPOSITE_UNIT:
				return getUnitSCAImplementationCompositeUnit() != null;
			case ScaPackage.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_CPLUSPLUS_UNIT:
				return getUnitSCAImplementationCplusplusUnit() != null;
			case ScaPackage.SCA_ROOT__UNIT_SCA_IMPLEMENTATION_JAVA_UNIT:
				return getUnitSCAImplementationJavaUnit() != null;
			case ScaPackage.SCA_ROOT__UNIT_SCA_INTERFACE_UNIT:
				return getUnitSCAInterfaceUnit() != null;
			case ScaPackage.SCA_ROOT__UNIT_SCA_OPERATION_UNIT:
				return getUnitSCAOperationUnit() != null;
			case ScaPackage.SCA_ROOT__UNIT_SCA_POLICY_INTENT_UNIT:
				return getUnitSCAPolicyIntentUnit() != null;
			case ScaPackage.SCA_ROOT__UNIT_SCA_POLICY_SET_UNIT:
				return getUnitSCAPolicySetUnit() != null;
			case ScaPackage.SCA_ROOT__UNIT_SCA_PROPERTY_UNIT:
				return getUnitScaPropertyUnit() != null;
			case ScaPackage.SCA_ROOT__UNIT_SCA_PROPERTY_VALUE_UNIT:
				return getUnitScaPropertyValueUnit() != null;
			case ScaPackage.SCA_ROOT__UNIT_SCA_REFERENCE_UNIT:
				return getUnitSCAReferenceUnit() != null;
			case ScaPackage.SCA_ROOT__UNIT_SCA_SERVICE_UNIT:
				return getUnitScaServiceUnit() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (mixed: "); //$NON-NLS-1$
		result.append(mixed);
		result.append(')');
		return result.toString();
	}

} //SCARootImpl
