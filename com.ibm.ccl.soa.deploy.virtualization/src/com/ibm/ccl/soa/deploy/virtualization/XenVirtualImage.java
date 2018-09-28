/**
 * <copyright>
 * </copyright>
 *
 * $Id: XenVirtualImage.java,v 1.4 2008/04/17 15:47:25 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization;

import com.ibm.ccl.soa.deploy.server.Server;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Xen Virtual Image</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				XenVirtualImages hold meta details of the image file on behalf of a {@link XenVirtualImageUnit}.
 * 				<p>
 * 					XenVirtualImage doesn't hold the details of the {@link Server} the XenVirtualImageUnit models, such
 * 					as memory size or processor type. These details are contained in the {@link XenVirtualServerDef}
 * 					capability
 * 				</p>
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualImage#getDomainConfigFile <em>Domain Config File</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualImage#getDomainName <em>Domain Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getXenVirtualImage()
 * @model extendedMetaData="name='XenVirtualImage' kind='elementOnly'"
 * @generated
 */
public interface XenVirtualImage extends VirtualImage {

	/**
	 * Returns the value of the '<em><b>Domain Config File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The configuration file for this image.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Domain Config File</em>' attribute.
	 * @see #setDomainConfigFile(String)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getXenVirtualImage_DomainConfigFile()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='domainConfigFile'"
	 * @generated
	 */
	String getDomainConfigFile();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualImage#getDomainConfigFile <em>Domain Config File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Config File</em>' attribute.
	 * @see #getDomainConfigFile()
	 * @generated
	 */
	void setDomainConfigFile(String value);

	/**
	 * Returns the value of the '<em><b>Domain Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A unique name for the Xen domain.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Domain Name</em>' attribute.
	 * @see #setDomainName(String)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getXenVirtualImage_DomainName()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='domainName'"
	 * @generated
	 */
	String getDomainName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.XenVirtualImage#getDomainName <em>Domain Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain Name</em>' attribute.
	 * @see #getDomainName()
	 * @generated
	 */
	void setDomainName(String value);
} // XenVirtualImage
