/**
 * <copyright>
 * </copyright>
 *
 * $Id: SoftwareInstallImpl.java,v 1.3 2008/02/08 21:22:29 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.genericsoftware.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage;
import com.ibm.ccl.soa.deploy.genericsoftware.SoftwareInstall;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Software Install</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.impl.SoftwareInstallImpl#getExecutableName <em>Executable Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.impl.SoftwareInstallImpl#getInstallDate <em>Install Date</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.impl.SoftwareInstallImpl#getInstalledLocation <em>Installed Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.impl.SoftwareInstallImpl#getProductId <em>Product Id</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.impl.SoftwareInstallImpl#getProductName <em>Product Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.impl.SoftwareInstallImpl#getPublisher <em>Publisher</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SoftwareInstallImpl extends CapabilityImpl implements SoftwareInstall {
	/**
	 * The default value of the '{@link #getExecutableName() <em>Executable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutableName()
	 * @generated
	 * @ordered
	 */
	protected static final String EXECUTABLE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExecutableName() <em>Executable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutableName()
	 * @generated
	 * @ordered
	 */
	protected String executableName = EXECUTABLE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getInstallDate() <em>Install Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstallDate()
	 * @generated
	 * @ordered
	 */
	protected static final String INSTALL_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInstallDate() <em>Install Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstallDate()
	 * @generated
	 * @ordered
	 */
	protected String installDate = INSTALL_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getInstalledLocation() <em>Installed Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstalledLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String INSTALLED_LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInstalledLocation() <em>Installed Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstalledLocation()
	 * @generated
	 * @ordered
	 */
	protected String installedLocation = INSTALLED_LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getProductId() <em>Product Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProductId()
	 * @generated
	 * @ordered
	 */
	protected static final String PRODUCT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProductId() <em>Product Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProductId()
	 * @generated
	 * @ordered
	 */
	protected String productId = PRODUCT_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getProductName() <em>Product Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProductName()
	 * @generated
	 * @ordered
	 */
	protected static final String PRODUCT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProductName() <em>Product Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProductName()
	 * @generated
	 * @ordered
	 */
	protected String productName = PRODUCT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPublisher() <em>Publisher</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublisher()
	 * @generated
	 * @ordered
	 */
	protected static final String PUBLISHER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPublisher() <em>Publisher</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublisher()
	 * @generated
	 * @ordered
	 */
	protected String publisher = PUBLISHER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SoftwareInstallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return GenericsoftwarePackage.Literals.SOFTWARE_INSTALL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExecutableName() {
		return executableName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecutableName(String newExecutableName) {
		String oldExecutableName = executableName;
		executableName = newExecutableName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenericsoftwarePackage.SOFTWARE_INSTALL__EXECUTABLE_NAME, oldExecutableName, executableName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInstallDate() {
		return installDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstallDate(String newInstallDate) {
		String oldInstallDate = installDate;
		installDate = newInstallDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenericsoftwarePackage.SOFTWARE_INSTALL__INSTALL_DATE, oldInstallDate, installDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInstalledLocation() {
		return installedLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstalledLocation(String newInstalledLocation) {
		String oldInstalledLocation = installedLocation;
		installedLocation = newInstalledLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenericsoftwarePackage.SOFTWARE_INSTALL__INSTALLED_LOCATION, oldInstalledLocation, installedLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProductId(String newProductId) {
		String oldProductId = productId;
		productId = newProductId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenericsoftwarePackage.SOFTWARE_INSTALL__PRODUCT_ID, oldProductId, productId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProductName(String newProductName) {
		String oldProductName = productName;
		productName = newProductName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenericsoftwarePackage.SOFTWARE_INSTALL__PRODUCT_NAME, oldProductName, productName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPublisher(String newPublisher) {
		String oldPublisher = publisher;
		publisher = newPublisher;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenericsoftwarePackage.SOFTWARE_INSTALL__PUBLISHER, oldPublisher, publisher));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GenericsoftwarePackage.SOFTWARE_INSTALL__EXECUTABLE_NAME:
				return getExecutableName();
			case GenericsoftwarePackage.SOFTWARE_INSTALL__INSTALL_DATE:
				return getInstallDate();
			case GenericsoftwarePackage.SOFTWARE_INSTALL__INSTALLED_LOCATION:
				return getInstalledLocation();
			case GenericsoftwarePackage.SOFTWARE_INSTALL__PRODUCT_ID:
				return getProductId();
			case GenericsoftwarePackage.SOFTWARE_INSTALL__PRODUCT_NAME:
				return getProductName();
			case GenericsoftwarePackage.SOFTWARE_INSTALL__PUBLISHER:
				return getPublisher();
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
			case GenericsoftwarePackage.SOFTWARE_INSTALL__EXECUTABLE_NAME:
				setExecutableName((String)newValue);
				return;
			case GenericsoftwarePackage.SOFTWARE_INSTALL__INSTALL_DATE:
				setInstallDate((String)newValue);
				return;
			case GenericsoftwarePackage.SOFTWARE_INSTALL__INSTALLED_LOCATION:
				setInstalledLocation((String)newValue);
				return;
			case GenericsoftwarePackage.SOFTWARE_INSTALL__PRODUCT_ID:
				setProductId((String)newValue);
				return;
			case GenericsoftwarePackage.SOFTWARE_INSTALL__PRODUCT_NAME:
				setProductName((String)newValue);
				return;
			case GenericsoftwarePackage.SOFTWARE_INSTALL__PUBLISHER:
				setPublisher((String)newValue);
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
			case GenericsoftwarePackage.SOFTWARE_INSTALL__EXECUTABLE_NAME:
				setExecutableName(EXECUTABLE_NAME_EDEFAULT);
				return;
			case GenericsoftwarePackage.SOFTWARE_INSTALL__INSTALL_DATE:
				setInstallDate(INSTALL_DATE_EDEFAULT);
				return;
			case GenericsoftwarePackage.SOFTWARE_INSTALL__INSTALLED_LOCATION:
				setInstalledLocation(INSTALLED_LOCATION_EDEFAULT);
				return;
			case GenericsoftwarePackage.SOFTWARE_INSTALL__PRODUCT_ID:
				setProductId(PRODUCT_ID_EDEFAULT);
				return;
			case GenericsoftwarePackage.SOFTWARE_INSTALL__PRODUCT_NAME:
				setProductName(PRODUCT_NAME_EDEFAULT);
				return;
			case GenericsoftwarePackage.SOFTWARE_INSTALL__PUBLISHER:
				setPublisher(PUBLISHER_EDEFAULT);
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
			case GenericsoftwarePackage.SOFTWARE_INSTALL__EXECUTABLE_NAME:
				return EXECUTABLE_NAME_EDEFAULT == null ? executableName != null : !EXECUTABLE_NAME_EDEFAULT.equals(executableName);
			case GenericsoftwarePackage.SOFTWARE_INSTALL__INSTALL_DATE:
				return INSTALL_DATE_EDEFAULT == null ? installDate != null : !INSTALL_DATE_EDEFAULT.equals(installDate);
			case GenericsoftwarePackage.SOFTWARE_INSTALL__INSTALLED_LOCATION:
				return INSTALLED_LOCATION_EDEFAULT == null ? installedLocation != null : !INSTALLED_LOCATION_EDEFAULT.equals(installedLocation);
			case GenericsoftwarePackage.SOFTWARE_INSTALL__PRODUCT_ID:
				return PRODUCT_ID_EDEFAULT == null ? productId != null : !PRODUCT_ID_EDEFAULT.equals(productId);
			case GenericsoftwarePackage.SOFTWARE_INSTALL__PRODUCT_NAME:
				return PRODUCT_NAME_EDEFAULT == null ? productName != null : !PRODUCT_NAME_EDEFAULT.equals(productName);
			case GenericsoftwarePackage.SOFTWARE_INSTALL__PUBLISHER:
				return PUBLISHER_EDEFAULT == null ? publisher != null : !PUBLISHER_EDEFAULT.equals(publisher);
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
		result.append(" (executableName: "); //$NON-NLS-1$
		result.append(executableName);
		result.append(", installDate: "); //$NON-NLS-1$
		result.append(installDate);
		result.append(", installedLocation: "); //$NON-NLS-1$
		result.append(installedLocation);
		result.append(", productId: "); //$NON-NLS-1$
		result.append(productId);
		result.append(", productName: "); //$NON-NLS-1$
		result.append(productName);
		result.append(", publisher: "); //$NON-NLS-1$
		result.append(publisher);
		result.append(')');
		return result.toString();
	}

} //SoftwareInstallImpl
