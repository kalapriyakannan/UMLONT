/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.core.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.ConstraintLink;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DependencyLink;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.IRelationshipChecker;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.RealizationLink;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceElement;
import com.ibm.ccl.soa.deploy.core.util.CapabilityLinkTypeFilter;
import com.ibm.ccl.soa.deploy.core.util.EObjectTypeFilter;
import com.ibm.ccl.soa.deploy.core.util.FilterIterator;
import com.ibm.ccl.soa.deploy.core.util.FilterList;
import com.ibm.ccl.soa.deploy.core.util.IObjectFilter;
import com.ibm.ccl.soa.deploy.core.util.RequirementLinkTypeFilter;
import com.ibm.ccl.soa.deploy.core.util.SecondOrderIterator;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreSafeRunnable;
import com.ibm.ccl.soa.deploy.internal.core.FeatureAdapter;
import com.ibm.ccl.soa.deploy.internal.core.FeatureAwareList;
import com.ibm.ccl.soa.deploy.internal.core.InternalTopology;
import com.ibm.ccl.soa.deploy.internal.core.TopologyRelationshipAdapter;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.InternalInstanceConfiguration;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.InternalScopeService;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Topology</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.TopologyImpl#getUnitGroup <em>Unit Group</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.TopologyImpl#getUnits <em>Units</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.TopologyImpl#getUnitLinksGroup <em>Unit Links Group</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.TopologyImpl#getUnitLinks <em>Unit Links</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.TopologyImpl#getConstraintLinks <em>Constraint Links</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.TopologyImpl#getDependencyLinkGroup <em>Dependency Link Group</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.TopologyImpl#getDependencyLinks <em>Dependency Links</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.TopologyImpl#getRealizationLinks <em>Realization Links</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.TopologyImpl#getImports <em>Imports</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.TopologyImpl#getConfigurationContractGroup <em>Configuration Contract Group</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.TopologyImpl#getConfigurationContract <em>Configuration Contract</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.TopologyImpl#getDecoratorSemantic <em>Decorator Semantic</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.TopologyImpl#getNamespace <em>Namespace</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated NOT
 * @extends InternalTopology
 */
public class TopologyImpl extends DeployModelObjectImpl implements Topology, InternalTopology {
	private static final String EMPTY_STRING = ""; //$NON-NLS-1$

	private static final class TopologyListenerSafeRunnable extends DeployCoreSafeRunnable {
		private final Adapter listener;
		private final Notification notification;
		private boolean didFail = false;

		private TopologyListenerSafeRunnable(Adapter aListener, Notification aNotification) {
			listener = aListener;
			notification = aNotification;
		}

		@Override
		public void run() throws Exception {
			listener.notifyChanged(notification);
		}

		@Override
		public void handleException(Throwable exception) {
			logException("Topology listener failed handling event.  Removing from list.", exception); //$NON-NLS-1$
			didFail = true;
		}

		boolean didFail() {
			return didFail;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getUnitGroup() <em>Unit Group</em>}' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUnitGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap unitGroup;

	/**
	 * The cached value of the '{@link #getUnitLinksGroup() <em>Unit Links Group</em>}' attribute
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getUnitLinksGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap unitLinksGroup;

	/**
	 * The cached value of the '{@link #getConstraintLinks() <em>Constraint Links</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getConstraintLinks()
	 * @generated
	 * @ordered
	 */
	protected EList constraintLinks;
	/**
	 * The cached value of the '{@link #getDependencyLinkGroup() <em>Dependency Link Group</em>}'
	 * attribute list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDependencyLinkGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap dependencyLinkGroup;

	/**
	 * The cached value of the '{@link #getRealizationLinks() <em>Realization Links</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getRealizationLinks()
	 * @generated
	 * @ordered
	 */
	protected EList realizationLinks;

	/**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected EList imports;

	/**
	 * The cached value of the '{@link #getConfigurationContractGroup() <em>Configuration Contract Group</em>}'
	 * attribute list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getConfigurationContractGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap configurationContractGroup;

	/**
	 * The default value of the '{@link #getDecoratorSemantic() <em>Decorator Semantic</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDecoratorSemantic()
	 * @generated
	 * @ordered
	 */
	protected static final String DECORATOR_SEMANTIC_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDecoratorSemantic() <em>Decorator Semantic</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDecoratorSemantic()
	 * @generated
	 * @ordered
	 */
	protected String decoratorSemantic = DECORATOR_SEMANTIC_EDEFAULT;

	/**
	 * The default value of the '{@link #isMutabilityConfigurable() <em>Mutability Configurable</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isMutabilityConfigurable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MUTABILITY_CONFIGURABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMutabilityConfigurable() <em>Mutability Configurable</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isMutabilityConfigurable()
	 * @generated
	 * @ordered
	 */
	protected boolean mutabilityConfigurable = MUTABILITY_CONFIGURABLE_EDEFAULT;

	/**
	 * This is true if the Mutability Configurable attribute has been set. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean mutabilityConfigurableESet;

	/**
	 * The default value of the '{@link #getNamespace() <em>Namespace</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNamespace()
	 * @generated
	 * @ordered
	 */
	protected static final String NAMESPACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNamespace() <em>Namespace</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getNamespace()
	 * @generated
	 * @ordered
	 */
	protected String namespace = NAMESPACE_EDEFAULT;

	/*
	 * <doc-ku> a slight of hand with the featuremap makes for some delectable code </doc-ku>
	 */
	private List units;

	private List unitLinkList;

	private List hostingLinkList;

	private List memberLinkList;

	private List dependencyLinkList;

	private IRelationshipChecker relationships;

	/*
	 * A Map to cache registered topology wide listeners.
	 */
	private Map<Object, BasicEList<Adapter>> topologyListenersMap;

	/**
	 * An empty array of units.
	 */
	private static final Unit[] EMPTY_UNIT_ARRAY = new Unit[0];

	/**
	 * An empty array of requirements.
	 */
	private static final Requirement[] EMPTY_REQUIREMENT_ARRAY = new Requirement[0];

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected TopologyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.TOPOLOGY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FeatureMap getUnitGroup() {
		if (unitGroup == null) {
			unitGroup = new BasicFeatureMap(this, CorePackage.TOPOLOGY__UNIT_GROUP);
		}
		return unitGroup;
	}

	/**
	 * @see com.ibm.ccl.soa.deploy.core.Topology#getUnits()
	 * @generated NOT
	 */
	public List getUnits() {
		if (units == null) {
			units = new FeatureAwareList(CorePackage.eINSTANCE.getTopology_Units(),
					(FeatureMap.Internal) getUnitGroup());
		}
		return units;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public List getUnitsGen() {
		return getUnitGroup().list(CorePackage.Literals.TOPOLOGY__UNITS);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FeatureMap getUnitLinksGroup() {
		if (unitLinksGroup == null) {
			unitLinksGroup = new BasicFeatureMap(this, CorePackage.TOPOLOGY__UNIT_LINKS_GROUP);
		}
		return unitLinksGroup;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.Topology#getUnitLinks()
	 */
	public List getUnitLinks() {
		if (unitLinkList == null) {
			unitLinkList = new FeatureAwareList(CorePackage.eINSTANCE.getTopology_UnitLinks(),
					(FeatureMap.Internal) getUnitLinksGroup());
		}
		return unitLinkList;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public List getConstraintLinks() {
		if (constraintLinks == null) {
			constraintLinks = new EObjectContainmentEList(ConstraintLink.class, this,
					CorePackage.TOPOLOGY__CONSTRAINT_LINKS);
		}
		return constraintLinks;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.Topology#getHostingLinks()
	 */
	public List getHostingLinks() {
		if (hostingLinkList == null) {
			hostingLinkList = new FilterList((EList) getUnitLinks(),
					EObjectTypeFilter.HOSTING_LINK_FILTER);
		}
		return hostingLinkList;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.Topology#getMemberLinks()
	 */
	public List getMemberLinks() {
		if (memberLinkList == null) {
			memberLinkList = new FilterList((EList) getUnitLinks(),
					EObjectTypeFilter.MEMBER_LINK_FILTER);
		}
		return memberLinkList;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FeatureMap getDependencyLinkGroup() {
		if (dependencyLinkGroup == null) {
			dependencyLinkGroup = new BasicFeatureMap(this,
					CorePackage.TOPOLOGY__DEPENDENCY_LINK_GROUP);
		}
		return dependencyLinkGroup;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.Topology#getDependencyLinks()
	 */
	public List getDependencyLinks() {
		if (dependencyLinkList == null) {
			dependencyLinkList = new FeatureAwareList(CorePackage.eINSTANCE
					.getTopology_DependencyLinks(), (FeatureMap.Internal) getDependencyLinkGroup());
		}
		return dependencyLinkList;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public List getRealizationLinks() {
		if (realizationLinks == null) {
			realizationLinks = new EObjectContainmentEList(RealizationLink.class, this,
					CorePackage.TOPOLOGY__REALIZATION_LINKS);
		}
		return realizationLinks;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public List getImports() {
		if (imports == null) {
			imports = new EObjectContainmentEList(Import.class, this, CorePackage.TOPOLOGY__IMPORTS);
		}
		return imports;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FeatureMap getConfigurationContractGroup() {
		if (configurationContractGroup == null) {
			configurationContractGroup = new BasicFeatureMap(this,
					CorePackage.TOPOLOGY__CONFIGURATION_CONTRACT_GROUP);
		}
		return configurationContractGroup;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ConfigurationContract getConfigurationContract() {
		return (ConfigurationContract) getConfigurationContractGroup().get(
				CorePackage.Literals.TOPOLOGY__CONFIGURATION_CONTRACT, true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetConfigurationContract(
			ConfigurationContract newConfigurationContract, NotificationChain msgs) {
		return ((FeatureMap.Internal) getConfigurationContractGroup()).basicAdd(
				CorePackage.Literals.TOPOLOGY__CONFIGURATION_CONTRACT, newConfigurationContract, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setConfigurationContract(ConfigurationContract newConfigurationContract) {

		FeatureMap.Internal group = (FeatureMap.Internal) getConfigurationContractGroup();

		if (newConfigurationContract != null) {
			EStructuralFeature feature = FeatureAdapter.getFeature(newConfigurationContract,
					CorePackage.eINSTANCE.getTopology_ConfigurationContract());

			if (group.size() > 0) {
				group.remove(0);
			}

			group.set(feature, newConfigurationContract);
		} else {
			group.clear();
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getDecoratorSemantic() {
		return decoratorSemantic;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDecoratorSemantic(String newDecoratorSemantic) {
		String oldDecoratorSemantic = decoratorSemantic;
		decoratorSemantic = newDecoratorSemantic;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					CorePackage.TOPOLOGY__DECORATOR_SEMANTIC, oldDecoratorSemantic, decoratorSemantic));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isMutabilityConfigurable() {
		return mutabilityConfigurable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setMutabilityConfigurable(boolean newMutabilityConfigurable) {
		boolean oldMutabilityConfigurable = mutabilityConfigurable;
		mutabilityConfigurable = newMutabilityConfigurable;
		boolean oldMutabilityConfigurableESet = mutabilityConfigurableESet;
		mutabilityConfigurableESet = true;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					CorePackage.TOPOLOGY__MUTABILITY_CONFIGURABLE, oldMutabilityConfigurable,
					mutabilityConfigurable, !oldMutabilityConfigurableESet));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void unsetMutabilityConfigurable() {
		boolean oldMutabilityConfigurable = mutabilityConfigurable;
		boolean oldMutabilityConfigurableESet = mutabilityConfigurableESet;
		mutabilityConfigurable = MUTABILITY_CONFIGURABLE_EDEFAULT;
		mutabilityConfigurableESet = false;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					CorePackage.TOPOLOGY__MUTABILITY_CONFIGURABLE, oldMutabilityConfigurable,
					MUTABILITY_CONFIGURABLE_EDEFAULT, oldMutabilityConfigurableESet));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isSetMutabilityConfigurable() {
		return mutabilityConfigurableESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String getNamespace() {
		return namespace != null ? namespace : IConstants.EMPTY_STRING;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setNamespace(String newNamespace) {
		String oldNamespace = namespace;
		namespace = newNamespace;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.TOPOLOGY__NAMESPACE,
					oldNamespace, namespace));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID)
		{
		case CorePackage.TOPOLOGY__UNIT_GROUP:
			return ((InternalEList) getUnitGroup()).basicRemove(otherEnd, msgs);
		case CorePackage.TOPOLOGY__UNITS:
			return ((InternalEList) getUnits()).basicRemove(otherEnd, msgs);
		case CorePackage.TOPOLOGY__UNIT_LINKS_GROUP:
			return ((InternalEList) getUnitLinksGroup()).basicRemove(otherEnd, msgs);
		case CorePackage.TOPOLOGY__UNIT_LINKS:
			return ((InternalEList) getUnitLinks()).basicRemove(otherEnd, msgs);
		case CorePackage.TOPOLOGY__CONSTRAINT_LINKS:
			return ((InternalEList) getConstraintLinks()).basicRemove(otherEnd, msgs);
		case CorePackage.TOPOLOGY__DEPENDENCY_LINK_GROUP:
			return ((InternalEList) getDependencyLinkGroup()).basicRemove(otherEnd, msgs);
		case CorePackage.TOPOLOGY__DEPENDENCY_LINKS:
			return ((InternalEList) getDependencyLinks()).basicRemove(otherEnd, msgs);
		case CorePackage.TOPOLOGY__REALIZATION_LINKS:
			return ((InternalEList) getRealizationLinks()).basicRemove(otherEnd, msgs);
		case CorePackage.TOPOLOGY__IMPORTS:
			return ((InternalEList) getImports()).basicRemove(otherEnd, msgs);
		case CorePackage.TOPOLOGY__CONFIGURATION_CONTRACT_GROUP:
			return ((InternalEList) getConfigurationContractGroup()).basicRemove(otherEnd, msgs);
		case CorePackage.TOPOLOGY__CONFIGURATION_CONTRACT:
			return basicSetConfigurationContract(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case CorePackage.TOPOLOGY__UNIT_GROUP:
			if (coreType) {
				return getUnitGroup();
			}
			return ((FeatureMap.Internal) getUnitGroup()).getWrapper();
		case CorePackage.TOPOLOGY__UNITS:
			return getUnits();
		case CorePackage.TOPOLOGY__UNIT_LINKS_GROUP:
			if (coreType) {
				return getUnitLinksGroup();
			}
			return ((FeatureMap.Internal) getUnitLinksGroup()).getWrapper();
		case CorePackage.TOPOLOGY__UNIT_LINKS:
			return getUnitLinks();
		case CorePackage.TOPOLOGY__CONSTRAINT_LINKS:
			return getConstraintLinks();
		case CorePackage.TOPOLOGY__DEPENDENCY_LINK_GROUP:
			if (coreType) {
				return getDependencyLinkGroup();
			}
			return ((FeatureMap.Internal) getDependencyLinkGroup()).getWrapper();
		case CorePackage.TOPOLOGY__DEPENDENCY_LINKS:
			return getDependencyLinks();
		case CorePackage.TOPOLOGY__REALIZATION_LINKS:
			return getRealizationLinks();
		case CorePackage.TOPOLOGY__IMPORTS:
			return getImports();
		case CorePackage.TOPOLOGY__CONFIGURATION_CONTRACT_GROUP:
			if (coreType) {
				return getConfigurationContractGroup();
			}
			return ((FeatureMap.Internal) getConfigurationContractGroup()).getWrapper();
		case CorePackage.TOPOLOGY__CONFIGURATION_CONTRACT:
			return getConfigurationContract();
		case CorePackage.TOPOLOGY__DECORATOR_SEMANTIC:
			return getDecoratorSemantic();
		case CorePackage.TOPOLOGY__MUTABILITY_CONFIGURABLE:
			return isMutabilityConfigurable() ? Boolean.TRUE : Boolean.FALSE;
		case CorePackage.TOPOLOGY__NAMESPACE:
			return getNamespace();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
		case CorePackage.TOPOLOGY__UNIT_GROUP:
			((FeatureMap.Internal) getUnitGroup()).set(newValue);
			return;
		case CorePackage.TOPOLOGY__UNITS:
			getUnits().clear();
			getUnits().addAll((Collection) newValue);
			return;
		case CorePackage.TOPOLOGY__UNIT_LINKS_GROUP:
			((FeatureMap.Internal) getUnitLinksGroup()).set(newValue);
			return;
		case CorePackage.TOPOLOGY__UNIT_LINKS:
			getUnitLinks().clear();
			getUnitLinks().addAll((Collection) newValue);
			return;
		case CorePackage.TOPOLOGY__CONSTRAINT_LINKS:
			getConstraintLinks().clear();
			getConstraintLinks().addAll((Collection) newValue);
			return;
		case CorePackage.TOPOLOGY__DEPENDENCY_LINK_GROUP:
			((FeatureMap.Internal) getDependencyLinkGroup()).set(newValue);
			return;
		case CorePackage.TOPOLOGY__DEPENDENCY_LINKS:
			getDependencyLinks().clear();
			getDependencyLinks().addAll((Collection) newValue);
			return;
		case CorePackage.TOPOLOGY__REALIZATION_LINKS:
			getRealizationLinks().clear();
			getRealizationLinks().addAll((Collection) newValue);
			return;
		case CorePackage.TOPOLOGY__IMPORTS:
			getImports().clear();
			getImports().addAll((Collection) newValue);
			return;
		case CorePackage.TOPOLOGY__CONFIGURATION_CONTRACT_GROUP:
			((FeatureMap.Internal) getConfigurationContractGroup()).set(newValue);
			return;
		case CorePackage.TOPOLOGY__CONFIGURATION_CONTRACT:
			setConfigurationContract((ConfigurationContract) newValue);
			return;
		case CorePackage.TOPOLOGY__DECORATOR_SEMANTIC:
			setDecoratorSemantic((String) newValue);
			return;
		case CorePackage.TOPOLOGY__MUTABILITY_CONFIGURABLE:
			setMutabilityConfigurable(((Boolean) newValue).booleanValue());
			return;
		case CorePackage.TOPOLOGY__NAMESPACE:
			setNamespace((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID)
		{
		case CorePackage.TOPOLOGY__UNIT_GROUP:
			getUnitGroup().clear();
			return;
		case CorePackage.TOPOLOGY__UNITS:
			getUnits().clear();
			return;
		case CorePackage.TOPOLOGY__UNIT_LINKS_GROUP:
			getUnitLinksGroup().clear();
			return;
		case CorePackage.TOPOLOGY__UNIT_LINKS:
			getUnitLinks().clear();
			return;
		case CorePackage.TOPOLOGY__CONSTRAINT_LINKS:
			getConstraintLinks().clear();
			return;
		case CorePackage.TOPOLOGY__DEPENDENCY_LINK_GROUP:
			getDependencyLinkGroup().clear();
			return;
		case CorePackage.TOPOLOGY__DEPENDENCY_LINKS:
			getDependencyLinks().clear();
			return;
		case CorePackage.TOPOLOGY__REALIZATION_LINKS:
			getRealizationLinks().clear();
			return;
		case CorePackage.TOPOLOGY__IMPORTS:
			getImports().clear();
			return;
		case CorePackage.TOPOLOGY__CONFIGURATION_CONTRACT_GROUP:
			getConfigurationContractGroup().clear();
			return;
		case CorePackage.TOPOLOGY__CONFIGURATION_CONTRACT:
			setConfigurationContract((ConfigurationContract) null);
			return;
		case CorePackage.TOPOLOGY__DECORATOR_SEMANTIC:
			setDecoratorSemantic(DECORATOR_SEMANTIC_EDEFAULT);
			return;
		case CorePackage.TOPOLOGY__MUTABILITY_CONFIGURABLE:
			unsetMutabilityConfigurable();
			return;
		case CorePackage.TOPOLOGY__NAMESPACE:
			setNamespace(NAMESPACE_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
		case CorePackage.TOPOLOGY__UNIT_GROUP:
			return unitGroup != null && !unitGroup.isEmpty();
		case CorePackage.TOPOLOGY__UNITS:
			return !getUnits().isEmpty();
		case CorePackage.TOPOLOGY__UNIT_LINKS_GROUP:
			return unitLinksGroup != null && !unitLinksGroup.isEmpty();
		case CorePackage.TOPOLOGY__UNIT_LINKS:
			return !getUnitLinks().isEmpty();
		case CorePackage.TOPOLOGY__CONSTRAINT_LINKS:
			return constraintLinks != null && !constraintLinks.isEmpty();
		case CorePackage.TOPOLOGY__DEPENDENCY_LINK_GROUP:
			return dependencyLinkGroup != null && !dependencyLinkGroup.isEmpty();
		case CorePackage.TOPOLOGY__DEPENDENCY_LINKS:
			return !getDependencyLinks().isEmpty();
		case CorePackage.TOPOLOGY__REALIZATION_LINKS:
			return realizationLinks != null && !realizationLinks.isEmpty();
		case CorePackage.TOPOLOGY__IMPORTS:
			return imports != null && !imports.isEmpty();
		case CorePackage.TOPOLOGY__CONFIGURATION_CONTRACT_GROUP:
			return configurationContractGroup != null && !configurationContractGroup.isEmpty();
		case CorePackage.TOPOLOGY__CONFIGURATION_CONTRACT:
			return getConfigurationContract() != null;
		case CorePackage.TOPOLOGY__DECORATOR_SEMANTIC:
			return DECORATOR_SEMANTIC_EDEFAULT == null ? decoratorSemantic != null
					: !DECORATOR_SEMANTIC_EDEFAULT.equals(decoratorSemantic);
		case CorePackage.TOPOLOGY__MUTABILITY_CONFIGURABLE:
			return isSetMutabilityConfigurable();
		case CorePackage.TOPOLOGY__NAMESPACE:
			return NAMESPACE_EDEFAULT == null ? namespace != null : !NAMESPACE_EDEFAULT
					.equals(namespace);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (unitGroup: "); //$NON-NLS-1$
		result.append(unitGroup);
		result.append(", unitLinksGroup: "); //$NON-NLS-1$
		result.append(unitLinksGroup);
		result.append(", dependencyLinkGroup: "); //$NON-NLS-1$
		result.append(dependencyLinkGroup);
		result.append(", configurationContractGroup: "); //$NON-NLS-1$
		result.append(configurationContractGroup);
		result.append(", decoratorSemantic: "); //$NON-NLS-1$
		result.append(decoratorSemantic);
		result.append(", mutabilityConfigurable: "); //$NON-NLS-1$
		if (mutabilityConfigurableESet) {
			result.append(mutabilityConfigurable);
		} else {
			result.append("<unset>"); //$NON-NLS-1$
		}
		result.append(", namespace: "); //$NON-NLS-1$
		result.append(namespace);
		result.append(')');
		return result.toString();
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.Topology#getAllDeployModelObjects()
	 */
	public Iterator findAllDeployModelObjects() {
		return new AllImportedTopologyValueIterator(this) {
			public Iterator getTopologyValues(Topology top) {
				return new FilterIterator(top.eAllContents(),
						DeployModelObjectImpl.DEPLOY_MODEL_OBJECT_FILTER);
			}
		};
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.Topology#getAllUnits()
	 */
	public Iterator findAllUnits() {
		return new AllImportedTopologyValueIterator(this) {
			public Iterator getTopologyValues(Topology top) {
				return top.getUnits().iterator();
			}
		};
	}

	public Iterator findAllPublicUnits() {
		return getListOfPublicUnits().iterator();
	}

	/**
	 * Returns a List of {@link Unit} instances in the topology as well as publicly imported ones.
	 * 
	 * @return Iterator<Unit>
	 * @generated NOT
	 * @see #findAllUnits()
	 */
	private List<Unit> getListOfPublicUnits() {
		List<Unit> retVal = new LinkedList<Unit>(getUnits());

		// Get the Imports.  We are only interested in units made public by direct imports.
		// DON'T call TopologyUtil.getAllImportedTopologies(), because it will return topologies
		// that aren't themselves vidible.
		for (Iterator it = getImports().iterator(); it.hasNext();) {
			Import imp = (Import) it.next();
			if (imp.getInstanceConfiguration() != null) {
				retVal.addAll(imp.getInstanceConfiguration().getPublicUnits());
			}
		}

		return retVal;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.Topology#getAllProvidedServices()
	 */
	public Iterator findAllNonHostingCapabilities() {
		return new AllImportedTopologyValueIterator(this) {
			public Iterator getTopologyValues(Topology top) {
				return new FilterIterator(new TopologyFilterIterator(top,
						TopologyFilterIterator.CAPABILITY), CapabilityLinkTypeFilter.DEPENDENCY_FILTER);
			}
		};
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.Topology#findAllCapabilities()
	 */
	public Iterator findAllCapabilities() {
		return new AllImportedTopologyValueIterator(this) {
			public Iterator getTopologyValues(Topology top) {
				return new TopologyFilterIterator(top, TopologyFilterIterator.CAPABILITY);
			}
		};
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.Topology#getAllProvidedHostingServices()
	 */
	public Iterator findAllHostingCapabilities() {
		return new FilterIterator(findAllCapabilities(),
				CapabilityLinkTypeFilter.ANY_OR_HOSTING_FILTER);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.Topology#getAllServiceLinks()
	 */
	public Iterator findAllDependencyLinks() {
		return new AllImportedTopologyValueIterator(this) {
			public Iterator getTopologyValues(Topology top) {
				return new TopologyFilterIterator(top, TopologyFilterIterator.DEPENDENCY_LINK);
			}
		};
	}

	/**
	 * Filters {@link Unit#isConfigurationUnit()} = true.
	 */
	public static final IObjectFilter CONFIGURATION_UNIT_FILTER = new IObjectFilter() {
		public boolean accept(Object value) {
			return value instanceof Unit && ((Unit) value).isConfigurationUnit();
		}
	};

	public Iterator findAllConfigurationUnits() {
		return new FilterIterator(findAllUnits(), CONFIGURATION_UNIT_FILTER);
	}

	public Iterator findAllRequirements() {
		return new AllImportedTopologyValueIterator(this) {
			public Iterator getTopologyValues(Topology top) {
				return new TopologyFilterIterator(top, TopologyFilterIterator.REQUIREMENT);
			}
		};
	}

	public Iterator findAllRequirementExpressions() {
		return new AllImportedTopologyValueIterator(this) {
			public Iterator getTopologyValues(Topology top) {
				return new TopologyFilterIterator(top, TopologyFilterIterator.REQUIREMENT_EXPRESSION);
			}
		};
	}

	public Iterator findAllHostingRequirements() {
		return new FilterIterator(findAllRequirements(),
				RequirementLinkTypeFilter.ANY_OR_HOSTING_FILTER);
	}

	public Iterator findAllNonHostingRequirements() {
		return new FilterIterator(findAllRequirements(), RequirementLinkTypeFilter.DEPENDENCY_FILTER);
	}

	public Iterator findAllDeployLinks() {
		return new AllImportedTopologyValueIterator(this) {
			public Iterator getTopologyValues(Topology top) {
				return new TopologyFilterIterator(top, TopologyFilterIterator.DEPLOY_LINK);
			}
		};
	}

	public Iterator findAllConstraintLinks() {
		return new AllImportedTopologyValueIterator(this) {
			public Iterator getTopologyValues(Topology top) {
				return new TopologyFilterIterator(top, TopologyFilterIterator.CONSTRAINT_LINK);
			}
		};
	}

	public Iterator findAllUnitLinks() {
		return new AllImportedTopologyValueIterator(this) {
			public Iterator getTopologyValues(Topology top) {
				return new TopologyFilterIterator(top, TopologyFilterIterator.UNIT_LINK);
			}
		};
	}

	public Iterator findAllHostingLinks() {
		return new FilterIterator(findAllUnitLinks(), EObjectTypeFilter.HOSTING_LINK_FILTER);
	}

	public Iterator findAllMemberLinks() {
		return new FilterIterator(findAllUnitLinks(), EObjectTypeFilter.MEMBER_LINK_FILTER);
	}

	public Iterator findAllRealizationLinks() {
		return new AllImportedTopologyValueIterator(this) {
			public Iterator getTopologyValues(Topology top) {
				return new TopologyFilterIterator(top, TopologyFilterIterator.REALIZATION_LINK);
			}
		};
	}

	public Iterator findAllArtifacts() {
		return new SecondOrderIterator(findAllUnits()) {
			public Iterator getValues(Object object) {
				return ((Unit) object).getArtifacts().iterator();
			}
		};
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.Topology#findLocalDeployModelObjects()
	 */
	public Iterator findLocalDeployModelObjects() {
		return new FilterIterator(eAllContents(), DeployModelObjectImpl.DEPLOY_MODEL_OBJECT_FILTER);
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.Topology#findHosts(com.ibm.ccl.soa.deploy.core.Unit)
	 */
	public Unit[] findHosts(Unit unit) {
		if (unit == null) {
			return EMPTY_UNIT_ARRAY;
		}

		// TODO consider keeping the arrays, or deprecating the array method and encouraging use of List version.
		Collection<Unit> h = getRelationships().getHost(unit);
		return h == null ? EMPTY_UNIT_ARRAY : h.toArray(new Unit[0]);

//		if (host != null) {
//			return new Unit[] { host };
//		}
//		return EMPTY_UNIT_ARRAY;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.Topology#findMemberOf(com.ibm.ccl.soa.deploy.core.Unit)
	 */
	public Unit[] findMemberOf(Unit member) {
		if (member == null) {
			return EMPTY_UNIT_ARRAY;
		}

		// TODO consider keeping the arrays, or deprecating the array method and encouraging use of List version.
		Collection<Unit> h = getRelationships().getContainer(member);
		return h == null ? EMPTY_UNIT_ARRAY : h.toArray(new Unit[0]);

//		Unit group = null;
//		List groupList = null;
//		for (Iterator it = findAllMemberLinks(); it.hasNext();) {
//			MemberLink candidate = (MemberLink) it.next();
//			if (member.equals(candidate.getTarget()) && candidate.getSource() != null) {
//				if (groupList != null) {
//					groupList.add(candidate.getSource());
//				} else if (group == null) {
//					group = candidate.getSource();
//				} else {
//					groupList = new LinkedList();
//					groupList.add(group);
//					groupList.add(candidate.getSource());
//				}
//			}
//		}
//
//		if (groupList != null) {
//			return (Unit[]) groupList.toArray(new Unit[groupList.size()]);
//		}
//		if (group != null) {
//			return new Unit[] { group };
//		}
//		return EMPTY_UNIT_ARRAY;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.Topology#findDependentRequirements(com.ibm.ccl.soa.deploy.core.Capability)
	 */
	public Requirement[] findDependentRequirements(Capability cap) {
		if (cap == null) {
			return EMPTY_REQUIREMENT_ARRAY;
		}

		// TODO consider keeping the arrays, or deprecating the array method and encouraging use of List version.
		Collection<Requirement> h = getRelationships().getDependentRequirements(cap);
		return h == null ? EMPTY_REQUIREMENT_ARRAY : h.toArray(new Requirement[0]);

//		Requirement req = null;
//		LinkedList reqList = null;
//		for (Iterator iter = findAllDependencyLinks(); iter.hasNext();) {
//			DependencyLink link = (DependencyLink) iter.next();
//			if (cap.equals(link.getTarget()) && link.getSource() != null) {
//				if (req == null) {
//					req = link.getSource();
//				} else {
//					if (reqList == null) {
//						reqList = new LinkedList();
//						reqList.add(req);
//					}
//					reqList.add(link.getSource());
//				}
//			}
//		}
//		if (reqList != null) {
//			return (Requirement[]) reqList.toArray(new Requirement[reqList.size()]);
//		}
//		if (req != null) {
//			return new Requirement[] { req };
//		}
//		return EMPTY_REQUIREMENT_ARRAY;
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.impl.DeployModelObjectImpl#getTopology()
	 */
	public Topology getTopology() {
		return this;
	}

	public DependencyLink getDependencyLink(String sourcePath) {
		List dependencyLinks = getDependencyLinks();
		for (Iterator iterator = dependencyLinks.iterator(); iterator.hasNext();) {
			DependencyLink link = (DependencyLink) iterator.next();
			if (sourcePath.equals(link.getSourceURI())) {
				return link;
			}
		}
		return null;
	}

	/**
	 * @see com.ibm.ccl.soa.deploy.core.Topology#getImport(java.lang.String, java.lang.String)
	 * 
	 * @generated NOT
	 */
	public Import getImport(String namespace, String pattern) {
		if (namespace == null) {
			namespace = INamespaceElement.DEFAULT_NAMESPACE;
		}
		for (Iterator iter = getImports().iterator(); iter.hasNext();) {
			Import i = (Import) iter.next();
			if (pattern == null && i.getPattern() == null || pattern != null
					&& pattern.equals(i.getPattern())) {
				if (namespace.equals(i.getNamespace())
						|| namespace.equals(INamespaceElement.DEFAULT_NAMESPACE)
						&& (i.getNamespace() == null || i.getNamespace().equals(
								INamespaceElement.DEFAULT_NAMESPACE))) {
					return i;
				}
			}
		}
		return null;
	}

	/**
	 * @see com.ibm.ccl.soa.deploy.core.Topology#getImport(java.lang.String)
	 * 
	 * @generated NOT
	 */
	public Import getImport(String fullyQualifiedName) {

		String namespace = INamespaceElement.DEFAULT_NAMESPACE;
		String pattern = null;
		int separatorIndex = -1;

		String trimmed = fullyQualifiedName;
		if ((separatorIndex = fullyQualifiedName.indexOf(IConstants.TOPOLOGY_SEPARATOR)) > -1) {
			trimmed = fullyQualifiedName.substring(0, separatorIndex);
		}
		separatorIndex = trimmed.lastIndexOf(IConstants.DOT_SEPARATOR);

		if (separatorIndex > -1) {
			namespace = trimmed.substring(0, separatorIndex);
			assert trimmed.length() > separatorIndex;
			pattern = trimmed.substring(separatorIndex + 1, trimmed.length());
		} else {
			pattern = trimmed; // doesn't contain any dots, just the Topology name
		}
		return getImport(namespace, pattern);

	}

	public List<Import> findRelatedImport(InternalScopeService scopeService, String fullPath,
			List<String> visited) {
		List<Import> related = new ArrayList<Import>();
		if (fullPath == null || fullPath.trim().length() == 0) {
			return null;
		}
		ConfigurationContract contract = getConfigurationContract();
		Import imported = getImport(fullPath);
		if (imported != null) {
			if (contract == null || contract.isPublic(imported)) {
				return Collections.singletonList(imported);
			} else {
				return Collections.emptyList();
			}
		}

		List<Import> searchRelated = new ArrayList<Import>(3);
		for (Iterator<Import> importIter = getImports().iterator(); importIter.hasNext();) {
			Import searchImport = importIter.next();
			if (!visited.contains(searchImport.getQualifiedImport())) {
				visited.add(searchImport.getQualifiedImport());
				InternalTopology searchTopology = (InternalTopology) scopeService.resolve(searchImport);
				if (searchTopology != null) {
					searchRelated = searchTopology.findRelatedImport(scopeService, fullPath, visited);
					if (searchRelated.size() > 0) {
						related.add(searchImport);
						related.addAll(searchRelated);
						return related;
					}
				}
			}
		}
		return Collections.emptyList();
	}

	public List<Unit> getVisibleUnits(InternalScopeService scopeService, Import importedSource,
			List<String> visited) {
		List<Unit> visibleUnits = new ArrayList<Unit>();
		ConfigurationContract contract = getConfigurationContract();
		if (contract != null) {
			for (Iterator<Unit> iter = contract.getVisibleUnits().iterator(); iter.hasNext();) {
				Unit unit = iter.next();
				Unit proxy = (Unit) scopeService.getCacheService().findProxy(unit, importedSource);
				if (proxy != null) {
					visibleUnits.add(proxy);
				}
			}
			for (Iterator<Import> importIter = getImports().iterator(); importIter.hasNext();) {
				Import searchImport = importIter.next();
				if (!visited.contains(searchImport.getQualifiedImport())
						&& contract.isPublic(searchImport)) {
					visited.add(searchImport.getQualifiedImport());
					InstanceConfiguration config = searchImport.getInstanceConfiguration();
					if (config instanceof InternalInstanceConfiguration) {
						// returned units are already proxified
						visibleUnits.addAll(((InternalInstanceConfiguration) config).getVisibleUnits(
								scopeService, importedSource, visited));
					}
				}
			}
		}
		return Collections.unmodifiableList(visibleUnits);
	}

	public String getQualifiedName() {
		return (namespace != null && namespace.length() > 0 ? namespace + '.' : EMPTY_STRING)
				+ (name != null ? name : EMPTY_STRING);

	}

	/**
	 * @see com.ibm.ccl.soa.deploy.core.Topology#getRelationships()
	 */
	public IRelationshipChecker getRelationships() {
		if (relationships == null) {
			synchronized (this) {
				if (relationships == null) {
					relationships = createRelationships();
				}
			}
		}
		return relationships;
	}

	private IRelationshipChecker createRelationships() {
		TopologyRelationshipAdapter retVal = new TopologyRelationshipAdapter(this);
		eAdapters().add(retVal);
		return retVal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.Topology#addTopologyListener(org.eclipse.emf.common.notify.Adapter,
	 *      java.lang.Object)
	 */
	public void addTopologyListener(Adapter listener, Object feature) {
		if (listener != null && feature != null) {
			List<Adapter> listeners = getTopologyListeners(feature, true);
			if (!listeners.contains(listener)) {
				listeners.add(listener);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.Topology#removeTopologyListener(org.eclipse.emf.common.notify.Adapter,
	 *      java.lang.Object)
	 */
	public void removeTopologyListener(final Adapter listener, Object feature) {
		if (listener != null && feature != null) {
			final List<Adapter> listeners = getTopologyListeners(feature, false);
			if (listeners != null) {
				ISafeRunnable runnable = new DeployCoreSafeRunnable() {
					@Override
					public void run() throws Exception {
						listeners.remove(listener);
					}
				};
				SafeRunner.run(runnable);
				if (listeners.isEmpty()) {
					topologyListenersMap.remove(feature);
				}
			}
		}
	}

	/*
	 * Return the list of adapters if one exists. If shouldCreate is true then an adapter list will
	 * be created and registered if one is not found.
	 */
	private BasicEList<Adapter> getTopologyListeners(Object feature, boolean shouldCreate) {
		if (feature == null) {
			return null;
		}
		if (topologyListenersMap == null) {
			if (shouldCreate) {
				topologyListenersMap = new HashMap<Object, BasicEList<Adapter>>();
			} else {
				return null;
			}
		}
		BasicEList<Adapter> listeners = topologyListenersMap.get(feature);
		if (listeners == null && shouldCreate) {
			listeners = new EAdapterList<Adapter>(this);
			topologyListenersMap.put(feature, listeners);
		}
		return listeners;
	}

	/**
	 * This is an internal method called by the
	 * CoreResourceImpl$CoreResourceModificationTrackingAdapter. This method should not be called by
	 * clients.
	 * 
	 * @param notification
	 *           The {@link Notification} that needs to be delegated.
	 */
	public void notifyTopologyListeners(Notification notification) {
		notifyTopologyListeners(notification, notification.getFeature());
		//Notify wildcard listeners
		notifyTopologyListeners(notification, WILDCARD_LISTENER);
	}

	public void notifyTopologyListeners(Notification notification, Object feature) {
		BasicEList<Adapter> listeners = getTopologyListeners(feature, false);
		if (listeners != null) {
			int size = listeners.size();
			if (size > 0) {
				List<Adapter> badListeners = null;
				Adapter[] adapters = (Adapter[]) listeners.data();
				for (int i = 0; i < size; ++i) {
					//TODO Switch to use SafeRunner.
					TopologyListenerSafeRunnable runnable = new TopologyListenerSafeRunnable(
							adapters[i], notification);
					SafeRunner.run(runnable);
					if (runnable.didFail()) {
						//Queue up problem listeners to be removed.
						if (badListeners == null) {
							badListeners = new ArrayList<Adapter>();
						}
						badListeners.add(adapters[i]);
					}
				}
				if (badListeners != null) {
					for (int i = 0; i < badListeners.size(); i++) {
						removeTopologyListener(badListeners.get(i), feature);
					}
				}
			}
		}
	}

	@Override
	public void eSetProxyURI(URI uri) {
		// We are being a proxy so clear out the topologyListenersMap.
		if (topologyListenersMap != null) {
			topologyListenersMap.clear();
			topologyListenersMap = null;
		}
		super.eSetProxyURI(uri);
	}

	public List getConfigurations() {
		List<Unit> retVal = new LinkedList<Unit>();
		for (Iterator it = getUnits().iterator(); it.hasNext();) {
			Unit unit = (Unit) it.next();
			if (unit.isConfigurationUnit()) {
				retVal.add(unit);
			}
		}
		return retVal;
	}

	public List getGroups() {
		List<Unit> retVal = new LinkedList<Unit>();
		for (Iterator it = getUnits().iterator(); it.hasNext();) {
			Unit unit = (Unit) it.next();
			if (unit.isGroup()) {
				retVal.add(unit);
			}
		}
		return retVal;
	}

	public List getConceptualUnits() {
		List<Unit> retVal = new LinkedList<Unit>();
		for (Iterator it = getUnits().iterator(); it.hasNext();) {
			Unit unit = (Unit) it.next();
			if (unit.isConceptual()) {
				retVal.add(unit);
			}
		}
		return retVal;
	}
} // TopologyImpl
