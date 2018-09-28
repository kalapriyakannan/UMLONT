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

import java.math.BigInteger;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EAttributeImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.xml.type.SimpleAnyType;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.osgi.util.NLS;

import com.ibm.ccl.soa.deploy.core.Augmentation;
import com.ibm.ccl.soa.deploy.core.CorePackage;
import com.ibm.ccl.soa.deploy.core.DeployCorePlugin;
import com.ibm.ccl.soa.deploy.core.DeployModelObject;
import com.ibm.ccl.soa.deploy.core.ExtendedAttribute;
import com.ibm.ccl.soa.deploy.core.Instantiation;
import com.ibm.ccl.soa.deploy.internal.core.DeployCoreMessages;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Extended Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.ExtendedAttributeImpl#getData <em>Data</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.core.impl.ExtendedAttributeImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @extends EAttributeImpl
 */
public class ExtendedAttributeImpl extends EAttributeImpl implements ExtendedAttribute {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation. Licensed Material - Property of IBM. All rights reserved."; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getData() <em>Data</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected EObject data;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ExtendedAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CorePackage.Literals.EXTENDED_ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object getData() {
		return data;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetData(EObject newData, NotificationChain msgs) {
		Object oldData = data;
		data = newData;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					CorePackage.EXTENDED_ATTRIBUTE__DATA, oldData, newData);
			if (msgs == null) {
				msgs = notification;
			} else {
				msgs.add(notification);
			}
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setData(Object newData) {
		if (newData != data) {
			NotificationChain msgs = null;
			if (data != null) {
				msgs = ((InternalEObject) data).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- CorePackage.EXTENDED_ATTRIBUTE__DATA, null, msgs);
			}
			if (newData != null) {
				msgs = ((InternalEObject) newData).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- CorePackage.EXTENDED_ATTRIBUTE__DATA, null, msgs);
			}
			msgs = basicSetData((EObject) newData, msgs);
			if (msgs != null) {
				msgs.dispatch();
			}
		} else if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					CorePackage.EXTENDED_ATTRIBUTE__DATA, newData, newData));
		}
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.ExtendedAttribute#getValue()
	 */
	public Object getValue() {
		if (getData() == null || !(getData() instanceof SimpleAnyType)) {
			return null;
		}

		SimpleAnyType anyData = (SimpleAnyType) getData();

		// Don't consider if there is no content to anyData
		if (anyData.getMixed().size() == 0) {
			return null;
		}

		// If there is no raw value, don't attempt to deserialize a boolean or
		// integer from it.  This still isn't completely safe, as a developer might
		// create a string-valued ExtendedAttribute "apple", then set it's type to
		// Integer, and try to read the value, but it helps against the common error of
		// trying to read an Integer/Boolean from a blank string.
		if (anyData.getRawValue().length() == 0) {
			if (anyData.getInstanceType() == XMLTypePackage.eINSTANCE.getInteger()) {
				return null;
			}
			if (anyData.getInstanceType() == XMLTypePackage.eINSTANCE.getBooleanObject()) {
				return null;
			}
			if (anyData.getInstanceType() == XMLTypePackage.eINSTANCE.getByteObject()) {
				return null;
			}
			if (anyData.getInstanceType() == XMLTypePackage.eINSTANCE.getShortObject()) {
				return null;
			}
			if (anyData.getInstanceType() == XMLTypePackage.eINSTANCE.getIntObject()) {
				return null;
			}
			if (anyData.getInstanceType() == XMLTypePackage.eINSTANCE.getLongObject()) {
				return null;
			}
			if (anyData.getInstanceType() == XMLTypePackage.eINSTANCE.getDoubleObject()) {
				return null;
			}
			if (anyData.getInstanceType() == XMLTypePackage.eINSTANCE.getFloatObject()) {
				return null;
			}
		}

		try {
			return anyData.getValue();
		} catch (RuntimeException nfe) {
			DeployCorePlugin
					.log(
							IStatus.WARNING,
							0,
							"Couldn't convert '" + anyData.getRawValue() + "' to " + anyData.getInstanceType().getName(), nfe); //$NON-NLS-1$ //$NON-NLS-2$
			return null;
		}
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.ExtendedAttribute#setValue(java.lang.Object)
	 */
	public void setValue(Object value) throws IllegalArgumentException {
		if (getData() == null || !(getData() instanceof SimpleAnyType)) {
			if (value == null) {
				return;
			}
			SimpleAnyType newData = XMLTypeFactory.eINSTANCE.createSimpleAnyType();
			if (value instanceof String) {
				newData.setInstanceType(XMLTypePackage.eINSTANCE.getString());
			} else if (value instanceof Boolean) {
				newData.setInstanceType(XMLTypePackage.eINSTANCE.getBooleanObject());
			} else if (value instanceof Byte) {
				newData.setInstanceType(XMLTypePackage.eINSTANCE.getByteObject());
			} else if (value instanceof Short) {
				newData.setInstanceType(XMLTypePackage.eINSTANCE.getShortObject());
			} else if (value instanceof Integer) {
				newData.setInstanceType(XMLTypePackage.eINSTANCE.getIntObject());
			} else if (value instanceof Long) {
				newData.setInstanceType(XMLTypePackage.eINSTANCE.getLongObject());
			} else if (value instanceof BigInteger) {
				newData.setInstanceType(XMLTypePackage.eINSTANCE.getInteger());
			} else if (value instanceof Float) {
				newData.setInstanceType(XMLTypePackage.eINSTANCE.getFloatObject());
			} else if (value instanceof Double) {
				newData.setInstanceType(XMLTypePackage.eINSTANCE.getDoubleObject());
			} else {
				throw new IllegalArgumentException(value.getClass().getName());
			}

			newData.setValue(value);
			setData(newData);
		} else {
			SimpleAnyType newData = (SimpleAnyType) getData();
			if (value != null && newData.getInstanceType() != null
					&& !newData.getInstanceType().isInstance(value)) {
				String message = NLS.bind(
						DeployCoreMessages.Extended_attribute_value_must_be_instance_of_0_not_1,
						new Object[] { newData.getInstanceType().getName(), value.getClass().getName() });
				throw new IllegalArgumentException(message);
			}
			if (value != null) {
				newData.setValue(value);
			} else {
				newData.setRawValue((String) null);
			}
			// Trigger EMF event
			// TODO trigger value event (need to create EAttribute for value)
			setData(newData);
		}
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.ExtendedAttribute#getInstanceType()
	 */
	public EDataType getInstanceType() {
		if (getData() == null || !(getData() instanceof SimpleAnyType)) {
			return null;
		}

		SimpleAnyType anyData = (SimpleAnyType) getData();
		return anyData.getInstanceType();
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.ExtendedAttribute#setInstanceType(org.eclipse.emf.ecore.EDataType)
	 */
	public void setInstanceType(EDataType type) {
		if (type == null) {
			type = XMLTypePackage.eINSTANCE.getAnySimpleType();
		}
		if (getData() == null || !(getData() instanceof SimpleAnyType)) {
			SimpleAnyType newData = XMLTypeFactory.eINSTANCE.createSimpleAnyType();
			newData.setInstanceType(type);
			newData.setValue(type.getDefaultValue());
			setData(newData);
		} else {
			SimpleAnyType newData = (SimpleAnyType) getData();
			if (newData.getInstanceType() != type) {
				newData.setInstanceType(type);
				if (type != XMLTypePackage.eINSTANCE.getAnySimpleType()) {
					newData.setValue(type.getDefaultValue());
				}
				// Trigger EMF event
				// TODO trigger value event (need to create EAttribute for value)
				setData(newData);
			}
		}
	}

	/*
	 * @see com.ibm.ccl.soa.deploy.core.ExtendedAttribute#getContainer()
	 */
	public DeployModelObject getContainer() {
		EObject container = eContainer();
		if (container != null) {
			if (container instanceof Augmentation) {
				EObject intercepted = ((Augmentation) container).eContainer();
				if (intercepted instanceof Instantiation) {
					return ((Instantiation) intercepted).getReferencedObject();
				}
			} else if (container instanceof Instantiation) {
				return ((Instantiation) container).getReferencedObject();
			} else if (container instanceof DeployModelObject) {
				return (DeployModelObject) container;
			}
		}
		return null;

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setName(String newName) {
		super.setName(newName);
		String oldName = name;
		name = newName;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					CorePackage.EXTENDED_ATTRIBUTE__NAME, oldName, name));
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
		case CorePackage.EXTENDED_ATTRIBUTE__DATA:
			return basicSetData(null, msgs);
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
		case CorePackage.EXTENDED_ATTRIBUTE__DATA:
			return getData();
		case CorePackage.EXTENDED_ATTRIBUTE__NAME:
			return getName();
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
		case CorePackage.EXTENDED_ATTRIBUTE__DATA:
			setData(newValue);
			return;
		case CorePackage.EXTENDED_ATTRIBUTE__NAME:
			setName((String) newValue);
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
		case CorePackage.EXTENDED_ATTRIBUTE__DATA:
			setData((Object) null);
			return;
		case CorePackage.EXTENDED_ATTRIBUTE__NAME:
			setName(NAME_EDEFAULT);
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
		case CorePackage.EXTENDED_ATTRIBUTE__DATA:
			return data != null;
		case CorePackage.EXTENDED_ATTRIBUTE__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (name: "); //$NON-NLS-1$
		result.append(name);
		result.append(')');
		return result.toString();
	}

	@Override
	public EDataType getEAttributeType() {
		/*
		 * For now return the instance type. We should consider removing the instance type and use
		 * EAttributeType.
		 */
		return getInstanceType();
	}

	@Override
	public EClassifier getEType() {
		return getInstanceType();
	}

	@Override
	public boolean isMany() {
		return false;
	}

	@Override
	public Class<?> getContainerClass() {
		/*
		 * Return the instance class of the DMO container.
		 */
		DeployModelObject dmo = getContainer();
		if (dmo != null) {
			return dmo.eClass().getInstanceClass();
		}
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (name == null ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ExtendedAttribute)) {
			return false;
		}
		final ExtendedAttribute other = (ExtendedAttribute) obj;

		if (name == null) {
			if (other.getName() != null) {
				return false;
			}
		} else if (!name.equals(other.getName())) {
			return false;
		}
		return true;
	}

} //ExtendedAttributeImpl
