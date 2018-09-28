/**
 * <copyright>
 * </copyright>
 *
 * $Id: VirtualImageImpl.java,v 1.5 2008/04/17 15:47:25 barnold Exp $
 */
package com.ibm.ccl.soa.deploy.virtualization.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.ibm.ccl.soa.deploy.core.impl.CapabilityImpl;
import com.ibm.ccl.soa.deploy.virtualization.VirtualImage;
import com.ibm.ccl.soa.deploy.virtualization.VirtualizationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Virtual Image</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualImageImpl#getCreatedWithVMTool <em>Created With VM Tool</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualImageImpl#getDateCreated <em>Date Created</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualImageImpl#getDateLastModified <em>Date Last Modified</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualImageImpl#getNotes <em>Notes</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.virtualization.impl.VirtualImageImpl#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VirtualImageImpl extends CapabilityImpl implements VirtualImage {
	/**
	 * The default value of the '{@link #getCreatedWithVMTool() <em>Created With VM Tool</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreatedWithVMTool()
	 * @generated
	 * @ordered
	 */
	protected static final String CREATED_WITH_VM_TOOL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreatedWithVMTool() <em>Created With VM Tool</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreatedWithVMTool()
	 * @generated
	 * @ordered
	 */
	protected String createdWithVMTool = CREATED_WITH_VM_TOOL_EDEFAULT;

	/**
	 * The default value of the '{@link #getDateCreated() <em>Date Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateCreated()
	 * @generated
	 * @ordered
	 */
	protected static final String DATE_CREATED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDateCreated() <em>Date Created</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateCreated()
	 * @generated
	 * @ordered
	 */
	protected String dateCreated = DATE_CREATED_EDEFAULT;

	/**
	 * The default value of the '{@link #getDateLastModified() <em>Date Last Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateLastModified()
	 * @generated
	 * @ordered
	 */
	protected static final String DATE_LAST_MODIFIED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDateLastModified() <em>Date Last Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDateLastModified()
	 * @generated
	 * @ordered
	 */
	protected String dateLastModified = DATE_LAST_MODIFIED_EDEFAULT;

	/**
	 * The default value of the '{@link #getNotes() <em>Notes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotes()
	 * @generated
	 * @ordered
	 */
	protected static final String NOTES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNotes() <em>Notes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotes()
	 * @generated
	 * @ordered
	 */
	protected String notes = NOTES_EDEFAULT;

	/**
	 * The default value of the '{@link #getOwner() <em>Owner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected static final String OWNER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOwner() <em>Owner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected String owner = OWNER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VirtualImageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return VirtualizationPackage.Literals.VIRTUAL_IMAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCreatedWithVMTool() {
		return createdWithVMTool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreatedWithVMTool(String newCreatedWithVMTool) {
		String oldCreatedWithVMTool = createdWithVMTool;
		createdWithVMTool = newCreatedWithVMTool;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VIRTUAL_IMAGE__CREATED_WITH_VM_TOOL, oldCreatedWithVMTool, createdWithVMTool));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDateCreated() {
		return dateCreated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDateCreated(String newDateCreated) {
		String oldDateCreated = dateCreated;
		dateCreated = newDateCreated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VIRTUAL_IMAGE__DATE_CREATED, oldDateCreated, dateCreated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDateLastModified() {
		return dateLastModified;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDateLastModified(String newDateLastModified) {
		String oldDateLastModified = dateLastModified;
		dateLastModified = newDateLastModified;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VIRTUAL_IMAGE__DATE_LAST_MODIFIED, oldDateLastModified, dateLastModified));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNotes(String newNotes) {
		String oldNotes = notes;
		notes = newNotes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VIRTUAL_IMAGE__NOTES, oldNotes, notes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwner(String newOwner) {
		String oldOwner = owner;
		owner = newOwner;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VirtualizationPackage.VIRTUAL_IMAGE__OWNER, oldOwner, owner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VirtualizationPackage.VIRTUAL_IMAGE__CREATED_WITH_VM_TOOL:
				return getCreatedWithVMTool();
			case VirtualizationPackage.VIRTUAL_IMAGE__DATE_CREATED:
				return getDateCreated();
			case VirtualizationPackage.VIRTUAL_IMAGE__DATE_LAST_MODIFIED:
				return getDateLastModified();
			case VirtualizationPackage.VIRTUAL_IMAGE__NOTES:
				return getNotes();
			case VirtualizationPackage.VIRTUAL_IMAGE__OWNER:
				return getOwner();
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
			case VirtualizationPackage.VIRTUAL_IMAGE__CREATED_WITH_VM_TOOL:
				setCreatedWithVMTool((String)newValue);
				return;
			case VirtualizationPackage.VIRTUAL_IMAGE__DATE_CREATED:
				setDateCreated((String)newValue);
				return;
			case VirtualizationPackage.VIRTUAL_IMAGE__DATE_LAST_MODIFIED:
				setDateLastModified((String)newValue);
				return;
			case VirtualizationPackage.VIRTUAL_IMAGE__NOTES:
				setNotes((String)newValue);
				return;
			case VirtualizationPackage.VIRTUAL_IMAGE__OWNER:
				setOwner((String)newValue);
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
			case VirtualizationPackage.VIRTUAL_IMAGE__CREATED_WITH_VM_TOOL:
				setCreatedWithVMTool(CREATED_WITH_VM_TOOL_EDEFAULT);
				return;
			case VirtualizationPackage.VIRTUAL_IMAGE__DATE_CREATED:
				setDateCreated(DATE_CREATED_EDEFAULT);
				return;
			case VirtualizationPackage.VIRTUAL_IMAGE__DATE_LAST_MODIFIED:
				setDateLastModified(DATE_LAST_MODIFIED_EDEFAULT);
				return;
			case VirtualizationPackage.VIRTUAL_IMAGE__NOTES:
				setNotes(NOTES_EDEFAULT);
				return;
			case VirtualizationPackage.VIRTUAL_IMAGE__OWNER:
				setOwner(OWNER_EDEFAULT);
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
			case VirtualizationPackage.VIRTUAL_IMAGE__CREATED_WITH_VM_TOOL:
				return CREATED_WITH_VM_TOOL_EDEFAULT == null ? createdWithVMTool != null : !CREATED_WITH_VM_TOOL_EDEFAULT.equals(createdWithVMTool);
			case VirtualizationPackage.VIRTUAL_IMAGE__DATE_CREATED:
				return DATE_CREATED_EDEFAULT == null ? dateCreated != null : !DATE_CREATED_EDEFAULT.equals(dateCreated);
			case VirtualizationPackage.VIRTUAL_IMAGE__DATE_LAST_MODIFIED:
				return DATE_LAST_MODIFIED_EDEFAULT == null ? dateLastModified != null : !DATE_LAST_MODIFIED_EDEFAULT.equals(dateLastModified);
			case VirtualizationPackage.VIRTUAL_IMAGE__NOTES:
				return NOTES_EDEFAULT == null ? notes != null : !NOTES_EDEFAULT.equals(notes);
			case VirtualizationPackage.VIRTUAL_IMAGE__OWNER:
				return OWNER_EDEFAULT == null ? owner != null : !OWNER_EDEFAULT.equals(owner);
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
		result.append(" (createdWithVMTool: "); //$NON-NLS-1$
		result.append(createdWithVMTool);
		result.append(", dateCreated: "); //$NON-NLS-1$
		result.append(dateCreated);
		result.append(", dateLastModified: "); //$NON-NLS-1$
		result.append(dateLastModified);
		result.append(", notes: "); //$NON-NLS-1$
		result.append(notes);
		result.append(", owner: "); //$NON-NLS-1$
		result.append(owner);
		result.append(')');
		return result.toString();
	}

} //VirtualImageImpl
