/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.notation.impl;

import com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage;
import com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.gmf.runtime.notation.View;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Deploy Style</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ui.notation.impl.DeployStyleImpl#isIsDuplicateCanvasView <em>Is Duplicate Canvas View</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ui.notation.impl.DeployStyleImpl#getProxyHashCode <em>Proxy Hash Code</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ui.notation.impl.DeployStyleImpl#getElementName <em>Element Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ui.notation.impl.DeployStyleImpl#getElementCategory <em>Element Category</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ui.notation.impl.DeployStyleImpl#getImport <em>Import</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ui.notation.impl.DeployStyleImpl#getSnapParent <em>Snap Parent</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ui.notation.impl.DeployStyleImpl#getSnapChildren <em>Snap Children</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ui.notation.impl.DeployStyleImpl#getFilteredSemanticElements <em>Filtered Semantic Elements</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ui.notation.impl.DeployStyleImpl#getFilteredDecorations <em>Filtered Decorations</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ui.notation.impl.DeployStyleImpl#getSnapStyle <em>Snap Style</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ui.notation.impl.DeployStyleImpl#getCollapseWidth <em>Collapse Width</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ui.notation.impl.DeployStyleImpl#getCollapseHeight <em>Collapse Height</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ui.notation.impl.DeployStyleImpl#getExpandWidth <em>Expand Width</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ui.notation.impl.DeployStyleImpl#getExpandHeight <em>Expand Height</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ui.notation.impl.DeployStyleImpl#getContainedObjs <em>Contained Objs</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ui.notation.impl.DeployStyleImpl#getUncontainedObjs <em>Uncontained Objs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DeployStyleImpl extends EObjectImpl implements DeployStyle {
	/**
	 * The default value of the '{@link #isIsDuplicateCanvasView() <em>Is Duplicate Canvas View</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDuplicateCanvasView()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_DUPLICATE_CANVAS_VIEW_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsDuplicateCanvasView() <em>Is Duplicate Canvas View</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDuplicateCanvasView()
	 * @generated
	 * @ordered
	 */
	protected boolean isDuplicateCanvasView = IS_DUPLICATE_CANVAS_VIEW_EDEFAULT;

	/**
	 * The default value of the '{@link #getProxyHashCode() <em>Proxy Hash Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProxyHashCode()
	 * @generated
	 * @ordered
	 */
	protected static final int PROXY_HASH_CODE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getProxyHashCode() <em>Proxy Hash Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProxyHashCode()
	 * @generated
	 * @ordered
	 */
	protected int proxyHashCode = PROXY_HASH_CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getElementName() <em>Element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementName()
	 * @generated
	 * @ordered
	 */
	protected static final String ELEMENT_NAME_EDEFAULT = ""; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getElementName() <em>Element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementName()
	 * @generated
	 * @ordered
	 */
	protected String elementName = ELEMENT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getElementCategory() <em>Element Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementCategory()
	 * @generated
	 * @ordered
	 */
	protected static final String ELEMENT_CATEGORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getElementCategory() <em>Element Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementCategory()
	 * @generated
	 * @ordered
	 */
	protected String elementCategory = ELEMENT_CATEGORY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getImport() <em>Import</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImport()
	 * @generated
	 * @ordered
	 */
	protected EObject import_;

	/**
	 * The cached value of the '{@link #getSnapParent() <em>Snap Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSnapParent()
	 * @generated
	 * @ordered
	 */
	protected View snapParent;

	/**
	 * The cached value of the '{@link #getSnapChildren() <em>Snap Children</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSnapChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<View> snapChildren;

	/**
	 * The cached value of the '{@link #getFilteredSemanticElements() <em>Filtered Semantic Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilteredSemanticElements()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> filteredSemanticElements;

	/**
	 * The cached value of the '{@link #getFilteredDecorations() <em>Filtered Decorations</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilteredDecorations()
	 * @generated
	 * @ordered
	 */
	protected EList<String> filteredDecorations;

	/**
	 * The default value of the '{@link #getSnapStyle() <em>Snap Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSnapStyle()
	 * @generated
	 * @ordered
	 */
	protected static final int SNAP_STYLE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSnapStyle() <em>Snap Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSnapStyle()
	 * @generated
	 * @ordered
	 */
	protected int snapStyle = SNAP_STYLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCollapseWidth() <em>Collapse Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollapseWidth()
	 * @generated
	 * @ordered
	 */
	protected static final int COLLAPSE_WIDTH_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getCollapseWidth() <em>Collapse Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollapseWidth()
	 * @generated
	 * @ordered
	 */
	protected int collapseWidth = COLLAPSE_WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getCollapseHeight() <em>Collapse Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollapseHeight()
	 * @generated
	 * @ordered
	 */
	protected static final int COLLAPSE_HEIGHT_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getCollapseHeight() <em>Collapse Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollapseHeight()
	 * @generated
	 * @ordered
	 */
	protected int collapseHeight = COLLAPSE_HEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getExpandWidth() <em>Expand Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpandWidth()
	 * @generated
	 * @ordered
	 */
	protected static final int EXPAND_WIDTH_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getExpandWidth() <em>Expand Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpandWidth()
	 * @generated
	 * @ordered
	 */
	protected int expandWidth = EXPAND_WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getExpandHeight() <em>Expand Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpandHeight()
	 * @generated
	 * @ordered
	 */
	protected static final int EXPAND_HEIGHT_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getExpandHeight() <em>Expand Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpandHeight()
	 * @generated
	 * @ordered
	 */
	protected int expandHeight = EXPAND_HEIGHT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getContainedObjs() <em>Contained Objs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainedObjs()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> containedObjs;

	/**
	 * The cached value of the '{@link #getUncontainedObjs() <em>Uncontained Objs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUncontainedObjs()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> uncontainedObjs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeployStyleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DeployNotationPackage.Literals.DEPLOY_STYLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsDuplicateCanvasView() {
		return isDuplicateCanvasView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsDuplicateCanvasView(boolean newIsDuplicateCanvasView) {
		boolean oldIsDuplicateCanvasView = isDuplicateCanvasView;
		isDuplicateCanvasView = newIsDuplicateCanvasView;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeployNotationPackage.DEPLOY_STYLE__IS_DUPLICATE_CANVAS_VIEW, oldIsDuplicateCanvasView, isDuplicateCanvasView));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getProxyHashCode() {
		return proxyHashCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProxyHashCode(int newProxyHashCode) {
		int oldProxyHashCode = proxyHashCode;
		proxyHashCode = newProxyHashCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeployNotationPackage.DEPLOY_STYLE__PROXY_HASH_CODE, oldProxyHashCode, proxyHashCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getElementName() {
		return elementName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementName(String newElementName) {
		String oldElementName = elementName;
		elementName = newElementName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeployNotationPackage.DEPLOY_STYLE__ELEMENT_NAME, oldElementName, elementName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getElementCategory() {
		return elementCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementCategory(String newElementCategory) {
		String oldElementCategory = elementCategory;
		elementCategory = newElementCategory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeployNotationPackage.DEPLOY_STYLE__ELEMENT_CATEGORY, oldElementCategory, elementCategory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetImport() {
		return import_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getImport() {
		if (import_ != null && import_.eIsProxy()) {
			InternalEObject oldImport = (InternalEObject)import_;
			import_ = eResolveProxy(oldImport);
			if (import_ != oldImport) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DeployNotationPackage.DEPLOY_STYLE__IMPORT, oldImport, import_));
			}
		}
		return import_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImport(EObject newImport) {
		EObject oldImport = import_;
		import_ = newImport;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeployNotationPackage.DEPLOY_STYLE__IMPORT, oldImport, import_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public View getSnapParent() {
		if (snapParent != null && snapParent.eIsProxy()) {
			InternalEObject oldSnapParent = (InternalEObject)snapParent;
			snapParent = (View)eResolveProxy(oldSnapParent);
			if (snapParent != oldSnapParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DeployNotationPackage.DEPLOY_STYLE__SNAP_PARENT, oldSnapParent, snapParent));
			}
		}
		return snapParent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public View basicGetSnapParent() {
		return snapParent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSnapParent(View newSnapParent) {
		View oldSnapParent = snapParent;
		snapParent = newSnapParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeployNotationPackage.DEPLOY_STYLE__SNAP_PARENT, oldSnapParent, snapParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<View> getSnapChildren() {
		if (snapChildren == null) {
			snapChildren = new EObjectResolvingEList<View>(View.class, this, DeployNotationPackage.DEPLOY_STYLE__SNAP_CHILDREN);
		}
		return snapChildren;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getFilteredSemanticElements() {
		if (filteredSemanticElements == null) {
			filteredSemanticElements = new EObjectResolvingEList<EObject>(EObject.class, this, DeployNotationPackage.DEPLOY_STYLE__FILTERED_SEMANTIC_ELEMENTS);
		}
		return filteredSemanticElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getFilteredDecorations() {
		if (filteredDecorations == null) {
			filteredDecorations = new EDataTypeUniqueEList<String>(String.class, this, DeployNotationPackage.DEPLOY_STYLE__FILTERED_DECORATIONS);
		}
		return filteredDecorations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getSnapStyle() {
		return snapStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSnapStyle(int newSnapStyle) {
		int oldSnapStyle = snapStyle;
		snapStyle = newSnapStyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeployNotationPackage.DEPLOY_STYLE__SNAP_STYLE, oldSnapStyle, snapStyle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCollapseWidth() {
		return collapseWidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCollapseWidth(int newCollapseWidth) {
		int oldCollapseWidth = collapseWidth;
		collapseWidth = newCollapseWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeployNotationPackage.DEPLOY_STYLE__COLLAPSE_WIDTH, oldCollapseWidth, collapseWidth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCollapseHeight() {
		return collapseHeight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCollapseHeight(int newCollapseHeight) {
		int oldCollapseHeight = collapseHeight;
		collapseHeight = newCollapseHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeployNotationPackage.DEPLOY_STYLE__COLLAPSE_HEIGHT, oldCollapseHeight, collapseHeight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getExpandWidth() {
		return expandWidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpandWidth(int newExpandWidth) {
		int oldExpandWidth = expandWidth;
		expandWidth = newExpandWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeployNotationPackage.DEPLOY_STYLE__EXPAND_WIDTH, oldExpandWidth, expandWidth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getExpandHeight() {
		return expandHeight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpandHeight(int newExpandHeight) {
		int oldExpandHeight = expandHeight;
		expandHeight = newExpandHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DeployNotationPackage.DEPLOY_STYLE__EXPAND_HEIGHT, oldExpandHeight, expandHeight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getContainedObjs() {
		if (containedObjs == null) {
			containedObjs = new EObjectResolvingEList<EObject>(EObject.class, this, DeployNotationPackage.DEPLOY_STYLE__CONTAINED_OBJS);
		}
		return containedObjs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getUncontainedObjs() {
		if (uncontainedObjs == null) {
			uncontainedObjs = new EObjectResolvingEList<EObject>(EObject.class, this, DeployNotationPackage.DEPLOY_STYLE__UNCONTAINED_OBJS);
		}
		return uncontainedObjs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DeployNotationPackage.DEPLOY_STYLE__IS_DUPLICATE_CANVAS_VIEW:
				return isIsDuplicateCanvasView() ? Boolean.TRUE : Boolean.FALSE;
			case DeployNotationPackage.DEPLOY_STYLE__PROXY_HASH_CODE:
				return new Integer(getProxyHashCode());
			case DeployNotationPackage.DEPLOY_STYLE__ELEMENT_NAME:
				return getElementName();
			case DeployNotationPackage.DEPLOY_STYLE__ELEMENT_CATEGORY:
				return getElementCategory();
			case DeployNotationPackage.DEPLOY_STYLE__IMPORT:
				if (resolve) return getImport();
				return basicGetImport();
			case DeployNotationPackage.DEPLOY_STYLE__SNAP_PARENT:
				if (resolve) return getSnapParent();
				return basicGetSnapParent();
			case DeployNotationPackage.DEPLOY_STYLE__SNAP_CHILDREN:
				return getSnapChildren();
			case DeployNotationPackage.DEPLOY_STYLE__FILTERED_SEMANTIC_ELEMENTS:
				return getFilteredSemanticElements();
			case DeployNotationPackage.DEPLOY_STYLE__FILTERED_DECORATIONS:
				return getFilteredDecorations();
			case DeployNotationPackage.DEPLOY_STYLE__SNAP_STYLE:
				return new Integer(getSnapStyle());
			case DeployNotationPackage.DEPLOY_STYLE__COLLAPSE_WIDTH:
				return new Integer(getCollapseWidth());
			case DeployNotationPackage.DEPLOY_STYLE__COLLAPSE_HEIGHT:
				return new Integer(getCollapseHeight());
			case DeployNotationPackage.DEPLOY_STYLE__EXPAND_WIDTH:
				return new Integer(getExpandWidth());
			case DeployNotationPackage.DEPLOY_STYLE__EXPAND_HEIGHT:
				return new Integer(getExpandHeight());
			case DeployNotationPackage.DEPLOY_STYLE__CONTAINED_OBJS:
				return getContainedObjs();
			case DeployNotationPackage.DEPLOY_STYLE__UNCONTAINED_OBJS:
				return getUncontainedObjs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DeployNotationPackage.DEPLOY_STYLE__IS_DUPLICATE_CANVAS_VIEW:
				setIsDuplicateCanvasView(((Boolean)newValue).booleanValue());
				return;
			case DeployNotationPackage.DEPLOY_STYLE__PROXY_HASH_CODE:
				setProxyHashCode(((Integer)newValue).intValue());
				return;
			case DeployNotationPackage.DEPLOY_STYLE__ELEMENT_NAME:
				setElementName((String)newValue);
				return;
			case DeployNotationPackage.DEPLOY_STYLE__ELEMENT_CATEGORY:
				setElementCategory((String)newValue);
				return;
			case DeployNotationPackage.DEPLOY_STYLE__IMPORT:
				setImport((EObject)newValue);
				return;
			case DeployNotationPackage.DEPLOY_STYLE__SNAP_PARENT:
				setSnapParent((View)newValue);
				return;
			case DeployNotationPackage.DEPLOY_STYLE__SNAP_CHILDREN:
				getSnapChildren().clear();
				getSnapChildren().addAll((Collection<? extends View>)newValue);
				return;
			case DeployNotationPackage.DEPLOY_STYLE__FILTERED_SEMANTIC_ELEMENTS:
				getFilteredSemanticElements().clear();
				getFilteredSemanticElements().addAll((Collection<? extends EObject>)newValue);
				return;
			case DeployNotationPackage.DEPLOY_STYLE__FILTERED_DECORATIONS:
				getFilteredDecorations().clear();
				getFilteredDecorations().addAll((Collection<? extends String>)newValue);
				return;
			case DeployNotationPackage.DEPLOY_STYLE__SNAP_STYLE:
				setSnapStyle(((Integer)newValue).intValue());
				return;
			case DeployNotationPackage.DEPLOY_STYLE__COLLAPSE_WIDTH:
				setCollapseWidth(((Integer)newValue).intValue());
				return;
			case DeployNotationPackage.DEPLOY_STYLE__COLLAPSE_HEIGHT:
				setCollapseHeight(((Integer)newValue).intValue());
				return;
			case DeployNotationPackage.DEPLOY_STYLE__EXPAND_WIDTH:
				setExpandWidth(((Integer)newValue).intValue());
				return;
			case DeployNotationPackage.DEPLOY_STYLE__EXPAND_HEIGHT:
				setExpandHeight(((Integer)newValue).intValue());
				return;
			case DeployNotationPackage.DEPLOY_STYLE__CONTAINED_OBJS:
				getContainedObjs().clear();
				getContainedObjs().addAll((Collection<? extends EObject>)newValue);
				return;
			case DeployNotationPackage.DEPLOY_STYLE__UNCONTAINED_OBJS:
				getUncontainedObjs().clear();
				getUncontainedObjs().addAll((Collection<? extends EObject>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DeployNotationPackage.DEPLOY_STYLE__IS_DUPLICATE_CANVAS_VIEW:
				setIsDuplicateCanvasView(IS_DUPLICATE_CANVAS_VIEW_EDEFAULT);
				return;
			case DeployNotationPackage.DEPLOY_STYLE__PROXY_HASH_CODE:
				setProxyHashCode(PROXY_HASH_CODE_EDEFAULT);
				return;
			case DeployNotationPackage.DEPLOY_STYLE__ELEMENT_NAME:
				setElementName(ELEMENT_NAME_EDEFAULT);
				return;
			case DeployNotationPackage.DEPLOY_STYLE__ELEMENT_CATEGORY:
				setElementCategory(ELEMENT_CATEGORY_EDEFAULT);
				return;
			case DeployNotationPackage.DEPLOY_STYLE__IMPORT:
				setImport((EObject)null);
				return;
			case DeployNotationPackage.DEPLOY_STYLE__SNAP_PARENT:
				setSnapParent((View)null);
				return;
			case DeployNotationPackage.DEPLOY_STYLE__SNAP_CHILDREN:
				getSnapChildren().clear();
				return;
			case DeployNotationPackage.DEPLOY_STYLE__FILTERED_SEMANTIC_ELEMENTS:
				getFilteredSemanticElements().clear();
				return;
			case DeployNotationPackage.DEPLOY_STYLE__FILTERED_DECORATIONS:
				getFilteredDecorations().clear();
				return;
			case DeployNotationPackage.DEPLOY_STYLE__SNAP_STYLE:
				setSnapStyle(SNAP_STYLE_EDEFAULT);
				return;
			case DeployNotationPackage.DEPLOY_STYLE__COLLAPSE_WIDTH:
				setCollapseWidth(COLLAPSE_WIDTH_EDEFAULT);
				return;
			case DeployNotationPackage.DEPLOY_STYLE__COLLAPSE_HEIGHT:
				setCollapseHeight(COLLAPSE_HEIGHT_EDEFAULT);
				return;
			case DeployNotationPackage.DEPLOY_STYLE__EXPAND_WIDTH:
				setExpandWidth(EXPAND_WIDTH_EDEFAULT);
				return;
			case DeployNotationPackage.DEPLOY_STYLE__EXPAND_HEIGHT:
				setExpandHeight(EXPAND_HEIGHT_EDEFAULT);
				return;
			case DeployNotationPackage.DEPLOY_STYLE__CONTAINED_OBJS:
				getContainedObjs().clear();
				return;
			case DeployNotationPackage.DEPLOY_STYLE__UNCONTAINED_OBJS:
				getUncontainedObjs().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DeployNotationPackage.DEPLOY_STYLE__IS_DUPLICATE_CANVAS_VIEW:
				return isDuplicateCanvasView != IS_DUPLICATE_CANVAS_VIEW_EDEFAULT;
			case DeployNotationPackage.DEPLOY_STYLE__PROXY_HASH_CODE:
				return proxyHashCode != PROXY_HASH_CODE_EDEFAULT;
			case DeployNotationPackage.DEPLOY_STYLE__ELEMENT_NAME:
				return ELEMENT_NAME_EDEFAULT == null ? elementName != null : !ELEMENT_NAME_EDEFAULT.equals(elementName);
			case DeployNotationPackage.DEPLOY_STYLE__ELEMENT_CATEGORY:
				return ELEMENT_CATEGORY_EDEFAULT == null ? elementCategory != null : !ELEMENT_CATEGORY_EDEFAULT.equals(elementCategory);
			case DeployNotationPackage.DEPLOY_STYLE__IMPORT:
				return import_ != null;
			case DeployNotationPackage.DEPLOY_STYLE__SNAP_PARENT:
				return snapParent != null;
			case DeployNotationPackage.DEPLOY_STYLE__SNAP_CHILDREN:
				return snapChildren != null && !snapChildren.isEmpty();
			case DeployNotationPackage.DEPLOY_STYLE__FILTERED_SEMANTIC_ELEMENTS:
				return filteredSemanticElements != null && !filteredSemanticElements.isEmpty();
			case DeployNotationPackage.DEPLOY_STYLE__FILTERED_DECORATIONS:
				return filteredDecorations != null && !filteredDecorations.isEmpty();
			case DeployNotationPackage.DEPLOY_STYLE__SNAP_STYLE:
				return snapStyle != SNAP_STYLE_EDEFAULT;
			case DeployNotationPackage.DEPLOY_STYLE__COLLAPSE_WIDTH:
				return collapseWidth != COLLAPSE_WIDTH_EDEFAULT;
			case DeployNotationPackage.DEPLOY_STYLE__COLLAPSE_HEIGHT:
				return collapseHeight != COLLAPSE_HEIGHT_EDEFAULT;
			case DeployNotationPackage.DEPLOY_STYLE__EXPAND_WIDTH:
				return expandWidth != EXPAND_WIDTH_EDEFAULT;
			case DeployNotationPackage.DEPLOY_STYLE__EXPAND_HEIGHT:
				return expandHeight != EXPAND_HEIGHT_EDEFAULT;
			case DeployNotationPackage.DEPLOY_STYLE__CONTAINED_OBJS:
				return containedObjs != null && !containedObjs.isEmpty();
			case DeployNotationPackage.DEPLOY_STYLE__UNCONTAINED_OBJS:
				return uncontainedObjs != null && !uncontainedObjs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isDuplicateCanvasView: "); //$NON-NLS-1$
		result.append(isDuplicateCanvasView);
		result.append(", proxyHashCode: "); //$NON-NLS-1$
		result.append(proxyHashCode);
		result.append(", elementName: "); //$NON-NLS-1$
		result.append(elementName);
		result.append(", elementCategory: "); //$NON-NLS-1$
		result.append(elementCategory);
		result.append(", filteredDecorations: "); //$NON-NLS-1$
		result.append(filteredDecorations);
		result.append(", snapStyle: "); //$NON-NLS-1$
		result.append(snapStyle);
		result.append(", collapseWidth: "); //$NON-NLS-1$
		result.append(collapseWidth);
		result.append(", collapseHeight: "); //$NON-NLS-1$
		result.append(collapseHeight);
		result.append(", expandWidth: "); //$NON-NLS-1$
		result.append(expandWidth);
		result.append(", expandHeight: "); //$NON-NLS-1$
		result.append(expandHeight);
		result.append(')');
		return result.toString();
	}

} //DeployStyleImpl
