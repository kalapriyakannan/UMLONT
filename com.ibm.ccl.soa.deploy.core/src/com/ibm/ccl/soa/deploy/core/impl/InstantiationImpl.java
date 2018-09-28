/**
 * <copyright> </copyright>
 * 
 * $Id: InstantiationImpl.java,v 1.16 2008/06/26 23:13:19 mdelder Exp $
 */
package com.ibm.ccl.soa.deploy.core.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

import com.ibm.ccl.soa.deploy.core.Augmentation;
import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.Instantiation;
import com.ibm.ccl.soa.deploy.core.Property;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.internal.core.FeatureAwareList;
import com.ibm.ccl.soa.deploy.internal.core.InternalDeployModelObject;
import com.ibm.ccl.soa.deploy.internal.core.InternalInstantiation;
import com.ibm.ccl.soa.deploy.internal.core.extension.IScopeService;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.InternalInstanceConfiguration;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.InternalScopeService;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Instantiation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.InstantiationImpl#getConfiguredCapabilityGroup <em>Configured Capability Group</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.InstantiationImpl#getConfiguredCapabilities <em>Configured Capabilities</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.InstantiationImpl#getConfiguredRequirementsGroup <em>Configured Requirements Group</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.InstantiationImpl#getConfiguredRequirements <em>Configured Requirements</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.InstantiationImpl#getConfiguredProperties <em>Configured Properties</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.InstantiationImpl#getAugmentationGroup <em>Augmentation Group</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.InstantiationImpl#getAugmentations <em>Augmentations</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.InstantiationImpl#getReferenced <em>Referenced</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated NOT
 * @extends InternalInstantiation
 */
public class InstantiationImpl extends DeployModelObjectImpl implements Instantiation,
		InternalInstantiation {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getConfiguredCapabilityGroup() <em>Configured Capability Group</em>}'
	 * attribute list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getConfiguredCapabilityGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap configuredCapabilityGroup;

	/**
	 * The cached value of the '{@link #getConfiguredRequirementsGroup() <em>Configured Requirements Group</em>}'
	 * attribute list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getConfiguredRequirementsGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap configuredRequirementsGroup;

	/**
	 * The cached value of the '{@link #getConfiguredProperties() <em>Configured Properties</em>}'
	 * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getConfiguredProperties()
	 * @generated
	 * @ordered
	 */
	protected EList configuredProperties;

	/**
	 * The cached value of the '{@link #getAugmentationGroup() <em>Augmentation Group</em>}'
	 * attribute list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getAugmentationGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap augmentationGroup;

	/**
	 * The default value of the '{@link #getReferenced() <em>Referenced</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getReferenced()
	 * @generated
	 * @ordered
	 */
	protected static final String REFERENCED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReferenced() <em>Referenced</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getReferenced()
	 * @generated
	 * @ordered
	 */
	protected String referenced = REFERENCED_EDEFAULT;

	private FeatureAwareList capabilities;

	private FeatureAwareList requirements;

	private final Map<String, Property> propertiesMap = new HashMap<String, Property>();

	private boolean staleCache = true;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected InstantiationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.INSTANTIATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FeatureMap getConfiguredCapabilityGroup() {
		if (configuredCapabilityGroup == null) {
			configuredCapabilityGroup = new BasicFeatureMap(this,
					CorePackage.INSTANTIATION__CONFIGURED_CAPABILITY_GROUP);
		}
		return configuredCapabilityGroup;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public List getConfiguredCapabilities() {
		return getConfiguredCapabilityGroup().list(
				CorePackage.Literals.INSTANTIATION__CONFIGURED_CAPABILITIES);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FeatureMap getConfiguredRequirementsGroup() {
		if (configuredRequirementsGroup == null) {
			configuredRequirementsGroup = new BasicFeatureMap(this,
					CorePackage.INSTANTIATION__CONFIGURED_REQUIREMENTS_GROUP);
		}
		return configuredRequirementsGroup;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public List getConfiguredRequirements() {
		return getConfiguredRequirementsGroup().list(
				CorePackage.Literals.INSTANTIATION__CONFIGURED_REQUIREMENTS);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public List getConfiguredProperties() {
		if (configuredProperties == null) {
			configuredProperties = new EObjectContainmentEList(Property.class, this,
					CorePackage.INSTANTIATION__CONFIGURED_PROPERTIES);
		}
		return configuredProperties;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FeatureMap getAugmentationGroup() {
		if (augmentationGroup == null) {
			augmentationGroup = new BasicFeatureMap(this,
					CorePackage.INSTANTIATION__AUGMENTATION_GROUP);
		}
		return augmentationGroup;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public List getAugmentations() {
		return getAugmentationGroup().list(CorePackage.Literals.INSTANTIATION__AUGMENTATIONS);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getReferenced() {
		return referenced;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setReferenced(String newReferenced) {
		String oldReferenced = referenced;
		referenced = newReferenced;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					CorePackage.INSTANTIATION__REFERENCED, oldReferenced, referenced));
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
		case CorePackage.INSTANTIATION__CONFIGURED_CAPABILITY_GROUP:
			return ((InternalEList) getConfiguredCapabilityGroup()).basicRemove(otherEnd, msgs);
		case CorePackage.INSTANTIATION__CONFIGURED_CAPABILITIES:
			return ((InternalEList) getConfiguredCapabilities()).basicRemove(otherEnd, msgs);
		case CorePackage.INSTANTIATION__CONFIGURED_REQUIREMENTS_GROUP:
			return ((InternalEList) getConfiguredRequirementsGroup()).basicRemove(otherEnd, msgs);
		case CorePackage.INSTANTIATION__CONFIGURED_REQUIREMENTS:
			return ((InternalEList) getConfiguredRequirements()).basicRemove(otherEnd, msgs);
		case CorePackage.INSTANTIATION__CONFIGURED_PROPERTIES:
			return ((InternalEList) getConfiguredProperties()).basicRemove(otherEnd, msgs);
		case CorePackage.INSTANTIATION__AUGMENTATION_GROUP:
			return ((InternalEList) getAugmentationGroup()).basicRemove(otherEnd, msgs);
		case CorePackage.INSTANTIATION__AUGMENTATIONS:
			return ((InternalEList) getAugmentations()).basicRemove(otherEnd, msgs);
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
		case CorePackage.INSTANTIATION__CONFIGURED_CAPABILITY_GROUP:
			if (coreType) {
				return getConfiguredCapabilityGroup();
			}
			return ((FeatureMap.Internal) getConfiguredCapabilityGroup()).getWrapper();
		case CorePackage.INSTANTIATION__CONFIGURED_CAPABILITIES:
			return getConfiguredCapabilities();
		case CorePackage.INSTANTIATION__CONFIGURED_REQUIREMENTS_GROUP:
			if (coreType) {
				return getConfiguredRequirementsGroup();
			}
			return ((FeatureMap.Internal) getConfiguredRequirementsGroup()).getWrapper();
		case CorePackage.INSTANTIATION__CONFIGURED_REQUIREMENTS:
			return getConfiguredRequirements();
		case CorePackage.INSTANTIATION__CONFIGURED_PROPERTIES:
			return getConfiguredProperties();
		case CorePackage.INSTANTIATION__AUGMENTATION_GROUP:
			if (coreType) {
				return getAugmentationGroup();
			}
			return ((FeatureMap.Internal) getAugmentationGroup()).getWrapper();
		case CorePackage.INSTANTIATION__AUGMENTATIONS:
			return getAugmentations();
		case CorePackage.INSTANTIATION__REFERENCED:
			return getReferenced();
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
		case CorePackage.INSTANTIATION__CONFIGURED_CAPABILITY_GROUP:
			((FeatureMap.Internal) getConfiguredCapabilityGroup()).set(newValue);
			return;
		case CorePackage.INSTANTIATION__CONFIGURED_CAPABILITIES:
			getConfiguredCapabilities().clear();
			getConfiguredCapabilities().addAll((Collection) newValue);
			return;
		case CorePackage.INSTANTIATION__CONFIGURED_REQUIREMENTS_GROUP:
			((FeatureMap.Internal) getConfiguredRequirementsGroup()).set(newValue);
			return;
		case CorePackage.INSTANTIATION__CONFIGURED_REQUIREMENTS:
			getConfiguredRequirements().clear();
			getConfiguredRequirements().addAll((Collection) newValue);
			return;
		case CorePackage.INSTANTIATION__CONFIGURED_PROPERTIES:
			getConfiguredProperties().clear();
			getConfiguredProperties().addAll((Collection) newValue);
			return;
		case CorePackage.INSTANTIATION__AUGMENTATION_GROUP:
			((FeatureMap.Internal) getAugmentationGroup()).set(newValue);
			return;
		case CorePackage.INSTANTIATION__AUGMENTATIONS:
			getAugmentations().clear();
			getAugmentations().addAll((Collection) newValue);
			return;
		case CorePackage.INSTANTIATION__REFERENCED:
			setReferenced((String) newValue);
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
		case CorePackage.INSTANTIATION__CONFIGURED_CAPABILITY_GROUP:
			getConfiguredCapabilityGroup().clear();
			return;
		case CorePackage.INSTANTIATION__CONFIGURED_CAPABILITIES:
			getConfiguredCapabilities().clear();
			return;
		case CorePackage.INSTANTIATION__CONFIGURED_REQUIREMENTS_GROUP:
			getConfiguredRequirementsGroup().clear();
			return;
		case CorePackage.INSTANTIATION__CONFIGURED_REQUIREMENTS:
			getConfiguredRequirements().clear();
			return;
		case CorePackage.INSTANTIATION__CONFIGURED_PROPERTIES:
			getConfiguredProperties().clear();
			return;
		case CorePackage.INSTANTIATION__AUGMENTATION_GROUP:
			getAugmentationGroup().clear();
			return;
		case CorePackage.INSTANTIATION__AUGMENTATIONS:
			getAugmentations().clear();
			return;
		case CorePackage.INSTANTIATION__REFERENCED:
			setReferenced(REFERENCED_EDEFAULT);
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
		case CorePackage.INSTANTIATION__CONFIGURED_CAPABILITY_GROUP:
			return configuredCapabilityGroup != null && !configuredCapabilityGroup.isEmpty();
		case CorePackage.INSTANTIATION__CONFIGURED_CAPABILITIES:
			return !getConfiguredCapabilities().isEmpty();
		case CorePackage.INSTANTIATION__CONFIGURED_REQUIREMENTS_GROUP:
			return configuredRequirementsGroup != null && !configuredRequirementsGroup.isEmpty();
		case CorePackage.INSTANTIATION__CONFIGURED_REQUIREMENTS:
			return !getConfiguredRequirements().isEmpty();
		case CorePackage.INSTANTIATION__CONFIGURED_PROPERTIES:
			return configuredProperties != null && !configuredProperties.isEmpty();
		case CorePackage.INSTANTIATION__AUGMENTATION_GROUP:
			return augmentationGroup != null && !augmentationGroup.isEmpty();
		case CorePackage.INSTANTIATION__AUGMENTATIONS:
			return !getAugmentations().isEmpty();
		case CorePackage.INSTANTIATION__REFERENCED:
			return REFERENCED_EDEFAULT == null ? referenced != null : !REFERENCED_EDEFAULT
					.equals(referenced);
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
		result.append(" (configuredCapabilityGroup: "); //$NON-NLS-1$
		result.append(configuredCapabilityGroup);
		result.append(", configuredRequirementsGroup: "); //$NON-NLS-1$
		result.append(configuredRequirementsGroup);
		result.append(", augmentationGroup: "); //$NON-NLS-1$
		result.append(augmentationGroup);
		result.append(", referenced: "); //$NON-NLS-1$
		result.append(referenced);
		result.append(')');
		return result.toString();
	}

	public List getCapabilities() {
		if (capabilities == null) {
			capabilities = new FeatureAwareList(CorePackage.eINSTANCE
					.getInstantiation_ConfiguredCapabilities(),
					(FeatureMap.Internal) getConfiguredCapabilityGroup());
		}
		return capabilities;
	}

	public List getRequirements() {

		if (requirements == null) {
			requirements = new FeatureAwareList(CorePackage.eINSTANCE
					.getInstantiation_ConfiguredRequirements(),
					(FeatureMap.Internal) getConfiguredRequirementsGroup());
		}
		return requirements;
	}

	/**
	 * Return a property of the given name.
	 * 
	 * <p>
	 * This method may return null.
	 * </p>
	 * 
	 * @param property
	 *           The name of the property to look for.
	 * 
	 * @return The property of the given name.
	 */
	public Property getProperty(String property) {
		Assert.isNotNull(property);

		if (staleCache) {

			for (Property prop : (List<Property>) getConfiguredProperties()) {
				propertiesMap.put(prop.getSelect(), prop);
			}
			staleCache = false;
		}
		return propertiesMap.get(property);
	}

	public String getDefaultValue(String property) {
		if (property != null) {
			InternalInstanceConfiguration instanceConfig = (InternalInstanceConfiguration) eContainer();
			ConfigurationContract contract = instanceConfig.getImportedContract();
			if (contract != null) {
				Property mirror = contract.getProperty(property);
				return mirror != null ? mirror.getValue() : null;
			}
		}
		return null;

	}

	/**
	 * Return the augmentation for the given field.
	 * 
	 * @param field
	 *           The name of a field from the source's EClass.
	 * @return The augmentation for the given field.
	 */
	public Augmentation getAugmentation(String field) {
		Augmentation augmentation = null;
		synchronized (getAugmentations()) {
			for (Iterator<Augmentation> iterator = getAugmentations().iterator(); iterator.hasNext();) {
				augmentation = iterator.next();
				if (field.equals(augmentation.getSelect())) {
					return augmentation;
				}
			}
		}
		return null;
	}

	/**
	 * Return the augmentation for the given field, and create it if necessary.
	 * 
	 * @param field
	 *           The name of a field from the source's EClass.
	 * @return The augmentation for the given field or create it if necessary.
	 */
	public Augmentation createAugmentation(String field) {
		Augmentation augmentation = null;
		synchronized (getAugmentations()) {
			for (Iterator<Augmentation> iterator = getAugmentations().iterator(); iterator.hasNext();) {
				augmentation = iterator.next();
				if (field.equals(augmentation.getSelect())) {
					return augmentation;
				}
			}
			augmentation = CoreFactory.eINSTANCE.createAugmentation();
			augmentation.setSelect(field);
			getAugmentations().add(augmentation);
		}
		return augmentation;
	}

	public DeployModelObject getReferencedObject() {
		String qualified = getQualifiedPath();
		if (qualified != null) {
			InternalScopeService service = (InternalScopeService) IScopeService.Locator
					.findScopeService(this);
			if (service != null) {
				return service.resolve(qualified);
			}
		}
		return null;
	}

	protected String getQualifiedPath() {
		String qualified = null;
		InternalDeployModelObject parent = getContaintmentParent();
		if (parent != null && parent instanceof InstanceConfiguration) {
			InstanceConfiguration config = (InstanceConfiguration) parent;
			Import imported = config.getImported();
			qualified = imported.getQualifiedImport() + IConstants.TOPOLOGY_SEPARATOR
					+ IConstants.PATH_SEPARATOR + getReferenced();
		}
		return qualified;
	}

	public DeployModelObject resolveReferenced(String referenced) {
		IPath parsed = new Path(referenced);
		if (parsed.segmentCount() == 0) {
			return getReferencedObject();
		}

		for (Iterator iterator = getCapabilities().iterator(); iterator.hasNext();) {
			Capability ref = (Capability) iterator.next();
			if (parsed.segment(0).equals(ref.getName())) {
				if (parsed.segmentCount() > 1) {
					return ref.resolve(parsed.removeFirstSegments(1).toString());
				}
				return ref;
			}
		}
		for (Iterator iterator = getRequirements().iterator(); iterator.hasNext();) {
			Requirement ref = (Requirement) iterator.next();
			if (parsed.segment(0).equals(ref.getName())) {
				if (parsed.segmentCount() > 1) {
					return ref.resolve(parsed.removeFirstSegments(1).toString());
				}
				return ref;
			}
		}
		for (Iterator iterator = getAugmentations().iterator(); iterator.hasNext();) {
			Augmentation ref = (Augmentation) iterator.next();
			for (Iterator iterator2 = ref.getAdditions().iterator(); iterator2.hasNext();) {
				Object augmented = iterator2.next();
				if (augmented instanceof DeployModelObject) {
					if (parsed.segment(0).equals(((DeployModelObject) augmented).getName())) {
						if (parsed.segmentCount() > 1) {
							return ((DeployModelObject) augmented).resolve(parsed.removeFirstSegments(1)
									.toString());
						}
						return (DeployModelObject) augmented;
					}
				}
			}
		}
		return null;
	}

	@Override
	public void eNotify(Notification notification) {
		super.eNotify(notification);
		if (notification.getFeature() == CorePackage.Literals.INSTANTIATION__CONFIGURED_PROPERTIES) {
			staleCache = true;
		}
	}

} //InstantiationImpl