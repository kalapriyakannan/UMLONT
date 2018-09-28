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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.core.ConfigurationContract;
import com.ibm.ccl.soa.deploy.core.CoreFactory;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExplicitContract;
import com.ibm.ccl.soa.deploy.core.Exported;
import com.ibm.ccl.soa.deploy.core.ExportedUnit;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.Property;
import com.ibm.ccl.soa.deploy.core.Requirement;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.Unit;
import com.ibm.ccl.soa.deploy.core.Visibility;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;
import com.ibm.ccl.soa.deploy.internal.core.InternalTopology;
import com.ibm.ccl.soa.deploy.internal.core.extension.IScopeService;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.InternalScopeService;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Explicit Contract</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.ExplicitContractImpl#getExportedUnits <em>Exported Units</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.ExplicitContractImpl#getProperties <em>Properties</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.ExplicitContractImpl#getDefaultConceptualPolicy <em>Default Conceptual Policy</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.ExplicitContractImpl#getDefaultPolicy <em>Default Policy</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ExplicitContractImpl extends ConfigurationContractImpl implements ExplicitContract {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getExportedUnits() <em>Exported Units</em>}' containment
	 * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getExportedUnits()
	 * @generated
	 * @ordered
	 */
	protected EList exportedUnits;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference
	 * list. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList properties;

	/**
	 * The default value of the '{@link #getDefaultConceptualPolicy() <em>Default Conceptual Policy</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDefaultConceptualPolicy()
	 * @generated NOT
	 * @ordered
	 */
	protected static final Visibility DEFAULT_CONCEPTUAL_POLICY_EDEFAULT = Visibility.PUBLIC_LITERAL;

	/**
	 * The cached value of the '{@link #getDefaultConceptualPolicy() <em>Default Conceptual Policy</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDefaultConceptualPolicy()
	 * @generated
	 * @ordered
	 */
	protected Visibility defaultConceptualPolicy = DEFAULT_CONCEPTUAL_POLICY_EDEFAULT;

	/**
	 * This is true if the Default Conceptual Policy attribute has been set. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean defaultConceptualPolicyESet;

	/**
	 * The default value of the '{@link #getDefaultPolicy() <em>Default Policy</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDefaultPolicy()
	 * @generated
	 * @ordered
	 */
	protected static final Visibility DEFAULT_POLICY_EDEFAULT = Visibility.PRIVATE_LITERAL;

	/**
	 * The cached value of the '{@link #getDefaultPolicy() <em>Default Policy</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDefaultPolicy()
	 * @generated
	 * @ordered
	 */
	protected Visibility defaultPolicy = DEFAULT_POLICY_EDEFAULT;

	/**
	 * This is true if the Default Policy attribute has been set. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean defaultPolicyESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ExplicitContractImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.EXPLICIT_CONTRACT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public List getExportedUnits() {
		if (exportedUnits == null) {
			exportedUnits = new EObjectContainmentEList(ExportedUnit.class, this,
					CorePackage.EXPLICIT_CONTRACT__EXPORTED_UNITS);
		}
		return exportedUnits;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public List getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList(Property.class, this,
					CorePackage.EXPLICIT_CONTRACT__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Visibility getDefaultConceptualPolicy() {
		return defaultConceptualPolicy;
	}

	public void setDefaultConceptualPolicy(Visibility newDefaultConceptualPolicy) {
		setDefaultConceptualPolicyGen(newDefaultConceptualPolicy);
	}

	public void setDefaultPolicy(Visibility newDefaultPolicy) {
		setDefaultPolicyGen(newDefaultPolicy);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDefaultConceptualPolicyGen(Visibility newDefaultConceptualPolicy) {
		Visibility oldDefaultConceptualPolicy = defaultConceptualPolicy;
		defaultConceptualPolicy = newDefaultConceptualPolicy == null ? DEFAULT_CONCEPTUAL_POLICY_EDEFAULT
				: newDefaultConceptualPolicy;
		boolean oldDefaultConceptualPolicyESet = defaultConceptualPolicyESet;
		defaultConceptualPolicyESet = true;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					CorePackage.EXPLICIT_CONTRACT__DEFAULT_CONCEPTUAL_POLICY,
					oldDefaultConceptualPolicy, defaultConceptualPolicy, !oldDefaultConceptualPolicyESet));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void unsetDefaultConceptualPolicy() {
		Visibility oldDefaultConceptualPolicy = defaultConceptualPolicy;
		boolean oldDefaultConceptualPolicyESet = defaultConceptualPolicyESet;
		defaultConceptualPolicy = DEFAULT_CONCEPTUAL_POLICY_EDEFAULT;
		defaultConceptualPolicyESet = false;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					CorePackage.EXPLICIT_CONTRACT__DEFAULT_CONCEPTUAL_POLICY,
					oldDefaultConceptualPolicy, DEFAULT_CONCEPTUAL_POLICY_EDEFAULT,
					oldDefaultConceptualPolicyESet));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isSetDefaultConceptualPolicy() {
		return defaultConceptualPolicyESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Visibility getDefaultPolicy() {
		return defaultPolicy;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDefaultPolicyGen(Visibility newDefaultPolicy) {
		Visibility oldDefaultPolicy = defaultPolicy;
		defaultPolicy = newDefaultPolicy == null ? DEFAULT_POLICY_EDEFAULT : newDefaultPolicy;
		boolean oldDefaultPolicyESet = defaultPolicyESet;
		defaultPolicyESet = true;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					CorePackage.EXPLICIT_CONTRACT__DEFAULT_POLICY, oldDefaultPolicy, defaultPolicy,
					!oldDefaultPolicyESet));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void unsetDefaultPolicy() {
		Visibility oldDefaultPolicy = defaultPolicy;
		boolean oldDefaultPolicyESet = defaultPolicyESet;
		defaultPolicy = DEFAULT_POLICY_EDEFAULT;
		defaultPolicyESet = false;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					CorePackage.EXPLICIT_CONTRACT__DEFAULT_POLICY, oldDefaultPolicy,
					DEFAULT_POLICY_EDEFAULT, oldDefaultPolicyESet));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isSetDefaultPolicy() {
		return defaultPolicyESet;
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
		case CorePackage.EXPLICIT_CONTRACT__EXPORTED_UNITS:
			return ((InternalEList) getExportedUnits()).basicRemove(otherEnd, msgs);
		case CorePackage.EXPLICIT_CONTRACT__PROPERTIES:
			return ((InternalEList) getProperties()).basicRemove(otherEnd, msgs);
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
		case CorePackage.EXPLICIT_CONTRACT__EXPORTED_UNITS:
			return getExportedUnits();
		case CorePackage.EXPLICIT_CONTRACT__PROPERTIES:
			return getProperties();
		case CorePackage.EXPLICIT_CONTRACT__DEFAULT_CONCEPTUAL_POLICY:
			return getDefaultConceptualPolicy();
		case CorePackage.EXPLICIT_CONTRACT__DEFAULT_POLICY:
			return getDefaultPolicy();
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
		case CorePackage.EXPLICIT_CONTRACT__EXPORTED_UNITS:
			getExportedUnits().clear();
			getExportedUnits().addAll((Collection) newValue);
			return;
		case CorePackage.EXPLICIT_CONTRACT__PROPERTIES:
			getProperties().clear();
			getProperties().addAll((Collection) newValue);
			return;
		case CorePackage.EXPLICIT_CONTRACT__DEFAULT_CONCEPTUAL_POLICY:
			setDefaultConceptualPolicy((Visibility) newValue);
			return;
		case CorePackage.EXPLICIT_CONTRACT__DEFAULT_POLICY:
			setDefaultPolicy((Visibility) newValue);
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
		case CorePackage.EXPLICIT_CONTRACT__EXPORTED_UNITS:
			getExportedUnits().clear();
			return;
		case CorePackage.EXPLICIT_CONTRACT__PROPERTIES:
			getProperties().clear();
			return;
		case CorePackage.EXPLICIT_CONTRACT__DEFAULT_CONCEPTUAL_POLICY:
			unsetDefaultConceptualPolicy();
			return;
		case CorePackage.EXPLICIT_CONTRACT__DEFAULT_POLICY:
			unsetDefaultPolicy();
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
		case CorePackage.EXPLICIT_CONTRACT__EXPORTED_UNITS:
			return exportedUnits != null && !exportedUnits.isEmpty();
		case CorePackage.EXPLICIT_CONTRACT__PROPERTIES:
			return properties != null && !properties.isEmpty();
		case CorePackage.EXPLICIT_CONTRACT__DEFAULT_CONCEPTUAL_POLICY:
			return isSetDefaultConceptualPolicy();
		case CorePackage.EXPLICIT_CONTRACT__DEFAULT_POLICY:
			return isSetDefaultPolicy();
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
		result.append(" (defaultConceptualPolicy: "); //$NON-NLS-1$
		if (defaultConceptualPolicyESet) {
			result.append(defaultConceptualPolicy);
		} else {
			result.append("<unset>"); //$NON-NLS-1$
		}
		result.append(", defaultPolicy: "); //$NON-NLS-1$
		if (defaultPolicyESet) {
			result.append(defaultPolicy);
		} else {
			result.append("<unset>"); //$NON-NLS-1$
		}
		result.append(')');
		return result.toString();
	}

	public List<Unit> getPublicUnits() {
		return getVisibleUnits();
	}

	public List<Unit> getVisibleUnits() {
		List<ExportedUnit> exported = getExportedUnits();
		Topology topology = getTopology();

		Set<Unit> publicUnits = new HashSet<Unit>();
		if (topology != null) {
			switch (getDefaultPolicy().getValue())
			{
			case Visibility.PRIVATE: {
				for (Iterator<ExportedUnit> iterator = exported.iterator(); iterator.hasNext();) {
					ExportedUnit exportedUnit = iterator.next();
					if (exportedUnit != null && isExposed(exportedUnit)) {
						DeployModelObject resolved = topology.resolve(exportedUnit.getPath());
						if (resolved != null && resolved instanceof Unit) {
							publicUnits.add((Unit) resolved);
						}
					}
				}
				if (areConceptualUnitsExported()) {
					// also collect conceptual units
					for (Iterator<Unit> allUnits = topology.getUnits().iterator(); allUnits.hasNext();) {
						Unit unit = allUnits.next();
						if (isConcpetualAndUnrealized(unit)) {
							publicUnits.add(unit);
						}
					}
				}
				break;
			}
			case Visibility.PUBLIC:
			case Visibility.PUBLIC_EDITABLE: {
				for (Iterator<Unit> allUnits = topology.getUnits().iterator(); allUnits.hasNext();) {
					Unit unit = allUnits.next();
					ExportedUnit exportedUnit = (ExportedUnit) findExported(unit, false);
					if (exportedUnit == null) {
						if (areConceptualUnitsExported() && isConcpetualAndUnrealized(unit)) {
							publicUnits.add(unit);
						} else if (isLocal(unit)) { // default is to export the unit if it's local 
							publicUnits.add(unit);
						}
					} else if (isExposed(exportedUnit)) {
						publicUnits.add(unit);
					}
				}
				break;
			}
			}
		}
		return new ArrayList<Unit>(publicUnits);
	}

	private boolean isLocal(Unit unit) {
		return unit.getTopology() == getTopology();
	}

	private boolean isExposed(ExportedUnit exportedUnit) {
		if (exportedUnit.isConfigurable() || exportedUnit.isLinkable()) {
			return true;
		}
		if (exportedUnit.getExportedCapabilities().size() > 0) {
			for (Iterator iterator = exportedUnit.getExportedCapabilities().iterator(); iterator
					.hasNext();) {
				Exported exported = (Exported) iterator.next();
				if (isExposed(exported)) {
					return true;
				}
			}
		}
		if (exportedUnit.getExportedRequirements().size() > 0) {
			for (Iterator iterator = exportedUnit.getExportedRequirements().iterator(); iterator
					.hasNext();) {
				Exported exported = (Exported) iterator.next();
				if (isExposed(exported)) {
					return true;
				}
			}
		}
		if (exportedUnit.getExportedProperties().size() > 0) {
			return true;
		}

		return false;
	}

	private boolean isExposed(Exported exported) {
		return exported.isConfigurable() || exported.isLinkable();
	}

	private boolean isConcpetualAndUnrealized(Unit unit) {
		return unit.isConceptual() && unit.getRealizationLinks().size() == 0;
	}

	private boolean areConceptualUnitsExported() {
		return getDefaultConceptualPolicy().getValue() != Visibility.PRIVATE;
	}

	private boolean areConceptualUnitsEditable() {
		return getDefaultConceptualPolicy().getValue() == Visibility.PUBLIC_EDITABLE;
	}

	public List<Unit> getPublicEditableUnits() {
		List<ExportedUnit> exported = getExportedUnits();
		Topology topology = getTopology();

		Set<Unit> publicUnits = new HashSet<Unit>();
		switch (getDefaultPolicy().getValue())
		{
		case Visibility.PRIVATE:
		case Visibility.PUBLIC: {
			for (Iterator<ExportedUnit> iterator = exported.iterator(); iterator.hasNext();) {
				ExportedUnit exportedUnit = iterator.next();
				if (exportedUnit != null && exportedUnit.isConfigurable()) {
					DeployModelObject resolved = topology.resolve(exportedUnit.getPath());
					if (resolved != null && resolved instanceof Unit) {
						publicUnits.add((Unit) resolved);
					}
				}
			}
			if (areConceptualUnitsEditable()) {
				// also collect conceptual units
				for (Iterator<Unit> allUnits = topology.findAllUnits(); allUnits.hasNext();) {
					Unit unit = allUnits.next();
					if (isConcpetualAndUnrealized(unit)) {
						publicUnits.add(unit);
					}
				}
			}
			break;
		}
		case Visibility.PUBLIC_EDITABLE: {
			for (Iterator<Unit> allUnits = topology.findAllUnits(); allUnits.hasNext();) {
				Unit unit = allUnits.next();
				Exported exportedUnit = findExported(unit, false);
				if (exportedUnit == null) {
					if (areConceptualUnitsEditable() && isConcpetualAndUnrealized(unit)) {
						publicUnits.add(unit);
					}
				} else if (exportedUnit.isConfigurable()) {
					publicUnits.add(unit);
				}
			}
			break;
		}
		}
		return new ArrayList<Unit>(publicUnits);
	}

	@Override
	public boolean isVisible(DeployModelObject source) {

		if (source == null) {
			return false;
		}

		// is it public
		if (isPublic(source)) {
			return true;
		}

		// search for a related import
		if (getEditTopology() != null) {
			Import imported = getEditTopology().getImport(source.getFullPath());
			if (imported != null && !isReexported(imported)) {
				return false;
			}
		}

		// does it have exposed properties?
		Unit unit = findContainer(source);
		if (unit != null) {
			ExportedUnit exported = (ExportedUnit) findExported(unit, true);

			if (exported != null) {

				String fullPath = source.getFullPath();
				String topologyPath = source.getTopology().getFullPath();
				String relativePath = IConstants.PATH_SEPARATOR
						+ fullPath.substring(topologyPath.length());

				List properties = exported.getExportedProperties();
				for (Iterator iterator = properties.iterator(); iterator.hasNext();) {
					Property property = (Property) iterator.next();
					String select = property.getSelect();
					if (select != null && select.startsWith(relativePath)) {
						return true;
					}
				}
			}
		}
		if (unit == source) { // we're dealing with a Unit.
			ExportedUnit exported = (ExportedUnit) findExported(unit, true);
			if (exported != null) {
				for (Iterator ietr = exported.getExportedCapabilities().iterator(); ietr.hasNext();) {
					Exported exportedChild = (Exported) ietr.next();
					if (isExposed(exportedChild)) {
						return true;
					}
				}
				for (Iterator iter = exported.getExportedRequirements().iterator(); iter.hasNext();) {
					Exported exportedChild = (Exported) iter.next();
					if (isExposed(exportedChild)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public boolean isPublic(DeployModelObject source) {

		if (source == null) {
			return false;
		}

		if (source instanceof Import) {
			return isReexported((Import) source);
		}

		String path = source.getFullPath();

		Topology container = null;
		Import imported = null;
		// search for a related import
		if ((container = getEditTopology()) != null) {

			if ((imported = getEditTopology().getImport(path)) != null) {
				return isReexported(imported) && source.isPublic();
			}

			if (path.indexOf(IConstants.TOPOLOGY_SEPARATOR) > -1
					&& container instanceof InternalTopology) {
				List<Import> relatedImports = ((InternalTopology) container).findRelatedImport(
						(InternalScopeService) IScopeService.Locator.findScopeService(this), path,
						new ArrayList<String>());
				for (Iterator<Import> iterator = relatedImports.iterator(); iterator.hasNext();) {
					imported = iterator.next();
					// either some import along the path isn't re-exported
					if (!isReexported(imported)) {
						return false;
					}
					// or the specific imported Unit doesn't happen to be public
					if (source.getQualifiedName() != null
							&& source.getQualifiedName().startsWith(imported.getQualifiedImport())) {
						return source.isPublic();
					}
				}
			}
		}

		Exported exported = findExported(source, true);
		if (exported != null) {
			if (isExposed(exported)) {
				return true;
			}
			return false;
		}

		Unit unit = findContainer(source);

		return isPublicByPolicy(unit);
	}

	private boolean isReexported(Import imported) {
		// fetch the container of the Topology
		Topology containingTopology = imported.getTopology();
		if (containingTopology != null) {
			if (containingTopology.getQualifiedName().equals(getTopology().getQualifiedName())) {
				if (imported.isSetReexported()) {
					return imported.isReexported();
				}
				switch (getDefaultPolicy().getValue())
				{
				case Visibility.PUBLIC:
				case Visibility.PUBLIC_EDITABLE:
					return true;
				default:
					return false;
				}
			} else {
				ConfigurationContract contract = containingTopology.getConfigurationContract();
				if (contract != null) {
					return contract.isPublic(imported);
				}
			}
		}
		return false;

	}

	private boolean isPublicByPolicy(Unit unit) {
		if (unit != null && isConcpetualAndUnrealized(unit)) {
			switch (getDefaultConceptualPolicy().getValue())
			{
			case Visibility.PUBLIC:
			case Visibility.PUBLIC_EDITABLE:
				return true;
			default:
				return false;
			}
		}
		switch (getDefaultPolicy().getValue())
		{
		case Visibility.PUBLIC:
		case Visibility.PUBLIC_EDITABLE:
			return true;
		default:
			return false;
		}
	}

	private Unit findContainer(DeployModelObject source) {
		Unit unit = null;
		if (source instanceof Unit) {
			unit = (Unit) source;
		} else {
			DeployModelObject container = source.getParent();
			while (container != null && !(container instanceof Unit)) {
				container = container.getParent();
			}
			if (container != null && container instanceof Unit) {
				unit = (Unit) container;
			}
		}
		return unit;
	}

	public boolean isPublicEditable(DeployModelObject source) {
		if (source == null || source instanceof Topology) {
			return true;
		}

		String path = source.getFullPath();

		if (source instanceof Import) {
			return false;
		}

		// search for a related import
		if (getEditTopology() != null) {
			Import imported = getEditTopology().getImport(path);
			if (imported != null) {
				return isReexported(imported) && source.isPublicEditable();
			}
		}

		Exported exported = findExported(source, true);
		if (exported != null) {
			if (exported.isConfigurable()) {
				return true;
			}
			return false;
		}

		Unit unit = findContainer(source);

		if (unit != null && isConcpetualAndUnrealized(unit)) {
			switch (getDefaultConceptualPolicy().getValue())
			{
			case Visibility.PUBLIC_EDITABLE:
				return true;
			default:
				return false;
			}
		}
		switch (getDefaultPolicy().getValue())
		{
		case Visibility.PUBLIC_EDITABLE:
			return true;
		default:
			return false;
		}
	}

	public Property exportProperty(String propertyName) {

		Assert.isNotNull(propertyName);

		for (Iterator props = getProperties().iterator(); props.hasNext();) {
			Property prop = (Property) props.next();
			if (propertyName.equals(prop.getName())) {
				return prop;
			}

		}
		Property property = CoreFactory.eINSTANCE.createProperty();
		property.setName(propertyName);
		getProperties().add(property);
		fireExportedGlobalProperty(getTopology(), property);

		return property;
	}

	public void export(DeployModelObject source, boolean configurable) {

		// search for a related import 
		if (source instanceof Import) {
			Import imported = (Import) source;
			if (!isReexported(imported)) {
				((Import) source).setReexported(true);
				fireVisibilityChanged(source, Visibility.PRIVATE_LITERAL, Visibility.PUBLIC_LITERAL);
			}
			return;
		}

		if (getEditTopology() != null) {
			Import imported = getEditTopology().getImport(source.getFullPath());
			if (imported != null) {
				IllegalStateException err = new IllegalStateException(NLS.bind(
						DeployCoreMessages.ExplicitContractImpl_Cannot_export_0_because_it_is_not_,
						source.getFullPath()));
				DeployCorePlugin.logError(0, err.getMessage(), err);
			}
		}

		Exported previouslyExported = findExported(source, false);

		Visibility oldValue = null;
		if (previouslyExported == null) {
			oldValue = Visibility.PRIVATE_LITERAL;
		} else if (previouslyExported.isConfigurable()) {
			oldValue = Visibility.PUBLIC_EDITABLE_LITERAL;
		} else if (previouslyExported.isLinkable()) {
			oldValue = Visibility.PUBLIC_LITERAL;
		} else {
			oldValue = Visibility.PRIVATE_LITERAL;
		}

		Visibility newValue = configurable ? Visibility.PUBLIC_EDITABLE_LITERAL
				: Visibility.PUBLIC_LITERAL;

		if (previouslyExported == null) {

			Exported exported = null;
			Unit unit = null;
			if (source instanceof Unit) {
				exported = CoreFactory.eINSTANCE.createExportedUnit();
			} else {
				exported = CoreFactory.eINSTANCE.createExported();
			}

			exported.setPath(source.getFullPath());
			exported.setConfigurable(configurable);
			exported.setLinkable(true);

			if (source instanceof Unit) {
				getExportedUnits().add(exported);
			} else {

				DeployModelObject container = source.getParent();
				while (container != null && !(container instanceof Unit)) {
					container = container.getParent();
				}
				if (container != null && container instanceof Unit) {

					Unit parent = (Unit) container;
					ExportedUnit exportedUnit = (ExportedUnit) findExported(parent, false);
					unit = parent;
					if (exportedUnit == null) {
						exportedUnit = CoreFactory.eINSTANCE.createExportedUnit();

						exportedUnit.setName(parent.getName());
						exportedUnit.setPath(parent.getFullPath());
						applyPolicy(unit, exportedUnit);
						getExportedUnits().add(exportedUnit);
					}

					if (source instanceof Capability) {
						exportedUnit.getExportedCapabilities().add(exported);
					} else if (source instanceof Requirement) {
						exportedUnit.getExportedRequirements().add(exported);
					}
				}
			}
		} else {
			previouslyExported.setLinkable(true);
			previouslyExported.setConfigurable(configurable);
		}

		switch (oldValue.getValue())
		{
		case Visibility.PRIVATE:
		case Visibility.PUBLIC:
			if (configurable) {
				clearProperties(source);
			}
			break;
		case Visibility.PUBLIC_EDITABLE:
			if (!configurable) {
				clearProperties(source);
			}
			break;

		}
		fireVisibilityChanged(source, oldValue, newValue);

	}

	public void export(DeployModelObject source, EStructuralFeature feature) {
		export(source, feature.getName());
	}

	private void applyPolicy(Unit source, ExportedUnit exported) {
		Visibility policy = null;
		if (source.isConceptual()) {
			policy = defaultConceptualPolicy;
		} else {
			policy = defaultPolicy;
		}

		switch (policy.getValue())
		{
		case Visibility.PRIVATE:
			exported.setLinkable(false);
			exported.setConfigurable(false);
			break;
		case Visibility.PUBLIC:
			exported.setLinkable(true);
			exported.setConfigurable(false);
			break;
		case Visibility.PUBLIC_EDITABLE:
			exported.setLinkable(true);
			exported.setConfigurable(true);
			break;
		}
	}

	public void export(DeployModelObject source, String propertyName) {

		if (source instanceof Import) {
			IllegalStateException ex = new IllegalStateException(
					"Cannot re-export specific properties from an Import."); //$NON-NLS-1$
			DeployCorePlugin.logError(0, ex.getMessage(), ex);
			return;
		}

		// search for a related import
		if (getEditTopology() != null) {
			Import imported = getEditTopology().getImport(source.getFullPath());
			if (imported != null) {
				IllegalStateException ex = new IllegalStateException(
						"Cannot re-export specific properties from imported model elements."); //$NON-NLS-1$
				DeployCorePlugin.logError(0, ex.getMessage(), ex);
				return;
			}
		}

		String path = computePath(source, propertyName);

		ExportedUnit exported = null;
		if (source instanceof Unit) {
			exported = (ExportedUnit) findExported(source, false);
		} else {
			DeployModelObject container = source.getParent();
			while (container != null && !(container instanceof Unit)) {
				container = container.getParent();
			}
			if (container != null && container instanceof Unit) {
				exported = (ExportedUnit) findExported(container, false);
			}
		}

		if (exported == null) {

			exported = CoreFactory.eINSTANCE.createExportedUnit();
			Unit unit = null;
			if (source instanceof Unit) {
				exported.setPath(source.getFullPath());
				unit = (Unit) source;
			} else {
				Object container = source.getParent();
				while (container != null && !(container instanceof Unit)) {
					container = source.getParent();
				}
				if (container != null && container instanceof Unit) {
					exported.setPath(((Unit) container).getFullPath());
					unit = (Unit) source.getParent();
				}
			}
			applyPolicy(unit, exported);
			getExportedUnits().add(exported);
		}

		Property exportedProperty = findProperty(path, exported.getExportedProperties());
		if (!exported.isConfigurable()) {
			if (exportedProperty == null) {
				Property property = CoreFactory.eINSTANCE.createProperty();
				property.setSelect(path);
				exported.getExportedProperties().add(property);
			}
		} else {

			final String fullPath = computePath(source, propertyName);
			for (Iterator<Property> props = exported.getExportedProperties().iterator(); props
					.hasNext();) {
				Property found = props.next();
				if (fullPath.equals(found.getSelect())) {
					props.remove();
					fireUnexportedProperty(source, propertyName);
					break; // leave for loop
				}
			}
		}

		fireExportedProperty(source, propertyName);
	}

	private String computePath(DeployModelObject source, String propertyName) {
		return source.getFullPath() + IConstants.ATTRIBUTE_SEPARATOR + propertyName;
	}

	public void unexport(DeployModelObject source) {

		String path = source.getFullPath();

		if (source instanceof Import) {
			Import imported = (Import) source;
			if (isReexported(imported)) {
				((Import) source).setReexported(false);
				fireVisibilityChanged(source, Visibility.PUBLIC_LITERAL, Visibility.PRIVATE_LITERAL);
			}
			return;
		}

		// search for a related import
		if (getEditTopology() != null) {
			Import imported = getEditTopology().getImport(path);
			if (imported != null) {
				IllegalStateException err = new IllegalStateException(NLS.bind(
						DeployCoreMessages.ExplicitContractImpl_Cannot_export_0_because_it_is_not_,
						source.getFullPath()));
				DeployCorePlugin.logError(0, err.getMessage(), err);
			}
		}

		Visibility oldValue = Visibility.PUBLIC_LITERAL;
		Visibility newValue = Visibility.PRIVATE_LITERAL;

		if (source instanceof Unit) {

			ExportedUnit exportedUnit = (ExportedUnit) findExported(source, false);
			if (exportedUnit == null) {
				exportedUnit = CoreFactory.eINSTANCE.createExportedUnit();
				exportedUnit.setPath(source.getFullPath());

				oldValue = ((Unit) source).isConceptual() ? getDefaultConceptualPolicy()
						: getDefaultPolicy();
			} else {

				oldValue = exportedUnit.isLinkable() ? exportedUnit.isConfigurable() ? Visibility.PUBLIC_EDITABLE_LITERAL
						: Visibility.PUBLIC_LITERAL
						: Visibility.PRIVATE_LITERAL;
			}

			exportedUnit.setLinkable(false);
			exportedUnit.setConfigurable(false);

			getExportedUnits().add(exportedUnit);

		} else {

			boolean parentCreated = false;

			DeployModelObject container = source.getParent();
			while (container != null && !(container instanceof Unit)) {
				container = container.getParent();
			}
			if (container != null && container instanceof Unit) {

				Unit parent = (Unit) container;

				ExportedUnit exportedParent = (ExportedUnit) findExported(parent, false);
				if (exportedParent == null) {
					exportedParent = CoreFactory.eINSTANCE.createExportedUnit();
					exportedParent.setPath(parent.getFullPath());
					getExportedUnits().add(exportedParent);
					parentCreated = true;
				}

				Exported exported = null;
				if (source instanceof Capability) {
					exported = findExported(source.getFullPath(), exportedParent
							.getExportedCapabilities());
				} else if (source instanceof Requirement) {
					exported = findExported(source.getFullPath(), exportedParent
							.getExportedRequirements());
				}

				if (exported == null) {
					exported = CoreFactory.eINSTANCE.createExported();
					exported.setPath(source.getFullPath());

					if (source instanceof Capability) {
						exportedParent.getExportedCapabilities().add(exported);
					} else if (source instanceof Requirement) {
						exportedParent.getExportedRequirements().add(exported);
					}

					if (parentCreated) { // default to policy

						oldValue = parent.isConceptual() ? getDefaultConceptualPolicy()
								: getDefaultPolicy();
					} else { // inherit from parent
						oldValue = exportedParent.isLinkable() ? exportedParent.isConfigurable() ? Visibility.PUBLIC_EDITABLE_LITERAL
								: Visibility.PUBLIC_LITERAL
								: Visibility.PRIVATE_LITERAL;
					}
				} else {

					oldValue = exported.isLinkable() ? exported.isConfigurable() ? Visibility.PUBLIC_EDITABLE_LITERAL
							: Visibility.PUBLIC_LITERAL
							: Visibility.PRIVATE_LITERAL;
				}

				exported.setConfigurable(false);
				exported.setLinkable(false);
			}

		}

		if (oldValue == Visibility.PUBLIC_EDITABLE_LITERAL) {
			clearProperties(source);
		}
		fireVisibilityChanged(source, oldValue, newValue);
	}

	public void unexport(DeployModelObject source, EStructuralFeature feature) {
		unexport(source, feature.getName());
	}

	public void unexport(DeployModelObject source, String propertyName) {

		if (source instanceof Import) {
			IllegalStateException err = new IllegalStateException(NLS.bind(
					DeployCoreMessages.ExplicitContractImpl_Cannot_export_0_because_it_is_not_, source
							.getFullPath()));
			DeployCorePlugin.logError(0, err.getMessage(), err);
			return;
		}

		// search for a related import
		if (getEditTopology() != null) {
			Import imported = getEditTopology().getImport(source.getFullPath());
			if (imported != null) {
				IllegalStateException err = new IllegalStateException(NLS.bind(
						DeployCoreMessages.ExplicitContractImpl_Cannot_export_0_because_it_is_not_,
						source.getFullPath()));
				DeployCorePlugin.logError(0, err.getMessage(), err);
				return;
			}
		}

		ExportedUnit exported = null;
		if (source instanceof Unit) {
			exported = (ExportedUnit) findExported(source, false);
		} else {
			Object container = source.getParent();
			while (container != null && !(container instanceof Unit)) {
				container = source.getParent();
			}
			if (container != null && container instanceof Unit) {
				exported = (ExportedUnit) findExported((Unit) container, false);
			}
		}

		if (exported != null) {
			final String fullPath = computePath(source, propertyName);
			Property found = null;
			if (!exported.isConfigurable()) {
				for (Iterator<Property> props = exported.getExportedProperties().iterator(); props
						.hasNext();) {
					found = props.next();
					if (fullPath.equals(found.getSelect())) {
						props.remove();
						fireUnexportedProperty(source, propertyName);
						break; // leave for loop
					}
				}
			} else {
				found = findProperty(fullPath, exported.getExportedProperties());
				if (found == null) {
					found = CoreFactory.eINSTANCE.createProperty();
					found.setSelect(fullPath);
					exported.getExportedProperties().add(found);
					fireUnexportedProperty(source, propertyName);
				}
			}
		}
	}

	public void unexportProperty(String propertyName) {
		Assert.isNotNull(propertyName);

		for (Iterator props = getProperties().iterator(); props.hasNext();) {
			Property prop = (Property) props.next();
			if (propertyName.equals(prop.getName())) {
				props.remove();
				fireUnexportedGlobalProperty(getTopology(), prop);
				return;
			}
		}
	}

	public boolean isPublicEditable(DeployModelObject source, String propertyName) {
		// Don't consider Topologies to be public-editable
		if (source instanceof Topology) {
			return false;
		}

		if (source instanceof Import) {
			return false;
		}

		// search for a related import
		if (getEditTopology() != null) {
			Import imported = getEditTopology().getImport(source.getFullPath());
			if (imported != null) {
				return false; // re-exported units are not public-editable
			}
		}

		String path = computePath(source, propertyName);
		// TODO Will need to change this after we move ExportedUnit.getExportedProperties() up
		ExportedUnit exportedUnit = null;
		Exported exportedSource = null;
		Unit container = findUnit(source);
		if (container != null) {
			exportedUnit = (ExportedUnit) findExported(container, false);
			exportedSource = findExported(source, false);
		}

		if (exportedUnit != null) {
			Property exportedProperty = findProperty(path, exportedUnit.getExportedProperties());
			// properties, if defined are always configurable
			if (exportedProperty != null) {
				return !exportedUnit.isConfigurable(); // return the inverse of the parent's configurable status
			}
			/* return the parent's configurable status */
			return exportedSource != null ? exportedSource.isConfigurable() : exportedUnit
					.isConfigurable();
		}
		return isPublicEditable(source);
	}

	private Unit findUnit(DeployModelObject source) {
		if (source == null || !(source instanceof DeployModelObject)) {
			return null;
		}
		if (source instanceof Topology) {
			return null;
		}
		if (source instanceof Unit) {
			return (Unit) source;
		}
		return findUnit(source.getParent());

	}

	@Override
	public List<Property> getGlobalProperties() {
		return getProperties();
	}

	public void clear(DeployModelObject source) {
		Exported exported = findExported(source, false);
		if (exported != null) {
			EcoreUtil.remove(exported);
		}
	}

	public Property getProperty(String property) {
		Assert.isNotNull(property);
		for (Iterator<Property> iterator = getGlobalProperties().iterator(); iterator.hasNext();) {
			Property next = iterator.next();
			if (property.equals(next.getName())) {
				return next;
			}
		}
		return null;
	}

	private Exported findExported(DeployModelObject source, boolean returnParentIfNotFound) {
		// same container
		if (source == null) {
			return null;
		}
		int indx = -1;
		String path = source.getFullPath();
		Assert.isNotNull(path);
		if ((indx = path.indexOf(IConstants.TOPOLOGY_SEPARATOR)) > -1 && path.length() > indx) {
			path = path.substring(indx + 1);
		}

		if (path.length() > 0) {
			IPath relative = new Path(path);

			ExportedUnit unit = (ExportedUnit) findExported(IConstants.PATH_SEPARATOR
					+ relative.segment(0), getExportedUnits());
			if (relative.segmentCount() == 1) {
				return unit;
				// else relative.segmentCount() > 1
			}

			Exported exported = null;

			if (unit != null) {
				String unitChildPath = IConstants.PATH_SEPARATOR + relative.segment(0)
						+ IConstants.PATH_SEPARATOR + relative.segment(1);
				exported = findExported(unitChildPath, unit.getExportedCapabilities());
				if (exported == null) {
					exported = findExported(unitChildPath, unit.getExportedRequirements());
				}
			}
			return exported == null && returnParentIfNotFound ? unit : exported;
		}
		DeployCorePlugin.logError(0, "Invalid Path encountered.", null); //$NON-NLS-1$ 
		return null;

	}

	private Exported findExported(String path, List search) {
		for (Iterator exportedItr = search.iterator(); exportedItr.hasNext();) {
			Exported exported = (Exported) exportedItr.next();
			if (path.equals(exported.getPath())) {
				return exported;
			}
		}
		return null;
	}

	private Property findProperty(String path, List search) {
		for (Iterator propertyItr = search.iterator(); propertyItr.hasNext();) {
			Property property = (Property) propertyItr.next();
			if (path.equals(property.getSelect())) {
				return property;
			}
		}
		return null;
	}

	private void clearProperties(DeployModelObject source) {
		Unit container = findContainer(source);
		if (container != null) {

			ExportedUnit exportedUnit = (ExportedUnit) findExported(container, false);
			if (exportedUnit != null) {

				if (container == source) {
					exportedUnit.getExportedCapabilities().clear();
					exportedUnit.getExportedRequirements().clear();
					exportedUnit.getExportedProperties().clear();
				} else {

					String fullPath = source.getFullPath();
					String topologyPath = source.getTopology().getFullPath();
					String relativePath = IConstants.PATH_SEPARATOR
							+ fullPath.substring(topologyPath.length()) + IConstants.ATTRIBUTE_SEPARATOR;

					List eProperties = exportedUnit.getExportedProperties();
					for (Iterator iterator = eProperties.iterator(); iterator.hasNext();) {
						Property property = (Property) iterator.next();
						String select = property.getSelect();
						if (select != null && select.startsWith(relativePath)) {
							iterator.remove();
						}
					}
				}
			}
		}
	}

} // ExplicitContractImpl
