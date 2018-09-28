/*******************************************************************************
 * Copyright (c) 2003, 2007 IBM Corporation Licensed Material - Property of IBM. All rights reserved.
 *  
 * US Government Users Restricted Rights - Use, duplication or disclosure v1.0 restricted by GSA ADP
 * Schedule Contract with IBM Corp.
 * 
 * Contributors: IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ccl.soa.deploy.dynamictype;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dynamic Palette Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * 				The specification of a dynamic palette entry
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry#getDescription <em>Description</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry#getDiagramPath <em>Diagram Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry#getId <em>Id</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry#getKind <em>Kind</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry#getLabel <em>Label</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry#getLargeIcon <em>Large Icon</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry#getPath <em>Path</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry#getSmallIcon <em>Small Icon</em>}</li>
 *   <li>{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry#getTemplateURI <em>Template URI</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamictypePackage#getDynamicPaletteEntry()
 * @model extendedMetaData="name='DynamicPaletteEntry' kind='empty'"
 * @generated
 */
public interface DynamicPaletteEntry extends EObject {
	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamictypePackage#getDynamicPaletteEntry_Description()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='description'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Diagram Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagram Path</em>' attribute.
	 * @see #setDiagramPath(String)
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamictypePackage#getDynamicPaletteEntry_DiagramPath()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='diagramPath'"
	 * @generated
	 */
	String getDiagramPath();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry#getDiagramPath <em>Diagram Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diagram Path</em>' attribute.
	 * @see #getDiagramPath()
	 * @generated
	 */
	void setDiagramPath(String value);

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamictypePackage#getDynamicPaletteEntry_Id()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='id'"
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see #setKind(String)
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamictypePackage#getDynamicPaletteEntry_Kind()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='kind'"
	 * @generated
	 */
	String getKind();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see #getKind()
	 * @generated
	 */
	void setKind(String value);

	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamictypePackage#getDynamicPaletteEntry_Label()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='label'"
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Large Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Large Icon</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Large Icon</em>' attribute.
	 * @see #setLargeIcon(String)
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamictypePackage#getDynamicPaletteEntry_LargeIcon()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='largeIcon'"
	 * @generated
	 */
	String getLargeIcon();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry#getLargeIcon <em>Large Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Large Icon</em>' attribute.
	 * @see #getLargeIcon()
	 * @generated
	 */
	void setLargeIcon(String value);

	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamictypePackage#getDynamicPaletteEntry_Path()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='path'"
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

	/**
	 * Returns the value of the '<em><b>Small Icon</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Small Icon</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Small Icon</em>' attribute.
	 * @see #setSmallIcon(String)
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamictypePackage#getDynamicPaletteEntry_SmallIcon()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='attribute' name='smallIcon'"
	 * @generated
	 */
	String getSmallIcon();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry#getSmallIcon <em>Small Icon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Small Icon</em>' attribute.
	 * @see #getSmallIcon()
	 * @generated
	 */
	void setSmallIcon(String value);

	/**
	 * Returns the value of the '<em><b>Template URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template URI</em>' attribute.
	 * @see #setTemplateURI(String)
	 * @see com.ibm.ccl.soa.deploy.dynamictype.DynamictypePackage#getDynamicPaletteEntry_TemplateURI()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='templateURI'"
	 * @generated
	 */
	String getTemplateURI();

	/**
	 * Sets the value of the '{@link com.ibm.ccl.soa.deploy.dynamictype.DynamicPaletteEntry#getTemplateURI <em>Template URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template URI</em>' attribute.
	 * @see #getTemplateURI()
	 * @generated
	 */
	void setTemplateURI(String value);

} // DynamicPaletteEntry
