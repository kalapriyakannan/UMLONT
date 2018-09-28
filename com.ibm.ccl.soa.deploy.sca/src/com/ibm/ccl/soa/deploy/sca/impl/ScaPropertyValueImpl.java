/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.sca.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.sca.ScaPackage;
import com.ibm.ccl.soa.deploy.sca.ScaPropertyValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.ScaPropertyValueImpl#getElement <em>Element</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.ScaPropertyValueImpl#getFile <em>File</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.ScaPropertyValueImpl#getMany <em>Many</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.ScaPropertyValueImpl#getMustSupply <em>Must Supply</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.ScaPropertyValueImpl#getName1 <em>Name1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.ScaPropertyValueImpl#getSource <em>Source</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.sca.impl.ScaPropertyValueImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScaPropertyValueImpl extends CapabilityImpl implements ScaPropertyValue {
	/**
	 * The default value of the '{@link #getElement() <em>Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected static final String ELEMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getElement() <em>Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected String element = ELEMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getFile() <em>File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFile()
	 * @generated
	 * @ordered
	 */
	protected static final String FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFile() <em>File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFile()
	 * @generated
	 * @ordered
	 */
	protected String file = FILE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMany() <em>Many</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMany()
	 * @generated
	 * @ordered
	 */
	protected static final String MANY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMany() <em>Many</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMany()
	 * @generated
	 * @ordered
	 */
	protected String many = MANY_EDEFAULT;

	/**
	 * The default value of the '{@link #getMustSupply() <em>Must Supply</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMustSupply()
	 * @generated
	 * @ordered
	 */
	protected static final String MUST_SUPPLY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMustSupply() <em>Must Supply</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMustSupply()
	 * @generated
	 * @ordered
	 */
	protected String mustSupply = MUST_SUPPLY_EDEFAULT;

	/**
	 * The default value of the '{@link #getName1() <em>Name1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName1()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName1() <em>Name1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName1()
	 * @generated
	 * @ordered
	 */
	protected String name1 = NAME1_EDEFAULT;

	/**
	 * The default value of the '{@link #getSource() <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected static final String SOURCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected String source = SOURCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScaPropertyValueImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ScaPackage.Literals.SCA_PROPERTY_VALUE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getElement() {
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElement(String newElement) {
		String oldElement = element;
		element = newElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScaPackage.SCA_PROPERTY_VALUE__ELEMENT, oldElement, element));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFile() {
		return file;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFile(String newFile) {
		String oldFile = file;
		file = newFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScaPackage.SCA_PROPERTY_VALUE__FILE, oldFile, file));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMany() {
		return many;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMany(String newMany) {
		String oldMany = many;
		many = newMany;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScaPackage.SCA_PROPERTY_VALUE__MANY, oldMany, many));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMustSupply() {
		return mustSupply;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMustSupply(String newMustSupply) {
		String oldMustSupply = mustSupply;
		mustSupply = newMustSupply;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScaPackage.SCA_PROPERTY_VALUE__MUST_SUPPLY, oldMustSupply, mustSupply));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName1() {
		return name1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName1(String newName1) {
		String oldName1 = name1;
		name1 = newName1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScaPackage.SCA_PROPERTY_VALUE__NAME1, oldName1, name1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(String newSource) {
		String oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScaPackage.SCA_PROPERTY_VALUE__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScaPackage.SCA_PROPERTY_VALUE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ScaPackage.SCA_PROPERTY_VALUE__ELEMENT:
				return getElement();
			case ScaPackage.SCA_PROPERTY_VALUE__FILE:
				return getFile();
			case ScaPackage.SCA_PROPERTY_VALUE__MANY:
				return getMany();
			case ScaPackage.SCA_PROPERTY_VALUE__MUST_SUPPLY:
				return getMustSupply();
			case ScaPackage.SCA_PROPERTY_VALUE__NAME1:
				return getName1();
			case ScaPackage.SCA_PROPERTY_VALUE__SOURCE:
				return getSource();
			case ScaPackage.SCA_PROPERTY_VALUE__TYPE:
				return getType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ScaPackage.SCA_PROPERTY_VALUE__ELEMENT:
				setElement((String)newValue);
				return;
			case ScaPackage.SCA_PROPERTY_VALUE__FILE:
				setFile((String)newValue);
				return;
			case ScaPackage.SCA_PROPERTY_VALUE__MANY:
				setMany((String)newValue);
				return;
			case ScaPackage.SCA_PROPERTY_VALUE__MUST_SUPPLY:
				setMustSupply((String)newValue);
				return;
			case ScaPackage.SCA_PROPERTY_VALUE__NAME1:
				setName1((String)newValue);
				return;
			case ScaPackage.SCA_PROPERTY_VALUE__SOURCE:
				setSource((String)newValue);
				return;
			case ScaPackage.SCA_PROPERTY_VALUE__TYPE:
				setType((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case ScaPackage.SCA_PROPERTY_VALUE__ELEMENT:
				setElement(ELEMENT_EDEFAULT);
				return;
			case ScaPackage.SCA_PROPERTY_VALUE__FILE:
				setFile(FILE_EDEFAULT);
				return;
			case ScaPackage.SCA_PROPERTY_VALUE__MANY:
				setMany(MANY_EDEFAULT);
				return;
			case ScaPackage.SCA_PROPERTY_VALUE__MUST_SUPPLY:
				setMustSupply(MUST_SUPPLY_EDEFAULT);
				return;
			case ScaPackage.SCA_PROPERTY_VALUE__NAME1:
				setName1(NAME1_EDEFAULT);
				return;
			case ScaPackage.SCA_PROPERTY_VALUE__SOURCE:
				setSource(SOURCE_EDEFAULT);
				return;
			case ScaPackage.SCA_PROPERTY_VALUE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ScaPackage.SCA_PROPERTY_VALUE__ELEMENT:
				return ELEMENT_EDEFAULT == null ? element != null : !ELEMENT_EDEFAULT.equals(element);
			case ScaPackage.SCA_PROPERTY_VALUE__FILE:
				return FILE_EDEFAULT == null ? file != null : !FILE_EDEFAULT.equals(file);
			case ScaPackage.SCA_PROPERTY_VALUE__MANY:
				return MANY_EDEFAULT == null ? many != null : !MANY_EDEFAULT.equals(many);
			case ScaPackage.SCA_PROPERTY_VALUE__MUST_SUPPLY:
				return MUST_SUPPLY_EDEFAULT == null ? mustSupply != null : !MUST_SUPPLY_EDEFAULT.equals(mustSupply);
			case ScaPackage.SCA_PROPERTY_VALUE__NAME1:
				return NAME1_EDEFAULT == null ? name1 != null : !NAME1_EDEFAULT.equals(name1);
			case ScaPackage.SCA_PROPERTY_VALUE__SOURCE:
				return SOURCE_EDEFAULT == null ? source != null : !SOURCE_EDEFAULT.equals(source);
			case ScaPackage.SCA_PROPERTY_VALUE__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (element: "); //$NON-NLS-1$
		result.append(element);
		result.append(", file: "); //$NON-NLS-1$
		result.append(file);
		result.append(", many: "); //$NON-NLS-1$
		result.append(many);
		result.append(", mustSupply: "); //$NON-NLS-1$
		result.append(mustSupply);
		result.append(", name1: "); //$NON-NLS-1$
		result.append(name1);
		result.append(", source: "); //$NON-NLS-1$
		result.append(source);
		result.append(", type: "); //$NON-NLS-1$
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //ScaPropertyValueImpl
