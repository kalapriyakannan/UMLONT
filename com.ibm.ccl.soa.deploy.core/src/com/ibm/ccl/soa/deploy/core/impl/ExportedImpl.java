/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.Exported;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Exported</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.ExportedImpl#isConfigurable <em>Configurable</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.ExportedImpl#isLinkable <em>Linkable</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.ExportedImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.ExportedImpl#getPath <em>Path</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExportedImpl extends EObjectImpl implements Exported {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #isConfigurable() <em>Configurable</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isConfigurable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CONFIGURABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isConfigurable() <em>Configurable</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isConfigurable()
	 * @generated
	 * @ordered
	 */
	protected boolean configurable = CONFIGURABLE_EDEFAULT;

	/**
	 * This is true if the Configurable attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean configurableESet;

	/**
	 * The default value of the '{@link #isLinkable() <em>Linkable</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isLinkable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LINKABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isLinkable() <em>Linkable</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isLinkable()
	 * @generated
	 * @ordered
	 */
	protected boolean linkable = LINKABLE_EDEFAULT;

	/**
	 * This is true if the Linkable attribute has been set. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean linkableESet;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected String path = PATH_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ExportedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.EXPORTED;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isConfigurable() {
		return configurable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfigurable(boolean newConfigurable) {
		boolean oldConfigurable = configurable;
		configurable = newConfigurable;
		boolean oldConfigurableESet = configurableESet;
		configurableESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.EXPORTED__CONFIGURABLE, oldConfigurable, configurable, !oldConfigurableESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetConfigurable() {
		boolean oldConfigurable = configurable;
		boolean oldConfigurableESet = configurableESet;
		configurable = CONFIGURABLE_EDEFAULT;
		configurableESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, CorePackage.EXPORTED__CONFIGURABLE, oldConfigurable, CONFIGURABLE_EDEFAULT, oldConfigurableESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetConfigurable() {
		return configurableESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLinkable() {
		return linkable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkable(boolean newLinkable) {
		boolean oldLinkable = linkable;
		linkable = newLinkable;
		boolean oldLinkableESet = linkableESet;
		linkableESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.EXPORTED__LINKABLE, oldLinkable, linkable, !oldLinkableESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetLinkable() {
		boolean oldLinkable = linkable;
		boolean oldLinkableESet = linkableESet;
		linkable = LINKABLE_EDEFAULT;
		linkableESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, CorePackage.EXPORTED__LINKABLE, oldLinkable, LINKABLE_EDEFAULT, oldLinkableESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetLinkable() {
		return linkableESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.EXPORTED__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getPath() {
		return path;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPath(String newPath) {
		String oldPath = path;
		path = newPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.EXPORTED__PATH, oldPath, path));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.EXPORTED__CONFIGURABLE:
				return isConfigurable() ? Boolean.TRUE : Boolean.FALSE;
			case CorePackage.EXPORTED__LINKABLE:
				return isLinkable() ? Boolean.TRUE : Boolean.FALSE;
			case CorePackage.EXPORTED__NAME:
				return getName();
			case CorePackage.EXPORTED__PATH:
				return getPath();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CorePackage.EXPORTED__CONFIGURABLE:
				setConfigurable(((Boolean)newValue).booleanValue());
				return;
			case CorePackage.EXPORTED__LINKABLE:
				setLinkable(((Boolean)newValue).booleanValue());
				return;
			case CorePackage.EXPORTED__NAME:
				setName((String)newValue);
				return;
			case CorePackage.EXPORTED__PATH:
				setPath((String)newValue);
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
			case CorePackage.EXPORTED__CONFIGURABLE:
				unsetConfigurable();
				return;
			case CorePackage.EXPORTED__LINKABLE:
				unsetLinkable();
				return;
			case CorePackage.EXPORTED__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CorePackage.EXPORTED__PATH:
				setPath(PATH_EDEFAULT);
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
			case CorePackage.EXPORTED__CONFIGURABLE:
				return isSetConfigurable();
			case CorePackage.EXPORTED__LINKABLE:
				return isSetLinkable();
			case CorePackage.EXPORTED__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CorePackage.EXPORTED__PATH:
				return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
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
		result.append(" (configurable: "); //$NON-NLS-1$
		if (configurableESet) result.append(configurable); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", linkable: "); //$NON-NLS-1$
		if (linkableESet) result.append(linkable); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", path: "); //$NON-NLS-1$
		result.append(path);
		result.append(')');
		return result.toString();
	}

} //ExportedImpl
