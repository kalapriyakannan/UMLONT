/**
 * <copyright>
 * </copyright>
 *
 * $Id: SoftwareInstall.java,v 1.2 2008/02/08 21:22:30 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.genericsoftware;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Software Install</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.SoftwareInstall#getExecutableName <em>Executable Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.SoftwareInstall#getInstallDate <em>Install Date</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.SoftwareInstall#getInstalledLocation <em>Installed Location</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.SoftwareInstall#getProductId <em>Product Id</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.SoftwareInstall#getProductName <em>Product Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.SoftwareInstall#getPublisher <em>Publisher</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage#getSoftwareInstall()
 * @model extendedMetaData="name='SoftwareInstall' kind='elementOnly'"
 * @generated
 */
public interface SoftwareInstall extends Capability {
	/**
	 * Returns the value of the '<em><b>Executable Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * TODO
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Executable Name</em>' attribute.
	 * @see #setExecutableName(String)
	 * @see com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage#getSoftwareInstall_ExecutableName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='executableName'"
	 * @generated
	 */
	String getExecutableName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.genericsoftware.SoftwareInstall#getExecutableName <em>Executable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Executable Name</em>' attribute.
	 * @see #getExecutableName()
	 * @generated
	 */
	void setExecutableName(String value);

	/**
	 * Returns the value of the '<em><b>Install Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Date and time software was or will be installed.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Install Date</em>' attribute.
	 * @see #setInstallDate(String)
	 * @see com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage#getSoftwareInstall_InstallDate()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='installDate'"
	 * @generated
	 */
	String getInstallDate();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.genericsoftware.SoftwareInstall#getInstallDate <em>Install Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Install Date</em>' attribute.
	 * @see #getInstallDate()
	 * @generated
	 */
	void setInstallDate(String value);

	/**
	 * Returns the value of the '<em><b>Installed Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * TODO
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Installed Location</em>' attribute.
	 * @see #setInstalledLocation(String)
	 * @see com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage#getSoftwareInstall_InstalledLocation()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='installedLocation'"
	 * @generated
	 */
	String getInstalledLocation();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.genericsoftware.SoftwareInstall#getInstalledLocation <em>Installed Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Installed Location</em>' attribute.
	 * @see #getInstalledLocation()
	 * @generated
	 */
	void setInstalledLocation(String value);

	/**
	 * Returns the value of the '<em><b>Product Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * TODO
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Product Id</em>' attribute.
	 * @see #setProductId(String)
	 * @see com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage#getSoftwareInstall_ProductId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ProductId'"
	 * @generated
	 */
	String getProductId();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.genericsoftware.SoftwareInstall#getProductId <em>Product Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Product Id</em>' attribute.
	 * @see #getProductId()
	 * @generated
	 */
	void setProductId(String value);

	/**
	 * Returns the value of the '<em><b>Product Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * TODO
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Product Name</em>' attribute.
	 * @see #setProductName(String)
	 * @see com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage#getSoftwareInstall_ProductName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='productName'"
	 * @generated
	 */
	String getProductName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.genericsoftware.SoftwareInstall#getProductName <em>Product Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Product Name</em>' attribute.
	 * @see #getProductName()
	 * @generated
	 */
	void setProductName(String value);

	/**
	 * Returns the value of the '<em><b>Publisher</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * e.g. "Microsoft Corporation"
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Publisher</em>' attribute.
	 * @see #setPublisher(String)
	 * @see com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage#getSoftwareInstall_Publisher()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='publisher'"
	 * @generated
	 */
	String getPublisher();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.genericsoftware.SoftwareInstall#getPublisher <em>Publisher</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Publisher</em>' attribute.
	 * @see #getPublisher()
	 * @generated
	 */
	void setPublisher(String value);

} // SoftwareInstall
