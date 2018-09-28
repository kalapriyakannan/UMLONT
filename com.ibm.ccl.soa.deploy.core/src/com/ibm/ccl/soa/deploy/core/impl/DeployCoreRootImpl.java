/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.impl;

import java.util.Map;

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

import com.ibm.ccl.soa.deploy.core.Annotation;
import com.ibm.ccl.soa.deploy.core.Artifact;
import com.ibm.ccl.soa.deploy.core.BaseComponentUnit;
import com.ibm.ccl.soa.deploy.core.BundleCapability;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.CommunicationCapability;
import com.ibm.ccl.soa.deploy.core.ConceptualNode;
import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.Constraint;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.DeployCoreRoot;
import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExplicitContract;
import com.ibm.ccl.soa.deploy.core.FileArtifact;
import com.ibm.ccl.soa.deploy.core.HostingLink;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.Instantiation;
import com.ibm.ccl.soa.deploy.core.Interface;
import com.ibm.ccl.soa.deploy.core.MemberLink;
import com.ibm.ccl.soa.deploy.core.Property;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Reference;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.RequirementExpression;
import com.ibm.ccl.soa.deploy.core.Service;
import com.ibm.ccl.soa.deploy.core.SoftwareComponent;
import com.ibm.ccl.soa.deploy.core.Stereotype;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.UnitLink;
import com.ibm.ccl.soa.deploy.core.Visibility;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Deploy Core Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl#getMixed <em>Mixed</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl#getAnnotation <em>Annotation</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl#getArtifact <em>Artifact</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl#getArtifactFile <em>Artifact File</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl#getBaseComponent <em>Base Component</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl#getUnit <em>Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl#getCapability <em>Capability</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl#getCapabilityBundle <em>Capability Bundle</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl#getCapabilityCommunication <em>Capability Communication</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl#getConfigTopology <em>Config Topology</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl#getContractExplicit <em>Contract Explicit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl#getContractTopology <em>Contract Topology</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl#getDeployModelObject <em>Deploy Model Object</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl#getImport <em>Import</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl#getInstantiation <em>Instantiation</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl#getInterface <em>Interface</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl#getLinkConstraint <em>Link Constraint</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl#getLinkDependency <em>Link Dependency</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl#getLinkDeploy <em>Link Deploy</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl#getLinkHosting <em>Link Hosting</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl#getLinkUnit <em>Link Unit</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl#getLinkMember <em>Link Member</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl#getLinkRealization <em>Link Realization</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl#getRequirement <em>Requirement</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl#getReqExpr <em>Req Expr</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl#getService <em>Service</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl#getSoftwareComponent <em>Software Component</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl#getTopology <em>Topology</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl#getUnitConceptualNode <em>Unit Conceptual Node</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.DeployCoreRootImpl#getVisibility <em>Visibility</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeployCoreRootImpl extends EObjectImpl implements DeployCoreRoot {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getMixed() <em>Mixed</em>}' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMixed()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap mixed;

	/**
	 * The cached value of the '{@link #getXMLNSPrefixMap() <em>XMLNS Prefix Map</em>}' map. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getXMLNSPrefixMap()
	 * @generated
	 * @ordered
	 */
	protected EMap xMLNSPrefixMap;

	/**
	 * The cached value of the '{@link #getXSISchemaLocation() <em>XSI Schema Location</em>}' map.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getXSISchemaLocation()
	 * @generated
	 * @ordered
	 */
	protected EMap xSISchemaLocation;

	/**
	 * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected static final Visibility VISIBILITY_EDEFAULT = Visibility.PRIVATE_LITERAL;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DeployCoreRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.DEPLOY_CORE_ROOT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getMixed() {
		if (mixed == null) {
			mixed = new BasicFeatureMap(this, CorePackage.DEPLOY_CORE_ROOT__MIXED);
		}
		return mixed;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map getXMLNSPrefixMap() {
		if (xMLNSPrefixMap == null) {
			xMLNSPrefixMap = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, CorePackage.DEPLOY_CORE_ROOT__XMLNS_PREFIX_MAP);
		}
		return xMLNSPrefixMap.map();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Map getXSISchemaLocation() {
		if (xSISchemaLocation == null) {
			xSISchemaLocation = new EcoreEMap(EcorePackage.Literals.ESTRING_TO_STRING_MAP_ENTRY, EStringToStringMapEntryImpl.class, this, CorePackage.DEPLOY_CORE_ROOT__XSI_SCHEMA_LOCATION);
		}
		return xSISchemaLocation.map();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Annotation getAnnotation() {
		return (Annotation)getMixed().get(CorePackage.Literals.DEPLOY_CORE_ROOT__ANNOTATION, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAnnotation(Annotation newAnnotation, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(CorePackage.Literals.DEPLOY_CORE_ROOT__ANNOTATION, newAnnotation, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnnotation(Annotation newAnnotation) {
		((FeatureMap.Internal)getMixed()).set(CorePackage.Literals.DEPLOY_CORE_ROOT__ANNOTATION, newAnnotation);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Artifact getArtifact() {
		return (Artifact)getMixed().get(CorePackage.Literals.DEPLOY_CORE_ROOT__ARTIFACT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetArtifact(Artifact newArtifact, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(CorePackage.Literals.DEPLOY_CORE_ROOT__ARTIFACT, newArtifact, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setArtifact(Artifact newArtifact) {
		((FeatureMap.Internal)getMixed()).set(CorePackage.Literals.DEPLOY_CORE_ROOT__ARTIFACT, newArtifact);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FileArtifact getArtifactFile() {
		return (FileArtifact)getMixed().get(CorePackage.Literals.DEPLOY_CORE_ROOT__ARTIFACT_FILE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetArtifactFile(FileArtifact newArtifactFile,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(CorePackage.Literals.DEPLOY_CORE_ROOT__ARTIFACT_FILE, newArtifactFile, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setArtifactFile(FileArtifact newArtifactFile) {
		((FeatureMap.Internal)getMixed()).set(CorePackage.Literals.DEPLOY_CORE_ROOT__ARTIFACT_FILE, newArtifactFile);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseComponentUnit getBaseComponent() {
		return (BaseComponentUnit)getMixed().get(CorePackage.Literals.DEPLOY_CORE_ROOT__BASE_COMPONENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBaseComponent(BaseComponentUnit newBaseComponent, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(CorePackage.Literals.DEPLOY_CORE_ROOT__BASE_COMPONENT, newBaseComponent, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseComponent(BaseComponentUnit newBaseComponent) {
		((FeatureMap.Internal)getMixed()).set(CorePackage.Literals.DEPLOY_CORE_ROOT__BASE_COMPONENT, newBaseComponent);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Capability getCapability() {
		return (Capability)getMixed().get(CorePackage.Literals.DEPLOY_CORE_ROOT__CAPABILITY, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapability(Capability newCapability, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(CorePackage.Literals.DEPLOY_CORE_ROOT__CAPABILITY, newCapability, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapability(Capability newCapability) {
		((FeatureMap.Internal)getMixed()).set(CorePackage.Literals.DEPLOY_CORE_ROOT__CAPABILITY, newCapability);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public BundleCapability getCapabilityBundle() {
		return (BundleCapability)getMixed().get(CorePackage.Literals.DEPLOY_CORE_ROOT__CAPABILITY_BUNDLE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityBundle(BundleCapability newCapabilityBundle,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(CorePackage.Literals.DEPLOY_CORE_ROOT__CAPABILITY_BUNDLE, newCapabilityBundle, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityBundle(BundleCapability newCapabilityBundle) {
		((FeatureMap.Internal)getMixed()).set(CorePackage.Literals.DEPLOY_CORE_ROOT__CAPABILITY_BUNDLE, newCapabilityBundle);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CommunicationCapability getCapabilityCommunication() {
		return (CommunicationCapability)getMixed().get(CorePackage.Literals.DEPLOY_CORE_ROOT__CAPABILITY_COMMUNICATION, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapabilityCommunication(
			CommunicationCapability newCapabilityCommunication, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(CorePackage.Literals.DEPLOY_CORE_ROOT__CAPABILITY_COMMUNICATION, newCapabilityCommunication, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCapabilityCommunication(CommunicationCapability newCapabilityCommunication) {
		((FeatureMap.Internal)getMixed()).set(CorePackage.Literals.DEPLOY_CORE_ROOT__CAPABILITY_COMMUNICATION, newCapabilityCommunication);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DeployModelObject getDeployModelObject() {
		return (DeployModelObject)getMixed().get(CorePackage.Literals.DEPLOY_CORE_ROOT__DEPLOY_MODEL_OBJECT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeployModelObject(DeployModelObject newDeployModelObject,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(CorePackage.Literals.DEPLOY_CORE_ROOT__DEPLOY_MODEL_OBJECT, newDeployModelObject, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Import getImport() {
		return (Import)getMixed().get(CorePackage.Literals.DEPLOY_CORE_ROOT__IMPORT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetImport(Import newImport, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(CorePackage.Literals.DEPLOY_CORE_ROOT__IMPORT, newImport, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setImport(Import newImport) {
		((FeatureMap.Internal)getMixed()).set(CorePackage.Literals.DEPLOY_CORE_ROOT__IMPORT, newImport);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Instantiation getInstantiation() {
		return (Instantiation)getMixed().get(CorePackage.Literals.DEPLOY_CORE_ROOT__INSTANTIATION, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInstantiation(Instantiation newInstantiation,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(CorePackage.Literals.DEPLOY_CORE_ROOT__INSTANTIATION, newInstantiation, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstantiation(Instantiation newInstantiation) {
		((FeatureMap.Internal)getMixed()).set(CorePackage.Literals.DEPLOY_CORE_ROOT__INSTANTIATION, newInstantiation);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Interface getInterface() {
		return (Interface)getMixed().get(CorePackage.Literals.DEPLOY_CORE_ROOT__INTERFACE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInterface(Interface newInterface, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(CorePackage.Literals.DEPLOY_CORE_ROOT__INTERFACE, newInterface, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterface(Interface newInterface) {
		((FeatureMap.Internal)getMixed()).set(CorePackage.Literals.DEPLOY_CORE_ROOT__INTERFACE, newInterface);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstraintLink getLinkConstraint() {
		return (ConstraintLink)getMixed().get(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_CONSTRAINT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLinkConstraint(ConstraintLink newLinkConstraint, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_CONSTRAINT, newLinkConstraint, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkConstraint(ConstraintLink newLinkConstraint) {
		((FeatureMap.Internal)getMixed()).set(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_CONSTRAINT, newLinkConstraint);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DependencyLink getLinkDependency() {
		return (DependencyLink)getMixed().get(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_DEPENDENCY, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLinkDependency(DependencyLink newLinkDependency,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_DEPENDENCY, newLinkDependency, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkDependency(DependencyLink newLinkDependency) {
		((FeatureMap.Internal)getMixed()).set(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_DEPENDENCY, newLinkDependency);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DeployLink getLinkDeploy() {
		return (DeployLink)getMixed().get(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_DEPLOY, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLinkDeploy(DeployLink newLinkDeploy, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_DEPLOY, newLinkDeploy, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkDeploy(DeployLink newLinkDeploy) {
		((FeatureMap.Internal)getMixed()).set(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_DEPLOY, newLinkDeploy);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public HostingLink getLinkHosting() {
		return (HostingLink)getMixed().get(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_HOSTING, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLinkHosting(HostingLink newLinkHosting, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_HOSTING, newLinkHosting, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkHosting(HostingLink newLinkHosting) {
		((FeatureMap.Internal)getMixed()).set(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_HOSTING, newLinkHosting);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UnitLink getLinkUnit() {
		return (UnitLink)getMixed().get(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLinkUnit(UnitLink newLinkUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_UNIT, newLinkUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkUnit(UnitLink newLinkUnit) {
		((FeatureMap.Internal)getMixed()).set(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_UNIT, newLinkUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MemberLink getLinkMember() {
		return (MemberLink)getMixed().get(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_MEMBER, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLinkMember(MemberLink newLinkMember, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_MEMBER, newLinkMember, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkMember(MemberLink newLinkMember) {
		((FeatureMap.Internal)getMixed()).set(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_MEMBER, newLinkMember);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RealizationLink getLinkRealization() {
		return (RealizationLink)getMixed().get(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_REALIZATION, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLinkRealization(RealizationLink newLinkRealization,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_REALIZATION, newLinkRealization, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkRealization(RealizationLink newLinkRealization) {
		((FeatureMap.Internal)getMixed()).set(CorePackage.Literals.DEPLOY_CORE_ROOT__LINK_REALIZATION, newLinkRealization);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Property getProperty() {
		return (Property)getMixed().get(CorePackage.Literals.DEPLOY_CORE_ROOT__PROPERTY, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProperty(Property newProperty, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(CorePackage.Literals.DEPLOY_CORE_ROOT__PROPERTY, newProperty, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setProperty(Property newProperty) {
		((FeatureMap.Internal)getMixed()).set(CorePackage.Literals.DEPLOY_CORE_ROOT__PROPERTY, newProperty);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Reference getReference() {
		return (Reference)getMixed().get(CorePackage.Literals.DEPLOY_CORE_ROOT__REFERENCE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReference(Reference newReference, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(CorePackage.Literals.DEPLOY_CORE_ROOT__REFERENCE, newReference, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setReference(Reference newReference) {
		((FeatureMap.Internal)getMixed()).set(CorePackage.Literals.DEPLOY_CORE_ROOT__REFERENCE, newReference);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementExpression getReqExpr() {
		return (RequirementExpression)getMixed().get(CorePackage.Literals.DEPLOY_CORE_ROOT__REQ_EXPR, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReqExpr(RequirementExpression newReqExpr, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(CorePackage.Literals.DEPLOY_CORE_ROOT__REQ_EXPR, newReqExpr, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setReqExpr(RequirementExpression newReqExpr) {
		((FeatureMap.Internal)getMixed()).set(CorePackage.Literals.DEPLOY_CORE_ROOT__REQ_EXPR, newReqExpr);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Service getService() {
		return (Service)getMixed().get(CorePackage.Literals.DEPLOY_CORE_ROOT__SERVICE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetService(Service newService, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(CorePackage.Literals.DEPLOY_CORE_ROOT__SERVICE, newService, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setService(Service newService) {
		((FeatureMap.Internal)getMixed()).set(CorePackage.Literals.DEPLOY_CORE_ROOT__SERVICE, newService);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SoftwareComponent getSoftwareComponent() {
		return (SoftwareComponent)getMixed().get(CorePackage.Literals.DEPLOY_CORE_ROOT__SOFTWARE_COMPONENT, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSoftwareComponent(SoftwareComponent newSoftwareComponent, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(CorePackage.Literals.DEPLOY_CORE_ROOT__SOFTWARE_COMPONENT, newSoftwareComponent, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSoftwareComponent(SoftwareComponent newSoftwareComponent) {
		((FeatureMap.Internal)getMixed()).set(CorePackage.Literals.DEPLOY_CORE_ROOT__SOFTWARE_COMPONENT, newSoftwareComponent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Stereotype getStereotype() {
		return (Stereotype)getMixed().get(CorePackage.Literals.DEPLOY_CORE_ROOT__STEREOTYPE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStereotype(Stereotype newStereotype, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(CorePackage.Literals.DEPLOY_CORE_ROOT__STEREOTYPE, newStereotype, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStereotype(Stereotype newStereotype) {
		((FeatureMap.Internal)getMixed()).set(CorePackage.Literals.DEPLOY_CORE_ROOT__STEREOTYPE, newStereotype);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Requirement getRequirement() {
		return (Requirement)getMixed().get(CorePackage.Literals.DEPLOY_CORE_ROOT__REQUIREMENT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRequirement(Requirement newRequirement, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(CorePackage.Literals.DEPLOY_CORE_ROOT__REQUIREMENT, newRequirement, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequirement(Requirement newRequirement) {
		((FeatureMap.Internal)getMixed()).set(CorePackage.Literals.DEPLOY_CORE_ROOT__REQUIREMENT, newRequirement);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Topology getTopology() {
		return (Topology)getMixed().get(CorePackage.Literals.DEPLOY_CORE_ROOT__TOPOLOGY, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTopology(Topology newTopology, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(CorePackage.Literals.DEPLOY_CORE_ROOT__TOPOLOGY, newTopology, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTopology(Topology newTopology) {
		((FeatureMap.Internal)getMixed()).set(CorePackage.Literals.DEPLOY_CORE_ROOT__TOPOLOGY, newTopology);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ConceptualNode getUnitConceptualNode() {
		return (ConceptualNode)getMixed().get(CorePackage.Literals.DEPLOY_CORE_ROOT__UNIT_CONCEPTUAL_NODE, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnitConceptualNode(ConceptualNode newUnitConceptualNode,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(CorePackage.Literals.DEPLOY_CORE_ROOT__UNIT_CONCEPTUAL_NODE, newUnitConceptualNode, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnitConceptualNode(ConceptualNode newUnitConceptualNode) {
		((FeatureMap.Internal)getMixed()).set(CorePackage.Literals.DEPLOY_CORE_ROOT__UNIT_CONCEPTUAL_NODE, newUnitConceptualNode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Visibility getVisibility() {
		return (Visibility)getMixed().get(CorePackage.Literals.DEPLOY_CORE_ROOT__VISIBILITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibility(Visibility newVisibility) {
		((FeatureMap.Internal)getMixed()).set(CorePackage.Literals.DEPLOY_CORE_ROOT__VISIBILITY, newVisibility);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Unit getUnit() {
		return (Unit)getMixed().get(CorePackage.Literals.DEPLOY_CORE_ROOT__UNIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnit(Unit newUnit, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(CorePackage.Literals.DEPLOY_CORE_ROOT__UNIT, newUnit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnit(Unit newUnit) {
		((FeatureMap.Internal)getMixed()).set(CorePackage.Literals.DEPLOY_CORE_ROOT__UNIT, newUnit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceConfiguration getConfigTopology() {
		return (InstanceConfiguration)getMixed().get(CorePackage.Literals.DEPLOY_CORE_ROOT__CONFIG_TOPOLOGY, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConfigTopology(InstanceConfiguration newConfigTopology,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(CorePackage.Literals.DEPLOY_CORE_ROOT__CONFIG_TOPOLOGY, newConfigTopology, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfigTopology(InstanceConfiguration newConfigTopology) {
		((FeatureMap.Internal)getMixed()).set(CorePackage.Literals.DEPLOY_CORE_ROOT__CONFIG_TOPOLOGY, newConfigTopology);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint getConstraint() {
		return (Constraint)getMixed().get(CorePackage.Literals.DEPLOY_CORE_ROOT__CONSTRAINT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConstraint(Constraint newConstraint, NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(CorePackage.Literals.DEPLOY_CORE_ROOT__CONSTRAINT, newConstraint, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ExplicitContract getContractExplicit() {
		return (ExplicitContract)getMixed().get(CorePackage.Literals.DEPLOY_CORE_ROOT__CONTRACT_EXPLICIT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContractExplicit(ExplicitContract newContractExplicit,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(CorePackage.Literals.DEPLOY_CORE_ROOT__CONTRACT_EXPLICIT, newContractExplicit, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setContractExplicit(ExplicitContract newContractExplicit) {
		((FeatureMap.Internal)getMixed()).set(CorePackage.Literals.DEPLOY_CORE_ROOT__CONTRACT_EXPLICIT, newContractExplicit);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationContract getContractTopology() {
		return (ConfigurationContract)getMixed().get(CorePackage.Literals.DEPLOY_CORE_ROOT__CONTRACT_TOPOLOGY, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContractTopology(ConfigurationContract newContractTopology,
			NotificationChain msgs) {
		return ((FeatureMap.Internal)getMixed()).basicAdd(CorePackage.Literals.DEPLOY_CORE_ROOT__CONTRACT_TOPOLOGY, newContractTopology, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setContractTopology(ConfigurationContract newContractTopology) {
		((FeatureMap.Internal)getMixed()).set(CorePackage.Literals.DEPLOY_CORE_ROOT__CONTRACT_TOPOLOGY, newContractTopology);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.DEPLOY_CORE_ROOT__MIXED:
				return ((InternalEList)getMixed()).basicRemove(otherEnd, msgs);
			case CorePackage.DEPLOY_CORE_ROOT__XMLNS_PREFIX_MAP:
				return ((InternalEList)((EMap.InternalMapView)getXMLNSPrefixMap()).eMap()).basicRemove(otherEnd, msgs);
			case CorePackage.DEPLOY_CORE_ROOT__XSI_SCHEMA_LOCATION:
				return ((InternalEList)((EMap.InternalMapView)getXSISchemaLocation()).eMap()).basicRemove(otherEnd, msgs);
			case CorePackage.DEPLOY_CORE_ROOT__ANNOTATION:
				return basicSetAnnotation(null, msgs);
			case CorePackage.DEPLOY_CORE_ROOT__ARTIFACT:
				return basicSetArtifact(null, msgs);
			case CorePackage.DEPLOY_CORE_ROOT__ARTIFACT_FILE:
				return basicSetArtifactFile(null, msgs);
			case CorePackage.DEPLOY_CORE_ROOT__BASE_COMPONENT:
				return basicSetBaseComponent(null, msgs);
			case CorePackage.DEPLOY_CORE_ROOT__UNIT:
				return basicSetUnit(null, msgs);
			case CorePackage.DEPLOY_CORE_ROOT__CAPABILITY:
				return basicSetCapability(null, msgs);
			case CorePackage.DEPLOY_CORE_ROOT__CAPABILITY_BUNDLE:
				return basicSetCapabilityBundle(null, msgs);
			case CorePackage.DEPLOY_CORE_ROOT__CAPABILITY_COMMUNICATION:
				return basicSetCapabilityCommunication(null, msgs);
			case CorePackage.DEPLOY_CORE_ROOT__CONFIG_TOPOLOGY:
				return basicSetConfigTopology(null, msgs);
			case CorePackage.DEPLOY_CORE_ROOT__CONSTRAINT:
				return basicSetConstraint(null, msgs);
			case CorePackage.DEPLOY_CORE_ROOT__CONTRACT_EXPLICIT:
				return basicSetContractExplicit(null, msgs);
			case CorePackage.DEPLOY_CORE_ROOT__CONTRACT_TOPOLOGY:
				return basicSetContractTopology(null, msgs);
			case CorePackage.DEPLOY_CORE_ROOT__DEPLOY_MODEL_OBJECT:
				return basicSetDeployModelObject(null, msgs);
			case CorePackage.DEPLOY_CORE_ROOT__IMPORT:
				return basicSetImport(null, msgs);
			case CorePackage.DEPLOY_CORE_ROOT__INSTANTIATION:
				return basicSetInstantiation(null, msgs);
			case CorePackage.DEPLOY_CORE_ROOT__INTERFACE:
				return basicSetInterface(null, msgs);
			case CorePackage.DEPLOY_CORE_ROOT__LINK_CONSTRAINT:
				return basicSetLinkConstraint(null, msgs);
			case CorePackage.DEPLOY_CORE_ROOT__LINK_DEPENDENCY:
				return basicSetLinkDependency(null, msgs);
			case CorePackage.DEPLOY_CORE_ROOT__LINK_DEPLOY:
				return basicSetLinkDeploy(null, msgs);
			case CorePackage.DEPLOY_CORE_ROOT__LINK_HOSTING:
				return basicSetLinkHosting(null, msgs);
			case CorePackage.DEPLOY_CORE_ROOT__LINK_UNIT:
				return basicSetLinkUnit(null, msgs);
			case CorePackage.DEPLOY_CORE_ROOT__LINK_MEMBER:
				return basicSetLinkMember(null, msgs);
			case CorePackage.DEPLOY_CORE_ROOT__LINK_REALIZATION:
				return basicSetLinkRealization(null, msgs);
			case CorePackage.DEPLOY_CORE_ROOT__PROPERTY:
				return basicSetProperty(null, msgs);
			case CorePackage.DEPLOY_CORE_ROOT__REFERENCE:
				return basicSetReference(null, msgs);
			case CorePackage.DEPLOY_CORE_ROOT__REQUIREMENT:
				return basicSetRequirement(null, msgs);
			case CorePackage.DEPLOY_CORE_ROOT__REQ_EXPR:
				return basicSetReqExpr(null, msgs);
			case CorePackage.DEPLOY_CORE_ROOT__SERVICE:
				return basicSetService(null, msgs);
			case CorePackage.DEPLOY_CORE_ROOT__SOFTWARE_COMPONENT:
				return basicSetSoftwareComponent(null, msgs);
			case CorePackage.DEPLOY_CORE_ROOT__STEREOTYPE:
				return basicSetStereotype(null, msgs);
			case CorePackage.DEPLOY_CORE_ROOT__TOPOLOGY:
				return basicSetTopology(null, msgs);
			case CorePackage.DEPLOY_CORE_ROOT__UNIT_CONCEPTUAL_NODE:
				return basicSetUnitConceptualNode(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.DEPLOY_CORE_ROOT__MIXED:
				if (coreType) return getMixed();
				return ((FeatureMap.Internal)getMixed()).getWrapper();
			case CorePackage.DEPLOY_CORE_ROOT__XMLNS_PREFIX_MAP:
				if (coreType) return ((EMap.InternalMapView)getXMLNSPrefixMap()).eMap();
				else return getXMLNSPrefixMap();
			case CorePackage.DEPLOY_CORE_ROOT__XSI_SCHEMA_LOCATION:
				if (coreType) return ((EMap.InternalMapView)getXSISchemaLocation()).eMap();
				else return getXSISchemaLocation();
			case CorePackage.DEPLOY_CORE_ROOT__ANNOTATION:
				return getAnnotation();
			case CorePackage.DEPLOY_CORE_ROOT__ARTIFACT:
				return getArtifact();
			case CorePackage.DEPLOY_CORE_ROOT__ARTIFACT_FILE:
				return getArtifactFile();
			case CorePackage.DEPLOY_CORE_ROOT__BASE_COMPONENT:
				return getBaseComponent();
			case CorePackage.DEPLOY_CORE_ROOT__UNIT:
				return getUnit();
			case CorePackage.DEPLOY_CORE_ROOT__CAPABILITY:
				return getCapability();
			case CorePackage.DEPLOY_CORE_ROOT__CAPABILITY_BUNDLE:
				return getCapabilityBundle();
			case CorePackage.DEPLOY_CORE_ROOT__CAPABILITY_COMMUNICATION:
				return getCapabilityCommunication();
			case CorePackage.DEPLOY_CORE_ROOT__CONFIG_TOPOLOGY:
				return getConfigTopology();
			case CorePackage.DEPLOY_CORE_ROOT__CONSTRAINT:
				return getConstraint();
			case CorePackage.DEPLOY_CORE_ROOT__CONTRACT_EXPLICIT:
				return getContractExplicit();
			case CorePackage.DEPLOY_CORE_ROOT__CONTRACT_TOPOLOGY:
				return getContractTopology();
			case CorePackage.DEPLOY_CORE_ROOT__DEPLOY_MODEL_OBJECT:
				return getDeployModelObject();
			case CorePackage.DEPLOY_CORE_ROOT__IMPORT:
				return getImport();
			case CorePackage.DEPLOY_CORE_ROOT__INSTANTIATION:
				return getInstantiation();
			case CorePackage.DEPLOY_CORE_ROOT__INTERFACE:
				return getInterface();
			case CorePackage.DEPLOY_CORE_ROOT__LINK_CONSTRAINT:
				return getLinkConstraint();
			case CorePackage.DEPLOY_CORE_ROOT__LINK_DEPENDENCY:
				return getLinkDependency();
			case CorePackage.DEPLOY_CORE_ROOT__LINK_DEPLOY:
				return getLinkDeploy();
			case CorePackage.DEPLOY_CORE_ROOT__LINK_HOSTING:
				return getLinkHosting();
			case CorePackage.DEPLOY_CORE_ROOT__LINK_UNIT:
				return getLinkUnit();
			case CorePackage.DEPLOY_CORE_ROOT__LINK_MEMBER:
				return getLinkMember();
			case CorePackage.DEPLOY_CORE_ROOT__LINK_REALIZATION:
				return getLinkRealization();
			case CorePackage.DEPLOY_CORE_ROOT__PROPERTY:
				return getProperty();
			case CorePackage.DEPLOY_CORE_ROOT__REFERENCE:
				return getReference();
			case CorePackage.DEPLOY_CORE_ROOT__REQUIREMENT:
				return getRequirement();
			case CorePackage.DEPLOY_CORE_ROOT__REQ_EXPR:
				return getReqExpr();
			case CorePackage.DEPLOY_CORE_ROOT__SERVICE:
				return getService();
			case CorePackage.DEPLOY_CORE_ROOT__SOFTWARE_COMPONENT:
				return getSoftwareComponent();
			case CorePackage.DEPLOY_CORE_ROOT__STEREOTYPE:
				return getStereotype();
			case CorePackage.DEPLOY_CORE_ROOT__TOPOLOGY:
				return getTopology();
			case CorePackage.DEPLOY_CORE_ROOT__UNIT_CONCEPTUAL_NODE:
				return getUnitConceptualNode();
			case CorePackage.DEPLOY_CORE_ROOT__VISIBILITY:
				return getVisibility();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CorePackage.DEPLOY_CORE_ROOT__MIXED:
				((FeatureMap.Internal)getMixed()).set(newValue);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__XMLNS_PREFIX_MAP:
				((EStructuralFeature.Setting)((EMap.InternalMapView)getXMLNSPrefixMap()).eMap()).set(newValue);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__XSI_SCHEMA_LOCATION:
				((EStructuralFeature.Setting)((EMap.InternalMapView)getXSISchemaLocation()).eMap()).set(newValue);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__ANNOTATION:
				setAnnotation((Annotation)newValue);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__ARTIFACT:
				setArtifact((Artifact)newValue);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__ARTIFACT_FILE:
				setArtifactFile((FileArtifact)newValue);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__BASE_COMPONENT:
				setBaseComponent((BaseComponentUnit)newValue);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__UNIT:
				setUnit((Unit)newValue);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__CAPABILITY:
				setCapability((Capability)newValue);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__CAPABILITY_BUNDLE:
				setCapabilityBundle((BundleCapability)newValue);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__CAPABILITY_COMMUNICATION:
				setCapabilityCommunication((CommunicationCapability)newValue);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__CONFIG_TOPOLOGY:
				setConfigTopology((InstanceConfiguration)newValue);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__CONTRACT_EXPLICIT:
				setContractExplicit((ExplicitContract)newValue);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__CONTRACT_TOPOLOGY:
				setContractTopology((ConfigurationContract)newValue);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__IMPORT:
				setImport((Import)newValue);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__INSTANTIATION:
				setInstantiation((Instantiation)newValue);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__INTERFACE:
				setInterface((Interface)newValue);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__LINK_CONSTRAINT:
				setLinkConstraint((ConstraintLink)newValue);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__LINK_DEPENDENCY:
				setLinkDependency((DependencyLink)newValue);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__LINK_DEPLOY:
				setLinkDeploy((DeployLink)newValue);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__LINK_HOSTING:
				setLinkHosting((HostingLink)newValue);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__LINK_UNIT:
				setLinkUnit((UnitLink)newValue);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__LINK_MEMBER:
				setLinkMember((MemberLink)newValue);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__LINK_REALIZATION:
				setLinkRealization((RealizationLink)newValue);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__PROPERTY:
				setProperty((Property)newValue);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__REFERENCE:
				setReference((Reference)newValue);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__REQUIREMENT:
				setRequirement((Requirement)newValue);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__REQ_EXPR:
				setReqExpr((RequirementExpression)newValue);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__SERVICE:
				setService((Service)newValue);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__SOFTWARE_COMPONENT:
				setSoftwareComponent((SoftwareComponent)newValue);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__STEREOTYPE:
				setStereotype((Stereotype)newValue);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__TOPOLOGY:
				setTopology((Topology)newValue);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__UNIT_CONCEPTUAL_NODE:
				setUnitConceptualNode((ConceptualNode)newValue);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__VISIBILITY:
				setVisibility((Visibility)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case CorePackage.DEPLOY_CORE_ROOT__MIXED:
				getMixed().clear();
				return;
			case CorePackage.DEPLOY_CORE_ROOT__XMLNS_PREFIX_MAP:
				getXMLNSPrefixMap().clear();
				return;
			case CorePackage.DEPLOY_CORE_ROOT__XSI_SCHEMA_LOCATION:
				getXSISchemaLocation().clear();
				return;
			case CorePackage.DEPLOY_CORE_ROOT__ANNOTATION:
				setAnnotation((Annotation)null);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__ARTIFACT:
				setArtifact((Artifact)null);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__ARTIFACT_FILE:
				setArtifactFile((FileArtifact)null);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__BASE_COMPONENT:
				setBaseComponent((BaseComponentUnit)null);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__UNIT:
				setUnit((Unit)null);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__CAPABILITY:
				setCapability((Capability)null);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__CAPABILITY_BUNDLE:
				setCapabilityBundle((BundleCapability)null);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__CAPABILITY_COMMUNICATION:
				setCapabilityCommunication((CommunicationCapability)null);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__CONFIG_TOPOLOGY:
				setConfigTopology((InstanceConfiguration)null);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__CONTRACT_EXPLICIT:
				setContractExplicit((ExplicitContract)null);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__CONTRACT_TOPOLOGY:
				setContractTopology((ConfigurationContract)null);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__IMPORT:
				setImport((Import)null);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__INSTANTIATION:
				setInstantiation((Instantiation)null);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__INTERFACE:
				setInterface((Interface)null);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__LINK_CONSTRAINT:
				setLinkConstraint((ConstraintLink)null);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__LINK_DEPENDENCY:
				setLinkDependency((DependencyLink)null);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__LINK_DEPLOY:
				setLinkDeploy((DeployLink)null);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__LINK_HOSTING:
				setLinkHosting((HostingLink)null);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__LINK_UNIT:
				setLinkUnit((UnitLink)null);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__LINK_MEMBER:
				setLinkMember((MemberLink)null);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__LINK_REALIZATION:
				setLinkRealization((RealizationLink)null);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__PROPERTY:
				setProperty((Property)null);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__REFERENCE:
				setReference((Reference)null);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__REQUIREMENT:
				setRequirement((Requirement)null);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__REQ_EXPR:
				setReqExpr((RequirementExpression)null);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__SERVICE:
				setService((Service)null);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__SOFTWARE_COMPONENT:
				setSoftwareComponent((SoftwareComponent)null);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__STEREOTYPE:
				setStereotype((Stereotype)null);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__TOPOLOGY:
				setTopology((Topology)null);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__UNIT_CONCEPTUAL_NODE:
				setUnitConceptualNode((ConceptualNode)null);
				return;
			case CorePackage.DEPLOY_CORE_ROOT__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CorePackage.DEPLOY_CORE_ROOT__MIXED:
				return mixed != null && !mixed.isEmpty();
			case CorePackage.DEPLOY_CORE_ROOT__XMLNS_PREFIX_MAP:
				return xMLNSPrefixMap != null && !xMLNSPrefixMap.isEmpty();
			case CorePackage.DEPLOY_CORE_ROOT__XSI_SCHEMA_LOCATION:
				return xSISchemaLocation != null && !xSISchemaLocation.isEmpty();
			case CorePackage.DEPLOY_CORE_ROOT__ANNOTATION:
				return getAnnotation() != null;
			case CorePackage.DEPLOY_CORE_ROOT__ARTIFACT:
				return getArtifact() != null;
			case CorePackage.DEPLOY_CORE_ROOT__ARTIFACT_FILE:
				return getArtifactFile() != null;
			case CorePackage.DEPLOY_CORE_ROOT__BASE_COMPONENT:
				return getBaseComponent() != null;
			case CorePackage.DEPLOY_CORE_ROOT__UNIT:
				return getUnit() != null;
			case CorePackage.DEPLOY_CORE_ROOT__CAPABILITY:
				return getCapability() != null;
			case CorePackage.DEPLOY_CORE_ROOT__CAPABILITY_BUNDLE:
				return getCapabilityBundle() != null;
			case CorePackage.DEPLOY_CORE_ROOT__CAPABILITY_COMMUNICATION:
				return getCapabilityCommunication() != null;
			case CorePackage.DEPLOY_CORE_ROOT__CONFIG_TOPOLOGY:
				return getConfigTopology() != null;
			case CorePackage.DEPLOY_CORE_ROOT__CONSTRAINT:
				return getConstraint() != null;
			case CorePackage.DEPLOY_CORE_ROOT__CONTRACT_EXPLICIT:
				return getContractExplicit() != null;
			case CorePackage.DEPLOY_CORE_ROOT__CONTRACT_TOPOLOGY:
				return getContractTopology() != null;
			case CorePackage.DEPLOY_CORE_ROOT__DEPLOY_MODEL_OBJECT:
				return getDeployModelObject() != null;
			case CorePackage.DEPLOY_CORE_ROOT__IMPORT:
				return getImport() != null;
			case CorePackage.DEPLOY_CORE_ROOT__INSTANTIATION:
				return getInstantiation() != null;
			case CorePackage.DEPLOY_CORE_ROOT__INTERFACE:
				return getInterface() != null;
			case CorePackage.DEPLOY_CORE_ROOT__LINK_CONSTRAINT:
				return getLinkConstraint() != null;
			case CorePackage.DEPLOY_CORE_ROOT__LINK_DEPENDENCY:
				return getLinkDependency() != null;
			case CorePackage.DEPLOY_CORE_ROOT__LINK_DEPLOY:
				return getLinkDeploy() != null;
			case CorePackage.DEPLOY_CORE_ROOT__LINK_HOSTING:
				return getLinkHosting() != null;
			case CorePackage.DEPLOY_CORE_ROOT__LINK_UNIT:
				return getLinkUnit() != null;
			case CorePackage.DEPLOY_CORE_ROOT__LINK_MEMBER:
				return getLinkMember() != null;
			case CorePackage.DEPLOY_CORE_ROOT__LINK_REALIZATION:
				return getLinkRealization() != null;
			case CorePackage.DEPLOY_CORE_ROOT__PROPERTY:
				return getProperty() != null;
			case CorePackage.DEPLOY_CORE_ROOT__REFERENCE:
				return getReference() != null;
			case CorePackage.DEPLOY_CORE_ROOT__REQUIREMENT:
				return getRequirement() != null;
			case CorePackage.DEPLOY_CORE_ROOT__REQ_EXPR:
				return getReqExpr() != null;
			case CorePackage.DEPLOY_CORE_ROOT__SERVICE:
				return getService() != null;
			case CorePackage.DEPLOY_CORE_ROOT__SOFTWARE_COMPONENT:
				return getSoftwareComponent() != null;
			case CorePackage.DEPLOY_CORE_ROOT__STEREOTYPE:
				return getStereotype() != null;
			case CorePackage.DEPLOY_CORE_ROOT__TOPOLOGY:
				return getTopology() != null;
			case CorePackage.DEPLOY_CORE_ROOT__UNIT_CONCEPTUAL_NODE:
				return getUnitConceptualNode() != null;
			case CorePackage.DEPLOY_CORE_ROOT__VISIBILITY:
				return getVisibility() != VISIBILITY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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

} //DeployCoreRootImpl
