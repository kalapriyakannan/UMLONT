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

import com.ibm.ccl.soa.deploy.core.AttributeMetaData;
import com.ibm.ccl.soa.deploy.core.CorePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Attribute Meta Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.AttributeMetaDataImpl#getAttributeName <em>Attribute Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.AttributeMetaDataImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.AttributeMetaDataImpl#isEncrypted <em>Encrypted</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.AttributeMetaDataImpl#isEncryptionRequired <em>Encryption Required</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.AttributeMetaDataImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.AttributeMetaDataImpl#isMutable <em>Mutable</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.AttributeMetaDataImpl#isOptional <em>Optional</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.impl.AttributeMetaDataImpl#isParameter <em>Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeMetaDataImpl extends EObjectImpl implements AttributeMetaData {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The default value of the '{@link #getAttributeName() <em>Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAttributeName()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTRIBUTE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttributeName() <em>Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getAttributeName()
	 * @generated
	 * @ordered
	 */
	protected String attributeName = ATTRIBUTE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #isEncrypted() <em>Encrypted</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isEncrypted()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENCRYPTED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEncrypted() <em>Encrypted</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isEncrypted()
	 * @generated
	 * @ordered
	 */
	protected boolean encrypted = ENCRYPTED_EDEFAULT;

	/**
	 * This is true if the Encrypted attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean encryptedESet;

	/**
	 * The default value of the '{@link #isEncryptionRequired() <em>Encryption Required</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isEncryptionRequired()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENCRYPTION_REQUIRED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEncryptionRequired() <em>Encryption Required</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isEncryptionRequired()
	 * @generated
	 * @ordered
	 */
	protected boolean encryptionRequired = ENCRYPTION_REQUIRED_EDEFAULT;

	/**
	 * This is true if the Encryption Required attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean encryptionRequiredESet;

	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * The default value of the '{@link #isMutable() <em>Mutable</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isMutable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MUTABLE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isMutable() <em>Mutable</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isMutable()
	 * @generated
	 * @ordered
	 */
	protected boolean mutable = MUTABLE_EDEFAULT;

	/**
	 * This is true if the Mutable attribute has been set. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean mutableESet;

	/**
	 * The default value of the '{@link #isOptional() <em>Optional</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isOptional()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OPTIONAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOptional() <em>Optional</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isOptional()
	 * @generated
	 * @ordered
	 */
	protected boolean optional = OPTIONAL_EDEFAULT;

	/**
	 * This is true if the Optional attribute has been set. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	protected boolean optionalESet;

	/**
	 * The default value of the '{@link #isParameter() <em>Parameter</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isParameter()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PARAMETER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isParameter() <em>Parameter</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isParameter()
	 * @generated
	 * @ordered
	 */
	protected boolean parameter = PARAMETER_EDEFAULT;

	/**
	 * This is true if the Parameter attribute has been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean parameterESet;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeMetaDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.ATTRIBUTE_META_DATA;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getAttributeName() {
		return attributeName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeName(String newAttributeName) {
		String oldAttributeName = attributeName;
		attributeName = newAttributeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ATTRIBUTE_META_DATA__ATTRIBUTE_NAME, oldAttributeName, attributeName));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ATTRIBUTE_META_DATA__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEncrypted() {
		return encrypted;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setEncrypted(boolean newEncrypted) {
		boolean oldEncrypted = encrypted;
		encrypted = newEncrypted;
		boolean oldEncryptedESet = encryptedESet;
		encryptedESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ATTRIBUTE_META_DATA__ENCRYPTED, oldEncrypted, encrypted, !oldEncryptedESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEncrypted() {
		boolean oldEncrypted = encrypted;
		boolean oldEncryptedESet = encryptedESet;
		encrypted = ENCRYPTED_EDEFAULT;
		encryptedESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, CorePackage.ATTRIBUTE_META_DATA__ENCRYPTED, oldEncrypted, ENCRYPTED_EDEFAULT, oldEncryptedESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEncrypted() {
		return encryptedESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEncryptionRequired() {
		return encryptionRequired;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setEncryptionRequired(boolean newEncryptionRequired) {
		boolean oldEncryptionRequired = encryptionRequired;
		encryptionRequired = newEncryptionRequired;
		boolean oldEncryptionRequiredESet = encryptionRequiredESet;
		encryptionRequiredESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ATTRIBUTE_META_DATA__ENCRYPTION_REQUIRED, oldEncryptionRequired, encryptionRequired, !oldEncryptionRequiredESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetEncryptionRequired() {
		boolean oldEncryptionRequired = encryptionRequired;
		boolean oldEncryptionRequiredESet = encryptionRequiredESet;
		encryptionRequired = ENCRYPTION_REQUIRED_EDEFAULT;
		encryptionRequiredESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, CorePackage.ATTRIBUTE_META_DATA__ENCRYPTION_REQUIRED, oldEncryptionRequired, ENCRYPTION_REQUIRED_EDEFAULT, oldEncryptionRequiredESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetEncryptionRequired() {
		return encryptionRequiredESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ATTRIBUTE_META_DATA__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMutable() {
		return mutable;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMutable(boolean newMutable) {
		boolean oldMutable = mutable;
		mutable = newMutable;
		boolean oldMutableESet = mutableESet;
		mutableESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ATTRIBUTE_META_DATA__MUTABLE, oldMutable, mutable, !oldMutableESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetMutable() {
		boolean oldMutable = mutable;
		boolean oldMutableESet = mutableESet;
		mutable = MUTABLE_EDEFAULT;
		mutableESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, CorePackage.ATTRIBUTE_META_DATA__MUTABLE, oldMutable, MUTABLE_EDEFAULT, oldMutableESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetMutable() {
		return mutableESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOptional() {
		return optional;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptional(boolean newOptional) {
		boolean oldOptional = optional;
		optional = newOptional;
		boolean oldOptionalESet = optionalESet;
		optionalESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ATTRIBUTE_META_DATA__OPTIONAL, oldOptional, optional, !oldOptionalESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetOptional() {
		boolean oldOptional = optional;
		boolean oldOptionalESet = optionalESet;
		optional = OPTIONAL_EDEFAULT;
		optionalESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, CorePackage.ATTRIBUTE_META_DATA__OPTIONAL, oldOptional, OPTIONAL_EDEFAULT, oldOptionalESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetOptional() {
		return optionalESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isParameter() {
		return parameter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameter(boolean newParameter) {
		boolean oldParameter = parameter;
		parameter = newParameter;
		boolean oldParameterESet = parameterESet;
		parameterESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.ATTRIBUTE_META_DATA__PARAMETER, oldParameter, parameter, !oldParameterESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetParameter() {
		boolean oldParameter = parameter;
		boolean oldParameterESet = parameterESet;
		parameter = PARAMETER_EDEFAULT;
		parameterESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, CorePackage.ATTRIBUTE_META_DATA__PARAMETER, oldParameter, PARAMETER_EDEFAULT, oldParameterESet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetParameter() {
		return parameterESet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.ATTRIBUTE_META_DATA__ATTRIBUTE_NAME:
				return getAttributeName();
			case CorePackage.ATTRIBUTE_META_DATA__DESCRIPTION:
				return getDescription();
			case CorePackage.ATTRIBUTE_META_DATA__ENCRYPTED:
				return isEncrypted() ? Boolean.TRUE : Boolean.FALSE;
			case CorePackage.ATTRIBUTE_META_DATA__ENCRYPTION_REQUIRED:
				return isEncryptionRequired() ? Boolean.TRUE : Boolean.FALSE;
			case CorePackage.ATTRIBUTE_META_DATA__LABEL:
				return getLabel();
			case CorePackage.ATTRIBUTE_META_DATA__MUTABLE:
				return isMutable() ? Boolean.TRUE : Boolean.FALSE;
			case CorePackage.ATTRIBUTE_META_DATA__OPTIONAL:
				return isOptional() ? Boolean.TRUE : Boolean.FALSE;
			case CorePackage.ATTRIBUTE_META_DATA__PARAMETER:
				return isParameter() ? Boolean.TRUE : Boolean.FALSE;
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CorePackage.ATTRIBUTE_META_DATA__ATTRIBUTE_NAME:
				setAttributeName((String)newValue);
				return;
			case CorePackage.ATTRIBUTE_META_DATA__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case CorePackage.ATTRIBUTE_META_DATA__ENCRYPTED:
				setEncrypted(((Boolean)newValue).booleanValue());
				return;
			case CorePackage.ATTRIBUTE_META_DATA__ENCRYPTION_REQUIRED:
				setEncryptionRequired(((Boolean)newValue).booleanValue());
				return;
			case CorePackage.ATTRIBUTE_META_DATA__LABEL:
				setLabel((String)newValue);
				return;
			case CorePackage.ATTRIBUTE_META_DATA__MUTABLE:
				setMutable(((Boolean)newValue).booleanValue());
				return;
			case CorePackage.ATTRIBUTE_META_DATA__OPTIONAL:
				setOptional(((Boolean)newValue).booleanValue());
				return;
			case CorePackage.ATTRIBUTE_META_DATA__PARAMETER:
				setParameter(((Boolean)newValue).booleanValue());
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
			case CorePackage.ATTRIBUTE_META_DATA__ATTRIBUTE_NAME:
				setAttributeName(ATTRIBUTE_NAME_EDEFAULT);
				return;
			case CorePackage.ATTRIBUTE_META_DATA__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case CorePackage.ATTRIBUTE_META_DATA__ENCRYPTED:
				unsetEncrypted();
				return;
			case CorePackage.ATTRIBUTE_META_DATA__ENCRYPTION_REQUIRED:
				unsetEncryptionRequired();
				return;
			case CorePackage.ATTRIBUTE_META_DATA__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case CorePackage.ATTRIBUTE_META_DATA__MUTABLE:
				unsetMutable();
				return;
			case CorePackage.ATTRIBUTE_META_DATA__OPTIONAL:
				unsetOptional();
				return;
			case CorePackage.ATTRIBUTE_META_DATA__PARAMETER:
				unsetParameter();
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
			case CorePackage.ATTRIBUTE_META_DATA__ATTRIBUTE_NAME:
				return ATTRIBUTE_NAME_EDEFAULT == null ? attributeName != null : !ATTRIBUTE_NAME_EDEFAULT.equals(attributeName);
			case CorePackage.ATTRIBUTE_META_DATA__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case CorePackage.ATTRIBUTE_META_DATA__ENCRYPTED:
				return isSetEncrypted();
			case CorePackage.ATTRIBUTE_META_DATA__ENCRYPTION_REQUIRED:
				return isSetEncryptionRequired();
			case CorePackage.ATTRIBUTE_META_DATA__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case CorePackage.ATTRIBUTE_META_DATA__MUTABLE:
				return isSetMutable();
			case CorePackage.ATTRIBUTE_META_DATA__OPTIONAL:
				return isSetOptional();
			case CorePackage.ATTRIBUTE_META_DATA__PARAMETER:
				return isSetParameter();
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
		result.append(" (attributeName: "); //$NON-NLS-1$
		result.append(attributeName);
		result.append(", description: "); //$NON-NLS-1$
		result.append(description);
		result.append(", encrypted: "); //$NON-NLS-1$
		if (encryptedESet) result.append(encrypted); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", encryptionRequired: "); //$NON-NLS-1$
		if (encryptionRequiredESet) result.append(encryptionRequired); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", label: "); //$NON-NLS-1$
		result.append(label);
		result.append(", mutable: "); //$NON-NLS-1$
		if (mutableESet) result.append(mutable); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", optional: "); //$NON-NLS-1$
		if (optionalESet) result.append(optional); else result.append("<unset>"); //$NON-NLS-1$
		result.append(", parameter: "); //$NON-NLS-1$
		if (parameterESet) result.append(parameter); else result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}

} //AttributeMetaDataImpl
