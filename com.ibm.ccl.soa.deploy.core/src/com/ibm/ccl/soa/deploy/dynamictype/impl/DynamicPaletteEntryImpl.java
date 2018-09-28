/***************************************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights
 * reserved.
 * 
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 **************************************************************************************************/
package com.ibm.ccl.soa.deploy.dynamictype.impl;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.ibm.ccl.soa.deploy.core.IConstants;
import com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry;
import com.ibm.ccl.soa.deploy.dynamictype.DynamictypePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Dynamic Palette Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.ibm.ccl.soa.deploy.dynamictype.impl.DynamicPaletteEntryImpl#getDescription <em>Description</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.dynamictype.impl.DynamicPaletteEntryImpl#getDiagramPath <em>Diagram Path</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.dynamictype.impl.DynamicPaletteEntryImpl#getId <em>Id</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.dynamictype.impl.DynamicPaletteEntryImpl#getKind <em>Kind</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.dynamictype.impl.DynamicPaletteEntryImpl#getLabel <em>Label</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.dynamictype.impl.DynamicPaletteEntryImpl#getLargeIcon <em>Large Icon</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.dynamictype.impl.DynamicPaletteEntryImpl#getPath <em>Path</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.dynamictype.impl.DynamicPaletteEntryImpl#getSmallIcon <em>Small Icon</em>}</li>
 * <li>{@link com.ibm.ccl.soa.deploy.dynamictype.impl.DynamicPaletteEntryImpl#getTemplateURI <em>Template URI</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class DynamicPaletteEntryImpl extends EObjectImpl implements DynamicPaletteEntry {
	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDiagramPath() <em>Diagram Path</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDiagramPath()
	 * @generated
	 * @ordered
	 */
	protected static final String DIAGRAM_PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDiagramPath() <em>Diagram Path</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDiagramPath()
	 * @generated
	 * @ordered
	 */
	protected String diagramPath = DIAGRAM_PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getKind() <em>Kind</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected static final String KIND_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKind() <em>Kind</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getKind()
	 * @generated
	 * @ordered
	 */
	protected String kind = KIND_EDEFAULT;

	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getLargeIcon() <em>Large Icon</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLargeIcon()
	 * @generated
	 * @ordered
	 */
	protected static final String LARGE_ICON_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLargeIcon() <em>Large Icon</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLargeIcon()
	 * @generated
	 * @ordered
	 */
	protected String largeIcon = LARGE_ICON_EDEFAULT;

	/**
	 * The default value of the '{@link #getPath() <em>Path</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' attribute. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected String path = PATH_EDEFAULT;

	/**
	 * The default value of the '{@link #getSmallIcon() <em>Small Icon</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSmallIcon()
	 * @generated
	 * @ordered
	 */
	protected static final String SMALL_ICON_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSmallIcon() <em>Small Icon</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getSmallIcon()
	 * @generated
	 * @ordered
	 */
	protected String smallIcon = SMALL_ICON_EDEFAULT;

	/**
	 * The default value of the '{@link #getTemplateURI() <em>Template URI</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTemplateURI()
	 * @generated
	 * @ordered
	 */
	protected static final String TEMPLATE_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTemplateURI() <em>Template URI</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTemplateURI()
	 * @generated
	 * @ordered
	 */
	protected String templateURI = TEMPLATE_URI_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DynamicPaletteEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DynamictypePackage.Literals.DYNAMIC_PALETTE_ENTRY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					DynamictypePackage.DYNAMIC_PALETTE_ENTRY__DESCRIPTION, oldDescription, description));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String getDiagramPath() {
		if (diagramPath == null) {
			IPath modelPath = new Path(getTemplateURI());
			diagramPath = modelPath.removeFileExtension().addFileExtension(
					IConstants.TOPOLOGYV_EXTENSION).toString();
		}
		return diagramPath;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDiagramPath(String newDiagramPath) {
		String oldDiagramPath = diagramPath;
		diagramPath = newDiagramPath;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					DynamictypePackage.DYNAMIC_PALETTE_ENTRY__DIAGRAM_PATH, oldDiagramPath, diagramPath));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					DynamictypePackage.DYNAMIC_PALETTE_ENTRY__ID, oldId, id));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getKind() {
		return kind;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setKind(String newKind) {
		String oldKind = kind;
		kind = newKind;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					DynamictypePackage.DYNAMIC_PALETTE_ENTRY__KIND, oldKind, kind));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					DynamictypePackage.DYNAMIC_PALETTE_ENTRY__LABEL, oldLabel, label));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getLargeIcon() {
		return largeIcon;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLargeIcon(String newLargeIcon) {
		String oldLargeIcon = largeIcon;
		largeIcon = newLargeIcon;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					DynamictypePackage.DYNAMIC_PALETTE_ENTRY__LARGE_ICON, oldLargeIcon, largeIcon));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getPath() {
		return path;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setPath(String newPath) {
		String oldPath = path;
		path = newPath;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					DynamictypePackage.DYNAMIC_PALETTE_ENTRY__PATH, oldPath, path));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getSmallIcon() {
		return smallIcon;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setSmallIcon(String newSmallIcon) {
		String oldSmallIcon = smallIcon;
		smallIcon = newSmallIcon;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					DynamictypePackage.DYNAMIC_PALETTE_ENTRY__SMALL_ICON, oldSmallIcon, smallIcon));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getTemplateURI() {
		return templateURI;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTemplateURI(String newTemplateURI) {
		String oldTemplateURI = templateURI;
		templateURI = newTemplateURI;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET,
					DynamictypePackage.DYNAMIC_PALETTE_ENTRY__TEMPLATE_URI, oldTemplateURI, templateURI));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID)
		{
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY__DESCRIPTION:
			return getDescription();
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY__DIAGRAM_PATH:
			return getDiagramPath();
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY__ID:
			return getId();
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY__KIND:
			return getKind();
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY__LABEL:
			return getLabel();
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY__LARGE_ICON:
			return getLargeIcon();
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY__PATH:
			return getPath();
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY__SMALL_ICON:
			return getSmallIcon();
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY__TEMPLATE_URI:
			return getTemplateURI();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID)
		{
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY__DESCRIPTION:
			setDescription((String) newValue);
			return;
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY__DIAGRAM_PATH:
			setDiagramPath((String) newValue);
			return;
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY__ID:
			setId((String) newValue);
			return;
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY__KIND:
			setKind((String) newValue);
			return;
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY__LABEL:
			setLabel((String) newValue);
			return;
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY__LARGE_ICON:
			setLargeIcon((String) newValue);
			return;
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY__PATH:
			setPath((String) newValue);
			return;
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY__SMALL_ICON:
			setSmallIcon((String) newValue);
			return;
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY__TEMPLATE_URI:
			setTemplateURI((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID)
		{
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY__DESCRIPTION:
			setDescription(DESCRIPTION_EDEFAULT);
			return;
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY__DIAGRAM_PATH:
			setDiagramPath(DIAGRAM_PATH_EDEFAULT);
			return;
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY__ID:
			setId(ID_EDEFAULT);
			return;
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY__KIND:
			setKind(KIND_EDEFAULT);
			return;
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY__LABEL:
			setLabel(LABEL_EDEFAULT);
			return;
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY__LARGE_ICON:
			setLargeIcon(LARGE_ICON_EDEFAULT);
			return;
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY__PATH:
			setPath(PATH_EDEFAULT);
			return;
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY__SMALL_ICON:
			setSmallIcon(SMALL_ICON_EDEFAULT);
			return;
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY__TEMPLATE_URI:
			setTemplateURI(TEMPLATE_URI_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID)
		{
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY__DESCRIPTION:
			return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT
					.equals(description);
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY__DIAGRAM_PATH:
			return DIAGRAM_PATH_EDEFAULT == null ? diagramPath != null : !DIAGRAM_PATH_EDEFAULT
					.equals(diagramPath);
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY__ID:
			return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY__KIND:
			return KIND_EDEFAULT == null ? kind != null : !KIND_EDEFAULT.equals(kind);
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY__LABEL:
			return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY__LARGE_ICON:
			return LARGE_ICON_EDEFAULT == null ? largeIcon != null : !LARGE_ICON_EDEFAULT
					.equals(largeIcon);
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY__PATH:
			return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY__SMALL_ICON:
			return SMALL_ICON_EDEFAULT == null ? smallIcon != null : !SMALL_ICON_EDEFAULT
					.equals(smallIcon);
		case DynamictypePackage.DYNAMIC_PALETTE_ENTRY__TEMPLATE_URI:
			return TEMPLATE_URI_EDEFAULT == null ? templateURI != null : !TEMPLATE_URI_EDEFAULT
					.equals(templateURI);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (description: "); //$NON-NLS-1$
		result.append(description);
		result.append(", diagramPath: "); //$NON-NLS-1$
		result.append(diagramPath);
		result.append(", id: "); //$NON-NLS-1$
		result.append(id);
		result.append(", kind: "); //$NON-NLS-1$
		result.append(kind);
		result.append(", label: "); //$NON-NLS-1$
		result.append(label);
		result.append(", largeIcon: "); //$NON-NLS-1$
		result.append(largeIcon);
		result.append(", path: "); //$NON-NLS-1$
		result.append(path);
		result.append(", smallIcon: "); //$NON-NLS-1$
		result.append(smallIcon);
		result.append(", templateURI: "); //$NON-NLS-1$
		result.append(templateURI);
		result.append(')');
		return result.toString();
	}

} //DynamicPaletteEntryImpl
