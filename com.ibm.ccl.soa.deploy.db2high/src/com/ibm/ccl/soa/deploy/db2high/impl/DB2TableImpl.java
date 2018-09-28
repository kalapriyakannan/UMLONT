/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.db2high.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.db2high.DB2Table;
import com.ibm.ccl.soa.deploy.db2high.Db2highPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DB2 Table</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2TableImpl#getAlias <em>Alias</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2TableImpl#getIndexTableSpace <em>Index Table Space</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2TableImpl#getName1 <em>Name1</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2TableImpl#getPartioningKey <em>Partioning Key</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.db2high.impl.DB2TableImpl#getPartioningMethod <em>Partioning Method</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DB2TableImpl extends CapabilityImpl implements DB2Table {
	/**
	 * The default value of the '{@link #getAlias() <em>Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlias()
	 * @generated
	 * @ordered
	 */
	protected static final String ALIAS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAlias() <em>Alias</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlias()
	 * @generated
	 * @ordered
	 */
	protected String alias = ALIAS_EDEFAULT;

	/**
	 * The default value of the '{@link #getIndexTableSpace() <em>Index Table Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexTableSpace()
	 * @generated
	 * @ordered
	 */
	protected static final String INDEX_TABLE_SPACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIndexTableSpace() <em>Index Table Space</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexTableSpace()
	 * @generated
	 * @ordered
	 */
	protected String indexTableSpace = INDEX_TABLE_SPACE_EDEFAULT;

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
	 * The default value of the '{@link #getPartioningKey() <em>Partioning Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartioningKey()
	 * @generated
	 * @ordered
	 */
	protected static final String PARTIONING_KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPartioningKey() <em>Partioning Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartioningKey()
	 * @generated
	 * @ordered
	 */
	protected String partioningKey = PARTIONING_KEY_EDEFAULT;

	/**
	 * The default value of the '{@link #getPartioningMethod() <em>Partioning Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartioningMethod()
	 * @generated
	 * @ordered
	 */
	protected static final String PARTIONING_METHOD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPartioningMethod() <em>Partioning Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartioningMethod()
	 * @generated
	 * @ordered
	 */
	protected String partioningMethod = PARTIONING_METHOD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DB2TableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return Db2highPackage.Literals.DB2_TABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlias(String newAlias) {
		String oldAlias = alias;
		alias = newAlias;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_TABLE__ALIAS, oldAlias, alias));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIndexTableSpace() {
		return indexTableSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndexTableSpace(String newIndexTableSpace) {
		String oldIndexTableSpace = indexTableSpace;
		indexTableSpace = newIndexTableSpace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_TABLE__INDEX_TABLE_SPACE, oldIndexTableSpace, indexTableSpace));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_TABLE__NAME1, oldName1, name1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPartioningKey() {
		return partioningKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPartioningKey(String newPartioningKey) {
		String oldPartioningKey = partioningKey;
		partioningKey = newPartioningKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_TABLE__PARTIONING_KEY, oldPartioningKey, partioningKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPartioningMethod() {
		return partioningMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPartioningMethod(String newPartioningMethod) {
		String oldPartioningMethod = partioningMethod;
		partioningMethod = newPartioningMethod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Db2highPackage.DB2_TABLE__PARTIONING_METHOD, oldPartioningMethod, partioningMethod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Db2highPackage.DB2_TABLE__ALIAS:
				return getAlias();
			case Db2highPackage.DB2_TABLE__INDEX_TABLE_SPACE:
				return getIndexTableSpace();
			case Db2highPackage.DB2_TABLE__NAME1:
				return getName1();
			case Db2highPackage.DB2_TABLE__PARTIONING_KEY:
				return getPartioningKey();
			case Db2highPackage.DB2_TABLE__PARTIONING_METHOD:
				return getPartioningMethod();
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
			case Db2highPackage.DB2_TABLE__ALIAS:
				setAlias((String)newValue);
				return;
			case Db2highPackage.DB2_TABLE__INDEX_TABLE_SPACE:
				setIndexTableSpace((String)newValue);
				return;
			case Db2highPackage.DB2_TABLE__NAME1:
				setName1((String)newValue);
				return;
			case Db2highPackage.DB2_TABLE__PARTIONING_KEY:
				setPartioningKey((String)newValue);
				return;
			case Db2highPackage.DB2_TABLE__PARTIONING_METHOD:
				setPartioningMethod((String)newValue);
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
			case Db2highPackage.DB2_TABLE__ALIAS:
				setAlias(ALIAS_EDEFAULT);
				return;
			case Db2highPackage.DB2_TABLE__INDEX_TABLE_SPACE:
				setIndexTableSpace(INDEX_TABLE_SPACE_EDEFAULT);
				return;
			case Db2highPackage.DB2_TABLE__NAME1:
				setName1(NAME1_EDEFAULT);
				return;
			case Db2highPackage.DB2_TABLE__PARTIONING_KEY:
				setPartioningKey(PARTIONING_KEY_EDEFAULT);
				return;
			case Db2highPackage.DB2_TABLE__PARTIONING_METHOD:
				setPartioningMethod(PARTIONING_METHOD_EDEFAULT);
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
			case Db2highPackage.DB2_TABLE__ALIAS:
				return ALIAS_EDEFAULT == null ? alias != null : !ALIAS_EDEFAULT.equals(alias);
			case Db2highPackage.DB2_TABLE__INDEX_TABLE_SPACE:
				return INDEX_TABLE_SPACE_EDEFAULT == null ? indexTableSpace != null : !INDEX_TABLE_SPACE_EDEFAULT.equals(indexTableSpace);
			case Db2highPackage.DB2_TABLE__NAME1:
				return NAME1_EDEFAULT == null ? name1 != null : !NAME1_EDEFAULT.equals(name1);
			case Db2highPackage.DB2_TABLE__PARTIONING_KEY:
				return PARTIONING_KEY_EDEFAULT == null ? partioningKey != null : !PARTIONING_KEY_EDEFAULT.equals(partioningKey);
			case Db2highPackage.DB2_TABLE__PARTIONING_METHOD:
				return PARTIONING_METHOD_EDEFAULT == null ? partioningMethod != null : !PARTIONING_METHOD_EDEFAULT.equals(partioningMethod);
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
		result.append(" (alias: "); //$NON-NLS-1$
		result.append(alias);
		result.append(", indexTableSpace: "); //$NON-NLS-1$
		result.append(indexTableSpace);
		result.append(", name1: "); //$NON-NLS-1$
		result.append(name1);
		result.append(", partioningKey: "); //$NON-NLS-1$
		result.append(partioningKey);
		result.append(", partioningMethod: "); //$NON-NLS-1$
		result.append(partioningMethod);
		result.append(')');
		return result.toString();
	}

} //DB2TableImpl
