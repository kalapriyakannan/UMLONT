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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.core.Import;
import com.ibm.ccl.soa.deploy.core.InstanceConfiguration;
import com.ibm.ccl.soa.deploy.core.Topology;
import com.ibm.ccl.soa.deploy.core.namespace.INamespaceElement;
import com.ibm.ccl.soa.deploy.internal.core.extension.IScopeService;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.InternalInstanceConfiguration;
import com.ibm.ccl.soa.deploy.internal.core.topologyimport.InternalScopeService;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Import</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.ImportImpl#getInstanceConfiguration <em>Instance Configuration</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.ImportImpl#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.ImportImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.ImportImpl#isReexported <em>Reexported</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImportImpl extends DeployModelObjectImpl implements Import {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getInstanceConfiguration() <em>Instance Configuration</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInstanceConfiguration()
	 * @generated
	 * @ordered
	 */
	protected InstanceConfiguration instanceConfiguration;

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

	/**
	 * The default value of the '{@link #getPattern() <em>Pattern</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected static final String PATTERN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPattern() <em>Pattern</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPattern()
	 * @generated
	 * @ordered
	 */
	protected String pattern = PATTERN_EDEFAULT;

	/**
	 * The default value of the '{@link #isReexported() <em>Reexported</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isReexported()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REEXPORTED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReexported() <em>Reexported</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isReexported()
	 * @generated
	 * @ordered
	 */
	protected boolean reexported = REEXPORTED_EDEFAULT;

	/**
	 * This is true if the Reexported attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean reexportedESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ImportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.IMPORT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceConfiguration getInstanceConfiguration() {
		return instanceConfiguration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInstanceConfiguration(
			InstanceConfiguration newInstanceConfiguration, NotificationChain msgs) {
		InstanceConfiguration oldInstanceConfiguration = instanceConfiguration;
		instanceConfiguration = newInstanceConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.IMPORT__INSTANCE_CONFIGURATION, oldInstanceConfiguration, newInstanceConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstanceConfiguration(InstanceConfiguration newInstanceConfiguration) {
		if (newInstanceConfiguration != instanceConfiguration) {
			NotificationChain msgs = null;
			if (instanceConfiguration != null)
				msgs = ((InternalEObject)instanceConfiguration).eInverseRemove(this, CorePackage.INSTANCE_CONFIGURATION__IMPORTED, InstanceConfiguration.class, msgs);
			if (newInstanceConfiguration != null)
				msgs = ((InternalEObject)newInstanceConfiguration).eInverseAdd(this, CorePackage.INSTANCE_CONFIGURATION__IMPORTED, InstanceConfiguration.class, msgs);
			msgs = basicSetInstanceConfiguration(newInstanceConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.IMPORT__INSTANCE_CONFIGURATION, newInstanceConfiguration, newInstanceConfiguration));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getNamespace() {
		return namespace;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamespace(String newNamespace) {
		String oldNamespace = namespace;
		namespace = newNamespace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.IMPORT__NAMESPACE, oldNamespace, namespace));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getPattern() {
		return pattern;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPattern(String newPattern) {
		String oldPattern = pattern;
		pattern = newPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.IMPORT__PATTERN, oldPattern, pattern));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReexported() {
		return reexported;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setReexported(boolean newReexported) {
		boolean oldReexported = reexported;
		reexported = newReexported;
		boolean oldReexportedESet = reexportedESet;
		reexportedESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.IMPORT__REEXPORTED, oldReexported, reexported, !oldReexportedESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetReexported() {
		boolean oldReexported = reexported;
		boolean oldReexportedESet = reexportedESet;
		reexported = REEXPORTED_EDEFAULT;
		reexportedESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, CorePackage.IMPORT__REEXPORTED, oldReexported, REEXPORTED_EDEFAULT, oldReexportedESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetReexported() {
		return reexportedESet;
	}

	/**
	 * <!-- begin-user-doc --> Resolves the import and returns the topology associated with the
	 * import
	 * 
	 * @return the imported topology <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Topology resolveImport() {
		if (getTopology() != null) {
			InternalScopeService scopeService = (InternalScopeService) IScopeService.Locator
					.findScopeService(getTopology());
			if (scopeService != null) {
				return scopeService.resolve(this);
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.IMPORT__INSTANCE_CONFIGURATION:
				if (instanceConfiguration != null)
					msgs = ((InternalEObject)instanceConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CorePackage.IMPORT__INSTANCE_CONFIGURATION, null, msgs);
				return basicSetInstanceConfiguration((InstanceConfiguration)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
			NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.IMPORT__INSTANCE_CONFIGURATION:
				return basicSetInstanceConfiguration(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.IMPORT__INSTANCE_CONFIGURATION:
				return getInstanceConfiguration();
			case CorePackage.IMPORT__NAMESPACE:
				return getNamespace();
			case CorePackage.IMPORT__PATTERN:
				return getPattern();
			case CorePackage.IMPORT__REEXPORTED:
				return isReexported() ? Boolean.TRUE : Boolean.FALSE;
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CorePackage.IMPORT__INSTANCE_CONFIGURATION:
				setInstanceConfiguration((InstanceConfiguration)newValue);
				return;
			case CorePackage.IMPORT__NAMESPACE:
				setNamespace((String)newValue);
				return;
			case CorePackage.IMPORT__PATTERN:
				setPattern((String)newValue);
				return;
			case CorePackage.IMPORT__REEXPORTED:
				setReexported(((Boolean)newValue).booleanValue());
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
			case CorePackage.IMPORT__INSTANCE_CONFIGURATION:
				setInstanceConfiguration((InstanceConfiguration)null);
				return;
			case CorePackage.IMPORT__NAMESPACE:
				setNamespace(NAMESPACE_EDEFAULT);
				return;
			case CorePackage.IMPORT__PATTERN:
				setPattern(PATTERN_EDEFAULT);
				return;
			case CorePackage.IMPORT__REEXPORTED:
				unsetReexported();
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
			case CorePackage.IMPORT__INSTANCE_CONFIGURATION:
				return instanceConfiguration != null;
			case CorePackage.IMPORT__NAMESPACE:
				return NAMESPACE_EDEFAULT == null ? namespace != null : !NAMESPACE_EDEFAULT.equals(namespace);
			case CorePackage.IMPORT__PATTERN:
				return PATTERN_EDEFAULT == null ? pattern != null : !PATTERN_EDEFAULT.equals(pattern);
			case CorePackage.IMPORT__REEXPORTED:
				return isSetReexported();
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
		result.append(" (namespace: "); //$NON-NLS-1$
		result.append(namespace);
		result.append(", pattern: "); //$NON-NLS-1$
		result.append(pattern);
		result.append(", reexported: "); //$NON-NLS-1$
		if (reexportedESet) result.append(reexported); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

	/*
	 * public String getName() { if(namespace == null && pattern == null){ return UNSET_STRING; }
	 * return (namespace != null && namespace.length() > 0 ? namespace + '.' : EMPTY_STRING) +
	 * (pattern != null ? pattern : EMPTY_STRING); }
	 */

	protected void eBasicSetContainer(InternalEObject newContainer, int newContainerFeatureID) {
		super.eBasicSetContainer(newContainer, newContainerFeatureID);
		if (getInstanceConfiguration() != null) {
			InternalInstanceConfiguration config = (InternalInstanceConfiguration) getInstanceConfiguration();
			config.updateScopeService();
		}
	}

	/**
	 * Returns true if the given namespace and a pattern match the current Import's attributes.
	 * 
	 * @param namespace
	 *           The namespace with NO trailing dot.
	 * @param pattern
	 *           The pattern (topology name without a file extension).
	 * @return
	 */
	public boolean equals(String otherNamespace, String otherPattern) {

		if (isDefaultNamespace(namespace) ^ isDefaultNamespace(otherNamespace)) {
			return false;
		} else if (!isDefaultNamespace(namespace) && !namespace.equals(otherNamespace)) {
			return false;
		}
		if (pattern == null ^ otherPattern == null) {
			return false;
		}
		return pattern != null ? pattern.equals(otherPattern) : otherPattern == null;
	}

	private boolean isDefaultNamespace(String ns) {
		return ns == null || INamespaceElement.DEFAULT_NAMESPACE.equals(ns);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.ccl.soa.deploy.core.Import#isReferencingMe(java.lang.String)
	 */
	public boolean isReferencingMe(String uri) {
		if (uri == null || uri.equals("") || uri.indexOf(":") == -1) { //$NON-NLS-1$ //$NON-NLS-2$
			return false;
		}
		String name = uri.substring(0, uri.indexOf(":")); //$NON-NLS-1$
		String namespace = ""; //$NON-NLS-1$

		int lastDot = name.lastIndexOf("."); //$NON-NLS-1$
		if (lastDot != -1) { //Find the namespace and name
			namespace = name.substring(0, lastDot);
			name = name.substring(lastDot + 1);
		}

		if (name.equals(getPattern()) && namespace.equals(getNamespace())) {
			return true;
		}

		return false;
	}

	public String getQualifiedImport() {
		if (getNamespace() == null || getNamespace().trim().length() == 0) {
			return getPattern();
		}
		return getNamespace() + IConstants.DOT_SEPARATOR + getPattern();
	}

} //ImportImpl
