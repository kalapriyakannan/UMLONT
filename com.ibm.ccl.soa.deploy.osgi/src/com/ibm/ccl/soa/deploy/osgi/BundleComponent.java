/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.ibm.ccl.soa.deploy.osgi;

import com.ibm.ccl.soa.deploy.core.SoftwareComponent;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bundle Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				A BundleComponent represents the OSGi Bundle, 
 * 				which exports itself and Java packages for 
 * 				other Bundles to depend on.
 * 
 * 				The inherited 'displayName' attribute will 				     provide the Bundle-Name.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.osgi.BundleComponent#getActivator <em>Activator</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.osgi.BundleComponent#isEclipseLazyStart <em>Eclipse Lazy Start</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.osgi.BundleComponent#getLocalization <em>Localization</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.osgi.BundleComponent#getManifestVersion <em>Manifest Version</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.osgi.BundleComponent#isSingleton <em>Singleton</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.osgi.BundleComponent#getVendor <em>Vendor</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.osgi.OsgiPackage#getBundleComponent()
 * @model extendedMetaData="name='BundleComponent' kind='elementOnly'"
 * @generated
 */
public interface BundleComponent extends SoftwareComponent {
	/**
	 * Returns the value of the '<em><b>Activator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *             Specifies the fully qualified name of a Java 
	 *             class which implements 
	 *             "org.osgi.framework.BundleActivator". 
	 *           
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Activator</em>' attribute.
	 * @see #setActivator(String)
	 * @see com.ibm.ccl.soa.deploy.osgi.OsgiPackage#getBundleComponent_Activator()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='activator'"
	 * @generated
	 */
	String getActivator();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.osgi.BundleComponent#getActivator <em>Activator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Activator</em>' attribute.
	 * @see #getActivator()
	 * @generated
	 */
	void setActivator(String value);

	/**
	 * Returns the value of the '<em><b>Eclipse Lazy Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *             Indicates whether the Bundle should be actively started or 
	 *             only when needed in an Eclipse environment. Set to 'true' 
	 *             to only load the Bundle once needed. 
	 *           
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Eclipse Lazy Start</em>' attribute.
	 * @see #isSetEclipseLazyStart()
	 * @see #unsetEclipseLazyStart()
	 * @see #setEclipseLazyStart(boolean)
	 * @see com.ibm.ccl.soa.deploy.osgi.OsgiPackage#getBundleComponent_EclipseLazyStart()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='eclipseLazyStart'"
	 * @generated
	 */
	boolean isEclipseLazyStart();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.osgi.BundleComponent#isEclipseLazyStart <em>Eclipse Lazy Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Eclipse Lazy Start</em>' attribute.
	 * @see #isSetEclipseLazyStart()
	 * @see #unsetEclipseLazyStart()
	 * @see #isEclipseLazyStart()
	 * @generated
	 */
	void setEclipseLazyStart(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.osgi.BundleComponent#isEclipseLazyStart <em>Eclipse Lazy Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEclipseLazyStart()
	 * @see #isEclipseLazyStart()
	 * @see #setEclipseLazyStart(boolean)
	 * @generated
	 */
	void unsetEclipseLazyStart();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.osgi.BundleComponent#isEclipseLazyStart <em>Eclipse Lazy Start</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Eclipse Lazy Start</em>' attribute is set.
	 * @see #unsetEclipseLazyStart()
	 * @see #isEclipseLazyStart()
	 * @see #setEclipseLazyStart(boolean)
	 * @generated
	 */
	boolean isSetEclipseLazyStart();

	/**
	 * Returns the value of the '<em><b>Localization</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *             Defines the path to a *.properties file which declares
	 *             localized strings for the Manifest.maf file. 
	 *             (e.g. 'plug-in' to indicate './plug-in.properties').   
	 *           
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Localization</em>' attribute.
	 * @see #setLocalization(String)
	 * @see com.ibm.ccl.soa.deploy.osgi.OsgiPackage#getBundleComponent_Localization()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='localization'"
	 * @generated
	 */
	String getLocalization();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.osgi.BundleComponent#getLocalization <em>Localization</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Localization</em>' attribute.
	 * @see #getLocalization()
	 * @generated
	 */
	void setLocalization(String value);

	/**
	 * Returns the value of the '<em><b>Manifest Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *             Defines the version of OSGi Manifest 
	 *             used in the Bundle. (Currently '2').  
	 *           
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Manifest Version</em>' attribute.
	 * @see #setManifestVersion(String)
	 * @see com.ibm.ccl.soa.deploy.osgi.OsgiPackage#getBundleComponent_ManifestVersion()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='manifestVersion'"
	 * @generated
	 */
	String getManifestVersion();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.osgi.BundleComponent#getManifestVersion <em>Manifest Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manifest Version</em>' attribute.
	 * @see #getManifestVersion()
	 * @generated
	 */
	void setManifestVersion(String value);

	/**
	 * Returns the value of the '<em><b>Singleton</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *             Must be set to 'true' in order to contribute 
	 *             plug-in extensions.  
	 *           
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Singleton</em>' attribute.
	 * @see #isSetSingleton()
	 * @see #unsetSingleton()
	 * @see #setSingleton(boolean)
	 * @see com.ibm.ccl.soa.deploy.osgi.OsgiPackage#getBundleComponent_Singleton()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='singleton'"
	 * @generated
	 */
	boolean isSingleton();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.osgi.BundleComponent#isSingleton <em>Singleton</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Singleton</em>' attribute.
	 * @see #isSetSingleton()
	 * @see #unsetSingleton()
	 * @see #isSingleton()
	 * @generated
	 */
	void setSingleton(boolean value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.osgi.BundleComponent#isSingleton <em>Singleton</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSingleton()
	 * @see #isSingleton()
	 * @see #setSingleton(boolean)
	 * @generated
	 */
	void unsetSingleton();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.osgi.BundleComponent#isSingleton <em>Singleton</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Singleton</em>' attribute is set.
	 * @see #unsetSingleton()
	 * @see #isSingleton()
	 * @see #setSingleton(boolean)
	 * @generated
	 */
	boolean isSetSingleton();

	/**
	 * Returns the value of the '<em><b>Vendor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 *             A localized string indicating the Vendor that produced the 
	 *             Bundle.
	 *           
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Vendor</em>' attribute.
	 * @see #setVendor(String)
	 * @see com.ibm.ccl.soa.deploy.osgi.OsgiPackage#getBundleComponent_Vendor()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='vendor'"
	 * @generated
	 */
	String getVendor();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.osgi.BundleComponent#getVendor <em>Vendor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vendor</em>' attribute.
	 * @see #getVendor()
	 * @generated
	 */
	void setVendor(String value);

} // BundleComponent
