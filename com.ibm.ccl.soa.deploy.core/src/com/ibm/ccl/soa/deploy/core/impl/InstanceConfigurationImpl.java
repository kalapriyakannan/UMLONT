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

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.impl.NotificationImpl;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.AbstractEMFOperation;

import com.ibm.ccl.soa.deploy.core.Augmentation;
import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployLink;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.Instantiation;
import com.ibm.ccl.soa.deploy.core.Property;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.util.UnitUtil;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.InternalTopology;
import com.ibm.ccl.soa.deploy.internal.core.extension.IScopeService;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.DynamicReassociationList;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.IProxyConfiguration;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.InternalInstanceConfiguration;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.InternalScopeService;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.MethodHandler;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.ProxyList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Instance Configuration</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.InstanceConfigurationImpl#getImported <em>Imported
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @extends InternalInstanceConfiguration
 * 
 */
public class InstanceConfigurationImpl extends DeployModelObjectImpl implements
		InstanceConfiguration, InternalInstanceConfiguration {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	private static final Set<String> unconfigurableFields = new HashSet<String>();

	static {
		unconfigurableFields.add(CorePackage.Literals.DEPLOY_MODEL_OBJECT__NAME.getName());
		unconfigurableFields.add(CorePackage.Literals.DEPLOY_MODEL_OBJECT__MUTABLE.getName());
		unconfigurableFields.add(CorePackage.Literals.DEPLOY_MODEL_OBJECT__VISIBILITY.getName());
		unconfigurableFields.add(CorePackage.Literals.DEPLOY_MODEL_OBJECT__ATTRIBUTE_META_DATA
				.getName());
		unconfigurableFields.add(CorePackage.Literals.DEPLOY_MODEL_OBJECT__STATUS.getName());
		unconfigurableFields.add(CorePackage.Literals.UNIT__CONCEPTUAL.getName());
		unconfigurableFields.add(CorePackage.Literals.UNIT__CONFIGURATION_UNIT.getName());

		unconfigurableFields.add(CorePackage.Literals.TOPOLOGY__NAMESPACE.getName());
		unconfigurableFields.add(CorePackage.Literals.TOPOLOGY__CONFIGURATION_CONTRACT.getName());
		unconfigurableFields.add(CorePackage.Literals.TOPOLOGY__CONFIGURATION_CONTRACT_GROUP
				.getName());
		unconfigurableFields.add(CorePackage.Literals.TOPOLOGY__IMPORTS.getName());

		unconfigurableFields.add(CorePackage.Literals.DEPLOY_LINK__SOURCE_URI.getName());
		unconfigurableFields.add(CorePackage.Literals.DEPLOY_LINK__TARGET_URI.getName());

		unconfigurableFields.add("parent"); //$NON-NLS-1$
		unconfigurableFields.add("topology"); //$NON-NLS-1$
		unconfigurableFields.add("fullPath"); //$NON-NLS-1$
		unconfigurableFields.add("relativePath"); //$NON-NLS-1$
		unconfigurableFields.add("source"); //$NON-NLS-1$
		unconfigurableFields.add("target"); //$NON-NLS-1$
		unconfigurableFields.add("captionProvider"); //$NON-NLS-1$
		unconfigurableFields.add("qualifiedName"); //$NON-NLS-1$

	}

	/**
	 * The cached value of the '{@link #getInstantiations() <em>Instantiations</em>}' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getInstantiations()
	 * @generated
	 * @ordered
	 */
	protected EList instantiations;

	private static final int DELAY = 200;

	private final ConfigurationListener listener = new ConfigurationListener();

	private List<Unit> units;
	private List<Property> globalProperties;

	private final Object lock = new Object();

	private InternalScopeService oldService;

	private Map<String, Instantiation> instantiationsByReferencedMap;

	private boolean staleCache = true;

	static class NotifierJob extends Job {

		public NotifierJob() {
			super("Notify clients of changes to imported Topologies"); //$NON-NLS-1$

		}

		private final ListenerList queue = new ListenerList() {
			@Override
			public synchronized Object[] getListeners() {

				Object[] objects = super.getListeners();
				clear();
				return objects;
			}
		};

		public void enqueue(AbstractEMFOperation op) {
			queue.add(op);
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {
			Object[] workItems = queue.getListeners();
			for (Object work : workItems) {
				if (work instanceof AbstractEMFOperation) {
					try {
						((AbstractEMFOperation) work).execute(new NullProgressMonitor(), null);
					} catch (ExecutionException e) {
						DeployCorePlugin.logError(0, e.getMessage(), e);
					}
				}
			}
			return Status.OK_STATUS;
		}

	};

	private static final NotifierJob notifierJob = new NotifierJob();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected InstanceConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.INSTANCE_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public List getInstantiations() {
		if (instantiations == null) {
			instantiations = new EObjectContainmentEList(Instantiation.class, this,
					CorePackage.INSTANCE_CONFIGURATION__INSTANTIATIONS);
		}
		return instantiations;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Import getImported() {
		if (eContainerFeatureID != CorePackage.INSTANCE_CONFIGURATION__IMPORTED) {
			return null;
		}
		return (Import) eContainer();
	}

	public boolean isPublicEditable(DeployModelObject source) {
		if (source != null) {
			synchronized (lock) {

				ConfigurationContract contract = getImportedContract();
				if (contract != null) {
					if (source.getTopology() == null
							|| source.getTopology().getQualifiedName().equals(
									getImported().getQualifiedImport())) {

						return contract.isPublicEditable(source);
					} else {
						// find the scope service for the local (referencing) Topology
						InternalScopeService scopeService = (InternalScopeService) IScopeService.Locator
								.findScopeService(getTopology());
						if (scopeService != null) {

							Topology topology = scopeService.resolve(getImported());
							if (topology instanceof InternalTopology) {
								String searchPath = calculateSearchPath(source);
								// should only return public imports
								List<Import> relatedImports = ((InternalTopology) topology)
										.findRelatedImport(scopeService, searchPath, new ArrayList<String>());
								if (relatedImports.size() > 0) {
									Import importedSource = relatedImports.get(relatedImports.size() - 1);
									return importedSource.getInstanceConfiguration()
											.isPublicEditable(source);
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

	private String calculateSearchPath(DeployModelObject source) {
		if (Proxy.isProxyClass(source.getClass()) || source.getTopology() == null) {
			return source.getFullPath();
		}
		return source.getTopology().getQualifiedName() + IConstants.TOPOLOGY_SEPARATOR
				+ source.getFullPath();
	}

	public boolean isVisible(DeployModelObject source) {
		if (source != null) {
			synchronized (lock) {

				ConfigurationContract contract = getImportedContract();
				if (contract != null) {
					if (source.getTopology() == null
							|| source.getTopology().getQualifiedName().equals(
									getImported().getQualifiedImport())) {

						return contract.isVisible(source);
					} else {
						// find the scope service for the local (referencing) Topology
						InternalScopeService scopeService = (InternalScopeService) IScopeService.Locator
								.findScopeService(getTopology());
						if (scopeService != null) {

							Topology topology = scopeService.resolve(getImported());
							if (topology instanceof InternalTopology) {
								String searchPath = calculateSearchPath(source);
								// should only return public imports
								List<Import> relatedImports = ((InternalTopology) topology)
										.findRelatedImport(scopeService, searchPath, new ArrayList<String>());
								if (relatedImports.size() > 0) {
									Import importedSource = relatedImports.get(relatedImports.size() - 1);
									return importedSource.getInstanceConfiguration().isVisible(source);
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

	public boolean isPublic(DeployModelObject source) {
		if (source != null) {
			synchronized (lock) {

				ConfigurationContract contract = getImportedContract();
				if (contract != null) {
					if (source.getTopology() == null
							|| source.getTopology().getQualifiedName().equals(
									getImported().getQualifiedImport())) {

						return contract.isPublic(source);
					} else {
						// find the scope service for the local (referencing) Topology
						InternalScopeService scopeService = (InternalScopeService) IScopeService.Locator
								.findScopeService(getTopology());
						if (scopeService != null) {

							Topology topology = scopeService.resolve(getImported());
							if (topology instanceof InternalTopology) {
								String searchPath = calculateSearchPath(source);
								// should only return public imports
								List<Import> relatedImports = ((InternalTopology) topology)
										.findRelatedImport(scopeService, searchPath, new ArrayList<String>());
								if (relatedImports.size() > 0) {
									Import importedSource = relatedImports.get(relatedImports.size() - 1);
									return importedSource.getInstanceConfiguration().isPublic(source);
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

	public void configure(DeployModelObject source, String field, Object value) {
		if (field == null || field.length() == 0) {
			DeployCorePlugin.logError(0, "Persistence of the " + field + " field for " //$NON-NLS-1$ //$NON-NLS-2$
					+ source.getFullPath() + " is not yet supported.", null); //$NON-NLS-1$
		} else {
			field = formatFieldName(field);
		}

		String oldValue = null;
		String newValue = null;
		EDataType extendedType = MethodHandler.getType(source, field);

		Object oldObjectValue = getConfiguredValue(source, field);
		if (oldObjectValue == null) {
			// fetch the unconfigured value
			oldObjectValue = MethodHandler.getValue(source, field);
		}
		oldValue = EcoreUtil.convertToString(extendedType, oldObjectValue);
		newValue = EcoreUtil.convertToString(extendedType, value);

		if (oldValue == null || !oldValue.equals(newValue)) {
			Instantiation instantiation = createInstantiation(source);
			Property foundProperty = instantiation.getProperty(field);
			if (foundProperty == null) {
				foundProperty = CoreFactory.eINSTANCE.createProperty();
				foundProperty.setSelect(field);
				instantiation.getConfiguredProperties().add(foundProperty);
			}
			foundProperty.setValue(newValue);
		}
	}

	public void deconfigure(DeployModelObject source, String field) {
		if (field == null || field.length() == 0) {
			DeployCorePlugin.logError(0, "Persistence of the " + field + " field for " //$NON-NLS-1$  //$NON-NLS-2$
					+ source.getFullPath() + " is not yet supported.", null); //$NON-NLS-1$
		} else {
			field = formatFieldName(field);
		}

		Object oldObjectValue = getConfiguredValue(source, field);
		if (oldObjectValue != null) {
			Instantiation instantiation = createInstantiation(source);
			Property foundProperty = null;
			for (Iterator iterator = instantiation.getConfiguredProperties().iterator(); iterator
					.hasNext()
					&& foundProperty == null;) {
				Property property = (Property) iterator.next();
				if (field.equals(property.getSelect())) {
					iterator.remove();
					break;
				}
			}
		}
	}

	/**
	 * Returns either the sewn together list of non-editable
	 */
	public Object getConfiguredValue(DeployModelObject source, String field) {

		field = formatFieldName(field);

		if (unconfigurableFields.contains(field) || source instanceof DeployLink
				|| source instanceof Import) {
			return null;
		}

		Object configuredValue = lookupConfiguredValue(source, field);

		if (configuredValue != null) {
			return configuredValue;
		}

		if (!isLocalImport(source.getTopology())) {

			InternalScopeService scopeService = (InternalScopeService) IScopeService.Locator
					.findScopeService(getTopology());
			if (scopeService != null) {
				// no value for this property, delegate
				Topology importedTopology = scopeService.resolve(getImported());

				if (importedTopology != null) {

					String searchPath = calculateSearchPath(source);
					List<Import> importTree = ((InternalTopology) importedTopology).findRelatedImport(
							scopeService, searchPath, new ArrayList<String>());
					for (Iterator<Import> iterator = importTree.iterator(); iterator.hasNext();) {
						Import imported = iterator.next();
						configuredValue = ((InternalInstanceConfiguration) imported
								.getInstanceConfiguration()).lookupConfiguredValue(source, field);
						if (configuredValue != null) {
							return configuredValue;
						}
					}
				}
			}
		}

		return null;
	}

	private boolean isLocalImport(Topology container) {
		return container != null && getImported() != null && container.getQualifiedName() != null
				&& container.getQualifiedName().equals(getImported().getQualifiedImport());
	}

	public Object lookupConfiguredValue(DeployModelObject source, String field) {
		if (field == null) {
			DeployCorePlugin.logError(0, "Retrieval of the " + field + " field for " //$NON-NLS-1$   //$NON-NLS-2$
					+ source.getFullPath() + " is not yet supported.", null); //$NON-NLS-1$
			return null;
		}

		field = formatFieldName(field);

		EStructuralFeature feature = source.eClass().getEStructuralFeature(field);
		if (feature != null && feature.isMany()) {
			InternalScopeService scopeService = (InternalScopeService) IScopeService.Locator
					.findScopeService(getTopology());
			if (scopeService != null) {
				List readonly = (List) source.getEObject().eGet(feature);
				List proxified = new ProxyList(scopeService.getCacheService(), getImported(), readonly);
				return new DynamicReassociationList(this, source, feature, proxified);
			}
			// no value for this property
		} else {

			Instantiation instantiation = getInstantiation(source.getFullPath());

			if (instantiation != null) {
				EDataType extendedType = MethodHandler.getType(source, field);

				if (extendedType != null) {

					Property property = instantiation.getProperty(field);

					if (property != null) {
						String value = property.getValue();
						return EcoreUtil.createFromString(extendedType, value);
					}
					// no value for this property
				}
			}
		}
		return null;
	}

	private String formatFieldName(String field) {
		if (Character.isUpperCase(field.charAt(0))) {
			StringBuffer converted = new StringBuffer();
			converted.append(Character.toLowerCase(field.charAt(0))).append(field.substring(1))
					.toString();
			field = converted.toString();
		}
		return field;
	}

	public boolean isPublicEditable(DeployModelObject source, String propertyName) {
		if (source != null) {
			synchronized (lock) {

				ConfigurationContract contract = getImportedContract();
				if (contract != null) {
					if (source.getTopology() == null
							|| source.getTopology().getQualifiedName().equals(
									getImported().getQualifiedImport())) {

						return contract.isPublicEditable(source, propertyName);
					} else {
						// find the scope service for the local (referencing) Topology
						InternalScopeService scopeService = (InternalScopeService) IScopeService.Locator
								.findScopeService(getTopology());
						if (scopeService != null) {

							Topology topology = scopeService.resolve(getImported());
							if (topology instanceof InternalTopology) {
								String searchPath = calculateSearchPath(source);
								// should only return public imports
								List<Import> relatedImports = ((InternalTopology) topology)
										.findRelatedImport(scopeService, searchPath, new ArrayList<String>());
								if (relatedImports.size() > 0) {
									Import importedSource = relatedImports.get(relatedImports.size() - 1);
									return importedSource.getInstanceConfiguration().isPublicEditable(
											source, propertyName);
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

	public List getPublicEditableUnits() {
		return getVisibleUnits();
	}

	public List<Unit> getPublicUnits() {
		return getVisibleUnits();
	}

	public List getVisibleUnits() {
		InternalScopeService scopeService = (InternalScopeService) IScopeService.Locator
				.findScopeService(getTopology());
		return getVisibleUnits(scopeService, getImported(), new ArrayList<String>());
	}

	public List getVisibleUnits(InternalScopeService scopeService, Import importedSource,
			List<String> visited) {
		synchronized (lock) {
			if (units == null) {
				List<Unit> proxies = internalGetVisibleUnits(scopeService, importedSource, visited);
				units = Collections.unmodifiableList(proxies);
			}
		}
		return units;
	}

	private List<Unit> internalGetVisibleUnits(InternalScopeService scopeService,
			Import importedSource, List<String> visited) {
		List<Unit> proxies = new ArrayList<Unit>();
		// find the scope service for the local (referencing) Topology 
		if (scopeService != null) {
			// find the scope service for the local (referencing) Topology 
			Import imported = getImported();
			Topology importedTopology = scopeService.resolve(imported);
			if (importedTopology instanceof InternalTopology) {
				proxies = ((InternalTopology) importedTopology).getVisibleUnits(scopeService,
						importedSource, visited);
			}
		}
		return proxies;
	}

	public EList buildConfiguredList(InternalScopeService scopeService, Import importedSource,
			IProxyConfiguration config, EStructuralFeature feature, EList originalContents) {

		BasicEList configuredList = new BasicEList();

		configuredList.addAll(originalContents);
		// find the scope service for the local (referencing) Topology 
		if (scopeService != null) {
			List<Import> imports = Collections.emptyList();
			// find the scope service for the local (referencing) Topology 
			Import imported = getImported();
			Topology importedTopology = scopeService.resolve(imported);
			ConfigurationContract contract = getImportedContract(scopeService);
			if (contract != null && importedTopology instanceof InternalTopology) {
				imports = ((InternalTopology) importedTopology).findRelatedImport(scopeService, config
						.getFullyQualifiedPath(), new ArrayList<String>());
			}

			Import searchImport = null;
			InstanceConfiguration editConfig = null;
			Instantiation instantiation = null;
			Augmentation augmentation = null;
			for (Iterator<Import> iterator = imports.iterator(); iterator.hasNext();) {
				searchImport = iterator.next();
				if ((editConfig = searchImport.getInstanceConfiguration()) != null) {
					if ((instantiation = editConfig.getInstantiation(config.getSource().getFullPath())) != null) {
						if ((augmentation = instantiation.getAugmentation(feature.getName())) != null) {
							configuredList.addAll(augmentation.getAdditions().list(feature));
						}
					}
				}

			}
		}

		return configuredList;

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID)
		{
		case CorePackage.INSTANCE_CONFIGURATION__IMPORTED:
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			return basicSetImported((Import) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
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
		case CorePackage.INSTANCE_CONFIGURATION__INSTANTIATIONS:
			return ((InternalEList) getInstantiations()).basicRemove(otherEnd, msgs);
		case CorePackage.INSTANCE_CONFIGURATION__IMPORTED:
			return basicSetImported(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID)
		{
		case CorePackage.INSTANCE_CONFIGURATION__IMPORTED:
			return eInternalContainer().eInverseRemove(this,
					CorePackage.IMPORT__INSTANCE_CONFIGURATION, Import.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case CorePackage.INSTANCE_CONFIGURATION__INSTANTIATIONS:
			return getInstantiations();
		case CorePackage.INSTANCE_CONFIGURATION__IMPORTED:
			return getImported();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	@Override
	public Object eOpenGet(EStructuralFeature feature, boolean resolve) {

		int featureID = eDerivedStructuralFeatureID(feature);
		switch (featureID)
		{
		case CorePackage.INSTANCE_CONFIGURATION__PUBLIC_UNITS:
		case CorePackage.INSTANCE_CONFIGURATION__PUBLIC_EDITABLE_UNITS:
			return getVisibleUnits();
		}
		return super.eOpenGet(feature, resolve);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
		case CorePackage.INSTANCE_CONFIGURATION__INSTANTIATIONS:
			getInstantiations().clear();
			getInstantiations().addAll((Collection) newValue);
			return;
		case CorePackage.INSTANCE_CONFIGURATION__IMPORTED:
			setImported((Import) newValue);
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
		case CorePackage.INSTANCE_CONFIGURATION__INSTANTIATIONS:
			getInstantiations().clear();
			return;
		case CorePackage.INSTANCE_CONFIGURATION__IMPORTED:
			setImported((Import) null);
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
		case CorePackage.INSTANCE_CONFIGURATION__INSTANTIATIONS:
			return instantiations != null && !instantiations.isEmpty();
		case CorePackage.INSTANCE_CONFIGURATION__IMPORTED:
			return getImported() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public NotificationChain basicSetImported(Import newImported, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newImported,
				CorePackage.INSTANCE_CONFIGURATION__IMPORTED, msgs);
		updateScopeService();
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setImported(Import newImported) {
		if (newImported != eInternalContainer()
				|| eContainerFeatureID != CorePackage.INSTANCE_CONFIGURATION__IMPORTED
				&& newImported != null) {
			if (EcoreUtil.isAncestor(this, newImported)) {
				throw new IllegalArgumentException("Recursive containment not allowed for " //$NON-NLS-1$ 
						+ toString());
			}
			NotificationChain msgs = null;
			if (eInternalContainer() != null) {
				msgs = eBasicRemoveFromContainer(msgs);
			}
			if (newImported != null) {
				msgs = ((InternalEObject) newImported).eInverseAdd(this,
						CorePackage.IMPORT__INSTANCE_CONFIGURATION, Import.class, msgs);
			}
			msgs = basicSetImported(newImported, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					CorePackage.INSTANCE_CONFIGURATION__IMPORTED, newImported, newImported));
		}
	}

	protected class ConfigurationListener implements InternalScopeService.Listener {

		public void onReload(String namespace, String pattern) {
			Import imported = getImported();
			if (imported != null && imported.equals(namespace, pattern)) {

				if (hasChanged(units, globalProperties)) {

					final List<Unit> oldUnits = units;
					final List<Property> oldProperties = globalProperties;
					synchronized (lock) {
						units = null;
						globalProperties = null;

						staleCache = true;

						if (instantiationsByReferencedMap != null) {
							instantiationsByReferencedMap.clear();
						}
					}

					TransactionalEditingDomain editingDomain = TransactionUtil
							.getEditingDomain(InstanceConfigurationImpl.this);
					if (editingDomain != null) {
						// this operation simply notifies of the resource change; 
						// it cannot be undone and therefore its label will not show in the UI.
						AbstractEMFOperation update = new AbstractEMFOperation(
								editingDomain,
								DeployCoreMessages.InstanceConfigurationImpl_Reloading_imported_resource_from_di_) {

							@Override
							public boolean canUndo() {
								return false;
							}

							@Override
							public boolean canRedo() {
								return false;
							}

							@Override
							protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info)
									throws ExecutionException {

								// should not be called in sync block; will re-initialize units field
								eNotify(new NotificationImpl(Notification.SET, oldUnits, getPublicUnits()) {

									public Object getNotifier() {
										return InstanceConfigurationImpl.this;
									}

									@Override
									public Object getFeature() {
										return CorePackage.eINSTANCE.getInstanceConfiguration_PublicUnits();
									}
								});

								// should not be called in sync block; will re-initialize units field
								eNotify(new NotificationImpl(Notification.SET, units,
										getPublicEditableUnits()) {
									public Object getNotifier() {
										return InstanceConfigurationImpl.this;
									}

									@Override
									public Object getFeature() {
										return CorePackage.eINSTANCE
												.getInstanceConfiguration_PublicEditableUnits();
									}
								});

								// should not be called in sync block; will re-initialize units field
								eNotify(new NotificationImpl(Notification.SET, oldProperties,
										getGlobalProperties()) {
									public Object getNotifier() {
										return InstanceConfigurationImpl.this;
									}

									@Override
									public Object getFeature() {
										return CorePackage.eINSTANCE
												.getInstanceConfiguration_GlobalProperties();
									}

								});
								return Status.OK_STATUS;
							}
						};

						// there is no real progress to update, and there's no guarantee we'll be run in the UI.
						notifierJob.enqueue(update);
						notifierJob.schedule(DELAY);
					} else {
						if (Platform.inDebugMode()) {
							DeployCorePlugin.logError(0,
									"An attempt was made to update a proxified InstanceConfiguration.", //$NON-NLS-1$
									new IllegalStateException());
						}
					}

				}
			}
		}

	}

	protected boolean hasChanged(List<Unit> oldUnits, List<Property> oldGlobalProperties) {
		// This optimization prevents events for changing values.
//		if (oldUnits == null && oldGlobalProperties == null) {
//			return false;
//		}
//
//		if (getImported() != null) {
//			InternalScopeService service = (InternalScopeService) IScopeService.Locator
//					.findScopeService(getImported());
//			if (service != null) {
//				List<Unit> newUnits = internalGetVisibleUnits(service, getImported(),
//						new ArrayList<String>());
//				if (newUnits == null || newUnits.size() != oldUnits.size()) {
//					return true;
//				}
//				if (!newUnits.containsAll(oldUnits)) {
//					return true;
//				}
//
//				List<Property> newProperties = internalGetGlobalProperties(getImportedContract());
//				if (newProperties == null || oldGlobalProperties == null
//						|| newProperties.size() != oldGlobalProperties.size()) {
//					return true;
//				}
//				if (!newProperties.containsAll(oldGlobalProperties)) {
//					return true;
//				}
//
//				return false;
//			}
//		}
		return true;

	}

	public void updateScopeService() {
		InternalScopeService newService = (InternalScopeService) IScopeService.Locator
				.findScopeService(getImported());
		if (oldService == null || oldService != newService) {
			if (oldService != null) {
				oldService.remove(listener);
			}
			if (newService != null) {
				newService.listen(listener);
			}
			oldService = newService;
		}
	}

	public Instantiation instantiate(String referenced) {
		Assert.isNotNull(referenced);
		Instantiation instance = null;
		synchronized (lock) {
			for (Iterator instances = getInstantiations().iterator(); instances.hasNext();) {
				instance = (Instantiation) instances.next();
				if (referenced.equals(instance.getReferenced())) {
					return instance;
				}
			}
			instance = CoreFactory.eINSTANCE.createInstantiation();
			instance.setReferenced(referenced);
			boolean deliver = eDeliver();
			try {
				eSetDeliver(false);
				getInstantiations().add(instance);
				getInstantiationCacheMap().put(referenced, instance);
				UnitUtil.assignUniqueName(instance);
			} finally {
				eSetDeliver(deliver);
			}
		}
		return instance;
	}

	public Instantiation getInstantiation(String referenced) {
		Assert.isNotNull(referenced);
		synchronized (lock) {

			Instantiation instance = getInstantiationCacheMap().get(referenced);
			if (instance == null) {
				for (Iterator instances = getInstantiations().iterator(); instances.hasNext();) {
					instance = (Instantiation) instances.next();
					if (referenced.equals(instance.getReferenced())) {
						getInstantiationCacheMap().put(referenced, instance);
						return instance;
					}
				}
				// ensure we don't return the last entry accidentally
				return null;
			}
			return instance;
		}
	}

	public Instantiation getInstantiationByName(String name) {
		Assert.isNotNull(name);
		synchronized (lock) {
			Instantiation instance = null;
			for (Iterator instances = getInstantiations().iterator(); instances.hasNext();) {
				instance = (Instantiation) instances.next();
				if (name.equals(instance.getName())) {
					return instance;
				}
			}
		}
		return null;
	}

	public List<Property> getGlobalProperties() {
		synchronized (lock) {

			ConfigurationContract contract = getImportedContract();
			if (contract != null) {

				boolean deliver = eDeliver();
				try {
					// suppress events for the instantiation of the Instantiation
					eSetDeliver(false);
					if (globalProperties == null) {
						globalProperties = internalGetGlobalProperties(contract);
					}
				} finally {
					eSetDeliver(deliver);
				}
				return basicGetGlobalProperties();
			}
		}
		return Collections.emptyList();
	}

	private List<Property> internalGetGlobalProperties(ConfigurationContract contract) {
		List<Property> properties = basicGetGlobalProperties();
		for (Iterator<Property> iterator = contract.getGlobalProperties().iterator(); iterator
				.hasNext();) {
			Property contractProperty = iterator.next();
			MirrorredProperty property = new MirrorredProperty(this, contractProperty.getName());
			properties.add(property);
		}
		return properties;
	}

	public Property getProperty(String name) {
		if (name != null) {
			for (Iterator<Property> iterator = getGlobalProperties().iterator(); iterator.hasNext();) {
				Property property = iterator.next();
				if (name.equals(property.getName())) {
					return property;
				}
			}
		}
		return null;
	}

	private List<Property> basicGetGlobalProperties() {
		if (globalProperties == null) {
			globalProperties = new ArrayList<Property>();
		}
		return globalProperties;
	}

	public ConfigurationContract getImportedContract() {
		ConfigurationContract contract = null;
		// find the scope service for the local (referencing) Topology
		InternalScopeService scopeService = (InternalScopeService) IScopeService.Locator
				.findScopeService(getTopology());
		if (scopeService != null) {
			Topology topology = scopeService.resolve(getImported());
			if (topology != null) {
				// Use Contract to locate the public Units
				contract = topology.getConfigurationContract();
			}
		}
		return contract;
	}

	public ConfigurationContract getImportedContract(InternalScopeService scopeService) {
		ConfigurationContract contract = null;
		if (scopeService != null) {
			Topology topology = scopeService.resolve(getImported());
			if (topology != null) {
				// Use Contract to locate the public Units
				contract = topology.getConfigurationContract();
			}
		}
		return contract;
	}

	public Instantiation createInstantiation(DeployModelObject source) {
		return createInstantiation(source, source.getFullPath(), null);
	}

	public Instantiation createInstantiation(DeployModelObject source, String referenced) {
		return createInstantiation(source, referenced, null);
	}

	public Instantiation createInstantiation(DeployModelObject source, String referenced, String name) {
		synchronized (lock) {

			Instantiation instantiation = null;
			if (name != null) {
				instantiation = getInstantiationByName(name);
			} else {
				instantiation = getInstantiation(referenced);
			}

			if (instantiation == null) {
				instantiation = CoreFactory.eINSTANCE.createInstantiation();
				instantiation.setReferenced(referenced);
				getInstantiations().add(instantiation);
				if (name == null) {
					UnitUtil.assignUniqueName(instantiation);
				} else {
					instantiation.setName(name);
				}
				instantiation.setDisplayName(source.getDisplayName());

				instantiationsByReferencedMap.put(referenced, instantiation);
				return instantiation;
			}
			return instantiation;
		}
	}

	public Map<String, Instantiation> getInstantiationCacheMap() {
		if (instantiationsByReferencedMap == null || staleCache) {
			// will init if necessary
			updateInstantiationCache();
		}
		return instantiationsByReferencedMap;
	}

	private void updateInstantiationCache() {

		if (instantiationsByReferencedMap == null) {
			instantiationsByReferencedMap = new HashMap<String, Instantiation>(getInstantiations()
					.size());
		}
		if (staleCache) {
			instantiationsByReferencedMap.clear();
			for (Instantiation next : (List<Instantiation>) getInstantiations()) {
				instantiationsByReferencedMap.put(next.getReferenced(), next);
			}
			staleCache = false;

		}
	}

	@Override
	public void eNotify(Notification notification) {
		super.eNotify(notification);
		if (notification.getFeature() == CorePackage.Literals.INSTANCE_CONFIGURATION__INSTANTIATIONS) {
			staleCache = true;
		}
	}

} // InstanceConfigurationImpl
