/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Topology</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 			    A container of {@link Unit} instances expressing a deployment topology.
 * 			    <p>
 * 			    In the first release of the Topology Definition Model (TDM) a topology
 * 			    wholly contains all the links between its {@link Unit} instances.  Future
 * 			    releases will support cross-topology linking.</p>
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Topology#getImports <em>Imports</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Topology#getConfigurationContractGroup <em>Configuration Contract Group</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Topology#getConfigurationContract <em>Configuration Contract</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Topology#getDecoratorSemantic <em>Decorator Semantic</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Topology#isMutabilityConfigurable <em>Mutability Configurable</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.Topology#getNamespace <em>Namespace</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getTopology()
 * @model features="unitGroup units unitLinksGroup unitLinks constraintLinks dependencyLinkGroup dependencyLinks realizationLinks" 
 *        unitGroupUnique="false" unitGroupDataType="org.eclipse.emf.ecore.EFeatureMapEntry" unitGroupMany="true" unitGroupSuppressedGetVisibility="true" unitGroupSuppressedSetVisibility="true"
 *        unitGroupExtendedMetaData="kind='group' name='unit:group' namespace='##targetNamespace'"
 *        unitsType="com.ibm.ccl.soa.deploy.core.Unit" unitsContainment="true" unitsMany="true" unitsTransient="true" unitsVolatile="true" unitsDerived="true" unitsSuppressedGetVisibility="true" unitsSuppressedSetVisibility="true"
 *        unitsExtendedMetaData="kind='element' name='unit' namespace='##targetNamespace' group='unit:group'"
 *        unitLinksGroupUnique="false" unitLinksGroupDataType="org.eclipse.emf.ecore.EFeatureMapEntry" unitLinksGroupMany="true" unitLinksGroupSuppressedGetVisibility="true" unitLinksGroupSuppressedSetVisibility="true"
 *        unitLinksGroupExtendedMetaData="kind='group' name='link.unit:group' namespace='##targetNamespace'"
 *        unitLinksType="com.ibm.ccl.soa.deploy.core.UnitLink" unitLinksContainment="true" unitLinksMany="true" unitLinksTransient="true" unitLinksVolatile="true" unitLinksDerived="true" unitLinksSuppressedGetVisibility="true" unitLinksSuppressedSetVisibility="true"
 *        unitLinksExtendedMetaData="kind='element' name='link.unit' namespace='##targetNamespace' group='link.unit:group'"
 *        constraintLinksType="com.ibm.ccl.soa.deploy.core.ConstraintLink" constraintLinksContainment="true" constraintLinksMany="true" constraintLinksSuppressedGetVisibility="true" constraintLinksSuppressedSetVisibility="true"
 *        constraintLinksExtendedMetaData="kind='element' name='link.constraint' namespace='##targetNamespace'"
 *        dependencyLinkGroupUnique="false" dependencyLinkGroupDataType="org.eclipse.emf.ecore.EFeatureMapEntry" dependencyLinkGroupMany="true" dependencyLinkGroupSuppressedGetVisibility="true" dependencyLinkGroupSuppressedSetVisibility="true"
 *        dependencyLinkGroupExtendedMetaData="kind='group' name='link.dependency:group' namespace='##targetNamespace'"
 *        dependencyLinksType="com.ibm.ccl.soa.deploy.core.DependencyLink" dependencyLinksContainment="true" dependencyLinksMany="true" dependencyLinksTransient="true" dependencyLinksVolatile="true" dependencyLinksDerived="true" dependencyLinksSuppressedGetVisibility="true" dependencyLinksSuppressedSetVisibility="true"
 *        dependencyLinksExtendedMetaData="kind='element' name='link.dependency' namespace='##targetNamespace' group='link.dependency:group'"
 *        realizationLinksType="com.ibm.ccl.soa.deploy.core.RealizationLink" realizationLinksContainment="true" realizationLinksMany="true" realizationLinksSuppressedGetVisibility="true" realizationLinksSuppressedSetVisibility="true"
 *        realizationLinksExtendedMetaData="kind='element' name='link.realization' namespace='##targetNamespace'"
 *        extendedMetaData="name='Topology' kind='elementOnly'"
 * @generated
 */
public interface Topology extends DeployModelObject {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * A topology listener flag used to register a topology listener that wants to recieve all
	 * notifications. No notification filtering will take place.
	 * 
	 * @see #addTopologyListener(Adapter, Object)
	 * @see #removeTopologyListener(Adapter, Object)
	 */
	String WILDCARD_LISTENER = "*"; //$NON-NLS-1$

	/**
	 * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
	 * The list contents are of type {@link com.ibm.ccl.soa.deploy.core.Import}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' containment reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' containment reference list.
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getTopology_Imports()
	 * @model type="com.ibm.ccl.soa.deploy.core.Import" containment="true"
	 *        extendedMetaData="kind='element' name='import' namespace='##targetNamespace'"
	 * @generated
	 */
	List getImports();

	/**
	 * Returns the value of the '<em><b>Configuration Contract Group</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration Contract Group</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Configuration Contract Group</em>' attribute list.
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getTopology_ConfigurationContractGroup()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" required="true"
	 *        many="false" extendedMetaData="kind='group' name='contract.topology:group'
	 *        namespace='##targetNamespace'"
	 * @generated
	 */
	FeatureMap getConfigurationContractGroup();

	/**
	 * Returns the value of the '<em><b>Decorator Semantic</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Decorator Semantic</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Decorator Semantic</em>' attribute.
	 * @see #setDecoratorSemantic(String)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getTopology_DecoratorSemantic()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='decoratorSemantic'"
	 * @generated
	 */
	String getDecoratorSemantic();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.Topology#getDecoratorSemantic <em>Decorator Semantic</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Decorator Semantic</em>' attribute.
	 * @see #getDecoratorSemantic()
	 * @generated
	 */
	void setDecoratorSemantic(String value);

	/**
	 * Returns the value of the '<em><b>Mutability Configurable</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mutability Configurable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mutability Configurable</em>' attribute.
	 * @see #isSetMutabilityConfigurable()
	 * @see #unsetMutabilityConfigurable()
	 * @see #setMutabilityConfigurable(boolean)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getTopology_MutabilityConfigurable()
	 * @model default="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='mutabilityConfigurable'"
	 * @generated
	 */
	boolean isMutabilityConfigurable();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.Topology#isMutabilityConfigurable <em>Mutability Configurable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mutability Configurable</em>' attribute.
	 * @see #isSetMutabilityConfigurable()
	 * @see #unsetMutabilityConfigurable()
	 * @see #isMutabilityConfigurable()
	 * @generated
	 */
	void setMutabilityConfigurable(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.core.Topology#isMutabilityConfigurable <em>Mutability Configurable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMutabilityConfigurable()
	 * @see #isMutabilityConfigurable()
	 * @see #setMutabilityConfigurable(boolean)
	 * @generated
	 */
	void unsetMutabilityConfigurable();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.core.Topology#isMutabilityConfigurable <em>Mutability Configurable</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Mutability Configurable</em>' attribute is set.
	 * @see #unsetMutabilityConfigurable()
	 * @see #isMutabilityConfigurable()
	 * @see #setMutabilityConfigurable(boolean)
	 * @generated
	 */
	boolean isSetMutabilityConfigurable();

	/**
	 * Returns the value of the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespace</em>' attribute isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namespace</em>' attribute.
	 * @see #setNamespace(String)
	 * @see com.ibm.ccl.soa.deploy.core.CorePackage#getTopology_Namespace()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='namespace'"
	 * @generated
	 */
	String getNamespace();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.Topology#getNamespace <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namespace</em>' attribute.
	 * @see #getNamespace()
	 * @generated
	 */
	void setNamespace(String value);

	/**
	 * Return a list containing {@link Unit} elements described within the topology.
	 * 
	 * @return List
	 * @see Unit
	 * @generated NOT
	 */
	List getUnits();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" type="com.ibm.ccl.soa.deploy.core.DeployModelObject"
	 * @generated
	 */
	List getGroups();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" type="com.ibm.ccl.soa.deploy.core.DeployModelObject"
	 * @generated
	 */
	List getConfigurations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" type="com.ibm.ccl.soa.deploy.core.DeployModelObject"
	 * @generated
	 */
	List getConceptualUnits();

	/**
	 * Returns an iterator over all DeployModelObject instances in the topology and its linked
	 * topologies (recursive).
	 * <p>
	 * The set of linked topologies contains this topology along with all the topologies it imports,
	 * as well as those that import it (recursive).
	 * 
	 * @return Iterator<DeployModelObject>
	 * @generated NOT
	 */
	public Iterator findAllDeployModelObjects();

	/**
	 * Returns an iterator over all DeployModelObject instances contained in the topology
	 * (recursive).
	 * <p>
	 * Does not return objects in imported or importing topologies.
	 * 
	 * @return Iterator<DeployModelObject>
	 * @generated NOT
	 */
	public Iterator findLocalDeployModelObjects();

	/**
	 * Returns an iterator over all {@link Unit} instances contained directly or indirectly in the
	 * topology (recursive).
	 * 
	 * @return Iterator<Unit>
	 * @generated NOT
	 * @see #findAllPublicUnits()
	 */
	public Iterator findAllUnits();

	/**
	 * Returns an iterator over all {@link Unit} instances in the topology as well as publicly
	 * imported ones.
	 * 
	 * @return Iterator<Unit>
	 * @generated NOT
	 * @see #findAllUnits()
	 */
	Iterator findAllPublicUnits();

	/**
	 * Returns an iterator over all {@link ConfigurationUnit} instances contained directly or
	 * indirectly in the topology (recursive).
	 * 
	 * @return Iterator<ConfigurationUnit>
	 * @generated NOT
	 */
	public Iterator findAllConfigurationUnits();

	/**
	 * Returns an iterator over all capabilities instances provided by units directly, indirectly
	 * contained directly or indirectly in the topology (recursive).
	 * 
	 * @see Unit#getCapabilities()
	 * 
	 * @return Iterator<Capability>
	 * @generated NOT
	 */
	public Iterator findAllCapabilities();

	/**
	 * Returns an iterator over all {@link Capability} instances whose {@link Capability#isHosting()}
	 * is false, provided by units contained directly or indirectly in the topology (recursive).
	 * 
	 * @see Unit#getOnlyDependencyCapabilities()
	 * 
	 * @return Iterator<Capability>
	 * @generated NOT
	 */
	public Iterator findAllNonHostingCapabilities();

	/**
	 * Returns an iterator over all {@link Capability} instances whose {@link Capability#isHosting()}
	 * is false, provided by units contained directly or indirectly in the topology (recursive).
	 * 
	 * @see Unit#getHostingOrAnyCapabilities()
	 * 
	 * @return Iterator<Capability>
	 * @generated NOT
	 */
	public Iterator findAllHostingCapabilities();

	/**
	 * Returns an iterator over all {@link Requirement} instances contained in the topology.
	 * 
	 * @see Unit#getRequirements()
	 * 
	 * @return Iterator<Requirement>
	 * @generated NOT
	 */
	public Iterator findAllRequirements();

	/**
	 * Returns an iterator over all {@link RequirementExpression} instances contained in the
	 * topology.
	 * 
	 * @return Iterator<RequirementExpression>
	 * @generated NOT
	 */
	public Iterator findAllRequirementExpressions();

	/**
	 * Returns an iterator over all {@link Requirement} instances whose
	 * {@link Requirement#isHosting()} is true that are contained directly or indirectly in the
	 * topology.
	 * 
	 * @return Iterator<Requirement>
	 * @generated NOT
	 */
	public Iterator findAllHostingRequirements();

	/**
	 * Returns an iterator over all {@link Requirement} instances whose
	 * {@link Requirement#isHosting()} is false that are contained directly or indirectly in the
	 * topology.
	 * 
	 * @return Iterator<Requirement>
	 * @generated NOT
	 */
	public Iterator findAllNonHostingRequirements();

	/**
	 * Returns an iterator over all {@link DeployLink} instances contained directly or indirectly in
	 * the topology.
	 * 
	 * @return Iterator<DeployLink>
	 */
	public Iterator findAllDeployLinks();

	/**
	 * Returns an iterator over all {@link DependencyLink} instances contained directly or indirectly
	 * in the topology.
	 * 
	 * @see Requirement#getLink()
	 * @see #getDependencyLinks()
	 * 
	 * @return Iterator<DependencyLink>
	 * @generated NOT
	 */
	public Iterator findAllDependencyLinks();

	/**
	 * Returns an iterator over all {@link ConstraintLink} instances contained directly or indirectly
	 * in the topology.
	 * 
	 * @see #getConstraintLinks()
	 * @see Unit#getConstraintLinks()
	 * 
	 * @return Iterator<LogicalLink>
	 * @generated NOT
	 */
	public Iterator findAllConstraintLinks();

	/**
	 * Returns an iterator over all {@link RealizationLink} instances contained directly or
	 * indirectly in the topology.
	 * 
	 * @see #getRealizationLinks()
	 * @see Unit#getRealizationLinks()
	 * 
	 * @return Iterator<LogicalLink>
	 * @generated NOT
	 */
	public Iterator findAllRealizationLinks();

	/**
	 * Returns an iterator over all {@link UnitLink} instances contained directly or indirectly in
	 * the topology.
	 * 
	 * @see Unit#getUnitLinks()
	 * @see #getUnitLinks()
	 * 
	 * @return Iterator<UnitLink>
	 * @generated NOT
	 */
	public Iterator findAllUnitLinks();

	/**
	 * Returns an iterator over all hosting link instances contained directly or indirectly in the
	 * topology.
	 * 
	 * @see Unit#getHostingLinks()
	 * @see #getHostingLinks()
	 * 
	 * @return Iterator<HostingLink>
	 * @generated NOT
	 */
	public Iterator findAllHostingLinks();

	/**
	 * Returns an iterator over all {@link MemberLink} instances contained directly or indirectly in
	 * the topology.
	 * 
	 * @see Unit#getMemberLinks()
	 * @see #getMemberLinks()
	 * 
	 * @return Iterator<MemberLink>
	 * @generated NOT
	 */
	public Iterator findAllMemberLinks();

	/**
	 * Returns an iterator over all {@link Artifact} instances contained directly or indirectly in
	 * the topology.
	 * 
	 * @see Unit#getArtifacts()
	 * 
	 * @return Iterator<Artifact>
	 * @generated NOT
	 */
	public Iterator findAllArtifacts();

	/**
	 * This API will return a array of {@link Unit} instances which host the passed unit.
	 * 
	 * <p>
	 * For each element in the returned array there will be a {@link HostingLink} which has the
	 * passed unit as the hosted target.
	 * </p>
	 * 
	 * <p>
	 * This method will not return null.
	 * </p>
	 * 
	 * @param unit -
	 *           The {@link Unit} which is being hosted.
	 * @return {@link Unit}[] of the hosts for the passed unit.
	 * @generated NOT
	 */
	Unit[] findHosts(Unit unit);

	/**
	 * This API will return a array of {@link Unit} instances which consider the passed unit a member
	 * of their relationships.
	 * 
	 * <p>
	 * For each element in the returned array there will be a {@link MemberLink} which has the passed
	 * unit as the member target.
	 * </p>
	 * 
	 * <p>
	 * This method will not return null.
	 * </p>
	 * 
	 * @param unit -
	 *           The {@link Unit} which might be a member of some other Unit.
	 * @return {@link Unit}[] of the member link owner for the passed unit.
	 * @generated NOT
	 */
	Unit[] findMemberOf(Unit unit);

	/**
	 * Finds all {@link Requirement} instances for which {@link Requirement#getLink()} has the
	 * capability argument as a target ({@link DependencyLink#getTarget()}).
	 * 
	 * @param cap
	 *           a capability.
	 * @return an array of requirements, never null.
	 * @generated NOT
	 */
	Requirement[] findDependentRequirements(Capability cap);

	/**
	 * Get a list of top-level realization links in this topology
	 * 
	 * @see Unit#getRealizationLinks()
	 * @see #getRealizationLinks()
	 * 
	 * @return A list of {@link RealizationLink} instances.
	 * @generated NOT
	 */
	List getRealizationLinks();

	/**
	 * @return A list of top-level {@link UnitLink} instances.
	 * @generated NOT
	 */
	List getUnitLinks();

	/**
	 * Get a list of top-level hosting links between <code>Unit</code>s
	 * 
	 * @return A list of {@link HostingLink} instances.
	 * @generated NOT
	 */
	List getHostingLinks();

	/**
	 * Get a list of top-level member links between <code>Unit</code>s
	 * 
	 * @return A list of {@link MemberLink} instances.
	 * @generated NOT
	 */
	List getMemberLinks();

	/**
	 * Get a list of top-level dependency links in this topology
	 * 
	 * @return A list of {@link DependencyLink} instances.
	 * @generated NOT
	 */
	List getConstraintLinks();

	/**
	 * Get a list of top-level dependency links in this topology
	 * 
	 * @return A list of {@link DependencyLink} instances.
	 * @generated NOT
	 */
	List getDependencyLinks();

	/**
	 * Return a dependency link from the Topology for the given source requirement. If the source
	 * requirement has a dependency link set on it already it will be ignored.
	 * 
	 * @param sourcePath
	 *           The sourcePath of the requirement.
	 * @return The dependency link for the source.
	 */
	DependencyLink getDependencyLink(String sourcePath);

	/**
	 * Return the configuration contract for this topology.
	 * 
	 * @return The configuration contract of this topology
	 * @generated NOT
	 */
	ConfigurationContract getConfigurationContract();

	/**
	 * Copied up from the impl.
	 * 
	 * @param newConfigurationContract
	 */
	public void setConfigurationContract(ConfigurationContract newConfigurationContract);

	/**
	 * Returns a topology {@link Import} matching the namespace and pattern.
	 * <p>
	 * Queries {@link #getImports()} to find a matching {@link Import}.
	 * 
	 * @param fullyQualifiedPath
	 *           the fully qualified Topology name (e.g. namespace + . + topologyName)
	 * 
	 * @return an import with equal {@link Import#getNamespace()} and {@link Import#getPattern()} or
	 *         null if not found.
	 * 
	 * @see #getImport(String, String)
	 * 
	 * @generated NOT
	 */
	Import getImport(String fullyQualifiedPath);

	/**
	 * Returns a topology {@link Import} matching the namespace and pattern.
	 * <p>
	 * Queries {@link #getImports()} to find a matching {@link Import}.
	 * 
	 * @param namespace
	 *           the imported topology namespace (may be null, or
	 *           INamespaceElement.DEFAULT_NAMESPACE).
	 * @param pattern
	 *           a pattern on the topology name.
	 * @return an import with equal {@link Import#getNamespace()} and {@link Import#getPattern()} or
	 *         null if not found.
	 * 
	 * @generated NOT
	 */
	Import getImport(String namespace, String pattern);

	/**
	 * Return the fully qualified name for the topology. If there is a namespace present, prefix with
	 * namespace.
	 * 
	 * @return the fully qualified name of the topology
	 */
	String getQualifiedName();

	/**
	 * @return methods for link navigation
	 */
	public IRelationshipChecker getRelationships();

	/**
	 * Add a listener that will get notifications for changes based on the registered feature.
	 * 
	 * You must call {@link #removeTopologyListener(Adapter, Object)} when you no longer want to
	 * receive notifications for this feature. Be sure to use the same feature that was used to add
	 * the listener.
	 * 
	 * @param listener
	 *           An {@link Adapter} that will listen to changes.
	 * @param feature
	 *           An {@link Object} that you want to be notified of changes. Typically this is an
	 *           {@link EStructuralFeature}.
	 * 
	 * @see #removeTopologyListener(Adapter, Object)
	 */
	void addTopologyListener(Adapter listener, Object feature);

	/**
	 * Remove a listener that is registered to receive topology wide changes based on a feature. Be
	 * sure to call {@link #removeTopologyListener(Adapter, Object)} when listening is no longer
	 * required.
	 * 
	 * @param listener
	 *           An {@link Adapter} that will listen to changes.
	 * @param feature
	 *           An {@link Object} that you want to stop being notified of changes. Typically this is
	 *           an {@link EStructuralFeature}.
	 * 
	 * @see #removeTopologyListener(Adapter, Object)
	 */
	void removeTopologyListener(Adapter listener, Object feature);

} // Topology
