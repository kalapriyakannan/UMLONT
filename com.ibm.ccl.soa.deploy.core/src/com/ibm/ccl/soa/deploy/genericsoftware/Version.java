/**
 * <copyright>
 * </copyright>
 *
 * $Id: Version.java,v 1.1 2008/02/04 15:55:29 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.genericsoftware;

import com.ibm.ccl.soa.deploy.core.Capability;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Version</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				Version can be a capability on any unit type that needs all or some of these attributes.
 * 
 * 				A representation of the specification of the version of a piece of hardware or software. The version is
 * 				specified in two parts - it can be specified as a single string, in which case the format of the string
 * 				is determined by the manufacturer of the entity (but should not include any manufacturer or model or
 * 				product name information ... it should just be the data that identifies the version); and it can be
 * 				specified as a combination of four integers that correspond to the Solution Install standard.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.Version#getBuildLevel <em>Build Level</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.Version#getLevel <em>Level</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.Version#getMajorVersion <em>Major Version</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.Version#getModifier <em>Modifier</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.Version#getRelease <em>Release</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.genericsoftware.Version#getVersionString <em>Version String</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage#getVersion()
 * @model extendedMetaData="name='Version' kind='elementOnly'"
 * @generated
 */
public interface Version extends Capability {
	/**
	 * Returns the value of the '<em><b>Build Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							This string contains the build level without any version or release information.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Build Level</em>' attribute.
	 * @see #setBuildLevel(String)
	 * @see com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage#getVersion_BuildLevel()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='buildLevel'"
	 * @generated
	 */
	String getBuildLevel();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.genericsoftware.Version#getBuildLevel <em>Build Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Build Level</em>' attribute.
	 * @see #getBuildLevel()
	 * @generated
	 */
	void setBuildLevel(String value);

	/**
	 * Returns the value of the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							A very precise specification of the exact build level of a particular piece of software, or
	 * 							the exact manufacturing run of a physical element. Not always specified in the version
	 * 							string. For products that use a 3 digit numbering convention, the level should not be used.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Level</em>' attribute.
	 * @see #isSetLevel()
	 * @see #unsetLevel()
	 * @see #setLevel(int)
	 * @see com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage#getVersion_Level()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='level'"
	 * @generated
	 */
	int getLevel();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.genericsoftware.Version#getLevel <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Level</em>' attribute.
	 * @see #isSetLevel()
	 * @see #unsetLevel()
	 * @see #getLevel()
	 * @generated
	 */
	void setLevel(int value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.genericsoftware.Version#getLevel <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLevel()
	 * @see #getLevel()
	 * @see #setLevel(int)
	 * @generated
	 */
	void unsetLevel();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.genericsoftware.Version#getLevel <em>Level</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Level</em>' attribute is set.
	 * @see #unsetLevel()
	 * @see #getLevel()
	 * @see #setLevel(int)
	 * @generated
	 */
	boolean isSetLevel();

	/**
	 * Returns the value of the '<em><b>Major Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							A major version of the product, and generally specified as the first number in a version
	 * 							string (for example, in WebSphere 6.1, the '6' is the major version). Generally,
	 * 							backwards-compatibility is not maintained across major version changes.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Major Version</em>' attribute.
	 * @see #isSetMajorVersion()
	 * @see #unsetMajorVersion()
	 * @see #setMajorVersion(int)
	 * @see com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage#getVersion_MajorVersion()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='majorVersion'"
	 * @generated
	 */
	int getMajorVersion();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.genericsoftware.Version#getMajorVersion <em>Major Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Major Version</em>' attribute.
	 * @see #isSetMajorVersion()
	 * @see #unsetMajorVersion()
	 * @see #getMajorVersion()
	 * @generated
	 */
	void setMajorVersion(int value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.genericsoftware.Version#getMajorVersion <em>Major Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMajorVersion()
	 * @see #getMajorVersion()
	 * @see #setMajorVersion(int)
	 * @generated
	 */
	void unsetMajorVersion();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.genericsoftware.Version#getMajorVersion <em>Major Version</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Major Version</em>' attribute is set.
	 * @see #unsetMajorVersion()
	 * @see #getMajorVersion()
	 * @see #setMajorVersion(int)
	 * @generated
	 */
	boolean isSetMajorVersion();

	/**
	 * Returns the value of the '<em><b>Modifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							A version specification that is normally tied to fixes within a software release, and is
	 * 							normally specified third in a version string. The Modifier may not always be specified, as
	 * 							in WebSphere 6.1, but it is more precise to include the exact fix pack level present in the
	 * 							software.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Modifier</em>' attribute.
	 * @see #isSetModifier()
	 * @see #unsetModifier()
	 * @see #setModifier(int)
	 * @see com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage#getVersion_Modifier()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='modifier'"
	 * @generated
	 */
	int getModifier();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.genericsoftware.Version#getModifier <em>Modifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Modifier</em>' attribute.
	 * @see #isSetModifier()
	 * @see #unsetModifier()
	 * @see #getModifier()
	 * @generated
	 */
	void setModifier(int value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.genericsoftware.Version#getModifier <em>Modifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetModifier()
	 * @see #getModifier()
	 * @see #setModifier(int)
	 * @generated
	 */
	void unsetModifier();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.genericsoftware.Version#getModifier <em>Modifier</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Modifier</em>' attribute is set.
	 * @see #unsetModifier()
	 * @see #getModifier()
	 * @see #setModifier(int)
	 * @generated
	 */
	boolean isSetModifier();

	/**
	 * Returns the value of the '<em><b>Release</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							The second highest specification in a version, generally used to show updates in a product
	 * 							where compatibility is maintained (such as between version 6.0 and 6.1 of WebSphere, where
	 * 							the '0' and the '1' are the release numbers).
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Release</em>' attribute.
	 * @see #isSetRelease()
	 * @see #unsetRelease()
	 * @see #setRelease(int)
	 * @see com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage#getVersion_Release()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='release'"
	 * @generated
	 */
	int getRelease();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.genericsoftware.Version#getRelease <em>Release</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Release</em>' attribute.
	 * @see #isSetRelease()
	 * @see #unsetRelease()
	 * @see #getRelease()
	 * @generated
	 */
	void setRelease(int value);

	/**
	 * Unsets the value of the '{@link com.ibm.ccl.soa.deploy.genericsoftware.Version#getRelease <em>Release</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRelease()
	 * @see #getRelease()
	 * @see #setRelease(int)
	 * @generated
	 */
	void unsetRelease();

	/**
	 * Returns whether the value of the '{@link com.ibm.ccl.soa.deploy.genericsoftware.Version#getRelease <em>Release</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Release</em>' attribute is set.
	 * @see #unsetRelease()
	 * @see #getRelease()
	 * @see #setRelease(int)
	 * @generated
	 */
	boolean isSetRelease();

	/**
	 * Returns the value of the '<em><b>Version String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * 							The complete version specification of the entity, expressed as a single string. Note that
	 * 							this string should not contain any information about the manufacturer of the entity, the
	 * 							model of the entity, or the name of the product associated with the entity. It should just
	 * 							contain version information, in a format described by the manufacturer of the entity. It is
	 * 							recommended, when the other attributes in the Version interface are filled in, that this
	 * 							attribute contain the same values, separated by periods. Note - In some cases the version
	 * 							string may be returned directly from an API call. If so, the string should not be parsed
	 * 							other than to remove things like line breaks.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Version String</em>' attribute.
	 * @see #setVersionString(String)
	 * @see com.ibm.ccl.soa.deploy.genericsoftware.GenericsoftwarePackage#getVersion_VersionString()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='versionString'"
	 * @generated
	 */
	String getVersionString();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.genericsoftware.Version#getVersionString <em>Version String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version String</em>' attribute.
	 * @see #getVersionString()
	 * @generated
	 */
	void setVersionString(String value);

} // Version
