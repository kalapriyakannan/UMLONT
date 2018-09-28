/**
 * <copyright>
 * </copyright>
 *
 * $Id: VMwareVirtualImage.java,v 1.4 2008/04/17 15:47:25 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization;

import com.ibm.ccl.soa.deploy.server.Server;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VMware Virtual Image</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				VMwareVirtualImages hold meta details of the image file on behalf of a {@link VMwareVirtualImageUnit}.
 * 				<p>
 * 					VMwareVirtualImage doesn't hold the details of the {@link Server} the VMwareVirtualImageUnit models,
 * 					such as memory size or processor type. These details are contained in the {@link
 * 					VMwareVirtualServerDef} capability
 * 				</p>
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImage#getConfigVersion <em>Config Version</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImage#getVmxFile <em>Vmx File</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualImage()
 * @model extendedMetaData="name='VMwareVirtualImage' kind='elementOnly'"
 * @generated
 */
public interface VMwareVirtualImage extends VirtualImage {

	/**
	 * Returns the value of the '<em><b>Config Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The configuration file for this image.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Config Version</em>' attribute.
	 * @see #setConfigVersion(String)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualImage_ConfigVersion()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='configVersion'"
	 * @generated
	 */
	String getConfigVersion();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImage#getConfigVersion <em>Config Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Config Version</em>' attribute.
	 * @see #getConfigVersion()
	 * @generated
	 */
	void setConfigVersion(String value);

	/**
	 * Returns the value of the '<em><b>Vmx File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The vmx (configuration) file for this image.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Vmx File</em>' attribute.
	 * @see #setVmxFile(String)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVMwareVirtualImage_VmxFile()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='vmxFile'"
	 * @generated
	 */
	String getVmxFile();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VMwareVirtualImage#getVmxFile <em>Vmx File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vmx File</em>' attribute.
	 * @see #getVmxFile()
	 * @generated
	 */
	void setVmxFile(String value);
} // VMwareVirtualImage
