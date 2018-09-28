/**
 * <copyright>
 * </copyright>
 *
 * $Id: VirtualImage.java,v 1.5 2008/04/17 15:47:25 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization;

import com.ibm.ccl.soa.deploy.core.Capability;
import com.ibm.ccl.soa.deploy.server.Server;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Virtual Image</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				VirtualImages hold meta details of the image file on behalf of a {@link VirtualImageUnit}.
 * 				<p>
 * 					VirtualImage doesn't hold the details of the {@link Server} the VirtualImageUnit models, such as
 * 					memory size or processor type. These details are contained in the {@link VirtualServerDef}
 * 					capability
 * 				</p>
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualImage#getCreatedWithVMTool <em>Created With VM Tool</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualImage#getDateCreated <em>Date Created</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualImage#getDateLastModified <em>Date Last Modified</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualImage#getNotes <em>Notes</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.VirtualImage#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualImage()
 * @model extendedMetaData="name='VirtualImage' kind='elementOnly'"
 * @generated
 */
public interface VirtualImage extends Capability {
	/**
	 * Returns the value of the '<em><b>Created With VM Tool</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Created With VM Tool</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Created With VM Tool</em>' attribute.
	 * @see #setCreatedWithVMTool(String)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualImage_CreatedWithVMTool()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='createdWithVMTool'"
	 * @generated
	 */
	String getCreatedWithVMTool();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualImage#getCreatedWithVMTool <em>Created With VM Tool</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Created With VM Tool</em>' attribute.
	 * @see #getCreatedWithVMTool()
	 * @generated
	 */
	void setCreatedWithVMTool(String value);

	/**
	 * Returns the value of the '<em><b>Date Created</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date Created</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date Created</em>' attribute.
	 * @see #setDateCreated(String)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualImage_DateCreated()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='dateCreated'"
	 * @generated
	 */
	String getDateCreated();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualImage#getDateCreated <em>Date Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date Created</em>' attribute.
	 * @see #getDateCreated()
	 * @generated
	 */
	void setDateCreated(String value);

	/**
	 * Returns the value of the '<em><b>Date Last Modified</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Date Last Modified</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date Last Modified</em>' attribute.
	 * @see #setDateLastModified(String)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualImage_DateLastModified()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='dateLastModified'"
	 * @generated
	 */
	String getDateLastModified();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualImage#getDateLastModified <em>Date Last Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date Last Modified</em>' attribute.
	 * @see #getDateLastModified()
	 * @generated
	 */
	void setDateLastModified(String value);

	/**
	 * Returns the value of the '<em><b>Notes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Notes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Notes</em>' attribute.
	 * @see #setNotes(String)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualImage_Notes()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='notes'"
	 * @generated
	 */
	String getNotes();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualImage#getNotes <em>Notes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Notes</em>' attribute.
	 * @see #getNotes()
	 * @generated
	 */
	void setNotes(String value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' attribute.
	 * @see #setOwner(String)
	 * @see com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage#getVirtualImage_Owner()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='owner'"
	 * @generated
	 */
	String getOwner();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.virtualization.VirtualImage#getOwner <em>Owner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' attribute.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(String value);

} // VirtualImage
