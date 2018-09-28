/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.core.ui.notation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Deploy Style</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#isIsDuplicateCanvasView <em>Is Duplicate Canvas View</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getProxyHashCode <em>Proxy Hash Code</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getElementName <em>Element Name</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getElementCategory <em>Element Category</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getImport <em>Import</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getSnapParent <em>Snap Parent</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getSnapChildren <em>Snap Children</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getFilteredSemanticElements <em>Filtered Semantic Elements</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getFilteredDecorations <em>Filtered Decorations</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getSnapStyle <em>Snap Style</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getCollapseWidth <em>Collapse Width</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getCollapseHeight <em>Collapse Height</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getExpandWidth <em>Expand Width</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getExpandHeight <em>Expand Height</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getContainedObjs <em>Contained Objs</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getUncontainedObjs <em>Uncontained Objs</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage#getDeployStyle()
 * @model
 * @generated
 */
public interface DeployStyle extends Style {
	/**
	 * Returns the value of the '<em><b>Is Duplicate Canvas View</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Duplicate Canvas View</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Duplicate Canvas View</em>' attribute.
	 * @see #setIsDuplicateCanvasView(boolean)
	 * @see com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage#getDeployStyle_IsDuplicateCanvasView()
	 * @model default="false"
	 * @generated
	 */
	boolean isIsDuplicateCanvasView();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#isIsDuplicateCanvasView <em>Is Duplicate Canvas View</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Duplicate Canvas View</em>' attribute.
	 * @see #isIsDuplicateCanvasView()
	 * @generated
	 */
	void setIsDuplicateCanvasView(boolean value);

	/**
	 * Returns the value of the '<em><b>Proxy Hash Code</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Proxy Hash Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Proxy Hash Code</em>' attribute.
	 * @see #setProxyHashCode(int)
	 * @see com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage#getDeployStyle_ProxyHashCode()
	 * @model default="0"
	 * @generated
	 */
	int getProxyHashCode();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getProxyHashCode <em>Proxy Hash Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Proxy Hash Code</em>' attribute.
	 * @see #getProxyHashCode()
	 * @generated
	 */
	void setProxyHashCode(int value);

	/**
	 * Returns the value of the '<em><b>Element Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Name</em>' attribute.
	 * @see #setElementName(String)
	 * @see com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage#getDeployStyle_ElementName()
	 * @model default=""
	 * @generated
	 */
	String getElementName();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getElementName <em>Element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Name</em>' attribute.
	 * @see #getElementName()
	 * @generated
	 */
	void setElementName(String value);

	/**
	 * Returns the value of the '<em><b>Element Category</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Category</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Category</em>' attribute.
	 * @see #setElementCategory(String)
	 * @see com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage#getDeployStyle_ElementCategory()
	 * @model
	 * @generated
	 */
	String getElementCategory();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getElementCategory <em>Element Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Category</em>' attribute.
	 * @see #getElementCategory()
	 * @generated
	 */
	void setElementCategory(String value);

	/**
	 * Returns the value of the '<em><b>Import</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Import</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import</em>' reference.
	 * @see #setImport(EObject)
	 * @see com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage#getDeployStyle_Import()
	 * @model
	 * @generated
	 */
	EObject getImport();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getImport <em>Import</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Import</em>' reference.
	 * @see #getImport()
	 * @generated
	 */
	void setImport(EObject value);

	/**
	 * Returns the value of the '<em><b>Snap Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Snap Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Snap Parent</em>' reference.
	 * @see #setSnapParent(View)
	 * @see com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage#getDeployStyle_SnapParent()
	 * @model
	 * @generated
	 */
	View getSnapParent();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getSnapParent <em>Snap Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Snap Parent</em>' reference.
	 * @see #getSnapParent()
	 * @generated
	 */
	void setSnapParent(View value);

	/**
	 * Returns the value of the '<em><b>Snap Children</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.runtime.notation.View}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Snap Children</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Snap Children</em>' reference list.
	 * @see com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage#getDeployStyle_SnapChildren()
	 * @model
	 * @generated
	 */
	EList<View> getSnapChildren();

	/**
	 * Returns the value of the '<em><b>Filtered Semantic Elements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filtered Semantic Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filtered Semantic Elements</em>' reference list.
	 * @see com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage#getDeployStyle_FilteredSemanticElements()
	 * @model
	 * @generated
	 */
	EList<EObject> getFilteredSemanticElements();

	/**
	 * Returns the value of the '<em><b>Filtered Decorations</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filtered Decorations</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filtered Decorations</em>' attribute list.
	 * @see com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage#getDeployStyle_FilteredDecorations()
	 * @model
	 * @generated
	 */
	EList<String> getFilteredDecorations();

	/**
	 * Returns the value of the '<em><b>Snap Style</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Snap Style</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Snap Style</em>' attribute.
	 * @see #setSnapStyle(int)
	 * @see com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage#getDeployStyle_SnapStyle()
	 * @model default="0"
	 * @generated
	 */
	int getSnapStyle();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getSnapStyle <em>Snap Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Snap Style</em>' attribute.
	 * @see #getSnapStyle()
	 * @generated
	 */
	void setSnapStyle(int value);

	/**
	 * Returns the value of the '<em><b>Collapse Width</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collapse Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collapse Width</em>' attribute.
	 * @see #setCollapseWidth(int)
	 * @see com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage#getDeployStyle_CollapseWidth()
	 * @model default="-1"
	 * @generated
	 */
	int getCollapseWidth();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getCollapseWidth <em>Collapse Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collapse Width</em>' attribute.
	 * @see #getCollapseWidth()
	 * @generated
	 */
	void setCollapseWidth(int value);

	/**
	 * Returns the value of the '<em><b>Collapse Height</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collapse Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collapse Height</em>' attribute.
	 * @see #setCollapseHeight(int)
	 * @see com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage#getDeployStyle_CollapseHeight()
	 * @model default="-1"
	 * @generated
	 */
	int getCollapseHeight();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getCollapseHeight <em>Collapse Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collapse Height</em>' attribute.
	 * @see #getCollapseHeight()
	 * @generated
	 */
	void setCollapseHeight(int value);

	/**
	 * Returns the value of the '<em><b>Expand Width</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expand Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expand Width</em>' attribute.
	 * @see #setExpandWidth(int)
	 * @see com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage#getDeployStyle_ExpandWidth()
	 * @model default="-1"
	 * @generated
	 */
	int getExpandWidth();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getExpandWidth <em>Expand Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expand Width</em>' attribute.
	 * @see #getExpandWidth()
	 * @generated
	 */
	void setExpandWidth(int value);

	/**
	 * Returns the value of the '<em><b>Expand Height</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expand Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expand Height</em>' attribute.
	 * @see #setExpandHeight(int)
	 * @see com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage#getDeployStyle_ExpandHeight()
	 * @model default="-1"
	 * @generated
	 */
	int getExpandHeight();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.core.ui.notation.DeployStyle#getExpandHeight <em>Expand Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expand Height</em>' attribute.
	 * @see #getExpandHeight()
	 * @generated
	 */
	void setExpandHeight(int value);

	/**
	 * Returns the value of the '<em><b>Contained Objs</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contained Objs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained Objs</em>' reference list.
	 * @see com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage#getDeployStyle_ContainedObjs()
	 * @model
	 * @generated
	 */
	EList<EObject> getContainedObjs();

	/**
	 * Returns the value of the '<em><b>Uncontained Objs</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uncontained Objs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uncontained Objs</em>' reference list.
	 * @see com.ibm.ccl.soa.deploy.core.ui.notation.DeployNotationPackage#getDeployStyle_UncontainedObjs()
	 * @model
	 * @generated
	 */
	EList<EObject> getUncontainedObjs();

} // DeployStyle
